/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author laboratorio
 */
public class PIXPagamento extends MetodoPagamento{
    
    public PIXPagamento(String nomeMetodo) {
        super(nomeMetodo);
    }
    
    public void processaPagamento(double valor){
        System.out.println("Pagamento de " + valor);
    }
    
    public void mostraDetalhesPagamento(){
        System.out.println("Metodo de pagamento: " + nomeMetodo);
        System.out.println("idPagamento: " + idPagamento);
    }
}
