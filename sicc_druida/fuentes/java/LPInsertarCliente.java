import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.dtos.mae.DTOCampo;
import es.indra.sicc.dtos.mae.DTOClasificacionCliente;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTOClienteMarca;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.mae.DTOComunicacion;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposCliente;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOIdentificacion;
import es.indra.sicc.dtos.mae.DTOObservacion;
import es.indra.sicc.dtos.mae.DTOObtenerPestanya4;
import es.indra.sicc.dtos.mae.DTOPestanya1Base;
import es.indra.sicc.dtos.mae.DTOPestanya2;
import es.indra.sicc.dtos.mae.DTOPestanya2Base;
import es.indra.sicc.dtos.mae.DTOPestanya3;
import es.indra.sicc.dtos.mae.DTOPestanya3Base;
import es.indra.sicc.dtos.mae.DTOPestanya4;
import es.indra.sicc.dtos.mae.DTOPreferencia;
import es.indra.sicc.dtos.mae.DTOPremioRecomendacion;
import es.indra.sicc.dtos.mae.DTOProblemaSolucion;
import es.indra.sicc.dtos.mae.DTOTarjeta;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.mae.DTOValidarClientes;
import es.indra.sicc.dtos.mae.DTOVinculo;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBoolean;
import java.util.Calendar;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.NoSuchElementException;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.ArrayList;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOString;


/************************************************************/
public class LPInsertarCliente extends LPSICCBase {
    private String accion = "";
    private String formatoFecha = null;
    private SimpleDateFormat miFecha = null;

    /* generales */
    private String tipoSubtipoStr = new String("");
    private String formatoFechaPais = new String("");
    private String hidPais = new String("");
    private String hidUsaGeo = new String("");
    private String hidCasoUso = new String("");
    private String hidFocusPrimerComponente = new String("");
    private String hidTipoClienDescripcion = new String("");

    /*************/
    /** Campos de Tipo y SUbTipo **/
    private String StrTipo = new String("");
    private String StrSubTipo = new String("");

    /**Campos primer pantalla**/
    private String hidtextCodCliente = new String("");
    private String hidListaIdentificacion = new String("");
    private String hidDigitoControl = new String("");
    private String hidCodigoAutomatico = new String("");
    private HashMap tipoSubt = new HashMap();


    /**Campos segunda pestaña**/
    private String elementosP2 = new String("");
    private String hidtextApellido1 = new String("");
    private String hidtextApellido2 = new String("");
    private String hidtextApellidoCasada = new String("");
    private String hidtextNombre1 = new String("");
    private String hidtextNombre2 = new String("");
    private String hidcbTratamiento = new String("");
    private String hidcbTratamientoDesc = new String("");
    private String hidrbSexo = new String("");
    private String hidcbFormaPago = new String("");
    private String hidtextFechaNacimiento = new String("");
    private String hidEdad = new String("");
    private String hidtextCodEmpleado = new String("");
    private String hidcbNacionalidad = new String("");
    private String hidcbEstadoCivil = new String("");
    private String hidtextOcupacion = new String("");
    private String hidtextProfesion = new String("");
    private String hidtextCentroTrabajo = new String("");
    private String hidtextCargoDesempena = new String("");
    private String hidcbNivelEstudios = new String("");
    private String hidtextCentroEstudios = new String("");
    private String hidtextNHijos = new String("");
    private String hidtextNPersonasDependientes = new String("");
    private String hidcbNivelSocioEconomico = new String("");
    private String hidcbCicloVidaFamilia = new String("");
    private String hidrbDeseaCorrespondencia = new String("");
    private String hidtextImporteIngresoFamiliar = new String("");
    private String hidOidClienteCont = new String("");

    // esta lista remplaza los otros hidden
    private String hidListaVinculo = new String("");
    private String hidListaObservacion = new String("");
    private String hidListaPrefe = new String("");
    private String hidcbPaisContactado = new String("");
    private String hidtextCodClienteContactado = new String("");
    private String hidcbTipoClienteContactado = new String("");
    private String hidcbCodTipoContactado = new String("");
    private String hidtextFechaContacto = new String("");
    private String hidtextFecha1PedidoContacto = new String("");
    private String hidtextFechaSiguienteContacto = new String("");
    private String hidtxtFechaIngresoActual = new String("");

    private String hidCanalContacto = new String("");
    private String hidMarcaContacto = new String("");
    private String hidPeriodoContacto = new String("");
    
    /*
     String listaObserva = conectorParametroLimpia("hidListaObserva", "", true);
                String marcaStr = "";
              String nroObservacion = "";
              String texto = "";
     */

    /**Campos tercera pestaña**/
    private String elementosP3 = new String("");
    private String hidListaDirecciones = new String("");
    private String hidListaComunicacion = new String("");
    private String hidListaMarca = new String("");
    private String hidMarcaValor = new String("");
    private String listaVinculosOid = new String("");

    /**Campos cuarta pestaña**/
    private String elementosP4 = new String("");
    private String hidListaTarjetas = new String("");
    private String hidListaClasificacion = new String("");
    private String hidListaProbSolu = new String("");

          //Utilizada por applet
  private String origen;
  //private String esModal = new String("");


         private HashMap mapaValores = null;

    public LPInsertarCliente() {
          super();
    }

    /************************************************************/
    public void inicio() throws Exception 
    {
          try {
              accion = conectorParametroLimpia("accion", "", true);
              //esModal = conectorParametroLimpia("esModal", "", true);  //Para manejar MenuSecundario Inc.BELC300018493
              //setTrazaFichero();
              traza("Entro a LPInsertarCliente.incio() con accion = " + accion);
              //traza("¿Debe ser una modal? = " + esModal);
              leeHiddens();

              if (accion.equals("")) {
                    pagina("contenido_clientes_insertar");
                    //asignarAtributo("VAR", "esModal", "valor", esModal);
              } else if (accion.equals("Siguiente1")) {
                    pagina("contenido_grupo1_cliente_basico_crear2");

                                      Long hOidDefTipoDoc = this.obtenerValorDefecto("MAE_TIPO_DOCUM");
                                      if( hOidDefTipoDoc != null )
                                             asignarAtributo("VAR", "hOidDefTipoDoc", "valor", hOidDefTipoDoc.toString() );
              }/* else if(accion.equals("Validar")){
                                         
                                         pagina("contenido_grupo2_insertar");
                    Long pais = UtilidadesSession.getPais(this);
                    Long idioma = UtilidadesSession.getIdioma(this);
                    this.asignarAtributo("VAR", "paisUsuario", "valor", pais.toString() );
                    this.asignarAtributo("VAR", "idiomaUsuario", "valor", idioma.toString() );   
                                         
              }*/  else if(accion.equals("Siguiente1_Validar")){
                                         pagina("contenido_grupo2_insertar");
                    Long pais = UtilidadesSession.getPais(this);
                    Long idioma = UtilidadesSession.getIdioma(this);
                    this.asignarAtributo("VAR", "paisUsuario", "valor", pais.toString() );
                    this.asignarAtributo("VAR", "idiomaUsuario", "valor", idioma.toString() );   
                                      
                                      Long obj = obtenerValorDefecto("SEG_MARCA");
                                      if( obj != null )
                                             this.asignarAtributo("VAR", "valDefMarca", "valor", obj.toString() );
                                      obj = obtenerValorDefecto("SEG_CANAL");
                                      if( obj != null )
                                             this.asignarAtributo("VAR", "valDefCanal", "valor", obj.toString() );
                                      obj = obtenerValorDefecto("CRA_PERIO");
                                      if( obj != null )
                                             this.asignarAtributo("VAR", "valDefPeriodo", "valor", obj.toString() );
                                      obj = obtenerValorDefecto("MAE_TIPO_CLIEN");
                                      if( obj != null )
                                             this.asignarAtributo("VAR", "valDefTipoClie", "valor", obj.toString() );

              }  else if(accion.equals("Siguiente3_Validar")){
                    pagina("salidaGenerica");
                    asignarAtributo("VAR", "cerrarVentana", "valor", "false");
              } else if (accion.equals("Siguiente3")) {
                    pagina("contenido_grupo3_insertar");
                    Long obj = obtenerValorDefecto("MAE_TIPO_DIREC");
                    if( obj != null )             
                    this.asignarAtributo("VAR", "valDefTipoDirr", "valor", obj.toString() );
                    getFormatosValidaciones();
              } else if (accion.equals("Siguiente4")) {
                    pagina("contenido_grupo4_insertar");
					// vbongiov -- 17/10/2008
					getFormatosValidaciones();
              } else if (accion.equals("Guardar")) {
                    pagina("contenido_grupo4_insertar");
					// vbongiov -- 17/10/2008
					getFormatosValidaciones();
              }
              /* 
              * Comentado por SICC20070433 - Rafael Romero - 24/09/2007 
              * No se hacen las validaciones en linea... 
              * Todas las validaciones se hacen al pasar a la pantalla 3 
              else if(accion.equals("ValidarRecte")){    // Agregado por HRCS - Fecha 04/04/2007 - Incidencia Sicc20070184
                                      // En ejecucion se analizara...
                            }
              else if(accion.equals("ValidarEdad")){     // Agregado por HRCS - Fecha 14/08/2007 - Cambio Sicc20070361
                                      // En ejecucion se analizara...
                            }
                            			 */
              else if(accion.equals("EnviaMensajeRechazo")){     // Agregado por HRCS - Fecha 17/08/2007 - Cambio Sicc20070361
                                      // En ejecucion se analizara...
                            }

              if (!accion.equals("Validar") && !accion.equals("Siguiente3_Validar") && 
                   //!accion.equals("ValidarRecte") && 
                   //!accion.equals("ValidarEdad") && 
                   !accion.equals("EnviaMensajeRechazo")) {
                   //traza("Hago getConfiguracionMenu para accion="+accion);                                                                                                                                                                  
                   seteaHiddens();
                   this.getConfiguracionMenu();
              }
          } catch (Throwable th) {
              this.traza("Error en Mostrar Pantalla para accion:[" + accion +
                    "]");

              ByteArrayOutputStream stack = new ByteArrayOutputStream();
              PrintStream out = new PrintStream(stack);
              th.printStackTrace(out);
              traza(stack.toString());

              BelcorpError belcorpError = new BelcorpError();
              DTOError dtoError = belcorpError.obtenerError(th,
                         UtilidadesSession.getIdioma_ISO(this), "");
              String s = th.getMessage();
              traza(dtoError.getCodigoError() + " - " +
                    dtoError.getDescripcionError());
              throw ((Exception) th);
          }
    }

    /************************************************************/
    public void ejecucion() throws Exception 
    {
          this.rastreo();    
          traza("*******************   LPInsertarCliente ejecucion(" + accion );
          //traza("Entro a LPInsertarCliente.ejecucion() con accion = " + accion);


          //Vector v = this.obtieneTipos("h_comboTipoCliente_0=11;h_comboSubtipoCliente_0=18;h_descTipoCliente_0=BR-Gerente de zona;h_descSubtipoCliente_0=Normal;h_comboTipoCliente_1=12;h_comboSubtipoCliente_1=19;h_descTipoCliente_1=BR-Instructor;h_descSubtipoCliente_1=BR-Normal;h_comboTipoCliente_2=3;h_comboSubtipoCliente_2=7;h_descTipoCliente_2=Cliente;h_descSubtipoCliente_2=Final;");
            
   //     hidListaClasificacion = "h_comboMarcaDesc_0=EBEL;h_comboCanalDesc_0=Tienda (retail);h_comboTipoClienteDesc_0=TipoCliente1;h_comboSubTipoClienteDesc_0=BR-Normal;h_comboTipoClasificacionDesc_0=Tipo clasificación 1;h_comboClasificacionDesc_0=Clasificación 1;h_comboMarca_0=1;h_comboCanal_0=2;h_comboTipoCliente_0=13;h_comboSubTipoCliente_0=20;h_comboTipoClasificacion_0=4;h_comboClasificacion_0=4;";
     //   this.procesarPestany4ClasificacionGuardar();
/*          hidListaProbSolu = "h_comboTipoProblema_0=3;h_AreaTxtDescripcionProblema_0=;h_cbxSolucion_0=S;h_comboTipoSolucion_0=-1;h_AreaTxtDescripcionSolucon_0=;h_AreaTxtNegocioProducto_0=;";
          this.procesarPestany4ProblemaSolucionGuardar();
          hidListaProbSolu = "h_comboTipoProblema_0=3;h_AreaTxtDescripcionProblema_0=aaaaaaaaaa;h_cbxSolucion_0=S;h_comboTipoSolucion_0=2;h_AreaTxtDescripcionSolucion_0=aaaaaaaaa;h_AreaTxtNegocioProducto_0=aaaaaaaaaaaa;";
          this.procesarPestany4ProblemaSolucionGuardar();
          hidListaProbSolu = "h_comboTipoProblema_0=3;h_AreaTxtDescripcionProblema_0=aaaaaaaaaa;h_cbxSolucion_0=N;h_comboTipoSolucion_0=2;h_AreaTxtDescripcionSolucion_0=aaaaaaaaa;h_AreaTxtNegocioProducto_0=aaaaaaaaaaaa;";
          this.procesarPestany4ProblemaSolucionGuardar();*/

/*          hidListaComunicacion = "h_comboTipoComunicacion_0=1;h_comboDiaComunicacion_0=L;h_AreaTxtTextoComunicacion_0=comun 1;h_RbComunicacionPrincipal_0=S;h_TextoHoraDesde_0=6:31;h_TextoHoraHasta_0=12:49;h_comboIntervaloComunicacion_0=false;h_comboTipoCmunicacion_1=1;h_comboDiaComunicacion_1=M;h_AreaTxtTextoComunicacion_1=comun 22;h_RbComunicacionPrincipal_1=N;h_TextoHoraDesde_1=8:41;h_TextoHoraHasta_1=9:02;h_comboIntervaloComunicacion_1=false;";
          this.procesarPestany3ComunicacionGuardar();*/
            

                   origen = conectorParametroLimpia("origen", "", true);

          //this.procesarPestany4ClasificacionGuardar();
          Long tipoL = ((StrTipo == null) || (StrTipo.length() == 0)) ? null : Long.valueOf(StrTipo);
          Long subTipoL = ((StrSubTipo == null) || (StrSubTipo.length() == 0)) ? null : Long.valueOf(StrSubTipo);

          asignarAtributo("VAR", "casoDeUso", "valor", "Insertar Cliente");

          // [1] no se usa para nada esta linea UtilidadesSession utilidadesSesion = new UtilidadesSession();




          HashMap pageParams = conectorParametro();
          Set en = pageParams.keySet();
          Iterator it = en.iterator();

          while (it.hasNext()) {
              String key = (String) it.next();
              String value = (String) pageParams.get(key);
              //traza(key + " = " + value);
          }



          String huboError = new String("exitoso");

          try {
              if (accion.equals("")) {
                    ProcesarAccionVacia();
              } else if (accion.equals("Siguiente1")) {
                    ProcesarAccionSiguiente1();
              } else if (accion.equals("Validar")) {
                    validar();
              } else if (accion.equals("Siguiente1_Validar")) {
                    ProcesarAccionValidar();
              } else if (accion.equals("Siguiente3_Validar")){
                    ProcesarAccionSiguiente3Validar();
              } else if (accion.equals("Siguiente3")) {
                    ProcesarAccionSiguiente3();
              } else if (accion.equals("Siguiente4")) {
                    ProcesarAccionSiguiente4();
              } else if (accion.equals("Guardar")) {
                    ProcesarAccionGuardar();
              //} else if (accion.equals("ValidarRecte")) {      // Agregado por HRCS - Fecha 04/04/2007 - Incidencia Sicc20070184
              //     validarRecteHijaDupla();
              //} else if (accion.equals("ValidarEdad")) {        // Agregado por HRCS - Fecha 14/08/2007 - Cambio Sicc20070361
              //     validarEdadHijaDupla();
              } else if (accion.equals("EnviaMensajeRechazo")) { // Agregado por HRCS - Fecha 17/08/2007 - Cambio Sicc20070361
                    enviarMensajeRechazoDupla();
              }

            this.asignarAtributo("VAR", "origen", "valor", origen);
              
          } catch (Exception ex) {
              traza("Se capturo una exeption");
              huboError = new String("con error");
              logStackTrace(ex);
              this.lanzarPaginaError(ex);
          }

          //getConfiguracionMenu();
          traza("*******************  FIN LPInsertarCliente ejecucion (" +
              accion + " )" + huboError + " ***************************");
    }


    /************************************************************/
    public void ProcesarAccionVacia() throws Exception {
          DruidaConector conectorTipSub;
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
          MareBusinessID id;
          Vector paramEntrada;
          DTOBelcorp dtoBelcorp;

          
          id = new MareBusinessID("MAEObtenerTipoSubtipo");
          paramEntrada = new Vector();
          dtoBelcorp = new DTOBelcorp();
          dtoBelcorp.setOidPais(utilidadesSesion.getPais(this));
          dtoBelcorp.setOidIdioma(utilidadesSesion.getIdioma(this));
          paramEntrada.add(dtoBelcorp);
          paramEntrada.add(id);
          conectorTipSub = conectar("ConectorTipoSubtipo", paramEntrada);

          //traza(conectorTipSub.objeto("DTOSalida").toString());

          DTOTipoSubtipo dtoTiSu = (DTOTipoSubtipo) conectorTipSub.objeto(
                    "DTOSalida");
          RecordSet subTipos = (RecordSet) dtoTiSu.getSubtipos();
          Vector colSubTipos = subTipos.getColumnIdentifiers();
          RecordSet tipos = (RecordSet) dtoTiSu.getTipos();
          utilidadesBelcorp.agregarRegistroVacio(tipos, 0);

          Vector colTipos = tipos.getColumnIdentifiers();
          DruidaConector tipo = generarConector("DTOSalida.tipos_ROWSET", tipos,
                    colTipos);

          DruidaConector subTipo = generarConector("DTOSalida.subtipos_ROWSET",
                    subTipos, colSubTipos);

          asignar("COMBO", "comboTipoCliente", tipo, "DTOSalida.tipos_ROWSET");

          //lista invisible
          this.crearListaLP(colSubTipos, subTipos.getColumnCount(), "Capa1",
              "Lista1", "14", "200");
          asignar("LISTA", "Lista1", subTipo, "DTOSalida.subtipos_ROWSET");

          //  asignarAtributo("VAR", "casoDeUso", "valor", "Insertar Cliente");
          // Limpio de session los datos de todas las pestañas, ya que se inicio o re-inicio el caso de uso
          String vuelve = conectorParametroLimpia("atrasTipoSubtipo", "", true);

          if (vuelve.equals("")) {
              conectorParametroSesion("elementos", new String());
              conectorParametroSesion("hidListaIdentificacion", new String());
              conectorParametroSesion("elementosP2", new String());
              conectorParametroSesion("elementosP3", new String());
              conectorParametroSesion("elementosP4", new String());
              conectorParametroSesion("codigoCliente", new String());
          } else {
              // tengo que guardar los datos que vienen de la pestanya1.
              conectorParametroSesion("hidListaIdentificacion",
                    hidListaIdentificacion);
          }
    }

    /************************************************************/
    public void ProcesarAccionSiguiente1() throws Exception {
          traza("*******************   Procesar Accion Siguiente1   ***************************");

          DruidaConector conectorTipSub;
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
          MareBusinessID id;
          Vector paramEntrada;
          DTOBelcorp dtoBelcorp;
          DruidaConector conectorP1Base;

          // proceso los datos enviados desde pestanya 0    
          //traza("[" + tipoSubtipoStr + "]");

          StringTokenizer strTok1 = new StringTokenizer(tipoSubtipoStr, ";");
          String tipoStr = new String("");
          String subTipoStr = new String("");

          while (strTok1.hasMoreElements()) {
              String line = strTok1.nextToken();
              String value = line.substring(line.lastIndexOf('=') + 1);

              // solo agrego el primer tipo y primer subtipo
              if (line.substring(0, 18).equals("h_comboTipoCliente") &&
                         tipoStr.equals("")) {
                    //traza(line + " => " + value);
                    tipoStr = value;
              } else if (line.substring(0, 21).equals("h_comboSubtipoCliente") &&
                         subTipoStr.equals("")) {
                    //traza(line + " => " + value);
                    subTipoStr = value;
              }
          }
                   
                   //	Agregado por HRCS - Fecha 03/04/2007 - Incidencia Sicc20070184
                   traza("tipoStr: " + tipoStr );
                   traza("subTipoStr: " + subTipoStr );

          asignarAtributo("VAR", "cbTipo", "valor", tipoStr);
          asignarAtributo("VAR", "cbSTipo", "valor", subTipoStr);

          // Procesar pestanya 2, porque esta pestaña puede llamarse desde ahi tambien
          String elementosP2 = conectorParametroLimpia("elementosP2", "", true);
          //traza("elementosP2[" + elementosP2 + "]");
          conectorParametroSesion("elementosP2", elementosP2);

          paramEntrada = new Vector();
          dtoBelcorp = new DTOBelcorp();
          dtoBelcorp.setOidPais(utilidadesSesion.getPais(this));
          dtoBelcorp.setOidIdioma(utilidadesSesion.getIdioma(this));
          id = new MareBusinessID("MAEPestanya1Base");
          paramEntrada.add(dtoBelcorp);
          paramEntrada.add(id);
          conectorP1Base = conectar("ConectorPestanya1Base", paramEntrada);

          //DTOPestanya1Base dtoP1Base = (DTOPestanya1Base) conectorP1Base.objeto("DTOPestanya1Base");
          DTOPestanya1Base dtoP1Base = (DTOPestanya1Base) conectorP1Base.objeto(
                    "DTOSalida");

          if (hidtextCodCliente.equals("")) {
              hidtextCodCliente = dtoP1Base.getCodigoCliente();
          }

          hidDigitoControl = dtoP1Base.getDigitoControl();

          RecordSet tipoDocu = (RecordSet) dtoP1Base.getTiposDocumento();
          utilidadesBelcorp.agregarRegistroVacio(tipoDocu, 0);

          Vector colTipoDoc = new Vector();
          colTipoDoc = tipoDocu.getColumnIdentifiers();

          DruidaConector tipoDocumento = generarConector("DTOSalida.tipodocu_ROWSET",
                    tipoDocu, colTipoDoc);
          asignar("COMBO", "comboTipoDocId", tipoDocumento,
              "DTOSalida.tipodocu_ROWSET");
          hidDigitoControl = (hidDigitoControl == null) ? "" : hidDigitoControl;
          asignarAtributo("VAR", "hidDigitoControl", "valor", hidDigitoControl);
          //traza("Codigo cliente:" + hidtextCodCliente);


          if (hidtextCodCliente != null) {
              asignarAtributo("LABELC", "lblCodClienteActual", "valor",hidtextCodCliente.toString());
              asignarAtributo("VAR", "codigoCliente", "valor", hidtextCodCliente.toString());
              asignarAtributo("VAR", "hidDigitoControl", "valor",(((hidDigitoControl == null) ||
              (hidDigitoControl.length() == 0)) ? "0" : hidDigitoControl.toString()));
          } 

          String longCodCliente = this.obtenerLongitudCodigoCliente().toString();


          asignarAtributo("VAR", "hidlongCliente", "valor", longCodCliente);           
          //asignarAtributo("VAR", "hidlongCliente", "valor", "11");                     


          if ((dtoP1Base.getCodigoCliente() == null) || (dtoP1Base.getCodigoCliente().equals(""))) {

                asignarAtributo("VAR", "hidCodigoAutomatico", "valor", new Boolean(false).toString());
          } else {

              asignarAtributo("VAR", "hidCodigoAutomatico", "valor", new Boolean(true).toString());
          }

          // String elementosP1 = (String) conectorParametroSesion("hidListaIdentificacion");
          //  if (elementosP1 != null) {
          //      asignarAtributo("VAR", "hidListaIdentificacion", "valor", elementosP1);
          //   }

    }

