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

import es.indra.sicc.entidades.mae.ClienteBloqueoLocal;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocalHome;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


import es.indra.sicc.dtos.ccc.DTOAplicarIncobrables;
import es.indra.sicc.dtos.ccc.DTOAprobar;
import es.indra.sicc.dtos.ccc.DTOBuscarLotes;
import es.indra.sicc.dtos.ccc.DTOBuscarSaldosMorosos;
import es.indra.sicc.dtos.ccc.DTOCargaInicialSeleccion;
import es.indra.sicc.dtos.ccc.DTOCargaInicialBuscarLotes;
import es.indra.sicc.dtos.ccc.DTOConsultarDepuracion;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.dtos.ccc.DTOBloquearCliente;
import es.indra.sicc.dtos.ccc.DTOConfigSecuencial;
import es.indra.sicc.dtos.cob.DTOActualizacionCartera;

import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;

import es.indra.sicc.dtos.seg.DTOCargaCAS;
import es.indra.sicc.dtos.seg.DTOCAS;
import es.indra.sicc.dtos.seg.DTOFiltroCAS;


import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.MarcasTipoAbonoLocal;
import es.indra.sicc.entidades.ccc.MarcasTipoAbonoLocalHome;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocal;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocalHome;
import es.indra.sicc.entidades.ccc.SituacionIncobrableLocal;
import es.indra.sicc.entidades.ccc.SituacionIncobrableLocalHome;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocal;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocalHome;

import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.ccc.DAOCCC;
import es.indra.sicc.logicanegocio.ccc.DAOCuentasCorrientes;
import es.indra.sicc.logicanegocio.ccc.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientes;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientesHome;

import es.indra.sicc.logicanegocio.ccc.MONMarcasPorTipoAbono;
import es.indra.sicc.logicanegocio.ccc.MONMarcasPorTipoAbonoHome;

import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;

import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;

import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;


