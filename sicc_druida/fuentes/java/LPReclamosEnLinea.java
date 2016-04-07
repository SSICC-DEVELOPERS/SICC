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
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigDecimal;

import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;                
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;           
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.util.UtilidadesSession; 
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.mare.common.dto.IMareDTO;

import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.rec.DTOBuscarClientesREC;
import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;
import es.indra.sicc.dtos.rec.DTODetalleReclamosREC;
import es.indra.sicc.dtos.rec.DTONumDocFecha;
import es.indra.sicc.dtos.rec.DTOReclamo;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;
import es.indra.sicc.dtos.rec.DTOLineaOperacion;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.DTOOID;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.Vector;
import es.indra.sicc.dtos.cra.DTOPeriodo;

public class LPReclamosEnLinea extends LPSICCBase {
	
	private String accion = null;
	private Long idioma;
	private Long pais;    
	private final String delimLinea="@@";
	private final String delimColum="||"; 
    private String opcionMenu = "";
	private Long oid;
    private String fila;
    public LPReclamosEnLinea() {
		super();
	}

	public void inicio() throws Exception {
		
	} 

	public void ejecucion() throws Exception {
		
		rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPReclamosEnLinea - ejecucion ***");
		
		this.accion = conectorParametroLimpia("accion", "", true);
		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);      	
		this.opcionMenu = conectorParametroLimpia("opcionMenu","",true);
		if(this.opcionMenu.equals("modificar")||this.opcionMenu.equals("consultar")){
            this.oid = new Long(conectorParametroLimpia("oid","",true));
            this.fila =conectorParametroLimpia("fila","",true);
        }
        try{
		
			if(accion.equals("")){	      		
				this.cargarPagina();	      		
			}else if(accion.equals("buscar_cliente")){			
				this.buscarCliente();			
			}else if(accion.equals("guardar")){
				this.guardar();	
			}else if(accion.equals("buscar_documento_cliente")){
				this.buscarDocumentoCliente();
			}else if(accion.equals("generar_solicitudes")){
				this.generarSolicitudes();
			}else if(accion.equals("buscar_numero_doc")){
				this.buscarDocumentoCliente();
			}else if(accion.equals("bloquear")){
				this.bloquear();
			}else if(accion.equals("buscar_cliente2")){
				this.buscarCliente2();
			}
		}catch(Exception  e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPReclamosEnLinea - ejecucion ***");	

	}
			
