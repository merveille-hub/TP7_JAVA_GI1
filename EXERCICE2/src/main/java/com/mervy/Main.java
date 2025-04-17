package com.mervy;

public class Main {
    public static void main(String[] args) throws SecretMissionException, NonProfitException {
        Entreprise ent1 = new Entreprise("Attijariwafa Bank", "Accommpagner ses clients pour les finances", 21317298, 20782);
        Entreprise ent4 = new Entreprise("Royal Air Maroc", "Compagnie aerienne", -1, -1);
        EntrepriseSecrete ent5 = new EntrepriseSecrete("DGED", "Service de renseignement exterieur du Maroc", -1, -1);
        EntrepriseSecrete ent6 = new EntrepriseSecrete("Central Intelligence Agency(CIA)", "Agence de renseignement civil du gouvernement federal des US", 150000, 21575);
        EntrepriseSansProfit ent2 = new EntrepriseSansProfit("Foundation Mohammed V pour la solidarite", "Apporter assistance", 0, -1);
        EntrepriseSansProfit ent3 = new EntrepriseSansProfit("Croix_rouge Marocaine", "Apporter aide", -1, -1);
        Entreprises tabEntreprises = new Entreprises();
        //List<Entreprise> tabEntreprises = new ArrayList<Entreprise>();
        tabEntreprises.add(ent2);
        tabEntreprises.add(ent3);
        tabEntreprises.add(ent1);
        tabEntreprises.add(ent4);
        tabEntreprises.add(ent5);
        tabEntreprises.add(ent6);
        try {
            tabEntreprises.afficherInfosEntreprises();
        }catch (NonProfitException e) {
            throw new NonProfitException();
        }
        catch (SecretMissionException e){
            throw new SecretMissionException();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}