package com.mervy;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class OperationPair extends Pair{

    public static <U extends Comparable<U>> U getMax(Pair<U, U> P){
        if (P.getFst().compareTo(P.getSnd()) >= 0)
            return P.getFst();
        else
            return P.getSnd();
    }

    //lexicographical Order
    public static <
            U extends Comparable<U>,
            V extends Comparable<V>>
            Comparator<Pair<U, V>>
            TriListePair(){
        return (P1, P2) -> {
            int cmp = P1.getFst().compareTo(P2.getFst());
            if (cmp == 0)
                return P1.getSnd().compareTo(P2.getSnd());
            else return cmp;
        };
    }

    /*public static <U extends Comparable<U>, V extends Comparable<V>>
    Comparator<Pair<U, V>> createPairComparator() {
        return (p1, p2) -> {
            int firstCompare = p1.getFst().compareTo(p2.getFst());
            if (firstCompare != 0) {
                return firstCompare;
            }
            return p1.getSnd().compareTo(p2.getSnd());
        };
    }*/

    public static <U extends Number, V extends Number> double somme(Pair<U, V> P){
        if (P == null || P.getFst() == null || P.getSnd() == null){
            throw new NullPointerException("La pair ou ses éléments sont nuls !");
        }
        return P.getFst().doubleValue() + P.getSnd().doubleValue();
    }
    /*Prends en paramètre une collection de Pair et retourne un tableau de meme dimension contenant leur sommme respectives
    * @param collection : la collection de paires(non null)
    * @return : un tableau de doubles contenant les sommes de chaque paire
    * @throws IllegalArgumentException : si la collection ou une paire est nulle
    * */
    public static <U extends Number> double[] CollectionToTableauV1
        (Collection<Pair<U, U>> collection){
        if (collection == null)
            throw new IllegalArgumentException("La collection est nulle !");
        double[] tabSomme = new double[collection.size()];
        int index = 0;
        for (Pair<U, U> sum : collection){
            if (sum == null || sum.getFst() == null || sum.getSnd() == null)
                throw new IllegalArgumentException("Une paire est nulle !");
            tabSomme[index++] = OperationPair.somme(sum);
        };
        return tabSomme;
    }
    //tabSomme[index++] = sum.getFst().doubleValue() + sum.getSnd().doubleValue();

    /**
     * une méthode collectionToTableauV2(Collection<Pair<U,V>> liste) similaire
     * à la méthode précédente mais chaque paire de la collection peut avoir des
     * éléments de n’importe quels sous-types de Number.
     */
    public static <U extends Number, V extends Number> double[]
        CollectionToTableauV2(Collection<Pair<U, V>> collection)
    {
        if (collection == null)
            throw new IllegalArgumentException("La collection est nulle !");

        double[] tabSomme = new double[collection.size()];
        int index = 0;
        for (Pair<U, V> sum : collection){
            if (sum == null || sum.getFst() == null || sum.getSnd() == null)
                throw new IllegalArgumentException("Une paire est nulle !");
            tabSomme[index++] = sum.getFst().doubleValue() + sum.getSnd().doubleValue();
        };
        return tabSomme;
    }

}

