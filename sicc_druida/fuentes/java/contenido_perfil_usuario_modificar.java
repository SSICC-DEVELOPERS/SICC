
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_perfil_usuario_modificar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_perfil_usuario_modificar" );
      ((Element)v.get(0)).setAttribute("cod","052" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r  \r          function muestraLista(ultima, rowset){\r                    var tamano = rowset.length;\r                    if (tamano > 0) {\r                                                                  document.all[\"Cplistado1\"].style.visibility='visible';\r                                 document.all[\"separaDiv\"].style.visibility='visible';\r                                 document.all[\"prim1Div\"].style.visibility='visible'; \r                                 document.all[\"ret1Div\"].style.visibility='visible'; \r                                 document.all[\"ava1Div\"].style.visibility='visible';   \r                                 document.all[\"CpLin1listado1\"].style.visibility='visible' \r                                 document.all[\"CpLin2listado1\"].style.visibility='visible' \r                                 document.all[\"CpLin3listado1\"].style.visibility='visible' \r                                 document.all[\"CpLin4listado1\"].style.visibility='visible'\r                                \r                                                                  var caso = get(\"frmContenido.casoUso\");\r                                  if (caso== \"eliminar\"){\r                                    btnProxy(4,1);\r                                  }\r                                 if(caso==\"modificar\"){\r                                         listado1.maxSel = \"1\";\r                                         document.all[\"ModificarDiv\"].style.visibility='visible';\r                                 }\r\r                                 if(caso==\"consultar\"){\r                                         listado1.maxSel = \"1\";\r                                         document.all[\"ConsultarDiv\"].style.visibility='visible';\r                                 }\r\r                                 if(caso==\"copiar\"){\r                                         listado1.maxSel = \"1\";\r                                         document.all[\"CopiarDiv\"].style.visibility='visible';\r                                 }  \r                                 focaliza(\"frmContenido.txtNombrePerfil\");\r                                 return true;\r                    } else {\r                      focaliza(\"frmContenido.txtNombrePerfil\");\r                                            return false;\r                     }\r          }\r\r\r  function onLoadPag()   {   \r    DrdEnsanchaConMargenDcho('listado1',12);\r    \r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"prim1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"ModificarDiv\"].style.visibility='';\r    document.all[\"CopiarDiv\"].style.visibility='hidden';\r    document.all[\"ConsultarDiv\"].style.visibility='hidden';\r    eval (ON_RSZ);\r    init();\r    ocultarLista();\r     \r   }\r\r      function ocultarLista() {\r      btnProxy(4,0);\r            document.all[\"Cplistado1\"].style.visibility='hidden';\r      document.all[\"separaDiv\"].style.visibility='hidden';\r      document.all[\"prim1Div\"].style.visibility='hidden'; \r      document.all[\"ret1Div\"].style.visibility='hidden'; \r      document.all[\"ava1Div\"].style.visibility='hidden';   \r      document.all[\"ModificarDiv\"].style.visibility='hidden';\r      document.all[\"CopiarDiv\"].style.visibility='hidden';\r      document.all[\"ConsultarDiv\"].style.visibility='hidden';\r      document.all[\"CpLin1listado1\"].style.visibility='hidden' \r      document.all[\"CpLin2listado1\"].style.visibility='hidden' \r      document.all[\"CpLin3listado1\"].style.visibility='hidden' \r      document.all[\"CpLin4listado1\"].style.visibility='hidden'\r  }   \r\r   function init() {\r            configurarMenuSecundario(\"frmContenido\");\r      var bErrores = hayErrores(); \r      if (bErrores == true) {\r          return;\r          }\r      focaliza(\"frmContenido.txtNombrePerfil\");\r\r      var exito = get(\"frmContenido.varExitoModifica\");     \r      if(exito == \"Exito\") {\r          fMostrarMensajeExito(\"modificar\");                    set(\"frmContenido.varExitoModifica\", \"\");       }  \r    }\r\r    function hayErrores() {\r          var codigoError = get(\"frmContenido.errCodigo\");\r          var descError = get(\"frmContenido.errDescripcion\");\r\r          if (codigoError == \"\") {\r            return false;\r          }\r                    else {\r            fMostrarMensajeError(codigoError, descError);    \r            set(\"frmContenido.conectorAction\", \"LPPerfiles\");            \r            set(\"frmContenido.accion\", \"\");      \r            enviaSICC(\"frmContenido\");    \r            return true;\r          }\r    }\r\r    function focalizaNombre() {\r      focaliza(\"frmContenido.txtNombrePerfil\");\r    }\r\r    function accionBuscar () {  \r          \r                                    \r            \r            document.all[\"capaTapaTodo\"].style.visibility='hidden';\r            ocultarLista();\r\r\r            var codigos = listado1.codigos();\r      var longitud = codigos.length;\r      for(var i=0;i<longitud;i++) {\r          listado1.deselecciona(i);    \r      }\r\r     configurarPaginado(mipgndo,\"MENBuscarPerfiles\",\"ConectorBuscarPerfiles\",\"es.indra.sicc.dtos.men.DTOString\", armarArray());      \r    }\r\r    function armarArray(){\r      var arrDatos = new Array(); \r      arrDatos[0] = new Array('valor',get('frmContenido.txtNombrePerfil'));     \r      arrDatos[1] = new Array('usuario',get('frmContenido.usuario'));     \r      arrDatos[2] = new Array('password',get('frmContenido.constrasenia'));     \r      return arrDatos;\r    }    \r\r    function accionEliminar() {\r                  \r                  \r      \r      \r\r            if (listado1.numSelecc()== 0) {\r          GestionarMensaje('1021',null,null,null);\r          return false;\r      }   \r\r            var respuesta = GestionarMensaje(1077);\r            if(respuesta==false) {          \r          return;\r      }\r\r                  var parametros = \"MENEliminarPerfil\" + \"|\";\r      \r      var codigos = listado1.codSeleccionados();       var cantElemen = listado1.numSelecc();           var todos = \"\";\r      var valor = \"\";\r      var indice = \"\";\r\r            for(var i=0;i<cantElemen;i++) {\r                    indice = codigos[i]; \r                    valor = listado1.extraeDato(indice,0);\r\r                    if(i==0) {\r            todos = valor;\r          }\r          else {\r            todos = todos + \"~\" + valor;\r          }          \r      }\r\r                  parametros = parametros + todos;\r      asignar([[\"TEXT\",\"\",\"ConectorEliminarPerfilTransaction\",\"resultado\", parametros, \"resultadoOperacion(datos);\"]]);      \r      accionBuscar();\r      focaliza(\"frmContenido.txtNombrePerfil\");\r    }\r\r    function accionCopiar() {\r                  \r      \r      if (listado1.numSelecc()!= 1) {\r          GestionarMensaje('1022',null,null,null);\r          return false;\r      }\r\r      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r      var obj = new Object();  \r      \r      obj.varPerfil=listado1.datos[posicion][1];\r      obj.casoUso=get(\"frmContenido.casoUso\");\r      obj.varCopiar=\"copiando\";\r\r      mostrarModalSICC('LPPerfiles','copiar',obj,800,600);\r      /* Se bloquea la ejecución hasta el cierre de la ventana emergente */ \r      accionBuscar();            \r    }\r\r    function accionConsultar() {\r                  \r      \r      if (listado1.numSelecc()!= 1) {\r          GestionarMensaje('1022',null,null,null);\r          return false;\r      }\r\r      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r      var obj = new Object();  \r      \r      obj.varPerfil=listado1.datos[posicion][1];\r      obj.casoUso=get(\"frmContenido.casoUso\");\r\r      mostrarModalSICC('LPPerfiles','consultar',obj,800,470);        /* Se bloquea la ejecución hasta el cierre de la ventana emergente */ \r\r            \r                                                \r      accionBuscar();          }\r\r    function accionModificar() {      \r                  \r      \r      if (listado1.numSelecc()!= 1) {\r          GestionarMensaje('1022',null,null,null);\r          return false;\r      }\r\r      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r      var obj = new Object();  \r      \r      obj.varPerfil=listado1.datos[posicion][1];\r      obj.casoUso=get(\"frmContenido.casoUso\");\r\r      mostrarModalSICC('LPPerfiles','modificar',obj,800,600);\r      /* Se bloquea la ejecución hasta el cierre de la ventana emergente */ \r\r            accionBuscar();     \r    }\r\r    function obtenerPosicionListaEditable(clave, lista) {\r      this.posicion = 0;\r      if (lista.codSeleccionados().length > 0) {\r          for(var k=0;k<lista.datos.length;k++) {\r            if (lista.datos[k][0] == clave) {\r              posicion=k;\r              break;\r            }\r          }           \r          return posicion;\r      }\r    }\r\r    function fBorrar() {\r      accionEliminar();    \r    }\r\r    \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","casoUso" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","nombreArbol" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","inicio" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","nombre" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","funciones" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","varExitoModifica" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","varPerfil" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","varExitoInserta" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","varNombre" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","varCopiar" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","varUnaVariable" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","usuario" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","contrasenia" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(24)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(24)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(24)).setAttribute("borde","0" );
      ((Element)v.get(24)).setAttribute("imagenf","" );
      ((Element)v.get(24)).setAttribute("repeat","" );
      ((Element)v.get(24)).setAttribute("padding","" );
      ((Element)v.get(24)).setAttribute("visibilidad","" );
      ((Element)v.get(24)).setAttribute("contravsb","" );
      ((Element)v.get(24)).setAttribute("x","0" );
      ((Element)v.get(24)).setAttribute("y","0" );
      ((Element)v.get(24)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("table"));
      ((Element)v.get(25)).setAttribute("width","100%" );
      ((Element)v.get(25)).setAttribute("border","0" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("cellpadding","0" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("align","center" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","12" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","750" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("height","1" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:26   */

      /* Empieza nodo:33 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(38)).setAttribute("class","legend" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(39)).setAttribute("id","legend" );
      ((Element)v.get(39)).setAttribute("cod","0075" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","680" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("align","left" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("colspan","4" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:47 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblPerfil1" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","146" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:47   */

      /* Empieza nodo:54 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(58)).setAttribute("nombre","txtNombrePerfil" );
      ((Element)v.get(58)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).setAttribute("max","25" );
      ((Element)v.get(58)).setAttribute("tipo","" );
      ((Element)v.get(58)).setAttribute("onchange","" );
      ((Element)v.get(58)).setAttribute("req","N" );
      ((Element)v.get(58)).setAttribute("size","33" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("validacion","" );
      ((Element)v.get(58)).setAttribute("ontab","focalizaNombre();" );
      ((Element)v.get(58)).setAttribute("onshtab","focalizaNombre();" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:54   */

      /* Empieza nodo:61 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("colspan","4" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:64 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:33   */

      /* Empieza nodo:66 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("cellpadding","0" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("class","botonera" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(74)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(74)).setAttribute("ID","botonContenido" );
      ((Element)v.get(74)).setAttribute("tipo","html" );
      ((Element)v.get(74)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(74)).setAttribute("estado","false" );
      ((Element)v.get(74)).setAttribute("cod","1" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:75 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","12" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:66   */

      /* Empieza nodo:77 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","12" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","750" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","12" );
      ((Element)v.get(83)).setAttribute("height","1" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:77   */
      /* Termina nodo:25   */

      /* Empieza nodo:84 / Elemento padre: 24   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(84)).setAttribute("nombre","listado1" );
      ((Element)v.get(84)).setAttribute("ancho","680" );
      ((Element)v.get(84)).setAttribute("alto","301" );
      ((Element)v.get(84)).setAttribute("x","12" );
      ((Element)v.get(84)).setAttribute("y","124" );
      ((Element)v.get(84)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(84)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(24)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(85)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(85)).setAttribute("alto","22" );
      ((Element)v.get(85)).setAttribute("imgFondo","" );
      ((Element)v.get(85)).setAttribute("cod","00135" );
      ((Element)v.get(85)).setAttribute("ID","datosTitle" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 84   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(86)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(86)).setAttribute("alto","22" );
      ((Element)v.get(86)).setAttribute("imgFondo","" );
      ((Element)v.get(84)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(87)).setAttribute("precarga","S" );
      ((Element)v.get(87)).setAttribute("conROver","S" );
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(88)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(88)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(88)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(88)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 87   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(89)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(89)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(89)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(87)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(90)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(90)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:87   */

      /* Empieza nodo:91 / Elemento padre: 84   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(84)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(92)).setAttribute("borde","1" );
      ((Element)v.get(92)).setAttribute("horizDatos","1" );
      ((Element)v.get(92)).setAttribute("horizCabecera","1" );
      ((Element)v.get(92)).setAttribute("vertical","1" );
      ((Element)v.get(92)).setAttribute("horizTitulo","1" );
      ((Element)v.get(92)).setAttribute("horizBase","1" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 91   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(93)).setAttribute("borde","#999999" );
      ((Element)v.get(93)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(93)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(93)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(93)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(93)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(93)).setAttribute("horizBase","#999999" );
      ((Element)v.get(91)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 84   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(94)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(94)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(94)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(94)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(94)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(94)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(84)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","100" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 84   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(96)).setAttribute("alto","20" );
      ((Element)v.get(96)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(96)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(84)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("colFondo","" );
      ((Element)v.get(97)).setAttribute("ID","EstCab" );
      ((Element)v.get(97)).setAttribute("align","center" );
      ((Element)v.get(97)).setAttribute("cod","147" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 84   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(98)).setAttribute("alto","22" );
      ((Element)v.get(98)).setAttribute("accion","" );
      ((Element)v.get(98)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(98)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(98)).setAttribute("maxSel","-1" );
      ((Element)v.get(98)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(98)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(98)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(98)).setAttribute("onLoad","" );
      ((Element)v.get(98)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(84)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("tipo","texto" );
      ((Element)v.get(99)).setAttribute("ID","EstDat" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 84   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(101)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(101)).setAttribute("ancho","683" );
      ((Element)v.get(101)).setAttribute("sep","$" );
      ((Element)v.get(101)).setAttribute("x","12" );
      ((Element)v.get(101)).setAttribute("class","botonera" );
      ((Element)v.get(101)).setAttribute("y","402" );
      ((Element)v.get(101)).setAttribute("control","|" );
      ((Element)v.get(101)).setAttribute("conector","" );
      ((Element)v.get(101)).setAttribute("rowset","" );
      ((Element)v.get(101)).setAttribute("cargainicial","N" );
      ((Element)v.get(101)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(84)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(102)).setAttribute("nombre","ret1" );
      ((Element)v.get(102)).setAttribute("x","37" );
      ((Element)v.get(102)).setAttribute("y","406" );
      ((Element)v.get(102)).setAttribute("ID","botonContenido" );
      ((Element)v.get(102)).setAttribute("img","retroceder_on" );
      ((Element)v.get(102)).setAttribute("tipo","0" );
      ((Element)v.get(102)).setAttribute("estado","false" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(102)).setAttribute("alt","" );
      ((Element)v.get(102)).setAttribute("codigo","" );
      ((Element)v.get(102)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 101   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(103)).setAttribute("nombre","ava1" );
      ((Element)v.get(103)).setAttribute("x","52" );
      ((Element)v.get(103)).setAttribute("y","406" );
      ((Element)v.get(103)).setAttribute("ID","botonContenido" );
      ((Element)v.get(103)).setAttribute("img","avanzar_on" );
      ((Element)v.get(103)).setAttribute("tipo","0" );
      ((Element)v.get(103)).setAttribute("estado","false" );
      ((Element)v.get(103)).setAttribute("alt","" );
      ((Element)v.get(103)).setAttribute("codigo","" );
      ((Element)v.get(103)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(101)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:101   */
      /* Termina nodo:84   */

      /* Empieza nodo:104 / Elemento padre: 24   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(104)).setAttribute("nombre","Modificar" );
      ((Element)v.get(104)).setAttribute("x","80" );
      ((Element)v.get(104)).setAttribute("y","403" );
      ((Element)v.get(104)).setAttribute("ID","botonContenido" );
      ((Element)v.get(104)).setAttribute("tipo","html" );
      ((Element)v.get(104)).setAttribute("estado","false" );
      ((Element)v.get(104)).setAttribute("cod","2" );
      ((Element)v.get(104)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(24)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 24   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(105)).setAttribute("nombre","Consultar" );
      ((Element)v.get(105)).setAttribute("x","80" );
      ((Element)v.get(105)).setAttribute("y","403" );
      ((Element)v.get(105)).setAttribute("ID","botonContenido" );
      ((Element)v.get(105)).setAttribute("tipo","html" );
      ((Element)v.get(105)).setAttribute("estado","false" );
      ((Element)v.get(105)).setAttribute("cod","3" );
      ((Element)v.get(105)).setAttribute("accion","accionConsultar();" );
      ((Element)v.get(24)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 24   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(106)).setAttribute("nombre","Copiar" );
      ((Element)v.get(106)).setAttribute("x","80" );
      ((Element)v.get(106)).setAttribute("y","403" );
      ((Element)v.get(106)).setAttribute("ID","botonContenido" );
      ((Element)v.get(106)).setAttribute("tipo","html" );
      ((Element)v.get(106)).setAttribute("estado","false" );
      ((Element)v.get(106)).setAttribute("cod","721" );
      ((Element)v.get(106)).setAttribute("accion","accionCopiar();" );
      ((Element)v.get(24)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 24   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(107)).setAttribute("nombre","prim1" );
      ((Element)v.get(107)).setAttribute("x","20" );
      ((Element)v.get(107)).setAttribute("y","406" );
      ((Element)v.get(107)).setAttribute("ID","botonContenido" );
      ((Element)v.get(107)).setAttribute("img","primera_on" );
      ((Element)v.get(107)).setAttribute("tipo","-2" );
      ((Element)v.get(107)).setAttribute("estado","false" );
      ((Element)v.get(107)).setAttribute("alt","" );
      ((Element)v.get(107)).setAttribute("codigo","" );
      ((Element)v.get(107)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(24)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 24   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(108)).setAttribute("nombre","separa" );
      ((Element)v.get(108)).setAttribute("x","59" );
      ((Element)v.get(108)).setAttribute("y","402" );
      ((Element)v.get(108)).setAttribute("ID","botonContenido" );
      ((Element)v.get(108)).setAttribute("img","separa_base" );
      ((Element)v.get(108)).setAttribute("tipo","0" );
      ((Element)v.get(108)).setAttribute("estado","false" );
      ((Element)v.get(108)).setAttribute("alt","" );
      ((Element)v.get(108)).setAttribute("codigo","" );
      ((Element)v.get(108)).setAttribute("accion","" );
      ((Element)v.get(24)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:24   */

      /* Empieza nodo:109 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(109)).setAttribute("nombre","capaTapaTodo" );
      ((Element)v.get(109)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(109)).setAttribute("borde","0" );
      ((Element)v.get(109)).setAttribute("visibilidad","" );
      ((Element)v.get(109)).setAttribute("x","12" );
      ((Element)v.get(109)).setAttribute("y","124" );
      ((Element)v.get(109)).setAttribute("ancho","785" );
      ((Element)v.get(109)).setAttribute("alto","320" );
      ((Element)v.get(6)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:6   */


   }

}
