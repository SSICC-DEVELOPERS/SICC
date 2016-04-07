package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_CLIEN_A_CHEQU")
@NamedQueries({
@NamedQuery(name="ClientesAChequearLocal.FindByUK",query="SELECT OBJECT(s) FROM ClientesAChequearLocal s WHERE s.cliente = ?1 AND s.periodo =?2 AND s.tipoRevision =?3"),
@NamedQuery(name="ClientesAChequearLocal.FindByPeriodoTipoChequeo",query="SELECT OBJECT(s) FROM ClientesAChequearLocal s WHERE s.periodo =?1 AND s.tipoRevision =?2"),
@NamedQuery(name="ClientesAChequearLocal.FindAll",query="select object(o) from ClientesAChequearLocal o")
})
public class ClientesAChequearLocal implements Serializable {

	public ClientesAChequearLocal() {}

	public ClientesAChequearLocal(Long oid, Long tipoRevision, Long cliente, Long periodo)	{
	
		this.oid=oid;
                this.tipoRevision=tipoRevision;
                this.cliente=cliente;
                this.periodo=periodo;
	
	}

	@Id
	@Column(name="OID_CLIE_A_CHEQ")
	private Long oid;
	@Column(name="INRE_OID_INDI_REVI")
	private Long tipoRevision;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="PERD_OID_PERI")
	private Long periodo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getTipoRevision() {return tipoRevision;}
      
	public void setTipoRevision(Long tipoRevision){this.tipoRevision=tipoRevision;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
			
	
}
