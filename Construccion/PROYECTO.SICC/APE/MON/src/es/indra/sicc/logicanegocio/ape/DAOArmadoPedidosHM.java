/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

public class DAOArmadoPedidosHM  {
    /**
     * Obtiene las entidades ListaPicadoCabezera que coincidan con los parámetros de la búsqueda 
     * @author hhernandez
     * @since 26-02-2007
     */
    public DTOSalida visualizarListaPicado(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("DAOArmadoPedidosHM.visualizarListaPicado(DTOOID dtoE): Entrada");
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("		SELECT	LPCabecera.OID_LIST_PICA_CABE AS oid, LPCabecera.PERD_OID_PERI AS periodo, ");
        query.append("				LPCabecera.CCDI_OID_CONF_CENT_DIST AS confCentDistribucion, ");
        query.append("				LPCabecera.COD_LIST_PICA AS codigoListaPicado ,");
        query.append("				ConfCenDistribucion.PAIS_OID_PAIS AS pais, ConfCenDistribucion.COD_CENT_DIST AS codCentroDist ");
        query.append("		FROM APE_LISTA_PICAD_CABEC LPCabecera, APP_CONFI_CENTR_DISTR ConfCenDistribucion");
        query.append("		WHERE");
        query.append("    LPCabecera.CCDI_OID_CONF_CENT_DIST = ConfCenDistribucion.OID_CONF_CENT_DIST");
                
        query.append("		AND LPCabecera.SOCA_OID_SOLI_CABE =  ");
        query.append(dtoE.getOid());
        
        //String sql = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dtoE);
        RecordSet rs = null;
        try {
            //rs = bs.dbService.executeStaticQuery(sql);
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        UtilidadesLog.debug("rs: " + rs);
        if (rs.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(error));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOArmadoPedidosHM.visualizarListaPicado(DTOOID dtoE): Salida");
        return dtoSalida;
    }
    
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE
     * @author Rafael Romero Vilcherrez
     * @date 27-02-2007
     */
    public void revertirArmadoPedidos(DTOOID dtoE) throws MareException{
        UtilidadesLog.debug("DAOArmadoPedidosHM.revertirArmadoPedidos(DTOOID dtoE): Entrada");
        
        if(dtoE.getOid()!=null){
            UtilidadesLog.debug("DAOArmadoPedidosHM.revertirArmadoPedidos(DTOOID dtoE): PED_SOLI_CAB(oid):["+dtoE.getOid()+"]");
            StringBuffer cmdSql1 = new StringBuffer();
            StringBuffer cmdSql2 = new StringBuffer();
            StringBuffer cmdSql3 = new StringBuffer();
            
            cmdSql1.append("DELETE FROM ape_etiqu ");
            cmdSql1.append("      WHERE soca_oid_soli_cabe = "+dtoE.getOid()+" ");
    
            cmdSql2.append("DELETE FROM ape_lista_picad_detal a ");
            cmdSql2.append("      WHERE lpca_oid_list_pica_cabe = (SELECT DISTINCT oid_list_pica_cabe ");
            cmdSql2.append("                                                  FROM ape_lista_picad_cabec ");
            cmdSql2.append("                                                 WHERE soca_oid_soli_cabe = "+dtoE.getOid()+") ");
    
            cmdSql3.append("DELETE FROM ape_lista_picad_cabec ");
            cmdSql3.append("      WHERE soca_oid_soli_cabe = "+dtoE.getOid()+" ");

            BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
            try {
                int del1 = bs.dbService.executeUpdate(cmdSql1.toString());
                int del2 = bs.dbService.executeUpdate(cmdSql2.toString());
                int del3 = bs.dbService.executeUpdate(cmdSql3.toString());
                UtilidadesLog.debug("DAOArmadoPedidosHM.revertirArmadoPedidos(DTOOID dtoE): se han eliminado registros APE_ETIQ["+del1+"], APE_LISTA_PICAD_DETAL["+del2+"], APE_LISTA_PICAD_CABEC["+del3+"] ");
            }
            catch (Exception e) {
                UtilidadesLog.error("No se pudo eliminar los registros...",e);
                String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }

        }else{
            UtilidadesLog.error("No se enviado OID en el DTO");
        }
        
        UtilidadesLog.debug("DAOArmadoPedidosHM.revertirArmadoPedidos(DTOOID dtoE): Salida");
    }

}