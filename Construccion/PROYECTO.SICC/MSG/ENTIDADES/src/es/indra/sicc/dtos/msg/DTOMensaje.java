package es.indra.sicc.dtos.msg;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.util.Date;
import java.util.Vector;


public class DTOMensaje extends DTOSiccPaginacion {
  private Long oidMensaje;
  private Long oidModulo;
  private String codigo;
  private String descripcion;
  private String bloque;
  private Date permanenciaDesde;
  private Date permanenciaHasta;
  private String texto;
  private Integer numeroVariables;
  private Long oidTipoPeriodo;
  private Long oidTipoMensaje;
  private Long oidGeneracionDatos;
  private Long oidPermanencia;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  private Vector tiposDestinatario;
  private Boolean exclusionTipologia;

    public DTOMensaje() {
    }

    public Long getOidMensaje() {
    return oidMensaje;
    }

    public Long getOidModulo() {
        return oidModulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }





    public String getBloque() {
        return bloque;
    }


    public Date getPermanenciaDesde() {
        return permanenciaDesde;
    }

    public Date getPermanenciaHasta() {
        return permanenciaHasta;
    }


    public String getTexto() {
        return texto;
    }

    public Integer getNumeroVariables() {
    return numeroVariables;
    }









    public void setOidMensaje(Long newOidMensaje) {
    oidMensaje = newOidMensaje;
    }


    public void setOidModulo(Long modulo) {
        this.oidModulo = modulo;
    }

    public void setCodigo(String codigoMensaje) {
        this.codigo = codigoMensaje;
    }

    public void setDescripcion(String descripcionMensaje) {
        this.descripcion = descripcionMensaje;
    }





    public void setBloque(String bloqueGrupoPertenece) {
        this.bloque = bloqueGrupoPertenece;
    }


    public void setPermanenciaDesde(Date permanenciaDesde) {
        this.permanenciaDesde = permanenciaDesde;
    }

    public void setPermanenciaHasta(Date permanenciaHasta) {
        this.permanenciaHasta = permanenciaHasta;
    }



    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setNumeroVariables(Integer newNumeroVariables) {
    numeroVariables = newNumeroVariables;
    }













  public Long getOidTipoPeriodo() {
    return oidTipoPeriodo;
  }

  public void setOidTipoPeriodo(Long newOidTipoPeriodo) {
    oidTipoPeriodo = newOidTipoPeriodo;
  }







  public Long getOidTipoMensaje()
  {
    return oidTipoMensaje;
  }

  public void setOidTipoMensaje(Long newOidTipoMensaje)
  {
    oidTipoMensaje = newOidTipoMensaje;
  }

  public Long getOidGeneracionDatos()
  {
    return oidGeneracionDatos;
  }

  public void setOidGeneracionDatos(Long newOidGeneracionDatos)
  {
    oidGeneracionDatos = newOidGeneracionDatos;
  }

  public Long getOidPermanencia()
  {
    return oidPermanencia;
  }

  public void setOidPermanencia(Long newOidPermanencia)
  {
    oidPermanencia = newOidPermanencia;
  }

  public Long getOidPeriodoDesde()
  {
    return oidPeriodoDesde;
  }

  public void setOidPeriodoDesde(Long newOidPeriodoDesde)
  {
    oidPeriodoDesde = newOidPeriodoDesde;
  }

  public Long getOidPeriodoHasta()
  {
    return oidPeriodoHasta;
  }

  public void setOidPeriodoHasta(Long newOidPeriodoHasta)
  {
    oidPeriodoHasta = newOidPeriodoHasta;
  }

  public Vector getTiposDestinatario()
  {
    return tiposDestinatario;
  }

  public void setTiposDestinatario(Vector newTiposDestinatario)
  {
    tiposDestinatario = newTiposDestinatario;
  }

  public Boolean getExclusionTipologia()
  {
    return exclusionTipologia;
  }

  public void setExclusionTipologia(Boolean exclusionTipologia)
  {
    this.exclusionTipologia = exclusionTipologia;
  }
}
