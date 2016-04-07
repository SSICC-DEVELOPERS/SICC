
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupo2_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupo2_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0309" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar Clientes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar Clientes" );
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
      ((Element)v.get(2)).setAttribute("src","menu_basicas.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","scripts_clientes.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_grupo2_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","textApellido1" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","16" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","textApellido2" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","17" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","textApellidoCasada" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","18" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","textNombre1" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","93" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","textNombre2" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","94" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","textFechaNacimiento" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","877" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","textCodEmpleado" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","1336" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","textOcupacion" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("cod","1109" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","textProfesion" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("cod","1117" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","textCentroTrabajo" );
      ((Element)v.get(17)).setAttribute("required","false" );
      ((Element)v.get(17)).setAttribute("cod","1055" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","textCargoDesempena" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("cod","1053" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","textCentroEstudios" );
      ((Element)v.get(19)).setAttribute("required","false" );
      ((Element)v.get(19)).setAttribute("cod","1054" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("name","textNPersonasDependientes" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("cod","1337" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","textImporteIngresoFamiliar" );
      ((Element)v.get(21)).setAttribute("required","false" );
      ((Element)v.get(21)).setAttribute("cod","1080" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","cbTratamiento" );
      ((Element)v.get(22)).setAttribute("required","false" );
      ((Element)v.get(22)).setAttribute("cod","757" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","cbNacionalidad" );
      ((Element)v.get(23)).setAttribute("required","false" );
      ((Element)v.get(23)).setAttribute("cod","1095" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","cbEstadoCivil" );
      ((Element)v.get(24)).setAttribute("required","false" );
      ((Element)v.get(24)).setAttribute("cod","1076" );
      ((Element)v.get(7)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","cbNivelEstudios" );
      ((Element)v.get(25)).setAttribute("required","false" );
      ((Element)v.get(25)).setAttribute("cod","1106" );
      ((Element)v.get(7)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","cbNivelSocioEconomico" );
      ((Element)v.get(26)).setAttribute("required","false" );
      ((Element)v.get(26)).setAttribute("cod","1107" );
      ((Element)v.get(7)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(27)).setAttribute("name","cbCicloVidaFamiliar" );
      ((Element)v.get(27)).setAttribute("required","false" );
      ((Element)v.get(27)).setAttribute("cod","1056" );
      ((Element)v.get(7)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(28)).setAttribute("name","rbSexo" );
      ((Element)v.get(28)).setAttribute("required","false" );
      ((Element)v.get(28)).setAttribute("cod","1122" );
      ((Element)v.get(7)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(29)).setAttribute("name","rbDeseaCorrespondencia" );
      ((Element)v.get(29)).setAttribute("required","false" );
      ((Element)v.get(29)).setAttribute("cod","1050" );
      ((Element)v.get(7)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:30 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(30)).setAttribute("nombre","frmInsertarCliente" );
      ((Element)v.get(0)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","accion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","ultimoChequeado" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidlongCliente" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidSaldo" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","dtoOid" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hPestanya" );
      ((Element)v.get(43)).setAttribute("valor","2" );
      ((Element)v.get(30)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hReentrandoP1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hReentrandoP2" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hReentrandoP3" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hReentrandoP4" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidFocusPrimerComponente" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidTipoClienDescripcion" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","paisUsuario" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","idiomaUsuario" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","h_cbTratamiento" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","h_rbSexo" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","h_cbFormaPago" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","h_cbNacionalidad" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","h_cbEstadoCivil" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","h_cbNivelEstudios" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","h_cbNivelSocioEconomico" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","h_cbCicloVidaFamiliar" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","h_rbDeseaCorrespondencia" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","h_cbPaisContactado" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","h_cbTipoClienteContactado" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 30   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","h_TipoClienteContacto" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidListaVinculo" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidListaObservacion" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidListaPrefe" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidListaVinculoSal" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidListaObservacionSal" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidListaPrefeSal" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","elementos" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","cbTipo" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","cbSTipo" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidCodigoAutomatico" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hidDigitoControl" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hidtextCodCliente" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hidListaIdentificacion" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","elementosP2" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hidFechaIngreso" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hidFechaHasta" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","oidNull" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","modificabilidad" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","arrayControles" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","campoToFocalizar" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","paisContacto" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","tipoClienteContacto" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","elementosEliminadosVincu" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","elementosEliminadosObser" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","elementosEliminadosPrefe" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","descTratamiento" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","obligatorio" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hidtextApellido1" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hidtextApellido2" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hidtextApellidoCasada" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","hidtextNombre1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","hidtextNombre2" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hidcbTratamiento" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","hidcbTratamientoDesc" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hidrbSexo" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hidcbFormaPago" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","hidtextFechaNacimiento" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","hidEdad" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","hidtextCodEmpleado" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","hidcbNacionalidad" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","hidcbEstadoCivil" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hidtextOcupacion" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(107)).setAttribute("nombre","hidtextProfesion" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 30   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(108)).setAttribute("nombre","hidtextCentroTrabajo" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(109)).setAttribute("nombre","hidtextCargoDesempena" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(110)).setAttribute("nombre","hidcbNivelEstudios" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(111)).setAttribute("nombre","hidtextCentroEstudios" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(112)).setAttribute("nombre","hidtextNHijos" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(113)).setAttribute("nombre","hidtextNPersonasDependientes" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(114)).setAttribute("nombre","hidcbNivelSocioEconomico" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(115)).setAttribute("nombre","hidcbCicloVidaFamiliar" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(116)).setAttribute("nombre","hidrbDeseaCorrespondencia" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(117)).setAttribute("nombre","hidtextImporteIngresoFamiliar" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(118)).setAttribute("nombre","hidcbPaisContactado" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(119)).setAttribute("nombre","hidtextCodClienteContactado" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(120)).setAttribute("nombre","hidcbTipoClienteContactado" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(121)).setAttribute("nombre","hidcbCodTipoContactado" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(122)).setAttribute("nombre","hidtextFechaContacto" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(123)).setAttribute("nombre","hidtextFecha1PedidoContacto" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(124)).setAttribute("nombre","hidtextFechaSiguienteContacto" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(125)).setAttribute("nombre","hidtxtFechaIngresoActual" );
      ((Element)v.get(125)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(126)).setAttribute("nombre","hidMarcaContacto" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(127)).setAttribute("nombre","hidCanalContacto" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(128)).setAttribute("nombre","hidPeriodoContacto" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(129)).setAttribute("nombre","hIndActivoP2" );
      ((Element)v.get(129)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(130)).setAttribute("nombre","hidMarcaDefecto" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(131)).setAttribute("nombre","hidCanalDefecto" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(132)).setAttribute("nombre","listaVinculosOid" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(133)).setAttribute("nombre","elementosP3" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(134)).setAttribute("nombre","hidListaDirecciones" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(135)).setAttribute("nombre","hidListaComunicacion" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(136)).setAttribute("nombre","hidListaMarca" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(137)).setAttribute("nombre","hidMarcaValor" );
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(138)).setAttribute("nombre","hidOidClienteCont" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(139)).setAttribute("nombre","usaGeoreferenciador" );
      ((Element)v.get(139)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(140)).setAttribute("nombre","elementosP4" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(141)).setAttribute("nombre","hidListaTarjetas" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(142)).setAttribute("nombre","hidListaClasificacion" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(143)).setAttribute("nombre","hidListaProbSolu" );
      ((Element)v.get(143)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(144)).setAttribute("nombre","valDefTratamiento" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(145)).setAttribute("nombre","valDefSexo" );
      ((Element)v.get(145)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(146)).setAttribute("nombre","valDefNacionalidad" );
      ((Element)v.get(146)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(147)).setAttribute("nombre","valDefEstCivil" );
      ((Element)v.get(147)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(148)).setAttribute("nombre","valDefNivEst" );
      ((Element)v.get(148)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(149)).setAttribute("nombre","valDefNivSocEco" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(150)).setAttribute("nombre","valDefCicVidFam" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(151)).setAttribute("nombre","valDefFormPago" );
      ((Element)v.get(151)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(152)).setAttribute("nombre","valDefDeseaCorrespondencia" );
      ((Element)v.get(152)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 30   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(153)).setAttribute("nombre","valDefMarca" );
      ((Element)v.get(153)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(154)).setAttribute("nombre","valDefCanal" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(155)).setAttribute("nombre","valDefPeriodo" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(156)).setAttribute("nombre","valDefTipoClie" );
      ((Element)v.get(156)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(157)).setAttribute("nombre","hiddenOid" );
      ((Element)v.get(157)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(158)).setAttribute("nombre","codigoClienteValidar" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(159)).setAttribute("nombre","indValClieRecteValidar" );
      ((Element)v.get(159)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(160)).setAttribute("nombre","OID_TIPO_VINCULO_RECOMENDANTE_RECOMENDADA" );
      ((Element)v.get(160)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 30   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(161)).setAttribute("nombre","capaTemporal" );
      ((Element)v.get(161)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(30)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(162)).setAttribute("nombre","cbTemporal" );
      ((Element)v.get(162)).setAttribute("valorinicial","" );
      ((Element)v.get(162)).setAttribute("req","S" );
      ((Element)v.get(162)).setAttribute("multiple","N" );
      ((Element)v.get(162)).setAttribute("size","1" );
      ((Element)v.get(162)).setAttribute("id","datosCamposTemporal" );
      ((Element)v.get(162)).setAttribute("textoinicial","" );
      ((Element)v.get(162)).setAttribute("onchange","" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 30   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(164)).setAttribute("nombre","capaFormularios" );
      ((Element)v.get(164)).setAttribute("alto","100%" );
      ((Element)v.get(164)).setAttribute("ancho","100%" );
      ((Element)v.get(30)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("height","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("class","menu4" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(167)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","12" );
      ((Element)v.get(168)).setAttribute("height","30" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(169)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Elemento padre:169 / Elemento actual: 170   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(169)).appendChild((Text)v.get(170));

      /* Termina nodo Texto:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","10" );
      ((Element)v.get(171)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(171)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","10" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 166   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("width","20" );
      ((Element)v.get(173)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(173)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("table"));
      ((Element)v.get(174)).setAttribute("width","75" );
      ((Element)v.get(174)).setAttribute("border","1" );
      ((Element)v.get(174)).setAttribute("align","center" );
      ((Element)v.get(174)).setAttribute("cellpadding","1" );
      ((Element)v.get(174)).setAttribute("cellspacing","0" );
      ((Element)v.get(174)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).setAttribute("align","center" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(177)).setAttribute("id","Pes1" );
      ((Element)v.get(177)).setAttribute("onclick","accionInsertarP1();" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(178)).setAttribute("nombre","lblPes1" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(178)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(178)).setAttribute("cod","00515" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:179 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("width","10" );
      ((Element)v.get(179)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","10" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("width","20" );
      ((Element)v.get(181)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(181)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("table"));
      ((Element)v.get(182)).setAttribute("width","75" );
      ((Element)v.get(182)).setAttribute("border","1" );
      ((Element)v.get(182)).setAttribute("align","center" );
      ((Element)v.get(182)).setAttribute("cellpadding","1" );
      ((Element)v.get(182)).setAttribute("cellspacing","0" );
      ((Element)v.get(182)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(182)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).setAttribute("align","center" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(185)).setAttribute("nombre","lblPes2" );
      ((Element)v.get(185)).setAttribute("alto","13" );
      ((Element)v.get(185)).setAttribute("filas","1" );
      ((Element)v.get(185)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(185)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(185)).setAttribute("cod","00516" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:186 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","10" );
      ((Element)v.get(186)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","10" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).setAttribute("width","20" );
      ((Element)v.get(188)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(188)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("table"));
      ((Element)v.get(189)).setAttribute("width","75" );
      ((Element)v.get(189)).setAttribute("border","1" );
      ((Element)v.get(189)).setAttribute("align","center" );
      ((Element)v.get(189)).setAttribute("cellpadding","1" );
      ((Element)v.get(189)).setAttribute("cellspacing","0" );
      ((Element)v.get(189)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(190)).setAttribute("align","center" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(192)).setAttribute("id","Pes3" );
      ((Element)v.get(192)).setAttribute("onclick","accionInsertarP3();" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(193)).setAttribute("nombre","lblPes3" );
      ((Element)v.get(193)).setAttribute("alto","13" );
      ((Element)v.get(193)).setAttribute("filas","1" );
      ((Element)v.get(193)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(193)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(193)).setAttribute("cod","00517" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:194 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("width","10" );
      ((Element)v.get(194)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","10" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("width","20" );
      ((Element)v.get(196)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(196)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("table"));
      ((Element)v.get(197)).setAttribute("width","75" );
      ((Element)v.get(197)).setAttribute("border","1" );
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(197)).setAttribute("cellpadding","1" );
      ((Element)v.get(197)).setAttribute("cellspacing","0" );
      ((Element)v.get(197)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(200)).setAttribute("nombre","lblPes4" );
      ((Element)v.get(200)).setAttribute("alto","13" );
      ((Element)v.get(200)).setAttribute("filas","1" );
      ((Element)v.get(200)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(200)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(200)).setAttribute("cod","00518" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:201 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","16" );
      ((Element)v.get(201)).setAttribute("class","menu5texto" );
      ((Element)v.get(166)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:203 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(203)).setAttribute("border","0" );
      ((Element)v.get(203)).setAttribute("cellspacing","0" );
      ((Element)v.get(203)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","12" );
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","12" );
      ((Element)v.get(206)).setAttribute("height","22" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","750" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","12" );
      ((Element)v.get(204)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","12" );
      ((Element)v.get(210)).setAttribute("height","1" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:204   */

      /* Empieza nodo:211 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(216)).setAttribute("class","legend" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblTitDatosBasicos" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("cod","00142" );
      ((Element)v.get(217)).setAttribute("id","legend" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("table"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(218)).setAttribute("border","0" );
      ((Element)v.get(218)).setAttribute("align","center" );
      ((Element)v.get(218)).setAttribute("cellspacing","0" );
      ((Element)v.get(218)).setAttribute("cellpadding","0" );
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("table"));
      ((Element)v.get(221)).setAttribute("width","725" );
      ((Element)v.get(221)).setAttribute("border","0" );
      ((Element)v.get(221)).setAttribute("align","left" );
      ((Element)v.get(221)).setAttribute("cellspacing","0" );
      ((Element)v.get(221)).setAttribute("cellpadding","0" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

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

      /* Empieza nodo:225 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(229)).setAttribute("nombre","lblApellido1" );
      ((Element)v.get(229)).setAttribute("alto","13" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(229)).setAttribute("id","datosTitle" );
      ((Element)v.get(229)).setAttribute("cod","16" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","25" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(233)).setAttribute("nombre","lblApellido2" );
      ((Element)v.get(233)).setAttribute("alto","13" );
      ((Element)v.get(233)).setAttribute("filas","1" );
      ((Element)v.get(233)).setAttribute("valor","" );
      ((Element)v.get(233)).setAttribute("id","datosTitle" );
      ((Element)v.get(233)).setAttribute("cod","17" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","25" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(237)).setAttribute("nombre","lblApellidoCasada" );
      ((Element)v.get(237)).setAttribute("alto","13" );
      ((Element)v.get(237)).setAttribute("filas","1" );
      ((Element)v.get(237)).setAttribute("valor","" );
      ((Element)v.get(237)).setAttribute("id","datosTitle" );
      ((Element)v.get(237)).setAttribute("cod","18" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).setAttribute("width","100%" );
      ((Element)v.get(225)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:225   */

      /* Empieza nodo:240 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(240)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(244)).setAttribute("nombre","textApellido1" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("onshtab","onshTabCampos('textApellido1');" );
      ((Element)v.get(244)).setAttribute("max","25" );
      ((Element)v.get(244)).setAttribute("tipo","" );
      ((Element)v.get(244)).setAttribute("onchange","" );
      ((Element)v.get(244)).setAttribute("req","S" );
      ((Element)v.get(244)).setAttribute("size","25" );
      ((Element)v.get(244)).setAttribute("valor","" );
      ((Element)v.get(244)).setAttribute("validacion","" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","25" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(240)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(248)).setAttribute("nombre","textApellido2" );
      ((Element)v.get(248)).setAttribute("id","datosCampos" );
      ((Element)v.get(248)).setAttribute("max","25" );
      ((Element)v.get(248)).setAttribute("tipo","" );
      ((Element)v.get(248)).setAttribute("onchange","" );
      ((Element)v.get(248)).setAttribute("onshtab","onshTabCampos('textApellido2');" );
      ((Element)v.get(248)).setAttribute("req","S" );
      ((Element)v.get(248)).setAttribute("size","25" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(248)).setAttribute("validacion","" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","25" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(251)).setAttribute("valign","bottom" );
      ((Element)v.get(240)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(252)).setAttribute("nombre","textApellidoCasada" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).setAttribute("onshtab","onshTabCampos('textApellidoCasada');" );
      ((Element)v.get(252)).setAttribute("max","25" );
      ((Element)v.get(252)).setAttribute("tipo","" );
      ((Element)v.get(252)).setAttribute("onchange","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(252)).setAttribute("req","N" );
      ((Element)v.get(252)).setAttribute("size","25" );
      ((Element)v.get(252)).setAttribute("valor","" );
      ((Element)v.get(252)).setAttribute("validacion","" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("width","100%" );
      ((Element)v.get(240)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:240   */

      /* Empieza nodo:255 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("colspan","4" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:258 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("table"));
      ((Element)v.get(260)).setAttribute("width","725" );
      ((Element)v.get(260)).setAttribute("border","0" );
      ((Element)v.get(260)).setAttribute("align","left" );
      ((Element)v.get(260)).setAttribute("cellspacing","0" );
      ((Element)v.get(260)).setAttribute("cellpadding","0" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(265)).setAttribute("nombre","lblNombre1" );
      ((Element)v.get(265)).setAttribute("alto","13" );
      ((Element)v.get(265)).setAttribute("filas","1" );
      ((Element)v.get(265)).setAttribute("valor","" );
      ((Element)v.get(265)).setAttribute("id","datosTitle" );
      ((Element)v.get(265)).setAttribute("cod","93" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","25" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(269)).setAttribute("nombre","lblNombre2" );
      ((Element)v.get(269)).setAttribute("alto","13" );
      ((Element)v.get(269)).setAttribute("filas","1" );
      ((Element)v.get(269)).setAttribute("valor","" );
      ((Element)v.get(269)).setAttribute("id","datosTitle" );
      ((Element)v.get(269)).setAttribute("cod","94" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","25" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(273)).setAttribute("nombre","lblTratamiento" );
      ((Element)v.get(273)).setAttribute("alto","13" );
      ((Element)v.get(273)).setAttribute("filas","1" );
      ((Element)v.get(273)).setAttribute("valor","" );
      ((Element)v.get(273)).setAttribute("id","datosTitle" );
      ((Element)v.get(273)).setAttribute("cod","757" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","25" );
      ((Element)v.get(275)).setAttribute("height","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(277)).setAttribute("nombre","lblSexo" );
      ((Element)v.get(277)).setAttribute("alto","13" );
      ((Element)v.get(277)).setAttribute("filas","1" );
      ((Element)v.get(277)).setAttribute("valor","" );
      ((Element)v.get(277)).setAttribute("id","datosTitle" );
      ((Element)v.get(277)).setAttribute("cod","1122" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).setAttribute("width","100%" );
      ((Element)v.get(261)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:261   */

      /* Empieza nodo:280 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(280)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(284)).setAttribute("nombre","textNombre1" );
      ((Element)v.get(284)).setAttribute("id","datosCampos" );
      ((Element)v.get(284)).setAttribute("onshtab","onshTabCampos('textNombre1');" );
      ((Element)v.get(284)).setAttribute("max","25" );
      ((Element)v.get(284)).setAttribute("tipo","" );
      ((Element)v.get(284)).setAttribute("onchange","" );
      ((Element)v.get(284)).setAttribute("req","S" );
      ((Element)v.get(284)).setAttribute("size","25" );
      ((Element)v.get(284)).setAttribute("valor","" );
      ((Element)v.get(284)).setAttribute("validacion","" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","25" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(287)).setAttribute("valign","bottom" );
      ((Element)v.get(280)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(288)).setAttribute("nombre","textNombre2" );
      ((Element)v.get(288)).setAttribute("id","datosCampos" );
      ((Element)v.get(288)).setAttribute("onshtab","onshTabCampos('textNombre2');" );
      ((Element)v.get(288)).setAttribute("max","25" );
      ((Element)v.get(288)).setAttribute("tipo","" );
      ((Element)v.get(288)).setAttribute("onchange","" );
      ((Element)v.get(288)).setAttribute("req","N" );
      ((Element)v.get(288)).setAttribute("size","25" );
      ((Element)v.get(288)).setAttribute("valor","" );
      ((Element)v.get(288)).setAttribute("validacion","" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","25" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(291)).setAttribute("valign","bottom" );
      ((Element)v.get(280)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(292)).setAttribute("nombre","cbTratamiento" );
      ((Element)v.get(292)).setAttribute("id","datosCampos" );
      ((Element)v.get(292)).setAttribute("onshtab","onshTabCampos('cbTratamiento');" );
      ((Element)v.get(292)).setAttribute("size","1" );
      ((Element)v.get(292)).setAttribute("multiple","N" );
      ((Element)v.get(292)).setAttribute("req","N" );
      ((Element)v.get(292)).setAttribute("valorinicial","" );
      ((Element)v.get(292)).setAttribute("textoinicial","" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:294 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","25" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).setAttribute("class","datosCampos" );
      ((Element)v.get(296)).setAttribute("valign","bottom" );
      ((Element)v.get(280)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(297)).setAttribute("nombre","rbSexo" );
      ((Element)v.get(297)).setAttribute("tipo","H" );
      ((Element)v.get(297)).setAttribute("id","datosCampos" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(298)).setAttribute("valor","S" );
      ((Element)v.get(298)).setAttribute("check","N" );
      ((Element)v.get(298)).setAttribute("onfocus","" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("cod","1334" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Elemento padre:298 / Elemento actual: 299   */
      v.add(doc.createTextNode("Masculino"));
      ((Element)v.get(298)).appendChild((Text)v.get(299));

      /* Termina nodo Texto:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(300)).setAttribute("valor","N" );
      ((Element)v.get(300)).setAttribute("check","N" );
      ((Element)v.get(300)).setAttribute("onfocus","" );
      ((Element)v.get(300)).setAttribute("id","datosCampos" );
      ((Element)v.get(300)).setAttribute("cod","1335" );
      ((Element)v.get(297)).appendChild((Element)v.get(300));

      /* Elemento padre:300 / Elemento actual: 301   */
      v.add(doc.createTextNode("Femenino"));
      ((Element)v.get(300)).appendChild((Text)v.get(301));

      /* Termina nodo Texto:301   */
      /* Termina nodo:300   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:302 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).setAttribute("width","100%" );
      ((Element)v.get(280)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","8" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:280   */

      /* Empieza nodo:304 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(304));

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
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:307 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("table"));
      ((Element)v.get(309)).setAttribute("width","725" );
      ((Element)v.get(309)).setAttribute("border","0" );
      ((Element)v.get(309)).setAttribute("align","left" );
      ((Element)v.get(309)).setAttribute("cellspacing","0" );
      ((Element)v.get(309)).setAttribute("cellpadding","0" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(314)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(314)).setAttribute("alto","13" );
      ((Element)v.get(314)).setAttribute("filas","1" );
      ((Element)v.get(314)).setAttribute("valor","" );
      ((Element)v.get(314)).setAttribute("id","datosTitle" );
      ((Element)v.get(314)).setAttribute("cod","541" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","25" );
      ((Element)v.get(316)).setAttribute("height","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(318)).setAttribute("nombre","lblFechaIngreso" );
      ((Element)v.get(318)).setAttribute("alto","13" );
      ((Element)v.get(318)).setAttribute("filas","1" );
      ((Element)v.get(318)).setAttribute("valor","" );
      ((Element)v.get(318)).setAttribute("id","datosTitle" );
      ((Element)v.get(318)).setAttribute("cod","499" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(310)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:310   */

      /* Empieza nodo:321 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(324)).setAttribute("valign","bottom" );
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(325)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(325)).setAttribute("id","datosCampos" );
      ((Element)v.get(325)).setAttribute("onshtab","onshTabCampos('cbFormaPago');" );
      ((Element)v.get(325)).setAttribute("size","1" );
      ((Element)v.get(325)).setAttribute("multiple","N" );
      ((Element)v.get(325)).setAttribute("req","N" );
      ((Element)v.get(325)).setAttribute("valorinicial","" );
      ((Element)v.get(325)).setAttribute("textoinicial","" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","25" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("valign","middle" );
      ((Element)v.get(321)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(330)).setAttribute("nombre","lblFechaIngresoActual" );
      ((Element)v.get(330)).setAttribute("alto","13" );
      ((Element)v.get(330)).setAttribute("filas","1" );
      ((Element)v.get(330)).setAttribute("valor","" );
      ((Element)v.get(330)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("width","100%" );
      ((Element)v.get(321)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","8" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:321   */

      /* Empieza nodo:333 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).setAttribute("colspan","4" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","8" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:218   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:336 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","12" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:211   */

      /* Empieza nodo:338 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("colspan","3" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","15" );
      ((Element)v.get(340)).setAttribute("height","15" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:341 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(346)).setAttribute("class","legend" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(347)).setAttribute("nombre","lblTitGrupoPrimerContacto" );
      ((Element)v.get(347)).setAttribute("alto","13" );
      ((Element)v.get(347)).setAttribute("filas","1" );
      ((Element)v.get(347)).setAttribute("valor","" );
      ((Element)v.get(347)).setAttribute("cod","0056" );
      ((Element)v.get(347)).setAttribute("id","legend" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 345   */
      v.add(doc.createElement("table"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(348)).setAttribute("border","0" );
      ((Element)v.get(348)).setAttribute("align","center" );
      ((Element)v.get(348)).setAttribute("cellspacing","0" );
      ((Element)v.get(348)).setAttribute("cellpadding","0" );
      ((Element)v.get(345)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("table"));
      ((Element)v.get(351)).setAttribute("width","725" );
      ((Element)v.get(351)).setAttribute("border","0" );
      ((Element)v.get(351)).setAttribute("align","left" );
      ((Element)v.get(351)).setAttribute("cellspacing","0" );
      ((Element)v.get(351)).setAttribute("cellpadding","0" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

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

      /* Empieza nodo:355 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).setAttribute("colspan","3" );
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(359)).setAttribute("nombre","lblCodClienteContactado" );
      ((Element)v.get(359)).setAttribute("alto","13" );
      ((Element)v.get(359)).setAttribute("filas","1" );
      ((Element)v.get(359)).setAttribute("valor","" );
      ((Element)v.get(359)).setAttribute("id","datosTitle" );
      ((Element)v.get(359)).setAttribute("cod","1060" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","25" );
      ((Element)v.get(361)).setAttribute("height","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(363)).setAttribute("nombre","lblTipoClienteContactado" );
      ((Element)v.get(363)).setAttribute("alto","13" );
      ((Element)v.get(363)).setAttribute("filas","1" );
      ((Element)v.get(363)).setAttribute("valor","" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(363)).setAttribute("id","datosTitle" );
      ((Element)v.get(363)).setAttribute("cod","1125" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","25" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(367)).setAttribute("nombre","lblTipoClienteContacto" );
      ((Element)v.get(367)).setAttribute("alto","13" );
      ((Element)v.get(367)).setAttribute("filas","1" );
      ((Element)v.get(367)).setAttribute("valor","" );
      ((Element)v.get(367)).setAttribute("id","datosTitle" );
      ((Element)v.get(367)).setAttribute("cod","1343" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","25" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(371)).setAttribute("nombre","lblCodTipoContacto" );
      ((Element)v.get(371)).setAttribute("alto","13" );
      ((Element)v.get(371)).setAttribute("filas","1" );
      ((Element)v.get(371)).setAttribute("valor","" );
      ((Element)v.get(371)).setAttribute("id","datosTitle" );
      ((Element)v.get(371)).setAttribute("cod","1065" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).setAttribute("width","100%" );
      ((Element)v.get(355)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","8" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:355   */

      /* Empieza nodo:374 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(378)).setAttribute("nombre","textCodClienteContactado" );
      ((Element)v.get(378)).setAttribute("id","datosCampos" );
      ((Element)v.get(378)).setAttribute("max","15" );
      ((Element)v.get(378)).setAttribute("tipo","" );
      ((Element)v.get(378)).setAttribute("onshtab","onshTabCampos('textCodClienteContactado');" );
      ((Element)v.get(378)).setAttribute("onchange","clienteContactadoOnBlur();" );
      ((Element)v.get(378)).setAttribute("req","N" );
      ((Element)v.get(378)).setAttribute("size","19" );
      ((Element)v.get(378)).setAttribute("valor","" );
      ((Element)v.get(378)).setAttribute("validacion","" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","8" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(382)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(382)).setAttribute("onclick","seleccionarClienteContactado();" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","25" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).setAttribute("nowrap","nowrap" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(385)).setAttribute("valign","top" );
      ((Element)v.get(374)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(386)).setAttribute("nombre","cbTipoClienteContactado" );
      ((Element)v.get(386)).setAttribute("id","datosCampos" );
      ((Element)v.get(386)).setAttribute("size","1" );
      ((Element)v.get(386)).setAttribute("multiple","N" );
      ((Element)v.get(386)).setAttribute("req","N" );
      ((Element)v.get(386)).setAttribute("valorinicial","" );
      ((Element)v.get(386)).setAttribute("textoinicial","" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:388 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","25" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(391)).setAttribute("nombre","lblTipoClienteContactoActual" );
      ((Element)v.get(391)).setAttribute("alto","13" );
      ((Element)v.get(391)).setAttribute("filas","1" );
      ((Element)v.get(391)).setAttribute("valor","" );
      ((Element)v.get(391)).setAttribute("id","datosCampos" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","25" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(394)).setAttribute("valign","top" );
      ((Element)v.get(374)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(395)).setAttribute("nombre","cbCodTipoContactado" );
      ((Element)v.get(395)).setAttribute("id","datosCampos" );
      ((Element)v.get(395)).setAttribute("size","1" );
      ((Element)v.get(395)).setAttribute("multiple","N" );
      ((Element)v.get(395)).setAttribute("req","N" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:397 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).setAttribute("width","100%" );
      ((Element)v.get(374)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","8" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:374   */

      /* Empieza nodo:399 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).setAttribute("colspan","4" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:402 / Elemento padre: 348   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(348)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("table"));
      ((Element)v.get(404)).setAttribute("width","725" );
      ((Element)v.get(404)).setAttribute("border","0" );
      ((Element)v.get(404)).setAttribute("align","left" );
      ((Element)v.get(404)).setAttribute("cellspacing","0" );
      ((Element)v.get(404)).setAttribute("cellpadding","0" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(407)).setAttribute("height","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(409)).setAttribute("nombre","lblFechaContacto" );
      ((Element)v.get(409)).setAttribute("alto","13" );
      ((Element)v.get(409)).setAttribute("filas","1" );
      ((Element)v.get(409)).setAttribute("valor","" );
      ((Element)v.get(409)).setAttribute("id","datosTitle" );
      ((Element)v.get(409)).setAttribute("cod","1078" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","25" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(413)).setAttribute("nombre","lblFechaSiguienteContacto" );
      ((Element)v.get(413)).setAttribute("alto","13" );
      ((Element)v.get(413)).setAttribute("filas","1" );
      ((Element)v.get(413)).setAttribute("valor","" );
      ((Element)v.get(413)).setAttribute("id","datosTitle" );
      ((Element)v.get(413)).setAttribute("cod","1342" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).setAttribute("width","25" );
      ((Element)v.get(415)).setAttribute("height","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(417)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(417)).setAttribute("alto","13" );
      ((Element)v.get(417)).setAttribute("filas","1" );
      ((Element)v.get(417)).setAttribute("valor","" );
      ((Element)v.get(417)).setAttribute("id","datosTitle" );
      ((Element)v.get(417)).setAttribute("cod","6" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).setAttribute("width","100%" );
      ((Element)v.get(405)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","8" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:405   */

      /* Empieza nodo:420 / Elemento padre: 404   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(404)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","8" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(424)).setAttribute("nombre","textFechaContacto" );
      ((Element)v.get(424)).setAttribute("id","datosCampos" );
      ((Element)v.get(424)).setAttribute("max","10" );
      ((Element)v.get(424)).setAttribute("tipo","" );
      ((Element)v.get(424)).setAttribute("onchange","" );
      ((Element)v.get(424)).setAttribute("req","N" );
      ((Element)v.get(424)).setAttribute("size","12" );
      ((Element)v.get(424)).setAttribute("valor","" );
      ((Element)v.get(424)).setAttribute("validacion","" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","25" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:427 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(428)).setAttribute("nombre","textFechaSiguienteContacto" );
      ((Element)v.get(428)).setAttribute("id","datosCampos" );
      ((Element)v.get(428)).setAttribute("max","10" );
      ((Element)v.get(428)).setAttribute("tipo","" );
      ((Element)v.get(428)).setAttribute("onchange","" );
      ((Element)v.get(428)).setAttribute("req","N" );
      ((Element)v.get(428)).setAttribute("size","12" );
      ((Element)v.get(428)).setAttribute("valor","" );
      ((Element)v.get(428)).setAttribute("validacion","" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","25" );
      ((Element)v.get(430)).setAttribute("height","8" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(432)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(432)).setAttribute("id","datosCampos" );
      ((Element)v.get(432)).setAttribute("size","1" );
      ((Element)v.get(432)).setAttribute("multiple","N" );
      ((Element)v.get(432)).setAttribute("req","N" );
      ((Element)v.get(432)).setAttribute("valorinicial","" );
      ((Element)v.get(432)).setAttribute("textoinicial","" );
      ((Element)v.get(432)).setAttribute("onchange","" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:434 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(434)).setAttribute("width","100%" );
      ((Element)v.get(420)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:420   */

      /* Empieza nodo:436 / Elemento padre: 404   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(404)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(437)).setAttribute("colspan","4" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(438)).setAttribute("width","8" );
      ((Element)v.get(438)).setAttribute("height","8" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:404   */
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:439 / Elemento padre: 348   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(348)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("table"));
      ((Element)v.get(441)).setAttribute("width","725" );
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
      ((Element)v.get(446)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(446)).setAttribute("alto","13" );
      ((Element)v.get(446)).setAttribute("filas","1" );
      ((Element)v.get(446)).setAttribute("valor","" );
      ((Element)v.get(446)).setAttribute("id","datosTitle" );
      ((Element)v.get(446)).setAttribute("cod","7" );
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
      ((Element)v.get(450)).setAttribute("nombre","lblPeriodoPrimerPedido" );
      ((Element)v.get(450)).setAttribute("alto","13" );
      ((Element)v.get(450)).setAttribute("filas","1" );
      ((Element)v.get(450)).setAttribute("valor","" );
      ((Element)v.get(450)).setAttribute("id","datosTitle" );
      ((Element)v.get(450)).setAttribute("cod","2420" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).setAttribute("width","100%" );
      ((Element)v.get(442)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","8" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:442   */

      /* Empieza nodo:453 / Elemento padre: 441   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(441)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","8" );
      ((Element)v.get(455)).setAttribute("height","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:456 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(457)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(457)).setAttribute("id","datosCampos" );
      ((Element)v.get(457)).setAttribute("size","1" );
      ((Element)v.get(457)).setAttribute("multiple","N" );
      ((Element)v.get(457)).setAttribute("req","N" );
      ((Element)v.get(457)).setAttribute("valorinicial","" );
      ((Element)v.get(457)).setAttribute("textoinicial","" );
      ((Element)v.get(457)).setAttribute("onchange","cambiarPeriodoContacto('');" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:459 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","25" );
      ((Element)v.get(460)).setAttribute("height","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(462)).setAttribute("nombre","cbPeriodoPrimerPedido" );
      ((Element)v.get(462)).setAttribute("id","datosCampos" );
      ((Element)v.get(462)).setAttribute("size","1" );
      ((Element)v.get(462)).setAttribute("multiple","N" );
      ((Element)v.get(462)).setAttribute("req","N" );
      ((Element)v.get(462)).setAttribute("valorinicial","" );
      ((Element)v.get(462)).setAttribute("textoinicial","" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:464 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).setAttribute("width","100%" );
      ((Element)v.get(453)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","8" );
      ((Element)v.get(465)).setAttribute("height","8" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:453   */

      /* Empieza nodo:466 / Elemento padre: 441   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(441)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).setAttribute("colspan","4" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","8" );
      ((Element)v.get(468)).setAttribute("height","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:348   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:469 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(470)).setAttribute("src","b.gif" );
      ((Element)v.get(470)).setAttribute("width","8" );
      ((Element)v.get(470)).setAttribute("height","12" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:341   */

      /* Empieza nodo:471 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).setAttribute("colspan","3" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","15" );
      ((Element)v.get(473)).setAttribute("height","15" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:474 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 474   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(479)).setAttribute("class","legend" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(480)).setAttribute("nombre","lblTitDatosAdiccionales" );
      ((Element)v.get(480)).setAttribute("alto","13" );
      ((Element)v.get(480)).setAttribute("filas","1" );
      ((Element)v.get(480)).setAttribute("valor","" );
      ((Element)v.get(480)).setAttribute("cod","0052" );
      ((Element)v.get(480)).setAttribute("id","legend" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 478   */
      v.add(doc.createElement("table"));
      ((Element)v.get(481)).setAttribute("width","100%" );
      ((Element)v.get(481)).setAttribute("border","0" );
      ((Element)v.get(481)).setAttribute("align","center" );
      ((Element)v.get(481)).setAttribute("cellspacing","0" );
      ((Element)v.get(481)).setAttribute("cellpadding","0" );
      ((Element)v.get(478)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("table"));
      ((Element)v.get(484)).setAttribute("width","725" );
      ((Element)v.get(484)).setAttribute("border","0" );
      ((Element)v.get(484)).setAttribute("align","left" );
      ((Element)v.get(484)).setAttribute("cellspacing","0" );
      ((Element)v.get(484)).setAttribute("cellpadding","0" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).setAttribute("colspan","4" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","8" );
      ((Element)v.get(487)).setAttribute("height","8" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:488 / Elemento padre: 484   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(484)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(490)).setAttribute("src","b.gif" );
      ((Element)v.get(490)).setAttribute("width","8" );
      ((Element)v.get(490)).setAttribute("height","8" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(492)).setAttribute("nombre","lblFechaNacimiento" );
      ((Element)v.get(492)).setAttribute("alto","13" );
      ((Element)v.get(492)).setAttribute("filas","1" );
      ((Element)v.get(492)).setAttribute("valor","" );
      ((Element)v.get(492)).setAttribute("id","datosTitle" );
      ((Element)v.get(492)).setAttribute("cod","877" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","25" );
      ((Element)v.get(494)).setAttribute("height","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(496)).setAttribute("nombre","lblCodEmpleado" );
      ((Element)v.get(496)).setAttribute("alto","13" );
      ((Element)v.get(496)).setAttribute("filas","1" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(496)).setAttribute("id","datosTitle" );
      ((Element)v.get(496)).setAttribute("cod","1336" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","25" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(500)).setAttribute("nombre","lblNacionalidad" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(500)).setAttribute("alto","13" );
      ((Element)v.get(500)).setAttribute("filas","1" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(500)).setAttribute("id","datosTitle" );
      ((Element)v.get(500)).setAttribute("cod","1095" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:501 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","25" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(504)).setAttribute("nombre","lblEdad" );
      ((Element)v.get(504)).setAttribute("alto","13" );
      ((Element)v.get(504)).setAttribute("filas","1" );
      ((Element)v.get(504)).setAttribute("valor","" );
      ((Element)v.get(504)).setAttribute("id","datosTitle" );
      ((Element)v.get(504)).setAttribute("cod","1074" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","25" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:507 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(508)).setAttribute("nombre","lblEstadoCivil" );
      ((Element)v.get(508)).setAttribute("alto","13" );
      ((Element)v.get(508)).setAttribute("filas","1" );
      ((Element)v.get(508)).setAttribute("valor","" );
      ((Element)v.get(508)).setAttribute("id","datosTitle" );
      ((Element)v.get(508)).setAttribute("cod","1076" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","25" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:511 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(512)).setAttribute("nombre","lblOcupacion" );
      ((Element)v.get(512)).setAttribute("alto","13" );
      ((Element)v.get(512)).setAttribute("filas","1" );
      ((Element)v.get(512)).setAttribute("valor","" );
      ((Element)v.get(512)).setAttribute("id","datosTitle" );
      ((Element)v.get(512)).setAttribute("cod","1109" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */

      /* Empieza nodo:513 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).setAttribute("width","100%" );
      ((Element)v.get(488)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).setAttribute("width","8" );
      ((Element)v.get(514)).setAttribute("height","8" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:488   */

      /* Empieza nodo:515 / Elemento padre: 484   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(484)).appendChild((Element)v.get(515));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(519)).setAttribute("nombre","textFechaNacimiento" );
      ((Element)v.get(519)).setAttribute("onblur","actualizaFechaNacimiento();" );
      ((Element)v.get(519)).setAttribute("id","datosCampos" );
      ((Element)v.get(519)).setAttribute("max","10" );
      ((Element)v.get(519)).setAttribute("tipo","" );
      ((Element)v.get(519)).setAttribute("onchange","" );
      ((Element)v.get(519)).setAttribute("req","N" );
      ((Element)v.get(519)).setAttribute("size","12" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(519)).setAttribute("validacion","" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","25" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(523)).setAttribute("nombre","textCodEmpleado" );
      ((Element)v.get(523)).setAttribute("id","datosCampos" );
      ((Element)v.get(523)).setAttribute("max","10" );
      ((Element)v.get(523)).setAttribute("tipo","10" );
      ((Element)v.get(523)).setAttribute("onchange","" );
      ((Element)v.get(523)).setAttribute("req","N" );
      ((Element)v.get(523)).setAttribute("size","12" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(523)).setAttribute("validacion","" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","25" );
      ((Element)v.get(525)).setAttribute("height","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(526)).setAttribute("valign","top" );
      ((Element)v.get(515)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(527)).setAttribute("nombre","cbNacionalidad" );
      ((Element)v.get(527)).setAttribute("id","datosCampos" );
      ((Element)v.get(527)).setAttribute("size","1" );
      ((Element)v.get(527)).setAttribute("multiple","N" );
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

      /* Empieza nodo:529 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).setAttribute("width","25" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(532)).setAttribute("nombre","lblEdadActual" );
      ((Element)v.get(532)).setAttribute("alto","15" );
      ((Element)v.get(532)).setAttribute("filas","1" );
      ((Element)v.get(532)).setAttribute("valor","" );
      ((Element)v.get(532)).setAttribute("id","datosCampos" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","25" );
      ((Element)v.get(534)).setAttribute("height","8" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(535)).setAttribute("valign","top" );
      ((Element)v.get(515)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(536)).setAttribute("nombre","cbEstadoCivil" );
      ((Element)v.get(536)).setAttribute("id","datosCampos" );
      ((Element)v.get(536)).setAttribute("size","1" );
      ((Element)v.get(536)).setAttribute("multiple","N" );
      ((Element)v.get(536)).setAttribute("req","N" );
      ((Element)v.get(536)).setAttribute("valorinicial","" );
      ((Element)v.get(536)).setAttribute("textoinicial","" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:538 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","25" );
      ((Element)v.get(539)).setAttribute("height","8" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(541)).setAttribute("nombre","textOcupacion" );
      ((Element)v.get(541)).setAttribute("id","datosCampos" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(541)).setAttribute("max","40" );
      ((Element)v.get(541)).setAttribute("tipo","" );
      ((Element)v.get(541)).setAttribute("onchange","" );
      ((Element)v.get(541)).setAttribute("req","N" );
      ((Element)v.get(541)).setAttribute("size","40" );
      ((Element)v.get(541)).setAttribute("valor","" );
      ((Element)v.get(541)).setAttribute("validacion","" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(542)).setAttribute("width","100%" );
      ((Element)v.get(515)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","8" );
      ((Element)v.get(543)).setAttribute("height","8" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:515   */

      /* Empieza nodo:544 / Elemento padre: 484   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(484)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("td"));
      ((Element)v.get(545)).setAttribute("colspan","4" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(546)).setAttribute("src","b.gif" );
      ((Element)v.get(546)).setAttribute("width","8" );
      ((Element)v.get(546)).setAttribute("height","8" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:547 / Elemento padre: 481   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(481)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("td"));
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("table"));
      ((Element)v.get(549)).setAttribute("width","725" );
      ((Element)v.get(549)).setAttribute("border","0" );
      ((Element)v.get(549)).setAttribute("align","left" );
      ((Element)v.get(549)).setAttribute("cellspacing","0" );
      ((Element)v.get(549)).setAttribute("cellpadding","0" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","8" );
      ((Element)v.get(552)).setAttribute("height","8" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(554)).setAttribute("nombre","lblProfesion" );
      ((Element)v.get(554)).setAttribute("alto","13" );
      ((Element)v.get(554)).setAttribute("filas","1" );
      ((Element)v.get(554)).setAttribute("valor","" );
      ((Element)v.get(554)).setAttribute("id","datosTitle" );
      ((Element)v.get(554)).setAttribute("cod","1117" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","25" );
      ((Element)v.get(556)).setAttribute("height","8" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */

      /* Empieza nodo:557 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(558)).setAttribute("nombre","lblCentroTrabajo" );
      ((Element)v.get(558)).setAttribute("alto","13" );
      ((Element)v.get(558)).setAttribute("filas","1" );
      ((Element)v.get(558)).setAttribute("valor","" );
      ((Element)v.get(558)).setAttribute("id","datosTitle" );
      ((Element)v.get(558)).setAttribute("cod","1055" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:559 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(560)).setAttribute("src","b.gif" );
      ((Element)v.get(560)).setAttribute("width","25" );
      ((Element)v.get(560)).setAttribute("height","8" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */

      /* Empieza nodo:561 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(562)).setAttribute("nombre","lblCargoDesempena" );
      ((Element)v.get(562)).setAttribute("alto","13" );
      ((Element)v.get(562)).setAttribute("filas","1" );
      ((Element)v.get(562)).setAttribute("valor","" );
      ((Element)v.get(562)).setAttribute("id","datosTitle" );
      ((Element)v.get(562)).setAttribute("cod","1053" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 550   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).setAttribute("width","100%" );
      ((Element)v.get(550)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(564)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).setAttribute("width","8" );
      ((Element)v.get(564)).setAttribute("height","8" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */
      /* Termina nodo:550   */

      /* Empieza nodo:565 / Elemento padre: 549   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(549)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).setAttribute("width","8" );
      ((Element)v.get(567)).setAttribute("height","8" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 565   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(569)).setAttribute("nombre","textProfesion" );
      ((Element)v.get(569)).setAttribute("id","datosCampos" );
      ((Element)v.get(569)).setAttribute("max","40" );
      ((Element)v.get(569)).setAttribute("tipo","" );
      ((Element)v.get(569)).setAttribute("onchange","" );
      ((Element)v.get(569)).setAttribute("req","N" );
      ((Element)v.get(569)).setAttribute("size","40" );
      ((Element)v.get(569)).setAttribute("valor","" );
      ((Element)v.get(569)).setAttribute("validacion","" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 565   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(571)).setAttribute("src","b.gif" );
      ((Element)v.get(571)).setAttribute("width","25" );
      ((Element)v.get(571)).setAttribute("height","8" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 565   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(573)).setAttribute("nombre","textCentroTrabajo" );
      ((Element)v.get(573)).setAttribute("id","datosCampos" );
      ((Element)v.get(573)).setAttribute("max","40" );
      ((Element)v.get(573)).setAttribute("tipo","" );
      ((Element)v.get(573)).setAttribute("onchange","" );
      ((Element)v.get(573)).setAttribute("req","N" );
      ((Element)v.get(573)).setAttribute("size","40" );
      ((Element)v.get(573)).setAttribute("valor","" );
      ((Element)v.get(573)).setAttribute("validacion","" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 565   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(575)).setAttribute("src","b.gif" );
      ((Element)v.get(575)).setAttribute("width","25" );
      ((Element)v.get(575)).setAttribute("height","8" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 565   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(577)).setAttribute("nombre","textCargoDesempena" );
      ((Element)v.get(577)).setAttribute("id","datosCampos" );
      ((Element)v.get(577)).setAttribute("max","40" );
      ((Element)v.get(577)).setAttribute("tipo","" );
      ((Element)v.get(577)).setAttribute("onchange","" );
      ((Element)v.get(577)).setAttribute("req","N" );
      ((Element)v.get(577)).setAttribute("size","40" );
      ((Element)v.get(577)).setAttribute("valor","" );
      ((Element)v.get(577)).setAttribute("validacion","" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 565   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).setAttribute("width","100%" );
      ((Element)v.get(565)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(579)).setAttribute("width","8" );
      ((Element)v.get(579)).setAttribute("height","8" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */
      /* Termina nodo:565   */

      /* Empieza nodo:580 / Elemento padre: 549   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(549)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("td"));
      ((Element)v.get(581)).setAttribute("colspan","4" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(582)).setAttribute("src","b.gif" );
      ((Element)v.get(582)).setAttribute("width","8" );
      ((Element)v.get(582)).setAttribute("height","8" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:583 / Elemento padre: 481   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(481)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("table"));
      ((Element)v.get(585)).setAttribute("width","725" );
      ((Element)v.get(585)).setAttribute("border","0" );
      ((Element)v.get(585)).setAttribute("align","left" );
      ((Element)v.get(585)).setAttribute("cellspacing","0" );
      ((Element)v.get(585)).setAttribute("cellpadding","0" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","8" );
      ((Element)v.get(588)).setAttribute("height","8" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */

      /* Empieza nodo:589 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(590)).setAttribute("nombre","lblNivelEstudios" );
      ((Element)v.get(590)).setAttribute("alto","13" );
      ((Element)v.get(590)).setAttribute("filas","1" );
      ((Element)v.get(590)).setAttribute("valor","" );
      ((Element)v.get(590)).setAttribute("id","datosTitle" );
      ((Element)v.get(590)).setAttribute("cod","1106" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */

      /* Empieza nodo:591 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","25" );
      ((Element)v.get(592)).setAttribute("height","8" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(594)).setAttribute("nombre","lblCentroEstudios" );
      ((Element)v.get(594)).setAttribute("alto","13" );
      ((Element)v.get(594)).setAttribute("filas","1" );
      ((Element)v.get(594)).setAttribute("valor","" );
      ((Element)v.get(594)).setAttribute("id","datosTitle" );
      ((Element)v.get(594)).setAttribute("cod","1054" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(596)).setAttribute("width","25" );
      ((Element)v.get(596)).setAttribute("height","8" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:597 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(598)).setAttribute("nombre","lblNHijos" );
      ((Element)v.get(598)).setAttribute("alto","13" );
      ((Element)v.get(598)).setAttribute("filas","1" );
      ((Element)v.get(598)).setAttribute("valor","" );
      ((Element)v.get(598)).setAttribute("id","datosTitle" );
      ((Element)v.get(598)).setAttribute("cod","1108" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:599 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","25" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(602)).setAttribute("nombre","lblNPersonasDependientes" );
      ((Element)v.get(602)).setAttribute("alto","13" );
      ((Element)v.get(602)).setAttribute("filas","1" );
      ((Element)v.get(602)).setAttribute("valor","" );
      ((Element)v.get(602)).setAttribute("id","datosTitle" );
      ((Element)v.get(602)).setAttribute("cod","1337" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:603 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(603)).setAttribute("width","100%" );
      ((Element)v.get(586)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("width","8" );
      ((Element)v.get(604)).setAttribute("height","8" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */
      /* Termina nodo:586   */

      /* Empieza nodo:605 / Elemento padre: 585   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(585)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).setAttribute("width","8" );
      ((Element)v.get(607)).setAttribute("height","8" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:608 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(608)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(608)).setAttribute("valign","top" );
      ((Element)v.get(605)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(609)).setAttribute("nombre","cbNivelEstudios" );
      ((Element)v.get(609)).setAttribute("id","datosCampos" );
      ((Element)v.get(609)).setAttribute("size","1" );
      ((Element)v.get(609)).setAttribute("multiple","N" );
      ((Element)v.get(609)).setAttribute("req","N" );
      ((Element)v.get(609)).setAttribute("valorinicial","" );
      ((Element)v.get(609)).setAttribute("textoinicial","" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:611 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","25" );
      ((Element)v.get(612)).setAttribute("height","8" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(614)).setAttribute("nombre","textCentroEstudios" );
      ((Element)v.get(614)).setAttribute("id","datosCampos" );
      ((Element)v.get(614)).setAttribute("max","40" );
      ((Element)v.get(614)).setAttribute("tipo","" );
      ((Element)v.get(614)).setAttribute("onchange","" );
      ((Element)v.get(614)).setAttribute("req","N" );
      ((Element)v.get(614)).setAttribute("size","40" );
      ((Element)v.get(614)).setAttribute("valor","" );
      ((Element)v.get(614)).setAttribute("validacion","" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */

      /* Empieza nodo:615 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(616)).setAttribute("src","b.gif" );
      ((Element)v.get(616)).setAttribute("width","25" );
      ((Element)v.get(616)).setAttribute("height","8" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:617 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(618)).setAttribute("nombre","textNHijos" );
      ((Element)v.get(618)).setAttribute("id","datosCampos" );
      ((Element)v.get(618)).setAttribute("max","2" );
      ((Element)v.get(618)).setAttribute("tipo","" );
      ((Element)v.get(618)).setAttribute("onchange","" );
      ((Element)v.get(618)).setAttribute("req","N" );
      ((Element)v.get(618)).setAttribute("size","2" );
      ((Element)v.get(618)).setAttribute("valor","" );
      ((Element)v.get(618)).setAttribute("validacion","" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:619 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(620)).setAttribute("src","b.gif" );
      ((Element)v.get(620)).setAttribute("width","25" );
      ((Element)v.get(620)).setAttribute("height","8" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */

      /* Empieza nodo:621 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(622)).setAttribute("nombre","textNPersonasDependientes" );
      ((Element)v.get(622)).setAttribute("id","datosCampos" );
      ((Element)v.get(622)).setAttribute("max","2" );
      ((Element)v.get(622)).setAttribute("tipo","" );
      ((Element)v.get(622)).setAttribute("onchange","" );
      ((Element)v.get(622)).setAttribute("req","N" );
      ((Element)v.get(622)).setAttribute("size","2" );
      ((Element)v.get(622)).setAttribute("valor","" );
      ((Element)v.get(622)).setAttribute("validacion","" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:623 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).setAttribute("width","100%" );
      ((Element)v.get(605)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","8" );
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:605   */

      /* Empieza nodo:625 / Elemento padre: 585   */
      v.add(doc.createElement("tr"));
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(585)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(626)).setAttribute("colspan","4" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(627)).setAttribute("src","b.gif" );
      ((Element)v.get(627)).setAttribute("width","8" );
      ((Element)v.get(627)).setAttribute("height","8" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */
      /* Termina nodo:625   */
      /* Termina nodo:585   */
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:628 / Elemento padre: 481   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(481)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("td"));
      ((Element)v.get(628)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("table"));
      ((Element)v.get(630)).setAttribute("width","725" );
      ((Element)v.get(630)).setAttribute("border","0" );
      ((Element)v.get(630)).setAttribute("align","left" );
      ((Element)v.get(630)).setAttribute("cellspacing","0" );
      ((Element)v.get(630)).setAttribute("cellpadding","0" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(630)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(633)).setAttribute("src","b.gif" );
      ((Element)v.get(633)).setAttribute("width","8" );
      ((Element)v.get(633)).setAttribute("height","8" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */

      /* Empieza nodo:634 / Elemento padre: 631   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(635)).setAttribute("nombre","lblNivelSocioEconomico" );
      ((Element)v.get(635)).setAttribute("alto","13" );
      ((Element)v.get(635)).setAttribute("filas","1" );
      ((Element)v.get(635)).setAttribute("valor","" );
      ((Element)v.get(635)).setAttribute("id","datosTitle" );
      ((Element)v.get(635)).setAttribute("cod","1107" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */

      /* Empieza nodo:636 / Elemento padre: 631   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(637)).setAttribute("src","b.gif" );
      ((Element)v.get(637)).setAttribute("width","25" );
      ((Element)v.get(637)).setAttribute("height","8" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:638 / Elemento padre: 631   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(639)).setAttribute("nombre","lblCicloVidaFamiliar" );
      ((Element)v.get(639)).setAttribute("alto","13" );
      ((Element)v.get(639)).setAttribute("filas","1" );
      ((Element)v.get(639)).setAttribute("valor","" );
      ((Element)v.get(639)).setAttribute("id","datosTitle" );
      ((Element)v.get(639)).setAttribute("cod","1056" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:640 / Elemento padre: 631   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(641)).setAttribute("src","b.gif" );
      ((Element)v.get(641)).setAttribute("width","25" );
      ((Element)v.get(641)).setAttribute("height","8" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:640   */

      /* Empieza nodo:642 / Elemento padre: 631   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(643)).setAttribute("nombre","lblDeseaCorrespondencia" );
      ((Element)v.get(643)).setAttribute("alto","13" );
      ((Element)v.get(643)).setAttribute("filas","1" );
      ((Element)v.get(643)).setAttribute("valor","" );
      ((Element)v.get(643)).setAttribute("id","datosTitle" );
      ((Element)v.get(643)).setAttribute("cod","1050" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:644 / Elemento padre: 631   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(645)).setAttribute("src","b.gif" );
      ((Element)v.get(645)).setAttribute("width","25" );
      ((Element)v.get(645)).setAttribute("height","8" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:646 / Elemento padre: 631   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(647)).setAttribute("nombre","lblImporteIngresoFamiliar" );
      ((Element)v.get(647)).setAttribute("alto","13" );
      ((Element)v.get(647)).setAttribute("filas","1" );
      ((Element)v.get(647)).setAttribute("valor","" );
      ((Element)v.get(647)).setAttribute("id","datosTitle" );
      ((Element)v.get(647)).setAttribute("cod","1080" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */
      /* Termina nodo:646   */

      /* Empieza nodo:648 / Elemento padre: 631   */
   }

   private void getXML2700(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(648)).setAttribute("width","100%" );
      ((Element)v.get(631)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(649)).setAttribute("src","b.gif" );
      ((Element)v.get(649)).setAttribute("width","8" );
      ((Element)v.get(649)).setAttribute("height","8" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:648   */
      /* Termina nodo:631   */

      /* Empieza nodo:650 / Elemento padre: 630   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(630)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(652)).setAttribute("src","b.gif" );
      ((Element)v.get(652)).setAttribute("width","8" );
      ((Element)v.get(652)).setAttribute("height","8" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */
      /* Termina nodo:651   */

      /* Empieza nodo:653 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(653)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(653)).setAttribute("valign","top" );
      ((Element)v.get(650)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(654)).setAttribute("nombre","cbNivelSocioEconomico" );
      ((Element)v.get(654)).setAttribute("id","datosCampos" );
      ((Element)v.get(654)).setAttribute("size","1" );
      ((Element)v.get(654)).setAttribute("multiple","N" );
      ((Element)v.get(654)).setAttribute("req","N" );
      ((Element)v.get(654)).setAttribute("valorinicial","" );
      ((Element)v.get(654)).setAttribute("textoinicial","" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(654)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:654   */
      /* Termina nodo:653   */

      /* Empieza nodo:656 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(657)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).setAttribute("width","25" );
      ((Element)v.get(657)).setAttribute("height","8" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */

      /* Empieza nodo:658 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(658)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(658)).setAttribute("valign","top" );
      ((Element)v.get(650)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(659)).setAttribute("nombre","cbCicloVidaFamiliar" );
      ((Element)v.get(659)).setAttribute("id","datosCampos" );
      ((Element)v.get(659)).setAttribute("size","1" );
      ((Element)v.get(659)).setAttribute("multiple","N" );
      ((Element)v.get(659)).setAttribute("req","N" );
      ((Element)v.get(659)).setAttribute("valorinicial","" );
      ((Element)v.get(659)).setAttribute("textoinicial","" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(659)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */
      /* Termina nodo:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:661 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(662)).setAttribute("src","b.gif" );
      ((Element)v.get(662)).setAttribute("width","25" );
      ((Element)v.get(662)).setAttribute("height","8" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:661   */

      /* Empieza nodo:663 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(663)).setAttribute("class","datosCampos" );
      ((Element)v.get(650)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(664)).setAttribute("nombre","rbDeseaCorrespondencia" );
      ((Element)v.get(664)).setAttribute("tipo","H" );
      ((Element)v.get(664)).setAttribute("id","datosCampos" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(665)).setAttribute("valor","S" );
      ((Element)v.get(665)).setAttribute("check","N" );
      ((Element)v.get(665)).setAttribute("onfocus","" );
      ((Element)v.get(665)).setAttribute("id","datosCampos" );
      ((Element)v.get(665)).setAttribute("cod","117" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));

      /* Elemento padre:665 / Elemento actual: 666   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(665)).appendChild((Text)v.get(666));

      /* Termina nodo Texto:666   */
      /* Termina nodo:665   */

      /* Empieza nodo:667 / Elemento padre: 664   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(667)).setAttribute("valor","N" );
      ((Element)v.get(667)).setAttribute("check","N" );
      ((Element)v.get(667)).setAttribute("onfocus","" );
      ((Element)v.get(667)).setAttribute("id","datosCampos" );
      ((Element)v.get(667)).setAttribute("cod","87" );
      ((Element)v.get(664)).appendChild((Element)v.get(667));

      /* Elemento padre:667 / Elemento actual: 668   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(667)).appendChild((Text)v.get(668));

      /* Termina nodo Texto:668   */
      /* Termina nodo:667   */
      /* Termina nodo:664   */
      /* Termina nodo:663   */

      /* Empieza nodo:669 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(670)).setAttribute("src","b.gif" );
      ((Element)v.get(670)).setAttribute("width","25" );
      ((Element)v.get(670)).setAttribute("height","8" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */
      /* Termina nodo:669   */

      /* Empieza nodo:671 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(672)).setAttribute("nombre","textImporteIngresoFamiliar" );
      ((Element)v.get(672)).setAttribute("id","datosCampos" );
      ((Element)v.get(672)).setAttribute("max","13" );
      ((Element)v.get(672)).setAttribute("tipo","" );
      ((Element)v.get(672)).setAttribute("onchange","" );
      ((Element)v.get(672)).setAttribute("req","N" );
      ((Element)v.get(672)).setAttribute("size","16" );
      ((Element)v.get(672)).setAttribute("valor","" );
      ((Element)v.get(672)).setAttribute("validacion","" );
      ((Element)v.get(672)).setAttribute("ontab","focalizaProximoDesdeImporte();" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:671   */

      /* Empieza nodo:673 / Elemento padre: 650   */
      v.add(doc.createElement("td"));
      ((Element)v.get(673)).setAttribute("width","100%" );
      ((Element)v.get(650)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(674)).setAttribute("src","b.gif" );
      ((Element)v.get(674)).setAttribute("width","8" );
      ((Element)v.get(674)).setAttribute("height","8" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:673   */
      /* Termina nodo:650   */

      /* Empieza nodo:675 / Elemento padre: 630   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(630)).appendChild((Element)v.get(675));

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
      /* Termina nodo:630   */
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:481   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:678 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(679)).setAttribute("src","b.gif" );
      ((Element)v.get(679)).setAttribute("width","8" );
      ((Element)v.get(679)).setAttribute("height","12" );
      ((Element)v.get(678)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:678   */
      /* Termina nodo:474   */

      /* Empieza nodo:680 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("td"));
      ((Element)v.get(681)).setAttribute("width","12" );
      ((Element)v.get(681)).setAttribute("align","center" );
      ((Element)v.get(680)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(682)).setAttribute("src","b.gif" );
      ((Element)v.get(682)).setAttribute("width","12" );
      ((Element)v.get(682)).setAttribute("height","12" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));
      /* Termina nodo:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:683 / Elemento padre: 680   */
      v.add(doc.createElement("td"));
      ((Element)v.get(683)).setAttribute("width","750" );
      ((Element)v.get(680)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(684)).setAttribute("src","b.gif" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */
      /* Termina nodo:683   */

      /* Empieza nodo:685 / Elemento padre: 680   */
      v.add(doc.createElement("td"));
      ((Element)v.get(685)).setAttribute("width","12" );
      ((Element)v.get(680)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(686)).setAttribute("src","b.gif" );
      ((Element)v.get(686)).setAttribute("width","12" );
      ((Element)v.get(686)).setAttribute("height","12" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */
      /* Termina nodo:680   */
      /* Termina nodo:203   */
      /* Termina nodo:164   */

      /* Empieza nodo:687 / Elemento padre: 30   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(687)).setAttribute("nombre","listado1" );
      ((Element)v.get(687)).setAttribute("ancho","731" );
      ((Element)v.get(687)).setAttribute("alto","162" );
      ((Element)v.get(687)).setAttribute("x","12" );
      ((Element)v.get(687)).setAttribute("y","580" );
      ((Element)v.get(687)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(687)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(688)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(688)).setAttribute("alto","22" );
      ((Element)v.get(688)).setAttribute("imgFondo","" );
      ((Element)v.get(688)).setAttribute("cod","0057" );
      ((Element)v.get(688)).setAttribute("ID","datosTitle" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */

      /* Empieza nodo:689 / Elemento padre: 687   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(689)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(689)).setAttribute("alto","22" );
      ((Element)v.get(689)).setAttribute("imgFondo","" );
      ((Element)v.get(687)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */

      /* Empieza nodo:690 / Elemento padre: 687   */
      v.add(doc.createElement("IMGBOTONES"));
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(690)).setAttribute("precarga","S" );
      ((Element)v.get(690)).setAttribute("conROver","S" );
      ((Element)v.get(687)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(691)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(691)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(691)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(691)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(690)).appendChild((Element)v.get(691));
      /* Termina nodo:691   */

      /* Empieza nodo:692 / Elemento padre: 690   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(692)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(692)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(692)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(692)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(690)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */

      /* Empieza nodo:693 / Elemento padre: 690   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(693)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(693)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(690)).appendChild((Element)v.get(693));
      /* Termina nodo:693   */
      /* Termina nodo:690   */

      /* Empieza nodo:694 / Elemento padre: 687   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(687)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(695)).setAttribute("borde","1" );
      ((Element)v.get(695)).setAttribute("horizDatos","1" );
      ((Element)v.get(695)).setAttribute("horizCabecera","1" );
      ((Element)v.get(695)).setAttribute("vertical","1" );
      ((Element)v.get(695)).setAttribute("horizTitulo","1" );
      ((Element)v.get(695)).setAttribute("horizBase","1" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */

      /* Empieza nodo:696 / Elemento padre: 694   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(696)).setAttribute("borde","#999999" );
      ((Element)v.get(696)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(696)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(696)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(696)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(696)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(696)).setAttribute("horizBase","#999999" );
      ((Element)v.get(694)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:694   */

      /* Empieza nodo:697 / Elemento padre: 687   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(697)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(697)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(697)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(697)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(697)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(697)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(687)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(698)).setAttribute("ancho","98" );
      ((Element)v.get(698)).setAttribute("minimizable","S" );
      ((Element)v.get(698)).setAttribute("minimizada","N" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));
      /* Termina nodo:698   */

      /* Empieza nodo:699 / Elemento padre: 697   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(699)).setAttribute("ancho","68" );
      ((Element)v.get(699)).setAttribute("minimizable","S" );
      ((Element)v.get(699)).setAttribute("minimizada","N" );
      ((Element)v.get(697)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */

      /* Empieza nodo:700 / Elemento padre: 697   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(700)).setAttribute("ancho","73" );
      ((Element)v.get(700)).setAttribute("minimizable","S" );
      ((Element)v.get(700)).setAttribute("minimizada","N" );
      ((Element)v.get(697)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */

      /* Empieza nodo:701 / Elemento padre: 697   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(701)).setAttribute("ancho","73" );
      ((Element)v.get(701)).setAttribute("minimizable","S" );
      ((Element)v.get(701)).setAttribute("minimizada","N" );
      ((Element)v.get(697)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */

      /* Empieza nodo:702 / Elemento padre: 697   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(702)).setAttribute("ancho","89" );
      ((Element)v.get(702)).setAttribute("minimizable","S" );
      ((Element)v.get(702)).setAttribute("minimizada","N" );
      ((Element)v.get(697)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:697   */

      /* Empieza nodo:703 / Elemento padre: 687   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(703)).setAttribute("alto","20" );
      ((Element)v.get(703)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(703)).setAttribute("imgFondo","" );
      ((Element)v.get(703)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(687)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(704)).setAttribute("colFondo","" );
      ((Element)v.get(704)).setAttribute("ID","EstCab" );
      ((Element)v.get(704)).setAttribute("align","center" );
      ((Element)v.get(704)).setAttribute("cod","1058" );
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */

      /* Empieza nodo:705 / Elemento padre: 703   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(705)).setAttribute("colFondo","" );
      ((Element)v.get(705)).setAttribute("ID","EstCab" );
      ((Element)v.get(705)).setAttribute("align","center" );
      ((Element)v.get(705)).setAttribute("cod","1131" );
      ((Element)v.get(703)).appendChild((Element)v.get(705));
      /* Termina nodo:705   */

      /* Empieza nodo:706 / Elemento padre: 703   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(706)).setAttribute("colFondo","" );
      ((Element)v.get(706)).setAttribute("ID","EstCab" );
      ((Element)v.get(706)).setAttribute("align","center" );
      ((Element)v.get(706)).setAttribute("cod","59" );
      ((Element)v.get(703)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */

      /* Empieza nodo:707 / Elemento padre: 703   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(707)).setAttribute("colFondo","" );
      ((Element)v.get(707)).setAttribute("ID","EstCab" );
      ((Element)v.get(707)).setAttribute("align","center" );
      ((Element)v.get(707)).setAttribute("cod","1339" );
      ((Element)v.get(703)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */

      /* Empieza nodo:708 / Elemento padre: 703   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(708)).setAttribute("colFondo","" );
      ((Element)v.get(708)).setAttribute("ID","EstCab" );
      ((Element)v.get(708)).setAttribute("align","center" );
      ((Element)v.get(708)).setAttribute("cod","1139" );
      ((Element)v.get(703)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */
      /* Termina nodo:703   */

      /* Empieza nodo:709 / Elemento padre: 687   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(709)).setAttribute("alto","22" );
      ((Element)v.get(709)).setAttribute("accion","" );
      ((Element)v.get(709)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(709)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(709)).setAttribute("maxSel","-1" );
      ((Element)v.get(709)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(709)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(709)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(709)).setAttribute("onLoad","" );
      ((Element)v.get(709)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(687)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(710)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(710)).setAttribute("nombre","TextoClienteVinculo" );
      ((Element)v.get(710)).setAttribute("size","19" );
      ((Element)v.get(710)).setAttribute("max","15" );
      ((Element)v.get(710)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(710)).setAttribute("onchange","clienteVinculoOnBlur(this);" );
      ((Element)v.get(710)).setAttribute("ID","EstDat2" );
      ((Element)v.get(709)).appendChild((Element)v.get(710));
      /* Termina nodo:710   */

      /* Empieza nodo:711 / Elemento padre: 709   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(711)).setAttribute("tipo","combo" );
      ((Element)v.get(711)).setAttribute("nombre","comboTipoVinculo" );
      ((Element)v.get(711)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(711)).setAttribute("ID","EstDat" );
      ((Element)v.get(711)).setAttribute("req","S" );
      ((Element)v.get(711)).setAttribute("size","1" );
      ((Element)v.get(711)).setAttribute("multiple","N" );
      ((Element)v.get(709)).appendChild((Element)v.get(711));

      /* Empieza nodo:712 / Elemento padre: 711   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(711)).appendChild((Element)v.get(712));
      /* Termina nodo:712   */
      /* Termina nodo:711   */

      /* Empieza nodo:713 / Elemento padre: 709   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(713)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(713)).setAttribute("nombre","TextoFechaDesde" );
      ((Element)v.get(713)).setAttribute("size","12" );
      ((Element)v.get(713)).setAttribute("max","10" );
      ((Element)v.get(713)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(713)).setAttribute("ID","EstDat2" );
      ((Element)v.get(709)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */

      /* Empieza nodo:714 / Elemento padre: 709   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(714)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(714)).setAttribute("nombre","TextoFechaHasta" );
      ((Element)v.get(714)).setAttribute("size","12" );
      ((Element)v.get(714)).setAttribute("max","10" );
      ((Element)v.get(714)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(714)).setAttribute("ID","EstDat" );
      ((Element)v.get(709)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */

      /* Empieza nodo:715 / Elemento padre: 709   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(715)).setAttribute("tipo","checkbox" );
      ((Element)v.get(715)).setAttribute("nombre","CKVinculoPrincipal" );
      ((Element)v.get(715)).setAttribute("ID","EstDat2" );
      ((Element)v.get(709)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */
      /* Termina nodo:709   */

      /* Empieza nodo:716 / Elemento padre: 687   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(687)).appendChild((Element)v.get(716));
      /* Termina nodo:716   */

      /* Empieza nodo:717 / Elemento padre: 687   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(717)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(717)).setAttribute("ancho","731" );
      ((Element)v.get(717)).setAttribute("sep","$" );
      ((Element)v.get(717)).setAttribute("x","12" );
      ((Element)v.get(717)).setAttribute("class","botonera" );
      ((Element)v.get(717)).setAttribute("y","719" );
      ((Element)v.get(717)).setAttribute("control","|" );
      ((Element)v.get(717)).setAttribute("conector","" );
      ((Element)v.get(717)).setAttribute("rowset","" );
      ((Element)v.get(717)).setAttribute("cargainicial","N" );
      ((Element)v.get(687)).appendChild((Element)v.get(717));
      /* Termina nodo:717   */
      /* Termina nodo:687   */

      /* Empieza nodo:718 / Elemento padre: 30   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(718)).setAttribute("nombre","masDatos1" );
      ((Element)v.get(718)).setAttribute("x","13" );
      ((Element)v.get(718)).setAttribute("y","720" );
      ((Element)v.get(718)).setAttribute("ID","botonContenido" );
      ((Element)v.get(718)).setAttribute("tipo","html" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(718)).setAttribute("accion","agregarFila('listado1', '');" );
      ((Element)v.get(718)).setAttribute("estado","false" );
      ((Element)v.get(718)).setAttribute("cod","404" );
      ((Element)v.get(30)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */

      /* Empieza nodo:719 / Elemento padre: 30   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(719)).setAttribute("nombre","Eliminar1" );
      ((Element)v.get(719)).setAttribute("x","61" );
      ((Element)v.get(719)).setAttribute("y","720" );
      ((Element)v.get(719)).setAttribute("ID","botonContenido" );
      ((Element)v.get(719)).setAttribute("tipo","html" );
      ((Element)v.get(719)).setAttribute("estado","false" );
      ((Element)v.get(719)).setAttribute("cod","1254" );
      ((Element)v.get(719)).setAttribute("accion","eliminarSelecc('listado1');" );
      ((Element)v.get(30)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */

      /* Empieza nodo:720 / Elemento padre: 30   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(720)).setAttribute("nombre","BuscarCliente" );
      ((Element)v.get(720)).setAttribute("x","115" );
      ((Element)v.get(720)).setAttribute("y","720" );
      ((Element)v.get(720)).setAttribute("ID","botonContenido" );
      ((Element)v.get(720)).setAttribute("tipo","html" );
      ((Element)v.get(720)).setAttribute("estado","false" );
      ((Element)v.get(720)).setAttribute("cod","0128" );
      ((Element)v.get(720)).setAttribute("accion","buscarClienteVinculo();" );
      ((Element)v.get(30)).appendChild((Element)v.get(720));
      /* Termina nodo:720   */

      /* Empieza nodo:721 / Elemento padre: 30   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(721)).setAttribute("nombre","listado2" );
      ((Element)v.get(721)).setAttribute("ancho","731" );
      ((Element)v.get(721)).setAttribute("alto","162" );
      ((Element)v.get(721)).setAttribute("x","12" );
      ((Element)v.get(721)).setAttribute("y","765" );
      ((Element)v.get(721)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(721)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(722)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(722)).setAttribute("alto","22" );
      ((Element)v.get(722)).setAttribute("imgFondo","" );
      ((Element)v.get(722)).setAttribute("cod","0055" );
      ((Element)v.get(722)).setAttribute("ID","datosTitle" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */

      /* Empieza nodo:723 / Elemento padre: 721   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(723)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(723)).setAttribute("alto","22" );
      ((Element)v.get(723)).setAttribute("imgFondo","" );
      ((Element)v.get(721)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */

      /* Empieza nodo:724 / Elemento padre: 721   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(724)).setAttribute("precarga","S" );
      ((Element)v.get(724)).setAttribute("conROver","S" );
      ((Element)v.get(721)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(725)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(725)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(725)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(725)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */

      /* Empieza nodo:726 / Elemento padre: 724   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(726)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(726)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(726)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(726)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(724)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */

      /* Empieza nodo:727 / Elemento padre: 724   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(727)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(727)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(724)).appendChild((Element)v.get(727));
      /* Termina nodo:727   */
      /* Termina nodo:724   */

      /* Empieza nodo:728 / Elemento padre: 721   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(721)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(729)).setAttribute("borde","1" );
      ((Element)v.get(729)).setAttribute("horizDatos","1" );
      ((Element)v.get(729)).setAttribute("horizCabecera","1" );
      ((Element)v.get(729)).setAttribute("vertical","1" );
      ((Element)v.get(729)).setAttribute("horizTitulo","1" );
      ((Element)v.get(729)).setAttribute("horizBase","1" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));
      /* Termina nodo:729   */

      /* Empieza nodo:730 / Elemento padre: 728   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(730)).setAttribute("borde","#999999" );
      ((Element)v.get(730)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(730)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(730)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(730)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(730)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(730)).setAttribute("horizBase","#999999" );
      ((Element)v.get(728)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */
      /* Termina nodo:728   */

      /* Empieza nodo:731 / Elemento padre: 721   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(731)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(731)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(731)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(731)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(731)).setAttribute("AnchoMinimizadas","20" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(731)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(721)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(732)).setAttribute("ancho","105" );
      ((Element)v.get(732)).setAttribute("minimizable","S" );
      ((Element)v.get(732)).setAttribute("minimizada","N" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */

      /* Empieza nodo:733 / Elemento padre: 731   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(733)).setAttribute("ancho","400" );
      ((Element)v.get(733)).setAttribute("minimizable","S" );
      ((Element)v.get(733)).setAttribute("minimizada","N" );
      ((Element)v.get(731)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */
      /* Termina nodo:731   */

      /* Empieza nodo:734 / Elemento padre: 721   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(734)).setAttribute("alto","20" );
      ((Element)v.get(734)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(734)).setAttribute("imgFondo","" );
      ((Element)v.get(734)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(721)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(735)).setAttribute("colFondo","" );
      ((Element)v.get(735)).setAttribute("ID","EstCab" );
      ((Element)v.get(735)).setAttribute("align","center" );
      ((Element)v.get(735)).setAttribute("cod","1127" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */

      /* Empieza nodo:736 / Elemento padre: 734   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(736)).setAttribute("colFondo","" );
      ((Element)v.get(736)).setAttribute("ID","EstCab" );
      ((Element)v.get(736)).setAttribute("align","center" );
      ((Element)v.get(736)).setAttribute("cod","9" );
      ((Element)v.get(734)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */
      /* Termina nodo:734   */

      /* Empieza nodo:737 / Elemento padre: 721   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(737)).setAttribute("alto","22" );
      ((Element)v.get(737)).setAttribute("accion","" );
      ((Element)v.get(737)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(737)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(737)).setAttribute("maxSel","-1" );
      ((Element)v.get(737)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(737)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(737)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(737)).setAttribute("onLoad","" );
      ((Element)v.get(737)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(721)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(738)).setAttribute("tipo","combo" );
      ((Element)v.get(738)).setAttribute("nombre","comboTipoPreferencia" );
      ((Element)v.get(738)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(738)).setAttribute("ID","EstDat" );
      ((Element)v.get(738)).setAttribute("req","S" );
      ((Element)v.get(738)).setAttribute("size","1" );
      ((Element)v.get(738)).setAttribute("multiple","N" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(738)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(740)).setAttribute("ID","1" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));

      /* Empieza nodo:741 / Elemento padre: 740   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(741)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(741)).setAttribute("TIPO","STRING" );
      ((Element)v.get(740)).appendChild((Element)v.get(741));

      /* Elemento padre:741 / Elemento actual: 742   */
      v.add(doc.createTextNode("S"));
      ((Element)v.get(741)).appendChild((Text)v.get(742));

      /* Termina nodo Texto:742   */
      /* Termina nodo:741   */

      /* Empieza nodo:743 / Elemento padre: 740   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(743)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(743)).setAttribute("TIPO","STRING" );
      ((Element)v.get(743)).setAttribute("VALOR","xxx" );
      ((Element)v.get(740)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */
      /* Termina nodo:740   */
      /* Termina nodo:739   */
      /* Termina nodo:738   */

      /* Empieza nodo:744 / Elemento padre: 737   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(744)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(744)).setAttribute("nombre","TextoDescripcion" );
      ((Element)v.get(744)).setAttribute("size","40" );
      ((Element)v.get(744)).setAttribute("max","40" );
      ((Element)v.get(744)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(744)).setAttribute("req","N" );
      ((Element)v.get(744)).setAttribute("ID","EstDat2" );
      ((Element)v.get(737)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */
      /* Termina nodo:737   */

      /* Empieza nodo:745 / Elemento padre: 721   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(721)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */

      /* Empieza nodo:746 / Elemento padre: 721   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(746)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(746)).setAttribute("ancho","731" );
      ((Element)v.get(746)).setAttribute("sep","$" );
      ((Element)v.get(746)).setAttribute("x","12" );
      ((Element)v.get(746)).setAttribute("class","botonera" );
      ((Element)v.get(746)).setAttribute("y","904" );
      ((Element)v.get(746)).setAttribute("control","|" );
      ((Element)v.get(746)).setAttribute("conector","" );
      ((Element)v.get(746)).setAttribute("rowset","" );
      ((Element)v.get(746)).setAttribute("cargainicial","N" );
      ((Element)v.get(721)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */
      /* Termina nodo:721   */

      /* Empieza nodo:747 / Elemento padre: 30   */
   }

   private void getXML3240(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(747)).setAttribute("nombre","masDatos2" );
      ((Element)v.get(747)).setAttribute("x","13" );
      ((Element)v.get(747)).setAttribute("y","905" );
      ((Element)v.get(747)).setAttribute("accion","agregarFila('listado2', '');" );
      ((Element)v.get(747)).setAttribute("ID","botonContenido" );
      ((Element)v.get(747)).setAttribute("tipo","html" );
      ((Element)v.get(747)).setAttribute("estado","false" );
      ((Element)v.get(747)).setAttribute("cod","404" );
      ((Element)v.get(30)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */

      /* Empieza nodo:748 / Elemento padre: 30   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(748)).setAttribute("nombre","Eliminar2" );
      ((Element)v.get(748)).setAttribute("x","61" );
      ((Element)v.get(748)).setAttribute("y","905" );
      ((Element)v.get(748)).setAttribute("ID","botonContenido" );
      ((Element)v.get(748)).setAttribute("tipo","html" );
      ((Element)v.get(748)).setAttribute("estado","false" );
      ((Element)v.get(748)).setAttribute("cod","1254" );
      ((Element)v.get(748)).setAttribute("accion","eliminarSelecc('listado2');" );
      ((Element)v.get(30)).appendChild((Element)v.get(748));
      /* Termina nodo:748   */

      /* Empieza nodo:749 / Elemento padre: 30   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(749)).setAttribute("nombre","listado3" );
      ((Element)v.get(749)).setAttribute("ancho","731" );
      ((Element)v.get(749)).setAttribute("alto","300" );
      ((Element)v.get(749)).setAttribute("x","12" );
      ((Element)v.get(749)).setAttribute("y","951" );
      ((Element)v.get(749)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(749)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(749));

      /* Empieza nodo:750 / Elemento padre: 749   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(750)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(750)).setAttribute("alto","22" );
      ((Element)v.get(750)).setAttribute("imgFondo","" );
      ((Element)v.get(750)).setAttribute("cod","0054" );
      ((Element)v.get(750)).setAttribute("ID","datosTitle" );
      ((Element)v.get(749)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */

      /* Empieza nodo:751 / Elemento padre: 749   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(751)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(751)).setAttribute("alto","22" );
      ((Element)v.get(751)).setAttribute("imgFondo","" );
      ((Element)v.get(749)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */

      /* Empieza nodo:752 / Elemento padre: 749   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(752)).setAttribute("precarga","S" );
      ((Element)v.get(752)).setAttribute("conROver","S" );
      ((Element)v.get(749)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(753)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(753)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(753)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(753)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(752)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */

      /* Empieza nodo:754 / Elemento padre: 752   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(754)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(754)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(754)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(754)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(752)).appendChild((Element)v.get(754));
      /* Termina nodo:754   */

      /* Empieza nodo:755 / Elemento padre: 752   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(755)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(755)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(752)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:752   */

      /* Empieza nodo:756 / Elemento padre: 749   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(749)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(757)).setAttribute("borde","1" );
      ((Element)v.get(757)).setAttribute("horizDatos","1" );
      ((Element)v.get(757)).setAttribute("horizCabecera","1" );
      ((Element)v.get(757)).setAttribute("vertical","1" );
      ((Element)v.get(757)).setAttribute("horizTitulo","1" );
      ((Element)v.get(757)).setAttribute("horizBase","1" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */

      /* Empieza nodo:758 / Elemento padre: 756   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(758)).setAttribute("borde","#999999" );
      ((Element)v.get(758)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(758)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(758)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(758)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(758)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(758)).setAttribute("horizBase","#999999" );
      ((Element)v.get(756)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */
      /* Termina nodo:756   */

      /* Empieza nodo:759 / Elemento padre: 749   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(759)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(759)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(759)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(759)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(759)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(759)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(749)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(760)).setAttribute("ancho","212" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(760)).setAttribute("minimizable","S" );
      ((Element)v.get(760)).setAttribute("minimizada","N" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */

      /* Empieza nodo:761 / Elemento padre: 759   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(761)).setAttribute("ancho","92" );
      ((Element)v.get(761)).setAttribute("minimizable","S" );
      ((Element)v.get(761)).setAttribute("minimizada","N" );
      ((Element)v.get(759)).appendChild((Element)v.get(761));
      /* Termina nodo:761   */

      /* Empieza nodo:762 / Elemento padre: 759   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(762)).setAttribute("ancho","402" );
      ((Element)v.get(762)).setAttribute("minimizable","S" );
      ((Element)v.get(762)).setAttribute("minimizada","N" );
      ((Element)v.get(759)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:759   */

      /* Empieza nodo:763 / Elemento padre: 749   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(763)).setAttribute("alto","20" );
      ((Element)v.get(763)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(763)).setAttribute("imgFondo","" );
      ((Element)v.get(763)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(749)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(764)).setAttribute("colFondo","" );
      ((Element)v.get(764)).setAttribute("ID","EstCab" );
      ((Element)v.get(764)).setAttribute("align","center" );
      ((Element)v.get(764)).setAttribute("cod","6" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */

      /* Empieza nodo:765 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(765)).setAttribute("colFondo","" );
      ((Element)v.get(765)).setAttribute("ID","EstCab" );
      ((Element)v.get(765)).setAttribute("align","center" );
      ((Element)v.get(765)).setAttribute("cod","1340" );
      ((Element)v.get(763)).appendChild((Element)v.get(765));
      /* Termina nodo:765   */

      /* Empieza nodo:766 / Elemento padre: 763   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(766)).setAttribute("colFondo","" );
      ((Element)v.get(766)).setAttribute("ID","EstCab" );
      ((Element)v.get(766)).setAttribute("align","center" );
      ((Element)v.get(766)).setAttribute("cod","487" );
      ((Element)v.get(763)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */
      /* Termina nodo:763   */

      /* Empieza nodo:767 / Elemento padre: 749   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(767)).setAttribute("alto","22" );
      ((Element)v.get(767)).setAttribute("accion","" );
      ((Element)v.get(767)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(767)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(767)).setAttribute("maxSel","-1" );
      ((Element)v.get(767)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(767)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(767)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(767)).setAttribute("onLoad","" );
      ((Element)v.get(767)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(749)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(768)).setAttribute("tipo","combo" );
      ((Element)v.get(768)).setAttribute("nombre","comboMarca" );
      ((Element)v.get(768)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(768)).setAttribute("ID","EstDat" );
      ((Element)v.get(768)).setAttribute("req","S" );
      ((Element)v.get(768)).setAttribute("size","1" );
      ((Element)v.get(768)).setAttribute("multiple","N" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(768)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */
      /* Termina nodo:768   */

      /* Empieza nodo:770 / Elemento padre: 767   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(770)).setAttribute("tipo","texto" );
      ((Element)v.get(770)).setAttribute("nombre","textoNumero" );
      ((Element)v.get(770)).setAttribute("ID","EstDat2" );
      ((Element)v.get(767)).appendChild((Element)v.get(770));
      /* Termina nodo:770   */

      /* Empieza nodo:771 / Elemento padre: 767   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(767)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */

      /* Empieza nodo:772 / Elemento padre: 767   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(772)).setAttribute("tipo","areatexto" );
      ((Element)v.get(772)).setAttribute("nombre","AreaTxtTexto" );
      ((Element)v.get(772)).setAttribute("ID","EstDat2" );
      ((Element)v.get(772)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(772)).setAttribute("rows","3" );
      ((Element)v.get(772)).setAttribute("cols","45" );
      ((Element)v.get(772)).setAttribute("validacion","" );
      ((Element)v.get(772)).setAttribute("req","S" );
      ((Element)v.get(772)).setAttribute("max","200" );
      ((Element)v.get(767)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */
      /* Termina nodo:767   */

      /* Empieza nodo:773 / Elemento padre: 749   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(749)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */

      /* Empieza nodo:774 / Elemento padre: 749   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(774)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(774)).setAttribute("ancho","731" );
      ((Element)v.get(774)).setAttribute("sep","$" );
      ((Element)v.get(774)).setAttribute("x","12" );
      ((Element)v.get(774)).setAttribute("class","botonera" );
      ((Element)v.get(774)).setAttribute("y","1228" );
      ((Element)v.get(774)).setAttribute("control","|" );
      ((Element)v.get(774)).setAttribute("conector","" );
      ((Element)v.get(774)).setAttribute("rowset","" );
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(774)).setAttribute("cargainicial","N" );
      ((Element)v.get(749)).appendChild((Element)v.get(774));
      /* Termina nodo:774   */
      /* Termina nodo:749   */

      /* Empieza nodo:775 / Elemento padre: 30   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(775)).setAttribute("nombre","masDatos3" );
      ((Element)v.get(775)).setAttribute("x","13" );
      ((Element)v.get(775)).setAttribute("accion","agregarFila('listado3','');" );
      ((Element)v.get(775)).setAttribute("y","1229" );
      ((Element)v.get(775)).setAttribute("ID","botonContenido" );
      ((Element)v.get(775)).setAttribute("tipo","html" );
      ((Element)v.get(775)).setAttribute("estado","false" );
      ((Element)v.get(775)).setAttribute("cod","404" );
      ((Element)v.get(30)).appendChild((Element)v.get(775));
      /* Termina nodo:775   */

      /* Empieza nodo:776 / Elemento padre: 30   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(776)).setAttribute("nombre","Eliminar3" );
      ((Element)v.get(776)).setAttribute("x","61" );
      ((Element)v.get(776)).setAttribute("y","1229" );
      ((Element)v.get(776)).setAttribute("ID","botonContenido" );
      ((Element)v.get(776)).setAttribute("tipo","html" );
      ((Element)v.get(776)).setAttribute("estado","false" );
      ((Element)v.get(776)).setAttribute("cod","1254" );
      ((Element)v.get(776)).setAttribute("accion","eliminarSelecc('listado3');" );
      ((Element)v.get(776)).setAttribute("ontab","focalizaBotonHTML('botonContenido', 'btnSiguiente' );" );
      ((Element)v.get(30)).appendChild((Element)v.get(776));
      /* Termina nodo:776   */

      /* Empieza nodo:777 / Elemento padre: 30   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(777)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(777)).setAttribute("x","0" );
      ((Element)v.get(777)).setAttribute("y","1252" );
      ((Element)v.get(30)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("table"));
      ((Element)v.get(778)).setAttribute("width","100%" );
      ((Element)v.get(778)).setAttribute("border","0" );
      ((Element)v.get(778)).setAttribute("cellspacing","0" );
      ((Element)v.get(778)).setAttribute("cellpadding","0" );
      ((Element)v.get(777)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(778)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("td"));
      ((Element)v.get(779)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(781)).setAttribute("src","b.gif" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));
      /* Termina nodo:781   */
      /* Termina nodo:780   */

      /* Empieza nodo:782 / Elemento padre: 779   */
      v.add(doc.createElement("td"));
      ((Element)v.get(779)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("table"));
      ((Element)v.get(783)).setAttribute("width","100%" );
      ((Element)v.get(783)).setAttribute("border","0" );
      ((Element)v.get(783)).setAttribute("align","center" );
      ((Element)v.get(783)).setAttribute("cellspacing","0" );
      ((Element)v.get(783)).setAttribute("cellpadding","0" );
      ((Element)v.get(782)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(783)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("td"));
      ((Element)v.get(784)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("table"));
      ((Element)v.get(786)).setAttribute("width","732" );
      ((Element)v.get(786)).setAttribute("border","0" );
      ((Element)v.get(786)).setAttribute("align","left" );
      ((Element)v.get(786)).setAttribute("cellspacing","0" );
      ((Element)v.get(786)).setAttribute("cellpadding","0" );
      ((Element)v.get(785)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(786)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(787)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(789)).setAttribute("src","b.gif" );
      ((Element)v.get(788)).appendChild((Element)v.get(789));
      /* Termina nodo:789   */
      /* Termina nodo:788   */
      /* Termina nodo:787   */
      /* Termina nodo:786   */
      /* Termina nodo:785   */
      /* Termina nodo:784   */
      /* Termina nodo:783   */
      /* Termina nodo:782   */

      /* Empieza nodo:790 / Elemento padre: 779   */
      v.add(doc.createElement("td"));
      ((Element)v.get(779)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(791)).setAttribute("src","b.gif" );
      ((Element)v.get(790)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */
      /* Termina nodo:790   */
      /* Termina nodo:779   */

      /* Empieza nodo:792 / Elemento padre: 778   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(778)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("td"));
      ((Element)v.get(792)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(794)).setAttribute("src","b.gif" );
      ((Element)v.get(793)).appendChild((Element)v.get(794));
      /* Termina nodo:794   */
      /* Termina nodo:793   */

      /* Empieza nodo:795 / Elemento padre: 792   */
      v.add(doc.createElement("td"));
      ((Element)v.get(792)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(795)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("table"));
      ((Element)v.get(797)).setAttribute("width","100%" );
      ((Element)v.get(797)).setAttribute("border","0" );
      ((Element)v.get(797)).setAttribute("align","center" );
      ((Element)v.get(797)).setAttribute("cellspacing","0" );
      ((Element)v.get(797)).setAttribute("cellpadding","0" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(796)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(797)).appendChild((Element)v.get(798));

      /* Empieza nodo:799 / Elemento padre: 798   */
      v.add(doc.createElement("td"));
      ((Element)v.get(799)).setAttribute("align","right" );
      ((Element)v.get(799)).setAttribute("class","botonera" );
      ((Element)v.get(799)).setAttribute("width","100%" );
      ((Element)v.get(798)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(800)).setAttribute("nombre","btnAnterior" );
      ((Element)v.get(800)).setAttribute("ID","botonContenido" );
      ((Element)v.get(800)).setAttribute("tipo","html" );
      ((Element)v.get(800)).setAttribute("accion","javascript:accionInsertarP1();" );
      ((Element)v.get(800)).setAttribute("onshtab","accionInsertarP1();" );
      ((Element)v.get(800)).setAttribute("ontab","ontabBotonAnterior();" );
      ((Element)v.get(800)).setAttribute("estado","false" );
      ((Element)v.get(800)).setAttribute("cod","1649" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));
      /* Termina nodo:800   */

      /* Empieza nodo:801 / Elemento padre: 799   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(801)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(801)).setAttribute("ID","botonContenido" );
      ((Element)v.get(801)).setAttribute("tipo","html" );
      ((Element)v.get(801)).setAttribute("accion","javascript:nuevaAccionInsertarP3();" );
      ((Element)v.get(801)).setAttribute("onshtab","focalizaBotonHTML('botonContenido', 'Eliminar3' );" );
      ((Element)v.get(801)).setAttribute("ontab","nuevaAccionInsertarP3();" );
      ((Element)v.get(801)).setAttribute("estado","false" );
      ((Element)v.get(801)).setAttribute("cod","446" );
      ((Element)v.get(799)).appendChild((Element)v.get(801));
      /* Termina nodo:801   */
      /* Termina nodo:799   */
      /* Termina nodo:798   */
      /* Termina nodo:797   */
      /* Termina nodo:796   */
      /* Termina nodo:795   */

      /* Empieza nodo:802 / Elemento padre: 792   */
      v.add(doc.createElement("td"));
      ((Element)v.get(792)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(803)).setAttribute("src","b.gif" );
      ((Element)v.get(803)).setAttribute("width","12" );
      ((Element)v.get(803)).setAttribute("height","12" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));
      /* Termina nodo:803   */
      /* Termina nodo:802   */
      /* Termina nodo:792   */

      /* Empieza nodo:804 / Elemento padre: 778   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(778)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).setAttribute("width","12" );
      ((Element)v.get(805)).setAttribute("align","center" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(806)).setAttribute("src","b.gif" );
      ((Element)v.get(806)).setAttribute("width","12" );
      ((Element)v.get(806)).setAttribute("height","12" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));
      /* Termina nodo:806   */
      /* Termina nodo:805   */

      /* Empieza nodo:807 / Elemento padre: 804   */
      v.add(doc.createElement("td"));
      ((Element)v.get(807)).setAttribute("width","756" );
      ((Element)v.get(804)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(808)).setAttribute("src","b.gif" );
      ((Element)v.get(807)).appendChild((Element)v.get(808));
      /* Termina nodo:808   */
      /* Termina nodo:807   */

      /* Empieza nodo:809 / Elemento padre: 804   */
      v.add(doc.createElement("td"));
      ((Element)v.get(809)).setAttribute("width","12" );
      ((Element)v.get(804)).appendChild((Element)v.get(809));

      /* Empieza nodo:810 / Elemento padre: 809   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(810)).setAttribute("src","b.gif" );
      ((Element)v.get(810)).setAttribute("width","12" );
      ((Element)v.get(810)).setAttribute("height","1" );
      ((Element)v.get(809)).appendChild((Element)v.get(810));
      /* Termina nodo:810   */
      /* Termina nodo:809   */
      /* Termina nodo:804   */
      /* Termina nodo:778   */
      /* Termina nodo:777   */
      /* Termina nodo:30   */


   }

}
