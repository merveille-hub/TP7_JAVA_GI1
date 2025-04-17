package com.mervy;

import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;


public class ExamenFinal extends Examen implements Comparable<ExamenFinal> {
    private int anneePassage;
    private LocalTime heureExamen;
    public ExamenFinal(int anneePassage, LocalTime heureExamen) {
        super();
        if(anneePassage < 2000 || anneePassage > Year.now().getValue()) {
            System.out.println("L'année considéré sera " + Year.now().getValue() + ".");
            throw new IllegalArgumentException("L'année de passage ne peut pas etre inférieur " +
                    "à 2000 ou superieur à l'année actuelle.");
        }
        else if (heureExamen ==null || heureExamen.isBefore(LocalTime.now())) {

        }
        this.anneePassage = anneePassage;
        this.heureExamen = heureExamen;
    }
    public ExamenFinal(double note, String nomProfesseur, String matiere, int anneePassage,
                       LocalTime heureExamen) throws NoteInvalideException{
        super(note, nomProfesseur, matiere);

        this.anneePassage = anneePassage;
        this.heureExamen = heureExamen;
    }
    public int compareTo(ExamenFinal autreExamenFinal) {
        return Integer.compare(this.anneePassage, autreExamenFinal.getAnneePassage());
    }
    public static void printExamenFinal(ArrayList<ExamenFinal> examens) {
        System.out.println("***************EXAMENS FINAUX*****************");
        for(Examen examen : examens) {
            if (examen instanceof ExamenFinal) {
                System.out.println(examen);
            }
        }
    }


    @Override
    public String toString() {
        return "ExamenFinal{" +
                "numeroEnregistrement=" + numeroEnregistrement +
                ", note=" + note +
                ", nomProfesseur='" + nomProfesseur + '\'' +
                ", matiere='" + matiere + '\'' +
                ",  anneePassage=" + anneePassage +
                ", heureExamen=" + heureExamen +
                '}';
    }

    public int getAnneePassage() {
        return anneePassage;
    }



    /*public int compareTo(ExamenFinal exam1, ExamenFinal exam2) {
        return Integer.compare(exam1.getAnneePassage(), exam2.getAnneePassage());
    }*/
}
