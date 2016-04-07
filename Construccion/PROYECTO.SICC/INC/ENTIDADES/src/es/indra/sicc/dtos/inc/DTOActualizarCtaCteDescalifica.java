package es.indra.sicc.dtos.inc;

public class DTOActualizarCtaCteDescalifica 
{
    private Long oidCliente;
    private Long oidConcurso;
    private Long oidPeriodo;
    private String descripcion;

    public DTOActualizarCtaCteDescalifica()
    {
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente)
    {
        this.oidCliente = oidCliente;
    }

    public Long getOidConcurso()
    {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso)
    {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
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