package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FAC_TIPO_OFERT_EXCLU")
public class TiposOfertaExcluidosLocal implements Serializable {

	public TiposOfertaExcluidosLocal() {}

	public TiposOfertaExcluidosLocal(Long oid, Long pais, Long tipoOferta, Timestamp fechaDesde, Timestamp fechaHasta)	{
            this.oid=oid;
	    this.pais = pais;
	    this.tipoOferta = tipoOferta;
	    this.fechaDesde = fechaDesde;
	    this.fechaHasta = fechaHasta;
	}

	@Id
	@Column(name="OID_TIPO_OFER_EXCL")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="FEC_DESD")
	private java.sql.Timestamp fechaDesde;
	@Column(name="FEC_HAST")
	private java.sql.Timestamp fechaHasta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public java.sql.Timestamp getFechaDesde() {return fechaDesde;}
      
	public void setFechaDesde(java.sql.Timestamp fechaDesde){this.fechaDesde=fechaDesde;}
		
	public java.sql.Timestamp getFechaHasta() {return fechaHasta;}
      
	public void setFechaHasta(java.sql.Timestamp fechaHasta){this.fechaHasta=fechaHasta;}
			
	
}
