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
import es.indra.sicc.entidades.ccc.SubprocesosLocal;
import es.indra.sicc.entidades.ccc.SubprocesosLocalHome;
import es.indra.sicc.logicanegocio.ped.ErroresNegocio;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;

import es.indra.sicc.dtos.ccc.DTONumeroDocumento;
import es.indra.sicc.dtos.ccc.DTOBloqueo;
import es.indra.sicc.dtos.ccc.DTONumeroOrden;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;

import es.indra.sicc.dtos.ccc.DTOBuscarCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCargaInicialCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCargaInicialConceptos;
import es.indra.sicc.dtos.ccc.DTOCargaInicialGeneracionVencimientos;
import es.indra.sicc.dtos.ccc.DTOCargaMasiva;
import es.indra.sicc.dtos.ccc.DTOCargosAbonos;
import es.indra.sicc.dtos.ccc.DTODatosCargaInicialConceptos;
import es.indra.sicc.dtos.ccc.DTODetalleCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.dtos.ccc.DTOObtenerCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOParametrosSubproceso;
import es.indra.sicc.dtos.ccc.DTOCasoUso;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.dtos.ccc.DTOConceptosGastosAbonos;
import es.indra.sicc.dtos.ccc.DTOValidarNumeroDocumento;
import es.indra.sicc.dtos.ccc.DTOBuscarMovimientosReasignacion;
import es.indra.sicc.util.DTOString;

import es.indra.sicc.dtos.cra.DTOPeriodo;

import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;

import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.msg.ConstantesMSG;

import es.indra.sicc.dtos.seg.DTOCAS;
import es.indra.sicc.dtos.seg.DTOCargaCAS;
import es.indra.sicc.dtos.seg.DTOFiltroCAS;

import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.MarcasTipoAbonoLocalHome;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocal;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocalHome;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocal;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocalHome;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocal;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocalHome;

import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;

import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;

import es.indra.sicc.logicanegocio.bel.MONGestionMedioPagoBelCenter;
import es.indra.sicc.logicanegocio.bel.MONGestionMedioPagoBelCenterHome;

import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientes;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientesHome;
import es.indra.sicc.logicanegocio.ccc.DAOCargosAbonos;

import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;

import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;

import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;

import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativasHome;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.StringTokenizer;
import java.sql.Date;
import java.sql.Timestamp;

import java.text.ParseException;

import java.util.Vector;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.ccc.DTOReasignacionPagos;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.dtos.ccc.DTOMovBancIndicadores;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
//import org.apache.commons.logging.Log;

public class MONCargosAbonosBean implements SessionBean  {

  private Long oidTipoPeriodo = null;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH/mm/ss");
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

	public DTOSalida recargaSubprocesos(DTOOID dto) throws MareException {
    
		UtilidadesLog.info("MONCargosAbonosBean.recargaSubprocesos(DTOOID dto): Entrada");
     
      /*String usuario = ctx.getCallerPrincipal().getName();
      
      DTOBloqueo dtoB = new DTOBloqueo();
      dtoB.setDescripcionProceso("Aplica cargos y abonos directos");
      dtoB.setUsuario(usuario); 
      
      try{
          MONCuentasCorrientesLocal mccL = getMONCuentasCorrientesLocalHome().create();
          mccL.insertarBloqueo(dtoB); 
      }catch (NamingException ne){
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(ne, UtilidadesError.armarCodigoError(codigoError));
      }catch (CreateException e){
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }*/
       
        
		DAOCCC daoCCC=new DAOCCC();
		RecordSet recordset = new RecordSet();
        /*RecordSet rs;
        rs = daoCCC.consultarBloqueo();*/
      
        /*if(rs.getRowCount() == 0){*/
            Long oid=dto.getOid();
            recordset=daoCCC.obtieneCodigosSubprocesos(oid);
            UtilidadesLog.info("MONCargosAbonosBean.recargaSubprocesos(DTOOID dto): Salida");
        /*}	*/
        return new DTOSalida(recordset);
	}

	
	public DTOCargaInicialCargosAbonos obtenerDatosInicialesCargosAbonos(DTOCasoUso dto) throws MareException {

		UtilidadesLog.info("MONCargosAbonosBean.obtenerDatosInicialesCargosAbonos(DTOCasoUso dto): Entrada");
        
		DTOCargaInicialCargosAbonos dtoCargaInicialCargosAbonos=new DTOCargaInicialCargosAbonos();
		try{
			DAOCCC daoCCC=new DAOCCC();
			//DAOCargosAbonos daoCargosAbonos=new DAOCargosAbonos(ctx.getCallerPrincipal().getName());

			if (dto.getCasoUso()!=null){
				if (dto.getCasoUso().equals("GestionarCheques")) {			
						/*
					 * No cargamos procesos ya que el proceso es fijo proceso='CCC004'
					 * Creamos un recordset "procesos" con dos campos: 
					 * codigo="CCC004";
					 * proceso=DAOCCC.obtieneProceso(dto.pais, codigo);
					 * Si no localiza el proceso para el pais entonces procesos=null;
					 * else guardamos en el recordset el proceso y el codigo;
					 */
					Vector valores = new Vector();
					String codigoProceso = "CCC004";
					Long oidProceso = daoCCC.obtieneProceso(codigoProceso, dto.getOidPais());
					if (oidProceso != null) {
						valores.add(oidProceso);
						valores.add(codigoProceso);
						RecordSet rs = new RecordSet();
						rs.addColumn("CODIGO");
						rs.addColumn("DESCRIPCION");
						rs.addRow(valores);
						dtoCargaInicialCargosAbonos.setProcesos(rs);
					} else {
						dtoCargaInicialCargosAbonos.setProcesos(new RecordSet());
					}
				}
				else{
					dtoCargaInicialCargosAbonos.setProcesos(daoCCC.obtieneProcesosPais(dto.getOidPais().longValue(),true));
				}
			}

			//numeroIdentificacion = Llamamos a DAOCargosAbonos.obtenerSiguienteNumero pasandole el pais del dto.		
			//empresas = IServicioSEG.recuperarEmpresasPorPais(dto) 
			MONMantenimientoSEG mantenimientoSEG=this.getIServicioSEG();
			DTOBelcorp dtobelcorp = new DTOBelcorp();
			dtobelcorp.setOidIdioma(dto.getOidIdioma());
			dtobelcorp.setOidPais(dto.getOidPais());
			/* Modificado por incidencia BELC300010254
				dtoCargaInicialCargosAbonos.setNumeroIdentificacion(daoCargosAbonos.obtieneSiguienteNumero(dto.getOidPais()));
			*/		
			//if(dto.getCasoUso().equals("AplicarCargosAbonos")){
				/* V-CCC-028 Se obtiene de manera individual en numero de identificacion desde otro metodo.
        dtoCargaInicialCargosAbonos.setNumeroIdentificacion(daoCCC.obtenerSecuenciaPais(dtobelcorp));			
        */
			//}
			dtoCargaInicialCargosAbonos.setEmpresas(mantenimientoSEG.recuperarEmpresasPorPais(dtobelcorp).getResultado());

			//Creamos un DTOCargaCAS de SEG y ponemos todos los atributos a true, copiamos el pais y el idioma del dto de entrada. 
			DTOCargaCAS dtoCarga=new DTOCargaCAS();
			DTOFiltroCAS filtroCas=new DTOFiltroCAS();
			filtroCas.setBaccesos(Boolean.valueOf(true));
			filtroCas.setBcanales(Boolean.valueOf(true));
			filtroCas.setBsubaccesos(Boolean.valueOf(true));
			dtoCarga.setFiltro(filtroCas);
			dtoCarga.setTodos(filtroCas);
			dtoCarga.setOidIdioma(dto.getOidIdioma());
			dtoCarga.setOidPais(dto.getOidPais());
		
			/*LLamamos a IServicioSEG.obtieneCanalAccesoSubacceso pasandole el DTOCargaCas. 
			Con el DTOCAS que obtenemos rellenamos los atributos canales, accesos y subaccesos de nuestro DTOCargaInicialCargosAbonos.*/ 
			DTOCAS dtoCas=mantenimientoSEG.obtieneCanalAccesoSubacceso(dtoCarga);
			dtoCargaInicialCargosAbonos.setCanales(dtoCas.getCanales());
			dtoCargaInicialCargosAbonos.setAccesos(dtoCas.getAccesos());
			dtoCargaInicialCargosAbonos.setSubaccesos(dtoCas.getSubaccesos());
			
			if (dto.getCasoUso()!=null){
				if (!dto.getCasoUso().equals("AplicarCargosAbonos")) {
					dtoCargaInicialCargosAbonos.setSubprocesosGestionCheques(this.obtenerSubprocesosGestionCheques(dto.getOidIdioma(), dto.getOidPais()));
				}
			}

			dtoCargaInicialCargosAbonos.setTasaCambioMonedaAlternativa(this.obtenerTasaCambioMonedaAlternativa(dto.getOidPais()));
			
			/*/////ANTIGUO////////////////
			DAOCCC daoCCC=new DAOCCC();
			DAOCargosAbonos daoCargosAbonos=new DAOCargosAbonos(ctx.getCallerPrincipal().getName());
			dtoCargaInicialCargosAbonos.setProcesos(daoCCC.obtieneProcesosPais(dto.getOidPais().longValue(),true));
			dtoCargaInicialCargosAbonos.setNumeroIdentificacion(daoCargosAbonos.obtieneSiguienteNumero(dto.getOidPais()));
			MONMantenimientoSEG mantenimientoSEG=this.getIServicioSEG();
			dtoCargaInicialCargosAbonos.setEmpresas(mantenimientoSEG.recuperarEmpresasPorPais(dto).getResultado());
			dtoCargaInicialCargosAbonos.setNumeroIdentificacion(daoCargosAbonos.obtieneSiguienteNumero(dto.getOidPais()));
			DTOCargaCAS dtoCarga=new DTOCargaCAS();
			DTOFiltroCAS filtroCas=new DTOFiltroCAS();
			filtroCas.setBaccesos(new Boolean(true));
			filtroCas.setBcanales(new Boolean(true));
			filtroCas.setBsubaccesos(new Boolean(true));
			dtoCarga.setFiltro(filtroCas);
			dtoCarga.setTodos(filtroCas);
			dtoCarga.setOidIdioma(dto.getOidIdioma());
			dtoCarga.setOidPais(dto.getOidPais());
	    	DTOCAS dtoCas=mantenimientoSEG.obtieneCanalAccesoSubacceso(dtoCarga);
			dtoCargaInicialCargosAbonos.setCanales(dtoCas.getCanales());
			dtoCargaInicialCargosAbonos.setAccesos(dtoCas.getAccesos());
			dtoCargaInicialCargosAbonos.setSubaccesos(dtoCas.getSubaccesos());
			dtoCargaInicialCargosAbonos.setSubprocesosGestionCheques(this.obtenerSubprocesosGestionCheques(dto.getOidIdioma()));
			dtoCargaInicialCargosAbonos.setTasaCambioMonedaAlternativa(this.obtenerTasaCambioMonedaAlternativa(dto.getOidPais()));*/
		}catch (RemoteException e) {
			//ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("obtenerDatosInicialesCargosAbonos: RemoteException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
		}					
		UtilidadesLog.info("MONCargosAbonosBean.obtenerDatosInicialesCargosAbonos(DTOCasoUso dto): Salida");
		return dtoCargaInicialCargosAbonos;
	}

	public DTOCargaMasiva validarCarteraMasiva(DTOCargaMasiva cartera) throws MareException {
    
		UtilidadesLog.info("MONCargosAbonosBean. validarCarteraMasiva(DTOCargaMasiva cartera): Entrada");
        
		String[][] carteraValidar=cartera.getElementos(); //se asume que tomamos filas/columnas.	
		UtilidadesLog.debug("****carteraValidar"+ carteraValidar);
		/*		
			0 Cliente 
			1 Marca 
			2 Canal 
			3 Acceso 
			4 Subacceso 
			5 Número documento 
			6 Referencia 
			7 Medio pago 
			8 Divisa 
			9 Importe 
			10 Importe Divisa 
			11 Observaciones 
			12 Fecha valor 
			13 Fecha vto 
		*/
		DTOCargaMasiva carteraValidada=new DTOCargaMasiva();
		if(carteraValidar==null||(carteraValidar!=null&&carteraValidar.length==0&&carteraValidar[0].length!=14)){
			ExcelIncorrectoException excelE=new ExcelIncorrectoException("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",ErroresDeNegocio.NUMERO_COLUMNAS_INCORRECTO)); 
			throw excelE; 
		}

		
		Entidadi18nLocalHome  entidadi18nLocalHome = this.getI18NEntityLocalHome();
		Entidadi18nLocal entidadi18nLocal = null;
		//en este array de String sus columnas llevaran el orden:
		/*
			0 codigoCliente,
			1 MarcaDesc,
			2 canal,
			3 acceso,
			4 subacceso, 
			5 numeroDocumento, 
			6 referenciaExterna, 
			7 fechaValor, 
			8 fechaVencimiento, 
			9 medioPagoDescripcion,
			10 divisa, 
			11 importe, 
			12 importeDivisa, 
			13 observaciones, 
			14 medioPagoOid, 
			15 marcaOid, 
			16 canalOid, 
			17 accesoOid, 
			18 subaccesoOid		
		*/

		String[][] carteraSRetorno=new String[carteraValidar.length][19];
		MONClientes maestroClientes=this.getIMaestroClientes();
		MONMantenimientoSEG mantenimientoSEG=this.getIServicioSEG();
		MarcaLocalHome marcaHome=this.getMarcaLocalHome();
		MONGestionMedioPagoBelCenter monGestionMedioPago=this.getMONGestionMedioPagoBelCenter();
		Long idCliente=null;
		for (int i = 0; i <carteraValidar.length; i++) {
		UtilidadesLog.debug("****Dentro del bucle for");
			try {
				if(carteraValidar[i][5].length()!=10){
					UtilidadesLog.debug("****longitud de número documento incorrecto");
					ExcelIncorrectoException excelE=new ExcelIncorrectoException("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",ErroresDeNegocio.NUMERO_DOC_NO_CORRECTO)); 
					excelE.addParameter(carteraValidar[i][5]);
					excelE.setPosicion(ExcelIncorrectoException.POSICION_FINAL);
					throw  excelE; 
				}
				UtilidadesLog.debug("****antes llamar a cliente");
				idCliente=maestroClientes.obtenerOidCliente(cartera.getOidPais(),carteraValidar[i][0]); 			
				UtilidadesLog.debug("****obtenido cliente");
				if(idCliente==null){
					UtilidadesLog.debug("****Dentro del if cliente");
					ExcelIncorrectoException excelE=new ExcelIncorrectoException("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",ErroresDeNegocio.CLIENTE_NO_RECONOCIDO)); 
					excelE.addParameter(carteraValidar[i][0]);
					excelE.setPosicion(ExcelIncorrectoException.POSICION_FINAL);
					throw  excelE; //ExcelIncorrectoException con el código de mensaje CCC-0021 (Código de cliente no reconocido: ) y le anexamos el codigoCliente que hemos pasado en la llamada
				}
				//falta las llamadas a los metodos de validacion:
				Long medioPagoOid=monGestionMedioPago.obtenerOidMedioPago(cartera.getOidPais(),carteraValidar[i][7]);				
				UtilidadesLog.debug("****obtenido midio pago");
				if(medioPagoOid==null){
					UtilidadesLog.debug("****dentro del if medio pago");
					ExcelIncorrectoException excelE=new ExcelIncorrectoException("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",ErroresDeNegocio.MEDIO_PAGO_NO_RECONOCIDO)); 
					excelE.addParameter(carteraValidar[i][7]);
					excelE.setPosicion(ExcelIncorrectoException.POSICION_FINAL);
					throw  excelE; //Lanzamos una ExcelIncorrectoException con el código de mensaje CCC-0024 (Moneda no reconcida: ) y le anexamos el valor de divisaDesc que hemos utilizado 
				}				
				carteraSRetorno[i][14]=""+medioPagoOid;
				/*
				medioPagoOid = llamamos a IBEL.obtenerOidMedioPago pasandole la columna medioPagoDesc y el pais del dto. 
				si obtenemos null { 
				Lanzamos una ExcelIncorrectoException con el código de mensaje CCC-0023 (Medio de pago no reconcido: ) y le anexamos el medioPagoDesc que hemos utilizado. 
				} */
				if (!carteraValidar[i][8].equals("")) {
					Long divisaOid=mantenimientoSEG.obtenerOidMoneda(carteraValidar[i][8]);
					UtilidadesLog.debug("****obtenido divisa");
					if(divisaOid==null){
						UtilidadesLog.debug("****dentro del if divisa");
						ExcelIncorrectoException excelE=new ExcelIncorrectoException("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",ErroresDeNegocio.MONEDA_NO_RECONIDIDA)); 
						excelE.addParameter(carteraValidar[i][8]);
						excelE.setPosicion(ExcelIncorrectoException.POSICION_FINAL);
						throw  excelE; //Lanzamos una ExcelIncorrectoException con el código de mensaje CCC-0024 (Moneda no reconcida: ) y le anexamos el valor de divisaDesc que hemos utilizado 
					}
					carteraSRetorno[i][10] = carteraValidar[i][8];
				}
				Long marcaOid = null;
				try {
					UtilidadesLog.debug("****antes de marca");
					marcaOid = mantenimientoSEG.obtenerOidMarca(carteraValidar[i][1]);
					UtilidadesLog.debug("****despues recuperar marca");
				} catch (MareException me) {
					if (me.getCode() == Integer.parseInt(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)) {
						ExcelIncorrectoException excelE=new ExcelIncorrectoException("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",ErroresDeNegocio.MARCA_NO_RECONOCIDA)); 
						excelE.addParameter(carteraValidar[i][1]);
						excelE.setPosicion(ExcelIncorrectoException.POSICION_FINAL);
						throw  excelE; //Lanzamos una ExcelIncorrectoException con el código de mensaje CCC-0022 (Marca no reconcida: ) y le anexamos la marca que hemos utilizado } 
					} else throw me;
				}				
				
				carteraSRetorno[i][0]=carteraValidar[i][0];//codigoCliente 
				carteraSRetorno[i][5]=carteraValidar[i][5];//numeroDocumento
				MONMantenimientoSEG monMantenimientoSEG=this.getIServicioSEG();
				DTOOID dtoId=new DTOOID();
				dtoId.setOid(cartera.getOidPais());
				dtoId.setOidIdioma(cartera.getOidIdioma());
				DTOSalida dtoSalida=monMantenimientoSEG.recuperarPais(dtoId);
				RecordSet resultado=dtoSalida.getResultado();
				String formatoFecha=(String)resultado.getValueAt(0,"VAL_FORM_FECH");
				while(formatoFecha.indexOf("a")!=-1){
					formatoFecha=formatoFecha.replace('a','y');
				}
				while(formatoFecha.indexOf("m")!=-1){
					formatoFecha=formatoFecha.replace('m','M');
				}
				String fechaFormatedaSistema=UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),formatoFecha);
				carteraSRetorno[i][7]=fechaFormatedaSistema; //fechavalor
				carteraSRetorno[i][8]=fechaFormatedaSistema; //fechaVencimiento
				//Buscamos el seleccionado				
				entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK("BEL_MEDIO_PAGO",new Long(1),cartera.getOidIdioma(),new Long(carteraSRetorno[i][14]));				
				carteraSRetorno[i][9]=entidadi18nLocal.getDetalle(); //medioPagoDesc
				carteraSRetorno[i][11]=carteraValidar[i][9]; //importe
				//carteraSRetorno[i][12]=carteraValidar[i][10]; //importePendiente
				//entidadi18nLocal=null;
				//entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK("SEG_MONED",new Long(1),cartera.getOidIdioma(),new Long(carteraSRetorno[i][14]));								
				//carteraSRetorno[i][10]=entidadi18nLocal.getDetalle(); //divisaDesc
				carteraSRetorno[i][12]=carteraValidar[i][10]; //importeDivisa
				MarcaLocal marcaLocal=marcaHome.findByPrimaryKey(marcaOid);
				carteraSRetorno[i][1]=marcaLocal.getDes_marc(); //marcaDESC 
				carteraSRetorno[i][13]=carteraValidar[i][11]; //observaciones
				carteraSRetorno[i][15]=""+marcaOid; //MARCA

				Long canalOid = null;
				try {
					canalOid = (this.getCanalLocalHome().findByClaveUnica(carteraValidar[i][2])).getOid();
				} catch (NoResultException e) {
					ExcelIncorrectoException excelE = new ExcelIncorrectoException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.CANAL_NO_RECONOCID0)); 
					excelE.addParameter(carteraValidar[i][2]);
					excelE.setPosicion(ExcelIncorrectoException.POSICION_FINAL);
					throw  excelE; //ExcelIncorrectoException con el código de mensaje CCC-0055 (Canal no reconcido: ) y le anexamos el codigoCanal que hemos pasado en la llamada
				}
				carteraSRetorno[i][16] = canalOid.toString(); //CANAL
				entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK("SEG_CANAL", new Long(1), cartera.getOidIdioma(), canalOid);								
				carteraSRetorno[i][2] = entidadi18nLocal.getDetalle(); //CANALDesc

				
				Long accesoOid = null;
				try {
					accesoOid = (this.getAccesoLocalHome().findByClaveUnica(carteraValidar[i][3], canalOid)).getOid();
				} catch (NoResultException e) {
					ExcelIncorrectoException excelE = new ExcelIncorrectoException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.ACCESO_NO_RECONOCID0)); 
					excelE.addParameter(carteraValidar[i][3]);
					excelE.setPosicion(ExcelIncorrectoException.POSICION_FINAL);
					throw  excelE; //ExcelIncorrectoException con el código de mensaje CCC-0056 (Acceso no reconcido: ) y le anexamos el codigoCanal que hemos pasado en la llamada
				}
				carteraSRetorno[i][17] = accesoOid.toString(); //ACCESO
				entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK("SEG_ACCES", new Long(1), cartera.getOidIdioma(), accesoOid);								
				carteraSRetorno[i][3] = entidadi18nLocal.getDetalle(); //ACCESODesc



				Long subaccesoOid = null;
				try {
					subaccesoOid = (this.getSubaccesoLocalHome().findByUK(carteraValidar[i][4], accesoOid)).getOid();
				} catch (NoResultException e) {
					ExcelIncorrectoException excelE = new ExcelIncorrectoException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.SUBACCESO_NO_RECONOCID0)); 
					excelE.addParameter(carteraValidar[i][4]);
					excelE.setPosicion(ExcelIncorrectoException.POSICION_FINAL);
					throw  excelE; //ExcelIncorrectoException con el código de mensaje CCC-0057 (Subacceso no reconcido: ) y le anexamos el codigoCanal que hemos pasado en la llamada
				}
				carteraSRetorno[i][18] = subaccesoOid.toString(); //ACCESO
				entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK("SEG_SUBAC", new Long(1), cartera.getOidIdioma(), subaccesoOid);								
				carteraSRetorno[i][4] = entidadi18nLocal.getDetalle(); //SUBACCESODesc
				carteraSRetorno[i][6]=carteraValidar[i][6]; //REFERENCIA EXTERNA
				validaAcceso(cartera.getOidPais(),null, new Long(carteraSRetorno[i][15]), new Long(carteraSRetorno[i][16]), new Long(carteraSRetorno[i][17]), new Long(carteraSRetorno[i][18]), null, null, null, null,null);				
				UtilidadesLog.debug("validarCarteraMasiva: Acceso concedido");

			}catch(ParseException e){
				ctx.setRollbackOnly();
				String codigoError = CodigosError.ERROR_PARAMETROS_INCORRECTOS;
				this.logearError("validarCarteraMasiva: ParseException",e);
				throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
			}catch(NoResultException e){
				ctx.setRollbackOnly();
				String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
				this.logearError("validarCarteraMasiva: FinderException",e);
				throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
			}catch (RemoteException e) {
				ctx.setRollbackOnly();
				String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
				this.logearError("validarCarteraMasiva: RemoteException",e);
				throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
			}			
		}
		UtilidadesLog.debug("****Fuera try catch");
		carteraValidada.setElementos(carteraSRetorno);
		UtilidadesLog.info("MONCargosAbonosBean. validarCarteraMasiva(DTOCargaMasiva cartera): Salida");
		return carteraValidada;
	}

	protected RecordSet obtenerSubprocesosGestionCheques(Long idioma, Long pais) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.obtenerSubprocesosGestionCheques(Long idioma, Long pais): Entrada");

		DAOCCC daoCCC = new DAOCCC();
		Long oidProc = daoCCC.obtieneProceso(CCCConstantes.PROCESO_GESTION_CHEQUES, pais);
		DTOOID dtoOID = new DTOOID();
		dtoOID.setOidIdioma(idioma);
		dtoOID.setOidPais(pais);
		dtoOID.setOid(oidProc);
		DTOSalida dtoSalida = this.recargaSubprocesos(dtoOID);
			
		UtilidadesLog.info("MONCargosAbonosBean.obtenerSubprocesosGestionCheques(Long idioma, Long pais): Salida");
		return dtoSalida.getResultado();
	}

	public void enviarMensajesGastosAbonos(RecordSet conceptos, Long pais) throws MareException {
        UtilidadesLog.info("MONCargosAbonosBean.enviarMensajesGastosAbonos(RecordSet conceptos, Long pais): Entrada");
		try  {
			MONGestionMensajes monGestionMensajes=this.getMONGestionMensajes();
			
            
            UtilidadesLog.debug("identificadores " + conceptos.getColumnIdentifiers());  
            
            
			for(int i=0;i<conceptos.getRowCount();i++){
                
                UtilidadesLog.debug("*conceptos * " + conceptos);
                
                UtilidadesLog.debug("a ver si trae los dato que necesito ** " + conceptos.getValueAt(i,0).toString());
             
            
				//if (conceptos.getValueAt(i,"OID_DETA_CARG_ABON_DIRE") == null) {
                
                /**
                 * Modificado por Paola cabrera * 
                 * este recordSet se corresponde con el llenado de la 
                 * LPAplicarCargosAbonos,y los valores de las columnas son
                 * diferentes, se modifican....
                 * En todos aquellos lugares que se pregunten por la columna
                 */ 
                 
                 
                if (conceptos.getValueAt(i,"oidDetalle") == null) {
					DTOBuzonMensajes buzonDeMensajes=new DTOBuzonMensajes(); 
					buzonDeMensajes.setOidPais(pais);
					buzonDeMensajes.setCodigoMensaje(ConstantesMSG.MENSAJE_CCC03);

					MONClientes monClientes=this.getIMaestroClientes();
                    
                    
					UtilidadesLog.debug("*** Antes de obtener cliente");
					Long oidCliente = monClientes.obtenerOidCliente(pais,conceptos.getValueAt(i,0).toString());
					UtilidadesLog.debug("*** Despues de obtener cliente");
                    
					buzonDeMensajes.setOidCliente(oidCliente);
                    //-datosVariable1 = cliente.nombre1
                    ClienteDatosBasicosLocalHome clienteHome = this.getClienteDatosBasicosLocalHome();
                    ClienteDatosBasicosLocal clienteLocal = clienteHome.findByPrimaryKey(oidCliente);
                    buzonDeMensajes.setDatoVariable1(clienteLocal.getVal_nom1());
                    
                    
                    // -datosVariable2 = la columna glosaContable               
                    //if(conceptos.getValueAt(i,"VAL_GLOS_CONT") != null) {
                    
                    if(conceptos.getValueAt(i,"glosaContable") != null) {
						UtilidadesLog.debug("*** Dato variable1 + " + conceptos.getValueAt(i,"glosaContable") );
						//buzonDeMensajes.setDatoVariable1(conceptos.getValueAt(i,"VAL_GLOS_CONT").toString());
                        buzonDeMensajes.setDatoVariable2(conceptos.getValueAt(i,"glosaContable").toString());
					}
                    // -datosVariable3 = la columna fechaPago
                    //if(conceptos.getValueAt(i,"FEC_DOCU") != null) {
                    if(conceptos.getValueAt(i,"fechaPago") != null) {
						UtilidadesLog.debug("*** Dato variable2 " + conceptos.getValueAt(i,"fechaPago"));
						//buzonDeMensajes.setDatoVariable2(((Date)conceptos.getValueAt(i,"FEC_DOCU")).toString());
                        buzonDeMensajes.setDatoVariable3((conceptos.getValueAt(i,"fechaPago")).toString());
					}
                    
                    
                    // -datosVariable4 = la columna importe                
                    //if (conceptos.getValueAt(i,"IMP")!=null) {
					if (conceptos.getValueAt(i,"importe")!=null) {
						UtilidadesLog.debug("*** Dato variable3 " + conceptos.getValueAt(i,"importe"));
						//buzonDeMensajes.setDatoVariable3((new Long(((BigDecimal)conceptos.getValueAt(i,"IMP")).longValue())).toString());
                        buzonDeMensajes.setDatoVariable4((new Long(((BigDecimal)conceptos.getValueAt(i,"importe")).longValue())).toString());
                    }
                    
                    
					buzonDeMensajes.setModuloOrigen(new Long(ConstantesSEG.MODULO_CCC));
					UtilidadesLog.debug("*** Antes de InsertaDatosMensaje()");
					monGestionMensajes.insertaDatosMensaje(buzonDeMensajes);                    
                    UtilidadesLog.debug("*** Sale de InsertaDatosMensaje()");
				}
			}
		} catch (RemoteException e)  {
			ctx.setRollbackOnly();
			this.logearError("*** Error en enviarMensajesGastosAbonos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));				
		}catch (MareException e)  {
			ctx.setRollbackOnly();
			//e.printStackTrace();
			UtilidadesLog.error(e);
            throw e;
		}catch (Exception e)  {
			ctx.setRollbackOnly();
			//e.printStackTrace();
			this.logearError("*** Error en enviarMensajesGastosAbonos",e);
		}  
		UtilidadesLog.info("MONCargosAbonosBean.enviarMensajesGastosAbonos(RecordSet conceptos, Long pais): Salida");
	}


	public DTOSalida obtenerDatosInicialesProcesos (DTOBelcorp dto) throws MareException{
		UtilidadesLog.info("MONCargosAbonosBean.obtenerDatosInicialesProcesos (DTOBelcorp dto): Entrada");
		DAOCCC daoCCC = new DAOCCC();
		RecordSet rs = new RecordSet();
		long pais = dto.getOidPais().longValue();
		boolean bol = true;
		
		rs = daoCCC.obtieneProcesosPais(pais,bol);

		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONCargosAbonosBean.obtenerDatosInicialesProcesos (DTOBelcorp dto): Salida");
        return dtoSalida;
	}

    private Entidadi18nLocalHome getI18NEntityLocalHome() throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.getI18NEntityLocalHome(): Entrada");        
		UtilidadesLog.info("MONCargosAbonosBean.getI18NEntityLocalHome(): Salida");
        return new Entidadi18nLocalHome();
    } 	
	
