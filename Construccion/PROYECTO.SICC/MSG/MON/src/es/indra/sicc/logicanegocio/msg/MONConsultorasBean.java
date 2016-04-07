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
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.ejbservice.EJBLocator;

import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.entidades.msg.BuzonMensajesLocal;
import es.indra.sicc.entidades.msg.BuzonMensajesLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.dtos.msg.*;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import java.sql.Timestamp;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.*;
import es.indra.sicc.dtos.msg.DTOBuscarConsultoras;
import es.indra.sicc.dtos.msg.DTOBuscarConsultorasInicial;
import es.indra.sicc.dtos.msg.DTODatosConsultora;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONConsultorasBean implements SessionBean  {
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

	public DTOSalida cargarListaConsultorasInicial(DTOBuscarConsultorasInicial DTOE) 
		throws MareException {

        UtilidadesLog.info("MONConsultorasBean.cargarListaConsultorasInicial(DTOBuscarConsultorasInicial DTOE): Entrada");

		RecordSet respuesta = null;

		DAOMSG daoMSG = new DAOMSG();		
		respuesta = daoMSG.obtenerListaConsultorasInicial(DTOE);
		
		// 21980 - dmorello, 31/05/2006: No se lanzará excepción por RecordSet vacio.
        //if (respuesta == null || respuesta.esVacio()){
        if (respuesta == null) {
            UtilidadesLog.debug("RecordSet nulo. Se va a lanzar excepcion.");
        
			throw new MareException(new Exception(), 
				UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        if (respuesta.esVacio()) {
            UtilidadesLog.debug("RecordSet vacío");
        }
        // Fin 21980 dmorello 31/05/2006

        UtilidadesLog.info("MONConsultorasBean.cargarListaConsultorasInicial(DTOBuscarConsultorasInicial DTOE): Salida");
				
		return (new DTOSalida(respuesta));		
	}

	public DTOSalida buscarListaConsultoras(DTOBuscarConsultoras DTOE) 
		throws MareException {

    UtilidadesLog.info("MONConsultorasBean.buscarListaConsultoras(DTOBuscarConsultoras DTOE): Entrada");

        DTOBuscarConsultorasOid dtoin = new DTOBuscarConsultorasOid();
        MensajesLocalHome msjLHome = null;
        ClienteDatosBasicosLocalHome cdbLHome = null;
        RecordSet respuesta = null;
        
        dtoin.setOidPais( DTOE.getOidPais() );
        dtoin.setCodMensaje( DTOE.getCodMensaje() );
        
        try{
            msjLHome = new MensajesLocalHome();
            cdbLHome = new ClienteDatosBasicosLocalHome();
            
            //Inc. 8092 dtoin.setOidMensaje( msjLHome.findByUk(DTOE.getOidPais(), DTOE.getCodMensaje()).getOid() );
            if ( DTOE.getCodCliente()!= null && !("".equals(DTOE.getCodCliente())) ){
                dtoin.setOidCliente( cdbLHome.findByCodigoYPais(DTOE.getOidPais(), 
                DTOE.getCodCliente()).getOid() );
	    } else {
		dtoin.setOidCliente(null);
            }
      } catch (NoResultException fe){
      // splatas - inc.19775 - 05/06/2006
      UtilidadesLog.debug("FinderException = " + fe);
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( 
          CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
		DAOMSG daoMSG = new DAOMSG();
		respuesta = daoMSG.obtenerListaConsultoras(dtoin);

		if (respuesta == null || respuesta.esVacio()){
      UtilidadesLog.debug("RecordSet vacio. Se va a lanzar excepcion");

			throw new MareException(new Exception(), 
				UtilidadesError.armarCodigoError(
          CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
        
    UtilidadesLog.info("MONConsultorasBean.buscarListaConsultoras(DTOBuscarConsultoras DTOE): Salida");
        		
		return (new DTOSalida(respuesta));		
	}

	public DTOSalida consultarConsultoras(DTOBuscarConsultoras DTOE) 
		throws MareException {

        UtilidadesLog.info("MONConsultorasBean.consultarConsultoras(DTOBuscarConsultoras DTOE): Entrada");

		DTOBuscarConsultorasOid dtoin = new DTOBuscarConsultorasOid();
		MensajesLocalHome msjLHome = null;
		ClienteDatosBasicosLocalHome cdbLHome = null;
		RecordSet respuesta = null;
		
		dtoin.setOidPais( DTOE.getOidPais() );
		dtoin.setCodMensaje( DTOE.getCodMensaje() );
		
		try{
			msjLHome = new MensajesLocalHome();
			cdbLHome = new ClienteDatosBasicosLocalHome();

			//dtoin.setOidMensaje( msjLHome.findByUk(DTOE.getOidPais(), DTOE.getCodMensaje()).getOid() );

			if ( DTOE.getCodCliente()!= null && 
					!("".equals(DTOE.getCodCliente())) ){
				dtoin.setOidCliente( cdbLHome.findByCodigoYPais(DTOE.getOidPais(), DTOE.getCodCliente()).getOid() );
			} else {
				dtoin.setOidCliente( null );
			}
		}  catch (NoResultException fe){
            UtilidadesLog.debug(fe);
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}catch (PersistenceException e) {
                    UtilidadesLog.error(e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
		
		DAOMSG daoMSG = new DAOMSG();		
		respuesta = daoMSG.consultarConsultoras(dtoin);

		if (respuesta == null || respuesta.esVacio()){
            UtilidadesLog.debug("RecordSet vacio. Se va a lanzar excepcion.");
        
			throw new MareException(new Exception(), 
				UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
        
        UtilidadesLog.info("MONConsultorasBean.consultarConsultoras(DTOBuscarConsultoras DTOE): Salida");
        		
		return (new DTOSalida(respuesta));			
	}

	public void insertarDatosConsultora(DTODatosConsultora DTOE) throws MareException {

        UtilidadesLog.info("MONConsultorasBean.insertarDatosConsultora(DTODatosConsultora DTOE): Entrada");

		ClienteDatosBasicosLocalHome cdbLHome = null;
		BuzonMensajesLocalHome bmLHome = null;
		BuzonMensajesLocal bmLocal = null;
		
		try{
			cdbLHome = new ClienteDatosBasicosLocalHome();
			bmLHome = getBuzonMensajesLocalHome();
			bmLHome.parametrosAuditoria( DTOE);		

			if (DTOE.getOidCliente()==null){
				DTOE.setOidCliente( cdbLHome.findByCodigoYPais(DTOE.getOidPais(), DTOE.getCodCliente()).getOid() );
			}

			if (DTOE.getOidCliente()!=null){
				Long numeroSecuencia = new Long(
											new DAOMSG().obtenerNumeroSecuencial(
																DTOE.getOidMensaje(), 
																DTOE.getOidCliente(), 
																DTOE.getOidPais()).longValue() + 
																1);
			
				bmLocal = bmLHome.create( numeroSecuencia,
								DTOE.getOidCliente(),
								DTOE.getOidMensaje(),
								new Long(ConstantesSEG.MODULO_MSG) );

				bmLocal.setActivo( new Long(ConstantesMSG.IND_ACTIVO.longValue()) );
				bmLocal.setEstadoMensaje( new Long(ConstantesMSG.IND_INACTIVO.longValue()) );
				bmLocal.setFechaGrabacion( new Timestamp(System.currentTimeMillis()));
				bmLocal.setEsConsultora( new Long(1) );

				bmLocal.setDatoVariable1( DTOE.getNombreApellidos() );
				bmLocal.setDatoVariable2( DTOE.getDatoVariable2() );
				bmLocal.setDatoVariable3( DTOE.getDatoVariable3() );
				bmLocal.setDatoVariable4( DTOE.getDatoVariable4() );
				bmLocal.setDatoVariable5( DTOE.getDatoVariable5() );
				bmLocal.setDatoVariable6( DTOE.getDatoVariable6() );
				bmLocal.setDatoVariable7( DTOE.getDatoVariable7() );
				bmLocal.setDatoVariable8( DTOE.getDatoVariable8() );
				bmLocal.setDatoVariable9( DTOE.getDatoVariable9() );
				bmLocal.setDatoVariable10( DTOE.getDatoVariable10() ); 
			}
	
		} catch (NamingException ne){
            UtilidadesLog.error(ne);
			ctx.setRollbackOnly();
			throw new MareException(ne, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch (NoResultException fe){
                        UtilidadesLog.debug(fe);
			ctx.setRollbackOnly();
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_MSG + ErroresDeNegocio.MSG_0014 ));
		} catch (CreateException ce){
            UtilidadesLog.error(ce);
			ctx.setRollbackOnly();
			throw new MareException(ce, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS ));
		}
        
        UtilidadesLog.info("MONConsultorasBean.insertarDatosConsultora(DTODatosConsultora DTOE): Salida");
        
	}

	public DTODatosConsultora obtenerDatosConsultora(DTOOID DTOE) throws MareException {
    
        UtilidadesLog.info("MONConsultorasBean.obtenerDatosConsultora(DTOOID DTOE): Entrada");
    
		ClienteDatosBasicosLocalHome cdbLHome = null;
		BuzonMensajesLocalHome bmLHome = null;
		BuzonMensajesLocal bmLocal = null;
		DTODatosConsultora dtoConsultora = new DTODatosConsultora();
		
		try{
			cdbLHome = new ClienteDatosBasicosLocalHome();
			bmLHome = getBuzonMensajesLocalHome();
			bmLocal = bmLHome.findByPrimaryKey( DTOE.getOid() );

			dtoConsultora.setOidBuzon( bmLocal.getOid() );
			dtoConsultora.setOidMensaje( bmLocal.getOidMensaje() );
			dtoConsultora.setOidCliente( bmLocal.getOidCliente() );

			dtoConsultora.setCodCliente( 
				cdbLHome.findByPrimaryKey( bmLocal.getOidCliente() ).getCod_clie() );
				
			dtoConsultora.setNombreApellidos( bmLocal.getDatoVariable1() );
			dtoConsultora.setDatoVariable2( bmLocal.getDatoVariable2() );
			dtoConsultora.setDatoVariable3( bmLocal.getDatoVariable3() );
			dtoConsultora.setDatoVariable4( bmLocal.getDatoVariable4() );
			dtoConsultora.setDatoVariable5( bmLocal.getDatoVariable5() );
			dtoConsultora.setDatoVariable6( bmLocal.getDatoVariable6() );
			dtoConsultora.setDatoVariable7( bmLocal.getDatoVariable7() );
			dtoConsultora.setDatoVariable8( bmLocal.getDatoVariable8() );
			dtoConsultora.setDatoVariable9( bmLocal.getDatoVariable9() );
			dtoConsultora.setDatoVariable10( bmLocal.getDatoVariable10() );

            UtilidadesLog.info("MONConsultorasBean.obtenerDatosConsultora(DTOOID DTOE): Salida");

			return dtoConsultora;
		} catch (NamingException ne){
            UtilidadesLog.error(ne);
			throw new MareException(ne, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch (FinderException fe){
            UtilidadesLog.debug(fe);
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ));
		}
	}

	public void modificarDatosConsultora(DTODatosConsultora DTOE) throws MareException {
    
        UtilidadesLog.info("MONConsultorasBean.modificarDatosConsultora(DTODatosConsultora DTOE): Entrada");
    
		ClienteDatosBasicosLocalHome cdbLHome = null;
		BuzonMensajesLocalHome bmLHome = null;
		BuzonMensajesLocal bmLocal = null;
		
		try{
			bmLHome = getBuzonMensajesLocalHome();
			bmLHome.parametrosAuditoria( DTOE);		

			bmLocal = bmLHome.findByPrimaryKey( DTOE.getOidBuzon() );

			if (bmLocal.getActivo()!=null && 
				bmLocal.getActivo().longValue() == 1 &&
				bmLocal.getEstadoMensaje()!=null && 
				bmLocal.getEstadoMensaje().longValue() == 0){

				if (DTOE.getCodCliente()!=DTOE.getCodClienteOld()){
					cdbLHome = new ClienteDatosBasicosLocalHome();
					DTOE.setOidCliente( cdbLHome.findByCodigoYPais(DTOE.getOidPais(), DTOE.getCodCliente() ).getOid() );

					Long numeroSecuencia = new Long(
										new DAOMSG().obtenerNumeroSecuencial(
															DTOE.getOidMensaje(), 
															DTOE.getOidCliente(), 
															DTOE.getOidPais()).longValue() + 
															1);
															
					bmLocal.setNumeroSecuencial( numeroSecuencia );
					bmLocal.setOidCliente(DTOE.getOidCliente());
				}

				bmLocal.setDatoVariable1( DTOE.getNombreApellidos() );
				bmLocal.setDatoVariable2( DTOE.getDatoVariable2() );
				bmLocal.setDatoVariable3( DTOE.getDatoVariable3() );
				bmLocal.setDatoVariable4( DTOE.getDatoVariable4() );
				bmLocal.setDatoVariable5( DTOE.getDatoVariable5() );
				bmLocal.setDatoVariable6( DTOE.getDatoVariable6() );
				bmLocal.setDatoVariable7( DTOE.getDatoVariable7() );
				bmLocal.setDatoVariable8( DTOE.getDatoVariable8() );
				bmLocal.setDatoVariable9( DTOE.getDatoVariable9() );
				bmLocal.setDatoVariable10( DTOE.getDatoVariable10() ); 				

			} else {
				throw new MareException(null,null,
					UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_MSG + ErroresDeNegocio.MSG_0017 ));
			}

		} catch (NamingException ne){
            UtilidadesLog.error(ne);
			ctx.setRollbackOnly();
			throw new MareException(ne, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch (FinderException fe){
            UtilidadesLog.debug(fe);
			ctx.setRollbackOnly();
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_MSG + ErroresDeNegocio.MSG_0014 ));
		}
        
        UtilidadesLog.info("MONConsultorasBean.modificarDatosConsultora(DTODatosConsultora DTOE): Salida");
	}

	public void eliminarDatosConsultora(DTOOIDs DTOE) throws MareException {
    
        UtilidadesLog.info("MONConsultorasBean.eliminarDatosConsultora(DTOOIDs DTOE): Entrada");
    
		BuzonMensajesLocalHome bmLHome = null;
		BuzonMensajesLocal bmLocal = null;
		
		try{
			bmLHome = getBuzonMensajesLocalHome();
			bmLHome.parametrosAuditoria(DTOE);
			
			Iterator it = Arrays.asList( DTOE.getOids() ).iterator(); //de Long's

			while (it.hasNext()) {
				bmLocal = bmLHome.findByPrimaryKey( (Long) it.next() );
				if (bmLocal.getActivo()!=null && 
					bmLocal.getActivo().longValue()==1 && 
					bmLocal.getEstadoMensaje() != null &&
					bmLocal.getEstadoMensaje().longValue()== 0){
					bmLocal.remove();
				} else{
					throw new MareException(null,null,
						UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_MSG + ErroresDeNegocio.MSG_0017 ));
				}
			}

		} catch (NamingException ne){
            UtilidadesLog.error(ne);
			ctx.setRollbackOnly();
			throw new MareException(ne, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch (FinderException fe){
            UtilidadesLog.debug(fe);
			ctx.setRollbackOnly();
			throw new MareException(fe, 
				UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_MSG + ErroresDeNegocio.MSG_0006 ));
		} catch (RemoveException re){
            UtilidadesLog.error(re);
			ctx.setRollbackOnly();
			throw new MareException(re, 
				UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_BORRADO_DE_DATOS ));
		}
        
        UtilidadesLog.info("MONConsultorasBean.eliminarDatosConsultora(DTOOIDs DTOE): Salida");
        
	}


    private BuzonMensajesLocalHome getBuzonMensajesLocalHome() throws NamingException {
		final InitialContext context = new InitialContext();
		return (BuzonMensajesLocalHome)context.lookup("java:comp/env/BuzonMensajes");
	}
}