package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_CHEQU_UA")
@NamedQueries({
@NamedQuery(name="ChequeoUALocal.FindAll",query="select object(o) from ChequeoUALocal o")
})
public class ChequeoUALocal implements Serializable {

	public ChequeoUALocal() {}

	public ChequeoUALocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_CHEQ_UA")
	private Long oid;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
        @Column(name="ZSGV_OID_SUBG_VENT")
        private Long oidSubgerenciaVenta;
        @Column(name="ZORG_OID_REGI")
        private Long oidRegion;
        @Column(name="ZZON_OID_ZONA")
        private Long oidZona;
        @Column(name="ZSCC_OID_SECC")
        private Long oidSeccion;
        @Column(name="TIRV_OID_TIPO_INDI_REVI")
        private Long oidTipoChequeo;
        
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
        public Long getOidPeriodo() {return oidPeriodo;}
        
        public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
        
        public Long getOidSubgerenciaVenta() {return oidSubgerenciaVenta;}
        
        public void setOidSubgerenciaVenta(Long oidSubgerenciaVenta){this.oidSubgerenciaVenta=oidSubgerenciaVenta;}
        
        public Long getOidRegion() {return oidRegion;}
        
        public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
        
        public Long getOidZona() {return oidZona;}
        
        public void setOidZona(Long oidZona){this.oidZona=oidZona;}
		
	public Long getOidSeccion() {return oidSeccion;}
      
	public void setOidSeccion(Long oidSeccion){this.oidSeccion=oidSeccion;}
			
        public Long getOidTipoChequeo() {return oidTipoChequeo;}
        
        public void setOidTipoChequeo(Long oidTipoChequeo){this.oidTipoChequeo=oidTipoChequeo;}                        
	
}
