package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_TIPO_PERMA")
public class TipoPermanenciaLocal implements Serializable {

	public TipoPermanenciaLocal() {}

	public TipoPermanenciaLocal(Long oid,String cod_tipo_perm)	{
	
		this.oid=oid;
                this.codigoTipoPermanencia=cod_tipo_perm;
	}

	@Id
	@Column(name="OID_TIPO_PERM")
	private Long oid;
	@Column(name="COD_TIPO_PERM")
	private String codigoTipoPermanencia;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoTipoPermanencia() {return codigoTipoPermanencia;}
      
	public void setCodigoTipoPermanencia(String codigoTipoPermanencia){this.codigoTipoPermanencia=codigoTipoPermanencia;}
			
	
}
