
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cursos_insertar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         

      getXML2880(doc);
         

      getXML2970(doc);
         

      getXML3060(doc);
         

      getXML3150(doc);
         

      getXML3240(doc);
         

      getXML3330(doc);
         

      getXML3420(doc);
         

      getXML3510(doc);
         

      getXML3600(doc);
         

      getXML3690(doc);
         

      getXML3780(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_cursos_insertar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","0202" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Realización de la inserción de cursos" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_cursos_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbMarca" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCanal" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","393" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbEstatusCli" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","612" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbProductoAEntregar" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","752" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbFrecuenciaDictado" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","731" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbTipoCurso" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","758" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbAccesoInfo" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","709" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbCursosExigidos" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("cod","754" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbPerConstInicio" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("cod","749" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","cbPerConstFin" );
      ((Element)v.get(17)).setAttribute("required","false" );
      ((Element)v.get(17)).setAttribute("cod","747" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","cbPerVentInicio" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("cod","750" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","cbPerVentFin" );
      ((Element)v.get(19)).setAttribute("required","false" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).setAttribute("cod","1530" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","cbPerIngresoCondicion" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("cod","748" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbSubVentas" );
      ((Element)v.get(21)).setAttribute("required","false" );
      ((Element)v.get(21)).setAttribute("cod","124" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","cbSubtipoCliente" );
      ((Element)v.get(22)).setAttribute("required","false" );
      ((Element)v.get(22)).setAttribute("cod","595" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","cbTipoClasificacion" );
      ((Element)v.get(23)).setAttribute("required","false" );
      ((Element)v.get(23)).setAttribute("cod","756" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","cbClasificacion" );
      ((Element)v.get(24)).setAttribute("required","false" );
      ((Element)v.get(24)).setAttribute("cod","550" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","cbRegion" );
      ((Element)v.get(25)).setAttribute("required","false" );
      ((Element)v.get(25)).setAttribute("cod","109" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","cbZona" );
      ((Element)v.get(26)).setAttribute("required","false" );
      ((Element)v.get(26)).setAttribute("cod","143" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(27)).setAttribute("name","cbSeccion" );
      ((Element)v.get(27)).setAttribute("required","false" );
      ((Element)v.get(27)).setAttribute("cod","112" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(28)).setAttribute("name","cbTerritorio" );
      ((Element)v.get(28)).setAttribute("required","false" );
      ((Element)v.get(28)).setAttribute("cod","126" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(29)).setAttribute("name","cbCapacitador" );
      ((Element)v.get(29)).setAttribute("required","false" );
      ((Element)v.get(29)).setAttribute("cod","714" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(30)).setAttribute("name","cbMomentoEntrega" );
      ((Element)v.get(30)).setAttribute("required","false" );
      ((Element)v.get(30)).setAttribute("cod","737" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(31)).setAttribute("name","txtNombreCurso" );
      ((Element)v.get(31)).setAttribute("required","false" );
      ((Element)v.get(31)).setAttribute("cod","742" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(32)).setAttribute("name","txtObjetivoCurso" );
      ((Element)v.get(32)).setAttribute("required","false" );
      ((Element)v.get(32)).setAttribute("cod","744" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(33)).setAttribute("name","txtContenidoCurso" );
      ((Element)v.get(33)).setAttribute("required","false" );
      ((Element)v.get(33)).setAttribute("cod","719" );
      ((Element)v.get(6)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(34)).setAttribute("name","txtFechaDisponible" );
      ((Element)v.get(34)).setAttribute("required","false" );
      ((Element)v.get(34)).setAttribute("cod","725" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(35)).setAttribute("name","txtFechaLanzamiento" );
      ((Element)v.get(35)).setAttribute("required","false" );
      ((Element)v.get(35)).setAttribute("cod","729" );
      ((Element)v.get(6)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(36)).setAttribute("name","txtFechaFinalizacion" );
      ((Element)v.get(36)).setAttribute("required","false" );
      ((Element)v.get(36)).setAttribute("cod","726" );
      ((Element)v.get(6)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(37)).setAttribute("name","txtOptimoParticipantes" );
      ((Element)v.get(37)).setAttribute("required","false" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(37)).setAttribute("cod","739" );
      ((Element)v.get(6)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(38)).setAttribute("name","txtMaterialAEmplear" );
      ((Element)v.get(38)).setAttribute("required","false" );
      ((Element)v.get(38)).setAttribute("cod","735" );
      ((Element)v.get(6)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(39)).setAttribute("name","txtNOrdenes" );
      ((Element)v.get(39)).setAttribute("required","false" );
      ((Element)v.get(39)).setAttribute("cod","740" );
      ((Element)v.get(6)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(40)).setAttribute("name","txtMontoVentasComp" );
      ((Element)v.get(40)).setAttribute("required","false" );
      ((Element)v.get(40)).setAttribute("cod","738" );
      ((Element)v.get(6)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(41)).setAttribute("name","txtFechaIngresoCondicion" );
      ((Element)v.get(41)).setAttribute("required","false" );
      ((Element)v.get(41)).setAttribute("cod","728" );
      ((Element)v.get(6)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(42)).setAttribute("name","txtNPeriodosCondicion" );
      ((Element)v.get(42)).setAttribute("required","false" );
      ((Element)v.get(42)).setAttribute("cod","741" );
      ((Element)v.get(6)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(43)).setAttribute("name","txtFechaUltimo" );
      ((Element)v.get(43)).setAttribute("required","false" );
      ((Element)v.get(43)).setAttribute("cod","730" );
      ((Element)v.get(6)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(44)).setAttribute("name","txtUniRegalo" );
      ((Element)v.get(44)).setAttribute("required","false" );
      ((Element)v.get(44)).setAttribute("cod","759" );
      ((Element)v.get(6)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(45)).setAttribute("name","areaDescDetallada" );
      ((Element)v.get(45)).setAttribute("required","false" );
      ((Element)v.get(45)).setAttribute("cod","722" );
      ((Element)v.get(6)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(46)).setAttribute("name","rbAccesoSeleccion" );
      ((Element)v.get(46)).setAttribute("required","false" );
      ((Element)v.get(46)).setAttribute("cod","708" );
      ((Element)v.get(6)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(47)).setAttribute("name","rbAlcanceGeoNacional" );
      ((Element)v.get(47)).setAttribute("required","false" );
      ((Element)v.get(47)).setAttribute("cod","710" );
      ((Element)v.get(6)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(48)).setAttribute("name","rbBloqueo" );
      ((Element)v.get(48)).setAttribute("required","false" );
      ((Element)v.get(48)).setAttribute("cod","713" );
      ((Element)v.get(6)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(49)).setAttribute("name","rbCondicionPedido" );
      ((Element)v.get(49)).setAttribute("required","false" );
      ((Element)v.get(49)).setAttribute("cod","718" );
      ((Element)v.get(6)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(50)).setAttribute("name","rbControlMorosidad" );
      ((Element)v.get(50)).setAttribute("required","false" );
      ((Element)v.get(50)).setAttribute("cod","720" );
      ((Element)v.get(6)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:6   */

      /* Empieza nodo:51 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(51)).setAttribute("nombre","formularioInsertarCurso" );
      ((Element)v.get(51)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","accion" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","casoUso" );
      ((Element)v.get(56)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(51)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","idioma" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","pais" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","Plantilla" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","oid" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hcbMarca" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hcbCanal" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hcbTipoCliente" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hcbEstatusCli" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hcbProductoAEntregar" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hcbFrecuenciaDictado" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hcbTipoCurso" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hcbAccesoInfo" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hcbCursosExigidos" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hcbPerConstInicio" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hcbPerConstFin" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hcbPerVentInicio" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hcbPerVentFin" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hcbPerIngresoCondicion" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hcbSubVentas" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hcbSubtipoCliente" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hcbTipoClasificacion" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hcbClasificacion" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(79)).setAttribute("nombre","hcbRegion" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hcbZona" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hcbSeccion" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hcbTerritorio" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hcbCapacitador" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hcbMomentoEntrega" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","htxtNombreCurso" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","htxtObjetivoCurso" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","htxtContenidoCurso" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","htxtFechaDisponible" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","htxtFechaLanzamiento" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","htxtFechaFinalizacion" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","htxtOptimoParticipantes" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","htxtMaterialAEmplear" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","htxtNOrdenes" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","htxtMontoVentasComp" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","htxtFechaIngresoCondicion" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","htxtNPeriodosCondicion" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","htxtFechaUltimo" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","htxtUniRegalo" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hareaDescDetallada" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hrbAccesoSeleccion" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","hrbAlcanceGeoNacional" );
      ((Element)v.get(101)).setAttribute("valor","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(51)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","hrbBloqueo" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","hrbCondicionPedido" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","hrbControlMorosidad" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(107)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(108)).setAttribute("nombre","cbAccesoInfoRO" );
      ((Element)v.get(108)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(109)).setAttribute("nombre","cbCursosExigidosRO" );
      ((Element)v.get(109)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(110)).setAttribute("nombre","cbTerritorioRO" );
      ((Element)v.get(110)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(111)).setAttribute("nombre","cbCapacitadorRO" );
      ((Element)v.get(111)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(112)).setAttribute("nombre","cbTipoCursoRO" );
      ((Element)v.get(112)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(113)).setAttribute("nombre","cbSubVentasRO" );
      ((Element)v.get(113)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(114)).setAttribute("nombre","cbSubtipoClienteRO" );
      ((Element)v.get(114)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(115)).setAttribute("nombre","cbTipoClasificacionRO" );
      ((Element)v.get(115)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(116)).setAttribute("nombre","cbClasificacionRO" );
      ((Element)v.get(116)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(117)).setAttribute("nombre","cbRegionRO" );
      ((Element)v.get(117)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(118)).setAttribute("nombre","cbZonaRO" );
      ((Element)v.get(118)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(119)).setAttribute("nombre","cbSeccionRO" );
      ((Element)v.get(119)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(120)).setAttribute("nombre","cbPerConstInicioRO" );
      ((Element)v.get(120)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(121)).setAttribute("nombre","cbPerConstFinRO" );
      ((Element)v.get(121)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(122)).setAttribute("nombre","cbPerVentInicioRO" );
      ((Element)v.get(122)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(123)).setAttribute("nombre","cbPerVentFinRO" );
      ((Element)v.get(123)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(124)).setAttribute("nombre","cbPerIngresoCondicionRO" );
      ((Element)v.get(124)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(125)).setAttribute("nombre","cbMomentoEntregaRO" );
      ((Element)v.get(125)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(126)).setAttribute("nombre","cbMarcaREQ" );
      ((Element)v.get(126)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(127)).setAttribute("nombre","cbCanalREQ" );
      ((Element)v.get(127)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(128)).setAttribute("nombre","cbTipoClienteREQ" );
      ((Element)v.get(128)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(129)).setAttribute("nombre","cbEstatusCliREQ" );
      ((Element)v.get(129)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(130)).setAttribute("nombre","cbProductoAEntregarREQ" );
      ((Element)v.get(130)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(131)).setAttribute("nombre","cbFrecuenciaDictadoREQ" );
      ((Element)v.get(131)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(132)).setAttribute("nombre","cbTipoCursoREQ" );
      ((Element)v.get(132)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(133)).setAttribute("nombre","cbAccesoInfoREQ" );
      ((Element)v.get(133)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(134)).setAttribute("nombre","cbCursosExigidosREQ" );
      ((Element)v.get(134)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(135)).setAttribute("nombre","cbPerConstInicioREQ" );
      ((Element)v.get(135)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(136)).setAttribute("nombre","cbPerConstFinREQ" );
      ((Element)v.get(136)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(137)).setAttribute("nombre","cbPerVentInicioREQ" );
      ((Element)v.get(137)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(138)).setAttribute("nombre","cbPerVentFinREQ" );
      ((Element)v.get(138)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(139)).setAttribute("nombre","cbPerIngresoCondicionREQ" );
      ((Element)v.get(139)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(140)).setAttribute("nombre","cbSubVentasREQ" );
      ((Element)v.get(140)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(141)).setAttribute("nombre","cbSubtipoClienteREQ" );
      ((Element)v.get(141)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(142)).setAttribute("nombre","cbTipoClasificacionREQ" );
      ((Element)v.get(142)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(143)).setAttribute("nombre","cbClasificacionREQ" );
      ((Element)v.get(143)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(144)).setAttribute("nombre","cbRegionREQ" );
      ((Element)v.get(144)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(145)).setAttribute("nombre","cbZonaREQ" );
      ((Element)v.get(145)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(146)).setAttribute("nombre","cbSeccionREQ" );
      ((Element)v.get(146)).setAttribute("valor","N" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(51)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(147)).setAttribute("nombre","cbTerritorioREQ" );
      ((Element)v.get(147)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(148)).setAttribute("nombre","cbCapacitadorREQ" );
      ((Element)v.get(148)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(149)).setAttribute("nombre","cbMomentoEntregaREQ" );
      ((Element)v.get(149)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(150)).setAttribute("nombre","txtNombreCursoREQ" );
      ((Element)v.get(150)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(151)).setAttribute("nombre","txtObjetivoCursoREQ" );
      ((Element)v.get(151)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(152)).setAttribute("nombre","txtContenidoCursoREQ" );
      ((Element)v.get(152)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(153)).setAttribute("nombre","txtFechaDisponibleREQ" );
      ((Element)v.get(153)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(154)).setAttribute("nombre","txtFechaLanzamientoREQ" );
      ((Element)v.get(154)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(155)).setAttribute("nombre","txtFechaFinalizacionREQ" );
      ((Element)v.get(155)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(156)).setAttribute("nombre","txtOptimoParticipantesREQ" );
      ((Element)v.get(156)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(157)).setAttribute("nombre","txtMaterialAEmplearREQ" );
      ((Element)v.get(157)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(158)).setAttribute("nombre","txtNOrdenesREQ" );
      ((Element)v.get(158)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(159)).setAttribute("nombre","txtMontoVentasCompREQ" );
      ((Element)v.get(159)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(160)).setAttribute("nombre","txtFechaIngresoCondicionREQ" );
      ((Element)v.get(160)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(161)).setAttribute("nombre","txtNPeriodosCondicionREQ" );
      ((Element)v.get(161)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(162)).setAttribute("nombre","txtFechaUltimoREQ" );
      ((Element)v.get(162)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(163)).setAttribute("nombre","txtUniRegaloREQ" );
      ((Element)v.get(163)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(164)).setAttribute("nombre","areaDescDetalladaREQ" );
      ((Element)v.get(164)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(165)).setAttribute("nombre","rbAccesoSeleccionREQ" );
      ((Element)v.get(165)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(166)).setAttribute("nombre","rbAlcanceGeoNacionalREQ" );
      ((Element)v.get(166)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(167)).setAttribute("nombre","rbBloqueoREQ" );
      ((Element)v.get(167)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(168)).setAttribute("nombre","rbCondicionPedidoREQ" );
      ((Element)v.get(168)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(169)).setAttribute("nombre","rbControlMorosidadREQ" );
      ((Element)v.get(169)).setAttribute("valor","N" );
      ((Element)v.get(51)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(170)).setAttribute("nombre","primero" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(171)).setAttribute("nombre","ultimo" );
      ((Element)v.get(171)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(172)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(172)).setAttribute("valor","LPInsertaCurso" );
      ((Element)v.get(51)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(173)).setAttribute("nombre","oidClienteCapacitador" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(174)).setAttribute("nombre","oidSubtipoClienteCapacitador" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(175)).setAttribute("nombre","oidTipoClasificacionCapacitador" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 51   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(176)).setAttribute("nombre","anexoCbCapacitador" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(51)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 51   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(177)).setAttribute("nombre","camposInsercionCurso" );
      ((Element)v.get(177)).setAttribute("alto","100%" );
      ((Element)v.get(177)).setAttribute("ancho","100%" );
      ((Element)v.get(177)).setAttribute("colorf","" );
      ((Element)v.get(177)).setAttribute("borde","" );
      ((Element)v.get(177)).setAttribute("imagenf","" );
      ((Element)v.get(177)).setAttribute("repeat","" );
      ((Element)v.get(177)).setAttribute("padding","" );
      ((Element)v.get(177)).setAttribute("visibilidad","" );
      ((Element)v.get(177)).setAttribute("contravsb","" );
      ((Element)v.get(177)).setAttribute("x","0" );
      ((Element)v.get(177)).setAttribute("y","0" );
      ((Element)v.get(177)).setAttribute("zindex","" );
      ((Element)v.get(51)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("table"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(178)).setAttribute("border","0" );
      ((Element)v.get(178)).setAttribute("cellspacing","0" );
      ((Element)v.get(178)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","12" );
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","12" );
      ((Element)v.get(181)).setAttribute("height","12" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("width","750" );
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","12" );
      ((Element)v.get(179)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","12" );
      ((Element)v.get(185)).setAttribute("height","1" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:179   */

      /* Empieza nodo:186 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(191)).setAttribute("class","legend" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblDatosGen" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(192)).setAttribute("id","legend" );
      ((Element)v.get(192)).setAttribute("cod","0011" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("table"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(193)).setAttribute("border","0" );
      ((Element)v.get(193)).setAttribute("align","center" );
      ((Element)v.get(193)).setAttribute("cellspacing","0" );
      ((Element)v.get(193)).setAttribute("cellpadding","0" );
      ((Element)v.get(190)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("colspan","4" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:197 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","8" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(201)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(201)).setAttribute("alto","13" );
      ((Element)v.get(201)).setAttribute("filas","1" );
      ((Element)v.get(201)).setAttribute("valor","" );
      ((Element)v.get(201)).setAttribute("id","datosTitle" );
      ((Element)v.get(201)).setAttribute("cod","6" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","25" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(205)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(205)).setAttribute("alto","13" );
      ((Element)v.get(205)).setAttribute("filas","1" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("id","datosTitle" );
      ((Element)v.get(205)).setAttribute("cod","7" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lblTipoCurso" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","758" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(197)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:197   */

      /* Empieza nodo:212 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(216)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).setAttribute("size","1" );
      ((Element)v.get(216)).setAttribute("multiple","N" );
      ((Element)v.get(216)).setAttribute("readonly","N" );
      ((Element)v.get(216)).setAttribute("req","N" );
      ((Element)v.get(216)).setAttribute("valorinicial","" );
      ((Element)v.get(216)).setAttribute("onchange","cargaCombosDepMarca();" );
      ((Element)v.get(216)).setAttribute("textoinicial","" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:218 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(212)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(221)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(221)).setAttribute("id","datosCampos" );
      ((Element)v.get(221)).setAttribute("size","1" );
      ((Element)v.get(221)).setAttribute("multiple","N" );
      ((Element)v.get(221)).setAttribute("readonly","N" );
      ((Element)v.get(221)).setAttribute("req","N" );
      ((Element)v.get(221)).setAttribute("valorinicial","" );
      ((Element)v.get(221)).setAttribute("onchange","cargaCombosDepCanal();" );
      ((Element)v.get(221)).setAttribute("textoinicial","" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:223 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","25" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(212)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(226)).setAttribute("nombre","cbTipoCurso" );
      ((Element)v.get(226)).setAttribute("id","datosCampos" );
      ((Element)v.get(226)).setAttribute("size","1" );
      ((Element)v.get(226)).setAttribute("multiple","N" );
      ((Element)v.get(226)).setAttribute("readonly","N" );
      ((Element)v.get(226)).setAttribute("req","N" );
      ((Element)v.get(226)).setAttribute("valorinicial","" );
      ((Element)v.get(226)).setAttribute("onchange","cargaComboCapacitador();" );
      ((Element)v.get(226)).setAttribute("textoinicial","" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:228 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","100%" );
      ((Element)v.get(212)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:212   */

      /* Empieza nodo:230 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("colspan","4" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:193   */

      /* Empieza nodo:233 / Elemento padre: 190   */
      v.add(doc.createElement("table"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(233)).setAttribute("border","0" );
      ((Element)v.get(233)).setAttribute("align","center" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(233)).setAttribute("cellspacing","0" );
      ((Element)v.get(233)).setAttribute("cellpadding","0" );
      ((Element)v.get(190)).appendChild((Element)v.get(233));

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
      ((Element)v.get(238)).setAttribute("nombre","lblNombreCurso" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).setAttribute("cod","742" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","25" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(244)).setAttribute("nombre","lblObjetivoCurso" );
      ((Element)v.get(244)).setAttribute("alto","13" );
      ((Element)v.get(244)).setAttribute("filas","1" );
      ((Element)v.get(244)).setAttribute("valor","" );
      ((Element)v.get(244)).setAttribute("id","datosTitle" );
      ((Element)v.get(244)).setAttribute("cod","744" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("nombre","lblObjetivoCursoI" );
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","25" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(248)).setAttribute("nombre","lblContenidoCurso" );
      ((Element)v.get(248)).setAttribute("alto","13" );
      ((Element)v.get(248)).setAttribute("filas","1" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(248)).setAttribute("id","datosTitle" );
      ((Element)v.get(248)).setAttribute("cod","719" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(234)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:234   */

      /* Empieza nodo:251 / Elemento padre: 233   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(251)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(255)).setAttribute("nombre","txtNombreCurso" );
      ((Element)v.get(255)).setAttribute("id","datosCampos" );
      ((Element)v.get(255)).setAttribute("max","30" );
      ((Element)v.get(255)).setAttribute("readonly","N" );
      ((Element)v.get(255)).setAttribute("tipo","" );
      ((Element)v.get(255)).setAttribute("req","N" );
      ((Element)v.get(255)).setAttribute("size","40" );
      ((Element)v.get(255)).setAttribute("valor","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(255)).setAttribute("validacion","" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(259)).setAttribute("onclick","levantarI18N('formularioInsertarCurso', '1');" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(251)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(263)).setAttribute("nombre","txtObjetivoCurso" );
      ((Element)v.get(263)).setAttribute("id","datosCampos" );
      ((Element)v.get(263)).setAttribute("max","30" );
      ((Element)v.get(263)).setAttribute("readonly","N" );
      ((Element)v.get(263)).setAttribute("tipo","" );
      ((Element)v.get(263)).setAttribute("onchange","" );
      ((Element)v.get(263)).setAttribute("req","N" );
      ((Element)v.get(263)).setAttribute("size","40" );
      ((Element)v.get(263)).setAttribute("valor","" );
      ((Element)v.get(263)).setAttribute("validacion","" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("nombre","txtObjetivoCursoI" );
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","25" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(251)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(267)).setAttribute("nombre","txtContenidoCurso" );
      ((Element)v.get(267)).setAttribute("id","datosCampos" );
      ((Element)v.get(267)).setAttribute("max","30" );
      ((Element)v.get(267)).setAttribute("readonly","N" );
      ((Element)v.get(267)).setAttribute("tipo","" );
      ((Element)v.get(267)).setAttribute("onchange","" );
      ((Element)v.get(267)).setAttribute("req","N" );
      ((Element)v.get(267)).setAttribute("size","40" );
      ((Element)v.get(267)).setAttribute("valor","" );
      ((Element)v.get(267)).setAttribute("validacion","" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("width","100%" );
      ((Element)v.get(251)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:251   */

      /* Empieza nodo:270 / Elemento padre: 233   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).setAttribute("colspan","4" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:233   */

      /* Empieza nodo:273 / Elemento padre: 190   */
      v.add(doc.createElement("table"));
      ((Element)v.get(273)).setAttribute("width","100%" );
      ((Element)v.get(273)).setAttribute("border","0" );
      ((Element)v.get(273)).setAttribute("align","center" );
      ((Element)v.get(273)).setAttribute("cellspacing","0" );
      ((Element)v.get(273)).setAttribute("cellpadding","0" );
      ((Element)v.get(190)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(278)).setAttribute("nombre","lblAccesoInfo" );
      ((Element)v.get(278)).setAttribute("alto","13" );
      ((Element)v.get(278)).setAttribute("filas","1" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(278)).setAttribute("id","datosTitle" );
      ((Element)v.get(278)).setAttribute("cod","709" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","25" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(282)).setAttribute("nombre","lblAccesoSeleccion" );
      ((Element)v.get(282)).setAttribute("alto","13" );
      ((Element)v.get(282)).setAttribute("filas","1" );
      ((Element)v.get(282)).setAttribute("valor","" );
      ((Element)v.get(282)).setAttribute("id","datosTitle" );
      ((Element)v.get(282)).setAttribute("cod","708" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("width","100%" );
      ((Element)v.get(274)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:274   */

      /* Empieza nodo:285 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","8" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(285)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(289)).setAttribute("nombre","cbAccesoInfo" );
      ((Element)v.get(289)).setAttribute("id","datosCampos" );
      ((Element)v.get(289)).setAttribute("size","1" );
      ((Element)v.get(289)).setAttribute("multiple","N" );
      ((Element)v.get(289)).setAttribute("readonly","N" );
      ((Element)v.get(289)).setAttribute("req","N" );
      ((Element)v.get(289)).setAttribute("valorinicial","" );
      ((Element)v.get(289)).setAttribute("textoinicial","" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:291 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","25" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(285)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("table"));
      ((Element)v.get(294)).setAttribute("width","100%" );
      ((Element)v.get(294)).setAttribute("border","0" );
      ((Element)v.get(294)).setAttribute("cellspacing","0" );
      ((Element)v.get(294)).setAttribute("cellpadding","0" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).setAttribute("class","datosCampos" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(297)).setAttribute("nombre","rbAccesoSeleccion" );
      ((Element)v.get(297)).setAttribute("tipo","H" );
      ((Element)v.get(297)).setAttribute("readonly","N" );
      ((Element)v.get(297)).setAttribute("req","N" );
      ((Element)v.get(297)).setAttribute("id","datosCampos" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(298)).setAttribute("valor","S" );
      ((Element)v.get(298)).setAttribute("check","N" );
      ((Element)v.get(298)).setAttribute("onfocus","" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("cod","117" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Elemento padre:298 / Elemento actual: 299   */
      v.add(doc.createTextNode("xxx"));
      ((Element)v.get(298)).appendChild((Text)v.get(299));

      /* Termina nodo Texto:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(300)).setAttribute("valor","N" );
      ((Element)v.get(300)).setAttribute("check","N" );
      ((Element)v.get(300)).setAttribute("onfocus","" );
      ((Element)v.get(300)).setAttribute("id","datosCampos" );
      ((Element)v.get(300)).setAttribute("cod","87" );
      ((Element)v.get(297)).appendChild((Element)v.get(300));

      /* Elemento padre:300 / Elemento actual: 301   */
      v.add(doc.createTextNode("ccc"));
      ((Element)v.get(300)).appendChild((Text)v.get(301));

      /* Termina nodo Texto:301   */
      /* Termina nodo:300   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:302 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).setAttribute("width","100%" );
      ((Element)v.get(285)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","8" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:285   */

      /* Empieza nodo:304 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).setAttribute("colspan","4" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:273   */

      /* Empieza nodo:307 / Elemento padre: 190   */
      v.add(doc.createElement("table"));
      ((Element)v.get(307)).setAttribute("nombre","nodoDatosGenerales5" );
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(307)).setAttribute("border","0" );
      ((Element)v.get(307)).setAttribute("align","center" );
      ((Element)v.get(307)).setAttribute("cellspacing","0" );
      ((Element)v.get(307)).setAttribute("cellpadding","0" );
      ((Element)v.get(190)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(312)).setAttribute("nombre","lblFrecuenciaDictado" );
      ((Element)v.get(312)).setAttribute("alto","13" );
      ((Element)v.get(312)).setAttribute("filas","1" );
      ((Element)v.get(312)).setAttribute("valor","" );
      ((Element)v.get(312)).setAttribute("id","datosTitle" );
      ((Element)v.get(312)).setAttribute("cod","731" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("nombre","lblFrecuenciaDictadoI" );
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","25" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(316)).setAttribute("nombre","lblFechaDisponible" );
      ((Element)v.get(316)).setAttribute("alto","13" );
      ((Element)v.get(316)).setAttribute("filas","1" );
      ((Element)v.get(316)).setAttribute("valor","" );
      ((Element)v.get(316)).setAttribute("id","datosTitle" );
      ((Element)v.get(316)).setAttribute("cod","725" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("nombre","lblFechaDisponibleI" );
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","25" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 308   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(320)).setAttribute("nombre","lblFechaLanzamiento" );
      ((Element)v.get(320)).setAttribute("alto","13" );
      ((Element)v.get(320)).setAttribute("filas","1" );
      ((Element)v.get(320)).setAttribute("valor","" );
      ((Element)v.get(320)).setAttribute("id","datosTitle" );
      ((Element)v.get(320)).setAttribute("cod","729" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("nombre","lblFechaLanzamientoI" );
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","25" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(324)).setAttribute("nombre","lblFechaFinalizacion" );
      ((Element)v.get(324)).setAttribute("alto","13" );
      ((Element)v.get(324)).setAttribute("filas","1" );
      ((Element)v.get(324)).setAttribute("valor","" );
      ((Element)v.get(324)).setAttribute("id","datosTitle" );
      ((Element)v.get(324)).setAttribute("cod","726" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("width","100%" );
      ((Element)v.get(308)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:308   */

      /* Empieza nodo:327 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(327)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(331)).setAttribute("nombre","cbFrecuenciaDictado" );
      ((Element)v.get(331)).setAttribute("id","datosCampos" );
      ((Element)v.get(331)).setAttribute("size","1" );
      ((Element)v.get(331)).setAttribute("multiple","N" );
      ((Element)v.get(331)).setAttribute("readonly","N" );
      ((Element)v.get(331)).setAttribute("req","N" );
      ((Element)v.get(331)).setAttribute("valorinicial","" );
      ((Element)v.get(331)).setAttribute("textoinicial","" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:333 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("nombre","cbFrecuenciaDictadoI" );
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(327)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(336)).setAttribute("nombre","txtFechaDisponible" );
      ((Element)v.get(336)).setAttribute("id","datosCampos" );
      ((Element)v.get(336)).setAttribute("max","10" );
      ((Element)v.get(336)).setAttribute("tipo","" );
      ((Element)v.get(336)).setAttribute("onblur","validaFecha('txtFechaDisponible')" );
      ((Element)v.get(336)).setAttribute("readonly","N" );
      ((Element)v.get(336)).setAttribute("req","N" );
      ((Element)v.get(336)).setAttribute("size","12" );
      ((Element)v.get(336)).setAttribute("valor","" );
      ((Element)v.get(336)).setAttribute("validacion","" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("nombre","txtFechaDisponibleI" );
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","25" );
      ((Element)v.get(338)).setAttribute("height","8" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(327)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(340)).setAttribute("nombre","txtFechaLanzamiento" );
      ((Element)v.get(340)).setAttribute("id","datosCampos" );
      ((Element)v.get(340)).setAttribute("max","10" );
      ((Element)v.get(340)).setAttribute("tipo","" );
      ((Element)v.get(340)).setAttribute("onblur","validaFecha('txtFechaLanzamiento');" );
      ((Element)v.get(340)).setAttribute("readonly","N" );
      ((Element)v.get(340)).setAttribute("req","N" );
      ((Element)v.get(340)).setAttribute("size","12" );
      ((Element)v.get(340)).setAttribute("valor","" );
      ((Element)v.get(340)).setAttribute("validacion","" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("nombre","txtFechaLanzamientoI" );
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","25" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(327)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(344)).setAttribute("nombre","txtFechaFinalizacion" );
      ((Element)v.get(344)).setAttribute("id","datosCampos" );
      ((Element)v.get(344)).setAttribute("max","10" );
      ((Element)v.get(344)).setAttribute("tipo","" );
      ((Element)v.get(344)).setAttribute("onblur","validaFecha('txtFechaFinalizacion');" );
      ((Element)v.get(344)).setAttribute("readonly","N" );
      ((Element)v.get(344)).setAttribute("req","N" );
      ((Element)v.get(344)).setAttribute("size","12" );
      ((Element)v.get(344)).setAttribute("valor","" );
      ((Element)v.get(344)).setAttribute("validacion","" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).setAttribute("width","100%" );
      ((Element)v.get(327)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","8" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:327   */

      /* Empieza nodo:347 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("colspan","4" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:307   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:350 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:186   */

      /* Empieza nodo:352 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("colspan","4" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(354)).setAttribute("height","15" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:355 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).setAttribute("nombre","nodoDatosGeograficos" );
      ((Element)v.get(178)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(360)).setAttribute("class","legend" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(361)).setAttribute("nombre","lblDatosGeo" );
      ((Element)v.get(361)).setAttribute("alto","13" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(361)).setAttribute("filas","1" );
      ((Element)v.get(361)).setAttribute("valor","Datos geográficos" );
      ((Element)v.get(361)).setAttribute("id","legend" );
      ((Element)v.get(361)).setAttribute("cod","00152" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 359   */
      v.add(doc.createElement("table"));
      ((Element)v.get(362)).setAttribute("nombre","nodoDatosGeograficos1" );
      ((Element)v.get(362)).setAttribute("width","100%" );
      ((Element)v.get(362)).setAttribute("border","0" );
      ((Element)v.get(362)).setAttribute("align","center" );
      ((Element)v.get(362)).setAttribute("cellspacing","0" );
      ((Element)v.get(362)).setAttribute("cellpadding","0" );
      ((Element)v.get(359)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("colspan","4" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","8" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:366 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(370)).setAttribute("nombre","lblAlcanceGeoNacional" );
      ((Element)v.get(370)).setAttribute("alto","13" );
      ((Element)v.get(370)).setAttribute("filas","1" );
      ((Element)v.get(370)).setAttribute("valor","" );
      ((Element)v.get(370)).setAttribute("id","datosTitle" );
      ((Element)v.get(370)).setAttribute("cod","710" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","25" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(374)).setAttribute("nombre","lblSubVentas" );
      ((Element)v.get(374)).setAttribute("alto","13" );
      ((Element)v.get(374)).setAttribute("filas","1" );
      ((Element)v.get(374)).setAttribute("valor","" );
      ((Element)v.get(374)).setAttribute("id","datosTitle" );
      ((Element)v.get(374)).setAttribute("cod","124" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("width","100%" );
      ((Element)v.get(366)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:366   */

      /* Empieza nodo:377 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(377)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("table"));
      ((Element)v.get(381)).setAttribute("width","100%" );
      ((Element)v.get(381)).setAttribute("border","0" );
      ((Element)v.get(381)).setAttribute("cellspacing","0" );
      ((Element)v.get(381)).setAttribute("cellpadding","0" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("class","datosCampos" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(384)).setAttribute("nombre","rbAlcanceGeoNacional" );
      ((Element)v.get(384)).setAttribute("tipo","H" );
      ((Element)v.get(384)).setAttribute("readonly","N" );
      ((Element)v.get(384)).setAttribute("req","N" );
      ((Element)v.get(384)).setAttribute("id","datosCampos" );
      ((Element)v.get(384)).setAttribute("onclick","modificaAlcanceHabilita();" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(385)).setAttribute("valor","S" );
      ((Element)v.get(385)).setAttribute("check","N" );
      ((Element)v.get(385)).setAttribute("onfocus","" );
      ((Element)v.get(385)).setAttribute("id","datosCampos" );
      ((Element)v.get(385)).setAttribute("cod","117" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Elemento padre:385 / Elemento actual: 386   */
      v.add(doc.createTextNode("xxx"));
      ((Element)v.get(385)).appendChild((Text)v.get(386));

      /* Termina nodo Texto:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 384   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(387)).setAttribute("valor","N" );
      ((Element)v.get(387)).setAttribute("check","N" );
      ((Element)v.get(387)).setAttribute("onfocus","" );
      ((Element)v.get(387)).setAttribute("id","datosCampos" );
      ((Element)v.get(387)).setAttribute("cod","87" );
      ((Element)v.get(384)).appendChild((Element)v.get(387));

      /* Elemento padre:387 / Elemento actual: 388   */
      v.add(doc.createTextNode("ccc"));
      ((Element)v.get(387)).appendChild((Text)v.get(388));

      /* Termina nodo Texto:388   */
      /* Termina nodo:387   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:389 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(390)).setAttribute("width","25" );
      ((Element)v.get(390)).setAttribute("height","8" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(377)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(392)).setAttribute("nombre","cbSubVentas" );
      ((Element)v.get(392)).setAttribute("id","datosCampos" );
      ((Element)v.get(392)).setAttribute("size","1" );
      ((Element)v.get(392)).setAttribute("multiple","N" );
      ((Element)v.get(392)).setAttribute("readonly","N" );
      ((Element)v.get(392)).setAttribute("req","N" );
      ((Element)v.get(392)).setAttribute("onchange","cargaComboRegion();" );
      ((Element)v.get(392)).setAttribute("valorinicial","" );
      ((Element)v.get(392)).setAttribute("textoinicial","" );
      ((Element)v.get(392)).setAttribute("onfocus","" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:394 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).setAttribute("width","100%" );
      ((Element)v.get(377)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","8" );
      ((Element)v.get(395)).setAttribute("height","8" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:377   */

      /* Empieza nodo:396 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).setAttribute("colspan","4" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","8" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:362   */

      /* Empieza nodo:399 / Elemento padre: 359   */
      v.add(doc.createElement("table"));
      ((Element)v.get(399)).setAttribute("nombre","nodoDatosGeograficos2" );
      ((Element)v.get(399)).setAttribute("width","100%" );
      ((Element)v.get(399)).setAttribute("border","0" );
      ((Element)v.get(399)).setAttribute("align","center" );
      ((Element)v.get(399)).setAttribute("cellspacing","0" );
      ((Element)v.get(399)).setAttribute("cellpadding","0" );
      ((Element)v.get(359)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","8" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(404)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(404)).setAttribute("alto","13" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(404)).setAttribute("filas","1" );
      ((Element)v.get(404)).setAttribute("valor","" );
      ((Element)v.get(404)).setAttribute("id","datosTitle" );
      ((Element)v.get(404)).setAttribute("cod","109" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("nombre","lblRegionI" );
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","25" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(408)).setAttribute("nombre","lblZona" );
      ((Element)v.get(408)).setAttribute("alto","13" );
      ((Element)v.get(408)).setAttribute("filas","1" );
      ((Element)v.get(408)).setAttribute("valor","" );
      ((Element)v.get(408)).setAttribute("id","datosTitle" );
      ((Element)v.get(408)).setAttribute("cod","143" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).setAttribute("width","100%" );
      ((Element)v.get(400)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","8" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:400   */

      /* Empieza nodo:411 / Elemento padre: 399   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(399)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","8" );
      ((Element)v.get(413)).setAttribute("height","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 411   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(411)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(415)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(415)).setAttribute("id","datosCampos" );
      ((Element)v.get(415)).setAttribute("size","1" );
      ((Element)v.get(415)).setAttribute("multiple","N" );
      ((Element)v.get(415)).setAttribute("readonly","N" );
      ((Element)v.get(415)).setAttribute("req","N" );
      ((Element)v.get(415)).setAttribute("onchange","cargaComboZona();" );
      ((Element)v.get(415)).setAttribute("valorinicial","" );
      ((Element)v.get(415)).setAttribute("textoinicial","" );
      ((Element)v.get(415)).setAttribute("onfocus","" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:417 / Elemento padre: 411   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("nombre","cbRegionI" );
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","25" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 411   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(411)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(420)).setAttribute("nombre","cbZona" );
      ((Element)v.get(420)).setAttribute("id","datosCampos" );
      ((Element)v.get(420)).setAttribute("size","1" );
      ((Element)v.get(420)).setAttribute("multiple","N" );
      ((Element)v.get(420)).setAttribute("readonly","N" );
      ((Element)v.get(420)).setAttribute("req","N" );
      ((Element)v.get(420)).setAttribute("onchange","cargaComboSeccion();" );
      ((Element)v.get(420)).setAttribute("valorinicial","" );
      ((Element)v.get(420)).setAttribute("textoinicial","" );
      ((Element)v.get(420)).setAttribute("onfocus","" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:422 / Elemento padre: 411   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).setAttribute("width","100%" );
      ((Element)v.get(411)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:411   */

      /* Empieza nodo:424 / Elemento padre: 399   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(399)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(425)).setAttribute("colspan","4" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:399   */

      /* Empieza nodo:427 / Elemento padre: 359   */
      v.add(doc.createElement("table"));
      ((Element)v.get(427)).setAttribute("nombre","nodoDatosGeograficos3" );
      ((Element)v.get(427)).setAttribute("width","100%" );
      ((Element)v.get(427)).setAttribute("border","0" );
      ((Element)v.get(427)).setAttribute("align","center" );
      ((Element)v.get(427)).setAttribute("cellspacing","0" );
      ((Element)v.get(427)).setAttribute("cellpadding","0" );
      ((Element)v.get(359)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).setAttribute("colspan","4" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","8" );
      ((Element)v.get(430)).setAttribute("height","8" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:431 / Elemento padre: 427   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(427)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(433)).setAttribute("width","8" );
      ((Element)v.get(433)).setAttribute("height","8" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(435)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(435)).setAttribute("alto","13" );
      ((Element)v.get(435)).setAttribute("filas","1" );
      ((Element)v.get(435)).setAttribute("valor","" );
      ((Element)v.get(435)).setAttribute("id","datosTitle" );
      ((Element)v.get(435)).setAttribute("cod","112" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("nombre","lblSeccionI" );
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","25" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(439)).setAttribute("nombre","lblTerritorio" );
      ((Element)v.get(439)).setAttribute("alto","13" );
      ((Element)v.get(439)).setAttribute("filas","1" );
      ((Element)v.get(439)).setAttribute("valor","" );
      ((Element)v.get(439)).setAttribute("id","datosTitle" );
      ((Element)v.get(439)).setAttribute("cod","126" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(440)).setAttribute("width","100%" );
      ((Element)v.get(431)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(441)).setAttribute("src","b.gif" );
      ((Element)v.get(441)).setAttribute("width","8" );
      ((Element)v.get(441)).setAttribute("height","8" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:431   */

      /* Empieza nodo:442 / Elemento padre: 427   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(427)).appendChild((Element)v.get(442));

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
      ((Element)v.get(445)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(442)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(446)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(446)).setAttribute("id","datosCampos" );
      ((Element)v.get(446)).setAttribute("size","1" );
      ((Element)v.get(446)).setAttribute("multiple","N" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(446)).setAttribute("readonly","N" );
      ((Element)v.get(446)).setAttribute("req","N" );
      ((Element)v.get(446)).setAttribute("onchange","cargaComboTerritorio();" );
      ((Element)v.get(446)).setAttribute("valorinicial","" );
      ((Element)v.get(446)).setAttribute("textoinicial","" );
      ((Element)v.get(446)).setAttribute("onfocus","" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:448 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("nombre","cbSeccionI" );
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","25" );
      ((Element)v.get(449)).setAttribute("height","8" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(442)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(451)).setAttribute("nombre","cbTerritorio" );
      ((Element)v.get(451)).setAttribute("id","datosCampos" );
      ((Element)v.get(451)).setAttribute("size","1" );
      ((Element)v.get(451)).setAttribute("multiple","N" );
      ((Element)v.get(451)).setAttribute("readonly","N" );
      ((Element)v.get(451)).setAttribute("req","N" );
      ((Element)v.get(451)).setAttribute("valorinicial","" );
      ((Element)v.get(451)).setAttribute("textoinicial","" );
      ((Element)v.get(451)).setAttribute("onfocus","" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:453 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).setAttribute("width","100%" );
      ((Element)v.get(442)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","8" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:442   */

      /* Empieza nodo:455 / Elemento padre: 427   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(427)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).setAttribute("colspan","4" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).setAttribute("width","8" );
      ((Element)v.get(457)).setAttribute("height","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:427   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:458 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:355   */

      /* Empieza nodo:460 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(460)).setAttribute("nombre","nodoImagenDatosGeograficos" );
      ((Element)v.get(178)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).setAttribute("colspan","4" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","8" );
      ((Element)v.get(462)).setAttribute("height","15" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:463 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(463)).setAttribute("nombre","nodoDatosCurso" );
      ((Element)v.get(178)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(468)).setAttribute("class","legend" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(469)).setAttribute("nombre","lblDatosCurso" );
      ((Element)v.get(469)).setAttribute("alto","13" );
      ((Element)v.get(469)).setAttribute("filas","1" );
      ((Element)v.get(469)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(469)).setAttribute("id","legend" );
      ((Element)v.get(469)).setAttribute("cod","00148" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 467   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(470)).setAttribute("nombre","nodoDatosCurso1" );
      ((Element)v.get(470)).setAttribute("width","100%" );
      ((Element)v.get(470)).setAttribute("border","0" );
      ((Element)v.get(470)).setAttribute("align","center" );
      ((Element)v.get(470)).setAttribute("cellspacing","0" );
      ((Element)v.get(470)).setAttribute("cellpadding","0" );
      ((Element)v.get(467)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).setAttribute("colspan","4" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","8" );
      ((Element)v.get(473)).setAttribute("height","8" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:474 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","8" );
      ((Element)v.get(476)).setAttribute("height","8" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(478)).setAttribute("nombre","lblOptimoParticipantes" );
      ((Element)v.get(478)).setAttribute("alto","13" );
      ((Element)v.get(478)).setAttribute("filas","1" );
      ((Element)v.get(478)).setAttribute("valor","" );
      ((Element)v.get(478)).setAttribute("id","datosTitle" );
      ((Element)v.get(478)).setAttribute("cod","739" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("nombre","lblOptimoParticipantesI" );
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","25" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(482)).setAttribute("nombre","lblBloqueo" );
      ((Element)v.get(482)).setAttribute("alto","13" );
      ((Element)v.get(482)).setAttribute("filas","1" );
      ((Element)v.get(482)).setAttribute("valor","" );
      ((Element)v.get(482)).setAttribute("id","datosTitle" );
      ((Element)v.get(482)).setAttribute("cod","713" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:483 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("nombre","lblBloqueoI" );
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","25" );
      ((Element)v.get(484)).setAttribute("height","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:485 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(486)).setAttribute("nombre","lblMaterialAEmplear" );
      ((Element)v.get(486)).setAttribute("alto","13" );
      ((Element)v.get(486)).setAttribute("filas","1" );
      ((Element)v.get(486)).setAttribute("valor","" );
      ((Element)v.get(486)).setAttribute("id","datosTitle" );
      ((Element)v.get(486)).setAttribute("cod","735" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:487 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(487)).setAttribute("width","100%" );
      ((Element)v.get(474)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(488)).setAttribute("src","b.gif" );
      ((Element)v.get(488)).setAttribute("width","8" );
      ((Element)v.get(488)).setAttribute("height","8" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:474   */

      /* Empieza nodo:489 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(489));

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
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(489)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(493)).setAttribute("nombre","txtOptimoParticipantes" );
      ((Element)v.get(493)).setAttribute("id","datosCampos" );
      ((Element)v.get(493)).setAttribute("max","2" );
      ((Element)v.get(493)).setAttribute("tipo","" );
      ((Element)v.get(493)).setAttribute("onblur","validaEntero('txtOptimoParticipantes');" );
      ((Element)v.get(493)).setAttribute("readonly","N" );
      ((Element)v.get(493)).setAttribute("req","N" );
      ((Element)v.get(493)).setAttribute("size","2" );
      ((Element)v.get(493)).setAttribute("valor","" );
      ((Element)v.get(493)).setAttribute("validacion","" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("nombre","txtOptimoParticipantesI" );
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","25" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(496)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(489)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("table"));
      ((Element)v.get(497)).setAttribute("width","100%" );
      ((Element)v.get(497)).setAttribute("border","0" );
      ((Element)v.get(497)).setAttribute("cellspacing","0" );
      ((Element)v.get(497)).setAttribute("cellpadding","0" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).setAttribute("class","datosCampos" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(500)).setAttribute("nombre","rbBloqueo" );
      ((Element)v.get(500)).setAttribute("readonly","N" );
      ((Element)v.get(500)).setAttribute("tipo","H" );
      ((Element)v.get(500)).setAttribute("req","N" );
      ((Element)v.get(500)).setAttribute("id","datosCampos" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(501)).setAttribute("valor","S" );
      ((Element)v.get(501)).setAttribute("check","N" );
      ((Element)v.get(501)).setAttribute("onfocus","" );
      ((Element)v.get(501)).setAttribute("id","datosCampos" );
      ((Element)v.get(501)).setAttribute("cod","117" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Elemento padre:501 / Elemento actual: 502   */
      v.add(doc.createTextNode("xxx"));
      ((Element)v.get(501)).appendChild((Text)v.get(502));

      /* Termina nodo Texto:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 500   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(503)).setAttribute("valor","N" );
      ((Element)v.get(503)).setAttribute("check","N" );
      ((Element)v.get(503)).setAttribute("onfocus","" );
      ((Element)v.get(503)).setAttribute("id","datosCampos" );
      ((Element)v.get(503)).setAttribute("cod","87" );
      ((Element)v.get(500)).appendChild((Element)v.get(503));

      /* Elemento padre:503 / Elemento actual: 504   */
      v.add(doc.createTextNode("ccc"));
      ((Element)v.get(503)).appendChild((Text)v.get(504));

      /* Termina nodo Texto:504   */
      /* Termina nodo:503   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:505 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("nombre","rbBloqueoI" );
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","25" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:507 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(489)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(508)).setAttribute("nombre","txtMaterialAEmplear" );
      ((Element)v.get(508)).setAttribute("id","datosCampos" );
      ((Element)v.get(508)).setAttribute("max","30" );
      ((Element)v.get(508)).setAttribute("tipo","" );
      ((Element)v.get(508)).setAttribute("onchange","" );
      ((Element)v.get(508)).setAttribute("readonly","N" );
      ((Element)v.get(508)).setAttribute("req","N" );
      ((Element)v.get(508)).setAttribute("size","36" );
      ((Element)v.get(508)).setAttribute("valor","" );
      ((Element)v.get(508)).setAttribute("validacion","" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(509)).setAttribute("width","100%" );
      ((Element)v.get(489)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(510)).setAttribute("width","8" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:489   */

      /* Empieza nodo:511 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).setAttribute("colspan","4" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","8" );
      ((Element)v.get(513)).setAttribute("height","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:470   */

      /* Empieza nodo:514 / Elemento padre: 467   */
      v.add(doc.createElement("table"));
      ((Element)v.get(514)).setAttribute("nombre","nodoDatosCurso2" );
      ((Element)v.get(514)).setAttribute("width","100%" );
      ((Element)v.get(514)).setAttribute("border","0" );
      ((Element)v.get(514)).setAttribute("align","center" );
      ((Element)v.get(514)).setAttribute("cellspacing","0" );
      ((Element)v.get(514)).setAttribute("cellpadding","0" );
      ((Element)v.get(467)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","8" );
      ((Element)v.get(517)).setAttribute("height","8" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(519)).setAttribute("nombre","lblCapacitador" );
      ((Element)v.get(519)).setAttribute("alto","13" );
      ((Element)v.get(519)).setAttribute("filas","1" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(519)).setAttribute("id","datosTitle" );
      ((Element)v.get(519)).setAttribute("cod","714" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(520)).setAttribute("width","100%" );
      ((Element)v.get(515)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","8" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:515   */

      /* Empieza nodo:522 / Elemento padre: 514   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(514)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","b.gif" );
      ((Element)v.get(524)).setAttribute("width","8" );
      ((Element)v.get(524)).setAttribute("height","8" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:525 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(525)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(522)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(526)).setAttribute("nombre","cbCapacitador" );
      ((Element)v.get(526)).setAttribute("id","datosCampos" );
      ((Element)v.get(526)).setAttribute("size","1" );
      ((Element)v.get(526)).setAttribute("multiple","N" );
      ((Element)v.get(526)).setAttribute("readonly","N" );
      ((Element)v.get(526)).setAttribute("req","N" );
      ((Element)v.get(526)).setAttribute("onchange","cargaValoresOcultosCapacitador();" );
      ((Element)v.get(526)).setAttribute("valorinicial","" );
      ((Element)v.get(526)).setAttribute("textoinicial","" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:528 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).setAttribute("width","100%" );
      ((Element)v.get(522)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:522   */

      /* Empieza nodo:530 / Elemento padre: 514   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(514)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(531)).setAttribute("colspan","4" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","8" );
      ((Element)v.get(532)).setAttribute("height","8" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:514   */

      /* Empieza nodo:533 / Elemento padre: 467   */
      v.add(doc.createElement("table"));
      ((Element)v.get(533)).setAttribute("nombre","nodoDatosCurso3" );
      ((Element)v.get(533)).setAttribute("width","100%" );
      ((Element)v.get(533)).setAttribute("border","0" );
      ((Element)v.get(533)).setAttribute("align","center" );
      ((Element)v.get(533)).setAttribute("cellspacing","0" );
      ((Element)v.get(533)).setAttribute("cellpadding","0" );
      ((Element)v.get(467)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","8" );
      ((Element)v.get(536)).setAttribute("height","8" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(538)).setAttribute("nombre","lblEstatusCursos" );
      ((Element)v.get(538)).setAttribute("alto","13" );
      ((Element)v.get(538)).setAttribute("filas","1" );
      ((Element)v.get(538)).setAttribute("valor","" );
      ((Element)v.get(538)).setAttribute("id","datosTitle" );
      ((Element)v.get(538)).setAttribute("cod","3059" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("nombre","lblEstatusCursosI" );
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","25" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(542)).setAttribute("nombre","lblFechaUltimo" );
      ((Element)v.get(542)).setAttribute("alto","13" );
      ((Element)v.get(542)).setAttribute("filas","1" );
      ((Element)v.get(542)).setAttribute("valor","" );
      ((Element)v.get(542)).setAttribute("id","datosTitle" );
      ((Element)v.get(542)).setAttribute("cod","730" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:543 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(543)).setAttribute("width","100%" );
      ((Element)v.get(534)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(544)).setAttribute("src","b.gif" );
      ((Element)v.get(544)).setAttribute("width","8" );
      ((Element)v.get(544)).setAttribute("height","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */
      /* Termina nodo:534   */

      /* Empieza nodo:545 / Elemento padre: 533   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(533)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("td"));
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","8" );
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 545   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(545)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(549)).setAttribute("nombre","cbCursosExigidos" );
      ((Element)v.get(549)).setAttribute("id","datosCampos" );
      ((Element)v.get(549)).setAttribute("size","5" );
      ((Element)v.get(549)).setAttribute("multiple","S" );
      ((Element)v.get(549)).setAttribute("readonly","N" );
      ((Element)v.get(549)).setAttribute("req","N" );
      ((Element)v.get(549)).setAttribute("valorinicial","" );
      ((Element)v.get(549)).setAttribute("textoinicial","" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:551 / Elemento padre: 545   */
      v.add(doc.createElement("td"));
      ((Element)v.get(545)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("nombre","cbCursosExigidosI" );
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","25" );
      ((Element)v.get(552)).setAttribute("height","8" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 545   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(553)).setAttribute("valign","top" );
      ((Element)v.get(545)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(554)).setAttribute("nombre","txtFechaUltimo" );
      ((Element)v.get(554)).setAttribute("id","datosCampos" );
      ((Element)v.get(554)).setAttribute("max","10" );
      ((Element)v.get(554)).setAttribute("tipo","" );
      ((Element)v.get(554)).setAttribute("onblur","validaFecha('txtFechaUltimo');" );
      ((Element)v.get(554)).setAttribute("readonly","N" );
      ((Element)v.get(554)).setAttribute("req","N" );
      ((Element)v.get(554)).setAttribute("size","12" );
      ((Element)v.get(554)).setAttribute("valor","" );
      ((Element)v.get(554)).setAttribute("validacion","" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 545   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).setAttribute("width","100%" );
      ((Element)v.get(545)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","8" );
      ((Element)v.get(556)).setAttribute("height","8" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:545   */

      /* Empieza nodo:557 / Elemento padre: 533   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(533)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("colspan","4" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","8" );
      ((Element)v.get(559)).setAttribute("height","8" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */
      /* Termina nodo:533   */

      /* Empieza nodo:560 / Elemento padre: 467   */
      v.add(doc.createElement("table"));
      ((Element)v.get(560)).setAttribute("nombre","nodoDatosCurso4" );
      ((Element)v.get(560)).setAttribute("width","100%" );
      ((Element)v.get(560)).setAttribute("border","0" );
      ((Element)v.get(560)).setAttribute("align","center" );
      ((Element)v.get(560)).setAttribute("cellspacing","0" );
      ((Element)v.get(560)).setAttribute("cellpadding","0" );
      ((Element)v.get(467)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(563)).setAttribute("src","b.gif" );
      ((Element)v.get(563)).setAttribute("width","8" );
      ((Element)v.get(563)).setAttribute("height","8" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(565)).setAttribute("nombre","lblCondicionPedido" );
      ((Element)v.get(565)).setAttribute("alto","13" );
      ((Element)v.get(565)).setAttribute("filas","1" );
      ((Element)v.get(565)).setAttribute("valor","" );
      ((Element)v.get(565)).setAttribute("id","datosTitle" );
      ((Element)v.get(565)).setAttribute("cod","718" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("nombre","lblCondicionPedidoI" );
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).setAttribute("width","25" );
      ((Element)v.get(567)).setAttribute("height","8" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(569)).setAttribute("nombre","lblControlMorosidad" );
      ((Element)v.get(569)).setAttribute("alto","13" );
      ((Element)v.get(569)).setAttribute("filas","1" );
      ((Element)v.get(569)).setAttribute("valor","" );
      ((Element)v.get(569)).setAttribute("id","datosTitle" );
      ((Element)v.get(569)).setAttribute("cod","720" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(571)).setAttribute("nombre","lblControlMorosidadI" );
      ((Element)v.get(571)).setAttribute("src","b.gif" );
      ((Element)v.get(571)).setAttribute("width","25" );
      ((Element)v.get(571)).setAttribute("height","8" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(573)).setAttribute("nombre","lblDescDetallada" );
      ((Element)v.get(573)).setAttribute("alto","13" );
      ((Element)v.get(573)).setAttribute("filas","1" );
      ((Element)v.get(573)).setAttribute("valor","" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(573)).setAttribute("id","datosTitle" );
      ((Element)v.get(573)).setAttribute("cod","722" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).setAttribute("width","100%" );
      ((Element)v.get(561)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(575)).setAttribute("src","b.gif" );
      ((Element)v.get(575)).setAttribute("width","8" );
      ((Element)v.get(575)).setAttribute("height","8" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:561   */

      /* Empieza nodo:576 / Elemento padre: 560   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(560)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(578)).setAttribute("src","b.gif" );
      ((Element)v.get(578)).setAttribute("width","8" );
      ((Element)v.get(578)).setAttribute("height","8" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */

      /* Empieza nodo:579 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(579)).setAttribute("valign","top" );
      ((Element)v.get(576)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("table"));
      ((Element)v.get(580)).setAttribute("width","100%" );
      ((Element)v.get(580)).setAttribute("border","0" );
      ((Element)v.get(580)).setAttribute("cellspacing","0" );
      ((Element)v.get(580)).setAttribute("cellpadding","0" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).setAttribute("class","datosCampos" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(583)).setAttribute("nombre","rbCondicionPedido" );
      ((Element)v.get(583)).setAttribute("readonly","N" );
      ((Element)v.get(583)).setAttribute("tipo","H" );
      ((Element)v.get(583)).setAttribute("req","N" );
      ((Element)v.get(583)).setAttribute("id","datosCampos" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(584)).setAttribute("valor","S" );
      ((Element)v.get(584)).setAttribute("check","N" );
      ((Element)v.get(584)).setAttribute("onfocus","" );
      ((Element)v.get(584)).setAttribute("id","datosCampos" );
      ((Element)v.get(584)).setAttribute("cod","117" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Elemento padre:584 / Elemento actual: 585   */
      v.add(doc.createTextNode("xxx"));
      ((Element)v.get(584)).appendChild((Text)v.get(585));

      /* Termina nodo Texto:585   */
      /* Termina nodo:584   */

      /* Empieza nodo:586 / Elemento padre: 583   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(586)).setAttribute("valor","N" );
      ((Element)v.get(586)).setAttribute("check","N" );
      ((Element)v.get(586)).setAttribute("onfocus","" );
      ((Element)v.get(586)).setAttribute("id","datosCampos" );
      ((Element)v.get(586)).setAttribute("cod","87" );
      ((Element)v.get(583)).appendChild((Element)v.get(586));

      /* Elemento padre:586 / Elemento actual: 587   */
      v.add(doc.createTextNode("ccc"));
      ((Element)v.get(586)).appendChild((Text)v.get(587));

      /* Termina nodo Texto:587   */
      /* Termina nodo:586   */
      /* Termina nodo:583   */
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:588 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("nombre","rbCondicionPedidoI" );
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).setAttribute("width","25" );
      ((Element)v.get(589)).setAttribute("height","8" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(590)).setAttribute("valign","top" );
      ((Element)v.get(576)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("table"));
      ((Element)v.get(591)).setAttribute("width","100%" );
      ((Element)v.get(591)).setAttribute("border","0" );
      ((Element)v.get(591)).setAttribute("cellspacing","0" );
      ((Element)v.get(591)).setAttribute("cellpadding","0" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(591)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(593)).setAttribute("class","datosCampos" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(594)).setAttribute("nombre","rbControlMorosidad" );
      ((Element)v.get(594)).setAttribute("readonly","N" );
      ((Element)v.get(594)).setAttribute("tipo","H" );
      ((Element)v.get(594)).setAttribute("req","N" );
      ((Element)v.get(594)).setAttribute("id","datosCampos" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(595)).setAttribute("valor","S" );
      ((Element)v.get(595)).setAttribute("check","N" );
      ((Element)v.get(595)).setAttribute("onfocus","" );
      ((Element)v.get(595)).setAttribute("id","datosCampos" );
      ((Element)v.get(595)).setAttribute("cod","117" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Elemento padre:595 / Elemento actual: 596   */
      v.add(doc.createTextNode("xxx"));
      ((Element)v.get(595)).appendChild((Text)v.get(596));

      /* Termina nodo Texto:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:597 / Elemento padre: 594   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(597)).setAttribute("valor","N" );
      ((Element)v.get(597)).setAttribute("check","N" );
      ((Element)v.get(597)).setAttribute("onfocus","" );
      ((Element)v.get(597)).setAttribute("id","datosCampos" );
      ((Element)v.get(597)).setAttribute("cod","87" );
      ((Element)v.get(594)).appendChild((Element)v.get(597));

      /* Elemento padre:597 / Elemento actual: 598   */
      v.add(doc.createTextNode("ccc"));
      ((Element)v.get(597)).appendChild((Text)v.get(598));

      /* Termina nodo Texto:598   */
      /* Termina nodo:597   */
      /* Termina nodo:594   */
      /* Termina nodo:593   */
      /* Termina nodo:592   */
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:599 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("nombre","rbControlMorosidadI" );
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","25" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(576)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(602)).setAttribute("cols","50" );
      ((Element)v.get(602)).setAttribute("id","datosCampos" );
      ((Element)v.get(602)).setAttribute("msjreq","" );
      ((Element)v.get(602)).setAttribute("nombre","areaDescDetallada" );
      ((Element)v.get(602)).setAttribute("readonly","N" );
      ((Element)v.get(602)).setAttribute("req","N" );
      ((Element)v.get(602)).setAttribute("rows","3" );
      ((Element)v.get(602)).setAttribute("tabindex","2" );
      ((Element)v.get(602)).setAttribute("valor","" );
      ((Element)v.get(602)).setAttribute("max","100" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:603 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(603)).setAttribute("width","100%" );
      ((Element)v.get(576)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("width","8" );
      ((Element)v.get(604)).setAttribute("height","8" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */
      /* Termina nodo:576   */

      /* Empieza nodo:605 / Elemento padre: 560   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(560)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).setAttribute("colspan","4" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).setAttribute("width","8" );
      ((Element)v.get(607)).setAttribute("height","8" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */
      /* Termina nodo:605   */
      /* Termina nodo:560   */
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:608 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(609)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */
      /* Termina nodo:463   */

      /* Empieza nodo:610 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(610)).setAttribute("nombre","nodoImagenDatosCurso" );
      ((Element)v.get(178)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("td"));
      ((Element)v.get(611)).setAttribute("colspan","4" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","8" );
      ((Element)v.get(612)).setAttribute("height","15" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:613 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(613)).setAttribute("nombre","nodoClasificacionCliente" );
      ((Element)v.get(178)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(615)).setAttribute("src","b.gif" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:616 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(613)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(618)).setAttribute("class","legend" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(619)).setAttribute("nombre","lblClasificacionCliente" );
      ((Element)v.get(619)).setAttribute("alto","13" );
      ((Element)v.get(619)).setAttribute("filas","1" );
      ((Element)v.get(619)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(619)).setAttribute("id","legend" );
      ((Element)v.get(619)).setAttribute("cod","00276" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */

      /* Empieza nodo:620 / Elemento padre: 617   */
      v.add(doc.createElement("table"));
      ((Element)v.get(620)).setAttribute("nombre","nodoClasificacionCliente1" );
      ((Element)v.get(620)).setAttribute("width","100%" );
      ((Element)v.get(620)).setAttribute("border","0" );
      ((Element)v.get(620)).setAttribute("align","center" );
      ((Element)v.get(620)).setAttribute("cellspacing","0" );
      ((Element)v.get(620)).setAttribute("cellpadding","0" );
      ((Element)v.get(617)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).setAttribute("colspan","4" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(623)).setAttribute("src","b.gif" );
      ((Element)v.get(623)).setAttribute("width","8" );
      ((Element)v.get(623)).setAttribute("height","8" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:624 / Elemento padre: 620   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(620)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","8" );
      ((Element)v.get(626)).setAttribute("height","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:627 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(628)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(628)).setAttribute("alto","13" );
      ((Element)v.get(628)).setAttribute("filas","1" );
      ((Element)v.get(628)).setAttribute("valor","" );
      ((Element)v.get(628)).setAttribute("id","datosTitle" );
      ((Element)v.get(628)).setAttribute("cod","393" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:629 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(630)).setAttribute("src","b.gif" );
      ((Element)v.get(630)).setAttribute("width","25" );
      ((Element)v.get(630)).setAttribute("height","8" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */

      /* Empieza nodo:631 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(632)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(632)).setAttribute("alto","13" );
      ((Element)v.get(632)).setAttribute("filas","1" );
      ((Element)v.get(632)).setAttribute("valor","" );
      ((Element)v.get(632)).setAttribute("id","datosTitle" );
      ((Element)v.get(632)).setAttribute("cod","595" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(633)).setAttribute("width","100%" );
      ((Element)v.get(624)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(634)).setAttribute("src","b.gif" );
      ((Element)v.get(634)).setAttribute("width","8" );
      ((Element)v.get(634)).setAttribute("height","8" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */
      /* Termina nodo:624   */

      /* Empieza nodo:635 / Elemento padre: 620   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(620)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(637)).setAttribute("src","b.gif" );
      ((Element)v.get(637)).setAttribute("width","8" );
      ((Element)v.get(637)).setAttribute("height","8" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:638 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(638)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(635)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(639)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(639)).setAttribute("id","datosCampos" );
      ((Element)v.get(639)).setAttribute("size","1" );
      ((Element)v.get(639)).setAttribute("multiple","N" );
      ((Element)v.get(639)).setAttribute("readonly","N" );
      ((Element)v.get(639)).setAttribute("req","N" );
      ((Element)v.get(639)).setAttribute("onchange","cargaComboSubtiposCliente();" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(639)).setAttribute("valorinicial","" );
      ((Element)v.get(639)).setAttribute("textoinicial","" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:641 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(642)).setAttribute("src","b.gif" );
      ((Element)v.get(642)).setAttribute("width","25" );
      ((Element)v.get(642)).setAttribute("height","8" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:641   */

      /* Empieza nodo:643 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(643)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(635)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(644)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(644)).setAttribute("id","datosCampos" );
      ((Element)v.get(644)).setAttribute("size","1" );
      ((Element)v.get(644)).setAttribute("multiple","N" );
      ((Element)v.get(644)).setAttribute("readonly","N" );
      ((Element)v.get(644)).setAttribute("req","N" );
      ((Element)v.get(644)).setAttribute("onchange","cargaComboTipoClasificacion();" );
      ((Element)v.get(644)).setAttribute("valorinicial","" );
      ((Element)v.get(644)).setAttribute("textoinicial","" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:644   */
      /* Termina nodo:643   */

      /* Empieza nodo:646 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(646)).setAttribute("width","100%" );
      ((Element)v.get(635)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(647)).setAttribute("src","b.gif" );
      ((Element)v.get(647)).setAttribute("width","8" );
      ((Element)v.get(647)).setAttribute("height","8" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */
      /* Termina nodo:646   */
      /* Termina nodo:635   */

      /* Empieza nodo:648 / Elemento padre: 620   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(620)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("td"));
      ((Element)v.get(649)).setAttribute("colspan","4" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(650)).setAttribute("src","b.gif" );
      ((Element)v.get(650)).setAttribute("width","8" );
      ((Element)v.get(650)).setAttribute("height","8" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */
      /* Termina nodo:649   */
      /* Termina nodo:648   */
      /* Termina nodo:620   */

      /* Empieza nodo:651 / Elemento padre: 617   */
      v.add(doc.createElement("table"));
      ((Element)v.get(651)).setAttribute("nombre","nodoClasificacionCliente2" );
      ((Element)v.get(651)).setAttribute("width","100%" );
      ((Element)v.get(651)).setAttribute("border","0" );
      ((Element)v.get(651)).setAttribute("align","center" );
      ((Element)v.get(651)).setAttribute("cellspacing","0" );
      ((Element)v.get(651)).setAttribute("cellpadding","0" );
      ((Element)v.get(617)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(651)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("td"));
      ((Element)v.get(652)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(654)).setAttribute("src","b.gif" );
      ((Element)v.get(654)).setAttribute("width","8" );
      ((Element)v.get(654)).setAttribute("height","8" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */
      /* Termina nodo:653   */

      /* Empieza nodo:655 / Elemento padre: 652   */
      v.add(doc.createElement("td"));
      ((Element)v.get(652)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(656)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(656)).setAttribute("alto","13" );
      ((Element)v.get(656)).setAttribute("filas","1" );
      ((Element)v.get(656)).setAttribute("valor","" );
      ((Element)v.get(656)).setAttribute("id","datosTitle" );
      ((Element)v.get(656)).setAttribute("cod","756" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:655   */

      /* Empieza nodo:657 / Elemento padre: 652   */
      v.add(doc.createElement("td"));
      ((Element)v.get(652)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(658)).setAttribute("nombre","lblTipoClasificacionI" );
      ((Element)v.get(658)).setAttribute("src","b.gif" );
      ((Element)v.get(658)).setAttribute("width","25" );
      ((Element)v.get(658)).setAttribute("height","8" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */
      /* Termina nodo:657   */

      /* Empieza nodo:659 / Elemento padre: 652   */
      v.add(doc.createElement("td"));
      ((Element)v.get(652)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(660)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(660)).setAttribute("alto","13" );
      ((Element)v.get(660)).setAttribute("filas","1" );
      ((Element)v.get(660)).setAttribute("valor","" );
      ((Element)v.get(660)).setAttribute("id","datosTitle" );
      ((Element)v.get(660)).setAttribute("cod","550" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(659)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */
      /* Termina nodo:659   */

      /* Empieza nodo:661 / Elemento padre: 652   */
      v.add(doc.createElement("td"));
      ((Element)v.get(661)).setAttribute("width","100%" );
      ((Element)v.get(652)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(662)).setAttribute("src","b.gif" );
      ((Element)v.get(662)).setAttribute("width","8" );
      ((Element)v.get(662)).setAttribute("height","8" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:661   */
      /* Termina nodo:652   */

      /* Empieza nodo:663 / Elemento padre: 651   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(651)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(663)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(665)).setAttribute("src","b.gif" );
      ((Element)v.get(665)).setAttribute("width","8" );
      ((Element)v.get(665)).setAttribute("height","8" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */
      /* Termina nodo:664   */

      /* Empieza nodo:666 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(666)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(663)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(667)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(667)).setAttribute("id","datosCampos" );
      ((Element)v.get(667)).setAttribute("size","1" );
      ((Element)v.get(667)).setAttribute("multiple","N" );
      ((Element)v.get(667)).setAttribute("readonly","N" );
      ((Element)v.get(667)).setAttribute("req","N" );
      ((Element)v.get(667)).setAttribute("onchange","cargaComboClasificacion();" );
      ((Element)v.get(667)).setAttribute("valorinicial","" );
      ((Element)v.get(667)).setAttribute("textoinicial","" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(667)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:667   */
      /* Termina nodo:666   */

      /* Empieza nodo:669 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(663)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(670)).setAttribute("nombre","cbTipoClasificacionI" );
      ((Element)v.get(670)).setAttribute("src","b.gif" );
      ((Element)v.get(670)).setAttribute("width","25" );
      ((Element)v.get(670)).setAttribute("height","8" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */
      /* Termina nodo:669   */

      /* Empieza nodo:671 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(671)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(663)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(672)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(672)).setAttribute("id","datosCampos" );
      ((Element)v.get(672)).setAttribute("size","1" );
      ((Element)v.get(672)).setAttribute("multiple","N" );
      ((Element)v.get(672)).setAttribute("readonly","N" );
      ((Element)v.get(672)).setAttribute("req","N" );
      ((Element)v.get(672)).setAttribute("valorinicial","" );
      ((Element)v.get(672)).setAttribute("textoinicial","" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(672)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */
      /* Termina nodo:672   */
      /* Termina nodo:671   */

      /* Empieza nodo:674 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(674)).setAttribute("width","100%" );
      ((Element)v.get(663)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(675)).setAttribute("src","b.gif" );
      ((Element)v.get(675)).setAttribute("width","8" );
      ((Element)v.get(675)).setAttribute("height","8" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */
      /* Termina nodo:674   */
      /* Termina nodo:663   */

      /* Empieza nodo:676 / Elemento padre: 651   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(651)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("td"));
      ((Element)v.get(677)).setAttribute("colspan","4" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(678)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).setAttribute("width","8" );
      ((Element)v.get(678)).setAttribute("height","8" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */
      /* Termina nodo:676   */
      /* Termina nodo:651   */

      /* Empieza nodo:679 / Elemento padre: 617   */
      v.add(doc.createElement("table"));
      ((Element)v.get(679)).setAttribute("nombre","nodoClasificacionCliente3" );
      ((Element)v.get(679)).setAttribute("width","100%" );
      ((Element)v.get(679)).setAttribute("border","0" );
      ((Element)v.get(679)).setAttribute("align","center" );
      ((Element)v.get(679)).setAttribute("cellspacing","0" );
      ((Element)v.get(679)).setAttribute("cellpadding","0" );
      ((Element)v.get(617)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(679)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("td"));
      ((Element)v.get(680)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(682)).setAttribute("src","b.gif" );
      ((Element)v.get(682)).setAttribute("width","8" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(682)).setAttribute("height","8" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));
      /* Termina nodo:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:683 / Elemento padre: 680   */
      v.add(doc.createElement("td"));
      ((Element)v.get(680)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(684)).setAttribute("nombre","lblEstatusCli" );
      ((Element)v.get(684)).setAttribute("alto","13" );
      ((Element)v.get(684)).setAttribute("filas","1" );
      ((Element)v.get(684)).setAttribute("valor","" );
      ((Element)v.get(684)).setAttribute("id","datosTitle" );
      ((Element)v.get(684)).setAttribute("cod","612" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */
      /* Termina nodo:683   */

      /* Empieza nodo:685 / Elemento padre: 680   */
      v.add(doc.createElement("td"));
      ((Element)v.get(685)).setAttribute("width","100%" );
      ((Element)v.get(680)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(686)).setAttribute("src","b.gif" );
      ((Element)v.get(686)).setAttribute("width","8" );
      ((Element)v.get(686)).setAttribute("height","8" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */
      /* Termina nodo:680   */

      /* Empieza nodo:687 / Elemento padre: 679   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(679)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("td"));
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(689)).setAttribute("src","b.gif" );
      ((Element)v.get(689)).setAttribute("width","8" );
      ((Element)v.get(689)).setAttribute("height","8" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */
      /* Termina nodo:688   */

      /* Empieza nodo:690 / Elemento padre: 687   */
      v.add(doc.createElement("td"));
      ((Element)v.get(690)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(690)).setAttribute("valign","top" );
      ((Element)v.get(687)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(691)).setAttribute("nombre","cbEstatusCli" );
      ((Element)v.get(691)).setAttribute("id","datosCampos" );
      ((Element)v.get(691)).setAttribute("size","1" );
      ((Element)v.get(691)).setAttribute("multiple","N" );
      ((Element)v.get(691)).setAttribute("readonly","N" );
      ((Element)v.get(691)).setAttribute("req","N" );
      ((Element)v.get(691)).setAttribute("valorinicial","" );
      ((Element)v.get(691)).setAttribute("textoinicial","" );
      ((Element)v.get(690)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */
      /* Termina nodo:690   */

      /* Empieza nodo:693 / Elemento padre: 687   */
      v.add(doc.createElement("td"));
      ((Element)v.get(687)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(694)).setAttribute("src","b.gif" );
      ((Element)v.get(694)).setAttribute("width","25" );
      ((Element)v.get(694)).setAttribute("height","8" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));
      /* Termina nodo:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:695 / Elemento padre: 687   */
      v.add(doc.createElement("td"));
      ((Element)v.get(695)).setAttribute("width","100%" );
      ((Element)v.get(687)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(696)).setAttribute("src","b.gif" );
      ((Element)v.get(696)).setAttribute("width","8" );
      ((Element)v.get(696)).setAttribute("height","8" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:695   */
      /* Termina nodo:687   */

      /* Empieza nodo:697 / Elemento padre: 679   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(679)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("td"));
      ((Element)v.get(698)).setAttribute("colspan","4" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(699)).setAttribute("src","b.gif" );
      ((Element)v.get(699)).setAttribute("width","8" );
      ((Element)v.get(699)).setAttribute("height","8" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */
      /* Termina nodo:698   */
      /* Termina nodo:697   */
      /* Termina nodo:679   */
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:700 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(613)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(701)).setAttribute("src","b.gif" );
      ((Element)v.get(700)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */
      /* Termina nodo:700   */
      /* Termina nodo:613   */

      /* Empieza nodo:702 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(702)).setAttribute("nombre","nodoImagenClasificacionCliente" );
      ((Element)v.get(178)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("td"));
      ((Element)v.get(703)).setAttribute("colspan","4" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(704)).setAttribute("src","b.gif" );
      ((Element)v.get(704)).setAttribute("width","8" );
      ((Element)v.get(704)).setAttribute("height","15" );
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:703   */
      /* Termina nodo:702   */

      /* Empieza nodo:705 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(705)).setAttribute("nombre","nodoDatosConstancia" );
      ((Element)v.get(178)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("td"));
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(705)).appendChild((Element)v.get(706));

      /* Empieza nodo:707 / Elemento padre: 706   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(707)).setAttribute("src","b.gif" );
      ((Element)v.get(706)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */
      /* Termina nodo:706   */

      /* Empieza nodo:708 / Elemento padre: 705   */
      v.add(doc.createElement("td"));
      ((Element)v.get(705)).appendChild((Element)v.get(708));

      /* Empieza nodo:709 / Elemento padre: 708   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(708)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(710)).setAttribute("class","legend" );
      ((Element)v.get(709)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(711)).setAttribute("nombre","lblDatosConstancia" );
      ((Element)v.get(711)).setAttribute("alto","13" );
      ((Element)v.get(711)).setAttribute("filas","1" );
      ((Element)v.get(711)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(711)).setAttribute("id","legend" );
      ((Element)v.get(711)).setAttribute("cod","00277" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */

      /* Empieza nodo:712 / Elemento padre: 709   */
      v.add(doc.createElement("table"));
      ((Element)v.get(712)).setAttribute("width","100%" );
      ((Element)v.get(712)).setAttribute("border","0" );
      ((Element)v.get(712)).setAttribute("align","center" );
      ((Element)v.get(712)).setAttribute("cellspacing","0" );
      ((Element)v.get(712)).setAttribute("cellpadding","0" );
      ((Element)v.get(709)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(712)).appendChild((Element)v.get(713));

      /* Empieza nodo:714 / Elemento padre: 713   */
      v.add(doc.createElement("td"));
      ((Element)v.get(714)).setAttribute("colspan","4" );
      ((Element)v.get(713)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(715)).setAttribute("src","b.gif" );
      ((Element)v.get(715)).setAttribute("width","8" );
      ((Element)v.get(715)).setAttribute("height","8" );
      ((Element)v.get(714)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */
      /* Termina nodo:714   */
      /* Termina nodo:713   */

      /* Empieza nodo:716 / Elemento padre: 712   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(712)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("td"));
      ((Element)v.get(716)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(718)).setAttribute("src","b.gif" );
      ((Element)v.get(718)).setAttribute("width","8" );
      ((Element)v.get(718)).setAttribute("height","8" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */
      /* Termina nodo:717   */

      /* Empieza nodo:719 / Elemento padre: 716   */
      v.add(doc.createElement("td"));
      ((Element)v.get(716)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(720)).setAttribute("nombre","lblNOrdenes" );
      ((Element)v.get(720)).setAttribute("alto","13" );
      ((Element)v.get(720)).setAttribute("filas","1" );
      ((Element)v.get(720)).setAttribute("valor","" );
      ((Element)v.get(720)).setAttribute("id","datosTitle" );
      ((Element)v.get(720)).setAttribute("cod","740" );
      ((Element)v.get(719)).appendChild((Element)v.get(720));
      /* Termina nodo:720   */
      /* Termina nodo:719   */

      /* Empieza nodo:721 / Elemento padre: 716   */
      v.add(doc.createElement("td"));
      ((Element)v.get(716)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(722)).setAttribute("nombre","lblNOrdenesI" );
      ((Element)v.get(722)).setAttribute("src","b.gif" );
      ((Element)v.get(722)).setAttribute("width","25" );
      ((Element)v.get(722)).setAttribute("height","8" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */
      /* Termina nodo:721   */

      /* Empieza nodo:723 / Elemento padre: 716   */
      v.add(doc.createElement("td"));
      ((Element)v.get(716)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(724)).setAttribute("nombre","lblPerConstInicio" );
      ((Element)v.get(724)).setAttribute("alto","13" );
      ((Element)v.get(724)).setAttribute("filas","1" );
      ((Element)v.get(724)).setAttribute("valor","" );
      ((Element)v.get(724)).setAttribute("id","datosTitle" );
      ((Element)v.get(724)).setAttribute("cod","749" );
      ((Element)v.get(723)).appendChild((Element)v.get(724));
      /* Termina nodo:724   */
      /* Termina nodo:723   */

      /* Empieza nodo:725 / Elemento padre: 716   */
      v.add(doc.createElement("td"));
      ((Element)v.get(716)).appendChild((Element)v.get(725));

      /* Empieza nodo:726 / Elemento padre: 725   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(726)).setAttribute("nombre","lblPerConstInicioI" );
      ((Element)v.get(726)).setAttribute("src","b.gif" );
      ((Element)v.get(726)).setAttribute("width","25" );
      ((Element)v.get(726)).setAttribute("height","8" );
      ((Element)v.get(725)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */
      /* Termina nodo:725   */

      /* Empieza nodo:727 / Elemento padre: 716   */
      v.add(doc.createElement("td"));
      ((Element)v.get(716)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(728)).setAttribute("nombre","lblPerConstFin" );
      ((Element)v.get(728)).setAttribute("alto","13" );
      ((Element)v.get(728)).setAttribute("filas","1" );
      ((Element)v.get(728)).setAttribute("valor","" );
      ((Element)v.get(728)).setAttribute("id","datosTitle" );
      ((Element)v.get(728)).setAttribute("cod","747" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(727)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:727   */

      /* Empieza nodo:729 / Elemento padre: 716   */
      v.add(doc.createElement("td"));
      ((Element)v.get(729)).setAttribute("width","100%" );
      ((Element)v.get(716)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(730)).setAttribute("src","b.gif" );
      ((Element)v.get(730)).setAttribute("width","8" );
      ((Element)v.get(730)).setAttribute("height","8" );
      ((Element)v.get(729)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */
      /* Termina nodo:729   */
      /* Termina nodo:716   */

      /* Empieza nodo:731 / Elemento padre: 712   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(712)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(733)).setAttribute("src","b.gif" );
      ((Element)v.get(733)).setAttribute("width","8" );
      ((Element)v.get(733)).setAttribute("height","8" );
      ((Element)v.get(732)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */
      /* Termina nodo:732   */

      /* Empieza nodo:734 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(734)).setAttribute("valign","top" );
      ((Element)v.get(731)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(735)).setAttribute("nombre","txtNOrdenes" );
      ((Element)v.get(735)).setAttribute("id","datosCampos" );
      ((Element)v.get(735)).setAttribute("max","2" );
      ((Element)v.get(735)).setAttribute("tipo","" );
      ((Element)v.get(735)).setAttribute("onblur","validaEntero('txtNOrdenes');" );
      ((Element)v.get(735)).setAttribute("readonly","N" );
      ((Element)v.get(735)).setAttribute("req","N" );
      ((Element)v.get(735)).setAttribute("size","2" );
      ((Element)v.get(735)).setAttribute("valor","" );
      ((Element)v.get(735)).setAttribute("validacion","" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:736 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(737)).setAttribute("nombre","txtNOrdenesI" );
      ((Element)v.get(737)).setAttribute("src","b.gif" );
      ((Element)v.get(737)).setAttribute("width","25" );
      ((Element)v.get(737)).setAttribute("height","8" );
      ((Element)v.get(736)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */
      /* Termina nodo:736   */

      /* Empieza nodo:738 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(738)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(731)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(739)).setAttribute("nombre","cbPerConstInicio" );
      ((Element)v.get(739)).setAttribute("id","datosCampos" );
      ((Element)v.get(739)).setAttribute("size","1" );
      ((Element)v.get(739)).setAttribute("multiple","N" );
      ((Element)v.get(739)).setAttribute("readonly","N" );
      ((Element)v.get(739)).setAttribute("req","N" );
      ((Element)v.get(739)).setAttribute("valorinicial","" );
      ((Element)v.get(739)).setAttribute("textoinicial","" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(739)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */
      /* Termina nodo:739   */
      /* Termina nodo:738   */

      /* Empieza nodo:741 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(742)).setAttribute("nombre","cbPerConstInicioI" );
      ((Element)v.get(742)).setAttribute("src","b.gif" );
      ((Element)v.get(742)).setAttribute("width","25" );
      ((Element)v.get(742)).setAttribute("height","8" );
      ((Element)v.get(741)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */
      /* Termina nodo:741   */

      /* Empieza nodo:743 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(743)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(731)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(744)).setAttribute("nombre","cbPerConstFin" );
      ((Element)v.get(744)).setAttribute("id","datosCampos" );
      ((Element)v.get(744)).setAttribute("size","1" );
      ((Element)v.get(744)).setAttribute("multiple","N" );
      ((Element)v.get(744)).setAttribute("readonly","N" );
      ((Element)v.get(744)).setAttribute("req","N" );
      ((Element)v.get(744)).setAttribute("valorinicial","" );
      ((Element)v.get(744)).setAttribute("textoinicial","" );
      ((Element)v.get(743)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(744)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */
      /* Termina nodo:744   */
      /* Termina nodo:743   */

      /* Empieza nodo:746 / Elemento padre: 731   */
      v.add(doc.createElement("td"));
      ((Element)v.get(746)).setAttribute("width","100%" );
      ((Element)v.get(731)).appendChild((Element)v.get(746));

      /* Empieza nodo:747 / Elemento padre: 746   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(747)).setAttribute("src","b.gif" );
      ((Element)v.get(747)).setAttribute("width","8" );
      ((Element)v.get(747)).setAttribute("height","8" );
      ((Element)v.get(746)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */
      /* Termina nodo:746   */
      /* Termina nodo:731   */

      /* Empieza nodo:748 / Elemento padre: 712   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(712)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
   }

   private void getXML3150(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(749)).setAttribute("colspan","4" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));

      /* Empieza nodo:750 / Elemento padre: 749   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(750)).setAttribute("src","b.gif" );
      ((Element)v.get(750)).setAttribute("width","8" );
      ((Element)v.get(750)).setAttribute("height","8" );
      ((Element)v.get(749)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */
      /* Termina nodo:749   */
      /* Termina nodo:748   */
      /* Termina nodo:712   */
      /* Termina nodo:709   */
      /* Termina nodo:708   */

      /* Empieza nodo:751 / Elemento padre: 705   */
      v.add(doc.createElement("td"));
      ((Element)v.get(705)).appendChild((Element)v.get(751));

      /* Empieza nodo:752 / Elemento padre: 751   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(752)).setAttribute("src","b.gif" );
      ((Element)v.get(751)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */
      /* Termina nodo:751   */
      /* Termina nodo:705   */

      /* Empieza nodo:753 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(753)).setAttribute("nombre","nodoImagenDatosConstancia" );
      ((Element)v.get(178)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("td"));
      ((Element)v.get(754)).setAttribute("colspan","4" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(755)).setAttribute("src","b.gif" );
      ((Element)v.get(755)).setAttribute("width","8" );
      ((Element)v.get(755)).setAttribute("height","15" );
      ((Element)v.get(754)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:754   */
      /* Termina nodo:753   */

      /* Empieza nodo:756 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(756)).setAttribute("nombre","nodoDatosVentas" );
      ((Element)v.get(178)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("td"));
      ((Element)v.get(756)).appendChild((Element)v.get(757));

      /* Empieza nodo:758 / Elemento padre: 757   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(758)).setAttribute("src","b.gif" );
      ((Element)v.get(757)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */
      /* Termina nodo:757   */

      /* Empieza nodo:759 / Elemento padre: 756   */
      v.add(doc.createElement("td"));
      ((Element)v.get(756)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(759)).appendChild((Element)v.get(760));

      /* Empieza nodo:761 / Elemento padre: 760   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(761)).setAttribute("class","legend" );
      ((Element)v.get(760)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(762)).setAttribute("nombre","lblDatosVenta" );
      ((Element)v.get(762)).setAttribute("alto","13" );
      ((Element)v.get(762)).setAttribute("filas","1" );
      ((Element)v.get(762)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(762)).setAttribute("id","legend" );
      ((Element)v.get(762)).setAttribute("cod","00190" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:761   */

      /* Empieza nodo:763 / Elemento padre: 760   */
      v.add(doc.createElement("table"));
      ((Element)v.get(763)).setAttribute("width","100%" );
      ((Element)v.get(763)).setAttribute("border","0" );
      ((Element)v.get(763)).setAttribute("align","center" );
      ((Element)v.get(763)).setAttribute("cellspacing","0" );
      ((Element)v.get(763)).setAttribute("cellpadding","0" );
      ((Element)v.get(760)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(763)).appendChild((Element)v.get(764));

      /* Empieza nodo:765 / Elemento padre: 764   */
      v.add(doc.createElement("td"));
      ((Element)v.get(765)).setAttribute("colspan","4" );
      ((Element)v.get(764)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(766)).setAttribute("src","b.gif" );
      ((Element)v.get(766)).setAttribute("width","8" );
      ((Element)v.get(766)).setAttribute("height","8" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */
      /* Termina nodo:765   */
      /* Termina nodo:764   */

      /* Empieza nodo:767 / Elemento padre: 763   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(763)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(769)).setAttribute("src","b.gif" );
      ((Element)v.get(769)).setAttribute("width","8" );
      ((Element)v.get(769)).setAttribute("height","8" );
      ((Element)v.get(768)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */
      /* Termina nodo:768   */

      /* Empieza nodo:770 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(771)).setAttribute("nombre","lblMontoVentasComp" );
      ((Element)v.get(771)).setAttribute("alto","13" );
      ((Element)v.get(771)).setAttribute("filas","1" );
      ((Element)v.get(771)).setAttribute("valor","" );
      ((Element)v.get(771)).setAttribute("id","datosTitle" );
      ((Element)v.get(771)).setAttribute("cod","738" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */
      /* Termina nodo:770   */

      /* Empieza nodo:772 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(772));

      /* Empieza nodo:773 / Elemento padre: 772   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(773)).setAttribute("nombre","lblMontoVentasCompI" );
      ((Element)v.get(773)).setAttribute("src","b.gif" );
      ((Element)v.get(773)).setAttribute("width","25" );
      ((Element)v.get(773)).setAttribute("height","8" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(772)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */
      /* Termina nodo:772   */

      /* Empieza nodo:774 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(775)).setAttribute("nombre","lblPerVentInicio" );
      ((Element)v.get(775)).setAttribute("alto","13" );
      ((Element)v.get(775)).setAttribute("filas","1" );
      ((Element)v.get(775)).setAttribute("valor","" );
      ((Element)v.get(775)).setAttribute("id","datosTitle" );
      ((Element)v.get(775)).setAttribute("cod","750" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));
      /* Termina nodo:775   */
      /* Termina nodo:774   */

      /* Empieza nodo:776 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(777)).setAttribute("nombre","lblPerVentInicioI" );
      ((Element)v.get(777)).setAttribute("src","b.gif" );
      ((Element)v.get(777)).setAttribute("width","25" );
      ((Element)v.get(777)).setAttribute("height","8" );
      ((Element)v.get(776)).appendChild((Element)v.get(777));
      /* Termina nodo:777   */
      /* Termina nodo:776   */

      /* Empieza nodo:778 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(779)).setAttribute("nombre","lblPerVentFin" );
      ((Element)v.get(779)).setAttribute("alto","13" );
      ((Element)v.get(779)).setAttribute("filas","1" );
      ((Element)v.get(779)).setAttribute("valor","" );
      ((Element)v.get(779)).setAttribute("id","datosTitle" );
      ((Element)v.get(779)).setAttribute("cod","1530" );
      ((Element)v.get(778)).appendChild((Element)v.get(779));
      /* Termina nodo:779   */
      /* Termina nodo:778   */

      /* Empieza nodo:780 / Elemento padre: 767   */
      v.add(doc.createElement("td"));
      ((Element)v.get(780)).setAttribute("width","100%" );
      ((Element)v.get(767)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(781)).setAttribute("src","b.gif" );
      ((Element)v.get(781)).setAttribute("width","8" );
      ((Element)v.get(781)).setAttribute("height","8" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));
      /* Termina nodo:781   */
      /* Termina nodo:780   */
      /* Termina nodo:767   */

      /* Empieza nodo:782 / Elemento padre: 763   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(763)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("td"));
      ((Element)v.get(782)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(784)).setAttribute("src","b.gif" );
      ((Element)v.get(784)).setAttribute("width","8" );
      ((Element)v.get(784)).setAttribute("height","8" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));
      /* Termina nodo:784   */
      /* Termina nodo:783   */

      /* Empieza nodo:785 / Elemento padre: 782   */
      v.add(doc.createElement("td"));
      ((Element)v.get(785)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(785)).setAttribute("valign","top" );
      ((Element)v.get(782)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(786)).setAttribute("nombre","txtMontoVentasComp" );
      ((Element)v.get(786)).setAttribute("id","datosCampos" );
      ((Element)v.get(786)).setAttribute("max","16" );
      ((Element)v.get(786)).setAttribute("tipo","" );
      ((Element)v.get(786)).setAttribute("onblur","validaMonto('txtMontoVentasComp');" );
      ((Element)v.get(786)).setAttribute("readonly","N" );
      ((Element)v.get(786)).setAttribute("req","N" );
      ((Element)v.get(786)).setAttribute("size","21" );
      ((Element)v.get(786)).setAttribute("valor","" );
      ((Element)v.get(786)).setAttribute("validacion","" );
      ((Element)v.get(785)).appendChild((Element)v.get(786));
      /* Termina nodo:786   */
      /* Termina nodo:785   */

      /* Empieza nodo:787 / Elemento padre: 782   */
      v.add(doc.createElement("td"));
      ((Element)v.get(782)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(788)).setAttribute("nombre","txtMontoVentasCompI" );
      ((Element)v.get(788)).setAttribute("src","b.gif" );
      ((Element)v.get(788)).setAttribute("width","25" );
      ((Element)v.get(788)).setAttribute("height","8" );
      ((Element)v.get(787)).appendChild((Element)v.get(788));
      /* Termina nodo:788   */
      /* Termina nodo:787   */

      /* Empieza nodo:789 / Elemento padre: 782   */
      v.add(doc.createElement("td"));
      ((Element)v.get(789)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(782)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(790)).setAttribute("nombre","cbPerVentInicio" );
      ((Element)v.get(790)).setAttribute("id","datosCampos" );
      ((Element)v.get(790)).setAttribute("size","1" );
      ((Element)v.get(790)).setAttribute("multiple","N" );
      ((Element)v.get(790)).setAttribute("readonly","N" );
      ((Element)v.get(790)).setAttribute("req","N" );
      ((Element)v.get(790)).setAttribute("valorinicial","" );
      ((Element)v.get(790)).setAttribute("textoinicial","" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(790)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */
      /* Termina nodo:790   */
      /* Termina nodo:789   */

      /* Empieza nodo:792 / Elemento padre: 782   */
      v.add(doc.createElement("td"));
      ((Element)v.get(782)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(793)).setAttribute("nombre","cbPerVentInicioI" );
      ((Element)v.get(793)).setAttribute("src","b.gif" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(793)).setAttribute("width","25" );
      ((Element)v.get(793)).setAttribute("height","8" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));
      /* Termina nodo:793   */
      /* Termina nodo:792   */

      /* Empieza nodo:794 / Elemento padre: 782   */
      v.add(doc.createElement("td"));
      ((Element)v.get(794)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(782)).appendChild((Element)v.get(794));

      /* Empieza nodo:795 / Elemento padre: 794   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(795)).setAttribute("nombre","cbPerVentFin" );
      ((Element)v.get(795)).setAttribute("id","datosCampos" );
      ((Element)v.get(795)).setAttribute("size","1" );
      ((Element)v.get(795)).setAttribute("multiple","N" );
      ((Element)v.get(795)).setAttribute("readonly","N" );
      ((Element)v.get(795)).setAttribute("req","N" );
      ((Element)v.get(795)).setAttribute("valorinicial","" );
      ((Element)v.get(795)).setAttribute("textoinicial","" );
      ((Element)v.get(794)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(795)).appendChild((Element)v.get(796));
      /* Termina nodo:796   */
      /* Termina nodo:795   */
      /* Termina nodo:794   */

      /* Empieza nodo:797 / Elemento padre: 782   */
      v.add(doc.createElement("td"));
      ((Element)v.get(797)).setAttribute("width","100%" );
      ((Element)v.get(782)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(798)).setAttribute("src","b.gif" );
      ((Element)v.get(798)).setAttribute("width","8" );
      ((Element)v.get(798)).setAttribute("height","8" );
      ((Element)v.get(797)).appendChild((Element)v.get(798));
      /* Termina nodo:798   */
      /* Termina nodo:797   */
      /* Termina nodo:782   */

      /* Empieza nodo:799 / Elemento padre: 763   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(763)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("td"));
      ((Element)v.get(800)).setAttribute("colspan","4" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(801)).setAttribute("src","b.gif" );
      ((Element)v.get(801)).setAttribute("width","8" );
      ((Element)v.get(801)).setAttribute("height","8" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));
      /* Termina nodo:801   */
      /* Termina nodo:800   */
      /* Termina nodo:799   */
      /* Termina nodo:763   */
      /* Termina nodo:760   */
      /* Termina nodo:759   */

      /* Empieza nodo:802 / Elemento padre: 756   */
      v.add(doc.createElement("td"));
      ((Element)v.get(756)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(803)).setAttribute("src","b.gif" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));
      /* Termina nodo:803   */
      /* Termina nodo:802   */
      /* Termina nodo:756   */

      /* Empieza nodo:804 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(804)).setAttribute("nombre","nodoImagenDatosVentas" );
      ((Element)v.get(178)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).setAttribute("colspan","4" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(806)).setAttribute("src","b.gif" );
      ((Element)v.get(806)).setAttribute("width","8" );
      ((Element)v.get(806)).setAttribute("height","15" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));
      /* Termina nodo:806   */
      /* Termina nodo:805   */
      /* Termina nodo:804   */

      /* Empieza nodo:807 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(807)).setAttribute("nombre","nodoCondicionIngreso" );
      ((Element)v.get(178)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("td"));
      ((Element)v.get(807)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(809)).setAttribute("src","b.gif" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));
      /* Termina nodo:809   */
      /* Termina nodo:808   */

      /* Empieza nodo:810 / Elemento padre: 807   */
      v.add(doc.createElement("td"));
      ((Element)v.get(807)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(810)).appendChild((Element)v.get(811));

      /* Empieza nodo:812 / Elemento padre: 811   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(812)).setAttribute("class","legend" );
      ((Element)v.get(811)).appendChild((Element)v.get(812));

      /* Empieza nodo:813 / Elemento padre: 812   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(813)).setAttribute("nombre","lblCondicionIngreso" );
      ((Element)v.get(813)).setAttribute("alto","13" );
      ((Element)v.get(813)).setAttribute("filas","1" );
      ((Element)v.get(813)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(813)).setAttribute("id","legend" );
      ((Element)v.get(813)).setAttribute("cod","00278" );
      ((Element)v.get(812)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */
      /* Termina nodo:812   */

      /* Empieza nodo:814 / Elemento padre: 811   */
      v.add(doc.createElement("table"));
      ((Element)v.get(814)).setAttribute("width","100%" );
      ((Element)v.get(814)).setAttribute("border","0" );
      ((Element)v.get(814)).setAttribute("align","center" );
      ((Element)v.get(814)).setAttribute("cellspacing","0" );
      ((Element)v.get(814)).setAttribute("cellpadding","0" );
      ((Element)v.get(811)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(814)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("td"));
      ((Element)v.get(816)).setAttribute("colspan","4" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));

      /* Empieza nodo:817 / Elemento padre: 816   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(817)).setAttribute("src","b.gif" );
      ((Element)v.get(817)).setAttribute("width","8" );
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(817)).setAttribute("height","8" );
      ((Element)v.get(816)).appendChild((Element)v.get(817));
      /* Termina nodo:817   */
      /* Termina nodo:816   */
      /* Termina nodo:815   */

      /* Empieza nodo:818 / Elemento padre: 814   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(814)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("td"));
      ((Element)v.get(818)).appendChild((Element)v.get(819));

      /* Empieza nodo:820 / Elemento padre: 819   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(820)).setAttribute("src","b.gif" );
      ((Element)v.get(820)).setAttribute("width","8" );
      ((Element)v.get(820)).setAttribute("height","8" );
      ((Element)v.get(819)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */
      /* Termina nodo:819   */

      /* Empieza nodo:821 / Elemento padre: 818   */
      v.add(doc.createElement("td"));
      ((Element)v.get(818)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(822)).setAttribute("nombre","lblPerIngresoCondicion" );
      ((Element)v.get(822)).setAttribute("alto","13" );
      ((Element)v.get(822)).setAttribute("filas","1" );
      ((Element)v.get(822)).setAttribute("valor","" );
      ((Element)v.get(822)).setAttribute("id","datosTitle" );
      ((Element)v.get(822)).setAttribute("cod","748" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */
      /* Termina nodo:821   */

      /* Empieza nodo:823 / Elemento padre: 818   */
      v.add(doc.createElement("td"));
      ((Element)v.get(818)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(824)).setAttribute("nombre","lblPerIngresoCondicionI" );
      ((Element)v.get(824)).setAttribute("src","b.gif" );
      ((Element)v.get(824)).setAttribute("width","25" );
      ((Element)v.get(824)).setAttribute("height","8" );
      ((Element)v.get(823)).appendChild((Element)v.get(824));
      /* Termina nodo:824   */
      /* Termina nodo:823   */

      /* Empieza nodo:825 / Elemento padre: 818   */
      v.add(doc.createElement("td"));
      ((Element)v.get(818)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(826)).setAttribute("nombre","lblFechaIngresoCondicion" );
      ((Element)v.get(826)).setAttribute("alto","13" );
      ((Element)v.get(826)).setAttribute("filas","1" );
      ((Element)v.get(826)).setAttribute("valor","" );
      ((Element)v.get(826)).setAttribute("id","datosTitle" );
      ((Element)v.get(826)).setAttribute("cod","728" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));
      /* Termina nodo:826   */
      /* Termina nodo:825   */

      /* Empieza nodo:827 / Elemento padre: 818   */
      v.add(doc.createElement("td"));
      ((Element)v.get(818)).appendChild((Element)v.get(827));

      /* Empieza nodo:828 / Elemento padre: 827   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(828)).setAttribute("nombre","lblFechaIngresoCondicionI" );
      ((Element)v.get(828)).setAttribute("src","b.gif" );
      ((Element)v.get(828)).setAttribute("width","25" );
      ((Element)v.get(828)).setAttribute("height","8" );
      ((Element)v.get(827)).appendChild((Element)v.get(828));
      /* Termina nodo:828   */
      /* Termina nodo:827   */

      /* Empieza nodo:829 / Elemento padre: 818   */
      v.add(doc.createElement("td"));
      ((Element)v.get(818)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(830)).setAttribute("nombre","lblNPeriodosCondicion" );
      ((Element)v.get(830)).setAttribute("alto","13" );
      ((Element)v.get(830)).setAttribute("filas","1" );
      ((Element)v.get(830)).setAttribute("valor","" );
      ((Element)v.get(830)).setAttribute("id","datosTitle" );
      ((Element)v.get(830)).setAttribute("cod","741" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */
      /* Termina nodo:829   */

      /* Empieza nodo:831 / Elemento padre: 818   */
      v.add(doc.createElement("td"));
      ((Element)v.get(831)).setAttribute("width","100%" );
      ((Element)v.get(818)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(832)).setAttribute("src","b.gif" );
      ((Element)v.get(832)).setAttribute("width","8" );
      ((Element)v.get(832)).setAttribute("height","8" );
      ((Element)v.get(831)).appendChild((Element)v.get(832));
      /* Termina nodo:832   */
      /* Termina nodo:831   */
      /* Termina nodo:818   */

      /* Empieza nodo:833 / Elemento padre: 814   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(814)).appendChild((Element)v.get(833));

      /* Empieza nodo:834 / Elemento padre: 833   */
      v.add(doc.createElement("td"));
      ((Element)v.get(833)).appendChild((Element)v.get(834));

      /* Empieza nodo:835 / Elemento padre: 834   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(835)).setAttribute("src","b.gif" );
      ((Element)v.get(835)).setAttribute("width","8" );
      ((Element)v.get(835)).setAttribute("height","8" );
      ((Element)v.get(834)).appendChild((Element)v.get(835));
      /* Termina nodo:835   */
      /* Termina nodo:834   */

      /* Empieza nodo:836 / Elemento padre: 833   */
      v.add(doc.createElement("td"));
      ((Element)v.get(836)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(833)).appendChild((Element)v.get(836));

      /* Empieza nodo:837 / Elemento padre: 836   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(837)).setAttribute("nombre","cbPerIngresoCondicion" );
      ((Element)v.get(837)).setAttribute("id","datosCampos" );
      ((Element)v.get(837)).setAttribute("onchange","validaIngreso(1);" );
      ((Element)v.get(837)).setAttribute("size","1" );
      ((Element)v.get(837)).setAttribute("multiple","N" );
      ((Element)v.get(837)).setAttribute("readonly","N" );
      ((Element)v.get(837)).setAttribute("req","N" );
      ((Element)v.get(837)).setAttribute("valorinicial","" );
      ((Element)v.get(837)).setAttribute("textoinicial","" );
      ((Element)v.get(836)).appendChild((Element)v.get(837));

      /* Empieza nodo:838 / Elemento padre: 837   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(837)).appendChild((Element)v.get(838));
      /* Termina nodo:838   */
      /* Termina nodo:837   */
      /* Termina nodo:836   */

      /* Empieza nodo:839 / Elemento padre: 833   */
   }

   private void getXML3510(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(833)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(840)).setAttribute("nombre","cbPerIngresoCondicionI" );
      ((Element)v.get(840)).setAttribute("src","b.gif" );
      ((Element)v.get(840)).setAttribute("width","25" );
      ((Element)v.get(840)).setAttribute("height","8" );
      ((Element)v.get(839)).appendChild((Element)v.get(840));
      /* Termina nodo:840   */
      /* Termina nodo:839   */

      /* Empieza nodo:841 / Elemento padre: 833   */
      v.add(doc.createElement("td"));
      ((Element)v.get(841)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(833)).appendChild((Element)v.get(841));

      /* Empieza nodo:842 / Elemento padre: 841   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(842)).setAttribute("nombre","txtFechaIngresoCondicion" );
      ((Element)v.get(842)).setAttribute("id","datosCampos" );
      ((Element)v.get(842)).setAttribute("max","10" );
      ((Element)v.get(842)).setAttribute("tipo","" );
      ((Element)v.get(842)).setAttribute("onchange","validaIngreso(2);" );
      ((Element)v.get(842)).setAttribute("onblur","validaFecha('txtFechaIngresoCondicion');" );
      ((Element)v.get(842)).setAttribute("readonly","N" );
      ((Element)v.get(842)).setAttribute("req","N" );
      ((Element)v.get(842)).setAttribute("size","12" );
      ((Element)v.get(842)).setAttribute("valor","" );
      ((Element)v.get(842)).setAttribute("validacion","" );
      ((Element)v.get(841)).appendChild((Element)v.get(842));
      /* Termina nodo:842   */
      /* Termina nodo:841   */

      /* Empieza nodo:843 / Elemento padre: 833   */
      v.add(doc.createElement("td"));
      ((Element)v.get(833)).appendChild((Element)v.get(843));

      /* Empieza nodo:844 / Elemento padre: 843   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(844)).setAttribute("nombre","txtFechaIngresoCondicionI" );
      ((Element)v.get(844)).setAttribute("src","b.gif" );
      ((Element)v.get(844)).setAttribute("width","25" );
      ((Element)v.get(844)).setAttribute("height","8" );
      ((Element)v.get(843)).appendChild((Element)v.get(844));
      /* Termina nodo:844   */
      /* Termina nodo:843   */

      /* Empieza nodo:845 / Elemento padre: 833   */
      v.add(doc.createElement("td"));
      ((Element)v.get(845)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(833)).appendChild((Element)v.get(845));

      /* Empieza nodo:846 / Elemento padre: 845   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(846)).setAttribute("nombre","txtNPeriodosCondicion" );
      ((Element)v.get(846)).setAttribute("id","datosCampos" );
      ((Element)v.get(846)).setAttribute("max","2" );
      ((Element)v.get(846)).setAttribute("tipo","" );
      ((Element)v.get(846)).setAttribute("onchange","validaIngreso(3);" );
      ((Element)v.get(846)).setAttribute("onblur","validaEntero('txtNPeriodosCondicion');" );
      ((Element)v.get(846)).setAttribute("readonly","N" );
      ((Element)v.get(846)).setAttribute("req","N" );
      ((Element)v.get(846)).setAttribute("size","2" );
      ((Element)v.get(846)).setAttribute("valor","" );
      ((Element)v.get(846)).setAttribute("validacion","" );
      ((Element)v.get(845)).appendChild((Element)v.get(846));
      /* Termina nodo:846   */
      /* Termina nodo:845   */

      /* Empieza nodo:847 / Elemento padre: 833   */
      v.add(doc.createElement("td"));
      ((Element)v.get(847)).setAttribute("width","100%" );
      ((Element)v.get(833)).appendChild((Element)v.get(847));

      /* Empieza nodo:848 / Elemento padre: 847   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(848)).setAttribute("src","b.gif" );
      ((Element)v.get(848)).setAttribute("width","8" );
      ((Element)v.get(848)).setAttribute("height","8" );
      ((Element)v.get(847)).appendChild((Element)v.get(848));
      /* Termina nodo:848   */
      /* Termina nodo:847   */
      /* Termina nodo:833   */

      /* Empieza nodo:849 / Elemento padre: 814   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(814)).appendChild((Element)v.get(849));

      /* Empieza nodo:850 / Elemento padre: 849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(850)).setAttribute("colspan","4" );
      ((Element)v.get(849)).appendChild((Element)v.get(850));

      /* Empieza nodo:851 / Elemento padre: 850   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(851)).setAttribute("src","b.gif" );
      ((Element)v.get(851)).setAttribute("width","8" );
      ((Element)v.get(851)).setAttribute("height","8" );
      ((Element)v.get(850)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */
      /* Termina nodo:850   */
      /* Termina nodo:849   */
      /* Termina nodo:814   */
      /* Termina nodo:811   */
      /* Termina nodo:810   */

      /* Empieza nodo:852 / Elemento padre: 807   */
      v.add(doc.createElement("td"));
      ((Element)v.get(807)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(853)).setAttribute("src","b.gif" );
      ((Element)v.get(852)).appendChild((Element)v.get(853));
      /* Termina nodo:853   */
      /* Termina nodo:852   */
      /* Termina nodo:807   */

      /* Empieza nodo:854 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(854)).setAttribute("nombre","nodoImagenCondicionIngreso" );
      ((Element)v.get(178)).appendChild((Element)v.get(854));

      /* Empieza nodo:855 / Elemento padre: 854   */
      v.add(doc.createElement("td"));
      ((Element)v.get(855)).setAttribute("colspan","4" );
      ((Element)v.get(854)).appendChild((Element)v.get(855));

      /* Empieza nodo:856 / Elemento padre: 855   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(856)).setAttribute("src","b.gif" );
      ((Element)v.get(856)).setAttribute("width","8" );
      ((Element)v.get(856)).setAttribute("height","15" );
      ((Element)v.get(855)).appendChild((Element)v.get(856));
      /* Termina nodo:856   */
      /* Termina nodo:855   */
      /* Termina nodo:854   */

      /* Empieza nodo:857 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(857)).setAttribute("nombre","nodoDatosRegalo" );
      ((Element)v.get(178)).appendChild((Element)v.get(857));

      /* Empieza nodo:858 / Elemento padre: 857   */
      v.add(doc.createElement("td"));
      ((Element)v.get(857)).appendChild((Element)v.get(858));

      /* Empieza nodo:859 / Elemento padre: 858   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(859)).setAttribute("src","b.gif" );
      ((Element)v.get(858)).appendChild((Element)v.get(859));
      /* Termina nodo:859   */
      /* Termina nodo:858   */

      /* Empieza nodo:860 / Elemento padre: 857   */
   }

   private void getXML3600(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(857)).appendChild((Element)v.get(860));

      /* Empieza nodo:861 / Elemento padre: 860   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(860)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(862)).setAttribute("class","legend" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));

      /* Empieza nodo:863 / Elemento padre: 862   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(863)).setAttribute("nombre","lblDatosRegalo" );
      ((Element)v.get(863)).setAttribute("alto","13" );
      ((Element)v.get(863)).setAttribute("filas","1" );
      ((Element)v.get(863)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(863)).setAttribute("id","legend" );
      ((Element)v.get(863)).setAttribute("cod","00157" );
      ((Element)v.get(862)).appendChild((Element)v.get(863));
      /* Termina nodo:863   */
      /* Termina nodo:862   */

      /* Empieza nodo:864 / Elemento padre: 861   */
      v.add(doc.createElement("table"));
      ((Element)v.get(864)).setAttribute("width","100%" );
      ((Element)v.get(864)).setAttribute("border","0" );
      ((Element)v.get(864)).setAttribute("align","center" );
      ((Element)v.get(864)).setAttribute("cellspacing","0" );
      ((Element)v.get(864)).setAttribute("cellpadding","0" );
      ((Element)v.get(861)).appendChild((Element)v.get(864));

      /* Empieza nodo:865 / Elemento padre: 864   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(864)).appendChild((Element)v.get(865));

      /* Empieza nodo:866 / Elemento padre: 865   */
      v.add(doc.createElement("td"));
      ((Element)v.get(866)).setAttribute("colspan","4" );
      ((Element)v.get(865)).appendChild((Element)v.get(866));

      /* Empieza nodo:867 / Elemento padre: 866   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(867)).setAttribute("src","b.gif" );
      ((Element)v.get(867)).setAttribute("width","8" );
      ((Element)v.get(867)).setAttribute("height","8" );
      ((Element)v.get(866)).appendChild((Element)v.get(867));
      /* Termina nodo:867   */
      /* Termina nodo:866   */
      /* Termina nodo:865   */

      /* Empieza nodo:868 / Elemento padre: 864   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(864)).appendChild((Element)v.get(868));

      /* Empieza nodo:869 / Elemento padre: 868   */
      v.add(doc.createElement("td"));
      ((Element)v.get(868)).appendChild((Element)v.get(869));

      /* Empieza nodo:870 / Elemento padre: 869   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(870)).setAttribute("src","b.gif" );
      ((Element)v.get(870)).setAttribute("width","8" );
      ((Element)v.get(870)).setAttribute("height","8" );
      ((Element)v.get(869)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */
      /* Termina nodo:869   */

      /* Empieza nodo:871 / Elemento padre: 868   */
      v.add(doc.createElement("td"));
      ((Element)v.get(868)).appendChild((Element)v.get(871));

      /* Empieza nodo:872 / Elemento padre: 871   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(872)).setAttribute("nombre","lblProductoAEntregar" );
      ((Element)v.get(872)).setAttribute("alto","13" );
      ((Element)v.get(872)).setAttribute("filas","1" );
      ((Element)v.get(872)).setAttribute("valor","" );
      ((Element)v.get(872)).setAttribute("id","datosTitle" );
      ((Element)v.get(872)).setAttribute("cod","752" );
      ((Element)v.get(871)).appendChild((Element)v.get(872));
      /* Termina nodo:872   */
      /* Termina nodo:871   */

      /* Empieza nodo:873 / Elemento padre: 868   */
      v.add(doc.createElement("td"));
      ((Element)v.get(868)).appendChild((Element)v.get(873));

      /* Empieza nodo:874 / Elemento padre: 873   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(874)).setAttribute("nombre","lblProductoAEntregarI" );
      ((Element)v.get(874)).setAttribute("src","b.gif" );
      ((Element)v.get(874)).setAttribute("width","25" );
      ((Element)v.get(874)).setAttribute("height","8" );
      ((Element)v.get(873)).appendChild((Element)v.get(874));
      /* Termina nodo:874   */
      /* Termina nodo:873   */

      /* Empieza nodo:875 / Elemento padre: 868   */
      v.add(doc.createElement("td"));
      ((Element)v.get(868)).appendChild((Element)v.get(875));

      /* Empieza nodo:876 / Elemento padre: 875   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(876)).setAttribute("nombre","lblUniRegalo" );
      ((Element)v.get(876)).setAttribute("alto","13" );
      ((Element)v.get(876)).setAttribute("filas","1" );
      ((Element)v.get(876)).setAttribute("valor","" );
      ((Element)v.get(876)).setAttribute("id","datosTitle" );
      ((Element)v.get(876)).setAttribute("cod","759" );
      ((Element)v.get(875)).appendChild((Element)v.get(876));
      /* Termina nodo:876   */
      /* Termina nodo:875   */

      /* Empieza nodo:877 / Elemento padre: 868   */
      v.add(doc.createElement("td"));
      ((Element)v.get(868)).appendChild((Element)v.get(877));

      /* Empieza nodo:878 / Elemento padre: 877   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(878)).setAttribute("nombre","lblUniRegaloI" );
      ((Element)v.get(878)).setAttribute("src","b.gif" );
      ((Element)v.get(878)).setAttribute("width","25" );
      ((Element)v.get(878)).setAttribute("height","8" );
      ((Element)v.get(877)).appendChild((Element)v.get(878));
      /* Termina nodo:878   */
      /* Termina nodo:877   */

      /* Empieza nodo:879 / Elemento padre: 868   */
      v.add(doc.createElement("td"));
      ((Element)v.get(868)).appendChild((Element)v.get(879));

      /* Empieza nodo:880 / Elemento padre: 879   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(880)).setAttribute("nombre","lblMomentoEntrega" );
      ((Element)v.get(880)).setAttribute("alto","13" );
      ((Element)v.get(880)).setAttribute("filas","1" );
      ((Element)v.get(880)).setAttribute("valor","" );
      ((Element)v.get(880)).setAttribute("id","datosTitle" );
      ((Element)v.get(880)).setAttribute("cod","737" );
      ((Element)v.get(879)).appendChild((Element)v.get(880));
      /* Termina nodo:880   */
      /* Termina nodo:879   */

      /* Empieza nodo:881 / Elemento padre: 868   */
      v.add(doc.createElement("td"));
      ((Element)v.get(881)).setAttribute("width","100%" );
      ((Element)v.get(868)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
   }

   private void getXML3690(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(882)).setAttribute("src","b.gif" );
      ((Element)v.get(882)).setAttribute("width","8" );
      ((Element)v.get(882)).setAttribute("height","8" );
      ((Element)v.get(881)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */
      /* Termina nodo:881   */
      /* Termina nodo:868   */

      /* Empieza nodo:883 / Elemento padre: 864   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(864)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(883)).appendChild((Element)v.get(884));

      /* Empieza nodo:885 / Elemento padre: 884   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(885)).setAttribute("src","b.gif" );
      ((Element)v.get(885)).setAttribute("width","8" );
      ((Element)v.get(885)).setAttribute("height","8" );
      ((Element)v.get(884)).appendChild((Element)v.get(885));
      /* Termina nodo:885   */
      /* Termina nodo:884   */

      /* Empieza nodo:886 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(886)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(883)).appendChild((Element)v.get(886));

      /* Empieza nodo:887 / Elemento padre: 886   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(887)).setAttribute("nombre","cbProductoAEntregar" );
      ((Element)v.get(887)).setAttribute("id","datosCampos" );
      ((Element)v.get(887)).setAttribute("size","1" );
      ((Element)v.get(887)).setAttribute("onchange","obligaRegalo();" );
      ((Element)v.get(887)).setAttribute("multiple","N" );
      ((Element)v.get(887)).setAttribute("readonly","N" );
      ((Element)v.get(887)).setAttribute("req","N" );
      ((Element)v.get(887)).setAttribute("valorinicial","" );
      ((Element)v.get(887)).setAttribute("textoinicial","" );
      ((Element)v.get(886)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(887)).appendChild((Element)v.get(888));
      /* Termina nodo:888   */
      /* Termina nodo:887   */
      /* Termina nodo:886   */

      /* Empieza nodo:889 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(883)).appendChild((Element)v.get(889));

      /* Empieza nodo:890 / Elemento padre: 889   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(890)).setAttribute("nombre","cbProductoAEntregarI" );
      ((Element)v.get(890)).setAttribute("src","b.gif" );
      ((Element)v.get(890)).setAttribute("width","25" );
      ((Element)v.get(890)).setAttribute("height","8" );
      ((Element)v.get(889)).appendChild((Element)v.get(890));
      /* Termina nodo:890   */
      /* Termina nodo:889   */

      /* Empieza nodo:891 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(891)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(883)).appendChild((Element)v.get(891));

      /* Empieza nodo:892 / Elemento padre: 891   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(892)).setAttribute("nombre","txtUniRegalo" );
      ((Element)v.get(892)).setAttribute("id","datosCampos" );
      ((Element)v.get(892)).setAttribute("max","2" );
      ((Element)v.get(892)).setAttribute("tipo","" );
      ((Element)v.get(892)).setAttribute("onblur","validaEntero('txtUniRegalo');" );
      ((Element)v.get(892)).setAttribute("readonly","N" );
      ((Element)v.get(892)).setAttribute("req","N" );
      ((Element)v.get(892)).setAttribute("size","2" );
      ((Element)v.get(892)).setAttribute("valor","" );
      ((Element)v.get(892)).setAttribute("validacion","" );
      ((Element)v.get(891)).appendChild((Element)v.get(892));
      /* Termina nodo:892   */
      /* Termina nodo:891   */

      /* Empieza nodo:893 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(883)).appendChild((Element)v.get(893));

      /* Empieza nodo:894 / Elemento padre: 893   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(894)).setAttribute("nombre","txtUniRegaloI" );
      ((Element)v.get(894)).setAttribute("src","b.gif" );
      ((Element)v.get(894)).setAttribute("width","25" );
      ((Element)v.get(894)).setAttribute("height","8" );
      ((Element)v.get(893)).appendChild((Element)v.get(894));
      /* Termina nodo:894   */
      /* Termina nodo:893   */

      /* Empieza nodo:895 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(895)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(883)).appendChild((Element)v.get(895));

      /* Empieza nodo:896 / Elemento padre: 895   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(896)).setAttribute("nombre","cbMomentoEntrega" );
      ((Element)v.get(896)).setAttribute("id","datosCampos" );
      ((Element)v.get(896)).setAttribute("size","1" );
      ((Element)v.get(896)).setAttribute("multiple","N" );
      ((Element)v.get(896)).setAttribute("readonly","N" );
      ((Element)v.get(896)).setAttribute("req","N" );
      ((Element)v.get(896)).setAttribute("valorinicial","" );
      ((Element)v.get(896)).setAttribute("textoinicial","" );
      ((Element)v.get(895)).appendChild((Element)v.get(896));

      /* Empieza nodo:897 / Elemento padre: 896   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(896)).appendChild((Element)v.get(897));
      /* Termina nodo:897   */
      /* Termina nodo:896   */
      /* Termina nodo:895   */

      /* Empieza nodo:898 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(898)).setAttribute("width","100%" );
      ((Element)v.get(883)).appendChild((Element)v.get(898));

      /* Empieza nodo:899 / Elemento padre: 898   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(899)).setAttribute("src","b.gif" );
      ((Element)v.get(899)).setAttribute("width","8" );
      ((Element)v.get(899)).setAttribute("height","8" );
      ((Element)v.get(898)).appendChild((Element)v.get(899));
      /* Termina nodo:899   */
      /* Termina nodo:898   */
      /* Termina nodo:883   */

      /* Empieza nodo:900 / Elemento padre: 864   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(864)).appendChild((Element)v.get(900));

      /* Empieza nodo:901 / Elemento padre: 900   */
      v.add(doc.createElement("td"));
      ((Element)v.get(901)).setAttribute("colspan","4" );
      ((Element)v.get(900)).appendChild((Element)v.get(901));

      /* Empieza nodo:902 / Elemento padre: 901   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3780(Document doc) {
      ((Element)v.get(902)).setAttribute("src","b.gif" );
      ((Element)v.get(902)).setAttribute("width","8" );
      ((Element)v.get(902)).setAttribute("height","8" );
      ((Element)v.get(901)).appendChild((Element)v.get(902));
      /* Termina nodo:902   */
      /* Termina nodo:901   */
      /* Termina nodo:900   */
      /* Termina nodo:864   */
      /* Termina nodo:861   */
      /* Termina nodo:860   */

      /* Empieza nodo:903 / Elemento padre: 857   */
      v.add(doc.createElement("td"));
      ((Element)v.get(857)).appendChild((Element)v.get(903));

      /* Empieza nodo:904 / Elemento padre: 903   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(904)).setAttribute("src","b.gif" );
      ((Element)v.get(903)).appendChild((Element)v.get(904));
      /* Termina nodo:904   */
      /* Termina nodo:903   */
      /* Termina nodo:857   */

      /* Empieza nodo:905 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(905));

      /* Empieza nodo:906 / Elemento padre: 905   */
      v.add(doc.createElement("td"));
      ((Element)v.get(906)).setAttribute("width","12" );
      ((Element)v.get(906)).setAttribute("align","center" );
      ((Element)v.get(905)).appendChild((Element)v.get(906));

      /* Empieza nodo:907 / Elemento padre: 906   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(907)).setAttribute("src","b.gif" );
      ((Element)v.get(907)).setAttribute("width","12" );
      ((Element)v.get(907)).setAttribute("height","12" );
      ((Element)v.get(906)).appendChild((Element)v.get(907));
      /* Termina nodo:907   */
      /* Termina nodo:906   */

      /* Empieza nodo:908 / Elemento padre: 905   */
      v.add(doc.createElement("td"));
      ((Element)v.get(908)).setAttribute("width","750" );
      ((Element)v.get(905)).appendChild((Element)v.get(908));

      /* Empieza nodo:909 / Elemento padre: 908   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(909)).setAttribute("src","b.gif" );
      ((Element)v.get(908)).appendChild((Element)v.get(909));
      /* Termina nodo:909   */
      /* Termina nodo:908   */

      /* Empieza nodo:910 / Elemento padre: 905   */
      v.add(doc.createElement("td"));
      ((Element)v.get(910)).setAttribute("width","12" );
      ((Element)v.get(905)).appendChild((Element)v.get(910));

      /* Empieza nodo:911 / Elemento padre: 910   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(911)).setAttribute("src","b.gif" );
      ((Element)v.get(911)).setAttribute("width","12" );
      ((Element)v.get(911)).setAttribute("height","1" );
      ((Element)v.get(910)).appendChild((Element)v.get(911));
      /* Termina nodo:911   */
      /* Termina nodo:910   */
      /* Termina nodo:905   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:51   */


   }

}
