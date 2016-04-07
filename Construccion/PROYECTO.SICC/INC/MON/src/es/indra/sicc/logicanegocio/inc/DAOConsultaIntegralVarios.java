package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.sicc.dtos.inc.DTOMovimientoCtaCte;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

public class DAOConsultaIntegralVarios {
    public DAOConsultaIntegralVarios() { }

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       22/06/2006
    * Comentario:  Se modifica la consulta para que sea paginada
    */

public RecordSet consultarDetalleRecomendacion(DTOCabeceraConsultaIntegral dto) 
             throws MareException{       
             UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetalleRecomendacion(DTOCabeceraConsultaIntegral dto): Entrada");
             GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
             CadenaFiltro cadenaFiltro = new CadenaFiltro();
 
 //Agregado por Cristian Valenzuela - 22/06/2006    
 cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
 //Fin - Agregado por Cristian Valenzuela - 22/06/2006
             cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
             cadenaFiltro.concatenar(gestor.getQueryRecomendacion(dto));
             cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
             cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));
 // vbongiov -- 4/09/2006 -- inc 1130
 // vbongiov -- INC 014 -- 20/10/2008
             cadenaFiltro.concatenar(new StringBuffer(" GROUP BY OID_CONCURSO, CLIE_OID_CLIE, ORIGEN, FECHA_INSCRIPCION,NUMERO_CONCURSO, " + 
      " DESC_CONCURSO,   PERIODO,  CODIGO_RECOM,NOMBRE_APELLIDO, " +
      " NIVEL,  NUMERO_PREMIO,  TIPO_PREMIO,DATOS_PREMIO,SITUACION, MOTIVO_INCUMPLIMIENTO, " +
                  " DETALLE_PREMIO_REEMPLAZO, imp_mont_soli, OID_CLIE"));
 cadenaFiltro.concatenar(new StringBuffer(" ORDER BY FECHA_INSCRIPCION DESC "));
 //Agregado por Cristian Valenzuela - 22/06/2006    
 cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));
 //Fin - Agregado por Cristian Valenzuela - 22/06/2006    

             RecordSet rs = new RecordSet();
     BelcorpService belcorpService;  
              
             try {
                     belcorpService = BelcorpService.getInstance();
                     rs = belcorpService.dbService.executePreparedQuery(cadenaFiltro.getCadena().toString(),
                             cadenaFiltro.getParamFiltro());                
         }
             catch (Exception e) {
                     UtilidadesLog.error("ERROR ", e);
             throw new MareException(e, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }
     
     // vbongiov -- 9/02/2009 -- Cambio 20080806
     RecordSet rs1 = null;
     StringBuffer sb1 = null;
     int delta = 0;
     Long periDesde = null;
     Long periHasta = null;        
     RecordSet rs2 = null;
     StringBuffer sb2 = null;
     
     try{
         int cant = rs.getRowCount();
         for(int i = 0; i < cant; i++) {
         
             rs1 = new RecordSet();
             sb1 = new StringBuffer();
         
             sb1.append(" SELECT cons.VAL_PERI_EVAL, recom.PERD_OID_PERI ");
             sb1.append(" FROM INC_CONCU_PARAM_CONSU cons, INC_CLIEN_RECDO recom, INC_CLIEN_RECTE recomte ");
             sb1.append(" WHERE cons.COPA_OID_PARA_GRAL = " + ((BigDecimal)rs.getValueAt(i, "OID_CONCURSO")).toString());
             sb1.append(" AND recom.CLIE_OID_CLIE = " + ((BigDecimal)rs.getValueAt(i, "OID_CLIE")).toString());
             sb1.append(" AND recom.clr3_oid_clie_rete = recomte.OID_CLIE_RETE ");                
             sb1.append(" AND recomte.CLIE_OID_CLIE = " + dto.getOidCliente());    
             
             rs1 = belcorpService.dbService.executeStaticQuery(sb1.toString()); 
             
             if((BigDecimal)rs1.getValueAt(0, "VAL_PERI_EVAL") != null && !(((BigDecimal)rs1.getValueAt(0, "VAL_PERI_EVAL")).equals(new BigDecimal(0)))) {
                 delta = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "VAL_PERI_EVAL")).toString()).intValue() - 1;
             } else {
                 delta = 0;
             }
             
             if(delta!=0) {
                 periDesde = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "PERD_OID_PERI")).toString());                    
                 periHasta = obtenerPeriodoMasDelta(Long.valueOf(((BigDecimal)rs1.getValueAt(0, "PERD_OID_PERI")).toString()), delta);
                 
             } else {
                 periDesde = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "PERD_OID_PERI")).toString());
                 periHasta = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "PERD_OID_PERI")).toString());
             }
             
             rs2 = new RecordSet();
             sb2 = new StringBuffer();
                             
             sb2.append(" SELECT SUM(recom.IMP_MONT_SOLI) IMP_MONT_SOLI ");
             sb2.append(" FROM INC_SOLIC_CONCU_RECOM recom, ");
             sb2.append(" cra_perio peri1, cra_perio peri2, cra_perio peri3 ");
             sb2.append(" WHERE recom.CLIE_OID_CLIE = " + dto.getOidCliente());
             sb2.append(" AND recom.COPA_OID_PARA_GRAL = " + ((BigDecimal)rs.getValueAt(i, "OID_CONCURSO")).toString());
             sb2.append(" AND recom.CLIE_OID_RECO_DADO = " + ((BigDecimal)rs.getValueAt(i, "OID_CLIE")).toString());                
             sb2.append(" AND (recom.IND_ANUL IS NULL OR recom.IND_ANUL = 0) ");
             sb2.append(" AND recom.IND_SOLI_VALI = 1  ");
             sb2.append(" AND recom.CLIE_OID_RECO_DADO is not null ");
             sb2.append(" AND peri1.OID_PERI = " + periDesde);
             sb2.append(" AND peri2.OID_PERI = " + periHasta);
             sb2.append(" AND recom.PERD_OID_PERI = peri3.OID_PERI ");
             sb2.append(" AND peri1.FEC_INIC <= peri3.FEC_INIC   ");
             sb2.append(" AND peri2.FEC_FINA >= peri3.FEC_FINA  ");
             sb2.append(" GROUP BY recom.CLIE_OID_CLIE, recom.CLIE_OID_RECO_DADO, COPA_OID_PARA_GRAL ");                
             
             rs2 = belcorpService.dbService.executeStaticQuery(sb2.toString()); 
             
             // vbongiov -- SiCC 20090850 --5/03/2009
             if(!rs2.esVacio()){
                 if(rs2.getValueAt(0, "IMP_MONT_SOLI")!= null){
                     rs.setValueAt(((BigDecimal)rs2.getValueAt(0, "IMP_MONT_SOLI")).toString(), i, 13);
                 } else {
                     rs.setValueAt("0", i, 13);
                 }        
             } else {
                 rs.setValueAt("0", i, 13);
             }            
         }

         UtilidadesLog.debug("rs: " + rs);
                     
     } catch(Exception e) {
         e.printStackTrace();
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }
     
             UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetalleRecomendacion(DTOCabeceraConsultaIntegral dto): Salida");
             return rs;           
     }
     
    public Long obtenerPeriodoMasDelta(Long oidPeriodo, int delta) throws MareException
    {
        UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerPeriodoMasDelta(Long oidPeriodo, int delta):Entrada");
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        try
        {
            bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException e)
        {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try
        {
            query.append(" SELECT B.OID_PERI, pcor.COD_PERI");
            query.append(" FROM cra_perio A, cra_perio B, seg_perio_corpo pcor ");
            query.append(" WHERE A.oid_peri = " + oidPeriodo);
            query.append(" AND B.pais_oid_pais = A.pais_oid_pais ");
            query.append(" AND B.marc_oid_marc = A.marc_oid_marc ");
            query.append(" AND B.cana_oid_cana = A.cana_oid_cana ");
            query.append(" AND B.fec_inic >= A.fec_inic ");
            query.append(" AND pcor.oid_peri = B.peri_oid_peri ");
            query.append(" ORDER BY B.fec_inic ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        }
        catch(Exception e)
        {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        int cant = respuesta.getRowCount();
        for(int i = 0; i < cant; i++)
        {
            if(i == delta)
            {
                UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerPeriodoMasDelta(Long oidPeriodo, int delta):Salida");
                return Long.valueOf(((BigDecimal)respuesta.getValueAt(i, "OID_PERI")).toString());
            }
        }
        
        return null;
    }


	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public RecordSet consultarPremiosSeleccionados(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralVarios.consultarPremiosSeleccionados(DTOCabeceraConsultaIntegral dto): Entrada");
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();

        cadenaFiltro.concatenar(gestor.getQueryTotalesConcursoDetalle(dto));
        cadenaFiltro.concatenar(gestor.getQueryDetalleConcurso(dto));
        cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
        cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));
        cadenaFiltro.concatenar(new StringBuffer(" GROUP BY OID_CONCURSO, CLIE_OID_CLIE "));

		RecordSet rs = new RecordSet();
        BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executePreparedQuery(cadenaFiltro.getCadena().toString(),
				cadenaFiltro.getParamFiltro());
	    }
		catch (Exception e) {
			UtilidadesLog.error("ERROR ", e);
	        throw new MareException(e, 
		    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	    }
        
		UtilidadesLog.info("DAOConsultaIntegralVarios.consultarPremiosSeleccionados(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;  
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       22/06/2006
    * Comentario:  Se modifica la consulta para que sea paginada
    */

	public RecordSet consultarDetalleMotivosDescalificacion(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetalleMotivosDescalificacion(DTOCabeceraConsultaIntegral dto): Entrada");
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
		
    //Agregado por Cristian Valenzuela - 22/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
    //Fin Agregado por Cristian Valenzuela - 22/06/2006
		cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
		cadenaFiltro.concatenar(gestor.getQueryMotivoDescalificacion(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
		cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ORDER BY FECHA_DESCALIF DESC "));
    //Agregado por Cristian Valenzuela - 22/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));
    //Fin Agregado por Cristian Valenzuela - 22/06/2006

		RecordSet rs = new RecordSet();
	    BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executePreparedQuery(cadenaFiltro.getCadena().toString(),
				cadenaFiltro.getParamFiltro());
	    }
		catch (Exception e) {
			UtilidadesLog.error("ERROR ", e);
	        throw new MareException(e, 
		    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	    }
        
		UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetalleMotivosDescalificacion(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;           
	}
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       23/12/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       22/06/2006
    * Comentario:  Se modifica la consulta para que sea paginada
    */

	public RecordSet consultarDetallePremiosSeleccionados(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetallePremiosSeleccionados(DTOCabeceraConsultaIntegral dto): Entrada");       
        
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
        
    //Agregado por Cristian Valenzuela - 22/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
    //Fin Agregado por Cristian Valenzuela - 22/06/2006
		cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
		cadenaFiltro.concatenar(gestor.getQueryPremiosSelecionados(dto));        
		cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));        
        //cadenaFiltro.concatenar(new StringBuffer(" AND OID_CONCURSO = " + dto.getOidConcurso() + " ")); // JVM, sicc 20070448, se adiciona oid_concurso
		cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));        
		cadenaFiltro.concatenar(new StringBuffer(" ORDER BY FECHA_DIGITACION DESC "));
    //Agregado por Cristian Valenzuela - 22/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));
    //Fin Agregado por Cristian Valenzuela - 22/06/2006

		RecordSet rs = new RecordSet();
	    BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executePreparedQuery(cadenaFiltro.getCadena().toString(),
				cadenaFiltro.getParamFiltro());
	    }
		catch (Exception e) {
			UtilidadesLog.error("ERROR ", e);
	        throw new MareException(e, 
		    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	    }
        
		UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetallePremiosSeleccionados(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;           
	}
  
   public RecordSet obtenerParticipaPaticipanteCompleto(DTOMovimientoCtaCte DTOE) throws MareException {        
        UtilidadesLog.info("DAOConcurso.obtenerParticipaPaticipanteCompleto(DTOBuscarConcursos DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
	
        query.append(" SELECT PC.VAL_PART, PC.OID_PLAN_CONC, CPG.OID_PARA_GRAL ");
        query.append(" FROM INC_CONCU_PARAM_GENER CPG, INC_PLANT_CONCU PC ");
        query.append(" WHERE CPG.PLC2_OID_PLAN_CONC = PC.OID_PLAN_CONC ");
        query.append(" AND CPG.OID_PARA_GRAL = "+ DTOE.getOidConcurso());

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        
        UtilidadesLog.info("Resultado "+rs);
        UtilidadesLog.info("DAOConcurso.obtenerParticipaPaticipanteCompleto(DTOBuscarConcursos DTOE): Salida");
        return rs;
    
    }
  public RecordSet obtenerCliente(DTOMovimientoCtaCte DTOE) throws MareException {        
        UtilidadesLog.info("DAOConcurso.obtenerCliente(DTOBuscarConcursos DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
	
            query.append(" SELECT distinct c.OID_CLIE OID, c.COD_CLIE, c.VAL_NOM1, c.VAL_NOM2, c.VAL_APE1, c.VAL_APE2 ");
            query.append("   FROM MAE_CLIEN c ");
            query.append("  WHERE c.PAIS_OID_PAIS = " + DTOE.getOidPais());
            

            if (DTOE.getCodCliente() != null) {
                query.append("    AND c.COD_CLIE LIKE '" + DTOE.getCodCliente() + "' ");
            }else{
              return null;
            }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(rs.esVacio()){
          return null;
        }
        UtilidadesLog.info("Resultado "+rs);
        UtilidadesLog.info("DAOConcurso.obtenerCliente(DTOBuscarConcursos DTOE): Salida");
        return rs;
    
    }
    
    // vbongiov -- INC 014 -- 20/10/2008
    public RecordSet consultarRecomendacionPart(DTOCabeceraConsultaIntegral dtoe)  throws MareException
    {
        UtilidadesLog.info("DAOConsultaIntegralVarios.consultarRecomendacionPart(DTOCabeceraConsultaIntegral dtoe): Entrada");
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT cons.NUM_MINI_PEDI_RECO, cons.NUM_MINI_PEDI, cons.IMP_MONT_MINI_PEDI, ");
        query.append(" pcor1.cod_peri COD_PERI_DESDE, pcor2.cod_peri COD_PERI_HASTA, 0 MONT_MIN_RECOMENDADA ");
        query.append(" FROM INC_CONCU_PARAM_GENER conc, INC_CONCU_PARAM_CONSU cons,  ");       
        query.append(" seg_perio_corpo pcor1, cra_perio per1, ");
        query.append(" seg_perio_corpo pcor2, cra_perio per2   ");
        query.append(" WHERE pcor1.oid_peri = per1.peri_oid_peri   ");
        query.append(" AND per1.oid_peri = conc.PERD_OID_PERI_DESD ");
        query.append(" AND pcor2.oid_peri = per2.peri_oid_peri   ");
        query.append(" AND per2.oid_peri =conc.PERD_OID_PERI_HAST ");
        query.append(" AND conc.OID_PARA_GRAL = cons.COPA_OID_PARA_GRAL(+) ");
        query.append(" AND conc.OID_PARA_GRAL = " + dtoe.getOidConcurso());
        
        RecordSet rs;
        try
        {
            BelcorpService bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch(MareMiiServiceNotFoundException e)
        {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch(Exception e)
        {
            UtilidadesLog.error("ERROR ", e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("Resultado " + rs);
        UtilidadesLog.info("DAOConsultaIntegralVarios.consultarRecomendacionPart(DTOCabeceraConsultaIntegral dtoe)): Salida");
        return rs;
    }

    // vbongiov -- INC 014 -- 20/10/2008
    public RecordSet consultarDetallePedidosRecomendadas(DTOCabeceraConsultaIntegral dtoe) throws MareException
    {
        UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetallePedidosRecomendadas(DTOCabeceraConsultaIntegral dtoe): Entrada");
        CadenaFiltro cadenaFiltro = new CadenaFiltro();
        StringBuffer query = new StringBuffer();
        GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
        cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
        // vbongiov -- Cambio 20090861 -- 14/04/2009
        query.append(" SELECT mclie.COD_CLIE, pcor.cod_peri, TO_CHAR(ped.FEC_FACT, 'DD/MM/YYYY') FEC_FACT, ");
        query.append(" pedCon.VAL_NUME_SOLI,  recom.IMP_MONT_SOLI, recom.IND_ANUL, ");
        query.append(" DECODE(recom.IND_ANUL, 1,TO_CHAR(ped.FEC_FACT, 'DD/MM/YYYY'), '') FEC_ANUL ");        
        query.append(" FROM INC_SOLIC_CONCU_RECOM recom, mae_clien mclie, PED_SOLIC_CABEC ped, PED_SOLIC_CABEC pedCon, ");
        query.append(" seg_perio_corpo pcor, cra_perio per  ");
        query.append(" WHERE pcor.oid_peri = per.peri_oid_peri   ");
        query.append(" AND per.oid_peri = ped.PERD_OID_PERI ");
        query.append(" AND recom.CLIE_OID_CLIE = " + dtoe.getOidCliente());
        query.append(" AND recom.COPA_OID_PARA_GRAL = " + dtoe.getOidConcurso());
        query.append(" AND recom.CLIE_OID_RECO_DADO = mclie.oid_clie ");
        query.append(" AND recom.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");
        query.append(" AND ped.SOCA_OID_SOLI_CABE = pedCon.OID_SOLI_CABE ");
        // vbongiov -- Cambio 20090861 -- 14/04/2009
        query.append(" ORDER BY mclie.COD_CLIE, pcor.cod_peri DESC, ped.FEC_FACT DESC ");
        cadenaFiltro.concatenar(query);
        cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dtoe)));
        RecordSet rs;
        try
        {
            BelcorpService bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(cadenaFiltro.getCadena().toString());
        }
        catch(MareMiiServiceNotFoundException e)
        {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch(Exception e)
        {
            UtilidadesLog.error("ERROR ", e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("Resultado " + rs);
        UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetallePedidosRecomendadas(DTOCabeceraConsultaIntegral dtoe)): Salida");
        return rs;
    }
    
    // vbongiov -- 9/02/2009 -- Cambio 20080806
    public RecordSet consultarDetallePedidosRecomendante(DTOCabeceraConsultaIntegral dtoe) throws MareException
    {
        UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetallePedidosRecomendante(DTOCabeceraConsultaIntegral dtoe): Entrada");
        CadenaFiltro cadenaFiltro = new CadenaFiltro();
        StringBuffer query = new StringBuffer();
        StringBuffer query1 = new StringBuffer();
        GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
        RecordSet rs;
        RecordSet rs1;
        int delta = 0;
        Long periDesde = null;
        Long periHasta = null;
        
        try {
        
            BelcorpService bs = BelcorpService.getInstance();
        
            query1.append(" SELECT conc.PERD_OID_PERI_DESD, cons.VAL_PERI_EVAL ");
            query1.append(" FROM INC_CONCU_PARAM_CONSU cons, INC_CONCU_PARAM_GENER conc ");
            query1.append(" WHERE cons.COPA_OID_PARA_GRAL = conc.OID_PARA_GRAL ");
            query1.append(" AND conc.OID_PARA_GRAL = " + dtoe.getOidConcurso());
            
            rs1 = bs.dbService.executeStaticQuery(query1.toString());
            
            if((BigDecimal)rs1.getValueAt(0, "VAL_PERI_EVAL") != null && !(((BigDecimal)rs1.getValueAt(0, "VAL_PERI_EVAL")).equals(new BigDecimal(0)))) {
                delta = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "VAL_PERI_EVAL")).toString()).intValue() - 1;
            } else {
                delta = 0;
            }
            
            if(delta!=0) {
                periDesde = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "PERD_OID_PERI_DESD")).toString());                    
                periHasta = obtenerPeriodoMasDelta(Long.valueOf(((BigDecimal)rs1.getValueAt(0, "PERD_OID_PERI_DESD")).toString()), delta);
                
            } else {
                periDesde = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "PERD_OID_PERI_DESD")).toString());
                periHasta = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "PERD_OID_PERI_DESD")).toString());
            }
            
            cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
            query.append(" SELECT pcor.cod_peri, TO_CHAR(ped.FEC_FACT, 'DD/MM/YYYY') FEC_FACT, ");
            query.append(" pedCon.VAL_NUME_SOLI,  ped.VAL_PREC_CATA_TOTA_LOCA, tipoSol.IND_ANUL, ");
            query.append(" DECODE(tipoSol.IND_ANUL, 1,TO_CHAR(ped.FEC_FACT, 'DD/MM/YYYY'), '') FEC_ANUL ");
            query.append(" FROM PED_SOLIC_CABEC ped, PED_SOLIC_CABEC pedCon, ");
            query.append(" PED_TIPO_SOLIC_PAIS tipoSolP, PED_TIPO_SOLIC tipoSol, ");
            query.append(" seg_perio_corpo pcor, cra_perio peri1, cra_perio peri2, cra_perio peri3 ");
            query.append(" WHERE pcor.oid_peri = peri3.peri_oid_peri ");
            query.append(" AND peri3.oid_peri = ped.PERD_OID_PERI ");
            query.append(" AND peri1.OID_PERI = " + periDesde);
            query.append(" AND peri2.OID_PERI = " + periHasta);
            query.append(" AND peri1.FEC_INIC <= peri3.FEC_INIC ");
            query.append(" AND peri2.FEC_FINA >= peri3.FEC_FINA ");
            query.append(" AND ped.CLIE_OID_CLIE = " + dtoe.getOidCliente());
            query.append(" AND ped.IND_OC = 1 ");
            query.append(" AND ped.SOCA_OID_SOLI_CABE = pedCon.OID_SOLI_CABE ");
            query.append(" AND tipoSolP.OID_TIPO_SOLI_PAIS = ped.TSPA_OID_TIPO_SOLI_PAIS ");
            query.append(" AND tipoSol.OID_TIPO_SOLI = tipoSolP.TSOL_OID_TIPO_SOLI ");
            // vbongiov -- Cambio 20090861 -- 14/04/2009
            query.append(" ORDER BY pcor.cod_peri DESC, ped.FEC_FACT DESC");        
            
            cadenaFiltro.concatenar(query);     
            cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dtoe)));        
       
            rs = bs.dbService.executeStaticQuery(cadenaFiltro.getCadena().toString());
            
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            
        } catch(Exception e) {
            UtilidadesLog.error("ERROR ", e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("Resultado " + rs);
        UtilidadesLog.info("DAOConsultaIntegralVarios.consultarDetallePedidosRecomendante(DTOCabeceraConsultaIntegral dtoe)): Salida");
        return rs;
    }
  
}