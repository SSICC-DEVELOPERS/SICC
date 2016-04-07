package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_ESTAT_CLIEN")
@NamedQueries({
@NamedQuery(name="EstatusClienteLocal.FindByCodigo", query="SELECT OBJECT(o) FROM EstatusClienteLocal AS o "
+ " WHERE o.cod_esta_clie = ?1"),
@NamedQuery(name="EstatusClienteLocal.FindAll", query="SELECT OBJECT(o) FROM EstatusClienteLocal AS o ")
})
public class EstatusClienteLocal implements Serializable {

	public EstatusClienteLocal() {}

	public EstatusClienteLocal(Long oid, String cod_esta_clie, Long tesc_oid_tipo_esta) {
            this.oid = oid;
            this.cod_esta_clie = cod_esta_clie;
            this.tesc_oid_tipo_esta = tesc_oid_tipo_esta;
	}

	@Id
	@Column(name="OID_ESTA_CLIE")
	private Long oid;
	@Column(name="COD_ESTA_CLIE")
	private String cod_esta_clie;
	@Column(name="TESC_OID_TIPO_ESTA")
	private Long tesc_oid_tipo_esta;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCod_esta_clie() {return cod_esta_clie;}
      
	public void setCod_esta_clie(String cod_esta_clie){this.cod_esta_clie=cod_esta_clie;}
		
	public Long getTesc_oid_tipo_esta() {return tesc_oid_tipo_esta;}
      
	public void setTesc_oid_tipo_esta(Long tesc_oid_tipo_esta){this.tesc_oid_tipo_esta=tesc_oid_tipo_esta;}
			
	
}
