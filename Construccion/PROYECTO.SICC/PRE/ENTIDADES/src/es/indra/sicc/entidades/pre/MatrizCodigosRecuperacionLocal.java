package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_MATRI_RECUP")
@NamedQueries({
@NamedQuery(name="MatrizCodigosRecuperacionLocal.FindByOidPpal",query="SELECT OBJECT(a) "
+"FROM MatrizCodigosRecuperacionLocal AS a WHERE a.oidCodPpal = ?1"),
@NamedQuery(name="MatrizCodigosRecuperacionLocal.FindByOidRecu",query="SELECT OBJECT(a) "
+"FROM MatrizCodigosRecuperacionLocal AS a WHERE a.oidCodRecu = ?1")
})
public class MatrizCodigosRecuperacionLocal implements Serializable {

	public MatrizCodigosRecuperacionLocal() {}

	public MatrizCodigosRecuperacionLocal(Long oid, Long mafa_oid_cod_ppal,
                                    Long mafa_oid_cod_recu, Boolean recupAuto, Boolean emiteMsj) {
	
		this.oid=oid;
                this.oidCodPpal=mafa_oid_cod_ppal;
                this.oidCodRecu=mafa_oid_cod_recu;
                this.recuperacionAutomatica=recupAuto;
                this.emiteMensaje=emiteMsj;
	
	}

	@Id
	@Column(name="OID_MATR_RECU")
	private Long oid;
	@Column(name="MAFA_OID_COD_PPAL")
	private Long oidCodPpal;
	@Column(name="MAFA_OID_COD_RECU")
	private Long oidCodRecu;
	@Column(name="IND_RECU_AUTO")
	private Boolean recuperacionAutomatica;
	@Column(name="IND_MENS")
	private Boolean emiteMensaje;
        @Column(name="ZORG_OID_REGI")
        private Long oidRegion;
        @Column(name="ZZON_OID_ZONA")
        private Long oidZona;
        @Column(name="TICL_OID_TIPO_CLIE")
        private Long tipoCliente;
        @Column(name="SBTI_OID_SUBTI_CLIEN")
        private Long subTipoCliente;
        @Column(name="TCCL_OID_TIPO_CLAS")
        private Long tipoClasificacion;
        @Column(name="CLAS_OID_CLAS")
        private Long clasificacion;  
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidCodPpal() {return oidCodPpal;}
      
	public void setOidCodPpal(Long oidCodPpal){this.oidCodPpal=oidCodPpal;}
		
	public Long getOidCodRecu() {return oidCodRecu;}
      
	public void setOidCodRecu(Long oidCodRecu){this.oidCodRecu=oidCodRecu;}
		
	public Boolean getRecuperacionAutomatica() {return recuperacionAutomatica;}
      
	public void setRecuperacionAutomatica(Boolean recuperacionAutomatica){this.recuperacionAutomatica=recuperacionAutomatica;}
		
	public Boolean getEmiteMensaje() {return emiteMensaje;}
      
	public void setEmiteMensaje(Boolean emiteMensaje){this.emiteMensaje=emiteMensaje;}
			
        public Long getOidRegion() {return oidRegion;}
        
        public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
        
        public Long getOidZona() {return oidZona;}
        
        public void setOidZona(Long oidZona){this.oidZona=oidZona;}
        
        public Long getTipoCliente() {return tipoCliente;}
        
        public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
        
        public Long getSubTipoCliente() {return subTipoCliente;}
        
        public void setSubTipoCliente(Long subTipoCliente){this.subTipoCliente=subTipoCliente;}
        
        public Long getTipoClasificacion() {return tipoClasificacion;}
        
        public void setTipoClasificacion(Long tipoClasificacion){this.tipoClasificacion=tipoClasificacion;}
        
        public Long getClasificacion() {return clasificacion;}
        
        public void setClasificacion(Long clasificacion){this.clasificacion=clasificacion;}
}
