package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_TIPO_CLIEN")
@NamedQueries({
@NamedQuery(name="TipoClienteLocal.FindByUK",query="SELECT OBJECT(o) "
+ " FROM TipoClienteLocal AS o"
+ " WHERE o.cod_tipo_clie = ?1"),
@NamedQuery(name="TipoClienteLocal.FindAll",query="SELECT OBJECT(o) FROM TipoClienteLocal AS o")
})
public class TipoClienteLocal implements Serializable {

	public TipoClienteLocal() {}

	public TipoClienteLocal(Long oid, String cod_tipo_clie, Long ind_eval_esta)	{
            this.oid=oid;
            this.cod_tipo_clie = cod_tipo_clie;
            this.ind_eval_esta = ind_eval_esta;
	}

	@Id
	@Column(name="OID_TIPO_CLIE")
	private Long oid;
	@Column(name="COD_TIPO_CLIE")
	private String cod_tipo_clie;
	@Column(name="IND_EVAL_ESTA")
	private Long ind_eval_esta;
	@Column(name="IND_EMPL")
	private Long ind_empl;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCod_tipo_clie() {return cod_tipo_clie;}
      
	public void setCod_tipo_clie(String cod_tipo_clie){this.cod_tipo_clie=cod_tipo_clie;}
		
	public Long getInd_eval_esta() {return ind_eval_esta;}
      
	public void setInd_eval_esta(Long ind_eval_esta){this.ind_eval_esta=ind_eval_esta;}
		
	public Long getInd_empl() {return ind_empl;}
      
	public void setInd_empl(Long ind_empl){this.ind_empl=ind_empl;}
			
	
}
