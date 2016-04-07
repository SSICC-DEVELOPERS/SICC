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

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.dtos.ccc.DTOBuscarRegistroVentas;
import es.indra.sicc.dtos.ccc.DTONumRegistros;

import es.indra.druida.DruidaConector;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.mare.common.mln.MareBusinessID;


 
public class LPCerrarRegistroVentas extends LPSICCBase {

	private String accion = null;
        private String casoUso = null;
	
        public LPCerrarRegistroVentas() {
        	super();
        }
        public void inicio() throws Exception {
       		pagina("contenido_registro_ventas_cerrar");      
        }
        public void ejecucion() throws Exception {
        	setTrazaFichero();
                Long pais=null;
                Long idioma=null;
               	try{
                	traza("****LPCerrarRegistroVentas Entrada");
                	Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
                	asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
                	idioma = UtilidadesSession.getIdioma(this);
                	pais = UtilidadesSession.getPais(this);
                	traza("Pais = "+pais);
                	traza("Idioma = "+idioma);
                	asignar("VAR", "idioma", idioma.toString());
			asignar("VAR", "pais", pais.toString());
               	 	this.accion = conectorParametroLimpia("accion","", true);
                	traza("Accion definida : "+accion);
                      	
                	this.generarHiddenFormatoFecha();
                      	
                	traza("FormatoFecha generado.");
                      	  
                	asignarAtributo("PAGINA","contenido_registro_ventas_cerrar", "cod", "0169"); //Codigo correcto 0169 -> Incidencia 8096
                	asignarAtributo("PAGINA","contenido_registro_ventas_cerrar", "msgle", "Cerrar Registro Ventas");
                	getConfiguracionMenu("LPCerrarRegistroVentas","");
                    	   
                	/*
                		Si accion="" {
                	    		Utilizando el subsistema GestorCargaPantalla, cargamos el COMBO Impuestos. 
					Pasándole al subsistema un DTOBelcorp y el idBusiness="CCCObtenerTasasImpuestoPorPais". 
					Con el DTOSalida que obtenemos cargamos el 
					COMBO "Impuestos". 
				}
                	*/
                	if(this.accion.equals("")){
                		cargaCombo(pais, idioma);			
			}
			/*
				Si accion="CerrarPeriodo" { 
					//Cerramos registros de ventas 
					Llamamos al conector "ConectorCerrarRegistro" pasándole: 
					idBusiness="CCCCerrarRegistroVentas" 
					DTOBuscarRegistroVentas (lleno con los datos de la pantalla). 
					Si optenemos una MareException (debido a que alguno de los códigos de cliente no son válidos)
					mostraremos un mensaje al usuario utilizando el método getMessage() de la MareException generada. 
					Mostramos un mensaje indicando el número de registros que se han actualizado. 
				}

			*/
			if(this.accion.equals("CerrarPeriodo")){
				//Cerramos registros de ventas 
				DTOBuscarRegistroVentas dto = new DTOBuscarRegistroVentas();
				dto.setOidIdioma(idioma);
				dto.setOidPais(pais); 
				String formato = UtilidadesSession.getFormatoFecha(this);
				//rellenar el resto de parametros con los datos de la pantalla
				String codCliDesde = conectorParametroLimpia("textClienteD","",true);
				if(codCliDesde!=null && !codCliDesde.equals("")){
					dto.setCodigoClienteDesde(codCliDesde);//String
				}
				String codCliHasta = conectorParametroLimpia("textClienteH","",true);
				if(codCliHasta!=null && !codCliHasta.equals("")){
					dto.setCodigoClienteHasta(codCliHasta);//String
				}
				String fecha = conectorParametroLimpia("text","",true);
				if(fecha!=null && !fecha.equals("")){
					java.util.Date fechaCierre = UtilidadesBelcorp.getDatefromSICCStringFormat(fecha,formato);
                	            	dto.setFechaCierre(fechaCierre);//Date
				}
				String fecha2 = conectorParametroLimpia("textFechaEmisionD","",true);
				if(fecha2!=null && !fecha2.equals("")){
					java.util.Date fechaEmisionDesde = UtilidadesBelcorp.getDatefromSICCStringFormat(fecha2,formato);
                	            	dto.setFechaEmisionDesde(fechaEmisionDesde);//Date
				}					
				String fecha3 = conectorParametroLimpia("textFechaEmisionH","",true);
				if(fecha3!=null && !fecha3.equals("")){
					java.util.Date fechaEmisionHasta = UtilidadesBelcorp.getDatefromSICCStringFormat(fecha3,formato);
                	                dto.setFechaEmisionHasta(fechaEmisionHasta);//Date
				}
				String oidAux = conectorParametroLimpia("cbImpuesto","",true);
				if(oidAux!=null && !oidAux.equals("")){
					Long oidImpuestos = new Long(oidAux);
					dto.setOidImpuestos(oidImpuestos);//Long
				}
				traza("El dto final es: "+dto); 
				Vector paramConector = new Vector();
				paramConector.add(dto);
				paramConector.add(new MareBusinessID("CCCCerrarRegistroVentas"));
				DruidaConector conector = null;
				traza("Antes de Conectar ConectorCerrarRegistrosVentas");
                		conector = conectar("ConectorCerrarRegistrosVentas", paramConector);                                                           
                		traza("Despues de Conectar ConectorCerrarRegistrosVentas");
                		//Mostramos un mensaje indicando el número de registros que se han actualizado.
                  		Object objeto=conector.objeto("DTONumRegistros");
                  		traza("Objeto recogido del conector"+objeto);
                  		DTONumRegistros dtoNumReg = (DTONumRegistros)conector.objeto("DTONumRegistros");         
                  		traza("DTONumRegistros calculado");                                   
                        	Long registros = dtoNumReg.getNumeroRegistros();
                        	asignarAtributo("VAR","registros","valor",registros.toString());
                        	cargaCombo(pais, idioma);
			}
			traza("****LPCerrarRegistroVentas Salida");
            	}catch(MareException me){
                	//mostraremos un mensaje al usuario utilizando el método getMessage() de la MareException generada. 
                	asignarAtributo("VAR","mensajeError","valor",me.getMessage());
                }
            	catch(Exception e) {
            		logStackTrace(e);
                	lanzarPaginaError(e);
                	cargaCombo(pais, idioma);
            	}
	}//Ejecucion
	
