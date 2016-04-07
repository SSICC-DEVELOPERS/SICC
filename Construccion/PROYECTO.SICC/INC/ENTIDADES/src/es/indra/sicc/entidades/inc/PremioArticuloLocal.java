package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PREMI_ARTIC")
@NamedQueries({
@NamedQuery(name="PremioArticuloLocal.FindAll",query="select object(o) from PremioArticuloLocal o"),
@NamedQuery(name="PremioArticuloLocal.FindByParametroNivelPremiacion",query="SELECT OBJECT(a) "
+ " FROM PremioArticuloLocal AS a "
+ " WHERE a.nivelPremiacion = ?1"),
@NamedQuery(name="PremioArticuloLocal.FindByUK",query="SELECT OBJECT(o) FROM PremioArticuloLocal o WHERE o.nivelPremiacion = ?1")
})
public class PremioArticuloLocal implements Serializable {

	public PremioArticuloLocal() {}

	public PremioArticuloLocal(Long oid, Integer numUnid, Long panpOidParaNivePrem)	{
	
		this.oid=oid;
                this.setNumeroUnidades(numUnid);
	        this.setNivelPremiacion(panpOidParaNivePrem);
	
	}

	@Id
	@Column(name="OID_PREM_ARTI")
	private Long oid;
	@Column(name="NUM_UNID")
	private Integer numeroUnidades;
	@Column(name="PANP_OID_PARA_NIVE_PREM")
	private Long nivelPremiacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroUnidades() {return numeroUnidades;}
      
	public void setNumeroUnidades(Integer numeroUnidades){this.numeroUnidades=numeroUnidades;}
		
	public Long getNivelPremiacion() {return nivelPremiacion;}
      
	public void setNivelPremiacion(Long nivelPremiacion){this.nivelPremiacion=nivelPremiacion;}
			
	
}
