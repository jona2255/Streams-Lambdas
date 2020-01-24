package com.company;

import org.w3c.dom.ls.LSOutput;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws MalformedURLException {
	// write your code here
        Scanner scanner =  new Scanner(System.in);

        XMLtoObject xmLtoObject = new XMLtoObject();

        ArrayList<Film> list = xmLtoObject.read();

        System.out.println("1. Per quin camp volem buscar, títol, director, any, etc. \n" +
                "2. Que doni la opció de saber quantes pel·lícules d’un determinat director hi apareixen\n" +
                "3. Quants títols una determinada paraula hi apareix. \n" +
                "4. Quantes vegades un director i un intèrpret coincideixen\n" +
                "5. Pel·lícules on hi apareguin el intèrprets que selecciones\n" +
                "6. Cercar quants tipus diferents d’idiomes hi ha\n" +
                "7. Ordenar Pelicules per Títol\n" +
                "8. Salir\n");

        int opcion = scanner.nextInt();

        scanner.nextLine();

        switch (opcion){
            case 1:
                System.out.println("1.Títol, 2. Any, 3. Original, 4. Direccio");
                int nodo = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Texto");

                String op1 = scanner.nextLine();

                list.stream()
                        //(nodo == 1) ? f.getTitol().contains(op1) : f.getOriginal().contains(op1)
                        .filter(f -> {
                            switch (nodo){
                                case 1:
                                    return f.getTitol().contains(op1);
                                case 2:
                                    return f.getAny().contains(op1);

                                case 3:
                                    return f.getOriginal().contains(op1);

                                case 4:
                                    return f.getDireccio().contains(op1);

                                default:
                                    System.out.println("Te has equivocado al elegir. ADIÓS");                            }
                                    return false;
                        })
                        .forEach(System.out::println);

                return;
            case 2:
                System.out.println("Director");
                String op2 = scanner.nextLine();
                long count1 = list.stream()
                        .filter(f -> f.getDireccio().contains(op2)).count();
                System.out.println(count1);
                return;
            case 3:
                System.out.println("Títol");
                String op3 = scanner.nextLine();
                long count2 = list.stream()
                        .filter(f -> f.getDireccio().contains(op3)).count();
                System.out.println(count2);
                return;
            case 4:
                System.out.println("Director");
                String op41 = scanner.nextLine();
                System.out.println("Interpret");
                String op42 = scanner.nextLine();
                long count3 = list.stream()
                        .filter(f -> f.getDireccio().contains(op41) && f.getInterprets().contains(op42)).count();
                System.out.println(count3);
                return;
            case 5:
                System.out.println("Interprets");
                String op5 = scanner.nextLine();;

                list.stream()
                        .filter(f -> f.getInterprets().contains(op5))
                        .forEach(System.out::println);
                return;
            case 6:
                System.out.println("Idioma\n");
                list.stream()
                        .distinct()
                        .forEach(f -> System.out.println(f.getIdioma()));
                return;
            case 7:
                List<Film> listSorted = list.stream().sorted().collect(Collectors.toList());

                for (Film film : listSorted) {
                    System.out.println(film);
                }
                return;
            case 8:
                System.out.println("Venga, hasta luego");
                return ;
            default:
                    System.out.println("Opción no disponible. Adiós, me he indignado");
        }
    }
}
