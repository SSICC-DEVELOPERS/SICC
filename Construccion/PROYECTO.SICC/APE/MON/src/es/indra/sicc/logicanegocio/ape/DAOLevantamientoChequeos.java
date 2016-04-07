package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTOChequeos;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;

public class DAOLevantamientoChequeos  {
    public DAOLevantamientoChequeos() {
    }
    /*
            Autor: Hugo Mansi
        Fecha: 23/05/2007
        
        Descripción:
        Recuperamos todas las listas de picado filtrando por los parámetros de la pantalla.
        
        Implementación:
        
        Realizar una consulta JDBC en la entidad ListaPicadoCabecera cruzando con SolicitudCabecera, Etiquetas y en donde:
        
        ListaPicadoCabecera.indicadorChequeo = ConstantesPED.OID_REVISION_AMBAS o ConstantesPED.OID_REVISION_LINEA
        
        Si( dtoE.nroConsolidado != null ){
        SolicitudCabecera.numeroSolicitud = dtoE.nroConsolidado
        SolicitudCabecera.pais = dtoE.pais
        SolicitudCabecera.oid = ListaPicadoCabecera.solicitudCabecera
        }
        
        Si( dtoe.oidRegion != null ){
        ListaPicadoCabecera.region.oid = dtoe.oidRegion
        }
        
        Si( dtoe.oidZona != null ){
        ListaPicadoCabecera.zona.oid = dtoe.oidZona
        }
        
        Si( dtoe.oidSeccion != null ){
        ListaPicadoCabecera.seccion.oid = dtoe.oidSeccion
        }
        
        --de los siguietnes flags más de uno puede venir activo, se debe hacer un OR entre las opciones
        Si( dtoe.reclamo ){
        ListaPicadoCabecera.origenChequeo = ConstantesAPE.CHEQUEO_EVALUACION_RECLAMOS
        }
        
        Si( dtoe.pedido ){
        ListaPicadoCabecera.origenChequeo = ConstantesAPE.CHEQUEO_PRIMER_PEDIDO
        }
        
        Si( dtoe.manual ){
        ListaPicadoCabecera.origenChequeo = ConstantesAPE.CHEQUEO_CAPTURA_MANUAL
        }
        
        Recuperar:
        
        ListaPicadoCabecera.oid oidListaPicado
        ListaPicadoCabecera.indicadorChequeo.oid indicadorChequeo
        - (
        Acceder a APE:Etiquetas
        Filtrando por Etiqueta.listaPicadoCAbecera.oid = ListaPicadoCabecera.oid
        Obtener Etiqueta.estadoPedido.oid teniendo en cuenta que se debe obtener el EstadoPedido de menor numeroOrden
        ) estadoPedido */
   /**
    * @autor Noziglia C.
    * @throws MareException
    * @param 
    * @return 
    * @documentation 
    * 
    * @date
    */
    public DTOSalida recuperarListaPicado(DTOChequeos dtoE) throws MareException {
        UtilidadesLog.info("DAOLevantamientoChequeos.recuperarListaPicado(DTOChequeos dtoE): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        DTOSalida dtoS = new DTOSalida();
        /* OIDLISTAPICADO ORIGCHEQ ESTADO   */
        
        
        query.append(" SELECT lpc.oid_list_pica_cabe, lpc.ind_orig_cheq, ");
        
        query.append("  (SELECT estp_oid_esta_pedi ");
        query.append("     FROM (SELECT   e.estp_oid_esta_pedi, MIN (ep.num_orde), e.LPCA_OID_LIST_PICA_CABE ");
        query.append("             FROM ape_etiqu e, ape_estad_pedid ep ");
        query.append("            WHERE e.estp_oid_esta_pedi = ep.oid_esta_pedi ");
        query.append("         GROUP BY e.estp_oid_esta_pedi) ");
		query.append(" 		where lpca_oid_list_pica_cabe = lpc.oid_list_pica_cabe) estado,  ");
        query.append(" 		lpc.inre_oid_indi_revi  ");
        query.append("   FROM ape_lista_picad_cabec lpc ");
        if(dtoE.getNroConsolidado()!=null){
            query.append("        , ped_solic_cabec psc ");
        }
        query.append(" WHERE (lpc.inre_oid_indi_revi = "+ ConstantesPED.OID_REVISION_AMBAS);
        query.append("    OR lpc.inre_oid_indi_revi = "+ ConstantesPED.OID_REVISION_LINEA +") ");
        if(dtoE.getNroConsolidado()!=null){
            query.append("   AND psc.VAL_NUME_SOLI = "+ dtoE.getNroConsolidado());
            query.append("   AND lpc.soca_oid_soli_cabe = psc.oid_soli_cabe");
            query.append("   AND psc.PAIS_OID_PAIS = "+dtoE.getOidPais());
        }
       
       if(dtoE.getOidRegion()!=null ){
            query.append(" AND lpc.zorg_oid_regi = "+dtoE.getOidRegion() );
       }
       if(dtoE.getOidZona()!=null ){
            query.append(" AND lpc.zzon_oid_zona = "+dtoE.getOidZona() );
       }
       if(dtoE.getOidSeccion()!=null ){
            query.append(" AND lpc.zscc_oid_secc = "+dtoE.getOidSeccion() );
       }
       if(dtoE.getReclamo().booleanValue()||dtoE.getPedido().booleanValue()||dtoE.getManual().booleanValue()){
            query.append(" AND ( ");
            if(dtoE.getReclamo().booleanValue()){
                query.append(" lpc.ind_orig_cheq = '"+ConstantesAPE.CHEQUEO_EVALUACION_RECLAMOS+"'");
                if(dtoE.getManual().booleanValue()||dtoE.getPedido().booleanValue()){
                    query.append(" OR ");
                }
            }
            if(dtoE.getManual().booleanValue()){
                query.append(" lpc.ind_orig_cheq = '"+ConstantesAPE.CHEQUEO_CAPTURA_MANUAL+"'" );
                if(dtoE.getPedido().booleanValue()){
                    query.append(" OR ");
                }
            }
            if(dtoE.getPedido().booleanValue()){
                query.append(" lpc.ind_orig_cheq = '"+ConstantesAPE.CHEQUEO_PRIMER_PEDIDO+"'" );
            }
            query.append(" ) ");
       }
       
            
 
       

        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        if(rs.esVacio()){
         throw new MareException("",
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOLevantamientoChequeos.recuperarListaPicado(DTOChequeos dtoE): Salida");
        return dtoS;
    }
 /**
  * @autor Noziglia C.
  * @throws MareException
  * @param 
  * @return 
  * @documentation 
  * 
  * @date
  */
    public void actualizarEstado(ArrayList listasActualizarEstado) throws MareException {
        UtilidadesLog.info("DAOLevantamientoChequeos.actualizarEstado(DTOOIDs listasActualizarEstado): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        if(listasActualizarEstado!=null && listasActualizarEstado.size() > 0){
            query.append(" UPDATE ape_etiqu ");
            query.append(" SET estp_oid_esta_pedi = "+ConstantesAPE.OID_ESTADO_PEDIDO_LEVANTAMIENTO);
            query.append(" WHERE lpca_oid_list_pica_cabe IN ( "); 
            for(int a=0; a < listasActualizarEstado.size();a++){
                query.append(" "+listasActualizarEstado.get(a)+",");
            }
            query.deleteCharAt(query.length()-1);
            query.append(" ) ");
        try {
            bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        }
        UtilidadesLog.info("DAOLevantamientoChequeos.actualizarEstado(DTOOIDs listasActualizarEstado): Salida");
    }
/**
 * @autor Noziglia C.
 * @throws MareException
 * @param 
 * @return 
 * @documentation 
 * 
 * @date
 */
    public void actualizarChequeo (ArrayList listasActualizaChequeo) throws MareException {
        UtilidadesLog.info("DAOLevantamientoChequeos.actualizarChequeo (DTOOIDs listasActualizaChequeo): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        if(listasActualizaChequeo!=null && listasActualizaChequeo.size() > 0){
                query.append(" UPDATE ape_lista_picad_cabec ");
                query.append(" SET INRE_OID_INDI_REVI = "+ConstantesPED.OID_REVISION_CAMPO);
                query.append(" WHERE OID_LIST_PICA_CABE IN ( "); 
                for(int a=0; a < listasActualizaChequeo.size();a++){
                    query.append(" "+listasActualizaChequeo.get(a)+",");
                }
                query.deleteCharAt(query.length()-1);
                query.append(" ) ");
            try {
                bs.dbService.executeUpdate(query.toString());
            } catch (Exception e) {
                String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
        }
        UtilidadesLog.info("DAOLevantamientoChequeos.actualizarChequeo (DTOOIDs listasActualizaChequeo): Salida");
    }
 /**
  * @autor Noziglia C.
  * @throws MareException
  * @param 
  * @return 
  * @documentation 
  * 
  * @date
  */
  public DTOSalida obtenerDatosErrores (ArrayList listasErrores) throws MareException{
      UtilidadesLog.info("DAOLevantamientoChequeos.obtenerDatosErrores (DTOOIDs listasErrores): Entrada");
            
        DTOSalida dtoS = new DTOSalida();
        
        if(listasErrores !=null && listasErrores.size() > 0){
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            RecordSet rs = null;
            StringBuffer query = new StringBuffer();
            
            query.append(" SELECT SYSDATE fecha, psc.val_nume_soli numsoli, ");
            query.append("        et.num_caja numcaja ");
            query.append("   FROM ape_lista_picad_cabec lpc, ape_etiqu et, ped_solic_cabec psc ");
            query.append("  WHERE lpc.soca_oid_soli_cabe = psc.oid_soli_cabe ");
            query.append("    AND et.soca_oid_soli_cabe(+) = psc.oid_soli_cabe ");
            query.append("    AND (et.estp_oid_esta_pedi NOT IN ("+ ConstantesAPE.OID_ESTADO_EMBALADO);
            query.append(          ", " + ConstantesAPE.OID_ESTADO_PEDIDO_INDUCIDO +") ");
            query.append(          " OR et.estp_oid_esta_pedi IS NULL)");
            query.append("    AND lpc.oid_list_pica_cabe IN (  ");
            for(int a=0; a < listasErrores.size();a++){
                query.append(" "+listasErrores.get(a)+",");
            }
            query.deleteCharAt(query.length()-1);
            query.append(" ) ");
            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
            if(rs.esVacio()){
                throw new MareException("",
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOLevantamientoChequeos.obtenerDatosErrores (DTOOIDs listasErrores): Salida");
        return dtoS;
        }
            
      UtilidadesLog.info("DAOLevantamientoChequeos.obtenerDatosErrores (DTOOIDs listasErrores): Salida");
      return null;
  }
}