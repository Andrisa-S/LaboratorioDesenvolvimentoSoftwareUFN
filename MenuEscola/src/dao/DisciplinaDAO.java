
package dao;

import beans.Disciplina;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DisciplinaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public DisciplinaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Disciplina disciplina){
        String sql = "INSERT INTO disciplina (nome, cargaHoraria, id_professor) VALUES (?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getCargaHoraria());
            stmt.setInt(3, disciplina.getProfessorID().getId());
            
            stmt.execute();
            
            System.out.println("Disciplina inserida!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir disciplina: " + ex.getMessage());
        }
    }
    
    public void editar(Disciplina disciplina){
        try{
            String sql = "UPDATE disciplina set nome=?, cargaHoraria=?, id_professor=? WHERE id=?";
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getCargaHoraria());
            stmt.setInt(3, disciplina.getProfessorID().getId());
            stmt.setInt(4, disciplina.getId());
            
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar disciplina: " + e.getMessage());
        }
    }
    
    public void excluir(int id){
        try{
            String sql = "DELETE FROM disciplina WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar disciplina: " + ex.getMessage());
        }
    }
}
