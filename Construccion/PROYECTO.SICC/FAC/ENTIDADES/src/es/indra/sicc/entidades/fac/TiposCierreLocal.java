package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="FAC_TIPOS_CIERR")
@NamedQueries({
@NamedQuery(name="TiposCierreLocal.FindAll",query="select object(o) from TiposCierreLocal o")
})

public class TiposCierreLocal implements Serializable {

	public TiposCierreLocal() {}

	public TiposCierreLocal(Long oid, String codigo)	{
            this.oid=oid;
            this.codigo = codigo;
	}

	@Id
	@Column(name="OID_TIPO_CIER")
	private Long oid;
	@Column(name="COD_TIPO_CIER")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
