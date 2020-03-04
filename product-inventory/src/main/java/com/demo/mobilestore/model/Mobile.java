package com.demo.mobilestore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.bytebuddy.implementation.MethodAccessorFactory.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.nio.file.AccessMode;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "mobile_category",
            joinColumns = @JoinColumn(name = "mobile_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    public Mobile(){}

    @JsonIgnore
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileId == null) ? 0 : mobileId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		if (mobileId == null) {
			if (other.mobileId != null)
				return false;
		} else if (!mobileId.equals(other.mobileId))
			return false;
		return true;
	}
    
    
}
