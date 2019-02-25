/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.deporte.dtos;

import co.edu.uniandes.csw.deporte.entities.AgendaEntity;
import co.edu.uniandes.csw.deporte.entities.CanchaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class CanchaDetailDTO extends CanchaDTO implements Serializable {

    private List<AgendaDTO> agendas;

    private List<ReservaDTO> reservas;

    public CanchaDetailDTO() {
        super();
    }

    public CanchaDetailDTO(CanchaEntity cancha) {
        super(cancha);
        agendas = new ArrayList<>();
        for (AgendaEntity entityBooks : cancha.getAgendas()) {
            agendas.add(new AgendaDTO(entityBooks));
        }
    }

    /**
     * @return the agendas
     */
    public List<AgendaDTO> getAgendas() {
        return agendas;
    }

    /**
     * @param agendas the agendas to set
     */
    public void setAgendas(List<AgendaDTO> agendas) {
        this.agendas = agendas;
    }

    /**
     * @return the reservas
     */
    public List<ReservaDTO> getReservas() {
        return reservas;
    }

    /**
     * @param reservas the reservas to set
     */
    public void setReservas(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }
}
