package es.indra.sicc.entidades.ccc;

import es.indra.sicc.logicanegocio.ccc.CCCConstantes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

@Entity
@Table(name="CCC_CABEC_CARGA_ABONO_DIREC")
@NamedQueries({
@NamedQuery(name="CabeceraCargosAbonosDirectosLocal.FindByUK",query="SELECT OBJECT(a) FROM CabeceraCargosAbonosDirectosLocal AS a WHERE a.numero=?1 AND a.anio=?2 AND a.periodoMes=?3"),
@NamedQuery(name="CabeceraCargosAbonosDirectosLocal.FindByPaisEmpresaLoteFacturacion",query="SELECT OBJECT(a) FROM CabeceraCargosAbonosDirectosLocal AS a WHERE a. pais=?1 AND a.empresa=?2 AND a.numeroLoteFacturacion=?3")
})
public class CabeceraCargosAbonosDirectosLocal implements Serializable {

	public CabeceraCargosAbonosDirectosLocal() {}

	public CabeceraCargosAbonosDirectosLocal(Long oid, Integer numero, String anio, 
                        String periodoMes, Date fechaDocumento, Long pais_oid_pais,
                        Long empresa, String codigoUsuario, Date fechaValor, Long proceso)	{
	
		this.oid=oid;
                this.numero=numero;
                this.anio=anio;
                this.periodoMes=periodoMes;
                this.fechaDocumento=fechaDocumento;
                this.pais=pais_oid_pais;
                this.empresa=empresa;
                this.codigoUsuario=codigoUsuario;
                this.fechaValor=fechaValor;
                this.proceso=proceso;                
	
	}
    
    public Boolean esDepuracionModificable() {
            /*Si fechaContabilizacion==null 
             * y situacion == CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO return 
             *      true 
             * else return false */
             if ((this.fechaContabilizacion==null) && (this.situacion.longValue()==new Long(CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO).longValue())) {
                    //CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO
                     return Boolean.TRUE;
             } else {
                     return Boolean.FALSE;
             }
            
    }    

