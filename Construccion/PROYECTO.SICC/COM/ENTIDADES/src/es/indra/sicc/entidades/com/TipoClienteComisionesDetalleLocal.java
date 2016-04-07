package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_TIPO_CLIEN_COMIS_DETAL")
@NamedQueries({
@NamedQuery(name="TipoClienteComisionesDetalleLocal.FindAll",query="select object(o) from TipoClienteComisionesDetalleLocal o"),
@NamedQuery(name="TipoClienteComisionesDetalleLocal.FindByCabecera",query="select object(o) from TipoClienteComisionesDetalleLocal o "
+ "  where o.tcccOidTipoClieComiCabe = ?1")
})
public class TipoClienteComisionesDetalleLocal implements Serializable {

	public TipoClienteComisionesDetalleLocal() {}

	public TipoClienteComisionesDetalleLocal(Long oid, Long tcccOidTipoClieComiCabe, Long ticlOidTipoClie)	{
	
		this.oid=oid;
                this.setTcccOidTipoClieComiCabe(tcccOidTipoClieComiCabe);
	        this.setTiclOidTipoClie(ticlOidTipoClie);
	
	}

	@Id
	@Column(name="OID_TIPO_CLIE_COMI_DETA")
	private Long oid;
	@Column(name="CLAS_OID_CLAS")
	private Long clasOidClas;
	@Column(name="TCCC_OID_TIPO_CLIE_COMI_CABE")
	private Long tcccOidTipoClieComiCabe;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long sbtiOidSubtClie;
	@Column(name="TCCL_OID_TIPO_CLAS")
	private Long tcclOidTipoClas;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long ticlOidTipoClie;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClasOidClas() {return clasOidClas;}
      
	public void setClasOidClas(Long clasOidClas){this.clasOidClas=clasOidClas;}
		
	public Long getTcccOidTipoClieComiCabe() {return tcccOidTipoClieComiCabe;}
      
	public void setTcccOidTipoClieComiCabe(Long tcccOidTipoClieComiCabe){this.tcccOidTipoClieComiCabe=tcccOidTipoClieComiCabe;}
		
	public Long getSbtiOidSubtClie() {return sbtiOidSubtClie;}
      
	public void setSbtiOidSubtClie(Long sbtiOidSubtClie){this.sbtiOidSubtClie=sbtiOidSubtClie;}
		
	public Long getTcclOidTipoClas() {return tcclOidTipoClas;}
      
	public void setTcclOidTipoClas(Long tcclOidTipoClas){this.tcclOidTipoClas=tcclOidTipoClas;}
		
	public Long getTiclOidTipoClie() {return ticlOidTipoClie;}
      
	public void setTiclOidTipoClie(Long ticlOidTipoClie){this.ticlOidTipoClie=ticlOidTipoClie;}
			
	
}