    /************************************************************/
    public void ProcesarAccionValidar() throws Exception {
          DruidaConector conectorTipSub;
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
          MareBusinessID id;
          Vector paramEntrada;
          DTOBelcorp dtoBelcorp;
          DruidaConector conectorP2;
          

          // Proceso los parametros de la Pestanya 1
          String hidListaIdentificacion2 = conectorParametroLimpia("hidListaIdentificacion",
                    "", true);
          traza("hidListaIdentificacion:" + hidListaIdentificacion2);

          if (!hidListaIdentificacion2.equals("")) {
              conectorParametroSesion("hidListaIdentificacion",
                    hidListaIdentificacion2);
          }

          // Proceso los parametros de la Pestanya 3
          elementosP3 = conectorParametroLimpia("elementosP3", "", true);
          //traza("elementosP3:" + elementosP3);
          conectorParametroSesion("elementosP3", elementosP3);

          hidListaDirecciones = conectorParametroLimpia("hidListaDirecciones",
                    "", true);
          //traza("hidListaDirecciones:" + hidListaDirecciones);
          conectorParametroSesion("hidListaDirecciones", hidListaDirecciones);

          hidListaComunicacion = conectorParametroLimpia("hidListaComunicacion",
                    "", true);
          //traza("hidListaComunicacion:" + hidListaComunicacion);
          conectorParametroSesion("hidListaComunicacion", hidListaComunicacion);

          hidListaMarca = conectorParametroLimpia("hidListaMarca", "", true);
          //traza("hidListaMarca:" + hidListaMarca);
          conectorParametroSesion("hidListaMarca", hidListaMarca);

          obtenerConfiguracionCampos(new Long(StrTipo), new Long(StrSubTipo));

          id = new MareBusinessID("MAEPestanya2"); //MAEPestanya2Base
          paramEntrada = new Vector();

          DTOCodigoCliente dtoCodClie = new DTOCodigoCliente();
          dtoCodClie.setCodigoCliente(hidtextCodCliente);
          dtoCodClie.setOidIdioma(utilidadesSesion.getIdioma(this));
          dtoCodClie.setOidPais(utilidadesSesion.getPais(this));
          dtoCodClie.setIpCliente(utilidadesBelcorp.getIPCliente(this));
          dtoCodClie.setPrograma("LPInsertarCliente");
                   
                   //	Agregado por HRCS - Fecha 03/04/2007 - Incidencia Sicc20070184
                   dtoCodClie.setOidTipoCliente( new Long(conectorParametroLimpia("cbTipo", "", true)) );
                   dtoCodClie.setOidSubTipoCliente( new Long(conectorParametroLimpia("cbSTipo", "", true)) );
                   traza("DTOCodigoCliente: " + dtoCodClie );

          paramEntrada.add(dtoCodClie);
          paramEntrada.add(id);
          //traza("paramEntrada:" + paramEntrada);

          conectorP2 = conectar("ConectorPestanya2", paramEntrada);

          asignarAtributo("VAR", "hidMarcaDefecto", "valor",  UtilidadesSession.getMarcaPorDefecto(this).toString());   
          asignarAtributo("VAR", "hidCanalDefecto", "valor",  UtilidadesSession.getCanalPorDefecto(this).toString());   


          
          DTOPestanya2 dtoP2 = (DTOPestanya2) conectorP2.objeto("DTOSalida");

          RecordSet marcasCombo = dtoP2.getMarcas();
          if (marcasCombo != null)
          {
            //traza("marcasCombo: " + marcasCombo);
            DruidaConector con = UtilidadesBelcorp.generarConector("marcasCombo", marcasCombo, marcasCombo.getColumnIdentifiers() );
            this.asignar("COMBO", "cbMarca", con, "marcasCombo");
          }

          RecordSet canalCombo = dtoP2.getCanales();
          if ( canalCombo != null)
          {
            //traza("canalCombo: " + canalCombo);
            DruidaConector con = UtilidadesBelcorp.generarConector("canalCombo", canalCombo, canalCombo.getColumnIdentifiers() );
            this.asignar("COMBO", "cbCanal", con, "canalCombo");            
          }
          
          
          DTOPestanya2Base dtoP2Base = (DTOPestanya2Base) dtoP2.getBase();
          

          
          String longCodCliente = this.obtenerLongitudCodigoCliente().toString();
          asignarAtributo("VAR", "hidlongCliente", "valor", longCodCliente);           
          //asignarAtributo("VAR", "hidlongCliente", "valor", "11");                     

          if (!dtoP2Base.getExiste().booleanValue()) 
          {
              RecordSet formaPago = (RecordSet) dtoP2Base.getFormasPago();
              formaPago.removeColumn(1);
              //traza(formaPago);

              Vector formaPagoCol = new Vector();
              formaPagoCol = formaPago.getColumnIdentifiers();


              DruidaConector conFormaPago = generarConector("DTOSalida.formapago_ROWSET",
                         formaPago, formaPagoCol);
              asignar("COMBO", "cbFormaPago", conFormaPago,
                    "DTOSalida.formapago_ROWSET");

              //ver si tengo que asignar getLongitudesCodigoClientePais alguna lista oculta 
          } else if (dtoP2Base.getEstaCastigado().booleanValue()) 
          {
              /*Se muestra el mensaje con el código MAE-0006 ("El cliente ya existe y tiene cuentas
                * castigadas. El saldo del cliente es") concatenado con el atributo saldo de dto
                Se reincia el caso de uso, para ello de envía una petición a esta LP si accion,
                tal y como se hace desde el menú*/
              //traza("Lanze exception MAE0006, saldo = " + dtoP2Base.getSaldo());
              asignarAtributo("VAR", "hidSaldo", "valor", dtoP2Base.getSaldo());

              throw new MareException(new Exception(), 160280001);

              //                        conectorAction("LPInsertarCliente");
              //                conectorActionParametro("accion", "");
          } else {
              /*Se muestra el mensaje MAE-0007 ("El cliente ya existe")
              Se llama a la LPModificarCliente pasandole el oidCliente que trae el DTO
              */
              

              if (dtoP2Base != null) {
                    if (dtoP2Base.getOidCliente() != null) {
                         asignarAtributo("VAR", "dtoOid", "valor",
                              dtoP2Base.getOidCliente().toString());
                    }
              }

              throw new MareException(new Exception(), 160280002);

              /*      if (dtoP2Base.getOidCliente() != null) {
                            String oidClienteDtoP2 = dtoP2Base.getOidCliente().toString();
                            conectorAction("LPModificarCliente");
                            conectorActionParametro("accion", "");
                            conectorActionParametro("oidCliente", oidClienteDtoP2);
                      }*/
          }

          /*
                    //formatoFecha = formatoFecha.replace('-','/');
                    miFecha = new SimpleDateFormat(formatoFecha);

                    //La fecha viene de la forma yyyy/MM/dd
                    java.util.Date fecha = miFecha.parse(fechaLoca);
                    miFecha = new SimpleDateFormat(formatoFecha);
                                */
          Timestamp fec_actu = new Timestamp(System.currentTimeMillis());

          //String formatoFecha = UtilidadesSession.getFormatoFecha(this);
          //formatoFecha = formatoFecha.replace('m', 'M');
          //SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
          // long fechita = 

          // java.util.Date fechitaDate = new Date(fechita);

          java.sql.Date fd = new java.sql.Date(fec_actu.getTime());
          traza("fDesde: " + fd);          

          asignarAtributo("LABELC", "lblFechaIngresoActual", "valor",
              transformaFechas(fd));
          asignarAtributo("VAR", "hidFechaIngreso", "valor", transformaFechas(fd));
          
          // vbongiov -- SiCC20070455 MAE -- 11/12/2007
          
          // Calculo fecha desde + 1 año
          Calendar calendHasta = Calendar.getInstance();                  
          calendHasta.setTime(fec_actu);
          
          calendHasta.add(Calendar.YEAR, 1);
          
          java.util.Date fHastaCal = calendHasta.getTime();
          
          Date fHasta = new Date(fHastaCal.getTime());
          
          traza("fHasta: " + fHasta);
          
          asignarAtributo("VAR", "hidFechaHasta", "valor", transformaFechas(fHasta));        
          
          asignarAtributo("VAR", "OID_TIPO_VINCULO_RECOMENDANTE_RECOMENDADA", "valor", ConstantesMAE.OID_TIPO_VINCULO_RECOMENDANTE_RECOMENDADA.toString()); 
          
          //Datos Adicionales combo Nacionalidad
          RecordSet nacionalidad = (RecordSet) dtoP2.getNacionalidad();
          Vector nacionalidadCol = new Vector();
          nacionalidadCol = nacionalidad.getColumnIdentifiers();


          DruidaConector conNacionalidad = generarConector("DTOSalida.nacionalidad_ROWSET",
                    nacionalidad, nacionalidadCol);
          asignar("COMBO", "cbNacionalidad", conNacionalidad,
              "DTOSalida.nacionalidad_ROWSET");

          //Datos Adicionales combo Estado Civil
          RecordSet estCivil = (RecordSet) dtoP2.getEstadoCivil();
          Vector estCivilCol = new Vector();
          estCivilCol = estCivil.getColumnIdentifiers();


          DruidaConector conEstCivil = generarConector("DTOSalida.estcivil_ROWSET",
                    estCivil, estCivilCol);
          asignar("COMBO", "cbEstadoCivil", conEstCivil,
              "DTOSalida.estcivil_ROWSET");


          //Datos Adicionales combo Nivel de Estudios
          RecordSet nivelEst = (RecordSet) dtoP2.getNivelEstudios();
          Vector nivelEstCol = new Vector();
          nivelEstCol = nivelEst.getColumnIdentifiers();


          DruidaConector conNivelEst = generarConector("DTOSalida.nivelEstudios_ROWSET",
                    nivelEst, nivelEstCol);
          asignar("COMBO", "cbNivelEstudios", conNivelEst,
              "DTOSalida.nivelEstudios_ROWSET");


          //Datos Adicionales comboNSEconomico
          RecordSet nsep = (RecordSet) dtoP2.getNSEP();
          Vector nsepCol = new Vector();
          nsepCol = nsep.getColumnIdentifiers();


          DruidaConector conNSEP = generarConector("DTOSalida.nsep_ROWSET", nsep,
                    nsepCol);
          asignar("COMBO", "cbNivelSocioEconomico", conNSEP,
              "DTOSalida.nsep_ROWSET");

          //Datos Adicionales comboCicloVida
          RecordSet cicloVida = (RecordSet) dtoP2.getCiclosVida();
          Vector cicloVidaCol = new Vector();
          cicloVidaCol = cicloVida.getColumnIdentifiers();


          DruidaConector conCicloVida = generarConector("DTOSalida.ciclovida_ROWSET",
                    cicloVida, cicloVidaCol);
          asignar("COMBO", "cbCicloVidaFamiliar", conCicloVida,
              "DTOSalida.ciclovida_ROWSET");

          RecordSet tiposVinc = (RecordSet) dtoP2.getTiposVinculo();
          utilidadesBelcorp.agregarRegistroVacio(tiposVinc, 0);

          Vector tiposVincCol = new Vector();
          tiposVincCol = tiposVinc.getColumnIdentifiers();


          DruidaConector conTiposVinc = generarConector("DTOSalida.tiposvinculo_ROWSET",
                    tiposVinc, tiposVincCol);
          asignar("COMBO", "comboTipoVinculo", conTiposVinc,
              "DTOSalida.tiposvinculo_ROWSET");

          //LISTADO 2 GRUPO PREFERENCIA comboTipoPreferencia
          RecordSet tiposPrefe = (RecordSet) dtoP2.getTiposPreferencias();
          utilidadesBelcorp.agregarRegistroVacio(tiposPrefe, 0);

          Vector tiposPrefeCol = new Vector();
          tiposPrefeCol = tiposPrefe.getColumnIdentifiers();

          DruidaConector conTiposPrefe = generarConector("DTOSalida.tipospreferencia_ROWSET",
                    tiposPrefe, tiposPrefeCol);
          asignar("COMBO", "comboTipoPreferencia", conTiposPrefe,
              "DTOSalida.tipospreferencia_ROWSET");


          //LISTADO3  comboMarca
          RecordSet marcas = (RecordSet) dtoP2.getMarcas();
          utilidadesBelcorp.agregarRegistroVacio(marcas, 0);

          Vector marcasCol = new Vector();
          marcasCol = marcas.getColumnIdentifiers();

          DruidaConector conMarca = generarConector("DTOSalida.marca_ROWSET",
                    marcas, marcasCol);
          asignar("COMBO", "comboMarca", conMarca, "DTOSalida.marca_ROWSET");


          asignarAtributo("LABELC", "lblPaisContactoActual", "valor",
              utilidadesSesion.getDescripcionPais(this));
          asignarAtributo("LABELC", "lblTipoClienteContactoActual", "valor",
              hidTipoClienDescripcion);


          RecordSet tiposCliente = (RecordSet) dtoP2.getTipoCliente();
          Vector tiposClienteCol = new Vector();
          tiposClienteCol = tiposCliente.getColumnIdentifiers();


          DruidaConector conTiposCliente = generarConector("DTOSalida.tiposcliente_ROWSET",
                    tiposCliente, tiposClienteCol);
          asignar("COMBO", "cbTipoClienteContactado", conTiposCliente,
              "DTOSalida.tiposcliente_ROWSET");

          String elementosP2 = (String) conectorParametroSesion("elementosP2");

          if (elementosP2 != null) {
              asignarAtributo("VAR", "elementosP2", "valor", elementosP2);
          }

          asignarAtributo("VAR", "hFormatoFechaPais", "valor",
              UtilidadesSession.getFormatoFecha(this));


    }

