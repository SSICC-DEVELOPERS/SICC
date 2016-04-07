package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTEmpresa extends DTOBelcorp

{
    public DTOINTEmpresa()
    {
    }
    private String codigoEmpresa;    
    private String descripcion;     

    public String getCodigoEmpresa()
    {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa)
    {
        this.codigoEmpresa = codigoEmpresa;
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