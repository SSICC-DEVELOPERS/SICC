package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_FORMA_PAGO")
public class FormaPagoCabeceraLocal implements Serializable {

	public FormaPagoCabeceraLocal() {}

	public FormaPagoCabeceraLocal(Long oid, String codigoFormaPago, Long pais)	{
		this.oid=oid;
                this.codigoFormaPago = codigoFormaPago;
                this.pais = pais;
	}

	@Id
	@Column(name="OID_FORM_PAGO")
	private Long oid;
	@Column(name="COD_FORM_PAGO")
	private String codigoFormaPago;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoFormaPago() {return codigoFormaPago;}
      
	public void setCodigoFormaPago(String codigoFormaPago){this.codigoFormaPago=codigoFormaPago;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
