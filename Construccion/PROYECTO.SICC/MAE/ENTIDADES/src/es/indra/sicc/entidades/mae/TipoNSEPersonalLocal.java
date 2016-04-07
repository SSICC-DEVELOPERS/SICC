package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_TIPO_NIVEL_SOCEC_PERSO")
@NamedQueries({
@NamedQuery(name="TipoNSEPersonalLocal.FindAll", query="SELECT OBJECT(o) FROM TipoNSEPersonalLocal AS o")
})
public class TipoNSEPersonalLocal implements Serializable {

	public TipoNSEPersonalLocal() {}

	public TipoNSEPersonalLocal(Long oid, String cod_nsep, Long pais_oid_pais) {
            this.oid=oid;
            this.codigoTipoNSEP = cod_nsep;
            this.oidPais = pais_oid_pais;
	}

	@Id
	@Column(name="OID_NSEP")
	private Long oid;
	@Column(name="COD_NSEP")
	private String codigoTipoNSEP;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoTipoNSEP() {return codigoTipoNSEP;}
      
	public void setCodigoTipoNSEP(String codigoTipoNSEP){this.codigoTipoNSEP=codigoTipoNSEP;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
			
	
}
