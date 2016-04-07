
import org.w3c.dom.*;
import java.util.ArrayList;

public class barra_favoritos_seleccionar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","barra_favoritos_seleccionar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r	function pausa(s) {\r		setTimeout(\"enviaF()\",s);\r	}\r\r	function enviaF() {\r		APP_CONTENIDO.enviarFormulario();\r	}\r         \r	function pausa2(s) {\r		setTimeout(\"limpiaF()\",s);\r	}\r\r	function limpiaF(){\r		APP_CONTENIDO.limpiarCampos();\r	}\r\r	var APP_CONTENIDO = parent.frames['contenido']; \r\r    \r "));
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
      v.add(doc.createTextNode("\r 	return false;\r"));
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
      v.add(doc.createTextNode("\r 	return false;\r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmBarra" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(8)).setAttribute("nombre","capaTitulo" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(9)).setAttribute("width","100%" );
      ((Element)v.get(9)).setAttribute("height","23" );
      ((Element)v.get(9)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(9)).setAttribute("cellpadding","0" );
      ((Element)v.get(9)).setAttribute("cellspacing","0" );
      ((Element)v.get(9)).setAttribute("border","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).setAttribute("width","5%" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","flechaTitle.jpg" );
      ((Element)v.get(12)).setAttribute("width","38" );
      ((Element)v.get(12)).setAttribute("height","23" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("width","100%" );
      ((Element)v.get(13)).setAttribute("valign","middle" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(14)).setAttribute("nombre","lblTitulo" );
      ((Element)v.get(14)).setAttribute("ancho","250" );
      ((Element)v.get(14)).setAttribute("alto","23" );
      ((Element)v.get(14)).setAttribute("filas","1" );
      ((Element)v.get(14)).setAttribute("id","titulos" );
      ((Element)v.get(14)).setAttribute("cod","043" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(10)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(16)).setAttribute("nombre","btnBarra" );
      ((Element)v.get(16)).setAttribute("tipo","H" );
      ((Element)v.get(16)).setAttribute("x","0" );
      ((Element)v.get(16)).setAttribute("y","0" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(17)).setAttribute("funcion","APP_CONTENIDO.f_Guardar();" );
      ((Element)v.get(17)).setAttribute("off","iconGuardar.gif" );
      ((Element)v.get(17)).setAttribute("on","iconGuardar.gif" );
      ((Element)v.get(17)).setAttribute("texto","Guardar" );
      ((Element)v.get(17)).setAttribute("estado","activo" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(18)).setAttribute("on","iconVolverOff.gif" );
      ((Element)v.get(18)).setAttribute("off","iconVolverOff.gif" );
      ((Element)v.get(18)).setAttribute("funcion","APP_CONTENIDO.fVolver();" );
      ((Element)v.get(18)).setAttribute("texto","Volver" );
      ((Element)v.get(18)).setAttribute("estado","inactivo" );
      ((Element)v.get(16)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(19)).setAttribute("on","iconSalir.gif" );
      ((Element)v.get(19)).setAttribute("off","iconSalir.gif" );
      ((Element)v.get(19)).setAttribute("funcion","APP_CONTENIDO.fSalir();" );
      ((Element)v.get(19)).setAttribute("texto","Salir" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).setAttribute("estado","activo" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(20)).setAttribute("on","iconBorrarOff.gif" );
      ((Element)v.get(20)).setAttribute("off","iconBorrarOff.gif" );
      ((Element)v.get(20)).setAttribute("texto","Eliminar" );
      ((Element)v.get(20)).setAttribute("estado","inactivo" );
      ((Element)v.get(16)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(21)).setAttribute("on","iconLimpiar.gif" );
      ((Element)v.get(21)).setAttribute("off","iconLimpiar.gif" );
      ((Element)v.get(21)).setAttribute("funcion","APP_CONTENIDO.Clean();" );
      ((Element)v.get(21)).setAttribute("texto","Limpiar" );
      ((Element)v.get(21)).setAttribute("estado","activo" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(22)).setAttribute("on","iconImprimir.gif" );
      ((Element)v.get(22)).setAttribute("off","iconImprimir.gif" );
      ((Element)v.get(22)).setAttribute("funcion","APP_CONTENIDO.fImprimir();" );
      ((Element)v.get(22)).setAttribute("texto","Imprimir" );
      ((Element)v.get(22)).setAttribute("estado","activo" );
      ((Element)v.get(16)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(23)).setAttribute("on","iconClave.gif" );
      ((Element)v.get(23)).setAttribute("off","iconClave.gif" );
      ((Element)v.get(23)).setAttribute("funcion","APP_CONTENIDO.fCambiarClave();" );
      ((Element)v.get(23)).setAttribute("texto","Clave" );
      ((Element)v.get(23)).setAttribute("estado","activo" );
      ((Element)v.get(16)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(24)).setAttribute("on","iconFavoritos.gif" );
      ((Element)v.get(24)).setAttribute("off","iconFavoritos.gif" );
      ((Element)v.get(24)).setAttribute("funcion","APP_CONTENIDO.fFavoritos();" );
      ((Element)v.get(24)).setAttribute("texto","Favoritos" );
      ((Element)v.get(24)).setAttribute("estado","activo" );
      ((Element)v.get(16)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(25)).setAttribute("on","iconPais.gif" );
      ((Element)v.get(25)).setAttribute("off","iconPais.gif" );
      ((Element)v.get(25)).setAttribute("funcion","APP_CONTENIDO.fPais();" );
      ((Element)v.get(25)).setAttribute("texto","Pais" );
      ((Element)v.get(25)).setAttribute("estado","activo" );
      ((Element)v.get(16)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 16   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(26)).setAttribute("on","iconAyuda.gif" );
      ((Element)v.get(26)).setAttribute("off","iconAyuda.gif" );
      ((Element)v.get(26)).setAttribute("funcion","APP_CONTENIDO.fAyuda();" );
      ((Element)v.get(26)).setAttribute("texto","Ayuda" );
      ((Element)v.get(26)).setAttribute("estado","activo" );
      ((Element)v.get(16)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */
      /* Termina nodo:10   */
      /* Termina nodo:9   */
      /* Termina nodo:8   */
      /* Termina nodo:7   */


   }

}
