package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="COM_CUOTA_POR_TRAMO_COM_CALCU")
@NamedQueries({
@NamedQuery(name="CuotasTramoComisionesCalculadasLocal.FindAll",query="select object(o) from CuotasTramoComisionesCalculadasLocal o")
})
public class CuotasTramoComisionesCalculadasLocal implements Serializable {

	public CuotasTramoComisionesCalculadasLocal() {}

	public CuotasTramoComisionesCalculadasLocal(Long oid, Long idCuota, Integer codTerri)	{
	
		this.oid=oid;
                this.setIdCuota(idCuota);
	        this.setCodTerritorio(codTerri);
	
	}

	@Id
	@Column(name="OID_CUOT_POR_TRAM_COM_CALC")
	private Long oid;
	@Column(name="VAL_EJER_CUOT")
	private String ejercicioCuota;
	@Column(name="FEC_FECH_VALO")
        @Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaValor;
	@Column(name="FEC_FECH_DOCU")
        @Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaDocumento;
	@Column(name="NUM_IMPO_PAGO")
	private java.math.BigDecimal importePago;
	@Column(name="NUM_IMPO")
	private java.math.BigDecimal importe;
	@Column(name="ACTR_OID_COMI_COBR_ACUM")
	private Long oidComiCobrAcumClien;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Column(name="ID_CUOTA")
	private Long idCuota;
	@Column(name="COD_TERRI")
	private Integer codTerritorio;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getEjercicioCuota() {return ejercicioCuota;}
      
	public void setEjercicioCuota(String ejercicioCuota){this.ejercicioCuota=ejercicioCuota;}
		
	public java.util.Date getFechaValor() {return fechaValor;}
      
	public void setFechaValor(java.util.Date fechaValor){this.fechaValor=fechaValor;}
		
	public java.util.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.util.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public java.math.BigDecimal getImportePago() {return importePago;}
      
	public void setImportePago(java.math.BigDecimal importePago){this.importePago=importePago;}
		
	public java.math.BigDecimal getImporte() {return importe;}
      
	public void setImporte(java.math.BigDecimal importe){this.importe=importe;}
		
	public Long getOidComiCobrAcumClien() {return oidComiCobrAcumClien;}
      
	public void setOidComiCobrAcumClien(Long oidComiCobrAcumClien){this.oidComiCobrAcumClien=oidComiCobrAcumClien;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Long getIdCuota() {return idCuota;}
      
	public void setIdCuota(Long idCuota){this.idCuota=idCuota;}
		
	public Integer getCodTerritorio() {return codTerritorio;}
      
	public void setCodTerritorio(Integer codTerritorio){this.codTerritorio=codTerritorio;}
			
	
}
