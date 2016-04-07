package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_AGRUP_STOCK_CABEC")
@NamedQueries({
@NamedQuery(name="AgrupacionStockCabeceraLocal.FindByClaveUnica",query="SELECT OBJECT(a) FROM AgrupacionStockCabeceraLocal AS a WHERE a.pais=?1 AND a.codigoASC=?2")
})
public class AgrupacionStockCabeceraLocal implements Serializable {

	public AgrupacionStockCabeceraLocal() {}

	public AgrupacionStockCabeceraLocal(Long oid, Long pais, String codigoASC, Boolean indicadorDefecto) {
		this.oid=oid;
                this.pais = pais;
                this.codigoASC = codigoASC;
                this.indicadorDefecto = indicadorDefecto;
	}

	@Id
	@Column(name="OID_AGRU_STOC_CABE")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_AGRU_STOC_CABE")
	private String codigoASC;
	@Column(name="IND_DEFE")
	private Boolean indicadorDefecto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigoASC() {return codigoASC;}
      
	public void setCodigoASC(String codigoASC){this.codigoASC=codigoASC;}
		
	public Boolean getIndicadorDefecto() {return indicadorDefecto;}
      
	public void setIndicadorDefecto(Boolean indicadorDefecto){this.indicadorDefecto=indicadorDefecto;}
			
	
}
