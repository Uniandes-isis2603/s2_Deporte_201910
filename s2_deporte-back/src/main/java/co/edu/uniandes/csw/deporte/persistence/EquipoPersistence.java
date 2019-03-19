/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.deporte.persistence;

import co.edu.uniandes.csw.deporte.entities.EquipoEntity;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @equipo estudiante
 */
@Stateless
public class EquipoPersistence 
{
    public static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(EquipoPersistence.class.getName());

    @PersistenceContext(unitName = "deportePU")
    protected EntityManager em;
    
    
    /**
     * Método para persisitir la entidad en la base de datos.
     *
     * @param EquipoEntity objeto equipo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EquipoEntity create(EquipoEntity equipoEntity) {
        LOGGER.log(Level.INFO, "Creando un equipo nuevo");
        em.persist(equipoEntity);
        LOGGER.log(Level.INFO, "Libro creado");
        System.out.println(em.find(EquipoEntity.class, equipoEntity.id)!=null);
        return equipoEntity;
    }

    /**
     * Devuelve todos losequipos de la base de datos.
     *
     * @return una lista con todos los equipos que encuentre en la base de datos,
     * "select u from EquipoEntity u" es como un "select * from EquipoEntity;" -
     * "SELECT * FROM table_name" en SQL.
     */
    public List<EquipoEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todos los equipos");
        Query q = em.createQuery("select u from EquipoEntity u");
        return q.getResultList();
    }

    /**
     * Busca si hay algun lubro con el id que se envía de argumento
     *
     * @param EquiposId: id correspondiente al equipo buscado.
     * @return un equipo.
     */
    public EquipoEntity find(Long EquiposId) {
        LOGGER.log(Level.INFO, "Consultando el equipo con id={0}", EquiposId);
        return em.find(EquipoEntity.class, EquiposId);
    }

    /**
     * Actualiza un equipo.
     *
     * @param EquipoEntity: el equipo que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del método update.
     * @return un equipo con los cambios aplicados.
     */
    public EquipoEntity update(EquipoEntity equipoEntity) {
        LOGGER.log(Level.INFO, "Actualizando el equipo con id={0}", equipoEntity.getId());
        return em.merge(equipoEntity);
    }

    /**
     *
     * Borra un equipo de la base de datos recibiendo como argumento el id del
     * equipo
     *
     * @param EquiposId: id correspondiente al equipo a borrar.
     */
    public void delete(Long EquiposId) {
        LOGGER.log(Level.INFO, "Borrando el equipo con id={0}", EquiposId);
        EquipoEntity equipoEntity = em.find(EquipoEntity.class, EquiposId);
        System.out.println(equipoEntity);
        em.remove(equipoEntity);
    }
}
