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

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.rec.ConstantesREC; 
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.rec.DTOChequeoEnLinea;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.dtos.rec.DTOChequeoManual;
import es.indra.sicc.dtos.rec.DTOChequeoZona;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.math.*; 

import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LPIntroducirOrdenesChequeos extends LPSICCBase {
         
    private String accion = null;
    private String casoUso = null;
    private Long pais;
    private Long idioma;

    private String tipoOrdenChequeo = null;
 
    public LPIntroducirOrdenesChequeos() {
        super();
    }
          
    public void inicio() throws Exception {
            pagina("contenido_ordenes_chequeo_introducir");
    }
          
    public void ejecucion() throws Exception {
        setTrazaFichero();

        try {

            traza("*** LPIntroducirOrdenesChequeos: Entrada ***");
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            this.accion = conectorParametroLimpia("accion", "", true);

			traza("accion: " + accion);

            if (this.accion.equals("")) {
				pagina("contenido_ordenes_chequeo_introducir");
				this.inicializar();
            } else if (this.accion.equals("Seleccionar tipo orden")) {
                this.seleccionarTipoOrden();
            } else if(this.accion.equals("Selecciona periodo")){ 
        		pagina("contenido_ordenes_chequeo_introducir_chequeo");
                this.cargarChequeoEnCampo(); 
				this.obtenerChequeoEnCampo();
            } else if (this.accion.equals("Guardar chequeo manual")) { 
            	pagina("salidaGenerica");
                this.guardarChequeoManual();
            } else if(this.accion.equals("Guardar chequeo en linea")){
            	pagina("salidaGenerica");
                this.guardarChequeoEnLinea();
            } else if(this.accion.equals("Guardar chequeo en campo")){
            	pagina("salidaGenerica");
                this.guardarChequeoEnCampo();
            } else if(this.accion.equals("obtenerChequeo")) {
				pagina("salidaGenerica");
				this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
				this.obtenerChequeoEnCampo();
		    // vbongiov -- Cambio 20080756 -- 29/04/2009
			} else if(this.accion.equals("detalleManual")) {
				this.detalleManual();
			} else if(this.accion.equals("verificarChequeosDefinidos")) {
				this.verificarChequeosDefinidos();
			} else if(this.accion.equals("limpiarManual")) {
				this.limpiarManual();
			} else if(this.accion.equals("eliminarRegistrosManual")) {
				this.eliminarRegistrosManual();
			} else if(this.accion.equals("detalleLineaCampo")) {
				this.detalleLineaCampo();
			} else if(this.accion.equals("aniadirLineaCampo")) {
				this.aniadirLineaCampo();
			} else if(this.accion.equals("verificarChequeosDefinidosLineaCampo")) {
				this.verificarChequeosDefinidosLineaCampo();
			}

            traza("*** Salida -  LPIntroducirOrdenesChequeos- ejecucion ***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e); 
        }
    }

   private void verificarChequeosDefinidosLineaCampo() throws Exception{

	   pagina("salidaGenerica");

	   try { 
      
		    String oidPeriodoDesde = conectorParametroLimpia("cbPeriodoInicialEvaluacion", "", true); 
		    String oidPeriodoHasta = conectorParametroLimpia("cbPeriodoFinalEvaluacion", "", true); 
		    String oidTipoChequeo = conectorParametroLimpia("hOidTipoChequeo", "", true);

			String oidSubgerencia = conectorParametroLimpia("hOidSubgerencia", "", true); 
			String oidRegion = conectorParametroLimpia("hOidRegion", "", true); 
			String oidZona = conectorParametroLimpia("hOidZona", "", true);    
			String oidSeccion = conectorParametroLimpia("hOidSeccion", "", true);

			// Verificacion en la base de datos
            DTOChequeoZona dtoChequeoZona = new DTOChequeoZona();    
            dtoChequeoZona.setOidTipoRevision(Long.valueOf(oidTipoChequeo));
            dtoChequeoZona.setOidPeriodoDesde(Long.valueOf(oidPeriodoDesde));
			dtoChequeoZona.setOidPeriodoHasta(Long.valueOf(oidPeriodoHasta));

			dtoChequeoZona.setOidSubgerenciaVentas(Long.valueOf(oidSubgerencia));
			dtoChequeoZona.setOidRegion(Long.valueOf(oidRegion));
			dtoChequeoZona.setOidZona(Long.valueOf(oidZona));
			dtoChequeoZona.setOidSeccion(oidSeccion.equals("")?null:Long.valueOf(oidSeccion));
			dtoChequeoZona.setOidPais(this.pais);
            
            traza("dtoChequeoZona: " + dtoChequeoZona);
           
            MareBusinessID id = new MareBusinessID("RECVerificarChequeoDefinidosLineaCampo");              
            Vector paramEntrada = new Vector();
        
            paramEntrada.add(dtoChequeoZona);
            paramEntrada.add(id);
            traza("*************** Antes de conectar");
            DruidaConector con = conectar("ConectorVerificarChequeoDefinidosLineaCampo", paramEntrada);            
            traza("*************** Despues de conectar");


            // Verificacion en los registro ya ingresados
			DTOChequeoZona dtoChequeoZonaAVerif = (DTOChequeoZona)con.objeto("DTOChequeoZona");    

			traza("dtoChequeoManualAVerif: " + dtoChequeoZonaAVerif);

			ArrayList chequeosLineaCampoIngresados = (ArrayList) this.conectorParametroSesion("chequeosLineaCampoIngresados"); 

			traza("chequeosLineaCampoIngresados: " + chequeosLineaCampoIngresados);

			int cant = chequeosLineaCampoIngresados.size();
			DTOChequeoZona dtoChequeoZonaVerif = null;
			SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			Date fechaDesdeVerif = null;
			Date fechaHastaVerif = null;
			String codClienteVerif = null;
		    Long oidTipoChequeoVerif = null;
			Long oidSubgerenciaVerif = null;
			Long oidRegionVerif = null;
			Long oidZonaVerif = null;
			Long oidSeccionVerif = null;

			Date fechaDesdeAVerif = formatter.parse(dtoChequeoZonaAVerif.getFechaDesdeInicio());
			Date fechaHastaAVerif = formatter.parse(dtoChequeoZonaAVerif.getFechaHastaFin());

			for(int i=0; i<cant; i++){

				dtoChequeoZonaVerif = (DTOChequeoZona)chequeosLineaCampoIngresados.get(i);

				traza("dtoChequeoZonaVerif: " + dtoChequeoZonaVerif);

				fechaDesdeVerif = formatter.parse(dtoChequeoZonaVerif.getFechaDesdeInicio());
				fechaHastaVerif = formatter.parse(dtoChequeoZonaVerif.getFechaHastaFin());
		        oidTipoChequeoVerif = dtoChequeoZonaVerif.getOidTipoRevision();
				oidSubgerenciaVerif = dtoChequeoZonaVerif.getOidSubgerenciaVentas();
				oidRegionVerif = dtoChequeoZonaVerif.getOidRegion();
				oidZonaVerif = dtoChequeoZonaVerif.getOidZona();
				oidSeccionVerif = dtoChequeoZonaVerif.getOidSeccion();

				traza("fechaDesdeAVerif: " + fechaDesdeAVerif);
				traza("fechaHastaAVerif: " + fechaHastaAVerif);
				traza("fechaDesdeVerif: " + fechaDesdeVerif);
				traza("fechaHastaVerif: " + fechaHastaVerif);

				if(((fechaDesdeAVerif.compareTo(fechaDesdeVerif) <= 0 && fechaHastaAVerif.compareTo(fechaDesdeVerif) >=0) ||
				    (fechaDesdeAVerif.compareTo(fechaDesdeVerif) >= 0 && fechaHastaAVerif.compareTo(fechaHastaVerif) <=0) ||
				    (fechaDesdeAVerif.compareTo(fechaHastaVerif) <= 0 && fechaHastaAVerif.compareTo(fechaHastaVerif) >=0) ||
				    (fechaDesdeAVerif.compareTo(fechaDesdeVerif) <= 0 && fechaHastaAVerif.compareTo(fechaHastaVerif) >=0)) &&
				    oidTipoChequeoVerif.equals(dtoChequeoZonaAVerif.getOidTipoRevision()) &&
					oidSubgerenciaVerif.equals(dtoChequeoZonaAVerif.getOidSubgerenciaVentas()) &&
					oidRegionVerif.equals(dtoChequeoZonaAVerif.getOidRegion()) &&
					oidZonaVerif.equals(dtoChequeoZonaAVerif.getOidZona()) &&
					((oidSeccionVerif != null && dtoChequeoZonaAVerif.getOidSeccion()== null) ||
					 (oidSeccionVerif != null && oidSeccionVerif.equals(dtoChequeoZonaAVerif.getOidSeccion())) ||
					 (oidSeccionVerif == null && dtoChequeoZonaAVerif.getOidSeccion()== null) ||
                     (oidSeccionVerif == null && dtoChequeoZonaAVerif.getOidSeccion()!= null)) ) {

						traza("solapamiento");
						throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC + "0011"));     
				}
			}

            // Almaceno en memoria el chequeo ingresado 
			chequeosLineaCampoIngresados.add(dtoChequeoZonaAVerif);
			this.conectorParametroSesion("chequeosLineaCampoIngresados", chequeosLineaCampoIngresados); 
            
            asignarAtributo("VAR", "ejecutar", "valor", "aniadirChequeo()");
            
       } catch(Exception e) {
           traza("Excepcion: " + e);
           asignarAtributo("VAR", "ejecutarError", "valor", "ejecutarErrorVerificar()");
           throw e;
       }
  }




   // vbongiov -- Cambio 20080756 -- 29/04/2009
	private void aniadirLineaCampo() throws Exception{

		pagina("contenido_ordenes_chequeo_introducir_linea_aniadir");

		String oidTipoChequeo = conectorParametroLimpia("oidTipoChequeo", "", true);
      
	    String oidMarca = conectorParametroLimpia("oidMarca", "", true); 
		String oidCanal = conectorParametroLimpia("oidCanal", "", true); 
		String oidSubgerencia = conectorParametroLimpia("oidSubgerencia", "", true); 
		String oidRegion = conectorParametroLimpia("oidRegion", "", true); 
		String oidZona = conectorParametroLimpia("oidZona", "", true);    
		String oidSeccion = conectorParametroLimpia("oidSeccion", "", true);

		asignarAtributo("VAR","idioma","valor", idioma.toString());  
		asignarAtributo("VAR","pais","valor", pais.toString());  

        asignarAtributo("VAR","hOidTipoChequeo","valor", oidTipoChequeo);   
		asignarAtributo("VAR","hOidMarca","valor", oidMarca);   
		asignarAtributo("VAR","hOidCanal","valor", oidCanal);   
		asignarAtributo("VAR","hOidSubgerencia","valor", oidSubgerencia);  
		asignarAtributo("VAR","hOidRegion","valor", oidRegion);  
		asignarAtributo("VAR","hOidZona","valor", oidZona);  
		asignarAtributo("VAR","hOidSeccion","valor", oidSeccion);       
		
		getConfiguracionMenu("LPIntroducirOrdenesChequeos", "aniadirLineaCampo");
  }

  // vbongiov -- Cambio 20080756 -- 29/04/2009
	private void detalleLineaCampo() throws Exception{

		pagina("contenido_ordenes_chequeo_introducir_linea_detalle");

        // Inicializa los chequeos Linea o Campo
		ArrayList chequeosLineaCampoIngresados = new ArrayList();
		this.conectorParametroSesion("chequeosLineaCampoIngresados", chequeosLineaCampoIngresados); 

		String oidTipoChequeo = conectorParametroLimpia("oidTipoChequeo", "", true);
      
	    String oidMarca = conectorParametroLimpia("oidMarca", "", true); 
		String oidCanal = conectorParametroLimpia("oidCanal", "", true); 
		String oidSubgerencia = conectorParametroLimpia("oidSubgerencia", "", true); 
		String oidRegion = conectorParametroLimpia("oidRegion", "", true); 
		String oidZona = conectorParametroLimpia("oidZona", "", true);    
		String oidSeccion = conectorParametroLimpia("oidSeccion", "", true);

        asignarAtributo("VAR","idioma","valor", idioma.toString());  
		asignarAtributo("VAR","hOidTipoChequeo","valor", oidTipoChequeo);   
		asignarAtributo("VAR","hOidMarca","valor", oidMarca);   
		asignarAtributo("VAR","hOidCanal","valor", oidCanal);   
		asignarAtributo("VAR","hOidSubgerencia","valor", oidSubgerencia);  
		asignarAtributo("VAR","hOidRegion","valor", oidRegion);  
		asignarAtributo("VAR","hOidZona","valor", oidZona);  
		asignarAtributo("VAR","hOidSeccion","valor", oidSeccion);  
		
		getConfiguracionMenu("LPIntroducirOrdenesChequeos", "detalleLineaCampo");
  }

  // vbongiov -- Cambio 20080756 -- 29/04/2009
  private void limpiarManual() throws Exception{

	   pagina("salidaGenerica");
	   asignarAtributo("VAR", "cerrarVentana", "valor", "false");

	   try { 
			this.conectorParametroSesion("chequeosManualesIngresados", new ArrayList()); 
            
            asignarAtributo("VAR", "ejecutar", "valor", "limpiarManual()");
            
       } catch(Exception e) {
           traza("Excepcion: " + e);
           asignarAtributo("VAR", "ejecutarError", "valor", "ejecutarErrorLimpiar()");
           throw e;
       }
  }

  // vbongiov -- Cambio 20080756 -- 29/04/2009
  private void eliminarRegistrosManual() throws Exception{

	   pagina("salidaGenerica");
	   asignarAtributo("VAR", "cerrarVentana", "valor", "false");

	   try { 
			String registrosEliminados = conectorParametroLimpia("registrosEliminados", "", true); 
			ArrayList chequeosManualesIngresados = (ArrayList) this.conectorParametroSesion("chequeosManualesIngresados"); 
			int cant = chequeosManualesIngresados.size();

			traza("registrosEliminados: " + registrosEliminados);
			traza("chequeosManualesIngresados antes: " + chequeosManualesIngresados);

			StringTokenizer stkRegistrosEliminados = new StringTokenizer(registrosEliminados,"|");
			StringTokenizer stkReg = null;
			DTOChequeoManual dtoChequeoManualVerif = null;
			String codCliente = null;
			String oidPeriodoDesde = null;
			String oidPeriodoHasta = null;
			String oidTipoChequeo = null;

			// Recorre los registros
			while (stkRegistrosEliminados.hasMoreTokens()) {
				stkReg = new StringTokenizer(stkRegistrosEliminados.nextToken(),",");

				codCliente = stkReg.nextToken();
				oidPeriodoDesde = stkReg.nextToken();
				oidPeriodoHasta = stkReg.nextToken();
				oidTipoChequeo = stkReg.nextToken();

				for(int i=0; i<cant; i++){

					dtoChequeoManualVerif = (DTOChequeoManual)chequeosManualesIngresados.get(i);

					traza("dtoChequeoManualVerif: " + dtoChequeoManualVerif);

					if(dtoChequeoManualVerif.getCodigoCliente().equals(codCliente) && dtoChequeoManualVerif.getOidPeriodoDesde().equals(Long.valueOf(oidPeriodoDesde)) 
						&& dtoChequeoManualVerif.getOidPeriodoHasta().equals(Long.valueOf(oidPeriodoHasta))
						&& dtoChequeoManualVerif.getOidTipoRevision().equals(Long.valueOf(oidTipoChequeo))){

							traza("borra registro");
							chequeosManualesIngresados.remove(i); 
							break;
					}
				 }
			}

			traza("chequeosManualesIngresados despues: " + chequeosManualesIngresados);

			this.conectorParametroSesion("chequeosManualesIngresados", chequeosManualesIngresados); 
            
            asignarAtributo("VAR", "ejecutar", "valor", "borrarRegistros()");
            
       } catch(Exception e) {
           traza("Excepcion: " + e);
           asignarAtributo("VAR", "ejecutarError", "valor", "ejecutarErrorLimpiar()");
           throw e;
       }
  }

	// vbongiov -- Cambio 20080756 -- 29/04/2009
	private void detalleManual() throws Exception{

		pagina("contenido_ordenes_chequeo_introducir_manual_detalle");
      
		String oidPeriodoDesde = conectorParametroLimpia("oidPeriodoDesde", "", true); 
		String oidPeriodoHasta = conectorParametroLimpia("oidPeriodoHasta", "", true); 
		String codCliente = conectorParametroLimpia("codCliente", "", true);    
		String oidTipoChequeo = conectorParametroLimpia("oidTipoChequeo", "", true);

        asignarAtributo("VAR","idioma","valor", idioma.toString());  
		asignarAtributo("VAR","hOidPeriodoDesde","valor", oidPeriodoDesde);  
		asignarAtributo("VAR","hOidPeriodoHasta","valor", oidPeriodoHasta);  
		asignarAtributo("VAR","hCodCliente","valor", codCliente);  
		asignarAtributo("VAR","hOidTipoChequeo","valor", oidTipoChequeo);         
		
		getConfiguracionMenu("LPIntroducirOrdenesChequeos", "detalleManual");
  }

  // vbongiov -- Cambio 20080756 -- 29/04/2009
  private void verificarChequeosDefinidos() throws Exception{

	   pagina("salidaGenerica");
	   asignarAtributo("VAR", "cerrarVentana", "valor", "false");

	   try { 
      
		    String oidPeriodoDesde = conectorParametroLimpia("cbPeriodo1", "", true); 
		    String oidPeriodoHasta = conectorParametroLimpia("cbPeriodo2", "", true); 
		    String codCliente = conectorParametroLimpia("txtCodigoCliente1", "", true);    
		    String oidTipoChequeo = conectorParametroLimpia("cbTipoChequeo", "", true);


			// Verificacion en la base de datos
            DTOChequeoManual dtoChequeoManual = new DTOChequeoManual();      
			dtoChequeoManual.setCodigoCliente(codCliente);
            dtoChequeoManual.setOidTipoRevision(Long.valueOf(oidTipoChequeo));
            dtoChequeoManual.setOidPeriodoDesde(Long.valueOf(oidPeriodoDesde));
			dtoChequeoManual.setOidPeriodoHasta(Long.valueOf(oidPeriodoHasta));
			dtoChequeoManual.setOidPais(this.pais);
            
            traza("dtoChequeoManual: " + dtoChequeoManual);
           
            MareBusinessID id = new MareBusinessID("RECVerificarChequeoDefinidos");              
            Vector paramEntrada = new Vector();
        
            paramEntrada.add(dtoChequeoManual);
            paramEntrada.add(id);
            traza("*************** Antes de conectar");
            DruidaConector con = conectar("ConectorVerificarChequeoDefinidos", paramEntrada);            
            traza("*************** Despues de conectar");


            // Verificacion en los registro ya ingresados
			DTOChequeoManual dtoChequeoManualAVerif = (DTOChequeoManual)con.objeto("DTOChequeoManual");    

			traza("dtoChequeoManualAVerif: " + dtoChequeoManualAVerif);

			ArrayList chequeosManualesIngresados = (ArrayList) this.conectorParametroSesion("chequeosManualesIngresados"); 

			traza("chequeosManualesIngresados: " + chequeosManualesIngresados);

			int cant = chequeosManualesIngresados.size();
			DTOChequeoManual dtoChequeoManualVerif = null;
			SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			Date fechaDesdeVerif = null;
			Date fechaHastaVerif = null;
			String codClienteVerif = null;
		    Long oidTipoChequeoVerif = null;

			Date fechaDesdeAVerif = formatter.parse(dtoChequeoManualAVerif.getFechaDesdeInicio());
			Date fechaHastaAVerif = formatter.parse(dtoChequeoManualAVerif.getFechaHastaFin());

			for(int i=0; i<cant; i++){

				dtoChequeoManualVerif = (DTOChequeoManual)chequeosManualesIngresados.get(i);

				traza("dtoChequeoManualVerif: " + dtoChequeoManualVerif);

				fechaDesdeVerif = formatter.parse(dtoChequeoManualVerif.getFechaDesdeInicio());
				fechaHastaVerif = formatter.parse(dtoChequeoManualVerif.getFechaHastaFin());
				codClienteVerif = dtoChequeoManualVerif.getCodigoCliente();
		        oidTipoChequeoVerif = dtoChequeoManualVerif.getOidTipoRevision();

				traza("fechaDesdeAVerif: " + fechaDesdeAVerif);
				traza("fechaHastaAVerif: " + fechaHastaAVerif);
				traza("fechaDesdeVerif: " + fechaDesdeVerif);
				traza("fechaHastaVerif: " + fechaHastaVerif);

				if(((fechaDesdeAVerif.compareTo(fechaDesdeVerif) <= 0 && fechaHastaAVerif.compareTo(fechaDesdeVerif) >=0) ||
				    (fechaDesdeAVerif.compareTo(fechaDesdeVerif) >= 0 && fechaHastaAVerif.compareTo(fechaHastaVerif) <=0) ||
				    (fechaDesdeAVerif.compareTo(fechaHastaVerif) <= 0 && fechaHastaAVerif.compareTo(fechaHastaVerif) >=0) ||
				    (fechaDesdeAVerif.compareTo(fechaDesdeVerif) <= 0 && fechaHastaAVerif.compareTo(fechaHastaVerif) >=0)) &&
				    codClienteVerif.equals(dtoChequeoManualAVerif.getCodigoCliente()) && oidTipoChequeoVerif.equals(dtoChequeoManualAVerif.getOidTipoRevision())) {

						traza("solapamiento");
						throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC + "0011"));     
				}
			}

            // Almaceno en memoria el chequeo ingresado 
			chequeosManualesIngresados.add(dtoChequeoManualAVerif);
			this.conectorParametroSesion("chequeosManualesIngresados", chequeosManualesIngresados); 
            
            asignarAtributo("VAR", "ejecutar", "valor", "aniadirRegistro()");
            
       } catch(Exception e) {
           traza("Excepcion: " + e);
           asignarAtributo("VAR", "ejecutarError", "valor", "ejecutarErrorVerificar()");
           throw e;
       }
  }

    private void inicializar() throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- inicializar ***");

		this.cargarComboTipoOrdenChequeo();           
        this.asignarIdiomaPais(); 

        getConfiguracionMenu("LPIntroducirOrdenesChequeos", "");

        traza("*** Salida -  LPIntroducirOrdenesChequeos- inicializar ***");
    }

    private void seleccionarTipoOrden () throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- seleccionarTipoOrden ***");
		this.tipoOrdenChequeo = conectorParametroLimpia("cbSeleccionarChequeo", "", true);
        traza("*** seleccionarTipoOrden ***: " + this.tipoOrdenChequeo );
        traza("*** seleccionarTipoOrden ***: " + ConstantesREC.CHEQUEO_MANUAL.toString() );
        traza("*** seleccionarTipoOrden ***: " + ConstantesREC.CHEQUEO_EN_LINEA.toString() );
        traza("*** seleccionarTipoOrden ***: " + ConstantesREC.CHEQUEO_EN_CAMPO.toString() );
		

		if (this.tipoOrdenChequeo.equals(ConstantesREC.CHEQUEO_MANUAL.toString())) {	//1
			this.cargarChequeoManual(); 
		// vbongiov -- Cambio 20080756 -- 29/04/2009
		} else if (this.tipoOrdenChequeo.equals(ConstantesREC.CHEQUEO_EN_LINEA.toString()) ||
			       this.tipoOrdenChequeo.equals(ConstantesREC.CHEQUEO_EN_CAMPO.toString())) {	
			this.cargarChequeoEnLinea(); 
		} 

        this.asignarIdiomaPais(); 
        asignar("VAR", "tipoOrdenChequeo", this.tipoOrdenChequeo);

        traza("*** Salida -  LPIntroducirOrdenesChequeos- seleccionarTipoOrden ***");
    }
    

    private void cargarChequeoManual() throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- cargarChequeoManual  ***");
        pagina("contenido_ordenes_chequeo_introducir_manual");
		Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
		asignar("VAR", "longitudCodigoCliente", longitudCodigoCliente.toString());
		asignar("VAR", "tipoOrdenChequeo", this.tipoOrdenChequeo);
		asignar("LABELC", "lbldtSeleccionarChequeo", conectorParametroLimpia("descripcion", "", true));
		this.asignarMarcaCanalPorDefecto();	
		
        this.cargarCombosChequeoManual();

        // vbongiov -- Cambio 20080756 -- 29/04/2009
		ArrayList chequeosManualesIngresados = new ArrayList();
		this.conectorParametroSesion("chequeosManualesIngresados", chequeosManualesIngresados); 


        getConfiguracionMenu("LPIntroducirOrdenesChequeos", "Manual");
        traza("*** Salida -  LPIntroducirOrdenesChequeos- cargarChequeoManual ***");
    }

    private void cargarCabeceraChequeoEnCampo() throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- cargarCabeceraChequeoEnCampo  ***");
        pagina("contenido_ordenes_chequeo_introducir1");
		this.getFormatosValidaciones();
		asignar("VAR", "tipoOrdenChequeo", this.tipoOrdenChequeo);
		asignar("LABELC", "lbldtSeleccionarChequeo", conectorParametroLimpia("descripcion", "", true));
		asignar("VAR", "nombreChequeo", conectorParametroLimpia("descripcion", "", true));
		this.asignarMarcaCanalPorDefecto();		
        this.cargarCombosCabeceraChequeoEnCampo();
        getConfiguracionMenu("LPIntroducirOrdenesChequeos", "CabeceraCampo");
        traza("*** Salida -  LPIntroducirOrdenesChequeos- cargarCabeceraChequeoEnCampo  ***");
    }

    private void cargarChequeoEnCampo () throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- cargarChequeoEnCampo  ***");
        this.cargarCombosChequeoEnCampo();
        String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR", "hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);


		asignar("VAR", "tipoOrdenChequeo", conectorParametroLimpia("tipoOrdenChequeo", "", true));
		asignar("LABELC", "lbldtSeleccionarChequeo", conectorParametroLimpia("nombreChequeo", "", true));
		asignar("VAR", "marca", conectorParametroLimpia("cbMarca", "", true));
		asignar("VAR", "canal", conectorParametroLimpia("cbCanal", "", true));
		asignar("VAR", "oidPeriodo", conectorParametroLimpia("cbPeriodo", "", true));
		asignar("LABELC", "lbldtMarca2", conectorParametroLimpia("nombreMarca", "", true));
		asignar("LABELC", "lbldtCanal2", conectorParametroLimpia("nombreCanal", "", true));
		asignar("LABELC", "lbldtPeriodo2", conectorParametroLimpia("nombrePeriodo", "", true));
        getConfiguracionMenu("LPIntroducirOrdenesChequeos", "Campo");
     
        traza("*** Salida -  LPIntroducirOrdenesChequeos- cargarChequeoEnCampo  ***");
    }

    private String obtenerChequeoEnCampo () throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- obtenerChequeoEnCampo  ***");
        // Busca en BD si existen datos para el periodo seleccionado. 
		// Si es así los recupera y los muestra en la página 
		String periodo = conectorParametroLimpia("cbPeriodo", "", true);
		DTOOID dto = new DTOOID();
		dto.setOidPais(this.pais);
        dto.setOidIdioma(this.idioma);
        dto.setOid(new Long(periodo));

        MareBusinessID idBusiness = new MareBusinessID("RECObtenerChequeoEnCampo");

        Vector paramEntrada = new Vector();
        paramEntrada.add(dto);
        paramEntrada.add(idBusiness);

        DruidaConector conector = conectar("ConectorObtenerChequeoEnCampo", paramEntrada);
		es.indra.sicc.dtos.rec.DTOChequeoEnCampo dtoChequeo = (es.indra.sicc.dtos.rec.DTOChequeoEnCampo)conector.objeto("DTOChequeoEnCampo");
		traza("dtoChequeo obtenido: " + dtoChequeo);
		
		StringBuffer sVarEjecutar = new StringBuffer("");
		String sParams = this.mostrarChequeoEnCampo(dtoChequeo);
		sVarEjecutar.append("luegoObtenerChequeo(");
		sVarEjecutar.append(sParams);
		sVarEjecutar.append(")");

		this.asignarAtributo("VAR", "ejecutar", "valor", sVarEjecutar.toString());
        traza("*** Salida -  LPIntroducirOrdenesChequeos- obtenerChequeoEnCampo  ***");
		traza("sVarEjecutar.toString(): " + sVarEjecutar.toString());

		return sVarEjecutar.toString();
    }

    private String mostrarChequeoEnCampo(es.indra.sicc.dtos.rec.DTOChequeoEnCampo dtoChequeo) throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- mostrarChequeoEnCampo  ***");
        // Busca en BD si existen datos para el periodo seleccionado. 
		// Si es así los recupera y los muestra en la página 
		// Carga en la página PGChequeoEnCampo los datos recibidos 
		String cantidad = "";
		String periodoINI = "";
		String periodoFIN = "";
		String periodoRECLAMO = "";
		String consultoraNueva = "";
		String oidChequeo = "";

		StringBuffer sCadenaVars = new StringBuffer("");
		if (dtoChequeo == null) {
			sCadenaVars.append("'', '', '', '', '', '', ''");
		} else { 
			if (dtoChequeo.getCantidadTotalChequear() != null) {
				cantidad = dtoChequeo.getCantidadTotalChequear();
				sCadenaVars.append("'" + cantidad + "'");
			} else {
				sCadenaVars.append("''");
			}
			sCadenaVars.append(",");

			if (dtoChequeo.getOidPeriodoInicial() != null) {
				periodoINI = dtoChequeo.getOidPeriodoInicial().toString();
				sCadenaVars.append("'" + periodoINI + "'");
			} else {
				sCadenaVars.append("''");
			}
			sCadenaVars.append(",");

			if (dtoChequeo.getOidPeriodoFinal() != null) {
				periodoFIN = dtoChequeo.getOidPeriodoFinal().toString();
				sCadenaVars.append("'" + periodoFIN + "'");
			} else {
				sCadenaVars.append("''");
			}
			sCadenaVars.append(",");

			if (dtoChequeo.getOidPeriodoReclamo() != null) {
				periodoRECLAMO = dtoChequeo.getOidPeriodoReclamo().toString();
				sCadenaVars.append("'" + periodoRECLAMO + "'");
			} else {
				sCadenaVars.append("''");
			}
			sCadenaVars.append(",");			

			if (dtoChequeo.getConsultoraNueva() != null) {
				consultoraNueva = this.booleanToStr(dtoChequeo.getConsultoraNueva());
				sCadenaVars.append("'" + consultoraNueva + "'");
			} else {
				sCadenaVars.append("''");
			}
			sCadenaVars.append(",");

			if (dtoChequeo.getOid() != null) {
				oidChequeo = dtoChequeo.getOid().toString();
				sCadenaVars.append("'" + oidChequeo + "'");
			} else {
				sCadenaVars.append("''");
			}
			sCadenaVars.append(",");

			RecordSet rZonas = dtoChequeo.getBusquedaZonas();
			if (rZonas != null && !rZonas.esVacio() ) {
				String sArmaLista = this.armaLista(rZonas);
				sCadenaVars.append("'" + sArmaLista + "'");
			} else {
				sCadenaVars.append("''");
			}

		}
		
        /*asignar("CTEXTO", "txtCantidadTotal", cantidad );
        asignar("VAR", "cantidad", cantidad );
		asignar("VAR", "periodoINI", periodoINI);
		asignar("VAR", "periodoFIN", periodoFIN);
		asignar("VAR", "periodoRECLAMO", periodoRECLAMO);
		asignarAtributo("CHECKBOX", "chkConsultorasNuevas2", "check", consultoraNueva);
		asignar("VAR", "hid_chkConsultorasNuevas2", consultoraNueva);*/

		/*if (dtoChequeo.getBusquedaZonas() != null ) {
			DruidaConector conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", dtoChequeo.getBusquedaZonas(), dtoChequeo.getBusquedaZonas().getColumnIdentifiers());
			asignar("LISTAEDITABLE", "listado2", conectorCargaLista, "DTOSalida.combo_ROWSET");
       	}
		asignar("VAR", "oidChequeo", oidChequeo);*/

        traza("*** Salida -  LPIntroducirOrdenesChequeos- mostrarChequeoEnCampo  ***");
		return sCadenaVars.toString(); 
    }


	private String armaLista(RecordSet rZonas) throws Exception {
		int nCantRegistros = rZonas.getRowCount();
		StringBuffer sLista = new StringBuffer("");
		String sOid = null;
		/*String sCodigo = null;*/
		String sSGV = null;
		String sRegion = null;
		String sZona = null;
		String sSeccion = null;
		BigDecimal bigCodigo = null;
		BigDecimal bigOidSGV = null;
		BigDecimal bigOidRegion = null;
		BigDecimal bigOidZona = null;
		BigDecimal bigOidSeccion = null;

		for (int i=0; i < nCantRegistros; i++) {
			if (i != 0) {
			   sLista.append("|");
			}

			sOid = rZonas.getValueAt(i,0).toString();
			bigCodigo = (BigDecimal) rZonas.getValueAt(i,1);

			bigOidSGV = (BigDecimal) rZonas.getValueAt(i,2);
			sSGV = (String) rZonas.getValueAt(i,3);

			bigOidRegion = (BigDecimal) rZonas.getValueAt(i,4);
			sRegion = (String) rZonas.getValueAt(i,5);

			bigOidZona = (BigDecimal) rZonas.getValueAt(i,6);
			sZona = (String) rZonas.getValueAt(i,7);

			bigOidSeccion = (BigDecimal) rZonas.getValueAt(i,8);
			sSeccion = (String) rZonas.getValueAt(i,9);

			sLista.append(sOid);
			sLista.append("~");

			if (bigCodigo != null) {
				sLista.append(bigCodigo.toString());
			} else {
				sLista.append(" ");
			}
			sLista.append("~");

			/* SGV */ 
			if (bigOidSGV != null) {
				sLista.append( bigOidSGV.toString() );
			} else {
				sLista.append(" ");
			}
			sLista.append("~");

			if (sSGV == null || sSGV.equals("") ) {
				sLista.append(" ");
			} else {
				sLista.append( sSGV );
			}
			sLista.append("~");

			/* Region */ 
			if (bigOidRegion != null) {
				sLista.append( bigOidRegion.toString() );
			} else {
				sLista.append(" ");
			}
			sLista.append("~");

			if (sRegion == null || sRegion.equals("") ) {
				sLista.append(" ");
			} else {
				sLista.append(sRegion);
			}
			sLista.append("~");

			/* Zona */ 
			if (bigOidZona != null) {
				sLista.append( bigOidZona.toString() );
			} else {
				sLista.append(" ");
			}
			sLista.append("~");

			if (sZona == null || sZona.equals("") ) {
				sLista.append(" ");
			} else {
				sLista.append(sZona);
			}
			sLista.append("~");

			/* Seccion */ 
			if (bigOidSeccion != null) {
				sLista.append(bigOidSeccion.toString());
			} else {
				sLista.append(" ");
			}
			sLista.append("~");

			if (sSeccion == null || sSeccion.equals("") ) {
				sLista.append(" ");
			} else {
				sLista.append(sSeccion);
			}
		}

		return sLista.toString();
	}

    private void cargarChequeoEnLinea() throws Exception { 
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- cargarChequeoEnLinea  ***");
        
        pagina("contenido_ordenes_chequeo_introducir_linea");
        asignarAtributo("PAGINA", "contenido_ordenes_chequeo_introducir_linea", "cod", "0146");
        asignarAtributo("PAGINA", "contenido_ordenes_chequeo_introducir_linea", "msgle", "Introducir Ordenes de Chequeo");
		
		Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
		asignar("VAR", "longitudCodigoCliente", longitudCodigoCliente.toString());
		asignar("VAR", "tipoOrdenChequeo", this.tipoOrdenChequeo);
		asignar("LABELC", "lbldtSeleccionarChequeo", conectorParametroLimpia("descripcion", "", true));

        // vbongiov -- Cambio 20080756 -- 29/04/2009
		// Inicializa los chequeos Linea o Campo
		ArrayList chequeosLineaCampoIngresados = new ArrayList();
		this.conectorParametroSesion("chequeosLineaCampoIngresados", chequeosLineaCampoIngresados); 

		this.asignarIdiomaPais();
		this.asignarMarcaCanalPorDefecto();
        this.cargarCombosChequeoEnLinea();
        
        // LPIntroducirOrdenesChequeos/Linea  = 	0146,1,1,0,0,1,1,0,0,0,1
        getConfiguracionMenu("LPIntroducirOrdenesChequeos", "Linea");
                
        traza("*** Salida -  LPIntroducirOrdenesChequeos- cargarChequeoEnLinea ***");
    }

    private void guardarChequeoManual() throws Exception {  
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- guardarChequeoManual  ***");

		es.indra.sicc.dtos.rec.DTOChequeo  dtoChequeo = new es.indra.sicc.dtos.rec.DTOChequeo();
		dtoChequeo.setOidPais(this.pais);
        dtoChequeo.setOidIdioma(this.idioma);

		// vbongiov -- Cambio 20080756 -- 29/04/2009
		ArrayList chequeosManualesIngresados = (ArrayList) this.conectorParametroSesion("chequeosManualesIngresados"); 
		dtoChequeo.setListaChequeos(chequeosManualesIngresados);

        traza("dtoChequeo: " + dtoChequeo);

        MareBusinessID idBusiness = new MareBusinessID("RECGrabarChequeoManual");

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoChequeo);
        paramEntrada.add(idBusiness);

        DruidaConector conector = conectar("ConectorGrabarChequeoManual", paramEntrada);

		// vbongiov -- Cambio 20080756 -- 29/04/2009
		this.conectorParametroSesion("chequeosManualesIngresados", new ArrayList()); 		
        asignar("VAR", "cerrarVentana", "true");

        traza("*** Salida -  LPIntroducirOrdenesChequeos- guardarChequeoManual  ***");
    }
    

	// vbongiov -- Cambio 20080756 -- 29/04/2009
    private void guardarChequeoEnLinea() throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- guardarChequeoEnLinea  ***");
        
        pagina("salidaGenerica");
        asignar("VAR", "cerrarVentana", "true");

        String oidTipoChequeo = conectorParametroLimpia("tipoOrdenChequeo", "", true);
		String chkConsultorasReincidentes = conectorParametroLimpia("chkConsultorasReincidentes", "", true); 
		String txtCantidadMinima = conectorParametroLimpia("txtCantidadMinima", "", true); 
		String txtCantidadPeriHaciaAtras = conectorParametroLimpia("txtCantidadPeriHaciaAtras", "", true); 
		String chkConsultorasNuevas = conectorParametroLimpia("chkConsultorasNuevas", "", true); 

		es.indra.sicc.dtos.rec.DTOChequeo  dtoChequeo = new es.indra.sicc.dtos.rec.DTOChequeo();
		dtoChequeo.setOidPais(this.pais);
        dtoChequeo.setOidIdioma(this.idioma);
		dtoChequeo.setIndConsReincidentes(chkConsultorasReincidentes.equals("")?null:(chkConsultorasReincidentes.equals("S")?Boolean.TRUE:Boolean.FALSE));
		dtoChequeo.setCantidadMinima(txtCantidadMinima.equals("")?null:new Integer(txtCantidadMinima));
		dtoChequeo.setCantidadPeriHaciaAtras(txtCantidadPeriHaciaAtras.equals("")?null:new Integer(txtCantidadPeriHaciaAtras));
		dtoChequeo.setIndConsNuevas(chkConsultorasNuevas.equals("")?null:(chkConsultorasNuevas.equals("S")?Boolean.TRUE:Boolean.FALSE));

		dtoChequeo.setOidTipoRevision(Long.valueOf(oidTipoChequeo));

		ArrayList chequeosLineaCampoIngresados = (ArrayList) this.conectorParametroSesion("chequeosLineaCampoIngresados"); 
		dtoChequeo.setListaChequeos(chequeosLineaCampoIngresados);
		
		traza("****** dtoChequeo creado: " + dtoChequeo);

        MareBusinessID idBusiness = new MareBusinessID("RECGrabarChequeoLineaCampo");

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoChequeo);
        paramEntrada.add(idBusiness);

        DruidaConector conector = conectar("ConectorGrabarChequeoEnLinea", paramEntrada);

		this.conectorParametroSesion("chequeosLineaCampoIngresados", new ArrayList()); 	


        traza("*** Salida -  LPIntroducirOrdenesChequeos- guardarChequeoEnLinea  ***");
    }

    private void guardarChequeoEnCampo() throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- guardarChequeoEnCampo  ***");

		Long oidChequeo = this.numeroLong(conectorParametroLimpia("oidChequeo", "", true));
		Long oidPeriodo = this.numeroLong(conectorParametroLimpia("cbPeriodo", "", true));
		traza("oidChequeo: " + oidChequeo);

		es.indra.sicc.dtos.rec.DTOChequeoEnCampo  dtoChequeo = new es.indra.sicc.dtos.rec.DTOChequeoEnCampo();
		dtoChequeo.setOidPais(this.pais);
    	dtoChequeo.setOidIdioma(this.idioma);
		dtoChequeo.setOid(oidChequeo); // oidChequeo
		/*dtoChequeo.setOidPeriodo(this.numeroLong(conectorParametroLimpia("oidPeriodo", "", true))); */
		dtoChequeo.setOidPeriodo(oidPeriodo);
		dtoChequeo.setOidPeriodoInicial(this.numeroLong(conectorParametroLimpia("cblPeriodoInicialEvaluacion2", "", true))); // oidPeriodoInicial
		dtoChequeo.setOidPeriodoFinal(this.numeroLong(conectorParametroLimpia("cbPeriodoFinalEvaluacion2", "", true))); // oidPeriodoFinal
		dtoChequeo.setOidPeriodoReclamo(this.numeroLong(conectorParametroLimpia("cbPeriodoReclamoEvaluacion", "", true))); // oidPeriodoReclamo
		dtoChequeo.setCantidadTotalChequear(this.cadena(conectorParametroLimpia("txtCantidadTotal", "", true))); // cantidadTotal
		dtoChequeo.setConsultoraNueva(this.strToBoolean(conectorParametroLimpia("chkConsultorasNuevas2", "", true))); // consultoraNueva
		dtoChequeo.setListaZonas (new java.util.ArrayList());

		String zonas = conectorParametroLimpia("zonas", "", true);

		StringTokenizer st = new StringTokenizer(zonas, "#");
		while (st.countTokens() > 0) {
			String fila = st.nextToken();
			es.indra.sicc.dtos.rec.DTOChequeoZona dtoChequeoZona = new es.indra.sicc.dtos.rec.DTOChequeoZona();
			dtoChequeoZona.setOidPais(this.pais);
	        dtoChequeoZona.setOidIdioma(this.idioma);
			dtoChequeoZona.setOid(oidChequeo); // oidChequeo

			if (!fila.equals("")) {
				StringTokenizer stFila = new StringTokenizer(fila, "@");
				if (stFila.countTokens() > 0) {
					dtoChequeoZona.setOidSubgerenciaVentas(this.numeroLong(stFila.nextToken())); // oidSubgerenciaVentas
					dtoChequeoZona.setOidRegion(this.numeroLong(stFila.nextToken())); // oidRegion
					dtoChequeoZona.setOidZona(this.numeroLong(stFila.nextToken())); // oidZona
					dtoChequeoZona.setOidSeccion(this.numeroLong(stFila.nextToken())); // oidSeccion
				}
			}
			dtoChequeo.getListaZonas().add(dtoChequeoZona);
		}

		traza("dtoChequeo: " + dtoChequeo);
        MareBusinessID idBusiness = new MareBusinessID("RECGrabarChequeoEnCampo");

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoChequeo);
        paramEntrada.add(idBusiness);

        DruidaConector conector = conectar("ConectorGrabarChequeoEnCampo", paramEntrada);
		
        asignar("VAR", "ejecutar", "window.close()");

        traza("*** Salida -  LPIntroducirOrdenesChequeos- guardarChequeoEnCampo  ***");
    }

     private void cargarComboTipoOrdenChequeo() throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- cargarComboTipoOrdenChequeo ***");

        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = null;

        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(this.pais);
        dtoBelcorp.setOidIdioma(this.idioma);

        elem = new ComposerViewElement(); 
        elem.setIDBusiness("RECObtenerTiposOrdenChequeo");
        elem.setDTOE(dtoBelcorp);
        listelem.addViewElement(elem);
   
        // Llamamos al subsistema GestorCargaPantalla. 
        ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
        conector.ejecucion();
        DruidaConector conConsulta = conector.getConector();
                
        asignar("COMBO", "cbSeleccionarChequeo", conConsulta, "RECObtenerTiposOrdenChequeo");

        traza("*** Salida -  LPIntroducirOrdenesChequeos- cargarComboTipoOrdenChequeo ***");
    }
 
    private void cargarCombosChequeoManual() throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- cargarCombosChequeoManual ***");
        
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = null;

        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(this.pais);
        dtoBelcorp.setOidIdioma(this.idioma);

        String[] idBussines = new String[3];
        idBussines[0] = "SEGConsultaMarcas";	//1 y 3
        idBussines[1] = "SEGConsultaCanales";	//1 y 3
        idBussines[2] = "PEDObtenerIndicadoresRevision";


        for (int i = 0; i < idBussines.length; i++) {
            elem = new ComposerViewElement(); 
            elem.setIDBusiness(idBussines[i]);
            elem.setDTOE(dtoBelcorp);
            listelem.addViewElement(elem);
        }

        ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
        conector.ejecucion();
               
        DruidaConector conConsulta = conector.getConector();
                
        asignar("COMBO", "cbMarca1", conConsulta, "SEGConsultaMarcas");
        asignar("COMBO", "cbCanal1", conConsulta, "SEGConsultaCanales");
        asignar("COMBO", "cbTipoChequeo", conConsulta, "PEDObtenerIndicadoresRevision");

        traza("*** Salida -  LPIntroducirOrdenesChequeos- cargarCombosChequeoManual ***");
    }
    

    private void cargarCombosCabeceraChequeoEnCampo() throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos- cargarCombosCabeceraChequeoEnCampo ***");
        
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = null;

        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(this.pais);
        dtoBelcorp.setOidIdioma(this.idioma);

        String[] idBussines = new String[2];
        idBussines[0] = "SEGConsultaMarcas";	//1 y 3
        idBussines[1] = "SEGConsultaCanales";	//1 y 3

        for (int i = 0; i < idBussines.length; i++) {
            elem = new ComposerViewElement(); 
            elem.setIDBusiness(idBussines[i]);
            elem.setDTOE(dtoBelcorp);
            listelem.addViewElement(elem);
        }

        ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
        conector.ejecucion();
               
        DruidaConector conConsulta = conector.getConector();
                
        asignar("COMBO", "cbMarca", conConsulta, "SEGConsultaMarcas");
        asignar("COMBO", "cbCanal", conConsulta, "SEGConsultaCanales");

        traza("*** Salida -  LPIntroducirOrdenesChequeos- cargarCombosCabeceraChequeoEnCampo ***");
	}

    // incidencia 15960
    private void cargarCombosChequeoEnLinea() throws Exception {
        traza("*** Entrada -  LPIntroducirOrdenesChequeos - cargarCombosChequeoEnLinea ***");
        
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = null;

        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(this.pais);
        dtoBelcorp.setOidIdioma(this.idioma);

		// combo marcas
		elem = new ComposerViewElement(); 
		elem.setIDBusiness("SEGConsultaMarcas");
		elem.setPosOID(new Byte("0").byteValue()); 
        elem.setPosDesc(new Byte("1").byteValue());
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem);
        
		// combo canales
		traza("*************************** antes de cargar el combo canales 3");
		elem = new ComposerViewElement(); 
		elem.setIDBusiness("SEGConsultaCanales");
		elem.setPosOID(new Byte("0").byteValue()); 
		elem.setPosDesc(new Byte("1").byteValue());
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem);
        
        ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
        conector.ejecucion();
               
        DruidaConector conConsulta = conector.getConector();
        
        asignar("COMBO", "cbMarca", conConsulta, "SEGConsultaMarcas");
        asignar("COMBO", "cbCanal", conConsulta, "SEGConsultaCanales");

        traza("*** Salida -  LPIntroducirOrdenesChequeos- cargarCombosChequeoEnLinea ***");
    }
    
    // incidencia 15960
    private void cargarCombosChequeoEnCampo() throws Exception {

		traza("*** Entrada -  LPIntroducirOrdenesChequeos- cargarCombosChequeoEnCampo ***");
        
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = null;

        DTOPeriodo dtoPeriodo = new DTOPeriodo();
        dtoPeriodo.setOidPais(this.pais);
        dtoPeriodo.setPais(this.pais);
        dtoPeriodo.setOidIdioma(this.idioma);
        dtoPeriodo.setMarca(new Long(conectorParametroLimpia("cbMarca", "", true)));
        dtoPeriodo.setCanal(new Long(conectorParametroLimpia("cbCanal", "", true)));

        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(this.pais);
        dtoBelcorp.setOidIdioma(this.idioma);

        elem = new ComposerViewElement(); 
        elem.setIDBusiness("CRAObtenerPeriodos"); // BELC300020479. Antes se utilizaba CRAObtenerPeriodosPosteriores
        elem.setDTOE(dtoPeriodo);
        listelem.addViewElement(elem);

        elem = new ComposerViewElement(); 
        elem.setIDBusiness("RECObtenerPeriodosReclamo");
        elem.setDTOE(dtoBelcorp);
        listelem.addViewElement(elem);

		// combo subgerencia ventas
		DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
		dtoUA.setOidPais(this.pais);
		dtoUA.setOidMarca(new Long(conectorParametroLimpia("cbMarca", "", true)));
		dtoUA.setOidCanal(new Long(conectorParametroLimpia("cbCanal", "", true)));
		elem = new ComposerViewElement(); 
		elem.setIDBusiness("ZONRecargaSubgerenciaVentas");
		elem.setDTOE(dtoUA);
		listelem.addViewElement(elem);        

        ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
        conector.ejecucion();
               
        DruidaConector conConsulta = conector.getConector();

        asignar("COMBO", "cblPeriodoInicialEvaluacion2", conConsulta, "CRAObtenerPeriodos"); // BELC300020479. Antes se utilizaba CRAObtenerPeriodosPosteriores
        asignar("COMBO", "cbPeriodoFinalEvaluacion2", conConsulta, "CRAObtenerPeriodos"); // BELC300020479. Antes se utilizaba CRAObtenerPeriodosPosteriores
        asignar("COMBO", "cbPeriodoReclamoEvaluacion", conConsulta, "RECObtenerPeriodosReclamo");
        asignar("COMBO", "cbSubgerenciaVentas2", conConsulta, "ZONRecargaSubgerenciaVentas");

        traza("*** Salida -  LPIntroducirOrdenesChequeos- cargarCombosChequeoEnCampo ***");
    }

    private void asignarIdiomaPais() throws Exception {
        asignar("VAR", "idioma", this.idioma.toString());
        asignar("VAR", "pais", this.pais.toString());    
    }
    
    private void asignarMarcaCanalPorDefecto() throws Exception {
			// cada usuario tiene una marca y canal por defecto que deben seleccionarse
			Long marca = UtilidadesSession.getMarcaPorDefecto(this);
			Long canal = UtilidadesSession.getCanalPorDefecto(this);
			
			// se asignan estos valores a campos ocultos de la pagina
			asignar("VAR", "marcaPorDefecto", marca.toString());
			asignar("VAR", "canalPorDefecto", canal.toString()); 
    }
    

	private String booleanToStr(Boolean boo) throws Exception {
        if (boo != null && boo.booleanValue())
        	return "S";
        return "N";
    }


	private Boolean strToBoolean(String entrada) throws Exception {
		if (entrada != null && entrada.equals("S"))
        	return new Boolean(true);
        return new Boolean(false);
    }


	private String cadena(String entrada) throws Exception {
		if (entrada != null && !entrada.equals("-") && !entrada.equals("")) {
			return entrada;
		}
		return null;
	}
	
	private Long numeroLong(String entrada) throws Exception{
		if (entrada != null && !entrada.equals("-") && !entrada.equals("")) {
			return new Long(entrada);
		}
		return null;	
	}
	
	private Integer numeroInteger(String entrada) throws Exception{
		if (entrada != null && !entrada.equals("-") && !entrada.equals("")) {
			return new Integer(entrada);
		}
		return null;	
	}

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());		
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);		
        traza("Stack Trace: " + baos.toString());
    }
}                                                               