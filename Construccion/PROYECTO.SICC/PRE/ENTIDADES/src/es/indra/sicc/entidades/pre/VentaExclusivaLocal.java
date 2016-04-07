package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_VENTA_EXCLU")
@NamedQueries({
@NamedQuery(name="VentaExclusivaLocal.FindByOidOferta",query="SELECT OBJECT(a) "
+ "FROM VentaExclusivaLocal AS a WHERE a.oidOferta = ?1")
})
public class VentaExclusivaLocal implements Serializable {

	public VentaExclusivaLocal() {}

	public VentaExclusivaLocal(Long oid, Long ofer_oid_ofer, Long oidSubtipoCliente,
                                         Long oidEstatusCliente, Long oidClasificacion, 
                                         Long oidTipoCliente, Long oidTipoClasificacion) {
	
		this.oid=oid;
                this.oidOferta=ofer_oid_ofer;
                this.oidSubtClie=oidSubtipoCliente;
                this.oidEstaClie=oidEstatusCliente;
                this.oidClas=oidClasificacion;
                this.oidTipoClie=oidTipoCliente;
                this.oidTipoClas=oidTipoClasificacion;
	
	}

	@Id
	@Column(name="OID_VENT_EXCL")
	private Long oid;
	@Column(name="OFER_OID_OFER")
	private Long oidOferta;
	@Column(name="TCCL_OID_TIPO_CLAS")
	private Long oidTipoClas;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long oidTipoClie;
	@Column(name="CLAS_OID_CLAS")
	private Long oidClas;
	@Column(name="ESTA_OID_ESTA_CLIE")
	private Long oidEstaClie;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long oidSubtClie;
	@Column(name="VAL_ESTA_2")
	private String estatus2;
        @Column(name="ZORG_OID_REGI")
        private Long oidRegion;
        @Column(name="ZZON_OID_ZONA")
        private Long oidZona;        

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidOferta() {return oidOferta;}
      
	public void setOidOferta(Long oidOferta){this.oidOferta=oidOferta;}
		
	public Long getOidTipoClas() {return oidTipoClas;}
      
	public void setOidTipoClas(Long oidTipoClas){this.oidTipoClas=oidTipoClas;}
		
	public Long getOidTipoClie() {return oidTipoClie;}
      
	public void setOidTipoClie(Long oidTipoClie){this.oidTipoClie=oidTipoClie;}
		
	public Long getOidClas() {return oidClas;}
      
	public void setOidClas(Long oidClas){this.oidClas=oidClas;}
		
	public Long getOidEstaClie() {return oidEstaClie;}
      
	public void setOidEstaClie(Long oidEstaClie){this.oidEstaClie=oidEstaClie;}
		
	public Long getOidSubtClie() {return oidSubtClie;}
      
	public void setOidSubtClie(Long oidSubtClie){this.oidSubtClie=oidSubtClie;}
		
	public String getEstatus2() {return estatus2;}
      
	public void setEstatus2(String estatus2){this.estatus2=estatus2;}
        
        public Long getOidRegion() {return oidRegion;}
        
        public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
        
        public Long getOidZona() {return oidZona;}
        
        public void setOidZona(Long oidZona){this.oidZona=oidZona;}        
			
	
}
