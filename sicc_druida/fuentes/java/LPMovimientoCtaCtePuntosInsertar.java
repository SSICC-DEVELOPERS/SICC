/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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


import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
 

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.dtos.cra.DTOBuscarPeriodos;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOMovimientoCtaCte;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream; 
import java.util.Collection;
import java.util.Iterator;
import java.math.BigDecimal;

import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import es.indra.sicc.util.Cronometrador;




public class LPMovimientoCtaCtePuntosInsertar extends LPSICCBase {
    
 private String accion = null;
 private String opcionMenu = null;
 private Long idioma = null;
 private Long pais = null;
 
 public LPMovimientoCtaCtePuntosInsertar() {
		  super();
 }
 
 public void inicio() throws Exception {
		  pagina("contenido_movimientos_cuenta_corriente_insertar");
          asignarAtributo("PAGINA", "contenido_movimientos_cuenta_corriente_insertar", "cod", "3191");
		  asignarAtributo("PAGINA", "contenido_movimientos_cuenta_corriente_insertar", "msgle", "Ingresar Movimientos Cuenta Corriente Puntos");
		  getConfiguracionMenu("LPMovimientoCtaCtePuntosInsertar", "");

 }
 
 public void ejecucion() throws Exception {
		  rastreo();
		  try {
			 setTrazaFichero(); 
			 traza("*** Entrada - LPMovimientoCtaCtePuntosInsertar - ejecucion ***");
			 
			 
			 generarHiddenFormatoFecha(); 
				
			  this.pais = UtilidadesSession.getPais(this);
			  this.idioma = UtilidadesSession.getIdioma(this);
			  this.accion = conectorParametroLimpia("accion", "", true);
			  this.opcionMenu = conectorParametroLimpia("opcionMenu","",true);
	  
				asignar("VAR", "longitudCodigoCliente", obtenerLongitudCodigoCliente().toString());           
		  if (accion.equals("")) {
			  this.cargarPagina();
		  }else if(accion.equals("guardar")){
		  	  this.guardar();
		  }
		
		  } catch(Exception e) {
			 logStackTrace(e);
			 lanzarPaginaError(e);
		  }
		  
		  traza("*** Salida - LPMovimientoCtaCtePuntosInsertar - ejecucion ***");
		  
 }
 
 private void cargarPagina() throws Exception {
		  
		  traza("*** Entrada - LPMovimientoCtaCtePuntosInsertar - cargarPagina ***");
		  
		  try {
				   
				  
				   asignar("VAR", "idioma", this.idioma.toString());
				   asignar("VAR", "pais", this.pais.toString());
				   asignar("VAR", "opcionMenu", this.opcionMenu);
				   asignar("VAR", "hMarcaDefec", UtilidadesSession.getMarcaPorDefecto(this).toString()); //[1]
				   asignar("VAR", "hCanalDefec", UtilidadesSession.getCanalPorDefecto(this).toString());//[1]
				   String fecha = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
                   asignar("CTEXTO", "txtFecha", fecha);

										 

		  DTOBelcorp dtoBelcorp = new DTOBelcorp();
		  dtoBelcorp.setOidPais(this.pais);
		  dtoBelcorp.setOidIdioma(this.idioma); 
 
		  String[] idBusiness = {"SEGConsultaMarcas", "SEGConsultaCanales", "INCObtenerTipoMovimiento"};
						 
		  ArrayList dtos = new ArrayList();
		  dtos.add(dtoBelcorp);
		  dtos.add(dtoBelcorp);
		  dtos.add(dtoBelcorp);
																				  
		  String[] combos = {"cbMarca", "cbCanal", "cbTipoM"};      
				   

		  cargaCombos(dtoBelcorp, idBusiness, dtos, combos, null, null);
				   
		  this.cargarOcultoPeriodosDefault();
		  } catch(Exception e) {
			 logStackTrace(e);
			 lanzarPaginaError(e);
		  }
		  
		  traza("*** Salida - LPMovimientoCtaCtePuntosInsertar - cargarPagina ***");
 }

