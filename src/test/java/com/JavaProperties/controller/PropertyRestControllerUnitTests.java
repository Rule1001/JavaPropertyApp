package com.JavaProperties.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.JavaProperties.controller.rest.PropertyRestController;
import com.JavaProperties.model.PropertyModel;
import com.JavaProperties.repository.PropertyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PropertyRestController.class)

public class PropertyRestControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PropertyRepository propertyRepository;

    @Test
    public void showIndividualProperty() throws Exception {
        PropertyModel property = new PropertyModel();
        property.setPropertyId(1L);
        property.setPropertyType("House");
        property.setBedrooms(3);
        property.setLocation("Sale");
        property.setForSale("Yes");
        property.setPropertyDescription("test");
        property.setPropertyName("willows");
        property.setImageUrl("test");


        Mockito.when(propertyRepository.findOne(Mockito.anyLong())).thenReturn(property);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/properties/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{propertyId:1, propertyType:House, numBedrooms:3, location:Sale, forSale:Yes, propertyDescription:test, propertyName:willows, imageUrl:test}";

        System.out.println(result.getResponse().getContentAsString());

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }

    @Test
    public void showAllProperties() throws Exception {

        PropertyModel property1 = new PropertyModel();
        property1.setPropertyId(1L);
        property1.setPropertyType("House");
        property1.setBedrooms(3);
        property1.setLocation("Sale");
        property1.setForSale("Yes");
        property1.setPropertyDescription("test");
        property1.setPropertyName("willows");
        property1.setImageUrl("test");

        PropertyModel property2 = new PropertyModel();
        property2.setPropertyId(1L);
        property2.setPropertyType("cottage");
        property2.setBedrooms(2);
        property2.setLocation("Altrincham");
        property2.setForSale("Yes");
        property2.setPropertyDescription("test");
        property2.setPropertyName("mansion");
        property2.setImageUrl("test");

        List<PropertyModel> property = new ArrayList<PropertyModel>();

        property.add(property1);
        property.add(property2);


        Mockito.when(propertyRepository.findAll()).thenReturn(property);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/properties").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "[{\"propertyId\":1,\"propertyName\":\"willows\",\"propertyType\":\"House\",\"location\":\"Sale\",\"propertyDescription\":\"test\",\"imageUrl\":\"test\",\"forSale\":\"Yes\",\"numBedrooms\":3},{\"propertyId\":1,\"propertyName\":\"mansion\",\"propertyType\":\"cottage\",\"location\":\"Altrincham\",\"propertyDescription\":\"test\",\"imageUrl\":\"test\",\"forSale\":\"Yes\",\"numBedrooms\":2}]";

        System.out.println(result.getResponse().getContentAsString());

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }

    @Test
    public void saveProperty() throws Exception {
        PropertyModel property = new PropertyModel();
        property.setPropertyId(1L);
        property.setPropertyType("House");
        property.setBedrooms(3);
        property.setLocation("Sale");
        property.setForSale("Yes");
        property.setPropertyDescription("test");
        property.setPropertyName("willows");
        property.setImageUrl("test");

        String carJson = new ObjectMapper().writeValueAsString(property);

        Mockito.when(propertyRepository.save(property)).thenReturn(property);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/properties/-1").contentType(MediaType.APPLICATION_JSON).content(carJson);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Mockito.verify(propertyRepository, Mockito.times(1)).save(Mockito.any(PropertyModel.class));
        Assert.assertEquals(202, result.getResponse().getStatus());
    }




}
