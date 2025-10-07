
package dao;

import beans.Categoria;
import beans.Produto;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
    private Conexao conexao;
    private Connection conn;

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Produto produto){
        String sql = "INSERT INTO produto (nome, preco, quantidade, id_categoria) VALUES (?,?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getId_categoria().getId());
            
            stmt.execute();
            
            System.out.println("Produto inserido!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }
    
    public void editar(Produto produto){
        try{
            String sql = "UPDATE produto set nome=?, preco=?, quantidade=?, id_categoria=? WHERE id=?";
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getId_categoria().getId());
            stmt.setInt(5, produto.getId());
            
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }
    
    public void excluir(int id){
        try{
            String sql = "DELETE FROM produto WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto: " + ex.getMessage());
        }
    }
    
    public Produto getProduto(int id){
        String sql = "SELECT p.*, c.nome as categoria_nome FROM produto p " +
                     "INNER JOIN categoria c ON p.id_categoria = c.id WHERE p.id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Produto p = new Produto();
            if (rs.next()){
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                
                Categoria c = new Categoria();
                c.setId(rs.getInt("id_categoria"));
                c.setNome(rs.getString("categoria_nome"));
                p.setId_categoria(c);
            }
            
            return p;
        } catch (SQLException ex){
            System.out.println("Erro ao consultar produto: " +ex.getMessage());
            return null;
        }
    }
    
    public List<Produto> getProdutoNome(String nome, String cat){
        String sql = "SELECT p.*, c.nome as categoria_nome FROM produto p " +
                     "INNER JOIN categoria c ON p.id_categoria = c.id " +
                     "WHERE p.nome LIKE ? AND c.nome LIKE ?";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, "%"+nome+"%");
            stmt.setString(2, "%"+cat +"%");
            
            ResultSet rs = stmt.executeQuery();
            List<Produto> listaProdutos = new ArrayList();
            
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("categoria_nome"));
                produto.setId_categoria(categoria);
                
                listaProdutos.add(produto);
            }
            
            return listaProdutos;
        }
        catch (SQLException ex) {
            System.out.println("Erro ao listar todos os produtos: " + ex.getMessage());
            return null;
        }
    }
}
