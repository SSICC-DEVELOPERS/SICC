package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_TIPO_MONTO_VENTA_RECOM")
@NamedQueries({
@NamedQuery(name="TipoMontoVentaRecomendadasLocal.FindAll",query="select object(o) from TipoMontoVentaRecomendadasLocal o")
})
public class TipoMontoVentaRecomendadasLocal implements Serializable {

	public TipoMontoVentaRecomendadasLocal() {}

	public TipoMontoVentaRecomendadasLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_TIPO_MONT_VENT_RECO")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
