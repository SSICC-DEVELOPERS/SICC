package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="CCC_RECEP_RECLA")
public class RecepcionReclamosLocal implements Serializable {

	public RecepcionReclamosLocal() {}

	public RecepcionReclamosLocal(Long oid, Integer numero, String anio, String periodoMes, 
                                Long consultoraReclamante, String usuaSolicitante, Long empresa, 
                                Long periodoReclamante, Timestamp fechaDocumento,Double importeReclamado,
                                Long situacReclam, Long canal, Date fechaValor, Long pais) {
	
		this.oid=oid;
                this.numero=numero;
                this.anyo=anio;
                this.periodoMes=periodoMes;
                this.consultoraReclamante=consultoraReclamante;
                this.usuarioSolicitante=usuaSolicitante;
                this.empresa=empresa;
                this.periodoReclamante=periodoReclamante;
                this.fechaDocumento=fechaDocumento;
                this.importeReclamado=importeReclamado;
                this.situacion=situacReclam;
                this.canal=canal;
                this.fechaValor=fechaValor;
                this.pais=pais;                
	
	}

        public RecepcionReclamosLocal(Long oid, Integer numero, String anio, String periodoMes, Long consultoraReclamante,
                                 Long cargoAbono, String usuaSolicitante, String observClienteReclam, 
                                 String observAreaReclamo, Date fecResolPrevista, Timestamp fecResolReal,
                                 String fichDocumAdjunto, String usuGestorPrev, String usuGestorReal, 
                                 String observacionesResolucion, Long subacceso, Long empresa, Long cuenta, 
                                 Long movimientoCC, Long medioPago, Long motivosRechazo, Long periodoReclamante,
                                 Timestamp fechaDocumento, Double importeReclamado, Long situacReclam, Long canal,
                                 Long acceso, Date fechaValor, Long pais, Long sucursal) {
        
                this.oid=oid;
                this.numero=numero;
                this.anyo=anio;
                this.periodoMes=periodoMes;
                this.consultoraReclamante=consultoraReclamante;
                this.usuarioSolicitante=usuaSolicitante;
                this.empresa=empresa;
                this.periodoReclamante=periodoReclamante;
                this.fechaDocumento=fechaDocumento;
                this.importeReclamado=importeReclamado;
                this.situacion=situacReclam;
                this.canal=canal;
                this.fechaValor=fechaValor;
                this.pais=pais;                
                this.cargoAbono=cargoAbono;
                this.observacionesClienteReclamante=observClienteReclam;
                this.observacionesAreaReclamos=observAreaReclamo;       
                this.fechaResolucionPrevista=fecResolPrevista;          
                this.fechaResolucionReal=fecResolReal;                  
                this.ficheroDocumentalAdjunto=fichDocumAdjunto;         
                this.usuarioGestorPrevisto=usuGestorPrev;               
                this.usuarioGestorReal=usuGestorReal;                   
                this.observacionesResolucion=observacionesResolucion; //BELC300003272                       
                this.subacceso=subacceso;                
                this.cuenta=cuenta;
                this.movimientoCC=movimientoCC;
                this.medioPago=medioPago;
                this.motivosRechazoDesbloqueo=motivosRechazo;                
                this.acceso=acceso;                
                this.sucursal=sucursal;                
        
        }

