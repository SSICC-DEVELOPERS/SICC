package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_MATRI_CODIG_ALTER")
@NamedQueries({
@NamedQuery(name="MatrizCodigosAternativosLocal.FindByOidPpal",query="SELECT OBJECT(a) "
+" FROM MatrizCodigosAternativosLocal AS a WHERE a.oidCodPpal = ?1"),
@NamedQuery(name="MatrizCodigosAternativosLocal.FindByOidAlte",query="SELECT OBJECT(a) "
+" FROM MatrizCodigosAternativosLocal AS a WHERE a.oidCodAlte = ?1")
})
public class MatrizCodigosAternativosLocal implements Serializable {

	public MatrizCodigosAternativosLocal() {}

	public MatrizCodigosAternativosLocal(Long oid, Long mafa_oid_cod_ppal, Long mafa_oid_cod_alte,
                                                Long num_orde, Boolean ind_mens) {
	
		this.oid=oid;
                this.oidCodPpal=mafa_oid_cod_ppal;
                this.oidCodAlte=mafa_oid_cod_alte;
                this.numeroOrden=num_orde;
                this.indicadorMensaje=ind_mens;
	
	}

	@Id
	@Column(name="OID_MATR_ATER")
	private Long oid;
	@Column(name="MAFA_OID_COD_PPAL")
	private Long oidCodPpal;
	@Column(name="MAFA_OID_COD_ALTE")
	private Long oidCodAlte;
	@Column(name="NUM_ORDE")
	private Long numeroOrden;
	@Column(name="IND_MENS")
	private Boolean indicadorMensaje;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidCodPpal() {return oidCodPpal;}
      
	public void setOidCodPpal(Long oidCodPpal){this.oidCodPpal=oidCodPpal;}
		
	public Long getOidCodAlte() {return oidCodAlte;}
      
	public void setOidCodAlte(Long oidCodAlte){this.oidCodAlte=oidCodAlte;}
		
	public Long getNumeroOrden() {return numeroOrden;}
      
	public void setNumeroOrden(Long numeroOrden){this.numeroOrden=numeroOrden;}
		
	public Boolean getIndicadorMensaje() {return indicadorMensaje;}
      
	public void setIndicadorMensaje(Boolean indicadorMensaje){this.indicadorMensaje=indicadorMensaje;}
			
	
}
