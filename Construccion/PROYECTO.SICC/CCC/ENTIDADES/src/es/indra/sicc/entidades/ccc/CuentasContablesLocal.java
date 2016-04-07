package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_CUENT_CONTA")
public class CuentasContablesLocal implements Serializable {

	public CuentasContablesLocal() {}

	public CuentasContablesLocal(Long oid, Long pais, String codigo, String codigoSAP) {
	
		this.oid=oid;
                this.pais=pais;
                this.codigo=codigo;
                this.codigoSAP=codigoSAP;
	
	}

        public CuentasContablesLocal(Long oid, Long pais, String codigo, String codigoSAP, String observaciones) {
        
                this.oid=oid;
                this.pais=pais;
                this.codigo=codigo;
                this.codigoSAP=codigoSAP;
                this.observaciones=observaciones;
        
        }

	@Id
	@Column(name="OID_CUEN_CONT")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_CUEN_CONT")
	private String codigo;
	@Column(name="COD_CUEN_SAP")
	private String codigoSAP;
	@Column(name="VAL_OBSE")
	private String observaciones;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getCodigoSAP() {return codigoSAP;}
      
	public void setCodigoSAP(String codigoSAP){this.codigoSAP=codigoSAP;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
			
	
}
