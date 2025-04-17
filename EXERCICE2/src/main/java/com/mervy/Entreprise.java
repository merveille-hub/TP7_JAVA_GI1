package com.mervy;

public class Entreprise {
    private int nbreEmploye;
    private int capital;
    private String nomEntreprise;
    private String mission;
    public String mission() throws SecretMissionException{
        return mission;
    }
    public int capital() throws NonProfitException{
        return capital;
    }
    public Entreprise(String nomEntreprise, String mission, int capital,
                      int nbreEmploye) {
        this.nomEntreprise = nomEntreprise;
        this.mission = mission;
        this.capital = capital;
        this.nbreEmploye = nbreEmploye;
    }

    public void afficherInfosEntreprise() throws NonProfitException, SecretMissionException{
        if(this instanceof EntrepriseSecrete){
            System.out.println("*******************ENTREPRISE SECRETE********************");
            System.out.println("Nom: " + getNomEntreprise() + ",\n Nbre Employé: " + getNbreEmploye() + ",\n Capital: " + getCapital());
            try {
                System.out.println(this.mission());
            }catch (SecretMissionException e){
                System.out.println("" + new SecretMissionException());
            }
        }
        else if (this instanceof EntrepriseSansProfit){
            System.out.println("*******************ENTREPRISE SANS PROFIT********************");
            System.out.println("Nom: " + nomEntreprise + ",\n Nbre Employé: " + nbreEmploye + ",\n Mission: " + mission);
            try {
                System.out.println(this.capital());
            }catch (NonProfitException e){
                System.out.println("" + new NonProfitException());
            }
        }
        else {
            System.out.println("***********************ENTREPRISE****************************");
            System.out.println("Nom: " + nomEntreprise + ",\n Nbre Employé: " + nbreEmploye + ",\n Mission : " + mission + ",\n Capital : " + capital);
        }
    }
    public int getNbreEmploye() {
        return nbreEmploye;
    }

    public void setNbreEmploye(int nbreEmploye) {
        this.nbreEmploye = nbreEmploye;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }


}
