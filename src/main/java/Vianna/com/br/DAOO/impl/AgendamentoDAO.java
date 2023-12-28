/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vianna.com.br.DAOO.impl;

import Vianna.com.br.DAO.IGenericsDao;
import Vianna.com.br.Model.Agendamento;
import Vianna.com.br.Model.Cliente;
import Vianna.com.br.Model.Servico;
import Vianna.com.br.Model.Usuario;
import Vianna.com.br.banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author wendel
 */
public class AgendamentoDAO implements IGenericsDao<Agendamento,Integer> {

   
    @Override
    public void inserir(Agendamento obj) throws ClassNotFoundException, SQLException {
 Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO agendamento\n" +
                     "(`valor`,`data`,`hora`,`observacao`,`id_servico`,`id_cliente`)\n" +
                     "VALUES\n" +
                     "(?,?,?,?,?,?);";
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setDouble(1,obj.getValor());
        pst.setString(2,obj.getData());
        pst.setString(3, obj.getHora());
        pst.setString(4,obj.getObsrvacao());
        pst.setInt(5, obj.getServico().getId());
        pst.setInt(6,obj.getCliente().getId());
       
        // pst.setString(8,obj.getServicos());
       
        
        
        pst.execute();
    }
        

    @Override
    public void alterar(Agendamento obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE agendamento \n" +
                    " SET \n" +
                    "valor = ?,\n" +
                    "data = ? ,\n" +
                    "hora = ? ,\n" +
                    "observacao = ? ,\n" +
                    "id_servico = ? ,\n" +
                    "id_cliente = ? \n" +
                    "WHERE id = ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setDouble(1,obj.getValor());
        pst.setString(2,obj.getData());
        pst.setString(3, obj.getHora());
        pst.setString(4,obj.getObservacao());
        pst.setInt(5, obj.getServico().getId());
        pst.setInt(6,obj.getCliente().getId());
       
               pst.setInt(7,obj.getId());        

        
        
        pst.executeUpdate();
    }

       @Override
    public void apagar(Integer obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM agendamento\n" +
                        "WHERE id = ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        pst.setInt(1,obj);        
        pst.execute();     
    }
    
    @Override
    public Agendamento buscarPorChave(Integer obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT id,valor,data,hora,observacao,id_servico,\n" +
                    "FROM agendamento;" +
                     "WHERE id = ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        pst.setInt(1,obj);        
        ResultSet rs =pst.executeQuery(); 
        
        Agendamento u = null;
        if(rs.next()){
            return u =new Agendamento(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getString(4),
                    rs.getString(5));
            
        }else{
           return u; 
        }
       }

    @Override
    public ArrayList<Agendamento> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
                String sql = "SELECT id,valor,data,hora,observacao,id_servico,id_cliente\n" +
                    "FROM agendamento";
        PreparedStatement pst = c.prepareStatement(sql);
        
         
        ResultSet rs =pst.executeQuery(); 
        
        ArrayList<Agendamento> lista = new ArrayList<>();
        while(rs.next()){
            Agendamento u = new Agendamento(rs.getInt(1), 
                   new ClienteDAO().buscarPorChave(rs.getInt(7)),
                   new ServicoDAO().buscarPorChave(rs.getInt(6)),
                    rs.getDouble(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
             lista.add(u);
        }
        return lista;    
    }

    @Override
    public Agendamento buscarLoginSenha(String nome, String senha) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Agendamento> buscarPorNome(String nome) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
                String sql = "SELECT * \n" +
                             "FROM agendamento a\n" +                   
                        "JOIN cliente c ON a.id_cliente = c.id\n" +
                        "WHERE c.nome LIKE ?;";
                
               



        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1,"%"+nome+"%");
         
        ResultSet rs =pst.executeQuery(); 
        
        ArrayList<Agendamento> lista = new ArrayList<>();
        while(rs.next()){
            Agendamento u = new Agendamento(rs.getInt(1), 
                   new ClienteDAO().buscarPorChave(rs.getInt(7)),
                   new ServicoDAO().buscarPorChave(rs.getInt(6)),
                    rs.getDouble(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            
             lista.add(u);
        }
        return lista;    
    }

    public Double quantidade() throws SQLException {
                Connection c = ConnectionFactory.getConnection();

         String sql = "SELECT sum(valor) FROM agendamento" ;                
               



        PreparedStatement pst = c.prepareStatement(sql);
        
                ResultSet rs =pst.executeQuery(); 

                rs.next();
                return rs.getDouble(1);
    }

    
  
}