    /************************************************************/
    public void ProcesarAccionSiguiente3Validar() throws Exception{


          //pagina("salidaGenerica");
          MareBusinessID id; 
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
          Vector paramEntrada;
          DTOBelcorp dtoBelcorp;
          DruidaConector conPestanya3;
          //Boolean exception = null;  
          
           
          id = new MareBusinessID("MAEPestanya3");

          DTOValidarClientes dtoValidaClie = new DTOValidarClientes();
          dtoValidaClie.setIpCliente(utilidadesBelcorp.getIPCliente(this));
          dtoValidaClie.setPrograma("LPInsertarCliente");


          //          clientesVinculo: rellenamos un array con los valores de los campos
          //          clienteVinculoN, respetando el orden de N, de menor a mayor 
          String[] codiClie = this.getClientesVinculo();
          //traza("Clientes: " + codiClie);

          if (codiClie != null){
              
              dtoValidaClie.setClientesVinculo(codiClie); //String[]

              Long[] codiPais = new Long[codiClie.length];
              Long tempi = utilidadesSesion.getPais(this);

              for (int y = 0; y < codiClie.length; y++)
                    codiPais[y] = tempi;


              dtoValidaClie.setPaisesVinculo(codiPais); //Long[]                      
          }


          //dtoValidaClie.setPaisContactado((hidcbPaisContactado == "") ? null: Long.valueOf( hidcbPaisContactado));
          dtoValidaClie.setPaisContactado(utilidadesSesion.getPais(this));

          dtoValidaClie.setClienteContacto(hidtextCodClienteContactado);


          // by ssantana, inc. 4950.
          if ((hidcbTipoClienteContactado == null) || hidcbTipoClienteContactado.equals("")) {
              dtoValidaClie.setTipoClienteContacto(null);
          } else {
              dtoValidaClie.setTipoClienteContacto(Long.valueOf(hidcbTipoClienteContactado));
          }



          Long tipoL = ((StrTipo == null) || (StrTipo.length() == 0)) ? null : Long.valueOf(StrTipo);
          Long subTipoL = ((StrSubTipo == null) || (StrSubTipo.length() == 0))
                                                                                  ? null : Long.valueOf(StrSubTipo);
          dtoValidaClie.setSubtipoCliente((subTipoL == null) ? null : subTipoL);
          dtoValidaClie.setOidIdioma(utilidadesSesion.getIdioma(this));
          dtoValidaClie.setOidPais(utilidadesSesion.getPais(this));

          // Agregado por SiCC20070433 - Rafael Romero - 24/09/2007 
          // UtilidadesLog.debug("hidEdad:["+hidEdad+"]"); 
          if(hidEdad!=null && hidEdad.length()>0){ 
                  dtoValidaClie.setEdad(new Integer(hidEdad)); 
          } 
          // Fin agregado SICC20070433 

          paramEntrada = new Vector();

          //          paramEntrada.add(dtoe2);
          paramEntrada.add(dtoValidaClie);
          paramEntrada.add(id);
          

/*          if (dtoValidaClie.getClientesVinculo() != null) {
              for (int t = 0; t < dtoValidaClie.getClientesVinculo().length;
                         t++) {
                    traza("DTOValidarClientes: " + getClientesVinculo()[t]);
              }
          }*/

          //traza("getPaisContactado() validar : " + dtoValidaClie.getPaisContactado());
          //traza("getClienteContacto() validar : " + dtoValidaClie.getClienteContacto());
          //traza("getTipoClienteContacto() validar: " + dtoValidaClie.getTipoClienteContacto());

          //------------- Conectar
          conPestanya3 = conectar("ConectorObjetoGenerico", paramEntrada);


          //-- se adelanta el chequeo de errores de negocio
          DTOPestanya3 dtoPestanya3 = (DTOPestanya3) conPestanya3.objeto("DTOSalida");
          //traza("dtoPestanya3:" + dtoPestanya3);

          //-------
          // faltaria chequeo de nulls, si pestanya3 ==null esto pincha mas abajo
          // El error MAE-20 nunca es tirado, ya que su condicion coincide con la del 19, aunque el 20 es un poco mas especifico
          //traza("Siguiente3_12 dtoPestanya3.getOidClientesVinculo()" + dtoPestanya3.getOidClientesVinculo());

          
          if (dtoPestanya3.getOidClientesVinculo() == null) {
              
              //exception = new Boolean(true); 
              //asignarAtributo("VAR", "hidSaldo", "valor", dtoP2Base.getSaldo());
              throw new MareException(new Exception(), 160280003);
          }

          Long[] oidClienteV = new Long[dtoPestanya3.getOidClientesVinculo().length];
          
          oidClienteV = dtoPestanya3.getOidClientesVinculo();


          RecordSet clienteV = new RecordSet();
          clienteV.addColumn("OID");
          clienteV.addColumn("CLIENTEVINCULO");


          StringBuffer cliVinc = new StringBuffer();
         
          //traza("OID cliente vinculo " + dtoPestanya3.getOidClientesVinculo());

          for (int i = 1; i < (dtoPestanya3.getOidClientesVinculo().length + 1);i++) 
          {


              // segun el MON, si un vinculo es invalido, se devuelve el DTOPestanya3 vacio
              // y no un null en el array de oids
              if (oidClienteV[i - 1] == null) {
                    /*Mostramos el mensaje de error MAE-0020 (El cliente de vínculo no existe)
                    La pantalla asociada es Pestanya2 y restauramos los valores de los campos.*/

                    //TODO:  rebote
                    
                    //asignarAtributo("VAR", "hidSaldo", "valor", dtoP2Base.getSaldo());
                    //exception = new Boolean(true);
                    throw new MareException(new Exception(), 160280003);

              } else {
                    /*guardamos el valor de cada elemento del array en campos ocultos "oidClienteVinculoN",
                     * donde N es la posicion del elemento en el array + 1 (para que empiece en 1 la
                     * numeracion de los campos)*/
                    Long clieVinculo = oidClienteV[i - 1];

                    if (i != 1) {
                         cliVinc.append("," + clieVinculo);
                    } else {
                         cliVinc.append("" + clieVinculo);
                    }

                    // Viejo-->
                    clienteV.addRow(new Object[] { new Integer(i), clieVinculo });

                    // asignarAtributo("VAR", "hidOidClienteVinculo", "valor", oidClienteVinculo);
              }
             
            
                                                          
          }

          Long oidClienteContacto = dtoPestanya3.getOidClienteContacto();

          traza("*******EL OID CLIENTE CONTACTO ES " + oidClienteContacto + " *****************");

          if (oidClienteContacto != null){
                //este cambio es por incidencia 5723
                //traza("entro en el NULL");
             asignarAtributo("VAR", "hidOidClienteCont", "valor", oidClienteContacto.toString());  
                //throw new MareException(new Exception(), 170280004);
          }

          String codClienteContactado = dtoValidaClie.getClienteContacto();
          //traza("codClienteContactado: " + codClienteContactado);
          // Se ingreso este campo, asi que es logico que se valide el resultado. 
          if (!codClienteContactado.equals(""))
          {
              if((oidClienteContacto != null) && (oidClienteContacto.equals(new Long(0))))
              {
                   
                   throw new MareException(new Exception(), 160310000);
              } 

              if (oidClienteContacto == null)
                  throw new MareException(new Exception(), 160280004);
          }
          else  
          {
            // El campo Codigo Cliente Contactado no se ingreso, asi que por mucho que devuelva null
            // no tira exception.
          }
          // Agregado por SiCC20070433 - Rafael Romero - 24/09/2007 
          Long cte_oid_subtipo_hija_dupla = dtoPestanya3.getCteOidSubTipoHijaDupla(); 
          StringBuffer vectorRetorno = new StringBuffer();; 
          vectorRetorno.append("["+cte_oid_subtipo_hija_dupla); 
          if(subTipoL!=null && subTipoL.equals(cte_oid_subtipo_hija_dupla)){ 
                           vectorRetorno.append(","+dtoPestanya3.getNivelValidacionEdadHijaDupla().toString()); 
                                                      vectorRetorno.append(","+dtoPestanya3.getNivelValidacionTipoHijaDupla().toString()); 
          } 
          vectorRetorno.append("]"); 
          asignarAtributo("VAR","ejecutar","valor","validoOk("+vectorRetorno.toString()+");"); 
          // Fin agregado SiCC20070433 
          asignarAtributo("VAR","ejecutarError","valor","noValido();");

          //conectorAction("LPInsertarCliente");
          //conectorActionParametro("accion", "Siguiente3");
          
    }

    
    public void ProcesarAccionSiguiente3() throws Exception{
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
          MareBusinessID id;
          Vector paramEntrada;
          DTOBelcorp dtoBelcorp;
          DruidaConector conPestanya3;
          

          //var datosP2 = get(formName + ".elementosP2");
          // Proceso los parametros de la Pestanya 2
          String datosP2 = conectorParametroLimpia("elementosP2", "", true);
          //traza("elementosP2:" + datosP2);
          conectorParametroSesion("elementosP2", datosP2);

          String hidListaVinculo = conectorParametroLimpia("hidListaVinculo", "", true);
          //traza("hidListaVinculo:" + hidListaVinculo);
          conectorParametroSesion("hidListaVinculo", hidListaVinculo);

          String hidListaObservacion = conectorParametroLimpia("hidListaObservacion", "", true);
          //traza("hidListaObservacion:" + hidListaObservacion);
          conectorParametroSesion("hidListaObservacion", hidListaObservacion);

          String hidListaPrefe = conectorParametroLimpia("hidListaPrefe", "", true);
          //traza("hidListaPrefe:" + hidListaPrefe);
          conectorParametroSesion("hidListaPrefe", hidListaPrefe);

          // Proceso los parametros de la Pestanya 4
          String datosP4 = conectorParametroLimpia("elementosP4", "", true);
          //traza("elementosP4:" + datosP4);
          conectorParametroSesion("elementosP4", datosP4);

          String hidListaTarjetas = conectorParametroLimpia("hidListaTarjetas", "", true);
          //traza("hidListaTarjetas:" + hidListaTarjetas);
          conectorParametroSesion("hidListaTarjetas", hidListaTarjetas);

          String hidListaClasificacion = conectorParametroLimpia("hidListaClasificacion", "", true);
          //traza("hidListaClasificacion:" + hidListaClasificacion);
          conectorParametroSesion("hidListaClasificacion", hidListaClasificacion);

          String hidListaProbSolu = conectorParametroLimpia("hidListaProbSolu", "", true);
          //traza("hidListaProbSolu:" + hidListaProbSolu);
          conectorParametroSesion("hidListaProbSolu", hidListaProbSolu);
/***************************************************************************************/
          id = new MareBusinessID("MAEPestanya3");

          DTOValidarClientes dtoValidaClie = new DTOValidarClientes();
          dtoValidaClie.setIpCliente(utilidadesBelcorp.getIPCliente(this));
          dtoValidaClie.setPrograma("LPInsertarCliente");
          

          //          clientesVinculo: rellenamos un array con los valores de los campos
          //          clienteVinculoN, respetando el orden de N, de menor a mayor 
          String[] codiClie = this.getClientesVinculo();
          //traza("Clientes: " + codiClie);

          if (codiClie != null) 
          {
             

              dtoValidaClie.setClientesVinculo(codiClie); //String[]
              

              Long[] codiPais = new Long[codiClie.length];
              Long tempi = utilidadesSesion.getPais(this);

              for (int y = 0; y < codiClie.length; y++)
                    codiPais[y] = tempi;


              dtoValidaClie.setPaisesVinculo(codiPais); //Long[]                      
          }


          //dtoValidaClie.setPaisContactado((hidcbPaisContactado == "") ? null: Long.valueOf( hidcbPaisContactado));
          dtoValidaClie.setPaisContactado(utilidadesSesion.getPais(this));

          dtoValidaClie.setClienteContacto(hidtextCodClienteContactado);
          //traza("Long.valueOf(hidcbTipoClienteContactado):" + hidcbTipoClienteContactado);

          // by ssantana, inc. 4950.
          if ((hidcbTipoClienteContactado == null) || hidcbTipoClienteContactado.equals("")) {
              dtoValidaClie.setTipoClienteContacto(null);
          } else {
              dtoValidaClie.setTipoClienteContacto(Long.valueOf(hidcbTipoClienteContactado));
          }



          Long tipoL = ((StrTipo == null) || (StrTipo.length() == 0)) ? null
                                                                                        : Long.valueOf(StrTipo);
          Long subTipoL = ((StrSubTipo == null) || (StrSubTipo.length() == 0))
              ? null : Long.valueOf(StrSubTipo);
          dtoValidaClie.setSubtipoCliente((subTipoL == null) ? null : subTipoL);
          dtoValidaClie.setOidIdioma(utilidadesSesion.getIdioma(this));
          dtoValidaClie.setOidPais(utilidadesSesion.getPais(this));

          paramEntrada = new Vector();

          //          paramEntrada.add(dtoe2);
          paramEntrada.add(dtoValidaClie);
          paramEntrada.add(id);
          //traza("DTOValidarClientes: " + dtoValidaClie);

          /*if (dtoValidaClie.getClientesVinculo() != null) {
              for (int t = 0; t < dtoValidaClie.getClientesVinculo().length;
                         t++) {
                    traza("DTOValidarClientes: " + getClientesVinculo()[t]);
              }
          }*/

          //traza("getPaisContactado() : " + dtoValidaClie.getPaisContactado());
          //traza("getClienteContacto() : " + dtoValidaClie.getClienteContacto());
          //traza("getTipoClienteContacto() : " + dtoValidaClie.getTipoClienteContacto());

          //------------- Conectar
          conPestanya3 = conectar("ConectorObjetoGenerico", paramEntrada);
          //traza("Despues de Conectar");

          //-- se adelanta el chequeo de errores de negocio
          DTOPestanya3 dtoPestanya3 = (DTOPestanya3) conPestanya3.objeto("DTOSalida");
          //traza("dtoPestanya3:" + dtoPestanya3);

          //-------
          // faltaria chequeo de nulls, si pestanya3 ==null esto pincha mas abajo
          // El error MAE-20 nunca es tirado, ya que su condicion coincide con la del 19, aunque el 20 es un poco mas especifico
          //traza("Siguiente3_12 dtoPestanya3.getOidClientesVinculo()" + dtoPestanya3.getOidClientesVinculo());

          //if (dtoPestanya3.getOidClientesVinculo() == null) {
          //    traza("Lanze exception MAE0020");

              //asignarAtributo("VAR", "hidSaldo", "valor", dtoP2Base.getSaldo());
            //  throw new MareException(new Exception(), 170280003);
      //  }

          Long[] oidClienteV = new Long[dtoPestanya3.getOidClientesVinculo().length];

          oidClienteV = dtoPestanya3.getOidClientesVinculo();


          RecordSet clienteV = new RecordSet();
          clienteV.addColumn("OID");
          clienteV.addColumn("CLIENTEVINCULO");


          StringBuffer cliVinc = new StringBuffer();

          for (int i = 1; i < (dtoPestanya3.getOidClientesVinculo().length + 1);
                    i++) {
              /*traza("Siguiente3_12_2 coco " + i + "--" +
                    dtoPestanya3.getOidClientesVinculo()[i - 1]);*/

              // segun el MON, si un vinculo es invalido, se devuelve el DTOPestanya3 vacio
              // y no un null en el array de oids
              if (oidClienteV[i - 1] == null) {
                    /*Mostramos el mensaje de error MAE-0020 (El cliente de vínculo no existe)
                    La pantalla asociada es Pestanya2 y restauramos los valores de los campos.*/

                    //TODO:  rebote


                    //asignarAtributo("VAR", "hidSaldo", "valor", dtoP2Base.getSaldo());
                    throw new MareException(new Exception(), 160280003);
              } else {
                    /*guardamos el valor de cada elemento del array en campos ocultos "oidClienteVinculoN",
                     * donde N es la posicion del elemento en el array + 1 (para que empiece en 1 la
                     * numeracion de los campos)*/
                    Long clieVinculo = oidClienteV[i - 1];

                    if (i != 1) {
                         cliVinc.append("," + clieVinculo);
                    } else {
                         cliVinc.append("" + clieVinculo);
                    }

                    // Viejo-->
                    clienteV.addRow(new Object[] { new Integer(i), clieVinculo });

                    // asignarAtributo("VAR", "hidOidClienteVinculo", "valor", oidClienteVinculo);
              }
          }
          
          asignarAtributo("VAR", "listaVinculosOid", "valor", cliVinc.toString());

          // asignarAtributo("VAR", "hidOidClienteVinculo", "valor", oidClienteVinculo);
          //si no encontro nignun cliente nulo
          Vector clienteVCol = new Vector();
          clienteVCol = clienteV.getColumnIdentifiers();

          DruidaConector conclieVinculo = generarConector("DTOSalida.clientevinculo_ROWSET", clienteV, clienteVCol);
          this.crearListaLP(clienteVCol, clienteVCol.size(), "CAPAVinculoOID", "listaocultaClienteV", "0", "0");

          asignar("LISTA", "listaocultaClienteV", conclieVinculo,"DTOSalida.clientevinculo_ROWSET");

          //-- la otra exception
          Long oidClienteContacto = dtoPestanya3.getOidClienteContacto();
          //traza("oidClienteContacto: " + oidClienteContacto);

          if (oidClienteContacto != null) {
              asignarAtributo("VAR", "hidOidClienteCont", "valor",
                    oidClienteContacto.toString());
          }

          //----
          DTOPestanya3Base dtoPestanya3Base = (DTOPestanya3Base) dtoPestanya3.getBase();
          //traza("Siguiente3_6" + dtoPestanya3Base);

          // combo tipos direccion
          RecordSet tiposDireccion = (RecordSet) dtoPestanya3Base.getTiposDirecciones();
          utilidadesBelcorp.agregarRegistroVacio(tiposDireccion, 0);

          Vector tiposDireccionCol = new Vector();
          tiposDireccionCol = tiposDireccion.getColumnIdentifiers();

          DruidaConector conTipoDire = generarConector("DTOSalida.tiposdireccion_ROWSET",
                    tiposDireccion, tiposDireccionCol);
          asignar("COMBO", "comboTipoDireccion", conTipoDire,
              "DTOSalida.tiposdireccion_ROWSET");

          //traza("Siguiente3_9");

          RecordSet marcasGrupo = (RecordSet) dtoPestanya3Base.getMarcas();
          utilidadesBelcorp.agregarRegistroVacio(marcasGrupo, 0);

          Vector marcasGrupoCol = new Vector();
          marcasGrupoCol = marcasGrupo.getColumnIdentifiers();

          DruidaConector conMarcasGrupo = generarConector("DTOSalida.marcasgrupo_ROWSET",
                    marcasGrupo, marcasGrupoCol);
          asignar("COMBO", "comboMarca", conMarcasGrupo,
              "DTOSalida.marcasgrupo_ROWSET");

          //      RecordSet canales = (RecordSet) dtoPestanya3Base.getCanales();
          //      Vector canalesCol = new Vector();
          //      canalesCol = canales.getColumnIdentifiers();
          //traza("Siguiente3_10");

          //          DruidaConector conCanales = generarConector("DTOSalida.canales_ROWSET", canales, canalesCol);
          //          asignar("COMBO", "cb?????", conCanales, "DTOSalida.canales_ROWSET");
          String usaGeoreferenciador = null;

          if (dtoPestanya3Base.getUsaGeoreferenciador().booleanValue()) {
              /*se oculta el combo tipoVia (que no se rellena)
              se muestran los campos nombreViaN y se ocultan los ViaN*/
              usaGeoreferenciador = "true";
          } else {
              /*se muestran los combos tipoViaN y se rellenan con el atributo del mismo nombre
                se muestran los campos ViaN, que no se cargan ahora sino que se recargará
              con DruidaTransaction según cambie el combo tipoVia.
                ocultamos los campos nombreViaN*/
              usaGeoreferenciador = "false";
                           /* Cleal Mae-
              RecordSet tiposVia = dtoPestanya3Base.getTipoVia();
              utilidadesBelcorp.agregarRegistroVacio(tiposVia, 0);
              traza(tiposVia);

              // Comentado. Por druida transaction, esto deberia conectarse desde la pagina
              Vector colID = tiposVia.getColumnIdentifiers();
              DruidaConector dtipo = this.generarConector("DTOSalida.tipoVia_ROWSET",
                         tiposVia, colID);
              asignar("COMBO", "comboTipoVia", dtipo, "DTOSalida.tipoVia_ROWSET");
                            */
          }
                   //Cleal
                            RecordSet tiposVia = dtoPestanya3Base.getTipoVia();
              utilidadesBelcorp.agregarRegistroVacio(tiposVia, 0);
              //traza(tiposVia);

              // Comentado. Por druida transaction, esto deberia conectarse desde la pagina
              Vector colID = tiposVia.getColumnIdentifiers();
              DruidaConector dtipo = this.generarConector("DTOSalida.tipoVia_ROWSET",
                         tiposVia, colID);
              asignar("COMBO", "comboTipoVia", dtipo, "DTOSalida.tipoVia_ROWSET");

          //traza("Siguiente3_11");
          asignarAtributo("VAR", "usaGeoreferenciador", "valor",
              usaGeoreferenciador);

          //-- aca hiba antes el trato de errores de negocio especiales
          hidPais = utilidadesSesion.getPais(this).toString();
          //traza("Siguiente3_13_1 ");
          asignarAtributo("VAR", "hidPais", "valor", hidPais);

          RecordSet tipoComunicacion = (RecordSet) dtoPestanya3.getTiposComunicacion();
          //traza("Siguiente3_13_2 " + tipoComunicacion);
          utilidadesBelcorp.agregarRegistroVacio(tipoComunicacion, 0);

          Vector tiposComuCol = new Vector();
          tiposComuCol = tipoComunicacion.getColumnIdentifiers();
          //traza("Siguiente3_13_3 " + tiposComuCol);

          DruidaConector conTipoComu = generarConector("DTOSalida.tiposComunicacion_ROWSET",
                    tipoComunicacion, tiposComuCol);
          
          tiposComuCol = tipoComunicacion.getColumnIdentifiers();

          asignar("COMBO", "comboTipoComunicacion", conTipoComu,
              "DTOSalida.tiposComunicacion_ROWSET");


          /*Los combos intervaloComunicacion y diasComunicacion se cargan con
          * los datos fijos que se indican en la descripcion de la pantalla*/
          //traza("******************Fin Accion Siguiente3*********************");
    }

    /************************************************************/
    public void ProcesarAccionSiguiente4() throws Exception {
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
          MareBusinessID id;
          Vector paramEntrada;
          DTOBelcorp dtoBelcorp;
          DruidaConector conPestanya4;

          //Grupo marcas Pestanya3
          String oidMarca = conectorParametroLimpia("hidOidMarca", "", true);

          

          // obtengo post de pestanya 3
          elementosP3 = conectorParametroLimpia("elementosP3", "", true);
          //traza("elementosP3:" + elementosP3);
          conectorParametroSesion("elementosP3", elementosP3);

          hidListaDirecciones = conectorParametroLimpia("hidListaDirecciones",
                    "", true);
          //traza("hidListaDirecciones:" + hidListaDirecciones);
          conectorParametroSesion("hidListaDirecciones", hidListaDirecciones);

          hidListaComunicacion = conectorParametroLimpia("hidListaComunicacion",
                    "", true);
          //traza("hidListaComunicacion:" + hidListaComunicacion);
          conectorParametroSesion("hidListaComunicacion", hidListaComunicacion);

          hidListaMarca = conectorParametroLimpia("hidListaMarca", "", true);
          //traza("hidListaMarca:" + hidListaMarca);
          conectorParametroSesion("hidListaMarca", hidListaMarca);

          DTOObtenerPestanya4 dtoObtenerP4 = new DTOObtenerPestanya4();
          dtoObtenerP4.setIpCliente(utilidadesBelcorp.getIPCliente(this));
          dtoObtenerP4.setPrograma("LPInsertarCliente");

          //dtoObtenerP4.setSubtipoCliente();
          dtoObtenerP4.setOidIdioma(utilidadesSesion.getIdioma(this));
          dtoObtenerP4.setOidPais(utilidadesSesion.getPais(this));

          //DTOOID dtoe = new DTOOID();
          //dtoe.setOidIdioma(utilidadesSesion.getIdioma(this));
          //dtoe.setOidPais(utilidadesSesion.getPais(this));
          //dtoe.setOid(new Long(1));
          StringTokenizer stk = new StringTokenizer(hidListaMarca, ";");
          Long[] miArr = new Long[stk.countTokens()];
          int a = 0;

          String valorMarca = "1";
          String comboMarca_valor;

          while (stk.hasMoreTokens()) {
              comboMarca_valor = stk.nextToken();

              StringTokenizer stk2 = new StringTokenizer(comboMarca_valor, "=");

              while (stk2.hasMoreTokens()) {
                    stk2.nextToken();

                    if (stk2.hasMoreTokens()) {
                         valorMarca = stk2.nextToken();
                    }
              }

              miArr[a] = ((valorMarca.length() == 0) ? null
                                                                  : Long.valueOf(valorMarca));
              a++;
          }

          dtoObtenerP4.setMarcasElegidas(miArr);

          StringTokenizer stk1 = new StringTokenizer(StrSubTipo, ",");
          String elem = conectorParametroLimpia("elementos", "", true);
          //traza("elem: " + elem);

          // Parsea elem para obtener los subtipos:
          //Long[] miArr1 = this.parseaSubTipos(elem);
          //Long[] miArr1 = new Long[2];
          
          // Parsea elem para obtener RecordSet tipos y subtipos, y array de oid Subtipo
          Vector v = this.obtieneTipos(elem);
          RecordSet rTipos = (RecordSet) v.get(0);
          RecordSet rSubTipos = (RecordSet) v.get(1);
          Long[] oidSubtipos = (Long[]) v.get(2);

          //traza("rTipos: " +rTipos);
          //traza("rSubTipos: " + rSubTipos);

          //  Asigna el RecordSet rTipos al combo de la pagina.

          DruidaConector conTipoCliente = UtilidadesBelcorp.generarConector("tiposCliente", rTipos, rTipos.getColumnIdentifiers() );

          this.asignar("COMBO", "cbTipoCliente", conTipoCliente, "tiposCliente");


          DruidaConector conSubtipoCliente = UtilidadesBelcorp.generarConector("subtiposCliente", rSubTipos, rSubTipos.getColumnIdentifiers() );

          this.asignar("LISTADOA", "ListaSubtipo", conSubtipoCliente, "subtiposCliente");


          /*for (int u = 0; u < oidSubtipos.length; u++) {
              traza("oidSubtipos[" + u + "]=" + oidSubtipos[u]);
          }*/

          dtoObtenerP4.setSubtipoCliente(oidSubtipos);
          id = new MareBusinessID("MAEPestanya4");
          paramEntrada = new Vector();

          //traza("dtoObtenerP4: " + dtoObtenerP4.toString());
          paramEntrada.add(dtoObtenerP4);

          //paramEntrada.add(dtoe);
          paramEntrada.add(id);
          conPestanya4 = conectar("ConectorObjetoGenerico", paramEntrada);

          //                    DTOPestanya4 dtoP4 = (DTOPestanya4) conPestanya4.objeto("DTOPestanya4");
          DTOPestanya4 dtoP4 = (DTOPestanya4) conPestanya4.objeto("DTOSalida");
          

          //lista Grupo Clasificacion
          //marcasSeleccionadas esto es un String que lo tengo que asignar al combo de marcas
          //asignar("COMBO", "comboMarca", "DTOSalida.marcasclasificacion_ROWSET");
          RecordSet canales = (RecordSet) dtoP4.getCanales();

          utilidadesBelcorp.agregarRegistroVacio(canales, 0);

          Vector canalesCol = new Vector();
          canalesCol = canales.getColumnIdentifiers();

          DruidaConector conCanales = generarConector("DTOSalida.canales_ROWSET",
                    canales, canalesCol);
          asignar("COMBO", "comboCanal", conCanales, "DTOSalida.canales_ROWSET");


          RecordSet tipoClasif = (RecordSet) dtoP4.getTiposClasificacion();
          //traza("Tipo Clasificacion: " + tipoClasif);
          
          //tipoClasif.removeColumn(1);
          //utilidadesBelcorp.agregarRegistroVacio(tipoClasif, 0);

          Vector tipoClasifCol = new Vector();
          tipoClasifCol = tipoClasif.getColumnIdentifiers();

          DruidaConector conTipoClasif = generarConector("DTOSalida.tiposclasificacion_ROWSET",
                    tipoClasif, tipoClasifCol);

          this.crearListaLP(tipoClasifCol, tipoClasif.getColumnCount(), "Capa2", "ListaTipoClasi", "14", "200");
          asignar("LISTA", "ListaTipoClasi", conTipoClasif, "DTOSalida.tiposclasificacion_ROWSET");
                    
/*          asignar("COMBO", "comboTipoClasificacion", conTipoClasif,
              "DTOSalida.tiposclasificacion_ROWSET");*/
          

          // Clasificaciones
          RecordSet clasificacion = (RecordSet) dtoP4.getClasificaciones();
          //traza("Clasificacion:" + clasificacion);

          // clasificacion.removeColumn(1);
          //utilidadesBelcorp.agregarRegistroVacio(clasificacion, 0);

          Vector clasificacionCol = new Vector();
          clasificacionCol = clasificacion.getColumnIdentifiers();

          DruidaConector conClasif = generarConector("DTOSalida.clasificaciones_ROWSET",
                    clasificacion, clasificacionCol);

          this.crearListaLP(clasificacionCol, clasificacion.getColumnCount(),
              "Capa1", "Lista1", "14", "200");
          asignar("LISTA", "Lista1", conClasif, "DTOSalida.clasificaciones_ROWSET");

          //          asignar("COMBO", "comboClasificacion", conClasif, "DTOSalida.clasificaciones_ROWSET");

          // Pongo la imagen de obligatorio (*) en los siguientes campos (son el 'Grupo2' de VALIDACION) - Inc. 23061
          String indGeo = conectorParametroLimpia("usaGeoreferenciador", "", true);
          traza("indGeo_" + indGeo);
                   if ("true".equals(indGeo)) {
                        asignarAtributo("COMBO", "cbTipoCliente", "req", "S");
              asignarAtributo("COMBO", "cbSubtipoCliente", "req", "S");
              asignarAtributo("COMBO", "comboTipoClasificacion", "req", "S");
              asignarAtributo("COMBO", "comboClasificacion", "req", "S");
                   }


          //Grupo Tarjeta
          RecordSet tiposTarjeta = (RecordSet) dtoP4.getTiposTarjeta();
          utilidadesBelcorp.agregarRegistroVacio(tiposTarjeta, 0);

          Vector tiposTarjetaCol = new Vector();
          tiposTarjetaCol = tiposTarjeta.getColumnIdentifiers();

          DruidaConector conTiposTar = generarConector("DTOSalida.tipostarjeta_ROWSET",
                    tiposTarjeta, tiposTarjetaCol);
          asignar("COMBO", "comboTipoTarjeta", conTiposTar,
              "DTOSalida.tipostarjeta_ROWSET");


          RecordSet clasesTar = (RecordSet) dtoP4.getClasesTarjeta();
          utilidadesBelcorp.agregarRegistroVacio(clasesTar, 0);

          Vector clasesTarCol = new Vector();
          clasesTarCol = clasesTar.getColumnIdentifiers();

          DruidaConector conClasesTar = generarConector("DTOSalida.clasestarjeta_ROWSET",
                    clasesTar, clasesTarCol);
          asignar("COMBO", "comboClasesTarjeta", conClasesTar,
              "DTOSalida.clasestarjeta_ROWSET");


          RecordSet bancos = (RecordSet) dtoP4.getBancos();
          utilidadesBelcorp.agregarRegistroVacio(bancos, 0);

          Vector bancosCol = new Vector();
          bancosCol = bancos.getColumnIdentifiers();

          DruidaConector conBancos = generarConector("DTOSalida.bancos_ROWSET",
                    bancos, bancosCol);
          asignar("COMBO", "comboEntidadBancaria", conBancos,
              "DTOSalida.bancos_ROWSET");


          //Grupo problemas y soluciones
          RecordSet tiposProblem = (RecordSet) dtoP4.getTiposProblema();
          utilidadesBelcorp.agregarRegistroVacio(tiposProblem, 0);

          Vector tiposProblemCol = new Vector();
          tiposProblemCol = tiposProblem.getColumnIdentifiers();

          DruidaConector conTiposProblem = generarConector("DTOSalida.tiposproblemas_ROWSET",
                    tiposProblem, tiposProblemCol);
          asignar("COMBO", "comboTipoProblema", conTiposProblem,
              "DTOSalida.tiposproblemas_ROWSET");


          RecordSet tiposSolu = (RecordSet) dtoP4.getTiposSolucion();

          utilidadesBelcorp.agregarRegistroVacio(tiposSolu, 0);


          Vector tiposSoluCol = new Vector();
          tiposSoluCol = tiposSolu.getColumnIdentifiers();


          DruidaConector conTiposSolu = generarConector("DTOSalida.tipossolucion_ROWSET",
                    tiposSolu, tiposSoluCol);

          asignar("COMBO", "comboTipoSolucion", conTiposSolu,
              "DTOSalida.tipossolucion_ROWSET");

          //traza("******************Fin Accion Siguiente4*********************");
    }

