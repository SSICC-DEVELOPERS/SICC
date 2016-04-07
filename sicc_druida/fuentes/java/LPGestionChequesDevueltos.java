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

/*
    INDRA/CAR/PROY
    $Id: LPGestionChequesDevueltos.java,v 1.1 2009/12/03 18:43:29 pecbazalar Exp $
    DESC
*/
import java.util.Vector;
import java.util.Hashtable;
import java.util.StringTokenizer;

import java.math.BigDecimal;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.dtos.ccc.DTOCargaInicialCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCasoUso;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasPendientes;

// Definicion de la clase
public class LPGestionChequesDevueltos extends LPSICCBase {
    // Definicion del constructor
    public LPGestionChequesDevueltos() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {

      	// Defino el nombre de la vista
        pagina("contenido_cargos_abonos_directos_aplicar");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
    	 rastreo();
         try{
                  setTrazaFichero();
                  traza("***Entrada - LPGestionChequesDevueltos - ejecucion***");
                    
                  String accion = conectorParametroLimpia("accion","",true);
                  traza("***accion : "+accion);
                    
                  //Bifurcamos la accion
                  if ( accion.equals("")) {
                           accionVacia();
                  }
                  if ( accion.equals("guardar")) {
                  		   accionGuardar();
                  }
                  
                  getConfiguracionMenu("LPGestionChequesDevueltos",accion);
                  traza("***Salida - LPGestionChequesDevueltos - ejecucion***");
         }catch(Exception e){
                  logStackTrace(e);
                  lanzarPaginaError(e);
         }
    }
    
     private void accionVacia()  throws Exception  {
                  traza("*** Entrada - LPAplicarCargosAbonos - accionVacia ***");
                  
                  //Poner en el campo modificable el valor "true" 
                  asignar("VAR", "modificable", "true");
                  asignar("VAR", "casoUso", "gestionarCheques");
                  asignarAtributo("TEXT", "txtCodCliente", "req", "S");
                  asignarAtributo("ELEMENTO", "txtCodCliente", "required", "true");
                  
                  Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
                  //Long longitudCodigoCliente = new Long(15);
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
                  } catch (Exception e) {
                  }
                  if (empresa != null) {
                           asignar("VAR", "empresa", empresa.toString());
                           traza("paso 5");
                  }
                  Long subacceso = null;
                  try {
                  	subacceso = UtilidadesSession.getSubaccesoPorDefecto(this);
                  } catch (Exception e) {
                  }
                  if (subacceso != null) {
                           asignar("VAR", "subacceso", subacceso.toString());
                           traza("paso 6");
                  }

                  Vector paramEntrada = new Vector();
                  DTOCasoUso dto = new DTOCasoUso();
                  dto.setOidPais(pais);
                  dto.setOidIdioma(idioma);
                  dto.setCasoUso("GestionarCheques");

                  paramEntrada.add(dto);
                  paramEntrada.add(new MareBusinessID("CCCObtenerDatosInicialesCargosAbonos"));
            
                  DruidaConector conector = conectar("ConectorRecuperarDatosInicialesCargosAbonos", paramEntrada);
                  //Con el DTOCargaInicialCargosAbonos que obtenemos, con sus atributos rellenamos los compontes: numeroIdentificacion, proceso, empresa y canal. 
                  DTOCargaInicialCargosAbonos dtoSalida = (DTOCargaInicialCargosAbonos)conector.objeto("DTOCargaInicialCargosAbonos");
                  traza("paso 7");
                           
                  //Se cargan combos si "combosEditables" es true
                  //if (combosEditables) {
                           String fecha = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
                           asignar("LABELC", "lblFechaDocumento", fecha);
                           asignar("VAR", "htxtFechaDocumento", fecha);
                  			traza("paso 8: " + fecha);
                           StringTokenizer stFecha = new StringTokenizer(fecha , "/"); 
                           String dia = stFecha.nextToken();
                           String mes = stFecha.nextToken();
                           asignar("LABELC","lblvalorMes",mes);
                           String anio = stFecha.nextToken();
                           asignar("LABELC","lblvalorAnio",anio);
                           if (dtoSalida.getNumeroIdentificacion() != null) {
                                    asignar("LABELC", "lblvalorNIdentificacion", dtoSalida.getNumeroIdentificacion().toString());
                                    asignar("VAR", "NIdentificacion", dtoSalida.getNumeroIdentificacion().toString());
                           }

