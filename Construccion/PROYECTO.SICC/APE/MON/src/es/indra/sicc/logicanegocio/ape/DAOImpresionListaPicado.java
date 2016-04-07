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
 *
 */

package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOListaPicado;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

public class DAOImpresionListaPicado  {

  /**
   * Autor: sapaza
   * Fecha: 12-03-2007
   * Descripcion: Recupera la lista de picado correspondiente al consolidado
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param oidConsolidado
   */
    public DTOListaPicado obtenerListaPicadoPorConsolidado (Long oidConsolidado) throws MareException  {
        UtilidadesLog.info("DAOImpresionListaPicado.obtenerListaPicadoPorConsolidado(Long oidConsolidado): Entrada");
          
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("		SELECT lis.oid_list_pica_cabe, lis.ccdi_oid_conf_cent_dist, ");
        query.append("		lis.liar_oid_line_arma, lis.perd_oid_peri ");
        query.append("		FROM ape_lista_picad_cabec lis ");
        query.append("		WHERE lis.SOCA_OID_SOLI_CABE =  " + oidConsolidado.toString());
        query.append("		AND rownum < 2 ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }

        DTOListaPicado dtoLP = null;        
        if (rs.esVacio()) {
            UtilidadesLog.error("****obtenerListaPicadoPorConsolidado (" + oidConsolidado.toString() + "): no hay datos ");				
        }
        else {
            UtilidadesLog.debug("rs: " + rs);
            dtoLP = new DTOListaPicado(); 
            dtoLP.setOidListaPicado(new Long((((BigDecimal)rs.getValueAt(0,"oid_list_pica_cabe"))).longValue()));
            dtoLP.setOidCentroDistribucion(new Long((((BigDecimal)rs.getValueAt(0,"ccdi_oid_conf_cent_dist"))).longValue()));        
            dtoLP.setOidLineaArmado(new Long((((BigDecimal)rs.getValueAt(0,"liar_oid_line_arma"))).longValue()));
            dtoLP.setOidPeriodo(new Long((((BigDecimal)rs.getValueAt(0,"perd_oid_peri"))).longValue()));
        }
        
        UtilidadesLog.info("DAOImpresionListaPicado.obtenerListaPicadoPorConsolidado(Long oidConsolidado): Salida");
        
        return dtoLP;
    }

  /**
   * Autor: sapaza
   * Fecha: 12-03-2007
   * Descripcion: Actualiza la entidad ListadoPicadoCabecera, el flag indicadorImpresion en TRUE 
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoE
   */
    public void actualizarFlagImpreso (DTOOIDs dtoE) throws MareException {
        UtilidadesLog.info("DAOImpresionListaPicado.actualizarFlagImpreso(DTOOIDs dtoE): Entrada");
    
        Long[] oids = dtoE.getOids();
        StringBuffer update = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        update.append(" UPDATE APE_LISTA_PICAD_CABEC ");
        update.append(" SET IND_IMPR = '").append(ConstantesAPE.IMPRESION_SI.toString()).append("'");
        update.append(" WHERE OID_LIST_PICA_CABE IN (");
        for (int i = 0; i < oids.length; ) {
            update.append(oids[i]);
            if (++i < oids.length) {
                update.append(',');
            } else {
                update.append(')');
            }
        }
        try {
            bs.dbService.executeUpdate(update.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionListaPicado.actualizarFlagImpreso(DTOOIDs dtoE): Salida");
    }

}