    /************************************************************/
    public void ProcesarAccionGuardar() throws Exception {
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
          MareBusinessID id;
          Vector paramEntrada;
          DTOBelcorp dtoBelcorp;
          DruidaConector conInsertarCliente;

          String registro = "";

          //------------- Variables a guardar --------------
          //variables utilizadas en la accion guardar que pertenecen a la lista
          // grupo identif 
          // String strTipoDocu = "";
          // String strNroDoc = "";
          // String strConfDoc = "";
          // String strDocPpal = "";
          // String strPEmpresa = "";
          //Grupo direcciones                
          String listaDireccion = conectorParametroLimpia("hidListaDireccion",
                    "", true);
          String unidadGeo = "";
          String tipoDire = "";
          String tipoVia = "";
          String nombreVia = "";
          String nroPpal = "";
          String codPostal = "";
          String oidTerritorioN = conectorParametroLimpia("hidTerritorio", "",
                    true);

          //Grupo marcas Pestanya3
          String oidMarca = conectorParametroLimpia("hidOidMarca", "", true);

          //GrupoClasificacion P4
          String listaClasificacion = conectorParametroLimpia("hidListaClasificacion",
                    "", true);
          String marcaP4 = "";
          String canalP4 = "";
          String tipoClasificacionP4 = "";
          String clasificacionP4 = "";
          String marcasSeleccionadas = conectorParametroLimpia("hidMarcasSeleccionadas",
                    "", true);

          //Grupo Vinculo   listado1
          String listaVinculo = conectorParametroLimpia("hidListaVinculo", "",
                    true);
          String oidClienteVinculo = conectorParametroLimpia("hidOidClienteVinculo",
                    "", true);
          String paisVinculo = "";
          String StrClienteVinculo = "";
          String tipoVinculo = "";
          String fechaDesde = "";
          String fechaHasta = "";
          String vinculoPpal = "";

          //GrupoPreferencias  listado2
          String listaPrefe = conectorParametroLimpia("hidListaPrefe", "", true);
          String tipoPrefe = "";
          String descripcionPrefe = "";

          //String codigoAutomatico = conectorParametroLimpia("hidCodigoAutomatico", "", true);
          //GrupoObservaciones   listado3
          String listaObserva = conectorParametroLimpia("hidListaObserva", "",
                    true);
          String marcaStr = "";
          String nroObservacion = "";
          String texto = "";

          //Grupo comunicacion
          String listaComunica = conectorParametroLimpia("hidListaComunicacion",
                    "", true);
          String strTipoComunicacion = "";
          String diaComunicacion = "";
          String textoComunicacion = "";
          String comunicacionPpal = "";
          String horaDesde = "";
          String horaHasta = "";
          String listaMarcas = conectorParametroLimpia("hidListaMarcas", "", true);

          //Pestanya4
          //GrupoTarjetas 
          String listaTarjeta = conectorParametroLimpia("hidListaTarjeta", "",
                    true);
          String tipoTarjeta = "";
          String clasesTarjeta = "";
          String banco = "";

          //GrupoProblemas y Soluciones
          String listaPSolucion = conectorParametroLimpia("hidListaPSolucion",
                    "", true);
          String tipoProblema = "";
          String descriProblem = "";
          String indSolucion = "";
          String tipoSolucion = "";
          String descriSoluc = "";

          //Atributos nuevos de pestanya3
          String usaGeoreferenciador = conectorParametroLimpia("usaGeoreferenciador",
                    "", true);
          String StrOidClienteContacto = conectorParametroLimpia("hidOidClienteCont",
                    "", true);

          //------------------------------------------------
          traza("******************Accion Guardar*********************");
          pagina("salidaGenerica");

          // Proceso los parametros de la Pestanya 4
          String datosP4 = conectorParametroLimpia("elementosP4", "", true);
          traza("elementosP4:" + datosP4);
          conectorParametroSesion("elementosP4", datosP4);

          String hidListaTarjetas = conectorParametroLimpia("hidListaTarjetas",
                    "", true);
          //traza("hidListaTarjetas:" + hidListaTarjetas);
          conectorParametroSesion("hidListaTarjetas", hidListaTarjetas);

          String hidListaClasificacion = conectorParametroLimpia("hidListaClasificacion",
                    "", true);
          //traza("hidListaClasificacion:" + hidListaClasificacion);
          conectorParametroSesion("hidListaClasificacion", hidListaClasificacion);

          String hidListaProbSolu = conectorParametroLimpia("hidListaProbSolu",
                    "", true);
          //traza("hidListaProbSolu:" + hidListaProbSolu);
          conectorParametroSesion("hidListaProbSolu", hidListaProbSolu);

          //--------------------------------------------------------------
          


          //--------------------------------------------------------------
          id = new MareBusinessID("MAEInsertarCliente");

          DTOCrearClienteBasico dtoCrearClienteB = new DTOCrearClienteBasico();
          dtoCrearClienteB.setOidPais(utilidadesSesion.getPais(this));
          dtoCrearClienteB.setOidIdioma(utilidadesSesion.getIdioma(this));

          Date fech = toDate(hidtxtFechaIngresoActual);

          dtoCrearClienteB.setFechaIngreso(new Date(System.currentTimeMillis()));

          DTOTipoSubtipoCliente[] dtoTipoSubClie = procesarPestanya0Guardar();

          //                  DTOTipoSubtipoCliente dtoTemp = new DTOTipoSubtipoCliente();
          //                  dtoTemp.setTipo(new Long(1));
          //                  dtoTemp.setSubtipo(new Long(1));
          //                  dtoTemp.setPrincipal(new Boolean(true));
          //dtoTipoSubClie[0] = dtoTemp;
          // recupero los tipos
          dtoCrearClienteB.setTiposSubtipos(dtoTipoSubClie);
          //traza("Guardar 2 : dtoTipoSubClie[0] " + dtoTipoSubClie[0]);
          //traza("codigo de cliente a la hora de guardar " + hidtextCodCliente);

          dtoCrearClienteB.setCodigoCliente((((hidtextCodCliente == null) ||
              (hidtextCodCliente.length() == 0)) ? "" : hidtextCodCliente));
          dtoCrearClienteB.setDigitoControl((((hidDigitoControl == null) ||
              (hidDigitoControl.length() == 0)) ? "0" : hidDigitoControl));
                  //traza("UsaGeoreferenciador: "+usaGeoreferenciador);
                   if("true".equals(usaGeoreferenciador)){
                           dtoCrearClienteB.setUsaGeoreferenciador(new Boolean(true));
                   } else{
                           dtoCrearClienteB.setUsaGeoreferenciador(new Boolean(false));
                   }

          //lista Grupo Identificacion 
          // parseo de las lineas identificacion
          //traza("*************** procesarPestanya1Guardar() **************");

          DTOIdentificacion[] dtoIdentif = procesarPestanya1Guardar();
          //traza("*************** DTOIdentificacion[] **********");

          /*for (int g = 0; g < dtoIdentif.length; g++) {
              traza(dtoIdentif[g]);
          }*/

          //traza("************* End DTOIdentificacion[] ********");
          dtoCrearClienteB.setIdentificaciones(dtoIdentif);


          traza("Ape:" + hidtextApellido1 + "|Ape2:" + hidtextApellido2 +
              "|ApeCas:" + hidtextApellidoCasada + "|Nom1:" + hidtextNombre1 +
              "|Nom2:" + hidtextNombre2 + "|Tra:" + hidcbTratamiento + "|Fech:" +
              hidtxtFechaIngresoActual + "|FP:" + hidcbFormaPago + "|Sex:" +
              hidrbSexo);
          dtoCrearClienteB.setApellido1(hidtextApellido1);
          dtoCrearClienteB.setApellido2(hidtextApellido2);
          dtoCrearClienteB.setApellidoCasada(hidtextApellidoCasada);
          dtoCrearClienteB.setNombre1(hidtextNombre1);
          dtoCrearClienteB.setNombre2(hidtextNombre2);
          dtoCrearClienteB.setTratamiento(hidcbTratamiento);
          dtoCrearClienteB.setTratamientoDesc(hidcbTratamientoDesc);
          dtoCrearClienteB.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
          dtoCrearClienteB.setPrograma(UtilidadesSession.getFuncion(this));

          traza("bloque 1");
          String sex = null;

          if (hidrbSexo.equals("S")) {
              sex = new String("M");
          } else {
              sex = new String("F");
          }

          dtoCrearClienteB.setSexo(sex);

          dtoCrearClienteB.setFechaIngreso(toDate(hidtxtFechaIngresoActual));

          dtoCrearClienteB.setFormaPago(((hidcbFormaPago.equals("")) ? null
                                                                                      : Long.valueOf(
                    hidcbFormaPago)));


                  traza("bloque 2");
      

          //Pestanya3 Grupo Direcciones
          //dtoCrearClienteB.setDirecciones(dtodireccion[]para cada conj de campos que forman
          //una direccion rellenamos cada atributo con una exceptionMIRRAAARRRR);
          DTODireccion[] dtoDire = procesarPestany3DireccionGuardar();
          dtoCrearClienteB.setDirecciones(dtoDire);

          /*for (int g = 0; g < dtoDire.length; g++) {
              traza(dtoDire[g]);
          }*/

         
                   traza("bloque 3");

          DTOClienteMarca[] dtoClienteMarca = procesarPestany3MarcaGuardar();
          dtoCrearClienteB.setMarcas(dtoClienteMarca);


          /*for (int g = 0; g < dtoClienteMarca.length; g++) {
              traza(dtoClienteMarca[g]);
          }*/

                    traza("bloque 4");
          DTOClasificacionCliente[] dtoClasiC = procesarPestany4ClasificacionGuardar();
          dtoCrearClienteB.setClasificaciones(dtoClasiC);

          traza("bloque 5");
          /*for (int g = 0; g < dtoClasiC.length; g++) {
              traza(dtoClasiC[g]);
          }*/

          

          /*
          dtoCrearClienteB.setUsaGeoreferenciador(((usaGeoreferenciador == "0") ? Boolean.FALSE
                                                                                           : Boolean.TRUE));
          */


          //***************************************************************************************
          DTOCliente dtoCliente = new DTOCliente();
          dtoCliente.setBase(dtoCrearClienteB);
          dtoCliente.setIpCliente(utilidadesBelcorp.getIPCliente(this));
          dtoCliente.setPrograma("LPInsertarCliente");
          //procesarPestanya2Basicos(dtoCliente);
          //Incidencia DBLG400000926 pzerbino 11/01/2006
          //No estaba contemplando que devolviera el dtoCliente se modifica
          //la funcion antes no devolvia nada
          
          dtoCliente =  procesarPestanya2Basicos(dtoCliente);

          DTOVinculo[] dtoVinc = procesarPestany2VinculosGuardar();
          dtoCliente.setVinculos(dtoVinc);

                    traza("bloque 6");
          /*for (int g = 0; g < dtoVinc.length; g++) {
             traza(dtoVinc[g]);
          }*/



          DTOPreferencia[] dtoPrefe = procesarPestany2PreferenciasGuardar();
          dtoCliente.setPreferencias(dtoPrefe);


          /*for (int g = 0; g < dtoPrefe.length; g++) {
              traza(dtoPrefe[g]);
          }*/

                    traza("bloque 7");

          DTOObservacion[] dtoObs = procesarPestany2ObservacionGuardar();
          dtoCliente.setObservaciones(dtoObs);

          traza("bloque 8");
          /*for (int g = 0; g < dtoObs.length; g++) {
              traza(dtoObs[g]);
          }*/



          DTOComunicacion[] dtoCom = procesarPestany3ComunicacionGuardar();
          dtoCliente.setComunicaciones(dtoCom);
                    traza("bloque 9");

          /*for (int g = 0; g < dtoCom.length; g++) {
              traza(dtoCom[g]);
          }*/


          DTOTarjeta[] dtoTar = procesarPestany4TarjetaGuardar();
          dtoCliente.setTarjetas(dtoTar);

          /*for (int g = 0; g < dtoTar.length; g++) {
              traza(dtoTar[g]);
          }*/
                   traza("bloque 10");


          DTOProblemaSolucion[] dtoProblemSolu = procesarPestany4ProblemaSolucionGuardar();
          dtoCliente.setProblemasSoluciones(dtoProblemSolu);
                    traza("bloque 11");

          /*for (int g = 0; g < dtoProblemSolu.length; g++) {
              traza(dtoProblemSolu[g]);
          }*/

          id = new MareBusinessID("MAEInsertarCliente");
          paramEntrada = new Vector();
          paramEntrada.add(dtoCliente);
          paramEntrada.add(id);
          //traza("LLamando a ID=MAEInsertarCliente con:" + dtoCliente);

          //por incidencia BELC300014757 puede no tener clasificaciones
          //traza("ID=getClasificaciones con:" + dtoCliente.getBase().getClasificaciones());

          /*for (int z = 0; z <dtoCliente.getBase().getTiposSubtipos().length;   z++){
             traza("ID=getTiposSubtipos conssss" +z+ ":" + dtoCliente.getBase().getTiposSubtipos()[z]);
          }*/
          
          conInsertarCliente = conectar("ConectorObjetoGenerico", paramEntrada);

          DTOPremioRecomendacion dtoPremioR = (DTOPremioRecomendacion) conInsertarCliente.objeto(
                    "DTOSalida");

          Long recomendado = dtoPremioR.getClienteRecomendado();
          Long recomendante = dtoPremioR.getClienteRecomendante();
          Long periodoContacto = dtoCliente.getPeriodoContacto();
          
          if ((recomendado != null) && (recomendante != null) && (periodoContacto != null)) {
              traza("Entro recomendante y rrecomendado");
              conectorAction("LPElegirPremiosRecomendacion");
              conectorActionParametro("accion", "");
              conectorActionParametro("hidRecomendado", recomendado.toString());
              conectorActionParametro("hidRecomendante", recomendante.toString());
              conectorActionParametro("hidPeriodoContacto", periodoContacto.toString());
          } else {
              //conectorAction("LPInsertarCliente");
              //conectorActionParametro("accion", "");
            
              //agregado applet
              if(origen.equals("applet")){
                  this.asignarAtributo("VAR", "hCerrarVentana", "valor", "S");
              }else{
                  conectorAction("LPInsertarCliente");
                  conectorActionParametro("accion", "");
              }
          }

          traza("******************Fin Accion Guardar*****************");
    }

    /************************************************************/
    private void logStackTrace(Throwable e) {
          ByteArrayOutputStream os = new ByteArrayOutputStream();
          PrintStream ps = new PrintStream(os);
          e.printStackTrace(ps);

          try {
              traza("Se produjo la excepcion: " + e.getMessage() + "\n" +
                    "stackTrace = " + os.toString());
          } catch (Exception ex) {
              //traza ("Error en logStackTrace: " + ex.getMessage ());
              e.printStackTrace();
          }
    }

    /************************************************************/
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

    /************************************************************/
    /*******FECHA**************/
    private Date toDate(String sFecha) throws Exception 
    {
          String fechaLoca = sFecha;
          //fechaLoca = fechaLoca.replace('-', '/');
          formatoFecha = UtilidadesSession.getFormatoFecha(this);
          formatoFechaPais = formatoFecha;
          
          
          asignarAtributo("VAR", "hFormatoFechaPais", "valor", formatoFechaPais);
          formatoFecha = formatoFecha.replace('m', 'M');

          //formatoFecha = formatoFecha.replace('-','/');
          miFecha = new SimpleDateFormat(formatoFecha);
          

          /* La fecha viene de la forma yyyy/MM/dd */

          java.util.Date fecha = miFecha.parse(fechaLoca);
          java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime() );

          //traza("FechaSQL: " + fechaSQL.toString() );
      

