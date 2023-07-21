package com.codingdojo.dielleza.devondeck.repositories;

import com.codingdojo.dielleza.devondeck.models.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long>{


    Optional<Developer> findByEmail(String email);

}