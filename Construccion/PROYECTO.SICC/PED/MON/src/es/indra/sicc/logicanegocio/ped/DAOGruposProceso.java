package es.indra.sicc.logicanegocio.ped;

import es.indra.sicc.dtos.ped.DTOListaProcesos;
import es.indra.sicc.dtos.ped.DTOProceso; 
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.ped.ErroresNegocio;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DAOGruposProceso  {
  public DAOGruposProceso() {
  }

  /*
   * Autor: Cortaberría
   * Fecha: 06/07/2005
   * En el IF se estaba comparando con == los 2 objetos Long.
   * Tambien se modificao el new Boolean(false/true) por Boolean.FALSE o TRUE segun corresponda
   */
  public Boolean esGrupoProcesosOnline(Long oidTipoSolicitud, Long oidGrupoSolicitud) throws MareException {
    UtilidadesLog.info("DAOGruposProceso.esGrupoProcesosOnline(Long oidTipoSolicitud, Long oidGrupoSolicitud): Entrada");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    RecordSet respuesta;

    if ((oidGrupoSolicitud == null) || (oidTipoSolicitud == null)){
      return Boolean.FALSE;
    }
    
    try {
      
      if (oidGrupoSolicitud.equals(ConstantesPED.GP5)) { 
			  query.append("SELECT IND_EJEC_ONLI FROM PED_SECUE_PROCE, PED_TIPO_SOLIC_PAIS TSP");
			  query.append(" WHERE GRPR_OID_GRUP_PROC = '" + oidGrupoSolicitud.longValue() + "'");
			  query.append(" AND TSP.OID_TIPO_SOLI_PAIS = '" + oidTipoSolicitud.longValue() + "'");
              query.append(" AND TSPA_OID_TIPO_SOLI_PAIS = TSP.TSOL_OID_TIPO_CONS");
			  query.append(" AND ROWNUM = 1");
			  query.append(" ORDER BY COD_SECU");
      } else {
			  query.append("SELECT IND_EJEC_ONLI FROM PED_SECUE_PROCE");
			  query.append(" WHERE GRPR_OID_GRUP_PROC = '" + oidGrupoSolicitud.longValue() + "'");
			  query.append(" AND TSPA_OID_TIPO_SOLI_PAIS = '" + oidTipoSolicitud.longValue() + "'");
			  query.append(" AND ROWNUM = 1");
			  query.append(" ORDER BY COD_SECU");
      }
   
      respuesta = bs.dbService.executeStaticQuery(query.toString());
    }catch (Exception e) {
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
 
    if ((respuesta != null) && (respuesta.getRowCount() > 0)) {
      if ( ((BigDecimal)respuesta.getValueAt(0,0)).intValue() == 1) {
        UtilidadesLog.info("DAOGruposProceso.esGrupoProcesosOnline(Long oidTipoSolicitud, Long oidGrupoSolicitud): Salida ");
        return Boolean.TRUE; 
      } else {
        UtilidadesLog.info("DAOGruposProceso.esGrupoProcesosOnline(Long oidTipoSolicitud, Long oidGrupoSolicitud): Salida ");
        return Boolean.FALSE;
      }
    } else {
     	throw new MareException(null, null,
		                           	UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, 
                                "", ErroresNegocio.PED_021));      
    }
    
  }
  
  public Boolean esGrupoProcesosOnlineFAC(Long oidTipoSolicitud, Long oidGrupoSolicitud) throws MareException {
    UtilidadesLog.info("DAOGruposProceso.esGrupoProcesosOnlineFAC(Long oidTipoSolicitud, Long oidGrupoSolicitud): Entrada");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    RecordSet respuesta;

    if ((oidGrupoSolicitud == null) || (oidTipoSolicitud == null)){
      return Boolean.FALSE;
    }
    
    try {
      
			  query.append("SELECT IND_EJEC_ONLI FROM PED_SECUE_PROCE");
			  query.append(" WHERE GRPR_OID_GRUP_PROC = '" + oidGrupoSolicitud.longValue() + "'");
			  query.append(" AND TSPA_OID_TIPO_SOLI_PAIS = '" + oidTipoSolicitud.longValue() + "'");
			  query.append(" AND ROWNUM = 1");
			  query.append(" ORDER BY COD_SECU");
   
      respuesta = bs.dbService.executeStaticQuery(query.toString());
    }catch (Exception e) {
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
 
    if ((respuesta != null) && (respuesta.getRowCount() > 0)) {
        if ( ((BigDecimal)respuesta.getValueAt(0,0)).intValue() == 1) {
            UtilidadesLog.info("DAOGruposProceso.esGrupoProcesosOnlineFAC(Long oidTipoSolicitud, Long oidGrupoSolicitud): Salida ");
            return Boolean.TRUE; 
        } else {
            UtilidadesLog.info("DAOGruposProceso.esGrupoProcesosOnlineFAC(Long oidTipoSolicitud, Long oidGrupoSolicitud): Salida ");
            return Boolean.FALSE;
        }
    } else {
        throw new MareException(null, null,
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED,  
            "", ErroresNegocio.PED_021));      
    }
    
  }

  public Long obtenerProximoGrupoProceso(Long oidGrupoProceso) throws MareException {
    UtilidadesLog.info("DAOGruposProceso.obtenerProximoGrupoProceso(Long oidGrupoProceso): Entrada ");
    if (oidGrupoProceso.longValue() == ConstantesPED.GP1.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerProximoGrupoProceso(Long oidGrupoProceso): Salida ");
        return ConstantesPED.GP2;
    }
    
    if (oidGrupoProceso.longValue() == ConstantesPED.GP2.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerProximoGrupoProceso(Long oidGrupoProceso): Salida ");
        return ConstantesPED.GP3;
    }
    
    if (oidGrupoProceso.longValue() == ConstantesPED.GP3.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerProximoGrupoProceso(Long oidGrupoProceso): Salida ");
        return ConstantesPED.GP4;
    }
    
    if (oidGrupoProceso.longValue() == ConstantesPED.GP4.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerProximoGrupoProceso(Long oidGrupoProceso): Salida ");
        return ConstantesPED.GP5;
    }
    
    if (oidGrupoProceso.longValue() == ConstantesPED.GP5.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerProximoGrupoProceso(Long oidGrupoProceso): Salida ");
        throw new MareException(null, null,
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, 
           "", ErroresNegocio.PED_022));      
        
    }
    UtilidadesLog.info("DAOGruposProceso.obtenerProximoGrupoProceso(Long oidGrupoProceso): Salida ");    
    return null;
  }

  public Long obtenerGrupoProcesoAnterior(Long oidGrupoProceso) throws MareException {
    UtilidadesLog.info("DAOGruposProceso.obtenerGrupoProcesoAnterior(Long oidGrupoProceso) : Entrada");
    if (oidGrupoProceso.longValue() == ConstantesPED.GP5.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerGrupoProcesoAnterior(Long oidGrupoProceso) : Salida ");
        return ConstantesPED.GP4;
    }
    
    if (oidGrupoProceso.longValue() == ConstantesPED.GP4.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerGrupoProcesoAnterior(Long oidGrupoProceso) : Salida ");
        return ConstantesPED.GP3;
    }
    
    if (oidGrupoProceso.longValue() == ConstantesPED.GP3.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerGrupoProcesoAnterior(Long oidGrupoProceso) : Salida ");
        return ConstantesPED.GP2;
    }
    
    if (oidGrupoProceso.longValue() == ConstantesPED.GP2.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerGrupoProcesoAnterior(Long oidGrupoProceso) : Salida ");
        return ConstantesPED.GP1;
    }
    
    if (oidGrupoProceso.longValue() == ConstantesPED.GP1.longValue()) {
        UtilidadesLog.info("DAOGruposProceso.obtenerGrupoProcesoAnterior(Long oidGrupoProceso) : Salida ");
   		throw new MareException(null, null,
	                           	UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, 
                               "", ErroresNegocio.PED_023));      
    
    }
    UtilidadesLog.info("DAOGruposProceso.obtenerGrupoProcesoAnterior(Long oidGrupoProceso) : Salida ");
    return null;
  }

  /**
   * Autor: Cortaberria
   * fecha: 22/04/2005
   * Modifico condicion (respuesta != null && respuesta.getRowCount() > 0)
   */
  public DTOListaProcesos obtenerGrupoProcesos(Long oidGrupoProceso, Long oidTipoSolPais) throws MareException {
    UtilidadesLog.info("DAOGruposProcesos.obtenerGrupoProcesos(Long oidGrupoProceso, Long oidTipoSolPais): Entrada ");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    RecordSet respuesta;

    if ((oidGrupoProceso == null) || (oidTipoSolPais == null)) {
        UtilidadesLog.info("DAOGruposProcesos.obtenerGrupoProcesos(Long oidGrupoProceso, Long oidTipoSolPais): Salida ");
        return new DTOListaProcesos();
    }

    try {

      query.append("SELECT S.COD_SECU,P.TPOS_OID_TIPO_POSI,P.STPO_OID_SUBT_POSI,PRG.VAL_CLAS_EJEC,PRG.COD_PROG,P.OID_PROC");
			query.append(" FROM PED_SECUE_PROCE S,PED_PROCE P ,PED_PROGR PRG");
			query.append(" WHERE S.GRPR_OID_GRUP_PROC = '" + oidGrupoProceso.longValue() + "'");
			query.append(" AND S.TSPA_OID_TIPO_SOLI_PAIS = '" + oidTipoSolPais.longValue() + "'");
			query.append(" AND P.OID_PROC = S.PROC_OID_PROC");
      query.append(" AND PRG.OID_PROG = P.PROG_OID_PROG");
			query.append(" ORDER BY COD_SECU");

      respuesta = bs.dbService.executeStaticQuery(query.toString());

      if (respuesta != null && respuesta.getRowCount() > 0) {
      
        DTOListaProcesos dtoLProc = new DTOListaProcesos(); 
        ArrayList lista = new ArrayList(); 

        //if ((respuesta.getRowCount()) > 0 && (!respuesta.equals(null))) {
      
            for (int row = 0; row < respuesta.getRowCount(); row++) {

               DTOProceso dtoProc = new DTOProceso();
               //inc.: 7275, resulta..... 
             
               dtoProc.setBusinessID(( respuesta.getValueAt(row, "VAL_CLAS_EJEC")==null ? null : respuesta.getValueAt(row, "VAL_CLAS_EJEC")).toString() );
               //
               dtoProc.setCodProceso(( respuesta.getValueAt(row, "COD_PROG")==null ? null : respuesta.getValueAt(row, "COD_PROG")).toString() );
               dtoProc.setOidProceso(( respuesta.getValueAt(row, "OID_PROC")==null ? null : new Long(( (BigDecimal)respuesta.getValueAt(row, "OID_PROC")).toString())) );
               dtoProc.setOidSubTipoPosicion(( respuesta.getValueAt(row, "STPO_OID_SUBT_POSI")==null ? null: new Long(( (BigDecimal)respuesta.getValueAt(row, "STPO_OID_SUBT_POSI")).toString())) );
               dtoProc.setOidTipoPosicion(( respuesta.getValueAt(row, "TPOS_OID_TIPO_POSI")==null ? null : new Long(( (BigDecimal)respuesta.getValueAt(row, "TPOS_OID_TIPO_POSI")).toString())) );
               dtoProc.setSecuencia(( respuesta.getValueAt(row, "COD_SECU")==null ? null : new Integer(( (BigDecimal)respuesta.getValueAt(row, "COD_SECU")).toString())) );

               lista.add(dtoProc);

            }

            dtoLProc.setListaProcesos(lista);
            UtilidadesLog.info("DAOGruposProcesos.obtenerGrupoProcesos(Long oidGrupoProceso, Long oidTipoSolPais): Salida ");
            return dtoLProc; 
        //}
        //return null;
      } else{
        UtilidadesLog.info("DAOGruposProcesos.obtenerGrupoProcesos(Long oidGrupoProceso, Long oidTipoSolPais): Salida ");
        return new DTOListaProcesos(); 
      }
      
    } catch (Exception e) {
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }

  }

  public DTOListaProcesos obtenerGrupoProcesosReverso(Long oidGrupoProceso, Long oidTipoSolPais) throws MareException {
    UtilidadesLog.info("DAOGruposProcesos.obtenerGrupoProcesosReverso(Long oidGrupoProceso, Long oidTipoSolPais): Entrada ");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    RecordSet respuesta;

    UtilidadesLog.debug("oidGrupoProceso...: "+oidGrupoProceso);
    UtilidadesLog.debug("oidTipoSolPais...: "+oidTipoSolPais);

    try {

        query.append("SELECT S.COD_SECU,PR.TPOS_OID_TIPO_POSI,PR.STPO_OID_SUBT_POSI,PRG.VAL_CLAS_EJEC,PR.COD_PROC ,PR.OID_PROC");
        query.append(" FROM PED_SECUE_PROCE S,PED_PROCE P,PED_PROCE PR ,PED_PROGR PRG");
        query.append(" WHERE S.GRPR_OID_GRUP_PROC = '" + oidGrupoProceso.longValue() + "'");
        query.append(" AND S.TSPA_OID_TIPO_SOLI_PAIS = '" + oidTipoSolPais.longValue() + "'");
        query.append(" AND P.OID_PROC=S.PROC_OID_PROC");
        query.append(" AND P.PROC_OID_PROC=PR.OID_PROC");
        query.append(" AND PRG.OID_PROG=PR.PROG_OID_PROG"); 
        query.append(" ORDER BY COD_SECU DESC");

        respuesta = bs.dbService.executeStaticQuery(query.toString());
        UtilidadesLog.debug("query de obtenerGrupoProcesosReverso: " + respuesta);

        if (respuesta.getRowCount() > 0) {
      
            DTOListaProcesos dtoLProc = new DTOListaProcesos(); 
            ArrayList lista = new ArrayList(); 
            for (int row = 0; row < respuesta.getRowCount(); row++) {
    
               DTOProceso dtoProc = new DTOProceso();
               //inc.: 7275, resulta. 
               dtoProc.setBusinessID(( respuesta.getValueAt(row, "VAL_CLAS_EJEC")).toString() );
               dtoProc.setCodProceso(( respuesta.getValueAt(row, "COD_PROC")).toString() );
               dtoProc.setOidProceso( new Long(( (BigDecimal)respuesta.getValueAt(row, "OID_PROC")).toString()) );
               dtoProc.setOidSubTipoPosicion(respuesta.getValueAt(row, "STPO_OID_SUBT_POSI")==null ? null : new Long(( (BigDecimal)respuesta.getValueAt(row, "STPO_OID_SUBT_POSI")).toString()));  
               dtoProc.setOidTipoPosicion(respuesta.getValueAt(row, "TPOS_OID_TIPO_POSI")==null ? null : new Long(((BigDecimal)respuesta.getValueAt(row, "TPOS_OID_TIPO_POSI")).toString()));
               dtoProc.setSecuencia(new Integer(( (BigDecimal)respuesta.getValueAt(row, "COD_SECU")).toString()) );
               
    //           dtoProc.setOidSubTipoPosicion(new Long(( (BigDecimal)respuesta.getValueAt(row, "STPO_OID_SUBT_POSI")).toString()) );
    //           dtoProc.setOidTipoPosicion(new Long(( (BigDecimal)respuesta.getValueAt(row, "TPOS_OID_TIPO_POSI")).toString()) );
    
               lista.add(dtoProc);

            }
    
            dtoLProc.setListaProcesos(lista);
            UtilidadesLog.info("DAOGruposProcesos.obtenerGrupoProcesosReverso(Long oidGrupoProceso, Long oidTipoSolPais): Salida ");
            return dtoLProc; 

      } else{
        UtilidadesLog.info("DAOGruposProcesos.obtenerGrupoProcesosReverso(Long oidGrupoProceso, Long oidTipoSolPais): Salida ");
        return new DTOListaProcesos(); 
      }
      
    } catch (Exception e) {
        UtilidadesLog.error("Exception: ",e);
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    
  }

  public Long obtenerUltimoProcesoGP(Long oidGrupoProceso, Long oidTipoSoliciutd) throws MareException {
    UtilidadesLog.info("DAOGruposProcesos.obtenerUltimoProcesoGP(Long oidGrupoProceso, Long oidTipoSoliciutd): Entrada ");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    RecordSet respuesta;

    if ((oidGrupoProceso == null) || (oidTipoSoliciutd == null)){
        UtilidadesLog.info("DAOGruposProcesos.obtenerUltimoProcesoGP(Long oidGrupoProceso, Long oidTipoSoliciutd): Salida ");
      return null;
    }
    
    try {

        query.append("SELECT PROC_OID_PROC FROM");
        query.append(" (SELECT S.PROC_OID_PROC FROM PED_SECUE_PROCE S");
        //query.append(" where S.GRPR_OID_GRUP_PROC = '" + oidGrupoProceso.longValue() + "'");
        //query.append(" AND S.TSPA_OID_TIPO_SOLI_PAIS = '" + oidTipoSoliciutd.longValue() + "'");
        query.append(" where S.GRPR_OID_GRUP_PROC = " + oidGrupoProceso.longValue());
        query.append(" AND S.TSPA_OID_TIPO_SOLI_PAIS = " + oidTipoSoliciutd.longValue());
        query.append(" order by cod_secu desc)");
        query.append(" WHERE ROWNUM = 1");

        respuesta = bs.dbService.executeStaticQuery(query.toString());
    }catch (Exception e) { 
        UtilidadesLog.error("Exception: ",e);
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
 
    if (respuesta.getRowCount() > 0) {
        UtilidadesLog.info("DAOGruposProcesos.obtenerUltimoProcesoGP(Long oidGrupoProceso, Long oidTipoSoliciutd): Salida ");
        return new Long( ((BigDecimal)respuesta.getValueAt(0,0)).intValue() );
    } else {
        return new Long(1);
        /*throw new MareException(null, null,
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, 
            "", ErroresNegocio.PED_021));      */
    }

  }

	private BelcorpService getBelcorpService() throws MareException{
        UtilidadesLog.info("DAOGruposProcesos.getBelcorpService(): Entrada ");
        try {
            BelcorpService bs = BelcorpService.getInstance();
            UtilidadesLog.info("DAOGruposProcesos.getBelcorpService(): Salida ");
			return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }		
	}

}