package com.demo.mobilestore.model;

import javax.persistence.*;

@Entity
@Table
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "TYPE")
    private String categoryType;

    @ManyToMany
    private Mobile mobile;

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }


    public Category(){}

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}
