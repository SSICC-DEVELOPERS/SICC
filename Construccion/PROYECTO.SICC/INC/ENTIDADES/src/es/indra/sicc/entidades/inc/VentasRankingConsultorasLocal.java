package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_VENTA_RANKI_CONSU")
@NamedQueries({
@NamedQuery(name="VentasRankingConsultorasLocal.FindAll",query="select object(o) from VentasRankingConsultorasLocal o")
})
public class VentasRankingConsultorasLocal implements Serializable {

	public VentasRankingConsultorasLocal() {}

	public VentasRankingConsultorasLocal(Long oid, Double valCant,Long copaOidParaGral, Long vvrcOidVariVentRankConc, Long clieOidClie)	{
	
		this.oid=oid;
                this.setCantidad(valCant);
                this.setConcurso(copaOidParaGral);
                this.setVariable(vvrcOidVariVentRankConc);
                this.setCliente(clieOidClie);
	
	}

	@Id
	@Column(name="OID_VENT_RANK_CONS")
	private Long oid;
	@Column(name="VAL_CANT")
	private Double cantidad;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="VVRC_OID_VARI_VENT_RANK_CONC")
	private Long variable;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Double getCantidad() {return cantidad;}
      
	public void setCantidad(Double cantidad){this.cantidad=cantidad;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getVariable() {return variable;}
      
	public void setVariable(Long variable){this.variable=variable;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
			
	
}
