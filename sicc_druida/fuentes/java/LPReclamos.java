import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.druida.DruidaConector;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import java.math.BigDecimal;
import java.util.StringTokenizer;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import java.util.ArrayList;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cal.DTOReclamo;



//import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;


public class LPReclamos extends LPSICCBase {
	
	private String accion = null;
	
	public void inicio() throws Exception {
		setTrazaFichero();
		pagina("contenido_reclamos_varios_insertar");
		traza("*** Entrada - LPReclamos - inicio ***");
		asignarAtributo("PAGINA","contenido_reclamos_varios_insertar","cod","0583");
                asignarAtributo("PAGINA","contenido_reclamos_varios_insertar","msgle","Realizar reclamos varios");				
                getConfiguracionMenu("LPReclamos", "");
                traza("*** Salida - LPReclamos - inicio ***");
	}
	
	public void ejecucion() throws Exception {
		
		traza("*** Entrada - LPReclamos - ejecucion ***");
        try {
			/*Si accion=""{ 
			Llamar al metodo mostrarPgReclamos() pasandole el oidContacto recibido 
			} 
			
			Si accion="insertar reclamo"{ 
			Llamar al metodo insertarReclamo() 
			}*/
			Long idioma = UtilidadesSession.getIdioma(this);			
            asignar("VAR", "hIdioma", idioma.toString());
            Long pais = UtilidadesSession.getPais(this);
            asignar("VAR", "hPais", pais.toString());
            
            this.accion  = conectorParametroLimpia("accion","",true);
            Long oidContacto =new Long( conectorParametroLimpia("oidContacto","",true)); // se le da este valor desde otro caso de uso, así que para hacer pruebas pasarle uno
            asignarAtributo("VAR", "oidContacto", "valor", oidContacto.toString());
            //Long oidContacto = new Long(1);
            
            
   
            traza("accion = "+accion);
            if(this.accion.equals("")){
            	this.mostrarPgReclamos(pais, idioma, oidContacto);
            
            }else if (this.accion.equals("insertarReclamo")) {
            	this.insertarReclamo(pais, idioma);
            }
            traza("*** Salida - LPReclamos - ejecucion ***");
		} catch (Exception ex) {
			logStackTrace(ex);
			this.lanzarPaginaError(ex);   
		}
                

	}
	//Operation void mostrarPgReclamos (), in Class LPReclamos
	private void mostrarPgReclamos(Long pais, Long idioma, Long oidContacto)throws Exception{
		traza("*** Entrada - LPReclamos.mostrarPgReclamos ***");
		/*
		Crear un DTOBelcorp dtoe con: 
		- pais = Pais activo 
		- idioma = Idioma del usuario */
	
	        DTOBelcorp dtoBelcorp=new DTOBelcorp();
	        dtoBelcorp.setOidIdioma(idioma);
	        dtoBelcorp.setOidPais(pais);
        	/*
		Crear una lista ComposerViewElementList 
		
		//Codigo Usuario 
		Crear un elemento de tipo ComposerViewElement() para cargar los usuarios de buzones 
		elem.IDBusiness="CALObtenerCodUsuario"; 
		elem.DTOE=dtoe; 
		
		//TipoGestionCliente 
		Crear un elemento de tipo ComposerViewElement() para cargar los usuarios de buzones 
		elem.IDBusiness="CALObtenerGestiones"; 
		elem.DTOE=dtoe; 
		
		
		Invocar al subsistema GestorCargaPantalla 
		
		Asigna la combo: 
		- cbCodUsuario 
		- cbTipoGestionCliente 
		
		Muestra la pantalla PantallaRealizarReclamos pasandole el oidContacto*/
		         //esta función la utilizaremos para cargar los combos
	         /*
	         *parámetros:
	         	dto de belcorp,mare id bussiness, los nombres de los combos...,lo seleccionado por defecto(caso consultar) y el oid sql (caso consultar)
	         ********************************************************/ 
		
                //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 

                ComposerViewElementList listelem = new ComposerViewElementList();
                ComposerViewElement elem = new ComposerViewElement();
		elem.setIDBusiness("CALObtenerCodUsuario");
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem); 
		
