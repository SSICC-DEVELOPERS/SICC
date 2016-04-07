package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_PARAM_CONTA")
public class ParametrosContablesLocal implements Serializable {

	public ParametrosContablesLocal() {}

	public ParametrosContablesLocal(Long oid, Long subproceso, Character indicativoDeberHaber, 
                                    String textoApunte, Character concatenarFechaSN) {
	
		this.oid=oid;
                this.subproceso=subproceso;
                this.indicativoDeberHaber=indicativoDeberHaber;
                this.textoApunte=textoApunte;
                this.concatenarFechaSN=concatenarFechaSN;
	
	}
        
        public ParametrosContablesLocal(Long oid, Long subproceso, Character indicativoDeberHaber, 
                                    Character obtencionCuenta, String textoApunte, String observaciones,
                                    Character concatenarFechaSN, Long cuenta) {
        
                this.oid=oid;
                this.subproceso=subproceso;
                this.indicativoDeberHaber=indicativoDeberHaber;
                this.textoApunte=textoApunte;
                this.concatenarFechaSN=concatenarFechaSN;
                this.obtencionCuenta=obtencionCuenta;                
                this.observaciones=observaciones;                
                this.cuenta=cuenta;        
        
        }        

	@Id
	@Column(name="OID_PARA_CONT")
	private Long oid;
	@Column(name="SUBP_OID_SUBP")
	private Long subproceso;
	@Column(name="VAL_DEBE_HABE")
	private Character indicativoDeberHaber;
	@Column(name="VAL_OBTE_CUEN")
	private Character obtencionCuenta;
	@Column(name="VAL_TEXT_APUN")
	private String textoApunte;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="IND_CONC_FECH")
	private Character concatenarFechaSN;
	@Column(name="CUCO_OID_CUEN_CONT_DIRE")
	private Long cuenta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSubproceso() {return subproceso;}
      
	public void setSubproceso(Long subproceso){this.subproceso=subproceso;}
		
	public Character getIndicativoDeberHaber() {return indicativoDeberHaber;}
      
	public void setIndicativoDeberHaber(Character indicativoDeberHaber){this.indicativoDeberHaber=indicativoDeberHaber;}
		
	public Character getObtencionCuenta() {return obtencionCuenta;}
      
	public void setObtencionCuenta(Character obtencionCuenta){this.obtencionCuenta=obtencionCuenta;}
		
	public String getTextoApunte() {return textoApunte;}
      
	public void setTextoApunte(String textoApunte){this.textoApunte=textoApunte;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Character getConcatenarFechaSN() {return concatenarFechaSN;}
      
	public void setConcatenarFechaSN(Character concatenarFechaSN){this.concatenarFechaSN=concatenarFechaSN;}
		
	public Long getCuenta() {return cuenta;}
      
	public void setCuenta(Long cuenta){this.cuenta=cuenta;}
			
	
}
