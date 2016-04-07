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
 */

package es.indra.sicc.logicanegocio.msg;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.msg.DTOMensajeSeccion;
import es.indra.sicc.dtos.msg.DTOPatron;
import es.indra.sicc.dtos.msg.DTOSeccion;
import es.indra.sicc.dtos.msg.DTOInicioFin;

import es.indra.sicc.entidades.msg.PatronCabeceraLocalHome;
import es.indra.sicc.entidades.msg.PatronCabeceraLocal;
import es.indra.sicc.entidades.msg.PatronPorPeriodoLocalHome;
import es.indra.sicc.entidades.msg.PatronPorPeriodoLocal;
import es.indra.sicc.entidades.msg.PatronSeccionLocalHome;
import es.indra.sicc.entidades.msg.PatronSeccionLocal;
import es.indra.sicc.entidades.msg.PatronMensajeLocalHome;
import es.indra.sicc.entidades.msg.PatronMensajeLocal;
import es.indra.sicc.entidades.msg.MedioEnvioPaisLocalHome;
import es.indra.sicc.entidades.msg.MedioEnvioPaisLocal;
import es.indra.sicc.entidades.msg.MedioEnvioLocalHome;
import es.indra.sicc.entidades.msg.MedioEnvioLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import es.indra.sicc.entidades.fac.FormularioLocalHome;
import es.indra.sicc.entidades.fac.FormularioLocal;


