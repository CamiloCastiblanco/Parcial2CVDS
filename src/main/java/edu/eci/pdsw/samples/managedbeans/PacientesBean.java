/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosConsulta;
import edu.eci.pdsw.samples.services.ServiciosPaciente;
import edu.eci.pdsw.samples.services.ServiciosPacientesFactory;

import java.sql.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name = "mb")
@SessionScoped
public class PacientesBean extends BasePageBean {
    @Inject private ServiciosPaciente serviciosPaciente;
    @Inject private ServiciosConsulta serviciosConsulta;
    TipoIdentificacion tipoIdentificacion = TipoIdentificacion.CC;
    int identificacion_paciente;
    String nombre;
    Date fechaNacimiento;
    List<Consulta> consultas;
    @PostConstruct
    public void init(){
        super.init();
    }
    public int getIdentificacion_paciente() {
        return identificacion_paciente;
    }

    public void setIdentificacion_paciente(int identificacion_paciente) {
        this.identificacion_paciente = identificacion_paciente;
    }
    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Consulta> getConsultas() {

        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    public List<Paciente> getData() throws Exception{
        try {
            return ServiciosPacientesFactory.getInstance().getForumsServices().consultarPacientes();
        } catch (ExcepcionServiciosSuscripciones ex) {
            throw ex;
        }
        
    }
    public TipoIdentificacion[] getTiposIdentificacion() {
        return TipoIdentificacion.values();
    }
    
}
