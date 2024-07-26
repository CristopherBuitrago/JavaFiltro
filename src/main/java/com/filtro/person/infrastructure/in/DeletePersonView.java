package com.filtro.person.infrastructure.in;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.filtro.person.application.DeletePersonUseCase;
import com.filtro.person.domain.service.PersonService;
import com.filtro.person.infrastructure.out.PersonRepository;
import com.filtro.utils.MyUtils;

public class DeletePersonView {
    // get app and scanner 
    private final DeletePersonUseCase deletePersonUseCase;
    private final Scanner scanner;

    public DeletePersonView (Scanner scanner) {
        this.scanner = scanner;
        PersonService personService = new PersonRepository();
        this.deletePersonUseCase = new DeletePersonUseCase(personService);
    }

    public void start () {
        while (true) {
            try {
                // intro message
                System.out.println("ELIMINAR PERSONA");
                // get data
                int personId = MyUtils.getIntInput("Ingrese el id de la persona a eliminar: ", scanner);
                // execute and get response
                String response = deletePersonUseCase.execute(personId);
                // show response
                MyUtils.displayMessageAndClearScreen(response, 2);
                // get out
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                MyUtils.displayMessageAndClearScreen("Ups! asegurate de ingreasr solo datos numéricos.", 2);
            }
        }
    }
}