          return fechaSQL;
    }    

    /**********************************************************************************************/
    private void crearListaLP(Vector nomColumns, int cantColumns,
          String nomCapa, String nomLista, String XCapa, String YCapa)
          throws Exception {
          //traza("dentro de crearListaLP()  " + nomColumns + " " + cantColumns);

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

          
          if (cantColumns >= 1) {
              eCOL_1.appendChild((Element) columnas.get(0));
              eCABECERA.appendChild(eCOL_1);
              
          }

          if (cantColumns >= 2) {
              eCOL_2.appendChild((Element) columnas.get(1));
              eCABECERA.appendChild(eCOL_2);
              
          }

          if (cantColumns >= 3) {
              eCOL_3.appendChild((Element) columnas.get(2));
              eCABECERA.appendChild(eCOL_3);
              
          }

          if (cantColumns >= 4) {
              eCOL_4.appendChild((Element) columnas.get(3));
              eCABECERA.appendChild(eCOL_4);
              
          }

          if (cantColumns >= 5) {
              eCOL_5.appendChild((Element) columnas.get(4));
              eCABECERA.appendChild(eCOL_5);
              
          }

          if (cantColumns >= 6) {
              eCOL_6.appendChild((Element) columnas.get(5));
              eCABECERA.appendChild(eCOL_6);
              
          }

          Element ePRESENTACION = document.createElement("PRESENTACION");
          Integer ancho = new Integer(cantColumns * anchoCab.intValue());
          ePRESENTACION.setAttribute("ancho", ancho.toString());
          ePRESENTACION.setAttribute("filas", "1");

          int swX1 = 0;
          StringBuffer cadena = new StringBuffer("['datosCamposCenterImpar'");
          //traza("break brain");

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


          ePRESENTACION.setAttribute("bloquesid", cadena.toString());

          Element eROWSET = document.createElement("ROWSET");

          eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
          eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
          eLista.appendChild(eROWSET); //Agrego el rowset de la lista

          eCapa.appendChild(eLista);

          getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);
    }

    /*******************Helper de Car5ga Inicial *******************/
    private ComposerViewElementList crearParametrosEntradaValidar() {
          ComposerViewElementList lista = new ComposerViewElementList();

          // primer combo 
          ComposerViewElement ci1 = new ComposerViewElement();

          return lista;
    }

    /*****************************************************/
    /*****************************************************/

    /*
    * Funcion que setea los componentes de la pagina en funcion a
    * los resultados devueltos por configurar campo
    */

    /**********************************************************/
    private void obtenerConfiguracionCampos(Long tip, Long subTip)
          throws Exception {
          try {
              //traza("obtenerConfiguracionCampos() - Creamos los DTOS");

              Vector field = new Vector();
              DTOConfiguracionCamposCliente dtoConfigClie = new DTOConfiguracionCamposCliente();
              DTOConfiguracionCamposCliente dtoSalida = new DTOConfiguracionCamposCliente();
              DTOCampo[] dtocampo = new DTOCampo[24];
              UtilidadesSession sesion = new UtilidadesSession();

              

              //tipoSubt=(HashMap)conectorParametroSesion("tipoSubtipo");
              // HashMap tipoSubtipo =(HashMap)conectorParametroSesion("tipoSubt");    
              // traza("obtenerConfiguracionCampos() - Tipo y subtipo: " + tipoSubtipo.toString() );
              // if(tipoSubtipo.isEmpty()){
              //  traza("HasMap vacio");
              // }
              

              for (int i = 0; i <= 23; i++) {
                    dtocampo[i] = new DTOCampo();

                    switch (i) {
                    case 0:
                         dtocampo[i].setCodigoCampo("MAECLIEAPELL1");
                         field.addElement(dtocampo[i]);

                         break;

                    case 1:
                         dtocampo[i].setCodigoCampo("MAECLIEAPELL2");
                         field.addElement(dtocampo[i]);

                         break;

                    case 2:
                         dtocampo[i].setCodigoCampo("MAECLIEAPELLCA");
                         field.addElement(dtocampo[i]);

                         break;

                    case 3:
                         dtocampo[i].setCodigoCampo("MAECLIENOM1");
                         field.addElement(dtocampo[i]);

                         break;

                    case 4:
                         dtocampo[i].setCodigoCampo("MAECLIENOM2");
                         field.addElement(dtocampo[i]);

                         break;

                    case 5:
                         dtocampo[i].setCodigoCampo("MAECLIEFECHNA");
                         field.addElement(dtocampo[i]);

                         break;

                    case 6:
                         dtocampo[i].setCodigoCampo("MAECLIECODEMP");
                         field.addElement(dtocampo[i]);

                         break;

                    case 7:
                         dtocampo[i].setCodigoCampo("MAECLIEOCUP");
                         field.addElement(dtocampo[i]);

                         break;

                    case 8:
                         dtocampo[i].setCodigoCampo("MAECLIEPROF");
                         field.addElement(dtocampo[i]);

                         break;

                    case 9:
                         dtocampo[i].setCodigoCampo("MAECLIECENTRA");
                         field.addElement(dtocampo[i]);

                         break;

                    case 10:
                         dtocampo[i].setCodigoCampo("MAECLIECARGO");
                         field.addElement(dtocampo[i]);

                         break;

                    case 11:
                         dtocampo[i].setCodigoCampo("MAECLIECENESTU");
                         field.addElement(dtocampo[i]);

                         break;

                    case 12:
                         dtocampo[i].setCodigoCampo("MAECLIEPERSDEP");
                         field.addElement(dtocampo[i]);

                         break;

                    case 13:
                         dtocampo[i].setCodigoCampo("MAECLIEINGFAM");
                         field.addElement(dtocampo[i]);

                         break;

                    case 14:
                         dtocampo[i].setCodigoCampo("MAECLIEFECHING");
                         field.addElement(dtocampo[i]);

                         break;

                    case 15:
                         dtocampo[i].setCodigoCampo("MAECLIETRAT");
                         field.addElement(dtocampo[i]);

                         break;

                    case 16:
                         dtocampo[i].setCodigoCampo("MAECLIENACIO");
                         field.addElement(dtocampo[i]);

                         break;

                    case 17:
                         dtocampo[i].setCodigoCampo("MAECLIEESTCIV");
                         field.addElement(dtocampo[i]);

                         break;

                    case 18:
                         dtocampo[i].setCodigoCampo("MAECLIENIVESTU");
                         field.addElement(dtocampo[i]);

                         break;

                    case 19:
                         dtocampo[i].setCodigoCampo("MAECLIENSEP");
                         field.addElement(dtocampo[i]);

                         break;

                    case 20:
                         dtocampo[i].setCodigoCampo("MAECLIECICLVID");
                         field.addElement(dtocampo[i]);

                         break;

                    case 21:
                         dtocampo[i].setCodigoCampo("MAECLIESEXO");
                         field.addElement(dtocampo[i]);

                         break;

                    case 22:
                         dtocampo[i].setCodigoCampo("MAECLIEDESCORR");
                         field.addElement(dtocampo[i]);

                         break;

                                      case 23:
                         dtocampo[i].setCodigoCampo("MAECLIEFORMPA");
                         field.addElement(dtocampo[i]);

                         break;

                                      case 24:
                         dtocampo[i].setCodigoCampo("MAECLIEEDAD");
                         field.addElement(dtocampo[i]);

                         break;
                    }
              }

              //tipoSubtipo=(HashMap)conectorParametroSesion("tipoSubtipo");
              dtoConfigClie.setCampos(field);
              

              //             String tipo = tip;//(String) tipoSubtipo.get("h_comboTipoCliente_0");
              //traza("tipo: " + tip.toString());
              dtoConfigClie.setTipo(tip);

              //             String subtipo = (String) tipoSubtipo.get("h_comboSubtipoCliente_0").toString();             
              //traza("subtipo: " + subTip.toString());
              dtoConfigClie.setSubtipo(subTip);


              dtoConfigClie.setOidPais(sesion.getPais(this));

              dtoConfigClie.setOidIdioma(sesion.getIdioma(this));

              dtoSalida = (DTOConfiguracionCamposCliente) obtenerDatosSalida("MAEConfiguracionCamposCliente",
                         "ConectorObjetoGenerico",
                         (DTOConfiguracionCamposCliente) dtoConfigClie);


              Vector resultado = dtoSalida.getCampos();


              //this.asignarAtributo(resultado);
              this.asignarAtributoRequerido(resultado);
          } catch (Throwable th) {
              this.traza("error en ConfiguracionCampos");

              ByteArrayOutputStream stack = new ByteArrayOutputStream();
              PrintStream out = new PrintStream(stack);
              th.printStackTrace(out);
              traza(stack.toString());

              BelcorpError belcorpError = new BelcorpError();
              DTOError dtoError = belcorpError.obtenerError(th,
                         UtilidadesSession.getIdioma_ISO(this), "");
              String s = th.getMessage();
              traza(dtoError.getCodigoError() + " - " +
                    dtoError.getDescripcionError());
              throw ((Exception) th);
          }
    }

    //------------------------------------------------------------------------
    private void asignarAtributoRequerido(Vector resultado)
          throws Exception {
          traza("Entra a asignarAtributoRequerido");

          DTOCampo dtoCampo = null;
          HashMap hashCampos = new HashMap();

          Vector vCampos = new Vector();
          Vector vTipoNombre = new Vector();

          // Apellido 1 
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textApellido1");
          hashCampos.put("MAECLIEAPELL1", vTipoNombre);

          // Apellido 2
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textApellido2");
          hashCampos.put("MAECLIEAPELL2", vTipoNombre);

          // Apellido Casada
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textApellidoCasada");
          hashCampos.put("MAECLIEAPELLCA", vTipoNombre);

          // Apellido Nombre 1 
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textNombre1");
          hashCampos.put("MAECLIENOM1", vTipoNombre);

          // Apellido Nombre 2
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textNombre2");
          hashCampos.put("MAECLIENOM2", vTipoNombre);

          // Fecha Nacimiento
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textFechaNacimiento");
          hashCampos.put("MAECLIEFECHNA", vTipoNombre);

          // Codigo Empleado
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textCodEmpleado");
          hashCampos.put("MAECLIECODEMP", vTipoNombre);

          // Ocupacion 
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textOcupacion");
          hashCampos.put("MAECLIEOCUP", vTipoNombre);

          // Profesion
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textProfesion");
          hashCampos.put("MAECLIEPROF", vTipoNombre);

          // Centro de Trabajo
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textCentroTrabajo");
          hashCampos.put("MAECLIECENTRA", vTipoNombre);

          // Cargo que desempeña
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textCargoDesempena");
          hashCampos.put("MAECLIECARGO", vTipoNombre);

          // Centro Estudios
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textCentroEstudios");
          hashCampos.put("MAECLIECENESTU", vTipoNombre);

          // Personas Dependientes
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textNPersonasDependientes");
          hashCampos.put("MAECLIEPERSDEP", vTipoNombre);

          // Ingresos Familiares
          vTipoNombre = new Vector();
          vTipoNombre.add("CTEXTO");
          vTipoNombre.add("textImporteIngresoFamiliar");
          hashCampos.put("MAECLIEINGFAM", vTipoNombre);

          // Fecha de Ingreso 
          vTipoNombre = new Vector();
          vTipoNombre.add("LABELC");
          vTipoNombre.add("lbl2FechaIngresoActual");
          hashCampos.put("MAECLIEFECHING", vTipoNombre);

          // Tratamiento
          vTipoNombre = new Vector();
          vTipoNombre.add("COMBO");
          vTipoNombre.add("cbTratamiento");
          hashCampos.put("MAECLIETRAT", vTipoNombre);

          // Nacionalidad 
          vTipoNombre = new Vector();
          vTipoNombre.add("COMBO");
          vTipoNombre.add("cbNacionalidad");
          hashCampos.put("MAECLIENACIO", vTipoNombre);

          // Estado Civil
          vTipoNombre = new Vector();
          vTipoNombre.add("COMBO");
          vTipoNombre.add("cbEstadoCivil");
          hashCampos.put("MAECLIEESTCIV", vTipoNombre);

          // Nivel Estudios
          vTipoNombre = new Vector();
          vTipoNombre.add("COMBO");
          vTipoNombre.add("cbNivelEstudios");
          hashCampos.put("MAECLIENIVESTU", vTipoNombre);

          // Nivel Socioeconomico
          vTipoNombre = new Vector();
          vTipoNombre.add("COMBO");
          vTipoNombre.add("cbNivelSocioEconomico");
          hashCampos.put("MAECLIENSEP", vTipoNombre);

          // Ciclo de Vida
          vTipoNombre = new Vector();
          vTipoNombre.add("COMBO");
          vTipoNombre.add("cbCicloVidaFamiliar");
          hashCampos.put("MAECLIECICLVID", vTipoNombre);

          // Sexo
          vTipoNombre = new Vector();
          vTipoNombre.add("RADIOB");
          vTipoNombre.add("rbSexo");
          hashCampos.put("MAECLIESEXO", vTipoNombre);

          // Desea Correspondecia
          vTipoNombre = new Vector();
          vTipoNombre.add("RADIOB");
          vTipoNombre.add("rbDeseaCorrespondencia");
          hashCampos.put("MAECLIEDESCORR", vTipoNombre);

          // Forma de Pago
          vTipoNombre = new Vector();
          vTipoNombre.add("COMBO");
          vTipoNombre.add("cbFormaPago");
          hashCampos.put("MAECLIEFORMPA", vTipoNombre);

          String codigoCampo = null;
          Boolean requerido = null;
          Boolean modificable = null;
          Vector vAsignar = null;
          String nombreCampoXML = null;
          String tipoCampoXML = null;
          StringBuffer sModificable = new StringBuffer();
          String valdef = null;

          // Se utiliza para luego ver cual es el primer control (hasta el combo 
          // forma de Pago en la pantalla) que esta deshabilitado. 
          // (Para setear el foco, ya que un control deshabilitado al focalizar
          // tira error).
          //  - H por Habilitado      
          Vector vCamposFoco = new Vector();
          vCamposFoco.add("textApellido1");
          vCamposFoco.add("textApellido2");
          vCamposFoco.add("textApellidoCasada");
          vCamposFoco.add("textNombre1");
          vCamposFoco.add("textNombre2");
          vCamposFoco.add("cbTratamiento");

          HashMap hshFoco = new HashMap();

          for (int i = 0; i < vCamposFoco.size(); i++)
              hshFoco.put((String) vCamposFoco.get(i), "H");

          StringBuffer obligatorio2 = new StringBuffer("");
          for (int i = 0; i < 24; i++) {
              //traza("AsignarAtributo, bucle " + i);
              dtoCampo = (DTOCampo) resultado.get(i);
              codigoCampo = dtoCampo.getCodigoCampo();

              //traza("    - codigo Campo: " + codigoCampo );
              requerido = dtoCampo.getObligatorio();
              modificable = dtoCampo.getModificable();
              valdef = dtoCampo.getValorDefecto();

              vAsignar = (Vector) hashCampos.get(codigoCampo);
              tipoCampoXML = (String) vAsignar.get(0);
              nombreCampoXML = (String) vAsignar.get(1);
              //traza("nombreCampo: " + nombreCampoXML);

              //traza("el valor por defecto es " + valdef);

              if ((valdef != null) && !valdef.equals("")) {
                    //traza("el valor por defecto dentro del for es " + valdef); 

                    asignarAtributo(tipoCampoXML, nombreCampoXML, "valor", valdef);

                    if(nombreCampoXML.equals("cbTratamiento")){
                        asignarAtributo("VAR", "valDefTratamiento", "valor", valdef);
                    }

                                         if(nombreCampoXML.equals("rbSexo")){
                        asignarAtributo("VAR", "valDefSexo", "valor", valdef);
                    }
                    
                    if(nombreCampoXML.equals("cbNacionalidad")){
                        asignarAtributo("VAR", "valDefNacionalidad", "valor", valdef);
                    }

                    if(nombreCampoXML.equals("cbEstadoCivil")){
                        asignarAtributo("VAR", "valDefEstCivil", "valor", valdef);
                    }

                    if(nombreCampoXML.equals("cbNivelEstudios")){
                        asignarAtributo("VAR", "valDefNivEst", "valor", valdef);
                    }

                    if(nombreCampoXML.equals("cbNivelSocioEconomico")){
                        asignarAtributo("VAR", "valDefNivSocEco", "valor", valdef);
                    }
              
                    if(nombreCampoXML.equals("cbCicloVidaFamiliar")){
                      asignarAtributo("VAR", "valDefCicVidFam", "valor", valdef);
                    }

                    if(nombreCampoXML.equals("cbFormaPago")){
                      asignarAtributo("VAR", "valDefFormPago", "valor", valdef);
                    }

                    if(nombreCampoXML.equals("rbDeseaCorrespondencia")){
                      asignarAtributo("VAR", "valDefDeseaCorrespondencia", "valor", valdef);
                    }
                    
              }



              // Obligatoriedad

              if (requerido.booleanValue() == true) {
                    //traza("dentro del if de obligatorio");
                    this.asignarAtributo(tipoCampoXML, nombreCampoXML, "req", "S");
                    if (!obligatorio2.toString().equals("") )
                      obligatorio2.append(",");
                    
                    obligatorio2.append(nombreCampoXML);
                    //this.asignarAtributo(tipoCampoXML, nombreCampoXML, "msjreq", "javascript:GestionarMensaje('6')");                    
                    //this.asignarAtributoElementoValidacion(nombreCampoXML,
                     //   "required", "true");
              } else {
                    this.asignarAtributo(tipoCampoXML, nombreCampoXML, "req", "N");
              }
              traza("Obligatorios2: " + obligatorio2.toString() );
              this.asignarAtributo("VAR", "obligatorio", "valor", obligatorio2.toString() );

              // Modificabilidad
              if (modificable.booleanValue() == false) {
                    if (!nombreCampoXML.equals("lbl2FechaIngresoActual")) {
                         if (sModificable.length() > 0) {
                              // Ya se agrego al menos 1 campo, por lo que al siguiente (éste campo)
                              // se le antepone una coma.
                              sModificable.append(",");
                         }

                         sModificable.append(nombreCampoXML);
                         hshFoco.put(nombreCampoXML, "D");
                    }
              }
          }
           // Fin bucle de 23 campos.

          // Chequea si algun campo es no modificable. t
          String sCampoFocalizado = "textApellido1"; // Por defecto, forma de Pago.      
          //traza("longitud sModificable: " + sModificable.length());

          if (sModificable.length() > 0) {
              this.asignarAtributo("VAR", "modificabilidad", "valor",
                    sModificable.toString());
              //traza("Cadena modificabilidad: " + sModificable.toString());

              // Chequea el HashMap para ver cual es el primer campo no deshabilitado (si hay uno)
              boolean continuar = true;
              int i = 0;
              String sBufferCampo = "";
              sCampoFocalizado = "cbFormaPago"; // Por defecto, forma de Pago.

              while ((i < vCamposFoco.size()) && (continuar == true)) {
                    sBufferCampo = (String) hshFoco.get((String) vCamposFoco.get(i));

                    if (sBufferCampo.equals("H")) {
                         // Este es el primer campo no deshabilitado, que deberia tomar el foco. 
                         // Setea este campo y termina el bucle.
                         sCampoFocalizado = (String) vCamposFoco.get(i);
                         continuar = false;
                    }

                    i++;
              }
          }

          
          asignarAtributo("VAR", "campoToFocalizar", "valor", sCampoFocalizado);
    }

    /*******************************************************/
    private Object obtenerDatosSalida(String bID, String conector, Object dto)
          throws Exception {
          try {
              

              Vector objBussines = new Vector();
              MareBusinessID id = new MareBusinessID(bID);
              objBussines.add(dto);
              objBussines.add(id);

              DruidaConector ver = conectar(conector, objBussines);
              Object obj = ver.objeto("DTOSalida");

              //traza("ver DTOSalida" + obj.toString());
              return obj;
          } catch (Throwable th) {
              this.traza("error en Obtener Datos Salida");

              ByteArrayOutputStream stack = new ByteArrayOutputStream();
              PrintStream out = new PrintStream(stack);
              th.printStackTrace(out);
              traza(stack.toString());

              BelcorpError belcorpError = new BelcorpError();
              DTOError dtoError = belcorpError.obtenerError(th,
                         UtilidadesSession.getIdioma_ISO(this), "");
              String s = th.getMessage();
              traza(dtoError.getCodigoError() + " - " +
                    dtoError.getDescripcionError());
              throw ((Exception) th);
          }
    }

    /*******************************************************/
    private String[] getClientesVinculo() throws Exception {
          //traza(" private String[] getClientesVinculo(): " + hidListaVinculo);

          StringTokenizer tok = new StringTokenizer(hidListaVinculo, ";");
          Vector codigosVec = new Vector();

          while (tok.hasMoreTokens()) {
              String componenteValor = (String) tok.nextToken();

              //traza(componenteValor);
              StringTokenizer tok2 = new StringTokenizer(componenteValor, "=");
              String componente = "";
              String value = "";

              if (tok2.hasMoreTokens()) {
                    componente = tok2.nextToken();
              }

              if (tok2.hasMoreTokens()) {
                    value = tok2.nextToken();
              }

              if (componente.length() >= 19) {
                    if ("TextoClienteVinculo".equals(componente.substring(0, 19))) {
                         codigosVec.add(value);
                    }
              }

              // TextoClienteVinculo_0=1;TextoFechaDesde_0=20/12/2002;TextoFechaHasta_0=20/12/2003;RbVinculoPrincipal_0=true;comboPaisVinculo_0=2;comboTipoVinculo_0=1;··
          }

          //traza("antes for(int r=0;r<" + codigosVec.size() + ";r++)");  
          String[] codigosStr = new String[codigosVec.size()];

          for (int r = 0; r < codigosVec.size(); r++) {
              codigosStr[r] = new String((String) codigosVec.elementAt(r));
          }

          //traza("despues for(int r=0;r<codigosVec.size();r++)");                    
          if (codigosStr.length == 0) {
              traza("codigos vinculos vacios");

              return new String[0];
          }

          return codigosStr;
    }

    /*******************************************************/
    private Long[] getPaisesVinculo() throws Exception {
          //traza("         private String[] getPaisesVinculo(): " + hidListaVinculo);
          StringTokenizer tok = new StringTokenizer(hidListaVinculo, ";");
          Vector codigosVec = new Vector();

          while (tok.hasMoreTokens()) {
              String componenteValor = (String) tok.nextToken();
              StringTokenizer tok2 = new StringTokenizer(componenteValor, "=");
              String componente = "";
              String value = "";

              if (tok2.hasMoreTokens()) {
                    componente = tok2.nextToken();
              }

              if (tok2.hasMoreTokens()) {
                    value = tok2.nextToken();
              }

              if (componente.length() >= 16) {
                    if ("comboPaisVinculo".equals(componente.substring(0, 16))) {
                         codigosVec.add(value);
                    }
              }

              // TextoClienteVinculo_0=1;TextoFechaDesde_0=20/12/2002;TextoFechaHasta_0=20/12/2003;RbVinculoPrincipal_0=true;comboPaisVinculo_0=2;comboTipoVinculo_0=1;··
          }

          //traza("antes for(int r=0;r<" + codigosVec.size() + ";r++)");  
          Long[] codigosLong = new Long[codigosVec.size()];

          for (int r = 0; r < codigosVec.size(); r++) {
              codigosLong[r] = new Long((String) codigosVec.elementAt(r));
          }

          //traza("despues for(int r=0;r<codigosVec.size();r++)");                    
          return codigosLong;
    }

    /***********************************************************************/
    private String transformaFechas(java.sql.Date fechaBD)
          throws Exception {
          //traza("TransformaFechas");

          // Transforma las Fechas para mostrar en pantalla, en formato de Sesión.
          String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
          formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
          //traza("Antes: " + fechaBD.toString());

          SimpleDateFormat sFormat = new SimpleDateFormat(formatoFechaSesion);
          String sBuffer = sFormat.format(fechaBD);
          //traza("Despues: " + sBuffer.toString());

          return sBuffer;
    }

    //---------------------------------------------------------------------

    /**********************************************************************/
    private void leeHiddens() throws Exception {
          //traza("private void leeHiddens()");

          /** generales **/
          hidPais = conectorParametroLimpia("hidPais", "", true);
          formatoFechaPais = conectorParametroLimpia("hFormatoFechaPais", "", true);
          //traza("Formato Fecha : " + formatoFechaPais);
          hidUsaGeo = conectorParametroLimpia("usaGeoreferenciador", "", true);
          hidCasoUso = conectorParametroLimpia("casoDeUso", "", true);
          hidTipoClienDescripcion = conectorParametroLimpia("hidTipoClienDescripcion",
                    "", true);

          /**Campos pestaña 0**/
                    StrTipo = conectorParametroLimpia("cbTipo", "", true);
          StrSubTipo = conectorParametroLimpia("cbSTipo", "", true);

          tipoSubtipoStr = conectorParametroLimpia("elementos", "", true);
          hidFocusPrimerComponente = conectorParametroLimpia("hidFocusPrimerComponente",
                    "", true);

          /**Campos primera pestaña**/

          hidCodigoAutomatico = conectorParametroLimpia("hidCodigoAutomatico",
                    "", true);
          hidDigitoControl = conectorParametroLimpia("hidDigitoControl", "", true);
          
          hidtextCodCliente = conectorParametroLimpia("codigoCliente", "", true);

          hidListaIdentificacion = conectorParametroLimpia("hidListaIdentificacion",
                    "", true);
          

          /**Campos segunda pestaña**/

          elementosP2 = conectorParametroLimpia("elementosP2", "", true);
          hidtxtFechaIngresoActual = conectorParametroLimpia("hidFechaIngreso",
                    "", true);
          hidtextApellido1 = conectorParametroLimpia("hidtextApellido1", "", true);
          hidtextApellido2 = conectorParametroLimpia("hidtextApellido2", "", true);
          hidtextApellidoCasada = conectorParametroLimpia("hidtextApellidoCasada",
                    "", true);
          hidtextNombre1 = conectorParametroLimpia("hidtextNombre1", "", true);
          hidtextNombre2 = conectorParametroLimpia("hidtextNombre2", "", true);
          hidcbTratamiento = conectorParametroLimpia("hidcbTratamiento", "", true);
          hidcbTratamientoDesc = conectorParametroLimpia("hidcbTratamientoDesc", "", true);
          hidrbSexo = conectorParametroLimpia("hidrbSexo", "", true);
          hidcbFormaPago = conectorParametroLimpia("hidcbFormaPago", "", true);
          hidtextFechaNacimiento = conectorParametroLimpia("hidtextFechaNacimiento",
                    "", true);
          hidEdad = conectorParametroLimpia("hidEdad", "", true);
          hidtextCodEmpleado = conectorParametroLimpia("hidtextCodEmpleado", "",
                    true);
          hidcbNacionalidad = conectorParametroLimpia("hidcbNacionalidad", "",
                    true);
          hidcbEstadoCivil = conectorParametroLimpia("hidcbEstadoCivil", "", true);
          hidtextOcupacion = conectorParametroLimpia("hidtextOcupacion", "", true);
          hidtextProfesion = conectorParametroLimpia("hidtextProfesion", "", true);
          hidtextCentroTrabajo = conectorParametroLimpia("hidtextCentroTrabajo",
                    "", true);
          hidtextCargoDesempena = conectorParametroLimpia("hidtextCargoDesempena",
                    "", true);
          hidcbNivelEstudios = conectorParametroLimpia("hidcbNivelEstudios", "",
                    true);
          hidtextCentroEstudios = conectorParametroLimpia("hidtextCentroEstudios",
                    "", true);
          hidtextNHijos = conectorParametroLimpia("hidtextNHijos", "", true);
          hidtextNPersonasDependientes = conectorParametroLimpia("hidtextNPersonasDependientes",
                    "", true);
          hidcbNivelSocioEconomico = conectorParametroLimpia("hidcbNivelSocioEconomico",
                    "", true);
          hidcbCicloVidaFamilia = conectorParametroLimpia("hidcbCicloVidaFamiliar",
                    "", true);
          hidrbDeseaCorrespondencia = conectorParametroLimpia("hidrbDeseaCorrespondencia",
                    "", true);
          hidtextImporteIngresoFamiliar = conectorParametroLimpia("hidtextImporteIngresoFamiliar",
                    "", true);

          hidcbPaisContactado = conectorParametroLimpia("hidcbPaisContactado",
                    "", true);
          hidtextCodClienteContactado = conectorParametroLimpia("hidtextCodClienteContactado",
                    "", true);
          hidcbTipoClienteContactado = conectorParametroLimpia("hidcbTipoClienteContactado",
                    "", true);
          hidcbCodTipoContactado = conectorParametroLimpia("hidcbCodTipoContactado",
                    "", true);
          hidtextFechaContacto = conectorParametroLimpia("hidtextFechaContacto",
                    "", true);
          hidtextFecha1PedidoContacto = conectorParametroLimpia("hidtextFecha1PedidoContacto",
                    "", true);
          hidtextFechaSiguienteContacto = conectorParametroLimpia("hidtextFechaSiguienteContacto",
                    "", true);

          // hidtxtFechaIngresoActual = conectorParametroLimpia("hidtxtFechaIngresoActual", "", true);
          hidListaVinculo = conectorParametroLimpia("hidListaVinculo", "", true);
          hidListaObservacion = conectorParametroLimpia("hidListaObservacion",
                    "", true);
          hidListaPrefe = conectorParametroLimpia("hidListaPrefe", "", true);
          
          hidCanalContacto = conectorParametroLimpia("hidCanalContacto", "", true);
          //traza("hidCanalContacto: " + hidCanalContacto);
          hidMarcaContacto = conectorParametroLimpia("hidMarcaContacto", "", true);
          //traza("hidMarcaContacto: " + hidMarcaContacto);
          hidPeriodoContacto = conectorParametroLimpia("hidPeriodoContacto", "", true);
          //traza("hidPeriodoContacto: " + hidPeriodoContacto);
          

          //private String = new String("");             
          /**Campos tercera pestaña**/

          elementosP3 = conectorParametroLimpia("elementosP3", "", true);
          hidListaDirecciones = conectorParametroLimpia("hidListaDirecciones",
                    "", true);
          hidListaComunicacion = conectorParametroLimpia("hidListaComunicacion",
                    "", true);
          hidListaMarca = conectorParametroLimpia("hidListaMarca", "", true);
          hidMarcaValor = conectorParametroLimpia("hidMarcaValor", "", true);
          listaVinculosOid = conectorParametroLimpia("listaVinculosOid", "", true);
          hidOidClienteCont = conectorParametroLimpia("hidOidClienteCont", "",
                    true);

          /**Campos cuarta pestaña**/

          elementosP4 = conectorParametroLimpia("elementosP4", "", true);
          hidListaTarjetas = conectorParametroLimpia("hidListaTarjetas", "", true);
          hidListaClasificacion = conectorParametroLimpia("hidListaClasificacion",
                    "", true);
          hidListaProbSolu = conectorParametroLimpia("hidListaProbSolu", "", true);
    }

    private void seteaHiddens() throws Exception {
          /**** generales **/
          
          asignarAtributo("VAR", "hFormatoFechaPais", "valor", formatoFechaPais);
          asignarAtributo("VAR", "hidPais", "valor", hidPais);
          asignarAtributo("VAR", "usaGeoreferenciador", "valor", hidUsaGeo);
          asignarAtributo("VAR", "casoDeUso", "valor", hidCasoUso);
          asignarAtributo("VAR", "hidFocusPrimerComponente", "valor",
              hidFocusPrimerComponente);
          asignarAtributo("VAR", "hidTipoClienDescripcion", "valor",
              hidTipoClienDescripcion);

          /**Asignaciones hiddens Tipo y Subtipo**/
          asignarAtributo("VAR", "cbTipo", "valor", StrTipo);
          asignarAtributo("VAR", "cbSTipo", "valor", StrSubTipo);
          asignarAtributo("VAR", "elementos", "valor", tipoSubtipoStr);

          /**Asignaciones hiddens primera pestaña**/

          asignarAtributo("VAR", "codigoCliente", "valor", hidtextCodCliente);
          asignarAtributo("VAR", "hidListaIdentificacion", "valor",
              hidListaIdentificacion);
          asignarAtributo("VAR", "hidDigitoControl", "valor", hidDigitoControl);
          asignarAtributo("VAR", "hidCodigoAutomatico", "valor",
              hidCodigoAutomatico);

          /**Asignaciones hiddens segunda pestaña**/
          asignarAtributo("VAR", "elementosP2", "valor", elementosP2);
          asignarAtributo("VAR", "hidFechaIngreso", "valor",
              hidtxtFechaIngresoActual);
          asignarAtributo("VAR", "hidtextApellido1", "valor", hidtextApellido1);
          asignarAtributo("VAR", "hidtextApellido2", "valor", hidtextApellido2);
          asignarAtributo("VAR", "hidtextApellidoCasada", "valor",
              hidtextApellidoCasada);
          asignarAtributo("VAR", "hidtextNombre1", "valor", hidtextNombre1);
          asignarAtributo("VAR", "hidtextNombre2", "valor", hidtextNombre2);
          asignarAtributo("VAR", "hidcbTratamiento", "valor", hidcbTratamiento);
          asignarAtributo("VAR", "hidcbTratamientoDesc ", "valor", hidcbTratamientoDesc);
          
          asignarAtributo("VAR", "hidrbSexo", "valor", hidrbSexo);
          asignarAtributo("VAR", "hidcbFormaPago", "valor", hidcbFormaPago);
          asignarAtributo("VAR", "hidtextFechaNacimiento", "valor",
              hidtextFechaNacimiento);
          asignarAtributo("VAR", "hidEdad", "valor", hidEdad);
          asignarAtributo("VAR", "hidtextCodEmpleado", "valor", hidtextCodEmpleado);
          asignarAtributo("VAR", "hidcbNacionalidad", "valor", hidcbNacionalidad);
          asignarAtributo("VAR", "hidcbEstadoCivil", "valor", hidcbEstadoCivil);
          asignarAtributo("VAR", "hidtextOcupacion", "valor", hidtextOcupacion);
          asignarAtributo("VAR", "hidtextProfesion", "valor", hidtextProfesion);
          asignarAtributo("VAR", "hidtextCentroTrabajo", "valor",
              hidtextCentroTrabajo);
          asignarAtributo("VAR", "hidtextCargoDesempena", "valor",
              hidtextCargoDesempena);
          asignarAtributo("VAR", "hidcbNivelEstudios", "valor", hidcbNivelEstudios);
          asignarAtributo("VAR", "hidtextCentroEstudios", "valor",
              hidtextCentroEstudios);
          asignarAtributo("VAR", "hidtextNHijos", "valor", hidtextNHijos);
          asignarAtributo("VAR", "hidtextNPersonasDependientes", "valor",
              hidtextNPersonasDependientes);
          asignarAtributo("VAR", "hidcbNivelSocioEconomico", "valor",
              hidcbNivelSocioEconomico);
          asignarAtributo("VAR", "hidcbCicloVidaFamiliar", "valor",
              hidcbCicloVidaFamilia);
          asignarAtributo("VAR", "hidrbDeseaCorrespondencia", "valor",
              hidrbDeseaCorrespondencia);
          asignarAtributo("VAR", "hidtextImporteIngresoFamiliar", "valor",
              hidtextImporteIngresoFamiliar);

          asignarAtributo("VAR", "hidcbPaisContactado", "valor",
              hidcbPaisContactado);
          asignarAtributo("VAR", "hidOidClienteCont", "valor", hidOidClienteCont);
          asignarAtributo("VAR", "hidtextCodClienteContactado", "valor",
              hidtextCodClienteContactado);
          asignarAtributo("VAR", "hidcbTipoClienteContactado", "valor",
              hidcbTipoClienteContactado);
          asignarAtributo("VAR", "hidcbCodTipoContactado", "valor",
              hidcbCodTipoContactado);
          asignarAtributo("VAR", "hidtextFechaContacto", "valor",
              hidtextFechaContacto);
          asignarAtributo("VAR", "hidtextFecha1PedidoContacto", "valor",
              hidtextFecha1PedidoContacto);
          asignarAtributo("VAR", "hidtextFechaSiguienteContacto", "valor",
              hidtextFechaSiguienteContacto);

          //      asignarAtributo("VAR", "hidtxtFechaIngresoActual", "valor", hidtxtFechaIngresoActual);
          asignarAtributo("VAR", "hidListaVinculo", "valor", hidListaVinculo);
          asignarAtributo("VAR", "hidListaPrefe", "valor", hidListaPrefe);
          asignarAtributo("VAR", "hidListaObservacion", "valor",
              hidListaObservacion);

          //traza("setea hidCanalContacto: " + hidCanalContacto);
          //traza("setea hidMarcaContacto: " + hidMarcaContacto);
          //traza("setea hidPeriodoContacto: " + hidPeriodoContacto);
          asignarAtributo("VAR", "hidCanalContacto", "valor", hidCanalContacto);
          asignarAtributo("VAR", "hidMarcaContacto", "valor", hidMarcaContacto);
          asignarAtributo("VAR", "hidPeriodoContacto", "valor", hidPeriodoContacto);          

//                    hidPeriodoContacto = conectorParametroLimpia("hidPeriodoContacto", "", true);
//          traza("hidPeriodoContacto: " + hidPeriodoContacto);

/*          hidCanalContacto = conectorParametroLimpia("hidCanalContacto", "", true);
          hidMarcaContacto = conectorParametroLimpia("hidMarcaContacto", "", true);*/
              

          /**Asignaciones de la tercera pestaña**/
          asignarAtributo("VAR", "elementosP3", "valor", elementosP3);
          asignarAtributo("VAR", "hidListaDirecciones", "valor",
              hidListaDirecciones);
          asignarAtributo("VAR", "hidListaComunicacion", "valor",
              hidListaComunicacion);
          asignarAtributo("VAR", "hidListaMarca", "valor", hidListaMarca);
          asignarAtributo("VAR", "hidMarcaValor", "valor", hidMarcaValor);
          asignarAtributo("VAR", "listaVinculosOid", "valor", listaVinculosOid);

          /**Asignacion a cuarta pestaña**/
          asignarAtributo("VAR", "elementosP4", "valor", elementosP4);
          asignarAtributo("VAR", "hidListaTarjetas", "valor", hidListaTarjetas);
          asignarAtributo("VAR", "hidListaClasificacion", "valor",
              hidListaClasificacion);
          asignarAtributo("VAR", "hidListaProbSolu", "valor", hidListaProbSolu);
    }

    /*****************************************************************************/
    /*private DTOTipoSubtipoCliente[] procesarPestanya0Guardar()
          throws Exception {
          traza(
              "***************** Start procesarPestanya0Guardar *******************");

          //Cargamos en un array los tipos y subtipos para luego setearlo
          //al DTOCrearClienteBasico en el DTOTipoSubtipoCliente --tipo. subTipo
          //Cargamos los tipos de cliente en el DTOTipoSubtipoCliente
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          traza("+++++++++EL array es este " + StrTipo);
          StringTokenizer stk = new StringTokenizer(StrTipo, ",");

          DTOTipoSubtipoCliente[] dtoTipoSubClie = new DTOTipoSubtipoCliente[stk.countTokens()];

          //traza("Guardar 1 :" + stk.countTokens() + "  -  " + StrTipo + " - " + StrSubTipo);
          Long[] tipoArr = new Long[stk.countTokens()];
          int a = 0;
          String valorT = "";

          while (stk.hasMoreTokens()) {
              valorT = stk.nextToken();
              tipoArr[a] = ((valorT.length() == 0) ? null : Long.valueOf(valorT));
              a++;
          }

          // recupero los subtipos                    
          StringTokenizer stk1 = new StringTokenizer(StrSubTipo, ",");
          Long[] subTipoArr = new Long[stk1.countTokens()];
          a = 0;

          String valorST = "";

          while (stk1.hasMoreTokens()) {
              valorST = stk1.nextToken();
              subTipoArr[a] = ((valorST.length() == 0) ? null
                                                                    : Long.valueOf(valorST));
              a++;
          }

          // Verifico que cada tipo tenga subtipo
          if (subTipoArr.length != tipoArr.length) {
              traza(
                    "Problema: Se debe seleccionar un subtipo para cada tipo. La cantidad de tipos seleccionados no coincide con la cantidad de subtipos.");
          }

          if (subTipoArr.length == 0) {
              traza("Problema: No hay ningun subtipo.");
          }

          // seteo los dto tiposubtipo
          for (int r = 0; r < subTipoArr.length; r++) {
              //traza("Guardar 1_" + r + ":");
              dtoTipoSubClie[r] = new DTOTipoSubtipoCliente();
              dtoTipoSubClie[r].setOidPais(utilidadesSesion.getPais(this));
              dtoTipoSubClie[r].setOidIdioma(utilidadesSesion.getIdioma(this));
              dtoTipoSubClie[r].setTipo(tipoArr[r]);
              dtoTipoSubClie[r].setSubtipo(subTipoArr[r]);

              if (r == 0) {
                    dtoTipoSubClie[r].setPrincipal(new Boolean(true));
              } else {
                    dtoTipoSubClie[r].setPrincipal(new Boolean(false));
              }

              traza(dtoTipoSubClie[r]);
          }

          traza(
              "***************** End procesarPestanya0Guardar *******************");

          return dtoTipoSubClie;
    }*/

    
    private DTOTipoSubtipoCliente[] procesarPestanya0Guardar() throws Exception {
      //traza("*******TIPO SUBTIPO " + tipoSubtipoStr);

      String str = tipoSubtipoStr;
      
      StringTokenizer tok = new StringTokenizer(str, ";");

      //h_comboTipoCliente_0=1;h_comboTipoCliente_1=2;
      StringTokenizer tok1 = null;
      String clave = null;
      String valor = null;
      String elem;
      int dif = 0;

      while (tok.hasMoreTokens()) 
      {
          elem = tok.nextToken().toString();
          tok1 = new StringTokenizer(elem, "=");
          clave = tok1.nextToken().toString();
          valor = elem.substring(clave.length() + 1, elem.length());

          tipoSubt.put(clave, valor);
      }
      //traza("tipoSubt: " + tipoSubt.toString() );
                         
           //int i = tipoSubt.size() / 2;
           int i = tipoSubt.size() / 4;
           //traza(tipoSubt.size() + "");
           //traza("HashMap  " + tipoSubt);


           DTOTipoSubtipoCliente[] dtos = new DTOTipoSubtipoCliente[i];

           
           

           for (int o = 0; o < i; o++) 
                dtos[o] = new DTOTipoSubtipoCliente();

           

           for (int index = 0; index < i; index++) 
           {
                //traza("/////////////////" +                      tipoSubt.get("h_comboTipoCliente_" + index));
                //traza("/////////////////" +                      tipoSubt.get("h_comboSubtipoCliente_" + index));
                
                dtos[index].setTipo(new Long(tipoSubt.get("h_comboTipoCliente_" +
                                  index).toString()));
                //traza("/////////////////1");
                
                dtos[index].setSubtipo(new Long(tipoSubt.get(
                                  "h_comboSubtipoCliente_" + index).toString()));
                //traza("/////////////////2");
                
                if (index == 0) {
                                  
                      dtos[index].setPrincipal(new Boolean(true));
                      //traza("/////////////////3");
                } else {
                                  
                      dtos[index].setPrincipal(new Boolean(false));
                      //traza("/////////////////3");
                }
           }

           //traza("subtipocliente");

           
           return dtos;
    }


    /*****************************************************************************/
    private DTODireccion[] procesarPestany3DireccionGuardar()
          throws Exception {
          

          /* El string a parsear contiene mas o menos esto
                     Mas o menos es esto lo que llega
                              h_comboTipoDireccion_0=1··
                              h_comboTipoVia_0=2··
                              h_comboNombreVia_0=Via 1_2··
                              h_TextoNumeroPrincipal_0=1··
                              h_TextoCodPostal_0=2··
                              h_TextoInterior_0=3··
                              h_TextoManzana_0=4··
                              h_TextoLote_0=5··
                              h_TextoKm_0=6··
                              h_AreaTxtObservaciones_0=7··
                              h_RbDireccionPrincipal_0=true··
                              h_hiddenTerritorioOculto_0=undefined··// esto va a venir mejor
                     */

          // genero un numero que considero maximo                                
          DTODireccion[] dtoDire = new DTODireccion[50];
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          //traza("*****lo que llega es " + hidListaDirecciones);
          StringTokenizer stkD = new StringTokenizer(hidListaDirecciones, ";");

          while (stkD.hasMoreTokens()) {
              String registro = stkD.nextToken();
              //traza(registro);

              if ((registro.length() > 17) &&
                         registro.substring(0, 17).equals("h_comboNombreViaD")) {
                    //hay que saltear esta linea
                    continue;
              }

              StringTokenizer stkR = new StringTokenizer(registro, "=");

              while (stkR.hasMoreTokens()) {
                    String elem = stkR.nextToken();
                    String value = null;
                    String name = null;
                    String index = null;

                    //traza(elem);
                    if (stkR.hasMoreTokens()) {
                         value = stkR.nextToken();
                    }

                    //saco del elemento el indice
                    StringTokenizer stkR1 = new StringTokenizer(elem, "_");

                    while (stkR1.hasMoreTokens()) {
                         // ej h_comboDir_0
                         // este nextToken devuelve h_
                         stkR1.nextToken();

                         if (stkR1.hasMoreTokens()) {
                              // este nextToken devuelve el nombre sin indice
                              name = stkR1.nextToken();
                         }

                         if (stkR1.hasMoreTokens()) {
                              index = stkR1.nextToken();
                         }
                    }

                    // traza("reg:" + registro);
                    // traza("elem:" + elem);
                    // traza("value:" + value);
                    // traza("index:" + index);
                    int ind = Integer.parseInt(index);

                    if (dtoDire[ind] == null) {
                         dtoDire[ind] = new DTODireccion();
                         dtoDire[ind].setOidIdioma(utilidadesSesion.getIdioma(this));
                         dtoDire[ind].setOidPais(utilidadesSesion.getPais(this));
                    }

                    if (name.equals("comboTipoDireccion")) {
                         Long tipodir = new Long(value);
                         dtoDire[ind].setTipoDireccion(tipodir);
                    }

                    if (name.equals("comboTipoVia")) {
                         Long tipovia = new Long(value);
                         dtoDire[ind].setTipoVia(tipovia);
                    }

                    if (name.equals("TextoNombreVia") || name.equals("textNombreVia")) {
                                                dtoDire[ind].setNombreVia(value);
                    }

                    if (name.equals("comboNombreVia")) {
                         dtoDire[ind].setVia(new Long(value));
                    }

                    if (name.equals("TextoNumeroPrincipal")) {
                         if (value != null) {
                              //Integer inte = new Integer(value);
                              dtoDire[ind].setNumeroPrincipal(value);
                         }
                    }

                    if (name.equals("TextoCodPostal")) {
                         dtoDire[ind].setCodigoPostal(value);
                    }

                    if (name.equals("AreaTxtObservaciones")) {
                         dtoDire[ind].setObservaciones(value);
                    }

                    if (name.equals("RbDireccionPrincipal")) {
                         if ("Si".equals(value)) {
                              dtoDire[ind].setEsDireccionPrincipal(new Boolean(true));
                         } else {
                              dtoDire[ind].setEsDireccionPrincipal(new Boolean(false));
                         }
                    }

                    if (name.equals("hiddenTerritorioOculto")) {
                         Long terri = new Long(value);
                         dtoDire[ind].setUnidadGeografica(terri);
                    }

                    dtoDire[ind].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
                    dtoDire[ind].setPrograma(UtilidadesSession.getFuncion(this));

              }
          }

          // ahora que llene los dto 
          int k = 0;

          for (int y = 0; y < dtoDire.length; y++) {
              if (dtoDire[y] != null) {
                    k++;
              }
          }

          // construyo solo los necesarios
          DTODireccion[] dtoDireRes = new DTODireccion[k];
          k = 0;

          for (int y = 0; y < dtoDire.length; y++) {
              if (dtoDire[y] != null) {
                    dtoDireRes[k] = dtoDire[y];
                    k++;
              }
          }

          

          return dtoDireRes;
    }
          /******************************************************************************/
          private void validar() throws Exception{
                    //traza("Entro validar()...");
             pagina("salidaGenerica");
                           DTOColeccion dto = new DTOColeccion();
             Long lIdioma = UtilidadesSession.getIdioma(this);
                           Long lPais = UtilidadesSession.getPais(this);
             ArrayList arrDocs = arrayToArrayList(procesarPestanya1Guardar());
             dto.setLista(arrDocs);
             dto.setOidPais(lPais);
             dto.setOidIdioma(lIdioma);
                           
                           MareBusinessID idBusiness = new MareBusinessID("MAEValidarDocumento");
             Vector params = new Vector();
                           params.add(dto);
                           params.add(idBusiness);

                           DruidaConector conector = conectar("ConectorValidarDocumento", params);
             traza("Clase: "+conector.objeto("DTOString").getClass().getName());
                    DTOString dtoStr = (DTOString) conector.objeto("DTOString");
                    String nroDoc = dtoStr.getCadena();


                    if(!"".equals(nroDoc)){

                              asignarAtributo( "VAR", "ejecutar", "valor", "mostrarerror('"+nroDoc+"')");
                    } else{

                              asignarAtributo( "VAR", "ejecutar", "valor", "accionExitosa()");
                    }

          }
          /*****************************************************************************/
          private ArrayList arrayToArrayList(DTOIdentificacion[] ident) throws Exception{
          ArrayList arrDocs = new ArrayList();
          
          int size = ident.length;
          for(int i=0;i<size;i++){
             DTOIdentificacion dtoI = (DTOIdentificacion) ident[i];
             arrDocs.add(dtoI);
          }
          
          return arrDocs;
          }

    /*****************************************************************************/
    private DTOIdentificacion[] procesarPestanya1Guardar()
          throws Exception {
          

          int k = 0;
          UtilidadesSession utilidadesSesion = new UtilidadesSession();


          //h_comboTipoDocId_0=11;h_TextoNDoc_0=2626;h_TextoConfirmacionDoc_0=2626;h_RbDocPrincipal_0=true;h_comboPersonaEmpresa_0=P
          //obtengo los indices de lista ident que tienen datos
          String linea = new String();
          StringTokenizer stkLGrupo = new StringTokenizer(hidListaIdentificacion, ";");

          //por cada conj componente identificacion de la pestanya1 creamos un dtoifentificacion
          DTOIdentificacion[] dtoIdentif = new DTOIdentificacion[50];

          while (stkLGrupo.hasMoreTokens()) {
              linea = stkLGrupo.nextToken();

              StringTokenizer stkElem = new StringTokenizer(linea, "=");
              String elemen = null;
              String nombre = null;
              String valor = null;
              int indice = 0;

              //traza(linea);
              if (stkElem.hasMoreTokens()) {
                    elemen = stkElem.nextToken();
              }

              if (stkElem.hasMoreTokens()) {
                    valor = stkElem.nextToken();
              }

              StringTokenizer stkTemp = new StringTokenizer(elemen, "_");

              if (stkTemp.hasMoreTokens()) {
                    // aca paso el h_
                    stkTemp.nextToken();
              }

              if (stkTemp.hasMoreTokens()) {
                    // aca paso el nombre (comboTipo bla)
                    nombre = stkTemp.nextToken();
              }

              if (stkTemp.hasMoreTokens()) {
                    // aca paso el 0
                    indice = Integer.parseInt(stkTemp.nextToken());
              }

              if (dtoIdentif[indice] == null) {
                    dtoIdentif[indice] = new DTOIdentificacion();
                    dtoIdentif[indice].setOidPais(utilidadesSesion.getPais(this));
                    dtoIdentif[indice].setOidIdioma(utilidadesSesion.getIdioma(this));

                    //dtoIdentif[indice].setOid(null);                                      
              }

              if ("comboTipoDocId".equals(nombre)) {
                    dtoIdentif[indice].setTipoDocumento(Long.decode(valor));
              }

              if ("TextoNDoc".equals(nombre)) {
                    dtoIdentif[indice].setNumeroDocumento(valor);
              }

              if ("RbDocPrincipal".equals(nombre)) {
                    if (valor.equals("true")) {
                         dtoIdentif[indice].setEsPrincipal(new Boolean(true));
                    } else {
                         dtoIdentif[indice].setEsPrincipal(new Boolean(false));
                    }
              }

              if ("comboPersonaEmpresa".equals(nombre)) {
                    dtoIdentif[indice].setIndPersonaEmpresa(valor);
              }

              dtoIdentif[indice].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
              dtoIdentif[indice].setPrograma(UtilidadesSession.getFuncion(this));

          }

          int cant = 0;

          for (int g = 0; g < dtoIdentif.length; g++) {
              if (dtoIdentif[g] != null) {
                    cant++;
              }
          }

          DTOIdentificacion[] dtoResult = new DTOIdentificacion[cant];
          cant = 0;

          for (int g = 0; g < dtoIdentif.length; g++) {
              if (dtoIdentif[g] != null) {
                    dtoResult[cant] = dtoIdentif[g];
                    cant++;
              }
          }


          dtoIdentif = null;

          return dtoResult;
    }

    /**************************************************************************/
    private DTOClienteMarca[] procesarPestany3MarcaGuardar()
          throws Exception {
          StringTokenizer stkMarca = new StringTokenizer(hidListaMarca, ";");
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          DTOClienteMarca[] dtoClienteMarca = new DTOClienteMarca[stkMarca.countTokens()];
          int k = 0;

          while (stkMarca.hasMoreTokens()) {
              String marcaValor = stkMarca.nextToken();
              String nombre = null;
              String valor = null;
              StringTokenizer stkMarca1 = new StringTokenizer(marcaValor, "=");

              while (stkMarca1.hasMoreTokens()) {
                    nombre = stkMarca1.nextToken();

                    if (stkMarca1.hasMoreTokens()) {
                         valor = stkMarca1.nextToken();

                         Long idMarc = new Long(valor);
                         dtoClienteMarca[k] = new DTOClienteMarca();
                         dtoClienteMarca[k].setOidPais(utilidadesSesion.getPais(this));
                         dtoClienteMarca[k].setOidIdioma(utilidadesSesion.getIdioma(
                                    this));
                         dtoClienteMarca[k].setMarca(idMarc);

                         if (k == 0) {
                              dtoClienteMarca[k].setPrincipal(Boolean.TRUE);
                         } else {
                              dtoClienteMarca[k].setPrincipal(Boolean.FALSE);
                         }

                         dtoClienteMarca[k].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
                         dtoClienteMarca[k].setPrograma(UtilidadesSession.getFuncion(this));


                         dtoClienteMarca[k].setOid(null);
                         k++;
                    }
              }
          }


          return dtoClienteMarca;

          // return null;
    }

    /**************************************************************************/
    private DTOClasificacionCliente[] procesarPestany4ClasificacionGuardar() throws Exception {
         /* Entrada:
            clasi=g;comboMarcaDesc=Grupo Ebel;comboCanalDesc=Venta directa;comboTipoClienteDesc=Cliente;comboSubtipoClienteDesc=Final;comboTipoClasificacionDesc=Lider;
            comboClasificacionDesc=Lider;comboMarca=8;comboCanal=2;comboTipoClasificacion=1;comboClasificacion=1;
            comboTipoCliente=1;comboSubtipoCliente=2|clasi=g;comboMarcaDesc=Grupo Ebel;.....
          */
         traza("---- Grupo Clasificacion string es_" + hidListaClasificacion);
         UtilidadesSession utilidadesSesion = new UtilidadesSession();
         Long oidPais = utilidadesSesion.getPais(this);
         Long oidIdioma = utilidadesSesion.getIdioma(this);
         String programa = UtilidadesSession.getFuncion(this);
         String ipCliente = UtilidadesBelcorp.getIPCliente(this);


         StringTokenizer stkLista = new StringTokenizer(hidListaClasificacion, "|");
         StringTokenizer stkClasificacion = null;
         StringTokenizer stkCampo = null;
         DTOClasificacionCliente dtoClasificacion = null;
         
         int cantFilas = stkLista.countTokens();
         traza("    cantClasificaciones: " + cantFilas);
         DTOClasificacionCliente[] clasificaciones = null;
          
          //enozigli 12/07/2005 cambio por inc. BELC300014757
         if (cantFilas > 0) {
             clasificaciones = new DTOClasificacionCliente[cantFilas];
             int indice = 0;
             int nCampo;
             String sClasi;
             String sCampo;
             String sValor;
                            
             while ( stkLista.hasMoreTokens() ) {
                  sClasi = stkLista.nextToken();
                  traza("    clasificacion_" + sClasi);

                  dtoClasificacion = new DTOClasificacionCliente();
                  dtoClasificacion.setPrincipal((indice == 0)? new Boolean(true) : new Boolean(false)); // Setea Principal = true en el primero, en otros = false

                  stkClasificacion = new StringTokenizer(sClasi, ";");
                  nCampo = 0;
                   
                  while ( stkClasificacion.hasMoreTokens() ) {
                      sCampo = stkClasificacion.nextToken();
                      stkCampo = new StringTokenizer(sCampo, "=");
                        
                      if ( stkCampo.countTokens() > 1 ) {   // Si un campo más de 1 token es porque tiene nombre y también valor
                           stkCampo.nextToken();              // No me interesa este valor (es nombre del campo).
                           sValor = stkCampo.nextToken();    // Valor real.

                           switch (nCampo) {
                              case 7:    // Marca
                                 traza("    campo es 7 Marca_" + sValor);
                                 dtoClasificacion.setMarca(new Long(sValor));
                                 break;
                              case 8:    // Canal
                                 traza("    campo es 8 Canal_" + sValor);
                                 dtoClasificacion.setCanal(new Long(sValor));
                                 break;
                              case 9:    // Tipo Clasificacion
                                 traza("    campo es 9 TipoClasificacion_" + sValor);
                                 dtoClasificacion.setTipoClasificacion(new Long(sValor));
                                 break;
                              case 10:   // Clasificacion
                                 traza("    campo es 10 Clasificacion_" + sValor);
                                 dtoClasificacion.setClasificacion(new Long(sValor));
                                 break;
                           }
                           
                      }            
                      nCampo++;
                  }
                  
                  dtoClasificacion.setOidPais(oidPais);
                  dtoClasificacion.setOidIdioma(oidIdioma);
                  dtoClasificacion.setIpCliente(ipCliente);
                  dtoClasificacion.setPrograma(programa);

                  clasificaciones[indice] = dtoClasificacion;

                  indice++;

             }

         }
         return clasificaciones;
    }

    /**************************************************************************/
    //private void procesarPestanya2Basicos(DTOCliente dtoCliente)
    private DTOCliente procesarPestanya2Basicos(DTOCliente dtoCliente)
          throws Exception {
          
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          dtoCliente.setOid(null);

          dtoCliente.setOidPais(utilidadesSesion.getPais(this));

          dtoCliente.setOidIdioma(utilidadesSesion.getIdioma(this));

          dtoCliente.setNivelEstudios(((hidcbNivelEstudios.equals("")) ? null
                                                                                         : Long.valueOf(
                    hidcbNivelEstudios)));


          // TODO : Hard, Mail de rodo
          // aca hay que validar
          if((hidOidClienteCont != null) && !(hidOidClienteCont.equals(""))){
             dtoCliente.setOidClienteContactado(new Long(hidOidClienteCont));
             //traza("EL OID DEL CLIENTE CONTAC ES " + hidOidClienteCont);
          }

          //dtoCliente.setOidClienteContactado(new Long(2660));


          //dtoCliente.setTipoClienteContactado(new Long(1));
          if((hidcbTipoClienteContactado != null) && !(hidcbTipoClienteContactado.equals(""))) {
             dtoCliente.setTipoClienteContactado(new Long(hidcbTipoClienteContactado));
             //traza("EL TIPO DEL CLIENTE CONTAC ES " + hidcbTipoClienteContactado);
          }


          //Datos Adicionales Pestanya2
          if (hidtextFechaNacimiento.equals("")) {

              dtoCliente.setFechaNacimiento(null);
          } else {

              dtoCliente.setFechaNacimiento(toDate(hidtextFechaNacimiento));
          }


          dtoCliente.setCodigoEmpleado(hidtextCodEmpleado);
          //traza("*****NACIONALIDAD " + hidcbNacionalidad);
          //traza("*****EDAD " + hidEdad);
          
          if((hidcbNacionalidad != null) && !(hidcbNacionalidad.equals(""))){
             dtoCliente.setNacionalidad(new Long(hidcbNacionalidad));
          }

          if((hidcbCodTipoContactado != null) && !(hidcbCodTipoContactado.equals(null))){ 
             dtoCliente.setTipoContacto(hidcbCodTipoContactado);
          }
          


          if(!hidEdad.equals("")){
             dtoCliente.setEdad(Short.valueOf(hidEdad));
          }


          dtoCliente.setEstadoCivil(((hidcbEstadoCivil.equals("")) ? null
                                                                                    : Long.valueOf(
                    hidcbEstadoCivil)));

          dtoCliente.setOcupacion(hidtextOcupacion);


          //traza("profesion == " + hidtextProfesion);
          dtoCliente.setProfesion(hidtextProfesion);

          dtoCliente.setCentroTrabajo(hidtextCentroTrabajo);

          dtoCliente.setCargo(hidtextCargoDesempena);


          dtoCliente.setNivelEstudios(((hidcbNivelEstudios.equals("")) ? null
                                                                                         : Long.valueOf(
                    hidcbNivelEstudios)));

          dtoCliente.setCentroEstudios(hidtextCentroEstudios);

          dtoCliente.setNumeroHijos((hidtextNHijos.equals("")) ? null
                                                                              : Byte.valueOf(
                    hidtextNHijos));

          dtoCliente.setPersonasDependientes((hidtextNPersonasDependientes.equals(
                    "")) ? null : Byte.valueOf(hidtextNPersonasDependientes));

          dtoCliente.setNSEP(((hidcbNivelSocioEconomico.equals("")) ? null
                                                                                     : Long.valueOf(
                    hidcbNivelSocioEconomico)));
          dtoCliente.setCicloVida(((hidcbCicloVidaFamilia.equals("")) ? null
                                                                                        : Long.valueOf(
                    hidcbCicloVidaFamilia)));

          dtoCliente.setDeseaCorrespondencia(((hidrbDeseaCorrespondencia == "0")
              ? Boolean.FALSE : Boolean.TRUE));

          dtoCliente.setImporteIngresos(((hidtextImporteIngresoFamiliar.equals(""))
              ? null : Double.valueOf(hidtextImporteIngresoFamiliar)));

            //FECHAS DE CONTACTO


           String sBuffer;
           sBuffer = hidtextFecha1PedidoContacto;
           java.sql.Date fechaPrimerPedido = null;
           if (sBuffer != null && !sBuffer.equals("") ){
              String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this); 
              formatoFechaSesion = formatoFechaSesion.replace('m', 'M'); 
              SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion); 
              java.util.Date fechaBuffer = simpleDate.parse(sBuffer);
              fechaPrimerPedido = new java.sql.Date(fechaBuffer.getTime());
           }

          /* if (fechaPrimerPedido != null)
              traza("Fecha Primer Pedido: " + fechaPrimerPedido.toString() );
           else 
              traza("Fecha Primer Pedido es null ");*/
            
           //dtoCliente.setFechaPrimerPedidoContactado(fechaPrimerPedido);


           sBuffer = hidtextFechaContacto;
           java.sql.Date fechaContacto = null;
          if (sBuffer != null && !sBuffer.equals("") ) 
          {
             String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this); 
             formatoFechaSesion = formatoFechaSesion.replace('m', 'M'); 
             SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion); 

            java.util.Date fechaBuffer = simpleDate.parse(sBuffer);
            fechaContacto = new java.sql.Date(fechaBuffer.getTime());
          }
