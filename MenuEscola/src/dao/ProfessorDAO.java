/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Professor;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void inserir (Professor professor){
        String sql = "INSERT INTO professor (nome, idade, disciplina) VALUES (?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getDisciplina());
            
            stmt.execute();
            
            System.out.println("Professor inserido!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir professor: " + ex.getMessage());
        }
    }
    
    public Professor getProfessor (int id){
        String sql = "SELECT * FROM professor WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Professor po = new Professor();
            
            rs.first();
            po.setId(id);
            po.setNome(rs.getString("nome"));
            po.setIdade(rs.getInt("idade"));
            po.setDisciplina(rs.getString("disciplina"));
            return po;
        } catch (SQLException ex){
            System.out.println("Erro ao consultar professor: " + ex.getMessage());
            return null;
        }
    }
    
    public void editar(Professor professor){
        try{
            String sql = "UPDATEprofessor set nome = ?, idade = ?, disciplina = ? WHERE id =?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4, professor.getId());
            stmt.execute();
        } catch (SQLException ex){
            System.out.println("Erro ao atualizar professor: " + ex.getMessage());
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
    
    public List<Professor> getProfessores(){
        
        String sql = "SELECT * FROM professor";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery();
            List<Professor> listaProfessores = new ArrayList();
            
            while (rs.next()){
                Professor p = new Professor();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setDisciplina(rs.getString("disciplina"));
                listaProfessores.add(p);
            }
            return listaProfessores;
        } catch (SQLException ex){
            System.out.println("Erro ao consultar todos os professores: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Professor> getProfessoresNome (String nome){
        String sql = "SELECT * FROM professor WHERE nome LIKE ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            List<Professor> listaProfessores = new ArrayList();
            
            while (rs.next()){
                Professor p = new Professor();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setDisciplina(rs.getString("disciplina"));
                listaProfessores.add(p);
            }
            return listaProfessores;
        } catch (SQLException ex){
            System.out.println("Erro ao consultar todos os professores: " + ex.getMessage());
            return null;
        }
    }
}
