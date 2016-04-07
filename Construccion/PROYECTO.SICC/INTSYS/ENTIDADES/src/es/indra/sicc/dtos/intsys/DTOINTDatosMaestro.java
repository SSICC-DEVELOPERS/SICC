package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTDatosMaestro extends DTOBelcorp {
    public DTOINTDatosMaestro()
    {
    }
    
    private Long oid;
    private String codigo;
    private String descripcion;

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid(Long oid)
    {
        this.oid = oid;
    }
}