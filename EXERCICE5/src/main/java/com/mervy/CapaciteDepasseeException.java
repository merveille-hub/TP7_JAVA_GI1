package com.mervy;

public class CapaciteDepasseeException extends Exception {
    public CapaciteDepasseeException() {
        System.out.println("La capacite de l'ensemble est dépassée !");
    }
    public CapaciteDepasseeException(String message) {
        super(message);
    }
    public CapaciteDepasseeException(int capacite) {
        System.out.println("La capacite de l'ensemble est dépassée !");
        System.out.println("Capacite de l'ensemble : " + capacite);
    }
}
