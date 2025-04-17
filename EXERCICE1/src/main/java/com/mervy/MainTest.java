package com.mervy;

//Pour tester les differentes methodes

import java.time.LocalTime;

public class MainTest {
    public static void main(String[] args) {
        GestionExamen gestionExamen = new GestionExamen();

        //Déclaration des examens finaux et de rattrapages
        ExamenFinal e12 = new ExamenFinal(2021, LocalTime.now());
        ExamenFinal e14 = new ExamenFinal(2023, LocalTime.now());
        ExamenFinal e13 = new ExamenFinal(2022, LocalTime.now());
        ExamenFinal e11 = new ExamenFinal(2020, LocalTime.now());


        ExamenRattrapage e21 = new ExamenRattrapage(Forme.ECRIT);
        ExamenRattrapage e22 = new ExamenRattrapage(Forme.ORAL);
        ExamenRattrapage e23 = new ExamenRattrapage(Forme.ECRIT);
        ExamenRattrapage e24 = new ExamenRattrapage(Forme.ORAL);

        //Ajouter les exmanes finaux et de rattrapage a la varaibale de la classe GestionExamen
        gestionExamen.add(e11);
        gestionExamen.add(e12);
        gestionExamen.add(e13);
        gestionExamen.add(e14);
        gestionExamen.add(e21);
        gestionExamen.add(e22);
        gestionExamen.add(e23);
        gestionExamen.add(e24);

        //Affichage des examens selon leur categorie (Fianux ou Rattrapages)
        System.out.println("\nAjout et affichage des examens :");
        gestionExamen.printExamens();

        //supprimer un element de la liste:
        //avec le numero d'enregistrement
        //avec la reference d'un examen specifique
        gestionExamen.removeExam(1);
        gestionExamen.removeExam(e24);
        System.out.println("\n\n***********************SUPPRESSION********************");
        gestionExamen.printExamens();

        //comparer les examens finaux par année de passage en utilisant l'interface Comparable
        System.out.println("\n***************************COMPARAISON*****************************");
        System.out.println("\nComparaison des examens finaux: ");
        gestionExamen.comparerExamFinauxParAnnee();

    }
}