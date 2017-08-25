package com.JavaProperties.controller.rest;

import com.JavaProperties.model.PropertyModel;
import com.JavaProperties.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
public class PropertyRestController {

    private final Logger logger = LoggerFactory.getLogger(PropertyRestController.class);

    @Autowired
    protected PropertyRepository propertyRepository;

    //get all properties
    @CrossOrigin("*")
    @RequestMapping(value="/properties", method = RequestMethod.GET)
    public List<PropertyModel> getAllProperties() {

        List<PropertyModel> properties = (List<PropertyModel>)propertyRepository.findAll();

        logger.debug("get all properties {}", properties);

        return properties;

    }

    //get a property
    @CrossOrigin("*")
    @RequestMapping(value="/properties/{propertyId}", method = RequestMethod.GET)
    public PropertyModel getIndividulaProperty(@PathVariable Long propertyId) {

        logger.debug("get individual property STARTED");

        PropertyModel property = propertyRepository.findOne(propertyId);

        if(property == null) {
            logger.warn("property {} does not exist", propertyId);
        }

        logger.debug("get individual property ENDED");

        return property;
    }

    //add a property
    @CrossOrigin("*")
    @RequestMapping(value="/properties/{propertyId}", method = RequestMethod.POST)
    public void saveProperty(@Valid @RequestBody PropertyModel property, HttpServletResponse response ) {

        logger.debug("property add has STARTED");

        propertyRepository.save(property);

        logger.debug("new property succesfully added");

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }

    //delete a property
    @CrossOrigin("*")
    @RequestMapping(value = "/properties/{propertyId}", method = RequestMethod.DELETE)
    public void deleteProperty(@PathVariable Long propertyId, HttpServletResponse response) {

        logger.debug("Fetching & Deleting Property with propertyId {}", propertyId);

        PropertyModel property = propertyRepository.findOne(propertyId);
        if (property == null) {
            logger.debug("Unable to delete. Property with propertyID {} not found", propertyId);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        } else {
            propertyRepository.delete(property);
            logger.debug("property deleted");
            response.setStatus(HttpServletResponse.SC_ACCEPTED);

        }
    }











}
