/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesLog;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.dtos.bel.DTOEBuscarFormasPagoDetalle;
import es.indra.sicc.dtos.bel.DTOFormaPagoDetalle;
import es.indra.sicc.dtos.bel.DTOEDetalleFormaPago;

import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.entidades.bel.FormaPagoDetalleLocal;
import es.indra.sicc.entidades.bel.FormaPagoDetalleLocalHome;

import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.logicanegocio.cra.MONMantenimientoActividad;
import es.indra.sicc.logicanegocio.cra.MONMantenimientoActividadHome;

import java.util.Collection;
import java.util.Iterator;
import java.rmi.RemoteException;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONMantenimientoFormasPagoDetalleBean implements SessionBean  {
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
		this.ctx=ctx;
	}

	/** 
     * Método para buscar detalles de formas de Pago
     * @param dto DTOEBuscarFormasPagoDetalle con los atributos por los que se filtrará la busqueda
     * @return DTOSalida con los detalles de las formas de pago
     * @exception MareException 
     */
	public DTOSalida buscarFormasPagoDetalle(DTOEBuscarFormasPagoDetalle dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.buscarFormasPagoDetalle(DTOEBuscarFormasPagoDetalle dto):Entrada");
		DTOSalida salida=null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOFormasPagoDetalle daoFormasPagoDetalle=new DAOFormasPagoDetalle(usuario);
		salida=daoFormasPagoDetalle.buscarFormasPagoDetalle(dto);
		if(salida==null){
			salida=new DTOSalida(new RecordSet());
		}
        if (salida.getResultado().esVacio()) {
            //GEN-0007 --> 005
          	UtilidadesLog.debug("****buscarFormasPagoDetalle: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.buscarFormasPagoDetalle(DTOEBuscarFormasPagoDetalle dto):Salida");
		return salida;	
	}	

	/** 
     * Método para consultar un detalle de una forma de Pago
     * @param dto DTOOID con el oid del detalle a consultar
     * @return DTOFormaPagoDetalle con los datos del detalle
     * @exception MareException 
     */	
	public DTOFormaPagoDetalle consultarFormaPagoDetalle(DTOOID dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.consultarFormaPagoDetalle(DTOOID dto):Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOFormasPagoDetalle daoFormasPagoDetalle=new DAOFormasPagoDetalle(usuario);		
		RecordSet rs=daoFormasPagoDetalle.consultarFormaPagoDetalle(dto);
		if(rs==null&&rs.esVacio()){
			return null;
		}
		DTOFormaPagoDetalle dtoFormaPagoDetalle=new DTOFormaPagoDetalle();
		if(rs.getValueAt(0,0)!=null){
			dtoFormaPagoDetalle.setOidFormaPagoDetalle(new Long(rs.getValueAt(0,0).toString()));
		}
		if(rs.getValueAt(0,1)!=null){
			dtoFormaPagoDetalle.setOidMedioPago(new Long(rs.getValueAt(0,1).toString()));
		}
		if(rs.getValueAt(0,2)!=null){
			dtoFormaPagoDetalle.setDescripcionMedioPago(rs.getValueAt(0,2).toString());
		}
		if(rs.getValueAt(0,3)!=null){
			dtoFormaPagoDetalle.setPorcentajePago(new Integer(rs.getValueAt(0,3).toString()));
		}
		if(rs.getValueAt(0,4)!=null){
			dtoFormaPagoDetalle.setIndicadorDeDias(new Character(rs.getValueAt(0,4).toString().charAt(0)));
		}
		if(rs.getValueAt(0,5)!=null){
			dtoFormaPagoDetalle.setNumeroDeDias(new Integer(rs.getValueAt(0,5).toString()));
		}
		if(rs.getValueAt(0,6)!=null){
			dtoFormaPagoDetalle.setOidMarca(new Long(rs.getValueAt(0,6).toString()));
		}
		if(rs.getValueAt(0,7)!=null){
			dtoFormaPagoDetalle.setDescripcionMarca(rs.getValueAt(0,7).toString());
		}
		if(rs.getValueAt(0,8)!=null){
			dtoFormaPagoDetalle.setOidCanal(new Long(rs.getValueAt(0,8).toString()));
		}
		if(rs.getValueAt(0,9)!=null){
			dtoFormaPagoDetalle.setDescripcionCanal(rs.getValueAt(0,9).toString());
		}
		if(rs.getValueAt(0,10)!=null){
			dtoFormaPagoDetalle.setOidActividad(new Long(rs.getValueAt(0,10).toString()));
		}
		if(rs.getValueAt(0,11)!=null){
			dtoFormaPagoDetalle.setDescripcionActividad(rs.getValueAt(0,11).toString());
		}		
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.consultarFormaPagoDetalle(DTOOID dto):Salida");
		return dtoFormaPagoDetalle;	
		
	}

	/** 
     * Método para consultar los detalles de una forma de Pago
     * @param dto DTOOID con el oid de la forma de pago cuyos detalles queremos consultar
     * @return DTOSalida con los detalles de la forma de pago
     * @exception MareException 
     */	
	public DTOSalida consultarDetalleFormaPago(DTOOID dto) throws MareException{
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.consultarDetalleFormaPago(DTOOID dto):Entrada");
		RecordSet salida=null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOFormasPagoDetalle daoFormasPagoDetalle=new DAOFormasPagoDetalle(usuario);
		salida=daoFormasPagoDetalle.consultarDetalleFormaPago(dto);
		if(salida==null){
			salida=new RecordSet();
		}
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.consultarDetalleFormaPago(DTOOID dto):Salida");
		return new DTOSalida(salida);	
	}

	/** 
     * Método para insertar/modificar los detalles de una forma de Pago
     * @param dto DTOEDetalleFormaPago con los datos de los detalles de la forma de pago y el oid de la forma de pago
     * @exception MareException 
     */	
	public void guardarDetalleFormaPago(DTOEDetalleFormaPago dto) throws MareException{
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.guardarDetalleFormaPago(DTOEDetalleFormaPago dto):Entrada");
		/*Entrada: DTOEDetalleFormaPago 
		- oidFormaPagoCabecera : Long 
		- listaRegistrosDetalle : arrayList 
		Proceso: 
		-> Hacer un Delete JDBC sobre la tabla BEL_FORMA_PAGO_DETAL filtrando por el campo FOPA_OID_FORM_PAGO = dto.oidFormaPagoCabecera 
		-> Recorrer arrayList contenido en el dto de entrada 
		Para cada objeto DTOFormaPagoDetalle contenido en el array hacer: 
		-> Hacer create sobre la entidad FormaPagoDetalle con los datos del dto de turno usando como oid de forma de pago cabecera el atributo oidFormaPagoCabecera del dto de entrada. 
		-> No tener en cuenta los siguientes atributos del dto: descripcionMedioPago, oidMarca, descripcionMarca, oidCanal, descripcionCanal y descripcionActividad. 
		Fin Para */
		this.validaAcceso(dto.getOidPais(),null,null,null,null,null,null,null,null);
		FormaPagoDetalleLocalHome formaPagoDetalleLocalHome = this.getFormaPagoDetalleLocalHome();
		try {
			Collection formaPagoDetalles = formaPagoDetalleLocalHome.findByFormaPagoCabecera(dto.getOidFormaPagoCabecera());
			if(!formaPagoDetalles.isEmpty()) {
				Iterator formaPagoDetallesIterator = formaPagoDetalles.iterator();
				while (formaPagoDetallesIterator.hasNext()) {
					FormaPagoDetalleLocal formaPagoDetalle = (FormaPagoDetalleLocal)formaPagoDetallesIterator.next();
					formaPagoDetalleLocalHome.remove(formaPagoDetalle);
				}
			}
		} catch(NoResultException e){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			this.logearError("guardarDetalleFormaPago: FinderException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
		} catch(PersistenceException e){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logearError("guardarDetalleFormaPago: RemoveException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
		}
		/*
		 * -> Recorrer arrayList contenido en el dto de entrada 
		Para cada objeto DTOFormaPagoDetalle contenido en el array hacer: 
		-> Hacer create sobre la entidad FormaPagoDetalle con los datos del dto de turno usando como oid de forma de pago cabecera el atributo oidFormaPagoCabecera del dto de entrada. 
		-> No tener en cuenta los siguientes atributos del dto: descripcionMedioPago, oidMarca, descripcionMarca, oidCanal, descripcionCanal y descripcionActividad. 
		*/
		Object lista[] = dto.getListaRegistrosDetalle().toArray();
		try {
			for (int i = 0; i < lista.length; i++) {
				DTOFormaPagoDetalle detalle = (DTOFormaPagoDetalle)lista[i];
				FormaPagoDetalleLocal formaPagoDetalle = formaPagoDetalleLocalHome.create(dto.getOidFormaPagoCabecera(), detalle.getPorcentajePago(), detalle.getIndicadorDeDias(), new Integer(i+1), detalle.getOidMedioPago(), detalle.getOidActividad(), detalle.getNumeroDeDias());
			}
		} catch(PersistenceException e){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logearError("guardarDetalleFormaPago: CreateException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
		}		
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.guardarDetalleFormaPago(DTOEDetalleFormaPago dto):Salida");
	}
	/**
	 * Metodo para recargar el combo actividad y envolver la excepcion que se lanza al no encontrar datos
	 * @param DTOActividad dto con los datos de marca y canal 
	 * @exception MareException
	 * @return DTOSalida con los valores que se rellenará el combo 
	 */
	 public DTOSalida recargaComboActividades(DTOActividad dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.recargaComboActividades(DTOActividad dto):Entrada");
		MONMantenimientoActividad monMantenimientoActividad = this.getMantenimientoActividad();
		DTOSalida dtoSalida = new DTOSalida(new RecordSet());
		try{
			dtoSalida = monMantenimientoActividad.obtieneActividades(dto);
			
		}catch(RemoteException e){
			
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("recargaComboActividades: MareException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
		}
		catch(MareException e){
			int codigoDevuelto=e.getCode();
			int codigoComparar=UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
			if(codigoDevuelto!=codigoComparar){
				this.logearError("recargaComboActividades: MareException",e);
				throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)); 
			}
		}
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.recargaComboActividades(DTOActividad dto):Salida");
		return dtoSalida;
	}
	
    private void validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio) throws  MareException {
        UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Entrada");
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = new Boolean(true);

		UtilidadesLog.debug("****Llamada a validaAcceso(pais= "+ pais+", marca="+marca+", canal= "+canal+", acceso="+acceso+", subgerencia="+subgerencia+", region="+region+", zona="+zona+", seccion="+seccion+", territorio="+territorio);
		try{
			b = monValidacion.validarAccesos( pais, null, marca, canal, acceso, null, subgerencia, region, zona, seccion, territorio);
		}catch(RemoteException rExc){
			ctx.setRollbackOnly();
			UtilidadesLog.error("****Metodo validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB) );			
		}
		UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());
		if (!b.booleanValue()){				
			ctx.setRollbackOnly();
			UtilidadesLog.error("****Metodo validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
		}
		UtilidadesLog.info("MONMantenimientoFormasPagoDetalleBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Salida");
   }

	private MONMantenimientoActividad getMantenimientoActividad() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  getMantenimientoActividad: Entrada");				
        MONMantenimientoActividadHome home = (MONMantenimientoActividadHome)UtilidadesEJB.getHome(
            "MONMantenimientoActividad", MONMantenimientoActividadHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoActividad ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMantenimientoActividad",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.debug("****Metodo  getMantenimientoActividad: Salida");		        
        return ejb;
	}

    private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  getMONValidacion: Entrada");				
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONValidacion",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.debug("****Metodo  getMONValidacion: Salida");		        
        return ejb;
	}
	
	private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		UtilidadesLog.error(e);
	}

	private void logearStackTrace(Throwable e){
		try{						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			UtilidadesLog.error(pila.toString());
		}catch(Exception ex){
			UtilidadesLog.error("Error Logeando Pila: "+ex.getMessage());
		}			
	}

    private FormaPagoDetalleLocalHome getFormaPagoDetalleLocalHome() {
        return new FormaPagoDetalleLocalHome();
    } 

}
