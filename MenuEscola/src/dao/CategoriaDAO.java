
package dao;

import beans.Categoria;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public CategoriaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Categoria categoria){
        String sql = "INSERT INTO categoria (nome) VALUES (?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            
            stmt.execute();
            
            System.out.println("Categoria inserida!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir categoria: " + ex.getMessage());
        }
    }
    
    public void editar(Categoria categoria){
        try{
            String sql = "UPDATE categoria set nome=? WHERE id=?";
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar categoria: " + e.getMessage());
        }
    }
    
    public void excluir(int id){
        try{
            String sql = "DELETE FROM categoria WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar categoria: " + ex.getMessage());
        }
    }
    
    public Categoria getCategoria(int id){
        String sql = "SELECT * FROM categoria WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Categoria c = new Categoria();
            rs.first();
            c.setId(id);
            c.setNome(rs.getString("nome"));
            
            return c;
        } catch (SQLException ex){
            System.out.println("Erro ao consultar categoria: " +ex.getMessage());
            return null;
        }
    }
    
    public List<Categoria> listarCategorias(){
        String sql = "SELECT id, nome FROM categoria";
        List<Categoria> categorias = new ArrayList<>();
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro ao listar categorias: " + ex.getMessage());   
        }
        
        return categorias;
    }
}
