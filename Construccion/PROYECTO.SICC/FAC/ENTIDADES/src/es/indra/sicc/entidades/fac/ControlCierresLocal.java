package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FAC_CONTR_CIERR")
public class ControlCierresLocal implements Serializable {

	public ControlCierresLocal() {}

	public ControlCierresLocal(Long oid, Long pais, Long tiposCierre, Integer secuencia, Date fechaCierre, Long periodo)	{
            this.oid = oid;
	    this.pais = pais;
	    this.tiposCierre = tiposCierre;
	    this.secuencia = secuencia;
	    this.fechaCierre = fechaCierre;
	    this.periodo = periodo;
	}
        
        public ControlCierresLocal(Long oid, Long pais, Long tiposCierre, Integer secuencia, Date fechaCierre, String procesoEjecutado, String resultadoProceso, Long periodo, Long zona, Long region)    {
            this.oid = oid;
            this.pais = pais;
            this.tiposCierre = tiposCierre;            
            this.fechaCierre = fechaCierre;
            this.periodo = periodo;
            this.procesoEjecutado = procesoEjecutado;
            this.resultadoProceso = resultadoProceso;
            this.zona = zona;
            this.region = region;
            this.secuencia = new Integer(oid.intValue());
        }
        

	@Id
	@Column(name="OID_CTRL")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="TCIE_OID_TIPO_CIER")
	private Long tiposCierre;
	@Column(name="VAL_SECU_CIER")
	private Integer secuencia;
	@Column(name="FEC_CIER")   
	private java.sql.Date fechaCierre;
	@Column(name="VAL_PROC_EJEC")
	private String procesoEjecutado;
	@Column(name="VAL_RESU_PROC")
	private String resultadoProceso;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="ZORG_OID_REGI")
	private Long region;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getTiposCierre() {return tiposCierre;}
      
	public void setTiposCierre(Long tiposCierre){this.tiposCierre=tiposCierre;}
		
	public Integer getSecuencia() {return secuencia;}
      
	public void setSecuencia(Integer secuencia){this.secuencia=secuencia;}
		
	public java.sql.Date getFechaCierre() {return fechaCierre;}
      
	public void setFechaCierre(java.sql.Date fechaCierre){this.fechaCierre=fechaCierre;}
		
	public String getProcesoEjecutado() {return procesoEjecutado;}
      
	public void setProcesoEjecutado(String procesoEjecutado){this.procesoEjecutado=procesoEjecutado;}
		
	public String getResultadoProceso() {return resultadoProceso;}
      
	public void setResultadoProceso(String resultadoProceso){this.resultadoProceso=resultadoProceso;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
			
	
}
