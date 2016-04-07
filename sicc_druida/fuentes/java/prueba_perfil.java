
import org.w3c.dom.*;
import java.util.ArrayList;

public class prueba_perfil  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","prueba_perfil" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","051" );
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
      v.add(doc.createTextNode("\r  \r\r  function onLoadPag()   {  \r    alert(\"Entre a prueba perfil\");\r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"prim1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"separa1Div\"].style.visibility='';\r    eval (ON_RSZ);\r    init();\r   }\r\r   function init() {      \r      configurarMenuSecundario(\"frmContenido\");\r      var casoUso = get(\"frmContenido.casoUso\");\r      \r      if(casoUso==\"insertar\") {\r        var nom = get(\"frmContenido.varNombre\");\r        set(\"frmContenido.txtPerfil\", nom);\r        focaliza(\"frmContenido.txtPerfil\");   \r        var exitoInserta = get(\"frmContenido.varExitoInserta\");         \r        if(exitoInserta == \"Exito\") {\r          fMostrarMensajeExito(\"insertar\");                 set(\"frmContenido.varExitoInserta\", \"\");       \r          var copia = get(\"frmContenido.varCopiar\");\r          if(copia==\"copiando\") {\r            window.close();\r          }          \r        }  \r      }\r\r      if(casoUso==\"consultar\") {\r                var nom = get(\"frmContenido.varNombre\");\r        set(\"frmContenido.txtPerfil\", nom);        \r        accion(\"frmContenido.txtPerfil\", \".disabled=true\");\r        document.all[\"capaPrincipal\"].style.display='none';\r        document.all[\"miscroll\"].style.display='none';\r      }\r  \r      if(casoUso==\"modificar\") {\r                var nom = get(\"frmContenido.varNombre\");\r        set(\"frmContenido.txtPerfil\", nom);        \r        accion(\"frmContenido.txtPerfil\", \".disabled=true\");      \r\r        var exitoModifica = get(\"frmContenido.varExitoModifica\");\r                if(exitoModifica ==\"Exito\") {\r                    fMostrarMensajeExito(\"modificar\");\r          set(\"frmContenido.varExitoModifica\", \"\");                           window.close();\r        }     \r      }     \r      \r      var bErrores = hayErrores(); \r      if (bErrores == true) {\r        return;\r    	}    \r    }\r\r    function hayErrores() {\r        var codigoError = get(\"frmContenido.errCodigo\");\r        var descError = get(\"frmContenido.errDescripcion\");\r\r        if (codigoError == \"\") {\r          return false;\r        }\r                else {\r          var casoUso = get(\"frmContenido.casoUso\");      \r          var copy = get(\"frmContenido.varCopiar\");\r\r          if(casoUso==\"insertar\") {\r            fMostrarMensajeError(codigoError, descError);\r            window.close();\r            return;\r          }\r\r          if(casoUso==\"consultar\") {\r            fMostrarMensajeError(codigoError, descError);\r            window.close();\r            return;\r          }\r\r          if(casoUso==\"modificar\") {\r            fMostrarMensajeError(codigoError, descError);\r            window.close();\r            return;\r          }\r\r          if(copy==\"copiando\") {\r            fMostrarMensajeError(codigoError, descError);\r            window.close();\r            return;\r          }         \r        \r          fMostrarMensajeError(codigoError, descError);    \r          set(\"frmContenido.conectorAction\", \"LPPerfiles\");          \r          set(\"frmContenido.accion\", \"\");      \r          enviaSICC(\"frmContenido\");    \r          return true;\r        }\r    }\r\r   function validaNombrePerfil(valor) {\r      var permitidos = \"0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz\";\r      var c;\r      for(var i=0; i<valor.length; i++) {\r          c = valor.charAt(i);\r          if (permitidos.indexOf(c) == -1 )	return false;\r      }\r      return true;\r   }\r\r   function accionGuardar() {\r      alert(\"Entre a accionGuardar\");\r                                    \r      var casoUso = get(\"frmContenido.casoUso\");\r      alert(\"casoUso: \" + casoUso);\r      if(casoUso==\"insertar\") {      \r                                var nomb = get(\"frmContenido.txtPerfil\");\r        if(nomb==\"\") {\r          GestionarMensaje(\"1065\", null, null, null);\r          focaliza(\"frmContenido.txtPerfil\",\"\");\r          return false;\r        }      \r\r                        var nombre = get(\"frmContenido.txtPerfil\");\r        var valnom = validaNombrePerfil(nombre);\r        if (valnom != true) {\r          GestionarMensaje(\"1086\", null, null, null);\r          focaliza(\"frmContenido.txtPerfil\",\"\");\r          return false;\r        }\r      }     \r\r      var listadoDatos = listado1.datos;\r			var cantCodigos = listado1.codigos().length;\r            \r      			for ( var i = 0; i < cantCodigos; i++) {\r					if (listadoDatos[i][2] == \"S\") {\r            var codigo = listadoDatos[i][0];\r          }          \r      }\r\r      alert(\"codigo: \" + codigo);\r\r            arrayFunc = listado1.codigos();\r\r      alert(\"arrayFunc \" + arrayFunc);\r      if(codigo==undefined) {       \r        alert(\"Codigo es undefined\");\r        set(\"frmContenido.inicio\",\"null\");  \r      }\r      else {\r        alert(\"Codigo no es undefined\");\r        set(\"frmContenido.inicio\",codigo);\r      }\r\r      var nombrePerfil;\r\r      if(casoUso==\"insertar\") {\r        alert(\"Entre por caso de uso insertar\");\r        nombrePerfil = get(\"frmContenido.txtPerfil\");  \r        alert(\"nombrePerfil \" + nombrePerfil);\r      }     \r      if(casoUso==\"modificar\") {\r        alert(\"Entre por caso de uso modificar\");\r        nombrePerfil = get(\"frmContenido.varNombre\");\r        alert(\"nombrePerfil \" + nombrePerfil);\r      }         \r    \r      alert(\"Variable inicio \");\r      \r      var valorCopia = get(\"frmContenido.varCopiar\");      \r      set(\"frmContenido.conectorAction\", \"LPPerfiles\");\r      set(\"frmContenido.funciones\",arrayFunc);      \r      set(\"frmContenido.accion\",\"guardar\");\r      set(\"frmContenido.varNombre\",nombrePerfil);\r      set(\"frmContenido.varCopiar\",valorCopia);\r      alert(\"Antes de enviar el formulario\");\r      enviaSICC(\"frmContenido\");\r   }\r   \r   function seleccionarFuncion(oid, nombre) {\r                        \r      var arrayVerificRepe = new Array();\r      arrayVerificRepe = listado1.codigos();\r\r            for(var i=0; i<arrayVerificRepe.length; i++) {\r        if (arrayVerificRepe[i] == oid) {\r          return false;\r        }\r      }\r      var ruta = obtengoRuta(oid);\r      agregarFuncion(oid, ruta);\r   }\r\r   function obtengoRuta(nId) {  \r      var cRuta;\r      var cOrig;\r      var arrayRutaOrig = new Array();\r      cRuta = \"Menu/\";\r\r      for(var i=0; i<name1.entradas.length; i++) {\r                if (name1.entradas[i][2] == nId) {\r          cOrig = name1.entradas[i][0];\r          arrayRutaOrig = cOrig.split(\".name\");\r                    for(var j=0; j<arrayRutaOrig.length; j++) {\r            for(var h=0; h<name1.entradas.length; h++) {\r              if (arrayRutaOrig[j] == name1.entradas[h][2]) {\r                                cRuta = cRuta + name1.entradas[h][3] + '/';\r                break;\r              } \r            }\r          } \r        }\r      }\r      cRuta = cRuta.substr(0, (cRuta.length-1));\r      return cRuta;\r    }\r\r   function agregarFuncion(oid, ruta) {      \r                                                      agregarFila(oid,ruta);\r   }\r\r   function agregarFila(oid,ruta) {\r      var nuevaFila = new Array();\r      \r      nuevaFila[0] = oid;			\r			nuevaFila[1] = ruta;			\r			nuevaFila[2] = \"N\";\r      \r			listado1.insertar(nuevaFila);\r    }\r\r   function fGuardar() {\r      accionGuardar();      \r   }\r\r   function inicioOnChange(filaCambiada) {\r      alert(\"Entre a inicioOnChange\");      \r      var caso = get(\"frmContenido.casoUso\");\r      alert(\"caso: \" + caso);\r      if(caso==\"consultar\") {\r        alert(\"Entre al if por consultar\");\r        listado1.repintaDat();\r        return;\r      }\r   \r                     \r      			listado1.actualizaDat();\r			var listadoDatos = listado1.datos;\r			var cantCodigos = listado1.codigos().length;\r			\r			listado1.actualizaDat();\r\r			for ( var i = 0; i < cantCodigos; i++) {\r					if ( i != filaCambiada)\r            listadoDatos[i][2] = \"N\";\r      }			\r			listado1.setDatos(listadoDatos); 			\r    }\r\r    function focalizaNombre() {\r      focaliza(\"frmContenido.txtPerfil\");\r    }\r\r    function fBorrar() {\r            if (listado1.numSelecc()== 0) {\r        GestionarMensaje('1021',null,null,null);\r        return false;\r      }    \r      listado1.eliminarSelecc();         \r    }\r    \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","nombreArbol" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","casoUso" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","inicio" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
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
      ((Element)v.get(16)).setAttribute("nombre","varExitoInserta" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","varExitoModifica" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","varNombre" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","varCopiar" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","varUnaVariable" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(21)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(21)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(21)).setAttribute("borde","0" );
      ((Element)v.get(21)).setAttribute("visibilidad","" );
      ((Element)v.get(21)).setAttribute("x","0" );
      ((Element)v.get(21)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","750" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","1" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:23   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(35)).setAttribute("class","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(36)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(36)).setAttribute("alto","13" );
      ((Element)v.get(36)).setAttribute("filas","1" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(36)).setAttribute("id","legend" );
      ((Element)v.get(36)).setAttribute("cod","0075" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","721" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","left" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("colspan","4" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblPerfil" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","146" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","8" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:44   */

      /* Empieza nodo:51 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(55)).setAttribute("nombre","txtPerfil" );
      ((Element)v.get(55)).setAttribute("id","datosCampos" );
      ((Element)v.get(55)).setAttribute("max","25" );
      ((Element)v.get(55)).setAttribute("tipo","" );
      ((Element)v.get(55)).setAttribute("onchange","" );
      ((Element)v.get(55)).setAttribute("req","S" );
      ((Element)v.get(55)).setAttribute("size","35" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("validacion","" );
      ((Element)v.get(55)).setAttribute("ontab","focalizaNombre();" );
      ((Element)v.get(55)).setAttribute("onshtab","focalizaNombre();" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(51)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:51   */

      /* Empieza nodo:58 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("colspan","4" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:61 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:30   */

      /* Empieza nodo:63 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","12" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","12" );
      ((Element)v.get(65)).setAttribute("height","12" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","750" );
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","12" );
      ((Element)v.get(63)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","12" );
      ((Element)v.get(69)).setAttribute("height","1" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:63   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:70 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(70)).setAttribute("nombre","capaPrincipal" );
      ((Element)v.get(70)).setAttribute("x","0" );
      ((Element)v.get(70)).setAttribute("y","81" );
      ((Element)v.get(6)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("cellpadding","0" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("height","12" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","750" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(72)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("height","1" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:72   */

      /* Empieza nodo:79 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(84)).setAttribute("class","legend" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(85)).setAttribute("nombre","lblListaFunciones" );
      ((Element)v.get(85)).setAttribute("alto","13" );
      ((Element)v.get(85)).setAttribute("filas","1" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(85)).setAttribute("id","legend" );
      ((Element)v.get(85)).setAttribute("cod","00505" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("table"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(86)).setAttribute("border","0" );
      ((Element)v.get(86)).setAttribute("align","center" );
      ((Element)v.get(86)).setAttribute("cellspacing","0" );
      ((Element)v.get(86)).setAttribute("cellpadding","0" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","230" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","713" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:92 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:79   */

      /* Empieza nodo:94 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","12" );
      ((Element)v.get(95)).setAttribute("align","center" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","12" );
      ((Element)v.get(96)).setAttribute("height","12" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","756" );
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","12" );
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","12" );
      ((Element)v.get(100)).setAttribute("height","1" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:94   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:101 / Elemento padre: 6   */
      v.add(doc.createElement("SCROLL"));
      ((Element)v.get(101)).setAttribute("nombre","miscroll" );
      ((Element)v.get(101)).setAttribute("x","22" );
      ((Element)v.get(101)).setAttribute("y","70" );
      ((Element)v.get(101)).setAttribute("ancho","700" );
      ((Element)v.get(101)).setAttribute("alto","250" );
      ((Element)v.get(101)).setAttribute("colorf","" );
      ((Element)v.get(101)).setAttribute("visibilidad","visible" );
      ((Element)v.get(101)).setAttribute("incx","10" );
      ((Element)v.get(101)).setAttribute("incy","10" );
      ((Element)v.get(101)).setAttribute("colores","" );
      ((Element)v.get(6)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(102)).setAttribute("nombre","RArbol" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(103)).setAttribute("nombre","listado1" );
      ((Element)v.get(103)).setAttribute("ancho","724" );
      ((Element)v.get(103)).setAttribute("alto","299" );
      ((Element)v.get(103)).setAttribute("x","12" );
      ((Element)v.get(103)).setAttribute("y","362" );
      ((Element)v.get(103)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(103)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(104)).setAttribute("precarga","S" );
      ((Element)v.get(104)).setAttribute("conROver","S" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(105)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(105)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(105)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(105)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 104   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(106)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(106)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(106)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(106)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(104)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(107)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(107)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:104   */

      /* Empieza nodo:108 / Elemento padre: 103   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(103)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(109)).setAttribute("borde","1" );
      ((Element)v.get(109)).setAttribute("horizDatos","1" );
      ((Element)v.get(109)).setAttribute("horizCabecera","1" );
      ((Element)v.get(109)).setAttribute("vertical","1" );
      ((Element)v.get(109)).setAttribute("horizTitulo","1" );
      ((Element)v.get(109)).setAttribute("horizBase","1" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 108   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(110)).setAttribute("borde","#999999" );
      ((Element)v.get(110)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(110)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(110)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(110)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(110)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(110)).setAttribute("horizBase","#999999" );
      ((Element)v.get(108)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:108   */

      /* Empieza nodo:111 / Elemento padre: 103   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(111)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(111)).setAttribute("alto","22" );
      ((Element)v.get(111)).setAttribute("imgFondo","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(111)).setAttribute("cod","00521" );
      ((Element)v.get(111)).setAttribute("ID","datosTitle" );
      ((Element)v.get(103)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 103   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(112)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(112)).setAttribute("alto","22" );
      ((Element)v.get(112)).setAttribute("imgFondo","" );
      ((Element)v.get(103)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 103   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(113)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(113)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(113)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(113)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(113)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(113)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(103)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("ancho","330" );
      ((Element)v.get(114)).setAttribute("minimizable","S" );
      ((Element)v.get(114)).setAttribute("minimizada","N" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("ancho","55" );
      ((Element)v.get(115)).setAttribute("minimizable","S" );
      ((Element)v.get(115)).setAttribute("minimizada","N" );
      ((Element)v.get(113)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 103   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(116)).setAttribute("alto","20" );
      ((Element)v.get(116)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(116)).setAttribute("imgFondo","" );
      ((Element)v.get(116)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(103)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","2243" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).setAttribute("cod","149" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 103   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(119)).setAttribute("alto","22" );
      ((Element)v.get(119)).setAttribute("accion","" );
      ((Element)v.get(119)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(119)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(119)).setAttribute("maxSel","-1" );
      ((Element)v.get(119)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(119)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(119)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(119)).setAttribute("onLoad","" );
      ((Element)v.get(119)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(103)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("tipo","texto" );
      ((Element)v.get(120)).setAttribute("ID","EstDat" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 119   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("tipo","checkbox" );
      ((Element)v.get(121)).setAttribute("onchange","inicioOnChange(FILAEVENTO);" );
      ((Element)v.get(121)).setAttribute("nombre","chkInicio" );
      ((Element)v.get(121)).setAttribute("ID","EstDat2" );
      ((Element)v.get(119)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:119   */

      /* Empieza nodo:122 / Elemento padre: 103   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(103)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 103   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(123)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(123)).setAttribute("ancho","724" );
      ((Element)v.get(123)).setAttribute("sep","$" );
      ((Element)v.get(123)).setAttribute("x","12" );
      ((Element)v.get(123)).setAttribute("class","botonera" );
      ((Element)v.get(123)).setAttribute("y","638" );
      ((Element)v.get(123)).setAttribute("control","|" );
      ((Element)v.get(123)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(123)).setAttribute("rowset","" );
      ((Element)v.get(123)).setAttribute("cargainicial","N" );
      ((Element)v.get(103)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(124)).setAttribute("nombre","ret1" );
      ((Element)v.get(124)).setAttribute("x","37" );
      ((Element)v.get(124)).setAttribute("y","642" );
      ((Element)v.get(124)).setAttribute("ID","botonContenido" );
      ((Element)v.get(124)).setAttribute("img","retroceder_on" );
      ((Element)v.get(124)).setAttribute("tipo","0" );
      ((Element)v.get(124)).setAttribute("estado","false" );
      ((Element)v.get(124)).setAttribute("alt","" );
      ((Element)v.get(124)).setAttribute("codigo","" );
      ((Element)v.get(124)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 123   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(125)).setAttribute("nombre","ava1" );
      ((Element)v.get(125)).setAttribute("x","52" );
      ((Element)v.get(125)).setAttribute("y","642" );
      ((Element)v.get(125)).setAttribute("ID","botonContenido" );
      ((Element)v.get(125)).setAttribute("img","avanzar_on" );
      ((Element)v.get(125)).setAttribute("tipo","0" );
      ((Element)v.get(125)).setAttribute("estado","false" );
      ((Element)v.get(125)).setAttribute("alt","" );
      ((Element)v.get(125)).setAttribute("codigo","" );
      ((Element)v.get(125)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(123)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:123   */
      /* Termina nodo:103   */

      /* Empieza nodo:126 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(126)).setAttribute("nombre","prim1" );
      ((Element)v.get(126)).setAttribute("x","20" );
      ((Element)v.get(126)).setAttribute("y","642" );
      ((Element)v.get(126)).setAttribute("ID","botonContenido" );
      ((Element)v.get(126)).setAttribute("img","primera_on" );
      ((Element)v.get(126)).setAttribute("tipo","0" );
      ((Element)v.get(126)).setAttribute("estado","false" );
      ((Element)v.get(126)).setAttribute("alt","" );
      ((Element)v.get(126)).setAttribute("codigo","" );
      ((Element)v.get(126)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(127)).setAttribute("nombre","separa1" );
      ((Element)v.get(127)).setAttribute("x","59" );
      ((Element)v.get(127)).setAttribute("y","638" );
      ((Element)v.get(127)).setAttribute("ID","botonContenido" );
      ((Element)v.get(127)).setAttribute("img","separa_base" );
      ((Element)v.get(127)).setAttribute("tipo","0" );
      ((Element)v.get(127)).setAttribute("estado","false" );
      ((Element)v.get(127)).setAttribute("alt","" );
      ((Element)v.get(127)).setAttribute("codigo","" );
      ((Element)v.get(127)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(128)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(128)).setAttribute("colorf","" );
      ((Element)v.get(128)).setAttribute("borde","0" );
      ((Element)v.get(128)).setAttribute("visibilidad","" );
      ((Element)v.get(128)).setAttribute("x","0" );
      ((Element)v.get(128)).setAttribute("y","661" );
      ((Element)v.get(128)).setAttribute("ancho","50" );
      ((Element)v.get(128)).setAttribute("alto","12" );
      ((Element)v.get(6)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:6   */


   }

}
