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
package es.indra.sicc.logicanegocio.pre;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.pre.DTOAgregarProductoSolicitud;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

/**
* MON encargado de cuadrar ofertas compuestas fijas.
*
* @version 3.6 - 12 Sep 2005
* @author Emilio Noziglia
*/
public class MONCuadreCompuestaFijaBean implements SessionBean  {

    SessionContext ctx;  
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx=ctx;
    }

   /**
    *
    *@autor jpbosnja
    */
    public DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, DTOPosicionSolicitud dtop, Long tipoPosicion, Long subtipoPosicion) throws MareException {
        UtilidadesLog.info("MONCuadreCompuestaFijaBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, DTOPosicionSolicitud dtop, Long tipoPosicion, Long subtipoPosicion): Entrada");
        try{
            //UtilidadesLog.debug("----------------------------------------------------------------------");
            //UtilidadesLog.debug("-------------------ENTRE DE CUADRE COMPUESTA FIJA---------------------");
            //UtilidadesLog.debug("----------------------------------------------------------------------");
            //UtilidadesLog.debug("Entrada: MONCuadreCompuestaFija.cuadrarOferta"); 
            //UtilidadesLog.debug("tipoPosicion=" + tipoPosicion); 
            //UtilidadesLog.debug("subtipoPosicion=" + subtipoPosicion); 
            //DTOSalida dtoS = getMONOfertaHome().create().obtenerProductosOferta(dtop.getOidOferta());
            DTOSalida dtoS = getMONOfertaLocalHome().create().obtenerProductosOferta(dtop.getOidOferta());
            RecordSet r = dtoS.getResultado();
            for (int i=0;i<r.getRowCount();i++){
                String codigoventa = (String)r.getValueAt(i,0);
                if (!dtop.getCodigoVenta().equals(codigoventa)){
                    DTOAgregarProductoSolicitud dtoAPS = new DTOAgregarProductoSolicitud();
                    dtoAPS.setOidTipoPosicion(tipoPosicion);
                    dtoAPS.setOidSubtipoPosicion(subtipoPosicion);
                    dtoAPS.setCodigoVenta(codigoventa);
                    dtoAPS.setUnidadesPorAtender(dtop.getUnidadesPorAtender());
                    
                    //dtoe = getMONCuadreProductosHome().create().agregarProductos(dtoe, dtoAPS, null);
                    dtoe = getMONCuadreProductosLocalHome().create().agregarProductos(dtoe, dtoAPS, null);
                }
            }
        }catch (NamingException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }        
        /*UtilidadesLog.debug("----------------------------------------------------------------------");
        UtilidadesLog.debug("-------------------SALI DE CUADRE COMPUESTA FIJA----------------------");
        UtilidadesLog.debug("----------------------------------------------------------------------");*/
        UtilidadesLog.info("MONCuadreCompuestaFijaBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, DTOPosicionSolicitud dtop, Long tipoPosicion, Long subtipoPosicion): Salida");
        return dtoe;
    }

  private MONOfertaHome getMONOfertaHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONOferta"), MONOfertaHome.class);
  }

  private MONCuadreProductosHome getMONCuadreProductosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONCuadreProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreProductos"), MONCuadreProductosHome.class);
  }

    private MONOfertaLocalHome getMONOfertaLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONOfertaLocalHome)context.lookup("java:comp/env/ejb/local/MONOferta");
    }

    private MONCuadreProductosLocalHome getMONCuadreProductosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCuadreProductosLocalHome)context.lookup("java:comp/env/ejb/local/MONCuadreProductos");
    }
}