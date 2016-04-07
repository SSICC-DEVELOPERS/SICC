package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="MAE_CODIG_CLIEN_ANTER")
@NamedQueries({
@NamedQuery(name="CodigosClientesAnterioresLocal.FindAll",query="select object(o) from CodigosClientesAnterioresLocal o"),
@NamedQuery(name="CodigosClientesAnterioresLocal.FindByUk",query="SELECT OBJECT(c) FROM CodigosClientesAnterioresLocal c "
+ " WHERE c.clieOidClieNuev = ?1")
})
public class CodigosClientesAnterioresLocal implements Serializable {

	public CodigosClientesAnterioresLocal() {}

	public CodigosClientesAnterioresLocal(Long oid, Long clieOidClieNuev, String codClieAnti, Long paisOidPais, Timestamp fecUltiActu)	{
            this.oid=oid;
            this.clieOidClieNuev = clieOidClieNuev;
            this.codClieAnti = codClieAnti;
            this.paisOidPais = paisOidPais;
            this.fecUltiActu = fecUltiActu;
	}

	@Id
	@Column(name="OID_CODI_CLIE_ANTE")
	private Long oid;
	@Column(name="CLIE_OID_CLIE_NUEV")
	private Long clieOidClieNuev;
	@Column(name="VAL_SIST_PROC")
	private String valSistProc;
	@Column(name="COD_CLIE_ANTI")
	private String codClieAnti;
	@Column(name="PAIS_OID_PAIS")
	private Long paisOidPais;
	@Column(name="FEC_ULTI_ACTU")
	private Timestamp fecUltiActu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClieOidClieNuev() {return clieOidClieNuev;}
      
	public void setClieOidClieNuev(Long clieOidClieNuev){this.clieOidClieNuev=clieOidClieNuev;}
		
	public String getValSistProc() {return valSistProc;}
      
	public void setValSistProc(String valSistProc){this.valSistProc=valSistProc;}
		
	public String getCodClieAnti() {return codClieAnti;}
      
	public void setCodClieAnti(String codClieAnti){this.codClieAnti=codClieAnti;}
		
	public Long getPaisOidPais() {return paisOidPais;}
      
	public void setPaisOidPais(Long paisOidPais){this.paisOidPais=paisOidPais;}
		
	public Timestamp getFecUltiActu() {return fecUltiActu;}
      
	public void setFecUltiActu(Timestamp fecUltiActu){this.fecUltiActu=fecUltiActu;}
			
	
}