	private void cargarPagina () throws Exception {
	
		traza("*** Entrada - LPReclamosEnLinea - cargarPagina ***");

			
		if(this.opcionMenu.equals("modificar")){
		pagina("contenido_reclamos_linea_mantener");
				asignarAtributo("PAGINA", "contenido_reclamos_linea_mantener", "cod", "0127");
				asignarAtributo("PAGINA", "contenido_reclamos_linea_mantener", "msgle", "Modificar reclamos");
				getConfiguracionMenu("LPReclamosEnLinea","");

		}else if(this.opcionMenu.equals("consultar")){
			pagina("contenido_reclamos_linea_mantener");
			asignarAtributo("PAGINA", "contenido_reclamos_linea_mantener", "cod", "0217");
			asignarAtributo("PAGINA", "contenido_reclamos_linea_mantener", "msgle", "Detalle reclamo");
			getConfiguracionMenu("LPMantenerReclamos", "detalleReclamo");
		}else{
		pagina("contenido_reclamos_linea_introducir");
			getConfiguracionMenu("LPReclamosEnLinea","");
		}
        asignar("VAR","pais",this.pais.toString());
		asignar("VAR","idioma",this.idioma.toString());
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
			separadorMiles = ".";
		}
	
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);				
		
		Byte longitud = this.obtenerLongitudCodigoCliente();
		asignar("VAR","tamanio",longitud.toString());
		if(this.opcionMenu.equals("modificar")){
            traza("*** LPReclamosEnLinea - Modificar ***"); 
            cargaModificar();
		}else if(this.opcionMenu.equals("consultar")){
			traza("*** LPReclamosEnLinea - Consultar ***"); 
			cargaConsultar();
		
		}else{
            cargaCombo();
        }
        
        traza("*** Salida - LPReclamosEnLinea - cargarPagina ***");
		
	}
	
	private void buscarCliente2() throws Exception {
		traza("*** Entrada - LPReclamosEnLinea - buscarCliente2 ***");
		pagina("contenido_reclamos_linea_cliente_introducir");
							 		
		asignar("VAR","hTxtCodCliente",conectorParametroLimpia("txtCodCliente","",true));
		asignar("VAR","hTxtNumeroDocumento",conectorParametroLimpia("txtNumeroDocumento","",true));
		asignar("VAR","hTxtNombre",conectorParametroLimpia("txtNombre","",true));
		asignar("VAR","hTxtApellidoPaterno",conectorParametroLimpia("txtApellidoPaterno","",true));
		asignar("VAR","hTxtApellidoMaterno",conectorParametroLimpia("txtApellidoMaterno","",true));
		asignar("VAR","oidCliente",conectorParametroLimpia("oidCliente","",true));
		asignar("VAR","pais",this.pais.toString());
		asignar("VAR","idioma",this.idioma.toString());
		getConfiguracionMenu("LPReclamosEnLinea","cliente");
		
		traza("*** Salida - LPReclamosEnLinea - buscarCliente2 ***");
	}
	
	
	private void buscarCliente() throws Exception {
		
		traza("*** Entrada - LPReclamosEnLinea - buscarCliente ***");
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		/*pagina("contenido_reclamos_linea_cliente_introducir");
							 		
		asignar("VAR","hTxtCodCliente",conectorParametroLimpia("txtCodCliente","",true));
		asignar("VAR","hTxtNumeroDocumento",conectorParametroLimpia("txtNumeroDocumento","",true));
		asignar("VAR","hTxtNombre",conectorParametroLimpia("txtNombre","",true));
		asignar("VAR","hTxtApellidoPaterno",conectorParametroLimpia("txtApellidoPaterno","",true));
		asignar("VAR","hTxtApellidoMaterno",conectorParametroLimpia("txtApellidoMaterno","",true));				
		asignar("VAR","pais",this.pais.toString());
		asignar("VAR","idioma",this.idioma.toString());
		getConfiguracionMenu("LPReclamosEnLinea","cliente");*/
		
		//Crear un DTOE del tipo DTOBuscarClientesREC con los datos recibidos de la pantalla:
		DTOBuscarClientesREC dtoe = new DTOBuscarClientesREC();
		if (!conectorParametroLimpia("txtCodCliente","",true).equals("")){
			dtoe.setCodigoCliente(conectorParametroLimpia("txtCodCliente","",true));
		}
		if (!conectorParametroLimpia("txtNombre","",true).equals("")){
			dtoe.setNombre(conectorParametroLimpia("txtNombre","",true));
		}	
		if (!conectorParametroLimpia("txtApellidoPaterno","",true).equals("")){
			dtoe.setApellidoPaterno(conectorParametroLimpia("txtApellidoPaterno","",true));
		}
		if (!conectorParametroLimpia("txtApellidoMaterno","",true).equals("")){
			dtoe.setApellidoMaterno(conectorParametroLimpia("txtApellidoMaterno","",true));
		}
		if (!conectorParametroLimpia("txtNumeroDocumento","",true).equals("")){
			dtoe.setNumDocumento(new Long(conectorParametroLimpia("txtNumeroDocumento","",true)));
		}
		dtoe.setOidIdioma(idioma);
		dtoe.setOidPais(pais);
		dtoe.setOidPeriodo(cargarOidPeriodoActual());
		
		Vector paramConector = new Vector();
		paramConector.add(dtoe);
		paramConector.add(new MareBusinessID("RECObtenerClientesIntroducir"));
		DruidaConector conector = conectar("ConectorObtenerClientesNoPagREC", paramConector);
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		//seteamos el documento recibido por parametro en el dto
        
		//Si el dto.resultado contiene 1 solo registro
		if (dtoSalida.getResultado().getRowCount() == 1){
			//Si el dtoS contiene un solo registro
			String oidCliente = dtoSalida.getResultado().getValueAt(0,"OID").toString();
			String cierre = dtoSalida.getResultado().getValueAt(0,"CIERRE").toString();
			DTOSalida dtoS = buscarDocumento(new Long(oidCliente), dtoe.getNumDocumento());	
            RecordSet rs = dtoSalida.getResultado();

			traza("rs: " + rs);

			if (dtoS.getResultado().getRowCount() == 1){

				traza("rowcount == 1");
				
				String canal = dtoS.getResultado().getValueAt(0,"OIDCANAL").toString();
				String acceso = dtoS.getResultado().getValueAt(0,"OIDACCESO").toString();
				String subacceso = dtoS.getResultado().getValueAt(0,"OIDSUBACCESO").toString();

				traza("-a-");

				//oidCliente
				String oidNumDocumento = dtoS.getResultado().getValueAt(0,"OIDSOLICITUD").toString();
				String numDocumento = dtoS.getResultado().getValueAt(0,"NUMSOLICITUD").toString();
				String oidPeriodo = dtoS.getResultado().getValueAt(0,"PERIODO").toString();
				String oidTerriAdmin = rs.getValueAt(0,"OIDTERRADMI").toString();

				traza("-b-");

				//codigoOperacion ó numero documento??
				String codigoCliente = rs.getValueAt(0,"CODIGOCLIENTE").toString();

				traza("-b1-");

				String nombreApellidos = rs.getValueAt(0,"NOMBREAPELLIDOS").toString();

				nombreApellidos = nombreApellidos.replaceAll("'","¿?");//manejo de comillas. SiCC 20070200

				traza("-b2-");

				String numeroZona = rs.getValueAt(0,"CODIGOZONA").toString();

				traza("-b3-");
               
			   String estadoCliente = ((rs.getValueAt(0, "ESTADOCLIENTE") == null) ? "" : new String(rs.getValueAt(0, "ESTADOCLIENTE").toString()));

				traza("-c-");




                //if(rs.getValueAt(0,"MONEDA")!=null){
                //    moneda = rs.getValueAt(0,"MONEDA").toString();
				//}

				traza("fecha "+(dtoS.getResultado().getValueAt(0, "FECHAINGRESO")));

			    String fechaIngreso = ((dtoS.getResultado().getValueAt(0, "FECHAINGRESO") == null) ? null : new String(dtoS.getResultado().getValueAt(0, "FECHAINGRESO").toString()));
				StringTokenizer st = new StringTokenizer(fechaIngreso,"-");
				String anio = st.nextToken();
				String mes = st.nextToken();
				String dia = st.nextToken();
                fechaIngreso = mes+"/"+dia+"/"+anio;
				traza("fecha "+fechaIngreso);
				String sFechaIngreso = (fechaIngreso == null) ? "" : (new Long(new Date(fechaIngreso).getTime()).toString());

				String moneda = "";
				if (dtoS.getResultado().getValueAt(0, "MONEDA") != null){
					moneda = dtoS.getResultado().getValueAt(0, "MONEDA").toString();
				}




                String datos = canal + "@@" + acceso + "@@" + subacceso + "@@";
				datos += oidCliente + "@@" + oidNumDocumento + "@@" + numDocumento + "@@";
				datos += oidPeriodo + "@@" + oidTerriAdmin + "@@" + numDocumento + "@@" + codigoCliente + "@@";
				datos += nombreApellidos + "@@" + numeroZona + "@@" + estadoCliente + "@@" + moneda + "@@" + sFechaIngreso + "@@" + cierre;
								
				traza("Datos: " + datos);

				asignar("VAR", "ejecutar", "mostrarReclamo('" + datos + "')");
				
				/*asignar("LABELC","lblNumeroDocumento",dtoS.getResultado().getValueAt(0,"NUMSOLICITUD").toString());
				asignar("VAR","oidNumDocumento",dtoS.getResultado().getValueAt(0,"OIDSOLICITUD").toString());
				asignar("VAR","oidCliente",oidCliente);
				asignar("LABELC","lblCodCliente",rs.getValueAt(0,"CODIGOCLIENTE").toString());
			
				asignar("LABELC","lblNombreApellidosX",(String)rs.getValueAt(0,"nombreApellidos"));
				asignar("LABELC","lblNumeroZonaX",rs.getValueAt(0,"codigoZona").toString());
				asignar("LABELC","lblEstadoClienteX",(String)rs.getValueAt(0,"estadoCliente"));*/
				//asignar("VAR", "ejecutar", "mostrarDatos()");
			} else{

				traza("rowcount != 1");

				traza("rs: " + rs);

				//mostrar pantalla modal y emergente PgClienteProductoReclamos con 
				//lstClientes no visible, pasandole el oidCliente obtenido

				Object o = null;

				String oidTerriAdmin = (o = rs.getValueAt(0,"OIDTERRADMI")) != null ? o.toString() : " ";
				String codigoCliente = (o = rs.getValueAt(0,"CODIGOCLIENTE")) != null ? o.toString() : " ";
				String nombreApellidos = (o = rs.getValueAt(0,"NOMBREAPELLIDOS")) != null ? o.toString() : " ";
				nombreApellidos = nombreApellidos.replaceAll("'","¿?");//manejo de comillas. SiCC 20070200
				String numeroZona = (o = rs.getValueAt(0,"CODIGOZONA")) != null ? o.toString() : " ";
				String estadoCliente = (o = rs.getValueAt(0,"ESTADOCLIENTE")) != null ? o.toString() : " ";
				String cierreR = dtoSalida.getResultado().getValueAt(0,"CIERRE").toString();
				traza("-a-");

                String cadena = oidCliente + "@@" + oidTerriAdmin + "@@" + codigoCliente + "@@";
				cadena += nombreApellidos + "@@" + numeroZona + "@@" + estadoCliente + "@@" + cierreR;
				asignar("VAR", "ejecutar", "mostrarClienteReclamos('" + cadena + "')");
			}	
		} else {
			//mostrar pantalla modal y emergente PgClienteProductoReclamos
			asignar("VAR", "ejecutar", "mostrarClienteReclamos()");
		}
		
		traza("*** Salida - LPReclamosEnLinea - buscarCliente ***");
		
	}			
	
	private DTOSalida buscarDocumento (Long oidCliente , Long numDocumento) throws Exception{
		traza("*** Entrada - LPReclamosEnLinea - buscarDocumento ***");
		/*- Crear un DTOE del tipo DTOBuscarClientesREC con el valor del campo oidCliente del dto.resultado recibido: 
		dto.oidCliente = oidCliente 
		- Invocar conector ConectorObtenerDocumentoREC enviando el DTOE creado 
		- Crear IDBusiness="RECObtenerDocumento" 
		- Recuperar DTO obtenido 
		*/
		DTOBuscarClientesREC dtoe = new DTOBuscarClientesREC();
		dtoe.setOidCliente(oidCliente);    
        dtoe.setOidIdioma(idioma);
		dtoe.setOidPais(pais);
		//se setea el numero de documento
        dtoe.setNumDocumento(numDocumento);
        
        Vector paramConector = new Vector();
		paramConector.add(dtoe);
		paramConector.add(new MareBusinessID("RECObtenerDocumento"));
		DruidaConector conector = conectar("ConectorObtenerDocumentoREC", paramConector);
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		
		traza("*** Salida - LPReclamosEnLinea - buscarDocumento ***");
		return dtoSalida;
	}
		
	private void guardar() throws Exception {
		
		traza("*** Entrada - LPReclamosEnLinea - guardar ***");

		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");

		traza("numAtencion: "+conectorParametroLimpia("numAtencion", "", true));
		traza("txtNReclamo: "+conectorParametroLimpia("txtNReclamo", "", true));
		traza("oidNumDocumento: "+conectorParametroLimpia("oidNumDocumento", "", true));
		traza("oidCliente: "+conectorParametroLimpia("oidCliente", "", true));
		traza("cbMotivoBloqueo: "+conectorParametroLimpia("cbMotivoBloqueo", "", true));
		traza("oidPeriodo: "+conectorParametroLimpia("oidPeriodo", "", true));
		traza("oidTerriAdmin: "+conectorParametroLimpia("oidTerriAdmin", "", true));
		traza("chequeoFisico: "+conectorParametroLimpia("chequeoFisico", "", true));
		traza("PeriodoReclamo: "+conectorParametroLimpia("cbPeriodoRec", "", true));

		DTOReclamo dtoReclamo=new DTOReclamo();
		//	Agregado por HRCS - Fecha 08/03/2007 - Req.Cambio REC-007
		dtoReclamo.setPeriodoReclamo(new Long(conectorParametroLimpia("cbPeriodoRec", "", true)));	//	Long PeriodoReclamo
		dtoReclamo.setNumAtencion(new Long(conectorParametroLimpia("numAtencion", "", true))); //Long 	numAtencion
		String numReclamo=conectorParametroLimpia("txtNReclamo", "", true);
		if(numReclamo.equals("")){
			dtoReclamo.setNumReclamo(new Long(conectorParametroLimpia("numAtencion", "", true))); //Long 	
		}else{ 
			dtoReclamo.setNumReclamo(new Long(numReclamo)); //Long 	
		}	
		if(!((conectorParametroLimpia("hOidReclamo", "", true).toString()).equals(""))){
            dtoReclamo.setOidReclamo(new Long(conectorParametroLimpia("hOidReclamo", "", true)));
        }  
        ArrayList listaOidsE= new ArrayList();    
        if(!(conectorParametroLimpia("hOidsAEliminar", "", true).toString()).equals("")){
        
        String oidEliminar =   conectorParametroLimpia("hOidsAEliminar", "", true).toString();
        StringTokenizer st = new StringTokenizer(oidEliminar,";");
            while(st.hasMoreTokens()){
                listaOidsE.add(new Long(st.nextToken()));
            }
        dtoReclamo.setOperacionesAEliminar(listaOidsE);    
        }
		dtoReclamo.setOidDocumentoReferencia(new Long(conectorParametroLimpia("oidNumDocumento", "", true)));	//Long 		
		dtoReclamo.setOidCliente(new Long(conectorParametroLimpia("oidCliente", "", true))); //Long 		
		
		//dtoReclamo.setPeriodoReclamo(new Long(conectorParametroLimpia("oidPeriodo", "", true)));
		if(!conectorParametroLimpia("oidTerriAdmin", "", true).equals("")){
			dtoReclamo.setUACliente(new Long(conectorParametroLimpia("oidTerriAdmin", "", true)));
		}
		String cbMotivoBloqueo=conectorParametroLimpia("cbMotivoBloqueo", "", true);

		if(!cbMotivoBloqueo.equals("")){
			dtoReclamo.setMotivoBloqueo(new Long(cbMotivoBloqueo));	//Long

		}
        BigDecimal totalDevuelve = new BigDecimal(0);
        BigDecimal totalEnvia = new BigDecimal(0);
        BigDecimal saldoAPagar = new BigDecimal(0);
        
        dtoReclamo.setOidPais(pais);
		dtoReclamo.setOidIdioma(idioma);
		traza("numDocumento: "+conectorParametroLimpia("numDocumento", "", true));
        dtoReclamo.setNumeroDocumentoReferencia(new Long(conectorParametroLimpia("numDocumento", "", true)));	
		

		if (conectorParametroLimpia("chequeoFisico", "", true).equals("")){
			dtoReclamo.setChequeoFisico(Boolean.FALSE);
		} else {
			dtoReclamo.setChequeoFisico(Boolean.TRUE);
		}


		traza("dtoReclamo 1: "+dtoReclamo);
		
		
		ArrayList matrizReclamoCabeceras=generaMatrizReclamo(conectorParametroLimpia("hMatrizReclamoCabeceras", "", true));
		ArrayList matrizReclamoDetalles=null;
		if(!conectorParametroLimpia("hMatrizReclamoDetalles", "", true).equals("")){
			matrizReclamoDetalles=generaMatrizReclamo(conectorParametroLimpia("hMatrizReclamoDetalles", "", true));
		}else{
			matrizReclamoDetalles=new ArrayList();
		}

		
		ArrayList arrayCabeceras=new ArrayList();
		DTOOperacionReclamo dtoOperacionReclamo=new DTOOperacionReclamo();
		ArrayList arrayLineas=new ArrayList();
		DTOLineaOperacion dtoLineaOperacion=new DTOLineaOperacion();
		for(int i=0;i<matrizReclamoCabeceras.size();i++){			
			dtoOperacionReclamo=new DTOOperacionReclamo();
			dtoOperacionReclamo.setOidPais(pais);
			dtoOperacionReclamo.setOidIdioma(idioma);			

            
            /*
			00|contadorOperaciones  
			01|codOper
			02|codTipoOper
			03|numSecOper
			04|docReferecia 
			05|monedaDoc    		      
			06|oidNumDocumento       
			07|montoPerdida 
			08|uReclamadas 
			09|uDevueltas 
			10|totalCargo 
			11|totalAbono 
			12|oidMotivoBloqueo 
			13|oidEstadoOperacion 
			14|tipoBloqueo		
			15|oidTipoOperacion
			16|oidCodOperacion
			17|oidProducto
			18|clienteSeguro
			19|asume
			20|importe	
			*/			/*
0		contadorOperaciones  
1		,datosRetorno.codOperacion
2		,datosRetorno.codTipoOperacion
3		,contadorOperaciones
4		,datosRetorno.descRetorno  
5		,objParams.numDocumento 
6		,moneda      		      
7		,objDatosBloqueo.oidMotivoBloqueo
8		,objDatosBloqueo.tipoBloqueo		
9		,datosRetorno.oidTipoOpSeleccionada  
10		,datosRetorno.oidOpSeleccionada 
         /*perdida *//*
11        ,operacionesPerdida .oidAsumePerdida-
12       ,operacionesPerdida .precioCalculo
13       ,operacionesPerdida .porcentajeRecargo-
14        ,operacionesPerdida .oidProductoSeguro
15        ,operacionesPerdida .oidClienteSeguro-
16        ,operacionesPerdida .importeSeguro 
           
           DATOS DTO
            private Long tipoOperacion;   
            private Integer numSecuencial;   
            private Long oidDocumentoReferencia;   
            private Long motivoBloqueo;   
            private String tipoBloqueo; 
            private Boolean atendido;   
            private Long periodo;
            private Long indEntregaMercaderia;   
            private Long responsablePerdida;   
            private Long tipoSolicitudPerdida;   
            private Long tipoPosicionPerdida;   
            private Long asumePerdida;  
            private Long codigoArticulo;   
            private BigDecimal montoPerdida;   
            private Long precioPerdida;   
            private Double porcentajePerdida;   
            private Long estadoOperacion;   
            private Long periodoReclamo;   
            private Long clienteSeguro;   
            private ArrayList lineas;   
            private Long oidOperacion; 
            //campos añadidos para el paquete N041
            private String codigoArticuloDigitacion;        
            private String codigoClienteSeguro;
            private String codigoOperacion;                       
            private String codigoResponsablePerdida;
        */
			Vector datosLineas=buscaEnMatrizReclamo(matrizReclamoDetalles,((String[])matrizReclamoCabeceras.get(i))[0]);			
			

            dtoOperacionReclamo.setNumAtencion(new Long(conectorParametroLimpia("numAtencion", "", true)));//Long               
			
			traza("((String[])matrizReclamoCabeceras.get(i))[1] " + ((String[])matrizReclamoCabeceras.get(i)).length);
			for(int u=0;u<((String[])matrizReclamoCabeceras.get(i)).length;u++){
                traza("\n ((String[])matrizReclamoCabeceras.get(i)) " + ((String[])matrizReclamoCabeceras.get(0))[u]);    
            }
            String parameter=((String[])matrizReclamoCabeceras.get(i))[1];
            traza("Cod Operacion " + ((String[])matrizReclamoCabeceras.get(i))[1]);
            if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")){
				dtoOperacionReclamo.setCodigoOperacion(null);
			}else{			
				dtoOperacionReclamo.setCodigoOperacion(parameter);//String         		
			}

			parameter=((String[])matrizReclamoCabeceras.get(i))[9];
			traza("OID Tipo operacion " + ((String[])matrizReclamoCabeceras.get(i))[9]);
			if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")||parameter.equalsIgnoreCase(" ")){
				dtoOperacionReclamo.setTipoOperacion(null);
			}else{						
				dtoOperacionReclamo.setTipoOperacion(new Long(parameter));//Long             		
			}
			parameter=((String[])matrizReclamoCabeceras.get(i))[3];
			traza("numero Secuencial " + ((String[])matrizReclamoCabeceras.get(i))[3]);
			if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")||parameter.equalsIgnoreCase(" ")){
				dtoOperacionReclamo.setNumSecuencial(null);
			}else{			
				dtoOperacionReclamo.setNumSecuencial(new Integer(parameter));//Integer          		
			}
			parameter=((String[])matrizReclamoCabeceras.get(i))[18];
			traza("OID Documento referencia " + ((String[])matrizReclamoCabeceras.get(i))[18]);
			if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")||parameter.equalsIgnoreCase(" ")){
				dtoOperacionReclamo.setOidDocumentoReferencia(null);
			}else{						
				dtoOperacionReclamo.setOidDocumentoReferencia(new Long(parameter));//Long    
			}
			
            parameter=((String[])matrizReclamoCabeceras.get(i))[7];
			traza("motivo Bloqueo " + ((String[])matrizReclamoCabeceras.get(i))[7]);
			if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")||parameter.equalsIgnoreCase(" ")){
				dtoOperacionReclamo.setMotivoBloqueo(null);
			}else{						
				dtoOperacionReclamo.setMotivoBloqueo(new Long(parameter));//Long             																							             				
			}
			parameter=((String[])matrizReclamoCabeceras.get(i))[8];
			traza("Tipo Bloqueo " + ((String[])matrizReclamoCabeceras.get(i))[8]);
			if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")){
				dtoOperacionReclamo.setTipoBloqueo(null);
			}else{						
				dtoOperacionReclamo.setTipoBloqueo(parameter);//String
			}
			
			parameter=((String[])matrizReclamoCabeceras.get(i))[10];
			traza("Oid Operacion " + ((String[])matrizReclamoCabeceras.get(i))[10]);
            if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")||parameter.equalsIgnoreCase(" ")){
				dtoOperacionReclamo.setOidOperacion(null);
			}else{						
				dtoOperacionReclamo.setOidOperacion(new Long(parameter));//Long Combo
			}
			
            parameter=((String[])matrizReclamoCabeceras.get(i))[11];
			traza("Asume: " + parameter);
			if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")||parameter.equalsIgnoreCase(" ")){
				dtoOperacionReclamo.setAsumePerdida(null);
			}else{						
				dtoOperacionReclamo.setAsumePerdida(new Long(parameter));//Long
			}
			parameter=((String[])matrizReclamoCabeceras.get(i))[13];

			if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")||parameter.equalsIgnoreCase(" ")){
				dtoOperacionReclamo.setPorcentajePerdida(null);
			}else{						
				dtoOperacionReclamo.setPorcentajePerdida(new Double(parameter));//Double
			}
			
			parameter=((String[])matrizReclamoCabeceras.get(i))[14];

			if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")||parameter.equalsIgnoreCase(" ")){
				dtoOperacionReclamo.setCodigoArticulo(null);
			}else{						
				dtoOperacionReclamo.setCodigoArticulo(new Long(parameter));
			}


			parameter=((String[])matrizReclamoCabeceras.get(i))[15];
			traza("ClienteSeguro: " + parameter);
			if(parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase("null")||parameter.equalsIgnoreCase(" ")){
				dtoOperacionReclamo.setClienteSeguro(null);
			}else{						
				dtoOperacionReclamo.setClienteSeguro(new Long(parameter));//Long
			}
			parameter=((String[])matrizReclamoCabeceras.get(i))[17];
			traza("OID ClieAsumePerdida: " + parameter);
			if(parameter.equalsIgnoreCase("null")||parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase(" ")){			
				dtoOperacionReclamo.setResponsablePerdida(null);
			}else{						
				dtoOperacionReclamo.setResponsablePerdida(new Long(parameter));//BigDecimal
			}
			parameter=((String[])matrizReclamoCabeceras.get(i))[12];
			traza("PrecioPerdida: " + parameter);
			if(parameter.equalsIgnoreCase("null")||parameter.equals("_")||parameter.equalsIgnoreCase("undefined")||parameter.equalsIgnoreCase(" ")){			
				dtoOperacionReclamo.setPrecioPerdida(null);
			}else{						
				dtoOperacionReclamo.setPrecioPerdida(new Long(parameter));//BigDecimal
			}
            parameter=((String[])matrizReclamoCabeceras.get(i))[20];
			traza("AUtorizado: " + parameter);
			if(parameter.equalsIgnoreCase("null")||parameter.equals("_")||parameter.equalsIgnoreCase("undefined")){			
				dtoOperacionReclamo.setAutorizacion(null);
			}else{						
				dtoOperacionReclamo.setAutorizacion(parameter.toString());//BigDecimal
			}
            parameter=((String[])matrizReclamoCabeceras.get(i))[19];
			traza("Oid Opera Recla" + parameter);
			if(parameter.equalsIgnoreCase("null")||parameter.equals("_")||parameter.equalsIgnoreCase("undefined")){			
				dtoOperacionReclamo.setOidOperacionReclamo(null);
			}else{						
				dtoOperacionReclamo.setOidOperacionReclamo(new Long(parameter));
			}
            BigDecimal montoPerdida = new BigDecimal(0);
            
			traza("datosLineas: " + datosLineas);

			arrayLineas=new ArrayList();
			int longitudLineas=datosLineas.size();
			for(int j=0;j<longitudLineas;j++){
				/*
				00|identificador
				01|tipoMovi
				02|codVenta
				03|codProducto
				04|descProducto
				05|unidadesReclamadas
				06|precioProducto
				07|descuentoUnitario
				08|unidadesDevueltas
				09|importeCargo
				10|importeAbono
				11|motivoDevolucion
				12|numLinea
				13|oidTipoMovi
				14|oidCodVenta
				15|oidCodProducto
				16|montoPerdida
				17|precioPerdida
				18|oidOperacion
				19|oidTpoOferta
				20|oidMotivo
				*/	
				
                dtoLineaOperacion=new DTOLineaOperacion();	
				dtoLineaOperacion.setOidPais(pais);
				dtoLineaOperacion.setOidIdioma(idioma);							
				String[] datosLinea=(String[])datosLineas.elementAt(j);
				traza("datosLinea largo" +  datosLinea.length);
                String datoLinea=datosLinea[12];
				traza("datoLinea" +  datoLinea);
//				datoLinea = datoLinea.replace/(',',UtilidadesSession.getFormatoNumerico(this).charAt(0));
				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setNumLinea(null);
				}else{				
					dtoLineaOperacion.setNumLinea(new Integer(datoLinea));//Integer 
				}
				datoLinea=datosLinea[14];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setOidCodVenta(null);
				}else{								  		 		
					dtoLineaOperacion.setOidCodVenta(new Long(datoLinea));//Long   		
				}
				datoLinea=datosLinea[15];

				if(datoLinea.equalsIgnoreCase("null")||datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")){
					dtoLineaOperacion.setOidCodProducto(null);
				}else{								
					dtoLineaOperacion.setOidCodProducto(new Long(datoLinea));//Long   				
				}
				datoLinea=datosLinea[5];

