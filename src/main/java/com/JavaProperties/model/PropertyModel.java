package com.JavaProperties.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;


@Entity
public class PropertyModel {

    private Long propertyId = null;
    private String propertyName = null;
    private String propertyType = null;
    private int bedrooms;
    private String location = null;
    private String PropertyDescription = null;
    private boolean forSale = false;
    private String imageUrl = null;

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
}
