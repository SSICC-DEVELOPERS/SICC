
import org.w3c.dom.*;
import java.util.ArrayList;

public class MMGLocalizationPage  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         
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
      v.add(doc.createTextNode("\r		\r				var descriptions = new Vector();\r		\r				function initComponents(){\r						document.title = GestionarMensaje('MMGGlobal.localzation.windowtitle');\r			\r						loadDescriptions(window.opener.getLocalization(get('localizationFrm.atributteName')));\r		}\r		\r						function loadDescriptions(descriptionsVector){\r			for(var i=0; i < descriptionsVector.longitud; i++){\r				var languageIndex = languageList.datos.buscar(descriptionsVector.ij(i,0),0);\r				if(languageIndex != -1){\r					descriptionsList.datos.agregar([descriptionsVector.ij(i,0), \r						languageList.datos.ij(languageIndex,1), descriptionsVector.ij(i,1)]);\r				}\r			}\r			descriptions.cargar(descriptionsVector.volcar());\r			descriptionsList.display();\r		}\r		\r				function addLocalizationDescription(){\r						if(languageList.seleccion.longitud != 1){\r				cdos_mostrarAlert(GestionarMensaje('MMGGlobal.localzation.nolanguage.message'));\r				return;\r			}\r			\r						if(ValidaLongitud(get('localizationFrm.description'), 1, get('localizationFrm.size')) != \"OK\"){\r				cdos_mostrarAlert(GestionarMensaje('MMGGlobal.localzation.nodescription.message') +\r					'(1-' + ')' + get('localizationFrm.size'));\r				return;\r			}\r			\r						if(descriptionsList.datos.buscar(languageList.getSeleccion(),0) != -1){\r				cdos_mostrarAlert(GestionarMensaje('MMGGlobal.localzation.languagedescriptionexits.message'));\r				return;\r			}\r			\r			\r						var indiceIdioma = languageList.datos.buscar(languageList.getSeleccion(),0);\r			descriptionsList.datos.agregar([languageList.getSeleccion(), languageList.datos.ij(indiceIdioma,1),\r				get('localizationFrm.description')]);\r			descriptions.agregar([languageList.getSeleccion(), get('localizationFrm.description')]);\r			\r						descriptionsList.display();\r			set('localizationFrm.description','') ;\r			languageList.offN();\r		}\r			\r						function removeLocalizationDescriptions(){\r						if(descriptionsList.seleccion.longitud < 1) return;\r			\r						for(var i = 0; i < descriptionsList.seleccion.longitud; i++){\r				var indice = descriptions.buscar(descriptionsList.seleccion.ij(i,0), 0);\r				descriptions.eliminar(indice);\r				descriptionsList.datos.eliminar(indice);\r			}\r			\r						descriptionsList.display();\r		}\r		\r				function updateLocalizationDescription(){\r						if(ValidaLongitud(get('localizationFrm.updateDescription'), 1, get('localizationFrm.size')) != \"OK\"){\r				cdos_mostrarAlert(GestionarMensaje('MMGGlobal.localzation.nodescription.message') + \r					'(1-' + ')' + get('localizationFrm.size'));\r				return;\r			}\r			\r						var indice = descriptions.buscar(descriptionsList.getSeleccion(), 0);\r			descriptionsList.datos.ij2(get('localizationFrm.updateDescription'), indice, 2);\r			descriptions.ij2(get('localizationFrm.updateDescription'), indice, 1);\r			descriptionsList.display();\r			\r						visibilidad('updateDescriptionLayer', 'O');\r			visibilidad('buttonBarLayer', 'V');\r		}\r		\r		function cancelUpdateLocalizationDescription(){\r			visibilidad('updateDescriptionLayer', 'O');\r			visibilidad('buttonBarLayer', 'V');\r		}\r		\r						function bindDescriptions(){\r						if(descriptions.longitud == 0 || descriptions.buscar(get('localizationFrm.defaultLanguageCode'),0) == -1){\r				cdos_mostrarAlert(GestionarMensaje('MMGGlobal.localzation.defalutlanguagevalue.message'));\r				return;\r			}\r		\r						window.opener.setLocalization(get('localizationFrm.atributteName'), descriptions);\r			window.close();\r		}\r		\r				function update(){\r						if(descriptionsList.seleccion.longitud != 1){\r				cdos_mostrarAlert(GestionarMensaje('MMGGlobal.localzation.descriptionsingleselection.message'));\r				return;\r			}\r			\r						var indice = descriptionsList.datos.buscar(descriptionsList.getSeleccion(), 0);\r			set('localizationFrm.updateDescription', descriptionsList.datos.ij(indice,2));\r			\r						visibilidad('updateDescriptionLayer', 'V');\r			visibilidad('buttonBarLayer', 'O');\r		}\r		\r				function cancel(){\r						window.close();\r		}\r		\r	"));
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
      ((Element)v.get(6)).setAttribute("nombre","atributteName" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","defaultLanguageCode" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","size" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(9)).setAttribute("nombre","languageLayer" );
      ((Element)v.get(9)).setAttribute("alto","200" );
      ((Element)v.get(9)).setAttribute("ancho","615" );
      ((Element)v.get(9)).setAttribute("colorf","" );
      ((Element)v.get(9)).setAttribute("borde","0" );
      ((Element)v.get(9)).setAttribute("imagenf","" );
      ((Element)v.get(9)).setAttribute("repeat","" );
      ((Element)v.get(9)).setAttribute("padding","" );
      ((Element)v.get(9)).setAttribute("visibilidad","visible" );
      ((Element)v.get(9)).setAttribute("contravsb","" );
      ((Element)v.get(9)).setAttribute("x","12" );
      ((Element)v.get(9)).setAttribute("y","10" );
      ((Element)v.get(9)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(10)).setAttribute("seleccion","boton" );
      ((Element)v.get(10)).setAttribute("nombre","languageList" );
      ((Element)v.get(10)).setAttribute("x","0" );
      ((Element)v.get(10)).setAttribute("y","0" );
      ((Element)v.get(10)).setAttribute("ancho","200" );
      ((Element)v.get(10)).setAttribute("alto","200" );
      ((Element)v.get(10)).setAttribute("filas","1" );
      ((Element)v.get(10)).setAttribute("multisel","1" );
      ((Element)v.get(10)).setAttribute("incy","10" );
      ((Element)v.get(10)).setAttribute("incx","10" );
      ((Element)v.get(10)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(10)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(10)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(10)).setAttribute("accion","" );
      ((Element)v.get(10)).setAttribute("sep","|" );
      ((Element)v.get(10)).setAttribute("pixelsborde","2" );
      ((Element)v.get(10)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(11)).setAttribute("height","20" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(12)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(12)).setAttribute("ancho","10" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(13)).setAttribute("nombre","selectionlanguageListLabel" );
      ((Element)v.get(13)).setAttribute("ancho","10" );
      ((Element)v.get(13)).setAttribute("alto","20" );
      ((Element)v.get(13)).setAttribute("filas","1" );
      ((Element)v.get(13)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(13)).setAttribute("cod","" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:12   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(14)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(14)).setAttribute("ancho","150" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(15)).setAttribute("nombre","languageLanguageListLabel" );
      ((Element)v.get(15)).setAttribute("ancho","150" );
      ((Element)v.get(15)).setAttribute("alto","20" );
      ((Element)v.get(15)).setAttribute("filas","1" );
      ((Element)v.get(15)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(15)).setAttribute("cod","MMGGlobal.localization.language.label" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */
      /* Termina nodo:14   */
      /* Termina nodo:11   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(16)).setAttribute("ancho","160" );
      ((Element)v.get(16)).setAttribute("filas","1" );
      ((Element)v.get(16)).setAttribute("bloquesid","['datosCamposCenterImpar','datosCamposCenterPar']" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(17)).setAttribute("ancho","10" );
      ((Element)v.get(17)).setAttribute("caracteres","10" );
      ((Element)v.get(17)).setAttribute("filas","1" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(18)).setAttribute("ancho","10" );
      ((Element)v.get(18)).setAttribute("caracteres","150" );
      ((Element)v.get(18)).setAttribute("filas","1" );
      ((Element)v.get(16)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:16   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:10   */
      /* Termina nodo:9   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(20)).setAttribute("nombre","newDescriptionLayer" );
      ((Element)v.get(20)).setAttribute("alto","50" );
      ((Element)v.get(20)).setAttribute("ancho","615" );
      ((Element)v.get(20)).setAttribute("colorf","" );
      ((Element)v.get(20)).setAttribute("borde","0" );
      ((Element)v.get(20)).setAttribute("imagenf","" );
      ((Element)v.get(20)).setAttribute("repeat","" );
      ((Element)v.get(20)).setAttribute("padding","" );
      ((Element)v.get(20)).setAttribute("visibilidad","visible" );
      ((Element)v.get(20)).setAttribute("contravsb","" );
      ((Element)v.get(20)).setAttribute("x","12" );
      ((Element)v.get(20)).setAttribute("y","220" );
      ((Element)v.get(20)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","1" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(21)).setAttribute("bordercolor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(23)).setAttribute("align","left" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(24)).setAttribute("nombre","languageLabel" );
      ((Element)v.get(24)).setAttribute("ancho","75" );
      ((Element)v.get(24)).setAttribute("alto","20" );
      ((Element)v.get(24)).setAttribute("filas","1" );
      ((Element)v.get(24)).setAttribute("id","datosTitle" );
      ((Element)v.get(24)).setAttribute("cod","MMGGlobal.localization.description.label" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","8" );
      ((Element)v.get(26)).setAttribute("height","8" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(27)).setAttribute("align","left" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(28)).setAttribute("nombre","description" );
      ((Element)v.get(28)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(28)).setAttribute("trim","S" );
      ((Element)v.get(28)).setAttribute("max","400" );
      ((Element)v.get(28)).setAttribute("onchange","" );
      ((Element)v.get(28)).setAttribute("size","50" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(28)).setAttribute("validacion","" );
      ((Element)v.get(28)).setAttribute("onblur","" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 22   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(22)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","8" );
      ((Element)v.get(30)).setAttribute("height","8" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 22   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(31)).setAttribute("align","left" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(22)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(32)).setAttribute("nombre","addDescriptionButton" );
      ((Element)v.get(32)).setAttribute("ID","botonContenido" );
      ((Element)v.get(32)).setAttribute("tipo","html" );
      ((Element)v.get(32)).setAttribute("accion","addLocalizationDescription();" );
      ((Element)v.get(32)).setAttribute("estado","true" );
      ((Element)v.get(32)).setAttribute("cod","MMGGlobal.localization.addbutton.label" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:33 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(33)).setAttribute("nombre","descriptionsLayer" );
      ((Element)v.get(33)).setAttribute("alto","200" );
      ((Element)v.get(33)).setAttribute("ancho","610" );
      ((Element)v.get(33)).setAttribute("colorf","" );
      ((Element)v.get(33)).setAttribute("borde","0" );
      ((Element)v.get(33)).setAttribute("imagenf","" );
      ((Element)v.get(33)).setAttribute("repeat","" );
      ((Element)v.get(33)).setAttribute("padding","" );
      ((Element)v.get(33)).setAttribute("visibilidad","visible" );
      ((Element)v.get(33)).setAttribute("contravsb","" );
      ((Element)v.get(33)).setAttribute("x","12" );
      ((Element)v.get(33)).setAttribute("y","280" );
      ((Element)v.get(33)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(34)).setAttribute("seleccion","boton" );
      ((Element)v.get(34)).setAttribute("nombre","descriptionsList" );
      ((Element)v.get(34)).setAttribute("x","0" );
      ((Element)v.get(34)).setAttribute("y","0" );
      ((Element)v.get(34)).setAttribute("ancho","610" );
      ((Element)v.get(34)).setAttribute("alto","200" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("multisel","-1" );
      ((Element)v.get(34)).setAttribute("incy","10" );
      ((Element)v.get(34)).setAttribute("incx","10" );
      ((Element)v.get(34)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(34)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(34)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(34)).setAttribute("accion","" );
      ((Element)v.get(34)).setAttribute("sep","|" );
      ((Element)v.get(34)).setAttribute("pixelsborde","2" );
      ((Element)v.get(34)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(35)).setAttribute("height","20" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(36)).setAttribute("ancho","10" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","selectionDescriptionsListLabel" );
      ((Element)v.get(37)).setAttribute("ancho","10" );
      ((Element)v.get(37)).setAttribute("alto","20" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(37)).setAttribute("cod","" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(38)).setAttribute("ancho","150" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","languageDescriptionsListLabel" );
      ((Element)v.get(39)).setAttribute("ancho","150" );
      ((Element)v.get(39)).setAttribute("alto","20" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(39)).setAttribute("cod","MMGGlobal.localization.language.label" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(40)).setAttribute("ancho","400" );
      ((Element)v.get(35)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","descriptionDescriptionsListLabel" );
      ((Element)v.get(41)).setAttribute("ancho","400" );
      ((Element)v.get(41)).setAttribute("alto","20" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(41)).setAttribute("cod","MMGGlobal.localization.description.label" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:35   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(42)).setAttribute("ancho","560" );
      ((Element)v.get(42)).setAttribute("filas","1" );
      ((Element)v.get(42)).setAttribute("bloquesid","['datosCamposCenterImpar','datosCamposCenterPar', 'datosCamposCenterImpar']" );
      ((Element)v.get(34)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("ancho","10" );
      ((Element)v.get(43)).setAttribute("caracteres","10" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("ancho","10" );
      ((Element)v.get(44)).setAttribute("caracteres","150" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(42)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("ancho","10" );
      ((Element)v.get(45)).setAttribute("caracteres","400" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:42   */

      /* Empieza nodo:46 / Elemento padre: 34   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(34)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:47 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(47)).setAttribute("nombre","buttonBarLayer" );
      ((Element)v.get(47)).setAttribute("alto","50" );
      ((Element)v.get(47)).setAttribute("ancho","615" );
      ((Element)v.get(47)).setAttribute("colorf","" );
      ((Element)v.get(47)).setAttribute("borde","0" );
      ((Element)v.get(47)).setAttribute("imagenf","" );
      ((Element)v.get(47)).setAttribute("repeat","" );
      ((Element)v.get(47)).setAttribute("padding","" );
      ((Element)v.get(47)).setAttribute("visibilidad","visible" );
      ((Element)v.get(47)).setAttribute("contravsb","" );
      ((Element)v.get(47)).setAttribute("x","12" );
      ((Element)v.get(47)).setAttribute("y","490" );
      ((Element)v.get(47)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("cellspacing","1" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).setAttribute("bordercolor","" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(51)).setAttribute("nombre","removeDescriptionsButton" );
      ((Element)v.get(51)).setAttribute("ID","botonContenido" );
      ((Element)v.get(51)).setAttribute("tipo","html" );
      ((Element)v.get(51)).setAttribute("accion","removeLocalizationDescriptions();" );
      ((Element)v.get(51)).setAttribute("estado","true" );
      ((Element)v.get(51)).setAttribute("cod","MMGGlobal.localization.removebutton.label" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 50   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(52)).setAttribute("nombre","upodateButton" );
      ((Element)v.get(52)).setAttribute("ID","botonContenido" );
      ((Element)v.get(52)).setAttribute("tipo","html" );
      ((Element)v.get(52)).setAttribute("accion","update();" );
      ((Element)v.get(52)).setAttribute("estado","true" );
      ((Element)v.get(52)).setAttribute("cod","MMGGlobal.localization.updatebutton.label" );
      ((Element)v.get(50)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:50   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(49)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","30" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(49)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(56)).setAttribute("nombre","acceptButton" );
      ((Element)v.get(56)).setAttribute("ID","botonContenido" );
      ((Element)v.get(56)).setAttribute("tipo","html" );
      ((Element)v.get(56)).setAttribute("accion","bindDescriptions();" );
      ((Element)v.get(56)).setAttribute("estado","true" );
      ((Element)v.get(56)).setAttribute("cod","MMGGlobal.localization.bindbutton.label" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 55   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(57)).setAttribute("nombre","cancelButton" );
      ((Element)v.get(57)).setAttribute("ID","botonContenido" );
      ((Element)v.get(57)).setAttribute("tipo","html" );
      ((Element)v.get(57)).setAttribute("accion","cancel();" );
      ((Element)v.get(57)).setAttribute("estado","true" );
      ((Element)v.get(57)).setAttribute("cod","MMGGlobal.localization.cancelbutton.label" );
      ((Element)v.get(55)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:55   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:58 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(58)).setAttribute("nombre","updateDescriptionLayer" );
      ((Element)v.get(58)).setAttribute("alto","50" );
      ((Element)v.get(58)).setAttribute("ancho","615" );
      ((Element)v.get(58)).setAttribute("colorf","" );
      ((Element)v.get(58)).setAttribute("borde","0" );
      ((Element)v.get(58)).setAttribute("imagenf","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(58)).setAttribute("repeat","" );
      ((Element)v.get(58)).setAttribute("padding","" );
      ((Element)v.get(58)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(58)).setAttribute("contravsb","" );
      ((Element)v.get(58)).setAttribute("x","12" );
      ((Element)v.get(58)).setAttribute("y","490" );
      ((Element)v.get(58)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(59)).setAttribute("border","0" );
      ((Element)v.get(59)).setAttribute("cellspacing","1" );
      ((Element)v.get(59)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).setAttribute("bordercolor","" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(61)).setAttribute("align","left" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","languageLabel" );
      ((Element)v.get(62)).setAttribute("ancho","75" );
      ((Element)v.get(62)).setAttribute("alto","20" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","MMGGlobal.localization.newdescription.label" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(65)).setAttribute("align","left" );
      ((Element)v.get(60)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(66)).setAttribute("nombre","updateDescription" );
      ((Element)v.get(66)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(66)).setAttribute("trim","S" );
      ((Element)v.get(66)).setAttribute("max","400" );
      ((Element)v.get(66)).setAttribute("onchange","" );
      ((Element)v.get(66)).setAttribute("size","50" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("validacion","" );
      ((Element)v.get(66)).setAttribute("onblur","" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(60)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(69)).setAttribute("align","left" );
      ((Element)v.get(60)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(70)).setAttribute("nombre","updateDescriptionButton" );
      ((Element)v.get(70)).setAttribute("ID","botonContenido" );
      ((Element)v.get(70)).setAttribute("tipo","html" );
      ((Element)v.get(70)).setAttribute("accion","updateLocalizationDescription();" );
      ((Element)v.get(70)).setAttribute("estado","true" );
      ((Element)v.get(70)).setAttribute("cod","MMGGlobal.localization.updatebutton.label" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(60)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("align","left" );
      ((Element)v.get(60)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(74)).setAttribute("nombre","canelUpdateDescriptionButton" );
      ((Element)v.get(74)).setAttribute("ID","botonContenido" );
      ((Element)v.get(74)).setAttribute("tipo","html" );
      ((Element)v.get(74)).setAttribute("accion","cancelUpdateLocalizationDescription();" );
      ((Element)v.get(74)).setAttribute("estado","true" );
      ((Element)v.get(74)).setAttribute("cod","MMGGlobal.localization.cancelupdatebutton.label" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:5   */


   }

}
