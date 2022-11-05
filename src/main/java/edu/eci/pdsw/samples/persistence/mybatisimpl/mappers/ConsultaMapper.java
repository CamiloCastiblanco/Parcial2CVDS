package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.samples.entities.Consulta;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsultaMapper {
    List<Consulta> getConsulta(@Param("id") int id, @Param("tipo_id") String tipo_id);
}