/*
	private Log getLog() {
		Log log = null;
		try {
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println ("No se pudo obtener el objeto Log");
			throw new RuntimeException ("No se pudo obtener el objeto Log");
		}
	}  
*/
	private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error(e);
	}

	private void loguearSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("MONCargosAbonosBean.loguearSql(String metodo, String sql, Vector params): Entrada");
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
        UtilidadesLog.info("MONCargosAbonosBean.loguearSql(String metodo, String sql, Vector params): Salida");
	}
    private MONClientes getIMaestroClientes() throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.getIMaestroClientes(): Entrada");
        // Se obtiene el interfaz home
        MONClientesHome home = (MONClientesHome)UtilidadesEJB.getHome(
            "MONClientes", MONClientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONClientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("getIMaestroClientes: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONCargosAbonosBean.getIMaestroClientes(): Salida");
        return ejb;
    }
    private MONMantenimientoSEG getIServicioSEG() throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.getIServicioSEG(): Entrada");
        // Se obtiene el interfaz home
        MONMantenimientoSEGHome home = (MONMantenimientoSEGHome)UtilidadesEJB.getHome(
            "MONMantenimientoSEG", MONMantenimientoSEGHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoSEG ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("getIServicioSEG: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONCargosAbonosBean.getIServicioSEG(): Salida");
        return ejb;
    }	
    private MONPeriodos getMONPeriodos() throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.getMONPeriodos(): Entrada");
        // Se obtiene el interfaz home
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome(
            "MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("getMONPeriodos: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONCargosAbonosBean.getMONPeriodos(): Salida");
        return ejb;
    }		
	private void validaAccesoVinculos(Long pais,Long empresa,Long sociedad, Long marca, Long canal, Long acceso,Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)throws RemoteException, MareException{
		UtilidadesLog.info("MONCargosAbonosBean.validaAccesoVinculos(Long pais,Long empresa,Long sociedad, Long marca, Long canal, Long acceso,Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");
		validaAcceso(pais,empresa,marca,canal,acceso,subAcceso,subgerencia,region,zona,seccion,territorio);
		validaVinculos(pais,sociedad,marca,canal,acceso,subAcceso);
		UtilidadesLog.info("MONCargosAbonosBean.validaAccesoVinculos(Long pais,Long empresa,Long sociedad, Long marca, Long canal, Long acceso,Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");		
	}
    private void validaAcceso(Long pais,Long empresa, Long marca, Long canal, Long acceso,Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio) throws RemoteException, MareException {
		UtilidadesLog.info("MONCargosAbonosBean.validaAcceso(Long pais,Long empresa, Long marca, Long canal, Long acceso,Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);

        //Valida que el usuario tenga acceso al Pais, Marca y Canal que se pasan
        //como parametro.		
		UtilidadesLog.debug("****Llamada a validaAcceso(pais= "+ pais+", marca="+marca+", canal= "+canal+", acceso="+acceso+", subgerencia="+subgerencia+", region="+region+", zona="+zona+", seccion="+seccion+", territorio="+territorio);
		b = monValidacion.validarAccesos( pais, empresa, marca, canal, acceso, subacceso, subgerencia, region, zona, seccion, territorio);
		UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());
		if (!b.booleanValue()){				
			ctx.setRollbackOnly();
			UtilidadesLog.error("****Metodo validaAcceso: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
		}
		UtilidadesLog.info("MONCargosAbonosBean.validaAcceso(Long pais,Long empresa, Long marca, Long canal, Long acceso,Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");


   }
    private void validaVinculos(Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso) throws RemoteException, MareException {
		UtilidadesLog.info("MONCargosAbonosBean.validaVinculos(Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso): Entrada");
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);
		
		UtilidadesLog.debug("**** Llamada a validaVinculos(pais= "+ pais + ", marca= "+marca + ", canal= " + canal + ", acceso= "+ acceso+ ")");
		b = monValidacion.validarVinculos( pais, sociedad, marca, canal, acceso, subAcceso);
		UtilidadesLog.debug("**** Retorno validaVinculos:  " + b.toString());
		if (!b.booleanValue()){				
			ctx.setRollbackOnly();			
			UtilidadesLog.error("****Metodo validaVinculos: validarVinculos : ERROR_VINCULOS_INVALIDOS");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULOS_INVALIDOS) );
		} 					
		UtilidadesLog.info("MONCargosAbonosBean.validaVinculos(Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso): Salida");


   }   
    private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONCargosAbonosBean.getMONValidacion(): Entrada");
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
		UtilidadesLog.info("MONCargosAbonosBean.getMONValidacion(): Salida");
        return ejb;
	}  
	    private MONProcesosPED getMONProcesosPED() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONCargosAbonosBean.getMONProcesosPED(): Entrada");
        MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome(
            "MONProcesosPED", MONProcesosPEDHome.class);
            
        // Se obtiene el interfaz remoto
        MONProcesosPED ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONProcesosPED",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONCargosAbonosBean.getMONProcesosPED(): Salida");
        return ejb;
	} 

    private MONUnidadesAdministrativas getMONUnidadesAdministrativas() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONCargosAbonosBean.getMONUnidadesAdministrativas(): Entrada");
        MONUnidadesAdministrativasHome home = (MONUnidadesAdministrativasHome)UtilidadesEJB.getHome(
            "MONUnidadesAdministrativas", MONUnidadesAdministrativasHome.class);
            
        // Se obtiene el interfaz remoto
        MONUnidadesAdministrativas ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONUnidadesAdministrativas",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONCargosAbonosBean.getMONUnidadesAdministrativas(): Salida");
        return ejb;
	}   
    private MONCuentasCorrientes getMONCuentasCorrientes() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONCargosAbonosBean.getMONCuentasCorrientes(): Entrada");
        MONCuentasCorrientesHome home = (MONCuentasCorrientesHome)UtilidadesEJB.getHome(
            "MONCuentasCorrientes", MONCuentasCorrientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONCuentasCorrientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONCuentasCorrientes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONCargosAbonosBean.getMONCuentasCorrientes(): Salida");
        return ejb;
	}  
	
    private MONGestionMedioPagoBelCenter getMONGestionMedioPagoBelCenter() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONCargosAbonosBean.getMONGestionMedioPagoBelCenter(): Entrada");
        MONGestionMedioPagoBelCenterHome home = (MONGestionMedioPagoBelCenterHome)UtilidadesEJB.getHome(
            "MONGestionMedioPagoBelCenter", MONGestionMedioPagoBelCenterHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestionMedioPagoBelCenter ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONGestionMedioPagoBelCenter",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONCargosAbonosBean.getMONGestionMedioPagoBelCenter(): Salida");
        return ejb;
	}   		
    private MONConfiguracionClientes getMONConfiguracionClientes() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONCargosAbonosBean.getMONConfiguracionClientes(): Entrada");
        MONConfiguracionClientesHome home = (MONConfiguracionClientesHome)UtilidadesEJB.getHome(
            "MONConfiguracionClientes", MONConfiguracionClientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONConfiguracionClientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONConfiguracionClientes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONCargosAbonosBean.getMONConfiguracionClientes(): Salida");
        return ejb;
	}   	
    private MONGestionMensajes getMONGestionMensajes() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONCargosAbonosBean.getMONGestionMensajes(): Entrada");
        MONGestionMensajesHome home = (MONGestionMensajesHome)UtilidadesEJB.getHome(
            "MONGestionMensajes", MONGestionMensajesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestionMensajes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONGestionMensajes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONCargosAbonosBean.getMONGestionMensajes(): Salida");
        return ejb;
	}   
	public void aplicarCargosAbonos(DTOCargosAbonos dto) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.aplicarCargosAbonos(DTOCargosAbonos dto): Entrada");
    UtilidadesLog.debug("DTOCargosAbonos recibidos: " + dto);
    
    Cronometrador.startTransaction("MONCargosAbonosBean.aplicarCargosAbonos");
		try {
//Añadido por incidencia 7704 y reflejados los cambios en el paquete 11B
			//Obtenemos los oids del DTOCargosAbonos.cancelacionCuotas: oidsMovCC
			//Obtenemos los oids del DTOCargosAbonos.aplicacionCobros: oidsMovaBanc
      Cronometrador.startTransaction("MONCargosAbonosBean-->monCuentasCorrientes");
			MONCuentasCorrientes monCuentasCorrientes = this.getMONCuentasCorrientes();
			DTOOIDs dtoOidsMovCC = new DTOOIDs();
			DTOOIDs dtoOidsMovBanc = new DTOOIDs();
			Vector oidMovCC = new Vector();
			Vector oidMovBanc = new Vector();
			int i;
			if (!dto.getCancelacionCuotas().esVacio()){
        Cronometrador.startTransaction("MONCargosAbonosBean-->getCancelacionCuotas");
				UtilidadesLog.debug("REcordset CancelacionCuotas no es vacio: ***"+dto.getCancelacionCuotas().toString());
				UtilidadesLog.debug("Posicion Columna OID: "+dto.getCancelacionCuotas().getColumnPosition("OID"));
				oidMovCC = dto.getCancelacionCuotas().getColumn(dto.getCancelacionCuotas().getColumnPosition("OID")); //Columna OID
				UtilidadesLog.debug("*** oidMovCC: "+oidMovCC);
				
				Long oidsMovCC[] = new Long[oidMovCC.size()];
				for (i=0; i<oidMovCC.size(); i++){
					UtilidadesLog.debug("i = "+i);
					UtilidadesLog.debug("Vector oidMovCC["+i+"]: "+ oidMovCC.elementAt(i));
					oidsMovCC[i] = new Long(oidMovCC.elementAt(i).toString());
          //oidsMovCC[i] = (Long)oidMovCC.elementAt(i);
					UtilidadesLog.debug("Array oidsMovCC["+i+"]: "+oidsMovCC[i].toString());					
				}
				
				//los incluimos en un DTOOIDs cada uno
				dtoOidsMovCC.setOids(oidsMovCC); 
				UtilidadesLog.debug("DTOOIDsMovCC: "+dtoOidsMovCC.getOids().toString());

				//Comprobamos si continúan bloqueados
				if (!monCuentasCorrientes.sigueBloqueadoMovCC(dtoOidsMovCC).booleanValue()){
					UtilidadesLog.debug("Estan bloqueados MovCC");
					throw new MareException(null,null,
						UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC , "", 
							ErroresDeNegocio.CCC_0044)); //La entidad está bloqueada

				}/*else{
					UtilidadesLog.debug("Está bloqueado se procede a desbloquear el movCC");
					monCuentasCorrientes.eliminarBloqueosMovCC(dtoOidsMovCC);
					UtilidadesLog.debug("MovimientoCC desbloqueado");
				}*/				
        Cronometrador.endTransaction("MONCargosAbonosBean-->getCancelacionCuotas");
			}
			
			if (!dto.getAplicacionCobros().esVacio()){	
        Cronometrador.startTransaction("MONCargosAbonosBean-->getAplicacionCobros");
				UtilidadesLog.debug("APLICACIONCOBROS no está vacio");
				UtilidadesLog.debug("Posicion columna OID: "+dto.getAplicacionCobros().getColumnPosition("OID"));
				oidMovBanc = dto.getAplicacionCobros().getColumn(dto.getAplicacionCobros().getColumnPosition("OID"));  //Columna OID
				UtilidadesLog.debug("OIDsMovBanc: "+ oidMovBanc);
			
				Long oidsMovBanc[] = new Long[oidMovBanc.size()];			
				for (i=0; i<oidMovBanc.size(); i++){
					UtilidadesLog.debug("i = "+i);
					UtilidadesLog.debug("Vector oidMovBanc["+i+"]: "+ oidMovBanc.elementAt(i));
					if(oidMovBanc.elementAt(i)!=null){
                        oidsMovBanc[i] = new Long(oidMovBanc.elementAt(i).toString());
                    }
					UtilidadesLog.debug("Array oidsMovBanc["+i+"]: "+oidsMovBanc[i].toString());
				}
				//los incluimos en un DTOOIDs cada uno
				dtoOidsMovBanc.setOids(oidsMovBanc);
				UtilidadesLog.debug("DTOOIDsMovBanc: "+ dtoOidsMovBanc.getOids().toString());
				//Comprobamos si continúan bloqueados
				if (!monCuentasCorrientes.sigueBloqueadoMovBanc(dtoOidsMovBanc).booleanValue()){
					UtilidadesLog.debug("Estan bloqueados MovBanc");
					throw new MareException(null,null,
						UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC , "", 
							ErroresDeNegocio.CCC_0044)); //La entidad está bloqueada

				}/*else{
					//En caso contrario eliminamos el bloqueo
					UtilidadesLog.debug("Movimiento Banc bloqueado, se procede a desbloquear");
					monCuentasCorrientes.eliminarBloqueosMovBanc(dtoOidsMovBanc);
					UtilidadesLog.debug("Mov Banc desbloqueado");
				}*/			
        Cronometrador.endTransaction("MONCargosAbonosBean-->getAplicacionCobros");
			}