import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.rmi.RemoteException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.sql.Timestamp;
import es.indra.sicc.dtos.ccc.DTOBloquearClientes;
import es.indra.sicc.dtos.ccc.DTOClienteBloqueo;
import es.indra.sicc.entidades.ccc.SubprocesosLocalHome;
import es.indra.sicc.entidades.ccc.SubprocesosLocal;
import es.indra.sicc.dtos.ccc.DTOOIDPAG;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONProvisionesDepuracionesBean implements SessionBean  {

	private final static String MON_MANTENIMIENTO_SEG = "MONMantenimientoSEG";
	private final static String MON_MARCAS_POR_TIPO_ABONO = "MONMarcasPorTipoAbono";
	private final static String MON_CLIENTES = "MONClientes";
	private final static String SITUACION_INCOBRABLE = "CCC_SITUA_INCOB";
	private final static String MON_VALIDACION = "MONValidacion";
	private final static String MON_CUENTAS_CORRIENTES = "MONCuentasCorrientes";
	private final static String MON_PERIODOS = "MONPeriodos";

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
	 * 
	 * @param dto DTO del tipo DTOBelcorp
	 * @exception MareException
	 * @return DTOCargaInicialSeleccion
	 */
	public DTOCargaInicialSeleccion cargaInicialSeleccion(DTOBelcorp dto) throws RemoteException, MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.cargaInicialSeleccion(DTOBelcorp dto): Entrada");
		/* Creamos un DTOCargaInicialSeleccion y rellenamos los atributos de la 
		 * siguiente manera: 
		 * -numDiasDeMora: llamamos al método recuperarPais de la interfaz
		 * IServicioSEG de SEG pasandole el pais del dto, del recordset que
		 * obtenemos cogemos la columna correspondiente al campo NUM_DIAS_MORA 
		 * -tiposCargo: llamamos al método obtenerTiposCargoSubproceso pasandole
		 * el resultado de llamar a obtenerSubprocesoAsociado
		 * BELC300003397
		 * 
		 *	Creamos un DTOBelcorp dtoBelcorp.
		 *-empresas=IServicioSEG.recuperarEmpresas(dtoBelcorp);
		 * BELC300008229 
		 */
		DTOCargaInicialSeleccion dtoCIS = new DTOCargaInicialSeleccion();
		 /************************ empresas *******************************/
		MONMantenimientoSEG monMantenimientoSEG = this.getMONMantenimientoSEG();
		DTOSalida dtoSalida;
		try{					
			dtoSalida = monMantenimientoSEG.recuperarEmpresasPorPais(dto);	
		}catch(RemoteException e){
			this.loguearError(e);
            throw new MareException(e,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			
		}
		RecordSet resultadoEmpresas = dtoSalida.getResultado();		
		dtoCIS.setEmpresas(resultadoEmpresas);
		 
		 /************************ numDiasMora *******************************/
		
		//MONMantenimientoSEG monMantenimientoSEG = this.getMONMantenimientoSEG();
		DTOOID dtoOID = new DTOOID();
		dtoOID.setOid(dto.getOidPais());
		dtoOID.setOidIdioma(dto.getOidIdioma());
		//DTOSalida dtoSalida;
		try{					
			dtoSalida = monMantenimientoSEG.recuperarPais(dtoOID);			
		}catch(RemoteException e){
			this.loguearError(e);
            throw new MareException(e,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			
		}
		RecordSet resultado = dtoSalida.getResultado();		
		Integer numDias = new Integer(((BigDecimal)resultado.getValueAt(0, "NUM_DIAS_MORA")).toString());
		dtoCIS.setNumDiasDeMora(numDias);

		/**************************** tiposCargo ******************************/
		DAOCCC daoCCC = new DAOCCC();
		dtoCIS.setTiposCargo(daoCCC.obtenerTiposCargoSubproceso(this.obtenerSubprocesoAsociado(dto.getOidPais()),dto.getOidIdioma()));
		/*
		/****************************** marcas ********************************/
		/*
		 * marcas: IServicioSEG.recuperarMarcas()
		 */
		//MONMantenimientoSEG monManteminientoSEG = this.getMONMantenimientoSEG();
		/*DTOSalida dtoMarcas;
		try {
			dtoMarcas = monMantenimientoSEG.recuperarMarcas(dto);
		} catch(RemoteException re) {
			this.loguearError("cargaInicialSeleccion: RemoteException: monManteminientoSEG.recuperarMarcas.",re);
            throw new MareException(re,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			
		}
		dtoCIS.setMarcas(dtoMarcas.getResultado());
		*/
		/***************** canales, accesos y subaccesos **********************/
		/*
		 * Creamos dos DTOCAS de SEG y rellenamos el primero con los tres 
		 * atributos a false y el segundo con los tres atributos a true. 
		 * Creamos un DTOCargaCAS tambien de SEG y metemos en el atributo todos 
		 * el primer DTOCAS y el filtro el segundo, además metemos el pais y el
		 * idioma del DTOBelcorp que hemos recibido. 
		 * Con este DTOCAS llamamos a obtieneCanalAccesoSubacceso y obtenemos 
		 * un DTOCAS. 
		 * -Con los recordset que obtenemos rellenamos los atributos 
		 * correspondientes: canales, accesos y subaccesos. Con la 
		 * particularidad de que les quitamos la segunda columna (la del código).
		 */
		DTOFiltroCAS dtoFiltroCASuno = new DTOFiltroCAS();
		DTOFiltroCAS dtoFiltroCASdos = new DTOFiltroCAS();
		dtoFiltroCASuno.setBaccesos( Boolean.valueOf(false));
		dtoFiltroCASuno.setBcanales( Boolean.valueOf(false));
		dtoFiltroCASuno.setBsubaccesos( Boolean.valueOf(false));
		dtoFiltroCASdos.setBaccesos( Boolean.valueOf(true));
		dtoFiltroCASdos.setBcanales( Boolean.valueOf(true));
		dtoFiltroCASdos.setBsubaccesos( Boolean.valueOf(true));

		DTOCargaCAS dtoCargaCAS = new DTOCargaCAS();
		dtoCargaCAS.setTodos(dtoFiltroCASuno);
		dtoCargaCAS.setFiltro(dtoFiltroCASdos);
		dtoCargaCAS.setOidPais(dto.getOidPais());
		dtoCargaCAS.setOidIdioma(dto.getOidIdioma());
		
		DTOCAS dtoCAS = null;
		try{
			dtoCAS = monMantenimientoSEG.obtieneCanalAccesoSubacceso(dtoCargaCAS);
		}catch(RemoteException re){
			this.loguearError(re);
            throw new MareException(re,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}

		RecordSet canales = dtoCAS.getCanales();
		RecordSet accesos = dtoCAS.getAccesos();
		RecordSet subaccesos = dtoCAS.getSubaccesos();
		// No se eliminan las segundas columnas por la incidencia BELC300004525
		// canales.removeColumn(1); // la segunda columna
		// accesos.removeColumn(1);
		// subaccesos.removeColumn(1);
		
		dtoCIS.setCanales(canales);
		dtoCIS.setAccesos(accesos);
		dtoCIS.setSubaccesos(subaccesos);

		/* BELC300005103
		 * -En el MONProvisionesDepuraciones.cargaInicialSeleccion, indicamos que el atributo
		 * numeroLote lo cargamos con el resultado de llamar a
		 * DAODepuracion.obtenerSiguienteNumeroDepuracion
		 */

		// Añadido por incidencia 9128
		//Llamamos al método recuperarPais de IServicioSEG pasandole el pais
		DTOOID dtoOIDSeg = new DTOOID();
		dtoOIDSeg.setOid(dto.getOidPais());
		dtoOIDSeg.setOidIdioma(dto.getOidIdioma());
		MONMantenimientoSEG seg = this.getMONMantenimientoSEG();

		DTOSalida dtoSalidaSeg = null;
		try {		
			dtoSalidaSeg = seg.recuperarPais(dtoOIDSeg);
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.loguearError(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }

		// Se obtiene el campo VAL_CONF_SECU_CCC de la primera fila del recordset
		RecordSet rs = dtoSalidaSeg.getResultado();
		int columna = rs.getColumnPosition("VAL_CONF_SECU_CCC");
		String tipo = (String)rs.getRow(0).elementAt(columna);

		char tipoSecuencial = tipo.charAt(0);
		DTOConfigSecuencial dtoCFGSec = new DTOConfigSecuencial();
		dtoCFGSec.setIndicadorConfigSec(new Character(tipoSecuencial));
		dtoCFGSec.setOidPais(dto.getOidPais());
		dtoCFGSec.setOidIdioma(dto.getOidIdioma());
		 
		//String usuario = ctx.getCallerPrincipal().getName();
		//DAODepuracion daoDepuracion = new DAODepuracion(usuario);
		/*Modificado por incidencia BELC300010254
			dtoCIS.setNumeroLote(daoDepuracion.obtenerSiguienteNumeroDepuracion(dtoCFGSec).getNumeroDepuracion());
		*/

		dtoCIS.setNumeroLote(daoCCC.obtenerSecuenciaPais(dto));
		// periodos no hace falta: BELC300003566 		

		//BELC300005115 : Se cargan subroceso y proceso
		//-subproceso = "1"
        // -proceso = DAOCCC.obtieneProceso(ConstantesCCC.PROCESO_PROVISION_DEPURACION, dto.pais)
		dtoCIS.setSubproceso("1");
		dtoCIS.setProceso(daoCCC.obtieneProceso(CCCConstantes.PROCESO_PROVISION_DEPURACION,dto.getOidPais()));
		dtoCIS.setSubproceso(daoCCC.obtieneSubproceso(dtoCIS.getProceso(),dtoCIS.getSubproceso()).toString());
		dtoCIS.setSubproceso("1");
		/*
		DTOSalida reg=ISEG.obtenerPeriodosPorCanal(); 
		dto.periodoDesde=reg.get("COD_PERI"); 
		Cargamos el combo "periodoDesde" con este reg. 
		*/

		/*DTOOID dtooid = new DTOOID();
		dtooid.setOid(new Long(1));
		DTOSalida reg=monMantenimientoSEG.obtenerPeriodosPorCanal(dtooid); 
		//dtoCIS.setPeriodoDesde(reg.getResultado().getColumn(1));		
		dtoCIS.setPeriodoDesde(reg.getResultado());*/

		UtilidadesLog.info("MONProvisionesDepuracionesBean.cargaInicialSeleccion(DTOBelcorp dto): Salida");
		return dtoCIS;
	}

	/**
	 * Llamamos a DAOCuentasCorrientes.buscarSaldosMorosos	 
	 * @param criterios DTO del tipo DTOBuscarSaldosMorosos
	 * @exception MareException
	 * @return DTOSalida
	 */
     /*
      * Autor: Cortaberria
      * Fecha: 27/06/2005
      * Debido a incidencia BELC300019093 se elimina la validacion de cliente desde y hasta.
      */
	public DTOSalida buscarSaldosMorosos(DTOBuscarSaldosMorosos criterios) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.buscarSaldosMorosos(DTOBuscarSaldosMorosos criterios): Entrada");
		

//18252
		/*MONMantenimientoSEG monSEG = this.getMONMantenimientoSEG();
		// Cambiado por incidencia 9046
		UtilidadesLog.debug("Periodo desde: "+criterios.getPeriodoDesde() +"Periodo Hasta: "+criterios.getPeriodoHasta());
		if ((criterios.getPeriodoDesde()!=null)&&(criterios.getPeriodoHasta()!=null)){
			//Long clienteDesde;
			//Long clienteHasta;
			try{
				criterios.setOidPeriodoDesde(monSEG.obtenerOidPeriodo(criterios.getPeriodoDesde(),criterios.getCanal()));			
			}catch(RemoteException re){
				this.loguearError("buscarSaldosMorosos: monClientes.obtenerOidCliente (desde):",re);
				throw new MareException(re,
						UtilidadesError.armarCodigoError(
							CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}
			try{
				criterios.setOidPeriodoHasta(monSEG.obtenerOidPeriodo(criterios.getPeriodoHasta(),criterios.getCanal()));
			}catch(RemoteException re){
				this.loguearError("buscarSaldosMorosos: monClientes.obtenerOidCliente (hasta):",re);
				throw new MareException(re,
						UtilidadesError.armarCodigoError(
							CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}
			UtilidadesLog.debug("[OID]Periodo desde: "+criterios.getOidPeriodoDesde() +"[OID]Periodo Hasta: "+criterios.getOidPeriodoHasta());
			if (criterios.getOidPeriodoDesde()==null) {
				UtilidadesLog.debug("****Metodo buscarSaldosMorosos: PeriodoDesde es nulo");	
				ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_SEG, "",
				es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0024));
				excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
				excepcionParam.addParameter(" "+criterios.getPeriodoDesde());
				throw excepcionParam;		
			}else{
				UtilidadesLog.debug("****Metodo buscarSaldosMorosos: PeriodoDesde = "+criterios.getOidPeriodoDesde().toString());	
			}
			if (criterios.getOidPeriodoHasta()==null) {
				UtilidadesLog.debug("****Metodo buscarSaldosMorosos: PeriodoHasta es nulo");	
				ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_SEG, "",
				ErroresNegocio.SEG_0002));		
				excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
				excepcionParam.addParameter(" "+criterios.getPeriodoHasta());
				throw excepcionParam;		
			}else{
				UtilidadesLog.debug("****Metodo buscarSaldosMorosos: PeriodoHasta = "+criterios.getOidPeriodoHasta().toString());		
			}
		}*/




		/* Llamamos a buscarSaldoMorosos del DAOCuentasCorrientes parasandole 
		 * el dto y el resultado llamar a DAO.obtenerProceso pasandole 
		 * CCCConstantes.PROCESO_PROVISION_DEPURACION y el pais del dto
		 */
		String usuario = ctx.getCallerPrincipal().getName();
		DAOCuentasCorrientes dao = new DAOCuentasCorrientes(usuario);
		DAOCCC daoCCC = new DAOCCC();
		// BELC300003347
		Long proceso = daoCCC.obtieneProceso(CCCConstantes.PROCESO_PROVISION_DEPURACION,criterios.getOidPais());
		DTOSalida dtoSalida = dao.buscarSaldosMorosos(criterios,proceso);

		RecordSet resultado = dtoSalida.getResultado();
		
        if (resultado.esVacio()) {                                                                            
			   UtilidadesLog.debug("****DAOCuentasCorrientes.buscarSaldosMorosos(): No hay datos ");                                      
			   throw new MareException(new Exception(),                                                            
			   UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
        }                           

		//Construimos un array de OIDs con la columna de los OIDs del DTOSalida.recordset 
		//y lo envolvemos en un DTOOIDs. 
		Vector vector = dtoSalida.getResultado().getColumn(0);
		DTOOIDs dtoOids = new DTOOIDs();

		int tamano = dtoSalida.getResultado().getRowCount();
		Long oids[] = new Long[tamano] ;
		for (int i=0; i<tamano;i++){
			oids[i] = new Long(vector.get(i).toString());
		}
		dtoOids.setOids(oids);

		//BLOQUEO 
		// Incidencia 9342 
		MONCuentasCorrientes monCCC = this.getMONCuentasCorrientes();
		try{
			if (!monCCC.bloquearMovCC(dtoOids).booleanValue()){
				ctx.setRollbackOnly();
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
						ErroresDeNegocio.CCC_0044));
			}
		}catch(RemoteException re){
			ctx.setRollbackOnly();
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		
		UtilidadesLog.info("MONProvisionesDepuracionesBean.buscarSaldosMorosos(DTOBuscarSaldosMorosos criterios): Salida");
        UtilidadesLog.debug("   - SAP601: retorna 'dtoSalida'= " + dtoSalida);
		return dtoSalida;

	}
  
  /*
     * Autor: Cortaberria
     * Fecha: 15/06/2005
     * Se agrega recepcion  del numero de lote de la pantalla. Incidencia BELC300019032
     * 
     * SCS 12/10/2006, pet. de cbio. nº 002
     */
	public void aplicarIncobrables(DTOAplicarIncobrables dto) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.aplicarIncobrables(DTOAplicarIncobrables dto): Entrada");
		/* 
		 * Llamamos a MONValidacion.validarVinculos, pasandole los parametros 
		 * pais, canal, acceso y subacceso del DTOBuscarSaldosMorosos que hay 
		 * en dto.criteriosBusqueda, el resto de parametros van a null. Si no 
		 * devuelve false lanzamos una MareException con el código de error 
		 * GEN-0013 ("La jerarquía de vínculos seleccionada no es válida")
		 * 
		 * public Boolean validarVinculos(Long Pais, Long Sociedad, Long Marca,
		 * Long Canal, Long Acceso, Long Subacceso)
		 */
		MONValidacion monValidacion = this.getMONValidacion();
		Date fechaActual = new Date(System.currentTimeMillis());
		UtilidadesLog.debug("Parametros ValidarVinculos: P:"+ dto.getOidPais()+" E:"+dto.getEmpresa()+" C:"+dto.getCanal()
								+" A:"+dto.getAcceso()+" S:"+dto.getSubacceso());
                
                UtilidadesLog.debug("el dto que llega a aplicarIncobrables, es: " + dto);
		try{
			if( !(monValidacion.validarVinculos(dto.getOidPais(),
												dto.getEmpresa(),
												null,
												dto.getCanal(),
												dto.getAcceso(),
												dto.getSubacceso())).booleanValue()){
				UtilidadesLog.error("aplicarIncobrables: validarVinculos: CodigosError.ERROR_VINCULOS_INVALIDOS");
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULOS_INVALIDOS) );
			 }
		}catch(RemoteException re){
			ctx.setRollbackOnly();
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}catch(MareException e) {
			throw e;
		}
		UtilidadesLog.debug("vinculos validos");
		
		DTOOIDs dtoOids = new DTOOIDs();
		dtoOids.setOids(dto.getMovimientos());

		//BLOQUEO 
		//  A falta de incidencia 9342 
		MONCuentasCorrientes monCC = this.getMONCuentasCorrientes();
    try{
			if (!monCC.bloquearMovCC(dtoOids).booleanValue()){
				ctx.setRollbackOnly();
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
						ErroresDeNegocio.CCC_0044));
			}
			//monCC.bloquearBloqueoMovCC() NO CONSTRUIDO EL METODO
			monCC.bloquearBloqueoMovCC();
		}catch(RemoteException re){
			ctx.setRollbackOnly();
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}

		UtilidadesLog.debug("Ejecutado el bloqueo");
		/* 
		 * Llamamos al findByTipoAbonoSubproceso del entity MarcasTipoAbono 
		 * pasandole los parametros: 
		 * tipoCargoAbono del dto de entrada, el resultado de llamar a 
		 * obtenerSubprocesoAsociado.
		 * Si obtenemos una entidad guardamos el atributo marcaSalida en una 
		 * variable marcaSituacion que utilizaremos más adelante. 
		 * si nos salta una FinderException lanzamos una MareException con el 
		 * siguiente mensaje: CCC-0014 (No existe una marca situación asociada 
		 * al tipo de abono elegido)
		 */
		MarcasTipoAbonoLocalHome homeMarcas = this.getMarcasTipoAbonoLocalHome();
		MarcasTipoAbonoLocal localMarcas = null;
		Long marcaSituacion = null;
		
		try {
			//localMarcas = homeMarcas.findByTipoAbonoSubproceso(this.obtenerSubprocesoAsociado(dto.getOidPais()),"S");
			Collection coleccion = homeMarcas.findByTipoAbonoSubprocesoEoS(this.obtenerTipoAbonoSubproceso(dto.getOidPais(),dto.getOidIdioma()),"S");
			Iterator iterador = coleccion.iterator();
		
			if (iterador.hasNext()) {
				 localMarcas = (MarcasTipoAbonoLocal)iterador.next();
			}else{
				ctx.setRollbackOnly();
				UtilidadesLog.debug("aplicarIncobrables: FinderException: ");
				throw new MareException(new Exception(),
						UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
							ErroresDeNegocio.MARCA_SITUACION_ASOCIADA_INEXISTENTE));
			}
		}catch(NoResultException fe) {
			ctx.setRollbackOnly();
			this.loguearError(fe);
			throw new MareException(fe,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                        ErroresDeNegocio.MARCA_SITUACION_ASOCIADA_INEXISTENTE));
		}

		marcaSituacion = localMarcas.getMarca();
		UtilidadesLog.debug("obtenida marcaSituacion: "+marcaSituacion.longValue());
		/*
		 * TiposAbonoSubproceso.findByPrimaryKey(tipoAbonoSubproceso) guardamos en 
		 * la variable cuentaContable el oid de CuentasContables (getCuenta()), 
		 * guardamos, también, en la variable subproceso=oidSubproceso. 
		 * Si nos salta una FinderException lanzamos una MareException con el 
		 * siguiente mensaje: CCC-0042 (No existe el Tipo de Abono Subproceso indicado). 
		 */
		TiposAbonoSubprocesoLocalHome homeTiposAbono = this.getTiposAbonoSubprocesoLocalHome();
		TiposAbonoSubprocesoLocal localTiposAbono = null;
		Long cuentaContable = null;
		Long subproceso = null;
		try {
			localTiposAbono = homeTiposAbono.findByPrimaryKey(localMarcas.getTipoAbonoSubproceso());
		} catch (NoResultException fe){
			ctx.setRollbackOnly();
			this.loguearError(fe);
			throw new MareException(fe,
                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                            ErroresDeNegocio.TIPO_ABONO_SUBPROCESO_INEXISTENTE));
		}

		cuentaContable = localTiposAbono.getCuenta();
		subproceso = localTiposAbono.getSubproceso();
		UtilidadesLog.debug("obtenida Cuenta contable y subproceso: "+cuentaContable.longValue()+" "+subproceso.longValue());
		/* Llamamos al create del entity CabeceraCargosAbonosDirectos pasandole 
		 * los siguientes parametros: 
		 * -pais: el pais del dto 
		 * -anio: los dos ultimos digitos del año actual del sistema 
		 * -periodoMes: el número de mes actual (con dos dígitos) 
		 * -numero: llamamos a obtenerSiguienteNumeroDepuracion del DAODepuracion 
		 * -situacion: CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO 
		 * -fechaContabilizacion es la fechaImputacion 
		 * -en fechaDocumento ponemos la fecha actual 
		 * -empresa, acceso, canal, marca y subacceso se rellenan con los atributos 
		 * correspondientes del dto 
		 * -periodoDesde y periodoHasta: llamamos a IPeriodos.obtienePeriodosPMCCodigo 
		 * pasandole un DTOPeriodo en el que rellenamos pais, marca, canal y codPeriodo 
		 * (tomando peridoDesde o periodoHasta según el caso), a partir de los atributos 
		 * del DTOBuscarSaldosMorosos. Del DTOPeriodo que obtenemos nos quedamos con el oid. 
		 * Si en la llamada al finder capturamos una FinderException, lanzamos una 
		 * ParametrizableException con el código de mensaje SEG-003 (No se ha encontrado 
		 * el periodo corporativo {0} para la marca, pais y canal especificados) ,
		 * hacemos un setPosicion con la constante POSICION_MEDIO y le añadimos 
		 * con addParameter el periodo del dto que ha fallado. 
		 * -los siguientes atributos los sacamos del DTOBuscarSaldosMorosos que 
		 * hay en el atributo criteriosBusqueda del dto de entrada: 
		 * empresa, canal, acceso, subacceso, fechaImputación, fechaDocumentoDesde, 
		 * fechaDocumentoHasta, fechaVencimientoDesde, fechaVencimientoHasta, 
		 * referenciaExterna, observaciones. 
		 * -clienteDesde y clienteHasta los rellenamos con los atributos del 
		 * DTOBuscarSaldosMorosos, una vez que hemos llamado para cada uno al 
		 * método obtenerOidCliente. 
		 * -tipoAbonoSubproceso = el asignamos DTOBuscarSaldosMorosos.tipoCargoAbono 
		 */
    //SCS pet. de cbio. nº 002 
    DAOCCC daoCCC = new DAOCCC(); 
    Long oidPro = daoCCC.obtieneProceso(CCCConstantes.PROCESO_PROVISION_DEPURACION, dto.getOidPais());
    UtilidadesLog.debug("SCS oidPro: " + oidPro);
    Long indiActuCuot = daoCCC.obtieneIndActCuota(oidPro, "1");
    UtilidadesLog.debug("SCS indiActuCuot: " + indiActuCuot);
    //
    
		CabeceraCargosAbonosDirectosLocalHome homeCabecera = this.getCabeceraCargosAbonosDirectosLocalHome();
		String anyo="";
		String mes="";
		try{
			anyo = UtilidadesFecha.convertirAString(fechaActual,"yy");
			mes = UtilidadesFecha.convertirAString(fechaActual,"MM");
		}catch(ParseException pe){
			ctx.setRollbackOnly();
			this.loguearError(pe);
			throw new MareException(pe,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			
		}



		// Añadido por incidencia 9128
		//Llamamos al método recuperarPais de IServicioSEG pasandole el pais
		DTOOID dtoOIDSeg = new DTOOID();
		dtoOIDSeg.setOid(dto.getOidPais());
		dtoOIDSeg.setOidIdioma(dto.getOidIdioma());
		MONMantenimientoSEG seg = this.getMONMantenimientoSEG();

		DTOSalida dtoSalidaSeg = null;
		try {		
			dtoSalidaSeg = seg.recuperarPais(dtoOIDSeg);
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.loguearError(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }

		// Se obtiene el campo VAL_CONF_SECU_CCC de la primera fila del recordset
		RecordSet rs = dtoSalidaSeg.getResultado();
		int columna = rs.getColumnPosition("VAL_CONF_SECU_CCC");
		String tipo = (String)rs.getRow(0).elementAt(columna);

		char tipoSecuencial = tipo.charAt(0);
		DTOConfigSecuencial dtoCFGSec = new DTOConfigSecuencial();
		dtoCFGSec.setIndicadorConfigSec(new Character(tipoSecuencial));
		dtoCFGSec.setOidPais(dto.getOidPais());
		dtoCFGSec.setOidIdioma(dto.getOidIdioma());
		 
		//String usuario = ctx.getCallerPrincipal().getName();
		//DAODepuracion daoDepuracion = new DAODepuracion(usuario);
		/* Moficado por incidencia BELC300010254
		Integer numero = daoDepuracion.obtenerSiguienteNumeroDepuracion(dtoCFGSec).getNumeroDepuracion();
		*/
		
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(dto.getOidPais());
		dtoBelcorp.setOidIdioma(dto.getOidIdioma());
    
		Integer numero = dto.getNumeroLote();
    if(numero == null) {
      numero = daoCCC.obtenerSecuenciaPais(dtoBelcorp);
    }
    Long situacion = new Long(CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO);
		TiposAbonoSubprocesoLocalHome homeTipo = this.getTiposAbonoSubprocesoLocalHome();
		TiposAbonoSubprocesoLocal localTipo;
		subproceso = this.obtenerSubprocesoAsociado(dto.getOidPais());
		try{//BELC300003571 TipoAbono es lo mismo que TipoCargoAbono
			localTipo = homeTipo.findByUK(dto.getTipoCargoAbono(),subproceso);
		} catch(NoResultException fe){
			ctx.setRollbackOnly();
			this.loguearError(fe);
                        throw new MareException(fe,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}

		MONClientes monClientes = this.getMONClientes();
		Long clienteDesde=null;
		Long clienteHasta=null;
		try{
			clienteDesde=monClientes.obtenerOidCliente(dto.getOidPais(),dto.getClienteDesde());			
		}catch(RemoteException re){
			ctx.setRollbackOnly();
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		try{
			clienteHasta=monClientes.obtenerOidCliente(dto.getOidPais(),dto.getClienteHasta());
		}catch(RemoteException re){
			ctx.setRollbackOnly();
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}

		/* BELC300004787, BELC300004785, BELC300004794 
		 * 
		 * BELC300004887 !!!!!!!!!!!!!!!
		 * Debido al cambio en CRA, la forma de obtener periodoDesde y periodoHasta en
		 * aplicarIncobrables queda así:
		 * 
		 * -periodoDesde y periodoHasta: llamamos a IPeriodos.obtienePeriodosPMCCodigo pasandole un
		 * DTOPeriodo en el que rellenamos pais, marca, canal y codPeriodo (tomando peridoDesde o
		 * periodoHasta según el caso), a partir de los atributos del DTOBuscarSaldosMorosos. DelDTOPeriodo que obtenemos nos quedamos con el oid.
		 * 
		 * BELC300004046
		 * Si en la llamada al finder capturamos una FinderException, lanzamos una
		 * ParametrizableException con el código de mensaje SEG-003 (No se ha encontrado el periodo
		 * corporativo {0} para la marca, pais y canal especificados) , hacemos un setPosicion con la
		 * constante POSICION_MEDIO y le añadimos con addParameter el periodo del dto que ha fallado.
		 */	

         //18260
		/*Long periodoDesde = null;
		Long periodoHasta = null;
		if (dto.getPeriodoDesde()!=null || dto.getPeriodoHasta()!=null){
			DTOPeriodo dtoPeriodoResultado;
			MONPeriodos monPeriodos = this.getMONPeriodos();
			DTOPeriodo dtoPeriodo = new DTOPeriodo();
			dtoPeriodo.setPais(dto.getOidPais());
			//dtoPeriodo.setMarca(dto.getMarca());
			dtoPeriodo.setCanal(dto.getCanal());

			if (dto.getPeriodoDesde()!=null) {
			
				dtoPeriodo.setCodigoPeriodo(dto.getPeriodoDesde());

				try{
					dtoPeriodoResultado = monPeriodos.obtienePeriodosPMCCodigo(dtoPeriodo);
				}catch(RemoteException re){
					ctx.setRollbackOnly();
					this.loguearError("aplicarIncobrables: ",re);
					throw new MareException(re,
							UtilidadesError.armarCodigoError(
								CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));		
				}

				if (dtoPeriodoResultado.getOid()==null) {
					ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_SEG, "",
					es.indra.sicc.logicanegocio.seg.ErroresNegocio.SEG_0003));	
					excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
					excepcionParam.addParameter(dto.getPeriodoDesde());	
					throw excepcionParam;		
				}
				periodoDesde = dtoPeriodoResultado.getOid();
			}

			if (dto.getPeriodoHasta()!=null) {

				dtoPeriodo.setCodigoPeriodo(dto.getPeriodoHasta());			
				try{
					dtoPeriodoResultado = monPeriodos.obtienePeriodosPMCCodigo(dtoPeriodo);
				}catch(RemoteException re){
					ctx.setRollbackOnly();
					this.loguearError("aplicarIncobrables: ",re);
					throw new MareException(re,
							UtilidadesError.armarCodigoError(
								CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));		
				}

				if (dtoPeriodoResultado.getOid()==null) {
					ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_SEG, "",
					es.indra.sicc.logicanegocio.seg.ErroresNegocio.SEG_0003));		
					excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
					excepcionParam.addParameter(dto.getPeriodoHasta());	
					throw excepcionParam;		
				}
		
				periodoHasta = dtoPeriodoResultado.getOid();
			}
		}*/
		
		//Long marca = dto.getMarca();
		UtilidadesLog.debug("despues de comprobar periodos ");

		Date fechaDocumentoDesde = null;
		Date fechaDocumentoHasta = null;
		Date fechaVencimientoDesde = null;
		Date fechaVencimientoHasta = null;

		if (dto.getFechaDocumentoDesde() != null){
			fechaDocumentoDesde = new Date(dto.getFechaDocumentoDesde().getTime());
		}
		if (dto.getFechaDocumentoHasta() != null){
			fechaDocumentoHasta = new Date(dto.getFechaDocumentoHasta().getTime());
		}
		if (dto.getFechaVencimientoDesde() != null){
			fechaVencimientoDesde = new Date(dto.getFechaVencimientoDesde().getTime());
		}
		if (dto.getFechaVencimientoHasta() != null){
			fechaVencimientoHasta = new Date(dto.getFechaVencimientoHasta().getTime());
		}

		Date fechaImputacion = null;
		if (dto.getFechaImputacion() != null){
			fechaImputacion = new Date(dto.getFechaImputacion().getTime());
		}
		UtilidadesLog.debug("despues de transformar fechas ");
		
		CabeceraCargosAbonosDirectosLocal localCabecera = null;
		try{
		localCabecera = 
		homeCabecera.create(//Long tipoAbonoSubproceso, String codigoClienteDesde, String codigoClienteHasta, String periodoDesde, String periodoHasta
							numero,//Integer numero,
							//"se quita",//String numLoteCont, --BELC300003415 
							//se quita??(Date)dto.getFechaImputacion(),//Date fecContab, 
							anyo,//String anio, 
							mes,//String periodoMes, 
							fechaActual,//Date fechaDocum, 
							//Se añade??
							new Date(dto.getFechaImputacion().getTime()), //Date fechaValor
							dto.getReferenciaExterna(),//String referenciaExterna, 
							null, //String numeroLoteContabilizacion
							//fechaImputacion,//Date fecContab
              null, //fecContab
							dto.getObservaciones(),//String observaciones, 
							dto.getSubacceso(),//Long subacceso, 
							dto.getOidPais(),//Long pais,
							dto.getEmpresa(), //Long Empresa
							null , //Long Cliente
							this.ctx.getCallerPrincipal().getName() , //CodigoUsuario
							localTipo.getOid(),
							situacion,//situacion
							dto.getClienteDesde(),//Long clienteDesde, 
							dto.getClienteHasta(),//Long clienteHasta,
							dto.getPeriodoDesde(),
							dto.getPeriodoHasta(),
							fechaDocumentoDesde,//Date fecDocumDesde, 
							fechaDocumentoHasta,//Date fecDocumHasta, 
							fechaVencimientoDesde,//Date fecVencimDesde, 
							fechaVencimientoHasta,//Date fecVencimHasta, 
							null,
							dto.getProceso());
		
		}catch(PersistenceException ce){
				this.loguearError(ce);
				ctx.setRollbackOnly();
				throw new MareException(ce, 
					UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));				
		}
		UtilidadesLog.debug("Create de la cabecera");
		/*
		 * Ahora vamos a crear las entidades DetalleDepuracionIncobrables 
		 * que colgaran de la que hemos creado. 
		 * para cada elemento en el array movimientos { 
		 */
		 //MovimientosCuentasCorrientesLocalHome homeMCC = this.getMovimientosCuentasCorrientesLocalHome();
		 //MovimientosCuentasCorrientesLocal localMCC;
     DTOMovimientoCuentaCompleto dtoMovCtaCte = new DTOMovimientoCuentaCompleto();
		 
		 Long movimientos[] = dto.getMovimientos();
		 int numeroLinea = 0;
		 int i=0;
		 try{ // BELC300004937
        // No comprobamos que el array sea distinto de null, porque siempre
        // tiene que llegar al menos una fila
        for (i=0;i<movimientos.length;i++) {
            /*
               * -llamamos al findByPrimaryKey del entity 
               * MovimientosCuentasCorrientes con el elemento del array que 
               * estamos procesando. 
               */
            //localMCC = homeMCC.findByPrimaryKey(movimientos[i]);
            dtoMovCtaCte = obtenerCuentaCorriente(movimientos[i]);
            
            numeroLinea++;
            /*
             * -llamamos al create de DetalleDepuracionIncobrables pasandole
             * los siguientes parametros: 
             * los atributos numeroIdentificacionCuota, numeroSerieCuota, 
             * ejercicioCuota, numeroOrdenCouta, observaciones, consultora 
             * (cliente) los copiamos del entity MovimientoCuentasCorrientes
             * que acabamos de buscar 
             * .la cabecera es el entity de cabecera que hemos creado 
             * .en movimiento el oid del entity MovimientoCuentasCorrientes 
             * .en cuotaAnterior copiamos el valor de cuentaCuota de
             * MovimientoCuentasCorrientes 
             * .en cuotaNueva ponemos el resultado de llamar a 
             * DAODepuracion.obtenerCuentatipoAbono pasandole 
             * dto.criteriosBusqueda.tipoCargoAbono y dto.pais 
             * .en el atributo numeroHistoria ponemos el valor del atributo 
             * ultimoNumeroHistoria del entity movimientos +1 
             */
            //SCS pet. de cbio. nº 002 
            //se obtiene el codigo de proceso de marcas último, de acuerdo a lo que tiene el campo subp_ord_sub_crea, de la cuota tratada 
            //String codProcMarcasUlti = daoCCC.obtieneCodProcMarcasUlti(localMCC.getSubprocesoDeCreacion(), dto.getOidPais());
                                                                        
            String codProcMarcasUlti = daoCCC.obtieneCodProcMarcasUlti(dtoMovCtaCte.getSubprocesoCreacion(), dto.getOidPais());
            UtilidadesLog.debug("SCS codProcMarcasUlti: " + codProcMarcasUlti);
            codProcMarcasUlti = codProcMarcasUlti.substring(0,5);
            codProcMarcasUlti = codProcMarcasUlti.concat("6");
            UtilidadesLog.debug("SCS codProcMarcasUlti (final): " + codProcMarcasUlti);
            
            //Long cuentaTipoAbono = daoDepuracion.obtenerCuentaTipoAbono(dto.getTipoCargoAbono(),dto.getOidPais());
                    
            //DAODepuracion dao = new DAODepuracion(this.ctx.getCallerPrincipal().getName());
            //Long cuotaNueva = dao.obtenerCuentaTipoAbono(dto.getTipoCargoAbono(),dto.getOidPais());
    
            //Integer ultimo = localMCC.getUltimoNumeroHistoria();
            Integer ultimo = dtoMovCtaCte.getUltimoNumeroHistoria();
            if (ultimo == null){
              ultimo =  new Integer(0);
            }else{
              ultimo = new Integer(ultimo.intValue()+1);
            }
            /*localDCAD = homeDCAD.create((Long)localCabecera.getPrimaryKey(),//Long cabecera
                    dtoMovCtaCte.getOidCliente(),
                    new Integer(i + 1),//inte,//numeroLinea, //Integer numeroLinea **nuevo
                    ultimo, //Integer numeroHistoriaGenera, 
                    null, //Date fechaMovimiento, 
                    null, //BigDecimal importeMoneda, 
                    null, //BigDecimal importe, 
                    null, //String referenciaNumeroDocumento, 
                    dtoMovCtaCte.getObservaciones(),
                    null, //String glosaContable, 
                    null, //Long moneda, 
                    null, //Long movimientoBancario, 
                    null, //Long medioPago, 
                    dtoMovCtaCte.getCuentaCuota(),
                    cuotaNueva ,              // Long cuotaNueva, 
                    dtoMovCtaCte.getOid(),
                    null, //Long cuentaCorriente, 
                    null, //Date fechaPagoEnBancos, 
                    this.ctx.getCallerPrincipal().getName() , //String codigoUsuario, 
                    dto.getEmpresa(), //Long empresa, 
                    dto.getTipoCargoAbono() ); // Long tipoAbonoSubproceso
            */
    
            /*
             * Creamos un DTOMovimientoCuentaCompleto y copiamos todos los 
             * campos del entity movimiento y hacemos los siguientes cambios
             * en el dto: 
             * le sumamos 1 al atributo ultimoNumeroHistoria 
             * en cuentaCouta copiamos el atributo cuotaNueva del entity 
             * DetalleDepuracionIncobrables que acabamos de crear. 
             * en marcaSituacion ponemos el valor de la variable 
             * marcaSituacion que obtuvimos al principio. 
             */
             
            DTOMovimientoCuentaCompleto dtoMCC = new DTOMovimientoCuentaCompleto();
            //dtoMCC.setOidCliente(localMCC.getCliente());
            dtoMCC.setOidCliente(dtoMovCtaCte.getOidCliente());
            
    
            //dtoMCC.setCuentaCuota(localDCAD.getCuotaNueva());
            //dtoMCC.setCuentaOrigen(localMCC.getCuentaOrigen());
            dtoMCC.setCuentaOrigen(dtoMovCtaCte.getCuentaOrigen());
            //scs, moneda se pasa NULL a la creacion de DCAD....dtoMCC.setDivisa(localDCAD.getMoneda()); //Puede que se getMoneda
            //dtoMCC.setDocumentoAnyo(localMCC.getDocumentoAnyo());
            dtoMCC.setDocumentoAnyo(dtoMovCtaCte.getDocumentoAnyo());
            //dtoMCC.setDocumentoMesSerie(localMCC.getDocumentoMesSerie());
            dtoMCC.setDocumentoMesSerie(dtoMovCtaCte.getDocumentoMesSerie());
            //dtoMCC.setDocumentoNumero(localMCC.getDocumentoNumero());
            dtoMCC.setDocumentoNumero(dtoMovCtaCte.getDocumentoNumero());
            //dtoMCC.setEjercicioCuota(localMCC.getEjercicioCuota());
            dtoMCC.setEjercicioCuota(dtoMovCtaCte.getEjercicioCuota());
            //dtoMCC.setEmpresa(localMCC.getEmpresa());
            dtoMCC.setEmpresa(dtoMovCtaCte.getEmpresa());
            //dtoMCC.setFechaContabilizacion(localMCC.getFechaContabilizacion());
            dtoMCC.setFechaContabilizacion(dtoMovCtaCte.getFechaContabilizacion());
            //dtoMCC.setFechaDocumento(localMCC.getFechaDocumento());
            dtoMCC.setFechaDocumento(dtoMovCtaCte.getFechaDocumento());
            //dtoMCC.setFechaUltimoMovimiento(localMCC.getFechaUltimoMovimiento());
            dtoMCC.setFechaUltimoMovimiento(dtoMovCtaCte.getFechaUltimoMovimiento());
            //dtoMCC.setFechaValor(localMCC.getFechaValor());
            dtoMCC.setFechaValor(dtoMovCtaCte.getFechaValor());
            //dtoMCC.setFechaVencimiento(localMCC.getFechaVencimiento());
            dtoMCC.setFechaVencimiento(dtoMovCtaCte.getFechaVencimiento());
            //dtoMCC.setImporte(localMCC.getImporte());
            dtoMCC.setImporte(dtoMovCtaCte.getImporte());
            //dtoMCC.setImporteDivisa(localMCC.getImporteDivisa());
            dtoMCC.setImporteDivisa(dtoMovCtaCte.getImporteDivisa());
            //dtoMCC.setImportePagado(localMCC.getImportePagado());
            //dtoMCC.setImportePagadoDivisa(localMCC.getImportePagadoDivisa());
            dtoMCC.setImportePagadoDivisa(dtoMovCtaCte.getImportePagadoDivisa());
            //dtoMCC.setImportePendiente(localMCC.getImportePendiente());
            //dtoMCC.setIndicaDescuentoRecargo(localMCC.getIndicaDescuentoRecargo());
            dtoMCC.setIndicaDescuentoRecargo(dtoMovCtaCte.getIndicaDescuentoRecargo());
            //dtoMCC.setMarca(localMCC.getMarca());
            dtoMCC.setMarca(dtoMovCtaCte.getMarca());
    
            //dtoMCC.setMarcaSituacion(marcaSituacion);
    
            //dtoMCC.setMedioPago(localMCC.getMedioPago());
            dtoMCC.setMedioPago(dtoMovCtaCte.getMedioPago());
            //dtoMCC.setNumeroIdentificadorCuota(localMCC.getNumeroIdentificadorCuota());
            //dtoMCC.setNumeroLoteContabilizacion(localMCC.getNumeroLoteContabilizacion());
            //dtoMCC.setNumeroOrdenCuota(localMCC.getNumeroOrdenCuota());
            
            dtoMCC.setNumeroIdentificadorCuota(dtoMovCtaCte.getNumeroIdentificadorCuota());
            dtoMCC.setNumeroLoteContabilizacion(dtoMovCtaCte.getNumeroLoteContabilizacion());
            dtoMCC.setNumeroOrdenCuota(dtoMovCtaCte.getNumeroOrdenCuota());
            
            //dtoMCC.setNumeroSerieCuota(localMCC.getNumeroSerieCuota());
            //dtoMCC.setObservaciones(localMCC.getObservaciones());
            dtoMCC.setObservaciones(dtoMovCtaCte.getObservaciones());
            //dtoMCC.setOid(localMCC.getOid());
            dtoMCC.setOid(dtoMovCtaCte.getOid());
            dtoMCC.setOidPais(dto.getOidPais());    //como consecuencia de 17855
            //dtoMCC.setPeriodoDesde(localMCC.getPeriodoDesde());
            dtoMCC.setPeriodoDesde(dtoMovCtaCte.getPeriodoDesde());
            //dtoMCC.setReferenciaNumeroDocumentoExterno(localMCC.getReferenciaNumeroDocumentoExterno());
            dtoMCC.setReferenciaNumeroDocumentoExterno(dtoMovCtaCte.getReferenciaNumeroDocumentoExterno());
            //dtoMCC.setSubacceso(localMCC.getSubacceso());
            dtoMCC.setSubacceso(dtoMovCtaCte.getSubacceso());
            //dtoMCC.setSubprocesoCreacion(localMCC.getSubprocesoDeCreacion());
            dtoMCC.setSubprocesoCreacion(dtoMovCtaCte.getSubprocesoCreacion());
            //dtoMCC.setSubprocesoUltimo(localMCC.getSubprocesoUltimo());
            //dtoMCC.setTerritorioAdministrativo(localMCC.getTerritorioAdministrativo());
            dtoMCC.setTerritorioAdministrativo(dtoMovCtaCte.getTerritorioAdministrativo());
            //dtoMCC.setTipoAbonoCreacion(localMCC.getTipoAbonoCreacion());
            dtoMCC.setTipoAbonoCreacion(dtoMovCtaCte.getTipoAbonoCreacion());
            //dtoMCC.setTipoAbonoUltimo(localMCC.getTipoAbonoUltimo());
            //dtoMCC.setTipoCliente(localMCC.getTipoCliente());
            //dtoMCC.setUltimoDocumentoAnyo(localMCC.getUltimoDocumentoAnyo());
            //dtoMCC.setUltimoDocumentoMesSerie(localMCC.getUltimoDocumentoMesSerie());
            //dtoMCC.setUltimoDocumentoNumero(localMCC.getUltimoDocumentoNumero());

            dtoMCC.setTipoCliente(dtoMovCtaCte.getTipoCliente());
            dtoMCC.setUltimoDocumentoAnyo(dtoMovCtaCte.getUltimoDocumentoAnyo());
            dtoMCC.setUltimoDocumentoMesSerie(dtoMovCtaCte.getUltimoDocumentoMesSerie());
            dtoMCC.setUltimoDocumentoNumero(dtoMovCtaCte.getUltimoDocumentoNumero());
    
    
            // A partir de aqui cambia todo
            int ultimoNumeroHistoria = 0;
            if (dtoMovCtaCte.getUltimoNumeroHistoria()!=null) {
              ultimoNumeroHistoria = dtoMovCtaCte.getUltimoNumeroHistoria().intValue()+1;
            }
            dtoMCC.setUltimoNumeroHistoria(new Integer(ultimoNumeroHistoria));
    
            //dtoMCC.setCuentaCuota(localDCAD.getCuotaNueva());
            //dtoMCC.setMarcaSituacion(marcaSituacion);
            dtoMCC.setFechaUltimoMovimiento(new Timestamp(localCabecera.getFechaDocumento().getTime()));
            dtoMCC.setImporteMovimiento(new BigDecimal(dtoMovCtaCte.getImporte().doubleValue()));
    
            dtoMCC.setUltimoDocumentoAnyo(localCabecera.getAnio());
            dtoMCC.setUltimoDocumentoMesSerie(localCabecera.getPeriodoMes());
            dtoMCC.setUltimoDocumentoNumero(localCabecera.getNumero());
            /*
              Falta por mirar estas dos Incidencia 9131
              Proceso de Marcas último = "CCC006"· 
                Subproceso de Marcas último = "1"· 
              
            */
            //Incidencia 9131
            //String procesoMarcasUltimo = "CCC006";
            //Integer subprocesoMarcasUltimo = new Integer(1);
    
            //Long subprocesoUltimo = daoCCC.obtenerOIDSubproceso(dto.getOidPais(),procesoMarcasUltimo,subprocesoMarcasUltimo);
            //dtoMCC.setSubprocesoUltimo(subprocesoUltimo);
    
            //dtoMCC.setTipoAbonoUltimo(dto.getTipoCargoAbono());
    
            // Incidencia BELC300009134 --> Resolver de donde viene el indicador este 
    
            /* MODIFICACIONES POR INCIDENCIA BELC300009134
            Con la variable subproceso obtenida anteriormente (2):
            Hacemos un home.findByPrimaryKey(subproceso) en la entidad Subproceso y recuperamos
            el atributo "indicadorActualizaCuotaSN".
            si nos salta una FinderException lanzamos una MareException con el siguiente mensaje: CCC-0043 (No existe el
            subproceso indicado)
            ...
            ++ultimoNumeroHistoria;
            Cuenta contable Cuota = cuotaNueva (Obtenido unas líneas más arriba);
            */
            SubprocesosLocalHome homeSubprocesos = this.getSubprocesosLocalHome();
            SubprocesosLocal localSubprocesos =null;
            try{
                localSubprocesos = homeSubprocesos.findByPrimaryKey(subproceso);
            }catch(NoResultException fe){
                  ctx.setRollbackOnly();
                  this.loguearError(fe);
                  throw new MareException(fe,
                      UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                        ErroresDeNegocio.SUBPROCESO_INEXISTENTE));
            }
    
          
            Character indicadorActualizarCuotaSN = localSubprocesos.getIndicadorActualizaCuotaSN();
            UtilidadesLog.debug("[AI]indicadorActualizarCuotas: "+indicadorActualizarCuotaSN.charValue());
    
            Double importePagado = dtoMovCtaCte.getImportePagado();
            UtilidadesLog.debug("[AI]importePagado: "+importePagado.doubleValue());
    
            Double importe = dtoMovCtaCte.getImporte();
            UtilidadesLog.debug("[AI]importe: "+importe.doubleValue());
    
            BigDecimal importeMovimiento = dtoMovCtaCte.getImporteMovimiento();
            UtilidadesLog.debug("[AI]importeMovimiento: "+importeMovimiento.intValue());
                    
            /*if (indicadorActualizarCuotaSN.charValue()=='0'){
              dtoMCC.setMarcaSituacion(marcaSituacion);
              UtilidadesLog.debug("[AI]Asignado getMarcaSituacion");					
            }*/
            /*UtilidadesLog.debug("[AI]indicadorActualizarCuotaSN.equals(S))&&(localMCC.getImportePagado()==localMCC.getImporte()))");
            if ((indicadorActualizarCuotaSN.charValue()=='1')&&(importePagado.doubleValue()==importe.doubleValue())){
              dtoMCC.setMarcaSituacion(marcaSituacion);
              UtilidadesLog.debug("[AI]Asignado getMarcaSituacion");
            }*/
            /*UtilidadesLog.debug("[AI]indicadorActualizarCuotaSN.equals('S'))&&(localMCC.getImportePagado()!=localMCC.getImporte()");
            if ((indicadorActualizarCuotaSN.charValue()=='1')&&(importePagado.doubleValue()!=importe.doubleValue())){
              dtoMCC.setMarcaSituacion(localMCC.getMarcaSituacion());
              UtilidadesLog.debug("[AI]Asignado getMarcaSituacion");
            }*/
    
            // Modificado por incidencia BELC300009134
            UtilidadesLog.debug("[AI]Antes Ultimo numero historia");
            Integer ultiNum = dtoMovCtaCte.getUltimoNumeroHistoria();
            if (ultiNum==null){
              dtoMCC.setUltimoNumeroHistoria(new Integer(1));
              UtilidadesLog.debug("[AI]Antes Ultimo numero historia(Cero)"+ultiNum);									
            }else{
              UtilidadesLog.debug("[AI]Antes Ultimo numero historia"+ultiNum);
              dtoMCC.setUltimoNumeroHistoria(new Integer(dtoMovCtaCte.getUltimoNumeroHistoria().intValue()+1));					
            }
            UtilidadesLog.debug("[AI]Asignado Ultimo numero historia");
            //dtoMCC.setUltimoNumeroHistoria(localMCC.getUltimoNumeroHistoria());
            //dtoMCC.setCuentaCuota(cuotaNueva);
            UtilidadesLog.debug("[AI]Asignado cuota nueva");
            dtoMCC.setUsuario(this.ctx.getCallerPrincipal().getName());
            UtilidadesLog.debug("[AI]Asignado usuario");
    
            dtoMCC.setTipoCambio(dtoMovCtaCte.getTipoCambio());
            UtilidadesLog.debug("[AI]Asignado getTipoCambio");
            dtoMCC.setOidSubtipoCliente(dtoMovCtaCte.getOidSubtipoCliente());
            UtilidadesLog.debug("[AI]Asignado getSubtipoCliente");
            dtoMCC.setOidRegion(dtoMovCtaCte.getOidRegion());
            UtilidadesLog.debug("[AI]Asignado getRegion");
            dtoMCC.setOidSeccion(dtoMovCtaCte.getOidSeccion());
            UtilidadesLog.debug("[AI]Asignado getSeccion");
            dtoMCC.setOidSugerenciaVenta(dtoMovCtaCte.getOidSugerenciaVenta());
            UtilidadesLog.debug("[AI]Asignado getSugerencia");
            dtoMCC.setTerritorioAdministrativo(dtoMovCtaCte.getTerritorioAdministrativo());
            UtilidadesLog.debug("[AI]Asignado getTerritorioAdministrativo");
            
            //SCS pet. de cbio. nº 002
            if (codProcMarcasUlti.equals("CCC006")) {
                if (indiActuCuot.longValue()==1) {
                   dtoMCC.setImportePago(dtoMovCtaCte.getImporteMovimiento());  
                }else{
                    dtoMCC.setImportePago(new BigDecimal(0));  
                }
            }else{
                if ((indicadorActualizarCuotaSN.charValue()=='1')){
                  dtoMCC.setImportePago(dtoMovCtaCte.getImporteMovimiento());
                  UtilidadesLog.debug("[AI]Asignado getImporteMovimiento");
                }else{
                  dtoMCC.setImportePago(new BigDecimal(0));
                  UtilidadesLog.debug("[AI]Asignado setImportePago");
                }
            }
            
            dtoMCC.setImportePagado(new Double(dtoMovCtaCte.getImportePagado().doubleValue() + new Double(dtoMCC.getImportePago().doubleValue()).doubleValue()));					
            
            dtoMCC.setImportePendiente(new Double(dtoMovCtaCte.getImporte().doubleValue()-dtoMCC.getImportePagado().doubleValue()));
            
            Integer subprocesoMarcasUltimo = new Integer(1);
            Long subprocesoUltimo = daoCCC.obtenerOIDSubproceso(dto.getOidPais(), codProcMarcasUlti, subprocesoMarcasUltimo);
            
            //segun decu: 1
            dtoMCC.setSubprocesoUltimo(Long.valueOf("1"));
            
            Long marcaSitSalida = new Long(0);
            Long oidCtaCont     = new Long(0); 
            Long oidTipoAbonoSubproceso    = new Long(0);
            Long oidTipoCargoAbono    = new Long(0);
            
            boolean someError = false;
            String mensajeLog = new String();           
            
            if (!(codProcMarcasUlti.equals("CCC006"))) {
                UtilidadesLog.debug("SCS codProcMarcasUlti no igual a: CCC006, dentro del if!!");
                if (daoCCC.obtieneIndActCuotaPais(codProcMarcasUlti, new String("1"), dto.getOidPais()) == null) {
                    mensajeLog = "[CCC]-Selección de Provisiones/Depuraciones <Número de Lote>: " + numero + " <Número Cuota>: " + 
                                  dtoMovCtaCte.getEjercicioCuota() + " <Número Identificador de Cuota>: " + dtoMovCtaCte.getNumeroIdentificadorCuota() + 
                                   ", no existe parametrización para el Subproceso";
                    BelcorpService.getInstance().log.info(mensajeLog);  
                    someError = true;
                }
                
                RecordSet rs1 = daoCCC.obtenerTiposAbonoSubprocesoAndCtaContable(codProcMarcasUlti, new Integer(1), dto.getOidPais());
                if (rs1 == null) {
                    mensajeLog = "[CCC]-Selección de Provisiones/Depuraciones <Número de Lote>: " + numero + " <Número Cuota>: " + 
                                  dtoMovCtaCte.getEjercicioCuota() + " <Número Identificador de Cuota>: " + dtoMovCtaCte.getNumeroIdentificadorCuota() + 
                                 ", no existe parametrización para el Tipo de Abono por Subproceso";
                    BelcorpService.getInstance().log.info(mensajeLog); 
                    someError = true;
                }else{ //me guardo un par de cosas
                    oidTipoAbonoSubproceso = this.bigDecimalToLong(rs1.getValueAt(0,"OID_TIPO_ABON_SUBP"));
                    oidTipoCargoAbono = this.bigDecimalToLong(rs1.getValueAt(0,"TCAB_OID_TCAB"));
                    oidCtaCont  = this.bigDecimalToLong(rs1.getValueAt(0,"CUCO_OID_CUEN_CONT")); 
                }
                
                RecordSet rs2 = daoCCC.obtenerMarcasSituacionSalida(codProcMarcasUlti, new Integer(1), dto.getOidPais(), oidTipoAbonoSubproceso);
                if (rs2 == null) {
                    mensajeLog = "[CCC]-Selección de Provisiones/Depuraciones <Número de Lote>: " + numero + " <Número Cuota>: " + 
                                  dtoMovCtaCte.getEjercicioCuota() + " <Número Identificador de Cuota>: " + dtoMovCtaCte.getNumeroIdentificadorCuota() + 
                                 ", no existe parametrización para las Marcas de situación relacionadas por Tipo de Abono";
                    BelcorpService.getInstance().log.info(mensajeLog);  
                    someError = true;
                }else{ 
                    marcaSitSalida = this.bigDecimalToLong(rs2.getValueAt(0,"OID_MARC_SITU"));
                }
            }
            
            
            
            if (someError) {
                UtilidadesLog.debug("continuo con el proximo registro de CC, por: " + mensajeLog);
                continue;    //segun correo de AG
            }                //<AG20061023> Si ocurre alguno de los 3 errores que existen al recuperar el campo: Proceso de Marcas último (actividad 12), se debe 
                             //dar el error definido en el DECU (log de error) sobre el registro tratado (sólo sobre el registro tratado) y continuar con el 
                             //siguiente registro (es decir, si hay error, no podrá grabarse el registro tratado en la entidad Detalle de Cargos y Abonos y 
                             //consecuentemente no puede llamarse a CU Actualizar Cuenta). En todo caso, de continuar con la inserción de este registro daría error 
                             //de integridad referencial, al no existir el proceso, subproceso o tipo de abono que se está buscando.
            
            //Agregado por cvalenzu - V-CCC-033
            Long oidTipoAbonoSubproceso2 = null;
            if (codProcMarcasUlti.equals("CCC006")) {
                RecordSet rs1 = daoCCC.obtenerOidTiposAbonoSubproceso(codProcMarcasUlti, 
                new Integer(1), dto.getOidPais(), dto.getTipoCargoAbono());
                
                if (rs1 != null) {                    
                    oidTipoAbonoSubproceso2 = this.bigDecimalToLong(rs1.getValueAt(0,"OID_TIPO_ABON_SUBP"));                    
                }            
            }                        
            //FIN - Agregado por cvalenzu - V-CCC-033
            UtilidadesLog.debug("**** oidTipoAbonoSubproceso2: " + oidTipoAbonoSubproceso2);                        
            
            if (codProcMarcasUlti.equals("CCC006")) {
                //Modificado por cvalenzu - V-CCC-033
                //El error era que se seteaba al campo tipoAbonoUltimo del DTO
                //el valor del combo "Tipo cargo / abono" de la pantalla
                //Seleccionar provisiones/depuraciones
                //Aparecia el siguiente error: 
                //"integrity constraint (OWN_PERU.DCAD_TASP_FK) violated"
                //Ahora se setea el oid de tipo de abono subproceso
                //dtoMCC.setTipoAbonoUltimo(dto.getTipoCargoAbono());
                dtoMCC.setTipoAbonoUltimo(oidTipoAbonoSubproceso2);
                //FIN - Modificado por cvalenzu - V-CCC-033
            } else {
                dtoMCC.setTipoAbonoUltimo(oidTipoAbonoSubproceso);
            }    
          
                
            if (codProcMarcasUlti.equals("CCC006"))
                dtoMCC.setMarcaSituacion(marcaSituacion);
            else   
                dtoMCC.setMarcaSituacion(marcaSitSalida);
             
            if ((indiActuCuot.longValue()==0) || (codProcMarcasUlti.equals("CCC006"))) {
                //!!se mueve siempre la marca de situación recuperada.
            }else{
                if (indiActuCuot.longValue()==1){
                    if (importePagado.doubleValue()==importe.doubleValue())   
                        dtoMCC.setMarcaSituacion(marcaSituacion);
                    if (importePagado.doubleValue()!=importe.doubleValue())
                        dtoMCC.setMarcaSituacion(dtoMovCtaCte.getMarcaSituacion());    
                }
            }
            
            if (codProcMarcasUlti.equals("CCC006"))
                dtoMCC.setCuentaCuota(cuentaContable);
            else
                dtoMCC.setCuentaCuota(oidCtaCont);
            
            //////////////////////////////////////////////////////////
            BigDecimal bdImporteDivisa=null;
            BigDecimal bdImportePendiente=null;
            if(dtoMovCtaCte.getImporteDivisa()!=null){
                bdImporteDivisa = new BigDecimal(dtoMovCtaCte.getImporteDivisa().toString());
            }
            if(dtoMovCtaCte.getImportePendiente()!=null){
                bdImportePendiente = new BigDecimal(dtoMovCtaCte.getImportePendiente().toString());
            }
            this.grabarDetCargoAbono(this.crearStrInsercionDCAD((Long)localCabecera.getPrimaryKey(),
                    dtoMovCtaCte.getOidCliente(),
                    new Integer(i + 1),
                    //ultimo, 
                    dtoMCC.getUltimoNumeroHistoria(),
                    fechaActual, 
                    bdImporteDivisa, 
                    bdImportePendiente, 
                    null, 
                    dtoMovCtaCte.getObservaciones(),
                    null, 
                    null, 
                    null, 
                    null, 
                    dtoMovCtaCte.getCuentaCuota(),       //CUCO_OID_CUEN_CONT_CUOT_ANTE
                    //cuotaNueva,
                    dtoMCC.getCuentaCuota(),             //CUCO_OID_CUEN_CONT_CUOT_NUEV
                    dtoMovCtaCte.getOid(),
                    null, 
                    null, 
                    this.ctx.getCallerPrincipal().getName(),
                    dto.getEmpresa(), 
                    dtoMCC.getTipoAbonoUltimo()));
                    //dto.getTipoCargoAbono())); 
                    
            
            UtilidadesLog.debug("Create del detalle ["+i+"]");            
            /*
             * Llamamos al actualizarCuenta del MONCuentasCorrientes 
             * pasandole el DTOMovimientoCuentaCompleto que hemos creado.
             */
            UtilidadesLog.debug("actualizar cuenta, con dtoMCC (actual): " + dtoMCC + ", y anterior: " + dtoMovCtaCte);
                       
            StringBuffer queryInsercion = new StringBuffer();
            queryInsercion.append(this.actualizarCuenta(dtoMCC, dtoMovCtaCte));   //dto actual y anterior

            if (codProcMarcasUlti.equals("CCC006")) {
                dtoMCC.setTipoAbonoUltimo(dto.getTipoCargoAbono());
                // vbongiov -- RI 20080583 - BLO 2da parte -- 24/04/2008
                queryInsercion.append(this.generarStringUpdateMCC(dtoMCC, subproceso, mes, anyo).toString());    
            }else{
                dtoMCC.setTipoAbonoUltimo(oidTipoCargoAbono);
                // vbongiov -- RI 20080583 - BLO 2da parte -- 24/04/2008
                queryInsercion.append(this.generarStringUpdateMCC(dtoMCC, subprocesoUltimo, mes, anyo).toString());
            }
            
            this.grabarMovCCyHistorico(queryInsercion);
    
            //Eliminamos los registros de las tablas de bloqueo y de esta manera 
            //liberamos dichos registros y el acceso a las tablas para otros usuarios 
            UtilidadesLog.debug("eliminar bloqueo");
            monCC.eliminarBloqueoMovCC();
            /*
             * Llamamos al metodo ponerBloqueoFinanciero de la interfaz 
             * IMaestroProductos de MAE pasandole el atributo consultora 
             * del detalle que hemos creado y como motivo:
             * "Depuración incobrables CCC" 
             */				
             // 3 Parametros x incidencia: BELC300008899 
           /* UtilidadesLog.debug("poniendo bloqueo financiero: " + dtoMovCtaCte.getOidCliente());				*/
           UtilidadesLog.debug("bloqueo financiero desplazado se realiza en otro caso de uso ");
           /* monClientes.ponerbloqueoFinanciero(dtoMovCtaCte.getOidCliente(),"Depuración incobrables CCC","");*/
        }
		 }
     catch(RemoteException re){
        ctx.setRollbackOnly();
        this.loguearError(re);
        re.printStackTrace();
      	throw new MareException(re,
				UtilidadesError.armarCodigoError(
        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
		 }
     catch(MareException me) {
        this.loguearError(me);
        ctx.setRollbackOnly();
        me.printStackTrace();
        throw me;
		 }
     catch(Exception e) {
        this.loguearError(e);
        ctx.setRollbackOnly();
        e.printStackTrace();
        throw new MareException(e,
				UtilidadesError.armarCodigoError(
				CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		 }
		 
     UtilidadesLog.info("MONProvisionesDepuracionesBean.aplicarIncobrables(DTOAplicarIncobrables dto): Salida");
	}

	public DTOSalida buscarClientesBloqueados(DTOBuscarClienteBloqueo dto) throws MareException {
		/*
		 * Llamamos al método buscarClientesBloqueoFinanciero de la interfaz 
		 * IMaestroCliente pasandole el dto recibido, devolvemos el DTOSalida 
		 * obtenido de la llamada
		 * BELC300003277
		 */
		UtilidadesLog.info("MONProvisionesDepuracionesBean.buscarClientesBloqueados(DTOBuscarClienteBloqueo dto): Entrada");
		MONClientes monClientes = this.getMONClientes();
		DTOSalida dtoSalida = null;
		try{
			dtoSalida = monClientes.buscarClientesBloqueoFinanciero(dto);
		}catch(RemoteException re) {
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}

		int regs = dtoSalida.getResultado().getRowCount();
		UtilidadesLog.debug("Num registros:"+regs);
        if (regs==0) {                                                                            
			   UtilidadesLog.debug("****MONProvisionesDepuraciones.buscarClientesBloqueados(): No hay datos ");                                      
			   throw new MareException(new Exception(),                                                            
			   UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
        }      
		
		UtilidadesLog.info("MONProvisionesDepuracionesBean.buscarClientesBloqueados(DTOBuscarClienteBloqueo dto): Salida");
		return dtoSalida;
	}

	public DTOSalida buscarClientesDesbloqueados(DTOBuscarClienteBloqueo dto) throws  RemoteException, MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.buscarClientesDesbloqueados(DTOBuscarClienteBloqueo dto): Entrada");
		MONClientes monClientes = this.getMONClientes();
		DTOSalida dtoSalida = null;
		UtilidadesLog.debug(dto);
		try{
			dtoSalida = monClientes.buscarClientesDesBloqueoFinanciero(dto);
		}catch(RemoteException re) {
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		int regs = dtoSalida.getResultado().getRowCount();
		UtilidadesLog.debug("Num registros:"+regs);
        if (regs==0) {                                                                            
			   UtilidadesLog.debug("****MONProvisionesDepuraciones.buscarClientesDesbloqueados(): No hay datos ");                                      
			   throw new MareException(new Exception(),                                                            
			   UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
        }      
		
		UtilidadesLog.info("MONProvisionesDepuracionesBean.buscarClientesDesbloqueados(DTOBuscarClienteBloqueo dto): Salida");
		return dtoSalida;
	}

	/**
	 * Por cada elemento en el array llamamos al metodo 
	 * quitarBloqueoFinanciero de la interfaz IMaestroClientes pasandole 
	 * dicho elemento.	 
	 * @param oids Objeto del tipo DTOOIDs
	 * @exception MareException
	 * @return void
	 */
	public void desbloquearClientes(DTOOIDs oids) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.desbloquearClientes(DTOOIDs oids): Entrada");
		/* Por cada elemento en el array llamamos al metodo 
		 * quitarBloqueoFinanciero de la interfaz IMaestroClientes pasandole 
		 * dicho elemento.
		 */
		MONClientes mon = this.getMONClientes();
		Long valores[] = oids.getOids();
		int i=0;
		try{
			for (i=0;i<valores.length;i++) {
				mon.quitarBloqueoFinanciero(valores[i]);	
			}
		}catch(RemoteException re) {
			ctx.setRollbackOnly();
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		UtilidadesLog.info("MONProvisionesDepuracionesBean.desbloquearClientes(DTOOIDs oids): Salida");
	}

	public void bloquearClientes(DTOBloquearClientes oids) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.bloquearClientes(DTOBloquearClientes oids): Entrada");
		/* Por cada elemento en el array (OIDs) llamamos al metodo 
		 * ponerBloqueoFinanciero(oid) de la interfaz 
		 * IMaestroClientes pasandole dicho elemento.
		 */ 


		MONClientes mon = this.getMONClientes();
		int i=0;
		DTOBloquearCliente[] dtoBloquear = oids.getBloquearCliente();
		try{
			for (i=0;i<dtoBloquear.length;i++) {
				if (dtoBloquear[i].getMotivoBloqueo()==null){
						throw new MareException(new Exception(),
								UtilidadesError.armarCodigoError(
									CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO));
				}
				mon.ponerbloqueoFinanciero(dtoBloquear[i].getOidCliente(), dtoBloquear[i].getMotivoBloqueo(), dtoBloquear[i].getObservacionesBloqueo());
			}
		}catch(RemoteException re) {
			ctx.setRollbackOnly();
			this.loguearError(re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		UtilidadesLog.info("MONProvisionesDepuracionesBean.bloquearClientes(DTOBloquearClientes oids): Salida");
	}

	// BELC300003397 - Se quita y se pone uno que se llama igual en DAOCCC
	/*private RecordSet obtenerTiposCargoSubproceso(Long subproceso) throws MareException {
		/* Devuelve un recordset con los tipos de abono para el subproceso
		 * especificado, para cada uno devuelve oid y descripcion.
		 * Creamos un DTOMarcasPorTipoAbono y rellenamos el atributo subproceso 
		 * con el parametro recibido.
		 * Llamamos a MONMarcasPorTipoAbono.buscar pasandole el dto que acabamos
		 * que crear.
		 * Con el recordset que obtenemos creamos un recordset reducido
		 * quedandonos con las columas: tipoAbono.oid y tipoAbono.descripcion.
		 * Devolvemos el recordset reducido.
		 * Incidencias 3279 y BELC300003364
		 *
		DTOMarcasPorTipoAbono dtoBMT = new DTOMarcasPorTipoAbono();
		dtoBMT.setSubproceso(subproceso);
		
		MONMarcasPorTipoAbono mon = this.getMONMarcasPorTipoAbono();
		DTOSalida dtoSalida;
		try{
			dtoSalida = mon.buscar(dtoBMT);
		}catch(RemoteException re){
			this.loguearError("obtenerTiposCargoSubproceso: RemoteException:",re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		RecordSet result = dtoSalida.getResultado();
		RecordSet resultado = new RecordSet();
		 
		return null;
	}*/

	public DTOCargaInicialBuscarLotes cargaInicialBuscarLotes(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.cargaInicialBuscarLotes(DTOBelcorp dto): Entrada");
		/************************ tiposCargoAbono **************************/
		/*
		 * Creamos un DTOCargaInicialBuscarLotes que rellenamos de la siguiente 
		 * manera: 
		 * -tiposCargoAbono: llamamos al método obtenerTiposCargoSubproceso 
		 * pasandole el resultado de llamar a obtenerSubprocesoAsociado. 
		 * BELC300003397
		 */
		DTOCargaInicialBuscarLotes dtoCIBL = new DTOCargaInicialBuscarLotes();
		DAOCCC daoCCC = new DAOCCC();
		dtoCIBL.setTipoCargoAbono(daoCCC.obtenerTiposCargoSubproceso(this.obtenerSubprocesoAsociado(dto.getOidPais()),dto.getOidIdioma()));

		/***************** canales, accesos y subaccesos **********************/
		/*
		 * Creamos dos DTOCAS de SEG y rellenamos el primero con los tres 
		 * atributos a false y el segundo con los tres atributos a true. 
		 */
		DTOFiltroCAS dtoFiltroCASuno = new DTOFiltroCAS();
		DTOFiltroCAS dtoFiltroCASdos = new DTOFiltroCAS();
		dtoFiltroCASuno.setBaccesos( Boolean.valueOf(false));
		dtoFiltroCASuno.setBcanales( Boolean.valueOf(false));
		dtoFiltroCASuno.setBsubaccesos( Boolean.valueOf(false));
		dtoFiltroCASdos.setBaccesos( Boolean.valueOf(true));
		dtoFiltroCASdos.setBcanales( Boolean.valueOf(true));
		dtoFiltroCASdos.setBsubaccesos( Boolean.valueOf(true));
		/*
		 * Creamos un DTOCargaCAS tambien de SEG y metemos en el atributo todos
		 * el primer DTOCAS y el filtro el segundo, además metemos el pais y el
		 * idioma del DTOBelcorp que hemos recibido. 
		 */
		DTOCargaCAS dtoCargaCAS = new DTOCargaCAS();
		dtoCargaCAS.setTodos(dtoFiltroCASuno);
		dtoCargaCAS.setFiltro(dtoFiltroCASdos);
		dtoCargaCAS.setOidPais(dto.getOidPais());
		dtoCargaCAS.setOidIdioma(dto.getOidIdioma());
		/*
		 * Con este DTOCAS llamamos a obtieneCanalAccesoSubacceso (3491) y 
		 * obtenemos un DTOCAS. 
		 */
		MONMantenimientoSEG monManteminientoSEG = this.getMONMantenimientoSEG();
		DTOCAS dtoCAS = null;
		try{
			dtoCAS = monManteminientoSEG.obtieneCanalAccesoSubacceso(dtoCargaCAS);
		}catch(RemoteException re){
			this.loguearError(re);
            throw new MareException(re,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		/*
		 * -Con los recordset que obtenemos rellenamos los atributos correspondientes:
		 * canales, accesos y subaccesos. Con la particularidad de que les
		 * quitamos la segunda columna (la del código). 
		 */
		RecordSet canales = dtoCAS.getCanales();
		RecordSet accesos = dtoCAS.getAccesos();
		RecordSet subaccesos = dtoCAS.getSubaccesos();
		// No se eliminan las segundas columnas por la incidencia BELC300004525
		// canales.removeColumn(1); // la segunda columna
		// accesos.removeColumn(1);
		// subaccesos.removeColumn(1);
	
		dtoCIBL.setCanales(canales);
		dtoCIBL.setAccesos(accesos);
		dtoCIBL.setSubaccesos(subaccesos);

		/*************************** situaciones ******************************/
		/*
		 * -situaciones: llamamos al metodo de este MON obtenerPosiblesSituaciones
		 * pasandole el idioma del dto.
		 */
		dtoCIBL.setSituaciones(this.obtenerPosiblesSituaciones(dto.getOidIdioma()));		
		
		UtilidadesLog.info("MONProvisionesDepuracionesBean.cargaInicialBuscarLotes(DTOBelcorp dto): Salida");
		
		return dtoCIBL;
	}

	public DTOSalida buscarLotes(DTOBuscarLotes dto) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.buscarLotes(DTOBuscarLotes dto): Entrada");
		/*
		 * Se delega la peticion al método buscarLotesDepuracion del
		 * DAODepuracion
		 */
		String usuario = ctx.getCallerPrincipal().getName();
		//String usuario="USUARIO1";
		DAODepuracion daoDepuracion = new DAODepuracion(usuario);
		
		DTOSalida dtoSalida = daoDepuracion.buscarLotesDepuracion(dto);
		UtilidadesLog.info("MONProvisionesDepuracionesBean.buscarLotes(DTOBuscarLotes dto): Salida");
		return dtoSalida;
	}//OK

	public DTOConsultarDepuracion obtenerDetalleDepuracion(DTOOIDPAG oid) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerDetalleDepuracion(DTOOIDPAG oid): Entrada");
		
		 // Delegamos la petición en el método del mismo nombre del DAODepuracion
		 
		String usuario = ctx.getCallerPrincipal().getName();
		//String usuario="USUARIO1";
		DAODepuracion daoDepuracion = new DAODepuracion(usuario);
		DTOConsultarDepuracion resultado = daoDepuracion.obtenerDetalleDepuracion(oid);
		
		//Modificado por incidencia BELC300008813
		CabeceraCargosAbonosDirectosLocal localCCAD;
		CabeceraCargosAbonosDirectosLocalHome homeCCAD = this.getCabeceraCargosAbonosDirectosLocalHome();
		try {
			localCCAD=homeCCAD.findByPrimaryKey(oid.getOid());
		} catch(NoResultException fe){
                        ctx.setRollbackOnly();
                        this.loguearError(fe);
                        throw new MareException(fe,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));			 
		} 

		//resultado.setAcceso(localCCAD);
		resultado.setAnio(localCCAD.getAnio());
                //resultado.setCanal(localCCAD);
		resultado.setClienteDesde(localCCAD.getCodigoClienteDesde());
		resultado.setClienteHasta(localCCAD.getCodigoClienteHasta());
		//resultado.setEmpresa(localCCAD.getEmpresa()); empresa es estring y getempresa es long
		resultado.setFechaDocumentoDesde(localCCAD.getFechaDocumentoDesde());
		resultado.setFechaDocumentoHasta(localCCAD.getFechaDocumentoHasta());
		resultado.setFechaImputacion(localCCAD.getFechaDocumento());
		resultado.setFechaVencimientoDesde(localCCAD.getFechaVencimientoDesde());
		resultado.setFechaDocumentoHasta(localCCAD.getFechaDocumentoHasta());
		//resultado.setImporteRegistrosDelNumero(localCCAD);
		resultado.setMes(localCCAD.getPeriodoMes());
		resultado.setNumero(localCCAD.getNumero());
		resultado.setObservaciones(localCCAD.getObservaciones());
		resultado.setOidCabecera(localCCAD.getOid());
		resultado.setPeriodoDesde(localCCAD.getPeriodoDesde());
		resultado.setPeriodoHasta(localCCAD.getPeriodoHasta());
		resultado.setReferencia(localCCAD.getReferenciaExterna());
		
		//resultado.setSituacion(localCCAD.getSituacion()); el metodo devuelve un long y el dto espera un string
		//resultado.setSubAcceso(); el metodo devuelve un long y el dto espera un string
		
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerDetalleDepuracion(DTOOIDPAG oid): Salida");
		return resultado;	

		
	}//OK

	/**
	 * @param oids DTO del tipo DTOOIDS con los oids de las cuotas que queremos
	 * eliminar
	 * @exception MareException
	 */
	public void eliminarCuotas(DTOOIDs oids) throws MareException {
        UtilidadesLog.info("MONProvisionesDepuracionesBean.eliminarCuotas(DTOOIDs oids): Entrada");
        
        try {        
            //modificado por incidencia 9960
            // Boolean todosBorrados=new Boolean(true);
            
            /*Recorremos el array DTOOIDs con los oids de los DetallesCargosAbonosDirectos: 
            { 
            Para cada elemento en el array { 
            Hacemos un findByPrimaryKey en el entity DetalleCargosAbonosDirectos con el elemento que estamos procesando. 
            
            Obtenemos el atributo "movimiento" (MovimientoCuentaCorriente) y hacemos un findByPrimaryKey(movimiento) sobre la entidad MovimientosCuentaCorriente. 
            
            Llenamos un DTOMovimientoCuentaCompleto con los datos del MovimientoCuentaCorriente. 
            */
            DetalleCargosAbonosDirectosLocalHome homeDCAD = this.getDetalleCargosAbonosDirectosLocalHome();
            DetalleCargosAbonosDirectosLocal localDCAD = null;
            
            Long movimiento=null;            
            
            MovimientosCuentasCorrientesLocalHome homeMovCC=this.getMovimientosCuentasCorrientesLocalHome();
            MovimientosCuentasCorrientesLocal localMovCC=null;
            MONCuentasCorrientes monCuentasCorrientes = this.getMONCuentasCorrientes();
            
            MONValidacion monValidacion = this.getMONValidacion();
            
            Long array[] = oids.getOids();
            if (array!=null && array.length>0) {
                for (int i=0;i<array.length;i++) {
                    // Modificacion por Incidencia 23354
                    //try{
                    UtilidadesLog.debug("SCS, busco en: DetalleCargosAbonosDirectos, por PK: " + array[i]);
                    localDCAD = homeDCAD.findByPrimaryKey(array[i]);
                    UtilidadesLog.debug("SCS, la local es (cabecera-consultora-empresa): " + localDCAD.getCabecera() + " " + localDCAD.getConsultora() + " " + localDCAD.getEmpresa());
                    //validamos el acceso
                    if (!(monValidacion.validarAccesos(null, localDCAD.getEmpresa(), null,
                        null, null, null, null,
                        null, null, null, null)).booleanValue()) {
                        throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
                    }
                    movimiento=localDCAD.getMovimiento();
                    UtilidadesLog.debug("SCS, el movimiento, es: " + movimiento);
                    /**
                    * Modificacion por Incidencia 23354
                    
                    UtilidadesLog.debug("SCS, busco en: MovimientosCuentasCorrientes por movimiento");
                    localMovCC=homeMovCC.findByPrimaryKey(movimiento);
                    UtilidadesLog.debug("SCS, la local es (clte.-cod.usua.)" + localMovCC.getCliente() + " " + localMovCC.getCodigoUsuario());
                    }catch(FinderException fe){
                    ctx.setRollbackOnly();
                    this.loguearError(fe);
                    throw new MareException(fe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));			 
                    } catch (RemoteException re) {
                    this.loguearError(re);
                    throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    //Llenamos un DTOMovimientoCuentaCompleto con los datos del MovimientoCuentaCorriente. 
                    DTOMovimientoCuentaCompleto dtoMovimiento = new DTOMovimientoCuentaCompleto();
                    dtoMovimiento.setOid(localMovCC.getOid());
                    dtoMovimiento.setUltimoNumeroHistoria(localMovCC.getUltimoNumeroHistoria());
                    dtoMovimiento.setOidCliente(localMovCC.getCliente());
                    dtoMovimiento.setOidPais(oids.getOidPais());
                    dtoMovimiento.setNumeroOrdenCuota(localMovCC.getNumeroOrdenCuota());
                    
                    try{
                    //ver incidencia 9934: Primero se elimina de DetalleCargoAbonoDirecto y después se llama a retroceso cuenta
                    UtilidadesLog.debug("SCS, voy a borrar detalle de cargos y abonos directos!!");
                    localDCAD.remove();
                    monCuentasCorrientes.retrocesoCuenta(dtoMovimiento);
                    }catch(RemoteException re) {
                    ctx.setRollbackOnly();
                    this.loguearError(re);
                    throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }catch(RemoveException re) {
                    ctx.setRollbackOnly();	
                    this.loguearError(re);
                    throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
                    */                   
                    if (movimiento == null) {
                        UtilidadesLog.debug("SAB, como el movimiento es nulo NO busco en MovimientosCuentasCorrienteso");
                        try {
                            //ver incidencia 9934: Primero se elimina de DetalleCargoAbonoDirecto y después se llama a retroceso cuenta
                            UtilidadesLog.debug("SAB, voy a borrar detalle de cargos y abonos directos!!");
                            homeDCAD.remove(localDCAD);
                        } catch(PersistenceException re) {
                            ctx.setRollbackOnly();	
                            this.loguearError(re);
                            throw new MareException(re,
                            UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                    
                    } else {
                        UtilidadesLog.debug("SCS, busco en: MovimientosCuentasCorrientes por movimiento");
                        localMovCC=homeMovCC.findByPrimaryKey(movimiento);
                        UtilidadesLog.debug("SCS, la local es (clte.-cod.usua.)" + localMovCC.getCliente() + " " + localMovCC.getCodigoUsuario());
                        //Llenamos un DTOMovimientoCuentaCompleto con los datos del MovimientoCuentaCorriente. 
                        DTOMovimientoCuentaCompleto dtoMovimiento = new DTOMovimientoCuentaCompleto();
                        dtoMovimiento.setOid(localMovCC.getOid());
                        dtoMovimiento.setUltimoNumeroHistoria(localMovCC.getUltimoNumeroHistoria());
                        dtoMovimiento.setOidCliente(localMovCC.getCliente());
                        dtoMovimiento.setOidPais(oids.getOidPais());
                        dtoMovimiento.setNumeroOrdenCuota(localMovCC.getNumeroOrdenCuota());
                        
                        try {
                            //ver incidencia 9934: Primero se elimina de DetalleCargoAbonoDirecto y después se llama a retroceso cuenta
                            UtilidadesLog.debug("SCS, voy a borrar detalle de cargos y abonos directos!!");
                            homeDCAD.remove(localDCAD);
                            monCuentasCorrientes.retrocesoCuenta(dtoMovimiento);
                        } catch(RemoteException re) {
                            ctx.setRollbackOnly();
                            this.loguearError(re);
                            throw new MareException(re,
                            UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        } catch(PersistenceException re) {
                            ctx.setRollbackOnly();	
                            this.loguearError(re);
                            throw new MareException(re,
                            UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                    }
                }//for
            }
        
        } catch(Exception ex) {
            UtilidadesLog.error("Error Logeando Pila: "+ex.getMessage());
            ex.printStackTrace();
        }			
        
        UtilidadesLog.info("MONProvisionesDepuracionesBean.eliminarCuotas(DTOOIDs oids): Salida");
        //quitado por incidencia 9960
        //return todosBorrados;
	}//ok

        /**
         * 
         * @param dto DTOOID con el oid de una CabeceraCargosAbonos
         * @exception MareException
         * @return true si se borraron todas, false en otro caso
         */
        public void eliminar(DTOOID dto) throws MareException {
            UtilidadesLog.info("MONProvisionesDepuracionesBean.eliminar(DTOOID dto): Entrada");
            /*
            * Llamamos a DAODepuracion.obtenerLineasDetalle pasandole el oid del dto. 
            */
            String usuario = ctx.getCallerPrincipal().getName();
            DAODepuracion daoDepuracion = new DAODepuracion(usuario);
            DTOOIDs dtoOIDs = daoDepuracion.obtenerLineasDetalle(dto.getOid());
            /*
            * Llamamos a eliminarCuotas pasandole el resultado de la llamada anterior.
            * No capturamos la MareException que lanza dicho método, de modo que si
            * se lanza una no se continua con el método. 
            */
            this.eliminarCuotas(dtoOIDs);
            /*
            * Si eliminarCuotas nos devuelve true (quiere decir que pudo eliminar todas) { 
            * Llamamos al método remove del home del entity CabeceraDepuracionIncobrables
            * pasandole el oid del dto. 
            * devolvemos un DTOBoolean con el valor true. 
            * } 
            * 
            * devolvemos un DTOBoolean con el valor false. 
            */
    
            try {
                    CabeceraCargosAbonosDirectosLocalHome home = this.getCabeceraCargosAbonosDirectosLocalHome();
                    CabeceraCargosAbonosDirectosLocal local = home.findByPrimaryKey(dto.getOid());
                    home.remove(local);			
            
            } catch(PersistenceException re) {
                    ctx.setRollbackOnly();
                    this.loguearError(re);
                    throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }		
            UtilidadesLog.info("MONProvisionesDepuracionesBean.eliminar(DTOOID dto): Salida");
        }//ok

        public void aprobarRechazar(DTOAprobar dto) throws MareException {
        UtilidadesLog.info("MONProvisionesDepuracionesBean.aprobarRechazar(DTOAprobar dto): Entrada");
        //COL	
        ClienteBloqueoLocalHome clienteBloquepLH = null;
        ClienteBloqueoLocal clienteBloquepL;        
        
        String usuario = ctx.getCallerPrincipal().getName();
        DAODepuracion daoDepuracion = new DAODepuracion(usuario);
        
        RecordSet resultado = daoDepuracion.obtenerTiposBloqueo(null,Boolean.TRUE);   
        
        Long oidTipoBloqueo = null;
        Long nivelGravedadBloqueo = null;
        if(resultado!= null) {
            UtilidadesLog.debug("paso 1");
            oidTipoBloqueo = new Long (resultado.getValueAt(0,0).toString());
            nivelGravedadBloqueo = new Long (resultado.getValueAt(0,3).toString());
        }        
        //Fin COL
        
        /*
        * Hacemos un fingByPrimaryKey del entity CabeceraCargosAbonosDirectos 
        * con el atributo depuracion del dto. 
        */
        CabeceraCargosAbonosDirectosLocalHome homeCCAD = this.getCabeceraCargosAbonosDirectosLocalHome();
        CabeceraCargosAbonosDirectosLocal localCCAD;
        
        try{
                localCCAD = homeCCAD.findByPrimaryKey(dto.getDepuracion());
        } catch(NoResultException fe) {
                ctx.setRollbackOnly();
                this.loguearError(fe);
                throw new MareException(fe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));			
        }                        
        //nuevo
        /*Si el atributo situacionIncobrable != CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO 
        * lanzamos una MareException con el código de mensaje: CCC-0004 
        * (Para realizar la operación seleccionada sobre el lote, éste debe estar en estado solicitado) 
        */
        if (localCCAD.getSituacion().longValue()!=new Long(CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO).longValue()) {
                UtilidadesLog.error("aprobarRechazar: Estado no solicitado : CCC-0004");
                throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                ErroresDeNegocio.LOTE_EN_ESTADO_NO_SOLICITADO));
        }
        
        ArrayList oidsClientes = daoDepuracion.obtenerClientesDetalle(dto.getDepuracion());
        
        /*si (dto.aprobar) { Establecemos el atributo situacionIncobrable = CCCConstantes.INCOBRABLE_SITUACION_APROBADO*/ 
        if (dto.getAprobar().booleanValue()) {
                UtilidadesLog.debug("paso 2");
                localCCAD.setSituacion(new Long(CCCConstantes.INCOBRABLE_SITUACION_APROBADO));
                
                //COL
                if(oidTipoBloqueo!=null) {
                        UtilidadesLog.debug("paso 3");
                        DTOClienteBloqueo dtoClienBloq = null;
                        ArrayList listaBloqueo = daoDepuracion.obtenerClientesBloqueo(oidsClientes);
                        
                        for (int i=0; i <listaBloqueo.size(); i++ ) {
                                dtoClienBloq = (DTOClienteBloqueo) listaBloqueo.get(i);
                                for (int a=0; a<oidsClientes.size(); a++) {
                                    if(oidsClientes.get(a).equals(dtoClienBloq.getOidCliente())) {
                                            oidsClientes.remove(a);
                                            break;
                                    }
                                }
                                UtilidadesLog.debug("paso 4");
                                if(dtoClienBloq != null && !oidTipoBloqueo.equals(dtoClienBloq.getOidTipoBloqueo())) {
                                    if(dtoClienBloq.getNvlGravedadBloqueo().intValue() > nivelGravedadBloqueo.intValue()) {
                                        
                                        UtilidadesLog.debug("paso 5");                                        
                                        try {
                                            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                                            StringBuffer consulta = new StringBuffer();
                                            consulta.append(" UPDATE MAE_CLIEN_BLOQU A ");
                                            consulta.append("    SET A.FEC_DESB = TO_DATE('"+sdf1.format(new Date(System.currentTimeMillis())) +"','dd/MM/yyyy') ");
                                            consulta.append("      , A.VAL_USUA_DESB = '"+usuario+"'");
                                            consulta.append("      , A.MAAB_OID_VALO_ACCI_DESB = 1000 ");// parametria fija???? oid 1000 automatico"
                                            consulta.append("      , A.OBS_DESB = 'Provisión/Depuración Incobrable - Automático'" );
                                            consulta.append("  WHERE A.CLIE_OID_CLIE = "+dtoClienBloq.getOidCliente() );
                                            consulta.append("    AND A.TIBQ_OID_TIPO_BLOQ = "+dtoClienBloq.getOidTipoBloqueo() );
                                            
                                            // Se ejecuta la consulta 
                                            BelcorpService bs = UtilidadesEJB.getBelcorpService();
                                            bs.dbService.executeUpdate(consulta.toString());
                                        
                                        } catch (Exception ex) {
                                            UtilidadesLog.info(ex); 
                                            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                                            
                                        } 
                                        
                                        try {
                                            clienteBloquepLH = this.getClienteBloqueoLocalHome();
                                            clienteBloquepL = clienteBloquepLH.create(dtoClienBloq.getOidCliente(), oidTipoBloqueo, new Timestamp(System.currentTimeMillis()), "Provisión/Depuración Incobrable - Automático", usuario, "Provisión/Depuración Incobrable - Automático");
                                            clienteBloquepL.setMaab_oid_valo_acci_bloq(new Long(1000));// parametria fija???? oid 1000 automatico    
                                            clienteBloquepLH.merge(clienteBloquepL);
                                        } catch (PersistenceException e) {
                                            ctx.setRollbackOnly();
                                            UtilidadesLog.info(e); 
                                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                        }
                                    }
                                }
                        
                        }
                        
                        
                        for (int b=0; b<oidsClientes.size(); b++){
                            UtilidadesLog.debug("paso 6");
                            try {
                                clienteBloquepLH = this.getClienteBloqueoLocalHome();
                                clienteBloquepL = clienteBloquepLH.create(((Long)oidsClientes.get(b)) , oidTipoBloqueo, new Timestamp(System.currentTimeMillis()), "Provisión/Depuración Incobrable - Automático", usuario, "Provisión/Depuración Incobrable - Automático");
                                clienteBloquepL.setMaab_oid_valo_acci_bloq(new Long(1000));// parametria fija???? oid 1000 automatico    
                                clienteBloquepLH.merge(clienteBloquepL);
                            } catch (PersistenceException e) {
                                ctx.setRollbackOnly();
                                UtilidadesLog.info(e); 
                                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        }
                
                }
                //FIn COL
        } else {
                /*} si no { //Rechazar 
                * si la llamada al método del Entity CabeceraCargosAbonosDirectos: esDepuracionModificable() 
                * devuelve false lanzamos una MareException con el código de error: CCC-0005 
                * (Para rechazar un lote este no debe haber sido contabilizado) 
                */
                UtilidadesLog.debug("paso 7");
                if (!localCCAD.esDepuracionModificable().booleanValue()) {
                    UtilidadesLog.error("aprobarRechazar: Error : CCC-0005");
                    throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                    ErroresDeNegocio.IMPOSIBLE_RECHAZAR_LOTE_CONTABILIZADO));	
                }
                /*Creamos un DTOOID con el oid del dto que hemos recibido (dto.depuracion) y 
                * llamamos a DAODepuracion.obtenerLineasDetalle() pasandole el nuevo DTOOID y 
                * obtenemos un DTOOIDs dtoOIDs de las líneas de detalle; 
                */
                
                DTOOIDs dtoOIDs = daoDepuracion.obtenerLineasDetalle(dto.getDepuracion());
                
                /*Llamamos a eliminarCuotas pasandole el resultado de la llamada anterior (dtoOIDs). 
                * No capturamos la MareException que lanza dicho método, 
                * de modo que si se lanza una no se continua con el método.
                */
                this.eliminarCuotas(dtoOIDs);
                
                /*Establecemos el atributo de CabeceraCargoAbonoDirecto: 
                * situacionIncobrable = CCCConstantes.INCOBRABLE_SITUACION_RECHAZADO */
                localCCAD.setSituacion(new Long(CCCConstantes.INCOBRABLE_SITUACION_RECHAZADO));        
        }
        homeCCAD.merge(localCCAD);
        
        UtilidadesLog.info("MONProvisionesDepuracionesBean.aprobarRechazar(DTOAprobar dto): Salida");
	}

	public DTOConsultarDepuracion obtenerCabeceraDepuracion(DTOOID dto) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerCabeceraDepuracion(DTOOID dto): Entrada");
		/*
		 * Invocamos al DAODepuracion.obtenerCabeceraDepuracion(DTOOID);
		 */
		String usuario = ctx.getCallerPrincipal().getName();
		//String usuario="USUARIO1";
		DAODepuracion daoDepuracion = new DAODepuracion(usuario);
		DTOConsultarDepuracion dtoConsultar = daoDepuracion.obtenerCabeceraDepuracion(dto);
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerCabeceraDepuracion(DTOOID dto): Salida");
		return dtoConsultar;
	}

	// BELC300003398 - Se añade el parámetro pais al método
	private Long obtenerSubprocesoAsociado(Long pais) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerSubprocesoAsociado(Long pais): Entrada");
		/* Obtiene el subproceso asociado a las operaciones de depuracion. 
		 * Devolvemos el resultado de llamar a obtieneSubproceso del DAOCCC 
		 * pasandole CCCConstantes.PROCESO_PROVISION_DEPURACION como proceso 
		 * y "1" como subproceso.
		 */
		DAOCCC daoCCC = new DAOCCC();
		Long resultado = daoCCC.obtieneSubproceso(CCCConstantes.PROCESO_PROVISION_DEPURACION,"1",pais);
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerSubprocesoAsociado(Long pais): Salida");
		return resultado;	
	}//OK

	private Long obtenerTipoAbonoSubproceso(Long pais, Long idioma) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerTipoAbonoSubproceso(Long pais, Long idioma): Entrada");
		/* Obtiene el tipo abono subproceso asociado a las operaciones de depuracion. */
		DAOCCC daoCCC = new DAOCCC();
		DTOOID dtoOid = new DTOOID();
		dtoOid.setOid(this.obtenerSubprocesoAsociado(pais));
		dtoOid.setOidPais(pais);
		dtoOid.setOidIdioma(idioma);		
		Long tipoAbonoSubproceso = null;
		DTOSalida dtoSalida = daoCCC.obtieneTiposAbonoSubproceso(dtoOid);
		if (dtoSalida != null){
			RecordSet rs = dtoSalida.getResultado();
			if (rs != null && rs.getRowCount() != 0){
				tipoAbonoSubproceso = new Long(rs.getValueAt(0,0).toString());
			}
		}
				
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerTipoAbonoSubproceso(Long pais, Long idioma): Salida");

		return tipoAbonoSubproceso;
	}
	
	private RecordSet obtenerPosiblesSituaciones(Long idioma) throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerPosiblesSituaciones(Long idioma): Entrada");
		/* Llamamos al findAll del entity SituacionIncobrables y creamos un 
		 * RecordSet con tantas filas como entidades obtenidas. En la primera 
		 * columna va el oid y en la segunda la descripcion en el idioma 
		 * indicado por parametro.
		 */
		SituacionIncobrableLocalHome home = this.getSituacionIncobrableLocalHome();
		SituacionIncobrableLocal local;
		RecordSet resultado = new RecordSet();
		Collection coleccion = null;
		try{
                    coleccion = home.findAll();
		} catch(NoResultException fe) {
                    UtilidadesLog.debug("No esta hecha la carga inicial de Situacion Incobrable CCC_SITUA_INCOB");
		}
		Vector vector;
		
		if (coleccion!=null && coleccion.size()>0) {
			Iterator iterador = coleccion.iterator();
			String sOid="OID";
			String sDescripcion="DESCRIPCION";
			resultado.addColumn(sOid);
			resultado.addColumn(sDescripcion);
			
			while(iterador.hasNext()) {
				 local=(SituacionIncobrableLocal)iterador.next();				 
				 vector = new Vector();
				 vector.addElement(local.getOid());
				 vector.addElement(
					UtilidadesI18N.recuperarTraducciones(SITUACION_INCOBRABLE,
														local.getOid(),
														idioma,
														new Long(1)));
				 resultado.addRow(vector);
			}
		}
		UtilidadesLog.info("MONProvisionesDepuracionesBean.obtenerPosiblesSituaciones(Long idioma): Salida");
		return resultado;
	}

	private MONClientes getMONClientes() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONClientes(): Entrada");
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
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONClientes(): Salida");
        return ejb;
	}

	private MONMarcasPorTipoAbono getMONMarcasPorTipoAbono() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONMarcasPorTipoAbono(): Entrada");
        // Se obtiene el interfaz home
        MONMarcasPorTipoAbonoHome home = (MONMarcasPorTipoAbonoHome)UtilidadesEJB.getHome(
            MON_MARCAS_POR_TIPO_ABONO, MONMarcasPorTipoAbonoHome.class);
            
        // Se obtiene el interfaz remoto
        MONMarcasPorTipoAbono ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.loguearError(e);			
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONMarcasPorTipoAbono(): Salida");
        return ejb;
	}

	private SituacionIncobrableLocalHome getSituacionIncobrableLocalHome() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getSituacionIncobrableLocalHome(): Entrada");		
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getSituacionIncobrableLocalHome(): Salida");
		return new SituacionIncobrableLocalHome();
	}

	private MONValidacion getMONValidacion() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONValidacion(): Entrada");
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
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONValidacion(): Salida");
        return ejb;
	}

	private MONCuentasCorrientes getMONCuentasCorrientes() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONCuentasCorrientes(): Entrada");
        // Se obtiene el interfaz home
        MONCuentasCorrientesHome home = (MONCuentasCorrientesHome)UtilidadesEJB.getHome(
            MON_CUENTAS_CORRIENTES, MONCuentasCorrientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONCuentasCorrientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.loguearError(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONCuentasCorrientes(): Salida");
        return ejb;
	}
  
	private MarcasTipoAbonoLocalHome getMarcasTipoAbonoLocalHome() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMarcasTipoAbonoLocalHome(): Entrada");		
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMarcasTipoAbonoLocalHome(): Salida");
		return new MarcasTipoAbonoLocalHome();
	}

	private TiposAbonoSubprocesoLocalHome getTiposAbonoSubprocesoLocalHome() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getTiposAbonoSubprocesoLocalHome(): Entrada");		
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getTiposAbonoSubprocesoLocalHome(): Salida");
		return new TiposAbonoSubprocesoLocalHome();		
	}

	private MovimientosCuentasCorrientesLocalHome getMovimientosCuentasCorrientesLocalHome() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMovimientosCuentasCorrientesLocalHome(): Entrada");
		MovimientosCuentasCorrientesLocalHome home = (MovimientosCuentasCorrientesLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/MovimientosCuentasCorrientes");
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMovimientosCuentasCorrientesLocalHome(): Salida");
		return home;
	}


	private MONMantenimientoSEG getMONMantenimientoSEG() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONMantenimientoSEG(): Entrada");
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
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONMantenimientoSEG(): Salida");
        return ejb;
	}

	private MONPeriodos getMONPeriodos() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONPeriodos(): Entrada");
        // Se obtiene el interfaz home
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome(
            MON_PERIODOS, MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.loguearError(e);			
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getMONPeriodos(): Salida");
        return ejb;
	}

	/*private Log getLog() {
		Log log = null;
		try {
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println ("No se pudo obtener el objeto Log");
			throw new RuntimeException ("No se pudo obtener el objeto Log");
		}
	}  */
	private void loguearError(Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error(e);
	}

	private void loguearSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("MONProvisionesDepuracionesBean.loguearSql(String metodo, String sql, Vector params): Entrada");
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
        UtilidadesLog.info("MONProvisionesDepuracionesBean.loguearSql(String metodo, String sql, Vector params): Salida");
	}

	/*
	 * cargaInicialSeleccion: OK
	 * buscarSaldosMorosos: OK
	 * aplicarIncobrables: Falta lo de poner seg_003
	 * buscarClientesBloqueados: OK
	 * desbloquearClientes: OK
	 * obtenerTiposCargoSubproceso: por la incidencia 3397 desaparece
	 * cargaInicialBuscarLotes: OK
	 * buscarLotes: OK
	 * obtenerDetalleDepuracion: OK
	 * eliminarCuotas: OK
	 * eliminar: OK
	 * aprobarRechazar: OK
	 * obtenerSubprocesoAsociado: OK
	 * obtenerPosiblesSituaciones: OK
	 */
    private CabeceraCargosAbonosDirectosLocalHome getCabeceraCargosAbonosDirectosLocalHome() throws MareException {
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getCabeceraCargosAbonosDirectosLocalHome(): Entrada");
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getCabeceraCargosAbonosDirectosLocalHome(): Salida");
        return new CabeceraCargosAbonosDirectosLocalHome();
    } 

    private DetalleCargosAbonosDirectosLocalHome getDetalleCargosAbonosDirectosLocalHome() throws MareException {
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getDetalleCargosAbonosDirectosLocalHome(): Entrada");    
        UtilidadesLog.info("MONProvisionesDepuracionesBean.getDetalleCargosAbonosDirectosLocalHome(): Salida");
        return new DetalleCargosAbonosDirectosLocalHome();
    }

	private SubprocesosLocalHome getSubprocesosLocalHome() throws MareException {
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getSubprocesosLocalHome(): Entrada");		
		UtilidadesLog.info("MONProvisionesDepuracionesBean.getSubprocesosLocalHome(): Salida");
		return new SubprocesosLocalHome();
	}

    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
    
    private DTOMovimientoCuentaCompleto obtenerCuentaCorriente(Long oidMov) throws MareException {
        StringBuffer consulta = new StringBuffer();        
         
        consulta.append("SELECT * FROM CCC_MOVIM_CUENT_CORRI " );
        consulta.append(" WHERE OID_MOVI_CC = " + oidMov.longValue());
        
        RecordSet resultado = null; 
        
        resultado = this.executeQuery(consulta.toString());
        
        if (resultado!=null && resultado.getRowCount()>0)
            return this.generarDtoRegistroCC(resultado);
        else
            return null;
    
    }
    
    private DTOMovimientoCuentaCompleto generarDtoRegistroCC(RecordSet regsDoc) {
        DTOMovimientoCuentaCompleto dtoRegTratar = new DTOMovimientoCuentaCompleto();
        int j=0;
        dtoRegTratar.setCuentaCuota(this.bigDecimalToLong(regsDoc.getValueAt(j,"CUCO_OID_CUEN_CONT_CUOT")));
        dtoRegTratar.setCuentaOrigen(this.bigDecimalToLong(regsDoc.getValueAt(j,"CUCO_OID_CUEN_CONT_ORIG")));
        dtoRegTratar.setDivisa(this.bigDecimalToLong(regsDoc.getValueAt(j, "MONE_OID_MONE")));
        dtoRegTratar.setDocumentoAnyo(regsDoc.getValueAt(j,"VAL_DOCU_ANIO").toString());
        dtoRegTratar.setDocumentoMesSerie((String) regsDoc.getValueAt(j, "VAL_DOCU_MES_SERI"));
        dtoRegTratar.setDocumentoNumero(this.bigDecimalToInteger(regsDoc.getValueAt(j, "VAL_DOCU_NUME")));
        dtoRegTratar.setEjercicioCuota((String) regsDoc.getValueAt(j, "VAL_EJER_CUOT"));
        dtoRegTratar.setEmpresa(this.bigDecimalToLong(regsDoc.getValueAt(j, "SOCI_OID_SOCI")));
        dtoRegTratar.setFechaContabilizacion((regsDoc.getValueAt(j,"FEC_CONTA") != null) ? (Date) regsDoc.getValueAt(j, "FEC_CONTA") : null); //nullable
        dtoRegTratar.setFechaDocumento(new Timestamp(((Date) regsDoc.getValueAt(j, "FEC_DOCU")).getTime()));
        dtoRegTratar.setFechaUltimoMovimiento(new Timestamp(((Date) regsDoc.getValueAt(j, "FEC_ULTI_MOVI")).getTime()));
        dtoRegTratar.setFechaValor((regsDoc.getValueAt(j, "FEC_VALO") != null) ? new Timestamp(((Date) regsDoc.getValueAt(j, "FEC_VALO")).getTime()) : null); //nullable
        dtoRegTratar.setFechaVencimiento((Date) regsDoc.getValueAt( j, "FEC_VENC"));
        dtoRegTratar.setImporte(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI")).doubleValue()));
        dtoRegTratar.setImporteDivisa((regsDoc.getValueAt(j,"IMP_DIVI") != null) ? new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_DIVI")).doubleValue()) : null); //nullable
        dtoRegTratar.setImporteMovimiento((BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI"));
        dtoRegTratar.setImporteMovimientoDivisa((regsDoc.getValueAt(j, "IMP_MOVI_DIVI") != null) ? (BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI_DIVI") : null); //nullable
        dtoRegTratar.setImportePagado(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_PAGA")).doubleValue()));
        dtoRegTratar.setImportePagadoDivisa((regsDoc.getValueAt(j,"IMP_PAGA_DIVI") != null) ? new Double(((BigDecimal)regsDoc.getValueAt(j, "IMP_PAGA_DIVI")).doubleValue()) : null); //nullable
        dtoRegTratar.setImportePago((regsDoc.getValueAt(j, "IMP_PAGO") != null) ? (BigDecimal)regsDoc.getValueAt(j, "IMP_PAGO") : null); //nullable
        dtoRegTratar.setImportePagoDivisa((regsDoc.getValueAt(j, "IMP_PAGO_DIVI") != null) ? (BigDecimal)regsDoc.getValueAt(j, "IMP_PAGO_DIVI") : null); //nullable
        dtoRegTratar.setImportePendiente(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_PEND")).doubleValue()));
        dtoRegTratar.setIndicaDescuentoRecargo(this.bigDecimalToBoolean(regsDoc.getValueAt(j, "IND_DTO_CARG_APLI")));
        dtoRegTratar.setMarca(this.bigDecimalToLong(regsDoc.getValueAt(j, "MARC_OID_MARC")));
        dtoRegTratar.setMarcaSituacion(this.bigDecimalToLong(regsDoc.getValueAt(j,"MASI_OID_MARC_SITU")));
        dtoRegTratar.setMedioPago(this.bigDecimalToLong(regsDoc.getValueAt(j,"MPAB_OID_MEDI_PAGO")));
        dtoRegTratar.setNumeroIdentificadorCuota(this.bigDecimalToInteger(regsDoc.getValueAt(j, "NUM_IDEN_CUOT")));
        dtoRegTratar.setNumeroLoteContabilizacion((regsDoc.getValueAt(j, "VAL_NUME_LOTE_CONT") != null) ? (String) regsDoc.getValueAt(j, "VAL_NUME_LOTE_CONT") : null);
        dtoRegTratar.setNumeroLoteFactu(this.bigDecimalToInteger(regsDoc.getValueAt(j,"NUM_LOTE_FACT")));
        dtoRegTratar.setNumeroOrdenCuota(this.bigDecimalToInteger(regsDoc.getValueAt(j, "NUM_ORDE_CUOT")));        
        //dtoRegTratar.setNumeroSerieCuota(regsDoc.getValueAt(j,"VAL_NUME_SERI_CUOOT").toString());        
        dtoRegTratar.setObservaciones((regsDoc.getValueAt(j,"VAL_OBSE") != null) ? (String) regsDoc.getValueAt(j, "VAL_OBSE") : null); //nullable
        dtoRegTratar.setOid(this.bigDecimalToLong(regsDoc.getValueAt(j, "OID_MOVI_CC")));
        dtoRegTratar.setOidCliente(this.bigDecimalToLong(regsDoc.getValueAt(j, "CLIE_OID_CLIE")));
        dtoRegTratar.setOidMoneda(this.bigDecimalToLong(regsDoc.getValueAt(j,"MONE_OID_MONE")));
        dtoRegTratar.setOidPedidoSolicitudCab(this.bigDecimalToLong(regsDoc.getValueAt(j, "SOCA_OID_SOLI_CABE")));
        dtoRegTratar.setOidRegion(this.bigDecimalToLong(regsDoc.getValueAt(j,"ZORG_OID_REGI")));
        dtoRegTratar.setOidSeccion(this.bigDecimalToLong(regsDoc.getValueAt(j, "ZSCC_OID_SECC")));
        dtoRegTratar.setOidSubtipoCliente(this.bigDecimalToLong(regsDoc.getValueAt(j,"SBTI_OID_SUBT_CLIE")));
        dtoRegTratar.setOidSugerenciaVenta(this.bigDecimalToLong(regsDoc.getValueAt(j,"ZSGV_OID_SUBG_VENT")));
        dtoRegTratar.setOidTipoDocumentoLegal(this.bigDecimalToLong(regsDoc.getValueAt(j,"TIDO_OID_TIPO_DOCU")));
        dtoRegTratar.setOidTipoSolicitud(this.bigDecimalToLong(regsDoc.getValueAt(j,"TSPA_OID_TIPO_SOLI_PAIS")));
        dtoRegTratar.setPeriodoDesde(this.bigDecimalToLong(regsDoc.getValueAt(j, "PERD_OID_PERI")));
        dtoRegTratar.setReferenciaNumeroDocumentoExterno((regsDoc.getValueAt(j, "VAL_REFE_NUME_DOCU_EXTE") != null) ? (String) regsDoc.getValueAt(j,"VAL_REFE_NUME_DOCU_EXTE") : null); //nullable
        dtoRegTratar.setSubacceso(this.bigDecimalToLong(regsDoc.getValueAt(j, "SBAC_OID_SBAC")));
        dtoRegTratar.setSubprocesoCreacion(this.bigDecimalToLong(regsDoc.getValueAt(j,"SUBP_OID_SUBP_CREA")));
        dtoRegTratar.setSubprocesoUltimo(this.bigDecimalToLong(regsDoc.getValueAt(j,"SUBP_OID_SUBP_ULTI")));
        dtoRegTratar.setTerritorioAdministrativo(this.bigDecimalToLong(regsDoc.getValueAt(j,"ZTAD_OID_TERR_ADMI")));
        dtoRegTratar.setTipoAbonoCreacion(this.bigDecimalToLong(regsDoc.getValueAt(j,"TCAB_OID_TCAB_CREA")));
        dtoRegTratar.setTipoAbonoUltimo(this.bigDecimalToLong(regsDoc.getValueAt(j,"TCAB_OID_TCAB_ULTI")));
        dtoRegTratar.setTipoCambio((BigDecimal) regsDoc.getValueAt(j, "IND_TIPO_CAMB"));
        dtoRegTratar.setTipoCliente(this.bigDecimalToLong(regsDoc.getValueAt(j,"TICL_OID_TIPO_CLIE")));
        dtoRegTratar.setTipoPeriodoDesde(this.bigDecimalToLong(regsDoc.getValueAt(j,"TIPE_OID_TIPO_PERI")));
        dtoRegTratar.setUltimoDocumentoAnyo((regsDoc.getValueAt(j,"VAL_ULTI_DOCU_ANIO") != null) ? (String) regsDoc.getValueAt(j, "VAL_ULTI_DOCU_ANIO") : null); //nullable
        dtoRegTratar.setUltimoDocumentoMesSerie((regsDoc.getValueAt( j, "VAL_ULTI_DOCU_MES_SERI") != null) ? (String) regsDoc.getValueAt(j,"VAL_ULTI_DOCU_MES_SERI") : null); //nullable
        dtoRegTratar.setUltimoDocumentoNumero(this.bigDecimalToInteger(regsDoc.getValueAt(j, "VAL_ULTI_DOCU_NUME")));
        dtoRegTratar.setUltimoNumeroHistoria(this.bigDecimalToInteger(regsDoc.getValueAt(j,"VAL_ULTI_NUME_HIST")));

        dtoRegTratar.setImporteMovimientoCuenta(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI_CUEN")).doubleValue()));

        return dtoRegTratar;
    }
    
  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONProvisionesDepuracionesBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONProvisionesDepuracionesBean.executeQuery(String query): Salida");  
    return rs;
  }
  
  private Boolean bigDecimalToBoolean(Object indicador) {    
        if (indicador != null) {
            if (((BigDecimal) indicador).intValue() == 1)  { 
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;           
            }           
        } else {
            return Boolean.FALSE;
        }
  }

  private Integer bigDecimalToInteger(Object numero) {
      if (numero != null) {
          return new Integer(((BigDecimal) numero).intValue());
      } else {
          return null;
      }
  }
 
      public StringBuffer actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta, DTOMovimientoCuentaCompleto dtoMCCAnterior) throws MareException {
        UtilidadesLog.info("MONProvisionesDepuracionesBean.actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta, DTOMovimientoCuentaCompleto dtoMCCAnterior): Entrada");
        UtilidadesLog.info("**** DTOMovimientoCuentaCompleto = "+movimientoCuenta);                
        StringBuffer cadenaInsercionHistorico = new StringBuffer();
        StringBuffer cadenaH = new StringBuffer();
        cadenaH = this.generarCadenaInsercionHistorico(dtoMCCAnterior);
        cadenaInsercionHistorico.append(cadenaH.toString());

        //double deudaCancelada = dtoMCCAnterior.getImportePendiente().doubleValue() - movimientoCuenta.getImportePendiente().doubleValue();
        double importeHistorico = dtoMCCAnterior.getImporte().doubleValue();
        double importeCuenta = movimientoCuenta.getImporte().doubleValue();

        UtilidadesLog.debug("importeHistorico : " + importeHistorico);
        UtilidadesLog.debug("importeCuenta : " + importeCuenta);
        
        if (importeHistorico != importeCuenta) {        
            DTOActualizacionCartera dtoActuCartera = new DTOActualizacionCartera();
            dtoActuCartera.setOidCuota(movimientoCuenta.getOid());
            dtoActuCartera.setOidPais(movimientoCuenta.getOidPais());
            dtoActuCartera.setOidMarca(movimientoCuenta.getMarca());
            dtoActuCartera.setImporteDeudaCancelada(movimientoCuenta.getImportePago());
            dtoActuCartera.setOidSubacceso(movimientoCuenta.getSubacceso());
            dtoActuCartera.setOidEstadoAsignacion(null);
            StringBuffer cadena = new StringBuffer();
            cadena = this.actualizarEstadoCartera(dtoActuCartera);
            cadenaInsercionHistorico.append(cadena.toString());
        }
        UtilidadesLog.info("MONProvisionesDepuracionesBean.actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta, DTOMovimientoCuentaCompleto dtoMCCAnterior): Salida");       
        return cadenaInsercionHistorico;
    }

   private StringBuffer actualizarEstadoCartera(DTOActualizacionCartera dto) throws MareException{
    UtilidadesLog.info("MONProvisionesDepuracionesBean.actualizarEstadoCartera(DTOActualizacionCartera dto): Entrada");
    StringBuffer query = new StringBuffer();
    
    query.append("UPDATE COB_ASIGN_COBRA SET IMP_DEUD_CANC = ("+ dto.getImporteDeudaCancelada() + "(NVL(IMP_ORIG_DEUD, 0) + NVL(IMP_DEUD_ASIG,0))) WHERE OID_ASIG_COBR = ");
    query.append("( ");
    query.append("  SELECT asi.OID_ASIG_COBR ");
    query.append("  FROM COB_ASIGN_COBRA asi, ");
    query.append("  COB_CRONO_COBRA cro, ");
    query.append("  CRA_PERIO per, ");
    query.append("  SEG_CANAL can, ");
    query.append("  SEG_ACCES acc, ");
    query.append("  SEG_SUBAC sba ");
    query.append("  WHERE asi.CRCO_OID_CRON_COBR = cro.OID_CRON_COBR ");
    query.append("  AND asi.ESAS_OID_ESTA_ASIG = "+dto.getOidEstadoAsignacion()+" ");
    query.append("  AND asi.MVCC_OID_MOVI_CC = "+dto.getOidCuota()+" ");
    query.append("  AND cro.PERD_OID_PERI = per.OID_PERI ");
    query.append("  AND per.PAIS_OID_PAIS = "+dto.getOidPais()+" ");
    query.append("  AND per.MARC_OID_MARC = "+dto.getOidMarca()+" ");
    query.append("  AND per.CANA_OID_CANA = can.OID_CANA ");
    query.append("  AND can.OID_CANA = acc.CANA_OID_CANA ");
    query.append("  AND sba.ACCE_OID_ACCE = acc.OID_ACCE ");
    query.append("  AND sba.OID_SBAC = "+dto.getOidSubacceso()+" );");

    
    UtilidadesLog.info("MONProvisionesDepuracionesBean.actualizarEstadoCartera(DTOActualizacionCartera dto): Salida");
    return query;    
  }
    private StringBuffer generarCadenaInsercionHistorico(DTOMovimientoCuentaCompleto dtoMCCAnterior){
        UtilidadesLog.info("MONProvisionesDepuracionesBean.generarCadenaInsercionHistorico(DTOMovimientoCuentaCompleto dtoMCCAnterior): Entrada");
        StringBuffer query = new StringBuffer();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        query.append("INSERT INTO CCC_HISTO_MOVIM_CC (OID_HIST_MOVI,SUBP_OID_SUBP,TCAB_OID_TIPO_CARG_ABON, NUM_HIST,");
        query.append("TICL_OID_TIPO_CLIE,  MASI_OID_MARC_SITU, CLIE_OID_CLIE,");
        query.append("VAL_REFE_NUME_DOCU_EXTE,  MVCC_OID_MOVI_CC,IMP,");
        query.append("IMP_PAGA,IMP_PAGA_DIVI,IMP_PEN,");
        query.append("IMP_DIVI,VAL_ULTI_DOCU_MES_SERI,VAL_ULTI_DOCU_ANIO,");
        query.append("VAL_ULTI_DOCU_NUME,VAL_NUME_LOTE_CONT,VAL_OBSE,");
        query.append("IMP_PAGO,IMP_MOVI,IMP_MOVI_DIVI,");
        query.append("IND_DESC_CARG_APLI,VAL_TIPO_CAMB,COD_USUA,");
        query.append("CUCO_OID_CUEN_CONT,MONE_OID_MONE,MPAB_OID_MEDI_PAGO_TEOR,");
        query.append("FEC_MOVI,");
        query.append("FEC_VENC,");
        if (dtoMCCAnterior.getFechaValor() != null){
            query.append("FEC_VALO,");
        }
        if (dtoMCCAnterior.getFechaContabilizacion() != null){
            query.append("FEC_CONT,");
        }
        query.append("FEC_DOCU");
        query.append(") VALUES (CCC_HMCC_SEQ.NEXTVAL,");
        query.append(dtoMCCAnterior.getSubprocesoUltimo()+","+dtoMCCAnterior.getTipoAbonoUltimo()+","+dtoMCCAnterior.getUltimoNumeroHistoria().longValue()+",");
        query.append(dtoMCCAnterior.getTipoCliente()+","+dtoMCCAnterior.getMarcaSituacion()+","+dtoMCCAnterior.getOidCliente()+",");
        if(dtoMCCAnterior.getReferenciaNumeroDocumentoExterno()!=null){
         query.append("'"+dtoMCCAnterior.getReferenciaNumeroDocumentoExterno()+"',");   
        }else{
         query.append("null,");  
        }
        query.append(dtoMCCAnterior.getOid()+","+dtoMCCAnterior.getImporte()+",");
        query.append(dtoMCCAnterior.getImportePagado()+","+dtoMCCAnterior.getImportePagadoDivisa()+","+dtoMCCAnterior.getImportePendiente()+",");
        query.append(dtoMCCAnterior.getImporteDivisa()+",");
        if(dtoMCCAnterior.getDocumentoMesSerie()!=null){
         query.append("'"+dtoMCCAnterior.getDocumentoMesSerie()+"',");
        }else{
         query.append("null, ");  
        }
        if(dtoMCCAnterior.getDocumentoAnyo()!=null){
         query.append("'"+dtoMCCAnterior.getDocumentoAnyo()+"',");
        }else{
         query.append("null, ");    
        }
        query.append(dtoMCCAnterior.getDocumentoNumero()+",");
        if(dtoMCCAnterior.getNumeroLoteContabilizacion()!=null){
         query.append("'"+dtoMCCAnterior.getNumeroLoteContabilizacion()+"',");   
        }else{
         query.append("null, ");      
        }
        if (dtoMCCAnterior.getObservaciones() != null) {
          query.append("'" + dtoMCCAnterior.getObservaciones()+"',");
        } else {
          query.append("'',");
        }
        query.append(dtoMCCAnterior.getImportePago()+","+dtoMCCAnterior.getImporteMovimientoCuenta()+","+dtoMCCAnterior.getImporteMovimientoDivisa()+",");
        if (dtoMCCAnterior.getIndicaDescuentoRecargo() != null) {
          if (dtoMCCAnterior.getIndicaDescuentoRecargo().booleanValue()) {
            query.append("1,");
          } else {
            query.append("0,");
          }
        } else {
            query.append("NULL,");
        }
        query.append(dtoMCCAnterior.getTipoCambio()+",");
        if (dtoMCCAnterior.getUsuario() != null) {
          query.append("'"+dtoMCCAnterior.getUsuario()+"',");
        } else {
          query.append("'',");
        }
        query.append(dtoMCCAnterior.getCuentaCuota()+","+dtoMCCAnterior.getDivisa()+","+dtoMCCAnterior.getMedioPago()+",");
        query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaUltimoMovimiento())+"','dd/MM/yyyy'),");
        query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaVencimiento())+"','dd/MM/yyyy'),");
        if (dtoMCCAnterior.getFechaValor() != null){
            query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaValor())+"','dd/MM/yyyy'),");
        }
        if (dtoMCCAnterior.getFechaContabilizacion() != null){
            query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaContabilizacion())+"','dd/MM/yyyy'),");
        }
        query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaDocumento())+"','dd/MM/yyyy')");
        query.append(");");
        
        UtilidadesLog.info("MONProvisionesDepuracionesBean.generarCadenaInsercionHistorico(DTOMovimientoCuentaCompleto dtoMCCAnterior): Salida");
        return query;        
    }
    
   // vbongiov -- RI 20080583 - BLO 2da parte -- 24/04/2008 
   private StringBuffer generarStringUpdateMCC(DTOMovimientoCuentaCompleto dtoMovimCC, Long subproceso, String mes, String anyo){
      UtilidadesLog.info("MONProvisionesDepuracionesBean.generarStringUpdateMCC(DTOMovimientoCuentaCompleto dtoMovimCC): Entrada");
      StringBuffer query = new StringBuffer();
      //SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
      
      query.append("UPDATE CCC_MOVIM_CUENT_CORRI SET MASI_OID_MARC_SITU = " + dtoMovimCC.getMarcaSituacion() + ",");
      query.append("IMP_PAGO =" + dtoMovimCC.getImportePago() +" ,");
      query.append("IMP_PEND =" + dtoMovimCC.getImportePendiente() +" ,");
      query.append("IMP_PAGA =" + dtoMovimCC.getImportePagado() +" ,");
      
      /* DBLG500000979 - dmorello, 26/10/2006 */
      //query.append("IMP_MOVI_CUEN = " + dtoMovimCC.getImporteMovimiento() + " ,");
      query.append("IMP_MOVI_CUEN = " + dtoMovimCC.getImportePendiente() + " ,");
      
      query.append("VAL_ULTI_DOCU_NUME =" + dtoMovimCC.getUltimoDocumentoNumero() +" ,");
      //query.append("SUBP_OID_SUBP_ULTI =" + dtoMovimCC.getSubprocesoUltimo() +" ,");
      
      query.append("SUBP_OID_SUBP_ULTI =" + subproceso.longValue() +" ,");
      
      query.append("TCAB_OID_TCAB_ULTI = " + dtoMovimCC.getTipoAbonoUltimo() +",");
      query.append("FEC_ULTI_MOVI = SYSDATE,");
      query.append("VAL_ULTI_NUME_HIST = " + dtoMovimCC.getUltimoNumeroHistoria() +",");
      query.append("COD_USUA = '" + dtoMovimCC.getUsuario() + "'");
      
      query.append(", CUCO_OID_CUEN_CONT_CUOT = " + dtoMovimCC.getCuentaCuota());
      query.append(", CUCO_OID_CUEN_CONT_ORIG = " + dtoMovimCC.getCuentaOrigen());
      
      if (mes.trim().length()==1) {
         String mesDef = new String();  
         mesDef = mesDef.concat("0").concat(mes.trim());
         query.append(", VAL_ULTI_DOCU_MES_SERI = '" + mesDef + "'");
      } else {
          query.append(", VAL_ULTI_DOCU_MES_SERI = '" + mes + "'");        
      }
      
      // vbongiov -- RI 20080583 - BLO 2da parte -- 24/04/2008
      query.append(", VAL_ULTI_DOCU_ANIO = '" + anyo + "'");   
          
      query.append(" WHERE OID_MOVI_CC = " + dtoMovimCC.getOid()+";");

      UtilidadesLog.info("MONProvisionesDepuracionesBean.generarStringUpdateMCC(DTOMovimientoCuentaCompleto dtoMovimCC): Salida");
      return query;
   }

  private void grabarMovCCyHistorico(StringBuffer query) throws MareException {
      UtilidadesLog.info("MONProvisionesDepuracionesBean.grabarMovCCyHistorico(StringBuffer query): Entrada");
      BelcorpService bs = BelcorpService.getInstance();      
        try {
            UtilidadesLog.debug("voy a ejecutar..: " + query.toString());
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error en grabarMovCCyHistorico ",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
      UtilidadesLog.info("MONProvisionesDepuracionesBean.grabarMovCCyHistorico(StringBuffer query): Salida");  
      }

    private StringBuffer crearStrInsercionDCAD(Long cabecera, Long consultora, Integer numeroLinea, Integer numeroHistoriaGenera, 
                                               Date fechaMovimiento, BigDecimal importeMoneda, BigDecimal importe, String referenciaNumeroDocumento, 
                                               String observaciones, String glosaContable, Long moneda, Long movimientoBancario, Long medioPago, 
                                               Long cuotaAnterior, Long cuotaNueva, Long movimiento, Long cuentaCorriente, Date fechaPagoEnBancos, 
                                               String codigoUsuario, Long empresa, Long tipoAbonoSubproceso) throws MareException {
                                               
        StringBuffer query  = new StringBuffer();
        StringBuffer values = new StringBuffer();

        query.append(" INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
      
        query.append(" OID_DETA_CARG_ABON_DIRE ");
        values.append("CCC_DCAD_SEQ.NEXTVAL ");
        
        query.append(" ,CCAD_OID_CABE_CARG ");
        values.append(", ").append(cabecera);
        
        if (consultora != null) {
            query.append(", CLIE_OID_CLIE ");   // consultora
            values.append(", ").append(consultora);
        }
        
        query.append(" , NUM_LINE ");
        values.append(", ").append(numeroLinea);
        
        query.append(", NUM_HIST_GENE ");
        values.append(", ").append(numeroHistoriaGenera);

        if (fechaMovimiento != null) {
            query.append(", FEC_MOVI");
            values.append(", ").append(" to_date( '" + fechaMovimiento + "', 'YYYY-MM-DD') ");           
        } 
        
        if (importeMoneda != null) {
            query.append(", IMP_MONE ");   // importeDivisa eq importeMoneda
            values.append(", ").append(importeMoneda);
        }

        if (importe != null) {
            query.append(", IMP ");
            values.append(", ").append(importe);
        }

        query.append(", VAL_REFE ");    // referenciaNumeroDocumento
        values.append(", ").append("null");

        query.append(", VAL_OBSE ");    // observaciones
        values.append(", ").append("null");

        query.append(", VAL_GLOS_CONT ");    // glosaContable
        values.append(", ").append("null");

        if (moneda != null) {
            query.append(", MONE_OID_MONE ");
            values.append(", ").append(moneda);
        }
                  
        query.append(", CMBA_OID_MOVI_BANC ");    // movimientoBancario
        values.append(", ").append("null");
                  
        if (medioPago != null) {
            query.append(", MPAB_OID_MEDI_PAGO ");
            values.append(", ").append(medioPago);
        }

        if (cuotaAnterior != null) {
            query.append(", CUCO_OID_CUEN_CONT_CUOT_ANTE ");    // cuentaAnterior
            values.append(", ").append(cuotaAnterior);
        }

        if (cuotaNueva != null) {
            query.append(", CUCO_OID_CUEN_CONT_CUOT_NUEV ");    // cuentaNueva
            values.append(", ").append(cuotaNueva);
        }

        if (movimiento != null) {
            query.append(", MVCC_OID_MOVI_CC ");    // movimientoCtaCte
            values.append(", ").append(movimiento);
        }

        query.append(", CCBA_OID_CUEN_CORR_BANC ");    // cuentaCorriente
        values.append(", ").append("null");

        query.append(", FEC_PAGO_BANC ");    // fechaPagoEnBancos
        values.append(", ").append("null");

        query.append(" , COD_USUA ");
        values.append(", ").append("'").append(codigoUsuario).append("'").append(", ");

        query.append(" , SOCI_OID_SOCI ");
        values.append(empresa).append(",");

        query.append(" , TASP_OID_TIPO_ABON_SUBP ");
        values.append(tipoAbonoSubproceso);
        
        query.append(") VALUES (");
        query.append(values); 
        query.append(");");
        
		    return query;
	}
      
   private void grabarDetCargoAbono(StringBuffer query) throws MareException {
     BelcorpService bs = BelcorpService.getInstance();   
      try {
          bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
      } catch (Exception e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("Error en grabarDetCargoAbono ",e);
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
   }

  private ClienteBloqueoLocalHome getClienteBloqueoLocalHome() {
    return new ClienteBloqueoLocalHome();
  }
   
}