    public CabeceraCargosAbonosDirectosLocal(Long oid, Integer numero, String anio,
                    String periodoMes, Date fechaDocumento, Date fechaValor, String referenciaExterna, 
                    String numeroLoteContabilizacion, Date fechaContabilizacion, 
                    String observaciones, Long subacceso, Long pais, Long empresa, 
                    Long cliente, String codigoUsuario, Long tipoAbonoSubproceso, Long situacion,
                    String codigoClienteDesde, String codigoClienteHasta, String periodoDesde, 
                    String periodoHasta, Date fechaDocumentoDesde, Date fechaDocumentoHasta,
                    Date fechaVencimientoDesde, Date fechaVencimientoHasta, Long cuentacorriente, Long proceso) {
    
            this.oid=oid;
            this.numero=numero;
            this.anio=anio;
            this.periodoMes=periodoMes;
            this.fechaDocumento=fechaDocumento;
            this.fechaValor=fechaValor;
            this.referenciaExterna=referenciaExterna;
            this.numeroLoteContabilizacion=numeroLoteContabilizacion;
            this.fechaContabilizacion=fechaContabilizacion;
            this.observaciones=observaciones;                
            this.subacceso=subacceso;
            this.pais=pais;
            this.empresa=empresa; 
            this.cliente=cliente;
            this.codigoUsuario=codigoUsuario;
            this.tipoAbonoSubproceso=tipoAbonoSubproceso;
            this.situacion=situacion;
            this.codigoClienteDesde=codigoClienteDesde;
            this.codigoClienteHasta=codigoClienteHasta;
            this.periodoDesde=periodoDesde;
            this.periodoHasta=periodoHasta;
            this.fechaDocumentoDesde=fechaDocumentoDesde;
            this.fechaDocumentoHasta=fechaDocumentoHasta;
            this.fechaVencimientoHasta=fechaVencimientoHasta;
            this.fechaVencimientoDesde=fechaVencimientoDesde;
            this.cuentacorriente=cuentacorriente;
            this.proceso=proceso;            
    
    }
    
    
	@Id
	@Column(name="OID_CABE_CARG")
	private Long oid;
	@Column(name="ANIO")
	private String anio;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;
	@Column(name="FEC_CONT")        
	private java.sql.Date fechaContabilizacion;
	@Column(name="FEC_DOCU")        
	private java.sql.Date fechaDocumento;
	@Column(name="FEC_VALO")        
	private java.sql.Date fechaValor;
	@Column(name="NUM_CABE")
	private Integer numero;
	@Column(name="VAL_NUME_LOTE_CONT")
	private String numeroLoteContabilizacion;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="VAL_PERI_MES")
	private String periodoMes;
	@Column(name="VAL_REFE_EXTE")
	private String referenciaExterna;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="COD_USUA")
	private String codigoUsuario;
	@Column(name="TASP_OID_TIPO_ABON_SUBP")
	private Long tipoAbonoSubproceso;
	@Column(name="COD_CLIE_HAST")
	private String codigoClienteHasta;
	@Column(name="COD_CLIE_DESD")
	private String codigoClienteDesde;
	@Column(name="COD_PERI_DESD")
	private String periodoDesde;
	@Column(name="COD_PERI_HAST")
	private String periodoHasta;
	@Column(name="SIIN_OID_SITU_INCO")
	private Long situacion;
	@Column(name="FEC_DOCU_DESD")        
	private java.sql.Date fechaDocumentoDesde;
	@Column(name="FEC_DOCU_HAST")        
	private java.sql.Date fechaDocumentoHasta;
	@Column(name="FEC_VENC_DESD")        
	private java.sql.Date fechaVencimientoDesde;
	@Column(name="FEC_VENC_HAST")        
	private java.sql.Date fechaVencimientoHasta;
	@Column(name="CCBA_OID_CUEN_CORR_BANC")
	private Long cuentacorriente;
	@Column(name="CCPR_OID_PROC")
	private Long proceso;
	@Column(name="VAL_NUME_LOTE_FACT")
	private String numeroLoteFacturacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getAnio() {return anio;}
      
	public void setAnio(String anio){this.anio=anio;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
		
	public java.sql.Date getFechaContabilizacion() {return fechaContabilizacion;}
      
	public void setFechaContabilizacion(java.sql.Date fechaContabilizacion){this.fechaContabilizacion=fechaContabilizacion;}
		
	public java.sql.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public java.sql.Date getFechaValor() {return fechaValor;}
      
	public void setFechaValor(java.sql.Date fechaValor){this.fechaValor=fechaValor;}
		
	public Integer getNumero() {return numero;}
      
	public void setNumero(Integer numero){this.numero=numero;}
		
	public String getNumeroLoteContabilizacion() {return numeroLoteContabilizacion;}
      
	public void setNumeroLoteContabilizacion(String numeroLoteContabilizacion){this.numeroLoteContabilizacion=numeroLoteContabilizacion;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public String getPeriodoMes() {return periodoMes;}
      
	public void setPeriodoMes(String periodoMes){this.periodoMes=periodoMes;}
		
	public String getReferenciaExterna() {return referenciaExterna;}
      
	public void setReferenciaExterna(String referenciaExterna){this.referenciaExterna=referenciaExterna;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public String getCodigoUsuario() {return codigoUsuario;}
      
	public void setCodigoUsuario(String codigoUsuario){this.codigoUsuario=codigoUsuario;}
		
	public Long getTipoAbonoSubproceso() {return tipoAbonoSubproceso;}
      
	public void setTipoAbonoSubproceso(Long tipoAbonoSubproceso){this.tipoAbonoSubproceso=tipoAbonoSubproceso;}
		
	public String getCodigoClienteHasta() {return codigoClienteHasta;}
      
	public void setCodigoClienteHasta(String codigoClienteHasta){this.codigoClienteHasta=codigoClienteHasta;}
		
	public String getCodigoClienteDesde() {return codigoClienteDesde;}
      
	public void setCodigoClienteDesde(String codigoClienteDesde){this.codigoClienteDesde=codigoClienteDesde;}
		
	public String getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(String periodoDesde){this.periodoDesde=periodoDesde;}
		
	public String getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(String periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getSituacion() {return situacion;}
      
	public void setSituacion(Long situacion){this.situacion=situacion;}
		
	public java.sql.Date getFechaDocumentoDesde() {return fechaDocumentoDesde;}
      
	public void setFechaDocumentoDesde(java.sql.Date fechaDocumentoDesde){this.fechaDocumentoDesde=fechaDocumentoDesde;}
		
	public java.sql.Date getFechaDocumentoHasta() {return fechaDocumentoHasta;}
      
	public void setFechaDocumentoHasta(java.sql.Date fechaDocumentoHasta){this.fechaDocumentoHasta=fechaDocumentoHasta;}
		
	public java.sql.Date getFechaVencimientoDesde() {return fechaVencimientoDesde;}
      
	public void setFechaVencimientoDesde(java.sql.Date fechaVencimientoDesde){this.fechaVencimientoDesde=fechaVencimientoDesde;}
		
	public java.sql.Date getFechaVencimientoHasta() {return fechaVencimientoHasta;}
      
	public void setFechaVencimientoHasta(java.sql.Date fechaVencimientoHasta){this.fechaVencimientoHasta=fechaVencimientoHasta;}
		
	public Long getCuentacorriente() {return cuentacorriente;}
      
	public void setCuentacorriente(Long cuentacorriente){this.cuentacorriente=cuentacorriente;}
		
	public Long getProceso() {return proceso;}
      
	public void setProceso(Long proceso){this.proceso=proceso;}
		
	public String getNumeroLoteFacturacion() {return numeroLoteFacturacion;}
      
	public void setNumeroLoteFacturacion(String numeroLoteFacturacion){this.numeroLoteFacturacion=numeroLoteFacturacion;}
			
	
}
