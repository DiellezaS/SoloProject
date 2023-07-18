package com.codingdojo.dielleza.devondeck.repositories;

import com.codingdojo.dielleza.devondeck.models.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

    List<Position> findAll();
}