                elem = new ComposerViewElement();
		elem.setIDBusiness("CALObtenerGestiones");
		elem.setDTOE(dtoBelcorp);
		listelem.addViewElement(elem);
		
		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		traza("*** Entrada - LPReclamos.conectorComposerView ***");
                ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
                conector.ejecucion();
                DruidaConector conConsultar = conector.getConector();
		traza("*** Salida - LPReclamos.conectorComposerViews ***");
		
                /*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. */
                asignar("COMBO", "cbCodUsuario", conConsultar, "CALObtenerCodUsuario"); 
                asignar("COMBO", "cbTipoGestionCliente", conConsultar, "CALObtenerGestiones");
                asignarAtributo("VAR", "oidContacto", "valor", oidContacto.toString());

		traza("*** Salida - LPReclamos.mostrarPgReclamos ***");
	}
        /*
        Operation void insertarReclamo (), in Class LPReclamos
	Recoge los datos procedentes de la PantallaReclamosVarios 
	Crear DTOE del tipo DTOReclamo con los atributos recogidos: 
	DTOE.oidContacto=oidContacto 
	DTOE.codUsuario= codUsuario 
	DTOE.oidCabecera= oidCabecera 
	DTOE.descripcionActividad= descripcionActividad 
	DTOE.oidGestion= oidGestion 
	DTOE.observaciones= observaciones 
	Invocar conector ConectorInsertarReclamo con el DTOE 
	Crear IDBusiness="CALInsertarReclamo" 
	Se cierra la ventana    */
	
	private void insertarReclamo(Long pais, Long idioma)throws Exception{
		traza("*** Entrada - LPReclamos.insertarReclamo ***");
                pagina("salidaGenerica");
                asignar("VAR", "cerrarVentana", "false");
                asignar("VAR", "ejecutar", "insercionCorrecta()");
                
                //añadimos al vector el dto 
                //y el mareidbussines
           	 DTOReclamo dtoReclamo = new DTOReclamo();
		//como siempre rellenamos el oid pais y el oid Idioma
		/*		
		cbCodUsuario  Combo   
		cbBuzon  Combo   
		descripcionActividad  Caja Texto   
		cbTipoGestionCliente  Combo   
		observaciones  Caja Texto   
		oidContacto VAR   
		*/
		dtoReclamo.setOidPais(pais);
        dtoReclamo.setOidIdioma(idioma);
        dtoReclamo.setOidContacto(new Long(conectorParametroLimpia("oidContacto", "", true)));  
  		dtoReclamo.setOidCabecera(new Long(conectorParametroLimpia("cbBuzon","",true)));
  		dtoReclamo.setCodUsuario(conectorParametroLimpia("cbCodUsuario", "",true));
  		dtoReclamo.setDescripcionActividad(conectorParametroLimpia("txtDescripcionActividad","",true));
  		String tipoGestion = conectorParametroLimpia("cbTipoGestionCliente","",true);
  		if (!tipoGestion.equals(""))
			dtoReclamo.setOidTipoGestionCliente(new Long(tipoGestion));
		dtoReclamo.setObservaciones(conectorParametroLimpia("atxtObservaciones","",true));
		traza("LPReclamos. DTOReclamo a insertar " + dtoReclamo);
		
                Vector paramConector = new Vector();
                 
		paramConector.add(dtoReclamo);
		paramConector.add(new MareBusinessID("CALInsertarReclamo")); 

                //le pasamos al druida conector el conector y el vector de parametros
                
                traza(" Antes de Conectar LPReclamos.ConectorInsertarReclamo");  
                DruidaConector conector = conectar("ConectorInsertarReclamo", paramConector);
                traza(" Después de Conectar LPReclamos.ConectorInsertarReclamo");

		
		traza("*** Salida - LPReclamos.insertarReclamo ***");
	}
         
        private void logStackTrace(Throwable e) throws Exception {
                  traza("Se produjo la excepcion: " + e.getMessage());		
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(baos);
                  e.printStackTrace(ps);		
                  traza("Stack Trace: " + baos.toString());
         }

}