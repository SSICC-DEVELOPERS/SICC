package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_RESUL_RANKI")
@NamedQueries({
@NamedQuery(name="ResultadosRankingLocal.FindAll",query="select object(o) from ResultadosRankingLocal o")
})
public class ResultadosRankingLocal implements Serializable {

	public ResultadosRankingLocal() {}

	public ResultadosRankingLocal(Long oid, Long copaOidParaGral, Long perdOidPeri, Long clieOidClie, Long resultado)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
                this.setPeriodoEvaluacion(perdOidPeri);
                this.setCliente(clieOidClie);
                this.setResultado(resultado);
	
	}

	@Id
	@Column(name="OID_RESU_RANK")
	private Long oid;
	@Column(name="IMP_MONT_VENT")
	private Double montoVentas;
	@Column(name="NUM_UNID_VEND")
	private Long unidadesVendidas;
	@Column(name="NUM_PEDI")
	private Long numeroPedidos;
	@Column(name="NUM_RECO")
	private Long numeroRecomendadas;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PERD_OID_PERI")
	private Long periodoEvaluacion;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="TERR_OID_TERR")
	private Long territorio;
	@Column(name="ZSCC_OID_SECC")
	private Long seccion;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long subgerencia;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="BCAL_OID_BASE_CALC")
	private Long baseCalculo;
	@Column(name="DIRI_OID_DIRI")
	private Long dirigidoA;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="ITRR_OID_TIPO_RESU_RANK")
	private Long resultado;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Double getMontoVentas() {return montoVentas;}
      
	public void setMontoVentas(Double montoVentas){this.montoVentas=montoVentas;}
		
	public Long getUnidadesVendidas() {return unidadesVendidas;}
      
	public void setUnidadesVendidas(Long unidadesVendidas){this.unidadesVendidas=unidadesVendidas;}
		
	public Long getNumeroPedidos() {return numeroPedidos;}
      
	public void setNumeroPedidos(Long numeroPedidos){this.numeroPedidos=numeroPedidos;}
		
	public Long getNumeroRecomendadas() {return numeroRecomendadas;}
      
	public void setNumeroRecomendadas(Long numeroRecomendadas){this.numeroRecomendadas=numeroRecomendadas;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getPeriodoEvaluacion() {return periodoEvaluacion;}
      
	public void setPeriodoEvaluacion(Long periodoEvaluacion){this.periodoEvaluacion=periodoEvaluacion;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getTerritorio() {return territorio;}
      
	public void setTerritorio(Long territorio){this.territorio=territorio;}
		
	public Long getSeccion() {return seccion;}
      
	public void setSeccion(Long seccion){this.seccion=seccion;}
		
	public Long getSubgerencia() {return subgerencia;}
      
	public void setSubgerencia(Long subgerencia){this.subgerencia=subgerencia;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getBaseCalculo() {return baseCalculo;}
      
	public void setBaseCalculo(Long baseCalculo){this.baseCalculo=baseCalculo;}
		
	public Long getDirigidoA() {return dirigidoA;}
      
	public void setDirigidoA(Long dirigidoA){this.dirigidoA=dirigidoA;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getResultado() {return resultado;}
      
	public void setResultado(Long resultado){this.resultado=resultado;}
			
	
}
