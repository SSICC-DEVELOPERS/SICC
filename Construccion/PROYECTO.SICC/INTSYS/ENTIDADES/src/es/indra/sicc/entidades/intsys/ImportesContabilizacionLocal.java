package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_IMPOR_CONTA_FACTU")
@NamedQueries({
@NamedQuery(name="ImportesContabilizacionLocal.FindAll",query="select object(o) from ImportesContabilizacionLocal o"),
@NamedQuery(name="ImportesContabilizacionLocal.FindByUk",query="SELECT OBJECT(i) FROM ImportesContabilizacionLocal i WHERE i.codigo = ?1")
})
public class ImportesContabilizacionLocal implements Serializable {

	public ImportesContabilizacionLocal() {}

	public ImportesContabilizacionLocal(Long oid, String codigo, String identificadorCabeceraDetalle, String descripcionImporte)	{
            this.oid=oid;
	    this.codigo=codigo;
	    this.identificadorCabeceraDetalle=identificadorCabeceraDetalle;
	    this.descripcionImporte=descripcionImporte;
	}

	@Id
	@Column(name="OID_IMPO_CONT_FACT")
	private Long oid;
	@Column(name="COD_IMPO_CONT")
	private String codigo;
	@Column(name="VAL_IDEN_CABE_DETA")
	private String identificadorCabeceraDetalle;
	@Column(name="VAL_DESC_IMPO")
	private String descripcionImporte;
	@Column(name="VAL_OBSE")
	private String observaciones;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getIdentificadorCabeceraDetalle() {return identificadorCabeceraDetalle;}
      
	public void setIdentificadorCabeceraDetalle(String identificadorCabeceraDetalle){this.identificadorCabeceraDetalle=identificadorCabeceraDetalle;}
		
	public String getDescripcionImporte() {return descripcionImporte;}
      
	public void setDescripcionImporte(String descripcionImporte){this.descripcionImporte=descripcionImporte;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
			
	
}
