package com.JavaProperties.repository;

import com.JavaProperties.model.PropertyModel;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyModel, Long> {
}
