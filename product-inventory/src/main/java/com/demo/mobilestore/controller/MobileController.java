package com.demo.mobilestore.controller;

import com.demo.mobilestore.dao.ICategoryDao;
import com.demo.mobilestore.dao.IMobileDao;
import com.demo.mobilestore.model.Category;
import com.demo.mobilestore.model.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class MobileController {

    @Autowired
    IMobileDao iMobileDao;

    @Autowired
    ICategoryDao categoryDao;

    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "mobiles_display"; //view
    }

    @PostMapping(value="/mobile")
    @ResponseBody
    public Mobile addMobile(){

        Category category = categoryDao.findByCategoryType("5G");
        Mobile mobile = new Mobile();
        mobile.setMobileBrand("REALME");
        mobile.setMobileModel("Model 3");
        mobile.setMobilePrice(21212.55);
        mobile.addCategory(category);
        return iMobileDao.save(mobile);
    }

    @GetMapping(value="/mobile")
    @ResponseBody
    public Set<Mobile> getMobilesByCategory(){
        Category category = categoryDao.findByCategoryType("5G");
        return category.getMobiles();
    }


    @PostMapping(value="/category")
    @ResponseBody
    public Set<Category> addCategory(){
        Set<Category> categories = new HashSet<>();

        categories.add(new Category("5G"));
        categories.add(new Category("BRAND"));
        categories.add(new Category("TRIPLECAM"));

        categoryDao.saveAll(categories);
        return categories;
    }


}
