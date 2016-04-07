package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_SUBTI_CLIEN")
@NamedQueries({
@NamedQuery(name="SubtipoClienteLocal.FindAll",query="select object(o) from SubtipoClienteLocal o"),
@NamedQuery(name="SubtipoClienteLocal.FindByUK",query="select object(s) from SubtipoClienteLocal s where s.codigo = ?1 and s.tipoCliente = ?2")
})
public class SubtipoClienteLocal implements Serializable {

	public SubtipoClienteLocal() {}

	public SubtipoClienteLocal(Long oid, String codigo, Long tipoCliente)	{
            this.oid=oid;
            this.codigo = codigo;
            this.tipoCliente = tipoCliente;
	}

	@Id
	@Column(name="OID_SUBT_CLIE")
	private Long oid;
	@Column(name="COD_SUBT_CLIE")
	private String codigo;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long tipoCliente;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Long getTipoCliente() {return tipoCliente;}
      
	public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
			
	
}
