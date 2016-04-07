
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_bp_atributos  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_bp_atributos" );
      ((Element)v.get(0)).setAttribute("cod","0225" );
      ((Element)v.get(0)).setAttribute("titulo","Completar datos BP" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Atributos BP" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_bp_atributos.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","textNUnidClienteRepartir" );
      ((Element)v.get(4)).setAttribute("group","g1" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("format","E" );
      ((Element)v.get(4)).setAttribute("min","0" );
      ((Element)v.get(4)).setAttribute("max","999999999999" );
      ((Element)v.get(4)).setAttribute("cod","1373" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbAtributoEvaluar" );
      ((Element)v.get(5)).setAttribute("group","g1" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","1404" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbPeriodoHasta1" );
      ((Element)v.get(6)).setAttribute("group","capaPedidoSuperaMonto" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","1176" );
      ((Element)v.get(3)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbPeriodoHasta2" );
      ((Element)v.get(7)).setAttribute("group","capaPedidoSuperaMontoMarca" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","1176" );
      ((Element)v.get(3)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbPeriodoHasta3" );
      ((Element)v.get(8)).setAttribute("group","capaPedidoSuperaUnidadNegocio" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1176" );
      ((Element)v.get(3)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbPeriodoHasta4" );
      ((Element)v.get(9)).setAttribute("group","capaPedidoSuperaMontoNegocio" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1176" );
      ((Element)v.get(3)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbPeriodoHasta5" );
      ((Element)v.get(10)).setAttribute("group","capaPedidoSuperaMontoCatalogo" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1176" );
      ((Element)v.get(3)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","textNCumpleanyos" );
      ((Element)v.get(11)).setAttribute("group","textNCumpleanyos" );
      ((Element)v.get(11)).setAttribute("format","E" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1407" );
      ((Element)v.get(3)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","textNAniversario" );
      ((Element)v.get(12)).setAttribute("group","textNAniversario" );
      ((Element)v.get(12)).setAttribute("format","E" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","999" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1405" );
      ((Element)v.get(3)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","textEdadDesde" );
      ((Element)v.get(13)).setAttribute("group","textEdadDesde" );
      ((Element)v.get(13)).setAttribute("format","E" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","999" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1406" );
      ((Element)v.get(3)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 3   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","textEdadHasta" );
      ((Element)v.get(14)).setAttribute("group","textEdadHasta" );
      ((Element)v.get(14)).setAttribute("format","E" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","999" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","1407" );
      ((Element)v.get(3)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","textMonto1" );
      ((Element)v.get(15)).setAttribute("group","textMonto1" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("format","m" );
      ((Element)v.get(15)).setAttribute("min","0" );
      ((Element)v.get(15)).setAttribute("max","999999999999999.99" );
      ((Element)v.get(15)).setAttribute("cod","917" );
      ((Element)v.get(3)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","textMonto2" );
      ((Element)v.get(16)).setAttribute("group","textMonto2" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("format","m" );
      ((Element)v.get(16)).setAttribute("min","0" );
      ((Element)v.get(16)).setAttribute("max","999999999999999.99" );
      ((Element)v.get(16)).setAttribute("cod","917" );
      ((Element)v.get(3)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","cbMarca" );
      ((Element)v.get(17)).setAttribute("group","textMonto2" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","6" );
      ((Element)v.get(3)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","textMonto3" );
      ((Element)v.get(18)).setAttribute("group","textMonto3" );
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("format","m" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","999999999999999.99" );
      ((Element)v.get(18)).setAttribute("cod","917" );
      ((Element)v.get(3)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","cbUnidNegocio" );
      ((Element)v.get(19)).setAttribute("group","textMonto3" );
      ((Element)v.get(19)).setAttribute("required","true" );
      ((Element)v.get(19)).setAttribute("cod","1338" );
      ((Element)v.get(3)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","textMonto4" );
      ((Element)v.get(20)).setAttribute("group","textMonto4" );
      ((Element)v.get(20)).setAttribute("required","true" );
      ((Element)v.get(20)).setAttribute("format","m" );
      ((Element)v.get(20)).setAttribute("min","0" );
      ((Element)v.get(20)).setAttribute("max","999999999999999.99" );
      ((Element)v.get(20)).setAttribute("cod","917" );
      ((Element)v.get(3)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbNegocio" );
      ((Element)v.get(21)).setAttribute("group","textMonto4" );
      ((Element)v.get(21)).setAttribute("required","true" );
      ((Element)v.get(21)).setAttribute("cod","588" );
      ((Element)v.get(3)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","textMonto5" );
      ((Element)v.get(22)).setAttribute("group","textMonto5" );
      ((Element)v.get(22)).setAttribute("required","true" );
      ((Element)v.get(22)).setAttribute("format","m" );
      ((Element)v.get(22)).setAttribute("min","0" );
      ((Element)v.get(22)).setAttribute("max","999999999999999.99" );
      ((Element)v.get(22)).setAttribute("cod","917" );
      ((Element)v.get(3)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","cbCatalogo" );
      ((Element)v.get(23)).setAttribute("group","textMonto5" );
      ((Element)v.get(23)).setAttribute("required","true" );
      ((Element)v.get(23)).setAttribute("cod","516" );
      ((Element)v.get(3)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:3   */

      /* Empieza nodo:24 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(24)).setAttribute("nombre","frmAtributos" );
      ((Element)v.get(0)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","accion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(27)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","varSubcriterio" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","varNumUnidadesCliente" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","varNumeroAniversario" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","varEdadDesde" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","varEdadHasta" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","varMonto" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","varPeriodoDesde" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","varPeriodoHasta" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","varMarcaCriterio" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","varCatalogo" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","varUnidadNegocio" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","varNegocio" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","varCampanyaFuente" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","varNumUnidadesTotales" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","varCriterio" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 24   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","varEstadoProceso" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(24)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(46)).setAttribute("nombre","capaPrincipal" );
      ((Element)v.get(46)).setAttribute("alto","100%" );
      ((Element)v.get(46)).setAttribute("ancho","100%" );
      ((Element)v.get(46)).setAttribute("x","0" );
      ((Element)v.get(46)).setAttribute("y","0" );
      ((Element)v.get(24)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(47)).setAttribute("border","0" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(50)).setAttribute("height","12" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","750" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","12" );
      ((Element)v.get(54)).setAttribute("height","1" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:48   */

      /* Empieza nodo:55 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(60)).setAttribute("class","legend" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblTitAtributos" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("cod","00175" );
      ((Element)v.get(61)).setAttribute("id","legend" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("table"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(62)).setAttribute("border","0" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","634" );
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
      ((Element)v.get(67)).setAttribute("colspan","4" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblNUnidClienteRepartir" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(73)).setAttribute("cod","1373" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblAtributoEvaluar" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","1404" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:69   */

      /* Empieza nodo:80 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("valign","bottom" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(84)).setAttribute("nombre","textNUnidClienteRepartir" );
      ((Element)v.get(84)).setAttribute("onshtab","shTab();" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("max","10" );
      ((Element)v.get(84)).setAttribute("tipo","" );
      ((Element)v.get(84)).setAttribute("onchange","" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(84)).setAttribute("size","10" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("validacion","" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","cbAtributoEvaluar" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("req","S" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("onchange","changeAtributo();" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:80   */

      /* Empieza nodo:92 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("colspan","4" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:95 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","12" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:55   */

      /* Empieza nodo:97 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("table"));
      ((Element)v.get(102)).setAttribute("width","100%" );
      ((Element)v.get(102)).setAttribute("border","0" );
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(102)).setAttribute("cellspacing","0" );
      ((Element)v.get(102)).setAttribute("cellpadding","0" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("class","botonera" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(105)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(105)).setAttribute("ID","botonContenido" );
      ((Element)v.get(105)).setAttribute("ontab","tabAceptar();" );
      ((Element)v.get(105)).setAttribute("tipo","html" );
      ((Element)v.get(105)).setAttribute("accion","procesaAtributo();" );
      ((Element)v.get(105)).setAttribute("estado","false" );
      ((Element)v.get(105)).setAttribute("cod","12" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:106 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","12" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:97   */

      /* Empieza nodo:108 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("height","12" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","750" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(108)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(114)).setAttribute("height","12" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:108   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:115 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(115)).setAttribute("nombre","capaAniversario" );
      ((Element)v.get(115)).setAttribute("alto","120" );
      ((Element)v.get(115)).setAttribute("ancho","100%" );
      ((Element)v.get(115)).setAttribute("x","0" );
      ((Element)v.get(115)).setAttribute("y","105" );
      ((Element)v.get(115)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(24)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","100%" );
      ((Element)v.get(116)).setAttribute("border","0" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("cellpadding","0" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","12" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","12" );
      ((Element)v.get(119)).setAttribute("height","12" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","750" );
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","12" );
      ((Element)v.get(117)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","12" );
      ((Element)v.get(123)).setAttribute("height","1" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:117   */

      /* Empieza nodo:124 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(129)).setAttribute("class","legend" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblAniversario" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("cod","00523" );
      ((Element)v.get(130)).setAttribute("id","legend" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(131)).setAttribute("border","0" );
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("cellpadding","0" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("table"));
      ((Element)v.get(134)).setAttribute("width","634" );
      ((Element)v.get(134)).setAttribute("border","0" );
      ((Element)v.get(134)).setAttribute("align","left" );
      ((Element)v.get(134)).setAttribute("cellspacing","0" );
      ((Element)v.get(134)).setAttribute("cellpadding","0" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("colspan","4" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:138 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblNAniversario" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","1405" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:138   */

      /* Empieza nodo:145 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(145));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(149)).setAttribute("nombre","textNAniversario" );
      ((Element)v.get(149)).setAttribute("id","datosCampos" );
      ((Element)v.get(149)).setAttribute("max","3" );
      ((Element)v.get(149)).setAttribute("tipo","" );
      ((Element)v.get(149)).setAttribute("onchange","" );
      ((Element)v.get(149)).setAttribute("req","N" );
      ((Element)v.get(149)).setAttribute("size","3" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(149)).setAttribute("validacion","" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(145)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:145   */

      /* Empieza nodo:152 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("colspan","4" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:155 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","12" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:124   */

      /* Empieza nodo:157 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("table"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(162)).setAttribute("border","0" );
      ((Element)v.get(162)).setAttribute("align","center" );
      ((Element)v.get(162)).setAttribute("cellspacing","0" );
      ((Element)v.get(162)).setAttribute("cellpadding","0" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("class","botonera" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(165)).setAttribute("nombre","btnContinuar" );
      ((Element)v.get(165)).setAttribute("ontab","focaliza('frmAtributos.textNUnidClienteRepartir','');" );
      ((Element)v.get(165)).setAttribute("ID","botonContenido" );
      ((Element)v.get(165)).setAttribute("tipo","html" );
      ((Element)v.get(165)).setAttribute("accion","continuar();" );
      ((Element)v.get(165)).setAttribute("estado","false" );
      ((Element)v.get(165)).setAttribute("cod","2247" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:166 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","12" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:157   */

      /* Empieza nodo:168 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(169)).setAttribute("align","center" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(170)).setAttribute("height","12" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","750" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("width","12" );
      ((Element)v.get(168)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","12" );
      ((Element)v.get(174)).setAttribute("height","12" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:168   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:175 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(175)).setAttribute("nombre","capaEdad" );
      ((Element)v.get(175)).setAttribute("alto","120" );
      ((Element)v.get(175)).setAttribute("ancho","100%" );
      ((Element)v.get(175)).setAttribute("x","0" );
      ((Element)v.get(175)).setAttribute("y","105" );
      ((Element)v.get(175)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(24)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("table"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(176)).setAttribute("border","0" );
      ((Element)v.get(176)).setAttribute("cellspacing","0" );
      ((Element)v.get(176)).setAttribute("cellpadding","0" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","12" );
      ((Element)v.get(178)).setAttribute("align","center" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","12" );
      ((Element)v.get(179)).setAttribute("height","12" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","750" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("width","12" );
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","12" );
      ((Element)v.get(183)).setAttribute("height","1" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:177   */

      /* Empieza nodo:184 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(189)).setAttribute("class","legend" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lblEdad" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("cod","00525" );
      ((Element)v.get(190)).setAttribute("id","legend" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("table"));
      ((Element)v.get(191)).setAttribute("width","100%" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(191)).setAttribute("border","0" );
      ((Element)v.get(191)).setAttribute("align","center" );
      ((Element)v.get(191)).setAttribute("cellspacing","0" );
      ((Element)v.get(191)).setAttribute("cellpadding","0" );
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("table"));
      ((Element)v.get(194)).setAttribute("width","634" );
      ((Element)v.get(194)).setAttribute("border","0" );
      ((Element)v.get(194)).setAttribute("align","left" );
      ((Element)v.get(194)).setAttribute("cellspacing","0" );
      ((Element)v.get(194)).setAttribute("cellpadding","0" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("colspan","4" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:198 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lblEdadDesde" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("id","datosTitle" );
      ((Element)v.get(202)).setAttribute("cod","1406" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblEdadHasta" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","1407" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(198)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:198   */

      /* Empieza nodo:209 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(213)).setAttribute("nombre","textEdadDesde" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("max","3" );
      ((Element)v.get(213)).setAttribute("tipo","" );
      ((Element)v.get(213)).setAttribute("onchange","" );
      ((Element)v.get(213)).setAttribute("req","N" );
      ((Element)v.get(213)).setAttribute("size","3" );
      ((Element)v.get(213)).setAttribute("valor","" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(213)).setAttribute("validacion","" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(217)).setAttribute("nombre","textEdadHasta" );
      ((Element)v.get(217)).setAttribute("id","datosCampos" );
      ((Element)v.get(217)).setAttribute("max","3" );
      ((Element)v.get(217)).setAttribute("tipo","" );
      ((Element)v.get(217)).setAttribute("onchange","" );
      ((Element)v.get(217)).setAttribute("req","N" );
      ((Element)v.get(217)).setAttribute("size","3" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("validacion","" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:209   */

      /* Empieza nodo:220 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("colspan","4" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:223 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","12" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:184   */

      /* Empieza nodo:225 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("table"));
      ((Element)v.get(230)).setAttribute("width","100%" );
      ((Element)v.get(230)).setAttribute("border","0" );
      ((Element)v.get(230)).setAttribute("align","center" );
      ((Element)v.get(230)).setAttribute("cellspacing","0" );
      ((Element)v.get(230)).setAttribute("cellpadding","0" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("class","botonera" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(233)).setAttribute("nombre","btnContinuar2" );
      ((Element)v.get(233)).setAttribute("ontab","focaliza('frmAtributos.textNUnidClienteRepartir','');" );
      ((Element)v.get(233)).setAttribute("ID","botonContenido" );
      ((Element)v.get(233)).setAttribute("tipo","html" );
      ((Element)v.get(233)).setAttribute("accion","continuar();" );
      ((Element)v.get(233)).setAttribute("estado","false" );
      ((Element)v.get(233)).setAttribute("cod","2247" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:234 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","12" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:225   */

      /* Empieza nodo:236 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("width","12" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(237)).setAttribute("align","center" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","12" );
      ((Element)v.get(238)).setAttribute("height","12" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("width","750" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("width","12" );
      ((Element)v.get(236)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","12" );
      ((Element)v.get(242)).setAttribute("height","12" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:236   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:243 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(243)).setAttribute("nombre","capaPedidoSuperaMonto" );
      ((Element)v.get(243)).setAttribute("alto","120" );
      ((Element)v.get(243)).setAttribute("ancho","100%" );
      ((Element)v.get(243)).setAttribute("x","0" );
      ((Element)v.get(243)).setAttribute("y","105" );
      ((Element)v.get(243)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(24)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("table"));
      ((Element)v.get(244)).setAttribute("width","100%" );
      ((Element)v.get(244)).setAttribute("border","0" );
      ((Element)v.get(244)).setAttribute("cellspacing","0" );
      ((Element)v.get(244)).setAttribute("cellpadding","0" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("width","12" );
      ((Element)v.get(246)).setAttribute("align","center" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","12" );
      ((Element)v.get(247)).setAttribute("height","12" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","750" );
      ((Element)v.get(245)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","12" );
      ((Element)v.get(245)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","12" );
      ((Element)v.get(251)).setAttribute("height","1" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:245   */

      /* Empieza nodo:252 / Elemento padre: 244   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(244)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(257)).setAttribute("class","legend" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(258)).setAttribute("nombre","lblPedidoSuperaMonto" );
      ((Element)v.get(258)).setAttribute("alto","13" );
      ((Element)v.get(258)).setAttribute("filas","1" );
      ((Element)v.get(258)).setAttribute("cod","00526" );
      ((Element)v.get(258)).setAttribute("id","legend" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 256   */
      v.add(doc.createElement("table"));
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(259)).setAttribute("border","0" );
      ((Element)v.get(259)).setAttribute("align","center" );
      ((Element)v.get(259)).setAttribute("cellspacing","0" );
      ((Element)v.get(259)).setAttribute("cellpadding","0" );
      ((Element)v.get(256)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("table"));
      ((Element)v.get(262)).setAttribute("width","634" );
      ((Element)v.get(262)).setAttribute("border","0" );
      ((Element)v.get(262)).setAttribute("align","left" );
      ((Element)v.get(262)).setAttribute("cellspacing","0" );
      ((Element)v.get(262)).setAttribute("cellpadding","0" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("colspan","4" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:266 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(266));

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
      ((Element)v.get(270)).setAttribute("nombre","lblMonto1" );
      ((Element)v.get(270)).setAttribute("alto","13" );
      ((Element)v.get(270)).setAttribute("filas","1" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("id","datosTitle" );
      ((Element)v.get(270)).setAttribute("cod","917" );
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
      ((Element)v.get(274)).setAttribute("nombre","lblPeriodoDesde1" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(274)).setAttribute("id","datosTitle" );
      ((Element)v.get(274)).setAttribute("cod","1175" );
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
      ((Element)v.get(278)).setAttribute("nombre","lblPeriodoHasta1" );
      ((Element)v.get(278)).setAttribute("alto","13" );
      ((Element)v.get(278)).setAttribute("filas","1" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(278)).setAttribute("id","datosTitle" );
      ((Element)v.get(278)).setAttribute("cod","1176" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","100%" );
      ((Element)v.get(266)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:266   */

      /* Empieza nodo:281 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(285)).setAttribute("nombre","textMonto1" );
      ((Element)v.get(285)).setAttribute("id","datosCampos" );
      ((Element)v.get(285)).setAttribute("max","18" );
      ((Element)v.get(285)).setAttribute("tipo","" );
      ((Element)v.get(285)).setAttribute("onchange","" );
      ((Element)v.get(285)).setAttribute("req","N" );
      ((Element)v.get(285)).setAttribute("size","18" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(285)).setAttribute("validacion","" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","25" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(281)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(289)).setAttribute("nombre","cbPeriodoDesde1" );
      ((Element)v.get(289)).setAttribute("id","datosCampos" );
      ((Element)v.get(289)).setAttribute("size","1" );
      ((Element)v.get(289)).setAttribute("multiple","N" );
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

      /* Empieza nodo:291 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","25" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(281)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(294)).setAttribute("nombre","cbPeriodoHasta1" );
      ((Element)v.get(294)).setAttribute("id","datosCampos" );
      ((Element)v.get(294)).setAttribute("size","1" );
      ((Element)v.get(294)).setAttribute("multiple","N" );
      ((Element)v.get(294)).setAttribute("req","N" );
      ((Element)v.get(294)).setAttribute("valorinicial","" );
      ((Element)v.get(294)).setAttribute("textoinicial","" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:296 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).setAttribute("width","100%" );
      ((Element)v.get(281)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:281   */

      /* Empieza nodo:298 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).setAttribute("colspan","4" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","8" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:301 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(302)).setAttribute("height","12" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:252   */

      /* Empieza nodo:303 / Elemento padre: 244   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(244)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(308)).setAttribute("width","100%" );
      ((Element)v.get(308)).setAttribute("border","0" );
      ((Element)v.get(308)).setAttribute("align","center" );
      ((Element)v.get(308)).setAttribute("cellspacing","0" );
      ((Element)v.get(308)).setAttribute("cellpadding","0" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("class","botonera" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(311)).setAttribute("nombre","btnContinuar3" );
      ((Element)v.get(311)).setAttribute("ontab","focaliza('frmAtributos.textNUnidClienteRepartir','');" );
      ((Element)v.get(311)).setAttribute("ID","botonContenido" );
      ((Element)v.get(311)).setAttribute("tipo","html" );
      ((Element)v.get(311)).setAttribute("accion","continuar();" );
      ((Element)v.get(311)).setAttribute("estado","false" );
      ((Element)v.get(311)).setAttribute("cod","2247" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:312 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","12" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:303   */

      /* Empieza nodo:314 / Elemento padre: 244   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(244)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("width","12" );
      ((Element)v.get(315)).setAttribute("align","center" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","12" );
      ((Element)v.get(316)).setAttribute("height","12" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).setAttribute("width","750" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("width","12" );
      ((Element)v.get(314)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","12" );
      ((Element)v.get(320)).setAttribute("height","12" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:314   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:321 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(321)).setAttribute("nombre","capaPedidoSuperaMontoMarca" );
      ((Element)v.get(321)).setAttribute("alto","120" );
      ((Element)v.get(321)).setAttribute("ancho","100%" );
      ((Element)v.get(321)).setAttribute("x","0" );
      ((Element)v.get(321)).setAttribute("y","105" );
      ((Element)v.get(321)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(24)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("table"));
      ((Element)v.get(322)).setAttribute("width","100%" );
      ((Element)v.get(322)).setAttribute("border","0" );
      ((Element)v.get(322)).setAttribute("cellspacing","0" );
      ((Element)v.get(322)).setAttribute("cellpadding","0" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("width","12" );
      ((Element)v.get(324)).setAttribute("align","center" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","12" );
      ((Element)v.get(325)).setAttribute("height","12" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("width","750" );
      ((Element)v.get(323)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("width","12" );
      ((Element)v.get(323)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","12" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(329)).setAttribute("height","1" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:323   */

      /* Empieza nodo:330 / Elemento padre: 322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(335)).setAttribute("class","legend" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(336)).setAttribute("nombre","lblPedidoSuperaMontoMarca" );
      ((Element)v.get(336)).setAttribute("alto","13" );
      ((Element)v.get(336)).setAttribute("filas","1" );
      ((Element)v.get(336)).setAttribute("cod","00527" );
      ((Element)v.get(336)).setAttribute("id","legend" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("table"));
      ((Element)v.get(337)).setAttribute("width","100%" );
      ((Element)v.get(337)).setAttribute("border","0" );
      ((Element)v.get(337)).setAttribute("align","center" );
      ((Element)v.get(337)).setAttribute("cellspacing","0" );
      ((Element)v.get(337)).setAttribute("cellpadding","0" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("table"));
      ((Element)v.get(340)).setAttribute("width","634" );
      ((Element)v.get(340)).setAttribute("border","0" );
      ((Element)v.get(340)).setAttribute("align","left" );
      ((Element)v.get(340)).setAttribute("cellspacing","0" );
      ((Element)v.get(340)).setAttribute("cellpadding","0" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("colspan","4" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:344 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","8" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(348)).setAttribute("nombre","lblMonto2" );
      ((Element)v.get(348)).setAttribute("alto","13" );
      ((Element)v.get(348)).setAttribute("filas","1" );
      ((Element)v.get(348)).setAttribute("valor","" );
      ((Element)v.get(348)).setAttribute("id","datosTitle" );
      ((Element)v.get(348)).setAttribute("cod","917" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","25" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(352)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(352)).setAttribute("alto","13" );
      ((Element)v.get(352)).setAttribute("filas","1" );
      ((Element)v.get(352)).setAttribute("valor","" );
      ((Element)v.get(352)).setAttribute("id","datosTitle" );
      ((Element)v.get(352)).setAttribute("cod","6" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","25" );
      ((Element)v.get(354)).setAttribute("height","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(356)).setAttribute("nombre","lblPeriodoDesde2" );
      ((Element)v.get(356)).setAttribute("alto","13" );
      ((Element)v.get(356)).setAttribute("filas","1" );
      ((Element)v.get(356)).setAttribute("valor","" );
      ((Element)v.get(356)).setAttribute("id","datosTitle" );
      ((Element)v.get(356)).setAttribute("cod","1175" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","25" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(360)).setAttribute("nombre","lblPeriodoHasta2" );
      ((Element)v.get(360)).setAttribute("alto","13" );
      ((Element)v.get(360)).setAttribute("filas","1" );
      ((Element)v.get(360)).setAttribute("valor","" );
      ((Element)v.get(360)).setAttribute("id","datosTitle" );
      ((Element)v.get(360)).setAttribute("cod","1176" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).setAttribute("width","100%" );
      ((Element)v.get(344)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:344   */

      /* Empieza nodo:363 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","8" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(367)).setAttribute("nombre","textMonto2" );
      ((Element)v.get(367)).setAttribute("id","datosCampos" );
      ((Element)v.get(367)).setAttribute("max","18" );
      ((Element)v.get(367)).setAttribute("tipo","" );
      ((Element)v.get(367)).setAttribute("onchange","" );
      ((Element)v.get(367)).setAttribute("req","N" );
      ((Element)v.get(367)).setAttribute("size","18" );
      ((Element)v.get(367)).setAttribute("valor","" );
      ((Element)v.get(367)).setAttribute("validacion","" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","25" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(363)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(371)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(371)).setAttribute("id","datosCampos" );
      ((Element)v.get(371)).setAttribute("size","1" );
      ((Element)v.get(371)).setAttribute("multiple","N" );
      ((Element)v.get(371)).setAttribute("req","N" );
      ((Element)v.get(371)).setAttribute("valorinicial","" );
      ((Element)v.get(371)).setAttribute("textoinicial","" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:373 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","25" );
      ((Element)v.get(374)).setAttribute("height","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(375)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(363)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(376)).setAttribute("nombre","cbPeriodoDesde2" );
      ((Element)v.get(376)).setAttribute("id","datosCampos" );
      ((Element)v.get(376)).setAttribute("size","1" );
      ((Element)v.get(376)).setAttribute("multiple","N" );
      ((Element)v.get(376)).setAttribute("req","N" );
      ((Element)v.get(376)).setAttribute("valorinicial","" );
      ((Element)v.get(376)).setAttribute("textoinicial","" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:378 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","25" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(380)).setAttribute("valign","top" );
      ((Element)v.get(363)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(381)).setAttribute("nombre","cbPeriodoHasta2" );
      ((Element)v.get(381)).setAttribute("id","datosCampos" );
      ((Element)v.get(381)).setAttribute("size","1" );
      ((Element)v.get(381)).setAttribute("multiple","N" );
      ((Element)v.get(381)).setAttribute("req","N" );
      ((Element)v.get(381)).setAttribute("valorinicial","" );
      ((Element)v.get(381)).setAttribute("textoinicial","" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:383 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(363)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:363   */

      /* Empieza nodo:385 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("colspan","4" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:388 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","8" );
      ((Element)v.get(389)).setAttribute("height","12" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:330   */

      /* Empieza nodo:390 / Elemento padre: 322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("table"));
      ((Element)v.get(395)).setAttribute("width","100%" );
      ((Element)v.get(395)).setAttribute("border","0" );
      ((Element)v.get(395)).setAttribute("align","center" );
      ((Element)v.get(395)).setAttribute("cellspacing","0" );
      ((Element)v.get(395)).setAttribute("cellpadding","0" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).setAttribute("class","botonera" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(398)).setAttribute("nombre","btnContinuar4" );
      ((Element)v.get(398)).setAttribute("ontab","focaliza('frmAtributos.textNUnidClienteRepartir','');" );
      ((Element)v.get(398)).setAttribute("ID","botonContenido" );
      ((Element)v.get(398)).setAttribute("tipo","html" );
      ((Element)v.get(398)).setAttribute("accion","continuar();" );
      ((Element)v.get(398)).setAttribute("estado","false" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(398)).setAttribute("cod","2247" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:399 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","8" );
      ((Element)v.get(400)).setAttribute("height","12" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:390   */

      /* Empieza nodo:401 / Elemento padre: 322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).setAttribute("width","12" );
      ((Element)v.get(402)).setAttribute("align","center" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","12" );
      ((Element)v.get(403)).setAttribute("height","12" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).setAttribute("width","750" );
      ((Element)v.get(401)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).setAttribute("width","12" );
      ((Element)v.get(401)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","12" );
      ((Element)v.get(407)).setAttribute("height","12" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:401   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:408 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(408)).setAttribute("nombre","capaPedidoSuperaMontoUnidNegocio" );
      ((Element)v.get(408)).setAttribute("alto","120" );
      ((Element)v.get(408)).setAttribute("ancho","100%" );
      ((Element)v.get(408)).setAttribute("x","0" );
      ((Element)v.get(408)).setAttribute("y","105" );
      ((Element)v.get(408)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(24)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("table"));
      ((Element)v.get(409)).setAttribute("width","100%" );
      ((Element)v.get(409)).setAttribute("border","0" );
      ((Element)v.get(409)).setAttribute("cellspacing","0" );
      ((Element)v.get(409)).setAttribute("cellpadding","0" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).setAttribute("width","12" );
      ((Element)v.get(411)).setAttribute("align","center" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","12" );
      ((Element)v.get(412)).setAttribute("height","12" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 410   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("width","750" );
      ((Element)v.get(410)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 410   */
      v.add(doc.createElement("td"));
      ((Element)v.get(415)).setAttribute("width","12" );
      ((Element)v.get(410)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","12" );
      ((Element)v.get(416)).setAttribute("height","1" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:410   */

      /* Empieza nodo:417 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(422)).setAttribute("class","legend" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(423)).setAttribute("nombre","lblPedidoSuperaMontoUnidadNegocio" );
      ((Element)v.get(423)).setAttribute("alto","13" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(423)).setAttribute("filas","1" );
      ((Element)v.get(423)).setAttribute("cod","00528" );
      ((Element)v.get(423)).setAttribute("id","legend" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("table"));
      ((Element)v.get(424)).setAttribute("width","100%" );
      ((Element)v.get(424)).setAttribute("border","0" );
      ((Element)v.get(424)).setAttribute("align","center" );
      ((Element)v.get(424)).setAttribute("cellspacing","0" );
      ((Element)v.get(424)).setAttribute("cellpadding","0" );
      ((Element)v.get(421)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("table"));
      ((Element)v.get(427)).setAttribute("width","634" );
      ((Element)v.get(427)).setAttribute("border","0" );
      ((Element)v.get(427)).setAttribute("align","left" );
      ((Element)v.get(427)).setAttribute("cellspacing","0" );
      ((Element)v.get(427)).setAttribute("cellpadding","0" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

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
      ((Element)v.get(435)).setAttribute("nombre","lblMonto3" );
      ((Element)v.get(435)).setAttribute("alto","13" );
      ((Element)v.get(435)).setAttribute("filas","1" );
      ((Element)v.get(435)).setAttribute("valor","" );
      ((Element)v.get(435)).setAttribute("id","datosTitle" );
      ((Element)v.get(435)).setAttribute("cod","917" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
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
      ((Element)v.get(439)).setAttribute("nombre","lblUnidNegocio" );
      ((Element)v.get(439)).setAttribute("alto","13" );
      ((Element)v.get(439)).setAttribute("filas","1" );
      ((Element)v.get(439)).setAttribute("valor","" );
      ((Element)v.get(439)).setAttribute("id","datosTitle" );
      ((Element)v.get(439)).setAttribute("cod","1338" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(441)).setAttribute("src","b.gif" );
      ((Element)v.get(441)).setAttribute("width","25" );
      ((Element)v.get(441)).setAttribute("height","8" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:442 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(443)).setAttribute("nombre","lblPeriodoDesde3" );
      ((Element)v.get(443)).setAttribute("alto","13" );
      ((Element)v.get(443)).setAttribute("filas","1" );
      ((Element)v.get(443)).setAttribute("valor","" );
      ((Element)v.get(443)).setAttribute("id","datosTitle" );
      ((Element)v.get(443)).setAttribute("cod","1175" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:444 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","25" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(445)).setAttribute("height","8" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(447)).setAttribute("nombre","lblPeriodoHasta3" );
      ((Element)v.get(447)).setAttribute("alto","13" );
      ((Element)v.get(447)).setAttribute("filas","1" );
      ((Element)v.get(447)).setAttribute("valor","" );
      ((Element)v.get(447)).setAttribute("id","datosTitle" );
      ((Element)v.get(447)).setAttribute("cod","1176" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("width","100%" );
      ((Element)v.get(431)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","8" );
      ((Element)v.get(449)).setAttribute("height","8" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:431   */

      /* Empieza nodo:450 / Elemento padre: 427   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(427)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","8" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(454)).setAttribute("nombre","textMonto3" );
      ((Element)v.get(454)).setAttribute("id","datosCampos" );
      ((Element)v.get(454)).setAttribute("max","18" );
      ((Element)v.get(454)).setAttribute("tipo","" );
      ((Element)v.get(454)).setAttribute("onchange","" );
      ((Element)v.get(454)).setAttribute("req","N" );
      ((Element)v.get(454)).setAttribute("size","18" );
      ((Element)v.get(454)).setAttribute("valor","" );
      ((Element)v.get(454)).setAttribute("validacion","" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","25" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(450)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(458)).setAttribute("nombre","cbUnidNegocio" );
      ((Element)v.get(458)).setAttribute("id","datosCampos" );
      ((Element)v.get(458)).setAttribute("size","1" );
      ((Element)v.get(458)).setAttribute("multiple","N" );
      ((Element)v.get(458)).setAttribute("req","N" );
      ((Element)v.get(458)).setAttribute("valorinicial","" );
      ((Element)v.get(458)).setAttribute("textoinicial","" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:460 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","25" );
      ((Element)v.get(461)).setAttribute("height","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(450)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(463)).setAttribute("nombre","cbPeriodoDesde3" );
      ((Element)v.get(463)).setAttribute("id","datosCampos" );
      ((Element)v.get(463)).setAttribute("size","1" );
      ((Element)v.get(463)).setAttribute("multiple","N" );
      ((Element)v.get(463)).setAttribute("req","N" );
      ((Element)v.get(463)).setAttribute("valorinicial","" );
      ((Element)v.get(463)).setAttribute("textoinicial","" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:465 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(466)).setAttribute("width","25" );
      ((Element)v.get(466)).setAttribute("height","8" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:467 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(450)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(468)).setAttribute("nombre","cbPeriodoHasta3" );
      ((Element)v.get(468)).setAttribute("id","datosCampos" );
      ((Element)v.get(468)).setAttribute("size","1" );
      ((Element)v.get(468)).setAttribute("multiple","N" );
      ((Element)v.get(468)).setAttribute("req","N" );
      ((Element)v.get(468)).setAttribute("valorinicial","" );
      ((Element)v.get(468)).setAttribute("textoinicial","" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:470 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).setAttribute("width","100%" );
      ((Element)v.get(450)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).setAttribute("width","8" );
      ((Element)v.get(471)).setAttribute("height","8" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:450   */

      /* Empieza nodo:472 / Elemento padre: 427   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(427)).appendChild((Element)v.get(472));

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
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:475 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","8" );
      ((Element)v.get(476)).setAttribute("height","12" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:417   */

      /* Empieza nodo:477 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("table"));
      ((Element)v.get(482)).setAttribute("width","100%" );
      ((Element)v.get(482)).setAttribute("border","0" );
      ((Element)v.get(482)).setAttribute("align","center" );
      ((Element)v.get(482)).setAttribute("cellspacing","0" );
      ((Element)v.get(482)).setAttribute("cellpadding","0" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).setAttribute("class","botonera" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(485)).setAttribute("nombre","btnContinuar5" );
      ((Element)v.get(485)).setAttribute("ontab","focaliza('frmAtributos.textNUnidClienteRepartir','');" );
      ((Element)v.get(485)).setAttribute("ID","botonContenido" );
      ((Element)v.get(485)).setAttribute("tipo","html" );
      ((Element)v.get(485)).setAttribute("accion","continuar();" );
      ((Element)v.get(485)).setAttribute("estado","false" );
      ((Element)v.get(485)).setAttribute("cod","2247" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:486 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","8" );
      ((Element)v.get(487)).setAttribute("height","12" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:477   */

      /* Empieza nodo:488 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).setAttribute("width","12" );
      ((Element)v.get(489)).setAttribute("align","center" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(490)).setAttribute("src","b.gif" );
      ((Element)v.get(490)).setAttribute("width","12" );
      ((Element)v.get(490)).setAttribute("height","12" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 488   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(491)).setAttribute("width","750" );
      ((Element)v.get(488)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(492)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).setAttribute("width","12" );
      ((Element)v.get(488)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","12" );
      ((Element)v.get(494)).setAttribute("height","12" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:488   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:495 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(495)).setAttribute("nombre","capaPedidoSuperaMontoNegocio" );
      ((Element)v.get(495)).setAttribute("alto","120" );
      ((Element)v.get(495)).setAttribute("ancho","100%" );
      ((Element)v.get(495)).setAttribute("x","0" );
      ((Element)v.get(495)).setAttribute("y","105" );
      ((Element)v.get(495)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(24)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("table"));
      ((Element)v.get(496)).setAttribute("width","100%" );
      ((Element)v.get(496)).setAttribute("border","0" );
      ((Element)v.get(496)).setAttribute("cellspacing","0" );
      ((Element)v.get(496)).setAttribute("cellpadding","0" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(498)).setAttribute("width","12" );
      ((Element)v.get(498)).setAttribute("align","center" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","12" );
      ((Element)v.get(499)).setAttribute("height","12" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).setAttribute("width","750" );
      ((Element)v.get(497)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).setAttribute("width","10" );
      ((Element)v.get(497)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","12" );
      ((Element)v.get(503)).setAttribute("height","1" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */
      /* Termina nodo:497   */

      /* Empieza nodo:504 / Elemento padre: 496   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(496)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:507 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(509)).setAttribute("class","legend" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(510)).setAttribute("nombre","lblPedidoSuperaMontoNegocio" );
      ((Element)v.get(510)).setAttribute("alto","13" );
      ((Element)v.get(510)).setAttribute("filas","1" );
      ((Element)v.get(510)).setAttribute("cod","00529" );
      ((Element)v.get(510)).setAttribute("id","legend" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:511 / Elemento padre: 508   */
      v.add(doc.createElement("table"));
      ((Element)v.get(511)).setAttribute("width","100%" );
      ((Element)v.get(511)).setAttribute("border","0" );
      ((Element)v.get(511)).setAttribute("align","center" );
      ((Element)v.get(511)).setAttribute("cellspacing","0" );
      ((Element)v.get(511)).setAttribute("cellpadding","0" );
      ((Element)v.get(508)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("table"));
      ((Element)v.get(514)).setAttribute("width","634" );
      ((Element)v.get(514)).setAttribute("border","0" );
      ((Element)v.get(514)).setAttribute("align","left" );
      ((Element)v.get(514)).setAttribute("cellspacing","0" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(514)).setAttribute("cellpadding","0" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).setAttribute("colspan","4" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","8" );
      ((Element)v.get(517)).setAttribute("height","8" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:518 / Elemento padre: 514   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(514)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(520)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).setAttribute("width","8" );
      ((Element)v.get(520)).setAttribute("height","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:521 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(522)).setAttribute("nombre","lblMonto4" );
      ((Element)v.get(522)).setAttribute("alto","13" );
      ((Element)v.get(522)).setAttribute("filas","1" );
      ((Element)v.get(522)).setAttribute("valor","" );
      ((Element)v.get(522)).setAttribute("id","datosTitle" );
      ((Element)v.get(522)).setAttribute("cod","917" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:523 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","b.gif" );
      ((Element)v.get(524)).setAttribute("width","25" );
      ((Element)v.get(524)).setAttribute("height","8" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:525 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(526)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(526)).setAttribute("alto","13" );
      ((Element)v.get(526)).setAttribute("filas","1" );
      ((Element)v.get(526)).setAttribute("valor","" );
      ((Element)v.get(526)).setAttribute("id","datosTitle" );
      ((Element)v.get(526)).setAttribute("cod","588" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:527 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(528)).setAttribute("src","b.gif" );
      ((Element)v.get(528)).setAttribute("width","25" );
      ((Element)v.get(528)).setAttribute("height","8" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(530)).setAttribute("nombre","lblPeriodoDesde4" );
      ((Element)v.get(530)).setAttribute("alto","13" );
      ((Element)v.get(530)).setAttribute("filas","1" );
      ((Element)v.get(530)).setAttribute("valor","" );
      ((Element)v.get(530)).setAttribute("id","datosTitle" );
      ((Element)v.get(530)).setAttribute("cod","1175" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","25" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(534)).setAttribute("nombre","lblPeriodoHasta4" );
      ((Element)v.get(534)).setAttribute("alto","13" );
      ((Element)v.get(534)).setAttribute("filas","1" );
      ((Element)v.get(534)).setAttribute("valor","" );
      ((Element)v.get(534)).setAttribute("id","datosTitle" );
      ((Element)v.get(534)).setAttribute("cod","1176" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).setAttribute("width","100%" );
      ((Element)v.get(518)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","8" );
      ((Element)v.get(536)).setAttribute("height","8" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */
      /* Termina nodo:518   */

      /* Empieza nodo:537 / Elemento padre: 514   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(514)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","8" );
      ((Element)v.get(539)).setAttribute("height","8" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(537)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(541)).setAttribute("nombre","textMonto4" );
      ((Element)v.get(541)).setAttribute("id","datosCampos" );
      ((Element)v.get(541)).setAttribute("max","18" );
      ((Element)v.get(541)).setAttribute("tipo","" );
      ((Element)v.get(541)).setAttribute("onchange","" );
      ((Element)v.get(541)).setAttribute("req","N" );
      ((Element)v.get(541)).setAttribute("size","18" );
      ((Element)v.get(541)).setAttribute("valor","" );
      ((Element)v.get(541)).setAttribute("validacion","" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(537)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","25" );
      ((Element)v.get(543)).setAttribute("height","8" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(537)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(545)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(545)).setAttribute("id","datosCampos" );
      ((Element)v.get(545)).setAttribute("size","1" );
      ((Element)v.get(545)).setAttribute("multiple","N" );
      ((Element)v.get(545)).setAttribute("req","N" );
      ((Element)v.get(545)).setAttribute("valorinicial","" );
      ((Element)v.get(545)).setAttribute("textoinicial","" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:547 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(537)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(548)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).setAttribute("width","25" );
      ((Element)v.get(548)).setAttribute("height","8" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(537)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(550)).setAttribute("nombre","cbPeriodoDesde4" );
      ((Element)v.get(550)).setAttribute("id","datosCampos" );
      ((Element)v.get(550)).setAttribute("size","1" );
      ((Element)v.get(550)).setAttribute("multiple","N" );
      ((Element)v.get(550)).setAttribute("req","N" );
      ((Element)v.get(550)).setAttribute("valorinicial","" );
      ((Element)v.get(550)).setAttribute("textoinicial","" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:552 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(537)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(553)).setAttribute("src","b.gif" );
      ((Element)v.get(553)).setAttribute("width","25" );
      ((Element)v.get(553)).setAttribute("height","8" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:554 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(554)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(537)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(555)).setAttribute("nombre","cbPeriodoHasta4" );
      ((Element)v.get(555)).setAttribute("id","datosCampos" );
      ((Element)v.get(555)).setAttribute("size","1" );
      ((Element)v.get(555)).setAttribute("multiple","N" );
      ((Element)v.get(555)).setAttribute("req","N" );
      ((Element)v.get(555)).setAttribute("valorinicial","" );
      ((Element)v.get(555)).setAttribute("textoinicial","" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:557 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(557)).setAttribute("width","100%" );
      ((Element)v.get(537)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(558)).setAttribute("src","b.gif" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(558)).setAttribute("width","8" );
      ((Element)v.get(558)).setAttribute("height","8" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:557   */
      /* Termina nodo:537   */

      /* Empieza nodo:559 / Elemento padre: 514   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(514)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).setAttribute("colspan","4" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(561)).setAttribute("src","b.gif" );
      ((Element)v.get(561)).setAttribute("width","8" );
      ((Element)v.get(561)).setAttribute("height","8" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:562 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(563)).setAttribute("src","b.gif" );
      ((Element)v.get(563)).setAttribute("width","8" );
      ((Element)v.get(563)).setAttribute("height","12" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */
      /* Termina nodo:504   */

      /* Empieza nodo:564 / Elemento padre: 496   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(496)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("td"));
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 564   */
      v.add(doc.createElement("td"));
      ((Element)v.get(564)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(567)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("table"));
      ((Element)v.get(569)).setAttribute("width","100%" );
      ((Element)v.get(569)).setAttribute("border","0" );
      ((Element)v.get(569)).setAttribute("align","center" );
      ((Element)v.get(569)).setAttribute("cellspacing","0" );
      ((Element)v.get(569)).setAttribute("cellpadding","0" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).setAttribute("class","botonera" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(572)).setAttribute("nombre","btnContinuar6" );
      ((Element)v.get(572)).setAttribute("ontab","focaliza('frmAtributos.textNUnidClienteRepartir','');" );
      ((Element)v.get(572)).setAttribute("ID","botonContenido" );
      ((Element)v.get(572)).setAttribute("tipo","html" );
      ((Element)v.get(572)).setAttribute("accion","continuar();" );
      ((Element)v.get(572)).setAttribute("estado","false" );
      ((Element)v.get(572)).setAttribute("cod","2247" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:568   */
      /* Termina nodo:567   */

      /* Empieza nodo:573 / Elemento padre: 564   */
      v.add(doc.createElement("td"));
      ((Element)v.get(564)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(574)).setAttribute("src","b.gif" );
      ((Element)v.get(574)).setAttribute("width","8" );
      ((Element)v.get(574)).setAttribute("height","12" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */
      /* Termina nodo:564   */

      /* Empieza nodo:575 / Elemento padre: 496   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(496)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).setAttribute("width","12" );
      ((Element)v.get(576)).setAttribute("align","center" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","12" );
      ((Element)v.get(577)).setAttribute("height","12" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 575   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).setAttribute("width","750" );
      ((Element)v.get(575)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 575   */
      v.add(doc.createElement("td"));
      ((Element)v.get(580)).setAttribute("width","12" );
      ((Element)v.get(575)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("width","12" );
      ((Element)v.get(581)).setAttribute("height","12" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:575   */
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:582 / Elemento padre: 24   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(582)).setAttribute("nombre","capaPedidoSuperaMontoCatalogo" );
      ((Element)v.get(582)).setAttribute("alto","120" );
      ((Element)v.get(582)).setAttribute("ancho","100%" );
      ((Element)v.get(582)).setAttribute("x","0" );
      ((Element)v.get(582)).setAttribute("y","105" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(582)).setAttribute("visibilidad","" );
      ((Element)v.get(24)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("table"));
      ((Element)v.get(583)).setAttribute("width","100%" );
      ((Element)v.get(583)).setAttribute("border","0" );
      ((Element)v.get(583)).setAttribute("cellspacing","0" );
      ((Element)v.get(583)).setAttribute("cellpadding","0" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).setAttribute("width","12" );
      ((Element)v.get(585)).setAttribute("align","center" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(586)).setAttribute("src","b.gif" );
      ((Element)v.get(586)).setAttribute("width","12" );
      ((Element)v.get(586)).setAttribute("height","12" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(587)).setAttribute("width","750" );
      ((Element)v.get(584)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */

      /* Empieza nodo:589 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(589)).setAttribute("width","12" );
      ((Element)v.get(584)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(590)).setAttribute("src","b.gif" );
      ((Element)v.get(590)).setAttribute("width","12" );
      ((Element)v.get(590)).setAttribute("height","1" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */
      /* Termina nodo:584   */

      /* Empieza nodo:591 / Elemento padre: 583   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(583)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:594 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(596)).setAttribute("class","legend" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(597)).setAttribute("nombre","lblPedidoSuperaMontoCatalogo" );
      ((Element)v.get(597)).setAttribute("alto","13" );
      ((Element)v.get(597)).setAttribute("filas","1" );
      ((Element)v.get(597)).setAttribute("cod","00530" );
      ((Element)v.get(597)).setAttribute("id","legend" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 595   */
      v.add(doc.createElement("table"));
      ((Element)v.get(598)).setAttribute("width","100%" );
      ((Element)v.get(598)).setAttribute("border","0" );
      ((Element)v.get(598)).setAttribute("align","center" );
      ((Element)v.get(598)).setAttribute("cellspacing","0" );
      ((Element)v.get(598)).setAttribute("cellpadding","0" );
      ((Element)v.get(595)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(599)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("table"));
      ((Element)v.get(601)).setAttribute("width","634" );
      ((Element)v.get(601)).setAttribute("border","0" );
      ((Element)v.get(601)).setAttribute("align","left" );
      ((Element)v.get(601)).setAttribute("cellspacing","0" );
      ((Element)v.get(601)).setAttribute("cellpadding","0" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(603)).setAttribute("colspan","4" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("width","8" );
      ((Element)v.get(604)).setAttribute("height","8" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:605 / Elemento padre: 601   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(601)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).setAttribute("width","8" );
      ((Element)v.get(607)).setAttribute("height","8" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:608 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(609)).setAttribute("nombre","lblMonto5" );
      ((Element)v.get(609)).setAttribute("alto","13" );
      ((Element)v.get(609)).setAttribute("filas","1" );
      ((Element)v.get(609)).setAttribute("valor","" );
      ((Element)v.get(609)).setAttribute("id","datosTitle" );
      ((Element)v.get(609)).setAttribute("cod","917" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:610 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(611)).setAttribute("src","b.gif" );
      ((Element)v.get(611)).setAttribute("width","25" );
      ((Element)v.get(611)).setAttribute("height","8" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:612 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(613)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(613)).setAttribute("alto","13" );
      ((Element)v.get(613)).setAttribute("filas","1" );
      ((Element)v.get(613)).setAttribute("valor","" );
      ((Element)v.get(613)).setAttribute("id","datosTitle" );
      ((Element)v.get(613)).setAttribute("cod","516" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:614 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(615)).setAttribute("src","b.gif" );
      ((Element)v.get(615)).setAttribute("width","25" );
      ((Element)v.get(615)).setAttribute("height","8" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:616 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(617)).setAttribute("nombre","lblPeriodoDesde5" );
      ((Element)v.get(617)).setAttribute("alto","13" );
      ((Element)v.get(617)).setAttribute("filas","1" );
      ((Element)v.get(617)).setAttribute("valor","" );
      ((Element)v.get(617)).setAttribute("id","datosTitle" );
      ((Element)v.get(617)).setAttribute("cod","1175" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:618 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(619)).setAttribute("src","b.gif" );
      ((Element)v.get(619)).setAttribute("width","25" );
      ((Element)v.get(619)).setAttribute("height","8" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */

      /* Empieza nodo:620 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(621)).setAttribute("nombre","lblPeriodoHasta5" );
      ((Element)v.get(621)).setAttribute("alto","13" );
      ((Element)v.get(621)).setAttribute("filas","1" );
      ((Element)v.get(621)).setAttribute("valor","" );
      ((Element)v.get(621)).setAttribute("id","datosTitle" );
      ((Element)v.get(621)).setAttribute("cod","1176" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */

      /* Empieza nodo:622 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).setAttribute("width","100%" );
      ((Element)v.get(605)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(623)).setAttribute("src","b.gif" );
      ((Element)v.get(623)).setAttribute("width","8" );
      ((Element)v.get(623)).setAttribute("height","8" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:605   */

      /* Empieza nodo:624 / Elemento padre: 601   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(601)).appendChild((Element)v.get(624));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(628)).setAttribute("nombre","textMonto5" );
      ((Element)v.get(628)).setAttribute("id","datosCampos" );
      ((Element)v.get(628)).setAttribute("max","18" );
      ((Element)v.get(628)).setAttribute("tipo","" );
      ((Element)v.get(628)).setAttribute("onchange","" );
      ((Element)v.get(628)).setAttribute("req","N" );
      ((Element)v.get(628)).setAttribute("size","18" );
      ((Element)v.get(628)).setAttribute("valor","" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(628)).setAttribute("validacion","" );
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
      ((Element)v.get(631)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(624)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(632)).setAttribute("nombre","cbCatalogo" );
      ((Element)v.get(632)).setAttribute("id","datosCampos" );
      ((Element)v.get(632)).setAttribute("size","1" );
      ((Element)v.get(632)).setAttribute("multiple","N" );
      ((Element)v.get(632)).setAttribute("req","N" );
      ((Element)v.get(632)).setAttribute("valorinicial","" );
      ((Element)v.get(632)).setAttribute("textoinicial","" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:634 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(635)).setAttribute("src","b.gif" );
      ((Element)v.get(635)).setAttribute("width","25" );
      ((Element)v.get(635)).setAttribute("height","8" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */

      /* Empieza nodo:636 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(636)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(624)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(637)).setAttribute("nombre","cbPeriodoDesde5" );
      ((Element)v.get(637)).setAttribute("id","datosCampos" );
      ((Element)v.get(637)).setAttribute("size","1" );
      ((Element)v.get(637)).setAttribute("multiple","N" );
      ((Element)v.get(637)).setAttribute("req","N" );
      ((Element)v.get(637)).setAttribute("valorinicial","" );
      ((Element)v.get(637)).setAttribute("textoinicial","" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:639 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(640)).setAttribute("src","b.gif" );
      ((Element)v.get(640)).setAttribute("width","25" );
      ((Element)v.get(640)).setAttribute("height","8" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */

      /* Empieza nodo:641 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(624)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(642)).setAttribute("nombre","cbPeriodoHasta5" );
      ((Element)v.get(642)).setAttribute("id","datosCampos" );
      ((Element)v.get(642)).setAttribute("size","1" );
      ((Element)v.get(642)).setAttribute("multiple","N" );
      ((Element)v.get(642)).setAttribute("req","N" );
      ((Element)v.get(642)).setAttribute("valorinicial","" );
      ((Element)v.get(642)).setAttribute("textoinicial","" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */
      /* Termina nodo:641   */

      /* Empieza nodo:644 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).setAttribute("width","100%" );
      ((Element)v.get(624)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(645)).setAttribute("src","b.gif" );
      ((Element)v.get(645)).setAttribute("width","8" );
      ((Element)v.get(645)).setAttribute("height","8" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:644   */
      /* Termina nodo:624   */

      /* Empieza nodo:646 / Elemento padre: 601   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(601)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("td"));
      ((Element)v.get(647)).setAttribute("colspan","4" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(648)).setAttribute("src","b.gif" );
      ((Element)v.get(648)).setAttribute("width","8" );
      ((Element)v.get(648)).setAttribute("height","8" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:647   */
      /* Termina nodo:646   */
      /* Termina nodo:601   */
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:598   */
      /* Termina nodo:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:649 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(650)).setAttribute("src","b.gif" );
      ((Element)v.get(650)).setAttribute("width","8" );
      ((Element)v.get(650)).setAttribute("height","12" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */
      /* Termina nodo:649   */
      /* Termina nodo:591   */

      /* Empieza nodo:651 / Elemento padre: 583   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(583)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("td"));
      ((Element)v.get(651)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(653)).setAttribute("src","b.gif" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:652   */

      /* Empieza nodo:654 / Elemento padre: 651   */
      v.add(doc.createElement("td"));
      ((Element)v.get(651)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(654)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("table"));
      ((Element)v.get(656)).setAttribute("width","100%" );
      ((Element)v.get(656)).setAttribute("border","0" );
      ((Element)v.get(656)).setAttribute("align","center" );
      ((Element)v.get(656)).setAttribute("cellspacing","0" );
      ((Element)v.get(656)).setAttribute("cellpadding","0" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(656)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("td"));
      ((Element)v.get(658)).setAttribute("class","botonera" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(659)).setAttribute("nombre","btnContinuar7" );
      ((Element)v.get(659)).setAttribute("ontab","focaliza('frmAtributos.textNUnidClienteRepartir','');" );
      ((Element)v.get(659)).setAttribute("ID","botonContenido" );
      ((Element)v.get(659)).setAttribute("tipo","html" );
      ((Element)v.get(659)).setAttribute("accion","continuar();" );
      ((Element)v.get(659)).setAttribute("estado","false" );
      ((Element)v.get(659)).setAttribute("cod","2247" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:658   */
      /* Termina nodo:657   */
      /* Termina nodo:656   */
      /* Termina nodo:655   */
      /* Termina nodo:654   */

      /* Empieza nodo:660 / Elemento padre: 651   */
      v.add(doc.createElement("td"));
      ((Element)v.get(651)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(661)).setAttribute("src","b.gif" );
      ((Element)v.get(661)).setAttribute("width","8" );
      ((Element)v.get(661)).setAttribute("height","12" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */
      /* Termina nodo:660   */
      /* Termina nodo:651   */

      /* Empieza nodo:662 / Elemento padre: 583   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(583)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("td"));
      ((Element)v.get(663)).setAttribute("width","12" );
      ((Element)v.get(663)).setAttribute("align","center" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(664)).setAttribute("src","b.gif" );
      ((Element)v.get(664)).setAttribute("width","12" );
      ((Element)v.get(664)).setAttribute("height","12" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:663   */

      /* Empieza nodo:665 / Elemento padre: 662   */
      v.add(doc.createElement("td"));
      ((Element)v.get(665)).setAttribute("width","750" );
      ((Element)v.get(662)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(666)).setAttribute("src","b.gif" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */
      /* Termina nodo:665   */

      /* Empieza nodo:667 / Elemento padre: 662   */
      v.add(doc.createElement("td"));
      ((Element)v.get(667)).setAttribute("width","12" );
      ((Element)v.get(662)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(668)).setAttribute("src","b.gif" );
      ((Element)v.get(668)).setAttribute("width","12" );
      ((Element)v.get(668)).setAttribute("height","12" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:667   */
      /* Termina nodo:662   */
      /* Termina nodo:583   */
      /* Termina nodo:582   */
      /* Termina nodo:24   */


   }

}
