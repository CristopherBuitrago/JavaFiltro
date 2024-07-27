package com.filtro.skill.infrastructure.in;

import java.util.Scanner;

import com.filtro.skill.application.CreateSkillUseCase;
import com.filtro.skill.domain.entity.Skill;
import com.filtro.skill.domain.service.SkillService;
import com.filtro.skill.infrastructure.out.SkillRepository;
import com.filtro.utils.MyUtils;

public class CreateSkillView {
    // get app and scanner
    private final CreateSkillUseCase createSkillUseCase;
    private final Scanner scanner;

    // constructor
    public CreateSkillView (Scanner scanner) {
        // get scanner 
        this.scanner = scanner;
        SkillService skillService = new SkillRepository();
        this.createSkillUseCase = new CreateSkillUseCase(skillService);
    }

    // start
    public void start () {
        while (true) {
            try {
                // intro message
                System.out.println("CREANDO UNA NUEVA HABILIDAD");
                // get data
                String name = MyUtils.getInput("Ingrese el nombre de la nueva habilidad (50 max): ", scanner);
                // valid input
                if (name.length() > 50){
                    MyUtils.displayMessageAndClearScreen("Ups! el nombre está muy largo. Intenta nuevamente", 2);
                    continue;
                }
                // create new skill
                Skill skill = new Skill();
                skill.setName(name);
                // create skill
                String response = createSkillUseCase.execute(skill);
                // show message
                MyUtils.displayMessageAndClearScreen(response, 2);
                // get out
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
