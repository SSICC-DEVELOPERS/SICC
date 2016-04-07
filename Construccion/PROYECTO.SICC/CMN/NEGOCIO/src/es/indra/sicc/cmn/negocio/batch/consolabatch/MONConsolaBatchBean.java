/**
 * @author SCS - 11/02/2005DTOConsolBatch
 */
package es.indra.sicc.cmn.negocio.batch.consolabatch;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.cmn.negocio.batch.DTOConsolaBatch;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;

public class MONConsolaBatchBean implements SessionBean {
  
  private SessionContext ctx;

  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

	public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;
	}
  
  public DTOSalida obtenerProcesosConsola(DTOConsolaBatch dtoin) throws MareException {
        UtilidadesLog.info("MONConsolaBatch.obtenerProcesosConsola(): Entrada");
        UtilidadesLog.debug("el dto de entrada es: " + dtoin);
        DTOSalida retorno = new DTOSalida();
        UtilidadesLog.debug("dentro de obtener procesos consola....");
        
        UtilidadesLog.debug("los datos, necesarios, son:...........");
        UtilidadesLog.debug("idioma: "+dtoin.getOidIdioma());
        UtilidadesLog.debug("ctx.getCallerPrincipal(); "+ctx.getCallerPrincipal());
        UtilidadesLog.debug("Estatus(): "+dtoin.getEstatus());
        UtilidadesLog.debug("Usuario: " + dtoin.getUsuario());
        
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
            
        UtilidadesLog.debug("situacion: "+dtoin.getIndicadorSituacion());
        UtilidadesLog.debug("tam. pag.:"+dtoin.getTamanioPagina());
        
        try {
            StringBuffer prQuery = new StringBuffer();
            
            prQuery.append(" select * from (");
            prQuery.append(" select rownum REG, datos.* from (");
            prQuery.append(" select gpb.COD_PROC, gpb.VAL_USUA, in1.val_i18n DESCR,"); //i18n asociado a GEN_ESTAD_BATCH
            prQuery.append(" TO_char( gpb.FEC_ENCO, 'dd/MM/yyyy HH:MI:SS') as ENCO, (gpb.FEC_INIC-gpb.FEC_ENCO)*24*60*60 TIEMPO_ACTIV, ");
            prQuery.append(" TO_char( gpb.FEC_INIC, 'dd/MM/yyyy HH:MI:SS') as INIC, TO_char( gpb.FEC_FIN, 'dd/MM/yyyy HH:MI:SS') as FIN, (gpb.FEC_FIN-gpb.FEC_INIC)*24*60*60 TIEMPO_EJEC, ");
            prQuery.append(" gpb.VAL_CODI_FINA, gpb.VAL_MENS_FINA, gpb.VAL_SERV, gpb.VAL_ESTA");
            prQuery.append(" from GEN_PROCE_BATCH gpb, v_gen_i18n_sicc in1");
            prQuery.append(" WHERE");
            prQuery.append(" in1.val_oid = gpb.VAL_ESTA");
            
            prQuery.append(" and in1.attr_enti = 'GEN_ESTAD_BATCH'");   
            prQuery.append(" and in1.attr_num_atri = 1");
            prQuery.append(" and in1.idio_oid_idio = " + dtoin.getOidIdioma());
            
            if (dtoin.getUsuario()) 
              prQuery.append(" and gpb.VAL_USUA = " + ctx.getCallerPrincipal());
            if (dtoin.getEstatus()!=null) {
              prQuery.append(" and gpb.VAL_ESTA = " + dtoin.getEstatus().longValue());
            }  
            
            if (dtoin.getFechaDesde()!=null) { 
              String fechaDesde = simpledateformat.format(dtoin.getFechaDesde());
              UtilidadesLog.debug("fechaDesde, es: " + fechaDesde);
              prQuery.append(" and trunc(gpb.FEC_ENCO) >= TO_DATE( '" + fechaDesde + "', 'DD-MM-YYYY') ");
            }  
            if (dtoin.getFechaHasta()!=null) {
              String fechaHasta = simpledateformat.format(dtoin.getFechaHasta());
              UtilidadesLog.debug("fechaHasta, es: " + fechaHasta);
              prQuery.append(" and trunc(gpb.FEC_ENCO) <= TO_DATE( '" + fechaHasta + "', 'DD-MM-YYYY') ");
            }   
             
            prQuery.append(" and gpb.PRBT_COD_PROC_PADR is null");
            prQuery.append(" order by gpb.FEC_INIC desc) datos)");
            prQuery.append(" where REG > " + dtoin.getIndicadorSituacion().longValue());
            prQuery.append(" and rownum <= " + dtoin.getTamanioPagina().longValue());
            
            UtilidadesLog.debug("a punto de ejecutar consulta: " + prQuery.toString());  
            
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(prQuery.toString());
            UtilidadesLog.debug("se obtiene: " + rs);
            if (rs.getRowCount() > 0) {
              retorno.setResultado(rs);
            }else if((rs.getRowCount()<=0) || (rs == null)) {
              UtilidadesLog.debug("mare exception..........");
              throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }   

        }catch(MareException me) {
          throw me;
        }catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("voy a retornar: "+retorno);
        UtilidadesLog.info("MONConsolaBatch.obtenerProcesosConsola(): Salida");
        return retorno;
  }


  public DTOSalida obtenerSubProcesosConsola(DTOConsolaBatch dtoin) throws MareException {
        UtilidadesLog.info("MONConsolaBatch.obtenerSubProcesosConsola(): Entrada");
        DTOSalida retorno = new DTOSalida();
        UtilidadesLog.debug("dentro de obtener sub procesos consola....");
        try {
            StringBuffer prQuery = new StringBuffer();
 
            prQuery.append(" select gpb.COD_PROC, in1.val_i18n DESCR,"); //i18n asociado a GEN_ESTAD_BATCH
            prQuery.append(" TO_char( gpb.FEC_ENCO, 'dd/MM/yyyy HH:MI:SS') as ENCO, (gpb.FEC_INIC-gpb.FEC_ENCO)*24*60*60 TIEMPO_ACTIV,");
            prQuery.append(" TO_char( gpb.FEC_INIC, 'dd/MM/yyyy HH:MI:SS') as INIC, TO_char( gpb.FEC_FIN, 'dd/MM/yyyy HH:MI:SS') as FIN, (gpb.FEC_FIN-gpb.FEC_INIC)*24*60*60 TIEMPO_EJEC,"); 
            prQuery.append(" gpb.VAL_CODI_FINA, gpb.VAL_MENS_FINA, gpb.VAL_SERV, gpb.VAL_ESTA");
            prQuery.append(" from GEN_PROCE_BATCH gpb, v_gen_i18n_sicc in1 WHERE");

            prQuery.append(" in1.val_oid = gpb.VAL_ESTA");
            
            prQuery.append(" and in1.attr_enti = 'GEN_ESTAD_BATCH'");
            prQuery.append(" and in1.attr_num_atri = 1");
            prQuery.append(" and in1.idio_oid_idio = " + dtoin.getOidIdioma());            
            
            prQuery.append(" and upper(gpb.PRBT_COD_PROC_PADR) = '" + dtoin.getCodProc().toUpperCase() + "'");
            prQuery.append(" order by gpb.FEC_INIC desc");
            
            UtilidadesLog.debug("a punto de ejecutar consulta: " + prQuery.toString());  
             
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(prQuery.toString());
            
            UtilidadesLog.debug("se obtiene: " + rs);
            if (rs.getRowCount() > 0) {
              UtilidadesLog.debug("hay registros..."); 
              retorno.setResultado(rs);
            }else if((rs.getRowCount()<=0) || (rs == null)) {
              UtilidadesLog.debug("mare exception..........");
              throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }   
        }catch(MareException me) {
          throw me;
        }catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("voy a retornar: "+retorno);
        UtilidadesLog.info("MONConsolaBatch.obtenerSubProcesosConsola(): Salida");
        return retorno;
  }


  public DTOSalida obtenerEstadosProcesos(DTOBelcorp dtoin) throws MareException {
        UtilidadesLog.info("MONConsolaBatch.obtenerEstadosProcesos(): Entrada");
        DTOSalida retorno = new DTOSalida();
        UtilidadesLog.debug("dentro de obtener estados procesos....");
        try {
            StringBuffer prQuery = new StringBuffer();
            
            prQuery.append("SELECT * from ( "); 
            prQuery.append("SELECT eb.OID_ESTA_BATC OID, ");
            prQuery.append("in1.val_i18n DESCR "); 
            prQuery.append("from GEN_ESTAD_BATCH eb, ");
            prQuery.append("v_gen_i18n_sicc in1 ");
            prQuery.append("where in1.attr_enti = 'GEN_ESTAD_BATCH' ");
            prQuery.append("AND in1.val_oid = eb.OID_ESTA_BATC ");
            prQuery.append("AND in1.attr_num_atri = 1 ");
            prQuery.append("AND in1.idio_oid_idio = "  + dtoin.getOidIdioma().longValue() + ")");
            
            UtilidadesLog.debug("a punto de ejecutar consulta: " + prQuery.toString());  
             
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(prQuery.toString());
            UtilidadesLog.debug("se obtiene: " + rs);
            if (rs.getRowCount() > 0) {
              UtilidadesLog.debug("hay registros..."); 
              retorno.setResultado(rs);
            }else if((rs.getRowCount()<=0) || (rs == null)) {
              UtilidadesLog.debug("mare exception..........");
              throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  

        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("voy a retornar: "+retorno);
        UtilidadesLog.info("MONConsolaBatch.obtenerEstadosProcesos(): Salida");
        return retorno;
  }
}