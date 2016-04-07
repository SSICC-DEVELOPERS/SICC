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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.util.Vector;
import java.util.Date;

import es.indra.sicc.util.DTOString;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOCORRecepcionar;
import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;

import es.indra.mare.common.mln.MareBusinessID;
 
public class LPCOR extends LPSICCBase {

                    private String accion = "";
                    private String casoUso = null;
		    private Long idioma=null;
    		    private Long pais= null;
    		    private Long numeroLote= null;
			
           public LPCOR() {
                      super();
           }
           
           public void inicio() throws Exception {
           	pagina("contenido_COR_interfaz");
           }

           public void ejecucion() throws Exception {
         	DTOString dtoString = null;
         	DTOCargaInicialInterfaz dtoSalida = null;
         	Vector paramConector = new Vector();
         	String seguimientoPedidos = null;
         	String confirmacionPedidos = null;
         	String fechaGenerar = null;
         	String descripcion = null;
         	String observaciones = null;
         	
         	try {
         		traza("*** Entrada - LPCOR - ejecucion ***");
           		setTrazaFichero();
           		rastreo();
           		accion = conectorParametroLimpia("accion","",true);
           		traza("accion = "+accion);
           		this.idioma = UtilidadesSession.getIdioma(this);
			this.pais = UtilidadesSession.getPais(this);
			traza("idioma = "+this.idioma);
			traza("pais = "+this.pais);
			
             		asignar("VAR", "idioma", idioma.toString());
	             	asignar("VAR", "pais", pais.toString());
	             	
	             	this.accion = conectorParametroLimpia("accion","",true);
	             	asignar("VAR", "accion", this.accion);
	             	traza("***accion : "+this.accion);
	             	
	             	asignarAtributo("PAGINA","contenido_COR_interfaz", "cod", "0269");
         		asignarAtributo("PAGINA","contenido_COR_interfaz", "msgle", "Interfaz con COR");
	             	       
	             	       
	             	 // Fecha:
                        this.generarHiddenFormatoFecha();
      getConfiguracionMenu("LPCOR","");
             		
             		if (accion.equals("")) {
             			
             			
             		/*		 
	   		Llamamos al ConectorObjeto con el idBusiness "INTCargaInicialInterfaz" y el dto. 
           		Con el DTOCargaInicialInterfaz obtenido mostramos la pantallaSeleccionDatos cargando los campos 
           		numeroLote y descripcionLote con los atributos numeroLote y descripcionInterfaz 
          		 */
          		 	traza("[]Estamos en CArgar Inicial Interfaz");
           			dtoString = new DTOString();
           			dtoString.setCadena(IGestorInterfaces.COD_INTERFAZ_COR1); 
           			traza("[]codigo de la interfaz == "+IGestorInterfaces.COD_INTERFAZ_COR1);
           			dtoString.setOidIdioma(this.idioma);
      				dtoString.setOidPais(this.pais);
      				traza("DTOSTRING =" +dtoString );
      				
      				paramConector = new Vector();
                                    
               			paramConector.add(dtoString);
                  		paramConector.add(new MareBusinessID("INTCargaInicialInterfaz"));

                  		traza("Antes de conectar en accion vacia");
                                    
                  		DruidaConector conector = conectar("ConectorObjeto", paramConector);
                  		traza("YA TENEMOS EL CONECTOR vamos a sacar el DTOCargarInicialInterfaz");
                 		dtoSalida = (DTOCargaInicialInterfaz)conector.objeto("DTOSalida");
                 		traza("dtoSalida despues de llamar al conector objeto");
                  		traza("dtoSalida =" +dtoSalida );
                  		/* 
                  		dtoSalida = new DTOCargaInicialInterfaz();
                  		dtoSalida.setNumeroLote(new Long(3));
                  		dtoSalida.setDescripcion("Estamos probando amigo");
                  		*/
      				
      				
      				asignar("VAR", "numeroLote", dtoSalida.getNumeroLote().toString());
      				asignar("VAR", "idioma", idioma.toString());
	             		asignar("VAR", "pais", pais.toString());
	             	        asignar("VAR", "accion", this.accion);
	             	      		   
                  		asignar("CTEXTO","txtDescripcion",dtoSalida.getDescripcion());           
                  		asignar("LABELC","lbldtLote",dtoSalida.getNumeroLote().toString());
                  		
				// Fecha del dia por defecto. Inc 20227
				String fecha = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
				asignar("CTEXTO", "txtFechaGenerar", fecha);
				asignarAtributo("CHECKBOX","ckSeguimientoPedidos","check","S");
				asignarAtributo("CHECKBOX","ckConfirmacionPedidos","check","S");
				/// fin modificacion
                  		                		                  		
                  		
                  	/*
                  	Si accion="recepcionar"{
                  		 
				if (seguimientoPedidos==true) { 
					Creamos un DTOCORRecepcionar que rellenamos con los campos recogidos de 
					la pantalla (además del pais y el idioma) 
		         		Llamamos al ConectorSeguimientoPedidosBatch con el dto creado y el idBusiness 
		         		"CORSeguimientoPedidosBatch" 
				} 
                		if (confirmacionPedidos==true) {
					Creamos un DTOCORRecepcionar que rellenamos con los campos recogidos de la 
					pantalla además del pais y el idioma) 
					Llamamos al ConectorConfirmacionRepartoBatch con el dto creado y el idBusiness 
					"CORConfirmacionRepartoBatch" 
				} 
			} 
                  		*/
      			} else if (accion.equals("recepcionar")) {
      				pagina("salidaGenerica");
                     		asignar("VAR", "cerrarVentana", "false");
                     		traza("***********Estamos en accion  recepcionar********");
                     		seguimientoPedidos = conectorParametroLimpia("ckSeguimientoPedidos", "", true);
                  		confirmacionPedidos = conectorParametroLimpia("ckConfirmacionPedidos", "", true);
                  		traza("+++++++++seguimientoPedidos = "+seguimientoPedidos );
                  		traza("+++++++++confirmacionPedidos = "+ confirmacionPedidos);
                  		
                  		Date fechaGenerar1=null;
                  		String fecha =null;
  		 		//Fecha real campo obligatorio
                             if(!conectorParametroLimpia("txtFechaGenerar", "", true).equals("")){
                                      fecha = conectorParametroLimpia("txtFechaGenerar","",true);
                                      traza("+++++++++fecha = "+fecha );
                                      traza("Formato de fecha: "+ UtilidadesSession.getFormatoFecha(this));
                                      fechaGenerar1 = UtilidadesBelcorp.getDatefromSICCStringFormat(fecha, UtilidadesSession.getFormatoFecha(this)); 
                                      traza("fechaGenerar: "+fechaGenerar1);
                                      //dtor.setFechaResolucionReal(fechaReclamoReal);	
                             }

                  	     if(!conectorParametroLimpia("txtDescripcion", "", true).equals("")){
	                  		descripcion = conectorParametroLimpia("txtDescripcion","",true);
	                  		traza("+++++++++descripcion = "+descripcion );
                  	      }
                  		
                  		//fechaGenerar = conectorParametroLimpia("txtFechaGenerar","",true);
                  		if(!conectorParametroLimpia("areatxtObservaciones", "", true).equals("")){
	                  		observaciones = conectorParametroLimpia("areatxtObservaciones","",true);
	                  		traza("+++++++++observaciones = "+observaciones );
                  	        }
                  	        this.numeroLote=new Long(conectorParametroLimpia("numeroLote","", true));
                  		
                     		
                     		traza("+++++++++descripcion = "+ descripcion );
                     		traza("+++++++++observaciones = "+ observaciones );
      				DTOCORRecepcionar dtoCOR = null;
      				
             			if (seguimientoPedidos.equals("S")) {
             				traza("Esta activado el de seguimineto de pedidos");
             				dtoCOR = new DTOCORRecepcionar();
             				paramConector = new Vector();
             				dtoCOR.setOidPais(this.pais);
             				dtoCOR.setOidIdioma(this.idioma);
             				dtoCOR.setFechaGenerar(fechaGenerar1);
             				dtoCOR.setSeguimientoPedidos(new Boolean(true));
             				if(confirmacionPedidos.equals("S")) {
             					traza("DEntro de seguimiento pedidos con confirmacion =true");
             					dtoCOR.setConfirmacionPedidos(new Boolean(true));
             					traza("DEntro de seguimiento pedidos con confirmacion =true");
             				} else {
             					traza("ELSE de seguimiento pedidos con confirmacion =true");
             					dtoCOR.setConfirmacionPedidos(new Boolean(false));
             					traza("ELSE de seguimiento pedidos con confirmacion =true");
             				}
             				traza("paso 1");
             				dtoCOR.setDescripcionLote(descripcion);
             				traza("paso 2");
             				
             				dtoCOR.setNumLote( this.numeroLote);
             				traza("paso 3");
             				dtoCOR.setObservaciones(observaciones);
             				traza("paso 4");
             				
             				paramConector.add(dtoCOR);
             				traza("paso 5");
                  			paramConector.add(new MareBusinessID("CORSeguimientoPedidosBatch"));
					traza("paso 6");
                  			
                  			traza("dtoCOR = "+dtoCOR);
                  			traza("Antes de ConectorSeguimientoPedidosBatch ");
                             		DruidaConector conectorSeguimiento = conectar("ConectorSeguimientoPedidosBatch", paramConector);
                  			traza("Despues de ConectorSeguimientoPedidosBatch");
                 		}
             			if (confirmacionPedidos.equals("S")) {
             				traza("Esta activado el de confirmacionPedidos ");
             				dtoCOR = new DTOCORRecepcionar();
             				paramConector = new Vector();
             				dtoCOR.setOidPais(this.pais);
             				dtoCOR.setOidIdioma(this.idioma);
             				dtoCOR.setFechaGenerar(fechaGenerar1);
             				dtoCOR.setConfirmacionPedidos(new Boolean(true));
             				if(seguimientoPedidos.equals("S")) {
             					traza("Antes de actualizar---confirmacionPedidos ");
             					dtoCOR.setSeguimientoPedidos(new Boolean(true));
             					traza("despues de actualizar---confirmacionPedidos ");
             				} else {
             					dtoCOR.setSeguimientoPedidos(new Boolean(false));
             				}
             				traza("paso 11");
             				dtoCOR.setDescripcionLote(descripcion);
             				traza("paso 21");
             				
             				dtoCOR.setNumLote( this.numeroLote);
             				traza("paso 31");
             				dtoCOR.setObservaciones(observaciones);
             				traza("paso 41");
             				
             				paramConector.add(dtoCOR);
             				traza("paso 51");
                  			paramConector.add(new MareBusinessID("CORConfirmacionRepartoBatch"));
					traza("dtoCOR = "+dtoCOR);
                  			traza("Antes de ConectorConfirmacionRepartoBatch" );
                  			
                                        DruidaConector conectorConfirmacion = conectar("ConectorConfirmacionRepartoBatch", paramConector);
                  			traza("Despues de ConectorConfirmacionRepartoBatch");
             				
             			}
             			
             			pagina("salidaGenerica");
             			//conectorAction("LPPresentarMenuPrincipal");
                		//conectorActionParametro("accion", "");
             			asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
             		} //accion!= vacia         
           
                      
                         
                }catch ( Exception e )  {
                	logStackTrace(e);
                        this.lanzarPaginaError(e);
                }
                 
            	traza("*** Salida - LPCOR - ejecucion ***");
           }    
    
    private void logStackTrace(Throwable e) throws Exception {
                      traza("Se produjo la excepcion: " + e.getMessage());
                      
                      ByteArrayOutputStream baos = new ByteArrayOutputStream();
                      PrintStream ps = new PrintStream(baos);
                      e.printStackTrace(ps);
                      
                      traza("Stack Trace: " + baos.toString());
     }

}