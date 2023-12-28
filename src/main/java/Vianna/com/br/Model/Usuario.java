/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vianna.com.br.Model;

import java.util.Date;

/**
 *
 * @author wendel
 */
public class Usuario extends Pessoa{
  
    protected String senha;
    protected String nivelAcesso;

    public Usuario(int id,String nome,String senha,String sexo, String nivelAcesso,    String dataNascimento, String telefone, String email, String rg) {
        super(id, nome, sexo, dataNascimento, telefone, email, rg);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public Usuario( int id, String nome, String senha ) {
        super(id, nome);
        this.senha = senha;
       
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    

   
    
}
