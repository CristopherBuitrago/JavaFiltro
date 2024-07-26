package com.filtro.person.domain.service;

import java.util.Date;
import java.util.List;

import com.filtro.person.domain.enitty.Person;

public interface PersonService {
    String createPerson (Person person);
    String deletePerson (int personId);
    String addSkillToPerson (Date registerDate, int personId, int skillId);
    String updatePerson (Person person);
    List<Person> getPersonsBySkill(String skillName); 
}