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
import java.util.StringTokenizer;

import es.indra.sicc.dtos.edu.DTORegalo;
import es.indra.sicc.dtos.edu.DTOOIDRegalo;
import es.indra.sicc.dtos.edu.DTORegaloProducto;
import es.indra.sicc.dtos.edu.DTOObtieneRegalo;
import es.indra.sicc.dtos.edu.DTOEliminaRegalo;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.util.ArrayList;

public class LPMantenimientoRegalos extends LPSICCBase {

	private String accion = null;
	private String casoUso =null;
         
	public LPMantenimientoRegalos() {
		super();
	}
         
	public void inicio() throws Exception {
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try{
			traza("*** MARTAAAAAAAAAAAAAAEntrada - LPMantenimientoRegalos - ejecucion ***");
			
			Long idioma = UtilidadesSession.getIdioma(this);
			traza("idioma MARTAAAAAAAAAAA" + idioma.toString() );
			Long pais = UtilidadesSession.getPais(this);			
			traza("pais  MARTAAAAAA"  + pais.toString());
			this.accion = conectorParametroLimpia("accion", "", true);
			this.casoUso = conectorParametroLimpia("casoUso","",true);
			traza("ACCION: "+accion);
			                 
			if(this.accion.equals("mostrarInsertar")){//mostrarInsertar
				traza("accion=mostrarInsertar");
				//Muestra la pantalla PaginaRegalos 
				pagina("contenido_regalo_insertar");
				asignar("VAR","casoUso","insertar");
				asignar("VAR","pais", pais.toString());	
				asignar("VAR","idioma", idioma.toString());
				getConfiguracionMenu("LPMantenimientoRegalos", "Insertar");
				asignarAtributo("PAGINA","contenido_regalo_insertar","cod","0727");
		        	asignarAtributo("PAGINA","contenido_regalo_insertar","msgle","Insertar Regalo");	
		        	anyadeHiddensI18N(true, "EDU_REGAL",null, new Integer(1), "Formulario", "txtDescripcion", false);			
			}
			
			if(this.accion.equals("mostrarModificar")){//mostrarModificar
			       /*Muestra la pantalla PaginaBuscaRegalos 
				Se hacen invisibles los botones bntDetalle y bntEliminar */
				pagina ("contenido_regalo_modificar");
				asignar("VAR","casoUso","modificar");
				asignar("VAR","pais", pais.toString());	
				asignar("VAR","idioma", idioma.toString());
				getConfiguracionMenu("LPMantenimientoRegalos", "Consultar");
				asignarAtributo("PAGINA","contenido_regalo_modificar","cod","0729");
		        	asignarAtributo("PAGINA","contenido_regalo_modificar","msgle","Modificar Regalo");
			}
			
			if(this.accion.equals("mostrarConsulta")){//mostrarConsulta
			       /*Muestra la pantalla PaginaBuscaRegalos 
				Se hacen invisibles los botones bntModificar y bntEliminar */
				pagina ("contenido_regalo_modificar");
				asignar("VAR","casoUso","consultar");
				asignar("VAR","pais", pais.toString());	
				asignar("VAR","idioma", idioma.toString());
				getConfiguracionMenu("LPMantenimientoRegalos", "Consultar");
				asignarAtributo("PAGINA","contenido_regalo_modificar","cod","0730");
		        	asignarAtributo("PAGINA","contenido_regalo_modificar","msgle","Consultar Regalo");
			}
			
			if(this.accion.equals("mostrarEliminar")){//mostrarEliminar
			       /*Muestra la pantalla PaginaBuscaRegalos 
				Se hace invisible el botón bntModificar*/
				pagina ("contenido_regalo_modificar");
				asignar("VAR","casoUso","eliminar");
				asignar("VAR","pais", pais.toString());	
				asignar("VAR","idioma", idioma.toString());
				getConfiguracionMenu("LPMantenimientoRegalos", "Eliminar");
				asignarAtributo("PAGINA","contenido_regalo_modificar","cod","0728");
		        	asignarAtributo("PAGINA","contenido_regalo_modificar","msgle","Eliminar Regalo");
			}
			if(this.accion.equals("MuestraPantalla")){	
			       muestraPantalla(idioma, pais);
			}			
			if(this.accion.equals("MuestraPantallaConsulta")){
			        muestraPantallaConsulta(idioma,pais);
			}
			
			if(this.accion.equals("Insertar")){
				traza("accion=Insertar");
			       insertarRegalo(idioma, pais);
			}
			
			if(this.accion.equals("Modificar")){
			        modificarRegalo(idioma, pais);
			}
			
			if(this.accion.equals("Eliminar")){
				eliminarRegalo(idioma, pais);
			}
			
			traza("*** Salida - LPMantenimientoRegalos - ejecucion ***");		
		}catch ( Exception e )  {
		       e.printStackTrace();
		       this.logStackTrace(e);
		       lanzarPaginaError(e);
		}		
	}

