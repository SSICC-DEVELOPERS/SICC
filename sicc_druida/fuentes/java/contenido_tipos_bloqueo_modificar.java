
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_tipos_bloqueo_modificar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         

      getXML630(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_tipos_caja_modificar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

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
      ((Element)v.get(4)).setAttribute("src","contenido_tipos_bloqueo_modificar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","varPais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","centroDistribucionVD" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(14)).setAttribute("nombre","capa1" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("border","0" );
      ((Element)v.get(15)).setAttribute("cellspacing","0" );
      ((Element)v.get(15)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("align","center" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).setAttribute("width","12" );
      ((Element)v.get(18)).setAttribute("height","12" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","750" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("height","1" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:16   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(28)).setAttribute("class","legend" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(29)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("filas","1" );
      ((Element)v.get(29)).setAttribute("cod","MMGGlobal.legend.searchcriteria.label" );
      ((Element)v.get(29)).setAttribute("id","legend" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","100%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("colspan","4" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","8" );
      ((Element)v.get(33)).setAttribute("height","8" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:34 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(38)).setAttribute("nombre","lblCodTipoBloqueo" );
      ((Element)v.get(38)).setAttribute("alto","13" );
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(38)).setAttribute("id","datosTitle" );
      ((Element)v.get(38)).setAttribute("cod","MaeTipoBloqu.codTipoBloq.label" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","25" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(42)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(42)).setAttribute("alto","13" );
      ((Element)v.get(42)).setAttribute("filas","1" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(42)).setAttribute("id","datosTitle" );
      ((Element)v.get(42)).setAttribute("cod","MaeTipoBloqu.Descripcion.label" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(34)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:34   */

      /* Empieza nodo:45 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(49)).setAttribute("nombre","txtCodTipoBloqueo" );
      ((Element)v.get(49)).setAttribute("id","datosCampos" );
      ((Element)v.get(49)).setAttribute("max","2" );
      ((Element)v.get(49)).setAttribute("tipo","" );
      ((Element)v.get(49)).setAttribute("req","N" );
      ((Element)v.get(49)).setAttribute("size","3" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("ontab","onTab('txtCodTipoBloqueo')" );
      ((Element)v.get(49)).setAttribute("onshtab","onShiftTab('txtCodTipoBloqueo')" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(45)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(53)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(53)).setAttribute("id","datosCampos" );
      ((Element)v.get(53)).setAttribute("max","40" );
      ((Element)v.get(53)).setAttribute("tipo","" );
      ((Element)v.get(53)).setAttribute("req","N" );
      ((Element)v.get(53)).setAttribute("size","50" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("ontab","onTab('txtDescripcion')" );
      ((Element)v.get(53)).setAttribute("onshtab","onShiftTab('txtDescripcion')" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(45)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:45   */

      /* Empieza nodo:56 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("colspan","4" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:30   */
      /* Termina nodo:27   */

      /* Empieza nodo:59 / Elemento padre: 26   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(26)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("table"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(60)).setAttribute("border","0" );
      ((Element)v.get(60)).setAttribute("align","center" );
      ((Element)v.get(60)).setAttribute("cellspacing","0" );
      ((Element)v.get(60)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("class","botonera" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(63)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(63)).setAttribute("ID","botonContenido" );
      ((Element)v.get(63)).setAttribute("tipo","html" );
      ((Element)v.get(63)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(63)).setAttribute("estado","false" );
      ((Element)v.get(63)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:26   */
      /* Termina nodo:23   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:64 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(64)).setAttribute("nombre","capaLista" );
      ((Element)v.get(64)).setAttribute("ancho","100%" );
      ((Element)v.get(64)).setAttribute("alto","330" );
      ((Element)v.get(64)).setAttribute("x","5" );
      ((Element)v.get(64)).setAttribute("y","180" );
      ((Element)v.get(64)).setAttribute("colorf","" );
      ((Element)v.get(64)).setAttribute("borde","0" );
      ((Element)v.get(64)).setAttribute("imagenf","" );
      ((Element)v.get(64)).setAttribute("repeat","" );
      ((Element)v.get(64)).setAttribute("padding","" );
      ((Element)v.get(64)).setAttribute("visibilidad","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(64)).setAttribute("contravsb","" );
      ((Element)v.get(64)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(65)).setAttribute("nombre","listado1" );
      ((Element)v.get(65)).setAttribute("ancho","369" );
      ((Element)v.get(65)).setAttribute("alto","301" );
      ((Element)v.get(65)).setAttribute("x","12" );
      ((Element)v.get(65)).setAttribute("y","0" );
      ((Element)v.get(65)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(65)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(66)).setAttribute("precarga","S" );
      ((Element)v.get(66)).setAttribute("conROver","S" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(67)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(67)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(67)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(67)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 66   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(68)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(68)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(68)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(68)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(66)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(69)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(69)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:66   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(65)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(71)).setAttribute("borde","1" );
      ((Element)v.get(71)).setAttribute("horizDatos","1" );
      ((Element)v.get(71)).setAttribute("horizCabecera","1" );
      ((Element)v.get(71)).setAttribute("vertical","1" );
      ((Element)v.get(71)).setAttribute("horizTitulo","1" );
      ((Element)v.get(71)).setAttribute("horizBase","1" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 70   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(72)).setAttribute("borde","#999999" );
      ((Element)v.get(72)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(72)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(72)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(72)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(72)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(72)).setAttribute("horizBase","#999999" );
      ((Element)v.get(70)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:70   */

      /* Empieza nodo:73 / Elemento padre: 65   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(73)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(73)).setAttribute("alto","22" );
      ((Element)v.get(73)).setAttribute("imgFondo","" );
      ((Element)v.get(73)).setAttribute("cod","00135" );
      ((Element)v.get(73)).setAttribute("ID","datosTitle" );
      ((Element)v.get(65)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 65   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(74)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(74)).setAttribute("alto","22" );
      ((Element)v.get(74)).setAttribute("imgFondo","" );
      ((Element)v.get(65)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 65   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(75)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(75)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(75)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(75)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(75)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(75)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(65)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("ancho","50" );
      ((Element)v.get(76)).setAttribute("minimizable","S" );
      ((Element)v.get(76)).setAttribute("minimizada","N" );
      ((Element)v.get(76)).setAttribute("oculta","S" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("ancho","50" );
      ((Element)v.get(77)).setAttribute("minimizable","S" );
      ((Element)v.get(77)).setAttribute("minimizada","N" );
      ((Element)v.get(75)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("ancho","50" );
      ((Element)v.get(78)).setAttribute("minimizable","S" );
      ((Element)v.get(78)).setAttribute("minimizada","N" );
      ((Element)v.get(75)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("ancho","50" );
      ((Element)v.get(79)).setAttribute("minimizable","S" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(79)).setAttribute("minimizada","N" );
      ((Element)v.get(75)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("ancho","50" );
      ((Element)v.get(80)).setAttribute("minimizable","S" );
      ((Element)v.get(80)).setAttribute("minimizada","N" );
      ((Element)v.get(75)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("ancho","50" );
      ((Element)v.get(81)).setAttribute("minimizable","S" );
      ((Element)v.get(81)).setAttribute("minimizada","N" );
      ((Element)v.get(75)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("ancho","50" );
      ((Element)v.get(82)).setAttribute("minimizable","S" );
      ((Element)v.get(82)).setAttribute("minimizada","N" );
      ((Element)v.get(75)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("ancho","50" );
      ((Element)v.get(83)).setAttribute("minimizable","S" );
      ((Element)v.get(83)).setAttribute("minimizada","N" );
      ((Element)v.get(75)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("ancho","50" );
      ((Element)v.get(84)).setAttribute("minimizable","S" );
      ((Element)v.get(84)).setAttribute("minimizada","N" );
      ((Element)v.get(84)).setAttribute("oculta","S" );
      ((Element)v.get(75)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("ancho","50" );
      ((Element)v.get(85)).setAttribute("minimizable","S" );
      ((Element)v.get(85)).setAttribute("minimizada","N" );
      ((Element)v.get(85)).setAttribute("oculta","S" );
      ((Element)v.get(75)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("ancho","50" );
      ((Element)v.get(86)).setAttribute("minimizable","S" );
      ((Element)v.get(86)).setAttribute("minimizada","N" );
      ((Element)v.get(86)).setAttribute("oculta","S" );
      ((Element)v.get(75)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 75   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("ancho","50" );
      ((Element)v.get(87)).setAttribute("minimizable","S" );
      ((Element)v.get(87)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).setAttribute("oculta","S" );
      ((Element)v.get(75)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:75   */

      /* Empieza nodo:88 / Elemento padre: 65   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(88)).setAttribute("alto","25" );
      ((Element)v.get(88)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(88)).setAttribute("imgFondo","" );
      ((Element)v.get(88)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(65)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("colFondo","" );
      ((Element)v.get(89)).setAttribute("ID","EstCab" );
      ((Element)v.get(89)).setAttribute("cod","" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Elemento padre:89 / Elemento actual: 90   */
      v.add(doc.createTextNode("OID Tipo bloqueo"));
      ((Element)v.get(89)).appendChild((Text)v.get(90));

      /* Termina nodo Texto:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("colFondo","" );
      ((Element)v.get(91)).setAttribute("ID","EstCab" );
      ((Element)v.get(91)).setAttribute("cod","MaeTipoBloqu.codTipoBloq.label" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Elemento padre:91 / Elemento actual: 92   */
      v.add(doc.createTextNode("Cod tipo bloqueo"));
      ((Element)v.get(91)).appendChild((Text)v.get(92));

      /* Termina nodo Texto:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("colFondo","" );
      ((Element)v.get(93)).setAttribute("ID","EstCab" );
      ((Element)v.get(93)).setAttribute("cod","MaeTipoBloqu.Descripcion.label" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Elemento padre:93 / Elemento actual: 94   */
      v.add(doc.createTextNode("Descripcion"));
      ((Element)v.get(93)).appendChild((Text)v.get(94));

      /* Termina nodo Texto:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("colFondo","" );
      ((Element)v.get(95)).setAttribute("ID","EstCab" );
      ((Element)v.get(95)).setAttribute("cod","3217" );
      ((Element)v.get(88)).appendChild((Element)v.get(95));

      /* Elemento padre:95 / Elemento actual: 96   */
      v.add(doc.createTextNode("Ind.bloqueo financiero"));
      ((Element)v.get(95)).appendChild((Text)v.get(96));

      /* Termina nodo Texto:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("colFondo","" );
      ((Element)v.get(97)).setAttribute("ID","EstCab" );
      ((Element)v.get(97)).setAttribute("cod","3218" );
      ((Element)v.get(88)).appendChild((Element)v.get(97));

      /* Elemento padre:97 / Elemento actual: 98   */
      v.add(doc.createTextNode("Forma bloqueo"));
      ((Element)v.get(97)).appendChild((Text)v.get(98));

      /* Termina nodo Texto:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("colFondo","" );
      ((Element)v.get(99)).setAttribute("ID","EstCab" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(99)).setAttribute("cod","3219" );
      ((Element)v.get(88)).appendChild((Element)v.get(99));

      /* Elemento padre:99 / Elemento actual: 100   */
      v.add(doc.createTextNode("Forma desbloqueo"));
      ((Element)v.get(99)).appendChild((Text)v.get(100));

      /* Termina nodo Texto:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("cod","3221" );
      ((Element)v.get(88)).appendChild((Element)v.get(101));

      /* Elemento padre:101 / Elemento actual: 102   */
      v.add(doc.createTextNode("Nivel gravedad"));
      ((Element)v.get(101)).appendChild((Text)v.get(102));

      /* Termina nodo Texto:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(103)).setAttribute("cod","3220" );
      ((Element)v.get(88)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("Motivo rechazo asociado"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("cod","" );
      ((Element)v.get(88)).appendChild((Element)v.get(105));

      /* Elemento padre:105 / Elemento actual: 106   */
      v.add(doc.createTextNode("OID forma bloqueo"));
      ((Element)v.get(105)).appendChild((Text)v.get(106));

      /* Termina nodo Texto:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("colFondo","" );
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(107)).setAttribute("cod","" );
      ((Element)v.get(88)).appendChild((Element)v.get(107));

      /* Elemento padre:107 / Elemento actual: 108   */
      v.add(doc.createTextNode("OID forma desbloqueo"));
      ((Element)v.get(107)).appendChild((Text)v.get(108));

      /* Termina nodo Texto:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("cod","" );
      ((Element)v.get(88)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode("OID motivo rechazo"));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","" );
      ((Element)v.get(88)).appendChild((Element)v.get(111));

      /* Elemento padre:111 / Elemento actual: 112   */
      v.add(doc.createTextNode("ind_ult_pagina"));
      ((Element)v.get(111)).appendChild((Text)v.get(112));

      /* Termina nodo Texto:112   */
      /* Termina nodo:111   */
      /* Termina nodo:88   */

      /* Empieza nodo:113 / Elemento padre: 65   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(113)).setAttribute("alto","22" );
      ((Element)v.get(113)).setAttribute("accion","" );
      ((Element)v.get(113)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(113)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(113)).setAttribute("maxSel","-1" );
      ((Element)v.get(113)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(113)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(113)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(113)).setAttribute("onLoad","" );
      ((Element)v.get(113)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(65)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("tipo","texto" );
      ((Element)v.get(114)).setAttribute("ID","EstDat" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat2" );
      ((Element)v.get(113)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat" );
      ((Element)v.get(113)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","texto" );
      ((Element)v.get(117)).setAttribute("ID","EstDat2" );
      ((Element)v.get(113)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("tipo","texto" );
      ((Element)v.get(118)).setAttribute("ID","EstDat" );
      ((Element)v.get(113)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("tipo","texto" );
      ((Element)v.get(119)).setAttribute("ID","EstDat2" );
      ((Element)v.get(113)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("tipo","texto" );
      ((Element)v.get(120)).setAttribute("ID","EstDat" );
      ((Element)v.get(113)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("tipo","texto" );
      ((Element)v.get(121)).setAttribute("ID","EstDat2" );
      ((Element)v.get(113)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 113   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat" );
      ((Element)v.get(113)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat2" );
      ((Element)v.get(113)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","texto" );
      ((Element)v.get(124)).setAttribute("ID","EstDat" );
      ((Element)v.get(113)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat2" );
      ((Element)v.get(113)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:113   */

      /* Empieza nodo:126 / Elemento padre: 65   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(65)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 65   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(127)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(127)).setAttribute("ancho","679" );
      ((Element)v.get(127)).setAttribute("sep","$" );
      ((Element)v.get(127)).setAttribute("x","12" );
      ((Element)v.get(127)).setAttribute("class","botonera" );
      ((Element)v.get(127)).setAttribute("y","294" );
      ((Element)v.get(127)).setAttribute("control","|" );
      ((Element)v.get(127)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(127)).setAttribute("rowset","" );
      ((Element)v.get(127)).setAttribute("cargainicial","N" );
      ((Element)v.get(127)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(65)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(128)).setAttribute("nombre","ret1" );
      ((Element)v.get(128)).setAttribute("x","37" );
      ((Element)v.get(128)).setAttribute("y","282" );
      ((Element)v.get(128)).setAttribute("ID","botonContenido" );
      ((Element)v.get(128)).setAttribute("img","retroceder_on" );
      ((Element)v.get(128)).setAttribute("tipo","0" );
      ((Element)v.get(128)).setAttribute("estado","false" );
      ((Element)v.get(128)).setAttribute("alt","" );
      ((Element)v.get(128)).setAttribute("codigo","" );
      ((Element)v.get(128)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 127   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(129)).setAttribute("nombre","ava1" );
      ((Element)v.get(129)).setAttribute("x","52" );
      ((Element)v.get(129)).setAttribute("y","282" );
      ((Element)v.get(129)).setAttribute("ID","botonContenido" );
      ((Element)v.get(129)).setAttribute("img","avanzar_on" );
      ((Element)v.get(129)).setAttribute("tipo","0" );
      ((Element)v.get(129)).setAttribute("estado","false" );
      ((Element)v.get(129)).setAttribute("alt","" );
      ((Element)v.get(129)).setAttribute("codigo","" );
      ((Element)v.get(129)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(127)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:127   */
      /* Termina nodo:65   */

      /* Empieza nodo:130 / Elemento padre: 64   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(130)).setAttribute("nombre","primera1" );
      ((Element)v.get(130)).setAttribute("x","20" );
      ((Element)v.get(130)).setAttribute("y","282" );
      ((Element)v.get(130)).setAttribute("ID","botonContenido" );
      ((Element)v.get(130)).setAttribute("img","primera_on" );
      ((Element)v.get(130)).setAttribute("tipo","-2" );
      ((Element)v.get(130)).setAttribute("estado","false" );
      ((Element)v.get(130)).setAttribute("alt","" );
      ((Element)v.get(130)).setAttribute("codigo","" );
      ((Element)v.get(130)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(64)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 64   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(131)).setAttribute("nombre","separa" );
      ((Element)v.get(131)).setAttribute("x","59" );
      ((Element)v.get(131)).setAttribute("y","278" );
      ((Element)v.get(131)).setAttribute("ID","botonContenido" );
      ((Element)v.get(131)).setAttribute("img","separa_base" );
      ((Element)v.get(131)).setAttribute("tipo","0" );
      ((Element)v.get(131)).setAttribute("estado","false" );
      ((Element)v.get(131)).setAttribute("alt","" );
      ((Element)v.get(131)).setAttribute("codigo","" );
      ((Element)v.get(131)).setAttribute("accion","" );
      ((Element)v.get(64)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 64   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(132)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(132)).setAttribute("x","80" );
      ((Element)v.get(132)).setAttribute("y","279" );
      ((Element)v.get(132)).setAttribute("ID","botonContenido" );
      ((Element)v.get(132)).setAttribute("tipo","html" );
      ((Element)v.get(132)).setAttribute("estado","false" );
      ((Element)v.get(132)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(132)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(64)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 64   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(133)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(133)).setAttribute("x","80" );
      ((Element)v.get(133)).setAttribute("y","279" );
      ((Element)v.get(133)).setAttribute("ID","botonContenido" );
      ((Element)v.get(133)).setAttribute("tipo","html" );
      ((Element)v.get(133)).setAttribute("estado","false" );
      ((Element)v.get(133)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(133)).setAttribute("accion","onClickModificar();" );
      ((Element)v.get(64)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:64   */
      /* Termina nodo:5   */


   }

}
