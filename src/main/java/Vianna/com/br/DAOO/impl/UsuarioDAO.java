/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vianna.com.br.DAOO.impl;

import Vianna.com.br.DAO.IGenericsDao;
import Vianna.com.br.Model.Cliente;
import Vianna.com.br.Model.Servico;
import Vianna.com.br.Model.Usuario;
import Vianna.com.br.banco.ConnectionFactory;
import java.awt.RenderingHints.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wendel
 */
public class UsuarioDAO implements IGenericsDao<Usuario,Integer> {

    @Override
    public void inserir(Usuario obj)throws ClassNotFoundException,SQLException {
        
         Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO usuario\n" +
                        "(`nome`,`senha`,`nivel_acesso`,`sexo`,`data_nascimento`,`telefone`,`email`,`rg`)\n" +
                        "VALUES\n" +
                        "(?,?,?,?,?,?,?,?);";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1,obj.getNome());
        pst.setString(2,obj.getSenha());
        pst.setString(3, obj.getNivelAcesso());
        pst.setString(4,obj.getSexo());
        pst.setString(5,obj.getDataNascimento());
        pst.setString(6,obj.getTelefone());
        pst.setString(7,obj.getEmail());
        pst.setString(8,obj.getRg());
        
         
       
        
        pst.execute();
    }

    @Override
    public void alterar(Usuario obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE usuario\n" +
                    "SET\n" +
                    "\n" +
                    "nome =?,\n" +
                    "senha = ?,\n" +
                    "nivel_acesso = ?,\n" +
                    "sexo = ?,\n" +
                    "data_nascimento = ?,\n" +
                    "telefone = ?,\n" +
                    "email = ?,\n" +
                    "rg = ?\n" +
                    "WHERE id =?;\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "";
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1,obj.getNome());
        pst.setString(2,obj.getSenha());
        pst.setString(3, obj.getNivelAcesso());
        pst.setString(4,obj.getSexo());
        pst.setString(5,obj.getDataNascimento());
        pst.setString(6,obj.getTelefone());
        pst.setString(7,obj.getEmail());
        pst.setString(8,obj.getRg());  
        pst.setInt(9,obj.getId());        
    pst.execute();
    }

    @Override
    public void apagar(Integer obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM usuario\n" +
                     "WHERE ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        pst.setInt(1,obj);        
        pst.execute();  
    
    }

    @Override
    public Usuario buscarPorChave(Integer obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT id,nome,senha,nivel_acesso,sexo,data_nascimento,telefone,email,rg\n" +
                    "FROM usuario " +
                     "WHERE id = ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        pst.setInt(1,obj);        
        ResultSet rs =pst.executeQuery(); 
        
        Usuario u = null;
        if(rs.next()){
            return u = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
            rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9 ));
            
        }else{
           return u; 
        }
        
    }

    @Override
    public ArrayList<Usuario> buscarTodos() throws ClassNotFoundException, SQLException {
Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT id,nome,senha,nivel_acesso,sexo,data_nascimento,telefone,email,rg\n" +
                    "FROM usuario ";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        ResultSet rs =pst.executeQuery(); 
        
        ArrayList<Usuario> lista = new ArrayList<>();
        while(rs.next()){
            Usuario u = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
            rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9 ));
             lista.add(u);
        }
        return lista;
    }

    

    @Override
    public Usuario buscarLoginSenha(String nome, String senha ) throws ClassNotFoundException, SQLException {
 Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT id,nome,senha,nivel_acesso,sexo,data_nascimento,telefone,email,rg\n" +
                    "FROM usuario " +
                     "WHERE nome = ? and senha = ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        pst.setString(1,nome);        
        pst.setString(2,senha);        
        
           ResultSet rs =pst.executeQuery(); 
        Usuario u = null;
        if(rs.next()){
            return u = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
            rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9 ));
            
        }else{
           return u; 
        }    
    }

}
