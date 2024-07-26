package com.filtro.person.infrastructure.in;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.filtro.person.application.UpdatePersonUseCase;
import com.filtro.person.domain.enitty.Person;
import com.filtro.person.domain.service.PersonService;
import com.filtro.person.infrastructure.out.PersonRepository;
import com.filtro.utils.MyUtils;

public class UpdatePersonView {
    // get app and scanner
    private final UpdatePersonUseCase updatePersonUseCase;
    private final Scanner scanner;
    private static final int LENGTH = 50;
    private static final int EMAIL_LENGTH = 100;
    private static final int AGE_LENGTH = 2;

    public UpdatePersonView (Scanner scanner) {
        // get scanner
        this.scanner = scanner;
        // get service
        PersonService personService = new PersonRepository();
        // initialize the app
        this.updatePersonUseCase = new UpdatePersonUseCase(personService);
    }

    public void start() {
        while (true) {
            try {
                // intro message
                System.out.println("ACTUALIZANDO PERSONA");

                // get data
                int id = MyUtils.getIntInput("Ingrese el id del individuo: ", scanner);
                String name = MyUtils.getInput("Ingrese el nombre de la persona (Max. 50): ", scanner);
                String lastName = MyUtils.getInput("Ingrese el apellido de la persona (Max. 50): ", scanner);
                String cityName = MyUtils.getInput("Ingrese el nombre de la ciudad (Max. 50): ", scanner);
                String address = MyUtils.getInput("Ingrese la direccion del individuo (Max. 50): ", scanner);
                int age = MyUtils.getIntInput("Ingrese la edad del individuo (Max. 2): ", scanner);
                String email = MyUtils.getInput("Ingrese el email del individuo (Max. 100): ", scanner);
                int genderId = MyUtils.getIntInput("Ingrese el id del genero: ", scanner);

                // verify inputs
                if (!isInputValid(name, lastName, cityName, address, age, email)) {
                    MyUtils.displayMessageAndClearScreen("Ups! parece que algunas de tus respuestas exceden el limite de caracteres. Intenta nuevamente", 3);
                    continue;
                }

                // create person
                Person person = new Person();
                person.setId(id);
                person.setName(name);
                person.setLastName(lastName);
                person.setCityName(cityName);
                person.setAddress(address);
                person.setAge(age);
                person.setEmail(email);
                person.setIdGender(genderId);

                // update and get response
                String response = updatePersonUseCase.execute(person);

                // display response
                MyUtils.displayMessageAndClearScreen(response, 2);

                // get out
                break;
                
            } catch (InputMismatchException e) {
                scanner.nextLine();
                MyUtils.displayMessageAndClearScreen("Ups! ingresa datos numéricos únicamente. Por favor intenta nuevamente.", 2);
            }
        }
    }

    private boolean isInputValid(String name, String lastName, String cityName, String address, int age, String email) {
        return name.length() <= LENGTH &&
               lastName.length() <= LENGTH &&
               cityName.length() <= LENGTH &&
               address.length() <= LENGTH &&
               String.valueOf(age).length() <= AGE_LENGTH &&
               email.length() <= EMAIL_LENGTH;
    }
}
