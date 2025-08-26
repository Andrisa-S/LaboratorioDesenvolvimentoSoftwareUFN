/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import dao.PessoaDAO;

/**
 *
 * @author laboratorio
 */
public class Principal {
    public static void main(String[] args) {
        
        Pessoa p = new Pessoa();
        p.setNome("Andrisa");
        p.setSexo("F");
        p.setIdioma("Português");
        
        PessoaDAO pDAO = new PessoaDAO();
        pDAO.inserir(p);
    }
}
