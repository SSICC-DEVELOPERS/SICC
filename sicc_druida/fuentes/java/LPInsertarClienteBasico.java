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


//import LPSICCBase;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.dtos.mae.DTOCampo;
import es.indra.sicc.dtos.mae.DTOClasificacionCliente;
import es.indra.sicc.dtos.mae.DTOClienteMarca;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposCliente;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOIdentificacion;
import es.indra.sicc.dtos.mae.DTOPestanya1Base;
import es.indra.sicc.dtos.mae.DTOPestanya2Base;
import es.indra.sicc.dtos.mae.DTOPestanya3Base;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.Exception;
import java.lang.StringBuffer;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.ArrayList;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOString;


public class LPInsertarClienteBasico extends LPSICCBase {
    private HashMap param = new HashMap();
    private HashMap param2 = new HashMap();
    private HashMap ptna1 = new HashMap();
    private HashMap ptna2 = new HashMap();
    private HashMap ptna3 = new HashMap();
    private HashMap tipoSubt = new HashMap();
         private String origen = "";

    public LPInsertarClienteBasico() {
         super();
    }

    public void inicio() throws Exception {
         setTrazaFichero();
         traza("entro a inicio");
         pagina("contenido_clientes_insertar");
         this.getConfiguracionMenu();
         asignarAtributoPagina("cod", "0408");
    }

    public void ejecucion() throws Exception {
         setTrazaFichero();

         String accion = conectorParametroLimpia("accion", "", true);
         param = conectorParametro();
                  origen = conectorParametro("origen");
traza("*************origen*******************");
//traza(origen);
traza("*************origen*******************");
                  if(origen == null) {
                           origen = " ";
                  }

         //logPageParameters();

         try {
             String focusPrimero = conectorParametroLimpia("hidFocusPrimerComponente", "", true);
             traza("focusPrimero: " + focusPrimero);
traza("+++++acion+++: " + accion);
             if (accion.equals("")) {
                  if ((conectorParametroLimpia("hidListaIdentificacion", "", true)).equals("")) {
                      conectorParametroSesion("elementos", "");
                      conectorParametroSesion("hidListaIdentificacion", "");

                      conectorParametroSesion("textApellido1", "");
                      conectorParametroSesion("textApellido2", "");
                      conectorParametroSesion("textApellidoCasada", "");
                      conectorParametroSesion("cbFormaPago", "");
                      conectorParametroSesion("textNombre2", "");
                      conectorParametroSesion("textNombre1", "");
                      conectorParametroSesion("cbTratamiento", "");
                      conectorParametroSesion("textApellido2", "");
                      conectorParametroSesion("rbSexo", "");
                      conectorParametroSesion("codigoCliente", "");
                      conectorParametroSesion("hidFocusPrimerComponente", "");

                      conectorParametroSesion("elementosExtra", "");
                      conectorParametroSesion("elementos3", "");
                      conectorParametroSesion("elementosP3Marca", "");
                      conectorParametroSesion("elementosP3MarcaListado2", "");
                  }

                  InicioLP();
                  asignarAtributo("CAPA", "capaTitulo", "visibilidad", "hidden");
             }

             if (accion.equals("Siguiente1")) {
                  mostrarPantalla(accion);
                  this.colaParametros(0);
                  Pestana1();
                  asignarAtributo("CAPA", "capaTitulo", "visibilidad", "visible");
             }

             if (accion.equals("Validar")) {
                  /*Cleal - 72
                                    mostrarPantalla(accion);
                  colaParametros(1);
                  Pestana2();
                                    */
                                    validar();
             }
                           //Cleal - 72
                           if (accion.equals("siguiente1_validar")){
                                mostrarPantalla(accion);
                  colaParametros(1);
                  Pestana2();
                           }

             if (accion.equals("Siguiente3")) {
                  mostrarPantalla(accion);
                  colaParametros(2);
                  this.Pestana3();
             }

             if (accion.equals("Guardar")) {
                  colaParametros(3);
                  this.Guardar();
             }

             if (accion.equals("BackPestanya1")) {
                  this.mostrarPantalla("Siguiente1");
                  this.BackPestanya1();
             }

             if (accion.equals("BackPestania2")) {
                  this.mostrarPantalla("Validar");
                  this.BackPestania2();
             }

             asignarAtributo("VAR", "hidFocusPrimerComponente", "valor", focusPrimero);
                           this.asignarAtributo("VAR", "origen", "valor", origen);

         } catch (Exception ex) {
             this.lanzarPaginaError(ex);
         }
    }

    void logPageParameters() throws Exception {
         traza("*******************   INI Parametros   ***************************");

         Set en = param.keySet();
         Iterator it = en.iterator();

         while (it.hasNext()) {
             String key = (String) it.next();
             String value = (String) param.get(key);
             traza(key + " = " + value);
         }

         traza("*******************   FIN Parametros   ***************************");
    }
         
         private void validar() throws Exception{
                  traza("Entro validar()...");
                  pagina("salidaGenerica");
				  /*Modificado BELC300024068*/
				  asignarAtributo( "VAR", "cerrarVentana", "valor", "false");
				  /*Modificado BELC300024068*/
                  
				  DTOColeccion dto = new DTOColeccion();
                  Long lIdioma = UtilidadesSession.getIdioma(this);
         Long lPais = UtilidadesSession.getPais(this);
                  ArrayList arrDocs = arrayToArrayList(documentos());
                  dto.setLista(arrDocs);
                  dto.setOidPais(lPais);
                  dto.setOidIdioma(lIdioma);

                  MareBusinessID idBusiness = new MareBusinessID("MAEValidarDocumento");
                  Vector params = new Vector();
         params.add(dto);
         params.add(idBusiness);
         traza("antes de conectar");
         DruidaConector conector = conectar("ConectorValidarDocumento", params);
                  traza("Clase: "+conector.objeto("DTOString").getClass().getName());
                  DTOString dtoStr = (DTOString) conector.objeto("DTOString");
                  String nroDoc = dtoStr.getCadena();
                  traza("nroDoc: "+nroDoc);

                  if(!"".equals(nroDoc)){
                           traza("El documento ya existe");
                           asignarAtributo( "VAR", "ejecutar", "valor", "mostrarerror('"+nroDoc+"')");
                  } else{
                           traza("accionExitosa");
                           asignarAtributo( "VAR", "ejecutar", "valor", "accionExitosa()");
                  }

         }

         private ArrayList arrayToArrayList(DTOIdentificacion[] ident) throws Exception{
                  ArrayList arrDocs = new ArrayList();
         
         int size = ident.length;
         for(int i=0;i<size;i++){
            DTOIdentificacion dtoI = (DTOIdentificacion) ident[i];
            arrDocs.add(dtoI);
         }
         
         return arrDocs;
         }

         private DTOIdentificacion[] documentos() throws Exception {
         String valores = conectorParametroLimpia("hidListaIdentificacion", "", true);
         traza("documentos() - vallores " + valores);

         //h_comboTipoDocId_0=11;h_TextoNDoc_0=10;h_TextoConfirmacionDoc_0=10;h_RbDocPrincipal_0=true;h_comboPersonaEmpresa_0=P;
         //h_comboTipoDocId_1=100;h_TextoNDoc_1=20;h_TextoConfirmacionDoc_1=20;h_RbDocPrincipal_1=false;h_comboPersonaEmpresa_1=P;··
         StringTokenizer tokTemp = new StringTokenizer(valores, ";");

         int cantRegistros = 0;

         while (tokTemp.hasMoreTokens()) {
             tokTemp.nextToken();
             cantRegistros++;
         }

         cantRegistros = cantRegistros / 5;

         DTOIdentificacion[] dtoIden = new DTOIdentificacion[cantRegistros];

         StringTokenizer tok = new StringTokenizer(valores, ";");
         traza("Paso -12 idenfificaciones");

         String nombre = new String();
         traza("Paso -13 idenfificaciones");

         String nombreAcotado = new String();
         traza("Paso -14 idenfificaciones");

         String valor = new String();
         int indice = -1;
         traza("Paso -15 idenfificaciones");

         while (tok.hasMoreTokens()) {
             //h_comboTipoDocId_1=100;
             traza("antes del componente valor");

             String componenteValor = tok.nextToken();
             traza("despues del componente valor");

             StringTokenizer tok2 = new StringTokenizer(componenteValor, "=");
             traza("Paso 1 idenfificaciones");

             if (tok2.hasMoreTokens()) {
                  nombre = tok2.nextToken();
                  traza("Paso 2 idenfificaciones");

                  //h_comboTipoDocId_1
             }

             traza("Paso 3 idenfificaciones");

             if (tok2.hasMoreTokens()) {
                  traza("Paso 4 idenfificaciones");

                  valor = tok2.nextToken();

                  //100
             }

             traza("Paso 5 idenfificaciones");

             StringTokenizer tok3 = new StringTokenizer(nombre, "_");
             traza("Paso 6 idenfificaciones");

             if (tok3.hasMoreTokens()) {
                  traza("Paso 7 idenfificaciones");

                  tok3.nextToken();
             }

             traza("Paso 8 idenfificaciones");

             if (tok3.hasMoreTokens()) {
                  traza("Paso 9 idenfificaciones");

                  nombreAcotado = tok3.nextToken();
             }

             traza("Paso 10 idenfificaciones");

             if (tok3.hasMoreTokens()) {
                  traza("Paso 11 idenfificaciones");

                  indice = Integer.parseInt(tok3.nextToken());
             }

             traza("Paso 12 idenfificaciones");

             if (dtoIden[indice] == null) {
                  traza("Paso 13 idenfificaciones");

                  dtoIden[indice] = new DTOIdentificacion();

                  //dtoIden[indice].
             }

             traza("Paso 14 idenfificaciones");

             if (nombreAcotado.equals("comboTipoDocId")) {
                  traza("Paso 15 idenfificaciones");

                  dtoIden[indice].setTipoDocumento(new Long(valor));
             }

             traza("Paso 16 idenfificaciones");

             if (nombreAcotado.equals("TextoNDoc")) {
                  traza("Paso 17 idenfificaciones");

                  dtoIden[indice].setNumeroDocumento(valor);
             }

             traza("Paso 18 idenfificaciones");

             if (nombreAcotado.equals("RbDocPrincipal")) {
                  traza("Paso 19 idenfificaciones");

                  if (valor.equals("true")) {
                      traza("Paso 20 idenfificaciones");

                      dtoIden[indice].setEsPrincipal(new Boolean(true));
                  } else {
                      traza("Paso 21 idenfificaciones");

                      dtoIden[indice].setEsPrincipal(new Boolean(false));
                  }
             }

             traza("Paso 22 idenfificaciones");

             if (nombreAcotado.equals("comboPersonaEmpresa")) {
                  traza("Paso 23 idenfificaciones");

                  dtoIden[indice].setIndPersonaEmpresa(valor);
             }

             traza("Paso 24 idenfificaciones");
             dtoIden[indice].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
             dtoIden[indice].setPrograma(UtilidadesSession.getFuncion(this));

         }

         for (int t = 0; t < dtoIden.length; t++) {
             traza("DTO A ENVIAR " + dtoIden[t]);
         }

         return dtoIden;
    }
         


