
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_configuracion_centro_distribucion_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_configuracion_centro_distribucion_consultar" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r   \r			function onLoadPag(){   \r			}\r   \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(6)).setAttribute("nombre","capa1" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(7)).setAttribute("width","100%" );
      ((Element)v.get(7)).setAttribute("border","0" );
      ((Element)v.get(7)).setAttribute("cellspacing","0" );
      ((Element)v.get(7)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).setAttribute("width","12" );
      ((Element)v.get(9)).setAttribute("align","center" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(10)).setAttribute("src","b.gif" );
      ((Element)v.get(10)).setAttribute("width","12" );
      ((Element)v.get(10)).setAttribute("height","12" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:9   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).setAttribute("width","750" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","b.gif" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(14)).setAttribute("src","b.gif" );
      ((Element)v.get(14)).setAttribute("width","12" );
      ((Element)v.get(14)).setAttribute("height","1" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */
      /* Termina nodo:8   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(17)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(20)).setAttribute("class","legend" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(21)).setAttribute("nombre","lblDatosPrincipales" );
      ((Element)v.get(21)).setAttribute("alto","13" );
      ((Element)v.get(21)).setAttribute("filas","1" );
      ((Element)v.get(21)).setAttribute("cod","ApeConfCentroDistribucion.legend.label" );
      ((Element)v.get(21)).setAttribute("id","legend" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("colspan","4" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","8" );
      ((Element)v.get(25)).setAttribute("height","8" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:26 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","8" );
      ((Element)v.get(28)).setAttribute("height","8" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(30)).setAttribute("nombre","lblCentroDistribucion" );
      ((Element)v.get(30)).setAttribute("alto","13" );
      ((Element)v.get(30)).setAttribute("filas","1" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(30)).setAttribute("id","datosTitle" );
      ((Element)v.get(30)).setAttribute("cod","ApeConfCentroDistribucion.centroDistrib.label" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","25" );
      ((Element)v.get(32)).setAttribute("height","8" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","datosTitle" );
      ((Element)v.get(34)).setAttribute("cod","ApeConfCentroDistribucion.descripcion.label" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(26)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:26   */

      /* Empieza nodo:37 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(41)).setAttribute("nombre","cbCentroDistribucion" );
      ((Element)v.get(41)).setAttribute("id","datosCampos" );
      ((Element)v.get(41)).setAttribute("size","1" );
      ((Element)v.get(41)).setAttribute("multiple","N" );
      ((Element)v.get(41)).setAttribute("req","N" );
      ((Element)v.get(41)).setAttribute("valorinicial","" );
      ((Element)v.get(41)).setAttribute("textoinicial","" );
      ((Element)v.get(41)).setAttribute("onchange","" );
      ((Element)v.get(41)).setAttribute("ontab","" );
      ((Element)v.get(41)).setAttribute("onshtab","" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","25" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(37)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(46)).setAttribute("nombre","cbDescripcion" );
      ((Element)v.get(46)).setAttribute("id","datosCampos" );
      ((Element)v.get(46)).setAttribute("size","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("multiple","N" );
      ((Element)v.get(46)).setAttribute("req","N" );
      ((Element)v.get(46)).setAttribute("valorinicial","" );
      ((Element)v.get(46)).setAttribute("textoinicial","" );
      ((Element)v.get(46)).setAttribute("onchange","" );
      ((Element)v.get(46)).setAttribute("ontab","" );
      ((Element)v.get(46)).setAttribute("onshtab","" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:48 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(37)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:37   */

      /* Empieza nodo:50 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("colspan","4" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:22   */
      /* Termina nodo:19   */

      /* Empieza nodo:53 / Elemento padre: 18   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(18)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("class","botonera" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(57)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(57)).setAttribute("ID","botonContenido" );
      ((Element)v.get(57)).setAttribute("tipo","html" );
      ((Element)v.get(57)).setAttribute("accion","" );
      ((Element)v.get(57)).setAttribute("estado","false" );
      ((Element)v.get(57)).setAttribute("cod","1" );
      ((Element)v.get(57)).setAttribute("ontab","" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:18   */

      /* Empieza nodo:58 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","12" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:15   */

      /* Empieza nodo:60 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(62)).setAttribute("height","12" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","756" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","12" );
      ((Element)v.get(60)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(66)).setAttribute("height","1" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:60   */
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:67 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(67)).setAttribute("nombre","capaLista" );
      ((Element)v.get(67)).setAttribute("ancho","100%" );
      ((Element)v.get(67)).setAttribute("alto","330" );
      ((Element)v.get(67)).setAttribute("x","7" );
      ((Element)v.get(67)).setAttribute("y","200" );
      ((Element)v.get(67)).setAttribute("colorf","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("borde","0" );
      ((Element)v.get(67)).setAttribute("imagenf","" );
      ((Element)v.get(67)).setAttribute("repeat","" );
      ((Element)v.get(67)).setAttribute("padding","" );
      ((Element)v.get(67)).setAttribute("visibilidad","" );
      ((Element)v.get(67)).setAttribute("contravsb","" );
      ((Element)v.get(67)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(68)).setAttribute("nombre","listado1" );
      ((Element)v.get(68)).setAttribute("ancho","369" );
      ((Element)v.get(68)).setAttribute("alto","301" );
      ((Element)v.get(68)).setAttribute("x","12" );
      ((Element)v.get(68)).setAttribute("y","0" );
      ((Element)v.get(68)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(68)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(69)).setAttribute("precarga","S" );
      ((Element)v.get(69)).setAttribute("conROver","S" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(70)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(70)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(70)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(70)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 69   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(71)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(71)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(71)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(71)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(72)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(72)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:69   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(74)).setAttribute("borde","1" );
      ((Element)v.get(74)).setAttribute("horizDatos","1" );
      ((Element)v.get(74)).setAttribute("horizCabecera","1" );
      ((Element)v.get(74)).setAttribute("vertical","1" );
      ((Element)v.get(74)).setAttribute("horizTitulo","1" );
      ((Element)v.get(74)).setAttribute("horizBase","1" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 73   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(75)).setAttribute("borde","#999999" );
      ((Element)v.get(75)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(75)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(75)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(75)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(75)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(75)).setAttribute("horizBase","#999999" );
      ((Element)v.get(73)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 68   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(76)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(76)).setAttribute("alto","22" );
      ((Element)v.get(76)).setAttribute("imgFondo","" );
      ((Element)v.get(76)).setAttribute("cod","00135" );
      ((Element)v.get(76)).setAttribute("ID","datosTitle" );
      ((Element)v.get(68)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(77)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(77)).setAttribute("alto","22" );
      ((Element)v.get(77)).setAttribute("imgFondo","" );
      ((Element)v.get(68)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 68   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(78)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(78)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(78)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(78)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(78)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(78)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(68)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("ancho","100" );
      ((Element)v.get(79)).setAttribute("minimizable","S" );
      ((Element)v.get(79)).setAttribute("minimizada","N" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("ancho","100" );
      ((Element)v.get(80)).setAttribute("minimizable","S" );
      ((Element)v.get(80)).setAttribute("minimizada","N" );
      ((Element)v.get(78)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("ancho","100" );
      ((Element)v.get(81)).setAttribute("minimizable","S" );
      ((Element)v.get(81)).setAttribute("minimizada","N" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(78)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:78   */

      /* Empieza nodo:82 / Elemento padre: 68   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(82)).setAttribute("alto","25" );
      ((Element)v.get(82)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(82)).setAttribute("imgFondo","" );
      ((Element)v.get(82)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(68)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("colFondo","" );
      ((Element)v.get(83)).setAttribute("ID","EstCab" );
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(83)).setAttribute("cod","ApeConfCentroDistribucion.centroDistrib.label" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Elemento padre:83 / Elemento actual: 84   */
      v.add(doc.createTextNode("Centro distribución"));
      ((Element)v.get(83)).appendChild((Text)v.get(84));

      /* Termina nodo Texto:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("colFondo","" );
      ((Element)v.get(85)).setAttribute("ID","EstCab" );
      ((Element)v.get(85)).setAttribute("cod","10" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Elemento padre:85 / Elemento actual: 86   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(85)).appendChild((Text)v.get(86));

      /* Termina nodo Texto:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("colFondo","" );
      ((Element)v.get(87)).setAttribute("ID","EstCab" );
      ((Element)v.get(87)).setAttribute("cod","ApeConfCentroDistribucion.centroDefault.label" );
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Elemento padre:87 / Elemento actual: 88   */
      v.add(doc.createTextNode("Centro distribución default"));
      ((Element)v.get(87)).appendChild((Text)v.get(88));

      /* Termina nodo Texto:88   */
      /* Termina nodo:87   */
      /* Termina nodo:82   */

      /* Empieza nodo:89 / Elemento padre: 68   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(89)).setAttribute("alto","22" );
      ((Element)v.get(89)).setAttribute("accion","" );
      ((Element)v.get(89)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(89)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(89)).setAttribute("maxSel","-1" );
      ((Element)v.get(89)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(89)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(89)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(89)).setAttribute("onLoad","" );
      ((Element)v.get(89)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(68)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("tipo","texto" );
      ((Element)v.get(90)).setAttribute("ID","EstDat" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("tipo","texto" );
      ((Element)v.get(91)).setAttribute("ID","EstDat2" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("tipo","texto" );
      ((Element)v.get(92)).setAttribute("ID","EstDat" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:89   */

      /* Empieza nodo:93 / Elemento padre: 68   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 68   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(94)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(94)).setAttribute("ancho","679" );
      ((Element)v.get(94)).setAttribute("sep","$" );
      ((Element)v.get(94)).setAttribute("x","12" );
      ((Element)v.get(94)).setAttribute("class","botonera" );
      ((Element)v.get(94)).setAttribute("y","294" );
      ((Element)v.get(94)).setAttribute("control","|" );
      ((Element)v.get(94)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(94)).setAttribute("rowset","" );
      ((Element)v.get(94)).setAttribute("cargainicial","N" );
      ((Element)v.get(94)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(68)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(95)).setAttribute("nombre","ret1" );
      ((Element)v.get(95)).setAttribute("x","37" );
      ((Element)v.get(95)).setAttribute("y","282" );
      ((Element)v.get(95)).setAttribute("ID","botonContenido" );
      ((Element)v.get(95)).setAttribute("img","retroceder_on" );
      ((Element)v.get(95)).setAttribute("tipo","0" );
      ((Element)v.get(95)).setAttribute("estado","false" );
      ((Element)v.get(95)).setAttribute("alt","" );
      ((Element)v.get(95)).setAttribute("codigo","" );
      ((Element)v.get(95)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 94   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(96)).setAttribute("nombre","ava1" );
      ((Element)v.get(96)).setAttribute("x","52" );
      ((Element)v.get(96)).setAttribute("y","282" );
      ((Element)v.get(96)).setAttribute("ID","botonContenido" );
      ((Element)v.get(96)).setAttribute("img","avanzar_on" );
      ((Element)v.get(96)).setAttribute("tipo","0" );
      ((Element)v.get(96)).setAttribute("estado","false" );
      ((Element)v.get(96)).setAttribute("alt","" );
      ((Element)v.get(96)).setAttribute("codigo","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(96)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(94)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:94   */
      /* Termina nodo:68   */

      /* Empieza nodo:97 / Elemento padre: 67   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(97)).setAttribute("nombre","primera1" );
      ((Element)v.get(97)).setAttribute("x","20" );
      ((Element)v.get(97)).setAttribute("y","282" );
      ((Element)v.get(97)).setAttribute("ID","botonContenido" );
      ((Element)v.get(97)).setAttribute("img","primera_on" );
      ((Element)v.get(97)).setAttribute("tipo","-2" );
      ((Element)v.get(97)).setAttribute("estado","false" );
      ((Element)v.get(97)).setAttribute("alt","" );
      ((Element)v.get(97)).setAttribute("codigo","" );
      ((Element)v.get(97)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(67)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 67   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(98)).setAttribute("nombre","separa" );
      ((Element)v.get(98)).setAttribute("x","59" );
      ((Element)v.get(98)).setAttribute("y","278" );
      ((Element)v.get(98)).setAttribute("ID","botonContenido" );
      ((Element)v.get(98)).setAttribute("img","separa_base" );
      ((Element)v.get(98)).setAttribute("tipo","0" );
      ((Element)v.get(98)).setAttribute("estado","false" );
      ((Element)v.get(98)).setAttribute("alt","" );
      ((Element)v.get(98)).setAttribute("codigo","" );
      ((Element)v.get(98)).setAttribute("accion","" );
      ((Element)v.get(67)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 67   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(99)).setAttribute("nombre","Modificar" );
      ((Element)v.get(99)).setAttribute("x","80" );
      ((Element)v.get(99)).setAttribute("y","279" );
      ((Element)v.get(99)).setAttribute("ID","botonContenido" );
      ((Element)v.get(99)).setAttribute("tipo","html" );
      ((Element)v.get(99)).setAttribute("estado","false" );
      ((Element)v.get(99)).setAttribute("cod","2" );
      ((Element)v.get(99)).setAttribute("accion","" );
      ((Element)v.get(67)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 67   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(100)).setAttribute("nombre","Detalle" );
      ((Element)v.get(100)).setAttribute("x","80" );
      ((Element)v.get(100)).setAttribute("y","279" );
      ((Element)v.get(100)).setAttribute("ID","botonContenido" );
      ((Element)v.get(100)).setAttribute("tipo","html" );
      ((Element)v.get(100)).setAttribute("estado","false" );
      ((Element)v.get(100)).setAttribute("cod","3" );
      ((Element)v.get(100)).setAttribute("accion","" );
      ((Element)v.get(67)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:67   */

      /* Empieza nodo:101 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(101)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(101)).setAttribute("alto","12" );
      ((Element)v.get(101)).setAttribute("ancho","100%" );
      ((Element)v.get(101)).setAttribute("colorf","" );
      ((Element)v.get(101)).setAttribute("borde","0" );
      ((Element)v.get(101)).setAttribute("imagenf","" );
      ((Element)v.get(101)).setAttribute("repeat","" );
      ((Element)v.get(101)).setAttribute("padding","" );
      ((Element)v.get(101)).setAttribute("visibilidad","visible" );
      ((Element)v.get(101)).setAttribute("contravsb","" );
      ((Element)v.get(101)).setAttribute("x","0" );
      ((Element)v.get(101)).setAttribute("y","428" );
      ((Element)v.get(101)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:5   */


   }

}
