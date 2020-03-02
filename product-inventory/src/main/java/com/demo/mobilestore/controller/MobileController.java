package com.demo.mobilestore.controller;

import com.demo.mobilestore.dao.ICategoryDao;
import com.demo.mobilestore.dao.IMobileDao;
import com.demo.mobilestore.model.Category;
import com.demo.mobilestore.model.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class MobileController {

    @Autowired
    IMobileDao iMobileDao;

    @Autowired
    ICategoryDao categoryDao;

    @Value("${welcome.message}")
    private String message;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("mobile", new Mobile());
        model.addAttribute("category", new Category());
   }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        return "mobiles_display";
    }

    @PostMapping(value="/mobile")
    @ResponseBody
    public Mobile addMobile(Mobile mobile){
        Category category = categoryDao.findByCategoryType("5G");
        mobile.addCategory(category);
        return iMobileDao.save(mobile);
    }

    @GetMapping(value="/mobile")
    @ResponseBody
    public Set<Mobile> getMobilesByCategory(){
        Category category = categoryDao.findByCategoryType("5G");
        return category.getMobiles();
    }

    @GetMapping("/categories")
    @ResponseBody
    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        categoryDao.findAll().forEach(category->categories.add(category));
        return categories;
    }

    @PostMapping(value="/category")
    public String addCategory(@ModelAttribute Category category){
        category = categoryDao.save(category);
        return "mobiles_display";
    }

}
