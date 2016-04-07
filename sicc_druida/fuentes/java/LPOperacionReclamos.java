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

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;
import es.indra.sicc.dtos.rec.DTOBloqueoTipoOperacionREC;
import es.indra.sicc.dtos.rec.DTOBuscarEnvia;
import es.indra.sicc.dtos.rec.DTOBuscarClientesREC;
import es.indra.sicc.dtos.rec.DTOGeneraOperacionREC;
//import es.indra.sicc.dtos.rec.DTOValidaOperacionREC;
import es.indra.sicc.dtos.rec.DTOLineaOperacionAuxiliarREC;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;
import es.indra.sicc.dtos.rec.DTOLineaOperacion;

import es.indra.sicc.logicanegocio.rec.ConstantesREC; 


import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesFecha;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 


import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import es.indra.sicc.dtos.rec.DTOIndicadoresOperacionREC;


public class LPOperacionReclamos extends LPSICCBase {
         
    private String accion = null;
    private String casoUso = null;

    private String pagina = null;
    
    private String ingresaDevuelve;
    private String ingresaEnvia;
    private String devuelveFisicoFactura;
    private String devuelveFactura;
    private String enviaFactura;
    private String precioEnvia;

    private boolean mostrando = false;
    private String cerrar = "N";

    private String sOidNumDocumento;
    private String sOidCliente;

    private Long oidNumDocumento;
    private Long oidCliente;
    private Long numAtencion; 
    private String numDocumento;


    //agregados ----------------------------------------------------------------
    private String oidOperacion;
    private String oidTipoOperacion;

    private String numeroLinea;

    private String matriz;
    
    private boolean DEBUG = false;
    
    private static int NUM_FILA = 0;    
    private static int NUM_LINEA = 1;
    private static int TIPO_MOVI = 2;
    private static int OID_TIPO_MOVI = 14;
    private static int COD_VENTA = 3;
    private static int COD_PRODUCTO = 4;
    private static int DESC_PRODUCTO = 5;
    private static int UNIDADES_RECLAMADAS = 6;
    private static int MOTIVO_DEVOLUCION = 7;
    private static int OID_MOTIVO_DEVOLUCION = 18;
    private static int PRECIO_PRODUCTO = 8;
    private static int IMPORTE_CARGO = 9;
    private static int IMPORTE_ABONO = 10;
    private static int UNIDADES_DEVUELTAS = 11;
    private static int MONTO_PERDIDA = 12;
    private static int MFCA_OID_CABE = 16;
    private static int DESCUENTO = 19;    
    private static int PRECIO_PERDIDA = 20;        
    private static int OID_PRODUCTO = 17;            
    private static int OID_POSICION = 21;    

    private static String SEPA_CAMPO = "@";
    private static String SEPA_LINEA = "|";    
    
    private long totalUnidadesReclamadas = 0;
    private long totalUnidadesDevuelve = 0;
    private double totalImporteCargo = 0;
    private double totalImporteAbono = 0;
    
    private Long oidMotivoBloqueo;
    private Long oidEstadoOperacion;
    private String tipoBloqueo;			
    
    //private ArrayList posicionesOperacion;

    private Long pais;
    private Long idioma;
    
    private String enviaGeneraDevuelve;
    private String devuelveGeneraEnvia;    

    private String controlProductosDevuelve;
    private String indicadorDevuelveProcesado;
    private String datosListaDevuelve;
    private String indicador2doDevuelve = "";
    private String indicador2doDevuelveProcesado;
    private String recojo;

    public LPOperacionReclamos() {
        super();
    }
          
    public void inicio() throws Exception {
    }
          
    public void ejecucion() throws Exception {
        setTrazaFichero();

        try {


            traza("*** HSH Entrada -  LPOperacionReclamos - ejecucion ***");
            traza("*** HSH LPOperacionReclamos: Entrada ***");
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            this.accion = conectorParametroLimpia("accion","", true);
      		this.pagina = conectorParametroLimpia("pagina", "", true);
            traza("HSH accion=: "+accion+"||pais="+this.pais+"||idioma="+idioma);


            this.oidOperacion = this.conectorParametroLimpia("oidOperacion", "", true);
            this.oidTipoOperacion = this.conectorParametroLimpia("oidTipoOperacion", "", true);
            
           /* if (accion.equals("")) {
              this.mostrarPgAgregarOperacion();
            }*/
            
            if (accion.equals("validarPerdida")) {
              this.validarPerdida();
            }
            
            if (accion.equals("buscarCampanya")) {
              this.buscarCampanya();
            }
            
            if (accion.equals("cambiar campanya") ) {
              this.cambiarCampanya();
            }
            
            if (accion.equals("guardar operacion") ) {
              this.grabarOperacion();
            }
            
            if (accion.equals("obtenerIndicadoresOperacion")) {
              this.obtenerIndicadoresOperacion();
            }
            

            // Temporal, hasta que funcionen las demás páginas
            if(this.accion.equals("")) this.accion = "agregar operacion";

            if(this.accion.equals("agregar operacion")){
                this.mostrarPgAgregarOperacion();
            } else if(this.accion.equals("obtener fecha")){ //ok
                this.obtenerFecha();
                
            } else if(this.accion.equals("buscarProducto")){ //ok
                this.obtenerParametrosBuscarProducto();
                this.buscarProducto();
                
            } else if(this.accion.equals("detalle producto")){
                this.mostrarPgDetalleBuscarProducto();
            } else if(this.accion.equals("comprobar")){ //recarga para añadir más registros si procede 14568
            	this.recogerParametros();
                this.mostrar();
            } else if(this.accion.equals("validarBloqueos")){
                //this.validarBloqueos();
			// vbongiov -- Cambio 20080756 -- 29/04/2009
            } else if(this.accion.equals("validarFaltantes")){
                this.validarFaltantes();
            }

            traza("*** HSH Salida -  LPOperacionReclamos- ejecucion ***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e); 
        }
    }


	// vbongiov -- Cambio 20080756 -- 29/04/2009
  private void validarFaltantes() throws Exception{

		pagina("salidaGenerica");
		this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");

		try { 
			 String oidNumDocumento = conectorParametroLimpia("oidNumDocumento", "", true); 
			 String oidOperacion = conectorParametroLimpia("oidOperacion", "", true); 

			 // Verificacion en la base de datos
			 DTOBuscarEnvia dtoBuscarEnvia = new DTOBuscarEnvia();    
			 dtoBuscarEnvia.setOidNumDocumento(Long.valueOf(oidNumDocumento));
			 dtoBuscarEnvia.setOidOperacion(Long.valueOf(oidOperacion));
             
             traza("dtoBuscarEnvia: " + dtoBuscarEnvia);
            
             MareBusinessID id = new MareBusinessID("RECValidarFaltantes");                
             Vector paramEntrada = new Vector();
         
             paramEntrada.add(dtoBuscarEnvia);
             paramEntrada.add(id);
             traza("*************** Antes de conectar");
             DruidaConector con = conectar("ConectorValidarFaltantes", paramEntrada);             
             traza("*************** Despues de conectar");


             // Verificacion en los registro ya ingresados
             DTOBoolean dtoBoolean = (DTOBoolean)con.objeto("DTOBoolean");   

			 if(dtoBoolean.getValor()){
				asignarAtributo("VAR", "ejecutar", "valor", "mostrarMensaje()");
			 } else {
				asignarAtributo("VAR", "ejecutar", "valor", "buscarCampanya()");
			 }
		 
			 
		} catch(Exception e) {
			traza("Excepcion: " + e);
			asignarAtributo("VAR", "ejecutarError", "valor", "ejecutarErrorValidarFaltantes()");
			throw e;
		}
  }



  /**
   * @author: ssantana, 07/03/2006
   * @throws java.lang.Exception
   */
    private void mostrarPgAgregarOperacion() throws Exception {    



       String sPais = UtilidadesSession.getPais(this).toString();
       String sIdioma = UtilidadesSession.getIdioma(this).toString();
       String sOidNumDocumento = this.conectorParametroLimpia("oidNumDocumento", "", true);
       String sNumDocumento = this.conectorParametroLimpia("numDocumento", "", true);
       String sOidCliente = this.conectorParametroLimpia("oidCliente", "", true);
       String sExisteOperacion = this.conectorParametroLimpia("existeOperacion", "", true);
       String sCadenaOperacionesPerdida = this.conectorParametroLimpia("datosDePerdida", 
                                                                       "", 
                                                                       true);       
       String sOidsAEliminar = this.conectorParametroLimpia("opeAEliminar", 
                                                                       "", 
                                                                       true);       
       traza("c" + sOidsAEliminar);
       String sCtrlProdDevuelve = this.conectorParametroLimpia("controlProductosDevuelve", 
                                                               "", 
                                                               true);

	   String fechaIngreso = this.conectorParametroLimpia("hFechaIngreso", "", true);

       
       this.pagina("contenido_operacion_agregar");
       this.getFormatosValidaciones();
       this.getConfiguracionMenu("LPOperacionReclamos", "agregarOperacion");
       
       this.asignarAtributo("VAR", "oidNumDocumento", "valor", sOidNumDocumento);
       this.asignarAtributo("VAR", "oidNumDocumentoOriginal", "valor", sOidNumDocumento);
       this.asignarAtributo("VAR", "numDocumento", "valor", sNumDocumento);
       this.asignarAtributo("VAR", "numDocumentoOriginal", "valor", sNumDocumento);
       this.asignarAtributo("VAR", "oidCliente", "valor", sOidCliente);
       this.asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString() );
       this.asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString() );
       this.asignarAtributo("VAR", "existeOperacion", "valor", sExisteOperacion );       
       this.asignarAtributo("VAR", "opeAEliminar", "valor", sOidsAEliminar );       
       this.asignarAtributo("VAR", "hFechaIngreso", "valor", fechaIngreso );   
			
       this.asignarAtributo("VAR", 
                            "constantesAsumeCliente", 
                            "valor", 
                            ConstantesREC.ASUME_CLIENTE.toString());
                            
       this.asignarAtributo("VAR", 
                            "constantesPrecioPerdida", 
                            "valor",
                            ConstantesREC.PRECIO_PERDIDA_VENTA.toString());
                            
       this.asignarAtributo("VAR",
                            "controlProductosDevuelve", 
                            "valor",
                            sCtrlProdDevuelve);


