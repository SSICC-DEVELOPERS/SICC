/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;


public class DTORecuperacionTASPYMarcas extends DTOBelcorp {
   private DTOBuscarCuotasAplicar dtoBuscar;
   private Long cuentaContable;
   private Long[] marcasSalida;
   private BigDecimal importeASaldar;
   private Long tipoAbonoTES;
   private Long tipoAbonoCCC;
   private Long oidSubprocesoCCC;
   private Long tipoCargoAbonoTES;
   private Long tipoCargoAbonoCCC;
   //Gacevedo. Se agrega el atributo
   //en respuesta a la incidencia V-CCC-008. 13/11/2006
   private Boolean indicadorActualizaCuotaConImportePagado;
   //Gacevedo 17/11/2006
   //Corrección de validación. Esta parte no estaba implementada
   private Long subProcesoBancarioSalida;
   //Gacevedo 08/01/2007
   //correccion de validacion en base a V-CCC-019
   private Long oidTipoAbonoCreacionBanco;

    public DTORecuperacionTASPYMarcas() {
    }

    public Long getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(Long newCuentaContable) {
        cuentaContable = newCuentaContable;
    }

    public DTOBuscarCuotasAplicar getDtoBuscar() {
        return dtoBuscar;
    }

    public void setDtoBuscar(DTOBuscarCuotasAplicar newDtoBuscar) {
        dtoBuscar = newDtoBuscar;
    }

    public BigDecimal getImporteASaldar() {
        return importeASaldar;
    }

    public void setImporteASaldar(BigDecimal newImporteASaldar) {
        importeASaldar = newImporteASaldar;
    }



    public Long[] getMarcasSalida() {
        return marcasSalida;
    }

    public void setMarcasSalida(Long[] newMarcasSalida) {
        marcasSalida = newMarcasSalida;
    }

	public Long getTipoAbonoTES() {
		return this.tipoAbonoTES;
	}

	public void setTipoAbonoTES(Long newTipoAbonoTES) {
		this.tipoAbonoTES = newTipoAbonoTES;
	}

	public Long getTipoAbonoCCC() {
		return this.tipoAbonoCCC;
	}

	public void setTipoAbonoCCC(Long newTipoAbonoCCC) {
		this.tipoAbonoCCC = newTipoAbonoCCC;
	}

	public Long getOidSubprocesoCCC() {
		return this.oidSubprocesoCCC;
	}

	public void setOidSubprocesoCCC(Long newOidSubprocesoCCC) {
		this.oidSubprocesoCCC = newOidSubprocesoCCC;
	}
    
	public Long getTipoCargoAbonoTES() {
		return tipoCargoAbonoTES;
	}

	public void setTipoCargoAbonoTES(Long newTipoCargoAbonoTES) {
		tipoCargoAbonoTES = newTipoCargoAbonoTES;
	}
    
	public Long getTipoCargoAbonoCCC() {
		return tipoCargoAbonoCCC;
	}

	public void setTipoCargoAbonoCCC(Long newTipoCargoAbonoCCC) {
		tipoCargoAbonoCCC = newTipoCargoAbonoCCC;
	}


   public void setIndicadorActualizaCuotaConImportePagado(Boolean indicadorActualizaCuotaConImportePagado) {
      this.indicadorActualizaCuotaConImportePagado = indicadorActualizaCuotaConImportePagado;
   }


   public Boolean getIndicadorActualizaCuotaConImportePagado() {
      return indicadorActualizaCuotaConImportePagado;
   }


   public void setSubProcesoBancarioSalida(Long subProcesoBancarioSalida) {
      this.subProcesoBancarioSalida = subProcesoBancarioSalida;
   }


   public Long getSubProcesoBancarioSalida() {
      return subProcesoBancarioSalida;
   }


   public void setOidTipoAbonoCreacionBanco(Long oidTipoAbonoCreacionBanco) {
      this.oidTipoAbonoCreacionBanco = oidTipoAbonoCreacionBanco;
   }


   public Long getOidTipoAbonoCreacionBanco() {
      return oidTipoAbonoCreacionBanco;
   }
    
}
