package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="INC_PARAM_NIVEL_PREMI")
@NamedQueries({
@NamedQuery(name="ParametrosNivelPremiacionLocal.FindAll",query="select object(o) from ParametrosNivelPremiacionLocal o"),
@NamedQuery(name="ParametrosNivelPremiacionLocal.FindByParametroGeneralPremiacion",query="SELECT OBJECT(a) "
+ " FROM ParametrosNivelPremiacionLocal AS a "
+ " WHERE a.premiacion = ?1"),
@NamedQuery(name="ParametrosNivelPremiacionLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM ParametrosNivelPremiacionLocal AS a  "
+ " WHERE a.numeroNivel = ?1 and "
+ " a.premiacion = ?2")
})
public class ParametrosNivelPremiacionLocal implements Serializable {

	public ParametrosNivelPremiacionLocal() {}

	public ParametrosNivelPremiacionLocal(Long oid, Integer numNive, Long pagpOidParaGenePrem, Long tpreOidTipoPrem, Date fechaUltimaActualizacion)	{
	
		this.oid=oid;
                this.setNumeroNivel(numNive);
	        this.setPremiacion(pagpOidParaGenePrem);
	        this.setTipoPremio(tpreOidTipoPrem);
	        this.setFechaUltimaActualizacion(fechaUltimaActualizacion);
	
	}

	@Id
	@Column(name="OID_PARA_NIVE_PREM")
	private Long oid;
	@Column(name="NUM_NIVE")
	private Integer numeroNivel;
	@Column(name="NUM_CANT_FIJA_PUNT")
	private Integer cantidadFijaPuntos;
	@Column(name="NUM_CANT_INIC_PUNT")
	private Integer cantidadInicialPuntos;
	@Column(name="NUM_CANT_FINA_PUNT")
	private Integer cantidadFinalPuntos;
	@Column(name="VAL_NIVE_SELE")
	private Boolean nivelSelectivo;
	@Column(name="VAL_PUNT_SERV")
	private Integer puntajeServicio;
	@Column(name="NUM_ASPI")
	private Integer numeroAspirantes;
	@Column(name="PAGP_OID_PARA_GENE_PREM")
	private Long premiacion;
	@Column(name="TPRE_OID_TIPO_PREM")
	private Long tipoPremio;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fechaUltimaActualizacion;
	@Column(name="NUM_PUNT_PROD_EXIG")
	private Integer puntosProductosExigidos;
        // vbongiov -- Cambio 20090930 -- 16/07/2009
        @Column(name="VAL_DESC")
        private String descripcionNivel;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroNivel() {return numeroNivel;}
      
	public void setNumeroNivel(Integer numeroNivel){this.numeroNivel=numeroNivel;}
		
	public Integer getCantidadFijaPuntos() {return cantidadFijaPuntos;}
      
	public void setCantidadFijaPuntos(Integer cantidadFijaPuntos){this.cantidadFijaPuntos=cantidadFijaPuntos;}
		
	public Integer getCantidadInicialPuntos() {return cantidadInicialPuntos;}
      
	public void setCantidadInicialPuntos(Integer cantidadInicialPuntos){this.cantidadInicialPuntos=cantidadInicialPuntos;}
		
	public Integer getCantidadFinalPuntos() {return cantidadFinalPuntos;}
      
	public void setCantidadFinalPuntos(Integer cantidadFinalPuntos){this.cantidadFinalPuntos=cantidadFinalPuntos;}
		
	public Boolean getNivelSelectivo() {return nivelSelectivo;}
      
	public void setNivelSelectivo(Boolean nivelSelectivo){this.nivelSelectivo=nivelSelectivo;}
		
	public Integer getPuntajeServicio() {return puntajeServicio;}
      
	public void setPuntajeServicio(Integer puntajeServicio){this.puntajeServicio=puntajeServicio;}
		
	public Integer getNumeroAspirantes() {return numeroAspirantes;}
      
	public void setNumeroAspirantes(Integer numeroAspirantes){this.numeroAspirantes=numeroAspirantes;}
		
	public Long getPremiacion() {return premiacion;}
      
	public void setPremiacion(Long premiacion){this.premiacion=premiacion;}
		
	public Long getTipoPremio() {return tipoPremio;}
      
	public void setTipoPremio(Long tipoPremio){this.tipoPremio=tipoPremio;}
		
	public java.sql.Date getFechaUltimaActualizacion() {return fechaUltimaActualizacion;}
      
	public void setFechaUltimaActualizacion(java.sql.Date fechaUltimaActualizacion){this.fechaUltimaActualizacion=fechaUltimaActualizacion;}
		
	public Integer getPuntosProductosExigidos() {return puntosProductosExigidos;}
      
	public void setPuntosProductosExigidos(Integer puntosProductosExigidos){this.puntosProductosExigidos=puntosProductosExigidos;}
        
        public String getDescripcionNivel() {return descripcionNivel;}
        
        public void setDescripcionNivel(String descripcionNivel){this.descripcionNivel=descripcionNivel;}
			
        
	
}
