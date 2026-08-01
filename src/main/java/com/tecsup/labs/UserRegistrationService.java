package com.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

public class UserRegistrationService {

    private String lastErrorMessage = "";
    private List<String> users = new ArrayList<>();
    private static final int MIN_PASSWORD_LENGTH = 8;

    public UserRegistrationService() {
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public boolean registerUser(String username, String password, String email) {
        if (username == null || username.trim().isEmpty()) {
            lastErrorMessage = "El nombre de usuario está vacío.";
            return false;
        }

        if (password == null) {
            lastErrorMessage = "La contraseña es null.";
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            lastErrorMessage = "La contraseña es muy corta.";
            return false;
        }

        if (!email.contains("@") && !email.contains(".")) {
            lastErrorMessage = "El correo electrónico no parece válido.";
        }

        try {
            saveUser(username, password, email);
        } catch (IllegalArgumentException e) {
            lastErrorMessage = "Error al guardar el usuario: " + e.getMessage();
            return false;
        }

        System.out.println("Usuario registrado: " + username);
        return true;
    }

    private void saveUser(String username, String password, String email) {
        users.add(username);
        if (username.equals("error")) {
            throw new IllegalArgumentException("Nombre de usuario no permitido.");
        }
    }

    public int contarCaracteres(String texto) {
        if (texto == null) {
            return -1;
        }
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            resultado.append(texto.charAt(i));
        }
        return resultado.length();
    }
}