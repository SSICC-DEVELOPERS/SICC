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

package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.ccc.DTOBuscarReclamos;
import es.indra.sicc.dtos.ccc.DTONumeroReclamo;
import es.indra.sicc.dtos.ccc.DTOReclamo;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocal;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocalHome;
import es.indra.sicc.entidades.ccc.RecepcionReclamosLocal;
import es.indra.sicc.entidades.ccc.RecepcionReclamosLocalHome;
import es.indra.sicc.logicanegocio.bel.MONGestionMedioPagoBelCenter;
import es.indra.sicc.logicanegocio.bel.MONGestionMedioPagoBelCenterHome;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.ccc.DAORegularizacion;
import es.indra.sicc.logicanegocio.ccc.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.men.MONUsuarios;
import es.indra.sicc.logicanegocio.men.MONUsuariosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Vector;

import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONRegularizacionPagosBean implements SessionBean  {

	private final static String MON_VALIDACION = "MONValidacion";
	private final static String MON_MANTENIMIENTO_SEG = "MONMantenimientoSEG";
	private final static String MON_CLIENTES = "MONClientes";
	private final static String MON_GESTION_MEDIO_PAGO = "MONGestionMedioPagoBelCenter";
	//private final static String SITUACION_RECLAMO = "CCC_SITUA_RECLA";

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

	public void guardarReclamo(DTOReclamo dto) throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.guardarReclamo(DTOReclamo dto): Entrada");
		UtilidadesLog.debug("****Metodo  dto que entra"+ dto);
		/* Llamamos a MONValidacion.validarAcceso pasandole los elementos del 
		 * dto: pais, canal, acceso y subacceso (el resto de parametros van a 
		 * null. 
		 * Si nos devuelve false lanzamos una MareException con el código de 
		 * error GEN_0008 
		 * monValidacion.validarAccesos( pais, sociedad, marca, canal, acceso, 
		 * 								subAcceso, subgerencia, region, zona, 
		 *                              seccion,territorio).
		 */		
     
    UtilidadesLog.debug("**** Llamando a validarAccesos");
		MONValidacion monValidacion = this.getMONValidacion();
		try{
			if( !(monValidacion.validarAccesos(dto.getOidPais(),
												null,
												null,
												dto.getOidCanal(),
												dto.getOidAcceso(), 
												dto.getOidSubacceso(),
												null, null, 
												null, null,null)).booleanValue()){
				UtilidadesLog.error("guardarReclamo: validarAccesos: CodigosError.ERROR_ASOCIACION_ESTRUCTURAL");
				throw new MareException(new Exception(), 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
			 }
		}catch(RemoteException re){
			UtilidadesLog.error(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
		}
		
		/* Llamamos a MONValidacion.validarVinculos, pasandole los parametros 
		 * pais, sociedad(empresa), canal, acceso y subacceso de dto, el resto 
		 * de parametros van a null. Si no devuelve false lanzamos una 
		 * MareException con el código de error GEN-0013 ("La jerarquía de 
		 * vínculos seleccionada no es válida") 
		 * public Boolean validarVinculos(Long Pais, Long Sociedad, Long Marca,
		 * Long Canal, Long Acceso, Long Subacceso)*/
	 
     UtilidadesLog.debug("**** Llamando a validarVinculos");
		 try{
			if( !(monValidacion.validarVinculos(dto.getOidPais(),
												dto.getOidEmpresa(),
												null,
												dto.getOidCanal(),
												dto.getOidAcceso(),
												dto.getOidSubacceso())).booleanValue()){
				UtilidadesLog.error("guardarReclamo: validarVinculos: CodigosError.ERROR_VINCULOS_INVALIDOS");
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULOS_INVALIDOS) );
			 }
		}catch(RemoteException re){
			UtilidadesLog.error(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
	
		/* //Validamos Movimiento Cuenta Corriente 
			si (dto.oidSubacceso, dto.numeroIdentificadorCuota, 
			dto.ejercicioCuota o dto.numeroOrdenCuota son != null) { 
---------	csanchezh como ahora son obligatorios en la pagina no haria faltta este if------
			Hacemos un findByUK del entity MovimientosCuentasCorrientes pasandole los 
			parametros del dto: dto.pais, dto.oidSubacceso, dto.numeroIdentificadorCuota, dto.ejercicioCuota, dto.numeroOrdenCuota. 
			Llenamos dto.oidMovimientoCC con la entidad obtenida. 

			Si capturamos un finderException lanzamos una MareException con el siguiente código de mensaje: CCC-0012 (No existe el movimiento de cuentas corrientes al que se hace referencia) 

		 * 
		 * 
		 * Si capturamos un finderException lanzamos una MareException con el
		 * siguiente código de mensaje: CCC-0012 (No existe el movimiento de 
		 * cuentas corrientes al que se hace referencia) } 
		 */


		
	  
		/* AÑADIDO POR INCIDENCIA 10612
		//Validamos Movimiento Cuenta Corriente
		Si dto.numeroIdentificadorCuota != null {
		Hacemos un findByUK del entity MovimientosCuentasCorrientes pasandole los parametros del dto: dto.pais,
		dto.oidSubacceso, dto.numeroIdentificadorCuota, dto.ejercicioCuota, dto.numeroOrdenCuota.
		Llenamos dto.oidMovimientoCC con la entidad obtenida.
		Si capturamos un finderException lanzamos una MareException con el siguiente código de mensaje: CCC-0053
		"Movimiento en cuenta corriente introducido no existe o no pertenece al código cliente".*/
    
    UtilidadesLog.debug("**** Antes de MovimientosCuentasCorrientesLocal");    
    
		MovimientosCuentasCorrientesLocal localMovimientosCC = null;
		Long oidMovimiento = null;
		if ( dto.getNumeroIdentificadorCuota()!=null ) {
      UtilidadesLog.debug("**** Llamando a MovimientosCuentasCorrientesLocal.findByUK");    
			MovimientosCuentasCorrientesLocalHome home = this.getMovimientosCuentasCorrientesLocalHome();
			try{//Long subacceso,String ejercicioCuota,Integer numeroIdentificadorCuota, Integer numeroOrdenCuota
				localMovimientosCC = home.findByUK(dto.getOidSubacceso(),
												dto.getEjercicioCuota(),
												dto.getNumeroIdentificadorCuota(),
												dto.getNumeroOrdenCuota(),
                                                dto.getOidPais()); //añaddido BELC300018543
				UtilidadesLog.debug("&&& localMovimientosCC: " + localMovimientosCC);
				oidMovimiento = localMovimientosCC.getOid();
				UtilidadesLog.debug("&&& oidMovimiento: " + oidMovimiento);
        
        UtilidadesLog.debug("**** Seteando OidMovimientoCC");    
        UtilidadesLog.debug("**** localMovimientosCC.getOid()" + localMovimientosCC.getOid());    
        dto.setOidMovimientoCC(localMovimientosCC.getOid());        
			}catch(FinderException fe) {
				UtilidadesLog.debug("*** FinderException: En localMovimientosCC = home.findByUK" );
				this.loguearError(fe);
				throw new MareException(fe,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                        ErroresDeNegocio.MOV_CC_NO_EXISTE_O_NO_PERTENECE_A_COD_CLIENT));
			}
			//Ponemos finderException por la incidencia 10612
			catch(Exception fe) {//quito finder porque puede lanzar tambien otras excepciones EjbException Por ejemplo.
				UtilidadesLog.debug("*** Exception: En localMovimientosCC = home.findByUK" );
				this.loguearError(fe);
				throw new MareException(fe,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                        ErroresDeNegocio.MOVIMIENTO_CUENTAS_INEXISTENTE));
				//throw new MareException(null, new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", es.indra.sicc.logicanegocio.ccc.ErroresDeNegocio.CCC_0012));
			}
			
		}
    
		/* Si en el dto el atributo oid es null llamamos al create del entity 
		 * RecepcionReclamos, si no hacemos un findByPrimaryKey. Luego 
		 * rellenamos los atributos con los atributos correspondientes del dto.
		 * Además de poner en los atributos cargoAbono y movimiento los oid de
		 * los entitys correspondientes que buscamos anteriormente o null si no
		 * los buscamos). 	
		 */
		 /* Si el oid es null rellenamos el atributo numero llamamos a 
		 * obtenerSiguienteNumero del DAORegularizacion pasandole el pais del 
		 * dto. 
		 * Para rellenar el atributo consultoraReclamante llamamos a 
		 * IMaestroClientes.obtenerOidCliente pasandole el dto.codigoCliente. 
		 * Si obtenemos null lanzamos una MareException con el código de error 
		 * MAE-0024 (El código de cliente introducido no es válido). 
		 */
     
    UtilidadesLog.debug("**** Antes de RecepcionReclamosLocalHome");
		RecepcionReclamosLocalHome homeReclamos = this.getRecepcionReclamosLocalHome();
		MONClientes monClientes = this.getMONClientes();
		Long consultoraReclamante = null;
    
    UtilidadesLog.debug("**** Antes de monClientes.obtenerOidCliente" + 
    dto.getCodigoClienteReclamante());
    
		if(dto.getCodigoClienteReclamante()!=null){
			try{
        UtilidadesLog.debug("**** Llamando a obtenerOidCliente");    
				consultoraReclamante = monClientes.obtenerOidCliente(dto.getOidPais(),dto.getCodigoClienteReclamante());
			} catch(RemoteException re){
				this.loguearError(re);
				throw new MareException(re,
						UtilidadesError.armarCodigoError(
							CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}//catch
		}//if getCodigoClienteReclamante
    
    UtilidadesLog.debug("**** consultoraReclamante " +
     consultoraReclamante);    
		if (consultoraReclamante == null) {
			UtilidadesLog.error("guardarReclamo: Código cliente introducido no válido");
			UtilidadesLog.error("Código cliente introducido no válido ");
				throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "",
                        es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0024));			
		} else {
            UtilidadesLog.debug("**** Seteando OidClienteReclamante");    
            dto.setOidClienteReclamante(consultoraReclamante);
        }
		/*Si el cliente de la entidad obtenida no es igual a oidClienteReclamante lanzamos una MareException con el
		siguiente código de mensaje: CCC-0053 "Movimiento en cuenta corriente introducido no existe o no pertenece al
		código cliente".*/
    
    UtilidadesLog.debug("**** Antes de comparar OidClienteReclamante");    
    if(localMovimientosCC!=null) {
      if (dto.getOidClienteReclamante().longValue()!= localMovimientosCC.getCliente().longValue()){
        Exception fe= null;
        throw new MareException(fe, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
        ErroresDeNegocio.MOV_CC_NO_EXISTE_O_NO_PERTENECE_A_COD_CLIENT));
      }      
    }
		
		String usuario = ctx.getCallerPrincipal().getName();
		dto.setUsuarioSolicitante(usuario);
    
    UtilidadesLog.debug("**** Antes de preguntar por oid " + dto.getOid());    
		if (dto.getOid()==null) {			
      UtilidadesLog.debug("**** oid null");    
			//DAORegularizacion daoRegularizacion = new DAORegularizacion(usuario);
			//DTONumeroReclamo dtoN= new DTONumeroReclamo();
			//dtoN=daoRegularizacion.obtenerSiguienteNumero(dto.getOidPais(),dto.getOidIdioma());
			//Date fechaRecPrevista = null;
			//if (dto.getFechaResolucionPrevista()!=null) {
			//	fechaRecPrevista = new Date(dto.getFechaResolucionPrevista().getTime());
			//}
      
      UtilidadesLog.debug("**** 1");    
			dto.setOidSituacion(new Long(CCCConstantes.RECLAMO_SITUACION_SOLICITADO));
			Timestamp fechaRecReal = null;			
      
      UtilidadesLog.debug("**** 2");    
			if (dto.getFechaResolucionReal()!=null) {
				fechaRecReal = new Timestamp(dto.getFechaResolucionReal().getTime());
			}
			try{			
				Timestamp fechaDocumento = null;
        
        UtilidadesLog.debug("**** 3");    
				if (dto.getFechaDocumento()!=null){
					// Este campo es obligatorio, pero mejor una create exception que un nullPointer
					fechaDocumento =  new Timestamp(dto.getFechaDocumento().getTime());
					//fecha= new java.sql.Date(dto.getFechaDocumento().getTime());
				}
				Date fechaRPrevista=null;
				if(dto.getFechaResolucionPrevista()!=null){
					fechaRPrevista=new Date(dto.getFechaResolucionPrevista().getTime());
				}
				
				UtilidadesLog.info("[cs]DTOcreate " + dto);
				
				UtilidadesLog.info("[cs]consultoraReclamante= "+consultoraReclamante);
				//this.getLog().error("[cs]fechaRecPrevista= "+fechaRecPrevista);
				UtilidadesLog.info("[cs]fechaRecReal= "+fechaRecReal);
				UtilidadesLog.info("[cs]oidMovimiento= "+oidMovimiento);
				UtilidadesLog.info("[cs]fechaDocumento= "+fechaDocumento);
				UtilidadesLog.info("[cs]dto.getAnio()= "+dto.getAnio());
				UtilidadesLog.info("[cs]dto.getMes()()= "+dto.getMes());
				UtilidadesLog.info("[cs]dto.getOidEmpresa()= "+dto.getOidEmpresa());
				UtilidadesLog.info("[cs]dto.getOidPeriodoReclamante()= "+dto.getOidPeriodoReclamante());
				UtilidadesLog.info("[cs]dto.getOidSituacion()= "+dto.getOidSituacion());
				UtilidadesLog.info("[cs]dto.getOidCanal()= "+dto.getOidCanal());
				UtilidadesLog.info("[cs]dto.getOidSucursal()= "+dto.getOidSucursal());


        UtilidadesLog.debug("**** Antes del create en RecepcionReclamos");    
				homeReclamos.create(dto.getNumeroIdentificacion(), //oblig.
						dto.getAnio(), //oblig.
						dto.getMes(), //oblig.
						consultoraReclamante, //oblig.
						null, //oidCargosAbonos,
						usuario, //oblig.
						dto.getObservacionesClienteReclamante(),
						dto.getObservacionesAreaReclamos(),
						fechaRPrevista,
						fechaRecReal,
						dto.getFicheroDocumentoAdjunto(),
						dto.getUsuarioGestorReclamoPrevisto(),
						dto.getUsuarioGestorReclamoReal(),
						dto.getObservacionesResolucionReclamos(),//observaciones
						dto.getOidSubacceso(),
						dto.getOidEmpresa(),//oblig.
						dto.getOidCuentaCorriente(),
						oidMovimiento,
						dto.getOidMedioPago(),
						dto.getOidMotivoRechazoDesbloqueo(),
						dto.getOidPeriodoReclamante(), //oblig.
						fechaDocumento, //oblig.
						new Double(dto.getImporteReclamado().doubleValue()),//oblig.
						dto.getOidSituacion(),//situacionRecla,//oblig.
						dto.getOidCanal(), //oblig.
						dto.getOidAcceso(),
						new java.sql.Date(dto.getFechaValor().getTime()), 
						dto.getOidPais(),
						dto.getOidSucursal());
						
			}catch(PersistenceException ce){
				this.loguearError(ce);
				ctx.setRollbackOnly();
				throw new MareException(ce, 
					UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));				
			}
			
		}else {
      UtilidadesLog.debug("**** oid distinto de null");    
			/* si (numeroCargoAbonoDirecto, anyoAbonoDirecto o 
		  * periodoMesAbonoDirecto) { 
		  * Hacemos un findByUK del entity CabeceraCargosAbonosDirectos con los
		  * parametros del dto: numeroCargoAbonoDirecto, anyoAbonoDirecto y
		  * periodoMesAbonoDirecto. 
		  * Si capturamos una finderException lanzamos una MareException con 
		  * el código de mensaje: CCC-0013 (No existe el cargo de abono directo
		  * al que se hace referencia) 
		  */
		CabeceraCargosAbonosDirectosLocal localCabecera = null;
		Long oidCargosAbonos=null;
		if (dto.getNumeroCargoAbono()!=null || 
			dto.getAnioCargoAbono()!= null || 
			dto.getMesCargoAbono()!=null) {
			CabeceraCargosAbonosDirectosLocalHome home = this.getCabeceraCargosAbonosDirectosLocalHome();
			try{
				localCabecera = home.findByUK(dto.getNumeroCargoAbono(),
											dto.getAnioCargoAbono(),
											dto.getMesCargoAbono());
				oidCargosAbonos = localCabecera.getOid();
			}catch(NoResultException fe) {
                                ctx.setRollbackOnly();
				this.loguearError(fe);
				throw new MareException(fe,
                                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                                    ErroresDeNegocio.CARGO_ABONO_DIRECTO_INEXISTENTE));
			}						
		}
			RecepcionReclamosLocal local = null;
			try{
				local = homeReclamos.findByPrimaryKey(dto.getOid());
			} catch (NoResultException fe) {
				ctx.setRollbackOnly();
				this.loguearError(fe);
                                throw new MareException(fe,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
			}
			local.setAnyo(dto.getAnio());
			local.setAcceso(dto.getOidAcceso());
			local.setCanal(dto.getOidCanal());
			local.setCargoAbono(oidCargosAbonos);
			local.setConsultoraReclamante(consultoraReclamante);
			local.setCuenta(dto.getOidCuentaCorriente());
			local.setEmpresa(dto.getOidEmpresa());
			local.setPais(dto.getOidPais());

			// Si fechaDocumento es null, el set daría error en algun momento,
			// en el ejbStore, luego mejor un nullPointer			
			local.setFechaDocumento(new Timestamp(dto.getFechaDocumento().getTime()));
			if(dto.getFechaResolucionPrevista()!=null){
				local.setFechaResolucionPrevista(new Date(dto.getFechaResolucionPrevista().getTime()));
			}else{
				local.setFechaResolucionPrevista(null);
			}
			if(dto.getFechaResolucionReal()!=null){
				local.setFechaResolucionReal(new Timestamp(dto.getFechaResolucionReal().getTime()));
			}else{
				local.setFechaResolucionReal(null);
			}
			//Double importeReclamado=new Double(dto.getImporteReclamado().doubleValue());
			
			local.setFicheroDocumentalAdjunto(dto.getFicheroDocumentoAdjunto());
			local.setImporteReclamado(new Double(dto.getImporteReclamado().doubleValue()));
			local.setMedioPago(dto.getOidMedioPago());
			local.setMotivosRechazoDesbloqueo(dto.getOidMotivoRechazoDesbloqueo());
			
			local.setMovimientoCC(oidMovimiento);
			//local.setNumero();BELC300003272
			local.setObservacionesResolucion(dto.getObservacionesResolucionReclamos());
			local.setObservacionesAreaReclamos(dto.getObservacionesAreaReclamos());
			local.setObservacionesClienteReclamante(dto.getObservacionesClienteReclamante());
			//local.setOid();
			local.setPeriodoMes(dto.getMes());
			local.setPeriodoReclamante(dto.getOidPeriodoReclamante());
			local.setSituacion(dto.getOidSituacion());
			local.setSubacceso(dto.getOidSubacceso());
			local.setUsuarioGestorPrevisto(dto.getUsuarioGestorReclamoPrevisto());
			local.setUsuarioGestorReal(dto.getUsuarioGestorReclamoReal());
			local.setUsuarioSolicitante(dto.getUsuarioSolicitante());
			local.setSucursal(dto.getOidSucursal());
			local.setFechaValor(new Date(dto.getFechaValor().getTime()));
                        homeReclamos.merge(local);
		}
    
		UtilidadesLog.info("MONRegularizacionPagosBean.guardarReclamo(DTOReclamo dto): Salida");
	}

	/*public DTOCargaInicialReclamos cargaInicial(DTOBancoSucursal dto) throws MareException {
		this.getLog().debug("****Metodo  cargaInicial: Entrada");
		// Creamos un DTOCargaInicialReclamos que rellenamos de la siguiente 
		 // manera: 
		 ///
		DTOSalida dtoSalida;
		DTOCargaInicialReclamos dtoCarga = new DTOCargaInicialReclamos();

		DTOBelcorp dtoBelcorp= new DTOBelcorp();
		dtoBelcorp.setOidIdioma(dto.getOidIdioma());
		dtoBelcorp.setOidPais(dto.getOidPais());
		/*BELC300008185     
		 * jmroldan - DT - 17/09/2004
			--------------------------
			Se ha agregado un campo DTOCargaInicialReclamos: usuarios(RecordSet) contendrá los datos para cargar todos
			los combos de usuarios: usuarioGestorPrevisto usuarioGestorReclamo y usuarioSolicitante.
			En las pantallas "BuscarReclamos", "PantallaReclamos" y "PantallaResolucionReclamo".

			A raiz del cambio anterior sustituimos en el método cargaInicial():

			DTOSalida usuarios_recordset=MEN.IUsuarios.obtenerUsuarios(dto:DTOBELCORP);
			usuarios=usuarios_recordset;
		
		 * */
		/* MONUsuarios monUsuarios = null; 
		 monUsuarios = this.getMONUsuarios();//este ya lanza una Mare
		try  {
			dtoSalida = monUsuarios.obtenerUsuarios(dtoBelcorp); 
		}catch(RemoteException e) {
			this.loguearError("obtieneClientesAsignarAptas: RemoteException",e);
			//	ctx.setRollbackOnly(); es consulta pues no se pone
			throw new MareException(e,UtilidadesError.armarCodigoError(
			CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
		}
		
		dtoCarga.setUsuarios(dtoSalida.getResultado());
		 

		/*- Creamos dos DTOCAS de SEG y rellenamos el primero con los tres 
		 * atributos a false y el segundo con los tres atributos a true. */
		/* Creamos un DTOCargaCAS tambien de SEG y metemos en el atributo todos
		 * el primer DTOCAS y el filtro el segundo, además metemos el pais y el
		 * idioma del DTOBelcorp que hemos recibido. 
		 * Con este DTOCAS llamamos a obtieneCanalAccesoSubacceso y obtenemos 
		 * un DTOCAS. 
		 * Con los recordset que obtenemos rellenamos los atributos 
		 * correspondientes: canales, accesos y subaccesos. Con la 
		 * particularidad de que les quitamos la segunda columna (la del código)
		 */

		/* BELC300003284 
		 * -Creamos dos DTOFiltroCAS de SEG y rellenamos el primero con los tres
		 * atributos a false y el segundo con los tres atributos a true. Creamos
		 * un DTOCargaCAS tambien de SEG y metemos en el atributo  todos el 
		 * primer DTOFiltroCAS y el filtro el segundo, además metemos el pais 
		 * y el idioma del DTOBelcorp que hemos recibido. Con este DTOCargaCAS
		 * llamamos a obtieneCanalAccesoSubacceso y obtenemos un DTOCAS.  
		 */
		
	/*	DTOFiltroCAS dtoFiltroCASuno = new DTOFiltroCAS();
		DTOFiltroCAS dtoFiltroCASdos = new DTOFiltroCAS();
		dtoFiltroCASuno.setBaccesos(new Boolean(false));
		dtoFiltroCASuno.setBcanales(new Boolean(false));
		dtoFiltroCASuno.setBsubaccesos(new Boolean(false));
		dtoFiltroCASdos.setBaccesos(new Boolean(true));
		dtoFiltroCASdos.setBcanales(new Boolean(true));
		dtoFiltroCASdos.setBsubaccesos(new Boolean(true));

		DTOCargaCAS dtoCargaCAS = new DTOCargaCAS();
		dtoCargaCAS.setTodos(dtoFiltroCASuno);
		dtoCargaCAS.setFiltro(dtoFiltroCASdos);
		dtoCargaCAS.setOidPais(dto.getOidPais());
		dtoCargaCAS.setOidIdioma(dto.getOidIdioma());

		MONMantenimientoSEG monManteminientoSEG = this.getMONMantenimientoSEG();
		DTOCAS dtoCAS = null;
		try{
			dtoCAS = monManteminientoSEG.obtieneCanalAccesoSubacceso(dtoCargaCAS);
		}catch(RemoteException re){
			this.loguearError("cargaInicial: RemoteException: monManteminientoSEG.obtieneCanalAccesoSubacceso=",re);
            throw new MareException(re,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		RecordSet accesos = dtoCAS.getAccesos();
		RecordSet canales = dtoCAS.getCanales();
		RecordSet subaccesos = dtoCAS.getSubaccesos();
		//Incidencia BELC300004246
		//accesos.removeColumn(1); //Eliminamos la segunda columna
		//canales.removeColumn(1);
		//subaccesos.removeColumn(1);
		
		dtoCarga.setAccesos(accesos);
		dtoCarga.setCanales(canales);
		dtoCarga.setSubaccesos(subaccesos);
		
		/* -bancos: llamamos a obtieneBancos de DAOCCC */
		/*DAOCCC daoCCC = new DAOCCC();
		dtoCarga.setBancos(daoCCC.obtieneBancos(dto));	

		/*
		 * 	-mediosPago: llamamos a obtenerMediosPagoCombo de IBELMediosPago
		 *  BELC300004723 
		 	
		MONGestionMedioPagoBelCenter monGestion = this.getMONGestionMedioPagoBelCenter();
		try{
			DTOSalida dtoMedioPago = monGestion.obtenerMediosPagoCombo(dto);
			dtoCarga.setMediosPago(dtoMedioPago.getResultado());
		}catch(RemoteException re){
			this.loguearError("cargaInicial: RemoteException: monGestion.obtenerFormasPagoPorPais",re);
            throw new MareException(re,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			
		}

		-periodos: llamamos a recuperarPeriodos de ISerivicioSEG 	
		try{
			dtoSalida = monManteminientoSEG.recuperarPeriodos(dto);
		}catch(RemoteException re) {
			this.loguearError("cargaInicial: RemoteException: monManteminientoSEG.recuperarPeriodos",re);
            throw new MareException(re,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		dtoCarga.setPeriodos(dtoSalida.getResultado());
		
		/*-motivosRechazoDesbloqueo: llamamos a obtieneMotivosRechadoDesbloqueo
		 * de la interfaz IReclamos de REC 
		DAORec daoRec = new DAORec();		
		dtoCarga.setMotivosRechazoDesbloqueo(daoRec.obtenerMotivosRechazoDesbloqueo(dto));
		
		/*-situaciones: llamamos a obtenerPosiblesSituaciones de este MON pasandole el idioma del dto 
		dtoCarga.setSituaciones(this.obtenerPosiblesSituaciones(dto.getOidIdioma()));
		
		/*-susursales: si el atributo banco del dto de entrada es null ponemos 
		 * un recordset vacio, de lo contrario llamamos a 
		 * DAOCCC.obtieneSucursalesBanco pasandole un DTOOID con el atributo 
		 * banco (ademas del pais y el idioma) 
		if (dto.getBanco()== null) {
			dtoCarga.setSucursales(new RecordSet());
		} else {
			DTOOID dtoOID = new DTOOID();
			dtoOID.setOid(dto.getBanco());
			dtoOID.setOidIdioma(dto.getOidIdioma());
			dtoOID.setOidPais(dto.getOidPais());
			dtoCarga.setSucursales(daoCCC.obtieneSucursalesBanco(dtoOID));
		}		
		/*-cuentas: si el atributo sucursales del dto de entrada es null ponemos
		 * un recordset vacio, de lo contrario llamamos a 
		 * DAOCCC.obtieneCuentasSucursal pasandole un DTOOID con el atributo 
		 * sucursal (ademas del pais y el idioma)
		if (dto.getSucursal()==null) {
			dtoCarga.setCuentas(new RecordSet());			
		} else {
			DTOOID dtoOID = new DTOOID();
			dtoOID.setOid(dto.getSucursal());
			dtoOID.setOidIdioma(dto.getOidIdioma());
			dtoOID.setOidPais(dto.getOidPais());
			dtoCarga.setCuentas(daoCCC.obtieneCuentasSucursal(dtoOID));
		}
		/*-empresas = IServicioSEG.recuperarEmpresasPorPais(dto)
		try{
			dtoSalida = monManteminientoSEG.recuperarEmpresasPorPais(dto);
		}catch(RemoteException re) {
			this.loguearError("cargaInicial: RemoteException: monManteminientoSEG.recuperarEmpresasPorPais",re);
            throw new MareException(re,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		dtoCarga.setEmpresas(dtoSalida.getResultado());

		/* BELC300004710
		 * -En MONRegularizacionPagos.cargaInicial indicamos que para cargar 
		 * dicho atributo debemos llamar a DAORegularizacion.obtenerSiguienteNumero.
		 
		String usuario = ctx.getCallerPrincipal().getName();
		DAORegularizacion daoRegula = new DAORegularizacion(usuario);		
		dtoCarga.setNumero(daoRegula.obtenerSiguienteNumero(dto.getOidPais(),dto.getOidIdioma()));
		this.getLog().debug("****Metodo cargaInicial : Salida");	
		return dtoCarga;
	}
*/
	private MONValidacion getMONValidacion() throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.getMONValidacion(): Entrada");
        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            MON_VALIDACION, MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.loguearError(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONRegularizacionPagosBean.getMONValidacion(): Salida");
        return ejb;
	}

	private MONMantenimientoSEG getMONMantenimientoSEG() throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.getMONMantenimientoSEG(): Entrada");
        // Se obtiene el interfaz home
        MONMantenimientoSEGHome home = (MONMantenimientoSEGHome)UtilidadesEJB.getHome(
            MON_MANTENIMIENTO_SEG, MONMantenimientoSEGHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoSEG ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.loguearError(e);			
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONRegularizacionPagosBean.getMONMantenimientoSEG(): Salida");
        return ejb;
	}

	private MONClientes getMONClientes() throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.getMONClientes(): Entrada");
        // Se obtiene el interfaz home
        MONClientesHome home = (MONClientesHome)UtilidadesEJB.getHome(
            MON_CLIENTES, MONClientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONClientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.loguearError(e);			
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONRegularizacionPagosBean.getMONClientes(): Salida");
        return ejb;
	}

	private MONGestionMedioPagoBelCenter getMONGestionMedioPagoBelCenter() throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.getMONGestionMedioPagoBelCenter(): Entrada");
        // Se obtiene el interfaz home
        MONGestionMedioPagoBelCenterHome home = (MONGestionMedioPagoBelCenterHome)UtilidadesEJB.getHome(
            MON_GESTION_MEDIO_PAGO, MONGestionMedioPagoBelCenterHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestionMedioPagoBelCenter ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.loguearError(e);			
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONRegularizacionPagosBean.getMONGestionMedioPagoBelCenter(): Salida");
        return ejb;
	}


	private MONUsuarios getMONUsuarios() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONRegularizacionPagosBean.getMONUsuarios(): Entrada");
        MONUsuariosHome home = (MONUsuariosHome)UtilidadesEJB.getHome("MONUsuarios", MONUsuariosHome.class);
            
        // Se obtiene el interfaz remoto
        MONUsuarios ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			
			this.loguearError(e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONRegularizacionPagosBean.getMONUsuarios(): Salida");
        return ejb;
	}  

	private MovimientosCuentasCorrientesLocalHome getMovimientosCuentasCorrientesLocalHome() throws MareException {//BMP
		UtilidadesLog.info("MONRegularizacionPagosBean.getMovimientosCuentasCorrientesLocalHome(): Entrada");
		MovimientosCuentasCorrientesLocalHome home = (MovimientosCuentasCorrientesLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/MovimientosCuentasCorrientes");
		UtilidadesLog.info("MONRegularizacionPagosBean.getMovimientosCuentasCorrientesLocalHome(): Salida");
		return home;
	}

	private CabeceraCargosAbonosDirectosLocalHome getCabeceraCargosAbonosDirectosLocalHome() throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.getCabeceraCargosAbonosDirectosLocalHome(): Entrada");		
		UtilidadesLog.info("MONRegularizacionPagosBean.getCabeceraCargosAbonosDirectosLocalHome(): Salida");
		return new CabeceraCargosAbonosDirectosLocalHome();
	}

	private RecepcionReclamosLocalHome getRecepcionReclamosLocalHome() throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.getRecepcionReclamosLocalHome(): Entrada");		
		UtilidadesLog.info("MONRegularizacionPagosBean.getRecepcionReclamosLocalHome(): Salida");
		return new RecepcionReclamosLocalHome();
	}
	
	public DTOSalida recargaSucursales(DTOOID dto) throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.recargaSucursales(DTOOID dto): Entrada");
		/* Delegamos la peticion en DAOCCC.obtenerSucursalesBanco */
		DTOSalida dtoSalida = (new DAOCCC()).obtenerSucursalesBanco(dto);
		UtilidadesLog.info("MONRegularizacionPagosBean.recargaSucursales(DTOOID dto): Salida");
		return dtoSalida;
	}

	public DTOSalida recargaCuentas(DTOOID dto) throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.recargaCuentas(DTOOID dto): Entrada");
		/* Delegamos la solicitud a DAOCCC.obtenerCuentasSucursal() */
		RecordSet resultado = (new DAOCCC()).obtieneCuentasSucursal(dto);
		DTOSalida dtoSalida = new DTOSalida(resultado);
		//return new DTOSalida();
		UtilidadesLog.info("MONRegularizacionPagosBean.recargaCuentas(DTOOID dto): Salida");
		return dtoSalida;
	}

	public DTOSalida buscarReclamos(DTOBuscarReclamos dto) throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.buscarReclamos(DTOBuscarReclamos dto): Entrada");
		/* 
//Validar el codigoCliente 
//Obtenemos el OID del cliente a partir del codigoCliente y llenamos 
//el campo del DTOBuscarReclamos: dto.oidClienteReclamante: 

dto.oidClienteReclamante=IMaestroClientes.obtenerOidCliente(dto.pais, dto.codigoClienteReclamante); 

if (dto.oidClienteReclamante == null) throw new MareException("MAE-0024") 
"El código de cliente introducido no es válido". 

Delegamos la solicitud en el método del mismo nombre del DAORegularizacion

	
		 */

			// Modificado por incidencia: BELC300009106
	 //Si (dto.codigoClienteReclamante != null) //No se ha llenado en pantalla
	 if (dto.getCodigoClienteReclamante()!=null){
		 
		MONClientes monClientes = this.getMONClientes();
		Long consultoraReclamante = null;
		try{
			consultoraReclamante = monClientes.obtenerOidCliente(dto.getOidPais(),dto.getCodigoClienteReclamante());
		} catch(RemoteException re){
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		if (consultoraReclamante == null) {
			UtilidadesLog.error("buscarReclamos: Código cliente introducido no válido");
			UtilidadesLog.error("Código cliente introducido no válido ");
				throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "",
                        es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0024));			
		}
		dto.setOidClienteReclamante(consultoraReclamante);
	 }
		//Delegamos la solicitud en el método del mismo nombre del DAORegularizacion
		String usuario = ctx.getCallerPrincipal().getName();
		DTOSalida dtoSalida = (new DAORegularizacion(usuario)).buscarReclamos(dto);
		RecordSet rs=new RecordSet(); 
		rs=dtoSalida.getResultado();                                                                    
		 if (rs.esVacio()) {                                                                            
            		//GEN-0007 --> 005                                                                                  
			UtilidadesLog.debug("****MON REGULARIZACION buscarReclamos: No hay datos ");				
			//this.loguearError("cargaAsignarAptas: FinderException",ce);                           
            		throw new MareException(new Exception(),                                                            
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
        	}                   


		UtilidadesLog.info("MONRegularizacionPagosBean.buscarReclamos(DTOBuscarReclamos dto): Salida");
		return dtoSalida;
		
	}

	public void eliminar(DTOOIDs oids) throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.eliminar(DTOOIDs oids): Entrada");
		/* Por cada oid en el array del dto llamamos al remove del home del 
		 * entity RecepcionReclamos
		 */
		Long array[] = oids.getOids();
		MONValidacion monValidacion = this.getMONValidacion();
		if (array!=null && array.length>0) {
			for (int i = 0; i < array.length; i++) {
				RecepcionReclamosLocalHome home = this.getRecepcionReclamosLocalHome();
				try { 
				//obtengo el local para sacar los datos
					RecepcionReclamosLocal local = home.findByPrimaryKey(array[i]);
					//valido el acceso
				
					if( !(monValidacion.validarAccesos(local.getPais(),local.getEmpresa(),null, local.getCanal(),
						local.getAcceso(),local.getSubacceso(), null, null, null, null,null)).booleanValue()){
						UtilidadesLog.error("EliminarReclamo: validarAccesos: CodigosError.ERROR_ASOCIACION_ESTRUCTURAL");
						throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
					 }
					//lo borro.
					home.remove(local);
					 
					}catch(RemoteException re){
						this.loguearError(re);
						throw new MareException(re,
							UtilidadesError.armarCodigoError(
								CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
		
					} catch (NoResultException e) {
						UtilidadesLog.error(e);
						ctx.setRollbackOnly();
						throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
						
					 }catch(PersistenceException re){
						this.loguearError(re);
						ctx.setRollbackOnly();
						throw new MareException(re,
						UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
					}

			}//cierro el for
	 }//cierrom el if del array
		
					
		 UtilidadesLog.info("MONRegularizacionPagosBean.eliminar(DTOOIDs oids): Salida");
	}

	public DTOReclamo obtenerReclamo(DTOOID oid) throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.obtenerReclamo(DTOOID oid): Entrada");
		/* Se delega la solicitud en el metodo del mismo nombre del 
		 * DAORegularizacion
		 */
		String usuario = ctx.getCallerPrincipal().getName();
		DTOReclamo dtoReclamo = (new DAORegularizacion(usuario)).obtenerReclamo(oid);
		UtilidadesLog.info("MONRegularizacionPagosBean.obtenerReclamo(DTOOID oid): Salida");
		return dtoReclamo;
	}
	
	public DTOSalida obtenerSituacionesReclamo(DTOBelcorp dto) throws MareException {
	    UtilidadesLog.info("MONRegularizacionPagosBean.obtenerSituacionesReclamo(DTOBelcorp dto): Entrada");
		/* Se delega la solicitud en el metodo del mismo nombre del 
		 * DAORegularizacion*/
		 
		String usuario = ctx.getCallerPrincipal().getName();
		DTOSalida dtoSalida = (new DAORegularizacion(usuario)).obtenerSituacionesReclamo(dto);
		UtilidadesLog.info("MONRegularizacionPagosBean.obtenerSituacionesReclamo(DTOBelcorp dto): Salida");
		return dtoSalida;
	}
	
/*	private RecordSet obtenerPosiblesSituaciones(Long idioma) throws MareException {
		this.getLog().debug("****Metodo  obtenerPosiblesSituaciones: Entrada");
		//Llamamos al findAll del entity SituacionReclamo. Creamos un recordset
		 //* con tantas filas como entidades obtenidas y dos columnas: el oid de 
		 //* la entidad y la descripcion para el idioma indicado 
		 //*
		SituacionReclamoLocalHome home = this.getSituacionReclamoLocalHome();
		SituacionReclamoLocal local;
		Vector vector;
		RecordSet resultado = new RecordSet();
		Collection coleccion = null;
		try{
			coleccion = home.findAll();
		}catch(FinderException fe) {//BELC300003311			
		}
	
		if (coleccion!=null && coleccion.size()>0) {
			Iterator iterador = coleccion.iterator();
			String sOid="OID";
			String sDescripcion="DESCRIPCION";
			resultado.addColumn(sOid);
			resultado.addColumn(sDescripcion);	
			while(iterador.hasNext()) {
				 local=(SituacionReclamoLocal)iterador.next();
				 vector = new Vector();
				 vector.addElement(local.getOid());
				 vector.addElement(
					UtilidadesI18N.recuperarTraducciones(SITUACION_RECLAMO,
														local.getOid(),
														idioma,
														new Long(1)));
				 resultado.addRow(vector);
			}
		}
		this.getLog().debug("****Metodo  obtenerPosiblesSituaciones: Salida");
		return resultado;
	}
*/
	public void procesar(DTOOIDs oids) throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.procesar(DTOOIDs oids): Entrada");
		/* Por cada elemento en el DTOOIDs { 
		 * Hacemos un findByPrimaryKey del entity RecepcionReclamos con el oid 
		 * del elemento del array. 
		 * 
		 * Si el atributo situacion es igual a 
		 * ConstantesCCC.RECLAMO_SITUACION_SOLICITADO o a 
		 * ConstantesCCC.SITUACION_EN_PROCESO { 
		 * En el atributo ponemos el valor ConstantesCCC.SITUACION_EN_PROCESO 
		 * } else { 
		 * Lanzamos una MareException con el código de errror CCC-0034 
		 * (Sólo se pueden pasar a procesados los reclamos en estado solicitado)
		 * en el idioma del dto. 
		 * } 
		 */
		RecepcionReclamosLocalHome home = this.getRecepcionReclamosLocalHome();
		RecepcionReclamosLocal local;
		Long datos[] = oids.getOids();
		for (int i=0;i<datos.length;i++) {
			try{
				local = home.findByPrimaryKey(datos[i]);
			}catch(NoResultException fe){
				ctx.setRollbackOnly();
				this.loguearError(fe);
                                 throw new MareException(fe,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));				
			}
			long situacion = local.getSituacion().longValue();
			long reclamo = Long.parseLong(CCCConstantes.RECLAMO_SITUACION_SOLICITADO);
			long proceso = Long.parseLong(CCCConstantes.RECLAMO_SITUACION_EN_PROCESO);
			if (situacion==reclamo || situacion==proceso) {
				local.setSituacion(new Long(proceso));
			}else {
				UtilidadesLog.debug("Metodo  procesar: CCC-0034");
				throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                        ErroresDeNegocio.IMPOSIBLE_PASAR_A_PROCESADO_RECLAMO_NO_SOLICITADO));				
			}
		}
		UtilidadesLog.info("MONRegularizacionPagosBean.procesar(DTOOIDs oids): Salida");
	}

	private void loguearError(Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error(e);
	}    
	
	private void loguearSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("MONRegistroVentasBean.loguearSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0){
			String sParams="";
			for (int i=0; i<params.size();i++){
				if (params.elementAt(i)!=null)
					sParams+="param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";
				else
					sParams+="param "+ (i+1) + ": es nulo, ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}		
        UtilidadesLog.info("MONRegistroVentasBean.loguearSql(String metodo, String sql, Vector params): Salida");
	}    
		//BELC300008981
	public DTONumeroReclamo obtenerSiguienteNumero(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONRegularizacionPagosBean.obtenerSiguienteNumero(DTOBelcorp dto): Entrada");
		/*	MODIFICADO POR INCIDENCIA 10254		 
		String usuario = ctx.getCallerPrincipal().getName();
		DTONumeroReclamo dtoN= new DTONumeroReclamo();
		DAORegularizacion dao=new DAORegularizacion(usuario);
		dtoN=dao.obtenerSiguienteNumero(dto.getOidPais(), dto.getOidIdioma());
		*/
		DTONumeroReclamo dtoN= new DTONumeroReclamo();
		DAOCCC daoccc = new DAOCCC();
		dtoN.setNumeroIdentificacion(daoccc.obtenerSecuenciaPais(dto));
		UtilidadesLog.info("MONRegularizacionPagosBean.obtenerSiguienteNumero(DTOBelcorp dto): Salida");
		return dtoN;
	}

	

	/*
	 * guardarReclamo: OK
	 * cargaInicial: OK
	 * recargaSucursales: OK
	 * recargaCuentas: OK
	 * buscarReclamos: OK
	 * eliminar: OK
	 * obtenerReclamo: OK
	 * obtenerPosiblesSituaciones: OK
	 * procesar: OK
	 */
	
}
