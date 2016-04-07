
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_calificacion_consultar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML810(doc);
         

      getXML900(doc);
         

      getXML990(doc);
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         

      getXML1710(doc);
         

      getXML1800(doc);
         

      getXML1890(doc);
         

      getXML1980(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_calificacion_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0493" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Parámetros de calificación" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
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
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r  \r      DrdEnsanchaConMargenDcho('listado1',24);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    \r      DrdEnsanchaConMargenDcho('listado2',24);\r    document.all[\"Cplistado2\"].style.visibility='';\r    document.all[\"CpLin1listado2\"].style.visibility='';\r    document.all[\"CpLin2listado2\"].style.visibility='';\r    document.all[\"CpLin3listado2\"].style.visibility='';\r    document.all[\"CpLin4listado2\"].style.visibility='';\r    document.all[\"separa2Div\"].style.visibility='';\r    document.all[\"primera2Div\"].style.visibility='';\r    document.all[\"ret2Div\"].style.visibility='';\r    document.all[\"ava2Div\"].style.visibility='';\r    \r    \r      DrdEnsanchaConMargenDcho('listado3',24);\r    document.all[\"Cplistado3\"].style.visibility='';\r    document.all[\"CpLin1listado3\"].style.visibility='';\r    document.all[\"CpLin2listado3\"].style.visibility='';\r    document.all[\"CpLin3listado3\"].style.visibility='';\r    document.all[\"CpLin4listado3\"].style.visibility='';\r    document.all[\"separa3Div\"].style.visibility='';\r    document.all[\"primera3Div\"].style.visibility='';\r    document.all[\"ret3Div\"].style.visibility='';\r    document.all[\"ava3Div\"].style.visibility='';\r    eval (ON_RSZ);  \r   }\r\rfunction poneManito(nombre) {           \r	var nombre = document.getElementById(nombre);\r	nombre.style.cursor = \"hand\";\r}   \r\r/*\rIDs pestanas\rParametrosGenerales	1\rProductos			2\rPremios				3\rRequisitos			4\rObtencionPuntos		5\rDespachoPremios		6\rAmbitoGeografico	7\rCalificacion		8\rGerentes			9\rConsultoras			10\rProgramaNuevas		11\rMultinivel			12\r*/\r\rfunction onClickPestanya(valor) {\r\r	alert('pestanya: ' + valor);\r\r	set('formulario.conectorAction', 'LPMantenerParametrosGenerales');\r	set('formulario.accion', 'redirigir');\r	set('formulario.idPestanyaDest', valor);\r	}\r\r   \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(13)).setAttribute("width","100%" );
      ((Element)v.get(13)).setAttribute("height","100%" );
      ((Element)v.get(13)).setAttribute("border","0" );
      ((Element)v.get(13)).setAttribute("align","center" );
      ((Element)v.get(13)).setAttribute("cellpadding","0" );
      ((Element)v.get(13)).setAttribute("cellspacing","0" );
      ((Element)v.get(13)).setAttribute("class","menu4" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).setAttribute("width","12" );
      ((Element)v.get(15)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(15)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(16)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).setAttribute("width","12" );
      ((Element)v.get(16)).setAttribute("height","30" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(17)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));

      /* Elemento padre:17 / Elemento actual: 18   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(17)).appendChild((Text)v.get(18));

      /* Termina nodo Texto:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","10" );
      ((Element)v.get(19)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(19)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","10" );
      ((Element)v.get(20)).setAttribute("height","8" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","92" );
      ((Element)v.get(21)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(21)).setAttribute("class","menu5texto" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(14)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","75" );
      ((Element)v.get(22)).setAttribute("border","1" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(22)).setAttribute("cellpadding","1" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(22)).setAttribute("onmouseover","poneManito('lblParametrosGenerales');" );
      ((Element)v.get(22)).setAttribute("onclick","onClickPestanya(1);" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(25)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(25)).setAttribute("alto","13" );
      ((Element)v.get(25)).setAttribute("filas","1" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(25)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(25)).setAttribute("cod","00393" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","10" );
      ((Element)v.get(26)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","10" );
      ((Element)v.get(27)).setAttribute("height","8" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","20" );
      ((Element)v.get(28)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(28)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("table"));
      ((Element)v.get(29)).setAttribute("width","75" );
      ((Element)v.get(29)).setAttribute("border","1" );
      ((Element)v.get(29)).setAttribute("align","center" );
      ((Element)v.get(29)).setAttribute("cellpadding","1" );
      ((Element)v.get(29)).setAttribute("cellspacing","0" );
      ((Element)v.get(29)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(29)).setAttribute("onmouseover","poneManito('lblProductos');" );
      ((Element)v.get(29)).setAttribute("onclick","onClickPestanya(2);" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(32)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(32)).setAttribute("alto","13" );
      ((Element)v.get(32)).setAttribute("filas","1" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(32)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(32)).setAttribute("cod","0094" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","10" );
      ((Element)v.get(33)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","10" );
      ((Element)v.get(34)).setAttribute("height","8" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","20" );
      ((Element)v.get(35)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(35)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","75" );
      ((Element)v.get(36)).setAttribute("border","1" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellpadding","1" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(36)).setAttribute("onmouseover","poneManito('lblPremios');" );
      ((Element)v.get(36)).setAttribute("onclick","onClickPestanya(3);" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(39)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(39)).setAttribute("cod","00394" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","10" );
      ((Element)v.get(40)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","10" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","20" );
      ((Element)v.get(42)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(42)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","75" );
      ((Element)v.get(43)).setAttribute("border","1" );
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(43)).setAttribute("cellpadding","1" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(43)).setAttribute("onmouseover","poneManito('lblRequisitos');" );
      ((Element)v.get(43)).setAttribute("onclick","onClickPestanya(4);" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).setAttribute("align","center" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(46)).setAttribute("cod","00395" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:47 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","10" );
      ((Element)v.get(47)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","10" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","20" );
      ((Element)v.get(49)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","75" );
      ((Element)v.get(50)).setAttribute("border","1" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellpadding","1" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(50)).setAttribute("onmouseover","poneManito('lblObtencionPuntos');" );
      ((Element)v.get(50)).setAttribute("onclick","onClickPestanya(5);" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(53)).setAttribute("cod","00396" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:54 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","10" );
      ((Element)v.get(54)).setAttribute("class","menu5texto" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(14)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","10" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","20" );
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(57)).setAttribute("width","75" );
      ((Element)v.get(57)).setAttribute("border","1" );
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(57)).setAttribute("cellpadding","1" );
      ((Element)v.get(57)).setAttribute("cellspacing","0" );
      ((Element)v.get(57)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(57)).setAttribute("onmouseover","poneManito('lblDespachoPremios');" );
      ((Element)v.get(57)).setAttribute("onclick","onClickPestanya(6);" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(60)).setAttribute("cod","00397" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:61 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","16" );
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
      ((Element)v.get(14)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:63 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(63)).setAttribute("height","100%" );
      ((Element)v.get(63)).setAttribute("border","0" );
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(63)).setAttribute("cellpadding","0" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("class","menu4" );
      ((Element)v.get(7)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","12" );
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(66)).setAttribute("height","30" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Elemento padre:67 / Elemento actual: 68   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(67)).appendChild((Text)v.get(68));

      /* Termina nodo Texto:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","10" );
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","10" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","70" );
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","75" );
      ((Element)v.get(72)).setAttribute("border","1" );
      ((Element)v.get(72)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(72)).setAttribute("cellpadding","1" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(72)).setAttribute("onmouseover","poneManito('lblAmbitoGeografico');" );
      ((Element)v.get(72)).setAttribute("onclick","onClickPestanya(7);" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(75)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(75)).setAttribute("cod","2801" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:76 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","10" );
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","10" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","70" );
      ((Element)v.get(78)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(78)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("table"));
      ((Element)v.get(79)).setAttribute("width","75" );
      ((Element)v.get(79)).setAttribute("border","1" );
      ((Element)v.get(79)).setAttribute("align","center" );
      ((Element)v.get(79)).setAttribute("cellpadding","1" );
      ((Element)v.get(79)).setAttribute("cellspacing","0" );
      ((Element)v.get(79)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(79)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(82)).setAttribute("cod","00398" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:83 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","10" );
      ((Element)v.get(83)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","10" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","20" );
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("table"));
      ((Element)v.get(86)).setAttribute("width","75" );
      ((Element)v.get(86)).setAttribute("border","1" );
      ((Element)v.get(86)).setAttribute("align","center" );
      ((Element)v.get(86)).setAttribute("cellpadding","1" );
      ((Element)v.get(86)).setAttribute("cellspacing","0" );
      ((Element)v.get(86)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(86)).setAttribute("onmouseover","poneManito('lblGerentes');" );
      ((Element)v.get(86)).setAttribute("onclick","onClickPestanya(9);" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lblGerentes" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(89)).setAttribute("alto","13" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(89)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(89)).setAttribute("cod","00399" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:90 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","10" );
      ((Element)v.get(90)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","10" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","20" );
      ((Element)v.get(92)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(92)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("table"));
      ((Element)v.get(93)).setAttribute("width","75" );
      ((Element)v.get(93)).setAttribute("border","1" );
      ((Element)v.get(93)).setAttribute("align","center" );
      ((Element)v.get(93)).setAttribute("cellpadding","1" );
      ((Element)v.get(93)).setAttribute("cellspacing","0" );
      ((Element)v.get(93)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(93)).setAttribute("onmouseover","poneManito('lblConsultoras');" );
      ((Element)v.get(93)).setAttribute("onclick","onClickPestanya(10);" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).setAttribute("align","center" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(96)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("filas","1" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(96)).setAttribute("cod","00401" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:97 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","10" );
      ((Element)v.get(97)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","10" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","20" );
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("table"));
      ((Element)v.get(100)).setAttribute("width","75" );
      ((Element)v.get(100)).setAttribute("border","1" );
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(100)).setAttribute("cellpadding","1" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
      ((Element)v.get(100)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(100)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(100)).setAttribute("onclick","onClickPestanya(11);" );
      ((Element)v.get(100)).setAttribute("onmouseover","poneManito('lblProgramaNuevas');" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(103)).setAttribute("cod","00590" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:104 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","10" );
      ((Element)v.get(104)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","10" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","20" );
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(106)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("table"));
      ((Element)v.get(107)).setAttribute("width","75" );
      ((Element)v.get(107)).setAttribute("border","1" );
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("cellpadding","1" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(107)).setAttribute("onclick","onClickPestanya(12);" );
      ((Element)v.get(107)).setAttribute("onmouseover","poneManito('lblMultinivel');" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(110)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("filas","1" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(110)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(110)).setAttribute("cod","00400" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:111 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","16" );
      ((Element)v.get(111)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","12" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:113 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(113)).setAttribute("nombre","capa1" );
      ((Element)v.get(7)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","12" );
      ((Element)v.get(117)).setAttribute("height","12" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","750" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(121)).setAttribute("height","1" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:115   */

      /* Empieza nodo:122 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(127)).setAttribute("class","legend" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblParametrosCalificacion" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("id","legend" );
      ((Element)v.get(128)).setAttribute("cod","00383" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(129)).setAttribute("border","0" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("cellspacing","0" );
      ((Element)v.get(129)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("table"));
      ((Element)v.get(132)).setAttribute("width","552" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("align","left" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("cellpadding","0" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("colspan","3" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:136 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblPeriodoEvaluacionDesde" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","1958" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","25" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblPeriodoEvaluacionHasta" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(144)).setAttribute("id","datosTitle" );
      ((Element)v.get(144)).setAttribute("cod","1959" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(148)).setAttribute("nombre","lblDirigidoA" );
      ((Element)v.get(148)).setAttribute("alto","13" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("valor","" );
      ((Element)v.get(148)).setAttribute("id","datosTitle" );
      ((Element)v.get(148)).setAttribute("cod","1626" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","25" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(152)).setAttribute("nombre","lblMetasModificables" );
      ((Element)v.get(152)).setAttribute("alto","13" );
      ((Element)v.get(152)).setAttribute("filas","1" );
      ((Element)v.get(152)).setAttribute("valor","" );
      ((Element)v.get(152)).setAttribute("id","datosTitle" );
      ((Element)v.get(152)).setAttribute("cod","1902" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:136   */

      /* Empieza nodo:155 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(159)).setAttribute("nombre","lbldtPeriodoEvaluacionDesde" );
      ((Element)v.get(159)).setAttribute("alto","13" );
      ((Element)v.get(159)).setAttribute("filas","1" );
      ((Element)v.get(159)).setAttribute("valor","xx-xx-xxxx" );
      ((Element)v.get(159)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","25" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(163)).setAttribute("nombre","lbldtPeriodoEvaluacionHasta" );
      ((Element)v.get(163)).setAttribute("alto","13" );
      ((Element)v.get(163)).setAttribute("filas","1" );
      ((Element)v.get(163)).setAttribute("valor","xx-xx-xxxx" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","25" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lbldtDirigidoA" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("valor","Consultoras" );
      ((Element)v.get(167)).setAttribute("id","datosCampos" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","25" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lbldtMetasModificables" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("valor","x1" );
      ((Element)v.get(171)).setAttribute("id","datosCampos" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","100%" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(155)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:155   */

      /* Empieza nodo:174 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("colspan","3" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","659" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:177 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("table"));
      ((Element)v.get(179)).setAttribute("width","552" );
      ((Element)v.get(179)).setAttribute("border","0" );
      ((Element)v.get(179)).setAttribute("align","left" );
      ((Element)v.get(179)).setAttribute("cellspacing","0" );
      ((Element)v.get(179)).setAttribute("cellpadding","0" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("colspan","3" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:183 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(187)).setAttribute("nombre","lblComunicacion" );
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("valor","" );
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(187)).setAttribute("cod","1812" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblMensaje" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","531" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("width","100%" );
      ((Element)v.get(183)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:183   */

      /* Empieza nodo:194 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(198)).setAttribute("nombre","lbldtComunicacion" );
      ((Element)v.get(198)).setAttribute("alto","13" );
      ((Element)v.get(198)).setAttribute("filas","1" );
      ((Element)v.get(198)).setAttribute("valor","Sí" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","25" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lbldtMensaje" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(202)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(194)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:194   */

      /* Empieza nodo:205 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("colspan","3" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","7" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:208 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("table"));
      ((Element)v.get(210)).setAttribute("width","552" );
      ((Element)v.get(210)).setAttribute("border","0" );
      ((Element)v.get(210)).setAttribute("align","left" );
      ((Element)v.get(210)).setAttribute("cellspacing","0" );
      ((Element)v.get(210)).setAttribute("cellpadding","0" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(215)).setAttribute("nombre","lblDevoluciones" );
      ((Element)v.get(215)).setAttribute("alto","13" );
      ((Element)v.get(215)).setAttribute("filas","1" );
      ((Element)v.get(215)).setAttribute("valor","" );
      ((Element)v.get(215)).setAttribute("id","datosTitle" );
      ((Element)v.get(215)).setAttribute("cod","1623" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","25" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(219)).setAttribute("nombre","lblAnulaciones" );
      ((Element)v.get(219)).setAttribute("alto","13" );
      ((Element)v.get(219)).setAttribute("filas","1" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("id","datosTitle" );
      ((Element)v.get(219)).setAttribute("cod","1624" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 211   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","25" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(223)).setAttribute("nombre","lblFaltantesNoAnunciados" );
      ((Element)v.get(223)).setAttribute("alto","13" );
      ((Element)v.get(223)).setAttribute("filas","1" );
      ((Element)v.get(223)).setAttribute("valor","" );
      ((Element)v.get(223)).setAttribute("id","datosTitle" );
      ((Element)v.get(223)).setAttribute("cod","1625" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(211)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:211   */

      /* Empieza nodo:226 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(230)).setAttribute("nombre","lbldtDevoluciones" );
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("valor","Sí" );
      ((Element)v.get(230)).setAttribute("id","datosCampos" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","25" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(234)).setAttribute("nombre","lbldtAnulaciones" );
      ((Element)v.get(234)).setAttribute("alto","13" );
      ((Element)v.get(234)).setAttribute("filas","1" );
      ((Element)v.get(234)).setAttribute("valor","Sí" );
      ((Element)v.get(234)).setAttribute("id","datosCampos" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","25" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lbldtFaltantesNoAnunciados" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("valor","Sí" );
      ((Element)v.get(238)).setAttribute("id","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(226)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:226   */

      /* Empieza nodo:241 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("colspan","3" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","7" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:244 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("table"));
      ((Element)v.get(246)).setAttribute("width","552" );
      ((Element)v.get(246)).setAttribute("border","0" );
      ((Element)v.get(246)).setAttribute("align","left" );
      ((Element)v.get(246)).setAttribute("cellspacing","0" );
      ((Element)v.get(246)).setAttribute("cellpadding","0" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(251)).setAttribute("nombre","lblTipoVentaCalificacion" );
      ((Element)v.get(251)).setAttribute("alto","13" );
      ((Element)v.get(251)).setAttribute("filas","1" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(251)).setAttribute("id","datosTitle" );
      ((Element)v.get(251)).setAttribute("cod","1960" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","25" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(255)).setAttribute("nombre","lblTipoVentaHistorica" );
      ((Element)v.get(255)).setAttribute("alto","13" );
      ((Element)v.get(255)).setAttribute("filas","1" );
      ((Element)v.get(255)).setAttribute("valor","" );
      ((Element)v.get(255)).setAttribute("id","datosTitle" );
      ((Element)v.get(255)).setAttribute("cod","1961" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","25" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(259)).setAttribute("nombre","lblTipoVentaIncremental" );
      ((Element)v.get(259)).setAttribute("alto","13" );
      ((Element)v.get(259)).setAttribute("filas","1" );
      ((Element)v.get(259)).setAttribute("valor","" );
      ((Element)v.get(259)).setAttribute("id","datosTitle" );
      ((Element)v.get(259)).setAttribute("cod","2443" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(263)).setAttribute("nombre","lblTipoDeterminacionMetas" );
      ((Element)v.get(263)).setAttribute("alto","13" );
      ((Element)v.get(263)).setAttribute("filas","1" );
      ((Element)v.get(263)).setAttribute("valor","" );
      ((Element)v.get(263)).setAttribute("id","datosTitle" );
      ((Element)v.get(263)).setAttribute("cod","1962" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(247)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:247   */

      /* Empieza nodo:266 / Elemento padre: 246   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(246)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(270)).setAttribute("nombre","lbldtTipoVentaCalificacion" );
      ((Element)v.get(270)).setAttribute("alto","13" );
      ((Element)v.get(270)).setAttribute("filas","1" );
      ((Element)v.get(270)).setAttribute("valor","Venta proyectada" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lbldtTipoVentaHistorica" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("valor","xxxxxxxxxxxxxx1" );
      ((Element)v.get(274)).setAttribute("id","datosCampos" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(278)).setAttribute("nombre","lbldtTipoVentaIncremental" );
      ((Element)v.get(278)).setAttribute("alto","13" );
      ((Element)v.get(278)).setAttribute("filas","1" );
      ((Element)v.get(278)).setAttribute("valor","xxxxxxxxxxxxxx1" );
      ((Element)v.get(278)).setAttribute("id","datosCampos" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","25" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(282)).setAttribute("nombre","lbldtTipoDeterminacionMetas" );
      ((Element)v.get(282)).setAttribute("alto","13" );
      ((Element)v.get(282)).setAttribute("filas","1" );
      ((Element)v.get(282)).setAttribute("valor","xxxxxxxxxxxxxx1" );
      ((Element)v.get(282)).setAttribute("id","datosCampos" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("width","100%" );
      ((Element)v.get(266)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:266   */

      /* Empieza nodo:285 / Elemento padre: 246   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(246)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("colspan","3" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","8" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:288 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(290)).setAttribute("width","552" );
      ((Element)v.get(290)).setAttribute("border","0" );
      ((Element)v.get(290)).setAttribute("align","left" );
      ((Element)v.get(290)).setAttribute("cellspacing","0" );
      ((Element)v.get(290)).setAttribute("cellpadding","0" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(295)).setAttribute("nombre","lblBonoAnual" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(295)).setAttribute("id","datosTitle" );
      ((Element)v.get(295)).setAttribute("cod","2456" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","25" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(299)).setAttribute("nombre","lblFormaCalculo" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("valor","" );
      ((Element)v.get(299)).setAttribute("id","datosTitle" );
      ((Element)v.get(299)).setAttribute("cod","1671" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","25" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(303)).setAttribute("nombre","lblTipoIncremento" );
      ((Element)v.get(303)).setAttribute("alto","13" );
      ((Element)v.get(303)).setAttribute("filas","1" );
      ((Element)v.get(303)).setAttribute("valor","" );
      ((Element)v.get(303)).setAttribute("id","datosTitle" );
      ((Element)v.get(303)).setAttribute("cod","1963" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("width","100%" );
      ((Element)v.get(291)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:291   */

      /* Empieza nodo:306 / Elemento padre: 290   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(310)).setAttribute("nombre","lbldtBonoAnual" );
      ((Element)v.get(310)).setAttribute("alto","13" );
      ((Element)v.get(310)).setAttribute("filas","1" );
      ((Element)v.get(310)).setAttribute("valor","xxxxxxxxxxxxxx1" );
      ((Element)v.get(310)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(312)).setAttribute("width","25" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(314)).setAttribute("nombre","lbldtFormaCalculo" );
      ((Element)v.get(314)).setAttribute("alto","13" );
      ((Element)v.get(314)).setAttribute("filas","1" );
      ((Element)v.get(314)).setAttribute("valor","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(314)).setAttribute("id","datosCampos" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","25" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(318)).setAttribute("nombre","lbldtTipoIncremento" );
      ((Element)v.get(318)).setAttribute("alto","13" );
      ((Element)v.get(318)).setAttribute("filas","1" );
      ((Element)v.get(318)).setAttribute("valor","Porcentaje" );
      ((Element)v.get(318)).setAttribute("id","datosCampos" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(306)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:306   */

      /* Empieza nodo:321 / Elemento padre: 290   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("colspan","3" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","335" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:129   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:324 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:122   */

      /* Empieza nodo:326 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("table"));
      ((Element)v.get(331)).setAttribute("width","100%" );
      ((Element)v.get(331)).setAttribute("border","0" );
      ((Element)v.get(331)).setAttribute("align","center" );
      ((Element)v.get(331)).setAttribute("cellspacing","0" );
      ((Element)v.get(331)).setAttribute("cellpadding","0" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("class","botonera" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(334)).setAttribute("nombre","btnProductos" );
      ((Element)v.get(334)).setAttribute("ID","botonContenido" );
      ((Element)v.get(334)).setAttribute("tipo","html" );
      ((Element)v.get(334)).setAttribute("accion","" );
      ((Element)v.get(334)).setAttribute("estado","false" );
      ((Element)v.get(334)).setAttribute("cod","515" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 333   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(335)).setAttribute("nombre","btnConsultarMetas" );
      ((Element)v.get(335)).setAttribute("ID","botonContenido" );
      ((Element)v.get(335)).setAttribute("tipo","html" );
      ((Element)v.get(335)).setAttribute("accion","" );
      ((Element)v.get(335)).setAttribute("estado","false" );
      ((Element)v.get(335)).setAttribute("cod","1967" );
      ((Element)v.get(333)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:336 / Elemento padre: 326   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","12" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:326   */

      /* Empieza nodo:338 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("width","12" );
      ((Element)v.get(339)).setAttribute("align","center" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","12" );
      ((Element)v.get(340)).setAttribute("height","12" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("width","756" );
      ((Element)v.get(338)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).setAttribute("width","12" );
      ((Element)v.get(338)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","12" );
      ((Element)v.get(344)).setAttribute("height","1" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:338   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:345 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(345)).setAttribute("nombre","listado1" );
      ((Element)v.get(345)).setAttribute("ancho","532" );
      ((Element)v.get(345)).setAttribute("alto","317" );
      ((Element)v.get(345)).setAttribute("x","24" );
      ((Element)v.get(345)).setAttribute("y","130" );
      ((Element)v.get(345)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(345)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(346)).setAttribute("precarga","S" );
      ((Element)v.get(346)).setAttribute("conROver","S" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(347)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(347)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(347)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(347)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 346   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(348)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(348)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(348)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(348)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(346)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 346   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(349)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(349)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(346)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:346   */

      /* Empieza nodo:350 / Elemento padre: 345   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(345)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(351)).setAttribute("borde","1" );
      ((Element)v.get(351)).setAttribute("horizDatos","1" );
      ((Element)v.get(351)).setAttribute("horizCabecera","1" );
      ((Element)v.get(351)).setAttribute("vertical","0" );
      ((Element)v.get(351)).setAttribute("horizTitulo","1" );
      ((Element)v.get(351)).setAttribute("horizBase","1" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 350   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(352)).setAttribute("borde","#999999" );
      ((Element)v.get(352)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(352)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(352)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(352)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(352)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(352)).setAttribute("horizBase","#999999" );
      ((Element)v.get(350)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:350   */

      /* Empieza nodo:353 / Elemento padre: 345   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(353)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(353)).setAttribute("alto","22" );
      ((Element)v.get(353)).setAttribute("imgFondo","" );
      ((Element)v.get(353)).setAttribute("cod","00382" );
      ((Element)v.get(353)).setAttribute("ID","datosTitle" );
      ((Element)v.get(345)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 345   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(354)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(354)).setAttribute("alto","22" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(354)).setAttribute("imgFondo","" );
      ((Element)v.get(345)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 345   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(355)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(355)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(355)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(355)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(355)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(355)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(345)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("ancho","80" );
      ((Element)v.get(356)).setAttribute("minimizable","S" );
      ((Element)v.get(356)).setAttribute("minimizada","N" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("ancho","50" );
      ((Element)v.get(357)).setAttribute("minimizable","S" );
      ((Element)v.get(357)).setAttribute("minimizada","N" );
      ((Element)v.get(355)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("ancho","50" );
      ((Element)v.get(358)).setAttribute("minimizable","S" );
      ((Element)v.get(358)).setAttribute("minimizada","N" );
      ((Element)v.get(355)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("ancho","80" );
      ((Element)v.get(359)).setAttribute("minimizable","S" );
      ((Element)v.get(359)).setAttribute("minimizada","N" );
      ((Element)v.get(355)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:355   */

      /* Empieza nodo:360 / Elemento padre: 345   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(360)).setAttribute("alto","20" );
      ((Element)v.get(360)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(360)).setAttribute("imgFondo","" );
      ((Element)v.get(360)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(345)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("colFondo","" );
      ((Element)v.get(361)).setAttribute("ID","EstCab" );
      ((Element)v.get(361)).setAttribute("cod","1905" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("colFondo","" );
      ((Element)v.get(362)).setAttribute("ID","EstCab" );
      ((Element)v.get(362)).setAttribute("cod","9" );
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("colFondo","" );
      ((Element)v.get(363)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).setAttribute("cod","469" );
      ((Element)v.get(360)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 360   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("colFondo","" );
      ((Element)v.get(364)).setAttribute("ID","EstCab" );
      ((Element)v.get(364)).setAttribute("cod","1701" );
      ((Element)v.get(360)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:360   */

      /* Empieza nodo:365 / Elemento padre: 345   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(365)).setAttribute("alto","22" );
      ((Element)v.get(365)).setAttribute("accion","" );
      ((Element)v.get(365)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(365)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(365)).setAttribute("maxSel","-1" );
      ((Element)v.get(365)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(365)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(365)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(365)).setAttribute("onLoad","" );
      ((Element)v.get(365)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(345)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("tipo","texto" );
      ((Element)v.get(366)).setAttribute("ID","EstDat" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 365   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("tipo","texto" );
      ((Element)v.get(367)).setAttribute("ID","EstDat2" );
      ((Element)v.get(365)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 365   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("tipo","texto" );
      ((Element)v.get(368)).setAttribute("ID","EstDat" );
      ((Element)v.get(365)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 365   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("tipo","texto" );
      ((Element)v.get(369)).setAttribute("ID","EstDat2" );
      ((Element)v.get(365)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:365   */

      /* Empieza nodo:370 / Elemento padre: 345   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(345)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 345   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(371)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(371)).setAttribute("ancho","532" );
      ((Element)v.get(371)).setAttribute("sep","$" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(371)).setAttribute("x","24" );
      ((Element)v.get(371)).setAttribute("class","botonera" );
      ((Element)v.get(371)).setAttribute("y","364" );
      ((Element)v.get(371)).setAttribute("control","|" );
      ((Element)v.get(371)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(371)).setAttribute("rowset","" );
      ((Element)v.get(371)).setAttribute("cargainicial","N" );
      ((Element)v.get(345)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(372)).setAttribute("nombre","ret1" );
      ((Element)v.get(372)).setAttribute("x","49" );
      ((Element)v.get(372)).setAttribute("y","368" );
      ((Element)v.get(372)).setAttribute("ID","botonContenido" );
      ((Element)v.get(372)).setAttribute("img","retroceder_on" );
      ((Element)v.get(372)).setAttribute("tipo","0" );
      ((Element)v.get(372)).setAttribute("estado","false" );
      ((Element)v.get(372)).setAttribute("alt","" );
      ((Element)v.get(372)).setAttribute("codigo","" );
      ((Element)v.get(372)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 371   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(373)).setAttribute("nombre","ava1" );
      ((Element)v.get(373)).setAttribute("x","64" );
      ((Element)v.get(373)).setAttribute("y","368" );
      ((Element)v.get(373)).setAttribute("ID","botonContenido" );
      ((Element)v.get(373)).setAttribute("img","avanzar_on" );
      ((Element)v.get(373)).setAttribute("tipo","0" );
      ((Element)v.get(373)).setAttribute("estado","false" );
      ((Element)v.get(373)).setAttribute("alt","" );
      ((Element)v.get(373)).setAttribute("codigo","" );
      ((Element)v.get(373)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(371)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:371   */
      /* Termina nodo:345   */

      /* Empieza nodo:374 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(374)).setAttribute("nombre","primera1" );
      ((Element)v.get(374)).setAttribute("x","32" );
      ((Element)v.get(374)).setAttribute("y","368" );
      ((Element)v.get(374)).setAttribute("ID","botonContenido" );
      ((Element)v.get(374)).setAttribute("img","primera_on" );
      ((Element)v.get(374)).setAttribute("tipo","-2" );
      ((Element)v.get(374)).setAttribute("estado","false" );
      ((Element)v.get(374)).setAttribute("alt","" );
      ((Element)v.get(374)).setAttribute("codigo","" );
      ((Element)v.get(374)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(375)).setAttribute("nombre","separa" );
      ((Element)v.get(375)).setAttribute("x","71" );
      ((Element)v.get(375)).setAttribute("y","364" );
      ((Element)v.get(375)).setAttribute("ID","botonContenido" );
      ((Element)v.get(375)).setAttribute("img","separa_base" );
      ((Element)v.get(375)).setAttribute("tipo","0" );
      ((Element)v.get(375)).setAttribute("estado","false" );
      ((Element)v.get(375)).setAttribute("alt","" );
      ((Element)v.get(375)).setAttribute("codigo","" );
      ((Element)v.get(375)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(376)).setAttribute("nombre","listado2" );
      ((Element)v.get(376)).setAttribute("ancho","532" );
      ((Element)v.get(376)).setAttribute("alto","299" );
      ((Element)v.get(376)).setAttribute("x","24" );
      ((Element)v.get(376)).setAttribute("y","472" );
      ((Element)v.get(376)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(376)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(377)).setAttribute("precarga","S" );
      ((Element)v.get(377)).setAttribute("conROver","S" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(378)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(378)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(378)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(378)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 377   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(379)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(379)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(379)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(379)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(377)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 377   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(380)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(380)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(377)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:377   */

      /* Empieza nodo:381 / Elemento padre: 376   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(376)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(382)).setAttribute("borde","1" );
      ((Element)v.get(382)).setAttribute("horizDatos","1" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(382)).setAttribute("horizCabecera","1" );
      ((Element)v.get(382)).setAttribute("vertical","0" );
      ((Element)v.get(382)).setAttribute("horizTitulo","1" );
      ((Element)v.get(382)).setAttribute("horizBase","1" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 381   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(383)).setAttribute("borde","#999999" );
      ((Element)v.get(383)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(383)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(383)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(383)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(383)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(383)).setAttribute("horizBase","#999999" );
      ((Element)v.get(381)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:381   */

      /* Empieza nodo:384 / Elemento padre: 376   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(384)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(384)).setAttribute("alto","22" );
      ((Element)v.get(384)).setAttribute("imgFondo","" );
      ((Element)v.get(384)).setAttribute("cod","00317" );
      ((Element)v.get(384)).setAttribute("ID","datosTitle" );
      ((Element)v.get(376)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 376   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(385)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(385)).setAttribute("alto","22" );
      ((Element)v.get(385)).setAttribute("imgFondo","" );
      ((Element)v.get(376)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 376   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(386)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(386)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(386)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(386)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(386)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(386)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(376)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("ancho","80" );
      ((Element)v.get(387)).setAttribute("minimizable","S" );
      ((Element)v.get(387)).setAttribute("minimizada","N" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 386   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("ancho","50" );
      ((Element)v.get(388)).setAttribute("minimizable","S" );
      ((Element)v.get(388)).setAttribute("minimizada","N" );
      ((Element)v.get(386)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 386   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("ancho","50" );
      ((Element)v.get(389)).setAttribute("minimizable","S" );
      ((Element)v.get(389)).setAttribute("minimizada","N" );
      ((Element)v.get(386)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:386   */

      /* Empieza nodo:390 / Elemento padre: 376   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(390)).setAttribute("alto","20" );
      ((Element)v.get(390)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(390)).setAttribute("imgFondo","" );
      ((Element)v.get(390)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(376)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("colFondo","" );
      ((Element)v.get(391)).setAttribute("ID","EstCab" );
      ((Element)v.get(391)).setAttribute("align","center" );
      ((Element)v.get(391)).setAttribute("cod","1701" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Elemento padre:391 / Elemento actual: 392   */
      v.add(doc.createTextNode("Estatus venta"));
      ((Element)v.get(391)).appendChild((Text)v.get(392));

      /* Termina nodo Texto:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("colFondo","" );
      ((Element)v.get(393)).setAttribute("ID","EstCab" );
      ((Element)v.get(393)).setAttribute("cod","1175" );
      ((Element)v.get(390)).appendChild((Element)v.get(393));

      /* Elemento padre:393 / Elemento actual: 394   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(393)).appendChild((Text)v.get(394));

      /* Termina nodo Texto:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(395)).setAttribute("colFondo","" );
      ((Element)v.get(395)).setAttribute("ID","EstCab" );
      ((Element)v.get(395)).setAttribute("cod","1176" );
      ((Element)v.get(390)).appendChild((Element)v.get(395));

      /* Elemento padre:395 / Elemento actual: 396   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(395)).appendChild((Text)v.get(396));

      /* Termina nodo Texto:396   */
      /* Termina nodo:395   */
      /* Termina nodo:390   */

      /* Empieza nodo:397 / Elemento padre: 376   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(397)).setAttribute("alto","22" );
      ((Element)v.get(397)).setAttribute("accion","" );
      ((Element)v.get(397)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(397)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(397)).setAttribute("maxSel","-1" );
      ((Element)v.get(397)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(397)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(397)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(397)).setAttribute("onLoad","" );
      ((Element)v.get(397)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(376)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(398)).setAttribute("tipo","texto" );
      ((Element)v.get(398)).setAttribute("ID","EstDat" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 397   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("tipo","texto" );
      ((Element)v.get(399)).setAttribute("ID","EstDat2" );
      ((Element)v.get(397)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */

      /* Empieza nodo:400 / Elemento padre: 397   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(400)).setAttribute("tipo","texto" );
      ((Element)v.get(400)).setAttribute("ID","EstDat" );
      ((Element)v.get(397)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:397   */

      /* Empieza nodo:401 / Elemento padre: 376   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(376)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 376   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(402)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(402)).setAttribute("ancho","532" );
      ((Element)v.get(402)).setAttribute("sep","$" );
      ((Element)v.get(402)).setAttribute("x","24" );
      ((Element)v.get(402)).setAttribute("class","botonera" );
      ((Element)v.get(402)).setAttribute("y","688" );
      ((Element)v.get(402)).setAttribute("control","|" );
      ((Element)v.get(402)).setAttribute("conector","conectorSandra1" );
      ((Element)v.get(402)).setAttribute("rowset","" );
      ((Element)v.get(402)).setAttribute("cargainicial","N" );
      ((Element)v.get(376)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(403)).setAttribute("nombre","ret2" );
      ((Element)v.get(403)).setAttribute("x","49" );
      ((Element)v.get(403)).setAttribute("y","692" );
      ((Element)v.get(403)).setAttribute("ID","botonContenido" );
      ((Element)v.get(403)).setAttribute("img","retroceder_on" );
      ((Element)v.get(403)).setAttribute("tipo","0" );
      ((Element)v.get(403)).setAttribute("estado","false" );
      ((Element)v.get(403)).setAttribute("alt","" );
      ((Element)v.get(403)).setAttribute("codigo","" );
      ((Element)v.get(403)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 402   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(404)).setAttribute("nombre","ava2" );
      ((Element)v.get(404)).setAttribute("x","64" );
      ((Element)v.get(404)).setAttribute("y","692" );
      ((Element)v.get(404)).setAttribute("ID","botonContenido" );
      ((Element)v.get(404)).setAttribute("img","avanzar_on" );
      ((Element)v.get(404)).setAttribute("tipo","0" );
      ((Element)v.get(404)).setAttribute("estado","false" );
      ((Element)v.get(404)).setAttribute("alt","" );
      ((Element)v.get(404)).setAttribute("codigo","" );
      ((Element)v.get(404)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(402)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:402   */
      /* Termina nodo:376   */

      /* Empieza nodo:405 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(405)).setAttribute("nombre","primera2" );
      ((Element)v.get(405)).setAttribute("x","32" );
      ((Element)v.get(405)).setAttribute("y","692" );
      ((Element)v.get(405)).setAttribute("ID","botonContenido" );
      ((Element)v.get(405)).setAttribute("img","primera_on" );
      ((Element)v.get(405)).setAttribute("tipo","-2" );
      ((Element)v.get(405)).setAttribute("estado","false" );
      ((Element)v.get(405)).setAttribute("alt","" );
      ((Element)v.get(405)).setAttribute("codigo","" );
      ((Element)v.get(405)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(406)).setAttribute("nombre","separa2" );
      ((Element)v.get(406)).setAttribute("x","71" );
      ((Element)v.get(406)).setAttribute("y","688" );
      ((Element)v.get(406)).setAttribute("ID","botonContenido" );
      ((Element)v.get(406)).setAttribute("img","separa_base" );
      ((Element)v.get(406)).setAttribute("tipo","0" );
      ((Element)v.get(406)).setAttribute("estado","false" );
      ((Element)v.get(406)).setAttribute("alt","" );
      ((Element)v.get(406)).setAttribute("codigo","" );
      ((Element)v.get(406)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(407)).setAttribute("nombre","listado3" );
      ((Element)v.get(407)).setAttribute("ancho","532" );
      ((Element)v.get(407)).setAttribute("alto","301" );
      ((Element)v.get(407)).setAttribute("x","24" );
      ((Element)v.get(407)).setAttribute("y","924" );
      ((Element)v.get(407)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(407)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(408)).setAttribute("precarga","S" );
      ((Element)v.get(408)).setAttribute("conROver","S" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(409)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(409)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(409)).setAttribute("seleccionado","btnLista2M.gif" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(409)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 408   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(410)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(410)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(410)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(410)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(408)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 408   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(411)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(411)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(408)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:408   */

      /* Empieza nodo:412 / Elemento padre: 407   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(407)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(413)).setAttribute("borde","1" );
      ((Element)v.get(413)).setAttribute("horizDatos","1" );
      ((Element)v.get(413)).setAttribute("horizCabecera","1" );
      ((Element)v.get(413)).setAttribute("vertical","0" );
      ((Element)v.get(413)).setAttribute("horizTitulo","1" );
      ((Element)v.get(413)).setAttribute("horizBase","1" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 412   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(414)).setAttribute("borde","#999999" );
      ((Element)v.get(414)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(414)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(414)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(414)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(414)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(414)).setAttribute("horizBase","#999999" );
      ((Element)v.get(412)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:412   */

      /* Empieza nodo:415 / Elemento padre: 407   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(415)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(415)).setAttribute("alto","22" );
      ((Element)v.get(415)).setAttribute("imgFondo","" );
      ((Element)v.get(415)).setAttribute("cod","00385" );
      ((Element)v.get(415)).setAttribute("ID","datosTitle" );
      ((Element)v.get(407)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 407   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(416)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(416)).setAttribute("alto","22" );
      ((Element)v.get(416)).setAttribute("imgFondo","" );
      ((Element)v.get(407)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 407   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(417)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(417)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(417)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(417)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(417)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(417)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(407)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(418)).setAttribute("ancho","26" );
      ((Element)v.get(418)).setAttribute("minimizable","S" );
      ((Element)v.get(418)).setAttribute("minimizada","N" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 417   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("ancho","26" );
      ((Element)v.get(419)).setAttribute("minimizable","S" );
      ((Element)v.get(419)).setAttribute("minimizada","N" );
      ((Element)v.get(417)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 417   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("ancho","26" );
      ((Element)v.get(420)).setAttribute("minimizable","S" );
      ((Element)v.get(420)).setAttribute("minimizada","N" );
      ((Element)v.get(417)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:417   */

      /* Empieza nodo:421 / Elemento padre: 407   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(421)).setAttribute("alto","20" );
      ((Element)v.get(421)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(421)).setAttribute("imgFondo","" );
      ((Element)v.get(421)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(407)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(422)).setAttribute("colFondo","" );
      ((Element)v.get(422)).setAttribute("ID","EstCab" );
      ((Element)v.get(422)).setAttribute("cod","555" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 421   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("colFondo","" );
      ((Element)v.get(423)).setAttribute("ID","EstCab" );
      ((Element)v.get(423)).setAttribute("cod","145" );
      ((Element)v.get(421)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(424)).setAttribute("colFondo","" );
      ((Element)v.get(424)).setAttribute("ID","EstCab" );
      ((Element)v.get(424)).setAttribute("cod","1740" );
      ((Element)v.get(421)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:421   */

      /* Empieza nodo:425 / Elemento padre: 407   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(425)).setAttribute("alto","22" );
      ((Element)v.get(425)).setAttribute("accion","" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(425)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(425)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(425)).setAttribute("maxSel","-1" );
      ((Element)v.get(425)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(425)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(425)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(425)).setAttribute("onLoad","" );
      ((Element)v.get(425)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(407)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(426)).setAttribute("tipo","texto" );
      ((Element)v.get(426)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */

      /* Empieza nodo:427 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(427)).setAttribute("tipo","texto" );
      ((Element)v.get(427)).setAttribute("ID","EstDat2" );
      ((Element)v.get(425)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(428)).setAttribute("tipo","texto" );
      ((Element)v.get(428)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:425   */

      /* Empieza nodo:429 / Elemento padre: 407   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(407)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 407   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(430)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(430)).setAttribute("ancho","726" );
      ((Element)v.get(430)).setAttribute("sep","$" );
      ((Element)v.get(430)).setAttribute("x","24" );
      ((Element)v.get(430)).setAttribute("class","botonera" );
      ((Element)v.get(430)).setAttribute("y","1142" );
      ((Element)v.get(430)).setAttribute("control","|" );
      ((Element)v.get(430)).setAttribute("conector","conectorSandra2" );
      ((Element)v.get(430)).setAttribute("rowset","" );
      ((Element)v.get(430)).setAttribute("cargainicial","N" );
      ((Element)v.get(407)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(431)).setAttribute("nombre","ret3" );
      ((Element)v.get(431)).setAttribute("x","49" );
      ((Element)v.get(431)).setAttribute("y","1146" );
      ((Element)v.get(431)).setAttribute("ID","botonContenido" );
      ((Element)v.get(431)).setAttribute("img","retroceder_on" );
      ((Element)v.get(431)).setAttribute("tipo","0" );
      ((Element)v.get(431)).setAttribute("estado","false" );
      ((Element)v.get(431)).setAttribute("alt","" );
      ((Element)v.get(431)).setAttribute("codigo","" );
      ((Element)v.get(431)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 430   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(432)).setAttribute("nombre","ava3" );
      ((Element)v.get(432)).setAttribute("x","64" );
      ((Element)v.get(432)).setAttribute("y","1146" );
      ((Element)v.get(432)).setAttribute("ID","botonContenido" );
      ((Element)v.get(432)).setAttribute("img","avanzar_on" );
      ((Element)v.get(432)).setAttribute("tipo","0" );
      ((Element)v.get(432)).setAttribute("estado","false" );
      ((Element)v.get(432)).setAttribute("alt","" );
      ((Element)v.get(432)).setAttribute("codigo","" );
      ((Element)v.get(432)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(430)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:430   */
      /* Termina nodo:407   */

      /* Empieza nodo:433 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(433)).setAttribute("nombre","primera3" );
      ((Element)v.get(433)).setAttribute("x","32" );
      ((Element)v.get(433)).setAttribute("y","1146" );
      ((Element)v.get(433)).setAttribute("ID","botonContenido" );
      ((Element)v.get(433)).setAttribute("img","primera_on" );
      ((Element)v.get(433)).setAttribute("tipo","-2" );
      ((Element)v.get(433)).setAttribute("estado","false" );
      ((Element)v.get(433)).setAttribute("alt","" );
      ((Element)v.get(433)).setAttribute("codigo","" );
      ((Element)v.get(433)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(434)).setAttribute("nombre","separa3" );
      ((Element)v.get(434)).setAttribute("x","71" );
      ((Element)v.get(434)).setAttribute("y","1142" );
      ((Element)v.get(434)).setAttribute("ID","botonContenido" );
      ((Element)v.get(434)).setAttribute("img","separa_base" );
      ((Element)v.get(434)).setAttribute("tipo","0" );
      ((Element)v.get(434)).setAttribute("estado","false" );
      ((Element)v.get(434)).setAttribute("alt","" );
      ((Element)v.get(434)).setAttribute("codigo","" );
      ((Element)v.get(434)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:7   */


   }

}
