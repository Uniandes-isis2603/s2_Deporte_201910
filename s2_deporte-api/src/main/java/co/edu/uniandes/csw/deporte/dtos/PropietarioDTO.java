/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.deporte.dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class PropietarioDTO implements Serializable{
    
    private String id;
    private int numCanchas;
    private List<CanchaDetailDTO> canchas;
    
    public PropietarioDTO () {
        
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the numCanchas
     */
    public int getNumCanchas() {
        return numCanchas;
    }

    /**
     * @param numCanchas the numCanchas to set
     */
    public void setNumCanchas(int numCanchas) {
        this.numCanchas = numCanchas;
    }

    /**
     * @return the canchas
     */
    public List<CanchaDetailDTO> getCanchas() {
        return canchas;
    }

    /**
     * @param canchas the canchas to set
     */
    public void setCanchas(List<CanchaDetailDTO> canchas) {
        this.canchas = canchas;
    }
}
