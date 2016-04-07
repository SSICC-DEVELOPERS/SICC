package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_CLIEN")
@NamedQueries({
@NamedQuery(name="ComisionesClientesLocal.FindAll",query="select object(o) from ComisionesClientesLocal o"),
@NamedQuery(name="ComisionesClientesLocal.FindByComision",query="select object(c) from ComisionesClientesLocal c where c.comision = ?1")
})
public class ComisionesClientesLocal implements Serializable {

	public ComisionesClientesLocal() {}

	public ComisionesClientesLocal(Long oid, Long comision, Long tipoClienteComisionesCabecera, Integer codigoOrden)	{
	
		this.oid=oid;
                this.setComision(comision);
	        this.setTipoClienteComisionesCabecera(tipoClienteComisionesCabecera);
	        this.setCodigoOrden(codigoOrden);
	
	}

	@Id
	@Column(name="OID_COMI_CLIE")
	private Long oid;
	@Column(name="VAL_TOPE_MAXI")
	private java.math.BigDecimal topeMaximo;
	@Column(name="VAL_TOPE_MINI")
	private java.math.BigDecimal topeMinimo;
	@Column(name="FEC_ANTI_DESD")
	private java.sql.Date fecAntiguedadDesde;
	@Column(name="FEC_ANTI_HAST")
	private java.sql.Date fecAntiguedadHasta;
	@Column(name="COMI_OID_COMI")
	private Long comision;
	@Column(name="TCCC_OID_TIPO_CLIE_COMI_CABE")
	private Long tipoClienteComisionesCabecera;
	@Column(name="ZSCC_OID_SECC")
	private Long seccion;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long subgerenciaVentas;
	@Column(name="TERR_OID_TERR")
	private Long territorio;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="ZZON_OID_ZONA")
	private Long zonas;
	@Column(name="COD_ORDE")
	private Integer codigoOrden;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getTopeMaximo() {return topeMaximo;}
      
	public void setTopeMaximo(java.math.BigDecimal topeMaximo){this.topeMaximo=topeMaximo;}
		
	public java.math.BigDecimal getTopeMinimo() {return topeMinimo;}
      
	public void setTopeMinimo(java.math.BigDecimal topeMinimo){this.topeMinimo=topeMinimo;}
		
	public java.sql.Date getFecAntiguedadDesde() {return fecAntiguedadDesde;}
      
	public void setFecAntiguedadDesde(java.sql.Date fecAntiguedadDesde){this.fecAntiguedadDesde=fecAntiguedadDesde;}
		
	public java.sql.Date getFecAntiguedadHasta() {return fecAntiguedadHasta;}
      
	public void setFecAntiguedadHasta(java.sql.Date fecAntiguedadHasta){this.fecAntiguedadHasta=fecAntiguedadHasta;}
		
	public Long getComision() {return comision;}
      
	public void setComision(Long comision){this.comision=comision;}
		
	public Long getTipoClienteComisionesCabecera() {return tipoClienteComisionesCabecera;}
      
	public void setTipoClienteComisionesCabecera(Long tipoClienteComisionesCabecera){this.tipoClienteComisionesCabecera=tipoClienteComisionesCabecera;}
		
	public Long getSeccion() {return seccion;}
      
	public void setSeccion(Long seccion){this.seccion=seccion;}
		
	public Long getSubgerenciaVentas() {return subgerenciaVentas;}
      
	public void setSubgerenciaVentas(Long subgerenciaVentas){this.subgerenciaVentas=subgerenciaVentas;}
		
	public Long getTerritorio() {return territorio;}
      
	public void setTerritorio(Long territorio){this.territorio=territorio;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getZonas() {return zonas;}
      
	public void setZonas(Long zonas){this.zonas=zonas;}
		
	public Integer getCodigoOrden() {return codigoOrden;}
      
	public void setCodigoOrden(Integer codigoOrden){this.codigoOrden=codigoOrden;}
			
	
}
