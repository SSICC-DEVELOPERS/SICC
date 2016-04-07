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
    INDRA/CAR/PROY
    $Id: LPCopiaStockAlmacen.java,v 1.1 2009/12/03 18:41:33 pecbazalar Exp $
    DESC
 */
/**
 * Sistema:           Belcorp
 * Modulo:            PED 
 * Componente:        LP
 * Fecha:             19/07/2004
*/

import LPSICCBase;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewClass;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.bel.DTOAlmOrigDest;
import es.indra.sicc.dtos.bel.DTOStock;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.Character;

import java.text.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class LPCopiaStockAlmacen  extends LPSICCBase {

   private String accion    	= null;
   private String pais     		= null;     
   private String idioma        = null;
   private String oidAlmacenO   = null;
   private String oidAlmacenD   = null;  
   

   public LPCopiaStockAlmacen()  {
		super();
	}

  public void inicio() throws Exception {  
		pagina("contenido_stock_almacen_copiar");
	}
  
  public void ejecucion() throws Exception {
    
    setTrazaFichero();
	
    accion     = conectorParametroLimpia("accion", "", true);
	
	idioma     = UtilidadesSession.getIdioma(this).toString();
	traza("contenido de idioma:::::: " + idioma);
	
	pais       = UtilidadesSession.getPais(this).toString();	
	traza("contenido de pais:::::: " + pais);

	oidAlmacenO = conectorParametro("oidAlmacenO");
    traza("contenido de oidAlmacenO>>>" + oidAlmacenO);

	oidAlmacenD = conectorParametro("oidAlmacenD");
	traza("contenido de oidAlmacenD >>> " + oidAlmacenD);	

    try  {	
			/*
			 * 1.- Ejecuta la acción: 
			 *	Si accion == "" -> muestra(); 
			 *	Si accion == "copiar" -> copia(); 
			 *	Si accion == "eliminar" -> elimina();  
			 */

	    //	rastreo();

			traza("contenido de accion:::: "+ accion);
			cargarMenuSecundario();
			
            if(accion.equals("")) {
					cargaMostrar();            
            }
			 else if(accion.equals("copiar")) {
						pagina("salidaGenerica");
			//	pagina("contenido_stock_almacen_copiar");
						cargaCopiar();   						
					
			}
			else if(accion.equals("eliminar")) {
						pagina("salidaGenerica");
						cargaEliminar(); 					
			}		

}


	catch ( Exception e )  {
		traza("pincho la lp principal");
		ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        e.printStackTrace(out);
        traza("EL STACK ES COMO SIGUE : " +  pila.toString());
    	e.printStackTrace(); 
		e.getMessage();
		lanzarPaginaError(e);
    }


  }

 private void cargaMostrar() throws Exception {    
 /*
  * 	1.- Crear un DTOBelcorp dtoe con: 
  *		- pais = Pais activo  *		- idioma = Idioma del usuario 
  *		2.- Crear una lista ComposerViewElementList 
  *		3.- Crear un elemento de tipo ComposerViewElement() para cargar los canales 
  *		elem.IDBusiness="BELobtieneAlmacenPais"; 
  *		elem.DTOE=dtoe; elem.posOID=1; elem.posDesc=2; 
  *		Añadir el elemento a la lista 
  *		4.- Invocar al subsistema GestorCargaPantalla 
  *		5.- asignar("COMBO", "cmbAlmacen", conConsultar, "BELobtieneAlmacenPais"); 
  *		asignar("COMBO", "cmbAlmacenDestino", conConsultar, "BELobtieneAlmacenPais"); 
  */	  

	  ComposerViewElementList cv = crearParametrosEntrada();
	  ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
	  conector.ejecucion();
		
	  DruidaConector resultados = conector.getConector();

	  asignar("COMBO", "cbAlmacen", resultados, "BELObtieneAlmacenPais"); 
	  asignar("COMBO", "cbAlmacenDestino", resultados, "BELObtieneAlmacenPais"); 
  }

  private ComposerViewElementList crearParametrosEntrada() throws Exception{
	  ComposerViewElementList lista = new ComposerViewElementList();
	
	  ComposerViewElement cmb1 = new ComposerViewElement();
	  cmb1.setIDBusiness("BELObtieneAlmacenPais");	

	  DTOBelcorp dtoe = new DTOBelcorp();
	  dtoe.setOidPais(new Long(pais));
	  dtoe.setOidIdioma(new Long(idioma));

	  cmb1.setDTOE(dtoe);
	/*  cmb1.setPosOID((byte)1);
	  cmb1.setPosDesc((byte)2);*/

	  lista.addViewElement(cmb1);

	  return lista; 

  }

  private void cargaCopiar() throws Exception { 
  /*
   * 	1.- Se crea un DTOAlmOrigDest rellenándolo así: 
   *	- oidAlmacenOrigen <- cmbAlmacen 
   *    - oidAlmacenDestion <- cmbAlmacenDestino 
   *    2.- Se crea idNegocio = "BELMoverRegistrosDeStock" 
   *    3.- Se invoca a ConectorGuardaGestionStock
   */
	 traza("contenido de oidAlmacenD >>> " + oidAlmacenD);
	 traza("contenido de oidAlmacenO >>> " + oidAlmacenO);
	
	 DTOAlmOrigDest dtoa =  new DTOAlmOrigDest();

	 dtoa.setOidAlmacenOrigen(new Long(oidAlmacenO));
	 dtoa.setOidAlmacenDestino(new Long(oidAlmacenD));

	 MareBusinessID id = new MareBusinessID("BELMoverRegistrosDeStock");
	
	 
	 Vector paramEntrada = new Vector();	
	 paramEntrada.add(dtoa);
	 paramEntrada.add(id);

	 DruidaConector con  = conectar("ConectorGuardaGestionStock", paramEntrada);

     asignarAtributo("VAR", "ejecutar", "valor", "borrarTodo()"); 
	 
   
  }

 private void cargaEliminar() throws Exception {   
	/*
	 * 	1.- Se crea un DTOStock rellenándolo así:
	 * 	  - oidAlmacen <- cmbAlmacen 
	 *  2.- Se crea idNegocio = "BELEliminarRegistrosDeStock" 
	 *  3.- Se invoca a ConectorEliminarStock
    */

	 traza("contenido de oidAlmacenO >>> " + oidAlmacenO);
     DTOStock dtos = new DTOStock();
	 dtos.setOidAlmacen(new Long(oidAlmacenO));


	 MareBusinessID id = new MareBusinessID("BELEliminarRegistrosDeStock");

	 Vector paramEntrada = new Vector();

	 paramEntrada.add(dtos);
     paramEntrada.add(id);

	 DruidaConector con = conectar("ConectorEliminarStock", paramEntrada);

	 asignarAtributo("VAR", "ejecutar", "valor", "borrarTodo()"); 
	
 }


 private void cargarMenuSecundario() throws Exception {  

  asignarAtributoPagina("cod","0455");	
  
  if (accion.equals("")) {
        getConfiguracionMenu("LPCopiaStockAlmacen",""); 
  }
 }
	
}
