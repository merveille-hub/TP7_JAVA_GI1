package com.mervy;

public class EntrepriseSansProfit extends Entreprise{
    public EntrepriseSansProfit(String nomEntreprise, String mission,
                                int capital, int nbreEmploye) {
        super(nomEntreprise, mission, capital, nbreEmploye);
    }

    public int capital() throws NonProfitException{
        throw new NonProfitException();
    }
}
