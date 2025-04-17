package com.mervy;

import java.util.Arrays;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        //Déclaration des variables
        Pair<Integer, Integer> integerPair = new Pair<>(2, 3);
        Pair<Integer, Double> integerDoublePair = new Pair<>(2, 3.8);
        Pair<String, String> stringPair = new Pair<>("Hello", "Class");

        //get max
        System.out.println("\n*****************************Get Max**************************");
        System.out.println("Le maximum de la paire (" + integerPair.getFst() + ", " + integerPair.getSnd() + ") est : " + OperationPair.getMax(integerPair));
        System.out.println("Le maximum de la paire (" + stringPair.getFst() + ", " + stringPair.getSnd() + ") est : " + OperationPair.getMax(stringPair));

        //Tri Liste Pair
        System.out.println("\n*****************************Tri Liste Pair**************************");
        List<Pair<String, String>> listString = Arrays.asList(
                new Pair<>("Chat", "Cat"),
                new Pair<>("Souris", "Mouse"),
                new Pair<>("Chien", "Dog"),
                new Pair<>("Zèbre", "Zebra"),
                new Pair<>("Livre", "Book")
        );

        System.out.println("\n***Affichage de la liste***");
        for (Pair<String, String> pair : listString) {
            System.out.println(pair);
        }

        System.out.println("\n***Triage de la liste***");
        listString.sort(OperationPair.TriListePair());
        for (Pair<String, String> pair : listString) {
            System.out.println(pair);
        }

        //Somme d'une liste de pair
        List<Pair<Number, Number>> listNumber = Arrays.asList(
                new Pair<>(8, 3),
                new Pair<>(1, 6),
                new Pair<>(9, 1),
                new Pair<>(5.4, 4.9)
        );

        System.out.println("\n***Affichage de la liste1***");
        for (Pair<Number, Number> pair : listNumber) {
            System.out.println(pair);
        }
        double[] tabSomme = new double[listNumber.size()];
        System.out.println("***Somme de la liste1 en utilisant V1 ***");
        tabSomme = OperationPair.CollectionToTableauV1(listNumber);

        for (double sum : tabSomme){
            System.out.println(sum);
        }

        List<Pair<Number, Number>> listNumber2 = Arrays.asList(
                new Pair<>(7, 30.2),
                new Pair<>(6, 4),
                new Pair<>(2, 15),
                new Pair<>(54, 4.9)
        );
        System.out.println("***Affichage de la liste2***");
        for (Pair<Number, Number> pair : listNumber2) {
            System.out.println(pair);
        }

        double[] tabSomme2 = new double[listNumber.size()];
        System.out.println("***Somme de la liste 2 en utilisant V2 ***");
        tabSomme2 = OperationPair.CollectionToTableauV2(listNumber2);

        for (double sum : tabSomme2){
            System.out.println(sum);
        }

    }
}