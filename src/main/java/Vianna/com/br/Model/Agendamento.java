 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vianna.com.br.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wendel
 */
public class Agendamento {
    private int id;
    private Cliente cliente;
    private Servico servico;
    private String servicos;
    private double valor;
    private String data;
    private String observacao;
    private String hora;
    
    public Agendamento(int id, Cliente cliente,Servico servico,  double valor, String data,String hora,String observacao) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        this.data=data;
        this.hora=hora;
        this.observacao=observacao;
        
    }

    public Agendamento(int id, double valor, String data, String hora, String observacao) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.hora = hora;
        
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

   
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObsrvacao() {
        return observacao;
    }

    public void setObsrvacao(String obsrvacao) {
        this.observacao = obsrvacao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
  
    
    
    
}
