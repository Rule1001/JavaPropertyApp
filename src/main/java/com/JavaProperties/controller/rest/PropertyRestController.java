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




}
