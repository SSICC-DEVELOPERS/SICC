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
 * Autor Marta Aurora Montiel
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

//import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.inc.DTOPrecioReclamo;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONSoporteExternoBean
        implements SessionBean {
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    /* Autor Marta Aurora Montiel
    * 23/03/05
    * Incidencia BELC300014887
    **/
    public DTOPrecioReclamo obtenerPrecioReclamo(DTOPrecioReclamo dto)
            throws MareException {
        UtilidadesLog.info("MONSoporteExternoBean.obtenerPrecioReclamo(DTOPrecioReclamo dto):Entrada");
        /* * dtoPrecio = llamar al método obtenerPrecioReclamo del DAOSoporteExterno
          Devolver el dtoPrecio.
         * */
        DAOSoporteExterno dao = new DAOSoporteExterno();
        DTOPrecioReclamo dts = dao.obtenerPrecioReclamo(dto);
        UtilidadesLog.info("MONSoporteExternoBean.obtenerPrecioReclamo(DTOPrecioReclamo dto):Salida");

        return dts;
    }
}
