/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Veiculo;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author laboratorio
 */
public class VeiculoDAO {
    private Conexao conexao;
    private Connection conn;

    public VeiculoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir (Veiculo v){
        String sql = "INSERT INTO veiculo (marca, modelo, ano, placa, cor) VALUES (?,?,?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, v.getMarca());
            stmt.setString(2, v.getModelo());
            stmt.setInt(3, v.getAno());
            stmt.setString(4, v.getPlaca());
            stmt.setString(5, v.getCor());
            
            stmt.execute();
            
            System.out.println("Veículo inserido!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir veículo: " + ex.getMessage());
        }
    }
}
