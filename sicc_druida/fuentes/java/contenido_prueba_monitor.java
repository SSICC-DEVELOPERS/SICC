
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_prueba_monitor  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_prueba_monitor" );
      ((Element)v.get(0)).setAttribute("cod","0691" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","init();" );
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
      v.add(doc.createTextNode("\r     \r    \r      var oTable = document.createElement(\"TABLE\");\r      var oThead = document.createElement(\"THEAD\");\r      var oTBody = document.createElement(\"TBODY\");\r      \r      var oRow, oCell;\r      var cantColumnas = 14;\r      var i, j;\r      \r      var rowOculta = new Array();\r       \r    \r      function init(){\r          inicializarLista();\r      \r             \r              insertarDatosLista();\r        \r              \r      }\r    \r      function inicializarLista(){    \r          var colGroup = document.createElement(\"COLGROUP\");    \r          oThead.appendChild(colGroup);    \r          for ( i = 0 ; i < cantColumnas; i++){    \r              var col = document.createElement(\"COL\");    \r              if (i == 0){    \r                  col.width=\"250px\";    \r              }else if (i == 1 || i==2){    \r                  col.width = \"75px\";    \r              }else{    \r                  col.width=\"50px\";    \r              }\r    \r              if (i == 0 || i == 2 || i == 5 || i == 6 || i == 9 || i == 10){    \r                  col.className=\"EstDatEven\";    \r              }else{    \r                  col.className=\"EstDatOdd\";                  \r              }         \r              oThead.appendChild(col);    \r          }    \r          oTable.appendChild(oThead);    \r          oTable.appendChild(oTBody);    \r          oTable.border=0;    \r          oTable.cellSpacing=0;    \r          oTable.cellPadding=0;    \r          oTable.scroll = \"auto\";    \r          oTable.id = \"listado\";    \r          oTable.width = \"100%\";\r          oTableContainer.appendChild(oTable);    \r      }\r\r      function insertarDatosLista(){\r    		  var s = \"1####Consolidado NC - Consultora####12####1012####0########1########0########0########0########1####1####13%%%%0####Consolidado NC - Consultora############0########1########0########0########0########1####0####0%%%%1####Consolidado NC - Consultora####12####1012####0########1########0########0########0########1####1####13%%%%0####Consolidado NC - Consultora############0########1########0########0########0########1####0####0\";\r          var array = parserString(s);\r          for ( i = 0 ; i < array.length; i++){\r              insertarRow(array[i],i);\r              rowOculta [i] = new Array(array[i][0],array[i][14],array[i][15],array[i][16]);\r          }       \r      }\r    \r      \r    \r      function insertarRow(array, index){\r          oRow = document.createElement(\"TR\");\r          oRow.CLASS=\"AlSt\";\r          oRow.height = \"25px\";\r          oTBody.appendChild(oRow);\r          \r          for (var j=1; j<cantColumnas; j++){\r              oCell = document.createElement(\"TD\");\r              oCell.id = \"TD\"+index+j;\r              oCell.indexI = index;\r              oCell.indexJ = j;\r              if (j == 1){\r                  oCell.className=\"BrdNoLeft\";\r                  oCell.width = \"250px\";\r              }else if (j == 2 || j==3){\r                  oCell.width = \"75px\";\r                  oCell.className=\"cabTit\";\r              }else{\r                  oCell.width = \"50px\";\r                  oCell.className=\"BrdWhite\";\r              }\r              if (j == 0 || j == 2 || j == 4 || j == 5 || j == 8 || j == 9 || j == 12 || j == 13){\r                  oCell.className=\"BrdOWhite\";\r              }else{\r                  oCell.className=\"BrdEWhite\";              \r              }  \r              if (array[0] == 1){\r                  if ((j == 5 || j == 7 || j == 9 || j == 11 || j == 13)){\r                      var oInput = document.createElement(\"INPUT\");\r                      oInput.size = \"2\";\r                      oInput.id = \"text\"+index+(j-1);\r                      oInput.className = \"input\";\r                      oInput.onclick = onClickInput;\r                      oInput.indexI = index;\r                      oInput.indexJ = j;\r                      oInput.onmouseover = onmouseoverInput;\r                      oInput.onmouseout = onmouseoutInput;\r                      oCell.appendChild(oInput);\r                  }else{\r                      oCell.onmouseover = pintarcelda;\r                      oCell.onmouseout = unpintarcelda;\r                      if (j >3 ){\r                          oCell.onclick = celdaOnClick;\r                      }\r                      if (array[j] == null || array[j] == ''){\r                          oCell.innerText = \" \";\r                      }else{\r                          oCell.innerText = array[j];\r                      }  \r                  }\r              }else{\r                  if (array[j] == null || array[j] == ''){\r                      oCell.innerText = \" \";\r                  }else{\r                      oCell.innerText = array[j];\r                  }\r                  oCell.onmouseover = pintarcelda;\r                  oCell.onmouseout = unpintarcelda;\r              }\r              \r              if (array[0] == 0){\r                  oRow.style.fontWeight = \"bold\";\r                  oRow.className=\"EstCab\";\r              }\r              oCell.align = \"left\";         \r              oRow.appendChild(oCell);    \r          }    \r      }\r    \r      var celdaClickeada = null;\r    \r      function pintarcelda(){\r          obj = window.event.srcElement;\r          obj.style.backgroundColor = \"D0D9E8\";\r      }\r    \r      function unpintarcelda(){\r          obj = window.event.srcElement;\r          if (obj != celdaClickeada ){\r              obj.style.backgroundColor = \"\";\r          }\r      }      \r    \r      function celdaOnClick(){\r          obj = window.event.srcElement;\r          if (celdaClickeada != null){\r              if (celdaClickeada == obj){\r                  celdaClickeada = null;\r                  obj.style.backgroundColor = \"\";\r              }else{\r                  celdaClickeada.style.backgroundColor = \"\";\r                  celdaClickeada = obj;\r                  obj.style.backgroundColor = \"D0D9E8\";	      \r              }          \r          }else{			  \r              celdaClickeada = obj;\r              obj.style.backgroundColor = \"D0D9E8\";\r          }\r      }\r    \r      function onClickInput(){\r    			obj = window.event.srcElement;\r    			obj.style.backgroundColor = \"\";\r      }\r      \r      function onmouseoverInput(){\r      }\r      \r      function onmouseoutInput(){\r      }      \r    \r      function parserString (s){\r          var array = new Array();\r          var array2 = new Array();\r          var arrayFinal = new Array();\r          array = s.split(\"%%%%\");\r          for ( i = 0 ; i < array.length; i++){\r              array2 = array[i].split(\"####\");\r              arrayFinal[i] = array2;\r          }\r          return arrayFinal;\r      }    \r      \r      function validarDatos(valores){\r          for(i = 0; i < valores.length; i++){\r              if (fValidarNumero(valores[i][0], 3, 1, 100) != 'OK'){\r                    GestionarMensaje(1390);\r                    valores[i][2].focus();\r                    return false;\r              }\r          }\r          return true;\r      }\r    \r      function validaSecuencia(gp){\r    	      var numero = eval((gp*2)+2);\r    	      var datos = new Array();\r    	      j=0;\r    	      for (i = 0; i < rowOculta.length ; i++){\r                if (rowOculta[i][0] == '1'){\r                    obj = eval(\"text\"+i+numero);\r                    dato = obj.value;\r                    if (dato != null && dato != ''){\r                        datos[j] = new Array(dato, i,obj);\r                    }	\r                    j++;\r                }			  \r    	      }\r    	      if (datos.length < 1){\r                if (gp != \"\"){\r                    GestionarMensaje(\"UIPED018\");\r                }else{\r                    GestionarMensaje(\"UIPED027\");\r                }\r                return;\r    	      }\r            \r            if (!validarDatos(datos)){\r                return;\r            }\r    	      datos = ordenarValores(datos);\r    	      if (!verificarRepetidos(datos)){\r                return;\r    	      }\r            var cad = '';\r            var cadCrear = '';  \r            for (j = 0; j < datos.length; j++) {\r                                cad = cad + rowOculta[datos[j][1]][1]+\"|\";                cad = cad + rowOculta[datos[j][1]][2]+\"|\";                cad = cad + rowOculta[datos[j][1]][3]+\"|\";                cad = cad + datos[j][0]+ \"|#|\";                \r                                cadCrear = cadCrear + rowOculta[datos[j][1]][1]+\"|\";                cadCrear = cadCrear + rowOculta[datos[j][1]][3]+\"|\";                cadCrear = cadCrear + datos[j][0]+\"|#|\";            }\r          \r            alert(cad);\r            set('formulario.hTreeGP'+gp,cad);      \r            set('formulario.hCrearGP'+gp,cadCrear); \r          \r            return true;        	      	      \r      }\r      \r      function verificarRepetidos(datos){\r          for (j = 0; j < datos.length-1; j++){\r              if (datos[j][0] == datos[j+1][0]) {\r                GestionarMensaje(\"UIPED005\");\r                return false;\r    \r              }\r          }        \r          return true;\r      }\r      \r      function ordenarValores( valores){    \r          for (i = 0 ; i < (valores.length-1); i++){\r              ordenado = true;\r              for (j = 0 ; j < (valores.length-1); j++){\r                  if (valores[j][0] > valores [i+1][0]){\r                      var aux = valores[j];\r                      valores[j] = valores[j+1];\r                      valores[j+1] = aux;\r                      ordenado = false;\r      	          }\r    		      }\r              if (ordenado == true){\r                  break;\r              }\r          }\r          return valores;\r      }\r      \r       function desglose() {\r          if (celdaClickeada == null){\r              GestionarMensaje('UIPED003');\r              return;\r          }\r          var x = celdaClickeada.indexI;\r          var y = celdaClickeada.indexJ;          \r    \r                    var GP = Math.round( (y-2) /2); \r    \r          dato = cmbDesglose.value;\r          if (dato == null || dato == ''){\r              return;\r          }\r          if (dato == 4 && GP != 2) {\r              GestionarMensaje('UIPED006');\r              return;\r          }\r    \r    \r          var LP;\r    	  \r      	  if( dato == 1 ) LP = 'LPDesgloseTipoSubtipoClasificacion'; \r          else if( dato == 2 ) LP = 'LPDesgloseAccesos'; \r          else if( dato == 3 ) LP = 'LPDesgloseContenido'; \r      	  else if( dato == 4 ) LP = 'LPDesgloseEstados'; \r      	  else{ \r              return; \r          }\r          /* Abrimos un popup modal y direccionamos a la lp indicada por la variable LP, pasandole como parametros: \r          -tipoSolicitud = el valor de la columna oidTipoSolicitud para la fila x \r          -region = el valor de la columna oidRegion para la fila x \r          -zona = el valor de la columna oidZona para la fila x \r          -gp= la variable GP \r          -fechaInicio = el campo oculto fechaInicio de la página \r          -fechaFin = el campo oculto fechaFin de la página\r          */ \r    \r          tipoSolicitud = rowOculta[x][1];\r          region = rowOculta[x][2];\r          zona = rowOculta[x][3];\r    \r          var obj = new Object();\r          obj.accion = '';\r          obj.tipoSolicitud = tipoSolicitud;\r          obj.region = region;\r          obj.zona = zona;\r          obj.gp = GP;\r          obj.tipoDesglose = dato;\r          var winModal = mostrarModalSICC(LP, '', obj, 780, 500);\r      }\r      \r      function crearGrupo() {\r          var cad = \"\";\r          var i;\r        \r          var cantValores;\r          var haySec;\r          var gpConSec = 0;\r          for (i = 1; i < 6; i++) {\r              cantValores = cantValoresSecGP(i);\r              if (cantValores > 0) {\r                  if (haySec) {\r                      GestionarMensaje(\"UIPED017\");\r                      return;\r                  } else {\r                      haySec = true;\r                      gpConSec = i;\r                  }\r              }\r              if (cantValores == -1) \r                  return;                 \r          }\r        \r          if (!haySec) {\r              GestionarMensaje(\"UIPED025\");               return;\r          }\r        \r          if (cdos_trim(get('formulario.txtGrupoReversion')) == \"\") {\r              GestionarMensaje(\"UIPED026\");\r              focaliza('formulario.txtGrupoReversion');\r              return;\r          }\r        \r          var obj = new Object();\r          obj.hListaOidsCrear = get('formulario.hCrearGP'+gpConSec);\r          obj.hGrupoReversion = get('formulario.txtGrupoReversion');\r          obj.hGPRever = gpConSec;   \r          obj.hFechaIni = get('formulario.hFechaIni');   \r          obj.hFechaFin = get('formulario.hFechaFin');   \r          mostrarModalSICC('LPMonitor','CrearGrupoRevesion',obj,740,580);\r      }\r    \r      function reporteFaltantes() {\r          if (!validaSecuencia(2)) \r              return; \r        \r          var obj = new Object();\r          obj.fechaIni = get('formulario.hFechaIni');   \r          obj.fechaFin = get('formulario.hFechaFin');   \r          mostrarModalSICC('LPValidaFaltantes','',obj,740,580);\r      }\r        \r      function generarSecTipificacion() {\r          var obj = new Object();\r          obj.hIdioma = get('formulario.hIdioma');\r          mostrarModalSICC('LPMonitorTipificacion','',obj,720,580);        \r      }\r        \r      function procesoValidacion() {\r          if (!validaSecuencia(1)) \r              return; \r        \r                                              }\r    \r      function revertirProcesos() {\r          if (cdos_trim(get('formulario.txtGrupoReversion')) == \"\") {\r              GestionarMensaje(\"UIPED012\");\r              return;\r          }\r        \r          set('formulario.accion', 'revertirProcesos');\r          set('formulario.conectorAction', 'LPMonitor');\r          set('formulario.hGrupoReversion', get('formulario.txtGrupoReversion'));\r          eval(\"formulario.oculto = 'S'\");\r          enviaSICC('formulario');\r          \r      }\r        \r      function gestionStock() {\r              if (!validaSecuencia(3)) \r                  return; \r            \r              set('formulario.accion', 'gestionStock');\r              set('formulario.conectorAction', 'LPMonitor');\r              set('formulario.hIndTipif', get('formulario.chkTipificacionCliente'));\r              eval(\"formulario.oculto = 'S'\");\r              enviaSICC('formulario');    \r      }\r    \r      function facturar() {\r          if (!validaFechaFact()) \r              return;\r          \r          if (!validaSecuencia(4)) \r              return; \r        \r          if (cdos_trim(get('formulario.txtFechaFacturacion')) == \"\") {\r              GestionarMensaje(\"UIPED013\");\r              return;\r          }\r        \r          set('formulario.accion', 'facturar');\r          set('formulario.conectorAction', 'LPMonitor');\r          set('formulario.hFechaFact', get('formulario.txtFechaFacturacion'));\r          eval(\"formulario.oculto = 'S'\");\r          enviaSICC('formulario');    \r      }\r    \r      function preFacturar() {\r          if (!validaFechaFact()) \r              return;\r          \r          if (!validaSecuencia(4)) \r              return; \r        \r          if (cdos_trim(get('formulario.txtFechaFacturacion')) == \"\") {\r              GestionarMensaje(\"UIPED013\");\r              return;\r          }\r        \r          set('formulario.accion', 'preFacturar');\r          set('formulario.conectorAction', 'LPMonitor');\r          set('formulario.hFechaFact', get('formulario.txtFechaFacturacion'));\r          eval(\"formulario.oculto = 'S'\");\r          enviaSICC('formulario');    \r      }\r    \r      function demandaAnticipada() {\r          if (!validaFechaFact()) \r              return;\r        \r          if (!validaSecuencia(4)) \r              return; \r        \r          if (cdos_trim(get('formulario.txtFechaFacturacion')) == \"\") {\r              GestionarMensaje(\"UIPED013\");\r              return;\r          }\r        \r          cdos_mostrarAlert(\"Esta opción no está disponible en esta versión\");\r      }\r      \r      function alarmaPedidos() {\r          set('formulario.accion', '');\r          set('formulario.conectorAction', 'LPAlarmaPedidos');\r        \r          if (cdos_trim(get('formulario.hFechaFin')) == \"\") \r              set('formulario.hFechaFin', get('formulario.hFechaIni'));\r              \r          eval(\"formulario.oculto = 'N'\");\r          enviaSICC('formulario');    \r      }\r    \r      function validaFechasIniFin() {\r          if (EsFechaValida(get('formulario.txtFechaInicio'),get('formulario.txtFechaInicio'), 'formulario') != 0) {\r              GestionarMensaje('947','formulario.txtFechaInicio');\r              focaliza('formulario.txtFechaInicio')\r              return false;\r          }\r        \r          if (cdos_trim(get('formulario.txtFechaFin')) != \"\") {\r              if (EsFechaValida(get('formulario.txtFechaFin'),get('formulario.txtFechaFin'), 'formulario')  != 0) {\r                  GestionarMensaje('947','formulario.txtFechaFin');\r                  focaliza('formulario.txtFechaFin')\r                  return false;\r              }\r          }        \r          return true;    \r      }\r    \r      function validaFechaFact() {\r          if (EsFechaValida(get('formulario.txtFechaFacturacion'),get('formulario.txtFechaFacturacion'), 'formulario')  != 0) {\r              GestionarMensaje('947','formulario.txtFechaFacturacion');\r                            return false;\r          }\r          return true;\r      }\r    \r     \r    \r  "));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","LPPruebaMonitor" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","valoresLista" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(11)).setAttribute("type","text/css" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));

      /* Elemento padre:11 / Elemento actual: 12   */
      v.add(doc.createTextNode("\r.EstCab {\r            FONT-WEIGHT: bold; FONT-SIZE: 9px; VERTICAL-ALIGN: middle; COLOR: black; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; TEXT-ALIGN: center; TEXT-DECORATION: none; \r}\r \r.input { font-family: Verdana, Arial, Helvetica; color:black; font-size:10px; border: 1 solid #000000; font-weight:bold;  cursor: auto; background : white;} \r \r\rTR.AlSt {\r            HEIGHT: 22px\r}\r\rTD.BrdNoLeft {\r            BORDER-BOTTOM: #ffffff 1px solid; BORDER-LEFT-STYLE: none\r}\r\rTD.BrdWhite {\r            BORDER-LEFT: #ffffff 1px solid; BORDER-BOTTOM: #ffffff 1px solid  \r}\r\rTD.BrdRWhite {\r            BORDER-RIGHT: #e0e0e0 1px solid; PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px\r}\r\rTD.BrdInf {\r            BORDER-BOTTOM: #999999 1px solid\r}\r\r.botonContenido {  font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; font-weight: normal; color: #FFFFFF; background-color: #4A699C; border-color: #D0F7FD #333366 #4A699C #D0F7FD; border-style: outset}\r\r.BrdNoLeft {\r            BORDER-BOTTOM: #ffffff 1px solid; BORDER-LEFT-STYLE: none PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #f0f0f0\r}\r\r.BrdEWhite {\r            BORDER-LEFT: #ffffff 1px solid; BORDER-BOTTOM: #ffffff 1px solid PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #f0f0f0\r}\r\r.BrdOWhite {\r\r            BORDER-LEFT: #ffffff 1px solid; BORDER-BOTTOM: #ffffff 1px solid PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #e0e0e0\r\r}\r\r.BrdPWhite {\r\r            BORDER-LEFT: #ffffff 1px solid; BORDER-BOTTOM: #ffffff 1px solid PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: blue\r\r}\r\r.BrdRWhite {\r\r            BORDER-RIGHT: #e0e0e0 1px solid; PADDING-RIGHT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #cecfce\r\r}\r\r.BrdInf {\r\r            BORDER-BOTTOM: #999999 1px solid\r\r}\r\rTD.cabTit {\r\r            PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; WIDTH: 10px; PADDING-TOP: 0px\r\r}\r\rTABLE.cabTit {\r\r            WIDTH: 100%; BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: none\r\r}\r"));
      ((Element)v.get(11)).appendChild((Text)v.get(12));

      /* Termina nodo Texto:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(13)).setAttribute("nombre","capa1" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(14)).setAttribute("style","BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; BORDER-LEFT: #999999 1px solid; WIDTH: 98%; BORDER-BOTTOM: #999999 1px solid" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(15)).setAttribute("style","TABLE-LAYOUT: fixed" );
      ((Element)v.get(15)).setAttribute("cellSpacing","0" );
      ((Element)v.get(15)).setAttribute("cellPadding","0" );
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("bgColor","#cecfce" );
      ((Element)v.get(15)).setAttribute("border","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(17)).setAttribute("class","AlSt" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(18)).setAttribute("class","BrdInf EstCab" );
      ((Element)v.get(18)).setAttribute("style","PADDING-LEFT: 5px; TEXT-ALIGN: left" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Elemento padre:18 / Elemento actual: 19   */
      v.add(doc.createTextNode("Resultado de búsqueda"));
      ((Element)v.get(18)).appendChild((Text)v.get(19));

      /* Termina nodo Texto:19   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:20 / Elemento padre: 16   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(20)).setAttribute("class","AlSt" );
      ((Element)v.get(16)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(21)).setAttribute("class","BrdInf" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(22)).setAttribute("style","BORDER-COLLAPSE: collapse; HEIGHT: 100%" );
      ((Element)v.get(22)).setAttribute("cellSpacing","0" );
      ((Element)v.get(22)).setAttribute("cellPadding","0" );
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(24)).setAttribute("class","EstCab" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(25)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(25)).setAttribute("width","250px" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(26)).setAttribute("class","cabTit" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(29)).setAttribute("class","EstCab" );
      ((Element)v.get(29)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Elemento padre:29 / Elemento actual: 30   */
      v.add(doc.createTextNode("\r                                Tipo solicitud\r                              "));
      ((Element)v.get(29)).appendChild((Text)v.get(30));

      /* Termina nodo Texto:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(31)).setAttribute("class","cabTit" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:32 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(32)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(32)).setAttribute("width","75px" );
      ((Element)v.get(24)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(33)).setAttribute("class","cabTit" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(36)).setAttribute("class","EstCab" );
      ((Element)v.get(36)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Elemento padre:36 / Elemento actual: 37   */
      v.add(doc.createTextNode("\r                                Región\r                              "));
      ((Element)v.get(36)).appendChild((Text)v.get(37));

      /* Termina nodo Texto:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(38)).setAttribute("class","cabTit" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:39 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(39)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(39)).setAttribute("width","75px" );
      ((Element)v.get(24)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(40)).setAttribute("class","cabTit" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(43)).setAttribute("class","EstCab" );
      ((Element)v.get(43)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Elemento padre:43 / Elemento actual: 44   */
      v.add(doc.createTextNode("\r                                Zona\r                              "));
      ((Element)v.get(43)).appendChild((Text)v.get(44));

      /* Termina nodo Texto:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(45)).setAttribute("class","cabTit" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:46 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(46)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(46)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(47)).setAttribute("class","cabTit" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(50)).setAttribute("class","EstCab" );
      ((Element)v.get(50)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Elemento padre:50 / Elemento actual: 51   */
      v.add(doc.createTextNode("\r                                GP1\r                              "));
      ((Element)v.get(50)).appendChild((Text)v.get(51));

      /* Termina nodo Texto:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(52)).setAttribute("class","cabTit" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:53 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(53)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(53)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(54)).setAttribute("class","cabTit" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(57)).setAttribute("class","EstCab" );
      ((Element)v.get(57)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Elemento padre:57 / Elemento actual: 58   */
      v.add(doc.createTextNode("\r                                GP1\r                              "));
      ((Element)v.get(57)).appendChild((Text)v.get(58));

      /* Termina nodo Texto:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(59)).setAttribute("class","cabTit" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:60 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(60)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(60)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(61)).setAttribute("class","cabTit" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(64)).setAttribute("class","EstCab" );
      ((Element)v.get(64)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Elemento padre:64 / Elemento actual: 65   */
      v.add(doc.createTextNode("\r                                GP2\r                              "));
      ((Element)v.get(64)).appendChild((Text)v.get(65));

      /* Termina nodo Texto:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(66)).setAttribute("class","cabTit" );
      ((Element)v.get(63)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:67 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(67)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(67)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(68)).setAttribute("class","cabTit" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(71)).setAttribute("class","EstCab" );
      ((Element)v.get(71)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Elemento padre:71 / Elemento actual: 72   */
      v.add(doc.createTextNode("\r                                GP2\r                              "));
      ((Element)v.get(71)).appendChild((Text)v.get(72));

      /* Termina nodo Texto:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("class","cabTit" );
      ((Element)v.get(70)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:74 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(74)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(74)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(75)).setAttribute("class","cabTit" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(78)).setAttribute("class","EstCab" );
      ((Element)v.get(78)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Elemento padre:78 / Elemento actual: 79   */
      v.add(doc.createTextNode("\r                                GP3\r                              "));
      ((Element)v.get(78)).appendChild((Text)v.get(79));

      /* Termina nodo Texto:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(80)).setAttribute("class","cabTit" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:81 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(81)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(81)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(82)).setAttribute("class","cabTit" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(85)).setAttribute("class","EstCab" );
      ((Element)v.get(85)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Elemento padre:85 / Elemento actual: 86   */
      v.add(doc.createTextNode("\r                                GP3\r                              "));
      ((Element)v.get(85)).appendChild((Text)v.get(86));

      /* Termina nodo Texto:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("class","cabTit" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(84)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:88 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(88)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(88)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(89)).setAttribute("class","cabTit" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(92)).setAttribute("class","EstCab" );
      ((Element)v.get(92)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Elemento padre:92 / Elemento actual: 93   */
      v.add(doc.createTextNode("\r                                GP4\r                              "));
      ((Element)v.get(92)).appendChild((Text)v.get(93));

      /* Termina nodo Texto:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(94)).setAttribute("class","cabTit" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:95 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(95)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(96)).setAttribute("class","cabTit" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(99)).setAttribute("class","EstCab" );
      ((Element)v.get(99)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Elemento padre:99 / Elemento actual: 100   */
      v.add(doc.createTextNode("\r                                GP4\r                              "));
      ((Element)v.get(99)).appendChild((Text)v.get(100));

      /* Termina nodo Texto:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(101)).setAttribute("class","cabTit" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:102 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(102)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(103)).setAttribute("class","cabTit" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(106)).setAttribute("class","EstCab" );
      ((Element)v.get(106)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Elemento padre:106 / Elemento actual: 107   */
      v.add(doc.createTextNode("\r                                GP5\r                              "));
      ((Element)v.get(106)).appendChild((Text)v.get(107));

      /* Termina nodo Texto:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(108)).setAttribute("class","cabTit" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:109 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(109)).setAttribute("width","50px" );
      ((Element)v.get(24)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(110)).setAttribute("class","cabTit" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(113)).setAttribute("class","EstCab" );
      ((Element)v.get(113)).setAttribute("style","PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Elemento padre:113 / Elemento actual: 114   */
      v.add(doc.createTextNode("\r                                GP5\r                              "));
      ((Element)v.get(113)).appendChild((Text)v.get(114));

      /* Termina nodo Texto:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).setAttribute("class","cabTit" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:116 / Elemento padre: 16   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(16)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(117)).setAttribute("class","BrdInf" );
      ((Element)v.get(117)).setAttribute("style","HEIGHT: 248px" );
      ((Element)v.get(117)).setAttribute("vAlign","top" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("div"));
      ((Element)v.get(118)).setAttribute("id","oTableContainer" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(118)).setAttribute("style","WIDTH: 100%; POSITION: relative; HEIGHT: 100% " );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 16   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(119)).setAttribute("class","AlSt" );
      ((Element)v.get(16)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("INPUT"));
      ((Element)v.get(121)).setAttribute("id","refrescar" );
      ((Element)v.get(121)).setAttribute("type","button" );
      ((Element)v.get(121)).setAttribute("value","Refrescar" );
      ((Element)v.get(121)).setAttribute("class","botonContenido" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 120   */
      v.add(doc.createElement("select"));
      ((Element)v.get(122)).setAttribute("id","cmbDesglose" );
      ((Element)v.get(122)).setAttribute("size","1" );
      ((Element)v.get(120)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("option"));
      ((Element)v.get(123)).setAttribute("value","" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 122   */
      v.add(doc.createElement("option"));
      ((Element)v.get(124)).setAttribute("value","2" );
      ((Element)v.get(122)).appendChild((Element)v.get(124));

      /* Elemento padre:124 / Elemento actual: 125   */
      v.add(doc.createTextNode("Desglose por acceso"));
      ((Element)v.get(124)).appendChild((Text)v.get(125));

      /* Termina nodo Texto:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 122   */
      v.add(doc.createElement("option"));
      ((Element)v.get(126)).setAttribute("value","3" );
      ((Element)v.get(122)).appendChild((Element)v.get(126));

      /* Elemento padre:126 / Elemento actual: 127   */
      v.add(doc.createTextNode("Desglose por contenido"));
      ((Element)v.get(126)).appendChild((Text)v.get(127));

      /* Termina nodo Texto:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 122   */
      v.add(doc.createElement("option"));
      ((Element)v.get(128)).setAttribute("value","4" );
      ((Element)v.get(122)).appendChild((Element)v.get(128));

      /* Elemento padre:128 / Elemento actual: 129   */
      v.add(doc.createTextNode("Desglose por estado"));
      ((Element)v.get(128)).appendChild((Text)v.get(129));

      /* Termina nodo Texto:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 122   */
      v.add(doc.createElement("option"));
      ((Element)v.get(130)).setAttribute("value","1" );
      ((Element)v.get(122)).appendChild((Element)v.get(130));

      /* Elemento padre:130 / Elemento actual: 131   */
      v.add(doc.createTextNode("Desglose por tipo, subtipo y clasificación cliente"));
      ((Element)v.get(130)).appendChild((Text)v.get(131));

      /* Termina nodo Texto:131   */
      /* Termina nodo:130   */
      /* Termina nodo:122   */

      /* Empieza nodo:132 / Elemento padre: 120   */
      v.add(doc.createElement("input"));
      ((Element)v.get(132)).setAttribute("id","Desglose" );
      ((Element)v.get(132)).setAttribute("type","button" );
      ((Element)v.get(132)).setAttribute("value","Desglose" );
      ((Element)v.get(132)).setAttribute("class","botonContenido" );
      ((Element)v.get(132)).setAttribute("onclick","desglose();" );
      ((Element)v.get(120)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:133 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(133)).setAttribute("id","btnValidacion" );
      ((Element)v.get(133)).setAttribute("type","button" );
      ((Element)v.get(133)).setAttribute("value","validacion" );
      ((Element)v.get(133)).setAttribute("onclick","procesoValidacion();" );
      ((Element)v.get(13)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(134)).setAttribute("id","btnReportes" );
      ((Element)v.get(134)).setAttribute("type","button" );
      ((Element)v.get(134)).setAttribute("value","Reportes" );
      ((Element)v.get(134)).setAttribute("onclick","reporteFaltantes();" );
      ((Element)v.get(13)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(135)).setAttribute("id","btnStock" );
      ((Element)v.get(135)).setAttribute("type","button" );
      ((Element)v.get(135)).setAttribute("value","Stock" );
      ((Element)v.get(135)).setAttribute("onclick","gestionStock();" );
      ((Element)v.get(13)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(136)).setAttribute("id","btnFacturar" );
      ((Element)v.get(136)).setAttribute("type","button" );
      ((Element)v.get(136)).setAttribute("value","Facturar" );
      ((Element)v.get(136)).setAttribute("onclick","facturar();" );
      ((Element)v.get(13)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(137)).setAttribute("id","btnFacturar" );
      ((Element)v.get(137)).setAttribute("type","button" );
      ((Element)v.get(137)).setAttribute("value","CrearGrupo" );
      ((Element)v.get(137)).setAttribute("onclick","crearGrupo();" );
      ((Element)v.get(13)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(138)).setAttribute("id","btnFacturar" );
      ((Element)v.get(138)).setAttribute("type","button" );
      ((Element)v.get(138)).setAttribute("value","PreFacturar" );
      ((Element)v.get(138)).setAttribute("onclick","preFacturar();" );
      ((Element)v.get(13)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(139)).setAttribute("id","btnFacturar" );
      ((Element)v.get(139)).setAttribute("type","button" );
      ((Element)v.get(139)).setAttribute("value","Alarma Pedidos" );
      ((Element)v.get(139)).setAttribute("onclick","alarmaPedidos();" );
      ((Element)v.get(13)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(140)).setAttribute("id","btnFacturar" );
      ((Element)v.get(140)).setAttribute("type","button" );
      ((Element)v.get(140)).setAttribute("value","generarSecTipificacion" );
      ((Element)v.get(140)).setAttribute("onclick","generarSecTipificacion();" );
      ((Element)v.get(13)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(141)).setAttribute("id","btnFacturar" );
      ((Element)v.get(141)).setAttribute("type","button" );
      ((Element)v.get(141)).setAttribute("value","Revertir" );
      ((Element)v.get(141)).setAttribute("onclick","revertirProcesos();" );
      ((Element)v.get(13)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(142)).setAttribute("id","btnFacturar" );
      ((Element)v.get(142)).setAttribute("type","button" );
      ((Element)v.get(142)).setAttribute("value","demandaAnticipada" );
      ((Element)v.get(142)).setAttribute("onclick","demandaAnticipada();" );
      ((Element)v.get(13)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 13   */
      v.add(doc.createElement("input"));
      ((Element)v.get(143)).setAttribute("id","txtFechaFacturacion" );
      ((Element)v.get(143)).setAttribute("type","text" );
      ((Element)v.get(143)).setAttribute("size","10" );
      ((Element)v.get(13)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:13   */
      /* Termina nodo:4   */


   }

}
