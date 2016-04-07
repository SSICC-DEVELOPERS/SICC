
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_consultoras_ranking_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_consultoras_ranking_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0699" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","PaginacionSicc.js" );
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
      ((Element)v.get(4)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","pestanyas_concurso_ranking_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","contenido_parametros_consultoras_ranking_mantener.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbBaseCalculo" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1181" );
      ((Element)v.get(9)).setAttribute("group","datosAdicionalesObligatorios" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","formulario" );
      ((Element)v.get(10)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidLstMVR" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hIndEstadoParametrosGerentes" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hIndEstadoParametrosConsultoras" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hIndEstadoVariablesVenta" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidIngresoEVTA" );
      ((Element)v.get(22)).setAttribute("valor","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidIngresoPAR" );
      ((Element)v.get(23)).setAttribute("valor","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidIndConsultoras" );
      ((Element)v.get(24)).setAttribute("valor","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidLstEstatusVta" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidLstClasConsul" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidListaClasif" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidTipoVenta" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidBaseCalculo" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","oidPerDesde" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","oidPerHasta" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","oidPlantillaBaseCalculo" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","ocultaParticipante" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","lstClasificacionParticipantes" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","lstClasificacionParticipantesConsultoras" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidParamConsultoras" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidParamConsultoras" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","oidBC_Recomendada" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","oidBC_Calculo_Monto" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("height","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("class","menu4" );
      ((Element)v.get(10)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(42)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","30" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(44)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Elemento padre:44 / Elemento actual: 45   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(44)).appendChild((Text)v.get(45));

      /* Termina nodo Texto:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","10" );
      ((Element)v.get(46)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(46)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","10" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","92" );
      ((Element)v.get(48)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","75" );
      ((Element)v.get(49)).setAttribute("border","1" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellpadding","1" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(49)).setAttribute("onmouseover","activarPuntero('formulario',1,'lblDatosGenerales');" );
      ((Element)v.get(49)).setAttribute("onclick","onClickPestanyaHabilitada(1, 'formulario', 'LPMantenerParametrosConsultorasRanking');" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(52)).setAttribute("cod","0011" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:53 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","10" );
      ((Element)v.get(53)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","10" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","20" );
      ((Element)v.get(55)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","75" );
      ((Element)v.get(56)).setAttribute("border","1" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(56)).setAttribute("cellpadding","1" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(56)).setAttribute("onmouseover","activarPuntero('formulario',2,'lblAlcanceGeografico');" );
      ((Element)v.get(56)).setAttribute("onclick","onClickPestanyaHabilitada(2, 'formulario', 'LPMantenerParametrosConsultorasRanking');" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblAlcanceGeografico" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(59)).setAttribute("cod","00368" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:60 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","10" );
      ((Element)v.get(60)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(61)).setAttribute("width","10" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","20" );
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("width","75" );
      ((Element)v.get(63)).setAttribute("border","1" );
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(63)).setAttribute("cellpadding","1" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(63)).setAttribute("onmouseover","activarPuntero('formulario',3,'lblParametrosGerentes');" );
      ((Element)v.get(63)).setAttribute("onclick","onClickPestanyaHabilitada(3, 'formulario', 'LPMantenerParametrosConsultorasRanking');" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblParametrosGerentes" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(66)).setAttribute("cod","00594" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:67 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","10" );
      ((Element)v.get(67)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","10" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","20" );
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","75" );
      ((Element)v.get(70)).setAttribute("border","1" );
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(70)).setAttribute("cellpadding","1" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
      ((Element)v.get(70)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(70)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(70)).setAttribute("onmouseover","activarPuntero('formulario',4,'lblParametrosConsultoras');" );
      ((Element)v.get(70)).setAttribute("onclick","onClickPestanyaHabilitada(4, 'formulario', 'LPMantenerParametrosConsultorasRanking');" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblParametrosConsultoras" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(73)).setAttribute("cod","00595" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:74 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","16" );
      ((Element)v.get(74)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:76 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(76)).setAttribute("height","100%" );
      ((Element)v.get(76)).setAttribute("border","0" );
      ((Element)v.get(76)).setAttribute("align","center" );
      ((Element)v.get(76)).setAttribute("cellpadding","0" );
      ((Element)v.get(76)).setAttribute("cellspacing","0" );
      ((Element)v.get(76)).setAttribute("class","menu4" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(10)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(78)).setAttribute("class","menu5texto" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","30" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).setAttribute("class","menu5texto" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Elemento padre:80 / Elemento actual: 81   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(80)).appendChild((Text)v.get(81));

      /* Termina nodo Texto:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","10" );
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).setAttribute("class","menu5texto" );
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","10" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","20" );
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).setAttribute("class","menu5texto" );
      ((Element)v.get(77)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("table"));
      ((Element)v.get(85)).setAttribute("width","75" );
      ((Element)v.get(85)).setAttribute("border","1" );
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(85)).setAttribute("cellpadding","1" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(85)).setAttribute("onmouseover","activarPuntero('formulario',5,'lblProductos');" );
      ((Element)v.get(85)).setAttribute("onclick","onClickPestanyaHabilitada(5, 'formulario', 'LPMantenerParametrosConsultorasRanking');" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(86)).setAttribute("align","center" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(88)).setAttribute("cod","0094" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:89 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","10" );
      ((Element)v.get(89)).setAttribute("class","menu5texto" );
      ((Element)v.get(77)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","10" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","20" );
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).setAttribute("class","menu5texto" );
      ((Element)v.get(77)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("table"));
      ((Element)v.get(92)).setAttribute("width","75" );
      ((Element)v.get(92)).setAttribute("border","1" );
      ((Element)v.get(92)).setAttribute("align","center" );
      ((Element)v.get(92)).setAttribute("cellpadding","1" );
      ((Element)v.get(92)).setAttribute("cellspacing","0" );
      ((Element)v.get(92)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(92)).setAttribute("onmouseover","activarPuntero('formulario', 6, 'lblPremios');" );
      ((Element)v.get(92)).setAttribute("onclick","onClickPestanyaHabilitada(6, 'formulario', 'LPMantenerParametrosConsultorasRanking');" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).setAttribute("align","center" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(95)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(95)).setAttribute("alto","13" );
      ((Element)v.get(95)).setAttribute("filas","1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(95)).setAttribute("cod","00394" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:96 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","10" );
      ((Element)v.get(96)).setAttribute("class","menu5texto" );
      ((Element)v.get(77)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","10" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","20" );
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).setAttribute("class","menu5texto" );
      ((Element)v.get(77)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","75" );
      ((Element)v.get(99)).setAttribute("border","1" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(99)).setAttribute("cellpadding","1" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(99)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblVariablesVenta');" );
      ((Element)v.get(99)).setAttribute("onclick","onClickPestanyaHabilitada(7, 'formulario', 'LPMantenerParametrosConsultorasRanking');" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblVariablesVenta" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(102)).setAttribute("cod","1951" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:103 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","16" );
      ((Element)v.get(103)).setAttribute("class","menu5texto" );
      ((Element)v.get(77)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","12" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:105 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(105)).setAttribute("nombre","capa1" );
      ((Element)v.get(10)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(106)).setAttribute("border","0" );
      ((Element)v.get(106)).setAttribute("cellspacing","0" );
      ((Element)v.get(106)).setAttribute("cellpadding","0" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","12" );
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("height","12" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","750" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","12" );
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(113)).setAttribute("height","1" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:107   */

      /* Empieza nodo:114 / Elemento padre: 106   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(119)).setAttribute("class","legend" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblDatosParametrosConsultoras" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","legend" );
      ((Element)v.get(120)).setAttribute("cod","00598" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("table"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(121)).setAttribute("border","0" );
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(121)).setAttribute("cellspacing","0" );
      ((Element)v.get(121)).setAttribute("cellpadding","0" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","661" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","left" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("colspan","4" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:128 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblBaseCalculo" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","1181" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblTipoVenta" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","1622" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:128   */

      /* Empieza nodo:139 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(143)).setAttribute("nombre","cbBaseCalculo" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(143)).setAttribute("size","1" );
      ((Element)v.get(143)).setAttribute("multiple","N" );
      ((Element)v.get(143)).setAttribute("req","S" );
      ((Element)v.get(143)).setAttribute("valorinicial","" );
      ((Element)v.get(143)).setAttribute("textoinicial","" );
      ((Element)v.get(143)).setAttribute("onchange","onChangeBaseCalculo();" );
      ((Element)v.get(143)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(143)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:145 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).setAttribute("valign","bottom" );
      ((Element)v.get(139)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(148)).setAttribute("nombre","cbTipoVenta" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).setAttribute("size","1" );
      ((Element)v.get(148)).setAttribute("multiple","N" );
      ((Element)v.get(148)).setAttribute("req","N" );
      ((Element)v.get(148)).setAttribute("valorinicial","" );
      ((Element)v.get(148)).setAttribute("textoinicial","" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:150 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:139   */

      /* Empieza nodo:152 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(152));

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
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:155 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("table"));
      ((Element)v.get(157)).setAttribute("width","661" );
      ((Element)v.get(157)).setAttribute("border","0" );
      ((Element)v.get(157)).setAttribute("align","left" );
      ((Element)v.get(157)).setAttribute("cellspacing","0" );
      ((Element)v.get(157)).setAttribute("cellpadding","0" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("colspan","4" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:161 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("id","datosTitle" );
      ((Element)v.get(165)).setAttribute("cod","1175" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","datosTitle" );
      ((Element)v.get(169)).setAttribute("cod","1176" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(161)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:161   */

      /* Empieza nodo:172 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(176)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("size","1" );
      ((Element)v.get(176)).setAttribute("multiple","N" );
      ((Element)v.get(176)).setAttribute("req","N" );
      ((Element)v.get(176)).setAttribute("valorinicial","" );
      ((Element)v.get(176)).setAttribute("textoinicial","" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:178 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","25" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(181)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("size","1" );
      ((Element)v.get(181)).setAttribute("multiple","N" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(181)).setAttribute("valorinicial","" );
      ((Element)v.get(181)).setAttribute("textoinicial","" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:183 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:172   */

      /* Empieza nodo:185 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("colspan","4" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:121   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:188 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:114   */

      /* Empieza nodo:190 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("table"));
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(195)).setAttribute("border","0" );
      ((Element)v.get(195)).setAttribute("align","center" );
      ((Element)v.get(195)).setAttribute("cellspacing","0" );
      ((Element)v.get(195)).setAttribute("cellpadding","0" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("class","botonera" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(198)).setAttribute("nombre","btnEstatusVenta" );
      ((Element)v.get(198)).setAttribute("ID","botonContenido" );
      ((Element)v.get(198)).setAttribute("tipo","html" );
      ((Element)v.get(198)).setAttribute("estado","false" );
      ((Element)v.get(198)).setAttribute("cod","1701" );
      ((Element)v.get(198)).setAttribute("accion","onClickEstatusVenta();" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(199)).setAttribute("nombre","btnParticipantes" );
      ((Element)v.get(199)).setAttribute("ID","botonContenido" );
      ((Element)v.get(199)).setAttribute("tipo","html" );
      ((Element)v.get(199)).setAttribute("estado","false" );
      ((Element)v.get(199)).setAttribute("cod","745" );
      ((Element)v.get(199)).setAttribute("ontab","focalizaTab1();" );
      ((Element)v.get(199)).setAttribute("accion","onClickParticipantes();" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:200 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","12" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:190   */

      /* Empieza nodo:202 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("width","12" );
      ((Element)v.get(203)).setAttribute("align","center" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","12" );
      ((Element)v.get(204)).setAttribute("height","12" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","756" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","12" );
      ((Element)v.get(202)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","12" );
      ((Element)v.get(208)).setAttribute("height","1" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:202   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:10   */


   }

}
