package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_SUBTI_CLIEN_DETAL")
@NamedQueries({
@NamedQuery(name="SubtipoClienteDetalleMAVLocal.FindByOidDetaMav",query="SELECT OBJECT(a) "+
" FROM SubtipoClienteDetalleMAVLocal AS a "+
" WHERE a.oidDetalleMAV = ?1")
})
public class SubtipoClienteDetalleMAVLocal implements Serializable {

	public SubtipoClienteDetalleMAVLocal() {}

	public SubtipoClienteDetalleMAVLocal(Long oid, Long oidSubtipoCliente, Long oidDetalleMAV){
	
		this.oid=oid;
                this.oidSubtipoCliente=oidSubtipoCliente;
                this.oidDetalleMAV=oidDetalleMAV;                
	
	}

	@Id
	@Column(name="OID_SUBT_CLTE_DETA")
	private Long oid;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long oidSubtipoCliente;
	@Column(name="DENV_OID_DETA_MAV")
	private Long oidDetalleMAV;
        
        // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
        @Column(name="TCCL_OID_TIPO_CLASI")
        private Long oidTipoClasificacion;
        @Column(name="CLAS_OID_CLAS")
        private Long oidClasificacion;
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidSubtipoCliente() {return oidSubtipoCliente;}
      
	public void setOidSubtipoCliente(Long oidSubtipoCliente){this.oidSubtipoCliente=oidSubtipoCliente;}
		
	public Long getOidDetalleMAV() {return oidDetalleMAV;}
      
	public void setOidDetalleMAV(Long oidDetalleMAV){this.oidDetalleMAV=oidDetalleMAV;}

        public void setOidTipoClasificacion(Long oidTipoClasificacion) {this.oidTipoClasificacion = oidTipoClasificacion;}

        public Long getOidTipoClasificacion() {return oidTipoClasificacion;}

        public void setOidClasificacion(Long oidClasificacion) {this.oidClasificacion = oidClasificacion;}

        public Long getOidClasificacion() { return oidClasificacion; }
        
}
