package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_TIPO_SOLIC_PAIS")
@NamedQueries({
@NamedQuery(name="TiposSolicitudPaisLocal.FindByUK",query="SELECT OBJECT(o) "
+ " FROM TiposSolicitudPaisLocal AS o "
+ " WHERE o.oidPais = ?1 "
+ " AND o.oidTipoSolicitud = ?2"),
@NamedQuery(name="TiposSolicitudPaisLocal.FindAll",query="SELECT OBJECT(p) from TiposSolicitudPaisLocal p")
})
public class TiposSolicitudPaisLocal implements Serializable {

	public TiposSolicitudPaisLocal() {}

	public TiposSolicitudPaisLocal(Long oid, Long oidPais, Long oidTipoSolicitud, Boolean sujetoFlete,
                Boolean reservaStock, Boolean permiteReversion, Boolean indPedidoPrueba, 
                Boolean indComisionable, Boolean indVentaSAB14, Boolean permiteUnionSolicitudes, 
                Boolean indPedGtZona, Boolean indCambioVentaBEL) {
	
            this.oid=oid;
	    setOidPais(oidPais);
	    setOidTipoSolicitud(oidTipoSolicitud);
	    setSujetoFlete(sujetoFlete);
	    setReservaStock(reservaStock);
	    setPermiteReversion(permiteReversion);
	    setIndPedidoPrueba(indPedidoPrueba);
	    setIndComisionable(indComisionable);            
	    setIndVentaSAB14(indVentaSAB14);
	    setPermiteUnionSolicitudes(permiteUnionSolicitudes);
	    setIndPedGtZona(indPedGtZona);
	    setIndCambioVentaBEL(indCambioVentaBEL);
	}

