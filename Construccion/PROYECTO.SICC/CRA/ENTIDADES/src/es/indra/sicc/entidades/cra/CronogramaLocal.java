package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="CRA_CRONO")
public class CronogramaLocal implements Serializable {

	public CronogramaLocal() {}

	public CronogramaLocal(Long oid, Long perd_oid_peri, Long cact_oid_acti, 
                                Long cod_tipo_fact, Timestamp fec_inic, Long zzon_oid_zona, 
                                Boolean indFija, Boolean tipoDias, Long fecha0, Integer cod_vist)	{
	
		this.oid=oid;
                this.periodo = perd_oid_peri;
                this.actividad = cact_oid_acti;
                this.tipoFacturacion = cod_tipo_fact;
                this.fechaInicio = fec_inic;
                this.zona = zzon_oid_zona;
                this.indFija = indFija;
                this.tipoDias = tipoDias;
                this.fecha0 = fecha0;
                this.idVista = cod_vist;
	}

	@Id
	@Column(name="OID_CRON")
	private Long oid;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="CACT_OID_ACTI")
	private Long actividad;
	@Column(name="TIFA_OID_TIPO_FACT")
	private Long tipoFacturacion;
	@Column(name="COD_TIPO_DIAS")
	private Boolean tipoDias;
	@Column(name="FEC_INIC")
	private java.sql.Timestamp fechaInicio;
	@Column(name="FEC_MEDI")
	private Integer fechaMedia;
	@Column(name="FEC_FINA")
	private java.sql.Date fechaFinal;
	@Column(name="IND_FIJA")
	private Boolean indFija;
	@Column(name="VAL_FEC0")
	private Long fecha0;
	@Column(name="ZSCC_OID_SECC")
	private Long seccion;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="COD_VIST_ORIG")
	private Integer idVistaOrigen;
	@Column(name="COD_VIST")
	private Integer idVista;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getActividad() {return actividad;}
      
	public void setActividad(Long actividad){this.actividad=actividad;}
		
	public Long getTipoFacturacion() {return tipoFacturacion;}
      
	public void setTipoFacturacion(Long tipoFacturacion){this.tipoFacturacion=tipoFacturacion;}
		
	public Boolean getTipoDias() {return tipoDias;}
      
	public void setTipoDias(Boolean tipoDias){this.tipoDias=tipoDias;}
		
	public java.sql.Timestamp getFechaInicio() {return fechaInicio;}
      
	public void setFechaInicio(java.sql.Timestamp fechaInicio){this.fechaInicio=fechaInicio;}
		
	public Integer getFechaMedia() {return fechaMedia;}
      
	public void setFechaMedia(Integer fechaMedia){this.fechaMedia=fechaMedia;}
		
	public java.sql.Date getFechaFinal() {return fechaFinal;}
      
	public void setFechaFinal(java.sql.Date fechaFinal){this.fechaFinal=fechaFinal;}
		
	public Boolean getIndFija() {return indFija;}
      
	public void setIndFija(Boolean indFija){this.indFija=indFija;}
		
	public Long getFecha0() {return fecha0;}
      
	public void setFecha0(Long fecha0){this.fecha0=fecha0;}
		
	public Long getSeccion() {return seccion;}
      
	public void setSeccion(Long seccion){this.seccion=seccion;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Integer getIdVistaOrigen() {return idVistaOrigen;}
      
	public void setIdVistaOrigen(Integer idVistaOrigen){this.idVistaOrigen=idVistaOrigen;}
		
	public Integer getIdVista() {return idVista;}
      
	public void setIdVista(Integer idVista){this.idVista=idVista;}
			
	
}
