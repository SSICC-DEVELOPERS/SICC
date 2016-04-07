package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_TIPO_CAJA")
@NamedQueries({
@NamedQuery(name="TipoCajaLocal.FindByUK",query="SELECT OBJECT(a) FROM TipoCajaLocal AS a WHERE a.codigo = ?1")
})
public class TipoCajaLocal implements Serializable {

	public TipoCajaLocal() {}

	public TipoCajaLocal(Long oid, String cod_tipo_caja)	{
		this.oid=oid;
                this.codigo = cod_tipo_caja;
	}

	@Id
	@Column(name="OID_TIPO_CAJA")
	private Long oid;
	@Column(name="COD_TIPO_CAJA")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