//				datoLinea = datoLinea.replace(',',UtilidadesSession.getFormatoNumerico(this).charAt(0));
				
				
				if(datoLinea.equalsIgnoreCase("null")||datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")){				
					dtoLineaOperacion.setUnidadesReclamadas(null);
				}else{	
					traza("datoLinea " + datoLinea);					
					dtoLineaOperacion.setUnidadesReclamadas(new Integer(datoLinea.trim()));//Integer
				}
				datoLinea=datosLinea[6];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setPrecio(null);
				}else{				
					dtoLineaOperacion.setPrecio(new BigDecimal(datoLinea));//BigDecimal   		
				}
				datoLinea=datosLinea[10];

				traza("totalDevuelve en datosLinea: " + datoLinea);

				if(datoLinea.equalsIgnoreCase("null")||datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")){				
					traza("totalDevuelve: entro por null");
					dtoLineaOperacion.setImporteAbono(null);
				}else{
					traza("totalDevuelve: entro por else");
					dtoLineaOperacion.setImporteAbono(new BigDecimal(datoLinea));//BigDecimal   		
                    totalDevuelve = totalDevuelve.add(new BigDecimal(datoLinea));
                }

				datoLinea=datosLinea[9];

				traza("totalEnvia en datosLinea: " + datoLinea);

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					traza("totalEnvia: entro por null");
					dtoLineaOperacion.setImporteCargo(null);
				}else{				
					traza("totalEnvia: entro por else");
					dtoLineaOperacion.setImporteCargo(new BigDecimal(datoLinea));//BigDecimal   			
                    totalEnvia = totalEnvia.add(new BigDecimal(datoLinea));
                }
				datoLinea=datosLinea[8];

				datoLinea = datoLinea.replace(',',UtilidadesSession.getFormatoNumerico(this).charAt(0));
				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setUnidadesDevueltas(null);
				}else{								
					dtoLineaOperacion.setUnidadesDevueltas(new Integer(datoLinea));//Integer   		
                }
                
				datoLinea=datosLinea[16];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")||datoLinea.equalsIgnoreCase("NaN")){
					dtoLineaOperacion.setMontoPerdida(null);
				}else{				
					dtoLineaOperacion.setMontoPerdida(new BigDecimal(datoLinea));//BigDecimal   		
                    montoPerdida.add(new BigDecimal(datoLinea));
                }
				datoLinea=datosLinea[17];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setPrecioPerdida(null);
				}else{								
					dtoLineaOperacion.setPrecioPerdida(new Long(datoLinea));//Long   ???		
				}
				datoLinea=datosLinea[13];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setOidTipoMovimiento(null);
				}else{				
					dtoLineaOperacion.setOidTipoMovimiento(new Long(datoLinea));//Long   		
				}
				datoLinea=datosLinea[20];

				
				if(datoLinea.equalsIgnoreCase("null")||datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")){
					dtoLineaOperacion.setOidMotivoDevolucion(null);
				}else{								
					dtoLineaOperacion.setOidMotivoDevolucion(new Long(datoLinea.trim()));//Long   												
				}
				datoLinea=datosLinea[18];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setOperacion(null);
				}else{								
					dtoLineaOperacion.setOperacion(new Long(datoLinea));//Long   ???		
				}
				datoLinea=datosLinea[2];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setCodigoVenta(null);
				}else{								
					dtoLineaOperacion.setCodigoVenta(datoLinea);//String 
				}
				datoLinea=datosLinea[19];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setOidTpoOferta(null);
				}else{								
					dtoLineaOperacion.setOidTpoOferta(new Long(datoLinea));//String 
				}				

				datoLinea=datosLinea[21];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setPosicionReferencia(null);
				}else{								
					dtoLineaOperacion.setPosicionReferencia(new Long(datoLinea));//String 
				}			

				
				datoLinea=datosLinea[22];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setOidConcurso(null);
				}else{								
					dtoLineaOperacion.setOidConcurso(new Long(datoLinea));//String 
				}			

				datoLinea=datosLinea[23];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setOidNivel(null);
				}else{								
					dtoLineaOperacion.setOidNivel(new Long(datoLinea));//String 
				}			
				
				datoLinea=datosLinea[24];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")){
					dtoLineaOperacion.setOidPremio(null);
				}else{								
					dtoLineaOperacion.setOidPremio(new Long(datoLinea));//String 
				}			
				
				datoLinea=datosLinea[25];

				if(datoLinea.equals("_")||datoLinea.equalsIgnoreCase("undefined")||datoLinea.equalsIgnoreCase("null")||datoLinea.equalsIgnoreCase("NaN")){
					dtoLineaOperacion.setPrecioContable(null);
				}else{				
					dtoLineaOperacion.setPrecioContable(new BigDecimal(datoLinea));//BigDecimal   		
                    montoPerdida.add(new BigDecimal(datoLinea));
                }
				
				
				
				traza("dtoLineaOperacion: " + dtoLineaOperacion);

				arrayLineas.add(dtoLineaOperacion);
				
			}
			
			
			dtoOperacionReclamo.setMontoPerdida(montoPerdida);
							
			dtoOperacionReclamo.setLineas(arrayLineas);//ArrayList  
									
			arrayCabeceras.add(dtoOperacionReclamo);
		}												
		
        saldoAPagar = this.calcularTotales(totalEnvia,totalDevuelve);		
		dtoReclamo.setTotalEnvia(totalEnvia); //BigDecimal		

		traza("totalDevuelve antes de asignar a dto: " + totalDevuelve);

		dtoReclamo.setTotalDevuelve(totalDevuelve);//BigDecimal		
		dtoReclamo.setSaldoAPagar(saldoAPagar);//BigDecimal 		
        
        asignarAtributo( "VAR", "hTotalEnvia","valor", totalEnvia.toString());
        asignarAtributo( "VAR", "hTotalDevuelve", "valor", totalDevuelve.toString());
        asignarAtributo( "VAR", "hSaldoPagar","valor", saldoAPagar.toString());
        
        dtoReclamo.setOperaciones(arrayCabeceras);	//ArrayList 

		traza("dtoReclamo: " + dtoReclamo);

		Vector paramConector = new Vector();
		paramConector.add(dtoReclamo);
		paramConector.add(new MareBusinessID("RECGuardarReclamo"));
		traza("antes de conectar dtoReclamo " + dtoReclamo);
		DruidaConector conector = conectar("ConectorGuardarReclamo", paramConector);
		asignar("VAR", "ejecutar", "vaciaGuardar()");
		asignarAtributo( "VAR", "numAtencion", "valor", conectorParametroLimpia("numAtencion", "", true) );
		traza("*** Salida - LPReclamosEnLinea - guardar ***");
			
	}	

	private Vector buscaEnMatrizReclamo(ArrayList entrada,String oid) throws Exception {
		traza("*** Entrada - LPReclamosEnLinea - buscaEnMatrizReclamo ***");
		traza("cadena entrada: " + entrada);
		traza("Oid: " +  oid);
		Vector resultados=new Vector();
		traza("nFilas"+entrada.size());
        if(entrada.size()>0){
			int nColumnas=((String[])entrada.get(0)).length;
            traza(" nColumnas: " + nColumnas+ " - ");	
			for (int i=0;i<entrada.size();i++){
				
                if(((String[])entrada.get(i))[0].equals(oid)){
					resultados.add(entrada.get(i));				
					
				}
			}			
		}				
		traza("*** Salida - LPReclamosEnLinea - buscaEnMatrizReclamo ***");
		return resultados;
	}

	private ArrayList generaMatrizReclamo(String entrada) throws Exception {
		
		traza("*** Entrada - LPReclamosEnLinea - generaMatrizReclamo ***");
		traza("Entrada: "+entrada);
		ArrayList retorno= new ArrayList();
		StringTokenizer tokenLineas= new StringTokenizer(entrada,delimLinea);
		int numeroLineas =tokenLineas.countTokens();
        traza("numero de lineas "+numeroLineas);
        
        int nLinea =0;
        int nColum =0;
        
        while(tokenLineas.hasMoreTokens()){
            String linea = tokenLineas.nextToken();
            
            traza(" - linea Nro ->"+nLinea+" -linea-->"  +linea );
            StringTokenizer tokenColum= new StringTokenizer(linea,delimColum);
            String[] columnas = new String[tokenColum.countTokens()];
            while(tokenColum.hasMoreTokens()){
                columnas[nColum] =tokenColum.nextToken();
                nColum++;
            }
            retorno.add(columnas);
            traza("largo columna "+columnas.length);
            nColum = 0;
            nLinea++;        
        }
            traza("largo filas"+retorno.size());
        
		/*while(tokenColum.hasMoreTokens()){			
			retorno[0][nColum]=tokenColum.nextToken();
			nColum++;
		}
						
		int nLinea=1;
		while(tokenLineas.hasMoreTokens()){
			nColum=0;
			columna1=tokenLineas.nextToken();
			tokenColum= new StringTokenizer(columna1,delimColum);
			while(tokenColum.hasMoreTokens()){			
				retorno[nLinea][nColum]=tokenColum.nextToken();
				nColum++;
			}
			nLinea++;			
		}*/
		
        //for (int i=0;i<numeroLineas;i++){
			//traza("numero de Columnas "+numeroCols);
            /*for(int j=0;j<numeroLineas;j++){
				traza(" , "+j+"--->"+retorno[j][0]+"-");
			}*/
          //  traza("<---Columna-- "+i);
		//}		
		traza("*** Salida - LPReclamosEnLinea- generaMatrizReclamo ***");
		return retorno;
	}
	
	private void buscarDocumentoCliente() throws Exception {
		
		traza("*** Entrada - LPReclamosEnLinea - buscarDocumentoCliente ***");

		String fechaIngreso = conectorParametroLimpia("hFechaIngreso","",true);

		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");

		//V_INT_RET_04 Se elimina el seteo de Canal, Acceso y Subacceso para que se utilice el mismo contador que en la INT-RET 
		//(recepcionarreclamoscalypso)				

		StringTokenizer st = new StringTokenizer(fechaIngreso,"-");
		String anio = st.nextToken();
   		String sFechaIngreso = "";
		if (st.countTokens() > 0){ 
			String mes = st.nextToken();
			String dia = st.nextToken();
			fechaIngreso = mes+"/"+dia+"/"+anio;
			sFechaIngreso = (new Long(new Date(fechaIngreso).getTime()).toString());
		}else{
			sFechaIngreso = new String(anio);
			
		}
		traza("fecha "+fechaIngreso);


		String numAtencion=this.generarNumDocumento();
		traza("generarNumDocumento: "+numAtencion);

		asignar("VAR", "ejecutar", "vueltaNumDocumento('"+numAtencion+"@@"+sFechaIngreso+"');");

		traza("*** Salida - LPReclamosEnLinea - buscarDocumentoCliente ***");
	}
	
	private String generarNumDocumento() throws Exception {
		
		traza("*** Entrada - LPReclamosEnLinea - generarNumDocumento ***");
		DTONumeroSolicitud dtoe = new DTONumeroSolicitud();
		dtoe.setOidPais(this.pais);
		
		//V_INT_RET_04 Se elimina el seteo de Canal, Acceso y Subacceso para que se utilice el mismo contador que en la INT-RET 
		//(recepcionarreclamoscalypso)
		dtoe.setOperacion("REC034");
						
		Vector paramConector = new Vector();
		paramConector.add(dtoe);
		paramConector.add(new MareBusinessID("RECGenerarNumeroDocumento"));
		DruidaConector conector = conectar("ConectorGenerarNumeroDocumentoREC", paramConector);
		DTOString dtoString = (DTOString)conector.objeto("DTOString");

		traza("*** Salida - LPReclamosEnLinea - generarNumDocumento ***");
		return dtoString.getCadena();
		
	}	
	
	private void generarSolicitudes() throws Exception {
		
		traza("*** Entrada - LPReclamosEnLinea - generarSolicitudes ***");

		pagina("salidaGenerica");
		DTOAtencionReclamoREC dtoe = new DTOAtencionReclamoREC();
		traza("numAtencion " + conectorParametroLimpia("numAtencion","",true));
		dtoe.setNumAtencion(new Long(conectorParametroLimpia("numAtencion","",true)));
		dtoe.setNumRecojo(ConstantesREC.RECOJO_RECLAMO_LINEA);
		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);

		traza("idioma");
		dtoe.setOidIdioma(this.idioma);
		traza("pais");
		dtoe.setOidPais(this.pais);
		Vector paramConector = new Vector();
		paramConector.add(dtoe);
		paramConector.add(new MareBusinessID("RECGenerarSolicitudes"));
		// Mejora SiCC 20070534 - dmorello, 12/02/2008
		//traza("antes del ConectorGenerarSolicitudesREC");
		//conectar("ConectorGenerarSolicitudesREC", paramConector);
		asignar("VAR", "cerrarVentana", "false");
		//asignar("VAR", "ejecutar", "vaciaSolicitudes()");
		try {
			traza("antes del ConectorGenerarSolicitudesREC");
			conectar("ConectorGenerarSolicitudesREC", paramConector);
			String casoUso = conectorParametroLimpia("casoUso", "", true);
			if (casoUso.equals("modificar")) {
				asignar("VAR", "ejecutar", "fVolver()");
			} else {
				asignar("VAR", "ejecutar", "vaciaSolicitudes()");
			}
		} catch (Exception e) {
			asignar("VAR", "ejecutarError", "errorGenerarSolicitudes()");
			throw e;
		}
		// Fin Mejora SiCC 20070534 - dmorello, 12/02/2008

		traza("*** Salida - LPReclamosEnLinea - generarSolicitudes ***");
		
	}

	private void bloquear() throws Exception {  
		  traza("*** Entrada - LPReclamosEnLinea - bloquear ***");
		  pagina("salidaGenerica");
		  String oidMotivoBloqueo = conectorParametroLimpia("oidMotivoBloqueo","",true); 
		  traza("*** oidMotivoBloqueo " + oidMotivoBloqueo);
		 
		  DTOAtencionReclamoREC dtoe = new DTOAtencionReclamoREC();
		  dtoe.setNumAtencion(new Long(conectorParametroLimpia("numAtencion","",true)));
		  dtoe.setOidIdioma(this.idioma);
		  dtoe.setOidPais(this.pais);
		  if(!oidMotivoBloqueo.equals("")) {
		   dtoe.setOidMotivoBloqueo(new Long(oidMotivoBloqueo));
		  }  
		  
		  Vector paramConector = new Vector();
		  paramConector.add(dtoe);
		  paramConector.add(new MareBusinessID("RECBloquearReclamoEnLinea"));
		  conectar("ConectorBloquearReclamoEnLinea", paramConector);
		  asignar("VAR", "cerrarVentana", "false");        
				asignar("VAR", "ejecutar", "vaciaSolicitudes()");
		  traza("*** Salida - LPReclamosEnLinea - bloquear ***");  
	 }  

	private void cargaCombo () throws Exception {
		
		traza("*** Entrada - LPReclamosEnLinea - cargaCombo ***");
	
		DTOBelcorp dtoe = new  DTOBelcorp();
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);
		
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elemMotivos = new ComposerViewElement();
		
		elemMotivos.setIDBusiness ("RECObtenerMotivosBloqueo");
		elemMotivos.setDTOE (dtoe); 
						
		listelem.addViewElement(elemMotivos);
				
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());		
		conector.ejecucion();             				
		DruidaConector conConsultar = conector.getConector();     

		asignar("COMBO","cbMotivoBloqueo",conConsultar,"RECObtenerMotivosBloqueo");		


		//	Agregado por HRCS - Fecha 08/03/2007 - Cambio REC-007
		DTOPeriodo dtoE = new  DTOPeriodo();
        dtoE.setPais( UtilidadesSession.getPais(this) );
        dtoE.setMarca( UtilidadesSession.getMarcaPorDefecto(this) );
		dtoE.setCanal( UtilidadesSession.getCanalPorDefecto(this) );
        
		ComposerViewElementList listelem2 = new ComposerViewElementList();
		ComposerViewElement elemPeriodos = new ComposerViewElement();
		elemPeriodos.setIDBusiness ("CRAObtenerPeriodosMayorIgualActual");
		elemPeriodos.setDTOE(dtoE);
		listelem2.addViewElement(elemPeriodos);
				
		ConectorComposerView conector2 = new ConectorComposerView(listelem2, this.getRequest());
		conector2.ejecucion();
		DruidaConector conConsultar2 = conector2.getConector();
		asignar("COMBO","cbPeriodoRec",conConsultar2,"CRAObtenerPeriodosMayorIgualActual");		


		traza("*** Salida - LPReclamosEnLinea - cargaCombo ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
	
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	
	}		

    private BigDecimal calcularTotales(BigDecimal sumaEnvia, BigDecimal sumaDevuelve)throws Exception {
    
        BigDecimal saldo= new BigDecimal(0);
        saldo = sumaEnvia.subtract(sumaDevuelve);
        /*try{
            asignar("LABELC","lblTotalEnviaX", sumaEnvia.toString());
            asignar("LABELC","lblTotalDevuelveX",sumaDevuelve.toString());
            asignar("LABELC","lblSaldoAPagarX",saldo.toString());
        
        }catch(Exception  e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}*/
        return saldo;
    }

    private void cargaModificar()throws Exception {
        traza("*** Entrada - LPReclamosEnLinea - cargaModificar ***"); 

		//	Agregado por HRCS - Fecha 10/03/2007 - Cambio REC-007
		DTOPeriodo dtoE = new  DTOPeriodo();
        dtoE.setPais( UtilidadesSession.getPais(this) );
        dtoE.setMarca( UtilidadesSession.getMarcaPorDefecto(this) );
		dtoE.setCanal( UtilidadesSession.getCanalPorDefecto(this) );
        
		ComposerViewElementList listelem2 = new ComposerViewElementList();
		ComposerViewElement elemPeriodos = new ComposerViewElement();
		elemPeriodos.setIDBusiness ("CRAObtenerPeriodosMayorIgualActual");
		elemPeriodos.setDTOE (dtoE );
		listelem2.addViewElement(elemPeriodos);
				
		ConectorComposerView conector2 = new ConectorComposerView(listelem2, this.getRequest());
		conector2.ejecucion();
		DruidaConector conConsultar2 = conector2.getConector();
		asignar("COMBO","cbPeriodoRec",conConsultar2,"CRAObtenerPeriodosMayorIgualActual");


		traza("------- FILA --------- \n \n"+this.fila); 
      		StringTokenizer st = new StringTokenizer(this.fila, ",");
        	
      		String nombre = "";
      		String apellidos = "";
      		String codCliente = "";
      		String numReclamo = "";
      		String codAtencion = "";
      		String subgerencia = "";
      		String region = "";
      		String seccion = "";
      		String zona = "";
      		String territorio = "";
      		String periodoReferencia = "";
      		String totalEnvia = "";
      		String totalDevuelve = "";
      		String saldoAPagar = "";
      		String estadoCliente = "";
      		String codDocuReferencia = "";
      		String oidNumDocumento = "";
      		String oidCliente = "";
      		String oid = "";
      		String oidPeriodo = "";
        	String moneda = "";
            String canal = "";
      		String acceso = "";
      		String subacceso = "";
      		String oidTerriAdmin = "";
        	String numeroZona = "";
      		String estadoReclamo = "";
            String tokken = "";
            // recibimos solo 1 registro, con los siguientes campos de la lista
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oid =tokken;
                }
                //traza("\n *** FILA oid = "+oid);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    numReclamo = tokken;
                }
      			//traza("\n *** FILA codAtencion = "+numReclamo);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    codCliente = tokken;
      			}
                //traza("\n *** FILA codCliente = "+codCliente);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oidCliente = tokken;
      			}
                //traza("\n *** FILA oidCliente = "+oidCliente);
      		}
      		if (st.countTokens() > 0) {
        		tokken = st.nextToken();
                if(!tokken.equals("-")){
                    nombre = tokken;
      			}
                //traza("\n *** FILA nombre = "+nombre);
      		}
      		if (st.countTokens() > 0) {
        		tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    apellidos = tokken;
      			}
                //traza("\n *** FILA apellidos = "+apellidos);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    subgerencia = tokken;;
      			}
                //traza("\n *** FILA subgerencia= "+subgerencia);
      		}
      		if (st.countTokens() > 0) { 
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    region = tokken;
      			}
                //traza("\n *** FILA region= "+region);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    seccion = tokken;;
      			}
                //traza("\n *** FILA seccion= "+seccion);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    zona = tokken;
      			}
                //traza("\n *** FILA zona= "+zona);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    territorio = tokken;
      			}
                //traza("\n *** FILA territorio = "+territorio);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    estadoCliente = tokken;
      			}
                //traza("\n *** FILA estadoCliente = "+estadoCliente);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    codDocuReferencia = tokken;
                }	
                //traza("\n *** FILA codDocuReferencia = "+codDocuReferencia);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oidNumDocumento = tokken;
      			}
                //traza("\n *** FILA oidNumDocumento = "+oidNumDocumento);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    periodoReferencia = tokken;
                }
      			//traza("\n *** FILA periodoReferencia = "+periodoReferencia);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    totalEnvia = tokken;
                }
      			//traza("\n *** FILA totalEnvia = "+totalEnvia);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    totalDevuelve = tokken;
                }
      			//traza("\n *** FILA totalDevuelve = "+totalDevuelve);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    saldoAPagar = tokken;
                }
      			//traza("\n *** FILA saldoAPagar = "+saldoAPagar);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oidPeriodo = tokken;
                }
      			//traza("\n *** FILA oidPeriodo = "+oidPeriodo);
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    moneda = tokken;
                }
      			//traza("\n *** FILA moneda = "+moneda );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    canal = tokken;
                }
      			//traza("\n *** FILA canal = "+canal );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    acceso = tokken;
                }
      			//traza("\n *** FILA acceso = "+acceso );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    subacceso = tokken;
                }
      			//traza("\n *** FILA subacceso = "+subacceso );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oidTerriAdmin = tokken;
                }
      			//traza("\n *** FILA oidTerriAdmin = "+oidTerriAdmin );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    numeroZona = tokken;
                }
      			//traza("\n *** FILA numeroZona = "+numeroZona );
      		}
            
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    estadoReclamo = tokken;
                }
      			//traza("\n *** FILA estadoReclamo = "+estadoReclamo );
      		}
			if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    codAtencion = tokken;
                }
      			//traza("\n *** FILA codAtencion = "+codAtencion);
      		}

			/** Agregado por HRCS - Fecha 10/03/2007 - Cambio SICC-GCC-REC-007-Periodo de Reclamo_V3 */
			String periodoReclamo = "";
			String codPeriodoReclamo = "";

            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    periodoReclamo = tokken;
                }
      			//traza("\n *** FILA periodoReclamo = "+periodoReclamo );
      		}

            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    codPeriodoReclamo = tokken;
                }
      			//traza("\n *** FILA codPeriodoReclamo = "+codPeriodoReclamo );
      		}

                String datos = canal + "@@" + acceso + "@@" + subacceso + "@@";
				datos += oidCliente + "@@" + oidNumDocumento + "@@" + codDocuReferencia + "@@";
				datos += oidPeriodo + "@@" + oidTerriAdmin + "@@" + codDocuReferencia + "@@" + codCliente + "@@";
				datos += nombre+" "+apellidos + "@@" + numeroZona + "@@" + estadoCliente + "@@" + moneda+ "@@";
				datos += numReclamo+"@@"+estadoReclamo+"@@"+ codAtencion+"@@";
				datos += periodoReclamo + "@@" + codPeriodoReclamo;

				asignarAtributo( "VAR", "hVModificar", "valor", datos);
				asignarAtributo( "VAR", "casoUso", "valor", "modificar");
                //asignar("VAR", "ejecutar", "mostrarReclamo('" + datos + "')");
            //Carga de reclamos Anteriores
        
        if(estadoReclamo.equals(ConstantesREC.ESTADO_RECLAMO_BLOQUEADO)){
            asignarAtributo( "VAR", "hReclamoBloq", "valor", "true");
        }
        
        Vector paramConector = new Vector();
		DTODetalleReclamosREC dtoDR = new DTODetalleReclamosREC();
        dtoDR.setOidReclamo(this.oid);
        dtoDR.setOidIdioma(idioma);
        dtoDR.setOidPais(pais);
        paramConector.add(dtoDR);
		paramConector.add(new MareBusinessID("RECObtenerDetalleModificacion"));
		DruidaConector conector = conectar("ConectorObtenerDetalleModificacionREC", paramConector);
		DTOReclamo dtoReclamo = (DTOReclamo)conector.objeto("DTOReclamo");
        traza("DTOReclamo MODIFICACION "+dtoReclamo);
        ArrayList arrOpera = dtoReclamo.getOperaciones();
        String operacionnes = "";
        String linneas = "";
        if(arrOpera != null && arrOpera.size()>0){
            asignarAtributo( "VAR", "hExisteOperacion", "valor", "true");
            for (int j=0 ;j<arrOpera.size() ;j++ )  {
                DTOOperacionReclamo dtoModOpera = (DTOOperacionReclamo)arrOpera.get(j);
    
                operacionnes += dtoModOpera.getNumSecuencial().toString()+delimColum+ dtoModOpera.getCodigoOperacion();
                operacionnes +=delimColum+dtoModOpera.getCodigoTipoOperacion()+delimColum+dtoModOpera.getNumSecuencial();
                operacionnes +=delimColum+dtoModOpera.getDescripcionCorta()+delimColum+dtoModOpera.getNumDocReferencia();
                operacionnes +=delimColum+dtoModOpera.getOidOperacionReclamo()+delimColum+dtoModOpera.getAutorizacion();
                if(j+1<arrOpera.size()){
                   operacionnes  +=delimLinea;
                }
                
                
                    ArrayList arrLinas=((DTOOperacionReclamo)arrOpera.get(j)).getLineas();
                        if(arrLinas!=null){
                            for (int h=0 ;h<arrLinas.size();h++)  {
                                DTOLineaOperacion dtoModLinea = (DTOLineaOperacion)arrLinas.get(h);
                                if(dtoModLinea.getCodigoVenta()==null){
                                    dtoModLinea.setCodigoVenta("");
                                }                 
                                linneas  += dtoModLinea.getTipoMovimiento()+delimColum+dtoModLinea.getCodigoVenta();
                                linneas  += delimColum+dtoModLinea.getCodProducto()+delimColum+dtoModLinea.getDescProducto();
                                linneas  += delimColum+dtoModLinea.getUnidadesReclamadas()+delimColum+dtoModLinea.getPrecio()+delimColum+dtoModLinea.getDescuento()+delimColum+dtoModLinea.getPrecioContable();
                                linneas  += delimColum+dtoModLinea.getUnidadesDevueltas()+delimColum+dtoModLinea.getImporteCargo();
                                linneas  += delimColum+dtoModLinea.getImporteAbono()+delimColum+dtoModLinea.getOperacion();
                                linneas  += delimColum+dtoModOpera.getNumSecuencial()+delimColum+dtoModLinea.getPosicionReferencia();
                                
                                if(h+1<arrLinas.size()||j+1<arrOpera.size()){
                                    linneas  +=delimLinea;
                                }
                                traza("*** lineas "+linneas);
                            }
                        }                
                if(dtoModOpera.getIndAnulacion().booleanValue()){
                    asignarAtributo( "VAR", "hExisteAnulacion", "valor", "true");
                }  
           
        }
        traza("*** lineass "+linneas);
        traza("*** Operaciones "+operacionnes);
        asignarAtributo( "VAR", "hOidReclamo", "valor", this.oid.toString());
        asignarAtributo( "VAR", "hOperacion", "valor", operacionnes);
        asignarAtributo( "VAR", "hLinea", "valor", linneas);
        asignarAtributo( "VAR", "hTotalEnvia","valor", totalEnvia!=null? totalEnvia:"0");
        asignarAtributo( "VAR", "hTotalDevuelve", "valor", totalDevuelve!=null? totalDevuelve:"0");
        asignarAtributo( "VAR", "hSaldoPagar","valor", saldoAPagar!=null? saldoAPagar:"0");
        traza("*** Salida - LPReclamosEnLinea - cargaModificar ***");
        }

    }

 private Long cargarOidPeriodoActual() throws Exception
    {

        traza("Entra cargarPeriodo()");
        DTOPeriodo dtoperiodo = new DTOPeriodo();
        dtoperiodo.setOidIdioma(idioma);
        dtoperiodo.setPais(pais);
        dtoperiodo.setMarca(UtilidadesSession.getMarcaPorDefecto(this));
        dtoperiodo.setCanal(UtilidadesSession.getCanalPorDefecto(this));
        Vector vector = new Vector();
        vector.add(dtoperiodo);
        vector.add(new MareBusinessID("CRAObtienePeriodoActual"));
        DruidaConector druidaconector = conectar("ConectorObjeto", vector);
        IMareDTO imaredto = (IMareDTO)druidaconector.objeto("DTOSalida");
        DTOPeriodo dtoperiodo1 = (DTOPeriodo)imaredto.getProperty("periodoActual");
        Long oid = dtoperiodo1.getOid();
        traza("periodo actual:" + oid);
        traza("Sale de cargarPeriodo()");
		return oid;

 }



