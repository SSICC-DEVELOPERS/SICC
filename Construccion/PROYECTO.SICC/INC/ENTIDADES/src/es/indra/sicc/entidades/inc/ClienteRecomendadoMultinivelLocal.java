package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CLIEN_RECDO_MULTI")
@NamedQueries({
@NamedQuery(name="ClienteRecomendadoMultinivelLocal.FindAll",query="select object(o) from ClienteRecomendadoMultinivelLocal o"),
@NamedQuery(name="ClienteRecomendadoMultinivelLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM ClienteRecomendadoMultinivelLocal AS a "
+ " WHERE a.recomendado = ?1 "
+ " AND a.recomendanteMultinivel = ?2")
})
public class ClienteRecomendadoMultinivelLocal implements Serializable {

	public ClienteRecomendadoMultinivelLocal() {}

	public ClienteRecomendadoMultinivelLocal(Long oid, Long recomendado, Long recomendanteMultinivel, Long periodo)	{
	
		this.oid=oid;
                this.setRecomendado(recomendado);
                this.setRecomendanteMultinivel(recomendanteMultinivel);
                this.setPeriodo(periodo);
	
	}

	@Id
	@Column(name="OID_CLIE_RECO_MULT")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long recomendado;
	@Column(name="CLR2_CLIE_OID_CLIE")
	private Long recomendanteMultinivel;
	@Column(name="PERD_OID_PERI")
	private Long periodo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getRecomendado() {return recomendado;}
      
	public void setRecomendado(Long recomendado){this.recomendado=recomendado;}
		
	public Long getRecomendanteMultinivel() {return recomendanteMultinivel;}
      
	public void setRecomendanteMultinivel(Long recomendanteMultinivel){this.recomendanteMultinivel=recomendanteMultinivel;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
			
	
}