	@Id
	@Column(name="OID_TIPO_SOLI_PAIS")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="TSOL_OID_TIPO_SOLI")
	private Long oidTipoSolicitud;
	@Column(name="NUM_SOLI_LOTE")
	private Integer numPorLote;
	@Column(name="NUM_UNID_ALAR")
	private Integer alarmaNumUnidades;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long oidFormaPago;
	@Column(name="IND_SUJE_FLET")
	private Boolean sujetoFlete;
	@Column(name="IND_RESE_STOC")
	private Boolean reservaStock;
	@Column(name="IND_PERM_REVE")
	private Boolean permiteReversion;
	@Column(name="IND_PEDI_PRUE")
	private Boolean indPedidoPrueba;
	@Column(name="IND_COMI")
	private Boolean indComisionable;
	@Column(name="IND_VENT_INTE_SAB_14")
	private Boolean indVentaSAB14;
	@Column(name="TSOL_OID_TIPO_CONS")
	private Long oidTipoConsolidado;
	@Column(name="CACT_OID_ACTI")
	private Long oidActividad;
	@Column(name="MONE_OID_MONE")
	private Long oidMoneda;
	@Column(name="TMAL_OID_TIPO_MOVI_ASIG")
	private Long oidTipoMovAsigna;
	@Column(name="TMAL_OID_TIPO_MOVI_RESE")
	private Long oidTipoMovReserva;
	@Column(name="TMAL_OID_TIPO_MOVI_FACT")
	private Long oidTipoMovFacturacion;
	@Column(name="TIDO_OID_TIPO_DOCU")
	private Long oidTipoDocumentoLegal;
	@Column(name="IND_PERM_UNIO")
	private Boolean permiteUnionSolicitudes;
	@Column(name="IND_PEDI_GT_ZONA")
	private Boolean indPedGtZona;
	@Column(name="IND_CAMB_VENT_BEL")
	private Boolean indCambioVentaBEL;
	@Column(name="ALMC_OID_ALMA")
	private Long oidAlmacen;
	@Column(name="SOCI_OID_SOCI")
	private Long oidSociedad;
	@Column(name="VAL_GLOS")
	private String glosa;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidTipoSolicitud() {return oidTipoSolicitud;}
      
	public void setOidTipoSolicitud(Long oidTipoSolicitud){this.oidTipoSolicitud=oidTipoSolicitud;}
		
	public Integer getNumPorLote() {return numPorLote;}
      
	public void setNumPorLote(Integer numPorLote){this.numPorLote=numPorLote;}
		
	public Integer getAlarmaNumUnidades() {return alarmaNumUnidades;}
      
	public void setAlarmaNumUnidades(Integer alarmaNumUnidades){this.alarmaNumUnidades=alarmaNumUnidades;}
		
	public Long getOidFormaPago() {return oidFormaPago;}
      
	public void setOidFormaPago(Long oidFormaPago){this.oidFormaPago=oidFormaPago;}
		
	public Boolean getSujetoFlete() {return sujetoFlete;}
      
	public void setSujetoFlete(Boolean sujetoFlete){this.sujetoFlete=sujetoFlete;}
		
	public Boolean getReservaStock() {return reservaStock;}
      
	public void setReservaStock(Boolean reservaStock){this.reservaStock=reservaStock;}
		
	public Boolean getPermiteReversion() {return permiteReversion;}
      
	public void setPermiteReversion(Boolean permiteReversion){this.permiteReversion=permiteReversion;}
		
	public Boolean getIndPedidoPrueba() {return indPedidoPrueba;}
      
	public void setIndPedidoPrueba(Boolean indPedidoPrueba){this.indPedidoPrueba=indPedidoPrueba;}
		
	public Boolean getIndComisionable() {return indComisionable;}
      
	public void setIndComisionable(Boolean indComisionable){this.indComisionable=indComisionable;}
		
	public Boolean getIndVentaSAB14() {return indVentaSAB14;}
      
	public void setIndVentaSAB14(Boolean indVentaSAB14){this.indVentaSAB14=indVentaSAB14;}
		
	public Long getOidTipoConsolidado() {return oidTipoConsolidado;}
      
	public void setOidTipoConsolidado(Long oidTipoConsolidado){this.oidTipoConsolidado=oidTipoConsolidado;}
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidMoneda() {return oidMoneda;}
      
	public void setOidMoneda(Long oidMoneda){this.oidMoneda=oidMoneda;}
		
	public Long getOidTipoMovAsigna() {return oidTipoMovAsigna;}
      
	public void setOidTipoMovAsigna(Long oidTipoMovAsigna){this.oidTipoMovAsigna=oidTipoMovAsigna;}
		
	public Long getOidTipoMovReserva() {return oidTipoMovReserva;}
      
	public void setOidTipoMovReserva(Long oidTipoMovReserva){this.oidTipoMovReserva=oidTipoMovReserva;}
		
	public Long getOidTipoMovFacturacion() {return oidTipoMovFacturacion;}
      
	public void setOidTipoMovFacturacion(Long oidTipoMovFacturacion){this.oidTipoMovFacturacion=oidTipoMovFacturacion;}
		
	public Long getOidTipoDocumentoLegal() {return oidTipoDocumentoLegal;}
      
	public void setOidTipoDocumentoLegal(Long oidTipoDocumentoLegal){this.oidTipoDocumentoLegal=oidTipoDocumentoLegal;}
		
	public Boolean getPermiteUnionSolicitudes() {return permiteUnionSolicitudes;}
      
	public void setPermiteUnionSolicitudes(Boolean permiteUnionSolicitudes){this.permiteUnionSolicitudes=permiteUnionSolicitudes;}
		
	public Boolean getIndPedGtZona() {return indPedGtZona;}
      
	public void setIndPedGtZona(Boolean indPedGtZona){this.indPedGtZona=indPedGtZona;}
		
	public Boolean getIndCambioVentaBEL() {return indCambioVentaBEL;}
      
	public void setIndCambioVentaBEL(Boolean indCambioVentaBEL){this.indCambioVentaBEL=indCambioVentaBEL;}
		
	public Long getOidAlmacen() {return oidAlmacen;}
      
	public void setOidAlmacen(Long oidAlmacen){this.oidAlmacen=oidAlmacen;}
		
	public Long getOidSociedad() {return oidSociedad;}
      
	public void setOidSociedad(Long oidSociedad){this.oidSociedad=oidSociedad;}
		
	public String getGlosa() {return glosa;}
      
	public void setGlosa(String glosa){this.glosa=glosa;}
			
	
}
