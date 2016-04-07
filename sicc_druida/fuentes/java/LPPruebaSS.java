import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.rec.DTOBloqueoTipoOperacionREC;
import es.indra.sicc.dtos.rec.DTOGeneraOperacionREC;
import es.indra.sicc.dtos.rec.DTOIndicadoresOperacionREC;
import es.indra.sicc.dtos.rec.DTOLineaOperacion;
import es.indra.sicc.dtos.rec.DTOLineaOperacionAuxiliarREC;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession; 

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.mare.common.mln.MareBusinessID;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import java.io.StringBufferInputStream;




public class LPPruebaSS extends LPSICCBase {
    /* Variables globales de Pablito */ 
    
    private static int NUM_FILA = 0;    
    private static int NUM_LINEA = 1;
    private static int TIPO_MOVI = 2;
    private static int OID_TIPO_MOVI = 3;
    private static int COD_VENTA = 4;
    private static int COD_PRODUCTO = 5;
    private static int DESC_PRODUCTO = 6;
    private static int UNIDADES_RECLAMADAS = 7;
    private static int MOTIVO_DEVOLUCION = 8;
    private static int OID_MOTIVO_DEVOLUCION = 9;
    private static int PRECIO_PRODUCTO = 10;
    private static int IMPORTE_CARGO = 11;
    private static int IMPORTE_ABONO = 12;
    private static int UNIDADES_DEVUELTAS = 13;
    private static String SEPA_CAMPO = "|";
    private static String SEPA_LINEA = "@";
    
    private long totalUnidadesReclamadas = 0;
    private long totalUnidadesDevuelve = 0;
    private double totalImporteCargo = 0;
    private double totalImporteAbono = 0;
    
    private Long oidMotivoBloqueo;
    private Long oidEstadoOperacion;
    private String tipoBloqueo;			
    
    private ArrayList posicionesOperacion;

    private Long pais;
    private Long idioma;
    
    private String enviaGeneraDevuelve;
    private String devuelveGeneraEnvia;
    
    

    public LPPruebaSS() {
        super();
    }

    public void inicio() throws Exception {
    }
          