                   			traza("paso 9: ");
                          RecordSet rs = dtoSalida.getEmpresas();
                           if (rs != null && !rs.esVacio()) {
                                    Vector cols = rs.getColumnIdentifiers();
                                    DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
                                    if (empresa != null)
                                    	asignar("COMBO", "cbEmpresa", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), empresa.toString());
                                    else
                                    	asignar("COMBO", "cbEmpresa", conectorCargaCombo, "DTOSalida.combo_ROWSET"); 
                  }
                    			traza("paso 10: ");
                          rs = dtoSalida.getSubprocesosGestionCheques();
                           if (rs != null && !rs.esVacio()) {
                                    Vector cols = rs.getColumnIdentifiers();
                                    DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
                                    asignar("COMBO", "cbEleccion", conectorCargaCombo, "DTOSalida.combo_ROWSET");
                  }
                           rs = dtoSalida.getCanales();
                           if (rs != null && !rs.esVacio()) {
                                    Vector cols = rs.getColumnIdentifiers();
                                    DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
                                    asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), canal.toString());
                                    //asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET"); //ñññ
                  }
                  //}
                           //Los RecordSets de accesos y subaccesos los guardamos en listas ocultas para recargar dinámicamente
                           RecordSet rsA = dtoSalida.getAccesos();
                           if (rsA != null && !rsA.esVacio()) {
                                    Vector cols = rsA.getColumnIdentifiers();
                                    DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "datosAccesos", rsA, cols);
                           asignar("MATRIZJS", "datosAccesos", conectorCargaCombo); 
                  }
                           
                           traza("*** Cargada Matriz ***");

                           rs = dtoSalida.getSubaccesos();
                           if (rs != null && !rs.esVacio()) {
                                    Vector cols = rs.getColumnIdentifiers();
                                    DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "datosSubaccesos", rs, cols);
                           asignar("MATRIZJS", "datosSubaccesos", conectorCargaCombo); 
                  }
                  
 		RecordSet rsProcesos = dtoSalida.getProcesos();
		traza("***rsProcesos:"+rsProcesos);
		/*traza("1");
		int filas = rsProcesos.getRowCount();
		traza("2");
		boolean existeProceso = false;
		for (int i = 0; i < filas; i++) {
			//Buscamos CCC004
			traza("3");
			String codigo = (String)rsProcesos.getValueAt(i,1);
			if(codigo.equals("CCC004")) {
				//Deshabilitar el combo procesos que contendrá el valor: CCC004.
				traza("4");
				Vector valores = new Vector();
				Long proceso = (Long)rsProcesos.getValueAt(i,0);
				traza("5");
				valores.add(proceso);
				valores.add((String)rsProcesos.getValueAt(i,1));
				RecordSet rsp = new RecordSet();
				rsp.addColumn("CODIGO");
				rsp.addColumn("DESCRIPCION");
				rsp.addRow(valores);
				traza("6");
				Vector colsP = rsp.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsp, colsP);
				asignar("COMBO", "cbAplicacion", conectorCargaCombo, "DTOSalida.combo_ROWSET", colsP.get(0).toString(), proceso.toString());
				asignarAtributoElemento("cbAplicacion", "disabled", "S");
 
				existeProceso = true;
				//codigocliente obligatorio.
				//asignarAtributo("TEXT", "txtCodCliente", "req", "S"); 
				asignarAtributo("ELEMENTO", "txtCodCliente", "required", "true");
				asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","cod","0193");
				asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","msgle","0193");
			}	
		}*/
		if (!rsProcesos.esVacio()) {
				Vector colsP = rsProcesos.getColumnIdentifiers();
				Long proceso = (Long)rsProcesos.getValueAt(0,0);

				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsProcesos, colsP);
				asignar("COMBO", "cbAplicacion", conectorCargaCombo, "DTOSalida.combo_ROWSET", colsP.get(0).toString(), proceso.toString());
				asignarAtributoElemento("cbAplicacion", "disabled", "S");
 
				//codigocliente obligatorio.
				//asignarAtributo("TEXT", "txtCodCliente", "req", "S"); 
				asignarAtributo("ELEMENTO", "txtCodCliente", "required", "true");
				asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","cod","0193");
				asignarAtributo("PAGINA","contenido_cargos_abonos_directos_aplicar","msgle","0193");

		} else {
			
			String xml ="<PAGINA onload=\"GestionarMensaje('1131');\"><JS src='sicc_util.js'/><FORMULARIO nombre='frmFormulario'><VAR nombre='accion' valor=''/><VAR nombre='conectorAction' valor=''/><VAR nombre='errCodigo' valor=''/><VAR nombre='errDescripcion' valor=''/></FORMULARIO></PAGINA>";
			org.w3c.dom.Document document = getParser().convierte(xml);
			setXML(document);
		}
		
		traza("***Salida -  LPGestionChequesDevueltos - accionVacia"); 
         }
    
    private void accionGuardar() throws Exception {
        traza("***Entrada - LPGestionChequesDevueltos - accionGuardar");
        
        //Salida Generica
        pagina("salidaGenerica");
        asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "insercionCorrecta()");
        
        //Creamos un DTOCargosAbonos
        DTOCargosAbonos dtoCarga = new DTOCargosAbonos();
        
        //Obtenemos el pais y el idioma de la sesion
        UtilidadesSession sesion = new UtilidadesSession();
        Long pais = sesion.getPais(this); 
        Long idioma = sesion.getIdioma(this);
        dtoCarga.setOidPais(pais);
        dtoCarga.setOidIdioma(idioma);
         
		//Por cada lista creamos un RecordSet y lo ponemos en el atributo correspondiente del 
		//DTOCargosAbonos: aplicacionCobros, conceptosGastosAbonos o generacionVencimientos. 
		RecordSet rs = null;
		StringTokenizer st = null;
		
		//Aplicacion cobros
		rs = new RecordSet();
		String parametro = conectorParametroLimpia("aplicacionCobros", "", true);

		if(!parametro.equals("")) {
			rs.addColumn("empresa");
			rs.addColumn("codigoCliente");
			rs.addColumn("cuentaCorrienteDesc");
			rs.addColumn("fechaPago");
			rs.addColumn("importe");
			rs.addColumn("importeAplicar");
			rs.addColumn("cuentaCorrienteoid");
			rs.addColumn("oidMovimiento");
			rs.addColumn("oidDetalle");	
			//Obtenemos las filas
			st = new StringTokenizer(parametro, "#");
			while (st.countTokens() > 0) {
				String fila = st.nextToken();
				if (!fila.equals("")) {
					//Obtenemos los valores de la fila
					StringTokenizer stFila = new StringTokenizer(fila, "@");
						if (stFila.countTokens() > 0) {
							Vector vFila = new Vector();
							vFila.add(this.cadena(stFila.nextToken()));
							vFila.add(this.cadena(stFila.nextToken()));
							vFila.add(this.cadena(stFila.nextToken()));
							vFila.add(this.fecha(stFila.nextToken()));
							vFila.add(this.numeroDecimal(stFila.nextToken()));
							vFila.add(this.numeroDecimal(stFila.nextToken()));
							vFila.add(this.numeroDecimal(stFila.nextToken())); 
							vFila.add(this.numeroDecimal(stFila.nextToken())); 
							vFila.add(this.cadena(stFila.nextToken()));
							rs.addRow(vFila);
						}
				}
			}
		}
		dtoCarga.setAplicacionCobros(rs);
		
		//Conceptos Gastos Abonos
		parametro = conectorParametroLimpia("conceptoCargosAbonos", "", true);
		rs = new RecordSet();
	
		if(!parametro.equals("")) {
			rs.addColumn("codigoCliente");
			rs.addColumn("cuentaCorrienteDesc");
			rs.addColumn("glosaContable");
			rs.addColumn("fechaPago");
			rs.addColumn("importe");
			rs.addColumn("divisa");
			rs.addColumn("importeDivisa");
			rs.addColumn("cuentaCorrienteoid");
			rs.addColumn("divisaOid");
			rs.addColumn("oidDetalle");
			//Obtenemos las filas
			st = new StringTokenizer(parametro, "#");
			while (st.countTokens() > 0) {
				String fila = st.nextToken();
				if (!fila.equals("")) {
					//Obtenemos los valores de la fila
					StringTokenizer stFila = new StringTokenizer(fila, "@");
					if (stFila.countTokens() > 0) {
						Vector vFila = new Vector();
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.fecha(stFila.nextToken()));
						vFila.add(this.numeroDecimal(stFila.nextToken()));
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.numeroDecimal(stFila.nextToken()));
						vFila.add(this.numeroDecimal(stFila.nextToken())); 
						vFila.add(this.numeroDecimal(stFila.nextToken())); 
						vFila.add(this.cadena(stFila.nextToken()));
						rs.addRow(vFila);
					}
				}
			}
		}
		dtoCarga.setConceptosGastosAbonos(rs);
		
		//Generacion Vencimientos
		parametro = conectorParametroLimpia("generacionVencimientos", "", true);
		rs = new RecordSet();
		
		if(!parametro.equals("")) {
			rs.addColumn("marca");
			rs.addColumn("codigoCliente");
			rs.addColumn("numeroDocumento");
			rs.addColumn("numeroOrden");
			rs.addColumn("fechaDocumento");
			rs.addColumn("fechaVencimiento");
			rs.addColumn("medioPagoDesc");
			rs.addColumn("importeCuota");
			rs.addColumn("importeAplicado");
			rs.addColumn("importePendiente");
			rs.addColumn("divisaDesc");
			rs.addColumn("importeDivisa");
			rs.addColumn("observaciones");
			rs.addColumn("medioPagoOid");
			rs.addColumn("divisaOid");
			rs.addColumn("marcaOid");
			rs.addColumn("oidDetalle");
			//Obtenemos las filas
			st = new StringTokenizer(parametro, "#");
			while (st.countTokens() > 0) {
				String fila = st.nextToken();
				if (!fila.equals("")) {
					//Obtenemos los valores de la fila	
					StringTokenizer stFila = new StringTokenizer(fila, "@");
					if (stFila.countTokens() > 0) {
						Vector vFila = new Vector();
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.fecha(stFila.nextToken()));
						vFila.add(this.fecha(stFila.nextToken()));
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.numeroDecimal(stFila.nextToken()));
						vFila.add(this.numeroDecimal(stFila.nextToken()));
						vFila.add(this.numeroDecimal(stFila.nextToken()));
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.numeroDecimal(stFila.nextToken()));
						vFila.add(this.cadena(stFila.nextToken()));
						vFila.add(this.numeroDecimal(stFila.nextToken())); //Long
						vFila.add(this.numeroDecimal(stFila.nextToken())); //Long
						vFila.add(this.numeroDecimal(stFila.nextToken())); //Long
						vFila.add(this.cadena(stFila.nextToken()));
						rs.addRow(vFila);
					}
				}
			}
		}
		dtoCarga.setGeneracionVencimientos(rs);
		
		//Como no existe la lista cancelacion ponemos en el atributo cancelacionCuotas un RecordSet vacio 
		RecordSet rsCancelacion = new RecordSet();
		dtoCarga.setCancelacionCuotas(rsCancelacion);
		
		//Rellenamos el resto de los atributos del dto con los campos correspondientes de la pantalla. 
		String param = conectorParametroLimpia("hid_numeroIdentificacion","",true);
		if(!param.equals("")) {
			dtoCarga.setNumeroIdentificacion(new Integer(param));
		}
		param = conectorParametroLimpia("txtCodCliente","",true);
		if(!param.equals("")) {
			dtoCarga.setCodigoCliente(param);
		}
		String fechaDocumento = conectorParametroLimpia("txtFechaDocumento","",true);
		if(!fechaDocumento.equals("")) {
			dtoCarga.setFechaDocumento(UtilidadesBelcorp.getDatefromSICCStringFormat(fechaDocumento, UtilidadesSession.getFormatoFecha(this)));
		}
		param = conectorParametroLimpia("txtReferenciaExterna","",true);
		if(!param.equals("")) {
			dtoCarga.setReferenciaExterna(param);
		}
		param = conectorParametroLimpia("cbCanal","",true);
		if(!param.equals("")) {
			dtoCarga.setCanal(new Long(param));
		}
		param = conectorParametroLimpia("cbAcceso","",true);
		if(!param.equals("")) {
			dtoCarga.setAcceso(new Long(param));
		}
		param = conectorParametroLimpia("cbSubacceso","",true);
		if(!param.equals("")) {
			dtoCarga.setSubacceso(new Long(param));
		}
		param = conectorParametroLimpia("cbEmpresa","",true);
		if(!param.equals("")) {
			dtoCarga.setEmpresa(new Long(param));
		}
		param = conectorParametroLimpia("areatxtObservaciones","",true);
		if(!param.equals("")) {
			dtoCarga.setObservaciones(param);
		}
		param = conectorParametroLimpia("proceso","",true);
		if(!param.equals("")) {
			dtoCarga.setProceso(new Long(param)); 
		}

		//idBusiness = "CCCGuardarCargosAbonos" 
		//Llamamos al ConectorAplicarCargosAbonos con el dto y el idBusiness 
		
		//- Se crea idNegocio "CCCGuardarCargosAbonos" 
        MareBusinessID idBussiness = new MareBusinessID("CCCGuardarCargosAbonos");
          
        //Almacenamos los parametros de entrada
        Vector paramEntrada = new Vector();
        paramEntrada.addElement(dtoCarga);
        paramEntrada.addElement(idBussiness);
         
        traza("****dtoCarga:"+dtoCarga.toString()); 
        traza ("Llamo a conectar");
          
        //- Se invoca al ConectorAplicarCargosAbonos 
        DruidaConector conector = conectar("ConectorAplicarCargosAbonos", paramEntrada);
       	
		traza("***Salida -  LPGestionChequesDevueltos - accionGuardar");
    }
    
    protected void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
                    
        traza("Stack Trace: " + baos.toString());
    }
    
    private String cadena(String entrada){
    	if (entrada != null && !entrada.equals("-")) return entrada;
        	return null;
    }
 	private BigDecimal numeroDecimal(String entrada){
    	if (entrada != null && !entrada.equals("-")) return new BigDecimal(entrada);
        	return null;
 	}

    private java.sql.Date fecha(String entrada)  throws Exception {
        if (entrada != null && !entrada.equals("-")) return new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(entrada, UtilidadesSession.getFormatoFecha(this))).getTime());
            return null;
    }


}