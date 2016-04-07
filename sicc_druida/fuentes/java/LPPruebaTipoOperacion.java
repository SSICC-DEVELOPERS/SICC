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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import java.util.Vector;
import java.util.Date;
import java.util.Collection;
import java.util.Iterator;
import java.math.BigDecimal;


import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;


import es.indra.druida.DruidaConector;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class LPPruebaTipoOperacion extends LPSICCBase {
           
	private String accion = null;
	private String opcionMenu = null;
	private Long pais;
	private Long idioma;
	private String idiomas = "";
	
	public LPPruebaTipoOperacion() {
	           super();
	}
	
	public void inicio() throws Exception {
	           
	} 
    public void ejecucion() throws Exception {
		setTrazaFichero();
        try{          
        	traza("*** LPPruebaTipoOperacion.ejecucion: Entrada ****");
            //pagina("contenido_operaciones_mantener"); 
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            this.accion = conectorParametroLimpia("accion","", true);
            traza("Accion definida : "+accion);
            Collection cIdiomas = getIdiomas(); //obtenemos los idiomas.
			Iterator itIdiomas = cIdiomas.iterator();
			while(itIdiomas.hasNext()){
            	Idioma idiomai18n = (Idioma)itIdiomas.next();
				this.idiomas += idiomai18n.getOid() +",";
			}
			traza(" *** Idiomas = "+this.idiomas);
            this.opcionMenu = "crear operacion";
            this.mostrarPgTiposOperacion();
                    
            
            traza("*** LPOperacion.ejecucion: Salida **");
         }catch ( Exception e )  {
                  e.printStackTrace();
                  this.logStackTrace(e);
                  lanzarPaginaError(e);
         }
   }                                      
            
    private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());            
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);                    
         traza("Stack Trace: " + baos.toString());
    }            
     
     
     public void cargarPgTiposOperacion() throws Exception{
                  
                  traza("*** LPOperacion.cargarPgTiposOperacion: Entrada ***");
                  /*Documentation
                  Crear un DTOBelcorp dtoe con: 
                  - pais = Pais activo 
                  - idioma = Idioma del usuario 
                  */
                  DTOBelcorp dtoe = new DTOBelcorp();
                  dtoe.setOidPais(this.pais);
                  dtoe.setOidIdioma(this.idioma);
                  
                  
                  //Crear una lista ComposerViewElementList 
                  ComposerViewElementList listelem = new ComposerViewElementList();
         ComposerViewElement elem = new ComposerViewElement(); 
                  
                  //Bloqueo por diferencia de precio 
                  /*Crear un elemento de tipo ComposerViewElement() para cargar los precios 
                  elem.IDBusiness="RECObteneMotivosBloqueo"; 
                  elem.DTOE=dtoe; 
                  */
                  elem.setIDBusiness("RECObtenerMotivosBloqueo");
         elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento primero aniadido");
                  /*
                  //Rechazo por validacion 
                  Crear un elemento de tipo ComposerViewElement() para cargar los precios 
                  elem.IDBusiness="RECObteneMotivosRechazoDesbloqueo"; 
                  elem.DTOE=dtoe; 
                  */
                  elem = new ComposerViewElement();
                  elem.setIDBusiness("RECObtenerMotivosRechazoDesbloqueo");
         elem.setDTOE(dtoe);
                  listelem.addViewElement(elem);
                  traza("Elemento segundo aniadido");
                  /*Invocar al subsistema GestorCargaPantalla 
                  
                  Asigna los combos: 
                  - cbBloqueoPorDiferenciaPrecio <- RECObteneMotivosBloqueo 
                  - cbBloqueoPorReclamoAnterior <- RECObteneMotivosBloqueo 
                  - cbReclamoPorImporte <- RECObteneMotivosBloqueo 
                  - cbBloqueoPorUnidades <- RECObteneMotivosBloqueo 
                  - cbRechazoPorValidacion <- RECObteneMotivosRechazoDesbloqueo
                  */
                  ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
         traza("conector creado");
         conector.ejecucion();
         traza("ejecutado");
         DruidaConector conConsultar = conector.getConector();
         traza("Obtener conConsultar");

                  asignar("COMBO","cbBloqueoDiferenciaPrecio", conConsultar,"RECObtenerMotivosBloqueo");
                  asignar("COMBO","cbBloqueoReclamoAnterior", conConsultar,"RECObtenerMotivosBloqueo");
                  asignar("COMBO","cbBloqueoImporte", conConsultar,"RECObtenerMotivosBloqueo");
                  asignar("COMBO","cbBloqueoUnidades", conConsultar,"RECObtenerMotivosBloqueo");
                  asignar("COMBO","cbRechazoValidacion", conConsultar,"RECObtenerMotivosRechazoDesbloqueo");

                  traza("*** LPOperacion.cargarPgTiposOperacion: Salida ***");
         } 
         
     public void mostrarPgTiposOperacion() throws Exception{

		/*Documentation
		Si opcionMenu="modificar operacion" { 
		lstResultados=obtenerTipoOperacion(oidOperacion) 
		Llama al metodo cargarPgTiposOperacion 
		Muestra la pantalla PgTiposOperacion pasandole 
		- oidOperaciones recibido de la pantalla 
		- la variable booleana modificado a false. 
		}*/
		traza("*** LPOperacion.mostrarPgTiposOperacion: Entrada ***");
		String oid = "1";//conectorParametroLimpia("oidOperacion","",true);
		
		if(this.opcionMenu.equals("modificar operacion")){
			traza("*** opcionMenu = modificar operacion ***");
			DTOSalida dtoS = this.obtenerTiposOperacion(new Long(oid));
			pagina("contenido_operaciones_mantener");
			asignarAtributo("PAGINA","contenido_operaciones_mantener", "cod", "0934");
            asignarAtributo("PAGINA","contenido_operaciones_mantener", "msgle", "Mantener Tipos de Operaciones");
            getConfiguracionMenu("LPOperacion","tiposOperacion");
            anyadeHiddensI18N(true, "REC_TIPOS_OPERA", null, new Integer(1), "frmFormulario", "txtDescripcion", false); 
			asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu);
			asignarAtributo("VAR","idiomas","valor",this.idiomas);
			asignar("VAR", "idioma", idioma.toString());
                                    traza("->Idioma : "+idioma);
                                    asignar("VAR", "pais", pais.toString());	
                                    traza("->Pais : "+pais);
			this.cargarPgTiposOperacion();
			//cargar la lista
			RecordSet rs = dtoS.getResultado();
			Vector cols = null;
			DruidaConector conectorCargaLista = null; 	

			if (rs != null ) {
				cols = rs.getColumnIdentifiers();
				conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rs, cols);
				asignar("LISTAEDITABLE", "listado1", conectorCargaLista, "DTOSalida.combo_ROWSET");
       		}
			asignarAtributo("VAR","oidOperacion","valor", oid);
			asignarAtributo("VAR","modificado","valor","false");
		} 
		
		/*Si opcionMenu="consultar operacion" { 
		Llama al metodo cargarPgTiposOperacion 
		Muestra la pantalla PgTiposOperacion pasandole 
		- oidOperaciones recibido de la pantalla 
		- la variable booleana modificado a false. 
		Se deshabilitan todos los campos de la pantalla. 
		} */
		if(this.opcionMenu.equals("consultar operacion")){
			traza("*** opcionMenu = consultar operacion ***");
			pagina("contenido_operaciones_mantener");
			asignarAtributo("PAGINA","contenido_operaciones_mantener", "cod", "0934");
            asignarAtributo("PAGINA","contenido_operaciones_mantener", "msgle", "Mantener Tipos de Operaciones");
			asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu);
			getConfiguracionMenu("LPOperacion","tiposOperacion");
			this.cargarPgTiposOperacion();
			asignarAtributo("VAR","oidOperacion","valor", oid);
			asignarAtributo("VAR","modificado","valor","false");
			DTOSalida dtoS = this.obtenerTiposOperacion(new Long(oid));
            //cargar la lista
            RecordSet rs = dtoS.getResultado();
            Vector cols = null;
            DruidaConector conectorCargaLista = null; 	

            if (rs != null ) {
                     cols = rs.getColumnIdentifiers();
                     conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rs, cols);
                     asignar("LISTAEDITABLE", "listado1", conectorCargaLista, "DTOSalida.combo_ROWSET");
            }
			
			//desabilitar campos
			asignarAtributoElemento("txtTipoOperacion","disabled","S");								
            asignarAtributoElemento("txtDescripcion","disabled","S");	
			asignarAtributoElemento("CampanaReferenciaUnica","disabled","S");
			asignarAtributoElemento("txtCantidadDiasAtras","disabled","S");
			asignarAtributoElemento("InformacionEbelNoticias","disabled","S");
			asignarAtributoElemento("DevuelveEstaFactura","disabled","S");
			asignarAtributoElemento("EnviaEstaFactura","disabled","S");
			asignarAtributoElemento("cbBloqueoDiferenciaPrecio","disabled","S");
			asignarAtributoElemento("cbBloqueoReclamoAnterior","disabled","S");
			asignarAtributoElemento("cbBloqueoImporte","disabled","S");
			asignarAtributoElemento("cbBloqueoUnidades","disabled","S");
			asignarAtributoElemento("cbRechazoValidacion","disabled","S");
			asignarAtributoElemento("btnInsertar","disabled","S");
			asignarAtributoElemento("Modificar","disabled","S");
			asignarAtributoElemento("Eliminar","disabled","S");
		
		}
		
		/*Si opcionMenu="crear operacion" { 
		Llama al metodo cargarPgTiposOperacion 
		Muestra la pantalla "PGTiposOperacion" 
		} 
		*/
		if(this.opcionMenu.equals("crear operacion")){
			traza("*** opcionMenu = crear operacion ***");
			pagina("contenido_operaciones_mantener");
			asignarAtributo("PAGINA","contenido_operaciones_mantener", "cod", "0934");
           	asignarAtributo("PAGINA","contenido_operaciones_mantener", "msgle", "Mantener Tipos de Operaciones");
			getConfiguracionMenu("LPOperacion","tiposOperacion");
			anyadeHiddensI18N(true, "REC_TIPOS_OPERA", null, new Integer(1), "frmFormulario", "txtDescripcion", false); 
			asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu);
			asignarAtributo("VAR","idiomas","valor",this.idiomas);
			this.cargarPgTiposOperacion();
		}
		traza("*** LPOperacion.mostrarPgTiposOperacion: Salida ***");
	}
	
	public DTOSalida obtenerTiposOperacion(Long oidOperacion ) throws Exception{

    	/*Documentation
    	//Obtenermos los tipos de operacion asociados a la operacion 
    	Invocar conector ConectorObtenerTiposOperacion con un DTO del tipo DTOOid- Parametro del DTOOid: 
    	- oid = oidOperacion (parametro recibido que indica a que operacion estan asociados estos tipos de operacion) 
    	Crear IDBusiness="RECObtenerTiposOperacion" 
    	Obtiene DTOSalida. 
    	*/
    	traza("*** LPOperacion.obtenerTiposOperacion: Entrada ***");
    	
    	Vector paramConector = new Vector();
    	DTOOID dtoOid=new DTOOID();
    	dtoOid.setOidIdioma(this.idioma);
    	dtoOid.setOidPais(this.pais);
    	dtoOid.setOid(oidOperacion);
    	paramConector.add(dtoOid);
    	paramConector.add(new MareBusinessID("RECObtenerTiposOperacion"));            
    	traza("Antes de Conectar ConectorObtenerTiposOperacion");
    	DruidaConector conector = conectar("ConectorObtenerTiposOperacion", paramConector);							
    	traza("Despues de Conectar ConectorObtenerTiposOperacion");
    	Object objeto=conector.objeto("DTOSalida");
    	traza("Objeto recogido"+objeto);
    	DTOSalida salida = (DTOSalida)conector.objeto("DTOSalida");
    	traza("DTOSalida obtenido");
    	
    	// Modificamos los valores boolean por un si o un no que es lo que aparece en la lista
    	RecordSet rs = salida.getResultado();
    	
    	if(!rs.esVacio()){    	
    		for(int i=0;i<rs.getRowCount();i++){
    		         
    		         if(rs.getValueAt(i,3) != null){
    		         		traza("elemento 1: campania referencia");
    		                  if( ((BigDecimal)rs.getValueAt(i,3)).intValue() == 1)
    		                           rs.setValueAt("Si",i,3);
    		                  else
    		                           rs.setValueAt("No",i,3);
    		         }
    		         if(rs.getValueAt(i,5) != null){
    		                traza("elemento 2: informacion noticias");
    		                  if( ((BigDecimal)rs.getValueAt(i,5)).intValue() == 1)
    		                           rs.setValueAt("Si",i,5);
    		                  else
    		                           rs.setValueAt("No",i,5);
    		         }
    		         if(rs.getValueAt(i,6) != null){
    		         		traza("elemento 3: devuelve factura");
    		                  if( ((BigDecimal)rs.getValueAt(i,6)).intValue() == 1)
    		                           rs.setValueAt("Si",i,6);
    		                  else
    		                           rs.setValueAt("No",i,6);
    		         }
    		         if(rs.getValueAt(i,7) != null){
    		         		traza("elemento 4: envia factura");
    		                  if( ((BigDecimal)rs.getValueAt(i,7)).intValue() == 1)
    		                           rs.setValueAt("Si",i,7);
    		                  else
    		                           rs.setValueAt("No",i,7);
    		         }	
    		}
    	}
    	traza("**** RecordSet  modificado ="+rs);
    	salida.setResultado(rs);	
    	
    	
    	traza("*** LPOperacion.obtenerTiposOperacion: Salida ***");
    	return salida;
	}

	
}       