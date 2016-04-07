
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_solicitudes_bloqueadas_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_solicitudes_bloqueadas_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0763" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r    configurarMenuSecundario('formulario');\r    fMostrarMensajeError();  \r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r                   \r    eval (ON_RSZ);  \r\r   }\r    function poneMano(nombre) {\r      var nombre = document.getElementById(nombre);\r      nombre.style.cursor = \"hand\";\r    }     \r     function onClickPestana(nroPestana){\r        if (nroPestana==\"1\"){\r           set('formulario.accion','Cliente');\r        } else if (nroPestana==\"2\"){        \r           set('formulario.accion','Solicitud');\r        } else if (nroPestana==\"3\"){        \r           set('formulario.accion','Cuenta Corriente');\r        } else if (nroPestana==\"4\"){        \r           set('formulario.accion','Cobranza');\r        } else if (nroPestana==\"5\"){        \r           set('formulario.accion','Credito');\r        } else if (nroPestana==\"6\"){        \r           set('formulario.accion','Solicitudes Bloqueadas');\r        } \r        set('formulario.conectorAction', 'CARHistorialCredito');\r        enviaSICC('formulario');       \r     }\r    function fVolver(){\r      window.close();\r    }       \r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","CARHistorialCredito" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","idioma" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","pais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hLongCliente" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(16)).setAttribute("nombre","capaPest" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("table"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("height","100%" );
      ((Element)v.get(17)).setAttribute("border","0" );
      ((Element)v.get(17)).setAttribute("align","center" );
      ((Element)v.get(17)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).setAttribute("cellspacing","0" );
      ((Element)v.get(17)).setAttribute("class","menu4" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(19)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","30" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(21)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Elemento padre:21 / Elemento actual: 22   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createTextNode(" "));
      ((Element)v.get(21)).appendChild((Text)v.get(22));

      /* Termina nodo Texto:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","10" );
      ((Element)v.get(23)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(23)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","10" );
      ((Element)v.get(24)).setAttribute("height","8" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","75" );
      ((Element)v.get(25)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(25)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("table"));
      ((Element)v.get(26)).setAttribute("width","75" );
      ((Element)v.get(26)).setAttribute("border","1" );
      ((Element)v.get(26)).setAttribute("align","center" );
      ((Element)v.get(26)).setAttribute("cellpadding","1" );
      ((Element)v.get(26)).setAttribute("cellspacing","0" );
      ((Element)v.get(26)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).setAttribute("align","center" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("id","pestana1" );
      ((Element)v.get(28)).setAttribute("onmouseover","poneMano('pestana1');" );
      ((Element)v.get(28)).setAttribute("onclick","onClickPestana('1');" );
      ((Element)v.get(28)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(29)).setAttribute("nombre","lblCliente" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("filas","1" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(29)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(29)).setAttribute("cod","1471" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:30 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","10" );
      ((Element)v.get(30)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","10" );
      ((Element)v.get(31)).setAttribute("height","8" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","20" );
      ((Element)v.get(32)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(32)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","75" );
      ((Element)v.get(33)).setAttribute("border","1" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellpadding","1" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("id","pestana2" );
      ((Element)v.get(35)).setAttribute("onmouseover","poneMano('pestana2');" );
      ((Element)v.get(35)).setAttribute("onclick","onClickPestana('2');" );
      ((Element)v.get(35)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(36)).setAttribute("nombre","lblSolicitud" );
      ((Element)v.get(36)).setAttribute("alto","13" );
      ((Element)v.get(36)).setAttribute("filas","1" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(36)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(36)).setAttribute("cod","990" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:37 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","10" );
      ((Element)v.get(37)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","10" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 18   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","20" );
      ((Element)v.get(39)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(39)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","75" );
      ((Element)v.get(40)).setAttribute("border","1" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("cellpadding","1" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("id","pestana3" );
      ((Element)v.get(42)).setAttribute("onmouseover","poneMano('pestana3');" );
      ((Element)v.get(42)).setAttribute("onclick","onClickPestana('3');" );
      ((Element)v.get(42)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblCuentaCorriente" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(43)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(43)).setAttribute("cod","636" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:44 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","10" );
      ((Element)v.get(44)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","10" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","20" );
      ((Element)v.get(46)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(46)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","75" );
      ((Element)v.get(47)).setAttribute("border","1" );
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(47)).setAttribute("cellpadding","1" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("id","pestana4" );
      ((Element)v.get(49)).setAttribute("onmouseover","poneMano('pestana4');" );
      ((Element)v.get(49)).setAttribute("onclick","onClickPestana('4');" );
      ((Element)v.get(49)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblCobranza" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(50)).setAttribute("cod","00345" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:51 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","10" );
      ((Element)v.get(51)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","10" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","20" );
      ((Element)v.get(53)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","75" );
      ((Element)v.get(54)).setAttribute("border","1" );
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(54)).setAttribute("cellpadding","1" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("bordercolor","#496A9A" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("id","pestana5" );
      ((Element)v.get(56)).setAttribute("onmouseover","poneMano('pestana5');" );
      ((Element)v.get(56)).setAttribute("onclick","onClickPestana('5');" );
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblCredito" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(57)).setAttribute("cod","00649" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:58 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","10" );
      ((Element)v.get(58)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","10" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","20" );
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("table"));
      ((Element)v.get(61)).setAttribute("width","75" );
      ((Element)v.get(61)).setAttribute("border","1" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("cellpadding","1" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(61)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("id","pestana6" );
      ((Element)v.get(63)).setAttribute("onmouseover","poneMano('pestana6');" );
      ((Element)v.get(63)).setAttribute("onclick","onClickPestana('6');" );
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblSolicitudesBloqueadas" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(64)).setAttribute("cod","00463" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:65 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","16" );
      ((Element)v.get(65)).setAttribute("class","menu5texto" );
      ((Element)v.get(18)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:67 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(67)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(67)).setAttribute("x","1" );
      ((Element)v.get(67)).setAttribute("y","20" );
      ((Element)v.get(6)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","524" );
      ((Element)v.get(71)).setAttribute("height","12" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:72 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(72)).setAttribute("nombre","listado1" );
      ((Element)v.get(72)).setAttribute("ancho","500" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(72)).setAttribute("alto","317" );
      ((Element)v.get(72)).setAttribute("x","12" );
      ((Element)v.get(72)).setAttribute("y","35" );
      ((Element)v.get(72)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(72)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(73)).setAttribute("precarga","S" );
      ((Element)v.get(73)).setAttribute("conROver","S" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(74)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(74)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(74)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(74)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 73   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(75)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(75)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(75)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(75)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(73)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(76)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(76)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:73   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(72)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(78)).setAttribute("borde","1" );
      ((Element)v.get(78)).setAttribute("horizDatos","1" );
      ((Element)v.get(78)).setAttribute("horizCabecera","1" );
      ((Element)v.get(78)).setAttribute("vertical","0" );
      ((Element)v.get(78)).setAttribute("horizTitulo","1" );
      ((Element)v.get(78)).setAttribute("horizBase","1" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 77   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(79)).setAttribute("borde","#999999" );
      ((Element)v.get(79)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(79)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(79)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(79)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(79)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(79)).setAttribute("horizBase","#999999" );
      ((Element)v.get(77)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:77   */

      /* Empieza nodo:80 / Elemento padre: 72   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(80)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(80)).setAttribute("alto","22" );
      ((Element)v.get(80)).setAttribute("imgFondo","" );
      ((Element)v.get(80)).setAttribute("cod","00659" );
      ((Element)v.get(80)).setAttribute("ID","datosTitle" );
      ((Element)v.get(72)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 72   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(81)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(81)).setAttribute("alto","22" );
      ((Element)v.get(81)).setAttribute("imgFondo","" );
      ((Element)v.get(72)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 72   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(82)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(82)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(82)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(82)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(82)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(82)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(72)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("ancho","100" );
      ((Element)v.get(83)).setAttribute("minimizable","S" );
      ((Element)v.get(83)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("ancho","100" );
      ((Element)v.get(84)).setAttribute("minimizable","S" );
      ((Element)v.get(84)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("ancho","100" );
      ((Element)v.get(85)).setAttribute("minimizable","S" );
      ((Element)v.get(85)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("ancho","100" );
      ((Element)v.get(86)).setAttribute("minimizable","S" );
      ((Element)v.get(86)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("ancho","100" );
      ((Element)v.get(87)).setAttribute("minimizable","S" );
      ((Element)v.get(87)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 82   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("ancho","130" );
      ((Element)v.get(88)).setAttribute("minimizable","S" );
      ((Element)v.get(88)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("ancho","140" );
      ((Element)v.get(89)).setAttribute("minimizable","S" );
      ((Element)v.get(89)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("ancho","140" );
      ((Element)v.get(90)).setAttribute("minimizable","S" );
      ((Element)v.get(90)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("ancho","140" );
      ((Element)v.get(91)).setAttribute("minimizable","S" );
      ((Element)v.get(91)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","140" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","100" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","120" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","100" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("ancho","100" );
      ((Element)v.get(96)).setAttribute("minimizable","S" );
      ((Element)v.get(96)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","100" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(82)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:82   */

      /* Empieza nodo:98 / Elemento padre: 72   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(98)).setAttribute("alto","20" );
      ((Element)v.get(98)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(98)).setAttribute("imgFondo","" );
      ((Element)v.get(98)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(72)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("colFondo","" );
      ((Element)v.get(99)).setAttribute("ID","EstCab" );
      ((Element)v.get(99)).setAttribute("cod","415" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("colFondo","" );
      ((Element)v.get(100)).setAttribute("ID","EstCab" );
      ((Element)v.get(100)).setAttribute("cod","424" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("cod","276" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("colFondo","" );
      ((Element)v.get(102)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).setAttribute("cod","188" );
      ((Element)v.get(98)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(103)).setAttribute("cod","2859" );
      ((Element)v.get(98)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("colFondo","" );
      ((Element)v.get(104)).setAttribute("ID","EstCab" );
      ((Element)v.get(104)).setAttribute("cod","1166" );
      ((Element)v.get(98)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("cod","1160" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(98)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("colFondo","" );
      ((Element)v.get(106)).setAttribute("ID","EstCab" );
      ((Element)v.get(106)).setAttribute("cod","1161" );
      ((Element)v.get(98)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("colFondo","" );
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(107)).setAttribute("cod","1162" );
      ((Element)v.get(98)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("colFondo","" );
      ((Element)v.get(108)).setAttribute("ID","EstCab" );
      ((Element)v.get(108)).setAttribute("cod","1163" );
      ((Element)v.get(98)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("cod","2860" );
      ((Element)v.get(98)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("colFondo","" );
      ((Element)v.get(110)).setAttribute("ID","EstCab" );
      ((Element)v.get(110)).setAttribute("cod","2861" );
      ((Element)v.get(98)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","596" );
      ((Element)v.get(98)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("cod","2251" );
      ((Element)v.get(98)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","928" );
      ((Element)v.get(98)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:98   */

      /* Empieza nodo:114 / Elemento padre: 72   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(114)).setAttribute("alto","22" );
      ((Element)v.get(114)).setAttribute("accion","" );
      ((Element)v.get(114)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(114)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(114)).setAttribute("maxSel","-1" );
      ((Element)v.get(114)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(114)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(114)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(114)).setAttribute("onLoad","" );
      ((Element)v.get(114)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(72)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","texto" );
      ((Element)v.get(117)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("tipo","texto" );
      ((Element)v.get(118)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("tipo","texto" );
      ((Element)v.get(119)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("tipo","texto" );
      ((Element)v.get(120)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("tipo","texto" );
      ((Element)v.get(121)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(124)).setAttribute("tipo","texto" );
      ((Element)v.get(124)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat2" );
      ((Element)v.get(114)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 114   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat" );
      ((Element)v.get(114)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:114   */

      /* Empieza nodo:130 / Elemento padre: 72   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(72)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 72   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(131)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(131)).setAttribute("ancho","404" );
      ((Element)v.get(131)).setAttribute("sep","$" );
      ((Element)v.get(131)).setAttribute("x","12" );
      ((Element)v.get(131)).setAttribute("class","botonera" );
      ((Element)v.get(131)).setAttribute("y","329" );
      ((Element)v.get(131)).setAttribute("control","|" );
      ((Element)v.get(131)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(131)).setAttribute("rowset","" );
      ((Element)v.get(131)).setAttribute("cargainicial","N" );
      ((Element)v.get(72)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:72   */

      /* Empieza nodo:132 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(132)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(132)).setAttribute("alto","12" );
      ((Element)v.get(132)).setAttribute("ancho","100%" );
      ((Element)v.get(132)).setAttribute("colorf","" );
      ((Element)v.get(132)).setAttribute("borde","0" );
      ((Element)v.get(132)).setAttribute("imagenf","" );
      ((Element)v.get(132)).setAttribute("repeat","" );
      ((Element)v.get(132)).setAttribute("padding","" );
      ((Element)v.get(132)).setAttribute("visibilidad","visible" );
      ((Element)v.get(132)).setAttribute("contravsb","" );
      ((Element)v.get(132)).setAttribute("x","0" );
      ((Element)v.get(132)).setAttribute("y","329" );
      ((Element)v.get(132)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:6   */


   }

}
