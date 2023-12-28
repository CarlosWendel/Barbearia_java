/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vianna.com.br.Model;

/**
 *
 * @author wendel
 */
public class Servico {
    private int Id;
    private String descricao;
    private double valor;

    public Servico() {
    }

    public Servico(int Id, String descricao, double valor) {
        this.Id = Id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){
        return this.getDescricao();
    }
}
