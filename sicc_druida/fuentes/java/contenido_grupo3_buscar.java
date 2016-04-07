
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupo3_buscar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupo3_buscar" );
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
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_grupo3_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmUnico" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","geoReferenciador" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hiddenTipoCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hiddenSubTipoCliente" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidTipoSubtipo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidIndActivo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(44)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidcb" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidcbMarcaContacto" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidcbCanalContacto" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("nombre","hidcbPeriodoPrimerPedido" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hibTextCbVia" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(89)).setAttribute("valor","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hCadenaParams" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(100)).setAttribute("height","100%" );
      ((Element)v.get(100)).setAttribute("border","0" );
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(100)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
      ((Element)v.get(100)).setAttribute("class","menu4" );
      ((Element)v.get(5)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(102)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","30" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Elemento padre:104 / Elemento actual: 105   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(104)).appendChild((Text)v.get(105));

      /* Termina nodo Texto:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","10" );
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(106)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","10" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","92" );
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(108)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("table"));
      ((Element)v.get(109)).setAttribute("width","75" );
      ((Element)v.get(109)).setAttribute("border","1" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(109)).setAttribute("cellpadding","1" );
      ((Element)v.get(109)).setAttribute("cellspacing","0" );
      ((Element)v.get(109)).setAttribute("bordercolor","#496A9A" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).setAttribute("class","menu5textoblanca" );
      ((Element)v.get(111)).setAttribute("onclick","siguientePestanya(-1)" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblPesCriterios" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(112)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(112)).setAttribute("cod","0075" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:113 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","10" );
      ((Element)v.get(113)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","10" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","20" );
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","75" );
      ((Element)v.get(116)).setAttribute("border","1" );
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
      ((Element)v.get(118)).setAttribute("onclick","siguientePestanya(0)" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblPesTipoSubtipo" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(119)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(119)).setAttribute("cod","00519" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:120 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","10" );
      ((Element)v.get(120)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","10" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","20" );
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","75" );
      ((Element)v.get(123)).setAttribute("border","1" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(123)).setAttribute("cellpadding","1" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(125)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(125)).setAttribute("onclick","siguientePestanya(1)" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblPes1" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","Pestaña 1" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(126)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(126)).setAttribute("cod","00515" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:127 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","10" );
      ((Element)v.get(127)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","10" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","20" );
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("table"));
      ((Element)v.get(130)).setAttribute("width","75" );
      ((Element)v.get(130)).setAttribute("border","1" );
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("cellpadding","1" );
      ((Element)v.get(130)).setAttribute("cellspacing","0" );
      ((Element)v.get(130)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(132)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(132)).setAttribute("onclick","siguientePestanya(2)" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblPes2" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(133)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(133)).setAttribute("cod","00516" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:134 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","10" );
      ((Element)v.get(134)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","10" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","20" );
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","75" );
      ((Element)v.get(137)).setAttribute("border","1" );
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("cellpadding","1" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(137)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(139)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblPes3" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(140)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(140)).setAttribute("cod","00517" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:141 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","10" );
      ((Element)v.get(141)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","10" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","20" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","75" );
      ((Element)v.get(144)).setAttribute("border","1" );
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("cellpadding","1" );
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(146)).setAttribute("onclick","siguientePestanya(4)" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(147)).setAttribute("nombre","lblPes4" );
      ((Element)v.get(147)).setAttribute("alto","13" );
      ((Element)v.get(147)).setAttribute("filas","1" );
      ((Element)v.get(147)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(147)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(147)).setAttribute("cod","00518" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:148 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","16" );
      ((Element)v.get(148)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:150 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(150)).setAttribute("nombre","capaUnica" );
      ((Element)v.get(150)).setAttribute("alto","450" );
      ((Element)v.get(150)).setAttribute("ancho","100%" );
      ((Element)v.get(5)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("table"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(151)).setAttribute("border","0" );
      ((Element)v.get(151)).setAttribute("cellspacing","0" );
      ((Element)v.get(151)).setAttribute("cellpadding","0" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("align","center" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","12" );
      ((Element)v.get(154)).setAttribute("height","12" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","750" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","12" );
      ((Element)v.get(152)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(158)).setAttribute("height","1" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:152   */

      /* Empieza nodo:159 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(164)).setAttribute("class","legend" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblTitGrupoDirecciones" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("cod","00143" );
      ((Element)v.get(165)).setAttribute("id","legend" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("table"));
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(166)).setAttribute("border","0" );
      ((Element)v.get(166)).setAttribute("align","center" );
      ((Element)v.get(166)).setAttribute("cellspacing","0" );
      ((Element)v.get(166)).setAttribute("cellpadding","0" );
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("colspan","4" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:170 / Elemento padre: 166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(166)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblTipoDireccion" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","159" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(178)).setAttribute("nombre","lblTipoVia" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("valor","" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("cod","215" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","25" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(182)).setAttribute("nombre","capaLblNombreVia" );
      ((Element)v.get(182)).setAttribute("visibilidad","visible" );
      ((Element)v.get(182)).setAttribute("alto","100%" );
      ((Element)v.get(182)).setAttribute("ancho","100%" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblNombreVia" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","216" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 181   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(184)).setAttribute("nombre","capaLblVia" );
      ((Element)v.get(184)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(184)).setAttribute("alto","100%" );
      ((Element)v.get(184)).setAttribute("ancho","100%" );
      ((Element)v.get(181)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(185)).setAttribute("nombre","lblVia" );
      ((Element)v.get(185)).setAttribute("alto","13" );
      ((Element)v.get(185)).setAttribute("filas","1" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(185)).setAttribute("valor","" );
      ((Element)v.get(185)).setAttribute("id","datosTitle" );
      ((Element)v.get(185)).setAttribute("cod","216" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:181   */

      /* Empieza nodo:186 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(170)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:170   */

      /* Empieza nodo:188 / Elemento padre: 166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(166)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).setAttribute("valign","top" );
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(192)).setAttribute("nombre","cbTipoDireccion" );
      ((Element)v.get(192)).setAttribute("id","datosCampos" );
      ((Element)v.get(192)).setAttribute("size","1" );
      ((Element)v.get(192)).setAttribute("multiple","N" );
      ((Element)v.get(192)).setAttribute("req","N" );
      ((Element)v.get(192)).setAttribute("valorinicial","" );
      ((Element)v.get(192)).setAttribute("textoinicial","" );
      ((Element)v.get(192)).setAttribute("onshtab","siguientePestanya(2);" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:194 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","25" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(196)).setAttribute("valign","top" );
      ((Element)v.get(188)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(197)).setAttribute("nombre","cbTipoVia" );
      ((Element)v.get(197)).setAttribute("id","datosCampos" );
      ((Element)v.get(197)).setAttribute("size","1" );
      ((Element)v.get(197)).setAttribute("multiple","N" );
      ((Element)v.get(197)).setAttribute("onchange","cambioTipoVia();" );
      ((Element)v.get(197)).setAttribute("req","N" );
      ((Element)v.get(197)).setAttribute("valorinicial","" );
      ((Element)v.get(197)).setAttribute("textoinicial","" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:199 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","25" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(202)).setAttribute("nombre","capaTextNombreVia" );
      ((Element)v.get(202)).setAttribute("visibilidad","visible" );
      ((Element)v.get(202)).setAttribute("alto","100%" );
      ((Element)v.get(202)).setAttribute("ancho","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(203)).setAttribute("nombre","textNombreVia" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("max","40" );
      ((Element)v.get(203)).setAttribute("tipo","" );
      ((Element)v.get(203)).setAttribute("onchange","" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("size","40" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("validacion","" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(204)).setAttribute("nombre","capaCbVia" );
      ((Element)v.get(204)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(204)).setAttribute("alto","100%" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(204)).setAttribute("ancho","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(205)).setAttribute("nombre","cbVia" );
      ((Element)v.get(205)).setAttribute("id","datosCampos" );
      ((Element)v.get(205)).setAttribute("size","1" );
      ((Element)v.get(205)).setAttribute("multiple","N" );
      ((Element)v.get(205)).setAttribute("req","N" );
      ((Element)v.get(205)).setAttribute("valorinicial","" );
      ((Element)v.get(205)).setAttribute("textoinicial","" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:201   */

      /* Empieza nodo:207 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(188)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:188   */

      /* Empieza nodo:209 / Elemento padre: 166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(166)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("colspan","4" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:166   */

      /* Empieza nodo:212 / Elemento padre: 163   */
      v.add(doc.createElement("table"));
      ((Element)v.get(212)).setAttribute("width","100%" );
      ((Element)v.get(212)).setAttribute("border","0" );
      ((Element)v.get(212)).setAttribute("align","center" );
      ((Element)v.get(212)).setAttribute("cellspacing","0" );
      ((Element)v.get(212)).setAttribute("cellpadding","0" );
      ((Element)v.get(163)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("colspan","4" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:216 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblNPrincipal" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("id","datosTitle" );
      ((Element)v.get(220)).setAttribute("cod","939" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(224)).setAttribute("nombre","lblCodPostal" );
      ((Element)v.get(224)).setAttribute("alto","13" );
      ((Element)v.get(224)).setAttribute("filas","1" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(224)).setAttribute("id","datosTitle" );
      ((Element)v.get(224)).setAttribute("cod","1344" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","25" );
      ((Element)v.get(226)).setAttribute("height","8" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(228)).setAttribute("nombre","lblDireccionPrincipal" );
      ((Element)v.get(228)).setAttribute("alto","13" );
      ((Element)v.get(228)).setAttribute("filas","1" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(228)).setAttribute("id","datosTitle" );
      ((Element)v.get(228)).setAttribute("cod","1349" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(216)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:216   */

      /* Empieza nodo:231 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(235)).setAttribute("nombre","textNPrincipal" );
      ((Element)v.get(235)).setAttribute("id","datosCampos" );
      ((Element)v.get(235)).setAttribute("max","6" );
      ((Element)v.get(235)).setAttribute("tipo","" );
      ((Element)v.get(235)).setAttribute("onchange","" );
      ((Element)v.get(235)).setAttribute("req","N" );
      ((Element)v.get(235)).setAttribute("size","6" );
      ((Element)v.get(235)).setAttribute("valor","" );
      ((Element)v.get(235)).setAttribute("validacion","" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","25" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(239)).setAttribute("nombre","textCodPostal" );
      ((Element)v.get(239)).setAttribute("id","datosCampos" );
      ((Element)v.get(239)).setAttribute("max","5" );
      ((Element)v.get(239)).setAttribute("tipo","" );
      ((Element)v.get(239)).setAttribute("onchange","" );
      ((Element)v.get(239)).setAttribute("req","N" );
      ((Element)v.get(239)).setAttribute("size","5" );
      ((Element)v.get(239)).setAttribute("valor","" );
      ((Element)v.get(239)).setAttribute("validacion","" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","25" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("class","datosCampos" );
      ((Element)v.get(231)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(243)).setAttribute("nombre","rbDireccionPrincipal" );
      ((Element)v.get(243)).setAttribute("tipo","H" );
      ((Element)v.get(243)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(244)).setAttribute("valor","S" );
      ((Element)v.get(244)).setAttribute("check","N" );
      ((Element)v.get(244)).setAttribute("onfocus","" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("cod","117" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Elemento padre:244 / Elemento actual: 245   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(244)).appendChild((Text)v.get(245));

      /* Termina nodo Texto:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 243   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(246)).setAttribute("valor","N" );
      ((Element)v.get(246)).setAttribute("check","N" );
      ((Element)v.get(246)).setAttribute("onfocus","" );
      ((Element)v.get(246)).setAttribute("id","datosCampos" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(246)).setAttribute("cod","87" );
      ((Element)v.get(243)).appendChild((Element)v.get(246));

      /* Elemento padre:246 / Elemento actual: 247   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(246)).appendChild((Text)v.get(247));

      /* Termina nodo Texto:247   */
      /* Termina nodo:246   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:248 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(231)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:231   */

      /* Empieza nodo:250 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(250));

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
      /* Termina nodo:212   */

      /* Empieza nodo:253 / Elemento padre: 163   */
      v.add(doc.createElement("table"));
      ((Element)v.get(253)).setAttribute("width","100%" );
      ((Element)v.get(253)).setAttribute("border","0" );
      ((Element)v.get(253)).setAttribute("align","center" );
      ((Element)v.get(253)).setAttribute("cellspacing","0" );
      ((Element)v.get(253)).setAttribute("cellpadding","0" );
      ((Element)v.get(163)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(258)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(258)).setAttribute("alto","13" );
      ((Element)v.get(258)).setAttribute("filas","1" );
      ((Element)v.get(258)).setAttribute("valor","" );
      ((Element)v.get(258)).setAttribute("id","datosTitle" );
      ((Element)v.get(258)).setAttribute("cod","169" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(254)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:254   */

      /* Empieza nodo:261 / Elemento padre: 253   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(253)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(265)).setAttribute("cols","50" );
      ((Element)v.get(265)).setAttribute("id","datosCampos" );
      ((Element)v.get(265)).setAttribute("nombre","textObservaciones" );
      ((Element)v.get(265)).setAttribute("readonly","N" );
      ((Element)v.get(265)).setAttribute("req","N" );
      ((Element)v.get(265)).setAttribute("rows","3" );
      ((Element)v.get(265)).setAttribute("tabindex","2" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("width","100%" );
      ((Element)v.get(261)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:261   */

      /* Empieza nodo:268 / Elemento padre: 253   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(253)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("colspan","4" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","8" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:253   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:271 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(272)).setAttribute("height","12" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:159   */

      /* Empieza nodo:273 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("width","12" );
      ((Element)v.get(274)).setAttribute("align","center" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(275)).setAttribute("height","15" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).setAttribute("width","750" );
      ((Element)v.get(273)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).setAttribute("width","12" );
      ((Element)v.get(273)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","12" );
      ((Element)v.get(279)).setAttribute("height","15" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:273   */

      /* Empieza nodo:280 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(285)).setAttribute("class","legend" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(286)).setAttribute("nombre","lblTitGrupoComunicacio" );
      ((Element)v.get(286)).setAttribute("alto","13" );
      ((Element)v.get(286)).setAttribute("filas","1" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(286)).setAttribute("cod","00144" );
      ((Element)v.get(286)).setAttribute("id","legend" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 284   */
      v.add(doc.createElement("table"));
      ((Element)v.get(287)).setAttribute("width","100%" );
      ((Element)v.get(287)).setAttribute("border","0" );
      ((Element)v.get(287)).setAttribute("align","center" );
      ((Element)v.get(287)).setAttribute("cellspacing","0" );
      ((Element)v.get(287)).setAttribute("cellpadding","0" );
      ((Element)v.get(284)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).setAttribute("colspan","4" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:291 / Elemento padre: 287   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(287)).appendChild((Element)v.get(291));

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
      ((Element)v.get(295)).setAttribute("nombre","lblTipoComunicacion" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(295)).setAttribute("id","datosTitle" );
      ((Element)v.get(295)).setAttribute("cod","1350" );
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
      ((Element)v.get(299)).setAttribute("nombre","lblDiaComunicacion" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("valor","" );
      ((Element)v.get(299)).setAttribute("id","datosTitle" );
      ((Element)v.get(299)).setAttribute("cod","1351" );
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
      ((Element)v.get(303)).setAttribute("nombre","lblComunicacionPrincipal" );
      ((Element)v.get(303)).setAttribute("alto","13" );
      ((Element)v.get(303)).setAttribute("filas","1" );
      ((Element)v.get(303)).setAttribute("valor","" );
      ((Element)v.get(303)).setAttribute("id","datosTitle" );
      ((Element)v.get(303)).setAttribute("cod","1353" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","25" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(307)).setAttribute("nombre","lblHoraDesde" );
      ((Element)v.get(307)).setAttribute("alto","13" );
      ((Element)v.get(307)).setAttribute("filas","1" );
      ((Element)v.get(307)).setAttribute("valor","" );
      ((Element)v.get(307)).setAttribute("id","datosTitle" );
      ((Element)v.get(307)).setAttribute("cod","1354" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","25" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(311)).setAttribute("nombre","lblHoraHasta" );
      ((Element)v.get(311)).setAttribute("alto","13" );
      ((Element)v.get(311)).setAttribute("filas","1" );
      ((Element)v.get(311)).setAttribute("valor","" );
      ((Element)v.get(311)).setAttribute("id","datosTitle" );
      ((Element)v.get(311)).setAttribute("cod","1355" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","25" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(315)).setAttribute("nombre","lblIntervaloComunicacion" );
      ((Element)v.get(315)).setAttribute("alto","13" );
      ((Element)v.get(315)).setAttribute("filas","1" );
      ((Element)v.get(315)).setAttribute("valor","" );
      ((Element)v.get(315)).setAttribute("id","datosTitle" );
      ((Element)v.get(315)).setAttribute("cod","1356" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(316)).setAttribute("width","100%" );
      ((Element)v.get(291)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:291   */

      /* Empieza nodo:318 / Elemento padre: 287   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(287)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(321)).setAttribute("valign","top" );
      ((Element)v.get(318)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(322)).setAttribute("nombre","cbTipoComunicacion" );
      ((Element)v.get(322)).setAttribute("id","datosCampos" );
      ((Element)v.get(322)).setAttribute("size","1" );
      ((Element)v.get(322)).setAttribute("multiple","N" );
      ((Element)v.get(322)).setAttribute("req","N" );
      ((Element)v.get(322)).setAttribute("valorinicial","" );
      ((Element)v.get(322)).setAttribute("textoinicial","" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:324 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","25" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(326)).setAttribute("valign","top" );
      ((Element)v.get(318)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(327)).setAttribute("nombre","cbDiaComunicacion" );
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
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:329 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","25" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("class","datosCampos" );
      ((Element)v.get(318)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(332)).setAttribute("nombre","rbComunicacionPrincipal" );
      ((Element)v.get(332)).setAttribute("tipo","H" );
      ((Element)v.get(332)).setAttribute("id","datosCampos" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(333)).setAttribute("valor","S" );
      ((Element)v.get(333)).setAttribute("check","N" );
      ((Element)v.get(333)).setAttribute("onfocus","" );
      ((Element)v.get(333)).setAttribute("id","datosCampos" );
      ((Element)v.get(333)).setAttribute("cod","117" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Elemento padre:333 / Elemento actual: 334   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(333)).appendChild((Text)v.get(334));

      /* Termina nodo Texto:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(335)).setAttribute("valor","N" );
      ((Element)v.get(335)).setAttribute("check","N" );
      ((Element)v.get(335)).setAttribute("onfocus","" );
      ((Element)v.get(335)).setAttribute("id","datosCampos" );
      ((Element)v.get(335)).setAttribute("cod","87" );
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Elemento padre:335 / Elemento actual: 336   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(335)).appendChild((Text)v.get(336));

      /* Termina nodo Texto:336   */
      /* Termina nodo:335   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:337 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(338)).setAttribute("width","25" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(340)).setAttribute("nombre","textHoraDesde" );
      ((Element)v.get(340)).setAttribute("id","datosCampos" );
      ((Element)v.get(340)).setAttribute("max","5" );
      ((Element)v.get(340)).setAttribute("tipo","" );
      ((Element)v.get(340)).setAttribute("onchange","" );
      ((Element)v.get(340)).setAttribute("req","N" );
      ((Element)v.get(340)).setAttribute("size","5" );
      ((Element)v.get(340)).setAttribute("valor","" );
      ((Element)v.get(340)).setAttribute("validacion","" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","25" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(344)).setAttribute("nombre","textHoraHasta" );
      ((Element)v.get(344)).setAttribute("id","datosCampos" );
      ((Element)v.get(344)).setAttribute("max","5" );
      ((Element)v.get(344)).setAttribute("tipo","" );
      ((Element)v.get(344)).setAttribute("onchange","" );
      ((Element)v.get(344)).setAttribute("req","N" );
      ((Element)v.get(344)).setAttribute("size","5" );
      ((Element)v.get(344)).setAttribute("valor","" );
      ((Element)v.get(344)).setAttribute("validacion","" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","25" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(347)).setAttribute("valign","top" );
      ((Element)v.get(318)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(348)).setAttribute("nombre","cbIntervaloComunicacion" );
      ((Element)v.get(348)).setAttribute("id","datosCampos" );
      ((Element)v.get(348)).setAttribute("size","1" );
      ((Element)v.get(348)).setAttribute("multiple","N" );
      ((Element)v.get(348)).setAttribute("req","N" );
      ((Element)v.get(348)).setAttribute("valorinicial","" );
      ((Element)v.get(348)).setAttribute("textoinicial","" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:350 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("width","100%" );
      ((Element)v.get(318)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:318   */

      /* Empieza nodo:352 / Elemento padre: 287   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(287)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("colspan","4" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(354)).setAttribute("height","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:287   */

      /* Empieza nodo:355 / Elemento padre: 284   */
      v.add(doc.createElement("table"));
      ((Element)v.get(355)).setAttribute("width","100%" );
      ((Element)v.get(355)).setAttribute("border","0" );
      ((Element)v.get(355)).setAttribute("align","center" );
      ((Element)v.get(355)).setAttribute("cellspacing","0" );
      ((Element)v.get(355)).setAttribute("cellpadding","0" );
      ((Element)v.get(284)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","8" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(360)).setAttribute("nombre","lblTextoComunicacion" );
      ((Element)v.get(360)).setAttribute("alto","13" );
      ((Element)v.get(360)).setAttribute("filas","1" );
      ((Element)v.get(360)).setAttribute("valor","" );
      ((Element)v.get(360)).setAttribute("id","datosTitle" );
      ((Element)v.get(360)).setAttribute("cod","1352" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).setAttribute("width","100%" );
      ((Element)v.get(356)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:356   */

      /* Empieza nodo:363 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(363));

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
      ((Element)v.get(366)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(363)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(367)).setAttribute("cols","50" );
      ((Element)v.get(367)).setAttribute("id","datosCampos" );
      ((Element)v.get(367)).setAttribute("nombre","textTextoComunicacion" );
      ((Element)v.get(367)).setAttribute("readonly","N" );
      ((Element)v.get(367)).setAttribute("req","N" );
      ((Element)v.get(367)).setAttribute("rows","3" );
      ((Element)v.get(367)).setAttribute("tabindex","2" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("width","100%" );
      ((Element)v.get(363)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:363   */

      /* Empieza nodo:370 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).setAttribute("colspan","4" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:355   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:373 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","8" );
      ((Element)v.get(374)).setAttribute("height","12" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:280   */

      /* Empieza nodo:375 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).setAttribute("width","12" );
      ((Element)v.get(376)).setAttribute("align","center" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","12" );
      ((Element)v.get(377)).setAttribute("height","15" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).setAttribute("width","750" );
      ((Element)v.get(375)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("width","12" );
      ((Element)v.get(375)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","12" );
      ((Element)v.get(381)).setAttribute("height","15" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:375   */

      /* Empieza nodo:382 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(387)).setAttribute("class","legend" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(388)).setAttribute("nombre","lblTitGrupoMarca" );
      ((Element)v.get(388)).setAttribute("alto","13" );
      ((Element)v.get(388)).setAttribute("filas","1" );
      ((Element)v.get(388)).setAttribute("valor","" );
      ((Element)v.get(388)).setAttribute("cod","00145" );
      ((Element)v.get(388)).setAttribute("id","legend" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 386   */
      v.add(doc.createElement("table"));
      ((Element)v.get(389)).setAttribute("width","100%" );
      ((Element)v.get(389)).setAttribute("border","0" );
      ((Element)v.get(389)).setAttribute("align","center" );
      ((Element)v.get(389)).setAttribute("cellspacing","0" );
      ((Element)v.get(389)).setAttribute("cellpadding","0" );
      ((Element)v.get(386)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).setAttribute("colspan","4" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","8" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:393 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","8" );
      ((Element)v.get(395)).setAttribute("height","8" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(397)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(397)).setAttribute("alto","13" );
      ((Element)v.get(397)).setAttribute("filas","1" );
      ((Element)v.get(397)).setAttribute("valor","" );
      ((Element)v.get(397)).setAttribute("id","datosTitle" );
      ((Element)v.get(397)).setAttribute("cod","6" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).setAttribute("width","100%" );
      ((Element)v.get(393)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","8" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:393   */

      /* Empieza nodo:400 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(400));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(404)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(404)).setAttribute("id","datosCampos" );
      ((Element)v.get(404)).setAttribute("size","1" );
      ((Element)v.get(404)).setAttribute("multiple","N" );
      ((Element)v.get(404)).setAttribute("req","N" );
      ((Element)v.get(404)).setAttribute("valorinicial","" );
      ((Element)v.get(404)).setAttribute("textoinicial","" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:406 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(406)).setAttribute("width","100%" );
      ((Element)v.get(400)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(407)).setAttribute("height","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:400   */

      /* Empieza nodo:408 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).setAttribute("colspan","4" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","8" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:389   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:411 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","8" );
      ((Element)v.get(412)).setAttribute("height","12" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:382   */

      /* Empieza nodo:413 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(416)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("table"));
      ((Element)v.get(418)).setAttribute("width","100%" );
      ((Element)v.get(418)).setAttribute("border","0" );
      ((Element)v.get(418)).setAttribute("align","center" );
      ((Element)v.get(418)).setAttribute("cellspacing","0" );
      ((Element)v.get(418)).setAttribute("cellpadding","0" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("class","botonera" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(421)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(421)).setAttribute("ID","botonContenido" );
      ((Element)v.get(421)).setAttribute("tipo","html" );
      ((Element)v.get(421)).setAttribute("accion","siguientePestanya(4);" );
      ((Element)v.get(421)).setAttribute("estado","false" );
      ((Element)v.get(421)).setAttribute("cod","446" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 420   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(422)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(422)).setAttribute("ID","botonContenido" );
      ((Element)v.get(422)).setAttribute("tipo","html" );
      ((Element)v.get(422)).setAttribute("accion","buscar();" );
      ((Element)v.get(422)).setAttribute("ontab","siguientePestanya(4);" );
      ((Element)v.get(422)).setAttribute("estado","false" );
      ((Element)v.get(422)).setAttribute("cod","1" );
      ((Element)v.get(420)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:423 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","12" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:413   */

      /* Empieza nodo:425 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("width","12" );
      ((Element)v.get(426)).setAttribute("align","center" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","12" );
      ((Element)v.get(427)).setAttribute("height","12" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("width","750" );
      ((Element)v.get(425)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:430 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).setAttribute("width","12" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(425)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","12" );
      ((Element)v.get(431)).setAttribute("height","12" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:425   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:5   */

      /* Empieza nodo:432 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(432)).setAttribute("nombre","frmUnicoBusq" );
      ((Element)v.get(432)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(433)).setAttribute("nombre","accion" );
      ((Element)v.get(433)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(434)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(434)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */

      /* Empieza nodo:435 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(435)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(435)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */

      /* Empieza nodo:436 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(436)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(436)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(437)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(437)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */

      /* Empieza nodo:438 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(438)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(438)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */

      /* Empieza nodo:439 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(439)).setAttribute("nombre","geoReferenciador" );
      ((Element)v.get(439)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(440)).setAttribute("nombre","hidPais" );
      ((Element)v.get(440)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */

      /* Empieza nodo:441 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(441)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(441)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */

      /* Empieza nodo:442 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(442)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(442)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(443)).setAttribute("nombre","hidTipoSubtipo" );
      ((Element)v.get(443)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */

      /* Empieza nodo:444 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(444)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(444)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */

      /* Empieza nodo:445 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(445)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(445)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(446)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(446)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */

      /* Empieza nodo:447 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(447)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(447)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */

      /* Empieza nodo:448 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(448)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(448)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(449)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(449)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */

      /* Empieza nodo:450 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(450)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(450)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */

      /* Empieza nodo:451 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(451)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(451)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */

      /* Empieza nodo:452 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(452)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(452)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 432   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(453)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(453)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */

      /* Empieza nodo:454 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(454)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(454)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(455)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(455)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(456)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(456)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */

      /* Empieza nodo:457 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(457)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(457)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(458)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(458)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(459)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(459)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */

      /* Empieza nodo:460 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(460)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(460)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */

      /* Empieza nodo:461 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(461)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(461)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(462)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(462)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */

      /* Empieza nodo:463 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(463)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(463)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(464)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(464)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */

      /* Empieza nodo:465 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(465)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(465)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */

      /* Empieza nodo:466 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(466)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(466)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */

      /* Empieza nodo:467 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(467)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(467)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */

      /* Empieza nodo:468 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(468)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(468)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */

      /* Empieza nodo:469 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(469)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(469)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */

      /* Empieza nodo:470 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(470)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(470)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(471)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(471)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */

      /* Empieza nodo:472 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(472)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(472)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */

      /* Empieza nodo:473 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(473)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(473)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */

      /* Empieza nodo:474 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(474)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(474)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */

      /* Empieza nodo:475 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(475)).setAttribute("nombre","hidcbTipoVinculo" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(475)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */

      /* Empieza nodo:476 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(476)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(476)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */

      /* Empieza nodo:477 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(477)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(477)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */

      /* Empieza nodo:478 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(478)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(478)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */

      /* Empieza nodo:479 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(479)).setAttribute("nombre","hidcb" );
      ((Element)v.get(479)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(480)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(480)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(481)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(481)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(482)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(482)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(483)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(483)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(484)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(484)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(485)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(485)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(486)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(486)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(487)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(487)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(488)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(488)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(489)).setAttribute("nombre","hidcbMarcaContacto" );
      ((Element)v.get(489)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(490)).setAttribute("nombre","hidcbCanalContacto" );
      ((Element)v.get(490)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(491)).setAttribute("nombre","hidcbPeriodoPrimerPedido" );
      ((Element)v.get(491)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(492)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(492)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(493)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(493)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(494)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(494)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(495)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(495)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(496)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(497)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(497)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 432   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(498)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(498)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */

      /* Empieza nodo:499 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(499)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(499)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */

      /* Empieza nodo:500 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(500)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */

      /* Empieza nodo:501 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(501)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(501)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */

      /* Empieza nodo:502 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(502)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(502)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(503)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(503)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */

      /* Empieza nodo:504 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(504)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(504)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */

      /* Empieza nodo:505 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(505)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(505)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */

      /* Empieza nodo:506 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(506)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(506)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */

      /* Empieza nodo:507 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(507)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(507)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */

      /* Empieza nodo:508 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(508)).setAttribute("nombre","hibTextCbVia" );
      ((Element)v.get(508)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */

      /* Empieza nodo:509 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(509)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(509)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */

      /* Empieza nodo:510 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(510)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(510)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */

      /* Empieza nodo:511 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(511)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(511)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(512)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(512)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */

      /* Empieza nodo:513 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(513)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(513)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */

      /* Empieza nodo:514 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(514)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(514)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */

      /* Empieza nodo:515 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(515)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(515)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */

      /* Empieza nodo:516 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(516)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(516)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */

      /* Empieza nodo:517 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(517)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(517)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(518)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(518)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */

      /* Empieza nodo:519 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(519)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */

      /* Empieza nodo:520 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(520)).setAttribute("nombre","hidcbClasificacion" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(520)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(521)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(521)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(522)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(522)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */

      /* Empieza nodo:523 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(523)).setAttribute("nombre","hiddenTipoCliente" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */

      /* Empieza nodo:524 / Elemento padre: 432   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(524)).setAttribute("nombre","hiddenSubTipoCliente" );
      ((Element)v.get(524)).setAttribute("valor","" );
      ((Element)v.get(432)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:432   */


   }

}