/*          if (fechaContacto != null)
            traza("Fecha Contacto: " + fechaContacto.toString() );
          else 
            traza("Fecha Contacto es null ");*/
          //dtoCliente.setFechaSiguienteContacto(fechaContacto);
          dtoCliente.setFechaPrimerContacto(fechaContacto);


          sBuffer = hidtextFechaSiguienteContacto;
          java.sql.Date fechaSigContacto = null;
          if (sBuffer != null && !sBuffer.equals("") ) 
          {
             String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this); 
             formatoFechaSesion = formatoFechaSesion.replace('m', 'M'); 
             SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion); 
             java.util.Date fechaBuffer = simpleDate.parse(sBuffer);
             fechaSigContacto = new java.sql.Date(fechaBuffer.getTime());
          }
/*          if (fechaSigContacto != null)
            traza("Fecha Siguiente Contacto: " + fechaSigContacto.toString() );
          else 
            traza("Fecha Siguiente Contacto es null ");*/
          dtoCliente.setFechaSiguienteContacto(fechaSigContacto);

          // Canal, Marca y Periodo de Contacto
/*          traza("Canal Contacto: " + hidCanalContacto);
          traza("Marca Contacto: " + hidMarcaContacto);
          traza("Periodo Contacto: " + hidPeriodoContacto);*/

          if(hidCanalContacto != null && !hidCanalContacto.equals("")){
              dtoCliente.setCanalContacto(new Long(hidCanalContacto));
          }

          if(hidMarcaContacto != null && !hidMarcaContacto.equals("")){
              dtoCliente.setMarcaContacto(new Long(hidMarcaContacto));
          }
              
          if(hidPeriodoContacto != null && !hidPeriodoContacto.equals("") ){
              dtoCliente.setPeriodoContacto(new Long(hidPeriodoContacto));
          }


          //procesarPestanya2Basicos(dtoCliente);
          //Incidencia DBLG400000926 pzerbino 11/01/2006
          //No estaba contemplando que devolviera el dtoCliente se modifica
          //la funcion antes no devolvia nada
                    return dtoCliente;
    }

    /*************************************************************************/
    public DTOVinculo[] procesarPestany2VinculosGuardar()
          throws Exception {

          //hidListaVinculo:h_TextoClienteVinculo_0=000000000000003;TextoFechaDesde_0=20/01/1989;TextoFechaHasta_0=10/03/1990;CKVinculoPrincipal_0=true; comboTipoVinculo_0=1;
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          DTOVinculo[] dtoVinculo = new DTOVinculo[50];
          StringTokenizer stkListaVinculo = new StringTokenizer(hidListaVinculo,
                    ";");
         //traza ("hidListaVinculo------  " + hidListaVinculo);
         while (stkListaVinculo.hasMoreTokens()) {
              String registro = stkListaVinculo.nextToken();
              StringTokenizer stkR = new StringTokenizer(registro, "=");

              while (stkR.hasMoreTokens()) {
                    String elem = stkR.nextToken();
                    String value = null;
                    String name = null;
                    String index = null;

                    if (stkR.hasMoreTokens()) {
                         value = stkR.nextToken();
                    }

                    //saco del elemento el indice
                    StringTokenizer stkR1 = new StringTokenizer(elem, "_");

                    while (stkR1.hasMoreTokens()) {
                         if (stkR1.hasMoreTokens()) {
                              // este nextToken devuelve el nombre sin indice
                              name = stkR1.nextToken();
                         }

                         if (stkR1.hasMoreTokens()) {
                              index = stkR1.nextToken();
                         }
                    }

                    //traza("reg:" + registro);
                    //traza("elem:" + elem);
                    //traza("value:" + value);
                    //traza("index:" + index);
                    int ind = Integer.parseInt(index);

                    if (dtoVinculo[ind] == null) {
                         dtoVinculo[ind] = new DTOVinculo();
                         dtoVinculo[ind].setOidPais(utilidadesSesion.getPais(this));
                         dtoVinculo[ind].setOidIdioma(utilidadesSesion.getIdioma(
                                    this));
                         dtoVinculo[ind].setPais(utilidadesSesion.getPais(this));
                    }

                    if (name.equals("TextoClienteVinculo")) {
                         dtoVinculo[ind].setCodigoCliente(value);
                    }

                    if (name.equals("TextoFechaDesde")) {
                         dtoVinculo[ind].setFechaDesde(toDate(value));
                    }

                    if (name.equals("TextoFechaHasta")) {
                         dtoVinculo[ind].setFechaHasta(toDate(value));
                    }

                    if (name.equals("CKVinculoPrincipal")) {
                         if ("true".equals(value)) {
                              dtoVinculo[ind].setPrincipal(new Boolean(true));
                         } else {
                              dtoVinculo[ind].setPrincipal(new Boolean(false));
                         }
                    }

                    if (name.equals("comboTipoVinculo")) {
                         Long tem = new Long(value);
                         dtoVinculo[ind].setTipo(tem);
                    }

                    dtoVinculo[ind].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
                    dtoVinculo[ind].setPrograma(UtilidadesSession.getFuncion(this));

              }
          }

          // ahora que llene los dto 
          int k = 0;

          for (int y = 0; y < dtoVinculo.length; y++) {
              if (dtoVinculo[y] != null) {
                    k++;
              }
          }

          // construyo solo los necesarios
          DTOVinculo[] dtoResult = new DTOVinculo[k];
          k = 0;

          //dtoVinculo[ind].setOidCliente(new Long(2660));
          //parseo los oid de vinculos de la lista oculta { Ej. 2660,3443 }
          StringTokenizer tok = new StringTokenizer(listaVinculosOid, ",");
          Long[] oidisVinc = new Long[tok.countTokens()];


          int gg = 0;

          while (tok.hasMoreTokens()) {
              oidisVinc[gg] = new Long(tok.nextToken());
              gg++;
          }

          for (int y = 0; y < dtoVinculo.length; y++) {
              if (dtoVinculo[y] != null) {
                    dtoVinculo[y].setOidCliente(oidisVinc[y]);
                    dtoResult[k] = dtoVinculo[y];
                    k++;
              }
          }

          /* */
          
          dtoVinculo = null;
          /*for(int t = 0; t < dtoResult.length; t++){
              traza("DTO A ENVIAR TIPO VINCULO" + dtoResult[t]);
           }*/

          return dtoResult;
    }

    /******************************************************************************************/
    public DTOPreferencia[] procesarPestany2PreferenciasGuardar()
          throws Exception {
          
          //TextoDescripcion_0=asd;TextoDescripcion_1=sdg;comboTipoPreferencia_0=1;comboTipoPreferencia_1=2;                                                 
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          DTOPreferencia[] dtoPrefe = new DTOPreferencia[50];
          StringTokenizer stkListaVinculo = new StringTokenizer(hidListaPrefe, ";");

          while (stkListaVinculo.hasMoreTokens()) {
              String registro = stkListaVinculo.nextToken();
              StringTokenizer stkR = new StringTokenizer(registro, "=");

              while (stkR.hasMoreTokens()) {
                    String elem = stkR.nextToken();
                    String value = null;
                    String name = null;
                    String index = null;

                    if (stkR.hasMoreTokens()) {
                         value = stkR.nextToken();
                    }

                    //saco del elemento el indice
                    StringTokenizer stkR1 = new StringTokenizer(elem, "_");

                    while (stkR1.hasMoreTokens()) {
                         // ej h_comboDir_0
                         if (stkR1.hasMoreTokens()) {
                              // este nextToken devuelve el nombre sin indice
                              name = stkR1.nextToken();
                         }

                         if (stkR1.hasMoreTokens()) {
                              index = stkR1.nextToken();
                         }
                    }

                    //traza("reg:" + registro);
                    //traza("elem:" + elem);
                    //traza("value:" + value);
                    //traza("index:" + index);
                    int ind = Integer.parseInt(index);

                    if (dtoPrefe[ind] == null) {
                         dtoPrefe[ind] = new DTOPreferencia();
                         dtoPrefe[ind].setOidPais(utilidadesSesion.getPais(this));
                         dtoPrefe[ind].setOidIdioma(utilidadesSesion.getIdioma(this));
                         
                    }

                    if (name.equals("TextoDescripcion")) {
                         dtoPrefe[ind].setDescripcion(value);
                    }

                    if (name.equals("comboTipoPreferencia")) {
                         Long tip = new Long(value);
                         dtoPrefe[ind].setTipo(tip);
                    }

                    dtoPrefe[ind].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
                    dtoPrefe[ind].setPrograma(UtilidadesSession.getFuncion(this));

              }
          }

          // ahora que llene los dto 
          int k = 0;

          for (int y = 0; y < dtoPrefe.length; y++) {
              if (dtoPrefe[y] != null) {
                    k++;
              }
          }

          // construyo solo los necesarios
          DTOPreferencia[] dtoResult = new DTOPreferencia[k];
          k = 0;

          for (int y = 0; y < dtoPrefe.length; y++) {
              if (dtoPrefe[y] != null) {
                    dtoResult[k] = dtoPrefe[y];
                    k++;
              }
          }

          dtoPrefe = null;

          return dtoResult;
    }

    /******************************************************************************************/
    public DTOObservacion[] procesarPestany2ObservacionGuardar()
          throws Exception {

          //hidListaObservacion = comboMarca_0=1;comboMarca_1=2;AreaTxtTexto_0=grupo observaciones;AreaTxtTexto_1=grupo obs 2;··
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          DTOObservacion[] dtoObse = new DTOObservacion[50];
          StringTokenizer stkListaVinculo = new StringTokenizer(hidListaObservacion,
                    ";");

          while (stkListaVinculo.hasMoreTokens()) {
              String registro = stkListaVinculo.nextToken();
              StringTokenizer stkR = new StringTokenizer(registro, "=");

              while (stkR.hasMoreTokens()) {
                    String elem = stkR.nextToken();
                    String value = null;
                    String name = null;
                    String index = null;

                    if (stkR.hasMoreTokens()) {
                         value = stkR.nextToken();
                    }

                    //saco del elemento el indice
                    StringTokenizer stkR1 = new StringTokenizer(elem, "_");

                    while (stkR1.hasMoreTokens()) {
                         // ej h_comboDir_0
                         if (stkR1.hasMoreTokens()) {
                              // este nextToken devuelve el nombre sin indice
                              name = stkR1.nextToken();
                         }

                         if (stkR1.hasMoreTokens()) {
                              index = stkR1.nextToken();
                         }
                    }

                    //traza("reg:" + registro);
                    //traza("elem:" + elem);
                    //traza("value:" + value);
                    //traza("index:" + index);
                    int ind = Integer.parseInt(index);

                    if (dtoObse[ind] == null) {
                         dtoObse[ind] = new DTOObservacion();
                         dtoObse[ind].setOidPais(utilidadesSesion.getPais(this));
                         dtoObse[ind].setOidIdioma(utilidadesSesion.getIdioma(this));
                         dtoObse[ind].setNumero(new Integer(ind + 1));
                    }

                    if (name.equals("comboMarca")) {
                         dtoObse[ind].setMarca(new Long(value));
                    }

                    if (name.equals("AreaTxtTexto")) {
                         dtoObse[ind].setTexto(value);
                    }

                    dtoObse[ind].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
                    dtoObse[ind].setPrograma(UtilidadesSession.getFuncion(this));

              }
          }

          // ahora que llene los dto 
          int k = 0;

          for (int y = 0; y < dtoObse.length; y++) {
              if (dtoObse[y] != null) {
                    k++;
              }
          }

          // construyo solo los necesarios
          DTOObservacion[] dtoResult = new DTOObservacion[k];
          k = 0;

          for (int y = 0; y < dtoObse.length; y++) {
              if (dtoObse[y] != null) {
                    dtoResult[k] = dtoObse[y];
                    k++;
              }
          }

          dtoObse = null;

          return dtoResult;
    }

    /******************************************************************************************/
    public DTOComunicacion[] procesarPestany3ComunicacionGuardar()
          throws Exception {

          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          Vector vComunicacion = new Vector();
          //traza("hidListaComunicacion: " + hidListaComunicacion);

          DTOComunicacion dtoC = new DTOComunicacion();

          StringTokenizer tok = new StringTokenizer(hidListaComunicacion, ";");
          
          int i = 0;
          while ( tok.hasMoreTokens() )
          {
              boolean hayCampoValor = true;
              
              String campo = tok.nextToken();
              //traza("campo: " + campo);
              StringTokenizer tokCampo = new StringTokenizer(campo, "=");

              String valor = tokCampo.nextToken();  // Nombre de Campo, no nos importa
              try {
                  valor = tokCampo.nextToken(); // Valor de campo, (lo que se busca)                  
              } catch (NoSuchElementException eEx){
                  hayCampoValor = false;
              }
              
              if (i == 0)  // Tipo Comunicacion (NOT NULL en BD)
                  dtoC.setTipoComunicacion( new Long(valor) );

              if (i == 1) // Dia Comunicacion
              {
                    //dtoC.setDiaComunicacion(new Character(valor.toCharArray()[0]));              
                  if (hayCampoValor)
                    dtoC.setDiaComunicacion(new Character(valor.charAt(0)));
                  else
                    dtoC.setDiaComunicacion(null);
              }

              if (i == 2) // Texto Comunicacion
              {
                  if (hayCampoValor)
                    dtoC.setTextoComunicacion(valor);
                  else
                    dtoC.setTextoComunicacion(null);
              }

              if (i == 3) // Indicador Comunicacion Principal
              {
                  if (hayCampoValor)
                  {
                    if (valor.equals("S"))
                      dtoC.setPrincipal(new Boolean(true));
                    else
                      dtoC.setPrincipal(new Boolean(false));
                  } else {
                    dtoC.setPrincipal(null);
                  }
              }

              if (i == 4) // Hora Desde
              {
                    if (hayCampoValor)
                    {
                      SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");

                      java.util.Date hora = simpleDate.parse(valor);

                      Timestamp t = new Timestamp(hora.getTime() );
                      /*traza("t.getTime:" + t.getTime());
                      traza("hora desde: " + hora.toString() );
                      traza("hora desde long: " + hora.getTime() );*/

                      dtoC.setHoraDesde(new Long(t.getTime()));                      

                      
                    } else {
                      dtoC.setHoraDesde(null);
                    }
              } 

              if (i == 5)  // Hora Hasta
              {
                  if (hayCampoValor)
                  {

                    SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");

                    java.util.Date hora = simpleDate.parse(valor);
                      
                    Timestamp t = new Timestamp(hora.getTime() );
                    /*traza("t.getTime:" + t.getTime());
                    traza("hora hasta: " + hora.toString() );
                    traza("hora hasta long: " + hora.getTime() );*/
                    //dtoC.setHoraDesde(new Long(hora.getTime()));
                    dtoC.setHoraHasta(new Long(t.getTime()));                      
                    
                    
                  } else {
                    dtoC.setHoraHasta(null);
                  }
              
              }

              if ( i == 6 ) // Intervalos de Comunicacion
              {
                  if (hayCampoValor)
                  {
                    if (valor.equals("false") )
                      dtoC.setIntervaloComunicacion(new Boolean(false));
                    else
                      dtoC.setIntervaloComunicacion(new Boolean(true));
                  } else {
                    dtoC.setIntervaloComunicacion(null);
                  }
              }
                  
              i++;
              if ( i == 7) 
              {
                    // Reinicializa variables.
                   vComunicacion.add(dtoC);              
                   //traza("dtoC: " + dtoC.toString() );
                   i = 0;
                   dtoC = new DTOComunicacion();
              }              

             dtoC.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
             dtoC.setPrograma(UtilidadesSession.getFuncion(this));
    
           }
           

           DTOComunicacion[] dtoComunicacion = (DTOComunicacion[]) vComunicacion.toArray(new DTOComunicacion[vComunicacion.size()] );
           //traza("LISTO Comunicacion");

           return dtoComunicacion;


          //hidListaComunicacion = h_comboTipoComunicacion_0=1;h_comboDiaComunicacion_0=L;h_AreaTxtTextoComunicacion_0=comun 1 ;h_RbComunicacionPrincipal_0=S;h_TextoHoraDesde_0=6;h_TextoHoraHasta_0=12;h_comboIntervaloComunicacion_0=false;h_comboTipoComunicacion_1=1;h_comboDiaComunicacion_1=M;h_AreaTxtTextoComunicacion_1=comun 22;h_RbComunicacionPrincipal_1=N;h_TextoHoraDesde_1=8;h_TextoHoraHasta_1=9;h_comboIntervaloComunicacion_1=false;··
/*          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          Vector vComunicacion = new Vector();
          
          DTOComunicacion[] dtoComu = new DTOComunicacion[50];

          
          StringTokenizer stkListaVinculo = new StringTokenizer(hidListaComunicacion,
                    ";");

          while(
          while (stkListaVinculo.hasMoreTokens()) {
              String registro = stkListaVinculo.nextToken();
              StringTokenizer stkR = new StringTokenizer(registro, "=");

              while (stkR.hasMoreTokens()) {
                    String elem = stkR.nextToken();
                    String value = null;
                    String name = null;
                    String index = null;

                    if (stkR.hasMoreTokens()) {
                         value = stkR.nextToken();
                    }

                    //saco del elemento el indice
                    StringTokenizer stkR1 = new StringTokenizer(elem, "_");

                    while (stkR1.hasMoreTokens()) {
                         // ej h_comboDir_0
                         // quemo la h de adelante
                         stkR1.nextToken();

                         if (stkR1.hasMoreTokens()) {
                              // este nextToken devuelve el nombre sin indice
                              name = stkR1.nextToken();
                         }

                         if (stkR1.hasMoreTokens()) {
                              index = stkR1.nextToken();
                         }
                    }

                    //traza("reg:" + registro);
                    //traza("elem:" + elem);
                    //traza("value:" + value);
                    //traza("index:" + index);
                    int ind = Integer.parseInt(index);

                    if (dtoComu[ind] == null) {
                         dtoComu[ind] = new DTOComunicacion();
                         dtoComu[ind].setOidPais(utilidadesSesion.getPais(this));
                         dtoComu[ind].setOidIdioma(utilidadesSesion.getIdioma(this));
                    }

                    if (name.equals("comboTipoComunicacion")) {
                         dtoComu[ind].setTipoComunicacion(new Long(value));
                    }

                    if (name.equals("comboDiaComunicacion")) {
                         dtoComu[ind].setDiaComunicacion(new Character(value.charAt(
                                         0)));
                    }

                    if (name.equals("AreaTxtTextoComunicacion")) {
                         dtoComu[ind].setTextoComunicacion(value);
                    }

                    if (name.equals("RbComunicacionPrincipal")) {
                         if ("S".equals(value)) {
                              dtoComu[ind].setPrincipal(new Boolean(true));
                         } else {
                              dtoComu[ind].setPrincipal(new Boolean(false));
                         }
                    }

                    if (name.equals("TextoHoraDesde")) {
                         dtoComu[ind].setHoraDesde(new Long(value));
                    }

                    if (name.equals("TextoHoraHasta")) {
                         dtoComu[ind].setHoraHasta(new Long(value));
                    }

                    if (name.equals("comboIntervaloComunicacion")) {
                         if ("false".equals(value)) {
                              dtoComu[ind].setIntervaloComunicacion(new Boolean(false));
                         } else {
                              dtoComu[ind].setIntervaloComunicacion(new Boolean(true));
                         }
                    }
              }
          }

          // ahora que llene los dto 
          int k = 0;

          for (int y = 0; y < dtoComu.length; y++) {
              if (dtoComu[y] != null) {
                    k++;
              }
          }

          // construyo solo los necesarios
          DTOComunicacion[] dtoResult = new DTOComunicacion[k];
          k = 0;

          for (int y = 0; y < dtoComu.length; y++) {
              if (dtoComu[y] != null) {
                    dtoResult[k] = dtoComu[y];
                    k++;
              }
          }

          dtoComu = null;
          traza(
              "***************** End procesarPestany3ComunicacionGuardar *******************");

          return dtoResult;*/

          
    }

    /******************************************************************************************/
    public DTOTarjeta[] procesarPestany4TarjetaGuardar()
          throws Exception {

          //hidListaTarjetas = h_comboTipoTarjeta_0=1;h_comboClasesTarjeta_0=1;h_comboEntidadBancaria_0=1;··
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          DTOTarjeta[] dtoTarj = new DTOTarjeta[50];
          StringTokenizer stkListaVinculo = new StringTokenizer(hidListaTarjetas,
                    ";");

          while (stkListaVinculo.hasMoreTokens()) {
              String registro = stkListaVinculo.nextToken();
              StringTokenizer stkR = new StringTokenizer(registro, "=");

              while (stkR.hasMoreTokens()) {
                    String elem = stkR.nextToken();
                    String value = null;
                    String name = null;
                    String index = null;

                    if (stkR.hasMoreTokens()) {
                         value = stkR.nextToken();
                    }

                    //saco del elemento el indice
                    StringTokenizer stkR1 = new StringTokenizer(elem, "_");

                    while (stkR1.hasMoreTokens()) {
                         // ej h_comboDir_0
                         // quemo la h de adelante
                         stkR1.nextToken();

                         if (stkR1.hasMoreTokens()) {
                              // este nextToken devuelve el nombre sin indice
                              name = stkR1.nextToken();
                         }

                         if (stkR1.hasMoreTokens()) {
                              index = stkR1.nextToken();
                         }
                    }

                    //traza("reg:" + registro);
                    //traza("elem:" + elem);
                    //traza("value:" + value);
                    //traza("index:" + index);
                    int ind = Integer.parseInt(index);

                    if (dtoTarj[ind] == null) {
                         dtoTarj[ind] = new DTOTarjeta();
                         dtoTarj[ind].setOidPais(utilidadesSesion.getPais(this));
                         dtoTarj[ind].setOidIdioma(utilidadesSesion.getIdioma(this));
                    }

                    if (name.equals("comboTipoTarjeta")) {
                         dtoTarj[ind].setTipo(new Long(value));
                    }

                    if (name.equals("comboClasesTarjeta")) {
                        if(!(value.equals("-1"))){
                             dtoTarj[ind].setClase(new Long(value));
                        }
                    }

                    if (name.equals("comboEntidadBancaria")) {
                        if(!(value.equals("-1"))){
                            dtoTarj[ind].setBanco(new Long(value));
                        }
                    }

                    dtoTarj[ind].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
                    dtoTarj[ind].setPrograma(UtilidadesSession.getFuncion(this));

              }
          }

          // ahora que llene los dto 
          int k = 0;

          for (int y = 0; y < dtoTarj.length; y++) {
              if (dtoTarj[y] != null) {
                    k++;
              }
          }

          // construyo solo los necesarios
          DTOTarjeta[] dtoResult = new DTOTarjeta[k];
          k = 0;

          for (int y = 0; y < dtoTarj.length; y++) {
              if (dtoTarj[y] != null) {
                    dtoResult[k] = dtoTarj[y];
                    k++;
              }
          }

          dtoTarj = null;
          
          return dtoResult;
    }

    /******************************************************************************************/
    public DTOProblemaSolucion[] procesarPestany4ProblemaSolucionGuardar()
          throws Exception {
          
          //hidListaProbSolu = h_comboTipoProblema_0=1;h_AreaTxtDescripcionProblema_0=problema1;h_cbxSolucion_0=N;h_comboTipoSolucion_0=-1;h_AreaTxtDescripcionSolucion_0=;h_AreaTxtNegocioProducto_0=negocio prob 1;h_comboTipoProblema_1=-1;h_AreaTxtDescripcionProblema_1=;h_cbxSolucion_1=S;h_comboTipoSolucion_1=1;h_AreaTxtDescripcionSolucion_1=solu1;h_AreaTxtNegocioProducto_1=negocio solu 1;··
          //h_comboTipoProblema_0=3;h_AreaTxtDescripcionProblema_0=aaaaaaaaaa;h_cbxSolucion_0=S;h_comboTipoSolucion_0=2;h_AreaTxtDescripcionSolucion_0=aaaaaaaaa;h_AreaTxtNegocioProducto_0=aaaaaaaaaaaa;
          UtilidadesSession utilidadesSesion = new UtilidadesSession();
          Vector vSolucion = new Vector();
          //traza("hidListaProbSolu: " + hidListaProbSolu);

          DTOProblemaSolucion dtoP = new DTOProblemaSolucion();

          StringTokenizer tok = new StringTokenizer(hidListaProbSolu, ";");
          boolean solucion = false;
          
          int i = 0;
          while ( tok.hasMoreTokens() )
          {
              boolean hayCampoValor = true;
              
              String campo = tok.nextToken();
              //traza("campo: " + campo);
              StringTokenizer tokCampo = new StringTokenizer(campo, "=");

              String valor = tokCampo.nextToken();  // Nombre, no nos importa
              try {
                  valor = tokCampo.nextToken(); // Valor <- Lo que se busca                  
              } catch (NoSuchElementException eEx){
                  hayCampoValor = false;
              }
              
              if (i == 0)  // Tipo Problema
                  dtoP.setTipoProblema(new Long(valor));

              if (i == 1)
              {
                  // Desc Problema (es opcional)
                  if (hayCampoValor)
                    dtoP.setDescripcionProblema(valor);
                  else
                    dtoP.setDescripcionProblema(null);
              }

              if (i == 2) // Indicador Solucion
              {
                  if (valor.equals("S") ){
                    dtoP.setSolucion( new Boolean(true) );
                    solucion = true;
                  }
                  else{
                    dtoP.setSolucion( new Boolean(false) );
                    solucion = false;                    
                  }
              }

              if (i == 3) // Tipo Solucion
              {
                  if (solucion && !valor.equals("-1"))  // -1 si no se selecciono nada
                    dtoP.setTipoSolucion(new Long(valor));
                  else
                    dtoP.setTipoSolucion(null);
              }

              if (i == 4 ) // Desc Solucion
              {
                  if (solucion && hayCampoValor)
                    dtoP.setDescripcionSolucion(valor);
                  else
                    dtoP.setDescripcionSolucion(null);
              } 


              if (i == 5 )  // Negocio
              {
                  if (hayCampoValor)
                    dtoP.setNegocio(valor);
                  else
                    dtoP.setNegocio(null);
              }
                  
              i++;
              if ( i == 6)
              {
                    // Reinicializa variables.
                   solucion = false;
                   vSolucion.add(dtoP);              
                   //traza("dtoP: " + dtoP.toString() );
                   i = 0;
                   dtoP = new DTOProblemaSolucion();
              }  

              dtoP.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
              dtoP.setPrograma(UtilidadesSession.getFuncion(this));

              
           }

           DTOProblemaSolucion[] dtoProbSolu = (DTOProblemaSolucion[]) vSolucion.toArray(new DTOProblemaSolucion[vSolucion.size()]);

           return dtoProbSolu;

    }

    private Long[] parseaSubTipos(String elem) throws Exception {
          // Siempre el segundo 
          // h_comboTipoCliente_0=1;h_comboSubtipoCliente_0=1;h_comboTipoCliente_1=2;h_comboSubtipoCliente_1=4;h_comboTipoCliente_2=3;h_comboSubtipoCliente_2=5;··
          Vector vSubTipos = new Vector();
          StringTokenizer tok = new StringTokenizer(elem, ";");
          StringTokenizer tokElem = null;
          boolean subtipo = false;

          while (tok.hasMoreTokens()) {
              String strSubT = tok.nextToken();

              if (subtipo) {
                    tokElem = new StringTokenizer(strSubT, "=");

                    String tipo = tokElem.nextToken(); // Nombre de campo (no importa)
                    tipo = tokElem.nextToken(); // Numero (el que se necesita).
                    vSubTipos.add(new Long(tipo));
              }

              subtipo = !subtipo;
          }

          //traza("Vector de subtipos: " + vSubTipos.toString());

          Long[] arrayLong = new Long[vSubTipos.size()];

          // Arma el array de Long[]
          for (int i = 0; i < vSubTipos.size(); i++)
              arrayLong[i] = (Long) vSubTipos.get(i);

          return arrayLong;
    }


    private Vector obtieneTipos(String cadena) throws Exception
    {
          System.out.println("------ Entrando a obtiene Tipos --------");
          RecordSet tiposCliente = new RecordSet();
          RecordSet subTipos = new RecordSet();
          Vector vSubTipos = new Vector();
          Long[] subtipos = null;

          Vector vTipos = new Vector();
          Vector vSubtipos = new Vector();
          
          tiposCliente.setColumnCount(2);
          subTipos.setColumnCount(3);
          Vector vTiposCol = new Vector();
          vTiposCol.add("OID_CLIENTE");
          vTiposCol.add("DESC_CLIENTE");
          tiposCliente.setColumnIdentifiers( vTiposCol );

          vTiposCol = new Vector();
          vTiposCol.add("OID_CLIENTE");
          vTiposCol.add("OID_SUBTIPO");
          vTiposCol.add("DESC_CLIENTE");          
          subTipos.setColumnIdentifiers(vTiposCol);

          StringTokenizer tok = new StringTokenizer(cadena, ";");
          StringTokenizer tokCampo = null;
          String valor = null;
          String sCampo = null;
          int contadorFilas = 0;
          int contadorCampos = 0;
          
          //traza("Fila: " + contadorFilas); // Seria 0. 
          while ( tok.hasMoreTokens() )
          {
            int i = 0; // Se procesa el token cuando i = 0 e i = 2 (Id Cliente y Descripcion).
            sCampo = tok.nextToken();
            //traza("sCampo: " + sCampo);
            tokCampo = new StringTokenizer(sCampo, "=");
            while ( tokCampo.hasMoreTokens() )  // Proceso el 4campo actual.
            {
                  //traza("Procesa campo " + contadorCampos);
                  valor = tokCampo.nextToken(); // Este no importa, es el nombre del campo.
                  valor = tokCampo.nextToken();  // Valor del campo, este es el que importa.
                  if ( contadorCampos == 0 ) // Se tiene el Oid Tipo 
                  {
                    tiposCliente.setRowCount( tiposCliente.getRowCount()+1 );
                    subTipos.setRowCount( subTipos.getRowCount()+1);
                    tiposCliente.setValueAt(valor, contadorFilas, 0);
                    subTipos.setValueAt(valor, contadorFilas, 0);
                  }

                  if ( contadorCampos == 1) {// Se tiene el Oid Subtipo
                    vSubTipos.add(new Long(valor));
                    subTipos.setValueAt(valor, contadorFilas, 1);
                  }

                  if ( contadorCampos == 2) // Se tiene la Desc Tipo
                    tiposCliente.setValueAt(valor, contadorFilas, 1);

                  if ( contadorCampos == 3) // Se tiene la Desc Subtipo
                    subTipos.setValueAt(valor, contadorFilas, 2);
                  
            }
            contadorCampos++;

            if (contadorCampos == 4)
            {
              contadorFilas++;
              contadorCampos = 0;
              //traza("Fila: " + contadorFilas);              
            }


          }

          // Arma el array Long[] con los oid Subtipos
          Long[] sRetorno = (Long[]) vSubTipos.toArray( new Long[vSubTipos.size()] );
          //traza("tiposCliente: " + tiposCliente);
          //traza("subTipos: " + subTipos);

          Vector v = new Vector();
          v.add(tiposCliente);
          v.add(subTipos);
          v.add(sRetorno);

          return v;
          
      
    }
