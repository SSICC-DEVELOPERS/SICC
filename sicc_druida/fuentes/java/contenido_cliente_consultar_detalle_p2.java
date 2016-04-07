
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cliente_consultar_detalle_p2  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2070(doc);
         

      getXML2160(doc);
         

      getXML2250(doc);
         

      getXML2340(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_cliente_consultar_detalle_p2" );
      ((Element)v.get(0)).setAttribute("cod","0410" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Clientes detalle" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar Clientes detalle" );
      ((Element)v.get(0)).setAttribute("onload","init();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","contenido_cliente_consultar_detalle_p2.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frmInsertarCliente" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(4)).setAttribute("nombre","accion" );
      ((Element)v.get(4)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","hidSexo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","hidTratamiento" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hidFormaPago" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hidNacionalidad" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidEstadoCivil" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidNSE" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidNivelEstudios" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidCicloVidaFamiliar" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidCorresp" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidInbound" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidTipoClienteContactado" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidPaisClienteContactado" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hFechaNacimiento" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hchkIndActivo" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(3)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(23)).setAttribute("nombre","capaFormulario2" );
      ((Element)v.get(23)).setAttribute("x","0" );
      ((Element)v.get(23)).setAttribute("y","0" );
      ((Element)v.get(23)).setAttribute("alto","100%" );
      ((Element)v.get(23)).setAttribute("ancho","100%" );
      ((Element)v.get(23)).setAttribute("visibilidad","" );
      ((Element)v.get(3)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("align","center" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","750" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("height","1" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:25   */

      /* Empieza nodo:32 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(37)).setAttribute("class","legend" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(38)).setAttribute("nombre","lbl2TitDatosBasicos" );
      ((Element)v.get(38)).setAttribute("alto","13" );
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(38)).setAttribute("cod","00142" );
      ((Element)v.get(38)).setAttribute("id","legend" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","center" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
      ((Element)v.get(42)).setAttribute("width","708" );
      ((Element)v.get(42)).setAttribute("border","0" );
      ((Element)v.get(42)).setAttribute("align","left" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
      ((Element)v.get(42)).setAttribute("cellpadding","0" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("colspan","4" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:46 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lbl2Apellido1" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","datosTitle" );
      ((Element)v.get(50)).setAttribute("cod","16" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","25" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lbl2Apellido2" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","17" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","25" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lbl2ApellidoCasada" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","18" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lbl2IndActivo" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","905" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(46)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:46   */

      /* Empieza nodo:65 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lbl2dtApellido1" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lbl2dtApellido2" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lbl2dtApellidoCasada" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(81)).setAttribute("check","" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("msjreq","" );
      ((Element)v.get(81)).setAttribute("nombre","ckIndActivo" );
      ((Element)v.get(81)).setAttribute("onclick","" );
      ((Element)v.get(81)).setAttribute("onfocus","" );
      ((Element)v.get(81)).setAttribute("readonly","" );
      ((Element)v.get(81)).setAttribute("req","" );
      ((Element)v.get(81)).setAttribute("tabindex","1" );
      ((Element)v.get(81)).setAttribute("texto","" );
      ((Element)v.get(81)).setAttribute("validacion","" );
      ((Element)v.get(81)).setAttribute("onshtab","" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(65)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:65   */

      /* Empieza nodo:84 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("colspan","4" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:87 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("table"));
      ((Element)v.get(89)).setAttribute("width","708" );
      ((Element)v.get(89)).setAttribute("border","0" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("align","left" );
      ((Element)v.get(89)).setAttribute("cellspacing","0" );
      ((Element)v.get(89)).setAttribute("cellpadding","0" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lbl2Nombre1" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","93" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lbl2Nombre2" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","94" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lbl2Tratamiento" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","757" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lbl2Sexo" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","1122" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:90   */

      /* Empieza nodo:109 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lbl2dtNombre1" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","25" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lbl2dtNombre2" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","25" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lbl2dtTratamiento" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","25" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(125)).setAttribute("nombre","lbl2dtSexo" );
      ((Element)v.get(125)).setAttribute("alto","13" );
      ((Element)v.get(125)).setAttribute("filas","1" );
      ((Element)v.get(125)).setAttribute("valor","" );
      ((Element)v.get(125)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:109   */

      /* Empieza nodo:128 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("colspan","4" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:131 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("table"));
      ((Element)v.get(133)).setAttribute("width","708" );
      ((Element)v.get(133)).setAttribute("border","0" );
      ((Element)v.get(133)).setAttribute("align","left" );
      ((Element)v.get(133)).setAttribute("cellspacing","0" );
      ((Element)v.get(133)).setAttribute("cellpadding","0" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lbl2FormaPago" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(138)).setAttribute("id","datosTitle" );
      ((Element)v.get(138)).setAttribute("cod","541" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","25" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lbl2FechaIngreso" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","499" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(134)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:134   */

      /* Empieza nodo:145 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(149)).setAttribute("nombre","lbl2dtFormaPago" );
      ((Element)v.get(149)).setAttribute("alto","13" );
      ((Element)v.get(149)).setAttribute("filas","1" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(149)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","25" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(153)).setAttribute("nombre","lbl2dtFechaIngreso" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("filas","1" );
      ((Element)v.get(153)).setAttribute("valor","" );
      ((Element)v.get(153)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(145)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:145   */

      /* Empieza nodo:156 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("colspan","4" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:39   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:159 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","12" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:32   */

      /* Empieza nodo:161 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(162)).setAttribute("align","center" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(163)).setAttribute("height","15" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","750" );
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(161)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(167)).setAttribute("height","15" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:161   */

      /* Empieza nodo:168 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(173)).setAttribute("class","legend" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lbl2TitDatosAdiccionales" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("cod","0052" );
      ((Element)v.get(174)).setAttribute("id","legend" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("table"));
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(175)).setAttribute("border","0" );
      ((Element)v.get(175)).setAttribute("align","center" );
      ((Element)v.get(175)).setAttribute("cellspacing","0" );
      ((Element)v.get(175)).setAttribute("cellpadding","0" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("table"));
      ((Element)v.get(178)).setAttribute("width","708" );
      ((Element)v.get(178)).setAttribute("border","0" );
      ((Element)v.get(178)).setAttribute("align","left" );
      ((Element)v.get(178)).setAttribute("cellspacing","0" );
      ((Element)v.get(178)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("colspan","4" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lbl2FechaNacimiento" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).setAttribute("cod","877" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lbl2CodEmpleado" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("id","datosTitle" );
      ((Element)v.get(190)).setAttribute("cod","1336" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","25" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(194)).setAttribute("nombre","lbl2Nacionalidad" );
      ((Element)v.get(194)).setAttribute("alto","13" );
      ((Element)v.get(194)).setAttribute("filas","1" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("id","datosTitle" );
      ((Element)v.get(194)).setAttribute("cod","1095" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(198)).setAttribute("nombre","lbl2Edad" );
      ((Element)v.get(198)).setAttribute("alto","13" );
      ((Element)v.get(198)).setAttribute("filas","1" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("id","datosTitle" );
      ((Element)v.get(198)).setAttribute("cod","1074" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","25" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lbl2EstadoCivil" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("id","datosTitle" );
      ((Element)v.get(202)).setAttribute("cod","1076" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(182)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:182   */

      /* Empieza nodo:205 / Elemento padre: 178   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lbl2dtFechaNacimiento" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("id","datosCampos" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","25" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lbl2dtCodEmpleado" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lbl2dtNacionalidad" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(221)).setAttribute("nombre","lbl2dtEdad" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(221)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(225)).setAttribute("nombre","lbl2dtEstadoCivil" );
      ((Element)v.get(225)).setAttribute("alto","13" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(225)).setAttribute("id","datosCampos" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("width","100%" );
      ((Element)v.get(205)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:205   */

      /* Empieza nodo:228 / Elemento padre: 178   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("colspan","4" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:231 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("table"));
      ((Element)v.get(233)).setAttribute("width","708" );
      ((Element)v.get(233)).setAttribute("border","0" );
      ((Element)v.get(233)).setAttribute("align","left" );
      ((Element)v.get(233)).setAttribute("cellspacing","0" );
      ((Element)v.get(233)).setAttribute("cellpadding","0" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lbl2Ocupacion" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).setAttribute("cod","1109" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","25" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(242)).setAttribute("nombre","lbl2Profesion" );
      ((Element)v.get(242)).setAttribute("alto","13" );
      ((Element)v.get(242)).setAttribute("filas","1" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(242)).setAttribute("id","datosTitle" );
      ((Element)v.get(242)).setAttribute("cod","1117" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(234)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:234   */

      /* Empieza nodo:245 / Elemento padre: 233   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(249)).setAttribute("nombre","lbl2dtOcupacion" );
      ((Element)v.get(249)).setAttribute("alto","13" );
      ((Element)v.get(249)).setAttribute("filas","1" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(249)).setAttribute("id","datosCampos" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","25" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 245   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(253)).setAttribute("nombre","lbl2dtProfesion" );
      ((Element)v.get(253)).setAttribute("alto","13" );
      ((Element)v.get(253)).setAttribute("filas","1" );
      ((Element)v.get(253)).setAttribute("valor","" );
      ((Element)v.get(253)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(245)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:245   */

      /* Empieza nodo:256 / Elemento padre: 233   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("colspan","4" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:259 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("table"));
      ((Element)v.get(261)).setAttribute("width","708" );
      ((Element)v.get(261)).setAttribute("border","0" );
      ((Element)v.get(261)).setAttribute("align","left" );
      ((Element)v.get(261)).setAttribute("cellspacing","0" );
      ((Element)v.get(261)).setAttribute("cellpadding","0" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(266)).setAttribute("nombre","lbl2CentroTrabajo" );
      ((Element)v.get(266)).setAttribute("alto","13" );
      ((Element)v.get(266)).setAttribute("filas","1" );
      ((Element)v.get(266)).setAttribute("valor","" );
      ((Element)v.get(266)).setAttribute("id","datosTitle" );
      ((Element)v.get(266)).setAttribute("cod","1055" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","25" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(270)).setAttribute("nombre","lbl2CargoDesempena" );
      ((Element)v.get(270)).setAttribute("alto","13" );
      ((Element)v.get(270)).setAttribute("filas","1" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("id","datosTitle" );
      ((Element)v.get(270)).setAttribute("cod","1053" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).setAttribute("width","100%" );
      ((Element)v.get(262)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:262   */

      /* Empieza nodo:273 / Elemento padre: 261   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(261)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(275)).setAttribute("height","8" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(277)).setAttribute("nombre","lbl2dtCentroTrabajo" );
      ((Element)v.get(277)).setAttribute("alto","13" );
      ((Element)v.get(277)).setAttribute("filas","1" );
      ((Element)v.get(277)).setAttribute("valor","" );
      ((Element)v.get(277)).setAttribute("id","datosCampos" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","25" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(281)).setAttribute("nombre","lbl2dtCargoDesempena" );
      ((Element)v.get(281)).setAttribute("alto","13" );
      ((Element)v.get(281)).setAttribute("filas","1" );
      ((Element)v.get(281)).setAttribute("valor","" );
      ((Element)v.get(281)).setAttribute("id","datosCampos" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).setAttribute("width","100%" );
      ((Element)v.get(273)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:273   */

      /* Empieza nodo:284 / Elemento padre: 261   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(261)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("colspan","4" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","8" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:287 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("table"));
      ((Element)v.get(289)).setAttribute("width","708" );
      ((Element)v.get(289)).setAttribute("border","0" );
      ((Element)v.get(289)).setAttribute("align","left" );
      ((Element)v.get(289)).setAttribute("cellspacing","0" );
      ((Element)v.get(289)).setAttribute("cellpadding","0" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(294)).setAttribute("nombre","lbl2NivelEstudios" );
      ((Element)v.get(294)).setAttribute("alto","13" );
      ((Element)v.get(294)).setAttribute("filas","1" );
      ((Element)v.get(294)).setAttribute("valor","" );
      ((Element)v.get(294)).setAttribute("id","datosTitle" );
      ((Element)v.get(294)).setAttribute("cod","1106" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(298)).setAttribute("nombre","lbl2CentroEstudios" );
      ((Element)v.get(298)).setAttribute("alto","13" );
      ((Element)v.get(298)).setAttribute("filas","1" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(298)).setAttribute("id","datosTitle" );
      ((Element)v.get(298)).setAttribute("cod","1054" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","25" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(302)).setAttribute("nombre","lbl2NHijos" );
      ((Element)v.get(302)).setAttribute("alto","13" );
      ((Element)v.get(302)).setAttribute("filas","1" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(302)).setAttribute("id","datosTitle" );
      ((Element)v.get(302)).setAttribute("cod","1108" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","25" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(306)).setAttribute("nombre","lbl2NPersonasDependientes" );
      ((Element)v.get(306)).setAttribute("alto","13" );
      ((Element)v.get(306)).setAttribute("filas","1" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("id","datosTitle" );
      ((Element)v.get(306)).setAttribute("cod","1337" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(290)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:290   */

      /* Empieza nodo:309 / Elemento padre: 289   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(289)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(313)).setAttribute("nombre","lbl2dtNivelEstudios" );
      ((Element)v.get(313)).setAttribute("alto","13" );
      ((Element)v.get(313)).setAttribute("filas","1" );
      ((Element)v.get(313)).setAttribute("valor","" );
      ((Element)v.get(313)).setAttribute("id","datosCampos" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","25" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(317)).setAttribute("nombre","lbl2dtCentroEstudios" );
      ((Element)v.get(317)).setAttribute("alto","13" );
      ((Element)v.get(317)).setAttribute("filas","1" );
      ((Element)v.get(317)).setAttribute("valor","" );
      ((Element)v.get(317)).setAttribute("id","datosCampos" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","25" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(321)).setAttribute("nombre","lbl2dtNHijos" );
      ((Element)v.get(321)).setAttribute("alto","13" );
      ((Element)v.get(321)).setAttribute("filas","1" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(321)).setAttribute("valor","" );
      ((Element)v.get(321)).setAttribute("id","datosCampos" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","25" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(325)).setAttribute("nombre","lbl2dtNPersonasDependientes" );
      ((Element)v.get(325)).setAttribute("alto","13" );
      ((Element)v.get(325)).setAttribute("filas","1" );
      ((Element)v.get(325)).setAttribute("valor","" );
      ((Element)v.get(325)).setAttribute("id","datosCampos" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("width","100%" );
      ((Element)v.get(309)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","8" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:309   */

      /* Empieza nodo:328 / Elemento padre: 289   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(289)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("colspan","4" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:331 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("table"));
      ((Element)v.get(333)).setAttribute("width","708" );
      ((Element)v.get(333)).setAttribute("border","0" );
      ((Element)v.get(333)).setAttribute("align","left" );
      ((Element)v.get(333)).setAttribute("cellspacing","0" );
      ((Element)v.get(333)).setAttribute("cellpadding","0" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(338)).setAttribute("nombre","lbl2NivelSocioEconomico" );
      ((Element)v.get(338)).setAttribute("alto","13" );
      ((Element)v.get(338)).setAttribute("filas","1" );
      ((Element)v.get(338)).setAttribute("valor","" );
      ((Element)v.get(338)).setAttribute("id","datosTitle" );
      ((Element)v.get(338)).setAttribute("cod","1107" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","25" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(342)).setAttribute("nombre","lbl2CicloVidaFamiliar" );
      ((Element)v.get(342)).setAttribute("alto","13" );
      ((Element)v.get(342)).setAttribute("filas","1" );
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("id","datosTitle" );
      ((Element)v.get(342)).setAttribute("cod","1056" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","25" );
      ((Element)v.get(344)).setAttribute("height","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(346)).setAttribute("nombre","lbl2DeseaCorrespondencia" );
      ((Element)v.get(346)).setAttribute("alto","13" );
      ((Element)v.get(346)).setAttribute("filas","1" );
      ((Element)v.get(346)).setAttribute("valor","" );
      ((Element)v.get(346)).setAttribute("id","datosTitle" );
      ((Element)v.get(346)).setAttribute("cod","1050" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","25" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(350)).setAttribute("nombre","lbl2ImporteIngresoFamiliar" );
      ((Element)v.get(350)).setAttribute("alto","13" );
      ((Element)v.get(350)).setAttribute("filas","1" );
      ((Element)v.get(350)).setAttribute("valor","" );
      ((Element)v.get(350)).setAttribute("id","datosTitle" );
      ((Element)v.get(350)).setAttribute("cod","1080" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("width","100%" );
      ((Element)v.get(334)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","8" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:334   */

      /* Empieza nodo:353 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(357)).setAttribute("nombre","lbl2dtNivelSocioEconomico" );
      ((Element)v.get(357)).setAttribute("alto","13" );
      ((Element)v.get(357)).setAttribute("filas","1" );
      ((Element)v.get(357)).setAttribute("valor","x1" );
      ((Element)v.get(357)).setAttribute("id","datosCampos" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","25" );
      ((Element)v.get(359)).setAttribute("height","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(361)).setAttribute("nombre","lbl2dtCicloVidaFamiliar" );
      ((Element)v.get(361)).setAttribute("alto","13" );
      ((Element)v.get(361)).setAttribute("filas","1" );
      ((Element)v.get(361)).setAttribute("valor","x1" );
      ((Element)v.get(361)).setAttribute("id","datosCampos" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","25" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(365)).setAttribute("nombre","lbl2dtDeseaCorrespondencia" );
      ((Element)v.get(365)).setAttribute("alto","13" );
      ((Element)v.get(365)).setAttribute("filas","1" );
      ((Element)v.get(365)).setAttribute("valor","x1" );
      ((Element)v.get(365)).setAttribute("id","datosCampos" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(367)).setAttribute("width","25" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(369)).setAttribute("nombre","lbl2dtImporteIngresoFamiliar" );
      ((Element)v.get(369)).setAttribute("alto","13" );
      ((Element)v.get(369)).setAttribute("filas","1" );
      ((Element)v.get(369)).setAttribute("valor","" );
      ((Element)v.get(369)).setAttribute("id","datosCampos" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("width","100%" );
      ((Element)v.get(353)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:353   */

      /* Empieza nodo:372 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).setAttribute("colspan","4" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","8" );
      ((Element)v.get(374)).setAttribute("height","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:175   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:375 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","12" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:168   */

      /* Empieza nodo:377 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).setAttribute("width","12" );
      ((Element)v.get(378)).setAttribute("align","center" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","12" );
      ((Element)v.get(379)).setAttribute("height","969" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("width","750" );
      ((Element)v.get(377)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).setAttribute("width","12" );
      ((Element)v.get(382)).setAttribute("align","center" );
      ((Element)v.get(377)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","12" );
      ((Element)v.get(383)).setAttribute("height","969" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:377   */

      /* Empieza nodo:384 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(389)).setAttribute("class","legend" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(390)).setAttribute("nombre","lbl2TitGrupoPrimerContacto" );
      ((Element)v.get(390)).setAttribute("alto","13" );
      ((Element)v.get(390)).setAttribute("filas","1" );
      ((Element)v.get(390)).setAttribute("valor","" );
      ((Element)v.get(390)).setAttribute("cod","0056" );
      ((Element)v.get(390)).setAttribute("id","legend" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 388   */
      v.add(doc.createElement("table"));
      ((Element)v.get(391)).setAttribute("width","100%" );
      ((Element)v.get(391)).setAttribute("border","0" );
      ((Element)v.get(391)).setAttribute("align","center" );
      ((Element)v.get(391)).setAttribute("cellspacing","0" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(391)).setAttribute("cellpadding","0" );
      ((Element)v.get(388)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("table"));
      ((Element)v.get(394)).setAttribute("width","708" );
      ((Element)v.get(394)).setAttribute("border","0" );
      ((Element)v.get(394)).setAttribute("align","left" );
      ((Element)v.get(394)).setAttribute("cellspacing","0" );
      ((Element)v.get(394)).setAttribute("cellpadding","0" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).setAttribute("colspan","4" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:398 / Elemento padre: 394   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(394)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","8" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(402)).setAttribute("nombre","lbl2CodClienteContactado" );
      ((Element)v.get(402)).setAttribute("alto","13" );
      ((Element)v.get(402)).setAttribute("filas","1" );
      ((Element)v.get(402)).setAttribute("valor","" );
      ((Element)v.get(402)).setAttribute("id","datosTitle" );
      ((Element)v.get(402)).setAttribute("cod","1060" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","25" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(406)).setAttribute("nombre","lbl2TipoClienteContactado" );
      ((Element)v.get(406)).setAttribute("alto","13" );
      ((Element)v.get(406)).setAttribute("filas","1" );
      ((Element)v.get(406)).setAttribute("valor","" );
      ((Element)v.get(406)).setAttribute("id","datosTitle" );
      ((Element)v.get(406)).setAttribute("cod","1125" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","25" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(410)).setAttribute("nombre","lbl2TipoClienteContacto" );
      ((Element)v.get(410)).setAttribute("alto","13" );
      ((Element)v.get(410)).setAttribute("filas","1" );
      ((Element)v.get(410)).setAttribute("valor","" );
      ((Element)v.get(410)).setAttribute("id","datosTitle" );
      ((Element)v.get(410)).setAttribute("cod","1343" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","25" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(414)).setAttribute("nombre","lbl2CodTipoContacto" );
      ((Element)v.get(414)).setAttribute("alto","13" );
      ((Element)v.get(414)).setAttribute("filas","1" );
      ((Element)v.get(414)).setAttribute("valor","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(414)).setAttribute("id","datosTitle" );
      ((Element)v.get(414)).setAttribute("cod","1065" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(415)).setAttribute("width","100%" );
      ((Element)v.get(398)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:398   */

      /* Empieza nodo:417 / Elemento padre: 394   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(394)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","8" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(421)).setAttribute("nombre","lbl2dtCodClienteContactado" );
      ((Element)v.get(421)).setAttribute("alto","13" );
      ((Element)v.get(421)).setAttribute("filas","1" );
      ((Element)v.get(421)).setAttribute("valor","" );
      ((Element)v.get(421)).setAttribute("id","datosCampos" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","25" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(425)).setAttribute("nombre","lbl2dtTipoClienteContactado" );
      ((Element)v.get(425)).setAttribute("alto","13" );
      ((Element)v.get(425)).setAttribute("filas","1" );
      ((Element)v.get(425)).setAttribute("valor","" );
      ((Element)v.get(425)).setAttribute("id","datosCampos" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","25" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(429)).setAttribute("nombre","lbl2dtTipoClienteContacto" );
      ((Element)v.get(429)).setAttribute("alto","13" );
      ((Element)v.get(429)).setAttribute("filas","1" );
      ((Element)v.get(429)).setAttribute("valor","" );
      ((Element)v.get(429)).setAttribute("id","datosCampos" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:430 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","25" );
      ((Element)v.get(431)).setAttribute("height","8" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(433)).setAttribute("nombre","lbl2dtCodTipoContacto" );
      ((Element)v.get(433)).setAttribute("alto","13" );
      ((Element)v.get(433)).setAttribute("filas","1" );
      ((Element)v.get(433)).setAttribute("valor","" );
      ((Element)v.get(433)).setAttribute("id","datosCampos" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(434)).setAttribute("width","100%" );
      ((Element)v.get(417)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:417   */

      /* Empieza nodo:436 / Elemento padre: 394   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(394)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(437)).setAttribute("colspan","4" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(438)).setAttribute("width","8" );
      ((Element)v.get(438)).setAttribute("height","8" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:439 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("table"));
      ((Element)v.get(441)).setAttribute("width","708" );
      ((Element)v.get(441)).setAttribute("border","0" );
      ((Element)v.get(441)).setAttribute("align","left" );
      ((Element)v.get(441)).setAttribute("cellspacing","0" );
      ((Element)v.get(441)).setAttribute("cellpadding","0" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(444)).setAttribute("width","8" );
      ((Element)v.get(444)).setAttribute("height","8" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(446)).setAttribute("nombre","lbl2FechaContacto" );
      ((Element)v.get(446)).setAttribute("alto","13" );
      ((Element)v.get(446)).setAttribute("filas","1" );
      ((Element)v.get(446)).setAttribute("valor","" );
      ((Element)v.get(446)).setAttribute("id","datosTitle" );
      ((Element)v.get(446)).setAttribute("cod","1078" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","25" );
      ((Element)v.get(448)).setAttribute("height","8" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:449 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(450)).setAttribute("nombre","lbl2FechaSiguienteContacto" );
      ((Element)v.get(450)).setAttribute("alto","13" );
      ((Element)v.get(450)).setAttribute("filas","1" );
      ((Element)v.get(450)).setAttribute("valor","" );
      ((Element)v.get(450)).setAttribute("id","datosTitle" );
      ((Element)v.get(450)).setAttribute("cod","1342" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","25" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(454)).setAttribute("nombre","lbl2Marca" );
      ((Element)v.get(454)).setAttribute("alto","13" );
      ((Element)v.get(454)).setAttribute("filas","1" );
      ((Element)v.get(454)).setAttribute("valor","" );
      ((Element)v.get(454)).setAttribute("id","datosTitle" );
      ((Element)v.get(454)).setAttribute("cod","6" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).setAttribute("width","100%" );
      ((Element)v.get(442)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","8" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:442   */

      /* Empieza nodo:457 / Elemento padre: 441   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(441)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).setAttribute("width","8" );
      ((Element)v.get(459)).setAttribute("height","8" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(461)).setAttribute("nombre","lbl2dtFechaContacto" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(461)).setAttribute("alto","13" );
      ((Element)v.get(461)).setAttribute("filas","1" );
      ((Element)v.get(461)).setAttribute("valor","" );
      ((Element)v.get(461)).setAttribute("id","datosCampos" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","25" );
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(465)).setAttribute("nombre","lbl2dtFechaSiguienteContacto" );
      ((Element)v.get(465)).setAttribute("alto","13" );
      ((Element)v.get(465)).setAttribute("filas","1" );
      ((Element)v.get(465)).setAttribute("valor","" );
      ((Element)v.get(465)).setAttribute("id","datosCampos" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","25" );
      ((Element)v.get(467)).setAttribute("height","8" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(469)).setAttribute("nombre","lbl2dtMarca" );
      ((Element)v.get(469)).setAttribute("alto","13" );
      ((Element)v.get(469)).setAttribute("filas","1" );
      ((Element)v.get(469)).setAttribute("valor","" );
      ((Element)v.get(469)).setAttribute("id","datosCampos" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).setAttribute("width","100%" );
      ((Element)v.get(457)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).setAttribute("width","8" );
      ((Element)v.get(471)).setAttribute("height","8" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:457   */

      /* Empieza nodo:472 / Elemento padre: 441   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(441)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).setAttribute("colspan","4" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).setAttribute("width","8" );
      ((Element)v.get(474)).setAttribute("height","8" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:475 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("table"));
      ((Element)v.get(477)).setAttribute("width","708" );
      ((Element)v.get(477)).setAttribute("border","0" );
      ((Element)v.get(477)).setAttribute("align","left" );
      ((Element)v.get(477)).setAttribute("cellspacing","0" );
      ((Element)v.get(477)).setAttribute("cellpadding","0" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","8" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(482)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(482)).setAttribute("alto","13" );
      ((Element)v.get(482)).setAttribute("filas","1" );
      ((Element)v.get(482)).setAttribute("valor","" );
      ((Element)v.get(482)).setAttribute("id","datosTitle" );
      ((Element)v.get(482)).setAttribute("cod","7" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:483 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","25" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(484)).setAttribute("height","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:485 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(486)).setAttribute("nombre","lblPeriodoPrimerPedido" );
      ((Element)v.get(486)).setAttribute("alto","13" );
      ((Element)v.get(486)).setAttribute("filas","1" );
      ((Element)v.get(486)).setAttribute("valor","" );
      ((Element)v.get(486)).setAttribute("id","datosTitle" );
      ((Element)v.get(486)).setAttribute("cod","2420" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:487 / Elemento padre: 478   */
      v.add(doc.createElement("td"));
      ((Element)v.get(487)).setAttribute("width","100%" );
      ((Element)v.get(478)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(488)).setAttribute("src","b.gif" );
      ((Element)v.get(488)).setAttribute("width","8" );
      ((Element)v.get(488)).setAttribute("height","8" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:478   */

      /* Empieza nodo:489 / Elemento padre: 477   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(477)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","8" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(493)).setAttribute("nombre","lbldtCanal" );
      ((Element)v.get(493)).setAttribute("alto","13" );
      ((Element)v.get(493)).setAttribute("filas","1" );
      ((Element)v.get(493)).setAttribute("valor","" );
      ((Element)v.get(493)).setAttribute("id","datosCampos" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","25" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(497)).setAttribute("nombre","lbldtPeriodoPrimerPedido" );
      ((Element)v.get(497)).setAttribute("alto","13" );
      ((Element)v.get(497)).setAttribute("filas","1" );
      ((Element)v.get(497)).setAttribute("valor","" );
      ((Element)v.get(497)).setAttribute("id","datosCampos" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(498)).setAttribute("width","100%" );
      ((Element)v.get(489)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","8" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:489   */

      /* Empieza nodo:500 / Elemento padre: 477   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(477)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(501)).setAttribute("colspan","4" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","8" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:391   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:503 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(504)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).setAttribute("width","8" );
      ((Element)v.get(504)).setAttribute("height","12" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */
      /* Termina nodo:384   */

      /* Empieza nodo:505 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 505   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(510)).setAttribute("width","100%" );
      ((Element)v.get(510)).setAttribute("border","0" );
      ((Element)v.get(510)).setAttribute("align","center" );
      ((Element)v.get(510)).setAttribute("cellspacing","0" );
      ((Element)v.get(510)).setAttribute("cellpadding","0" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).setAttribute("class","botonera" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(513)).setAttribute("nombre","btnAnterior" );
      ((Element)v.get(513)).setAttribute("ID","botonContenido" );
      ((Element)v.get(513)).setAttribute("tipo","html" );
      ((Element)v.get(513)).setAttribute("accion","anteriorPestanya();" );
      ((Element)v.get(513)).setAttribute("estado","false" );
      ((Element)v.get(513)).setAttribute("cod","1649" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */

      /* Empieza nodo:514 / Elemento padre: 512   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(514)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(514)).setAttribute("ID","botonContenido" );
      ((Element)v.get(514)).setAttribute("tipo","html" );
      ((Element)v.get(514)).setAttribute("accion","siguientePestanya();" );
      ((Element)v.get(514)).setAttribute("estado","false" );
      ((Element)v.get(514)).setAttribute("cod","446" );
      ((Element)v.get(512)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:515 / Elemento padre: 505   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","8" );
      ((Element)v.get(516)).setAttribute("height","12" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:505   */

      /* Empieza nodo:517 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).setAttribute("width","12" );
      ((Element)v.get(518)).setAttribute("align","center" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
      ((Element)v.get(519)).setAttribute("width","12" );
      ((Element)v.get(519)).setAttribute("height","12" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(520)).setAttribute("width","750" );
      ((Element)v.get(517)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).setAttribute("width","12" );
      ((Element)v.get(517)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("width","12" );
      ((Element)v.get(523)).setAttribute("height","12" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:517   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:524 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(524)).setAttribute("nombre","listado2" );
      ((Element)v.get(524)).setAttribute("ancho","711" );
      ((Element)v.get(524)).setAttribute("alto","277" );
      ((Element)v.get(524)).setAttribute("x","12" );
      ((Element)v.get(524)).setAttribute("y","367" );
      ((Element)v.get(524)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(524)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(525)).setAttribute("precarga","S" );
      ((Element)v.get(525)).setAttribute("conROver","S" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(526)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(526)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(526)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(526)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */

      /* Empieza nodo:527 / Elemento padre: 525   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(527)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(527)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(527)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(527)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(525)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:525   */

      /* Empieza nodo:528 / Elemento padre: 524   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(524)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(529)).setAttribute("borde","1" );
      ((Element)v.get(529)).setAttribute("horizDatos","1" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(529)).setAttribute("horizCabecera","1" );
      ((Element)v.get(529)).setAttribute("vertical","1" );
      ((Element)v.get(529)).setAttribute("horizTitulo","1" );
      ((Element)v.get(529)).setAttribute("horizBase","1" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */

      /* Empieza nodo:530 / Elemento padre: 528   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(530)).setAttribute("borde","#999999" );
      ((Element)v.get(530)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(530)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(530)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(530)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(530)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(530)).setAttribute("horizBase","#999999" );
      ((Element)v.get(528)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:528   */

      /* Empieza nodo:531 / Elemento padre: 524   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(531)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(531)).setAttribute("alto","22" );
      ((Element)v.get(531)).setAttribute("imgFondo","" );
      ((Element)v.get(531)).setAttribute("cod","0057" );
      ((Element)v.get(531)).setAttribute("ID","datosTitle" );
      ((Element)v.get(524)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */

      /* Empieza nodo:532 / Elemento padre: 524   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(532)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(532)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(532)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(532)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(532)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(524)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(533)).setAttribute("ancho","98" );
      ((Element)v.get(533)).setAttribute("minimizable","S" );
      ((Element)v.get(533)).setAttribute("minimizada","N" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */

      /* Empieza nodo:534 / Elemento padre: 532   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(534)).setAttribute("ancho","68" );
      ((Element)v.get(534)).setAttribute("minimizable","S" );
      ((Element)v.get(534)).setAttribute("minimizada","N" );
      ((Element)v.get(532)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */

      /* Empieza nodo:535 / Elemento padre: 532   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(535)).setAttribute("ancho","73" );
      ((Element)v.get(535)).setAttribute("minimizable","S" );
      ((Element)v.get(535)).setAttribute("minimizada","N" );
      ((Element)v.get(532)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */

      /* Empieza nodo:536 / Elemento padre: 532   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(536)).setAttribute("ancho","73" );
      ((Element)v.get(536)).setAttribute("minimizable","S" );
      ((Element)v.get(536)).setAttribute("minimizada","N" );
      ((Element)v.get(532)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */

      /* Empieza nodo:537 / Elemento padre: 532   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(537)).setAttribute("ancho","89" );
      ((Element)v.get(537)).setAttribute("minimizable","S" );
      ((Element)v.get(537)).setAttribute("minimizada","N" );
      ((Element)v.get(532)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:532   */

      /* Empieza nodo:538 / Elemento padre: 524   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(538)).setAttribute("alto","20" );
      ((Element)v.get(538)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(538)).setAttribute("imgFondo","" );
      ((Element)v.get(538)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(524)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(539)).setAttribute("colFondo","" );
      ((Element)v.get(539)).setAttribute("ID","EstCab" );
      ((Element)v.get(539)).setAttribute("align","center" );
      ((Element)v.get(539)).setAttribute("cod","1058" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */

      /* Empieza nodo:540 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(540)).setAttribute("colFondo","" );
      ((Element)v.get(540)).setAttribute("ID","EstCab" );
      ((Element)v.get(540)).setAttribute("align","center" );
      ((Element)v.get(540)).setAttribute("cod","1131" );
      ((Element)v.get(538)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(541)).setAttribute("colFondo","" );
      ((Element)v.get(541)).setAttribute("ID","EstCab" );
      ((Element)v.get(541)).setAttribute("align","center" );
      ((Element)v.get(541)).setAttribute("cod","59" );
      ((Element)v.get(538)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(542)).setAttribute("colFondo","" );
      ((Element)v.get(542)).setAttribute("ID","EstCab" );
      ((Element)v.get(542)).setAttribute("align","center" );
      ((Element)v.get(542)).setAttribute("cod","1339" );
      ((Element)v.get(538)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */

      /* Empieza nodo:543 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(543)).setAttribute("colFondo","" );
      ((Element)v.get(543)).setAttribute("ID","EstCab" );
      ((Element)v.get(543)).setAttribute("align","center" );
      ((Element)v.get(543)).setAttribute("cod","1139" );
      ((Element)v.get(538)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:538   */

      /* Empieza nodo:544 / Elemento padre: 524   */
      v.add(doc.createElement("DATOS"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(544)).setAttribute("alto","22" );
      ((Element)v.get(544)).setAttribute("accion","" );
      ((Element)v.get(544)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(544)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(544)).setAttribute("maxSel","-1" );
      ((Element)v.get(544)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(544)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(544)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(544)).setAttribute("onLoad","" );
      ((Element)v.get(544)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(524)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(545)).setAttribute("tipo","texto" );
      ((Element)v.get(545)).setAttribute("ID","EstDat" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */

      /* Empieza nodo:546 / Elemento padre: 544   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(546)).setAttribute("tipo","texto" );
      ((Element)v.get(546)).setAttribute("ID","EstDat2" );
      ((Element)v.get(544)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */

      /* Empieza nodo:547 / Elemento padre: 544   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(547)).setAttribute("tipo","texto" );
      ((Element)v.get(547)).setAttribute("ID","EstDat" );
      ((Element)v.get(544)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */

      /* Empieza nodo:548 / Elemento padre: 544   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(548)).setAttribute("tipo","texto" );
      ((Element)v.get(548)).setAttribute("ID","EstDat2" );
      ((Element)v.get(544)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */

      /* Empieza nodo:549 / Elemento padre: 544   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(549)).setAttribute("tipo","texto" );
      ((Element)v.get(549)).setAttribute("ID","EstDat" );
      ((Element)v.get(544)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:544   */

      /* Empieza nodo:550 / Elemento padre: 524   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(524)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:524   */

      /* Empieza nodo:551 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(551)).setAttribute("nombre","listado3" );
      ((Element)v.get(551)).setAttribute("ancho","711" );
      ((Element)v.get(551)).setAttribute("alto","277" );
      ((Element)v.get(551)).setAttribute("x","12" );
      ((Element)v.get(551)).setAttribute("y","669" );
      ((Element)v.get(551)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(551)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(552)).setAttribute("precarga","S" );
      ((Element)v.get(552)).setAttribute("conROver","S" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(553)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(553)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(553)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(553)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */

      /* Empieza nodo:554 / Elemento padre: 552   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(554)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(554)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(554)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(554)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(552)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:552   */

      /* Empieza nodo:555 / Elemento padre: 551   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(551)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(556)).setAttribute("borde","1" );
      ((Element)v.get(556)).setAttribute("horizDatos","1" );
      ((Element)v.get(556)).setAttribute("horizCabecera","1" );
      ((Element)v.get(556)).setAttribute("vertical","1" );
      ((Element)v.get(556)).setAttribute("horizTitulo","1" );
      ((Element)v.get(556)).setAttribute("horizBase","1" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */

      /* Empieza nodo:557 / Elemento padre: 555   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(557)).setAttribute("borde","#999999" );
      ((Element)v.get(557)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(557)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(557)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(557)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(557)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(557)).setAttribute("horizBase","#999999" );
      ((Element)v.get(555)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:555   */

      /* Empieza nodo:558 / Elemento padre: 551   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(558)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(558)).setAttribute("alto","22" );
      ((Element)v.get(558)).setAttribute("imgFondo","" );
      ((Element)v.get(558)).setAttribute("cod","0055" );
      ((Element)v.get(558)).setAttribute("ID","datosTitle" );
      ((Element)v.get(551)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */

      /* Empieza nodo:559 / Elemento padre: 551   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(559)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(559)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(559)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(559)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(559)).setAttribute("AnchoMinimizadas","20" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(551)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(560)).setAttribute("ancho","105" );
      ((Element)v.get(560)).setAttribute("minimizable","S" );
      ((Element)v.get(560)).setAttribute("minimizada","N" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 559   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(561)).setAttribute("ancho","400" );
      ((Element)v.get(561)).setAttribute("minimizable","S" );
      ((Element)v.get(561)).setAttribute("minimizada","N" );
      ((Element)v.get(559)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:559   */

      /* Empieza nodo:562 / Elemento padre: 551   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(562)).setAttribute("alto","20" );
      ((Element)v.get(562)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(562)).setAttribute("imgFondo","" );
      ((Element)v.get(562)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(551)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(563)).setAttribute("colFondo","" );
      ((Element)v.get(563)).setAttribute("ID","EstCab" );
      ((Element)v.get(563)).setAttribute("align","center" );
      ((Element)v.get(563)).setAttribute("cod","1127" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */

      /* Empieza nodo:564 / Elemento padre: 562   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(564)).setAttribute("colFondo","" );
      ((Element)v.get(564)).setAttribute("ID","EstCab" );
      ((Element)v.get(564)).setAttribute("align","center" );
      ((Element)v.get(564)).setAttribute("cod","9" );
      ((Element)v.get(562)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:562   */

      /* Empieza nodo:565 / Elemento padre: 551   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(565)).setAttribute("alto","22" );
      ((Element)v.get(565)).setAttribute("accion","" );
      ((Element)v.get(565)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(565)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(565)).setAttribute("maxSel","-1" );
      ((Element)v.get(565)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(565)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(565)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(565)).setAttribute("onLoad","" );
      ((Element)v.get(565)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(551)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(566)).setAttribute("tipo","texto" );
      ((Element)v.get(566)).setAttribute("ID","EstDat" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */

      /* Empieza nodo:567 / Elemento padre: 565   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(567)).setAttribute("tipo","texto" );
      ((Element)v.get(567)).setAttribute("ID","EstDat2" );
      ((Element)v.get(565)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:565   */

      /* Empieza nodo:568 / Elemento padre: 551   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(551)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:551   */

      /* Empieza nodo:569 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(569)).setAttribute("nombre","listado4" );
      ((Element)v.get(569)).setAttribute("ancho","711" );
      ((Element)v.get(569)).setAttribute("alto","317" );
      ((Element)v.get(569)).setAttribute("x","12" );
      ((Element)v.get(569)).setAttribute("y","971" );
      ((Element)v.get(569)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(569)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(570)).setAttribute("precarga","S" );
      ((Element)v.get(570)).setAttribute("conROver","S" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(571)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(571)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(571)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(571)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */

      /* Empieza nodo:572 / Elemento padre: 570   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(572)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(572)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(572)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(572)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(570)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:570   */

      /* Empieza nodo:573 / Elemento padre: 569   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(569)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(574)).setAttribute("borde","1" );
      ((Element)v.get(574)).setAttribute("horizDatos","1" );
      ((Element)v.get(574)).setAttribute("horizCabecera","1" );
      ((Element)v.get(574)).setAttribute("vertical","1" );
      ((Element)v.get(574)).setAttribute("horizTitulo","1" );
      ((Element)v.get(574)).setAttribute("horizBase","1" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */

      /* Empieza nodo:575 / Elemento padre: 573   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(575)).setAttribute("borde","#999999" );
      ((Element)v.get(575)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(575)).setAttribute("vertDatos","#FFFFFF" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(575)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(575)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(575)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(575)).setAttribute("horizBase","#999999" );
      ((Element)v.get(573)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:573   */

      /* Empieza nodo:576 / Elemento padre: 569   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(576)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(576)).setAttribute("alto","22" );
      ((Element)v.get(576)).setAttribute("imgFondo","" );
      ((Element)v.get(576)).setAttribute("cod","0054" );
      ((Element)v.get(576)).setAttribute("ID","datosTitle" );
      ((Element)v.get(569)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */

      /* Empieza nodo:577 / Elemento padre: 569   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(577)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(577)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(577)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(577)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(577)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(569)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(578)).setAttribute("ancho","212" );
      ((Element)v.get(578)).setAttribute("minimizable","S" );
      ((Element)v.get(578)).setAttribute("minimizada","N" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */

      /* Empieza nodo:579 / Elemento padre: 577   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(579)).setAttribute("ancho","92" );
      ((Element)v.get(579)).setAttribute("minimizable","S" );
      ((Element)v.get(579)).setAttribute("minimizada","N" );
      ((Element)v.get(577)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */

      /* Empieza nodo:580 / Elemento padre: 577   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(580)).setAttribute("ancho","402" );
      ((Element)v.get(580)).setAttribute("minimizable","S" );
      ((Element)v.get(580)).setAttribute("minimizada","N" );
      ((Element)v.get(577)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:577   */

      /* Empieza nodo:581 / Elemento padre: 569   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(581)).setAttribute("alto","20" );
      ((Element)v.get(581)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(581)).setAttribute("imgFondo","" );
      ((Element)v.get(581)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(569)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(582)).setAttribute("colFondo","" );
      ((Element)v.get(582)).setAttribute("ID","EstCab" );
      ((Element)v.get(582)).setAttribute("align","center" );
      ((Element)v.get(582)).setAttribute("cod","6" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */

      /* Empieza nodo:583 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(583)).setAttribute("colFondo","" );
      ((Element)v.get(583)).setAttribute("ID","EstCab" );
      ((Element)v.get(583)).setAttribute("align","center" );
      ((Element)v.get(583)).setAttribute("cod","1340" );
      ((Element)v.get(581)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */

      /* Empieza nodo:584 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(584)).setAttribute("colFondo","" );
      ((Element)v.get(584)).setAttribute("ID","EstCab" );
      ((Element)v.get(584)).setAttribute("align","center" );
      ((Element)v.get(584)).setAttribute("cod","487" );
      ((Element)v.get(581)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:581   */

      /* Empieza nodo:585 / Elemento padre: 569   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(585)).setAttribute("alto","22" );
      ((Element)v.get(585)).setAttribute("accion","" );
      ((Element)v.get(585)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(585)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(585)).setAttribute("maxSel","-1" );
      ((Element)v.get(585)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(585)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(585)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(585)).setAttribute("onLoad","" );
      ((Element)v.get(585)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(569)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(586)).setAttribute("tipo","texto" );
      ((Element)v.get(586)).setAttribute("ID","EstDat" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */

      /* Empieza nodo:587 / Elemento padre: 585   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(587)).setAttribute("tipo","texto" );
      ((Element)v.get(587)).setAttribute("ID","EstDat2" );
      ((Element)v.get(585)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */

      /* Empieza nodo:588 / Elemento padre: 585   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(588)).setAttribute("tipo","texto" );
      ((Element)v.get(588)).setAttribute("ID","EstDat" );
      ((Element)v.get(585)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:585   */

      /* Empieza nodo:589 / Elemento padre: 569   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(569)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:569   */
      /* Termina nodo:3   */


   }

}
