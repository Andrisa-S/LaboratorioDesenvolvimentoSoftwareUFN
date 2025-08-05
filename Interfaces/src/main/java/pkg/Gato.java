/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author laboratorio
 */
public class Gato implements Animal {

    @Override
    public void emitirSom() {
        System.out.println("Miau");
    }

    @Override
    public void movimentar() {
        System.out.println("O gato esta se movimentando!");
    }
    
}
