package es.indra.sicc.logicanegocio.fac;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOFACImpuestosUbigeo;
import es.indra.sicc.dtos.fac.DTOFACSecuenciaProcesos;
import es.indra.sicc.dtos.fac.DTOFACValoresDefecto;
import es.indra.sicc.dtos.fac.DTOImpuestosGenerales;
import es.indra.sicc.dtos.fac.DTOIndicadoresImpuestos;
import es.indra.sicc.dtos.fac.DTOTiposSolicitudPais;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class ProcesoFacturacionHelper 
{
    private HashMap listaTiposSolicitud = null;
    private HashMap hashImpuestosGenerales = null;
    private HashMap hashValoresDefecto = null;
    private HashMap hashEstadosSolicitud = null;
    private HashMap hashImpuestosUbigeo = null;
    private HashMap hashImpuestosNegocio = null;
    private HashMap hashIndicadoresImpuestos = null;
    private HashMap hashTiposSolicitud = null;
    private ArrayList secuenciaProcesos = null;
    private Long pais = null;
    //  Agregado por HRCS - Fecha 29/05/2007 - Cambio Sicc20070188
    private HashMap hashIndicadoresImpuestosPorCodigo = null;
    private HashMap hashTiposSoliPaisCCC = null;

    //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
    private HashMap hashTipoMovimientoAlmacen = null;
    private HashMap hashFPagoDetal = null;    
    private HashMap hashAsigSubProcTipoSolicAplic = null;  
    private HashMap hashAsigSubProcTipoSolicCreac = null;  
    private Long idioma = null;
    
    //sapaza -- PER-SiCC-2011-0441 -- 23/06/2011
    private HashMap hashPeriodosPosteriores = null;    
    
    private static ProcesoFacturacionHelper procesoFacturacionHelper = null;
    
    private ProcesoFacturacionHelper(Long pais, Long idioma){
        this.pais = pais;
        this.idioma = idioma;
    }
    
    private ProcesoFacturacionHelper(){
    }
   
    public static ProcesoFacturacionHelper getInstance(Long pais, Long idioma) {
        if (procesoFacturacionHelper == null){
            procesoFacturacionHelper = new ProcesoFacturacionHelper(pais, idioma);
        }
        return procesoFacturacionHelper;
    }
    
    public static ProcesoFacturacionHelper getInstance(Long pais) {
        if (procesoFacturacionHelper == null){
            procesoFacturacionHelper = new ProcesoFacturacionHelper(pais, getIdiomaDefecto());
        }
        return procesoFacturacionHelper;
    }
    
    public static ProcesoFacturacionHelper getInstance() {
        if (procesoFacturacionHelper == null){
            procesoFacturacionHelper = new ProcesoFacturacionHelper();
        }
        return procesoFacturacionHelper;
    }
    
    public void finalizarHelper(){
        listaTiposSolicitud = null;
        hashImpuestosGenerales = null;
        hashValoresDefecto = null;
        hashEstadosSolicitud = null;
        hashTiposSolicitud = null;
        hashIndicadoresImpuestos = null;
        hashImpuestosUbigeo = null;
        hashImpuestosNegocio = null;
        secuenciaProcesos = null;
        procesoFacturacionHelper = null;
        
        //sapaza -- PER-SiCC-2011-0441 -- 23/06/2011
        hashPeriodosPosteriores = null;
    }
    
    public HashMap getImpuestosGenerales () throws MareException{
        if (hashImpuestosGenerales == null){
            hashImpuestosGenerales = this.cargarImpuestosGenerales(this.pais);
        }
        return hashImpuestosGenerales;
    }
    
    public HashMap getValoresDefecto() throws MareException{
        if (hashValoresDefecto == null){
            hashValoresDefecto = this.cargaValoresDefecto();
        }
        return hashValoresDefecto;
    }
    
    public HashMap getEstadosSolicitud() throws MareException{
        if (hashEstadosSolicitud == null){
            hashEstadosSolicitud = this.cargarEstadosSolicitud();
        }
        return hashEstadosSolicitud;
    }
    
    public HashMap getImpuestoUbigeo() throws MareException{
        if (hashImpuestosUbigeo == null){
            hashImpuestosUbigeo = this.cargarImpuestosUbigeo();
        }
        return hashImpuestosUbigeo;
    }
    
    public HashMap getIndicadoresImpuestos() throws MareException{
        if (hashIndicadoresImpuestos == null){
            hashIndicadoresImpuestos = this.cargaIndicadoresImpuestos(this.pais);
        }
        return hashIndicadoresImpuestos;
    }
    
    public HashMap getIndicadoresImpuestosPorCodigo() throws MareException{
        if (hashIndicadoresImpuestosPorCodigo == null){
            hashIndicadoresImpuestosPorCodigo = this.cargaIndicadoresImpuestosPorCodigo(this.pais);
        }
        return hashIndicadoresImpuestosPorCodigo;
    }
    
    public HashMap getImpuestoNegocio() throws MareException{
        if (hashImpuestosNegocio == null){
            hashImpuestosNegocio = this.cargarImpuestosNegocio(this.pais);
        }
        return hashImpuestosNegocio;
    }
    
    public HashMap getTipoSolicitud() throws MareException{
        if (hashTiposSolicitud == null){
            hashTiposSolicitud = this.obtenerTipoSolicitudPais(this.pais);
        }
        return hashTiposSolicitud;
    }
    
    public ArrayList getSecuenciaProcesos() throws MareException{
        if (secuenciaProcesos == null){
            secuenciaProcesos = this.cargarSecuenciaProcesos(ConstantesPED.GP5, null, null);
        }
        return secuenciaProcesos;
    }

    public HashMap getTiposSoliPaisCCC() throws MareException {
        if (hashTiposSoliPaisCCC == null){
            hashTiposSoliPaisCCC = this.cargarTiposSoliPaisCCC();
        }
        return hashTiposSoliPaisCCC;
    }
    
    private HashMap cargarImpuestosGenerales(Long oidPais) throws MareException {
		
		StringBuffer sql = new StringBuffer("");
        HashMap hashImpuestosGenerales = new HashMap();  
    
		sql.append(" SELECT IG.SBAC_OID_SBAC AS SUBACCESO, ");
		sql.append("	 IG.TAIM_OID_TASA_IMPU AS INDICADORIMPUESTO, ");
        sql.append("   IG.TAIM_OID_TASA_IMPU_FLET AS INDICADORIMPUESTOFLETE, ");
		sql.append("   IG.IND_TASA_UNIC AS INDICADORTASAUNICA ");
		sql.append(" FROM PED_IMPUE_GENER IG ");
		sql.append(" WHERE IG.PAIS_OID_PAIS = " + oidPais);


		BelcorpService bs = null;
		bs = BelcorpService.getInstance();

		RecordSet rs = null;

		try{
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch(Exception e) {
			UtilidadesLog.error("DAOFACPrecargas:cargarImpuestosGenerales:Exception",e);			
			throw new MareException(e, UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		
		
        if (!rs.esVacio()){
            for(int i = 0; i<rs.getRowCount(); i++){
                DTOImpuestosGenerales dtoImpuestosGenerales = new DTOImpuestosGenerales();		      
                dtoImpuestosGenerales.setSubacceso(this.bigDecimalToLong(rs.getValueAt(i, "SUBACCESO")));                    
                dtoImpuestosGenerales.setIndicadorImpuesto(this.bigDecimalToLong(rs.getValueAt(i,"INDICADORIMPUESTO")));
                dtoImpuestosGenerales.setIndicadorImpuestoFlete(this.bigDecimalToLong(rs.getValueAt(i,"INDICADORIMPUESTOFLETE")));
                dtoImpuestosGenerales.setIndicadorTasaUnica(this.bigDecimalToBoolean(rs.getValueAt(i, "INDICADORTASAUNICA")));
                hashImpuestosGenerales.put(this.bigDecimalToLong(rs.getValueAt(i, "SUBACCESO")) ,dtoImpuestosGenerales);
            }
        }		
		UtilidadesLog.info("MONProcesosFActuracionBean.cargarImpuestosGenerales(): Salida");
		return hashImpuestosGenerales;
	}
    
    private HashMap cargaValoresDefecto() throws MareException {
		StringBuffer sql = new StringBuffer("");
        
		sql.append("SELECT VD.TSPA_OID_TIPO_SOLI_PAIS, ");
		sql.append(" 	     VD.VAL_VALO_DEFE ");
		sql.append(" FROM PED_VALOR_DEFEC_TIPO_SOLIC VD ");
		sql.append(" WHERE VD.ATRE_OID_ATRI_ESPE = " + ConstantesFAC.OID_IND_ESTADISTICABLE.longValue());

		RecordSet rs = null;
	
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try { 
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargaValoresDefecto:Exception",e);
			throw new MareException (e, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

        HashMap hashValoresDefecto = new HashMap();
		
        if (!rs.esVacio()){
            for(int i = 0; i<rs.getRowCount(); i++){
                DTOFACValoresDefecto dtoValoresDefecto = new DTOFACValoresDefecto();
                dtoValoresDefecto.setOidTipoSolicitudPais(this.bigDecimalToLong(rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS")));
                dtoValoresDefecto.setValorPorDefecto(this.bigDecimalToString(rs.getValueAt(i, "VAL_VALO_DEFE")));
                hashValoresDefecto.put(this.bigDecimalToLong(rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS")),dtoValoresDefecto);
            }
        }
		return hashValoresDefecto;
	}


	private HashMap cargarEstadosSolicitud() throws MareException {
		StringBuffer sql = new StringBuffer("");
	
		sql.append(" SELECT OID_ESTA_SOLI as OID, COD_ESTA_SOLI as ESTADO ");
		sql.append(" FROM PED_ESTAD_SOLIC ");
		
		BelcorpService bs = null;
		bs = BelcorpService.getInstance();
		RecordSet rs = null;
		
		try{
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch(Exception e) {
			UtilidadesLog.error(" cargarEstadosSolicitud:",e);
		  throw new MareException(e, UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
        HashMap hashEstadoSolicitud = new HashMap();
        if (!rs.esVacio()){
            for(int i=0; i<rs.getRowCount(); i++){
                hashEstadoSolicitud.put(this.bigDecimalToString(rs.getValueAt(i,"ESTADO")),this.bigDecimalToLong(rs.getValueAt(i,"OID")));
            }
        }
        return hashEstadoSolicitud;
	}
  
    private HashMap cargarImpuestosUbigeo() throws MareException {
		StringBuffer sql = new StringBuffer("");

		sql.append(" SELECT  ");
		sql.append(" PROD_OID_PROD, ");
		sql.append(" TAIM_OID_TASA_IMPU,  ");
		sql.append(" SBAC_OID_SBAC ");
		sql.append(" FROM MAE_IMPUE_UBIGE  ");
		
		RecordSet rs = null;

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try { 
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargarImpuestosUbigeo:Exception",e);
			throw new MareException (e, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
        HashMap hashImpuestosUbigeo = new HashMap();
		DTOFACImpuestosUbigeo dto = null;
        if (!rs.esVacio()){
            for(int i = 0; i<rs.getRowCount(); i++){
                hashImpuestosUbigeo.put(this.bigDecimalToLong(rs.getValueAt(i,"SBAC_OID_SBAC")).toString()+this.bigDecimalToLong(rs.getValueAt(i,"PROD_OID_PROD")).toString() ,this.bigDecimalToLong(rs.getValueAt(i,"TAIM_OID_TASA_IMPU")));
            }
        }
		return hashImpuestosUbigeo;
	}

	private HashMap cargaIndicadoresImpuestos(Long oidPais) throws MareException {
		StringBuffer sql = new StringBuffer("");

		sql.append(" SELECT VAL_TASA_IMPU, ");
		sql.append(" 		OID_TASA_IMPU ");
		sql.append(" FROM PED_TASA_IMPUE ");
		sql.append(" WHERE PAIS_OID_PAIS = " + oidPais);

		BelcorpService bs = UtilidadesEJB.getBelcorpService();

		RecordSet rs = null;		

		try{
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargaIndicadoresImpuestos:Exception",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(
								CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

        HashMap hashIndicadoresImpuestos = new HashMap();	
    
        if (!rs.esVacio()){
            for(int i = 0; i<rs.getRowCount(); i++){
                hashIndicadoresImpuestos.put(this.bigDecimalToLong(rs.getValueAt(i,"OID_TASA_IMPU")),this.bigDecimalToFloat(rs.getValueAt(i,"VAL_TASA_IMPU")));
            }
        }
		return hashIndicadoresImpuestos;
	}
  
  
    private HashMap cargarImpuestosNegocio(Long oidPais ) throws MareException {
		StringBuffer sql = new StringBuffer("");

		sql.append(" SELECT NEGO_OID_NEGO, ");
		sql.append(" TAIM_OID_TASA_IMPU, ");
		sql.append(" SBAC_OID_SBAC  ");
		sql.append(" FROM PED_IMPUE_NEGOC  ");
        sql.append(" WHERE PAIS_OID_PAIS = " + oidPais);
  
		RecordSet rs = null;
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
	
		try { 
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargarImpuestosNegocio:Exception",e);
			throw new MareException (e, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		HashMap hashImpuestosNegocio = new HashMap();
    
        if (!rs.esVacio()){
            for(int i = 0; i<rs.getRowCount(); i++){
                hashImpuestosNegocio.put(this.bigDecimalToLong(rs.getValueAt(i, "SBAC_OID_SBAC")).toString()+this.bigDecimalToLong(rs.getValueAt(i, "NEGO_OID_NEGO")).toString(),this.bigDecimalToFloat(rs.getValueAt(i, "TAIM_OID_TASA_IMPU")));
            }
		}
		return hashImpuestosNegocio;		
	}
    
    private HashMap obtenerTipoSolicitudPais(Long oidPais) throws MareException {
        StringBuffer sql = new StringBuffer("");
        
        sql.append(" SELECT TSP.OID_TIPO_SOLI_PAIS, ");
        sql.append("        TS.ACCE_OID_ACCE, ");
        sql.append("        TS.SBAC_OID_SBAC, ");
        sql.append("        ACC.COD_ACCE  ");
        sql.append(" FROM PED_TIPO_SOLIC_PAIS TSP, ");
        sql.append("      PED_TIPO_SOLIC TS,			 ");
        sql.append("      SEG_ACCES ACC ");
        sql.append(" WHERE TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        sql.append(" AND ACC.OID_ACCE = TS.ACCE_OID_ACCE ");
        sql.append(" AND TSP.PAIS_OID_PAIS = " + oidPais);
        
        RecordSet rs = null;	
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try { 
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargarTiposSolicitudPais:Exception",e);			
			throw new MareException (e, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
    
        HashMap hashTipoSolicitudPais = new HashMap();
    
        if (!rs.esVacio()){
            for(int i = 0; i < rs.getRowCount(); i++){
                DTOTiposSolicitudPais dtoTiposSolicitudPais = new DTOTiposSolicitudPais();
                dtoTiposSolicitudPais.setTipoSolicitudPais(this.bigDecimalToLong(rs.getValueAt(i, "OID_TIPO_SOLI_PAIS")));  
                dtoTiposSolicitudPais.setAcceso(this.bigDecimalToLong(rs.getValueAt(i, "ACCE_OID_ACCE")));
                dtoTiposSolicitudPais.setSubacceso(this.bigDecimalToLong(rs.getValueAt(i, "SBAC_OID_SBAC")));
                dtoTiposSolicitudPais.setCodAcceso(this.bigDecimalToString(rs.getValueAt(i,"COD_ACCE")));
                hashTipoSolicitudPais.put(this.bigDecimalToLong(rs.getValueAt(i, "OID_TIPO_SOLI_PAIS")),dtoTiposSolicitudPais);
            }
        }
		return hashTipoSolicitudPais;
	}
    
    private ArrayList cargarSecuenciaProcesos( Long grupoProcesos ,String proceso, Long tipoSolicitud) throws MareException{
        StringBuffer sql = new StringBuffer("");
        Vector parametros = new Vector();
        
		sql.append(" SELECT SP.COD_SECU secuencia, SP.TSPA_OID_TIPO_SOLI_PAIS as tipoSolicitud, ");
		sql.append(" SP.GRPR_OID_GRUP_PROC as oidGrupoProcesos, GP.COD_GRUP_PROC as grupoProcesos, ");
		sql.append(" SP.PROC_OID_PROC as oidProceso, P.COD_PROC as codigoProceso, ");
		sql.append(" SP.IND_EJEC_ONLI as indicadorEjecucionEnLinea, ");
		sql.append(" PR.VAL_CLAS_EJEC as businessID "); 
		sql.append(" FROM PED_SECUE_PROCE SP, PED_GRUPO_PROCE GP, PED_PROCE P, PED_PROGR PR ");
		
        sql.append(" WHERE SP.PROC_OID_PROC = P.OID_PROC ");
        sql.append(" AND PR.OID_PROG = P.PROG_OID_PROG ");
        sql.append(" AND GP.OID_GRUP_PROC = SP.GRPR_OID_GRUP_PROC ");
        if(grupoProcesos != null){
            sql.append(" AND  SP.GRPR_OID_GRUP_PROC = ? ");
            parametros.add(grupoProcesos);
        }
        if(proceso != null){
            sql.append(" AND P.COD_PROC > ? ");
            parametros.add(proceso);
        }
        if(tipoSolicitud != null){
            sql.append(" AND SP.TSPA_OID_TIPO_SOLI_PAIS = ? ");
            parametros.add(tipoSolicitud);
		}
		  
        //Con el RecordSet obtenido se crea una lista de objetos DTOFACSecuenciaProcesos, y se retorna.
        BelcorpService bs = null;
		bs = BelcorpService.getInstance();

		RecordSet rs = null;

		// Obtenemos todos los registros
		try{
			rs = bs.dbService.executePreparedQuery(sql.toString(),parametros);
		} catch(Exception e) {
			UtilidadesLog.error(" cargarSecuenciaProcesos:",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		int tamanyo = rs.getRowCount();
		ArrayList salida = new ArrayList(tamanyo);
		for(int i=0; i<tamanyo; i++){
			DTOFACSecuenciaProcesos dto = new DTOFACSecuenciaProcesos();
			dto.setSecuencia(new Integer(((BigDecimal)rs.getValueAt(i,0)).intValue()));//"secuencia"
			dto.setTipoSolicitud(new Long(((BigDecimal)rs.getValueAt(i,1)).longValue()));//"tipoSolicitud"
			dto.setOidGrupoProcesos(new Long(((BigDecimal)rs.getValueAt(i,2)).longValue()));	//"oidGrupoProcesos"		
			dto.setGrupoProcesos(rs.getValueAt(i,3).toString());//"grupoProcesos"
			dto.setOidProceso(new Long(((BigDecimal)rs.getValueAt(i,4)).longValue()));//"oidProceso"			
			dto.setCodigoProceso(rs.getValueAt(i,5).toString());//"codigoProceso"

			if(((BigDecimal)rs.getValueAt(i,6)).intValue() == 1){//"indicadorEjecucionEnLinea"
				dto.setIndicadorEjecucionEnLinea(Boolean.TRUE);
			} else{
				dto.setIndicadorEjecucionEnLinea(Boolean.FALSE);
			}

			if (rs.getValueAt(i,7)!=null){//"businessID"
				dto.setBusinessID(rs.getValueAt(i,7).toString());//"businessID"
			}
			salida.add(dto);
		}
			
		return salida;
    }
    
    private Boolean bigDecimalToBoolean(Object indicador) {    
        if (indicador != null) {
            if (((BigDecimal) indicador).intValue() == 1)  { 
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;           
            }           
        } else {
            return Boolean.FALSE;
        }
    }
    
    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
   }
   
   private String bigDecimalToString(Object ob) {
        if (ob != null) {
            return ob.toString();
        } else {
            return null;
        }
    } 
    
    private Float bigDecimalToFloat(Object numero) {
        if (numero != null) {
            return new Float(((BigDecimal) numero).floatValue());
        } else {
            return null;
        }
   }
       
    /**
     * Obtiene los indicadores de impuestos  de PED_TASA_IMPUE
     * Creado por HRCS - Fecha 28/05/2007 - Cambio Sicc20070188
     * @throws es.indra.mare.common.exception.MareException
     * @return HashMap con los indicadores de impuesto
     * @param oidPais
     */
	private HashMap cargaIndicadoresImpuestosPorCodigo(Long oidPais) throws MareException {
		StringBuffer sql = new StringBuffer("");

		sql.append(" SELECT VAL_INDI_IMPU, ");
        sql.append("        VAL_TASA_IMPU, ");
		sql.append(" 		OID_TASA_IMPU ");
		sql.append(" FROM PED_TASA_IMPUE ");
		sql.append(" WHERE PAIS_OID_PAIS = " + oidPais);

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		try{
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargaIndicadoresImpuestosPorCodigo:Exception",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(
								CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
        
        HashMap hashIndicadoresImpuestos = new HashMap();
        if (!rs.esVacio()){
            for(int i = 0; i<rs.getRowCount(); i++) {
                DTOIndicadoresImpuestos dto = new DTOIndicadoresImpuestos();
                dto.setIndicadorImpuestos( rs.getValueAt(i,"VAL_INDI_IMPU").toString() );
                dto.setOidTasaImpuesto( this.bigDecimalToLong(rs.getValueAt(i,"OID_TASA_IMPU")) );
                dto.setTasaImpuesto( this.bigDecimalToFloat(rs.getValueAt(i,"VAL_TASA_IMPU")) );
                hashIndicadoresImpuestos.put( rs.getValueAt(i,"VAL_INDI_IMPU").toString(), dto);
            }
        }
		return hashIndicadoresImpuestos;
	}
    
   /**
    * Recupera los tipos de solicitud pais que existen en la tabla CCC_ASIGN_SUBTR_TIPO_SOLIC
    * Creado por HRCS - Fecha 29/05/2007 - Cambio Sicc20070188
    * @return HashMap con los tipos de solicitud pais de CCC_ASIGN_SUBTR_TIPO_SOLIC
    * @throws MareException Excepcion generica de MARE
    */
   private HashMap cargarTiposSoliPaisCCC() throws MareException {
		
		StringBuffer sql = new StringBuffer("");
		sql.append(" select tspa_oid_tipo_soli_pais ");
        sql.append(" from ccc_asign_subpr_tipo_solic ");
        
		BelcorpService bs = BelcorpService.getInstance();
		RecordSet rs = null;
		try{
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch(Exception e) {
			UtilidadesLog.error("cargarTiposSoliPaisCCC:Exception",e);			
			throw new MareException(e, UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
		//  Validamos si existe en la tabla CCC_ASIGN_SUBTR_TIPO_SOLIC
        HashMap hashTipos = new HashMap();
        if (!rs.esVacio()){
            for(int i = 0; i<rs.getRowCount(); i++) {
                hashTipos.put( this.bigDecimalToLong(rs.getValueAt(i,"TSPA_OID_TIPO_SOLI_PAIS")), this.bigDecimalToLong(rs.getValueAt(i,"TSPA_OID_TIPO_SOLI_PAIS")));
            }
        }
		return hashTipos;
	}    
 
    //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
    public HashMap getTipoMovimientoAlmacen() throws MareException{
        if (hashTipoMovimientoAlmacen == null){
             hashTipoMovimientoAlmacen = this.obtenerTipoMovimientoAlmacen(this.pais, this.idioma);
         }
         return hashTipoMovimientoAlmacen;
    }
       
    //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
    private HashMap obtenerTipoMovimientoAlmacen(Long oidPais, Long oidIdioma) throws MareException {
        StringBuffer sql = new StringBuffer("");
        
        sql.append(" SELECT TMA.OID_TIPO_MOVI_ALMA, ");
        sql.append("        TMA.PAIS_OID_PAIS, ");
        sql.append("        TMA.COD_TIPO_MOVI, ");
        sql.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + oidIdioma + ",TMA.OID_TIPO_MOVI_ALMA,'BEL_TIPO_MOVIM_ALMAC') DES_TIPO_MOVI, ");
        sql.append("        TMA.COD_MOVI_SAP, ");
        sql.append("        TMA.COD_OPER_1, ");
        sql.append("        TMA.COD_OPER_2, ");
        sql.append("        TMA.IND_MOVI_ENTR_ALMA, ");
        sql.append("        TMA.IND_MANT_MOVI, ");
        sql.append("        TMA.IND_SAP, ");
        sql.append("        TMA.ESME_OID_ESTA_MERC_1, ");
        sql.append("        TMA.ESME_OID_ESTA_MERC_2, ");
        sql.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + oidIdioma + ",TMA.ESME_OID_ESTA_MERC_1,'BEL_ESTAD_MERCA') DES_ESTA_MERC_1, ");
        sql.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + oidIdioma + ",TMA.ESME_OID_ESTA_MERC_2,'BEL_ESTAD_MERCA') DES_ESTA_MERC_2 ");
        sql.append(" FROM BEL_TIPO_MOVIM_ALMAC TMA, ");
        sql.append("      BEL_ESTAD_MERCA BEM1, ");
        sql.append("      BEL_ESTAD_MERCA BEM2 ");
        sql.append(" WHERE TMA.ESME_OID_ESTA_MERC_1 = BEM1.OID_ESTA_MERC(+) ");
        sql.append("   AND TMA.ESME_OID_ESTA_MERC_2 = BEM2.OID_ESTA_MERC(+) ");
        sql.append("   AND TMA.PAIS_OID_PAIS = " + oidPais); 
                    
        RecordSet rs = null;    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try { 
            rs = bs.dbService.executeStaticQuery(sql.toString());
        } catch (Exception e) {
            UtilidadesLog.error("cargarTiposSolicitudPais:Exception",e);                    
            throw new MareException (e, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    
        HashMap hashTipoMovimientoAlmacen = new HashMap();
    
        if (!rs.esVacio()){
            for(int i = 0; i < rs.getRowCount(); i++){
                RecordSet rsAux = new RecordSet();
                for (int j = 0; j < rs.getColumnCount(); j++) {
                    rsAux.addColumn(rs.getColumnName(j));
                }
                
                Vector vAux = rs.getRow(i);
                rsAux.addRow(vAux);
            
                hashTipoMovimientoAlmacen.put(this.bigDecimalToLong(rs.getValueAt(i, "OID_TIPO_MOVI_ALMA")),rsAux);
            }
        }
        
        return hashTipoMovimientoAlmacen;
    }
 
    public DTOSalida getFPagoDetalNumPosi(Long oid) throws MareException{
        if (hashFPagoDetal == null){
             hashFPagoDetal = new HashMap();
        }
        if(!hashFPagoDetal.containsKey(oid)) {
            RecordSet rsAux = consultarFPagoDetalNumPosi(oid);
            DTOSalida dtoS =  new DTOSalida();
            dtoS.setResultado(rsAux);
            hashFPagoDetal.put(oid, dtoS);
        }
        
        return (DTOSalida)hashFPagoDetal.get(oid);
    }
    
    private RecordSet consultarFPagoDetalNumPosi(Long oid) throws MareException{
        RecordSet rs = new RecordSet();
        StringBuffer consulta = new StringBuffer("");   
        Vector parametros=new Vector();         

        consulta.append(" SELECT D.* , cra.CANA_OID_CANA, cra.MARC_OID_MARC ");
        consulta.append(" FROM  BEL_FORMA_PAGO C, BEL_FORMA_PAGO_DETAL D, ");
        consulta.append(" CRA_ACTIV cra ");
        consulta.append(" WHERE ");
        consulta.append(" C.OID_FORM_PAGO = D.FOPA_OID_FORM_PAGO AND ");
        consulta.append(" D.CACT_OID_ACTI = cra.OID_ACTI(+) AND ");
        consulta.append(" C.OID_FORM_PAGO = ? ");
        parametros.add(oid); 
        consulta.append(" ORDER BY NUM_POSI_DETA ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        try {
           rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("consultarFPagoDetalNumPosi: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        return rs;
    }    

    public RecordSet getAsigSubProcTipoSolicAplic(Long oidTipoSolicitud) throws MareException{
        if (hashAsigSubProcTipoSolicAplic == null){
             hashAsigSubProcTipoSolicAplic = new HashMap();
        }
        if(!hashAsigSubProcTipoSolicAplic.containsKey(oidTipoSolicitud)) {
            RecordSet rsAux = obtenerAsignacionSubprocesosTiposSolicitudAplicacion(this.pais, oidTipoSolicitud);
            hashAsigSubProcTipoSolicAplic.put(oidTipoSolicitud, rsAux);
        }
        
        return (RecordSet)hashAsigSubProcTipoSolicAplic.get(oidTipoSolicitud);
    }

    private RecordSet obtenerAsignacionSubprocesosTiposSolicitudAplicacion(Long oidPais, Long oidTipoSolicitud) throws MareException{
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT  ASTS.OID_ASIG_SUBP_POR_TIPO_SOLI");
        query.append(" ,ASTS.TSPA_OID_TIPO_SOLI_PAIS");
        query.append(" ,P.OID_PROC");
        query.append(" ,ASTS.SUBP_OID_SUBP_APLI_CUOT");
        query.append(" ,ASTS.CCBA_OID_CUEN_CORR_BANC");
        query.append(" from CCC_ASIGN_SUBPR_TIPO_SOLIC ASTS, PED_TIPO_SOLIC_PAIS  TSP, CCC_PROCE P, CCC_SUBPR S");
        query.append(" where ASTS.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS");
        query.append(" and ASTS.SUBP_OID_SUBP_APLI_CUOT = S.OID_SUBP");
        query.append(" and S.CCPR_OID_PROC = P.OID_PROC"); 
        query.append(" and TSP.PAIS_OID_PAIS = " + oidPais);
        query.append(" and TSP.oid_tipo_soli_pais = " + oidTipoSolicitud);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try  {
            rs =  bs.dbService.executeStaticQuery(query.toString());            
        } catch (MareException me) {
           UtilidadesLog.debug("obtenerAsignacionSubprocesosTiposSolicitudAplicacion: llego a la excepcion Mare "); 
            throw me;
        } catch (Exception ex){
            UtilidadesLog.debug("obtenerAsignacionSubprocesosTiposSolicitudAplicacion: llego a la excepcion desconocida ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }    
        
        return rs;
    }

    public RecordSet getAsigSubProcTipoSolicCreac(Long oidTipoSolicitud) throws MareException{
        if (hashAsigSubProcTipoSolicCreac == null){
             hashAsigSubProcTipoSolicCreac = new HashMap();
        }
        if(!hashAsigSubProcTipoSolicCreac.containsKey(oidTipoSolicitud)) {
            RecordSet rsAux = obtenerAsignacionSubprocesosTiposSolicitudCreacion(this.pais, oidTipoSolicitud);
            hashAsigSubProcTipoSolicCreac.put(oidTipoSolicitud, rsAux);
        }
        
        return (RecordSet)hashAsigSubProcTipoSolicCreac.get(oidTipoSolicitud);
    }

    private RecordSet obtenerAsignacionSubprocesosTiposSolicitudCreacion(Long oidPais, Long oidTipoSolicitud) throws MareException{
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        
        query.append(" SELECT  ASTS.OID_ASIG_SUBP_POR_TIPO_SOLI ");
        query.append(" ,ASTS.TSPA_OID_TIPO_SOLI_PAIS ");
        query.append(" ,P.OID_PROC ");
        query.append(" ,ASTS.SUBP_OID_SUBP_CREA_CUOT ");
        query.append(" ,ASTS.CCBA_OID_CUEN_CORR_BANC ");
        query.append(" from CCC_ASIGN_SUBPR_TIPO_SOLIC ASTS, PED_TIPO_SOLIC_PAIS  TSP, CCC_PROCE P, CCC_SUBPR S ");
        query.append(" where ASTS.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        query.append(" and ASTS.SUBP_OID_SUBP_CREA_CUOT = S.OID_SUBP ");
        query.append(" and S.CCPR_OID_PROC = P.OID_PROC "); 
        query.append(" and TSP.PAIS_OID_PAIS = " + oidPais);
        query.append(" and TSP.oid_tipo_soli_pais = " + oidTipoSolicitud);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try  {
            rs =  bs.dbService.executeStaticQuery(query.toString());            
        } catch (MareException me) {
           UtilidadesLog.debug("obtenerAsignacionSubprocesosTiposSolicitudAplicacion: llego a la excepcion Mare "); 
            throw me;
        } catch (Exception ex){
            UtilidadesLog.debug("obtenerAsignacionSubprocesosTiposSolicitudAplicacion: llego a la excepcion desconocida ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }    
        
        return rs;
    }

    private static Long getIdiomaDefecto() {
        Long idiomaDefecto = null;
        
        try {
            idiomaDefecto = RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor();
        } catch (Exception ex) {}

        return idiomaDefecto;            
    }

    //sapaza -- PER-SiCC-2011-0441 -- 23/06/2011
    public Long getPeriodoPosterior(Long oidPeriodo, Long numeroCampanas) throws MareException{
        if (hashPeriodosPosteriores == null){
             hashPeriodosPosteriores = new HashMap();
        }
        
        if(numeroCampanas == 0) return oidPeriodo;
        
        String oid = oidPeriodo.toString() + "," + numeroCampanas.toString();
        
        if(!hashPeriodosPosteriores.containsKey(oid)) {
            Long valor = consultarPeriodoPosterior(oidPeriodo, numeroCampanas);
            hashPeriodosPosteriores.put(oid, valor);
        }
        
        return (Long)hashPeriodosPosteriores.get(oid);
    }

    //sapaza -- PER-SiCC-2011-0441 -- 23/06/2011
    private Long consultarPeriodoPosterior(Long oidPeriodo, Long numeroCampanas) throws MareException{
        RecordSet rs = new RecordSet();
        StringBuffer consulta = new StringBuffer("");   
        Long resultado = null;         

        consulta.append("  SELECT B.oid_peri OID_PERI ");
        consulta.append("     FROM cra_perio A, cra_perio B, SEG_PERIO_CORPO C, SEG_PERIO_CORPO D ");
        consulta.append("    WHERE A.oid_peri = " + oidPeriodo );
        consulta.append("      AND B.pais_oid_pais = A.pais_oid_pais ");
        consulta.append("      AND B.marc_oid_marc = A.marc_oid_marc ");
        consulta.append("      AND B.cana_oid_cana = A.cana_oid_cana ");
        consulta.append("      AND C.OID_PERI = A.PERI_OID_PERI ");
        consulta.append("      AND D.OID_PERI = B.PERI_OID_PERI ");
        consulta.append("      AND D.COD_PERI > C.COD_PERI ");
        consulta.append("  ORDER BY D.COD_PERI ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        try {
           rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("consultarPeriodoPosterior: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        int fila = numeroCampanas.intValue() - 1;
        if (rs != null && !rs.esVacio()) {
            resultado =  this.bigDecimalToLong(rs.getValueAt(fila, 0));
        }
        
        return resultado;
    }    
    
}
