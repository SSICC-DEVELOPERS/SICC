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
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.logicanegocio.intsys.ConstantesINT;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.intsys.DTOEINTIVR;
import es.indra.sicc.dtos.intsys.DTOEnvioInterfacesIVR;

public class LPEnviarInterfaces extends LPSICCBase {

         private String accion = "";
         private String casoUso = null;
         private Long idioma=null;
         private Long pais= null;

         
         public LPEnviarInterfaces() {
                  super();
         }
         
         public void inicio() throws Exception {				

         }
         
         public void ejecucion() throws Exception {
                  setTrazaFichero();
                  rastreo();
                  traza("*** Entrada - LPEnviarInterfaces - ejecucion ***");
                  try{
                           accion = conectorParametroLimpia("accion","",true);
                           idioma = UtilidadesSession.getIdioma(this);
                           pais = UtilidadesSession.getPais(this);

                           if(accion.equals("")){
                                    cargarPagina();
                           }else if(accion.equals("enviar")){
                           	accionEnviar();
                           }
                  }catch ( Exception e )  {
                           logStackTrace(e);
                           lanzarPaginaError(e);
                  }
                  traza("*** Salida  - LPEnviarInterfaces - ejecucion ***");

         }
         
	private void cargarPagina() throws Exception{
	
		traza("*** Entrada - LPEnviarInterfaces - cargarBusqueda ***");
		pagina("contenido_completa_IVR_enviar");
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());
		
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		DTOString dtoString=new DTOString();
		dtoString.setOidPais(this.pais);
		dtoString.setOidIdioma(this.idioma);    
		dtoString.setCadena(conectorParametroLimpia("modoEnvio","",true));                             
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem1 =new ComposerViewElement(); 
		ComposerViewElement elem2 =new ComposerViewElement(); 
		ComposerViewElement elem3 =new ComposerViewElement(); 
		
		elem1.setIDBusiness("SEGConsultaCanales");
		elem1.setDTOE(dto);
		elem1.setPosOID((byte)0);
		elem1.setPosDesc((byte)1);
		
		elem2.setIDBusiness("SEGConsultaMarcas");
		elem2.setDTOE(dto);
		elem2.setPosOID((byte)0);
		elem2.setPosDesc((byte)1);		
		
		elem3.setIDBusiness("INTObtenerInterfacesIVR");
		elem3.setDTOE(dtoString);
		
		listelem.addViewElement(elem1);
		listelem.addViewElement(elem2);
		listelem.addViewElement(elem3);
		
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();		
		asignar("COMBO","cbCanal",conConsultar,"SEGConsultaCanales");
		asignar("COMBO","cbMarca",conConsultar,"SEGConsultaMarcas");
		asignar("COMBO","cbInterfaz",conConsultar,"INTObtenerInterfacesIVR");
		getConfiguracionMenu("LPEnviarInterfaces","");
		
		asignar("VAR","modoEnvio",conectorParametroLimpia("modoEnvio","",true));
		
		DTOString dtos = new DTOString();
				
		dtos.setOidIdioma(idioma);
		dtos.setOidPais(pais);
		dtos.setCadena("IVR-1");
				
		MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
		Vector vec = new Vector();
		vec.add(dtos);
		vec.add(mid);
		
		DruidaConector dc = conectar("ConectorObjeto", vec);
		DTOCargaInicialInterfaz dtoCarga = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
		
		String numeroDeLote=dtoCarga.getNumeroLote().toString();
		// INC 22104 - dmorello, 13/12/2005
		// Se modifica la asignación de valor del textfield Descripcion para que, además del String obtenido
		// en la carga inicial, se agregue la fecha actual
		String descripcion = dtoCarga.getDescripcion() + " " + formatDate(new Date(System.currentTimeMillis()));
		// Fin modificaciones INC 22104
		
		asignar("CTEXTO","Descripcion",descripcion);         		
		asignar("LABELC","lbldtLote",numeroDeLote);
		asignar("VAR","numeroLote",numeroDeLote);
		
