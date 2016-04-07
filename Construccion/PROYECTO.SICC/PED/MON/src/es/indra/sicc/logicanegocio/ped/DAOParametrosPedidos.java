/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;

import es.indra.sicc.util.UtilidadesLog;
import java.util.Vector;

import javax.ejb.EJBException;


/**
 * Sistema:       Geodesys
 * Modulo:        Paquete Funcional 1
 * Componente:    DAOParametrosPedidos.java
 * Fecha:         
 * Observaciones: 
 *
 * @author Luciana C. Garcia Mari, Viviana Bongiovanni
 * @version 1.0
 */
public class DAOParametrosPedidos implements IParametrosPedidos {
    /**
     * Construye un DAOParametrosPedidos
     */
    public DAOParametrosPedidos() {
    }

   
    public RecordSet obtenerTasasImpuestoPorPais(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("DAOParametrosPedidos.obtenerTasasImpuestoPorPais(DTOBelcorp dto): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {

            Vector param = new Vector();

            param.addElement(dto.getOidPais());
            param.addElement(dto.getOidPais());
            param.addElement(dto.getOidPais());            
        
          /* buf.append("select a.OID_TASA_IMPU, VAL_I18N desc_imup_il8n ");            
            buf.append("from PED_TASA_IMPUE a, GEN_I18N_SICC  ");     
            buf.append("where a.PAIS_OID_PAIS = ? ");      
            buf.append("and a.OID_TASA_IMPU = VAL_OID ");
            buf.append("and ATTR_ENTI = 'PED_TASA_IMPUE' ");           
            buf.append("and ATTR_NUM_ATRI = 1 ");*/

            buf.append("SELECT   a.oid_tasa_impu, i.VAL_I18N ");
            buf.append("FROM ped_tasa_impue a, V_GEN_I18N_SICC i ");
            buf.append(" WHERE a.pais_oid_pais = " + dto.getOidPais());
            buf.append(" AND a.oid_tasa_impu = i.val_oid ");
            buf.append(" AND i.attr_enti = 'PED_TASA_IMPUE' ");
            buf.append(" AND i. attr_num_atri = 1 ");
            buf.append(" AND i.idio_oid_idio = " + dto.getOidIdioma());

         
            //respuesta = bs.dbService.executePreparedQuery(UtilidadesI18N.armarSQLPatronI18n(buf,dto.getOidIdioma(),"order by desc_imup_il8n "), param);
            respuesta = (RecordSet) getBelcorpService().dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOParametrosPedidos.obtenerTasasImpuestoPorPais(DTOBelcorp dto): Salida ");
        return respuesta;         
    }

    /**
     * Realiza una consulta y devuelve el oid y la descripción de la tabla 
     * Atributos Especiales, para el módulo indicado. 
     *
     * @param modulo - String
     *
     * @return RecordSet
     */
    public RecordSet obtenerAtributosEspecialesModulo(String modulo) throws MareException{
      
        UtilidadesLog.info("DAOParametrosPedidos.obtenerAtributosEspecialesModulo(String modulo): Entrada ");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" OID_ATRI_ESPE, DES_ATRI, VAL_FORM ");
        query.append(" FROM PED_ATRIB_ESPEC p, SEG_MODUL m ");
        query.append(" WHERE p.MODU_OID_MODU = m.OID_MODU ");
        query.append(" AND m.COD_MODU = '" + modulo + "' ");
        query.append(" ORDER BY DES_ATRI ");
        
        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener tipos de clientes", e);
        }
        UtilidadesLog.info("DAOParametrosPedidos.obtenerAtributosEspecialesModulo(String modulo): Salida ");
        return rs;
    }
    
    
    /**
	 * Autor: Hugo Andrés Mansi
	 * email: hmansi@indra.com.ar
	 * Fecha: 20/12/2004
	 * Incidencia asociada: BELC300011520
	 * Recibe: DTOOID de donde se toma el oid
	 * Devuelve: Un DTOSalida cuyo RecordSet tiene la columna: coeficiente
	 * Descripción: Obtiene el coeficiente correspondiente a un tipo de impuesto. 
	 **/
     public  DTOSalida obtenerCoeficienteImpuesto(DTOOID dto) throws MareException{
        UtilidadesLog.info("DAOParametrosPedidos.obtenerCoeficienteImpuesto(DTOOID dto): Entrada ");
       DTOSalida salida = new DTOSalida();
       StringBuffer query = new StringBuffer();
       RecordSet rs;
       query.append(" SELECT val_tasa_impu as coeficiente "); 
       query.append(" FROM  ped_tasa_impue "); 
       query.append(" WHERE oid_tasa_impu = " + dto.getOid()); 
       try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener el coeficiente", e);
        }
       salida.setResultado(rs);
        UtilidadesLog.info("DAOParametrosPedidos.obtenerCoeficienteImpuesto(DTOOID dto): Salida ");
	   return salida;
	 }//fin obtenerCoeficienteImpuesto

     private BelcorpService getBelcorpService() {
        try {
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
    }
}