  private void guardar() throws Exception {
		  
		  traza("*** Entrada - LPMovimientoCtaCtePuntosInsertar - guardar ***");
				  pagina("salidaGenerica");

        	      traza("Fecha: "+conectorParametroLimpia("hFecha", "", true));
                  traza("Marca: "+conectorParametroLimpia("hMarca", "", true));
                  traza("Canal: "+conectorParametroLimpia("hCanal", "", true));
                  traza("Concurso: "+conectorParametroLimpia("hConcurso", "", true));
                  traza("TipoMovimiento: "+conectorParametroLimpia("hTipoM", "", true));
                  traza("Periodo: "+conectorParametroLimpia("hPeriodo", "", true));
                  traza("CodCliente: "+conectorParametroLimpia("hCodClie", "", true));
                  traza("Puntos: "+conectorParametroLimpia("hNumPuntos", "", true));
                  traza("PuntosExigidos: "+conectorParametroLimpia("hNumExig", "", true));
                  traza("Descripcion: "+conectorParametroLimpia("hDescrip", "", true));
	  
		  try {
					
					DTOMovimientoCtaCte dtoMovimiento = new DTOMovimientoCtaCte();

						dtoMovimiento.setDescripcion(conectorParametroLimpia("hDescrip", "", true)!=""?conectorParametroLimpia("hDescrip", "", true).toString():null);
						dtoMovimiento.setFechaMovimiento(conectorParametroLimpia("hFecha", "", true)!=""?conectorParametroLimpia("hFecha", "", true).toString():null);
						dtoMovimiento.setNumPuntos(conectorParametroLimpia("hNumPuntos", "", true)!=""?new Long(conectorParametroLimpia("hNumPuntos", "", true)):null);
						dtoMovimiento.setNumPuntosExigidos(conectorParametroLimpia("hNumExig", "", true).equals("")?null:new Long(conectorParametroLimpia("hNumExig", "", true)));
						dtoMovimiento.setOidCanal(conectorParametroLimpia("hCanal", "", true)!=""?new Long(conectorParametroLimpia("hCanal", "", true)):null);
						dtoMovimiento.setCodCliente(conectorParametroLimpia("hCodClie", "", true)!=""?conectorParametroLimpia("hCodClie", "", true).toString():null);
						dtoMovimiento.setOidConcurso(conectorParametroLimpia("hConcurso", "", true)!=""?new Long(conectorParametroLimpia("hConcurso", "", true)):null);
						dtoMovimiento.setOidIdioma(this.idioma);
						dtoMovimiento.setOidMarca(conectorParametroLimpia("hMarca", "", true)!=""?new Long(conectorParametroLimpia("hMarca", "", true)):null);
						dtoMovimiento.setOidPais(this.pais);
						dtoMovimiento.setOidPeriodo(conectorParametroLimpia("hPeriodo", "", true)!=""?new Long(conectorParametroLimpia("hPeriodo", "", true)):null);
						dtoMovimiento.setOidTipoMovimiento(conectorParametroLimpia("hTipoM", "", true)!=""?new Long(conectorParametroLimpia("hTipoM", "", true)):null);

				  traza("DTO: "+dtoMovimiento);
        		  Vector paramConector = new Vector();
                  paramConector.add(dtoMovimiento);
                  paramConector.add(new MareBusinessID("INCGuardarMovimientosCtaCte"));
                  
                  DruidaConector conector = conectar("ConectorGuardarMovimientoCtaCtePuntos", paramConector);
                  
				  asignar("VAR", "ejecutar", "vaciaGuardar()");

				   
		  } catch(Exception e) {
			 logStackTrace(e);
			 lanzarPaginaError(e);
		  }
		  
		  traza("*** Salida - LPMovimientoCtaCtePuntosInsertar - guardar ***");
 }

 

