package com.filtro.person.infrastructure.in;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.filtro.person.application.AddSkillPersonUseCase;
import com.filtro.person.domain.service.PersonService;
import com.filtro.person.infrastructure.out.PersonRepository;
import com.filtro.utils.MyUtils;

public class AddSkillPersonView {
    // get app and scanner
    private final AddSkillPersonUseCase addSkillPersonUseCase;
    private final Scanner scanner;

    public AddSkillPersonView(Scanner scanner) {
        this.scanner = scanner;
        PersonService personService = new PersonRepository();
        this.addSkillPersonUseCase = new AddSkillPersonUseCase(personService);
    }

    public void start() {
        while (true) {
            try {
                // intro message
                System.out.println("AGREGAR HABILIDAD A PERSONA");
                // get data
                Date registerDate = MyUtils.getDateInput("Ingrese la fecha en que hace este registro (yyyy-MM-dd): ", scanner);
                int personId = MyUtils.getIntInput("Ingrese el id de la persona: ", scanner);
                int roleId = MyUtils.getIntInput("Ingrese el id de la habilidad: ", scanner);
                // execute
                String response = addSkillPersonUseCase.execute(registerDate, personId, roleId);
                // display message
                MyUtils.displayMessageAndClearScreen(response, 2);
                // get out
                break;
            } catch (ParseException e) {
                MyUtils.displayMessageAndClearScreen("Ups! parece que ingresaste un mal formato de fecha. Intenta con (yyyy-MM-dd)", 3);
            } catch (InputMismatchException e) {
                scanner.nextLine();
                MyUtils.displayMessageAndClearScreen("Ups! asegurate de ingresar solo datos numéricos.", 2);
            }
        }
    }
}
