
import org.w3c.dom.*;
import java.util.ArrayList;

public class InicioBelcorp  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","inicio" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","fnOnLoadEstaPagina()" );
      ((Element)v.get(0)).setAttribute("imagenf","" );
      ((Element)v.get(0)).setAttribute("repeat","" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r\r\rfunction fnOnLoadEstaPagina()\r{\r	try{\r				parent.frames[\"cabecera\"].mandarPagina();\r				if (get('frmInicio.hidRecargaMenu')){\r			parent.frames['menu'].location.reload();\r		}\r		try{\r			configurarMenu();\r		}catch(e){\r			;\r		}\r	}catch(e){\r			}\r}\r\rfunction configurarMenu(){\r	configurarMenuSecundario(\"frmInicio\");\r}\r\r\r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmInicio" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","hidRecargaMenu" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(8)).setAttribute("nombre","capa1" );
      ((Element)v.get(8)).setAttribute("ancho","100%" );
      ((Element)v.get(8)).setAttribute("alto","100%" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(9)).setAttribute("width","100%%" );
      ((Element)v.get(9)).setAttribute("height","100%" );
      ((Element)v.get(9)).setAttribute("border","0" );
      ((Element)v.get(9)).setAttribute("cellspacing","0" );
      ((Element)v.get(9)).setAttribute("cellpadding","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).setAttribute("valign","top" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","inicial01.jpg" );
      ((Element)v.get(12)).setAttribute("width","344" );
      ((Element)v.get(12)).setAttribute("height","176" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("rowspan","2" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(14)).setAttribute("width","100%" );
      ((Element)v.get(14)).setAttribute("height","100%" );
      ((Element)v.get(14)).setAttribute("border","0" );
      ((Element)v.get(14)).setAttribute("cellspacing","0" );
      ((Element)v.get(14)).setAttribute("cellpadding","0" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(16)).setAttribute("class","inicial" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Elemento padre:16 / Elemento actual: 17   */
      v.add(doc.createTextNode("Bolivia"));
      ((Element)v.get(16)).appendChild((Text)v.get(17));

      /* Termina nodo Texto:17   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("class","inicial" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Elemento padre:19 / Elemento actual: 20   */
      v.add(doc.createTextNode("Chile"));
      ((Element)v.get(19)).appendChild((Text)v.get(20));

      /* Termina nodo Texto:20   */
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("class","inicial" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Elemento padre:22 / Elemento actual: 23   */
      v.add(doc.createTextNode("Colombia"));
      ((Element)v.get(22)).appendChild((Text)v.get(23));

      /* Termina nodo Texto:23   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("class","inicial" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Elemento padre:25 / Elemento actual: 26   */
      v.add(doc.createTextNode("Ecuador"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(25)).appendChild((Text)v.get(26));

      /* Termina nodo Texto:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("class","inicial" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Elemento padre:28 / Elemento actual: 29   */
      v.add(doc.createTextNode("El Salvador"));
      ((Element)v.get(28)).appendChild((Text)v.get(29));

      /* Termina nodo Texto:29   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("class","inicial" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Elemento padre:31 / Elemento actual: 32   */
      v.add(doc.createTextNode("Guatemala"));
      ((Element)v.get(31)).appendChild((Text)v.get(32));

      /* Termina nodo Texto:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("class","inicial" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Elemento padre:34 / Elemento actual: 35   */
      v.add(doc.createTextNode("México"));
      ((Element)v.get(34)).appendChild((Text)v.get(35));

      /* Termina nodo Texto:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("class","inicial" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Elemento padre:37 / Elemento actual: 38   */
      v.add(doc.createTextNode("Perú"));
      ((Element)v.get(37)).appendChild((Text)v.get(38));

      /* Termina nodo Texto:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:39 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(10)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","1" );
      ((Element)v.get(40)).setAttribute("height","1" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:10   */

      /* Empieza nodo:41 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("valign","top" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","inicial02.jpg" );
      ((Element)v.get(43)).setAttribute("width","344" );
      ((Element)v.get(43)).setAttribute("height","116" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:41   */

      /* Empieza nodo:46 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("colspan","2" );
      ((Element)v.get(47)).setAttribute("valign","top" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","inicial03.jpg" );
      ((Element)v.get(48)).setAttribute("width","491" );
      ((Element)v.get(48)).setAttribute("height","86" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:46   */

      /* Empieza nodo:51 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("height","100%" );
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
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("height","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("class","inicial" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Elemento padre:57 / Elemento actual: 58   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createTextNode("Puerto Rico"));
      ((Element)v.get(57)).appendChild((Text)v.get(58));

      /* Termina nodo Texto:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).setAttribute("class","inicial" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Elemento padre:60 / Elemento actual: 61   */
      v.add(doc.createTextNode("República Dominicana"));
      ((Element)v.get(60)).appendChild((Text)v.get(61));

      /* Termina nodo Texto:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("class","inicial" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Elemento padre:63 / Elemento actual: 64   */
      v.add(doc.createTextNode("Venezuela"));
      ((Element)v.get(63)).appendChild((Text)v.get(64));

      /* Termina nodo Texto:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:65 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:51   */
      /* Termina nodo:9   */
      /* Termina nodo:8   */
      /* Termina nodo:4   */


   }

}
