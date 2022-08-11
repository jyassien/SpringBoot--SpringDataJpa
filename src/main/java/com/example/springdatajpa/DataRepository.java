package com.example.springdatajpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<DataModel, Long>{

    List<DataModel> findByLastName(String lastName);
    DataModel findById(long id);
}

// DataRepository inherits several methods for working with DataModel persistence,
// including methods for saving, deleting, and finding Customer entities.

// Spring Data JPA has the ability to create repository implementations automatically,
// at runtime, from a repository interface. You need not write an implementation of the repository
// interface. Spring Data JPA creates an implementation when you run the application.(Only method signature)