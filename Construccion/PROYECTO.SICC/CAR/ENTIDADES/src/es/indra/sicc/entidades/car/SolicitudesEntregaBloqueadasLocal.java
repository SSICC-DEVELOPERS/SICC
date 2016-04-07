package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;
import java.math.BigDecimal;

@Entity
@Table(name="CAR_SOLI_ENTR_BLOQ")
@NamedQueries({
@NamedQuery(name="SolicitudesEntregaBloqueadasLocal.FindBySolicitud",query="SELECT OBJECT(a) "
          + "  FROM SolicitudesEntregaBloqueadasLocal AS a "
          + "  WHERE a.oidSolcitudCabecera = ?1")
})
public class SolicitudesEntregaBloqueadasLocal implements Serializable {

	public SolicitudesEntregaBloqueadasLocal() {}

	public SolicitudesEntregaBloqueadasLocal(Long oid, Long oidPais, Long oidSubAcceso, Long oidTipoSolicitud, Long oidSolicitud, Date fechaSolicitud, Integer indNotificacion, BigDecimal montoSolicitud, BigDecimal montoDeudaVencida, Integer indDeudaVencida, Integer indLineaCredito, Integer indMontoMaximo, Integer indPorcentajeMaximo, Long oidJerarquia, Long estatus, Long oidPeriodo, Long oidCliente, Long oidNivelRiesgo, Long oidGrupoSolicitud, Long oidZona)	{
	
		this.oid=oid;
	        this.setOidPais(oidPais);
	        this.setOidSubacceso(oidSubAcceso);
	        this.setOidTipoSolicitud(oidTipoSolicitud);
	        this.setOidSolcitudCabecera(oidSolicitud);
	        this.setFechaDocumento(fechaSolicitud);
	        this.setIndicadorNotificado(indNotificacion.intValue()==1?Boolean.TRUE:Boolean.FALSE);
	        this.setMontoOrden(new Double(montoSolicitud.toString()));
                
	        if (montoDeudaVencida != null)  
                    this.setMontoDeudaVencida(new Double(montoDeudaVencida.toString()));
	        else
	            this.setMontoDeudaVencida(null);
	        
	        if (indDeudaVencida!=null)
	            this.setIndicadorValidacion1(indDeudaVencida.intValue()==1?Boolean.TRUE:Boolean.FALSE);
	        if (indLineaCredito!=null)
	            this.setIndicadorValidacion2(indLineaCredito.intValue()==1?Boolean.TRUE:Boolean.FALSE);
	        if (indMontoMaximo!=null)
	            this.setIndicadorValidacion3(indMontoMaximo.intValue()==1?Boolean.TRUE:Boolean.FALSE);
	        if (indPorcentajeMaximo!=null)
	            this.setIndicadorValidacion4(indPorcentajeMaximo.intValue()==1?Boolean.TRUE:Boolean.FALSE);        
                    
	        this.setOidJerarquia(oidJerarquia);
	        this.setOidEstatusPedido(estatus);
	        this.setOidPeriodo(oidPeriodo);
	        this.setOidCliente(oidCliente);
	        this.setOidNivelRiesgo(oidNivelRiesgo);
	        this.setOidGrupoSolicitud(oidGrupoSolicitud);
	        this.setOidZona(oidZona);
	
	}

