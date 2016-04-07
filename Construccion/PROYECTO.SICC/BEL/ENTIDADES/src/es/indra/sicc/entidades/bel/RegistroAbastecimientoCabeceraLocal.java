package es.indra.sicc.entidades.bel;

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
@Table(name="BEL_REGIS_ABAST_CABEC")
@NamedQueries({
@NamedQuery(name="RegistroAbastecimientoCabeceraLocal.FindByUK",query="SELECT OBJECT(a) FROM RegistroAbastecimientoCabeceraLocal AS a WHERE a.nSolicitud = ?1")
})
public class RegistroAbastecimientoCabeceraLocal implements Serializable {

	public RegistroAbastecimientoCabeceraLocal() {}

	public RegistroAbastecimientoCabeceraLocal(Long oid, Long nSolicitud, Long periodo, Long almacen, Long subacceso, Long pais, Long estadoHojaDemanda, Long agrupacionStockCabecera) {
		this.oid=oid;
                this.nSolicitud = nSolicitud;
                this.periodo = periodo;
                this.almacen = almacen;
                this.subacceso = subacceso;
                this.pais = pais;
                this.estadoHojaDemanda = estadoHojaDemanda;
                this.agrupacionStockCabecera = agrupacionStockCabecera;
	}

	@Id
	@Column(name="OID_REGI_ABAS_CABE")
	private Long oid;
	@Column(name="NUM_SOLI")
	private Long nSolicitud;
	@Column(name="FEC_CREA")
        //@Temporal(TemporalType.DATE)
	private java.sql.Timestamp fechaCreado;
	@Column(name="FEC_ENVI")
        //@Temporal(TemporalType.DATE)
	private java.sql.Timestamp fechaEnviado;
	@Column(name="FEC_CONF")
        //@Temporal(TemporalType.DATE)
	private java.sql.Timestamp fechaConfirmado;
	@Column(name="FEC_INGR")
        //@Temporal(TemporalType.DATE)
	private java.sql.Timestamp fechaIngresado;
	@Column(name="IND_SAP")
	private Boolean indicadorSAP;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="ALMC_OID_ALMA")
	private Long almacen;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="DHDE_OID_ESTA_HOJA_DEMA")
	private Long estadoHojaDemanda;
	@Column(name="AGSC_OID_AGRU_STOC_CABE")
	private Long agrupacionStockCabecera;
	@Column(name="FEC_RECE_INTE")
        //@Temporal(TemporalType.DATE)
        private java.sql.Timestamp fechaRecepcionInterface;
	@Column(name="VAL_OBSE")
	private String observaciones;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNSolicitud() {return nSolicitud;}
      
	public void setNSolicitud(Long nSolicitud){this.nSolicitud=nSolicitud;}
		
	public java.sql.Timestamp getFechaCreado() {return fechaCreado;}
      
	public void setFechaCreado(java.sql.Timestamp fechaCreado){this.fechaCreado=fechaCreado;}
		
	public java.sql.Timestamp getFechaEnviado() {return fechaEnviado;}
      
	public void setFechaEnviado(java.sql.Timestamp fechaEnviado){this.fechaEnviado=fechaEnviado;}
		
	public java.sql.Timestamp getFechaConfirmado() {return fechaConfirmado;}
      
	public void setFechaConfirmado(java.sql.Timestamp fechaConfirmado){this.fechaConfirmado=fechaConfirmado;}
		
	public java.sql.Timestamp getFechaIngresado() {return fechaIngresado;}
      
	public void setFechaIngresado(java.sql.Timestamp fechaIngresado){this.fechaIngresado=fechaIngresado;}
		
	public Boolean getIndicadorSAP() {return indicadorSAP;}
      
	public void setIndicadorSAP(Boolean indicadorSAP){this.indicadorSAP=indicadorSAP;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getAlmacen() {return almacen;}
      
	public void setAlmacen(Long almacen){this.almacen=almacen;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getEstadoHojaDemanda() {return estadoHojaDemanda;}
      
	public void setEstadoHojaDemanda(Long estadoHojaDemanda){this.estadoHojaDemanda=estadoHojaDemanda;}
		
	public Long getAgrupacionStockCabecera() {return agrupacionStockCabecera;}
      
	public void setAgrupacionStockCabecera(Long agrupacionStockCabecera){this.agrupacionStockCabecera=agrupacionStockCabecera;}
		
	public java.sql.Timestamp getFechaRecepcionInterface() {return fechaRecepcionInterface;}
      
	public void setFechaRecepcionInterface(java.sql.Timestamp fechaRecepcionInterface){this.fechaRecepcionInterface=fechaRecepcionInterface;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
			
	
}
