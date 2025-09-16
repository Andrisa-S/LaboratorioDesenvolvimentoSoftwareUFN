/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beansEx2.Professor;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author laboratorio
 */
public class ProfessorDAO {
    private Conexao conexao;
    private Connection conn;

    public ProfessorDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public Professor getProfessor (int id){
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Professor po = new Professor();
            
            rs.first();
            po.setId(id);
            po.setNome(rs.getString("nome"));
            po.setIdade(rs.getInt("idade"));
            po.setDisciplina(rs.getString("curso"));
            return po;
        } catch (SQLException ex){
            System.out.println("Erro ao consultar aluno: " + ex.getMessage());
            return null;
        }
    }
    
    public void editar(Professor professor){
        try{
            String sql = "UPDATE aluno set nome = ?, idade = ?, curso = ? WHERE id =?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4, professor.getId());
            stmt.execute();
        } catch (SQLException ex){
            System.out.println("Erro ao atualizar pessoa: " + ex.getMessage());
        }
    }
    
    public void excluir(int id){
        try{
            String sql = "DELETE FROM pessoa WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex){
            System.out.println("Erro ao atualizar professor: " + ex.getMessage());
        }
    }
}
