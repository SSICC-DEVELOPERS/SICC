
import org.w3c.dom.*;
import java.util.ArrayList;

public class MMGLocalizationPageV3  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","MMGLocalizationPage" );
      ((Element)v.get(0)).setAttribute("titulo","Descripciones" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Descripciones" );
      ((Element)v.get(0)).setAttribute("onload","initComponents()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","mmg.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r		\r		\r				var codsIdiomas = new Vector();\r	\r				function initComponents(){\r						document.title = GestionarMensaje('MMGGlobal.localzation.windowtitle');\r			\r									codsIdiomas.token('|', get('localizationFrm.languageWidgetsIds'));\r			\r						loadDescriptions(window.dialogArguments.entrada);\r		}\r		\r						function loadDescriptions(descriptionsVector){\r			for(var i=0; i < descriptionsVector.longitud; i++){\r				var nombreCampo = 'language' + descriptionsVector.ij(i,0) + 'Value';\r				set('localizationFrm.' + nombreCampo, descriptionsVector.ij(i,1));\r			}\r		}\r		\r						function bindDescriptions(){\r						var campoIdiomaDefecto = \"language\" + get('localizationFrm.defaultLanguageCode') + 'Value';\r			if(fTrim(get('localizationFrm.'+ campoIdiomaDefecto)) == \"\" ){\r				cdos_mostrarAlert(GestionarMensaje('MMGGlobal.localzation.defalutlanguagevalue.message') +\r					' (' + get('localizationFrm.defaultLanguageDescription') + ')');\r				return;\r			}\r			\r						var descriptions = window.dialogArguments.salida;\r			for(var i=0; i < codsIdiomas.longitud; i++){\r				var nombreWidget = \"language\" + codsIdiomas.ij(i) + \"Value\";\r				var valor = \" \";\r				if(get('localizationFrm.' + nombreWidget) != \"\") valor = get('localizationFrm.' + nombreWidget);\r				descriptions.agregar([codsIdiomas.ij(i), valor]);\r			}\r		\r						window.close();\r		}\r		\r				function cancel(){\r						window.close();\r		}\r		\r	"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","localizationFrm" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","languageWidgetsIds" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","atributteName" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","defaultLanguageCode" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","defaultLanguageDescription" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","size" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(11)).setAttribute("nombre","capaPrototipo" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(12)).setAttribute("width","100%" );
      ((Element)v.get(12)).setAttribute("height","23" );
      ((Element)v.get(12)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(12)).setAttribute("cellpadding","0" );
      ((Element)v.get(12)).setAttribute("cellspacing","0" );
      ((Element)v.get(12)).setAttribute("border","0" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(12)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(15)).setAttribute("src","flechaTitle.jpg" );
      ((Element)v.get(15)).setAttribute("width","38" );
      ((Element)v.get(15)).setAttribute("height","23" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(16)).setAttribute("class","titulos" );
      ((Element)v.get(16)).setAttribute("valign","middle" );
      ((Element)v.get(16)).setAttribute("width","100%" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(17)).setAttribute("nombre","lblTitulo" );
      ((Element)v.get(17)).setAttribute("ancho","300" );
      ((Element)v.get(17)).setAttribute("alto","23" );
      ((Element)v.get(17)).setAttribute("filas","1" );
      ((Element)v.get(17)).setAttribute("id","titulos" );
      ((Element)v.get(17)).setAttribute("cod","MMGGlobal.localization.title.label" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */
      /* Termina nodo:13   */
      /* Termina nodo:12   */

      /* Empieza nodo:18 / Elemento padre: 11   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(11)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(22)).setAttribute("width","750" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","1" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:19   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(18)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LEGEND"));
      ((Element)v.get(31)).setAttribute("class","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("LABEL"));
      ((Element)v.get(32)).setAttribute("nombre","lblIdiomas" );
      ((Element)v.get(32)).setAttribute("x","24" );
      ((Element)v.get(32)).setAttribute("y","29" );
      ((Element)v.get(32)).setAttribute("cod","MMGGlobal.localization.legend.label" );
      ((Element)v.get(32)).setAttribute("id","legend" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(33)).setAttribute("nombre","localizationTable" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(34)).setAttribute("nombre","localizationTableGapsTrId" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(35)).setAttribute("nombre","localizationTableLeftGapTdId" );
      ((Element)v.get(35)).setAttribute("rowspan","" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(39)).setAttribute("nombre","localizationTableRightGapTdId" );
      ((Element)v.get(39)).setAttribute("rowspan","" );
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","8" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:41 / Elemento padre: 26   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(26)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:26   */

      /* Empieza nodo:43 / Elemento padre: 18   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(18)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(50)).setAttribute("class","botonera" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(51)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(51)).setAttribute("ID","botonContenido" );
      ((Element)v.get(51)).setAttribute("tipo","html" );
      ((Element)v.get(51)).setAttribute("accion","bindDescriptions();" );
      ((Element)v.get(51)).setAttribute("estado","false" );
      ((Element)v.get(51)).setAttribute("cod","MMGGlobal.localization.bindbutton.label" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 50   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(52)).setAttribute("nombre","btnCancelar" );
      ((Element)v.get(52)).setAttribute("ID","botonContenido" );
      ((Element)v.get(52)).setAttribute("tipo","html" );
      ((Element)v.get(52)).setAttribute("accion","cancel();" );
      ((Element)v.get(52)).setAttribute("estado","false" );
      ((Element)v.get(52)).setAttribute("cod","MMGGlobal.localization.cancelbutton.label" );
      ((Element)v.get(50)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:53 / Elemento padre: 43   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(43)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","12" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:43   */

      /* Empieza nodo:55 / Elemento padre: 18   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(18)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("height","12" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(58)).setAttribute("width","750" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(61)).setAttribute("height","1" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:55   */
      /* Termina nodo:18   */
      /* Termina nodo:11   */
      /* Termina nodo:5   */


   }

}
