package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Consulta;

import java.util.List;

public interface ServiciosConsulta {
    List<Consulta> getConsulta(int id, String tipo_id) throws ExcepcionServiciosSuscripciones;
}
