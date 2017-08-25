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
}