	private void modificarRegalo (Long idioma, Long pais) throws Exception{
		/*
		*Se crea DTORegalo (dto) y se carga con los siguientes datos: 
		*dto.pais = pais de la sesión 
		*dto.idioma = idioma de la sesión 
		*dto.oid = oidRegalo 
		*dto.codRegalo = txtCodRegalo 
		*dto.attriTraducible = descripción del regalo internacionalizable 
		*Por cada uno de los productos en lstProductos 
		*Añade un nuevo elemento en el array dto.productos() 
		*dto.productos(i).oidProducto = oid de la lista 
		*Fin del Bucle 
		*
		*idNegocio = "EDUModificaRegalo" 
		*
		*Se invoca el conector ConectorModificarRegalo 
		*
		*Si se recibe una excepcion se muestra el mensaje de error correspondiente al usuario. 
		*
		*Si la operación se realiza correctamente se genera una pagina que cierre la ventana modal.
		*/
		
		traza("*** Entrada - LPMantenimientoRegalos - modificarRegalo ***");
		
		//Salida Generica
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "modificacionCorrecta();");
		//Fin Salida Generica				
		
		//conseguir OIDs de la lista
		String hSoids = conectorParametroLimpia("hOids","",true);
		traza("OIDS: "+hSoids);
		StringTokenizer stoids=new StringTokenizer(hSoids,",");
		int i=0;
		DTORegaloProducto dtoProds[] = new DTORegaloProducto[stoids.countTokens()];
		while (stoids.hasMoreTokens()){
			dtoProds[i]=new DTORegaloProducto();
			dtoProds[i].setOidProducto(new Long(stoids.nextToken()));
			i++;
		}//fin
		
		traza("Rellena DTOI18nSICC");
		//Rellenar DTOI18nSICC
		Vector vIdiomas = this.recuperaTraduccionesI18N(new Integer(1));
		DTOI18nSICC idiomas [] = null;
		if (vIdiomas != null){
			idiomas = new DTOI18nSICC[vIdiomas.size()];
			for (int j = 0; j < vIdiomas.size(); j++){
				idiomas [j] = (DTOI18nSICC)vIdiomas.get(j);
			}
		}//fin	
		
		String codRegalo = conectorParametroLimpia("txtCodRegalo", "", true);
		String oidRegalo = conectorParametroLimpia("oidRegalo","",true);
		traza("Vamos a rellenar el DTORegalo");
		//Creacion DTORegalo para insertar
		DTORegalo dto = new DTORegalo();
		dto.setOid(new Long(oidRegalo));
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		dto.setCodRegalo(new Integer(codRegalo));
		dto.setAttriTraducible(idiomas);
		dto.setProductos(dtoProds);
		//fin creacion DTORegalo

		traza("Rellenar vector paramConector");
		Vector paramConector = new Vector();
		paramConector.add(dto);
		paramConector.add(new MareBusinessID("EDUModificaRegalo"));            
		traza("Antes de Conectar ConectorModificarRegalo");
		DruidaConector conector = conectar("ConectorModificarRegalo", paramConector);							
		traza("Despues de Conectar ConectorModificarRegalo");		
		
