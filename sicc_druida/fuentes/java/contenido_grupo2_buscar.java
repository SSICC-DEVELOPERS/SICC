
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupo2_buscar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupo2_buscar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","buscar Clientes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","buscar Clientes" );
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
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","contenido_grupo2_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmUnico" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","accion" );
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
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hiddenTipoCliente" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hiddenSubTipoCliente" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidTipoSubtipo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidIndActivo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 4   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidcb" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidcbMarcaContacto" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidcbCanalContacto" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidcbPeriodoPrimerPedido" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 4   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidtextInterior" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidtextManzana" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidtextLote" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidtextKm" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hidcbCanal" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hCadenaParams" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(101)).setAttribute("width","100%" );
      ((Element)v.get(101)).setAttribute("height","100%" );
      ((Element)v.get(101)).setAttribute("border","0" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(101)).setAttribute("cellpadding","0" );
      ((Element)v.get(101)).setAttribute("cellspacing","0" );
      ((Element)v.get(101)).setAttribute("class","menu4" );
      ((Element)v.get(4)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(103)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","12" );
      ((Element)v.get(104)).setAttribute("height","30" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Elemento padre:105 / Elemento actual: 106   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(105)).appendChild((Text)v.get(106));

      /* Termina nodo Texto:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","10" );
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(107)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","10" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","92" );
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("table"));
      ((Element)v.get(110)).setAttribute("width","75" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).setAttribute("border","1" );
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(110)).setAttribute("cellpadding","1" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).setAttribute("align","center" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(112)).setAttribute("class","menu5textoblanca" );
      ((Element)v.get(112)).setAttribute("onclick","siguientePestanya(-1)" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblPesCriterios" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(113)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(113)).setAttribute("cod","0075" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:114 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","10" );
      ((Element)v.get(114)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","10" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","20" );
      ((Element)v.get(116)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(116)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("table"));
      ((Element)v.get(117)).setAttribute("width","75" );
      ((Element)v.get(117)).setAttribute("border","1" );
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(117)).setAttribute("cellpadding","1" );
      ((Element)v.get(117)).setAttribute("cellspacing","0" );
      ((Element)v.get(117)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(119)).setAttribute("onclick","siguientePestanya(0)" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblPesTipoSubtipo" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(120)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(120)).setAttribute("cod","00519" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:121 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","10" );
      ((Element)v.get(121)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","10" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","20" );
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(123)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","75" );
      ((Element)v.get(124)).setAttribute("border","1" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(124)).setAttribute("cellpadding","1" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).setAttribute("align","center" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(126)).setAttribute("onclick","siguientePestanya(1)" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lblPes1" );
      ((Element)v.get(127)).setAttribute("alto","13" );
      ((Element)v.get(127)).setAttribute("filas","1" );
      ((Element)v.get(127)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(127)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(127)).setAttribute("cod","00515" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:128 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","10" );
      ((Element)v.get(128)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","10" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","20" );
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(130)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","75" );
      ((Element)v.get(131)).setAttribute("border","1" );
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(131)).setAttribute("cellpadding","1" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(131)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(133)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblPes2" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(134)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(134)).setAttribute("cod","00516" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:135 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","10" );
      ((Element)v.get(135)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","10" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","20" );
      ((Element)v.get(137)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("table"));
      ((Element)v.get(138)).setAttribute("width","75" );
      ((Element)v.get(138)).setAttribute("border","1" );
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(138)).setAttribute("cellpadding","1" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(140)).setAttribute("onclick","siguientePestanya(3)" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lblPes3" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(141)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(141)).setAttribute("cod","00517" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:142 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","10" );
      ((Element)v.get(142)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(143)).setAttribute("width","10" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","20" );
      ((Element)v.get(144)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(144)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("table"));
      ((Element)v.get(145)).setAttribute("width","75" );
      ((Element)v.get(145)).setAttribute("border","1" );
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(145)).setAttribute("cellpadding","1" );
      ((Element)v.get(145)).setAttribute("cellspacing","0" );
      ((Element)v.get(145)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(147)).setAttribute("onclick","siguientePestanya(4)" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(148)).setAttribute("nombre","lblPes4" );
      ((Element)v.get(148)).setAttribute("alto","13" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(148)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(148)).setAttribute("cod","00518" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:149 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","16" );
      ((Element)v.get(149)).setAttribute("class","menu5texto" );
      ((Element)v.get(102)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","12" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:151 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(151)).setAttribute("nombre","capaFormularios" );
      ((Element)v.get(151)).setAttribute("alto","100%" );
      ((Element)v.get(151)).setAttribute("ancho","100%" );
      ((Element)v.get(4)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("table"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(152)).setAttribute("border","0" );
      ((Element)v.get(152)).setAttribute("cellspacing","0" );
      ((Element)v.get(152)).setAttribute("cellpadding","0" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","12" );
      ((Element)v.get(154)).setAttribute("align","center" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(155)).setAttribute("height","12" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("width","750" );
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(153)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(159)).setAttribute("height","1" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:153   */

      /* Empieza nodo:160 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(165)).setAttribute("class","legend" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblTitDatosBasicos" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("cod","00142" );
      ((Element)v.get(166)).setAttribute("id","legend" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(167)).setAttribute("width","100%" );
      ((Element)v.get(167)).setAttribute("border","0" );
      ((Element)v.get(167)).setAttribute("align","center" );
      ((Element)v.get(167)).setAttribute("cellspacing","0" );
      ((Element)v.get(167)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("colspan","4" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:171 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblApellido1" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","16" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","25" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblApellido2" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","datosTitle" );
      ((Element)v.get(179)).setAttribute("cod","17" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","25" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblApellidoCasada" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","18" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","100%" );
      ((Element)v.get(171)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:171   */

      /* Empieza nodo:186 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(186)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(190)).setAttribute("nombre","textApellido1" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).setAttribute("onshtab","siguientePestanya(1);" );
      ((Element)v.get(190)).setAttribute("max","25" );
      ((Element)v.get(190)).setAttribute("tipo","" );
      ((Element)v.get(190)).setAttribute("onchange","" );
      ((Element)v.get(190)).setAttribute("req","N" );
      ((Element)v.get(190)).setAttribute("size","25" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("validacion","" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","25" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(186)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(194)).setAttribute("nombre","textApellido2" );
      ((Element)v.get(194)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).setAttribute("max","25" );
      ((Element)v.get(194)).setAttribute("tipo","" );
      ((Element)v.get(194)).setAttribute("onchange","" );
      ((Element)v.get(194)).setAttribute("req","N" );
      ((Element)v.get(194)).setAttribute("size","25" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("validacion","" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(186)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(198)).setAttribute("nombre","textApellidoCasada" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("max","25" );
      ((Element)v.get(198)).setAttribute("tipo","" );
      ((Element)v.get(198)).setAttribute("onchange","" );
      ((Element)v.get(198)).setAttribute("req","N" );
      ((Element)v.get(198)).setAttribute("size","25" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("validacion","" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(186)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:186   */

      /* Empieza nodo:201 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("colspan","4" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:167   */

      /* Empieza nodo:204 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(204)).setAttribute("width","100%" );
      ((Element)v.get(204)).setAttribute("border","0" );
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(204)).setAttribute("cellspacing","0" );
      ((Element)v.get(204)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
   }

   private void getXML900(Document doc) {
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
      ((Element)v.get(209)).setAttribute("nombre","lblNombre1" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","93" );
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
      ((Element)v.get(213)).setAttribute("nombre","lblNombre2" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("id","datosTitle" );
      ((Element)v.get(213)).setAttribute("cod","94" );
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
      ((Element)v.get(217)).setAttribute("nombre","lblTratamiento" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","757" );
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
      ((Element)v.get(221)).setAttribute("nombre","lblSexo" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(221)).setAttribute("id","datosTitle" );
      ((Element)v.get(221)).setAttribute("cod","1122" );
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
      ((Element)v.get(225)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(225)).setAttribute("alto","13" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(225)).setAttribute("id","datosTitle" );
      ((Element)v.get(225)).setAttribute("cod","541" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","25" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(229)).setAttribute("nombre","lblFechaIngreso" );
      ((Element)v.get(229)).setAttribute("alto","13" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(229)).setAttribute("id","datosTitle" );
      ((Element)v.get(229)).setAttribute("cod","499" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("width","100%" );
      ((Element)v.get(205)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:205   */

      /* Empieza nodo:232 / Elemento padre: 204   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(204)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(236)).setAttribute("nombre","textNombre1" );
      ((Element)v.get(236)).setAttribute("id","datosCampos" );
      ((Element)v.get(236)).setAttribute("max","25" );
      ((Element)v.get(236)).setAttribute("tipo","" );
      ((Element)v.get(236)).setAttribute("onchange","" );
      ((Element)v.get(236)).setAttribute("req","N" );
      ((Element)v.get(236)).setAttribute("size","25" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(236)).setAttribute("validacion","" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","25" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(232)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(240)).setAttribute("nombre","textNombre2" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("max","25" );
      ((Element)v.get(240)).setAttribute("tipo","" );
      ((Element)v.get(240)).setAttribute("onchange","" );
      ((Element)v.get(240)).setAttribute("req","N" );
      ((Element)v.get(240)).setAttribute("size","25" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(240)).setAttribute("validacion","" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","25" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).setAttribute("valign","top" );
      ((Element)v.get(232)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(244)).setAttribute("nombre","cbTratamiento" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("size","1" );
      ((Element)v.get(244)).setAttribute("multiple","N" );
      ((Element)v.get(244)).setAttribute("req","N" );
      ((Element)v.get(244)).setAttribute("valorinicial","" );
      ((Element)v.get(244)).setAttribute("textoinicial","" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("class","datosCampos" );
      ((Element)v.get(232)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(249)).setAttribute("nombre","rbSexo" );
      ((Element)v.get(249)).setAttribute("tipo","H" );
      ((Element)v.get(249)).setAttribute("id","datosCampos" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(250)).setAttribute("valor","S" );
      ((Element)v.get(250)).setAttribute("check","N" );
      ((Element)v.get(250)).setAttribute("onfocus","" );
      ((Element)v.get(250)).setAttribute("id","datosCampos" );
      ((Element)v.get(250)).setAttribute("cod","1334" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Elemento padre:250 / Elemento actual: 251   */
      v.add(doc.createTextNode("Masculino"));
      ((Element)v.get(250)).appendChild((Text)v.get(251));

      /* Termina nodo Texto:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(252)).setAttribute("valor","N" );
      ((Element)v.get(252)).setAttribute("check","N" );
      ((Element)v.get(252)).setAttribute("onfocus","" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).setAttribute("cod","1335" );
      ((Element)v.get(249)).appendChild((Element)v.get(252));

      /* Elemento padre:252 / Elemento actual: 253   */
      v.add(doc.createTextNode("Femenino"));
      ((Element)v.get(252)).appendChild((Text)v.get(253));

      /* Termina nodo Texto:253   */
      /* Termina nodo:252   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:254 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","25" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(256)).setAttribute("valign","top" );
      ((Element)v.get(232)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(257)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(257)).setAttribute("id","datosCampos" );
      ((Element)v.get(257)).setAttribute("size","1" );
      ((Element)v.get(257)).setAttribute("multiple","N" );
      ((Element)v.get(257)).setAttribute("req","N" );
      ((Element)v.get(257)).setAttribute("valorinicial","" );
      ((Element)v.get(257)).setAttribute("textoinicial","" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:259 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","25" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(262)).setAttribute("nombre","txtFechaIngresoActual" );
      ((Element)v.get(262)).setAttribute("id","datosCampos" );
      ((Element)v.get(262)).setAttribute("max","10" );
      ((Element)v.get(262)).setAttribute("tipo","" );
      ((Element)v.get(262)).setAttribute("onchange","" );
      ((Element)v.get(262)).setAttribute("req","N" );
      ((Element)v.get(262)).setAttribute("size","12" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("validacion","" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","100%" );
      ((Element)v.get(232)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:232   */

      /* Empieza nodo:265 / Elemento padre: 204   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(204)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("colspan","4" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:204   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:268 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(160)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","12" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:160   */

      /* Empieza nodo:270 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).setAttribute("width","12" );
      ((Element)v.get(271)).setAttribute("align","center" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","12" );
      ((Element)v.get(272)).setAttribute("height","15" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("width","750" );
      ((Element)v.get(270)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(276)).setAttribute("height","15" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:270   */

      /* Empieza nodo:277 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(282)).setAttribute("class","legend" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblTitDatosAdiccionales" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("cod","0052" );
      ((Element)v.get(283)).setAttribute("id","legend" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("table"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(284)).setAttribute("border","0" );
      ((Element)v.get(284)).setAttribute("align","center" );
      ((Element)v.get(284)).setAttribute("cellspacing","0" );
      ((Element)v.get(284)).setAttribute("cellpadding","0" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("colspan","4" );
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

      /* Empieza nodo:288 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(292)).setAttribute("nombre","lblFechaNacimiento" );
      ((Element)v.get(292)).setAttribute("alto","13" );
      ((Element)v.get(292)).setAttribute("filas","1" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(292)).setAttribute("id","datosTitle" );
      ((Element)v.get(292)).setAttribute("cod","877" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(288)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","25" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(296)).setAttribute("nombre","lblCodEmpleado" );
      ((Element)v.get(296)).setAttribute("alto","13" );
      ((Element)v.get(296)).setAttribute("filas","1" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(296)).setAttribute("id","datosTitle" );
      ((Element)v.get(296)).setAttribute("cod","1336" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","25" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(300)).setAttribute("nombre","lblNacionalidad" );
      ((Element)v.get(300)).setAttribute("alto","13" );
      ((Element)v.get(300)).setAttribute("filas","1" );
      ((Element)v.get(300)).setAttribute("valor","" );
      ((Element)v.get(300)).setAttribute("id","datosTitle" );
      ((Element)v.get(300)).setAttribute("cod","1095" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","25" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblEdad" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("filas","1" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(304)).setAttribute("id","datosTitle" );
      ((Element)v.get(304)).setAttribute("cod","1074" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","25" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(308)).setAttribute("nombre","lblEstadoCivil" );
      ((Element)v.get(308)).setAttribute("alto","13" );
      ((Element)v.get(308)).setAttribute("filas","1" );
      ((Element)v.get(308)).setAttribute("valor","" );
      ((Element)v.get(308)).setAttribute("id","datosTitle" );
      ((Element)v.get(308)).setAttribute("cod","1076" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","25" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(312)).setAttribute("nombre","lblOcupacion" );
      ((Element)v.get(312)).setAttribute("alto","13" );
      ((Element)v.get(312)).setAttribute("filas","1" );
      ((Element)v.get(312)).setAttribute("valor","" );
      ((Element)v.get(312)).setAttribute("id","datosTitle" );
      ((Element)v.get(312)).setAttribute("cod","1109" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).setAttribute("width","100%" );
      ((Element)v.get(288)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:288   */

      /* Empieza nodo:315 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(319)).setAttribute("nombre","textFechaNacimiento" );
      ((Element)v.get(319)).setAttribute("id","datosCampos" );
      ((Element)v.get(319)).setAttribute("max","10" );
      ((Element)v.get(319)).setAttribute("tipo","" );
      ((Element)v.get(319)).setAttribute("onblur","actualizaFechaNacimiento();" );
      ((Element)v.get(319)).setAttribute("onchange","" );
      ((Element)v.get(319)).setAttribute("req","N" );
      ((Element)v.get(319)).setAttribute("size","12" );
      ((Element)v.get(319)).setAttribute("valor","" );
      ((Element)v.get(319)).setAttribute("validacion","" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","25" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(323)).setAttribute("nombre","textCodEmpleado" );
      ((Element)v.get(323)).setAttribute("id","datosCampos" );
      ((Element)v.get(323)).setAttribute("max","10" );
      ((Element)v.get(323)).setAttribute("tipo","10" );
      ((Element)v.get(323)).setAttribute("onchange","" );
      ((Element)v.get(323)).setAttribute("req","N" );
      ((Element)v.get(323)).setAttribute("size","12" );
      ((Element)v.get(323)).setAttribute("valor","" );
      ((Element)v.get(323)).setAttribute("validacion","" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","25" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(326)).setAttribute("valign","top" );
      ((Element)v.get(315)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(327)).setAttribute("nombre","cbNacionalidad" );
      ((Element)v.get(327)).setAttribute("id","datosCampos" );
      ((Element)v.get(327)).setAttribute("size","1" );
      ((Element)v.get(327)).setAttribute("multiple","N" );
      ((Element)v.get(327)).setAttribute("req","N" );
      ((Element)v.get(327)).setAttribute("valorinicial","" );
      ((Element)v.get(327)).setAttribute("textoinicial","" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:330 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","25" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(333)).setAttribute("nombre","lblEdadActual" );
      ((Element)v.get(333)).setAttribute("alto","15" );
      ((Element)v.get(333)).setAttribute("filas","1" );
      ((Element)v.get(333)).setAttribute("valor","" );
      ((Element)v.get(333)).setAttribute("id","datosCampos" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","25" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(336)).setAttribute("valign","top" );
      ((Element)v.get(315)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(337)).setAttribute("nombre","cbEstadoCivil" );
      ((Element)v.get(337)).setAttribute("id","datosCampos" );
      ((Element)v.get(337)).setAttribute("size","1" );
      ((Element)v.get(337)).setAttribute("multiple","N" );
      ((Element)v.get(337)).setAttribute("req","N" );
      ((Element)v.get(337)).setAttribute("valorinicial","" );
      ((Element)v.get(337)).setAttribute("textoinicial","" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:339 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","25" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(342)).setAttribute("nombre","textOcupacion" );
      ((Element)v.get(342)).setAttribute("id","datosCampos" );
      ((Element)v.get(342)).setAttribute("max","40" );
      ((Element)v.get(342)).setAttribute("tipo","" );
      ((Element)v.get(342)).setAttribute("onchange","" );
      ((Element)v.get(342)).setAttribute("req","N" );
      ((Element)v.get(342)).setAttribute("size","40" );
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("validacion","" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).setAttribute("width","100%" );
      ((Element)v.get(315)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","8" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:315   */

      /* Empieza nodo:345 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("colspan","4" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","8" );
      ((Element)v.get(347)).setAttribute("height","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:284   */

      /* Empieza nodo:348 / Elemento padre: 281   */
      v.add(doc.createElement("table"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(348)).setAttribute("border","0" );
      ((Element)v.get(348)).setAttribute("align","center" );
      ((Element)v.get(348)).setAttribute("cellspacing","0" );
      ((Element)v.get(348)).setAttribute("cellpadding","0" );
      ((Element)v.get(281)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(353)).setAttribute("nombre","lblProfesion" );
      ((Element)v.get(353)).setAttribute("alto","13" );
      ((Element)v.get(353)).setAttribute("filas","1" );
      ((Element)v.get(353)).setAttribute("valor","" );
      ((Element)v.get(353)).setAttribute("id","datosTitle" );
      ((Element)v.get(353)).setAttribute("cod","1117" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","25" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(357)).setAttribute("nombre","lblCentroTrabajo" );
      ((Element)v.get(357)).setAttribute("alto","13" );
      ((Element)v.get(357)).setAttribute("filas","1" );
      ((Element)v.get(357)).setAttribute("valor","" );
      ((Element)v.get(357)).setAttribute("id","datosTitle" );
      ((Element)v.get(357)).setAttribute("cod","1055" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","25" );
      ((Element)v.get(359)).setAttribute("height","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(361)).setAttribute("nombre","lblCargoDesempena" );
      ((Element)v.get(361)).setAttribute("alto","13" );
      ((Element)v.get(361)).setAttribute("filas","1" );
      ((Element)v.get(361)).setAttribute("valor","" );
      ((Element)v.get(361)).setAttribute("id","datosTitle" );
      ((Element)v.get(361)).setAttribute("cod","1053" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).setAttribute("width","100%" );
      ((Element)v.get(349)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","8" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:349   */

      /* Empieza nodo:364 / Elemento padre: 348   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(348)).appendChild((Element)v.get(364));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(368)).setAttribute("nombre","textProfesion" );
      ((Element)v.get(368)).setAttribute("id","datosCampos" );
      ((Element)v.get(368)).setAttribute("max","40" );
      ((Element)v.get(368)).setAttribute("tipo","" );
      ((Element)v.get(368)).setAttribute("onchange","" );
      ((Element)v.get(368)).setAttribute("req","N" );
      ((Element)v.get(368)).setAttribute("size","40" );
      ((Element)v.get(368)).setAttribute("valor","" );
      ((Element)v.get(368)).setAttribute("validacion","" );
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(372)).setAttribute("nombre","textCentroTrabajo" );
      ((Element)v.get(372)).setAttribute("id","datosCampos" );
      ((Element)v.get(372)).setAttribute("max","40" );
      ((Element)v.get(372)).setAttribute("tipo","" );
      ((Element)v.get(372)).setAttribute("onchange","" );
      ((Element)v.get(372)).setAttribute("req","N" );
      ((Element)v.get(372)).setAttribute("size","40" );
      ((Element)v.get(372)).setAttribute("valor","" );
      ((Element)v.get(372)).setAttribute("validacion","" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(376)).setAttribute("nombre","textCargoDesempena" );
      ((Element)v.get(376)).setAttribute("id","datosCampos" );
      ((Element)v.get(376)).setAttribute("max","40" );
      ((Element)v.get(376)).setAttribute("tipo","" );
      ((Element)v.get(376)).setAttribute("onchange","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(376)).setAttribute("req","N" );
      ((Element)v.get(376)).setAttribute("size","40" );
      ((Element)v.get(376)).setAttribute("valor","" );
      ((Element)v.get(376)).setAttribute("validacion","" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).setAttribute("width","100%" );
      ((Element)v.get(364)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","8" );
      ((Element)v.get(378)).setAttribute("height","8" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:364   */

      /* Empieza nodo:379 / Elemento padre: 348   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(348)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("colspan","4" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","8" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:348   */

      /* Empieza nodo:382 / Elemento padre: 281   */
      v.add(doc.createElement("table"));
      ((Element)v.get(382)).setAttribute("width","100%" );
      ((Element)v.get(382)).setAttribute("border","0" );
      ((Element)v.get(382)).setAttribute("align","center" );
      ((Element)v.get(382)).setAttribute("cellspacing","0" );
      ((Element)v.get(382)).setAttribute("cellpadding","0" );
      ((Element)v.get(281)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(387)).setAttribute("nombre","lblNivelEstudios" );
      ((Element)v.get(387)).setAttribute("alto","13" );
      ((Element)v.get(387)).setAttribute("filas","1" );
      ((Element)v.get(387)).setAttribute("valor","" );
      ((Element)v.get(387)).setAttribute("id","datosTitle" );
      ((Element)v.get(387)).setAttribute("cod","1106" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","25" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(391)).setAttribute("nombre","lblCentroEstudios" );
      ((Element)v.get(391)).setAttribute("alto","13" );
      ((Element)v.get(391)).setAttribute("filas","1" );
      ((Element)v.get(391)).setAttribute("valor","" );
      ((Element)v.get(391)).setAttribute("id","datosTitle" );
      ((Element)v.get(391)).setAttribute("cod","1054" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","25" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(395)).setAttribute("nombre","lblNHijos" );
      ((Element)v.get(395)).setAttribute("alto","13" );
      ((Element)v.get(395)).setAttribute("filas","1" );
      ((Element)v.get(395)).setAttribute("valor","" );
      ((Element)v.get(395)).setAttribute("id","datosTitle" );
      ((Element)v.get(395)).setAttribute("cod","1108" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","25" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 383   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(399)).setAttribute("nombre","lblNPersonasDependientes" );
      ((Element)v.get(399)).setAttribute("alto","13" );
      ((Element)v.get(399)).setAttribute("filas","1" );
      ((Element)v.get(399)).setAttribute("valor","" );
      ((Element)v.get(399)).setAttribute("id","datosTitle" );
      ((Element)v.get(399)).setAttribute("cod","1337" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).setAttribute("width","100%" );
      ((Element)v.get(383)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:383   */

      /* Empieza nodo:402 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).setAttribute("valign","top" );
      ((Element)v.get(402)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(406)).setAttribute("nombre","cbNivelEstudios" );
      ((Element)v.get(406)).setAttribute("id","datosCampos" );
      ((Element)v.get(406)).setAttribute("size","1" );
      ((Element)v.get(406)).setAttribute("multiple","N" );
      ((Element)v.get(406)).setAttribute("req","N" );
      ((Element)v.get(406)).setAttribute("valorinicial","" );
      ((Element)v.get(406)).setAttribute("textoinicial","" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:408 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","25" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(411)).setAttribute("nombre","textCentroEstudios" );
      ((Element)v.get(411)).setAttribute("id","datosCampos" );
      ((Element)v.get(411)).setAttribute("max","40" );
      ((Element)v.get(411)).setAttribute("tipo","" );
      ((Element)v.get(411)).setAttribute("onchange","" );
      ((Element)v.get(411)).setAttribute("req","N" );
      ((Element)v.get(411)).setAttribute("size","40" );
      ((Element)v.get(411)).setAttribute("valor","" );
      ((Element)v.get(411)).setAttribute("validacion","" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","25" );
      ((Element)v.get(413)).setAttribute("height","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(415)).setAttribute("nombre","textNHijos" );
      ((Element)v.get(415)).setAttribute("id","datosCampos" );
      ((Element)v.get(415)).setAttribute("max","2" );
      ((Element)v.get(415)).setAttribute("tipo","" );
      ((Element)v.get(415)).setAttribute("onchange","" );
      ((Element)v.get(415)).setAttribute("req","N" );
      ((Element)v.get(415)).setAttribute("size","2" );
      ((Element)v.get(415)).setAttribute("valor","" );
      ((Element)v.get(415)).setAttribute("validacion","" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","25" );
      ((Element)v.get(417)).setAttribute("height","8" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(402)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(419)).setAttribute("nombre","textNPersonasDependientes" );
      ((Element)v.get(419)).setAttribute("id","datosCampos" );
      ((Element)v.get(419)).setAttribute("max","2" );
      ((Element)v.get(419)).setAttribute("tipo","" );
      ((Element)v.get(419)).setAttribute("onchange","" );
      ((Element)v.get(419)).setAttribute("req","N" );
      ((Element)v.get(419)).setAttribute("size","2" );
      ((Element)v.get(419)).setAttribute("valor","" );
      ((Element)v.get(419)).setAttribute("validacion","" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("width","100%" );
      ((Element)v.get(402)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","8" );
      ((Element)v.get(421)).setAttribute("height","8" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:402   */

      /* Empieza nodo:422 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).setAttribute("colspan","4" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:382   */

      /* Empieza nodo:425 / Elemento padre: 281   */
      v.add(doc.createElement("table"));
      ((Element)v.get(425)).setAttribute("width","100%" );
      ((Element)v.get(425)).setAttribute("border","0" );
      ((Element)v.get(425)).setAttribute("align","center" );
      ((Element)v.get(425)).setAttribute("cellspacing","0" );
      ((Element)v.get(425)).setAttribute("cellpadding","0" );
      ((Element)v.get(281)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","8" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(430)).setAttribute("nombre","lblNivelSocioEconomico" );
      ((Element)v.get(430)).setAttribute("alto","13" );
      ((Element)v.get(430)).setAttribute("filas","1" );
      ((Element)v.get(430)).setAttribute("valor","" );
      ((Element)v.get(430)).setAttribute("id","datosTitle" );
      ((Element)v.get(430)).setAttribute("cod","1107" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","25" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(434)).setAttribute("nombre","lblCicloVidaFamiliar" );
      ((Element)v.get(434)).setAttribute("alto","13" );
      ((Element)v.get(434)).setAttribute("filas","1" );
      ((Element)v.get(434)).setAttribute("valor","" );
      ((Element)v.get(434)).setAttribute("id","datosTitle" );
      ((Element)v.get(434)).setAttribute("cod","1056" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(436)).setAttribute("src","b.gif" );
      ((Element)v.get(436)).setAttribute("width","25" );
      ((Element)v.get(436)).setAttribute("height","8" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:437 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(438)).setAttribute("nombre","lblDeseaCorrespondencia" );
      ((Element)v.get(438)).setAttribute("alto","13" );
      ((Element)v.get(438)).setAttribute("filas","1" );
      ((Element)v.get(438)).setAttribute("valor","" );
      ((Element)v.get(438)).setAttribute("id","datosTitle" );
      ((Element)v.get(438)).setAttribute("cod","1050" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:439 / Elemento padre: 426   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).setAttribute("width","25" );
      ((Element)v.get(440)).setAttribute("height","8" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:441 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(442)).setAttribute("nombre","lblImporteIngresoFamiliar" );
      ((Element)v.get(442)).setAttribute("alto","13" );
      ((Element)v.get(442)).setAttribute("filas","1" );
      ((Element)v.get(442)).setAttribute("valor","" );
      ((Element)v.get(442)).setAttribute("id","datosTitle" );
      ((Element)v.get(442)).setAttribute("cod","1080" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(443)).setAttribute("width","100%" );
      ((Element)v.get(426)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(444)).setAttribute("width","8" );
      ((Element)v.get(444)).setAttribute("height","8" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:426   */

      /* Empieza nodo:445 / Elemento padre: 425   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(425)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","8" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(448)).setAttribute("valign","top" );
      ((Element)v.get(445)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(449)).setAttribute("nombre","cbNivelSocioEconomico" );
      ((Element)v.get(449)).setAttribute("id","datosCampos" );
      ((Element)v.get(449)).setAttribute("size","1" );
      ((Element)v.get(449)).setAttribute("multiple","N" );
      ((Element)v.get(449)).setAttribute("req","N" );
      ((Element)v.get(449)).setAttribute("valorinicial","" );
      ((Element)v.get(449)).setAttribute("textoinicial","" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:451 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(445)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","25" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(453)).setAttribute("valign","top" );
      ((Element)v.get(445)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(454)).setAttribute("nombre","cbCicloVidaFamiliar" );
      ((Element)v.get(454)).setAttribute("id","datosCampos" );
      ((Element)v.get(454)).setAttribute("size","1" );
      ((Element)v.get(454)).setAttribute("multiple","N" );
      ((Element)v.get(454)).setAttribute("req","N" );
      ((Element)v.get(454)).setAttribute("valorinicial","" );
      ((Element)v.get(454)).setAttribute("textoinicial","" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:456 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(445)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).setAttribute("width","25" );
      ((Element)v.get(457)).setAttribute("height","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).setAttribute("class","datosCampos" );
      ((Element)v.get(445)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(459)).setAttribute("nombre","rbDeseaCorrespondencia" );
      ((Element)v.get(459)).setAttribute("tipo","H" );
      ((Element)v.get(459)).setAttribute("id","datosCampos" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(460)).setAttribute("valor","S" );
      ((Element)v.get(460)).setAttribute("check","N" );
      ((Element)v.get(460)).setAttribute("onfocus","" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(460)).setAttribute("id","datosCampos" );
      ((Element)v.get(460)).setAttribute("cod","117" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Elemento padre:460 / Elemento actual: 461   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(460)).appendChild((Text)v.get(461));

      /* Termina nodo Texto:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 459   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(462)).setAttribute("valor","N" );
      ((Element)v.get(462)).setAttribute("check","N" );
      ((Element)v.get(462)).setAttribute("onfocus","" );
      ((Element)v.get(462)).setAttribute("id","datosCampos" );
      ((Element)v.get(462)).setAttribute("cod","87" );
      ((Element)v.get(459)).appendChild((Element)v.get(462));

      /* Elemento padre:462 / Elemento actual: 463   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(462)).appendChild((Text)v.get(463));

      /* Termina nodo Texto:463   */
      /* Termina nodo:462   */
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:464 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(445)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","25" );
      ((Element)v.get(465)).setAttribute("height","8" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(445)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(467)).setAttribute("nombre","textImporteIngresoFamiliar" );
      ((Element)v.get(467)).setAttribute("id","datosCampos" );
      ((Element)v.get(467)).setAttribute("max","12" );
      ((Element)v.get(467)).setAttribute("tipo","" );
      ((Element)v.get(467)).setAttribute("onchange","" );
      ((Element)v.get(467)).setAttribute("req","N" );
      ((Element)v.get(467)).setAttribute("size","15" );
      ((Element)v.get(467)).setAttribute("valor","" );
      ((Element)v.get(467)).setAttribute("validacion","" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).setAttribute("width","100%" );
      ((Element)v.get(445)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","8" );
      ((Element)v.get(469)).setAttribute("height","8" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:445   */

      /* Empieza nodo:470 / Elemento padre: 425   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(425)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).setAttribute("colspan","4" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","8" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:425   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:473 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).setAttribute("width","12" );
      ((Element)v.get(474)).setAttribute("height","12" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:277   */

      /* Empieza nodo:475 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
      ((Element)v.get(476)).setAttribute("width","12" );
      ((Element)v.get(476)).setAttribute("align","center" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(477)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).setAttribute("width","12" );
      ((Element)v.get(477)).setAttribute("height","15" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).setAttribute("width","750" );
      ((Element)v.get(475)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("width","12" );
      ((Element)v.get(480)).setAttribute("align","center" );
      ((Element)v.get(475)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","12" );
      ((Element)v.get(481)).setAttribute("height","15" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:475   */

      /* Empieza nodo:482 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:485 / Elemento padre: 482   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(487)).setAttribute("class","legend" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(488)).setAttribute("nombre","lblTitGrupoVinculo" );
      ((Element)v.get(488)).setAttribute("alto","13" );
      ((Element)v.get(488)).setAttribute("filas","1" );
      ((Element)v.get(488)).setAttribute("valor","" );
      ((Element)v.get(488)).setAttribute("cod","0057" );
      ((Element)v.get(488)).setAttribute("id","legend" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:489 / Elemento padre: 486   */
      v.add(doc.createElement("table"));
      ((Element)v.get(489)).setAttribute("width","100%" );
      ((Element)v.get(489)).setAttribute("border","0" );
      ((Element)v.get(489)).setAttribute("align","center" );
      ((Element)v.get(489)).setAttribute("cellspacing","0" );
      ((Element)v.get(489)).setAttribute("cellpadding","0" );
      ((Element)v.get(486)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("td"));
      ((Element)v.get(491)).setAttribute("colspan","4" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(492)).setAttribute("src","b.gif" );
      ((Element)v.get(492)).setAttribute("width","8" );
      ((Element)v.get(492)).setAttribute("height","8" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:493 / Elemento padre: 489   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(489)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","8" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(496)).setAttribute("colspan","3" );
      ((Element)v.get(493)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(497)).setAttribute("nombre","lblClienteVinculo" );
      ((Element)v.get(497)).setAttribute("alto","13" );
      ((Element)v.get(497)).setAttribute("filas","1" );
      ((Element)v.get(497)).setAttribute("valor","" );
      ((Element)v.get(497)).setAttribute("id","datosTitle" );
      ((Element)v.get(497)).setAttribute("cod","1058" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","25" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(501)).setAttribute("nombre","lblTipoVinculo" );
      ((Element)v.get(501)).setAttribute("alto","13" );
      ((Element)v.get(501)).setAttribute("filas","1" );
      ((Element)v.get(501)).setAttribute("valor","" );
      ((Element)v.get(501)).setAttribute("id","datosTitle" );
      ((Element)v.get(501)).setAttribute("cod","1131" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","25" );
      ((Element)v.get(503)).setAttribute("height","8" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(505)).setAttribute("nombre","lblFechaDesde" );
      ((Element)v.get(505)).setAttribute("alto","13" );
      ((Element)v.get(505)).setAttribute("filas","1" );
      ((Element)v.get(505)).setAttribute("valor","" );
      ((Element)v.get(505)).setAttribute("id","datosTitle" );
      ((Element)v.get(505)).setAttribute("cod","59" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","25" );
      ((Element)v.get(507)).setAttribute("height","8" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(509)).setAttribute("nombre","lblFechaHasta" );
      ((Element)v.get(509)).setAttribute("alto","13" );
      ((Element)v.get(509)).setAttribute("filas","1" );
      ((Element)v.get(509)).setAttribute("valor","" );
      ((Element)v.get(509)).setAttribute("id","datosTitle" );
      ((Element)v.get(509)).setAttribute("cod","1339" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(511)).setAttribute("src","b.gif" );
      ((Element)v.get(511)).setAttribute("width","25" );
      ((Element)v.get(511)).setAttribute("height","8" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(513)).setAttribute("nombre","lblVinculoPrincipal" );
      ((Element)v.get(513)).setAttribute("alto","13" );
      ((Element)v.get(513)).setAttribute("filas","1" );
      ((Element)v.get(513)).setAttribute("valor","" );
      ((Element)v.get(513)).setAttribute("id","datosTitle" );
      ((Element)v.get(513)).setAttribute("cod","1139" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 493   */
      v.add(doc.createElement("td"));
      ((Element)v.get(514)).setAttribute("width","100%" );
      ((Element)v.get(493)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","8" );
      ((Element)v.get(515)).setAttribute("height","8" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */
      /* Termina nodo:493   */

      /* Empieza nodo:516 / Elemento padre: 489   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(489)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(518)).setAttribute("src","b.gif" );
      ((Element)v.get(518)).setAttribute("width","8" );
      ((Element)v.get(518)).setAttribute("height","8" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */

      /* Empieza nodo:519 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(520)).setAttribute("nombre","textClienteVinculo" );
      ((Element)v.get(520)).setAttribute("id","datosCampos" );
      ((Element)v.get(520)).setAttribute("max","15" );
      ((Element)v.get(520)).setAttribute("tipo","" );
      ((Element)v.get(520)).setAttribute("onchange","" );
      ((Element)v.get(520)).setAttribute("req","N" );
      ((Element)v.get(520)).setAttribute("size","15" );
      ((Element)v.get(520)).setAttribute("valor","" );
      ((Element)v.get(520)).setAttribute("validacion","" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:521 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(522)).setAttribute("src","b.gif" );
      ((Element)v.get(522)).setAttribute("width","8" );
      ((Element)v.get(522)).setAttribute("height","8" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:523 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(524)).setAttribute("onclick","seleccionarClienteContactado('V');" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:525 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(526)).setAttribute("src","b.gif" );
      ((Element)v.get(526)).setAttribute("width","25" );
      ((Element)v.get(526)).setAttribute("height","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:527 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(527)).setAttribute("valign","top" );
      ((Element)v.get(516)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(528)).setAttribute("nombre","cbTipoVinculo" );
      ((Element)v.get(528)).setAttribute("id","datosCampos" );
      ((Element)v.get(528)).setAttribute("size","1" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(528)).setAttribute("multiple","N" );
      ((Element)v.get(528)).setAttribute("req","N" );
      ((Element)v.get(528)).setAttribute("valorinicial","" );
      ((Element)v.get(528)).setAttribute("textoinicial","" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:530 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(531)).setAttribute("width","25" );
      ((Element)v.get(531)).setAttribute("height","8" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(533)).setAttribute("nombre","textFechaD" );
      ((Element)v.get(533)).setAttribute("id","datosCampos" );
      ((Element)v.get(533)).setAttribute("max","10" );
      ((Element)v.get(533)).setAttribute("tipo","" );
      ((Element)v.get(533)).setAttribute("onchange","" );
      ((Element)v.get(533)).setAttribute("req","N" );
      ((Element)v.get(533)).setAttribute("size","12" );
      ((Element)v.get(533)).setAttribute("valor","" );
      ((Element)v.get(533)).setAttribute("validacion","" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","25" );
      ((Element)v.get(535)).setAttribute("height","8" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(537)).setAttribute("nombre","textFechaH" );
      ((Element)v.get(537)).setAttribute("id","datosCampos" );
      ((Element)v.get(537)).setAttribute("max","10" );
      ((Element)v.get(537)).setAttribute("tipo","" );
      ((Element)v.get(537)).setAttribute("onchange","" );
      ((Element)v.get(537)).setAttribute("req","N" );
      ((Element)v.get(537)).setAttribute("size","12" );
      ((Element)v.get(537)).setAttribute("valor","" );
      ((Element)v.get(537)).setAttribute("validacion","" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","25" );
      ((Element)v.get(539)).setAttribute("height","8" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(540)).setAttribute("class","datosCampos" );
      ((Element)v.get(516)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(541)).setAttribute("nombre","rbVinculoPrincipal" );
      ((Element)v.get(541)).setAttribute("tipo","H" );
      ((Element)v.get(541)).setAttribute("id","datosCampos" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(542)).setAttribute("valor","S" );
      ((Element)v.get(542)).setAttribute("check","N" );
      ((Element)v.get(542)).setAttribute("onfocus","" );
      ((Element)v.get(542)).setAttribute("id","datosCampos" );
      ((Element)v.get(542)).setAttribute("cod","117" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Elemento padre:542 / Elemento actual: 543   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(542)).appendChild((Text)v.get(543));

      /* Termina nodo Texto:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 541   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(544)).setAttribute("valor","N" );
      ((Element)v.get(544)).setAttribute("check","N" );
      ((Element)v.get(544)).setAttribute("onfocus","" );
      ((Element)v.get(544)).setAttribute("id","datosCampos" );
      ((Element)v.get(544)).setAttribute("cod","87" );
      ((Element)v.get(541)).appendChild((Element)v.get(544));

      /* Elemento padre:544 / Elemento actual: 545   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(544)).appendChild((Text)v.get(545));

      /* Termina nodo Texto:545   */
      /* Termina nodo:544   */
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:546 / Elemento padre: 516   */
      v.add(doc.createElement("td"));
      ((Element)v.get(546)).setAttribute("width","100%" );
      ((Element)v.get(516)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","8" );
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:516   */

      /* Empieza nodo:548 / Elemento padre: 489   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(489)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).setAttribute("colspan","4" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).setAttribute("width","8" );
      ((Element)v.get(550)).setAttribute("height","8" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:489   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:551 / Elemento padre: 482   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","8" );
      ((Element)v.get(552)).setAttribute("height","12" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:482   */

      /* Empieza nodo:553 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(554)).setAttribute("width","12" );
      ((Element)v.get(554)).setAttribute("align","center" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(555)).setAttribute("src","b.gif" );
      ((Element)v.get(555)).setAttribute("width","12" );
      ((Element)v.get(555)).setAttribute("height","15" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:556 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(556)).setAttribute("width","750" );
      ((Element)v.get(553)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(557)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:558 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("width","12" );
      ((Element)v.get(558)).setAttribute("align","center" );
      ((Element)v.get(553)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","12" );
      ((Element)v.get(559)).setAttribute("height","15" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:553   */

      /* Empieza nodo:560 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(563)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(565)).setAttribute("class","legend" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(566)).setAttribute("nombre","lblTitGrupoPreferencias" );
      ((Element)v.get(566)).setAttribute("alto","13" );
      ((Element)v.get(566)).setAttribute("filas","1" );
      ((Element)v.get(566)).setAttribute("valor","" );
      ((Element)v.get(566)).setAttribute("cod","0055" );
      ((Element)v.get(566)).setAttribute("id","legend" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 564   */
      v.add(doc.createElement("table"));
      ((Element)v.get(567)).setAttribute("width","100%" );
      ((Element)v.get(567)).setAttribute("border","0" );
      ((Element)v.get(567)).setAttribute("align","center" );
      ((Element)v.get(567)).setAttribute("cellspacing","0" );
      ((Element)v.get(567)).setAttribute("cellpadding","0" );
      ((Element)v.get(564)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(567)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(569)).setAttribute("colspan","4" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","8" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:571 / Elemento padre: 567   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(567)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","8" );
      ((Element)v.get(573)).setAttribute("height","8" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(571)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(575)).setAttribute("nombre","lblTipoPreferencia" );
      ((Element)v.get(575)).setAttribute("alto","13" );
      ((Element)v.get(575)).setAttribute("filas","1" );
      ((Element)v.get(575)).setAttribute("valor","" );
      ((Element)v.get(575)).setAttribute("id","datosTitle" );
      ((Element)v.get(575)).setAttribute("cod","1127" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","25" );
      ((Element)v.get(577)).setAttribute("height","8" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(579)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(579)).setAttribute("alto","13" );
      ((Element)v.get(579)).setAttribute("filas","1" );
      ((Element)v.get(579)).setAttribute("valor","" );
      ((Element)v.get(579)).setAttribute("id","datosTitle" );
      ((Element)v.get(579)).setAttribute("cod","9" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(580)).setAttribute("width","100%" );
      ((Element)v.get(571)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("width","8" );
      ((Element)v.get(581)).setAttribute("height","8" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:571   */

      /* Empieza nodo:582 / Elemento padre: 567   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(567)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","8" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(585)).setAttribute("valign","top" );
      ((Element)v.get(582)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(586)).setAttribute("nombre","cb" );
      ((Element)v.get(586)).setAttribute("id","datosCampos" );
      ((Element)v.get(586)).setAttribute("size","1" );
      ((Element)v.get(586)).setAttribute("multiple","N" );
      ((Element)v.get(586)).setAttribute("req","N" );
      ((Element)v.get(586)).setAttribute("valorinicial","" );
      ((Element)v.get(586)).setAttribute("textoinicial","" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:588 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).setAttribute("width","25" );
      ((Element)v.get(589)).setAttribute("height","8" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(590)).setAttribute("valign","top" );
      ((Element)v.get(582)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(591)).setAttribute("cols","50" );
      ((Element)v.get(591)).setAttribute("id","datosCampos" );
      ((Element)v.get(591)).setAttribute("nombre","textDescripcion" );
      ((Element)v.get(591)).setAttribute("readonly","N" );
      ((Element)v.get(591)).setAttribute("req","N" );
      ((Element)v.get(591)).setAttribute("rows","3" );
      ((Element)v.get(591)).setAttribute("tabindex","2" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).setAttribute("width","100%" );
      ((Element)v.get(582)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).setAttribute("width","8" );
      ((Element)v.get(593)).setAttribute("height","8" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */
      /* Termina nodo:582   */

      /* Empieza nodo:594 / Elemento padre: 567   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(567)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).setAttribute("colspan","4" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(596)).setAttribute("width","8" );
      ((Element)v.get(596)).setAttribute("height","8" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */
      /* Termina nodo:594   */
      /* Termina nodo:567   */
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:597 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(598)).setAttribute("src","b.gif" );
      ((Element)v.get(598)).setAttribute("width","8" );
      ((Element)v.get(598)).setAttribute("height","12" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */
      /* Termina nodo:560   */

      /* Empieza nodo:599 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(600)).setAttribute("width","12" );
      ((Element)v.get(600)).setAttribute("align","center" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(601)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).setAttribute("width","12" );
      ((Element)v.get(601)).setAttribute("height","15" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:602 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).setAttribute("width","750" );
      ((Element)v.get(599)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(604)).setAttribute("width","12" );
      ((Element)v.get(604)).setAttribute("align","center" );
      ((Element)v.get(599)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("width","12" );
      ((Element)v.get(605)).setAttribute("height","15" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */
      /* Termina nodo:599   */

      /* Empieza nodo:606 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(611)).setAttribute("class","legend" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(612)).setAttribute("nombre","lblTitGrupoPrimerContacto" );
      ((Element)v.get(612)).setAttribute("alto","13" );
      ((Element)v.get(612)).setAttribute("filas","1" );
      ((Element)v.get(612)).setAttribute("valor","" );
      ((Element)v.get(612)).setAttribute("cod","0056" );
      ((Element)v.get(612)).setAttribute("id","legend" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 610   */
      v.add(doc.createElement("table"));
      ((Element)v.get(613)).setAttribute("width","100%" );
      ((Element)v.get(613)).setAttribute("border","0" );
      ((Element)v.get(613)).setAttribute("align","center" );
      ((Element)v.get(613)).setAttribute("cellspacing","0" );
      ((Element)v.get(613)).setAttribute("cellpadding","0" );
      ((Element)v.get(610)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(615)).setAttribute("colspan","4" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(616)).setAttribute("src","b.gif" );
      ((Element)v.get(616)).setAttribute("width","8" );
      ((Element)v.get(616)).setAttribute("height","8" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:617 / Elemento padre: 613   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(613)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(619)).setAttribute("src","b.gif" );
      ((Element)v.get(619)).setAttribute("width","8" );
      ((Element)v.get(619)).setAttribute("height","8" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */

      /* Empieza nodo:620 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).setAttribute("colspan","3" );
      ((Element)v.get(617)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(621)).setAttribute("nombre","lblCodClienteContactado" );
      ((Element)v.get(621)).setAttribute("alto","13" );
      ((Element)v.get(621)).setAttribute("filas","1" );
      ((Element)v.get(621)).setAttribute("valor","" );
      ((Element)v.get(621)).setAttribute("id","datosTitle" );
      ((Element)v.get(621)).setAttribute("cod","1060" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */

      /* Empieza nodo:622 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(623)).setAttribute("src","b.gif" );
      ((Element)v.get(623)).setAttribute("width","25" );
      ((Element)v.get(623)).setAttribute("height","8" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:622   */

      /* Empieza nodo:624 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(625)).setAttribute("nombre","lblTipoClienteContactado" );
      ((Element)v.get(625)).setAttribute("alto","13" );
      ((Element)v.get(625)).setAttribute("filas","1" );
      ((Element)v.get(625)).setAttribute("valor","" );
      ((Element)v.get(625)).setAttribute("id","datosTitle" );
      ((Element)v.get(625)).setAttribute("cod","1125" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */

      /* Empieza nodo:626 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(627)).setAttribute("src","b.gif" );
      ((Element)v.get(627)).setAttribute("width","25" );
      ((Element)v.get(627)).setAttribute("height","8" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:628 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(629)).setAttribute("nombre","lblCodTipoContacto" );
      ((Element)v.get(629)).setAttribute("alto","13" );
      ((Element)v.get(629)).setAttribute("filas","1" );
      ((Element)v.get(629)).setAttribute("valor","" );
      ((Element)v.get(629)).setAttribute("id","datosTitle" );
      ((Element)v.get(629)).setAttribute("cod","1065" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:630 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(631)).setAttribute("width","25" );
      ((Element)v.get(631)).setAttribute("height","8" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(633)).setAttribute("nombre","lblFechaContacto" );
      ((Element)v.get(633)).setAttribute("alto","13" );
      ((Element)v.get(633)).setAttribute("filas","1" );
      ((Element)v.get(633)).setAttribute("valor","" );
      ((Element)v.get(633)).setAttribute("id","datosTitle" );
      ((Element)v.get(633)).setAttribute("cod","1078" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */

      /* Empieza nodo:634 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(635)).setAttribute("src","b.gif" );
      ((Element)v.get(635)).setAttribute("width","25" );
      ((Element)v.get(635)).setAttribute("height","8" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */

      /* Empieza nodo:636 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(637)).setAttribute("nombre","lblFechaSiguienteContacto" );
      ((Element)v.get(637)).setAttribute("alto","13" );
      ((Element)v.get(637)).setAttribute("filas","1" );
      ((Element)v.get(637)).setAttribute("valor","" );
      ((Element)v.get(637)).setAttribute("id","datosTitle" );
      ((Element)v.get(637)).setAttribute("cod","1342" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:638 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(638)).setAttribute("width","100%" );
      ((Element)v.get(617)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(639)).setAttribute("src","b.gif" );
      ((Element)v.get(639)).setAttribute("width","8" );
      ((Element)v.get(639)).setAttribute("height","8" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */
      /* Termina nodo:617   */

      /* Empieza nodo:640 / Elemento padre: 613   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(613)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(642)).setAttribute("src","b.gif" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(642)).setAttribute("width","8" );
      ((Element)v.get(642)).setAttribute("height","8" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:641   */

      /* Empieza nodo:643 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(644)).setAttribute("nombre","textCodClienteContactado" );
      ((Element)v.get(644)).setAttribute("id","datosCampos" );
      ((Element)v.get(644)).setAttribute("max","15" );
      ((Element)v.get(644)).setAttribute("tipo","" );
      ((Element)v.get(644)).setAttribute("onchange","" );
      ((Element)v.get(644)).setAttribute("req","N" );
      ((Element)v.get(644)).setAttribute("size","15" );
      ((Element)v.get(644)).setAttribute("valor","" );
      ((Element)v.get(644)).setAttribute("validacion","" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */
      /* Termina nodo:643   */

      /* Empieza nodo:645 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(646)).setAttribute("src","b.gif" );
      ((Element)v.get(646)).setAttribute("width","8" );
      ((Element)v.get(646)).setAttribute("height","8" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */

      /* Empieza nodo:647 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(648)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(648)).setAttribute("onclick","seleccionarClienteContactado('C');" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:647   */

      /* Empieza nodo:649 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(650)).setAttribute("src","b.gif" );
      ((Element)v.get(650)).setAttribute("width","25" );
      ((Element)v.get(650)).setAttribute("height","8" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */
      /* Termina nodo:649   */

      /* Empieza nodo:651 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(651)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(651)).setAttribute("valign","top" );
      ((Element)v.get(640)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(652)).setAttribute("nombre","cbTipoClienteContactado" );
      ((Element)v.get(652)).setAttribute("id","datosCampos" );
      ((Element)v.get(652)).setAttribute("size","1" );
      ((Element)v.get(652)).setAttribute("multiple","N" );
      ((Element)v.get(652)).setAttribute("req","N" );
      ((Element)v.get(652)).setAttribute("valorinicial","" );
      ((Element)v.get(652)).setAttribute("textoinicial","" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(652)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:652   */
      /* Termina nodo:651   */

      /* Empieza nodo:654 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(655)).setAttribute("src","b.gif" );
      ((Element)v.get(655)).setAttribute("width","25" );
      ((Element)v.get(655)).setAttribute("height","8" );
      ((Element)v.get(654)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:654   */

      /* Empieza nodo:656 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(657)).setAttribute("nombre","cbCodTipoContactado" );
      ((Element)v.get(657)).setAttribute("id","datosCampos" );
      ((Element)v.get(657)).setAttribute("size","1" );
      ((Element)v.get(657)).setAttribute("multiple","N" );
      ((Element)v.get(657)).setAttribute("req","N" );
      ((Element)v.get(657)).setAttribute("valorinicial","" );
      ((Element)v.get(657)).setAttribute("textoinicial","" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(657)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(658)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(660)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(660)).setAttribute("TIPO","STRING" );
      ((Element)v.get(660)).setAttribute("VALOR","I" );
      ((Element)v.get(659)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */

      /* Empieza nodo:661 / Elemento padre: 659   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(661)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(661)).setAttribute("TIPO","STRING" );
      ((Element)v.get(661)).setAttribute("VALOR","Inbound" );
      ((Element)v.get(659)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */
      /* Termina nodo:659   */

      /* Empieza nodo:662 / Elemento padre: 658   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(658)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(663)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(663)).setAttribute("TIPO","STRING" );
      ((Element)v.get(663)).setAttribute("VALOR","O" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */

      /* Empieza nodo:664 / Elemento padre: 662   */
   }

   private void getXML2790(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(664)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(664)).setAttribute("TIPO","STRING" );
      ((Element)v.get(664)).setAttribute("VALOR","Outbound" );
      ((Element)v.get(662)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:662   */
      /* Termina nodo:658   */
      /* Termina nodo:657   */
      /* Termina nodo:656   */

      /* Empieza nodo:665 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(666)).setAttribute("src","b.gif" );
      ((Element)v.get(666)).setAttribute("width","25" );
      ((Element)v.get(666)).setAttribute("height","8" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */
      /* Termina nodo:665   */

      /* Empieza nodo:667 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(668)).setAttribute("nombre","textFechaContacto" );
      ((Element)v.get(668)).setAttribute("id","datosCampos" );
      ((Element)v.get(668)).setAttribute("max","10" );
      ((Element)v.get(668)).setAttribute("tipo","" );
      ((Element)v.get(668)).setAttribute("onchange","" );
      ((Element)v.get(668)).setAttribute("req","N" );
      ((Element)v.get(668)).setAttribute("size","12" );
      ((Element)v.get(668)).setAttribute("valor","" );
      ((Element)v.get(668)).setAttribute("validacion","" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:667   */

      /* Empieza nodo:669 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(670)).setAttribute("src","b.gif" );
      ((Element)v.get(670)).setAttribute("width","25" );
      ((Element)v.get(670)).setAttribute("height","8" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */
      /* Termina nodo:669   */

      /* Empieza nodo:671 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(672)).setAttribute("nombre","textFechaSiguienteContacto" );
      ((Element)v.get(672)).setAttribute("id","datosCampos" );
      ((Element)v.get(672)).setAttribute("max","10" );
      ((Element)v.get(672)).setAttribute("tipo","" );
      ((Element)v.get(672)).setAttribute("onchange","" );
      ((Element)v.get(672)).setAttribute("req","N" );
      ((Element)v.get(672)).setAttribute("size","12" );
      ((Element)v.get(672)).setAttribute("valor","" );
      ((Element)v.get(672)).setAttribute("validacion","" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:671   */

      /* Empieza nodo:673 / Elemento padre: 640   */
      v.add(doc.createElement("td"));
      ((Element)v.get(673)).setAttribute("width","100%" );
      ((Element)v.get(640)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(674)).setAttribute("src","b.gif" );
      ((Element)v.get(674)).setAttribute("width","8" );
      ((Element)v.get(674)).setAttribute("height","8" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:673   */
      /* Termina nodo:640   */

      /* Empieza nodo:675 / Elemento padre: 613   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(613)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("td"));
      ((Element)v.get(676)).setAttribute("colspan","4" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(677)).setAttribute("src","b.gif" );
      ((Element)v.get(677)).setAttribute("width","8" );
      ((Element)v.get(677)).setAttribute("height","8" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */
      /* Termina nodo:676   */
      /* Termina nodo:675   */
      /* Termina nodo:613   */

      /* Empieza nodo:678 / Elemento padre: 610   */
      v.add(doc.createElement("table"));
      ((Element)v.get(678)).setAttribute("width","100%" );
      ((Element)v.get(678)).setAttribute("border","0" );
      ((Element)v.get(678)).setAttribute("align","center" );
      ((Element)v.get(678)).setAttribute("cellspacing","0" );
      ((Element)v.get(678)).setAttribute("cellpadding","0" );
      ((Element)v.get(610)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(678)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(679)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(681)).setAttribute("src","b.gif" );
      ((Element)v.get(681)).setAttribute("width","8" );
      ((Element)v.get(681)).setAttribute("height","8" );
      ((Element)v.get(680)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:680   */

      /* Empieza nodo:682 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(679)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(683)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(683)).setAttribute("alto","13" );
      ((Element)v.get(683)).setAttribute("filas","1" );
      ((Element)v.get(683)).setAttribute("valor","" );
      ((Element)v.get(683)).setAttribute("id","datosTitle" );
      ((Element)v.get(683)).setAttribute("cod","6" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */
      /* Termina nodo:682   */

      /* Empieza nodo:684 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(679)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(685)).setAttribute("src","b.gif" );
      ((Element)v.get(685)).setAttribute("width","25" );
      ((Element)v.get(685)).setAttribute("height","8" );
      ((Element)v.get(684)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */
      /* Termina nodo:684   */

      /* Empieza nodo:686 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(679)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(687)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(687)).setAttribute("alto","13" );
      ((Element)v.get(687)).setAttribute("filas","1" );
      ((Element)v.get(687)).setAttribute("valor","" );
      ((Element)v.get(687)).setAttribute("id","datosTitle" );
      ((Element)v.get(687)).setAttribute("cod","7" );
      ((Element)v.get(686)).appendChild((Element)v.get(687));
      /* Termina nodo:687   */
      /* Termina nodo:686   */

      /* Empieza nodo:688 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(679)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(689)).setAttribute("src","b.gif" );
      ((Element)v.get(689)).setAttribute("width","25" );
      ((Element)v.get(689)).setAttribute("height","8" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */
      /* Termina nodo:688   */

      /* Empieza nodo:690 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(679)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(691)).setAttribute("nombre","lblPeriodoPrimerPedido" );
      ((Element)v.get(691)).setAttribute("alto","13" );
      ((Element)v.get(691)).setAttribute("filas","1" );
      ((Element)v.get(691)).setAttribute("valor","" );
      ((Element)v.get(691)).setAttribute("id","datosTitle" );
      ((Element)v.get(691)).setAttribute("cod","2420" );
      ((Element)v.get(690)).appendChild((Element)v.get(691));
      /* Termina nodo:691   */
      /* Termina nodo:690   */

      /* Empieza nodo:692 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(692)).setAttribute("width","100%" );
      ((Element)v.get(679)).appendChild((Element)v.get(692));

      /* Empieza nodo:693 / Elemento padre: 692   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(693)).setAttribute("src","b.gif" );
      ((Element)v.get(693)).setAttribute("width","8" );
      ((Element)v.get(693)).setAttribute("height","8" );
      ((Element)v.get(692)).appendChild((Element)v.get(693));
      /* Termina nodo:693   */
      /* Termina nodo:692   */
      /* Termina nodo:679   */

      /* Empieza nodo:694 / Elemento padre: 678   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(678)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("td"));
      ((Element)v.get(694)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(696)).setAttribute("src","b.gif" );
      ((Element)v.get(696)).setAttribute("width","8" );
      ((Element)v.get(696)).setAttribute("height","8" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:697 / Elemento padre: 694   */
      v.add(doc.createElement("td"));
      ((Element)v.get(694)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(698)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(698)).setAttribute("id","datosCampos" );
      ((Element)v.get(698)).setAttribute("size","1" );
      ((Element)v.get(698)).setAttribute("multiple","N" );
      ((Element)v.get(698)).setAttribute("req","N" );
      ((Element)v.get(698)).setAttribute("valorinicial","" );
      ((Element)v.get(698)).setAttribute("textoinicial","" );
      ((Element)v.get(698)).setAttribute("onchange","cambiarPeriodoContacto('', 'cbMarca');" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(698)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */
      /* Termina nodo:698   */
      /* Termina nodo:697   */

      /* Empieza nodo:700 / Elemento padre: 694   */
      v.add(doc.createElement("td"));
      ((Element)v.get(694)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(701)).setAttribute("src","b.gif" );
      ((Element)v.get(701)).setAttribute("width","25" );
      ((Element)v.get(701)).setAttribute("height","8" );
      ((Element)v.get(700)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */
      /* Termina nodo:700   */

      /* Empieza nodo:702 / Elemento padre: 694   */
      v.add(doc.createElement("td"));
      ((Element)v.get(694)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(703)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(703)).setAttribute("id","datosCampos" );
      ((Element)v.get(703)).setAttribute("size","1" );
      ((Element)v.get(703)).setAttribute("multiple","N" );
      ((Element)v.get(703)).setAttribute("req","N" );
      ((Element)v.get(703)).setAttribute("valorinicial","" );
      ((Element)v.get(703)).setAttribute("textoinicial","" );
      ((Element)v.get(703)).setAttribute("onchange","cambiarPeriodoContacto('', 'cbCanal');" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:703   */
      /* Termina nodo:702   */

      /* Empieza nodo:705 / Elemento padre: 694   */
      v.add(doc.createElement("td"));
      ((Element)v.get(694)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(706)).setAttribute("src","b.gif" );
      ((Element)v.get(706)).setAttribute("width","25" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(706)).setAttribute("height","8" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */
      /* Termina nodo:705   */

      /* Empieza nodo:707 / Elemento padre: 694   */
      v.add(doc.createElement("td"));
      ((Element)v.get(694)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(708)).setAttribute("nombre","cbPeriodoPrimerPedido" );
      ((Element)v.get(708)).setAttribute("id","datosCampos" );
      ((Element)v.get(708)).setAttribute("size","1" );
      ((Element)v.get(708)).setAttribute("multiple","N" );
      ((Element)v.get(708)).setAttribute("req","N" );
      ((Element)v.get(708)).setAttribute("valorinicial","" );
      ((Element)v.get(708)).setAttribute("textoinicial","" );
      ((Element)v.get(707)).appendChild((Element)v.get(708));

      /* Empieza nodo:709 / Elemento padre: 708   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(708)).appendChild((Element)v.get(709));
      /* Termina nodo:709   */
      /* Termina nodo:708   */
      /* Termina nodo:707   */

      /* Empieza nodo:710 / Elemento padre: 694   */
      v.add(doc.createElement("td"));
      ((Element)v.get(710)).setAttribute("width","100%" );
      ((Element)v.get(694)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(711)).setAttribute("src","b.gif" );
      ((Element)v.get(711)).setAttribute("width","8" );
      ((Element)v.get(711)).setAttribute("height","8" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */
      /* Termina nodo:694   */

      /* Empieza nodo:712 / Elemento padre: 678   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(678)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("td"));
      ((Element)v.get(713)).setAttribute("colspan","4" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));

      /* Empieza nodo:714 / Elemento padre: 713   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(714)).setAttribute("src","b.gif" );
      ((Element)v.get(714)).setAttribute("width","8" );
      ((Element)v.get(714)).setAttribute("height","8" );
      ((Element)v.get(713)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */
      /* Termina nodo:713   */
      /* Termina nodo:712   */
      /* Termina nodo:678   */
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:715 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).appendChild((Element)v.get(715));

      /* Empieza nodo:716 / Elemento padre: 715   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(716)).setAttribute("src","b.gif" );
      ((Element)v.get(716)).setAttribute("width","8" );
      ((Element)v.get(716)).setAttribute("height","12" );
      ((Element)v.get(715)).appendChild((Element)v.get(716));
      /* Termina nodo:716   */
      /* Termina nodo:715   */
      /* Termina nodo:606   */

      /* Empieza nodo:717 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("td"));
      ((Element)v.get(717)).appendChild((Element)v.get(718));

      /* Empieza nodo:719 / Elemento padre: 718   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(719)).setAttribute("src","b.gif" );
      ((Element)v.get(718)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */
      /* Termina nodo:718   */

      /* Empieza nodo:720 / Elemento padre: 717   */
      v.add(doc.createElement("td"));
      ((Element)v.get(717)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(720)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("table"));
      ((Element)v.get(722)).setAttribute("width","100%" );
      ((Element)v.get(722)).setAttribute("border","0" );
      ((Element)v.get(722)).setAttribute("align","center" );
      ((Element)v.get(722)).setAttribute("cellspacing","0" );
      ((Element)v.get(722)).setAttribute("cellpadding","0" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(722)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("td"));
      ((Element)v.get(724)).setAttribute("class","botonera" );
      ((Element)v.get(723)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(725)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(725)).setAttribute("ID","botonContenido" );
      ((Element)v.get(725)).setAttribute("tipo","html" );
      ((Element)v.get(725)).setAttribute("accion","siguientePestanya(3);" );
      ((Element)v.get(725)).setAttribute("estado","false" );
      ((Element)v.get(725)).setAttribute("cod","446" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */

      /* Empieza nodo:726 / Elemento padre: 724   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(726)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(726)).setAttribute("ID","botonContenido" );
      ((Element)v.get(726)).setAttribute("tipo","html" );
      ((Element)v.get(726)).setAttribute("ontab","siguientePestanya(3);" );
      ((Element)v.get(726)).setAttribute("accion","buscar();" );
      ((Element)v.get(726)).setAttribute("estado","false" );
      ((Element)v.get(726)).setAttribute("cod","1" );
      ((Element)v.get(724)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */
      /* Termina nodo:724   */
      /* Termina nodo:723   */
      /* Termina nodo:722   */
      /* Termina nodo:721   */
      /* Termina nodo:720   */

      /* Empieza nodo:727 / Elemento padre: 717   */
      v.add(doc.createElement("td"));
      ((Element)v.get(717)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(728)).setAttribute("src","b.gif" );
      ((Element)v.get(728)).setAttribute("width","8" );
      ((Element)v.get(728)).setAttribute("height","12" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:727   */
      /* Termina nodo:717   */

      /* Empieza nodo:729 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("td"));
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(730)).setAttribute("width","12" );
      ((Element)v.get(730)).setAttribute("align","center" );
      ((Element)v.get(729)).appendChild((Element)v.get(730));

      /* Empieza nodo:731 / Elemento padre: 730   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(731)).setAttribute("src","b.gif" );
      ((Element)v.get(731)).setAttribute("width","12" );
      ((Element)v.get(731)).setAttribute("height","12" );
      ((Element)v.get(730)).appendChild((Element)v.get(731));
      /* Termina nodo:731   */
      /* Termina nodo:730   */

      /* Empieza nodo:732 / Elemento padre: 729   */
      v.add(doc.createElement("td"));
      ((Element)v.get(732)).setAttribute("width","750" );
      ((Element)v.get(729)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(733)).setAttribute("src","b.gif" );
      ((Element)v.get(732)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */
      /* Termina nodo:732   */

      /* Empieza nodo:734 / Elemento padre: 729   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).setAttribute("width","12" );
      ((Element)v.get(729)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(735)).setAttribute("src","b.gif" );
      ((Element)v.get(735)).setAttribute("width","12" );
      ((Element)v.get(735)).setAttribute("height","12" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */
      /* Termina nodo:729   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:4   */

      /* Empieza nodo:736 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(736)).setAttribute("nombre","frmUnicoBusq" );
      ((Element)v.get(736)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(737)).setAttribute("nombre","accion" );
      ((Element)v.get(737)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */

      /* Empieza nodo:738 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(738)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(738)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */

      /* Empieza nodo:739 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(739)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(739)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */

      /* Empieza nodo:740 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(740)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(740)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */

      /* Empieza nodo:741 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(741)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(741)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */

      /* Empieza nodo:742 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(742)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(742)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */

      /* Empieza nodo:743 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(743)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(743)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */

      /* Empieza nodo:744 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(744)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(744)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */

      /* Empieza nodo:745 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(745)).setAttribute("nombre","hidTipoSubtipo" );
      ((Element)v.get(745)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */

      /* Empieza nodo:746 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(746)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(746)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */

      /* Empieza nodo:747 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(747)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(747)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */

      /* Empieza nodo:748 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(748)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(748)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(748));
      /* Termina nodo:748   */

      /* Empieza nodo:749 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(749)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(749)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */

      /* Empieza nodo:750 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(750)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(750)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */

      /* Empieza nodo:751 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(751)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(751)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */

      /* Empieza nodo:752 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(752)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(752)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */

      /* Empieza nodo:753 / Elemento padre: 736   */
   }

   private void getXML3150(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(753)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(753)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */

      /* Empieza nodo:754 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(754)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(754)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(754));
      /* Termina nodo:754   */

      /* Empieza nodo:755 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(755)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(755)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */

      /* Empieza nodo:756 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(756)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(756)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */

      /* Empieza nodo:757 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(757)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(757)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */

      /* Empieza nodo:758 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(758)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(758)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */

      /* Empieza nodo:759 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(759)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(759)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(759));
      /* Termina nodo:759   */

      /* Empieza nodo:760 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(760)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(760)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */

      /* Empieza nodo:761 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(761)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(761)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(761));
      /* Termina nodo:761   */

      /* Empieza nodo:762 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(762)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(762)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */

      /* Empieza nodo:763 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(763)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(763)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(763));
      /* Termina nodo:763   */

      /* Empieza nodo:764 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(764)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(764)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */

      /* Empieza nodo:765 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(765)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(765)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(765));
      /* Termina nodo:765   */

      /* Empieza nodo:766 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(766)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(766)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */

      /* Empieza nodo:767 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(767)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(767)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(767));
      /* Termina nodo:767   */

      /* Empieza nodo:768 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(768)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(768)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(768));
      /* Termina nodo:768   */

      /* Empieza nodo:769 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(769)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(769)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */

      /* Empieza nodo:770 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(770)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(770)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(770));
      /* Termina nodo:770   */

      /* Empieza nodo:771 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(771)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(771)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */

      /* Empieza nodo:772 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(772)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(772)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */

      /* Empieza nodo:773 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(773)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(773)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */

      /* Empieza nodo:774 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(774)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(774)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(774));
      /* Termina nodo:774   */

      /* Empieza nodo:775 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(775)).setAttribute("nombre","hidcbPaisVinculo" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(775)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(775));
      /* Termina nodo:775   */

      /* Empieza nodo:776 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(776)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(776)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(776));
      /* Termina nodo:776   */

      /* Empieza nodo:777 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(777)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(777)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(777));
      /* Termina nodo:777   */

      /* Empieza nodo:778 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(778)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(778)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(778));
      /* Termina nodo:778   */

      /* Empieza nodo:779 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(779)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(779)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(779));
      /* Termina nodo:779   */

      /* Empieza nodo:780 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(780)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(780)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(780));
      /* Termina nodo:780   */

      /* Empieza nodo:781 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(781)).setAttribute("nombre","hidcb" );
      ((Element)v.get(781)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(781));
      /* Termina nodo:781   */

      /* Empieza nodo:782 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(782)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(782)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(782));
      /* Termina nodo:782   */

      /* Empieza nodo:783 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(783)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(783)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(783));
      /* Termina nodo:783   */

      /* Empieza nodo:784 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(784)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(784)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(784));
      /* Termina nodo:784   */

      /* Empieza nodo:785 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(785)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(785)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */

      /* Empieza nodo:786 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(786)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(786)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(786));
      /* Termina nodo:786   */

      /* Empieza nodo:787 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(787)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(787)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(787));
      /* Termina nodo:787   */

      /* Empieza nodo:788 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(788)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(788)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(788));
      /* Termina nodo:788   */

      /* Empieza nodo:789 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(789)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(789)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(789));
      /* Termina nodo:789   */

      /* Empieza nodo:790 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(790)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(790)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(790));
      /* Termina nodo:790   */

      /* Empieza nodo:791 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(791)).setAttribute("nombre","hidcbMarcaContacto" );
      ((Element)v.get(791)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */

      /* Empieza nodo:792 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(792)).setAttribute("nombre","hidcbCanalContacto" );
      ((Element)v.get(792)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(792));
      /* Termina nodo:792   */

      /* Empieza nodo:793 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(793)).setAttribute("nombre","hidcbPeriodoPrimerPedido" );
      ((Element)v.get(793)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(793));
      /* Termina nodo:793   */

      /* Empieza nodo:794 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(794)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(794)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(794));
      /* Termina nodo:794   */

      /* Empieza nodo:795 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(795)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(795)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(795));
      /* Termina nodo:795   */

      /* Empieza nodo:796 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(796)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(796)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(796));
      /* Termina nodo:796   */

      /* Empieza nodo:797 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(797)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(797)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(797));
      /* Termina nodo:797   */

      /* Empieza nodo:798 / Elemento padre: 736   */
   }

   private void getXML3330(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(798)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(798)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(798));
      /* Termina nodo:798   */

      /* Empieza nodo:799 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(799)).setAttribute("nombre","hidtextInterior" );
      ((Element)v.get(799)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(799));
      /* Termina nodo:799   */

      /* Empieza nodo:800 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(800)).setAttribute("nombre","hidtextManzana" );
      ((Element)v.get(800)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(800));
      /* Termina nodo:800   */

      /* Empieza nodo:801 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(801)).setAttribute("nombre","hidtextLote" );
      ((Element)v.get(801)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(801));
      /* Termina nodo:801   */

      /* Empieza nodo:802 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(802)).setAttribute("nombre","hidtextKm" );
      ((Element)v.get(802)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(802));
      /* Termina nodo:802   */

      /* Empieza nodo:803 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(803)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(803)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(803));
      /* Termina nodo:803   */

      /* Empieza nodo:804 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(804)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(804)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(804));
      /* Termina nodo:804   */

      /* Empieza nodo:805 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(805)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(805)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(805));
      /* Termina nodo:805   */

      /* Empieza nodo:806 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(806)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(806)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(806));
      /* Termina nodo:806   */

      /* Empieza nodo:807 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(807)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(807)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(807));
      /* Termina nodo:807   */

      /* Empieza nodo:808 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(808)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(808)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(808));
      /* Termina nodo:808   */

      /* Empieza nodo:809 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(809)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(809)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(809));
      /* Termina nodo:809   */

      /* Empieza nodo:810 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(810)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(810)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(810));
      /* Termina nodo:810   */

      /* Empieza nodo:811 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(811)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(811)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(811));
      /* Termina nodo:811   */

      /* Empieza nodo:812 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(812)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(812)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(812));
      /* Termina nodo:812   */

      /* Empieza nodo:813 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(813)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(813)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */

      /* Empieza nodo:814 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(814)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(814)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(814));
      /* Termina nodo:814   */

      /* Empieza nodo:815 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(815)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(815)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(815));
      /* Termina nodo:815   */

      /* Empieza nodo:816 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(816)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(816)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(816));
      /* Termina nodo:816   */

      /* Empieza nodo:817 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(817)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(817)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(817));
      /* Termina nodo:817   */

      /* Empieza nodo:818 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(818)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(818)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(818));
      /* Termina nodo:818   */

      /* Empieza nodo:819 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(819)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(819)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(819));
      /* Termina nodo:819   */

      /* Empieza nodo:820 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(820)).setAttribute("nombre","hidcbTipoProblema" );
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(820)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */

      /* Empieza nodo:821 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(821)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(821)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(821));
      /* Termina nodo:821   */

      /* Empieza nodo:822 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(822)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(822)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */

      /* Empieza nodo:823 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(823)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(823)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(823));
      /* Termina nodo:823   */

      /* Empieza nodo:824 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(824)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(824)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(824));
      /* Termina nodo:824   */

      /* Empieza nodo:825 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(825)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(825)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(825));
      /* Termina nodo:825   */

      /* Empieza nodo:826 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(826)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(826)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(826));
      /* Termina nodo:826   */

      /* Empieza nodo:827 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(827)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(827)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(827));
      /* Termina nodo:827   */

      /* Empieza nodo:828 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(828)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(828)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(828));
      /* Termina nodo:828   */

      /* Empieza nodo:829 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(829)).setAttribute("nombre","hiddenTipoCliente" );
      ((Element)v.get(829)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(829));
      /* Termina nodo:829   */

      /* Empieza nodo:830 / Elemento padre: 736   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(830)).setAttribute("nombre","hiddenSubTipoCliente" );
      ((Element)v.get(830)).setAttribute("valor","" );
      ((Element)v.get(736)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */
      /* Termina nodo:736   */


   }

}