		if(conectorParametroLimpia("modoEnvio","",true).equals("1")){
			asignarAtributo("PAGINA","contenido_completa_IVR_enviar","cod","0900");
			asignarAtributo("PAGINA","contenido_completa_IVR_enviar","msgle","Enviar completa desde IVR");
			getConfiguracionMenu("LPEnviarInterfaces","completo");

		}else{
			asignarAtributo("PAGINA","contenido_completa_IVR_enviar","cod","0901");
			asignarAtributo("PAGINA","contenido_completa_IVR_enviar","msgle","Enviar novedad desde IVR");		
			getConfiguracionMenu("LPEnviarInterfaces","novedad");

		}
         
		
		traza("*** Salida - LPEnviarInterfaces - cargarBusqueda ***");
	
	}
             
        private void accionEnviar() throws Exception{
        
		traza("*** Entrada - LPAdam - accionEnviar ***");
		String cbMarca     =conectorParametroLimpia("cbMarca","",true);
		String cbCanal     =conectorParametroLimpia("cbCanal","",true);    
		String cbAcceso    =conectorParametroLimpia("cbAcceso","",true);   
		String cbPeriodo   =conectorParametroLimpia("cbPeriodo","",true);  
		String descripcion =conectorParametroLimpia("Descripcion","",true);
		String cbInterfaz  =conectorParametroLimpia("cbInterfaz","",true); 
	        String numeroLote  =conectorParametroLimpia("numeroLote","",true); 
	        String modoEnvio   =conectorParametroLimpia("modoEnvio","",true);  
	        String observaciones=conectorParametroLimpia("areatxtObservaciones","",true);  
	        StringTokenizer interTokens=new StringTokenizer(cbInterfaz,"|");
	        Long arrayInterfaces[]=new Long[interTokens.countTokens()];
		for (int i=0; i<arrayInterfaces.length;i++){
			arrayInterfaces[i]=new Long(interTokens.nextToken());
		} 
	        
		Boolean modoEnvioBool=null;
		if(modoEnvio.equals("1")){
			modoEnvioBool=Boolean.FALSE;
		}else{
			modoEnvioBool=Boolean.TRUE;
		}
		traza("*******************************");
		traza("cbMarca       :"+cbMarca      );
                traza("cbCanal       :"+cbCanal      );
                traza("cbAcceso      :"+cbAcceso     );
                traza("cbPeriodo     :"+cbPeriodo    );
                traza("descripcion   :"+descripcion  );
                traza("cbInterfaz    :"+cbInterfaz   );
                traza("numeroLote    :"+numeroLote   );
                traza("modoEnvio     :"+modoEnvio    );
                traza("modoEnvioBool :"+modoEnvioBool);
                traza("observaciones: "+observaciones);
		traza("*******************************");
		DTOEnvioInterfacesIVR dtoEnvio=new DTOEnvioInterfacesIVR();
		dtoEnvio.setOidMarca(new Long(cbMarca));//Long   
		dtoEnvio.setOidCanal(new Long(cbCanal));//Long   
		dtoEnvio.setOidPeriodo(new Long(cbPeriodo));//Long   
		if ((cbAcceso!=null)&&(!cbAcceso.equals(""))){
			dtoEnvio.setOidAcceso(new Long(cbAcceso));//Long   
		}
		dtoEnvio.setNumeroLote(numeroLote);//String   
		dtoEnvio.setDescripcionLote(descripcion);//String   
		dtoEnvio.setObservaciones(observaciones);//String   
		dtoEnvio.setNovedad(modoEnvioBool);//Boolean 
		dtoEnvio.setInterfaces(arrayInterfaces);

		dtoEnvio.setOidPais(pais);//Long   
		dtoEnvio.setOidIdioma(idioma);//Long   

		traza("DTOEINTIVR: "+dtoEnvio);

		MareBusinessID mid = new MareBusinessID("INTEnviarIVRInterfaz");
		Vector vec = new Vector();
		vec.add(dtoEnvio);
		vec.add(mid);
		
		conectar("ConectorEnviarIVRInterfaz", vec);		
		
		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");		
	
		traza("*** Salida- LPAdam - accionEnviar ***");

	}                  
        private void logStackTrace(Throwable e) throws Exception {
                  
                  traza("Se produjo la excepcion: " + e.getMessage());
                  
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(baos);
                  e.printStackTrace(ps);
                  
                  traza("Stack Trace: " + baos.toString());
                  
         }

	/*
	 * dmorello, 13/12/2005
	 * Este método devuelve un String cuyo valor es el de la fecha recibida como parámetro,
	 * formateada según el formato correspondiente a la sesioón
	 */
	private String formatDate(Date date) {
		// Tomo el formato de fecha utilizado en la sesión, modificándolo para adecuarlo a SimpleDateFormat
		String formatoFecha = UtilidadesSession.getFormatoFecha(this).replace('m','M');
		SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
		return sdf.format(date);
	}

                  
}

