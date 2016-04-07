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
 *
 */
 

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.bel.DTOCaja;
import es.indra.sicc.dtos.bel.DTOCargaPaginaMCD;
import es.indra.sicc.dtos.bel.DTOMovimientoCaja;
import es.indra.sicc.dtos.bel.DTOMovimientoCajaDetalle;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.util.DTOSalida;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;



public class LPRealizarMovimientoCaja extends LPSICCBase {
    //definicion de variables
    String accion = null;
    String casoDeUso = null;
    Long pais = null;
    Long idiomaUsuario = null;
    String ipCliente = null;
    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;
    private boolean debugging = false;

    // Definicion del constructor
    public LPRealizarMovimientoCaja() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        TiempoDeCargaInicio = System.currentTimeMillis();

        this.rastreo();
        setTrazaFichero();        

        accion = this.conectorParametroLimpia("accion", "", true);
        casoDeUso = this.conectorParametroLimpia("casoDeUso", "", true);
        if (debugging) {
          ipCliente = "192.168.119.144";
          idiomaUsuario = new Long(1);
          pais = new Long(1);
        } else {
          ipCliente = UtilidadesBelcorp.getIPCliente(this);
          idiomaUsuario = UtilidadesSession.getIdioma(this);
		  traza("idiomaUsuario "+ idiomaUsuario );
          pais = UtilidadesSession.getPais(this);
		  traza("pais " + pais);
		  
        }

