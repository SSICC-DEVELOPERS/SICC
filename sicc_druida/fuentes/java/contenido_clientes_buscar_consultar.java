
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_clientes_buscar_consultar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_clientes_buscar_consultar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(1)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(2)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("table"));
      ((Element)v.get(3)).setAttribute("width","100%" );
      ((Element)v.get(3)).setAttribute("border","0" );
      ((Element)v.get(3)).setAttribute("cellspacing","0" );
      ((Element)v.get(3)).setAttribute("cellpadding","0" );
      ((Element)v.get(2)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("td"));
      ((Element)v.get(5)).setAttribute("width","12" );
      ((Element)v.get(5)).setAttribute("align","center" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(6)).setAttribute("src","b.gif" );
      ((Element)v.get(6)).setAttribute("width","12" );
      ((Element)v.get(6)).setAttribute("height","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("td"));
      ((Element)v.get(7)).setAttribute("width","750" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(8)).setAttribute("src","b.gif" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).setAttribute("width","12" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(10)).setAttribute("src","b.gif" );
      ((Element)v.get(10)).setAttribute("width","12" );
      ((Element)v.get(10)).setAttribute("height","1" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:9   */
      /* Termina nodo:4   */

      /* Empieza nodo:11 / Elemento padre: 3   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(3)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(13)).setAttribute("src","b.gif" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:12   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(16)).setAttribute("class","legend" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(17)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(17)).setAttribute("alto","13" );
      ((Element)v.get(17)).setAttribute("filas","1" );
      ((Element)v.get(17)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(17)).setAttribute("id","legend" );
      ((Element)v.get(17)).setAttribute("cod","0075" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("align","center" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("colspan","4" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","8" );
      ((Element)v.get(21)).setAttribute("height","8" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:22 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","8" );
      ((Element)v.get(24)).setAttribute("height","8" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(26)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(26)).setAttribute("alto","13" );
      ((Element)v.get(26)).setAttribute("filas","1" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(26)).setAttribute("id","datosTitle" );
      ((Element)v.get(26)).setAttribute("cod","393" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","25" );
      ((Element)v.get(28)).setAttribute("height","8" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(30)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(30)).setAttribute("alto","13" );
      ((Element)v.get(30)).setAttribute("filas","1" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(30)).setAttribute("id","datosTitle" );
      ((Element)v.get(30)).setAttribute("cod","595" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","100%" );
      ((Element)v.get(22)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","8" );
      ((Element)v.get(32)).setAttribute("height","8" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:22   */

      /* Empieza nodo:33 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","8" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(37)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(37)).setAttribute("id","datosCampos" );
      ((Element)v.get(37)).setAttribute("size","1" );
      ((Element)v.get(37)).setAttribute("multiple","N" );
      ((Element)v.get(37)).setAttribute("req","N" );
      ((Element)v.get(37)).setAttribute("valorinicial","" );
      ((Element)v.get(37)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:39 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","25" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(33)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(42)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(42)).setAttribute("id","datosCampos" );
      ((Element)v.get(42)).setAttribute("size","1" );
      ((Element)v.get(42)).setAttribute("multiple","N" );
      ((Element)v.get(42)).setAttribute("req","N" );
      ((Element)v.get(42)).setAttribute("valorinicial","" );
      ((Element)v.get(42)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(33)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:33   */

      /* Empieza nodo:46 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("colspan","4" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:18   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:49 / Elemento padre: 11   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:11   */

      /* Empieza nodo:51 / Elemento padre: 3   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(3)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(56)).setAttribute("border","0" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("class","botonera" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(59)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(59)).setAttribute("ID","botonContenido" );
      ((Element)v.get(59)).setAttribute("tipo","html" );
      ((Element)v.get(59)).setAttribute("accion","" );
      ((Element)v.get(59)).setAttribute("estado","false" );
      ((Element)v.get(59)).setAttribute("cod","446" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:60 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","12" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:51   */

      /* Empieza nodo:62 / Elemento padre: 3   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(3)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","12" );
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","12" );
      ((Element)v.get(64)).setAttribute("height","12" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","750" );
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","12" );
      ((Element)v.get(68)).setAttribute("height","1" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:62   */
      /* Termina nodo:3   */
      /* Termina nodo:2   */
      /* Termina nodo:1   */


   }

}