	   this.asignarAtributo("VAR", "PRECIO_ENVIA_FACTURA", "valor", ConstantesREC.PRECIO_ENVIA_FACTURA.toString()); 
	   this.asignarAtributo("VAR", "PRECIO_ENVIA_CATALOGO", "valor", ConstantesREC.PRECIO_ENVIA_CATALOGO.toString()); 
		
                            
       if (sCadenaOperacionesPerdida != null && !sCadenaOperacionesPerdida.equals("")) {
          RecordSet r = this.parseaCadenaPerdida(sCadenaOperacionesPerdida);
          traza("R: " + r);
          if (r != null && !r.esVacio()) {
             DruidaConector con = UtilidadesBelcorp.generarConector("rowset", 
                                                                    r, 
                                                                    r.getColumnIdentifiers());
             traza("Asigna Matriz de Operaciones");
             this.asignar("MATRIZJS", "lstOperacionesPerdida", con, "rowset");
             traza("Termino de asignar Matriz de Operaciones");
          }
       }
       this.asignarAtributo("CAPA", "capa1", "visibilidad", "hidden");
       this.cargarCombo();
       this.asignarSecuencial();
    }

    
    
  /**
   * @author: ssantana, 21/03/2006
   * @throws java.lang.Exception
   * @return 
   * @param sCadenaEntrada
   */
  private RecordSet parseaCadenaPerdida(String sCadenaEntrada) 
        throws Exception {
      /*  @@ - Separador de Lineas
          || - Separador de Cols */
          
      /*RecordSet r = new RecordSet();
      Vector vCols = new Vector();
      Vector vRow = null;
      traza("sCadenaEntrada: " + sCadenaEntrada);
      
      int OID_OPERACION = 0;
      int OID_CLIENTE = 1;
      int OID_ASUME_PERDIDA = 2;
      int PRECIO_CALCULO = 3;
      int PORCENTAJE_RECARGO = 4;
      int OID_PROD_SEGURO = 5;
      int OID_CLIENTE_SEGURO = 6;
      int IMPORTE_SEGURO = 7;

      String[] sLineas = this.construirLineas(sCadenaEntrada, "@@");
      String espacio = " ";
      String sBuffer = null;
      int cantLineas = sLineas.length;*/
      
      /* Armo RecordSet  */ 
      /*vCols.add("OID_OPERACION");
      vCols.add("OID_CLIENTE");
      vCols.add("OID_ASUME_PERDIDA");
      vCols.add("PRECIO_CALCULO");
      vCols.add("PORCENTAJE_RECARGO");
      vCols.add("OID_PROD_SEGURO");
      vCols.add("OID_CLIENTE_SEGURO");
      vCols.add("IMPORTE_SEGURO");
      r.setColumnIdentifiers(vCols);*/
      
      /* Pueblo el RecordSet */ 
      /*for (int i = 0; i < cantLineas; i++) {
         String[] sCampos = this.construirLineas(sLineas[i], "||");
         vRow = new Vector();
         
         sBuffer = sCampos[OID_OPERACION];
         vRow = this.agregaCampoOperaciones(vRow, sBuffer);

         sBuffer = sCampos[OID_CLIENTE];
         vRow = this.agregaCampoOperaciones(vRow, sBuffer);
         
         sBuffer = sCampos[OID_ASUME_PERDIDA];
         vRow = this.agregaCampoOperaciones(vRow, sBuffer);
         
         sBuffer = sCampos[PRECIO_CALCULO];
         vRow = this.agregaCampoOperaciones(vRow, sBuffer);
         
         sBuffer = sCampos[PORCENTAJE_RECARGO];
         vRow = this.agregaCampoOperaciones(vRow, sBuffer);
         
         sBuffer = sCampos[OID_PROD_SEGURO];
         vRow = this.agregaCampoOperaciones(vRow, sBuffer);
         
         sBuffer = sCampos[OID_CLIENTE_SEGURO];
         vRow = this.agregaCampoOperaciones(vRow, sBuffer);
         
         sBuffer = sCampos[IMPORTE_SEGURO];
         vRow = this.agregaCampoOperaciones(vRow, sBuffer);
         
         r.addRow(vRow);
      }
      traza("RecordSet Operacion: " + r);*/
        Node nodeDoc = null;        
        Node nodoRow = null;
        Node nodoCampo = null;
        NodeList nodeList = null;
        NodeList nodeListCampos = null;
        DocumentBuilder docBuilder = null;
        RecordSet r = this.preparaRecordSet();
        String sValorCampo = null;
        Vector vFila = null;
        
        traza("sCadenaEntrada: " + sCadenaEntrada);        
      
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = 
                new ByteArrayInputStream(sCadenaEntrada.getBytes());
        
        nodeDoc = docBuilder.parse(inputStream).getFirstChild();
        traza("nodeDoc: " + nodeDoc.getNodeName());
        nodeList = nodeDoc.getOwnerDocument().getElementsByTagName("ROW");
        
        long cantElems = nodeList.getLength();
        traza("cantElems: " + cantElems);
        /* Recorro tags <ROW> */        
        for (int i=0; i<cantElems; i++) {
            vFila = new Vector(); 
            nodoRow = nodeList.item(i);
            nodeListCampos = nodoRow.getChildNodes();
            long cantCampos = nodeListCampos.getLength();
            /* Recorro tags <CAMPO> */
            for (int j=0; j<cantCampos; j++) {
                nodoCampo = nodeListCampos.item(j);
                sValorCampo = this.obtenerValorCampo(nodoCampo);
                vFila.add(sValorCampo);
            }
            r.addRow(vFila);
        }
     
      return r;
  }
  
  
  private RecordSet preparaRecordSet() throws Exception { 
      RecordSet r = new RecordSet();
      Vector vCols = new Vector();
      /* Armo RecordSet  */ 
      vCols.add("OID_OPERACION");
      vCols.add("OID_CLIENTE");
      vCols.add("OID_ASUME_PERDIDA");
      vCols.add("PRECIO_CALCULO");
      vCols.add("PORCENTAJE_RECARGO");
      vCols.add("OID_PROD_SEGURO");
      vCols.add("OID_CLIENTE_SEGURO");
      vCols.add("IMPORTE_SEGURO");
      r.setColumnIdentifiers(vCols);
      
      return r;
  }
  
  
  /**
   * @author: ssantana, 19/03/2006
   * @throws java.lang.Exception
   * @return Vector
   * @param String sValor
   * @param Vector vector
   */
  private Vector agregaCampoOperaciones(Vector vector, String sValor) 
        throws Exception {
        
     String espacio = " ";
     if (sValor.equals(espacio)) { 
        vector.add(null);
     } else {
        vector.add(sValor);
     }
     return vector;
  }


  /**
   * @author: ssantana, 17/03/2006
   * @throws java.lang.Exception
   */
    private void buscarCampanya() throws Exception {
       traza("LPOperacionReclamos.buscarCampanya(): Entrada");

   	   String fechaIngreso = this.conectorParametroLimpia("hFechaIngreso", "", true);      

	   this.pagina("salidaGenerica");
       this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");

       DruidaConector con = null;
       DTOSalida dtoSalida = null;
       DTOOID dtoOid = new DTOOID();
       MareBusinessID bussId = new MareBusinessID("RECObtenerCampania");
       Vector vParams = new Vector();
       RecordSet r = null;
       String sOidTipoOperacion = 
              this.conectorParametroLimpia("oidTipoOperacion", "", true);
   	   
	   Long flag = Long.valueOf("0");
	   if (fechaIngreso != null && !fechaIngreso.equals("")) {

		   long lFechaIngreso = (new Long(fechaIngreso)).longValue();
		   
		   dtoOid.setOid(Long.valueOf(sOidTipoOperacion));
		   dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
		   dtoOid.setOidPais(UtilidadesSession.getPais(this));
		   
		   vParams.add(dtoOid);
		   vParams.add(bussId);
		   
		   con = this.conectar("ConectorObtenerCampaniaREC", vParams);
		   
		   dtoSalida = (DTOSalida) con.objeto("DTOSalida");
		   r = dtoSalida.getResultado();
		   
		   Long nDias = Long.valueOf( r.getValueAt(0,1).toString() );
		   //java.util.Date dateNDias = UtilidadesFecha.addDays(new java.util.Date(), nDias.intValue());
		   int SECOND = 1000;
		   int MINUTE = 60 * SECOND;
		   int HOUR = 60 * MINUTE;
		   long DAY = 24 * HOUR;
		   long dias = 0;
		   if(nDias.intValue() > 0){
				dias = DAY * nDias.intValue();
		   }
		   traza(System.currentTimeMillis()+" - "+lFechaIngreso+" > "+ dias );
		   if( (System.currentTimeMillis() - lFechaIngreso) > dias){
				flag = Long.valueOf("1");
		   }
	   }

       this.asignarAtributo("VAR", 
                            "ejecutar", 
                            "valor", 
                            "cambiarCampanya('"+flag+"')");
                            
    }
    
  /**
   * @author: ssantana, 10/03/2006
   * @throws java.lang.Exception
   */
    private void cambiarCampanya() throws Exception {
       traza("LPOperacionReclamo.cambiarCampanya():Entrada");
       Vector vParams = new Vector();
       DTOOID dtoOid = null;
       DruidaConector con = null;
       DTOSalida dtoSalida = null;
       RecordSet r = null;
       MareBusinessID bussId = new MareBusinessID("RECObtenerFechaCampania");
       this.pagina("contenido_operacion_detalle_agregar");
       
       String sTipoOperacion = 
              this.conectorParametroLimpia("tipoOperacion", "", true);
       String sOidNumDoc =
              this.conectorParametroLimpia("oidNumDoc", "", true);
       String sOidCliente = 
              this.conectorParametroLimpia("oidCliente", "", true);
      
       /* Obtengo Fecha Campaña REC */ 
       dtoOid = new DTOOID();
       dtoOid.setOid(Long.valueOf(sTipoOperacion));
       dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
       dtoOid.setOidPais(UtilidadesSession.getPais(this));
       
       vParams.add(dtoOid);
       vParams.add(bussId);
       
       con = this.conectar("ConectorObtenerFechaCampaniaREC", vParams);
       dtoSalida = (DTOSalida) con.objeto("DTOFecha");
       r = dtoSalida.getResultado();
       
       java.util.Date dateFechaFiltro = (java.util.Date) r.getValueAt(0,0);
       traza("FechaFiltro: " + dateFechaFiltro.toString());
       
       SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
       String sDate = simpleDate.format(dateFechaFiltro);
       
       String sPais = UtilidadesSession.getPais(this).toString();
       String sIdioma = UtilidadesSession.getIdioma(this).toString();
       
       this.asignarAtributo("VAR", "oidCliente", "valor", sOidCliente);
       this.asignarAtributo("VAR", "oidNumDocumento", "valor", sOidNumDoc);
       this.asignarAtributo("VAR", "fechaFiltro", "valor", sDate);
       this.asignarAtributo("VAR", "pais", "valor", sPais);
       this.asignarAtributo("VAR", "idioma", "valor", sIdioma);
    }
    
    private void obtenerFecha() throws Exception {
            // Crear DTOE de tipo DTOOID con el oid recibido
            // Invocar conector ConectorObtenerFechaCampañaREC enviando el DTOE creado
            // Crear IDBusiness="RECObtenerFechaCampaña"
            // Recuperar DTO obtenido
            traza("*** HSH Entrada -  LPOperacionReclamos- obtenerFecha ***");
        	pagina("contenido_operacion_detalle_agregar");    

            getConfiguracionMenu("LPOperacionReclamos", "buscarFecha");

            DTOOID dtoOid = new DTOOID();

            dtoOid.setOid(new Long(conectorParametroLimpia("oidTipoOperacion","", true)));
            dtoOid.setOidPais(this.pais);
            dtoOid.setOidIdioma(this.idioma);

            MareBusinessID idBusiness = new MareBusinessID("RECObtenerFechaCampania");
    
            // Parametros de entrada del conector                     
            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoOid);
            paramEntrada.add(idBusiness);
            // Se invoca al conector 
            traza("HSH obtenerFecha --> Antes de conectar");
            DruidaConector conector = conectar("ConectorObtenerFechaCampaniaREC", paramEntrada);
            traza("HSH obtenerFecha--> Despues de conectar");
            DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOFecha");

            // Asignamos los valores del DTOSalida a la página
            java.util.Date fechaCamp = (java.util.Date)dtoSalida.getResultado().getValueAt(0, 0);
            traza("HSH obtenerFecha-->fechaCamp="+fechaCamp);    
            // Asignar valor obtenido en paso anterior al campo fechaFiltro de PgDatosDocumento
            asignar("VAR", "fechaFiltro", obtieneCadenaFecha(fechaCamp));
            asignar("VAR", "oidCliente", conectorParametroLimpia("oidCliente","", true));
            asignar("VAR", "oidNumDocumento", conectorParametroLimpia("oidNumDocumento","", true));
            // BELC300013959

            traza("*** HSH Salida -  LPOperacionReclamos- obtenerFecha***");
    }

    // Viene de PgAgregarOperacion.onClickBuscarProducto
    // Llama a PgProductoReclamos
    private void buscarProducto() throws Exception {
        traza("*** HSH Entrada -  LPOperacionReclamos- buscarProducto ***");
        
        //pagina("contenido_producto_no_buscar");

// **********************************
// **********************************
/*
        DTOIndicadoresOperacionREC dto = new DTOIndicadoresOperacionREC();
        try {
            dto.setOidOperacion(oidOperacion != null ? Long.valueOf(oidOperacion) : null);
        } catch (NumberFormatException nfe){}
        try {
            dto.setOidTipoOperacion(oidTipoOperacion != null ? Long.valueOf(oidTipoOperacion) : null);
        } catch (NumberFormatException nfe){}

        MareBusinessID id = new MareBusinessID("RECObtenerIndicadoresOperacion");
        Vector params = new Vector();
        params.add(dto);
        params.add(id);

        DruidaConector con = this.conectar("ConectorObtenerIndicadoresOperacionREC", params);
        dto = (DTOIndicadoresOperacionREC)con.objeto("DTOIndicadoresOperacionREC");
        
        ingresaDevuelve = dto.getIngresaDevuelve() != null && 
            dto.getIngresaDevuelve().booleanValue() ? "1" : "0";
        ingresaEnvia = dto.getIngresaEnvia() != null && 
            dto.getIngresaEnvia().booleanValue() ? "1" : "0";
        devuelveFisicoFactura = dto.getDevuelveFisicoFactura() != null && 
            dto.getDevuelveFisicoFactura().booleanValue() ? "1" : "0";
        devuelveFactura = dto.getDevuelveFactura() != null && 
            dto.getDevuelveFactura().booleanValue() ? "1" : "0";
        enviaFactura = dto.getEnviaFactura() != null && 
            dto.getEnviaFactura().booleanValue() ? "1" : "0;";
        enviaGeneraDevuelve = dto.getEnviaGeneraDevuelve() != null && 
            dto.getEnviaGeneraDevuelve().booleanValue() ? "1" : "0";
        devuelveGeneraEnvia = dto.getDevuelveGeneraEnvia() != null && 
            dto.getDevuelveGeneraEnvia().booleanValue() ? "1" : "0";
*/
// **********************************
// **********************************

        this.mostrarPGBuscarProducto();

        this.getConfiguracionMenu("LPOperacionReclamos", "buscarProducto");

        traza("*** HSH Salida -  LPOperacionReclamos- buscarProducto ***");

/*
		//----------------------------------------------
		this.cargarComboMotivo();
		//----------------------------------------------
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
        // Crear DTOE de tipo DTOValidaOperacionREC con el oidOperacion y oidTipoOperacion recibidos (resto de campos a NULL):
        // DTOE.oidOperacion = oidOperacion-->cbCodigoOperacion
        // DTOE.oidTipoOperacion = oidTipoOperacion-->cbCodigoTipoOperacion 
        DTOValidaOperacionREC dtoValidaOperacion = new DTOValidaOperacionREC();
        String codigoOperacion = conectorParametroLimpia("oidOperacion","", true);
        String codigoTipoOperacion = conectorParametroLimpia("oidTipoOperacion","", true);
        String oidCliente = conectorParametroLimpia("oidCliente","", true);
        String oidNumDocumento = conectorParametroLimpia("oidNumDocumento","", true);
        
        dtoValidaOperacion.setOidOperacion(new Long(codigoOperacion));
        dtoValidaOperacion.setOidTipoOperacion(new Long(codigoTipoOperacion));
        dtoValidaOperacion.setOidPais(this.pais);
        dtoValidaOperacion.setOidIdioma(this.idioma);

        MareBusinessID idBusiness = new MareBusinessID("RECObtenerValidaOperacion");

        // Parametros de entrada del conector                     
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoValidaOperacion);
        paramEntrada.add(idBusiness);

        // Se invoca al conector 
        DruidaConector conector = conectar("ConectorObtenerValidaOperacionREC", paramEntrada);
		es.indra.sicc.dtos.rec.DTOValidaOperacionREC dtoValida = (es.indra.sicc.dtos.rec.DTOValidaOperacionREC)conector.objeto("DTOSalida");
        this.ingresaDevuelve = booleanToStr(dtoValida.getIngresaDevuelve());
        this.ingresaEnvia = booleanToStr(dtoValida.getIngresaEnvia());
        this.devuelveFisicoFactura = booleanToStr(dtoValida.getDevuelveFisicoFactura());
        this.devuelveFactura = booleanToStr(dtoValida.getDevuelveFactura());
        this.enviaFactura = booleanToStr(dtoValida.getEnviaFactura());

		getConfiguracionMenu("LPOperacionReclamos", "buscarProducto");
		this.pagina = "0";
		this.mostrar();
        traza("*** HSH Salida -  LPOperacionReclamos- buscarProducto ***");
*/        
    }

    /**
     * @author Marcelo J. Maidana
     * @date 11/03/2006
	 *
	 * Modificado por HRCS - Fecha 16/02/2005 - Incidencia: DBLG700000293
	 * Se agregaron trazas para el debug 
     */
    private void mostrarPGBuscarProducto() throws Exception {
    
        if (this.ingresaDevuelve.equals("1") && this.ingresaEnvia.equals("1")){
            if (indicadorDevuelveProcesado == null || !indicadorDevuelveProcesado.equals("1")){
				traza("*** mostrarPGBuscarProducto() -  ID:1 y IE:1 y (IDP=null o IDP!=1) ***");
                this.comprobarDevuelveFisico();
            } else if(this.indicador2doDevuelve.equals("1")&&!this.indicador2doDevuelveProcesado.equals("1")) {
				traza("*** mostrarPGBuscarProducto() -  ID:1 y IE:1 y (I2D=1 y I2D!=1) ***");
                this.comprobarDevuelveFisico();  
            } else {
				traza("*** mostrarPGBuscarProducto() -  ID:1 y IE:1 y ninguno ***");
                this.comprobarIngresaEnvia();
            }
        } else if (this.ingresaDevuelve.equals("1")){
             if (indicadorDevuelveProcesado == null || !indicadorDevuelveProcesado.equals("1")){ 
				traza("*** mostrarPGBuscarProducto() -  ID:1 y (IDP=null o IDP!=1) ***");
				this.comprobarDevuelveFisico();          
             } else if(this.indicador2doDevuelve.equals("1")&&!this.indicador2doDevuelveProcesado.equals("1")) { 
				traza("*** mostrarPGBuscarProducto() -  ID:1 y (I2D=1 y I2D!=1) ***");
                this.comprobarDevuelveFisico();   
             }
        } else if (this.ingresaEnvia.equals("1")){
			traza("*** mostrarPGBuscarProducto() -  IE:1 ***");
            this.comprobarIngresaEnvia();
        }
        //this.cargarComboMotivo();
    }



