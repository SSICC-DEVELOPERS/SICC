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
 
package es.indra.sicc.logicanegocio.fac;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.fac.DTOFormulariosTipoSolicitud;
import es.indra.sicc.entidades.fac.FormulariosTipoSolicitudLocalHome;
import es.indra.sicc.entidades.fac.FormulariosTipoSolicitudLocal;
import es.indra.sicc.logicanegocio.fac.DAOFacturacion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.rmi.RemoteException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONParametrizacionBean implements SessionBean  {

	private final static String MON_VALIDACION = "MONValidacion";
	private SessionContext ctx = null;
	
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

	public DTOSalida cargaFormulariosTipoSolicitud(DTOOID dto) throws MareException {
		UtilidadesLog.info("MONParametrizacionBean.cargaFormulariosTipoSolicitud(DTOOID dto): Entrada");

		// Delegamos en DAOFacturacion.obtenerFormulariosTipoSolicitud
		String usuario = ctx.getCallerPrincipal().getName();
		DAOFacturacion daoFacturacion = new DAOFacturacion(usuario);
		RecordSet rs = daoFacturacion.obtenerFormulariosTipoSolicitud(dto);

		DTOSalida dtoSalida = null;
		if (rs != null && rs.getRowCount() != 0) {
			dtoSalida = new DTOSalida(rs);
		} else {
			dtoSalida = new DTOSalida(new RecordSet());
			 throw new MareException(new Exception(),
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));

		}
		
		UtilidadesLog.info("MONParametrizacionBean.cargaFormulariosTipoSolicitud(DTOOID dto): Salida");
		return dtoSalida;
	}
	
	public void guardarFormulariosTipoSolicitud(DTOFormulariosTipoSolicitud dto) throws MareException {
		UtilidadesLog.info("MONParametrizacionBean.guardarFormulariosTipoSolicitud(DTOFormulariosTipoSolicitud dto): Entrada");
		try {
		// Hacemos un findByTipoSolicitud() en el entity FormulariosTipoSolicitud
		this.validaAcceso(dto.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		Long tipoSolicitud = dto.getTipoSolicitud();
		FormulariosTipoSolicitudLocalHome formulariosHome = this.getFormulariosHome();
		Collection collectionFormularios = formulariosHome.findByTipoSolicitud(tipoSolicitud);

		Map formularios = dto.getFormularios();

		Iterator iterador = collectionFormularios.iterator();
		while (iterador.hasNext()) {
			FormulariosTipoSolicitudLocal formularioLocal = (FormulariosTipoSolicitudLocal)iterador.next();
                        formulariosHome.remove(formularioLocal);                       
		}

		
		iterador = formularios.keySet().iterator();
		while (iterador.hasNext()) {
			Long formulario = (Long)iterador.next();
			Short numOrdenSecuencia = new Short(formularios.get(formulario).toString());
			FormulariosTipoSolicitudLocal formularioLocal = formulariosHome.create(formulario,tipoSolicitud,numOrdenSecuencia);
		}
		} catch(NoResultException e) {
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			this.logearError("guardarFormulariosTipoSolicitud: FinderException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
		} catch(PersistenceException e) {
                        ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logearError("guardarFormulariosTipoSolicitud: RemoveException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
		} 
				
		UtilidadesLog.info("MONParametrizacionBean.guardarFormulariosTipoSolicitud(DTOFormulariosTipoSolicitud dto): Salida");
	}
	
	public DTOSalida obtenerTiposDocumentoLegal(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONParametrizacionBean.obtenerTiposDocumentoLegal(DTOBelcorp dto): Entrada");

		// Delegamos en DAOFacturacion.obtenerTiposDocumentoLegal
		String usuario = ctx.getCallerPrincipal().getName();
		DAOFacturacion daoFacturacion = new DAOFacturacion(usuario);
		RecordSet rs = daoFacturacion.obtenerTiposDocumentoLegal(dto);

		DTOSalida dtoSalida = null;
		if (rs != null) {
			dtoSalida = new DTOSalida(rs);
		} else {
			dtoSalida = new DTOSalida(new RecordSet());
		}
		
		UtilidadesLog.info("MONParametrizacionBean.obtenerTiposDocumentoLegal(DTOBelcorp dto): Salida");
		return dtoSalida;
	}

	private FormulariosTipoSolicitudLocalHome getFormulariosHome() throws MareException {
		return new FormulariosTipoSolicitudLocalHome();
	}

	private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		this.logStackTrace(e);
	}

	private void logStackTrace(Throwable e) {
		try{
			UtilidadesLog.error("Se produjo la excepcion: " + e.getMessage());
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			//e.printStackTrace(out);
			UtilidadesLog.error("stack Trace : " +  pila.toString());
		}catch(Exception ex){
			UtilidadesLog.error("Eror Logeando Pila: "+ex.getMessage());
		}
	}

	private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, 
        Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)
        throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = new Boolean(true);

        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais + ",sociedad = " + sociedad +
            ", marca=" + marca + ", canal= " + canal + ", acceso=" + acceso + ",subacceso = "
	        + subacceso +  ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal, acceso,
                    subacceso, subgerencia, region, zona, seccion, territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(rExc);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("MONParametrizacionBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");
    }

	private MONValidacion getMONValidacion() throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.getMONValidacion(): Entrada");

        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome(MON_VALIDACION,
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.logearError("*** Error en getMONValidacion", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONParametrizacionBean.getMONValidacion(): Salida");

        return ejb;
    }
	// Añadido por incidencia 11153
	public DTOSalida obtenerFormularios(DTOBelcorp DTOE) throws MareException {
		UtilidadesLog.info("MONParametrizacionBean.obtenerFormularios(DTOBelcorp DTOE): Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOFacturacion daoFacturacion = new DAOFacturacion(usuario);
		DTOSalida dtoSalida = new DTOSalida(daoFacturacion.obtenerFormularios());
		UtilidadesLog.info("MONParametrizacionBean.obtenerFormularios(DTOBelcorp DTOE): Salida");
		return dtoSalida;
	}

	public DTOSalida obtenerTiposCierre(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONParametrizacionBean.obtenerTiposCierre(DTOBelcorp dto): Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOFacturacion daoFacturacion = new DAOFacturacion(usuario);
		DTOSalida dtoSalida = new DTOSalida(daoFacturacion.obtenerTiposCierre());
		UtilidadesLog.info("MONParametrizacionBean.obtenerTiposCierre(DTOBelcorp dto): Salida");
		return dtoSalida;
	}

  public DTOSalida obtenerNivel(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.obtenerNivel(DTOBelcorp dto): Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOFAC daoFacturacion = new DAOFAC();
		UtilidadesLog.info("MONParametrizacionBean.obtenerNivel(DTOBelcorp dto): Salida");
		return daoFacturacion.obtenerNivel(dto);
  }
}