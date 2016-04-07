package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_PROCE")
@NamedQueries({
@NamedQuery(name="ProcesosLocal.FindByUk",query="SELECT OBJECT(t) FROM ProcesosLocal AS t WHERE t.oidPais = ?1 AND t.codigoProceso = ?2")
})
public class ProcesosLocal implements Serializable {

	public ProcesosLocal() {}

	public ProcesosLocal(Long oid, Long pais_oid_pais, String cod_proc, String des_proc) {
	
		this.oid=oid;
                this.oidPais=pais_oid_pais;
                this.codigoProceso=cod_proc;
                this.descripcionProceso=des_proc;
	
	}

	@Id
	@Column(name="OID_PROC")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="COD_PROC")
	private String codigoProceso;
	@Column(name="DES_PROC")
	private String descripcionProceso;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="IND_CV_DIRE")
	private Long cargoAbonos;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public String getCodigoProceso() {return codigoProceso;}
      
	public void setCodigoProceso(String codigoProceso){this.codigoProceso=codigoProceso;}
		
	public String getDescripcionProceso() {return descripcionProceso;}
      
	public void setDescripcionProceso(String descripcionProceso){this.descripcionProceso=descripcionProceso;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getCargoAbonos() {return cargoAbonos;}
      
	public void setCargoAbonos(Long cargoAbonos){this.cargoAbonos=cargoAbonos;}
			
	
}
