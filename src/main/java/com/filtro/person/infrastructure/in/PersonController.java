package com.filtro.person.infrastructure.in;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.filtro.utils.MyUtils;

public class PersonController {
    // get views and scanner
    private final AddSkillPersonView addSkillPersonView;
    private final CreatePersonView createPersonView;
    private final DeletePersonView deletePersonView;
    private final GetFilterPersonsView getFilterPersonsView;
    private final UpdatePersonView updatePersonView;
    private final Scanner scanner;

    public PersonController(Scanner scanner) {
        // get scanner
        this.scanner = scanner;
        // initialize the views
        this.addSkillPersonView = new AddSkillPersonView(scanner);
        this.createPersonView = new CreatePersonView(scanner);
        this.deletePersonView = new DeletePersonView(scanner);
        this.getFilterPersonsView = new GetFilterPersonsView(scanner);
        this.updatePersonView = new UpdatePersonView(scanner);
    }

    public void run() {
        while (true) {
            try {
                // show menu and get choise
                int choise = showMenu();

                switch (choise) {
                    case 1:
                        MyUtils.displayMessageAndClearScreen("Cargando...", 1);
                        createPersonView.start();
                        break;
                    case 2:
                        MyUtils.displayMessageAndClearScreen("Cargando...", 1);
                        updatePersonView.start();
                        break;
                    case 3:
                        MyUtils.displayMessageAndClearScreen("Cargando...", 1);
                        getFilterPersonsView.start();
                        break;
                    case 4:
                        MyUtils.displayMessageAndClearScreen("Cargando...", 1);
                        addSkillPersonView.start();
                        break;
                    case 5:
                        MyUtils.displayMessageAndClearScreen("Cargando...", 1);
                        deletePersonView.start();
                        break;
                    case 6:
                        MyUtils.displayMessageAndClearScreen("Saliendo...", 1);
                        return;
                    default:
                        MyUtils.displayMessageAndClearScreen("Ups! Escoje una opcion valida.", 2);
                        break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                MyUtils.displayMessageAndClearScreen("Ups! asegurate de ingresar solo datos numéricos.",2);
            }
        }
    }

    private int showMenu() throws InputMismatchException{
        System.out.println("CONTROL DE PERSONAS");
        System.out.println("1. Crear una persona");
        System.out.println("2. Actualizar persona");
        System.out.println("3. Filtrar personas por habilidad");
        System.out.println("4. Agregar habilidades a una persona");
        System.out.println("5. Eliminar una persona");
        System.out.println("6. Salir");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
}
