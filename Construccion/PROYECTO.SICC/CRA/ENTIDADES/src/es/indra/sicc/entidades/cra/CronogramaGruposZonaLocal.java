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
@Table(name="CRA_CRONO_GRUPO_ZONA")
public class CronogramaGruposZonaLocal implements Serializable {

	public CronogramaGruposZonaLocal() {}

	public CronogramaGruposZonaLocal(Long oid, Long perd_oid_peri, Long cgzo_oid_cabe_grup_zona,
                                    Long cact_oid_acti, Long cod_tipo_fact, Boolean tipoDias, 
                                    Long fecha0, Timestamp fecha_Prev, Integer cod_vist)	{
	
		this.oid=oid;
                this.periodo = perd_oid_peri;
                this.grupoZona = cgzo_oid_cabe_grup_zona;
                this.actividad = cact_oid_acti;
                this.tipoFacturacion = cod_tipo_fact;
                this.tipoDias = tipoDias;
                this.fecha0 = fecha0;
                this.fechaPrevista = fecha_Prev;
                this.idVista = cod_vist;
	}

	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Id
	@Column(name="OID_CRON_GRUP_ZONA")
	private Long oid;
	@Column(name="CGZO_OID_CABE_GRUP_ZONA")
	private Long grupoZona;
	@Column(name="CACT_OID_ACTI")
	private Long actividad;
	@Column(name="VAL_FEC0")
	private Long fecha0;
	@Column(name="FEC_MEDI")
	private Integer fechaMedia;
	@Column(name="FEC_FINA")
	private java.sql.Date fechaFinal;
	@Column(name="FEC_PREV")
	private java.sql.Timestamp fechaPrevista;
	@Column(name="TIFA_OID_TIPO_FACT")
	private Long tipoFacturacion;
	@Column(name="COD_TIPO_DIAS")
	private Boolean tipoDias;
	@Column(name="COD_VIST_ORIG")
	private Integer idVistaOrigen;
	@Column(name="COD_VIST")
	private Integer idVista;
	@Column(name="NUM_DIAS_DESP")
	private Integer numDiasDesplazamiento;
	@Column(name="PERD_OID_PERI_REFE")
	private Long oidPeriodoReferencia;

	
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getGrupoZona() {return grupoZona;}
      
	public void setGrupoZona(Long grupoZona){this.grupoZona=grupoZona;}
		
	public Long getActividad() {return actividad;}
      
	public void setActividad(Long actividad){this.actividad=actividad;}
		
	public Long getFecha0() {return fecha0;}
      
	public void setFecha0(Long fecha0){this.fecha0=fecha0;}
		
	public Integer getFechaMedia() {return fechaMedia;}
      
	public void setFechaMedia(Integer fechaMedia){this.fechaMedia=fechaMedia;}
		
	public java.sql.Date getFechaFinal() {return fechaFinal;}
      
	public void setFechaFinal(java.sql.Date fechaFinal){this.fechaFinal=fechaFinal;}
		
	public java.sql.Timestamp getFechaPrevista() {return fechaPrevista;}
      
	public void setFechaPrevista(java.sql.Timestamp fechaPrevista){this.fechaPrevista=fechaPrevista;}
		
	public Long getTipoFacturacion() {return tipoFacturacion;}
      
	public void setTipoFacturacion(Long tipoFacturacion){this.tipoFacturacion=tipoFacturacion;}
		
	public Boolean getTipoDias() {return tipoDias;}
      
	public void setTipoDias(Boolean tipoDias){this.tipoDias=tipoDias;}
		
	public Integer getIdVistaOrigen() {return idVistaOrigen;}
      
	public void setIdVistaOrigen(Integer idVistaOrigen){this.idVistaOrigen=idVistaOrigen;}
		
	public Integer getIdVista() {return idVista;}
      
	public void setIdVista(Integer idVista){this.idVista=idVista;}
		
	public Integer getNumDiasDesplazamiento() {return numDiasDesplazamiento;}
      
	public void setNumDiasDesplazamiento(Integer numDiasDesplazamiento){this.numDiasDesplazamiento=numDiasDesplazamiento;}
		
	public Long getOidPeriodoReferencia() {return oidPeriodoReferencia;}
      
	public void setOidPeriodoReferencia(Long oidPeriodoReferencia){this.oidPeriodoReferencia=oidPeriodoReferencia;}
			
	
}
