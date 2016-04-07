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
    $Id: LPCancelacionCuotas.java,v 1.1 2009/12/03 18:33:31 pecbazalar Exp $
    DESC
*/

import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.druida.DruidaConector;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

import es.indra.sicc.dtos.ccc.DTOCargaInicialCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCasoUso;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;

// Definicion de la clase
public class LPCancelacionCuotas extends LPSICCBase {
	
	private boolean combosEditables = true;
	// Definicion del constructor
	public LPCancelacionCuotas() {super();}
	
	// Definicion del metodo abstracto inicio
	public void inicio() throws Exception {
	
	  	// Defino el nombre de la vista
	    pagina("contenido_cuotas_cancelacion");
	}
	
	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
	     try{
	              setTrazaFichero();
	              traza("***Entrada - LPCancelacionCuotas - ejecucion***");
	                
	              String accion = conectorParametroLimpia("accion","",true);
	              traza("***accion : "+accion);
	                
	              //Bifurcamos la accion
	              if ( accion.equals("")) {
	                       accionVacia();
	              }
	              
	              getConfiguracionMenu("LPCancelacionCuotas",accion);
	              traza("***Salida - LPCancelacionCuotas - ejecucion***");
	     }catch(Exception e){
	              logStackTrace(e);
	              lanzarPaginaError(e);
	     }
	}
/*	
	private void accionPrueba() throws Exception{
		traza ("++++ ENTRADA - LPCancelacionCuotas - accionPRUEBA");
		
		//Creamos un DTOOIDs con los oids de Mov.CC. 
		//idBusiness = "CCCEliminarBloqueosMovCC" 
		//Llamamos al "ConectorEliminarBloqueosMovCC" con el dto y el idBusiness 
		
		Long oid[] = new Long[2];
		oid[0] = new Long(5);
		oid[1] = new Long(7);
		Vector paramEntrada = new Vector();
		DTOOIDs oids = new DTOOIDs();
		oids.setOids(oid);
		traza ("OID: " +oids);
		oids.setOidIdioma(new Long(1));
		oids.setOidPais(new Long(1));				
		
		paramEntrada.add(oids);
		paramEntrada.add(new MareBusinessID("CCCEliminarBloqueosMovCC"));
		
		traza ("PARAMETROS ENTRADA: "+ paramEntrada);
		traza("ANTES CONECTAR");
		DruidaConector conector = conectar("ConectorEliminarBloqueosMovCC", paramEntrada);
		
		
		traza ("++++ SALIDA - LPCancelacionCuotas - accionPRUEBA");
	}
*/	
	private void accionVacia() throws Exception {
	    traza("***Entrada -  LPCancelacionCuotas - accionVacia");
	     
		//Si recibimos como parametros el codigoCliente rellenamos el campo correspondiente
		// y el botón de seleccionar cliente lo desabilitamos. 
		String codigoCliente = conectorParametroLimpia("codigoCliente","",true);
		if(!codigoCliente.equals(""))
		{
			asignarAtributo("TEXT","txtCodCliente","valor",codigoCliente);
			asignarAtributo("TEXT","txtCodCliente","disabled","S");
		}
			
		//Debemos recibir los parametros proceso y empresa, y lo guardamos en las 
		//variables ocultas del mismo nombre. 
		
		String proceso = conectorParametroLimpia("proceso","",true);
		String subproceso = conectorParametroLimpia("subproceso","",true);
		String empresa = conectorParametroLimpia("empresa","",true);
		asignarAtributo("VAR","proceso","valor",proceso);
		asignarAtributo("VAR","subproceso","valor",subproceso);
		asignarAtributo("VAR","empresa","valor",empresa);
		
	
		//Llamamos a obtenerLongitudCodigoCliente y con el resultado rellenamos el 
		//campo oculto longitudCodigoCliente 
		
		//Byte longitud = this.obtenerLongitudCodigoCliente();
		//Long longitudCodigoCliente = new Long(longitud.longValue());
		Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
		asignarAtributo("VAR","longitudCodigoCliente","valor",longitudCodigoCliente.toString());
		
		//Rellena datos generales de la pagina
	        UtilidadesSession session = new UtilidadesSession();
	        Long pais = session.getPais(this);
	        Long idioma = session.getIdioma(this);
	        asignarAtributo("VAR", "idioma", "valor", idioma.toString());
	        asignarAtributo("VAR", "pais", "valor", pais.toString());
	        
	        //Guardamos los valores de los separadores
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
	   	 String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
			 separadorMiles = ".";
		}
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
		
		traza ("CANAL: "+conectorParametroLimpia("canal","",true));
		traza ("ACCESO: "+conectorParametroLimpia("acceso","",true));
		traza ("SUBACCESO: "+conectorParametroLimpia("subacceso","",true));
		
		String canal = conectorParametroLimpia("canal","",true);
		String acceso = conectorParametroLimpia("acceso","",true);
		String subacceso = conectorParametroLimpia("subacceso","",true);
		
		asignarAtributo("VAR","hcanal","valor",canal);
		asignarAtributo("VAR","hacceso","valor",acceso);
		asignarAtributo("VAR","hsubacceso","valor",subacceso);

