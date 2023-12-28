/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vianna.com.br.Controller.Helper;

import Vianna.com.br.Model.Usuario;
import Vianna.com.br.View.Login;

/**
 *
 * @author wendel
 */
public class LoginHelper {
    
    private final Login View;

    public LoginHelper(Login View) {
        this.View = View;
    }
    public Usuario obterModelo(){
      String nome  = View.getTextUsuario().getText();
        String senha = View.getTextSenha().getText();
        
        Usuario mode= new Usuario(0,nome,senha); 
        return mode;
    }
    public void setarModelo(Usuario mode){
        String nome= mode.getNome();
        String senha = mode.getSenha();
        
        View.getTextUsuario().setText(nome);
        View.getTextSenha().setText(senha);
    }
    public void limparTela(){
        View.getTextUsuario().setText("");
        View.getTextSenha().setText("");
    }
    
}
