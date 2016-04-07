package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CRA_TRANS")
public class TransaccionesLocal implements Serializable {

	public TransaccionesLocal() {}

	public TransaccionesLocal(Long oid, String cod_proc, Boolean val_ejec)	{
	
		this.oid=oid;
                this.codigoProceso = cod_proc;
                this.ejecutable = val_ejec;
	}

	@Id
	@Column(name="OID_TRAN")
	private Long oid;
	@Column(name="COD_PROC")
	private String codigoProceso;
	@Column(name="VAL_EJEC")
	private Boolean ejecutable;
	@Column(name="VAL_PARA")
	private String parametros;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoProceso() {return codigoProceso;}
      
	public void setCodigoProceso(String codigoProceso){this.codigoProceso=codigoProceso;}
		
	public Boolean getEjecutable() {return ejecutable;}
      
	public void setEjecutable(Boolean ejecutable){this.ejecutable=ejecutable;}
		
	public String getParametros() {return parametros;}
      
	public void setParametros(String parametros){this.parametros=parametros;}
			
	
}
