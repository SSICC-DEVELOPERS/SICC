package es.indra.sicc.logicanegocio.cob;
import es.indra.sicc.dtos.cob.DTOBuscarAccionesCobranza;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

public class DAOAccionesCobranza 
{
  public DAOAccionesCobranza()
  {
  }

   /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       07/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOSalida buscarAccionesCobranza(DTOBuscarAccionesCobranza dto) throws MareException {
    UtilidadesLog.info("DAOAccionesCobranza.buscarAccionesCobranza(DTOBuscarAccionesCobranza dto): Entrada");
  
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT acc.OID_ACCI_COBR OID, acc.COD_ACCI_COBR, ");
            buf.append(" acc.VAL_DESC, i18n.VAL_I18N desc_subacc  ");
            buf.append(" FROM COB_ACCIO_COBRA acc, COB_SUBTI_ACCIO subacc, ");
            buf.append(" V_GEN_I18N_SICC i18n  ");
            buf.append(" WHERE acc.SACC_OID_SUBT_ACCI = subacc.OID_SUBT_ACCI ");
            buf.append(" AND acc.pais_oid_pais = " + dto.getOidPais());
            buf.append(" AND i18n.VAL_OID = subacc.OID_SUBT_ACCI ");            
            buf.append(" AND i18n.ATTR_ENTI = 'COB_SUBTI_ACCIO' ");
            buf.append(" AND i18n.ATTR_NUM_ATRI = 1 ");
            buf.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());

            if(dto.getPaginacion().booleanValue()) {
              respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(buf.toString(), dto));
            } else if(!dto.getPaginacion().booleanValue()) {
              respuesta = bs.dbService.executeStaticQuery(buf.toString());
            }
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if( respuesta.esVacio() ){
          UtilidadesLog.debug("************** No hay registros, se lanza la MareException");          
          throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }   

        UtilidadesLog.info("DAOAccionesCobranza.buscarAccionesCobranza(DTOBuscarAccionesCobranza dto): Salida");

        return new DTOSalida(respuesta);
  }

  public DTOSalida obtenerAccionesCobranza (DTOBelcorp dto) throws MareException {
  
    UtilidadesLog.info("DAOAccionesCobranza.buscarAccionesCobranza(DTOBuscarAccionesCobranza dto): Entrada");
    
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {

            buf.append("  SELECT accion.oid_acci_cobr, accion.val_desc   ");
            buf.append("    FROM COB_ACCIO_COBRA accion   ");
            buf.append("   WHERE accion.pais_oid_pais = " + dto.getOidPais());
            
            respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(buf.toString());
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOAccionesCobranza.buscarAccionesCobranza(DTOBuscarAccionesCobranza dto): Salida");

        return new DTOSalida(respuesta);
  }


}