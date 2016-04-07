package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_HISTO_CLASI")
@NamedQueries({
@NamedQuery(name="HistoricoClasificacionLocal.FindAll",query="select object(o) from HistoricoClasificacionLocal o")
})
public class HistoricoClasificacionLocal implements Serializable {

	public HistoricoClasificacionLocal() {}

	public HistoricoClasificacionLocal(Long oid, Long clhe_oid_hist_esta, Long clas_oid_clas) {
            this.oid = oid;
            this.clhe_oid_hist_esta = clhe_oid_hist_esta;
            this.clas_oid_clas = clas_oid_clas;
	}

	@Id
	@Column(name="OID_HIST_CLAS")
	private Long oid;
	@Column(name="CLHE_OID_HIST_ESTA")
	private Long clhe_oid_hist_esta;
	@Column(name="CLAS_OID_CLAS")
	private Long clas_oid_clas;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClhe_oid_hist_esta() {return clhe_oid_hist_esta;}
      
	public void setClhe_oid_hist_esta(Long clhe_oid_hist_esta){this.clhe_oid_hist_esta=clhe_oid_hist_esta;}
		
	public Long getClas_oid_clas() {return clas_oid_clas;}
      
	public void setClas_oid_clas(Long clas_oid_clas){this.clas_oid_clas=clas_oid_clas;}
			
	
}