        try {
            if (accion.equals("")) {
                cargarPagina();
            } else if (accion.equals("añadir")) {
                añadir();
            } else if (accion.equals("modificar")) {
                modificar();
            } else if (accion.equals("guardar")) {
                guardar();
				cargarPagina();
            }

            TiempoDeCargaFin = System.currentTimeMillis();
            traza("El tiempo de carga de LPRealizarMovimientoCaja es :" +
                (TiempoDeCargaFin - TiempoDeCargaInicio));
        } catch (Exception e) {
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    }
  /** 
   * Método para cargar la pagina principal
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */    
    private void cargarPagina() throws Exception {
    traza("1");
        pagina("contenido_movimiento_caja_realizar");
        generarHiddenFormatoFecha();
        getFormatosValidaciones();
        this.getConfiguracionMenu("LPRealizarMovimientoCaja", "");
traza("2");
        DTOString dtos = new DTOString();
        traza("ipCliente "+this.ipCliente);
        dtos.setCadena(this.ipCliente);
        dtos.setOidPais(this.pais);
        dtos.setOidIdioma(this.idiomaUsuario);
traza("3");
        MareBusinessID bid = new MareBusinessID("BELObtenerDatosCaja");
        Vector vec = new Vector();
        vec.add(dtos);
        vec.add(bid);
traza("4");        
        DTOCaja caja = (DTOCaja) conectar("ConectorObtenerDatosCaja",vec).objeto("dtoSalida");

        traza("caja.getEstadoCaja "+caja.getEstadoCaja());
        if (caja.getEstadoCaja()!=null&&
            (!caja.getEstadoCaja().trim().equals(""))&&
            new Character(caja.getEstadoCaja().trim().charAt(0)).equals(ConstantesBEL.CAJA_CERRADA)){
            throw new MareException(new Exception(),30103);
            //VER -> No mostrar página, volver a la página de inicio 
        } else {
            asignarAtributo("LABELC","lbldtCanal","valor",((caja.getCodigoCanal()!=null)?caja.getCodigoCanal():""));
            asignarAtributo("LABELC","lbldtAcceso","valor",((caja.getCodigoAcceso()!=null)?caja.getCodigoAcceso():""));
            asignarAtributo("LABELC","lbldtSubacceso","valor",((caja.getCodigoSubacceso()!=null)?caja.getCodigoSubacceso():""));            
            asignarAtributo("LABELC","lbldtCaja","valor",((caja.getCodigoCaja()!=null)?caja.getCodigoCaja():""));
            String fecha = obtenerFechaFormatoPais(caja.getFecha());
            asignarAtributo("LABELC","lbldtFecha","valor",((caja.getFecha()!=null)?fecha:""));
            asignarAtributo("LABELC","lbldtNumMovimiento","valor",((caja.getNumeroMovimiento()!=null)?caja.getNumeroMovimiento():""));
            asignarAtributo("LABELC","lbldtCanal","valor",((caja.getCodigoCanal()!=null)?caja.getCodigoCanal():""));
            asignarAtributo("VAR","oidCanal","valor",((caja.getOidCanal()!=null)?caja.getOidCanal().toString():""));
            asignarAtributo("VAR","oidAcceso","valor",((caja.getOidAcceso()!=null)?caja.getOidAcceso().toString():""));
            asignarAtributo("VAR","oidSubacceso","valor",((caja.getOidSubacceso()!=null)?caja.getOidSubacceso().toString():""));
            asignarAtributo("VAR","oidCaja","valor",((caja.getOidCaja()!=null)?caja.getOidCaja().toString():""));
            asignarAtributo("VAR","habAniadir","valor","true");
            asignarAtributo("VAR","habModificar","valor","false");
            asignarAtributo("VAR","habEliminar","valor","true");
            if (debugging) {
              asignarAtributo("VAR","hUsuario","valor","USUARIO1");
            } else {              
              asignarAtributo("VAR","hUsuario","valor",((UtilidadesSession.getIdUsuario(this)!=null)?UtilidadesSession.getIdUsuario(this):""));
            }
            asignarAtributo("VAR","hNumMovimiento","valor",((caja.getNumeroMovimiento()!=null)?caja.getNumeroMovimiento():""));
            asignarAtributo("VAR","hFecha","valor",((caja.getFecha()!=null)?fecha:""));         
        }        
    }
  /** 
   * Método para abrir la pagina que agrega un detalle al movimiento de caja
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */
    private void añadir() throws Exception {
        cargarPaginaDetalle();
    }
  /** 
   * Método para abrir la pagina que modifica un detalle al movimiento de caja
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */
    private void modificar() throws Exception {
/*
    -> Llamar al método "cargarPaginaDetalle()" 
-> Mapear el registro seleccionado en la lista "detalle" de la página 
"contenido_movimiento_caja_realizar" en la pantalla
"contenido_movimiento_caja_realizar_detalle"
*/
      String tipoMovimientoCaja = conectorParametro("tipoMovimientoCaja");
      String medioPago = conectorParametro("medioPago");
      String moneda = conectorParametro("Moneda");
      String importe = conectorParametro("importe");
      String importeDivisa = conectorParametro("importeDivisa");
      String nroCheque = conectorParametro("nroCheque");
      String banco = conectorParametro("Banco");
      String tipoTarjeta = conectorParametro("tipoTarjeta");
      String nroTarjeta = conectorParametro("nroTarjeta");
      String nroValeCompra = conectorParametro("nroValeCompra");
      String oidTipoMovimientoCaja = conectorParametro("oidTipoMovimientoCaja");
      String oidMedioPago = conectorParametro("oidMedioPago");
      String oidMoneda = conectorParametro("oidMoneda");
      String oidBanco = conectorParametro("oidBanco");
      String oidTipoTarjeta = conectorParametro("oidTipoTarjeta");
      
      traza("tipoMovimientoCaja " + tipoMovimientoCaja);traza("medioPago " + medioPago); 
      traza("moneda " + moneda);traza("importe " + importe);traza("importeDivisa " + importeDivisa);
      traza("nroCheque " + nroCheque); 
      traza("banco " + banco);traza("tipoTarjeta " + tipoTarjeta);traza("nroTarjeta " + nroTarjeta);
      traza("nroValeCompra " + nroValeCompra);traza("oidTipoMovimientoCaja " + oidTipoMovimientoCaja);
      traza("oidMedioPago " + oidMedioPago);traza("oidMoneda " + oidMoneda);traza("oidBanco " + oidBanco); 
      traza("oidTipoTarjeta " + oidTipoTarjeta); 
      
      cargarPaginaDetalle();    

      asignarAtributo("CTEXTO","txtImporte","valor",importe);//importe
      asignarAtributo("CTEXTO","txtImporteDivisa","valor",importeDivisa);//importeDivisa      
      asignarAtributo("CTEXTO","txtNumCheque","valor",nroCheque);//nroCheque
      asignarAtributo("CTEXTO","txtNumTarjeta","valor",nroTarjeta);//nroTarjeta
      asignarAtributo("CTEXTO","txtNumvaleCompra","valor",nroValeCompra);//nroValeCompra
      asignarAtributo("VAR","oidTipoMovimiento","valor",oidTipoMovimientoCaja);//oidTipoMovimientoCaja
      asignarAtributo("VAR","oidMedioPago","valor",oidMedioPago);//oidMedioPago
      asignarAtributo("VAR","oidMoneda","valor",oidMoneda);//oidMoneda
      asignarAtributo("VAR","oidBanco","valor",oidBanco);//oidBanco
      asignarAtributo("VAR","oidTipoTarjeta","valor",oidTipoTarjeta);//oidTipoTarjeta
      asignarAtributo("VAR", "cteTipoMedioPagoCheque", "valor", ConstantesBEL.TIPO_MP_CHEQUE.toString());
      asignarAtributo("VAR", "cteTipoMedioPagoTarjeta", "valor", ConstantesBEL.TIPO_MP_TARJETA.toString());
      asignarAtributo("VAR", "cteTipoMedioPagoVales", "valor", ConstantesBEL.TIPO_MP_VALES_COMPRA.toString());
    }
  /** 
   * Método para cargar los datos iniciales en la pagina del detalle de movimiento
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */
    private void cargarPaginaDetalle() throws Exception {
/*
 * -> Crear un objeto DTOBelcorp con pais e idioma de la sesión 
-> Obtener oidSubacceso de la página llamante "contenido_movimiento_caja_realizar" 
-> Crear un objeto DTOOID con el oid de subacceso y el pais e idioma de la sesión 
-> Llamar al subsistema GestorCargaPantalla con la siguiente información 
- idBusiness = "BELObtenerTiposMovimientosCajaManuales" y DTOBelcorp => carga el combo "tipoMovimientoCaja" 
- idBusiness = "MAEObtenerTiposTarjeta" y DTOBelcorp => carga el combo "tipoTarjeta" 
- idBusiness = "CCCObtieneBancos" y DTOBelcorp => carga el combo "banco" 
-> Crear idBusiness = "BELCargaPaginaMCD" 
-> Crear objeto DTOOID con oidSubacceso de pantalla 
-> Asignar conector "ConectorCargaPaginaMCD" con idBusiness creado y el DTOOID creado 
-> Mapear en pantalla el DTOCargaPaginaMCD de respuesta del siguiente modo: 
-> Llenar el combo moneda con oid y descripción de la moneda alternativa 
-> Llenar la variable oculta "varTipoCambio" con el tipo de cambio que viene en el dto 
-> Tomar el valor del atributo "mediosDePago", que es un RecordSet y mapearlo en el combo
"mediosPagoBelcenter", manteniendo en oculto para cada medio de pago,
el campo "OID_TIPO_MEDI_PAGO"
 */
      Long oidSubacceso = (conectorParametro("oidSubacceso")!=null?new Long(conectorParametro("oidSubacceso").toString()):null);
      traza("oidSubacceso"+oidSubacceso);
      
      pagina("contenido_movimiento_caja_realizar_detalle");
      getFormatosValidaciones();
      this.getConfiguracionMenu("LPRealizarMovimientoCaja","detalle");
      
      DTOBelcorp dtoB = new DTOBelcorp();
      dtoB.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoB.setOidPais(UtilidadesSession.getPais(this));
      
      DruidaConector conectorSigno = null;
      
      Vector parametros = new Vector();
      MareBusinessID mareBid = new MareBusinessID("BELObtenerSignoTipoMovimiento");
      
      parametros.add(dtoB);
      parametros.add(mareBid);
      traza("antes de generar el tema de signo")  ;
      conectorSigno = conectar("ConectorSignoTipoMovimiento",parametros);      
      traza("antes de generar el tema de signo 2 ") ;
      
      DTOSalida dtoSal = (DTOSalida) conectar("ConectorSignoTipoMovimiento",parametros).objeto("dtoSalida"); 
      traza("antes de generar el tema de signo 3 ")  ;
      
      RecordSet signo = (RecordSet)dtoSal.getResultado();
      traza("antes de generar el tema de signo 4 ")  ;
      Vector colSigno = signo.getColumnIdentifiers();
      traza("antes de generar el tema de signo 5 ")  ;
      DruidaConector signos = generarConector("DTOSalida.signos_ROWSET",signo, colSigno);
  	  traza("antes de generar el tema de signo 6")  ;
      traza("signooooo "+dtoSal.getResultado());
      traza("signoooo2222 "+dtoSal.getResultado().getColumnIdentifiers());
      this.crearListaLP(colSigno, signo.getColumnCount(), "Capa2","Lista2", "14", "200");
  	  traza("antes de generar el tema de signo 7")  ;
      asignar("LISTA", "Lista2", signos, "DTOSalida.signos_ROWSET");     
      
      
      DTOOID dtooid = new DTOOID();
      dtooid.setOid(oidSubacceso);
      dtooid.setOidPais(this.pais);
      dtooid.setOidIdioma(new Long(1));//HAY VA EL IDIOMA POR DEFECTO (ESP) por eso 1   
      

      cargaCombos();//combos tipoMovimientoCaja tipoTarjeta banco

      MareBusinessID bid = new MareBusinessID("BELCargaPaginaMCD");
      Vector vec = new Vector();
      vec.add(dtooid);
      vec.add(bid);
        
      DTOCargaPaginaMCD dtoSalida = (DTOCargaPaginaMCD) conectar("ConectorCargaPaginaMCD",vec).objeto("dtoSalida");

      //asignarAtributo("LABELC","lbldtTipoCambio","valor",((dtoSalida.getTipoCambio()!=null)?dtoSalida.getTipoCambio().toString():""));
      
      asignarAtributo("VAR","varOidMonedaAlternativa","valor",((dtoSalida.getOidMonedaAlternativa()!=null)?dtoSalida.getOidMonedaAlternativa().toString():""));
      asignarAtributo("VAR","varTipoCambio","valor",((dtoSalida.getTipoCambio()!=null)?dtoSalida.getTipoCambio().toString():""));
      traza("mediopago "+dtoSalida.getMediosDePago());
      traza("mediopagocol "+dtoSalida.getMediosDePago().getColumnIdentifiers());
      asignar("COMBO","cbMedioPago",UtilidadesBelcorp.generarConector("dtoSalida", dtoSalida.getMediosDePago(),dtoSalida.getMediosDePago().getColumnIdentifiers()), "dtoSalida");     
	  
	    traza("antes de crear lista oculta");
	    RecordSet mediosPago = (RecordSet) dtoSalida.getMediosDePago();
  	  traza("paso 1");
      Vector colMediosPago = mediosPago.getColumnIdentifiers();
  	  traza("paso 2");
      DruidaConector medioPago = generarConector("DTOSalida.mediosPago_ROWSET",mediosPago, colMediosPago);
  	  traza("paso 3");
      this.crearListaLP(colMediosPago, mediosPago.getColumnCount(), "Capa1","Lista1", "14", "200");
  	  traza("paso 4");
      asignar("LISTA", "Lista1", medioPago, "DTOSalida.mediosPago_ROWSET");
      
	  cargarMonedaAlternativa(dtoSalida);
      asignarAtributo("VAR", "cteTipoMedioPagoCheque", "valor", ConstantesBEL.TIPO_MP_CHEQUE.toString());
      asignarAtributo("VAR", "cteTipoMedioPagoTarjeta", "valor", ConstantesBEL.TIPO_MP_TARJETA.toString());
      asignarAtributo("VAR", "cteTipoMedioPagoVales", "valor", ConstantesBEL.TIPO_MP_VALES_COMPRA.toString());
      
    }

