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
@Table(name="INC_PREMI_ELEGI")
@NamedQueries({
@NamedQuery(name="PremiosElegidosLocal.FindAll",query="select object(o) from PremiosElegidosLocal o"),
@NamedQuery(name="PremiosElegidosLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM PremiosElegidosLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class PremiosElegidosLocal implements Serializable {

	public PremiosElegidosLocal() {}

	public PremiosElegidosLocal(Long oid, Integer numPrem, Long clieOidClie, Long copaOidParaGral, Long panpOidParaNivePrem, Date fechaSistema)	{
	
		this.oid=oid;
                this.setNumeroPremio(numPrem);
	        this.setClienteGanador(clieOidClie);
	        this.setConcurso(copaOidParaGral);
	        this.setNivelPremiacion(panpOidParaNivePrem);
	        this.setFechaSistema(fechaSistema);
	
	}

	@Id
	@Column(name="OID_PREM_ELEG")
	private Long oid;
	@Column(name="NUM_PREM")
	private Integer numeroPremio;
	@Column(name="CLIE_OID_CLIE")
	private Long clienteGanador;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PANP_OID_PARA_NIVE_PREM")
	private Long nivelPremiacion;
	@Column(name="FEC_SIST")
	private java.sql.Date fechaSistema;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroPremio() {return numeroPremio;}
      
	public void setNumeroPremio(Integer numeroPremio){this.numeroPremio=numeroPremio;}
		
	public Long getClienteGanador() {return clienteGanador;}
      
	public void setClienteGanador(Long clienteGanador){this.clienteGanador=clienteGanador;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getNivelPremiacion() {return nivelPremiacion;}
      
	public void setNivelPremiacion(Long nivelPremiacion){this.nivelPremiacion=nivelPremiacion;}
		
	public java.sql.Date getFechaSistema() {return fechaSistema;}
      
	public void setFechaSistema(java.sql.Date fechaSistema){this.fechaSistema=fechaSistema;}
			
	
}