/*
	private void asignarHiddenBuscarProducto() throws Exception {
        asignarIdiomaPais();
        // Asignar valor obtenido en paso anterior a los campos de PgProductoReclamos
        asignarAtributo("VAR", "ingresaDevuelve", "valor", this.ingresaDevuelve);
        asignarAtributo("VAR", "ingresaEnvia", "valor", this.ingresaEnvia);
        asignarAtributo("VAR", "devuelveFisicoFactura", "valor", this.devuelveFisicoFactura);
        asignarAtributo("VAR", "devuelveFactura", "valor", this.devuelveFactura);
        asignarAtributo("VAR", "enviaFactura", "valor", this.enviaFactura);
        asignar("VAR", "oidOperacion", conectorParametroLimpia("oidOperacion","", true));
        asignar("VAR", "oidCliente", conectorParametroLimpia("oidCliente","", true));
        asignar("VAR", "oidNumDocumento", conectorParametroLimpia("oidNumDocumento","", true));
        asignar("VAR", "arrayList", conectorParametroLimpia("arrayList","", true));
		asignar("VAR", "numeroLinea", conectorParametroLimpia("numeroLinea","", true));
        asignar("VAR", "pagina", this.pagina);

        String cerrar = "N";
		//si estamos mostrando 1 o 3 es la última de 'devuelve', si 'ingresaEnvia' false es la última recarga
		if((this.pagina.equals("1") || this.pagina.equals("3")) && this.ingresaEnvia.equals("0"))
			cerrar ="S";

		//si estamos mostrando 4 es la última recarga
		if(this.pagina.equals("4"))
			cerrar ="S";
		asignar("VAR", "cerrar", cerrar);

		//si estamos mostrando 0 se cierra la ventana en el onload()
		if (this.pagina.equals("0"))
			asignarAtributo("PAGINA", "contenido_producto_no_buscar", "onload", "window.close();");

        traza("*** HSH Salida -  asignarHiddenBuscarProducto- buscarProducto ***: " + this.ingresaDevuelve + "-" + this.ingresaEnvia + "-" + this.devuelveFisicoFactura + "-" + this.devuelveFactura + "-" + this.enviaFactura );
        traza("*** HSH Salida -  asignarHiddenBuscarProducto- buscarProducto ***: " + conectorParametroLimpia("arrayList","", true) + "-" + this.pagina + "-" + cerrar);
	}
*/



    private void recogerParametros() throws Exception {
		traza("*** HSH Entrada -  LPOperacionReclamos- recogerParametros ***");
        pagina("contenido_producto_no_buscar");    
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);

		String codigoOperacion = conectorParametroLimpia("oidOperacion","", true);
        String codigoTipoOperacion = conectorParametroLimpia("oidTipoOperacion","", true);
        this.ingresaDevuelve = conectorParametroLimpia("ingresaDevuelve","", true);
        this.ingresaEnvia = conectorParametroLimpia("ingresaEnvia","", true);
        this.devuelveFisicoFactura = conectorParametroLimpia("devuelveFisicoFactura","", true);
        this.devuelveFactura = conectorParametroLimpia("devuelveFactura","", true);
        this.enviaFactura = conectorParametroLimpia("enviaFactura","", true);
		this.matriz = conectorParametroLimpia("matriz","", true);

		traza("Matriz "+this.matriz);
		getConfiguracionMenu("LPOperacionReclamos", "buscarProducto");
        traza("*** HSH Salida -  LPOperacionReclamos- recogerParametros ***");
	}

    private void mostrar() throws Exception {
		traza("*** HSH Entrada -  LPOperacionReclamos- mostrar ***");
 		//Añadir a la variable arrayList el array recuperado de la PgProductoReclamos 
		comprobarDevuelveFisico();
		comprobarIngresaEnvia();
		cargarComboMotivo();
		//Volvemos a la PgAgregarOperacion asignando a la lstResultados el valor de la variable arrayList (que hemos procesado)
		traza("*** HSH Salida -  LPOperacionReclamos- mostrar ***");
    }

    /**
     * @author Marcelo J. Maidana
     * @date 11/03/2006
     * Funcionalidad modificada en rediseño.
     */
    private void comprobarDevuelveFactura() throws Exception {
    
        traza("*** HSH Entrada -  LPOperacionReclamos- comprobarDevuelveFactura ***");
        traza("this.devuelveFactura: " + devuelveFactura);
		
				if (this.devuelveFactura.equals("1")) { 
                
                    traza("devuelveFactura == true");
                
                    //Mostrar la Pantalla PGBuscarProductoDevuelve con los atributos de la Pagina 
                    //indBuscar = false, 
                    //oidNumDocumento = oidNumDocumento (recibido desde la Pagina PgAgregarOperacion), 
                    //oidCliente = oidCliente (recibido desde la Pagina PgAgregarOperacion) y 
                    //numeroLinea = ultimo numero secuencial de linea insertada (recibido desde la Pagina PgAgregarOperacion) 
                    //Ocultar la capa que presenta los "Criterios de búsqueda" 
                    this.asignarAtributo("VAR", "indBuscar", "valor", "0");
                    this.asignarAtributo("VAR", "visibilidadPGBuscarProductoDevuelveContenido", "valor", "0");
                    this.asignarAtributo("VAR", "devuelveFisicoFactura", "valor", "1");

				} else {
                
                    traza("devuelveFactura == false");
                
                    //Mostrar la Pantalla PGBuscarProductoDevuelve con los atributos de la Pagina 
                    //indBuscar = true, 
                    //oidNumDocumento = oidNumDocumento (recibido desde la Pagina PgAgregarOperacion), 
                    //oidCliente = oidCliente (recibido desde la Pagina PgAgregarOperacion) y 
                    //numeroLinea = ultimo numero secuencial de linea insertada (recibido desde la Pagina PgAgregarOperacion) 
                    this.asignarAtributo("VAR", "devuelveFisicoFactura", "valor", "1");
					this.asignarAtributo("VAR", "indBuscar", "valor", "1");
                }

        traza("*** HSH Salida -  LPOperacionReclamos- comprobarDevuelveFactura ***");
        
    }

    /**
     * @author Marcelo J. Maidana
     * @date 11/03/2006
     * Recupera los valores recibidos por parámetro del caso de uso 'Agregar operación'
     * para el caso de uso 'Buscar producto'.
     */
    private void obtenerParametrosBuscarProducto() throws Exception {
        traza("LPOperacionReclamos.obtenerParametrosBuscarProducto() - Entrada");
        
        this.indicador2doDevuelve = this.conectorParametroLimpia("ind2doDevuelve", "", true);    
        this.indicador2doDevuelveProcesado = this.conectorParametroLimpia("ind2doDevuelveProcesado", "", true);
        this.indicadorDevuelveProcesado = this.conectorParametroLimpia("indicadorDevuelveProcesado", "", true);
        this.datosListaDevuelve = this.conectorParametroLimpia("datosListaDevuelve", "", true);
        
        
        oidOperacion = this.conectorParametroLimpia("oidOperacion", "", true);
        oidTipoOperacion = this.conectorParametroLimpia("oidTipoOperacion", "", true);
        numeroLinea = this.conectorParametroLimpia("numeroLinea", "", true); //Ultimo numero secuencial de linea insertada
        sOidNumDocumento = this.conectorParametroLimpia("oidNumDocumento", "", true);
        sOidCliente = this.conectorParametroLimpia("oidCliente", "", true);
        this.oidOperacion = this.conectorParametroLimpia("oidOperacion", "", true);
        this.oidTipoOperacion = this.conectorParametroLimpia("oidTipoOperacion", "", true);
        this.controlProductosDevuelve = this.conectorParametroLimpia("controlProductosDevuelve", "", true);

        traza("controlProductosDevuelve: " + controlProductosDevuelve);

        //Se obtienen los indicadores operacion
        ingresaDevuelve = this.conectorParametroLimpia("ingresaDevuelve", "", true);
        ingresaEnvia = this.conectorParametroLimpia("ingresaEnvia", "", true);
        devuelveFisicoFactura = this.conectorParametroLimpia("devuelveFisicoFactura", "", true);
        devuelveFactura = this.conectorParametroLimpia("devuelveFactura", "", true);
        enviaFactura = this.conectorParametroLimpia("enviaFactura", "", true);
        enviaGeneraDevuelve	= this.conectorParametroLimpia("enviaGeneraDevuelve", "", true);
        devuelveGeneraEnvia	= this.conectorParametroLimpia("devuelveGeneraEnvia", "", true);
		this.precioEnvia = this.conectorParametroLimpia("precioEnvia", "", true);
		this.matriz = this.conectorParametroLimpia("matriz", "", true);
		this.recojo = this.conectorParametroLimpia("recojo", "", true);
        traza("Parametros obtenidos: ");

        traza("indicadorDevuelveProcesado: " + indicadorDevuelveProcesado);
        
        traza("oidOperacion: " + oidOperacion);
        traza("oidTipoOperacion: " + oidTipoOperacion);
        traza("numeroLinea: " + numeroLinea);
        traza("sOidNumDocumento: " + sOidNumDocumento);
        traza("sOidCliente: " + sOidCliente);
        traza("oidOperacion: " + oidOperacion);
        traza("oidTipoOperacion: " + oidTipoOperacion);
        traza(" ");
        traza("... y los indicadores de operacion son los siguientes: ");
        

        if (DEBUG){
            sOidNumDocumento = "1440";
            sOidCliente = "1";
            //ingresaEnvia = "1";
            //enviaFactura = "1";
            ingresaDevuelve = "1";
            devuelveFisicoFactura = "1";
            devuelveFactura = "1";
        }

        traza("ingresaDevuelve: " + ingresaDevuelve);
        traza("ingresaEnvia: " + ingresaEnvia);
        traza("devuelveFisicoFactura: " + devuelveFisicoFactura);
        traza("devuelveFactura: " + devuelveFactura);
        traza("enviaFactura: " + enviaFactura);
        traza("enviaGeneraDevuelve: " + enviaGeneraDevuelve);
        traza("devuelveGeneraEnvia: " + devuelveGeneraEnvia);
		traza("precioEnvia " + precioEnvia);
		traza("Matriz " + this.matriz);
		traza("recojo " + this.recojo);
        try {
            oidNumDocumento = sOidNumDocumento != null ? Long.valueOf(sOidNumDocumento) : null;
        } catch (NumberFormatException nfe){}
        
        try {
            oidCliente = sOidCliente != null ? Long.valueOf(sOidCliente) : null;
        } catch (NumberFormatException nfe){}
    
        traza("LPOperacionReclamos.obtenerParametrosBuscarProducto() - Salida");
    }

    /**
     * @author Marcelo J. Maidana
     * @date 13/03/2006
     * Modificación de funcionalidad por rediseño.
     */

    private void comprobarIngresaEnvia() throws Exception {
		traza("*** HSH Entrada -  LPOperacionReclamos- comprobarIngresaEnvia ***");

        if (this.ingresaEnvia != null && this.ingresaEnvia.equals("1")){
        
            traza("ingresaEnvia es true");
            traza("Matriz "+this.matriz);
			if(this.matriz.equals("I")){
	            traza("PREMIO");
			}
			this.pagina("contenido_buscar_producto_envia");
			
            this.getFormatosValidaciones();
            this.asignarAtributo("VAR", "oidNumDocumento", "valor", oidNumDocumento != null ? oidNumDocumento.toString() : "");
            this.asignarAtributo("VAR", "oidCliente", "valor", oidCliente != null ? oidCliente.toString() : "");
            this.asignarAtributo("VAR", "oidOperacion", "valor", oidOperacion != null ? oidOperacion : "");
            this.asignarAtributo("VAR", "numeroLinea", "valor", numeroLinea != null ? numeroLinea : "");
            this.asignarAtributo("VAR", "tipoMovimiento", "valor", ConstantesREC.MOVIMIENTO_ENVIA);
            this.asignarAtributo("VAR", "oidTipoMovimiento", "valor", ConstantesREC.TIPO_MOVIMIENTO_ENVIA.toString());
            this.asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
            this.asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
            this.asignarAtributo("VAR", "devuelveFactura", "valor", devuelveFactura);
            this.asignarAtributo("VAR", "enviaFactura", "valor", this.enviaFactura);
			this.asignarAtributo("VAR", "datosListaDevuelve", "valor", datosListaDevuelve);
            this.asignarAtributo("VAR", "indicadorDevuelveProcesado", "valor", indicadorDevuelveProcesado);
			this.asignarAtributo("VAR", "matriz", "valor", this.matriz);
	        
			traza("ENVIA EN FACTURA ????? ---->"+ this.enviaFactura);
            if (this.enviaFactura != null && this.enviaFactura.equals("1")){
            
                traza("enviaFactura es true");
            
                this.asignarAtributo("VAR", "indBuscar", "valor", "0");
                //this.asignarAtributo("VAR", "visibilidadPGBuscarProductoEnviaContenido", "valor", "0");
            } else {
            
                traza("enviaFactura es false");
            
                this.asignarAtributo("VAR", "indBuscar", "valor", "1");
            }
        }

        traza("*** HSH Salida -  LPOperacionReclamos- comprobarIngresaEnvia ***");

/*
		if (!mostrando) {
			if (this.ingresaEnvia.equals("1")) { 
				if (this.enviaFactura.equals("1")) { 
					//- Llamar a buscarEnvia() con parametros recibidos oidNumDocumento , oidCliente , oidOperacion (oid del valor seleccionado en cbCodigoOperacion de pantalla llamante) para cargar la lista 
					//- Mostrar la ventana PgProductoReclamos solo aparecerán visibles los campos lstEnvia , su botón asociado aceptarEnvia 
					//- asignar a la variable: - tipoMovimiento = ConstantesRec.MOVIMIENTO_ENVIA 
					this.buscarEnvia(); 
	            	asignar("VAR", "visible", "Envia");
            		asignar("VAR", "tipoMovimiento", ConstantesREC.MOVIMIENTO_ENVIA);
	            	asignar("VAR", "oidTipoMovimiento", ConstantesREC.TIPO_MOVIMIENTO_ENVIA.toString());
	            	this.pagina = "4";
					asignarHiddenBuscarProducto();
				} else {	//Si enviaFactura = False 
					//- Mostrar la ventana PgProductoReclamos donde solo aparecerán visibles los campos lstDevuelveNo , su botón asociado aceptarDevuelveNo , descripcion , codigoVenta , codigoProducto , paginaCatalogo y boton buscar 
					//- asignar: - tipoMovimiento = ConstantesRec.MOVIMIENTO_ENVIA 
		            asignar("VAR", "visible", "DevuelveNo");
					//- asignar - tipoMovimiento = ConstantesRec.MOVIMIENTO_ENVIA 
	            	asignar("VAR", "tipoMovimiento", ConstantesREC.MOVIMIENTO_ENVIA);
		            asignar("VAR", "oidTipoMovimiento", ConstantesREC.TIPO_MOVIMIENTO_ENVIA.toString());
		            this.pagina = "4";
					asignarHiddenBuscarProducto();
				}
			} 
		} 
*/
    }


    private void buscarDevuelveSi() throws Exception {
        traza("*** HSH Entrada -  LPOperacionReclamos- buscarDevuelveSi ***");

        DTOBuscarClientesREC dtoBuscarClientes = new DTOBuscarClientesREC();
        if (!conectorParametroLimpia("oidNumDocumento","", true).equals(""))
        	dtoBuscarClientes.setNumDocumento(new Long(conectorParametroLimpia("oidNumDocumento","", true)));
        if (!conectorParametroLimpia("oidCliente","", true).equals(""))
        	dtoBuscarClientes.setOidCliente(new Long(conectorParametroLimpia("oidCliente","", true)));
        dtoBuscarClientes.setOidPais(this.pais);
        dtoBuscarClientes.setOidIdioma(this.idioma);

        MareBusinessID idBusiness = new MareBusinessID("RECObtenerProductosDevuelveSi");

        // Parametros de entrada del conector                     
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoBuscarClientes);
        paramEntrada.add(idBusiness);
        traza("HSH buscarDevuelveSi-->Antes de conectar" + dtoBuscarClientes);                          
        // Se invoca al conector 
        DruidaConector conector = conectar("ConectorObtenerProductosDevuelveSiREC", paramEntrada);
        traza("HSH buscarDevuelveSi--> Despues de conectar");
        //DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida");

        //traza("datos obtenidos: ---------------------------------------------");
        //traza(conector.getXML());
        //Element e = conector.getXML();
        //traza("--------------------------------------------------------------");

        //traza(this.conectorParametro("listado2"));

        //YYY
        agregarCampos(conector);



        // Recuperar DTO obtenido y cargar lista lstDevuelveSi
		cargarComboMotivo(); //mamontie agregado por REC-16 03/01/06
		asignar("VAR", "visible", "DevuelveSi"); //mamontie agregado por REC-16 03/01/06
		asignar("LISTAEDITABLE", "listado2", conector, "dtoSalida.resultado_ROWSET");
        
        traza("*** HSH Salida -  LPOperacionReclamos- buscarDevuelveSi ***");
    }

