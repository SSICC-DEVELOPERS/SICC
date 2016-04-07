
import org.w3c.dom.*;
import java.util.ArrayList;

public class menu_secundario  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r\r	var APP_CONTENIDO = parent.frames['contenido']; \r	var menuActivo = false;\r\r	function setActive(param){\r		menuActivo = (param == true);\r	}\r\r	function llamarContenido(param){\r		if(menuActivo){\r			try{\r				eval(param);\r			}catch(e){}\r		}\r	}\r\r	function ocultarCapa(){\r		if(get_visibilidad('capaInicio')){\r			visibilidad('capaInicio','O');\r			menuActivo = false;\r		}\r	}\r	function mostrarCapa(){\r		if(!get_visibilidad('capaInicio')){\r			visibilidad('capaInicio','V');\r			menuActivo = true;\r		}\r	}\r\r	function preguntar(){\r		return cdos_mostrarConfirm(GestionarMensaje('1063',null,null,null));\r	}\r\r\r "));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("SCRIPT"));
      ((Element)v.get(4)).setAttribute("LANGUAGE","javascript" );
      ((Element)v.get(4)).setAttribute("FOR","document" );
      ((Element)v.get(4)).setAttribute("EVENT","onselectstart" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r return false;\r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("SCRIPT"));
      ((Element)v.get(6)).setAttribute("LANGUAGE","javascript" );
      ((Element)v.get(6)).setAttribute("FOR","document" );
      ((Element)v.get(6)).setAttribute("EVENT","ondragstart" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r return false;\r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("SCRIPT"));
      ((Element)v.get(8)).setAttribute("LANGUAGE","javascript" );
      ((Element)v.get(8)).setAttribute("FOR","document" );
      ((Element)v.get(8)).setAttribute("EVENT","oncontextmenu" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Elemento padre:8 / Elemento actual: 9   */
      v.add(doc.createTextNode("\rreturn false;\r"));
      ((Element)v.get(8)).appendChild((Text)v.get(9));

      /* Termina nodo Texto:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmMenuSecundario" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(11)).setAttribute("width","100%" );
      ((Element)v.get(11)).setAttribute("height","23" );
      ((Element)v.get(11)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(11)).setAttribute("cellpadding","0" );
      ((Element)v.get(11)).setAttribute("cellspacing","0" );
      ((Element)v.get(11)).setAttribute("border","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(14)).setAttribute("src","flechaTitle.jpg" );
      ((Element)v.get(14)).setAttribute("width","38" );
      ((Element)v.get(14)).setAttribute("height","23" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).setAttribute("class","titulos" );
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(16)).setAttribute("nombre","etiqueta1" );
      ((Element)v.get(16)).setAttribute("ancho","99%" );
      ((Element)v.get(16)).setAttribute("alto","20" );
      ((Element)v.get(16)).setAttribute("filas","1" );
      ((Element)v.get(16)).setAttribute("id","titulos" );
      ((Element)v.get(16)).setAttribute("cod","" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(16)).setAttribute("enviaroculto","N" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(18)).setAttribute("nombre","btnBarra" );
      ((Element)v.get(18)).setAttribute("tipo","H" );
      ((Element)v.get(18)).setAttribute("x","0" );
      ((Element)v.get(18)).setAttribute("y","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(19)).setAttribute("on","iconGuardarOver.gif" );
      ((Element)v.get(19)).setAttribute("off","iconGuardar.gif" );
      ((Element)v.get(19)).setAttribute("disable","iconGuardarOff.gif" );
      ((Element)v.get(19)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fGuardar()');" );
      ((Element)v.get(19)).setAttribute("texto","" );
      ((Element)v.get(19)).setAttribute("cod","2160" );
      ((Element)v.get(19)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(20)).setAttribute("on","iconVolverOver.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("off","iconVolver.gif" );
      ((Element)v.get(20)).setAttribute("disable","iconVolverOff.gif" );
      ((Element)v.get(20)).setAttribute("funcion","if(preguntar()){llamarContenido('APP_CONTENIDO.fVolver()');}" );
      ((Element)v.get(20)).setAttribute("texto","" );
      ((Element)v.get(20)).setAttribute("cod","2161" );
      ((Element)v.get(20)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(21)).setAttribute("on","iconInicioOver.gif" );
      ((Element)v.get(21)).setAttribute("off","iconSalir.gif" );
      ((Element)v.get(21)).setAttribute("disable","iconSalirOff.gif" );
      ((Element)v.get(21)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fSalir()');" );
      ((Element)v.get(21)).setAttribute("texto","" );
      ((Element)v.get(21)).setAttribute("cod","2162" );
      ((Element)v.get(21)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(22)).setAttribute("on","iconBorrarOver.gif" );
      ((Element)v.get(22)).setAttribute("off","iconBorrar.gif" );
      ((Element)v.get(22)).setAttribute("disable","iconBorrarOff.gif" );
      ((Element)v.get(22)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fBorrar()');" );
      ((Element)v.get(22)).setAttribute("texto","" );
      ((Element)v.get(22)).setAttribute("cod","2163" );
      ((Element)v.get(22)).setAttribute("nombre","botonBorrar" );
      ((Element)v.get(22)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(23)).setAttribute("on","iconLimpiarOver.gif" );
      ((Element)v.get(23)).setAttribute("off","iconLimpiar.gif" );
      ((Element)v.get(23)).setAttribute("disable","iconLimpiarOff.gif" );
      ((Element)v.get(23)).setAttribute("funcion","try{llamarContenido('APP_CONTENIDO.fLimpiarGenericoSICC()')}catch(e){;};try{llamarContenido('APP_CONTENIDO.fLimpiar()');}catch(e){;}" );
      ((Element)v.get(23)).setAttribute("texto","" );
      ((Element)v.get(23)).setAttribute("cod","2164" );
      ((Element)v.get(23)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(24)).setAttribute("on","iconImprimirOver.gif" );
      ((Element)v.get(24)).setAttribute("off","iconImprimir.gif" );
      ((Element)v.get(24)).setAttribute("disable","iconImprimirOff.gif" );
      ((Element)v.get(24)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fImprimir()');" );
      ((Element)v.get(24)).setAttribute("texto","" );
      ((Element)v.get(24)).setAttribute("cod","2165" );
      ((Element)v.get(24)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(25)).setAttribute("on","iconClaveOver.gif" );
      ((Element)v.get(25)).setAttribute("off","iconClave.gif" );
      ((Element)v.get(25)).setAttribute("disable","iconClaveOff.gif" );
      ((Element)v.get(25)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fCambiarClave()');" );
      ((Element)v.get(25)).setAttribute("texto","" );
      ((Element)v.get(25)).setAttribute("cod","2166" );
      ((Element)v.get(25)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(26)).setAttribute("on","iconFavoritosOver.gif" );
      ((Element)v.get(26)).setAttribute("off","iconFavoritos.gif" );
      ((Element)v.get(26)).setAttribute("disable","iconFavoritosOff.gif" );
      ((Element)v.get(26)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fFavoritos()');" );
      ((Element)v.get(26)).setAttribute("texto","" );
      ((Element)v.get(26)).setAttribute("cod","2167" );
      ((Element)v.get(26)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(27)).setAttribute("on","iconPaisOver.gif" );
      ((Element)v.get(27)).setAttribute("off","iconPais.gif" );
      ((Element)v.get(27)).setAttribute("disable","iconPaisOff.gif" );
      ((Element)v.get(27)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fPais()');" );
      ((Element)v.get(27)).setAttribute("texto","" );
      ((Element)v.get(27)).setAttribute("cod","2168" );
      ((Element)v.get(27)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 18   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(28)).setAttribute("on","iconAyudaOver.gif" );
      ((Element)v.get(28)).setAttribute("off","iconAyuda.gif" );
      ((Element)v.get(28)).setAttribute("disable","iconAyudaOff.gif" );
      ((Element)v.get(28)).setAttribute("funcion","llamarContenido('APP_CONTENIDO.fAyuda()');" );
      ((Element)v.get(28)).setAttribute("texto","" );
      ((Element)v.get(28)).setAttribute("cod","2169" );
      ((Element)v.get(28)).setAttribute("estado","inactivo" );
      ((Element)v.get(18)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(29)).setAttribute("nombre","capaInicio" );
      ((Element)v.get(29)).setAttribute("alto","30" );
      ((Element)v.get(29)).setAttribute("ancho","100%" );
      ((Element)v.get(29)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(29)).setAttribute("borde","0" );
      ((Element)v.get(29)).setAttribute("imagenf","" );
      ((Element)v.get(29)).setAttribute("repeat","" );
      ((Element)v.get(29)).setAttribute("padding","" );
      ((Element)v.get(29)).setAttribute("visibilidad","oculto" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(29)).setAttribute("contravsb","" );
      ((Element)v.get(29)).setAttribute("x","0" );
      ((Element)v.get(29)).setAttribute("y","0" );
      ((Element)v.get(29)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:10   */


   }

}
