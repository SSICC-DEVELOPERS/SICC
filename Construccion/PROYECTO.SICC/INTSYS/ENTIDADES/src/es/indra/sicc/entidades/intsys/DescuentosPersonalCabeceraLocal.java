package es.indra.sicc.entidades.intsys;

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
@Table(name="INT_DESCU_PERSO_CABEC")
@NamedQueries({
@NamedQuery(name="DescuentosPersonalCabeceraLocal.FindAll",query="select object(o) from DescuentosPersonalCabeceraLocal o"),
@NamedQuery(name="DescuentosPersonalCabeceraLocal.FindByUK",query="SELECT OBJECT(o) FROM  DescuentosPersonalCabeceraLocal o WHERE o.pais = ?1 AND o.numeroDocumento = ?2")
})
public class DescuentosPersonalCabeceraLocal implements Serializable {

	public DescuentosPersonalCabeceraLocal() {}

	public DescuentosPersonalCabeceraLocal(Long oid, Long numeroDocumento, Date fechaCreacion, Long pais, Long acceso, Long estado, Long marca)	{
            this.oid=oid;
	    this.numeroDocumento=numeroDocumento;
	    this.fechaCreacion=fechaCreacion;
	    this.pais=pais;
	    this.acceso=acceso;
	    this.estado=estado;
	    this.marca=marca;
	}

	@Id
	@Column(name="OID_DESC_PERS_CABE")
	private Long oid;
	@Column(name="NUM_DOCU")
	private Long numeroDocumento;
	@Column(name="NUM_LOTE")
	private String numeroLote;
	@Column(name="VAL_DESC_LOTE")
	private String descripcion;
	@Column(name="VAL_OBSE")
	private String observaciones;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_CREA")
	private java.util.Date fechaCreacion;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="ACCE_OID_ACCE")
	private Long acceso;
	@Column(name="ESDE_OID_ESTA_DESC")
	private Long estado;
	@Column(name="MARC_OID_MARC")
	private Long marca;
        //@Temporal(TemporalType.DATE)
        @Column(name="FEC_VENC_DESD")
	private Date fechaVencimientoDesde;
        //@Temporal(TemporalType.DATE)
        @Column(name="FEC_VENC_HAST")
	private Date fechaVencimientoHasta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroDocumento() {return numeroDocumento;}
      
	public void setNumeroDocumento(Long numeroDocumento){this.numeroDocumento=numeroDocumento;}
		
	public String getNumeroLote() {return numeroLote;}
      
	public void setNumeroLote(String numeroLote){this.numeroLote=numeroLote;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public java.util.Date getFechaCreacion() {return fechaCreacion;}
      
	public void setFechaCreacion(java.util.Date fechaCreacion){this.fechaCreacion=fechaCreacion;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getAcceso() {return acceso;}
      
	public void setAcceso(Long acceso){this.acceso=acceso;}
		
	public Long getEstado() {return estado;}
      
	public void setEstado(Long estado){this.estado=estado;}
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Date getFechaVencimientoDesde() {return fechaVencimientoDesde;}
      
	public void setFechaVencimientoDesde(Date fechaVencimientoDesde){this.fechaVencimientoDesde=fechaVencimientoDesde;}
		
	public Date getFechaVencimientoHasta() {return fechaVencimientoHasta;}
      
	public void setFechaVencimientoHasta(Date fechaVencimientoHasta){this.fechaVencimientoHasta=fechaVencimientoHasta;}
			
	
}
