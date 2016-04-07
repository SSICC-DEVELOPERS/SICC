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
    $Id: LPInsertarMovimientos.java,v 1.1 2009/12/03 18:36:40 pecbazalar Exp $
    DESC
 */
/**
 * Sistema:           Belcorp
 * Modulo:            CCC
 * Submódulo:         
 * Componente:        LP
 * Fecha:             15/03/2004
 */ 


//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewClass;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.util.StringTokenizer;

import java.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.Character;

import java.text.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import java.math.BigDecimal;

public class LPInsertarMovimientos extends LPSICCBase {

   private String accion    	= null;
   private String oid         	= null;
   private String pais     		= null;     
   private String idioma        = null;	
   private String user          = null; 
   private String flag          = null; 
   private Long i;

   public LPInsertarMovimientos() {
		super();
	}

   public void inicio() throws Exception {  
     pagina("contenido_movimientos_bancarios_manual_mantenimiento");
	 this.getFormatosValidaciones();
   }
  
   public void ejecucion() throws Exception {
    
	 setTrazaFichero();

	 accion     = conectorParametroLimpia("accion", "", true);  
	 idioma     = UtilidadesSession.getIdioma(this).toString();
	 pais       = UtilidadesSession.getPais(this).toString();	
	 oid        = conectorParametro("oids");
	 flag     = conectorParametroLimpia("flag", "", true);  
	 traza("contenido de oid>>>>>" + oid);
	 user 	    = UtilidadesSession.getIdUsuario(this).toString();
	 String valorConse = "";
	 String oidMovimiento ="";

	 String separadorDecimal = UtilidadesSession.getSeparadorDecimales(this);
	 String separadorMiles = ((separadorDecimal.equals("."))) ? "," : ".";

     try  {
			rastreo();
			getConfiguracionMenu("LPInsertarMovimientos","");			
			asignarAtributo("VAR","hFormatoFechaPais","valor",UtilidadesSession.getFormatoFecha(this));
			traza("FECHA>>>> " + UtilidadesSession.getFormatoFecha(this));
			asignarAtributo("VAR","hPais","valor",pais);
			asignarAtributo("VAR","hIdioma","valor",idioma);
			asignarAtributo("VAR", "hSepMiles", "valor", separadorMiles);
			asignarAtributo("VAR", "hSepDec", "valor", separadorDecimal);

			// Tomar el Nro de Lote que me va a pasar el gestor de interfaces ***** 
			
			
			if (accion.equals(""))
			{
					ComposerViewElementList cv = crearParametrosEntrada();
					ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
					conector.ejecucion();
					DruidaConector resultados = conector.getConector();
					traza("resultados>>>>> " + conector.getConector().getXML());					
					asignar("COMBO","cbEmpresa", resultados,"SEGObtenerEmpresasPorPais");
					
					asignar("COMBO","cbTipoTransaccion", resultados, "CCCObtenerTiposTransaccion");	

                    Date fechaNow  = new Date();
                    String fechaDefault = UtilidadesBelcorp.fechaFormateada(fechaNow, "dd/MM/yyyy");        
                    traza("fechaDefault >>>>> " + fechaDefault );
                    asignar("CTEXTO","txtFechaMovimiento", fechaDefault);	

					traza("antes de setea businessid");

					DTOString dtos = new DTOString();
					//Asigno la constante
					dtos.setOidIdioma(new Long(idioma));
					dtos.setOidPais(new Long(pais));
					dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_GIS6);
                     
					traza("antes de setea businessid");
					MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
					Vector vec = new Vector();
					vec.add(dtos);
					vec.add(mid);
					traza("antes de llamar al conector");
					DruidaConector dc = conectar("ConectorObjeto", vec);
					DTOCargaInicialInterfaz dtocii = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
					traza("antes de asignar a la pantalla");
					asignarAtributo("LABELC", "lbldtNLote", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
                 	asignarAtributo("VAR", "lote", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
				
					asignarAtributo("LABELC","lbldtConsecutivo","valor","1");
					asignarAtributo("VAR","consecutivo","valor","1");
					asignarAtributo("VAR","procesaLote","valor","T");
					asignarAtributo("VAR","accion","valor",accion);				

			}
			else{
				  if (accion.equals("guardar"))
				 {
				   
					pagina("salidaGenerica");
					traza("esta en accion ::::  " + accion);				
						
					asignarAtributo("VAR","accion","valor","guardar");	
					
					DTOMovimientoBancario dtoMv = new DTOMovimientoBancario();

					dtoMv.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
					dtoMv.setOidPais(new Long(pais));
												
					// Valores de la cabecera
					
					String empresa = conectorParametro("cbEmpresa");						
					String lote = conectorParametro("lote");
					traza("contenido de lote _____ : "+ lote);
					
					Date fechaMov =  new Date();

					String fechaM = conectorParametro("txtFechaMovimiento");												
					traza("contenido de fechaM _____ : "+ fechaM);
						
					String ctaCte = conectorParametro("cbCCC");
					traza("contenido de ctaCte _____ : "+ ctaCte);

					///////////////////////////////////////////////////////

					String consTrans = conectorParametro("consecutivo");
					traza("contenido de consTrans _____ : "+ consTrans);

					String conT = conectorParametro("lbldtConsecutivo");
					traza(">>>> conT<<<<<" + conT);

					String tipoTrans = conectorParametro("cbTipoTransaccion");
					traza("contenido de tipoTrans _____ : "+ tipoTrans);

					String importePago = conectorParametroNumero("txtImportePago", this.FORMATO_DEFAULT);
					traza("contenido de importePago _____ : "+ importePago);

					String consultora = conectorParametro("txtCodConsultoraReal");
					traza("contenido de consultora _____ : "+ consultora);

					String nroFactura = conectorParametro("txtNFacturaBoleta");
					traza("contenido de nroFactura _____ : "+ nroFactura);

					String digitoChequeo = conectorParametro("txtDigitoChequeo");
					traza("contenido de digitoChequeo _____ : "+ digitoChequeo);

					String nroCupon = conectorParametro("txtNCupon");
					traza("contenido de nroCupon _____ : "+ nroCupon);

					String ofRecau = conectorParametro("txtOficina");
					traza("contenido de ofRecau _____ : "+ ofRecau);		
						
					String nombreOf = conectorParametro("txtNombreOficina");
					traza("contenido de nombreOf _____ : "+ nombreOf);
				
					String horario = conectorParametro("cbHorario");
					traza("contenido de horario _____ : "+ horario);	

					String observaciones = conectorParametro("areatxtObservaciones");
					traza("contenido de observaciones _____ : "+ observaciones);

					dtoMv.setNumeroLote(new Long(lote));
					traza("1");
					
					dtoMv.setEmpresa(new Long(empresa));	
					traza("2");
					dtoMv.setCuentaCorrienteBancaria(new Long(ctaCte));
					traza("3");
	
					/*Integer consecutivo = Integer.valueOf(consTrans);	
					int a=0;
					a+= Integer.parseInt(consTrans);
					dtoMv.setConsecutivoTransaccion(new Long(a));					
					a++;*/

					Long consecutivo = new Long(consTrans);						
					long a = consecutivo.longValue();
					traza("1a");
					dtoMv.setConsecutivoTransaccion(new Long(a));
					a = a + 1;	
					
					traza("2a");
			
					if (!tipoTrans.equals("")){
						dtoMv.setTipoTransaccion(new Long(tipoTrans));
					}
					
					dtoMv.setImportePago(new BigDecimal(importePago));
					dtoMv.setCodConsultoraReal(consultora);	

					traza("4");

					String valEstatus = conectorParametro("procesaLote");
					traza("contenido de idProceso _____ : "+ valEstatus);
					
					if (valEstatus.equals("SI")){
						valEstatus = new String("P");	
					}else{
						valEstatus = new String("A");	
					}

					//dtoMv.setIdentificadorProceso(valEstatus);
					dtoMv.setEstatusMovimientoTesoreria(new Character(valEstatus.charAt(0)));
					
		 			if (fechaM.equals("")){
							dtoMv.setFechaPago(null);
					}else{
							fechaMov= toDate(fechaM);
							traza("contenido de fechaMov>>>> " + fechaMov);
							dtoMv.setFechaPago(fechaMov);
							/* Dato insertado para que cumpla la condicion de eliminar */
						//	dtoMv.setFechaMovimientoAplicacion(fechaMov);
					}

					if (!nroFactura.equals(""))  {
						    dtoMv.setNumeroFactura(new Long(nroFactura));	
					}				
						
					if (!digitoChequeo.equals(""))  {
							dtoMv.setDigitoChequeo(new Integer(digitoChequeo));	
					}
						
					if (!nroCupon.equals(""))  {
							dtoMv.setNumeroCupon(new Long(nroCupon));
					}
					
					if (!ofRecau.equals(""))  {
							dtoMv.setOficinaRecaudadora(ofRecau);
					}	
					
					if (!nombreOf.equals(""))  {
							dtoMv.setNombreOficina(nombreOf);
					}					

					if (!horario.equals(""))  {
						if (horario.equals("0")){
							dtoMv.setHorario(new String("A"));
						}else{
							dtoMv.setHorario(new String("N"));	
						}						
					}
	
					if (!observaciones.equals(""))  {
							dtoMv.setObservaciones(observaciones);	
					}else{
						dtoMv.setObservaciones(null);	
					}

					dtoMv.setUsuarioProceso(user); 
					dtoMv.setIdentificadorProceso("P");
					//*************************@AGREGADO BELC300017922  - CNOZIGLIA*************************
						dtoMv.setIndConfirmaMovimientoManual(Boolean.FALSE);
					if(flag.equals("graba")){ 
						dtoMv.setIndConfirmaMovimientoManual(Boolean.TRUE);
					}
						

	    			MareBusinessID id = new MareBusinessID("CCCInsertarMovimientoBancario");
					Vector paramEntrada = new Vector();
					paramEntrada.add(dtoMv);
					paramEntrada.add(id);

					traza("contenido del vector:::::: ++ " + paramEntrada);

					traza("antes del conector");					
					DruidaConector conectorObjeto = conectar("ConectorObjeto", paramEntrada);
					traza("despues del conector");

					DTOOID dtoDatos = (DTOOID) conectorObjeto.objeto("DTOSalida");
					traza("contenido de dtoDatos>>>> " + dtoDatos.toString());
					
					oidMovimiento = dtoDatos.getOid().toString();
					traza("oidMovimiento>>>>> "+ oidMovimiento);	

					if (!oidMovimiento.equals("")){
						dtoDatos.setOid(dtoDatos.getOid());
						//String  cad = conectorParametroLimpia("cad","",true);
						String  cad = (String) conectorParametroSesion("cad");
						traza("cad recibido: "+cad);
						if(cad!=null){
								cad = cad + "," + oidMovimiento;
							//asignarAtributo("VAR", "cad", "valor", cad);
							//oid = oid + ", " + oidMovimiento; 
							//asignarAtributo("VAR", "procesosOids", "valor", oidMovimiento);
							//asignarAtributo("VAR", "oids", "valor", oid);
						}else	cad = oidMovimiento;				
						traza("cad nuevo: "+cad);
					   conectorParametroSesion("cad",cad);
					}	

					traza("111");
					flag = "";
					asignarAtributo("VAR","flag","valor","");
					valorConse = String.valueOf(a);
					traza("valor de valor*** " + valorConse);
					
					asignarAtributo("VAR", "ejecutar", "valor", "seteaValores(" +valorConse+",  " +oidMovimiento+ ")");	
					asignarAtributo("VAR", "boton", "valor", "A");	
					
				}

                /* SCS por incidencia nro.: BELC300022313, segun tony el boton "Procesar Lote", debe desaparecer; con lo cual su accion tb.!
				if (accion.equals("procesarLote")){
					
					//	 si accion="procesarLote" { 
					//		 Recibimos un array de oids y construimos un DTOOIDs y 
					//		 llamamos al ConectorProcesarLote con IdBusiness="CCCProcesarLotes". 
					//	}
					

					//oid   = conectorParametro("oids");
					//traza("contenido de oid en accion = procesar Lote " + oid);
					pagina("salidaGenerica");
					String  oid = (String) conectorParametroSesion("cad");
					traza("contenido de oid en accion = procesar Lote " + oid);

					StringTokenizer tokTemp = new StringTokenizer(oid, ",");
					int cant = tokTemp.countTokens();
					traza("************ cantidad de elementos " + cant);
					Long[] oids = new Long[cant];	
					
					int i = 0;
					while (tokTemp.hasMoreTokens()){
						   traza("antes de oid");
						   String conte = tokTemp.nextToken();
						   traza("despues ::::" + conte);							
						   oids[i] = new Long(conte);
						   i++;
					}	   

					DTOOIDs dtoOid = new DTOOIDs();
					dtoOid.setOidIdioma(new Long(idioma));
					dtoOid.setOidPais(new Long(pais));

					traza("seteo el valor del Oids[] --" + oids);
					dtoOid.setOids(oids);			

					MareBusinessID procesarID = new MareBusinessID("CCCProcesarLotes");
					Vector paramEntrada = new Vector();
					paramEntrada.add(dtoOid);
					paramEntrada.add(procesarID);

					traza("contenido del vector:::::: ++ " + paramEntrada);

					traza("antes del conector");					
					DruidaConector conectorProcesar= conectar("ConectorProcesarLote", paramEntrada);
					traza("despues del conector");	
					asignarAtributo("VAR","ejecutar","valor","procesoLote()");
					
				}	

				*/

			}

			if (accion.equals("limpiar")){		
					traza("en Limpiar>>>>>");
					 pagina("salidaGenerica");
					DTOString dtos = new DTOString();
					dtos.setOidIdioma(new Long(idioma));
					dtos.setOidPais(new Long(pais));
					dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_GIS6);
                     
					traza("antes de setea businessid");
					MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
					Vector vec = new Vector();
					vec.add(dtos);
					vec.add(mid);
					traza("antes de llamar al conector");
					DruidaConector dc = conectar("ConectorObjeto", vec);
					DTOCargaInicialInterfaz dtocii = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
					traza("antes de asignar a la pantalla >>> " + dtocii.getNumeroLote());	
				
					asignarAtributo("LABELC","lbldtConsecutivo","valor","1");
					asignarAtributo("VAR","consecutivo","valor","1");				
					asignarAtributo("VAR","procesaLote","valor","T");				
					asignarAtributo("VAR","accion","valor",accion);	
			    	asignarAtributo("VAR", "ejecutar", "valor",  "seteaValoresLimpiar(" +dtocii.getNumeroLote().toString() + ")");	
					traza("aaa");
			}



			
  }
  catch ( Exception e )  {
	 /*if (!accion.equals("")){
		if (accion.equals("guardar")){
			asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");
		}
	}*/
	
	BelcorpError belcorpError = new BelcorpError();
	DTOError dtoError = belcorpError.obtenerError(e);
	traza("cod error: " + dtoError.getCodigoError());
	if(dtoError.getCodigoError().equals("230340037")){
		traza("aca");
		asignarAtributo("VAR", "ejecutar", "valor", "errorAlGuardar()");
	}else	lanzarPaginaError(e);

	traza("pincho la lp principal");
	ByteArrayOutputStream pila = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(pila);
    e.printStackTrace(out);
    traza("EL STACK ES COMO SIGUE : " +  pila.toString());
    e.printStackTrace(); 
	e.getMessage();
	//lanzarPaginaError(e);
  }
}

private Date toDate(String sFecha) throws Exception
 {
	  String formatoFecha = UtilidadesSession.getFormatoFecha(this);
	  traza("formatoFecha::::::::::: " + formatoFecha);
	  //formatoFecha = formatoFecha.replace("m","M");
	  formatoFecha = formatoFecha.replace('m', 'M');
	  traza("formatoFecha::::::::::: " + formatoFecha);
	  //SimpleDateFormat miFecha = new SimpleDateFormat("dd/MM/yyyy");
	  SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
	  /* La fecha viene de la forma dd/MM/yyyy */
	  traza("miFecha>>>>>>>>>>>>>>>>>> " + miFecha); 
	  
	  java.util.Date fecha = miFecha.parse(sFecha);
	  traza("fecha>>>>>>>>>>>>>>>>>> " + fecha);
	  
	  
	  miFecha = new SimpleDateFormat(formatoFecha);
 
	  String fechaRes = miFecha.format(fecha);
	  fecha = miFecha.parse(fechaRes);
	  traza(fechaRes);
	  java.sql.Date sql = new java.sql.Date(fecha.getTime());
	  traza("sql Date: " + sql.toString() );
    
	  return sql;
 }


private ComposerViewElementList crearParametrosEntrada() throws Exception{
	ComposerViewElementList lista = new ComposerViewElementList();
	
    ComposerViewElement cmb1 = new ComposerViewElement();
	cmb1.setIDBusiness("SEGObtenerEmpresasPorPais");

	DTOBelcorp dto1 = new DTOBelcorp();
	dto1.setOidIdioma(new Long(idioma));
	dto1.setOidPais(new Long(pais));

	cmb1.setDTOE(dto1);
	traza("despues de setar el valor del dto1" + dto1);
					
	ComposerViewElement cmb2 = new ComposerViewElement();
	cmb2.setIDBusiness("CCCObtenerTiposTransaccion"); 
	traza("despues de CCCObtenerTiposTransaccion");

	DTOBelcorp dto2 = new DTOBelcorp();
	dto2.setOidIdioma(new Long(idioma));
	dto2.setOidPais(new Long(pais));

    cmb2.setDTOE(dto2);

	lista.addViewElement(cmb1);
	lista.addViewElement(cmb2);
	traza("contenido de lista" + lista);
					

	return lista; 

  }
	
}
