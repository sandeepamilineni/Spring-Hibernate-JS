package com.demo.mobilestore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Mobile {

    @Id
    @GeneratedValue
    @Column(name = "MOBILE_ID")
    private Integer mobileId;

    @Column(name = "MODEL")
    private String mobileModel;

    @Column(name = "BRAND")
    private String mobileBrand;

    //@Pattern(regexp="[\\d]{6}")
    //@NotEmpty(message = "{mobile.price.notempty}")
    @Column(name = "PRICE")
    private double mobilePrice;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "mobile_category",
            joinColumns = @JoinColumn(name = "mobile_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    
    private List<Category> categories = new ArrayList<>();

    public Mobile(){}

    public List<Category> getCategories() {
        return this.categories;
    }

    public void addCategory(Category category){
         this.categories.add(category);
    }

    public void setCategory(List<Category> categories) {
        this.categories = categories;
    }

    public Integer getMobileId() {
        return mobileId;
    }

    public void setMobileId(Integer mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public String getMobileBrand() {
        return mobileBrand;
    }

    public void setMobileBrand(String mobileBrand) {
        this.mobileBrand = mobileBrand;
    }

    public double getMobilePrice() {
        return mobilePrice;
    }

    public void setMobilePrice(double mobilePrice) {
        this.mobilePrice = mobilePrice;
    }
}
