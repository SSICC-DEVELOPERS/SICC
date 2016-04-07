package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_TIPO_VINCU")
@NamedQueries({
@NamedQuery(name="TipoVinculoLocal.FindByUK",query="SELECT OBJECT(o) "
+ " FROM TipoVinculoLocal AS o "
+ " WHERE o.pais_oid_pais = ?1 "
+ " AND o.cod_tipo_vinc = ?2"),
@NamedQuery(name="TipoVinculoLocal.FindAll",query="SELECT OBJECT(o) FROM TipoVinculoLocal AS o ")
})
public class TipoVinculoLocal implements Serializable {

	public TipoVinculoLocal() {}

	public TipoVinculoLocal(Long oid, Long pais_oid_pais, String cod_tipo_vinc, Long ind_reco) {
            this.oid=oid;
            this.pais_oid_pais = pais_oid_pais;
            this.cod_tipo_vinc = cod_tipo_vinc;
            this.ind_reco = ind_reco;
	}

	@Id
	@Column(name="OID_TIPO_VINC")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais_oid_pais;
	@Column(name="COD_TIPO_VINC")
	private String cod_tipo_vinc;
	@Column(name="IND_RECO")
	private Long ind_reco;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais_oid_pais() {return pais_oid_pais;}
      
	public void setPais_oid_pais(Long pais_oid_pais){this.pais_oid_pais=pais_oid_pais;}
		
	public String getCod_tipo_vinc() {return cod_tipo_vinc;}
      
	public void setCod_tipo_vinc(String cod_tipo_vinc){this.cod_tipo_vinc=cod_tipo_vinc;}
		
	public Long getInd_reco() {return ind_reco;}
      
	public void setInd_reco(Long ind_reco){this.ind_reco=ind_reco;}
			
	
}
