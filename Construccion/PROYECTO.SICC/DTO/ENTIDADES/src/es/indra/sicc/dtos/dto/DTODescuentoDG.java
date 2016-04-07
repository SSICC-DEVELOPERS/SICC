package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOOIDs;

import java.util.Vector;

public class DTODescuentoDG extends DTOAuditableSICC {

   private Long oidDescuento;
   private Long oidCabeceraDTO;
   private Long oidPais;
    private String descripcion;
   private Long oidMarca;
   private Long oidCanal;
   private DTOOIDs accesos;
   private DTOOIDs subaccesos;
   private Long oidPeriodoDesde;
   private Long oidPeriodoHasta;
   private Boolean activo;
   private Boolean aprobado;
   private Boolean descuentoAcumulativo;
   private Boolean culminacion;
   private Boolean controlDevoluciones;
   private Boolean controlAnulaciones;
   private Boolean comunicacionAParticipantes;
   private Boolean morosidad;
   private Boolean afectaAFacturas;
   private Boolean afectaACuentasCorrientes;
   private Boolean nacional;
    private volatile Vector attTraducible;
    private Long numeroDescuento;
    private Long numeroCorrelativo;
    private Character vigencia;
   
   public DTODescuentoDG() {
   }

   public Long getOidDescuento()
   {
      return this.oidDescuento;
   }

   public Long getOidCabeceraDTO()
   {
      return this.oidCabeceraDTO;
   }

   public Long getOidPais()
   {
      return this.oidPais;
   }

   public Long getOidPeriodoDesde()
   {
      return this.oidPeriodoDesde;
   }

   public Long getOidPeriodoHasta()
   {
      return this.oidPeriodoHasta;
   }

   public Long getOidMarca()
   {
      return this.oidMarca;
   }

   public Long getOidCanal()
   {
      return this.oidCanal;
   }

   public String getDescripcion()
   {
      return this.descripcion;
   }

   public DTOOIDs getAccesos()
   {
      return this.accesos;
   }

   public DTOOIDs getSubaccesos()
   {
      return this.subaccesos;
   }

   public Boolean getActivo()
   {
      return this.activo;
   }

   public Boolean getAprobado()
   {
      return this.aprobado;
   }

   public Boolean getDescuentoAcumulativo()
   {
      return this.descuentoAcumulativo;
   }

   public Boolean getCulminacion()
   {
      return this.culminacion;
   }

   public Boolean getControlDevoluciones()
   {
      return this.controlDevoluciones;
   }

   public Boolean getControlAnulaciones()
   {
      return this.controlAnulaciones;
   }

   public Boolean getComunicacionAParticipantes()
   {
      return this.comunicacionAParticipantes;
   }

   public Boolean getMorosidad()
   {
      return this.morosidad;
   }

   public Boolean getAfectaAFacturas()
   {
      return this.afectaAFacturas;
   }

   public Boolean getAfectaACuentasCorrientes()
   {
      return this.afectaACuentasCorrientes;
   }

   public Boolean getNacional()
   {
        return nacional;
   }

   public void setOidCabeceraDTO (Long oidCabeceraDTO)
   {
      this.oidCabeceraDTO = oidCabeceraDTO;
   }

   public void setOidPais  (Long oidPais)
   {
      this.oidPais = oidPais;
   }

   public void setOidMarca  (Long oidMarca)
   {
      this.oidMarca = oidMarca;
   }

   public void setOidCanal  (Long oidCanal)
   {
      this.oidCanal = oidCanal;
   }

   public void setOidPeriodoDesde  (Long oidPeriodoDesde)
   {
      this.oidPeriodoDesde = oidPeriodoDesde;
   }

   public void setOidPeriodoHasta  (Long oidPeriodoHasta)
   {
      this.oidPeriodoHasta = oidPeriodoHasta;
   }

   public void setOidDescuento  (Long oidDescuento)
   {
      this.oidDescuento = oidDescuento;
   }

   public void setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }

   public void setAccesos (DTOOIDs accesos)
   {
      this.accesos = accesos;
   }

   public void setSubaccesos (DTOOIDs subaccesos)
   {
      this.subaccesos = subaccesos;
   }

   public void setActivo (Boolean activo)
   {
      this.activo = activo;
   }

   public void setAprobado (Boolean aprobado)
   {
      this.aprobado = aprobado;
   }

   public void setDescuentoAcumulativo (Boolean descuentoAcumulativo)
   {
      this.descuentoAcumulativo = descuentoAcumulativo;
   }

   public void setCulminacion (Boolean culminacion)
   {
      this.culminacion = culminacion;
   }

   public void setControlDevoluciones (Boolean controlDevoluciones)
   {
      this.controlDevoluciones = controlDevoluciones;
   }

   public void setControlAnulaciones (Boolean controlAnulaciones)
   {
      this.controlAnulaciones = controlAnulaciones;
   }

   public void setComunicacionAParticipantes (Boolean comunicacionAParticipantes)
   {
      this.comunicacionAParticipantes = comunicacionAParticipantes;
   }


   public void setMorosidad (Boolean morosidad)
   {
      this.morosidad = morosidad;
   }


   public void setAfectaAFacturas (Boolean afectaAFacturas)
   {
      this.afectaAFacturas = afectaAFacturas;
   }


   public void setAfectaACuentasCorrientes (Boolean afectaACuentasCorrientes)
   {
      this.afectaACuentasCorrientes = afectaACuentasCorrientes;
   }

	public void setNacional(Boolean newNacional) {
        nacional = newNacional;
	}

    public Vector getAttTraducible() {
        return attTraducible;
    }

    public void setAttTraducible(Vector newAttTraducible) {
        attTraducible = newAttTraducible;
    }

    public Long getNumeroDescuento() {
        return numeroDescuento;
    }

    public void setNumeroDescuento(Long newNumeroDescuento) {
        numeroDescuento = newNumeroDescuento;
    }

    public Long getNumeroCorrelativo() {
        return numeroCorrelativo;
    }

    public void setNumeroCorrelativo(Long newNumeroCorrelativo) {
        numeroCorrelativo = newNumeroCorrelativo;
    }

    public Character getVigencia() {
        return vigencia;
    }

    public void setVigencia(Character newVigencia) {
        vigencia = newVigencia;
    }
}