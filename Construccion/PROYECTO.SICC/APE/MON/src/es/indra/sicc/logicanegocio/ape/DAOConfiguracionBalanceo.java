/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.sicc.dtos.ape.DTOMantenerConfiguracionBalanceo;
import es.indra.sicc.entidades.ape.LineaArmadoLocal;
import es.indra.sicc.entidades.ape.LineaArmadoLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class DAOConfiguracionBalanceo {


    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoConfiguracion
     * @author dmorello
     * @since 09-01-2007
     */
    public void guardarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConfiguracion) throws MareException {
        UtilidadesLog.info("DAOConfiguracionBalanceo.guardarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConfiguracion): Entrada");
    
        UtilidadesLog.debug("dtoConfiguracion: " + dtoConfiguracion);
        try {
            LineaArmadoLocalHome home = new LineaArmadoLocalHome();
            LineaArmadoLocal lineaArmado = home.findByPrimaryKey(dtoConfiguracion.getOidLineaArmado());
            UtilidadesLog.debug("Encontre la linea de armado: " + lineaArmado);
            
            // dmorello, 27/09/2007 - A partir de error reportado via mail
            if (dtoConfiguracion.getCasoUso().equals("insertar")
                    && lineaArmado.getPorcentajeVariacionEstimado() != null
                    && lineaArmado.getFuncionDistribucion() != null) {
                String error = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
                throw new MareException("", UtilidadesError.armarCodigoError(error));
            }
            // Fin dmorello 27/09/2007
                        
            lineaArmado.setPorcentajeVariacionEstimado(dtoConfiguracion.getPorcentajeVariacionEstimado());
            lineaArmado.setFuncionDistribucion(dtoConfiguracion.getOidFuncionDistribucion());
            
            try {
                home.merge(lineaArmado);
            } catch (PersistenceException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
        } catch (NoResultException e) {
            UtilidadesLog.error("DAOConfiguracionBalanceo.guardarConfiguracionBalanceo: NoResultException, "
                                    + "no existe LineaArmado = " + dtoConfiguracion.getOidLineaArmado(),
                                e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error("DAOConfiguracionBalanceo.guardarConfiguracionBalanceo: PersistenceException, "
                                    + "no existe LineaArmado = " + dtoConfiguracion.getOidLineaArmado(),
                                e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("DAOConfiguracionBalanceo.guardarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConfiguracion): Entrada");
    }
  
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con funciones de distribucion
     * @param dtoE DTOBelcorp con pais e idioma del usuario
     * @author dmorello
     * @since 08-01-2007
     */
    public DTOSalida obtenerFuncionDistribucion(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOConfiguracionBalanceo.obtenerFuncionDistribucion(DTOBelcorp dtoE): Entrada");
    
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT fd.oid_func_dist, gen.val_i18n ");
        //Agregado por cvalenzu 29/1/2007 - Para el caso de uso
        //Consultar funcion de distribucion se necesitaban 2 columnas mas
        query.append(" ,fd.COD_FUNC_DIST, fd.VAL_PROG ");
        //FIN - Agregado por cvalenzu
        query.append(" FROM ape_funci_distr fd, v_gen_i18n_sicc gen ");
        query.append(" WHERE fd.oid_func_dist = gen.val_oid ");
        query.append(" AND gen.attr_enti = 'APE_FUNCI_DISTR' ");
        query.append(" AND gen.idio_oid_idio = ").append(dtoE.getOidIdioma());
        query.append(" ORDER BY val_i18n ASC ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error("Exception en DAOConfiguracionBalanceo.obtenerFuncionDistribucion: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOConfiguracionBalanceo.obtenerFuncionDistribucion(DTOBelcorp dtoE): Salida");
        return dtoSalida;
    }
    
    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con la configuracion de balanceo obtenida
     * @param dtoConsulta
     * @author dmorello
     * @since 09-01-2007
     */
    public DTOSalida consultarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConsulta) throws MareException {
        UtilidadesLog.info("DAOConfiguracionBalanceo.consultarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConsulta): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        
        /* dmorello, 12/01/2007: La siguiente query es paginada */
        /* dmorello, 17/01/2007: Se modifica para que quede ordenada por los campos de descripciones */
        query.append(" SELECT ROWNUM AS OID, datos.* FROM ( ");
        //query.append("SELECT config.oid_conf_cent_dist AS oid, ");
        query.append("SELECT ");
        query.append("                (SELECT val_i18n ");
        query.append("                   FROM v_gen_i18n_sicc ");
        query.append("                  WHERE attr_enti = 'APP_CONFI_CENTR_DISTR' ");
        query.append("                    AND idio_oid_idio = ").append(dtoConsulta.getOidIdioma());
        query.append("                    AND val_oid = config.oid_conf_cent_dist) desc_conf_cent_dist, ");
        query.append("                (SELECT val_i18n ");
        query.append("                   FROM v_gen_i18n_sicc ");
        query.append("                  WHERE attr_enti = 'APE_LINEA_ARMAD' ");
        query.append("                    AND idio_oid_idio = ").append(dtoConsulta.getOidIdioma());
        query.append("                    AND val_oid = linea.oid_line_arma) desc_line_arma, ");
        query.append("                linea.num_porc_vari_esti, ");
        query.append("                 (SELECT val_i18n ");
        query.append("                    FROM v_gen_i18n_sicc ");
        query.append("                   WHERE attr_enti = 'APE_FUNCI_DISTR' ");
        query.append("                     AND idio_oid_idio = ").append(dtoConsulta.getOidIdioma());
        query.append("                     AND val_oid = funcion.oid_func_dist) desc_func_dist, ");
        query.append("                config.oid_conf_cent_dist, ");
        query.append("                linea.oid_line_arma, ");
        query.append("                funcion.oid_func_dist ");
        query.append("           FROM ape_linea_armad linea, ");
        query.append("                ape_funci_distr funcion, ");
        query.append("                app_confi_centr_distr config ");
        query.append("          WHERE funcion.oid_func_dist (+) = linea.fndi_oid_func_dist ");
        query.append("            AND config.oid_conf_cent_dist = linea.ccdi_oid_conf_cent_dist ");
        query.append("            AND config.pais_oid_pais =  ");
        query.append(dtoConsulta.getOidPais());
        if (dtoConsulta.getOidLineaArmado() != null) {
            query.append("        AND linea.oid_line_arma = ");
            query.append(dtoConsulta.getOidLineaArmado());
        }
        if (dtoConsulta.getOidCentroDistribucion() != null) {
            query.append("        AND config.oid_conf_cent_dist = ");
            query.append(dtoConsulta.getOidCentroDistribucion());
        }
        query.append("         ORDER BY desc_conf_cent_dist, desc_line_arma, desc_func_dist ");
        query.append(" ) datos ");
        
        String queryPaginada = UtilidadesPaginacion.armarQueryPaginacionEspecial(query.toString(), dtoConsulta);

        try {
          rs = bs.dbService.executeStaticQuery(queryPaginada);
        } catch (Exception e) {
          String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("DAOConfiguracionBalanceo.consultarConfiguracionBalanceo: Exception",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (rs == null || rs.esVacio()) {
            UtilidadesLog.error("DAOConfiguracionBalanceo.consultarConfiguracionBalanceo: la query no trajo resultados.");
            String codError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(codError));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOConfiguracionBalanceo.consultarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConsulta): Salida");
        return dtoSalida;
    }
    
    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe DTOOIDs con OIDs de lineas armado de las cuales quitar la config de balanceo
     * @author dmorello
     * @since 09-01-2007
     */
    public void eliminarConfiguracionBalanceo(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("DAOConfiguracionBalanceo.eliminarConfiguracionBalanceo(DTOOIDs dtoe): Entrada");
        
        LineaArmadoLocalHome home = new LineaArmadoLocalHome();
        Long[] oids = dtoe.getOids();
        UtilidadesLog.debug("Se eliminara la configuracion de " + oids.length + " lineas de armado");
        
        try {
            for (int i = 0; i < oids.length; i++) {
                UtilidadesLog.debug("Intento encontrar registro con OID: " + oids[i]);
                LineaArmadoLocal lineaArmado = home.findByPrimaryKey(oids[i]);
                UtilidadesLog.debug("Lo encontre! Borro porcentajeVariacionEstimado y oidFuncionDistribucion");
                lineaArmado.setPorcentajeVariacionEstimado(null);
                lineaArmado.setFuncionDistribucion(null);
                
                try {
                    home.merge(lineaArmado);
                } catch (PersistenceException e) {
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        } catch (NoResultException e) {
            UtilidadesLog.error("DAOConfiguracionBalanceo.eliminarConfiguracionBalanceo: FinderException", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error("DAOConfiguracionBalanceo.eliminarConfiguracionBalanceo: FinderException", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOConfiguracionBalanceo.eliminarConfiguracionBalanceo(DTOOIDs dtoe): Salida");
    }

}