		traza("*** Salida - LPMantenimientoRegalos - modificarRegalo ***");
	
	}

	private void insertarRegalo(Long idioma, Long pais) throws Exception{
		/*
		* Se crea DTORegalo (dto) y se carga con los siguientes datos: 
		* dto.pais = pais de la sesión 
		* dto.idioma = idioma de la sesión 
		* dto.codRegalo = txtCodRegalo 
		* dto.attriTraducible = descripción del regalo internacionalizable 
		* Por cada uno de los productos en lstProductos 
		* Añade un nuevo elemento en el array dto.productos() 
		* dto.productos(i).oidProducto = oid de la lista 
		* Fin del Bucle 
		*
		* idNegocio = "EDUInsertaRegalo" 
		*
		* Se invoca el conector ConectorInsertarRegalo 
		*
		* Se muestra la ventana PaginaRegalos
		*/
		
		traza("*** Entrada - LPMantenimientoRegalos - insertarRegalo ***");
		
		//Salida Generica
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "insercionCorrecta();");
		//Fin Salida Generica				
		
		//conseguir OIDs de la lista
		String hSoids = conectorParametroLimpia("hOids","",true);
		StringTokenizer stoids=new StringTokenizer(hSoids,",");
		int i=0;
		DTORegaloProducto dtoProds[] = new DTORegaloProducto[stoids.countTokens()];
		while (stoids.hasMoreTokens()){
			dtoProds[i]=new DTORegaloProducto();
			dtoProds[i].setOidProducto(new Long(stoids.nextToken()));
			i++;
		}//fin
		
		traza("Rellena DTOI18nSICC");
		//Rellenar DTOI18nSICC
		Vector vIdiomas = this.recuperaTraduccionesI18N(new Integer(1));
		DTOI18nSICC idiomas [] = null;
		if (vIdiomas != null){
			idiomas = new DTOI18nSICC[vIdiomas.size()];
			for (int j = 0; j < vIdiomas.size(); j++){
				idiomas [j] = (DTOI18nSICC)vIdiomas.get(j);
			}
		}//fin	
		
		String codRegalo = conectorParametroLimpia("txtCodRegalo", "", true);
		traza("Vamos a rellenar el DTORegalo");
		//Creacion DTORegalo para insertar
		DTORegalo dto = new DTORegalo();
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		dto.setCodRegalo(new Integer(codRegalo));
		dto.setAttriTraducible(idiomas);
		dto.setProductos(dtoProds);
		//fin creacion DTORegalo

		traza("Rellenar vector paramConector");
		Vector paramConector = new Vector();
		paramConector.add(dto);
		paramConector.add(new MareBusinessID("EDUInsertaRegalo")); 
		traza("****** EDUInsertaRegalo ******");
		traza("Antes de Conectar ConectorInsertarRegalo");
		DruidaConector conector = conectar("ConectorInsertarRegalo", paramConector);							
		traza("Despues de Conectar ConectorInsertarRegalo");
		
		traza("*** Salida - LPMantenimientoRegalos - insertarRegalo ***");

	}
	
	private void muestraPantalla(Long idioma, Long pais) throws Exception{
		/*
		*Se asigna al campo oidRegalo el oid recibido en la llamada 
		*
		*Se muestra PaginaRegalos 
		*
		*Se deshabilita txtCodRegalo 
		*
		*Se crea DTOOIDRegalo (dto) y se carga con la siguiente información: 
		*dto.oidRegalo = el oid recibido en la llamada 
		*
		*IdNegocio = "EDUObtieneRegalo" 
		*
		*Se invoca el conector ConectorObtieneRegalo 
		*
		*Se muestran en la pantalla los datos obtenidos: 
		*txtCodRegalo = DTOObtieneRegalo.codRegalo 
		*txtDescRegalo = DTOObtieneRegalo.descRegalo
		*/		
		traza("*** Entrada - LPMantenimientoRegalos - muestraPantalla ***");
				
		pagina("contenido_regalo_insertar");
		/// Menu secundario y titulo
		asignarAtributo("PAGINA","contenido_regalo_insertar","cod","0729");
		asignarAtributo("PAGINA","contenido_regalo_insertar","msgle","Modificar Regalo");
		getConfiguracionMenu("LPMantenimientoRegalos", "Modificar");
		///
		
		String oidRegaloS =conectorParametroLimpia("oidSeleccionado","",true);
		asignar("VAR","oidRegalo",oidRegaloS); 
		asignar("VAR","casoUso","modificar");
		asignar("VAR","pais", pais.toString());	
		asignar("VAR","idioma", idioma.toString());
		
		//deshabilitamos cajas y ocultamos botones
		asignarAtributoElemento("txtCodRegalo","disabled","S");
		
		//crea DTOOIDRegalo
		traza("Crea DTOOIDRegalo");
		Long oidRegalo = new Long(oidRegaloS);
		DTOOIDRegalo dto = new DTOOIDRegalo();
		dto.setOidRegalo(oidRegalo);
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		
		//creamos vector parametros
		traza("Crea vector Parametros");
		Vector paramConector = new Vector();
		paramConector.add(dto);
		paramConector.add(new MareBusinessID("EDUObtieneRegalo"));            
		//invocamos conector ConectorObtieneRegalo
		traza("Antes de Conectar ConectorObtieneRegalo");
		DruidaConector conector = conectar("ConectorObtieneRegalo", paramConector);
		traza("Despues de conectar ConectorObtieneRegalo");
		
		//mostramos datos recibidos DTOObtieneRegalo
		traza("recoge los datos recibidos del DTOObtieneRegalo");
		DTOObtieneRegalo dtoObtieneRegalo = new DTOObtieneRegalo();
		dtoObtieneRegalo = (DTOObtieneRegalo)conector.objeto("DTOObtieneRegalo");	
		if(dtoObtieneRegalo.getCodRegalo()!=null){ //Integer
			asignar("CTEXTO","txtCodRegalo", dtoObtieneRegalo.getCodRegalo().toString());
			asignar("VAR","codigoRegalo",dtoObtieneRegalo.getCodRegalo().toString());
		}
		///
		
		if(dtoObtieneRegalo.getDescRegalo()!=null){ //String 
			asignar("CTEXTO","txtDescripcion", dtoObtieneRegalo.getDescRegalo());
			asignar("VAR","descripcion",dtoObtieneRegalo.getDescRegalo());
		}
		
		traza("DTOObtieneRegalo"+dtoObtieneRegalo);
		
		anyadeHiddensI18N(true, "EDU_REGAL", oidRegalo, new Integer(1), "Formulario", "txtDescripcion", false);
		
		traza("*** Salida - LPMantenimientoRegalos - muestraPantalla ***");
	}
	
	private void muestraPantallaConsulta (Long idioma, Long pais) throws Exception{
		/*
		*Se asigna al campo oidRegalo el oid recibido en la llamada 
		*
		*Se muestra PaginaRegalos 
		*
		*Se deshabilitan txtCodRegalo y txtDescRegalo 
		*Se ponen invisibles los botones btnBuscar y btnQuitar 
		*
		*Se crea DTOOIDRegalo (dto) y se carga con la siguiente información: 
		*dto.oidRegalo = el oid recibido en la llamada 
		*
		*IdNegocio = "EDUObtieneRegalo" 
		*
		*Se invoca el conector ConectorObtieneRegalo 
		*
		*Se muestran en la pantalla los datos obtenidos: 
		*txtCodRegalo = DTOObtieneRegalo.codRegalo 
		*txtDescRegalo = DTOObtieneRegalo.descRegalo 
		*/
		traza("*** Entrada - LPMantenimientoRegalos - muestraPantallaConsulta ***");
				
		pagina("contenido_regalo_insertar");
		/// Menu secundario y titulo
		getConfiguracionMenu("LPMantenimientoRegalos", "Detalle");
		if(this.casoUso.equals("consultar")){
			asignarAtributo("PAGINA","contenido_regalo_insertar","cod","0730");
		}
		if(this.casoUso.equals("eliminar")){
			asignarAtributo("PAGINA","contenido_regalo_insertar","cod","0728");
		}
		
		String oidRegaloS =conectorParametroLimpia("oidSeleccionado","",true);
		asignar("VAR","oidRegalo",oidRegaloS); 
		asignar("VAR","casoUso","detalle");
		asignar("VAR","pais", pais.toString());	
		asignar("VAR","idioma", idioma.toString());
		
		
		//deshabilitamos cajas y ocultamos botones
		traza("deshabilita cajas");
		asignarAtributoElemento("txtCodRegalo","disabled","S");
		asignarAtributoElemento("txtDescripcion","disabled","S");
		//ocultar botones btnBuscar y btnQuitar desde javascript
		//crea DTOOIDRegalo
		traza("Crea DTOOIDRegalo");
		Long oidRegalo = new Long(oidRegaloS);
		DTOOIDRegalo dto = new DTOOIDRegalo();
		dto.setOidRegalo(oidRegalo);
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		
		//creamos vector parametros
		traza("Crea vector Parametros");
		Vector paramConector = new Vector();
		paramConector.add(dto);
		paramConector.add(new MareBusinessID("EDUObtieneRegalo"));            
		//invocamos conector ConectorObtieneRegalo
		traza("Antes de Conectar ConectorObtieneRegalo");
		DruidaConector conector = conectar("ConectorObtieneRegalo", paramConector);
		traza("Despues de conectar ConectorObtieneRegalo");
		
		//mostramos datos recibidos DTOObtieneRegalo
		traza("recoge los datos recibidos del DTOObtieneRegalo");
		DTOObtieneRegalo dtoObtieneRegalo = new DTOObtieneRegalo();
		dtoObtieneRegalo = (DTOObtieneRegalo)conector.objeto("DTOObtieneRegalo");	
		if(dtoObtieneRegalo.getCodRegalo()!=null){ //Integer
			asignar("CTEXTO","txtCodRegalo", dtoObtieneRegalo.getCodRegalo().toString());
		}
		if(dtoObtieneRegalo.getDescRegalo()!=null){ //String 
			asignar("CTEXTO","txtDescripcion", dtoObtieneRegalo.getDescRegalo());
		}
		

		anyadeHiddensI18N(true, "EDU_REGAL", oidRegalo, new Integer(1), "Formulario", "txtDescripcion", true);
		
		traza("*** Salida - LPMantenimientoRegalos - muestraPantallaConsulta ***");
	
	}

	
	private void eliminarRegalo (Long idioma, Long pais) throws Exception{

		/*
		*Se crea DTOEliminaRegalo (dto) y se carga con los siguientes datos: 
		*Por cada uno de los regalos en lstRegalos 
		*Si el regalo está seleccionado 
		*Añade un nuevo elemento en el array dto.regalos() 
		*dto.regalos(i).oidRegalo = oid de la lista 
		*Fin del Si 
		*Fin del Bucle 
		*
		*idNegocio = "EDUEliminaRegalo" 
		*
		*Se invoca el conector ConectorEliminarRegalo
		*/
		
		traza("*** Entrada - LPMantenimientoRegalos - eliminarRegalo ***");
		
		
		//Salida Generica
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "eliminacionCorrecta();");
		//Fin Salida Generica
		
		DTOEliminaRegalo dto = new DTOEliminaRegalo();
		
		//insercion en el array de DTO
		String hSoids= conectorParametroLimpia("hOids","",true);
		StringTokenizer stoids=new StringTokenizer(hSoids,",");
		int i=0;
		DTOOIDRegalo dtoOids[] = new DTOOIDRegalo[stoids.countTokens()];
		while (stoids.hasMoreTokens()){
			dtoOids[i]=new DTOOIDRegalo();
			dtoOids[i].setOidRegalo(new Long(stoids.nextToken()));
			i++;
		}
		dto.setRegalos(dtoOids);
		//fin
		
		//Creando vector prametros
		Vector paramConector = new Vector();
		paramConector.add(dto);
		paramConector.add(new MareBusinessID("EDUEliminaRegalo"));            
		traza("Antes de Conectar ConectorEliminarRegalo");
		DruidaConector conector = conectar("ConectorEliminarRegalo", paramConector);							
		traza("Despues de Conectar ConectorEliminarRegalo");
		//fin
		
		traza("*** Salida - LPMantenimientoRegalos - eliminarRegalo ***");
	
	}
		
	
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
                  
              ByteArrayOutputStream baos = new ByteArrayOutputStream();
              PrintStream ps = new PrintStream(baos);
              e.printStackTrace(ps);
              
              traza("Stack Trace: " + baos.toString());
	}
	
}