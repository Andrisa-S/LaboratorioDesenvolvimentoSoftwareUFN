/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author laboratorio
 */
public class Principal {
    public static void main(String[] args) {
        double a = 7;
        double b = 3;
        
        Implementacao i = new Implementacao();
        System.out.println("Soma de " + a +" e " + b + ": " + i.somar(a, b));
        System.out.println("Subtracao de " + a +" e " + b + ": " + i.subtrair(a, b));
        System.out.println("Multiplicacao de " + a +" e " + b + ": " + i.multiplicar(a, b));
        System.out.println("Divisao de " + a +" e " + b + ": " + i.dividir(a, b));
        System.out.println("Raiz quadrada de " + a  + ": " +  i.raizquadrada(a));
        System.out.println("Elevar potencia de " + a +" para " + b + ":" + i.elevarPotencia(a, b));
        System.out.println("Logaritmo de " + a  + ": " + i.raizquadrada(a));
    }
}
