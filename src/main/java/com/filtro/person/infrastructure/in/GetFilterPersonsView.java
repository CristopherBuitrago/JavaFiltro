package com.filtro.person.infrastructure.in;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.filtro.person.application.GetFilterPersonsUseCase;
import com.filtro.person.domain.enitty.Person;
import com.filtro.person.domain.service.PersonService;
import com.filtro.person.infrastructure.out.PersonRepository;
import com.filtro.utils.MyUtils;

public class GetFilterPersonsView {
    // get app and scanner
    private final GetFilterPersonsUseCase getFilterPersonsUseCase;
    private final Scanner scanner;

    public GetFilterPersonsView(Scanner scanner) {
        this.scanner = scanner;
        PersonService personService = new PersonRepository();
        this.getFilterPersonsUseCase = new GetFilterPersonsUseCase(personService);
    }

    public void start () {
        while (true) {
            try {
                // intro message
                System.out.println("FILTRAR PERSONAS POR HABILIDADES");
                // get data
                String skillName = MyUtils.getInput("Ingrese el nombre de la habilidad (50 max): ", scanner);
                // get persons
                List<Person> persons = getFilterPersonsUseCase.execute(skillName);
                // verify if persons are not null
                if (persons == null) {
                    showPersons(persons);
                } else {
                    MyUtils.displayMessageAndClearScreen("Ups! parece ser que no hay individuos con ese rol. Intenta nuevamente o asegurate de que haya registros", 3);
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showPersons(List<Person> persons) {
        MyUtils.clearScreen();
        String leftAlignFormat = "| %-4d | %-40s | %-35s | %-40s |%n";
        System.out.format("+------+------------------------------------------+-------------------------------------+------------------------------------------+%n");
        System.out.format("| ID   | Individuo                                | Genero                              | Habilidad                                |%n");
        System.out.format("+------+------------------------------------------+-------------------------------------+------------------------------------------+%n");
        for (Person person : persons) {
            System.out.format(leftAlignFormat, person.getId(), person.getName(), person.getGenderName(), person.getSkill());
        }
        System.out.format("+------+------------------------------------------+-------------------------------------+------------------------------------------+%n");
        System.out.format("                                          Presiona cualquier tecla para continuar                                                   %n");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
