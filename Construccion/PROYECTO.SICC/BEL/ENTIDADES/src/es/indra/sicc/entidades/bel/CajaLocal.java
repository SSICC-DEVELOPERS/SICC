package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BEL_CAJA")
public class CajaLocal implements Serializable {

	public CajaLocal() {}

	    public CajaLocal(Long oid, Long pais, Long subAcceso, String codigoCaja, Character estadoCaja, Timestamp fechaCierre,  Long usuario) {
	            this.oid = oid;
	            this.pais = pais;
	            this.subAcceso = subAcceso;
	            this.codigoCaja = codigoCaja;
	            this.estadoCaja = estadoCaja;
	            this.fechaCierre = fechaCierre;
	            this.usuario = usuario;
	    }

	public CajaLocal(Long oid, Long pais, Long subAcceso, String codigoCaja, Character estadoCaja, Timestamp fechaCierre, Long oidTipoCaja, Long usuario) {
		this.oid = oid;
                this.pais = pais;
                this.subAcceso = subAcceso;
                this.codigoCaja = codigoCaja;
                this.estadoCaja = estadoCaja;
                this.fechaCierre = fechaCierre;
                this.oidTipoCaja = oidTipoCaja;
                this.usuario = usuario;
	}

	@Id
	@Column(name="OID_CAJA")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="SBAC_OID_SBAC")
	private Long subAcceso;
	@Column(name="COD_CAJA")
	private String codigoCaja;
	@Column(name="VAL_ESTA_CAJA")
	private Character estadoCaja;
        @Column(name="FEC_CIER")
        //@Temporal(TemporalType.DATE)
        private java.sql.Timestamp fechaCierre;
        @Column(name="TICJ_OID_TIPO_CAJA")
	private Long oidTipoCaja;
	@Column(name="USER_OID_USER")
	private Long usuario;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getSubAcceso() {return subAcceso;}
      
	public void setSubAcceso(Long subAcceso){this.subAcceso=subAcceso;}
		
	public String getCodigoCaja() {return codigoCaja;}
      
	public void setCodigoCaja(String codigoCaja){this.codigoCaja=codigoCaja;}
		
	public Character getEstadoCaja() {return estadoCaja;}
      
	public void setEstadoCaja(Character estadoCaja){this.estadoCaja=estadoCaja;}
		
	public java.sql.Timestamp getFechaCierre() {return fechaCierre;}
      
	public void setFechaCierre(java.sql.Timestamp fechaCierre){this.fechaCierre=fechaCierre;}
		
	public Long getOidTipoCaja() {return oidTipoCaja;}
      
	public void setOidTipoCaja(Long oidTipoCaja){this.oidTipoCaja=oidTipoCaja;}
		
	public Long getUsuario() {return usuario;}
      
	public void setUsuario(Long usuario){this.usuario=usuario;}
			
	
}
