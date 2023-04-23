package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerarDatos {

    private static final String[] encabezados = {"id", "name", "last_name", "password", "email", "phone", "address", "city", "state", "zip", "country"};
    private static final String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final String[] dominios = {"example.com", "test.com", "prueba.com"};

    public static void main(String[] args) {
        try {
            File archivo = new File("datos.csv");
            FileWriter writer = new FileWriter(archivo);
            writer.append(String.join(",", encabezados));
            writer.append("\n");
            for (int i = 0; i < 50; i++) {
                String iD = generarIdAleatorio();
                String name = generarNombreAleatorio();
                String lastName = generarApellidoAleatorio();
                String password = generarPasswordAleatoria();
                String email = generarEmailAleatorio();
                String phone = generarTelefonoAleatorio();
                String address = generarDireccionAleatoria();
                String city = generarCiudadAleatoria();
                String state = generarEstadoAleatorio();
                String zip = generarCodigoPostalAleatorio();
                String country = generarPaisAleatorio();
                writer.append(String.join(",", iD, name, lastName, password, email, phone, address, city, state, zip, country));
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generarIdAleatorio() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private static String generarNombreAleatorio() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(alfabeto[random.nextInt(alfabeto.length)]);
        }
        return sb.toString();
    }

    public static String generarApellidoAleatorio() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(alfabeto[random.nextInt(alfabeto.length)]);
        }
        return sb.toString();
    }

    private static String generarPasswordAleatoria() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(alfabeto[random.nextInt(alfabeto.length)]);
        }
        return sb.toString();
    }

    private static String generarEmailAleatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append(generarNombreAleatorio());
        sb.append("@");
        sb.append(dominios[new Random().nextInt(dominios.length)]);
        return sb.toString();
    }

    public static String generarTelefonoAleatorio() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generarDireccionAleatoria() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(alfabeto[random.nextInt(alfabeto.length)]);
        }
        return sb.toString();
    }

    public static String generarCiudadAleatoria() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(alfabeto[random.nextInt(alfabeto.length)]);
        }
        return sb.toString();
    }

    public static String generarEstadoAleatorio() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(alfabeto[random.nextInt(alfabeto.length)]);
        }
        return sb.toString();
    }

    public static String generarCodigoPostalAleatorio() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generarPaisAleatorio() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(alfabeto[random.nextInt(alfabeto.length)]);
        }
        return sb.toString();
    }

}
