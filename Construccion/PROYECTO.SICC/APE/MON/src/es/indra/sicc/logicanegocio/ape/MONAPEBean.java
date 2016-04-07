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
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.intsys.DTOListaPicadoInduccionPTL;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

/**
 * Clase que brinda los servicios del Modulo APE hacia otros modulos de Sicc.
 */
public class MONAPEBean implements SessionBean, IAPE {
    private SessionContext ctx;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }
    
    /**
     * Metodo que se ejecuta al arrancar facturacion para forma que los pedidos a chequear 
     * sean armados en primer lugar para cada zona.
     * @author eiraola
     * @date 08/03/2007
     */
    public DTOFACConsolidado[] balancearAreaChequeo(DTOFACConsolidado[] listaConsolidados) 
            throws MareException {
        UtilidadesLog.info("MONAPE.balancearAreaChequeo(listaConsolidados): Entrada");
        
        DTOFACConsolidado[] listaReSecuenciada = listaConsolidados;
        try {
            MONBalanceoAreaChequeoHome mONBalanceoAreaChequeoHome = this.getMONBalanceoAreaChequeoHome();
            MONBalanceoAreaChequeo mONBalanceoAreaChequeo;
            
            mONBalanceoAreaChequeo = mONBalanceoAreaChequeoHome.create();
            UtilidadesLog.debug("...MONBalanceoAreaChequeo listo para utilizar");
            
            listaReSecuenciada = mONBalanceoAreaChequeo.balancearAreaChequeo(listaConsolidados);
        } catch (Exception e) {
            UtilidadesLog.error("*** ERROR al Balancear Consolidados para chequeo");
            e.printStackTrace();
            //throw new MareException("Error en APE Balanceo del area de chequeo", e);
        }
        UtilidadesLog.info("MONAPE.balancearAreaChequeo(listaConsolidados): Salida");
        return listaReSecuenciada;
    }
    
    public void imprimirEtiquetasInduccionPTL(ArrayList lstEtiquetasAImprimir) throws MareException {}
    
    public void crearListasPicadoInduccionPTL(DTOListaPicadoInduccionPTL dtoE) throws MareException {}

    /*-----------------------------------------------------------------------------------------*/
    private MONBalanceoAreaChequeoHome getMONBalanceoAreaChequeoHome() throws MareException {
        try {
            final InitialContext context = new InitialContext();
            return (MONBalanceoAreaChequeoHome)PortableRemoteObject.narrow(
                context.lookup("java:comp/env/MONBalanceoAreaChequeo"), MONBalanceoAreaChequeoHome.class);
        } catch (NamingException ne) {
            throw new MareException(ne, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            
        }
    }

}