package com.mervy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ensemble<T extends Comparable<T>> {
    //permettant de stocker des
    //éléments sans répétition, tout en respectant les règles suivantes
    private T[] arrayT;
    private int capacite = 10;
    private int nbElt = 0;

    @SuppressWarnings("unchecked")
    public Ensemble(Class<T> arrayT, int capacite) {
        // Proper type-safe creation
        this.arrayT = (T[]) Array.newInstance(arrayT, capacite);
        this.nbElt = 0;
        this.capacite = capacite;
    }

    public Ensemble(Ensemble<T> ensemble) {
        this.arrayT = ensemble.getArrayT();
        this.nbElt = ensemble.nbElt;
    }

    @SuppressWarnings("unchecked")
    public Ensemble(int capacite) {
        this.capacite = capacite;
        //this.setArrayT((T[]) new Object[capacite]);
        this.arrayT = (T[]) new Object[capacite];
    }



    public int getNbElt() {
        return nbElt;
    }

    public void setNbElt(int nbElt) {
        this.nbElt = nbElt;
    }

    public int getCapacite() {
        return capacite;
    }

    public T[] getArrayT() {
        return arrayT;
    }

    public void setArrayT(T[] arrayT) {
        this.arrayT = arrayT;
    }

    public void trierTableau() {
        Arrays.sort(this.arrayT, Comparator.nullsLast(Comparator.naturalOrder()));
    }

    /*public void trierTableau2{
        Collections.sort(this.arrayT, new Ensemble<T>());
        *//*for (int i = 0; i < this.getNbElt()-1; i++) {
            for (int j = i+1; j < this.getNbElt(); j++) {
                if (this.getArrayT()[i] < this.getArrayT()[j]){

                }
            }
        }*//*
    }*/

    public boolean contient(T e) {
        for (int i = 0; i < this.getNbElt(); i++) {
            if (this.getArrayT()[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * retourne -1 si l'element n'existe pas
     */
    public int positionElt(T e) {
        int pos = -1;
        for (int i = 0; i < arrayT.length; i++) {
            if (arrayT[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, T element) {
        this.nbElt = index;
        this.arrayT[nbElt] = element;
    }

    public T get(int nbElt) {
        return this.arrayT[nbElt];
    }

    public T pop(int index) {
        T popElement = this.arrayT[index];
        for (int i = index; i < this.nbElt-1; i++) {
            arrayT[i] = arrayT[i+1];
        }

        this.arrayT[nbElt-1] = null;
        this.nbElt --;
        return popElement;
    }

    public boolean retirer(T e){
        if (e == null) {
            throw new NullPointerException();
        }

        if (!this.contient(e)) {
            System.out.println("L'element n'existe pas !");
            return false;
        }

        int nbElt = positionElt(e);
        return pop(nbElt) != null;
    }

    public boolean ajouter(T e) throws CapaciteDepasseeException, NullPointerException{
        if (e == null) {
            throw new NullPointerException();
        }
        if (capacite <= nbElt){
            throw new CapaciteDepasseeException();
        }
        if (contient(e)) {
            return false;
            //arrayT[nbElt++] = e;
        }

        this.set(nbElt, e);
        this.nbElt ++;
        trierTableau();
        return true;
    }

    /**
     * met a jour le nombre d'elements
     */
    public void mettreAJourElement(){
        int nbElt = 0;
        for (T t : arrayT) {
            if(t != null){
                nbElt++;
            }
        }
        this.setNbElt(nbElt);
    }


    public void union(Ensemble<T> autre) throws CapaciteDepasseeException{
        if (autre == null || autre.getArrayT() == null) {
            throw new NullPointerException();
        }

        if (autre.getNbElt() + this.getNbElt() > this.getCapacite()) {
            throw new CapaciteDepasseeException();
        }

        for (int i = 0; i < autre.getNbElt(); i++) {
            if (autre.getArrayT()[i] != null || !this.contient(autre.getArrayT()[i])) {
                this.ajouter(autre.getArrayT()[i]);
            }
        }
        this.trierTableau();
    }

    public void intersection(Ensemble<T> autre){
        if (autre == null || autre.getArrayT() == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < this.getNbElt(); i++) {
            T elt = this.getArrayT()[i];
            if (!autre.contient(elt)){
                this.retirer(elt);
            }

        }

        this.trierTableau();
    }
    /*public Ensemble(Class<T> arrayT, int capacite) {
        // Proper type-safe creation
        this.arrayT = (T[]) Array.newInstance(arrayT, capacite);
        this.nbElt = 0;
        this.capacite = capacite;
    }*/

    public Ensemble<T> scinder() throws CapaciteDepasseeException{
        int moitie = this.getNbElt()/2;

        Ensemble<T> sousEnsemble = new Ensemble<>(
                (Class<T>) arrayT.getClass().getComponentType(), moitie);

        for (int i = 0; i < moitie; i++) {
            sousEnsemble.ajouter(arrayT[i]);
        }

        for (int i = 0; i < moitie; i++) {
            this.retirer(arrayT[i]);
        }
        return sousEnsemble;
    }

    /*public Ensemble<T> scinder() throws CapaciteDepasseeException {
        int milieu = (this.getNbElt() +1)/2;
        T[] tab =;
        Ensemble<T> autre = new Ensemble(tab, milieu);
        for (int i = milieu; i < this.getNbElt(); i++) {
            autre.ajouter(this.getArrayT()[i]);
            this.getArrayT()[i] = null;
        }
        //this.nbElt = milieu;
        this.mettreAJourElement();
        autre.mettreAJourElement();
        return autre;
    }*/

    @Override
    public String toString() {
        return "Ensemble{" +
                "arrayT=" + Arrays.toString(arrayT) +
                ", capacite=" + capacite +
                '}';
    }

    /**
     * Compare les ensembles sur la base de leur taille.
     * o Retourne une valeur négative si l’ensemble courant est plus petit qu’autre, 0 s'ils
     * sont de même taille, et une valeur positive sinon.
     */
    /*public int compareTo(Ensemble<T> autre){
        return Integer.compare(this.nbElt, autre.nbElt);
        return (this.getCapacite() - autre.getCapacite());

    }*/

    public int compare(Ensemble<T> autre1){
        int nbEltCompare = Integer.compare(this.nbElt, autre1.nbElt);

        if (nbEltCompare != 0)
            return nbEltCompare;
        //si tailles egales
        T[] arrayTCompare1 = this.getArrayT();
        T[] arrayTCompare2 = autre1.getArrayT();
        for (int i = 0; i < this.getNbElt(); i++) {
            int cmp = arrayTCompare1[i].compareTo(arrayTCompare2[i]);
            if (cmp != 0) {
                return cmp;
            }
        }
        return 0;
    }

    /*public int compareTo(Ensemble<T> autre) {
        int fstCmp = Integer.compare(this.getArrayT().length, autre.getArrayT().length);
        //fstCmp = Integer.compare(this.arrayT.length, autre.getArrayT().length);
        if (fstCmp != 0) return fstCmp;

        else{
            //return Integer.compare(this.getArrayT().length, autre.getArrayT().length);
            return this.compareTo(autre);
        }
    }*/
/*@Override
    public int compareTo(Ensemble ensemble) {
        if (ensemble.arrayT.length != this.arrayT.length) {
            return false;
        }
        return this.compareTo((T) ensemble);
    }*/
}
