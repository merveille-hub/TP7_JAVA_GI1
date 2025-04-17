package com.mervy;
enum Forme{
    ECRIT,
    ORAL
}
public class ExamenRattrapage extends Examen{
    private Forme forme;
    public ExamenRattrapage(double note, String nomProfesseur, String matiere, Forme forme) throws NoteInvalideException{
        super(note, nomProfesseur, matiere);
        this.forme = forme;
    }
    public ExamenRattrapage(Forme forme){
        super();
        this.forme = forme;
    }
    @Override
    public String toString() {
        return "ExamenRattrapage{" +
                "numeroEnregistrement=" + numeroEnregistrement +
                ", note=" + note +
                ", nomProfesseur='" + nomProfesseur + '\'' +
                ", matiere='" + matiere + '\'' +
                ", forme=" + forme +
                '}';
    }
}
