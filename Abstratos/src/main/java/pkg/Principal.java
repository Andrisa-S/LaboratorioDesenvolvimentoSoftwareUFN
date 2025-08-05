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
        Quadrado q = new Quadrado();
        q.setDescricao("Quadrado 1 ");
        q.lado = 7;
        System.out.println("Area do " + q.getDescricao() + q.calcularArea());
        
        Triangulo t = new Triangulo();
        t.setDescricao("Triangulo 1 ");
        t.lado = 5;
        System.out.println("Area do " + t.getDescricao() + t.calcularArea());
        
        Retangulo r = new Retangulo();
        r.setDescricao("Retangulo 1 ");
        r.lado1 = 7;
        r.lado2 = 5;
        System.out.println("Area do " + r.getDescricao() + r.calcularArea());
    }
}
