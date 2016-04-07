package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_PARAM_GENER_CARTE")
@NamedQueries({
@NamedQuery(name="ParametrosGeneralesdeCarteraLocal.FindByPais",query="SELECT OBJECT(a) "
          + "  FROM ParametrosGeneralesdeCarteraLocal AS a "
          + "  WHERE a.oidPais = ?1")
})
public class ParametrosGeneralesdeCarteraLocal implements Serializable {

	public ParametrosGeneralesdeCarteraLocal() {}

	public ParametrosGeneralesdeCarteraLocal(Long oid,Long pais_oid_pais, Long inij_oid_indi_nive_jera, Long nire_oid_nive_redo, Long num_peri_nuev, Long num_peri_anti)	{
	
		this.oid=oid;
	        this.setOidPais(pais_oid_pais);
	        this.setOidIndicadorNivelJerarquia(inij_oid_indi_nive_jera);
	        this.setOidNivelRedondeo(nire_oid_nive_redo);
	        this.setNumeroPeriodosNue(num_peri_nuev);
	        this.setNumeroPeriodosAnt(num_peri_anti);
	
	}

	@Id
	@Column(name="OID_PARA_GENE_CART")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="INIJ_OID_INDI_NIVE_JERA")
	private Long oidIndicadorNivelJerarquia;
	@Column(name="NIRE_OID_NIVE_REDO")
	private Long oidNivelRedondeo;
	@Column(name="NUM_PERI_NUEV")
	private Long numeroPeriodosNue;
	@Column(name="NUM_PERI_ANTI")
	private Long numeroPeriodosAnt;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidIndicadorNivelJerarquia() {return oidIndicadorNivelJerarquia;}
      
	public void setOidIndicadorNivelJerarquia(Long oidIndicadorNivelJerarquia){this.oidIndicadorNivelJerarquia=oidIndicadorNivelJerarquia;}
		
	public Long getOidNivelRedondeo() {return oidNivelRedondeo;}
      
	public void setOidNivelRedondeo(Long oidNivelRedondeo){this.oidNivelRedondeo=oidNivelRedondeo;}
		
	public Long getNumeroPeriodosNue() {return numeroPeriodosNue;}
      
	public void setNumeroPeriodosNue(Long numeroPeriodosNue){this.numeroPeriodosNue=numeroPeriodosNue;}
		
	public Long getNumeroPeriodosAnt() {return numeroPeriodosAnt;}
      
	public void setNumeroPeriodosAnt(Long numeroPeriodosAnt){this.numeroPeriodosAnt=numeroPeriodosAnt;}
			
	
}
