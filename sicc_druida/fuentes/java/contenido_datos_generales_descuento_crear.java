
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_datos_generales_descuento_crear  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_datos_generales_descuento_crear" );
      ((Element)v.get(0)).setAttribute("cod","0644" );
      ((Element)v.get(0)).setAttribute("titulo","Ingresar valores descuento" );
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
      ((Element)v.get(3)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","utilidadesDTO.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","contenido_datos_generales_descuento_crear.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtNombreDescuento" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","942" );
      ((Element)v.get(8)).setAttribute("group","g1" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbMarca" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","6" );
      ((Element)v.get(9)).setAttribute("group","g1" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbCanal" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","7" );
      ((Element)v.get(10)).setAttribute("group","g1" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbAcceso" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","10" );
      ((Element)v.get(11)).setAttribute("group","g1" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbSubacceso" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","122" );
      ((Element)v.get(12)).setAttribute("group","g1" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbVigenciaPeriodoDesde" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1298" );
      ((Element)v.get(13)).setAttribute("group","g1" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbVigenciaPeriodoHasta" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","1299" );
      ((Element)v.get(14)).setAttribute("group","g1" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:7   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(15)).setAttribute("nombre","formulario" );
      ((Element)v.get(15)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","LPMantenimientoDTODG" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","accion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidCasoDeUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","casoDeUso" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidPais" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","varNoLimpiarSICC" );
      ((Element)v.get(23)).setAttribute("valor","true" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidDescripcionPais" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidNumDescuento" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidOidDescuento" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidDescripcion" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidOidMarca" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidOidCanal" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidAccesos" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidSubAccesos" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidOidPeriodoDesde" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidOidPeriodoHasta" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","oidCabeceraDTO" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hModificable" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","accesoOid" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","accesoDesc" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","accesoOidPadre" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","SubaccesoOid" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","SubaccesoDesc" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","SubaccesoOidPadre" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 15   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","selMarca" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","selCanal" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","selAcceso" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","selSubcceso" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","selPD" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","selPH" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidDescuentoAcumulativo" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidCulminacion" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidControlDevoluciones" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidControlAnulaciones" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidCdomunicacionAParticipantes" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidActiva" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidMorosidad" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidAfectaAFacturas" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidAfectaACuentasCorrientes" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","VisibleMarca" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","ObligatorioMarca" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","ModificableMarca" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","txtNmaximoMarca" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","VisibleCanal" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","ObligatorioCanal" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","ModificableCanal" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","txtNmaximoCanal" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","VisibleAcceso" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","ObligatorioAcceso" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","ModificableAcceso" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","txtNmaximoAcceso" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","VisibleSubacceso" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","ObligatorioSubacceso" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","ModificableSubacceso" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","txtNmaximoSubacceso" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","VisiblePeriodoInicial" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","ObligatorioPeriodoInicial" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","ModificablePeriodoInicial" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","VisiblePeriodoFinal" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","ObligatorioPeriodoFinal" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","ModificablePeriodoFinal" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","VisibleControlDesc" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","ObligatorioControlDesc" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","ModificableControlDesc" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","VisibleIndicador" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","ObligatorioIndicador" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","ModificableIndicador" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","VisibleControlDA" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","ObligatorioControlDA" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 15   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","ModificableControlDA" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","VisibleComunicacion" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","ObligatorioComunicacion" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","ModificableComunicacion" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","VisibleControlMorosidad" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","ObligatorioControlMorosidad" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","ModificableControlMorosidad" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","VisibleAfectaFactura" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","ObligatorioAfectaFactura" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","ModificableAfectaFactura" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","VisibleAfectaCC" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","ObligatorioAfectaCC" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","ModificableAfectaCC" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hidVigenciaDescuento" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","hVuelveErrPest" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","hExito" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(104)).setAttribute("nombre","capa1" );
      ((Element)v.get(15)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("table"));
      ((Element)v.get(105)).setAttribute("bgcolor","red" );
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(105)).setAttribute("height","100%" );
      ((Element)v.get(105)).setAttribute("border","0" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("cellpadding","0" );
      ((Element)v.get(105)).setAttribute("cellspacing","0" );
      ((Element)v.get(105)).setAttribute("class","menu5" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(107)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(108)).setAttribute("width","12" );
      ((Element)v.get(108)).setAttribute("height","10" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","10" );
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","10" );
      ((Element)v.get(112)).setAttribute("height","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","10" );
      ((Element)v.get(113)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","10" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","20" );
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","75" );
      ((Element)v.get(116)).setAttribute("border","0" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(116)).setAttribute("cellpadding","1" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("a"));
      ((Element)v.get(119)).setAttribute("href","#" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(120)).setAttribute("ID","InsertarP1" );
      ((Element)v.get(120)).setAttribute("onclick","onClickPestanya('0')" );
      ((Element)v.get(120)).setAttribute("onmouseover","poneManito('InsertarP1');" );
      ((Element)v.get(120)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Elemento padre:120 / Elemento actual: 121   */
      v.add(doc.createTextNode("Datos generales"));
      ((Element)v.get(120)).appendChild((Text)v.get(121));

      /* Termina nodo Texto:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:122 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","10" );
      ((Element)v.get(122)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","10" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","20" );
      ((Element)v.get(124)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(124)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("table"));
      ((Element)v.get(125)).setAttribute("width","75" );
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("align","center" );
      ((Element)v.get(125)).setAttribute("cellpadding","1" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).setAttribute("align","center" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(128)).setAttribute("ID","InsertarP2" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).setAttribute("onclick","onClickPestanya('1')" );
      ((Element)v.get(128)).setAttribute("onmouseover","poneManito('InsertarP2');" );
      ((Element)v.get(128)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Elemento padre:128 / Elemento actual: 129   */
      v.add(doc.createTextNode("Tipo de cliente"));
      ((Element)v.get(128)).appendChild((Text)v.get(129));

      /* Termina nodo Texto:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:130 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","10" );
      ((Element)v.get(130)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","10" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","20" );
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(132)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("table"));
      ((Element)v.get(133)).setAttribute("width","75" );
      ((Element)v.get(133)).setAttribute("border","0" );
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(133)).setAttribute("cellpadding","1" );
      ((Element)v.get(133)).setAttribute("cellspacing","0" );
      ((Element)v.get(133)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(136)).setAttribute("ID","InsertarP3" );
      ((Element)v.get(136)).setAttribute("onclick","onClickPestanya('2')" );
      ((Element)v.get(136)).setAttribute("onmouseover","poneManito('InsertarP3');" );
      ((Element)v.get(136)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Elemento padre:136 / Elemento actual: 137   */
      v.add(doc.createTextNode("Alcance administrativo"));
      ((Element)v.get(136)).appendChild((Text)v.get(137));

      /* Termina nodo Texto:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:138 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","10" );
      ((Element)v.get(138)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","10" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","20" );
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","75" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellpadding","1" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(144)).setAttribute("ID","InsertarP4" );
      ((Element)v.get(144)).setAttribute("onclick","onClickPestanya('3')" );
      ((Element)v.get(144)).setAttribute("onmouseover","poneManito('InsertarP4');" );
      ((Element)v.get(144)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Elemento padre:144 / Elemento actual: 145   */
      v.add(doc.createTextNode("Base de cálculo"));
      ((Element)v.get(144)).appendChild((Text)v.get(145));

      /* Termina nodo Texto:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:146 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("width","10" );
      ((Element)v.get(146)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","10" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).setAttribute("width","20" );
      ((Element)v.get(148)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(148)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("table"));
      ((Element)v.get(149)).setAttribute("width","75" );
      ((Element)v.get(149)).setAttribute("border","0" );
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("cellpadding","1" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(151)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(152)).setAttribute("ID","InsertarP5" );
      ((Element)v.get(152)).setAttribute("onclick","onClickPestanya('4')" );
      ((Element)v.get(152)).setAttribute("onmouseover","poneManito('InsertarP5');" );
      ((Element)v.get(152)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Elemento padre:152 / Elemento actual: 153   */
      v.add(doc.createTextNode("Aplicación de descuento"));
      ((Element)v.get(152)).appendChild((Text)v.get(153));

      /* Termina nodo Texto:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:154 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","16" );
      ((Element)v.get(154)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:156 / Elemento padre: 104   */
      v.add(doc.createElement("table"));
      ((Element)v.get(156)).setAttribute("width","100%" );
      ((Element)v.get(156)).setAttribute("border","0" );
      ((Element)v.get(156)).setAttribute("cellspacing","0" );
      ((Element)v.get(156)).setAttribute("cellpadding","0" );
      ((Element)v.get(104)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(159)).setAttribute("height","12" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","750" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(157)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(163)).setAttribute("height","1" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:157   */

      /* Empieza nodo:164 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(169)).setAttribute("class","legend" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblDatosPrincipales" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("cod","0011" );
      ((Element)v.get(170)).setAttribute("id","legend" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("table"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("align","center" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("table"));
      ((Element)v.get(174)).setAttribute("width","531" );
      ((Element)v.get(174)).setAttribute("border","0" );
      ((Element)v.get(174)).setAttribute("align","left" );
      ((Element)v.get(174)).setAttribute("cellspacing","0" );
      ((Element)v.get(174)).setAttribute("cellpadding","0" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("colspan","4" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:178 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblPais" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","5" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblNumDescuento" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).setAttribute("cod","933" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("colspan","3" );
      ((Element)v.get(178)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lblNombreDescuento" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("id","datosTitle" );
      ((Element)v.get(190)).setAttribute("cod","942" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(191)).setAttribute("colspan","2" );
      ((Element)v.get(178)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:178   */

      /* Empieza nodo:193 / Elemento padre: 174   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(197)).setAttribute("nombre","lbldtPais" );
      ((Element)v.get(197)).setAttribute("alto","13" );
      ((Element)v.get(197)).setAttribute("filas","1" );
      ((Element)v.get(197)).setAttribute("valor","" );
      ((Element)v.get(197)).setAttribute("id","datosCampos" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","25" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(201)).setAttribute("nombre","lbldtNumDescuento" );
      ((Element)v.get(201)).setAttribute("alto","13" );
      ((Element)v.get(201)).setAttribute("filas","1" );
      ((Element)v.get(201)).setAttribute("valor","" );
      ((Element)v.get(201)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","25" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(193)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(205)).setAttribute("nombre","txtNombreDescuento" );
      ((Element)v.get(205)).setAttribute("id","datosCampos" );
      ((Element)v.get(205)).setAttribute("max","30" );
      ((Element)v.get(205)).setAttribute("tipo","" );
      ((Element)v.get(205)).setAttribute("onchange","" );
      ((Element)v.get(205)).setAttribute("req","S" );
      ((Element)v.get(205)).setAttribute("size","30" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("validacion","" );
      ((Element)v.get(205)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnSiguiente')" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(209)).setAttribute("width","21" );
      ((Element)v.get(209)).setAttribute("height","15" );
      ((Element)v.get(209)).setAttribute("onclick","levantarI18N ('formulario', '1');" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(193)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:193   */

      /* Empieza nodo:212 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("colspan","4" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:215 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("table"));
      ((Element)v.get(217)).setAttribute("width","531" );
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("align","left" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(222)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(222)).setAttribute("alto","13" );
      ((Element)v.get(222)).setAttribute("filas","1" );
      ((Element)v.get(222)).setAttribute("valor","" );
      ((Element)v.get(222)).setAttribute("id","datosTitle" );
      ((Element)v.get(222)).setAttribute("cod","6" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","25" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(226)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("id","datosTitle" );
      ((Element)v.get(226)).setAttribute("cod","7" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("width","100%" );
      ((Element)v.get(218)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:218   */

      /* Empieza nodo:229 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(229)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(233)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(233)).setAttribute("id","datosCampos" );
      ((Element)v.get(233)).setAttribute("size","1" );
      ((Element)v.get(233)).setAttribute("multiple","N" );
      ((Element)v.get(233)).setAttribute("req","S" );
      ((Element)v.get(233)).setAttribute("valorinicial","" );
      ((Element)v.get(233)).setAttribute("textoinicial","" );
      ((Element)v.get(233)).setAttribute("onchange","marcaOnChange();" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:235 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","25" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(229)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(238)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(238)).setAttribute("id","datosCampos" );
      ((Element)v.get(238)).setAttribute("size","1" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(238)).setAttribute("multiple","N" );
      ((Element)v.get(238)).setAttribute("req","S" );
      ((Element)v.get(238)).setAttribute("valorinicial","" );
      ((Element)v.get(238)).setAttribute("textoinicial","" );
      ((Element)v.get(238)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("width","100%" );
      ((Element)v.get(229)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:229   */

      /* Empieza nodo:242 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("colspan","4" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:245 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("table"));
      ((Element)v.get(247)).setAttribute("width","531" );
      ((Element)v.get(247)).setAttribute("border","0" );
      ((Element)v.get(247)).setAttribute("align","left" );
      ((Element)v.get(247)).setAttribute("cellspacing","0" );
      ((Element)v.get(247)).setAttribute("cellpadding","0" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(252)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(252)).setAttribute("alto","13" );
      ((Element)v.get(252)).setAttribute("filas","1" );
      ((Element)v.get(252)).setAttribute("valor","" );
      ((Element)v.get(252)).setAttribute("id","datosTitle" );
      ((Element)v.get(252)).setAttribute("cod","10" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","25" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(256)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(256)).setAttribute("alto","13" );
      ((Element)v.get(256)).setAttribute("filas","1" );
      ((Element)v.get(256)).setAttribute("valor","" );
      ((Element)v.get(256)).setAttribute("id","datosTitle" );
      ((Element)v.get(256)).setAttribute("cod","122" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("width","100%" );
      ((Element)v.get(248)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:248   */

      /* Empieza nodo:259 / Elemento padre: 247   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(247)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","8" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 259   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(259)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(263)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(263)).setAttribute("id","datosCampos" );
      ((Element)v.get(263)).setAttribute("size","5" );
      ((Element)v.get(263)).setAttribute("multiple","S" );
      ((Element)v.get(263)).setAttribute("req","N" );
      ((Element)v.get(263)).setAttribute("valorinicial","" );
      ((Element)v.get(263)).setAttribute("textoinicial","" );
      ((Element)v.get(263)).setAttribute("onchange","accesoOnChange();" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:265 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","25" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(259)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(268)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(268)).setAttribute("id","datosCampos" );
      ((Element)v.get(268)).setAttribute("size","5" );
      ((Element)v.get(268)).setAttribute("multiple","S" );
      ((Element)v.get(268)).setAttribute("req","N" );
      ((Element)v.get(268)).setAttribute("valorinicial","" );
      ((Element)v.get(268)).setAttribute("textoinicial","" );
      ((Element)v.get(268)).setAttribute("onchange","subaccesoOnChange();" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:270 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(259)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:259   */

      /* Empieza nodo:272 / Elemento padre: 247   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(247)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("colspan","4" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:275 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("table"));
      ((Element)v.get(277)).setAttribute("width","531" );
      ((Element)v.get(277)).setAttribute("border","0" );
      ((Element)v.get(277)).setAttribute("align","left" );
      ((Element)v.get(277)).setAttribute("cellspacing","0" );
      ((Element)v.get(277)).setAttribute("cellpadding","0" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(282)).setAttribute("nombre","lblVigenciaPeriodoDesde" );
      ((Element)v.get(282)).setAttribute("alto","13" );
      ((Element)v.get(282)).setAttribute("filas","1" );
      ((Element)v.get(282)).setAttribute("valor","" );
      ((Element)v.get(282)).setAttribute("id","datosTitle" );
      ((Element)v.get(282)).setAttribute("cod","1298" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","25" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(286)).setAttribute("nombre","lblVigenciaPeriodoHasta" );
      ((Element)v.get(286)).setAttribute("alto","13" );
      ((Element)v.get(286)).setAttribute("filas","1" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(286)).setAttribute("id","datosTitle" );
      ((Element)v.get(286)).setAttribute("cod","1299" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).setAttribute("width","100%" );
      ((Element)v.get(278)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:278   */

      /* Empieza nodo:289 / Elemento padre: 277   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(277)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(293)).setAttribute("nombre","cbVigenciaPeriodoDesde" );
      ((Element)v.get(293)).setAttribute("id","datosCampos" );
      ((Element)v.get(293)).setAttribute("size","1" );
      ((Element)v.get(293)).setAttribute("multiple","N" );
      ((Element)v.get(293)).setAttribute("req","S" );
      ((Element)v.get(293)).setAttribute("valorinicial","" );
      ((Element)v.get(293)).setAttribute("textoinicial","" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(297)).setAttribute("valign","bottom" );
      ((Element)v.get(289)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(298)).setAttribute("nombre","cbVigenciaPeriodoHasta" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("size","1" );
      ((Element)v.get(298)).setAttribute("multiple","N" );
      ((Element)v.get(298)).setAttribute("req","N" );
      ((Element)v.get(298)).setAttribute("valorinicial","" );
      ((Element)v.get(298)).setAttribute("ontab","checkEntrada()" );
      ((Element)v.get(298)).setAttribute("textoinicial","" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("width","100%" );
      ((Element)v.get(289)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:289   */

      /* Empieza nodo:302 / Elemento padre: 277   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(277)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).setAttribute("colspan","4" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:171   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:305 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("height","12" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:164   */

      /* Empieza nodo:307 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("width","12" );
      ((Element)v.get(308)).setAttribute("align","center" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","12" );
      ((Element)v.get(309)).setAttribute("height","12" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("width","750" );
      ((Element)v.get(307)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).setAttribute("width","12" );
      ((Element)v.get(307)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","12" );
      ((Element)v.get(313)).setAttribute("height","12" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:307   */
      /* Termina nodo:156   */
      /* Termina nodo:104   */

      /* Empieza nodo:314 / Elemento padre: 15   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(314)).setAttribute("nombre","listado1" );
      ((Element)v.get(314)).setAttribute("ancho","535" );
      ((Element)v.get(314)).setAttribute("alto","276" );
      ((Element)v.get(314)).setAttribute("x","12" );
      ((Element)v.get(314)).setAttribute("y","272" );
      ((Element)v.get(314)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(314)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(15)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(315)).setAttribute("precarga","S" );
      ((Element)v.get(315)).setAttribute("conROver","S" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(316)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(316)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(316)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(316)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 315   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(317)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(317)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(317)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(317)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(315)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 315   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(318)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(318)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(315)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:315   */

      /* Empieza nodo:319 / Elemento padre: 314   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(314)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(320)).setAttribute("borde","1" );
      ((Element)v.get(320)).setAttribute("horizDatos","1" );
      ((Element)v.get(320)).setAttribute("horizCabecera","1" );
      ((Element)v.get(320)).setAttribute("vertical","0" );
      ((Element)v.get(320)).setAttribute("horizTitulo","1" );
      ((Element)v.get(320)).setAttribute("horizBase","1" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 319   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(321)).setAttribute("borde","#999999" );
      ((Element)v.get(321)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(321)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(321)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(321)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(321)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(321)).setAttribute("horizBase","#999999" );
      ((Element)v.get(319)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:319   */

      /* Empieza nodo:322 / Elemento padre: 314   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(322)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(322)).setAttribute("alto","22" );
      ((Element)v.get(322)).setAttribute("imgFondo","" );
      ((Element)v.get(322)).setAttribute("cod","955" );
      ((Element)v.get(322)).setAttribute("ID","datosTitle" );
      ((Element)v.get(314)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 314   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(323)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(323)).setAttribute("alto","22" );
      ((Element)v.get(323)).setAttribute("imgFondo","" );
      ((Element)v.get(314)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 314   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(324)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(324)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(324)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(324)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(324)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(324)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(314)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("ancho","100" );
      ((Element)v.get(325)).setAttribute("minimizable","S" );
      ((Element)v.get(325)).setAttribute("minimizada","N" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 324   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("ancho","50" );
      ((Element)v.get(326)).setAttribute("minimizable","S" );
      ((Element)v.get(326)).setAttribute("minimizada","N" );
      ((Element)v.get(326)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(324)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 324   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("ancho","50" );
      ((Element)v.get(327)).setAttribute("minimizable","S" );
      ((Element)v.get(327)).setAttribute("minimizada","N" );
      ((Element)v.get(327)).setAttribute("oculta","S" );
      ((Element)v.get(324)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:324   */

      /* Empieza nodo:328 / Elemento padre: 314   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(328)).setAttribute("alto","20" );
      ((Element)v.get(328)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(328)).setAttribute("imgFondo","" );
      ((Element)v.get(328)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(314)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("colFondo","" );
      ((Element)v.get(329)).setAttribute("ID","EstCab" );
      ((Element)v.get(329)).setAttribute("align","center" );
      ((Element)v.get(329)).setAttribute("cod","9" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Elemento padre:329 / Elemento actual: 330   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(329)).appendChild((Text)v.get(330));

      /* Termina nodo Texto:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(331)).setAttribute("colFondo","" );
      ((Element)v.get(331)).setAttribute("ID","EstCab" );
      ((Element)v.get(331)).setAttribute("cod","1553" );
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Elemento padre:331 / Elemento actual: 332   */
      v.add(doc.createTextNode("Valor"));
      ((Element)v.get(331)).appendChild((Text)v.get(332));

      /* Termina nodo Texto:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 328   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("colFondo","" );
      ((Element)v.get(333)).setAttribute("ID","EstCab" );
      ((Element)v.get(328)).appendChild((Element)v.get(333));

      /* Elemento padre:333 / Elemento actual: 334   */
      v.add(doc.createTextNode("oidParametros"));
      ((Element)v.get(333)).appendChild((Text)v.get(334));

      /* Termina nodo Texto:334   */
      /* Termina nodo:333   */
      /* Termina nodo:328   */

      /* Empieza nodo:335 / Elemento padre: 314   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(335)).setAttribute("alto","22" );
      ((Element)v.get(335)).setAttribute("accion","" );
      ((Element)v.get(335)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(335)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(335)).setAttribute("maxSel","-1" );
      ((Element)v.get(335)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(335)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(335)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(335)).setAttribute("onLoad","" );
      ((Element)v.get(335)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(314)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("tipo","texto" );
      ((Element)v.get(336)).setAttribute("ID","EstDat" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 335   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("tipo","checkbox" );
      ((Element)v.get(337)).setAttribute("nombre","ckValor" );
      ((Element)v.get(337)).setAttribute("ID","EstDat2" );
      ((Element)v.get(337)).setAttribute("onShTab","focalizaListaShTab(FILAEVENTO);" );
      ((Element)v.get(337)).setAttribute("onTab","focalizaListaTab(FILAEVENTO)" );
      ((Element)v.get(337)).setAttribute("onchange","inicioOnChange(FILAEVENTO);" );
      ((Element)v.get(335)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 335   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(338)).setAttribute("tipo","texto" );
      ((Element)v.get(338)).setAttribute("ID","EstDat" );
      ((Element)v.get(335)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:335   */

      /* Empieza nodo:339 / Elemento padre: 314   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(314)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(340)).setAttribute("ID","1" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(341)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(341)).setAttribute("TIPO","STRING" );
      ((Element)v.get(341)).setAttribute("VALOR","28" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 340   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(342)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(342)).setAttribute("TIPO","STRING" );
      ((Element)v.get(342)).setAttribute("VALOR","Indicador dto. acumulativo" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(340)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 340   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(343)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(343)).setAttribute("TIPO","STRING" );
      ((Element)v.get(343)).setAttribute("VALOR","" );
      ((Element)v.get(340)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:340   */

      /* Empieza nodo:344 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(344)).setAttribute("ID","2" );
      ((Element)v.get(339)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(345)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(345)).setAttribute("TIPO","STRING" );
      ((Element)v.get(345)).setAttribute("VALOR","2" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 344   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(346)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(346)).setAttribute("TIPO","STRING" );
      ((Element)v.get(346)).setAttribute("VALOR","Indicador culminación" );
      ((Element)v.get(344)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(347)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(347)).setAttribute("TIPO","STRING" );
      ((Element)v.get(347)).setAttribute("VALOR","" );
      ((Element)v.get(344)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:344   */

      /* Empieza nodo:348 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(348)).setAttribute("ID","3" );
      ((Element)v.get(339)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(349)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(349)).setAttribute("TIPO","STRING" );
      ((Element)v.get(349)).setAttribute("VALOR","27" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 348   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(350)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(350)).setAttribute("TIPO","STRING" );
      ((Element)v.get(350)).setAttribute("VALOR","Control por devoluciones" );
      ((Element)v.get(348)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 348   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(351)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(351)).setAttribute("TIPO","STRING" );
      ((Element)v.get(351)).setAttribute("VALOR","" );
      ((Element)v.get(348)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:348   */

      /* Empieza nodo:352 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(352)).setAttribute("ID","1" );
      ((Element)v.get(339)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(353)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(353)).setAttribute("TIPO","STRING" );
      ((Element)v.get(353)).setAttribute("VALOR","32" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 352   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(354)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(354)).setAttribute("TIPO","STRING" );
      ((Element)v.get(354)).setAttribute("VALOR","Control por anulaciones" );
      ((Element)v.get(352)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 352   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(355)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(355)).setAttribute("TIPO","STRING" );
      ((Element)v.get(355)).setAttribute("VALOR","" );
      ((Element)v.get(352)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:352   */

      /* Empieza nodo:356 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(356)).setAttribute("ID","2" );
      ((Element)v.get(339)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(357)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(357)).setAttribute("TIPO","STRING" );
      ((Element)v.get(357)).setAttribute("VALOR","31" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 356   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(358)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(358)).setAttribute("TIPO","STRING" );
      ((Element)v.get(358)).setAttribute("VALOR","Comunicación a participantes" );
      ((Element)v.get(356)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 356   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(359)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(359)).setAttribute("TIPO","STRING" );
      ((Element)v.get(359)).setAttribute("VALOR","" );
      ((Element)v.get(356)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:356   */

      /* Empieza nodo:360 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(360)).setAttribute("ID","3" );
      ((Element)v.get(339)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(361)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(361)).setAttribute("TIPO","STRING" );
      ((Element)v.get(361)).setAttribute("VALOR","5" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(362)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(362)).setAttribute("TIPO","STRING" );
      ((Element)v.get(362)).setAttribute("VALOR","Activa" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 360   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(363)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(363)).setAttribute("TIPO","STRING" );
      ((Element)v.get(363)).setAttribute("VALOR","" );
      ((Element)v.get(360)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:360   */

      /* Empieza nodo:364 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(364)).setAttribute("ID","3" );
      ((Element)v.get(339)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(365)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(365)).setAttribute("TIPO","STRING" );
      ((Element)v.get(365)).setAttribute("VALOR","26" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 364   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(366)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(366)).setAttribute("TIPO","STRING" );
      ((Element)v.get(366)).setAttribute("VALOR","Morosidad" );
      ((Element)v.get(364)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 364   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(367)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(367)).setAttribute("TIPO","STRING" );
      ((Element)v.get(367)).setAttribute("VALOR","" );
      ((Element)v.get(364)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:364   */

      /* Empieza nodo:368 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(368)).setAttribute("ID","1" );
      ((Element)v.get(339)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(369)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(369)).setAttribute("TIPO","STRING" );
      ((Element)v.get(369)).setAttribute("VALOR","29" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 368   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(370)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(370)).setAttribute("TIPO","STRING" );
      ((Element)v.get(370)).setAttribute("VALOR","Afecta a facturas" );
      ((Element)v.get(368)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 368   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(371)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(371)).setAttribute("TIPO","STRING" );
      ((Element)v.get(371)).setAttribute("VALOR","" );
      ((Element)v.get(368)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:368   */

      /* Empieza nodo:372 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(372)).setAttribute("ID","2" );
      ((Element)v.get(339)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(373)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(373)).setAttribute("TIPO","STRING" );
      ((Element)v.get(373)).setAttribute("VALOR","30" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 372   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(374)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(374)).setAttribute("TIPO","STRING" );
      ((Element)v.get(374)).setAttribute("VALOR","Afecta a cuentas corrientes" );
      ((Element)v.get(372)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(375)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(375)).setAttribute("TIPO","STRING" );
      ((Element)v.get(375)).setAttribute("VALOR","" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:372   */
      /* Termina nodo:339   */

      /* Empieza nodo:376 / Elemento padre: 314   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(376)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(376)).setAttribute("ancho","535" );
      ((Element)v.get(376)).setAttribute("sep","$" );
      ((Element)v.get(376)).setAttribute("x","12" );
      ((Element)v.get(376)).setAttribute("class","botonera" );
      ((Element)v.get(376)).setAttribute("y","526" );
      ((Element)v.get(376)).setAttribute("control","|" );
      ((Element)v.get(376)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(376)).setAttribute("rowset","" );
      ((Element)v.get(376)).setAttribute("cargainicial","N" );
      ((Element)v.get(314)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(377)).setAttribute("nombre","ret1" );
      ((Element)v.get(377)).setAttribute("x","37" );
      ((Element)v.get(377)).setAttribute("y","530" );
      ((Element)v.get(377)).setAttribute("ID","botonContenido" );
      ((Element)v.get(377)).setAttribute("img","retroceder_on" );
      ((Element)v.get(377)).setAttribute("tipo","0" );
      ((Element)v.get(377)).setAttribute("estado","false" );
      ((Element)v.get(377)).setAttribute("alt","" );
      ((Element)v.get(377)).setAttribute("codigo","" );
      ((Element)v.get(377)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 376   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(378)).setAttribute("nombre","ava1" );
      ((Element)v.get(378)).setAttribute("x","52" );
      ((Element)v.get(378)).setAttribute("y","530" );
      ((Element)v.get(378)).setAttribute("ID","botonContenido" );
      ((Element)v.get(378)).setAttribute("img","avanzar_on" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(378)).setAttribute("tipo","0" );
      ((Element)v.get(378)).setAttribute("estado","false" );
      ((Element)v.get(378)).setAttribute("alt","" );
      ((Element)v.get(378)).setAttribute("codigo","" );
      ((Element)v.get(378)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(376)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:376   */
      /* Termina nodo:314   */

      /* Empieza nodo:379 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(379)).setAttribute("nombre","primera1" );
      ((Element)v.get(379)).setAttribute("x","20" );
      ((Element)v.get(379)).setAttribute("y","530" );
      ((Element)v.get(379)).setAttribute("ID","botonContenido" );
      ((Element)v.get(379)).setAttribute("img","primera_on" );
      ((Element)v.get(379)).setAttribute("tipo","-2" );
      ((Element)v.get(379)).setAttribute("estado","false" );
      ((Element)v.get(379)).setAttribute("alt","" );
      ((Element)v.get(379)).setAttribute("codigo","" );
      ((Element)v.get(379)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(15)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(380)).setAttribute("nombre","separa" );
      ((Element)v.get(380)).setAttribute("x","59" );
      ((Element)v.get(380)).setAttribute("y","526" );
      ((Element)v.get(380)).setAttribute("ID","botonContenido" );
      ((Element)v.get(380)).setAttribute("img","separa_base" );
      ((Element)v.get(380)).setAttribute("tipo","0" );
      ((Element)v.get(380)).setAttribute("estado","false" );
      ((Element)v.get(380)).setAttribute("alt","" );
      ((Element)v.get(380)).setAttribute("codigo","" );
      ((Element)v.get(380)).setAttribute("accion","" );
      ((Element)v.get(15)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(381)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(381)).setAttribute("x","13" );
      ((Element)v.get(381)).setAttribute("y","527" );
      ((Element)v.get(381)).setAttribute("ID","botonContenido" );
      ((Element)v.get(381)).setAttribute("tipo","html" );
      ((Element)v.get(381)).setAttribute("estado","false" );
      ((Element)v.get(381)).setAttribute("cod","446" );
      ((Element)v.get(381)).setAttribute("accion","accionSiguiente();" );
      ((Element)v.get(381)).setAttribute("ontab","onTabSiguiente();" );
      ((Element)v.get(381)).setAttribute("onshtab","onShTabSiguiente();" );
      ((Element)v.get(15)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(382)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(382)).setAttribute("alto","12" );
      ((Element)v.get(382)).setAttribute("ancho","100%" );
      ((Element)v.get(382)).setAttribute("colorf","" );
      ((Element)v.get(382)).setAttribute("borde","0" );
      ((Element)v.get(382)).setAttribute("imagenf","" );
      ((Element)v.get(382)).setAttribute("repeat","" );
      ((Element)v.get(382)).setAttribute("padding","" );
      ((Element)v.get(382)).setAttribute("visibilidad","visible" );
      ((Element)v.get(382)).setAttribute("contravsb","" );
      ((Element)v.get(382)).setAttribute("x","0" );
      ((Element)v.get(382)).setAttribute("y","549" );
      ((Element)v.get(382)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:15   */


   }

}