 private void cargaCombos(DTOBelcorp dtoBelcorp, 
							String[] idBusiness, 
									 ArrayList dtos,
									 String[] combos, 
											  String[] seleccionados, 
														String[] columnas) throws Exception {
			  
		 
		  try {
			ComposerViewElementList listelem = new ComposerViewElementList();
			ComposerViewElement elem = null;
		  
					   int tamano = idBusiness.length;
		  for (int i = 0; i < tamano; i++) {
				   
				   elem = new ComposerViewElement(); 
				   elem.setIDBusiness(idBusiness[i]);
				   elem.setDTOE((DTOBelcorp)dtos.get(i));
				   listelem.addViewElement(elem);
		  }

		  ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());

		  conector.ejecucion();
						  
		  DruidaConector conConsultar = conector.getConector();
		  asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas"); 
		  asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales"); 
  		  asignar("COMBO", "cbTipoM", conConsultar, "INCObtenerTipoMovimiento"); 
								 
 } catch (Exception e) {
		  
		  this.logStackTrace(e);
		  lanzarPaginaError(e);  
 }
 
			
 }
 
 protected void logStackTrace(Throwable e) throws Exception {  
	traza("Se produjo la excepcion: " + e.getMessage());        
																			
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
	PrintStream ps = new PrintStream(baos);                      
	e.printStackTrace(ps);                                          
																	   
	traza("Stack Trace: " + baos.toString());                    
	} 

                                                                   
	private void cargarOcultoPeriodosDefault() throws Exception {
		traza("LPEnviarMapaAnaquelesProducto.cargarOcultoPeriodosDefault(): Entrada");
		
		// Signatura del metodo en el MON
		// public Collection obtienePeriodosActuales(DTOBuscarPeriodos dtoE)
		DTOBuscarPeriodos dtoBuscarPeriodos = new DTOBuscarPeriodos();
		dtoBuscarPeriodos.setOidPais(pais);
		dtoBuscarPeriodos.setOidIdioma(idioma);
		dtoBuscarPeriodos.setPeriodoMasNuevoPrimero(new Boolean(true));
		
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoBuscarPeriodos);
		paramEntrada.add(new MareBusinessID("CRAObtienePeriodosActuales"));
		
		traza("  antes de CRAObtienePeriodosActuales");
		DruidaConector conectorPeriodosActuales = conectar("ConectorObtienePeriodosActuales", paramEntrada);
		traza("  despues de CRAObtienePeriodosActuales");
		
		IMareDTO dtoSalida = (MareDTO) conectorPeriodosActuales.objeto("dtoSalida");
		Collection periodosActuales = (ArrayList)dtoSalida.getProperty("periodosActuales");
		
		traza("  se recuperaron los periodos actuales");
		
	    asignarAtributo("VAR", "hPeriodosActualesDefault", "valor", this.periodosActualesToString((ArrayList)periodosActuales));
		
		traza("LPEnviarMapaAnaquelesProducto.cargarOcultoPeriodosDefault(): Salida");
	}

	private String periodosActualesToString(ArrayList periodosActuales) throws Exception {
		traza("LPEnviarMapaAnaquelesProducto.periodosActualesToString(): Entrada");
		
		StringBuffer cadena = new StringBuffer("");
		
		int cantRegistros = periodosActuales.size();
		traza("  cantidad de periodos actuales: " + cantRegistros);
		
		DTOPeriodo dtoPeriodo = null;

		Iterator it = periodosActuales.iterator();
		
		while (it.hasNext()) {
			dtoPeriodo = (DTOPeriodo)it.next();
			cadena.append(dtoPeriodo.getMarca() + "," + dtoPeriodo.getCanal() + "," + dtoPeriodo.getOid());
			if (it.hasNext()) {
				cadena.append("|");
			}
		}
		traza(" --- vamos a retornar 'periodosActuales': " + cadena);
		traza("LPEnviarMapaAnaquelesProducto.periodosActualesToString(): Salida");
		return cadena.toString();
	}
} 