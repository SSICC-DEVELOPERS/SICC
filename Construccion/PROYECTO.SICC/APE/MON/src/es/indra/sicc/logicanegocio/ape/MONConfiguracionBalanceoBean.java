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
import es.indra.sicc.dtos.ape.DTOMantenerConfiguracionBalanceo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONConfiguracionBalanceoBean implements SessionBean {

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
  
    public void setSessionContext(SessionContext ctx)
    {
        this.ctx = ctx;
    }
  
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoConfiguracion
     * @author dmorello
     * @since 09-01-2007
     */
    public void guardarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConfiguracion) throws MareException {
        UtilidadesLog.debug("MONConfiguracionBalanceoBean.guardarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConfiguracion): Entrada");
        try {
            new DAOConfiguracionBalanceo().guardarConfiguracionBalanceo(dtoConfiguracion);
        } catch (MareException e) {
            ctx.setRollbackOnly();
            throw e;
        }
        UtilidadesLog.debug("MONConfiguracionBalanceoBean.guardarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConfiguracion): Salida");
    }
  
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     * @author dmorello
     * @since 09-01-2007
     */
    public DTOSalida obtenerFuncionDistribucion(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.debug("MONConfiguracionBalanceoBean.obtenerFuncionDistribucion(DTOBelcorp dtoe): Entrada");
        DTOSalida dtoSalida = new DAOConfiguracionBalanceo().obtenerFuncionDistribucion(dtoe);
        UtilidadesLog.debug("MONConfiguracionBalanceoBean.obtenerFuncionDistribucion(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
  
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoConsulta
     * @author dmorello
     * @since 09-01-2007
     */
    public DTOSalida consultarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConsulta) throws MareException {
        UtilidadesLog.debug("MONConfiguracionBalanceoBean.consultarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConsulta): Entrada");
        DTOSalida dtoSalida = new DAOConfiguracionBalanceo().consultarConfiguracionBalanceo(dtoConsulta);
        UtilidadesLog.debug("MONConfiguracionBalanceoBean.consultarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConsulta): Salida");
        return dtoSalida;
    }
  
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     * @author dmorello
     * @since 09-01-2007
     */
    public void eliminarConfiguracionBalanceo(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.debug("MONConfiguracionBalanceoBean.eliminarConfiguracionBalanceo(DTOOIDs dtoe): Entrada");
        try {
            new DAOConfiguracionBalanceo().eliminarConfiguracionBalanceo(dtoe);
        } catch (MareException e) {
            ctx.setRollbackOnly();
            throw e;
        }
        UtilidadesLog.debug("MONConfiguracionBalanceoBean.eliminarConfiguracionBalanceo(DTOOIDs dtoe): Salida");
    }
}