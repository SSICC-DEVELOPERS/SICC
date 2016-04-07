package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_TIPO_ABONO_SUBPR")
@NamedQueries({
@NamedQuery(name="TiposAbonoSubprocesoLocal.FindBySubproceso",query="SELECT OBJECT(t) FROM TiposAbonoSubprocesoLocal AS t WHERE t.subproceso = ?1"),
@NamedQuery(name="TiposAbonoSubprocesoLocal.FindByUK",query="SELECT OBJECT(t) FROM TiposAbonoSubprocesoLocal AS t WHERE t.tipoAbono = ?1 AND t.subproceso = ?2")
})
public class TiposAbonoSubprocesoLocal implements Serializable {

	public TiposAbonoSubprocesoLocal() {}

	public TiposAbonoSubprocesoLocal(Long oid, Long subproceso, Long cuenta, Long tipoAbono) {
	
		this.oid=oid;
                this.subproceso=subproceso;
                this.cuenta=cuenta;
                this.tipoAbono=tipoAbono;
	
	}

	@Id
	@Column(name="OID_TIPO_ABON_SUBP")
	private Long oid;
	@Column(name="SUBP_OID_SUBP")
	private Long subproceso;
	@Column(name="CUCO_OID_CUEN_CONT")
	private Long cuenta;
	@Column(name="TCAB_OID_TCAB")
	private Long tipoAbono;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSubproceso() {return subproceso;}
      
	public void setSubproceso(Long subproceso){this.subproceso=subproceso;}
		
	public Long getCuenta() {return cuenta;}
      
	public void setCuenta(Long cuenta){this.cuenta=cuenta;}
		
	public Long getTipoAbono() {return tipoAbono;}
      
	public void setTipoAbono(Long tipoAbono){this.tipoAbono=tipoAbono;}
			
	
}
