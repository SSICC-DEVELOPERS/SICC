
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_registrar_nuevas_buscar_curso  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML720(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_registrar_nuevas_buscar_curso" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoad()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_registrar_nuevas_buscar_curso.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
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
      ((Element)v.get(11)).setAttribute("nombre","idioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","pais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(13)).setAttribute("nombre","capa1" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(14)).setAttribute("width","100%" );
      ((Element)v.get(14)).setAttribute("border","0" );
      ((Element)v.get(14)).setAttribute("cellspacing","0" );
      ((Element)v.get(14)).setAttribute("cellpadding","0" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(16)).setAttribute("width","12" );
      ((Element)v.get(16)).setAttribute("align","center" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(17)).setAttribute("src","b.gif" );
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("height","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(18)).setAttribute("width","750" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","1" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */
      /* Termina nodo:15   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(27)).setAttribute("class","legend" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(28)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(28)).setAttribute("alto","13" );
      ((Element)v.get(28)).setAttribute("filas","1" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(28)).setAttribute("id","legend" );
      ((Element)v.get(28)).setAttribute("cod","0075" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("table"));
      ((Element)v.get(29)).setAttribute("width","100%" );
      ((Element)v.get(29)).setAttribute("border","0" );
      ((Element)v.get(29)).setAttribute("align","center" );
      ((Element)v.get(29)).setAttribute("cellspacing","0" );
      ((Element)v.get(29)).setAttribute("cellpadding","0" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","487" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("align","left" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("colspan","3" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","8" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:36 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(40)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(40)).setAttribute("alto","13" );
      ((Element)v.get(40)).setAttribute("filas","1" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(40)).setAttribute("id","datosTitle" );
      ((Element)v.get(40)).setAttribute("cod","6" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","25" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","7" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(36)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:36   */

      /* Empieza nodo:47 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(51)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(51)).setAttribute("id","datosCampos" );
      ((Element)v.get(51)).setAttribute("size","1" );
      ((Element)v.get(51)).setAttribute("multiple","N" );
      ((Element)v.get(51)).setAttribute("req","N" );
      ((Element)v.get(51)).setAttribute("onshtab","compruebashtab();" );
      ((Element)v.get(51)).setAttribute("valorinicial","" );
      ((Element)v.get(51)).setAttribute("textoinicial","" );
      ((Element)v.get(51)).setAttribute("onchange","onSeleccionaMarca();" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:53 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","25" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(56)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(56)).setAttribute("id","datosCampos" );
      ((Element)v.get(56)).setAttribute("size","1" );
      ((Element)v.get(56)).setAttribute("multiple","N" );
      ((Element)v.get(56)).setAttribute("req","N" );
      ((Element)v.get(56)).setAttribute("valorinicial","" );
      ((Element)v.get(56)).setAttribute("textoinicial","" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:58 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(47)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:47   */

      /* Empieza nodo:60 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("colspan","3" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","7" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:63 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","487" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("align","left" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblTipoCurso" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","758" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblCodCurso" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("cod","715" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblNombreCurso" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","742" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","100%" );
      ((Element)v.get(66)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:66   */

      /* Empieza nodo:81 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(85)).setAttribute("nombre","cbTipoCurso" );
      ((Element)v.get(85)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).setAttribute("size","1" );
      ((Element)v.get(85)).setAttribute("multiple","N" );
      ((Element)v.get(85)).setAttribute("req","N" );
      ((Element)v.get(85)).setAttribute("valorinicial","" );
      ((Element)v.get(85)).setAttribute("textoinicial","" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:87 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(90)).setAttribute("nombre","txtCodCurso" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("max","3" );
      ((Element)v.get(90)).setAttribute("tipo","" );
      ((Element)v.get(90)).setAttribute("onchange","" );
      ((Element)v.get(90)).setAttribute("onblur","validarCodCurso();" );
      ((Element)v.get(90)).setAttribute("req","N" );
      ((Element)v.get(90)).setAttribute("size","3" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("validacion","" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(94)).setAttribute("nombre","txtNombreCurso" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("max","30" );
      ((Element)v.get(94)).setAttribute("tipo","" );
      ((Element)v.get(94)).setAttribute("onchange","" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("size","30" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("validacion","" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(81)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:81   */

      /* Empieza nodo:97 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("colspan","3" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:29   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:100 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:22   */

      /* Empieza nodo:102 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("table"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("cellpadding","0" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("class","botonera" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(110)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(110)).setAttribute("ID","botonContenido" );
      ((Element)v.get(110)).setAttribute("tipo","html" );
      ((Element)v.get(110)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(110)).setAttribute("ontab","compruebatab();" );
      ((Element)v.get(110)).setAttribute("estado","false" );
      ((Element)v.get(110)).setAttribute("cod","1" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:111 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","12" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:102   */

      /* Empieza nodo:113 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","12" );
      ((Element)v.get(115)).setAttribute("height","12" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","756" );
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","12" );
      ((Element)v.get(113)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","12" );
      ((Element)v.get(119)).setAttribute("height","1" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:113   */
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:120 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(120)).setAttribute("nombre","capaLista" );
      ((Element)v.get(120)).setAttribute("alto","360" );
      ((Element)v.get(120)).setAttribute("ancho","100%" );
      ((Element)v.get(120)).setAttribute("colorf","" );
      ((Element)v.get(120)).setAttribute("borde","0" );
      ((Element)v.get(120)).setAttribute("imagenf","" );
      ((Element)v.get(120)).setAttribute("repeat","" );
      ((Element)v.get(120)).setAttribute("padding","" );
      ((Element)v.get(120)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(120)).setAttribute("contravsb","" );
      ((Element)v.get(120)).setAttribute("x","0" );
      ((Element)v.get(120)).setAttribute("y","162" );
      ((Element)v.get(120)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(121)).setAttribute("nombre","listado1" );
      ((Element)v.get(121)).setAttribute("ancho","490" );
      ((Element)v.get(121)).setAttribute("alto","317" );
      ((Element)v.get(121)).setAttribute("x","12" );
      ((Element)v.get(121)).setAttribute("y","0" );
      ((Element)v.get(121)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(121)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(122)).setAttribute("precarga","S" );
      ((Element)v.get(122)).setAttribute("conROver","S" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(123)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(123)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(123)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(123)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 122   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(124)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(124)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(124)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(124)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(122)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(125)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(125)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:122   */

      /* Empieza nodo:126 / Elemento padre: 121   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(121)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(127)).setAttribute("borde","1" );
      ((Element)v.get(127)).setAttribute("horizDatos","1" );
      ((Element)v.get(127)).setAttribute("horizCabecera","1" );
      ((Element)v.get(127)).setAttribute("vertical","1" );
      ((Element)v.get(127)).setAttribute("horizTitulo","1" );
      ((Element)v.get(127)).setAttribute("horizBase","1" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 126   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(128)).setAttribute("borde","#999999" );
      ((Element)v.get(128)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(128)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(128)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(128)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(128)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(128)).setAttribute("horizBase","#999999" );
      ((Element)v.get(126)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:126   */

      /* Empieza nodo:129 / Elemento padre: 121   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(129)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(129)).setAttribute("alto","22" );
      ((Element)v.get(129)).setAttribute("imgFondo","" );
      ((Element)v.get(129)).setAttribute("cod","00135" );
      ((Element)v.get(129)).setAttribute("ID","datosTitle" );
      ((Element)v.get(121)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 121   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(130)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(130)).setAttribute("alto","22" );
      ((Element)v.get(130)).setAttribute("imgFondo","" );
      ((Element)v.get(121)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 121   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(131)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(131)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(131)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(131)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(131)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(131)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(121)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("ancho","100" );
      ((Element)v.get(132)).setAttribute("minimizable","S" );
      ((Element)v.get(132)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("ancho","100" );
      ((Element)v.get(133)).setAttribute("minimizable","S" );
      ((Element)v.get(133)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("ancho","120" );
      ((Element)v.get(134)).setAttribute("minimizable","S" );
      ((Element)v.get(134)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("ancho","100" );
      ((Element)v.get(135)).setAttribute("minimizable","S" );
      ((Element)v.get(135)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("ancho","100" );
      ((Element)v.get(136)).setAttribute("minimizable","S" );
      ((Element)v.get(136)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("ancho","100" );
      ((Element)v.get(137)).setAttribute("minimizable","S" );
      ((Element)v.get(137)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("ancho","100" );
      ((Element)v.get(138)).setAttribute("minimizable","S" );
      ((Element)v.get(138)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("ancho","100" );
      ((Element)v.get(139)).setAttribute("minimizable","S" );
      ((Element)v.get(139)).setAttribute("minimizada","N" );
      ((Element)v.get(139)).setAttribute("oculta","S" );
      ((Element)v.get(131)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:131   */

      /* Empieza nodo:140 / Elemento padre: 121   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(140)).setAttribute("alto","20" );
      ((Element)v.get(140)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(140)).setAttribute("imgFondo","" );
      ((Element)v.get(140)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(121)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("colFondo","" );
      ((Element)v.get(141)).setAttribute("ID","EstCab" );
      ((Element)v.get(141)).setAttribute("cod","1039" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("colFondo","" );
      ((Element)v.get(142)).setAttribute("ID","EstCab" );
      ((Element)v.get(142)).setAttribute("cod","3128" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("colFondo","" );
      ((Element)v.get(143)).setAttribute("ID","EstCab" );
      ((Element)v.get(143)).setAttribute("cod","124" );
      ((Element)v.get(140)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("colFondo","" );
      ((Element)v.get(144)).setAttribute("ID","EstCab" );
      ((Element)v.get(144)).setAttribute("cod","109" );
      ((Element)v.get(140)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("colFondo","" );
      ((Element)v.get(145)).setAttribute("ID","EstCab" );
      ((Element)v.get(145)).setAttribute("cod","143" );
      ((Element)v.get(140)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("colFondo","" );
      ((Element)v.get(146)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).setAttribute("cod","112" );
      ((Element)v.get(140)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("colFondo","" );
      ((Element)v.get(147)).setAttribute("ID","EstCab" );
      ((Element)v.get(147)).setAttribute("cod","126" );
      ((Element)v.get(140)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 140   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("colFondo","" );
      ((Element)v.get(148)).setAttribute("ID","EstCab" );
      ((Element)v.get(148)).setAttribute("cod","126" );
      ((Element)v.get(140)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:140   */

      /* Empieza nodo:149 / Elemento padre: 121   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(149)).setAttribute("alto","22" );
      ((Element)v.get(149)).setAttribute("accion","" );
      ((Element)v.get(149)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(149)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(149)).setAttribute("maxSel","-1" );
      ((Element)v.get(149)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(149)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(149)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(149)).setAttribute("onLoad","" );
      ((Element)v.get(149)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(121)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("tipo","texto" );
      ((Element)v.get(150)).setAttribute("ID","EstDat2" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("tipo","texto" );
      ((Element)v.get(151)).setAttribute("ID","EstDat" );
      ((Element)v.get(149)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("tipo","texto" );
      ((Element)v.get(152)).setAttribute("ID","EstDat2" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("tipo","texto" );
      ((Element)v.get(153)).setAttribute("ID","EstDat" );
      ((Element)v.get(149)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("tipo","texto" );
      ((Element)v.get(154)).setAttribute("ID","EstDat2" );
      ((Element)v.get(149)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("tipo","texto" );
      ((Element)v.get(155)).setAttribute("ID","EstDat" );
      ((Element)v.get(149)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("tipo","texto" );
      ((Element)v.get(156)).setAttribute("ID","EstDat2" );
      ((Element)v.get(149)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("tipo","texto" );
      ((Element)v.get(157)).setAttribute("ID","EstDat" );
      ((Element)v.get(149)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:149   */

      /* Empieza nodo:158 / Elemento padre: 121   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(121)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 121   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(159)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(159)).setAttribute("ancho","490" );
      ((Element)v.get(159)).setAttribute("sep","$" );
      ((Element)v.get(159)).setAttribute("x","12" );
      ((Element)v.get(159)).setAttribute("class","botonera" );
      ((Element)v.get(159)).setAttribute("y","294" );
      ((Element)v.get(159)).setAttribute("control","|" );
      ((Element)v.get(159)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(159)).setAttribute("rowset","" );
      ((Element)v.get(159)).setAttribute("cargainicial","N" );
      ((Element)v.get(159)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(121)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(160)).setAttribute("nombre","ret1" );
      ((Element)v.get(160)).setAttribute("x","37" );
      ((Element)v.get(160)).setAttribute("y","298" );
      ((Element)v.get(160)).setAttribute("ID","botonContenido" );
      ((Element)v.get(160)).setAttribute("img","retroceder_on" );
      ((Element)v.get(160)).setAttribute("tipo","0" );
      ((Element)v.get(160)).setAttribute("estado","false" );
      ((Element)v.get(160)).setAttribute("alt","" );
      ((Element)v.get(160)).setAttribute("codigo","" );
      ((Element)v.get(160)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 159   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(161)).setAttribute("nombre","ava1" );
      ((Element)v.get(161)).setAttribute("x","52" );
      ((Element)v.get(161)).setAttribute("y","298" );
      ((Element)v.get(161)).setAttribute("ID","botonContenido" );
      ((Element)v.get(161)).setAttribute("img","avanzar_on" );
      ((Element)v.get(161)).setAttribute("tipo","0" );
      ((Element)v.get(161)).setAttribute("estado","false" );
      ((Element)v.get(161)).setAttribute("alt","" );
      ((Element)v.get(161)).setAttribute("codigo","" );
      ((Element)v.get(161)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(159)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:159   */
      /* Termina nodo:121   */

      /* Empieza nodo:162 / Elemento padre: 120   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(162)).setAttribute("nombre","primera1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(162)).setAttribute("x","20" );
      ((Element)v.get(162)).setAttribute("y","298" );
      ((Element)v.get(162)).setAttribute("ID","botonContenido" );
      ((Element)v.get(162)).setAttribute("img","primera_on" );
      ((Element)v.get(162)).setAttribute("tipo","-2" );
      ((Element)v.get(162)).setAttribute("estado","false" );
      ((Element)v.get(162)).setAttribute("alt","" );
      ((Element)v.get(162)).setAttribute("codigo","" );
      ((Element)v.get(162)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(120)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 120   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(163)).setAttribute("nombre","separa" );
      ((Element)v.get(163)).setAttribute("x","59" );
      ((Element)v.get(163)).setAttribute("y","294" );
      ((Element)v.get(163)).setAttribute("ID","botonContenido" );
      ((Element)v.get(163)).setAttribute("img","separa_base" );
      ((Element)v.get(163)).setAttribute("tipo","0" );
      ((Element)v.get(163)).setAttribute("estado","false" );
      ((Element)v.get(163)).setAttribute("alt","" );
      ((Element)v.get(163)).setAttribute("codigo","" );
      ((Element)v.get(163)).setAttribute("accion","" );
      ((Element)v.get(120)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 120   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(164)).setAttribute("nombre","Aceptar" );
      ((Element)v.get(164)).setAttribute("x","80" );
      ((Element)v.get(164)).setAttribute("y","295" );
      ((Element)v.get(164)).setAttribute("ID","botonContenido" );
      ((Element)v.get(164)).setAttribute("tipo","html" );
      ((Element)v.get(164)).setAttribute("estado","false" );
      ((Element)v.get(164)).setAttribute("cod","12" );
      ((Element)v.get(164)).setAttribute("accion","onClickAceptar();" );
      ((Element)v.get(164)).setAttribute("onshtab","document.all['btnBuscar'].focus();" );
      ((Element)v.get(164)).setAttribute("ontab","focaliza('formulario.cbMarca');" );
      ((Element)v.get(120)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:120   */

      /* Empieza nodo:165 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(165)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(165)).setAttribute("alto","12" );
      ((Element)v.get(165)).setAttribute("ancho","50" );
      ((Element)v.get(165)).setAttribute("x","0" );
      ((Element)v.get(165)).setAttribute("y","479" );
      ((Element)v.get(5)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:5   */


   }

}
