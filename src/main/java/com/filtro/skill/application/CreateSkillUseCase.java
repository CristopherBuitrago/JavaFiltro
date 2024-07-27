package com.filtro.skill.application;

import com.filtro.skill.domain.entity.Skill;
import com.filtro.skill.domain.service.SkillService;

public class CreateSkillUseCase {
    // get service
    private final SkillService skillService;

    public CreateSkillUseCase(SkillService skillService) {
        this.skillService = skillService;
    }

    public String execute (Skill skill) {
        return skillService.createSkill(skill);
    }
}
