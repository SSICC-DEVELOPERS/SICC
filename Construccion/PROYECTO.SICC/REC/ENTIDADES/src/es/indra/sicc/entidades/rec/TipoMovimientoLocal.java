package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_TIPO_MOVIM")
@NamedQueries({
@NamedQuery(name="TipoMovimientoLocal.FindAll",query="select object(o) from TipoMovimientoLocal o")
})
public class TipoMovimientoLocal implements Serializable {

	public TipoMovimientoLocal() {}

	public TipoMovimientoLocal(Long oid, String codTipoMovimiento)	{
	
		this.oid=oid;
                this.codTipoMovimiento=codTipoMovimiento;
	
	}

	@Id
	@Column(name="OID_TIPO_MOVI")
	private Long oid;
	@Column(name="COD_TIPO_MOVI")
	private String codTipoMovimiento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodTipoMovimiento() {return codTipoMovimiento;}
      
	public void setCodTipoMovimiento(String codTipoMovimiento){this.codTipoMovimiento=codTipoMovimiento;}
			
	
}
