/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author danil
 */
public class Serie extends Video implements Situacao{
    private int temporadas;
    private String status;

    public Serie(int temporadas, String status, int id, String nome, String tipo) {
        super(id, nome, tipo);
        this.temporadas = temporadas;
        this.status = status;
    }
    
    @Override
    public String getStatus(){
    return this.status;
    } 
    
    @Override
    public void setStatus(String status){
     this.status= status ;
    } 

    public int getTemporadas() {
        return temporadas;
    }
    
    @Override
    public String toString() {
        return "Serie{" + "temporadas=" + temporadas + ", status=" + status + '}';
    }
    
    
}
