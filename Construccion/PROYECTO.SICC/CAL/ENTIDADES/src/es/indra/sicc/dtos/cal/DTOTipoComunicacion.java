package es.indra.sicc.dtos.cal;

import es.indra.sicc.util.DTOBelcorp;

public class DTOTipoComunicacion extends DTOBelcorp{
    private Long oidClienteComun;
    private String descripcion;
    private String valTextComu;
    private String indicadorPrincipal;

    public DTOTipoComunicacion()
    {
    }

    public Long getOidClienteComun()
    {
      return oidClienteComun;
    }

    public void setOidClienteComun(Long oidClienteComun)
    {
      this.oidClienteComun = oidClienteComun;
    }

    public String getDescripcion()
    {
      return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
      this.descripcion = descripcion;
    }

    public String getValTextComu()
    {
      return valTextComu;
    }

    public void setValTextComu(String valTextComu)
    {
      this.valTextComu = valTextComu;
    }

    public String getIndicadorPrincipal()
    {
      return indicadorPrincipal;
    }

    public void setIndicadorPrincipal(String indicadorPrincipal)
    {
      this.indicadorPrincipal = indicadorPrincipal;
    }
    
}
