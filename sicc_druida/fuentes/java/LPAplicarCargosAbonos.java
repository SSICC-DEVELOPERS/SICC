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
 /*
    INDRA/CCC/PROY
    $Id: LPAplicarCargosAbonos.java,v 1.1 2009/12/03 18:32:16 pecbazalar Exp $
    DESC
 */

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ccc.DTOCargaInicialCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCasoUso;
import es.indra.sicc.dtos.ccc.DTOObtenerCargosAbonos;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LPAplicarCargosAbonos extends LPSICCBase {

	private String accion	= null;
	private boolean combosEditables = true;
	private boolean bModificar = false;

	/* Constantes */
	private String SEPARADOR_COLUMNAS = "~";

	public LPAplicarCargosAbonos() {
		super();
	}
           
	public void inicio() throws Exception {
		pagina("contenido_cargos_abonos_directos_aplicar");
        getFormatosValidaciones();
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPAplicarCargosAbonos - ejecucion ***");

		this.accion = conectorParametroLimpia("accion", "", true);

		try {
			setTrazaFichero();
			traza("accion: " + accion);
			if (accion.equals("")) {
				this.accionVacia();
				asignarAtributo("VAR", "separadorColumnas", "valor", this.SEPARADOR_COLUMNAS);
			} else if (accion.equals("aceptar")) {
				this.accionAceptar();
				asignarAtributo("VAR", "separadorColumnas", "valor", this.SEPARADOR_COLUMNAS);
			} else if (accion.equals("guardar")) {
				this.accionGuardar();
				asignarAtributo("VAR", "separadorColumnas", "valor", this.SEPARADOR_COLUMNAS);
			} else if (accion.equals("modificar")) {
				this.accionModificar();
				asignarAtributo("VAR", "separadorColumnas", "valor", this.SEPARADOR_COLUMNAS);
			} else if (accion.equals("consultar")) {
				this.accionConsultar();
				asignarAtributo("VAR", "separadorColumnas", "valor", this.SEPARADOR_COLUMNAS);
			} else if (accion.equals("borrarBloqueo")) {
				this.borrarBloqueo();
			}
		

		} catch (Exception ex) {
			this.logStackTrace(ex);
			DTOError dtoError = UtilidadesBelcorp.recuperarDatosException(ex, this);
			//¿Qué error se va a lanzar desde negocio?
			if (dtoError != null && dtoError.getCodigoError() != null && dtoError.getCodigoError().equals("23"))
				asignar("VAR", "ejecutarError", "fLimpiar()");
			this.lanzarPaginaError(ex);
  
		}
		traza("*** Salida - LPAplicarCargosAbonos - ejecucion ***");
	} 

	private void borrarBloqueo() throws Exception  {
		traza("*** Entrada - LPAplicarCargosAbonos - borrarBloqueo ***");
		pagina("salidaGenerica");

        Vector paramEntrada = new Vector();
		DTOBelcorp dto = new DTOBelcorp();
       
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("CCCEliminarBloqueo"));

		DruidaConector conector = conectar("ConectorEliminarBloqueo", paramEntrada);          


		traza("*** Salida - LPAplicarCargosAbonos - borrarBloqueo ***");	
	}
	
	private void accionVacia()  throws Exception  {
		traza("*** Entrada - LPAplicarCargosAbonos - accionVacia ***");

        /*mdolce Para validar la concurrencia de procesos de CCC*/
		Vector paramEntradaValidar = new Vector();
		DTOBelcorp dtoValidar = new DTOBelcorp();
		/*uso el atributo pais para poder diferenciar luego en el mon que descripcion insertar
					  uso ese atributo para no modificar todo, solo envio una constante y no la uso como pais*/
		dtoValidar.setOidPais(new Long("1"));

		paramEntradaValidar.add(dtoValidar);
		paramEntradaValidar.add(new MareBusinessID("CCCInsertarBloqueo"));  

		DruidaConector conectorValidar = conectar("ConectorRecuperarDatosInicialesCargosAbonos", paramEntradaValidar);

        /*Fin validacion concurrencia*/
		
		//Poner en el campo modificable el valor "true" 
		asignar("VAR", "modificable", "true");
		
		Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
		asignar("VAR", "longitudCodigoCliente", longitudCodigoCliente.toString());
		

		this.generarHiddenFormatoFecha();
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);

		traza("paso 1");
		Long idioma = UtilidadesSession.getIdioma(this);
		asignar("VAR", "idioma", idioma.toString());
		traza("paso 2");
		Long pais = UtilidadesSession.getPais(this);
		asignar("VAR", "pais", pais.toString());
		traza("paso 3");
		Long canal = UtilidadesSession.getCanalPorDefecto(this);
		if (canal != null) {
			asignar("VAR", "canal", canal.toString());
			traza("paso 4");
		}

		Long empresa = null;
		try {
			empresa = UtilidadesSession.getSociedadPorDefecto(this);
			traza("La sociedad por defecto es: " +  empresa);
			if (empresa != null) {
				asignar("VAR", "empresa", empresa.toString());
				traza("paso 5");
			}
		} catch (Exception e) {
		}
		
		Long subacceso = null;
		try {
	 		subacceso = UtilidadesSession.getSubaccesoPorDefecto(this);
			if (subacceso != null) {
				asignar("VAR", "subacceso", subacceso.toString());
				traza("paso 6");
			}
		} catch (Exception e) {
		}

		Vector paramEntrada = new Vector();
		DTOCasoUso dto = new DTOCasoUso();
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		if(!this.bModificar){
			dto.setCasoUso("AplicarCargosAbonos");
		}else{
			dto.setCasoUso("ModificarCargosAbonos");
		}

		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("CCCObtenerDatosInicialesCargosAbonos"));
           
		DruidaConector conector = conectar("ConectorRecuperarDatosInicialesCargosAbonos", paramEntrada);
		//Con el DTOCargaInicialCargosAbonos que obtenemos, con sus atributos rellenamos los compontes: numeroIdentificacion, proceso, empresa y canal. 
		DTOCargaInicialCargosAbonos dtoSalida = (DTOCargaInicialCargosAbonos)conector.objeto("DTOCargaInicialCargosAbonos");
		traza("paso 7");
			
		//Se cargan combos si "combosEditables" es true
		if (combosEditables) {
			String fecha = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
			asignar("LABELC", "lblFechaDocumento", fecha);
			asignar("VAR", "htxtFechaDocumento", fecha);

			traza("***  accionVacia -> combosEditables = true ***");
			asignar("TEXT", "txtFechaValor", fecha);
			asignar("VAR", "htxtFechaValor", fecha);

			String mes = UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"MM");
			asignar("LABELC","lblvalorMes",mes);
			String anio = UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"yy");
			asignar("LABELC","lblvalorAnio",anio);
			/** Ahora el numero de identificacion se carga en la accion "aceptar"
			if (dtoSalida.getNumeroIdentificacion() != null) {
				asignar("LABELC", "lblvalorNIdentificacion", dtoSalida.getNumeroIdentificacion().toString());
				asignar("VAR", "NIdentificacion", dtoSalida.getNumeroIdentificacion().toString());
			}*/

			RecordSet rs = dtoSalida.getEmpresas();
			if (rs != null && !rs.esVacio()) {
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
				if (empresa!=null){
					asignar("COMBO", "cbEmpresa", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), empresa.toString());
				}else{
					asignar("COMBO", "cbEmpresa", conectorCargaCombo, "DTOSalida.combo_ROWSET"); 
				}
        	}
			rs = dtoSalida.getProcesos();
			if (rs != null && !rs.esVacio()) {
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
				asignar("COMBO", "cbAplicacion", conectorCargaCombo, "DTOSalida.combo_ROWSET");
        	}
			rs = dtoSalida.getCanales();
			if (rs != null && !rs.esVacio()) {
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
				if (canal!=null){
					asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), canal.toString());
				}else{
					asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET");
				}
        	}
		}
			//Los RecordSets de accesos y subaccesos los guardamos en listas ocultas para recargar dinámicamente
			RecordSet rs = dtoSalida.getAccesos();
			if (rs != null && !rs.esVacio()) {
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "datosAccesos", rs, cols);
        		asignar("MATRIZJS", "datosAccesos", conectorCargaCombo); 
        	}
			
			traza("*** Cargada Matriz ***");

			rs = dtoSalida.getSubaccesos();
			if (rs != null && !rs.esVacio()) {
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "datosSubaccesos", rs, cols);
        		asignar("MATRIZJS", "datosSubaccesos", conectorCargaCombo); 
        	}
 
 		if (dtoSalida.getTasaCambioMonedaAlternativa() != null) {
			asignar("VAR", "tasaCambioMonedaAlternativa", dtoSalida.getTasaCambioMonedaAlternativa().toString());
		}
       
		getConfiguracionMenu("LPAplicarCargosAbonos", "insertar");
		traza("*** Salida - LPAplicarCargosAbonos - accionVacia ***");
	}


	private void accionAceptar()  throws Exception  {
		traza("Entrada - LPAplicarCargosAbonos - accionAceptar");
		Long idioma = UtilidadesSession.getIdioma(this);
		Long pais = UtilidadesSession.getPais(this);
		traza("idioma " + idioma + "pais " + pais );
		Integer nIdentif = buscaNIdentificarion (pais,idioma);
		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "postAceptar(" + nIdentif.toString() + ")");
	}


	private void accionGuardar()  throws Exception  {
		traza("*** Entrada - LPAplicarCargosAbonos - accionGuardar ***");
/*
//Comprobar bloqueos (Puede haber expirado el tiempo de uso y 
//estar bloqueados por otro usuario). 
//Si esto ocurre le mostramos un mensaje de error indicando que 
//debe comenzar de nuevo y vaciamos las tablas de todas las 
//capas con las que estamos trabajando. 

//En caso de que el tiempo de bloqueo no se haya superado 
Creamos un DTOOIDs con los oids de Mov.CC para el 
subproceso=1 (Cancelación de cuotas). 
idBusiness = "CCCEliminarBloqueosMovCC" 
Llamamos al "ConectorEliminarBloqueosMovCC" con el dto y el idBusiness 

Creamos un DTOOIDs con los oids de Mov.Banc para el 
subproceso=2 (Aplicación de cobros). 
idBusiness = "CCCEliminarBloqueosMovBanc" 
Llamamos al "ConectorEliminarBloqueosMovBanc" con el dto y el idBusiness 
*/
				/* YYY DEBUG */
				String cancelacionCuotasCadena= conectorParametroLimpia("cancelacionCuotas", "", true);
				String aplicacionCobrosCadena= conectorParametroLimpia("aplicacionCobros", "", true);
				String aplicacionGastosCadena= conectorParametroLimpia("aplicacionGastos", "", true);
				String generacionVencimientosCadena= conectorParametroLimpia("generacionVencimientos", "", true);

				traza("cancelacionCuotas: " + cancelacionCuotasCadena);
				traza("aplicacionCobros: " + aplicacionCobrosCadena);
				traza("aplicacionGastos: " + aplicacionGastosCadena);
				traza("generacionVencimientos: " + generacionVencimientosCadena);
				/* YYY FIN DEBUG */
		
		//Creamos un DTOCargosAbonos 
		DTOCargosAbonos dtoCargosAbonos = new DTOCargosAbonos();

		//Por cada lista creamos un RecordSet y lo ponemos en el atributo correspondiente del DTOCargosAbonos: cancelacionCuotas, aplicacionCobros, conceptosGastosAbonos o generacionVencimientos. 
		//Rellenamos el resto de los atributos del dto con los campos correspondientes de la pantalla. 
		Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);
		dtoCargosAbonos.setOidPais(pais);
		dtoCargosAbonos.setOidIdioma(idioma);
		String parametro = conectorParametroLimpia("NIdentificacion", "", true);
		traza("***** identificacion *****"+ parametro);
		//parametro="1";
		if(!parametro.equals(""))
			dtoCargosAbonos.setNumeroIdentificacion(Integer.valueOf(parametro));  

		parametro = conectorParametroLimpia("txtCodCliente", "", true);
		traza("***** codigoCliente *****"+ parametro);
		//parametro="000000000001270";
		if(!parametro.equals(""))
			dtoCargosAbonos.setCodigoCliente(parametro);

		parametro = conectorParametroLimpia("htxtFechaDocumento", "", true);
        String fechaDocumento = conectorParametroLimpia("htxtFechaDocumento", "", true);
		traza("***** fechaDocumento *****"+ parametro);
        
        
		//parametro="06/05/2004";
			if(!parametro.equals(""))
				dtoCargosAbonos.setFechaDocumento(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));
				
		parametro = conectorParametroLimpia("txtFechaValor", "", true);
		traza("***** fechaValor *****"+ parametro);
		//parametro="06/05/2004";
			if(!parametro.equals(""))
				dtoCargosAbonos.setFechaValor(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));

		parametro = conectorParametroLimpia("cbEmpresa", "", true);
		traza("***** empresa *****"+ parametro);
		//parametro="1";
			if(!parametro.equals(""))
				dtoCargosAbonos.setEmpresa(Long.valueOf(parametro));
				
		parametro = conectorParametroLimpia("txtReferenciaExterna", "", true);
		traza("***** referenciaExterna *****"+ parametro);
		//parametro="";
			if(!parametro.equals(""))
				dtoCargosAbonos.setReferenciaExterna(parametro);
				
		parametro = conectorParametroLimpia("cbSubacceso", "", true);
		traza("***** subacceso *****"+ parametro);
		//parametro="1";
			if(!parametro.equals(""))
				dtoCargosAbonos.setSubacceso(Long.valueOf(parametro));
				
		parametro = conectorParametroLimpia("cbAcceso", "", true);
		traza("***** acceso *****"+ parametro);
		//parametro="1";
			if(!parametro.equals(""))
				dtoCargosAbonos.setAcceso(Long.valueOf(parametro));
				
		parametro = conectorParametroLimpia("areatxtObservaciones", "", true);
		traza("***** textArea *****"+ parametro);
		//parametro="";
			if(!parametro.equals(""))
				dtoCargosAbonos.setObservaciones(parametro);

		RecordSet rs = null;
		StringTokenizer st = null;
        
        // 1 - CANCELACION CUOTAS QQ
		parametro = conectorParametroLimpia("cancelacionCuotas", "", true);
		traza("**********parametro: " + parametro);
		rs = new RecordSet();
		
        
        ArrayList al = null;
        HashMap linea = null;
        Vector vFila = null;
        Iterator i = null;
        
		if(!parametro.equals("")) {
			rs.addColumn("codigoCliente");
			rs.addColumn("canal");
			rs.addColumn("acceso");
			rs.addColumn("subacceso");
			rs.addColumn("numeroDocumento");
			rs.addColumn("numeroOrdenCuota");
			rs.addColumn("fechaDocumento");
			rs.addColumn("fechaVencimiento");
			rs.addColumn("medioPagoTeor");
			rs.addColumn("importe");
			rs.addColumn("importeAplicado");
			rs.addColumn("importePendiente");
			rs.addColumn("divisa");
			rs.addColumn("importeDivisa");
			rs.addColumn("importeAplicar");
			rs.addColumn("medioPagoOid");
			rs.addColumn("OID");
			//rs.addColumn("oidDetalle");
			//20 columnas
            
            //parseo del string ------------------------------------------------
            
            al = this.parseaLista(parametro);
            linea = null;
            vFila = null;
            i = al.iterator();
            
            while (i.hasNext()){
                linea = (HashMap)i.next();
                vFila = new Vector();
                vFila.add(linea.get("Cód. cliente"));
                vFila.add(linea.get("Canal"));
                vFila.add(linea.get("Acceso"));
                vFila.add(linea.get("Subacceso"));
                vFila.add(linea.get("Nº documento"));
                vFila.add(linea.get("Nº orden cuota"));
                vFila.add(conectorParametroFechaString((String)linea.get("Fecha doc.")));
                vFila.add(conectorParametroFechaString((String)linea.get("Fecha vencimiento")));
                vFila.add(linea.get("Medio pago teórico"));
                vFila.add(desFormatearNumero((String)linea.get("Importe cuota"),LPSICCBase.FORMATO_MONEDA));
                vFila.add(desFormatearNumero((String)linea.get("Importe aplicado"),LPSICCBase.FORMATO_MONEDA));
                vFila.add(desFormatearNumero((String)linea.get("Importe pendiente"), LPSICCBase.FORMATO_MONEDA));
                vFila.add(linea.get("Divisa"));
                vFila.add(desFormatearNumero((String)linea.get("Importe divisa"), LPSICCBase.FORMATO_MONEDA));
                vFila.add(desFormatearNumero((String)linea.get("Importe a aplicar"), LPSICCBase.FORMATO_MONEDA));
                vFila.add(linea.get("medioPagoOid"));
                
                if (linea.get("oidMovimiento") != null && !linea.get("oidMovimiento").equals("")){
                    vFila.add(linea.get("oidMovimiento").toString());
                } else {
                    vFila.add(null);
                }
                
				rs.addRow(vFila);
            }
		}
        
        traza("RecordSet de CANCELACION CUOTAS: " + rs);
        
		dtoCargosAbonos.setCancelacionCuotas(rs);

        // ---------------------------------------------------------------------
		
        // 2 - APLICACION COBROS QQ
		parametro = conectorParametroLimpia("aplicacionCobros", "", true);
		rs = new RecordSet();

		if (!parametro.equals("")) {
            rs.addColumn("codigoCliente");
            rs.addColumn("cuentaCorrienteDesc");
            rs.addColumn("fechaPago");
            rs.addColumn("numeroLote");
            rs.addColumn("consecutivoTransaccion");
            rs.addColumn("importePago");
            rs.addColumn("importePendiente");
            rs.addColumn("importeAplicar");
            rs.addColumn("cuentaCorrienteoid");
            rs.addColumn("OID");
            rs.addColumn("oidDetalle");

            al = this.parseaLista(parametro);
            linea = null;
            vFila = null;
            i = al.iterator();

            while (i.hasNext()){
                linea = (HashMap)i.next();
                vFila = new Vector();
                vFila.add(linea.get("Cód. cliente"));
                vFila.add(linea.get("Cuenta corriente bancaria"));
                vFila.add(conectorParametroFechaString((String)linea.get("Fecha pago")));
                vFila.add(linea.get("Nº lote"));
                vFila.add(linea.get("Consecutivo transacción"));
                vFila.add(desFormatearNumero((String)linea.get("Importe pago"), LPSICCBase.FORMATO_MONEDA));
                vFila.add(desFormatearNumero((String)linea.get("Importe pendiente"), LPSICCBase.FORMATO_MONEDA));
                vFila.add(desFormatearNumero((String)linea.get("Importe a aplicar"), LPSICCBase.FORMATO_MONEDA));

				//Modificado por cvalenzu - 15/12/2006
				//Incidencia bloqueante - V-CCC-030
				//Comentario: Aparecia el siguiente error en la parte servidora porque no 
				//estaba formateado este oid: java.lang.NumberFormatException: For input string: "2,026"
				String tmpOid = desFormatearNumero((String)linea.get("cuentaCorrienteOid"), this.FORMATO_DEFAULT);
		        traza("************ tmpOid **********" + tmpOid);
				vFila.add(tmpOid);
                //vFila.add(linea.get("cuentaCorrienteOid"));
				//FIN - Modificado por cvalenzu - 15/12/2006
                
                if (linea.get("oidMovimiento") != null && !linea.get("oidMovimiento").equals("")){
                    vFila.add(linea.get("oidMovimiento").toString());
                } else {
                    vFila.add(null);
                }
                
                vFila.add(linea.get("oidDetalle"));
                rs.addRow(vFila);
            }
		}
        
        traza("RecordSet de CANCELACION COBROS: " + rs);
        
		dtoCargosAbonos.setAplicacionCobros(rs);
        
        // ---------------------------------------------------------------------
        
        // 3 - APLICACION GASTOS QQ
		parametro = conectorParametroLimpia("aplicacionGastos", "", true);
		traza("parametro  * aplicacionGastos  * " + parametro);

		rs = new RecordSet();
        
 		            
		if(!parametro.equals("")) {
            rs.addColumn("codigoCliente");
            rs.addColumn("cuentaCorrienteDesc");
            rs.addColumn("tipoAbono");
            rs.addColumn("glosaContable");
            rs.addColumn("divisa");
            rs.addColumn("importe");
            rs.addColumn("importeDivisa");
            rs.addColumn("cuentaCorrienteoid");
            rs.addColumn("tipoAbonoOid");
            rs.addColumn("oidDetalle");
            //--Agregado incidencia BELC300015345
            rs.addColumn("fechaPago");

            al = this.parseaLista(parametro);
            linea = null;
            vFila = null;
            i = al.iterator();

            while (i.hasNext()){
                linea = (HashMap)i.next();
                vFila = new Vector();
                vFila.add(linea.get("Cód. cliente"));
                vFila.add(linea.get("CCC"));
                vFila.add(linea.get("Tipo abono"));
                vFila.add(linea.get("Glosa contable"));
                vFila.add(linea.get("Divisa"));
                vFila.add(desFormatearNumero((String)linea.get("Importe"), LPSICCBase.FORMATO_MONEDA));
                vFila.add(desFormatearNumero((String)linea.get("Importe divisa"), LPSICCBase.FORMATO_MONEDA));
                vFila.add(linea.get("cuentaCorrienteOid"));
                vFila.add(linea.get("tipoAbonoOid"));
                vFila.add(linea.get("oidDetalle"));
                //vFila.add(linea.get("")); yyy FALTA!!! TIENE QUE VENIR DE LA PAGINA
                rs.addRow(vFila);
            }
		}

        traza("RecordSet de APLICACION GASTOS: " + rs);

		dtoCargosAbonos.setConceptosGastosAbonos(rs);

        // ---------------------------------------------------------------------
		
        // 4 - GENERACION VENCIMIENTOS QQ
		parametro = conectorParametroLimpia("generacionVencimientos", "", true);
		traza("***** linea de parametros *****"+ parametro);
		rs = new RecordSet();
		//traza(rs.getRowCount()+"");
        
 		
		if(!parametro.equals("")) {
            rs.addColumn("codigoCliente");
            rs.addColumn("marca");
            rs.addColumn("canal");
            rs.addColumn("acceso");
            rs.addColumn("subacceso");
            rs.addColumn("numeroDocumento");
            rs.addColumn("referenciaExterna");
            rs.addColumn("fechaDocumento");
            rs.addColumn("fechaVencimiento");
            rs.addColumn("medioPagoDesc");
            rs.addColumn("divisa");
            rs.addColumn("importe");
            rs.addColumn("importeDivisa");
            rs.addColumn("observaciones");
            rs.addColumn("medioPagoOid");
            rs.addColumn("marcaOid");
            rs.addColumn("canalOid");
            rs.addColumn("accesoOid");
            rs.addColumn("subaccesoOid");
            rs.addColumn("oidMovimiento");
            rs.addColumn("oidDetalle");
            
            al = this.parseaLista(parametro);
            linea = null;
            vFila = null;
            i = al.iterator();

            while (i.hasNext()){
                linea = (HashMap)i.next();
                vFila = new Vector();
                vFila.add(linea.get("Cód. cliente"));
                vFila.add(linea.get("Marca"));
                vFila.add(linea.get("Canal"));
                vFila.add(linea.get("Acceso"));
                vFila.add(linea.get("Subacceso"));
                vFila.add(linea.get("Nº documento"));
                vFila.add(linea.get("Referencia externa"));
                vFila.add(conectorParametroFechaString((String)linea.get("Fecha valor")));
                vFila.add(conectorParametroFechaString((String)linea.get("Fecha vencimiento")));
                vFila.add(linea.get("Medio pago teórico"));
                vFila.add(linea.get("Divisa"));
                vFila.add(desFormatearNumero((String)linea.get("Importe"), LPSICCBase.FORMATO_MONEDA));
                vFila.add(desFormatearNumero((String)linea.get("Importe divisa"), LPSICCBase.FORMATO_MONEDA));
                vFila.add(linea.get("Observaciones"));
                vFila.add(linea.get("medioPagoOid"));
                vFila.add(linea.get("marcaOid"));
                vFila.add(linea.get("canalOid"));
                vFila.add(linea.get("accesoOid"));
                vFila.add(linea.get("subaccesoOid"));
                vFila.add(linea.get("oidMovimiento"));
                vFila.add(linea.get("oidDetalle"));
                rs.addRow(vFila);
            }
		}
        
        traza("RecordSet de GENERACION VENCIMIENTOS: " + rs);
        
		dtoCargosAbonos.setGeneracionVencimientos(rs);

		parametro = conectorParametroLimpia("oid", "", true);
		traza("oid: " + parametro);
		//parametro="";
			if(!parametro.equals(""))
				dtoCargosAbonos.setOid(Long.valueOf(parametro));
				
		parametro = conectorParametroLimpia("cbAplicacion", "", true);
		//parametro="1";
			if(!parametro.equals(""))
				dtoCargosAbonos.setProceso(Long.valueOf(parametro));
								
		parametro = conectorParametroLimpia("cbCanal", "", true);
		//parametro="1";
			if(!parametro.equals(""))
				dtoCargosAbonos.setCanal(Long.valueOf(parametro));
				
		parametro = conectorParametroLimpia("cbAcceso", "", true);
		//parametro="1";
			if(!parametro.equals(""))
				dtoCargosAbonos.setAcceso(Long.valueOf(parametro));
				
		traza("***************** dto " + dtoCargosAbonos.toString());
		
		//traza(dtoCargosAbonos.getCancelacionCuotas().toString());

		//traza(dtoCargosAbonos.getGeneracionVencimientos().toString());
		
		//traza(dtoCargosAbonos.getAplicacionCobros().toString());
		
		//traza(dtoCargosAbonos.getConceptosGastosAbonos().toString());
		
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoCargosAbonos);
		paramEntrada.add(new MareBusinessID("CCCGuardarCargosAbonos"));
		//traza ("++++ Parametros: "+paramEntrada);
		DruidaConector conector = conectar("ConectorAplicarCargosAbonos", paramEntrada);
		
		String casoUso = conectorParametroLimpia("casoUso", "", true);
		/*if (casoUso.equals("modificar")) {
			asignar("VAR", "cerrarVentana", "true");
		} else{
			if (!casoUso.equals("")) {
				conectorActionOpener(true);
  				conectorAction("LPAplicarCargosAbonos"); //nombre de la LP con la que estamos insertando.
			}else{
				Integer nIdentif = buscaNIdentificarion (pais,idioma);
				if (nIdentif !=null){
					asignarAtributo("VAR","ejecutar","valor","postGuardado("+ nIdentif + ")");
				}else{
					conectorActionOpener(true);
		 			conectorAction("LPAplicarCargosAbonos"); //nombre de la LP con la que estamos insertando.
				}
				
			}
		}*/

				pagina("salidaGenerica");
				asignar("VAR", "cerrarVentana", "S");
				asignar("VAR", "ejecutarError", "insercionIncorrecta()");

		if (!casoUso.equals("modificar")) {
			conectorActionOpener(true);
			conectorAction("LPAplicarCargosAbonos"); 
		} else{
			  asignar("VAR", "cerrarVentana", "true");
		}
		traza("*** Salida - LPAplicarCargosAbonos - accionGuardar ***");
	}
	
	private Integer buscaNIdentificarion (Long pais, Long idioma)throws Exception {
		DTOCasoUso dto = new DTOCasoUso();
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		Integer retorno = null;
		if(!this.bModificar){
			dto.setCasoUso("AplicarCargosAbonos");
		}else{
			dto.setCasoUso("ModificarCargosAbonos");
		}
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("CCCObtenerNumeroIdentificacion"));
           
		DruidaConector conector = conectar("ConectorObtenerNumeroIdentificacion", paramEntrada);
		DTOCargaInicialCargosAbonos dtoSalida = (DTOCargaInicialCargosAbonos)conector.objeto("DTOCargaInicialCargosAbonos");

		if (dtoSalida.getNumeroIdentificacion() != null) {
			 retorno = dtoSalida.getNumeroIdentificacion();
		}
		return retorno;
	}

    private ArrayList parseaLista(String sXml) throws Exception {
        traza("LPOperacionReclamos.parseaLista(): Entrada");
        traza("sxml: " + sXml);
        String sPropiedadActual = null;
        String sValorCampo = null;
        String sPropiedad = null;
        Node nodeDoc = null;        
        Node nodoRow = null;
        Node nodoCampo = null;
        Node textNode = null;
        NodeList nodeList = null;
        NodeList nodeListCampos = null;
        HashMap hshAtributos = new HashMap();
        DocumentBuilder docBuilder = null;
        
        Object obj = null;
   
        ArrayList posicionesOperacion = new ArrayList();

		// sXml = sXml.replaceAll("/&/gi", "&amp;").replaceAll("/\'/gi", "&apos;").replaceAll("/</gi", "&lt;").replaceAll("/>/gi","&gt;").replaceAll("/\"/gi", "&quot;");
		sXml = sXml.replaceAll("&", "&amp;");
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sXml.getBytes());
        
        nodeDoc = docBuilder.parse(inputStream).getFirstChild();
        traza("nodeDoc: " + nodeDoc.getNodeName());
        nodeList = nodeDoc.getOwnerDocument().getElementsByTagName("ROW");
        //nodeDoc.getChildNodes(); 
        long cantElems = nodeList.getLength();
        traza("cantElems: " + cantElems);
        /* Recorro tags <ROW> */        
        for (int i=0; i<cantElems; i++) {
            hshAtributos = new HashMap();
            nodoRow = nodeList.item(i);
            nodeListCampos = nodoRow.getChildNodes();
            long cantCampos = nodeListCampos.getLength();
            /* Recorro tags <CAMPO> */
            for (int j=0; j<cantCampos; j++) {
                nodoCampo = nodeListCampos.item(j);
                sPropiedad = this.obtenerPropiedadCampo(nodoCampo);
                sValorCampo = this.obtenerValorCampo(nodoCampo);
                hshAtributos.put(sPropiedad, sValorCampo);
            }
            
            posicionesOperacion.add(hshAtributos);
        }
        
        traza("LPOperacionReclamos.parseaLista(): Salida");
        
        return posicionesOperacion;
    }
    
    private String obtenerPropiedadCampo(Node nodo) throws Exception {
        NamedNodeMap nodeMap = nodo.getAttributes();
        Node nAtributo = nodeMap.getNamedItem("nombre");
        String sValorAtributo = nAtributo.getNodeValue();
        return sValorAtributo;
    }
    
    private String obtenerValorCampo(Node nodo) throws Exception {
        Node textNode = nodo.getFirstChild();
        String sValorCampo = null;
        
        if (textNode != null) { 
            sValorCampo = textNode.getNodeValue();
        } else {
            sValorCampo = "";
        }
        return sValorCampo;
    }
    
    
    
    
    
	
	private void accionConsultar()  throws Exception {
		traza("*** Entrada - LPAplicarCargosAbonos - accionConsultar ***");
		
		//Asignamos el valor false al campo oculto "modificable" 
		asignar("VAR", "modificable", "false");
		asignar("VAR", "casoUso", "consultar");
		
		//Deshabilitamos todos los campos de la pantalla salvo el combo subprocesos
		deshabilitaCampos();
		
		//Deshabilitamos todos los campos de las listas
		deshabilitaListas();

		//Insertamos un Javascript para que cuando se carga la pantalla se llame al metodo Javascript: recalcular() 
		asignarAtributoPagina("onload", "onLoadPag();recalcular();");
		asignarAtributo("CAPA", "capaImportes", "visibilidad", "visible");
		
		//llamamos a cargarDatos pasandole el oid recibido y el parametro modificar a false
		Long oid = Long.valueOf(conectorParametroLimpia("oid", "", true));
		traza("*** OID ***"+ oid);
		cargaDatos(oid, false);
		
		getConfiguracionMenu("LPAplicarCargosAbonos", "consultar");
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
		
		// Dependiendo del caso de uso, se pondrá un titulo u otro en la página
		String casoUso = conectorParametroLimpia("casoUso","",true);
		if (casoUso.equals("consultar")) {
			asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","cod","0174");
			asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","msgle","0174");
		} else if (casoUso.equals("eliminar")) {
			asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","cod","0357");
			asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","msgle","0357");
		}
		
		traza("*** Salida - LPAplicarCargosAbonos - accionConsultar ***");
	} 

	private void accionModificar() throws Exception  {
		traza("*** Entrada - LPAplicarCargosAbonos - accionModificar ***");
		
		this.combosEditables = false;
		this.bModificar = true;
		asignar("VAR", "casoUso", "modificar");
		
		accionVacia(); 
		
		//Insertamos un Javascript para que cuando se carga la pantalla se llame al metodo Javascript: recalcular() 
		asignarAtributoPagina("onload", "onLoadPag();recalcular();");
		asignarAtributo("CAPA", "capaImportes", "visibilidad", "visible");
		
		//Deshabilitamos todos los campos de la pantalla salvo el combo subprocesos
		deshabilitaCampos();
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);

		//llamamos a cargarDatos pasandole el oid recibido y el parametro modificar a true
		Long oid = Long.valueOf(conectorParametroLimpia("oid", "", true));
		cargaDatos(oid,true);
		
		getConfiguracionMenu("LPAplicarCargosAbonos", "modificar");
		asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","cod","0358");
		asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","msgle","0358");
		
		traza("*** Salida - LPAplicarCargosAbonos - accionModificar ***");
	}


	private void deshabilitaCampos() throws Exception  {
		traza("*** Entrada - LPAplicarCargosAbonos - deshabilitaCampos ***");
		
		asignarAtributoElemento("cbAplicacion", "disabled", "S");
		asignarAtributoElemento("cbEmpresa", "disabled", "S");
		asignarAtributoElemento("cbCanal", "disabled", "S");
		asignarAtributoElemento("cbAcceso", "disabled", "S");
		asignarAtributoElemento("cbSubacceso", "disabled", "S");
		asignarAtributoElemento("txtCodCliente", "disabled", "S");
		asignarAtributoElemento("txtFechaValor", "disabled", "S");
		asignarAtributoElemento("txtReferenciaExterna", "disabled", "S");
		asignarAtributoElemento("areatxtObservaciones", "disabled", "S");
		
		traza("*** Salida - LPAplicarCargosAbonos - deshabilitaCampos ***");
	}

	private void deshabilitaListas()  throws Exception  {
		traza("*** Entrada - LPAplicarCargosAbonos - deshabilitaListas ***");
		
		asignarAtributo("COL", "Texto1", "deshabilitado", "S");
		asignarAtributo("COL", "Texto2", "deshabilitado", "S");
		asignarAtributo("COL", "Texto3", "deshabilitado", "S");
		asignarAtributo("COL", "Texto4", "deshabilitado", "S");
		asignarAtributo("COL", "Texto5", "deshabilitado", "S");
		asignarAtributo("COL", "Texto6", "deshabilitado", "S");
		asignarAtributo("COL", "Fechavalor", "deshabilitado", "S");
		asignarAtributo("COL", "Fechavencimiento", "deshabilitado", "S");
		
		traza("*** Salida - LPAplicarCargosAbonos - deshabilitaListas ***");
	}

	private void cargaDatos(Long oid, boolean modificar) throws Exception {
		traza("*** Entrada - LPAplicarCargosAbonos - cargaDatos ***");
		
		// Se obtiene el pais y el idioma de sesión
		Long idioma = UtilidadesSession.getIdioma(this);
		Long pais = UtilidadesSession.getPais(this);
		traza("*** PAIS ***"+ pais); 
		traza("*** IDIOMA ***"+ idioma); 
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());
		
		// Creamos un DTOObtenerCargosAbonos y lo rellenamos con los parametros recibidos.
		DTOObtenerCargosAbonos dtoObtenerCargosAbonos = new DTOObtenerCargosAbonos();
		dtoObtenerCargosAbonos.setOidIdioma(idioma);
		dtoObtenerCargosAbonos.setOidPais(pais);
		dtoObtenerCargosAbonos.setOid(oid);
		dtoObtenerCargosAbonos.setModificar(new Boolean(modificar));

		// idBusiness = "CCCConsultarCargosAbonos" 
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoObtenerCargosAbonos);
		paramEntrada.add(new MareBusinessID("CCCConsultarCargosAbonos"));

		// Llamamos al ConectorObtenerCargosAbonos y con el dto rellenamos los 
		// campos de la pantalla correspondientes     
		traza("*** Llamando  conector ***");      
        DruidaConector conector = conectar("ConectorObtenerCargosAbonos", paramEntrada);
        traza("*** conector llamado ***"); 
		DTOCargosAbonos dtoCargosAbonos = (DTOCargosAbonos)conector.objeto("DTOCargosAbonos");
		traza("*** cargado DTOCargosAbonos ***"); 
		
		// Carga los combos empresa, proceso, acceso, subacceso y canal
		cargaCombos(dtoCargosAbonos);
		
		// Rellena los campos de texto y las etiquetas de la pagina
        if (dtoCargosAbonos.getNumeroIdentificacion() != null) {
			asignar("LABELC", "lblvalorNIdentificacion", dtoCargosAbonos.getNumeroIdentificacion().toString());
			asignar("VAR", "NIdentificacion", dtoCargosAbonos.getNumeroIdentificacion().toString());
		}
        if (dtoCargosAbonos.getCodigoCliente() != null) {
			asignar("TEXT", "txtCodCliente", dtoCargosAbonos.getCodigoCliente());
		}
        if (dtoCargosAbonos.getFechaDocumento() != null) {
        	String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        	String fechaDocumento = UtilidadesBelcorp.fechaFormateada(dtoCargosAbonos.getFechaDocumento(),formatoFecha);
			//asignar("TEXT", "txtFechaDocumento", fechaDocumento);
			asignar("LABELC", "lblFechaDocumento", fechaDocumento);
			asignar("VAR", "htxtFechaDocumento", fechaDocumento);
		}
        if (dtoCargosAbonos.getFechaValor() != null) {
        	String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        	String fechaValor = UtilidadesBelcorp.fechaFormateada(dtoCargosAbonos.getFechaValor(),formatoFecha);
			asignar("TEXT", "txtFechaValor", fechaValor);
			//asignar("LABELC", "lblFechaDocumento", fechaDocumento);
			asignar("VAR", "htxtFechaValor", fechaValor);
		}
        if (dtoCargosAbonos.getReferenciaExterna() != null) {
			asignar("TEXT", "txtReferenciaExterna", dtoCargosAbonos.getReferenciaExterna());
		}
        if (dtoCargosAbonos.getObservaciones() != null) {
			asignar("AREATEXTO", "areatxtObservaciones", dtoCargosAbonos.getObservaciones());
		}
		if(dtoCargosAbonos.getMes() != null){
			if(dtoCargosAbonos.getMes().intValue() < 10){
				String mes = "0" + dtoCargosAbonos.getMes().toString();
				asignar("LABELC",  "lblvalorMes", mes);
			}else{
				asignar("LABELC", "lblvalorMes", dtoCargosAbonos.getMes().toString());
			}
		}
		if(dtoCargosAbonos.getAnio() != null){
			if(dtoCargosAbonos.getAnio().intValue() < 10){

				String anio = "0" + dtoCargosAbonos.getAnio().toString();
				asignar("LABELC", "lblvalorAnio", anio);
			}else{
				asignar("LABELC", "lblvalorAnio", dtoCargosAbonos.getAnio().toString());
			}
		}
		
		// Carga las listas editables
		cargaListas(dtoCargosAbonos);
		
        if (dtoCargosAbonos.getOid() != null) {
			asignar("VAR", "oid", dtoCargosAbonos.getOid().toString());
		}
		
		// Cargamos el combo de subprocesos 
		// -idBusiness /CCCRecargaSubprocesos
		// -Creamos un DTOOID y metemos el valor del atributo proceso del dto que hemos obtenido en la llamada anterior. 	
		DTOOID dto = new DTOOID();
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		dto.setOid(dtoCargosAbonos.getProceso());
		traza("*** proceso a pasar ***"+ dto.getOid());

		paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("CCCRecargaSubprocesos"));
		
        // Llamamos al ConectorObtenerSubprocesos con el dto y con el DTOSalida que 
        // obtenemos cargamos el subproceso
		conector = conectar("ConectorObtenerSubprocesos", paramEntrada);
        asignar("COMBO", "cbEleccion", conector, "dtoSalida.resultado_ROWSET");
        
        traza("*** Salida - LPAplicarCargosAbonos - cargaDatos ***");
	} 	
		
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
                    
		traza("Stack Trace: " + baos.toString());
	}
	
	//método que se encuentra en la LP LPUtilidadesEDU (Añade los separadores de miles y decimales a un decimal
	//código para pasar un valor procedente de la bbdd al formato numérico del usuario
	private String formateaImporte(String dineroEntrada){
		String separadorMiles = ",";
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String numeroDecimales = UtilidadesSession.getFormatoNumerico(this);
		if (separadorDecimales.equals(",")) separadorMiles=".";
		
		StringTokenizer tokens = new StringTokenizer(dineroEntrada, ".");
		StringBuffer bufferEntero=new StringBuffer(tokens.nextToken());// almacena la parte entera.
		StringBuffer bufferDinero=new StringBuffer();//almacena el resultado
		StringBuffer bufferDecimales=new StringBuffer();//almacena la parte decimal
		
		int miles=0;
		while (bufferEntero.length()>0) {
			miles++;
			bufferDinero.insert(0, bufferEntero.charAt(bufferEntero.length()-1));
			bufferEntero.deleteCharAt(bufferEntero.length()-1);
			if (miles==3 && bufferEntero.length()>0) {
				miles=0;
				bufferDinero.insert(0, separadorMiles);
			}
		}
		if (numeroDecimales != null && tokens.hasMoreTokens()) { 
			bufferDecimales.append(tokens.nextToken());
			//Scale siempre vendrá a 00? ññññññ
			if (!bufferDecimales.substring(0,2).equals("00")) {
				if (numeroDecimales.equals("1")) 
					bufferDinero.append(separadorDecimales + bufferDecimales.substring(0,1));
				else if (numeroDecimales.equals("2")) 
					bufferDinero.append(separadorDecimales + bufferDecimales.substring(0,2));

			}//else{
					//if(!bufferDecimales.substring(0,1).equals("0"))
						//bufferDinero.append(separadorDecimales+bufferDecimales.toString());
				//}
		}
		return bufferDinero.toString();
	}

	private String cadena(String entrada) throws Exception {
		if (entrada != null && !entrada.equals("-")) {
			return entrada;
		}
		return null;

	}
	
	private BigDecimal numeroDecimal(String entrada) throws Exception {
		if (entrada != null && !entrada.equals("-")) {
			return new BigDecimal(entrada);
		}
		return null;
	}

	private BigDecimal numeroDecimalNoNulo(String entrada) throws Exception {
		if (entrada != null && !entrada.equals("-")) {
			return new BigDecimal(entrada);
		} else return new BigDecimal("0");
	}
	
	private Long numeroLong(String entrada) throws Exception{
		if (entrada != null && !entrada.equals("-")) {
			return new Long(entrada);
		}
		return null;	
	}

	private java.sql.Date fecha(String entrada) throws Exception {
		if (entrada != null && !entrada.equals("-")) {
			return new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(entrada, UtilidadesSession.getFormatoFecha(this))).getTime());
		}
		return null;
	}
	
	private void cargaCombos(DTOCargosAbonos dtoCargosAbonos) throws Exception {
		traza("*** Entrada - LPAplicarCargosAbonos - cargaCombos ***");
		
		// Se carga el combo empresa
		traza("Cargando empresa");
		Vector valores = new Vector();
		valores.add(dtoCargosAbonos.getEmpresa());
		valores.add(dtoCargosAbonos.getEmpresaDesc());
		
		RecordSet rs = new RecordSet();
		rs.addColumn("CODIGO");
		rs.addColumn("DESCRIPCION");
		rs.addRow(valores);
		
		Vector cols = rs.getColumnIdentifiers();
		DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
		asignar("COMBO", "cbEmpresa", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), 
			dtoCargosAbonos.getEmpresa().toString());
        
		// Se carga el combo proceso
		traza("Cargando proceso");
		valores = new Vector();
		valores.add(dtoCargosAbonos.getProceso());
		valores.add(dtoCargosAbonos.getProcesoDesc());
		
		rs = new RecordSet();
		rs.addColumn("CODIGO");
		rs.addColumn("DESCRIPCION");
		rs.addRow(valores);
		
		cols = rs.getColumnIdentifiers();
		conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
		asignar("COMBO", "cbAplicacion", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), 
			dtoCargosAbonos.getProceso().toString());
        
        // Se carga el combo acceso
		if (dtoCargosAbonos.getAcceso() != null) {
			valores = new Vector();
			valores.add(dtoCargosAbonos.getAcceso());
			valores.add(dtoCargosAbonos.getAccesoDesc());
			
			rs = new RecordSet();
			rs.addColumn("CODIGO");
			rs.addColumn("DESCRIPCION");
			rs.addRow(valores);
			
			cols = rs.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
			asignar("COMBO", "cbAcceso", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), 
				dtoCargosAbonos.getAcceso().toString());
		}
        
		// Se carga el combo subacceso
		if (dtoCargosAbonos.getSubacceso() != null) {
			traza("Cargando subacceso");
			valores = new Vector();
			valores.add(dtoCargosAbonos.getSubacceso());
			valores.add(dtoCargosAbonos.getSubaccesoDesc());
			
			rs = new RecordSet();
			rs.addColumn("CODIGO");
			rs.addColumn("DESCRIPCION");
			rs.addRow(valores);
		
			cols = rs.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
			asignar("COMBO", "cbSubacceso", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), 
				dtoCargosAbonos.getSubacceso().toString());
		}
        
		// Se carga el combo canal
		if (dtoCargosAbonos.getCanal() != null) {
			traza("Cargando canal");
			valores = new Vector();
			valores.add(dtoCargosAbonos.getCanal());
			valores.add(dtoCargosAbonos.getCanalDesc());
			
			rs = new RecordSet();
			rs.addColumn("CODIGO");
			rs.addColumn("DESCRIPCION");
			rs.addRow(valores);
			
			cols = rs.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
			asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), 
				dtoCargosAbonos.getCanal().toString());
		}
       	
        traza("*** Salida - LPAplicarCargosAbonos - cargaCombos ***");
	}
	
	private void cargaListas(DTOCargosAbonos dtoCargosAbonos) throws Exception {
		traza("*** Entrada - LPAplicarCargosAbonos - cargaListas ***");
		
		Vector cols = null;
		DruidaConector conectorCargaLista = null; 
		Vector colsSinFormato = null;
		
		RecordSet rs = dtoCargosAbonos.getCancelacionCuotas();
		if (rs != null) {
			cols = rs.getColumnIdentifiers();
			colsSinFormato = new Vector();
			colsSinFormato.add(new Integer(0));
			colsSinFormato.add(new Integer(16));
			colsSinFormato.add(new Integer(17));
			colsSinFormato.add(new Integer(18));
        	traza("****** generaConector  cancelacion cuotas ******");
			conectorCargaLista = this.generarConector("DTOSalida.combo_ROWSET", rs, cols, colsSinFormato);
			asignar("LISTAEDITABLE", "listado1", conectorCargaLista, "DTOSalida.combo_ROWSET");
        }
        
		rs = dtoCargosAbonos.getAplicacionCobros();
		if (rs != null) {
			cols = rs.getColumnIdentifiers();
			colsSinFormato = new Vector();
			colsSinFormato.add(new Integer(0));
			colsSinFormato.add(new Integer(9));
			colsSinFormato.add(new Integer(10));
			colsSinFormato.add(new Integer(11));
        	traza("****** generaConector  aplicacion cobros ******");
			conectorCargaLista = this.generarConector("DTOSalida.combo_ROWSET", rs, cols, colsSinFormato);
			asignar("LISTAEDITABLE", "listado2", conectorCargaLista, "DTOSalida.combo_ROWSET");
        }

		rs = dtoCargosAbonos.getConceptosGastosAbonos();
		if (rs != null) {
			cols = rs.getColumnIdentifiers();
			colsSinFormato = new Vector();
			colsSinFormato.add(new Integer(0));
			colsSinFormato.add(new Integer(8));
			colsSinFormato.add(new Integer(9));
			colsSinFormato.add(new Integer(10));
        	traza("****** generaConector  conceptos gastos ******");
			conectorCargaLista = this.generarConector("DTOSalida.combo_ROWSET", rs, cols, colsSinFormato);
			asignar("LISTAEDITABLE", "listado3", conectorCargaLista, "DTOSalida.combo_ROWSET");
        }
        
		rs = dtoCargosAbonos.getGeneracionVencimientos();
		if (rs != null) {
			cols = rs.getColumnIdentifiers();
			colsSinFormato = new Vector();
			colsSinFormato.add(new Integer(0));
			colsSinFormato.add(new Integer(15));
			colsSinFormato.add(new Integer(16));
			colsSinFormato.add(new Integer(17));
			colsSinFormato.add(new Integer(18));
			colsSinFormato.add(new Integer(19));
			colsSinFormato.add(new Integer(20));
			colsSinFormato.add(new Integer(21));
        	traza("****** generaConector  vencimientos ******");
			conectorCargaLista = this.generarConector("DTOSalida.combo_ROWSET", rs, cols, colsSinFormato);
			asignar("LISTAEDITABLE", "listado4", conectorCargaLista, "DTOSalida.combo_ROWSET");
        }
        
        traza("*** Salida - LPAplicarCargosAbonos - cargaListas ***");
	}

    private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns, Vector colsSinFormato) throws Exception, DOMException {
        StringBuffer salida = new StringBuffer();
        int sizeColums = datos.getColumnCount();
        int sizeRows = datos.getRowCount();
        if(columns == null)
            columns = new Vector();
        Vector columsDesc = datos.getColumnIdentifiers();
        DruidaConector conectorValoresPosibles = new DruidaConector();
        XMLDocument xmlDoc = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", rowsetID);
        docDestino.getDocumentElement().appendChild(e_rows);
        for (int i = 0; i < sizeRows; i++) {
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);
            for(int j = 0; j < sizeColums; j++)
                if(columns.contains(columsDesc.elementAt(j))) {
                    Element e_campo2 = docDestino.createElement("CAMPO");
                    e_campo2.setAttribute("NOMBRE", columsDesc.elementAt(j).toString());
                    e_campo2.setAttribute("TIPO", "OBJECTO");
                    e_campo2.setAttribute("LONGITUD", "50");
                    String dato = "";
                    Object datoObj = datos.getValueAt(i, j);
                    if (datoObj != null ) {
                    	if (datoObj instanceof java.sql.Date)
                    		dato = this.obtieneCadenaFecha((java.sql.Date) datoObj);
                    	else if (datoObj instanceof BigDecimal && !colsSinFormato.contains(new Integer(j))) {
                    		dato = this.formateaNumerico(datoObj.toString());
        					traza("*** generaConector ***: " + dato + " " + j);
                    	} else {
                    		dato = datoObj.toString();
                    	}
                    }
                    org.w3c.dom.Text txt = docDestino.createTextNode(dato);
                    e_campo2.appendChild(txt);
                    e_row.appendChild(e_campo2);
                }

        }

        conectorValoresPosibles.setXML(docDestino.getDocumentElement());
        return conectorValoresPosibles;
    }

         // Devuelve cadena de fecha conforme al formato que está en sesion
         private String obtieneCadenaFecha(java.sql.Date valor) throws Exception {
                  String fecha = new String("");
                  if (valor != null) {
                           fecha = UtilidadesBelcorp.fechaFormateada(valor, UtilidadesSession.getFormatoFecha(this));
                  }
                  
                  return fecha;
         }

         private String formateaNumerico(String dineroEntrada)  throws Exception{
                  String separadorMiles = ",";
                  String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
                  String numeroDecimales = UtilidadesSession.getFormatoNumerico(this);
                  String signo = "";
                  if (separadorDecimales.equals(",")) separadorMiles=".";
 					if (dineroEntrada.startsWith("-", 0)) {
 						signo = "-";
 						dineroEntrada = dineroEntrada.substring(1);
 					}              
                  StringTokenizer tokens=new StringTokenizer(dineroEntrada, ".");
                  StringBuffer bufferEntero=new StringBuffer(tokens.nextToken());// almacena la parte entera.
                  StringBuffer bufferDinero=new StringBuffer();//almacena el resultado
                  StringBuffer bufferDecimales=new StringBuffer();//almacena la parte decimal
                  
                  //Si ya contiene los separadores de mil no formateamos la cadena
                  for (int i=0; i<bufferEntero.length(); i++) {
                           if (bufferEntero.charAt(i) == separadorMiles.charAt(0)) return dineroEntrada;
                  }
                  int miles=0;
                  while (bufferEntero.length()>0) {
                           miles++;
                           bufferDinero.insert(0, bufferEntero.charAt(bufferEntero.length()-1));
                           bufferEntero.deleteCharAt(bufferEntero.length()-1);
                           if (miles==3 && bufferEntero.length()>0) {
                                    miles=0;
                                    bufferDinero.insert(0, separadorMiles);
                           }
                  }

                  if (numeroDecimales != null && tokens.hasMoreTokens()) { 
                           bufferDecimales.append(tokens.nextToken());
                           //Scale siempre vendrá a 00? //creo que en plantillas puede ser de longitud 0
                           if (!bufferDecimales.substring(0, bufferDecimales.length()).equals("00") && !bufferDecimales.substring(0, bufferDecimales.length()).equals("0")) {
                                    if (numeroDecimales.equals("1")) 
                                             bufferDinero.append(separadorDecimales + bufferDecimales.substring(0,1));
                                    else if (numeroDecimales.equals("2")) {
                                    	if (bufferDecimales.length() == 2) 
                                             bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 2));
                                        else if (bufferDecimales.length() == 1)
                                        	bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 1) + "0");
                                    }

                           }
                  }		
                  
                  String resultado = signo + bufferDinero.toString();
                  
                  return resultado;
         }

}