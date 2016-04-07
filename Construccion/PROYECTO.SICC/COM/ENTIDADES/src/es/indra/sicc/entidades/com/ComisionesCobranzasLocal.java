package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_COBRA")
@NamedQueries({
@NamedQuery(name="ComisionesCobranzasLocal.FindAll",query="select object(o) from ComisionesCobranzasLocal o"),
@NamedQuery(name="ComisionesCobranzasLocal.FindByComision",query="select object(c) from ComisionesCobranzasLocal c where c.comision = ?1")
})
public class ComisionesCobranzasLocal implements Serializable {

	public ComisionesCobranzasLocal() {}

	public ComisionesCobranzasLocal(Long oid, Long comision, Long tipoParticipante)	{
	
		this.oid=oid;
                this.setComision(comision);
	        this.setTipoParticipante(tipoParticipante);
	
	}

	@Id
	@Column(name="OID_COMI_COBR")
	private Long oid;
	@Column(name="NUM_DIAS_TRAS_FACT")
	private Integer diasTrasFacturacion;
	@Column(name="COMI_OID_COMI")
	private Long comision;
	@Column(name="TPAR_OID_TIPO_PART")
	private Long tipoParticipante;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getDiasTrasFacturacion() {return diasTrasFacturacion;}
      
	public void setDiasTrasFacturacion(Integer diasTrasFacturacion){this.diasTrasFacturacion=diasTrasFacturacion;}
		
	public Long getComision() {return comision;}
      
	public void setComision(Long comision){this.comision=comision;}
		
	public Long getTipoParticipante() {return tipoParticipante;}
      
	public void setTipoParticipante(Long tipoParticipante){this.tipoParticipante=tipoParticipante;}
			
	
}
