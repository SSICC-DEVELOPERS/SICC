package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_TIPO_MEDIO_PAGO")
public class TipoMediosDePagoLocal implements Serializable {

	public TipoMediosDePagoLocal() {}

	public TipoMediosDePagoLocal(Long oid)	{
		this.oid=oid;
	}

	@Id
	@Column(name="OID_TIPO_MEDI_PAGO")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
