/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vianna.com.br.Controller.Helper;

/**
 *
 * @author wendel
 */

import Vianna.com.br.Controller.Helper.LoginHelper;
import Vianna.com.br.Model.Usuario;
import Vianna.com.br.View.Login;

/**
 *
 * @author wendel
 */
public class LoginController {

    private final Login View;
    private LoginHelper helper;
    public LoginController(Login View) {
        this.View = View;
        this.helper =new  LoginHelper(View);
    }
    
    public void entrarNoSistema(){
        Usuario usuario = helper.obterModelo();
        
    }
    public void fizTarefa(){
        System.out.print("Busquei algo do baco de dados");
        this.View.exibeMensagem("Executei o fiz Tarefa");
    }
    
}
