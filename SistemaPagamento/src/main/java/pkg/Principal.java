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
        CartaoCreditoPagamento c = new CartaoCreditoPagamento("Cartao de Credito");
        c.processaPagamento(150);
        c.mostraDetalhesPagamento();
        
        System.out.println("");
    
        PayPalPagamento pp = new PayPalPagamento("PayPal");
        pp.processaPagamento(300);
        pp.mostraDetalhesPagamento();
        
        System.out.println("");
    
        PIXPagamento pix = new PIXPagamento("PIX");
        pix.processaPagamento(500);
        pix.mostraDetalhesPagamento();
    }
}
