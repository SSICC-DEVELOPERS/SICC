package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_ARGUM_VENTA")
@NamedQueries({
@NamedQuery(name="ArgumentoVentaLocal.FindByTipoEstrategia",query="SELECT OBJECT(a) FROM "
+ "ArgumentoVentaLocal AS a WHERE a.oidTipoEstr = ?1"),
@NamedQuery(name="ArgumentoVentaLocal.FindByUK",query="SELECT OBJECT(a) "
+ "FROM ArgumentoVentaLocal AS a WHERE a.codigoArgumento = ?1")
})
public class ArgumentoVentaLocal implements Serializable {

	public ArgumentoVentaLocal() {}

	public ArgumentoVentaLocal(Long oid, Integer cod_argu_vent) {
	
		this.oid=oid;
                this.codigoArgumento=cod_argu_vent;
	
	}

	@Id
	@Column(name="OID_ARGU_VENT")
	private Long oid;
	@Column(name="COD_ARGU_VENT")
	private Integer codigoArgumento;
	@Column(name="VAL_FACT_REPE")
	private Integer factorRepeticion;
	@Column(name="TIES_OID_TIPO_ESTR")
	private Long oidTipoEstr;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getCodigoArgumento() {return codigoArgumento;}
      
	public void setCodigoArgumento(Integer codigoArgumento){this.codigoArgumento=codigoArgumento;}
		
	public Integer getFactorRepeticion() {return factorRepeticion;}
      
	public void setFactorRepeticion(Integer factorRepeticion){this.factorRepeticion=factorRepeticion;}
		
	public Long getOidTipoEstr() {return oidTipoEstr;}
      
	public void setOidTipoEstr(Long oidTipoEstr){this.oidTipoEstr=oidTipoEstr;}
			
	
}
