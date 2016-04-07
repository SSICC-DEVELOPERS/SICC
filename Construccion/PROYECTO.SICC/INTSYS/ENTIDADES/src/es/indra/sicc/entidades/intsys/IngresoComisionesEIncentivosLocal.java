package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;

import java.io.Serializable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="INT_INGRE_COMIS_INCEN")
@NamedQueries({
@NamedQuery(name="IngresoComisionesEIncentivosLocal.FindAll",query="select object(o) from IngresoComisionesEIncentivosLocal o")
})
public class IngresoComisionesEIncentivosLocal implements Serializable {

	public IngresoComisionesEIncentivosLocal() {}

	public IngresoComisionesEIncentivosLocal(Long oid, Long importePagar, Long oidTipoSubtipo, Long oidComisionIncentivo)	{
            this.oid=oid;
	    this.importePagar=importePagar;
	    this.oidTipoSubtipo=oidTipoSubtipo;
	    this.oidComisionIncentivo=oidComisionIncentivo;
	
	}

	@Id
	@Column(name="OID_INGR_COMI_INCE")
	private Long oid;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_INGR_COMI_INCE")
	private Date fecha;
	@Column(name="NUM_LOTE")
	private String numeroLote;
	@Column(name="IMP_PAGA")
	private Long importePagar;
	@Column(name="CTSU_OID_CLIE_TIPO_SUBT")
	private Long oidTipoSubtipo;
	@Column(name="DCOI_OID_COMI_INCE")
	private Long oidComisionIncentivo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Date getFecha() {return fecha;}
      
	public void setFecha(Date fecha){this.fecha=fecha;}
		
	public String getNumeroLote() {return numeroLote;}
      
	public void setNumeroLote(String numeroLote){this.numeroLote=numeroLote;}
		
	public Long getImportePagar() {return importePagar;}
      
	public void setImportePagar(Long importePagar){this.importePagar=importePagar;}
		
	public Long getOidTipoSubtipo() {return oidTipoSubtipo;}
      
	public void setOidTipoSubtipo(Long oidTipoSubtipo){this.oidTipoSubtipo=oidTipoSubtipo;}
		
	public Long getOidComisionIncentivo() {return oidComisionIncentivo;}
      
	public void setOidComisionIncentivo(Long oidComisionIncentivo){this.oidComisionIncentivo=oidComisionIncentivo;}
			
	
}
