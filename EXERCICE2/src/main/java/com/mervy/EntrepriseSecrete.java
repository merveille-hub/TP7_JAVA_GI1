package com.mervy;

public class EntrepriseSecrete extends Entreprise{
    public EntrepriseSecrete(String nomEntreprise,
                             String mission, int capital, int nbreEmploye) {
        super(nomEntreprise, mission, capital, nbreEmploye);
    }

    public String mission() throws SecretMissionException {
        throw new SecretMissionException();
    }
}
