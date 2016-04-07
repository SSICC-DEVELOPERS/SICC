/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.bel;

import es.indra.sicc.entidades.bel.MediosDePagoLocal;
import es.indra.sicc.entidades.bel.MediosDePagoLocalHome;
import es.indra.sicc.logicanegocio.bel.DAOServicioBel;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONGestionMedioPagoBelCenterBean implements SessionBean ,IBELMediosPago {

    private SessionContext ctx;
	
    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }


	//BELC300004902 
	public Long obtenerOidMedioPago(Long pais, String codigo) throws MareException {
		/*
		 * Entrada: pais (Long) y codigo (String)
		 * Proceso:
		 * -> Con el pais y el codigo se hace la consulta en la entidad MediosDePago, 
		 * llamando al método
		 * "findByUK" y devuelve el oid correspondiente o null si no existe.
		 */
		UtilidadesLog.info("MONGestionMedioPagoBelCenterBean.obtenerOidMedioPago(Long pais, String codigo):Entrada");
		try  {
			MediosDePagoLocalHome mediosDePagoLocalHome = this.getMediosDePagoHome();
			MediosDePagoLocal local = mediosDePagoLocalHome.findByUK(pais,codigo);
			UtilidadesLog.info("MONGestionMedioPagoBelCenterBean.obtenerOidMedioPago(Long pais, String codigo):Salida");
			return local.getOid();
		} catch (NoResultException fe)  {
                         UtilidadesLog.info("MONGestionMedioPagoBelCenterBean.obtenerOidMedioPago(Long pais, String codigo):Salida");
			 //throw new MareException(fe,  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );
			 return null;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
	}

	// BELC300004522
	public DTOSalida obtenerMediosPagoCombo(DTOBelcorp dto) throws MareException {
		/*
		 * -> Llamar al método "DAOServicioBEL.obtenerMediosPagoCombo(dto : DTOBelcorp) : DTOSalida"
		 * -> Devolver el DTOSalida obtenido en actividad anterior.
		 */
		UtilidadesLog.info("MONGestionMedioPagoBelCenterBean.obtenerMediosPagoCombo(DTOBelcorp dto):Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicioBel = new DAOServicioBel(usuario);
		DTOSalida dtoSalida = daoServicioBel.obtenerMediosPagoCombo(dto);
		UtilidadesLog.info("MONGestionMedioPagoBelCenterBean.obtenerMediosPagoCombo(DTOBelcorp dto):Salida");
		return dtoSalida;		
	}

        
    private MediosDePagoLocalHome getMediosDePagoHome() {
        return new MediosDePagoLocalHome();
    }      
    
}