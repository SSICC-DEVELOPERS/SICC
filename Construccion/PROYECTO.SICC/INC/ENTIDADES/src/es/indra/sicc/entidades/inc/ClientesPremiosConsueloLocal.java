package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CLIEN_PREMI_CONSU")
@NamedQueries({
@NamedQuery(name="ClientesPremiosConsueloLocal.FindAll",query="select object(o) from ClientesPremiosConsueloLocal o")
})
public class ClientesPremiosConsueloLocal implements Serializable {

	public ClientesPremiosConsueloLocal() {}

	public ClientesPremiosConsueloLocal(Long oidClientesPremioConsuelo, Long clieOidClie, Long prcoOidPremCons)	{
	
		this.oidClientesPremioConsuelo=oidClientesPremioConsuelo;
                this.setClieOidClie(clieOidClie);
                this.setPrcoOidPremCons(prcoOidPremCons);
	
	}

	@Column(name="CLIE_OID_CLIE")
	private Long clieOidClie;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long copaOidParaGral;
	@Column(name="PRCO_OID_PREM_CONS")
	private Long prcoOidPremCons;
	@Id
	@Column(name="OID_CLIENTES_PREMIO_CONSUELO")
	private Long oidClientesPremioConsuelo;

	
	public Long getClieOidClie() {return clieOidClie;}
      
	public void setClieOidClie(Long clieOidClie){this.clieOidClie=clieOidClie;}
		
	public Long getCopaOidParaGral() {return copaOidParaGral;}
      
	public void setCopaOidParaGral(Long copaOidParaGral){this.copaOidParaGral=copaOidParaGral;}
		
	public Long getPrcoOidPremCons() {return prcoOidPremCons;}
      
	public void setPrcoOidPremCons(Long prcoOidPremCons){this.prcoOidPremCons=prcoOidPremCons;}
		
	public Long getOidClientesPremioConsuelo() {return oidClientesPremioConsuelo;}
      
	//public void setOidClientesPremioConsuelo(Long oidClientesPremioConsuelo){this.oidClientesPremioConsuelo=oidClientesPremioConsuelo;}
	
	public Long getPrimaryKey() {return oidClientesPremioConsuelo;}		
			
	
}
