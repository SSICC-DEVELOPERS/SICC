package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_ESTAT_PRODU")
@NamedQueries({
@NamedQuery(name="EstatusLocal.FindAll",query="select object(o) from EstatusLocal o"),
@NamedQuery(name="EstatusLocal.FindByUk",query="SELECT OBJECT(e) "
+ " FROM EstatusLocal AS e "
+ " WHERE e.oidPais=?1 "
+ " AND e.codigoEstatus = ?2")
})
public class EstatusLocal implements Serializable {

	public EstatusLocal() {}

	public EstatusLocal(Long oid, String codEstaProd, Long paisOidPais)	{
            this.oid = oid;
            this.codigoEstatus = codEstaProd;
            this.oidPais = paisOidPais;
	}

	@Id
	@Column(name="OID_ESTA_PROD")
	private Long oid;
	@Column(name="COD_ESTA_PROD")
	private String codigoEstatus;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoEstatus() {return codigoEstatus;}
      
	public void setCodigoEstatus(String codigoEstatus){this.codigoEstatus=codigoEstatus;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
			
	
}
