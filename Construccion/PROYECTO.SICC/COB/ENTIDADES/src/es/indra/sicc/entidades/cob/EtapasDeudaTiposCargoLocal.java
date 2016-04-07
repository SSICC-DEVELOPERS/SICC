package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_ETAPA_DEUDA_TIPO_CARGO")
@NamedQueries({
@NamedQuery(name="EtapasDeudaTiposCargoLocal.FindAll",query="select object(o) from EtapasDeudaTiposCargoLocal o"),
@NamedQuery(name="EtapasDeudaTiposCargoLocal.FindByUK",query="select object(e) from EtapasDeudaTiposCargoLocal e where e.tipoCargo = ?1 and e.etapaDeuda = ?2")
})
public class EtapasDeudaTiposCargoLocal implements Serializable {

	public EtapasDeudaTiposCargoLocal() {}

	public EtapasDeudaTiposCargoLocal(Long oid, Long tipoCargo, Long etapaDeuda)	{
	
		this.oid=oid;
                this.setTipoCargo(tipoCargo);
	        this.setEtapaDeuda(etapaDeuda);
	
	}

	@Id
	@Column(name="OID_ETAP_DEUD_TIPO_CARG")
	private Long oid;
	@Column(name="VAL_DESC")
	private String descripcion;
	@Column(name="TCAB_OID_TIPO_CARG_ABON")
	private Long tipoCargo;
	@Column(name="ETDE_OID_ETAP_DEUD")
	private Long etapaDeuda;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Long getTipoCargo() {return tipoCargo;}
      
	public void setTipoCargo(Long tipoCargo){this.tipoCargo=tipoCargo;}
		
	public Long getEtapaDeuda() {return etapaDeuda;}
      
	public void setEtapaDeuda(Long etapaDeuda){this.etapaDeuda=etapaDeuda;}
			
	
}
