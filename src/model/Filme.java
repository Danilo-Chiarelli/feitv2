/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author danil
 */
public class Filme extends Video {
    private int duracao;
    public Filme(int id, String nome, String tipo, int duracao) {
        super(id, nome, tipo);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    
    @Override
    public String toString() {
        return getNome() + " (" + duracao + " min) - Tipo: " + getTipo();
    }

}
