package com.demo.mobilestore.controller;

import com.demo.mobilestore.dao.ICategoryDao;
import com.demo.mobilestore.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    ICategoryDao categoryDao;

    @GetMapping("/categories")
    @ResponseBody
    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
                categoryDao.findAll().forEach(category->categories.add(category));
        return categories;
    }
}
