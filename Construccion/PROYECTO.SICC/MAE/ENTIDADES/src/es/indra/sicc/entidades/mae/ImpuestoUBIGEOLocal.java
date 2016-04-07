package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_IMPUE_UBIGE")
@NamedQueries({
@NamedQuery(name="ImpuestoUBIGEOLocal.FindAll", query="SELECT OBJECT(o) FROM ImpuestoUBIGEOLocal AS o")
})
public class ImpuestoUBIGEOLocal implements Serializable {

	public ImpuestoUBIGEOLocal() {}

	public ImpuestoUBIGEOLocal(Long oid, Long prod_oid_prod, Long oid_subac, Long oidTasaImpuesto)	{
            this.oid = oid;
            this.oidProducto = prod_oid_prod;
            this.oidSubacceso = oid_subac;
            this.oidTasaImpuesto = oidTasaImpuesto;
	}

	@Id
	@Column(name="OID_IMPU_UBIG")
	private Long oid;
	@Column(name="PROD_OID_PROD")
	private Long oidProducto;
	@Column(name="SBAC_OID_SBAC")
	private Long oidSubacceso;
	@Column(name="TAIM_OID_TASA_IMPU")
	private Long oidTasaImpuesto;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidProducto() {return oidProducto;}
      
	public void setOidProducto(Long oidProducto){this.oidProducto=oidProducto;}
		
	public Long getOidSubacceso() {return oidSubacceso;}
      
	public void setOidSubacceso(Long oidSubacceso){this.oidSubacceso=oidSubacceso;}
		
	public Long getOidTasaImpuesto() {return oidTasaImpuesto;}
      
	public void setOidTasaImpuesto(Long oidTasaImpuesto){this.oidTasaImpuesto=oidTasaImpuesto;}
			
	
}
