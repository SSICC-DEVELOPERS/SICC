package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_PARAM")
@NamedQueries({
@NamedQuery(name="ParametrizacionMAVLocal.FindByUK",query="SELECT OBJECT(a) "+
" FROM ParametrizacionMAVLocal AS a "+
" WHERE a.oidPais = ?1")
})
public class ParametrizacionMAVLocal implements Serializable {

	public ParametrizacionMAVLocal() {}

	public ParametrizacionMAVLocal(Long oid, Long oidPais, Long oidEstrategia, Long numeroRegistrosAviso,
                                    Long limitePrecioAutorizacion, String direccionElectronicaEnvioFaltaStock,
                                    Long oidTipoClienteZona, Long oidTipoClienteRegion, Long oidAlmacenes,
                                    Boolean requerirAutorizacion) {
	
		this.oid=oid;
                this.oidPais=oidPais;
                this.oidEstrategia=oidEstrategia;
                this.numeroRegistrosAviso=numeroRegistrosAviso;
                this.limitePrecioAutorizacion=limitePrecioAutorizacion;
                this.direccionElectronicaEnvioFaltaStock=direccionElectronicaEnvioFaltaStock;
                this.oidTipoClienteZona=oidTipoClienteZona;
                this.oidTipoClienteRegion=oidTipoClienteRegion;
                this.oidAlmacenes=oidAlmacenes;
                this.requerirAutorizacion=requerirAutorizacion;                
	
	}

	@Id
	@Column(name="OID_PARA_MAV")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="COES_OID_ESTR")
	private Long oidEstrategia;
	@Column(name="NUM_REGI_AVIS")
	private Long numeroRegistrosAviso;
	@Column(name="VAL_LIMI_PREC_AUTO")
	private Long limitePrecioAutorizacion;
	@Column(name="VAL_DIRE_ELEC_ENVI_FALT_STOC")
	private String direccionElectronicaEnvioFaltaStock;
	@Column(name="TICL_OID_TIPO_CLIE_ZONA")
	private Long oidTipoClienteZona;
	@Column(name="TICL_OID_TIPO_CLIE_REGI")
	private Long oidTipoClienteRegion;
	@Column(name="ALMC_OID_ALMA")
	private Long oidAlmacenes;
	@Column(name="IND_REQU_AUTO")
	private Boolean requerirAutorizacion;

        // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
        @Column(name="OCAT_OID_CATA")
        private Long oidCatalogo;
        @Column(name="CNDP_OID_COND_PROM")
        private Long oidCondicionPromocion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidEstrategia() {return oidEstrategia;}
      
	public void setOidEstrategia(Long oidEstrategia){this.oidEstrategia=oidEstrategia;}
		
	public Long getNumeroRegistrosAviso() {return numeroRegistrosAviso;}
      
	public void setNumeroRegistrosAviso(Long numeroRegistrosAviso){this.numeroRegistrosAviso=numeroRegistrosAviso;}
		
	public Long getLimitePrecioAutorizacion() {return limitePrecioAutorizacion;}
      
	public void setLimitePrecioAutorizacion(Long limitePrecioAutorizacion){this.limitePrecioAutorizacion=limitePrecioAutorizacion;}
		
	public String getDireccionElectronicaEnvioFaltaStock() {return direccionElectronicaEnvioFaltaStock;}
      
	public void setDireccionElectronicaEnvioFaltaStock(String direccionElectronicaEnvioFaltaStock){this.direccionElectronicaEnvioFaltaStock=direccionElectronicaEnvioFaltaStock;}
		
	public Long getOidTipoClienteZona() {return oidTipoClienteZona;}
      
	public void setOidTipoClienteZona(Long oidTipoClienteZona){this.oidTipoClienteZona=oidTipoClienteZona;}
		
	public Long getOidTipoClienteRegion() {return oidTipoClienteRegion;}
      
	public void setOidTipoClienteRegion(Long oidTipoClienteRegion){this.oidTipoClienteRegion=oidTipoClienteRegion;}
		
	public Long getOidAlmacenes() {return oidAlmacenes;}
      
	public void setOidAlmacenes(Long oidAlmacenes){this.oidAlmacenes=oidAlmacenes;}
		
	public Boolean getRequerirAutorizacion() {return requerirAutorizacion;}
      
	public void setRequerirAutorizacion(Boolean requerirAutorizacion){this.requerirAutorizacion=requerirAutorizacion;}

        public void setOidCatalogo(Long oidCatalogo) {this.oidCatalogo = oidCatalogo;}
    
        public Long getOidCatalogo() {return oidCatalogo;}    
        
        public void setOidCondicionPromocion(Long oidCondicionPromocion) {this.oidCondicionPromocion = oidCondicionPromocion;}
    
        public Long getOidCondicionPromocion() {return oidCondicionPromocion;}
        
}
