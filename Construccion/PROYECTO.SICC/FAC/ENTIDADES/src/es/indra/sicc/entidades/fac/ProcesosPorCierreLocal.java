package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FAC_PROCE_CIERR")
public class ProcesosPorCierreLocal implements Serializable {

	public ProcesosPorCierreLocal() {}

	public ProcesosPorCierreLocal(Long oid, Long pais, String tipoCierre, String proceso, Byte ordenEjecucion)	{
            this.oid=oid;
	    this.pais = pais;
	    this.tipoCierre = tipoCierre;
	    this.proceso = proceso;
	    this.ordenEjecucion = ordenEjecucion;
	}

        public ProcesosPorCierreLocal(Long oid, Long pais, String tipoCierre, String proceso, Byte ordenEjecucion, String programa)      {
            this.oid=oid;
            this.pais = pais;
            this.tipoCierre = tipoCierre;
            this.proceso = proceso;
            this.ordenEjecucion = ordenEjecucion;
            this.programa = programa;
        }

	@Id
	@Column(name="OID_PROC_CIER")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="VAL_TIPO_CIER")
	private String tipoCierre;
	@Column(name="VAL_PROC")
	private String proceso;
	@Column(name="NUM_ORDE_EJEC")
	private Byte ordenEjecucion;
	@Column(name="VAL_PROG")
	private String programa;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getTipoCierre() {return tipoCierre;}
      
	public void setTipoCierre(String tipoCierre){this.tipoCierre=tipoCierre;}
		
	public String getProceso() {return proceso;}
      
	public void setProceso(String proceso){this.proceso=proceso;}
		
	public Byte getOrdenEjecucion() {return ordenEjecucion;}
      
	public void setOrdenEjecucion(Byte ordenEjecucion){this.ordenEjecucion=ordenEjecucion;}
		
	public String getPrograma() {return programa;}
      
	public void setPrograma(String programa){this.programa=programa;}
			
	
}
