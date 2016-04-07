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
 
//import LPSICCBase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.druida.DruidaConector;

public class LPRegistrarExtemporaneas extends LPSICCBase {

	public LPRegistrarExtemporaneas() {
	          super();
	}
           
	public void inicio() throws Exception {
	
	}

	public void ejecucion() throws Exception {
		this.cargaInicial();
	}
           
	private void cargaInicial() throws Exception {
		rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPRegistrarExtemporaneas - cargaInicial ***");
		try  {
		
			rastreo();
			pagina("contenido_extemporaneas_cursos_registrar");
			asignarAtributo("PAGINA","contenido_extemporaneas_cursos_registrar", "cod", "0210");
        	asignarAtributo("PAGINA","contenido_extemporaneas_cursos_registrar", "msgle", "Registrar Extemporáneas a Cursos");
			//Se deshabilita en su totalidad el menú secundario
			getConfiguracionMenu("LPRegistrarExtemporaneas", "");
		
			//Obtenemos el pais y el idioma de la sesion
			Long pais = UtilidadesSession.getPais(this); 
			Long idioma = UtilidadesSession.getIdioma(this);
			asignarAtributo ("VAR", "pais", "valor", pais.toString());
			asignarAtributo("VAR", "idioma", "valor", idioma.toString());
		
		
			//Se instancia un DTOBelcorp
			DTOBelcorp dtoEntrada = new DTOBelcorp();
			dtoEntrada.setOidPais(pais);
			dtoEntrada.setOidIdioma(idioma);
		
			String idNegocios[] = new String[2];
			idNegocios[0] = new String("SEGConsultaMarcas"); 
			idNegocios[1] = new String("SEGConsultaCanales");
		
			String [] combos = new String[2];
			combos[0] = new String("cbMarca");
			combos[1] = new String("cbCanal");
		
			byte posicionOid[]=new byte[2];
			posicionOid[0]=new Byte("0").byteValue();
			posicionOid[1]=new Byte("0").byteValue();
					
			byte posicionDescripcion[]=new byte[2];
			posicionDescripcion[0]=new Byte("1").byteValue();
			posicionDescripcion[1]=new Byte("1").byteValue();
		
			this.cargaCombos(dtoEntrada,idNegocios,combos,null,null,posicionOid, posicionDescripcion);
		
		
		}catch ( Exception e ) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPRegistrarExtemporaneas - cargaInicial ***");
	}
           

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}
     
	private void cargaCombos(DTOBelcorp dtoBelcorp, String[] idNegocios, String[] combos, String[] seleccionados, String[] columnas, byte [] posicionOid, byte [] posicionDescripcion) throws Exception {
	      traza("*** Entrada - cargaCombos ***");
	      try {
	      //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
	      ComposerViewElementList listelem = new ComposerViewElementList();
	      ComposerViewElement elem = null;
	      
	      for (int i = 0; i < idNegocios.length; i++) {
	               elem=new ComposerViewElement(); 
	               elem.setIDBusiness(idNegocios[i]);
	               elem.setDTOE(dtoBelcorp);
	               elem.setPosOID(posicionOid[i]);
	               elem.setPosDesc(posicionDescripcion[i]);
	               listelem.addViewElement(elem);
	      }
              
          /*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
          ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
          conector.ejecucion();
          DruidaConector conConsultar = conector.getConector();
              
          /*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
          //correspondiente utilizando el String que representa el BusinessID en cada caso. */
          if (seleccionados == null) {
                   for(int j = 0; j < combos.length; j++) {
                            asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
                   }
          } else {
                   for (int j = 0; j < combos.length; j++) {
                            if (seleccionados[j] != null && !seleccionados[j].equals("") && columnas != null && columnas.length > j && columnas[j] != null && !columnas[j].equals(""))
                                                        asignar("COMBO", combos[j], conConsultar, idNegocios[j], columnas[j], seleccionados[j]);
                      	else
                      		asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
                   }
          }		
          } catch (Exception ex) {
                   this.logStackTrace(ex);
          }
          traza("*** Salida - cargaCombos ***");
     }	


}
