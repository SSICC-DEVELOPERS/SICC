package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="REC_CABEC_GENER_MASIV")
@NamedQueries({
@NamedQuery(name="CabeceraGeneracionMasivaLocal.FindAll",query="select object(o) from CabeceraGeneracionMasivaLocal o")
})
public class CabeceraGeneracionMasivaLocal implements Serializable {

	public CabeceraGeneracionMasivaLocal() {}

	public CabeceraGeneracionMasivaLocal(Long oid, Integer numeroGeneracion, 
                                            Long pais, Long acceso, Long tipoOperacion,
                                            Long ventaOrigen, Long ventaDestino)	{
	
		this.oid=oid;
                this.numeroGeneracion=numeroGeneracion;
                this.pais=pais;
                this.acceso=acceso;
                this.tipoOperacion=tipoOperacion;
                this.ventaOrigen=ventaOrigen;
                this.ventaDestino=ventaDestino;
        
	}

	@Id
	@Column(name="OID_CABE_GENE_MASI")
	private Long oid;
	@Column(name="NUM_GENE")
	private Integer numeroGeneracion;
	@Column(name="ESGN_OID_ESTA_GENE")
	private String estado;
	@Column(name="FEC_GENE")
	private Date fechaGeneracion;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="ACCE_OID_ACCE")
	private Long acceso;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="OFDE_OID_OFER_DETA")
	private Long ventaOrigen;
	@Column(name="OFDE_OID_DETA_OFER_DEST")
	private Long ventaDestino;
	@Column(name="TIOP_OID_TIPO_OPER")
	private Long tipoOperacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroGeneracion() {return numeroGeneracion;}
      
	public void setNumeroGeneracion(Integer numeroGeneracion){this.numeroGeneracion=numeroGeneracion;}
		
	public String getEstado() {return estado;}
      
	public void setEstado(String estado){this.estado=estado;}
		
	public Date getFechaGeneracion() {return fechaGeneracion;}
      
	public void setFechaGeneracion(Date fechaGeneracion){this.fechaGeneracion=fechaGeneracion;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getAcceso() {return acceso;}
      
	public void setAcceso(Long acceso){this.acceso=acceso;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getVentaOrigen() {return ventaOrigen;}
      
	public void setVentaOrigen(Long ventaOrigen){this.ventaOrigen=ventaOrigen;}
		
	public Long getVentaDestino() {return ventaDestino;}
      
	public void setVentaDestino(Long ventaDestino){this.ventaDestino=ventaDestino;}
		
	public Long getTipoOperacion() {return tipoOperacion;}
      
	public void setTipoOperacion(Long tipoOperacion){this.tipoOperacion=tipoOperacion;}
			
	
}
