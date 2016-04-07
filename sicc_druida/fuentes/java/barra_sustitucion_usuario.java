
import org.w3c.dom.*;
import java.util.ArrayList;

public class barra_sustitucion_usuario  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","menu_secundario" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","cargaFrame();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r\r	var APP_CONTENIDO = parent.frames['contenido']; \r	var menuActivo = true;\r\r	function setActive(param){\r		menuActivo = (param == true);\r	}\r\r	function llamarContenido(param){\r		if(menuActivo){\r			eval(param);\r		}\r	}\r\r	function ocultarCapa(){\r		if(get_visibilidad('capaInicio')){\r			visibilidad('capaInicio','O');\r		}\r	}\r	function mostrarCapa(){\r		if(!get_visibilidad('capaInicio')){\r			visibilidad('capaInicio','V');\r		}\r	}\r\r	function cargaFrame()	{\r			parent.frames['contenido'].location.href = \"sicc0000jg?ON=LPSustitucionUsuario\";\r	}\r\r\r\r "));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("SCRIPT"));
      ((Element)v.get(3)).setAttribute("LANGUAGE","javascript" );
      ((Element)v.get(3)).setAttribute("FOR","document" );
      ((Element)v.get(3)).setAttribute("EVENT","onselectstart" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r return false;\r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("SCRIPT"));
      ((Element)v.get(5)).setAttribute("LANGUAGE","javascript" );
      ((Element)v.get(5)).setAttribute("FOR","document" );
      ((Element)v.get(5)).setAttribute("EVENT","ondragstart" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r return false;\r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmMenuSecundario" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(8)).setAttribute("width","100%" );
      ((Element)v.get(8)).setAttribute("height","23" );
      ((Element)v.get(8)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(8)).setAttribute("cellpadding","0" );
      ((Element)v.get(8)).setAttribute("cellspacing","0" );
      ((Element)v.get(8)).setAttribute("border","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(11)).setAttribute("src","flechaTitle.jpg" );
      ((Element)v.get(11)).setAttribute("width","38" );
      ((Element)v.get(11)).setAttribute("height","23" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:10   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).setAttribute("class","titulos" );
      ((Element)v.get(12)).setAttribute("width","100%" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(13)).setAttribute("nombre","etiqueta1" );
      ((Element)v.get(13)).setAttribute("ancho","99%" );
      ((Element)v.get(13)).setAttribute("alto","20" );
      ((Element)v.get(13)).setAttribute("filas","1" );
      ((Element)v.get(13)).setAttribute("id","titulos" );
      ((Element)v.get(13)).setAttribute("cod","" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(13)).setAttribute("enviaroculto","N" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:12   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(15)).setAttribute("nombre","btnBarra" );
      ((Element)v.get(15)).setAttribute("tipo","H" );
      ((Element)v.get(15)).setAttribute("x","0" );
      ((Element)v.get(15)).setAttribute("y","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(16)).setAttribute("on","iconGuardarOver.gif" );
      ((Element)v.get(16)).setAttribute("off","iconGuardar.gif" );
      ((Element)v.get(16)).setAttribute("disable","iconGuardarOff.gif" );
      ((Element)v.get(16)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fGuardar()');" );
      ((Element)v.get(16)).setAttribute("texto","" );
      ((Element)v.get(16)).setAttribute("cod","1251" );
      ((Element)v.get(16)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(17)).setAttribute("on","iconVolverOver.gif" );
      ((Element)v.get(17)).setAttribute("off","iconVolver.gif" );
      ((Element)v.get(17)).setAttribute("disable","iconVolverOff.gif" );
      ((Element)v.get(17)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fVolver()');" );
      ((Element)v.get(17)).setAttribute("texto","" );
      ((Element)v.get(17)).setAttribute("cod","1252" );
      ((Element)v.get(17)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(18)).setAttribute("on","iconInicioOver.gif" );
      ((Element)v.get(18)).setAttribute("off","iconSalir.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(18)).setAttribute("disable","iconSalirOff.gif" );
      ((Element)v.get(18)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fSalirSust()');" );
      ((Element)v.get(18)).setAttribute("texto","" );
      ((Element)v.get(18)).setAttribute("cod","1253" );
      ((Element)v.get(18)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(19)).setAttribute("on","iconBorrarOver.gif" );
      ((Element)v.get(19)).setAttribute("off","iconBorrar.gif" );
      ((Element)v.get(19)).setAttribute("disable","iconBorrarOff.gif" );
      ((Element)v.get(19)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fBorrar()');" );
      ((Element)v.get(19)).setAttribute("texto","" );
      ((Element)v.get(19)).setAttribute("cod","1254" );
      ((Element)v.get(19)).setAttribute("nombre","botonBorrar" );
      ((Element)v.get(19)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(20)).setAttribute("on","iconLimpiarOver.gif" );
      ((Element)v.get(20)).setAttribute("off","iconLimpiar.gif" );
      ((Element)v.get(20)).setAttribute("disable","iconLimpiarOff.gif" );
      ((Element)v.get(20)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fLimpiar()');" );
      ((Element)v.get(20)).setAttribute("texto","" );
      ((Element)v.get(20)).setAttribute("cod","1272" );
      ((Element)v.get(20)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(21)).setAttribute("on","iconImprimirOver.gif" );
      ((Element)v.get(21)).setAttribute("off","iconImprimir.gif" );
      ((Element)v.get(21)).setAttribute("disable","iconImprimirOff.gif" );
      ((Element)v.get(21)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fImprimir()');" );
      ((Element)v.get(21)).setAttribute("texto","" );
      ((Element)v.get(21)).setAttribute("cod","1157" );
      ((Element)v.get(21)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(22)).setAttribute("on","iconClaveOver.gif" );
      ((Element)v.get(22)).setAttribute("off","iconClave.gif" );
      ((Element)v.get(22)).setAttribute("disable","iconClaveOff.gif" );
      ((Element)v.get(22)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fCambiarClave()');" );
      ((Element)v.get(22)).setAttribute("texto","" );
      ((Element)v.get(22)).setAttribute("cod","1255" );
      ((Element)v.get(22)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(23)).setAttribute("on","iconFavoritosOver.gif" );
      ((Element)v.get(23)).setAttribute("off","iconFavoritos.gif" );
      ((Element)v.get(23)).setAttribute("disable","iconFavoritosOff.gif" );
      ((Element)v.get(23)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fFavoritos()');" );
      ((Element)v.get(23)).setAttribute("texto","" );
      ((Element)v.get(23)).setAttribute("cod","1256" );
      ((Element)v.get(23)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(24)).setAttribute("on","iconPaisOver.gif" );
      ((Element)v.get(24)).setAttribute("off","iconPais.gif" );
      ((Element)v.get(24)).setAttribute("disable","iconPaisOff.gif" );
      ((Element)v.get(24)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fPais()');" );
      ((Element)v.get(24)).setAttribute("texto","" );
      ((Element)v.get(24)).setAttribute("cod","5" );
      ((Element)v.get(24)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 15   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(25)).setAttribute("on","iconAyudaOver.gif" );
      ((Element)v.get(25)).setAttribute("off","iconAyuda.gif" );
      ((Element)v.get(25)).setAttribute("disable","iconAyudaOff.gif" );
      ((Element)v.get(25)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fAyuda()');" );
      ((Element)v.get(25)).setAttribute("texto","" );
      ((Element)v.get(25)).setAttribute("cod","1044" );
      ((Element)v.get(25)).setAttribute("estado","inactivo" );
      ((Element)v.get(15)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:26 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(26)).setAttribute("nombre","capaInicio" );
      ((Element)v.get(26)).setAttribute("alto","30" );
      ((Element)v.get(26)).setAttribute("ancho","100%" );
      ((Element)v.get(26)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(26)).setAttribute("borde","0" );
      ((Element)v.get(26)).setAttribute("imagenf","" );
      ((Element)v.get(26)).setAttribute("repeat","" );
      ((Element)v.get(26)).setAttribute("padding","" );
      ((Element)v.get(26)).setAttribute("visibilidad","visible" );
      ((Element)v.get(26)).setAttribute("contravsb","" );
      ((Element)v.get(26)).setAttribute("x","0" );
      ((Element)v.get(26)).setAttribute("y","0" );
      ((Element)v.get(26)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:7   */


   }

}
