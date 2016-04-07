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
import java.util.Date;
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;                
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;           
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.sicc.logicanegocio.intsys.IDAT;
import es.indra.sicc.logicanegocio.intsys.ConstantesINT;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;


import es.indra.sicc.util.UtilidadesSession; 
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOString;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialDAT;

import es.indra.sicc.util.DTOSalida;

public class LPEnviarGenericoDatamart extends LPSICCBase {
	
	private String accion = null;
	private Long idioma;
	private Long pais;
	

	public LPEnviarGenericoDatamart() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_generico_datamart_enviar");
	} 

	public void ejecucion() throws Exception {
		
		rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPEnviarGenericoDatamart - ejecucion ***");
		
		this.accion = conectorParametroLimpia("accion", "", true);
		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);      	

		asignar("VAR","pais",this.pais.toString());
		asignar("VAR","idioma",this.idioma.toString());
		traza("Pais: "+this.pais);
		traza("Pais: "+this.idioma);
		
                asignarAtributo("PAGINA","contenido_generico_datamart_enviar", "cod", "0256");
                asignarAtributo("PAGINA","contenido_generico_datamart_enviar", "msgle", "Enviar generico al Datamart");
		
		try{		
			
			if(accion.equals("")){	      		
				this.cargaDatosIniciales();	      		
			}else if(accion.equals("enviar")){		
				this.enviar();		
			}
			
		}catch(Exception  e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPEnviarGenericoDatamart - ejecucion ***");	

	}

	private void cargaDatosIniciales() throws Exception {
		
		traza("*** Entrada- LPEnviarGenericoDatamart - cargaDatosIniciales ***");
		
		
						
		DTOString dtos = new DTOString();				
		dtos.setOidIdioma(idioma);
		dtos.setOidPais(pais);
		dtos.setCadena(IDAT.COD_INTERFAZ_DAT30);
		traza("[ASF] Interfaz para la carga inicial: "+dtos.getCadena());
				
		MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
		Vector vec = new Vector();
		vec.add(dtos);
		vec.add(mid);
		
		DruidaConector dc = conectar("ConectorObjeto", vec);
		DTOCargaInicialInterfaz dtoCarga = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
		
		String numeroDeLote=dtoCarga.getNumeroLote().toString();
		String descripcion=dtoCarga.getDescripcion();

		traza("numeroLote	 : "+numeroDeLote	       );
		traza("descripcionLote	 : "+ConstantesINT.DATAMART   );
		
		asignar("VAR","hNumeroLote",numeroDeLote);
		//modificado por incidencia 19599
		asignar("VAR","hDescripcionLote",ConstantesINT.DATAMART);

		asignar("LABELC","lbldtLote",numeroDeLote);
		//modificado por incidencia 19599	
		asignar("CTEXTO","Descripcion",ConstantesINT.DATAMART);     
		
		
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem1 =new ComposerViewElement(); 
		ComposerViewElement elem2 =new ComposerViewElement(); 		
		
		elem1.setIDBusiness("SEGConsultaCanales");
		elem1.setDTOE(dto);
		elem1.setPosOID((byte)0);
		elem1.setPosDesc((byte)1);
		
		elem2.setIDBusiness("SEGConsultaMarcas");
		elem2.setDTOE(dto);
		elem2.setPosOID((byte)0);
		elem2.setPosDesc((byte)1);		
				
		listelem.addViewElement(elem1);
		listelem.addViewElement(elem2);
		
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();		
		//asignar("COMBO", "cbCanal", conConsultar,"SEGConsultaCanales","VAL_OID",ConstantesSEG.CANAL_VD);
		//La utilizacion de constantes seg no es lo que va, ya que este valor debe levantarse
		//desde las propiedades de usuario. Igualmente, no se usaran las propiedades de usuario
		//hasta que no sea concensuado el cambio.
		asignar("COMBO", "cbCanal", conConsultar,"SEGConsultaCanales");
		asignar("COMBO", "cbMarca", conConsultar,"SEGConsultaMarcas");
		this.generarHiddenFormatoFecha();
		
		//añadido por incidencia 19599
		String fecha = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
		asignar("CTEXTO", "txtFechaFacturacion", fecha);
		
		//	Inicio. Agregado por HRCS - Fecha 17/04/2007 - Cambio Sicc20070215
		DTOBelcorp dtoB = new DTOBelcorp();				
		dtoB.setOidIdioma(idioma);
		dtoB.setOidPais(pais);
		traza(" DTOBelcorp: "+dtoB);
		MareBusinessID bID = new MareBusinessID("INTObtenerInterfacesDAT");
		Vector param = new Vector();
		param.add( dtoB );
		param.add( bID );
		DruidaConector resultado = conectar("ConectorObjetoGenerico", param);
		DTOSalida dtoInterfaces = (DTOSalida)resultado.objeto("DTOSalida");
		RecordSet rInterfaces = dtoInterfaces.getResultado();
		traza("rInterfaces: " + rInterfaces);
		if (!rInterfaces.esVacio()) {
		  DruidaConector conInterfaces = UtilidadesBelcorp.generarConector("rowset", rInterfaces, rInterfaces.getColumnIdentifiers());
		  this.asignar("LISTADOA", "listado1", conInterfaces, "rowset");
		}
		//	Fin.
		
		getConfiguracionMenu("LPEnviarGenericoDatamart","");
		traza("*** Salida - LPEnviarGenericoDatamart - cargaDatosIniciales ***");
		
	}
		
	private void enviar() throws Exception {
		
		traza("*** Entrada- LPEnviarGenericoDatamart - enviar ***");
		pagina("salidaGenerica");
		conectorParametroLimpia("accion", "", true);
		String marca              =conectorParametroLimpia("cbMarca", "", true);
		String canal              =conectorParametroLimpia("cbCanal", "", true);
		String acceso             =conectorParametroLimpia("cbAcceso", "", true);
		String descripcion        =conectorParametroLimpia("Descripcion", "", true);
		String fechaFacturacion   =conectorParametroLimpia("txtFechaFacturacion", "", true);
		String periodoFacturacion =conectorParametroLimpia("cbPeriodoFacturacion", "", true);
		String numeroLote	  =conectorParametroLimpia("hNumeroLote", "", true);
		String descripcionLote	  =conectorParametroLimpia("hDescripcionLote", "", true);
		String observaciones      =conectorParametroLimpia("areatxtObservaciones", "", true);
		
		DTOINTCargaInicialDAT dtoINTCargaInicialDAT=new DTOINTCargaInicialDAT();
		
		traza("marca             : "+marca             );
		traza("canal             : "+canal             );
		traza("acceso            : "+acceso            );
		traza("descripcion       : "+descripcion       );
		traza("fechaFacturacion  : "+fechaFacturacion  );
		traza("periodoFacturacion: "+periodoFacturacion);
		traza("numeroLote	 : "+numeroLote	       );
		traza("descripcionLote	 : "+descripcionLote   );
		traza("observaciones     : "+observaciones     );    

		dtoINTCargaInicialDAT.setMarca(new Long(marca));//Long   
		dtoINTCargaInicialDAT.setCanal(new Long(canal));//Long   
		if (acceso!=null){ 
			traza("Acceso tiene valor");
			if (!acceso.equals("")){
				traza("Acceso distinto de '' ");
				dtoINTCargaInicialDAT.setAcceso(new Long(acceso));//Long   
			}
		}
		dtoINTCargaInicialDAT.setNumeroLote(numeroLote);//String   
		dtoINTCargaInicialDAT.setDescripcionLote(descripcionLote);//String   
		dtoINTCargaInicialDAT.setObservaciones(observaciones);//String   
		dtoINTCargaInicialDAT.setFechaFacturacion(toDate(fechaFacturacion));//java.util.Date   
		dtoINTCargaInicialDAT.setPeriodoFacturacion(new Long(periodoFacturacion));//Long
		dtoINTCargaInicialDAT.setOidIdioma(idioma);
		dtoINTCargaInicialDAT.setOidPais(pais);    
		
		//	Agregador por HRCS - Fecha 18/04/2007 - Cambio 20070215
		traza("hListaInterfaces    : " + (String)conectorParametroLimpia("hListaInterfaces", "", true) );
		dtoINTCargaInicialDAT.setCodigosEnviar( (String)conectorParametroLimpia("hListaInterfaces", "", true) );    

		MareBusinessID intDATEnviarGenericoDatamart=new MareBusinessID("INTDATEnviarGenericoDatamart");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoINTCargaInicialDAT);
		paramEntrada.add(intDATEnviarGenericoDatamart);
		traza("Conecta a ConectorEnviarInterfacesDatamart--Start");		
		conectar("ConectorEnviarInterfacesDatamart", paramEntrada);
		traza("Conecta a ConectorEnviarInterfacesDatamart--OK");		
				
		asignarAtributo("VAR", "cerrarVentana", "valor", "false");		
		asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");		
		traza("*** Salida - LPEnviarGenericoDatamart - enviar ***");
		
	}
			
	private Date toDate(String sFecha) throws Exception{
	
		String formatoUsuario = UtilidadesSession.getFormatoFecha(this);
		char frmFecha[] = formatoUsuario.toCharArray();
		for (int i=0; i < frmFecha.length; i++ ) {
			if ( frmFecha[i] == 'm' ){
				frmFecha[i] = 'M';
			}else if ( frmFecha[i] == 'a' || frmFecha[i] == 'A'){
				frmFecha[i] = 'y';
			}
		}		
		String formatoFecha = new String(frmFecha);					
		SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
		java.util.Date fecha = miFecha.parse(sFecha);		
		return fecha;
	
	}
		
	private void logStackTrace(Throwable e) throws Exception {
	
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	
	}		
		
}