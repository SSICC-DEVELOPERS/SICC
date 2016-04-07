package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PARTI_CONCU_DETAL")
@NamedQueries({
@NamedQuery(name="ParticipantesConcursoDetalleLocal.FindAll",query="select object(o) from ParticipantesConcursoDetalleLocal o")
})
public class ParticipantesConcursoDetalleLocal implements Serializable {

	public ParticipantesConcursoDetalleLocal() {}

	public ParticipantesConcursoDetalleLocal(Long oid, Long oidCabecera, Long tipoCliente)	{
	
		this.oid=oid;
                this.setOidCabecera(oidCabecera);
                this.setTipoCliente(tipoCliente);
	
	}

	@Id
	@Column(name="OID_PART_CONC_DETA")
	private Long oid;
	@Column(name="PACI_OID_PART_CONC_CABE")
	private Long oidCabecera;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long subtipoCliente;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long tipoCliente;
	@Column(name="TCCL_OID_TIPO_CLAS")
	private Long tipoClasificacion;
	@Column(name="CLAS_OID_CLAS")
	private Long clasificacion;
	@Column(name="DES_DESC")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidCabecera() {return oidCabecera;}
      
	public void setOidCabecera(Long oidCabecera){this.oidCabecera=oidCabecera;}
		
	public Long getSubtipoCliente() {return subtipoCliente;}
      
	public void setSubtipoCliente(Long subtipoCliente){this.subtipoCliente=subtipoCliente;}
		
	public Long getTipoCliente() {return tipoCliente;}
      
	public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
		
	public Long getTipoClasificacion() {return tipoClasificacion;}
      
	public void setTipoClasificacion(Long tipoClasificacion){this.tipoClasificacion=tipoClasificacion;}
		
	public Long getClasificacion() {return clasificacion;}
      
	public void setClasificacion(Long clasificacion){this.clasificacion=clasificacion;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
