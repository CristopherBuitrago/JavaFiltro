package com.filtro.person.application;

import com.filtro.person.domain.enitty.Person;
import com.filtro.person.domain.service.PersonService;

public class UpdatePersonUseCase {
    //service
    private final PersonService personService;

    public UpdatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public String execute (Person person) {
        return personService.updatePerson(person);
    }
}