	private void cargaCombo(Long pais, Long idioma) throws Exception{
		try{
			ComposerViewElementList listelem = new ComposerViewElementList();
                    	   
                	ComposerViewElement tipoImpuestos = new ComposerViewElement();
                    		
                	DTOBelcorp dto = new DTOBelcorp();
                	dto.setOidPais(pais);
                	dto.setOidIdioma(idioma);
                    		
                	tipoImpuestos.setIDBusiness("CCCObtenerTasasImpuestoPorPais");
                	tipoImpuestos.setDTOE(dto);
			listelem.addViewElement(tipoImpuestos);
			   
			ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
			traza("Conector creado");
			conector.ejecucion();
			traza("Ejecutado");
			DruidaConector conConsultar = conector.getConector();
			traza("Obtener conConsultar");
	
			asignar("COMBO","cbImpuesto", conConsultar,"CCCObtenerTasasImpuestoPorPais");
		}catch(Exception e) {
            		logStackTrace(e);
                	lanzarPaginaError(e);
            	}
	}
	
	private void logStackTrace(Throwable e) throws Exception {     
        	traza("Se produjo la excepcion: " + e.getMessage());          
                ByteArrayOutputStream baos = new ByteArrayOutputStream();    
                PrintStream ps = new PrintStream(baos);
                e.printStackTrace(ps);
                traza("Stack Trace: " + baos.toString());                      
	}//logStackTrace 

}//clase
