package com.filtro.person.application;

import java.util.Date;

import com.filtro.person.domain.service.PersonService;

public class AddSkillPersonUseCase {
    // service
    private final PersonService personService;

    public AddSkillPersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public String execute (Date registerDate, int personId, int skillId) {
        return personService.addSkillToPerson(registerDate, personId, skillId);
    }
}
