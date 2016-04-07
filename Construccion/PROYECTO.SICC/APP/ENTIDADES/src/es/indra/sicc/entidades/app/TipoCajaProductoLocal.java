package es.indra.sicc.entidades.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APP_TIPO_CAJA_PRODU")
@NamedQueries({
@NamedQuery(name="TipoCajaProductoLocal.FindAll",query="select object(o) from TipoCajaProductoLocal o")
})
public class TipoCajaProductoLocal implements Serializable {

	public TipoCajaProductoLocal() {}

	public TipoCajaProductoLocal(Long oid, String codCaja, Long paisOidPais)	{
            this.oid = oid;
            this.codigoCaja = codCaja;
            this.pais = paisOidPais;
	}

	@Id
	@Column(name="OID_TIPO_CAJA_PROD")
	private Long oid;
	@Column(name="COD_CAJA")
	private String codigoCaja;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoCaja() {return codigoCaja;}
      
	public void setCodigoCaja(String codigoCaja){this.codigoCaja=codigoCaja;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
