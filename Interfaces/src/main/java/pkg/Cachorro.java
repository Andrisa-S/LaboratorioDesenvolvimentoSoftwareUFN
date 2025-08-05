/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author laboratorio
 */
public class Cachorro implements Animal{

    @Override
    public void emitirSom() {
        System.out.println("au au au");
    }

    @Override
    public void movimentar() {
        System.out.println("O cachorro esta se movimentando!");
    }
    
}
