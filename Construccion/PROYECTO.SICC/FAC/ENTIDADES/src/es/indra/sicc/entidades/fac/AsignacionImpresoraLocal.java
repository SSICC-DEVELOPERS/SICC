package es.indra.sicc.entidades.fac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="FAC_ASIGN_IMPRE")
@NamedQueries({
@NamedQuery(name="AsignacionImpresoraLocal.FindAll",query="select object(o) from AsignacionImpresoraLocal o"),
@NamedQuery(name="AsignacionImpresoraLocal.FindByUK",query="Select Object(a) from AsignacionImpresoraLocal a where a.subacceso = ?1 and a.formulario = ?2")
})
public class AsignacionImpresoraLocal implements Serializable {

	public AsignacionImpresoraLocal() {}

	public AsignacionImpresoraLocal(Long oid, Long impresoraVirtual, Long subacceso, Long formulario) {
            this.oid = oid;
	    this.impresoraVirtual = impresoraVirtual;
	    this.subacceso = subacceso;
	    this.formulario = formulario;
	}

	@Id
	@Column(name="OID_ASIG_IMPR")
	private Long oid;
	@Column(name="IMVI_OID_IMPR")
	private Long impresoraVirtual;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="FORS_OID_FORM")
	private Long formulario;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getImpresoraVirtual() {return impresoraVirtual;}
      
	public void setImpresoraVirtual(Long impresoraVirtual){this.impresoraVirtual=impresoraVirtual;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getFormulario() {return formulario;}
      
	public void setFormulario(Long formulario){this.formulario=formulario;}
			
	
}
