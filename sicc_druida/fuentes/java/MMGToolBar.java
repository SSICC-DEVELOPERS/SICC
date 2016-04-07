
import org.w3c.dom.*;
import java.util.ArrayList;

public class MMGToolBar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","Prueba" );
      ((Element)v.get(0)).setAttribute("titulo","Titulo de la Página" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Descripción línea estado" );
      ((Element)v.get(0)).setAttribute("onload","mmgToolBarLoaded();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r 	 \r	       var APP_CONTENIDO = parent.frames['contenido']; \r	       \r	       function mmgToolBarLoaded(){\r	       	 	       	 	       	 	         if(String(parent.contenido.loadScreen) != \"undefined\") parent.contenido.loadScreen();\r	       }\r	   \r  "));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frmBarra" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(4)).setAttribute("nombre","capaTitulo" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(5)).setAttribute("width","100%" );
      ((Element)v.get(5)).setAttribute("height","23" );
      ((Element)v.get(5)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(5)).setAttribute("cellpadding","0" );
      ((Element)v.get(5)).setAttribute("cellspacing","0" );
      ((Element)v.get(5)).setAttribute("border","0" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("td"));
      ((Element)v.get(7)).setAttribute("width","5%" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(8)).setAttribute("src","fondo_titulo.gif" );
      ((Element)v.get(8)).setAttribute("width","44" );
      ((Element)v.get(8)).setAttribute("height","23" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).setAttribute("width","100%" );
      ((Element)v.get(9)).setAttribute("valign","middle" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(10)).setAttribute("nombre","lblTitulo" );
      ((Element)v.get(10)).setAttribute("ancho","500" );
      ((Element)v.get(10)).setAttribute("alto","23" );
      ((Element)v.get(10)).setAttribute("filas","1" );
      ((Element)v.get(10)).setAttribute("id","titulos" );
      ((Element)v.get(10)).setAttribute("cod","MMGGlobal.toolbar.label" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:9   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("td"));
      ((Element)v.get(6)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(12)).setAttribute("nombre","btnBarra" );
      ((Element)v.get(12)).setAttribute("tipo","H" );
      ((Element)v.get(12)).setAttribute("x","0" );
      ((Element)v.get(12)).setAttribute("y","0" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(13)).setAttribute("on","iconGuardar.gif" );
      ((Element)v.get(13)).setAttribute("off","iconGuardar.gif" );
      ((Element)v.get(13)).setAttribute("disable","iconGuardarOff.gif" );
      ((Element)v.get(13)).setAttribute("texto","Guardar" );
      ((Element)v.get(13)).setAttribute("estado","activo" );
      ((Element)v.get(13)).setAttribute("funcion","APP_CONTENIDO.insertar()" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(14)).setAttribute("on","iconVolver.gif" );
      ((Element)v.get(14)).setAttribute("off","iconVolver.gif" );
      ((Element)v.get(14)).setAttribute("disable","iconVolverOff.gif" );
      ((Element)v.get(14)).setAttribute("funcion","APP_CONTENIDO.Volver();" );
      ((Element)v.get(14)).setAttribute("texto","Volver" );
      ((Element)v.get(14)).setAttribute("estado","activo" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(15)).setAttribute("on","iconSalir.gif" );
      ((Element)v.get(15)).setAttribute("off","iconSalir.gif" );
      ((Element)v.get(15)).setAttribute("disable","iconSalirOff.gif" );
      ((Element)v.get(15)).setAttribute("funcion","APP_CONTENIDO.fSalir();" );
      ((Element)v.get(15)).setAttribute("texto","Salir" );
      ((Element)v.get(15)).setAttribute("estado","activo" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 12   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(16)).setAttribute("on","iconBorrar.gif" );
      ((Element)v.get(16)).setAttribute("off","iconBorrar.gif" );
      ((Element)v.get(16)).setAttribute("disable","iconBorrarOff.gif" );
      ((Element)v.get(16)).setAttribute("texto","Eliminar" );
      ((Element)v.get(16)).setAttribute("estado","activo" );
      ((Element)v.get(16)).setAttribute("function","APP_CONTENIDO.Delete()" );
      ((Element)v.get(12)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 12   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("BTN"));
      ((Element)v.get(17)).setAttribute("on","iconLimpiar.gif" );
      ((Element)v.get(17)).setAttribute("off","iconLimpiar.gif" );
      ((Element)v.get(17)).setAttribute("disable","iconLimpiarOff.gif" );
      ((Element)v.get(17)).setAttribute("funcion","APP_CONTENIDO.Clean();" );
      ((Element)v.get(17)).setAttribute("texto","Limpiar" );
      ((Element)v.get(17)).setAttribute("estado","activo" );
      ((Element)v.get(12)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 12   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(18)).setAttribute("on","iconImprimir.gif" );
      ((Element)v.get(18)).setAttribute("off","iconImprimir.gif" );
      ((Element)v.get(18)).setAttribute("disable","iconImprimirOff.gif" );
      ((Element)v.get(18)).setAttribute("funcion","APP_CONTENIDO.fImprimir();" );
      ((Element)v.get(18)).setAttribute("texto","Imprimir" );
      ((Element)v.get(18)).setAttribute("estado","activo" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(19)).setAttribute("on","iconClave.gif" );
      ((Element)v.get(19)).setAttribute("off","iconClave.gif" );
      ((Element)v.get(19)).setAttribute("disable","iconClaveOff.gif" );
      ((Element)v.get(19)).setAttribute("funcion","APP_CONTENIDO.fCambiarClave();" );
      ((Element)v.get(19)).setAttribute("texto","Clave" );
      ((Element)v.get(19)).setAttribute("estado","activo" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(20)).setAttribute("on","iconFavoritos.gif" );
      ((Element)v.get(20)).setAttribute("off","iconFavoritos.gif" );
      ((Element)v.get(20)).setAttribute("disable","iconFavoritosOff.gif" );
      ((Element)v.get(20)).setAttribute("funcion","APP_CONTENIDO.fFavoritos();" );
      ((Element)v.get(20)).setAttribute("texto","Favoritos" );
      ((Element)v.get(20)).setAttribute("estado","activo" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(21)).setAttribute("on","iconPais.gif" );
      ((Element)v.get(21)).setAttribute("off","iconPais.gif" );
      ((Element)v.get(21)).setAttribute("disable","iconPaisOff.gif" );
      ((Element)v.get(21)).setAttribute("funcion","APP_CONTENIDO.fPais();" );
      ((Element)v.get(21)).setAttribute("texto","Pais" );
      ((Element)v.get(21)).setAttribute("estado","activo" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(22)).setAttribute("on","iconAyuda.gif" );
      ((Element)v.get(22)).setAttribute("off","iconAyuda.gif" );
      ((Element)v.get(22)).setAttribute("disable","iconAyudaOff.gif" );
      ((Element)v.get(22)).setAttribute("funcion","APP_CONTENIDO.fAyuda();" );
      ((Element)v.get(22)).setAttribute("texto","Ayuda" );
      ((Element)v.get(22)).setAttribute("estado","activo" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */
      /* Termina nodo:4   */
      /* Termina nodo:3   */


   }

}
