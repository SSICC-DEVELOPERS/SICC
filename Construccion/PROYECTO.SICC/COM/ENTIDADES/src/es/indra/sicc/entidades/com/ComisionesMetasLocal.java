package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_METAS")
@NamedQueries({
@NamedQuery(name="ComisionesMetasLocal.FindAll",query="select object(o) from ComisionesMetasLocal o"),
@NamedQuery(name="ComisionesMetasLocal.FindByUk",query="SELECT OBJECT(met) "
+ "  FROM ComisionesMetasLocal AS met "
+ "  WHERE met.comiOidComi = ?1 "
+ "  and met.perdOidPeri = ?2 "
+ "  and met.ctsuOidClieTipoSubt = ?3")
})
public class ComisionesMetasLocal implements Serializable {

	public ComisionesMetasLocal() {}

	public ComisionesMetasLocal(Long oid, Long perdOidPeri, Long comiOidComi, Long ctsuOidClieTipoSubt, Double impCalc)	{
	
		this.oid=oid;
                this.setPerdOidPeri(perdOidPeri);
                this.setComiOidComi(comiOidComi);
                this.setCtsuOidClieTipoSubt(ctsuOidClieTipoSubt);
                this.setImpCalc(impCalc);
	
	}

	@Id
	@Column(name="OID_COMI_META")
	private Long oid;
	@Column(name="PERD_OID_PERI")
	private Long perdOidPeri;
	@Column(name="COMI_OID_COMI")
	private Long comiOidComi;
	@Column(name="CTSU_OID_CLIE_TIPO_SUBT")
	private Long ctsuOidClieTipoSubt;
	@Column(name="IMP_CALC")
	private Double impCalc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPerdOidPeri() {return perdOidPeri;}
      
	public void setPerdOidPeri(Long perdOidPeri){this.perdOidPeri=perdOidPeri;}
		
	public Long getComiOidComi() {return comiOidComi;}
      
	public void setComiOidComi(Long comiOidComi){this.comiOidComi=comiOidComi;}
		
	public Long getCtsuOidClieTipoSubt() {return ctsuOidClieTipoSubt;}
      
	public void setCtsuOidClieTipoSubt(Long ctsuOidClieTipoSubt){this.ctsuOidClieTipoSubt=ctsuOidClieTipoSubt;}
		
	public Double getImpCalc() {return impCalc;}
      
	public void setImpCalc(Double impCalc){this.impCalc=impCalc;}
			
	
}
