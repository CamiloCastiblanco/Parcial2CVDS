package edu.eci.pdsw.samples.services.impl;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.persistence.DaoPaciente;
import edu.eci.pdsw.samples.persistence.DaoConsulta;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosConsulta;

import javax.inject.Inject;
import java.util.List;

public class ServiciosConsultaImpl implements ServiciosConsulta {
    @Inject
    private DaoConsulta daoConsulta;

    @Override
    public List<Consulta> getConsulta(int id, String tipo_id) throws ExcepcionServiciosSuscripciones {
        try{
            return daoConsulta.getConsulta(id, tipo_id);
        }catch (Exception ex){
            throw new ExcepcionServiciosSuscripciones(ex.getMessage());
        }
    }
}
