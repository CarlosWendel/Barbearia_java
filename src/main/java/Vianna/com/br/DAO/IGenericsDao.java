/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vianna.com.br.DAO;

import Vianna.com.br.Model.Servico;
import Vianna.com.br.Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author wendel
 */
public interface IGenericsDao<C,K> {
    public void inserir (C obj) throws ClassNotFoundException,SQLException;
    public void alterar (C obj) throws ClassNotFoundException,SQLException;
    public void apagar (K  obj) throws ClassNotFoundException,SQLException;
    
    public C buscarPorChave (K obj) throws ClassNotFoundException,SQLException;
    public ArrayList<C>buscarTodos ( ) throws ClassNotFoundException,SQLException;
    public C buscarLoginSenha (String nome, String senha ) throws ClassNotFoundException,SQLException;
    
}
