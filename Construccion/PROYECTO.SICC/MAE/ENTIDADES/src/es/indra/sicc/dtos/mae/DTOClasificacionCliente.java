package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOClasificacionCliente extends DTOAuditableSICC  {

        private Long clasificacion;
        private Boolean principal;
        private Long marca;
        private Long canal;
        private Long oid;
        private Long tipoClasificacion;
        private Long tipo;
        private Long subtipo;
        private String tipoDesc;
        private String subtipoDesc;
        private String marcaDesc;
        private String canalDesc;
        private String clasificacionDesc;
        private String tipoClasificacionDesc;

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Long getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Long newClasificacion) {
        clasificacion = newClasificacion;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean newPrincipal) {
        principal = newPrincipal;
    }

    public Long getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(Long newTipoClasificacion) {
        tipoClasificacion = newTipoClasificacion;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long newTipo) {
        tipo = newTipo;
    }

    public Long getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(Long newSubtipo) {
        subtipo = newSubtipo;
    }


    public void setTipoDesc(String tipoDesc){
        this.tipoDesc = tipoDesc;      
    }

    public String getTipoDesc()
    {
      return this.tipoDesc;
    }

    public void setSubtipoDesc(String subtipoDesc)
    {
       this.subtipoDesc = subtipoDesc;
    }

    public String getSubtipoDesc()
    {
      return this.subtipoDesc;
    }

  public String getMarcaDesc()
  {
    return marcaDesc;
  }

  public void setMarcaDesc(String newMarcaDesc)
  {
    marcaDesc = newMarcaDesc;
  }

  public String getCanalDesc()
  {
    return canalDesc;
  }

  public void setCanalDesc(String newCanalDesc)
  {
    canalDesc = newCanalDesc;
  }

  public String getClasificacionDesc()
  {
    return clasificacionDesc;
  }

  public void setClasificacionDesc(String newClasificacionDesc)
  {
    clasificacionDesc = newClasificacionDesc;
  }

  public String getTipoClasificacionDesc()
  {
    return tipoClasificacionDesc;
  }

  public void setTipoClasificacionDesc(String newTipoClasificacionDesc)
  {
    tipoClasificacionDesc = newTipoClasificacionDesc;
  }




}