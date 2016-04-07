package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_PARAM_NMPER")
@NamedQueries({
@NamedQuery(name="ParametrosNMPLocal.FindAll",query="select object(o) from ParametrosNMPLocal o")
})
public class ParametrosNMPLocal implements Serializable {

	public ParametrosNMPLocal() {}

	public ParametrosNMPLocal(Long oid, Double porcentajeRecargo, Long tipoCliente, Long pais, Long precioPerdida)	{
	
		this.oid=oid;
                this.porcentajeRecargo=porcentajeRecargo;
                this.tipoCliente=tipoCliente;
                this.pais=pais;
                this.precioPerdida=precioPerdida;
	
	}

	@Id
	@Column(name="OID_PARA")
	private Long oid;
	@Column(name="VAL_PORC_RECA")
	private Double porcentajeRecargo;
	@Column(name="IND_PARA_MODI")
	private Long parametrosModificables;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long tipoCliente;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="PPER_OID_PREC_PERD")
	private Long precioPerdida;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Double getPorcentajeRecargo() {return porcentajeRecargo;}
      
	public void setPorcentajeRecargo(Double porcentajeRecargo){this.porcentajeRecargo=porcentajeRecargo;}
		
	public Long getParametrosModificables() {return parametrosModificables;}
      
	public void setParametrosModificables(Long parametrosModificables){this.parametrosModificables=parametrosModificables;}
		
	public Long getTipoCliente() {return tipoCliente;}
      
	public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getPrecioPerdida() {return precioPerdida;}
      
	public void setPrecioPerdida(Long precioPerdida){this.precioPerdida=precioPerdida;}
			
	
}
