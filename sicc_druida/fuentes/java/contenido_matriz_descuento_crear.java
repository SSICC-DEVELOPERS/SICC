
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_descuento_crear  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML3870(doc);
         

      getXML3960(doc);
         

      getXML4050(doc);
         

      getXML4140(doc);
         

      getXML4230(doc);
         

      getXML4320(doc);
         

      getXML4410(doc);
         

      getXML4500(doc);
         

      getXML4590(doc);
         

      getXML4680(doc);
         

      getXML4770(doc);
         

      getXML4860(doc);
         

      getXML4950(doc);
         

      getXML5040(doc);
         

      getXML5130(doc);
         

      getXML5220(doc);
         

      getXML5310(doc);
         
      MgetXML0 (doc);
            
            return (Element)v.get(0);
            
}
   private void MgetXML0 (Document doc) {
            

      getXML5400(doc);
         

      getXML5490(doc);
         

      getXML5580(doc);
         

      getXML5670(doc);
         

      getXML5760(doc);
         

      getXML5850(doc);
         

      getXML5940(doc);
         

      getXML6030(doc);
         

      getXML6120(doc);
         

      getXML6210(doc);
         

      getXML6300(doc);
         

      getXML6390(doc);
         

      getXML6480(doc);
         

      getXML6570(doc);
         

      getXML6660(doc);
         

      getXML6750(doc);
         

      getXML6840(doc);
         

      getXML6930(doc);
         

      getXML7020(doc);
         

      getXML7110(doc);
         

      getXML7200(doc);
         

      getXML7290(doc);
         

      getXML7380(doc);
         

      getXML7470(doc);
         

      getXML7560(doc);
         

      getXML7650(doc);
         

      getXML7740(doc);
         

      getXML7830(doc);
         

      getXML7920(doc);
         

      getXML8010(doc);
         

      getXML8100(doc);
         

      getXML8190(doc);
         

      getXML8280(doc);
         

      getXML8370(doc);
         

      getXML8460(doc);
         

      getXML8550(doc);
         

      getXML8640(doc);
         

      getXML8730(doc);
         

      getXML8820(doc);
         

      getXML8910(doc);
         

      getXML9000(doc);
         

      getXML9090(doc);
         

      getXML9180(doc);
         

      getXML9270(doc);
         

      getXML9360(doc);
         

      getXML9450(doc);
         

      getXML9540(doc);
         

      getXML9630(doc);
         

      getXML9720(doc);
         

      getXML9810(doc);
         

      getXML9900(doc);
         

      getXML9990(doc);
         
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_descuento_crear" );
      ((Element)v.get(0)).setAttribute("cod","0247" );
      ((Element)v.get(0)).setAttribute("titulo","Crear Matriz de descuento" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPage();" );
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
      ((Element)v.get(3)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_matriz_descuento_crear.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtDescripcion" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","9" );
      ((Element)v.get(6)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","rbMatrizActiva" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","912" );
      ((Element)v.get(7)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbValoresPosiblesMarca" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1022" );
      ((Element)v.get(8)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbValoresPosiblesCanal" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1022" );
      ((Element)v.get(9)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbValoresPosiblesTipoCliente" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1301" );
      ((Element)v.get(10)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbValoresPosiblesSubtipoCliente" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","595" );
      ((Element)v.get(11)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbValoresPosiblesAlcanceAdministrativoDescuento" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1022" );
      ((Element)v.get(12)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbValoresPosiblesControlMorosidad" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1022" );
      ((Element)v.get(13)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbValoresPosiblesControlDevolucionesAnulaciones" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","1022" );
      ((Element)v.get(14)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbValoresPosiblesControlDescuentoAcumulativo" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","1022" );
      ((Element)v.get(15)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbValoresPosiblesAfectaFacturas" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","1022" );
      ((Element)v.get(16)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","cbValoresPosiblesAfectaCuentaCorriente" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","1022" );
      ((Element)v.get(17)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","cbValoresPosiblesComunicacionParticipantes" );
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("cod","1022" );
      ((Element)v.get(18)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","cbValoresPosiblesIndicadorCulminacion" );
      ((Element)v.get(19)).setAttribute("required","true" );
      ((Element)v.get(19)).setAttribute("cod","1022" );
      ((Element)v.get(19)).setAttribute("group","grupo1" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","cbValoresPosiblesAcceso" );
      ((Element)v.get(20)).setAttribute("required","true" );
      ((Element)v.get(20)).setAttribute("cod","1022" );
      ((Element)v.get(20)).setAttribute("group","grupo2" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbValoresPosiblesSubacceso" );
      ((Element)v.get(21)).setAttribute("required","true" );
      ((Element)v.get(21)).setAttribute("cod","1022" );
      ((Element)v.get(21)).setAttribute("group","grupo3" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","cbValoresPosiblesTipoClasificacion" );
      ((Element)v.get(22)).setAttribute("required","true" );
      ((Element)v.get(22)).setAttribute("cod","756" );
      ((Element)v.get(22)).setAttribute("group","grupo4" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","cbValoresPosiblesClasificacion" );
      ((Element)v.get(23)).setAttribute("required","true" );
      ((Element)v.get(23)).setAttribute("cod","611" );
      ((Element)v.get(23)).setAttribute("group","grupo5" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","txtNumMaxValoresAcceso" );
      ((Element)v.get(24)).setAttribute("required","false" );
      ((Element)v.get(24)).setAttribute("cod","937" );
      ((Element)v.get(24)).setAttribute("format","t" );
      ((Element)v.get(24)).setAttribute("chars","0-9" );
      ((Element)v.get(24)).setAttribute("group","grupo6" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","txtNumMaxSubacceso" );
      ((Element)v.get(25)).setAttribute("required","false" );
      ((Element)v.get(25)).setAttribute("cod","937" );
      ((Element)v.get(25)).setAttribute("format","t" );
      ((Element)v.get(25)).setAttribute("chars","0-9" );
      ((Element)v.get(25)).setAttribute("group","grupo6" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","txtNumMaxTipoCliente" );
      ((Element)v.get(26)).setAttribute("required","false" );
      ((Element)v.get(26)).setAttribute("cod","937" );
      ((Element)v.get(26)).setAttribute("format","t" );
      ((Element)v.get(26)).setAttribute("chars","0-9" );
      ((Element)v.get(26)).setAttribute("group","grupo6" );
      ((Element)v.get(5)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(27)).setAttribute("name","atxtObservaciones" );
      ((Element)v.get(27)).setAttribute("required","false" );
      ((Element)v.get(27)).setAttribute("cod","169" );
      ((Element)v.get(27)).setAttribute("format","t" );
      ((Element)v.get(27)).setAttribute("max","100" );
      ((Element)v.get(27)).setAttribute("group","camposOpcionales" );
      ((Element)v.get(5)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:5   */

      /* Empieza nodo:28 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(28)).setAttribute("nombre","formulario" );
      ((Element)v.get(28)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","accion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 28   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","oidCabecera" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","accesoOid" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","accesoDesc" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","accesoOidPadre" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","SubtipoClienteOid" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","SubtipoClienteDesc" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","SubtipoClienteOidPadre" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","TipoClasificacionOid" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","TipoClasificacionDesc" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","TipoClasificacionOidPadre" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","SubaccesoOid" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","SubaccesoDesc" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","SubaccesoOidPadre" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","ClasificacionOid" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","ClasificacionDesc" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","ClasificacionOidPadre" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","selMarca" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","selCanal" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","selAcceso" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","selSubacceso" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","selTipoCliente" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","selSubtipoCliente" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","selTipoClasificacion" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","selClasificacion" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","selAlcanceAdministrativoDescuento" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","selControlMorosidad" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","selControlDevolucionesAnulaciones" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","selControlDescuentoAcumulativo" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","selAfectaFacturas" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","selAfectaCuentaCorriente" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","selComunicacionParticipantes" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","selIndicadorCulminacion" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","radio" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","exito" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","parametros" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidOidMatriz" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidDesc" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidMat" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","varNoLimpiarSICC" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","oidDetalle" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","dMarca" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","dCanal" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","dAcceso" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 28   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","dSubcceso" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","dTiposClientes" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","dSubtiposClientes" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","dTiposClasificacion" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","dClasificacion" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","dAlcance" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","dControlMorosidad" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","dControlDA" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","dControlDesc" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","dAfectaFactura" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","dAfectaCC" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","dComunicacion" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","dIndicadorCulminacion" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","vdAlcanceAdministrativoDescuento" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","vdControlMorosidad" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","vdControlDevolucionesAnulaciones" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","vdControlDescuentoAcumulativo" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","vdAfectaFacturas" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","vdAfectaCuentaCorriente" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","vdComunicacionParticipantes" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 28   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","vdIndicadorCulminacion" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(28)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 28   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(98)).setAttribute("nombre","capa1" );
      ((Element)v.get(98)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(28)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","100%" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","12" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","750" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("height","1" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:100   */

      /* Empieza nodo:107 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(112)).setAttribute("class","legend" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblMatrizDescuentos" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(113)).setAttribute("id","legend" );
      ((Element)v.get(113)).setAttribute("cod","0085" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("colspan","4" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("colspan","3" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("id","datosTitle" );
      ((Element)v.get(122)).setAttribute("cod","9" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblMatrizActiva" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("id","datosTitle" );
      ((Element)v.get(126)).setAttribute("cod","912" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(118)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:118   */

      /* Empieza nodo:129 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(133)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("onshtab","foco(2);" );
      ((Element)v.get(133)).setAttribute("max","40" );
      ((Element)v.get(133)).setAttribute("tipo","" );
      ((Element)v.get(133)).setAttribute("onchange","" );
      ((Element)v.get(133)).setAttribute("req","S" );
      ((Element)v.get(133)).setAttribute("size","40" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("validacion","" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(137)).setAttribute("width","21" );
      ((Element)v.get(137)).setAttribute("height","15" );
      ((Element)v.get(137)).setAttribute("onclick","levantarI18N('formulario', '1');" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).setAttribute("class","datosCampos" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(144)).setAttribute("nombre","rbMatrizActiva" );
      ((Element)v.get(144)).setAttribute("tipo","H" );
      ((Element)v.get(144)).setAttribute("id","datosCampos" );
      ((Element)v.get(144)).setAttribute("req","S" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(145)).setAttribute("valor","S" );
      ((Element)v.get(145)).setAttribute("check","N" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(145)).setAttribute("onfocus","" );
      ((Element)v.get(145)).setAttribute("id","datosCampos" );
      ((Element)v.get(145)).setAttribute("cod","117" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Elemento padre:145 / Elemento actual: 146   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(145)).appendChild((Text)v.get(146));

      /* Termina nodo Texto:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(147)).setAttribute("valor","N" );
      ((Element)v.get(147)).setAttribute("check","N" );
      ((Element)v.get(147)).setAttribute("onfocus","" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("cod","87" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Elemento padre:147 / Elemento actual: 148   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(147)).appendChild((Text)v.get(148));

      /* Termina nodo Texto:148   */
      /* Termina nodo:147   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:149 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(129)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:129   */

      /* Empieza nodo:151 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("colspan","4" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:114   */

      /* Empieza nodo:154 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(154)).setAttribute("border","0" );
      ((Element)v.get(154)).setAttribute("align","center" );
      ((Element)v.get(154)).setAttribute("cellspacing","0" );
      ((Element)v.get(154)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

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
      ((Element)v.get(159)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(159)).setAttribute("alto","13" );
      ((Element)v.get(159)).setAttribute("filas","1" );
      ((Element)v.get(159)).setAttribute("id","datosTitle" );
      ((Element)v.get(159)).setAttribute("cod","169" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(155)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:155   */

      /* Empieza nodo:162 / Elemento padre: 154   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(154)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(166)).setAttribute("cols","50" );
      ((Element)v.get(166)).setAttribute("id","datosCampos" );
      ((Element)v.get(166)).setAttribute("msjreq","" );
      ((Element)v.get(166)).setAttribute("nombre","atxtObservaciones" );
      ((Element)v.get(166)).setAttribute("readonly","N" );
      ((Element)v.get(166)).setAttribute("req","N" );
      ((Element)v.get(166)).setAttribute("rows","3" );
      ((Element)v.get(166)).setAttribute("tabindex","2" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("max","100" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 162   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","100%" );
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:162   */

      /* Empieza nodo:169 / Elemento padre: 154   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(154)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("colspan","4" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:154   */

      /* Empieza nodo:172 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(172)).setAttribute("border","0" );
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(172)).setAttribute("cellspacing","0" );
      ((Element)v.get(172)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(178)).setAttribute("class","legend" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","legend" );
      ((Element)v.get(179)).setAttribute("cod","0069" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("table"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(180)).setAttribute("border","0" );
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(180)).setAttribute("cellspacing","0" );
      ((Element)v.get(180)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("colspan","3" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:184 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblCodigoMarca" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblVisibleMarca" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","1038" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","lblObligatorioMarca" );
      ((Element)v.get(196)).setAttribute("alto","13" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("valor","" );
      ((Element)v.get(196)).setAttribute("id","datosTitle" );
      ((Element)v.get(196)).setAttribute("cod","949" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","25" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(200)).setAttribute("nombre","lblModificableMarca" );
      ((Element)v.get(200)).setAttribute("alto","13" );
      ((Element)v.get(200)).setAttribute("filas","1" );
      ((Element)v.get(200)).setAttribute("valor","" );
      ((Element)v.get(200)).setAttribute("id","datosTitle" );
      ((Element)v.get(200)).setAttribute("cod","914" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","100%" );
      ((Element)v.get(184)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:184   */

      /* Empieza nodo:203 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(207)).setAttribute("nombre","lbldtCodigoMarca" );
      ((Element)v.get(207)).setAttribute("alto","13" );
      ((Element)v.get(207)).setAttribute("filas","1" );
      ((Element)v.get(207)).setAttribute("valor","03" );
      ((Element)v.get(207)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","25" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(211)).setAttribute("nombre","ckVisibleMarca" );
      ((Element)v.get(211)).setAttribute("id","datosCampos" );
      ((Element)v.get(211)).setAttribute("onclick","cambiaObli(1)" );
      ((Element)v.get(211)).setAttribute("check","S" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","25" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(215)).setAttribute("nombre","ckObligatorioMarca" );
      ((Element)v.get(215)).setAttribute("id","datosCampos" );
      ((Element)v.get(215)).setAttribute("onclick","" );
      ((Element)v.get(215)).setAttribute("check","S" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","25" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(219)).setAttribute("nombre","ckModificableMarca" );
      ((Element)v.get(219)).setAttribute("id","datosCampos" );
      ((Element)v.get(219)).setAttribute("onclick","" );
      ((Element)v.get(219)).setAttribute("check","S" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(203)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:203   */

      /* Empieza nodo:222 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("colspan","4" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:180   */

      /* Empieza nodo:225 / Elemento padre: 177   */
      v.add(doc.createElement("table"));
      ((Element)v.get(225)).setAttribute("width","100%" );
      ((Element)v.get(225)).setAttribute("border","0" );
      ((Element)v.get(225)).setAttribute("align","center" );
      ((Element)v.get(225)).setAttribute("cellspacing","0" );
      ((Element)v.get(225)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

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
      ((Element)v.get(230)).setAttribute("nombre","lblValoresPosiblesMarca" );
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("id","datosTitle" );
      ((Element)v.get(230)).setAttribute("cod","1022" );
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
      ((Element)v.get(234)).setAttribute("nombre","lblValoresDefectoMarca" );
      ((Element)v.get(234)).setAttribute("alto","13" );
      ((Element)v.get(234)).setAttribute("filas","1" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(234)).setAttribute("id","datosTitle" );
      ((Element)v.get(234)).setAttribute("cod","1286" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(226)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:226   */

      /* Empieza nodo:237 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(241)).setAttribute("nombre","cbValoresPosiblesMarca" );
      ((Element)v.get(241)).setAttribute("onchange","marcasOnChange();" );
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("size","5" );
      ((Element)v.get(241)).setAttribute("multiple","S" );
      ((Element)v.get(241)).setAttribute("req","S" );
      ((Element)v.get(241)).setAttribute("valorinicial","" );
      ((Element)v.get(241)).setAttribute("textoinicial","" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","25" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(245)).setAttribute("valign","top" );
      ((Element)v.get(237)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(246)).setAttribute("nombre","cbValoresDefectoMarca" );
      ((Element)v.get(246)).setAttribute("id","datosCampos" );
      ((Element)v.get(246)).setAttribute("size","1" );
      ((Element)v.get(246)).setAttribute("multiple","N" );
      ((Element)v.get(246)).setAttribute("req","N" );
      ((Element)v.get(246)).setAttribute("valorinicial","" );
      ((Element)v.get(246)).setAttribute("textoinicial","" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:248 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:237   */

      /* Empieza nodo:250 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("colspan","4" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:225   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:253 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:173   */

      /* Empieza nodo:255 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("width","12" );
      ((Element)v.get(256)).setAttribute("align","center" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","12" );
      ((Element)v.get(257)).setAttribute("height","15" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("width","756" );
      ((Element)v.get(255)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).setAttribute("width","12" );
      ((Element)v.get(255)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","12" );
      ((Element)v.get(261)).setAttribute("height","1" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:255   */
      /* Termina nodo:172   */

      /* Empieza nodo:262 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(262)).setAttribute("border","0" );
      ((Element)v.get(262)).setAttribute("align","center" );
      ((Element)v.get(262)).setAttribute("cellspacing","0" );
      ((Element)v.get(262)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("width","100%" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(268)).setAttribute("class","legend" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(269)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(269)).setAttribute("alto","13" );
      ((Element)v.get(269)).setAttribute("filas","1" );
      ((Element)v.get(269)).setAttribute("valor","" );
      ((Element)v.get(269)).setAttribute("id","legend" );
      ((Element)v.get(269)).setAttribute("cod","00217" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("table"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(270)).setAttribute("border","0" );
      ((Element)v.get(270)).setAttribute("align","center" );
      ((Element)v.get(270)).setAttribute("cellspacing","0" );
      ((Element)v.get(270)).setAttribute("cellpadding","0" );
      ((Element)v.get(267)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("colspan","3" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(273)).setAttribute("height","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:274 / Elemento padre: 270   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(270)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
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
      ((Element)v.get(278)).setAttribute("nombre","lblCodigoCanal" );
      ((Element)v.get(278)).setAttribute("alto","13" );
      ((Element)v.get(278)).setAttribute("filas","1" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(278)).setAttribute("id","datosTitle" );
      ((Element)v.get(278)).setAttribute("cod","8" );
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
      ((Element)v.get(282)).setAttribute("nombre","lblVisibleCanal" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(282)).setAttribute("alto","13" );
      ((Element)v.get(282)).setAttribute("filas","1" );
      ((Element)v.get(282)).setAttribute("valor","" );
      ((Element)v.get(282)).setAttribute("id","datosTitle" );
      ((Element)v.get(282)).setAttribute("cod","1038" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","25" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(286)).setAttribute("nombre","lblObligatorioCanal" );
      ((Element)v.get(286)).setAttribute("alto","13" );
      ((Element)v.get(286)).setAttribute("filas","1" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(286)).setAttribute("id","datosTitle" );
      ((Element)v.get(286)).setAttribute("cod","949" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","25" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(290)).setAttribute("nombre","lblModificableCanal" );
      ((Element)v.get(290)).setAttribute("alto","13" );
      ((Element)v.get(290)).setAttribute("filas","1" );
      ((Element)v.get(290)).setAttribute("valor","" );
      ((Element)v.get(290)).setAttribute("id","datosTitle" );
      ((Element)v.get(290)).setAttribute("cod","914" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("width","100%" );
      ((Element)v.get(274)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:274   */

      /* Empieza nodo:293 / Elemento padre: 270   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(270)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(297)).setAttribute("nombre","lbldtCodigoCanal" );
      ((Element)v.get(297)).setAttribute("alto","13" );
      ((Element)v.get(297)).setAttribute("filas","1" );
      ((Element)v.get(297)).setAttribute("valor","04" );
      ((Element)v.get(297)).setAttribute("id","datosCampos" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","25" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(301)).setAttribute("nombre","ckVisibleCanal" );
      ((Element)v.get(301)).setAttribute("id","datosCampos" );
      ((Element)v.get(301)).setAttribute("onclick","cambiaObli(2)" );
      ((Element)v.get(301)).setAttribute("check","S" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","25" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(305)).setAttribute("nombre","ckObligatorioCanal" );
      ((Element)v.get(305)).setAttribute("id","datosCampos" );
      ((Element)v.get(305)).setAttribute("onclick","" );
      ((Element)v.get(305)).setAttribute("check","S" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","25" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(309)).setAttribute("nombre","ckModificableCanal" );
      ((Element)v.get(309)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).setAttribute("onclick","" );
      ((Element)v.get(309)).setAttribute("check","S" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(293)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:293   */

      /* Empieza nodo:312 / Elemento padre: 270   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(270)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).setAttribute("colspan","4" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","8" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:270   */

      /* Empieza nodo:315 / Elemento padre: 267   */
      v.add(doc.createElement("table"));
      ((Element)v.get(315)).setAttribute("width","100%" );
      ((Element)v.get(315)).setAttribute("border","0" );
      ((Element)v.get(315)).setAttribute("align","center" );
      ((Element)v.get(315)).setAttribute("cellspacing","0" );
      ((Element)v.get(315)).setAttribute("cellpadding","0" );
      ((Element)v.get(267)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(320)).setAttribute("nombre","lblValoresPosiblesCanal" );
      ((Element)v.get(320)).setAttribute("alto","13" );
      ((Element)v.get(320)).setAttribute("filas","1" );
      ((Element)v.get(320)).setAttribute("valor","" );
      ((Element)v.get(320)).setAttribute("id","datosTitle" );
      ((Element)v.get(320)).setAttribute("cod","1022" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","25" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(324)).setAttribute("nombre","lblValoresDefectoCanal" );
      ((Element)v.get(324)).setAttribute("alto","13" );
      ((Element)v.get(324)).setAttribute("filas","1" );
      ((Element)v.get(324)).setAttribute("valor","" );
      ((Element)v.get(324)).setAttribute("id","datosTitle" );
      ((Element)v.get(324)).setAttribute("cod","1286" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("width","100%" );
      ((Element)v.get(316)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:316   */

      /* Empieza nodo:327 / Elemento padre: 315   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(315)).appendChild((Element)v.get(327));

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
      ((Element)v.get(331)).setAttribute("nombre","cbValoresPosiblesCanal" );
      ((Element)v.get(331)).setAttribute("onchange","canalesOnChange();" );
      ((Element)v.get(331)).setAttribute("id","datosCampos" );
      ((Element)v.get(331)).setAttribute("size","5" );
      ((Element)v.get(331)).setAttribute("multiple","S" );
      ((Element)v.get(331)).setAttribute("req","S" );
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
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(335)).setAttribute("valign","top" );
      ((Element)v.get(327)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(336)).setAttribute("nombre","cbValoresDefectoCanal" );
      ((Element)v.get(336)).setAttribute("id","datosCampos" );
      ((Element)v.get(336)).setAttribute("size","1" );
      ((Element)v.get(336)).setAttribute("multiple","N" );
      ((Element)v.get(336)).setAttribute("req","N" );
      ((Element)v.get(336)).setAttribute("valorinicial","" );
      ((Element)v.get(336)).setAttribute("textoinicial","" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:338 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).setAttribute("width","100%" );
      ((Element)v.get(327)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:327   */

      /* Empieza nodo:340 / Elemento padre: 315   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(315)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("colspan","4" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:315   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:343 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:263   */

      /* Empieza nodo:345 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("width","12" );
      ((Element)v.get(346)).setAttribute("align","center" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","12" );
      ((Element)v.get(347)).setAttribute("height","15" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("width","756" );
      ((Element)v.get(345)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("width","12" );
      ((Element)v.get(345)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","12" );
      ((Element)v.get(351)).setAttribute("height","1" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:345   */
      /* Termina nodo:262   */

      /* Empieza nodo:352 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(352)).setAttribute("width","100%" );
      ((Element)v.get(352)).setAttribute("border","0" );
      ((Element)v.get(352)).setAttribute("align","center" );
      ((Element)v.get(352)).setAttribute("cellspacing","0" );
      ((Element)v.get(352)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

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
      ((Element)v.get(356)).setAttribute("width","100%" );
      ((Element)v.get(353)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(358)).setAttribute("class","legend" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(359)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(359)).setAttribute("alto","13" );
      ((Element)v.get(359)).setAttribute("filas","1" );
      ((Element)v.get(359)).setAttribute("valor","" );
      ((Element)v.get(359)).setAttribute("id","legend" );
      ((Element)v.get(359)).setAttribute("cod","00468" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 357   */
      v.add(doc.createElement("table"));
      ((Element)v.get(360)).setAttribute("width","100%" );
      ((Element)v.get(360)).setAttribute("border","0" );
      ((Element)v.get(360)).setAttribute("align","center" );
      ((Element)v.get(360)).setAttribute("cellspacing","0" );
      ((Element)v.get(360)).setAttribute("cellpadding","0" );
      ((Element)v.get(357)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).setAttribute("colspan","3" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","8" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:364 / Elemento padre: 360   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(360)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","8" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(368)).setAttribute("nombre","lblCodigoAcceso" );
      ((Element)v.get(368)).setAttribute("alto","13" );
      ((Element)v.get(368)).setAttribute("filas","1" );
      ((Element)v.get(368)).setAttribute("valor","" );
      ((Element)v.get(368)).setAttribute("id","datosTitle" );
      ((Element)v.get(368)).setAttribute("cod","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(370)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).setAttribute("width","25" );
      ((Element)v.get(370)).setAttribute("height","8" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(372)).setAttribute("nombre","lblVisibleAcceso" );
      ((Element)v.get(372)).setAttribute("alto","13" );
      ((Element)v.get(372)).setAttribute("filas","1" );
      ((Element)v.get(372)).setAttribute("valor","" );
      ((Element)v.get(372)).setAttribute("id","datosTitle" );
      ((Element)v.get(372)).setAttribute("cod","1038" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(364)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","25" );
      ((Element)v.get(374)).setAttribute("height","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(376)).setAttribute("nombre","lblObligatorioAcceso" );
      ((Element)v.get(376)).setAttribute("alto","13" );
      ((Element)v.get(376)).setAttribute("filas","1" );
      ((Element)v.get(376)).setAttribute("valor","" );
      ((Element)v.get(376)).setAttribute("id","datosTitle" );
      ((Element)v.get(376)).setAttribute("cod","949" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","25" );
      ((Element)v.get(378)).setAttribute("height","8" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(380)).setAttribute("nombre","lblModificableAcceso" );
      ((Element)v.get(380)).setAttribute("alto","13" );
      ((Element)v.get(380)).setAttribute("filas","1" );
      ((Element)v.get(380)).setAttribute("valor","" );
      ((Element)v.get(380)).setAttribute("id","datosTitle" );
      ((Element)v.get(380)).setAttribute("cod","914" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(382)).setAttribute("src","b.gif" );
      ((Element)v.get(382)).setAttribute("width","25" );
      ((Element)v.get(382)).setAttribute("height","8" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(384)).setAttribute("nombre","lblNumMaxValoresAcceso" );
      ((Element)v.get(384)).setAttribute("alto","13" );
      ((Element)v.get(384)).setAttribute("filas","1" );
      ((Element)v.get(384)).setAttribute("valor","" );
      ((Element)v.get(384)).setAttribute("id","datosTitle" );
      ((Element)v.get(384)).setAttribute("cod","937" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).setAttribute("width","100%" );
      ((Element)v.get(364)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","8" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:364   */

      /* Empieza nodo:387 / Elemento padre: 360   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(360)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","8" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(391)).setAttribute("nombre","lbldtCodigoAcceso" );
      ((Element)v.get(391)).setAttribute("alto","13" );
      ((Element)v.get(391)).setAttribute("filas","1" );
      ((Element)v.get(391)).setAttribute("valor","05" );
      ((Element)v.get(391)).setAttribute("id","datosCampos" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","25" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(395)).setAttribute("nombre","ckVisibleAcceso" );
      ((Element)v.get(395)).setAttribute("id","datosCampos" );
      ((Element)v.get(395)).setAttribute("onclick","cambiaObli(3)" );
      ((Element)v.get(395)).setAttribute("check","S" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","25" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(399)).setAttribute("nombre","ckObligatorioAcceso" );
      ((Element)v.get(399)).setAttribute("id","datosCampos" );
      ((Element)v.get(399)).setAttribute("onclick","" );
      ((Element)v.get(399)).setAttribute("check","N" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","25" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(403)).setAttribute("nombre","ckModificableAcceso" );
      ((Element)v.get(403)).setAttribute("id","datosCampos" );
      ((Element)v.get(403)).setAttribute("onclick","cambiaNumax(0)" );
      ((Element)v.get(403)).setAttribute("check","S" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","25" );
      ((Element)v.get(405)).setAttribute("height","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(387)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(407)).setAttribute("nombre","txtNumMaxValoresAcceso" );
      ((Element)v.get(407)).setAttribute("id","datosCampos" );
      ((Element)v.get(407)).setAttribute("max","3" );
      ((Element)v.get(407)).setAttribute("tipo","" );
      ((Element)v.get(407)).setAttribute("onchange","" );
      ((Element)v.get(407)).setAttribute("req","N" );
      ((Element)v.get(407)).setAttribute("size","3" );
      ((Element)v.get(407)).setAttribute("valor","" );
      ((Element)v.get(407)).setAttribute("validacion","" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).setAttribute("width","100%" );
      ((Element)v.get(387)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","8" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:387   */

      /* Empieza nodo:410 / Elemento padre: 360   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(360)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).setAttribute("colspan","4" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","8" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:360   */

      /* Empieza nodo:413 / Elemento padre: 357   */
      v.add(doc.createElement("table"));
      ((Element)v.get(413)).setAttribute("width","100%" );
      ((Element)v.get(413)).setAttribute("border","0" );
      ((Element)v.get(413)).setAttribute("align","center" );
      ((Element)v.get(413)).setAttribute("cellspacing","0" );
      ((Element)v.get(413)).setAttribute("cellpadding","0" );
      ((Element)v.get(357)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(418)).setAttribute("nombre","lblValoresPosiblesAcceso" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(418)).setAttribute("alto","13" );
      ((Element)v.get(418)).setAttribute("filas","1" );
      ((Element)v.get(418)).setAttribute("valor","" );
      ((Element)v.get(418)).setAttribute("id","datosTitle" );
      ((Element)v.get(418)).setAttribute("cod","1022" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","25" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(422)).setAttribute("nombre","lblValoresDefectoAcceso" );
      ((Element)v.get(422)).setAttribute("alto","13" );
      ((Element)v.get(422)).setAttribute("filas","1" );
      ((Element)v.get(422)).setAttribute("valor","" );
      ((Element)v.get(422)).setAttribute("id","datosTitle" );
      ((Element)v.get(422)).setAttribute("cod","1286" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).setAttribute("width","100%" );
      ((Element)v.get(414)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:414   */

      /* Empieza nodo:425 / Elemento padre: 413   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(413)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","8" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(425)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(429)).setAttribute("nombre","cbValoresPosiblesAcceso" );
      ((Element)v.get(429)).setAttribute("onchange","accesosOnChange();" );
      ((Element)v.get(429)).setAttribute("id","datosCampos" );
      ((Element)v.get(429)).setAttribute("size","5" );
      ((Element)v.get(429)).setAttribute("multiple","S" );
      ((Element)v.get(429)).setAttribute("req","N" );
      ((Element)v.get(429)).setAttribute("valorinicial","" );
      ((Element)v.get(429)).setAttribute("textoinicial","" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:431 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(425)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","25" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(433)).setAttribute("valign","top" );
      ((Element)v.get(425)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(434)).setAttribute("nombre","cbValoresDefectoAcceso" );
      ((Element)v.get(434)).setAttribute("id","datosCampos" );
      ((Element)v.get(434)).setAttribute("size","1" );
      ((Element)v.get(434)).setAttribute("multiple","N" );
      ((Element)v.get(434)).setAttribute("req","N" );
      ((Element)v.get(434)).setAttribute("valorinicial","" );
      ((Element)v.get(434)).setAttribute("textoinicial","" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:436 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).setAttribute("width","100%" );
      ((Element)v.get(425)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","8" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:425   */

      /* Empieza nodo:438 / Elemento padre: 413   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(413)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).setAttribute("colspan","4" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).setAttribute("width","8" );
      ((Element)v.get(440)).setAttribute("height","8" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:413   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:441 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:353   */

      /* Empieza nodo:443 / Elemento padre: 352   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(352)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).setAttribute("width","12" );
      ((Element)v.get(444)).setAttribute("align","center" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","12" );
      ((Element)v.get(445)).setAttribute("height","15" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 443   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).setAttribute("width","756" );
      ((Element)v.get(443)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 443   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("width","12" );
      ((Element)v.get(443)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","12" );
      ((Element)v.get(449)).setAttribute("height","1" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:443   */
      /* Termina nodo:352   */

      /* Empieza nodo:450 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(450)).setAttribute("width","100%" );
      ((Element)v.get(450)).setAttribute("border","0" );
      ((Element)v.get(450)).setAttribute("align","center" );
      ((Element)v.get(450)).setAttribute("cellspacing","0" );
      ((Element)v.get(450)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(453)).setAttribute("width","8" );
      ((Element)v.get(453)).setAttribute("height","8" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 451   */
      v.add(doc.createElement("td"));
      ((Element)v.get(454)).setAttribute("width","100%" );
      ((Element)v.get(451)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(456)).setAttribute("class","legend" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(457)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(457)).setAttribute("alto","13" );
      ((Element)v.get(457)).setAttribute("filas","1" );
      ((Element)v.get(457)).setAttribute("valor","" );
      ((Element)v.get(457)).setAttribute("id","legend" );
      ((Element)v.get(457)).setAttribute("cod","00469" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 455   */
      v.add(doc.createElement("table"));
      ((Element)v.get(458)).setAttribute("width","100%" );
      ((Element)v.get(458)).setAttribute("border","0" );
      ((Element)v.get(458)).setAttribute("align","center" );
      ((Element)v.get(458)).setAttribute("cellspacing","0" );
      ((Element)v.get(458)).setAttribute("cellpadding","0" );
      ((Element)v.get(455)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(460)).setAttribute("colspan","3" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","8" );
      ((Element)v.get(461)).setAttribute("height","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:462 / Elemento padre: 458   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(458)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(464)).setAttribute("width","8" );
      ((Element)v.get(464)).setAttribute("height","8" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(466)).setAttribute("nombre","lblCodigoSubacceso" );
      ((Element)v.get(466)).setAttribute("alto","13" );
      ((Element)v.get(466)).setAttribute("filas","1" );
      ((Element)v.get(466)).setAttribute("valor","" );
      ((Element)v.get(466)).setAttribute("id","datosTitle" );
      ((Element)v.get(466)).setAttribute("cod","8" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:467 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","25" );
      ((Element)v.get(468)).setAttribute("height","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:469 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(470)).setAttribute("nombre","lblVisibleSubacceso" );
      ((Element)v.get(470)).setAttribute("alto","13" );
      ((Element)v.get(470)).setAttribute("filas","1" );
      ((Element)v.get(470)).setAttribute("valor","" );
      ((Element)v.get(470)).setAttribute("id","datosTitle" );
      ((Element)v.get(470)).setAttribute("cod","1038" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:471 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","25" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(474)).setAttribute("nombre","lblObligatorioSubacceso" );
      ((Element)v.get(474)).setAttribute("alto","13" );
      ((Element)v.get(474)).setAttribute("filas","1" );
      ((Element)v.get(474)).setAttribute("valor","" );
      ((Element)v.get(474)).setAttribute("id","datosTitle" );
      ((Element)v.get(474)).setAttribute("cod","949" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","25" );
      ((Element)v.get(476)).setAttribute("height","8" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(478)).setAttribute("nombre","lblModificableSubacceso" );
      ((Element)v.get(478)).setAttribute("alto","13" );
      ((Element)v.get(478)).setAttribute("filas","1" );
      ((Element)v.get(478)).setAttribute("valor","" );
      ((Element)v.get(478)).setAttribute("id","datosTitle" );
      ((Element)v.get(478)).setAttribute("cod","914" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","25" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(482)).setAttribute("nombre","lblNumMaxValoresSubacceso" );
      ((Element)v.get(482)).setAttribute("alto","13" );
      ((Element)v.get(482)).setAttribute("filas","1" );
      ((Element)v.get(482)).setAttribute("valor","" );
      ((Element)v.get(482)).setAttribute("id","datosTitle" );
      ((Element)v.get(482)).setAttribute("cod","937" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:483 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).setAttribute("width","100%" );
      ((Element)v.get(462)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","8" );
      ((Element)v.get(484)).setAttribute("height","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:462   */

      /* Empieza nodo:485 / Elemento padre: 458   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(458)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","8" );
      ((Element)v.get(487)).setAttribute("height","8" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(489)).setAttribute("nombre","lbldtCodigoSubacceso" );
      ((Element)v.get(489)).setAttribute("alto","13" );
      ((Element)v.get(489)).setAttribute("filas","1" );
      ((Element)v.get(489)).setAttribute("valor","06" );
      ((Element)v.get(489)).setAttribute("id","datosCampos" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","25" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(493)).setAttribute("nombre","ckVisibleSubacceso" );
      ((Element)v.get(493)).setAttribute("id","datosCampos" );
      ((Element)v.get(493)).setAttribute("onclick","cambiaObli(4)" );
      ((Element)v.get(493)).setAttribute("check","S" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","25" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(497)).setAttribute("nombre","ckObligatorioSubacceso" );
      ((Element)v.get(497)).setAttribute("id","datosCampos" );
      ((Element)v.get(497)).setAttribute("onclick","" );
      ((Element)v.get(497)).setAttribute("check","N" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","25" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(501)).setAttribute("nombre","ckModificableSubacceso" );
      ((Element)v.get(501)).setAttribute("id","datosCampos" );
      ((Element)v.get(501)).setAttribute("onclick","cambiaNumax(1)" );
      ((Element)v.get(501)).setAttribute("check","S" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","25" );
      ((Element)v.get(503)).setAttribute("height","8" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(485)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(505)).setAttribute("nombre","txtNumMaxSubacceso" );
      ((Element)v.get(505)).setAttribute("id","datosCampos" );
      ((Element)v.get(505)).setAttribute("max","3" );
      ((Element)v.get(505)).setAttribute("tipo","" );
      ((Element)v.get(505)).setAttribute("onchange","" );
      ((Element)v.get(505)).setAttribute("req","N" );
      ((Element)v.get(505)).setAttribute("size","3" );
      ((Element)v.get(505)).setAttribute("valor","" );
      ((Element)v.get(505)).setAttribute("validacion","" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).setAttribute("width","100%" );
      ((Element)v.get(485)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","8" );
      ((Element)v.get(507)).setAttribute("height","8" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:485   */

      /* Empieza nodo:508 / Elemento padre: 458   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(458)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("td"));
      ((Element)v.get(509)).setAttribute("colspan","4" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","8" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:458   */

      /* Empieza nodo:511 / Elemento padre: 455   */
      v.add(doc.createElement("table"));
      ((Element)v.get(511)).setAttribute("width","100%" );
      ((Element)v.get(511)).setAttribute("border","0" );
      ((Element)v.get(511)).setAttribute("align","center" );
      ((Element)v.get(511)).setAttribute("cellspacing","0" );
      ((Element)v.get(511)).setAttribute("cellpadding","0" );
      ((Element)v.get(455)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).setAttribute("width","8" );
      ((Element)v.get(514)).setAttribute("height","8" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:515 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(516)).setAttribute("nombre","lblValoresPosiblesSubacceso" );
      ((Element)v.get(516)).setAttribute("alto","13" );
      ((Element)v.get(516)).setAttribute("filas","1" );
      ((Element)v.get(516)).setAttribute("valor","" );
      ((Element)v.get(516)).setAttribute("id","datosTitle" );
      ((Element)v.get(516)).setAttribute("cod","1022" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:517 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(518)).setAttribute("src","b.gif" );
      ((Element)v.get(518)).setAttribute("width","25" );
      ((Element)v.get(518)).setAttribute("height","8" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */

      /* Empieza nodo:519 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(520)).setAttribute("nombre","lblValoresDefectoSubacceso" );
      ((Element)v.get(520)).setAttribute("alto","13" );
      ((Element)v.get(520)).setAttribute("filas","1" );
      ((Element)v.get(520)).setAttribute("valor","" );
      ((Element)v.get(520)).setAttribute("id","datosTitle" );
      ((Element)v.get(520)).setAttribute("cod","1286" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:521 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).setAttribute("width","100%" );
      ((Element)v.get(512)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(522)).setAttribute("src","b.gif" );
      ((Element)v.get(522)).setAttribute("width","8" );
      ((Element)v.get(522)).setAttribute("height","8" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */
      /* Termina nodo:512   */

      /* Empieza nodo:523 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","8" );
      ((Element)v.get(525)).setAttribute("height","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(523)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(527)).setAttribute("nombre","cbValoresPosiblesSubacceso" );
      ((Element)v.get(527)).setAttribute("onchange","subAccesosOnChange();" );
      ((Element)v.get(527)).setAttribute("id","datosCampos" );
      ((Element)v.get(527)).setAttribute("size","5" );
      ((Element)v.get(527)).setAttribute("multiple","S" );
      ((Element)v.get(527)).setAttribute("req","N" );
      ((Element)v.get(527)).setAttribute("valorinicial","" );
      ((Element)v.get(527)).setAttribute("textoinicial","" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:529 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(523)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(530)).setAttribute("width","25" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(531)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(531)).setAttribute("valign","top" );
      ((Element)v.get(523)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(532)).setAttribute("nombre","cbValoresDefectoSubacceso" );
      ((Element)v.get(532)).setAttribute("id","datosCampos" );
      ((Element)v.get(532)).setAttribute("size","1" );
      ((Element)v.get(532)).setAttribute("multiple","N" );
      ((Element)v.get(532)).setAttribute("req","N" );
      ((Element)v.get(532)).setAttribute("valorinicial","" );
      ((Element)v.get(532)).setAttribute("textoinicial","" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:534 / Elemento padre: 523   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).setAttribute("width","100%" );
      ((Element)v.get(523)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","8" );
      ((Element)v.get(535)).setAttribute("height","8" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:523   */

      /* Empieza nodo:536 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(537)).setAttribute("colspan","4" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("width","8" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:511   */
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:539 / Elemento padre: 451   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:451   */

      /* Empieza nodo:541 / Elemento padre: 450   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(450)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(542)).setAttribute("width","12" );
      ((Element)v.get(542)).setAttribute("align","center" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","12" );
      ((Element)v.get(543)).setAttribute("height","15" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).setAttribute("width","756" );
      ((Element)v.get(541)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(546)).setAttribute("width","12" );
      ((Element)v.get(541)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","12" );
      ((Element)v.get(547)).setAttribute("height","1" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:541   */
      /* Termina nodo:450   */

      /* Empieza nodo:548 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(548)).setAttribute("width","100%" );
      ((Element)v.get(548)).setAttribute("border","0" );
      ((Element)v.get(548)).setAttribute("align","center" );
      ((Element)v.get(548)).setAttribute("cellspacing","0" );
      ((Element)v.get(548)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(551)).setAttribute("src","b.gif" );
      ((Element)v.get(551)).setAttribute("width","8" );
      ((Element)v.get(551)).setAttribute("height","8" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */

      /* Empieza nodo:552 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).setAttribute("width","100%" );
      ((Element)v.get(549)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(554)).setAttribute("class","legend" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(555)).setAttribute("nombre","lblVigenciaPeriodoInicial" );
      ((Element)v.get(555)).setAttribute("alto","13" );
      ((Element)v.get(555)).setAttribute("filas","1" );
      ((Element)v.get(555)).setAttribute("valor","" );
      ((Element)v.get(555)).setAttribute("id","legend" );
      ((Element)v.get(555)).setAttribute("cod","00470" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:556 / Elemento padre: 553   */
      v.add(doc.createElement("table"));
      ((Element)v.get(556)).setAttribute("width","100%" );
      ((Element)v.get(556)).setAttribute("border","0" );
      ((Element)v.get(556)).setAttribute("align","center" );
      ((Element)v.get(556)).setAttribute("cellspacing","0" );
      ((Element)v.get(556)).setAttribute("cellpadding","0" );
      ((Element)v.get(553)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("colspan","3" );
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

      /* Empieza nodo:560 / Elemento padre: 556   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(556)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","8" );
      ((Element)v.get(562)).setAttribute("height","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(564)).setAttribute("nombre","lblCodigoVigenciaPeriodoInicial" );
      ((Element)v.get(564)).setAttribute("alto","13" );
      ((Element)v.get(564)).setAttribute("filas","1" );
      ((Element)v.get(564)).setAttribute("valor","" );
      ((Element)v.get(564)).setAttribute("id","datosTitle" );
      ((Element)v.get(564)).setAttribute("cod","8" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:565 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","25" );
      ((Element)v.get(566)).setAttribute("height","8" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(568)).setAttribute("nombre","lblVisibleVigenciaPeriodoInicial" );
      ((Element)v.get(568)).setAttribute("alto","13" );
      ((Element)v.get(568)).setAttribute("filas","1" );
      ((Element)v.get(568)).setAttribute("valor","" );
      ((Element)v.get(568)).setAttribute("id","datosTitle" );
      ((Element)v.get(568)).setAttribute("cod","1038" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */

      /* Empieza nodo:569 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","25" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:571 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(572)).setAttribute("nombre","lblObligatorioVigenciaPeriodoInicial" );
      ((Element)v.get(572)).setAttribute("alto","13" );
      ((Element)v.get(572)).setAttribute("filas","1" );
      ((Element)v.get(572)).setAttribute("valor","" );
      ((Element)v.get(572)).setAttribute("id","datosTitle" );
      ((Element)v.get(572)).setAttribute("cod","949" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(574)).setAttribute("src","b.gif" );
      ((Element)v.get(574)).setAttribute("width","25" );
      ((Element)v.get(574)).setAttribute("height","8" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:575 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(576)).setAttribute("nombre","lblModificableVigenciaPeriodoInicial" );
      ((Element)v.get(576)).setAttribute("alto","13" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(576)).setAttribute("filas","1" );
      ((Element)v.get(576)).setAttribute("valor","" );
      ((Element)v.get(576)).setAttribute("id","datosTitle" );
      ((Element)v.get(576)).setAttribute("cod","914" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */

      /* Empieza nodo:577 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).setAttribute("width","100%" );
      ((Element)v.get(560)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(578)).setAttribute("src","b.gif" );
      ((Element)v.get(578)).setAttribute("width","8" );
      ((Element)v.get(578)).setAttribute("height","8" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */
      /* Termina nodo:560   */

      /* Empieza nodo:579 / Elemento padre: 556   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(556)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("width","8" );
      ((Element)v.get(581)).setAttribute("height","8" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */

      /* Empieza nodo:582 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(583)).setAttribute("nombre","lbldtCodigoVigenciaPeriodoInicial" );
      ((Element)v.get(583)).setAttribute("alto","13" );
      ((Element)v.get(583)).setAttribute("filas","1" );
      ((Element)v.get(583)).setAttribute("valor","07" );
      ((Element)v.get(583)).setAttribute("id","datosCampos" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:584 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(585)).setAttribute("src","b.gif" );
      ((Element)v.get(585)).setAttribute("width","25" );
      ((Element)v.get(585)).setAttribute("height","8" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */

      /* Empieza nodo:586 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(587)).setAttribute("nombre","ckVisibleVigenciaPeriodoInicial" );
      ((Element)v.get(587)).setAttribute("id","datosCampos" );
      ((Element)v.get(587)).setAttribute("onclick","cambiaObli(5)" );
      ((Element)v.get(587)).setAttribute("check","S" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).setAttribute("width","25" );
      ((Element)v.get(589)).setAttribute("height","8" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(591)).setAttribute("nombre","ckObligatorioVigenciaPeriodoInicial" );
      ((Element)v.get(591)).setAttribute("id","datosCampos" );
      ((Element)v.get(591)).setAttribute("onclick","" );
      ((Element)v.get(591)).setAttribute("check","S" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).setAttribute("width","25" );
      ((Element)v.get(593)).setAttribute("height","8" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:594 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(595)).setAttribute("nombre","ckModificableVigenciaPeriodoInicial" );
      ((Element)v.get(595)).setAttribute("id","datosCampos" );
      ((Element)v.get(595)).setAttribute("onclick","" );
      ((Element)v.get(595)).setAttribute("check","S" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:596 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).setAttribute("width","100%" );
      ((Element)v.get(579)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","8" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */
      /* Termina nodo:579   */

      /* Empieza nodo:598 / Elemento padre: 556   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(556)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(599)).setAttribute("colspan","4" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","8" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:598   */
      /* Termina nodo:556   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:601 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(602)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */
      /* Termina nodo:549   */

      /* Empieza nodo:603 / Elemento padre: 548   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(548)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("td"));
      ((Element)v.get(604)).setAttribute("width","12" );
      ((Element)v.get(604)).setAttribute("align","center" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("width","12" );
      ((Element)v.get(605)).setAttribute("height","15" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:606 / Elemento padre: 603   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).setAttribute("width","756" );
      ((Element)v.get(603)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:608 / Elemento padre: 603   */
      v.add(doc.createElement("td"));
      ((Element)v.get(608)).setAttribute("width","12" );
      ((Element)v.get(603)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(609)).setAttribute("src","b.gif" );
      ((Element)v.get(609)).setAttribute("width","12" );
      ((Element)v.get(609)).setAttribute("height","1" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */
      /* Termina nodo:603   */
      /* Termina nodo:548   */

      /* Empieza nodo:610 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(610)).setAttribute("width","100%" );
      ((Element)v.get(610)).setAttribute("border","0" );
      ((Element)v.get(610)).setAttribute("align","center" );
      ((Element)v.get(610)).setAttribute("cellspacing","0" );
      ((Element)v.get(610)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(610)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("td"));
      ((Element)v.get(611)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(613)).setAttribute("src","b.gif" );
      ((Element)v.get(613)).setAttribute("width","8" );
      ((Element)v.get(613)).setAttribute("height","8" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:614 / Elemento padre: 611   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).setAttribute("width","100%" );
      ((Element)v.get(611)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(616)).setAttribute("class","legend" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(617)).setAttribute("nombre","lblVigenciaPeriodoFinal" );
      ((Element)v.get(617)).setAttribute("alto","13" );
      ((Element)v.get(617)).setAttribute("filas","1" );
      ((Element)v.get(617)).setAttribute("valor","" );
      ((Element)v.get(617)).setAttribute("id","legend" );
      ((Element)v.get(617)).setAttribute("cod","00471" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:618 / Elemento padre: 615   */
      v.add(doc.createElement("table"));
      ((Element)v.get(618)).setAttribute("width","100%" );
      ((Element)v.get(618)).setAttribute("border","0" );
      ((Element)v.get(618)).setAttribute("align","center" );
      ((Element)v.get(618)).setAttribute("cellspacing","0" );
      ((Element)v.get(618)).setAttribute("cellpadding","0" );
      ((Element)v.get(615)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).setAttribute("colspan","3" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(621)).setAttribute("src","b.gif" );
      ((Element)v.get(621)).setAttribute("width","8" );
      ((Element)v.get(621)).setAttribute("height","8" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:619   */

      /* Empieza nodo:622 / Elemento padre: 618   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(618)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","8" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:625 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(626)).setAttribute("nombre","lblCodigoVigenciaPeriodoFinal" );
      ((Element)v.get(626)).setAttribute("alto","13" );
      ((Element)v.get(626)).setAttribute("filas","1" );
      ((Element)v.get(626)).setAttribute("valor","" );
      ((Element)v.get(626)).setAttribute("id","datosTitle" );
      ((Element)v.get(626)).setAttribute("cod","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:627 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(628)).setAttribute("src","b.gif" );
      ((Element)v.get(628)).setAttribute("width","25" );
      ((Element)v.get(628)).setAttribute("height","8" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:629 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(630)).setAttribute("nombre","lblVisibleVigenciaPeriodoFinal" );
      ((Element)v.get(630)).setAttribute("alto","13" );
      ((Element)v.get(630)).setAttribute("filas","1" );
      ((Element)v.get(630)).setAttribute("valor","" );
      ((Element)v.get(630)).setAttribute("id","datosTitle" );
      ((Element)v.get(630)).setAttribute("cod","1038" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */

      /* Empieza nodo:631 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(632)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).setAttribute("width","25" );
      ((Element)v.get(632)).setAttribute("height","8" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(634)).setAttribute("nombre","lblObligatorioVigenciaPeriodoFinal" );
      ((Element)v.get(634)).setAttribute("alto","13" );
      ((Element)v.get(634)).setAttribute("filas","1" );
      ((Element)v.get(634)).setAttribute("valor","" );
      ((Element)v.get(634)).setAttribute("id","datosTitle" );
      ((Element)v.get(634)).setAttribute("cod","949" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:635 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(636)).setAttribute("src","b.gif" );
      ((Element)v.get(636)).setAttribute("width","25" );
      ((Element)v.get(636)).setAttribute("height","8" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */
      /* Termina nodo:635   */

      /* Empieza nodo:637 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(638)).setAttribute("nombre","lblModificableVigenciaPeriodoFinal" );
      ((Element)v.get(638)).setAttribute("alto","13" );
      ((Element)v.get(638)).setAttribute("filas","1" );
      ((Element)v.get(638)).setAttribute("valor","" );
      ((Element)v.get(638)).setAttribute("id","datosTitle" );
      ((Element)v.get(638)).setAttribute("cod","914" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */

      /* Empieza nodo:639 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).setAttribute("width","100%" );
      ((Element)v.get(622)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(640)).setAttribute("src","b.gif" );
      ((Element)v.get(640)).setAttribute("width","8" );
      ((Element)v.get(640)).setAttribute("height","8" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */
      /* Termina nodo:622   */

      /* Empieza nodo:641 / Elemento padre: 618   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(618)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(643)).setAttribute("src","b.gif" );
      ((Element)v.get(643)).setAttribute("width","8" );
      ((Element)v.get(643)).setAttribute("height","8" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:644 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(645)).setAttribute("nombre","lbldtCodigoVigenciaPeriodoFinal" );
      ((Element)v.get(645)).setAttribute("alto","13" );
      ((Element)v.get(645)).setAttribute("filas","1" );
      ((Element)v.get(645)).setAttribute("valor","08" );
      ((Element)v.get(645)).setAttribute("id","datosCampos" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:646 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(641)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(647)).setAttribute("src","b.gif" );
      ((Element)v.get(647)).setAttribute("width","25" );
      ((Element)v.get(647)).setAttribute("height","8" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */
      /* Termina nodo:646   */

      /* Empieza nodo:648 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(649)).setAttribute("nombre","ckVisibleVigenciaPeriodoFinal" );
      ((Element)v.get(649)).setAttribute("id","datosCampos" );
      ((Element)v.get(649)).setAttribute("onclick","cambiaObli(6)" );
      ((Element)v.get(649)).setAttribute("check","S" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:648   */

      /* Empieza nodo:650 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(651)).setAttribute("src","b.gif" );
      ((Element)v.get(651)).setAttribute("width","25" );
      ((Element)v.get(651)).setAttribute("height","8" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */

      /* Empieza nodo:652 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(653)).setAttribute("nombre","ckObligatorioVigenciaPeriodoFinal" );
      ((Element)v.get(653)).setAttribute("id","datosCampos" );
      ((Element)v.get(653)).setAttribute("onclick","" );
      ((Element)v.get(653)).setAttribute("check","N" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:652   */

      /* Empieza nodo:654 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(655)).setAttribute("src","b.gif" );
      ((Element)v.get(655)).setAttribute("width","25" );
      ((Element)v.get(655)).setAttribute("height","8" );
      ((Element)v.get(654)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:654   */

      /* Empieza nodo:656 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(657)).setAttribute("nombre","ckModificableVigenciaPeriodoFinal" );
      ((Element)v.get(657)).setAttribute("id","datosCampos" );
      ((Element)v.get(657)).setAttribute("onclick","" );
      ((Element)v.get(657)).setAttribute("check","S" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */

      /* Empieza nodo:658 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(658)).setAttribute("width","100%" );
      ((Element)v.get(641)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(659)).setAttribute("src","b.gif" );
      ((Element)v.get(659)).setAttribute("width","8" );
      ((Element)v.get(659)).setAttribute("height","8" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:658   */
      /* Termina nodo:641   */

      /* Empieza nodo:660 / Elemento padre: 618   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(618)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("td"));
      ((Element)v.get(661)).setAttribute("colspan","4" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(662)).setAttribute("src","b.gif" );
      ((Element)v.get(662)).setAttribute("width","8" );
      ((Element)v.get(662)).setAttribute("height","8" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:661   */
      /* Termina nodo:660   */
      /* Termina nodo:618   */
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:663 / Elemento padre: 611   */
      v.add(doc.createElement("td"));
      ((Element)v.get(611)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(664)).setAttribute("src","b.gif" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:663   */
      /* Termina nodo:611   */

      /* Empieza nodo:665 / Elemento padre: 610   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(610)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("td"));
      ((Element)v.get(666)).setAttribute("width","12" );
      ((Element)v.get(666)).setAttribute("align","center" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(667)).setAttribute("src","b.gif" );
      ((Element)v.get(667)).setAttribute("width","12" );
      ((Element)v.get(667)).setAttribute("height","15" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:666   */

      /* Empieza nodo:668 / Elemento padre: 665   */
      v.add(doc.createElement("td"));
      ((Element)v.get(668)).setAttribute("width","756" );
      ((Element)v.get(665)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(669)).setAttribute("src","b.gif" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 665   */
      v.add(doc.createElement("td"));
      ((Element)v.get(670)).setAttribute("width","12" );
      ((Element)v.get(665)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(671)).setAttribute("src","b.gif" );
      ((Element)v.get(671)).setAttribute("width","12" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(671)).setAttribute("height","1" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:670   */
      /* Termina nodo:665   */
      /* Termina nodo:610   */

      /* Empieza nodo:672 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(672)).setAttribute("width","100%" );
      ((Element)v.get(672)).setAttribute("border","0" );
      ((Element)v.get(672)).setAttribute("align","center" );
      ((Element)v.get(672)).setAttribute("cellspacing","0" );
      ((Element)v.get(672)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(672)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("td"));
      ((Element)v.get(673)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(675)).setAttribute("src","b.gif" );
      ((Element)v.get(675)).setAttribute("width","8" );
      ((Element)v.get(675)).setAttribute("height","8" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */
      /* Termina nodo:674   */

      /* Empieza nodo:676 / Elemento padre: 673   */
      v.add(doc.createElement("td"));
      ((Element)v.get(676)).setAttribute("width","100%" );
      ((Element)v.get(673)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(676)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(678)).setAttribute("class","legend" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(679)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(679)).setAttribute("alto","13" );
      ((Element)v.get(679)).setAttribute("filas","1" );
      ((Element)v.get(679)).setAttribute("valor","" );
      ((Element)v.get(679)).setAttribute("id","legend" );
      ((Element)v.get(679)).setAttribute("cod","0068" );
      ((Element)v.get(678)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:678   */

      /* Empieza nodo:680 / Elemento padre: 677   */
      v.add(doc.createElement("table"));
      ((Element)v.get(680)).setAttribute("width","100%" );
      ((Element)v.get(680)).setAttribute("border","0" );
      ((Element)v.get(680)).setAttribute("align","center" );
      ((Element)v.get(680)).setAttribute("cellspacing","0" );
      ((Element)v.get(680)).setAttribute("cellpadding","0" );
      ((Element)v.get(677)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(680)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("td"));
      ((Element)v.get(682)).setAttribute("colspan","3" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(683)).setAttribute("src","b.gif" );
      ((Element)v.get(683)).setAttribute("width","8" );
      ((Element)v.get(683)).setAttribute("height","8" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */
      /* Termina nodo:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:684 / Elemento padre: 680   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(680)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(686)).setAttribute("src","b.gif" );
      ((Element)v.get(686)).setAttribute("width","8" );
      ((Element)v.get(686)).setAttribute("height","8" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */

      /* Empieza nodo:687 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(688)).setAttribute("nombre","lblCodigoTipoCliente" );
      ((Element)v.get(688)).setAttribute("alto","13" );
      ((Element)v.get(688)).setAttribute("filas","1" );
      ((Element)v.get(688)).setAttribute("valor","" );
      ((Element)v.get(688)).setAttribute("id","datosTitle" );
      ((Element)v.get(688)).setAttribute("cod","8" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(690)).setAttribute("src","b.gif" );
      ((Element)v.get(690)).setAttribute("width","25" );
      ((Element)v.get(690)).setAttribute("height","8" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:691 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(692)).setAttribute("nombre","lblVisibleTipoCliente" );
      ((Element)v.get(692)).setAttribute("alto","13" );
      ((Element)v.get(692)).setAttribute("filas","1" );
      ((Element)v.get(692)).setAttribute("valor","" );
      ((Element)v.get(692)).setAttribute("id","datosTitle" );
      ((Element)v.get(692)).setAttribute("cod","1038" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:693 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(694)).setAttribute("src","b.gif" );
      ((Element)v.get(694)).setAttribute("width","25" );
      ((Element)v.get(694)).setAttribute("height","8" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));
      /* Termina nodo:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:695 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(696)).setAttribute("nombre","lblObligatorioTipoCliente" );
      ((Element)v.get(696)).setAttribute("alto","13" );
      ((Element)v.get(696)).setAttribute("filas","1" );
      ((Element)v.get(696)).setAttribute("valor","" );
      ((Element)v.get(696)).setAttribute("id","datosTitle" );
      ((Element)v.get(696)).setAttribute("cod","949" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:697 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(698)).setAttribute("src","b.gif" );
      ((Element)v.get(698)).setAttribute("width","25" );
      ((Element)v.get(698)).setAttribute("height","8" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));
      /* Termina nodo:698   */
      /* Termina nodo:697   */

      /* Empieza nodo:699 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(700)).setAttribute("nombre","lblModificableTipoCliente" );
      ((Element)v.get(700)).setAttribute("alto","13" );
      ((Element)v.get(700)).setAttribute("filas","1" );
      ((Element)v.get(700)).setAttribute("valor","" );
      ((Element)v.get(700)).setAttribute("id","datosTitle" );
      ((Element)v.get(700)).setAttribute("cod","914" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */
      /* Termina nodo:699   */

      /* Empieza nodo:701 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(702)).setAttribute("src","b.gif" );
      ((Element)v.get(702)).setAttribute("width","25" );
      ((Element)v.get(702)).setAttribute("height","8" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:703 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(704)).setAttribute("nombre","lblNumMaxValoresTipoCliente" );
      ((Element)v.get(704)).setAttribute("alto","13" );
      ((Element)v.get(704)).setAttribute("filas","1" );
      ((Element)v.get(704)).setAttribute("valor","" );
      ((Element)v.get(704)).setAttribute("id","datosTitle" );
      ((Element)v.get(704)).setAttribute("cod","937" );
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:703   */

      /* Empieza nodo:705 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(705)).setAttribute("width","100%" );
      ((Element)v.get(684)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(706)).setAttribute("src","b.gif" );
      ((Element)v.get(706)).setAttribute("width","8" );
      ((Element)v.get(706)).setAttribute("height","8" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */
      /* Termina nodo:705   */
      /* Termina nodo:684   */

      /* Empieza nodo:707 / Elemento padre: 680   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(680)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(708));

      /* Empieza nodo:709 / Elemento padre: 708   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(709)).setAttribute("src","b.gif" );
      ((Element)v.get(709)).setAttribute("width","8" );
      ((Element)v.get(709)).setAttribute("height","8" );
      ((Element)v.get(708)).appendChild((Element)v.get(709));
      /* Termina nodo:709   */
      /* Termina nodo:708   */

      /* Empieza nodo:710 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(711)).setAttribute("nombre","lbldtCodigoTipoCliente" );
      ((Element)v.get(711)).setAttribute("alto","13" );
      ((Element)v.get(711)).setAttribute("filas","1" );
      ((Element)v.get(711)).setAttribute("valor","09" );
      ((Element)v.get(711)).setAttribute("id","datosCampos" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */

      /* Empieza nodo:712 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(713)).setAttribute("src","b.gif" );
      ((Element)v.get(713)).setAttribute("width","25" );
      ((Element)v.get(713)).setAttribute("height","8" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */
      /* Termina nodo:712   */

      /* Empieza nodo:714 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(715)).setAttribute("nombre","ckVisibleTipoCliente" );
      ((Element)v.get(715)).setAttribute("id","datosCampos" );
      ((Element)v.get(715)).setAttribute("onclick","cambiaObli(7)" );
      ((Element)v.get(715)).setAttribute("check","S" );
      ((Element)v.get(714)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */
      /* Termina nodo:714   */

      /* Empieza nodo:716 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(707)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(717)).setAttribute("src","b.gif" );
      ((Element)v.get(717)).setAttribute("width","25" );
      ((Element)v.get(717)).setAttribute("height","8" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));
      /* Termina nodo:717   */
      /* Termina nodo:716   */

      /* Empieza nodo:718 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(718));

      /* Empieza nodo:719 / Elemento padre: 718   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(719)).setAttribute("nombre","ckObligatorioTipoCliente" );
      ((Element)v.get(719)).setAttribute("id","datosCampos" );
      ((Element)v.get(719)).setAttribute("onclick","" );
      ((Element)v.get(719)).setAttribute("check","S" );
      ((Element)v.get(718)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */
      /* Termina nodo:718   */

      /* Empieza nodo:720 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(721)).setAttribute("src","b.gif" );
      ((Element)v.get(721)).setAttribute("width","25" );
      ((Element)v.get(721)).setAttribute("height","8" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */
      /* Termina nodo:720   */

      /* Empieza nodo:722 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(723)).setAttribute("nombre","ckModificableTipoCliente" );
      ((Element)v.get(723)).setAttribute("id","datosCampos" );
      ((Element)v.get(723)).setAttribute("onclick","cambiaNumax(2)" );
      ((Element)v.get(723)).setAttribute("check","S" );
      ((Element)v.get(722)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */
      /* Termina nodo:722   */

      /* Empieza nodo:724 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(725)).setAttribute("src","b.gif" );
      ((Element)v.get(725)).setAttribute("width","25" );
      ((Element)v.get(725)).setAttribute("height","8" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */
      /* Termina nodo:724   */

      /* Empieza nodo:726 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(726)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(707)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(727)).setAttribute("nombre","txtNumMaxTipoCliente" );
      ((Element)v.get(727)).setAttribute("id","datosCampos" );
      ((Element)v.get(727)).setAttribute("max","3" );
      ((Element)v.get(727)).setAttribute("tipo","" );
      ((Element)v.get(727)).setAttribute("onchange","" );
      ((Element)v.get(727)).setAttribute("req","N" );
      ((Element)v.get(727)).setAttribute("size","3" );
      ((Element)v.get(727)).setAttribute("valor","" );
      ((Element)v.get(727)).setAttribute("validacion","" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));
      /* Termina nodo:727   */
      /* Termina nodo:726   */

      /* Empieza nodo:728 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(728)).setAttribute("width","100%" );
      ((Element)v.get(707)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(729)).setAttribute("src","b.gif" );
      ((Element)v.get(729)).setAttribute("width","8" );
      ((Element)v.get(729)).setAttribute("height","8" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));
      /* Termina nodo:729   */
      /* Termina nodo:728   */
      /* Termina nodo:707   */

      /* Empieza nodo:730 / Elemento padre: 680   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(680)).appendChild((Element)v.get(730));

      /* Empieza nodo:731 / Elemento padre: 730   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).setAttribute("colspan","4" );
      ((Element)v.get(730)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(732)).setAttribute("src","b.gif" );
      ((Element)v.get(732)).setAttribute("width","8" );
      ((Element)v.get(732)).setAttribute("height","8" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:730   */
      /* Termina nodo:680   */

      /* Empieza nodo:733 / Elemento padre: 677   */
      v.add(doc.createElement("table"));
      ((Element)v.get(733)).setAttribute("width","100%" );
      ((Element)v.get(733)).setAttribute("border","0" );
      ((Element)v.get(733)).setAttribute("align","center" );
      ((Element)v.get(733)).setAttribute("cellspacing","0" );
      ((Element)v.get(733)).setAttribute("cellpadding","0" );
      ((Element)v.get(677)).appendChild((Element)v.get(733));

      /* Empieza nodo:734 / Elemento padre: 733   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(733)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).appendChild((Element)v.get(735));

      /* Empieza nodo:736 / Elemento padre: 735   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(736)).setAttribute("src","b.gif" );
      ((Element)v.get(736)).setAttribute("width","8" );
      ((Element)v.get(736)).setAttribute("height","8" );
      ((Element)v.get(735)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */
      /* Termina nodo:735   */

      /* Empieza nodo:737 / Elemento padre: 734   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(738)).setAttribute("nombre","lblValoresPosiblesTipoCliente" );
      ((Element)v.get(738)).setAttribute("alto","13" );
      ((Element)v.get(738)).setAttribute("filas","1" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(738)).setAttribute("valor","" );
      ((Element)v.get(738)).setAttribute("id","datosTitle" );
      ((Element)v.get(738)).setAttribute("cod","1301" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */
      /* Termina nodo:737   */

      /* Empieza nodo:739 / Elemento padre: 734   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(740)).setAttribute("src","b.gif" );
      ((Element)v.get(740)).setAttribute("width","25" );
      ((Element)v.get(740)).setAttribute("height","8" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */
      /* Termina nodo:739   */

      /* Empieza nodo:741 / Elemento padre: 734   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(742)).setAttribute("nombre","lblValoresDefectoTipoCliente" );
      ((Element)v.get(742)).setAttribute("alto","13" );
      ((Element)v.get(742)).setAttribute("filas","1" );
      ((Element)v.get(742)).setAttribute("valor","" );
      ((Element)v.get(742)).setAttribute("id","datosTitle" );
      ((Element)v.get(742)).setAttribute("cod","1286" );
      ((Element)v.get(741)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */
      /* Termina nodo:741   */

      /* Empieza nodo:743 / Elemento padre: 734   */
      v.add(doc.createElement("td"));
      ((Element)v.get(743)).setAttribute("width","100%" );
      ((Element)v.get(734)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(744)).setAttribute("src","b.gif" );
      ((Element)v.get(744)).setAttribute("width","8" );
      ((Element)v.get(744)).setAttribute("height","8" );
      ((Element)v.get(743)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */
      /* Termina nodo:743   */
      /* Termina nodo:734   */

      /* Empieza nodo:745 / Elemento padre: 733   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(733)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("td"));
      ((Element)v.get(745)).appendChild((Element)v.get(746));

      /* Empieza nodo:747 / Elemento padre: 746   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(747)).setAttribute("src","b.gif" );
      ((Element)v.get(747)).setAttribute("width","8" );
      ((Element)v.get(747)).setAttribute("height","8" );
      ((Element)v.get(746)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */
      /* Termina nodo:746   */

      /* Empieza nodo:748 / Elemento padre: 745   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(745)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(749)).setAttribute("nombre","cbValoresPosiblesTipoCliente" );
      ((Element)v.get(749)).setAttribute("onchange","tipoClienteOnChange();" );
      ((Element)v.get(749)).setAttribute("id","datosCampos" );
      ((Element)v.get(749)).setAttribute("size","5" );
      ((Element)v.get(749)).setAttribute("multiple","S" );
      ((Element)v.get(749)).setAttribute("req","S" );
      ((Element)v.get(749)).setAttribute("valorinicial","" );
      ((Element)v.get(749)).setAttribute("textoinicial","" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));

      /* Empieza nodo:750 / Elemento padre: 749   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(749)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */
      /* Termina nodo:749   */
      /* Termina nodo:748   */

      /* Empieza nodo:751 / Elemento padre: 745   */
      v.add(doc.createElement("td"));
      ((Element)v.get(745)).appendChild((Element)v.get(751));

      /* Empieza nodo:752 / Elemento padre: 751   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(752)).setAttribute("src","b.gif" );
      ((Element)v.get(752)).setAttribute("width","25" );
      ((Element)v.get(752)).setAttribute("height","8" );
      ((Element)v.get(751)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */
      /* Termina nodo:751   */

      /* Empieza nodo:753 / Elemento padre: 745   */
      v.add(doc.createElement("td"));
      ((Element)v.get(753)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(753)).setAttribute("valign","top" );
      ((Element)v.get(745)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(754)).setAttribute("nombre","cbValoresDefectoTipoCliente" );
      ((Element)v.get(754)).setAttribute("id","datosCampos" );
      ((Element)v.get(754)).setAttribute("size","1" );
      ((Element)v.get(754)).setAttribute("multiple","N" );
      ((Element)v.get(754)).setAttribute("req","N" );
      ((Element)v.get(754)).setAttribute("valorinicial","" );
      ((Element)v.get(754)).setAttribute("textoinicial","" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(754)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:754   */
      /* Termina nodo:753   */

      /* Empieza nodo:756 / Elemento padre: 745   */
      v.add(doc.createElement("td"));
      ((Element)v.get(756)).setAttribute("width","100%" );
      ((Element)v.get(745)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(757)).setAttribute("src","b.gif" );
      ((Element)v.get(757)).setAttribute("width","8" );
      ((Element)v.get(757)).setAttribute("height","8" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */
      /* Termina nodo:756   */
      /* Termina nodo:745   */

      /* Empieza nodo:758 / Elemento padre: 733   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(733)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(759)).setAttribute("colspan","4" );
      ((Element)v.get(758)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(760)).setAttribute("src","b.gif" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(760)).setAttribute("width","8" );
      ((Element)v.get(760)).setAttribute("height","8" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */
      /* Termina nodo:759   */
      /* Termina nodo:758   */
      /* Termina nodo:733   */

      /* Empieza nodo:761 / Elemento padre: 677   */
      v.add(doc.createElement("table"));
      ((Element)v.get(761)).setAttribute("width","100%" );
      ((Element)v.get(761)).setAttribute("border","0" );
      ((Element)v.get(761)).setAttribute("align","center" );
      ((Element)v.get(761)).setAttribute("cellspacing","0" );
      ((Element)v.get(761)).setAttribute("cellpadding","0" );
      ((Element)v.get(677)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(761)).appendChild((Element)v.get(762));

      /* Empieza nodo:763 / Elemento padre: 762   */
      v.add(doc.createElement("td"));
      ((Element)v.get(762)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(764)).setAttribute("src","b.gif" );
      ((Element)v.get(764)).setAttribute("width","8" );
      ((Element)v.get(764)).setAttribute("height","8" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */
      /* Termina nodo:763   */

      /* Empieza nodo:765 / Elemento padre: 762   */
      v.add(doc.createElement("td"));
      ((Element)v.get(762)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(766)).setAttribute("nombre","lblValoresPosiblesSubtipoCliente" );
      ((Element)v.get(766)).setAttribute("alto","13" );
      ((Element)v.get(766)).setAttribute("filas","1" );
      ((Element)v.get(766)).setAttribute("valor","" );
      ((Element)v.get(766)).setAttribute("id","datosTitle" );
      ((Element)v.get(766)).setAttribute("cod","595" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */
      /* Termina nodo:765   */

      /* Empieza nodo:767 / Elemento padre: 762   */
      v.add(doc.createElement("td"));
      ((Element)v.get(762)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(768)).setAttribute("src","b.gif" );
      ((Element)v.get(768)).setAttribute("width","25" );
      ((Element)v.get(768)).setAttribute("height","8" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));
      /* Termina nodo:768   */
      /* Termina nodo:767   */

      /* Empieza nodo:769 / Elemento padre: 762   */
      v.add(doc.createElement("td"));
      ((Element)v.get(762)).appendChild((Element)v.get(769));

      /* Empieza nodo:770 / Elemento padre: 769   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(770)).setAttribute("nombre","lblValoresDefectoSubtipoCliente" );
      ((Element)v.get(770)).setAttribute("alto","13" );
      ((Element)v.get(770)).setAttribute("filas","1" );
      ((Element)v.get(770)).setAttribute("valor","" );
      ((Element)v.get(770)).setAttribute("id","datosTitle" );
      ((Element)v.get(770)).setAttribute("cod","1286" );
      ((Element)v.get(769)).appendChild((Element)v.get(770));
      /* Termina nodo:770   */
      /* Termina nodo:769   */

      /* Empieza nodo:771 / Elemento padre: 762   */
      v.add(doc.createElement("td"));
      ((Element)v.get(771)).setAttribute("width","100%" );
      ((Element)v.get(762)).appendChild((Element)v.get(771));

      /* Empieza nodo:772 / Elemento padre: 771   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(772)).setAttribute("src","b.gif" );
      ((Element)v.get(772)).setAttribute("width","8" );
      ((Element)v.get(772)).setAttribute("height","8" );
      ((Element)v.get(771)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */
      /* Termina nodo:771   */
      /* Termina nodo:762   */

      /* Empieza nodo:773 / Elemento padre: 761   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(761)).appendChild((Element)v.get(773));

      /* Empieza nodo:774 / Elemento padre: 773   */
      v.add(doc.createElement("td"));
      ((Element)v.get(773)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(775)).setAttribute("src","b.gif" );
      ((Element)v.get(775)).setAttribute("width","8" );
      ((Element)v.get(775)).setAttribute("height","8" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));
      /* Termina nodo:775   */
      /* Termina nodo:774   */

      /* Empieza nodo:776 / Elemento padre: 773   */
      v.add(doc.createElement("td"));
      ((Element)v.get(776)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(773)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(777)).setAttribute("nombre","cbValoresPosiblesSubtipoCliente" );
      ((Element)v.get(777)).setAttribute("onchange","subtipoClienteOnChange();" );
      ((Element)v.get(777)).setAttribute("id","datosCampos" );
      ((Element)v.get(777)).setAttribute("size","5" );
      ((Element)v.get(777)).setAttribute("multiple","S" );
      ((Element)v.get(777)).setAttribute("req","S" );
      ((Element)v.get(777)).setAttribute("valorinicial","" );
      ((Element)v.get(777)).setAttribute("textoinicial","" );
      ((Element)v.get(776)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(777)).appendChild((Element)v.get(778));
      /* Termina nodo:778   */
      /* Termina nodo:777   */
      /* Termina nodo:776   */

      /* Empieza nodo:779 / Elemento padre: 773   */
      v.add(doc.createElement("td"));
      ((Element)v.get(773)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(780)).setAttribute("src","b.gif" );
      ((Element)v.get(780)).setAttribute("width","25" );
      ((Element)v.get(780)).setAttribute("height","8" );
      ((Element)v.get(779)).appendChild((Element)v.get(780));
      /* Termina nodo:780   */
      /* Termina nodo:779   */

      /* Empieza nodo:781 / Elemento padre: 773   */
      v.add(doc.createElement("td"));
      ((Element)v.get(781)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(781)).setAttribute("valign","top" );
      ((Element)v.get(773)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(782)).setAttribute("nombre","cbValoresDefectoSubtipoCliente" );
      ((Element)v.get(782)).setAttribute("id","datosCampos" );
      ((Element)v.get(782)).setAttribute("size","1" );
      ((Element)v.get(782)).setAttribute("multiple","N" );
      ((Element)v.get(782)).setAttribute("req","N" );
      ((Element)v.get(782)).setAttribute("valorinicial","" );
      ((Element)v.get(782)).setAttribute("textoinicial","" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(782)).appendChild((Element)v.get(783));
      /* Termina nodo:783   */
      /* Termina nodo:782   */
      /* Termina nodo:781   */

      /* Empieza nodo:784 / Elemento padre: 773   */
      v.add(doc.createElement("td"));
      ((Element)v.get(784)).setAttribute("width","100%" );
      ((Element)v.get(773)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(785)).setAttribute("src","b.gif" );
      ((Element)v.get(785)).setAttribute("width","8" );
      ((Element)v.get(785)).setAttribute("height","8" );
      ((Element)v.get(784)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */
      /* Termina nodo:784   */
      /* Termina nodo:773   */

      /* Empieza nodo:786 / Elemento padre: 761   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(761)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("td"));
      ((Element)v.get(787)).setAttribute("colspan","4" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(788)).setAttribute("src","b.gif" );
      ((Element)v.get(788)).setAttribute("width","8" );
      ((Element)v.get(788)).setAttribute("height","8" );
      ((Element)v.get(787)).appendChild((Element)v.get(788));
      /* Termina nodo:788   */
      /* Termina nodo:787   */
      /* Termina nodo:786   */
      /* Termina nodo:761   */
      /* Termina nodo:677   */
      /* Termina nodo:676   */

      /* Empieza nodo:789 / Elemento padre: 673   */
      v.add(doc.createElement("td"));
      ((Element)v.get(673)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(790)).setAttribute("src","b.gif" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));
      /* Termina nodo:790   */
      /* Termina nodo:789   */
      /* Termina nodo:673   */

      /* Empieza nodo:791 / Elemento padre: 672   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(672)).appendChild((Element)v.get(791));

      /* Empieza nodo:792 / Elemento padre: 791   */
      v.add(doc.createElement("td"));
      ((Element)v.get(792)).setAttribute("width","12" );
      ((Element)v.get(792)).setAttribute("align","center" );
      ((Element)v.get(791)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(793)).setAttribute("src","b.gif" );
      ((Element)v.get(793)).setAttribute("width","12" );
      ((Element)v.get(793)).setAttribute("height","15" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));
      /* Termina nodo:793   */
      /* Termina nodo:792   */

      /* Empieza nodo:794 / Elemento padre: 791   */
      v.add(doc.createElement("td"));
      ((Element)v.get(794)).setAttribute("width","756" );
      ((Element)v.get(791)).appendChild((Element)v.get(794));

      /* Empieza nodo:795 / Elemento padre: 794   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(795)).setAttribute("src","b.gif" );
      ((Element)v.get(794)).appendChild((Element)v.get(795));
      /* Termina nodo:795   */
      /* Termina nodo:794   */

      /* Empieza nodo:796 / Elemento padre: 791   */
      v.add(doc.createElement("td"));
      ((Element)v.get(796)).setAttribute("width","12" );
      ((Element)v.get(791)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(797)).setAttribute("src","b.gif" );
      ((Element)v.get(797)).setAttribute("width","12" );
      ((Element)v.get(797)).setAttribute("height","1" );
      ((Element)v.get(796)).appendChild((Element)v.get(797));
      /* Termina nodo:797   */
      /* Termina nodo:796   */
      /* Termina nodo:791   */
      /* Termina nodo:672   */

      /* Empieza nodo:798 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(798)).setAttribute("width","100%" );
      ((Element)v.get(798)).setAttribute("border","0" );
      ((Element)v.get(798)).setAttribute("align","center" );
      ((Element)v.get(798)).setAttribute("cellspacing","0" );
      ((Element)v.get(798)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(798));

      /* Empieza nodo:799 / Elemento padre: 798   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(798)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("td"));
      ((Element)v.get(799)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(801)).setAttribute("src","b.gif" );
      ((Element)v.get(801)).setAttribute("width","8" );
      ((Element)v.get(801)).setAttribute("height","8" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));
      /* Termina nodo:801   */
      /* Termina nodo:800   */

      /* Empieza nodo:802 / Elemento padre: 799   */
      v.add(doc.createElement("td"));
      ((Element)v.get(802)).setAttribute("width","100%" );
      ((Element)v.get(799)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(802)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(804)).setAttribute("class","legend" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(805)).setAttribute("nombre","lblPorcentajeAdicionalLineaCarrera" );
      ((Element)v.get(805)).setAttribute("alto","13" );
      ((Element)v.get(805)).setAttribute("filas","1" );
      ((Element)v.get(805)).setAttribute("valor","" );
      ((Element)v.get(805)).setAttribute("id","legend" );
      ((Element)v.get(805)).setAttribute("cod","00472" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));
      /* Termina nodo:805   */
      /* Termina nodo:804   */

      /* Empieza nodo:806 / Elemento padre: 803   */
   }

   private void getXML3240(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(806)).setAttribute("width","100%" );
      ((Element)v.get(806)).setAttribute("border","0" );
      ((Element)v.get(806)).setAttribute("align","center" );
      ((Element)v.get(806)).setAttribute("cellspacing","0" );
      ((Element)v.get(806)).setAttribute("cellpadding","0" );
      ((Element)v.get(803)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(806)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("td"));
      ((Element)v.get(808)).setAttribute("colspan","3" );
      ((Element)v.get(807)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(809)).setAttribute("src","b.gif" );
      ((Element)v.get(809)).setAttribute("width","8" );
      ((Element)v.get(809)).setAttribute("height","8" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));
      /* Termina nodo:809   */
      /* Termina nodo:808   */
      /* Termina nodo:807   */

      /* Empieza nodo:810 / Elemento padre: 806   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(806)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).appendChild((Element)v.get(811));

      /* Empieza nodo:812 / Elemento padre: 811   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(812)).setAttribute("src","b.gif" );
      ((Element)v.get(812)).setAttribute("width","8" );
      ((Element)v.get(812)).setAttribute("height","8" );
      ((Element)v.get(811)).appendChild((Element)v.get(812));
      /* Termina nodo:812   */
      /* Termina nodo:811   */

      /* Empieza nodo:813 / Elemento padre: 810   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).appendChild((Element)v.get(813));

      /* Empieza nodo:814 / Elemento padre: 813   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(814)).setAttribute("nombre","lblCodigoPorcentajeAdicionalLineaCarrera" );
      ((Element)v.get(814)).setAttribute("alto","13" );
      ((Element)v.get(814)).setAttribute("filas","1" );
      ((Element)v.get(814)).setAttribute("valor","" );
      ((Element)v.get(814)).setAttribute("id","datosTitle" );
      ((Element)v.get(814)).setAttribute("cod","8" );
      ((Element)v.get(813)).appendChild((Element)v.get(814));
      /* Termina nodo:814   */
      /* Termina nodo:813   */

      /* Empieza nodo:815 / Elemento padre: 810   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(816)).setAttribute("src","b.gif" );
      ((Element)v.get(816)).setAttribute("width","25" );
      ((Element)v.get(816)).setAttribute("height","8" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));
      /* Termina nodo:816   */
      /* Termina nodo:815   */

      /* Empieza nodo:817 / Elemento padre: 810   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(818)).setAttribute("nombre","lblVisiblePorcentajeAdicionalLineaCarrera" );
      ((Element)v.get(818)).setAttribute("alto","13" );
      ((Element)v.get(818)).setAttribute("filas","1" );
      ((Element)v.get(818)).setAttribute("valor","" );
      ((Element)v.get(818)).setAttribute("id","datosTitle" );
      ((Element)v.get(818)).setAttribute("cod","1038" );
      ((Element)v.get(817)).appendChild((Element)v.get(818));
      /* Termina nodo:818   */
      /* Termina nodo:817   */

      /* Empieza nodo:819 / Elemento padre: 810   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).appendChild((Element)v.get(819));

      /* Empieza nodo:820 / Elemento padre: 819   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(820)).setAttribute("src","b.gif" );
      ((Element)v.get(820)).setAttribute("width","25" );
      ((Element)v.get(820)).setAttribute("height","8" );
      ((Element)v.get(819)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */
      /* Termina nodo:819   */

      /* Empieza nodo:821 / Elemento padre: 810   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(822)).setAttribute("nombre","lblObligatorioPorcentajeAdicionalLineaCarrera" );
      ((Element)v.get(822)).setAttribute("alto","13" );
      ((Element)v.get(822)).setAttribute("filas","1" );
      ((Element)v.get(822)).setAttribute("valor","" );
      ((Element)v.get(822)).setAttribute("id","datosTitle" );
      ((Element)v.get(822)).setAttribute("cod","949" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */
      /* Termina nodo:821   */

      /* Empieza nodo:823 / Elemento padre: 810   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(824)).setAttribute("src","b.gif" );
      ((Element)v.get(824)).setAttribute("width","25" );
      ((Element)v.get(824)).setAttribute("height","8" );
      ((Element)v.get(823)).appendChild((Element)v.get(824));
      /* Termina nodo:824   */
      /* Termina nodo:823   */

      /* Empieza nodo:825 / Elemento padre: 810   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(826)).setAttribute("nombre","lblModificablePorcentajeAdicionalLineaCarrera" );
      ((Element)v.get(826)).setAttribute("alto","13" );
      ((Element)v.get(826)).setAttribute("filas","1" );
      ((Element)v.get(826)).setAttribute("valor","" );
      ((Element)v.get(826)).setAttribute("id","datosTitle" );
      ((Element)v.get(826)).setAttribute("cod","914" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));
      /* Termina nodo:826   */
      /* Termina nodo:825   */

      /* Empieza nodo:827 / Elemento padre: 810   */
      v.add(doc.createElement("td"));
      ((Element)v.get(827)).setAttribute("width","100%" );
      ((Element)v.get(810)).appendChild((Element)v.get(827));

      /* Empieza nodo:828 / Elemento padre: 827   */
   }

   private void getXML3330(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(828)).setAttribute("src","b.gif" );
      ((Element)v.get(828)).setAttribute("width","8" );
      ((Element)v.get(828)).setAttribute("height","8" );
      ((Element)v.get(827)).appendChild((Element)v.get(828));
      /* Termina nodo:828   */
      /* Termina nodo:827   */
      /* Termina nodo:810   */

      /* Empieza nodo:829 / Elemento padre: 806   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(806)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).appendChild((Element)v.get(830));

      /* Empieza nodo:831 / Elemento padre: 830   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(831)).setAttribute("src","b.gif" );
      ((Element)v.get(831)).setAttribute("width","8" );
      ((Element)v.get(831)).setAttribute("height","8" );
      ((Element)v.get(830)).appendChild((Element)v.get(831));
      /* Termina nodo:831   */
      /* Termina nodo:830   */

      /* Empieza nodo:832 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(833)).setAttribute("nombre","lbldtCodigoPorcentajeAdicionalLineaCarrera" );
      ((Element)v.get(833)).setAttribute("alto","13" );
      ((Element)v.get(833)).setAttribute("filas","1" );
      ((Element)v.get(833)).setAttribute("valor","10" );
      ((Element)v.get(833)).setAttribute("id","datosCampos" );
      ((Element)v.get(832)).appendChild((Element)v.get(833));
      /* Termina nodo:833   */
      /* Termina nodo:832   */

      /* Empieza nodo:834 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).appendChild((Element)v.get(834));

      /* Empieza nodo:835 / Elemento padre: 834   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(835)).setAttribute("src","b.gif" );
      ((Element)v.get(835)).setAttribute("width","25" );
      ((Element)v.get(835)).setAttribute("height","8" );
      ((Element)v.get(834)).appendChild((Element)v.get(835));
      /* Termina nodo:835   */
      /* Termina nodo:834   */

      /* Empieza nodo:836 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).appendChild((Element)v.get(836));

      /* Empieza nodo:837 / Elemento padre: 836   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(837)).setAttribute("nombre","ckVisiblePorcentajeAdicionalLineaCarrera" );
      ((Element)v.get(837)).setAttribute("id","datosCampos" );
      ((Element)v.get(837)).setAttribute("onclick","cambiaObli(8)" );
      ((Element)v.get(837)).setAttribute("check","S" );
      ((Element)v.get(836)).appendChild((Element)v.get(837));
      /* Termina nodo:837   */
      /* Termina nodo:836   */

      /* Empieza nodo:838 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).appendChild((Element)v.get(838));

      /* Empieza nodo:839 / Elemento padre: 838   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(839)).setAttribute("src","b.gif" );
      ((Element)v.get(839)).setAttribute("width","25" );
      ((Element)v.get(839)).setAttribute("height","8" );
      ((Element)v.get(838)).appendChild((Element)v.get(839));
      /* Termina nodo:839   */
      /* Termina nodo:838   */

      /* Empieza nodo:840 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).appendChild((Element)v.get(840));

      /* Empieza nodo:841 / Elemento padre: 840   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(841)).setAttribute("nombre","ckObligatorioPorcentajeAdicionalLineaCarrera" );
      ((Element)v.get(841)).setAttribute("id","datosCampos" );
      ((Element)v.get(841)).setAttribute("onclick","" );
      ((Element)v.get(841)).setAttribute("check","N" );
      ((Element)v.get(840)).appendChild((Element)v.get(841));
      /* Termina nodo:841   */
      /* Termina nodo:840   */

      /* Empieza nodo:842 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).appendChild((Element)v.get(842));

      /* Empieza nodo:843 / Elemento padre: 842   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(843)).setAttribute("src","b.gif" );
      ((Element)v.get(843)).setAttribute("width","25" );
      ((Element)v.get(843)).setAttribute("height","8" );
      ((Element)v.get(842)).appendChild((Element)v.get(843));
      /* Termina nodo:843   */
      /* Termina nodo:842   */

      /* Empieza nodo:844 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(845)).setAttribute("nombre","ckModificablePorcentajeAdicionalLineaCarrera" );
      ((Element)v.get(845)).setAttribute("id","datosCampos" );
      ((Element)v.get(845)).setAttribute("onclick","" );
      ((Element)v.get(845)).setAttribute("check","S" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:844   */

      /* Empieza nodo:846 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).setAttribute("width","100%" );
      ((Element)v.get(829)).appendChild((Element)v.get(846));

      /* Empieza nodo:847 / Elemento padre: 846   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(847)).setAttribute("src","b.gif" );
      ((Element)v.get(847)).setAttribute("width","8" );
      ((Element)v.get(847)).setAttribute("height","8" );
      ((Element)v.get(846)).appendChild((Element)v.get(847));
      /* Termina nodo:847   */
      /* Termina nodo:846   */
      /* Termina nodo:829   */

      /* Empieza nodo:848 / Elemento padre: 806   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(806)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("td"));
      ((Element)v.get(849)).setAttribute("colspan","4" );
      ((Element)v.get(848)).appendChild((Element)v.get(849));

      /* Empieza nodo:850 / Elemento padre: 849   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(850)).setAttribute("src","b.gif" );
      ((Element)v.get(850)).setAttribute("width","8" );
      ((Element)v.get(850)).setAttribute("height","8" );
      ((Element)v.get(849)).appendChild((Element)v.get(850));
      /* Termina nodo:850   */
      /* Termina nodo:849   */
      /* Termina nodo:848   */
      /* Termina nodo:806   */

      /* Empieza nodo:851 / Elemento padre: 803   */
      v.add(doc.createElement("table"));
      ((Element)v.get(851)).setAttribute("width","100%" );
      ((Element)v.get(851)).setAttribute("border","0" );
      ((Element)v.get(851)).setAttribute("align","center" );
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(851)).setAttribute("cellspacing","0" );
      ((Element)v.get(851)).setAttribute("cellpadding","0" );
      ((Element)v.get(803)).appendChild((Element)v.get(851));

      /* Empieza nodo:852 / Elemento padre: 851   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(851)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(852)).appendChild((Element)v.get(853));

      /* Empieza nodo:854 / Elemento padre: 853   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(854)).setAttribute("src","b.gif" );
      ((Element)v.get(854)).setAttribute("width","8" );
      ((Element)v.get(854)).setAttribute("height","8" );
      ((Element)v.get(853)).appendChild((Element)v.get(854));
      /* Termina nodo:854   */
      /* Termina nodo:853   */

      /* Empieza nodo:855 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(852)).appendChild((Element)v.get(855));

      /* Empieza nodo:856 / Elemento padre: 855   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(856)).setAttribute("nombre","lblValoresPosiblesTipoClasificacion" );
      ((Element)v.get(856)).setAttribute("alto","13" );
      ((Element)v.get(856)).setAttribute("filas","1" );
      ((Element)v.get(856)).setAttribute("valor","" );
      ((Element)v.get(856)).setAttribute("id","datosTitle" );
      ((Element)v.get(856)).setAttribute("cod","756" );
      ((Element)v.get(855)).appendChild((Element)v.get(856));
      /* Termina nodo:856   */
      /* Termina nodo:855   */

      /* Empieza nodo:857 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(852)).appendChild((Element)v.get(857));

      /* Empieza nodo:858 / Elemento padre: 857   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(858)).setAttribute("src","b.gif" );
      ((Element)v.get(858)).setAttribute("width","25" );
      ((Element)v.get(858)).setAttribute("height","8" );
      ((Element)v.get(857)).appendChild((Element)v.get(858));
      /* Termina nodo:858   */
      /* Termina nodo:857   */

      /* Empieza nodo:859 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(852)).appendChild((Element)v.get(859));

      /* Empieza nodo:860 / Elemento padre: 859   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(860)).setAttribute("nombre","lblValoresDefectoTipoClasificacion" );
      ((Element)v.get(860)).setAttribute("alto","13" );
      ((Element)v.get(860)).setAttribute("filas","1" );
      ((Element)v.get(860)).setAttribute("valor","" );
      ((Element)v.get(860)).setAttribute("id","datosTitle" );
      ((Element)v.get(860)).setAttribute("cod","1286" );
      ((Element)v.get(859)).appendChild((Element)v.get(860));
      /* Termina nodo:860   */
      /* Termina nodo:859   */

      /* Empieza nodo:861 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(861)).setAttribute("width","100%" );
      ((Element)v.get(852)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(862)).setAttribute("src","b.gif" );
      ((Element)v.get(862)).setAttribute("width","8" );
      ((Element)v.get(862)).setAttribute("height","8" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */
      /* Termina nodo:861   */
      /* Termina nodo:852   */

      /* Empieza nodo:863 / Elemento padre: 851   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(851)).appendChild((Element)v.get(863));

      /* Empieza nodo:864 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(863)).appendChild((Element)v.get(864));

      /* Empieza nodo:865 / Elemento padre: 864   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(865)).setAttribute("src","b.gif" );
      ((Element)v.get(865)).setAttribute("width","8" );
      ((Element)v.get(865)).setAttribute("height","8" );
      ((Element)v.get(864)).appendChild((Element)v.get(865));
      /* Termina nodo:865   */
      /* Termina nodo:864   */

      /* Empieza nodo:866 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(866)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(863)).appendChild((Element)v.get(866));

      /* Empieza nodo:867 / Elemento padre: 866   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(867)).setAttribute("nombre","cbValoresPosiblesTipoClasificacion" );
      ((Element)v.get(867)).setAttribute("onchange","tipoClasificacionOnChange();" );
      ((Element)v.get(867)).setAttribute("id","datosCampos" );
      ((Element)v.get(867)).setAttribute("size","5" );
      ((Element)v.get(867)).setAttribute("multiple","S" );
      ((Element)v.get(867)).setAttribute("req","N" );
      ((Element)v.get(867)).setAttribute("valorinicial","" );
      ((Element)v.get(867)).setAttribute("textoinicial","" );
      ((Element)v.get(866)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(867)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */
      /* Termina nodo:867   */
      /* Termina nodo:866   */

      /* Empieza nodo:869 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(863)).appendChild((Element)v.get(869));

      /* Empieza nodo:870 / Elemento padre: 869   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(870)).setAttribute("src","b.gif" );
      ((Element)v.get(870)).setAttribute("width","25" );
      ((Element)v.get(870)).setAttribute("height","8" );
      ((Element)v.get(869)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */
      /* Termina nodo:869   */

      /* Empieza nodo:871 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(871)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(871)).setAttribute("valign","top" );
      ((Element)v.get(863)).appendChild((Element)v.get(871));

      /* Empieza nodo:872 / Elemento padre: 871   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(872)).setAttribute("nombre","cbValoresDefectoTipoClasificacion" );
      ((Element)v.get(872)).setAttribute("id","datosCampos" );
      ((Element)v.get(872)).setAttribute("size","1" );
      ((Element)v.get(872)).setAttribute("multiple","N" );
      ((Element)v.get(872)).setAttribute("req","N" );
      ((Element)v.get(872)).setAttribute("valorinicial","" );
      ((Element)v.get(872)).setAttribute("textoinicial","" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(871)).appendChild((Element)v.get(872));

      /* Empieza nodo:873 / Elemento padre: 872   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(872)).appendChild((Element)v.get(873));
      /* Termina nodo:873   */
      /* Termina nodo:872   */
      /* Termina nodo:871   */

      /* Empieza nodo:874 / Elemento padre: 863   */
      v.add(doc.createElement("td"));
      ((Element)v.get(874)).setAttribute("width","100%" );
      ((Element)v.get(863)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(875)).setAttribute("src","b.gif" );
      ((Element)v.get(875)).setAttribute("width","8" );
      ((Element)v.get(875)).setAttribute("height","8" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */
      /* Termina nodo:874   */
      /* Termina nodo:863   */

      /* Empieza nodo:876 / Elemento padre: 851   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(851)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
      ((Element)v.get(877)).setAttribute("colspan","4" );
      ((Element)v.get(876)).appendChild((Element)v.get(877));

      /* Empieza nodo:878 / Elemento padre: 877   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(878)).setAttribute("src","b.gif" );
      ((Element)v.get(878)).setAttribute("width","8" );
      ((Element)v.get(878)).setAttribute("height","8" );
      ((Element)v.get(877)).appendChild((Element)v.get(878));
      /* Termina nodo:878   */
      /* Termina nodo:877   */
      /* Termina nodo:876   */
      /* Termina nodo:851   */

      /* Empieza nodo:879 / Elemento padre: 803   */
      v.add(doc.createElement("table"));
      ((Element)v.get(879)).setAttribute("width","100%" );
      ((Element)v.get(879)).setAttribute("border","0" );
      ((Element)v.get(879)).setAttribute("align","center" );
      ((Element)v.get(879)).setAttribute("cellspacing","0" );
      ((Element)v.get(879)).setAttribute("cellpadding","0" );
      ((Element)v.get(803)).appendChild((Element)v.get(879));

      /* Empieza nodo:880 / Elemento padre: 879   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(879)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(882)).setAttribute("src","b.gif" );
      ((Element)v.get(882)).setAttribute("width","8" );
      ((Element)v.get(882)).setAttribute("height","8" );
      ((Element)v.get(881)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */
      /* Termina nodo:881   */

      /* Empieza nodo:883 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(884)).setAttribute("nombre","lblValoresPosiblesClasificacion" );
      ((Element)v.get(884)).setAttribute("alto","13" );
      ((Element)v.get(884)).setAttribute("filas","1" );
      ((Element)v.get(884)).setAttribute("valor","" );
      ((Element)v.get(884)).setAttribute("id","datosTitle" );
      ((Element)v.get(884)).setAttribute("cod","611" );
      ((Element)v.get(883)).appendChild((Element)v.get(884));
      /* Termina nodo:884   */
      /* Termina nodo:883   */

      /* Empieza nodo:885 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).appendChild((Element)v.get(885));

      /* Empieza nodo:886 / Elemento padre: 885   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(886)).setAttribute("src","b.gif" );
      ((Element)v.get(886)).setAttribute("width","25" );
      ((Element)v.get(886)).setAttribute("height","8" );
      ((Element)v.get(885)).appendChild((Element)v.get(886));
      /* Termina nodo:886   */
      /* Termina nodo:885   */

      /* Empieza nodo:887 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(888)).setAttribute("nombre","lblValoresDefectoClasificacion" );
      ((Element)v.get(888)).setAttribute("alto","13" );
      ((Element)v.get(888)).setAttribute("filas","1" );
      ((Element)v.get(888)).setAttribute("valor","" );
      ((Element)v.get(888)).setAttribute("id","datosTitle" );
      ((Element)v.get(888)).setAttribute("cod","1286" );
      ((Element)v.get(887)).appendChild((Element)v.get(888));
      /* Termina nodo:888   */
      /* Termina nodo:887   */

      /* Empieza nodo:889 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(889)).setAttribute("width","100%" );
      ((Element)v.get(880)).appendChild((Element)v.get(889));

      /* Empieza nodo:890 / Elemento padre: 889   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(890)).setAttribute("src","b.gif" );
      ((Element)v.get(890)).setAttribute("width","8" );
      ((Element)v.get(890)).setAttribute("height","8" );
      ((Element)v.get(889)).appendChild((Element)v.get(890));
      /* Termina nodo:890   */
      /* Termina nodo:889   */
      /* Termina nodo:880   */

      /* Empieza nodo:891 / Elemento padre: 879   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(879)).appendChild((Element)v.get(891));

      /* Empieza nodo:892 / Elemento padre: 891   */
      v.add(doc.createElement("td"));
      ((Element)v.get(891)).appendChild((Element)v.get(892));

      /* Empieza nodo:893 / Elemento padre: 892   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(893)).setAttribute("src","b.gif" );
      ((Element)v.get(893)).setAttribute("width","8" );
      ((Element)v.get(893)).setAttribute("height","8" );
      ((Element)v.get(892)).appendChild((Element)v.get(893));
      /* Termina nodo:893   */
      /* Termina nodo:892   */

      /* Empieza nodo:894 / Elemento padre: 891   */
      v.add(doc.createElement("td"));
      ((Element)v.get(894)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(891)).appendChild((Element)v.get(894));

      /* Empieza nodo:895 / Elemento padre: 894   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(895)).setAttribute("nombre","cbValoresPosiblesClasificacion" );
      ((Element)v.get(895)).setAttribute("onchange","clasificacionOnChange();" );
      ((Element)v.get(895)).setAttribute("id","datosCampos" );
      ((Element)v.get(895)).setAttribute("size","5" );
      ((Element)v.get(895)).setAttribute("multiple","S" );
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(895)).setAttribute("req","N" );
      ((Element)v.get(895)).setAttribute("valorinicial","" );
      ((Element)v.get(895)).setAttribute("textoinicial","" );
      ((Element)v.get(894)).appendChild((Element)v.get(895));

      /* Empieza nodo:896 / Elemento padre: 895   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(895)).appendChild((Element)v.get(896));
      /* Termina nodo:896   */
      /* Termina nodo:895   */
      /* Termina nodo:894   */

      /* Empieza nodo:897 / Elemento padre: 891   */
      v.add(doc.createElement("td"));
      ((Element)v.get(891)).appendChild((Element)v.get(897));

      /* Empieza nodo:898 / Elemento padre: 897   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(898)).setAttribute("src","b.gif" );
      ((Element)v.get(898)).setAttribute("width","25" );
      ((Element)v.get(898)).setAttribute("height","8" );
      ((Element)v.get(897)).appendChild((Element)v.get(898));
      /* Termina nodo:898   */
      /* Termina nodo:897   */

      /* Empieza nodo:899 / Elemento padre: 891   */
      v.add(doc.createElement("td"));
      ((Element)v.get(899)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(899)).setAttribute("valign","top" );
      ((Element)v.get(891)).appendChild((Element)v.get(899));

      /* Empieza nodo:900 / Elemento padre: 899   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(900)).setAttribute("nombre","cbValoresDefectoClasificacion" );
      ((Element)v.get(900)).setAttribute("id","datosCampos" );
      ((Element)v.get(900)).setAttribute("size","1" );
      ((Element)v.get(900)).setAttribute("multiple","N" );
      ((Element)v.get(900)).setAttribute("req","N" );
      ((Element)v.get(900)).setAttribute("valorinicial","" );
      ((Element)v.get(900)).setAttribute("textoinicial","" );
      ((Element)v.get(899)).appendChild((Element)v.get(900));

      /* Empieza nodo:901 / Elemento padre: 900   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(900)).appendChild((Element)v.get(901));
      /* Termina nodo:901   */
      /* Termina nodo:900   */
      /* Termina nodo:899   */

      /* Empieza nodo:902 / Elemento padre: 891   */
      v.add(doc.createElement("td"));
      ((Element)v.get(902)).setAttribute("width","100%" );
      ((Element)v.get(891)).appendChild((Element)v.get(902));

      /* Empieza nodo:903 / Elemento padre: 902   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(903)).setAttribute("src","b.gif" );
      ((Element)v.get(903)).setAttribute("width","8" );
      ((Element)v.get(903)).setAttribute("height","8" );
      ((Element)v.get(902)).appendChild((Element)v.get(903));
      /* Termina nodo:903   */
      /* Termina nodo:902   */
      /* Termina nodo:891   */

      /* Empieza nodo:904 / Elemento padre: 879   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(879)).appendChild((Element)v.get(904));

      /* Empieza nodo:905 / Elemento padre: 904   */
      v.add(doc.createElement("td"));
      ((Element)v.get(905)).setAttribute("colspan","4" );
      ((Element)v.get(904)).appendChild((Element)v.get(905));

      /* Empieza nodo:906 / Elemento padre: 905   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(906)).setAttribute("src","b.gif" );
      ((Element)v.get(906)).setAttribute("width","8" );
      ((Element)v.get(906)).setAttribute("height","8" );
      ((Element)v.get(905)).appendChild((Element)v.get(906));
      /* Termina nodo:906   */
      /* Termina nodo:905   */
      /* Termina nodo:904   */
      /* Termina nodo:879   */
      /* Termina nodo:803   */
      /* Termina nodo:802   */

      /* Empieza nodo:907 / Elemento padre: 799   */
      v.add(doc.createElement("td"));
      ((Element)v.get(799)).appendChild((Element)v.get(907));

      /* Empieza nodo:908 / Elemento padre: 907   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(908)).setAttribute("src","b.gif" );
      ((Element)v.get(907)).appendChild((Element)v.get(908));
      /* Termina nodo:908   */
      /* Termina nodo:907   */
      /* Termina nodo:799   */

      /* Empieza nodo:909 / Elemento padre: 798   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(798)).appendChild((Element)v.get(909));

      /* Empieza nodo:910 / Elemento padre: 909   */
      v.add(doc.createElement("td"));
      ((Element)v.get(910)).setAttribute("width","12" );
      ((Element)v.get(910)).setAttribute("align","center" );
      ((Element)v.get(909)).appendChild((Element)v.get(910));

      /* Empieza nodo:911 / Elemento padre: 910   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(911)).setAttribute("src","b.gif" );
      ((Element)v.get(911)).setAttribute("width","12" );
      ((Element)v.get(911)).setAttribute("height","15" );
      ((Element)v.get(910)).appendChild((Element)v.get(911));
      /* Termina nodo:911   */
      /* Termina nodo:910   */

      /* Empieza nodo:912 / Elemento padre: 909   */
      v.add(doc.createElement("td"));
      ((Element)v.get(912)).setAttribute("width","756" );
      ((Element)v.get(909)).appendChild((Element)v.get(912));

      /* Empieza nodo:913 / Elemento padre: 912   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(913)).setAttribute("src","b.gif" );
      ((Element)v.get(912)).appendChild((Element)v.get(913));
      /* Termina nodo:913   */
      /* Termina nodo:912   */

      /* Empieza nodo:914 / Elemento padre: 909   */
      v.add(doc.createElement("td"));
      ((Element)v.get(914)).setAttribute("width","12" );
      ((Element)v.get(909)).appendChild((Element)v.get(914));

      /* Empieza nodo:915 / Elemento padre: 914   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(915)).setAttribute("src","b.gif" );
      ((Element)v.get(915)).setAttribute("width","12" );
      ((Element)v.get(915)).setAttribute("height","1" );
      ((Element)v.get(914)).appendChild((Element)v.get(915));
      /* Termina nodo:915   */
      /* Termina nodo:914   */
      /* Termina nodo:909   */
      /* Termina nodo:798   */

      /* Empieza nodo:916 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(916)).setAttribute("width","100%" );
      ((Element)v.get(916)).setAttribute("border","0" );
      ((Element)v.get(916)).setAttribute("align","center" );
      ((Element)v.get(916)).setAttribute("cellspacing","0" );
      ((Element)v.get(916)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(916));

      /* Empieza nodo:917 / Elemento padre: 916   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(916)).appendChild((Element)v.get(917));

      /* Empieza nodo:918 / Elemento padre: 917   */
      v.add(doc.createElement("td"));
      ((Element)v.get(917)).appendChild((Element)v.get(918));

      /* Empieza nodo:919 / Elemento padre: 918   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(919)).setAttribute("src","b.gif" );
      ((Element)v.get(919)).setAttribute("width","8" );
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(919)).setAttribute("height","8" );
      ((Element)v.get(918)).appendChild((Element)v.get(919));
      /* Termina nodo:919   */
      /* Termina nodo:918   */

      /* Empieza nodo:920 / Elemento padre: 917   */
      v.add(doc.createElement("td"));
      ((Element)v.get(920)).setAttribute("width","100%" );
      ((Element)v.get(917)).appendChild((Element)v.get(920));

      /* Empieza nodo:921 / Elemento padre: 920   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(920)).appendChild((Element)v.get(921));

      /* Empieza nodo:922 / Elemento padre: 921   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(922)).setAttribute("class","legend" );
      ((Element)v.get(921)).appendChild((Element)v.get(922));

      /* Empieza nodo:923 / Elemento padre: 922   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(923)).setAttribute("nombre","lblDescuentosCliente" );
      ((Element)v.get(923)).setAttribute("alto","13" );
      ((Element)v.get(923)).setAttribute("filas","1" );
      ((Element)v.get(923)).setAttribute("valor","" );
      ((Element)v.get(923)).setAttribute("id","legend" );
      ((Element)v.get(923)).setAttribute("cod","00473" );
      ((Element)v.get(922)).appendChild((Element)v.get(923));
      /* Termina nodo:923   */
      /* Termina nodo:922   */

      /* Empieza nodo:924 / Elemento padre: 921   */
      v.add(doc.createElement("table"));
      ((Element)v.get(924)).setAttribute("width","100%" );
      ((Element)v.get(924)).setAttribute("border","0" );
      ((Element)v.get(924)).setAttribute("align","center" );
      ((Element)v.get(924)).setAttribute("cellspacing","0" );
      ((Element)v.get(924)).setAttribute("cellpadding","0" );
      ((Element)v.get(921)).appendChild((Element)v.get(924));

      /* Empieza nodo:925 / Elemento padre: 924   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(924)).appendChild((Element)v.get(925));

      /* Empieza nodo:926 / Elemento padre: 925   */
      v.add(doc.createElement("td"));
      ((Element)v.get(926)).setAttribute("colspan","3" );
      ((Element)v.get(925)).appendChild((Element)v.get(926));

      /* Empieza nodo:927 / Elemento padre: 926   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(927)).setAttribute("src","b.gif" );
      ((Element)v.get(927)).setAttribute("width","8" );
      ((Element)v.get(927)).setAttribute("height","8" );
      ((Element)v.get(926)).appendChild((Element)v.get(927));
      /* Termina nodo:927   */
      /* Termina nodo:926   */
      /* Termina nodo:925   */

      /* Empieza nodo:928 / Elemento padre: 924   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(924)).appendChild((Element)v.get(928));

      /* Empieza nodo:929 / Elemento padre: 928   */
      v.add(doc.createElement("td"));
      ((Element)v.get(928)).appendChild((Element)v.get(929));

      /* Empieza nodo:930 / Elemento padre: 929   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(930)).setAttribute("src","b.gif" );
      ((Element)v.get(930)).setAttribute("width","8" );
      ((Element)v.get(930)).setAttribute("height","8" );
      ((Element)v.get(929)).appendChild((Element)v.get(930));
      /* Termina nodo:930   */
      /* Termina nodo:929   */

      /* Empieza nodo:931 / Elemento padre: 928   */
      v.add(doc.createElement("td"));
      ((Element)v.get(928)).appendChild((Element)v.get(931));

      /* Empieza nodo:932 / Elemento padre: 931   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(932)).setAttribute("nombre","lblCodigoDescuentosCliente" );
      ((Element)v.get(932)).setAttribute("alto","13" );
      ((Element)v.get(932)).setAttribute("filas","1" );
      ((Element)v.get(932)).setAttribute("valor","" );
      ((Element)v.get(932)).setAttribute("id","datosTitle" );
      ((Element)v.get(932)).setAttribute("cod","8" );
      ((Element)v.get(931)).appendChild((Element)v.get(932));
      /* Termina nodo:932   */
      /* Termina nodo:931   */

      /* Empieza nodo:933 / Elemento padre: 928   */
      v.add(doc.createElement("td"));
      ((Element)v.get(928)).appendChild((Element)v.get(933));

      /* Empieza nodo:934 / Elemento padre: 933   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(934)).setAttribute("src","b.gif" );
      ((Element)v.get(934)).setAttribute("width","25" );
      ((Element)v.get(934)).setAttribute("height","8" );
      ((Element)v.get(933)).appendChild((Element)v.get(934));
      /* Termina nodo:934   */
      /* Termina nodo:933   */

      /* Empieza nodo:935 / Elemento padre: 928   */
      v.add(doc.createElement("td"));
      ((Element)v.get(928)).appendChild((Element)v.get(935));

      /* Empieza nodo:936 / Elemento padre: 935   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(936)).setAttribute("nombre","lblVisibleDescuentosCliente" );
      ((Element)v.get(936)).setAttribute("alto","13" );
      ((Element)v.get(936)).setAttribute("filas","1" );
      ((Element)v.get(936)).setAttribute("valor","" );
      ((Element)v.get(936)).setAttribute("id","datosTitle" );
      ((Element)v.get(936)).setAttribute("cod","1038" );
      ((Element)v.get(935)).appendChild((Element)v.get(936));
      /* Termina nodo:936   */
      /* Termina nodo:935   */

      /* Empieza nodo:937 / Elemento padre: 928   */
      v.add(doc.createElement("td"));
      ((Element)v.get(928)).appendChild((Element)v.get(937));

      /* Empieza nodo:938 / Elemento padre: 937   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(938)).setAttribute("src","b.gif" );
      ((Element)v.get(938)).setAttribute("width","25" );
      ((Element)v.get(938)).setAttribute("height","8" );
      ((Element)v.get(937)).appendChild((Element)v.get(938));
      /* Termina nodo:938   */
      /* Termina nodo:937   */

      /* Empieza nodo:939 / Elemento padre: 928   */
      v.add(doc.createElement("td"));
      ((Element)v.get(928)).appendChild((Element)v.get(939));

      /* Empieza nodo:940 / Elemento padre: 939   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(940)).setAttribute("nombre","lblObligatorioDescuentosCliente" );
      ((Element)v.get(940)).setAttribute("alto","13" );
      ((Element)v.get(940)).setAttribute("filas","1" );
      ((Element)v.get(940)).setAttribute("valor","" );
      ((Element)v.get(940)).setAttribute("id","datosTitle" );
      ((Element)v.get(940)).setAttribute("cod","949" );
      ((Element)v.get(939)).appendChild((Element)v.get(940));
      /* Termina nodo:940   */
      /* Termina nodo:939   */

      /* Empieza nodo:941 / Elemento padre: 928   */
      v.add(doc.createElement("td"));
      ((Element)v.get(928)).appendChild((Element)v.get(941));

      /* Empieza nodo:942 / Elemento padre: 941   */
   }

   private void getXML3780(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(942)).setAttribute("src","b.gif" );
      ((Element)v.get(942)).setAttribute("width","25" );
      ((Element)v.get(942)).setAttribute("height","8" );
      ((Element)v.get(941)).appendChild((Element)v.get(942));
      /* Termina nodo:942   */
      /* Termina nodo:941   */

      /* Empieza nodo:943 / Elemento padre: 928   */
      v.add(doc.createElement("td"));
      ((Element)v.get(928)).appendChild((Element)v.get(943));

      /* Empieza nodo:944 / Elemento padre: 943   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(944)).setAttribute("nombre","lblModificableDescuentosCliente" );
      ((Element)v.get(944)).setAttribute("alto","13" );
      ((Element)v.get(944)).setAttribute("filas","1" );
      ((Element)v.get(944)).setAttribute("valor","" );
      ((Element)v.get(944)).setAttribute("id","datosTitle" );
      ((Element)v.get(944)).setAttribute("cod","914" );
      ((Element)v.get(943)).appendChild((Element)v.get(944));
      /* Termina nodo:944   */
      /* Termina nodo:943   */

      /* Empieza nodo:945 / Elemento padre: 928   */
      v.add(doc.createElement("td"));
      ((Element)v.get(945)).setAttribute("width","100%" );
      ((Element)v.get(928)).appendChild((Element)v.get(945));

      /* Empieza nodo:946 / Elemento padre: 945   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(946)).setAttribute("src","b.gif" );
      ((Element)v.get(946)).setAttribute("width","8" );
      ((Element)v.get(946)).setAttribute("height","8" );
      ((Element)v.get(945)).appendChild((Element)v.get(946));
      /* Termina nodo:946   */
      /* Termina nodo:945   */
      /* Termina nodo:928   */

      /* Empieza nodo:947 / Elemento padre: 924   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(924)).appendChild((Element)v.get(947));

      /* Empieza nodo:948 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(947)).appendChild((Element)v.get(948));

      /* Empieza nodo:949 / Elemento padre: 948   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(949)).setAttribute("src","b.gif" );
      ((Element)v.get(949)).setAttribute("width","8" );
      ((Element)v.get(949)).setAttribute("height","8" );
      ((Element)v.get(948)).appendChild((Element)v.get(949));
      /* Termina nodo:949   */
      /* Termina nodo:948   */

      /* Empieza nodo:950 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(947)).appendChild((Element)v.get(950));

      /* Empieza nodo:951 / Elemento padre: 950   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(951)).setAttribute("nombre","lbldtCodigoDescuentosCliente" );
      ((Element)v.get(951)).setAttribute("alto","13" );
      ((Element)v.get(951)).setAttribute("filas","1" );
      ((Element)v.get(951)).setAttribute("valor","11" );
      ((Element)v.get(951)).setAttribute("id","datosCampos" );
      ((Element)v.get(950)).appendChild((Element)v.get(951));
      /* Termina nodo:951   */
      /* Termina nodo:950   */

      /* Empieza nodo:952 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(947)).appendChild((Element)v.get(952));

      /* Empieza nodo:953 / Elemento padre: 952   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(953)).setAttribute("src","b.gif" );
      ((Element)v.get(953)).setAttribute("width","25" );
      ((Element)v.get(953)).setAttribute("height","8" );
      ((Element)v.get(952)).appendChild((Element)v.get(953));
      /* Termina nodo:953   */
      /* Termina nodo:952   */

      /* Empieza nodo:954 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(947)).appendChild((Element)v.get(954));

      /* Empieza nodo:955 / Elemento padre: 954   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(955)).setAttribute("nombre","ckVisibleDescuentosCliente" );
      ((Element)v.get(955)).setAttribute("id","datosCampos" );
      ((Element)v.get(955)).setAttribute("onclick","cambiaObli(9)" );
      ((Element)v.get(955)).setAttribute("check","S" );
      ((Element)v.get(954)).appendChild((Element)v.get(955));
      /* Termina nodo:955   */
      /* Termina nodo:954   */

      /* Empieza nodo:956 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(947)).appendChild((Element)v.get(956));

      /* Empieza nodo:957 / Elemento padre: 956   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(957)).setAttribute("src","b.gif" );
      ((Element)v.get(957)).setAttribute("width","25" );
      ((Element)v.get(957)).setAttribute("height","8" );
      ((Element)v.get(956)).appendChild((Element)v.get(957));
      /* Termina nodo:957   */
      /* Termina nodo:956   */

      /* Empieza nodo:958 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(947)).appendChild((Element)v.get(958));

      /* Empieza nodo:959 / Elemento padre: 958   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(959)).setAttribute("nombre","ckObligatorioDescuentosCliente" );
      ((Element)v.get(959)).setAttribute("id","datosCampos" );
      ((Element)v.get(959)).setAttribute("onclick","" );
      ((Element)v.get(959)).setAttribute("check","N" );
      ((Element)v.get(958)).appendChild((Element)v.get(959));
      /* Termina nodo:959   */
      /* Termina nodo:958   */

      /* Empieza nodo:960 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(947)).appendChild((Element)v.get(960));

      /* Empieza nodo:961 / Elemento padre: 960   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(961)).setAttribute("src","b.gif" );
      ((Element)v.get(961)).setAttribute("width","25" );
      ((Element)v.get(961)).setAttribute("height","8" );
      ((Element)v.get(960)).appendChild((Element)v.get(961));
      /* Termina nodo:961   */
      /* Termina nodo:960   */

      /* Empieza nodo:962 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(947)).appendChild((Element)v.get(962));

      /* Empieza nodo:963 / Elemento padre: 962   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(963)).setAttribute("nombre","ckModificableDescuentosCliente" );
      ((Element)v.get(963)).setAttribute("id","datosCampos" );
      ((Element)v.get(963)).setAttribute("onclick","" );
      ((Element)v.get(963)).setAttribute("check","S" );
      ((Element)v.get(962)).appendChild((Element)v.get(963));
      /* Termina nodo:963   */
      /* Termina nodo:962   */

      /* Empieza nodo:964 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(964)).setAttribute("width","100%" );
      ((Element)v.get(947)).appendChild((Element)v.get(964));

      /* Empieza nodo:965 / Elemento padre: 964   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3870(Document doc) {
      ((Element)v.get(965)).setAttribute("src","b.gif" );
      ((Element)v.get(965)).setAttribute("width","8" );
      ((Element)v.get(965)).setAttribute("height","8" );
      ((Element)v.get(964)).appendChild((Element)v.get(965));
      /* Termina nodo:965   */
      /* Termina nodo:964   */
      /* Termina nodo:947   */

      /* Empieza nodo:966 / Elemento padre: 924   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(924)).appendChild((Element)v.get(966));

      /* Empieza nodo:967 / Elemento padre: 966   */
      v.add(doc.createElement("td"));
      ((Element)v.get(967)).setAttribute("colspan","4" );
      ((Element)v.get(966)).appendChild((Element)v.get(967));

      /* Empieza nodo:968 / Elemento padre: 967   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(968)).setAttribute("src","b.gif" );
      ((Element)v.get(968)).setAttribute("width","8" );
      ((Element)v.get(968)).setAttribute("height","8" );
      ((Element)v.get(967)).appendChild((Element)v.get(968));
      /* Termina nodo:968   */
      /* Termina nodo:967   */
      /* Termina nodo:966   */
      /* Termina nodo:924   */
      /* Termina nodo:921   */
      /* Termina nodo:920   */

      /* Empieza nodo:969 / Elemento padre: 917   */
      v.add(doc.createElement("td"));
      ((Element)v.get(917)).appendChild((Element)v.get(969));

      /* Empieza nodo:970 / Elemento padre: 969   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(970)).setAttribute("src","b.gif" );
      ((Element)v.get(969)).appendChild((Element)v.get(970));
      /* Termina nodo:970   */
      /* Termina nodo:969   */
      /* Termina nodo:917   */

      /* Empieza nodo:971 / Elemento padre: 916   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(916)).appendChild((Element)v.get(971));

      /* Empieza nodo:972 / Elemento padre: 971   */
      v.add(doc.createElement("td"));
      ((Element)v.get(972)).setAttribute("width","12" );
      ((Element)v.get(972)).setAttribute("align","center" );
      ((Element)v.get(971)).appendChild((Element)v.get(972));

      /* Empieza nodo:973 / Elemento padre: 972   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(973)).setAttribute("src","b.gif" );
      ((Element)v.get(973)).setAttribute("width","12" );
      ((Element)v.get(973)).setAttribute("height","15" );
      ((Element)v.get(972)).appendChild((Element)v.get(973));
      /* Termina nodo:973   */
      /* Termina nodo:972   */

      /* Empieza nodo:974 / Elemento padre: 971   */
      v.add(doc.createElement("td"));
      ((Element)v.get(974)).setAttribute("width","756" );
      ((Element)v.get(971)).appendChild((Element)v.get(974));

      /* Empieza nodo:975 / Elemento padre: 974   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(975)).setAttribute("src","b.gif" );
      ((Element)v.get(974)).appendChild((Element)v.get(975));
      /* Termina nodo:975   */
      /* Termina nodo:974   */

      /* Empieza nodo:976 / Elemento padre: 971   */
      v.add(doc.createElement("td"));
      ((Element)v.get(976)).setAttribute("width","12" );
      ((Element)v.get(971)).appendChild((Element)v.get(976));

      /* Empieza nodo:977 / Elemento padre: 976   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(977)).setAttribute("src","b.gif" );
      ((Element)v.get(977)).setAttribute("width","12" );
      ((Element)v.get(977)).setAttribute("height","1" );
      ((Element)v.get(976)).appendChild((Element)v.get(977));
      /* Termina nodo:977   */
      /* Termina nodo:976   */
      /* Termina nodo:971   */
      /* Termina nodo:916   */

      /* Empieza nodo:978 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(978)).setAttribute("width","100%" );
      ((Element)v.get(978)).setAttribute("border","0" );
      ((Element)v.get(978)).setAttribute("align","center" );
      ((Element)v.get(978)).setAttribute("cellspacing","0" );
      ((Element)v.get(978)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(978));

      /* Empieza nodo:979 / Elemento padre: 978   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(978)).appendChild((Element)v.get(979));

      /* Empieza nodo:980 / Elemento padre: 979   */
      v.add(doc.createElement("td"));
      ((Element)v.get(979)).appendChild((Element)v.get(980));

      /* Empieza nodo:981 / Elemento padre: 980   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(981)).setAttribute("src","b.gif" );
      ((Element)v.get(981)).setAttribute("width","8" );
      ((Element)v.get(981)).setAttribute("height","8" );
      ((Element)v.get(980)).appendChild((Element)v.get(981));
      /* Termina nodo:981   */
      /* Termina nodo:980   */

      /* Empieza nodo:982 / Elemento padre: 979   */
      v.add(doc.createElement("td"));
      ((Element)v.get(982)).setAttribute("width","100%" );
      ((Element)v.get(979)).appendChild((Element)v.get(982));

      /* Empieza nodo:983 / Elemento padre: 982   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(982)).appendChild((Element)v.get(983));

      /* Empieza nodo:984 / Elemento padre: 983   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(984)).setAttribute("class","legend" );
      ((Element)v.get(983)).appendChild((Element)v.get(984));

      /* Empieza nodo:985 / Elemento padre: 984   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(985)).setAttribute("nombre","lblAlcanceAdministrativoDescuento" );
      ((Element)v.get(985)).setAttribute("alto","13" );
      ((Element)v.get(985)).setAttribute("filas","1" );
      ((Element)v.get(985)).setAttribute("valor","" );
      ((Element)v.get(985)).setAttribute("id","legend" );
      ((Element)v.get(985)).setAttribute("cod","00474" );
      ((Element)v.get(984)).appendChild((Element)v.get(985));
      /* Termina nodo:985   */
      /* Termina nodo:984   */

      /* Empieza nodo:986 / Elemento padre: 983   */
      v.add(doc.createElement("table"));
      ((Element)v.get(986)).setAttribute("width","100%" );
      ((Element)v.get(986)).setAttribute("border","0" );
      ((Element)v.get(986)).setAttribute("align","center" );
      ((Element)v.get(986)).setAttribute("cellspacing","0" );
      ((Element)v.get(986)).setAttribute("cellpadding","0" );
      ((Element)v.get(983)).appendChild((Element)v.get(986));

      /* Empieza nodo:987 / Elemento padre: 986   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(986)).appendChild((Element)v.get(987));

      /* Empieza nodo:988 / Elemento padre: 987   */
      v.add(doc.createElement("td"));
      ((Element)v.get(988)).setAttribute("colspan","3" );
      ((Element)v.get(987)).appendChild((Element)v.get(988));

      /* Empieza nodo:989 / Elemento padre: 988   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(989)).setAttribute("src","b.gif" );
   }

   private void getXML3960(Document doc) {
      ((Element)v.get(989)).setAttribute("width","8" );
      ((Element)v.get(989)).setAttribute("height","8" );
      ((Element)v.get(988)).appendChild((Element)v.get(989));
      /* Termina nodo:989   */
      /* Termina nodo:988   */
      /* Termina nodo:987   */

      /* Empieza nodo:990 / Elemento padre: 986   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(986)).appendChild((Element)v.get(990));

      /* Empieza nodo:991 / Elemento padre: 990   */
      v.add(doc.createElement("td"));
      ((Element)v.get(990)).appendChild((Element)v.get(991));

      /* Empieza nodo:992 / Elemento padre: 991   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(992)).setAttribute("src","b.gif" );
      ((Element)v.get(992)).setAttribute("width","8" );
      ((Element)v.get(992)).setAttribute("height","8" );
      ((Element)v.get(991)).appendChild((Element)v.get(992));
      /* Termina nodo:992   */
      /* Termina nodo:991   */

      /* Empieza nodo:993 / Elemento padre: 990   */
      v.add(doc.createElement("td"));
      ((Element)v.get(990)).appendChild((Element)v.get(993));

      /* Empieza nodo:994 / Elemento padre: 993   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(994)).setAttribute("nombre","lblCodigoAlcanceAdministrativoDescuento" );
      ((Element)v.get(994)).setAttribute("alto","13" );
      ((Element)v.get(994)).setAttribute("filas","1" );
      ((Element)v.get(994)).setAttribute("valor","" );
      ((Element)v.get(994)).setAttribute("id","datosTitle" );
      ((Element)v.get(994)).setAttribute("cod","8" );
      ((Element)v.get(993)).appendChild((Element)v.get(994));
      /* Termina nodo:994   */
      /* Termina nodo:993   */

      /* Empieza nodo:995 / Elemento padre: 990   */
      v.add(doc.createElement("td"));
      ((Element)v.get(990)).appendChild((Element)v.get(995));

      /* Empieza nodo:996 / Elemento padre: 995   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(996)).setAttribute("src","b.gif" );
      ((Element)v.get(996)).setAttribute("width","25" );
      ((Element)v.get(996)).setAttribute("height","8" );
      ((Element)v.get(995)).appendChild((Element)v.get(996));
      /* Termina nodo:996   */
      /* Termina nodo:995   */

      /* Empieza nodo:997 / Elemento padre: 990   */
      v.add(doc.createElement("td"));
      ((Element)v.get(990)).appendChild((Element)v.get(997));

      /* Empieza nodo:998 / Elemento padre: 997   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(998)).setAttribute("nombre","lblVisibleAlcanceAdministrativoDescuento" );
      ((Element)v.get(998)).setAttribute("alto","13" );
      ((Element)v.get(998)).setAttribute("filas","1" );
      ((Element)v.get(998)).setAttribute("valor","" );
      ((Element)v.get(998)).setAttribute("id","datosTitle" );
      ((Element)v.get(998)).setAttribute("cod","1038" );
      ((Element)v.get(997)).appendChild((Element)v.get(998));
      /* Termina nodo:998   */
      /* Termina nodo:997   */

      /* Empieza nodo:999 / Elemento padre: 990   */
      v.add(doc.createElement("td"));
      ((Element)v.get(990)).appendChild((Element)v.get(999));

      /* Empieza nodo:1000 / Elemento padre: 999   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1000)).setAttribute("src","b.gif" );
      ((Element)v.get(1000)).setAttribute("width","25" );
      ((Element)v.get(1000)).setAttribute("height","8" );
      ((Element)v.get(999)).appendChild((Element)v.get(1000));
      /* Termina nodo:1000   */
      /* Termina nodo:999   */

      /* Empieza nodo:1001 / Elemento padre: 990   */
      v.add(doc.createElement("td"));
      ((Element)v.get(990)).appendChild((Element)v.get(1001));

      /* Empieza nodo:1002 / Elemento padre: 1001   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1002)).setAttribute("nombre","lblObligatorioAlcanceAdministrativoDescuento" );
      ((Element)v.get(1002)).setAttribute("alto","13" );
      ((Element)v.get(1002)).setAttribute("filas","1" );
      ((Element)v.get(1002)).setAttribute("valor","" );
      ((Element)v.get(1002)).setAttribute("id","datosTitle" );
      ((Element)v.get(1002)).setAttribute("cod","949" );
      ((Element)v.get(1001)).appendChild((Element)v.get(1002));
      /* Termina nodo:1002   */
      /* Termina nodo:1001   */

      /* Empieza nodo:1003 / Elemento padre: 990   */
      v.add(doc.createElement("td"));
      ((Element)v.get(990)).appendChild((Element)v.get(1003));

      /* Empieza nodo:1004 / Elemento padre: 1003   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1004)).setAttribute("src","b.gif" );
      ((Element)v.get(1004)).setAttribute("width","25" );
      ((Element)v.get(1004)).setAttribute("height","8" );
      ((Element)v.get(1003)).appendChild((Element)v.get(1004));
      /* Termina nodo:1004   */
      /* Termina nodo:1003   */

      /* Empieza nodo:1005 / Elemento padre: 990   */
      v.add(doc.createElement("td"));
      ((Element)v.get(990)).appendChild((Element)v.get(1005));

      /* Empieza nodo:1006 / Elemento padre: 1005   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1006)).setAttribute("nombre","lblModificableAlcanceAdministrativoDescuento" );
      ((Element)v.get(1006)).setAttribute("alto","13" );
      ((Element)v.get(1006)).setAttribute("filas","1" );
      ((Element)v.get(1006)).setAttribute("valor","" );
      ((Element)v.get(1006)).setAttribute("id","datosTitle" );
      ((Element)v.get(1006)).setAttribute("cod","914" );
      ((Element)v.get(1005)).appendChild((Element)v.get(1006));
      /* Termina nodo:1006   */
      /* Termina nodo:1005   */

      /* Empieza nodo:1007 / Elemento padre: 990   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1007)).setAttribute("width","100%" );
      ((Element)v.get(990)).appendChild((Element)v.get(1007));

      /* Empieza nodo:1008 / Elemento padre: 1007   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1008)).setAttribute("src","b.gif" );
      ((Element)v.get(1008)).setAttribute("width","8" );
      ((Element)v.get(1008)).setAttribute("height","8" );
      ((Element)v.get(1007)).appendChild((Element)v.get(1008));
      /* Termina nodo:1008   */
      /* Termina nodo:1007   */
      /* Termina nodo:990   */

      /* Empieza nodo:1009 / Elemento padre: 986   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(986)).appendChild((Element)v.get(1009));

      /* Empieza nodo:1010 / Elemento padre: 1009   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1009)).appendChild((Element)v.get(1010));

      /* Empieza nodo:1011 / Elemento padre: 1010   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1011)).setAttribute("src","b.gif" );
      ((Element)v.get(1011)).setAttribute("width","8" );
      ((Element)v.get(1011)).setAttribute("height","8" );
      ((Element)v.get(1010)).appendChild((Element)v.get(1011));
      /* Termina nodo:1011   */
      /* Termina nodo:1010   */

      /* Empieza nodo:1012 / Elemento padre: 1009   */
   }

   private void getXML4050(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(1009)).appendChild((Element)v.get(1012));

      /* Empieza nodo:1013 / Elemento padre: 1012   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1013)).setAttribute("nombre","lbldtCodigoAlcanceAdministrativoDescuento" );
      ((Element)v.get(1013)).setAttribute("alto","13" );
      ((Element)v.get(1013)).setAttribute("filas","1" );
      ((Element)v.get(1013)).setAttribute("valor","12" );
      ((Element)v.get(1013)).setAttribute("id","datosCampos" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1013));
      /* Termina nodo:1013   */
      /* Termina nodo:1012   */

      /* Empieza nodo:1014 / Elemento padre: 1009   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1009)).appendChild((Element)v.get(1014));

      /* Empieza nodo:1015 / Elemento padre: 1014   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1015)).setAttribute("src","b.gif" );
      ((Element)v.get(1015)).setAttribute("width","25" );
      ((Element)v.get(1015)).setAttribute("height","8" );
      ((Element)v.get(1014)).appendChild((Element)v.get(1015));
      /* Termina nodo:1015   */
      /* Termina nodo:1014   */

      /* Empieza nodo:1016 / Elemento padre: 1009   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1009)).appendChild((Element)v.get(1016));

      /* Empieza nodo:1017 / Elemento padre: 1016   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1017)).setAttribute("nombre","ckVisibleAlcanceAdministrativoDescuento" );
      ((Element)v.get(1017)).setAttribute("id","datosCampos" );
      ((Element)v.get(1017)).setAttribute("onclick","cambiaObli(10)" );
      ((Element)v.get(1017)).setAttribute("check","S" );
      ((Element)v.get(1016)).appendChild((Element)v.get(1017));
      /* Termina nodo:1017   */
      /* Termina nodo:1016   */

      /* Empieza nodo:1018 / Elemento padre: 1009   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1009)).appendChild((Element)v.get(1018));

      /* Empieza nodo:1019 / Elemento padre: 1018   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1019)).setAttribute("src","b.gif" );
      ((Element)v.get(1019)).setAttribute("width","25" );
      ((Element)v.get(1019)).setAttribute("height","8" );
      ((Element)v.get(1018)).appendChild((Element)v.get(1019));
      /* Termina nodo:1019   */
      /* Termina nodo:1018   */

      /* Empieza nodo:1020 / Elemento padre: 1009   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1009)).appendChild((Element)v.get(1020));

      /* Empieza nodo:1021 / Elemento padre: 1020   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1021)).setAttribute("nombre","ckObligatorioAlcanceAdministrativoDescuento" );
      ((Element)v.get(1021)).setAttribute("id","datosCampos" );
      ((Element)v.get(1021)).setAttribute("onclick","" );
      ((Element)v.get(1021)).setAttribute("check","S" );
      ((Element)v.get(1020)).appendChild((Element)v.get(1021));
      /* Termina nodo:1021   */
      /* Termina nodo:1020   */

      /* Empieza nodo:1022 / Elemento padre: 1009   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1009)).appendChild((Element)v.get(1022));

      /* Empieza nodo:1023 / Elemento padre: 1022   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1023)).setAttribute("src","b.gif" );
      ((Element)v.get(1023)).setAttribute("width","25" );
      ((Element)v.get(1023)).setAttribute("height","8" );
      ((Element)v.get(1022)).appendChild((Element)v.get(1023));
      /* Termina nodo:1023   */
      /* Termina nodo:1022   */

      /* Empieza nodo:1024 / Elemento padre: 1009   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1009)).appendChild((Element)v.get(1024));

      /* Empieza nodo:1025 / Elemento padre: 1024   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1025)).setAttribute("nombre","ckModificableAlcanceAdministrativoDescuento" );
      ((Element)v.get(1025)).setAttribute("id","datosCampos" );
      ((Element)v.get(1025)).setAttribute("onclick","" );
      ((Element)v.get(1025)).setAttribute("check","S" );
      ((Element)v.get(1024)).appendChild((Element)v.get(1025));
      /* Termina nodo:1025   */
      /* Termina nodo:1024   */

      /* Empieza nodo:1026 / Elemento padre: 1009   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1026)).setAttribute("width","100%" );
      ((Element)v.get(1009)).appendChild((Element)v.get(1026));

      /* Empieza nodo:1027 / Elemento padre: 1026   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1027)).setAttribute("src","b.gif" );
      ((Element)v.get(1027)).setAttribute("width","8" );
      ((Element)v.get(1027)).setAttribute("height","8" );
      ((Element)v.get(1026)).appendChild((Element)v.get(1027));
      /* Termina nodo:1027   */
      /* Termina nodo:1026   */
      /* Termina nodo:1009   */

      /* Empieza nodo:1028 / Elemento padre: 986   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(986)).appendChild((Element)v.get(1028));

      /* Empieza nodo:1029 / Elemento padre: 1028   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1029)).setAttribute("colspan","4" );
      ((Element)v.get(1028)).appendChild((Element)v.get(1029));

      /* Empieza nodo:1030 / Elemento padre: 1029   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1030)).setAttribute("src","b.gif" );
      ((Element)v.get(1030)).setAttribute("width","8" );
      ((Element)v.get(1030)).setAttribute("height","8" );
      ((Element)v.get(1029)).appendChild((Element)v.get(1030));
      /* Termina nodo:1030   */
      /* Termina nodo:1029   */
      /* Termina nodo:1028   */
      /* Termina nodo:986   */

      /* Empieza nodo:1031 / Elemento padre: 983   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1031)).setAttribute("width","100%" );
      ((Element)v.get(1031)).setAttribute("border","0" );
      ((Element)v.get(1031)).setAttribute("align","center" );
      ((Element)v.get(1031)).setAttribute("cellspacing","0" );
      ((Element)v.get(1031)).setAttribute("cellpadding","0" );
      ((Element)v.get(983)).appendChild((Element)v.get(1031));

      /* Empieza nodo:1032 / Elemento padre: 1031   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1031)).appendChild((Element)v.get(1032));

      /* Empieza nodo:1033 / Elemento padre: 1032   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1032)).appendChild((Element)v.get(1033));

      /* Empieza nodo:1034 / Elemento padre: 1033   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1034)).setAttribute("src","b.gif" );
      ((Element)v.get(1034)).setAttribute("width","8" );
      ((Element)v.get(1034)).setAttribute("height","8" );
      ((Element)v.get(1033)).appendChild((Element)v.get(1034));
      /* Termina nodo:1034   */
      /* Termina nodo:1033   */

      /* Empieza nodo:1035 / Elemento padre: 1032   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1032)).appendChild((Element)v.get(1035));

      /* Empieza nodo:1036 / Elemento padre: 1035   */
   }

   private void getXML4140(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1036)).setAttribute("nombre","lblValoresPosiblesAlcanceAdministrativoDescuento" );
      ((Element)v.get(1036)).setAttribute("alto","13" );
      ((Element)v.get(1036)).setAttribute("filas","1" );
      ((Element)v.get(1036)).setAttribute("valor","" );
      ((Element)v.get(1036)).setAttribute("id","datosTitle" );
      ((Element)v.get(1036)).setAttribute("cod","1022" );
      ((Element)v.get(1035)).appendChild((Element)v.get(1036));
      /* Termina nodo:1036   */
      /* Termina nodo:1035   */

      /* Empieza nodo:1037 / Elemento padre: 1032   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1032)).appendChild((Element)v.get(1037));

      /* Empieza nodo:1038 / Elemento padre: 1037   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1038)).setAttribute("src","b.gif" );
      ((Element)v.get(1038)).setAttribute("width","25" );
      ((Element)v.get(1038)).setAttribute("height","8" );
      ((Element)v.get(1037)).appendChild((Element)v.get(1038));
      /* Termina nodo:1038   */
      /* Termina nodo:1037   */

      /* Empieza nodo:1039 / Elemento padre: 1032   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1032)).appendChild((Element)v.get(1039));

      /* Empieza nodo:1040 / Elemento padre: 1039   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1040)).setAttribute("nombre","lblValoresDefectoAlcanceAdministrativoDescuento" );
      ((Element)v.get(1040)).setAttribute("alto","13" );
      ((Element)v.get(1040)).setAttribute("filas","1" );
      ((Element)v.get(1040)).setAttribute("valor","" );
      ((Element)v.get(1040)).setAttribute("id","datosTitle" );
      ((Element)v.get(1040)).setAttribute("cod","1286" );
      ((Element)v.get(1039)).appendChild((Element)v.get(1040));
      /* Termina nodo:1040   */
      /* Termina nodo:1039   */

      /* Empieza nodo:1041 / Elemento padre: 1032   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1041)).setAttribute("width","100%" );
      ((Element)v.get(1032)).appendChild((Element)v.get(1041));

      /* Empieza nodo:1042 / Elemento padre: 1041   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1042)).setAttribute("src","b.gif" );
      ((Element)v.get(1042)).setAttribute("width","8" );
      ((Element)v.get(1042)).setAttribute("height","8" );
      ((Element)v.get(1041)).appendChild((Element)v.get(1042));
      /* Termina nodo:1042   */
      /* Termina nodo:1041   */
      /* Termina nodo:1032   */

      /* Empieza nodo:1043 / Elemento padre: 1031   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1031)).appendChild((Element)v.get(1043));

      /* Empieza nodo:1044 / Elemento padre: 1043   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1043)).appendChild((Element)v.get(1044));

      /* Empieza nodo:1045 / Elemento padre: 1044   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1045)).setAttribute("src","b.gif" );
      ((Element)v.get(1045)).setAttribute("width","8" );
      ((Element)v.get(1045)).setAttribute("height","8" );
      ((Element)v.get(1044)).appendChild((Element)v.get(1045));
      /* Termina nodo:1045   */
      /* Termina nodo:1044   */

      /* Empieza nodo:1046 / Elemento padre: 1043   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1046)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(1043)).appendChild((Element)v.get(1046));

      /* Empieza nodo:1047 / Elemento padre: 1046   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(1047)).setAttribute("nombre","cbValoresPosiblesAlcanceAdministrativoDescuento" );
      ((Element)v.get(1047)).setAttribute("onchange","alcanceOnChange();" );
      ((Element)v.get(1047)).setAttribute("id","datosCampos" );
      ((Element)v.get(1047)).setAttribute("size","3" );
      ((Element)v.get(1047)).setAttribute("multiple","S" );
      ((Element)v.get(1047)).setAttribute("req","S" );
      ((Element)v.get(1047)).setAttribute("valorinicial","" );
      ((Element)v.get(1047)).setAttribute("textoinicial","" );
      ((Element)v.get(1046)).appendChild((Element)v.get(1047));

      /* Empieza nodo:1048 / Elemento padre: 1047   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1047)).appendChild((Element)v.get(1048));

      /* Empieza nodo:1049 / Elemento padre: 1048   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(1049)).setAttribute("ID","1" );
      ((Element)v.get(1048)).appendChild((Element)v.get(1049));

      /* Empieza nodo:1050 / Elemento padre: 1049   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1050)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(1050)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1050)).setAttribute("VALOR","1" );
      ((Element)v.get(1049)).appendChild((Element)v.get(1050));
      /* Termina nodo:1050   */

      /* Empieza nodo:1051 / Elemento padre: 1049   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1051)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(1051)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1051)).setAttribute("VALOR","Nacional" );
      ((Element)v.get(1049)).appendChild((Element)v.get(1051));
      /* Termina nodo:1051   */
      /* Termina nodo:1049   */

      /* Empieza nodo:1052 / Elemento padre: 1048   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(1052)).setAttribute("ID","2" );
      ((Element)v.get(1048)).appendChild((Element)v.get(1052));

      /* Empieza nodo:1053 / Elemento padre: 1052   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1053)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(1053)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1053)).setAttribute("VALOR","2" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1053));
      /* Termina nodo:1053   */

      /* Empieza nodo:1054 / Elemento padre: 1052   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1054)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(1054)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1054)).setAttribute("VALOR","No nacional" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1054));
      /* Termina nodo:1054   */
      /* Termina nodo:1052   */
      /* Termina nodo:1048   */
      /* Termina nodo:1047   */
      /* Termina nodo:1046   */

      /* Empieza nodo:1055 / Elemento padre: 1043   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1043)).appendChild((Element)v.get(1055));

      /* Empieza nodo:1056 / Elemento padre: 1055   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1056)).setAttribute("src","b.gif" );
      ((Element)v.get(1056)).setAttribute("width","25" );
      ((Element)v.get(1056)).setAttribute("height","8" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1056));
      /* Termina nodo:1056   */
      /* Termina nodo:1055   */

      /* Empieza nodo:1057 / Elemento padre: 1043   */
   }

   private void getXML4230(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(1057)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(1057)).setAttribute("valign","top" );
      ((Element)v.get(1043)).appendChild((Element)v.get(1057));

      /* Empieza nodo:1058 / Elemento padre: 1057   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(1058)).setAttribute("nombre","cbValoresDefectoAlcanceAdministrativoDescuento" );
      ((Element)v.get(1058)).setAttribute("id","datosCampos" );
      ((Element)v.get(1058)).setAttribute("size","1" );
      ((Element)v.get(1058)).setAttribute("multiple","N" );
      ((Element)v.get(1058)).setAttribute("req","N" );
      ((Element)v.get(1058)).setAttribute("valorinicial","" );
      ((Element)v.get(1058)).setAttribute("textoinicial","" );
      ((Element)v.get(1057)).appendChild((Element)v.get(1058));

      /* Empieza nodo:1059 / Elemento padre: 1058   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1058)).appendChild((Element)v.get(1059));
      /* Termina nodo:1059   */
      /* Termina nodo:1058   */
      /* Termina nodo:1057   */

      /* Empieza nodo:1060 / Elemento padre: 1043   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1060)).setAttribute("width","100%" );
      ((Element)v.get(1043)).appendChild((Element)v.get(1060));

      /* Empieza nodo:1061 / Elemento padre: 1060   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1061)).setAttribute("src","b.gif" );
      ((Element)v.get(1061)).setAttribute("width","8" );
      ((Element)v.get(1061)).setAttribute("height","8" );
      ((Element)v.get(1060)).appendChild((Element)v.get(1061));
      /* Termina nodo:1061   */
      /* Termina nodo:1060   */
      /* Termina nodo:1043   */

      /* Empieza nodo:1062 / Elemento padre: 1031   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1031)).appendChild((Element)v.get(1062));

      /* Empieza nodo:1063 / Elemento padre: 1062   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1063)).setAttribute("colspan","4" );
      ((Element)v.get(1062)).appendChild((Element)v.get(1063));

      /* Empieza nodo:1064 / Elemento padre: 1063   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1064)).setAttribute("src","b.gif" );
      ((Element)v.get(1064)).setAttribute("width","8" );
      ((Element)v.get(1064)).setAttribute("height","8" );
      ((Element)v.get(1063)).appendChild((Element)v.get(1064));
      /* Termina nodo:1064   */
      /* Termina nodo:1063   */
      /* Termina nodo:1062   */
      /* Termina nodo:1031   */
      /* Termina nodo:983   */
      /* Termina nodo:982   */

      /* Empieza nodo:1065 / Elemento padre: 979   */
      v.add(doc.createElement("td"));
      ((Element)v.get(979)).appendChild((Element)v.get(1065));

      /* Empieza nodo:1066 / Elemento padre: 1065   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1066)).setAttribute("src","b.gif" );
      ((Element)v.get(1065)).appendChild((Element)v.get(1066));
      /* Termina nodo:1066   */
      /* Termina nodo:1065   */
      /* Termina nodo:979   */

      /* Empieza nodo:1067 / Elemento padre: 978   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(978)).appendChild((Element)v.get(1067));

      /* Empieza nodo:1068 / Elemento padre: 1067   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1068)).setAttribute("width","12" );
      ((Element)v.get(1068)).setAttribute("align","center" );
      ((Element)v.get(1067)).appendChild((Element)v.get(1068));

      /* Empieza nodo:1069 / Elemento padre: 1068   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1069)).setAttribute("src","b.gif" );
      ((Element)v.get(1069)).setAttribute("width","12" );
      ((Element)v.get(1069)).setAttribute("height","15" );
      ((Element)v.get(1068)).appendChild((Element)v.get(1069));
      /* Termina nodo:1069   */
      /* Termina nodo:1068   */

      /* Empieza nodo:1070 / Elemento padre: 1067   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1070)).setAttribute("width","756" );
      ((Element)v.get(1067)).appendChild((Element)v.get(1070));

      /* Empieza nodo:1071 / Elemento padre: 1070   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1071)).setAttribute("src","b.gif" );
      ((Element)v.get(1070)).appendChild((Element)v.get(1071));
      /* Termina nodo:1071   */
      /* Termina nodo:1070   */

      /* Empieza nodo:1072 / Elemento padre: 1067   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1072)).setAttribute("width","12" );
      ((Element)v.get(1067)).appendChild((Element)v.get(1072));

      /* Empieza nodo:1073 / Elemento padre: 1072   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1073)).setAttribute("src","b.gif" );
      ((Element)v.get(1073)).setAttribute("width","12" );
      ((Element)v.get(1073)).setAttribute("height","1" );
      ((Element)v.get(1072)).appendChild((Element)v.get(1073));
      /* Termina nodo:1073   */
      /* Termina nodo:1072   */
      /* Termina nodo:1067   */
      /* Termina nodo:978   */

      /* Empieza nodo:1074 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1074)).setAttribute("width","100%" );
      ((Element)v.get(1074)).setAttribute("border","0" );
      ((Element)v.get(1074)).setAttribute("align","center" );
      ((Element)v.get(1074)).setAttribute("cellspacing","0" );
      ((Element)v.get(1074)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1074));

      /* Empieza nodo:1075 / Elemento padre: 1074   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1074)).appendChild((Element)v.get(1075));

      /* Empieza nodo:1076 / Elemento padre: 1075   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1075)).appendChild((Element)v.get(1076));

      /* Empieza nodo:1077 / Elemento padre: 1076   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1077)).setAttribute("src","b.gif" );
      ((Element)v.get(1077)).setAttribute("width","8" );
      ((Element)v.get(1077)).setAttribute("height","8" );
      ((Element)v.get(1076)).appendChild((Element)v.get(1077));
      /* Termina nodo:1077   */
      /* Termina nodo:1076   */

      /* Empieza nodo:1078 / Elemento padre: 1075   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1078)).setAttribute("width","100%" );
      ((Element)v.get(1075)).appendChild((Element)v.get(1078));

      /* Empieza nodo:1079 / Elemento padre: 1078   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1078)).appendChild((Element)v.get(1079));

      /* Empieza nodo:1080 / Elemento padre: 1079   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1080)).setAttribute("class","legend" );
      ((Element)v.get(1079)).appendChild((Element)v.get(1080));

      /* Empieza nodo:1081 / Elemento padre: 1080   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1081)).setAttribute("nombre","lblPorcentajeAdicionalAlcanceAdministrativo" );
      ((Element)v.get(1081)).setAttribute("alto","13" );
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(1081)).setAttribute("filas","1" );
      ((Element)v.get(1081)).setAttribute("valor","" );
      ((Element)v.get(1081)).setAttribute("id","legend" );
      ((Element)v.get(1081)).setAttribute("cod","00475" );
      ((Element)v.get(1080)).appendChild((Element)v.get(1081));
      /* Termina nodo:1081   */
      /* Termina nodo:1080   */

      /* Empieza nodo:1082 / Elemento padre: 1079   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1082)).setAttribute("width","100%" );
      ((Element)v.get(1082)).setAttribute("border","0" );
      ((Element)v.get(1082)).setAttribute("align","center" );
      ((Element)v.get(1082)).setAttribute("cellspacing","0" );
      ((Element)v.get(1082)).setAttribute("cellpadding","0" );
      ((Element)v.get(1079)).appendChild((Element)v.get(1082));

      /* Empieza nodo:1083 / Elemento padre: 1082   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1082)).appendChild((Element)v.get(1083));

      /* Empieza nodo:1084 / Elemento padre: 1083   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1084)).setAttribute("colspan","3" );
      ((Element)v.get(1083)).appendChild((Element)v.get(1084));

      /* Empieza nodo:1085 / Elemento padre: 1084   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1085)).setAttribute("src","b.gif" );
      ((Element)v.get(1085)).setAttribute("width","8" );
      ((Element)v.get(1085)).setAttribute("height","8" );
      ((Element)v.get(1084)).appendChild((Element)v.get(1085));
      /* Termina nodo:1085   */
      /* Termina nodo:1084   */
      /* Termina nodo:1083   */

      /* Empieza nodo:1086 / Elemento padre: 1082   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1082)).appendChild((Element)v.get(1086));

      /* Empieza nodo:1087 / Elemento padre: 1086   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1086)).appendChild((Element)v.get(1087));

      /* Empieza nodo:1088 / Elemento padre: 1087   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1088)).setAttribute("src","b.gif" );
      ((Element)v.get(1088)).setAttribute("width","8" );
      ((Element)v.get(1088)).setAttribute("height","8" );
      ((Element)v.get(1087)).appendChild((Element)v.get(1088));
      /* Termina nodo:1088   */
      /* Termina nodo:1087   */

      /* Empieza nodo:1089 / Elemento padre: 1086   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1086)).appendChild((Element)v.get(1089));

      /* Empieza nodo:1090 / Elemento padre: 1089   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1090)).setAttribute("nombre","lblCodigoPorcentajeAdicionalAlcanceAdministrativo" );
      ((Element)v.get(1090)).setAttribute("alto","13" );
      ((Element)v.get(1090)).setAttribute("filas","1" );
      ((Element)v.get(1090)).setAttribute("valor","" );
      ((Element)v.get(1090)).setAttribute("id","datosTitle" );
      ((Element)v.get(1090)).setAttribute("cod","8" );
      ((Element)v.get(1089)).appendChild((Element)v.get(1090));
      /* Termina nodo:1090   */
      /* Termina nodo:1089   */

      /* Empieza nodo:1091 / Elemento padre: 1086   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1086)).appendChild((Element)v.get(1091));

      /* Empieza nodo:1092 / Elemento padre: 1091   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1092)).setAttribute("src","b.gif" );
      ((Element)v.get(1092)).setAttribute("width","25" );
      ((Element)v.get(1092)).setAttribute("height","8" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1092));
      /* Termina nodo:1092   */
      /* Termina nodo:1091   */

      /* Empieza nodo:1093 / Elemento padre: 1086   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1086)).appendChild((Element)v.get(1093));

      /* Empieza nodo:1094 / Elemento padre: 1093   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1094)).setAttribute("nombre","lblVisiblePorcentajeAdicionalAlcanceAdministrativo" );
      ((Element)v.get(1094)).setAttribute("alto","13" );
      ((Element)v.get(1094)).setAttribute("filas","1" );
      ((Element)v.get(1094)).setAttribute("valor","" );
      ((Element)v.get(1094)).setAttribute("id","datosTitle" );
      ((Element)v.get(1094)).setAttribute("cod","1038" );
      ((Element)v.get(1093)).appendChild((Element)v.get(1094));
      /* Termina nodo:1094   */
      /* Termina nodo:1093   */

      /* Empieza nodo:1095 / Elemento padre: 1086   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1086)).appendChild((Element)v.get(1095));

      /* Empieza nodo:1096 / Elemento padre: 1095   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1096)).setAttribute("src","b.gif" );
      ((Element)v.get(1096)).setAttribute("width","25" );
      ((Element)v.get(1096)).setAttribute("height","8" );
      ((Element)v.get(1095)).appendChild((Element)v.get(1096));
      /* Termina nodo:1096   */
      /* Termina nodo:1095   */

      /* Empieza nodo:1097 / Elemento padre: 1086   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1086)).appendChild((Element)v.get(1097));

      /* Empieza nodo:1098 / Elemento padre: 1097   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1098)).setAttribute("nombre","lblObligatorioPorcentajeAdicionalAlcanceAdministrativo" );
      ((Element)v.get(1098)).setAttribute("alto","13" );
      ((Element)v.get(1098)).setAttribute("filas","1" );
      ((Element)v.get(1098)).setAttribute("valor","" );
      ((Element)v.get(1098)).setAttribute("id","datosTitle" );
      ((Element)v.get(1098)).setAttribute("cod","949" );
      ((Element)v.get(1097)).appendChild((Element)v.get(1098));
      /* Termina nodo:1098   */
      /* Termina nodo:1097   */

      /* Empieza nodo:1099 / Elemento padre: 1086   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1086)).appendChild((Element)v.get(1099));

      /* Empieza nodo:1100 / Elemento padre: 1099   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1100)).setAttribute("src","b.gif" );
      ((Element)v.get(1100)).setAttribute("width","25" );
      ((Element)v.get(1100)).setAttribute("height","8" );
      ((Element)v.get(1099)).appendChild((Element)v.get(1100));
      /* Termina nodo:1100   */
      /* Termina nodo:1099   */

      /* Empieza nodo:1101 / Elemento padre: 1086   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1086)).appendChild((Element)v.get(1101));

      /* Empieza nodo:1102 / Elemento padre: 1101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1102)).setAttribute("nombre","lblModificablePorcentajeAdicionalAlcanceAdministrativo" );
      ((Element)v.get(1102)).setAttribute("alto","13" );
      ((Element)v.get(1102)).setAttribute("filas","1" );
      ((Element)v.get(1102)).setAttribute("valor","" );
      ((Element)v.get(1102)).setAttribute("id","datosTitle" );
   }

   private void getXML4410(Document doc) {
      ((Element)v.get(1102)).setAttribute("cod","914" );
      ((Element)v.get(1101)).appendChild((Element)v.get(1102));
      /* Termina nodo:1102   */
      /* Termina nodo:1101   */

      /* Empieza nodo:1103 / Elemento padre: 1086   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1103)).setAttribute("width","100%" );
      ((Element)v.get(1086)).appendChild((Element)v.get(1103));

      /* Empieza nodo:1104 / Elemento padre: 1103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1104)).setAttribute("src","b.gif" );
      ((Element)v.get(1104)).setAttribute("width","8" );
      ((Element)v.get(1104)).setAttribute("height","8" );
      ((Element)v.get(1103)).appendChild((Element)v.get(1104));
      /* Termina nodo:1104   */
      /* Termina nodo:1103   */
      /* Termina nodo:1086   */

      /* Empieza nodo:1105 / Elemento padre: 1082   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1082)).appendChild((Element)v.get(1105));

      /* Empieza nodo:1106 / Elemento padre: 1105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1105)).appendChild((Element)v.get(1106));

      /* Empieza nodo:1107 / Elemento padre: 1106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1107)).setAttribute("src","b.gif" );
      ((Element)v.get(1107)).setAttribute("width","8" );
      ((Element)v.get(1107)).setAttribute("height","8" );
      ((Element)v.get(1106)).appendChild((Element)v.get(1107));
      /* Termina nodo:1107   */
      /* Termina nodo:1106   */

      /* Empieza nodo:1108 / Elemento padre: 1105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1105)).appendChild((Element)v.get(1108));

      /* Empieza nodo:1109 / Elemento padre: 1108   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1109)).setAttribute("nombre","lbldtCodigoPorcentajeAdicionalAlcanceAdministrativo" );
      ((Element)v.get(1109)).setAttribute("alto","13" );
      ((Element)v.get(1109)).setAttribute("filas","1" );
      ((Element)v.get(1109)).setAttribute("valor","13" );
      ((Element)v.get(1109)).setAttribute("id","datosCampos" );
      ((Element)v.get(1108)).appendChild((Element)v.get(1109));
      /* Termina nodo:1109   */
      /* Termina nodo:1108   */

      /* Empieza nodo:1110 / Elemento padre: 1105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1105)).appendChild((Element)v.get(1110));

      /* Empieza nodo:1111 / Elemento padre: 1110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1111)).setAttribute("src","b.gif" );
      ((Element)v.get(1111)).setAttribute("width","25" );
      ((Element)v.get(1111)).setAttribute("height","8" );
      ((Element)v.get(1110)).appendChild((Element)v.get(1111));
      /* Termina nodo:1111   */
      /* Termina nodo:1110   */

      /* Empieza nodo:1112 / Elemento padre: 1105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1105)).appendChild((Element)v.get(1112));

      /* Empieza nodo:1113 / Elemento padre: 1112   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1113)).setAttribute("nombre","ckVisiblePorcentajeAdicionalAlcanceAdministrativo" );
      ((Element)v.get(1113)).setAttribute("id","datosCampos" );
      ((Element)v.get(1113)).setAttribute("onclick","cambiaObli(11)" );
      ((Element)v.get(1113)).setAttribute("check","S" );
      ((Element)v.get(1112)).appendChild((Element)v.get(1113));
      /* Termina nodo:1113   */
      /* Termina nodo:1112   */

      /* Empieza nodo:1114 / Elemento padre: 1105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1105)).appendChild((Element)v.get(1114));

      /* Empieza nodo:1115 / Elemento padre: 1114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1115)).setAttribute("src","b.gif" );
      ((Element)v.get(1115)).setAttribute("width","25" );
      ((Element)v.get(1115)).setAttribute("height","8" );
      ((Element)v.get(1114)).appendChild((Element)v.get(1115));
      /* Termina nodo:1115   */
      /* Termina nodo:1114   */

      /* Empieza nodo:1116 / Elemento padre: 1105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1105)).appendChild((Element)v.get(1116));

      /* Empieza nodo:1117 / Elemento padre: 1116   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1117)).setAttribute("nombre","ckObligatorioPorcentajeAdicionalAlcanceAdministrativo" );
      ((Element)v.get(1117)).setAttribute("id","datosCampos" );
      ((Element)v.get(1117)).setAttribute("onclick","" );
      ((Element)v.get(1117)).setAttribute("check","N" );
      ((Element)v.get(1116)).appendChild((Element)v.get(1117));
      /* Termina nodo:1117   */
      /* Termina nodo:1116   */

      /* Empieza nodo:1118 / Elemento padre: 1105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1105)).appendChild((Element)v.get(1118));

      /* Empieza nodo:1119 / Elemento padre: 1118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1119)).setAttribute("src","b.gif" );
      ((Element)v.get(1119)).setAttribute("width","25" );
      ((Element)v.get(1119)).setAttribute("height","8" );
      ((Element)v.get(1118)).appendChild((Element)v.get(1119));
      /* Termina nodo:1119   */
      /* Termina nodo:1118   */

      /* Empieza nodo:1120 / Elemento padre: 1105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1105)).appendChild((Element)v.get(1120));

      /* Empieza nodo:1121 / Elemento padre: 1120   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1121)).setAttribute("nombre","ckModificablePorcentajeAdicionalAlcanceAdministrativo" );
      ((Element)v.get(1121)).setAttribute("id","datosCampos" );
      ((Element)v.get(1121)).setAttribute("onclick","" );
      ((Element)v.get(1121)).setAttribute("check","S" );
      ((Element)v.get(1120)).appendChild((Element)v.get(1121));
      /* Termina nodo:1121   */
      /* Termina nodo:1120   */

      /* Empieza nodo:1122 / Elemento padre: 1105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1122)).setAttribute("width","100%" );
      ((Element)v.get(1105)).appendChild((Element)v.get(1122));

      /* Empieza nodo:1123 / Elemento padre: 1122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1123)).setAttribute("src","b.gif" );
      ((Element)v.get(1123)).setAttribute("width","8" );
      ((Element)v.get(1123)).setAttribute("height","8" );
      ((Element)v.get(1122)).appendChild((Element)v.get(1123));
      /* Termina nodo:1123   */
      /* Termina nodo:1122   */
      /* Termina nodo:1105   */

      /* Empieza nodo:1124 / Elemento padre: 1082   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1082)).appendChild((Element)v.get(1124));

      /* Empieza nodo:1125 / Elemento padre: 1124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1125)).setAttribute("colspan","4" );
      ((Element)v.get(1124)).appendChild((Element)v.get(1125));

      /* Empieza nodo:1126 / Elemento padre: 1125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1126)).setAttribute("src","b.gif" );
      ((Element)v.get(1126)).setAttribute("width","8" );
      ((Element)v.get(1126)).setAttribute("height","8" );
   }

   private void getXML4500(Document doc) {
      ((Element)v.get(1125)).appendChild((Element)v.get(1126));
      /* Termina nodo:1126   */
      /* Termina nodo:1125   */
      /* Termina nodo:1124   */
      /* Termina nodo:1082   */
      /* Termina nodo:1079   */
      /* Termina nodo:1078   */

      /* Empieza nodo:1127 / Elemento padre: 1075   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1075)).appendChild((Element)v.get(1127));

      /* Empieza nodo:1128 / Elemento padre: 1127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1128)).setAttribute("src","b.gif" );
      ((Element)v.get(1127)).appendChild((Element)v.get(1128));
      /* Termina nodo:1128   */
      /* Termina nodo:1127   */
      /* Termina nodo:1075   */

      /* Empieza nodo:1129 / Elemento padre: 1074   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1074)).appendChild((Element)v.get(1129));

      /* Empieza nodo:1130 / Elemento padre: 1129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1130)).setAttribute("width","12" );
      ((Element)v.get(1130)).setAttribute("align","center" );
      ((Element)v.get(1129)).appendChild((Element)v.get(1130));

      /* Empieza nodo:1131 / Elemento padre: 1130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1131)).setAttribute("src","b.gif" );
      ((Element)v.get(1131)).setAttribute("width","12" );
      ((Element)v.get(1131)).setAttribute("height","15" );
      ((Element)v.get(1130)).appendChild((Element)v.get(1131));
      /* Termina nodo:1131   */
      /* Termina nodo:1130   */

      /* Empieza nodo:1132 / Elemento padre: 1129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1132)).setAttribute("width","756" );
      ((Element)v.get(1129)).appendChild((Element)v.get(1132));

      /* Empieza nodo:1133 / Elemento padre: 1132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1133)).setAttribute("src","b.gif" );
      ((Element)v.get(1132)).appendChild((Element)v.get(1133));
      /* Termina nodo:1133   */
      /* Termina nodo:1132   */

      /* Empieza nodo:1134 / Elemento padre: 1129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1134)).setAttribute("width","12" );
      ((Element)v.get(1129)).appendChild((Element)v.get(1134));

      /* Empieza nodo:1135 / Elemento padre: 1134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1135)).setAttribute("src","b.gif" );
      ((Element)v.get(1135)).setAttribute("width","12" );
      ((Element)v.get(1135)).setAttribute("height","1" );
      ((Element)v.get(1134)).appendChild((Element)v.get(1135));
      /* Termina nodo:1135   */
      /* Termina nodo:1134   */
      /* Termina nodo:1129   */
      /* Termina nodo:1074   */

      /* Empieza nodo:1136 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1136)).setAttribute("width","100%" );
      ((Element)v.get(1136)).setAttribute("border","0" );
      ((Element)v.get(1136)).setAttribute("align","center" );
      ((Element)v.get(1136)).setAttribute("cellspacing","0" );
      ((Element)v.get(1136)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1136));

      /* Empieza nodo:1137 / Elemento padre: 1136   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1136)).appendChild((Element)v.get(1137));

      /* Empieza nodo:1138 / Elemento padre: 1137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1137)).appendChild((Element)v.get(1138));

      /* Empieza nodo:1139 / Elemento padre: 1138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1139)).setAttribute("src","b.gif" );
      ((Element)v.get(1139)).setAttribute("width","8" );
      ((Element)v.get(1139)).setAttribute("height","8" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1139));
      /* Termina nodo:1139   */
      /* Termina nodo:1138   */

      /* Empieza nodo:1140 / Elemento padre: 1137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1140)).setAttribute("width","100%" );
      ((Element)v.get(1137)).appendChild((Element)v.get(1140));

      /* Empieza nodo:1141 / Elemento padre: 1140   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1140)).appendChild((Element)v.get(1141));

      /* Empieza nodo:1142 / Elemento padre: 1141   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1142)).setAttribute("class","legend" );
      ((Element)v.get(1141)).appendChild((Element)v.get(1142));

      /* Empieza nodo:1143 / Elemento padre: 1142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1143)).setAttribute("nombre","lblBaseCalculoDescuentoMarca" );
      ((Element)v.get(1143)).setAttribute("alto","13" );
      ((Element)v.get(1143)).setAttribute("filas","1" );
      ((Element)v.get(1143)).setAttribute("valor","" );
      ((Element)v.get(1143)).setAttribute("id","legend" );
      ((Element)v.get(1143)).setAttribute("cod","00476" );
      ((Element)v.get(1142)).appendChild((Element)v.get(1143));
      /* Termina nodo:1143   */
      /* Termina nodo:1142   */

      /* Empieza nodo:1144 / Elemento padre: 1141   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1144)).setAttribute("width","100%" );
      ((Element)v.get(1144)).setAttribute("border","0" );
      ((Element)v.get(1144)).setAttribute("align","center" );
      ((Element)v.get(1144)).setAttribute("cellspacing","0" );
      ((Element)v.get(1144)).setAttribute("cellpadding","0" );
      ((Element)v.get(1141)).appendChild((Element)v.get(1144));

      /* Empieza nodo:1145 / Elemento padre: 1144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1144)).appendChild((Element)v.get(1145));

      /* Empieza nodo:1146 / Elemento padre: 1145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1146)).setAttribute("colspan","3" );
      ((Element)v.get(1145)).appendChild((Element)v.get(1146));

      /* Empieza nodo:1147 / Elemento padre: 1146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1147)).setAttribute("src","b.gif" );
      ((Element)v.get(1147)).setAttribute("width","8" );
      ((Element)v.get(1147)).setAttribute("height","8" );
      ((Element)v.get(1146)).appendChild((Element)v.get(1147));
      /* Termina nodo:1147   */
      /* Termina nodo:1146   */
      /* Termina nodo:1145   */

      /* Empieza nodo:1148 / Elemento padre: 1144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1144)).appendChild((Element)v.get(1148));

      /* Empieza nodo:1149 / Elemento padre: 1148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1148)).appendChild((Element)v.get(1149));

      /* Empieza nodo:1150 / Elemento padre: 1149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1150)).setAttribute("src","b.gif" );
      ((Element)v.get(1150)).setAttribute("width","8" );
      ((Element)v.get(1150)).setAttribute("height","8" );
      ((Element)v.get(1149)).appendChild((Element)v.get(1150));
      /* Termina nodo:1150   */
      /* Termina nodo:1149   */

      /* Empieza nodo:1151 / Elemento padre: 1148   */
      v.add(doc.createElement("td"));
   }

   private void getXML4590(Document doc) {
      ((Element)v.get(1148)).appendChild((Element)v.get(1151));

      /* Empieza nodo:1152 / Elemento padre: 1151   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1152)).setAttribute("nombre","lblCodigoBaseCalculoDescuentoMarca" );
      ((Element)v.get(1152)).setAttribute("alto","13" );
      ((Element)v.get(1152)).setAttribute("filas","1" );
      ((Element)v.get(1152)).setAttribute("valor","" );
      ((Element)v.get(1152)).setAttribute("id","datosTitle" );
      ((Element)v.get(1152)).setAttribute("cod","8" );
      ((Element)v.get(1151)).appendChild((Element)v.get(1152));
      /* Termina nodo:1152   */
      /* Termina nodo:1151   */

      /* Empieza nodo:1153 / Elemento padre: 1148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1148)).appendChild((Element)v.get(1153));

      /* Empieza nodo:1154 / Elemento padre: 1153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1154)).setAttribute("src","b.gif" );
      ((Element)v.get(1154)).setAttribute("width","25" );
      ((Element)v.get(1154)).setAttribute("height","8" );
      ((Element)v.get(1153)).appendChild((Element)v.get(1154));
      /* Termina nodo:1154   */
      /* Termina nodo:1153   */

      /* Empieza nodo:1155 / Elemento padre: 1148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1148)).appendChild((Element)v.get(1155));

      /* Empieza nodo:1156 / Elemento padre: 1155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1156)).setAttribute("nombre","lblVisibleBaseCalculoDescuentoMarca" );
      ((Element)v.get(1156)).setAttribute("alto","13" );
      ((Element)v.get(1156)).setAttribute("filas","1" );
      ((Element)v.get(1156)).setAttribute("valor","" );
      ((Element)v.get(1156)).setAttribute("id","datosTitle" );
      ((Element)v.get(1156)).setAttribute("cod","1038" );
      ((Element)v.get(1155)).appendChild((Element)v.get(1156));
      /* Termina nodo:1156   */
      /* Termina nodo:1155   */

      /* Empieza nodo:1157 / Elemento padre: 1148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1148)).appendChild((Element)v.get(1157));

      /* Empieza nodo:1158 / Elemento padre: 1157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1158)).setAttribute("src","b.gif" );
      ((Element)v.get(1158)).setAttribute("width","25" );
      ((Element)v.get(1158)).setAttribute("height","8" );
      ((Element)v.get(1157)).appendChild((Element)v.get(1158));
      /* Termina nodo:1158   */
      /* Termina nodo:1157   */

      /* Empieza nodo:1159 / Elemento padre: 1148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1148)).appendChild((Element)v.get(1159));

      /* Empieza nodo:1160 / Elemento padre: 1159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1160)).setAttribute("nombre","lblObligatorioBaseCalculoDescuentoMarca" );
      ((Element)v.get(1160)).setAttribute("alto","13" );
      ((Element)v.get(1160)).setAttribute("filas","1" );
      ((Element)v.get(1160)).setAttribute("valor","" );
      ((Element)v.get(1160)).setAttribute("id","datosTitle" );
      ((Element)v.get(1160)).setAttribute("cod","949" );
      ((Element)v.get(1159)).appendChild((Element)v.get(1160));
      /* Termina nodo:1160   */
      /* Termina nodo:1159   */

      /* Empieza nodo:1161 / Elemento padre: 1148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1148)).appendChild((Element)v.get(1161));

      /* Empieza nodo:1162 / Elemento padre: 1161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1162)).setAttribute("src","b.gif" );
      ((Element)v.get(1162)).setAttribute("width","25" );
      ((Element)v.get(1162)).setAttribute("height","8" );
      ((Element)v.get(1161)).appendChild((Element)v.get(1162));
      /* Termina nodo:1162   */
      /* Termina nodo:1161   */

      /* Empieza nodo:1163 / Elemento padre: 1148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1148)).appendChild((Element)v.get(1163));

      /* Empieza nodo:1164 / Elemento padre: 1163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1164)).setAttribute("nombre","lblModificableBaseCalculoDescuentoMarca" );
      ((Element)v.get(1164)).setAttribute("alto","13" );
      ((Element)v.get(1164)).setAttribute("filas","1" );
      ((Element)v.get(1164)).setAttribute("valor","" );
      ((Element)v.get(1164)).setAttribute("id","datosTitle" );
      ((Element)v.get(1164)).setAttribute("cod","914" );
      ((Element)v.get(1163)).appendChild((Element)v.get(1164));
      /* Termina nodo:1164   */
      /* Termina nodo:1163   */

      /* Empieza nodo:1165 / Elemento padre: 1148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1165)).setAttribute("width","100%" );
      ((Element)v.get(1148)).appendChild((Element)v.get(1165));

      /* Empieza nodo:1166 / Elemento padre: 1165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1166)).setAttribute("src","b.gif" );
      ((Element)v.get(1166)).setAttribute("width","8" );
      ((Element)v.get(1166)).setAttribute("height","8" );
      ((Element)v.get(1165)).appendChild((Element)v.get(1166));
      /* Termina nodo:1166   */
      /* Termina nodo:1165   */
      /* Termina nodo:1148   */

      /* Empieza nodo:1167 / Elemento padre: 1144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1144)).appendChild((Element)v.get(1167));

      /* Empieza nodo:1168 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1167)).appendChild((Element)v.get(1168));

      /* Empieza nodo:1169 / Elemento padre: 1168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1169)).setAttribute("src","b.gif" );
      ((Element)v.get(1169)).setAttribute("width","8" );
      ((Element)v.get(1169)).setAttribute("height","8" );
      ((Element)v.get(1168)).appendChild((Element)v.get(1169));
      /* Termina nodo:1169   */
      /* Termina nodo:1168   */

      /* Empieza nodo:1170 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1167)).appendChild((Element)v.get(1170));

      /* Empieza nodo:1171 / Elemento padre: 1170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1171)).setAttribute("nombre","lbldtCodigoBaseCalculoDescuentoMarca" );
      ((Element)v.get(1171)).setAttribute("alto","13" );
      ((Element)v.get(1171)).setAttribute("filas","1" );
      ((Element)v.get(1171)).setAttribute("valor","14" );
      ((Element)v.get(1171)).setAttribute("id","datosCampos" );
      ((Element)v.get(1170)).appendChild((Element)v.get(1171));
      /* Termina nodo:1171   */
      /* Termina nodo:1170   */

      /* Empieza nodo:1172 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1167)).appendChild((Element)v.get(1172));

      /* Empieza nodo:1173 / Elemento padre: 1172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1173)).setAttribute("src","b.gif" );
   }

   private void getXML4680(Document doc) {
      ((Element)v.get(1173)).setAttribute("width","25" );
      ((Element)v.get(1173)).setAttribute("height","8" );
      ((Element)v.get(1172)).appendChild((Element)v.get(1173));
      /* Termina nodo:1173   */
      /* Termina nodo:1172   */

      /* Empieza nodo:1174 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1167)).appendChild((Element)v.get(1174));

      /* Empieza nodo:1175 / Elemento padre: 1174   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1175)).setAttribute("nombre","ckVisibleBaseCalculoDescuentoMarca" );
      ((Element)v.get(1175)).setAttribute("id","datosCampos" );
      ((Element)v.get(1175)).setAttribute("onclick","cambiaObli(12)" );
      ((Element)v.get(1175)).setAttribute("check","S" );
      ((Element)v.get(1174)).appendChild((Element)v.get(1175));
      /* Termina nodo:1175   */
      /* Termina nodo:1174   */

      /* Empieza nodo:1176 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1167)).appendChild((Element)v.get(1176));

      /* Empieza nodo:1177 / Elemento padre: 1176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1177)).setAttribute("src","b.gif" );
      ((Element)v.get(1177)).setAttribute("width","25" );
      ((Element)v.get(1177)).setAttribute("height","8" );
      ((Element)v.get(1176)).appendChild((Element)v.get(1177));
      /* Termina nodo:1177   */
      /* Termina nodo:1176   */

      /* Empieza nodo:1178 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1167)).appendChild((Element)v.get(1178));

      /* Empieza nodo:1179 / Elemento padre: 1178   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1179)).setAttribute("nombre","ckObligatorioBaseCalculoDescuentoMarca" );
      ((Element)v.get(1179)).setAttribute("id","datosCampos" );
      ((Element)v.get(1179)).setAttribute("onclick","" );
      ((Element)v.get(1179)).setAttribute("check","N" );
      ((Element)v.get(1178)).appendChild((Element)v.get(1179));
      /* Termina nodo:1179   */
      /* Termina nodo:1178   */

      /* Empieza nodo:1180 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1167)).appendChild((Element)v.get(1180));

      /* Empieza nodo:1181 / Elemento padre: 1180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1181)).setAttribute("src","b.gif" );
      ((Element)v.get(1181)).setAttribute("width","25" );
      ((Element)v.get(1181)).setAttribute("height","8" );
      ((Element)v.get(1180)).appendChild((Element)v.get(1181));
      /* Termina nodo:1181   */
      /* Termina nodo:1180   */

      /* Empieza nodo:1182 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1167)).appendChild((Element)v.get(1182));

      /* Empieza nodo:1183 / Elemento padre: 1182   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1183)).setAttribute("nombre","ckModificableBaseCalculoDescuentoMarca" );
      ((Element)v.get(1183)).setAttribute("id","datosCampos" );
      ((Element)v.get(1183)).setAttribute("onclick","" );
      ((Element)v.get(1183)).setAttribute("check","S" );
      ((Element)v.get(1182)).appendChild((Element)v.get(1183));
      /* Termina nodo:1183   */
      /* Termina nodo:1182   */

      /* Empieza nodo:1184 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1184)).setAttribute("width","100%" );
      ((Element)v.get(1167)).appendChild((Element)v.get(1184));

      /* Empieza nodo:1185 / Elemento padre: 1184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1185)).setAttribute("src","b.gif" );
      ((Element)v.get(1185)).setAttribute("width","8" );
      ((Element)v.get(1185)).setAttribute("height","8" );
      ((Element)v.get(1184)).appendChild((Element)v.get(1185));
      /* Termina nodo:1185   */
      /* Termina nodo:1184   */
      /* Termina nodo:1167   */

      /* Empieza nodo:1186 / Elemento padre: 1144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1144)).appendChild((Element)v.get(1186));

      /* Empieza nodo:1187 / Elemento padre: 1186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1187)).setAttribute("colspan","4" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1187));

      /* Empieza nodo:1188 / Elemento padre: 1187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1188)).setAttribute("src","b.gif" );
      ((Element)v.get(1188)).setAttribute("width","8" );
      ((Element)v.get(1188)).setAttribute("height","8" );
      ((Element)v.get(1187)).appendChild((Element)v.get(1188));
      /* Termina nodo:1188   */
      /* Termina nodo:1187   */
      /* Termina nodo:1186   */
      /* Termina nodo:1144   */
      /* Termina nodo:1141   */
      /* Termina nodo:1140   */

      /* Empieza nodo:1189 / Elemento padre: 1137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1137)).appendChild((Element)v.get(1189));

      /* Empieza nodo:1190 / Elemento padre: 1189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1190)).setAttribute("src","b.gif" );
      ((Element)v.get(1189)).appendChild((Element)v.get(1190));
      /* Termina nodo:1190   */
      /* Termina nodo:1189   */
      /* Termina nodo:1137   */

      /* Empieza nodo:1191 / Elemento padre: 1136   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1136)).appendChild((Element)v.get(1191));

      /* Empieza nodo:1192 / Elemento padre: 1191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1192)).setAttribute("width","12" );
      ((Element)v.get(1192)).setAttribute("align","center" );
      ((Element)v.get(1191)).appendChild((Element)v.get(1192));

      /* Empieza nodo:1193 / Elemento padre: 1192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1193)).setAttribute("src","b.gif" );
      ((Element)v.get(1193)).setAttribute("width","12" );
      ((Element)v.get(1193)).setAttribute("height","15" );
      ((Element)v.get(1192)).appendChild((Element)v.get(1193));
      /* Termina nodo:1193   */
      /* Termina nodo:1192   */

      /* Empieza nodo:1194 / Elemento padre: 1191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1194)).setAttribute("width","756" );
      ((Element)v.get(1191)).appendChild((Element)v.get(1194));

      /* Empieza nodo:1195 / Elemento padre: 1194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1195)).setAttribute("src","b.gif" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1195));
      /* Termina nodo:1195   */
      /* Termina nodo:1194   */

      /* Empieza nodo:1196 / Elemento padre: 1191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1196)).setAttribute("width","12" );
      ((Element)v.get(1191)).appendChild((Element)v.get(1196));

      /* Empieza nodo:1197 / Elemento padre: 1196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1197)).setAttribute("src","b.gif" );
      ((Element)v.get(1197)).setAttribute("width","12" );
      ((Element)v.get(1197)).setAttribute("height","1" );
      ((Element)v.get(1196)).appendChild((Element)v.get(1197));
      /* Termina nodo:1197   */
      /* Termina nodo:1196   */
      /* Termina nodo:1191   */
      /* Termina nodo:1136   */

      /* Empieza nodo:1198 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
   }

   private void getXML4770(Document doc) {
      ((Element)v.get(1198)).setAttribute("width","100%" );
      ((Element)v.get(1198)).setAttribute("border","0" );
      ((Element)v.get(1198)).setAttribute("align","center" );
      ((Element)v.get(1198)).setAttribute("cellspacing","0" );
      ((Element)v.get(1198)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1198));

      /* Empieza nodo:1199 / Elemento padre: 1198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1198)).appendChild((Element)v.get(1199));

      /* Empieza nodo:1200 / Elemento padre: 1199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1199)).appendChild((Element)v.get(1200));

      /* Empieza nodo:1201 / Elemento padre: 1200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1201)).setAttribute("src","b.gif" );
      ((Element)v.get(1201)).setAttribute("width","8" );
      ((Element)v.get(1201)).setAttribute("height","8" );
      ((Element)v.get(1200)).appendChild((Element)v.get(1201));
      /* Termina nodo:1201   */
      /* Termina nodo:1200   */

      /* Empieza nodo:1202 / Elemento padre: 1199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1202)).setAttribute("width","100%" );
      ((Element)v.get(1199)).appendChild((Element)v.get(1202));

      /* Empieza nodo:1203 / Elemento padre: 1202   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1202)).appendChild((Element)v.get(1203));

      /* Empieza nodo:1204 / Elemento padre: 1203   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1204)).setAttribute("class","legend" );
      ((Element)v.get(1203)).appendChild((Element)v.get(1204));

      /* Empieza nodo:1205 / Elemento padre: 1204   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1205)).setAttribute("nombre","lblBaseCalculoDescuentoUnidadNegocio" );
      ((Element)v.get(1205)).setAttribute("alto","13" );
      ((Element)v.get(1205)).setAttribute("filas","1" );
      ((Element)v.get(1205)).setAttribute("valor","" );
      ((Element)v.get(1205)).setAttribute("id","legend" );
      ((Element)v.get(1205)).setAttribute("cod","00477" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1205));
      /* Termina nodo:1205   */
      /* Termina nodo:1204   */

      /* Empieza nodo:1206 / Elemento padre: 1203   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1206)).setAttribute("width","100%" );
      ((Element)v.get(1206)).setAttribute("border","0" );
      ((Element)v.get(1206)).setAttribute("align","center" );
      ((Element)v.get(1206)).setAttribute("cellspacing","0" );
      ((Element)v.get(1206)).setAttribute("cellpadding","0" );
      ((Element)v.get(1203)).appendChild((Element)v.get(1206));

      /* Empieza nodo:1207 / Elemento padre: 1206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1206)).appendChild((Element)v.get(1207));

      /* Empieza nodo:1208 / Elemento padre: 1207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1208)).setAttribute("colspan","3" );
      ((Element)v.get(1207)).appendChild((Element)v.get(1208));

      /* Empieza nodo:1209 / Elemento padre: 1208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1209)).setAttribute("src","b.gif" );
      ((Element)v.get(1209)).setAttribute("width","8" );
      ((Element)v.get(1209)).setAttribute("height","8" );
      ((Element)v.get(1208)).appendChild((Element)v.get(1209));
      /* Termina nodo:1209   */
      /* Termina nodo:1208   */
      /* Termina nodo:1207   */

      /* Empieza nodo:1210 / Elemento padre: 1206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1206)).appendChild((Element)v.get(1210));

      /* Empieza nodo:1211 / Elemento padre: 1210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1210)).appendChild((Element)v.get(1211));

      /* Empieza nodo:1212 / Elemento padre: 1211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1212)).setAttribute("src","b.gif" );
      ((Element)v.get(1212)).setAttribute("width","8" );
      ((Element)v.get(1212)).setAttribute("height","8" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1212));
      /* Termina nodo:1212   */
      /* Termina nodo:1211   */

      /* Empieza nodo:1213 / Elemento padre: 1210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1210)).appendChild((Element)v.get(1213));

      /* Empieza nodo:1214 / Elemento padre: 1213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1214)).setAttribute("nombre","lblCodigoBaseCalculoDescuentoUnidadNegocio" );
      ((Element)v.get(1214)).setAttribute("alto","13" );
      ((Element)v.get(1214)).setAttribute("filas","1" );
      ((Element)v.get(1214)).setAttribute("valor","" );
      ((Element)v.get(1214)).setAttribute("id","datosTitle" );
      ((Element)v.get(1214)).setAttribute("cod","8" );
      ((Element)v.get(1213)).appendChild((Element)v.get(1214));
      /* Termina nodo:1214   */
      /* Termina nodo:1213   */

      /* Empieza nodo:1215 / Elemento padre: 1210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1210)).appendChild((Element)v.get(1215));

      /* Empieza nodo:1216 / Elemento padre: 1215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1216)).setAttribute("src","b.gif" );
      ((Element)v.get(1216)).setAttribute("width","25" );
      ((Element)v.get(1216)).setAttribute("height","8" );
      ((Element)v.get(1215)).appendChild((Element)v.get(1216));
      /* Termina nodo:1216   */
      /* Termina nodo:1215   */

      /* Empieza nodo:1217 / Elemento padre: 1210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1210)).appendChild((Element)v.get(1217));

      /* Empieza nodo:1218 / Elemento padre: 1217   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1218)).setAttribute("nombre","lblVisibleBaseCalculoDescuentoUnidadNegocio" );
      ((Element)v.get(1218)).setAttribute("alto","13" );
      ((Element)v.get(1218)).setAttribute("filas","1" );
      ((Element)v.get(1218)).setAttribute("valor","" );
      ((Element)v.get(1218)).setAttribute("id","datosTitle" );
      ((Element)v.get(1218)).setAttribute("cod","1038" );
      ((Element)v.get(1217)).appendChild((Element)v.get(1218));
      /* Termina nodo:1218   */
      /* Termina nodo:1217   */

      /* Empieza nodo:1219 / Elemento padre: 1210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1210)).appendChild((Element)v.get(1219));

      /* Empieza nodo:1220 / Elemento padre: 1219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1220)).setAttribute("src","b.gif" );
      ((Element)v.get(1220)).setAttribute("width","25" );
      ((Element)v.get(1220)).setAttribute("height","8" );
   }

   private void getXML4860(Document doc) {
      ((Element)v.get(1219)).appendChild((Element)v.get(1220));
      /* Termina nodo:1220   */
      /* Termina nodo:1219   */

      /* Empieza nodo:1221 / Elemento padre: 1210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1210)).appendChild((Element)v.get(1221));

      /* Empieza nodo:1222 / Elemento padre: 1221   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1222)).setAttribute("nombre","lblObligatorioBaseCalculoDescuentoUnidadNegocio" );
      ((Element)v.get(1222)).setAttribute("alto","13" );
      ((Element)v.get(1222)).setAttribute("filas","1" );
      ((Element)v.get(1222)).setAttribute("valor","" );
      ((Element)v.get(1222)).setAttribute("id","datosTitle" );
      ((Element)v.get(1222)).setAttribute("cod","949" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1222));
      /* Termina nodo:1222   */
      /* Termina nodo:1221   */

      /* Empieza nodo:1223 / Elemento padre: 1210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1210)).appendChild((Element)v.get(1223));

      /* Empieza nodo:1224 / Elemento padre: 1223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1224)).setAttribute("src","b.gif" );
      ((Element)v.get(1224)).setAttribute("width","25" );
      ((Element)v.get(1224)).setAttribute("height","8" );
      ((Element)v.get(1223)).appendChild((Element)v.get(1224));
      /* Termina nodo:1224   */
      /* Termina nodo:1223   */

      /* Empieza nodo:1225 / Elemento padre: 1210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1210)).appendChild((Element)v.get(1225));

      /* Empieza nodo:1226 / Elemento padre: 1225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1226)).setAttribute("nombre","lblModificableBaseCalculoDescuentoUnidadNegocio" );
      ((Element)v.get(1226)).setAttribute("alto","13" );
      ((Element)v.get(1226)).setAttribute("filas","1" );
      ((Element)v.get(1226)).setAttribute("valor","" );
      ((Element)v.get(1226)).setAttribute("id","datosTitle" );
      ((Element)v.get(1226)).setAttribute("cod","914" );
      ((Element)v.get(1225)).appendChild((Element)v.get(1226));
      /* Termina nodo:1226   */
      /* Termina nodo:1225   */

      /* Empieza nodo:1227 / Elemento padre: 1210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1227)).setAttribute("width","100%" );
      ((Element)v.get(1210)).appendChild((Element)v.get(1227));

      /* Empieza nodo:1228 / Elemento padre: 1227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1228)).setAttribute("src","b.gif" );
      ((Element)v.get(1228)).setAttribute("width","8" );
      ((Element)v.get(1228)).setAttribute("height","8" );
      ((Element)v.get(1227)).appendChild((Element)v.get(1228));
      /* Termina nodo:1228   */
      /* Termina nodo:1227   */
      /* Termina nodo:1210   */

      /* Empieza nodo:1229 / Elemento padre: 1206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1206)).appendChild((Element)v.get(1229));

      /* Empieza nodo:1230 / Elemento padre: 1229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1229)).appendChild((Element)v.get(1230));

      /* Empieza nodo:1231 / Elemento padre: 1230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1231)).setAttribute("src","b.gif" );
      ((Element)v.get(1231)).setAttribute("width","8" );
      ((Element)v.get(1231)).setAttribute("height","8" );
      ((Element)v.get(1230)).appendChild((Element)v.get(1231));
      /* Termina nodo:1231   */
      /* Termina nodo:1230   */

      /* Empieza nodo:1232 / Elemento padre: 1229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1229)).appendChild((Element)v.get(1232));

      /* Empieza nodo:1233 / Elemento padre: 1232   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1233)).setAttribute("nombre","lbldtCodigoBaseCalculoDescuentoUnidadNegocio" );
      ((Element)v.get(1233)).setAttribute("alto","13" );
      ((Element)v.get(1233)).setAttribute("filas","1" );
      ((Element)v.get(1233)).setAttribute("valor","15" );
      ((Element)v.get(1233)).setAttribute("id","datosCampos" );
      ((Element)v.get(1232)).appendChild((Element)v.get(1233));
      /* Termina nodo:1233   */
      /* Termina nodo:1232   */

      /* Empieza nodo:1234 / Elemento padre: 1229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1229)).appendChild((Element)v.get(1234));

      /* Empieza nodo:1235 / Elemento padre: 1234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1235)).setAttribute("src","b.gif" );
      ((Element)v.get(1235)).setAttribute("width","25" );
      ((Element)v.get(1235)).setAttribute("height","8" );
      ((Element)v.get(1234)).appendChild((Element)v.get(1235));
      /* Termina nodo:1235   */
      /* Termina nodo:1234   */

      /* Empieza nodo:1236 / Elemento padre: 1229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1229)).appendChild((Element)v.get(1236));

      /* Empieza nodo:1237 / Elemento padre: 1236   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1237)).setAttribute("nombre","ckVisibleBaseCalculoDescuentoUnidadNegocio" );
      ((Element)v.get(1237)).setAttribute("id","datosCampos" );
      ((Element)v.get(1237)).setAttribute("onclick","cambiaObli(13)" );
      ((Element)v.get(1237)).setAttribute("check","S" );
      ((Element)v.get(1236)).appendChild((Element)v.get(1237));
      /* Termina nodo:1237   */
      /* Termina nodo:1236   */

      /* Empieza nodo:1238 / Elemento padre: 1229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1229)).appendChild((Element)v.get(1238));

      /* Empieza nodo:1239 / Elemento padre: 1238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1239)).setAttribute("src","b.gif" );
      ((Element)v.get(1239)).setAttribute("width","25" );
      ((Element)v.get(1239)).setAttribute("height","8" );
      ((Element)v.get(1238)).appendChild((Element)v.get(1239));
      /* Termina nodo:1239   */
      /* Termina nodo:1238   */

      /* Empieza nodo:1240 / Elemento padre: 1229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1229)).appendChild((Element)v.get(1240));

      /* Empieza nodo:1241 / Elemento padre: 1240   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1241)).setAttribute("nombre","ckObligatorioBaseCalculoDescuentoUnidadNegocio" );
      ((Element)v.get(1241)).setAttribute("id","datosCampos" );
      ((Element)v.get(1241)).setAttribute("onclick","" );
      ((Element)v.get(1241)).setAttribute("check","N" );
      ((Element)v.get(1240)).appendChild((Element)v.get(1241));
      /* Termina nodo:1241   */
      /* Termina nodo:1240   */

      /* Empieza nodo:1242 / Elemento padre: 1229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1229)).appendChild((Element)v.get(1242));

      /* Empieza nodo:1243 / Elemento padre: 1242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1243)).setAttribute("src","b.gif" );
      ((Element)v.get(1243)).setAttribute("width","25" );
      ((Element)v.get(1243)).setAttribute("height","8" );
   }

   private void getXML4950(Document doc) {
      ((Element)v.get(1242)).appendChild((Element)v.get(1243));
      /* Termina nodo:1243   */
      /* Termina nodo:1242   */

      /* Empieza nodo:1244 / Elemento padre: 1229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1229)).appendChild((Element)v.get(1244));

      /* Empieza nodo:1245 / Elemento padre: 1244   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1245)).setAttribute("nombre","ckModificableBaseCalculoDescuentoUnidadNegocio" );
      ((Element)v.get(1245)).setAttribute("id","datosCampos" );
      ((Element)v.get(1245)).setAttribute("onclick","" );
      ((Element)v.get(1245)).setAttribute("check","S" );
      ((Element)v.get(1244)).appendChild((Element)v.get(1245));
      /* Termina nodo:1245   */
      /* Termina nodo:1244   */

      /* Empieza nodo:1246 / Elemento padre: 1229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1246)).setAttribute("width","100%" );
      ((Element)v.get(1229)).appendChild((Element)v.get(1246));

      /* Empieza nodo:1247 / Elemento padre: 1246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1247)).setAttribute("src","b.gif" );
      ((Element)v.get(1247)).setAttribute("width","8" );
      ((Element)v.get(1247)).setAttribute("height","8" );
      ((Element)v.get(1246)).appendChild((Element)v.get(1247));
      /* Termina nodo:1247   */
      /* Termina nodo:1246   */
      /* Termina nodo:1229   */

      /* Empieza nodo:1248 / Elemento padre: 1206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1206)).appendChild((Element)v.get(1248));

      /* Empieza nodo:1249 / Elemento padre: 1248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1249)).setAttribute("colspan","4" );
      ((Element)v.get(1248)).appendChild((Element)v.get(1249));

      /* Empieza nodo:1250 / Elemento padre: 1249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1250)).setAttribute("src","b.gif" );
      ((Element)v.get(1250)).setAttribute("width","8" );
      ((Element)v.get(1250)).setAttribute("height","8" );
      ((Element)v.get(1249)).appendChild((Element)v.get(1250));
      /* Termina nodo:1250   */
      /* Termina nodo:1249   */
      /* Termina nodo:1248   */
      /* Termina nodo:1206   */
      /* Termina nodo:1203   */
      /* Termina nodo:1202   */

      /* Empieza nodo:1251 / Elemento padre: 1199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1199)).appendChild((Element)v.get(1251));

      /* Empieza nodo:1252 / Elemento padre: 1251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1252)).setAttribute("src","b.gif" );
      ((Element)v.get(1251)).appendChild((Element)v.get(1252));
      /* Termina nodo:1252   */
      /* Termina nodo:1251   */
      /* Termina nodo:1199   */

      /* Empieza nodo:1253 / Elemento padre: 1198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1198)).appendChild((Element)v.get(1253));

      /* Empieza nodo:1254 / Elemento padre: 1253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1254)).setAttribute("width","12" );
      ((Element)v.get(1254)).setAttribute("align","center" );
      ((Element)v.get(1253)).appendChild((Element)v.get(1254));

      /* Empieza nodo:1255 / Elemento padre: 1254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1255)).setAttribute("src","b.gif" );
      ((Element)v.get(1255)).setAttribute("width","12" );
      ((Element)v.get(1255)).setAttribute("height","15" );
      ((Element)v.get(1254)).appendChild((Element)v.get(1255));
      /* Termina nodo:1255   */
      /* Termina nodo:1254   */

      /* Empieza nodo:1256 / Elemento padre: 1253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1256)).setAttribute("width","756" );
      ((Element)v.get(1253)).appendChild((Element)v.get(1256));

      /* Empieza nodo:1257 / Elemento padre: 1256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1257)).setAttribute("src","b.gif" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1257));
      /* Termina nodo:1257   */
      /* Termina nodo:1256   */

      /* Empieza nodo:1258 / Elemento padre: 1253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1258)).setAttribute("width","12" );
      ((Element)v.get(1253)).appendChild((Element)v.get(1258));

      /* Empieza nodo:1259 / Elemento padre: 1258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1259)).setAttribute("src","b.gif" );
      ((Element)v.get(1259)).setAttribute("width","12" );
      ((Element)v.get(1259)).setAttribute("height","1" );
      ((Element)v.get(1258)).appendChild((Element)v.get(1259));
      /* Termina nodo:1259   */
      /* Termina nodo:1258   */
      /* Termina nodo:1253   */
      /* Termina nodo:1198   */

      /* Empieza nodo:1260 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1260)).setAttribute("width","100%" );
      ((Element)v.get(1260)).setAttribute("border","0" );
      ((Element)v.get(1260)).setAttribute("align","center" );
      ((Element)v.get(1260)).setAttribute("cellspacing","0" );
      ((Element)v.get(1260)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1260));

      /* Empieza nodo:1261 / Elemento padre: 1260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1260)).appendChild((Element)v.get(1261));

      /* Empieza nodo:1262 / Elemento padre: 1261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1261)).appendChild((Element)v.get(1262));

      /* Empieza nodo:1263 / Elemento padre: 1262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1263)).setAttribute("src","b.gif" );
      ((Element)v.get(1263)).setAttribute("width","8" );
      ((Element)v.get(1263)).setAttribute("height","8" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1263));
      /* Termina nodo:1263   */
      /* Termina nodo:1262   */

      /* Empieza nodo:1264 / Elemento padre: 1261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1264)).setAttribute("width","100%" );
      ((Element)v.get(1261)).appendChild((Element)v.get(1264));

      /* Empieza nodo:1265 / Elemento padre: 1264   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1264)).appendChild((Element)v.get(1265));

      /* Empieza nodo:1266 / Elemento padre: 1265   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1266)).setAttribute("class","legend" );
      ((Element)v.get(1265)).appendChild((Element)v.get(1266));

      /* Empieza nodo:1267 / Elemento padre: 1266   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1267)).setAttribute("nombre","lblBaseCalculoDescuentoNegocio" );
      ((Element)v.get(1267)).setAttribute("alto","13" );
      ((Element)v.get(1267)).setAttribute("filas","1" );
      ((Element)v.get(1267)).setAttribute("valor","" );
      ((Element)v.get(1267)).setAttribute("id","legend" );
      ((Element)v.get(1267)).setAttribute("cod","00478" );
      ((Element)v.get(1266)).appendChild((Element)v.get(1267));
      /* Termina nodo:1267   */
      /* Termina nodo:1266   */

      /* Empieza nodo:1268 / Elemento padre: 1265   */
      v.add(doc.createElement("table"));
   }

   private void getXML5040(Document doc) {
      ((Element)v.get(1268)).setAttribute("width","100%" );
      ((Element)v.get(1268)).setAttribute("border","0" );
      ((Element)v.get(1268)).setAttribute("align","center" );
      ((Element)v.get(1268)).setAttribute("cellspacing","0" );
      ((Element)v.get(1268)).setAttribute("cellpadding","0" );
      ((Element)v.get(1265)).appendChild((Element)v.get(1268));

      /* Empieza nodo:1269 / Elemento padre: 1268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1268)).appendChild((Element)v.get(1269));

      /* Empieza nodo:1270 / Elemento padre: 1269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1270)).setAttribute("colspan","3" );
      ((Element)v.get(1269)).appendChild((Element)v.get(1270));

      /* Empieza nodo:1271 / Elemento padre: 1270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1271)).setAttribute("src","b.gif" );
      ((Element)v.get(1271)).setAttribute("width","8" );
      ((Element)v.get(1271)).setAttribute("height","8" );
      ((Element)v.get(1270)).appendChild((Element)v.get(1271));
      /* Termina nodo:1271   */
      /* Termina nodo:1270   */
      /* Termina nodo:1269   */

      /* Empieza nodo:1272 / Elemento padre: 1268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1268)).appendChild((Element)v.get(1272));

      /* Empieza nodo:1273 / Elemento padre: 1272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1272)).appendChild((Element)v.get(1273));

      /* Empieza nodo:1274 / Elemento padre: 1273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1274)).setAttribute("src","b.gif" );
      ((Element)v.get(1274)).setAttribute("width","8" );
      ((Element)v.get(1274)).setAttribute("height","8" );
      ((Element)v.get(1273)).appendChild((Element)v.get(1274));
      /* Termina nodo:1274   */
      /* Termina nodo:1273   */

      /* Empieza nodo:1275 / Elemento padre: 1272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1272)).appendChild((Element)v.get(1275));

      /* Empieza nodo:1276 / Elemento padre: 1275   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1276)).setAttribute("nombre","lblCodigoBaseCalculoDescuentoNegocio" );
      ((Element)v.get(1276)).setAttribute("alto","13" );
      ((Element)v.get(1276)).setAttribute("filas","1" );
      ((Element)v.get(1276)).setAttribute("valor","" );
      ((Element)v.get(1276)).setAttribute("id","datosTitle" );
      ((Element)v.get(1276)).setAttribute("cod","8" );
      ((Element)v.get(1275)).appendChild((Element)v.get(1276));
      /* Termina nodo:1276   */
      /* Termina nodo:1275   */

      /* Empieza nodo:1277 / Elemento padre: 1272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1272)).appendChild((Element)v.get(1277));

      /* Empieza nodo:1278 / Elemento padre: 1277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1278)).setAttribute("src","b.gif" );
      ((Element)v.get(1278)).setAttribute("width","25" );
      ((Element)v.get(1278)).setAttribute("height","8" );
      ((Element)v.get(1277)).appendChild((Element)v.get(1278));
      /* Termina nodo:1278   */
      /* Termina nodo:1277   */

      /* Empieza nodo:1279 / Elemento padre: 1272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1272)).appendChild((Element)v.get(1279));

      /* Empieza nodo:1280 / Elemento padre: 1279   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1280)).setAttribute("nombre","lblVisibleBaseCalculoDescuentoNegocio" );
      ((Element)v.get(1280)).setAttribute("alto","13" );
      ((Element)v.get(1280)).setAttribute("filas","1" );
      ((Element)v.get(1280)).setAttribute("valor","" );
      ((Element)v.get(1280)).setAttribute("id","datosTitle" );
      ((Element)v.get(1280)).setAttribute("cod","1038" );
      ((Element)v.get(1279)).appendChild((Element)v.get(1280));
      /* Termina nodo:1280   */
      /* Termina nodo:1279   */

      /* Empieza nodo:1281 / Elemento padre: 1272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1272)).appendChild((Element)v.get(1281));

      /* Empieza nodo:1282 / Elemento padre: 1281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1282)).setAttribute("src","b.gif" );
      ((Element)v.get(1282)).setAttribute("width","25" );
      ((Element)v.get(1282)).setAttribute("height","8" );
      ((Element)v.get(1281)).appendChild((Element)v.get(1282));
      /* Termina nodo:1282   */
      /* Termina nodo:1281   */

      /* Empieza nodo:1283 / Elemento padre: 1272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1272)).appendChild((Element)v.get(1283));

      /* Empieza nodo:1284 / Elemento padre: 1283   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1284)).setAttribute("nombre","lblObligatorioBaseCalculoDescuentoNegocio" );
      ((Element)v.get(1284)).setAttribute("alto","13" );
      ((Element)v.get(1284)).setAttribute("filas","1" );
      ((Element)v.get(1284)).setAttribute("valor","" );
      ((Element)v.get(1284)).setAttribute("id","datosTitle" );
      ((Element)v.get(1284)).setAttribute("cod","949" );
      ((Element)v.get(1283)).appendChild((Element)v.get(1284));
      /* Termina nodo:1284   */
      /* Termina nodo:1283   */

      /* Empieza nodo:1285 / Elemento padre: 1272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1272)).appendChild((Element)v.get(1285));

      /* Empieza nodo:1286 / Elemento padre: 1285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1286)).setAttribute("src","b.gif" );
      ((Element)v.get(1286)).setAttribute("width","25" );
      ((Element)v.get(1286)).setAttribute("height","8" );
      ((Element)v.get(1285)).appendChild((Element)v.get(1286));
      /* Termina nodo:1286   */
      /* Termina nodo:1285   */

      /* Empieza nodo:1287 / Elemento padre: 1272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1272)).appendChild((Element)v.get(1287));

      /* Empieza nodo:1288 / Elemento padre: 1287   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1288)).setAttribute("nombre","lblModificableBaseCalculoDescuentoNegocio" );
      ((Element)v.get(1288)).setAttribute("alto","13" );
      ((Element)v.get(1288)).setAttribute("filas","1" );
      ((Element)v.get(1288)).setAttribute("valor","" );
      ((Element)v.get(1288)).setAttribute("id","datosTitle" );
      ((Element)v.get(1288)).setAttribute("cod","914" );
      ((Element)v.get(1287)).appendChild((Element)v.get(1288));
      /* Termina nodo:1288   */
      /* Termina nodo:1287   */

      /* Empieza nodo:1289 / Elemento padre: 1272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1289)).setAttribute("width","100%" );
      ((Element)v.get(1272)).appendChild((Element)v.get(1289));

      /* Empieza nodo:1290 / Elemento padre: 1289   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML5130(Document doc) {
      ((Element)v.get(1290)).setAttribute("src","b.gif" );
      ((Element)v.get(1290)).setAttribute("width","8" );
      ((Element)v.get(1290)).setAttribute("height","8" );
      ((Element)v.get(1289)).appendChild((Element)v.get(1290));
      /* Termina nodo:1290   */
      /* Termina nodo:1289   */
      /* Termina nodo:1272   */

      /* Empieza nodo:1291 / Elemento padre: 1268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1268)).appendChild((Element)v.get(1291));

      /* Empieza nodo:1292 / Elemento padre: 1291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1291)).appendChild((Element)v.get(1292));

      /* Empieza nodo:1293 / Elemento padre: 1292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1293)).setAttribute("src","b.gif" );
      ((Element)v.get(1293)).setAttribute("width","8" );
      ((Element)v.get(1293)).setAttribute("height","8" );
      ((Element)v.get(1292)).appendChild((Element)v.get(1293));
      /* Termina nodo:1293   */
      /* Termina nodo:1292   */

      /* Empieza nodo:1294 / Elemento padre: 1291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1291)).appendChild((Element)v.get(1294));

      /* Empieza nodo:1295 / Elemento padre: 1294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1295)).setAttribute("nombre","lbldtCodigoBaseCalculoDescuentoNegocio" );
      ((Element)v.get(1295)).setAttribute("alto","13" );
      ((Element)v.get(1295)).setAttribute("filas","1" );
      ((Element)v.get(1295)).setAttribute("valor","16" );
      ((Element)v.get(1295)).setAttribute("id","datosCampos" );
      ((Element)v.get(1294)).appendChild((Element)v.get(1295));
      /* Termina nodo:1295   */
      /* Termina nodo:1294   */

      /* Empieza nodo:1296 / Elemento padre: 1291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1291)).appendChild((Element)v.get(1296));

      /* Empieza nodo:1297 / Elemento padre: 1296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1297)).setAttribute("src","b.gif" );
      ((Element)v.get(1297)).setAttribute("width","25" );
      ((Element)v.get(1297)).setAttribute("height","8" );
      ((Element)v.get(1296)).appendChild((Element)v.get(1297));
      /* Termina nodo:1297   */
      /* Termina nodo:1296   */

      /* Empieza nodo:1298 / Elemento padre: 1291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1291)).appendChild((Element)v.get(1298));

      /* Empieza nodo:1299 / Elemento padre: 1298   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1299)).setAttribute("nombre","ckVisibleBaseCalculoDescuentoNegocio" );
      ((Element)v.get(1299)).setAttribute("id","datosCampos" );
      ((Element)v.get(1299)).setAttribute("onclick","cambiaObli(14)" );
      ((Element)v.get(1299)).setAttribute("check","S" );
      ((Element)v.get(1298)).appendChild((Element)v.get(1299));
      /* Termina nodo:1299   */
      /* Termina nodo:1298   */

      /* Empieza nodo:1300 / Elemento padre: 1291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1291)).appendChild((Element)v.get(1300));

      /* Empieza nodo:1301 / Elemento padre: 1300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1301)).setAttribute("src","b.gif" );
      ((Element)v.get(1301)).setAttribute("width","25" );
      ((Element)v.get(1301)).setAttribute("height","8" );
      ((Element)v.get(1300)).appendChild((Element)v.get(1301));
      /* Termina nodo:1301   */
      /* Termina nodo:1300   */

      /* Empieza nodo:1302 / Elemento padre: 1291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1291)).appendChild((Element)v.get(1302));

      /* Empieza nodo:1303 / Elemento padre: 1302   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1303)).setAttribute("nombre","ckObligatorioBaseCalculoDescuentoNegocio" );
      ((Element)v.get(1303)).setAttribute("id","datosCampos" );
      ((Element)v.get(1303)).setAttribute("onclick","" );
      ((Element)v.get(1303)).setAttribute("check","N" );
      ((Element)v.get(1302)).appendChild((Element)v.get(1303));
      /* Termina nodo:1303   */
      /* Termina nodo:1302   */

      /* Empieza nodo:1304 / Elemento padre: 1291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1291)).appendChild((Element)v.get(1304));

      /* Empieza nodo:1305 / Elemento padre: 1304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1305)).setAttribute("src","b.gif" );
      ((Element)v.get(1305)).setAttribute("width","25" );
      ((Element)v.get(1305)).setAttribute("height","8" );
      ((Element)v.get(1304)).appendChild((Element)v.get(1305));
      /* Termina nodo:1305   */
      /* Termina nodo:1304   */

      /* Empieza nodo:1306 / Elemento padre: 1291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1291)).appendChild((Element)v.get(1306));

      /* Empieza nodo:1307 / Elemento padre: 1306   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1307)).setAttribute("nombre","ckModificableBaseCalculoDescuentoNegocio" );
      ((Element)v.get(1307)).setAttribute("id","datosCampos" );
      ((Element)v.get(1307)).setAttribute("onclick","" );
      ((Element)v.get(1307)).setAttribute("check","S" );
      ((Element)v.get(1306)).appendChild((Element)v.get(1307));
      /* Termina nodo:1307   */
      /* Termina nodo:1306   */

      /* Empieza nodo:1308 / Elemento padre: 1291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1308)).setAttribute("width","100%" );
      ((Element)v.get(1291)).appendChild((Element)v.get(1308));

      /* Empieza nodo:1309 / Elemento padre: 1308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1309)).setAttribute("src","b.gif" );
      ((Element)v.get(1309)).setAttribute("width","8" );
      ((Element)v.get(1309)).setAttribute("height","8" );
      ((Element)v.get(1308)).appendChild((Element)v.get(1309));
      /* Termina nodo:1309   */
      /* Termina nodo:1308   */
      /* Termina nodo:1291   */

      /* Empieza nodo:1310 / Elemento padre: 1268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1268)).appendChild((Element)v.get(1310));

      /* Empieza nodo:1311 / Elemento padre: 1310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1311)).setAttribute("colspan","4" );
      ((Element)v.get(1310)).appendChild((Element)v.get(1311));

      /* Empieza nodo:1312 / Elemento padre: 1311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1312)).setAttribute("src","b.gif" );
      ((Element)v.get(1312)).setAttribute("width","8" );
      ((Element)v.get(1312)).setAttribute("height","8" );
      ((Element)v.get(1311)).appendChild((Element)v.get(1312));
      /* Termina nodo:1312   */
      /* Termina nodo:1311   */
      /* Termina nodo:1310   */
      /* Termina nodo:1268   */
      /* Termina nodo:1265   */
      /* Termina nodo:1264   */

      /* Empieza nodo:1313 / Elemento padre: 1261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1261)).appendChild((Element)v.get(1313));

      /* Empieza nodo:1314 / Elemento padre: 1313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1314)).setAttribute("src","b.gif" );
      ((Element)v.get(1313)).appendChild((Element)v.get(1314));
      /* Termina nodo:1314   */
      /* Termina nodo:1313   */
      /* Termina nodo:1261   */

      /* Empieza nodo:1315 / Elemento padre: 1260   */
   }

   private void getXML5220(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(1260)).appendChild((Element)v.get(1315));

      /* Empieza nodo:1316 / Elemento padre: 1315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1316)).setAttribute("width","12" );
      ((Element)v.get(1316)).setAttribute("align","center" );
      ((Element)v.get(1315)).appendChild((Element)v.get(1316));

      /* Empieza nodo:1317 / Elemento padre: 1316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1317)).setAttribute("src","b.gif" );
      ((Element)v.get(1317)).setAttribute("width","12" );
      ((Element)v.get(1317)).setAttribute("height","15" );
      ((Element)v.get(1316)).appendChild((Element)v.get(1317));
      /* Termina nodo:1317   */
      /* Termina nodo:1316   */

      /* Empieza nodo:1318 / Elemento padre: 1315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1318)).setAttribute("width","756" );
      ((Element)v.get(1315)).appendChild((Element)v.get(1318));

      /* Empieza nodo:1319 / Elemento padre: 1318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1319)).setAttribute("src","b.gif" );
      ((Element)v.get(1318)).appendChild((Element)v.get(1319));
      /* Termina nodo:1319   */
      /* Termina nodo:1318   */

      /* Empieza nodo:1320 / Elemento padre: 1315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1320)).setAttribute("width","12" );
      ((Element)v.get(1315)).appendChild((Element)v.get(1320));

      /* Empieza nodo:1321 / Elemento padre: 1320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1321)).setAttribute("src","b.gif" );
      ((Element)v.get(1321)).setAttribute("width","12" );
      ((Element)v.get(1321)).setAttribute("height","1" );
      ((Element)v.get(1320)).appendChild((Element)v.get(1321));
      /* Termina nodo:1321   */
      /* Termina nodo:1320   */
      /* Termina nodo:1315   */
      /* Termina nodo:1260   */

      /* Empieza nodo:1322 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1322)).setAttribute("width","100%" );
      ((Element)v.get(1322)).setAttribute("border","0" );
      ((Element)v.get(1322)).setAttribute("align","center" );
      ((Element)v.get(1322)).setAttribute("cellspacing","0" );
      ((Element)v.get(1322)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1322));

      /* Empieza nodo:1323 / Elemento padre: 1322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1322)).appendChild((Element)v.get(1323));

      /* Empieza nodo:1324 / Elemento padre: 1323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1323)).appendChild((Element)v.get(1324));

      /* Empieza nodo:1325 / Elemento padre: 1324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1325)).setAttribute("src","b.gif" );
      ((Element)v.get(1325)).setAttribute("width","8" );
      ((Element)v.get(1325)).setAttribute("height","8" );
      ((Element)v.get(1324)).appendChild((Element)v.get(1325));
      /* Termina nodo:1325   */
      /* Termina nodo:1324   */

      /* Empieza nodo:1326 / Elemento padre: 1323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1326)).setAttribute("width","100%" );
      ((Element)v.get(1323)).appendChild((Element)v.get(1326));

      /* Empieza nodo:1327 / Elemento padre: 1326   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1326)).appendChild((Element)v.get(1327));

      /* Empieza nodo:1328 / Elemento padre: 1327   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1328)).setAttribute("class","legend" );
      ((Element)v.get(1327)).appendChild((Element)v.get(1328));

      /* Empieza nodo:1329 / Elemento padre: 1328   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1329)).setAttribute("nombre","lblBaseCalculoDescuentoSupergenerico" );
      ((Element)v.get(1329)).setAttribute("alto","13" );
      ((Element)v.get(1329)).setAttribute("filas","1" );
      ((Element)v.get(1329)).setAttribute("valor","" );
      ((Element)v.get(1329)).setAttribute("id","legend" );
      ((Element)v.get(1329)).setAttribute("cod","00479" );
      ((Element)v.get(1328)).appendChild((Element)v.get(1329));
      /* Termina nodo:1329   */
      /* Termina nodo:1328   */

      /* Empieza nodo:1330 / Elemento padre: 1327   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1330)).setAttribute("width","100%" );
      ((Element)v.get(1330)).setAttribute("border","0" );
      ((Element)v.get(1330)).setAttribute("align","center" );
      ((Element)v.get(1330)).setAttribute("cellspacing","0" );
      ((Element)v.get(1330)).setAttribute("cellpadding","0" );
      ((Element)v.get(1327)).appendChild((Element)v.get(1330));

      /* Empieza nodo:1331 / Elemento padre: 1330   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1330)).appendChild((Element)v.get(1331));

      /* Empieza nodo:1332 / Elemento padre: 1331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1332)).setAttribute("colspan","3" );
      ((Element)v.get(1331)).appendChild((Element)v.get(1332));

      /* Empieza nodo:1333 / Elemento padre: 1332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1333)).setAttribute("src","b.gif" );
      ((Element)v.get(1333)).setAttribute("width","8" );
      ((Element)v.get(1333)).setAttribute("height","8" );
      ((Element)v.get(1332)).appendChild((Element)v.get(1333));
      /* Termina nodo:1333   */
      /* Termina nodo:1332   */
      /* Termina nodo:1331   */

      /* Empieza nodo:1334 / Elemento padre: 1330   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1330)).appendChild((Element)v.get(1334));

      /* Empieza nodo:1335 / Elemento padre: 1334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1334)).appendChild((Element)v.get(1335));

      /* Empieza nodo:1336 / Elemento padre: 1335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1336)).setAttribute("src","b.gif" );
      ((Element)v.get(1336)).setAttribute("width","8" );
      ((Element)v.get(1336)).setAttribute("height","8" );
      ((Element)v.get(1335)).appendChild((Element)v.get(1336));
      /* Termina nodo:1336   */
      /* Termina nodo:1335   */

      /* Empieza nodo:1337 / Elemento padre: 1334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1334)).appendChild((Element)v.get(1337));

      /* Empieza nodo:1338 / Elemento padre: 1337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1338)).setAttribute("nombre","lblCodigoBaseCalculoDescuentoSupergenerico" );
      ((Element)v.get(1338)).setAttribute("alto","13" );
      ((Element)v.get(1338)).setAttribute("filas","1" );
      ((Element)v.get(1338)).setAttribute("valor","" );
   }

   private void getXML5310(Document doc) {
      ((Element)v.get(1338)).setAttribute("id","datosTitle" );
      ((Element)v.get(1338)).setAttribute("cod","8" );
      ((Element)v.get(1337)).appendChild((Element)v.get(1338));
      /* Termina nodo:1338   */
      /* Termina nodo:1337   */

      /* Empieza nodo:1339 / Elemento padre: 1334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1334)).appendChild((Element)v.get(1339));

      /* Empieza nodo:1340 / Elemento padre: 1339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1340)).setAttribute("src","b.gif" );
      ((Element)v.get(1340)).setAttribute("width","25" );
      ((Element)v.get(1340)).setAttribute("height","8" );
      ((Element)v.get(1339)).appendChild((Element)v.get(1340));
      /* Termina nodo:1340   */
      /* Termina nodo:1339   */

      /* Empieza nodo:1341 / Elemento padre: 1334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1334)).appendChild((Element)v.get(1341));

      /* Empieza nodo:1342 / Elemento padre: 1341   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1342)).setAttribute("nombre","lblVisibleBaseCalculoDescuentoSupergenerico" );
      ((Element)v.get(1342)).setAttribute("alto","13" );
      ((Element)v.get(1342)).setAttribute("filas","1" );
      ((Element)v.get(1342)).setAttribute("valor","" );
      ((Element)v.get(1342)).setAttribute("id","datosTitle" );
      ((Element)v.get(1342)).setAttribute("cod","1038" );
      ((Element)v.get(1341)).appendChild((Element)v.get(1342));
      /* Termina nodo:1342   */
      /* Termina nodo:1341   */

      /* Empieza nodo:1343 / Elemento padre: 1334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1334)).appendChild((Element)v.get(1343));

      /* Empieza nodo:1344 / Elemento padre: 1343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1344)).setAttribute("src","b.gif" );
      ((Element)v.get(1344)).setAttribute("width","25" );
      ((Element)v.get(1344)).setAttribute("height","8" );
      ((Element)v.get(1343)).appendChild((Element)v.get(1344));
      /* Termina nodo:1344   */
      /* Termina nodo:1343   */

      /* Empieza nodo:1345 / Elemento padre: 1334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1334)).appendChild((Element)v.get(1345));

      /* Empieza nodo:1346 / Elemento padre: 1345   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1346)).setAttribute("nombre","lblObligatorioBaseCalculoDescuentoSupergenerico" );
      ((Element)v.get(1346)).setAttribute("alto","13" );
      ((Element)v.get(1346)).setAttribute("filas","1" );
      ((Element)v.get(1346)).setAttribute("valor","" );
      ((Element)v.get(1346)).setAttribute("id","datosTitle" );
      ((Element)v.get(1346)).setAttribute("cod","949" );
      ((Element)v.get(1345)).appendChild((Element)v.get(1346));
      /* Termina nodo:1346   */
      /* Termina nodo:1345   */

      /* Empieza nodo:1347 / Elemento padre: 1334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1334)).appendChild((Element)v.get(1347));

      /* Empieza nodo:1348 / Elemento padre: 1347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1348)).setAttribute("src","b.gif" );
      ((Element)v.get(1348)).setAttribute("width","25" );
      ((Element)v.get(1348)).setAttribute("height","8" );
      ((Element)v.get(1347)).appendChild((Element)v.get(1348));
      /* Termina nodo:1348   */
      /* Termina nodo:1347   */

      /* Empieza nodo:1349 / Elemento padre: 1334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1334)).appendChild((Element)v.get(1349));

      /* Empieza nodo:1350 / Elemento padre: 1349   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1350)).setAttribute("nombre","lblModificableBaseCalculoDescuentoSupergenerico" );
      ((Element)v.get(1350)).setAttribute("alto","13" );
      ((Element)v.get(1350)).setAttribute("filas","1" );
      ((Element)v.get(1350)).setAttribute("valor","" );
      ((Element)v.get(1350)).setAttribute("id","datosTitle" );
      ((Element)v.get(1350)).setAttribute("cod","914" );
      ((Element)v.get(1349)).appendChild((Element)v.get(1350));
      /* Termina nodo:1350   */
      /* Termina nodo:1349   */

      /* Empieza nodo:1351 / Elemento padre: 1334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1351)).setAttribute("width","100%" );
      ((Element)v.get(1334)).appendChild((Element)v.get(1351));

      /* Empieza nodo:1352 / Elemento padre: 1351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1352)).setAttribute("src","b.gif" );
      ((Element)v.get(1352)).setAttribute("width","8" );
      ((Element)v.get(1352)).setAttribute("height","8" );
      ((Element)v.get(1351)).appendChild((Element)v.get(1352));
      /* Termina nodo:1352   */
      /* Termina nodo:1351   */
      /* Termina nodo:1334   */

      /* Empieza nodo:1353 / Elemento padre: 1330   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1330)).appendChild((Element)v.get(1353));

      /* Empieza nodo:1354 / Elemento padre: 1353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1353)).appendChild((Element)v.get(1354));

      /* Empieza nodo:1355 / Elemento padre: 1354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1355)).setAttribute("src","b.gif" );
      ((Element)v.get(1355)).setAttribute("width","8" );
      ((Element)v.get(1355)).setAttribute("height","8" );
      ((Element)v.get(1354)).appendChild((Element)v.get(1355));
      /* Termina nodo:1355   */
      /* Termina nodo:1354   */

      /* Empieza nodo:1356 / Elemento padre: 1353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1353)).appendChild((Element)v.get(1356));

      /* Empieza nodo:1357 / Elemento padre: 1356   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1357)).setAttribute("nombre","lbldtCodigoBaseCalculoDescuentoSupergenerico" );
      ((Element)v.get(1357)).setAttribute("alto","13" );
      ((Element)v.get(1357)).setAttribute("filas","1" );
      ((Element)v.get(1357)).setAttribute("valor","17" );
      ((Element)v.get(1357)).setAttribute("id","datosCampos" );
      ((Element)v.get(1356)).appendChild((Element)v.get(1357));
      /* Termina nodo:1357   */
      /* Termina nodo:1356   */

      /* Empieza nodo:1358 / Elemento padre: 1353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1353)).appendChild((Element)v.get(1358));

      /* Empieza nodo:1359 / Elemento padre: 1358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1359)).setAttribute("src","b.gif" );
      ((Element)v.get(1359)).setAttribute("width","25" );
      ((Element)v.get(1359)).setAttribute("height","8" );
      ((Element)v.get(1358)).appendChild((Element)v.get(1359));
      /* Termina nodo:1359   */
      /* Termina nodo:1358   */

      /* Empieza nodo:1360 / Elemento padre: 1353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1353)).appendChild((Element)v.get(1360));

      /* Empieza nodo:1361 / Elemento padre: 1360   */
      v.add(doc.createElement("CHECKBOX"));
   }

   private void getXML5400(Document doc) {
      ((Element)v.get(1361)).setAttribute("nombre","ckVisibleBaseCalculoDescuentoSupergenerico" );
      ((Element)v.get(1361)).setAttribute("id","datosCampos" );
      ((Element)v.get(1361)).setAttribute("onclick","cambiaObli(15)" );
      ((Element)v.get(1361)).setAttribute("check","S" );
      ((Element)v.get(1360)).appendChild((Element)v.get(1361));
      /* Termina nodo:1361   */
      /* Termina nodo:1360   */

      /* Empieza nodo:1362 / Elemento padre: 1353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1353)).appendChild((Element)v.get(1362));

      /* Empieza nodo:1363 / Elemento padre: 1362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1363)).setAttribute("src","b.gif" );
      ((Element)v.get(1363)).setAttribute("width","25" );
      ((Element)v.get(1363)).setAttribute("height","8" );
      ((Element)v.get(1362)).appendChild((Element)v.get(1363));
      /* Termina nodo:1363   */
      /* Termina nodo:1362   */

      /* Empieza nodo:1364 / Elemento padre: 1353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1353)).appendChild((Element)v.get(1364));

      /* Empieza nodo:1365 / Elemento padre: 1364   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1365)).setAttribute("nombre","ckObligatorioBaseCalculoDescuentoSupergenerico" );
      ((Element)v.get(1365)).setAttribute("id","datosCampos" );
      ((Element)v.get(1365)).setAttribute("onclick","" );
      ((Element)v.get(1365)).setAttribute("check","N" );
      ((Element)v.get(1364)).appendChild((Element)v.get(1365));
      /* Termina nodo:1365   */
      /* Termina nodo:1364   */

      /* Empieza nodo:1366 / Elemento padre: 1353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1353)).appendChild((Element)v.get(1366));

      /* Empieza nodo:1367 / Elemento padre: 1366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1367)).setAttribute("src","b.gif" );
      ((Element)v.get(1367)).setAttribute("width","25" );
      ((Element)v.get(1367)).setAttribute("height","8" );
      ((Element)v.get(1366)).appendChild((Element)v.get(1367));
      /* Termina nodo:1367   */
      /* Termina nodo:1366   */

      /* Empieza nodo:1368 / Elemento padre: 1353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1353)).appendChild((Element)v.get(1368));

      /* Empieza nodo:1369 / Elemento padre: 1368   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1369)).setAttribute("nombre","ckModificableBaseCalculoDescuentoSupergenerico" );
      ((Element)v.get(1369)).setAttribute("id","datosCampos" );
      ((Element)v.get(1369)).setAttribute("onclick","" );
      ((Element)v.get(1369)).setAttribute("check","S" );
      ((Element)v.get(1368)).appendChild((Element)v.get(1369));
      /* Termina nodo:1369   */
      /* Termina nodo:1368   */

      /* Empieza nodo:1370 / Elemento padre: 1353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1370)).setAttribute("width","100%" );
      ((Element)v.get(1353)).appendChild((Element)v.get(1370));

      /* Empieza nodo:1371 / Elemento padre: 1370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1371)).setAttribute("src","b.gif" );
      ((Element)v.get(1371)).setAttribute("width","8" );
      ((Element)v.get(1371)).setAttribute("height","8" );
      ((Element)v.get(1370)).appendChild((Element)v.get(1371));
      /* Termina nodo:1371   */
      /* Termina nodo:1370   */
      /* Termina nodo:1353   */

      /* Empieza nodo:1372 / Elemento padre: 1330   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1330)).appendChild((Element)v.get(1372));

      /* Empieza nodo:1373 / Elemento padre: 1372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1373)).setAttribute("colspan","4" );
      ((Element)v.get(1372)).appendChild((Element)v.get(1373));

      /* Empieza nodo:1374 / Elemento padre: 1373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1374)).setAttribute("src","b.gif" );
      ((Element)v.get(1374)).setAttribute("width","8" );
      ((Element)v.get(1374)).setAttribute("height","8" );
      ((Element)v.get(1373)).appendChild((Element)v.get(1374));
      /* Termina nodo:1374   */
      /* Termina nodo:1373   */
      /* Termina nodo:1372   */
      /* Termina nodo:1330   */
      /* Termina nodo:1327   */
      /* Termina nodo:1326   */

      /* Empieza nodo:1375 / Elemento padre: 1323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1323)).appendChild((Element)v.get(1375));

      /* Empieza nodo:1376 / Elemento padre: 1375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1376)).setAttribute("src","b.gif" );
      ((Element)v.get(1375)).appendChild((Element)v.get(1376));
      /* Termina nodo:1376   */
      /* Termina nodo:1375   */
      /* Termina nodo:1323   */

      /* Empieza nodo:1377 / Elemento padre: 1322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1322)).appendChild((Element)v.get(1377));

      /* Empieza nodo:1378 / Elemento padre: 1377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1378)).setAttribute("width","12" );
      ((Element)v.get(1378)).setAttribute("align","center" );
      ((Element)v.get(1377)).appendChild((Element)v.get(1378));

      /* Empieza nodo:1379 / Elemento padre: 1378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1379)).setAttribute("src","b.gif" );
      ((Element)v.get(1379)).setAttribute("width","12" );
      ((Element)v.get(1379)).setAttribute("height","15" );
      ((Element)v.get(1378)).appendChild((Element)v.get(1379));
      /* Termina nodo:1379   */
      /* Termina nodo:1378   */

      /* Empieza nodo:1380 / Elemento padre: 1377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1380)).setAttribute("width","756" );
      ((Element)v.get(1377)).appendChild((Element)v.get(1380));

      /* Empieza nodo:1381 / Elemento padre: 1380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1381)).setAttribute("src","b.gif" );
      ((Element)v.get(1380)).appendChild((Element)v.get(1381));
      /* Termina nodo:1381   */
      /* Termina nodo:1380   */

      /* Empieza nodo:1382 / Elemento padre: 1377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1382)).setAttribute("width","12" );
      ((Element)v.get(1377)).appendChild((Element)v.get(1382));

      /* Empieza nodo:1383 / Elemento padre: 1382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1383)).setAttribute("src","b.gif" );
      ((Element)v.get(1383)).setAttribute("width","12" );
      ((Element)v.get(1383)).setAttribute("height","1" );
      ((Element)v.get(1382)).appendChild((Element)v.get(1383));
      /* Termina nodo:1383   */
      /* Termina nodo:1382   */
      /* Termina nodo:1377   */
      /* Termina nodo:1322   */

      /* Empieza nodo:1384 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1384)).setAttribute("width","100%" );
      ((Element)v.get(1384)).setAttribute("border","0" );
      ((Element)v.get(1384)).setAttribute("align","center" );
      ((Element)v.get(1384)).setAttribute("cellspacing","0" );
      ((Element)v.get(1384)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1384));

      /* Empieza nodo:1385 / Elemento padre: 1384   */
   }

   private void getXML5490(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(1384)).appendChild((Element)v.get(1385));

      /* Empieza nodo:1386 / Elemento padre: 1385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1385)).appendChild((Element)v.get(1386));

      /* Empieza nodo:1387 / Elemento padre: 1386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1387)).setAttribute("src","b.gif" );
      ((Element)v.get(1387)).setAttribute("width","8" );
      ((Element)v.get(1387)).setAttribute("height","8" );
      ((Element)v.get(1386)).appendChild((Element)v.get(1387));
      /* Termina nodo:1387   */
      /* Termina nodo:1386   */

      /* Empieza nodo:1388 / Elemento padre: 1385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1388)).setAttribute("width","100%" );
      ((Element)v.get(1385)).appendChild((Element)v.get(1388));

      /* Empieza nodo:1389 / Elemento padre: 1388   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1388)).appendChild((Element)v.get(1389));

      /* Empieza nodo:1390 / Elemento padre: 1389   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1390)).setAttribute("class","legend" );
      ((Element)v.get(1389)).appendChild((Element)v.get(1390));

      /* Empieza nodo:1391 / Elemento padre: 1390   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1391)).setAttribute("nombre","lblBaseCalculoDescuentoGenerico" );
      ((Element)v.get(1391)).setAttribute("alto","13" );
      ((Element)v.get(1391)).setAttribute("filas","1" );
      ((Element)v.get(1391)).setAttribute("valor","" );
      ((Element)v.get(1391)).setAttribute("id","legend" );
      ((Element)v.get(1391)).setAttribute("cod","00480" );
      ((Element)v.get(1390)).appendChild((Element)v.get(1391));
      /* Termina nodo:1391   */
      /* Termina nodo:1390   */

      /* Empieza nodo:1392 / Elemento padre: 1389   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1392)).setAttribute("width","100%" );
      ((Element)v.get(1392)).setAttribute("border","0" );
      ((Element)v.get(1392)).setAttribute("align","center" );
      ((Element)v.get(1392)).setAttribute("cellspacing","0" );
      ((Element)v.get(1392)).setAttribute("cellpadding","0" );
      ((Element)v.get(1389)).appendChild((Element)v.get(1392));

      /* Empieza nodo:1393 / Elemento padre: 1392   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1392)).appendChild((Element)v.get(1393));

      /* Empieza nodo:1394 / Elemento padre: 1393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1394)).setAttribute("colspan","3" );
      ((Element)v.get(1393)).appendChild((Element)v.get(1394));

      /* Empieza nodo:1395 / Elemento padre: 1394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1395)).setAttribute("src","b.gif" );
      ((Element)v.get(1395)).setAttribute("width","8" );
      ((Element)v.get(1395)).setAttribute("height","8" );
      ((Element)v.get(1394)).appendChild((Element)v.get(1395));
      /* Termina nodo:1395   */
      /* Termina nodo:1394   */
      /* Termina nodo:1393   */

      /* Empieza nodo:1396 / Elemento padre: 1392   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1392)).appendChild((Element)v.get(1396));

      /* Empieza nodo:1397 / Elemento padre: 1396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1396)).appendChild((Element)v.get(1397));

      /* Empieza nodo:1398 / Elemento padre: 1397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1398)).setAttribute("src","b.gif" );
      ((Element)v.get(1398)).setAttribute("width","8" );
      ((Element)v.get(1398)).setAttribute("height","8" );
      ((Element)v.get(1397)).appendChild((Element)v.get(1398));
      /* Termina nodo:1398   */
      /* Termina nodo:1397   */

      /* Empieza nodo:1399 / Elemento padre: 1396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1396)).appendChild((Element)v.get(1399));

      /* Empieza nodo:1400 / Elemento padre: 1399   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1400)).setAttribute("nombre","lblCodigoBaseCalculoDescuentoGenerico" );
      ((Element)v.get(1400)).setAttribute("alto","13" );
      ((Element)v.get(1400)).setAttribute("filas","1" );
      ((Element)v.get(1400)).setAttribute("valor","" );
      ((Element)v.get(1400)).setAttribute("id","datosTitle" );
      ((Element)v.get(1400)).setAttribute("cod","8" );
      ((Element)v.get(1399)).appendChild((Element)v.get(1400));
      /* Termina nodo:1400   */
      /* Termina nodo:1399   */

      /* Empieza nodo:1401 / Elemento padre: 1396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1396)).appendChild((Element)v.get(1401));

      /* Empieza nodo:1402 / Elemento padre: 1401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1402)).setAttribute("src","b.gif" );
      ((Element)v.get(1402)).setAttribute("width","25" );
      ((Element)v.get(1402)).setAttribute("height","8" );
      ((Element)v.get(1401)).appendChild((Element)v.get(1402));
      /* Termina nodo:1402   */
      /* Termina nodo:1401   */

      /* Empieza nodo:1403 / Elemento padre: 1396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1396)).appendChild((Element)v.get(1403));

      /* Empieza nodo:1404 / Elemento padre: 1403   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1404)).setAttribute("nombre","lblVisibleBaseCalculoDescuentoGenerico" );
      ((Element)v.get(1404)).setAttribute("alto","13" );
      ((Element)v.get(1404)).setAttribute("filas","1" );
      ((Element)v.get(1404)).setAttribute("valor","" );
      ((Element)v.get(1404)).setAttribute("id","datosTitle" );
      ((Element)v.get(1404)).setAttribute("cod","1038" );
      ((Element)v.get(1403)).appendChild((Element)v.get(1404));
      /* Termina nodo:1404   */
      /* Termina nodo:1403   */

      /* Empieza nodo:1405 / Elemento padre: 1396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1396)).appendChild((Element)v.get(1405));

      /* Empieza nodo:1406 / Elemento padre: 1405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1406)).setAttribute("src","b.gif" );
      ((Element)v.get(1406)).setAttribute("width","25" );
      ((Element)v.get(1406)).setAttribute("height","8" );
      ((Element)v.get(1405)).appendChild((Element)v.get(1406));
      /* Termina nodo:1406   */
      /* Termina nodo:1405   */

      /* Empieza nodo:1407 / Elemento padre: 1396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1396)).appendChild((Element)v.get(1407));

      /* Empieza nodo:1408 / Elemento padre: 1407   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1408)).setAttribute("nombre","lblObligatorioBaseCalculoDescuentoGenerico" );
      ((Element)v.get(1408)).setAttribute("alto","13" );
   }

   private void getXML5580(Document doc) {
      ((Element)v.get(1408)).setAttribute("filas","1" );
      ((Element)v.get(1408)).setAttribute("valor","" );
      ((Element)v.get(1408)).setAttribute("id","datosTitle" );
      ((Element)v.get(1408)).setAttribute("cod","949" );
      ((Element)v.get(1407)).appendChild((Element)v.get(1408));
      /* Termina nodo:1408   */
      /* Termina nodo:1407   */

      /* Empieza nodo:1409 / Elemento padre: 1396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1396)).appendChild((Element)v.get(1409));

      /* Empieza nodo:1410 / Elemento padre: 1409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1410)).setAttribute("src","b.gif" );
      ((Element)v.get(1410)).setAttribute("width","25" );
      ((Element)v.get(1410)).setAttribute("height","8" );
      ((Element)v.get(1409)).appendChild((Element)v.get(1410));
      /* Termina nodo:1410   */
      /* Termina nodo:1409   */

      /* Empieza nodo:1411 / Elemento padre: 1396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1396)).appendChild((Element)v.get(1411));

      /* Empieza nodo:1412 / Elemento padre: 1411   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1412)).setAttribute("nombre","lblModificableBaseCalculoDescuentoGenerico" );
      ((Element)v.get(1412)).setAttribute("alto","13" );
      ((Element)v.get(1412)).setAttribute("filas","1" );
      ((Element)v.get(1412)).setAttribute("valor","" );
      ((Element)v.get(1412)).setAttribute("id","datosTitle" );
      ((Element)v.get(1412)).setAttribute("cod","914" );
      ((Element)v.get(1411)).appendChild((Element)v.get(1412));
      /* Termina nodo:1412   */
      /* Termina nodo:1411   */

      /* Empieza nodo:1413 / Elemento padre: 1396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1413)).setAttribute("width","100%" );
      ((Element)v.get(1396)).appendChild((Element)v.get(1413));

      /* Empieza nodo:1414 / Elemento padre: 1413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1414)).setAttribute("src","b.gif" );
      ((Element)v.get(1414)).setAttribute("width","8" );
      ((Element)v.get(1414)).setAttribute("height","8" );
      ((Element)v.get(1413)).appendChild((Element)v.get(1414));
      /* Termina nodo:1414   */
      /* Termina nodo:1413   */
      /* Termina nodo:1396   */

      /* Empieza nodo:1415 / Elemento padre: 1392   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1392)).appendChild((Element)v.get(1415));

      /* Empieza nodo:1416 / Elemento padre: 1415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1415)).appendChild((Element)v.get(1416));

      /* Empieza nodo:1417 / Elemento padre: 1416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1417)).setAttribute("src","b.gif" );
      ((Element)v.get(1417)).setAttribute("width","8" );
      ((Element)v.get(1417)).setAttribute("height","8" );
      ((Element)v.get(1416)).appendChild((Element)v.get(1417));
      /* Termina nodo:1417   */
      /* Termina nodo:1416   */

      /* Empieza nodo:1418 / Elemento padre: 1415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1415)).appendChild((Element)v.get(1418));

      /* Empieza nodo:1419 / Elemento padre: 1418   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1419)).setAttribute("nombre","lbldtCodigoBaseCalculoDescuentoGenerico" );
      ((Element)v.get(1419)).setAttribute("alto","18" );
      ((Element)v.get(1419)).setAttribute("filas","1" );
      ((Element)v.get(1419)).setAttribute("valor","18" );
      ((Element)v.get(1419)).setAttribute("id","datosCampos" );
      ((Element)v.get(1418)).appendChild((Element)v.get(1419));
      /* Termina nodo:1419   */
      /* Termina nodo:1418   */

      /* Empieza nodo:1420 / Elemento padre: 1415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1415)).appendChild((Element)v.get(1420));

      /* Empieza nodo:1421 / Elemento padre: 1420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1421)).setAttribute("src","b.gif" );
      ((Element)v.get(1421)).setAttribute("width","25" );
      ((Element)v.get(1421)).setAttribute("height","8" );
      ((Element)v.get(1420)).appendChild((Element)v.get(1421));
      /* Termina nodo:1421   */
      /* Termina nodo:1420   */

      /* Empieza nodo:1422 / Elemento padre: 1415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1415)).appendChild((Element)v.get(1422));

      /* Empieza nodo:1423 / Elemento padre: 1422   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1423)).setAttribute("nombre","ckVisibleBaseCalculoDescuentoGenerico" );
      ((Element)v.get(1423)).setAttribute("id","datosCampos" );
      ((Element)v.get(1423)).setAttribute("onclick","cambiaObli(16)" );
      ((Element)v.get(1423)).setAttribute("check","S" );
      ((Element)v.get(1422)).appendChild((Element)v.get(1423));
      /* Termina nodo:1423   */
      /* Termina nodo:1422   */

      /* Empieza nodo:1424 / Elemento padre: 1415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1415)).appendChild((Element)v.get(1424));

      /* Empieza nodo:1425 / Elemento padre: 1424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1425)).setAttribute("src","b.gif" );
      ((Element)v.get(1425)).setAttribute("width","25" );
      ((Element)v.get(1425)).setAttribute("height","8" );
      ((Element)v.get(1424)).appendChild((Element)v.get(1425));
      /* Termina nodo:1425   */
      /* Termina nodo:1424   */

      /* Empieza nodo:1426 / Elemento padre: 1415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1415)).appendChild((Element)v.get(1426));

      /* Empieza nodo:1427 / Elemento padre: 1426   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1427)).setAttribute("nombre","ckObligatorioBaseCalculoDescuentoGenerico" );
      ((Element)v.get(1427)).setAttribute("id","datosCampos" );
      ((Element)v.get(1427)).setAttribute("onclick","" );
      ((Element)v.get(1427)).setAttribute("check","N" );
      ((Element)v.get(1426)).appendChild((Element)v.get(1427));
      /* Termina nodo:1427   */
      /* Termina nodo:1426   */

      /* Empieza nodo:1428 / Elemento padre: 1415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1415)).appendChild((Element)v.get(1428));

      /* Empieza nodo:1429 / Elemento padre: 1428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1429)).setAttribute("src","b.gif" );
      ((Element)v.get(1429)).setAttribute("width","25" );
      ((Element)v.get(1429)).setAttribute("height","8" );
      ((Element)v.get(1428)).appendChild((Element)v.get(1429));
      /* Termina nodo:1429   */
      /* Termina nodo:1428   */

      /* Empieza nodo:1430 / Elemento padre: 1415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1415)).appendChild((Element)v.get(1430));

      /* Empieza nodo:1431 / Elemento padre: 1430   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1431)).setAttribute("nombre","ckModificableBaseCalculoDescuentoGenerico" );
      ((Element)v.get(1431)).setAttribute("id","datosCampos" );
   }

   private void getXML5670(Document doc) {
      ((Element)v.get(1431)).setAttribute("onclick","" );
      ((Element)v.get(1431)).setAttribute("check","S" );
      ((Element)v.get(1430)).appendChild((Element)v.get(1431));
      /* Termina nodo:1431   */
      /* Termina nodo:1430   */

      /* Empieza nodo:1432 / Elemento padre: 1415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1432)).setAttribute("width","100%" );
      ((Element)v.get(1415)).appendChild((Element)v.get(1432));

      /* Empieza nodo:1433 / Elemento padre: 1432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1433)).setAttribute("src","b.gif" );
      ((Element)v.get(1433)).setAttribute("width","8" );
      ((Element)v.get(1433)).setAttribute("height","8" );
      ((Element)v.get(1432)).appendChild((Element)v.get(1433));
      /* Termina nodo:1433   */
      /* Termina nodo:1432   */
      /* Termina nodo:1415   */

      /* Empieza nodo:1434 / Elemento padre: 1392   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1392)).appendChild((Element)v.get(1434));

      /* Empieza nodo:1435 / Elemento padre: 1434   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1435)).setAttribute("colspan","4" );
      ((Element)v.get(1434)).appendChild((Element)v.get(1435));

      /* Empieza nodo:1436 / Elemento padre: 1435   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1436)).setAttribute("src","b.gif" );
      ((Element)v.get(1436)).setAttribute("width","8" );
      ((Element)v.get(1436)).setAttribute("height","8" );
      ((Element)v.get(1435)).appendChild((Element)v.get(1436));
      /* Termina nodo:1436   */
      /* Termina nodo:1435   */
      /* Termina nodo:1434   */
      /* Termina nodo:1392   */
      /* Termina nodo:1389   */
      /* Termina nodo:1388   */

      /* Empieza nodo:1437 / Elemento padre: 1385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1385)).appendChild((Element)v.get(1437));

      /* Empieza nodo:1438 / Elemento padre: 1437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1438)).setAttribute("src","b.gif" );
      ((Element)v.get(1437)).appendChild((Element)v.get(1438));
      /* Termina nodo:1438   */
      /* Termina nodo:1437   */
      /* Termina nodo:1385   */

      /* Empieza nodo:1439 / Elemento padre: 1384   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1384)).appendChild((Element)v.get(1439));

      /* Empieza nodo:1440 / Elemento padre: 1439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1440)).setAttribute("width","12" );
      ((Element)v.get(1440)).setAttribute("align","center" );
      ((Element)v.get(1439)).appendChild((Element)v.get(1440));

      /* Empieza nodo:1441 / Elemento padre: 1440   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1441)).setAttribute("src","b.gif" );
      ((Element)v.get(1441)).setAttribute("width","12" );
      ((Element)v.get(1441)).setAttribute("height","15" );
      ((Element)v.get(1440)).appendChild((Element)v.get(1441));
      /* Termina nodo:1441   */
      /* Termina nodo:1440   */

      /* Empieza nodo:1442 / Elemento padre: 1439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1442)).setAttribute("width","756" );
      ((Element)v.get(1439)).appendChild((Element)v.get(1442));

      /* Empieza nodo:1443 / Elemento padre: 1442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1443)).setAttribute("src","b.gif" );
      ((Element)v.get(1442)).appendChild((Element)v.get(1443));
      /* Termina nodo:1443   */
      /* Termina nodo:1442   */

      /* Empieza nodo:1444 / Elemento padre: 1439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1444)).setAttribute("width","12" );
      ((Element)v.get(1439)).appendChild((Element)v.get(1444));

      /* Empieza nodo:1445 / Elemento padre: 1444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1445)).setAttribute("src","b.gif" );
      ((Element)v.get(1445)).setAttribute("width","12" );
      ((Element)v.get(1445)).setAttribute("height","1" );
      ((Element)v.get(1444)).appendChild((Element)v.get(1445));
      /* Termina nodo:1445   */
      /* Termina nodo:1444   */
      /* Termina nodo:1439   */
      /* Termina nodo:1384   */

      /* Empieza nodo:1446 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1446)).setAttribute("width","100%" );
      ((Element)v.get(1446)).setAttribute("border","0" );
      ((Element)v.get(1446)).setAttribute("align","center" );
      ((Element)v.get(1446)).setAttribute("cellspacing","0" );
      ((Element)v.get(1446)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1446));

      /* Empieza nodo:1447 / Elemento padre: 1446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1446)).appendChild((Element)v.get(1447));

      /* Empieza nodo:1448 / Elemento padre: 1447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1447)).appendChild((Element)v.get(1448));

      /* Empieza nodo:1449 / Elemento padre: 1448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1449)).setAttribute("src","b.gif" );
      ((Element)v.get(1449)).setAttribute("width","8" );
      ((Element)v.get(1449)).setAttribute("height","8" );
      ((Element)v.get(1448)).appendChild((Element)v.get(1449));
      /* Termina nodo:1449   */
      /* Termina nodo:1448   */

      /* Empieza nodo:1450 / Elemento padre: 1447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1450)).setAttribute("width","100%" );
      ((Element)v.get(1447)).appendChild((Element)v.get(1450));

      /* Empieza nodo:1451 / Elemento padre: 1450   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1450)).appendChild((Element)v.get(1451));

      /* Empieza nodo:1452 / Elemento padre: 1451   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1452)).setAttribute("class","legend" );
      ((Element)v.get(1451)).appendChild((Element)v.get(1452));

      /* Empieza nodo:1453 / Elemento padre: 1452   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1453)).setAttribute("nombre","lblBaseCalculoDescuentoProducto" );
      ((Element)v.get(1453)).setAttribute("alto","13" );
      ((Element)v.get(1453)).setAttribute("filas","1" );
      ((Element)v.get(1453)).setAttribute("valor","" );
      ((Element)v.get(1453)).setAttribute("id","legend" );
      ((Element)v.get(1453)).setAttribute("cod","00481" );
      ((Element)v.get(1452)).appendChild((Element)v.get(1453));
      /* Termina nodo:1453   */
      /* Termina nodo:1452   */

      /* Empieza nodo:1454 / Elemento padre: 1451   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1454)).setAttribute("width","100%" );
      ((Element)v.get(1454)).setAttribute("border","0" );
      ((Element)v.get(1454)).setAttribute("align","center" );
      ((Element)v.get(1454)).setAttribute("cellspacing","0" );
      ((Element)v.get(1454)).setAttribute("cellpadding","0" );
      ((Element)v.get(1451)).appendChild((Element)v.get(1454));

      /* Empieza nodo:1455 / Elemento padre: 1454   */
   }

   private void getXML5760(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(1454)).appendChild((Element)v.get(1455));

      /* Empieza nodo:1456 / Elemento padre: 1455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1456)).setAttribute("colspan","3" );
      ((Element)v.get(1455)).appendChild((Element)v.get(1456));

      /* Empieza nodo:1457 / Elemento padre: 1456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1457)).setAttribute("src","b.gif" );
      ((Element)v.get(1457)).setAttribute("width","8" );
      ((Element)v.get(1457)).setAttribute("height","8" );
      ((Element)v.get(1456)).appendChild((Element)v.get(1457));
      /* Termina nodo:1457   */
      /* Termina nodo:1456   */
      /* Termina nodo:1455   */

      /* Empieza nodo:1458 / Elemento padre: 1454   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1454)).appendChild((Element)v.get(1458));

      /* Empieza nodo:1459 / Elemento padre: 1458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1458)).appendChild((Element)v.get(1459));

      /* Empieza nodo:1460 / Elemento padre: 1459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1460)).setAttribute("src","b.gif" );
      ((Element)v.get(1460)).setAttribute("width","8" );
      ((Element)v.get(1460)).setAttribute("height","8" );
      ((Element)v.get(1459)).appendChild((Element)v.get(1460));
      /* Termina nodo:1460   */
      /* Termina nodo:1459   */

      /* Empieza nodo:1461 / Elemento padre: 1458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1458)).appendChild((Element)v.get(1461));

      /* Empieza nodo:1462 / Elemento padre: 1461   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1462)).setAttribute("nombre","lblCodigoBaseCalculoDescuentoProducto" );
      ((Element)v.get(1462)).setAttribute("alto","13" );
      ((Element)v.get(1462)).setAttribute("filas","1" );
      ((Element)v.get(1462)).setAttribute("valor","" );
      ((Element)v.get(1462)).setAttribute("id","datosTitle" );
      ((Element)v.get(1462)).setAttribute("cod","8" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1462));
      /* Termina nodo:1462   */
      /* Termina nodo:1461   */

      /* Empieza nodo:1463 / Elemento padre: 1458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1458)).appendChild((Element)v.get(1463));

      /* Empieza nodo:1464 / Elemento padre: 1463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1464)).setAttribute("src","b.gif" );
      ((Element)v.get(1464)).setAttribute("width","25" );
      ((Element)v.get(1464)).setAttribute("height","8" );
      ((Element)v.get(1463)).appendChild((Element)v.get(1464));
      /* Termina nodo:1464   */
      /* Termina nodo:1463   */

      /* Empieza nodo:1465 / Elemento padre: 1458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1458)).appendChild((Element)v.get(1465));

      /* Empieza nodo:1466 / Elemento padre: 1465   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1466)).setAttribute("nombre","lblVisibleBaseCalculoDescuentoProducto" );
      ((Element)v.get(1466)).setAttribute("alto","13" );
      ((Element)v.get(1466)).setAttribute("filas","1" );
      ((Element)v.get(1466)).setAttribute("valor","" );
      ((Element)v.get(1466)).setAttribute("id","datosTitle" );
      ((Element)v.get(1466)).setAttribute("cod","1038" );
      ((Element)v.get(1465)).appendChild((Element)v.get(1466));
      /* Termina nodo:1466   */
      /* Termina nodo:1465   */

      /* Empieza nodo:1467 / Elemento padre: 1458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1458)).appendChild((Element)v.get(1467));

      /* Empieza nodo:1468 / Elemento padre: 1467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1468)).setAttribute("src","b.gif" );
      ((Element)v.get(1468)).setAttribute("width","25" );
      ((Element)v.get(1468)).setAttribute("height","8" );
      ((Element)v.get(1467)).appendChild((Element)v.get(1468));
      /* Termina nodo:1468   */
      /* Termina nodo:1467   */

      /* Empieza nodo:1469 / Elemento padre: 1458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1458)).appendChild((Element)v.get(1469));

      /* Empieza nodo:1470 / Elemento padre: 1469   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1470)).setAttribute("nombre","lblObligatorioBaseCalculoDescuentoProducto" );
      ((Element)v.get(1470)).setAttribute("alto","13" );
      ((Element)v.get(1470)).setAttribute("filas","1" );
      ((Element)v.get(1470)).setAttribute("valor","" );
      ((Element)v.get(1470)).setAttribute("id","datosTitle" );
      ((Element)v.get(1470)).setAttribute("cod","949" );
      ((Element)v.get(1469)).appendChild((Element)v.get(1470));
      /* Termina nodo:1470   */
      /* Termina nodo:1469   */

      /* Empieza nodo:1471 / Elemento padre: 1458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1458)).appendChild((Element)v.get(1471));

      /* Empieza nodo:1472 / Elemento padre: 1471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1472)).setAttribute("src","b.gif" );
      ((Element)v.get(1472)).setAttribute("width","25" );
      ((Element)v.get(1472)).setAttribute("height","8" );
      ((Element)v.get(1471)).appendChild((Element)v.get(1472));
      /* Termina nodo:1472   */
      /* Termina nodo:1471   */

      /* Empieza nodo:1473 / Elemento padre: 1458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1458)).appendChild((Element)v.get(1473));

      /* Empieza nodo:1474 / Elemento padre: 1473   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1474)).setAttribute("nombre","lblModificableBaseCalculoDescuentoProducto" );
      ((Element)v.get(1474)).setAttribute("alto","13" );
      ((Element)v.get(1474)).setAttribute("filas","1" );
      ((Element)v.get(1474)).setAttribute("valor","" );
      ((Element)v.get(1474)).setAttribute("id","datosTitle" );
      ((Element)v.get(1474)).setAttribute("cod","914" );
      ((Element)v.get(1473)).appendChild((Element)v.get(1474));
      /* Termina nodo:1474   */
      /* Termina nodo:1473   */

      /* Empieza nodo:1475 / Elemento padre: 1458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1475)).setAttribute("width","100%" );
      ((Element)v.get(1458)).appendChild((Element)v.get(1475));

      /* Empieza nodo:1476 / Elemento padre: 1475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1476)).setAttribute("src","b.gif" );
      ((Element)v.get(1476)).setAttribute("width","8" );
      ((Element)v.get(1476)).setAttribute("height","8" );
      ((Element)v.get(1475)).appendChild((Element)v.get(1476));
      /* Termina nodo:1476   */
      /* Termina nodo:1475   */
      /* Termina nodo:1458   */

      /* Empieza nodo:1477 / Elemento padre: 1454   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1454)).appendChild((Element)v.get(1477));

      /* Empieza nodo:1478 / Elemento padre: 1477   */
   }

   private void getXML5850(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(1477)).appendChild((Element)v.get(1478));

      /* Empieza nodo:1479 / Elemento padre: 1478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1479)).setAttribute("src","b.gif" );
      ((Element)v.get(1479)).setAttribute("width","8" );
      ((Element)v.get(1479)).setAttribute("height","8" );
      ((Element)v.get(1478)).appendChild((Element)v.get(1479));
      /* Termina nodo:1479   */
      /* Termina nodo:1478   */

      /* Empieza nodo:1480 / Elemento padre: 1477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1477)).appendChild((Element)v.get(1480));

      /* Empieza nodo:1481 / Elemento padre: 1480   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1481)).setAttribute("nombre","lbldtCodigoBaseCalculoDescuentoProducto" );
      ((Element)v.get(1481)).setAttribute("alto","13" );
      ((Element)v.get(1481)).setAttribute("filas","1" );
      ((Element)v.get(1481)).setAttribute("valor","19" );
      ((Element)v.get(1481)).setAttribute("id","datosCampos" );
      ((Element)v.get(1480)).appendChild((Element)v.get(1481));
      /* Termina nodo:1481   */
      /* Termina nodo:1480   */

      /* Empieza nodo:1482 / Elemento padre: 1477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1477)).appendChild((Element)v.get(1482));

      /* Empieza nodo:1483 / Elemento padre: 1482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1483)).setAttribute("src","b.gif" );
      ((Element)v.get(1483)).setAttribute("width","25" );
      ((Element)v.get(1483)).setAttribute("height","8" );
      ((Element)v.get(1482)).appendChild((Element)v.get(1483));
      /* Termina nodo:1483   */
      /* Termina nodo:1482   */

      /* Empieza nodo:1484 / Elemento padre: 1477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1477)).appendChild((Element)v.get(1484));

      /* Empieza nodo:1485 / Elemento padre: 1484   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1485)).setAttribute("nombre","ckVisibleBaseCalculoDescuentoProducto" );
      ((Element)v.get(1485)).setAttribute("id","datosCampos" );
      ((Element)v.get(1485)).setAttribute("onclick","cambiaObli(17)" );
      ((Element)v.get(1485)).setAttribute("check","S" );
      ((Element)v.get(1484)).appendChild((Element)v.get(1485));
      /* Termina nodo:1485   */
      /* Termina nodo:1484   */

      /* Empieza nodo:1486 / Elemento padre: 1477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1477)).appendChild((Element)v.get(1486));

      /* Empieza nodo:1487 / Elemento padre: 1486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1487)).setAttribute("src","b.gif" );
      ((Element)v.get(1487)).setAttribute("width","25" );
      ((Element)v.get(1487)).setAttribute("height","8" );
      ((Element)v.get(1486)).appendChild((Element)v.get(1487));
      /* Termina nodo:1487   */
      /* Termina nodo:1486   */

      /* Empieza nodo:1488 / Elemento padre: 1477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1477)).appendChild((Element)v.get(1488));

      /* Empieza nodo:1489 / Elemento padre: 1488   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1489)).setAttribute("nombre","ckObligatorioBaseCalculoDescuentoProducto" );
      ((Element)v.get(1489)).setAttribute("id","datosCampos" );
      ((Element)v.get(1489)).setAttribute("onclick","" );
      ((Element)v.get(1489)).setAttribute("check","N" );
      ((Element)v.get(1488)).appendChild((Element)v.get(1489));
      /* Termina nodo:1489   */
      /* Termina nodo:1488   */

      /* Empieza nodo:1490 / Elemento padre: 1477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1477)).appendChild((Element)v.get(1490));

      /* Empieza nodo:1491 / Elemento padre: 1490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1491)).setAttribute("src","b.gif" );
      ((Element)v.get(1491)).setAttribute("width","25" );
      ((Element)v.get(1491)).setAttribute("height","8" );
      ((Element)v.get(1490)).appendChild((Element)v.get(1491));
      /* Termina nodo:1491   */
      /* Termina nodo:1490   */

      /* Empieza nodo:1492 / Elemento padre: 1477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1477)).appendChild((Element)v.get(1492));

      /* Empieza nodo:1493 / Elemento padre: 1492   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1493)).setAttribute("nombre","ckModificableBaseCalculoDescuentoProducto" );
      ((Element)v.get(1493)).setAttribute("id","datosCampos" );
      ((Element)v.get(1493)).setAttribute("onclick","" );
      ((Element)v.get(1493)).setAttribute("check","S" );
      ((Element)v.get(1492)).appendChild((Element)v.get(1493));
      /* Termina nodo:1493   */
      /* Termina nodo:1492   */

      /* Empieza nodo:1494 / Elemento padre: 1477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1494)).setAttribute("width","100%" );
      ((Element)v.get(1477)).appendChild((Element)v.get(1494));

      /* Empieza nodo:1495 / Elemento padre: 1494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1495)).setAttribute("src","b.gif" );
      ((Element)v.get(1495)).setAttribute("width","8" );
      ((Element)v.get(1495)).setAttribute("height","8" );
      ((Element)v.get(1494)).appendChild((Element)v.get(1495));
      /* Termina nodo:1495   */
      /* Termina nodo:1494   */
      /* Termina nodo:1477   */

      /* Empieza nodo:1496 / Elemento padre: 1454   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1454)).appendChild((Element)v.get(1496));

      /* Empieza nodo:1497 / Elemento padre: 1496   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1497)).setAttribute("colspan","4" );
      ((Element)v.get(1496)).appendChild((Element)v.get(1497));

      /* Empieza nodo:1498 / Elemento padre: 1497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1498)).setAttribute("src","b.gif" );
      ((Element)v.get(1498)).setAttribute("width","8" );
      ((Element)v.get(1498)).setAttribute("height","8" );
      ((Element)v.get(1497)).appendChild((Element)v.get(1498));
      /* Termina nodo:1498   */
      /* Termina nodo:1497   */
      /* Termina nodo:1496   */
      /* Termina nodo:1454   */
      /* Termina nodo:1451   */
      /* Termina nodo:1450   */

      /* Empieza nodo:1499 / Elemento padre: 1447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1447)).appendChild((Element)v.get(1499));

      /* Empieza nodo:1500 / Elemento padre: 1499   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1500)).setAttribute("src","b.gif" );
      ((Element)v.get(1499)).appendChild((Element)v.get(1500));
      /* Termina nodo:1500   */
      /* Termina nodo:1499   */
      /* Termina nodo:1447   */

      /* Empieza nodo:1501 / Elemento padre: 1446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1446)).appendChild((Element)v.get(1501));

      /* Empieza nodo:1502 / Elemento padre: 1501   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1502)).setAttribute("width","12" );
      ((Element)v.get(1502)).setAttribute("align","center" );
      ((Element)v.get(1501)).appendChild((Element)v.get(1502));

      /* Empieza nodo:1503 / Elemento padre: 1502   */
   }

   private void getXML5940(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1503)).setAttribute("src","b.gif" );
      ((Element)v.get(1503)).setAttribute("width","12" );
      ((Element)v.get(1503)).setAttribute("height","15" );
      ((Element)v.get(1502)).appendChild((Element)v.get(1503));
      /* Termina nodo:1503   */
      /* Termina nodo:1502   */

      /* Empieza nodo:1504 / Elemento padre: 1501   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1504)).setAttribute("width","756" );
      ((Element)v.get(1501)).appendChild((Element)v.get(1504));

      /* Empieza nodo:1505 / Elemento padre: 1504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1505)).setAttribute("src","b.gif" );
      ((Element)v.get(1504)).appendChild((Element)v.get(1505));
      /* Termina nodo:1505   */
      /* Termina nodo:1504   */

      /* Empieza nodo:1506 / Elemento padre: 1501   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1506)).setAttribute("width","12" );
      ((Element)v.get(1501)).appendChild((Element)v.get(1506));

      /* Empieza nodo:1507 / Elemento padre: 1506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1507)).setAttribute("src","b.gif" );
      ((Element)v.get(1507)).setAttribute("width","12" );
      ((Element)v.get(1507)).setAttribute("height","1" );
      ((Element)v.get(1506)).appendChild((Element)v.get(1507));
      /* Termina nodo:1507   */
      /* Termina nodo:1506   */
      /* Termina nodo:1501   */
      /* Termina nodo:1446   */

      /* Empieza nodo:1508 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1508)).setAttribute("width","100%" );
      ((Element)v.get(1508)).setAttribute("border","0" );
      ((Element)v.get(1508)).setAttribute("align","center" );
      ((Element)v.get(1508)).setAttribute("cellspacing","0" );
      ((Element)v.get(1508)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1508));

      /* Empieza nodo:1509 / Elemento padre: 1508   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1508)).appendChild((Element)v.get(1509));

      /* Empieza nodo:1510 / Elemento padre: 1509   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1509)).appendChild((Element)v.get(1510));

      /* Empieza nodo:1511 / Elemento padre: 1510   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1511)).setAttribute("src","b.gif" );
      ((Element)v.get(1511)).setAttribute("width","8" );
      ((Element)v.get(1511)).setAttribute("height","8" );
      ((Element)v.get(1510)).appendChild((Element)v.get(1511));
      /* Termina nodo:1511   */
      /* Termina nodo:1510   */

      /* Empieza nodo:1512 / Elemento padre: 1509   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1512)).setAttribute("width","100%" );
      ((Element)v.get(1509)).appendChild((Element)v.get(1512));

      /* Empieza nodo:1513 / Elemento padre: 1512   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1512)).appendChild((Element)v.get(1513));

      /* Empieza nodo:1514 / Elemento padre: 1513   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1514)).setAttribute("class","legend" );
      ((Element)v.get(1513)).appendChild((Element)v.get(1514));

      /* Empieza nodo:1515 / Elemento padre: 1514   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1515)).setAttribute("nombre","lblBaseAplicacionDescuentoMarca" );
      ((Element)v.get(1515)).setAttribute("alto","13" );
      ((Element)v.get(1515)).setAttribute("filas","1" );
      ((Element)v.get(1515)).setAttribute("valor","" );
      ((Element)v.get(1515)).setAttribute("id","legend" );
      ((Element)v.get(1515)).setAttribute("cod","00482" );
      ((Element)v.get(1514)).appendChild((Element)v.get(1515));
      /* Termina nodo:1515   */
      /* Termina nodo:1514   */

      /* Empieza nodo:1516 / Elemento padre: 1513   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1516)).setAttribute("width","100%" );
      ((Element)v.get(1516)).setAttribute("border","0" );
      ((Element)v.get(1516)).setAttribute("align","center" );
      ((Element)v.get(1516)).setAttribute("cellspacing","0" );
      ((Element)v.get(1516)).setAttribute("cellpadding","0" );
      ((Element)v.get(1513)).appendChild((Element)v.get(1516));

      /* Empieza nodo:1517 / Elemento padre: 1516   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1516)).appendChild((Element)v.get(1517));

      /* Empieza nodo:1518 / Elemento padre: 1517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1518)).setAttribute("colspan","3" );
      ((Element)v.get(1517)).appendChild((Element)v.get(1518));

      /* Empieza nodo:1519 / Elemento padre: 1518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1519)).setAttribute("src","b.gif" );
      ((Element)v.get(1519)).setAttribute("width","8" );
      ((Element)v.get(1519)).setAttribute("height","8" );
      ((Element)v.get(1518)).appendChild((Element)v.get(1519));
      /* Termina nodo:1519   */
      /* Termina nodo:1518   */
      /* Termina nodo:1517   */

      /* Empieza nodo:1520 / Elemento padre: 1516   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1516)).appendChild((Element)v.get(1520));

      /* Empieza nodo:1521 / Elemento padre: 1520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1520)).appendChild((Element)v.get(1521));

      /* Empieza nodo:1522 / Elemento padre: 1521   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1522)).setAttribute("src","b.gif" );
      ((Element)v.get(1522)).setAttribute("width","8" );
      ((Element)v.get(1522)).setAttribute("height","8" );
      ((Element)v.get(1521)).appendChild((Element)v.get(1522));
      /* Termina nodo:1522   */
      /* Termina nodo:1521   */

      /* Empieza nodo:1523 / Elemento padre: 1520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1520)).appendChild((Element)v.get(1523));

      /* Empieza nodo:1524 / Elemento padre: 1523   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1524)).setAttribute("nombre","lblCodigoBaseAplicacionDescuentoMarca" );
      ((Element)v.get(1524)).setAttribute("alto","13" );
      ((Element)v.get(1524)).setAttribute("filas","1" );
      ((Element)v.get(1524)).setAttribute("valor","" );
      ((Element)v.get(1524)).setAttribute("id","datosTitle" );
      ((Element)v.get(1524)).setAttribute("cod","8" );
      ((Element)v.get(1523)).appendChild((Element)v.get(1524));
      /* Termina nodo:1524   */
      /* Termina nodo:1523   */

      /* Empieza nodo:1525 / Elemento padre: 1520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1520)).appendChild((Element)v.get(1525));

      /* Empieza nodo:1526 / Elemento padre: 1525   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML6030(Document doc) {
      ((Element)v.get(1526)).setAttribute("src","b.gif" );
      ((Element)v.get(1526)).setAttribute("width","25" );
      ((Element)v.get(1526)).setAttribute("height","8" );
      ((Element)v.get(1525)).appendChild((Element)v.get(1526));
      /* Termina nodo:1526   */
      /* Termina nodo:1525   */

      /* Empieza nodo:1527 / Elemento padre: 1520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1520)).appendChild((Element)v.get(1527));

      /* Empieza nodo:1528 / Elemento padre: 1527   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1528)).setAttribute("nombre","lblVisibleBaseAplicacionDescuentoMarca" );
      ((Element)v.get(1528)).setAttribute("alto","13" );
      ((Element)v.get(1528)).setAttribute("filas","1" );
      ((Element)v.get(1528)).setAttribute("valor","" );
      ((Element)v.get(1528)).setAttribute("id","datosTitle" );
      ((Element)v.get(1528)).setAttribute("cod","1038" );
      ((Element)v.get(1527)).appendChild((Element)v.get(1528));
      /* Termina nodo:1528   */
      /* Termina nodo:1527   */

      /* Empieza nodo:1529 / Elemento padre: 1520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1520)).appendChild((Element)v.get(1529));

      /* Empieza nodo:1530 / Elemento padre: 1529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1530)).setAttribute("src","b.gif" );
      ((Element)v.get(1530)).setAttribute("width","25" );
      ((Element)v.get(1530)).setAttribute("height","8" );
      ((Element)v.get(1529)).appendChild((Element)v.get(1530));
      /* Termina nodo:1530   */
      /* Termina nodo:1529   */

      /* Empieza nodo:1531 / Elemento padre: 1520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1520)).appendChild((Element)v.get(1531));

      /* Empieza nodo:1532 / Elemento padre: 1531   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1532)).setAttribute("nombre","lblObligatorioBaseAplicacionDescuentoMarca" );
      ((Element)v.get(1532)).setAttribute("alto","13" );
      ((Element)v.get(1532)).setAttribute("filas","1" );
      ((Element)v.get(1532)).setAttribute("valor","" );
      ((Element)v.get(1532)).setAttribute("id","datosTitle" );
      ((Element)v.get(1532)).setAttribute("cod","949" );
      ((Element)v.get(1531)).appendChild((Element)v.get(1532));
      /* Termina nodo:1532   */
      /* Termina nodo:1531   */

      /* Empieza nodo:1533 / Elemento padre: 1520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1520)).appendChild((Element)v.get(1533));

      /* Empieza nodo:1534 / Elemento padre: 1533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1534)).setAttribute("src","b.gif" );
      ((Element)v.get(1534)).setAttribute("width","25" );
      ((Element)v.get(1534)).setAttribute("height","8" );
      ((Element)v.get(1533)).appendChild((Element)v.get(1534));
      /* Termina nodo:1534   */
      /* Termina nodo:1533   */

      /* Empieza nodo:1535 / Elemento padre: 1520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1520)).appendChild((Element)v.get(1535));

      /* Empieza nodo:1536 / Elemento padre: 1535   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1536)).setAttribute("nombre","lblModificableBaseAplicacionDescuentoMarca" );
      ((Element)v.get(1536)).setAttribute("alto","13" );
      ((Element)v.get(1536)).setAttribute("filas","1" );
      ((Element)v.get(1536)).setAttribute("valor","" );
      ((Element)v.get(1536)).setAttribute("id","datosTitle" );
      ((Element)v.get(1536)).setAttribute("cod","914" );
      ((Element)v.get(1535)).appendChild((Element)v.get(1536));
      /* Termina nodo:1536   */
      /* Termina nodo:1535   */

      /* Empieza nodo:1537 / Elemento padre: 1520   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1537)).setAttribute("width","100%" );
      ((Element)v.get(1520)).appendChild((Element)v.get(1537));

      /* Empieza nodo:1538 / Elemento padre: 1537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1538)).setAttribute("src","b.gif" );
      ((Element)v.get(1538)).setAttribute("width","8" );
      ((Element)v.get(1538)).setAttribute("height","8" );
      ((Element)v.get(1537)).appendChild((Element)v.get(1538));
      /* Termina nodo:1538   */
      /* Termina nodo:1537   */
      /* Termina nodo:1520   */

      /* Empieza nodo:1539 / Elemento padre: 1516   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1516)).appendChild((Element)v.get(1539));

      /* Empieza nodo:1540 / Elemento padre: 1539   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1539)).appendChild((Element)v.get(1540));

      /* Empieza nodo:1541 / Elemento padre: 1540   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1541)).setAttribute("src","b.gif" );
      ((Element)v.get(1541)).setAttribute("width","8" );
      ((Element)v.get(1541)).setAttribute("height","8" );
      ((Element)v.get(1540)).appendChild((Element)v.get(1541));
      /* Termina nodo:1541   */
      /* Termina nodo:1540   */

      /* Empieza nodo:1542 / Elemento padre: 1539   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1539)).appendChild((Element)v.get(1542));

      /* Empieza nodo:1543 / Elemento padre: 1542   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1543)).setAttribute("nombre","lbldtCodigoBaseAplicacionDescuentoMarca" );
      ((Element)v.get(1543)).setAttribute("alto","13" );
      ((Element)v.get(1543)).setAttribute("filas","1" );
      ((Element)v.get(1543)).setAttribute("valor","20" );
      ((Element)v.get(1543)).setAttribute("id","datosCampos" );
      ((Element)v.get(1542)).appendChild((Element)v.get(1543));
      /* Termina nodo:1543   */
      /* Termina nodo:1542   */

      /* Empieza nodo:1544 / Elemento padre: 1539   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1539)).appendChild((Element)v.get(1544));

      /* Empieza nodo:1545 / Elemento padre: 1544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1545)).setAttribute("src","b.gif" );
      ((Element)v.get(1545)).setAttribute("width","25" );
      ((Element)v.get(1545)).setAttribute("height","8" );
      ((Element)v.get(1544)).appendChild((Element)v.get(1545));
      /* Termina nodo:1545   */
      /* Termina nodo:1544   */

      /* Empieza nodo:1546 / Elemento padre: 1539   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1539)).appendChild((Element)v.get(1546));

      /* Empieza nodo:1547 / Elemento padre: 1546   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1547)).setAttribute("nombre","ckVisibleBaseAplicacionDescuentoMarca" );
      ((Element)v.get(1547)).setAttribute("id","datosCampos" );
      ((Element)v.get(1547)).setAttribute("onclick","cambiaObli(18)" );
      ((Element)v.get(1547)).setAttribute("check","S" );
      ((Element)v.get(1546)).appendChild((Element)v.get(1547));
      /* Termina nodo:1547   */
      /* Termina nodo:1546   */

      /* Empieza nodo:1548 / Elemento padre: 1539   */
      v.add(doc.createElement("td"));
   }

   private void getXML6120(Document doc) {
      ((Element)v.get(1539)).appendChild((Element)v.get(1548));

      /* Empieza nodo:1549 / Elemento padre: 1548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1549)).setAttribute("src","b.gif" );
      ((Element)v.get(1549)).setAttribute("width","25" );
      ((Element)v.get(1549)).setAttribute("height","8" );
      ((Element)v.get(1548)).appendChild((Element)v.get(1549));
      /* Termina nodo:1549   */
      /* Termina nodo:1548   */

      /* Empieza nodo:1550 / Elemento padre: 1539   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1539)).appendChild((Element)v.get(1550));

      /* Empieza nodo:1551 / Elemento padre: 1550   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1551)).setAttribute("nombre","ckObligatorioBaseAplicacionDescuentoMarca" );
      ((Element)v.get(1551)).setAttribute("id","datosCampos" );
      ((Element)v.get(1551)).setAttribute("onclick","" );
      ((Element)v.get(1551)).setAttribute("check","N" );
      ((Element)v.get(1550)).appendChild((Element)v.get(1551));
      /* Termina nodo:1551   */
      /* Termina nodo:1550   */

      /* Empieza nodo:1552 / Elemento padre: 1539   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1539)).appendChild((Element)v.get(1552));

      /* Empieza nodo:1553 / Elemento padre: 1552   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1553)).setAttribute("src","b.gif" );
      ((Element)v.get(1553)).setAttribute("width","25" );
      ((Element)v.get(1553)).setAttribute("height","8" );
      ((Element)v.get(1552)).appendChild((Element)v.get(1553));
      /* Termina nodo:1553   */
      /* Termina nodo:1552   */

      /* Empieza nodo:1554 / Elemento padre: 1539   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1539)).appendChild((Element)v.get(1554));

      /* Empieza nodo:1555 / Elemento padre: 1554   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1555)).setAttribute("nombre","ckModificableBaseAplicacionDescuentoMarca" );
      ((Element)v.get(1555)).setAttribute("id","datosCampos" );
      ((Element)v.get(1555)).setAttribute("onclick","" );
      ((Element)v.get(1555)).setAttribute("check","S" );
      ((Element)v.get(1554)).appendChild((Element)v.get(1555));
      /* Termina nodo:1555   */
      /* Termina nodo:1554   */

      /* Empieza nodo:1556 / Elemento padre: 1539   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1556)).setAttribute("width","100%" );
      ((Element)v.get(1539)).appendChild((Element)v.get(1556));

      /* Empieza nodo:1557 / Elemento padre: 1556   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1557)).setAttribute("src","b.gif" );
      ((Element)v.get(1557)).setAttribute("width","8" );
      ((Element)v.get(1557)).setAttribute("height","8" );
      ((Element)v.get(1556)).appendChild((Element)v.get(1557));
      /* Termina nodo:1557   */
      /* Termina nodo:1556   */
      /* Termina nodo:1539   */

      /* Empieza nodo:1558 / Elemento padre: 1516   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1516)).appendChild((Element)v.get(1558));

      /* Empieza nodo:1559 / Elemento padre: 1558   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1559)).setAttribute("colspan","4" );
      ((Element)v.get(1558)).appendChild((Element)v.get(1559));

      /* Empieza nodo:1560 / Elemento padre: 1559   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1560)).setAttribute("src","b.gif" );
      ((Element)v.get(1560)).setAttribute("width","8" );
      ((Element)v.get(1560)).setAttribute("height","8" );
      ((Element)v.get(1559)).appendChild((Element)v.get(1560));
      /* Termina nodo:1560   */
      /* Termina nodo:1559   */
      /* Termina nodo:1558   */
      /* Termina nodo:1516   */
      /* Termina nodo:1513   */
      /* Termina nodo:1512   */

      /* Empieza nodo:1561 / Elemento padre: 1509   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1509)).appendChild((Element)v.get(1561));

      /* Empieza nodo:1562 / Elemento padre: 1561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1562)).setAttribute("src","b.gif" );
      ((Element)v.get(1561)).appendChild((Element)v.get(1562));
      /* Termina nodo:1562   */
      /* Termina nodo:1561   */
      /* Termina nodo:1509   */

      /* Empieza nodo:1563 / Elemento padre: 1508   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1508)).appendChild((Element)v.get(1563));

      /* Empieza nodo:1564 / Elemento padre: 1563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1564)).setAttribute("width","12" );
      ((Element)v.get(1564)).setAttribute("align","center" );
      ((Element)v.get(1563)).appendChild((Element)v.get(1564));

      /* Empieza nodo:1565 / Elemento padre: 1564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1565)).setAttribute("src","b.gif" );
      ((Element)v.get(1565)).setAttribute("width","12" );
      ((Element)v.get(1565)).setAttribute("height","15" );
      ((Element)v.get(1564)).appendChild((Element)v.get(1565));
      /* Termina nodo:1565   */
      /* Termina nodo:1564   */

      /* Empieza nodo:1566 / Elemento padre: 1563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1566)).setAttribute("width","756" );
      ((Element)v.get(1563)).appendChild((Element)v.get(1566));

      /* Empieza nodo:1567 / Elemento padre: 1566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1567)).setAttribute("src","b.gif" );
      ((Element)v.get(1566)).appendChild((Element)v.get(1567));
      /* Termina nodo:1567   */
      /* Termina nodo:1566   */

      /* Empieza nodo:1568 / Elemento padre: 1563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1568)).setAttribute("width","12" );
      ((Element)v.get(1563)).appendChild((Element)v.get(1568));

      /* Empieza nodo:1569 / Elemento padre: 1568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1569)).setAttribute("src","b.gif" );
      ((Element)v.get(1569)).setAttribute("width","12" );
      ((Element)v.get(1569)).setAttribute("height","1" );
      ((Element)v.get(1568)).appendChild((Element)v.get(1569));
      /* Termina nodo:1569   */
      /* Termina nodo:1568   */
      /* Termina nodo:1563   */
      /* Termina nodo:1508   */

      /* Empieza nodo:1570 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1570)).setAttribute("width","100%" );
      ((Element)v.get(1570)).setAttribute("border","0" );
      ((Element)v.get(1570)).setAttribute("align","center" );
      ((Element)v.get(1570)).setAttribute("cellspacing","0" );
      ((Element)v.get(1570)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1570));

      /* Empieza nodo:1571 / Elemento padre: 1570   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1570)).appendChild((Element)v.get(1571));

      /* Empieza nodo:1572 / Elemento padre: 1571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1571)).appendChild((Element)v.get(1572));

      /* Empieza nodo:1573 / Elemento padre: 1572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1573)).setAttribute("src","b.gif" );
   }

   private void getXML6210(Document doc) {
      ((Element)v.get(1573)).setAttribute("width","8" );
      ((Element)v.get(1573)).setAttribute("height","8" );
      ((Element)v.get(1572)).appendChild((Element)v.get(1573));
      /* Termina nodo:1573   */
      /* Termina nodo:1572   */

      /* Empieza nodo:1574 / Elemento padre: 1571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1574)).setAttribute("width","100%" );
      ((Element)v.get(1571)).appendChild((Element)v.get(1574));

      /* Empieza nodo:1575 / Elemento padre: 1574   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1574)).appendChild((Element)v.get(1575));

      /* Empieza nodo:1576 / Elemento padre: 1575   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1576)).setAttribute("class","legend" );
      ((Element)v.get(1575)).appendChild((Element)v.get(1576));

      /* Empieza nodo:1577 / Elemento padre: 1576   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1577)).setAttribute("nombre","lblBaseAplicacionDescuentoUnidadNegocio" );
      ((Element)v.get(1577)).setAttribute("alto","13" );
      ((Element)v.get(1577)).setAttribute("filas","1" );
      ((Element)v.get(1577)).setAttribute("valor","" );
      ((Element)v.get(1577)).setAttribute("id","legend" );
      ((Element)v.get(1577)).setAttribute("cod","00483" );
      ((Element)v.get(1576)).appendChild((Element)v.get(1577));
      /* Termina nodo:1577   */
      /* Termina nodo:1576   */

      /* Empieza nodo:1578 / Elemento padre: 1575   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1578)).setAttribute("width","100%" );
      ((Element)v.get(1578)).setAttribute("border","0" );
      ((Element)v.get(1578)).setAttribute("align","center" );
      ((Element)v.get(1578)).setAttribute("cellspacing","0" );
      ((Element)v.get(1578)).setAttribute("cellpadding","0" );
      ((Element)v.get(1575)).appendChild((Element)v.get(1578));

      /* Empieza nodo:1579 / Elemento padre: 1578   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1578)).appendChild((Element)v.get(1579));

      /* Empieza nodo:1580 / Elemento padre: 1579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1580)).setAttribute("colspan","3" );
      ((Element)v.get(1579)).appendChild((Element)v.get(1580));

      /* Empieza nodo:1581 / Elemento padre: 1580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1581)).setAttribute("src","b.gif" );
      ((Element)v.get(1581)).setAttribute("width","8" );
      ((Element)v.get(1581)).setAttribute("height","8" );
      ((Element)v.get(1580)).appendChild((Element)v.get(1581));
      /* Termina nodo:1581   */
      /* Termina nodo:1580   */
      /* Termina nodo:1579   */

      /* Empieza nodo:1582 / Elemento padre: 1578   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1578)).appendChild((Element)v.get(1582));

      /* Empieza nodo:1583 / Elemento padre: 1582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1582)).appendChild((Element)v.get(1583));

      /* Empieza nodo:1584 / Elemento padre: 1583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1584)).setAttribute("src","b.gif" );
      ((Element)v.get(1584)).setAttribute("width","8" );
      ((Element)v.get(1584)).setAttribute("height","8" );
      ((Element)v.get(1583)).appendChild((Element)v.get(1584));
      /* Termina nodo:1584   */
      /* Termina nodo:1583   */

      /* Empieza nodo:1585 / Elemento padre: 1582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1582)).appendChild((Element)v.get(1585));

      /* Empieza nodo:1586 / Elemento padre: 1585   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1586)).setAttribute("nombre","lblCodigoBaseAplicacionDescuentoUnidadNegocio" );
      ((Element)v.get(1586)).setAttribute("alto","13" );
      ((Element)v.get(1586)).setAttribute("filas","1" );
      ((Element)v.get(1586)).setAttribute("valor","" );
      ((Element)v.get(1586)).setAttribute("id","datosTitle" );
      ((Element)v.get(1586)).setAttribute("cod","8" );
      ((Element)v.get(1585)).appendChild((Element)v.get(1586));
      /* Termina nodo:1586   */
      /* Termina nodo:1585   */

      /* Empieza nodo:1587 / Elemento padre: 1582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1582)).appendChild((Element)v.get(1587));

      /* Empieza nodo:1588 / Elemento padre: 1587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1588)).setAttribute("src","b.gif" );
      ((Element)v.get(1588)).setAttribute("width","25" );
      ((Element)v.get(1588)).setAttribute("height","8" );
      ((Element)v.get(1587)).appendChild((Element)v.get(1588));
      /* Termina nodo:1588   */
      /* Termina nodo:1587   */

      /* Empieza nodo:1589 / Elemento padre: 1582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1582)).appendChild((Element)v.get(1589));

      /* Empieza nodo:1590 / Elemento padre: 1589   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1590)).setAttribute("nombre","lblVisibleBaseAplicacionDescuentoUnidadNegocio" );
      ((Element)v.get(1590)).setAttribute("alto","13" );
      ((Element)v.get(1590)).setAttribute("filas","1" );
      ((Element)v.get(1590)).setAttribute("valor","" );
      ((Element)v.get(1590)).setAttribute("id","datosTitle" );
      ((Element)v.get(1590)).setAttribute("cod","1038" );
      ((Element)v.get(1589)).appendChild((Element)v.get(1590));
      /* Termina nodo:1590   */
      /* Termina nodo:1589   */

      /* Empieza nodo:1591 / Elemento padre: 1582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1582)).appendChild((Element)v.get(1591));

      /* Empieza nodo:1592 / Elemento padre: 1591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1592)).setAttribute("src","b.gif" );
      ((Element)v.get(1592)).setAttribute("width","25" );
      ((Element)v.get(1592)).setAttribute("height","8" );
      ((Element)v.get(1591)).appendChild((Element)v.get(1592));
      /* Termina nodo:1592   */
      /* Termina nodo:1591   */

      /* Empieza nodo:1593 / Elemento padre: 1582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1582)).appendChild((Element)v.get(1593));

      /* Empieza nodo:1594 / Elemento padre: 1593   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1594)).setAttribute("nombre","lblObligatorioBaseAplicacionDescuentoUnidadNegocio" );
      ((Element)v.get(1594)).setAttribute("alto","13" );
      ((Element)v.get(1594)).setAttribute("filas","1" );
      ((Element)v.get(1594)).setAttribute("valor","" );
      ((Element)v.get(1594)).setAttribute("id","datosTitle" );
      ((Element)v.get(1594)).setAttribute("cod","949" );
      ((Element)v.get(1593)).appendChild((Element)v.get(1594));
      /* Termina nodo:1594   */
      /* Termina nodo:1593   */

      /* Empieza nodo:1595 / Elemento padre: 1582   */
      v.add(doc.createElement("td"));
   }

   private void getXML6300(Document doc) {
      ((Element)v.get(1582)).appendChild((Element)v.get(1595));

      /* Empieza nodo:1596 / Elemento padre: 1595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1596)).setAttribute("src","b.gif" );
      ((Element)v.get(1596)).setAttribute("width","25" );
      ((Element)v.get(1596)).setAttribute("height","8" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1596));
      /* Termina nodo:1596   */
      /* Termina nodo:1595   */

      /* Empieza nodo:1597 / Elemento padre: 1582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1582)).appendChild((Element)v.get(1597));

      /* Empieza nodo:1598 / Elemento padre: 1597   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1598)).setAttribute("nombre","lblModificableBaseAplicacionDescuentoUnidadNegocio" );
      ((Element)v.get(1598)).setAttribute("alto","13" );
      ((Element)v.get(1598)).setAttribute("filas","1" );
      ((Element)v.get(1598)).setAttribute("valor","" );
      ((Element)v.get(1598)).setAttribute("id","datosTitle" );
      ((Element)v.get(1598)).setAttribute("cod","914" );
      ((Element)v.get(1597)).appendChild((Element)v.get(1598));
      /* Termina nodo:1598   */
      /* Termina nodo:1597   */

      /* Empieza nodo:1599 / Elemento padre: 1582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1599)).setAttribute("width","100%" );
      ((Element)v.get(1582)).appendChild((Element)v.get(1599));

      /* Empieza nodo:1600 / Elemento padre: 1599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1600)).setAttribute("src","b.gif" );
      ((Element)v.get(1600)).setAttribute("width","8" );
      ((Element)v.get(1600)).setAttribute("height","8" );
      ((Element)v.get(1599)).appendChild((Element)v.get(1600));
      /* Termina nodo:1600   */
      /* Termina nodo:1599   */
      /* Termina nodo:1582   */

      /* Empieza nodo:1601 / Elemento padre: 1578   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1578)).appendChild((Element)v.get(1601));

      /* Empieza nodo:1602 / Elemento padre: 1601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1601)).appendChild((Element)v.get(1602));

      /* Empieza nodo:1603 / Elemento padre: 1602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1603)).setAttribute("src","b.gif" );
      ((Element)v.get(1603)).setAttribute("width","8" );
      ((Element)v.get(1603)).setAttribute("height","8" );
      ((Element)v.get(1602)).appendChild((Element)v.get(1603));
      /* Termina nodo:1603   */
      /* Termina nodo:1602   */

      /* Empieza nodo:1604 / Elemento padre: 1601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1601)).appendChild((Element)v.get(1604));

      /* Empieza nodo:1605 / Elemento padre: 1604   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1605)).setAttribute("nombre","lbldtCodigoBaseAplicacionDescuentoUnidadNegocio" );
      ((Element)v.get(1605)).setAttribute("alto","13" );
      ((Element)v.get(1605)).setAttribute("filas","1" );
      ((Element)v.get(1605)).setAttribute("valor","21" );
      ((Element)v.get(1605)).setAttribute("id","datosCampos" );
      ((Element)v.get(1604)).appendChild((Element)v.get(1605));
      /* Termina nodo:1605   */
      /* Termina nodo:1604   */

      /* Empieza nodo:1606 / Elemento padre: 1601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1601)).appendChild((Element)v.get(1606));

      /* Empieza nodo:1607 / Elemento padre: 1606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1607)).setAttribute("src","b.gif" );
      ((Element)v.get(1607)).setAttribute("width","25" );
      ((Element)v.get(1607)).setAttribute("height","8" );
      ((Element)v.get(1606)).appendChild((Element)v.get(1607));
      /* Termina nodo:1607   */
      /* Termina nodo:1606   */

      /* Empieza nodo:1608 / Elemento padre: 1601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1601)).appendChild((Element)v.get(1608));

      /* Empieza nodo:1609 / Elemento padre: 1608   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1609)).setAttribute("nombre","ckVisibleBaseAplicacionDescuentoUnidadNegocio" );
      ((Element)v.get(1609)).setAttribute("id","datosCampos" );
      ((Element)v.get(1609)).setAttribute("onclick","cambiaObli(19)" );
      ((Element)v.get(1609)).setAttribute("check","S" );
      ((Element)v.get(1608)).appendChild((Element)v.get(1609));
      /* Termina nodo:1609   */
      /* Termina nodo:1608   */

      /* Empieza nodo:1610 / Elemento padre: 1601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1601)).appendChild((Element)v.get(1610));

      /* Empieza nodo:1611 / Elemento padre: 1610   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1611)).setAttribute("src","b.gif" );
      ((Element)v.get(1611)).setAttribute("width","25" );
      ((Element)v.get(1611)).setAttribute("height","8" );
      ((Element)v.get(1610)).appendChild((Element)v.get(1611));
      /* Termina nodo:1611   */
      /* Termina nodo:1610   */

      /* Empieza nodo:1612 / Elemento padre: 1601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1601)).appendChild((Element)v.get(1612));

      /* Empieza nodo:1613 / Elemento padre: 1612   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1613)).setAttribute("nombre","ckObligatorioBaseAplicacionDescuentoUnidadNegocio" );
      ((Element)v.get(1613)).setAttribute("id","datosCampos" );
      ((Element)v.get(1613)).setAttribute("onclick","" );
      ((Element)v.get(1613)).setAttribute("check","N" );
      ((Element)v.get(1612)).appendChild((Element)v.get(1613));
      /* Termina nodo:1613   */
      /* Termina nodo:1612   */

      /* Empieza nodo:1614 / Elemento padre: 1601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1601)).appendChild((Element)v.get(1614));

      /* Empieza nodo:1615 / Elemento padre: 1614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1615)).setAttribute("src","b.gif" );
      ((Element)v.get(1615)).setAttribute("width","25" );
      ((Element)v.get(1615)).setAttribute("height","8" );
      ((Element)v.get(1614)).appendChild((Element)v.get(1615));
      /* Termina nodo:1615   */
      /* Termina nodo:1614   */

      /* Empieza nodo:1616 / Elemento padre: 1601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1601)).appendChild((Element)v.get(1616));

      /* Empieza nodo:1617 / Elemento padre: 1616   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1617)).setAttribute("nombre","ckModificableBaseAplicacionDescuentoUnidadNegocio" );
      ((Element)v.get(1617)).setAttribute("id","datosCampos" );
      ((Element)v.get(1617)).setAttribute("onclick","" );
      ((Element)v.get(1617)).setAttribute("check","S" );
      ((Element)v.get(1616)).appendChild((Element)v.get(1617));
      /* Termina nodo:1617   */
      /* Termina nodo:1616   */

      /* Empieza nodo:1618 / Elemento padre: 1601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1618)).setAttribute("width","100%" );
      ((Element)v.get(1601)).appendChild((Element)v.get(1618));

      /* Empieza nodo:1619 / Elemento padre: 1618   */
   }

   private void getXML6390(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1619)).setAttribute("src","b.gif" );
      ((Element)v.get(1619)).setAttribute("width","8" );
      ((Element)v.get(1619)).setAttribute("height","8" );
      ((Element)v.get(1618)).appendChild((Element)v.get(1619));
      /* Termina nodo:1619   */
      /* Termina nodo:1618   */
      /* Termina nodo:1601   */

      /* Empieza nodo:1620 / Elemento padre: 1578   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1578)).appendChild((Element)v.get(1620));

      /* Empieza nodo:1621 / Elemento padre: 1620   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1621)).setAttribute("colspan","4" );
      ((Element)v.get(1620)).appendChild((Element)v.get(1621));

      /* Empieza nodo:1622 / Elemento padre: 1621   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1622)).setAttribute("src","b.gif" );
      ((Element)v.get(1622)).setAttribute("width","8" );
      ((Element)v.get(1622)).setAttribute("height","8" );
      ((Element)v.get(1621)).appendChild((Element)v.get(1622));
      /* Termina nodo:1622   */
      /* Termina nodo:1621   */
      /* Termina nodo:1620   */
      /* Termina nodo:1578   */
      /* Termina nodo:1575   */
      /* Termina nodo:1574   */

      /* Empieza nodo:1623 / Elemento padre: 1571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1571)).appendChild((Element)v.get(1623));

      /* Empieza nodo:1624 / Elemento padre: 1623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1624)).setAttribute("src","b.gif" );
      ((Element)v.get(1623)).appendChild((Element)v.get(1624));
      /* Termina nodo:1624   */
      /* Termina nodo:1623   */
      /* Termina nodo:1571   */

      /* Empieza nodo:1625 / Elemento padre: 1570   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1570)).appendChild((Element)v.get(1625));

      /* Empieza nodo:1626 / Elemento padre: 1625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1626)).setAttribute("width","12" );
      ((Element)v.get(1626)).setAttribute("align","center" );
      ((Element)v.get(1625)).appendChild((Element)v.get(1626));

      /* Empieza nodo:1627 / Elemento padre: 1626   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1627)).setAttribute("src","b.gif" );
      ((Element)v.get(1627)).setAttribute("width","12" );
      ((Element)v.get(1627)).setAttribute("height","15" );
      ((Element)v.get(1626)).appendChild((Element)v.get(1627));
      /* Termina nodo:1627   */
      /* Termina nodo:1626   */

      /* Empieza nodo:1628 / Elemento padre: 1625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1628)).setAttribute("width","756" );
      ((Element)v.get(1625)).appendChild((Element)v.get(1628));

      /* Empieza nodo:1629 / Elemento padre: 1628   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1629)).setAttribute("src","b.gif" );
      ((Element)v.get(1628)).appendChild((Element)v.get(1629));
      /* Termina nodo:1629   */
      /* Termina nodo:1628   */

      /* Empieza nodo:1630 / Elemento padre: 1625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1630)).setAttribute("width","12" );
      ((Element)v.get(1625)).appendChild((Element)v.get(1630));

      /* Empieza nodo:1631 / Elemento padre: 1630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1631)).setAttribute("src","b.gif" );
      ((Element)v.get(1631)).setAttribute("width","12" );
      ((Element)v.get(1631)).setAttribute("height","1" );
      ((Element)v.get(1630)).appendChild((Element)v.get(1631));
      /* Termina nodo:1631   */
      /* Termina nodo:1630   */
      /* Termina nodo:1625   */
      /* Termina nodo:1570   */

      /* Empieza nodo:1632 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1632)).setAttribute("width","100%" );
      ((Element)v.get(1632)).setAttribute("border","0" );
      ((Element)v.get(1632)).setAttribute("align","center" );
      ((Element)v.get(1632)).setAttribute("cellspacing","0" );
      ((Element)v.get(1632)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1632));

      /* Empieza nodo:1633 / Elemento padre: 1632   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1632)).appendChild((Element)v.get(1633));

      /* Empieza nodo:1634 / Elemento padre: 1633   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1633)).appendChild((Element)v.get(1634));

      /* Empieza nodo:1635 / Elemento padre: 1634   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1635)).setAttribute("src","b.gif" );
      ((Element)v.get(1635)).setAttribute("width","8" );
      ((Element)v.get(1635)).setAttribute("height","8" );
      ((Element)v.get(1634)).appendChild((Element)v.get(1635));
      /* Termina nodo:1635   */
      /* Termina nodo:1634   */

      /* Empieza nodo:1636 / Elemento padre: 1633   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1636)).setAttribute("width","100%" );
      ((Element)v.get(1633)).appendChild((Element)v.get(1636));

      /* Empieza nodo:1637 / Elemento padre: 1636   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1636)).appendChild((Element)v.get(1637));

      /* Empieza nodo:1638 / Elemento padre: 1637   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1638)).setAttribute("class","legend" );
      ((Element)v.get(1637)).appendChild((Element)v.get(1638));

      /* Empieza nodo:1639 / Elemento padre: 1638   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1639)).setAttribute("nombre","lblBaseAplicacionDescuentoNegocio" );
      ((Element)v.get(1639)).setAttribute("alto","13" );
      ((Element)v.get(1639)).setAttribute("filas","1" );
      ((Element)v.get(1639)).setAttribute("valor","" );
      ((Element)v.get(1639)).setAttribute("id","legend" );
      ((Element)v.get(1639)).setAttribute("cod","00484" );
      ((Element)v.get(1638)).appendChild((Element)v.get(1639));
      /* Termina nodo:1639   */
      /* Termina nodo:1638   */

      /* Empieza nodo:1640 / Elemento padre: 1637   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1640)).setAttribute("width","100%" );
      ((Element)v.get(1640)).setAttribute("border","0" );
      ((Element)v.get(1640)).setAttribute("align","center" );
      ((Element)v.get(1640)).setAttribute("cellspacing","0" );
      ((Element)v.get(1640)).setAttribute("cellpadding","0" );
      ((Element)v.get(1637)).appendChild((Element)v.get(1640));

      /* Empieza nodo:1641 / Elemento padre: 1640   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1640)).appendChild((Element)v.get(1641));

      /* Empieza nodo:1642 / Elemento padre: 1641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1642)).setAttribute("colspan","3" );
      ((Element)v.get(1641)).appendChild((Element)v.get(1642));

      /* Empieza nodo:1643 / Elemento padre: 1642   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML6480(Document doc) {
      ((Element)v.get(1643)).setAttribute("src","b.gif" );
      ((Element)v.get(1643)).setAttribute("width","8" );
      ((Element)v.get(1643)).setAttribute("height","8" );
      ((Element)v.get(1642)).appendChild((Element)v.get(1643));
      /* Termina nodo:1643   */
      /* Termina nodo:1642   */
      /* Termina nodo:1641   */

      /* Empieza nodo:1644 / Elemento padre: 1640   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1640)).appendChild((Element)v.get(1644));

      /* Empieza nodo:1645 / Elemento padre: 1644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1644)).appendChild((Element)v.get(1645));

      /* Empieza nodo:1646 / Elemento padre: 1645   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1646)).setAttribute("src","b.gif" );
      ((Element)v.get(1646)).setAttribute("width","8" );
      ((Element)v.get(1646)).setAttribute("height","8" );
      ((Element)v.get(1645)).appendChild((Element)v.get(1646));
      /* Termina nodo:1646   */
      /* Termina nodo:1645   */

      /* Empieza nodo:1647 / Elemento padre: 1644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1644)).appendChild((Element)v.get(1647));

      /* Empieza nodo:1648 / Elemento padre: 1647   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1648)).setAttribute("nombre","lblCodigoBaseAplicacionDescuentoNegocio" );
      ((Element)v.get(1648)).setAttribute("alto","13" );
      ((Element)v.get(1648)).setAttribute("filas","1" );
      ((Element)v.get(1648)).setAttribute("valor","" );
      ((Element)v.get(1648)).setAttribute("id","datosTitle" );
      ((Element)v.get(1648)).setAttribute("cod","8" );
      ((Element)v.get(1647)).appendChild((Element)v.get(1648));
      /* Termina nodo:1648   */
      /* Termina nodo:1647   */

      /* Empieza nodo:1649 / Elemento padre: 1644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1644)).appendChild((Element)v.get(1649));

      /* Empieza nodo:1650 / Elemento padre: 1649   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1650)).setAttribute("src","b.gif" );
      ((Element)v.get(1650)).setAttribute("width","25" );
      ((Element)v.get(1650)).setAttribute("height","8" );
      ((Element)v.get(1649)).appendChild((Element)v.get(1650));
      /* Termina nodo:1650   */
      /* Termina nodo:1649   */

      /* Empieza nodo:1651 / Elemento padre: 1644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1644)).appendChild((Element)v.get(1651));

      /* Empieza nodo:1652 / Elemento padre: 1651   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1652)).setAttribute("nombre","lblVisibleBaseAplicacionDescuentoNegocio" );
      ((Element)v.get(1652)).setAttribute("alto","13" );
      ((Element)v.get(1652)).setAttribute("filas","1" );
      ((Element)v.get(1652)).setAttribute("valor","" );
      ((Element)v.get(1652)).setAttribute("id","datosTitle" );
      ((Element)v.get(1652)).setAttribute("cod","1038" );
      ((Element)v.get(1651)).appendChild((Element)v.get(1652));
      /* Termina nodo:1652   */
      /* Termina nodo:1651   */

      /* Empieza nodo:1653 / Elemento padre: 1644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1644)).appendChild((Element)v.get(1653));

      /* Empieza nodo:1654 / Elemento padre: 1653   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1654)).setAttribute("src","b.gif" );
      ((Element)v.get(1654)).setAttribute("width","25" );
      ((Element)v.get(1654)).setAttribute("height","8" );
      ((Element)v.get(1653)).appendChild((Element)v.get(1654));
      /* Termina nodo:1654   */
      /* Termina nodo:1653   */

      /* Empieza nodo:1655 / Elemento padre: 1644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1644)).appendChild((Element)v.get(1655));

      /* Empieza nodo:1656 / Elemento padre: 1655   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1656)).setAttribute("nombre","lblObligatorioBaseAplicacionDescuentoNegocio" );
      ((Element)v.get(1656)).setAttribute("alto","13" );
      ((Element)v.get(1656)).setAttribute("filas","1" );
      ((Element)v.get(1656)).setAttribute("valor","" );
      ((Element)v.get(1656)).setAttribute("id","datosTitle" );
      ((Element)v.get(1656)).setAttribute("cod","949" );
      ((Element)v.get(1655)).appendChild((Element)v.get(1656));
      /* Termina nodo:1656   */
      /* Termina nodo:1655   */

      /* Empieza nodo:1657 / Elemento padre: 1644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1644)).appendChild((Element)v.get(1657));

      /* Empieza nodo:1658 / Elemento padre: 1657   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1658)).setAttribute("src","b.gif" );
      ((Element)v.get(1658)).setAttribute("width","25" );
      ((Element)v.get(1658)).setAttribute("height","8" );
      ((Element)v.get(1657)).appendChild((Element)v.get(1658));
      /* Termina nodo:1658   */
      /* Termina nodo:1657   */

      /* Empieza nodo:1659 / Elemento padre: 1644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1644)).appendChild((Element)v.get(1659));

      /* Empieza nodo:1660 / Elemento padre: 1659   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1660)).setAttribute("nombre","lblModificableBaseAplicacionDescuentoNegocio" );
      ((Element)v.get(1660)).setAttribute("alto","13" );
      ((Element)v.get(1660)).setAttribute("filas","1" );
      ((Element)v.get(1660)).setAttribute("valor","" );
      ((Element)v.get(1660)).setAttribute("id","datosTitle" );
      ((Element)v.get(1660)).setAttribute("cod","914" );
      ((Element)v.get(1659)).appendChild((Element)v.get(1660));
      /* Termina nodo:1660   */
      /* Termina nodo:1659   */

      /* Empieza nodo:1661 / Elemento padre: 1644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1661)).setAttribute("width","100%" );
      ((Element)v.get(1644)).appendChild((Element)v.get(1661));

      /* Empieza nodo:1662 / Elemento padre: 1661   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1662)).setAttribute("src","b.gif" );
      ((Element)v.get(1662)).setAttribute("width","8" );
      ((Element)v.get(1662)).setAttribute("height","8" );
      ((Element)v.get(1661)).appendChild((Element)v.get(1662));
      /* Termina nodo:1662   */
      /* Termina nodo:1661   */
      /* Termina nodo:1644   */

      /* Empieza nodo:1663 / Elemento padre: 1640   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1640)).appendChild((Element)v.get(1663));

      /* Empieza nodo:1664 / Elemento padre: 1663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1663)).appendChild((Element)v.get(1664));

      /* Empieza nodo:1665 / Elemento padre: 1664   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1665)).setAttribute("src","b.gif" );
      ((Element)v.get(1665)).setAttribute("width","8" );
      ((Element)v.get(1665)).setAttribute("height","8" );
   }

   private void getXML6570(Document doc) {
      ((Element)v.get(1664)).appendChild((Element)v.get(1665));
      /* Termina nodo:1665   */
      /* Termina nodo:1664   */

      /* Empieza nodo:1666 / Elemento padre: 1663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1663)).appendChild((Element)v.get(1666));

      /* Empieza nodo:1667 / Elemento padre: 1666   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1667)).setAttribute("nombre","lbldtCodigoBaseAplicacionDescuentoNegocio" );
      ((Element)v.get(1667)).setAttribute("alto","13" );
      ((Element)v.get(1667)).setAttribute("filas","1" );
      ((Element)v.get(1667)).setAttribute("valor","22" );
      ((Element)v.get(1667)).setAttribute("id","datosCampos" );
      ((Element)v.get(1666)).appendChild((Element)v.get(1667));
      /* Termina nodo:1667   */
      /* Termina nodo:1666   */

      /* Empieza nodo:1668 / Elemento padre: 1663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1663)).appendChild((Element)v.get(1668));

      /* Empieza nodo:1669 / Elemento padre: 1668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1669)).setAttribute("src","b.gif" );
      ((Element)v.get(1669)).setAttribute("width","25" );
      ((Element)v.get(1669)).setAttribute("height","8" );
      ((Element)v.get(1668)).appendChild((Element)v.get(1669));
      /* Termina nodo:1669   */
      /* Termina nodo:1668   */

      /* Empieza nodo:1670 / Elemento padre: 1663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1663)).appendChild((Element)v.get(1670));

      /* Empieza nodo:1671 / Elemento padre: 1670   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1671)).setAttribute("nombre","ckVisibleBaseAplicacionDescuentoNegocio" );
      ((Element)v.get(1671)).setAttribute("id","datosCampos" );
      ((Element)v.get(1671)).setAttribute("onclick","cambiaObli(20)" );
      ((Element)v.get(1671)).setAttribute("check","S" );
      ((Element)v.get(1670)).appendChild((Element)v.get(1671));
      /* Termina nodo:1671   */
      /* Termina nodo:1670   */

      /* Empieza nodo:1672 / Elemento padre: 1663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1663)).appendChild((Element)v.get(1672));

      /* Empieza nodo:1673 / Elemento padre: 1672   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1673)).setAttribute("src","b.gif" );
      ((Element)v.get(1673)).setAttribute("width","25" );
      ((Element)v.get(1673)).setAttribute("height","8" );
      ((Element)v.get(1672)).appendChild((Element)v.get(1673));
      /* Termina nodo:1673   */
      /* Termina nodo:1672   */

      /* Empieza nodo:1674 / Elemento padre: 1663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1663)).appendChild((Element)v.get(1674));

      /* Empieza nodo:1675 / Elemento padre: 1674   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1675)).setAttribute("nombre","ckObligatorioBaseAplicacionDescuentoNegocio" );
      ((Element)v.get(1675)).setAttribute("id","datosCampos" );
      ((Element)v.get(1675)).setAttribute("onclick","" );
      ((Element)v.get(1675)).setAttribute("check","N" );
      ((Element)v.get(1674)).appendChild((Element)v.get(1675));
      /* Termina nodo:1675   */
      /* Termina nodo:1674   */

      /* Empieza nodo:1676 / Elemento padre: 1663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1663)).appendChild((Element)v.get(1676));

      /* Empieza nodo:1677 / Elemento padre: 1676   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1677)).setAttribute("src","b.gif" );
      ((Element)v.get(1677)).setAttribute("width","25" );
      ((Element)v.get(1677)).setAttribute("height","8" );
      ((Element)v.get(1676)).appendChild((Element)v.get(1677));
      /* Termina nodo:1677   */
      /* Termina nodo:1676   */

      /* Empieza nodo:1678 / Elemento padre: 1663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1663)).appendChild((Element)v.get(1678));

      /* Empieza nodo:1679 / Elemento padre: 1678   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1679)).setAttribute("nombre","ckModificableBaseAplicacionDescuentoNegocio" );
      ((Element)v.get(1679)).setAttribute("id","datosCampos" );
      ((Element)v.get(1679)).setAttribute("onclick","" );
      ((Element)v.get(1679)).setAttribute("check","S" );
      ((Element)v.get(1678)).appendChild((Element)v.get(1679));
      /* Termina nodo:1679   */
      /* Termina nodo:1678   */

      /* Empieza nodo:1680 / Elemento padre: 1663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1680)).setAttribute("width","100%" );
      ((Element)v.get(1663)).appendChild((Element)v.get(1680));

      /* Empieza nodo:1681 / Elemento padre: 1680   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1681)).setAttribute("src","b.gif" );
      ((Element)v.get(1681)).setAttribute("width","8" );
      ((Element)v.get(1681)).setAttribute("height","8" );
      ((Element)v.get(1680)).appendChild((Element)v.get(1681));
      /* Termina nodo:1681   */
      /* Termina nodo:1680   */
      /* Termina nodo:1663   */

      /* Empieza nodo:1682 / Elemento padre: 1640   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1640)).appendChild((Element)v.get(1682));

      /* Empieza nodo:1683 / Elemento padre: 1682   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1683)).setAttribute("colspan","4" );
      ((Element)v.get(1682)).appendChild((Element)v.get(1683));

      /* Empieza nodo:1684 / Elemento padre: 1683   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1684)).setAttribute("src","b.gif" );
      ((Element)v.get(1684)).setAttribute("width","8" );
      ((Element)v.get(1684)).setAttribute("height","8" );
      ((Element)v.get(1683)).appendChild((Element)v.get(1684));
      /* Termina nodo:1684   */
      /* Termina nodo:1683   */
      /* Termina nodo:1682   */
      /* Termina nodo:1640   */
      /* Termina nodo:1637   */
      /* Termina nodo:1636   */

      /* Empieza nodo:1685 / Elemento padre: 1633   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1633)).appendChild((Element)v.get(1685));

      /* Empieza nodo:1686 / Elemento padre: 1685   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1686)).setAttribute("src","b.gif" );
      ((Element)v.get(1685)).appendChild((Element)v.get(1686));
      /* Termina nodo:1686   */
      /* Termina nodo:1685   */
      /* Termina nodo:1633   */

      /* Empieza nodo:1687 / Elemento padre: 1632   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1632)).appendChild((Element)v.get(1687));

      /* Empieza nodo:1688 / Elemento padre: 1687   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1688)).setAttribute("width","12" );
      ((Element)v.get(1688)).setAttribute("align","center" );
      ((Element)v.get(1687)).appendChild((Element)v.get(1688));

      /* Empieza nodo:1689 / Elemento padre: 1688   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1689)).setAttribute("src","b.gif" );
      ((Element)v.get(1689)).setAttribute("width","12" );
      ((Element)v.get(1689)).setAttribute("height","15" );
      ((Element)v.get(1688)).appendChild((Element)v.get(1689));
      /* Termina nodo:1689   */
      /* Termina nodo:1688   */

      /* Empieza nodo:1690 / Elemento padre: 1687   */
      v.add(doc.createElement("td"));
   }

   private void getXML6660(Document doc) {
      ((Element)v.get(1690)).setAttribute("width","756" );
      ((Element)v.get(1687)).appendChild((Element)v.get(1690));

      /* Empieza nodo:1691 / Elemento padre: 1690   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1691)).setAttribute("src","b.gif" );
      ((Element)v.get(1690)).appendChild((Element)v.get(1691));
      /* Termina nodo:1691   */
      /* Termina nodo:1690   */

      /* Empieza nodo:1692 / Elemento padre: 1687   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1692)).setAttribute("width","12" );
      ((Element)v.get(1687)).appendChild((Element)v.get(1692));

      /* Empieza nodo:1693 / Elemento padre: 1692   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1693)).setAttribute("src","b.gif" );
      ((Element)v.get(1693)).setAttribute("width","12" );
      ((Element)v.get(1693)).setAttribute("height","1" );
      ((Element)v.get(1692)).appendChild((Element)v.get(1693));
      /* Termina nodo:1693   */
      /* Termina nodo:1692   */
      /* Termina nodo:1687   */
      /* Termina nodo:1632   */

      /* Empieza nodo:1694 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1694)).setAttribute("width","100%" );
      ((Element)v.get(1694)).setAttribute("border","0" );
      ((Element)v.get(1694)).setAttribute("align","center" );
      ((Element)v.get(1694)).setAttribute("cellspacing","0" );
      ((Element)v.get(1694)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1694));

      /* Empieza nodo:1695 / Elemento padre: 1694   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1694)).appendChild((Element)v.get(1695));

      /* Empieza nodo:1696 / Elemento padre: 1695   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1695)).appendChild((Element)v.get(1696));

      /* Empieza nodo:1697 / Elemento padre: 1696   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1697)).setAttribute("src","b.gif" );
      ((Element)v.get(1697)).setAttribute("width","8" );
      ((Element)v.get(1697)).setAttribute("height","8" );
      ((Element)v.get(1696)).appendChild((Element)v.get(1697));
      /* Termina nodo:1697   */
      /* Termina nodo:1696   */

      /* Empieza nodo:1698 / Elemento padre: 1695   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1698)).setAttribute("width","100%" );
      ((Element)v.get(1695)).appendChild((Element)v.get(1698));

      /* Empieza nodo:1699 / Elemento padre: 1698   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1698)).appendChild((Element)v.get(1699));

      /* Empieza nodo:1700 / Elemento padre: 1699   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1700)).setAttribute("class","legend" );
      ((Element)v.get(1699)).appendChild((Element)v.get(1700));

      /* Empieza nodo:1701 / Elemento padre: 1700   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1701)).setAttribute("nombre","lblBaseAplicacionDescuentoSupergenerico" );
      ((Element)v.get(1701)).setAttribute("alto","13" );
      ((Element)v.get(1701)).setAttribute("filas","1" );
      ((Element)v.get(1701)).setAttribute("valor","" );
      ((Element)v.get(1701)).setAttribute("id","legend" );
      ((Element)v.get(1701)).setAttribute("cod","00485" );
      ((Element)v.get(1700)).appendChild((Element)v.get(1701));
      /* Termina nodo:1701   */
      /* Termina nodo:1700   */

      /* Empieza nodo:1702 / Elemento padre: 1699   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1702)).setAttribute("width","100%" );
      ((Element)v.get(1702)).setAttribute("border","0" );
      ((Element)v.get(1702)).setAttribute("align","center" );
      ((Element)v.get(1702)).setAttribute("cellspacing","0" );
      ((Element)v.get(1702)).setAttribute("cellpadding","0" );
      ((Element)v.get(1699)).appendChild((Element)v.get(1702));

      /* Empieza nodo:1703 / Elemento padre: 1702   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1702)).appendChild((Element)v.get(1703));

      /* Empieza nodo:1704 / Elemento padre: 1703   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1704)).setAttribute("colspan","3" );
      ((Element)v.get(1703)).appendChild((Element)v.get(1704));

      /* Empieza nodo:1705 / Elemento padre: 1704   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1705)).setAttribute("src","b.gif" );
      ((Element)v.get(1705)).setAttribute("width","8" );
      ((Element)v.get(1705)).setAttribute("height","8" );
      ((Element)v.get(1704)).appendChild((Element)v.get(1705));
      /* Termina nodo:1705   */
      /* Termina nodo:1704   */
      /* Termina nodo:1703   */

      /* Empieza nodo:1706 / Elemento padre: 1702   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1702)).appendChild((Element)v.get(1706));

      /* Empieza nodo:1707 / Elemento padre: 1706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1706)).appendChild((Element)v.get(1707));

      /* Empieza nodo:1708 / Elemento padre: 1707   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1708)).setAttribute("src","b.gif" );
      ((Element)v.get(1708)).setAttribute("width","8" );
      ((Element)v.get(1708)).setAttribute("height","8" );
      ((Element)v.get(1707)).appendChild((Element)v.get(1708));
      /* Termina nodo:1708   */
      /* Termina nodo:1707   */

      /* Empieza nodo:1709 / Elemento padre: 1706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1706)).appendChild((Element)v.get(1709));

      /* Empieza nodo:1710 / Elemento padre: 1709   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1710)).setAttribute("nombre","lblCodigoBaseAplicacionDescuentoSupergenerico" );
      ((Element)v.get(1710)).setAttribute("alto","13" );
      ((Element)v.get(1710)).setAttribute("filas","1" );
      ((Element)v.get(1710)).setAttribute("valor","" );
      ((Element)v.get(1710)).setAttribute("id","datosTitle" );
      ((Element)v.get(1710)).setAttribute("cod","8" );
      ((Element)v.get(1709)).appendChild((Element)v.get(1710));
      /* Termina nodo:1710   */
      /* Termina nodo:1709   */

      /* Empieza nodo:1711 / Elemento padre: 1706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1706)).appendChild((Element)v.get(1711));

      /* Empieza nodo:1712 / Elemento padre: 1711   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1712)).setAttribute("src","b.gif" );
      ((Element)v.get(1712)).setAttribute("width","25" );
      ((Element)v.get(1712)).setAttribute("height","8" );
      ((Element)v.get(1711)).appendChild((Element)v.get(1712));
      /* Termina nodo:1712   */
      /* Termina nodo:1711   */

      /* Empieza nodo:1713 / Elemento padre: 1706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1706)).appendChild((Element)v.get(1713));

      /* Empieza nodo:1714 / Elemento padre: 1713   */
   }

   private void getXML6750(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1714)).setAttribute("nombre","lblVisibleBaseAplicacionDescuentoSupergenerico" );
      ((Element)v.get(1714)).setAttribute("alto","13" );
      ((Element)v.get(1714)).setAttribute("filas","1" );
      ((Element)v.get(1714)).setAttribute("valor","" );
      ((Element)v.get(1714)).setAttribute("id","datosTitle" );
      ((Element)v.get(1714)).setAttribute("cod","1038" );
      ((Element)v.get(1713)).appendChild((Element)v.get(1714));
      /* Termina nodo:1714   */
      /* Termina nodo:1713   */

      /* Empieza nodo:1715 / Elemento padre: 1706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1706)).appendChild((Element)v.get(1715));

      /* Empieza nodo:1716 / Elemento padre: 1715   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1716)).setAttribute("src","b.gif" );
      ((Element)v.get(1716)).setAttribute("width","25" );
      ((Element)v.get(1716)).setAttribute("height","8" );
      ((Element)v.get(1715)).appendChild((Element)v.get(1716));
      /* Termina nodo:1716   */
      /* Termina nodo:1715   */

      /* Empieza nodo:1717 / Elemento padre: 1706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1706)).appendChild((Element)v.get(1717));

      /* Empieza nodo:1718 / Elemento padre: 1717   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1718)).setAttribute("nombre","lblObligatorioBaseAplicacionDescuentoSupergenerico" );
      ((Element)v.get(1718)).setAttribute("alto","13" );
      ((Element)v.get(1718)).setAttribute("filas","1" );
      ((Element)v.get(1718)).setAttribute("valor","" );
      ((Element)v.get(1718)).setAttribute("id","datosTitle" );
      ((Element)v.get(1718)).setAttribute("cod","949" );
      ((Element)v.get(1717)).appendChild((Element)v.get(1718));
      /* Termina nodo:1718   */
      /* Termina nodo:1717   */

      /* Empieza nodo:1719 / Elemento padre: 1706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1706)).appendChild((Element)v.get(1719));

      /* Empieza nodo:1720 / Elemento padre: 1719   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1720)).setAttribute("src","b.gif" );
      ((Element)v.get(1720)).setAttribute("width","25" );
      ((Element)v.get(1720)).setAttribute("height","8" );
      ((Element)v.get(1719)).appendChild((Element)v.get(1720));
      /* Termina nodo:1720   */
      /* Termina nodo:1719   */

      /* Empieza nodo:1721 / Elemento padre: 1706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1706)).appendChild((Element)v.get(1721));

      /* Empieza nodo:1722 / Elemento padre: 1721   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1722)).setAttribute("nombre","lblModificableBaseAplicacionDescuentoSupergenerico" );
      ((Element)v.get(1722)).setAttribute("alto","13" );
      ((Element)v.get(1722)).setAttribute("filas","1" );
      ((Element)v.get(1722)).setAttribute("valor","" );
      ((Element)v.get(1722)).setAttribute("id","datosTitle" );
      ((Element)v.get(1722)).setAttribute("cod","914" );
      ((Element)v.get(1721)).appendChild((Element)v.get(1722));
      /* Termina nodo:1722   */
      /* Termina nodo:1721   */

      /* Empieza nodo:1723 / Elemento padre: 1706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1723)).setAttribute("width","100%" );
      ((Element)v.get(1706)).appendChild((Element)v.get(1723));

      /* Empieza nodo:1724 / Elemento padre: 1723   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1724)).setAttribute("src","b.gif" );
      ((Element)v.get(1724)).setAttribute("width","8" );
      ((Element)v.get(1724)).setAttribute("height","8" );
      ((Element)v.get(1723)).appendChild((Element)v.get(1724));
      /* Termina nodo:1724   */
      /* Termina nodo:1723   */
      /* Termina nodo:1706   */

      /* Empieza nodo:1725 / Elemento padre: 1702   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1702)).appendChild((Element)v.get(1725));

      /* Empieza nodo:1726 / Elemento padre: 1725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1725)).appendChild((Element)v.get(1726));

      /* Empieza nodo:1727 / Elemento padre: 1726   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1727)).setAttribute("src","b.gif" );
      ((Element)v.get(1727)).setAttribute("width","8" );
      ((Element)v.get(1727)).setAttribute("height","8" );
      ((Element)v.get(1726)).appendChild((Element)v.get(1727));
      /* Termina nodo:1727   */
      /* Termina nodo:1726   */

      /* Empieza nodo:1728 / Elemento padre: 1725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1725)).appendChild((Element)v.get(1728));

      /* Empieza nodo:1729 / Elemento padre: 1728   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1729)).setAttribute("nombre","lbldtCodigoBaseAplicacionDescuentoSupergenerico" );
      ((Element)v.get(1729)).setAttribute("alto","13" );
      ((Element)v.get(1729)).setAttribute("filas","1" );
      ((Element)v.get(1729)).setAttribute("valor","23" );
      ((Element)v.get(1729)).setAttribute("id","datosCampos" );
      ((Element)v.get(1728)).appendChild((Element)v.get(1729));
      /* Termina nodo:1729   */
      /* Termina nodo:1728   */

      /* Empieza nodo:1730 / Elemento padre: 1725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1725)).appendChild((Element)v.get(1730));

      /* Empieza nodo:1731 / Elemento padre: 1730   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1731)).setAttribute("src","b.gif" );
      ((Element)v.get(1731)).setAttribute("width","25" );
      ((Element)v.get(1731)).setAttribute("height","8" );
      ((Element)v.get(1730)).appendChild((Element)v.get(1731));
      /* Termina nodo:1731   */
      /* Termina nodo:1730   */

      /* Empieza nodo:1732 / Elemento padre: 1725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1725)).appendChild((Element)v.get(1732));

      /* Empieza nodo:1733 / Elemento padre: 1732   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1733)).setAttribute("nombre","ckVisibleBaseAplicacionDescuentoSupergenerico" );
      ((Element)v.get(1733)).setAttribute("id","datosCampos" );
      ((Element)v.get(1733)).setAttribute("onclick","cambiaObli(21)" );
      ((Element)v.get(1733)).setAttribute("check","S" );
      ((Element)v.get(1732)).appendChild((Element)v.get(1733));
      /* Termina nodo:1733   */
      /* Termina nodo:1732   */

      /* Empieza nodo:1734 / Elemento padre: 1725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1725)).appendChild((Element)v.get(1734));

      /* Empieza nodo:1735 / Elemento padre: 1734   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1735)).setAttribute("src","b.gif" );
      ((Element)v.get(1735)).setAttribute("width","25" );
      ((Element)v.get(1735)).setAttribute("height","8" );
      ((Element)v.get(1734)).appendChild((Element)v.get(1735));
      /* Termina nodo:1735   */
      /* Termina nodo:1734   */

      /* Empieza nodo:1736 / Elemento padre: 1725   */
   }

   private void getXML6840(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(1725)).appendChild((Element)v.get(1736));

      /* Empieza nodo:1737 / Elemento padre: 1736   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1737)).setAttribute("nombre","ckObligatorioBaseAplicacionDescuentoSupergenerico" );
      ((Element)v.get(1737)).setAttribute("id","datosCampos" );
      ((Element)v.get(1737)).setAttribute("onclick","" );
      ((Element)v.get(1737)).setAttribute("check","N" );
      ((Element)v.get(1736)).appendChild((Element)v.get(1737));
      /* Termina nodo:1737   */
      /* Termina nodo:1736   */

      /* Empieza nodo:1738 / Elemento padre: 1725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1725)).appendChild((Element)v.get(1738));

      /* Empieza nodo:1739 / Elemento padre: 1738   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1739)).setAttribute("src","b.gif" );
      ((Element)v.get(1739)).setAttribute("width","25" );
      ((Element)v.get(1739)).setAttribute("height","8" );
      ((Element)v.get(1738)).appendChild((Element)v.get(1739));
      /* Termina nodo:1739   */
      /* Termina nodo:1738   */

      /* Empieza nodo:1740 / Elemento padre: 1725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1725)).appendChild((Element)v.get(1740));

      /* Empieza nodo:1741 / Elemento padre: 1740   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1741)).setAttribute("nombre","ckModificableBaseAplicacionDescuentoSupergenerico" );
      ((Element)v.get(1741)).setAttribute("id","datosCampos" );
      ((Element)v.get(1741)).setAttribute("onclick","" );
      ((Element)v.get(1741)).setAttribute("check","S" );
      ((Element)v.get(1740)).appendChild((Element)v.get(1741));
      /* Termina nodo:1741   */
      /* Termina nodo:1740   */

      /* Empieza nodo:1742 / Elemento padre: 1725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1742)).setAttribute("width","100%" );
      ((Element)v.get(1725)).appendChild((Element)v.get(1742));

      /* Empieza nodo:1743 / Elemento padre: 1742   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1743)).setAttribute("src","b.gif" );
      ((Element)v.get(1743)).setAttribute("width","8" );
      ((Element)v.get(1743)).setAttribute("height","8" );
      ((Element)v.get(1742)).appendChild((Element)v.get(1743));
      /* Termina nodo:1743   */
      /* Termina nodo:1742   */
      /* Termina nodo:1725   */

      /* Empieza nodo:1744 / Elemento padre: 1702   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1702)).appendChild((Element)v.get(1744));

      /* Empieza nodo:1745 / Elemento padre: 1744   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1745)).setAttribute("colspan","4" );
      ((Element)v.get(1744)).appendChild((Element)v.get(1745));

      /* Empieza nodo:1746 / Elemento padre: 1745   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1746)).setAttribute("src","b.gif" );
      ((Element)v.get(1746)).setAttribute("width","8" );
      ((Element)v.get(1746)).setAttribute("height","8" );
      ((Element)v.get(1745)).appendChild((Element)v.get(1746));
      /* Termina nodo:1746   */
      /* Termina nodo:1745   */
      /* Termina nodo:1744   */
      /* Termina nodo:1702   */
      /* Termina nodo:1699   */
      /* Termina nodo:1698   */

      /* Empieza nodo:1747 / Elemento padre: 1695   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1695)).appendChild((Element)v.get(1747));

      /* Empieza nodo:1748 / Elemento padre: 1747   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1748)).setAttribute("src","b.gif" );
      ((Element)v.get(1747)).appendChild((Element)v.get(1748));
      /* Termina nodo:1748   */
      /* Termina nodo:1747   */
      /* Termina nodo:1695   */

      /* Empieza nodo:1749 / Elemento padre: 1694   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1694)).appendChild((Element)v.get(1749));

      /* Empieza nodo:1750 / Elemento padre: 1749   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1750)).setAttribute("width","12" );
      ((Element)v.get(1750)).setAttribute("align","center" );
      ((Element)v.get(1749)).appendChild((Element)v.get(1750));

      /* Empieza nodo:1751 / Elemento padre: 1750   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1751)).setAttribute("src","b.gif" );
      ((Element)v.get(1751)).setAttribute("width","12" );
      ((Element)v.get(1751)).setAttribute("height","15" );
      ((Element)v.get(1750)).appendChild((Element)v.get(1751));
      /* Termina nodo:1751   */
      /* Termina nodo:1750   */

      /* Empieza nodo:1752 / Elemento padre: 1749   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1752)).setAttribute("width","756" );
      ((Element)v.get(1749)).appendChild((Element)v.get(1752));

      /* Empieza nodo:1753 / Elemento padre: 1752   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1753)).setAttribute("src","b.gif" );
      ((Element)v.get(1752)).appendChild((Element)v.get(1753));
      /* Termina nodo:1753   */
      /* Termina nodo:1752   */

      /* Empieza nodo:1754 / Elemento padre: 1749   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1754)).setAttribute("width","12" );
      ((Element)v.get(1749)).appendChild((Element)v.get(1754));

      /* Empieza nodo:1755 / Elemento padre: 1754   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1755)).setAttribute("src","b.gif" );
      ((Element)v.get(1755)).setAttribute("width","12" );
      ((Element)v.get(1755)).setAttribute("height","1" );
      ((Element)v.get(1754)).appendChild((Element)v.get(1755));
      /* Termina nodo:1755   */
      /* Termina nodo:1754   */
      /* Termina nodo:1749   */
      /* Termina nodo:1694   */

      /* Empieza nodo:1756 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1756)).setAttribute("width","100%" );
      ((Element)v.get(1756)).setAttribute("border","0" );
      ((Element)v.get(1756)).setAttribute("align","center" );
      ((Element)v.get(1756)).setAttribute("cellspacing","0" );
      ((Element)v.get(1756)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1756));

      /* Empieza nodo:1757 / Elemento padre: 1756   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1756)).appendChild((Element)v.get(1757));

      /* Empieza nodo:1758 / Elemento padre: 1757   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1757)).appendChild((Element)v.get(1758));

      /* Empieza nodo:1759 / Elemento padre: 1758   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1759)).setAttribute("src","b.gif" );
      ((Element)v.get(1759)).setAttribute("width","8" );
      ((Element)v.get(1759)).setAttribute("height","8" );
      ((Element)v.get(1758)).appendChild((Element)v.get(1759));
      /* Termina nodo:1759   */
      /* Termina nodo:1758   */

      /* Empieza nodo:1760 / Elemento padre: 1757   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1760)).setAttribute("width","100%" );
      ((Element)v.get(1757)).appendChild((Element)v.get(1760));

      /* Empieza nodo:1761 / Elemento padre: 1760   */
   }

   private void getXML6930(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1760)).appendChild((Element)v.get(1761));

      /* Empieza nodo:1762 / Elemento padre: 1761   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1762)).setAttribute("class","legend" );
      ((Element)v.get(1761)).appendChild((Element)v.get(1762));

      /* Empieza nodo:1763 / Elemento padre: 1762   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1763)).setAttribute("nombre","lblBaseAplicacionDescuentoGenerico" );
      ((Element)v.get(1763)).setAttribute("alto","13" );
      ((Element)v.get(1763)).setAttribute("filas","1" );
      ((Element)v.get(1763)).setAttribute("valor","" );
      ((Element)v.get(1763)).setAttribute("id","legend" );
      ((Element)v.get(1763)).setAttribute("cod","00486" );
      ((Element)v.get(1762)).appendChild((Element)v.get(1763));
      /* Termina nodo:1763   */
      /* Termina nodo:1762   */

      /* Empieza nodo:1764 / Elemento padre: 1761   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1764)).setAttribute("width","100%" );
      ((Element)v.get(1764)).setAttribute("border","0" );
      ((Element)v.get(1764)).setAttribute("align","center" );
      ((Element)v.get(1764)).setAttribute("cellspacing","0" );
      ((Element)v.get(1764)).setAttribute("cellpadding","0" );
      ((Element)v.get(1761)).appendChild((Element)v.get(1764));

      /* Empieza nodo:1765 / Elemento padre: 1764   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1764)).appendChild((Element)v.get(1765));

      /* Empieza nodo:1766 / Elemento padre: 1765   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1766)).setAttribute("colspan","3" );
      ((Element)v.get(1765)).appendChild((Element)v.get(1766));

      /* Empieza nodo:1767 / Elemento padre: 1766   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1767)).setAttribute("src","b.gif" );
      ((Element)v.get(1767)).setAttribute("width","8" );
      ((Element)v.get(1767)).setAttribute("height","8" );
      ((Element)v.get(1766)).appendChild((Element)v.get(1767));
      /* Termina nodo:1767   */
      /* Termina nodo:1766   */
      /* Termina nodo:1765   */

      /* Empieza nodo:1768 / Elemento padre: 1764   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1764)).appendChild((Element)v.get(1768));

      /* Empieza nodo:1769 / Elemento padre: 1768   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1768)).appendChild((Element)v.get(1769));

      /* Empieza nodo:1770 / Elemento padre: 1769   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1770)).setAttribute("src","b.gif" );
      ((Element)v.get(1770)).setAttribute("width","8" );
      ((Element)v.get(1770)).setAttribute("height","8" );
      ((Element)v.get(1769)).appendChild((Element)v.get(1770));
      /* Termina nodo:1770   */
      /* Termina nodo:1769   */

      /* Empieza nodo:1771 / Elemento padre: 1768   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1768)).appendChild((Element)v.get(1771));

      /* Empieza nodo:1772 / Elemento padre: 1771   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1772)).setAttribute("nombre","lblCodigoBaseAplicacionDescuentoGenerico" );
      ((Element)v.get(1772)).setAttribute("alto","13" );
      ((Element)v.get(1772)).setAttribute("filas","1" );
      ((Element)v.get(1772)).setAttribute("valor","" );
      ((Element)v.get(1772)).setAttribute("id","datosTitle" );
      ((Element)v.get(1772)).setAttribute("cod","8" );
      ((Element)v.get(1771)).appendChild((Element)v.get(1772));
      /* Termina nodo:1772   */
      /* Termina nodo:1771   */

      /* Empieza nodo:1773 / Elemento padre: 1768   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1768)).appendChild((Element)v.get(1773));

      /* Empieza nodo:1774 / Elemento padre: 1773   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1774)).setAttribute("src","b.gif" );
      ((Element)v.get(1774)).setAttribute("width","25" );
      ((Element)v.get(1774)).setAttribute("height","8" );
      ((Element)v.get(1773)).appendChild((Element)v.get(1774));
      /* Termina nodo:1774   */
      /* Termina nodo:1773   */

      /* Empieza nodo:1775 / Elemento padre: 1768   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1768)).appendChild((Element)v.get(1775));

      /* Empieza nodo:1776 / Elemento padre: 1775   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1776)).setAttribute("nombre","lblVisibleBaseAplicacionDescuentoGenerico" );
      ((Element)v.get(1776)).setAttribute("alto","13" );
      ((Element)v.get(1776)).setAttribute("filas","1" );
      ((Element)v.get(1776)).setAttribute("valor","" );
      ((Element)v.get(1776)).setAttribute("id","datosTitle" );
      ((Element)v.get(1776)).setAttribute("cod","1038" );
      ((Element)v.get(1775)).appendChild((Element)v.get(1776));
      /* Termina nodo:1776   */
      /* Termina nodo:1775   */

      /* Empieza nodo:1777 / Elemento padre: 1768   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1768)).appendChild((Element)v.get(1777));

      /* Empieza nodo:1778 / Elemento padre: 1777   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1778)).setAttribute("src","b.gif" );
      ((Element)v.get(1778)).setAttribute("width","25" );
      ((Element)v.get(1778)).setAttribute("height","8" );
      ((Element)v.get(1777)).appendChild((Element)v.get(1778));
      /* Termina nodo:1778   */
      /* Termina nodo:1777   */

      /* Empieza nodo:1779 / Elemento padre: 1768   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1768)).appendChild((Element)v.get(1779));

      /* Empieza nodo:1780 / Elemento padre: 1779   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1780)).setAttribute("nombre","lblObligatorioBaseAplicacionDescuentoGenerico" );
      ((Element)v.get(1780)).setAttribute("alto","13" );
      ((Element)v.get(1780)).setAttribute("filas","1" );
      ((Element)v.get(1780)).setAttribute("valor","" );
      ((Element)v.get(1780)).setAttribute("id","datosTitle" );
      ((Element)v.get(1780)).setAttribute("cod","949" );
      ((Element)v.get(1779)).appendChild((Element)v.get(1780));
      /* Termina nodo:1780   */
      /* Termina nodo:1779   */

      /* Empieza nodo:1781 / Elemento padre: 1768   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1768)).appendChild((Element)v.get(1781));

      /* Empieza nodo:1782 / Elemento padre: 1781   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1782)).setAttribute("src","b.gif" );
      ((Element)v.get(1782)).setAttribute("width","25" );
      ((Element)v.get(1782)).setAttribute("height","8" );
      ((Element)v.get(1781)).appendChild((Element)v.get(1782));
      /* Termina nodo:1782   */
      /* Termina nodo:1781   */

      /* Empieza nodo:1783 / Elemento padre: 1768   */
   }

   private void getXML7020(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(1768)).appendChild((Element)v.get(1783));

      /* Empieza nodo:1784 / Elemento padre: 1783   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1784)).setAttribute("nombre","lblModificableBaseAplicacionDescuentoGenerico" );
      ((Element)v.get(1784)).setAttribute("alto","13" );
      ((Element)v.get(1784)).setAttribute("filas","1" );
      ((Element)v.get(1784)).setAttribute("valor","" );
      ((Element)v.get(1784)).setAttribute("id","datosTitle" );
      ((Element)v.get(1784)).setAttribute("cod","914" );
      ((Element)v.get(1783)).appendChild((Element)v.get(1784));
      /* Termina nodo:1784   */
      /* Termina nodo:1783   */

      /* Empieza nodo:1785 / Elemento padre: 1768   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1785)).setAttribute("width","100%" );
      ((Element)v.get(1768)).appendChild((Element)v.get(1785));

      /* Empieza nodo:1786 / Elemento padre: 1785   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1786)).setAttribute("src","b.gif" );
      ((Element)v.get(1786)).setAttribute("width","8" );
      ((Element)v.get(1786)).setAttribute("height","8" );
      ((Element)v.get(1785)).appendChild((Element)v.get(1786));
      /* Termina nodo:1786   */
      /* Termina nodo:1785   */
      /* Termina nodo:1768   */

      /* Empieza nodo:1787 / Elemento padre: 1764   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1764)).appendChild((Element)v.get(1787));

      /* Empieza nodo:1788 / Elemento padre: 1787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1787)).appendChild((Element)v.get(1788));

      /* Empieza nodo:1789 / Elemento padre: 1788   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1789)).setAttribute("src","b.gif" );
      ((Element)v.get(1789)).setAttribute("width","8" );
      ((Element)v.get(1789)).setAttribute("height","8" );
      ((Element)v.get(1788)).appendChild((Element)v.get(1789));
      /* Termina nodo:1789   */
      /* Termina nodo:1788   */

      /* Empieza nodo:1790 / Elemento padre: 1787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1787)).appendChild((Element)v.get(1790));

      /* Empieza nodo:1791 / Elemento padre: 1790   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1791)).setAttribute("nombre","lbldtCodigoBaseAplicacionDescuentoGenerico" );
      ((Element)v.get(1791)).setAttribute("alto","18" );
      ((Element)v.get(1791)).setAttribute("filas","1" );
      ((Element)v.get(1791)).setAttribute("valor","24" );
      ((Element)v.get(1791)).setAttribute("id","datosCampos" );
      ((Element)v.get(1790)).appendChild((Element)v.get(1791));
      /* Termina nodo:1791   */
      /* Termina nodo:1790   */

      /* Empieza nodo:1792 / Elemento padre: 1787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1787)).appendChild((Element)v.get(1792));

      /* Empieza nodo:1793 / Elemento padre: 1792   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1793)).setAttribute("src","b.gif" );
      ((Element)v.get(1793)).setAttribute("width","25" );
      ((Element)v.get(1793)).setAttribute("height","8" );
      ((Element)v.get(1792)).appendChild((Element)v.get(1793));
      /* Termina nodo:1793   */
      /* Termina nodo:1792   */

      /* Empieza nodo:1794 / Elemento padre: 1787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1787)).appendChild((Element)v.get(1794));

      /* Empieza nodo:1795 / Elemento padre: 1794   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1795)).setAttribute("nombre","ckVisibleBaseAplicacionDescuentoGenerico" );
      ((Element)v.get(1795)).setAttribute("id","datosCampos" );
      ((Element)v.get(1795)).setAttribute("onclick","cambiaObli(22)" );
      ((Element)v.get(1795)).setAttribute("check","S" );
      ((Element)v.get(1794)).appendChild((Element)v.get(1795));
      /* Termina nodo:1795   */
      /* Termina nodo:1794   */

      /* Empieza nodo:1796 / Elemento padre: 1787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1787)).appendChild((Element)v.get(1796));

      /* Empieza nodo:1797 / Elemento padre: 1796   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1797)).setAttribute("src","b.gif" );
      ((Element)v.get(1797)).setAttribute("width","25" );
      ((Element)v.get(1797)).setAttribute("height","8" );
      ((Element)v.get(1796)).appendChild((Element)v.get(1797));
      /* Termina nodo:1797   */
      /* Termina nodo:1796   */

      /* Empieza nodo:1798 / Elemento padre: 1787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1787)).appendChild((Element)v.get(1798));

      /* Empieza nodo:1799 / Elemento padre: 1798   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1799)).setAttribute("nombre","ckObligatorioBaseAplicacionDescuentoGenerico" );
      ((Element)v.get(1799)).setAttribute("id","datosCampos" );
      ((Element)v.get(1799)).setAttribute("onclick","" );
      ((Element)v.get(1799)).setAttribute("check","N" );
      ((Element)v.get(1798)).appendChild((Element)v.get(1799));
      /* Termina nodo:1799   */
      /* Termina nodo:1798   */

      /* Empieza nodo:1800 / Elemento padre: 1787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1787)).appendChild((Element)v.get(1800));

      /* Empieza nodo:1801 / Elemento padre: 1800   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1801)).setAttribute("src","b.gif" );
      ((Element)v.get(1801)).setAttribute("width","25" );
      ((Element)v.get(1801)).setAttribute("height","8" );
      ((Element)v.get(1800)).appendChild((Element)v.get(1801));
      /* Termina nodo:1801   */
      /* Termina nodo:1800   */

      /* Empieza nodo:1802 / Elemento padre: 1787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1787)).appendChild((Element)v.get(1802));

      /* Empieza nodo:1803 / Elemento padre: 1802   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1803)).setAttribute("nombre","ckModificableBaseAplicacionDescuentoGenerico" );
      ((Element)v.get(1803)).setAttribute("id","datosCampos" );
      ((Element)v.get(1803)).setAttribute("onclick","" );
      ((Element)v.get(1803)).setAttribute("check","S" );
      ((Element)v.get(1802)).appendChild((Element)v.get(1803));
      /* Termina nodo:1803   */
      /* Termina nodo:1802   */

      /* Empieza nodo:1804 / Elemento padre: 1787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1804)).setAttribute("width","100%" );
      ((Element)v.get(1787)).appendChild((Element)v.get(1804));

      /* Empieza nodo:1805 / Elemento padre: 1804   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1805)).setAttribute("src","b.gif" );
      ((Element)v.get(1805)).setAttribute("width","8" );
      ((Element)v.get(1805)).setAttribute("height","8" );
      ((Element)v.get(1804)).appendChild((Element)v.get(1805));
      /* Termina nodo:1805   */
      /* Termina nodo:1804   */
      /* Termina nodo:1787   */

      /* Empieza nodo:1806 / Elemento padre: 1764   */
      v.add(doc.createElement("tr"));
   }

   private void getXML7110(Document doc) {
      ((Element)v.get(1764)).appendChild((Element)v.get(1806));

      /* Empieza nodo:1807 / Elemento padre: 1806   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1807)).setAttribute("colspan","4" );
      ((Element)v.get(1806)).appendChild((Element)v.get(1807));

      /* Empieza nodo:1808 / Elemento padre: 1807   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1808)).setAttribute("src","b.gif" );
      ((Element)v.get(1808)).setAttribute("width","8" );
      ((Element)v.get(1808)).setAttribute("height","8" );
      ((Element)v.get(1807)).appendChild((Element)v.get(1808));
      /* Termina nodo:1808   */
      /* Termina nodo:1807   */
      /* Termina nodo:1806   */
      /* Termina nodo:1764   */
      /* Termina nodo:1761   */
      /* Termina nodo:1760   */

      /* Empieza nodo:1809 / Elemento padre: 1757   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1757)).appendChild((Element)v.get(1809));

      /* Empieza nodo:1810 / Elemento padre: 1809   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1810)).setAttribute("src","b.gif" );
      ((Element)v.get(1809)).appendChild((Element)v.get(1810));
      /* Termina nodo:1810   */
      /* Termina nodo:1809   */
      /* Termina nodo:1757   */

      /* Empieza nodo:1811 / Elemento padre: 1756   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1756)).appendChild((Element)v.get(1811));

      /* Empieza nodo:1812 / Elemento padre: 1811   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1812)).setAttribute("width","12" );
      ((Element)v.get(1812)).setAttribute("align","center" );
      ((Element)v.get(1811)).appendChild((Element)v.get(1812));

      /* Empieza nodo:1813 / Elemento padre: 1812   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1813)).setAttribute("src","b.gif" );
      ((Element)v.get(1813)).setAttribute("width","12" );
      ((Element)v.get(1813)).setAttribute("height","15" );
      ((Element)v.get(1812)).appendChild((Element)v.get(1813));
      /* Termina nodo:1813   */
      /* Termina nodo:1812   */

      /* Empieza nodo:1814 / Elemento padre: 1811   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1814)).setAttribute("width","756" );
      ((Element)v.get(1811)).appendChild((Element)v.get(1814));

      /* Empieza nodo:1815 / Elemento padre: 1814   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1815)).setAttribute("src","b.gif" );
      ((Element)v.get(1814)).appendChild((Element)v.get(1815));
      /* Termina nodo:1815   */
      /* Termina nodo:1814   */

      /* Empieza nodo:1816 / Elemento padre: 1811   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1816)).setAttribute("width","12" );
      ((Element)v.get(1811)).appendChild((Element)v.get(1816));

      /* Empieza nodo:1817 / Elemento padre: 1816   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1817)).setAttribute("src","b.gif" );
      ((Element)v.get(1817)).setAttribute("width","12" );
      ((Element)v.get(1817)).setAttribute("height","1" );
      ((Element)v.get(1816)).appendChild((Element)v.get(1817));
      /* Termina nodo:1817   */
      /* Termina nodo:1816   */
      /* Termina nodo:1811   */
      /* Termina nodo:1756   */

      /* Empieza nodo:1818 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1818)).setAttribute("width","100%" );
      ((Element)v.get(1818)).setAttribute("border","0" );
      ((Element)v.get(1818)).setAttribute("align","center" );
      ((Element)v.get(1818)).setAttribute("cellspacing","0" );
      ((Element)v.get(1818)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1818));

      /* Empieza nodo:1819 / Elemento padre: 1818   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1818)).appendChild((Element)v.get(1819));

      /* Empieza nodo:1820 / Elemento padre: 1819   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1819)).appendChild((Element)v.get(1820));

      /* Empieza nodo:1821 / Elemento padre: 1820   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1821)).setAttribute("src","b.gif" );
      ((Element)v.get(1821)).setAttribute("width","8" );
      ((Element)v.get(1821)).setAttribute("height","8" );
      ((Element)v.get(1820)).appendChild((Element)v.get(1821));
      /* Termina nodo:1821   */
      /* Termina nodo:1820   */

      /* Empieza nodo:1822 / Elemento padre: 1819   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1822)).setAttribute("width","100%" );
      ((Element)v.get(1819)).appendChild((Element)v.get(1822));

      /* Empieza nodo:1823 / Elemento padre: 1822   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1822)).appendChild((Element)v.get(1823));

      /* Empieza nodo:1824 / Elemento padre: 1823   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1824)).setAttribute("class","legend" );
      ((Element)v.get(1823)).appendChild((Element)v.get(1824));

      /* Empieza nodo:1825 / Elemento padre: 1824   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1825)).setAttribute("nombre","lblBaseAplicacionDescuentoProducto" );
      ((Element)v.get(1825)).setAttribute("alto","13" );
      ((Element)v.get(1825)).setAttribute("filas","1" );
      ((Element)v.get(1825)).setAttribute("valor","" );
      ((Element)v.get(1825)).setAttribute("id","legend" );
      ((Element)v.get(1825)).setAttribute("cod","00487" );
      ((Element)v.get(1824)).appendChild((Element)v.get(1825));
      /* Termina nodo:1825   */
      /* Termina nodo:1824   */

      /* Empieza nodo:1826 / Elemento padre: 1823   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1826)).setAttribute("width","100%" );
      ((Element)v.get(1826)).setAttribute("border","0" );
      ((Element)v.get(1826)).setAttribute("align","center" );
      ((Element)v.get(1826)).setAttribute("cellspacing","0" );
      ((Element)v.get(1826)).setAttribute("cellpadding","0" );
      ((Element)v.get(1823)).appendChild((Element)v.get(1826));

      /* Empieza nodo:1827 / Elemento padre: 1826   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1826)).appendChild((Element)v.get(1827));

      /* Empieza nodo:1828 / Elemento padre: 1827   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1828)).setAttribute("colspan","3" );
      ((Element)v.get(1827)).appendChild((Element)v.get(1828));

      /* Empieza nodo:1829 / Elemento padre: 1828   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1829)).setAttribute("src","b.gif" );
      ((Element)v.get(1829)).setAttribute("width","8" );
      ((Element)v.get(1829)).setAttribute("height","8" );
      ((Element)v.get(1828)).appendChild((Element)v.get(1829));
      /* Termina nodo:1829   */
      /* Termina nodo:1828   */
      /* Termina nodo:1827   */

      /* Empieza nodo:1830 / Elemento padre: 1826   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1826)).appendChild((Element)v.get(1830));

      /* Empieza nodo:1831 / Elemento padre: 1830   */
   }

   private void getXML7200(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(1830)).appendChild((Element)v.get(1831));

      /* Empieza nodo:1832 / Elemento padre: 1831   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1832)).setAttribute("src","b.gif" );
      ((Element)v.get(1832)).setAttribute("width","8" );
      ((Element)v.get(1832)).setAttribute("height","8" );
      ((Element)v.get(1831)).appendChild((Element)v.get(1832));
      /* Termina nodo:1832   */
      /* Termina nodo:1831   */

      /* Empieza nodo:1833 / Elemento padre: 1830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1830)).appendChild((Element)v.get(1833));

      /* Empieza nodo:1834 / Elemento padre: 1833   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1834)).setAttribute("nombre","lblCodigoBaseAplicacionDescuentoProducto" );
      ((Element)v.get(1834)).setAttribute("alto","13" );
      ((Element)v.get(1834)).setAttribute("filas","1" );
      ((Element)v.get(1834)).setAttribute("valor","" );
      ((Element)v.get(1834)).setAttribute("id","datosTitle" );
      ((Element)v.get(1834)).setAttribute("cod","8" );
      ((Element)v.get(1833)).appendChild((Element)v.get(1834));
      /* Termina nodo:1834   */
      /* Termina nodo:1833   */

      /* Empieza nodo:1835 / Elemento padre: 1830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1830)).appendChild((Element)v.get(1835));

      /* Empieza nodo:1836 / Elemento padre: 1835   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1836)).setAttribute("src","b.gif" );
      ((Element)v.get(1836)).setAttribute("width","25" );
      ((Element)v.get(1836)).setAttribute("height","8" );
      ((Element)v.get(1835)).appendChild((Element)v.get(1836));
      /* Termina nodo:1836   */
      /* Termina nodo:1835   */

      /* Empieza nodo:1837 / Elemento padre: 1830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1830)).appendChild((Element)v.get(1837));

      /* Empieza nodo:1838 / Elemento padre: 1837   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1838)).setAttribute("nombre","lblVisibleBaseAplicacionDescuentoProducto" );
      ((Element)v.get(1838)).setAttribute("alto","13" );
      ((Element)v.get(1838)).setAttribute("filas","1" );
      ((Element)v.get(1838)).setAttribute("valor","" );
      ((Element)v.get(1838)).setAttribute("id","datosTitle" );
      ((Element)v.get(1838)).setAttribute("cod","1038" );
      ((Element)v.get(1837)).appendChild((Element)v.get(1838));
      /* Termina nodo:1838   */
      /* Termina nodo:1837   */

      /* Empieza nodo:1839 / Elemento padre: 1830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1830)).appendChild((Element)v.get(1839));

      /* Empieza nodo:1840 / Elemento padre: 1839   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1840)).setAttribute("src","b.gif" );
      ((Element)v.get(1840)).setAttribute("width","25" );
      ((Element)v.get(1840)).setAttribute("height","8" );
      ((Element)v.get(1839)).appendChild((Element)v.get(1840));
      /* Termina nodo:1840   */
      /* Termina nodo:1839   */

      /* Empieza nodo:1841 / Elemento padre: 1830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1830)).appendChild((Element)v.get(1841));

      /* Empieza nodo:1842 / Elemento padre: 1841   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1842)).setAttribute("nombre","lblObligatorioBaseAplicacionDescuentoProducto" );
      ((Element)v.get(1842)).setAttribute("alto","13" );
      ((Element)v.get(1842)).setAttribute("filas","1" );
      ((Element)v.get(1842)).setAttribute("valor","" );
      ((Element)v.get(1842)).setAttribute("id","datosTitle" );
      ((Element)v.get(1842)).setAttribute("cod","949" );
      ((Element)v.get(1841)).appendChild((Element)v.get(1842));
      /* Termina nodo:1842   */
      /* Termina nodo:1841   */

      /* Empieza nodo:1843 / Elemento padre: 1830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1830)).appendChild((Element)v.get(1843));

      /* Empieza nodo:1844 / Elemento padre: 1843   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1844)).setAttribute("src","b.gif" );
      ((Element)v.get(1844)).setAttribute("width","25" );
      ((Element)v.get(1844)).setAttribute("height","8" );
      ((Element)v.get(1843)).appendChild((Element)v.get(1844));
      /* Termina nodo:1844   */
      /* Termina nodo:1843   */

      /* Empieza nodo:1845 / Elemento padre: 1830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1830)).appendChild((Element)v.get(1845));

      /* Empieza nodo:1846 / Elemento padre: 1845   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1846)).setAttribute("nombre","lblModificableBaseAplicacionDescuentoProducto" );
      ((Element)v.get(1846)).setAttribute("alto","13" );
      ((Element)v.get(1846)).setAttribute("filas","1" );
      ((Element)v.get(1846)).setAttribute("valor","" );
      ((Element)v.get(1846)).setAttribute("id","datosTitle" );
      ((Element)v.get(1846)).setAttribute("cod","914" );
      ((Element)v.get(1845)).appendChild((Element)v.get(1846));
      /* Termina nodo:1846   */
      /* Termina nodo:1845   */

      /* Empieza nodo:1847 / Elemento padre: 1830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1847)).setAttribute("width","100%" );
      ((Element)v.get(1830)).appendChild((Element)v.get(1847));

      /* Empieza nodo:1848 / Elemento padre: 1847   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1848)).setAttribute("src","b.gif" );
      ((Element)v.get(1848)).setAttribute("width","8" );
      ((Element)v.get(1848)).setAttribute("height","8" );
      ((Element)v.get(1847)).appendChild((Element)v.get(1848));
      /* Termina nodo:1848   */
      /* Termina nodo:1847   */
      /* Termina nodo:1830   */

      /* Empieza nodo:1849 / Elemento padre: 1826   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1826)).appendChild((Element)v.get(1849));

      /* Empieza nodo:1850 / Elemento padre: 1849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1849)).appendChild((Element)v.get(1850));

      /* Empieza nodo:1851 / Elemento padre: 1850   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1851)).setAttribute("src","b.gif" );
      ((Element)v.get(1851)).setAttribute("width","8" );
      ((Element)v.get(1851)).setAttribute("height","8" );
      ((Element)v.get(1850)).appendChild((Element)v.get(1851));
      /* Termina nodo:1851   */
      /* Termina nodo:1850   */

      /* Empieza nodo:1852 / Elemento padre: 1849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1849)).appendChild((Element)v.get(1852));

      /* Empieza nodo:1853 / Elemento padre: 1852   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1853)).setAttribute("nombre","lbldtCodigoBaseAplicacionDescuentoProducto" );
      ((Element)v.get(1853)).setAttribute("alto","13" );
   }

   private void getXML7290(Document doc) {
      ((Element)v.get(1853)).setAttribute("filas","1" );
      ((Element)v.get(1853)).setAttribute("valor","25" );
      ((Element)v.get(1853)).setAttribute("id","datosCampos" );
      ((Element)v.get(1852)).appendChild((Element)v.get(1853));
      /* Termina nodo:1853   */
      /* Termina nodo:1852   */

      /* Empieza nodo:1854 / Elemento padre: 1849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1849)).appendChild((Element)v.get(1854));

      /* Empieza nodo:1855 / Elemento padre: 1854   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1855)).setAttribute("src","b.gif" );
      ((Element)v.get(1855)).setAttribute("width","25" );
      ((Element)v.get(1855)).setAttribute("height","8" );
      ((Element)v.get(1854)).appendChild((Element)v.get(1855));
      /* Termina nodo:1855   */
      /* Termina nodo:1854   */

      /* Empieza nodo:1856 / Elemento padre: 1849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1849)).appendChild((Element)v.get(1856));

      /* Empieza nodo:1857 / Elemento padre: 1856   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1857)).setAttribute("nombre","ckVisibleBaseAplicacionDescuentoProducto" );
      ((Element)v.get(1857)).setAttribute("id","datosCampos" );
      ((Element)v.get(1857)).setAttribute("onclick","cambiaObli(23)" );
      ((Element)v.get(1857)).setAttribute("check","S" );
      ((Element)v.get(1856)).appendChild((Element)v.get(1857));
      /* Termina nodo:1857   */
      /* Termina nodo:1856   */

      /* Empieza nodo:1858 / Elemento padre: 1849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1849)).appendChild((Element)v.get(1858));

      /* Empieza nodo:1859 / Elemento padre: 1858   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1859)).setAttribute("src","b.gif" );
      ((Element)v.get(1859)).setAttribute("width","25" );
      ((Element)v.get(1859)).setAttribute("height","8" );
      ((Element)v.get(1858)).appendChild((Element)v.get(1859));
      /* Termina nodo:1859   */
      /* Termina nodo:1858   */

      /* Empieza nodo:1860 / Elemento padre: 1849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1849)).appendChild((Element)v.get(1860));

      /* Empieza nodo:1861 / Elemento padre: 1860   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1861)).setAttribute("nombre","ckObligatorioBaseAplicacionDescuentoProducto" );
      ((Element)v.get(1861)).setAttribute("id","datosCampos" );
      ((Element)v.get(1861)).setAttribute("onclick","" );
      ((Element)v.get(1861)).setAttribute("check","N" );
      ((Element)v.get(1860)).appendChild((Element)v.get(1861));
      /* Termina nodo:1861   */
      /* Termina nodo:1860   */

      /* Empieza nodo:1862 / Elemento padre: 1849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1849)).appendChild((Element)v.get(1862));

      /* Empieza nodo:1863 / Elemento padre: 1862   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1863)).setAttribute("src","b.gif" );
      ((Element)v.get(1863)).setAttribute("width","25" );
      ((Element)v.get(1863)).setAttribute("height","8" );
      ((Element)v.get(1862)).appendChild((Element)v.get(1863));
      /* Termina nodo:1863   */
      /* Termina nodo:1862   */

      /* Empieza nodo:1864 / Elemento padre: 1849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1849)).appendChild((Element)v.get(1864));

      /* Empieza nodo:1865 / Elemento padre: 1864   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1865)).setAttribute("nombre","ckModificableBaseAplicacionDescuentoProducto" );
      ((Element)v.get(1865)).setAttribute("id","datosCampos" );
      ((Element)v.get(1865)).setAttribute("onclick","" );
      ((Element)v.get(1865)).setAttribute("check","S" );
      ((Element)v.get(1864)).appendChild((Element)v.get(1865));
      /* Termina nodo:1865   */
      /* Termina nodo:1864   */

      /* Empieza nodo:1866 / Elemento padre: 1849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1866)).setAttribute("width","100%" );
      ((Element)v.get(1849)).appendChild((Element)v.get(1866));

      /* Empieza nodo:1867 / Elemento padre: 1866   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1867)).setAttribute("src","b.gif" );
      ((Element)v.get(1867)).setAttribute("width","8" );
      ((Element)v.get(1867)).setAttribute("height","8" );
      ((Element)v.get(1866)).appendChild((Element)v.get(1867));
      /* Termina nodo:1867   */
      /* Termina nodo:1866   */
      /* Termina nodo:1849   */

      /* Empieza nodo:1868 / Elemento padre: 1826   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1826)).appendChild((Element)v.get(1868));

      /* Empieza nodo:1869 / Elemento padre: 1868   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1869)).setAttribute("colspan","4" );
      ((Element)v.get(1868)).appendChild((Element)v.get(1869));

      /* Empieza nodo:1870 / Elemento padre: 1869   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1870)).setAttribute("src","b.gif" );
      ((Element)v.get(1870)).setAttribute("width","8" );
      ((Element)v.get(1870)).setAttribute("height","8" );
      ((Element)v.get(1869)).appendChild((Element)v.get(1870));
      /* Termina nodo:1870   */
      /* Termina nodo:1869   */
      /* Termina nodo:1868   */
      /* Termina nodo:1826   */
      /* Termina nodo:1823   */
      /* Termina nodo:1822   */

      /* Empieza nodo:1871 / Elemento padre: 1819   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1819)).appendChild((Element)v.get(1871));

      /* Empieza nodo:1872 / Elemento padre: 1871   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1872)).setAttribute("src","b.gif" );
      ((Element)v.get(1871)).appendChild((Element)v.get(1872));
      /* Termina nodo:1872   */
      /* Termina nodo:1871   */
      /* Termina nodo:1819   */

      /* Empieza nodo:1873 / Elemento padre: 1818   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1818)).appendChild((Element)v.get(1873));

      /* Empieza nodo:1874 / Elemento padre: 1873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1874)).setAttribute("width","12" );
      ((Element)v.get(1874)).setAttribute("align","center" );
      ((Element)v.get(1873)).appendChild((Element)v.get(1874));

      /* Empieza nodo:1875 / Elemento padre: 1874   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1875)).setAttribute("src","b.gif" );
      ((Element)v.get(1875)).setAttribute("width","12" );
      ((Element)v.get(1875)).setAttribute("height","15" );
      ((Element)v.get(1874)).appendChild((Element)v.get(1875));
      /* Termina nodo:1875   */
      /* Termina nodo:1874   */

      /* Empieza nodo:1876 / Elemento padre: 1873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1876)).setAttribute("width","756" );
      ((Element)v.get(1873)).appendChild((Element)v.get(1876));

      /* Empieza nodo:1877 / Elemento padre: 1876   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1877)).setAttribute("src","b.gif" );
      ((Element)v.get(1876)).appendChild((Element)v.get(1877));
      /* Termina nodo:1877   */
      /* Termina nodo:1876   */

      /* Empieza nodo:1878 / Elemento padre: 1873   */
      v.add(doc.createElement("td"));
   }

   private void getXML7380(Document doc) {
      ((Element)v.get(1878)).setAttribute("width","12" );
      ((Element)v.get(1873)).appendChild((Element)v.get(1878));

      /* Empieza nodo:1879 / Elemento padre: 1878   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1879)).setAttribute("src","b.gif" );
      ((Element)v.get(1879)).setAttribute("width","12" );
      ((Element)v.get(1879)).setAttribute("height","1" );
      ((Element)v.get(1878)).appendChild((Element)v.get(1879));
      /* Termina nodo:1879   */
      /* Termina nodo:1878   */
      /* Termina nodo:1873   */
      /* Termina nodo:1818   */

      /* Empieza nodo:1880 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1880)).setAttribute("width","100%" );
      ((Element)v.get(1880)).setAttribute("border","0" );
      ((Element)v.get(1880)).setAttribute("align","center" );
      ((Element)v.get(1880)).setAttribute("cellspacing","0" );
      ((Element)v.get(1880)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1880));

      /* Empieza nodo:1881 / Elemento padre: 1880   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1880)).appendChild((Element)v.get(1881));

      /* Empieza nodo:1882 / Elemento padre: 1881   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1881)).appendChild((Element)v.get(1882));

      /* Empieza nodo:1883 / Elemento padre: 1882   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1883)).setAttribute("src","b.gif" );
      ((Element)v.get(1883)).setAttribute("width","8" );
      ((Element)v.get(1883)).setAttribute("height","8" );
      ((Element)v.get(1882)).appendChild((Element)v.get(1883));
      /* Termina nodo:1883   */
      /* Termina nodo:1882   */

      /* Empieza nodo:1884 / Elemento padre: 1881   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1884)).setAttribute("width","100%" );
      ((Element)v.get(1881)).appendChild((Element)v.get(1884));

      /* Empieza nodo:1885 / Elemento padre: 1884   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1884)).appendChild((Element)v.get(1885));

      /* Empieza nodo:1886 / Elemento padre: 1885   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1886)).setAttribute("class","legend" );
      ((Element)v.get(1885)).appendChild((Element)v.get(1886));

      /* Empieza nodo:1887 / Elemento padre: 1886   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1887)).setAttribute("nombre","lblControlMorosidad" );
      ((Element)v.get(1887)).setAttribute("alto","13" );
      ((Element)v.get(1887)).setAttribute("filas","1" );
      ((Element)v.get(1887)).setAttribute("valor","" );
      ((Element)v.get(1887)).setAttribute("id","legend" );
      ((Element)v.get(1887)).setAttribute("cod","00259" );
      ((Element)v.get(1886)).appendChild((Element)v.get(1887));
      /* Termina nodo:1887   */
      /* Termina nodo:1886   */

      /* Empieza nodo:1888 / Elemento padre: 1885   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1888)).setAttribute("width","100%" );
      ((Element)v.get(1888)).setAttribute("border","0" );
      ((Element)v.get(1888)).setAttribute("align","center" );
      ((Element)v.get(1888)).setAttribute("cellspacing","0" );
      ((Element)v.get(1888)).setAttribute("cellpadding","0" );
      ((Element)v.get(1885)).appendChild((Element)v.get(1888));

      /* Empieza nodo:1889 / Elemento padre: 1888   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1888)).appendChild((Element)v.get(1889));

      /* Empieza nodo:1890 / Elemento padre: 1889   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1890)).setAttribute("colspan","3" );
      ((Element)v.get(1889)).appendChild((Element)v.get(1890));

      /* Empieza nodo:1891 / Elemento padre: 1890   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1891)).setAttribute("src","b.gif" );
      ((Element)v.get(1891)).setAttribute("width","8" );
      ((Element)v.get(1891)).setAttribute("height","8" );
      ((Element)v.get(1890)).appendChild((Element)v.get(1891));
      /* Termina nodo:1891   */
      /* Termina nodo:1890   */
      /* Termina nodo:1889   */

      /* Empieza nodo:1892 / Elemento padre: 1888   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1888)).appendChild((Element)v.get(1892));

      /* Empieza nodo:1893 / Elemento padre: 1892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1892)).appendChild((Element)v.get(1893));

      /* Empieza nodo:1894 / Elemento padre: 1893   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1894)).setAttribute("src","b.gif" );
      ((Element)v.get(1894)).setAttribute("width","8" );
      ((Element)v.get(1894)).setAttribute("height","8" );
      ((Element)v.get(1893)).appendChild((Element)v.get(1894));
      /* Termina nodo:1894   */
      /* Termina nodo:1893   */

      /* Empieza nodo:1895 / Elemento padre: 1892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1892)).appendChild((Element)v.get(1895));

      /* Empieza nodo:1896 / Elemento padre: 1895   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1896)).setAttribute("nombre","lblCodigoControlMorosidad" );
      ((Element)v.get(1896)).setAttribute("alto","13" );
      ((Element)v.get(1896)).setAttribute("filas","1" );
      ((Element)v.get(1896)).setAttribute("valor","" );
      ((Element)v.get(1896)).setAttribute("id","datosTitle" );
      ((Element)v.get(1896)).setAttribute("cod","8" );
      ((Element)v.get(1895)).appendChild((Element)v.get(1896));
      /* Termina nodo:1896   */
      /* Termina nodo:1895   */

      /* Empieza nodo:1897 / Elemento padre: 1892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1892)).appendChild((Element)v.get(1897));

      /* Empieza nodo:1898 / Elemento padre: 1897   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1898)).setAttribute("src","b.gif" );
      ((Element)v.get(1898)).setAttribute("width","25" );
      ((Element)v.get(1898)).setAttribute("height","8" );
      ((Element)v.get(1897)).appendChild((Element)v.get(1898));
      /* Termina nodo:1898   */
      /* Termina nodo:1897   */

      /* Empieza nodo:1899 / Elemento padre: 1892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1892)).appendChild((Element)v.get(1899));

      /* Empieza nodo:1900 / Elemento padre: 1899   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1900)).setAttribute("nombre","lblVisibleControlMorosidad" );
      ((Element)v.get(1900)).setAttribute("alto","13" );
      ((Element)v.get(1900)).setAttribute("filas","1" );
      ((Element)v.get(1900)).setAttribute("valor","" );
      ((Element)v.get(1900)).setAttribute("id","datosTitle" );
   }

   private void getXML7470(Document doc) {
      ((Element)v.get(1900)).setAttribute("cod","1038" );
      ((Element)v.get(1899)).appendChild((Element)v.get(1900));
      /* Termina nodo:1900   */
      /* Termina nodo:1899   */

      /* Empieza nodo:1901 / Elemento padre: 1892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1892)).appendChild((Element)v.get(1901));

      /* Empieza nodo:1902 / Elemento padre: 1901   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1902)).setAttribute("src","b.gif" );
      ((Element)v.get(1902)).setAttribute("width","25" );
      ((Element)v.get(1902)).setAttribute("height","8" );
      ((Element)v.get(1901)).appendChild((Element)v.get(1902));
      /* Termina nodo:1902   */
      /* Termina nodo:1901   */

      /* Empieza nodo:1903 / Elemento padre: 1892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1892)).appendChild((Element)v.get(1903));

      /* Empieza nodo:1904 / Elemento padre: 1903   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1904)).setAttribute("nombre","lblObligatorioControlMorosidad" );
      ((Element)v.get(1904)).setAttribute("alto","13" );
      ((Element)v.get(1904)).setAttribute("filas","1" );
      ((Element)v.get(1904)).setAttribute("valor","" );
      ((Element)v.get(1904)).setAttribute("id","datosTitle" );
      ((Element)v.get(1904)).setAttribute("cod","949" );
      ((Element)v.get(1903)).appendChild((Element)v.get(1904));
      /* Termina nodo:1904   */
      /* Termina nodo:1903   */

      /* Empieza nodo:1905 / Elemento padre: 1892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1892)).appendChild((Element)v.get(1905));

      /* Empieza nodo:1906 / Elemento padre: 1905   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1906)).setAttribute("src","b.gif" );
      ((Element)v.get(1906)).setAttribute("width","25" );
      ((Element)v.get(1906)).setAttribute("height","8" );
      ((Element)v.get(1905)).appendChild((Element)v.get(1906));
      /* Termina nodo:1906   */
      /* Termina nodo:1905   */

      /* Empieza nodo:1907 / Elemento padre: 1892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1892)).appendChild((Element)v.get(1907));

      /* Empieza nodo:1908 / Elemento padre: 1907   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1908)).setAttribute("nombre","lblModificableControlMorosidad" );
      ((Element)v.get(1908)).setAttribute("alto","13" );
      ((Element)v.get(1908)).setAttribute("filas","1" );
      ((Element)v.get(1908)).setAttribute("valor","" );
      ((Element)v.get(1908)).setAttribute("id","datosTitle" );
      ((Element)v.get(1908)).setAttribute("cod","914" );
      ((Element)v.get(1907)).appendChild((Element)v.get(1908));
      /* Termina nodo:1908   */
      /* Termina nodo:1907   */

      /* Empieza nodo:1909 / Elemento padre: 1892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1909)).setAttribute("width","100%" );
      ((Element)v.get(1892)).appendChild((Element)v.get(1909));

      /* Empieza nodo:1910 / Elemento padre: 1909   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1910)).setAttribute("src","b.gif" );
      ((Element)v.get(1910)).setAttribute("width","8" );
      ((Element)v.get(1910)).setAttribute("height","8" );
      ((Element)v.get(1909)).appendChild((Element)v.get(1910));
      /* Termina nodo:1910   */
      /* Termina nodo:1909   */
      /* Termina nodo:1892   */

      /* Empieza nodo:1911 / Elemento padre: 1888   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1888)).appendChild((Element)v.get(1911));

      /* Empieza nodo:1912 / Elemento padre: 1911   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1911)).appendChild((Element)v.get(1912));

      /* Empieza nodo:1913 / Elemento padre: 1912   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1913)).setAttribute("src","b.gif" );
      ((Element)v.get(1913)).setAttribute("width","8" );
      ((Element)v.get(1913)).setAttribute("height","8" );
      ((Element)v.get(1912)).appendChild((Element)v.get(1913));
      /* Termina nodo:1913   */
      /* Termina nodo:1912   */

      /* Empieza nodo:1914 / Elemento padre: 1911   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1911)).appendChild((Element)v.get(1914));

      /* Empieza nodo:1915 / Elemento padre: 1914   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1915)).setAttribute("nombre","lbldtCodigoControlMorosidad" );
      ((Element)v.get(1915)).setAttribute("alto","13" );
      ((Element)v.get(1915)).setAttribute("filas","1" );
      ((Element)v.get(1915)).setAttribute("valor","26" );
      ((Element)v.get(1915)).setAttribute("id","datosCampos" );
      ((Element)v.get(1914)).appendChild((Element)v.get(1915));
      /* Termina nodo:1915   */
      /* Termina nodo:1914   */

      /* Empieza nodo:1916 / Elemento padre: 1911   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1911)).appendChild((Element)v.get(1916));

      /* Empieza nodo:1917 / Elemento padre: 1916   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1917)).setAttribute("src","b.gif" );
      ((Element)v.get(1917)).setAttribute("width","25" );
      ((Element)v.get(1917)).setAttribute("height","8" );
      ((Element)v.get(1916)).appendChild((Element)v.get(1917));
      /* Termina nodo:1917   */
      /* Termina nodo:1916   */

      /* Empieza nodo:1918 / Elemento padre: 1911   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1911)).appendChild((Element)v.get(1918));

      /* Empieza nodo:1919 / Elemento padre: 1918   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1919)).setAttribute("nombre","ckVisibleControlMorosidad" );
      ((Element)v.get(1919)).setAttribute("id","datosCampos" );
      ((Element)v.get(1919)).setAttribute("onclick","cambiaObli(24)" );
      ((Element)v.get(1919)).setAttribute("check","S" );
      ((Element)v.get(1918)).appendChild((Element)v.get(1919));
      /* Termina nodo:1919   */
      /* Termina nodo:1918   */

      /* Empieza nodo:1920 / Elemento padre: 1911   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1911)).appendChild((Element)v.get(1920));

      /* Empieza nodo:1921 / Elemento padre: 1920   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1921)).setAttribute("src","b.gif" );
      ((Element)v.get(1921)).setAttribute("width","25" );
      ((Element)v.get(1921)).setAttribute("height","8" );
      ((Element)v.get(1920)).appendChild((Element)v.get(1921));
      /* Termina nodo:1921   */
      /* Termina nodo:1920   */

      /* Empieza nodo:1922 / Elemento padre: 1911   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1911)).appendChild((Element)v.get(1922));

      /* Empieza nodo:1923 / Elemento padre: 1922   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1923)).setAttribute("nombre","ckObligatorioControlMorosidad" );
      ((Element)v.get(1923)).setAttribute("id","datosCampos" );
      ((Element)v.get(1923)).setAttribute("onclick","" );
   }

   private void getXML7560(Document doc) {
      ((Element)v.get(1923)).setAttribute("check","N" );
      ((Element)v.get(1922)).appendChild((Element)v.get(1923));
      /* Termina nodo:1923   */
      /* Termina nodo:1922   */

      /* Empieza nodo:1924 / Elemento padre: 1911   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1911)).appendChild((Element)v.get(1924));

      /* Empieza nodo:1925 / Elemento padre: 1924   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1925)).setAttribute("src","b.gif" );
      ((Element)v.get(1925)).setAttribute("width","25" );
      ((Element)v.get(1925)).setAttribute("height","8" );
      ((Element)v.get(1924)).appendChild((Element)v.get(1925));
      /* Termina nodo:1925   */
      /* Termina nodo:1924   */

      /* Empieza nodo:1926 / Elemento padre: 1911   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1911)).appendChild((Element)v.get(1926));

      /* Empieza nodo:1927 / Elemento padre: 1926   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(1927)).setAttribute("nombre","ckModificableControlMorosidad" );
      ((Element)v.get(1927)).setAttribute("id","datosCampos" );
      ((Element)v.get(1927)).setAttribute("onclick","" );
      ((Element)v.get(1927)).setAttribute("check","S" );
      ((Element)v.get(1926)).appendChild((Element)v.get(1927));
      /* Termina nodo:1927   */
      /* Termina nodo:1926   */

      /* Empieza nodo:1928 / Elemento padre: 1911   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1928)).setAttribute("width","100%" );
      ((Element)v.get(1911)).appendChild((Element)v.get(1928));

      /* Empieza nodo:1929 / Elemento padre: 1928   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1929)).setAttribute("src","b.gif" );
      ((Element)v.get(1929)).setAttribute("width","8" );
      ((Element)v.get(1929)).setAttribute("height","8" );
      ((Element)v.get(1928)).appendChild((Element)v.get(1929));
      /* Termina nodo:1929   */
      /* Termina nodo:1928   */
      /* Termina nodo:1911   */

      /* Empieza nodo:1930 / Elemento padre: 1888   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1888)).appendChild((Element)v.get(1930));

      /* Empieza nodo:1931 / Elemento padre: 1930   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1931)).setAttribute("colspan","4" );
      ((Element)v.get(1930)).appendChild((Element)v.get(1931));

      /* Empieza nodo:1932 / Elemento padre: 1931   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1932)).setAttribute("src","b.gif" );
      ((Element)v.get(1932)).setAttribute("width","8" );
      ((Element)v.get(1932)).setAttribute("height","8" );
      ((Element)v.get(1931)).appendChild((Element)v.get(1932));
      /* Termina nodo:1932   */
      /* Termina nodo:1931   */
      /* Termina nodo:1930   */
      /* Termina nodo:1888   */

      /* Empieza nodo:1933 / Elemento padre: 1885   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1933)).setAttribute("width","100%" );
      ((Element)v.get(1933)).setAttribute("border","0" );
      ((Element)v.get(1933)).setAttribute("align","center" );
      ((Element)v.get(1933)).setAttribute("cellspacing","0" );
      ((Element)v.get(1933)).setAttribute("cellpadding","0" );
      ((Element)v.get(1885)).appendChild((Element)v.get(1933));

      /* Empieza nodo:1934 / Elemento padre: 1933   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1933)).appendChild((Element)v.get(1934));

      /* Empieza nodo:1935 / Elemento padre: 1934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1934)).appendChild((Element)v.get(1935));

      /* Empieza nodo:1936 / Elemento padre: 1935   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1936)).setAttribute("src","b.gif" );
      ((Element)v.get(1936)).setAttribute("width","8" );
      ((Element)v.get(1936)).setAttribute("height","8" );
      ((Element)v.get(1935)).appendChild((Element)v.get(1936));
      /* Termina nodo:1936   */
      /* Termina nodo:1935   */

      /* Empieza nodo:1937 / Elemento padre: 1934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1934)).appendChild((Element)v.get(1937));

      /* Empieza nodo:1938 / Elemento padre: 1937   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1938)).setAttribute("nombre","lblValoresPosiblesControlMorosidad" );
      ((Element)v.get(1938)).setAttribute("alto","13" );
      ((Element)v.get(1938)).setAttribute("filas","1" );
      ((Element)v.get(1938)).setAttribute("valor","" );
      ((Element)v.get(1938)).setAttribute("id","datosTitle" );
      ((Element)v.get(1938)).setAttribute("cod","1022" );
      ((Element)v.get(1937)).appendChild((Element)v.get(1938));
      /* Termina nodo:1938   */
      /* Termina nodo:1937   */

      /* Empieza nodo:1939 / Elemento padre: 1934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1934)).appendChild((Element)v.get(1939));

      /* Empieza nodo:1940 / Elemento padre: 1939   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1940)).setAttribute("src","b.gif" );
      ((Element)v.get(1940)).setAttribute("width","25" );
      ((Element)v.get(1940)).setAttribute("height","8" );
      ((Element)v.get(1939)).appendChild((Element)v.get(1940));
      /* Termina nodo:1940   */
      /* Termina nodo:1939   */

      /* Empieza nodo:1941 / Elemento padre: 1934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1934)).appendChild((Element)v.get(1941));

      /* Empieza nodo:1942 / Elemento padre: 1941   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1942)).setAttribute("nombre","lblValoresDefectoControlMorosidad" );
      ((Element)v.get(1942)).setAttribute("alto","13" );
      ((Element)v.get(1942)).setAttribute("filas","1" );
      ((Element)v.get(1942)).setAttribute("valor","" );
      ((Element)v.get(1942)).setAttribute("id","datosTitle" );
      ((Element)v.get(1942)).setAttribute("cod","1286" );
      ((Element)v.get(1941)).appendChild((Element)v.get(1942));
      /* Termina nodo:1942   */
      /* Termina nodo:1941   */

      /* Empieza nodo:1943 / Elemento padre: 1934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1943)).setAttribute("width","100%" );
      ((Element)v.get(1934)).appendChild((Element)v.get(1943));

      /* Empieza nodo:1944 / Elemento padre: 1943   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1944)).setAttribute("src","b.gif" );
      ((Element)v.get(1944)).setAttribute("width","8" );
      ((Element)v.get(1944)).setAttribute("height","8" );
      ((Element)v.get(1943)).appendChild((Element)v.get(1944));
      /* Termina nodo:1944   */
      /* Termina nodo:1943   */
      /* Termina nodo:1934   */

      /* Empieza nodo:1945 / Elemento padre: 1933   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1933)).appendChild((Element)v.get(1945));

      /* Empieza nodo:1946 / Elemento padre: 1945   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1945)).appendChild((Element)v.get(1946));

      /* Empieza nodo:1947 / Elemento padre: 1946   */
   }

   private void getXML7650(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1947)).setAttribute("src","b.gif" );
      ((Element)v.get(1947)).setAttribute("width","8" );
      ((Element)v.get(1947)).setAttribute("height","8" );
      ((Element)v.get(1946)).appendChild((Element)v.get(1947));
      /* Termina nodo:1947   */
      /* Termina nodo:1946   */

      /* Empieza nodo:1948 / Elemento padre: 1945   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1948)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(1945)).appendChild((Element)v.get(1948));

      /* Empieza nodo:1949 / Elemento padre: 1948   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(1949)).setAttribute("nombre","cbValoresPosiblesControlMorosidad" );
      ((Element)v.get(1949)).setAttribute("onchange","controlMorosidadOnChange();" );
      ((Element)v.get(1949)).setAttribute("id","datosCampos" );
      ((Element)v.get(1949)).setAttribute("size","3" );
      ((Element)v.get(1949)).setAttribute("multiple","S" );
      ((Element)v.get(1949)).setAttribute("req","S" );
      ((Element)v.get(1949)).setAttribute("valorinicial","" );
      ((Element)v.get(1949)).setAttribute("textoinicial","" );
      ((Element)v.get(1948)).appendChild((Element)v.get(1949));

      /* Empieza nodo:1950 / Elemento padre: 1949   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1949)).appendChild((Element)v.get(1950));

      /* Empieza nodo:1951 / Elemento padre: 1950   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(1951)).setAttribute("ID","1" );
      ((Element)v.get(1950)).appendChild((Element)v.get(1951));

      /* Empieza nodo:1952 / Elemento padre: 1951   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1952)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(1952)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1952)).setAttribute("VALOR","1" );
      ((Element)v.get(1951)).appendChild((Element)v.get(1952));
      /* Termina nodo:1952   */

      /* Empieza nodo:1953 / Elemento padre: 1951   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1953)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(1953)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1953)).setAttribute("VALOR","Si" );
      ((Element)v.get(1951)).appendChild((Element)v.get(1953));
      /* Termina nodo:1953   */
      /* Termina nodo:1951   */

      /* Empieza nodo:1954 / Elemento padre: 1950   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(1954)).setAttribute("ID","2" );
      ((Element)v.get(1950)).appendChild((Element)v.get(1954));

      /* Empieza nodo:1955 / Elemento padre: 1954   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1955)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(1955)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1955)).setAttribute("VALOR","0" );
      ((Element)v.get(1954)).appendChild((Element)v.get(1955));
      /* Termina nodo:1955   */

      /* Empieza nodo:1956 / Elemento padre: 1954   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1956)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(1956)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1956)).setAttribute("VALOR","No" );
      ((Element)v.get(1954)).appendChild((Element)v.get(1956));
      /* Termina nodo:1956   */
      /* Termina nodo:1954   */
      /* Termina nodo:1950   */
      /* Termina nodo:1949   */
      /* Termina nodo:1948   */

      /* Empieza nodo:1957 / Elemento padre: 1945   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1945)).appendChild((Element)v.get(1957));

      /* Empieza nodo:1958 / Elemento padre: 1957   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1958)).setAttribute("src","b.gif" );
      ((Element)v.get(1958)).setAttribute("width","25" );
      ((Element)v.get(1958)).setAttribute("height","8" );
      ((Element)v.get(1957)).appendChild((Element)v.get(1958));
      /* Termina nodo:1958   */
      /* Termina nodo:1957   */

      /* Empieza nodo:1959 / Elemento padre: 1945   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1959)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(1959)).setAttribute("valign","top" );
      ((Element)v.get(1945)).appendChild((Element)v.get(1959));

      /* Empieza nodo:1960 / Elemento padre: 1959   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(1960)).setAttribute("nombre","cbValoresDefectoControlMorosidad" );
      ((Element)v.get(1960)).setAttribute("id","datosCampos" );
      ((Element)v.get(1960)).setAttribute("size","1" );
      ((Element)v.get(1960)).setAttribute("multiple","N" );
      ((Element)v.get(1960)).setAttribute("req","N" );
      ((Element)v.get(1960)).setAttribute("valorinicial","" );
      ((Element)v.get(1960)).setAttribute("textoinicial","" );
      ((Element)v.get(1959)).appendChild((Element)v.get(1960));

      /* Empieza nodo:1961 / Elemento padre: 1960   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1960)).appendChild((Element)v.get(1961));
      /* Termina nodo:1961   */
      /* Termina nodo:1960   */
      /* Termina nodo:1959   */

      /* Empieza nodo:1962 / Elemento padre: 1945   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1962)).setAttribute("width","100%" );
      ((Element)v.get(1945)).appendChild((Element)v.get(1962));

      /* Empieza nodo:1963 / Elemento padre: 1962   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1963)).setAttribute("src","b.gif" );
      ((Element)v.get(1963)).setAttribute("width","8" );
      ((Element)v.get(1963)).setAttribute("height","8" );
      ((Element)v.get(1962)).appendChild((Element)v.get(1963));
      /* Termina nodo:1963   */
      /* Termina nodo:1962   */
      /* Termina nodo:1945   */

      /* Empieza nodo:1964 / Elemento padre: 1933   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1933)).appendChild((Element)v.get(1964));

      /* Empieza nodo:1965 / Elemento padre: 1964   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1965)).setAttribute("colspan","4" );
      ((Element)v.get(1964)).appendChild((Element)v.get(1965));

      /* Empieza nodo:1966 / Elemento padre: 1965   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1966)).setAttribute("src","b.gif" );
      ((Element)v.get(1966)).setAttribute("width","8" );
      ((Element)v.get(1966)).setAttribute("height","8" );
      ((Element)v.get(1965)).appendChild((Element)v.get(1966));
      /* Termina nodo:1966   */
      /* Termina nodo:1965   */
      /* Termina nodo:1964   */
      /* Termina nodo:1933   */
      /* Termina nodo:1885   */
      /* Termina nodo:1884   */

      /* Empieza nodo:1967 / Elemento padre: 1881   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1881)).appendChild((Element)v.get(1967));

      /* Empieza nodo:1968 / Elemento padre: 1967   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1968)).setAttribute("src","b.gif" );
   }

   private void getXML7740(Document doc) {
      ((Element)v.get(1967)).appendChild((Element)v.get(1968));
      /* Termina nodo:1968   */
      /* Termina nodo:1967   */
      /* Termina nodo:1881   */

      /* Empieza nodo:1969 / Elemento padre: 1880   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1880)).appendChild((Element)v.get(1969));

      /* Empieza nodo:1970 / Elemento padre: 1969   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1970)).setAttribute("width","12" );
      ((Element)v.get(1970)).setAttribute("align","center" );
      ((Element)v.get(1969)).appendChild((Element)v.get(1970));

      /* Empieza nodo:1971 / Elemento padre: 1970   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1971)).setAttribute("src","b.gif" );
      ((Element)v.get(1971)).setAttribute("width","12" );
      ((Element)v.get(1971)).setAttribute("height","15" );
      ((Element)v.get(1970)).appendChild((Element)v.get(1971));
      /* Termina nodo:1971   */
      /* Termina nodo:1970   */

      /* Empieza nodo:1972 / Elemento padre: 1969   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1972)).setAttribute("width","756" );
      ((Element)v.get(1969)).appendChild((Element)v.get(1972));

      /* Empieza nodo:1973 / Elemento padre: 1972   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1973)).setAttribute("src","b.gif" );
      ((Element)v.get(1972)).appendChild((Element)v.get(1973));
      /* Termina nodo:1973   */
      /* Termina nodo:1972   */

      /* Empieza nodo:1974 / Elemento padre: 1969   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1974)).setAttribute("width","12" );
      ((Element)v.get(1969)).appendChild((Element)v.get(1974));

      /* Empieza nodo:1975 / Elemento padre: 1974   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1975)).setAttribute("src","b.gif" );
      ((Element)v.get(1975)).setAttribute("width","12" );
      ((Element)v.get(1975)).setAttribute("height","1" );
      ((Element)v.get(1974)).appendChild((Element)v.get(1975));
      /* Termina nodo:1975   */
      /* Termina nodo:1974   */
      /* Termina nodo:1969   */
      /* Termina nodo:1880   */

      /* Empieza nodo:1976 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1976)).setAttribute("width","100%" );
      ((Element)v.get(1976)).setAttribute("border","0" );
      ((Element)v.get(1976)).setAttribute("align","center" );
      ((Element)v.get(1976)).setAttribute("cellspacing","0" );
      ((Element)v.get(1976)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(1976));

      /* Empieza nodo:1977 / Elemento padre: 1976   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1976)).appendChild((Element)v.get(1977));

      /* Empieza nodo:1978 / Elemento padre: 1977   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1977)).appendChild((Element)v.get(1978));

      /* Empieza nodo:1979 / Elemento padre: 1978   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1979)).setAttribute("src","b.gif" );
      ((Element)v.get(1979)).setAttribute("width","8" );
      ((Element)v.get(1979)).setAttribute("height","8" );
      ((Element)v.get(1978)).appendChild((Element)v.get(1979));
      /* Termina nodo:1979   */
      /* Termina nodo:1978   */

      /* Empieza nodo:1980 / Elemento padre: 1977   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1980)).setAttribute("width","100%" );
      ((Element)v.get(1977)).appendChild((Element)v.get(1980));

      /* Empieza nodo:1981 / Elemento padre: 1980   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1980)).appendChild((Element)v.get(1981));

      /* Empieza nodo:1982 / Elemento padre: 1981   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1982)).setAttribute("class","legend" );
      ((Element)v.get(1981)).appendChild((Element)v.get(1982));

      /* Empieza nodo:1983 / Elemento padre: 1982   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1983)).setAttribute("nombre","lblControlDevolucionesAnulaciones" );
      ((Element)v.get(1983)).setAttribute("alto","13" );
      ((Element)v.get(1983)).setAttribute("filas","1" );
      ((Element)v.get(1983)).setAttribute("valor","" );
      ((Element)v.get(1983)).setAttribute("id","legend" );
      ((Element)v.get(1983)).setAttribute("cod","00488" );
      ((Element)v.get(1982)).appendChild((Element)v.get(1983));
      /* Termina nodo:1983   */
      /* Termina nodo:1982   */

      /* Empieza nodo:1984 / Elemento padre: 1981   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1984)).setAttribute("width","100%" );
      ((Element)v.get(1984)).setAttribute("border","0" );
      ((Element)v.get(1984)).setAttribute("align","center" );
      ((Element)v.get(1984)).setAttribute("cellspacing","0" );
      ((Element)v.get(1984)).setAttribute("cellpadding","0" );
      ((Element)v.get(1981)).appendChild((Element)v.get(1984));

      /* Empieza nodo:1985 / Elemento padre: 1984   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1984)).appendChild((Element)v.get(1985));

      /* Empieza nodo:1986 / Elemento padre: 1985   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1986)).setAttribute("colspan","3" );
      ((Element)v.get(1985)).appendChild((Element)v.get(1986));

      /* Empieza nodo:1987 / Elemento padre: 1986   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1987)).setAttribute("src","b.gif" );
      ((Element)v.get(1987)).setAttribute("width","8" );
      ((Element)v.get(1987)).setAttribute("height","8" );
      ((Element)v.get(1986)).appendChild((Element)v.get(1987));
      /* Termina nodo:1987   */
      /* Termina nodo:1986   */
      /* Termina nodo:1985   */

      /* Empieza nodo:1988 / Elemento padre: 1984   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1984)).appendChild((Element)v.get(1988));

      /* Empieza nodo:1989 / Elemento padre: 1988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1988)).appendChild((Element)v.get(1989));

      /* Empieza nodo:1990 / Elemento padre: 1989   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1990)).setAttribute("src","b.gif" );
      ((Element)v.get(1990)).setAttribute("width","8" );
      ((Element)v.get(1990)).setAttribute("height","8" );
      ((Element)v.get(1989)).appendChild((Element)v.get(1990));
      /* Termina nodo:1990   */
      /* Termina nodo:1989   */

      /* Empieza nodo:1991 / Elemento padre: 1988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1988)).appendChild((Element)v.get(1991));

      /* Empieza nodo:1992 / Elemento padre: 1991   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1992)).setAttribute("nombre","lblCodigoControlDevolucionesAnulaciones" );
      ((Element)v.get(1992)).setAttribute("alto","13" );
      ((Element)v.get(1992)).setAttribute("filas","1" );
   }

   private void getXML7830(Document doc) {
      ((Element)v.get(1992)).setAttribute("valor","" );
      ((Element)v.get(1992)).setAttribute("id","datosTitle" );
      ((Element)v.get(1992)).setAttribute("cod","8" );
      ((Element)v.get(1991)).appendChild((Element)v.get(1992));
      /* Termina nodo:1992   */
      /* Termina nodo:1991   */

      /* Empieza nodo:1993 / Elemento padre: 1988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1988)).appendChild((Element)v.get(1993));

      /* Empieza nodo:1994 / Elemento padre: 1993   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1994)).setAttribute("src","b.gif" );
      ((Element)v.get(1994)).setAttribute("width","25" );
      ((Element)v.get(1994)).setAttribute("height","8" );
      ((Element)v.get(1993)).appendChild((Element)v.get(1994));
      /* Termina nodo:1994   */
      /* Termina nodo:1993   */

      /* Empieza nodo:1995 / Elemento padre: 1988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1988)).appendChild((Element)v.get(1995));

      /* Empieza nodo:1996 / Elemento padre: 1995   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1996)).setAttribute("nombre","lblVisibleControlDevolucionesAnulaciones" );
      ((Element)v.get(1996)).setAttribute("alto","13" );
      ((Element)v.get(1996)).setAttribute("filas","1" );
      ((Element)v.get(1996)).setAttribute("valor","" );
      ((Element)v.get(1996)).setAttribute("id","datosTitle" );
      ((Element)v.get(1996)).setAttribute("cod","1038" );
      ((Element)v.get(1995)).appendChild((Element)v.get(1996));
      /* Termina nodo:1996   */
      /* Termina nodo:1995   */

      /* Empieza nodo:1997 / Elemento padre: 1988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1988)).appendChild((Element)v.get(1997));

      /* Empieza nodo:1998 / Elemento padre: 1997   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1998)).setAttribute("src","b.gif" );
      ((Element)v.get(1998)).setAttribute("width","25" );
      ((Element)v.get(1998)).setAttribute("height","8" );
      ((Element)v.get(1997)).appendChild((Element)v.get(1998));
      /* Termina nodo:1998   */
      /* Termina nodo:1997   */

      /* Empieza nodo:1999 / Elemento padre: 1988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1988)).appendChild((Element)v.get(1999));

      /* Empieza nodo:2000 / Elemento padre: 1999   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2000)).setAttribute("nombre","lblObligatorioControlDevolucionesAnulaciones" );
      ((Element)v.get(2000)).setAttribute("alto","13" );
      ((Element)v.get(2000)).setAttribute("filas","1" );
      ((Element)v.get(2000)).setAttribute("valor","" );
      ((Element)v.get(2000)).setAttribute("id","datosTitle" );
      ((Element)v.get(2000)).setAttribute("cod","949" );
      ((Element)v.get(1999)).appendChild((Element)v.get(2000));
      /* Termina nodo:2000   */
      /* Termina nodo:1999   */

      /* Empieza nodo:2001 / Elemento padre: 1988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1988)).appendChild((Element)v.get(2001));

      /* Empieza nodo:2002 / Elemento padre: 2001   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2002)).setAttribute("src","b.gif" );
      ((Element)v.get(2002)).setAttribute("width","25" );
      ((Element)v.get(2002)).setAttribute("height","8" );
      ((Element)v.get(2001)).appendChild((Element)v.get(2002));
      /* Termina nodo:2002   */
      /* Termina nodo:2001   */

      /* Empieza nodo:2003 / Elemento padre: 1988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1988)).appendChild((Element)v.get(2003));

      /* Empieza nodo:2004 / Elemento padre: 2003   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2004)).setAttribute("nombre","lblModificableControlDevolucionesAnulaciones" );
      ((Element)v.get(2004)).setAttribute("alto","13" );
      ((Element)v.get(2004)).setAttribute("filas","1" );
      ((Element)v.get(2004)).setAttribute("valor","" );
      ((Element)v.get(2004)).setAttribute("id","datosTitle" );
      ((Element)v.get(2004)).setAttribute("cod","914" );
      ((Element)v.get(2003)).appendChild((Element)v.get(2004));
      /* Termina nodo:2004   */
      /* Termina nodo:2003   */

      /* Empieza nodo:2005 / Elemento padre: 1988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2005)).setAttribute("width","100%" );
      ((Element)v.get(1988)).appendChild((Element)v.get(2005));

      /* Empieza nodo:2006 / Elemento padre: 2005   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2006)).setAttribute("src","b.gif" );
      ((Element)v.get(2006)).setAttribute("width","8" );
      ((Element)v.get(2006)).setAttribute("height","8" );
      ((Element)v.get(2005)).appendChild((Element)v.get(2006));
      /* Termina nodo:2006   */
      /* Termina nodo:2005   */
      /* Termina nodo:1988   */

      /* Empieza nodo:2007 / Elemento padre: 1984   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1984)).appendChild((Element)v.get(2007));

      /* Empieza nodo:2008 / Elemento padre: 2007   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2007)).appendChild((Element)v.get(2008));

      /* Empieza nodo:2009 / Elemento padre: 2008   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2009)).setAttribute("src","b.gif" );
      ((Element)v.get(2009)).setAttribute("width","8" );
      ((Element)v.get(2009)).setAttribute("height","8" );
      ((Element)v.get(2008)).appendChild((Element)v.get(2009));
      /* Termina nodo:2009   */
      /* Termina nodo:2008   */

      /* Empieza nodo:2010 / Elemento padre: 2007   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2007)).appendChild((Element)v.get(2010));

      /* Empieza nodo:2011 / Elemento padre: 2010   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2011)).setAttribute("nombre","lbldtCodigoControlDevolucionesAnulaciones" );
      ((Element)v.get(2011)).setAttribute("alto","13" );
      ((Element)v.get(2011)).setAttribute("filas","1" );
      ((Element)v.get(2011)).setAttribute("valor","27" );
      ((Element)v.get(2011)).setAttribute("id","datosCampos" );
      ((Element)v.get(2010)).appendChild((Element)v.get(2011));
      /* Termina nodo:2011   */
      /* Termina nodo:2010   */

      /* Empieza nodo:2012 / Elemento padre: 2007   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2007)).appendChild((Element)v.get(2012));

      /* Empieza nodo:2013 / Elemento padre: 2012   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2013)).setAttribute("src","b.gif" );
      ((Element)v.get(2013)).setAttribute("width","25" );
      ((Element)v.get(2013)).setAttribute("height","8" );
      ((Element)v.get(2012)).appendChild((Element)v.get(2013));
      /* Termina nodo:2013   */
      /* Termina nodo:2012   */

      /* Empieza nodo:2014 / Elemento padre: 2007   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2007)).appendChild((Element)v.get(2014));

      /* Empieza nodo:2015 / Elemento padre: 2014   */
   }

   private void getXML7920(Document doc) {
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2015)).setAttribute("nombre","ckVisibleControlDevolucionesAnulaciones" );
      ((Element)v.get(2015)).setAttribute("id","datosCampos" );
      ((Element)v.get(2015)).setAttribute("onclick","cambiaObli(25)" );
      ((Element)v.get(2015)).setAttribute("check","S" );
      ((Element)v.get(2014)).appendChild((Element)v.get(2015));
      /* Termina nodo:2015   */
      /* Termina nodo:2014   */

      /* Empieza nodo:2016 / Elemento padre: 2007   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2007)).appendChild((Element)v.get(2016));

      /* Empieza nodo:2017 / Elemento padre: 2016   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2017)).setAttribute("src","b.gif" );
      ((Element)v.get(2017)).setAttribute("width","25" );
      ((Element)v.get(2017)).setAttribute("height","8" );
      ((Element)v.get(2016)).appendChild((Element)v.get(2017));
      /* Termina nodo:2017   */
      /* Termina nodo:2016   */

      /* Empieza nodo:2018 / Elemento padre: 2007   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2007)).appendChild((Element)v.get(2018));

      /* Empieza nodo:2019 / Elemento padre: 2018   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2019)).setAttribute("nombre","ckObligatorioControlDevolucionesAnulaciones" );
      ((Element)v.get(2019)).setAttribute("id","datosCampos" );
      ((Element)v.get(2019)).setAttribute("onclick","" );
      ((Element)v.get(2019)).setAttribute("check","N" );
      ((Element)v.get(2018)).appendChild((Element)v.get(2019));
      /* Termina nodo:2019   */
      /* Termina nodo:2018   */

      /* Empieza nodo:2020 / Elemento padre: 2007   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2007)).appendChild((Element)v.get(2020));

      /* Empieza nodo:2021 / Elemento padre: 2020   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2021)).setAttribute("src","b.gif" );
      ((Element)v.get(2021)).setAttribute("width","25" );
      ((Element)v.get(2021)).setAttribute("height","8" );
      ((Element)v.get(2020)).appendChild((Element)v.get(2021));
      /* Termina nodo:2021   */
      /* Termina nodo:2020   */

      /* Empieza nodo:2022 / Elemento padre: 2007   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2007)).appendChild((Element)v.get(2022));

      /* Empieza nodo:2023 / Elemento padre: 2022   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2023)).setAttribute("nombre","ckModificableControlDevolucionesAnulaciones" );
      ((Element)v.get(2023)).setAttribute("id","datosCampos" );
      ((Element)v.get(2023)).setAttribute("onclick","" );
      ((Element)v.get(2023)).setAttribute("check","S" );
      ((Element)v.get(2022)).appendChild((Element)v.get(2023));
      /* Termina nodo:2023   */
      /* Termina nodo:2022   */

      /* Empieza nodo:2024 / Elemento padre: 2007   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2024)).setAttribute("width","100%" );
      ((Element)v.get(2007)).appendChild((Element)v.get(2024));

      /* Empieza nodo:2025 / Elemento padre: 2024   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2025)).setAttribute("src","b.gif" );
      ((Element)v.get(2025)).setAttribute("width","8" );
      ((Element)v.get(2025)).setAttribute("height","8" );
      ((Element)v.get(2024)).appendChild((Element)v.get(2025));
      /* Termina nodo:2025   */
      /* Termina nodo:2024   */
      /* Termina nodo:2007   */

      /* Empieza nodo:2026 / Elemento padre: 1984   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1984)).appendChild((Element)v.get(2026));

      /* Empieza nodo:2027 / Elemento padre: 2026   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2027)).setAttribute("colspan","4" );
      ((Element)v.get(2026)).appendChild((Element)v.get(2027));

      /* Empieza nodo:2028 / Elemento padre: 2027   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2028)).setAttribute("src","b.gif" );
      ((Element)v.get(2028)).setAttribute("width","8" );
      ((Element)v.get(2028)).setAttribute("height","8" );
      ((Element)v.get(2027)).appendChild((Element)v.get(2028));
      /* Termina nodo:2028   */
      /* Termina nodo:2027   */
      /* Termina nodo:2026   */
      /* Termina nodo:1984   */

      /* Empieza nodo:2029 / Elemento padre: 1981   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2029)).setAttribute("width","100%" );
      ((Element)v.get(2029)).setAttribute("border","0" );
      ((Element)v.get(2029)).setAttribute("align","center" );
      ((Element)v.get(2029)).setAttribute("cellspacing","0" );
      ((Element)v.get(2029)).setAttribute("cellpadding","0" );
      ((Element)v.get(1981)).appendChild((Element)v.get(2029));

      /* Empieza nodo:2030 / Elemento padre: 2029   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2029)).appendChild((Element)v.get(2030));

      /* Empieza nodo:2031 / Elemento padre: 2030   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2030)).appendChild((Element)v.get(2031));

      /* Empieza nodo:2032 / Elemento padre: 2031   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2032)).setAttribute("src","b.gif" );
      ((Element)v.get(2032)).setAttribute("width","8" );
      ((Element)v.get(2032)).setAttribute("height","8" );
      ((Element)v.get(2031)).appendChild((Element)v.get(2032));
      /* Termina nodo:2032   */
      /* Termina nodo:2031   */

      /* Empieza nodo:2033 / Elemento padre: 2030   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2030)).appendChild((Element)v.get(2033));

      /* Empieza nodo:2034 / Elemento padre: 2033   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2034)).setAttribute("nombre","lblValoresPosiblesControlDevolucionesAnulaciones" );
      ((Element)v.get(2034)).setAttribute("alto","13" );
      ((Element)v.get(2034)).setAttribute("filas","1" );
      ((Element)v.get(2034)).setAttribute("valor","" );
      ((Element)v.get(2034)).setAttribute("id","datosTitle" );
      ((Element)v.get(2034)).setAttribute("cod","1022" );
      ((Element)v.get(2033)).appendChild((Element)v.get(2034));
      /* Termina nodo:2034   */
      /* Termina nodo:2033   */

      /* Empieza nodo:2035 / Elemento padre: 2030   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2030)).appendChild((Element)v.get(2035));

      /* Empieza nodo:2036 / Elemento padre: 2035   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2036)).setAttribute("src","b.gif" );
      ((Element)v.get(2036)).setAttribute("width","25" );
      ((Element)v.get(2036)).setAttribute("height","8" );
      ((Element)v.get(2035)).appendChild((Element)v.get(2036));
      /* Termina nodo:2036   */
      /* Termina nodo:2035   */

      /* Empieza nodo:2037 / Elemento padre: 2030   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2030)).appendChild((Element)v.get(2037));

      /* Empieza nodo:2038 / Elemento padre: 2037   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML8010(Document doc) {
      ((Element)v.get(2038)).setAttribute("nombre","lblValoresDefectoControlDevolucionesAnulaciones" );
      ((Element)v.get(2038)).setAttribute("alto","13" );
      ((Element)v.get(2038)).setAttribute("filas","1" );
      ((Element)v.get(2038)).setAttribute("valor","" );
      ((Element)v.get(2038)).setAttribute("id","datosTitle" );
      ((Element)v.get(2038)).setAttribute("cod","1286" );
      ((Element)v.get(2037)).appendChild((Element)v.get(2038));
      /* Termina nodo:2038   */
      /* Termina nodo:2037   */

      /* Empieza nodo:2039 / Elemento padre: 2030   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2039)).setAttribute("width","100%" );
      ((Element)v.get(2030)).appendChild((Element)v.get(2039));

      /* Empieza nodo:2040 / Elemento padre: 2039   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2040)).setAttribute("src","b.gif" );
      ((Element)v.get(2040)).setAttribute("width","8" );
      ((Element)v.get(2040)).setAttribute("height","8" );
      ((Element)v.get(2039)).appendChild((Element)v.get(2040));
      /* Termina nodo:2040   */
      /* Termina nodo:2039   */
      /* Termina nodo:2030   */

      /* Empieza nodo:2041 / Elemento padre: 2029   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2029)).appendChild((Element)v.get(2041));

      /* Empieza nodo:2042 / Elemento padre: 2041   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2041)).appendChild((Element)v.get(2042));

      /* Empieza nodo:2043 / Elemento padre: 2042   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2043)).setAttribute("src","b.gif" );
      ((Element)v.get(2043)).setAttribute("width","8" );
      ((Element)v.get(2043)).setAttribute("height","8" );
      ((Element)v.get(2042)).appendChild((Element)v.get(2043));
      /* Termina nodo:2043   */
      /* Termina nodo:2042   */

      /* Empieza nodo:2044 / Elemento padre: 2041   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2044)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2041)).appendChild((Element)v.get(2044));

      /* Empieza nodo:2045 / Elemento padre: 2044   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2045)).setAttribute("nombre","cbValoresPosiblesControlDevolucionesAnulaciones" );
      ((Element)v.get(2045)).setAttribute("onchange","controlDAOnChange();" );
      ((Element)v.get(2045)).setAttribute("id","datosCampos" );
      ((Element)v.get(2045)).setAttribute("size","3" );
      ((Element)v.get(2045)).setAttribute("multiple","S" );
      ((Element)v.get(2045)).setAttribute("req","S" );
      ((Element)v.get(2045)).setAttribute("valorinicial","" );
      ((Element)v.get(2045)).setAttribute("textoinicial","" );
      ((Element)v.get(2044)).appendChild((Element)v.get(2045));

      /* Empieza nodo:2046 / Elemento padre: 2045   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2045)).appendChild((Element)v.get(2046));

      /* Empieza nodo:2047 / Elemento padre: 2046   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2047)).setAttribute("ID","1" );
      ((Element)v.get(2046)).appendChild((Element)v.get(2047));

      /* Empieza nodo:2048 / Elemento padre: 2047   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2048)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2048)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2048)).setAttribute("VALOR","1" );
      ((Element)v.get(2047)).appendChild((Element)v.get(2048));
      /* Termina nodo:2048   */

      /* Empieza nodo:2049 / Elemento padre: 2047   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2049)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2049)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2049)).setAttribute("VALOR","Si" );
      ((Element)v.get(2047)).appendChild((Element)v.get(2049));
      /* Termina nodo:2049   */
      /* Termina nodo:2047   */

      /* Empieza nodo:2050 / Elemento padre: 2046   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2050)).setAttribute("ID","2" );
      ((Element)v.get(2046)).appendChild((Element)v.get(2050));

      /* Empieza nodo:2051 / Elemento padre: 2050   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2051)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2051)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2051)).setAttribute("VALOR","0" );
      ((Element)v.get(2050)).appendChild((Element)v.get(2051));
      /* Termina nodo:2051   */

      /* Empieza nodo:2052 / Elemento padre: 2050   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2052)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2052)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2052)).setAttribute("VALOR","No" );
      ((Element)v.get(2050)).appendChild((Element)v.get(2052));
      /* Termina nodo:2052   */
      /* Termina nodo:2050   */
      /* Termina nodo:2046   */
      /* Termina nodo:2045   */
      /* Termina nodo:2044   */

      /* Empieza nodo:2053 / Elemento padre: 2041   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2041)).appendChild((Element)v.get(2053));

      /* Empieza nodo:2054 / Elemento padre: 2053   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2054)).setAttribute("src","b.gif" );
      ((Element)v.get(2054)).setAttribute("width","25" );
      ((Element)v.get(2054)).setAttribute("height","8" );
      ((Element)v.get(2053)).appendChild((Element)v.get(2054));
      /* Termina nodo:2054   */
      /* Termina nodo:2053   */

      /* Empieza nodo:2055 / Elemento padre: 2041   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2055)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2055)).setAttribute("valign","top" );
      ((Element)v.get(2041)).appendChild((Element)v.get(2055));

      /* Empieza nodo:2056 / Elemento padre: 2055   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2056)).setAttribute("nombre","cbValoresDefectoControlDevolucionesAnulaciones" );
      ((Element)v.get(2056)).setAttribute("id","datosCampos" );
      ((Element)v.get(2056)).setAttribute("size","1" );
      ((Element)v.get(2056)).setAttribute("multiple","N" );
      ((Element)v.get(2056)).setAttribute("req","N" );
      ((Element)v.get(2056)).setAttribute("valorinicial","" );
      ((Element)v.get(2056)).setAttribute("textoinicial","" );
      ((Element)v.get(2055)).appendChild((Element)v.get(2056));

      /* Empieza nodo:2057 / Elemento padre: 2056   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2056)).appendChild((Element)v.get(2057));
      /* Termina nodo:2057   */
      /* Termina nodo:2056   */
      /* Termina nodo:2055   */

      /* Empieza nodo:2058 / Elemento padre: 2041   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2058)).setAttribute("width","100%" );
      ((Element)v.get(2041)).appendChild((Element)v.get(2058));

      /* Empieza nodo:2059 / Elemento padre: 2058   */
   }

   private void getXML8100(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2059)).setAttribute("src","b.gif" );
      ((Element)v.get(2059)).setAttribute("width","8" );
      ((Element)v.get(2059)).setAttribute("height","8" );
      ((Element)v.get(2058)).appendChild((Element)v.get(2059));
      /* Termina nodo:2059   */
      /* Termina nodo:2058   */
      /* Termina nodo:2041   */

      /* Empieza nodo:2060 / Elemento padre: 2029   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2029)).appendChild((Element)v.get(2060));

      /* Empieza nodo:2061 / Elemento padre: 2060   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2061)).setAttribute("colspan","4" );
      ((Element)v.get(2060)).appendChild((Element)v.get(2061));

      /* Empieza nodo:2062 / Elemento padre: 2061   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2062)).setAttribute("src","b.gif" );
      ((Element)v.get(2062)).setAttribute("width","8" );
      ((Element)v.get(2062)).setAttribute("height","8" );
      ((Element)v.get(2061)).appendChild((Element)v.get(2062));
      /* Termina nodo:2062   */
      /* Termina nodo:2061   */
      /* Termina nodo:2060   */
      /* Termina nodo:2029   */
      /* Termina nodo:1981   */
      /* Termina nodo:1980   */

      /* Empieza nodo:2063 / Elemento padre: 1977   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1977)).appendChild((Element)v.get(2063));

      /* Empieza nodo:2064 / Elemento padre: 2063   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2064)).setAttribute("src","b.gif" );
      ((Element)v.get(2063)).appendChild((Element)v.get(2064));
      /* Termina nodo:2064   */
      /* Termina nodo:2063   */
      /* Termina nodo:1977   */

      /* Empieza nodo:2065 / Elemento padre: 1976   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1976)).appendChild((Element)v.get(2065));

      /* Empieza nodo:2066 / Elemento padre: 2065   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2066)).setAttribute("width","12" );
      ((Element)v.get(2066)).setAttribute("align","center" );
      ((Element)v.get(2065)).appendChild((Element)v.get(2066));

      /* Empieza nodo:2067 / Elemento padre: 2066   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2067)).setAttribute("src","b.gif" );
      ((Element)v.get(2067)).setAttribute("width","12" );
      ((Element)v.get(2067)).setAttribute("height","15" );
      ((Element)v.get(2066)).appendChild((Element)v.get(2067));
      /* Termina nodo:2067   */
      /* Termina nodo:2066   */

      /* Empieza nodo:2068 / Elemento padre: 2065   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2068)).setAttribute("width","756" );
      ((Element)v.get(2065)).appendChild((Element)v.get(2068));

      /* Empieza nodo:2069 / Elemento padre: 2068   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2069)).setAttribute("src","b.gif" );
      ((Element)v.get(2068)).appendChild((Element)v.get(2069));
      /* Termina nodo:2069   */
      /* Termina nodo:2068   */

      /* Empieza nodo:2070 / Elemento padre: 2065   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2070)).setAttribute("width","12" );
      ((Element)v.get(2065)).appendChild((Element)v.get(2070));

      /* Empieza nodo:2071 / Elemento padre: 2070   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2071)).setAttribute("src","b.gif" );
      ((Element)v.get(2071)).setAttribute("width","12" );
      ((Element)v.get(2071)).setAttribute("height","1" );
      ((Element)v.get(2070)).appendChild((Element)v.get(2071));
      /* Termina nodo:2071   */
      /* Termina nodo:2070   */
      /* Termina nodo:2065   */
      /* Termina nodo:1976   */

      /* Empieza nodo:2072 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2072)).setAttribute("width","100%" );
      ((Element)v.get(2072)).setAttribute("border","0" );
      ((Element)v.get(2072)).setAttribute("align","center" );
      ((Element)v.get(2072)).setAttribute("cellspacing","0" );
      ((Element)v.get(2072)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(2072));

      /* Empieza nodo:2073 / Elemento padre: 2072   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2072)).appendChild((Element)v.get(2073));

      /* Empieza nodo:2074 / Elemento padre: 2073   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2073)).appendChild((Element)v.get(2074));

      /* Empieza nodo:2075 / Elemento padre: 2074   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2075)).setAttribute("src","b.gif" );
      ((Element)v.get(2075)).setAttribute("width","8" );
      ((Element)v.get(2075)).setAttribute("height","8" );
      ((Element)v.get(2074)).appendChild((Element)v.get(2075));
      /* Termina nodo:2075   */
      /* Termina nodo:2074   */

      /* Empieza nodo:2076 / Elemento padre: 2073   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2076)).setAttribute("width","100%" );
      ((Element)v.get(2073)).appendChild((Element)v.get(2076));

      /* Empieza nodo:2077 / Elemento padre: 2076   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(2076)).appendChild((Element)v.get(2077));

      /* Empieza nodo:2078 / Elemento padre: 2077   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(2078)).setAttribute("class","legend" );
      ((Element)v.get(2077)).appendChild((Element)v.get(2078));

      /* Empieza nodo:2079 / Elemento padre: 2078   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2079)).setAttribute("nombre","lblControlDescuentoAcumulativo" );
      ((Element)v.get(2079)).setAttribute("alto","13" );
      ((Element)v.get(2079)).setAttribute("filas","1" );
      ((Element)v.get(2079)).setAttribute("valor","" );
      ((Element)v.get(2079)).setAttribute("id","legend" );
      ((Element)v.get(2079)).setAttribute("cod","00465" );
      ((Element)v.get(2078)).appendChild((Element)v.get(2079));
      /* Termina nodo:2079   */
      /* Termina nodo:2078   */

      /* Empieza nodo:2080 / Elemento padre: 2077   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2080)).setAttribute("width","100%" );
      ((Element)v.get(2080)).setAttribute("border","0" );
      ((Element)v.get(2080)).setAttribute("align","center" );
      ((Element)v.get(2080)).setAttribute("cellspacing","0" );
      ((Element)v.get(2080)).setAttribute("cellpadding","0" );
      ((Element)v.get(2077)).appendChild((Element)v.get(2080));

      /* Empieza nodo:2081 / Elemento padre: 2080   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2080)).appendChild((Element)v.get(2081));

      /* Empieza nodo:2082 / Elemento padre: 2081   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2082)).setAttribute("colspan","3" );
      ((Element)v.get(2081)).appendChild((Element)v.get(2082));

      /* Empieza nodo:2083 / Elemento padre: 2082   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML8190(Document doc) {
      ((Element)v.get(2083)).setAttribute("src","b.gif" );
      ((Element)v.get(2083)).setAttribute("width","8" );
      ((Element)v.get(2083)).setAttribute("height","8" );
      ((Element)v.get(2082)).appendChild((Element)v.get(2083));
      /* Termina nodo:2083   */
      /* Termina nodo:2082   */
      /* Termina nodo:2081   */

      /* Empieza nodo:2084 / Elemento padre: 2080   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2080)).appendChild((Element)v.get(2084));

      /* Empieza nodo:2085 / Elemento padre: 2084   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2084)).appendChild((Element)v.get(2085));

      /* Empieza nodo:2086 / Elemento padre: 2085   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2086)).setAttribute("src","b.gif" );
      ((Element)v.get(2086)).setAttribute("width","8" );
      ((Element)v.get(2086)).setAttribute("height","8" );
      ((Element)v.get(2085)).appendChild((Element)v.get(2086));
      /* Termina nodo:2086   */
      /* Termina nodo:2085   */

      /* Empieza nodo:2087 / Elemento padre: 2084   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2084)).appendChild((Element)v.get(2087));

      /* Empieza nodo:2088 / Elemento padre: 2087   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2088)).setAttribute("nombre","lblCodigoControlDescuentoAcumulativo" );
      ((Element)v.get(2088)).setAttribute("alto","13" );
      ((Element)v.get(2088)).setAttribute("filas","1" );
      ((Element)v.get(2088)).setAttribute("valor","" );
      ((Element)v.get(2088)).setAttribute("id","datosTitle" );
      ((Element)v.get(2088)).setAttribute("cod","8" );
      ((Element)v.get(2087)).appendChild((Element)v.get(2088));
      /* Termina nodo:2088   */
      /* Termina nodo:2087   */

      /* Empieza nodo:2089 / Elemento padre: 2084   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2084)).appendChild((Element)v.get(2089));

      /* Empieza nodo:2090 / Elemento padre: 2089   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2090)).setAttribute("src","b.gif" );
      ((Element)v.get(2090)).setAttribute("width","25" );
      ((Element)v.get(2090)).setAttribute("height","8" );
      ((Element)v.get(2089)).appendChild((Element)v.get(2090));
      /* Termina nodo:2090   */
      /* Termina nodo:2089   */

      /* Empieza nodo:2091 / Elemento padre: 2084   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2084)).appendChild((Element)v.get(2091));

      /* Empieza nodo:2092 / Elemento padre: 2091   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2092)).setAttribute("nombre","lblVisibleControlDescuentoAcumulativo" );
      ((Element)v.get(2092)).setAttribute("alto","13" );
      ((Element)v.get(2092)).setAttribute("filas","1" );
      ((Element)v.get(2092)).setAttribute("valor","" );
      ((Element)v.get(2092)).setAttribute("id","datosTitle" );
      ((Element)v.get(2092)).setAttribute("cod","1038" );
      ((Element)v.get(2091)).appendChild((Element)v.get(2092));
      /* Termina nodo:2092   */
      /* Termina nodo:2091   */

      /* Empieza nodo:2093 / Elemento padre: 2084   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2084)).appendChild((Element)v.get(2093));

      /* Empieza nodo:2094 / Elemento padre: 2093   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2094)).setAttribute("src","b.gif" );
      ((Element)v.get(2094)).setAttribute("width","25" );
      ((Element)v.get(2094)).setAttribute("height","8" );
      ((Element)v.get(2093)).appendChild((Element)v.get(2094));
      /* Termina nodo:2094   */
      /* Termina nodo:2093   */

      /* Empieza nodo:2095 / Elemento padre: 2084   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2084)).appendChild((Element)v.get(2095));

      /* Empieza nodo:2096 / Elemento padre: 2095   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2096)).setAttribute("nombre","lblObligatorioControlDescuentoAcumulativo" );
      ((Element)v.get(2096)).setAttribute("alto","13" );
      ((Element)v.get(2096)).setAttribute("filas","1" );
      ((Element)v.get(2096)).setAttribute("valor","" );
      ((Element)v.get(2096)).setAttribute("id","datosTitle" );
      ((Element)v.get(2096)).setAttribute("cod","949" );
      ((Element)v.get(2095)).appendChild((Element)v.get(2096));
      /* Termina nodo:2096   */
      /* Termina nodo:2095   */

      /* Empieza nodo:2097 / Elemento padre: 2084   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2084)).appendChild((Element)v.get(2097));

      /* Empieza nodo:2098 / Elemento padre: 2097   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2098)).setAttribute("src","b.gif" );
      ((Element)v.get(2098)).setAttribute("width","25" );
      ((Element)v.get(2098)).setAttribute("height","8" );
      ((Element)v.get(2097)).appendChild((Element)v.get(2098));
      /* Termina nodo:2098   */
      /* Termina nodo:2097   */

      /* Empieza nodo:2099 / Elemento padre: 2084   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2084)).appendChild((Element)v.get(2099));

      /* Empieza nodo:2100 / Elemento padre: 2099   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2100)).setAttribute("nombre","lblModificableControlDescuentoAcumulativo" );
      ((Element)v.get(2100)).setAttribute("alto","13" );
      ((Element)v.get(2100)).setAttribute("filas","1" );
      ((Element)v.get(2100)).setAttribute("valor","" );
      ((Element)v.get(2100)).setAttribute("id","datosTitle" );
      ((Element)v.get(2100)).setAttribute("cod","914" );
      ((Element)v.get(2099)).appendChild((Element)v.get(2100));
      /* Termina nodo:2100   */
      /* Termina nodo:2099   */

      /* Empieza nodo:2101 / Elemento padre: 2084   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2101)).setAttribute("width","100%" );
      ((Element)v.get(2084)).appendChild((Element)v.get(2101));

      /* Empieza nodo:2102 / Elemento padre: 2101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2102)).setAttribute("src","b.gif" );
      ((Element)v.get(2102)).setAttribute("width","8" );
      ((Element)v.get(2102)).setAttribute("height","8" );
      ((Element)v.get(2101)).appendChild((Element)v.get(2102));
      /* Termina nodo:2102   */
      /* Termina nodo:2101   */
      /* Termina nodo:2084   */

      /* Empieza nodo:2103 / Elemento padre: 2080   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2080)).appendChild((Element)v.get(2103));

      /* Empieza nodo:2104 / Elemento padre: 2103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2103)).appendChild((Element)v.get(2104));

      /* Empieza nodo:2105 / Elemento padre: 2104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2105)).setAttribute("src","b.gif" );
      ((Element)v.get(2105)).setAttribute("width","8" );
      ((Element)v.get(2105)).setAttribute("height","8" );
   }

   private void getXML8280(Document doc) {
      ((Element)v.get(2104)).appendChild((Element)v.get(2105));
      /* Termina nodo:2105   */
      /* Termina nodo:2104   */

      /* Empieza nodo:2106 / Elemento padre: 2103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2103)).appendChild((Element)v.get(2106));

      /* Empieza nodo:2107 / Elemento padre: 2106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2107)).setAttribute("nombre","lbldtCodigoControlDescuentoAcumulativo" );
      ((Element)v.get(2107)).setAttribute("alto","13" );
      ((Element)v.get(2107)).setAttribute("filas","1" );
      ((Element)v.get(2107)).setAttribute("valor","28" );
      ((Element)v.get(2107)).setAttribute("id","datosCampos" );
      ((Element)v.get(2106)).appendChild((Element)v.get(2107));
      /* Termina nodo:2107   */
      /* Termina nodo:2106   */

      /* Empieza nodo:2108 / Elemento padre: 2103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2103)).appendChild((Element)v.get(2108));

      /* Empieza nodo:2109 / Elemento padre: 2108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2109)).setAttribute("src","b.gif" );
      ((Element)v.get(2109)).setAttribute("width","25" );
      ((Element)v.get(2109)).setAttribute("height","8" );
      ((Element)v.get(2108)).appendChild((Element)v.get(2109));
      /* Termina nodo:2109   */
      /* Termina nodo:2108   */

      /* Empieza nodo:2110 / Elemento padre: 2103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2103)).appendChild((Element)v.get(2110));

      /* Empieza nodo:2111 / Elemento padre: 2110   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2111)).setAttribute("nombre","ckVisibleControlDescuentoAcumulativo" );
      ((Element)v.get(2111)).setAttribute("id","datosCampos" );
      ((Element)v.get(2111)).setAttribute("onclick","cambiaObli(26)" );
      ((Element)v.get(2111)).setAttribute("check","S" );
      ((Element)v.get(2110)).appendChild((Element)v.get(2111));
      /* Termina nodo:2111   */
      /* Termina nodo:2110   */

      /* Empieza nodo:2112 / Elemento padre: 2103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2103)).appendChild((Element)v.get(2112));

      /* Empieza nodo:2113 / Elemento padre: 2112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2113)).setAttribute("src","b.gif" );
      ((Element)v.get(2113)).setAttribute("width","25" );
      ((Element)v.get(2113)).setAttribute("height","8" );
      ((Element)v.get(2112)).appendChild((Element)v.get(2113));
      /* Termina nodo:2113   */
      /* Termina nodo:2112   */

      /* Empieza nodo:2114 / Elemento padre: 2103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2103)).appendChild((Element)v.get(2114));

      /* Empieza nodo:2115 / Elemento padre: 2114   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2115)).setAttribute("nombre","ckObligatorioControlDescuentoAcumulativo" );
      ((Element)v.get(2115)).setAttribute("id","datosCampos" );
      ((Element)v.get(2115)).setAttribute("onclick","" );
      ((Element)v.get(2115)).setAttribute("check","N" );
      ((Element)v.get(2114)).appendChild((Element)v.get(2115));
      /* Termina nodo:2115   */
      /* Termina nodo:2114   */

      /* Empieza nodo:2116 / Elemento padre: 2103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2103)).appendChild((Element)v.get(2116));

      /* Empieza nodo:2117 / Elemento padre: 2116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2117)).setAttribute("src","b.gif" );
      ((Element)v.get(2117)).setAttribute("width","25" );
      ((Element)v.get(2117)).setAttribute("height","8" );
      ((Element)v.get(2116)).appendChild((Element)v.get(2117));
      /* Termina nodo:2117   */
      /* Termina nodo:2116   */

      /* Empieza nodo:2118 / Elemento padre: 2103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2103)).appendChild((Element)v.get(2118));

      /* Empieza nodo:2119 / Elemento padre: 2118   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2119)).setAttribute("nombre","ckModificableControlDescuentoAcumulativo" );
      ((Element)v.get(2119)).setAttribute("id","datosCampos" );
      ((Element)v.get(2119)).setAttribute("onclick","" );
      ((Element)v.get(2119)).setAttribute("check","S" );
      ((Element)v.get(2118)).appendChild((Element)v.get(2119));
      /* Termina nodo:2119   */
      /* Termina nodo:2118   */

      /* Empieza nodo:2120 / Elemento padre: 2103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2120)).setAttribute("width","100%" );
      ((Element)v.get(2103)).appendChild((Element)v.get(2120));

      /* Empieza nodo:2121 / Elemento padre: 2120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2121)).setAttribute("src","b.gif" );
      ((Element)v.get(2121)).setAttribute("width","8" );
      ((Element)v.get(2121)).setAttribute("height","8" );
      ((Element)v.get(2120)).appendChild((Element)v.get(2121));
      /* Termina nodo:2121   */
      /* Termina nodo:2120   */
      /* Termina nodo:2103   */

      /* Empieza nodo:2122 / Elemento padre: 2080   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2080)).appendChild((Element)v.get(2122));

      /* Empieza nodo:2123 / Elemento padre: 2122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2123)).setAttribute("colspan","4" );
      ((Element)v.get(2122)).appendChild((Element)v.get(2123));

      /* Empieza nodo:2124 / Elemento padre: 2123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2124)).setAttribute("src","b.gif" );
      ((Element)v.get(2124)).setAttribute("width","8" );
      ((Element)v.get(2124)).setAttribute("height","8" );
      ((Element)v.get(2123)).appendChild((Element)v.get(2124));
      /* Termina nodo:2124   */
      /* Termina nodo:2123   */
      /* Termina nodo:2122   */
      /* Termina nodo:2080   */

      /* Empieza nodo:2125 / Elemento padre: 2077   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2125)).setAttribute("width","100%" );
      ((Element)v.get(2125)).setAttribute("border","0" );
      ((Element)v.get(2125)).setAttribute("align","center" );
      ((Element)v.get(2125)).setAttribute("cellspacing","0" );
      ((Element)v.get(2125)).setAttribute("cellpadding","0" );
      ((Element)v.get(2077)).appendChild((Element)v.get(2125));

      /* Empieza nodo:2126 / Elemento padre: 2125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2125)).appendChild((Element)v.get(2126));

      /* Empieza nodo:2127 / Elemento padre: 2126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2126)).appendChild((Element)v.get(2127));

      /* Empieza nodo:2128 / Elemento padre: 2127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2128)).setAttribute("src","b.gif" );
      ((Element)v.get(2128)).setAttribute("width","8" );
      ((Element)v.get(2128)).setAttribute("height","8" );
      ((Element)v.get(2127)).appendChild((Element)v.get(2128));
      /* Termina nodo:2128   */
      /* Termina nodo:2127   */

      /* Empieza nodo:2129 / Elemento padre: 2126   */
      v.add(doc.createElement("td"));
   }

   private void getXML8370(Document doc) {
      ((Element)v.get(2126)).appendChild((Element)v.get(2129));

      /* Empieza nodo:2130 / Elemento padre: 2129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2130)).setAttribute("nombre","lblValoresPosiblesControlDescuentoAcumulativo" );
      ((Element)v.get(2130)).setAttribute("alto","13" );
      ((Element)v.get(2130)).setAttribute("filas","1" );
      ((Element)v.get(2130)).setAttribute("valor","" );
      ((Element)v.get(2130)).setAttribute("id","datosTitle" );
      ((Element)v.get(2130)).setAttribute("cod","1022" );
      ((Element)v.get(2129)).appendChild((Element)v.get(2130));
      /* Termina nodo:2130   */
      /* Termina nodo:2129   */

      /* Empieza nodo:2131 / Elemento padre: 2126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2126)).appendChild((Element)v.get(2131));

      /* Empieza nodo:2132 / Elemento padre: 2131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2132)).setAttribute("src","b.gif" );
      ((Element)v.get(2132)).setAttribute("width","25" );
      ((Element)v.get(2132)).setAttribute("height","8" );
      ((Element)v.get(2131)).appendChild((Element)v.get(2132));
      /* Termina nodo:2132   */
      /* Termina nodo:2131   */

      /* Empieza nodo:2133 / Elemento padre: 2126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2126)).appendChild((Element)v.get(2133));

      /* Empieza nodo:2134 / Elemento padre: 2133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2134)).setAttribute("nombre","lblValoresDefectoControlDescuentoAcumulativo" );
      ((Element)v.get(2134)).setAttribute("alto","13" );
      ((Element)v.get(2134)).setAttribute("filas","1" );
      ((Element)v.get(2134)).setAttribute("valor","" );
      ((Element)v.get(2134)).setAttribute("id","datosTitle" );
      ((Element)v.get(2134)).setAttribute("cod","1286" );
      ((Element)v.get(2133)).appendChild((Element)v.get(2134));
      /* Termina nodo:2134   */
      /* Termina nodo:2133   */

      /* Empieza nodo:2135 / Elemento padre: 2126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2135)).setAttribute("width","100%" );
      ((Element)v.get(2126)).appendChild((Element)v.get(2135));

      /* Empieza nodo:2136 / Elemento padre: 2135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2136)).setAttribute("src","b.gif" );
      ((Element)v.get(2136)).setAttribute("width","8" );
      ((Element)v.get(2136)).setAttribute("height","8" );
      ((Element)v.get(2135)).appendChild((Element)v.get(2136));
      /* Termina nodo:2136   */
      /* Termina nodo:2135   */
      /* Termina nodo:2126   */

      /* Empieza nodo:2137 / Elemento padre: 2125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2125)).appendChild((Element)v.get(2137));

      /* Empieza nodo:2138 / Elemento padre: 2137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2137)).appendChild((Element)v.get(2138));

      /* Empieza nodo:2139 / Elemento padre: 2138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2139)).setAttribute("src","b.gif" );
      ((Element)v.get(2139)).setAttribute("width","8" );
      ((Element)v.get(2139)).setAttribute("height","8" );
      ((Element)v.get(2138)).appendChild((Element)v.get(2139));
      /* Termina nodo:2139   */
      /* Termina nodo:2138   */

      /* Empieza nodo:2140 / Elemento padre: 2137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2137)).appendChild((Element)v.get(2140));

      /* Empieza nodo:2141 / Elemento padre: 2140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2141)).setAttribute("nombre","cbValoresPosiblesControlDescuentoAcumulativo" );
      ((Element)v.get(2141)).setAttribute("onchange","controlDescOnChange();" );
      ((Element)v.get(2141)).setAttribute("id","datosCampos" );
      ((Element)v.get(2141)).setAttribute("size","3" );
      ((Element)v.get(2141)).setAttribute("multiple","S" );
      ((Element)v.get(2141)).setAttribute("req","S" );
      ((Element)v.get(2141)).setAttribute("valorinicial","" );
      ((Element)v.get(2141)).setAttribute("textoinicial","" );
      ((Element)v.get(2140)).appendChild((Element)v.get(2141));

      /* Empieza nodo:2142 / Elemento padre: 2141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2141)).appendChild((Element)v.get(2142));

      /* Empieza nodo:2143 / Elemento padre: 2142   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2143)).setAttribute("ID","1" );
      ((Element)v.get(2142)).appendChild((Element)v.get(2143));

      /* Empieza nodo:2144 / Elemento padre: 2143   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2144)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2144)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2144)).setAttribute("VALOR","1" );
      ((Element)v.get(2143)).appendChild((Element)v.get(2144));
      /* Termina nodo:2144   */

      /* Empieza nodo:2145 / Elemento padre: 2143   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2145)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2145)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2145)).setAttribute("VALOR","Si" );
      ((Element)v.get(2143)).appendChild((Element)v.get(2145));
      /* Termina nodo:2145   */
      /* Termina nodo:2143   */

      /* Empieza nodo:2146 / Elemento padre: 2142   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2146)).setAttribute("ID","2" );
      ((Element)v.get(2142)).appendChild((Element)v.get(2146));

      /* Empieza nodo:2147 / Elemento padre: 2146   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2147)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2147)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2147)).setAttribute("VALOR","0" );
      ((Element)v.get(2146)).appendChild((Element)v.get(2147));
      /* Termina nodo:2147   */

      /* Empieza nodo:2148 / Elemento padre: 2146   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2148)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2148)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2148)).setAttribute("VALOR","No" );
      ((Element)v.get(2146)).appendChild((Element)v.get(2148));
      /* Termina nodo:2148   */
      /* Termina nodo:2146   */
      /* Termina nodo:2142   */
      /* Termina nodo:2141   */
      /* Termina nodo:2140   */

      /* Empieza nodo:2149 / Elemento padre: 2137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2137)).appendChild((Element)v.get(2149));

      /* Empieza nodo:2150 / Elemento padre: 2149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2150)).setAttribute("src","b.gif" );
      ((Element)v.get(2150)).setAttribute("width","25" );
      ((Element)v.get(2150)).setAttribute("height","8" );
   }

   private void getXML8460(Document doc) {
      ((Element)v.get(2149)).appendChild((Element)v.get(2150));
      /* Termina nodo:2150   */
      /* Termina nodo:2149   */

      /* Empieza nodo:2151 / Elemento padre: 2137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2151)).setAttribute("valign","top" );
      ((Element)v.get(2137)).appendChild((Element)v.get(2151));

      /* Empieza nodo:2152 / Elemento padre: 2151   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2152)).setAttribute("nombre","cbValoresDefectoControlDescuentoAcumulativo" );
      ((Element)v.get(2152)).setAttribute("id","datosCampos" );
      ((Element)v.get(2152)).setAttribute("size","1" );
      ((Element)v.get(2152)).setAttribute("multiple","N" );
      ((Element)v.get(2152)).setAttribute("req","N" );
      ((Element)v.get(2152)).setAttribute("valorinicial","" );
      ((Element)v.get(2152)).setAttribute("textoinicial","" );
      ((Element)v.get(2151)).appendChild((Element)v.get(2152));

      /* Empieza nodo:2153 / Elemento padre: 2152   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2152)).appendChild((Element)v.get(2153));
      /* Termina nodo:2153   */
      /* Termina nodo:2152   */
      /* Termina nodo:2151   */

      /* Empieza nodo:2154 / Elemento padre: 2137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2154)).setAttribute("width","100%" );
      ((Element)v.get(2137)).appendChild((Element)v.get(2154));

      /* Empieza nodo:2155 / Elemento padre: 2154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2155)).setAttribute("src","b.gif" );
      ((Element)v.get(2155)).setAttribute("width","8" );
      ((Element)v.get(2155)).setAttribute("height","8" );
      ((Element)v.get(2154)).appendChild((Element)v.get(2155));
      /* Termina nodo:2155   */
      /* Termina nodo:2154   */
      /* Termina nodo:2137   */

      /* Empieza nodo:2156 / Elemento padre: 2125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2125)).appendChild((Element)v.get(2156));

      /* Empieza nodo:2157 / Elemento padre: 2156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2157)).setAttribute("colspan","4" );
      ((Element)v.get(2156)).appendChild((Element)v.get(2157));

      /* Empieza nodo:2158 / Elemento padre: 2157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2158)).setAttribute("src","b.gif" );
      ((Element)v.get(2158)).setAttribute("width","8" );
      ((Element)v.get(2158)).setAttribute("height","8" );
      ((Element)v.get(2157)).appendChild((Element)v.get(2158));
      /* Termina nodo:2158   */
      /* Termina nodo:2157   */
      /* Termina nodo:2156   */
      /* Termina nodo:2125   */
      /* Termina nodo:2077   */
      /* Termina nodo:2076   */

      /* Empieza nodo:2159 / Elemento padre: 2073   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2073)).appendChild((Element)v.get(2159));

      /* Empieza nodo:2160 / Elemento padre: 2159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2160)).setAttribute("src","b.gif" );
      ((Element)v.get(2159)).appendChild((Element)v.get(2160));
      /* Termina nodo:2160   */
      /* Termina nodo:2159   */
      /* Termina nodo:2073   */

      /* Empieza nodo:2161 / Elemento padre: 2072   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2072)).appendChild((Element)v.get(2161));

      /* Empieza nodo:2162 / Elemento padre: 2161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2162)).setAttribute("width","12" );
      ((Element)v.get(2162)).setAttribute("align","center" );
      ((Element)v.get(2161)).appendChild((Element)v.get(2162));

      /* Empieza nodo:2163 / Elemento padre: 2162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2163)).setAttribute("src","b.gif" );
      ((Element)v.get(2163)).setAttribute("width","12" );
      ((Element)v.get(2163)).setAttribute("height","15" );
      ((Element)v.get(2162)).appendChild((Element)v.get(2163));
      /* Termina nodo:2163   */
      /* Termina nodo:2162   */

      /* Empieza nodo:2164 / Elemento padre: 2161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2164)).setAttribute("width","756" );
      ((Element)v.get(2161)).appendChild((Element)v.get(2164));

      /* Empieza nodo:2165 / Elemento padre: 2164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2165)).setAttribute("src","b.gif" );
      ((Element)v.get(2164)).appendChild((Element)v.get(2165));
      /* Termina nodo:2165   */
      /* Termina nodo:2164   */

      /* Empieza nodo:2166 / Elemento padre: 2161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2166)).setAttribute("width","12" );
      ((Element)v.get(2161)).appendChild((Element)v.get(2166));

      /* Empieza nodo:2167 / Elemento padre: 2166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2167)).setAttribute("src","b.gif" );
      ((Element)v.get(2167)).setAttribute("width","12" );
      ((Element)v.get(2167)).setAttribute("height","1" );
      ((Element)v.get(2166)).appendChild((Element)v.get(2167));
      /* Termina nodo:2167   */
      /* Termina nodo:2166   */
      /* Termina nodo:2161   */
      /* Termina nodo:2072   */

      /* Empieza nodo:2168 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2168)).setAttribute("width","100%" );
      ((Element)v.get(2168)).setAttribute("border","0" );
      ((Element)v.get(2168)).setAttribute("align","center" );
      ((Element)v.get(2168)).setAttribute("cellspacing","0" );
      ((Element)v.get(2168)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(2168));

      /* Empieza nodo:2169 / Elemento padre: 2168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2168)).appendChild((Element)v.get(2169));

      /* Empieza nodo:2170 / Elemento padre: 2169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2169)).appendChild((Element)v.get(2170));

      /* Empieza nodo:2171 / Elemento padre: 2170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2171)).setAttribute("src","b.gif" );
      ((Element)v.get(2171)).setAttribute("width","8" );
      ((Element)v.get(2171)).setAttribute("height","8" );
      ((Element)v.get(2170)).appendChild((Element)v.get(2171));
      /* Termina nodo:2171   */
      /* Termina nodo:2170   */

      /* Empieza nodo:2172 / Elemento padre: 2169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2172)).setAttribute("width","100%" );
      ((Element)v.get(2169)).appendChild((Element)v.get(2172));

      /* Empieza nodo:2173 / Elemento padre: 2172   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(2172)).appendChild((Element)v.get(2173));

      /* Empieza nodo:2174 / Elemento padre: 2173   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(2174)).setAttribute("class","legend" );
      ((Element)v.get(2173)).appendChild((Element)v.get(2174));

      /* Empieza nodo:2175 / Elemento padre: 2174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2175)).setAttribute("nombre","lblAfectaFacturas" );
   }

   private void getXML8550(Document doc) {
      ((Element)v.get(2175)).setAttribute("alto","13" );
      ((Element)v.get(2175)).setAttribute("filas","1" );
      ((Element)v.get(2175)).setAttribute("valor","" );
      ((Element)v.get(2175)).setAttribute("id","legend" );
      ((Element)v.get(2175)).setAttribute("cod","00489" );
      ((Element)v.get(2174)).appendChild((Element)v.get(2175));
      /* Termina nodo:2175   */
      /* Termina nodo:2174   */

      /* Empieza nodo:2176 / Elemento padre: 2173   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2176)).setAttribute("width","100%" );
      ((Element)v.get(2176)).setAttribute("border","0" );
      ((Element)v.get(2176)).setAttribute("align","center" );
      ((Element)v.get(2176)).setAttribute("cellspacing","0" );
      ((Element)v.get(2176)).setAttribute("cellpadding","0" );
      ((Element)v.get(2173)).appendChild((Element)v.get(2176));

      /* Empieza nodo:2177 / Elemento padre: 2176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2176)).appendChild((Element)v.get(2177));

      /* Empieza nodo:2178 / Elemento padre: 2177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2178)).setAttribute("colspan","3" );
      ((Element)v.get(2177)).appendChild((Element)v.get(2178));

      /* Empieza nodo:2179 / Elemento padre: 2178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2179)).setAttribute("src","b.gif" );
      ((Element)v.get(2179)).setAttribute("width","8" );
      ((Element)v.get(2179)).setAttribute("height","8" );
      ((Element)v.get(2178)).appendChild((Element)v.get(2179));
      /* Termina nodo:2179   */
      /* Termina nodo:2178   */
      /* Termina nodo:2177   */

      /* Empieza nodo:2180 / Elemento padre: 2176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2176)).appendChild((Element)v.get(2180));

      /* Empieza nodo:2181 / Elemento padre: 2180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2180)).appendChild((Element)v.get(2181));

      /* Empieza nodo:2182 / Elemento padre: 2181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2182)).setAttribute("src","b.gif" );
      ((Element)v.get(2182)).setAttribute("width","8" );
      ((Element)v.get(2182)).setAttribute("height","8" );
      ((Element)v.get(2181)).appendChild((Element)v.get(2182));
      /* Termina nodo:2182   */
      /* Termina nodo:2181   */

      /* Empieza nodo:2183 / Elemento padre: 2180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2180)).appendChild((Element)v.get(2183));

      /* Empieza nodo:2184 / Elemento padre: 2183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2184)).setAttribute("nombre","lblCodigoAfectaFacturas" );
      ((Element)v.get(2184)).setAttribute("alto","13" );
      ((Element)v.get(2184)).setAttribute("filas","1" );
      ((Element)v.get(2184)).setAttribute("valor","" );
      ((Element)v.get(2184)).setAttribute("id","datosTitle" );
      ((Element)v.get(2184)).setAttribute("cod","8" );
      ((Element)v.get(2183)).appendChild((Element)v.get(2184));
      /* Termina nodo:2184   */
      /* Termina nodo:2183   */

      /* Empieza nodo:2185 / Elemento padre: 2180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2180)).appendChild((Element)v.get(2185));

      /* Empieza nodo:2186 / Elemento padre: 2185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2186)).setAttribute("src","b.gif" );
      ((Element)v.get(2186)).setAttribute("width","25" );
      ((Element)v.get(2186)).setAttribute("height","8" );
      ((Element)v.get(2185)).appendChild((Element)v.get(2186));
      /* Termina nodo:2186   */
      /* Termina nodo:2185   */

      /* Empieza nodo:2187 / Elemento padre: 2180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2180)).appendChild((Element)v.get(2187));

      /* Empieza nodo:2188 / Elemento padre: 2187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2188)).setAttribute("nombre","lblVisibleAfectaFacturas" );
      ((Element)v.get(2188)).setAttribute("alto","13" );
      ((Element)v.get(2188)).setAttribute("filas","1" );
      ((Element)v.get(2188)).setAttribute("valor","" );
      ((Element)v.get(2188)).setAttribute("id","datosTitle" );
      ((Element)v.get(2188)).setAttribute("cod","1038" );
      ((Element)v.get(2187)).appendChild((Element)v.get(2188));
      /* Termina nodo:2188   */
      /* Termina nodo:2187   */

      /* Empieza nodo:2189 / Elemento padre: 2180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2180)).appendChild((Element)v.get(2189));

      /* Empieza nodo:2190 / Elemento padre: 2189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2190)).setAttribute("src","b.gif" );
      ((Element)v.get(2190)).setAttribute("width","25" );
      ((Element)v.get(2190)).setAttribute("height","8" );
      ((Element)v.get(2189)).appendChild((Element)v.get(2190));
      /* Termina nodo:2190   */
      /* Termina nodo:2189   */

      /* Empieza nodo:2191 / Elemento padre: 2180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2180)).appendChild((Element)v.get(2191));

      /* Empieza nodo:2192 / Elemento padre: 2191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2192)).setAttribute("nombre","lblObligatorioAfectaFacturas" );
      ((Element)v.get(2192)).setAttribute("alto","13" );
      ((Element)v.get(2192)).setAttribute("filas","1" );
      ((Element)v.get(2192)).setAttribute("valor","" );
      ((Element)v.get(2192)).setAttribute("id","datosTitle" );
      ((Element)v.get(2192)).setAttribute("cod","949" );
      ((Element)v.get(2191)).appendChild((Element)v.get(2192));
      /* Termina nodo:2192   */
      /* Termina nodo:2191   */

      /* Empieza nodo:2193 / Elemento padre: 2180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2180)).appendChild((Element)v.get(2193));

      /* Empieza nodo:2194 / Elemento padre: 2193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2194)).setAttribute("src","b.gif" );
      ((Element)v.get(2194)).setAttribute("width","25" );
      ((Element)v.get(2194)).setAttribute("height","8" );
      ((Element)v.get(2193)).appendChild((Element)v.get(2194));
      /* Termina nodo:2194   */
      /* Termina nodo:2193   */

      /* Empieza nodo:2195 / Elemento padre: 2180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2180)).appendChild((Element)v.get(2195));

      /* Empieza nodo:2196 / Elemento padre: 2195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2196)).setAttribute("nombre","lblModificableAfectaFacturas" );
      ((Element)v.get(2196)).setAttribute("alto","13" );
      ((Element)v.get(2196)).setAttribute("filas","1" );
      ((Element)v.get(2196)).setAttribute("valor","" );
   }

   private void getXML8640(Document doc) {
      ((Element)v.get(2196)).setAttribute("id","datosTitle" );
      ((Element)v.get(2196)).setAttribute("cod","914" );
      ((Element)v.get(2195)).appendChild((Element)v.get(2196));
      /* Termina nodo:2196   */
      /* Termina nodo:2195   */

      /* Empieza nodo:2197 / Elemento padre: 2180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2197)).setAttribute("width","100%" );
      ((Element)v.get(2180)).appendChild((Element)v.get(2197));

      /* Empieza nodo:2198 / Elemento padre: 2197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2198)).setAttribute("src","b.gif" );
      ((Element)v.get(2198)).setAttribute("width","8" );
      ((Element)v.get(2198)).setAttribute("height","8" );
      ((Element)v.get(2197)).appendChild((Element)v.get(2198));
      /* Termina nodo:2198   */
      /* Termina nodo:2197   */
      /* Termina nodo:2180   */

      /* Empieza nodo:2199 / Elemento padre: 2176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2176)).appendChild((Element)v.get(2199));

      /* Empieza nodo:2200 / Elemento padre: 2199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2199)).appendChild((Element)v.get(2200));

      /* Empieza nodo:2201 / Elemento padre: 2200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2201)).setAttribute("src","b.gif" );
      ((Element)v.get(2201)).setAttribute("width","8" );
      ((Element)v.get(2201)).setAttribute("height","8" );
      ((Element)v.get(2200)).appendChild((Element)v.get(2201));
      /* Termina nodo:2201   */
      /* Termina nodo:2200   */

      /* Empieza nodo:2202 / Elemento padre: 2199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2199)).appendChild((Element)v.get(2202));

      /* Empieza nodo:2203 / Elemento padre: 2202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2203)).setAttribute("nombre","lbldtCodigoAfectaFacturas" );
      ((Element)v.get(2203)).setAttribute("alto","13" );
      ((Element)v.get(2203)).setAttribute("filas","1" );
      ((Element)v.get(2203)).setAttribute("valor","29" );
      ((Element)v.get(2203)).setAttribute("id","datosCampos" );
      ((Element)v.get(2202)).appendChild((Element)v.get(2203));
      /* Termina nodo:2203   */
      /* Termina nodo:2202   */

      /* Empieza nodo:2204 / Elemento padre: 2199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2199)).appendChild((Element)v.get(2204));

      /* Empieza nodo:2205 / Elemento padre: 2204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2205)).setAttribute("src","b.gif" );
      ((Element)v.get(2205)).setAttribute("width","25" );
      ((Element)v.get(2205)).setAttribute("height","8" );
      ((Element)v.get(2204)).appendChild((Element)v.get(2205));
      /* Termina nodo:2205   */
      /* Termina nodo:2204   */

      /* Empieza nodo:2206 / Elemento padre: 2199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2199)).appendChild((Element)v.get(2206));

      /* Empieza nodo:2207 / Elemento padre: 2206   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2207)).setAttribute("nombre","ckVisibleAfectaFacturas" );
      ((Element)v.get(2207)).setAttribute("id","datosCampos" );
      ((Element)v.get(2207)).setAttribute("onclick","cambiaObli(27)" );
      ((Element)v.get(2207)).setAttribute("check","S" );
      ((Element)v.get(2206)).appendChild((Element)v.get(2207));
      /* Termina nodo:2207   */
      /* Termina nodo:2206   */

      /* Empieza nodo:2208 / Elemento padre: 2199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2199)).appendChild((Element)v.get(2208));

      /* Empieza nodo:2209 / Elemento padre: 2208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2209)).setAttribute("src","b.gif" );
      ((Element)v.get(2209)).setAttribute("width","25" );
      ((Element)v.get(2209)).setAttribute("height","8" );
      ((Element)v.get(2208)).appendChild((Element)v.get(2209));
      /* Termina nodo:2209   */
      /* Termina nodo:2208   */

      /* Empieza nodo:2210 / Elemento padre: 2199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2199)).appendChild((Element)v.get(2210));

      /* Empieza nodo:2211 / Elemento padre: 2210   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2211)).setAttribute("nombre","ckObligatorioAfectaFacturas" );
      ((Element)v.get(2211)).setAttribute("id","datosCampos" );
      ((Element)v.get(2211)).setAttribute("onclick","" );
      ((Element)v.get(2211)).setAttribute("check","N" );
      ((Element)v.get(2210)).appendChild((Element)v.get(2211));
      /* Termina nodo:2211   */
      /* Termina nodo:2210   */

      /* Empieza nodo:2212 / Elemento padre: 2199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2199)).appendChild((Element)v.get(2212));

      /* Empieza nodo:2213 / Elemento padre: 2212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2213)).setAttribute("src","b.gif" );
      ((Element)v.get(2213)).setAttribute("width","25" );
      ((Element)v.get(2213)).setAttribute("height","8" );
      ((Element)v.get(2212)).appendChild((Element)v.get(2213));
      /* Termina nodo:2213   */
      /* Termina nodo:2212   */

      /* Empieza nodo:2214 / Elemento padre: 2199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2199)).appendChild((Element)v.get(2214));

      /* Empieza nodo:2215 / Elemento padre: 2214   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2215)).setAttribute("nombre","ckModificableAfectaFacturas" );
      ((Element)v.get(2215)).setAttribute("id","datosCampos" );
      ((Element)v.get(2215)).setAttribute("onclick","" );
      ((Element)v.get(2215)).setAttribute("check","S" );
      ((Element)v.get(2214)).appendChild((Element)v.get(2215));
      /* Termina nodo:2215   */
      /* Termina nodo:2214   */

      /* Empieza nodo:2216 / Elemento padre: 2199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2216)).setAttribute("width","100%" );
      ((Element)v.get(2199)).appendChild((Element)v.get(2216));

      /* Empieza nodo:2217 / Elemento padre: 2216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2217)).setAttribute("src","b.gif" );
      ((Element)v.get(2217)).setAttribute("width","8" );
      ((Element)v.get(2217)).setAttribute("height","8" );
      ((Element)v.get(2216)).appendChild((Element)v.get(2217));
      /* Termina nodo:2217   */
      /* Termina nodo:2216   */
      /* Termina nodo:2199   */

      /* Empieza nodo:2218 / Elemento padre: 2176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2176)).appendChild((Element)v.get(2218));

      /* Empieza nodo:2219 / Elemento padre: 2218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2219)).setAttribute("colspan","4" );
      ((Element)v.get(2218)).appendChild((Element)v.get(2219));

      /* Empieza nodo:2220 / Elemento padre: 2219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2220)).setAttribute("src","b.gif" );
      ((Element)v.get(2220)).setAttribute("width","8" );
   }

   private void getXML8730(Document doc) {
      ((Element)v.get(2220)).setAttribute("height","8" );
      ((Element)v.get(2219)).appendChild((Element)v.get(2220));
      /* Termina nodo:2220   */
      /* Termina nodo:2219   */
      /* Termina nodo:2218   */
      /* Termina nodo:2176   */

      /* Empieza nodo:2221 / Elemento padre: 2173   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2221)).setAttribute("width","100%" );
      ((Element)v.get(2221)).setAttribute("border","0" );
      ((Element)v.get(2221)).setAttribute("align","center" );
      ((Element)v.get(2221)).setAttribute("cellspacing","0" );
      ((Element)v.get(2221)).setAttribute("cellpadding","0" );
      ((Element)v.get(2173)).appendChild((Element)v.get(2221));

      /* Empieza nodo:2222 / Elemento padre: 2221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2221)).appendChild((Element)v.get(2222));

      /* Empieza nodo:2223 / Elemento padre: 2222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2222)).appendChild((Element)v.get(2223));

      /* Empieza nodo:2224 / Elemento padre: 2223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2224)).setAttribute("src","b.gif" );
      ((Element)v.get(2224)).setAttribute("width","8" );
      ((Element)v.get(2224)).setAttribute("height","8" );
      ((Element)v.get(2223)).appendChild((Element)v.get(2224));
      /* Termina nodo:2224   */
      /* Termina nodo:2223   */

      /* Empieza nodo:2225 / Elemento padre: 2222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2222)).appendChild((Element)v.get(2225));

      /* Empieza nodo:2226 / Elemento padre: 2225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2226)).setAttribute("nombre","lblValoresPosiblesAfectaFacturas" );
      ((Element)v.get(2226)).setAttribute("alto","13" );
      ((Element)v.get(2226)).setAttribute("filas","1" );
      ((Element)v.get(2226)).setAttribute("valor","" );
      ((Element)v.get(2226)).setAttribute("id","datosTitle" );
      ((Element)v.get(2226)).setAttribute("cod","1022" );
      ((Element)v.get(2225)).appendChild((Element)v.get(2226));
      /* Termina nodo:2226   */
      /* Termina nodo:2225   */

      /* Empieza nodo:2227 / Elemento padre: 2222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2222)).appendChild((Element)v.get(2227));

      /* Empieza nodo:2228 / Elemento padre: 2227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2228)).setAttribute("src","b.gif" );
      ((Element)v.get(2228)).setAttribute("width","25" );
      ((Element)v.get(2228)).setAttribute("height","8" );
      ((Element)v.get(2227)).appendChild((Element)v.get(2228));
      /* Termina nodo:2228   */
      /* Termina nodo:2227   */

      /* Empieza nodo:2229 / Elemento padre: 2222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2222)).appendChild((Element)v.get(2229));

      /* Empieza nodo:2230 / Elemento padre: 2229   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2230)).setAttribute("nombre","lblValoresDefectoAfectaFacturas" );
      ((Element)v.get(2230)).setAttribute("alto","13" );
      ((Element)v.get(2230)).setAttribute("filas","1" );
      ((Element)v.get(2230)).setAttribute("valor","" );
      ((Element)v.get(2230)).setAttribute("id","datosTitle" );
      ((Element)v.get(2230)).setAttribute("cod","1286" );
      ((Element)v.get(2229)).appendChild((Element)v.get(2230));
      /* Termina nodo:2230   */
      /* Termina nodo:2229   */

      /* Empieza nodo:2231 / Elemento padre: 2222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2231)).setAttribute("width","100%" );
      ((Element)v.get(2222)).appendChild((Element)v.get(2231));

      /* Empieza nodo:2232 / Elemento padre: 2231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2232)).setAttribute("src","b.gif" );
      ((Element)v.get(2232)).setAttribute("width","8" );
      ((Element)v.get(2232)).setAttribute("height","8" );
      ((Element)v.get(2231)).appendChild((Element)v.get(2232));
      /* Termina nodo:2232   */
      /* Termina nodo:2231   */
      /* Termina nodo:2222   */

      /* Empieza nodo:2233 / Elemento padre: 2221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2221)).appendChild((Element)v.get(2233));

      /* Empieza nodo:2234 / Elemento padre: 2233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2233)).appendChild((Element)v.get(2234));

      /* Empieza nodo:2235 / Elemento padre: 2234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2235)).setAttribute("src","b.gif" );
      ((Element)v.get(2235)).setAttribute("width","8" );
      ((Element)v.get(2235)).setAttribute("height","8" );
      ((Element)v.get(2234)).appendChild((Element)v.get(2235));
      /* Termina nodo:2235   */
      /* Termina nodo:2234   */

      /* Empieza nodo:2236 / Elemento padre: 2233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2236)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2233)).appendChild((Element)v.get(2236));

      /* Empieza nodo:2237 / Elemento padre: 2236   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2237)).setAttribute("nombre","cbValoresPosiblesAfectaFacturas" );
      ((Element)v.get(2237)).setAttribute("onchange","afectaFacturasOnChange();" );
      ((Element)v.get(2237)).setAttribute("id","datosCampos" );
      ((Element)v.get(2237)).setAttribute("size","3" );
      ((Element)v.get(2237)).setAttribute("multiple","S" );
      ((Element)v.get(2237)).setAttribute("req","S" );
      ((Element)v.get(2237)).setAttribute("valorinicial","" );
      ((Element)v.get(2237)).setAttribute("textoinicial","" );
      ((Element)v.get(2236)).appendChild((Element)v.get(2237));

      /* Empieza nodo:2238 / Elemento padre: 2237   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2237)).appendChild((Element)v.get(2238));

      /* Empieza nodo:2239 / Elemento padre: 2238   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2239)).setAttribute("ID","1" );
      ((Element)v.get(2238)).appendChild((Element)v.get(2239));

      /* Empieza nodo:2240 / Elemento padre: 2239   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2240)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2240)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2240)).setAttribute("VALOR","1" );
      ((Element)v.get(2239)).appendChild((Element)v.get(2240));
      /* Termina nodo:2240   */

      /* Empieza nodo:2241 / Elemento padre: 2239   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2241)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2241)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2241)).setAttribute("VALOR","Si" );
      ((Element)v.get(2239)).appendChild((Element)v.get(2241));
      /* Termina nodo:2241   */
      /* Termina nodo:2239   */

      /* Empieza nodo:2242 / Elemento padre: 2238   */
   }

   private void getXML8820(Document doc) {
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2242)).setAttribute("ID","2" );
      ((Element)v.get(2238)).appendChild((Element)v.get(2242));

      /* Empieza nodo:2243 / Elemento padre: 2242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2243)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2243)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2243)).setAttribute("VALOR","0" );
      ((Element)v.get(2242)).appendChild((Element)v.get(2243));
      /* Termina nodo:2243   */

      /* Empieza nodo:2244 / Elemento padre: 2242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2244)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2244)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2244)).setAttribute("VALOR","No" );
      ((Element)v.get(2242)).appendChild((Element)v.get(2244));
      /* Termina nodo:2244   */
      /* Termina nodo:2242   */
      /* Termina nodo:2238   */
      /* Termina nodo:2237   */
      /* Termina nodo:2236   */

      /* Empieza nodo:2245 / Elemento padre: 2233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2233)).appendChild((Element)v.get(2245));

      /* Empieza nodo:2246 / Elemento padre: 2245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2246)).setAttribute("src","b.gif" );
      ((Element)v.get(2246)).setAttribute("width","25" );
      ((Element)v.get(2246)).setAttribute("height","8" );
      ((Element)v.get(2245)).appendChild((Element)v.get(2246));
      /* Termina nodo:2246   */
      /* Termina nodo:2245   */

      /* Empieza nodo:2247 / Elemento padre: 2233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2247)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2247)).setAttribute("valign","top" );
      ((Element)v.get(2233)).appendChild((Element)v.get(2247));

      /* Empieza nodo:2248 / Elemento padre: 2247   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2248)).setAttribute("nombre","cbValoresDefectoAfectaFacturas" );
      ((Element)v.get(2248)).setAttribute("id","datosCampos" );
      ((Element)v.get(2248)).setAttribute("size","1" );
      ((Element)v.get(2248)).setAttribute("multiple","N" );
      ((Element)v.get(2248)).setAttribute("req","N" );
      ((Element)v.get(2248)).setAttribute("valorinicial","" );
      ((Element)v.get(2248)).setAttribute("textoinicial","" );
      ((Element)v.get(2247)).appendChild((Element)v.get(2248));

      /* Empieza nodo:2249 / Elemento padre: 2248   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2248)).appendChild((Element)v.get(2249));
      /* Termina nodo:2249   */
      /* Termina nodo:2248   */
      /* Termina nodo:2247   */

      /* Empieza nodo:2250 / Elemento padre: 2233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2250)).setAttribute("width","100%" );
      ((Element)v.get(2233)).appendChild((Element)v.get(2250));

      /* Empieza nodo:2251 / Elemento padre: 2250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2251)).setAttribute("src","b.gif" );
      ((Element)v.get(2251)).setAttribute("width","8" );
      ((Element)v.get(2251)).setAttribute("height","8" );
      ((Element)v.get(2250)).appendChild((Element)v.get(2251));
      /* Termina nodo:2251   */
      /* Termina nodo:2250   */
      /* Termina nodo:2233   */

      /* Empieza nodo:2252 / Elemento padre: 2221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2221)).appendChild((Element)v.get(2252));

      /* Empieza nodo:2253 / Elemento padre: 2252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2253)).setAttribute("colspan","4" );
      ((Element)v.get(2252)).appendChild((Element)v.get(2253));

      /* Empieza nodo:2254 / Elemento padre: 2253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2254)).setAttribute("src","b.gif" );
      ((Element)v.get(2254)).setAttribute("width","8" );
      ((Element)v.get(2254)).setAttribute("height","8" );
      ((Element)v.get(2253)).appendChild((Element)v.get(2254));
      /* Termina nodo:2254   */
      /* Termina nodo:2253   */
      /* Termina nodo:2252   */
      /* Termina nodo:2221   */
      /* Termina nodo:2173   */
      /* Termina nodo:2172   */

      /* Empieza nodo:2255 / Elemento padre: 2169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2169)).appendChild((Element)v.get(2255));

      /* Empieza nodo:2256 / Elemento padre: 2255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2256)).setAttribute("src","b.gif" );
      ((Element)v.get(2255)).appendChild((Element)v.get(2256));
      /* Termina nodo:2256   */
      /* Termina nodo:2255   */
      /* Termina nodo:2169   */

      /* Empieza nodo:2257 / Elemento padre: 2168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2168)).appendChild((Element)v.get(2257));

      /* Empieza nodo:2258 / Elemento padre: 2257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2258)).setAttribute("width","12" );
      ((Element)v.get(2258)).setAttribute("align","center" );
      ((Element)v.get(2257)).appendChild((Element)v.get(2258));

      /* Empieza nodo:2259 / Elemento padre: 2258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2259)).setAttribute("src","b.gif" );
      ((Element)v.get(2259)).setAttribute("width","12" );
      ((Element)v.get(2259)).setAttribute("height","15" );
      ((Element)v.get(2258)).appendChild((Element)v.get(2259));
      /* Termina nodo:2259   */
      /* Termina nodo:2258   */

      /* Empieza nodo:2260 / Elemento padre: 2257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2260)).setAttribute("width","756" );
      ((Element)v.get(2257)).appendChild((Element)v.get(2260));

      /* Empieza nodo:2261 / Elemento padre: 2260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2261)).setAttribute("src","b.gif" );
      ((Element)v.get(2260)).appendChild((Element)v.get(2261));
      /* Termina nodo:2261   */
      /* Termina nodo:2260   */

      /* Empieza nodo:2262 / Elemento padre: 2257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2262)).setAttribute("width","12" );
      ((Element)v.get(2257)).appendChild((Element)v.get(2262));

      /* Empieza nodo:2263 / Elemento padre: 2262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2263)).setAttribute("src","b.gif" );
      ((Element)v.get(2263)).setAttribute("width","12" );
      ((Element)v.get(2263)).setAttribute("height","1" );
      ((Element)v.get(2262)).appendChild((Element)v.get(2263));
      /* Termina nodo:2263   */
      /* Termina nodo:2262   */
      /* Termina nodo:2257   */
      /* Termina nodo:2168   */

      /* Empieza nodo:2264 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2264)).setAttribute("width","100%" );
      ((Element)v.get(2264)).setAttribute("border","0" );
      ((Element)v.get(2264)).setAttribute("align","center" );
      ((Element)v.get(2264)).setAttribute("cellspacing","0" );
      ((Element)v.get(2264)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(2264));

      /* Empieza nodo:2265 / Elemento padre: 2264   */
   }

   private void getXML8910(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(2264)).appendChild((Element)v.get(2265));

      /* Empieza nodo:2266 / Elemento padre: 2265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2265)).appendChild((Element)v.get(2266));

      /* Empieza nodo:2267 / Elemento padre: 2266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2267)).setAttribute("src","b.gif" );
      ((Element)v.get(2267)).setAttribute("width","8" );
      ((Element)v.get(2267)).setAttribute("height","8" );
      ((Element)v.get(2266)).appendChild((Element)v.get(2267));
      /* Termina nodo:2267   */
      /* Termina nodo:2266   */

      /* Empieza nodo:2268 / Elemento padre: 2265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2268)).setAttribute("width","100%" );
      ((Element)v.get(2265)).appendChild((Element)v.get(2268));

      /* Empieza nodo:2269 / Elemento padre: 2268   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(2268)).appendChild((Element)v.get(2269));

      /* Empieza nodo:2270 / Elemento padre: 2269   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(2270)).setAttribute("class","legend" );
      ((Element)v.get(2269)).appendChild((Element)v.get(2270));

      /* Empieza nodo:2271 / Elemento padre: 2270   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2271)).setAttribute("nombre","lblAfectaCuentaCorriente" );
      ((Element)v.get(2271)).setAttribute("alto","13" );
      ((Element)v.get(2271)).setAttribute("filas","1" );
      ((Element)v.get(2271)).setAttribute("valor","" );
      ((Element)v.get(2271)).setAttribute("id","legend" );
      ((Element)v.get(2271)).setAttribute("cod","00490" );
      ((Element)v.get(2270)).appendChild((Element)v.get(2271));
      /* Termina nodo:2271   */
      /* Termina nodo:2270   */

      /* Empieza nodo:2272 / Elemento padre: 2269   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2272)).setAttribute("width","100%" );
      ((Element)v.get(2272)).setAttribute("border","0" );
      ((Element)v.get(2272)).setAttribute("align","center" );
      ((Element)v.get(2272)).setAttribute("cellspacing","0" );
      ((Element)v.get(2272)).setAttribute("cellpadding","0" );
      ((Element)v.get(2269)).appendChild((Element)v.get(2272));

      /* Empieza nodo:2273 / Elemento padre: 2272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2272)).appendChild((Element)v.get(2273));

      /* Empieza nodo:2274 / Elemento padre: 2273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2274)).setAttribute("colspan","3" );
      ((Element)v.get(2273)).appendChild((Element)v.get(2274));

      /* Empieza nodo:2275 / Elemento padre: 2274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2275)).setAttribute("src","b.gif" );
      ((Element)v.get(2275)).setAttribute("width","8" );
      ((Element)v.get(2275)).setAttribute("height","8" );
      ((Element)v.get(2274)).appendChild((Element)v.get(2275));
      /* Termina nodo:2275   */
      /* Termina nodo:2274   */
      /* Termina nodo:2273   */

      /* Empieza nodo:2276 / Elemento padre: 2272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2272)).appendChild((Element)v.get(2276));

      /* Empieza nodo:2277 / Elemento padre: 2276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2276)).appendChild((Element)v.get(2277));

      /* Empieza nodo:2278 / Elemento padre: 2277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2278)).setAttribute("src","b.gif" );
      ((Element)v.get(2278)).setAttribute("width","8" );
      ((Element)v.get(2278)).setAttribute("height","8" );
      ((Element)v.get(2277)).appendChild((Element)v.get(2278));
      /* Termina nodo:2278   */
      /* Termina nodo:2277   */

      /* Empieza nodo:2279 / Elemento padre: 2276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2276)).appendChild((Element)v.get(2279));

      /* Empieza nodo:2280 / Elemento padre: 2279   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2280)).setAttribute("nombre","lblCodigoAfectaCuentaCorriente" );
      ((Element)v.get(2280)).setAttribute("alto","13" );
      ((Element)v.get(2280)).setAttribute("filas","1" );
      ((Element)v.get(2280)).setAttribute("valor","" );
      ((Element)v.get(2280)).setAttribute("id","datosTitle" );
      ((Element)v.get(2280)).setAttribute("cod","8" );
      ((Element)v.get(2279)).appendChild((Element)v.get(2280));
      /* Termina nodo:2280   */
      /* Termina nodo:2279   */

      /* Empieza nodo:2281 / Elemento padre: 2276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2276)).appendChild((Element)v.get(2281));

      /* Empieza nodo:2282 / Elemento padre: 2281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2282)).setAttribute("src","b.gif" );
      ((Element)v.get(2282)).setAttribute("width","25" );
      ((Element)v.get(2282)).setAttribute("height","8" );
      ((Element)v.get(2281)).appendChild((Element)v.get(2282));
      /* Termina nodo:2282   */
      /* Termina nodo:2281   */

      /* Empieza nodo:2283 / Elemento padre: 2276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2276)).appendChild((Element)v.get(2283));

      /* Empieza nodo:2284 / Elemento padre: 2283   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2284)).setAttribute("nombre","lblVisibleAfectaCuentaCorriente" );
      ((Element)v.get(2284)).setAttribute("alto","13" );
      ((Element)v.get(2284)).setAttribute("filas","1" );
      ((Element)v.get(2284)).setAttribute("valor","" );
      ((Element)v.get(2284)).setAttribute("id","datosTitle" );
      ((Element)v.get(2284)).setAttribute("cod","1038" );
      ((Element)v.get(2283)).appendChild((Element)v.get(2284));
      /* Termina nodo:2284   */
      /* Termina nodo:2283   */

      /* Empieza nodo:2285 / Elemento padre: 2276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2276)).appendChild((Element)v.get(2285));

      /* Empieza nodo:2286 / Elemento padre: 2285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2286)).setAttribute("src","b.gif" );
      ((Element)v.get(2286)).setAttribute("width","25" );
      ((Element)v.get(2286)).setAttribute("height","8" );
      ((Element)v.get(2285)).appendChild((Element)v.get(2286));
      /* Termina nodo:2286   */
      /* Termina nodo:2285   */

      /* Empieza nodo:2287 / Elemento padre: 2276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2276)).appendChild((Element)v.get(2287));

      /* Empieza nodo:2288 / Elemento padre: 2287   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2288)).setAttribute("nombre","lblObligatorioAfectaCuentaCorriente" );
      ((Element)v.get(2288)).setAttribute("alto","13" );
   }

   private void getXML9000(Document doc) {
      ((Element)v.get(2288)).setAttribute("filas","1" );
      ((Element)v.get(2288)).setAttribute("valor","" );
      ((Element)v.get(2288)).setAttribute("id","datosTitle" );
      ((Element)v.get(2288)).setAttribute("cod","949" );
      ((Element)v.get(2287)).appendChild((Element)v.get(2288));
      /* Termina nodo:2288   */
      /* Termina nodo:2287   */

      /* Empieza nodo:2289 / Elemento padre: 2276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2276)).appendChild((Element)v.get(2289));

      /* Empieza nodo:2290 / Elemento padre: 2289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2290)).setAttribute("src","b.gif" );
      ((Element)v.get(2290)).setAttribute("width","25" );
      ((Element)v.get(2290)).setAttribute("height","8" );
      ((Element)v.get(2289)).appendChild((Element)v.get(2290));
      /* Termina nodo:2290   */
      /* Termina nodo:2289   */

      /* Empieza nodo:2291 / Elemento padre: 2276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2276)).appendChild((Element)v.get(2291));

      /* Empieza nodo:2292 / Elemento padre: 2291   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2292)).setAttribute("nombre","lblModificableAfectaCuentaCorriente" );
      ((Element)v.get(2292)).setAttribute("alto","13" );
      ((Element)v.get(2292)).setAttribute("filas","1" );
      ((Element)v.get(2292)).setAttribute("valor","" );
      ((Element)v.get(2292)).setAttribute("id","datosTitle" );
      ((Element)v.get(2292)).setAttribute("cod","914" );
      ((Element)v.get(2291)).appendChild((Element)v.get(2292));
      /* Termina nodo:2292   */
      /* Termina nodo:2291   */

      /* Empieza nodo:2293 / Elemento padre: 2276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2293)).setAttribute("width","100%" );
      ((Element)v.get(2276)).appendChild((Element)v.get(2293));

      /* Empieza nodo:2294 / Elemento padre: 2293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2294)).setAttribute("src","b.gif" );
      ((Element)v.get(2294)).setAttribute("width","8" );
      ((Element)v.get(2294)).setAttribute("height","8" );
      ((Element)v.get(2293)).appendChild((Element)v.get(2294));
      /* Termina nodo:2294   */
      /* Termina nodo:2293   */
      /* Termina nodo:2276   */

      /* Empieza nodo:2295 / Elemento padre: 2272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2272)).appendChild((Element)v.get(2295));

      /* Empieza nodo:2296 / Elemento padre: 2295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2295)).appendChild((Element)v.get(2296));

      /* Empieza nodo:2297 / Elemento padre: 2296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2297)).setAttribute("src","b.gif" );
      ((Element)v.get(2297)).setAttribute("width","8" );
      ((Element)v.get(2297)).setAttribute("height","8" );
      ((Element)v.get(2296)).appendChild((Element)v.get(2297));
      /* Termina nodo:2297   */
      /* Termina nodo:2296   */

      /* Empieza nodo:2298 / Elemento padre: 2295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2295)).appendChild((Element)v.get(2298));

      /* Empieza nodo:2299 / Elemento padre: 2298   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2299)).setAttribute("nombre","lbldtCodigoAfectaCuentaCorriente" );
      ((Element)v.get(2299)).setAttribute("alto","13" );
      ((Element)v.get(2299)).setAttribute("filas","1" );
      ((Element)v.get(2299)).setAttribute("valor","30" );
      ((Element)v.get(2299)).setAttribute("id","datosCampos" );
      ((Element)v.get(2298)).appendChild((Element)v.get(2299));
      /* Termina nodo:2299   */
      /* Termina nodo:2298   */

      /* Empieza nodo:2300 / Elemento padre: 2295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2295)).appendChild((Element)v.get(2300));

      /* Empieza nodo:2301 / Elemento padre: 2300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2301)).setAttribute("src","b.gif" );
      ((Element)v.get(2301)).setAttribute("width","25" );
      ((Element)v.get(2301)).setAttribute("height","8" );
      ((Element)v.get(2300)).appendChild((Element)v.get(2301));
      /* Termina nodo:2301   */
      /* Termina nodo:2300   */

      /* Empieza nodo:2302 / Elemento padre: 2295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2295)).appendChild((Element)v.get(2302));

      /* Empieza nodo:2303 / Elemento padre: 2302   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2303)).setAttribute("nombre","ckVisibleAfectaCuentaCorriente" );
      ((Element)v.get(2303)).setAttribute("id","datosCampos" );
      ((Element)v.get(2303)).setAttribute("onclick","cambiaObli(28)" );
      ((Element)v.get(2303)).setAttribute("check","S" );
      ((Element)v.get(2302)).appendChild((Element)v.get(2303));
      /* Termina nodo:2303   */
      /* Termina nodo:2302   */

      /* Empieza nodo:2304 / Elemento padre: 2295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2295)).appendChild((Element)v.get(2304));

      /* Empieza nodo:2305 / Elemento padre: 2304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2305)).setAttribute("src","b.gif" );
      ((Element)v.get(2305)).setAttribute("width","25" );
      ((Element)v.get(2305)).setAttribute("height","8" );
      ((Element)v.get(2304)).appendChild((Element)v.get(2305));
      /* Termina nodo:2305   */
      /* Termina nodo:2304   */

      /* Empieza nodo:2306 / Elemento padre: 2295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2295)).appendChild((Element)v.get(2306));

      /* Empieza nodo:2307 / Elemento padre: 2306   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2307)).setAttribute("nombre","ckObligatorioAfectaCuentaCorriente" );
      ((Element)v.get(2307)).setAttribute("id","datosCampos" );
      ((Element)v.get(2307)).setAttribute("onclick","" );
      ((Element)v.get(2307)).setAttribute("check","N" );
      ((Element)v.get(2306)).appendChild((Element)v.get(2307));
      /* Termina nodo:2307   */
      /* Termina nodo:2306   */

      /* Empieza nodo:2308 / Elemento padre: 2295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2295)).appendChild((Element)v.get(2308));

      /* Empieza nodo:2309 / Elemento padre: 2308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2309)).setAttribute("src","b.gif" );
      ((Element)v.get(2309)).setAttribute("width","25" );
      ((Element)v.get(2309)).setAttribute("height","8" );
      ((Element)v.get(2308)).appendChild((Element)v.get(2309));
      /* Termina nodo:2309   */
      /* Termina nodo:2308   */

      /* Empieza nodo:2310 / Elemento padre: 2295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2295)).appendChild((Element)v.get(2310));

      /* Empieza nodo:2311 / Elemento padre: 2310   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2311)).setAttribute("nombre","ckModificableAfectaCuentaCorriente" );
      ((Element)v.get(2311)).setAttribute("id","datosCampos" );
   }

   private void getXML9090(Document doc) {
      ((Element)v.get(2311)).setAttribute("onclick","" );
      ((Element)v.get(2311)).setAttribute("check","S" );
      ((Element)v.get(2310)).appendChild((Element)v.get(2311));
      /* Termina nodo:2311   */
      /* Termina nodo:2310   */

      /* Empieza nodo:2312 / Elemento padre: 2295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2312)).setAttribute("width","100%" );
      ((Element)v.get(2295)).appendChild((Element)v.get(2312));

      /* Empieza nodo:2313 / Elemento padre: 2312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2313)).setAttribute("src","b.gif" );
      ((Element)v.get(2313)).setAttribute("width","8" );
      ((Element)v.get(2313)).setAttribute("height","8" );
      ((Element)v.get(2312)).appendChild((Element)v.get(2313));
      /* Termina nodo:2313   */
      /* Termina nodo:2312   */
      /* Termina nodo:2295   */

      /* Empieza nodo:2314 / Elemento padre: 2272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2272)).appendChild((Element)v.get(2314));

      /* Empieza nodo:2315 / Elemento padre: 2314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2315)).setAttribute("colspan","4" );
      ((Element)v.get(2314)).appendChild((Element)v.get(2315));

      /* Empieza nodo:2316 / Elemento padre: 2315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2316)).setAttribute("src","b.gif" );
      ((Element)v.get(2316)).setAttribute("width","8" );
      ((Element)v.get(2316)).setAttribute("height","8" );
      ((Element)v.get(2315)).appendChild((Element)v.get(2316));
      /* Termina nodo:2316   */
      /* Termina nodo:2315   */
      /* Termina nodo:2314   */
      /* Termina nodo:2272   */

      /* Empieza nodo:2317 / Elemento padre: 2269   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2317)).setAttribute("width","100%" );
      ((Element)v.get(2317)).setAttribute("border","0" );
      ((Element)v.get(2317)).setAttribute("align","center" );
      ((Element)v.get(2317)).setAttribute("cellspacing","0" );
      ((Element)v.get(2317)).setAttribute("cellpadding","0" );
      ((Element)v.get(2269)).appendChild((Element)v.get(2317));

      /* Empieza nodo:2318 / Elemento padre: 2317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2317)).appendChild((Element)v.get(2318));

      /* Empieza nodo:2319 / Elemento padre: 2318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2318)).appendChild((Element)v.get(2319));

      /* Empieza nodo:2320 / Elemento padre: 2319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2320)).setAttribute("src","b.gif" );
      ((Element)v.get(2320)).setAttribute("width","8" );
      ((Element)v.get(2320)).setAttribute("height","8" );
      ((Element)v.get(2319)).appendChild((Element)v.get(2320));
      /* Termina nodo:2320   */
      /* Termina nodo:2319   */

      /* Empieza nodo:2321 / Elemento padre: 2318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2318)).appendChild((Element)v.get(2321));

      /* Empieza nodo:2322 / Elemento padre: 2321   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2322)).setAttribute("nombre","lblValoresPosiblesAfectaCuentaCorriente" );
      ((Element)v.get(2322)).setAttribute("alto","13" );
      ((Element)v.get(2322)).setAttribute("filas","1" );
      ((Element)v.get(2322)).setAttribute("valor","" );
      ((Element)v.get(2322)).setAttribute("id","datosTitle" );
      ((Element)v.get(2322)).setAttribute("cod","1022" );
      ((Element)v.get(2321)).appendChild((Element)v.get(2322));
      /* Termina nodo:2322   */
      /* Termina nodo:2321   */

      /* Empieza nodo:2323 / Elemento padre: 2318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2318)).appendChild((Element)v.get(2323));

      /* Empieza nodo:2324 / Elemento padre: 2323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2324)).setAttribute("src","b.gif" );
      ((Element)v.get(2324)).setAttribute("width","25" );
      ((Element)v.get(2324)).setAttribute("height","8" );
      ((Element)v.get(2323)).appendChild((Element)v.get(2324));
      /* Termina nodo:2324   */
      /* Termina nodo:2323   */

      /* Empieza nodo:2325 / Elemento padre: 2318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2318)).appendChild((Element)v.get(2325));

      /* Empieza nodo:2326 / Elemento padre: 2325   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2326)).setAttribute("nombre","lblValoresDefectoAfectaCuentaCorriente" );
      ((Element)v.get(2326)).setAttribute("alto","13" );
      ((Element)v.get(2326)).setAttribute("filas","1" );
      ((Element)v.get(2326)).setAttribute("valor","" );
      ((Element)v.get(2326)).setAttribute("id","datosTitle" );
      ((Element)v.get(2326)).setAttribute("cod","1286" );
      ((Element)v.get(2325)).appendChild((Element)v.get(2326));
      /* Termina nodo:2326   */
      /* Termina nodo:2325   */

      /* Empieza nodo:2327 / Elemento padre: 2318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2327)).setAttribute("width","100%" );
      ((Element)v.get(2318)).appendChild((Element)v.get(2327));

      /* Empieza nodo:2328 / Elemento padre: 2327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2328)).setAttribute("src","b.gif" );
      ((Element)v.get(2328)).setAttribute("width","8" );
      ((Element)v.get(2328)).setAttribute("height","8" );
      ((Element)v.get(2327)).appendChild((Element)v.get(2328));
      /* Termina nodo:2328   */
      /* Termina nodo:2327   */
      /* Termina nodo:2318   */

      /* Empieza nodo:2329 / Elemento padre: 2317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2317)).appendChild((Element)v.get(2329));

      /* Empieza nodo:2330 / Elemento padre: 2329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2329)).appendChild((Element)v.get(2330));

      /* Empieza nodo:2331 / Elemento padre: 2330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2331)).setAttribute("src","b.gif" );
      ((Element)v.get(2331)).setAttribute("width","8" );
      ((Element)v.get(2331)).setAttribute("height","8" );
      ((Element)v.get(2330)).appendChild((Element)v.get(2331));
      /* Termina nodo:2331   */
      /* Termina nodo:2330   */

      /* Empieza nodo:2332 / Elemento padre: 2329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2332)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2329)).appendChild((Element)v.get(2332));

      /* Empieza nodo:2333 / Elemento padre: 2332   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2333)).setAttribute("nombre","cbValoresPosiblesAfectaCuentaCorriente" );
      ((Element)v.get(2333)).setAttribute("onchange","afectaCCOnChange();" );
      ((Element)v.get(2333)).setAttribute("id","datosCampos" );
      ((Element)v.get(2333)).setAttribute("size","3" );
      ((Element)v.get(2333)).setAttribute("multiple","S" );
   }

   private void getXML9180(Document doc) {
      ((Element)v.get(2333)).setAttribute("req","S" );
      ((Element)v.get(2333)).setAttribute("valorinicial","" );
      ((Element)v.get(2333)).setAttribute("textoinicial","" );
      ((Element)v.get(2332)).appendChild((Element)v.get(2333));

      /* Empieza nodo:2334 / Elemento padre: 2333   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2333)).appendChild((Element)v.get(2334));

      /* Empieza nodo:2335 / Elemento padre: 2334   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2335)).setAttribute("ID","1" );
      ((Element)v.get(2334)).appendChild((Element)v.get(2335));

      /* Empieza nodo:2336 / Elemento padre: 2335   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2336)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2336)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2336)).setAttribute("VALOR","1" );
      ((Element)v.get(2335)).appendChild((Element)v.get(2336));
      /* Termina nodo:2336   */

      /* Empieza nodo:2337 / Elemento padre: 2335   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2337)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2337)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2337)).setAttribute("VALOR","Si" );
      ((Element)v.get(2335)).appendChild((Element)v.get(2337));
      /* Termina nodo:2337   */
      /* Termina nodo:2335   */

      /* Empieza nodo:2338 / Elemento padre: 2334   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2338)).setAttribute("ID","2" );
      ((Element)v.get(2334)).appendChild((Element)v.get(2338));

      /* Empieza nodo:2339 / Elemento padre: 2338   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2339)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2339)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2339)).setAttribute("VALOR","0" );
      ((Element)v.get(2338)).appendChild((Element)v.get(2339));
      /* Termina nodo:2339   */

      /* Empieza nodo:2340 / Elemento padre: 2338   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2340)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2340)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2340)).setAttribute("VALOR","No" );
      ((Element)v.get(2338)).appendChild((Element)v.get(2340));
      /* Termina nodo:2340   */
      /* Termina nodo:2338   */
      /* Termina nodo:2334   */
      /* Termina nodo:2333   */
      /* Termina nodo:2332   */

      /* Empieza nodo:2341 / Elemento padre: 2329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2329)).appendChild((Element)v.get(2341));

      /* Empieza nodo:2342 / Elemento padre: 2341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2342)).setAttribute("src","b.gif" );
      ((Element)v.get(2342)).setAttribute("width","25" );
      ((Element)v.get(2342)).setAttribute("height","8" );
      ((Element)v.get(2341)).appendChild((Element)v.get(2342));
      /* Termina nodo:2342   */
      /* Termina nodo:2341   */

      /* Empieza nodo:2343 / Elemento padre: 2329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2343)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2343)).setAttribute("valign","top" );
      ((Element)v.get(2329)).appendChild((Element)v.get(2343));

      /* Empieza nodo:2344 / Elemento padre: 2343   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2344)).setAttribute("nombre","cbValoresDefectoAfectaCuentaCorriente" );
      ((Element)v.get(2344)).setAttribute("id","datosCampos" );
      ((Element)v.get(2344)).setAttribute("size","1" );
      ((Element)v.get(2344)).setAttribute("multiple","N" );
      ((Element)v.get(2344)).setAttribute("req","N" );
      ((Element)v.get(2344)).setAttribute("valorinicial","" );
      ((Element)v.get(2344)).setAttribute("textoinicial","" );
      ((Element)v.get(2343)).appendChild((Element)v.get(2344));

      /* Empieza nodo:2345 / Elemento padre: 2344   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2344)).appendChild((Element)v.get(2345));
      /* Termina nodo:2345   */
      /* Termina nodo:2344   */
      /* Termina nodo:2343   */

      /* Empieza nodo:2346 / Elemento padre: 2329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2346)).setAttribute("width","100%" );
      ((Element)v.get(2329)).appendChild((Element)v.get(2346));

      /* Empieza nodo:2347 / Elemento padre: 2346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2347)).setAttribute("src","b.gif" );
      ((Element)v.get(2347)).setAttribute("width","8" );
      ((Element)v.get(2347)).setAttribute("height","8" );
      ((Element)v.get(2346)).appendChild((Element)v.get(2347));
      /* Termina nodo:2347   */
      /* Termina nodo:2346   */
      /* Termina nodo:2329   */

      /* Empieza nodo:2348 / Elemento padre: 2317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2317)).appendChild((Element)v.get(2348));

      /* Empieza nodo:2349 / Elemento padre: 2348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2349)).setAttribute("colspan","4" );
      ((Element)v.get(2348)).appendChild((Element)v.get(2349));

      /* Empieza nodo:2350 / Elemento padre: 2349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2350)).setAttribute("src","b.gif" );
      ((Element)v.get(2350)).setAttribute("width","8" );
      ((Element)v.get(2350)).setAttribute("height","8" );
      ((Element)v.get(2349)).appendChild((Element)v.get(2350));
      /* Termina nodo:2350   */
      /* Termina nodo:2349   */
      /* Termina nodo:2348   */
      /* Termina nodo:2317   */
      /* Termina nodo:2269   */
      /* Termina nodo:2268   */

      /* Empieza nodo:2351 / Elemento padre: 2265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2265)).appendChild((Element)v.get(2351));

      /* Empieza nodo:2352 / Elemento padre: 2351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2352)).setAttribute("src","b.gif" );
      ((Element)v.get(2351)).appendChild((Element)v.get(2352));
      /* Termina nodo:2352   */
      /* Termina nodo:2351   */
      /* Termina nodo:2265   */

      /* Empieza nodo:2353 / Elemento padre: 2264   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2264)).appendChild((Element)v.get(2353));

      /* Empieza nodo:2354 / Elemento padre: 2353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2354)).setAttribute("width","12" );
      ((Element)v.get(2354)).setAttribute("align","center" );
      ((Element)v.get(2353)).appendChild((Element)v.get(2354));

      /* Empieza nodo:2355 / Elemento padre: 2354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2355)).setAttribute("src","b.gif" );
      ((Element)v.get(2355)).setAttribute("width","12" );
      ((Element)v.get(2355)).setAttribute("height","15" );
      ((Element)v.get(2354)).appendChild((Element)v.get(2355));
      /* Termina nodo:2355   */
      /* Termina nodo:2354   */

      /* Empieza nodo:2356 / Elemento padre: 2353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2356)).setAttribute("width","756" );
   }

   private void getXML9270(Document doc) {
      ((Element)v.get(2353)).appendChild((Element)v.get(2356));

      /* Empieza nodo:2357 / Elemento padre: 2356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2357)).setAttribute("src","b.gif" );
      ((Element)v.get(2356)).appendChild((Element)v.get(2357));
      /* Termina nodo:2357   */
      /* Termina nodo:2356   */

      /* Empieza nodo:2358 / Elemento padre: 2353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2358)).setAttribute("width","12" );
      ((Element)v.get(2353)).appendChild((Element)v.get(2358));

      /* Empieza nodo:2359 / Elemento padre: 2358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2359)).setAttribute("src","b.gif" );
      ((Element)v.get(2359)).setAttribute("width","12" );
      ((Element)v.get(2359)).setAttribute("height","1" );
      ((Element)v.get(2358)).appendChild((Element)v.get(2359));
      /* Termina nodo:2359   */
      /* Termina nodo:2358   */
      /* Termina nodo:2353   */
      /* Termina nodo:2264   */

      /* Empieza nodo:2360 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2360)).setAttribute("width","100%" );
      ((Element)v.get(2360)).setAttribute("border","0" );
      ((Element)v.get(2360)).setAttribute("align","center" );
      ((Element)v.get(2360)).setAttribute("cellspacing","0" );
      ((Element)v.get(2360)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(2360));

      /* Empieza nodo:2361 / Elemento padre: 2360   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2360)).appendChild((Element)v.get(2361));

      /* Empieza nodo:2362 / Elemento padre: 2361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2361)).appendChild((Element)v.get(2362));

      /* Empieza nodo:2363 / Elemento padre: 2362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2363)).setAttribute("src","b.gif" );
      ((Element)v.get(2363)).setAttribute("width","8" );
      ((Element)v.get(2363)).setAttribute("height","8" );
      ((Element)v.get(2362)).appendChild((Element)v.get(2363));
      /* Termina nodo:2363   */
      /* Termina nodo:2362   */

      /* Empieza nodo:2364 / Elemento padre: 2361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2364)).setAttribute("width","100%" );
      ((Element)v.get(2361)).appendChild((Element)v.get(2364));

      /* Empieza nodo:2365 / Elemento padre: 2364   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(2364)).appendChild((Element)v.get(2365));

      /* Empieza nodo:2366 / Elemento padre: 2365   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(2366)).setAttribute("class","legend" );
      ((Element)v.get(2365)).appendChild((Element)v.get(2366));

      /* Empieza nodo:2367 / Elemento padre: 2366   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2367)).setAttribute("nombre","lblComunicacionParticipantes" );
      ((Element)v.get(2367)).setAttribute("alto","13" );
      ((Element)v.get(2367)).setAttribute("filas","1" );
      ((Element)v.get(2367)).setAttribute("valor","" );
      ((Element)v.get(2367)).setAttribute("id","legend" );
      ((Element)v.get(2367)).setAttribute("cod","00466" );
      ((Element)v.get(2366)).appendChild((Element)v.get(2367));
      /* Termina nodo:2367   */
      /* Termina nodo:2366   */

      /* Empieza nodo:2368 / Elemento padre: 2365   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2368)).setAttribute("width","100%" );
      ((Element)v.get(2368)).setAttribute("border","0" );
      ((Element)v.get(2368)).setAttribute("align","center" );
      ((Element)v.get(2368)).setAttribute("cellspacing","0" );
      ((Element)v.get(2368)).setAttribute("cellpadding","0" );
      ((Element)v.get(2365)).appendChild((Element)v.get(2368));

      /* Empieza nodo:2369 / Elemento padre: 2368   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2368)).appendChild((Element)v.get(2369));

      /* Empieza nodo:2370 / Elemento padre: 2369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2370)).setAttribute("colspan","3" );
      ((Element)v.get(2369)).appendChild((Element)v.get(2370));

      /* Empieza nodo:2371 / Elemento padre: 2370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2371)).setAttribute("src","b.gif" );
      ((Element)v.get(2371)).setAttribute("width","8" );
      ((Element)v.get(2371)).setAttribute("height","8" );
      ((Element)v.get(2370)).appendChild((Element)v.get(2371));
      /* Termina nodo:2371   */
      /* Termina nodo:2370   */
      /* Termina nodo:2369   */

      /* Empieza nodo:2372 / Elemento padre: 2368   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2368)).appendChild((Element)v.get(2372));

      /* Empieza nodo:2373 / Elemento padre: 2372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2372)).appendChild((Element)v.get(2373));

      /* Empieza nodo:2374 / Elemento padre: 2373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2374)).setAttribute("src","b.gif" );
      ((Element)v.get(2374)).setAttribute("width","8" );
      ((Element)v.get(2374)).setAttribute("height","8" );
      ((Element)v.get(2373)).appendChild((Element)v.get(2374));
      /* Termina nodo:2374   */
      /* Termina nodo:2373   */

      /* Empieza nodo:2375 / Elemento padre: 2372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2372)).appendChild((Element)v.get(2375));

      /* Empieza nodo:2376 / Elemento padre: 2375   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2376)).setAttribute("nombre","lblCodigoComunicacionParticipantes" );
      ((Element)v.get(2376)).setAttribute("alto","13" );
      ((Element)v.get(2376)).setAttribute("filas","1" );
      ((Element)v.get(2376)).setAttribute("valor","" );
      ((Element)v.get(2376)).setAttribute("id","datosTitle" );
      ((Element)v.get(2376)).setAttribute("cod","8" );
      ((Element)v.get(2375)).appendChild((Element)v.get(2376));
      /* Termina nodo:2376   */
      /* Termina nodo:2375   */

      /* Empieza nodo:2377 / Elemento padre: 2372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2372)).appendChild((Element)v.get(2377));

      /* Empieza nodo:2378 / Elemento padre: 2377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2378)).setAttribute("src","b.gif" );
      ((Element)v.get(2378)).setAttribute("width","25" );
      ((Element)v.get(2378)).setAttribute("height","8" );
      ((Element)v.get(2377)).appendChild((Element)v.get(2378));
      /* Termina nodo:2378   */
      /* Termina nodo:2377   */

      /* Empieza nodo:2379 / Elemento padre: 2372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2372)).appendChild((Element)v.get(2379));

      /* Empieza nodo:2380 / Elemento padre: 2379   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML9360(Document doc) {
      ((Element)v.get(2380)).setAttribute("nombre","lblVisibleComunicacionParticipantes" );
      ((Element)v.get(2380)).setAttribute("alto","13" );
      ((Element)v.get(2380)).setAttribute("filas","1" );
      ((Element)v.get(2380)).setAttribute("valor","" );
      ((Element)v.get(2380)).setAttribute("id","datosTitle" );
      ((Element)v.get(2380)).setAttribute("cod","1038" );
      ((Element)v.get(2379)).appendChild((Element)v.get(2380));
      /* Termina nodo:2380   */
      /* Termina nodo:2379   */

      /* Empieza nodo:2381 / Elemento padre: 2372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2372)).appendChild((Element)v.get(2381));

      /* Empieza nodo:2382 / Elemento padre: 2381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2382)).setAttribute("src","b.gif" );
      ((Element)v.get(2382)).setAttribute("width","25" );
      ((Element)v.get(2382)).setAttribute("height","8" );
      ((Element)v.get(2381)).appendChild((Element)v.get(2382));
      /* Termina nodo:2382   */
      /* Termina nodo:2381   */

      /* Empieza nodo:2383 / Elemento padre: 2372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2372)).appendChild((Element)v.get(2383));

      /* Empieza nodo:2384 / Elemento padre: 2383   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2384)).setAttribute("nombre","lblObligatorioComunicacionParticipantes" );
      ((Element)v.get(2384)).setAttribute("alto","13" );
      ((Element)v.get(2384)).setAttribute("filas","1" );
      ((Element)v.get(2384)).setAttribute("valor","" );
      ((Element)v.get(2384)).setAttribute("id","datosTitle" );
      ((Element)v.get(2384)).setAttribute("cod","949" );
      ((Element)v.get(2383)).appendChild((Element)v.get(2384));
      /* Termina nodo:2384   */
      /* Termina nodo:2383   */

      /* Empieza nodo:2385 / Elemento padre: 2372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2372)).appendChild((Element)v.get(2385));

      /* Empieza nodo:2386 / Elemento padre: 2385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2386)).setAttribute("src","b.gif" );
      ((Element)v.get(2386)).setAttribute("width","25" );
      ((Element)v.get(2386)).setAttribute("height","8" );
      ((Element)v.get(2385)).appendChild((Element)v.get(2386));
      /* Termina nodo:2386   */
      /* Termina nodo:2385   */

      /* Empieza nodo:2387 / Elemento padre: 2372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2372)).appendChild((Element)v.get(2387));

      /* Empieza nodo:2388 / Elemento padre: 2387   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2388)).setAttribute("nombre","lblModificableComunicacionParticipantes" );
      ((Element)v.get(2388)).setAttribute("alto","13" );
      ((Element)v.get(2388)).setAttribute("filas","1" );
      ((Element)v.get(2388)).setAttribute("valor","" );
      ((Element)v.get(2388)).setAttribute("id","datosTitle" );
      ((Element)v.get(2388)).setAttribute("cod","914" );
      ((Element)v.get(2387)).appendChild((Element)v.get(2388));
      /* Termina nodo:2388   */
      /* Termina nodo:2387   */

      /* Empieza nodo:2389 / Elemento padre: 2372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2389)).setAttribute("width","100%" );
      ((Element)v.get(2372)).appendChild((Element)v.get(2389));

      /* Empieza nodo:2390 / Elemento padre: 2389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2390)).setAttribute("src","b.gif" );
      ((Element)v.get(2390)).setAttribute("width","8" );
      ((Element)v.get(2390)).setAttribute("height","8" );
      ((Element)v.get(2389)).appendChild((Element)v.get(2390));
      /* Termina nodo:2390   */
      /* Termina nodo:2389   */
      /* Termina nodo:2372   */

      /* Empieza nodo:2391 / Elemento padre: 2368   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2368)).appendChild((Element)v.get(2391));

      /* Empieza nodo:2392 / Elemento padre: 2391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2391)).appendChild((Element)v.get(2392));

      /* Empieza nodo:2393 / Elemento padre: 2392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2393)).setAttribute("src","b.gif" );
      ((Element)v.get(2393)).setAttribute("width","8" );
      ((Element)v.get(2393)).setAttribute("height","8" );
      ((Element)v.get(2392)).appendChild((Element)v.get(2393));
      /* Termina nodo:2393   */
      /* Termina nodo:2392   */

      /* Empieza nodo:2394 / Elemento padre: 2391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2391)).appendChild((Element)v.get(2394));

      /* Empieza nodo:2395 / Elemento padre: 2394   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2395)).setAttribute("nombre","lbldtCodigoComunicacionParticipantes" );
      ((Element)v.get(2395)).setAttribute("alto","13" );
      ((Element)v.get(2395)).setAttribute("filas","1" );
      ((Element)v.get(2395)).setAttribute("valor","31" );
      ((Element)v.get(2395)).setAttribute("id","datosCampos" );
      ((Element)v.get(2394)).appendChild((Element)v.get(2395));
      /* Termina nodo:2395   */
      /* Termina nodo:2394   */

      /* Empieza nodo:2396 / Elemento padre: 2391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2391)).appendChild((Element)v.get(2396));

      /* Empieza nodo:2397 / Elemento padre: 2396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2397)).setAttribute("src","b.gif" );
      ((Element)v.get(2397)).setAttribute("width","25" );
      ((Element)v.get(2397)).setAttribute("height","8" );
      ((Element)v.get(2396)).appendChild((Element)v.get(2397));
      /* Termina nodo:2397   */
      /* Termina nodo:2396   */

      /* Empieza nodo:2398 / Elemento padre: 2391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2391)).appendChild((Element)v.get(2398));

      /* Empieza nodo:2399 / Elemento padre: 2398   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2399)).setAttribute("nombre","ckVisibleComunicacionParticipantes" );
      ((Element)v.get(2399)).setAttribute("id","datosCampos" );
      ((Element)v.get(2399)).setAttribute("onclick","cambiaObli(29)" );
      ((Element)v.get(2399)).setAttribute("check","S" );
      ((Element)v.get(2398)).appendChild((Element)v.get(2399));
      /* Termina nodo:2399   */
      /* Termina nodo:2398   */

      /* Empieza nodo:2400 / Elemento padre: 2391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2391)).appendChild((Element)v.get(2400));

      /* Empieza nodo:2401 / Elemento padre: 2400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2401)).setAttribute("src","b.gif" );
      ((Element)v.get(2401)).setAttribute("width","25" );
      ((Element)v.get(2401)).setAttribute("height","8" );
      ((Element)v.get(2400)).appendChild((Element)v.get(2401));
      /* Termina nodo:2401   */
      /* Termina nodo:2400   */

      /* Empieza nodo:2402 / Elemento padre: 2391   */
      v.add(doc.createElement("td"));
   }

   private void getXML9450(Document doc) {
      ((Element)v.get(2391)).appendChild((Element)v.get(2402));

      /* Empieza nodo:2403 / Elemento padre: 2402   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2403)).setAttribute("nombre","ckObligatorioComunicacionParticipantes" );
      ((Element)v.get(2403)).setAttribute("id","datosCampos" );
      ((Element)v.get(2403)).setAttribute("onclick","" );
      ((Element)v.get(2403)).setAttribute("check","N" );
      ((Element)v.get(2402)).appendChild((Element)v.get(2403));
      /* Termina nodo:2403   */
      /* Termina nodo:2402   */

      /* Empieza nodo:2404 / Elemento padre: 2391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2391)).appendChild((Element)v.get(2404));

      /* Empieza nodo:2405 / Elemento padre: 2404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2405)).setAttribute("src","b.gif" );
      ((Element)v.get(2405)).setAttribute("width","25" );
      ((Element)v.get(2405)).setAttribute("height","8" );
      ((Element)v.get(2404)).appendChild((Element)v.get(2405));
      /* Termina nodo:2405   */
      /* Termina nodo:2404   */

      /* Empieza nodo:2406 / Elemento padre: 2391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2391)).appendChild((Element)v.get(2406));

      /* Empieza nodo:2407 / Elemento padre: 2406   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2407)).setAttribute("nombre","ckModificableComunicacionParticipantes" );
      ((Element)v.get(2407)).setAttribute("id","datosCampos" );
      ((Element)v.get(2407)).setAttribute("onclick","" );
      ((Element)v.get(2407)).setAttribute("check","S" );
      ((Element)v.get(2406)).appendChild((Element)v.get(2407));
      /* Termina nodo:2407   */
      /* Termina nodo:2406   */

      /* Empieza nodo:2408 / Elemento padre: 2391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2408)).setAttribute("width","100%" );
      ((Element)v.get(2391)).appendChild((Element)v.get(2408));

      /* Empieza nodo:2409 / Elemento padre: 2408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2409)).setAttribute("src","b.gif" );
      ((Element)v.get(2409)).setAttribute("width","8" );
      ((Element)v.get(2409)).setAttribute("height","8" );
      ((Element)v.get(2408)).appendChild((Element)v.get(2409));
      /* Termina nodo:2409   */
      /* Termina nodo:2408   */
      /* Termina nodo:2391   */

      /* Empieza nodo:2410 / Elemento padre: 2368   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2368)).appendChild((Element)v.get(2410));

      /* Empieza nodo:2411 / Elemento padre: 2410   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2411)).setAttribute("colspan","4" );
      ((Element)v.get(2410)).appendChild((Element)v.get(2411));

      /* Empieza nodo:2412 / Elemento padre: 2411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2412)).setAttribute("src","b.gif" );
      ((Element)v.get(2412)).setAttribute("width","8" );
      ((Element)v.get(2412)).setAttribute("height","8" );
      ((Element)v.get(2411)).appendChild((Element)v.get(2412));
      /* Termina nodo:2412   */
      /* Termina nodo:2411   */
      /* Termina nodo:2410   */
      /* Termina nodo:2368   */

      /* Empieza nodo:2413 / Elemento padre: 2365   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2413)).setAttribute("width","100%" );
      ((Element)v.get(2413)).setAttribute("border","0" );
      ((Element)v.get(2413)).setAttribute("align","center" );
      ((Element)v.get(2413)).setAttribute("cellspacing","0" );
      ((Element)v.get(2413)).setAttribute("cellpadding","0" );
      ((Element)v.get(2365)).appendChild((Element)v.get(2413));

      /* Empieza nodo:2414 / Elemento padre: 2413   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2413)).appendChild((Element)v.get(2414));

      /* Empieza nodo:2415 / Elemento padre: 2414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2414)).appendChild((Element)v.get(2415));

      /* Empieza nodo:2416 / Elemento padre: 2415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2416)).setAttribute("src","b.gif" );
      ((Element)v.get(2416)).setAttribute("width","8" );
      ((Element)v.get(2416)).setAttribute("height","8" );
      ((Element)v.get(2415)).appendChild((Element)v.get(2416));
      /* Termina nodo:2416   */
      /* Termina nodo:2415   */

      /* Empieza nodo:2417 / Elemento padre: 2414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2414)).appendChild((Element)v.get(2417));

      /* Empieza nodo:2418 / Elemento padre: 2417   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2418)).setAttribute("nombre","lblValoresPosiblesComunicacionParticipantes" );
      ((Element)v.get(2418)).setAttribute("alto","13" );
      ((Element)v.get(2418)).setAttribute("filas","1" );
      ((Element)v.get(2418)).setAttribute("valor","" );
      ((Element)v.get(2418)).setAttribute("id","datosTitle" );
      ((Element)v.get(2418)).setAttribute("cod","1022" );
      ((Element)v.get(2417)).appendChild((Element)v.get(2418));
      /* Termina nodo:2418   */
      /* Termina nodo:2417   */

      /* Empieza nodo:2419 / Elemento padre: 2414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2414)).appendChild((Element)v.get(2419));

      /* Empieza nodo:2420 / Elemento padre: 2419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2420)).setAttribute("src","b.gif" );
      ((Element)v.get(2420)).setAttribute("width","25" );
      ((Element)v.get(2420)).setAttribute("height","8" );
      ((Element)v.get(2419)).appendChild((Element)v.get(2420));
      /* Termina nodo:2420   */
      /* Termina nodo:2419   */

      /* Empieza nodo:2421 / Elemento padre: 2414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2414)).appendChild((Element)v.get(2421));

      /* Empieza nodo:2422 / Elemento padre: 2421   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2422)).setAttribute("nombre","lblValoresDefectoComunicacionParticipantes" );
      ((Element)v.get(2422)).setAttribute("alto","13" );
      ((Element)v.get(2422)).setAttribute("filas","1" );
      ((Element)v.get(2422)).setAttribute("valor","" );
      ((Element)v.get(2422)).setAttribute("id","datosTitle" );
      ((Element)v.get(2422)).setAttribute("cod","1286" );
      ((Element)v.get(2421)).appendChild((Element)v.get(2422));
      /* Termina nodo:2422   */
      /* Termina nodo:2421   */

      /* Empieza nodo:2423 / Elemento padre: 2414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2423)).setAttribute("width","100%" );
      ((Element)v.get(2414)).appendChild((Element)v.get(2423));

      /* Empieza nodo:2424 / Elemento padre: 2423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2424)).setAttribute("src","b.gif" );
      ((Element)v.get(2424)).setAttribute("width","8" );
      ((Element)v.get(2424)).setAttribute("height","8" );
   }

   private void getXML9540(Document doc) {
      ((Element)v.get(2423)).appendChild((Element)v.get(2424));
      /* Termina nodo:2424   */
      /* Termina nodo:2423   */
      /* Termina nodo:2414   */

      /* Empieza nodo:2425 / Elemento padre: 2413   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2413)).appendChild((Element)v.get(2425));

      /* Empieza nodo:2426 / Elemento padre: 2425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2425)).appendChild((Element)v.get(2426));

      /* Empieza nodo:2427 / Elemento padre: 2426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2427)).setAttribute("src","b.gif" );
      ((Element)v.get(2427)).setAttribute("width","8" );
      ((Element)v.get(2427)).setAttribute("height","8" );
      ((Element)v.get(2426)).appendChild((Element)v.get(2427));
      /* Termina nodo:2427   */
      /* Termina nodo:2426   */

      /* Empieza nodo:2428 / Elemento padre: 2425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2428)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2425)).appendChild((Element)v.get(2428));

      /* Empieza nodo:2429 / Elemento padre: 2428   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2429)).setAttribute("nombre","cbValoresPosiblesComunicacionParticipantes" );
      ((Element)v.get(2429)).setAttribute("onchange","comunicacionOnChange();" );
      ((Element)v.get(2429)).setAttribute("id","datosCampos" );
      ((Element)v.get(2429)).setAttribute("size","3" );
      ((Element)v.get(2429)).setAttribute("multiple","S" );
      ((Element)v.get(2429)).setAttribute("req","S" );
      ((Element)v.get(2429)).setAttribute("valorinicial","" );
      ((Element)v.get(2429)).setAttribute("textoinicial","" );
      ((Element)v.get(2428)).appendChild((Element)v.get(2429));

      /* Empieza nodo:2430 / Elemento padre: 2429   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2429)).appendChild((Element)v.get(2430));

      /* Empieza nodo:2431 / Elemento padre: 2430   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2431)).setAttribute("ID","1" );
      ((Element)v.get(2430)).appendChild((Element)v.get(2431));

      /* Empieza nodo:2432 / Elemento padre: 2431   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2432)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2432)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2432)).setAttribute("VALOR","1" );
      ((Element)v.get(2431)).appendChild((Element)v.get(2432));
      /* Termina nodo:2432   */

      /* Empieza nodo:2433 / Elemento padre: 2431   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2433)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2433)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2433)).setAttribute("VALOR","Si" );
      ((Element)v.get(2431)).appendChild((Element)v.get(2433));
      /* Termina nodo:2433   */
      /* Termina nodo:2431   */

      /* Empieza nodo:2434 / Elemento padre: 2430   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2434)).setAttribute("ID","2" );
      ((Element)v.get(2430)).appendChild((Element)v.get(2434));

      /* Empieza nodo:2435 / Elemento padre: 2434   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2435)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2435)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2435)).setAttribute("VALOR","0" );
      ((Element)v.get(2434)).appendChild((Element)v.get(2435));
      /* Termina nodo:2435   */

      /* Empieza nodo:2436 / Elemento padre: 2434   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2436)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2436)).setAttribute("VALOR","No" );
      ((Element)v.get(2434)).appendChild((Element)v.get(2436));
      /* Termina nodo:2436   */
      /* Termina nodo:2434   */
      /* Termina nodo:2430   */
      /* Termina nodo:2429   */
      /* Termina nodo:2428   */

      /* Empieza nodo:2437 / Elemento padre: 2425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2425)).appendChild((Element)v.get(2437));

      /* Empieza nodo:2438 / Elemento padre: 2437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2438)).setAttribute("src","b.gif" );
      ((Element)v.get(2438)).setAttribute("width","25" );
      ((Element)v.get(2438)).setAttribute("height","8" );
      ((Element)v.get(2437)).appendChild((Element)v.get(2438));
      /* Termina nodo:2438   */
      /* Termina nodo:2437   */

      /* Empieza nodo:2439 / Elemento padre: 2425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2439)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2439)).setAttribute("valign","top" );
      ((Element)v.get(2425)).appendChild((Element)v.get(2439));

      /* Empieza nodo:2440 / Elemento padre: 2439   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2440)).setAttribute("nombre","cbValoresDefectoComunicacionParticipantes" );
      ((Element)v.get(2440)).setAttribute("id","datosCampos" );
      ((Element)v.get(2440)).setAttribute("size","1" );
      ((Element)v.get(2440)).setAttribute("multiple","N" );
      ((Element)v.get(2440)).setAttribute("req","N" );
      ((Element)v.get(2440)).setAttribute("valorinicial","" );
      ((Element)v.get(2440)).setAttribute("textoinicial","" );
      ((Element)v.get(2439)).appendChild((Element)v.get(2440));

      /* Empieza nodo:2441 / Elemento padre: 2440   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2440)).appendChild((Element)v.get(2441));
      /* Termina nodo:2441   */
      /* Termina nodo:2440   */
      /* Termina nodo:2439   */

      /* Empieza nodo:2442 / Elemento padre: 2425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2442)).setAttribute("width","100%" );
      ((Element)v.get(2425)).appendChild((Element)v.get(2442));

      /* Empieza nodo:2443 / Elemento padre: 2442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2443)).setAttribute("src","b.gif" );
      ((Element)v.get(2443)).setAttribute("width","8" );
      ((Element)v.get(2443)).setAttribute("height","8" );
      ((Element)v.get(2442)).appendChild((Element)v.get(2443));
      /* Termina nodo:2443   */
      /* Termina nodo:2442   */
      /* Termina nodo:2425   */

      /* Empieza nodo:2444 / Elemento padre: 2413   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2413)).appendChild((Element)v.get(2444));

      /* Empieza nodo:2445 / Elemento padre: 2444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2445)).setAttribute("colspan","4" );
      ((Element)v.get(2444)).appendChild((Element)v.get(2445));

      /* Empieza nodo:2446 / Elemento padre: 2445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2446)).setAttribute("src","b.gif" );
      ((Element)v.get(2446)).setAttribute("width","8" );
      ((Element)v.get(2446)).setAttribute("height","8" );
   }

   private void getXML9630(Document doc) {
      ((Element)v.get(2445)).appendChild((Element)v.get(2446));
      /* Termina nodo:2446   */
      /* Termina nodo:2445   */
      /* Termina nodo:2444   */
      /* Termina nodo:2413   */
      /* Termina nodo:2365   */
      /* Termina nodo:2364   */

      /* Empieza nodo:2447 / Elemento padre: 2361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2361)).appendChild((Element)v.get(2447));

      /* Empieza nodo:2448 / Elemento padre: 2447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2448)).setAttribute("src","b.gif" );
      ((Element)v.get(2447)).appendChild((Element)v.get(2448));
      /* Termina nodo:2448   */
      /* Termina nodo:2447   */
      /* Termina nodo:2361   */

      /* Empieza nodo:2449 / Elemento padre: 2360   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2360)).appendChild((Element)v.get(2449));

      /* Empieza nodo:2450 / Elemento padre: 2449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2450)).setAttribute("width","12" );
      ((Element)v.get(2450)).setAttribute("align","center" );
      ((Element)v.get(2449)).appendChild((Element)v.get(2450));

      /* Empieza nodo:2451 / Elemento padre: 2450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2451)).setAttribute("src","b.gif" );
      ((Element)v.get(2451)).setAttribute("width","12" );
      ((Element)v.get(2451)).setAttribute("height","15" );
      ((Element)v.get(2450)).appendChild((Element)v.get(2451));
      /* Termina nodo:2451   */
      /* Termina nodo:2450   */

      /* Empieza nodo:2452 / Elemento padre: 2449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2452)).setAttribute("width","756" );
      ((Element)v.get(2449)).appendChild((Element)v.get(2452));

      /* Empieza nodo:2453 / Elemento padre: 2452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2453)).setAttribute("src","b.gif" );
      ((Element)v.get(2452)).appendChild((Element)v.get(2453));
      /* Termina nodo:2453   */
      /* Termina nodo:2452   */

      /* Empieza nodo:2454 / Elemento padre: 2449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2454)).setAttribute("width","12" );
      ((Element)v.get(2449)).appendChild((Element)v.get(2454));

      /* Empieza nodo:2455 / Elemento padre: 2454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2455)).setAttribute("src","b.gif" );
      ((Element)v.get(2455)).setAttribute("width","12" );
      ((Element)v.get(2455)).setAttribute("height","1" );
      ((Element)v.get(2454)).appendChild((Element)v.get(2455));
      /* Termina nodo:2455   */
      /* Termina nodo:2454   */
      /* Termina nodo:2449   */
      /* Termina nodo:2360   */

      /* Empieza nodo:2456 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2456)).setAttribute("width","100%" );
      ((Element)v.get(2456)).setAttribute("border","0" );
      ((Element)v.get(2456)).setAttribute("align","center" );
      ((Element)v.get(2456)).setAttribute("cellspacing","0" );
      ((Element)v.get(2456)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(2456));

      /* Empieza nodo:2457 / Elemento padre: 2456   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2456)).appendChild((Element)v.get(2457));

      /* Empieza nodo:2458 / Elemento padre: 2457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2457)).appendChild((Element)v.get(2458));

      /* Empieza nodo:2459 / Elemento padre: 2458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2459)).setAttribute("src","b.gif" );
      ((Element)v.get(2459)).setAttribute("width","8" );
      ((Element)v.get(2459)).setAttribute("height","8" );
      ((Element)v.get(2458)).appendChild((Element)v.get(2459));
      /* Termina nodo:2459   */
      /* Termina nodo:2458   */

      /* Empieza nodo:2460 / Elemento padre: 2457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2460)).setAttribute("width","100%" );
      ((Element)v.get(2457)).appendChild((Element)v.get(2460));

      /* Empieza nodo:2461 / Elemento padre: 2460   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(2460)).appendChild((Element)v.get(2461));

      /* Empieza nodo:2462 / Elemento padre: 2461   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(2462)).setAttribute("class","legend" );
      ((Element)v.get(2461)).appendChild((Element)v.get(2462));

      /* Empieza nodo:2463 / Elemento padre: 2462   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2463)).setAttribute("nombre","lblIndicadorCulminacion" );
      ((Element)v.get(2463)).setAttribute("alto","13" );
      ((Element)v.get(2463)).setAttribute("filas","1" );
      ((Element)v.get(2463)).setAttribute("valor","" );
      ((Element)v.get(2463)).setAttribute("id","legend" );
      ((Element)v.get(2463)).setAttribute("cod","00467" );
      ((Element)v.get(2462)).appendChild((Element)v.get(2463));
      /* Termina nodo:2463   */
      /* Termina nodo:2462   */

      /* Empieza nodo:2464 / Elemento padre: 2461   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2464)).setAttribute("width","100%" );
      ((Element)v.get(2464)).setAttribute("border","0" );
      ((Element)v.get(2464)).setAttribute("align","center" );
      ((Element)v.get(2464)).setAttribute("cellspacing","0" );
      ((Element)v.get(2464)).setAttribute("cellpadding","0" );
      ((Element)v.get(2461)).appendChild((Element)v.get(2464));

      /* Empieza nodo:2465 / Elemento padre: 2464   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2464)).appendChild((Element)v.get(2465));

      /* Empieza nodo:2466 / Elemento padre: 2465   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2466)).setAttribute("colspan","3" );
      ((Element)v.get(2465)).appendChild((Element)v.get(2466));

      /* Empieza nodo:2467 / Elemento padre: 2466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2467)).setAttribute("src","b.gif" );
      ((Element)v.get(2467)).setAttribute("width","8" );
      ((Element)v.get(2467)).setAttribute("height","8" );
      ((Element)v.get(2466)).appendChild((Element)v.get(2467));
      /* Termina nodo:2467   */
      /* Termina nodo:2466   */
      /* Termina nodo:2465   */

      /* Empieza nodo:2468 / Elemento padre: 2464   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2464)).appendChild((Element)v.get(2468));

      /* Empieza nodo:2469 / Elemento padre: 2468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2468)).appendChild((Element)v.get(2469));

      /* Empieza nodo:2470 / Elemento padre: 2469   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2470)).setAttribute("src","b.gif" );
      ((Element)v.get(2470)).setAttribute("width","8" );
      ((Element)v.get(2470)).setAttribute("height","8" );
      ((Element)v.get(2469)).appendChild((Element)v.get(2470));
      /* Termina nodo:2470   */
      /* Termina nodo:2469   */

      /* Empieza nodo:2471 / Elemento padre: 2468   */
      v.add(doc.createElement("td"));
   }

   private void getXML9720(Document doc) {
      ((Element)v.get(2468)).appendChild((Element)v.get(2471));

      /* Empieza nodo:2472 / Elemento padre: 2471   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2472)).setAttribute("nombre","lblCodigoIndicadorCulminacion" );
      ((Element)v.get(2472)).setAttribute("alto","13" );
      ((Element)v.get(2472)).setAttribute("filas","1" );
      ((Element)v.get(2472)).setAttribute("valor","" );
      ((Element)v.get(2472)).setAttribute("id","datosTitle" );
      ((Element)v.get(2472)).setAttribute("cod","8" );
      ((Element)v.get(2471)).appendChild((Element)v.get(2472));
      /* Termina nodo:2472   */
      /* Termina nodo:2471   */

      /* Empieza nodo:2473 / Elemento padre: 2468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2468)).appendChild((Element)v.get(2473));

      /* Empieza nodo:2474 / Elemento padre: 2473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2474)).setAttribute("src","b.gif" );
      ((Element)v.get(2474)).setAttribute("width","25" );
      ((Element)v.get(2474)).setAttribute("height","8" );
      ((Element)v.get(2473)).appendChild((Element)v.get(2474));
      /* Termina nodo:2474   */
      /* Termina nodo:2473   */

      /* Empieza nodo:2475 / Elemento padre: 2468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2468)).appendChild((Element)v.get(2475));

      /* Empieza nodo:2476 / Elemento padre: 2475   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2476)).setAttribute("nombre","lblVisibleIndicadorCulminacion" );
      ((Element)v.get(2476)).setAttribute("alto","13" );
      ((Element)v.get(2476)).setAttribute("filas","1" );
      ((Element)v.get(2476)).setAttribute("valor","" );
      ((Element)v.get(2476)).setAttribute("id","datosTitle" );
      ((Element)v.get(2476)).setAttribute("cod","1038" );
      ((Element)v.get(2475)).appendChild((Element)v.get(2476));
      /* Termina nodo:2476   */
      /* Termina nodo:2475   */

      /* Empieza nodo:2477 / Elemento padre: 2468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2468)).appendChild((Element)v.get(2477));

      /* Empieza nodo:2478 / Elemento padre: 2477   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2478)).setAttribute("src","b.gif" );
      ((Element)v.get(2478)).setAttribute("width","25" );
      ((Element)v.get(2478)).setAttribute("height","8" );
      ((Element)v.get(2477)).appendChild((Element)v.get(2478));
      /* Termina nodo:2478   */
      /* Termina nodo:2477   */

      /* Empieza nodo:2479 / Elemento padre: 2468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2468)).appendChild((Element)v.get(2479));

      /* Empieza nodo:2480 / Elemento padre: 2479   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2480)).setAttribute("nombre","lblObligatorioIndicadorCulminacion" );
      ((Element)v.get(2480)).setAttribute("alto","13" );
      ((Element)v.get(2480)).setAttribute("filas","1" );
      ((Element)v.get(2480)).setAttribute("valor","" );
      ((Element)v.get(2480)).setAttribute("id","datosTitle" );
      ((Element)v.get(2480)).setAttribute("cod","949" );
      ((Element)v.get(2479)).appendChild((Element)v.get(2480));
      /* Termina nodo:2480   */
      /* Termina nodo:2479   */

      /* Empieza nodo:2481 / Elemento padre: 2468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2468)).appendChild((Element)v.get(2481));

      /* Empieza nodo:2482 / Elemento padre: 2481   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2482)).setAttribute("src","b.gif" );
      ((Element)v.get(2482)).setAttribute("width","25" );
      ((Element)v.get(2482)).setAttribute("height","8" );
      ((Element)v.get(2481)).appendChild((Element)v.get(2482));
      /* Termina nodo:2482   */
      /* Termina nodo:2481   */

      /* Empieza nodo:2483 / Elemento padre: 2468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2468)).appendChild((Element)v.get(2483));

      /* Empieza nodo:2484 / Elemento padre: 2483   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2484)).setAttribute("nombre","lblModificableIndicadorCulminacion" );
      ((Element)v.get(2484)).setAttribute("alto","13" );
      ((Element)v.get(2484)).setAttribute("filas","1" );
      ((Element)v.get(2484)).setAttribute("valor","" );
      ((Element)v.get(2484)).setAttribute("id","datosTitle" );
      ((Element)v.get(2484)).setAttribute("cod","914" );
      ((Element)v.get(2483)).appendChild((Element)v.get(2484));
      /* Termina nodo:2484   */
      /* Termina nodo:2483   */

      /* Empieza nodo:2485 / Elemento padre: 2468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2485)).setAttribute("width","100%" );
      ((Element)v.get(2468)).appendChild((Element)v.get(2485));

      /* Empieza nodo:2486 / Elemento padre: 2485   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2486)).setAttribute("src","b.gif" );
      ((Element)v.get(2486)).setAttribute("width","8" );
      ((Element)v.get(2486)).setAttribute("height","8" );
      ((Element)v.get(2485)).appendChild((Element)v.get(2486));
      /* Termina nodo:2486   */
      /* Termina nodo:2485   */
      /* Termina nodo:2468   */

      /* Empieza nodo:2487 / Elemento padre: 2464   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2464)).appendChild((Element)v.get(2487));

      /* Empieza nodo:2488 / Elemento padre: 2487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2487)).appendChild((Element)v.get(2488));

      /* Empieza nodo:2489 / Elemento padre: 2488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2489)).setAttribute("src","b.gif" );
      ((Element)v.get(2489)).setAttribute("width","8" );
      ((Element)v.get(2489)).setAttribute("height","8" );
      ((Element)v.get(2488)).appendChild((Element)v.get(2489));
      /* Termina nodo:2489   */
      /* Termina nodo:2488   */

      /* Empieza nodo:2490 / Elemento padre: 2487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2487)).appendChild((Element)v.get(2490));

      /* Empieza nodo:2491 / Elemento padre: 2490   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2491)).setAttribute("nombre","lbldtCodigoIndicadorCulminacion" );
      ((Element)v.get(2491)).setAttribute("alto","13" );
      ((Element)v.get(2491)).setAttribute("filas","1" );
      ((Element)v.get(2491)).setAttribute("valor","02" );
      ((Element)v.get(2491)).setAttribute("id","datosCampos" );
      ((Element)v.get(2490)).appendChild((Element)v.get(2491));
      /* Termina nodo:2491   */
      /* Termina nodo:2490   */

      /* Empieza nodo:2492 / Elemento padre: 2487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2487)).appendChild((Element)v.get(2492));

      /* Empieza nodo:2493 / Elemento padre: 2492   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2493)).setAttribute("src","b.gif" );
   }

   private void getXML9810(Document doc) {
      ((Element)v.get(2493)).setAttribute("width","25" );
      ((Element)v.get(2493)).setAttribute("height","8" );
      ((Element)v.get(2492)).appendChild((Element)v.get(2493));
      /* Termina nodo:2493   */
      /* Termina nodo:2492   */

      /* Empieza nodo:2494 / Elemento padre: 2487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2487)).appendChild((Element)v.get(2494));

      /* Empieza nodo:2495 / Elemento padre: 2494   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2495)).setAttribute("nombre","ckVisibleIndicadorCulminacion" );
      ((Element)v.get(2495)).setAttribute("id","datosCampos" );
      ((Element)v.get(2495)).setAttribute("onclick","cambiaObli(0)" );
      ((Element)v.get(2495)).setAttribute("check","S" );
      ((Element)v.get(2494)).appendChild((Element)v.get(2495));
      /* Termina nodo:2495   */
      /* Termina nodo:2494   */

      /* Empieza nodo:2496 / Elemento padre: 2487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2487)).appendChild((Element)v.get(2496));

      /* Empieza nodo:2497 / Elemento padre: 2496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2497)).setAttribute("src","b.gif" );
      ((Element)v.get(2497)).setAttribute("width","25" );
      ((Element)v.get(2497)).setAttribute("height","8" );
      ((Element)v.get(2496)).appendChild((Element)v.get(2497));
      /* Termina nodo:2497   */
      /* Termina nodo:2496   */

      /* Empieza nodo:2498 / Elemento padre: 2487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2487)).appendChild((Element)v.get(2498));

      /* Empieza nodo:2499 / Elemento padre: 2498   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2499)).setAttribute("nombre","ckObligatorioIndicadorCulminacion" );
      ((Element)v.get(2499)).setAttribute("id","datosCampos" );
      ((Element)v.get(2499)).setAttribute("onclick","" );
      ((Element)v.get(2499)).setAttribute("check","N" );
      ((Element)v.get(2498)).appendChild((Element)v.get(2499));
      /* Termina nodo:2499   */
      /* Termina nodo:2498   */

      /* Empieza nodo:2500 / Elemento padre: 2487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2487)).appendChild((Element)v.get(2500));

      /* Empieza nodo:2501 / Elemento padre: 2500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2501)).setAttribute("src","b.gif" );
      ((Element)v.get(2501)).setAttribute("width","25" );
      ((Element)v.get(2501)).setAttribute("height","8" );
      ((Element)v.get(2500)).appendChild((Element)v.get(2501));
      /* Termina nodo:2501   */
      /* Termina nodo:2500   */

      /* Empieza nodo:2502 / Elemento padre: 2487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2487)).appendChild((Element)v.get(2502));

      /* Empieza nodo:2503 / Elemento padre: 2502   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(2503)).setAttribute("nombre","ckModificableIndicadorCulminacion" );
      ((Element)v.get(2503)).setAttribute("id","datosCampos" );
      ((Element)v.get(2503)).setAttribute("onclick","" );
      ((Element)v.get(2503)).setAttribute("check","S" );
      ((Element)v.get(2502)).appendChild((Element)v.get(2503));
      /* Termina nodo:2503   */
      /* Termina nodo:2502   */

      /* Empieza nodo:2504 / Elemento padre: 2487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2504)).setAttribute("width","100%" );
      ((Element)v.get(2487)).appendChild((Element)v.get(2504));

      /* Empieza nodo:2505 / Elemento padre: 2504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2505)).setAttribute("src","b.gif" );
      ((Element)v.get(2505)).setAttribute("width","8" );
      ((Element)v.get(2505)).setAttribute("height","8" );
      ((Element)v.get(2504)).appendChild((Element)v.get(2505));
      /* Termina nodo:2505   */
      /* Termina nodo:2504   */
      /* Termina nodo:2487   */

      /* Empieza nodo:2506 / Elemento padre: 2464   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2464)).appendChild((Element)v.get(2506));

      /* Empieza nodo:2507 / Elemento padre: 2506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2507)).setAttribute("colspan","4" );
      ((Element)v.get(2506)).appendChild((Element)v.get(2507));

      /* Empieza nodo:2508 / Elemento padre: 2507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2508)).setAttribute("src","b.gif" );
      ((Element)v.get(2508)).setAttribute("width","8" );
      ((Element)v.get(2508)).setAttribute("height","8" );
      ((Element)v.get(2507)).appendChild((Element)v.get(2508));
      /* Termina nodo:2508   */
      /* Termina nodo:2507   */
      /* Termina nodo:2506   */
      /* Termina nodo:2464   */

      /* Empieza nodo:2509 / Elemento padre: 2461   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2509)).setAttribute("width","100%" );
      ((Element)v.get(2509)).setAttribute("border","0" );
      ((Element)v.get(2509)).setAttribute("align","center" );
      ((Element)v.get(2509)).setAttribute("cellspacing","0" );
      ((Element)v.get(2509)).setAttribute("cellpadding","0" );
      ((Element)v.get(2461)).appendChild((Element)v.get(2509));

      /* Empieza nodo:2510 / Elemento padre: 2509   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2509)).appendChild((Element)v.get(2510));

      /* Empieza nodo:2511 / Elemento padre: 2510   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2510)).appendChild((Element)v.get(2511));

      /* Empieza nodo:2512 / Elemento padre: 2511   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2512)).setAttribute("src","b.gif" );
      ((Element)v.get(2512)).setAttribute("width","8" );
      ((Element)v.get(2512)).setAttribute("height","8" );
      ((Element)v.get(2511)).appendChild((Element)v.get(2512));
      /* Termina nodo:2512   */
      /* Termina nodo:2511   */

      /* Empieza nodo:2513 / Elemento padre: 2510   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2510)).appendChild((Element)v.get(2513));

      /* Empieza nodo:2514 / Elemento padre: 2513   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2514)).setAttribute("nombre","lblValoresPosiblesIndicadorCulminacion" );
      ((Element)v.get(2514)).setAttribute("alto","13" );
      ((Element)v.get(2514)).setAttribute("filas","1" );
      ((Element)v.get(2514)).setAttribute("valor","" );
      ((Element)v.get(2514)).setAttribute("id","datosTitle" );
      ((Element)v.get(2514)).setAttribute("cod","1022" );
      ((Element)v.get(2513)).appendChild((Element)v.get(2514));
      /* Termina nodo:2514   */
      /* Termina nodo:2513   */

      /* Empieza nodo:2515 / Elemento padre: 2510   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2510)).appendChild((Element)v.get(2515));

      /* Empieza nodo:2516 / Elemento padre: 2515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2516)).setAttribute("src","b.gif" );
      ((Element)v.get(2516)).setAttribute("width","25" );
   }

   private void getXML9900(Document doc) {
      ((Element)v.get(2516)).setAttribute("height","8" );
      ((Element)v.get(2515)).appendChild((Element)v.get(2516));
      /* Termina nodo:2516   */
      /* Termina nodo:2515   */

      /* Empieza nodo:2517 / Elemento padre: 2510   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2510)).appendChild((Element)v.get(2517));

      /* Empieza nodo:2518 / Elemento padre: 2517   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(2518)).setAttribute("nombre","lblValoresDefectoIndicadorCulminacion" );
      ((Element)v.get(2518)).setAttribute("alto","13" );
      ((Element)v.get(2518)).setAttribute("filas","1" );
      ((Element)v.get(2518)).setAttribute("valor","" );
      ((Element)v.get(2518)).setAttribute("id","datosTitle" );
      ((Element)v.get(2518)).setAttribute("cod","1286" );
      ((Element)v.get(2517)).appendChild((Element)v.get(2518));
      /* Termina nodo:2518   */
      /* Termina nodo:2517   */

      /* Empieza nodo:2519 / Elemento padre: 2510   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2519)).setAttribute("width","100%" );
      ((Element)v.get(2510)).appendChild((Element)v.get(2519));

      /* Empieza nodo:2520 / Elemento padre: 2519   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2520)).setAttribute("src","b.gif" );
      ((Element)v.get(2520)).setAttribute("width","8" );
      ((Element)v.get(2520)).setAttribute("height","8" );
      ((Element)v.get(2519)).appendChild((Element)v.get(2520));
      /* Termina nodo:2520   */
      /* Termina nodo:2519   */
      /* Termina nodo:2510   */

      /* Empieza nodo:2521 / Elemento padre: 2509   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2509)).appendChild((Element)v.get(2521));

      /* Empieza nodo:2522 / Elemento padre: 2521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2521)).appendChild((Element)v.get(2522));

      /* Empieza nodo:2523 / Elemento padre: 2522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2523)).setAttribute("src","b.gif" );
      ((Element)v.get(2523)).setAttribute("width","8" );
      ((Element)v.get(2523)).setAttribute("height","8" );
      ((Element)v.get(2522)).appendChild((Element)v.get(2523));
      /* Termina nodo:2523   */
      /* Termina nodo:2522   */

      /* Empieza nodo:2524 / Elemento padre: 2521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2524)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2521)).appendChild((Element)v.get(2524));

      /* Empieza nodo:2525 / Elemento padre: 2524   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2525)).setAttribute("nombre","cbValoresPosiblesIndicadorCulminacion" );
      ((Element)v.get(2525)).setAttribute("onchange","indicadorOnChange();" );
      ((Element)v.get(2525)).setAttribute("id","datosCampos" );
      ((Element)v.get(2525)).setAttribute("size","3" );
      ((Element)v.get(2525)).setAttribute("multiple","S" );
      ((Element)v.get(2525)).setAttribute("req","S" );
      ((Element)v.get(2525)).setAttribute("valorinicial","" );
      ((Element)v.get(2525)).setAttribute("textoinicial","" );
      ((Element)v.get(2524)).appendChild((Element)v.get(2525));

      /* Empieza nodo:2526 / Elemento padre: 2525   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2525)).appendChild((Element)v.get(2526));

      /* Empieza nodo:2527 / Elemento padre: 2526   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2527)).setAttribute("ID","1" );
      ((Element)v.get(2526)).appendChild((Element)v.get(2527));

      /* Empieza nodo:2528 / Elemento padre: 2527   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2528)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2528)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2528)).setAttribute("VALOR","1" );
      ((Element)v.get(2527)).appendChild((Element)v.get(2528));
      /* Termina nodo:2528   */

      /* Empieza nodo:2529 / Elemento padre: 2527   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2529)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2529)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2529)).setAttribute("VALOR","Si" );
      ((Element)v.get(2527)).appendChild((Element)v.get(2529));
      /* Termina nodo:2529   */
      /* Termina nodo:2527   */

      /* Empieza nodo:2530 / Elemento padre: 2526   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(2530)).setAttribute("ID","2" );
      ((Element)v.get(2526)).appendChild((Element)v.get(2530));

      /* Empieza nodo:2531 / Elemento padre: 2530   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2531)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(2531)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2531)).setAttribute("VALOR","0" );
      ((Element)v.get(2530)).appendChild((Element)v.get(2531));
      /* Termina nodo:2531   */

      /* Empieza nodo:2532 / Elemento padre: 2530   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2532)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(2532)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2532)).setAttribute("VALOR","No" );
      ((Element)v.get(2530)).appendChild((Element)v.get(2532));
      /* Termina nodo:2532   */
      /* Termina nodo:2530   */
      /* Termina nodo:2526   */
      /* Termina nodo:2525   */
      /* Termina nodo:2524   */

      /* Empieza nodo:2533 / Elemento padre: 2521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2521)).appendChild((Element)v.get(2533));

      /* Empieza nodo:2534 / Elemento padre: 2533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2534)).setAttribute("src","b.gif" );
      ((Element)v.get(2534)).setAttribute("width","25" );
      ((Element)v.get(2534)).setAttribute("height","8" );
      ((Element)v.get(2533)).appendChild((Element)v.get(2534));
      /* Termina nodo:2534   */
      /* Termina nodo:2533   */

      /* Empieza nodo:2535 / Elemento padre: 2521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2535)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(2535)).setAttribute("valign","top" );
      ((Element)v.get(2521)).appendChild((Element)v.get(2535));

      /* Empieza nodo:2536 / Elemento padre: 2535   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(2536)).setAttribute("nombre","cbValoresDefectoIndicadorCulminacion" );
      ((Element)v.get(2536)).setAttribute("ontab","foco(1);" );
      ((Element)v.get(2536)).setAttribute("id","datosCampos" );
      ((Element)v.get(2536)).setAttribute("size","1" );
      ((Element)v.get(2536)).setAttribute("multiple","N" );
      ((Element)v.get(2536)).setAttribute("req","N" );
      ((Element)v.get(2536)).setAttribute("valorinicial","" );
      ((Element)v.get(2536)).setAttribute("textoinicial","" );
   }

   private void getXML9990(Document doc) {
      ((Element)v.get(2535)).appendChild((Element)v.get(2536));

      /* Empieza nodo:2537 / Elemento padre: 2536   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2536)).appendChild((Element)v.get(2537));
      /* Termina nodo:2537   */
      /* Termina nodo:2536   */
      /* Termina nodo:2535   */

      /* Empieza nodo:2538 / Elemento padre: 2521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2538)).setAttribute("width","100%" );
      ((Element)v.get(2521)).appendChild((Element)v.get(2538));

      /* Empieza nodo:2539 / Elemento padre: 2538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2539)).setAttribute("src","b.gif" );
      ((Element)v.get(2539)).setAttribute("width","8" );
      ((Element)v.get(2539)).setAttribute("height","8" );
      ((Element)v.get(2538)).appendChild((Element)v.get(2539));
      /* Termina nodo:2539   */
      /* Termina nodo:2538   */
      /* Termina nodo:2521   */

      /* Empieza nodo:2540 / Elemento padre: 2509   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2509)).appendChild((Element)v.get(2540));

      /* Empieza nodo:2541 / Elemento padre: 2540   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2541)).setAttribute("colspan","4" );
      ((Element)v.get(2540)).appendChild((Element)v.get(2541));

      /* Empieza nodo:2542 / Elemento padre: 2541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2542)).setAttribute("src","b.gif" );
      ((Element)v.get(2542)).setAttribute("width","8" );
      ((Element)v.get(2542)).setAttribute("height","8" );
      ((Element)v.get(2541)).appendChild((Element)v.get(2542));
      /* Termina nodo:2542   */
      /* Termina nodo:2541   */
      /* Termina nodo:2540   */
      /* Termina nodo:2509   */
      /* Termina nodo:2461   */
      /* Termina nodo:2460   */

      /* Empieza nodo:2543 / Elemento padre: 2457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2457)).appendChild((Element)v.get(2543));

      /* Empieza nodo:2544 / Elemento padre: 2543   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2544)).setAttribute("src","b.gif" );
      ((Element)v.get(2543)).appendChild((Element)v.get(2544));
      /* Termina nodo:2544   */
      /* Termina nodo:2543   */
      /* Termina nodo:2457   */

      /* Empieza nodo:2545 / Elemento padre: 2456   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2456)).appendChild((Element)v.get(2545));

      /* Empieza nodo:2546 / Elemento padre: 2545   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2546)).setAttribute("width","12" );
      ((Element)v.get(2546)).setAttribute("align","center" );
      ((Element)v.get(2545)).appendChild((Element)v.get(2546));

      /* Empieza nodo:2547 / Elemento padre: 2546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2547)).setAttribute("src","b.gif" );
      ((Element)v.get(2547)).setAttribute("width","12" );
      ((Element)v.get(2547)).setAttribute("height","15" );
      ((Element)v.get(2546)).appendChild((Element)v.get(2547));
      /* Termina nodo:2547   */
      /* Termina nodo:2546   */

      /* Empieza nodo:2548 / Elemento padre: 2545   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2548)).setAttribute("width","756" );
      ((Element)v.get(2545)).appendChild((Element)v.get(2548));

      /* Empieza nodo:2549 / Elemento padre: 2548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2549)).setAttribute("src","b.gif" );
      ((Element)v.get(2548)).appendChild((Element)v.get(2549));
      /* Termina nodo:2549   */
      /* Termina nodo:2548   */

      /* Empieza nodo:2550 / Elemento padre: 2545   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2550)).setAttribute("width","12" );
      ((Element)v.get(2545)).appendChild((Element)v.get(2550));

      /* Empieza nodo:2551 / Elemento padre: 2550   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2551)).setAttribute("src","b.gif" );
      ((Element)v.get(2551)).setAttribute("width","12" );
      ((Element)v.get(2551)).setAttribute("height","1" );
      ((Element)v.get(2550)).appendChild((Element)v.get(2551));
      /* Termina nodo:2551   */
      /* Termina nodo:2550   */
      /* Termina nodo:2545   */
      /* Termina nodo:2456   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:2552 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(2552));

      /* Empieza nodo:2553 / Elemento padre: 2552   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2553)).setAttribute("src","b.gif" );
      ((Element)v.get(2553)).setAttribute("width","12" );
      ((Element)v.get(2553)).setAttribute("height","12" );
      ((Element)v.get(2552)).appendChild((Element)v.get(2553));
      /* Termina nodo:2553   */
      /* Termina nodo:2552   */
      /* Termina nodo:107   */

      /* Empieza nodo:2554 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(2554));

      /* Empieza nodo:2555 / Elemento padre: 2554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2555)).setAttribute("width","12" );
      ((Element)v.get(2555)).setAttribute("align","center" );
      ((Element)v.get(2554)).appendChild((Element)v.get(2555));

      /* Empieza nodo:2556 / Elemento padre: 2555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2556)).setAttribute("src","b.gif" );
      ((Element)v.get(2556)).setAttribute("width","12" );
      ((Element)v.get(2556)).setAttribute("height","12" );
      ((Element)v.get(2555)).appendChild((Element)v.get(2556));
      /* Termina nodo:2556   */
      /* Termina nodo:2555   */

      /* Empieza nodo:2557 / Elemento padre: 2554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2557)).setAttribute("width","750" );
      ((Element)v.get(2554)).appendChild((Element)v.get(2557));

      /* Empieza nodo:2558 / Elemento padre: 2557   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2558)).setAttribute("src","b.gif" );
      ((Element)v.get(2557)).appendChild((Element)v.get(2558));
      /* Termina nodo:2558   */
      /* Termina nodo:2557   */

      /* Empieza nodo:2559 / Elemento padre: 2554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(2559)).setAttribute("width","12" );
      ((Element)v.get(2554)).appendChild((Element)v.get(2559));

      /* Empieza nodo:2560 / Elemento padre: 2559   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(2560)).setAttribute("src","b.gif" );
      ((Element)v.get(2560)).setAttribute("width","12" );
      ((Element)v.get(2560)).setAttribute("height","12" );
      ((Element)v.get(2559)).appendChild((Element)v.get(2560));
      /* Termina nodo:2560   */
      /* Termina nodo:2559   */
      /* Termina nodo:2554   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:28   */


   }

}