    public void ejecucion() throws Exception {
        setTrazaFichero();
        
        try {
          this.idioma = UtilidadesSession.getIdioma(this);
          this.pais = UtilidadesSession.getPais(this);
          
          String sAccion = this.conectorParametroLimpia("accion", "", true);        
          traza("sAccion: " + sAccion);
          if (sAccion.equals("")) {
            this.mostrarPgAgregarOperacion();
          }
          
          if (sAccion.equals("validarPerdida")) {
            this.validarPerdida();
          }
          
          if (sAccion.equals("calcularMontoPerdida") ) {
            this.calcularMontoPerdida();
          }
          
          if (sAccion.equals("buscarCampanya")) {
            this.buscarCampanya();
          }
          
          if (sAccion.equals("cambiar campanya") ) {
            this.cambiarCampanya();
          }
          
          if (sAccion.equals("guardar operacion") ) {
            this.grabarOperacion();
          }
          
          if (sAccion.equals("obtenerIndicadoresOperacion")) {
            this.obtenerIndicadoresOperacion();
          }
          
        } catch (Exception ex) {
            ex.printStackTrace();
            this.lanzarPaginaError(ex);
        }
    }
    
    
  /**
   * @author: ssantana, 07/03/2006
   * @throws java.lang.Exception
   */
    private void mostrarPgAgregarOperacion() throws Exception {    
    
       /*String sNumAtencion = this.conectorParametroLimpia("numAtencion", "", true);*/
       String sOidNumDocumento = this.conectorParametroLimpia("oidNumDocumento", "", true);
       String sNumDocumento = this.conectorParametroLimpia("numDocumento", "", true);
       String sOidCliente = this.conectorParametroLimpia("oidCliente", "", true);
       String sExisteOperacion = this.conectorParametroLimpia("existeOperacion", "", true);
       
       /* Hardcodeo */ 
       sOidNumDocumento = "4159";
       /* Hardcodeo */
        
       String sPais = UtilidadesSession.getPais(this).toString();
       String sIdioma = UtilidadesSession.getIdioma(this).toString();
       
       this.pagina("contenido_operacion_agregar2");
       this.getFormatosValidaciones();
       this.getConfiguracionMenu("LPOperacionReclamos", "agregarOperacion");
       
       this.asignarAtributo("VAR", "oidNumDocumento", "valor", sOidNumDocumento);
       this.asignarAtributo("VAR", "oidCliente", "valor", sOidCliente);
       this.asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString() );
       this.asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString() );
       this.asignarAtributo("VAR", "existeOperacion", "valor", sExisteOperacion );       
       this.asignarAtributo("VAR", "constantesAsumeCliente", "valor", ConstantesREC.ASUME_CLIENTE.toString());
       this.asignarAtributo("VAR", "constantesPrecioPerdida", "valor", ConstantesREC.PRECIO_PERDIDA_VENTA.toString());
       
       this.asignarAtributo("CAPA", "capa1", "visibilidad", "hidden");
       
       this.cargarCombo();
       this.asignarSecuencial();
       
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
       
       /* Oid Codigo Operacion / Indicador Anulacion */
       /*cElem1.setIDBusiness("RECObtenerIndicadorAnulacionOperaciones");
       cElem1.setDTOE(dtoe);*/
       
       cElem2.setIDBusiness("RECObtenerMotivosBloqueo");
       cElem2.setDTOE(dtoe);
       
       // cViewList.addViewElement(cElem1);
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
       /*this.asignar("MATRIZJS", 
                    "datosAnulacion",
                    con,
                    "RECObtenerIndicadorAnulacionOperaciones");*/
       this.asignar("MATRIZJS", "lsOperacion", conRowset, "rowset");
       
       traza("LPOperacionReclamos.cargarCombo(): Salida");
       
    }
    
  /**
   * @author: ssantana, 07/03/2006
   * @throws java.lang.Exception
   */
    private void asignarSecuencial() throws Exception {
        traza("LPOperacionReclamo.asignarSecuencial():Entrada");
        
        String sNumAtencion = 
                this.conectorParametroLimpia("numAtencion", "", true);
        String sNumSecuencial = 
                this.conectorParametroLimpia("numeroSecuencialOperacion", "", true);
        Integer numSecuencial = null;
        
        if (sNumSecuencial != null && sNumSecuencial.length() == 0) {
           traza("Num. Secuencial es ''");
           Vector vParams = new Vector();
           /* Hardcodeo */
           sNumAtencion = "400000222";
           /* Hardcodeo */ 
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
                             numSecuencial.toString() );

        traza("LPOperacionReclamo.asignarSecuencial():Salida");
    }
    
    
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
    
    
  /**
   * @author: ssantana, 09/03/2006
   * @throws java.lang.Exception
   */
    private void calcularMontoPerdida() throws Exception {
       traza("LPOperacionReclamos.calcularMontoPerdida():Entrada");
       this.pagina("salidaGenerica");
       
       String sOidCliente = 
              this.conectorParametroLimpia("oidClientePerdida", "", true);
       String sOidAsumePerdida = 
              this.conectorParametroLimpia("oidAsumePerdida", "", true);       
       String sOidPrecioCalcula = 
              this.conectorParametroLimpia("oidPrecioCalcula", "", true);
       String sOidPorcentaje = 
              this.conectorParametroLimpia("oidPorcentaje", "", true);
       String sOidProducto = 
              this.conectorParametroLimpia("oidProducto", "", true);
       String sOidClienteSeguro = 
              this.conectorParametroLimpia("oidClienteSeguro", "", true);
       String sImporte =
              this.conectorParametroLimpia("importe", "", true);
                                                              
		/*set("frmContenido.oidCliente", retorno[0]);
		set("frmContenido.oidAsumePerdida", retorno[1]);
		set("frmContenido.oidPrecioCalcula", retorno[2]);
		set("frmContenido.oidPorcentaje", retorno[3]);
		set("frmContenido.oidProducto", retorno[4]);
		set("frmContenido.oidClienteSeguro", retorno[5]);
		set("frmContenido.importe", retorno[6]);*/
              
              
       Long oidAsumePerdida = Long.valueOf(sOidAsumePerdida);
       if (oidAsumePerdida.equals(ConstantesREC.ASUME_CLIENTE) ) {
          Long oidPrecioCalcula = Long.valueOf(sOidPrecioCalcula);
          if (oidPrecioCalcula.equals(ConstantesREC.PRECIO_PERDIDA_VENTA)) {
                            
          } else {
              /* precio perdida es precio Catalogo */
          }
       }
                                                               
    }
    
    
    private void buscarCampanya() throws Exception {
       traza("LPOperacionReclamos.buscarCampanya(): Entrada");
       this.pagina("salidaGenerica");

       DruidaConector con = null;
       DTOSalida dtoSalida = null;
       DTOOID dtoOid = new DTOOID();
       MareBusinessID bussId = new MareBusinessID("RECObtenerCampania");
       Vector vParams = new Vector();
       RecordSet r = null;
       String sOidTipoOperacion = 
              this.conectorParametroLimpia("oidTipoOperacion", "", true);
              
       dtoOid.setOid(Long.valueOf(sOidTipoOperacion));
       dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
       dtoOid.setOidPais(UtilidadesSession.getPais(this));
       
       vParams.add(dtoOid);
       vParams.add(bussId);
       
       con = this.conectar("ConectorObtenerCampaniaREC", vParams);
       
       dtoSalida = (DTOSalida) con.objeto("DTOSalida");
       r = dtoSalida.getResultado();
       
       Long flag = Long.valueOf( r.getValueAt(0,0).toString() );
       
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
    
    
  /**
   * @author: ssantana, 11/03/2006
   * @throws java.lang.Exception
   */
    private void grabarOperacion() throws Exception {
      traza("LPOperacionReclamo.grabarOperacion():Entrada");
      this.pagina("salidaGenerica");
      
      Vector vParams = new Vector();
      MareBusinessID bussId = new MareBusinessID("RECObtenerGeneraOperacion");
      DruidaConector con = null;
      DTOGeneraOperacionREC dtoGeneraOp = null;
      String sExisteOperacion = null;
      String sExisteOperacionAnulacion = null;
      DTOOID dtoOid = new DTOOID();
      
      String sOidOperacion = 
              this.conectorParametroLimpia("oidOperacion", "", true);
      String sIndAnulacion = 
              this.conectorParametroLimpia("hAnulacion", "", true);
      String sChequeoFisico = 
              this.conectorParametroLimpia("sChequeoFisico", "", true);
              
      dtoOid.setOid(Long.valueOf(sOidOperacion));
      dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoOid.setOidPais(UtilidadesSession.getPais(this));
      
      vParams.add(dtoOid);
      vParams.add(bussId);
      
      con = this.conectar("ConectorObtenerGeneraOperacionREC", vParams);
      dtoGeneraOp = (DTOGeneraOperacionREC) con.objeto("DTOGeneraOperacionREC");
            
      /* TODO: Terminar metodo (falta probar integracion con pablito) */ 
      /*this.generarLineasAutomaticas();
      String[] sDatosValidarBloqueo = this.validarBloqueos();*/
      
      String[] sDatosValidarBloqueo = new String[3];
      sDatosValidarBloqueo[0] = "datoPrueba1";
      sDatosValidarBloqueo[1] = "datoPrueba2";
      sDatosValidarBloqueo[2] = "datoPrueba3";
      
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
      StringBuffer sCadenaEjecutar = new StringBuffer("funcionRetorno(");
      if (sExisteOperacionAnulacion != null) { 
         sCadenaEjecutar.append("'sExisteOperacionAnulacion', ");
      } else {
         sCadenaEjecutar.append("'sExisteOperacion', ");
      }
      
      sCadenaEjecutar.append("'" + sChequeoFisico + "', ");
      
      sCadenaEjecutar.append("'" + sDatosValidarBloqueo[0] + ";");
      sCadenaEjecutar.append(sDatosValidarBloqueo[1] + ";");
      sCadenaEjecutar.append(sDatosValidarBloqueo[2] + "', ");
      
      /* TODO: Poner cadena de lista cuando la tenga Pablito */ 
      sCadenaEjecutar.append("'')");
      
      traza("sCAdenaEjecutar: " + sCadenaEjecutar.toString());
      
      /* Establezco qué funcion ejecutar en jscript */ 
      this.asignarAtributo("VAR", "ejecutar", "valor", sCadenaEjecutar.toString());
    }
    
    
  /**
   * @author: ssantana, 14/03/2006
   * @throws java.lang.Exception
   */
    private void obtenerIndicadoresOperacion() throws Exception {
      traza("LPOperacionReclamo.cambiarCampanya():Entrada");
      
      this.pagina("salidaGenerica");
      
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
      
      Boolean bIngresaDevuelve = dtoIndicadores.getIngresaDevuelve();
      Boolean bIngresaEnvia = dtoIndicadores.getIngresaEnvia();
      Boolean bEnviaGeneraDevuelve = dtoIndicadores.getEnviaGeneraDevuelve();
      Boolean bDevuelveGeneraEnvia = dtoIndicadores.getDevuelveGeneraEnvia();
      Boolean bDevuelveFisicoFactura = dtoIndicadores.getDevuelveFisicoFactura();
      Boolean bDevuelveFactura = dtoIndicadores.getDevuelveFactura();
      Boolean bEnviaFactura = dtoIndicadores.getEnviaFactura();
      Boolean bAnulacion = dtoIndicadores.getIndicadorAnulacion();
      Boolean bPerdida = dtoIndicadores.getIndicadorPerdida();
      String  sChequeoFisico = dtoIndicadores.getChequeoFisico();
	  String  sPrecioEnvia = dtoIndicadores.getPrecioEnvia();
      
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
    
    // Se llama en LPOperacionReclamos.grabarOperacion
    private String[] validarBloqueos() throws Exception {

        String[] valoresRetorno = new String[3];
        String motivoBloqueo = conectorParametroLimpia("cbMotivoBloq","", true);
        traza(" Combo MotivoBloqueo: "+ motivoBloqueo);

        if (motivoBloqueo.equals(""))  {// no se ha seleccionado manualmente ningun motivo de bloqueo 

            String oidDocumentoReferencia = conectorParametroLimpia("oidNumDocumento","", true);
            String tipoOperacion = conectorParametroLimpia("cbCodTipoOper","", true);
    
            /*
            - uReclamadas <- sumatorio de campo unidadesReclamadas de la lista lstResultados 
            - uDevueltas <- sumatorio de campo unidadesDevueltas de la lista lstResultados 
            - totalCargo <- sumatorio de campo importeCargo de la lista lstResultados 
            - totalAbono <- sumatorio de campo importeAbono de la lista lstResultados    */
            calcularSumatorias();
            
            /*Crear un DTOOperacionReclamo con: 
            - oidDocumentoReferencia = Procedente de la página 
            - tipoOperacion = oid del valor seleccionado en cbCodigoTipoOperacion 
            - usuario = usuario del sistema */
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

            /*
            Por cada linea de la operación creamos un DTOLineaOperacion con: 
            - oidCodVenta 
            - oidCodProducto  
            Añadimos cada DTOLineaOperacion a DTOOperacionReclamo   */
            dtoOperacionREC.setLineas(obtenerLineas());
    
            /*        
            - Invocar conector ConectorObtenerBloqueosTipoREC enviando el DTOOperacionReclamo creado 
            - Crear IDBusiness="RECObtenerBloqueosTipo" 
            - Recuperar DTO obtenido   */
            MareBusinessID idBusiness = new MareBusinessID("RECObtenerBloqueosTipo");
    
            // Parametros de entrada del conector                     
            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoOperacionREC);
            paramEntrada.add(idBusiness);
            
            DruidaConector conector = conectar("ConectorValidarPerdidaREC", paramEntrada);        
            DTOBloqueoTipoOperacionREC dtoBloqueo = (DTOBloqueoTipoOperacionREC) conector.objeto("DTOBloqueoTipoOperacionREC");
            
            establecerBloqueo(dtoBloqueo);
            
            valoresRetorno[0] = oidMotivoBloqueo.toString();
            valoresRetorno[1] = oidEstadoOperacion.toString();
            valoresRetorno[2] = tipoBloqueo;
            
        }
        return valoresRetorno;
	}
  
    private void establecerBloqueo(DTOBloqueoTipoOperacionREC dtoBloqueo) throws Exception {
        
        if (dtoBloqueo.getBloqueoUnidades() != null)  {
            if (totalUnidadesDevuelve > totalUnidadesReclamadas)  { // Si uDevueltas > uReclamadas
                oidMotivoBloqueo = dtoBloqueo.getBloqueoUnidades();
                oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO;
                tipoBloqueo = ConstantesREC.BLOQUEO_UNIDADES_DEVUELTAS;			
            }
        } else if (dtoBloqueo.getBloqueoImporte() != null)  {
            if ((dtoBloqueo.getImporteMaximo() != null) && (totalImporteCargo > dtoBloqueo.getImporteMaximo().intValue()))  { // Si(dto.importeMaximo <> NULL) y (totalCargo > dto.importeMaximo)
                oidMotivoBloqueo = dtoBloqueo.getBloqueoImporte();
                oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO;
                tipoBloqueo = ConstantesREC.BLOQUEO_IMPORTE_MAXIMO;			
            }
        } else if (dtoBloqueo.getBloqueoDiferencia() != null)  {
            if ((dtoBloqueo.getImporteMaximo() != null) && 
                    ((totalImporteCargo - totalImporteAbono) >  dtoBloqueo.getImporteMaximo().intValue()))  { //Si(dto.montoMaximo <> NULL) y ((totalCargo - totalAbono) > dto.montoMaximo)
                oidMotivoBloqueo = dtoBloqueo.getBloqueoDiferencia();
                oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO;
                tipoBloqueo = ConstantesREC.BLOQUEO_DIFERENCIA_IMPORTES;			
            }
        } else if (dtoBloqueo.getBloqueoAnterior() != null)  {
            oidMotivoBloqueo = dtoBloqueo.getBloqueoAnterior();
            oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_BLOQUEO;
            tipoBloqueo = ConstantesREC.BLOQUEO_RECLAMO_ANTERIOR;			
        }
    }  
    
    private void calcularSumatorias() throws Exception {
        int cantPos = posicionesOperacion.size();
        this.totalUnidadesReclamadas = 0;
        this.totalUnidadesDevuelve = 0;
        this.totalImporteCargo = 0;
        this.totalImporteAbono = 0;
        
        for (int i=0; i<cantPos; i++)  {
            DTOLineaOperacionAuxiliarREC dtoREC = (DTOLineaOperacionAuxiliarREC) posicionesOperacion.get(i);
            this.totalUnidadesReclamadas += dtoREC.getUReclamadas().longValue();
            this.totalUnidadesDevuelve += dtoREC.getUDevueltas().longValue();
            this.totalImporteCargo += dtoREC.getImporteCargo().doubleValue();
            this.totalImporteAbono += dtoREC.getImporteAbono().doubleValue();
        }
    }
    
    private ArrayList obtenerLineas() throws Exception {
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
    
    
    private void generarLineasAutomaticas() throws Exception {
        /*Descripción: genera lineas complementarias segun la parametrizacion de la operacion. 
        
        Implementación: 
        
        // Generar Lineas Automaticas: se muestran en pantalla. 
        // No se almacenan en BD hasta que el usuario selecciona la opcion de menu guardar en la pantalla correspondiente */
        
        /*
        - Se crea un arreglo lstResultado con los registros recibidos de la PgAgregaOperacion de la listaEditable "lstResultado"         */
        obtenerArrayListLineas();
        ArrayList posicionesOperacionGeneradas = new ArrayList();
        int cantLineas = this.posicionesOperacion.size();
        int ultimoNumeroLinea = obtenerUltimoNumeroLinea();
        
        for (int i=0; i< cantLineas ; i++)  {
            traza("Procesando la posicion.... " + i);
            DTOLineaOperacionAuxiliarREC dtoAuxiliarREC = (DTOLineaOperacionAuxiliarREC) this.posicionesOperacion.get(i);
            int tipoMovimiento = dtoAuxiliarREC.getOidTipoMovimiento().intValue();
            
            if ((tipoMovimiento == ConstantesREC.TIPO_MOVIMIENTO_ENVIA.intValue()) &&
                    (enviaGeneraDevuelve.equals("true") )) {
                
                DTOLineaOperacionAuxiliarREC dtoAuxiliarRECGenerado = copiarDTOLineaOperacionAuxiliarREC(dtoAuxiliarREC);
                dtoAuxiliarRECGenerado.setNumLinea(new Long(ultimoNumeroLinea+1));
                dtoAuxiliarRECGenerado.setOidTipoMovimiento(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
                dtoAuxiliarRECGenerado.setTipoMovimiento(ConstantesREC.MOVIMIENTO_DEVUELVE);
                dtoAuxiliarRECGenerado.setImporteCargo(new Double(0));
                posicionesOperacionGeneradas.add(dtoAuxiliarRECGenerado);
                ultimoNumeroLinea++;
            
            } else if ((tipoMovimiento == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.intValue()) && 
                       (devuelveGeneraEnvia.equals("true"))){
            
                DTOLineaOperacionAuxiliarREC dtoAuxiliarRECGenerado = copiarDTOLineaOperacionAuxiliarREC(dtoAuxiliarREC);
                dtoAuxiliarRECGenerado.setNumLinea(new Long(ultimoNumeroLinea+1));
                dtoAuxiliarRECGenerado.setOidTipoMovimiento(ConstantesREC.TIPO_MOVIMIENTO_ENVIA);
                dtoAuxiliarRECGenerado.setTipoMovimiento(ConstantesREC.MOVIMIENTO_ENVIA);
                dtoAuxiliarRECGenerado.setImporteAbono(new Double(0));
                posicionesOperacionGeneradas.add(dtoAuxiliarRECGenerado);
                ultimoNumeroLinea++;
            }
            traza("Termino de Procesar la posicion.... " + i);            
        }
        traza("finalizó el procesamiento de las posiciones.... ");
        this.posicionesOperacion.addAll(posicionesOperacionGeneradas);        
        setearPosicionesPagina();
    }
    
    
    private void obtenerArrayListLineas() throws Exception {
        /* Metodo que genera el atributo ArrayList posicionesOperacion de dtos DTOLineaOperacionAuxiliarREC
         * con las posiciones que se 
         * encuentran en la pagina pgAgregarOperacion*/
        this.posicionesOperacion = new ArrayList();
        String strLineasPosicion = conectorParametroLimpia("hStrLineasPosiciones","",true);
        String[] arrLineasPosicion = construirLineas(strLineasPosicion,SEPA_LINEA);
        
        int cantPos = arrLineasPosicion.length;
        for (int i=0; i< cantPos; i++)  {
            String[] columnas =  construirLineas(arrLineasPosicion[i],SEPA_CAMPO);
            DTOLineaOperacionAuxiliarREC dto = new DTOLineaOperacionAuxiliarREC();
            dto.setNumLinea(Long.valueOf(columnas[NUM_LINEA]));
            dto.setTipoMovimiento(columnas[TIPO_MOVI]);
            dto.setOidTipoMovimiento(Long.valueOf(columnas[OID_TIPO_MOVI]));
            dto.setCodVenta(columnas[COD_VENTA]);
            dto.setCodProducto(columnas[COD_PRODUCTO]);
            dto.setDescProducto(columnas[DESC_PRODUCTO]);
            dto.setUReclamadas(Long.valueOf(columnas[UNIDADES_RECLAMADAS]));
            dto.setMotivoDevolucion(columnas[MOTIVO_DEVOLUCION]);
            dto.setOidMotivoDevolucion(Long.valueOf(columnas[OID_MOTIVO_DEVOLUCION]));
            dto.setPrecioProducto(Double.valueOf(columnas[PRECIO_PRODUCTO]));
            dto.setImporteCargo(Double.valueOf(columnas[IMPORTE_CARGO]));
            dto.setImporteAbono(Double.valueOf(columnas[IMPORTE_ABONO]));
            dto.setUDevueltas(Long.valueOf(columnas[UNIDADES_DEVUELTAS]));
            this.posicionesOperacion.add(dto);
        }
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
    
    private void setearPosicionesPagina() throws Exception {
        StringBuffer strPosiciones = new StringBuffer();
        int cantPos = this.posicionesOperacion.size();
        
        for (int i=0; i<cantPos; i++)  {
            DTOLineaOperacionAuxiliarREC dtoREC = (DTOLineaOperacionAuxiliarREC) this.posicionesOperacion.get(i);
            strPosiciones.append(dtoREC.getNumLinea() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getTipoMovimiento() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getOidTipoMovimiento() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getCodVenta() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getCodProducto() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getDescProducto() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getUReclamadas() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getMotivoDevolucion() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getOidMotivoDevolucion() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getPrecioProducto() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getImporteCargo() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getImporteAbono() + SEPA_CAMPO);
            strPosiciones.append(dtoREC.getUDevueltas()+ SEPA_LINEA);  
        }
        
        strPosiciones.deleteCharAt(strPosiciones.length()-1);
        asignarAtributo("VAR", "hStrLineasPosiciones","valor", strPosiciones.toString());
    }
    
    private int obtenerUltimoNumeroLinea() throws Exception {
        int size = this.posicionesOperacion.size();
        DTOLineaOperacionAuxiliarREC dto = (DTOLineaOperacionAuxiliarREC) this.posicionesOperacion.get(size - 1);
        return dto.getNumLinea().intValue();
    }

    public static DTOLineaOperacionAuxiliarREC copiarDTOLineaOperacionAuxiliarREC(DTOLineaOperacionAuxiliarREC dtoEntrada){
        DTOLineaOperacionAuxiliarREC dto = new DTOLineaOperacionAuxiliarREC();
        dto.setCodProducto(dtoEntrada.getCodProducto());        
        dto.setCodVenta(dtoEntrada.getCodVenta());
        dto.setDescProducto(dtoEntrada.getDescProducto());
        dto.setImporteAbono(dtoEntrada.getImporteAbono());
        dto.setImporteCargo(dtoEntrada.getImporteCargo());
        dto.setMotivoDevolucion(dtoEntrada.getMotivoDevolucion());
        dto.setNumLinea(dtoEntrada.getNumLinea());
        dto.setOidMotivoDevolucion(dtoEntrada.getOidMotivoDevolucion());
        dto.setOidTipoMovimiento(dtoEntrada.getOidTipoMovimiento());
        dto.setPrecioProducto(dtoEntrada.getPrecioProducto());
        dto.setTipoMovimiento(dtoEntrada.getTipoMovimiento());
        dto.setUReclamadas(dtoEntrada.getUReclamadas());
        dto.setUDevueltas(dtoEntrada.getUDevueltas());
        return dto;
    }        
    
    
  /**
   * @author: ssantana, 16/03/2006
/   * @throws java.lang.Exception
   * @return String[][]
   * @param sXml
   */
    private String[][] parseaLista(String sXml)  throws Exception {

        DocumentBuilderFactory docBuilderFactory = 
                DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sXml.getBytes());
        //StringBufferInputStream inputStream = new StringBufferInputStream(sXml); 
        Node nodeDoc = docBuilder.parse(inputStream).getFirstChild();
        
        NodeList nodeList = nodeDoc.getChildNodes(); 
        long cantElems = nodeList.getLength();
        
        Node nodoRow = null;
        NodeList nodeListCampos = null;        
        /* Recorro tags <ROW> */
        for (int i = 0; i < cantElems; i++) {
           nodoRow = nodeList.item(i);
           traza("<ROW>");
           nodeListCampos = nodoRow.getChildNodes();
           Node nodoCampo = null;
           /* Recorre tags <CAMPO> y obtiene el valor */ 
           for (int j = 0; j < nodeListCampos.getLength(); j++) {
               nodoCampo = nodeListCampos.item(j);
               Node textNode = nodoCampo.getFirstChild();
               traza("<CAMPO>" + textNode.getNodeValue() + "</CAMPO>");
               textNode.getNodeValue();
           }
           traza("</ROW>");
        }
        return null;
      
    }
    
    
    
    
}