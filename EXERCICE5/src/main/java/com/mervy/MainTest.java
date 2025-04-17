package com.mervy;

public class MainTest {
    public static void main(String[] args) throws CapaciteDepasseeException {
        Ensemble<Integer> setInteger1 = new Ensemble<>(Integer.class, 10);
        System.out.println("***********************AJOUT***********************");
        setInteger1.ajouter(3);
        setInteger1.ajouter(2);
        setInteger1.ajouter(9);
        //setInteger1.ajouter(1);
        System.out.println("setInteger1: " + setInteger1);
        System.out.println("***********************SUPPRESSION***********************");
        setInteger1.retirer(3);
        setInteger1.retirer(3);
        System.out.println("setInteger1: " + setInteger1);


        System.out.println("***********************AJOUT***********************");
        Ensemble<Integer> setInteger2 = new Ensemble<>(Integer.class, 3);
        try {
            setInteger2.ajouter(7);
            setInteger2.ajouter(3);
            setInteger2.ajouter(8);

            setInteger2.ajouter(9);
        }
        catch (CapaciteDepasseeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("setInteger2: " + setInteger2);


        /*System.out.println("******************************UNION************************");
        setInteger1.union(setInteger2);
        System.out.println("setIntegerUnion: " + setInteger1);
*/
        System.out.println("***********************INTERSECTION************************");
        setInteger1.intersection(setInteger2);
        System.out.println("setIntegerIntersection: " + setInteger1);
        //setInteger1.ajouter(i1);
        //setInteger1.ajouter(i2);
        //System.out.println(setInteger1);


        System.out.println("********************COMPARE TO*************************");

        System.out.println("comparaison : " + setInteger1.compare(setInteger2));

        System.out.println("*****************SCINDER*******************");
        System.out.println("setInteger2: " + setInteger2);
        System.out.println("setInteger2Scinder: " + setInteger2.scinder());
        System.out.println("setInteger2: " + setInteger2);
    }
}

/*Boite<String> boite = new Boite<>(String.class, 5);
boite.set(0, "Hello");
System.out.println(boite.get(0)); // affiche "Hello"*/