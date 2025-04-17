package com.mervy;

import java.util.ArrayList;
import java.util.Collections;

public class GestionExamen {
    private ArrayList<Examen> examens;
    public GestionExamen() {
        examens = new ArrayList<>();
    }

    public void add(Examen examen) {
        if(examens.contains(examen)){
           return;
        }
        examens.add(examen);
    }
    public void addExamFinal(ExamenFinal examen) {
        if(examens.contains(examen)){
            return;
        }
        examens.add(examen);
    }
    public void addExamRattr(ExamenRattrapage examen) {
        if(examens.contains(examen)){
            return;
        }
        examens.add(examen);
    }

    public void removeExam(Examen examen) {
        examens.remove(examen);
    }

    public void removeExam(int numeroEnregistrement) {
        int position = searchPosition(numeroEnregistrement);
        if(numeroEnregistrement < 0) {
            throw new IllegalArgumentException("Le numéro d'enregistrement " +
                    "ne peut pas être négatif");
        }
        if(position != -1) {
            examens.remove(position);
            System.out.println("Examen " + numeroEnregistrement +
                    " supprimé avec succès");
        }
        else {
            System.out.println("L'examen avec le numéro " +
                    numeroEnregistrement + " n'existe pas");
        }
    }

    public int searchPosition(int numeroEnregistrement) {
        for(int i = 0; i < examens.size(); i++) {
            if(examens.get(i).getNumeroEnregistrement() == numeroEnregistrement) {
                return i;
            }
        }
        return -1;
    }

    public void printExamens() {
        System.out.println("************************LISTE DES EXAMENS***********************");
        printExamenFinaux();
        printExamenRattr();
    }

    public void printExamenFinaux() {
        System.out.println("***************EXAMENS FINAUX*****************");
        for(Examen examen : examens) {
            if (examen instanceof ExamenFinal) {
                System.out.println(examen);
            }
        }
    }

    public void printExamenRattr() {
        System.out.println("******************EXAMENS RATTRAPAGES**************");
        for(Examen examen : examens) {
            if (examen instanceof ExamenRattrapage) {
                System.out.println(examen);
            }
        }
    }

    public void comparerExamFinauxParAnnee(){
        ArrayList<ExamenFinal> examensFinaux = getExamFinaux();
        Collections.sort(examensFinaux);
        ExamenFinal.printExamenFinal(examensFinaux);
    }


    public ArrayList<ExamenFinal> getExamFinaux(){
        ArrayList<ExamenFinal> examensFinaux = new ArrayList<>();
        for(Examen examen : examens) {
            if (examen instanceof ExamenFinal) {
                examensFinaux.add((ExamenFinal) examen);
            }
        }
        return examensFinaux;
    }

    public ArrayList<Examen> getExamens() {
        return examens;
    }
    public void setExamens(ArrayList<Examen> examens) {
        this.examens = examens;
    }
}
