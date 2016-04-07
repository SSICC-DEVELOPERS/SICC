package es.indra.sicc.entidades.fac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="FAC_FORMU_TIPO_SOLIC")
@NamedQueries({
@NamedQuery(name="FormulariosTipoSolicitudLocal.FindByTipoSolicitud",query="SELECT OBJECT(a) FROM FormulariosTipoSolicitudLocal AS a WHERE a.tipoSolicitud=?1")
})
public class FormulariosTipoSolicitudLocal implements Serializable {

	public FormulariosTipoSolicitudLocal() {}

	public FormulariosTipoSolicitudLocal(Long oid, Long formulario, Long tipoSolicitud, Short numOrdenSecuencia)	{
            this.oid=oid;
            this.formulario = formulario;
            this.tipoSolicitud = tipoSolicitud;
            this.numOrdenSecuencia = numOrdenSecuencia;
	}

	@Id
	@Column(name="OID_FORM_TIPO_SOLI")
	private Long oid;
	@Column(name="FORS_OID_FORM")
	private Long formulario;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitud;
	@Column(name="NUM_ORDE_SECU")
	private Short numOrdenSecuencia;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getFormulario() {return formulario;}
      
	public void setFormulario(Long formulario){this.formulario=formulario;}
		
	public Long getTipoSolicitud() {return tipoSolicitud;}
      
	public void setTipoSolicitud(Long tipoSolicitud){this.tipoSolicitud=tipoSolicitud;}
		
	public Short getNumOrdenSecuencia() {return numOrdenSecuencia;}
      
	public void setNumOrdenSecuencia(Short numOrdenSecuencia){this.numOrdenSecuencia=numOrdenSecuencia;}
			
	
}