////// fin del añadido			
      Cronometrador.endTransaction("MONCargosAbonosBean-->monCuentasCorrientes");
			UtilidadesLog.debug("Fin de comprobacion de bloqueos");


      Cronometrador.startTransaction("MONCargosAbonosBean-->monCuentasCorrientes-->bloqueos");
			//bloqueamos las tablas
			monCuentasCorrientes.bloquearBloqueoMovBanc();
			monCuentasCorrientes.bloquearBloqueoMovCC();
			Cronometrador.endTransaction("MONCargosAbonosBean-->monCuentasCorrientes-->bloqueos");
      
			UtilidadesLog.debug("dto.getOid(): "+ dto.getOid()+" ++++");
			if(dto.getOid()!=null){
				UtilidadesLog.debug("Entra en oid!=null");
				DAOCargosAbonos daoCargosAbonos=new DAOCargosAbonos(ctx.getCallerPrincipal().getName());
				if(!daoCargosAbonos.esPosibleModificar(dto.getOid()).booleanValue()){
					UtilidadesLog.debug("No es posible Modificar");
					throw new MareException(new Exception(),
	                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
		                ErroresDeNegocio.EXISTENCIA_TRATAMIENTOS_POSTERIORES));

				}
			}
			
			Cronometrador.startTransaction("MONCargosAbonosBean-->validaAcceso");
			this.validaAcceso(dto.getOidPais(),dto.getEmpresa(),null,dto.getCanal(),dto.getAcceso(),dto.getSubacceso(),null,null,null,null,null);
      Cronometrador.endTransaction("MONCargosAbonosBean-->validaAcceso");
      Cronometrador.startTransaction("MONCargosAbonosBean-->validaVinculos");
			this.validaVinculos(dto.getOidPais(),dto.getEmpresa(),null,dto.getCanal(),dto.getAcceso(),dto.getSubacceso());
			Cronometrador.endTransaction("MONCargosAbonosBean-->validaVinculos");
			MONClientes monClientes=this.getIMaestroClientes();	
			/*LLamamos a IMaestroClientes.obtenerOidCliente pasandole el dto.codigoCliente. 
			El valor que obtenemos lo metemos en el atributo oidCliente, pero si hemos obtenido un null { 
			Lanzamos una MareException con el código de error MAE-0024 (El código de cliente introducido no es válido) 
			} // 3690
			*/
      Cronometrador.startTransaction("MONCargosAbonosBean-->getCodigoCliente");
			Long oidCliente = null;
			UtilidadesLog.debug("dto.getCodigoCliente(): "+ dto.getCodigoCliente()+" +++++");
			if (dto.getCodigoCliente()!=null) {
				UtilidadesLog.debug("CodigoCliente es != null");
				oidCliente = monClientes.obtenerOidCliente(dto.getOidPais(),dto.getCodigoCliente());
				if(oidCliente==null){
						this.lanzarMAE0024Exception(dto.getCodigoCliente());
				}
			}
      Cronometrador.endTransaction("MONCargosAbonosBean-->getCodigoCliente");
      
			Cronometrador.startTransaction("MONCargosAbonosBean-->validarClientesSubprocesos");
			this.validarClientesSubprocesos(dto);
			Cronometrador.endTransaction("MONCargosAbonosBean-->validarClientesSubprocesos");
      
      
			String usuario = ctx.getCallerPrincipal().getName();
			//si viene informado el oid modificamos, si no insertamos.
			CabeceraCargosAbonosDirectosLocalHome cabeceraHome=this.getCabeceraCargosAbonosDirectosLocalHome();
			CabeceraCargosAbonosDirectosLocal cabeceraLocal = null;
			if(dto.getOid()==null){
        Cronometrador.startTransaction("MONCargosAbonosBean-->cabeceraHome.create");
				//Modificado masanz 17/08/2004
				UtilidadesLog.debug("dto.getoid es null con lo que se realiza un create");
        Integer numeroIdentificacion = null;
        if (dto.getNumeroIdentificacion()!=null)
            numeroIdentificacion = Integer.valueOf(dto.getNumeroIdentificacion().toString());
				cabeceraLocal=cabeceraHome.create(numeroIdentificacion,
												  UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"yy"),
												  UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"MM"),
												  new Date(dto.getFechaDocumento().getTime()),
												  new Date(dto.getFechaValor().getTime()),
												  dto.getReferenciaExterna(),
												  null,
												  null,
												  dto.getObservaciones(),
												  //dto.getProceso(),
												  dto.getSubacceso(),
												  dto.getOidPais(),
												  dto.getEmpresa(),
												  oidCliente,
												  usuario,
												  null,// incidencia BELC300008037
												  null,
												  null,
												  null,
												  null,
												  null,
												  null,
												  null,
												  null,
												  null,
												  dto.getOidCuentaCorriente(),
												  dto.getProceso());
				Cronometrador.endTransaction("MONCargosAbonosBean-->cabeceraHome.create");

			} else  {
        Cronometrador.startTransaction("MONCargosAbonosBean-->cabeceraHome.findByPrimaryKey");
        cabeceraLocal=cabeceraHome.findByPrimaryKey(dto.getOid());  
        Cronometrador.endTransaction("MONCargosAbonosBean-->cabeceraHome.findByPrimaryKey");
      }
      

			if(dto.getOid()!=null){
				Cronometrador.startTransaction("MONCargosAbonosBean-->eliminarDetalles");
				this.eliminarDetalles(dto.getOid());
				Cronometrador.endTransaction("MONCargosAbonosBean-->eliminarDetalles");
			}
			DTOParametrosSubproceso dtoParametros=null;
			// el numero de linea o numero de detalle debe empezar en uno
      short numDetalle=1;
			//guardamos los detalles.
          Cronometrador.startTransaction("MONCargosAbonosBean-->guardarDetalles");
            //incidencia 15414
            if (dto.getCancelacionCuotas() != null && dto.getCancelacionCuotas().getRowCount() > 0) {
                Cronometrador.startTransaction("MONCargosAbonosBean-->cancelacionCuotas");
                dtoParametros=this.obtenerParametrosSubproceso(CCCConstantes.CANCELACION_CUOTAS,dto.getProceso());
                dtoParametros.setOidPais(dto.getOidPais());// 4296
                dtoParametros.setOidIdioma(dto.getOidIdioma());
                numDetalle   =this.cancelacionCuotas(dto.getCancelacionCuotas(),cabeceraLocal,numDetalle,dtoParametros, dto);
                Cronometrador.endTransaction("MONCargosAbonosBean-->cancelacionCuotas");
            }

            if (dto.getAplicacionCobros() != null && dto.getAplicacionCobros().getRowCount() > 0) {
                Cronometrador.startTransaction("MONCargosAbonosBean-->aplicacionCobros");
                dtoParametros=this.obtenerParametrosSubproceso(CCCConstantes.APLICACION_COBROS,dto.getProceso());
                dtoParametros.setOidPais(dto.getOidPais());// 4296
                dtoParametros.setOidIdioma(dto.getOidIdioma());
                numDetalle   =this.aplicacionCobros(dto.getAplicacionCobros(),cabeceraLocal,numDetalle,dtoParametros);
                Cronometrador.endTransaction("MONCargosAbonosBean-->aplicacionCobros");
            }

            if (dto.getConceptosGastosAbonos() != null && dto.getConceptosGastosAbonos().getRowCount() > 0) {
                //incidencia 10294
                Cronometrador.startTransaction("MONCargosAbonosBean-->conceptosGastosAbonos");
                dtoParametros=this.obtenerSubproceso(CCCConstantes.CONCEPTOS_GASTOS_ABONOS, dto.getProceso());
                dtoParametros.setOidPais(dto.getOidPais());// 4296
                dtoParametros.setOidIdioma(dto.getOidIdioma());
                numDetalle = this.conceptosGastosAbonos(dto.getConceptosGastosAbonos(), cabeceraLocal, numDetalle, dtoParametros);
                Cronometrador.endTransaction("MONCargosAbonosBean-->conceptosGastosAbonos");
            }
			
            if (dto.getGeneracionVencimientos() != null && dto.getGeneracionVencimientos().getRowCount() > 0) {
                Cronometrador.startTransaction("MONCargosAbonosBean-->generacionVencimentos");
                dtoParametros=this.obtenerParametrosSubproceso(CCCConstantes.GENERACION_VENCIMIENTOS,dto.getProceso());
                dtoParametros.setOidPais(dto.getOidPais());// 4296
                dtoParametros.setOidIdioma(dto.getOidIdioma());
                numDetalle = this.generacionVencimientos(dto.getGeneracionVencimientos(),cabeceraLocal,numDetalle,dtoParametros,dto.getOidPais());
                Cronometrador.endTransaction("MONCargosAbonosBean-->generacionVencimentos");
            }
          Cronometrador.endTransaction("MONCargosAbonosBean-->guardarDetalles");
      
      Cronometrador.startTransaction("MONCargosAbonosBean-->eliminarBloqueoMovCC");
      monCuentasCorrientes.eliminarBloqueoMovCC();
      Cronometrador.endTransaction("MONCargosAbonosBean-->eliminarBloqueoMovCC");
      Cronometrador.startTransaction("MONCargosAbonosBean-->eliminarBloqueoMovBanc");
			monCuentasCorrientes.eliminarBloqueoMovBanc();
      Cronometrador.endTransaction("MONCargosAbonosBean-->eliminarBloqueoMovBanc");

			Cronometrador.startTransaction("MONCargosAbonosBean-->enviarMensajesGastosAbonos");
			this.enviarMensajesGastosAbonos(dto.getConceptosGastosAbonos(),dto.getOidPais());			
			Cronometrador.endTransaction("MONCargosAbonosBean-->enviarMensajesGastosAbonos");

		} catch (ParseException e)  {
        e.printStackTrace();
        ctx.setRollbackOnly();
        this.logearError("Error en aplicarCargosAbonos",e);
        String codigoError = CodigosError.ERROR_PARAMETROS_INCORRECTOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
		}catch (PersistenceException e)  {
        e.printStackTrace();
        ctx.setRollbackOnly();
        this.logearError("Error en aplicarCargosAbonos",e);
        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
		}catch (MareException e) {
        e.printStackTrace();
        ctx.setRollbackOnly();
        this.logearError("Error en aplicarCargosAbonos",e);
        throw e;
		}catch (Exception e) {
        e.printStackTrace();
        ctx.setRollbackOnly();
        this.logearError("Error en aplicarCargosAbonos",e);
        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}finally{
         try{
            new DAOCCC().eliminarBloqueo();
         }catch (Exception e){
            e.printStackTrace();
         }
      
      }
      
		Cronometrador.endTransaction("MONCargosAbonosBean.aplicarCargosAbonos");
		UtilidadesLog.info("MONCargosAbonosBean.aplicarCargosAbonos(DTOCargosAbonos dto): Salida");
	}

	protected void validarClientesSubprocesos(DTOCargosAbonos dto) throws MareException {
		
        UtilidadesLog.info("MONCargosAbonosBean.validarClientesSubprocesos(DTOCargosAbonos dto): Entrada");
        
		RecordSet cancelacionCuotas=dto.getCancelacionCuotas();
		RecordSet conceptosGastosAbonos=dto.getConceptosGastosAbonos();
		RecordSet generacionVencimientos=dto.getGeneracionVencimientos();
		RecordSet aplicacionCobros=dto.getAplicacionCobros();
		MONClientes  monClientes=this.getIMaestroClientes();
		try{
			for(int i=0;(cancelacionCuotas!=null)&&(!cancelacionCuotas.esVacio())&&(i<cancelacionCuotas.getRowCount())&&(cancelacionCuotas.getValueAt(i,0)!=null);i++){
				Long oidCliente=monClientes.obtenerOidCliente(dto.getOidPais(),cancelacionCuotas.getValueAt(i,0).toString());
				if(oidCliente==null){
					this.lanzarMAE0024Exception(cancelacionCuotas.getValueAt(i,0).toString());
				}
			}
			for(int i=0;(conceptosGastosAbonos!=null)&&(!conceptosGastosAbonos.esVacio())&&(i<conceptosGastosAbonos.getRowCount())&&(conceptosGastosAbonos.getValueAt(i,0)!=null);i++){
				//Long oidCliente=monClientes.obtenerOidCliente(dto.getOidPais(),conceptosGastosAbonos.getValueAt(i,0).toString());
				//pzerbino 24325 11/10/2006 Cmabio de CCC
        /*if(oidCliente==null){
					this.lanzarMAE0024Exception(conceptosGastosAbonos.getValueAt(i,0).toString());
				}*/
			}
			for(int i=0;(generacionVencimientos!=null)&&(!generacionVencimientos.esVacio())&&(i<generacionVencimientos.getRowCount())&&(generacionVencimientos.getValueAt(i,0)!=null);i++){
				Long oidCliente=monClientes.obtenerOidCliente(dto.getOidPais(),generacionVencimientos.getValueAt(i,0).toString());
				if(oidCliente==null){
					this.lanzarMAE0024Exception(generacionVencimientos.getValueAt(i,0).toString());
				}
			}
			for(int i=0;(aplicacionCobros!=null)&&(!aplicacionCobros.esVacio())&&(i<aplicacionCobros.getRowCount())&&(aplicacionCobros.getValueAt(i,0)!=null);i++){
				Long oidCliente=monClientes.obtenerOidCliente(dto.getOidPais(),aplicacionCobros.getValueAt(i,0).toString());
				if(oidCliente==null){
					this.lanzarMAE0024Exception(aplicacionCobros.getValueAt(i,0).toString());
				}
			}			
		}catch(RemoteException e){
			this.logearError("*** Error en validarClientesSubprocesos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));	
		}
        
        UtilidadesLog.info("MONCargosAbonosBean.validarClientesSubprocesos(DTOCargosAbonos dto): Salida");
	
	}

	public DTOSalida buscar(DTOBuscarCargosAbonos dto) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.buscar(DTOBuscarCargosAbonos dto): Entrada");
		DAOCargosAbonos daoCargosAbonos=new DAOCargosAbonos(ctx.getCallerPrincipal().getName());
		DTOSalida salida=daoCargosAbonos.buscar(dto)		;
    	UtilidadesLog.info("MONCargosAbonosBean.buscar(DTOBuscarCargosAbonos dto): Salida");
		return salida; 		
	}

	public void eliminar(DTOOIDs oids) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.eliminar(DTOOIDs oids): Entrada");

		boolean todosBorrados=true;
		DAOCargosAbonos daoCargosAbonos=new DAOCargosAbonos(ctx.getCallerPrincipal().getName());
		Long[] arrayDto=oids.getOids();
		for(int i=0;i<arrayDto.length;i++){
			//Comentado masanz 17/08/2004
			if(daoCargosAbonos.esPosibleModificar(arrayDto[i]).booleanValue()){
				this.eliminarCargoAbono(arrayDto[i]);
			}else{
				todosBorrados=false;
			}
				
		}
		if(!todosBorrados){
			throw new MareException(new Exception(),
					UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
					ErroresDeNegocio.NO_TODAS_LAS_APLICACIONES_BORRADAS));
		}
			
		UtilidadesLog.info("MONCargosAbonosBean.eliminar(DTOOIDs oids): Salida");
		
	}

	public DTOCargosAbonos obtener(DTOObtenerCargosAbonos dto) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.obtener(DTOObtenerCargosAbonos dto): Entrada");
		DAOCargosAbonos daoCargosAbonos=new DAOCargosAbonos(ctx.getCallerPrincipal().getName());
		//DAOCargosAbonos daoCargosAbonos=new DAOCargosAbonos("USUARIO1");
		if((dto.getModificar()!=null)&&dto.getModificar().booleanValue()){
			//Comentado Masanz 17/08/2004
			if(!daoCargosAbonos.esPosibleModificar(dto.getOid()).booleanValue()){
				throw new MareException(new Exception(),
						UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
						ErroresDeNegocio.EXISTENCIA_TRATAMIENTOS_POSTERIORES));
			}
		}
				
		DTOOID dtoOid=new DTOOID();
		dtoOid.setOid(dto.getOid());
		dtoOid.setOidIdioma(dto.getOidIdioma());
		dtoOid.setOidPais(dto.getOidPais());
		DTOCargosAbonos dtoCargosAbonos=daoCargosAbonos.obtenerCabecera(dtoOid);

		MONCuentasCorrientes monCuentasCorrientes=this.getMONCuentasCorrientes();

		//Cancelación Cuotas
		RecordSet rs = daoCargosAbonos.obtieneCancelacionCuotas(dtoOid);
		dtoCargosAbonos.setCancelacionCuotas(rs);
		DTOOIDs dtoOids = new DTOOIDs();
		dtoOids.setOidIdioma(dto.getOidIdioma());
		dtoOids.setOidPais(dto.getOidPais());
		Long[] oids= new Long[rs.getRowCount()];
		for(int i=0;i<rs.getRowCount();i++){
			UtilidadesLog.debug("****dentro del bucle for"+ rs.getRowCount());
			oids[i] = new Long(((BigDecimal)rs.getValueAt(i,"OID_MOVI_CC")).toString());	
		}
		UtilidadesLog.debug("****fuera del bucle for");
		if(oids.length > 0){
			dtoOids.setOids(oids);
			try{
				if (!monCuentasCorrientes.bloquearMovCC(dtoOids).booleanValue()) {
					UtilidadesLog.debug("****pasado bloqueo");
					throw new MareException(new Exception(),
							UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
							ErroresDeNegocio.CCC_0044));
				}
				UtilidadesLog.debug("****dentro del try");
			}catch(RemoteException re){
				String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
				this.logearError("obtener: RemoteException",re);
				throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
			}
		}
		
		
		//Aplicación Cobros
		rs = null;
		rs = daoCargosAbonos.obtieneAplicacionCobros(dtoOid);
		dtoCargosAbonos.setAplicacionCobros(rs);
		oids = new Long[rs.getRowCount()];
		for(int i=0;i<rs.getRowCount();i++){
			oids[i] = new Long(((BigDecimal)rs.getValueAt(i,"CMBA_OID_MOVI_BANC")).toString());
		}
		if(oids.length > 0){
			dtoOids.setOids(oids);
			try{
				if (!monCuentasCorrientes.bloquearMovBanc(dtoOids).booleanValue()) {
				throw new MareException(new Exception(),
						UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
						ErroresDeNegocio.CCC_0044));
				}	
			}catch(RemoteException re){
				String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
				this.logearError("obtener: RemoteException",re);
				throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
			}
		}

		//Conceptos Gastos Abonos
        
        UtilidadesLog.debug("entra a daoCargosAbonos.obtieneConceptosGastosAbonos(");
		dtoCargosAbonos.setConceptosGastosAbonos(daoCargosAbonos.obtieneConceptosGastosAbonos(dtoOid));
        UtilidadesLog.debug("dtoCargosAbonos " + dtoCargosAbonos);

		//Generacion Vencimientos
		rs = null;
		rs = daoCargosAbonos.obtieneGeneracionVencimientos(dtoOid);
		dtoCargosAbonos.setGeneracionVencimientos(rs);
		oids = new Long[rs.getRowCount()];
		for(int i=0;i<rs.getRowCount();i++){
			oids[i] = new Long(((BigDecimal)rs.getValueAt(i,"OID_MOVI_CC")).toString());
		}
		if(oids.length > 0){
			dtoOids.setOids(oids);
			try{
				if ( !monCuentasCorrientes.bloquearMovCC(dtoOids).booleanValue()) {
					throw new MareException(new Exception(),
							UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
							ErroresDeNegocio.CCC_0044));
				}
			}catch(RemoteException re){
				String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
				this.logearError("obtener: RemoteException",re);
				throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
			}
		}
		
		UtilidadesLog.info("MONCargosAbonosBean.obtener(DTOObtenerCargosAbonos dto): Salida");
		return dtoCargosAbonos;
	}

	protected void eliminarDetalles(Long cabecera) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.eliminarDetalles(Long cabecera): Entrada");
		/*0 oid de detalle,
		 *1 movimiento, 
		 *2 numeroHistoriaGenera, 
		 *3 movimientoBancario,  
		 *4 codigo de subproceso*/

		DAOCargosAbonos daoCargosAbonos=new DAOCargosAbonos(ctx.getCallerPrincipal().getName());
		RecordSet subProcesos=daoCargosAbonos.obtenerDetallesCargoAbono(cabecera);
		MONCuentasCorrientes monCuentasCorrientes=this.getMONCuentasCorrientes();
		MovimientosCuentasCorrientesLocalHome movimientosCCC=this.getMovimientosCuentasCorrientesLocalHome();
		DetalleCargosAbonosDirectosLocalHome detalleAbonosDirectos=this.getDetalleCargosAbonosDirectosLocalHome();
		MovimientosBancariosLocalHome movimientosBancariosHome=this.getMovimientosBancariosLocalHome();
		try{
			for(int i=0;i<subProcesos.getRowCount();i++){
				Long movimiento=null;
				Integer numeroHistoriaGenera=null;
				Long movimientoBancario=null;
				if(subProcesos.getValueAt(i,3)!=null){
					movimientoBancario=new Long(subProcesos.getValueAt(i,3).toString());
				}
				if(subProcesos.getValueAt(i,2)!=null){
					numeroHistoriaGenera=new Integer(subProcesos.getValueAt(i,2).toString());
				}
				if(subProcesos.getValueAt(i,1)!=null){
					movimiento=new Long(subProcesos.getValueAt(i,1).toString());
				}			
				Long oidDetalle=new Long(subProcesos.getValueAt(i,0).toString());
				DetalleCargosAbonosDirectosLocal detalle = detalleAbonosDirectos.findByPrimaryKey(oidDetalle);
				detalleAbonosDirectos.remove(detalle);
				if(CCCConstantes.CANCELACION_CUOTAS.equals(subProcesos.getValueAt(i,4).toString())){
					if(movimiento!=null&&numeroHistoriaGenera!=null){
						//Incidencia 7775. Valores a introducir en el DTO
						//Error(1009,28): method retrocesoCuenta(java.lang.Long, java.lang.Integer) not found in interface es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientes
						DTOMovimientoCuentaCompleto dtoMovimiento = new DTOMovimientoCuentaCompleto();
						dtoMovimiento.setOid(movimiento);
						dtoMovimiento.setUltimoNumeroHistoria(numeroHistoriaGenera);
						monCuentasCorrientes.retrocesoCuenta(dtoMovimiento);
					}
				}
				if(CCCConstantes.GENERACION_VENCIMIENTOS.equals(subProcesos.getValueAt(i,4).toString())){
					if(movimiento!=null){
						MovimientosCuentasCorrientesLocal movimientosCCCLocal = movimientosCCC.findByPrimaryKey(movimiento);
						movimientosCCCLocal.remove();
					}
				}
				if(CCCConstantes.APLICACION_COBROS.equals(subProcesos.getValueAt(i,4).toString())){
					if(movimientoBancario!=null){
						//Añadido por incidencia BELC300009139
						MovimientosBancariosLocal movimientosBancarios = movimientosBancariosHome.findByPrimaryKey(movimientoBancario);
						//******************Fin Añadido****************
						DTOMovimientoBancario dto = new DTOMovimientoBancario();
						dto.setOid(movimientosBancarios.getOid());
						dto.setOidPais(movimientosBancarios.getPais());
						dto.setEmpresa(movimientosBancarios.getEmpresa());
						monCuentasCorrientes.retrocesoMovBancario(dto);
					}
				}			
			}
		}catch(RemoteException e){
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("eliminarDetalles: RemoteException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
		}catch(RemoveException e){
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logearError("eliminarDetalles: RemoveException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
		}catch(NoResultException e){
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			this.logearError("eliminarDetalles: FinderException",e);
			UtilidadesLog.debug("eliminarDetalles: FinderException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
		}catch(FinderException e){
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			this.logearError("eliminarDetalles: FinderException",e);
			UtilidadesLog.debug("eliminarDetalles: FinderException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
		} catch(PersistenceException e){
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logearError("eliminarDetalles: RemoveException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
		} catch (EJBException ejbe) {
                //acceso gen-002			
                UtilidadesLog.error(ejbe);
                ctx.setRollbackOnly();
				String falloSQL = (ejbe.getCausedByException()).getMessage();
				if (falloSQL.indexOf("ORA-02292") != -1) {
					this.logearError("eliminarDetalles: EJBException",ejbe);	  						
					UtilidadesLog.debug("eliminarDetalles: ORA-02292",ejbe);	  						
					String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
					throw new MareException(ejbe, UtilidadesError.armarCodigoError(codigoError));
				} else {
					String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
					this.logearError("eliminarDetalles: EJBException",ejbe);	  										
					UtilidadesLog.debug("eliminarDetalles: no ORA-02292",ejbe);	  						
					throw new MareException(ejbe, UtilidadesError.armarCodigoError(codigoError));
				}				
            }
		UtilidadesLog.info("MONCargosAbonosBean.eliminarDetalles(Long cabecera): Salida");
	}

	protected short conceptosGastosAbonos(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametrosIn) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.conceptosGastosAbonos(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametrosIn): Entrada");
		UtilidadesLog.debug("****RecordSet"+ movimientos);
		int numeroFilas=movimientos.getRowCount();
		DTOOID dtoDivisa = null;
		Long oidDivisa = null;
		
		if(movimientos==null||movimientos.esVacio()||numeroFilas==0){
			return numDetalle;			
		}
		//Columnas del RecordSet Movimientos.
		/* 0 codigocliente,
		 * 1 cuentaCorrienteDesc, 
		 * 2 glosaContable, 
		 * 3 fechaPago, 
		 * 4 importe, 
		 * 5 divisa, 
		 * 6 importeDivisa, 
		 * 7 cuentaCorrienteoid, 
		 * 8 divisaOid,
		 * tipoAbonoOid
		 * 9 oidDetalle*/
		 //Nuevo
		//Validamos la divisa 
		try{
			MONMantenimientoSEG local = this.getMONMantenimientoSEG();
	
			for(int i = 0; i < numeroFilas; i++){
				parametrosIn.setTipoAbono(new Long(movimientos.getValueAt(i,"tipoAbonoOid").toString()));
				//Obtenemos el resto de parámetros del subproceso para cada fila
				DTOParametrosSubproceso parametros = this.obtenerRestoParametrosSubproceso(parametrosIn);
				//Validamos la divisa 
				oidDivisa = null;
				if (movimientos.getValueAt(i, "divisa") != null && movimientos.getValueAt(i, "divisa").toString().trim().length()>0) {
					dtoDivisa = local.obtenerOIDMonedaAltPais(parametros.getOidPais(), (String)movimientos.getValueAt(i, "divisa").toString()); //incidencia BELC300009456
					//(La interfaz es interfaces.ISEG.obtenerOIDMonedaAltPais(pais, divisa) ) 
					if (dtoDivisa == null || dtoDivisa.getOid() == null) {
						//throw new MareException("CCC-0046") //El codigo de Divisa no es válido para el país actual
						ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.CCC_0046));
						excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
						excepcionParam.addParameter(" "+(String)movimientos.getValueAt(i, "divisa"));
						throw excepcionParam; 
					} else oidDivisa = dtoDivisa.getOid();
				}

				DTODetalleCargosAbonos dtoDetalle=new DTODetalleCargosAbonos();
				if (movimientos.getValueAt(i,"importe") != null && movimientos.getValueAt(i, "importe").toString().trim().length()>0)
					dtoDetalle.setImporte(new Double((movimientos.getValueAt(i,"importe")).toString()));
				if (movimientos.getValueAt(i,"importeDivisa")!=null && movimientos.getValueAt(i, "importeDivisa").toString().trim().length()>0){
					dtoDetalle.setImporteMoneda(new Double((movimientos.getValueAt(i,"importeDivisa")).toString()));
				}else{
					dtoDetalle.setImporteMoneda(null);
				}
				dtoDetalle.setMoneda(oidDivisa);
				dtoDetalle.setFechaMovimiento(cabecera.getFechaDocumento());
				if (movimientos.getValueAt(i,"glosaContable") != null && movimientos.getValueAt(i, "glosaContable").toString().trim().length()>0)
					dtoDetalle.setGlosaContable((String)movimientos.getValueAt(i,"glosaContable").toString());
				dtoDetalle.setCabecera(cabecera.getOid());
				dtoDetalle.setNumLinea(new Integer(numDetalle));
				dtoDetalle.setSubproceso(parametros.getSubproceso());
				MONClientes monClientes=this.getIMaestroClientes();
				if(movimientos.getValueAt(i,"codigoCliente")!=null && movimientos.getValueAt(i, "codigoCliente").toString().trim().length()>0){
					UtilidadesLog.debug("****hay codigo cliente");
					dtoDetalle.setConsultora(monClientes.obtenerOidCliente(parametros.getOidPais(),movimientos.getValueAt(i,"codigoCliente").toString()));			
				}else{
					dtoDetalle.setConsultora(null);
				}
				UtilidadesLog.debug("****insertar tipo abono");
			
				dtoDetalle.setTipoAbono(parametros.getTipoAbonoSubproceso());
				UtilidadesLog.debug("****insertar cuenta anterior");
				dtoDetalle.setCuotaAnterior(parametros.getCuenta());
				UtilidadesLog.debug("****insertar cuenta nueva");
				dtoDetalle.setCuotaNueva(parametros.getCuenta());
				if(movimientos.getValueAt(i,"cuentaCorrienteoid")!=null && movimientos.getValueAt(i, "cuentaCorrienteoid").toString().trim().length()>0){
					UtilidadesLog.debug("****hay cuenta corriente");
					dtoDetalle.setCuentaCorriente(new Long((movimientos.getValueAt(i,"cuentaCorrienteoid")).toString()));
				}
				UtilidadesLog.debug("****insertar empresa");
				dtoDetalle.setEmpresa(cabecera.getEmpresa());
				UtilidadesLog.debug("****llamada guardar detalle");
                
                UtilidadesLog.debug("DTODetalle: "+dtoDetalle);
                
				this.guardarDetalle(dtoDetalle);

				numDetalle++;
			
			}
		}catch(RemoteException e){
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("conceptosGastosAbonos: RemoteException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
		}
		UtilidadesLog.info("MONCargosAbonosBean.conceptosGastosAbonos(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametrosIn): Salida");
		return numDetalle;
	}

	protected short aplicacionCobros(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros) throws MareException {
		/*
                  0 "codigoCliente"
                  1 "cuentaCorrienteDesc"
                  2 "fechaPago"
                  3 "numeroLote"
                  4 "consecutivoTransaccion"
                  5 "importePago"
                  6 "importePendiente"
                  7 "importeAplicar"
                  8 "cuentaCorrienteoid"
                  9 "oidMovimiento"
                 10 "oidDetalle"
		*/ 
		UtilidadesLog.info("MONCargosAbonosBean.aplicacionCobros(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros): Entrada");
		if(parametros==null){
			return numDetalle;
		}
		int numeroMovimientos=movimientos.getRowCount();
		MONClientes monClientes=this.getIMaestroClientes();		
		
		for (int i = 0; i < numeroMovimientos; i++){
			try {
				MovimientosBancariosLocal movimientosBancarios = null;
				try{
					MovimientosBancariosLocalHome movimientosBancariosLocalHome = this.getMovimientosBancariosLocalHome();
					BigDecimal oidMovimientoBig=new BigDecimal(movimientos.getValueAt(i, "OID").toString());				
					//findByPrimaryKey del atributo MovimientosBancarios con el oidMovimiento de la fila
					movimientosBancarios = movimientosBancariosLocalHome.findByPrimaryKey(new Long(oidMovimientoBig.longValue()));				
				} catch(FinderException e) {
					ctx.setRollbackOnly();
					String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
					this.logearError("aplicacionCobros mov banc: FinderException",e);
					throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    				
				}
					//Copiar todos los atributos del entity en un DTOMovimientoBancario.
					DTOMovimientoBancario dtoMovimientoBancario = new DTOMovimientoBancario();
					dtoMovimientoBancario.setAnioDocumentoAplicacion(movimientosBancarios.getDocumentoAplicacionAnyo());
					dtoMovimientoBancario.setAnioDocumentoCreacion(movimientosBancarios.getDocumentoCreacionAnyo());
					dtoMovimientoBancario.setCodConsultoraReal(movimientosBancarios.getCodigoConsultora());
					dtoMovimientoBancario.setCodError(movimientosBancarios.getCodigoError());
					dtoMovimientoBancario.setConsecutivoTransaccion(movimientosBancarios.getConsecutivoTransaccion());
					dtoMovimientoBancario.setCuentaCorrienteBancaria(movimientosBancarios.getCuentaCorriente());
					dtoMovimientoBancario.setDigitoChequeo(movimientosBancarios.getDigitoChequeoFactura());
					dtoMovimientoBancario.setEmpresa(movimientosBancarios.getEmpresa());
					dtoMovimientoBancario.setImporteAplicado(movimientosBancarios.getImporteAplicado());
					dtoMovimientoBancario.setImportePago(movimientosBancarios.getImportePago());
					dtoMovimientoBancario.setImporteSaldo(movimientosBancarios.getSaldoPendiente());
					dtoMovimientoBancario.setEstatusMovimientoTesoreria(new Character(movimientosBancarios.getEstatusMovimientoPendienteAplicado().charAt(0)));
					dtoMovimientoBancario.setFechaContabilizacion(movimientosBancarios.getFechaContabilizacion());
					dtoMovimientoBancario.setFechaPago(movimientosBancarios.getFechaPago());
					dtoMovimientoBancario.setHorario(movimientosBancarios.getHorarioNormalAdicional());
					dtoMovimientoBancario.setIdentificadorProceso(movimientosBancarios.getIdentificadorProceso());
					dtoMovimientoBancario.setNombreOficina(movimientosBancarios.getNombreOficina());
					dtoMovimientoBancario.setNumeroCupon(movimientosBancarios.getNumeroCupon());
					dtoMovimientoBancario.setNumeroDocumentoAplicacion(movimientosBancarios.getDocumentoAplicacionNumero());
					dtoMovimientoBancario.setNumeroFactura(movimientosBancarios.getNumeroFacturaBoleta());
					dtoMovimientoBancario.setNumeroHistoria(movimientosBancarios.getNumeroHistoria());
					dtoMovimientoBancario.setNumeroLote(movimientosBancarios.getNumeroLote());
					dtoMovimientoBancario.setNumeroLoteContabilizacion(movimientosBancarios.getNumeroLoteContabilizacion());
					dtoMovimientoBancario.setObservaciones(movimientosBancarios.getObservaciones());
					dtoMovimientoBancario.setOficinaRecaudadora(movimientosBancarios.getOficinaRecaudadora());
					dtoMovimientoBancario.setOidConsultoraReal(movimientosBancarios.getConsultoraReal());
					dtoMovimientoBancario.setSerieDocumentoAplicacion(movimientosBancarios.getDocumentoAplicacionMesSerie());
					dtoMovimientoBancario.setSerieDocumentoCreacion(movimientosBancarios.getDocumentoCreacionMesSerie());
					dtoMovimientoBancario.setNumeroDocumentoCreacion(movimientosBancarios.getDocumentoCreacionNumero());
					dtoMovimientoBancario.setSubacceso(movimientosBancarios.getSubacceso());
					dtoMovimientoBancario.setTipoTransaccion(movimientosBancarios.getTipoTransaccion());
					dtoMovimientoBancario.setUsuarioProceso(movimientosBancarios.getUsuarioProceso());
					dtoMovimientoBancario.setOidPais(movimientosBancarios.getPais());
					dtoMovimientoBancario.setOid(movimientosBancarios.getOid());
					dtoMovimientoBancario.setAnioDocumentoAplicacion(cabecera.getAnio());
					dtoMovimientoBancario.setSerieDocumentoAplicacion(cabecera.getPeriodoMes());
					dtoMovimientoBancario.setNumeroDocumentoAplicacion(cabecera.getNumero());
					dtoMovimientoBancario.setFechaMovimientoAplicacion(new java.sql.Date(new java.util.Date().getTime())); //la fechaSistema
					dtoMovimientoBancario.setIdentificadorProceso(movimientosBancarios.getIdentificadorProceso()); //el valor de la constante del entity CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO
					dtoMovimientoBancario.setOidTipoAbonoUltimo(parametros.getTipoAbono());
					dtoMovimientoBancario.setOidSubprocesoMarcaUltimo(parametros.getSubproceso());
					dtoMovimientoBancario.setUsuarioProceso(ctx.getCallerPrincipal().getName());//usuario activo

				double auxImporteAplicar = 0;
				if (movimientos.getValueAt(i, "importeAplicar") != null && movimientos.getValueAt(i, "importeAplicar").toString().trim().length()>0){
					auxImporteAplicar = new Double(movimientos.getValueAt(i, "importeAplicar").toString()).doubleValue();
				}

				dtoMovimientoBancario.setImporteMovimiento(new BigDecimal(auxImporteAplicar)); //movimientos(i).importeAplicar

				if	(dtoMovimientoBancario.getImporteAplicado() != null )			
					dtoMovimientoBancario.setImporteAplicado(new BigDecimal(dtoMovimientoBancario.getImporteAplicado().doubleValue() + auxImporteAplicar));
				else
					dtoMovimientoBancario.setImporteAplicado(new BigDecimal(auxImporteAplicar));
				double auxImporte = 0;
				if (movimientos.getValueAt(i, "importePendiente") != null && movimientos.getValueAt(i, "importePendiente").toString().trim().length()>0) {
					auxImporte = new Double(movimientos.getValueAt(i, "importePendiente").toString()).doubleValue();
				}
						
				dtoMovimientoBancario.setImporteSaldo( new BigDecimal(dtoMovimientoBancario.getImportePago().doubleValue() - dtoMovimientoBancario.getImporteAplicado().doubleValue()));

				if ( dtoMovimientoBancario.getImporteAplicado().doubleValue() == dtoMovimientoBancario.getImportePago().doubleValue() )
					dtoMovimientoBancario.setEstatusMovimientoTesoreria(new Character(CCCConstantes.MOVIMIENTO_BANCARIO_APLICADO.charAt(0))); // ponemos el valor de la constante del entity

				dtoMovimientoBancario.setAnioDocumentoAplicacion(cabecera.getAnio());
				dtoMovimientoBancario.setSerieDocumentoAplicacion(cabecera.getPeriodoMes());
				dtoMovimientoBancario.setNumeroDocumentoAplicacion(cabecera.getNumero());
				dtoMovimientoBancario.setFechaMovimientoAplicacion(new Date(System.currentTimeMillis()));
				dtoMovimientoBancario.setIdentificadorProceso(movimientosBancarios.getIdentificadorProceso());

				MONCuentasCorrientes monCuentasCorrientes = this.getMONCuentasCorrientes();
                
                UtilidadesLog.debug("dtoMovimientoBancario: "+dtoMovimientoBancario);
                
				monCuentasCorrientes.actualizarMovBancario(dtoMovimientoBancario);

				//Creamos el detalle
					DTODetalleCargosAbonos dtoDetalleCargosAbonos=new DTODetalleCargosAbonos();
					if(movimientos.getValueAt(i, "importeAplicar")!=null  && movimientos.getValueAt(i, "importeAplicar").toString().trim().length()>0){
						dtoDetalleCargosAbonos.setImporte(new Double(movimientos.getValueAt(i, "importeAplicar").toString())); 
					}
                    
					if(movimientos.getValueAt(i, 0)!=null){
						dtoDetalleCargosAbonos.setConsultora(monClientes.obtenerOidCliente(parametros.getOidPais(),movimientos.getValueAt(i, 0).toString()));	
					}
					dtoDetalleCargosAbonos.setNumHistoriaGenera(movimientosBancarios.getNumeroHistoria());
					dtoDetalleCargosAbonos.setMovimientoBancario(movimientosBancarios.getOid());
					dtoDetalleCargosAbonos.setCabecera(cabecera.getOid());
					dtoDetalleCargosAbonos.setNumLinea(new Integer(numDetalle)); 
					dtoDetalleCargosAbonos.setSubproceso(parametros.getSubproceso());
					dtoDetalleCargosAbonos.setCuotaNueva(parametros.getCuenta());
					dtoDetalleCargosAbonos.setCuotaAnterior(parametros.getCuenta());
					dtoDetalleCargosAbonos.setTipoAbono(parametros.getTipoAbonoSubproceso());			
					if(movimientos.getValueAt(i, "cuentaCorrienteoid")!=null  && movimientos.getValueAt(i, "cuentaCorrienteoid").toString().trim().length()>0){
						dtoDetalleCargosAbonos.setCuentaCorriente(new Long(movimientos.getValueAt(i, "cuentaCorrienteoid").toString()));
					}
					dtoDetalleCargosAbonos.setEmpresa(cabecera.getEmpresa());
					dtoDetalleCargosAbonos.setFechaMovimiento(cabecera.getFechaDocumento());
					UtilidadesLog.debug("dtoDetalleCargosAbonos: "+dtoDetalleCargosAbonos);
                    
					this.guardarDetalle(dtoDetalleCargosAbonos);
					numDetalle++;
				}/*catch(FinderException e){
					String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
					this.logearError("aplicacionCobros: FinderException",e);
					throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
				}*/catch(RemoteException e){
					String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
					this.logearError("aplicacionCobros: RemoteException",e);
					throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    									
				}
				
		}
		
		UtilidadesLog.info("MONCargosAbonosBean.aplicacionCobros(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros): Salida");
		return numDetalle;
	}

	protected void guardarDetalle(DTODetalleCargosAbonos dto) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.guardarDetalle(DTODetalleCargosAbonos dto): Entrada");
		try  {
			DetalleCargosAbonosDirectosLocalHome detalle=this.getDetalleCargosAbonosDirectosLocalHome();
			/*
			 * 
			 */
			Date fechaMovimiento = null;
			if (dto.getFechaMovimiento()!=null){
				fechaMovimiento = new Date(dto.getFechaMovimiento().getTime());
			}
			BigDecimal importe = null;
			BigDecimal importeMoneda = new BigDecimal(0);
			if (dto.getImporte() != null) importe = new BigDecimal(dto.getImporte().doubleValue());
			if (dto.getImporteMoneda() != null)  importeMoneda = new BigDecimal(dto.getImporteMoneda().doubleValue());
                        detalle.create(dto.getCabecera(),//Long cabecera,
                                dto.getConsultora(),//Long consultora,
                                dto.getNumLinea(),//Integer numeroLinea,
                                dto.getNumHistoriaGenera(),//Integer numeroHistoriaGenera,
                                fechaMovimiento,//Date fechaMovimiento,
                                importeMoneda,//Double importeMoneda,
                                importe,//Double importe,
                                dto.getReferenciaNumeroDocumento(),//String referenciaNumeroDocumento,
                                dto.getObservaciones(),//String observaciones,
                                dto.getGlosaContable(),//String glosaContable,
                                dto.getMoneda(),//Long moneda,
                                dto.getMovimientoBancario(),//Long movimientoBancario,
                                dto.getMedioPago(),//Long medioPago,
                                dto.getCuotaAnterior(),//Long cuotaAnterior,
                                dto.getCuotaNueva(),//Long cuotaNueva,
                                dto.getMovimiento(),//Long movimiento,
                                dto.getCuentaCorriente(),//);//Long cuentaCorriente)
                                null, //Date fechaEnBanco
                                //dto.getCodigoUsuario(), //String CodigoUsuario
                                ctx.getCallerPrincipal().getName(),
                                dto.getEmpresa(),//Long subproceso,
                                dto.getTipoAbono()//Long tipoAbono,
                                ); 
           

		} catch (PersistenceException e)  {
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logearError("guardarDetalle: RemoteException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		} 
		
		UtilidadesLog.info("MONCargosAbonosBean.guardarDetalle(DTODetalleCargosAbonos dto): Salida");
	}

	protected short generacionVencimientos(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros, Long pais) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.generacionVencimientos(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros, Long pais): Entrada");

		try  {
		
			if(parametros==null){
				return numDetalle;
			}
			//Columnas de movimientos.
			/*
			 * 0 codigoCliente
			 * 1 marca
			 * 2 canal
			 * 3 acceso
			 * 4 subacceso
			 * 5 numeroDocumento
			 * 6 referenciaExterna
			 * 7 fechaDocumento
			 * 8 fechaVencimiento
			 * 9 medioPagoDesc
			 * 10 divisa
			 * 11 importe
			 * 12 importeDivisa
			 * 13 observaciones
			 * 14 medioPagoOid
			 * 15 marcaOid
			 * 16 canalOid
			 * 17 accesoOid
			 * 18 subaccesoOid
			 */
			 int numeroFilas=movimientos.getRowCount();
			 MONPeriodos monPeriodos=this.getMONPeriodos();
			 MONClientes monClientes=this.getIMaestroClientes();
			 MONUnidadesAdministrativas monUnidadesA=this.getMONUnidadesAdministrativas();
			 MONConfiguracionClientes monConfiguracion=this.getMONConfiguracionClientes();
			 MONMantenimientoSEG monMantenimientoSEG = this.getMONMantenimientoSEG();
			 for (int i = 0; i < numeroFilas; i++) {
  				 //this.validaAcceso( pais, cabecera.getEmpresa(), new Long((movimientos.getValueAt(i,"marcaOid")).toString()), new Long((movimientos.getValueAt(i,"canalOid")).toString()), new Long((movimientos.getValueAt(i,"accesoOid")).toString()), new Long((movimientos.getValueAt(i,"subaccesoOid")).toString()),null, null, null, null, null);

			/*
				//Generar numeroDocumento y numeroOrdenCuota
				Hacemos una consulta sobre la entidad MovimientosCuentaCorriente buscando el numeroDocumento
				(ejercicioCuota+numeroIdentificadorCuota) que el usuario ha tecleado:
				Construimos un DTONumeroDocumento con el numeroDocumento que nos llega como parámetro.*/
				 String numeroDocumento  =null;
				 String numeroDocumentoINI = null;
				 String numeroDocumentoFIN = null;
				 Integer numeroOrden = null;
				if(movimientos.getValueAt(i,"numeroDocumento") != null && movimientos.getValueAt(i,"numeroDocumento").toString().trim().length()>0) {
					numeroDocumento=movimientos.getValueAt(i,"numeroDocumento").toString(); //puede ser Bigdecimal???
                    UtilidadesLog.debug("GA - numeroDocumento: "+numeroDocumento);
					numeroDocumentoFIN = numeroDocumento.substring(2);
					numeroDocumentoINI = numeroDocumento.substring(0,2);
					DTONumeroDocumento dtoNumeroDocumento = new DTONumeroDocumento();
					dtoNumeroDocumento.setNumeroDocumento(numeroDocumento);
                    UtilidadesLog.debug("GA - dtoNumeroDocumento: "+dtoNumeroDocumento);
					DTONumeroOrden dtoOrden = (new DAOCargosAbonos(ctx.getCallerPrincipal().getName())).mayorNumeroOrden(dtoNumeroDocumento);
					numeroOrden = new Integer(dtoOrden.getNumeroOrden().intValue() + 1);
                    UtilidadesLog.debug("GA - dtoOrden: "+dtoOrden);
					/*
					 * Si el numero de documento no existe el numero de orden devuelto es -1, debemos generar un numero de docuemnto
					 * Se invoca al Caso de Uso Generar Número de
					 * documento con los parámetros: País,Canal,Acceso y Subaccesoo Operación="PED001" (correspondiente a la
					 * Operación=Solicitud de Pedido)
					 */
					if (dtoOrden.getNumeroOrden().intValue() == -1) {
						DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
						dtoNumeroSolicitud.setOidCanal(new Long((movimientos.getValueAt(i,"canalOid")).toString()));
						dtoNumeroSolicitud.setOidAcceso(new Long((movimientos.getValueAt(i,"accesoOid")).toString()));
						dtoNumeroSolicitud.setOidSubacceso(new Long((movimientos.getValueAt(i,"subaccesoOid")).toString()));
						dtoNumeroSolicitud.setOperacion(ConstantesBEL.COD_PED001); //13818
						dtoNumeroSolicitud.setOidPais(pais);
                        UtilidadesLog.debug("GA - dtoNumeroSolicitud: "+dtoNumeroSolicitud);
						MONProcesosPED monProcesos = this.getMONProcesosPED();
						numeroDocumento  = monProcesos.generaNumeroDocumento(dtoNumeroSolicitud);
                        UtilidadesLog.debug("GA - numeroDocumento generado:"+numeroDocumento);
						numeroDocumentoFIN = numeroDocumento.substring(2);
						numeroDocumentoINI = numeroDocumento.substring(0,2);
						numeroOrden = new Integer(1);
					}
				}

				//Validamos la divisa 
				Long divisa = null;
				if (movimientos.getValueAt(i,"divisa") != null && movimientos.getValueAt(i,"divisa").toString().trim().length()>0) {
                    UtilidadesLog.debug("GA - divisa: "+movimientos.getValueAt(i,"divisa").toString());
					DTOOID dtoDivisa = monMantenimientoSEG.obtenerOIDMonedaAltPais(pais, (String)movimientos.getValueAt(i,"divisa").toString()); 
					//(La interfaz es interfaces.ISEG.obtenerOIDMonedaAltPais(pais, divisa) ) 
					if (dtoDivisa == null || dtoDivisa.getOid() == null) {
						//throw new MareException("CCC-0046") //El codigo de Divisa no es válido para el país actual
						ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.CCC_0046));
						excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
						excepcionParam.addParameter(" "+(String)movimientos.getValueAt(i, "divisa"));
						throw excepcionParam; 
					} else divisa = dtoDivisa.getOid();
				}

				 DTOPeriodo periodoActual=monPeriodos.obtienePeriodoActual(pais,new Long((movimientos.getValueAt(i,"marcaOid")).toString()), new Long((movimientos.getValueAt(i,"canalOid")).toString()));
				 Date fechaSistema = new Date(System.currentTimeMillis());
				 MovimientosCuentasCorrientesLocalHome movimientosCCCHome=this.getMovimientosCuentasCorrientesLocalHome();
				 Long oidCliente=monClientes.obtenerOidCliente(parametros.getOidPais(),movimientos.getValueAt(i,0).toString());



				Long medioPago = null;
				if (movimientos.getValueAt(i,"medioPagoOid") != null && movimientos.getValueAt(i,"medioPagoOid").toString().trim().length()>0)
					medioPago = new Long((movimientos.getValueAt(i,"medioPagoOid")).toString());
				 //String digitosYear=UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"yy");
				 DTOTipoSubtipoCliente dtoTipoSubtipoCliente=monConfiguracion.obtenerTipoSubtipoCliente(oidCliente);
				 //Long subTipoCliente=dtoTipoSubtipoCliente.getTipo(); //Hacer asignacion abajo.
				 Long territorioAdministrativo=monUnidadesA.obtenerTerritorioAdministrativo(new Long((movimientos.getValueAt(i,"marcaOid")).toString()), oidCliente);
				if (territorioAdministrativo==null){
					ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
					ErroresDeNegocio.CLIENTE_NO_ASIGNADO_PARA_MARCA));
					excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
					excepcionParam.addParameter(movimientos.getValueAt(i,0).toString());	
					excepcionParam.addParameter(movimientos.getValueAt(i,1).toString());
					throw excepcionParam;
				}
				//Incidencia 7780
				String usuario = ctx.getCallerPrincipal().getName();
				BigDecimal tipoCambio = null;
				
				PaisLocalHome paisHome = this.getPaisLocalHome();
				try{
					PaisLocal local = paisHome.findByPrimaryKey(pais);
					tipoCambio = monMantenimientoSEG.obtenerTipoCambio(local.getMone_oid_mone(),local.getMone_oid_mone_alt());
					UtilidadesLog.debug("****Metodo  generacionVencimentos: tipocambio " + tipoCambio);
				}catch (NoResultException e)  {
					ctx.setRollbackOnly();
					this.logearError("*** Error en generacionVencimentos",e);
					String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
					throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
				}

        //obtiene el tipo de periodo segun el canal
        if (oidTipoPeriodo == null) {
            DAOCCC daoCCC = new DAOCCC();
            oidTipoPeriodo = daoCCC.obtenerTipoPeriodo(new Long((movimientos.getValueAt(i,"canalOid")).toString()));
        }

        // obtiene la unidad administrativa
				DTOUnidadAdministrativa dtoUnidad = monClientes.obtenerUnidadAdministrativa(oidCliente,periodoActual.getOid());
        
        // 24150 - dmorello, 05/09/2006
        // El cliente no puede interactuar con CCC si no tiene UA
        if (dtoUnidad == null) {
            throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_066));
        }
				

        UtilidadesLog.debug("****Metodo  generacionVencimentos: dtoUnidad " );
        UtilidadesLog.debug("**** tipoCambio: " + tipoCambio);
        if(tipoCambio == null) {
          tipoCambio = new BigDecimal(1);
          UtilidadesLog.debug("**** tipoCambio: " + tipoCambio);
        }        
        
            UtilidadesLog.debug("-GA- fecha documento: "+cabecera.getFechaDocumento());
            UtilidadesLog.debug("-GA- fecha valor: "+fechaFormateada(movimientos.getValueAt(i,"fechaDocumento").toString()));
            UtilidadesLog.debug("-GA- fecha vencimiento: "+fechaFormateada(movimientos.getValueAt(i,"fechaVencimiento").toString()));
				MovimientosCuentasCorrientesLocal movimientosCCC=movimientosCCCHome.create(
				 	    /*1 Long empresa,*/cabecera.getEmpresa(),
						/*2 Long marcaSituacion,*/parametros.getMarcaSituacion(),
						/*3 Long divisa,*/divisa,
						/*4 Long periodoDesde,*/periodoActual.getOid(),
						/*5 Long tipoAbonoUltimo,*/parametros.getTipoAbono(),
						/*6 Long tipoAbonoCreacion,*/parametros.getTipoAbono(),
						/*7 Long subacceso,*/new Long((movimientos.getValueAt(i,"subaccesoOid")).toString()),
						/*8 Long subprocesoUltimo,*/parametros.getSubproceso(),
						/*9 Long subprocesoDeCreacion,*/parametros.getSubproceso(),
						/*10 Long cuentaOrigen,*/parametros.getCuenta(),
						/*11 Long cuentaCuota,*/parametros.getCuenta(),
						/*12 Long cliente,*/oidCliente, 
						/*13 String documentoAnyo,*/cabecera.getAnio(),
						/*14 String documentoMesSerie,*/cabecera.getPeriodoMes(),
						/*15 Integer documentoNumero,*/cabecera.getNumero(),
						/*16 String ejercicioCuota,*/numeroDocumentoINI,
						/*17 Date fechaContabilizacion,*/null, 
						/*18 Timestamp fechaDocumento,*/new Timestamp(fechaSistema.getTime()),
						/*19 Timestamp fechaUltimoMovimiento,*/new Timestamp(cabecera.getFechaDocumento().getTime()),
						/*20 Timestamp fechaValor,*/ new Timestamp(fechaFormateada(movimientos.getValueAt(i,"fechaDocumento").toString()).getTime()),
						/*21 Date fechaVencimiento,*/new java.sql.Date(fechaFormateada(movimientos.getValueAt(i,"fechaVencimiento").toString()).getTime()),
						/*22 Double importe,*/new Double((movimientos.getValueAt(i,"importe")).toString()),
						/*23 Double importeDivisa,*/new Double(0),
						/*24 Double importePagado,*/new Double(0),
						/*25 Double impPagadoDivisa,*/new Double(0),
						/*26 Double importePendiente,*/new Double((movimientos.getValueAt(i,"importe")).toString()),
						/*27 Boolean indicaDtoRecargo,*/null,
						/*28 Integer numeroIdentificadorCuota,*/new Integer(numeroDocumentoFIN),
						/*29 String numLoteContab,*/null,
						/*30 Integer numeroOrdenCuota,*/numeroOrden,
						/*31 String numeroSerieCuota,numeroDocumentoA, Eliminado por incidencia 7548*/
						/*32 String observaciones,*/movimientos.getValueAt(i,"observaciones").toString(),
						/*33 String referenciaNumeroDocumentoExterno,*/movimientos.getValueAt(i,"referenciaExterna").toString(),
						/*34 String ultimoDocumentoAnyo,*/cabecera.getAnio(),
						/*35 String ultimoDocumentoMesSerie,*/cabecera.getPeriodoMes(),
						/*36 Integer ultimoDocumentoNumero,*/cabecera.getNumero(),
						/*37 Integer ultimoNumeroHistoria,*/new Integer(0),
						/*38 Long medioPago,*/medioPago,
						/*39 Long TerritorioAdministrativo,*/territorioAdministrativo,
						/*40 Long pais,pais, Eliminado por modificaciones-> P0020 i2*/						
						/*41 Long tipoCliente,*/dtoTipoSubtipoCliente.getTipo(),
						/*42 Long marca */new Long((movimientos.getValueAt(i,"marcaOid")).toString()),
						/*43 BigDecimal tipoCambio*/tipoCambio,
						/*44 String codigoUsuario*/usuario,
						/*45 Long subtipoCliente*/dtoTipoSubtipoCliente.getSubtipo(),
						/*46 Long sugerencia*/dtoUnidad.getOidSGV(),
						/*47 Long seccion*/dtoUnidad.getOidSeccion(),
						/*48 Integer numeroLoteFacturacion*/null,
						/*49 BigDecimal importePago*/new BigDecimal(0),
						/*50 BigDecimal importePagoDivisa*/new BigDecimal(0),
						/*51 BigDecimal importeMovimientoDivisa*/new BigDecimal(0),
						/*52 Long tipoPeriodo*/oidTipoPeriodo,
						/*53 Long tipoDocumentoLegal*/null,
						/*54 Long tipoSolicitud*/null,
						/*55 Long region*/dtoUnidad.getOidRegion(),
						/*56 Long consolidado*/null,
            /*DBLG700000176 20/10/2006 mdolce*/
						/*57 BigDecimal importeMovimiento*/new BigDecimal((movimientos.getValueAt(i,"importe")).toString())
						);	
						UtilidadesLog.debug("****Después del create ");
						DTODetalleCargosAbonos detalleCargos=new DTODetalleCargosAbonos();
						//Error(1304,35): variable movimientosCCC not found in class es.indra.sicc.logicanegocio.ccc.MONCargosAbonosBean
						detalleCargos.setMovimiento(movimientosCCC.getOid());
						detalleCargos.setImporte(new Double((movimientos.getValueAt(i,"importe")).toString()));
						if(movimientos.getValueAt(i,"importeDivisa")!=null && movimientos.getValueAt(i,"importeDivisa").toString().trim().length()>0){
							detalleCargos.setImporteMoneda(new Double((movimientos.getValueAt(i,"importeDivisa")).toString()));
						}
						detalleCargos.setMoneda(divisa);
						detalleCargos.setConsultora(oidCliente); 
						detalleCargos.setNumHistoriaGenera(new Integer(0));
						detalleCargos.setFechaMovimiento(cabecera.getFechaDocumento());
						detalleCargos.setCabecera(cabecera.getOid());
						detalleCargos.setNumLinea(new Integer(numDetalle));
						detalleCargos.setSubproceso(parametros.getSubproceso());
						detalleCargos.setCuotaNueva(parametros.getCuenta());
						detalleCargos.setCuotaAnterior(parametros.getCuenta());
						detalleCargos.setTipoAbono(parametros.getTipoAbonoSubproceso());
						detalleCargos.setEmpresa(cabecera.getEmpresa());
						UtilidadesLog.debug("****Antes de llamar al guardarDetalle ");
                        UtilidadesLog.debug("detalleCargos: "+detalleCargos);
						this.guardarDetalle(detalleCargos);
						numDetalle++;
			 }
				
			
		}//Error(1328,5): exception javax.ejb.DuplicateKeyException is never thrown in the corresponding try block
		//Error(1333,6): exception javax.ejb.CreateException is never thrown in the corresponding try block
		 catch (DuplicateKeyException de) {
			//clave duplicada GEN-0001
			this.logearError("generacionVencimentos: DuplicateKeyException" ,de);
			String codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
			throw new MareException(de, UtilidadesError.armarCodigoError(codigoError));
		}  catch (CreateException e)  {
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logearError("generacionVencimentos: CreateException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		} catch (ParseException e)  {
			String codigoError = CodigosError.ERROR_PARAMETROS_INCORRECTOS;
			this.logearError("generacionVencimentos: ParseException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		}catch (RemoteException e)  {
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("generacionVencimentos: RemoteException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 	       
    }catch (Exception e) {
        e.printStackTrace();
        if (e instanceof MareException) {
            throw (MareException)e;
        } else {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            this.logearError("Se capturo una Exception",e);
            //e.printStackTrace();            
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
		}
		
		UtilidadesLog.info("MONCargosAbonosBean.generacionVencimientos(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros, Long pais): Salida");
		return numDetalle;
	}


	protected void eliminarCargoAbono(Long oid) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.eliminarCargoAbono(Long oid): Entrada");
		try{			
			this.eliminarDetalles(oid);
			CabeceraCargosAbonosDirectosLocalHome cabeceraCargos=this.getCabeceraCargosAbonosDirectosLocalHome();
                        CabeceraCargosAbonosDirectosLocal cabe = cabeceraCargos.findByPrimaryKey(oid);
			cabeceraCargos.remove(cabe);
		} catch (NoResultException e)  {
                        ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("eliminarCargoAbono: RemoveException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		} catch (PersistenceException e)  {
                        ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("eliminarCargoAbono: RemoveException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		}  		
		UtilidadesLog.info("MONCargosAbonosBean.eliminarCargoAbono(Long oid): Salida");
	}

	public short cancelacionCuotas(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros, DTOCargosAbonos dtoCargosAbonos) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.cancelacionCuotas(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros): Entrada");
		
		if(movimientos==null||movimientos.esVacio()||movimientos.getRowCount()==0){
			return numDetalle;
		}
		MONCuentasCorrientes monCCC=this.getMONCuentasCorrientes();
		MovimientosCuentasCorrientesLocalHome movimientosCCC=this.getMovimientosCuentasCorrientesLocalHome();
		MONClientes monClientes=this.getIMaestroClientes();
		MONMantenimientoSEG monMantenimientoSEG = this.getMONMantenimientoSEG();

		try{
			for(int i=0;i<movimientos.getRowCount();i++){
				UtilidadesLog.debug("oidMovimientoCtaCte: " + movimientos.getValueAt(i, "OID").toString());
        UtilidadesLog.debug("parametros: " + parametros);
        UtilidadesLog.debug("importeAplicar: " + movimientos.getValueAt(i,"importeAplicar" ).toString());
        UtilidadesLog.debug("fechaValor: " + dtoCargosAbonos.getFechaValor());
        MovimientosCuentasCorrientesLocal movimientosCCCLocal = movimientosCCC.findByPrimaryKey(new Long(movimientos.getValueAt(i, "OID").toString()));
				DTOMovimientoCuentaCompleto dtoMovimiento=new DTOMovimientoCuentaCompleto();
				dtoMovimiento.setOidCliente(movimientosCCCLocal.getCliente());
				dtoMovimiento.setCuentaOrigen(movimientosCCCLocal.getCuentaOrigen());
				dtoMovimiento.setDivisa(movimientosCCCLocal.getDivisa());
				dtoMovimiento.setDocumentoAnyo(movimientosCCCLocal.getDocumentoAnyo());
				dtoMovimiento.setDocumentoMesSerie(movimientosCCCLocal.getDocumentoMesSerie());
				dtoMovimiento.setDocumentoNumero(movimientosCCCLocal.getDocumentoNumero());
				dtoMovimiento.setEjercicioCuota(movimientosCCCLocal.getEjercicioCuota());
				dtoMovimiento.setEmpresa(movimientosCCCLocal.getEmpresa());
				dtoMovimiento.setFechaContabilizacion(movimientosCCCLocal.getFechaContabilizacion());
				dtoMovimiento.setTipoCambio(movimientosCCCLocal.getTipoCambio());
				dtoMovimiento.setUsuario(movimientosCCCLocal.getCodigoUsuario());
				dtoMovimiento.setOidSubtipoCliente(movimientosCCCLocal.getSubtipoCliente());
				dtoMovimiento.setOidSugerenciaVenta(movimientosCCCLocal.getSugerencia());
				dtoMovimiento.setOidSeccion(movimientosCCCLocal.getSeccion());
				dtoMovimiento.setOidRegion(movimientosCCCLocal.getRegion());
        dtoMovimiento.setFechaDocumento(new Date(movimientosCCCLocal.getFechaDocumento().getTime()));
        dtoMovimiento.setFechaUltimoMovimiento(new Timestamp(System.currentTimeMillis()));
				dtoMovimiento.setFechaVencimiento(movimientosCCCLocal.getFechaVencimiento());
        dtoMovimiento.setFechaValor(dtoCargosAbonos.getFechaValor());

        /* actualizacion de importes gdm */
				//importe --> IMP_MOVI --> importe incial de la deuda
        dtoMovimiento.setImporte(movimientosCCCLocal.getImporte());
        // importeMovimiento --> IMP_MOVI_CUEN --> importe del movimiento actual
        dtoMovimiento.setImporteMovimiento(new BigDecimal(movimientos.getValueAt(i,"importeAplicar").toString()));
        // importePagado --> IMP_PAGA --> importe pagado acumulado (importePagado anterior + importePago)
        // seteo el importePago y luego se realiza el acumulado en actualizarCuenta()
				dtoMovimiento.setImportePagado(new Double(movimientos.getValueAt(i,"importeAplicar").toString()));
				// importePendiente --> IMP_PEND --> (importePendiete = importe - importePagado)
        double importePagado = (movimientosCCCLocal.getImportePagado().doubleValue() + dtoMovimiento.getImportePagado().doubleValue());
        dtoMovimiento.setImportePendiente(new Double(dtoMovimiento.getImporte().doubleValue() - importePagado ));
        // segun el indicador de actualiza cuota, se modifica el importePago y la marca de situacion				
        if (parametros.getIndActualizaCuota()) {
            // importePago --> IMP_PAGO --> importe del movimiento actual
            dtoMovimiento.setImportePago(new BigDecimal(movimientos.getValueAt(i, "importeAplicar").toString()));
            // segun el importe pendiente cambia la marca de situacion
            if(dtoMovimiento.getImportePendiente().doubleValue() == 0){
               dtoMovimiento.setMarcaSituacion(parametros.getMarcaSituacion()); 
            }else{
                dtoMovimiento.setMarcaSituacion(movimientosCCCLocal.getMarcaSituacion());
            }
        } else {
            // importePago --> IMP_PAGO --> importe cero
            dtoMovimiento.setImportePago(new BigDecimal(0));
            dtoMovimiento.setMarcaSituacion(parametros.getMarcaSituacion()); 
        }
        // importes divisa
        dtoMovimiento.setImportePagadoDivisa(movimientosCCCLocal.getImportePagadoDivisa());
        if (movimientos.getValueAt(i, "importeDivisa")!=null && !movimientos.getValueAt(i, "importeDivisa").toString().equals("")){
            dtoMovimiento.setImporteDivisa(new Double(movimientos.getValueAt(i, "importeDivisa").toString()));
        }else {
            dtoMovimiento.setImporteDivisa(new Double("0"));
        }
        dtoMovimiento.setImporteMovimientoDivisa(movimientosCCCLocal.getImporteMovimientoDivisa());
        /* actualizacion de importes gdm */
        dtoMovimiento.setIndicaDescuentoRecargo(movimientosCCCLocal.getIndicaDescuentoRecargo());
				dtoMovimiento.setMarca(movimientosCCCLocal.getMarca());
				dtoMovimiento.setMedioPago(movimientosCCCLocal.getMedioPago());
				dtoMovimiento.setNumeroIdentificadorCuota(movimientosCCCLocal.getNumeroIdentificadorCuota());
				dtoMovimiento.setNumeroLoteContabilizacion(movimientosCCCLocal.getNumeroLoteContabilizacion());
				dtoMovimiento.setNumeroOrdenCuota(movimientosCCCLocal.getNumeroOrdenCuota());
				dtoMovimiento.setObservaciones(movimientosCCCLocal.getObservaciones());
				dtoMovimiento.setOid(movimientosCCCLocal.getOid());
        dtoMovimiento.setOidPais(parametros.getOidPais());
        dtoMovimiento.setOidIdioma(parametros.getOidIdioma());
        dtoMovimiento.setPeriodoDesde(movimientosCCCLocal.getPeriodoDesde());
				dtoMovimiento.setReferenciaNumeroDocumentoExterno(movimientosCCCLocal.getReferenciaNumeroDocumentoExterno());
				dtoMovimiento.setSubacceso(movimientosCCCLocal.getSubacceso());
				dtoMovimiento.setSubprocesoCreacion(movimientosCCCLocal.getSubprocesoDeCreacion());
				dtoMovimiento.setSubprocesoUltimo(movimientosCCCLocal.getSubprocesoUltimo());
				dtoMovimiento.setTerritorioAdministrativo(movimientosCCCLocal.getTerritorioAdministrativo());
				dtoMovimiento.setTipoAbonoCreacion(movimientosCCCLocal.getTipoAbonoCreacion());
        dtoMovimiento.setOidTipoDocumentoLegal(movimientosCCCLocal.getTipoDocumentoLegal());
        dtoMovimiento.setTipoPeriodoDesde(movimientosCCCLocal.getTipoPeriodo());
        dtoMovimiento.setOidTipoSolicitud(movimientosCCCLocal.getTipoSolicitud());
        dtoMovimiento.setNumeroLoteFactu(movimientosCCCLocal.getNumeroLoteFacturacion());
				dtoMovimiento.setTipoCliente(movimientosCCCLocal.getTipoCliente());
				dtoMovimiento.setUltimoNumeroHistoria(movimientosCCCLocal.getUltimoNumeroHistoria());
				if (dtoMovimiento.getUltimoNumeroHistoria()!=null){
    				dtoMovimiento.setUltimoNumeroHistoria(new Integer(dtoMovimiento.getUltimoNumeroHistoria().intValue()+1));
				}else{
  					dtoMovimiento.setUltimoNumeroHistoria(new Integer(0));
				}
        dtoMovimiento.setUltimoDocumentoNumero(cabecera.getNumero());
        dtoMovimiento.setUltimoDocumentoMesSerie(cabecera.getPeriodoMes());
        dtoMovimiento.setUltimoDocumentoAnyo(cabecera.getAnio());
        dtoMovimiento.setSubprocesoUltimo(parametros.getSubproceso());
        dtoMovimiento.setTipoAbonoUltimo(parametros.getTipoAbono());
        dtoMovimiento.setCuentaCuota(parametros.getCuenta());
        UtilidadesLog.debug("GA - dtoMovimiento: "+dtoMovimiento);

        //actualiza movimiento cuenta corriente                
				monCCC.actualizarCuenta(dtoMovimiento);

				DTODetalleCargosAbonos dtoDetalle=new DTODetalleCargosAbonos();
				dtoDetalle.setNumHistoriaGenera(dtoMovimiento.getUltimoNumeroHistoria());
				dtoDetalle.setMovimiento(dtoMovimiento.getOid());
				if (movimientos.getValueAt(i, "importeAplicar")!=null && !movimientos.getValueAt(i, "importeAplicar").toString().equals("")){
					dtoDetalle.setImporte(new Double(movimientos.getValueAt(i, "importeAplicar").toString()));
				}else {
					dtoDetalle.setImporte(null);
				}
				if (movimientos.getValueAt(i, "importeDivisa")!=null && !movimientos.getValueAt(i, "importeDivisa").toString().equals("")){
					dtoDetalle.setImporteMoneda(new Double(movimientos.getValueAt(i, "importeDivisa").toString()));					
				}else{
					dtoDetalle.setImporteMoneda(null);
				}

				//Validamos la divisa 
				Long divisa = null;
				if (movimientos.getValueAt(i,"divisa") != null && !movimientos.getValueAt(i,"divisa").toString().equals("")) {
					DTOOID dtoDivisa = monMantenimientoSEG.obtenerOIDMonedaAltPais(cabecera.getPais(), (String)movimientos.getValueAt(i,"divisa")); 
					//(La interfaz es interfaces.ISEG.obtenerOIDMonedaAltPais(pais, divisa) ) 
					if (dtoDivisa == null || dtoDivisa.getOid() == null) {
						//throw new MareException("CCC-0046") //El codigo de Divisa no es válido para el país actual
						ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.CCC_0046));
						excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
						excepcionParam.addParameter(" "+(String)movimientos.getValueAt(0, "divisa"));
						throw excepcionParam; 
					} else divisa = dtoDivisa.getOid();
				}
					dtoDetalle.setMoneda(divisa);
					dtoDetalle.setFechaMovimiento(cabecera.getFechaDocumento());	

				if (movimientos.getValueAt(i, "medioPagoOid") != null && !movimientos.getValueAt(i, "medioPagoOid").toString().equals("") )
					dtoDetalle.setMedioPago(new Long(movimientos.getValueAt(i, "medioPagoOid").toString()));
				if(movimientos.getValueAt(i, 0) != null && !movimientos.getValueAt(i, 0).toString().equals("")){
					dtoDetalle.setConsultora(monClientes.obtenerOidCliente(parametros.getOidPais(),movimientos.getValueAt(i, 0).toString()));
				}
				if(cabecera!=null){
					dtoDetalle.setCabecera(cabecera.getOid()); //no puede ser null
				}else{
					dtoDetalle.setCabecera(null);
				}
				dtoDetalle.setNumLinea(new Integer(numDetalle));
				if(parametros!=null){
					dtoDetalle.setSubproceso(parametros.getSubproceso()); //no puede ser null
					dtoDetalle.setCuotaAnterior(parametros.getCuenta()); //no puede ser null
					dtoDetalle.setCuotaNueva(parametros.getCuenta()); //no puede ser null
					dtoDetalle.setTipoAbono(parametros.getTipoAbonoSubproceso());
				}
				dtoDetalle.setEmpresa(cabecera.getEmpresa());
				this.guardarDetalle(dtoDetalle);
				numDetalle++;
			}			
		}catch (FinderException e)  {
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			this.logearError("cancelacionCuotas: FinderException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		}catch (RemoteException e)  {
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("cancelacionCuotas: RemoteException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		}catch (Exception e)  {
			e.printStackTrace();
      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("cancelacionCuotas: Exception",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
    }
		UtilidadesLog.info("MONCargosAbonosBean.cancelacionCuotas(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros): Salida");

		return numDetalle;	

	}

	protected DTOParametrosSubproceso obtenerParametrosSubproceso(String subproceso, Long proceso) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.obtenerParametrosSubproceso(String subproceso, Long proceso): Entrada");
		DTOParametrosSubproceso retorno=new DTOParametrosSubproceso();
		//TiposAbonoSubprocesoLocalHome tiposAbonoHome=this.getTiposAbonoSubprocesoLocalHome();
		//MarcasTipoAbonoLocalHome marcasTipoAbonoHome=this.getMarcasTipoAbonoLocalHome();
        
        /* dmorello, 28/06/2006: Reemplazo llamada al DAO por método finder */
        
		//DAOCCC daoCCC=new DAOCCC();
		//Long longSubProceso=daoCCC.obtieneSubproceso(proceso,subproceso);		
        SubprocesosLocalHome subprHome = new SubprocesosLocalHome();
        SubprocesosLocal subprocesoLocal = null;
        try {
            subprocesoLocal = subprHome.findByUk(proceso, new Long(subproceso));
        } catch (NoResultException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                ErroresDeNegocio.SUBPROCESO_INEXISTENTE));
        }
        
        // dmorello, 28/06/2006
        // Para el siguiente seteo me baso en que el indicador nunca es nulo en BD
        // y además puede valer solo 0 ó 1
        char indActualizaCuota = subprocesoLocal.getIndicadorActualizaCuotaSN().charValue();
        retorno.setIndActualizaCuota(indActualizaCuota == '1');
               
        retorno.setSubproceso(subprocesoLocal.getOid());
        
        /* Fin dmorello 28/06/2006 */
        
        Long longSubProceso = subprocesoLocal.getOid();
        DAOCargosAbonos daoCargosAbonos = new DAOCargosAbonos(ctx.getCallerPrincipal().getName());
        RecordSet subProcesos;
    
        subProcesos = daoCargosAbonos.getSubProcesos(longSubProceso);
        if(subProcesos.esVacio()){
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                ErroresDeNegocio.TIPOS_ABONO_MAL_CONFIGURADOS));
        }
    //Iterator tiposAbonoIterator=tiposAbonoColeccion.iterator();
    //TiposAbonoSubprocesoLocal tiposAbono=(TiposAbonoSubprocesoLocal)tiposAbonoIterator.next();
    retorno.setTipoAbonoSubproceso(new Long(subProcesos.getValueAt(0,"OID_TIPO_ABON_SUBP").toString()));//OID_TIPO_ABON_SUBP
    retorno.setTipoAbono(new Long(subProcesos.getValueAt(0,"TCAB_OID_TCAB").toString()));//TCAB_OID_TCAB
    retorno.setCuenta(new Long(subProcesos.getValueAt(0,"CUCO_OID_CUEN_CONT").toString()));//CUCO_OID_CUEN_CONT
    retorno.setSubproceso(longSubProceso);//SUBP_OID_SUBP
          
          //15414
          /*Si subproceso == CCCConstantes.CANCELACION_CUOTAS { 
              Hacemos un findByTipoAbonoSubproceso del entity MarcasTipoAbono pasándole el tipoAbonoSubproceso (ya que se está buscando la marca de entrada/salida). Del entity que obtenemos guardamos marcaSalida en el atributo marcaSituacion del dto. 
          } 
          Si subproceso == CCCConstantes.GENERACION_VENCIMIENTOS { 
              Hacemos un findByTipoAbonoSubprocesoEoS del entity MarcasTipoAbono pasándole el tipoAbonoSubproceso del paso anterior y "S" (ya que se está buscando la marca de salida). Del entity que obtenemos guardamos marcaSalida en el atributo marcaSituacion del dto. 
          } */
          if (subproceso.equals(CCCConstantes.CANCELACION_CUOTAS)) {
              //Collection marcasTipoAbonoColeccion = marcasTipoAbonoHome.findByTipoAbonoSubproceso(tiposAbono.getOid());
              RecordSet tipoAbono = daoCargosAbonos.getMarcaTipoAbonoEoS(new Long(subProcesos.getValueAt(0,"OID_TIPO_ABON_SUBP").toString()),"S");
              if (!tipoAbono.esVacio()){
                  //Iterator marcasTipoAbonoIterator = marcasTipoAbonoColeccion.iterator();
                  //MarcasTipoAbonoLocal marcasTipoAbonoLocal = (MarcasTipoAbonoLocal) marcasTipoAbonoIterator.next();
                  retorno.setMarcaSituacion(new Long(tipoAbono.getValueAt(0,"MASI_OID_MARC_SALI").toString()) );//MASI_OID_MARC_SALI
                  
                  UtilidadesLog.debug("retorno.getMarcaSituacion() ARRIBA: "+retorno.getMarcaSituacion().toString());
                  
                  
                  if (retorno.getMarcaSituacion() == null) {
                      throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                          ErroresDeNegocio.MARCA_POR_TIPO_ABONO_NO_ENCONTRADA));
                  }
              } else {
                  UtilidadesLog.debug("****Metodo  obtenerParametrosSubproceso: no hay marcasTipoAbono");
                  throw new MareException(new Exception(),
                          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                          ErroresDeNegocio.TIPOS_ABONO_MAL_CONFIGURADOS));
                  
              }
          }

          if (subproceso.equals(CCCConstantes.GENERACION_VENCIMIENTOS)) {
              //Collection marcasTipoAbonoColeccion = marcasTipoAbonoHome.findByTipoAbonoSubprocesoEoS(tiposAbono.getOid(), "S");
              RecordSet tipoAbono = daoCargosAbonos.getMarcaTipoAbonoEoS(new Long(subProcesos.getValueAt(0,"OID_TIPO_ABON_SUBP").toString()),"S");
              if (!tipoAbono.esVacio()){
                  //Iterator marcasTipoAbonoIterator = marcasTipoAbonoColeccion.iterator();
                  //MarcasTipoAbonoLocal marcasTipoAbonoLocal = (MarcasTipoAbonoLocal) marcasTipoAbonoIterator.next();
                  retorno.setMarcaSituacion(new Long(tipoAbono.getValueAt(0,"MASI_OID_MARC_SALI").toString()));//MASI_OID_MARC_SALI
                  UtilidadesLog.debug("retorno.getMarcaSituacion() ABAJO: "+retorno.getMarcaSituacion().toString());
                  if (retorno.getMarcaSituacion() == null) {
                      throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                          ErroresDeNegocio.MARCA_POR_TIPO_ABONO_NO_ENCONTRADA));
                  }
              } else {
                  UtilidadesLog.debug("****Metodo  obtenerParametrosSubproceso: no hay marcasTipoAbono");
                  throw new MareException(new Exception(),
                          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                          ErroresDeNegocio.TIPOS_ABONO_MAL_CONFIGURADOS));
                  
              }
          }					
		UtilidadesLog.info("MONCargosAbonosBean.obtenerParametrosSubproceso(String subproceso, Long proceso): Salida");
		return retorno;
	}

	//incidencia 10294
	private DTOParametrosSubproceso obtenerSubproceso(String subproceso, Long proceso) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.obtenerSubproceso(String subproceso, Long proceso): Entrada");

		DTOParametrosSubproceso retorno=new DTOParametrosSubproceso();
		DAOCCC daoCCC=new DAOCCC();
		Long longSubProceso=daoCCC.obtieneSubproceso(proceso,subproceso);		
		retorno.setSubproceso(longSubProceso);
					
		UtilidadesLog.info("MONCargosAbonosBean.obtenerSubproceso(String subproceso, Long proceso): Salida");
		return retorno;
	}


	//incidencia 10294
	private DTOParametrosSubproceso obtenerRestoParametrosSubproceso(DTOParametrosSubproceso parametros) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.obtenerRestoParametrosSubproceso(DTOParametrosSubproceso parametros): Entrada");
		DTOParametrosSubproceso dtoParametros = new DTOParametrosSubproceso();
		dtoParametros.setSubproceso(parametros.getSubproceso());
		dtoParametros.setOidPais(parametros.getOidPais());
		dtoParametros.setOidIdioma(parametros.getOidIdioma());
		TiposAbonoSubprocesoLocalHome tiposAbonoHome=this.getTiposAbonoSubprocesoLocalHome();
		//MarcasTipoAbonoLocalHome marcasTipoAbonoHome=this.getMarcasTipoAbonoLocalHome();

		try{
			TiposAbonoSubprocesoLocal tiposAbonoSubprocesoLocal = tiposAbonoHome.findByUK(parametros.getTipoAbono(), parametros.getSubproceso());
			if(tiposAbonoSubprocesoLocal == null) {
				throw new MareException(new Exception(),
						UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
						ErroresDeNegocio.TIPOS_ABONO_MAL_CONFIGURADOS));
			}
			dtoParametros.setTipoAbonoSubproceso(tiposAbonoSubprocesoLocal.getOid());
			dtoParametros.setTipoAbono(tiposAbonoSubprocesoLocal.getTipoAbono());
			dtoParametros.setCuenta(tiposAbonoSubprocesoLocal.getCuenta());
                        

		}catch (NoResultException e)  {		
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			this.logearError("obtenerRestoParametrosSubproceso: FinderException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		}  		  		
		
		UtilidadesLog.info("MONCargosAbonosBean.obtenerRestoParametrosSubproceso(DTOParametrosSubproceso parametros): Salida");
		return dtoParametros;
	}

	public DTODatosCargaInicialConceptos cargaInicialConceptos(DTOCargaInicialConceptos dto) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.cargaInicialConceptos(DTOCargaInicialConceptos dto): Entrada");
		DTODatosCargaInicialConceptos datosCargaInicial=new DTODatosCargaInicialConceptos();
		MONMantenimientoSEG monMantenimiento=this.getIServicioSEG();
		DTOBelcorp dtoBel=new DTOBelcorp();
		dtoBel.setOidIdioma(dto.getOidIdioma());
		dtoBel.setOidPais(dto.getOidPais());
		try{
			datosCargaInicial.setDivisas(monMantenimiento.obtenerMonedasAlternativas(dtoBel).getResultado());
		}catch(RemoteException e){
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("cargaInicialConceptos: RemoteException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}		
		DAOCuentasCorrientes daoCC=new DAOCuentasCorrientes(ctx.getCallerPrincipal().getName());
		//DAOCargosAbonos daoCargos=new DAOCargosAbonos(ctx.getCallerPrincipal().getName());
		DTOOID dtoOid=new DTOOID();
		dtoOid.setOid(dto.getEmpresa());
		dtoOid.setOidIdioma(dto.getOidIdioma());
		dtoOid.setOidPais(dto.getOidPais());
		datosCargaInicial.setCuentasCorrientes(daoCC.obtenerCuentasCorrientesEmpresa(dtoOid).getResultado());	
		/*
			·Tipo de Abono = Llamamos a 
			DAOCCC.obtenerTiposCargoSubproceso(subproceso : Long) 
			Por defecto, se presentará el primer registro que se encuentre. 

			-glosaContable = Descripción del primer Tipo de Abono. 
		 */
		 DAOCCC daoCCC = new DAOCCC();
		 //incidencia 7874
		 Long subproceso = daoCCC.obtieneSubproceso(dto.getProceso(), CCCConstantes.CONCEPTOS_GASTOS_ABONOS);
		 datosCargaInicial.setTiposAbono(daoCCC.obtenerTiposCargoSubproceso(subproceso, dto.getOidIdioma()));
		 if (datosCargaInicial.getTiposAbono() != null && !datosCargaInicial.getTiposAbono().esVacio())
			datosCargaInicial.setGlosaContable((String)datosCargaInicial.getTiposAbono().getValueAt(0, 1));
		datosCargaInicial.setTasaCambioMonedaAlternativa(this.obtenerTasaCambioMonedaAlternativa(dto.getOidPais()));
		UtilidadesLog.info("MONCargosAbonosBean.cargaInicialConceptos(DTOCargaInicialConceptos dto): Salida");
		return datosCargaInicial;
	}
    
	private void lanzarMAE0024Exception(String codigo) throws MareException{
		UtilidadesLog.info("MONCargosAbonosBean.lanzarMAE0024Exception(String codigo): Entrada");
		ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "",
			es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0024));
		excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
		excepcionParam.addParameter(codigo);
        UtilidadesLog.info("MONCargosAbonosBean.lanzarMAE0024Exception(String codigo): Salida");
		throw excepcionParam;	
	}
	private void lanzarExceptionParam(String codigo,String errorNegocio) throws MareException{
		UtilidadesLog.info("MONCargosAbonosBean.lanzarExceptionParam(String codigo,String errorNegocio): Entrada");
		ExcepcionParametrizada excepcionParam=new ExcepcionParametrizada("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
			errorNegocio));
		excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
		excepcionParam.addParameter(codigo);
        UtilidadesLog.info("MONCargosAbonosBean.lanzarExceptionParam(String codigo,String errorNegocio): Salida");
		throw excepcionParam;	
	}
	public DTOString bloquearCliente(DTOString dto) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.bloquearCliente(DTOString dto): Entrada");
		DTOString dtoStringResultado=new DTOString();
		MONClientes monClientes=this.getIMaestroClientes();
		try{
			Long oidCliente=monClientes.obtenerOidCliente(dto.getOidPais(),dto.getCadena());
			if(oidCliente==null){
				this.lanzarMAE0024Exception(dto.getCadena());
			}
			boolean bloqueo=monClientes.ponerbloqueoFinanciero(oidCliente,"Gestión de cheques devueltos CCC","");
			if(bloqueo){
				dtoStringResultado.setCadena("Se ha añadido un bloqueo al cliente: "+dto.getCadena());
			}else{
				dtoStringResultado.setCadena("El cliente ya tenía un bloqueo financiero");
			}
		}catch (RemoteException e)  {
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("bloquearCliente: RemoteException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		}  	
		UtilidadesLog.info("MONCargosAbonosBean.bloquearCliente(DTOString dto): Salida");
		return dtoStringResultado;
	}

	protected BigDecimal obtenerTasaCambioMonedaAlternativa(Long pais) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.obtenerTasaCambioMonedaAlternativa(Long pais): Entrada");
		MONMantenimientoSEG monManSeg=this.getIServicioSEG();
		BigDecimal resultado=null;
		try {
			resultado=monManSeg.obtenerCambioMonedaAlternativa(pais);
		}catch (RemoteException e)  {		
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("obtenerTasaCambioMonedaAlternativa: RemoteException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		}  	
		UtilidadesLog.info("MONCargosAbonosBean.obtenerTasaCambioMonedaAlternativa(Long pais): Salida");
		return resultado;
	}

	public DTOCargaInicialGeneracionVencimientos cargaInicialVencimientos(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.cargaInicialVencimientos(DTOBelcorp dto): Entrada");
		DTOCargaInicialGeneracionVencimientos cargaInicial=new DTOCargaInicialGeneracionVencimientos();
		cargaInicial.setTasaCambioMonedaAlternativa(this.obtenerTasaCambioMonedaAlternativa(dto.getOidPais()));
		UtilidadesLog.info("MONCargosAbonosBean.cargaInicialVencimientos(DTOBelcorp dto): Salida");
		return cargaInicial;
	}


	public DTOSalida obtenerTiposCargo(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.obtenerTiposCargo(DTOBelcorp dto): Entrada");
		DAOCCC daoCCC = new DAOCCC();
		DTOSalida salida = daoCCC.obtenerTiposCargo(dto);
    	UtilidadesLog.info("MONCargosAbonosBean.obtenerTiposCargo(DTOBelcorp dto): Salida");
		return salida; 		
	}
	
	private CabeceraCargosAbonosDirectosLocalHome getCabeceraCargosAbonosDirectosLocalHome() throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.getCabeceraCargosAbonosDirectosLocalHome(): Entrada");        
		UtilidadesLog.info("MONCargosAbonosBean.getCabeceraCargosAbonosDirectosLocalHome(): Salida");
        return new CabeceraCargosAbonosDirectosLocalHome();
    } 

	private DetalleCargosAbonosDirectosLocalHome getDetalleCargosAbonosDirectosLocalHome() throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.getDetalleCargosAbonosDirectosLocalHome(): Entrada");		
		UtilidadesLog.info("MONCargosAbonosBean.getDetalleCargosAbonosDirectosLocalHome(): Salida");
		return new DetalleCargosAbonosDirectosLocalHome();
	}

	private MovimientosBancariosLocalHome getMovimientosBancariosLocalHome() throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.getMovimientosBancariosLocalHome(): Entrada");
        MovimientosBancariosLocalHome movimientosBancariosLocalHome = (MovimientosBancariosLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MovimientosBancarios");
		UtilidadesLog.info("MONCargosAbonosBean.getMovimientosBancariosLocalHome(): Salida");
        return movimientosBancariosLocalHome;
    } 	
    private MarcaLocalHome getMarcaLocalHome() throws MareException {
        UtilidadesLog.info("MONCargosAbonosBean.getMarcaLocalHome(): Entrada");        
        UtilidadesLog.info("MONCargosAbonosBean.getMarcaLocalHome(): Salida");
        return new MarcaLocalHome();
    } 		

    private CanalLocalHome getCanalLocalHome() throws MareException {
        UtilidadesLog.info("MONCargosAbonosBean.getCanalLocalHome(): Entrada");        
        UtilidadesLog.info("MONCargosAbonosBean.getCanalLocalHome(): Salida");
        return new CanalLocalHome();
    } 		

     private AccesoLocalHome getAccesoLocalHome() throws MareException {
        UtilidadesLog.info("MONCargosAbonosBean.getAccesoLocalHome(): Entrada");        
        UtilidadesLog.info("MONCargosAbonosBean.getAccesoLocalHome(): Salida");
        return new AccesoLocalHome();
    } 		

     private SubaccesoLocalHome getSubaccesoLocalHome() throws MareException {
        UtilidadesLog.info("MONCargosAbonosBean.getSubaccesoLocalHome(): Entrada");        
        UtilidadesLog.info("MONCargosAbonosBean.getSubaccesoLocalHome(): Salida");
        return new SubaccesoLocalHome();
    } 
    private MarcasTipoAbonoLocalHome getMarcasTipoAbonoLocalHome() throws MareException {
        UtilidadesLog.info("MONCargosAbonosBean.getMarcasTipoAbonoLocalHome(): Entrada");        
        UtilidadesLog.info("MONCargosAbonosBean.getMarcasTipoAbonoLocalHome(): Salida");
        return new MarcasTipoAbonoLocalHome();
    } 
	private MovimientosCuentasCorrientesLocalHome getMovimientosCuentasCorrientesLocalHome() throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.getMovimientosCuentasCorrientesLocalHome(): Entrada");
        MovimientosCuentasCorrientesLocalHome movimientosCuentasCorrientesHome = (MovimientosCuentasCorrientesLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MovimientosCuentasCorrientes");
		UtilidadesLog.info("MONCargosAbonosBean.getMovimientosCuentasCorrientesLocalHome(): Salida");
        return movimientosCuentasCorrientesHome;
    }
    /*private MovimientosCuentasCorrientesLocalHome getMovimientosCuentasCorrientesLocalHome() throws MareException {
		UtilidadesLog.debug("****Metodo getMovimientosCuentasCorrientesHome: Entrada");
        MovimientosCuentasCorrientesLocalHome movimientosCuentasCorrientesHome = (MovimientosCuentasCorrientesLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MovimientosCuentasCorrientes");
		UtilidadesLog.debug("****Metodo getMovimientosCuentasCorrientesHome: Salida");
        return movimientosCuentasCorrientesHome;
    } */		
	
    private TiposAbonoSubprocesoLocalHome getTiposAbonoSubprocesoLocalHome() throws MareException {
        UtilidadesLog.info("MONCargosAbonosBean.getTiposAbonoSubprocesoLocalHome(): Entrada");        
        UtilidadesLog.info("MONCargosAbonosBean.getTiposAbonoSubprocesoLocalHome(): Salida");
        return new TiposAbonoSubprocesoLocalHome();
    }

	private PaisLocalHome getPaisLocalHome() throws MareException {
            UtilidadesLog.info("MONCargosAbonosBean.getPaisLocalHome(): Entrada");        
            UtilidadesLog.info("MONCargosAbonosBean.getPaisLocalHome(): Salida");
        return new PaisLocalHome();
    }

	 private MONMantenimientoSEG getMONMantenimientoSEG() throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.getMONMantenimientoSEG(): Entrada");
        // Se obtiene el interfaz home
        MONMantenimientoSEGHome home = (MONMantenimientoSEGHome)UtilidadesEJB.getHome(
            "MONMantenimientoSEG", MONMantenimientoSEGHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoSEG ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logearError("getMONMantenimientoSEG: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONCargosAbonosBean.getMONMantenimientoSEG(): Salida");
        return ejb;
    }

	private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException {
        UtilidadesLog.info("MONCargosAbonosBean.getMONGestionMensajesHome(): Entrada");
		final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONCargosAbonosBean.getMONGestionMensajesHome(): Salida");
		return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionMensajes"), MONGestionMensajesHome.class);
	}

	//anyadido por incidencia BELC300008373
	public void enviarMensaje(DTOConceptosGastosAbonos dto) throws MareException {
		UtilidadesLog.info("MONCargosAbonosBean.enviarMensaje(DTOConceptosGastosAbonos dto): Entrada");

		Long oidCliente = null;
		ClienteDatosBasicosLocalHome home = null;
		ClienteDatosBasicosLocal cliente = null;
		String nombreCliente = null;
		Date fecha = null;
		MONGestionMensajes localGestion = null;
		MONClientes localClientes = null;
		
		DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
		
		
		//validamos el cliente
		localClientes = this.getIMaestroClientes();
		try { 
			oidCliente =  localClientes.obtenerOidCliente(dto.getOidPais(),dto.getCodigoCliente());
			

		} catch (RemoteException re) {
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.debug("enviarMensaje : RemoteException",re);
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
		}

		if (oidCliente == null) {
			this.lanzarMAE0024Exception(dto.getCodigoCliente());
		}

		home = this.getClienteDatosBasicosLocalHome();
		try {
			cliente = home.findByPrimaryKey(oidCliente);
		} catch(NoResultException fe) {
                                ctx.setRollbackOnly();
				String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
				UtilidadesLog.debug("enviarMensaje: FinderException",fe);
				throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
		}
		nombreCliente = cliente.getVal_nom1();
		fecha = new Date(System.currentTimeMillis());
		
		dtoBuzon.setOidPais(new Long(dto.getOidPais().longValue()));
		dtoBuzon.setCodigoMensaje("CCC03");
		dtoBuzon.setOidCliente(new Long(oidCliente.longValue()));
		//dtoBuzon.setModuloOrigen("CCC");   //pendiente de incidencia BELC300009492
		dtoBuzon.setDatoVariable1(nombreCliente);
		dtoBuzon.setDatoVariable2(dto.getGlosaContable());
		dtoBuzon.setDatoVariable3(fecha.toString()); //pendiente de incidencia BELC300009492
		dtoBuzon.setDatoVariable4(dto.getImporte().toString());
		dtoBuzon.setListaConsultoras("N");
		dtoBuzon.setCodigoPatron(null);

		localGestion = this.getMONGestionMensajes();
		try {
			localGestion.insertaDatosMensaje(dtoBuzon);
		} catch (RemoteException re) {
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			UtilidadesLog.debug("enviarMensaje : RemoteException",re);
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
		}
		UtilidadesLog.info("MONCargosAbonosBean.enviarMensaje(DTOConceptosGastosAbonos dto): Entrada");
	}

	private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() throws MareException {
		
        UtilidadesLog.info("MONCargosAbonosBean.getClienteDatosBasicosLocalHome(): Entrada");        
        UtilidadesLog.info("MONCargosAbonosBean.getClienteDatosBasicosLocalHome(): Salida");
            return new ClienteDatosBasicosLocalHome();
	}

  

    private java.util.Date fechaFormateada(String fechaEntrada) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat();
        if(fechaEntrada.indexOf("/") > -1){
            f.applyLocalizedPattern("dd/MM/yyyy");    
        }else{
            f.applyLocalizedPattern("yyyy-MM-dd");    
        }
        java.util.Date salida = f.parse(fechaEntrada);
        UtilidadesLog.debug("fechaFormateada: "+salida);
        return salida;
    }

    /**
     * Obtiene en numero de identificacion de acuerdo al pais.
     * V-CCC-028
     */
    public DTOCargaInicialCargosAbonos obtenerNumeroIdentificacion(DTOCasoUso dto) throws MareException{
        UtilidadesLog.info("MONCargosAbonosBean.obtenerNumeroIdentificacion(): Entrada");
        Integer numeroIdentificacion;
        DTOCargaInicialCargosAbonos dtoCargaInicialCargosAbonos = new DTOCargaInicialCargosAbonos();
        
        DAOCCC daoCCC = new DAOCCC();
        DTOBelcorp dtobelcorp = new DTOBelcorp();
        dtobelcorp.setOidIdioma(dto.getOidIdioma());
        dtobelcorp.setOidPais(dto.getOidPais());
        numeroIdentificacion = daoCCC.obtenerSecuenciaPais(dtobelcorp);
        dtoCargaInicialCargosAbonos.setNumeroIdentificacion(numeroIdentificacion);			
        UtilidadesLog.info("MONCargosAbonosBean.obtenerNumeroIdentificacion(): Salida");
        return dtoCargaInicialCargosAbonos;
    }

    /**
     * Valida el numero de documento, si número documento existe, y si existe, si es para el mismo cliente.
     * 1.- Retorna NE, si no existe el numero de documento al acceder a la entidad CCC-Movimiento-Cuenta Corriente accediendo por país + número documento. 
     * 2.- Retorna NP, si número documento no pertenece al cliente.
     * 3.- Retorna E, si existe el numero de documento para el cliente.
     * @autor gdmarzi
     */
    public DTOString validarNumeroDocumento(DTOValidarNumeroDocumento dto) throws MareException{
        UtilidadesLog.info("MONCargosAbonos.validarNumeroDocumento() Entrada");
        DTOString dtoEstado = new DTOString();
        DAOCargosAbonos dao = new DAOCargosAbonos(ctx.getCallerPrincipal().getName());
        if ( ! dao.existeNumeroDocumento(dto) ) {
            dtoEstado.setCadena("NE");      
        } else {
            if ( ! dao.numeroDocumentoPerteneceCliente(dto) ) {
                dtoEstado.setCadena("NP");              
            } else {
                dtoEstado.setCadena("E");
            }
        }
        UtilidadesLog.info("MONCargosAbonos.validarNumeroDocumento() Salida");
        return dtoEstado;
    }

   private MONCuentasCorrientesLocalHome getMONCuentasCorrientesLocalHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONCuentasCorrientesLocalHome)context.lookup("java:comp/env/ejb/local/MONCuentasCorrientes");
   }

   public void validarBloqueo(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONCargosAbonos.validarBloqueo() Entrada");
   
        String usuario = ctx.getCallerPrincipal().getName();
                 
        DTOBloqueo dtoB = new DTOBloqueo();
        /*Uso el atributo pais del dto para poder insertar la descripcion correcta, envio una constante desde parte cliente
         * Si pais = 1 Aplica cargos y abonos directos
         * Si pais = 2 Generar Descuento recargo automatico
         * */
        int proceso = dto.getOidPais().intValue();
        switch(proceso) {
            case 1:
                dtoB.setDescripcionProceso("Aplica cargos y abonos directos");
                break;
            case 2:
                dtoB.setDescripcionProceso("Generar Descuento/Recargo automatico");
                break;
            case 3:
                dtoB.setDescripcionProceso("Reasignacion de pagos entre consultoras");
                break;
            default:
                throw new MareException("Codigo de proceso no existente", new Exception());
        }
        dtoB.setUsuario(usuario);
        
        try{
            MONCuentasCorrientesLocal mccL = getMONCuentasCorrientesLocalHome().create();
            mccL.insertarBloqueo(dtoB);
        }catch (NamingException ne){
           String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(ne, UtilidadesError.armarCodigoError(codigoError));
        }catch (CreateException e){
              ctx.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONCargosAbonos.validarBloqueo() Salida");

   }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con el resultado de la busqueda     
     */
    public DTOSalida buscarBancosReasignar(DTOBuscarMovimientosReasignacion dtoe) throws MareException {
        
        StringBuffer buff = generarSQLBusquedaBancosReasignar(dtoe);
        DTOSalida salida = new DTOSalida();
        RecordSet rsSalida = null;
        try{
            rsSalida = BelcorpService.getInstance().
                dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(buff.toString(),dtoe));
            if(rsSalida.esVacio()){
                throw new MareException(new Exception(),
                                         UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }catch(Exception e){
            if(e instanceof MareException){
                throw (MareException)e;
            }else{
                throw new MareException("Error al buscar datos para la reasignacion",e);
            }
        }
        salida.setResultado(rsSalida);
        return salida;
    }

    private StringBuffer generarSQLBusquedaBancosReasignar(DTOBuscarMovimientosReasignacion dtoe) {
    
        StringBuffer buff = new StringBuffer();
        buff.append("SELECT CMB.OID_MOVI_BANC OID, CCB.DES_CC, MC.COD_CLIE, ");
	    buff.append(" substr(VAL_NOM1||' '||VAL_NOM2||' '||VAL_APE1||' '||VAL_APE2,0,40) AS NOMBRE, ");
        buff.append(" CMB.NUM_LOTE, CMB.NUM_CONS_TRAN, CMB.FEC_PAGO, CMB.IMP_PAGO, CMB.IMP_SALD_PEND, ");
	    buff.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc(").append(dtoe.getOidIdioma()).append(",");
        buff.append(" CTT.OID_TIPO_TRAN, 'CCC_TIPO_TRANS') AS TIPO_TRANS, ");
        buff.append(" CMB.VAL_DOCU_CREA_ANIO, CMB.VAL_DOCU_CREA_MES_SERI, CMB.VAL_DOCU_CREA_NUME, ");
	    buff.append(" CMB.VAL_ESTA_MOVI_PEND, cmb.NUM_CUPO, cmb.NUM_FACT_BOLE ");
        buff.append(" FROM CCC_MOVIM_BANCA CMB, CCC_TIPO_TRANS CTT , CCC_CUENT_CORRI_BANCA CCB ");
        buff.append(" , CCC_SUCUR CS  , MAE_CLIEN MC ");
        if(dtoe.getOidRegion()!=null || dtoe.getOidZona()!=null){
            buff.append(" , MAE_CLIEN_UNIDA_ADMIN MCUA , ZON_TERRI_ADMIN ZTA , ZON_SECCI ZS , ZON_ZONA ZZ "); 
        }
        buff.append(" WHERE CMB.PAIS_OID_PAIS = ").append(dtoe.getOidPais());
        buff.append(" AND CMB.CCBA_OID_CC_BANC = CCB.OID_CUEN_CORR_BANC ");
        buff.append(" AND CCB.SUCU_OID_SUCU = CS.OID_SUCU ");
        if(dtoe.getOidMovimientoBancario()!=null){
            buff.append(" AND CMB.OID_MOVI_BANC = ").append(dtoe.getOidMovimientoBancario());
        }
        if(dtoe.getOidCuentaCorrienteBancaria()!=null){
            buff.append(" AND CMB.CCBA_OID_CC_BANC = ").append(dtoe.getOidCuentaCorrienteBancaria());
        }
        if(dtoe.getOidBanco()!=null){
            buff.append(" AND CS.CBAN_OID_BANC = ").append(dtoe.getOidBanco());
        }
        buff.append(" AND CMB.TTRA_OID_TIPO_TRANS = CTT.OID_TIPO_TRAN ");
        if(dtoe.getOidCliente()!=null){//SI TIENE OID LO USO Y SOLO SI NO TIENE OID PREGUNTO POR EL CODIGO
            buff.append(" AND CMB.CLIE_OID_CLIE = ").append(dtoe.getOidCliente());
            buff.append(" AND MC.OID_CLIE = ").append(dtoe.getOidCliente());
        }else{
            if(dtoe.getCodigoCliente() !=null){
                buff.append(" AND MC.COD_CLIE = '").append(dtoe.getCodigoCliente()).append("'");
            }
        }
        if(dtoe.getFechaPago()!=null){
            buff.append(" AND CMB.FEC_PAGO = TO_DATE('").append(sdf.format(dtoe.getFechaPago())).append("','DD/MM/YYYY') ");    
        }
        if(dtoe.getNumeroLote()!=null){
            buff.append(" AND CMB.NUM_LOTE = ").append(dtoe.getNumeroLote());    
        }
        if(dtoe.getNumeroConsecutivoTransaccion()!=null){
            buff.append(" AND CMB.NUM_CONS_TRAN = ").append(dtoe.getNumeroConsecutivoTransaccion());
        }
        if(dtoe.getNumeroCupon()!=null){
            buff.append(" AND CMB.NUM_CUPO = ").append(dtoe.getNumeroCupon());
        }
        if(dtoe.getNumeroBolFact()!=null){
            buff.append(" AND CMB.NUM_FACT_BOLE = ").append(dtoe.getNumeroBolFact());
        }
        if(dtoe.getImportePagoDesde()!=null){
            buff.append(" AND CMB.IMP_PAGO >= ").append(dtoe.getImportePagoDesde());
        }
        if(dtoe.getImportePagoHasta()!=null){
            buff.append(" AND CMB.IMP_PAGO <= ").append(dtoe.getImportePagoHasta());
        }
        buff.append(" AND CMB.COD_IDEN_PROC = '").append(CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO).append("' ");
        buff.append(" AND CMB.CLIE_OID_CLIE = MC.OID_CLIE ");
        if(dtoe.getOidRegion()!=null || dtoe.getOidZona()!=null){
            buff.append(" AND MC.OID_CLIE = MCUA.CLIE_OID_CLIE ");
            buff.append(" AND MCUA.PERD_OID_PERI_FIN IS NULL ");
            buff.append(" AND MCUA.ZTAD_OID_TERR_ADMI = ZTA.OID_TERR_ADMI ");
            buff.append(" AND ZTA.ZSCC_OID_SECC = ZS.OID_SECC ");
            buff.append(" AND ZS.ZZON_OID_ZONA = ZZ.OID_ZONA ");
            if(dtoe.getOidZona()!=null){
                buff.append(" AND ZZ.OID_ZONA = ").append(dtoe.getOidZona());
            }
            if(dtoe.getOidRegion()!=null){
                buff.append(" AND ZORG_OID_REGI = ").append(dtoe.getOidRegion());
            }
        }
        //debemos filtrar los movimientos q sean reasignaciones
        //para no permitir realizar esta operacion mas de una
        //vez con el mismo movimiento.
        buff.append(" AND CMB.TTRA_OID_TIPO_TRANS <> ");
        buff.append(" (SELECT OID_TIPO_TRAN FROM CCC_TIPO_TRANS WHERE COD_TIPO_TRAN = '");
        buff.append(CCCConstantes.TIPO_TRANSACCION_REASIGNACION_PAGO).append("')");
    
        return buff;
        
    }
    
    private RecordSet obtenerMovimientoReasignacion(DTOReasignacionPagos dtoe)throws MareException    {
        StringBuffer buff = new StringBuffer();
        buff.append("SELECT * FROM CCC_MOVIM_BANCA WHERE OID_MOVI_BANC = ").append(dtoe.getOidMovimientoOriginal());
        RecordSet rsSalida = null;
        try{
            rsSalida = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());
            if(rsSalida.esVacio()){
                throw new MareException(new Exception(),UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }catch(Exception e){
            if(e instanceof MareException){
                throw (MareException)e;
            }else{
                throw new MareException("Error al buscar el movimiento bancario para la reasignacion",e);
            }
        }
        
        return rsSalida;
    }
    
    private Long obtenerOidTipoTransaccion(DTOReasignacionPagos dtoe)throws MareException{
        StringBuffer buff = new StringBuffer();
        buff.append("SELECT OID_TIPO_TRAN FROM CCC_TIPO_TRANS WHERE COD_TIPO_TRAN = '");
        buff.append(dtoe.getTipoTransaccion()).append("'");
        buff.append(" AND PAIS_OID_PAIS = ").append(dtoe.getOidPais());
        RecordSet rsSalida = null;
        try{
            rsSalida = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());
            if(rsSalida.esVacio()){
                throw new MareException(new Exception(),UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }catch(Exception e){
            if(e instanceof MareException){
                throw (MareException)e;
            }else{
                throw new MareException("Error al buscar el tipo de transaccion para la reasignacion",e);
            }
        }
        return new Long(rsSalida.getValueAt(0,0).toString());
    }
    
    
  /**
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dtoE
   * @author gacevedo
   * Este metodo se implanta segun el pedido de cambio COL-CCC-003
   */
  public void reasignarBancos(DTOReasignacionPagos dtoE) throws MareException {
    UtilidadesLog.debug("MONCargosAbonos.reasignarBancos(DTOReasignacionPagos dtoE) Entrada");
    
    UtilidadesLog.debug("dtoE: "+dtoE);
    
    DTOBloqueo dtoB = new DTOBloqueo();
    dtoB.setDescripcionProceso("Reasignacion pagos entre consultoras");
    String usuario = ctx.getCallerPrincipal().getName();
    dtoB.setUsuario(usuario);
    DAOCCC daoCCC = new DAOCCC();
    daoCCC.insertarBloqueo(dtoB);
    try{
        Long numeroLote = new Long(getMONGestorInterfacesHome().create().obtenerNumeroLote());
        PaisLocal pais = getPaisLocalHome().findByPrimaryKey(dtoE.getOidPais());
        RecordSet rsTipoAbonoSubp = daoCCC.obtenerTiposAbonoSubproceso(CCCConstantes.PROCESO_REASIGNACION_PAGOS_ENTRE_CONSULTORAS,
                                                                        new Integer(1),
                                                                    dtoE.getOidPais());
        Long tipoAbonoCreacion = new Long(rsTipoAbonoSubp.getValueAt(0,"TCAB_OID_TCAB").toString());
        Long subProcesoCreacion = new Long(rsTipoAbonoSubp.getValueAt(0,"SUBP_OID_SUBP").toString());
        Long tipoAbonoSubProceso = new Long(rsTipoAbonoSubp.getValueAt(0,"OID_TIPO_ABON_SUBP").toString());
        
        Long oidTipoTransaccion = obtenerOidTipoTransaccion(dtoE);
        java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());
        RecordSet rsMovimientoOriginal = obtenerMovimientoReasignacion(dtoE);
        DTOMovimientoBancario dtoMovBanc = new DTOMovimientoBancario();
        BigDecimal importePago = (BigDecimal)rsMovimientoOriginal.getValueAt(0,"IMP_PAGO");
        BigDecimal importePagoNegativo = importePago.negate();
        StringBuffer buffSQL = new StringBuffer();
        String[] partesFechaDelSistema = obtenerAnioMesDiaDelSistema();
        String anio = partesFechaDelSistema[0].substring(2, 4);
        String periodoMes = partesFechaDelSistema[1];
        
        //Se actualiza el registro del movimiento bancario a reasignar 
        buffSQL.append("UPDATE CCC_MOVIM_BANCA SET TTRA_OID_TIPO_TRANS=").append(oidTipoTransaccion);
        buffSQL.append(" WHERE OID_MOVI_BANC=").append(dtoE.getOidMovimientoOriginal()).append(";");
        
        //primero la reasignada
        dtoMovBanc.setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_CMBA_SEQ"));
        dtoMovBanc.setOidPais(dtoE.getOidPais());
        dtoMovBanc.setOidIdioma(dtoE.getOidIdioma());
        dtoMovBanc.setNumeroLote(numeroLote);
        dtoMovBanc.setConsecutivoTransaccion(new Long(1));
        dtoMovBanc.setFechaPago((java.sql.Date)rsMovimientoOriginal.getValueAt(0,"FEC_PAGO"));
        dtoMovBanc.setFechaUltimoMivimiento(fechaActual);
        dtoMovBanc.setEmpresa(new Long(rsMovimientoOriginal.getValueAt(0,"SOCI_OID_SOCI").toString()));
        dtoMovBanc.setCuentaCorrienteBancaria(new Long(rsMovimientoOriginal.getValueAt(0,"CCBA_OID_CC_BANC").toString()));
        dtoMovBanc.setTipoTransaccion(oidTipoTransaccion);
        dtoMovBanc.setCodConsultoraReal(rsMovimientoOriginal.getValueAt(0,"COD_CONS").toString());
        dtoMovBanc.setOidConsultoraReal(new Long(rsMovimientoOriginal.getValueAt(0,"CLIE_OID_CLIE").toString()));
        dtoMovBanc.setImportePago(importePagoNegativo);
        dtoMovBanc.setImporteMovimiento(importePagoNegativo);
        dtoMovBanc.setImporteAplicado(new BigDecimal(0));
        dtoMovBanc.setImporteSaldo(importePagoNegativo);
        dtoMovBanc.setCodError("00");
        dtoMovBanc.setEstatusMovimientoTesoreria(new Character('P'));
        dtoMovBanc.setIdentificadorProceso("P");
        dtoMovBanc.setNumeroHistoria(new Integer(0));
        dtoMovBanc.setOidSubprocesoMarcaCreacion(subProcesoCreacion);
        dtoMovBanc.setOidSubprocesoMarcaUltimo(subProcesoCreacion);
        dtoMovBanc.setOidTipoAbonoCreacion(tipoAbonoCreacion);
        dtoMovBanc.setOidTipoAbonoUltimo(tipoAbonoCreacion);
        dtoMovBanc.setUsuarioProceso(usuario);
        dtoMovBanc.setCodigoUsuario(usuario);
        dtoMovBanc.setFechaProceso(fechaActual);
        dtoMovBanc.setFechaMovimientoAplicacion(fechaActual); 
        if(rsMovimientoOriginal.getValueAt(0,"NUM_FACT_BOLE")!=null){
            dtoMovBanc.setNumeroFactura(new Long(rsMovimientoOriginal.getValueAt(0,"NUM_FACT_BOLE").toString()));
        }
        if(rsMovimientoOriginal.getValueAt(0,"VAL_DIGI_CHEQ_FACT")!=null){
            dtoMovBanc.setDigitoChequeo(new Integer(rsMovimientoOriginal.getValueAt(0,"VAL_DIGI_CHEQ_FACT").toString()));    
        }
        if(rsMovimientoOriginal.getValueAt(0,"NUM_CUPO")!=null){
            dtoMovBanc.setNumeroCupon(new Long(rsMovimientoOriginal.getValueAt(0,"NUM_CUPO").toString()));    
        }
        if(rsMovimientoOriginal.getValueAt(0,"VAL_NUME_DOCU")!=null) {
            dtoMovBanc.setNumeroDocumento(new Long(rsMovimientoOriginal.getValueAt(0,"VAL_NUME_DOCU").toString()));    
        }
        if(rsMovimientoOriginal.getValueAt(0,"COD_OFIC_RECA")!=null){
            dtoMovBanc.setOficinaRecaudadora(rsMovimientoOriginal.getValueAt(0,"COD_OFIC_RECA").toString());    
        }
        if(rsMovimientoOriginal.getValueAt(0,"VAL_NOMB_OFIC")!=null){
            dtoMovBanc.setNombreOficina(rsMovimientoOriginal.getValueAt(0,"VAL_NOMB_OFIC").toString());
        }
        if(rsMovimientoOriginal.getValueAt(0,"VAL_HORA_NORM_ADIC")!=null){
            dtoMovBanc.setHorario(rsMovimientoOriginal.getValueAt(0,"VAL_HORA_NORM_ADIC").toString());
        }
        if(dtoE.getObservaciones()!=null){
            dtoMovBanc.setObservaciones(dtoE.getObservaciones());
        }
        
        //estos no se guardan, se usan para la generacion del
        //detalle cargo abono.
        dtoMovBanc.setAnioDocumentoCreacion(anio);
        dtoMovBanc.setSerieDocumentoCreacion(periodoMes);
        //primer insert (cabecera cargo/abono)
        Long oidCabecera = SecuenciadorOID.obtenerSiguienteValor("CCC_CCAD_SEQ");
        Integer numero = daoCCC.obtenerSecuenciaPais(dtoMovBanc);
        buffSQL.append(armarInsertCabeceraCargoAbono(dtoMovBanc, oidCabecera, numero));
        
        //segundo y tercer insert (banco y detalle cargo abono)
        dtoMovBanc.setNumeroDocumentoCreacion(numero); 
        buffSQL.append(armarInsertBanco(dtoMovBanc));
        buffSQL.append(armarInsertDetalleCargoAbono(dtoMovBanc, oidCabecera, tipoAbonoSubProceso));
        
        //ahora la "A REASIGNAR"
        DTOMovimientoBancario dtoMovBancAReasig = new DTOMovimientoBancario();
        dtoMovBancAReasig.setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_CMBA_SEQ"));
        dtoMovBancAReasig.setOidPais(dtoE.getOidPais());
        dtoMovBancAReasig.setOidIdioma(dtoE.getOidIdioma());
        dtoMovBancAReasig.setNumeroLote(numeroLote);
        dtoMovBancAReasig.setConsecutivoTransaccion(new Long(2));
        dtoMovBancAReasig.setFechaPago((java.sql.Date)rsMovimientoOriginal.getValueAt(0,"FEC_PAGO"));
        dtoMovBancAReasig.setFechaUltimoMivimiento(fechaActual);
        dtoMovBancAReasig.setEmpresa(new Long(rsMovimientoOriginal.getValueAt(0,"SOCI_OID_SOCI").toString()));
        dtoMovBancAReasig.setCuentaCorrienteBancaria(new Long(rsMovimientoOriginal.getValueAt(0,"CCBA_OID_CC_BANC").toString()));
        dtoMovBancAReasig.setTipoTransaccion(oidTipoTransaccion);
        dtoMovBancAReasig.setCodConsultoraReal(dtoE.getCodigoClienteReceptor());
        dtoMovBancAReasig.setOidConsultoraReal(dtoE.getOidClienteReceptor());
        dtoMovBancAReasig.setImporteAplicado(new BigDecimal(0));
        dtoMovBancAReasig.setImportePago(importePago);
        dtoMovBancAReasig.setImporteMovimiento(importePago);
        dtoMovBancAReasig.setImporteSaldo(importePago);
        dtoMovBancAReasig.setCodError("00");
        dtoMovBancAReasig.setEstatusMovimientoTesoreria(new Character('P'));
        dtoMovBancAReasig.setIdentificadorProceso("P");
        dtoMovBancAReasig.setNumeroHistoria(new Integer(0));
        dtoMovBancAReasig.setOidSubprocesoMarcaCreacion(subProcesoCreacion);
        dtoMovBancAReasig.setOidSubprocesoMarcaUltimo(subProcesoCreacion);
        dtoMovBancAReasig.setOidTipoAbonoCreacion(tipoAbonoCreacion);
        dtoMovBancAReasig.setOidTipoAbonoUltimo(tipoAbonoCreacion);
        dtoMovBancAReasig.setUsuarioProceso(usuario);
        dtoMovBancAReasig.setCodigoUsuario(usuario);
        dtoMovBancAReasig.setFechaProceso(fechaActual); 
        dtoMovBancAReasig.setFechaMovimientoAplicacion(fechaActual); 
        if(dtoE.getNumeroBoletaFactura()!=null){
            dtoMovBancAReasig.setNumeroFactura(dtoE.getNumeroBoletaFactura());
        }
        if(rsMovimientoOriginal.getValueAt(0,"VAL_DIGI_CHEQ_FACT")!=null){
            dtoMovBancAReasig.setDigitoChequeo(new Integer(rsMovimientoOriginal.getValueAt(0,"VAL_DIGI_CHEQ_FACT").toString()));
        }
        if(dtoE.getNumeroCupon()!=null){
            dtoMovBancAReasig.setNumeroCupon(dtoE.getNumeroCupon());
        }
        if(rsMovimientoOriginal.getValueAt(0,"VAL_NUME_DOCU")!=null){
            dtoMovBancAReasig.setNumeroDocumento(new Long(rsMovimientoOriginal.getValueAt(0,"VAL_NUME_DOCU").toString()));
        }
        if(rsMovimientoOriginal.getValueAt(0,"COD_OFIC_RECA")!=null){
            dtoMovBancAReasig.setOficinaRecaudadora(rsMovimientoOriginal.getValueAt(0,"COD_OFIC_RECA").toString());
        }
        if(rsMovimientoOriginal.getValueAt(0,"VAL_NOMB_OFIC")!=null){
            dtoMovBancAReasig.setNombreOficina(rsMovimientoOriginal.getValueAt(0,"VAL_NOMB_OFIC").toString());
        }
        if(rsMovimientoOriginal.getValueAt(0,"VAL_HORA_NORM_ADIC")!=null){
            dtoMovBancAReasig.setHorario(rsMovimientoOriginal.getValueAt(0,"VAL_HORA_NORM_ADIC").toString());
        }
        if(dtoE.getObservaciones()!=null){
            dtoMovBancAReasig.setObservaciones(dtoE.getObservaciones());
        }
        //estos no se guardan, se usan para la generacion del
        //detalle cargo abono.
        dtoMovBancAReasig.setAnioDocumentoCreacion(anio);
        dtoMovBancAReasig.setSerieDocumentoCreacion(periodoMes);
        dtoMovBancAReasig.setNumeroDocumentoCreacion(numero); 
        //cuarto y quinto insert (banco y detalle cargo abono)
        buffSQL.append(armarInsertBanco(dtoMovBancAReasig));
        buffSQL.append(armarInsertDetalleCargoAbono(dtoMovBancAReasig, oidCabecera,tipoAbonoSubProceso));
        //grabamos
        try{
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", buffSQL.toString());
        }catch(Exception e) {
            UtilidadesLog.error("Error al grabar-- SQL= "+buffSQL.toString());
            throw e;
        }
        
        //ahora llamamos a procesarMovimientosBancariosPorAplicacion
        DTOMovBancIndicadores dtoIndic = new DTOMovBancIndicadores();
        DTOMovimientoBancario[] movsProcesar = new DTOMovimientoBancario[2];
        movsProcesar[0] = dtoMovBanc;
        movsProcesar[1] = dtoMovBancAReasig;
        dtoIndic.setDtoMovimientosBancarios(movsProcesar);
        if (pais.getInd_sald_unic().longValue() == 1){
           dtoIndic.setIndicadorSaldoUnico(Boolean.TRUE);
        }else{
           dtoIndic.setIndicadorSaldoUnico(Boolean.FALSE);
        }
        dtoIndic.setIndicadorSimulacion(Boolean.FALSE);
        dtoIndic.setOidPais(dtoE.getOidPais());
        dtoIndic.setOidIdioma(dtoE.getOidIdioma());
        getMONActualizarCCporAplicacion().procesarMovBancporAplicacion(dtoIndic);
        }catch(Exception e) {
            UtilidadesLog.error("Error en reasignarBancos: ",e);
            if(e instanceof MareException){
                throw (MareException)e;
            }else {
                throw new MareException(e,UtilidadesError.armarCodigoError(
                                             CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }finally{
            daoCCC.eliminarBloqueo();
        }
        UtilidadesLog.debug("MONCargosAbonos.reasignarBancos(DTOReasignacionPagos dtoE) Salida");
    }

    private String armarInsertBanco(DTOMovimientoBancario dtoe){
        StringBuffer cadena = new StringBuffer();
        
        cadena.append("INSERT INTO CCC_MOVIM_BANCA ( ");
        cadena.append(" OID_MOVI_BANC, ");
        cadena.append(" SOCI_OID_SOCI, ");
        cadena.append(" SUBP_OID_MARC_CREA, "); 
        cadena.append(" TCAB_OID_ABON_CREA, "); 
        cadena.append(" CCBA_OID_CC_BANC, ");
        cadena.append(" NUM_CONS_TRAN, ");
        cadena.append(" NUM_LOTE, ");
        cadena.append(" PAIS_OID_PAIS, ");
        cadena.append(" CLIE_OID_CLIE, "); //NULO  
        cadena.append(" COD_CONS, "); //NULO 
        cadena.append(" COD_ERRO, "); //NULO
        cadena.append(" VAL_DIGI_CHEQ_FACT, ");  //NULO
        cadena.append(" VAL_ESTA_MOVI_PEND, "); //NULO
        cadena.append(" FEC_PAGO, "); //NULO
        cadena.append(" FEC_PROC, "); //NULO
        cadena.append(" VAL_HORA_PROC, "); //NULO
        cadena.append(" VAL_HORA_NORM_ADIC, "); //NULO
        cadena.append(" COD_IDEN_PROC, "); //NULO
        cadena.append(" IMP_PAGO, "); //NULO
        cadena.append(" VAL_NOMB_OFIC, "); //NULO
        cadena.append(" VAL_NUME_DOCU, "); //NULO
        cadena.append(" NUM_FACT_BOLE, "); //NULO
        cadena.append(" VAL_USUA_PROC, "); //NULO
        cadena.append(" NUM_CUPO, "); //NULO
        cadena.append(" TTRA_OID_TIPO_TRANS, "); //NULO
        cadena.append(" COD_USUA, "); //NULO
        cadena.append(" TCAB_OID_ABON_ULTI, "); //NULO
        cadena.append(" SUBP_OID_MARC_ULTI, "); //NULO
        cadena.append(" IMP_APLI, "); //NULO
        cadena.append(" IMP_SALD_PEND, "); //NULO
        cadena.append(" VAL_IMPO_MOVI, ");   //NULO
        cadena.append(" NUM_HIST, "); //NULO
        cadena.append(" VAL_OBSE , "); //NULO
        cadena.append(" COD_OFIC_RECA, "); //NULO
        cadena.append(" VAL_DOCU_CREA_ANIO, "); 
        cadena.append(" VAL_DOCU_APLI_ANIO, "); 
        cadena.append(" VAL_DOCU_CREA_MES_SERI, "); 
        cadena.append(" VAL_DOCU_APLI_MES_SERI, "); 
        cadena.append(" VAL_DOCU_CREA_NUME, "); 
        cadena.append(" VAL_DOCU_APLI_NUME, "); 
        cadena.append(" FEC_MOVI_APLI "); 
        
        cadena.append(" ) VALUES ( ");
        cadena.append(dtoe.getOid()).append(",");
        cadena.append(dtoe.getEmpresa()).append(",");
        cadena.append(dtoe.getOidSubprocesoMarcaCreacion()).append(",");
        cadena.append(dtoe.getOidTipoAbonoCreacion()).append(",");
        cadena.append(dtoe.getCuentaCorrienteBancaria()).append(",");
        cadena.append(dtoe.getConsecutivoTransaccion()).append(",");
        cadena.append(dtoe.getNumeroLote()).append(",");
        cadena.append(dtoe.getOidPais()).append(",");
        
        if(dtoe.getOidConsultoraReal()!=null){
            cadena.append(dtoe.getOidConsultoraReal()).append(",");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getCodConsultoraReal()!=null){
            cadena.append("'").append(dtoe.getCodConsultoraReal()).append("',");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getCodError()!=null){
            cadena.append("'").append(dtoe.getCodError()).append("',");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getDigitoChequeo()!=null){
            cadena.append(dtoe.getDigitoChequeo()).append(",");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getEstatusMovimientoTesoreria()!=null){
            cadena.append("'").append(dtoe.getEstatusMovimientoTesoreria()).append("',");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getFechaPago()!=null){
            cadena.append("TO_DATE('").append(sdf.format(dtoe.getFechaPago())).append("','DD/MM/YYYY')").append(",");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getFechaProceso()!=null){
            cadena.append("TO_DATE('").append(sdf.format(dtoe.getFechaProceso())).append("','DD/MM/YYYY')").append(",");
            cadena.append("TO_DATE('").append(sdf2.format(dtoe.getFechaProceso())).append("','DD/MM/YYYY HH24/MI/SS')").append(",");
        }else{
            cadena.append("null,null,");
        }
        if(dtoe.getHorario()!=null){
            cadena.append("'").append(dtoe.getHorario()).append("',");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getIdentificadorProceso()!=null){
            cadena.append("'").append(dtoe.getIdentificadorProceso()).append("',");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getImportePago()!=null){
            cadena.append(dtoe.getImportePago()).append(",");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getNombreOficina()!=null){
            cadena.append("'").append(dtoe.getNombreOficina()).append("',");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getNumeroDocumento()!=null){
            cadena.append(dtoe.getNumeroDocumento()).append(",");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getNumeroFactura()!=null){
            cadena.append(dtoe.getNumeroFactura()).append(",'");
        }else {
            cadena.append("null,");
        }
        if(dtoe.getUsuarioProceso()!=null){
            cadena.append("'").append(dtoe.getUsuarioProceso()).append("',");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getNumeroCupon()!=null){
            cadena.append(dtoe.getNumeroCupon()).append(",");
        }else {
            cadena.append("null,");
        }
        if(dtoe.getTipoTransaccion()!=null){
            cadena.append(dtoe.getTipoTransaccion()).append(",");
        }else {
            cadena.append("null,");
        }
        if(dtoe.getCodigoUsuario()!=null){
            cadena.append("'").append(dtoe.getCodigoUsuario()).append("',");
        }else{
            cadena.append("null,");
        }
        if(dtoe.getOidTipoAbonoUltimo()!=null){
            cadena.append(dtoe.getOidTipoAbonoUltimo()).append(",");
        }else {
            cadena.append("null,");
        }
        if(dtoe.getOidSubprocesoMarcaUltimo()!=null){
            cadena.append(dtoe.getOidSubprocesoMarcaUltimo()).append(",");
        }else {
            cadena.append("null,");
        }
        if(dtoe.getImporteAplicado()!=null){
            cadena.append(dtoe.getImporteAplicado()).append(",");
        }else {
            cadena.append("null,");
        }
        if(dtoe.getImporteSaldo()!=null){
            cadena.append(dtoe.getImporteSaldo()).append(",");
        }else {
            cadena.append("null,");
        }
        if(dtoe.getImporteMovimiento()!=null){
            cadena.append(dtoe.getImporteMovimiento()).append(",");
        }else {
            cadena.append("null,");
        }
        if(dtoe.getNumeroHistoria()!=null){
            cadena.append(dtoe.getNumeroHistoria()).append(",");
        }else {
            cadena.append("null,");
        }

        if(dtoe.getObservaciones()!=null){
            cadena.append("'").append(dtoe.getObservaciones()).append("',");
        }else {
            cadena.append("null,");
        }
        if(dtoe.getOficinaRecaudadora()!=null){
            cadena.append("'").append(dtoe.getOficinaRecaudadora()).append("',");
        }else{
            cadena.append("null,");
        }

        cadena.append("'").append(dtoe.getAnioDocumentoCreacion()).append("',");
        cadena.append("'").append(dtoe.getAnioDocumentoCreacion()).append("',");            
        cadena.append("'").append(dtoe.getSerieDocumentoCreacion()).append("',");
        cadena.append("'").append(dtoe.getSerieDocumentoCreacion()).append("',");
        cadena.append(dtoe.getNumeroDocumentoCreacion()).append(",");
        cadena.append(dtoe.getNumeroDocumentoCreacion()).append(",");
        cadena.append("TO_DATE('").append(sdf2.format(dtoe.getFechaMovimientoAplicacion())).append("','DD/MM/YYYY HH24/MI/SS')").append(");");
            
        return cadena.toString();
    }
    
    private String armarInsertCabeceraCargoAbono(DTOMovimientoBancario dtoe, Long oidCabecera, Integer numero)throws MareException{
        
        //DAOCCC daoCCC = new DAOCCC();

        StringBuffer insertCabecera = new StringBuffer();
        insertCabecera.append("INSERT INTO CCC_CABEC_CARGA_ABONO_DIREC ");
        insertCabecera.append("(OID_CABE_CARG,");
        insertCabecera.append("NUM_CABE,");
        insertCabecera.append("ANIO,");
        insertCabecera.append("VAL_PERI_MES,");
        insertCabecera.append("FEC_DOCU,");
        insertCabecera.append("PAIS_OID_PAIS,");
        insertCabecera.append("SOCI_OID_SOCI,");
        insertCabecera.append("COD_USUA,");
        insertCabecera.append("FEC_VALO,");
        insertCabecera.append("CCPR_OID_PROC,");
        insertCabecera.append("CCBA_OID_CUEN_CORR_BANC,");
        insertCabecera.append("VAL_OBSE) VALUES (");
        insertCabecera.append(oidCabecera).append(",");
        insertCabecera.append(numero).append(",");
        insertCabecera.append("'").append(dtoe.getAnioDocumentoCreacion()).append("',");
        insertCabecera.append("'").append(dtoe.getSerieDocumentoCreacion()).append("',");
        insertCabecera.append("TO_DATE('").append(sdf.format(dtoe.getFechaProceso())).append("','DD/MM/YYYY'),");
        insertCabecera.append(dtoe.getOidPais()).append(",");
        insertCabecera.append(dtoe.getEmpresa()).append(",");
        insertCabecera.append("'").append(dtoe.getCodigoUsuario()).append("',");
        insertCabecera.append("TO_DATE('").append(sdf.format(dtoe.getFechaPago())).append("','DD/MM/YYYY'),");
        insertCabecera.append("(SELECT OID_PROC FROM CCC_PROCE WHERE COD_PROC = '");
        insertCabecera.append(CCCConstantes.PROCESO_REASIGNACION_PAGOS_ENTRE_CONSULTORAS).append("' AND ROWNUM=1),");
        insertCabecera.append(dtoe.getCuentaCorrienteBancaria()).append(",");
        insertCabecera.append("'").append(dtoe.getNumeroLote().toString()).append("');");
        return insertCabecera.toString();
        
    }

    private String armarInsertDetalleCargoAbono(DTOMovimientoBancario dtoe, Long oidCabecera, Long tipoAbonoSubProceso){
       StringBuffer InsertDetalleCargoAbono = new StringBuffer();
       InsertDetalleCargoAbono.append("INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
       InsertDetalleCargoAbono.append("OID_DETA_CARG_ABON_DIRE,CCAD_OID_CABE_CARG,");
       InsertDetalleCargoAbono.append("NUM_LINE,COD_USUA,SOCI_OID_SOCI,TASP_OID_TIPO_ABON_SUBP,");
       InsertDetalleCargoAbono.append("CUCO_OID_CUEN_CONT_CUOT_NUEV,CUCO_OID_CUEN_CONT_CUOT_ANTE,");
       InsertDetalleCargoAbono.append("CMBA_OID_MOVI_BANC,CLIE_OID_CLIE,FEC_MOVI,");
       InsertDetalleCargoAbono.append("IMP,NUM_HIST_GENE,FEC_PAGO_BANC,IMP_MONE,CCBA_OID_CUEN_CORR_BANC");
       InsertDetalleCargoAbono.append(") VALUES (");
       InsertDetalleCargoAbono.append("CCC_DCAD_SEQ.NEXTVAL,").append(oidCabecera).append(",");
       InsertDetalleCargoAbono.append(dtoe.getConsecutivoTransaccion()).append(",");
       InsertDetalleCargoAbono.append("'").append(dtoe.getCodigoUsuario()).append("',");
       InsertDetalleCargoAbono.append(dtoe.getEmpresa()).append(",");
       InsertDetalleCargoAbono.append(tipoAbonoSubProceso).append(",");
       InsertDetalleCargoAbono.append("null").append(",");
       InsertDetalleCargoAbono.append("null").append(",");
       InsertDetalleCargoAbono.append(dtoe.getOid()).append(",");
       InsertDetalleCargoAbono.append(dtoe.getOidConsultoraReal()).append(",");
       InsertDetalleCargoAbono.append("TO_DATE('").append(sdf.format(dtoe.getFechaProceso())).append("','DD/MM/YYYY'),");
       InsertDetalleCargoAbono.append(dtoe.getImportePago()).append(",");
       InsertDetalleCargoAbono.append("0,");
       InsertDetalleCargoAbono.append("TO_DATE('").append(sdf.format(dtoe.getFechaPago())).append("','DD/MM/YYYY'),");
       InsertDetalleCargoAbono.append("0,");
       InsertDetalleCargoAbono.append(dtoe.getCuentaCorrienteBancaria()).append(");");
       
        return InsertDetalleCargoAbono.toString();
        
    }
    
    private String[] obtenerAnioMesDiaDelSistema(){
      UtilidadesLog.info("MONCargosAbonos.obtenerAnioMesDiaDelSistema(): Entrada");

      String fecha[] = new String[3];
      // Obtenemos la fecha en formato aaaa-mm-dd
      Date fechaSql = new Date(System.currentTimeMillis());
      StringTokenizer st = new StringTokenizer(fechaSql.toString(), "-");
      if (st.countTokens() > 0){
         String anio = st.nextToken().toString();
         fecha[0] = anio;
         String mes = st.nextToken().toString();
         fecha[1] = mes;
         String dia = st.nextToken().toString();
         fecha[2] = dia;
      }
      UtilidadesLog.info("MONCargosAbonos.obtenerAnioMesDiaDelSistema(): Salida");
      return fecha;
   }
    
    private MONGestorInterfacesHome getMONGestorInterfacesHome() throws NamingException {
            final InitialContext context = new InitialContext();
            return (MONGestorInterfacesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestorInterfaces"), MONGestorInterfacesHome.class);
    }
    
     private MONActualizarCCporAplicacion getMONActualizarCCporAplicacion() throws MareException{
      // Se obtiene el interfaz home
      UtilidadesLog.info("MONRecaudoEntFinBean.getMONActualizarCCporAplicacion(): Entrada");

      MONActualizarCCporAplicacionHome home = (MONActualizarCCporAplicacionHome) UtilidadesEJB.getHome("MONActualizarCCporAplicacion", MONActualizarCCporAplicacionHome.class);
      // Se obtiene el interfaz remoto
      MONActualizarCCporAplicacion ejb = null;

      try{
         ejb = home.create();
      }catch (Exception e){
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      UtilidadesLog.info("MONRecaudoEntFinBean.getMONActualizarCCporAplicacion(): Salida");
      return ejb;
   }
    
}