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
        Cachorro c = new Cachorro();
        c.emitirSom();
        c.movimentar();
        
        System.out.println("");
        
        Gato g = new Gato();
        g.emitirSom();
        g.movimentar();
    }
}
