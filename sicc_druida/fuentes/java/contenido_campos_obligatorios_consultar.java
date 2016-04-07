
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_campos_obligatorios_consultar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_campos_obligatorios_insertar" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar Campos de ingreso obligatorio, modificacion permitida y valores por defecto" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar Campos de ingreso obligatorio, modificacion permitida y valores por defecto" );
      ((Element)v.get(0)).setAttribute("onload","" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(1)).setAttribute("nombre","frmDatos" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(2)).setAttribute("nombre","capaFormulario" );
      ((Element)v.get(2)).setAttribute("alto","100%" );
      ((Element)v.get(2)).setAttribute("ancho","100%" );
      ((Element)v.get(2)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(2)).setAttribute("borde","0" );
      ((Element)v.get(2)).setAttribute("imagenf","" );
      ((Element)v.get(2)).setAttribute("repeat","" );
      ((Element)v.get(2)).setAttribute("padding","" );
      ((Element)v.get(2)).setAttribute("visibilidad","" );
      ((Element)v.get(2)).setAttribute("contravsb","" );
      ((Element)v.get(2)).setAttribute("x","0" );
      ((Element)v.get(2)).setAttribute("y","0" );
      ((Element)v.get(2)).setAttribute("zindex","" );
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
      ((Element)v.get(4)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(8)).setAttribute("src","b.gif" );
      ((Element)v.get(8)).setAttribute("width","1" );
      ((Element)v.get(8)).setAttribute("height","1" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("td"));
      ((Element)v.get(4)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(10)).setAttribute("src","b.gif" );
      ((Element)v.get(10)).setAttribute("width","12" );
      ((Element)v.get(10)).setAttribute("height","12" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:9   */
      /* Termina nodo:4   */

      /* Empieza nodo:11 / Elemento padre: 3   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(3)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).setAttribute("width","12" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(13)).setAttribute("src","b.gif" );
      ((Element)v.get(13)).setAttribute("width","12" );
      ((Element)v.get(13)).setAttribute("height","12" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:12   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("border","1" );
      ((Element)v.get(15)).setAttribute("bordercolor","#CCCCCC" );
      ((Element)v.get(15)).setAttribute("cellspacing","1" );
      ((Element)v.get(15)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","98%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("align","center" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("colspan","8" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:22 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("valign","top" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(24)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(24)).setAttribute("ancho","100" );
      ((Element)v.get(24)).setAttribute("alto","28" );
      ((Element)v.get(24)).setAttribute("filas","1" );
      ((Element)v.get(24)).setAttribute("id","datosTitle" );
      ((Element)v.get(24)).setAttribute("cod","393" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","8" );
      ((Element)v.get(26)).setAttribute("height","8" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("colspan","2" );
      ((Element)v.get(27)).setAttribute("width","100%" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(28)).setAttribute("textoinicial","" );
      ((Element)v.get(28)).setAttribute("valorinicial","" );
      ((Element)v.get(28)).setAttribute("req","N" );
      ((Element)v.get(28)).setAttribute("multiple","N" );
      ((Element)v.get(28)).setAttribute("size","1" );
      ((Element)v.get(28)).setAttribute("id","estCombo" );
      ((Element)v.get(28)).setAttribute("nombre","comboTipoCliente" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(31)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(31)).setAttribute("TIPO","STRING" );
      ((Element)v.get(31)).setAttribute("VALOR","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(32)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(32)).setAttribute("TIPO","STRING" );
      ((Element)v.get(32)).setAttribute("VALOR","1.1" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:30   */

      /* Empieza nodo:33 / Elemento padre: 29   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(29)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(34)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(34)).setAttribute("TIPO","STRING" );
      ((Element)v.get(34)).setAttribute("VALOR","1" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 33   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(35)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(35)).setAttribute("TIPO","STRING" );
      ((Element)v.get(35)).setAttribute("VALOR","1.2" );
      ((Element)v.get(33)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:33   */

      /* Empieza nodo:36 / Elemento padre: 29   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(29)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(37)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(37)).setAttribute("TIPO","STRING" );
      ((Element)v.get(37)).setAttribute("VALOR","2" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 36   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(38)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(38)).setAttribute("TIPO","STRING" );
      ((Element)v.get(38)).setAttribute("VALOR","1.3" );
      ((Element)v.get(36)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:36   */

      /* Empieza nodo:39 / Elemento padre: 29   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(29)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(40)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(40)).setAttribute("TIPO","STRING" );
      ((Element)v.get(40)).setAttribute("VALOR","3" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 39   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(41)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(41)).setAttribute("TIPO","STRING" );
      ((Element)v.get(41)).setAttribute("VALOR","1.4" );
      ((Element)v.get(39)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 29   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(29)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(43)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(43)).setAttribute("TIPO","STRING" );
      ((Element)v.get(43)).setAttribute("VALOR","4" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(44)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(44)).setAttribute("TIPO","STRING" );
      ((Element)v.get(44)).setAttribute("VALOR","11111111" );
      ((Element)v.get(42)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:42   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:45 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("valign","top" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(47)).setAttribute("ancho","100" );
      ((Element)v.get(47)).setAttribute("alto","28" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","595" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("colspan","2" );
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(51)).setAttribute("textoinicial","" );
      ((Element)v.get(51)).setAttribute("valorinicial","" );
      ((Element)v.get(51)).setAttribute("req","N" );
      ((Element)v.get(51)).setAttribute("multiple","N" );
      ((Element)v.get(51)).setAttribute("size","1" );
      ((Element)v.get(51)).setAttribute("id","estCombo" );
      ((Element)v.get(51)).setAttribute("nombre","comboSubtipoCliente" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(54)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(54)).setAttribute("TIPO","STRING" );
      ((Element)v.get(54)).setAttribute("VALOR","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 53   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(55)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(55)).setAttribute("TIPO","STRING" );
      ((Element)v.get(55)).setAttribute("VALOR","1.1" );
      ((Element)v.get(53)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 52   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(52)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(57)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(57)).setAttribute("TIPO","STRING" );
      ((Element)v.get(57)).setAttribute("VALOR","1" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 56   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(58)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(58)).setAttribute("TIPO","STRING" );
      ((Element)v.get(58)).setAttribute("VALOR","1.2" );
      ((Element)v.get(56)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 52   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(52)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(60)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(60)).setAttribute("TIPO","STRING" );
      ((Element)v.get(60)).setAttribute("VALOR","2" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(61)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(61)).setAttribute("TIPO","STRING" );
      ((Element)v.get(61)).setAttribute("VALOR","1.3" );
      ((Element)v.get(59)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 52   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(52)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(63)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(63)).setAttribute("TIPO","STRING" );
      ((Element)v.get(63)).setAttribute("VALOR","3" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 62   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(64)).setAttribute("NOMBRE","contenido" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(64)).setAttribute("TIPO","STRING" );
      ((Element)v.get(64)).setAttribute("VALOR","1.4" );
      ((Element)v.get(62)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 52   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(52)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(66)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(66)).setAttribute("TIPO","STRING" );
      ((Element)v.get(66)).setAttribute("VALOR","4" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(67)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(67)).setAttribute("TIPO","STRING" );
      ((Element)v.get(67)).setAttribute("VALOR","11111111" );
      ((Element)v.get(65)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:65   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:45   */

      /* Empieza nodo:68 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("valign","top" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblNombreCampo" );
      ((Element)v.get(70)).setAttribute("ancho","100" );
      ((Element)v.get(70)).setAttribute("alto","28" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","1285" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("colspan","2" );
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(74)).setAttribute("textoinicial","" );
      ((Element)v.get(74)).setAttribute("valorinicial","" );
      ((Element)v.get(74)).setAttribute("req","N" );
      ((Element)v.get(74)).setAttribute("multiple","N" );
      ((Element)v.get(74)).setAttribute("size","1" );
      ((Element)v.get(74)).setAttribute("id","estCombo" );
      ((Element)v.get(74)).setAttribute("nombre","comboNombreCampo" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(77)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(77)).setAttribute("TIPO","STRING" );
      ((Element)v.get(77)).setAttribute("VALOR","0" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 76   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(78)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(78)).setAttribute("TIPO","STRING" );
      ((Element)v.get(78)).setAttribute("VALOR","1.1" );
      ((Element)v.get(76)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:76   */

      /* Empieza nodo:79 / Elemento padre: 75   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(75)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(80)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(80)).setAttribute("TIPO","STRING" );
      ((Element)v.get(80)).setAttribute("VALOR","1" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 79   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(81)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(81)).setAttribute("TIPO","STRING" );
      ((Element)v.get(81)).setAttribute("VALOR","1.2" );
      ((Element)v.get(79)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:79   */

      /* Empieza nodo:82 / Elemento padre: 75   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(75)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(83)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(83)).setAttribute("TIPO","STRING" );
      ((Element)v.get(83)).setAttribute("VALOR","2" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 82   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(84)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(84)).setAttribute("TIPO","STRING" );
      ((Element)v.get(84)).setAttribute("VALOR","1.3" );
      ((Element)v.get(82)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 75   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(75)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(86)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(86)).setAttribute("TIPO","STRING" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(86)).setAttribute("VALOR","3" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 85   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(87)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(87)).setAttribute("TIPO","STRING" );
      ((Element)v.get(87)).setAttribute("VALOR","1.4" );
      ((Element)v.get(85)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:85   */

      /* Empieza nodo:88 / Elemento padre: 75   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(75)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(89)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(89)).setAttribute("TIPO","STRING" );
      ((Element)v.get(89)).setAttribute("VALOR","4" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(90)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(90)).setAttribute("TIPO","STRING" );
      ((Element)v.get(90)).setAttribute("VALOR","11111111" );
      ((Element)v.get(88)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:88   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:68   */

      /* Empieza nodo:91 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblObligatorio" );
      ((Element)v.get(93)).setAttribute("ancho","100" );
      ((Element)v.get(93)).setAttribute("alto","28" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("cod","949" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(91)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("table"));
      ((Element)v.get(97)).setAttribute("cellspacing","0" );
      ((Element)v.get(97)).setAttribute("cellpadding","0" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("class","datosCampos" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(100)).setAttribute("nombre","RDObligatorio" );
      ((Element)v.get(100)).setAttribute("tipo","H" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(101)).setAttribute("valor","S" );
      ((Element)v.get(101)).setAttribute("check","N" );
      ((Element)v.get(101)).setAttribute("onfocus","" );
      ((Element)v.get(101)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Elemento padre:101 / Elemento actual: 102   */
      v.add(doc.createTextNode("Si"));
      ((Element)v.get(101)).appendChild((Text)v.get(102));

      /* Termina nodo Texto:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(103)).setAttribute("valor","N" );
      ((Element)v.get(103)).setAttribute("check","N" );
      ((Element)v.get(103)).setAttribute("onfocus","" );
      ((Element)v.get(103)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("No"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:91   */

      /* Empieza nodo:105 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblModificable" );
      ((Element)v.get(107)).setAttribute("ancho","100" );
      ((Element)v.get(107)).setAttribute("alto","28" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","914" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 105   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("class","datosCamposLeft" );
      ((Element)v.get(105)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("class","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(114)).setAttribute("nombre","RDModificable" );
      ((Element)v.get(114)).setAttribute("tipo","H" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(115)).setAttribute("valor","S" );
      ((Element)v.get(115)).setAttribute("check","N" );
      ((Element)v.get(115)).setAttribute("onfocus","" );
      ((Element)v.get(115)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Elemento padre:115 / Elemento actual: 116   */
      v.add(doc.createTextNode("Si"));
      ((Element)v.get(115)).appendChild((Text)v.get(116));

      /* Termina nodo Texto:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(117)).setAttribute("valor","N" );
      ((Element)v.get(117)).setAttribute("check","N" );
      ((Element)v.get(117)).setAttribute("onfocus","" );
      ((Element)v.get(117)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Elemento padre:117 / Elemento actual: 118   */
      v.add(doc.createTextNode("No"));
      ((Element)v.get(117)).appendChild((Text)v.get(118));

      /* Termina nodo Texto:118   */
      /* Termina nodo:117   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:105   */

      /* Empieza nodo:119 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lblValorDefecto" );
      ((Element)v.get(121)).setAttribute("ancho","100" );
      ((Element)v.get(121)).setAttribute("alto","28" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("id","datosTitle" );
      ((Element)v.get(121)).setAttribute("cod","1286" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(125)).setAttribute("nombre","txtValorDefecto" );
      ((Element)v.get(125)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(125)).setAttribute("max","30" );
      ((Element)v.get(125)).setAttribute("tipo","" );
      ((Element)v.get(125)).setAttribute("onchange","" );
      ((Element)v.get(125)).setAttribute("req","N" );
      ((Element)v.get(125)).setAttribute("size","30" );
      ((Element)v.get(125)).setAttribute("valor","" );
      ((Element)v.get(125)).setAttribute("validacion","" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:119   */

      /* Empieza nodo:126 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("colspan","7" );
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).setAttribute("class","datosCampos" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("height","12" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:129 / Elemento padre: 11   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(11)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(130)).setAttribute("height","12" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:11   */

      /* Empieza nodo:131 / Elemento padre: 3   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(3)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(133)).setAttribute("height","12" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","1" );
      ((Element)v.get(135)).setAttribute("height","12" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","12" );
      ((Element)v.get(137)).setAttribute("height","12" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:131   */
      /* Termina nodo:3   */
      /* Termina nodo:2   */
      /* Termina nodo:1   */


   }

}