	@Id
	@Column(name="OID_SOLI_ENTR_BLOQ")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="SBAC_OID_SBAC")
	private Long oidSubacceso;
	@Column(name="TSOL_OID_TIPO_SOLI")
	private Long oidTipoSolicitud;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long oidSolcitudCabecera;
	@Column(name="FEC_DOCU")
        //@Temporal(TemporalType.DATE)
	private java.sql.Date fechaDocumento;        
	@Column(name="IND_NOTI")
	private Boolean indicadorNotificado;
	@Column(name="VAL_MONT_ORDE")
	private Double montoOrden;
	@Column(name="VAL_MONT_DEUD_VENC")
	private Double montoDeudaVencida;
	@Column(name="IND_VALI_1")
	private Boolean indicadorValidacion1;
	@Column(name="IND_VALI_2")
	private Boolean indicadorValidacion2;
	@Column(name="IND_VALI_3")
	private Boolean indicadorValidacion3;
	@Column(name="IND_VALI_4")
	private Boolean indicadorValidacion4;
	@Column(name="FEC_HORA_LIBE")
	private java.sql.Timestamp fechaHoraLiberacion;        
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="JERA_OID_JERA")
	private Long oidJerarquia;
	@Column(name="ESPE_OID_ESTA_PEDI")
	private Long oidEstatusPedido;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Column(name="ZZON_OID_ZONA")
	private Long oidZona;
	@Column(name="COAP_OID_CODI_APRO")
	private Long oidCodigoAprobacion;
	@Column(name="EJCU_OID_EJEC_CUEN")
	private Long oidEjecutivoCuenta;
	@Column(name="EJCU_OID_USUA_LIBE")
	private Long oidUsuarioLiberacion;
	@Column(name="NIRI_OID_NIVE_RIES")
	private Long oidNivelRiesgo;
	@Column(name="GRSO_OID_GRUP_SOLI")
	private Long oidGrupoSolicitud;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidSubacceso() {return oidSubacceso;}
      
	public void setOidSubacceso(Long oidSubacceso){this.oidSubacceso=oidSubacceso;}
		
	public Long getOidTipoSolicitud() {return oidTipoSolicitud;}
      
	public void setOidTipoSolicitud(Long oidTipoSolicitud){this.oidTipoSolicitud=oidTipoSolicitud;}
		
	public Long getOidSolcitudCabecera() {return oidSolcitudCabecera;}
      
	public void setOidSolcitudCabecera(Long oidSolcitudCabecera){this.oidSolcitudCabecera=oidSolcitudCabecera;}
		
	public java.sql.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public Boolean getIndicadorNotificado() {return indicadorNotificado;}
      
	public void setIndicadorNotificado(Boolean indicadorNotificado){this.indicadorNotificado=indicadorNotificado;}
		
	public Double getMontoOrden() {return montoOrden;}
      
	public void setMontoOrden(Double montoOrden){this.montoOrden=montoOrden;}
		
	public Double getMontoDeudaVencida() {return montoDeudaVencida;}
      
	public void setMontoDeudaVencida(Double montoDeudaVencida){this.montoDeudaVencida=montoDeudaVencida;}
		
	public Boolean getIndicadorValidacion1() {return indicadorValidacion1;}
      
	public void setIndicadorValidacion1(Boolean indicadorValidacion1){this.indicadorValidacion1=indicadorValidacion1;}
		
	public Boolean getIndicadorValidacion2() {return indicadorValidacion2;}
      
	public void setIndicadorValidacion2(Boolean indicadorValidacion2){this.indicadorValidacion2=indicadorValidacion2;}
		
	public Boolean getIndicadorValidacion3() {return indicadorValidacion3;}
      
	public void setIndicadorValidacion3(Boolean indicadorValidacion3){this.indicadorValidacion3=indicadorValidacion3;}
		
	public Boolean getIndicadorValidacion4() {return indicadorValidacion4;}
      
	public void setIndicadorValidacion4(Boolean indicadorValidacion4){this.indicadorValidacion4=indicadorValidacion4;}
		
	public java.sql.Timestamp getFechaHoraLiberacion() {return fechaHoraLiberacion;}
      
	public void setFechaHoraLiberacion(java.sql.Timestamp fechaHoraLiberacion){this.fechaHoraLiberacion=fechaHoraLiberacion;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getOidJerarquia() {return oidJerarquia;}
      
	public void setOidJerarquia(Long oidJerarquia){this.oidJerarquia=oidJerarquia;}
		
	public Long getOidEstatusPedido() {return oidEstatusPedido;}
      
	public void setOidEstatusPedido(Long oidEstatusPedido){this.oidEstatusPedido=oidEstatusPedido;}
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Long getOidZona() {return oidZona;}
      
	public void setOidZona(Long oidZona){this.oidZona=oidZona;}
		
	public Long getOidCodigoAprobacion() {return oidCodigoAprobacion;}
      
	public void setOidCodigoAprobacion(Long oidCodigoAprobacion){this.oidCodigoAprobacion=oidCodigoAprobacion;}
		
	public Long getOidEjecutivoCuenta() {return oidEjecutivoCuenta;}
      
	public void setOidEjecutivoCuenta(Long oidEjecutivoCuenta){this.oidEjecutivoCuenta=oidEjecutivoCuenta;}
		
	public Long getOidUsuarioLiberacion() {return oidUsuarioLiberacion;}
      
	public void setOidUsuarioLiberacion(Long oidUsuarioLiberacion){this.oidUsuarioLiberacion=oidUsuarioLiberacion;}
		
	public Long getOidNivelRiesgo() {return oidNivelRiesgo;}
      
	public void setOidNivelRiesgo(Long oidNivelRiesgo){this.oidNivelRiesgo=oidNivelRiesgo;}
		
	public Long getOidGrupoSolicitud() {return oidGrupoSolicitud;}
      
	public void setOidGrupoSolicitud(Long oidGrupoSolicitud){this.oidGrupoSolicitud=oidGrupoSolicitud;}
			
	
}
