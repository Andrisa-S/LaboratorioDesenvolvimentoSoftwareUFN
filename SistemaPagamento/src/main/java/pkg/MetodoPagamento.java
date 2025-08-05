/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import java.util.Random;

/**
 *
 * @author laboratorio
 */
abstract class MetodoPagamento {
    String nomeMetodo;
    int idPagamento;
    Random gerador = new Random();

    public MetodoPagamento(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
        this.idPagamento = gerador.nextInt();
    }
    
}
