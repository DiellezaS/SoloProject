package com.codingdojo.dielleza.devondeck.repositories;

import com.codingdojo.dielleza.devondeck.models.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    Optional<Organization> findByEmail(String email);
}