/*		
		Vector valores = null 
		RecordSet rs = new RecordSet();
		if (!canal.equals("")){
			valores=new Vector();
			valores.add(canal);
			valores.add(descCanal);
			rs = new RecordSet();
			rs.addColumn("CODIGO");
			rs.addColumn("DESCRIPCION");
			rs.addRow(valores);		
			Vector cols = rs.getColumnIdentifiers();
			DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
			asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), canal);
		}
		if (!acceso.equals("")){
			valores=new Vector();
			valores.add(acceso);
			valores.add(descAcceso);
			rs = new RecordSet();
			rs.addColumn("CODIGO");
			rs.addColumn("DESCRIPCION");
			rs.addRow(valores);		
			Vector cols = rs.getColumnIdentifiers();
			DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
			asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), acceso);
		}
		if (!subacceso.equals("")){
			valores=new Vector();
			valores.add(subacceso);
			valores.add(descSubacceso);
			rs = new RecordSet();
			rs.addColumn("CODIGO");
			rs.addColumn("DESCRIPCION");
			rs.addRow(valores);		
			Vector cols = rs.getColumnIdentifiers();
			DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
			asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), subaccesos);
		}		
*/		
		
		//Llamar al subsistema GestorCargaPantalla :- idBusiness = SEGConsultaCanales y DTOBelcorp => llena combo canal 
		Vector paramEntrada = new Vector();
              DTOBelcorp dto = new DTOBelcorp();
              dto.setOidPais(pais);
              dto.setOidIdioma(idioma);		
              
		String [] idNegocios = new String[3];
		idNegocios[0] = new String("SEGConsultaCanales");
		String [] combos = new String[3];
		combos[0] = new String("cbCanal");		
		if (canal.equals("")){
			traza("No llega canal");
			this.cargaCombos(dto, idNegocios, combos, null, null,null,null);	
		}else{
			String [] selecs = new String[3];
			selecs[0] = canal.toString();
			String [] columnas = new String[3];
			columnas[0] = new String("VAL_OID");
			combos[1] = new String("cbAcceso");
			idNegocios[1] = new String("SEGObtenerAccesosPorCanal");
			if (acceso.equals("")){
				traza ("Llega canal pero no acceso");
				this.cargaCombos(dto, idNegocios, combos, selecs, columnas,canal.toString(),null); //mando oid canal para cargar combo acceso
				
			}else{
				selecs[1] = acceso.toString();
				columnas[1] = new String("VAL_OID");
				combos[2] = new String("cbSubacceso");
				idNegocios[2] = new String("SegObtenerSubaccesosPorAcceso");
				if (!subacceso.equals("")){
					traza("Llega Canal, Acceso y Subacceso");
					selecs[2] = subacceso.toString();
					columnas[2] = new String("OID_SBAC");
				}
				this.cargaCombos(dto,idNegocios,combos,selecs,columnas,canal.toString(),acceso.toString());
			}
		}						
		
		if (!canal.equals("")){
			traza("Entra en dehabilitar combos canal");
			combosEditables=false;
			asignarAtributoElemento("cbCanal","disabled","S");
		}
		if (!acceso.equals("")) {
			traza("Entra en dehabilitar combos acceso");
			asignarAtributoElemento("cbAcceso","disabled","S");
		}
		if (!subacceso.equals("")){
			traza("Entra en dehabilitar combos subacceso");
			asignarAtributoElemento("cbSubacceso","disabled","S");
		}

		
		
			
		traza("***Salida -  LPCancelacionCuotas - accionVacia");
	}
	
	protected void logStackTrace(Throwable e) throws Exception {
	    traza("Se produjo la excepcion: " + e.getMessage());
	
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    e.printStackTrace(ps);
	                
	    traza("Stack Trace: " + baos.toString());
	}
    
	private void cargaCombos(DTOBelcorp dtoBelcorp, String[] idNegocios, String[] combos, String[] seleccionados, String[] columnas, String canal, String acceso) throws Exception {
		traza("*** Entrada  LPCancelacionCuotas  - cargaCombos ***");
		try {
			//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
			ComposerViewElementList listelem = new ComposerViewElementList();
			ComposerViewElement elem = null;
			
			
			
			elem=new ComposerViewElement(); 
			elem.setIDBusiness(idNegocios[0]); //SEGConsultaCanales
			elem.setDTOE(dtoBelcorp);
			listelem.addViewElement(elem);
			
			traza("++++ antes de comprobar si canal");
			if (canal != null){
				DTOAccesosPorCanal dtoapc = new DTOAccesosPorCanal();
				dtoapc.setOidIdioma(dtoBelcorp.getOidIdioma());
				dtoapc.setOidCanal(new Long(canal));
			       elem=new ComposerViewElement(); 
			       elem.setIDBusiness(idNegocios[1]); //SEGObtenerAccesosPorCanal
			       elem.setDTOE(dtoapc);
			       listelem.addViewElement(elem);
			}
			traza("+++ Antes de comprobar si acceso:" +acceso);
			if (acceso != null){
				DTOOID oid = new DTOOID();
				oid.setOidIdioma(dtoBelcorp.getOidIdioma());
				oid.setOidPais(dtoBelcorp.getOidPais());
				oid.setOid(new Long(acceso));
			       elem=new ComposerViewElement(); 
			       elem.setIDBusiness(idNegocios[2]); //SegObtenerSubaccesosPorAcceso
			       elem.setDTOE(oid);
			       listelem.addViewElement(elem);			
			}
			traza("++++ antes de ejecutar el conector y obtener un rowset con los datos");
			/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
			ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
			conector.ejecucion();
			DruidaConector conConsultar = conector.getConector();
			
			traza("+++ Antes de asignar a la pantalla los datos");
			/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
			//correspondiente utilizando el String que representa el BusinessID en cada caso. */
			
			if (seleccionados == null) {
			       for(int j = 0; j < combos.length; j++) {
			                asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
			       }
			} else {
			       for (int j = 0; j < combos.length; j++) {
			                if (seleccionados[j] != null && !seleccionados[j].equals("") && columnas != null && columnas.length > j && columnas[j] != null && !columnas[j].equals("")){
			                	traza("Combos["+j+"]: "+combos[j]);
			                	traza("Seleccionados["+j+"]: "+seleccionados[j]);
			                	traza("idNegocios["+j+"]: "+idNegocios[j]);
			                	traza("columnas["+j+"]: "+columnas[j]);
			                	traza("seleccionados["+j+"]: "+seleccionados[j]);
			                	asignar("COMBO", combos[j], conConsultar, idNegocios[j], columnas[j], seleccionados[j]);
			          	  }else{
			          	  	if (combos[j] != null){
				          	  	traza("Seleccionados vacio");
				          	  	traza("Combos["+j+"]: "+combos[j]);
				          	  	traza("idNegocios["+j+"]: "+idNegocios[j]);			          	  	
			          			asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
			          		}
			          	}
			       }
			}		
		} catch (Exception ex) {
		       this.logStackTrace(ex);
		}
		traza("*** Salida - cargaCombos ***");
	}
}