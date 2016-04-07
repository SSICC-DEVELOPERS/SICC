package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;

import es.indra.sicc.dtos.rec.DTOConsultarCabeceraReclamo;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONInformesReclamosBean implements SessionBean 
{
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
    }

    public DTOConsultarCabeceraReclamo consultarCabeceraReclamo(DTOString dtoe) throws MareException
    {
        /* Vamos a obtener los datos de la cabecera del reclamos para el cliente dado 
         * DAOInformesReclamos dao 
         * DTOString dtoe 
         * DTOConsultarCabeceraReclamo dtoCabecera = dao.consultarCabeceraReclamo(dtoe) 
         * Devolver este dtoCabecera obtenido
         */
       
        UtilidadesLog.info("MONDigitarReclamos.consultarCabeceraReclamo(DTOString):Entrada");
        UtilidadesLog.debug("**DTOE: "+dtoe);
        DAOInformesReclamos daoInformes = new DAOInformesReclamos();
        DTOConsultarCabeceraReclamo dtoCabecera = daoInformes.consultarCabeceraReclamo(dtoe);
        UtilidadesLog.info("MONDigitarReclamos.consultarCabeceraReclamo(DTOString):Salida");
        return dtoCabecera;
    }

    public DTOSalida consultarReclamosCliente(DTOOIDPaginado dtoe) throws MareException
    {
        /* Vamos a obtener los datos de la cabecera del reclamos para el cliente dado 
         * DAOInformesReclamos dao 
         * DTOOidPaginado dtoe 
         * DTOSalida.resultado = dao.consultarReclamosCliente(dtoe) 
         * Devolver este DTOSalida obtenido
         */

        UtilidadesLog.info("MONDigitarReclamos.consultarReclamosCliente(DTOOIDPaginado):Entrada");
        DAOInformesReclamos daoInformes = new DAOInformesReclamos();
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(daoInformes.consultarReclamosCliente(dtoe));
        UtilidadesLog.info("MONDigitarReclamos.consultarReclamosCliente(DTOOIDPaginado):Salida");
        return dtoSalida;
    }
    
    //Modificado el DTOE por incidencia BELC300015961
    public DTOSalida consultarDetalleReclamo(DTOOIDPaginado dtoe) throws MareException
    {
        /*
         * DAOInformesReclamos dao 
         * DTOOidPaginado dtoe 
         * DTOSalida.resultado = dao.consultarDetalleReclamos(dtoe)
         */
        
        UtilidadesLog.info("MONDigitarReclamos.consultarDetalleReclamo(DTOOIDPaginado):Entrada");
        DAOInformesReclamos daoInformes = new DAOInformesReclamos();
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(daoInformes.consultarDetalleReclamo(dtoe));
        UtilidadesLog.info("MONDigitarReclamos.consultarDetalleReclamo(DTOOIDPaginado):Salida");
        return dtoSalida;
    }
}