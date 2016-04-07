package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_USUAR_ETAPA_COBRA_DETAL")
@NamedQueries({
@NamedQuery(name="UsuariosEtapaCobranzaDetalleLocal.FindAll",query="select object(o) from UsuariosEtapaCobranzaDetalleLocal o")
})
public class UsuariosEtapaCobranzaDetalleLocal implements Serializable {

	public UsuariosEtapaCobranzaDetalleLocal() {}

	public UsuariosEtapaCobranzaDetalleLocal(Long oid, Long zsgvOidSubgVent, Long edtcOidEtapDeudTipoCarg, Long ueccOidUsuaEtapCobr, Long zorgOidRegi, Long zzonOidZona, Long zsccOidSecc, Long terrOidTerr, Long gacaOidGuioArguCabe, Long melcOidMetoLiquCobr)	{
	
		this.oid=oid;
                this.setZsgvOidSubgVent(zsgvOidSubgVent);
	        this.setEdtcOidEtapDeudTipoCarg(edtcOidEtapDeudTipoCarg);
	        this.setUeccOidUsuaEtapCobr(ueccOidUsuaEtapCobr);        
	        this.setZorgOidRegi(zorgOidRegi);
	        this.setZzonOidZona(zzonOidZona);
	        this.setZsccOidSecc(zsccOidSecc);
	        this.setTerrOidTerr(terrOidTerr);
	        this.setGacaOidGuioArguCabe(gacaOidGuioArguCabe);
	        this.setMelcOidMetoLiquCobr(melcOidMetoLiquCobr);
	
	}

	@Id
	@Column(name="OID_USUA_ETAP_COBR_DETA")
	private Long oid;
	@Column(name="ZSCC_OID_SECC")
	private Long zsccOidSecc;
	@Column(name="ZZON_OID_ZONA")
	private Long zzonOidZona;
	@Column(name="TERR_OID_TERR")
	private Long terrOidTerr;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long zsgvOidSubgVent;
	@Column(name="ZORG_OID_REGI")
	private Long zorgOidRegi;
	@Column(name="EDTC_OID_ETAP_DEUD_TIPO_CARG")
	private Long edtcOidEtapDeudTipoCarg;
	@Column(name="UECC_OID_USUA_ETAP_COBR")
	private Long ueccOidUsuaEtapCobr;
	@Column(name="MELC_OID_METO_LIQU_COBR")
	private Long melcOidMetoLiquCobr;
	@Column(name="EUCO_OID_ESTA_USUA_ETAP_COBR")
	private Long eucoOidEstaUsuaEtapCobr;
	@Column(name="GACA_OID_GUIO_ARGU_CABE")
	private Long gacaOidGuioArguCabe;
	@Column(name="VAL_OBSE")
	private String val_obse;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getZsccOidSecc() {return zsccOidSecc;}
      
	public void setZsccOidSecc(Long zsccOidSecc){this.zsccOidSecc=zsccOidSecc;}
		
	public Long getZzonOidZona() {return zzonOidZona;}
      
	public void setZzonOidZona(Long zzonOidZona){this.zzonOidZona=zzonOidZona;}
		
	public Long getTerrOidTerr() {return terrOidTerr;}
      
	public void setTerrOidTerr(Long terrOidTerr){this.terrOidTerr=terrOidTerr;}
		
	public Long getZsgvOidSubgVent() {return zsgvOidSubgVent;}
      
	public void setZsgvOidSubgVent(Long zsgvOidSubgVent){this.zsgvOidSubgVent=zsgvOidSubgVent;}
		
	public Long getZorgOidRegi() {return zorgOidRegi;}
      
	public void setZorgOidRegi(Long zorgOidRegi){this.zorgOidRegi=zorgOidRegi;}
		
	public Long getEdtcOidEtapDeudTipoCarg() {return edtcOidEtapDeudTipoCarg;}
      
	public void setEdtcOidEtapDeudTipoCarg(Long edtcOidEtapDeudTipoCarg){this.edtcOidEtapDeudTipoCarg=edtcOidEtapDeudTipoCarg;}
		
	public Long getUeccOidUsuaEtapCobr() {return ueccOidUsuaEtapCobr;}
      
	public void setUeccOidUsuaEtapCobr(Long ueccOidUsuaEtapCobr){this.ueccOidUsuaEtapCobr=ueccOidUsuaEtapCobr;}
		
	public Long getMelcOidMetoLiquCobr() {return melcOidMetoLiquCobr;}
      
	public void setMelcOidMetoLiquCobr(Long melcOidMetoLiquCobr){this.melcOidMetoLiquCobr=melcOidMetoLiquCobr;}
		
	public Long getEucoOidEstaUsuaEtapCobr() {return eucoOidEstaUsuaEtapCobr;}
      
	public void setEucoOidEstaUsuaEtapCobr(Long eucoOidEstaUsuaEtapCobr){this.eucoOidEstaUsuaEtapCobr=eucoOidEstaUsuaEtapCobr;}
		
	public Long getGacaOidGuioArguCabe() {return gacaOidGuioArguCabe;}
      
	public void setGacaOidGuioArguCabe(Long gacaOidGuioArguCabe){this.gacaOidGuioArguCabe=gacaOidGuioArguCabe;}
		
	public String getVal_obse() {return val_obse;}
      
	public void setVal_obse(String val_obse){this.val_obse=val_obse;}
			
	
}
