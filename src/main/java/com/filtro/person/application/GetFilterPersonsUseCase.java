package com.filtro.person.application;

import java.util.List;

import com.filtro.person.domain.enitty.Person;
import com.filtro.person.domain.service.PersonService;

public class GetFilterPersonsUseCase {
    // service
    private final PersonService personService;

    public GetFilterPersonsUseCase(PersonService personService) {
        this.personService = personService;
    }

    public List<Person> execute (String skillName) {
        return personService.getPersonsBySkill(skillName);
    }
}
