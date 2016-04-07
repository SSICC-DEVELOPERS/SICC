package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CONTR_IMPRE_FICHA_INSCR")
@NamedQueries({
@NamedQuery(name="ControlImpresionFichasInscripcionLocal.FindAll", query="SELECT OBJECT(o) FROM ControlImpresionFichasInscripcionLocal o")
})
public class ControlImpresionFichasInscripcionLocal implements Serializable {

	public ControlImpresionFichasInscripcionLocal() {}

	public ControlImpresionFichasInscripcionLocal(Long oid, Long clie_oid_clie, Integer num_impr) {
            this.oid = oid;
            this.oidCliente = clie_oid_clie;
            this.numImpresion = num_impr;
	}

	@Id
	@Column(name="OID_CTRL_IMPR")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Column(name="NUM_IMPR")
	private Integer numImpresion;
	@Column(name="VAL_MOTI")
	private String motivo;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Integer getNumImpresion() {return numImpresion;}
      
	public void setNumImpresion(Integer numImpresion){this.numImpresion=numImpresion;}
		
	public String getMotivo() {return motivo;}
      
	public void setMotivo(String motivo){this.motivo=motivo;}
			
	
}
