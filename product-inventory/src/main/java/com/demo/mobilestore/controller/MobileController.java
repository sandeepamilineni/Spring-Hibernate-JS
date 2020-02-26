package com.demo.mobilestore.controller;

import com.demo.mobilestore.dao.ICategoryDao;
import com.demo.mobilestore.dao.IMobileDao;
import com.demo.mobilestore.model.Category;
import com.demo.mobilestore.model.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MobileController {

    @Autowired
    IMobileDao iMobileDao;

    @Autowired
    ICategoryDao categoryDao;

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

    @GetMapping(value="/mobile/{categoryId}")
    @ResponseBody
    public List<Mobile> getMobilesByCategory(@PathVariable Integer categoryId){

        return iMobileDao.findMobilesByCategory(categoryId);
    }
}