//--------------------------------------------------------------------------------------------------------------------------------//
         private Long obtenerValorDefecto(String codigo) throws Exception{
                  if(this.mapaValores == null){
                           obtenerValoresDefecto();
                  }
                  traza( "obtenerValorDefecto("+codigo+"):"+this.mapaValores.get(codigo));
                  Object obj = this.mapaValores.get(codigo);
                  if ( obj != null ){
                           return new Long(  ((BigDecimal)this.mapaValores.get(codigo)).longValue() ) ;
                  }else{
                           return (Long)obj;
                  }

         }

         private void obtenerValoresDefecto() throws Exception{
                  UtilidadesSession utilidadesSesion = new UtilidadesSession();
                  UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
                  MareBusinessID id;
                  Vector paramEntrada;
                  DTOBelcorp dtoBelcorp;

                  id = new MareBusinessID("MAEObtenerValoresDefectoClientes");
                  paramEntrada = new Vector();
                  dtoBelcorp = new DTOBelcorp();
                  dtoBelcorp.setOidPais(utilidadesSesion.getPais(this));
                  dtoBelcorp.setOidIdioma(utilidadesSesion.getIdioma(this));
                  paramEntrada.add(dtoBelcorp);
                  paramEntrada.add(id);
                  DruidaConector conector = conectar("ConectorTipoSubtipo", paramEntrada);
                  DTOSalida dtoSalida = (DTOSalida) conector.objeto("DTOSalida");


                  RecordSet valores = dtoSalida.getResultado();
                  this.mapaValores = new HashMap();
                  int tamanio = valores.getRowCount();
                  traza("obtenerValoresDefecto():"+ tamanio);
                  for ( int i = 0; i < tamanio; i++){
                           mapaValores.put( valores.getValueAt(i,"CODIGO"), valores.getValueAt(i,"OID") );
                  }
         }

         //	Agregado por HRCS - Fecha 04/04/2007 - Incidencia Sicc20070184
    //  Modificado por HRCS - Fecha 17/08/2007 - Cambio Sicc20070361
