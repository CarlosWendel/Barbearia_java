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
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wendel
 */
public class ServicoDAO implements IGenericsDao<Servico,Integer> {

    /**
     *
     * @param ser
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public void inserir(Servico obj)throws ClassNotFoundException,SQLException {
        
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO servico\n" +
                        "(`descricao`,`valor`)\n" +
                        "VALUES\n" +
                        "(?,?);";
        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1,obj.getDescricao()); 
        pst.setDouble(2,obj.getValor());
       
        
        pst.execute();
    }


    @Override
    public void alterar(Servico obj) throws ClassNotFoundException, SQLException {
    Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE servico\n" +
                        "SET\n" +
                        "descricao =?,valor = ?\n" +
                        "WHERE id = ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1,obj.getDescricao());
        pst.setDouble(2,obj.getValor());
        pst.setInt(3,obj.getId());        
    pst.execute();
    }

    @Override
    public void apagar(Integer obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM servico\n" +
                        "WHERE ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        pst.setInt(1,obj);        
        pst.execute();      }

    @Override
    public Servico buscarPorChave(Integer obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT id,descricao,valor\n" +
                    "FROM servico " +
                     "WHERE id = ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        pst.setInt(1,obj);        
        ResultSet rs =pst.executeQuery(); 
        
        Servico u = null;
        if(rs.next()){
            return u = new Servico(rs.getInt(1),rs.getString(2),rs.getDouble(3));
            
        }else{
           return u; 
        }
       }

    @Override
    public ArrayList<Servico> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT id,descricao,senha,valor\n" +
                    "FROM usuario ";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        ResultSet rs =pst.executeQuery(); 
        
        ArrayList<Servico> lista = new ArrayList<>();
        while(rs.next()){
            Servico u = new Servico(rs.getInt(1),rs.getString(2),rs.getDouble(3));
             lista.add(u);
        }
        return lista;    
    }

    @Override
    public Servico buscarLoginSenha(String nome, String senha) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Servico> listarServico() {
         try{
            ArrayList<Servico>lista= new ArrayList<>();
            
             Connection c = ConnectionFactory.getConnection();
           
        String sql = "SELECT  * FROM servico ORDER BY descricao;" ; 
            PreparedStatement pst = c.prepareStatement(sql);
            
        ResultSet rs= pst.executeQuery();
        
        while(rs.next()){
            
            Servico u = new Servico(rs.getInt(1),rs.getString(2),Double.parseDouble(rs.getString(3)));
             lista.add(u);
        }
        return lista;
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"listar nome de clientes" + e.getMessage());
            return null;
        }
    }
   
}
