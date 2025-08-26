/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Pessoa;
import com.mysql.cj.xdevapi.PreparableStatement;
import conexao.Conexao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorio
 */
public class PessoaDAO {
    private Conexao conexao;
    private Connection conn;

    public PessoaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir (Pessoa pessoa){
        String sql = "INSERT INTO pessoa (nome, sexo, idioma) VALUES (?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            
            stmt.execute();
            
            System.out.println("Pessoa inserida!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir pessoa: " + ex.getMessage());
        }
    }
}
