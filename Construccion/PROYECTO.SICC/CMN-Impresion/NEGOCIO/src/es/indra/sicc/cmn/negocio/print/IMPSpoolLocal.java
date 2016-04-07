package es.indra.sicc.cmn.negocio.print;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="GEN_SPOOL")
@NamedQueries({
@NamedQuery(name="IMPSpoolLocal.FindAll",query="select object(o) from IMPSpoolLocal o")
})
public class IMPSpoolLocal implements Serializable {

	public IMPSpoolLocal() {}

	IMPSpoolLocal(Long idSpool, Timestamp fecAper, Boolean indActi, Boolean indAper, Long valAcceFisi) {
            this.idSpool = idSpool;
            this.start = fecAper;
            this.active = indActi;
            this.open = indAper;
            this.accesoFisico = valAcceFisi;
	}

	@Column(name="VAL_ACCE_FISI")
	private Long accesoFisico;
	@Id
	@Column(name="OID_SPOO")
	private Long idSpool;
	@Column(name="FEC_APER")
	private java.sql.Timestamp start;
	@Column(name="IND_ACTI")
	private Boolean active;
	@Column(name="COD_SERV")
	private String serverID;
	@Column(name="IND_APER")
	private Boolean open;
	@Column(name="IND_PETI_CIER")
	private Boolean indPeticionCierre;

	
	public Long getAccesoFisico() {return accesoFisico;}
      
	public void setAccesoFisico(Long accesoFisico){this.accesoFisico=accesoFisico;}
		
	public Long getIdSpool() {return idSpool;}
      
	public Long getPrimaryKey() {return idSpool;}		
		
	public java.sql.Timestamp getStart() {return start;}
      
	public void setStart(java.sql.Timestamp start){this.start=start;}
		
	public Boolean getActive() {return active;}
      
	public void setActive(Boolean active){this.active=active;}
		
	public String getServerID() {return serverID;}
      
	public void setServerID(String serverID){this.serverID=serverID;}
		
	public Boolean getOpen() {return open;}
      
	public void setOpen(Boolean open){this.open=open;}
		
	public Boolean getIndPeticionCierre() {return indPeticionCierre;}
      
	public void setIndPeticionCierre(Boolean indPeticionCierre){this.indPeticionCierre=indPeticionCierre;}
			
	
}
