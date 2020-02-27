package com.demo.mobilestore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "TYPE")
    private String categoryType;

    @JsonManagedReference
    @ManyToMany(mappedBy = "categories")
    private Set<Mobile> mobiles = new HashSet<>();


    public Category(){}
    public Category(String categoryType){
        this.categoryType= categoryType;
    }

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

    public Set<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(Set<Mobile> mobiles) {
        this.mobiles = mobiles;
    }
}
