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

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cal.DTODatosClien;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

public class LPConsultarLineaCarreraConsultora extends LPSICCBase {
	
	public LPConsultarLineaCarreraConsultora() {super();}
	
	private String accion = null;
	private Long idioma = null;
	private String oidContacto = null;
	
	public void inicio() throws Exception {
		pagina("contenido_linea_carrera_consultora_consultar");
	}
	public void ejecucion() throws Exception {
		try{
			setTrazaFichero();
			traza("***Entrada - LPConsultarLineaCarreraConsultora - ejecucion***");
			
			accion = conectorParametroLimpia("accion","",true);
			traza("***accion : "+accion);
			this.oidContacto = conectorParametroLimpia("oidContacto","",true);   
			asignar("VAR", "oidContacto", this.oidContacto);

 


			String pais=conectorParametroLimpia("pais","",true);
			//String pais="1";
			traza("***Pais: "+pais);
			this.idioma=UtilidadesSession.getIdioma(this);
			traza("***Idioma: "+this.idioma);
			asignarAtributo("VAR", "idioma", "valor", idioma.toString());
			asignarAtributo("VAR", "pais", "valor", pais);
			/*asignar("VAR", "idioma", idioma.toString());
			asignar("VAR", "pais", pais);*/
			
			asignarAtributo("PAGINA","contenido_linea_carrera_consultora_consultar", "cod", "0576");
			asignarAtributo("PAGINA","contenido_linea_carrera_consultora_consultar", "msgle", "Consultar línea de carrera de una consultora");

			/*accion = "" 
				Se obtiene el oidPais y el oidCliente 
				cargaInicial(oidPais, oidCliente) 
			*/
			Long oidCliente = new Long(conectorParametroLimpia("oidCliente","",true));	
			//Long oidCliente = new Long(1);	
			traza ("***oidCliente: "+oidCliente);
			Long oidPais = new Long(pais);
			traza("***oidPais: "+oidPais);
			if ( accion.equals("")) {
				traza("Antes de la llamada a cargaInicial");
			       cargaInicial(oidPais,oidCliente);
			}
			
			getConfiguracionMenu("LPConsultarLineaCarreraConsultora","Consultar");
			traza("***Salida - LPConsultarLineaCarreraConsultora - ejecucion***");
		}catch(Exception e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}
	}
	
	private void cargaInicial(Long oidPais, Long oidCliente) throws Exception{
		traza("***Entrada - LPConsultarLineaCarreraConsultora - cargaInicial***");
		/*
		Proceso 
		======== 
		Se crea el elemento: 
		
		elem1.idNegocio="CALConsultarClasificacion" 
		elem1.dtoe=DTODatosClien (con el oidCliente y el oidPais) 
		
		Se invoca al conector ConectorConsultarClasificacion 
		
		Se carga la lista con los valores del oidSalida 
		-codCliente, 
		-tipoCliente, 
		-subtipoCliente, 
		-tipoClasificacionCliente, 
		-clasificiacionCliente 
		*/
		
		Vector paramEntrada = new Vector();
		DTODatosClien dto = new DTODatosClien();
		dto.setOidPais(oidPais);
              dto.setOidCliente(oidCliente);
		dto.setOidIdioma(this.idioma);
		paramEntrada.add(dto);
              paramEntrada.add(new MareBusinessID("CALConsultarClasificacion"));
              traza("antes de conectar");
              DruidaConector conector = conectar("ConectorConsultarClasificacion", paramEntrada);
              traza("despues de conectar");
              traza("Probando conector: ",conector);
              asignar("LISTAEDITABLE", "listado1", conector, "dtoSalida.resultado_ROWSET");
		
		traza("***Salida - LPConsultarLineaCarreraConsultora - cargaInicial***");
	}
	
         private void logStackTrace(Throwable e) throws Exception {
                  traza("Se produjo la excepcion: " + e.getMessage());

                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(baos);
                  e.printStackTrace(ps);
                      
                  traza("Stack Trace: " + baos.toString());
         }
         	
}