private void cargaConsultar()throws Exception {
        traza("*** Entrada - LPReclamosEnLinea - cargaConsultar ***"); 

		//traza("------- FILA --------- \n \n"+this.fila); 
      		StringTokenizer st = new StringTokenizer(this.fila, ",");
        	
      		String nombre = "";
      		String apellidos = "";
      		String codCliente = "";
      		String codAtencion = "";
      		String subgerencia = "";
      		String region = "";
      		String seccion = "";
      		String zona = "";
      		String territorio = "";
      		String periodoReferencia = "";
      		String totalEnvia = "";
      		String totalDevuelve = "";
      		String saldoAPagar = "";
      		String estadoCliente = "";
      		String codDocuReferencia = "";
      		String oidNumDocumento = "";
      		String oidCliente = "";
      		String oid = "";
      		String oidPeriodo = "";
        	String moneda = "";
            String canal = "";
      		String acceso = "";
      		String subacceso = "";
      		String oidTerriAdmin = "";
        	String numeroZona = "";
      		String estadoReclamo = "";
            String tokken = "";
            // recibimos solo 1 registro, con los siguientes campos de la lista
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oid =tokken;
                }
                //traza("\n *** FILA oid = "+oid);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    codAtencion = tokken;
                }
      			//traza("\n *** FILA codAtencion = "+codAtencion);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    codCliente = tokken;
      			}
                //traza("\n *** FILA codCliente = "+codCliente);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oidCliente = tokken;
      			}
                //traza("\n *** FILA oidCliente = "+oidCliente);
      		}
      		if (st.countTokens() > 0) {
        		tokken = st.nextToken();
                if(!tokken.equals("-")){
                    nombre = tokken;
      			}
                //traza("\n *** FILA nombre = "+nombre);
      		}
      		if (st.countTokens() > 0) {
        		tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    apellidos = tokken;
      			}
                //traza("\n *** FILA apellidos = "+apellidos);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    subgerencia = tokken;;
      			}
                //traza("\n *** FILA subgerencia= "+subgerencia);
      		}
      		if (st.countTokens() > 0) { 
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    region = tokken;
      			}
                //traza("\n *** FILA region= "+region);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    seccion = tokken;;
      			}
                //traza("\n *** FILA seccion= "+seccion);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    zona = tokken;
      			}
               // traza("\n *** FILA zona= "+zona);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    territorio = tokken;
      			}
                //traza("\n *** FILA territorio = "+territorio);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    estadoCliente = tokken;
      			}
                //traza("\n *** FILA estadoCliente = "+estadoCliente);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    codDocuReferencia = tokken;
                }	
                //traza("\n *** FILA codDocuReferencia = "+codDocuReferencia);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oidNumDocumento = tokken;
      			}
               // traza("\n *** FILA oidNumDocumento = "+oidNumDocumento);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    periodoReferencia = tokken;
                }
      			//traza("\n *** FILA periodoReferencia = "+periodoReferencia);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    totalEnvia = tokken;
                }
      			//traza("\n *** FILA totalEnvia = "+totalEnvia);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    totalDevuelve = tokken;
                }
      			//traza("\n *** FILA totalDevuelve = "+totalDevuelve);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    saldoAPagar = tokken;
                }
      		//	traza("\n *** FILA saldoAPagar = "+saldoAPagar);
      		}
      		if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oidPeriodo = tokken;
                }
      			//traza("\n *** FILA oidPeriodo = "+oidPeriodo);
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    moneda = tokken;
                }
      			//traza("\n *** FILA moneda = "+moneda );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    canal = tokken;
                }
      			//traza("\n *** FILA canal = "+canal );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    acceso = tokken;
                }
      			//traza("\n *** FILA acceso = "+acceso );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    subacceso = tokken;
                }
      			//traza("\n *** FILA subacceso = "+subacceso );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    oidTerriAdmin = tokken;
                }
      			//traza("\n *** FILA oidTerriAdmin = "+oidTerriAdmin );
      		}
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    numeroZona = tokken;
                }
      			//traza("\n *** FILA numeroZona = "+numeroZona );
      		}
            
            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    estadoReclamo = tokken;
                }
      			//traza("\n *** FILA estadoReclamo = "+estadoReclamo );
      		}

			/** Agregado por HRCS - Fecha 09/03/2007 - Cambio SICC-GCC-REC-007-Periodo de Reclamo_V3 */
			String numAtencion = "";
			String periodoReclamo = "";
			String codPeriodoReclamo = "";

            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    numAtencion = tokken;
                }
      			//traza("\n *** FILA numAtencion = "+numAtencion );
      		}

            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    periodoReclamo = tokken;
                }
      			//traza("\n *** FILA periodoReclamo = "+periodoReclamo );
      		}

            if (st.countTokens() > 0) {
      			tokken = st.nextToken();
      			if(!tokken.equals("-")){
                    codPeriodoReclamo = tokken;
                }
      			//traza("\n *** FILA codPeriodoReclamo = "+codPeriodoReclamo );
      		}
                String datos = canal + "@@" + acceso + "@@" + subacceso + "@@";
				datos += oidCliente + "@@" + oidNumDocumento + "@@" + codDocuReferencia + "@@";
				datos += oidPeriodo + "@@" + oidTerriAdmin + "@@" + codDocuReferencia + "@@" + codCliente + "@@";
				datos += nombre+" "+apellidos + "@@" + numeroZona + "@@" + estadoCliente + "@@" + moneda + "@@"+ codAtencion+"@@"+estadoReclamo+"@@";
				datos += periodoReclamo + "@@" + codPeriodoReclamo;
				//traza("*** datos datos = "+datos );
				
				asignarAtributo( "VAR", "hVModificar", "valor", datos);
				asignarAtributo( "VAR", "casoUso", "valor", "consultar");
                //asignar("VAR", "ejecutar", "mostrarReclamo('" + datos + "')");
            //Carga de reclamos Anteriores
        
        if(estadoReclamo.equals(ConstantesREC.ESTADO_RECLAMO_BLOQUEADO)){
            asignarAtributo( "VAR", "hReclamoBloq", "valor", "true");
        }
        
        Vector paramConector = new Vector();
		DTODetalleReclamosREC dtoDR = new DTODetalleReclamosREC();
        dtoDR.setOidReclamo(this.oid);
        dtoDR.setOidIdioma(idioma);
        dtoDR.setOidPais(pais);
        paramConector.add(dtoDR);
		paramConector.add(new MareBusinessID("RECObtenerDetalleReclamos"));
		DruidaConector conector = conectar("ConectorObtenerDetalleReclamosREC", paramConector);
		DTOReclamo dtoReclamo = (DTOReclamo)conector.objeto("DTOReclamo");
        //traza("DTOReclamo CONSULTAR "+dtoReclamo);
        ArrayList arrOpera = dtoReclamo.getOperaciones();
        String operacionnes = "";
        String linneas = "";
        if(arrOpera != null && arrOpera.size()>0){
            asignarAtributo( "VAR", "hExisteOperacion", "valor", "true");
            for (int j=0 ;j<arrOpera.size() ;j++ )  {
                DTOOperacionReclamo dtoModOpera = (DTOOperacionReclamo)arrOpera.get(j);
				
                operacionnes += dtoModOpera.getNumSecuencial()+delimColum+ dtoModOpera.getCodigoOperacion();
                operacionnes +=delimColum+dtoModOpera.getCodigoTipoOperacion()+delimColum+dtoModOpera.getNumSecuencial();
                operacionnes +=delimColum+dtoModOpera.getDescripcionCorta()+delimColum+dtoModOpera.getNumDocReferencia();
                operacionnes +=delimColum+dtoModOpera.getOidOperacionReclamo()+delimColum+dtoModOpera.getAutorizacion();
                operacionnes +=delimColum+dtoModOpera.getCodigoResponsablePerdida()+delimColum+dtoModOpera.getDescripcionAsumePerdida(); 
				operacionnes +=delimColum+dtoModOpera.getDescripcionPrecioPerdida()+delimColum+dtoModOpera.getPorcentajePerdida();
				operacionnes +=delimColum+dtoModOpera.getCodigoClienteSeguro()+delimColum+dtoModOpera.getNombreClienteSeguro();
                operacionnes +=delimColum+dtoModOpera.getCodigoArticuloSeguro()+delimColum+dtoModOpera.getDescripcionArticuloSeguro()+delimColum+dtoModOpera.getMontoPerdida();
				operacionnes +=delimColum+dtoModOpera.getCodigoTipoSolicitudPerdida()+delimColum+dtoModOpera.getDescripcionTipoSolicitudPerdida();
				if(j+1<arrOpera.size()){
                   operacionnes  +=delimLinea;
                }
            
                    ArrayList arrLinas=((DTOOperacionReclamo)arrOpera.get(j)).getLineas();
                        if(arrLinas!=null){
                            for (int h=0 ;h<arrLinas.size();h++)  {
                                DTOLineaOperacion dtoModLinea = (DTOLineaOperacion)arrLinas.get(h);
                                if(dtoModLinea.getCodigoVenta()==null){
                                    dtoModLinea.setCodigoVenta("");
                                }                 

                                linneas  += dtoModLinea.getTipoMovimiento()+delimColum+dtoModLinea.getCodigoVenta();
                                linneas  += delimColum+dtoModLinea.getCodProducto()+delimColum+dtoModLinea.getDescProducto();
                                //linneas  += delimColum+dtoModLinea.getUnidadesReclamadas()+delimColum+dtoModLinea.getPrecio();
                                linneas  += delimColum+dtoModLinea.getUnidadesReclamadas()+delimColum+dtoModLinea.getPrecio()+delimColum+dtoModLinea.getDescuento()+delimColum+dtoModLinea.getPrecioContable();
                                linneas  += delimColum+dtoModLinea.getUnidadesDevueltas()+delimColum+dtoModLinea.getImporteCargo();
                                linneas  += delimColum+dtoModLinea.getImporteAbono()+delimColum+dtoModLinea.getOperacion();
								linneas  += delimColum+dtoModOpera.getNumSecuencial()+delimColum+dtoModLinea.getMontoPerdida();
								if(h+1<arrLinas.size()||j+1<arrOpera.size()){
                                    linneas  +=delimLinea;
                                }
                               // traza("*** lineas "+linneas);
                            }
                        }                
        }
        //traza("*** lineass "+linneas);
        //traza("*** Operaciones "+operacionnes);
        asignarAtributo( "VAR", "hOidReclamo", "valor", this.oid.toString());
        asignarAtributo( "VAR", "hOperacion", "valor", operacionnes);
        asignarAtributo( "VAR", "hLinea", "valor", linneas);
        asignarAtributo( "VAR", "hTotalEnvia","valor", totalEnvia!=null? totalEnvia:"0");
        asignarAtributo( "VAR", "hTotalDevuelve", "valor", totalDevuelve!=null? totalDevuelve:"0");
        asignarAtributo( "VAR", "hSaldoPagar","valor", saldoAPagar!=null? saldoAPagar:"0");

		traza("*** Salida - LPReclamosEnLinea - cargaConsultar ***");
        }

    }
}
