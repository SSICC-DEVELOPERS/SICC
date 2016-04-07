
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_clientes_resultados_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_clientes_resultados_buscar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Resultados de búsqueda de clientes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Resultados de búsqueda de clientes" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_clientes_resultados_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r         \r\r	\r\r   \r  "));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmPBuscarTiposError" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
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
      ((Element)v.get(12)).setAttribute("nombre","hidCadenaParametros" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","dtoOid" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidPestanya" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidCodigoCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hPestanya" );
      ((Element)v.get(17)).setAttribute("valor","-1" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidIndActivo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidCodigosStatus" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidCriterioBusqueda1" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidCriterioBusqueda2" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidTipoSubtipo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","hiddenTipoCliente" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hiddenSubTipoCliente" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidcbTipoDocId" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidtextNDocId" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidrbDocPrincipal" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidcbPersonaCliente" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(45)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(7)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidcbPaisVinculo" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidtextClienteVinculo" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidcbTipoVinculo" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidtextFechaD" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidtextFechaH" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidrbVinculoPrincipal" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidcb" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidtextDescripcion" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidcbTipoDireccion" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidcbTipoVia" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidtextNombreVia" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidtextNPrincipal" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidtextCodPostal" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidtextInterior" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidtextManzana" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hidtextLote" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidtextKm" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidrbDireccionPrincipal" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hidtextObservaciones" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hidcbTipoComunicacion" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hidcbDiaComunicacion" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hidrbComunicacionPrincipal" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hidtextHoraDesde" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hidtextHoraHasta" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hidcbIntervaloComunicacion" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hidtextTextoComunicacion" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hidcbMarca" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hidcbVia" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hidcbTipoTarjeta" );
      ((Element)v.get(90)).setAttribute("valor","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(7)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hidcbClasesTarjeta" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hidcbEntidadBancaria" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hidcbMarcaPestanya4" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hidcbCanal" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","hidcbTipoClasificacion" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","hidcbTipoProblema" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hidrbSolucion" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","hidcbTipoSolucion" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hidtextDescripcionProblema" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hidtextDescripcionSolucion" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","hidcbClasificacion" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","hidtextNegocioProducto" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","ListaComboClasificacion" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(105)).setAttribute("border","0" );
      ((Element)v.get(105)).setAttribute("cellspacing","0" );
      ((Element)v.get(105)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","524" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:109 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(109)).setAttribute("nombre","listado1" );
      ((Element)v.get(109)).setAttribute("ancho","500" );
      ((Element)v.get(109)).setAttribute("alto","317" );
      ((Element)v.get(109)).setAttribute("x","12" );
      ((Element)v.get(109)).setAttribute("y","12" );
      ((Element)v.get(109)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(109)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(110)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(110)).setAttribute("alto","22" );
      ((Element)v.get(110)).setAttribute("imgFondo","" );
      ((Element)v.get(110)).setAttribute("cod","00135" );
      ((Element)v.get(110)).setAttribute("ID","datosTitle" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 109   */
      v.add(doc.createElement("BASE"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(111)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(111)).setAttribute("alto","22" );
      ((Element)v.get(111)).setAttribute("imgFondo","" );
      ((Element)v.get(109)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(112)).setAttribute("precarga","S" );
      ((Element)v.get(112)).setAttribute("conROver","S" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(113)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(113)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(113)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(113)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 112   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(114)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(114)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(114)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(114)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(115)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(115)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:112   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(109)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(117)).setAttribute("borde","1" );
      ((Element)v.get(117)).setAttribute("horizDatos","1" );
      ((Element)v.get(117)).setAttribute("horizCabecera","1" );
      ((Element)v.get(117)).setAttribute("vertical","1" );
      ((Element)v.get(117)).setAttribute("horizTitulo","1" );
      ((Element)v.get(117)).setAttribute("horizBase","1" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(118)).setAttribute("borde","#999999" );
      ((Element)v.get(118)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(118)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(118)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(118)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(118)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(118)).setAttribute("horizBase","#999999" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 109   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(119)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(119)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(119)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(119)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(119)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(119)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(109)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("ancho","100" );
      ((Element)v.get(120)).setAttribute("minimizable","S" );
      ((Element)v.get(120)).setAttribute("minimizada","N" );
      ((Element)v.get(120)).setAttribute("orden","" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("ancho","100" );
      ((Element)v.get(121)).setAttribute("minimizable","S" );
      ((Element)v.get(121)).setAttribute("minimizada","N" );
      ((Element)v.get(121)).setAttribute("orden","" );
      ((Element)v.get(119)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("ancho","100" );
      ((Element)v.get(122)).setAttribute("minimizable","S" );
      ((Element)v.get(122)).setAttribute("minimizada","N" );
      ((Element)v.get(122)).setAttribute("orden","" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","100" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(123)).setAttribute("orden","" );
      ((Element)v.get(119)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("ancho","100" );
      ((Element)v.get(124)).setAttribute("minimizable","S" );
      ((Element)v.get(124)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).setAttribute("orden","" );
      ((Element)v.get(119)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","100" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).setAttribute("orden","" );
      ((Element)v.get(119)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","100" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(126)).setAttribute("orden","" );
      ((Element)v.get(119)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","100" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(127)).setAttribute("orden","" );
      ((Element)v.get(119)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:119   */

      /* Empieza nodo:128 / Elemento padre: 109   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(128)).setAttribute("alto","20" );
      ((Element)v.get(128)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(128)).setAttribute("imgFondo","" );
      ((Element)v.get(128)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(109)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("colFondo","" );
      ((Element)v.get(129)).setAttribute("ID","EstCab" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("cod","263" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("colFondo","" );
      ((Element)v.get(130)).setAttribute("ID","EstCab" );
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("cod","905" );
      ((Element)v.get(128)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("colFondo","" );
      ((Element)v.get(131)).setAttribute("ID","EstCab" );
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(131)).setAttribute("cod","1869" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("colFondo","" );
      ((Element)v.get(132)).setAttribute("ID","EstCab" );
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("cod","595" );
      ((Element)v.get(128)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("colFondo","" );
      ((Element)v.get(133)).setAttribute("ID","EstCab" );
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(133)).setAttribute("cod","16" );
      ((Element)v.get(128)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("colFondo","" );
      ((Element)v.get(134)).setAttribute("ID","EstCab" );
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(134)).setAttribute("cod","17" );
      ((Element)v.get(128)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("colFondo","" );
      ((Element)v.get(135)).setAttribute("ID","EstCab" );
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(135)).setAttribute("cod","93" );
      ((Element)v.get(128)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("colFondo","" );
      ((Element)v.get(136)).setAttribute("ID","EstCab" );
      ((Element)v.get(136)).setAttribute("align","center" );
      ((Element)v.get(136)).setAttribute("cod","94" );
      ((Element)v.get(128)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:128   */

      /* Empieza nodo:137 / Elemento padre: 109   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(137)).setAttribute("alto","22" );
      ((Element)v.get(137)).setAttribute("accion","seleccionarCliente(FILAEVENTO)" );
      ((Element)v.get(137)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(137)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(137)).setAttribute("maxSel","-1" );
      ((Element)v.get(137)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(137)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(137)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(137)).setAttribute("onLoad","" );
      ((Element)v.get(137)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(137)).setAttribute("primerRefresco","N" );
      ((Element)v.get(109)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("tipo","texto" );
      ((Element)v.get(138)).setAttribute("ID","EstDat" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("tipo","texto" );
      ((Element)v.get(139)).setAttribute("ID","EstDat2" );
      ((Element)v.get(137)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("tipo","texto" );
      ((Element)v.get(140)).setAttribute("ID","EstDat" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("tipo","texto" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(141)).setAttribute("ID","EstDat2" );
      ((Element)v.get(137)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("tipo","texto" );
      ((Element)v.get(142)).setAttribute("ID","EstDat" );
      ((Element)v.get(137)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("tipo","texto" );
      ((Element)v.get(143)).setAttribute("ID","EstDat2" );
      ((Element)v.get(137)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("tipo","texto" );
      ((Element)v.get(144)).setAttribute("ID","EstDat" );
      ((Element)v.get(137)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("tipo","texto" );
      ((Element)v.get(145)).setAttribute("ID","EstDat2" );
      ((Element)v.get(137)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:137   */

      /* Empieza nodo:146 / Elemento padre: 109   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(109)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 109   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(147)).setAttribute("nombre","mypgndo" );
      ((Element)v.get(147)).setAttribute("ancho","306" );
      ((Element)v.get(147)).setAttribute("sep","$" );
      ((Element)v.get(147)).setAttribute("x","12" );
      ((Element)v.get(147)).setAttribute("class","botonera" );
      ((Element)v.get(147)).setAttribute("y","306" );
      ((Element)v.get(147)).setAttribute("control","|" );
      ((Element)v.get(147)).setAttribute("conector","" );
      ((Element)v.get(147)).setAttribute("rowset","" );
      ((Element)v.get(147)).setAttribute("cargainicial","N" );
      ((Element)v.get(147)).setAttribute("onload","procesarPaginado(mypgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(109)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(148)).setAttribute("nombre","ret1" );
      ((Element)v.get(148)).setAttribute("x","37" );
      ((Element)v.get(148)).setAttribute("y","310" );
      ((Element)v.get(148)).setAttribute("ID","botonContenido" );
      ((Element)v.get(148)).setAttribute("img","retroceder_on" );
      ((Element)v.get(148)).setAttribute("tipo","0" );
      ((Element)v.get(148)).setAttribute("estado","false" );
      ((Element)v.get(148)).setAttribute("alt","" );
      ((Element)v.get(148)).setAttribute("codigo","" );
      ((Element)v.get(148)).setAttribute("accion","retrocederPag();" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 147   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(149)).setAttribute("nombre","ava1" );
      ((Element)v.get(149)).setAttribute("x","52" );
      ((Element)v.get(149)).setAttribute("y","310" );
      ((Element)v.get(149)).setAttribute("ID","botonContenido" );
      ((Element)v.get(149)).setAttribute("img","avanzar_on" );
      ((Element)v.get(149)).setAttribute("tipo","0" );
      ((Element)v.get(149)).setAttribute("estado","false" );
      ((Element)v.get(149)).setAttribute("alt","" );
      ((Element)v.get(149)).setAttribute("codigo","" );
      ((Element)v.get(149)).setAttribute("accion","avanzarPag();" );
      ((Element)v.get(147)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:147   */
      /* Termina nodo:109   */

      /* Empieza nodo:150 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(150)).setAttribute("nombre","pri1" );
      ((Element)v.get(150)).setAttribute("x","20" );
      ((Element)v.get(150)).setAttribute("y","310" );
      ((Element)v.get(150)).setAttribute("ID","botonContenido" );
      ((Element)v.get(150)).setAttribute("img","primera_on" );
      ((Element)v.get(150)).setAttribute("tipo","-2" );
      ((Element)v.get(150)).setAttribute("estado","false" );
      ((Element)v.get(150)).setAttribute("alt","" );
      ((Element)v.get(150)).setAttribute("codigo","" );
      ((Element)v.get(150)).setAttribute("accion","mypgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(151)).setAttribute("nombre","modificar" );
      ((Element)v.get(151)).setAttribute("x","80" );
      ((Element)v.get(151)).setAttribute("y","307" );
      ((Element)v.get(151)).setAttribute("ID","botonContenido" );
      ((Element)v.get(151)).setAttribute("tipo","html" );
      ((Element)v.get(151)).setAttribute("estado","false" );
      ((Element)v.get(151)).setAttribute("cod","2" );
      ((Element)v.get(151)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(7)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(152)).setAttribute("nombre","detalle" );
      ((Element)v.get(152)).setAttribute("x","80" );
      ((Element)v.get(152)).setAttribute("y","307" );
      ((Element)v.get(152)).setAttribute("ID","botonContenido" );
      ((Element)v.get(152)).setAttribute("tipo","html" );
      ((Element)v.get(152)).setAttribute("accion","accionConsultar();" );
      ((Element)v.get(152)).setAttribute("estado","false" );
      ((Element)v.get(152)).setAttribute("cod","3" );
      ((Element)v.get(7)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(153)).setAttribute("nombre","cambiarEstatus" );
      ((Element)v.get(153)).setAttribute("x","80" );
      ((Element)v.get(153)).setAttribute("y","307" );
      ((Element)v.get(153)).setAttribute("ID","botonContenido" );
      ((Element)v.get(153)).setAttribute("tipo","html" );
      ((Element)v.get(153)).setAttribute("accion","accionStatus();" );
      ((Element)v.get(153)).setAttribute("estado","false" );
      ((Element)v.get(153)).setAttribute("cod","1052" );
      ((Element)v.get(7)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(154)).setAttribute("nombre","separa" );
      ((Element)v.get(154)).setAttribute("x","59" );
      ((Element)v.get(154)).setAttribute("y","306" );
      ((Element)v.get(154)).setAttribute("ID","botonContenido" );
      ((Element)v.get(154)).setAttribute("img","separa_base" );
      ((Element)v.get(154)).setAttribute("tipo","0" );
      ((Element)v.get(154)).setAttribute("estado","false" );
      ((Element)v.get(154)).setAttribute("alt","" );
      ((Element)v.get(154)).setAttribute("codigo","" );
      ((Element)v.get(154)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(155)).setAttribute("nombre","capaFinal" );
      ((Element)v.get(155)).setAttribute("x","0" );
      ((Element)v.get(155)).setAttribute("y","320" );
      ((Element)v.get(155)).setAttribute("alto","1" );
      ((Element)v.get(155)).setAttribute("ancho","1" );
      ((Element)v.get(7)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:7   */


   }

}
