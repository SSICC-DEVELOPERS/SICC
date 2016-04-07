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
 /*
    INDRA/CCC/PROY
    $Id: LPEnviarApuntesContables.java,v 1.1 2009/12/03 18:36:56 pecbazalar Exp $
    DESC
 */
 
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import java.text.SimpleDateFormat;
import java.util.Vector;

import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOINT;
 
 public class LPEnviarApuntesContables extends LPSICCBase {

         private String accion = null;
         private Long pais;
         private Long idioma;
         
         public LPEnviarApuntesContables() {
                super();
         }
         
         public void inicio() throws Exception {
                  pagina("contenido_apuntes_contables_enviar");
         }
         
         public void ejecucion() throws Exception {
                  setTrazaFichero();
                  try{
 
                  traza("*** Entrada - LPEnviarApuntesContables - ejecucion ***");          
                  
                  this.accion = conectorParametroLimpia("accion", "", true);
                  this.idioma = UtilidadesSession.getIdioma(this);
                  this.pais = UtilidadesSession.getPais(this);
                  
                  traza("Accion: "+this.accion+" Idioma: "+this.idioma+" Pais: "+this.pais);
                  asignarAtributo("PAGINA","contenido_apuntes_contables_enviar", "cod", "0894");
                  asignarAtributo("PAGINA","contenido_apuntes_contables_enviar", "msgle", "Enviar apuntes contables");
                  asignarAtributo( "VAR", "hFormatoFechaPais", "valor", UtilidadesSession.getFormatoFecha(this));    
      
                  if (accion.equals("")){
                           traza("Antes de llamar a accionVacia");
                           accionVacia();
                  }
                  if (accion.equals("enviar")){
                           traza("Antes de llamar a accionEnviar");
/*			   
			   String descripcion = conectorParametroLimpia("descripcionLote", "", true);                            
			   String observaciones = conectorParametroLimpia("observaciones", "", true);
*/

			   String numeroLote = conectorParametroLimpia("numeroLote", "", true);                            
			   String descripcion = conectorParametroLimpia("Descripcion", "", true);                            
			   String observaciones = conectorParametroLimpia("areatxtObservaciones", "", true); 
			   String fechaHasta = conectorParametroLimpia("FechaHasta", "", true); 

			   traza ("NumeroLote: "+numeroLote);
			   traza ("Descripcion: "+descripcion);
			   traza ("Observaciones: "+observaciones);
			   traza ("FechaHasta: "+fechaHasta);
			   
  			   DTOINT dtoe = new DTOINT();
		           dtoe.setDescripcionLote(descripcion);
		           dtoe.setNumeroLote(new Long(numeroLote));
		           dtoe.setObservaciones(observaciones);
		           dtoe.setOidIdioma(this.idioma);
		           dtoe.setOidPais(this.pais);
               //se agrega fechaHasta como parametro de busqueda, incidencia SiCC-20070233 (Sapaza)
               dtoe.setFechaHasta(stringAFecha(fechaHasta)); 

			   enviarApuntesContables(dtoe);
                  }
                  getConfiguracionMenu("LPEnviarApuntesContables","");
                  traza("*** Salida - LPEnviarApuntesContables - ejecucion ***");          
                  
                  }catch(Exception  e){
		          traza("ERROR: " + e);
		          e.printStackTrace();
		          lanzarPaginaError(e);  
		  }

         }

/*
DTOCargaInicialInterfaz dto = cargarDatosIniciales() 
lblNumeroLote = dto.numeroLote 
ctxDescripcion = dto.descripcion 
- se muestra PantallaEnviarApuntesContables 
*/
         
         private void accionVacia() throws Exception{
                  traza("*** Entrada - LPEnviarApuntesContables.accionVacia - ejecucion ***");

                  // Se obtiene el pais y el idioma de sesión
                  asignar("VAR", "idioma", idioma.toString());
                  asignar("VAR", "pais", pais.toString());

		  DTOCargaInicialInterfaz dto = cargarDatosIniciales();
		  /*DTOCargaInicialInterfaz dto = new DTOCargaInicialInterfaz();
	          dto.setDescripcion("Descripcion del 123456");
	          dto.setNumeroLote(new Long(123456));
	          dto.setOidIdioma(new Long(1));
	          dto.setOidPais(new Long(1));*/
                  
                  //Con el DTOCargaInicialInterfaz obtenido cargamos los campos txtNumeroLote y txtObservaciones con los atributos numeroLote e observaciones
                  traza("***** Antes de rellenar campos");   
                  asignar("CTEXTO","Descripcion",dto.getDescripcion());     
                  asignar("LABELC","lblvalorLote",dto.getNumeroLote().toString());
                  asignar("VAR","numeroLote",dto.getNumeroLote().toString()); 
                  asignar("VAR","descripcionLote",dto.getDescripcion());     
                  traza("*** Salida - LPEnviarApuntesContables.accionVacia - ejecucion ***");
         }
         
         private void enviarApuntesContables(DTOINT dtoe) throws Exception{
         	traza("*** Entrada - LPEnviarApuntesContables.accionEnviar - ejecucion ***");
         	pagina("salidaGenerica");
		/*                  
		Invocamos al motor plano, con los siguientes parámetros: 

		DTOE: DTOINT recibido 
		DTOS: DTOSalidaBatch 
		conector: ConectorEnviarApuntesContables 
		IDBusiness: INTEnviarApuntesContables
                */
                
                Vector paramConector = new Vector();

                paramConector.add(dtoe);
                traza(dtoe);
                paramConector.add(new MareBusinessID("INTEnviarApuntesContables"));
                traza("Antes de conectar en enviar");
                DruidaConector conector = conectar("ConectorEnviarApuntesContables", paramConector);
                asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
                traza("*** Salida - LPEnviarApuntesContables.accionEnviar - ejecucion ***");
                
         }
         
         
         private DTOCargaInicialInterfaz cargarDatosIniciales() throws Exception{
                  traza("*** Entrada - LPEnviarApuntesContables.cargarDatosIniciales - ejecucion ***");
                 
                  Vector paramConector = new Vector();
                  DTOString dto = new DTOString();
                  
                  dto.setCadena(IGestorInterfaces.COD_INTERFAZ_SAF1C);
                  dto.setOidPais(pais);
                  dto.setOidIdioma(idioma);
                
                  //Relleno los parametros de entrada para llamar al conector
                  paramConector.add(dto);
                  paramConector.add(new MareBusinessID("INTCargaInicialInterfaz"));

                  traza("Antes de conectar en accion vacia");
                  DruidaConector conector = conectar("ConectorObjeto", paramConector);
		  traza("Despues de conectar en accion vacia");
                  DTOCargaInicialInterfaz dtoSalida = (DTOCargaInicialInterfaz)conector.objeto("DTOSalida");
                  traza("Antes de asignar en accion vacia");
                  traza("*** Salida - LPEnviarApuntesContables.cargarDatosIniciales - ejecucion ***");
                  return (dtoSalida);
         }  

         private java.util.Date stringAFecha(String fecha) throws Exception { 
                  if (fecha.trim().equals(""))
                  	  return null;
                  String formato = UtilidadesSession.getFormatoFecha(this);
                  int pos = formato.indexOf("mm");
                  if ( pos > -1) 
                  	  formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
                  SimpleDateFormat sdf = new SimpleDateFormat(formato);

                  return sdf.parse(fecha);
         } 

}