    private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception {
         StringBuffer salida = new StringBuffer();
         int sizeColums = datos.getColumnCount();
         int sizeRows = datos.getRowCount();
         boolean flag = false;
         Text txt;

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

                      if (flag) {
                           e_campo2.setAttribute("NOMBRE", columsDesc.elementAt(j).toString() + ".DESCRIPCION");
                           flag = false;
                      } else {
                           e_campo2.setAttribute("NOMBRE", columsDesc.elementAt(j).toString() + ".CODIGO");
                           flag = true;
                      }

                      e_campo2.setAttribute("TIPO", "OBJECTO");
                      e_campo2.setAttribute("LONGITUD", "50");

                      txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null) ? "" : datos.getValueAt(i, j).toString()));

                      e_campo2.appendChild(txt);
                      e_row.appendChild(e_campo2);
                  }
             }
         }

         conectorValoresPosibles.setXML(docDestino.getDocumentElement());

         return conectorValoresPosibles;
    }

    private void InicioLP() throws Exception {
         DTOTipoSubtipo dtotsubtipo = new DTOTipoSubtipo();
         DTOBelcorp dtoBelcorp = new DTOBelcorp();
         UtilidadesSession sesion = new UtilidadesSession();
         UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();

         dtoBelcorp.setOidPais(sesion.getPais(this));
         dtoBelcorp.setOidIdioma(sesion.getIdioma(this));

traza("ale 1");

         dtotsubtipo = (DTOTipoSubtipo) obtenerDatosSalida("MAEObtenerTipoSubtipo", "ConectorTipoSubtipo", (DTOBelcorp) dtoBelcorp);
traza("ale 2");
         RecordSet tipo = (RecordSet) dtotsubtipo.getTipos();

        // utilidadesBelcorp.agregarRegistroVacio(tipo, 0);

         Vector colID = tipo.getColumnIdentifiers();
         DruidaConector dtipo = this.generarConector("DTOSalida.tipos_ROWSET", tipo, colID);

         RecordSet subtipo = (RecordSet) dtotsubtipo.getSubtipos();
         Vector colID2 = subtipo.getColumnIdentifiers();
         DruidaConector dsubtipo = this.generarConector("DTOSalida.subtipos_ROWSET", subtipo, colID2);

         this.crearListaLP(colID2, subtipo.getColumnCount(), "Capa1", "Lista1", "14", "200");

         asignar("COMBO", "comboTipoCliente", dtipo, "DTOSalida.tipos_ROWSET");

         asignar("LISTA", "Lista1", dsubtipo, "DTOSalida.subtipos_ROWSET");

         // Limpio de session los datos de todas las pestañas, ya que se inicio o re-inicio el caso de uso
         String vuelve = conectorParametroLimpia("atrasTipoSubtipo", "", true);
         String hidListaIdentificacion = conectorParametroLimpia("hidListaIdentificacion", "", true);
         traza("**************************************************Accion Vacia*************************************");

         if (vuelve.equals("")) {
             conectorParametroSesion("hidListaIdentificacion", new String());
             conectorParametroSesion("elementosP2", new String());
             conectorParametroSesion("elementosP3", new String());
             conectorParametroSesion("elementosP4", new String());
         } else {
             // tengo que guardar los datos que vienen de la pestanya1.
             conectorParametroSesion("hidListaIdentificacion", hidListaIdentificacion);
         }

         String elementos = (String) conectorParametroSesion("elementos");

         traza("elementos de la accion vacia " + elementos);

         if (elementos != null) {
             asignarAtributo("VAR", "elementos", "valor", elementos);
         }

         if ((conectorParametroLimpia("codigoCliente", "", true) != null) && !(conectorParametroLimpia("codigoCliente", "", true).equals(""))) {
             traza("++++++++++++cliente " + conectorParametroLimpia("codigoCliente", "", true));

             conectorParametroSesion("codigoCliente", (String) conectorParametroLimpia("codigoCliente", "", true));
         }
    }

    private void Pestana1() throws Exception {
         try {
             traza("entro en Pestana1");

             DTOBelcorp dtobelcorp = new DTOBelcorp();
             UtilidadesSession utls = new UtilidadesSession();
             UtilidadesBelcorp utilidades = new UtilidadesBelcorp();

             dtobelcorp.setOidPais(utls.getPais(this));
             dtobelcorp.setOidIdioma(utls.getIdioma(this));
             traza("Obtenemos la logica de negocio");

             DTOPestanya1Base dtop1Base = (DTOPestanya1Base) obtenerDatosSalida("MAEPestanya1Base", "ConectorObjetoCrearBasico", (DTOBelcorp) dtobelcorp);
             traza("paso dto");

             RecordSet pestanya1 = (RecordSet) dtop1Base.getTiposDocumento();
             traza("paso recordset");
             utilidades.agregarRegistroVacio(pestanya1, 0);
             traza("paso agregar registro vacio");

             Vector colID = pestanya1.getColumnIdentifiers();
             traza("paso vector");

             DruidaConector dtipo = this.generarConector("DTOSalida.tiposDocumento", pestanya1, colID);
             traza("paso conector");
             asignar("COMBO", "comboTipoDocId", dtipo, "DTOSalida.tiposDocumento");
             traza("paso combo");

             if ((dtop1Base.getCodigoCliente() == null) || (dtop1Base.getCodigoCliente().equals(""))) {
                  traza("dentro del if");
                  asignarAtributo("VAR", "codigoAutomatico", "valor", new Boolean(false).toString());
             } else {
                  traza("esta en el else");
                  asignarAtributo("LABELC", "lblCodClienteActual", "valor", dtop1Base.getCodigoCliente());
                  traza("asigno label");

                  asignarAtributo("VAR", "codigoAutomatico", "valor", new Boolean(true).toString());
                  traza("asigno hidden");
                  asignarAtributo("VAR", "codigoCliente", "valor", dtop1Base.getCodigoCliente());
                  traza("asigno cod cliente");
                  conectorParametroSesion("codigoCliente", dtop1Base.getCodigoCliente());
                  traza("puso cliente en sesion");
                  conectorParametroSesion("conectorcomboTipoDocId", dtipo);
                  traza("armo conector");
             }

             if (dtop1Base.getDigitoControl() == null) {
                  asignarAtributo("VAR", "digitoControl", "valor", " ");
                  traza("if digito control");
             } else {
                  asignarAtributo("VAR", "digitoControl", "valor", dtop1Base.getDigitoControl());
                  traza("else de digito control");
             }

             String longCodCliente = this.obtenerLongitudCodigoCliente().toString();
             asignarAtributo("VAR", "hidlongCliente", "valor", longCodCliente);

             String elementosP1 = (String) conectorParametroSesion("hidListaIdentificacion");

             traza("elementos p1 " + elementosP1);

             if (elementosP1 != null) {
                  asignarAtributo("VAR", "hidListaIdentificacion", "valor", elementosP1);
             }

             //Esto es para que recargue la pestaña 0 volviendo de la 1
             String elementos = conectorParametroLimpia("elementos", "", true);

             if (!elementos.equals("")) {
                  conectorParametroSesion("elementos", elementos);
             }

             traza("elementos cuando esta en pestanya 1: " + elementos);

             //le guardo en sesion los parametros de la pestaña 2
             String textApellido1 = conectorParametroLimpia("textApellido1", "", true);

             traza("valor text apellido " + textApellido1);
             traza("**************cliente " + conectorParametroSesion("codigoCliente"));

             if ((conectorParametroSesion("codigoCliente") != null) && !(conectorParametroSesion("codigoCliente").equals(""))) {
                  traza("entro al if de codigo cliente");

                  String codigoCliente = (String) conectorParametroSesion("codigoCliente");
                  asignarAtributo("VAR", "codigoCliente", "valor", codigoCliente);
             }

             if (!textApellido1.equals("")) {
                  traza("entro al if");
                  conectorParametroSesion("textApellido1", param.get("textApellido1"));
                  conectorParametroSesion("textApellido2", param.get("textApellido2"));
                  conectorParametroSesion("textApellidoCasada", param.get("textApellidoCasada"));
                  conectorParametroSesion("textNombre1", param.get("textNombre1"));
                  conectorParametroSesion("textNombre2", param.get("textNombre2"));
                  conectorParametroSesion("rbSexo", param.get("rbSexo"));
                  conectorParametroSesion("cbTratamiento", param.get("cbTratamiento"));
                  conectorParametroSesion("cbFormaPago", param.get("cbFormaPago"));
             }
         } catch (Throwable th) {
             //traza("error en Pestana1");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");

             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +         dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    private Object obtenerDatosSalida(String bID, String conector, Object dto) throws Exception {
         try {
             //traza("entro a ObtenerDatos Salida");
             Vector paramEntrada = new Vector();
             MareBusinessID id = new MareBusinessID(bID);
             paramEntrada.add(dto);
             paramEntrada.add(id);

             //traza("****************dto del obtener: " + dto);
             //traza("****************id del obtener: " + id.getBusinessID());
             //traza("*********Conector " + conector);
             DruidaConector ver = conectar(conector, paramEntrada);
             Object obj = ver.objeto("DTOSalida");

             //traza("ver DTOSalida " + obj.toString());
             return obj;
         } catch (Throwable th) {
             //traza("error en Obtener Datos Salida");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");
             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +         dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    private void mostrarPantalla(String accion) throws Exception {
         try {
             if (accion.equals("")) {
                  pagina("contenido_clientes_insertar");
             }

             if (accion.equals("Siguiente1")) {
                  //traza("Siguiente1");
                  pagina("contenido_grupo1_cliente_basico_crear");
             }
                           /*
             if (accion.equals("Validar")) {
                  pagina("contenido_grupo2_cliente_basico_crear");
             }
                           */
                           if (accion.equals("siguiente1_validar")) {
                  pagina("contenido_grupo2_cliente_basico_crear");
             }

             if (accion.equals("Siguiente3")) {
                  pagina("contenido_grupo3_cliente_basico_crear");
             }

             this.getConfiguracionMenu();
             asignarAtributoPagina("cod", "0408");
         } catch (Throwable th) {
             //traza("error en Mostrar Pantalla");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");
             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +              dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    private DruidaConector generarConectorII(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception {
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
                      Element e_campo0 = docDestino.createElement("CAMPO");
                      e_campo0.setAttribute("NOMBRE", columsDesc.elementAt(j).toString());
                      e_campo0.setAttribute("TIPO", "OBJECTO");
                      e_campo0.setAttribute("LONGITUD", "50");

                      Text txt = docDestino.createTextNode("");
                      e_campo0.appendChild(txt);
                      e_row.appendChild(e_campo0);

                      //------------------------------------------------------------
                      Element e_campo2 = docDestino.createElement("CAMPO");
                      e_campo2.setAttribute("NOMBRE", columsDesc.elementAt(j).toString());
                      e_campo2.setAttribute("TIPO", "OBJECTO");
                      e_campo2.setAttribute("LONGITUD", "50");

                      Text txt0 = docDestino.createTextNode(((datos.getValueAt(i, j) == null) ? "" : datos.getValueAt(i, j).toString()));
                      e_campo2.appendChild(txt0);
                      e_row.appendChild(e_campo2);
                  }
             }
         }

         conectorValoresPosibles.setXML(docDestino.getDocumentElement());

         return conectorValoresPosibles;
    }

    private void crearListaLP(Vector nomColumns, int cantColumns, String nomCapa, String nomLista, String XCapa, String YCapa) throws Exception {
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

         //traza("despues de poner en variables los titulos " + columnas + " " +      cantColumns);
         if (cantColumns >= 1) {
             eCOL_1.appendChild((Element) columnas.get(0));
             eCABECERA.appendChild(eCOL_1);

             //traza("1");
         }

         if (cantColumns >= 2) {
             eCOL_2.appendChild((Element) columnas.get(1));
             eCABECERA.appendChild(eCOL_2);

             //traza("1");
         }

         if (cantColumns >= 3) {
             eCOL_3.appendChild((Element) columnas.get(2));
             eCABECERA.appendChild(eCOL_3);

             //traza("1");
         }

         if (cantColumns >= 4) {
             eCOL_4.appendChild((Element) columnas.get(3));
             eCABECERA.appendChild(eCOL_4);

             //traza("1");
         }

         if (cantColumns >= 5) {
             eCOL_5.appendChild((Element) columnas.get(4));
             eCABECERA.appendChild(eCOL_5);

             //traza("1");
         }

         if (cantColumns >= 6) {
             eCOL_6.appendChild((Element) columnas.get(5));
             eCABECERA.appendChild(eCOL_6);

             //traza("1");
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

         //traza("### " + cadena.toString());
         ePRESENTACION.setAttribute("bloquesid", cadena.toString());

         Element eROWSET = document.createElement("ROWSET");

         eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
         eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
         eLista.appendChild(eROWSET); //Agrego el rowset de la lista

         eCapa.appendChild(eLista);

         getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);
    }

    private void BackPestanya1() throws Exception {
         try {
             if (param.get("envia").toString().equals("Pag2")) {
                  conectorParametroSesion("pestania_2", param);

                  //traza("refresque pestania_2");
             }

             //trae los parametros guardados de la pantalla1
             HashMap ptna1 = (HashMap) conectorParametroSesion("pestania_1");

             //traza("Vemos ptna1" + ptna1);
             /*

             asignar("COMBO","comboTipoDocId",(DruidaConector)conectorParametroSesion("comboTipoDocId"),"DTOSalida.tiposDocumento");
             asignarAtributo("VAR","codigoAutomatico","valor",(String)conectorParametroSesion("codigoAutomatico_1"));
             asignarAtributo("VAR","digitoControl","valor",(String)conectorParametroSesion("digitoControl_1"));
             asignarAtributo("VAR","nameComboSelected","valor",(String)conectorParametroSesion("nameComboSelected_1"));
             asignarAtributo("VAR","valueComboSelected","valor",(String)conectorParametroSesion("valueComboSelected_1"));
             asignarAtributo("VAR","docPrincipal","valor",(String)conectorParametroSesion("docPrincipal_1"));
             asignarAtributo("VAR","elementos","valor",(String)conectorParametroSesion("elementos_1"));
             asignarAtributo("VAR","componente","valor",(String)conectorParametroSesion("componente_1"));
             asignarAtributo("VAR","radioStatus","valor",(String)conectorParametroSesion("radioStatus_1"));
             asignarAtributo("VAR","codigoCliente","valor",(String)conectorParametroSesion("codigoCliente_1"));
             asignarAtributo("VAR","back","valor","volver");
             asignarAtributo("VAR","elementos","valor",(String)conectorParametroSesion("elementos_1"));
             //asignar("LISTA","Lista1",d_subtipo,"DTOSalida.subtipos_ROWSET");
             */
             asignar("COMBO", "comboTipoDocId", (DruidaConector) conectorParametroSesion("conectorcomboTipoDocId"), "DTOSalida.tiposDocumento");

             //traza("1");
             asignarAtributo("VAR", "codigoAutomatico", "valor", (String) ptna1.get("codigoAutomatico"));

             //traza("2");
             asignarAtributo("VAR", "digitoControl", "valor", (String) ptna1.get("digitoControl"));

             //traza("3");
             asignarAtributo("VAR", "nameComboSelected", "valor", (String) ptna1.get("nameComboSelected"));

             //traza("4");
             asignarAtributo("VAR", "valueComboSelected", "valor", (String) ptna1.get("valueComboSelected"));

             //traza("5");
             asignarAtributo("VAR", "docPrincipal", "valor", (String) ptna1.get("docPrincipal"));

             //traza("6");
             asignarAtributo("VAR", "elementos", "valor", (String) ptna1.get("elementos"));

             //traza("7");
             asignarAtributo("VAR", "componente", "valor", (String) ptna1.get("componente"));

             //traza("8");
             asignarAtributo("VAR", "radioStatus", "valor", (String) ptna1.get("radioStatus"));

             //traza("9");
             asignarAtributo("VAR", "codigoCliente", "valor", (String) ptna1.get("codigoCliente"));

             //traza("10");
             asignarAtributo("VAR", "back", "valor", "volver");

             asignarAtributo("VAR", "codigoCliente", "valor", (String) ptna1.get("codigoCliente"));
         } catch (Throwable th) {
             //traza("error en BackPestanya1");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");
             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +                  dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    private void colaParametros(int ptna) throws Exception {
         try {
             String strTemp = (String) param.get("elementos");
             traza("llego a la cola: " + ptna + "strTemp: " + strTemp);

             if (strTemp != null) {
                  String str = param.get("elementos").toString();
                  traza("despues de elementos");

                  StringTokenizer tok = new StringTokenizer(str, ";");

                  //h_comboTipoCliente_0=1;h_comboTipoCliente_1=2;
                  StringTokenizer tok1 = null;
                  String clave = null;
                  String valor = null;
                  String elem;
                  int dif = 0;

                  while (tok.hasMoreTokens()) {
                      elem = tok.nextToken().toString();

                      //traza("##############" + elem);
                      tok1 = new StringTokenizer(elem, "=");
                      clave = tok1.nextToken().toString();

                      //traza("##############" + clave);
                      valor = elem.substring(clave.length() + 1, elem.length());

                      //traza("##############" + valor);
                      switch (ptna) {
                      case 0:
                           tipoSubt.put(clave, valor);

                           //traza("asigno 0");
                           break;

                      case 1:
                           ptna1.put((String) clave, (String) valor);

                           //traza("&&&&&&&&&&&&&&&&&&&&" + ptna1);
                           break;

                      // case 2:
                      //  ptna2.put((String)clave,(String)valor);
                      //  break;
                      case 3:
                           ptna3.put((String) clave, (String) valor);

                           break;
                      }
                  }

                  switch (ptna) {
                  case 0:
                      traza("tipo" + tipoSubt.get(clave));
                      traza("subtipo" + tipoSubt.get(clave));
                      conectorParametroSesion("tipoSubtipo", tipoSubt);

                      break;

                  case 1:

                      //conectorParametroSesion("Pestana1",ptna1);
                      traza("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                      conectorParametroSesion("codigoAutomatico_1", param.get("codigoAutomatico").toString());
                      conectorParametroSesion("digitoControl_1", param.get("digitoControl").toString());
                      conectorParametroSesion("nameComboSelected_1", param.get("nameComboSelected").toString());
                      conectorParametroSesion("valueComboSelected_1", param.get("valueComboSelected").toString());
                      conectorParametroSesion("docPrincipal_1", param.get("docPrincipal").toString());
                      conectorParametroSesion("elementos_1", param.get("elementos").toString());
                      conectorParametroSesion("componente_1", param.get("componente").toString());
                      conectorParametroSesion("radioStatus_1", param.get("radioStatus").toString());
                      conectorParametroSesion("codigoCliente_1", param.get("codigoCliente").toString());
                      conectorParametroSesion("back", param.get("back").toString());
                      conectorParametroSesion("pestania_1", param);

                      break;

                  case 2:
                      conectorParametroSesion("Pestana2", ptna2);

                      if (param.get("h_textApellido1") != null) {
                           conectorParametroSesion("h_textApellido1", param.get("h_textApellido1").toString());
                      }

                      if (param.get("h_textApellido2") != null) {
                           conectorParametroSesion("h_textApellido2", param.get("h_textApellido2").toString());
                      }

                      if (param.get("h_textApellidoCasada") != null) {
                           conectorParametroSesion("h_textApellidoCasada", param.get("h_textApellidoCasada").toString());
                      }

                      if (param.get("h_textNombre1") != null) {
                           conectorParametroSesion("h_textNombre1", param.get("h_textNombre1").toString());
                      }

                      if (param.get("h_textNombre2") != null) {
                           conectorParametroSesion("h_textNombre2", param.get("h_textNombre2").toString());
                      }

                      if (param.get("h_cbTratamiento") != null) {
                           conectorParametroSesion("h_cbTratamiento", param.get("h_cbTratamiento").toString());
                      }

                      if (param.get("h_cbFormaPago") != null) {
                           conectorParametroSesion("h_cbFormaPago", param.get("h_cbFormaPago").toString());
                      }

                      if (param.get("h_rbSexo") != null) {
                           conectorParametroSesion("h_rbSexo", param.get("h_rbSexo").toString());
                      }

                      if (param.get("textApellido1") != null) {
                           //traza("*********************" +   param.get("textApellido1").toString());
                           conectorParametroSesion("textApellido1", param.get("textApellido1").toString());
                      }

                      if (param.get("accion") != null) {
                           conectorParametroSesion("accion", param.get("accion").toString());
                      }

                      if (param.get("conectorAction") != null) {
                           conectorParametroSesion("conectorAction", param.get("conectorAction").toString());
                      }

                      if (param.get("textApellidoCasada") != null) {
                           conectorParametroSesion("textApellidoCasada", param.get("textApellidoCasada").toString());
                      }

                      if (param.get("cbFormaPago") != null) {
                           conectorParametroSesion("cbFormaPago", param.get("cbFormaPago").toString());
                      }

                      if (param.get("textNombre2") != null) {
                           conectorParametroSesion("textNombre2", param.get("textNombre2").toString());
                      }

                      if (param.get("textNombre1") != null) {
                           conectorParametroSesion("textNombre1", param.get("textNombre1").toString());
                      }

                      if (param.get("casoDeUso") != null) {
                           conectorParametroSesion("casoDeUso", param.get("casoDeUso").toString());
                      }

                      if (param.get("cbTratamiento") != null) {
                           conectorParametroSesion("cbTratamiento", param.get("cbTratamiento").toString());
                      }

                      if (param.get("textApellido2") != null) {
                           conectorParametroSesion("textApellido2", param.get("textApellido2").toString());
                      }

                      if (param.get("rbSexo") != null) {
                           conectorParametroSesion("rbSexo", param.get("rbSexo").toString());
                      }

                      if (param.get("elementosExtra") != null) {
                           conectorParametroSesion("elementosExtra", param.get("elementosExtra").toString());
                      }

                      if (param.get("elementosP3Marca") != null) {
                           conectorParametroSesion("elementosP3Marca", param.get("elementosP3Marca").toString());
                      }

                      if (param.get("elementosP3MarcaListado2") != null) {
                           conectorParametroSesion("elementosP3MarcaListado2", param.get("elementosP3MarcaListado2").toString());
                      }

                      //traza("??????????????????pestania_1 en cola" + (HashMap) conectorParametroSesion("pestania_1"));
                      conectorParametroSesion("pestania_2", param);

                      break;

                  case 3:
                      traza("llego la case 3");
                      conectorParametroSesion("Pestana3", ptna3);
                      conectorParametroSesion("elementosP3", param.get("elementosP3").toString());

                      conectorParametroSesion("elementosP3Marca", param.get("elementosP3Marca").toString());
                      conectorParametroSesion("elementosP3MarcaListado2", param.get("elementosP3MarcaListado2").toString());

                      break;
                  }
             }
         } catch (Throwable th) {
             //traza("error colaParam");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");
             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +  dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    /*
     * Devuelve una cadena
     */
    private void Pestana2() throws Exception {
         try {
             //falta tomar los parametros de la pestaña anterior
             obtenerConfiguracionCampos();
             traza("paso configuracion campos");

             DTOCodigoCliente dtocClien = new DTOCodigoCliente();
             traza("Paso 1");

             Long pais = UtilidadesSession.getPais(this);
             traza("Paso 2");

             Long idioma = UtilidadesSession.getIdioma(this);
             traza("Paso 3");

             //traza("cliente en la sesion " + conectorParametroSesion("codigoCliente"));
             //si viene de la pantalla 1 tomo el parametro, lo paso al dto y lo pongo en sesion
             //sino, obtengo el de sesion y lo paso al dto
             // String codigo = (String)param.get("codigoCliente");
             //traza("++++++++++++++++++++++++++++++codigo " + codigo);
             String codCliente = (String) conectorParametroSesion("codigoCliente");
             traza("cod cliente " + codCliente);

             if ((codCliente != null) && !(codCliente.equals(""))) {
                  //if((codigoCliente != null) || (!codigoCliente.equals(""))){
                  String codigo = (String) param.get("codigoCliente");

                  if ((codigo != null) && !(codigo.equals(""))) {
                      conectorParametroSesion("codigoCliente", (String) param.get("codigoCliente"));
                  }

                  dtocClien.setCodigoCliente((String) conectorParametroSesion("codigoCliente"));
                  traza("cliente en la sesion " + conectorParametroSesion("codigoCliente"));

                  //conectorParametroSesion("codigoCliente", (String)param.get("codigoCliente"));
             } else {
                  conectorParametroSesion("codigoCliente", (String) param.get("codigoCliente"));
                  dtocClien.setCodigoCliente((String) param.get("codigoCliente"));
                  traza("++++++++++++codigo de cliente en el else " + (String) conectorParametroSesion("codigoCliente"));
             }

             dtocClien.setOidPais(pais);

             dtocClien.setOidIdioma(idioma);
             traza("Paso 6");

             DTOPestanya2Base dtop2Base = new DTOPestanya2Base();
             traza("Paso 7");
             dtop2Base = (DTOPestanya2Base) obtenerDatosSalida("MAEPestanya2Base", "ConectorObjetoCrearBasico", (DTOCodigoCliente) dtocClien);
             traza("Paso 8");

             //traza("Realizamos la logica con el DTOPestanya2");
             traza("*******antes de setear dto");

             if (!dtop2Base.getExiste().booleanValue()) {
                  RecordSet codClie = (RecordSet) dtop2Base.getFormasPago();
                  codClie.removeColumn(1);

                  //traza("Ver DTO " + codClie);
                  Vector colID = codClie.getColumnIdentifiers();
                  DruidaConector dtipo = this.generarConector("DTOSalida.formasPago_ROWSET", codClie, colID);

                  //traza("veremos " + dtipo.getXML());
                  conectorParametroSesion("cbFPago", dtipo);

                  asignar("COMBO", "cbFormaPago", dtipo, "DTOSalida.formasPago_ROWSET");
             } else {
                  if (dtop2Base.getEstaCastigado().booleanValue()) {
                      asignarAtributo("VAR", "MsjValidacion", "valor", "MAE-0006");
                      traza("Saldo del castigado " + dtop2Base.getSaldo().toString());
                      asignarAtributo("VAR", "SaldoCastigado", "valor", dtop2Base.getSaldo().toString());

                      //falta recursar esta LP
                  } else {
                      asignarAtributo("VAR", "MsjValidacion", "valor", "MAE-0007");

                      // conectorAction("LPInsertarClienteBasico");
                      // conectorActionParametro("oidcliente",dtop2Base.getOidCliente().toString());
                      // conectorActionParametro("accion","Validar");
                  }
             }

             traza("*******antes de setear una fecha");

             Date date = new Date(System.currentTimeMillis());
             String s2 = UtilidadesSession.getFormatoFecha(this);
             String s1 = null;
             s2 = s2.replace('m', 'M');

             SimpleDateFormat simpledateformat = new SimpleDateFormat(s2);

             try {
                  s1 = simpledateformat.format(date);
             } catch (Exception exception2) {
             }

             asignarAtributo("LABELC", "lblFechaIngresoActual", "valor", s1.toString());
             conectorParametroSesion("fechaing", s1.toString());

             /* SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");



              Date currentTime_1 = new Date();
              String dateString = formatter.format(currentTime_1);



              //conectorParametroSesion("fecha",(Date) currentTime_1);
              Date fecha = new Date();
              //traza("FECHA*******" + fecha.toString());
              asignarAtributo("LABELC", "lblFechaIngresoActual", "valor",
                   dateString);*/
             //obtengo de la session y aplico en la pagina
             traza("*******antes de setear apeliidos y nombre");

             String apellido1 = (String) conectorParametroSesion("textApellido1");
             String apellido2 = (String) conectorParametroSesion("textApellido2");
             String apellidoCasada = (String) conectorParametroSesion("textApellidoCasada");
             String nombre1 = (String) conectorParametroSesion("textNombre1");
             String nombre2 = (String) conectorParametroSesion("textNombre2");
             String cbTratamiento = (String) conectorParametroSesion("cbTratamiento");
             String rbSexo = (String) conectorParametroSesion("rbSexo");
             String cbFormaPago = (String) conectorParametroSesion("cbFormaPago");
             traza("sexo " + rbSexo);
             traza("cbFormaPago " + cbFormaPago);
             traza("cbTratamiento " + cbTratamiento);
             traza("******************APELLIDO " + apellido1);

             if ((apellido1 != null) && (!apellido1.equals(""))) {
                  traza("esta entrando al if de apellido");
                  asignarAtributo("CTEXTO", "textApellido1", "valor", apellido1);
                  asignarAtributo("CTEXTO", "textApellido2", "valor", apellido2);
                  asignarAtributo("CTEXTO", "textApellidoCasada", "valor", apellidoCasada);
                  asignarAtributo("CTEXTO", "textNombre1", "valor", nombre1);
                  asignarAtributo("CTEXTO", "textNombre2", "valor", nombre2);
                  asignarAtributo("VAR", "h_cbTratamiento", "valor", cbTratamiento);
                  asignarAtributo("VAR", "h_rbSexo", "valor", rbSexo);
                  asignarAtributo("VAR", "h_cbFormaPago", "valor", cbFormaPago);
             }

             String paramIden = (String) conectorParametroSesion("hidListaIdentificacion");
             String paramIdenHidden = (String) conectorParametroLimpia("hidListaIdentificacion", "", true);
             traza("IDENTIFICACION SI ESTA EN SESION " + paramIden);

             if ((paramIden == null) && (paramIden.equals(""))) {
                  traza("SINO ESTA EN SESION " + conectorParametroLimpia("hidListaIdentificacion", "", true));

                  String hidListaIdentificacion = conectorParametroLimpia("hidListaIdentificacion", "", true);
                  conectorParametroSesion("hidListaIdentificacion", hidListaIdentificacion);
             } else {
                  if ((paramIdenHidden != null) && !(paramIdenHidden.equals(""))) {
                      conectorParametroSesion("hidListaIdentificacion", paramIdenHidden);
                  }
             }

             //para volver de p3 a p2
             String paramP3 = (String) conectorParametroSesion("elementosP3");

             if (paramP3.equals("")) {
                  String elementosP3 = conectorParametroLimpia("elementosP3", "", true);
                  conectorParametroSesion("elementosP3", elementosP3);
                  traza("elementos de la pestanya 3 " + elementosP3);
             }

             traza("antes de declarar paramextra");

             String paramExtra = (String) conectorParametroSesion("elementosExtra");
             String paramMarca = (String) conectorParametroSesion("elementosP3Marca");
             String paramMarcaListado2 = (String) conectorParametroSesion("elementosP3MarcaListado2");
             traza("Marca en sesion " + paramMarca);

             String pag = conectorParametroLimpia("envia", "", true);

             if (pag.equals("Pag3")) {
                  String elementosExtra = conectorParametroLimpia("elementosExtra", "", true);
                  conectorParametroSesion("elementosExtra", elementosExtra);
                  traza("entro en pag 3 " + conectorParametroLimpia("elementosP3Marca", "", true));

                  String elementosP3Marca = conectorParametroLimpia("elementosP3Marca", "", true);
                  conectorParametroSesion("elementosP3Marca", elementosP3Marca);

                  traza("entro en pag 3 " + conectorParametroLimpia("elementosP3MarcaListado2", "", true));

                  String elementosP3MarcaListado2 = conectorParametroLimpia("elementosP3MarcaListado2", "", true);
                  conectorParametroSesion("elementosP3MarcaListado2", elementosP3MarcaListado2);
             }

             if ((paramExtra != null) && (paramExtra.equals(""))) {
                  String elementosExtra = conectorParametroLimpia("elementosExtra", "", true);
                  conectorParametroSesion("elementosExtra", elementosExtra);
             }

             if ((paramMarca != null) && (paramMarca.equals(""))) {
                  String elementosP3Marca = conectorParametroLimpia("elementosP3Marca", "", true);
                  conectorParametroSesion("elementosP3Marca", elementosP3Marca);

                  String elementosP3MarcaListado2 = conectorParametroLimpia("elementosP3MarcaListado2", "", true);
                  conectorParametroSesion("elementosP3MarcaListado2", elementosP3MarcaListado2);
             }

             traza("ELEMENTOS DE LA PESTANIA 3 EN SESION " + conectorParametroSesion("elementosP3"));
         } catch (Throwable th) {
             //traza("error en validar");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");
             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +                  dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    private void obtenerConfiguracionCampos() throws Exception {
         try {
             //traza("Creamos los DTOS");
             Vector field = new Vector();
             DTOConfiguracionCamposCliente dtoConfigClie = new DTOConfiguracionCamposCliente();
             DTOConfiguracionCamposCliente dtoSalida = new DTOConfiguracionCamposCliente();

             //traza("Leemos los objetos de la sesion");
             tipoSubt = (HashMap) conectorParametroSesion("tipoSubtipo");

             if (tipoSubt.isEmpty()) {
                  //traza("HasMap vacio");
             }

             UtilidadesSession sesion = new UtilidadesSession();

             //traza("Cargamos los campos");
             DTOCampo campos0 = new DTOCampo();
             DTOCampo campos1 = new DTOCampo();
             DTOCampo campos2 = new DTOCampo();
             DTOCampo campos3 = new DTOCampo();
             DTOCampo campos4 = new DTOCampo();
             DTOCampo campos5 = new DTOCampo();
             DTOCampo campos6 = new DTOCampo();
             DTOCampo campos7 = new DTOCampo();

             campos0.setCodigoCampo("MAECLIEAPELL1");
             campos1.setCodigoCampo("MAECLIEAPELL2");
             campos2.setCodigoCampo("MAECLIEAPELLCA");
             campos3.setCodigoCampo("MAECLIENOM1");
             campos4.setCodigoCampo("MAECLIENOM2");
             campos5.setCodigoCampo("MAECLIETRAT");
             campos6.setCodigoCampo("MAECLIESEXO");
             campos7.setCodigoCampo("MAECLIEFORMPA");

             field.add(campos0);
             field.add(campos1);
             field.add(campos2);
             field.add(campos3);
             field.add(campos4);
             field.add(campos5);
             field.add(campos6);
             field.add(campos7);

             traza("Invocamos al dto Salida");
             dtoConfigClie.setCampos(field);

             traza("333333");
             dtoConfigClie.setTipo(new Long(tipoSubt.get("h_comboTipoCliente_0").toString()));

             traza("44444");
             dtoConfigClie.setSubtipo(new Long(tipoSubt.get("h_comboSubtipoCliente_0").toString()));

             traza("55555");
             dtoConfigClie.setOidPais(sesion.getPais(this));

             traza("66666");
             dtoConfigClie.setOidIdioma(sesion.getIdioma(this));

             traza("77777");
             dtoSalida = (DTOConfiguracionCamposCliente) obtenerDatosSalida("MAEConfiguracionCamposCliente", "ConectorTipoSubtipo", (DTOConfiguracionCamposCliente) dtoConfigClie);

             traza("88888");
             //RecordSet tipo = (RecordSet)dtotsubtipo.getTipos();
             // Vector colID = tipo.getColumnIdentifiers();
             //DruidaConector dtipo = this.generarConector("DTOSalida.tipos_ROWSET",tipo, colID);
             Vector resultado = dtoSalida.getCampos();
             DTOCampo res = new DTOCampo();
             StringBuffer obligatorio = new StringBuffer("");
             for (int i = 0; i < resultado.size(); i++) {
                  res = (DTOCampo) resultado.elementAt(i);
                  traza("DTOCAMPO " + res);

                  switch (i) {
                  case 0:

                      if (res.getObligatorio().booleanValue()) 
                      {
                           if (!obligatorio.toString().equals("") )
                             obligatorio.append(",");

                           obligatorio.append("textApellido1");

                           asignarAtributo("CTEXTO", "textApellido1", "req", "S");
                           asignarAtributoElementoValidacion("textApellido1", "required", "true");
                      }

                      if (!res.getModificable().booleanValue()) {
                           asignarAtributo("VAR", "hModtextApellido1", "valor", "S");
                      }

                      if ((res.getValorDefecto() != null) && !res.getValorDefecto().equals("")) {
                           asignarAtributo("CTEXTO", "textApellido1", "valor", res.getValorDefecto());
                      }

                      break;

                  case 1:

                      if (res.getObligatorio().booleanValue()) {
                           if (!obligatorio.toString().equals("") )
                             obligatorio.append(",");

                           obligatorio.append("textApellido2");
                      
                           asignarAtributo("CTEXTO", "textApellido2", "req", "S");
                           asignarAtributoElementoValidacion("textApellido2", "required", "true");
                      }

                      if (!res.getModificable().booleanValue()) {
                           asignarAtributo("VAR", "hModtextApellido2", "valor", "S");
                      }

                      traza("antes del if de valor defecto");

                      if ((res.getValorDefecto() != null) && !res.getValorDefecto().equals("")) {
                           traza("***********ENTRO EN EL IF DE VALOR DEFECTO APELLIDO 2");
                           traza("VALOR POR DEFECTO " + res.getValorDefecto());
                           asignarAtributo("CTEXTO", "textApellido2", "valor", res.getValorDefecto());
                      }

                      break;

                  case 2:

                      if (res.getObligatorio().booleanValue()) {
                           if (!obligatorio.toString().equals("") )
                             obligatorio.append(",");

                           obligatorio.append("textApellidoCasada");
                           
                           asignarAtributo("CTEXTO", "textApellidoCasada", "req", "S");
                           asignarAtributoElementoValidacion("textApellidoCasada", "required", "true");
                      }

                      if (!res.getModificable().booleanValue()) {
                           asignarAtributo("VAR", "hModtextApellidoCasada", "valor", "S");
                      }

                      traza("antes del if de valor defecto");

                      if ((res.getValorDefecto() != null) && !res.getValorDefecto().equals("")) {
                           traza("***********ENTRO EN EL IF DE VALOR DEFECTO Casada");
                           asignarAtributo("CTEXTO", "textApellidoCasada", "valor", res.getValorDefecto());
                      }

                      break;

                  case 3:

                      if (res.getObligatorio().booleanValue()) {
                           if (!obligatorio.toString().equals("") )
                             obligatorio.append(",");

                           obligatorio.append("textNombre1");                      
                           
                           asignarAtributo("CTEXTO", "textNombre1", "req", "S");
                           asignarAtributoElementoValidacion("textNombre1", "required", "true");
                      }

                      if (!res.getModificable().booleanValue()) {
                           asignarAtributo("VAR", "hModtextNombre1", "valor", "S");
                      }

                      if ((res.getValorDefecto() != null) && !res.getValorDefecto().equals("")) {
                           asignarAtributo("CTEXTO", "textNombre1", "valor", res.getValorDefecto());
                      }

                      break;

                  case 4:

                      if (res.getObligatorio().booleanValue()) {
                           if (!obligatorio.toString().equals("") )
                             obligatorio.append(",");

                           obligatorio.append("textNombre2");                      
                           
                           asignarAtributo("CTEXTO", "textNombre2", "req", "S");
                           asignarAtributoElementoValidacion("textNombre2", "required", "true");
                      }

                      if (!res.getModificable().booleanValue()) {
                           asignarAtributo("VAR", "hModtextNombre2", "valor", "S");
                      }

                      if ((res.getValorDefecto() != null) && !res.getValorDefecto().equals("")) {
                           asignarAtributo("CTEXTO", "textNombre2", "valor", res.getValorDefecto());
                      }

                      break;

                  case 5:

                      if (res.getObligatorio().booleanValue()) {
                           if (!obligatorio.toString().equals("") )
                             obligatorio.append(",");

                           obligatorio.append("cbTratamiento");                      
                      
                           asignarAtributo("COMBO", "cbTratamiento", "req", "S");
                           asignarAtributoElementoValidacion("cbTratamiento", "required", "true");
                      }

                      if (!res.getModificable().booleanValue()) {
                           asignarAtributo("VAR", "hModcbTratamiento", "valor", "S");
                      }

                      if ((res.getValorDefecto() != null) && !res.getValorDefecto().equals("")) {
                           asignarAtributo("VAR", "h_cbTratamiento", "valor", res.getValorDefecto());
                      }

                      break;

                  case 6:

                      if (res.getObligatorio().booleanValue()) {
                           if (!obligatorio.toString().equals("") )
                             obligatorio.append(",");

                           obligatorio.append("rbSexo");                      
                     
                           asignarAtributo("RADIO", "rbSexo", "req", "S");
                           asignarAtributoElementoValidacion("rbSexo", "required", "true");
                      }

                      if (!res.getModificable().booleanValue()) {
                           asignarAtributo("VAR", "hModrbSexo", "valor", "S");
                      }

                      if ((res.getValorDefecto() != null) && !res.getValorDefecto().equals("")) {
                           asignarAtributo("VAR", "h_rbSexo", "valor", res.getValorDefecto());
                      }

                      break;

                  case 7:

                      if (res.getObligatorio().booleanValue()) {
                           if (!obligatorio.toString().equals("") )
                             obligatorio.append(",");

                           obligatorio.append("cbFormaPago");
                           asignarAtributo("COMBO", "cbFormaPago", "req", "S");
                           asignarAtributoElementoValidacion("cbFormaPago", "required", "true");
                      }

                      if (!res.getModificable().booleanValue()) {
                           asignarAtributo("VAR", "hModcbFormaPago", "valor", "S");
                      }

                      if ((res.getValorDefecto() != null) && !res.getValorDefecto().equals("")) {
                           asignarAtributo("VAR", "h_cbFormaPago", "valor", res.getValorDefecto());
                      }

                      break;
                  }
             }
             traza("Obligatorio: " + obligatorio.toString());
             
             this.asignarAtributo("VAR", "obligatorio", "valor", obligatorio.toString() );
         } catch (Throwable th) {
             //traza("error en ConfiguracionCampos");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");
             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +  dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    private void Pestana3() throws Exception {
         try {
             //traza("GuardoElementos de la pantalla anterios");
             conectorParametroSesion("textApellido1", param.get("textApellido1"));
             conectorParametroSesion("textApellido2", param.get("textApellido2"));
             conectorParametroSesion("textApellidoCasada", param.get("textApellidoCasada"));
             conectorParametroSesion("textNombre1", param.get("textNombre1"));
             conectorParametroSesion("textNombre2", param.get("textNombre2"));
             conectorParametroSesion("rbSexo", param.get("rbSexo"));
             conectorParametroSesion("cbTratamiento", param.get("cbTratamiento"));
             conectorParametroSesion("cbFormaPago", param.get("cbFormaPago"));
             conectorParametroSesion("strTratamiento", conectorParametroLimpia("strTratamiento", "", true));

             traza("*******sexo en sesion " + conectorParametroLimpia("rbSexo", "", true));
             traza("*******tratamiento en sesion " + conectorParametroLimpia("cbTratamiento", "", true));
             traza("*******forma de pago " + conectorParametroLimpia("cbFormaPago", "", true));
             traza("**********srt tratamiento en sesion " + conectorParametroSesion("strTratamiento"));
            
             UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();

             //conectorParametroSesion("fecha",param.get("h_fecha"));
             //traza(             "//----------------------- Pestanya 3 --------------------------------");
             DTOOIDs oidsSubtiposDTO = new DTOOIDs();
             UtilidadesSession utls = new UtilidadesSession();
             oidsSubtiposDTO.setOidPais(utls.getPais(this));
             oidsSubtiposDTO.setOidIdioma(utls.getIdioma(this));

             traza("++++++++++++++TIPO SUBTIPO EN SESION " + conectorParametroSesion("tipoSubtipo"));
             tipoSubt = (HashMap) conectorParametroSesion("tipoSubtipo");
             traza("daleee");

             int i = tipoSubt.size() / 4;
             traza("a ver");
             Long[] oidss = new Long[i];

             for (int index = 0; index < i; index++) {
             traza("entro al for");
                  oidss[index] = new Long(tipoSubt.get("h_comboSubtipoCliente_" + index).toString());

                  //new Long[]{ new Long(tipoSubt.get("h_comboSubtipoCliente_" + index).toString() ) } );
             }

             oidsSubtiposDTO.setOids(oidss);
            
             // traza("****ESTO QUEDO EN EL DTO " + oidsSubtiposDTO);
             // oidsSubtiposDTO.setOids(new Long[] { new Long(1) });
             //traza("Llamos a ConectorPestanya3Base MAEPestanya3Base");
             DTOPestanya3Base dtop3Base = (DTOPestanya3Base) obtenerDatosSalida("MAEPestanya3Base", "ConectorPestanya3Base", oidsSubtiposDTO);
             traza("paso 1");
             //traza(dtop3Base);
             // Desconectar para las pruebas
             //DTOPestanya3Base dtop3Base = new DTOPestanya3Base();
             //harcodear(dtop3Base);
             // pais 
             asignarAtributo("VAR", "hidPais", "valor", "" + utls.getPais(this));
             asignarAtributo("VAR", "hidIdioma", "valor", "" + utls.getIdioma(this));
             asignarAtributo("VAR", "primeraVez", "valor", "true");
             traza("paso 2");

             // Direcciones
             RecordSet tiposDir = dtop3Base.getTiposDirecciones();
            // utilidadesBelcorp.agregarRegistroVacio(tiposDir, 0);
             traza("paso 3");

             //traza(tiposDir);
             Vector colID = tiposDir.getColumnIdentifiers();
             DruidaConector dtipo = this.generarConector("DTOSalida.tiposDireccion_ROWSET", tiposDir, colID);
             asignar("COMBO", "comboTipoDireccion", dtipo, "DTOSalida.tiposDireccion_ROWSET");
             traza("paso 4");

             // Marcas
             RecordSet tiposMarc = dtop3Base.getMarcas();
             utilidadesBelcorp.agregarRegistroVacio(tiposMarc, 0);
             colID = tiposMarc.getColumnIdentifiers();
             dtipo = this.generarConector("DTOSalida.marcas_ROWSET", tiposMarc, colID);
             asignar("COMBO", "comboMarca", dtipo, "DTOSalida.marcas_ROWSET");
             traza("paso 5");

             // Canales
             RecordSet tiposCana = dtop3Base.getCanales();
             utilidadesBelcorp.agregarRegistroVacio(tiposCana, 0);
             colID = tiposCana.getColumnIdentifiers();
             dtipo = this.generarConector("DTOSalida.canales_ROWSET", tiposCana, colID);
             asignar("COMBO", "comboCanal", dtipo, "DTOSalida.canales_ROWSET");
             traza("paso 6");
                        

             // TipoClasificacion
             RecordSet tiposClasi = dtop3Base.getTiposClasificacion();
             utilidadesBelcorp.agregarRegistroVacio(tiposClasi, 0);
             colID = tiposClasi.getColumnIdentifiers();
             dtipo = this.generarConector("DTOSalida.tiposClasificacion_ROWSET", tiposClasi, colID);
             this.crearListaLP(colID, tiposClasi.getColumnCount(), "Capa2", "ListaTipoClasi", "14", "200");
             asignar("LISTA", "ListaTipoClasi", dtipo, "DTOSalida.tiposClasificacion_ROWSET");
             //asignar("COMBO", "comboTipoClasificacion", dtipo, "DTOSalida.tiposClasificacion_ROWSET");
             traza("paso 7");

             // Clasificaciones
             RecordSet clasi = dtop3Base.getClasificaciones();
             utilidadesBelcorp.agregarRegistroVacio(clasi, 0);
             colID = clasi.getColumnIdentifiers();
             dtipo = this.generarConector("DTOSalida.clasificaciones_ROWSET", clasi, colID);
             this.crearListaLP(colID, clasi.getColumnCount(), "Capa1", "Lista1", "14", "200");
             asignar("LISTA", "Lista1", dtipo, "DTOSalida.clasificaciones_ROWSET");
             traza("paso 8");

             /*********************************************************/
             /*aca armo la lista para los tipos*/
             traza("antes de armar");
             int f = tipoSubt.size() / 4;
             RecordSet tipo = new RecordSet();
             tipo.addColumn("Tipo");
             tipo.addColumn("descTipo");
             tipo.setRowCount(f);
             Long aux;
             String aux2;
             traza("paso 9");
             
              
             for (int index = 0; index < f; index++) {
                  aux  = new Long(tipoSubt.get("h_comboTipoCliente_" + index).toString());
                  aux2 = tipoSubt.get("h_descTipoCliente_" + index).toString();
                  tipo.setValueAt(aux, index, 0);
                  tipo.setValueAt(aux2, index, 1);
             }

             colID = tipo.getColumnIdentifiers();
             DruidaConector dtipoCli = this.generarConector("DTOSalida.tipo_ROWSET", tipo, colID);
             //this.crearListaLP(colID, tipo.getColumnCount(), "Capa5", "ListaTipo", "14", "200");
             asignar("COMBO", "cbTipoCliente", dtipoCli, "DTOSalida.tipo_ROWSET");
             traza("paso 11");
             

             
             /*********************************************************/

             /*********************************************************/
             /*aca armo la lista para los subtipos*/
             traza("antes de armar");
             int v = tipoSubt.size() / 4;
             RecordSet subtipo = new RecordSet();
             subtipo.addColumn("tipo");
             subtipo.addColumn("Subtipo");
             subtipo.addColumn("descSubtipo");
             subtipo.setRowCount(v);
             Long auxT;
             Long aux3;
             String aux4;
             traza("paso 12");
             
              
             for (int index = 0; index < v; index++) {
             
                  auxT = new Long(tipoSubt.get("h_comboTipoCliente_" + index).toString());
                  aux3 = new Long(tipoSubt.get("h_comboSubtipoCliente_" + index).toString());
                  aux4 = tipoSubt.get("h_descSubtipoCliente_" + index).toString();
                  subtipo.setValueAt(auxT, index, 0);
                  subtipo.setValueAt(aux3, index, 1);
                  subtipo.setValueAt(aux4, index, 2);
             }

             colID = subtipo.getColumnIdentifiers();
             DruidaConector dsubtipo = this.generarConector("DTOSalida.subtipo_ROWSET", subtipo, colID);
             this.crearListaLP(colID, subtipo.getColumnCount(), "Capa5", "ListaSubtipo", "14", "200");
             asignar("LISTA", "ListaSubtipo", dsubtipo, "DTOSalida.subtipo_ROWSET");

             
             /*********************************************************/

             traza("paso 14");
             //Cleal MAE-03         
			 RecordSet tiposVia = dtop3Base.getTipoVia();
			 colID = tiposVia.getColumnIdentifiers();
			 dtipo = this.generarConector("DTOSalida.tipoVia_ROWSET", tiposVia, colID);
 		     asignar("COMBO", "comboTipoVia", dtipo, "DTOSalida.tipoVia_ROWSET");

             // la Pagina lee el hidden usaGeoreferenciador para activar y desactivar campos
             if (dtop3Base.getUsaGeoreferenciador().booleanValue()) {
                  // se oculta el combo tipoViaN
                  // Se muestran nombreViaN y se oculta ViaN      
                  asignarAtributo("VAR", "usaGeoreferenciador", "valor", "true");
                  // Pongo la imagen de obligatorio (*) en los siguientes campos (son el 'Grupo2' de VALIDACION) - Inc. 23061
                  asignarAtributo("COMBO", "cbTipoCliente", "req", "S");
                  asignarAtributo("COMBO", "cbSubtipoCliente", "req", "S");
                  asignarAtributo("COMBO", "comboTipoClasificacion", "req", "S");
                  asignarAtributo("COMBO", "comboClasificacion", "req", "S");
             } else {
                  // Se muestran los combos tipoViaN y se rellenan con el atributo del mismo nombre
                  // Se muestran los campos viaN, que no se cargan ahora sino que Druida transaction segun combo tipoVia
                  asignarAtributo("VAR", "usaGeoreferenciador", "valor", "false");

                  // ahora dejo en pantalla los valores para el combo tipo via
                  // Canales
				  //Cleal MAE-03  
                 // RecordSet tiposVia = dtop3Base.getTipoVia();
                //  utilidadesBelcorp.agregarRegistroVacio(tiposVia, 0);

                  //traza(tiposVia);
                  // Comentado. Por druida transaction, esto deberia conectarse desde la pagina
				  /*Cleal MAE-03  
                  colID = tiposVia.getColumnIdentifiers();
                  dtipo = this.generarConector("DTOSalida.tipoVia_ROWSET", tiposVia, colID);

                  asignar("COMBO", "comboTipoVia", dtipo, "DTOSalida.tipoVia_ROWSET");
				  */
             }

             String paramP3 = (String) conectorParametroSesion("elementosP3");

             if (!paramP3.equals("")) {
                  asignarAtributo("VAR", "elementosP3", "valor", paramP3);
             }

             String paramExtra = (String) conectorParametroSesion("elementosExtra");
             String paramMarca = (String) conectorParametroSesion("elementosP3Marca");
             String paramMarcaListado2 = (String) conectorParametroSesion("elementosP3MarcaListado2");
             traza("parametros en metodo Pestana3 " + paramExtra);

             if ((paramExtra != null) && (!paramExtra.equals(""))) {
                  traza("esta adentro del if");
                  asignarAtributo("VAR", "elementosExtra", "valor", paramExtra);
             }

             if ((paramMarca != null) && (!paramMarca.equals(""))) {
                  traza("esta adentro del if");
                  asignarAtributo("VAR", "elementosP3Marca", "valor", paramMarca);
             }

             if ((paramMarcaListado2 != null) && (!paramMarcaListado2.equals(""))) {
                  traza("esta adentro del if");
                  asignarAtributo("VAR", "elementosP3MarcaListado2", "valor", paramMarcaListado2);
             }

             traza("paso el if");
         } catch (Throwable th) {
             //traza("error en Pestana3");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");
             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +                  dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    private void Guardar() throws Exception {
         try {
             pagina("salidaGenerica");
             traza("Creamos los DTOS");

             String elementosP3 = (String) conectorParametroLimpia("elementosP3", "", true);
             String elementosP3Marca = (String) conectorParametroLimpia("elementosP3Marca", "", true);
             String elementosP3MarcaListado2 = (String) conectorParametroLimpia("elementosP3MarcaListado2", "", true);
             String usaGeoreferenciador = (String) conectorParametroLimpia("usaGeoreferenciador", "", true);
             String territorio = (String) conectorParametroLimpia("hidTerritorio", "", true);

             conectorParametroSesion("elementosP3", elementosP3);
             conectorParametroSesion("elementosP3Marca", elementosP3Marca);
             conectorParametroSesion("elementosP3MarcaListado2", elementosP3MarcaListado2);
             conectorParametroSesion("usaGeoreferenciador", usaGeoreferenciador);
             conectorParametroSesion("hidTerritorio", territorio);

             traza("*******SESION DE ELEMENTOS P3 " + conectorParametroSesion("elementosP3"));
             traza("*******SESION DE ELEMENTOS P3 MARCA " + conectorParametroSesion("elementosP3Marca"));
             traza("*******SESION DE ELEMENTOS P3 LISTADO2 " + conectorParametroSesion("elementosP3MarcaListado2"));
             traza("*******SESION GEO " + conectorParametroSesion("usaGeoreferenciador"));
             traza("*******SESION TERRITORIO " + conectorParametroSesion("hidTerritorio"));

             DTOCrearClienteBasico dtoClieBas = new DTOCrearClienteBasico();
             traza("Cargamos DTOTipoSubtipoCliente");
             dtoClieBas.setTiposSubtipos(tipoSubtipo());
             traza("1");
             dtoClieBas.setDigitoControl((String) conectorParametroSesion("digitoControl_1"));
             traza("2");

             //dtoClieBas.setCodigoCliente((String)conectorParametroSesion("codigoCliente_1"));
             traza("3");
             dtoClieBas.setIdentificaciones(identificaciones());
             traza("4");
             dtoClieBas.setApellido1((String) conectorParametroSesion("textApellido1"));
             traza("5");
             dtoClieBas.setApellido2((String) conectorParametroSesion("textApellido2"));
             traza("6");
             dtoClieBas.setApellidoCasada((String) conectorParametroSesion("textApellidoCasada"));
             traza("7");
             dtoClieBas.setNombre1((String) conectorParametroSesion("textNombre1"));
             traza("8");
             dtoClieBas.setNombre2((String) conectorParametroSesion("textNombre2"));
             traza("9");
             dtoClieBas.setTratamiento((String) conectorParametroSesion("cbTratamiento"));
             traza("10");
             dtoClieBas.setFechaIngreso(new java.sql.Date(new Date().getTime()));
             traza("11");
             traza("el codigo de cliente al guardar es " + conectorParametroSesion("codigoCliente"));
             dtoClieBas.setCodigoCliente((String) conectorParametroSesion("codigoCliente"));
             traza("111");
             dtoClieBas.setOidIdioma(UtilidadesSession.getIdioma(this));
             traza("112");
             dtoClieBas.setOidPais(UtilidadesSession.getPais(this));
             traza("113");
             dtoClieBas.setTratamientoDesc(((String) conectorParametroSesion("strTratamiento")));

             if (conectorParametroSesion("cbFormaPago").equals("")) {
                  traza("114");
                  dtoClieBas.setFormaPago(null);
             } else {
                  traza("115");
                  dtoClieBas.setFormaPago(new Long(conectorParametroSesion("cbFormaPago").toString()));
             }

             traza("12");

             if ((conectorParametroSesion("rbSexo") != null) || !conectorParametroSesion("rbSexo").equals("")) {
                  dtoClieBas.setSexo(conectorParametroSesion("rbSexo").toString());
             } else {
                  dtoClieBas.setSexo("");
             }

             // dtoClieBas.setSexo(param.get((String)"rbSexo").toString());
             //} else {
             //     dtoClieBas.setSexo(conectorParametroSesion("rbSexo").toString());
             //}
             traza("13");
             dtoClieBas.setDirecciones(direccion());
             traza("14");
             dtoClieBas.setMarcas(marca());
             traza("15");
             dtoClieBas.setClasificaciones(clasificaciones());
             traza("16");

             if (param.get("usaGeoreferenciador").equals("true")) {
                  dtoClieBas.setUsaGeoreferenciador(new Boolean(true));
                  traza("17");
             } else {
                  dtoClieBas.setUsaGeoreferenciador(new Boolean(false));
                  traza("18");
             }

             for (int u = 0; u < dtoClieBas.getDirecciones().length; u++) {
                  traza("mmm" + dtoClieBas.getDirecciones()[u]);
             }

             Vector objBussines = new Vector();
             traza("19");

             MareBusinessID id = new MareBusinessID("MAECrearClienteBasico");
             traza("20");
             objBussines.add(dtoClieBas);
             traza("21");
             objBussines.add(id);
             traza("22____");
             traza("//////////////" + dtoClieBas);

             dtoClieBas.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
traza("22 bis 1");
             dtoClieBas.setPrograma("LPInsertarClienteBasico");
traza("22 bis 2");
traza("origen: " + origen);
             DruidaConector dConector = this.conectar("ConectorCrearClienteBasico", objBussines);
             traza("23____");
//             conectorAction("LPInsertarClienteBasico");
  //           conectorActionParametro("accion", "");
             traza("antes de ejecutar el reinicio");
                            
             //asignarAtributo( "VAR", "ejecutar", "valor", "reiniciarCasoDeUso()" );

                           if("otro".equals(origen)){
                             traza("se tiene que cerrar la ventana");
                             String codCliente = (String) conectorParametroSesion("codigoCliente");
         traza("codCliente: " + codCliente);
         Long tipoCliente = dtoClieBas.getTiposSubtipos()[0].getTipo();
         traza("tipoCliente: " + tipoCliente);
         Object object = dConector.objeto("DTOSalida");
                  traza("object: " + object);
                  traza("object.class: " + object.getClass());
         DTOOID dtoid = (DTOOID) object;
         Long oidCliente = dtoid.getOid();
         
         traza("oidCliente: " + oidCliente);
         //pagina("prueba");
         //pagina("contenido_grupo3_cliente_basico_crear");
         String funcion = "cerrarVentana2('" + (oidCliente != null ? oidCliente.toString() : " ") + "', '" +  
             codCliente + "', '" +
             (tipoCliente != null ? tipoCliente.toString() : " ") + "')";
         //asignarAtributo( "VAR", "hidOidCliente", "valor", oidCliente != null ? oidCliente.toString() : " " );
         //asignarAtributo( "VAR", "hidCodigoCliente", "valor", codCliente );
         //asignarAtributo( "VAR", "hidOitTipoCliente", "valor", tipoCliente != null ? tipoCliente.toString() : " ");
         traza("\n ejecuta: " + funcion);
         asignarAtributo( "VAR", "ejecutar", "valor", funcion );         
         //asignarAtributo( "VAR", "hidCerrarVentana", "valor", "true" );
         //asignarAtributo("VAR", "cerrarVentana", "valor", "true");
          
      }else{ 
                             traza("antes de ejecutar el reinicio");             
                             asignarAtributo( "VAR", "ejecutar", "valor", "reiniciarCasoDeUso()" );
      }

             // dtotsubtipo= (DTOTipoSubtipo)obtenerDatosSalida("MAEObtenerTipoSubtipo","ConectorTipoSubtipo",(DTOBelcorp)dtoBelcorp);
             // RecordSet tipo = (RecordSet)dtotsubtipo.getTipos();
             // Vector colID = tipo.getColumnIdentifiers();
         } catch (Throwable th) {
             traza("error en Guardar");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");
             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +                  dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    private DTOIdentificacion[] identificaciones() throws Exception {
         String valores = (String) conectorParametroSesion("hidListaIdentificacion");
         traza("++++++++++vallores " + valores);

         //h_comboTipoDocId_0=11;h_TextoNDoc_0=10;h_TextoConfirmacionDoc_0=10;h_RbDocPrincipal_0=true;h_comboPersonaEmpresa_0=P;
         //h_comboTipoDocId_1=100;h_TextoNDoc_1=20;h_TextoConfirmacionDoc_1=20;h_RbDocPrincipal_1=false;h_comboPersonaEmpresa_1=P;··
         StringTokenizer tokTemp = new StringTokenizer(valores, ";");

         int cantRegistros = 0;

         while (tokTemp.hasMoreTokens()) {
             tokTemp.nextToken();
             cantRegistros++;
         }

         cantRegistros = cantRegistros / 5;

         DTOIdentificacion[] dtoIden = new DTOIdentificacion[cantRegistros];

         StringTokenizer tok = new StringTokenizer(valores, ";");
         traza("Paso -12 idenfificaciones");

         String nombre = new String();
         traza("Paso -13 idenfificaciones");

         String nombreAcotado = new String();
         traza("Paso -14 idenfificaciones");

         String valor = new String();
         int indice = -1;
         traza("Paso -15 idenfificaciones");

         while (tok.hasMoreTokens()) {
             //h_comboTipoDocId_1=100;
             traza("antes del componente valor");

             String componenteValor = tok.nextToken();
             traza("despues del componente valor");

             StringTokenizer tok2 = new StringTokenizer(componenteValor, "=");
             traza("Paso 1 idenfificaciones");

             if (tok2.hasMoreTokens()) {
                  nombre = tok2.nextToken();
                  traza("Paso 2 idenfificaciones");

                  //h_comboTipoDocId_1
             }

             traza("Paso 3 idenfificaciones");

             if (tok2.hasMoreTokens()) {
                  traza("Paso 4 idenfificaciones");

                  valor = tok2.nextToken();

                  //100
             }

             traza("Paso 5 idenfificaciones");

             StringTokenizer tok3 = new StringTokenizer(nombre, "_");
             traza("Paso 6 idenfificaciones");

             if (tok3.hasMoreTokens()) {
                  traza("Paso 7 idenfificaciones");

                  tok3.nextToken();
             }

             traza("Paso 8 idenfificaciones");

             if (tok3.hasMoreTokens()) {
                  traza("Paso 9 idenfificaciones");

                  nombreAcotado = tok3.nextToken();
             }

             traza("Paso 10 idenfificaciones");

             if (tok3.hasMoreTokens()) {
                  traza("Paso 11 idenfificaciones");

                  indice = Integer.parseInt(tok3.nextToken());
             }

             traza("Paso 12 idenfificaciones");

             if (dtoIden[indice] == null) {
                  traza("Paso 13 idenfificaciones");

                  dtoIden[indice] = new DTOIdentificacion();

                  //dtoIden[indice].
             }

             traza("Paso 14 idenfificaciones");

             if (nombreAcotado.equals("comboTipoDocId")) {
                  traza("Paso 15 idenfificaciones");

                  dtoIden[indice].setTipoDocumento(new Long(valor));
             }

             traza("Paso 16 idenfificaciones");

             if (nombreAcotado.equals("TextoNDoc")) {
                  traza("Paso 17 idenfificaciones");

                  dtoIden[indice].setNumeroDocumento(valor);
             }

             traza("Paso 18 idenfificaciones");

             if (nombreAcotado.equals("RbDocPrincipal")) {
                  traza("Paso 19 idenfificaciones");

                  if (valor.equals("true")) {
                      traza("Paso 20 idenfificaciones");

                      dtoIden[indice].setEsPrincipal(new Boolean(true));
                  } else {
                      traza("Paso 21 idenfificaciones");

                      dtoIden[indice].setEsPrincipal(new Boolean(false));
                  }
             }

             traza("Paso 22 idenfificaciones");

             if (nombreAcotado.equals("comboPersonaEmpresa")) {
                  traza("Paso 23 idenfificaciones");

                  dtoIden[indice].setIndPersonaEmpresa(valor);
             }

             traza("Paso 24 idenfificaciones");
             dtoIden[indice].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
             dtoIden[indice].setPrograma(UtilidadesSession.getFuncion(this));

         }

         for (int t = 0; t < dtoIden.length; t++) {
             traza("DTO A ENVIAR " + dtoIden[t]);
         }

         return dtoIden;
    }

    /* String radio = (String) conectorParametroSesion("docPrincipal_1");
             DTOIdentificacion[] dtos = new DTOIdentificacion[i];

             for (int index = 0; index < i; index++) {
                  dtos[index] = new DTOIdentificacion();
                  dtos[index].setTipoDocumento(new Long(va.get("h_comboTipoDocId_" + index).toString()));
                  dtos[index].setNumeroDocumento(va.get("h_TextoNDoc_" + index).toString());

                  if (radio.equals("h_RbDocPrincipal_" + index)) {
                      dtos[index].setEsPrincipal(new Boolean(true));
                  } else {
                      dtos[index].setEsPrincipal(new Boolean(false));
                  }

                  dtos[index].setIndPersonaEmpresa(va.get("h_comboPersonaEmpresa_" + index).toString());

                  //traza("identificacion" + dtos[index]);
             }*/
    private DTOTipoSubtipoCliente[] tipoSubtipo() throws Exception {
         traza("*******TIPO SUBTIPO " + conectorParametroSesion("tipoSubtipo"));
         tipoSubt = (HashMap) conectorParametroSesion("tipoSubtipo");

         int i = tipoSubt.size() / 4;

         //traza(tipoSubt.size() + "");
         //traza("HashMap  " + tipoSubt);
         DTOTipoSubtipoCliente[] dtos = new DTOTipoSubtipoCliente[i];

         for (int o = 0; o < i; o++) {
             dtos[o] = new DTOTipoSubtipoCliente();
         }

         for (int index = 0; index < i; index++) {
             //traza("/////////////////" +                  tipoSubt.get("h_comboTipoCliente_" + index));
             //traza("/////////////////" +                  tipoSubt.get("h_comboSubtipoCliente_" + index));
             dtos[index].setTipo(new Long(tipoSubt.get("h_comboTipoCliente_" + index).toString()));

             //traza("/////////////////1");
             dtos[index].setSubtipo(new Long(tipoSubt.get("h_comboSubtipoCliente_" + index).toString()));

             //traza("/////////////////2");
             if (index == 0) {
                  dtos[index].setPrincipal(new Boolean(true));

                  //traza("/////////////////3");
             } else {
                  dtos[index].setPrincipal(new Boolean(false));

                  //traza("/////////////////3");
             }

             dtos[index].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
             dtos[index].setPrograma(UtilidadesSession.getFuncion(this));

         }

         //traza("subtipocliente");
         for (int t = 0; t < dtos.length; t++) {
             traza("DTO A ENVIAR TIPO SUBTIPO" + dtos[t]);
         }

         return dtos;
    }

    /*
    private DTODireccion[] direccion()throws Exception{
              int i=ptna3.size();
              //traza("size"+ i);
             DTODireccion[] dtos = new DTODireccion[i];
              for(int index=0;index<i;index++){
                                         //traza("Entro al for");
                                         dtos[index].setCodigoPostal(ptna3.get("h_TextoCodPostal_"+index).toString());
                                         //traza("vnhgvj");
                                         //traza(param.get("usaGeoreferenciador").toString());
                                         if(param.get("usaGeoreferenciador").toString().equals("true")){
                                                  dtos[index].setNombreVia(ptna3.get("h_TextoNombreVia_"+index).toString());

                                 }else{
                                         //traza("bbbbbbbbbbbbbbbbbbbb");
                                                  dtos[index].setTipoVia(new Long(ptna3.get("h_comboTipoVia_"+index).toString()));
                                                  //traza("xxxxxxxxxxxxxxxxxxx");
                                                  dtos[index].setNombreVia(ptna3.get("h_comboNombreVia_"+index).toString());
                                 }
                                         dtos[index].setTipoDireccion(new Long(ptna3.get("h_comboTipoDireccion_"+index).toString()));
                                         //traza("111");
                                         dtos[index].setInterior(new Integer(ptna3.get("h_TextoInterior_"+index).toString()));
                                         //traza("112");
                                         dtos[index].setManzana(new Integer(ptna3.get("h_TextoManzana_"+index).toString()));
                                         //traza("113");
                                         dtos[index].setLote(new Integer(ptna3.get("h_TextoLote_"+index).toString()));
                                         //traza("114");
                                         dtos[index].setKilometro(new Integer(ptna3.get("h_TextoKm_"+index).toString()));
                                         //traza("115");
                                         dtos[index].setObservaciones(ptna3.get("h_AreaTxtObservaciones_"+index).toString());
                                         //traza("116");
                                         dtos[index].setUnidadGeografica(new Long(ptna3.get("h_Territorio").toString()));
                                         //traza("117");
                                         if(ptna3.get("h_cbxDireccionPrincipal_"+index).toString()=="true"){
                                                  dtos[index].setEsDireccionPrincipal(new Boolean(true));
                                                  //traza("118");
                                         }else{
                                                  dtos[index].setEsDireccionPrincipal(new Boolean(false));
                                                  //traza("119");
                                         }
                                }
                                return dtos;
     }
     */
    private DTOClienteMarca[] marca() throws Exception {
         String valores = (String) conectorParametroSesion("elementosP3MarcaListado2");
         traza("valores elementosP3MarcaListado2:" + valores);

         if ((valores != null) && !(valores.equals(""))) {
             StringTokenizer tok = new StringTokenizer(valores, ";");
             int cantRegistros = tok.countTokens();

             DTOClienteMarca[] dtoMarca = new DTOClienteMarca[cantRegistros];

             String nombre = new String();
             String nombreAcotado = new String();

             String valor = new String();
             int indice = 0;

             try {
                  while (tok.hasMoreTokens()) {
                      String componenteValor = tok.nextToken();
                      StringTokenizer tok2 = new StringTokenizer(componenteValor, "=");

                      nombre = tok2.nextToken();
                      valor = tok2.nextToken();

                      dtoMarca[indice] = new DTOClienteMarca();
                      dtoMarca[indice].setMarca(new Long(valor));

                      if (indice == 0) {
                           dtoMarca[indice].setPrincipal(new Boolean(true));
                      } else {
                           dtoMarca[indice].setPrincipal(new Boolean(false));
                      }

                      dtoMarca[indice].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
                      dtoMarca[indice].setPrograma(UtilidadesSession.getFuncion(this));


                      indice++;
                  }
             } catch (Exception e) {
                  e.printStackTrace();
                  traza("error de parseo: " + e);
             }

             for (int t = 0; t < dtoMarca.length; t++) {
                  traza("DTO A ENVIAR MARCA" + dtoMarca[t]);
             }

             return dtoMarca;
         } else {
             return null;
         }
    }

    private DTOClasificacionCliente[] clasificaciones() throws Exception {
         String valores = (String) conectorParametroSesion("elementosP3Marca");
         traza("++++++++++vallores " + valores);

         //h_comboTipoDocId_0=11;h_TextoNDoc_0=10;h_TextoConfirmacionDoc_0=10;h_RbDocPrincipal_0=true;h_comboPersonaEmpresa_0=P;
         //h_comboTipoDocId_1=100;h_TextoNDoc_1=20;h_TextoConfirmacionDoc_1=20;h_RbDocPrincipal_1=false;h_comboPersonaEmpresa_1=P;··
         StringTokenizer tokTemp = new StringTokenizer(valores, ";");

         int cantRegistros = 0;

         while (tokTemp.hasMoreTokens()) {
             tokTemp.nextToken();
             cantRegistros++;
         }

         cantRegistros = cantRegistros / 10;

         DTOClasificacionCliente[] dtoClasi = new DTOClasificacionCliente[cantRegistros];

         StringTokenizer tok = new StringTokenizer(valores, ";");
         String nombre = new String();
         String nombreAcotado = new String();

         String valor = new String();
         int indice = -1;

         while (tok.hasMoreTokens()) {
             //h_comboTipoDocId_1=100;
			 valor = "";
             traza("antes del componente valor");

             String componenteValor = tok.nextToken();
             traza("despues del componente valor");

             StringTokenizer tok2 = new StringTokenizer(componenteValor, "=");
			 traza("tok2: "+tok2);
             traza("Paso 1 idenfificaciones");

             if (tok2.hasMoreTokens()) {
                  nombre = tok2.nextToken();
                  traza("Paso 2 marca");

                  //h_comboTipoDocId_1
             }

             traza("Paso 3 marca");

             if (tok2.hasMoreTokens()) {
                  valor = tok2.nextToken();
				  traza("valor: "+valor);
                  //100
             }

             StringTokenizer tok3 = new StringTokenizer(nombre, "_");

             if (tok3.hasMoreTokens()) {
                  tok3.nextToken();
             }

             if (tok3.hasMoreTokens()) {
                  nombreAcotado = tok3.nextToken();
				  traza("nombreAcotado: "+nombreAcotado);
             }

             if (tok3.hasMoreTokens()) {
                  indice = Integer.parseInt(tok3.nextToken());
             }

             if (dtoClasi[indice] == null) {
                  dtoClasi[indice] = new DTOClasificacionCliente();

                  //dtoIden[indice].
             }

             if (nombreAcotado.equals("comboMarcaClasificacion")) {
                  dtoClasi[indice].setMarca(new Long(valor));
             }

             if (indice == 0) {
                  dtoClasi[indice].setPrincipal(new Boolean(true));
             } else {
                  dtoClasi[indice].setPrincipal(new Boolean(false));
             }

             if (nombreAcotado.equals("comboCanal")) {
                  dtoClasi[indice].setCanal(new Long(valor));
             }

             if (nombreAcotado.equals("comboTipoClasificacion") && !valor.equals("")) {
				 traza("comboTipoClasificacion: "+valor);
                  dtoClasi[indice].setTipoClasificacion(new Long(valor));
             }

             if (nombreAcotado.equals("comboClasificacion") && !valor.equals("")) {
				 traza("comboClasificacion: "+valor);
                  dtoClasi[indice].setClasificacion(new Long(valor));
             }

             dtoClasi[indice].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
             dtoClasi[indice].setPrograma(UtilidadesSession.getFuncion(this));

         }

         for (int t = 0; t < dtoClasi.length; t++) {
             traza("DTO A ENVIAR MARCA" + dtoClasi[t]);
         }

         return dtoClasi;

         /*int MAX_CLASI = 30;
         HashMap p3 = (HashMap) conectorParametroSesion("Pestana3");
         //traza("HashMap  " + p3);

         DTOClasificacionCliente[] dtos = new DTOClasificacionCliente[MAX_CLASI];

         /*
           h_comboMarcaClasificacion_0

          h_comboCanal_0
          h_comboTipoClasificacion_
          h_comboClasificacion_0


         for (int index = 0; index < MAX_CLASI; index++) {
             //traza("x1");
             dtos[index] = new DTOClasificacionCliente();
             //traza("x2");

             if (p3.get("h_comboClasificacion_" + index) != null) {
                  //traza("x3");
                  dtos[index].setClasificacion(new Long(
                           p3.get("h_comboClasificacion_" + index).toString()));
                  dtos[index].setTipoClasificacion(new Long(
                           p3.get("h_comboTipoClasificacion_" + index).toString()));
                  dtos[index].setCanal(new Long(p3.get("h_comboCanal_" + index)
                                                      .toString()));

                  if (index == 0) {
                      //traza("x4");
                      dtos[index].setPrincipal(new Boolean(true));
                  } else {
                      //traza("x5");
                      dtos[index].setPrincipal(new Boolean(false));
                  }
             }

             //traza("x6");

             if (p3.get("h_comboMarcaClasificacion_" + index) != null) {
                  //traza("x7");
                  dtos[index].setMarca(new Long(p3.get("h_comboMarcaClasificacion_" +
                                index).toString()));
             }

             //traza("x8");

             if (p3.get("h_comboCanal_" + index) != null) {
                  //traza("x8");
                  dtos[index].setMarca(new Long(p3.get("h_comboCanal_" + index)
                                                      .toString()));
                  //traza("$$$$$$$$$$$$$$$$$$$$$" + dtos[index]);
             }
         }

         return dtos;*/
    }

    private void BackPestania2() throws Exception {
         try {
             if (param.get("envia").toString().equals("Pag3")) {
                  conectorParametroSesion("pestania_3", param);

                  //traza("refresque pestania_3");
             }

             if (param.get("envia").toString().equals("Pag1")) {
                  conectorParametroSesion("pestania_1", param);

                  //traza("refresque pestania_1");
             }

             HashMap ptna2 = (HashMap) conectorParametroSesion("pestania_2");

             //traza("conecte ptna2");
             SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
             Date currentTime_1 = new Date();
             String dateString = formatter.format(currentTime_1);

             /*
             //traza("BackPestania21");
             asignarAtributo("CTEXTO","textApellido1","valor",(String)conectorParametroSesion("textApellido1"));
             //traza("BackPestania22");
             asignarAtributo("CTEXTO","textApellido2","valor",(String)conectorParametroSesion("textApellido1"));
             //traza("BackPestania23");
             asignarAtributo("CTEXTO","textApellidoCasada","valor",(String)conectorParametroSesion("textApellidoCasada"));
             //traza("BackPestania24");
             asignarAtributo("CTEXTO","textNombre1","valor",(String)conectorParametroSesion("textNombre1"));
             //traza("BackPestania25");
             asignarAtributo("CTEXTO","textNombre2","valor",(String)conectorParametroSesion("textNombre2"));
             //traza("BackPestania26");
             asignarAtributo("LABELC","lblFechaIngresoActual","valor",dateString);
             //traza("BackPestania27");
             asignarAtributo("VAR","h_rbSexo","valor",(String)conectorParametroSesion("rbSexo").toString());
             //traza("BackPestania28");
             asignarAtributo("VAR","h_cbFormaPago","valor",(String)conectorParametroSesion("cbFormaPago"));
             //traza("BackPestania29");
             asignarAtributo("VAR","h_cbTratamiento","valor",(String)conectorParametroSesion("cbTratamiento"));
             //traza("BackPestania30");
             asignarAtributo("VAR","backP2","valor","volver");
             //traza("BackPestania31");
             DruidaConector bk=(DruidaConector)conectorParametroSesion("cbFPago");
             asignar("COMBO","cbFormaPago",bk);
             //traza("BackPestania31");
             */

             //traza("BackPestania21");
             if (ptna2.get("textApellido1") != null) {
                  asignarAtributo("CTEXTO", "textApellido1", "valor", ptna2.get("textApellido1").toString());
             }

             //traza("BackPestania22");
             if (ptna2.get("textApellido2") != null) {
                  asignarAtributo("CTEXTO", "textApellido2", "valor", ptna2.get("textApellido2").toString());
             }

             //traza("BackPestania23");
             if (ptna2.get("textApellidoCasada") != null) {
                  asignarAtributo("CTEXTO", "textApellidoCasada", "valor", ptna2.get("textApellidoCasada").toString());
             }

             //traza("BackPestania24");
             if (ptna2.get("textNombre1") != null) {
                  asignarAtributo("CTEXTO", "textNombre1", "valor", ptna2.get("textNombre1").toString());
             }

             //traza("BackPestania25");
             if (ptna2.get("textNombre2") != null) {
                  asignarAtributo("CTEXTO", "textNombre2", "valor", ptna2.get("textNombre2").toString());
             }

             //traza("BackPestania26");
             asignarAtributo("LABELC", "lblFechaIngresoActual", "valor", dateString);

             //traza("BackPestania27");
             if (ptna2.get("rbSexo") != null) {
                  asignarAtributo("VAR", "h_rbSexo", "valor", ptna2.get("rbSexo").toString().toString());
             }

             //traza("BackPestania28");
             if (ptna2.get("cbFormaPago") != null) {
                  asignarAtributo("VAR", "h_cbFormaPago", "valor", ptna2.get("cbFormaPago").toString());
             }

             //traza("BackPestania29");
             if (ptna2.get("cbTratamiento") != null) {
                  asignarAtributo("VAR", "h_cbTratamiento", "valor", ptna2.get("cbTratamiento").toString());
             }

             //traza("BackPestania30");
             if (ptna2.get("textApellido1") != null) {
                  asignarAtributo("VAR", "backP2", "valor", "volver");
             }

             //traza("BackPestania31");
             DruidaConector bk = (DruidaConector) conectorParametroSesion("cbFPago");
             asignar("COMBO", "cbFormaPago", bk);
         } catch (Throwable th) {
             //traza("error en BackPestania2");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);

             //traza(stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this), "");
             String s = th.getMessage();

             //traza(dtoError.getCodigoError() + " - " +                  dtoError.getDescripcionError());
             throw ((Exception) th);
         }
    }

    private DTODireccion[] direccion() throws Exception {
         // int i=ptna3.size();
         ////traza("size"+ i);
         String valores = (String) conectorParametroSesion("elementosP3");
         traza("++++++++++vallores " + valores);

         //h_comboTipoDocId_0=11;h_TextoNDoc_0=10;h_TextoConfirmacionDoc_0=10;h_RbDocPrincipal_0=true;h_comboPersonaEmpresa_0=P;
         //h_comboTipoDocId_1=100;h_TextoNDoc_1=20;h_TextoConfirmacionDoc_1=20;h_RbDocPrincipal_1=false;h_comboPersonaEmpresa_1=P;··
         StringTokenizer tokTemp = new StringTokenizer(valores, ";");

         int cantRegistros = 0;

         while (tokTemp.hasMoreTokens()) {
             tokTemp.nextToken();
             cantRegistros++;
         }

         String georef = (String) conectorParametroSesion("usaGeoreferenciador");

         if (georef.equals("true")) {
             traza("entro en true");
             cantRegistros = cantRegistros / 10;//14 - Cleal - MAE-005
         } else {
             traza("entro en false");
             cantRegistros = cantRegistros / 11;//15 - Cleal - MAE-005
         }
         
         traza("Cant. Registros: " + cantRegistros);

         DTODireccion[] dtoDir = new DTODireccion[cantRegistros];
         StringTokenizer tok = new StringTokenizer(valores, ";");
         String nombre = new String();
         String nombreAcotado = new String();
         String valor = new String();
         int indice = -1;

         while (tok.hasMoreTokens()) 
         {
             // Agregado por ssantana, 13/4/2005
             // Se reinicia el valor de "valor" a '' para evitar que se tome
             // el valor del bucle anterior.
             valor = "";
             // Fin Agregado ssantana, 13/4/2005
             
             //h_comboTipoDocId_1=100;
             String componenteValor = tok.nextToken();
             StringTokenizer tok2 = new StringTokenizer(componenteValor, "=");

             if (tok2.hasMoreTokens()) {
                  nombre = tok2.nextToken();

                  //h_comboTipoDocId_1
             }

             if (tok2.hasMoreTokens()) {
                  valor = tok2.nextToken();

                  //100
             }
             
             traza("Campo: " + nombre);
             traza("Valor: " + valor);

             StringTokenizer tok3 = new StringTokenizer(nombre, "_");

             if (tok3.hasMoreTokens()) {
                  tok3.nextToken();
             }

             if (tok3.hasMoreTokens()) {
                  nombreAcotado = tok3.nextToken();
             }

             if (tok3.hasMoreTokens()) {
                  indice = Integer.parseInt(tok3.nextToken());
             }

             if (dtoDir[indice] == null) {
                  dtoDir[indice] = new DTODireccion();

                  //dtoIden[indice].
                  dtoDir[indice].setOidPais(UtilidadesSession.getPais(this));
             }

             if (nombreAcotado.equals("comboTipoDireccion")) {
                  dtoDir[indice].setTipoDireccion(new Long(valor));
             }
             //Cleal Mae-03
             if (nombreAcotado.equals("comboTipoVia")) {
                dtoDir[indice].setTipoVia(new Long(valor));
              }
             //
             String usaGeoreferenciador = (String) conectorParametroSesion("usaGeoreferenciador");

             if (usaGeoreferenciador.equals("true")) {
                  if (nombreAcotado.equals("TextoNombreVia")) {
                      dtoDir[indice].setNombreVia(valor);
                  }
             } else {
                /* Cleal Mae-03
                  if (nombreAcotado.equals("comboTipoVia")) {
                      dtoDir[indice].setTipoVia(new Long(valor));
                  }
                  */

                  if (nombreAcotado.equals("comboNombreVia")) {
                      dtoDir[indice].setVia(new Long(valor));
                  }

                  if (nombreAcotado.equals("DescripcionVia")) {
                      dtoDir[indice].setNombreVia(valor);
                  }
             }

             if (nombreAcotado.equals("TextoNumeroPrincipal") && !valor.equals("")) {
                  dtoDir[indice].setNumeroPrincipal(valor);
             }

             if (nombreAcotado.equals("TextoCodPostal") && !valor.equals("")) {
                  dtoDir[indice].setCodigoPostal(valor);
             }

             if (nombreAcotado.equals("AreaTxtObservaciones")) {
                  dtoDir[indice].setObservaciones(valor);
             }

             if (nombreAcotado.equals("TerritorioDesc")) {
                  dtoDir[indice].setNombreUnidadGeografica(valor);
             }

             if (nombreAcotado.equals("Territorio") && !valor.equals("")) {
                  dtoDir[indice].setUnidadGeografica(new Long(valor));
             }

             if (nombreAcotado.equals("cbxDireccionPrincipal")) {
                  if (valor.equals("Si")) {
                      dtoDir[indice].setEsDireccionPrincipal(new Boolean(true));
                  } else {
                      dtoDir[indice].setEsDireccionPrincipal(new Boolean(false));
                  }
             }

             dtoDir[indice].setIpCliente(UtilidadesBelcorp.getIPCliente(this));
             dtoDir[indice].setPrograma(UtilidadesSession.getFuncion(this));

         }

         for (int t = 0; t < dtoDir.length; t++) {
             traza("DTO A ENVIAR de DIRECCIONES " + dtoDir[t]);
         }

         return dtoDir;
    }
}

