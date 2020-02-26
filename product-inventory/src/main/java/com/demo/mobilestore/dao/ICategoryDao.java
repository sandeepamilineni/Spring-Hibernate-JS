package com.demo.mobilestore.dao;

import com.demo.mobilestore.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category,Integer> {

    Category findByCategoryType(String categorytype);
}
