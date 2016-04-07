package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PREMI_CONSU")
@NamedQueries({
@NamedQuery(name="PremioConsueloLocal.FindAll",query="select object(o) from PremioConsueloLocal o")
})
public class PremioConsueloLocal implements Serializable {

	public PremioConsueloLocal() {}

	public PremioConsueloLocal(Long oid, Long numUnid, Long mopcOidMotiPremCons, Long enviOidEnvi, Boolean valDesp)	{
	
		this.oid=oid;
                this.setUnidades(numUnid);
                this.setMotivo(mopcOidMotiPremCons);
                this.setEnviarA(enviOidEnvi);
                this.setDespacho(valDesp);   
	
	}

	@Id
	@Column(name="OID_PREM_CONS")
	private Long oid;
	@Column(name="NUM_UNID")
	private Long unidades;
	@Column(name="NUM_DESP")
	private Boolean despacho;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="NUM_COMU")
	private Integer comunicacion;
	@Column(name="MOPC_OID_MOTI_PREM_CONS")
	private Long motivo;
	@Column(name="MENS_OID_MENS")
	private Long mensaje;
	@Column(name="ENVI_OID_ENVI")
	private Long enviarA;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getUnidades() {return unidades;}
      
	public void setUnidades(Long unidades){this.unidades=unidades;}
		
	public Boolean getDespacho() {return despacho;}
      
	public void setDespacho(Boolean despacho){this.despacho=despacho;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Integer getComunicacion() {return comunicacion;}
      
	public void setComunicacion(Integer comunicacion){this.comunicacion=comunicacion;}
		
	public Long getMotivo() {return motivo;}
      
	public void setMotivo(Long motivo){this.motivo=motivo;}
		
	public Long getMensaje() {return mensaje;}
      
	public void setMensaje(Long mensaje){this.mensaje=mensaje;}
		
	public Long getEnviarA() {return enviarA;}
      
	public void setEnviarA(Long enviarA){this.enviarA=enviarA;}
			
	
}
