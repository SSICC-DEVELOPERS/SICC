package es.indra.sicc.entidades.mav;

import java.sql.Date;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ACTIV")
public class ActividadesMAVLocal implements Serializable {

	public ActividadesMAVLocal() {}

	public ActividadesMAVLocal(Long oid, Long oidPais, Long oidTipoCondicionDePago, Long oidCanal, Long oidFormaDePago, String descripcionDetallada,
                                                    Long oidMarca, Long oidTipoCliente)	{
	
		this.oid=oid;
                this.oidPais=oidPais;
                this.oidTipoCondicionPago=oidTipoCondicionDePago;
                this.oidCanal=oidCanal;
                this.oidFormaPago=oidFormaDePago;
                this.descripcionDetallada=descripcionDetallada;
                this.oidMarca=oidMarca;
                this.oidTipoCliente=oidTipoCliente;                
	
	}

	@Id
	@Column(name="OID_ACTI")
	private Long oid;
	@Column(name="VAL_CAMP_EVAL")
	private Integer campagnaEvaluacion;
	@Column(name="VAL_PORC_SOBR_COST")
	private Integer porcentajeSobreCosto;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="TCPA_OID_TIPO_COND_PAGO")
	private Long oidTipoCondicionPago;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="SOCI_OID_SOCI")
	private Long oidEmpresa;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long oidFormaPago;
	@Column(name="CLIE_OID_CLIE")
	private Long oidClienteDatosBasicos;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS_PAGO")
	private Long oidTipoSolicitudParaPago;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS_DEST")
	private Long oidTipoSolicitudDestino;
	@Column(name="TPOS_OID_TIPO_POSI_PAGO")
	private Long oidTipoPosicionParaPago;
	@Column(name="TPOS_OID_TIPO_POSI_DEST")
	private Long oidTipoPosicionDestino;
	@Column(name="IND_FACT_INTE_COMP")
	private Boolean facturaIntercompagnias;
	@Column(name="DES_DETA")
	private String descripcionDetallada;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long oidTipoCliente;
	@Column(name="STPO_OID_SUBT_POSI_PAGO")
	private Long oidSubtipoPosicionParaPago;
	@Column(name="STPO_OID_SUBT_POSI_ENVI")
	private Long oidSubtipoPosicionEnvio;

        // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
        @Column(name="USU_CREA")
        private String usuarioCreacion;
        @Column(name="FEC_CREA")
        private java.sql.Timestamp fechaCreacion;
        @Column(name="USU_MODI")
        private String usuarioModificacion;
        @Column(name="FEC_MODI")
        private java.sql.Timestamp fechaModificacion;
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getCampagnaEvaluacion() {return campagnaEvaluacion;}
      
	public void setCampagnaEvaluacion(Integer campagnaEvaluacion){this.campagnaEvaluacion=campagnaEvaluacion;}
		
	public Integer getPorcentajeSobreCosto() {return porcentajeSobreCosto;}
      
	public void setPorcentajeSobreCosto(Integer porcentajeSobreCosto){this.porcentajeSobreCosto=porcentajeSobreCosto;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidTipoCondicionPago() {return oidTipoCondicionPago;}
      
	public void setOidTipoCondicionPago(Long oidTipoCondicionPago){this.oidTipoCondicionPago=oidTipoCondicionPago;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidEmpresa() {return oidEmpresa;}
      
	public void setOidEmpresa(Long oidEmpresa){this.oidEmpresa=oidEmpresa;}
		
	public Long getOidFormaPago() {return oidFormaPago;}
      
	public void setOidFormaPago(Long oidFormaPago){this.oidFormaPago=oidFormaPago;}
		
	public Long getOidClienteDatosBasicos() {return oidClienteDatosBasicos;}
      
	public void setOidClienteDatosBasicos(Long oidClienteDatosBasicos){this.oidClienteDatosBasicos=oidClienteDatosBasicos;}
		
	public Long getOidTipoSolicitudParaPago() {return oidTipoSolicitudParaPago;}
      
	public void setOidTipoSolicitudParaPago(Long oidTipoSolicitudParaPago){this.oidTipoSolicitudParaPago=oidTipoSolicitudParaPago;}
		
	public Long getOidTipoSolicitudDestino() {return oidTipoSolicitudDestino;}
      
	public void setOidTipoSolicitudDestino(Long oidTipoSolicitudDestino){this.oidTipoSolicitudDestino=oidTipoSolicitudDestino;}
		
	public Long getOidTipoPosicionParaPago() {return oidTipoPosicionParaPago;}
      
	public void setOidTipoPosicionParaPago(Long oidTipoPosicionParaPago){this.oidTipoPosicionParaPago=oidTipoPosicionParaPago;}
		
	public Long getOidTipoPosicionDestino() {return oidTipoPosicionDestino;}
      
	public void setOidTipoPosicionDestino(Long oidTipoPosicionDestino){this.oidTipoPosicionDestino=oidTipoPosicionDestino;}
		
	public Boolean getFacturaIntercompagnias() {return facturaIntercompagnias;}
      
	public void setFacturaIntercompagnias(Boolean facturaIntercompagnias){this.facturaIntercompagnias=facturaIntercompagnias;}
		
	public String getDescripcionDetallada() {return descripcionDetallada;}
      
	public void setDescripcionDetallada(String descripcionDetallada){this.descripcionDetallada=descripcionDetallada;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidTipoCliente() {return oidTipoCliente;}
      
	public void setOidTipoCliente(Long oidTipoCliente){this.oidTipoCliente=oidTipoCliente;}
		
	public Long getOidSubtipoPosicionParaPago() {return oidSubtipoPosicionParaPago;}
      
	public void setOidSubtipoPosicionParaPago(Long oidSubtipoPosicionParaPago){this.oidSubtipoPosicionParaPago=oidSubtipoPosicionParaPago;}
		
	public Long getOidSubtipoPosicionEnvio() {return oidSubtipoPosicionEnvio;}
      
	public void setOidSubtipoPosicionEnvio(Long oidSubtipoPosicionEnvio){this.oidSubtipoPosicionEnvio=oidSubtipoPosicionEnvio;}

        public void setUsuarioCreacion(String usuarioCreacion) {
            this.usuarioCreacion = usuarioCreacion;
        }
    
        public String getUsuarioCreacion() {
            return usuarioCreacion;
        }
    
        public void setFechaCreacion(Timestamp fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }
    
        public Timestamp getFechaCreacion() {
            return fechaCreacion;
        }
    
        public void setUsuarioModificacion(String usuarioModificacion) {
            this.usuarioModificacion = usuarioModificacion;
        }
    
        public String getUsuarioModificacion() {
            return usuarioModificacion;
        }
    
        public void setFechaModificacion(Timestamp fechaModificacion) {
            this.fechaModificacion = fechaModificacion;
        }
    
        public Timestamp getFechaModificacion() {
            return fechaModificacion;
        }
    
}
