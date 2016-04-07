package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CONTA_PREMI_ARTIC")
@NamedQueries({
@NamedQuery(name="ContadorPremioArticuloLocal.FindAll",query="select object(o) from ContadorPremioArticuloLocal o"),
@NamedQuery(name="ContadorPremioArticuloLocal.FindByPais",query="SELECT OBJECT(a) "
+ " FROM ContadorPremioArticuloLocal AS a "
+ " WHERE a.oidPais = ?1")
})
public class ContadorPremioArticuloLocal implements Serializable {

	public ContadorPremioArticuloLocal() {}

	public ContadorPremioArticuloLocal(Long oid, Long numRangoDesde, Long numRangoHasta, Long valUltimConta, Long paisOidPais)	{
	
		this.oid=oid;
                this.setRangoDesde(numRangoDesde);
	        this.setRangoHasta(numRangoHasta);
	        this.setUltimContador(valUltimConta);
	        this.setOidPais(paisOidPais);
	
	}

	@Id
	@Column(name="OID_CONTA_PREMI_ARTIC")
	private Long oid;
	@Column(name="NUM_RANGO_DESDE")
	private Long rangoDesde;
	@Column(name="NUM_RANGO_HASTA")
	private Long rangoHasta;
	@Column(name="VAL_ULTIM_CONTA")
	private Long ultimContador;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getRangoDesde() {return rangoDesde;}
      
	public void setRangoDesde(Long rangoDesde){this.rangoDesde=rangoDesde;}
		
	public Long getRangoHasta() {return rangoHasta;}
      
	public void setRangoHasta(Long rangoHasta){this.rangoHasta=rangoHasta;}
		
	public Long getUltimContador() {return ultimContador;}
      
	public void setUltimContador(Long ultimContador){this.ultimContador=ultimContador;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
			
	
}
