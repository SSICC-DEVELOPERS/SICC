package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOTipoEncuesta extends DTOSiccPaginacion {
    public DTOTipoEncuesta() {
    }
    private Long oidEncuesta;
    private Long oidPais;
    private String codTipoEncuesta;
    Long oidMarca;
    private String descripcion;
     
     public Long getOidEncuesta()
      {
        return oidEncuesta;
      }

      public void setOidEncuesta(Long oidEncuesta)
      {
        this.oidEncuesta = oidEncuesta;
      }

      public Long getOidPais()
      {
        return oidPais;
      }

      public void setOidPais(Long oidPais)
      {
        this.oidPais = oidPais;
      }

      public String getCodTipoEncuesta()
      {
        return codTipoEncuesta;
      }

      public void setCodTipoEncuesta(String codTipoEncuesta)
      {
        this.codTipoEncuesta = codTipoEncuesta;
      }

      public Long getOidMarca()
      {
        return oidMarca;
      }

      public void setOidMarca(Long oidMarca)
      {
        this.oidMarca = oidMarca;
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
