package com.codingdojo.dielleza.devondeck.repositories;

import java.util.List;

import com.codingdojo.dielleza.devondeck.models.Skill;
import org.springframework.data.repository.CrudRepository;



public interface SkillRepository extends CrudRepository<Skill, Long> {

    List<Skill> findAllByLanguageContaining(boolean b);

    List<Skill>findAll();


}