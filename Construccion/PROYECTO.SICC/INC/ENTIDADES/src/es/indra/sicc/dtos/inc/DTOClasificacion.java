package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOClasificacion extends DTOBelcorp 
{
    private Long oidClasificacionParticipante;
    private Long oidParticipante;
    private String descripcion;

    public Long getOidClasificacionParticipante()
    {
        return oidClasificacionParticipante;
    }

    public void setOidClasificacionParticipante(Long oidClasificacionParticipante)
    {
        this.oidClasificacionParticipante = oidClasificacionParticipante;
    }

    public Long getOidParticipante()
    {
        return oidParticipante;
    }

    public void setOidParticipante(Long oidParticipante)
    {
        this.oidParticipante = oidParticipante;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

}