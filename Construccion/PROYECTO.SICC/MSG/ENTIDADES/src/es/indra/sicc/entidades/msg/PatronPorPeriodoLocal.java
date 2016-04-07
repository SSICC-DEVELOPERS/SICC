package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_PATRO_PERIO")
@NamedQueries({
@NamedQuery(name="PatronPorPeriodoLocal.FindByPatron",query="SELECT OBJECT(i) FROM PatronPorPeriodoLocal AS i WHERE i.oidPatron = ?1"),
@NamedQuery(name="PatronPorPeriodoLocal.FindByPatronOrigen",query="SELECT OBJECT(i) FROM PatronPorPeriodoLocal AS i WHERE i.oidPatronOrigen = ?1"),
@NamedQuery(name="PatronPorPeriodoLocal.FindByPatronPeriodo",query="SELECT OBJECT(a) FROM PatronPorPeriodoLocal AS a WHERE a.oidPatron = ?1 AND a.oidPeriodo = ?2")
})
public class PatronPorPeriodoLocal implements Serializable {

	public PatronPorPeriodoLocal() {}

	public PatronPorPeriodoLocal(Long oid, Long patr_oid_patr_orig, Long patr_oid_patr, Long peri_oid_peri)	{
            this.oid=oid;
	    this.oidPatronOrigen = patr_oid_patr_orig;
	    this.oidPatron = patr_oid_patr;
	    this.oidPeriodo = peri_oid_peri;
	}

	@Id
	@Column(name="OID_PATR_PERI")
	private Long oid;
	@Column(name="PATR_OID_PATR_ORIG")
	private Long oidPatronOrigen;
	@Column(name="PATR_OID_PATR")
	private Long oidPatron;
	@Column(name="PERI_OID_PERI")
	private Long oidPeriodo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPatronOrigen() {return oidPatronOrigen;}
      
	public void setOidPatronOrigen(Long oidPatronOrigen){this.oidPatronOrigen=oidPatronOrigen;}
		
	public Long getOidPatron() {return oidPatron;}
      
	public void setOidPatron(Long oidPatron){this.oidPatron=oidPatron;}
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
			
	
}
