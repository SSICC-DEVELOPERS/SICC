package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_SUBPR")
@NamedQueries({
@NamedQuery(name="SubprocesosLocal.FindByUk",query="SELECT OBJECT(t) FROM SubprocesosLocal AS t WHERE t.proceso = ?1 AND t.codigo = ?2")
})
public class SubprocesosLocal implements Serializable {

	public SubprocesosLocal() {}

	public SubprocesosLocal(Long oid, Long proceso, Integer codigo, String descripcion,
                            Character indicadorGestionaMarcasSN, Character indicadorActualizaCuotaSN,
                            Character indicadorTipoAbonoSN, Character indicadorConsultasDHAN) {
	
		this.oid=oid;
                this.proceso=proceso;
                this.codigo=codigo;
                this.descripcion=descripcion;
                this.indicadorGestionaMarcasSN=indicadorGestionaMarcasSN;
                this.indicadorActualizaCuotaSN=indicadorActualizaCuotaSN;
                this.indicadorTipoAbonoSN=indicadorTipoAbonoSN;
                this.indicadorConsultasDHAN=indicadorConsultasDHAN;                
	
	}
        
        public SubprocesosLocal(Long oid, Long proceso, Integer codigo, String descripcion, 
                            Character indicadorGestionaMarcasSN, Character indicadorActualizaCuotaSN, 
                            Character indicadorTipoAbonoSN, Character indicadorConsultasDHAN, String observaciones) {
        
                this.oid=oid;
                this.proceso=proceso;
                this.codigo=codigo;
                this.descripcion=descripcion;
                this.indicadorGestionaMarcasSN=indicadorGestionaMarcasSN;
                this.indicadorActualizaCuotaSN=indicadorActualizaCuotaSN;
                this.indicadorTipoAbonoSN=indicadorTipoAbonoSN;
                this.indicadorConsultasDHAN=indicadorConsultasDHAN; 
                this.observaciones=observaciones;                
        
        }        

	@Id
	@Column(name="OID_SUBP")
	private Long oid;
	@Column(name="CCPR_OID_PROC")
	private Long proceso;
	@Column(name="COD_SUBP")
	private Integer codigo;
	@Column(name="DES_SUBP")
	private String descripcion;
	@Column(name="VAL_INDI_GEST_MARC")
	private Character indicadorGestionaMarcasSN;
	@Column(name="VAL_INDI_ACTU_CUOT")
	private Character indicadorActualizaCuotaSN;
	@Column(name="VAL_INDI_TIPO_ABON")
	private Character indicadorTipoAbonoSN;
	@Column(name="VAL_INDI_CONS")
	private Character indicadorConsultasDHAN;
	@Column(name="VAL_OBSE")
	private String observaciones;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getProceso() {return proceso;}
      
	public void setProceso(Long proceso){this.proceso=proceso;}
		
	public Integer getCodigo() {return codigo;}
      
	public void setCodigo(Integer codigo){this.codigo=codigo;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Character getIndicadorGestionaMarcasSN() {return indicadorGestionaMarcasSN;}
      
	public void setIndicadorGestionaMarcasSN(Character indicadorGestionaMarcasSN){this.indicadorGestionaMarcasSN=indicadorGestionaMarcasSN;}
		
	public Character getIndicadorActualizaCuotaSN() {return indicadorActualizaCuotaSN;}
      
	public void setIndicadorActualizaCuotaSN(Character indicadorActualizaCuotaSN){this.indicadorActualizaCuotaSN=indicadorActualizaCuotaSN;}
		
	public Character getIndicadorTipoAbonoSN() {return indicadorTipoAbonoSN;}
      
	public void setIndicadorTipoAbonoSN(Character indicadorTipoAbonoSN){this.indicadorTipoAbonoSN=indicadorTipoAbonoSN;}
		
	public Character getIndicadorConsultasDHAN() {return indicadorConsultasDHAN;}
      
	public void setIndicadorConsultasDHAN(Character indicadorConsultasDHAN){this.indicadorConsultasDHAN=indicadorConsultasDHAN;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
			
	
}
