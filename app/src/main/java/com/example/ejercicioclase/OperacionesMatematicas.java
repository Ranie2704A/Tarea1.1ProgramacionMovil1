package com.example.ejercicioclase;

public class OperacionesMatematicas {
    private double num1;
    private double num2;

    public OperacionesMatematicas(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double sumar() {
        return num1 + num2;
    }

    public double restar() {
        return num1 - num2;
    }

    public double multiplicar() {
        return num1 * num2;
    }

    public String dividir() {
        if (num2 == 0) {
            return "Error: División entre cero";
        }
        return String.valueOf(num1 / num2);
    }
}
