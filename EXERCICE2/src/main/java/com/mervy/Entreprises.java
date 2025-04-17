package com.mervy;

import java.util.ArrayList;
import java.util.List;

public class Entreprises {
    private static ArrayList<Entreprise> listEntreprise;
    public void afficherInfosEntreprises() throws NonProfitException,
            SecretMissionException{
        System.out.println("****************************INFORMATIONS ENTREPRISES***********************");
        for (Entreprise entreprise : listEntreprise) {
            entreprise.afficherInfosEntreprise();
        }
        System.out.println("***************************************************************************");
    }
    public static ArrayList<Entreprise> getListEntreprise() {
        return listEntreprise;
    }
    public static void setListEntreprise(ArrayList<Entreprise> listEntreprise) {
        Entreprises.listEntreprise = listEntreprise;
    }
    public Entreprises(){
        listEntreprise = new ArrayList<>();
    }
    public void add(Entreprise ent){
        listEntreprise.add(ent);
    }
}
