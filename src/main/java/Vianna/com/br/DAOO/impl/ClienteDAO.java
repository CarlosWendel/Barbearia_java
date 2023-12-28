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
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wendel
 */
public class ClienteDAO implements IGenericsDao<Cliente,Integer> {

  

    @Override
    public void inserir(Cliente obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO cliente\n" +
                     "(`nome`,`sexo`,`data_nascimento`,`telefone`,`email`,`rg`,`endereco`,`cep`)\n" +
                    "VALUES\n" +
                    "(?,?,?,?,?,?,?,?);";
        PreparedStatement pst = c.prepareStatement(sql);
   
        pst.setString(1,obj.getNome());
        pst.setString(2,obj.getSexo());
        pst.setString(3, obj.getDataNascimento());
        pst.setString(4,obj.getTelefone());
        pst.setString(5,obj.getEmail());
        pst.setString(6,obj.getRg());
        pst.setString(7,obj.getEndereco());
        pst.setString(8,obj.getCep());
        
         
       
        
        pst.execute();
    }

    @Override
    public void alterar(Cliente obj) throws ClassNotFoundException, SQLException {
    Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE cliente\n" +
                        "SET\n" +
                        "nome = ?,sexo = ?,data_nascimento = ?,telefone = ?,email = ?,rg = ?,endereco = ?,cep =?\n" +
                        "WHERE id = ?;UPDATE servico\n" +
                        "SET\n" +
                        "descricao =?,valor = ?\n" +
                        "WHERE id = ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1,obj.getNome());
        pst.setString(2,obj.getSexo());
        pst.setString(3,obj.getTelefone());
        pst.setString(4,obj.getEmail());
        pst.setString(5,obj.getRg());
        pst.setString(6,obj.getEndereco());
        pst.setString(7,obj.getCep());
        pst.setInt(8,obj.getId());        
    pst.execute();
    }

    @Override
    public void apagar(Integer obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM cliente\n" +
                        "WHERE ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        pst.setInt(1,obj);        
        pst.execute();     
    }
    
    @Override
    public Cliente buscarPorChave(Integer obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT id,nome,sexo,data_nascimento,telefone,email,rg,endereco,cep\n" +
                    "FROM cliente " +
                     "WHERE id = ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        pst.setInt(1,obj);        
        ResultSet rs =pst.executeQuery(); 
        
        Cliente u = null;
        if(rs.next()){
            return u = new Cliente(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),rs.getString(6),rs.getString(7),
                    rs.getString(8),rs.getString(9));
            
        }else{
           return u; 
        }
       }

    @Override
    public ArrayList<Cliente> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT id,nome,sexo,data_nascimento,telefone,email,rg,endereco,cep\n" +
                    "FROM cliente;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        ResultSet rs =pst.executeQuery(); 
        
        ArrayList<Cliente> lista = new ArrayList<>();
        while(rs.next()){
            Cliente u = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
             lista.add(u);
        }
        return lista;    
    }

    @Override
    public Cliente buscarLoginSenha(String nome, String senha) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<Cliente>listarCliente(){
         
        try{
            ArrayList<Cliente>lista= new ArrayList<>();
            
             Connection c = ConnectionFactory.getConnection();
           
        String sql = "SELECT  * FROM cliente ORDER BY nome;" ; 
            PreparedStatement pst = c.prepareStatement(sql);
            
        ResultSet rs= pst.executeQuery();
        
        while(rs.next()){
            
            Cliente u = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
             lista.add(u);
        }
        return lista;
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"listar nome de clientes" + e.getMessage());
            return null;
        }
    } 

    public double quantidadeClientes() throws SQLException {
            Connection c = ConnectionFactory.getConnection();

            String sql = "SELECT COUNT(*) AS quantidade FROM cliente;" ;                
               



            PreparedStatement pst = c.prepareStatement(sql);
        
                ResultSet rs =pst.executeQuery(); 

                rs.next();
                return rs.getDouble(1);
    }    
    
}

