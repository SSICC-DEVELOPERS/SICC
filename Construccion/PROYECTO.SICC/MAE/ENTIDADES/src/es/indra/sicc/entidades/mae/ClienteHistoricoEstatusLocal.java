package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CLIEN_HISTO_ESTAT")
@NamedQueries({
@NamedQuery(name="ClienteHistoricoEstatusLocal.FindByClienteEstatus",query="SELECT OBJECT(a) "
+ " FROM ClienteHistoricoEstatusLocal AS a "
+ " WHERE a.esta_oid_esta_clie = ?2 " 
+ " AND a.clie_oid_clie = ?1"),
@NamedQuery(name="ClienteHistoricoEstatusLocal.FindUltimoHistorico",query="SELECT OBJECT(a) "
+ " FROM ClienteHistoricoEstatusLocal AS a  " 
+ " WHERE a.clie_oid_clie = ?1 " 
+ " AND a.perd_oid_peri_peri_fin IS NULL"),
@NamedQuery(name="ClienteHistoricoEstatusLocal.FindByUK",query="SELECT OBJECT(h) "
+ " FROM ClienteHistoricoEstatusLocal AS h  " 
+ " WHERE h.clie_oid_clie = ?1 AND " 
+ " h.perd_oid_peri = ?2"),
@NamedQuery(name="ClienteHistoricoEstatusLocal.FindHistoricoPorPeriodoFin",query="SELECT OBJECT(h) "
+ " FROM ClienteHistoricoEstatusLocal AS h "  
+ " WHERE h.clie_oid_clie = ?1 AND " 
+ " h.perd_oid_peri_peri_fin = ?2"),
@NamedQuery(name="ClienteHistoricoEstatusLocal.FindAll",query="SELECT OBJECT(h) FROM ClienteHistoricoEstatusLocal AS h ")
})
public class ClienteHistoricoEstatusLocal implements Serializable {

	public ClienteHistoricoEstatusLocal() {}

	public ClienteHistoricoEstatusLocal(Long oid, Long cliente, Long estatus)	{
            this.oid=oid;
            this.clie_oid_clie = cliente;
            this.esta_oid_esta_clie = estatus;
	}
        
        public ClienteHistoricoEstatusLocal(Long oid, Long cliente, Long estatus, Long periodoInicio, Long periodoFin) {
            this(oid, cliente, estatus);
            this.perd_oid_peri = periodoInicio;
            this.perd_oid_peri_peri_fin = periodoFin;
        }

	@Id
	@Column(name="OID_HIST_ESTA")
	private Long oid;
	@Column(name="PERD_OID_PERI")
	private Long perd_oid_peri;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="PERD_OID_PERI_PERI_FIN")
	private Long perd_oid_peri_peri_fin;
	@Column(name="ESTA_OID_ESTA_CLIE")
	private Long esta_oid_esta_clie;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPerd_oid_peri() {return perd_oid_peri;}
      
	public void setPerd_oid_peri(Long perd_oid_peri){this.perd_oid_peri=perd_oid_peri;}
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getPerd_oid_peri_peri_fin() {return perd_oid_peri_peri_fin;}
      
	public void setPerd_oid_peri_peri_fin(Long perd_oid_peri_peri_fin){this.perd_oid_peri_peri_fin=perd_oid_peri_peri_fin;}
		
	public Long getEsta_oid_esta_clie() {return esta_oid_esta_clie;}
      
	public void setEsta_oid_esta_clie(Long esta_oid_esta_clie){this.esta_oid_esta_clie=esta_oid_esta_clie;}
			
	
}
