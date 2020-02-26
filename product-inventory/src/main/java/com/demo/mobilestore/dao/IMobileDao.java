package com.demo.mobilestore.dao;

import com.demo.mobilestore.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMobileDao extends JpaRepository<Mobile,Integer> {
    /*@Query("select mobile from Mobile mobile where mobile. = :categoryId")
    List<Mobile> findMobilesByCategory(@Param("categoryId") Integer categoryId);*/


}