    // Carga la moneda alternativa en el combo correspondiente
    private void cargarMonedaAlternativa(DTOCargaPaginaMCD dtoSalida) throws Exception{
      RecordSet recordSet = new RecordSet();
      
      if (dtoSalida.getOidMonedaAlternativa()!=null){       
        llenarRecordSetMoneda(recordSet);
        recordSet.addRow(new Vector());
        recordSet.setValueAt(dtoSalida.getOidMonedaAlternativa(), 0, 0);
        recordSet.setValueAt(dtoSalida.getDescripcionMonedaAlternativa(), 0, 1);
      }
      asignar("COMBO","cbMoneda",UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                      recordSet.getColumnIdentifiers()), "dtoSalida");	
    }//cargarMonedaAlternativa()    
  private void llenarRecordSetMoneda(RecordSet r) { 
        r.addColumn("OID");
        r.addColumn("DES");
  }
  /** 
   * Método de carga inicial de combos
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */
    private void cargaCombos() throws Exception{
      //Preparamos los parametros del subsistema
      ComposerViewElementList cv = crearParametrosEntrada();
		
      //Utilizamos el subsistema
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
		
      //Cargamos los combos con los resultados
      asignar("COMBO", "cbTipoMovimiento", resultados, "BELObtenerTiposMovimientosCajaManuales");
      asignar("COMBO", "cbTipoTarjeta", resultados, "MAEObtenerTiposTarjeta");
      asignar("COMBO", "cbBanco", resultados, "CCCObtieneBancos");
    }

    private ComposerViewElementList crearParametrosEntrada(){
      ComposerViewElementList lista = new ComposerViewElementList(); 

      DTOBelcorp dtoe = new DTOBelcorp();    
      dtoe.setOidPais(this.pais);
      dtoe.setOidIdioma(this.idiomaUsuario);

      //Primer combo
      ComposerViewElement ci1 = new ComposerViewElement();
      ci1.setIDBusiness("BELObtenerTiposMovimientosCajaManuales");
      ci1.setDTOE(dtoe);    
      ci1.setPosOID((byte)0);
      ci1.setPosDesc((byte)2);      

      //Segundo combo
      ComposerViewElement ci2 = new ComposerViewElement();
      ci2.setIDBusiness("MAEObtenerTiposTarjeta");
      ci2.setDTOE(dtoe);    

      //Tercer combo
      ComposerViewElement ci3 = new ComposerViewElement();
      ci3.setIDBusiness("CCCObtieneBancos");
      ci3.setDTOE(dtoe);   

/*		//Refefinimos la posición de las columnas porque el resultado de 
		// la operación de negocio no es estándar
		ci2.setPosOID((byte)2);
		ci2.setPosDesc((byte)0);
  */    
      
      lista.addViewElement(ci1);
      lista.addViewElement(ci2);
      lista.addViewElement(ci3);
    
      return lista;
    }
  /** 
   * Método para guardar los cambios del movimiento de caja
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */
    private void guardar() throws Exception {
    /*
    -> Crear variable llamada "movimientoCaja" de tipo DTOMovimientoCaja haciendo el siguiente mapeo con los campos de pantalla: 
    -> movimientoCaja.pais = pais de sesión 
    -> movimientoCaja.idioma = idioma de sesión 
    -> movimientoCaja.oidCaja = oidCaja 
    -> movimientoCaja.numeroMovimiento = numeroMovimiento 
    -> movimientoCaja.fecha = fecha 
    -> movimientoCaja.observaciones = observaciones 
    -> movimientoCaja.usuario = usuario activo 
    -> El resto de atributos llenarlos a null 
    (1)Para cada línea de la lista "detalle" hacer 
    -> Crear variable "movimientoCajaDetalle" de tipo DTOMovimientoCajaDetalle haciendo el siguiente mapeo: 
    -> movimientoCajaDetalle.pais = pais de sesión 
    -> movimientoCajaDetalle.idioma = idioma de sesión 
    -> movimientoCajaDetalle.oidMedioPagoBelcenter = medioPagoBelcenter 
    -> movimientoCajaDetalle.oidTipoMovimientoCaja = tipoMovimientoCaja 
    -> movimientoCajaDetalle.oidMonedaAlternativa = monedaAlternativa (si no hay selección asignar null) 
    -> movimientoCajaDetalle.importe = importe 
    -> movimientoCajaDetalle.importeDivisa = importeDivisa 
    -> movimientoCajaDetalle.oidBanco = banco (si no hay selección asignar null) 
    -> movimientoCajaDetalle.numeroCheque = numeroCheque (si no hay dato asignar null) 
    -> movimientoCajaDetalle.oidTipoTarjeta = tipoTarjeta 
    -> movimientoCajaDetalle.numeroTarjeta = numeroTarjeta (si no hay dato asignar null) 
    -> movimientoCajaDetalle.numeroValeCompra = numeroValeCompra 
    -> El resto de atributos llenarlos a null 
    -> añadir movimientoCajaDetalle en el array movimientoCaja.detalle 
    (1)Fin Para 
    -> Crear idBusiness = "BELGuardarMovimientoCaja" 
    -> Asignar conector "ConectorGuardarMovimientoCaja" con idBusiness y DTOMovimientoCaja creado
    */
      String observaciones = conectorParametro("atxtObservaciones")==null?"":conectorParametro("atxtObservaciones");
      String nroMovimiento = conectorParametro("hNumMovimiento")==null?"":conectorParametro("hNumMovimiento");
      Long oidCaja = conectorParametro("oidCaja")==null?null:new Long(conectorParametro("oidCaja"));
      java.sql.Date fecha = null; 
      if (conectorParametro("hFecha")!=null&&(!conectorParametro("hFecha").equals(""))){
          String fechtemp = this.obtenerFechaFormatoDate(conectorParametro("hFecha"));      
          fecha = conectorParametro("hFecha")==null?null:java.sql.Date.valueOf(fechtemp);
      }      
      String usuario = conectorParametro("hUsuario")==null?"":conectorParametro("hUsuario"); 
      DTOMovimientoCaja movimientoCaja = new DTOMovimientoCaja();
      movimientoCaja.setOidPais(this.pais);
      movimientoCaja.setOidIdioma(this.idiomaUsuario);
      movimientoCaja.setOidCaja(oidCaja);      
      movimientoCaja.setNumeroMovimiento(nroMovimiento);
      movimientoCaja.setFecha(fecha);
      movimientoCaja.setObservaciones(observaciones);
      movimientoCaja.setUsuario(usuario);

      String listado1STR = conectorParametro("listado1STR");
      traza("listado1STR " + listado1STR);      
      StringTokenizer stRows = new StringTokenizer(listado1STR, "$");
      ArrayList arrDetalle = new ArrayList();
      for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
          StringTokenizer stCols = new StringTokenizer(stRows.nextToken(), "|");
          //orden columnas
          //tipoMovimientoCaja medioPago Moneda importe importeDivisa nroCheque Banco tipoTarjeta
          //nroTarjeta nroValeCompra oidTipoMovimientoCaja oidMedioPago
          //oidMoneda oidBanco oidTipoTarjeta
          
          DTOMovimientoCajaDetalle dtodet = new DTOMovimientoCajaDetalle();
          dtodet.setOidPais(this.pais);
          dtodet.setOidIdioma(this.idiomaUsuario);
          stCols.nextToken();//cod de la fila
          stCols.nextToken();//tipoMovimientoCaja 0
          stCols.nextToken();//medioPago 1
          stCols.nextToken();//Moneda 2
          String temp = stCols.nextToken();
		 
          traza("el temp es " + temp);
          String temp2 = desFormatearNumero(temp,this.FORMATO_DEFAULT); 
          traza("antes de setear importe " + temp2);
          dtodet.setImporte(!temp2.equals(" ")?new BigDecimal(temp2):null);//importe 3
          temp = stCols.nextToken();
		      temp2 = desFormatearNumero(temp,this.FORMATO_DEFAULT); 
		      traza("antes de setear importe Divisa " + temp2);
          dtodet.setImporteDivisa(!temp2.equals(" ")?new BigDecimal(temp2):null);//importeDivisa 4
          traza("paso 1");
          dtodet.setNumeroCheque(stCols.nextToken());//nroCheque 5
          traza("paso 2");
          stCols.nextToken();//Banco 6
          traza("paso 3");
          stCols.nextToken();//tipoTarjeta 7
		  traza("paso 4");
          dtodet.setNumeroTarjeta(stCols.nextToken());//nroTarjeta 8
		  traza("paso 5");
          dtodet.setNumeroValeCompra(stCols.nextToken());//nroValeCompra 9
		  traza("paso 6");
          temp = stCols.nextToken();
		  dtodet.setOidTipoMovimientoCaja(!temp.equals(" ")?new Long(temp):null);//oidTipoMovimientoCaja 10
          temp = stCols.nextToken();//oidMedioPago 11
		  traza("paso 8 " + temp);
          dtodet.setOidMedioPagoBelcenter(!temp.equals(" ")?new Long(temp):null);//oidMedioPago 11
		  traza("paso 9");
          temp = stCols.nextToken();//oidMoneda 12
		  traza("paso 10 " + temp);
          dtodet.setOidMonedaAlternativa(!temp.equals(" ")?new Long(temp):null);//oidMoneda 12
		  traza("paso 11 ");
          temp = stCols.nextToken();//oidBanco 13
		  traza("paso 12 " + temp);
          dtodet.setOidBancos(!temp.equals(" ")?new Long(temp):null);//oidBanco 13
		  traza("paso 13 ");
          temp = stCols.nextToken();//oidTipoTarjeta 14
		  traza("paso 14 " + temp);
          dtodet.setOidTipoTarjeta(!temp.equals(" ")?new Long(temp):null);//oidTipoTarjeta 14
		  traza("paso 15");
          //dtodet.setFecha(fecha);

          arrDetalle.add(dtodet);
      }
      movimientoCaja.setDetalle(arrDetalle);
      
      MareBusinessID bid = new MareBusinessID("BELGuardarMovimientoCaja");
      Vector vec = new Vector();
      vec.add(movimientoCaja);
      vec.add(bid);
	  traza("el dto es : " + movimientoCaja);
	  DruidaConector con = null;
        
      con = conectar("ConectorGuardarMovimientoCaja",vec);      
      
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }

    /**
    * Retorna el string fecha segun el formato por pais.
    * La fecha a formatear viene en formato Date YYYY-MM-DD.
    */
    private String obtenerFechaFormatoPais(Date fecha) throws Exception {
      // obtenemos el formato de fecha segun el pais
      // String formatoFecha = conectorParametro("hFormatoFechaPais");
      String formatoFecha = null;
      if (debugging) {
        formatoFecha = new String("yyyy-MM-dd");
      } else { 
        formatoFecha = UtilidadesSession.getFormatoFecha(this);
      }
      // aseguro el indicador de mes a mayuscula  
      formatoFecha = formatoFecha.replace('m','M');
      //trabajamos con el formato del pais
      SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
      //formateamos la fecha segun el formato del pais
      String fechaFormatoPaisStr = null;
      if (fecha != null){
        fechaFormatoPaisStr = formatoPais.format(fecha);
      }
      //retorna la fecha formateada    
      return fechaFormatoPaisStr;
    }
    /**
     * Retorna string fecha en formato YYYY-MM-DD, tal como lo maneja Date.
     * Recibe el string fecha en formato en el formato del pais. 
     */
    private String obtenerFechaFormatoDate(String fecha) throws Exception {
        // obtenemos el formato de fecha segun el pais
        // String formatoFecha = conectorParametro("hFormatoFechaPais");
        String formatoFecha = null;
        if (debugging){
          formatoFecha = new String("yyyy-MM-dd");
        } else {
          formatoFecha = UtilidadesSession.getFormatoFecha(this);
        }
        // aseguro el indicador de mes a mayuscula  
        formatoFecha = formatoFecha.replace('m','M');
        //trabajamos con el formato del pais
        SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
        //formateamos la fecha segun el formato Date yyyy-mmm-dd
        Date fechaFormatoDate = new java.sql.Date(formatoPais.parse(fecha).getTime());
        //retorna la fecha formateada
        return fechaFormatoDate.toString();
    } 
	
	 private DruidaConector generarConector(String rowsetID, RecordSet datos,
         Vector columns) throws DOMException, Exception {
         StringBuffer salida = new StringBuffer();

         int sizeColums = datos.getColumnCount();
         int sizeRows = datos.getRowCount();

         if (columns == null) {
             columns = new Vector();
         }

         Vector columsDesc = datos.getColumnIdentifiers();

         DruidaConector conectorValoresPosibles = new DruidaConector();
         XMLDocument xmlDoc = new XMLDocument();
         Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
         Element e_rows = docDestino.createElement("ROWSET");
         e_rows.setAttribute("ID", rowsetID);
         docDestino.getDocumentElement().appendChild(e_rows);

         for (int i = 0; i < sizeRows; i++) {
             Element e_row = docDestino.createElement("ROW");
             e_rows.appendChild(e_row);

             for (int j = 0; j < sizeColums; j++) {
                  if (columns.contains(columsDesc.elementAt(j))) {
                      Element e_campo2 = docDestino.createElement("CAMPO");
                      e_campo2.setAttribute("NOMBRE",
                           columsDesc.elementAt(j).toString());
                      e_campo2.setAttribute("TIPO", "OBJECTO");
                      e_campo2.setAttribute("LONGITUD", "50");

                      Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)
                                ? "" : datos.getValueAt(i, j).toString()));
                      e_campo2.appendChild(txt);
                      e_row.appendChild(e_campo2);
                  }
             }
         }

         conectorValoresPosibles.setXML(docDestino.getDocumentElement());

         return conectorValoresPosibles;
    }

    private void crearListaLP(Vector nomColumns, int cantColumns,
         String nomCapa, String nomLista, String XCapa, String YCapa)
         throws Exception {
         traza("dentro de crearListaLP()  " + nomColumns + " " + cantColumns);

         Document document = getXML();

         Element eCapa = document.createElement("CAPA");
         eCapa.setAttribute("nombre", nomCapa);
         eCapa.setAttribute("alto", "162");
         eCapa.setAttribute("ancho", "580");
         eCapa.setAttribute("colorf", "");
         eCapa.setAttribute("borde", "1");
         eCapa.setAttribute("imagenf", "");
         eCapa.setAttribute("repeat", "");
         eCapa.setAttribute("padding", "");
         eCapa.setAttribute("visibilidad", "hidden");
         eCapa.setAttribute("contravsb", "");
         eCapa.setAttribute("zindex", "");
         eCapa.setAttribute("x", XCapa);
         eCapa.setAttribute("y", YCapa);

         Element eLista = document.createElement("LISTA");

         eLista.setAttribute("seleccion", "boton");
         eLista.setAttribute("nombre", nomLista);
         eLista.setAttribute("ancho", "580");
         eLista.setAttribute("alto", "150");
         eLista.setAttribute("multisel", "0");
         eLista.setAttribute("incy", "1");
         eLista.setAttribute("incx", "10");
         eLista.setAttribute("colorf", "#EFEFEF");
         eLista.setAttribute("imagenoff", "close_no.gif");
         eLista.setAttribute("imagenon", "close_up.gif");
         eLista.setAttribute("accion", "");
         eLista.setAttribute("sep", "|");
         eLista.setAttribute("pixelsborde", "3");
         eLista.setAttribute("colorborde", "#CCCCCC");

         Element eCABECERA = document.createElement("CABECERA");
         eCABECERA.setAttribute("nombre", "cabecera");
         eCABECERA.setAttribute("height", "20");

         Integer anchoCab;

         if (cantColumns < 4) {
             anchoCab = new Integer(580 / cantColumns);
         } else {
             anchoCab = new Integer(150);
         }

         Element eCOL_1 = document.createElement("COL");
         eCOL_1.setAttribute("id", "fondoCabecera");
         eCOL_1.setAttribute("ancho", anchoCab.toString());

         Element eCOL_2 = document.createElement("COL");
         eCOL_2.setAttribute("id", "fondoCabecera");
         eCOL_2.setAttribute("ancho", anchoCab.toString());

         Element eCOL_3 = document.createElement("COL");
         eCOL_3.setAttribute("id", "fondoCabecera");
         eCOL_3.setAttribute("ancho", anchoCab.toString());

         Element eCOL_4 = document.createElement("COL");
         eCOL_4.setAttribute("id", "fondoCabecera");
         eCOL_4.setAttribute("ancho", anchoCab.toString());

         Element eCOL_5 = document.createElement("COL");
         eCOL_5.setAttribute("id", "fondoCabecera");
         eCOL_5.setAttribute("ancho", anchoCab.toString());

         Element eCOL_6 = document.createElement("COL");
         eCOL_6.setAttribute("id", "fondoCabecera");
         eCOL_6.setAttribute("ancho", anchoCab.toString());

         Vector columnas = new Vector();

         for (int i = 0; i < cantColumns; i++) {
             Element eLABEL_2 = document.createElement("LABELC");
             eLABEL_2.setAttribute("id", "fondoCabecera");
             eLABEL_2.setAttribute("nombre", "lbDivisionesPoliticas" + i);
             eLABEL_2.setAttribute("ancho", anchoCab.toString());
             eLABEL_2.setAttribute("alto", "20");
             eLABEL_2.setAttribute("filas", "1");
             eLABEL_2.setAttribute("id", "datosCamposCabecera");

             if (i != 0) {
                  eLABEL_2.setAttribute("valor", (String) nomColumns.get(i));
             } else {
                  eLABEL_2.setAttribute("cod", "199");
             }

             eLABEL_2.setAttribute("enviaroculto", "N");
             columnas.add(eLABEL_2); //Agrego label a la columna
         }

         traza("despues de poner en variables los titulos " + columnas + " " +
             cantColumns);

         if (cantColumns >= 1) {
             eCOL_1.appendChild((Element) columnas.get(0));
             eCABECERA.appendChild(eCOL_1);
             traza("1");
         }

         if (cantColumns >= 2) {
             eCOL_2.appendChild((Element) columnas.get(1));
             eCABECERA.appendChild(eCOL_2);
             traza("1");
         }

         if (cantColumns >= 3) {
             eCOL_3.appendChild((Element) columnas.get(2));
             eCABECERA.appendChild(eCOL_3);
             traza("1");
         }

         if (cantColumns >= 4) {
             eCOL_4.appendChild((Element) columnas.get(3));
             eCABECERA.appendChild(eCOL_4);
             traza("1");
         }

         if (cantColumns >= 5) {
             eCOL_5.appendChild((Element) columnas.get(4));
             eCABECERA.appendChild(eCOL_5);
             traza("1");
         }

         if (cantColumns >= 6) {
             eCOL_6.appendChild((Element) columnas.get(5));
             eCABECERA.appendChild(eCOL_6);
             traza("1");
         }

         Element ePRESENTACION = document.createElement("PRESENTACION");
         Integer ancho = new Integer(cantColumns * anchoCab.intValue());
         ePRESENTACION.setAttribute("ancho", ancho.toString());
         ePRESENTACION.setAttribute("filas", "1");

         int swX1 = 0;
         StringBuffer cadena = new StringBuffer("['datosCamposCenterImpar'");
         traza("break brain");

         for (int i = 1; i < cantColumns; i++) {
             if (swX1 == 0) {
                  cadena.append(", 'datosCamposCenterPar'");
                  swX1 = 1;
             } else {
                  cadena.append(", 'datosCamposCenterImpar'");
                  swX1 = 0;
             }
         }

         for (int i = 0; i < cantColumns; i++) {
             Element eCOLP_2 = document.createElement("COL");
             eCOLP_2.setAttribute("ancho", anchoCab.toString());
             eCOLP_2.setAttribute("caracteres", "150");
             ePRESENTACION.appendChild(eCOLP_2); //Agrego columna a la presentacion
         }

         cadena.append("]");

         traza("### " + cadena.toString());
         ePRESENTACION.setAttribute("bloquesid", cadena.toString());

         Element eROWSET = document.createElement("ROWSET");

         eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
         eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
         eLista.appendChild(eROWSET); //Agrego el rowset de la lista

         eCapa.appendChild(eLista);

         getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);
    }



}
