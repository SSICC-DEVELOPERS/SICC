package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_UNIDA_NEGOC")
@NamedQueries({
@NamedQuery(name="UnidadesNegocioLocal.FindAll",query="select object(o) from UnidadesNegocioLocal o"),
@NamedQuery(name="UnidadesNegocioLocal.FindByUk",query="SELECT OBJECT(u) "
+ " FROM UnidadesNegocioLocal AS u "
+ " WHERE u.oidPais=?1 "
+ " AND u.codigoUnidadNegocio=?2")
})
public class UnidadesNegocioLocal implements Serializable {

	public UnidadesNegocioLocal() {}

	public UnidadesNegocioLocal(Long oid, Long paisOidPais, String codUnidNego)	{
            this.oid=oid;
            this.oidPais = paisOidPais;
            this.codigoUnidadNegocio = codUnidNego;
	}

	@Id
	@Column(name="OID_UNID_NEGO")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="COD_UNID_NEGO")
	private String codigoUnidadNegocio;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public String getCodigoUnidadNegocio() {return codigoUnidadNegocio;}
      
	public void setCodigoUnidadNegocio(String codigoUnidadNegocio){this.codigoUnidadNegocio=codigoUnidadNegocio;}
			
	
}
