package com.mervy;

public abstract class Examen {
    protected int numeroEnregistrement;
    protected double note;
    protected String nomProfesseur;
    protected String matiere;

    private static int count = 0;

    public Examen(double note, String nomProfesseur, String matiere)
            throws NoteInvalideException{
        if (note < 0 || note > 20) {
            throw new NoteInvalideException();
        }
        this.note = note;
        this.nomProfesseur = nomProfesseur;
        this.matiere = matiere;
        this.numeroEnregistrement = ++count;
    }

    public Examen() {
        this.numeroEnregistrement = ++count;
        this.note = 0.0;
        this.nomProfesseur = "";
        this.matiere = "";
    }
    public int getNumeroEnregistrement() {
        return numeroEnregistrement;
    }
    public void setNumeroEnregistrement(int numeroEnregistrement) {
        this.numeroEnregistrement = numeroEnregistrement;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "numeroEnregistrement=" + numeroEnregistrement +
                ", note=" + note +
                ", nomProfesseur='" + nomProfesseur + '\'' +
                ", matiere='" + matiere + '\'' +
                '}';
    }
}
