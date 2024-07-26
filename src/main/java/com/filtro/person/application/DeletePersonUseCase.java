package com.filtro.person.application;

import com.filtro.person.domain.service.PersonService;

public class DeletePersonUseCase {
    // service
    private final PersonService personService;

    public DeletePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public String execute (int personId) {
        return personService.deletePerson(personId);
    }
}
