package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.services.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name = "consultaBean")
@SessionScoped
public class ConsultasBean extends BasePageBean {
    @Inject
    private ServiciosConsulta consultasBean;
    int idConsultas;
    Date fecha_y_hora;
    String resumen;
    int id;
    String tipo_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }
    @PostConstruct
    public void init(){
        super.init();
    }
    public int getidConsultas() {
        return idConsultas;
    }
    public void setidConsultas(int idConsultas) {this.idConsultas = idConsultas;}
    public void setfecha_y_hora(Date fecha_y_hora) {this.fecha_y_hora = fecha_y_hora;}
    public Date getfecha_y_hora() {
        return fecha_y_hora;
    }
    public String getResumen(){return resumen;}
    public void setResumen(String resumen){this.resumen = resumen;}
    public void redirect() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("data.xhtml");
    }
    public List<Consulta> getData() throws Exception{
        if (ServiciosPacientesFactory.getInstance().getForumsServices().consultarPacientesPorId(id, TipoIdentificacion.valueOf(tipo_id)) != null){
                return ServiciosConsultasFactory.getInstance().getForumsServices().getConsulta(id, tipo_id);
        }
        return null;
    }
    public Map<String,String> getTipos(){

        Map<String,String> tipos = new HashMap<String,String>();
        for(TipoIdentificacion i : TipoIdentificacion.values()){
            tipos.put(i.name(), i.name());
        }
        return tipos;
    }
}
