package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_NEGOC")
@NamedQueries({
@NamedQuery(name="NegocioLocal.FindAll",query="select object(o) from NegocioLocal o"),
@NamedQuery(name="NegocioLocal.FindByUk",query="SELECT OBJECT(n) "
+ " FROM NegocioLocal AS n "
+ " WHERE n.oidPais=?1 "
+ " AND n.codigoNegocio=?2")
})
public class NegocioLocal implements Serializable {

	public NegocioLocal() {}

	public NegocioLocal(Long oid, Long paisOidPais, String codNego)	{
            this.oid=oid;
            this.oidPais = paisOidPais;
            this.codigoNegocio = codNego;
	}

	@Id
	@Column(name="OID_NEGO")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="COD_NEGO")
	private String codigoNegocio;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public String getCodigoNegocio() {return codigoNegocio;}
      
	public void setCodigoNegocio(String codigoNegocio){this.codigoNegocio=codigoNegocio;}
			
	
}