/*
    private void recorrerHijos(Element e) throw Exception{
        NodeList nl = e.getChildNodes();
        Node n = null;
        
        for (int i = 0; i < nl.getLength(); i++){
            n = nl.item(i);
            traza("--------------------------");
            traza("nombre: " + n.getNodeName());
            traza("valor: " + n.getNodeValue());
            traza("--------------------------");
        }
    }
*/

    private void agregarCampos(DruidaConector con) throws Exception {
    
        traza("LPOperacionReclamos.agregarCampos - ENTRADA");
    
/*
        //Vector v = this.valorRowset("dtoSalida.resultado", con);
        Vector v = this.valorVector("dtoSalida.resultado_ROWSET", con);
        if (v == null){
            traza("v es null, no se obtuvieron datos");
        } else {
            traza("v viene con " + v.size() + " posiciones");
        }
        Vector v2 = null;
        Iterator i = null;
        int i2 = 0;
        if (v != null){
            i = v.iterator();
            while (i != null && i.hasNext()){
                traza("&&& recuperando el vector " + i2 + " &&&");
                v2 = (Vector)i.next();
                traza("El vector " + i2++ + " es: " + v2);
            }
        } else {
            traza("&&& v es null &&&");
        }
*/

        Element e = con.getXML();
        NodeList nl = e.getChildNodes();
        Node nn = null;
        traza("La lista de nodos tiene: " + nl.getLength()  + " elementos");
        
        for (int i = 0; i < nl.getLength(); i++){
            nn = nl.item(i);
            parsearNodo(nn, 0);
        }

        con.setXML(e);
        
        traza("LPOperacionReclamos.agregarCampos - SALIDA");
    }

    //TEST: metodo recursivo para recorrer hijos xml
    private void parsearNodo(Node n, int nivel) throws Exception {
        NodeList nl = null;
        int nivelSiguiente = nivel + 1;
    
        if (n.getNodeName().equals("ROW")){
            agregarCamposXML(n);
        }
        //} else {
            if (n.getChildNodes().getLength() > 0){
                nl = n.getChildNodes();
            
                for (int i = 0; i < nl.getLength(); i++){
                    parsearNodo(nl.item(i), nivelSiguiente);
                }
            }
        //}
    
        String indent = "";
        
        for (int j = 0; j < nivel; j++){
            indent = indent + '\t';
        }
    
        traza(indent + "Node Name: " + n.getNodeName() + '\n');
        traza(indent + "Node Value: " + n.getNodeValue() + '\n');
        traza("----------------------------------------------------------\n");
    }

    private void agregarCamposXML(Node nRow){
        Document d = nRow.getOwnerDocument();
        Text txt =  d.createTextNode("");
        Text txt2 =  d.createTextNode("");
      
        Element e_campo2 = d.createElement("CAMPO");
        e_campo2.setAttribute("NOMBRE", "PRODUCTOS_RECLAMADOS");
        e_campo2.setAttribute("TIPO", "OBJECTO");
        e_campo2.setAttribute("LONGITUD", "50");
        e_campo2.setNodeValue("agregado_1");

        e_campo2.appendChild(txt);

        Element e_campo3 = d.createElement("CAMPO");
        e_campo3.setAttribute("NOMBRE", "PRODUCTOS_DEVUELTOS");
        e_campo3.setAttribute("TIPO", "OBJECTO");
        e_campo3.setAttribute("LONGITUD", "50");
        e_campo3.appendChild(txt2);
        e_campo3.setNodeValue("agregado_2");
        
        nRow.appendChild(e_campo2);
        nRow.appendChild(e_campo3);
    }


  /**
   * @author: ssantana, 11/03/2006
   * @throws java.lang.Exception
   */
    private void grabarOperacion() throws Exception {
      traza("LPOperacionReclamo.grabarOperacion():Entrada");
      this.pagina("salidaGenerica");
      
      DTOGeneraOperacionREC dtoGeneraOp = null;
      String sExisteOperacion = "";
      String sExisteOperacionAnulacion = "";
      DTOOID dtoOid = new DTOOID();
      
      String sOidOperacion = 
              this.conectorParametroLimpia("oidOperacion", "", true);
      String sIndAnulacion = 
              this.conectorParametroLimpia("hAnulacion", "", true);
      String sChequeoFisico = this.conectorParametroLimpia("sChequeoFisico", "", true);

	  // vivi
              
      String listaLineasOperacion = this.conectorParametroLimpia("hListaLineasOperacion", "", true);
      
        traza("String para generar lineas automaticas: " + listaLineasOperacion);
      
      ArrayList posiciones = generarLineasAutomaticas(parseaLista(listaLineasOperacion));
      //*ArrayList posiciones = generarLineasAutomaticas(this.obtenerArrayListLineas());
      String[] sDatosValidarBloqueo = this.validarBloqueos(posiciones);      
      
      if (sIndAnulacion.equals("1")) {
         sExisteOperacionAnulacion = "true";
      } else {
         sExisteOperacion = "true";
      }
      
      if (sChequeoFisico.equals(ConstantesREC.BLOQUEO_POR_CHEQUEO)) {
         String sNumSecuencial = this.conectorParametroLimpia("numSecuencial", "", true);
         sChequeoFisico = sChequeoFisico + sNumSecuencial;
      }
      
      /* Arma cadena de retorno */ 
      StringBuffer sCadenaEjecutar = new StringBuffer("funcionRetornoSSSS(");
      sCadenaEjecutar.append("'" + sExisteOperacionAnulacion + "', ");
      sCadenaEjecutar.append("'" + sExisteOperacion +  "', ");
      
      sCadenaEjecutar.append("'" + sChequeoFisico + "', ");
      
      sCadenaEjecutar.append("'" + sDatosValidarBloqueo[0] + ";");
      sCadenaEjecutar.append(sDatosValidarBloqueo[1] + ";");
      sCadenaEjecutar.append(sDatosValidarBloqueo[2] + "', ");
      
      sCadenaEjecutar.append("'" + construirCadena(posiciones) + "')");
      
      traza("sCAdenaEjecutar: " + sCadenaEjecutar.toString());
      
      this.asignarAtributo("VAR", "ejecutar", "valor", sCadenaEjecutar.toString());
      
    }
    
  /**
   * @author: ssantana, 14/03/2006
   * @throws java.lang.Exception
   */
    private void obtenerIndicadoresOperacion() throws Exception {
      traza("LPOperacionReclamo.cambiarCampanya():Entrada");
      
      this.pagina("salidaGenerica");
      this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
      this.asignarAtributo("VAR", "ejecutarError", "valor", "errorIndicadores()");
      
      DTOIndicadoresOperacionREC dtoIndicadores = new DTOIndicadoresOperacionREC();
      MareBusinessID bussId = new MareBusinessID("RECObtenerIndicadoresOperacion");
      Vector vParams = new Vector();
      DruidaConector con = null;
      String sOidOperacion = this.conectorParametroLimpia("oidOperacion", "", true);
      String sOidTipoOperacion = this.conectorParametroLimpia("oidTipoOperacion", "", true);
      
      dtoIndicadores.setOidOperacion( Long.valueOf(sOidOperacion) );
      dtoIndicadores.setOidTipoOperacion( Long.valueOf(sOidTipoOperacion) );

      vParams.add(dtoIndicadores);
      vParams.add(bussId);
      
      traza("Conectando...");
      con = this.conectar("ConectorObtenerIndicadoresOperacionREC", vParams);
      traza("Conecto!");
      
      dtoIndicadores = (DTOIndicadoresOperacionREC)con.objeto("DTOIndicadoresOperacionREC");
      
		  traza("dtoIndicadores santana: " + dtoIndicadores);

      Boolean bIngresaDevuelve = dtoIndicadores.getIngresaDevuelve();
      Boolean bIngresaEnvia = dtoIndicadores.getIngresaEnvia();
      Boolean bEnviaGeneraDevuelve = dtoIndicadores.getEnviaGeneraDevuelve();
      Boolean bDevuelveGeneraEnvia = dtoIndicadores.getDevuelveGeneraEnvia();
      Boolean bDevuelveFisicoFactura = dtoIndicadores.getDevuelveFisicoFactura();
      Boolean bDevuelveFactura = dtoIndicadores.getDevuelveFactura();
      Boolean bEnviaFactura = dtoIndicadores.getEnviaFactura();
      Boolean bAnulacion = dtoIndicadores.getIndicadorAnulacion();
      Boolean bPerdida = dtoIndicadores.getIndicadorPerdida();
      Boolean bRecojo = dtoIndicadores.getIndicadorRecojo();
      String sChequeoFisico = dtoIndicadores.getChequeoFisico();

	  String sPrecioEnvia = dtoIndicadores.getPrecioEnvia()!=null?dtoIndicadores.getPrecioEnvia():"";
      
	  String sMatriz = dtoIndicadores.getMatriz();
      traza("Matriz "+ sMatriz);
      StringBuffer sBooleans = new StringBuffer("");
      String separator = ";";
      
      sBooleans.append(this.armaCadenaParams(bIngresaDevuelve));
      sBooleans.append(separator);
      sBooleans.append(this.armaCadenaParams(bIngresaEnvia));
      sBooleans.append(separator);
      sBooleans.append(this.armaCadenaParams(bEnviaGeneraDevuelve));
      sBooleans.append(separator);
      sBooleans.append(this.armaCadenaParams(bDevuelveGeneraEnvia));
      sBooleans.append(separator);
      sBooleans.append(this.armaCadenaParams(bDevuelveFisicoFactura));
      sBooleans.append(separator);
      sBooleans.append(this.armaCadenaParams(bDevuelveFactura));
      sBooleans.append(separator);
      sBooleans.append(this.armaCadenaParams(bEnviaFactura));
      sBooleans.append(separator);
      sBooleans.append(this.armaCadenaParams(bAnulacion));
      sBooleans.append(separator);
      sBooleans.append(this.armaCadenaParams(bPerdida));
      sBooleans.append(separator);
      sBooleans.append(sChequeoFisico);
	  sBooleans.append(separator);
      sBooleans.append(sPrecioEnvia);
      sBooleans.append(separator);
      sBooleans.append(sMatriz);
      sBooleans.append(separator);
      sBooleans.append(bRecojo);
	  
      
	  StringBuffer sFuncionJS = new StringBuffer("");
      sFuncionJS.append("manejoAnulacion('" + sBooleans.toString() + "')");
      traza("Funcion JS generada: " + sFuncionJS.toString());
      
      this.asignarAtributo("VAR", "ejecutar", "valor", sFuncionJS.toString());
      
      
    }
    
  /**
   * @author: ssantana, 14/03/2006
   * @throws java.lang.Exception
   * @return String
   * @param Boolean bValor
   */
    private String armaCadenaParams(Boolean bValor) throws Exception {
      String sRetorno = null;
      if (bValor.booleanValue()) {
        sRetorno = "1";
      } else {
        sRetorno = "0";
      }
      return sRetorno;
    }    


    // Viene de PgProductosReclamo.onClickAceptarDevuelveSi 
    private void buscarEnvia() throws Exception {
        traza("*** HSH Entrada -  LPOperacionReclamos- buscarEnvia ***");
        DTOBuscarEnvia dtoBuscarEnvia = new DTOBuscarEnvia();
        dtoBuscarEnvia.setOidPais(this.pais);
        dtoBuscarEnvia.setOidIdioma(this.idioma);
		if (!conectorParametroLimpia("oidCliente","", true).equals(""))
        	dtoBuscarEnvia.setOidCliente(new Long(conectorParametroLimpia("oidCliente","", true)));
        if (!conectorParametroLimpia("oidNumDocumento","", true).equals(""))
        	dtoBuscarEnvia.setOidNumDocumento(new Long(conectorParametroLimpia("oidNumDocumento","", true)));
        if (!conectorParametroLimpia("oidOperacion","", true).equals(""))
        	dtoBuscarEnvia.setOidOperacion(new Long(conectorParametroLimpia("oidOperacion","", true)));

        traza("Parametros obtenidos: dtoBuscarEnvia="+dtoBuscarEnvia);
        
        MareBusinessID idBusiness = new MareBusinessID("RECObtenerProductosEnvia");

        // Parametros de entrada del conector                     
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoBuscarEnvia);
        paramEntrada.add(idBusiness);
        traza("HSH buscarEnvia-->Antes de conectar");                          
        // Se invoca al conector 
        DruidaConector conector = conectar("ConectorObtenerProductosEnviaREC", paramEntrada);
        traza("HSH buscarEnvia--> Despues de conectar");

        // - Recuperar DTO obtenido y cargar lista lstEnvia
		asignar("LISTAEDITABLE", "listado3", conector, "dtoSalida.resultado_ROWSET");

        traza("*** HSH Salida -  LPOperacionReclamos- buscarEnvia ***");
    }

	private String[] validarBloqueos(ArrayList posiciones) throws Exception {
		traza("LPOperacionReclamos.validarBloqueos() - Entrada");
		
		/*Inicio - Obtencion del DTOBloqueoTipoOperacionREC*/
		String oidDocumentoReferencia = conectorParametroLimpia("oidNumDocumento","", true);
		String tipoOperacion = conectorParametroLimpia("cbCodTipoOper","", true);                
		traza("*********** oidDocumentoReferencia: " + oidDocumentoReferencia);
		traza("*********** tipoOperacion: " + tipoOperacion);

        DTOOperacionReclamo dtoOperacionREC = new DTOOperacionReclamo();
        dtoOperacionREC.setOidIdioma(this.pais);
        dtoOperacionREC.setOidPais(this.idioma);
        if (!oidDocumentoReferencia.equals("")){
	        dtoOperacionREC.setOidDocumentoReferencia(new Long(oidDocumentoReferencia));
        }
        if (!tipoOperacion.equals("")){
		    dtoOperacionREC.setTipoOperacion(new Long(tipoOperacion));
        }
		dtoOperacionREC.setUsuario(UtilidadesSession.getIdUsuario(this));        
        dtoOperacionREC.setLineas(obtenerLineas(posiciones));   
 
		MareBusinessID idBusiness = new MareBusinessID("RECObtenerBloqueosTipo");    
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoOperacionREC);
        paramEntrada.add(idBusiness);
		traza("********** ANTES DE CONECTAR");
        DruidaConector conector = conectar("ConectorValidarPerdidaREC", paramEntrada);        
		traza("********** DESPUES DE CONECTAR");
        DTOBloqueoTipoOperacionREC dtoBloqueo = (DTOBloqueoTipoOperacionREC) conector.objeto("DTOBoolean");
		traza("********** DTOBloqueoTipoOperacionREC " + dtoBloqueo);
		/*Fin - Obtencion del DTOBloqueoTipoOperacionREC*/

        String[] valoresRetorno = new String[3];
        String motivoBloqueo = conectorParametroLimpia("cbMotivoBloq","", true);
        traza("******* motivoBloqueo: " + motivoBloqueo);

        if (motivoBloqueo.equals(""))  {// no se ha seleccionado manualmente ningun motivo de bloqueo        
			traza("******* IF");
            calcularSumatorias(posiciones);            
            establecerBloqueo(dtoBloqueo);            
            
            if (oidMotivoBloqueo != null) {
              valoresRetorno[0] = oidMotivoBloqueo.toString();
            }
			else {
              valoresRetorno[0] = null;
            }

            if (oidEstadoOperacion != null) {
              valoresRetorno[1] = oidEstadoOperacion.toString();
            }
			else {
              valoresRetorno[1] = null;
            }
            
            if (tipoBloqueo != null) {
              valoresRetorno[2] = tipoBloqueo;  
            }
			else {
              valoresRetorno[2] = tipoBloqueo;  
            }
            
        }
		else {
			traza("******* ELSE");
			oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO;

			if(dtoBloqueo.getBloqueoUnidades()!=null) {
				if(motivoBloqueo.equals(dtoBloqueo.getBloqueoUnidades().toString())) {
					tipoBloqueo = ConstantesREC.BLOQUEO_UNIDADES_DEVUELTAS;			
				}
			}

			if(dtoBloqueo.getBloqueoImporte()!=null) {
				if(motivoBloqueo.equals(dtoBloqueo.getBloqueoImporte().toString())) {
					tipoBloqueo = ConstantesREC.BLOQUEO_IMPORTE_MAXIMO;			
				}
			}

			if(dtoBloqueo.getBloqueoDiferencia()!=null) {
				if(motivoBloqueo.equals(dtoBloqueo.getBloqueoDiferencia().toString())) {
					tipoBloqueo = ConstantesREC.BLOQUEO_DIFERENCIA_IMPORTES;			
				}
			}

			if(dtoBloqueo.getBloqueoAnterior()!=null) {
				if(motivoBloqueo.equals(dtoBloqueo.getBloqueoAnterior().toString())) {
					tipoBloqueo = ConstantesREC.BLOQUEO_RECLAMO_ANTERIOR;			
				}
			}

			valoresRetorno[0] = motivoBloqueo;
			valoresRetorno[1] = oidEstadoOperacion.toString();
			valoresRetorno[2] = tipoBloqueo;  
		}

		traza("LPOperacionReclamos.validarBloqueos() - Salida");
        return valoresRetorno;
	}

    // Se llama en LPOperacionReclamos.grabarOperacion
    /*private String[] validarBloqueos(ArrayList posiciones) throws Exception {
        String[] valoresRetorno = new String[3];
        String motivoBloqueo = conectorParametroLimpia("cbMotivoBloq","", true);
        traza(" Combo MotivoBloqueo: "+ motivoBloqueo);

        if (motivoBloqueo.equals(""))  {// no se ha seleccionado manualmente ningun motivo de bloqueo 

            String oidDocumentoReferencia = conectorParametroLimpia("oidNumDocumento","", true);
            String tipoOperacion = conectorParametroLimpia("cbCodTipoOper","", true);
    
            
            //- uReclamadas <- sumatorio de campo unidadesReclamadas de la lista lstResultados 
            //- uDevueltas <- sumatorio de campo unidadesDevueltas de la lista lstResultados 
            //- totalCargo <- sumatorio de campo importeCargo de la lista lstResultados 
            //- totalAbono <- sumatorio de campo importeAbono de la lista lstResultados    
            calcularSumatorias(posiciones);
            
            //Crear un DTOOperacionReclamo con: 
            //- oidDocumentoReferencia = Procedente de la página 
            //- tipoOperacion = oid del valor seleccionado en cbCodigoTipoOperacion 
            //- usuario = usuario del sistema 
            DTOOperacionReclamo dtoOperacionREC = new DTOOperacionReclamo();
            dtoOperacionREC.setOidIdioma(this.pais);
            dtoOperacionREC.setOidPais(this.idioma);
            if (!oidDocumentoReferencia.equals("")){
                dtoOperacionREC.setOidDocumentoReferencia(new Long(oidDocumentoReferencia));
            }
            if (!tipoOperacion.equals("")){
                dtoOperacionREC.setTipoOperacion(new Long(tipoOperacion));
            }
            dtoOperacionREC.setUsuario(UtilidadesSession.getIdUsuario(this));

            
            //Por cada linea de la operación creamos un DTOLineaOperacion con: 
            //- oidCodVenta 
            //- oidCodProducto  
            //Añadimos cada DTOLineaOperacion a DTOOperacionReclamo   
            dtoOperacionREC.setLineas(obtenerLineas(posiciones));
    
                    
            //- Invocar conector ConectorObtenerBloqueosTipoREC enviando el DTOOperacionReclamo creado 
            //- Crear IDBusiness="RECObtenerBloqueosTipo" 
            //- Recuperar DTO obtenido  
            MareBusinessID idBusiness = new MareBusinessID("RECObtenerBloqueosTipo");
    
            // Parametros de entrada del conector                     
            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoOperacionREC);
            paramEntrada.add(idBusiness);
            
            DruidaConector conector = conectar("ConectorValidarPerdidaREC", paramEntrada);        
            DTOBloqueoTipoOperacionREC dtoBloqueo = (DTOBloqueoTipoOperacionREC) conector.objeto("DTOBoolean");
            
            establecerBloqueo(dtoBloqueo);
            
            
            if (oidMotivoBloqueo != null) {
              valoresRetorno[0] = oidMotivoBloqueo.toString();
            } else {
              valoresRetorno[0] = null;
            }

            if (oidEstadoOperacion != null) {
              valoresRetorno[1] = oidEstadoOperacion.toString();
            } else {
              valoresRetorno[1] = null;
            }
            
            if (tipoBloqueo != null) {
              valoresRetorno[2] = tipoBloqueo;  
            } else {
              valoresRetorno[2] = tipoBloqueo;  
            }
            
        }
        return valoresRetorno;
	}*/

  /**
   * @author: ssantana, 07/03/2006
   * @throws java.lang.Exception
   */
    private void validarPerdida() throws Exception {
       traza("LPOperacionReclamos.validarPerdida(): Entrada"); 
       /* 
        * Pagina temporal, solamente para que exista una pagina 
        * si pincha el conectar. 
        */
       this.pagina("salidaGenerica");
       this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
       
       DTOOID dtoE = new DTOOID();
       MareBusinessID bussId = new MareBusinessID("RECValidarPerdida");
       Vector vParams = new Vector();
       DruidaConector con = null;
       String sOidOperacion = this.conectorParametroLimpia("oidOperacion", 
                                                           "", 
                                                           true);
       
       dtoE.setOid(Long.valueOf(sOidOperacion));
       dtoE.setOidIdioma(UtilidadesSession.getIdioma(this));
       dtoE.setOidPais(UtilidadesSession.getPais(this));
       
       vParams.add(dtoE);
       vParams.add(bussId);
       
       traza("Se conecta...");
       con = this.conectar("ConectorValidarPerdidaREC", vParams);
       traza("Se conecto!");
       
       DTOBoolean dtoBoolean = (DTOBoolean) con.objeto("DTOBoolean");
       boolean bPerdida = dtoBoolean.getValor();
       traza("dtoBoolean: " + dtoBoolean);
       
       if (bPerdida) {
          traza("Es Perdida");
          this.conectorAction("LPCapturaProcesoReclamos");          
          this.conectorActionParametro("accion", "buscar");
          
          
       } else {
          traza("No Es Perdida");
       }
      
    }
    
    private void establecerBloqueo(DTOBloqueoTipoOperacionREC dtoBloqueo) throws Exception {
        traza("LPOperacionReclamos.establecerBloqueo():Entrada");
        traza("dtoBloqueo: " + dtoBloqueo);

        if (dtoBloqueo.getBloqueoUnidades() != null) {
            traza("Bloqueo x unidades");
            traza("totalUnidadesDevuelve: " + totalUnidadesDevuelve );
            traza("totalUnidadesReclamadas: " + totalUnidadesReclamadas);
            if (totalUnidadesDevuelve > totalUnidadesReclamadas)  { // Si uDevueltas > uReclamadas
                oidMotivoBloqueo = dtoBloqueo.getBloqueoUnidades();
                oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO;
                tipoBloqueo = ConstantesREC.BLOQUEO_UNIDADES_DEVUELTAS;			
            }
        } 
		
		if (dtoBloqueo.getBloqueoImporte() != null) {
            traza("Bloqueo x importe");
            traza("dtoBloqueo.getImporteMaximo(): " + dtoBloqueo.getImporteMaximo());
            traza("totalImporteCargo: " + totalImporteCargo);
            if ((dtoBloqueo.getImporteMaximo() != null) && (totalImporteCargo > dtoBloqueo.getImporteMaximo().intValue()))  { // Si(dto.importeMaximo <> NULL) y (totalCargo > dto.importeMaximo)
                oidMotivoBloqueo = dtoBloqueo.getBloqueoImporte();
                oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO;
                tipoBloqueo = ConstantesREC.BLOQUEO_IMPORTE_MAXIMO;			
            }
        } 
		
		if (dtoBloqueo.getBloqueoDiferencia() != null) {
            traza("Bloqueo x Diferencia");
            traza("dtoBloqueo.getImporteMaximo(): " + dtoBloqueo.getImporteMaximo());
            traza("totalImporteCargo: " + totalImporteCargo);
            traza("totalImporteAbono: " + totalImporteAbono);
            if ((dtoBloqueo.getImporteMaximo() != null) && 
                    ((totalImporteCargo - totalImporteAbono) >  dtoBloqueo.getImporteMaximo().intValue()))  { //Si(dto.montoMaximo <> NULL) y ((totalCargo - totalAbono) > dto.montoMaximo)
                oidMotivoBloqueo = dtoBloqueo.getBloqueoDiferencia();
                oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO;
                tipoBloqueo = ConstantesREC.BLOQUEO_DIFERENCIA_IMPORTES;			
            }
        } 
		
		if (dtoBloqueo.getBloqueoAnterior() != null) {
            traza("Bloqueo x Anterior");
            traza("dtoBloqueo.getBloqueoAnterior(): " + dtoBloqueo.getBloqueoAnterior());
            oidMotivoBloqueo = dtoBloqueo.getBloqueoAnterior();
            oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO;
            tipoBloqueo = ConstantesREC.BLOQUEO_RECLAMO_ANTERIOR;			
        }
		
		traza("LPOperacionReclamos.establecerBloqueo():Salida");
    }  
    
    private void calcularSumatorias(ArrayList posicionesOperacion) throws Exception {    
        traza("LPOperacionReclamos.calcularSumatorias() - ENTRADA");   
        traza("posicionesOperacion: " + posicionesOperacion);
    
        int cantPos = posicionesOperacion.size();
        this.totalUnidadesReclamadas = 0;
        this.totalUnidadesDevuelve = 0;
        this.totalImporteCargo = 0;
        this.totalImporteAbono = 0;
        
        for (int i=0; i<cantPos; i++)  {         
            traza("actualiza...");
        
            DTOLineaOperacionAuxiliarREC dtoREC = (DTOLineaOperacionAuxiliarREC) posicionesOperacion.get(i);
            this.totalUnidadesReclamadas += dtoREC.getUReclamadas().longValue();
            
            if (dtoREC != null && dtoREC.getUDevueltas() != null){
                this.totalUnidadesDevuelve += dtoREC.getUDevueltas().longValue();
            }
            if(dtoREC.getImporteCargo()!=null){
				this.totalImporteCargo += dtoREC.getImporteCargo().doubleValue();
			}
            
			if(dtoREC.getImporteAbono()!=null){
				this.totalImporteAbono += dtoREC.getImporteAbono().doubleValue();
			}			
        }
        
        traza("totalUnidadesDevuelve: " + totalUnidadesDevuelve);
        traza("totalImporteCargo: " + totalImporteCargo);
        traza("totalImporteAbono: " + totalImporteAbono);        
        traza("LPOperacionReclamos.calcularSumatorias() - SALIDA");
    }    
    
    private ArrayList obtenerLineas(ArrayList posicionesOperacion) throws Exception {
        int cantPos = posicionesOperacion.size();
        DTOLineaOperacionAuxiliarREC dtoREC = null;
        ArrayList arr = new ArrayList();
        for (int i=0; i<cantPos; i++)  {
            dtoREC = (DTOLineaOperacionAuxiliarREC) posicionesOperacion.get(i);
            DTOLineaOperacion dtoLinea = new DTOLineaOperacion();
            dtoLinea.setOidCodVenta(dtoREC.getOidCodigoVenta());
            dtoLinea.setOidCodProducto(dtoREC.getOidCodigoProducto());
            dtoLinea.setOidIdioma(this.idioma);
            dtoLinea.setOidPais(this.pais);
            arr.add(dtoLinea);
        }
        return arr;        
    }    
    private ArrayList generarLineasAutomaticas(ArrayList posicionesOperacion) throws Exception {
        /*Descripción: genera lineas complementarias segun la parametrizacion de la operacion. 
        
        Implementación: 
        
        // Generar Lineas Automaticas: se muestran en pantalla. 
        // No se almacenan en BD hasta que el usuario selecciona la opcion de menu guardar en la pantalla correspondiente */
        
        /*
        - Se crea un arreglo lstResultado con los registros recibidos de la PgAgregaOperacion de la listaEditable "lstResultado"         */
        ArrayList posicionesOperacionGeneradas = new ArrayList();
        int cantLineas = posicionesOperacion.size();
        int ultimoNumeroLinea = obtenerUltimoNumeroLinea(posicionesOperacion);
        
        String sEnviaGeneraDevuelve = this.conectorParametroLimpia("hEnviaGeneraDevuelve", "", true);
        String sDevuelveGeneraEnvia = this.conectorParametroLimpia("hDevuelveGeneraEnvia", "", true);
        
        for (int i=0; i< cantLineas ; i++)  {
            traza("Procesando la posicion.... " + i);
            DTOLineaOperacionAuxiliarREC dtoAuxiliarREC = (DTOLineaOperacionAuxiliarREC) posicionesOperacion.get(i);
            traza("dtoAuxiliarREC: " + dtoAuxiliarREC);
            
            int tipoMovimiento = dtoAuxiliarREC.getOidTipoMovimiento()!=null?dtoAuxiliarREC.getOidTipoMovimiento().intValue():0;
            traza("tipoMovimiento: " + tipoMovimiento);
            /*if ((tipoMovimiento == ConstantesREC.TIPO_MOVIMIENTO_ENVIA.intValue()) &&
                    (enviaGeneraDevuelve.equals("true") )) {*/
            if ((tipoMovimiento == ConstantesREC.TIPO_MOVIMIENTO_ENVIA.intValue()) &&
                    (sEnviaGeneraDevuelve.equals("1") )) {                    
                traza("AAA");    
                DTOLineaOperacionAuxiliarREC dtoAuxiliarRECGenerado = copiarDTOLineaOperacionAuxiliarREC(dtoAuxiliarREC);
				dtoAuxiliarREC.setOidPosicionSolicitud(null);
				dtoAuxiliarRECGenerado.setNumLinea(new Long(ultimoNumeroLinea+1));
                dtoAuxiliarRECGenerado.setOidTipoMovimiento(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
                dtoAuxiliarRECGenerado.setTipoMovimiento(ConstantesREC.MOVIMIENTO_DEVUELVE);
                dtoAuxiliarRECGenerado.setImporteCargo(new Double(0));
                posicionesOperacionGeneradas.add(dtoAuxiliarRECGenerado);
                ultimoNumeroLinea++;
            
            } else if ((tipoMovimiento == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.intValue()) && 
                       (sDevuelveGeneraEnvia.equals("1")) && (dtoAuxiliarREC.getOidPosicionSolicitud() != null) ){
                traza("BBB");
                DTOLineaOperacionAuxiliarREC dtoAuxiliarRECGenerado = copiarDTOLineaOperacionAuxiliarREC(dtoAuxiliarREC);
                dtoAuxiliarRECGenerado.setNumLinea(new Long(ultimoNumeroLinea+1));
                dtoAuxiliarRECGenerado.setOidTipoMovimiento(ConstantesREC.TIPO_MOVIMIENTO_ENVIA);
                dtoAuxiliarRECGenerado.setTipoMovimiento(ConstantesREC.MOVIMIENTO_ENVIA);
                dtoAuxiliarRECGenerado.setImporteAbono(new Double(0));
                dtoAuxiliarRECGenerado.setOidPosicionSolicitud(null);
				posicionesOperacionGeneradas.add(dtoAuxiliarRECGenerado);
                ultimoNumeroLinea++;
            }
            traza("Termino de Procesar la posicion.... " + i);            
        }
        traza("finalizó el procesamiento de las posiciones.... ");
        posicionesOperacion.addAll(posicionesOperacionGeneradas);        
        return posicionesOperacion;
    }
    
    
    private ArrayList obtenerArrayListLineas() throws Exception {
        /* Metodo que genera el atributo ArrayList posicionesOperacion de dtos DTOLineaOperacionAuxiliarREC
         * con las posiciones que se 
         * encuentran en la pagina pgAgregarOperacion*/
        ArrayList posicionesOperacion = new ArrayList();
        String strLineasPosicion = conectorParametroLimpia("hListaLineasOperacion","",true);
        String[] arrLineasPosicion = construirLineas(strLineasPosicion,SEPA_LINEA);
        
        int cantPos = arrLineasPosicion.length;
        String vacio = "";
        String espacio = " ";
        String sBuffer = null;
        for (int i=0; i< cantPos; i++)  {
            String[] columnas =  construirLineas(arrLineasPosicion[i],SEPA_CAMPO);
            DTOLineaOperacionAuxiliarREC dto = new DTOLineaOperacionAuxiliarREC();
            
            if (columnas[NUM_LINEA] != null && 
                    !columnas[NUM_LINEA].equals(vacio)
                    && !columnas[NUM_LINEA].equals(espacio) ) {
                sBuffer = this.desFormatearNumero(columnas[NUM_LINEA], 
                                                  this.FORMATO_DEFAULT);
                dto.setNumLinea(Long.valueOf(sBuffer)); 
            }
          
            dto.setTipoMovimiento(columnas[TIPO_MOVI]);
            
            if ( columnas[OID_TIPO_MOVI] != null && 
                    !columnas[OID_TIPO_MOVI].equals(vacio)
                    && !columnas[OID_TIPO_MOVI].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[OID_TIPO_MOVI], 
                                                  this.FORMATO_DEFAULT);
                dto.setOidTipoMovimiento(Long.valueOf(sBuffer));
            }
            
            dto.setCodVenta(columnas[COD_VENTA]);
            dto.setCodProducto(columnas[COD_PRODUCTO]);
            dto.setDescProducto(columnas[DESC_PRODUCTO]);
            dto.setMotivoDevolucion(columnas[MOTIVO_DEVOLUCION]);            
            
            if (columnas[UNIDADES_RECLAMADAS] != null && 
                    !columnas[UNIDADES_RECLAMADAS].equals(vacio)
                    && !columnas[UNIDADES_RECLAMADAS].equals(espacio) ) {
                sBuffer = this.desFormatearNumero(columnas[UNIDADES_RECLAMADAS], 
                                                  this.FORMATO_DEFAULT);
                dto.setUReclamadas(Long.valueOf(sBuffer));
            }
            
            if (columnas[OID_MOTIVO_DEVOLUCION] != null && 
                    !columnas[OID_MOTIVO_DEVOLUCION].equals(vacio)
                    && !columnas[OID_MOTIVO_DEVOLUCION].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[OID_MOTIVO_DEVOLUCION], 
                                                  this.FORMATO_DEFAULT);
                dto.setOidMotivoDevolucion(Long.valueOf(sBuffer));
            }
            
            if (columnas[PRECIO_PRODUCTO] != null && 
                    !columnas[PRECIO_PRODUCTO].equals(vacio)
                        && !columnas[PRECIO_PRODUCTO].equals(espacio) ) {
                sBuffer = this.desFormatearNumero(columnas[PRECIO_PRODUCTO], 
                                                  this.FORMATO_DEFAULT);
                dto.setPrecioProducto(Double.valueOf(sBuffer));
            }

            if (columnas[IMPORTE_CARGO] != null && 
                    !columnas[IMPORTE_CARGO].equals(vacio)
                    && !columnas[IMPORTE_CARGO].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[IMPORTE_CARGO], 
                                                  this.FORMATO_DEFAULT);
                dto.setImporteCargo(Double.valueOf(sBuffer));
            }
            
            if (columnas[IMPORTE_ABONO] != null && 
                    !columnas[IMPORTE_ABONO].equals(vacio)
                    && !columnas[IMPORTE_ABONO].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[IMPORTE_ABONO], 
                                                  this.FORMATO_DEFAULT);
                dto.setImporteAbono(Double.valueOf(sBuffer));
            }

            if (columnas[UNIDADES_DEVUELTAS] != null && 
                    !columnas[UNIDADES_DEVUELTAS].equals(vacio)
                  && !columnas[UNIDADES_DEVUELTAS].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[UNIDADES_DEVUELTAS], 
                                                  this.FORMATO_DEFAULT);
                dto.setUDevueltas(Long.valueOf(sBuffer));
            }

            if (columnas[MFCA_OID_CABE] != null && 
                    !columnas[MFCA_OID_CABE].equals(vacio)
                    && !columnas[MFCA_OID_CABE].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[MFCA_OID_CABE], 
                                                  this.FORMATO_DEFAULT);
                dto.setOidCodigoVenta(Long.valueOf(sBuffer));
            }
            
            if (columnas[OID_PRODUCTO] != null && 
                    !columnas[OID_PRODUCTO].equals(vacio)
                  && !columnas[OID_PRODUCTO].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[OID_PRODUCTO], 
                                                  this.FORMATO_DEFAULT);
                dto.setOidCodigoProducto(Long.valueOf(sBuffer));
            }
            
            if (columnas[MONTO_PERDIDA] != null && 
                    !columnas[MONTO_PERDIDA].equals(vacio) 
                  && !columnas[MONTO_PERDIDA].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[MONTO_PERDIDA], 
                                                  this.FORMATO_DEFAULT);
                dto.setMontoPerdida(Double.valueOf(sBuffer));
            }

            if (columnas[DESCUENTO] != null && 
                    !columnas[DESCUENTO].equals(vacio)
                  && !columnas[DESCUENTO].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[DESCUENTO], 
                                                  this.FORMATO_DEFAULT);
                dto.setDescuentoUnitario(Double.valueOf(sBuffer));
            }
			if (columnas[OID_POSICION] != null && 
                    !columnas[OID_POSICION].equals(vacio)
                  && !columnas[OID_POSICION].equals(espacio)) {
                sBuffer = this.desFormatearNumero(columnas[OID_POSICION], 
                                                  this.FORMATO_DEFAULT);
                dto.setOidPosicionSolicitud(Long.valueOf(sBuffer));
            }
            posicionesOperacion.add(dto);
        }
            /* Armo el DTOLineaOperacionAuxiliarREC de la linea */
        return posicionesOperacion;
    } 
    
    private String[] construirLineas(String s, String s1)
        throws Exception {
        StringTokenizer stringtokenizer = new StringTokenizer(s, s1);
        String[] as = new String[stringtokenizer.countTokens()];

        for (int i = 0; stringtokenizer.hasMoreTokens(); i++) {
            as[i] = stringtokenizer.nextToken();
        }
        return as;
    }
    
    private String construirCadena(ArrayList posicionesOperacion) throws Exception {
        StringBuffer strPosiciones = new StringBuffer();
        int cantPos = posicionesOperacion.size();
        
        String separadorFila = "|";
        String separadorCampo = "~";

        for (int i=0; i<cantPos; i++)  {
			DTOLineaOperacionAuxiliarREC dtoREC = (DTOLineaOperacionAuxiliarREC) posicionesOperacion.get(i);
	        traza("Contruir cadena DTO "+ dtoREC);
			strPosiciones.append(dtoREC.getNumLinea() + separadorCampo);
            strPosiciones.append(dtoREC.getTipoMovimiento() + separadorCampo);
            strPosiciones.append(dtoREC.getOidTipoMovimiento() + separadorCampo);
            strPosiciones.append(dtoREC.getCodVenta() + separadorCampo);
            strPosiciones.append(dtoREC.getCodProducto() + separadorCampo);
            strPosiciones.append(dtoREC.getDescProducto() + separadorCampo);
            strPosiciones.append(dtoREC.getUReclamadas() + separadorCampo);
            strPosiciones.append(dtoREC.getMotivoDevolucion() + separadorCampo);
            strPosiciones.append(dtoREC.getOidMotivoDevolucion() + separadorCampo);
            strPosiciones.append(dtoREC.getPrecioProducto() + separadorCampo);
            strPosiciones.append(dtoREC.getImporteCargo() + separadorCampo);
            strPosiciones.append(dtoREC.getImporteAbono() + separadorCampo);
            strPosiciones.append(dtoREC.getUDevueltas() + separadorCampo);
            strPosiciones.append(dtoREC.getOidCodigoVenta() + separadorCampo);  
            strPosiciones.append(dtoREC.getOidCodigoProducto() + separadorCampo);  
            strPosiciones.append(dtoREC.getMontoPerdida() + separadorCampo);  
            strPosiciones.append(dtoREC.getDescuentoUnitario() + separadorCampo);  
			strPosiciones.append(dtoREC.getOidPosicionSolicitud() + separadorCampo);
			strPosiciones.append(dtoREC.getOidTipoOferta() + separadorCampo);
			strPosiciones.append(dtoREC.getOidConcurso() + separadorCampo);
			strPosiciones.append(dtoREC.getOidNivel() + separadorCampo);
			strPosiciones.append(dtoREC.getOidPremio() + separadorCampo);
			strPosiciones.append(dtoREC.getPrecioContable() + separadorFila);

	        traza("Contruir cadena "+ strPosiciones);
		}
        
        strPosiciones.deleteCharAt(strPosiciones.length()-1);
        return strPosiciones.toString();
    }    
    private int obtenerUltimoNumeroLinea(ArrayList posicionesOperacion) throws Exception {
        int size = posicionesOperacion.size();
		traza("MAD El size es " + size);
        DTOLineaOperacionAuxiliarREC dto = (DTOLineaOperacionAuxiliarREC) posicionesOperacion.get(size - 1);
        return dto.getNumLinea().intValue();
    }

    public DTOLineaOperacionAuxiliarREC copiarDTOLineaOperacionAuxiliarREC(DTOLineaOperacionAuxiliarREC dtoEntrada){
        DTOLineaOperacionAuxiliarREC dto = new DTOLineaOperacionAuxiliarREC();
        dto.setCodProducto(dtoEntrada.getCodProducto());        
        dto.setCodVenta(dtoEntrada.getCodVenta());
        dto.setDescProducto(dtoEntrada.getDescProducto());
        dto.setImporteAbono(dtoEntrada.getImporteCargo());
        dto.setImporteCargo(dtoEntrada.getImporteAbono());
        dto.setMotivoDevolucion(dtoEntrada.getMotivoDevolucion());
        dto.setNumLinea(dtoEntrada.getNumLinea());
        dto.setOidMotivoDevolucion(dtoEntrada.getOidMotivoDevolucion());
        dto.setOidTipoMovimiento(dtoEntrada.getOidTipoMovimiento());
        dto.setPrecioProducto(dtoEntrada.getPrecioProducto());
        dto.setTipoMovimiento(dtoEntrada.getTipoMovimiento());
        dto.setUReclamadas(dtoEntrada.getUReclamadas());
        dto.setUDevueltas(dtoEntrada.getUDevueltas());
        dto.setOidCodigoVenta(dtoEntrada.getOidCodigoVenta());
        dto.setOidCodigoProducto(dtoEntrada.getOidCodigoProducto());
        dto.setMontoPerdida(dtoEntrada.getMontoPerdida());
        dto.setDescuentoUnitario(dtoEntrada.getDescuentoUnitario());
		dto.setOidPosicionSolicitud(dtoEntrada.getOidPosicionSolicitud());
		dto.setOidConcurso(dtoEntrada.getOidConcurso());
		dto.setOidNivel(dtoEntrada.getOidNivel());
		dto.setOidPremio(dtoEntrada.getOidPremio());
		dto.setPrecioContable(dtoEntrada.getPrecioContable());
		// Agregado por HRCS - Fecha 27/02/2008 - Incidencia Sicc20080569
		dto.setOidTipoOferta(dtoEntrada.getOidTipoOferta());
		return dto;
    }    
    
  /**
   * @author: ssantana, 16/03/2006
   * @throws java.lang.Exception
   * @return void
   * @param String sXml
   */
    private ArrayList parseaLista(String sXml) throws Exception {
        traza("LPOperacionReclamos.parseaLista():Entrada");
        traza("sxml: " + sXml);
        String sPropiedadActual = null;
        String sValorCampo = null;
        String sPropiedad = null;
        Node nodeDoc = null;        
        Node nodoRow = null;
        Node nodoCampo = null;
        Node textNode = null;
        NodeList nodeList = null;
        NodeList nodeListCampos = null;
        HashMap hshAtributos = new HashMap();
        DocumentBuilder docBuilder = null;
        DTOLineaOperacionAuxiliarREC dto = null;
        Object obj = null;
   
        ArrayList posicionesOperacion = new ArrayList();

		// sXml = sXml.replaceAll("/&/gi", "&amp;").replaceAll("/\'/gi", "&apos;").replaceAll("/</gi", "&lt;").replaceAll("/>/gi","&gt;").replaceAll("/\"/gi", "&quot;");
		sXml = sXml.replaceAll("&", "&amp;");
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sXml.getBytes());
        
        nodeDoc = docBuilder.parse(inputStream).getFirstChild();
        traza("nodeDoc: " + nodeDoc.getNodeName());
        nodeList = nodeDoc.getOwnerDocument().getElementsByTagName("ROW");
        //nodeDoc.getChildNodes(); 
        long cantElems = nodeList.getLength();
        traza("cantElems: " + cantElems);
        /* Recorro tags <ROW> */        
        for (int i=0; i<cantElems; i++) {
            hshAtributos = new HashMap();
            nodoRow = nodeList.item(i);
            nodeListCampos = nodoRow.getChildNodes();
            long cantCampos = nodeListCampos.getLength();
            /* Recorro tags <CAMPO> */
            for (int j=0; j<cantCampos; j++) {
                nodoCampo = nodeListCampos.item(j);
                sPropiedad = this.obtenerPropiedadCampo(nodoCampo);
                sValorCampo = this.obtenerValorCampo(nodoCampo);
                hshAtributos.put(sPropiedad, sValorCampo);
            }
            dto = this.armaDTOLineaOperacion(hshAtributos);
            posicionesOperacion.add(dto);
        }
        return posicionesOperacion;
    }
    
    
  /**
   * @author: ssantana, 22/03/2006
   * @throws java.lang.Exception
   * @return DTOLineaOperacionAuxiliarREC 
   * @param HashMap hshMap
   */
    private DTOLineaOperacionAuxiliarREC armaDTOLineaOperacion(HashMap hshMap)
          throws Exception { 
        DTOLineaOperacionAuxiliarREC dto = null;
        Object obj = null;
        dto = new DTOLineaOperacionAuxiliarREC();
        traza("hshMap: " + hshMap);
        
        traza("1");
        obj = hshMap.get("N. linea");
        dto.setNumLinea((Long)this.chequeaNulos(obj,"L"));
        
        traza("2");        
        obj = hshMap.get("OidTipoMovimiento"); 
        dto.setOidTipoMovimiento((Long) this.chequeaNulos(obj,"L"));
        
        traza("3");
        obj = hshMap.get("N. unid. reclamadas"); 
        dto.setUReclamadas((Long) this.chequeaNulos(obj,"L"));
        
        traza("4");
        obj = hshMap.get("Oid MotivoDevolucion"); 
        dto.setOidMotivoDevolucion((Long) this.chequeaNulos(obj,"L"));
        
        traza("5");
        obj = hshMap.get("Precio producto"); 
        dto.setPrecioProducto((Double) this.chequeaNulos(obj,"D"));
        
        traza("6");
        obj = hshMap.get("Importe cargo"); 
        dto.setImporteCargo((Double) this.chequeaNulos(obj,"D"));
        
        traza("7");
        obj = hshMap.get("Importe abono"); 
        dto.setImporteAbono((Double) this.chequeaNulos(obj,"D"));
        
        traza("8");
        obj = hshMap.get("N. unid. devueltas");
        dto.setUDevueltas((Long) this.chequeaNulos(obj, "L"));
        
        traza("9");
        obj = hshMap.get("MFCA_OID_CABE");
        dto.setOidCodigoVenta((Long) this.chequeaNulos(obj, "L"));
        
        traza("10");
        obj = hshMap.get("Oid Producto");
        dto.setOidCodigoProducto((Long) this.chequeaNulos(obj, "L"));
        
        traza("11");
        obj = hshMap.get("Monto Perdida");
        dto.setMontoPerdida((Double) this.chequeaNulos(obj, "D"));
        
        traza("12");
        obj = hshMap.get("Descuento");
        dto.setDescuentoUnitario((Double) this.chequeaNulos(obj, "D"));

		traza("12 B");
        obj = hshMap.get("OidTipoOferta");
		dto.setOidTipoOferta((Long)this.chequeaNulos(obj, "L"));

        traza("13");
        dto.setMotivoDevolucion((String) hshMap.get("Motivo devolucion"));
        dto.setTipoMovimiento((String) hshMap.get("Tipo movimiento"));            
        dto.setCodVenta((String) hshMap.get("Cod. venta") );
        dto.setCodProducto((String) hshMap.get("Cod. producto") );
        dto.setDescProducto((String) hshMap.get("Descripcion producto"));
		obj = hshMap.get("Oid Posicion Solic");
		dto.setOidPosicionSolicitud((Long)this.chequeaNulos(obj, "L"));
		obj = hshMap.get("Oid Concurso");
		dto.setOidConcurso((Long)this.chequeaNulos(obj, "L"));
		obj = hshMap.get("Oid Nivel");
		dto.setOidNivel((Long)this.chequeaNulos(obj, "L"));
		obj = hshMap.get("Oid Premio");
		dto.setOidPremio((Long)this.chequeaNulos(obj, "L"));

		traza("4");
        obj = hshMap.get("Importe Contable"); 
    	obj = obj.toString().replaceAll("," , "");
        dto.setPrecioContable((Double) this.chequeaNulos(obj,"D"));
		
		traza("DTOLineaOperacionAuxiliarREC: " + dto);
        
        return dto;
          
    }
    
  /**
   * @author: ssantana, 22/03/2006
   * @throws java.lang.Exception
   * @return Object
   * @param String sTipoDato
   * @param Object o
   */
    private Object chequeaNulos(Object o, String sTipoDato) 
          throws Exception {
          
       Object oRetorno = null;
	   if(o != null && !o.equals("undefined")){ 
	   // 20080770
	   o = o.toString().replaceAll("," , "");
		//20080770 FIN
	   /* Long */        
	   if (sTipoDato.equals("L") ) {  
          if (o != null && !o.toString().trim().equals("") ) {
            oRetorno = Long.valueOf(o.toString().trim());
          }
       } 
       
       /* Integer */        
       if (sTipoDato.equals("I") ) {  
          if (o != null && !o.toString().trim().equals("") ) {
            oRetorno = Integer.valueOf(o.toString().trim());
          }         
       }
       
       /* Double */       
       if (sTipoDato.equals("D") ) {  
          if (o != null && !o.toString().trim().equals("") ) {
            oRetorno = Double.valueOf(o.toString().trim());
          }         
       }
	  }
	   return oRetorno;
    }
    
  /**
   * @author: ssantana, 18/03/2006
   * @throws java.lang.Exception
   * @return String
   * @param Node nodo
   * @param String sNombreAtributo
   */
    private String obtenerPropiedadCampo(Node nodo) 
          throws Exception {
      NamedNodeMap nodeMap = nodo.getAttributes();
      Node nAtributo = nodeMap.getNamedItem("nombre");
      String sValorAtributo = nAtributo.getNodeValue();
      
      return sValorAtributo;
    }
    
  /**
   * @author: ssantana, 18/03/2006
   * @throws java.lang.Exception
   * @return String
   * @param Node nodo
   */
    private String obtenerValorCampo(Node nodo) 
          throws Exception {
        Node textNode = nodo.getFirstChild();
        String sValorCampo = null;
        if (textNode != null) { 

          sValorCampo = textNode.getNodeValue();
        } else {
          sValorCampo = "";
        }
        return sValorCampo;
    }

    
    

  /**
   * @author: ssantana, 07/03/2006
   * @throws java.lang.Exception
   */
    private void asignarSecuencial() throws Exception {
        traza("LPOperacionReclamo.asignarSecuencial():Entrada");
        
       /* String sNumAtencion = 
                this.conectorParametroLimpia("numAtencion", "", true);
        String sNumSecuencial = 
                this.conectorParametroLimpia("numeroSecuencialOperacion", "", true);
        Integer numSecuencial = null;
        
        if (sNumSecuencial != null && sNumSecuencial.length() == 0) {
           traza("Num. Secuencial es ''");
           Vector vParams = new Vector();
           DTOAtencionReclamoREC dtoAtencion = new DTOAtencionReclamoREC();
           MareBusinessID bussId = new MareBusinessID("RECObtenerSecuencial");
           DruidaConector con = null;
           
           dtoAtencion.setNumAtencion( Long.valueOf(sNumAtencion) );
           dtoAtencion.setOidIdioma(UtilidadesSession.getIdioma(this));
           dtoAtencion.setOidPais(UtilidadesSession.getPais(this));
           
           vParams.add(dtoAtencion);
           vParams.add(bussId);
           
           con = this.conectar("ConectorObtenerSecuencialREC", vParams);
                                              
           DTOSalida dtoSalida = (DTOSalida) con.objeto("DTOSalida");
           
           RecordSet rs = dtoSalida.getResultado();
           numSecuencial = (Integer) rs.getValueAt(0,0);
        } else {
           traza("Num. Secuencial es " + sNumSecuencial);
           numSecuencial = Integer.valueOf(sNumSecuencial);
           numSecuencial = new Integer(numSecuencial.intValue() + 1);
        }
        traza("Num. Secuencial: " + numSecuencial);
        
        this.asignarAtributo("VAR", 
                             "numSecuencial", 
                             "valor", 
                             numSecuencial.toString() );

        this.asignarAtributo("LABELC", 
                             "lblNumSecOperX", 
                             "valor", 
                             numSecuencial.toString() );*/
        /* 
         * Segun lo hablado con DT, solamente se recibe el parametro de la 
         * pantalla llamante y lo muestro en el label (20/03/2006) 
         */
        String sNumSecuencial = 
                this.conectorParametroLimpia("numeroSecuencialOperacion", 
                                             "",
                                            true);
                                            
        this.asignarAtributo("LABELC", 
                             "lblNumSecOperX", 
                             "valor", 
                             sNumSecuencial);
        traza("LPOperacionReclamo.asignarSecuencial():Salida");
    }

    private void mostrarPgDetalleBuscarProducto() throws Exception {
            traza("*** HSH Entrada -  LPOperacionReclamos- detalleProducto ***");
        	pagina("contenido_producto_no_buscar_detalle"); 
        	traza("Reclamadas " + conectorParametroLimpia("unidadesReclamadas","", true));
        	traza("Recibidas " + conectorParametroLimpia("unidadesRecibidas","", true));
			String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
			String separadorMiles = ",";
			if (separadorDecimales.equals(",")) separadorMiles = ".";
			asignar("VAR","unidadesReclamadas", conectorParametroLimpia("unidadesReclamadas","", true));
			asignar("VAR","unidadesRecibidas", conectorParametroLimpia("unidadesRecibidas","", true));
			asignar("VAR","hid_SeparadorMiles", separadorMiles);
			asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
			asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
			this.cargarComboMotivo();
			getConfiguracionMenu("LPOperacionReclamos", "detalleProducto");
            traza("*** HSH Salida -  LPOperacionReclamos- detalleProducto ***");
    }

