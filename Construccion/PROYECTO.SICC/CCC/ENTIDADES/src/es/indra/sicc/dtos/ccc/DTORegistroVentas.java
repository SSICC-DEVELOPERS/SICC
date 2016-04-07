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

import java.util.Date;
import java.math.BigDecimal;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTORegistroVentas extends DTOSiccPaginacion{

	private Long oidReg;    
	private Long oidEmpresa;
	private Long oidIndImpuestos;    
	private Date fechaEmision;   
	private String codigoCliente;   
	private String nombre1; 
	private String nombre2;    
	private String apellido1; 
	private String apellido2;  
	private BigDecimal baseImponible;   
	private BigDecimal importeImpuesto;   
	private BigDecimal importeTotal;
	private BigDecimal coeficienteImpuesto;  // se añade por la incidencia BELC300007694     
	private Long oidCanal;					// se añade por la incidencia BELC300007694 
	private Long oidAcceso;					// se añade por la incidencia BELC300007694 
	private Long oidSubAcceso;     
	private String puntoEmision;     
	private Long oidTipoDocumentoLegal;    
	private String serieDocumentoLegal;
	//private Integer numeroDocumentoLegal;  cambiado por incidencia BELC300015038
    private String numeroDocumentoLegal;
	private String numeroIdentificacionFiscal; 
	private String numeroIdentificacionNacional;  
	private Long oidTipoDocumentoRef;   
	private String serieDocumentoRef;    
	//private Integer numeroDocumentoRef;   cambiado por incidencia BELC300015038
    private String numeroDocumentoRef;
	private Boolean estadoAnulado;     
	private String estadoRUV;  
	private Boolean indTransfGratuita;
        
        private BigDecimal descuento; 
        private BigDecimal baseImponibleNeto; 
        private String numeroDocumentoLegalFinal;
        private String exportacion;
        
        //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
        private Long oidTipoDocumento;    
        private Date fechaEmisionReferencia;  
        //sb 
        private String numDocControlLegal;
        private String numDocControlFinalLegal;

        
	public DTORegistroVentas(){
	}
	
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String newApellido1) {
		apellido1 = newApellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String newApellido2) {
		apellido2 = newApellido2;
	}

	public BigDecimal getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(BigDecimal newBaseImponible) {
		baseImponible = newBaseImponible;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}

	public Boolean getEstadoAnulado() {
		return estadoAnulado;
	}

	public void setEstadoAnulado(Boolean newEstadoAnulado) {
		estadoAnulado = newEstadoAnulado;
	}

	public String getEstadoRUV() {
		return estadoRUV;
	}

	public void setEstadoRUV(String newEstadoRUV) {
		estadoRUV = newEstadoRUV;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date newFechaEmision) {
		fechaEmision = newFechaEmision;
	}

	public BigDecimal getImporteImpuesto() {
		return importeImpuesto;
	}

	public void setImporteImpuesto(BigDecimal newImporteImpuesto) {
		importeImpuesto = newImporteImpuesto;
	}

	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(BigDecimal newImporteTotal) {
		importeTotal = newImporteTotal;
	}

	public Boolean getIndTransfGratuita() {
		return indTransfGratuita;
	}

	public void setIndTransfGratuita(Boolean newIndTransfGratuita) {
		indTransfGratuita = newIndTransfGratuita;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String newNombre1) {
		nombre1 = newNombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String newNombre2) {
		nombre2 = newNombre2;
	}

	public String getNumeroDocumentoLegal() {
        return numeroDocumentoLegal;
	}

	

	public String getNumeroDocumentoRef() {
        return numeroDocumentoRef;
	}

	

	public String getNumeroIdentificacionFiscal() {
		return numeroIdentificacionFiscal;
	}

	public void setNumeroIdentificacionFiscal(String newNumeroIdentificacionFiscal) {
		numeroIdentificacionFiscal = newNumeroIdentificacionFiscal;
	}

	public String getNumeroIdentificacionNacional() {
		return numeroIdentificacionNacional;
	}

	public void setNumeroIdentificacionNacional(String newNumeroIdentificacionNacional) {
		numeroIdentificacionNacional = newNumeroIdentificacionNacional;
	}

	public Long getOidEmpresa() {
		return oidEmpresa;
	}

	public void setOidEmpresa(Long newOidEmpresa) {
		oidEmpresa = newOidEmpresa;
	}

	public Long getOidIndImpuestos() {
		return oidIndImpuestos;
	}

	public void setOidIndImpuestos(Long newOidIndImpuestos) {
		oidIndImpuestos = newOidIndImpuestos;
	}

	public Long getOidReg() {
		return oidReg;
	}

	public void setOidReg(Long newOidReg) {
		oidReg = newOidReg;
	}

	public Long getOidSubAcceso() {
		return oidSubAcceso;
	}

	public void setOidSubAcceso(Long newOidSubAcceso) {
		oidSubAcceso = newOidSubAcceso;
	}

	public Long getOidTipoDocumentoLegal() {
		return oidTipoDocumentoLegal;
	}

	public void setOidTipoDocumentoLegal(Long newOidTipoDocumentoLegal) {
		oidTipoDocumentoLegal = newOidTipoDocumentoLegal;
	}

	public Long getOidTipoDocumentoRef() {
		return oidTipoDocumentoRef;
	}

	public void setOidTipoDocumentoRef(Long newOidTipoDocumentoRef) {
		oidTipoDocumentoRef = newOidTipoDocumentoRef;
	}

	public String getPuntoEmision() {
		return puntoEmision;
	}

	public void setPuntoEmision(String newPuntoEmision) {
		puntoEmision = newPuntoEmision;
	}

	public String getSerieDocumentoLegal() {
		return serieDocumentoLegal;
	}

	public void setSerieDocumentoLegal(String newSerieDocumentoLegal) {
		serieDocumentoLegal = newSerieDocumentoLegal;
	}

	public String getSerieDocumentoRef() {
		return serieDocumentoRef;
	}

	public void setSerieDocumentoRef(String newSerieDocumentoRef) {
		serieDocumentoRef = newSerieDocumentoRef;
	}

	public BigDecimal getCoeficienteImpuesto() {
		return coeficienteImpuesto;
	}

	public void setCoeficienteImpuesto(BigDecimal newCoeficienteImpuesto) {
		coeficienteImpuesto = newCoeficienteImpuesto;
	}

	public Long getOidAcceso() {
		return oidAcceso;
	}

	public void setOidAcceso(Long newOidAcceso) {
		oidAcceso = newOidAcceso;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

    public void setNumeroDocumentoLegal(String numeroDocumentoLegal)
    {
        this.numeroDocumentoLegal = numeroDocumentoLegal;
    }

    public void setNumeroDocumentoRef(String numeroDocumentoRef)
    {
        this.numeroDocumentoRef = numeroDocumentoRef;
    }
    public BigDecimal getDescuento()
      {
        return descuento;
      }

      public void setDescuento(BigDecimal desc)
      {
        this.descuento = desc;
      }

      public BigDecimal getBaseImponibleNeto()
      {
        return baseImponibleNeto;
      }

      public void setBaseImponibleNeto(BigDecimal baseImponibleNeto)
      {
        this.baseImponibleNeto = baseImponibleNeto;
      }

      public String getNumeroDocumentoLegalFinal()
      {
        return numeroDocumentoLegalFinal;
      }

      public void setNumeroDocumentoLegalFinal(String numeroDocumentoLegalFinal)
      {
        this.numeroDocumentoLegalFinal = numeroDocumentoLegalFinal;
      }

      public String getExportacion()
      {
        return exportacion;
      }

      public void setExportacion(String exportacion)
      {
        this.exportacion = exportacion;
      }

    public void setOidTipoDocumento(Long oidTipoDocumento) {
        this.oidTipoDocumento = oidTipoDocumento;
    }

    public Long getOidTipoDocumento() {
        return oidTipoDocumento;
    }

    public void setFechaEmisionReferencia(Date fechaEmisionReferencia) {
        this.fechaEmisionReferencia = fechaEmisionReferencia;
    }

    public Date getFechaEmisionReferencia() {
        return fechaEmisionReferencia;
    }

    public String getNumDocControlLegal() {
        return numDocControlLegal;
    }

    public void setNumDocControlLegal(String numDocControlLegal) {
        this.numDocControlLegal = numDocControlLegal;
    }

    public String getNumDocControlFinalLegal() {
        return numDocControlFinalLegal;
    }

    public void setNumDocControlFinalLegal(String numDocControlFinalLegal) {
        this.numDocControlFinalLegal = numDocControlFinalLegal;
    }
}
