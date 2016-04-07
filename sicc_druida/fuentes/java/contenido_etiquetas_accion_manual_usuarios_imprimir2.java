
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_etiquetas_accion_manual_usuarios_imprimir2  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_etiquetas_accion_manual_usuarios_imprimir2" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_etiquetas_accion_manual_usuarios_imprimir2.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","formulario" );
      ((Element)v.get(8)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","varPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(15)).setAttribute("valor","insertar" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","ejecutar" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","ejecutarError" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hOidsAnular" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(20)).setAttribute("nombre","capa1" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","750" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(34)).setAttribute("class","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblDatosInicial" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("cod","00193" );
      ((Element)v.get(35)).setAttribute("id","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("colspan","4" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblConsolidado" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","1419" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:40   */

      /* Empieza nodo:47 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(51)).setAttribute("nombre","txtConsolidado" );
      ((Element)v.get(51)).setAttribute("id","datosCampos" );
      ((Element)v.get(51)).setAttribute("max","10" );
      ((Element)v.get(51)).setAttribute("tipo","" );
      ((Element)v.get(51)).setAttribute("onchange","" );
      ((Element)v.get(51)).setAttribute("req","N" );
      ((Element)v.get(51)).setAttribute("size","15" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("validacion","" );
      ((Element)v.get(51)).setAttribute("ontab","onTab('txtConsolidado')" );
      ((Element)v.get(51)).setAttribute("onshtab","onShiftTab('txtConsolidado')" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:47   */

      /* Empieza nodo:54 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("colspan","4" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */

      /* Empieza nodo:57 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("class","botonera" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(61)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(61)).setAttribute("ID","botonContenido" );
      ((Element)v.get(61)).setAttribute("tipo","html" );
      ((Element)v.get(61)).setAttribute("accion","onClickBtnAceptar()" );
      ((Element)v.get(61)).setAttribute("estado","false" );
      ((Element)v.get(61)).setAttribute("cod","MMGGlobal.localization.bindbutton.label" );
      ((Element)v.get(61)).setAttribute("ontab","onTab('btnAceptar')" );
      ((Element)v.get(61)).setAttribute("onshtab","onShiftTab('btnAceptar')" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:32   */
      /* Termina nodo:29   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:62 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(62)).setAttribute("nombre","capaLista" );
      ((Element)v.get(62)).setAttribute("ancho","100%" );
      ((Element)v.get(62)).setAttribute("alto","330" );
      ((Element)v.get(62)).setAttribute("x","5" );
      ((Element)v.get(62)).setAttribute("y","120" );
      ((Element)v.get(62)).setAttribute("colorf","" );
      ((Element)v.get(62)).setAttribute("borde","0" );
      ((Element)v.get(62)).setAttribute("imagenf","" );
      ((Element)v.get(62)).setAttribute("repeat","" );
      ((Element)v.get(62)).setAttribute("padding","" );
      ((Element)v.get(62)).setAttribute("visibilidad","" );
      ((Element)v.get(62)).setAttribute("contravsb","" );
      ((Element)v.get(62)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(63)).setAttribute("nombre","listado1" );
      ((Element)v.get(63)).setAttribute("ancho","369" );
      ((Element)v.get(63)).setAttribute("alto","301" );
      ((Element)v.get(63)).setAttribute("x","12" );
      ((Element)v.get(63)).setAttribute("y","0" );
      ((Element)v.get(63)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(63)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(64)).setAttribute("precarga","S" );
      ((Element)v.get(64)).setAttribute("conROver","S" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(65)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(65)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(65)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(65)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 64   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(66)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(66)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(66)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(66)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(67)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(67)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:64   */

      /* Empieza nodo:68 / Elemento padre: 63   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(63)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(69)).setAttribute("borde","1" );
      ((Element)v.get(69)).setAttribute("horizDatos","1" );
      ((Element)v.get(69)).setAttribute("horizCabecera","1" );
      ((Element)v.get(69)).setAttribute("vertical","1" );
      ((Element)v.get(69)).setAttribute("horizTitulo","1" );
      ((Element)v.get(69)).setAttribute("horizBase","1" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 68   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(70)).setAttribute("borde","#999999" );
      ((Element)v.get(70)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(70)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(70)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(70)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(70)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(70)).setAttribute("horizBase","#999999" );
      ((Element)v.get(68)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:68   */

      /* Empieza nodo:71 / Elemento padre: 63   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(71)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(71)).setAttribute("alto","22" );
      ((Element)v.get(71)).setAttribute("imgFondo","" );
      ((Element)v.get(71)).setAttribute("cod","00135" );
      ((Element)v.get(71)).setAttribute("ID","datosTitle" );
      ((Element)v.get(63)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 63   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(72)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(72)).setAttribute("alto","22" );
      ((Element)v.get(72)).setAttribute("imgFondo","" );
      ((Element)v.get(63)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 63   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(73)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(73)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(73)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(73)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(73)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(73)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(63)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("ancho","50" );
      ((Element)v.get(74)).setAttribute("minimizable","S" );
      ((Element)v.get(74)).setAttribute("minimizada","N" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("ancho","50" );
      ((Element)v.get(75)).setAttribute("minimizable","S" );
      ((Element)v.get(75)).setAttribute("minimizada","N" );
      ((Element)v.get(73)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("ancho","50" );
      ((Element)v.get(76)).setAttribute("minimizable","S" );
      ((Element)v.get(76)).setAttribute("minimizada","N" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("ancho","50" );
      ((Element)v.get(77)).setAttribute("minimizable","S" );
      ((Element)v.get(77)).setAttribute("minimizada","N" );
      ((Element)v.get(73)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("ancho","50" );
      ((Element)v.get(78)).setAttribute("minimizable","S" );
      ((Element)v.get(78)).setAttribute("minimizada","N" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("ancho","50" );
      ((Element)v.get(79)).setAttribute("minimizable","S" );
      ((Element)v.get(79)).setAttribute("minimizada","N" );
      ((Element)v.get(73)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:73   */

      /* Empieza nodo:80 / Elemento padre: 63   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(80)).setAttribute("alto","25" );
      ((Element)v.get(80)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(80)).setAttribute("imgFondo","" );
      ((Element)v.get(80)).setAttribute("colFondo","#CCCCCC" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(63)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("colFondo","" );
      ((Element)v.get(81)).setAttribute("ID","EstCab" );
      ((Element)v.get(81)).setAttribute("cod","ComConge.clieOidClie.label" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Elemento padre:81 / Elemento actual: 82   */
      v.add(doc.createTextNode("Código Cliente"));
      ((Element)v.get(81)).appendChild((Text)v.get(82));

      /* Termina nodo Texto:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("colFondo","" );
      ((Element)v.get(83)).setAttribute("ID","EstCab" );
      ((Element)v.get(83)).setAttribute("cod","FacAsignImpre.canaOidCana.label" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Elemento padre:83 / Elemento actual: 84   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(83)).appendChild((Text)v.get(84));

      /* Termina nodo Texto:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("colFondo","" );
      ((Element)v.get(85)).setAttribute("ID","EstCab" );
      ((Element)v.get(85)).setAttribute("cod","FacAsignImpre.acceOidAcce.label" );
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Elemento padre:85 / Elemento actual: 86   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(85)).appendChild((Text)v.get(86));

      /* Termina nodo Texto:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("colFondo","" );
      ((Element)v.get(87)).setAttribute("ID","EstCab" );
      ((Element)v.get(87)).setAttribute("cod","FacAsignImpre.sbacOidSbac.label" );
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Elemento padre:87 / Elemento actual: 88   */
      v.add(doc.createTextNode("SubAcceso"));
      ((Element)v.get(87)).appendChild((Text)v.get(88));

      /* Termina nodo Texto:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("colFondo","" );
      ((Element)v.get(89)).setAttribute("ID","EstCab" );
      ((Element)v.get(89)).setAttribute("cod","1419" );
      ((Element)v.get(80)).appendChild((Element)v.get(89));

      /* Elemento padre:89 / Elemento actual: 90   */
      v.add(doc.createTextNode("N° Consolidado"));
      ((Element)v.get(89)).appendChild((Text)v.get(90));

      /* Termina nodo Texto:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("colFondo","" );
      ((Element)v.get(91)).setAttribute("ID","EstCab" );
      ((Element)v.get(91)).setAttribute("cod","2102" );
      ((Element)v.get(80)).appendChild((Element)v.get(91));

      /* Elemento padre:91 / Elemento actual: 92   */
      v.add(doc.createTextNode("N° Total cajas"));
      ((Element)v.get(91)).appendChild((Text)v.get(92));

      /* Termina nodo Texto:92   */
      /* Termina nodo:91   */
      /* Termina nodo:80   */

      /* Empieza nodo:93 / Elemento padre: 63   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(93)).setAttribute("alto","22" );
      ((Element)v.get(93)).setAttribute("accion","" );
      ((Element)v.get(93)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(93)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(93)).setAttribute("maxSel","-1" );
      ((Element)v.get(93)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(93)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(93)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(93)).setAttribute("onLoad","" );
      ((Element)v.get(93)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(63)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("tipo","texto" );
      ((Element)v.get(94)).setAttribute("ID","EstDat" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("tipo","texto" );
      ((Element)v.get(95)).setAttribute("ID","EstDat" );
      ((Element)v.get(93)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("tipo","texto" );
      ((Element)v.get(96)).setAttribute("ID","EstDat" );
      ((Element)v.get(93)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("tipo","texto" );
      ((Element)v.get(97)).setAttribute("ID","EstDat" );
      ((Element)v.get(93)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("tipo","texto" );
      ((Element)v.get(98)).setAttribute("ID","EstDat" );
      ((Element)v.get(93)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 93   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("tipo","texto" );
      ((Element)v.get(99)).setAttribute("ID","EstDat" );
      ((Element)v.get(93)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:93   */

      /* Empieza nodo:100 / Elemento padre: 63   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(63)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 63   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(101)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(101)).setAttribute("ancho","624" );
      ((Element)v.get(101)).setAttribute("sep","$" );
      ((Element)v.get(101)).setAttribute("x","12" );
      ((Element)v.get(101)).setAttribute("class","botonera" );
      ((Element)v.get(101)).setAttribute("y","277" );
      ((Element)v.get(101)).setAttribute("control","|" );
      ((Element)v.get(101)).setAttribute("conector","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(101)).setAttribute("rowset","" );
      ((Element)v.get(101)).setAttribute("cargainicial","N" );
      ((Element)v.get(101)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(63)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(102)).setAttribute("nombre","ret1" );
      ((Element)v.get(102)).setAttribute("x","37" );
      ((Element)v.get(102)).setAttribute("y","281" );
      ((Element)v.get(102)).setAttribute("ID","botonContenido" );
      ((Element)v.get(102)).setAttribute("img","retroceder_on" );
      ((Element)v.get(102)).setAttribute("tipo","0" );
      ((Element)v.get(102)).setAttribute("estado","false" );
      ((Element)v.get(102)).setAttribute("alt","" );
      ((Element)v.get(102)).setAttribute("codigo","" );
      ((Element)v.get(102)).setAttribute("accion","" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 101   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(103)).setAttribute("nombre","ava1" );
      ((Element)v.get(103)).setAttribute("x","52" );
      ((Element)v.get(103)).setAttribute("y","281" );
      ((Element)v.get(103)).setAttribute("ID","botonContenido" );
      ((Element)v.get(103)).setAttribute("img","avanzar_on" );
      ((Element)v.get(103)).setAttribute("tipo","0" );
      ((Element)v.get(103)).setAttribute("estado","false" );
      ((Element)v.get(103)).setAttribute("alt","" );
      ((Element)v.get(103)).setAttribute("codigo","" );
      ((Element)v.get(103)).setAttribute("accion","" );
      ((Element)v.get(101)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:101   */
      /* Termina nodo:63   */

      /* Empieza nodo:104 / Elemento padre: 62   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(104)).setAttribute("nombre","primera1" );
      ((Element)v.get(104)).setAttribute("x","20" );
      ((Element)v.get(104)).setAttribute("y","281" );
      ((Element)v.get(104)).setAttribute("ID","botonContenido" );
      ((Element)v.get(104)).setAttribute("img","primera_on" );
      ((Element)v.get(104)).setAttribute("tipo","-2" );
      ((Element)v.get(104)).setAttribute("estado","false" );
      ((Element)v.get(104)).setAttribute("alt","" );
      ((Element)v.get(104)).setAttribute("codigo","" );
      ((Element)v.get(104)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(62)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 62   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(105)).setAttribute("nombre","separa" );
      ((Element)v.get(105)).setAttribute("x","59" );
      ((Element)v.get(105)).setAttribute("y","281" );
      ((Element)v.get(105)).setAttribute("ID","botonContenido" );
      ((Element)v.get(105)).setAttribute("img","separa_base" );
      ((Element)v.get(105)).setAttribute("tipo","0" );
      ((Element)v.get(105)).setAttribute("estado","false" );
      ((Element)v.get(105)).setAttribute("alt","" );
      ((Element)v.get(105)).setAttribute("codigo","" );
      ((Element)v.get(105)).setAttribute("accion","" );
      ((Element)v.get(62)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 62   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(106)).setAttribute("nombre","btnAnular" );
      ((Element)v.get(106)).setAttribute("x","20" );
      ((Element)v.get(106)).setAttribute("y","279" );
      ((Element)v.get(106)).setAttribute("ID","botonContenido" );
      ((Element)v.get(106)).setAttribute("tipo","html" );
      ((Element)v.get(106)).setAttribute("estado","false" );
      ((Element)v.get(106)).setAttribute("cod","1598" );
      ((Element)v.get(106)).setAttribute("accion","onClickBtnAnular()" );
      ((Element)v.get(106)).setAttribute("ontab","onTab('btnAnular')" );
      ((Element)v.get(106)).setAttribute("onshtab","onShiftTab('btnAnular')" );
      ((Element)v.get(62)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:62   */
      /* Termina nodo:8   */


   }

}
