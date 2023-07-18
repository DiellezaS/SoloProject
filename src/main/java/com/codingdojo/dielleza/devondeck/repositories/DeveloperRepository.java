package com.codingdojo.dielleza.devondeck.repositories;

import com.codingdojo.dielleza.devondeck.models.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long>{

    Developer findByEmail(String email);

}