package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_MATRI_REEMP")
@NamedQueries({
@NamedQuery(name="MatrizCodigosReemplazoLocal.FindByOidPpal",query="SELECT OBJECT(a) "
+ "FROM MatrizCodigosReemplazoLocal AS a WHERE a.oidCodPpal = ?1"),
@NamedQuery(name="MatrizCodigosReemplazoLocal.FindByOidReemp",query="SELECT OBJECT(a) "
+"FROM MatrizCodigosReemplazoLocal AS a WHERE a.oidCodReem = ?1")
})
public class MatrizCodigosReemplazoLocal implements Serializable {

	public MatrizCodigosReemplazoLocal() {}

	public MatrizCodigosReemplazoLocal(Long oid, Long mafa_oid_cod_ppal, 
                    Long mafa_oid_cod_reem, Boolean antesDespuesCuadre, Boolean emiteMsj) {
	
		this.oid=oid;
                this.oidCodPpal=mafa_oid_cod_ppal;
                this.oidCodReem=mafa_oid_cod_reem;
                this.indicadorAntesDespuesCuadre=antesDespuesCuadre;
                this.emiteMensaje=emiteMsj;
	
	}

	@Id
	@Column(name="OID_MATR_REEM")
	private Long oid;
	@Column(name="MAFA_OID_COD_PPAL")
	private Long oidCodPpal;
	@Column(name="MAFA_OID_COD_REEM")
	private Long oidCodReem;
	@Column(name="IND_MENS")
	private Boolean emiteMensaje;
	@Column(name="IND_REEM_ANTE_CUAD")
	private Boolean indicadorAntesDespuesCuadre;
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
		
	public Long getOidCodReem() {return oidCodReem;}
      
	public void setOidCodReem(Long oidCodReem){this.oidCodReem=oidCodReem;}
		
	public Boolean getEmiteMensaje() {return emiteMensaje;}
      
	public void setEmiteMensaje(Boolean emiteMensaje){this.emiteMensaje=emiteMensaje;}
		
	public Boolean getIndicadorAntesDespuesCuadre() {return indicadorAntesDespuesCuadre;}
      
	public void setIndicadorAntesDespuesCuadre(Boolean indicadorAntesDespuesCuadre){this.indicadorAntesDespuesCuadre=indicadorAntesDespuesCuadre;}
			
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
