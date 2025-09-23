/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Pessoa;
import beans.Veiculo;
import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "INSERT INTO veiculo (modelo, placa, id_pessoa) VALUES (?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getPlaca());
            stmt.setInt(3, v.getPessoaid().getId());
            
            stmt.execute();
            
            System.out.println("Veículo inserido!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir veículo: " + ex.getMessage());
        }
    }
    
    public void editar (Veiculo v){
        try{
            String sql = "UPDATE veiculo set modelo = ?, placa = ?, id_pessoa = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getPlaca());
            stmt.setInt(3, v.getPessoaid().getId());
            stmt.setInt(4, v.getId());
            stmt.execute();
        } catch (SQLException ex){
            System.out.println("Erro ao atualizar veículo: " + ex.getMessage());
        }
    }
    
    public void excluir (int id){
        try{
            String sql = "delete from veiculo WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex){
            System.out.println("Erro ao excluir veículo: " + ex.getMessage());
        }
    }
    
    public List<Veiculo> getVeiculos(){
        String sql = "SELECT * FROM veiculo";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(); //Retorno da consulta e armazena no ResultSet
            List<Veiculo> listaVeiculos = new ArrayList(); //Prepara uma lista de objetos que vai armazenar a consulta
            //Percorre rs e salva as informações dentro de um objeto Pessoa e depois adiciona na lista
            while(rs.next()){
                Veiculo v = new Veiculo();
                v.setId(rs.getInt("id"));
                v.setModelo(rs.getString("modelo"));
                v.setPlaca(rs.getString("placa"));
                int idPessoa = rs.getInt("id_pessoa");
                PessoaDAO pdao = new PessoaDAO();
                Pessoa p = pdao.getPessoa(idPessoa);
                v.setPessoaid(p);
                listaVeiculos.add(v);
            }
            return listaVeiculos;
        } catch (SQLException ex){
            System.out.println("Erro ao consultar todas as pessoas: " + ex.getMessage());
            return null;
        }
    }
}
