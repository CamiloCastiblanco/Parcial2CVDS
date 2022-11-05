package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.Consulta;

import java.util.List;

public interface DaoConsulta {
    public List<Consulta> getConsulta(int id, String tipo_id) throws PersistenceException;
}
