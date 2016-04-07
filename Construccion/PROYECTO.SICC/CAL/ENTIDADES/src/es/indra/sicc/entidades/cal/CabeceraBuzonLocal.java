package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_CABEC_BUZON")
@NamedQueries({
@NamedQuery(name="CabeceraBuzonLocal.FindAll",query="select object(o) from CabeceraBuzonLocal o")

})
public class CabeceraBuzonLocal implements Serializable {

	public CabeceraBuzonLocal() {}

	public CabeceraBuzonLocal(Long oid, String cod_buzo, String cod_usua, String val_desc_cabe_buzo, Long pais_oid_pais)	{
	
		this.oid=oid;
	        setCodBuzon(cod_buzo);
	        setCodUsuario(cod_usua);
	        setDescripcion(val_desc_cabe_buzo);
	        setPais(pais_oid_pais);

	
	}

	@Id
	@Column(name="OID_CABE_BUZO")
	private Long oid;
	@Column(name="COD_BUZO")
	private String codBuzon;
	@Column(name="COD_USUA")
	private String codUsuario;
	@Column(name="VAL_DESC_CABE_BUZO")
	private String descripcion;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodBuzon() {return codBuzon;}
      
	public void setCodBuzon(String codBuzon){this.codBuzon=codBuzon;}
		
	public String getCodUsuario() {return codUsuario;}
      
	public void setCodUsuario(String codUsuario){this.codUsuario=codUsuario;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
