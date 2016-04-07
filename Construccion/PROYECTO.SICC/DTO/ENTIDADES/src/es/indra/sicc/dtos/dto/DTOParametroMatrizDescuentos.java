package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Long;

import java.util.ArrayList;

public class DTOParametroMatrizDescuentos extends DTOAuditableSICC {

   private Long oidParametro;
   private Long oidDetalleMatrizDescuento;
   private Boolean obligatorio;
   private Boolean visible;
   private Boolean modificable;
   private ArrayList listaValoresPosibles;
   private ArrayList listaValoresPosibles2;
   private Integer numeroMaximoValores;
  private Long parametro;

   public DTOParametroMatrizDescuentos() {
   }

   public Long getOidParametro()
   {
      return this.oidParametro;
   }

   public Long getOidDetalleMatrizDescuento()
   {
      return this.oidDetalleMatrizDescuento;
   }

   public Boolean getObligatorio()
   {
      return this.obligatorio;
   }

   public Boolean getVisible()
   {
      return this.visible;
   }

   public Boolean getModificable()
   {
      return this.modificable;
   }

   public ArrayList getListaValoresPosibles()
   {
      return this.listaValoresPosibles;
   }

   public ArrayList getListaValoresPosibles2()
   {
      return this.listaValoresPosibles2;
   }

   public void setOidParametro(Long oidParametro)
   {
      this.oidParametro = oidParametro;
   }

   public void setOidDetalleMatrizDescuento(Long oidDetalleMatrizDescuento)
   {
      this.oidDetalleMatrizDescuento = oidDetalleMatrizDescuento;
   }

   public void setObligatorio(Boolean obligatorio)
   {
      this.obligatorio = obligatorio;
   }

   public void setVisible(Boolean visible)
   {
      this.visible = visible;
   }

   public void setModificable(Boolean modificable)
   {
      this.modificable = modificable;
   }

   public void setListaVariablesPosibles(ArrayList listaValoresPosibles)
   {
      this.listaValoresPosibles = listaValoresPosibles;
   }

    public void setListaVariablesPosibles2(ArrayList listaValoresPosibles2)
   {
      this.listaValoresPosibles2 = listaValoresPosibles2;
   }

   public Integer getNumeroMaximoValores()
   {
      return this.numeroMaximoValores;
   }

   public void setNumeroMaximoValores(Integer numeroMaximoValores)
   {
      this.numeroMaximoValores = numeroMaximoValores;
   }

  public Long getParametro()
  {
    return parametro;
  }

  public void setParametro(Long parametro)
  {
    this.parametro = parametro;
  }
}