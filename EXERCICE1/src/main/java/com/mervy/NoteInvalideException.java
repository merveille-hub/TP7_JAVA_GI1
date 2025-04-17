package com.mervy;

public class NoteInvalideException extends Exception {
    public NoteInvalideException(String message) {
        super(message);
    }

    public NoteInvalideException() {
        super("La note est invalide !!!");
    }

    public NoteInvalideException(double note) {
        super("La note " + note +
                " est invalide !!!");
    }
}
