package edu.eci.pdsw.samples.persistence.mybatisimpl;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.persistence.DaoConsulta;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.ConsultaMapper;

import javax.inject.Inject;
import java.util.List;

public class MyBatisDAOConsulta implements DaoConsulta {
    @Inject
    ConsultaMapper consultaMapper;
    @Override
    public List<Consulta> getConsulta(int id, String tipo_id) throws PersistenceException {
        try{
            return consultaMapper.getConsulta(id,tipo_id);
        }catch (Exception ex){
            throw new PersistenceException (ex.getMessage());
        }
    }
}
