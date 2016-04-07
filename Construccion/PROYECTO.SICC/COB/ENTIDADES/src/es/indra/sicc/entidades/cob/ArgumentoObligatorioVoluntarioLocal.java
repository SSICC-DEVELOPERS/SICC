package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_ARGUM_OBLIG_VOLUN")
@NamedQueries({
@NamedQuery(name="ArgumentoObligatorioVoluntarioLocal.FindAll",query="select object(o) from ArgumentoObligatorioVoluntarioLocal o")
})
public class ArgumentoObligatorioVoluntarioLocal implements Serializable {

	public ArgumentoObligatorioVoluntarioLocal() {}

	public ArgumentoObligatorioVoluntarioLocal(Long oid, Character codigo)	{
	
		this.oid=oid;
                this.setCodigo(codigo);
	
	}

	@Id
	@Column(name="OID_ARGU_OBLI_VOLU")
	private Long oid;
	@Column(name="COD_ARGU_OBLI_VOLU")
	private Character codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Character getCodigo() {return codigo;}
      
	public void setCodigo(Character codigo){this.codigo=codigo;}
			
	
}