	@Id
	@Column(name="OID_RECE_RECL")
	private Long oid;
	@Column(name="NUM_RECE")
	private Integer numero;
	@Column(name="VAL_ANIO")
	private String anyo;
	@Column(name="VAL_PERI_MES")
	private String periodoMes;
	@Column(name="CLIE_OID_CONS_RECL")
	private Long consultoraReclamante;
	@Column(name="CCAD_OID_CABE_CARG")
	private Long cargoAbono;
	@Column(name="VAL_USUA_SOLI")
	private String usuarioSolicitante;
	@Column(name="VAL_OBSE_CLIE_RECL")
	private String observacionesClienteReclamante;
	@Column(name="VAL_OBSE_AREA_RECL")
	private String observacionesAreaReclamos;
	@Column(name="FEC_RESO_PREV")        
	private java.sql.Date fechaResolucionPrevista;
	@Column(name="FEC_RESO_REAL")
	private java.sql.Timestamp fechaResolucionReal;
	@Column(name="VAL_FICH_DOCU_ADJU")
	private String ficheroDocumentalAdjunto;
	@Column(name="VAL_USUA_GEST_PREV")
	private String usuarioGestorPrevisto;
	@Column(name="VAL_USUA_GEST_REAL")
	private String usuarioGestorReal;
	@Column(name="VAL_OBSE_RECL")
	private String observacionesResolucion;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;
	@Column(name="CCBA_OID_CC_BANC_RECA")
	private Long cuenta;
	@Column(name="MPAB_OID_MEDI_PAGO")
	private Long medioPago;
	@Column(name="MOID_MOTI_RECH_DESB")
	private Long motivosRechazoDesbloqueo;
	@Column(name="PERI_OID_PERI_RECL")
	private Long periodoReclamante;
	@Column(name="FEC_DOCU")
	private java.sql.Timestamp fechaDocumento;
	@Column(name="IMP_RECL")
	private Double importeReclamado;
	@Column(name="SIRE_OID_SITU_RECL")
	private Long situacion;
	@Column(name="CANA_OID_CANA")
	private Long canal;
	@Column(name="ACCE_OID_ACCE")
	private Long acceso;
	@Column(name="FEC_VALO")        
	private java.sql.Date fechaValor;
	@Column(name="MVCC_OID_MOVI_CC")
	private Long movimientoCC;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="SUCU_OID_SUCU")
	private Long sucursal;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumero() {return numero;}
      
	public void setNumero(Integer numero){this.numero=numero;}
		
	public String getAnyo() {return anyo;}
      
	public void setAnyo(String anyo){this.anyo=anyo;}
		
	public String getPeriodoMes() {return periodoMes;}
      
	public void setPeriodoMes(String periodoMes){this.periodoMes=periodoMes;}
		
	public Long getConsultoraReclamante() {return consultoraReclamante;}
      
	public void setConsultoraReclamante(Long consultoraReclamante){this.consultoraReclamante=consultoraReclamante;}
		
	public Long getCargoAbono() {return cargoAbono;}
      
	public void setCargoAbono(Long cargoAbono){this.cargoAbono=cargoAbono;}
		
	public String getUsuarioSolicitante() {return usuarioSolicitante;}
      
	public void setUsuarioSolicitante(String usuarioSolicitante){this.usuarioSolicitante=usuarioSolicitante;}
		
	public String getObservacionesClienteReclamante() {return observacionesClienteReclamante;}
      
	public void setObservacionesClienteReclamante(String observacionesClienteReclamante){this.observacionesClienteReclamante=observacionesClienteReclamante;}
		
	public String getObservacionesAreaReclamos() {return observacionesAreaReclamos;}
      
	public void setObservacionesAreaReclamos(String observacionesAreaReclamos){this.observacionesAreaReclamos=observacionesAreaReclamos;}
		
	public java.sql.Date getFechaResolucionPrevista() {return fechaResolucionPrevista;}
      
	public void setFechaResolucionPrevista(java.sql.Date fechaResolucionPrevista){this.fechaResolucionPrevista=fechaResolucionPrevista;}
		
	public java.sql.Timestamp getFechaResolucionReal() {return fechaResolucionReal;}
      
	public void setFechaResolucionReal(java.sql.Timestamp fechaResolucionReal){this.fechaResolucionReal=fechaResolucionReal;}
		
	public String getFicheroDocumentalAdjunto() {return ficheroDocumentalAdjunto;}
      
	public void setFicheroDocumentalAdjunto(String ficheroDocumentalAdjunto){this.ficheroDocumentalAdjunto=ficheroDocumentalAdjunto;}
		
	public String getUsuarioGestorPrevisto() {return usuarioGestorPrevisto;}
      
	public void setUsuarioGestorPrevisto(String usuarioGestorPrevisto){this.usuarioGestorPrevisto=usuarioGestorPrevisto;}
		
	public String getUsuarioGestorReal() {return usuarioGestorReal;}
      
	public void setUsuarioGestorReal(String usuarioGestorReal){this.usuarioGestorReal=usuarioGestorReal;}
		
	public String getObservacionesResolucion() {return observacionesResolucion;}
      
	public void setObservacionesResolucion(String observacionesResolucion){this.observacionesResolucion=observacionesResolucion;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
		
	public Long getCuenta() {return cuenta;}
      
	public void setCuenta(Long cuenta){this.cuenta=cuenta;}
		
	public Long getMedioPago() {return medioPago;}
      
	public void setMedioPago(Long medioPago){this.medioPago=medioPago;}
		
	public Long getMotivosRechazoDesbloqueo() {return motivosRechazoDesbloqueo;}
      
	public void setMotivosRechazoDesbloqueo(Long motivosRechazoDesbloqueo){this.motivosRechazoDesbloqueo=motivosRechazoDesbloqueo;}
		
	public Long getPeriodoReclamante() {return periodoReclamante;}
      
	public void setPeriodoReclamante(Long periodoReclamante){this.periodoReclamante=periodoReclamante;}
		
	public java.sql.Timestamp getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Timestamp fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public Double getImporteReclamado() {return importeReclamado;}
      
	public void setImporteReclamado(Double importeReclamado){this.importeReclamado=importeReclamado;}
		
	public Long getSituacion() {return situacion;}
      
	public void setSituacion(Long situacion){this.situacion=situacion;}
		
	public Long getCanal() {return canal;}
      
	public void setCanal(Long canal){this.canal=canal;}
		
	public Long getAcceso() {return acceso;}
      
	public void setAcceso(Long acceso){this.acceso=acceso;}
		
	public java.sql.Date getFechaValor() {return fechaValor;}
      
	public void setFechaValor(java.sql.Date fechaValor){this.fechaValor=fechaValor;}
		
	public Long getMovimientoCC() {return movimientoCC;}
      
	public void setMovimientoCC(Long movimientoCC){this.movimientoCC=movimientoCC;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getSucursal() {return sucursal;}
      
	public void setSucursal(Long sucursal){this.sucursal=sucursal;}
			
	
}