/*
     private void cargarComboMotivo() throws Exception {
            traza("*** HSH Entrada -  LPOperacionReclamos- cargarComboMotivo ***");

            ComposerViewElementList listelem = new ComposerViewElementList();
            ComposerViewElement elem = null;

            DTOBelcorp dtoBelcorp = new DTOBelcorp();
            dtoBelcorp.setOidPais(this.pais);
            dtoBelcorp.setOidIdioma(this.idioma);
   
            elem = new ComposerViewElement(); 
            elem.setIDBusiness("RECObtenerMotivosDevolucion");
            elem.setDTOE(dtoBelcorp);
            listelem.addViewElement(elem);
       
            // Llamamos al subsistema GestorCargaPantalla. 
            ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
            conector.ejecucion();
            DruidaConector conConsulta = conector.getConector();
                    
            asignar("COMBO", "cbMotivoDevolucion", conConsulta, "RECObtenerMotivosDevolucion");

            traza("*** HSH Salida -  LPOperacionReclamos- cargarComboMotivo ***");
    }
*/

	/**
	* Autor: Marcelo J. Maidana
	* Fecha:
	* Cambiado por inc. 21603.
	*/
    private void cargarComboMotivo() throws Exception {
        traza("*** HSH Entrada -  LPOperacionReclamos- cargarComboMotivo ***");

        //DTOBelcorp dtoBelcorp = new DTOBelcorp();
        //dtoBelcorp.setOidPais(this.pais);
        //dtoBelcorp.setOidIdioma(this.idioma);

        traza("oidOperacion: " + this.oidOperacion);
    
        DTOOID dto = new DTOOID();
        dto.setOidPais(this.pais);
        dto.setOidIdioma(this.idioma);
        dto.setOid(Long.valueOf(this.oidOperacion));
    
        MareBusinessID id = new MareBusinessID("RECObtenerMotivosDevolucion");
            
        Vector params = new Vector();
            
        params.add(dto);
        params.add(id);

		DruidaConector con = conectar("ConectorObtenerMotivosDevolucion", params);

		DTOSalida dtos = (DTOSalida)con.objeto("DTOSalida");
		RecordSet rs = null;

        Vector oids = null;
        Vector descs = null;
		Vector oidsValDef = null;

        String sOids = "";
        String sDescs = "";
		String sValDef = "";

		if (dtos != null && dtos.getResultado() != null && !dtos.getResultado().esVacio()){
			rs = dtos.getResultado();
			
            oids = rs.getColumn(0);
            descs = rs.getColumn(1);
			oidsValDef = rs.getColumn(2);

          /*  sOids = oids.toString();
            sDescs = descs.toString();*/

			for (int i = 0; i < oids.size(); i++){
               sOids += oids.get(i).toString() + ",";
            }

			for (int j = 0; j < descs.size(); j++){
               sDescs += descs.get(j).toString() + ",";
            }



			if (oidsValDef != null && oidsValDef.size() > 0 && oidsValDef.get(0) != null){
				for (int j=0; j<oidsValDef.size();j++){
					traza("valdef: " + oidsValDef.get(j).toString());
					if(oidsValDef.get(j).toString().equals("1")){
						sValDef = oids.get(j).toString();
					}
				}
				
			
			}
			
			//V_REC_04 - cvalenzu - 4/12/2006
            if (sOids != null && sOids.length() >= 1){
                sOids = sOids.substring(0, sOids.length() - 1);
            }
            
            if (sDescs != null && sDescs.length() >= 1){
                sDescs = sDescs.substring(0, sDescs.length() - 1);
            }
			//V_REC_04
            
            traza("*** nuevo sOids: " + sOids);
            traza("*** nuevo sDescs: " + sDescs);
			traza("svalDef: " + sValDef);
            //Setear los valores a la pagina.
            this.asignarAtributo("VAR", "hOidsMotivoDevolucion", "valor", sOids);
            this.asignarAtributo("VAR", "hDescsMotivoDevolucion", "valor", sDescs);
            this.asignarAtributo("VAR", "hOidMotivoDevolucionDefecto", "valor", sValDef);
		}

        traza("*** HSH Salida -  LPOperacionReclamos- cargarComboMotivo ***");
    }

  /**
   * @author: ssantana, 07/03/2006
   * @throws java.lang.Exception
   */
    private void cargarCombo() throws Exception {
       traza("LPOperacionReclamos.cargarCombo(): Entrada");
       DTOBelcorp dtoe = new DTOBelcorp();
       DTOSalida dtoSalida = null;       
       ComposerViewElementList cViewList = new ComposerViewElementList(); 
       /*ComposerViewElement cElem1 = new ComposerViewElement(); */
       ComposerViewElement cElem2 = new ComposerViewElement(); 
       ConectorComposerView cConector = null;
       DruidaConector con = null;
       DruidaConector conOperaciones = null;
       DruidaConector conRowset = null;
       DruidaConector conCombo = null;
       Vector vParams = new Vector();
       RecordSet r = null;

       /* Oid Operacion / Codigo Operacion / Descripcion */
       MareBusinessID bussId = new MareBusinessID("RECObtenerOperacionesAgregar");
       vParams.add(dtoe);
       vParams.add(bussId);
       
       dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
       dtoe.setOidPais(UtilidadesSession.getPais(this));
       
       cElem2.setIDBusiness("RECObtenerMotivosBloqueo");
       cElem2.setDTOE(dtoe);
       
       cViewList.addViewElement(cElem2);
       
       cConector = new ConectorComposerView(cViewList, this.getRequest());
       
       traza("Se conecta por ComposerView...");
       cConector.ejecucion();
       traza("Se conecto!");
       con = cConector.getConector();
       
       traza("Se conecta para RECObtenerOperacionesAgregar..");
       conOperaciones = this.conectar("ConectorObtenerOperacionesAgregarREC", 
                                      vParams);
       traza("Se conecto!");
       dtoSalida = (DTOSalida) conOperaciones.objeto("DTOSalida");
       traza("dtoSalida: " + dtoSalida);
       r = dtoSalida.getResultado();
       
       conRowset = UtilidadesBelcorp.generarConector("rowset", 
                                                     r, 
                                                     r.getColumnIdentifiers());
                                                     
       this.asignar("COMBO", "cbMotivoBloq", con, "RECObtenerMotivosBloqueo"); 
       this.asignar("COMBO", "cbCodOper", conRowset, "rowset");
       this.asignar("MATRIZJS", "lsOperacion", conRowset, "rowset");
       
       traza("LPOperacionReclamos.cargarCombo(): Salida");
       
    }

    private void asignarIdiomaPais() throws Exception {
            traza("*** HSH Entrada -  LPOperacionReclamos- asignarIdiomaPais ***");

            asignar("VAR", "idioma", this.idioma.toString());
            traza("HSH idioma=: "+this.idioma);
            asignar("VAR", "pais", this.pais.toString());    
            traza("HSH pais : "+this.pais);

            traza("*** HSH Salida -  LPOperacionReclamos- asignarIdiomaPais***");
    }

	private String booleanToStr(Boolean boo) throws Exception {
        traza("*** booleanToStrs***: " + boo);
        if (boo != null && boo.booleanValue())
        	return "1";
        return "0";
    }

    // Devuelve cadena de fecha conforme al formato que está en sesion

    private String obtieneCadenaFecha(java.util.Date valor) throws Exception {

        String fecha = new String("");

        if (valor != null) {
            fecha = UtilidadesBelcorp.fechaFormateada(valor, UtilidadesSession.getFormatoFecha(this));
        }
        return fecha;
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());		
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);		
        traza("Stack Trace: " + baos.toString());
    }
    
    
    /**
     * @author Marcelo J. Maidana
     * recupera los motivos de devolucion asociados a la operacion. 
     */
    private void obtenerMotivosDevolucion() throws Exception {
        traza("LPOperacionReclamos.obtenerMotivosDevolucion() - ENTRADA");
    
        DTOOID dto = new DTOOID();
        dto.setOidPais(UtilidadesSession.getPais(this));
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));
        dto.setOid(this.oidOperacion != null ? Long.valueOf(this.oidOperacion) : null);
        
        MareBusinessID id = new MareBusinessID("RECObtenerMotivosDevolucion");
        Vector params = new Vector();
        params.add(dto);
        params.add(id);
        
        DruidaConector con = this.conectar("ConectorObtenerMotivosDevolucion", params);
        DTOSalida dtos = null;
        RecordSet rs = null;
        
        StringBuffer sbOids = new StringBuffer();
        StringBuffer sbDescs = new StringBuffer();
        
        if (con != null){
            dtos = (DTOSalida)con.objeto("DTOSalida");

            if (dtos != null){
                rs = dtos.getResultado();
                
                if (rs != null && !rs.esVacio()){
                    // rs tiene los siguientes campos:
                    // - OID
                    // - DESCRIPCION
                    for (int i = 0; i < rs.getRowCount(); i++){
                        sbOids.append(sbOids.length() == 0 ? rs.getValueAt(i, "OID").toString() : 
                            "," + rs.getValueAt(i, "OID").toString());
                            
                        sbDescs.append(sbDescs.length() == 0 ? rs.getValueAt(i, "DESCRIPCION").toString() : 
                            "," + rs.getValueAt(i, "DESCRIPCION").toString());
                    }
                    
                    // yyy
                    //Verificar que este asignada la pagina contenido_buscar_producto_devuelve
                    this.asignarAtributo("VAR", "hOidsMotivoDevolucion", "valor", sbOids.toString());
                    this.asignarAtributo("VAR", "hDescsMotivoDevolucion", "valor", sbDescs.toString());
                }
            }
        }
        
        traza("LPOperacionReclamos.obtenerMotivosDevolucion() - SALIDA");
    }

	/**
	 * @modified Marcelo J. Maidana
	 * @Date 08/05/2006
	 * Modificado por inc. bloqueante REC01
	 */
    private void comprobarDevuelveFisico() throws Exception{

		traza("LPOperacionReclamos.comprobarDevuelveFisico() - ENTRADA");
        
/*
  Si ingresaDevuelve == true
  {
   Llamar al metodo obtenerMotivosDevolucion pasandole como parametro el valor correspondiente al oid de la Operacion seleccionada en el combo cbCodigoOperacion de la Pagina PgAgregarOperacion
   Si devuelveFisicoFactura != true
   {
    Mostrar la Pantalla PGBuscarProductoDevuelve con el atributo de la Pagina indBuscar = true, devuelveFisicoFactura = false, oidNumDocumento = oidNumDocumento (recibido desde la Pagina PgAgregarOperacion), oidCliente = oidCliente (recibido desde la Pagina PgAgregarOperacion), numeroLinea = ultimo numero secuencial de linea insertada (recibido desde la Pagina PgAgregarOperacion) y controlProductosDevuelve (recibido desde la Pagina PgAgregarOperacion)
    }
   Llamar al metodo comprobarDevuelveFactura
  }
    }*/

	
	traza("ingresaDevuelve: " + ingresaDevuelve);
	traza("devuelveFisicoFactura: " + devuelveFisicoFactura);
	traza("indicador2doDevuelve: " + indicador2doDevuelve);


    if (this.ingresaDevuelve.equals("1")) { 

            this.obtenerMotivosDevolucion();
            traza("Matriz "+this.matriz);
			if(this.matriz.equals("I")){
	            traza("PREMIO");
			}
    			this.pagina("contenido_buscar_producto_devuelve");
			

            // yyy PRUEBA
            this.generarHiddenFormatoNumerico();

            this.cargarComboMotivo();
            this.asignarAtributo("VAR", "indicadorDevuelveProcesado", "valor", indicadorDevuelveProcesado);
            this.asignarAtributo("VAR", "ingresaDevuelve", "valor", ingresaDevuelve != null ? ingresaDevuelve : "");
            this.asignarAtributo("VAR", "ingresaEnvia", "valor", ingresaEnvia != null ? ingresaEnvia : "");
            this.asignarAtributo("VAR", "ind2doDevuelveProcesado", "valor", indicador2doDevuelveProcesado != null ? indicador2doDevuelveProcesado : "");
            this.asignarAtributo("VAR", "datosListaDevuelve", "valor", this.datosListaDevuelve != null ? this.datosListaDevuelve : "");
            this.asignarAtributo("VAR", "oidNumDocumento", "valor", oidNumDocumento != null ? oidNumDocumento.toString() : "");
            this.asignarAtributo("VAR", "oidCliente", "valor", oidCliente != null ? oidCliente.toString() : "");
            this.asignarAtributo("VAR", "numeroLinea", "valor", numeroLinea != null ? numeroLinea.toString() : "");
            this.asignarAtributo("VAR", "tipoMovimiento", "valor", ConstantesREC.MOVIMIENTO_DEVUELVE);
            this.asignarAtributo("VAR", "oidTipoMovimiento", "valor", ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.toString());
            this.asignarAtributo("VAR", "controlProductosDevuelve", "valor", controlProductosDevuelve);
			this.asignarAtributo("VAR", "precioEnvia", "valor", this.precioEnvia);
            this.asignarAtributo("VAR", "enviaFactura", "valor", this.enviaFactura);
			this.asignarAtributo("VAR", "matriz", "valor", this.matriz);
			this.asignarAtributo("VAR", "hRecojo", "valor", this.recojo);

            this.asignarAtributo("VAR", "devuelveFactura", "valor", devuelveFactura);
            //this.asignarAtributo("VAR", "oidOperacion", "valor", ConstantesREC.MOVIMIENTO_DEVUELVE);
            //this.asignarAtributo("VAR", "oidTipoOperacion", "valor", ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.toString());

            this.asignarAtributo("VAR", "oidOperacion", "valor", oidOperacion != null ? oidOperacion : "");
            this.asignarAtributo("VAR", "oidTipoOperacion", "valor", oidTipoOperacion != null ? oidTipoOperacion : "");

			if (!this.devuelveFisicoFactura.equals("1") && (this.indicador2doDevuelve == null || !this.indicador2doDevuelve.equals("1"))) { 
            
            /*    traza("!devuelveFisicoFactura == true");
            
                this.asignarAtributo("VAR", "devuelveFisicoFactura", "valor", "1");
            } else {
            */  if(this.ingresaEnvia.equals("1")){
                    this.indicador2doDevuelve = "1";
                    this.asignarAtributo("VAR", "ind2doDevuelve", "valor", this.indicador2doDevuelve);
                }
                traza("devuelveFisicoFactura == false");
            
                //Mostrar la Pantalla PGBuscarProductoDevuelve con el atributo de la Pagina 
                //indBuscar = true, 
                //devuelveFisicoFactura = false, 
                //oidNumDocumento = oidNumDocumento (recibido desde la Pagina PgAgregarOperacion), 
                //oidCliente = oidCliente (recibido desde la Pagina PgAgregarOperacion) y 
                //numeroLinea = ultimo numero secuencial de linea insertada (recibido desde la Pagina PgAgregarOperacion) 
                this.asignarAtributo("VAR", "indBuscar", "valor", "1");
                this.asignarAtributo("VAR", "devuelveFisicoFactura", "valor", "0");

            } else {
            
				this.comprobarDevuelveFactura();

			}
        }

		traza("LPOperacionReclamos.comprobarDevuelveFisico() - SALIDA");
        
/*
		if (this.ingresaDevuelve.equals("1")) { 
			if (this.devuelveFisicoFactura.equals("1")) { 
				if (this.devuelveFactura.equals("1")) { 
					if (this.pagina.equals("0")) { 
						this.buscarDevuelveSi(); 
						//- Mostrar la ventana PgProductoReclamos donde solo aparecerán visibles los campos lstDevuelveSi y su botón asociado aceptarDevuelveSi 
            			asignar("VAR", "visible", "DevuelveSi");
						//- asignar : - tipoMovimiento =ConstantesRec.MOVIMIENTO_DEVUELVE 
            			asignar("VAR", "tipoMovimiento", ConstantesREC.MOVIMIENTO_DEVUELVE);
            			asignar("VAR", "oidTipoMovimiento", ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.toString());
            			traza("*** ingresaDevuelve=1 AND devuelveFisicoFactura=1 AND devuelveFactura=1 AND pagina=0 => pagina=1");
            			this.pagina = "1";
						asignarHiddenBuscarProducto();
						mostrando = true;
					} 
				} else { //Si devuelveFactura == False 
					if (this.pagina.equals("0")) { 
						//- Mostrar la ventana PgProductoReclamos donde solo aparecerán visibles los campos lstDevuelveNo , su botón asociado aceptarDevuelveNo , descripcion , codigoVenta , codigoProducto , paginaCatalogo y boton buscar 
            			asignar("VAR", "visible", "DevuelveNo");
						//- asignar - tipoMovimiento = ConstantesRec.MOVIMIENTO_DEVUELVE 
            			asignar("VAR", "tipoMovimiento", ConstantesREC.MOVIMIENTO_DEVUELVE);
            			asignar("VAR", "oidTipoMovimiento", ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.toString());
            			traza("*** ingresaDevuelve=1 AND devuelveFisicoFactura=1 AND devuelveFactura=0 AND pagina=0 => pagina=1");
            			this.pagina = "1";
						asignarHiddenBuscarProducto();
						mostrando = true;
					} 
				} 

			} else {	//Si devuelveFisicoFactura == False 
				if (this.pagina.equals("0")) { 
					//- Mostrar la pantalla PgProductosReclamos: solo aparecerán visibles los campos lstDevuelveNo , su botón asociado aceptarDevuelveNo , descripcion , codigoVenta , codigoProducto , paginaCatalogo y boton buscar 
            		asignar("VAR", "visible", "DevuelveNo");
					//- asignar - tipoMovimiento = ConstantesRec.MOVIMIENTO_DEVUELVE 
            		asignar("VAR", "tipoMovimiento", ConstantesREC.MOVIMIENTO_DEVUELVE);
            		asignar("VAR", "oidTipoMovimiento", ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.toString());
            		traza("*** ingresaDevuelve=1 AND devuelveFisicoFactura=0 AND pagina=0 => pagina=2");
            		this.pagina = "2";
					asignarHiddenBuscarProducto();
					mostrando = true;
				} else {
					if (this.devuelveFactura.equals("1")) { 
						if (this.pagina.equals("2")) { 
							this.buscarDevuelveSi(); 
							//- Mostrar la ventana PgProductoReclamos donde solo aparecerán visibles los campos lstDevuelveSi y su botón asociado aceptarDevuelveSi 
	            			asignar("VAR", "visible", "DevuelveSi");
							//- asignar : - tipoMovimiento =ConstantesRec.MOVIMIENTO_DEVUELVE 
            				asignar("VAR", "tipoMovimiento", ConstantesREC.MOVIMIENTO_DEVUELVE);
	            			asignar("VAR", "oidTipoMovimiento", ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.toString());
	            			traza("*** ingresaDevuelve=1 AND devuelveFisicoFactura=0 AND devuelveFactura=1 AND pagina=2 => pagina=3");
	            			this.pagina = "3";
							asignarHiddenBuscarProducto();
							mostrando = true;
						} 
					} else {	//Si devuelveFactura == False 
						if (this.pagina.equals("2")) { 
							//- Mostrar la ventana PgProductoReclamos donde solo aparecerán visibles los campos lstDevuelveNo , su botón asociado aceptarDevuelveNo , descripcion , codigoVenta , codigoProducto , paginaCatalogo y boton buscar 
	            			asignar("VAR", "visible", "DevuelveNo");
							//- asignar - tipoMovimiento = ConstantesRec.MOVIMIENTO_DEVUELVE 
            				asignar("VAR", "tipoMovimiento", ConstantesREC.MOVIMIENTO_DEVUELVE);
	            			asignar("VAR", "oidTipoMovimiento", ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.toString());
	            			traza("*** ingresaDevuelve=1 AND devuelveFisicoFactura=0 AND devuelveFactura=0 AND pagina=2 => pagina=3");
	            			this.pagina = "3";
							asignarHiddenBuscarProducto();
							mostrando = true;
						} 
					} 
				}
			}
		}
*/
    }
}                                                               