/*
         private void validarRecteHijaDupla() throws Exception {
                  
         String validacionOk = "mensajeValidacionRecteOK();";
                  String validacionError1 = "mensajeValidacionErrorEsHijaDupla();";
         String validacionError2 = "mensajeValidacionErrorNoEsConsultora();";
         String validacionError3 = "mensajeValidacionErrorNoExiste();";
                  try	{
                            pagina("salidaGenerica");

                            String codigoCliente = conectorParametroLimpia("codigoClienteValidar", "", true);
                            String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
                            
                            MareBusinessID id = new MareBusinessID("MAEValidarTipoClienteHijaDupla");
                            DTOCodigoCliente dtoCodClie = new DTOCodigoCliente();
                            dtoCodClie.setCodigoCliente(codigoCliente);
                            dtoCodClie.setPrograma("LPInsertarCliente");
                            
              Vector paramEntrada = new Vector();
                            paramEntrada.add(dtoCodClie);
                            paramEntrada.add(id);
                            DruidaConector conectorR = conectar("ConectorTipoSubtipo", paramEntrada);
                            DTOSalida dtoSalida = (DTOSalida) conectorR.objeto("DTOSalida");
                            RecordSet salida = (RecordSet) dtoSalida.getResultado();
                            
                            if (salida!=null && !salida.esVacio()) {
                                     Long oid = new Long( ((BigDecimal)salida.getValueAt(0,0)).longValue() );
                                     String codigo = (String)salida.getValueAt(0,1);
                                     Long tipo = new Long( ((BigDecimal)salida.getValueAt(0,2)).longValue() );
                                     Long subtipo = new Long( ((BigDecimal)salida.getValueAt(0,3)).longValue() );
                   Long CONST_HIJADUPLA = new Long( ((BigDecimal)salida.getValueAt(0,4)).longValue() );
                   Long CONST_CONSULTORA = new Long( ((BigDecimal)salida.getValueAt(0,5)).longValue() );
                   traza("*** Oid Cliente: " + oid ); 
                                     traza("*** Tipo Cliente: " + tipo ); 
                                     traza("*** Subtipo Cliente: " + subtipo );
                                     
                   if (tipo.longValue() == CONST_HIJADUPLA.longValue())  {
                      asignarAtributo("VAR", "ejecutar", "valor", validacionError1);    
                   }
                   else if (tipo.longValue() != CONST_CONSULTORA.longValue())  {
                      asignarAtributo("VAR", "ejecutar", "valor", validacionError2);
                   }
                                     else   {
                      asignarAtributo("VAR", "ejecutar", "valor", validacionOk);
                   }
                            }
              else   {
                   asignarAtributo("VAR", "ejecutar", "valor", validacionError3);
              }
              // Para el caso de modificar
              if( casoDeUso!=null && casoDeUso.equals("ModificarCliente") ) {
                                    asignarAtributo("VAR", "cerrarVentana", "valor", "false");
                            }
                  } catch(Exception e)	{
                           traza("Excepcion: " + e);
                           throw e;
                  }
         }
*/
         //	Agregado por HRCS - Fecha 14/08/2007 - Cambio Sicc20070361
/*
         private void validarEdadHijaDupla() throws Exception {
                  
         String validacionOk = "mensajeValidacionEdadOK();";
                  //String validacionError = "mensajeValidacionEdadError();";
         String casoDeUso = "";
                  try	{
                            pagina("salidaGenerica");

                            casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
                            String edad = conectorParametroLimpia("hidEdad", "", true);
              traza("Edad: " + edad );
                            MareBusinessID id = new MareBusinessID("MAEValidarEdadHijaDupla");

                            DTOCodigoCliente dtoCodClie = new DTOCodigoCliente();
                            dtoCodClie.setOidPais(UtilidadesSession.getPais(this));
                            dtoCodClie.setPrograma("LPInsertarCliente");
                            if (edad!=null && !edad.equals(""))
                  dtoCodClie.setEdad(new Integer(edad));

                            Vector paramEntrada = new Vector();
                            paramEntrada.add(dtoCodClie);
                            paramEntrada.add(id);
                            DruidaConector conectorR = conectar("ConectorValidarRecteHijaDupla", paramEntrada);

                            DTOBoolean dto = (DTOBoolean) conectorR.objeto("DTOBoolean");
                            if (dto.getValor())
                            {
                                asignarAtributo("VAR", "ejecutar", "valor", validacionOk);
                                    traza("Edad de Hija Dupla es Valida: " + dto.getValor() );
                            }
                            else {
                                     asignarAtributo("VAR", "ejecutar", "valor", "mensajeValidacionEdadError('"+casoDeUso+"');");
                                     traza("Edad de Hija Dupla es No Valida: " + dto.getValor() );
                            }
              // Agregamos esto para que no se cierre la ventana en Modificar Cliente
              //traza("CasoDeUso: " + casoDeUso );
              //if( casoDeUso!=null && casoDeUso.equals("ModificarCliente") ) {
              //    asignarAtributo("VAR", "cerrarVentana", "valor", "false");
              //}
                  } catch(Throwable e)	{
             this.traza("Error en validar edad: " + e);
             e.printStackTrace();
                           asignarAtributo("VAR", "ejecutar", "valor", "mensajeValidacionEdadError2('"+e.getCause().getMessage()+"');");
                           //throw e;
                  }
         finally {
              // Agregamos esto para que no se cierre la ventana en Modificar Cliente
              traza("CasoDeUso: " + casoDeUso );
              if( casoDeUso!=null && casoDeUso.equals("ModificarCliente") ) {
                   asignarAtributo("VAR", "cerrarVentana", "valor", "false");
              }
         }
         }
*/
         //	Agregado por HRCS - Fecha 15/08/2007 - Cambio Sicc20070361
         private void enviarMensajeRechazoDupla() throws Exception {
                  
         //String validacionOk = "mensajeValidacionEdadOK();";
                  //String validacionError = "mensajeEnvioMensajeError();";
                  try	{
                            pagina("salidaGenerica");

                            String codigoCliente = conectorParametroLimpia("codigoClienteValidar", "", true);
                            String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);

                            MareBusinessID id = new MareBusinessID("MAEEnviarMensajeRechazoDupla");

                            DTOCodigoCliente dtoCodClie = new DTOCodigoCliente();
                            dtoCodClie.setOidPais(UtilidadesSession.getPais(this));
                            dtoCodClie.setOidIdioma(UtilidadesSession.getIdioma(this));
                            dtoCodClie.setCodigoCliente(codigoCliente);
                            dtoCodClie.setPrograma("LPInsertarCliente");

                            Vector paramEntrada = new Vector();
                            paramEntrada.add(dtoCodClie);
                            paramEntrada.add(id);
                            DruidaConector conectorR = conectar("ConectorValidarRecteHijaDupla", paramEntrada);

                            DTOBoolean dto = (DTOBoolean) conectorR.objeto("DTOBoolean");
                            if (dto.getValor())
                            {
                                //asignarAtributo("VAR", "ejecutar", "valor", validacionOk);
                                    traza("Se envio el mensaje: " + dto.getValor() );
                            }
                            else {
                                     //asignarAtributo("VAR", "ejecutar", "valor", validacionError);
                                     traza("No se envio el mensaje: " + dto.getValor() );
                            }
              // Agregamos esto para que no se cierre la ventana en Modificar Cliente
              traza("CasoDeUso: " + casoDeUso );
              if( casoDeUso!=null && casoDeUso.equals("ModificarCliente") ) {
                   asignarAtributo("VAR", "cerrarVentana", "valor", "false");
              }
                  } catch(Exception e)	{
                           traza("Excepcion: " + e);
                           throw e;
                  }
         }
}