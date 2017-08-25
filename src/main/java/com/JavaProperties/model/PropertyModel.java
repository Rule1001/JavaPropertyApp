package com.JavaProperties.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;


@Entity(name="property")
public class PropertyModel {

    private Long propertyId = null;
    private String propertyName = null;
    private String propertyType = null;
    private int bedrooms;
    private String location = null;
    private String propertyDescription = null;
    private String imageUrl = null;
    private String forSale = null;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name ="property_id")
    public Long getPropertyId() {
        return propertyId;
    }
    public void setPropertyId(Long propertyId){
        this.propertyId=propertyId;
    }

    @Column(name ="property_name")
    @NotEmpty (message = "You must specify a Property_name")
    public String getPropertyName() {
        return propertyName;
    }
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @Column(name ="property_type")
    @NotEmpty (message = "You must specify a Property_type")
    public String getPropertyType() {
        return propertyType;
    }
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Column(name ="bedrooms")
    @Min(value = 1, message = "The bedrooms should be at least 1")
    @Max(value = 10, message = "The bedrooms can not be more than 10")
    public int getBedrooms() {
        return bedrooms;
    }
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    @Column(name ="location")
    @NotEmpty (message = "You must specify a Location")
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name ="property_description")
    @NotEmpty (message = "You must specify a Property_description")
    public String getPropertyDescription() {
        return propertyDescription;
    }
    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    @Column(name ="image_url")
    @NotEmpty (message = "You must add a Url image")
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name ="for_sale")
    @NotEmpty (message = "You must advise if property is for sale")
    public String getForSale() {
        return forSale;
    }
    public void setForSale(String forSale) {
        this.forSale = forSale;
    }
}
