package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_VENTA_RANKI_GEREN")
@NamedQueries({
@NamedQuery(name="VentasRankingGerentesLocal.FindAll",query="select object(o) from VentasRankingGerentesLocal o"),
@NamedQuery(name="VentasRankingGerentesLocal.FindByUK",query="SELECT OBJECT(o) FROM VentasRankingGerentesLocal o WHERE o.zona = ?1 AND o.concurso = ?2 AND o.seccion = ?3 AND o.subgerencia = ?4 AND o.cliente = ?5 AND o.region = ?6")
})
public class VentasRankingGerentesLocal implements Serializable {

	public VentasRankingGerentesLocal() {}

	public VentasRankingGerentesLocal(Long oid, Long zzonOidZona, Long copaOidParaGral, Long zsccOidSecc, Long zsgvOidSubgVent, Long clieOidClie, Long regiOidRegi)	{
	
		this.oid=oid;
                this.setZona(zzonOidZona);
                this.setConcurso(copaOidParaGral);
                this.setSeccion(zsccOidSecc);
                this.setSubgerencia(zsgvOidSubgVent);
                this.setCliente(clieOidClie);
                this.setRegion(regiOidRegi);
	
	}

	@Id
	@Column(name="OID_VENT_RANK_GERE")
	private Long oid;
	@Column(name="IMP_VENT")
	private Double importeVentas;
	@Column(name="NUM_UNID")
	private Long unidades;
	@Column(name="NUM_ACTI_INIC")
	private Long activasIniciales;
	@Column(name="NUM_ACTI_FINA")
	private Long activasFinales;
	@Column(name="NUM_PEDI")
	private Double numeroPedidos;
	@Column(name="VAL_PORC_ACTI")
	private Double porcentajeActividad;
	@Column(name="VAL_CONS")
	private Double constancia;
	@Column(name="IMP_INGR")
	private Double ingresos;
	@Column(name="IMP_REIN")
	private Double reingresos;
	@Column(name="IMP_EGRE")
	private Double egresos;
	@Column(name="VAL_ENTR")
	private Double entregadas;
	@Column(name="VAL_RECI")
	private Double recibidas;
	@Column(name="IMP_CAPI")
	private Double capitalizacion;
	@Column(name="VAL_PPU")
	private Double ppu;
	@Column(name="VAL_PVP")
	private Double pvp;
	@Column(name="VAL_PUP")
	private Double pup;
	@Column(name="VAL_POP")
	private Double pop;
	@Column(name="IMP_RETE")
	private Double retencion;
	@Column(name="IMP_COBR")
	private Double cobranza;
	@Column(name="VAL_ROTA")
	private Double rotacion;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="ZSCC_OID_SECC")
	private Long seccion;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long subgerencia;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="ZORG_OID_REGI")
	private Long region;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Double getImporteVentas() {return importeVentas;}
      
	public void setImporteVentas(Double importeVentas){this.importeVentas=importeVentas;}
		
	public Long getUnidades() {return unidades;}
      
	public void setUnidades(Long unidades){this.unidades=unidades;}
		
	public Long getActivasIniciales() {return activasIniciales;}
      
	public void setActivasIniciales(Long activasIniciales){this.activasIniciales=activasIniciales;}
		
	public Long getActivasFinales() {return activasFinales;}
      
	public void setActivasFinales(Long activasFinales){this.activasFinales=activasFinales;}
		
	public Double getNumeroPedidos() {return numeroPedidos;}
      
	public void setNumeroPedidos(Double numeroPedidos){this.numeroPedidos=numeroPedidos;}
		
	public Double getPorcentajeActividad() {return porcentajeActividad;}
      
	public void setPorcentajeActividad(Double porcentajeActividad){this.porcentajeActividad=porcentajeActividad;}
		
	public Double getConstancia() {return constancia;}
      
	public void setConstancia(Double constancia){this.constancia=constancia;}
		
	public Double getIngresos() {return ingresos;}
      
	public void setIngresos(Double ingresos){this.ingresos=ingresos;}
		
	public Double getReingresos() {return reingresos;}
      
	public void setReingresos(Double reingresos){this.reingresos=reingresos;}
		
	public Double getEgresos() {return egresos;}
      
	public void setEgresos(Double egresos){this.egresos=egresos;}
		
	public Double getEntregadas() {return entregadas;}
      
	public void setEntregadas(Double entregadas){this.entregadas=entregadas;}
		
	public Double getRecibidas() {return recibidas;}
      
	public void setRecibidas(Double recibidas){this.recibidas=recibidas;}
		
	public Double getCapitalizacion() {return capitalizacion;}
      
	public void setCapitalizacion(Double capitalizacion){this.capitalizacion=capitalizacion;}
		
	public Double getPpu() {return ppu;}
      
	public void setPpu(Double ppu){this.ppu=ppu;}
		
	public Double getPvp() {return pvp;}
      
	public void setPvp(Double pvp){this.pvp=pvp;}
		
	public Double getPup() {return pup;}
      
	public void setPup(Double pup){this.pup=pup;}
		
	public Double getPop() {return pop;}
      
	public void setPop(Double pop){this.pop=pop;}
		
	public Double getRetencion() {return retencion;}
      
	public void setRetencion(Double retencion){this.retencion=retencion;}
		
	public Double getCobranza() {return cobranza;}
      
	public void setCobranza(Double cobranza){this.cobranza=cobranza;}
		
	public Double getRotacion() {return rotacion;}
      
	public void setRotacion(Double rotacion){this.rotacion=rotacion;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getSeccion() {return seccion;}
      
	public void setSeccion(Long seccion){this.seccion=seccion;}
		
	public Long getSubgerencia() {return subgerencia;}
      
	public void setSubgerencia(Long subgerencia){this.subgerencia=subgerencia;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
			
	
}
