package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_TIPO_DIREC_REPAR")
@NamedQueries({
@NamedQuery(name="TipoDireccionRepartoLocal.FindAll",query="select object(o) from TipoDireccionRepartoLocal o"),
@NamedQuery(name="TipoDireccionRepartoLocal.FindByUk",query="SELECT OBJECT(o) FROM TipoDireccionRepartoLocal AS o WHERE o.codigo = ?1")
})
public class TipoDireccionRepartoLocal implements Serializable {

	public TipoDireccionRepartoLocal() {}

	public TipoDireccionRepartoLocal(Long oid)	{
            this.oid=oid;
	}

	@Id
	@Column(name="OID_TIPO_DIRE_REPA")
	private Long oid;
	@Column(name="COD_TIPO_DIRE_REPA")
	private String codigo;
	@Column(name="VAL_DESC_TIPO_DIRE_REPA")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
