package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_USUAR_ETAPA_COBRA_CABEC")
@NamedQueries({
@NamedQuery(name="UsuariosEtapaCobranzaCabeceraLocal.FindAll",query="select object(o) from UsuariosEtapaCobranzaCabeceraLocal o")
})
public class UsuariosEtapaCobranzaCabeceraLocal implements Serializable {

	public UsuariosEtapaCobranzaCabeceraLocal() {}

	public UsuariosEtapaCobranzaCabeceraLocal(Long oid, Long uscoOidUsuaCobr, Long etdeOidEtapDeud)	{
	
		this.oid=oid;
                this.setUscoOidUsuaCobr(uscoOidUsuaCobr);
	        this.setEtdeOidEtapDeud(etdeOidEtapDeud);      
	
	}

	@Id
	@Column(name="OID_USUA_ETAP_COBR")
	private Long oid;
	@Column(name="VAL_OBSE")
	private String valObse;
	@Column(name="USCO_OID_USUA_COBR")
	private Long uscoOidUsuaCobr;
	@Column(name="ETDE_OID_ETAP_DEUD")
	private Long etdeOidEtapDeud;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getValObse() {return valObse;}
      
	public void setValObse(String valObse){this.valObse=valObse;}
		
	public Long getUscoOidUsuaCobr() {return uscoOidUsuaCobr;}
      
	public void setUscoOidUsuaCobr(Long uscoOidUsuaCobr){this.uscoOidUsuaCobr=uscoOidUsuaCobr;}
		
	public Long getEtdeOidEtapDeud() {return etdeOidEtapDeud;}
      
	public void setEtdeOidEtapDeud(Long etdeOidEtapDeud){this.etdeOidEtapDeud=etdeOidEtapDeud;}
			
	
}
