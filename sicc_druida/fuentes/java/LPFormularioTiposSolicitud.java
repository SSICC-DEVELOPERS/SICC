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
    $Id: LPFormularioTiposSolicitud.java,v 1.1 2009/12/03 18:43:04 pecbazalar Exp $
    DESC
*/
import java.util.Vector; 
import java.util.HashMap;
import java.util.StringTokenizer;
import java.math.BigDecimal;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.fac.DTOFormulariosTipoSolicitud;

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream; 

// Definicion de la clase
public class LPFormularioTiposSolicitud extends LPSICCBase {
    // Definicion del constructor
    public LPFormularioTiposSolicitud() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {

         // Defino el nombre de la vista
         pagina("contenido_formularios_tipo_solicitud_asignar");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
    	  rastreo();
          try{
            setTrazaFichero(); 
            traza("***Entrada - LPFormularioTiposSolicitud - ejecucion***");
              
            String accion = conectorParametroLimpia("accion","",true);
            traza("***accion : "+accion);
             
            //Bifurcamos la accion
            if ( accion.equals("")) {
                      cargaInicial();
            }
            if ( accion.equals("guardar")) {
                      guardar();
            }
            
            getConfiguracionMenu("LPFormularioTiposSolicitud",accion);      
            traza("***Salida - LPFormularioTiposSolicitud - ejecucion***");
          }catch(Exception e){
            logStackTrace(e);
            lanzarPaginaError(e);
          }
    }
   
    private void cargaInicial() throws Exception {
        traza("***Entrada - LPFormularioTiposSolicitud - accionVacia");
                           
          UtilidadesSession sesion = new UtilidadesSession();
          Long pais = sesion.getPais(this); 
          Long idioma = sesion.getIdioma(this);

          //Utilizamos el subsistema de carga inicial para cargar
          // el combo tiposSolicitud con el idBusiness "PEDobtieneTiposSolicitudPorPais"
          DTOBelcorp dtoBelcorp = new DTOBelcorp();
          dtoBelcorp.setOidPais(pais);
          dtoBelcorp.setOidIdioma(idioma);

          //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
	      ComposerViewElementList listelem = new ComposerViewElementList();
	      ComposerViewElement elem=new ComposerViewElement();

		  //@ssaavedr 29/09/2005, debe recuperar solo los tipos de sol, consolidados
	      //elem.setIDBusiness("PEDobtieneTiposSolicitudPorPais");
		  elem.setIDBusiness("PEDobtieneTiposSolicitudPorPaisConso");

	      elem.setDTOE(dtoBelcorp);
	      listelem.addViewElement(elem); 

	      //Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.
	      ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
	      conector.ejecucion();
	      DruidaConector conConsultar = conector.getConector();
	      	
	      //Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
	      //correspondiente utilizando el String que representa el BusinessID en cada caso. 
	      //asignar("COMBO", "cbTipoSolicitud", conConsultar, "PEDobtieneTiposSolicitudPorPais"); 

          //@ssaavedr 29/09/2005, debe recuperar solo los tipos de sol, consolidados
 	      asignar("COMBO", "cbTipoSolicitud", conConsultar, "PEDobtieneTiposSolicitudPorPaisConso");
	      
	      //Rellena datos generales de la pagina
          asignarAtributo("VAR", "idioma", "valor", idioma.toString());
          asignarAtributo("VAR", "pais", "valor", pais.toString());

	      traza("***Salida -  LPFormularioTiposSolicitud - accionVacia"); 

    }
    
    private void guardar() throws Exception {
        traza("***Entrada - LPFormularioTiposSolicitud - accionGuardar");
       
        //Salida Generica
        pagina("salidaGenerica");
        asignar("VAR", "cerrarVentana", "false");
        asignar("VAR", "ejecutar", "correcto()");

        //Creamos un Hashmap y añadimos una entrada por cada fila que 
        //tenga el campo "orden formulario" rellenado, poniendo como 
        //key el oid (campo oculto del listado) y como value el valor 
        //de la columna "orden formulario". 
        HashMap formularios = new HashMap();
      
        String parametro = conectorParametroLimpia("cadena", "", true);
        if(!parametro.equals("")) {
        	//Le quitamos el ultimo caracter, siempre vendra uno como mínimo
        	parametro = parametro.substring(0,parametro.length()-1);
        	//Obtenemos las filas
        	StringTokenizer filas = new StringTokenizer(parametro,"#");
        	while (filas.countTokens() > 0) {
	         	String fila = filas.nextToken();
         		//Obtenemos el oid y el ordenformulario
         		StringTokenizer campos = new StringTokenizer(fila,"@");
         		//En el mon espera Long-Short
         		formularios.put(new Long(campos.nextToken()),campos.nextToken());
        	}
        }
		//Creamos un DTOFormulariosTipoSolicitud y rellenamos los atributos: 
		//-tipoSolicitud: el valor del combo correspondiente. 
		//-formularios: el HashMap que creamos antes. 

        DTOFormulariosTipoSolicitud dtoCarga = new DTOFormulariosTipoSolicitud();
     
        //Obtenemos el pais y el idioma de la sesion
        UtilidadesSession sesion = new UtilidadesSession();       
        Long pais = sesion.getPais(this);        
        Long idioma = sesion.getIdioma(this);
		dtoCarga.setOidPais(pais);
		dtoCarga.setOidIdioma(idioma);
      
        //Obtenemos tipoSolicitud
        String solicitud = conectorParametroLimpia("cbTipoSolicitud","", true);
      
		dtoCarga.setTipoSolicitud(new Long(solicitud));
		dtoCarga.setFormularios(formularios);
		//Llamamos al ConectorGuardar con el dto creado y el idBusiness = "FACGuardarFormularioTiposSolicitud"
        MareBusinessID idBussiness = new MareBusinessID("FACGuardarFormularioTiposSolicitud");
       
        //Almacenamos los parametros de entrada
        Vector paramEntrada = new Vector();
        paramEntrada.addElement(dtoCarga);
        paramEntrada.addElement(idBussiness);

        traza ("Llamo a conectar");
        //traza ("El dto:"+dtoCarga);
           
        //- Se invoca al ConectorGuardar 
        DruidaConector conector = conectar("ConectorGuardar", paramEntrada);

		traza("***Salida -  LPFormularioTiposSolicitud - accionGuardar");
    }
    
    protected void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());

         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);
                      
         traza("Stack Trace: " + baos.toString());
    }
}