import java.math.BigDecimal;
import java.util.Arrays;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONPatronesBean implements SessionBean {
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
		this.ctx = ctx;
    }

    public DTOSalida obtenerFormularios(DTOBelcorp DTOE) throws MareException {
		return new DTOSalida( new DAOMSG().obtenerFormularios() );
    }

    public DTOPatron guardarPatron(DTOPatron DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.guardarPatron(DTOPatron DTOE): Entrada");
    
		PatronCabeceraLocalHome pcLHome = null;
		PatronCabeceraLocal pcLocal = null;
		PatronPorPeriodoLocalHome pppLHome = null;
		PatronPorPeriodoLocal pppLocal = null;

		try{
			pcLHome = new PatronCabeceraLocalHome();
			//pcLHome.parametrosAuditoria( DTOE );

			//pcLocal = pcLHome.create( DTOE.getCodigo().toLowerCase(), DTOE.getDescripcion(), DTOE.getOidPais() );
            pcLocal = pcLHome.create( DTOE.getCodigo(), DTOE.getDescripcion(), DTOE.getOidPais() );
			pcLocal.setIndActivo( DTOE.getActivo() );
			pcLocal.setIndPatronPeriodo( DTOE.getPatronPeriodo() );
			pcLocal.setOidFormulario( DTOE.getOidFormulario() );
			pcLocal.setOidMedioEnvioPais( DTOE.getOidMedioEnvio() );
                        pcLHome.merge(pcLocal);
			DTOE.setOidPatron( pcLocal.getOid() );

			if (DTOE.getPatronPeriodo().booleanValue() ){
				if (DTOE.getOidPatronOrigen().longValue() == 
						ConstantesMSG.PRIMER_PATRON_PERIODO.longValue() ){
					DTOE.setOidPatronOrigen( pcLocal.getOid() );
				}

				pppLHome = new PatronPorPeriodoLocalHome();
				//pppLHome.parametrosAuditoria( DTOE );

				pppLocal = pppLHome.create( DTOE.getOidPatronOrigen(),
											DTOE.getOidPatron(),
											DTOE.getOidPeriodo() );

				DTOE.setOidPatronPeriodo(pppLocal.getOid());
			    
				pppLocal = null;
				pppLHome = null;
			}

			pcLocal = null;
			pcLHome = null;
			
		} catch (PersistenceException ce){
            UtilidadesLog.error(ce);
			ctx.setRollbackOnly();
			throw new MareException(ce, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_CLAVE_DUPLICADA));
		} catch (Exception e){
            UtilidadesLog.error(e);
			ctx.setRollbackOnly();
			throw new MareException(e, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_CLAVE_DUPLICADA));
		}
		
        UtilidadesLog.info("MONPatronesBean.guardarPatron(DTOPatron DTOE): Salida");
        
        return DTOE;
    }

    public DTOSeccion obtenerSeccion(DTOOID DTOE) throws MareException {
        return new DAOMSG().obtenerSeccion(DTOE);
    }

    public DTOOID guardarSeccion(DTOSeccion DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.guardarSeccion(DTOSeccion DTOE): Entrada");
    
		PatronSeccionLocalHome psLHome = null;
		PatronSeccionLocal psLocal = null;
		DTOOID oidSeccion = null;
		
		try{
			psLHome = new PatronSeccionLocalHome();
			//psLHome.parametrosAuditoria( DTOE );

			psLocal = psLHome.create( 	DTOE.getCodigo(), 
										DTOE.getOidPatron(), 
										DTOE.getOrdenSecuencia() );

			psLocal.setOidMetacaracter( DTOE.getOidMetacaracter() );
                        psLHome.merge(psLocal);
			oidSeccion = new DTOOID();
			oidSeccion.setOid( psLocal.getOid() );

			Collection mensajes = DTOE.getMensajes();
			Iterator it = mensajes.iterator();

			while (it.hasNext() ){
				guardarMensaje( oidSeccion.getOid() , ((DTOMensajeSeccion) it.next()));
			}

			psLocal = null;
			psLHome = null;

		} catch (PersistenceException ce){
            UtilidadesLog.error(ce);
			ctx.setRollbackOnly();
			throw new MareException(ce, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS ));
		}
		
        UtilidadesLog.info("MONPatronesBean.guardarSeccion(DTOSeccion DTOE): Salida");
        
        return oidSeccion;
    }

    public void guardarMensaje(Long oidPatronSeccion, DTOMensajeSeccion DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.guardarMensaje(Long oidPatronSeccion, DTOMensajeSeccion DTOE): Entrada");
    
		PatronMensajeLocalHome pmLHome = null;
		PatronMensajeLocal pmLocal = null;
	
		try{
			pmLHome = new PatronMensajeLocalHome();
			//pmLHome.parametrosAuditoria( DTOE );

			pmLocal = pmLHome.create( 	oidPatronSeccion, 
										DTOE.getOidMensaje(), 
										DTOE.getOrdenImpresion() );

			pmLocal = null;
			pmLHome = null;

		} catch (PersistenceException ce){
            UtilidadesLog.error(ce);
			ctx.setRollbackOnly();
			throw new MareException(ce, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS ));
		}
        
        UtilidadesLog.info("MONPatronesBean.guardarMensaje(Long oidPatronSeccion, DTOMensajeSeccion DTOE): Salida");
    }

    public void modificarSeccion(DTOSeccion DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.modificarSeccion(DTOSeccion DTOE): Entrada");
    
		DTOOID oid = new DTOOID();
		oid.setOid( DTOE.getOidSeccion() );

		eliminarSeccion( oid );
		insertarSeccion( DTOE );
        
        UtilidadesLog.info("MONPatronesBean.modificarSeccion(DTOSeccion DTOE): Salida");
    }

    public void eliminarSeccion(DTOOID DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.eliminarSeccion(DTOOID DTOE): Entrada");
    
		PatronSeccionLocalHome psLHome = null;
		PatronSeccionLocal psLocal = null;
		
		try{
			psLHome = new PatronSeccionLocalHome();
			//psLHome.parametrosAuditoria( DTOE );

			// Obtenemos la sección a eliminar 
			psLocal = psLHome.findByPrimaryKey( DTOE.getOid() );

			// Desplazamos hacia arriba, las secciones con orden de secuencia superior 
			DAOMSG daoMSG = new DAOMSG();
			int numeroSecciones = daoMSG.obtenerNumeroSecciones( psLocal.getOidPatronCabecera() );

			DTOInicioFin dtoInicioFin = new DTOInicioFin();
			dtoInicioFin.setIpCliente(DTOE.getIpCliente());
			dtoInicioFin.setPrograma(DTOE.getPrograma());
			dtoInicioFin.setOidIdioma(DTOE.getOidIdioma());
			dtoInicioFin.setOidPais(DTOE.getOidPais());
		
			dtoInicioFin.setOidPatron( psLocal.getOidPatronCabecera() );
			dtoInicioFin.setInicio( new Integer( psLocal.getOrdenSeccion().intValue() + 1 ) );
			dtoInicioFin.setFin( new Integer(numeroSecciones + 1) );

			desplazarSeccionesArriba( dtoInicioFin );

			// Finalmente se elimina la sección 
			eliminarMensajesSeccion( DTOE );
			psLHome.remove(psLocal);

			psLocal = null;
			psLHome = null;

		} catch (NoResultException fe){
            UtilidadesLog.debug(fe);
			ctx.setRollbackOnly();
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch (PersistenceException re){
            UtilidadesLog.debug(re);
			ctx.setRollbackOnly();
			throw new MareException(re, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_BORRADO_DE_DATOS));
		}
        
        UtilidadesLog.info("MONPatronesBean.eliminarSeccion(DTOOID DTOE): Salida");
    }

    public void eliminarMensajesSeccion(DTOOID DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.eliminarMensajesSeccion(DTOOID DTOE): Entrada");
    
		PatronMensajeLocalHome pmLHome = null;
		PatronMensajeLocal pmLocal = null;
	
		try{
			pmLHome = new PatronMensajeLocalHome();
			//pmLHome.parametrosAuditoria( DTOE );

			// Obtenemos todos los mensajes de la sección 
			Collection mensajes = pmLHome.findBySeccion( DTOE.getOid() );
			Iterator it = mensajes.iterator();

			while (it.hasNext()){
				//Para cada mensaje encontrado en la Collection mensajes 
				//Llamar al método remove() de la entidad PatronMensaje 

				pmLHome.remove(((PatronMensajeLocal) it.next()));
			}

			pmLHome = null;
			
		} catch (NoResultException fe){
            UtilidadesLog.debug(fe);
			ctx.setRollbackOnly();
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch (PersistenceException re){
            UtilidadesLog.error(re);
			ctx.setRollbackOnly();
			throw new MareException(re, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_BORRADO_DE_DATOS ));
		}
        
        UtilidadesLog.info("MONPatronesBean.eliminarMensajesSeccion(DTOOID DTOE): Salida");
        
    }

    public DTOPatron actualizarPatron(DTOPatron DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.actualizarPatron(DTOPatron DTOE): Entrada");
    
		PatronCabeceraLocalHome pcLHome = null;
		PatronCabeceraLocal pcLocal = null;
		PatronPorPeriodoLocalHome pppLHome = null;
		PatronPorPeriodoLocal pppLocal = null;

		try{
			pcLHome = new PatronCabeceraLocalHome();
			//pcLHome.parametrosAuditoria( DTOE );

			pcLocal = pcLHome.findByPrimaryKey( DTOE.getOidPatron() );

			pcLocal.setDescripcion( DTOE.getDescripcion() );
			pcLocal.setIndActivo( DTOE.getActivo() );
			pcLocal.setIndPatronPeriodo( DTOE.getPatronPeriodo() );
			pcLocal.setOidFormulario( DTOE.getOidFormulario() );
			pcLocal.setOidMedioEnvioPais( DTOE.getOidMedioEnvio() );
		       pcLHome.merge(pcLocal);
			if (DTOE.getOidPatronPeriodo() != null){
				pppLHome = new PatronPorPeriodoLocalHome();
				//pppLHome.parametrosAuditoria( DTOE );

				pppLocal = pppLHome.findByPrimaryKey( DTOE.getOidPatronPeriodo() );
				pppLHome.remove(pppLocal);

				pppLocal = null;
				pppLHome = null;
			}

			// Comprobar si se ha habilitado la opción Patron por Periodo 
			if (DTOE.getPatronPeriodo().booleanValue() ){
				if (DTOE.getOidPatronOrigen().longValue() == 
						ConstantesMSG.PRIMER_PATRON_PERIODO.longValue() ){
					DTOE.setOidPatronOrigen( DTOE.getOidPatron() );
				}
				pppLHome = new PatronPorPeriodoLocalHome();
				//pppLHome.parametrosAuditoria( DTOE );

				pppLocal = pppLHome.create( DTOE.getOidPatronOrigen(),
											DTOE.getOidPatron(),
											DTOE.getOidPeriodo() );

				DTOE.setOidPatronPeriodo( pppLocal.getOid() );

				pppLocal = null;
				pppLHome = null;
			}

			pcLocal = null;
			pcLHome = null;
		} catch (NoResultException fe){
            UtilidadesLog.debug(fe);
			ctx.setRollbackOnly();
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch (PersistenceException ce){
            UtilidadesLog.error(ce);
			ctx.setRollbackOnly();
			throw new MareException(ce, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS ));
		}

        UtilidadesLog.info("MONPatronesBean.actualizarPatron(DTOPatron DTOE): Salida");

		return DTOE;
    }

    public void desplazarSeccionesArriba(DTOInicioFin DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.desplazarSeccionesArriba(DTOInicioFin DTOE): Entrada");
    
		PatronSeccionLocalHome psLHome = null;
		PatronSeccionLocal psLocal = null;
		int inicio = DTOE.getInicio().intValue();
		int fin = DTOE.getFin().intValue();
		
		
		try{
			psLHome = new PatronSeccionLocalHome();
			//psLHome.parametrosAuditoria( DTOE );

			// Mueve una posición hacia arriba las secciones con orden de secuencia entre inicio (incluido) y fin (no incluido) 
			for (int i = inicio; i < fin; i++) { 
				// Obtiene la seccion de la posicion i 
				//TODO: BELC300008685

                UtilidadesLog.debug("DTOE.getOidPatron(): " + DTOE.getOidPatron());
                UtilidadesLog.debug("new Integer(i): " + new Integer(i));
                
				psLocal = psLHome.findByOrdenSeccion(DTOE.getOidPatron(), new Integer(i) );
				// Disminuye en 1 su orden de secuencia y lo actualiza en la entidad PatronSeccion 
        //psLocal.setOrdenSeccion(new Integer( psLocal.getOrdenSeccion().intValue() - 1 ));
        
        //inc. 14029
        UtilidadesLog.debug("orden de sec. antes: " + psLocal.getOrdenSeccion().intValue());
        //if(psLocal.getOrdenSeccion().intValue()!=1)
          psLocal.setOrdenSeccion(new Integer( psLocal.getOrdenSeccion().intValue() - 1 ));
         psLHome.merge(psLocal);
        //else psLocal.setOrdenSeccion(new Integer( psLocal.getOrdenSeccion().intValue()));  
        UtilidadesLog.debug("orden de sec. despues: " + psLocal.getOrdenSeccion().intValue());
			}
		} catch (NoResultException fe){
            UtilidadesLog.debug(fe);
			ctx.setRollbackOnly();
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}catch (PersistenceException ce){
            UtilidadesLog.error(ce);
			ctx.setRollbackOnly();
			throw new MareException(ce, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS ));
		}
        
        UtilidadesLog.info("MONPatronesBean.desplazarSeccionesArriba(DTOInicioFin DTOE): Salida");
    }

    public void desplazarSeccionesAbajo(DTOInicioFin DTOE) throws MareException {
        UtilidadesLog.info("MONPatronesBean.desplazarSeccionesAbajo(DTOInicioFin DTOE): Entrada");
    
		PatronSeccionLocalHome psLHome = null;
		PatronSeccionLocal psLocal = null;
		int inicio = DTOE.getInicio().intValue();
		int fin = DTOE.getFin().intValue();
		
		try{
			psLHome = new PatronSeccionLocalHome();
			//psLHome.parametrosAuditoria( DTOE );

			// Mueve una posición hacia arriba las secciones con orden de secuencia entre inicio (incluido) y fin (no incluido) 
            UtilidadesLog.debug("Este es el inicio: " + inicio);
            UtilidadesLog.debug("Este es el Fin: " + fin);
            
			for (int i = inicio; i > fin; i--) { 
				// Obtiene la seccion de la posicion i 
				//TODO: BELC300008685
                UtilidadesLog.debug("DTOE.getOidPatron(): " + DTOE.getOidPatron());
                UtilidadesLog.debug("new Integer(i): " + new Integer(i));

				Collection col = psLHome.findByPatron(DTOE.getOidPatron());
                
				Iterator it = col.iterator();
				while (it.hasNext())  {
					psLocal = (PatronSeccionLocal) it.next();
					if (psLocal.getOrdenSeccion().intValue() == i)
						psLocal.setOrdenSeccion(new Integer( psLocal.getOrdenSeccion().intValue() + 1 ));
                                                psLHome.merge(psLocal);
                                }
                
				// Se modifica el metodo ya que por razones desconocidas, el finByOrdenSeccion()
				// posee un comportamiento extraño. No retorna datos aunque existan registros en la base
				// que cumplan con los paramtros correspondientes.
				// Pablo Perez
				// 23/11/2004
//				System.out.println("Este es el valor de I:  " + new Integer(i));
//				psLocal = psLHome.findByOrdenSeccion(DTOE.getOidPatron(), new Integer(i) );
				// Aumenta en 1 su orden de secuencia y lo actualiza en la entidad PatronSeccion 
//				psLocal.setOrdenSeccion(new Integer( psLocal.getOrdenSeccion().intValue() + 1 ));
			}
                
		} catch (NoResultException fe){
            UtilidadesLog.debug(fe);
			ctx.setRollbackOnly();
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}catch (PersistenceException ce){
            UtilidadesLog.error(ce);
			ctx.setRollbackOnly();
			throw new MareException(ce, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS ));
		}
        
        UtilidadesLog.info("MONPatronesBean.desplazarSeccionesAbajo(DTOInicioFin DTOE): Salida");
    }

    public void insertarSeccion(DTOSeccion DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.insertarSeccion(DTOSeccion DTOE): Entrada");
    
		//En primer lugar desplazamos hacia abajo todas las secciones con orden de secuencia >= al orden de secuencia de la sección que vamos a insertar. 
		DAOMSG daoMSG = new DAOMSG();
		int numeroSecciones = daoMSG.obtenerNumeroSecciones(DTOE.getOidPatron());

		DTOInicioFin dtoInicioFin = new DTOInicioFin();
		dtoInicioFin.setIpCliente(DTOE.getIpCliente());
		dtoInicioFin.setPrograma(DTOE.getPrograma());
		dtoInicioFin.setOidIdioma(DTOE.getOidIdioma());
		dtoInicioFin.setOidPais(DTOE.getOidPais());
		
		dtoInicioFin.setOidPatron( DTOE.getOidPatron() );
		dtoInicioFin.setInicio( new Integer( numeroSecciones) );
		dtoInicioFin.setFin( new Integer(DTOE.getOrdenSecuencia().intValue() - 1) );
        
        UtilidadesLog.debug("Este es el inicio:" + new Integer( numeroSecciones));
        UtilidadesLog.debug("este es el Fin: " + new Integer(DTOE.getOrdenSecuencia().intValue() - 1));
        
		desplazarSeccionesAbajo( dtoInicioFin );

		// A continuación guardamos la sección en su posición 
		guardarSeccion(DTOE);
        
        UtilidadesLog.info("MONPatronesBean.insertarSeccion(DTOSeccion DTOE): Salida");
    }

    public DTOSalida obtenerPatronesOrigen(DTOBelcorp DTOE) throws MareException {
		return new DTOSalida( new DAOMSG().obtenerPatronesOrigen( DTOE.getOidPais() ));
    }

    public DTOSalida obtenerSecciones(DTOOID DTOE) throws MareException {
        return new DTOSalida( new DAOMSG().obtenerSecciones( DTOE.getOid() ));
    }

    public DTOSalida buscarPatrones(DTOPatron DTOE) throws MareException {
		if ((DTOE.getPatronPeriodo() == null) || !DTOE.getPatronPeriodo().booleanValue()){   //DTOE.getPatronPeriodo().booleanValue()
			return new DTOSalida( new DAOMSG().buscarPatrones( DTOE ));			
		} else { 
			return new DTOSalida( new DAOMSG().buscarPatronesPorPeriodo( DTOE ));
		} 
    }

    public DTOPatron obtenerPatron(DTOOID DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.obtenerPatron(DTOOID DTOE): Entrada");
    
		PatronCabeceraLocalHome pcLHome = null;
		PatronCabeceraLocal pcLocal = null;
		PatronPorPeriodoLocalHome pppLHome = null;
		PatronPorPeriodoLocal pppLocal = null;
		MedioEnvioLocalHome meLHome = null;
		MedioEnvioLocal meLocal = null;
		MedioEnvioPaisLocalHome mepLHome = null;
		MedioEnvioPaisLocal mepLocal = null;
		FormularioLocalHome formLHome = null;
		FormularioLocal formLocal = null;
    PeriodoCorporativoLocalHome pcoLHome = null;
    PeriodoCorporativoLocal pcoLocal = null;
    Entidadi18nLocalHome e18lh = null;
    Entidadi18nLocal e18l = null;
    
		DTOPatron salida = new DTOPatron();
		
		try{
			pcLHome = new PatronCabeceraLocalHome();
			//pcLHome.parametrosAuditoria( DTOE);

			pcLocal = pcLHome.findByPrimaryKey( DTOE.getOid() );
			salida.setOidPatron(pcLocal.getOid() );
			salida.setCodigo( pcLocal.getCodigoPatron() );
			salida.setDescripcion( pcLocal.getDescripcion() );
			salida.setOidFormulario( pcLocal.getOidFormulario());
			salida.setOidMedioEnvio( pcLocal.getOidMedioEnvioPais() );
			salida.setPatronPeriodo( pcLocal.getIndPatronPeriodo() );
			salida.setActivo(pcLocal.getIndActivo());
			salida.setOidPais(pcLocal.getOidPais());


			/*TODO inc a GPM: entidades formulario no disponible
			 * 
			formulario = Llamar al método findByPrimaryKey(DTOPatron.oidFormulario) de la entidad Formulario 
			DTOPatron.codigoFormulario = formulario.codigo 
			*/

			formLHome = new FormularioLocalHome();
			formLocal = formLHome.findByPrimaryKey(salida.getOidFormulario());
			
            /**    
             *@Author: pperez 
             *@Fecha: 23/08/2005 Incidencia DBLG200000117
            */ 
            //salida.setCodigoFormulario(formLocal.getCodigo());
            salida.setCodigoFormulario(formLocal.getNombre());
			
            mepLHome = new MedioEnvioPaisLocalHome();
			meLHome = new MedioEnvioLocalHome();
			
			mepLocal = mepLHome.findByPrimaryKey( salida.getOidMedioEnvio() );
			meLocal = meLHome.findByPrimaryKey(mepLocal.getOidMediosEnvio() );
			
			salida.setDescripcionMedioEnvio( meLocal.getDes_medi_envi() ); 


			if ( pcLocal.getIndPatronPeriodo().booleanValue()){
				pppLHome = new PatronPorPeriodoLocalHome();
				pppLocal = pppLHome.findByPatron( pcLocal.getOid() );
				salida.setOidPatronPeriodo( pppLocal.getOid() );
				salida.setOidPatronOrigen( pppLocal.getOidPatronOrigen() );
				salida.setOidPeriodo( pppLocal.getOidPeriodo() );
        
        //inc. 14024
        pcoLHome = new PeriodoCorporativoLocalHome();
        pcoLocal = pcoLHome.findByPrimaryKey(pppLocal.getOidPeriodo());
        salida.setDesPeriodo(pcoLocal.getCodigoPeriodo());
        salida.setOidTipoPeriodo(pcoLocal.getOidTipoPeriodo());
        e18lh = new Entidadi18nLocalHome();
        e18l = e18lh.findByEntAtrIdioPK(ConstantesSEG.SEG_TIPO_PERIO, ConstantesMSG.NUM_ATRIBUTO, DTOE.getOidIdioma(), pcoLocal.getOidTipoPeriodo());
        salida.setDesTipoPeriodo(e18l.getDetalle());
        
			} else {
				salida.setOidPatronPeriodo( null );
				salida.setOidPatronOrigen( null );
				salida.setOidPeriodo( null );
        
        //inc. 14024
        salida.setDesPeriodo( null );
        salida.setOidTipoPeriodo( null );
        salida.setDesTipoPeriodo( null );
			}
		} catch ( NoResultException fe){
            UtilidadesLog.debug(fe);
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}catch (PersistenceException ce){
            UtilidadesLog.error(ce);
			ctx.setRollbackOnly();
			throw new MareException(ce, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS ));
		} catch (Exception e){
            UtilidadesLog.error(e);
			throw new MareException(e, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }

        UtilidadesLog.info("MONPatronesBean.obtenerPatron(DTOOID DTOE): Salida");

		return salida;
    }

    public void eliminarPatron(DTOOIDs DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.eliminarPatron(DTOOIDs DTOE): Entrada");
    
		//El método elimina todos los patrones identificados en el DTO de entrada. 
		PatronSeccionLocalHome psLHome = null;
		PatronSeccionLocal psLocal = null;
		PatronCabeceraLocalHome pcLHome = null;
		PatronCabeceraLocal pcLocal = null;
		PatronPorPeriodoLocalHome pppLHome = null;
		PatronPorPeriodoLocal pppLocal = null;
		DTOOID dtoPatronSeccion = null;
		
		Collection oids = Arrays.asList( DTOE.getOids() );
		Long oid = null;

		try{

			if (oids!=null){
				psLHome = new PatronSeccionLocalHome();
				//psLHome.parametrosAuditoria( DTOE );			

				Iterator it = oids.iterator();
				while (it.hasNext()){
					oid = (Long) it.next();
					Boolean patronOrigen = esPatronOrigen(oid);

					if (!patronOrigen.booleanValue()){

						Collection secciones = psLHome.findByPatron(oid);
						if (secciones!=null){

							Iterator it2 = secciones.iterator();
							while (it2.hasNext()){
								psLocal = (PatronSeccionLocal) it2.next();
								//TODO: BELC300008903.
								dtoPatronSeccion = new DTOOID();
								dtoPatronSeccion.setOid( psLocal.getOid() );
								dtoPatronSeccion.setOidIdioma( DTOE.getOidIdioma() );
								dtoPatronSeccion.setOidPais( DTOE.getOidPais() );
								dtoPatronSeccion.setPrograma( DTOE.getPrograma() );
								dtoPatronSeccion.setIpCliente( DTOE.getIpCliente() );
								
								eliminarMensajesSeccion( dtoPatronSeccion );
								psLHome.remove(psLocal);
							}
						}

						pppLHome = new PatronPorPeriodoLocalHome();
						//pppLHome.parametrosAuditoria(DTOE);

						try  {
							pppLocal = pppLHome.findByPatron(oid);
							pppLHome.remove(pppLocal);							
						} catch (NoResultException ex)  {
                            UtilidadesLog.debug(ex);
						}

						pcLHome = new PatronCabeceraLocalHome();
						//pcLHome.parametrosAuditoria( DTOE );

						pcLocal = pcLHome.findByPrimaryKey( oid );
						pcLHome.remove(pcLocal);
						
						pcLocal = null;
						pcLHome = null;
					} else {
						throw new MareException(new Exception(), 
								UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_BORRADO_DE_DATOS));
					}
				}
				
				psLocal = null;
				psLHome = null;
			}
		} catch (NoResultException fe){
            UtilidadesLog.debug(fe);
			ctx.setRollbackOnly();
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch (PersistenceException re){
            UtilidadesLog.error(re);
			ctx.setRollbackOnly();
			throw new MareException(re, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_BORRADO_DE_DATOS));
		}
        
        UtilidadesLog.info("MONPatronesBean.eliminarPatron(DTOOIDs DTOE): Salida");
	}

    public Boolean esPatronOrigen(Long oidPatron) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.esPatronOrigen(Long oidPatron): Entrada");
    
		PatronPorPeriodoLocalHome pppLHome = null;
		PatronPorPeriodoLocal pppLocal = null;

		boolean patronOrigen = false;

		try{
			pppLHome = new PatronPorPeriodoLocalHome();

			//Comprueba si el patrón recibido es un patrón origen y está siendo utilizado 
			Collection patrones = pppLHome.findByPatronOrigen( oidPatron );
			Iterator it = patrones.iterator();

			while (it.hasNext()){
				// Si no coincide el oid del patron origen con el oid del patrón, quiere decir que está siendo utilizado por otro patrón distinto 
				pppLocal = (PatronPorPeriodoLocal) it.next();
				if ( pppLocal.getOidPatronOrigen().longValue() != 
						pppLocal.getOidPatron().longValue() ){
					patronOrigen = true;
				}
			}
		} catch (NoResultException fe){
            UtilidadesLog.debug(fe);
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}catch (PersistenceException ce){
            UtilidadesLog.error(ce);
			ctx.setRollbackOnly();
			throw new MareException(ce, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS ));
		}

        UtilidadesLog.info("MONPatronesBean.esPatronOrigen(Long oidPatron): Salida");

        return new Boolean(patronOrigen);
    }

    public DTOPatron obtenerDetallePatron(DTOOID DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.obtenerDetallePatron(DTOOID DTOE): Entrada");
    
		DTOPatron patron = new DTOPatron();
		RecordSet secciones = null;
		DAOMSG daoMSG = new DAOMSG();
		DTOSeccion seccionActual = null;
		DTOOID oidSeccion = null;
		ArrayList arrSecciones = new ArrayList();
		
		// Recupera toda la información referente a un patrón 
		patron = obtenerPatron(DTOE);
		secciones = daoMSG.obtenerSecciones( DTOE.getOid() );

		if (secciones!=null){

			for (int i=0; i<secciones.getRowCount(); i++){

				oidSeccion = new DTOOID();
				oidSeccion.setOidIdioma( DTOE.getOidIdioma() );
				oidSeccion.setOidPais( DTOE.getOidPais() );
				oidSeccion.setOid( new Long( ((BigDecimal) secciones.getValueAt(i,0) ).longValue()));
				seccionActual = new DTOSeccion();
				seccionActual = obtenerSeccion(oidSeccion);
				arrSecciones.add( seccionActual );
			}

			patron.setSecciones( arrSecciones );
		}

        UtilidadesLog.info("MONPatronesBean.obtenerDetallePatron(DTOOID DTOE): Salida");

		return patron;
    }

    public DTOPatron copiarPatron(DTOPatron DTOE) throws MareException {
    
        UtilidadesLog.info("MONPatronesBean.copiarPatron(DTOPatron DTOE): Entrada");
    
		// Método que realiza la copia de un patrón y de sus mensajes 
		// Devuelve la información del nuevo patrón creado 
		Collection secciones = null;
		DTOSeccion seccionActual = null;

		DTOOID oidPatron = new DTOOID();
		oidPatron.setOid( DTOE.getOidPatron() );
		oidPatron.setOidIdioma( DTOE.getOidIdioma() );
		oidPatron.setOidPais( DTOE.getOidPais() );

		DTOPatron dtoPatron = obtenerDetallePatron(oidPatron);
    Boolean patronPeriodo = dtoPatron.getPatronPeriodo(); //guardo este valor para asignarlo luego
		// Modificamos el codigo del patron que vamos a copiar 
		dtoPatron.setCodigo( DTOE.getCodigo() );
		dtoPatron.setPatronPeriodo( Boolean.FALSE );


		// Guardamos el nuevo patrón 
		dtoPatron = guardarPatron(dtoPatron);

		// Modificamos la información del patron origen (será el patrón que estamos copiando) 
		//dtoPatron.setOidPatronOrigen(null); 
		dtoPatron.setOidPeriodo(null);
		dtoPatron.setOidPatronPeriodo(null);
    dtoPatron.setPatronPeriodo(patronPeriodo);
		// Copiamos las secciones del patrón 
		secciones = dtoPatron.getSecciones();


		if (secciones!=null){
			Iterator it = secciones.iterator();
			while (it.hasNext()){
				seccionActual = (DTOSeccion) it.next();
				seccionActual.setOidPatron( dtoPatron.getOidPatron() ); 
				guardarSeccion(seccionActual);
			}
		} 

        UtilidadesLog.info("MONPatronesBean.copiarPatron(DTOPatron DTOE): Salida");

		return dtoPatron;
    }

    public DTOSalida obtenerMediosEnvioPorPais(DTOBelcorp DTOE) throws MareException {
        return new DTOSalida( new DAOMSG().obtenerMediosEnvioPorPais( DTOE ));
    }

    public DTOSalida obtenerMetacaracterEstructura(DTOBelcorp DTOE) throws MareException {
        UtilidadesLog.info("MONPatronesBean.obtenerMetacaracterEstructura(DTOBelcorp DTOE): Entrada");
    
		DAOMSG dao = new DAOMSG();
		DTOSalida salida = new DTOSalida( dao.obtenerMetacaracterEstructura(DTOE) );
        UtilidadesLog.debug(">>> DTOSALIDA: " + salida + "<<<");
        
        UtilidadesLog.info("MONPatronesBean.obtenerMetacaracterEstructura(DTOBelcorp DTOE): Salida");
        
		return salida;
//      return new DTOSalida( new DAOMSG().obtenerMetacaracterEstructura( DTOE ));
    }


    /**
     * Paola Cabrera
     * Se obtienen todos los patrones 
     * Se utiliza para cargar la combo del caso de uso 
     * "Imprimir Mensajes desde Editor de Mensajes" 
     * 
     * Fecha: 15/12/2004
     */

	public DTOSalida obtenerTodosPatrones(DTOBelcorp DTOE) throws MareException {
        UtilidadesLog.info("MONPatronesBean.obtenerTodosPatrones(DTOBelcorp DTOE): Entrada");
    
		DAOMSG dao = new DAOMSG();
		DTOSalida salida = new DTOSalida(dao.obtenerTodosPatrones(DTOE) );
        
        UtilidadesLog.debug("** DTOSALIDA: " + salida + " **");
        UtilidadesLog.info("MONPatronesBean.obtenerTodosPatrones(DTOBelcorp DTOE): Salida");
        
		return salida;		
	}


}
