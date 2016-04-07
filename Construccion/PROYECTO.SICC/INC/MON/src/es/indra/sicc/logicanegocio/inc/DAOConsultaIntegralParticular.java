package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;

public class DAOConsultaIntegralParticular {
    public DAOConsultaIntegralParticular() { }

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

	public RecordSet consultarDetalleConcursoSeleccionado(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetalleConcursoSeleccionado(DTOCabeceraConsultaIntegral dto): Entrada");
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
    
    //Agregado por Cristian Valenzuela - 22/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
    //Fin Agregado por Cristian Valenzuela - 22/06/2006
		cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
	        // vbongiov -- Cambio RI 20080810 -- 6/01/2009
		cadenaFiltro.concatenar(gestor.getQueryDetalleConcursoCC(dto));
                
		cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
                cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));   
                // vbongiov -- INC 014 -- 20/10/2008
                // vbongiov -- Cambio RI 20080810 -- 6/01/2009
                // vbongiov -- Cambio 20090861 -- 14/04/2009
                cadenaFiltro.concatenar(new StringBuffer(" ORDER BY COD_PERI DESC, fec_moviOrd DESC, fechaUltiActuOrd DESC "));    
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
        
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetalleConcursoSeleccionado(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;           
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public RecordSet consultarConcursoSeleccionado(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarConcursoSeleccionado(DTOCabeceraConsultaIntegral dto): Entrada");
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
                
	        // vbongiov -- Cambio RI 20080810 -- 6/01/2009		
                cadenaFiltro.concatenar(gestor.getQueryTotalesConcursoDetalleCC(dto));

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
        
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarConcursoSeleccionado(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;           
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       22/12/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       22/06/2006
    * Comentario:  Se modifica la consulta para que sea paginada
    */
	public RecordSet consultarDetalleMultinivel(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetalleMultinivel(DTOCabeceraConsultaIntegral dto): Entrada");       
    GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
    
    //Agregado por Cristian Valenzuela - 22/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
    //Fin Agregado por Cristian Valenzuela - 22/06/2006
		cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
		cadenaFiltro.concatenar(gestor.getQueryDetalleMultinivel(dto));                
		cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
		cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));		
    cadenaFiltro.concatenar(new StringBuffer(" ORDER BY CAMPANIA_INGRESO "));
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
        
    UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetalleMultinivel(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;    
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       23/05/2006
    * Incidencia:  DBLG500000317
    */
	public RecordSet consultarMultinivel(DTOCabeceraConsultaIntegral dto) 
      throws MareException{       
        UtilidadesLog.info("DAOConsultaIntegralParticular.consultarMultinivel(DTOCabeceraConsultaIntegral dto): Entrada");           
        GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
        CadenaFiltro cadenaFiltro = new CadenaFiltro();
        
        StringBuffer sb1 = new StringBuffer();   
        
        sb1.append(" SELECT MAX(DETALLE.LACODIGOMADRE) LACODIGOMADRE, MAX(DETALLE.LANOMBREAPELLIDO) LANOMBREAPELLIDO, ");
        sb1.append(" MAX(DETALLE.ESTADO_RE) LAESTADO,  ");
        sb1.append(" SUM(PED_RTE.VAL_CANT) LAIMPORTEVENTA,  ");
        sb1.append(" SUM(CCC.IMPORTE_INICIAL) LAIMPORTEINICIAL,  ");
        sb1.append(" SUM(CCC.IMPORTE_PAGADO) LAIMPORTEPAGADO, ");
        sb1.append(" MAX(DETALLE.LADOCUMIDENTIDAD)LADOCUMIDENTIDAD,  ");
        sb1.append(" MAX(DETALLE.LAZONA) LAZONA,  ");
        sb1.append(" MAX(DECODE(DETALLE.GANADORA,0,'SI','NO')) LALOGRACALIFICACION, ");
        sb1.append(" COUNT(DETALLE.CLIE_OID_CLIE) LANROTOTALHIJASINICIO,SUM(ESTADO_NUEVA) LANROHIJASNUEVAS,  ");
        sb1.append(" COUNT(1) LANROTOTALHIJASCIERRE, SUM(HIJA_ACTIVA) LANROHIJASACTIVASCIERRE, ");
        sb1.append(" NVL((SUM(IMPORTE_VENTA) / COUNT(DETALLE.CLIE_OID_CLIE)),0) LAPROMEDIOPEDIDOHIJAS, ");
        sb1.append(" COUNT(DETALLE.CLIE_OID_CLIE) LAPEDIDOSHIJASRED, 'SI' LAPEDIDOSMADRERED,  ");
        sb1.append(" SUM(IMPORTE_VENTA)LAIMPORTEVENTARED,  MAX(DETALLE.LABASECALCULO) LABASECALCULO ");
        sb1.append(" FROM ( ");
        
        StringBuffer sb2 = new StringBuffer();       
        
        sb2.append(" ) DETALLE, ");
        sb2.append(" INC_PEDID_RECTE_MULTI PED_RTE, ");
        sb2.append(" (SELECT CMCC.PERD_OID_PERI, CMCC.CLIE_OID_CLIE,  ");
        sb2.append(" SUM(CMCC.IMP_MOVI) IMPORTE_INICIAL, ");
        sb2.append(" SUM(CMCC.IMP_PAGA) IMPORTE_PAGADO ");
        sb2.append(" FROM CCC_MOVIM_CUENT_CORRI CMCC ");
        sb2.append(" GROUP BY CMCC.PERD_OID_PERI, CMCC.CLIE_OID_CLIE) CCC	   ");
        sb2.append(" WHERE DETALLE.OID_CLIE_RECO_MULT = PED_RTE.CLR2_CLIE_OID_CLIE ");
        sb2.append(" AND PED_RTE.PERD_OID_PERI = ? ");
        sb2.append(" AND DETALLE.PERD_OID_PERI = PED_RTE.PERD_OID_PERI ");
        sb2.append(" AND DETALLE.CLIE_OID_CLIE = CCC.CLIE_OID_CLIE ");  
        sb2.append(" AND DETALLE.PERD_OID_PERI = CCC.PERD_OID_PERI ");       
        sb2.append(" GROUP BY OID_CONCURSO, DETALLE.CLIE_OID_CLIE ");

        cadenaFiltro.concatenar(sb1);		
        cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));		
        cadenaFiltro.concatenar(gestor.getQueryDetalleMultinivel(dto));		
        cadenaFiltro.concatenar(new StringBuffer(" )  WHERE 1=1 "));		
        cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));		
        cadenaFiltro.concatenar(sb2);		        
        cadenaFiltro.concatenarParametro(dto.getOidCampania());

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
      
        UtilidadesLog.info("DAOConsultaIntegralParticular.consultarMultinivel(DTOCabeceraConsultaIntegral dto): Salida");
        return rs;           
    }

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       23/06/2006
    * Comentario:  Se modifica la consulta para que sea paginada
    */

	public RecordSet consultarDetallePremioArticulo(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetallePremioArticulo(DTOCabeceraConsultaIntegral dto): Entrada");
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
    
    //Agregado por Cristian Valenzuela - 23/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
    //Fin Agregado por Cristian Valenzuela - 23/06/2006
		cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
		cadenaFiltro.concatenar(gestor.getQueryPremiosProceArticulo(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
		cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ORDER BY FECHA_OBTENCION DESC "));
    //Agregado por Cristian Valenzuela - 23/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));
    //Fin Agregado por Cristian Valenzuela - 23/06/2006

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
        
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetallePremioArticulo(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;           
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       23/06/2006
    * Comentario:  Se modifica la consulta para que sea paginada
    */

	public RecordSet consultarDetallePremioMonetario(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetallePremioMonetario(DTOCabeceraConsultaIntegral dto): Entrada");
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
    
    //Agregado por Cristian Valenzuela - 23/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
    //Fin Agregado por Cristian Valenzuela - 23/06/2006
		cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
		cadenaFiltro.concatenar(gestor.getQueryPremiosProceMonetario(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
		cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ORDER BY FECHA_OBTENCION DESC "));
    //Agregado por Cristian Valenzuela - 23/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));
    //Fin Agregado por Cristian Valenzuela - 23/06/2006

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
        
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetallePremioMonetario(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;           
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       23/06/2006
    * Comentario:  Se modifica la consulta para que sea paginada
    */

	public RecordSet consultarDetallePremioPuntos(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetallePremioPuntos(DTOCabeceraConsultaIntegral dto): Entrada");
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();

    //Agregado por Cristian Valenzuela - 23/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
    //Fin Agregado por Cristian Valenzuela - 23/06/2006
		cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
		cadenaFiltro.concatenar(gestor.getQueryPremiosProcePuntos(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
		cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ORDER BY FECHA_OBTENCION DESC "));
    //Agregado por Cristian Valenzuela - 23/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));
    //Fin Agregado por Cristian Valenzuela - 23/06/2006

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
        
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetallePremioPuntos(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;           
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado   Cristian Valenzuela
    * Fecha:       23/06/2006
    * Comentario:  Se modifica la consulta para que sea paginada
    */

	public RecordSet consultarDetallePremioDescuento(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetallePremioDescuento(DTOCabeceraConsultaIntegral dto): Entrada");
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadenaFiltro = new CadenaFiltro();

    //Agregado por Cristian Valenzuela - 23/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
    //Fin Agregado por Cristian Valenzuela - 23/06/2006
		cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
		cadenaFiltro.concatenar(gestor.getQueryPremiosProceDescuento(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
		cadenaFiltro.concatenar(gestor.getFiltrosGralDetalle(dto));
		cadenaFiltro.concatenar(new StringBuffer(" ORDER BY FECHA_OBTENCION DESC "));
    //Agregado por Cristian Valenzuela - 23/06/2006
    cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));
    //Fin Agregado por Cristian Valenzuela - 23/06/2006

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
        
		UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetallePremioDescuento(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;           
	}
        
    // vbongiov -- Cambio RI 20080810 -- 6/01/2009
    public RecordSet consultarDetalleSolicitudes(DTOCabeceraConsultaIntegral dto) 
                throws MareException{       
        UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetalleSolicitudes(DTOCabeceraConsultaIntegral dto): Entrada");
        GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
        CadenaFiltro cadenaFiltro = new CadenaFiltro();
                
        // vbongiov -- Cambio RI 20080810 -- 6/01/2009  
        cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryInicioPaginado()));
        cadenaFiltro.concatenar(gestor.getQueryDetalleSolicitudes(dto));
        cadenaFiltro.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));
    
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
    
            UtilidadesLog.info("DAOConsultaIntegralParticular.consultarDetalleSolicitudes(DTOCabeceraConsultaIntegral dto): Salida");
            return rs;           
    }
}