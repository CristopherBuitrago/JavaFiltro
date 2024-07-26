package com.filtro;

import java.util.Scanner;

import com.filtro.person.infrastructure.in.CreatePersonView;
import com.filtro.person.infrastructure.in.PersonController;
import com.filtro.person.infrastructure.in.UpdatePersonView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonController personController = new PersonController(scanner);
        personController.run();
    }
}