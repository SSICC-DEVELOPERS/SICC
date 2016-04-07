
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_actividades_insertar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML990(doc);
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         

      getXML1350(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_actividades_insertar" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar Actividades" );
      ((Element)v.get(0)).setAttribute("cod","050" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","LoadBar();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","i18NJS.js" );
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
      v.add(doc.createTextNode("  \r\r      \r    \r    \r var str =''; \r var procesosAsignado='';\r var procesosDisponible='';\r    \r function LoadBar(){     \r            \r      configurarMenuSecundario(\"frmInsertarActividades\");\r            \r      accion('frmInsertarActividades.txtCampDesp', '.disabled=true');\r      porDefecto();   \r      modifico();   \r      mostrarCodigoError();   \r      ocultarCampos();   \r      procesos();\r }\r function porDefecto() { \r \r    if (get('frmInsertarActividades.hCasoDeUso') == ''){\r    \r       iSeleccionado = new Array();    \r       iSeleccionado[0] = get('frmInsertarActividades.valueMarca')==\"\"?\"0\":get('frmInsertarActividades.valueMarca');   \r       set('frmInsertarActividades.cboMarcas',iSeleccionado);   \r    \r       iSeleccionado = new Array();    \r       iSeleccionado[0] = get('frmInsertarActividades.valueCanal')==\"\"?\"0\":get('frmInsertarActividades.valueCanal');   \r       set('frmInsertarActividades.cboCanales',iSeleccionado);   \r    \r       iSeleccionado = new Array();    \r       iSeleccionado[0] = '6';   \r       var le = combo_get ('frmInsertarActividades.cboClaseAct','L');   \r               \r       for (var i=0;i<le;i++){   \r          if (combo_get('frmInsertarActividades.cboClaseAct','V',i)== 6){   \r             set('frmInsertarActividades.cboClaseAct',iSeleccionado);   \r          }   \r       }   \r    }\r }\r\r  function limpiarProcesos(){\r      var aPonerCombo = new Array();\r      var arr = new Array();\r      arr = procesosDisponible.split('%');\r      for (i=0;i<arr.length;i++){\r          var arr2 = arr[i].split('|');\r          if (arr2[0]!='' && arr2[1]!=''){\r              aPonerCombo[i] = new Array(arr2[0],arr2[1]);\r          }\r      }\r      set_combo('frmInsertarActividades.cbProcDisp',aPonerCombo); \r      aPonerCombo = new Array();\r      arr = new Array();\r      arr = procesosAsignado.split('%');\r      for (i=0;i<arr.length;i++){\r          var arr2 = arr[i].split('|');\r          if (arr2[0]!='' && arr2[1]!=''){\r              aPonerCombo[i] = new Array(arr2[0],arr2[1]);\r          }\r      }\r      set_combo('frmInsertarActividades.cbProcAsig',aPonerCombo);\r  }\r   \r function procesos(){   \r    \r   var lon = combo_get ('frmInsertarActividades.cbProcDisp','L');   \r\r   var oids = new Array();      \r   var des = new Array();   \r      \r   for(var i=0; i < lon; i++){    \r      des[i] = (combo_get ('frmInsertarActividades.cbProcDisp','T',i));   \r      oids[i] = (combo_get ('frmInsertarActividades.cbProcDisp','V',i));   \r   }\r      \r   for(var i=0; i < oids.length; i++){\r      str +=  oids[i] + '|';     \r      str +=  des[i]  + '%';        \r   }\r   procesosDisponible = str;\r   lon = combo_get ('frmInsertarActividades.cbProcAsig','L');   \r\r   oids = new Array();      \r   des = new Array();\r\r   str='';\r      \r   for(var i=0; i < lon; i++){    \r      des[i] = (combo_get ('frmInsertarActividades.cbProcAsig','T',i));   \r      oids[i] = (combo_get ('frmInsertarActividades.cbProcAsig','V',i));   \r   }   \r      \r   for(var i=0; i < oids.length; i++){   \r      str +=  oids[i] + '|';     \r      str +=  des[i]  + '%';        \r   }\r    procesosAsignado = str;\r }  \r\r function deFLimpiar(str) {   \r    \r    val = procesosAsignado + procesosDisponible;\r    \r    arr = procesosDisponible.split('%');\r    for (i=0;i<arr.length;i++){\r        var arr2 = arr[i].split('|');\r        if (arr2[0]!='' && arr2[1]!=''){\r            aPonerCombo[i] = new Array(arr2[0],arr2[1]);\r        }\r    }\r    set_combo('frmInsertarActividades.cbProcDisp',aPonerCombo);  \r } \r    \r function fVolver(){   \r    window.close();   \r } \r function modifico(){   \r    if (get('frmInsertarActividades.ok') == 'si'){   \r       window.close();   \r    }   \r }\r  function habilitadomarca(){   \r    \r    var objArr = document.all['cboMarcas'];   \r    for(var i=0; i < objArr.length; i++){   \r       if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){   \r          if (objArr[i].disabled) {   \r             return false;   \r          }   \r       }   \r     }   \r         \r     return true;   \r }\r function vaAlPrimeroMarcas(){   \r    focaliza('frmInsertarActividades.cbProcDisp');   \r }\r function vaAlPrimero(){   \r\r    if (habilitadomarca()){    \r       focaliza('frmInsertarActividades.cboCanales');\r    }else{   \r       focaliza('frmInsertarActividades.cbProcDisp');   \r    }   \r }\r\r function vuelveAlPrimero(){   \r    \r    if (habilitadomarca()) {   \r      focaliza('frmInsertarActividades.cboMarcas');   \r    }else{    \r      focaliza('frmInsertarActividades.cboClaseAct');   \r    }   \r }\r\r function limpiaInsertar(){ \r	\r			\r    limpiaI18N('frmInsertarActividades', '1');   \r             \r     iSeleccionado = new Array();    \r     iSeleccionado[0] = get('frmInsertarActividades.valueMarca')==\"\"?\"0\":get('frmInsertarActividades.valueMarca');   \r	 	\r	 set('frmInsertarActividades.cboMarcas',iSeleccionado);   \r    \r     iSeleccionado = new Array();    \r     iSeleccionado[0] = get('frmInsertarActividades.valueCanal')==\"\"?\"0\":get('frmInsertarActividades.valueCanal');   \r     set('frmInsertarActividades.cboCanales',iSeleccionado);   \r    \r     iSeleccionado = new Array();    \r     iSeleccionado[0] = '6';   \r     var le = combo_get ('frmInsertarActividades.cboClaseAct','L');   \r      \r     for (var i=0;i<le;i++){   \r          if (combo_get('frmInsertarActividades.cboClaseAct','V',i)== 6){   \r             set('frmInsertarActividades.cboClaseAct',iSeleccionado);   \r          }   \r     }   \r        \r    set('frmInsertarActividades.txtcdActividad','');   \r    set('frmInsertarActividades.txtdesActividad','');   \r    set('frmInsertarActividades.cboTpAct','');   \r    set('frmInsertarActividades.cbactividadRef','');   \r    set('frmInsertarActividades.txtDias','');   \r    set('frmInsertarActividades.txtCampDesp','');  \r    set('frmInsertarActividades.cboAreaResp','');   \r    set('frmInsertarActividades.RebelNoticias','N');   \r    set('frmInsertarActividades.txtCampaAntela','');   \r    set('frmInsertarActividades.cbTipoDirec','');   \r    set('frmInsertarActividades.cboTipoDias','');   \r    set('frmInsertarActividades.cbMensaje','');   \r                limpiarProcesos();\r    cmbCanal_onChange();\r	\r	var arr = new Array(); \r	focaliza('frmInsertarActividades.cboMarcas',arr[0]);   \r	\r	\r }\r\r function limpia(){   \r    var arr = new Array();      \r    \r     \r    if(get('frmInsertarActividades.accion')=='muestraInsercion'){       \r       limpiaInsertar();   \r    }else if(get('frmInsertarActividades.accion')=='modificar'){   \r       limpiarProcesos();\r       limpiaI18N('frmInsertarActividades', '1');   \r       arr[0] =  get('frmInsertarActividades.valueCanal')      \r       set('frmInsertarActividades.cboCanales',arr);   \r       \r       arr[0] = get('frmInsertarActividades.valueMarca')   \r       set('frmInsertarActividades.cboMarcas',arr);   \r    \r       set('frmInsertarActividades.txtdesActividad',get('frmInsertarActividades.nombreActividad'));   \r       set('frmInsertarActividades.txtDias',get('frmInsertarActividades.diasDesplazamiento'));   \r       set('frmInsertarActividades.txtCampDesp',get('frmInsertarActividades.hCampDespl'));   \r\r       arr[0] = get('frmInsertarActividades.areaResponsable')   \r       set('frmInsertarActividades.cboAreaResp',arr);  \r\r       arr[0] = get('frmInsertarActividades.oidActRef');\r       set('frmInsertarActividades.cbactividadRef',arr); \r    \r       set('frmInsertarActividades.RebelNoticias',get('frmInsertarActividades.ebelNoticia'));   \r\r       arr[0] = get('frmInsertarActividades.tipoDireccionOid')   \r       set('frmInsertarActividades.cbTipoDirec',arr);   \r       \r       arr[0] = get('frmInsertarActividades.diaLaborable')   \r       set('frmInsertarActividades.cboTipoDias',arr);   \r    \r                                    \r       get('frmInsertarActividades.ebelNoticia')==\"1\"?set('frmInsertarActividades.RebelNoticias','S'):set('frmInsertarActividades.RebelNoticias','N');   \r    \r       arr[0] = get('frmInsertarActividades.codigoTipoActividad')   \r       set('frmInsertarActividades.cboTpAct',arr);   \r    \r       arr[0] = get('frmInsertarActividades.ClaseActividad');   \r       set('frmInsertarActividades.cboClaseAct',arr);\r\r       ocultarCampos();\r    \r       deFLimpiar(str);   \r    \r       focaliza('frmInsertarActividades.cboClaseAct');   \r                      \r    }           \r }\r function fLimpiar(){   \r   limpia();   \r }\r   \r function ocultarCampos(){   \r    var arr = new Array();   \r    \r   if ((get('frmInsertarActividades.hCasoDeUso')) == ''){   \r          focaliza('frmInsertarActividades.cboMarcas',arr[0]);   \r          accion('frmInsertarActividades.cbactividadRef', '.disabled=true');   \r          set('frmInsertarActividades.RebelNoticias','N');   \r          accion('frmInsertarActividades.cbProcAsig', '.disabled=true');   \r          habilitarOrigen();   \r          deshabilitarTipoDireccion();   \r             \r                     \r     } else if ((get('frmInsertarActividades.hCasoDeUso')) == 'consultar'){   \r    \r               cargarCombosModificar();   \r               accion('frmInsertarActividades.cboMarcas', '.disabled=true');   \r               accion('frmInsertarActividades.cboCanales', '.disabled=true');   \r               accion('frmInsertarActividades.cboClaseAct', '.disabled=true');   \r               accion('frmInsertarActividades.txtcdActividad', '.disabled=true');   \r               accion('frmInsertarActividades.txtdesActividad', '.disabled=true');   \r               accion('frmInsertarActividades.cboTpAct', '.disabled=true');   \r                              iSeleccionado = new Array(); \r               iSeleccionado[0] = get('frmInsertarActividades.oidActRef');\r               set('frmInsertarActividades.cbactividadRef',iSeleccionado);            \r               accion('frmInsertarActividades.cbactividadRef', '.disabled=true');\r               \r               accion('frmInsertarActividades.txtDias', '.disabled=true');   \r               accion('frmInsertarActividades.txtCampDesp', '.disabled=true');   \r               accion('frmInsertarActividades.cboAreaResp', '.disabled=true');   \r               document.all.RebelNoticias[0].disabled=true;   \r               document.all.RebelNoticias[1].disabled=true;   \r                  \r               accion('frmInsertarActividades.txtCampaAntela', '.disabled=true');   \r               accion('frmInsertarActividades.cbTipoDirec', '.disabled=true');   \r               accion('frmInsertarActividades.cboTipoDias', '.disabled=true');   \r               accion('frmInsertarActividades.cbProcAsig', '.disabled=true');   \r               accion('frmInsertarActividades.cbProcDisp', '.disabled=true');   \r               accion('frmInsertarActividades.cbMensaje', '.disabled=true');\r                  \r     } else  if ((get('frmInsertarActividades.hCasoDeUso')) == 'modificar'){   \r                                   focaliza('frmInsertarActividades.cboClaseAct',arr[0]);   \r                                   cargarCombosModificar();\r                                   iSeleccionado = new Array(); \r                                   iSeleccionado[0] = get('frmInsertarActividades.oidActRef');\r                                   set('frmInsertarActividades.cbactividadRef',iSeleccionado);       \r                                   habilitarOrigen();   \r                                   deshabilitarTipoDireccion();   \r                                   accion('frmInsertarActividades.cboMarcas', '.disabled=true');   \r                                   accion('frmInsertarActividades.cboCanales', '.disabled=true');   \r                                   accion('frmInsertarActividades.txtcdActividad', '.disabled=true'); \r                                   \r                                                                   \r            }   \r }  \r    \r    \r function cargarCombosModificar(){   \r    \r            iSeleccionado = new Array();    \r            \r            iSeleccionado[0] = get('frmInsertarActividades.valueMarca')==\"\"?\"0\":get('frmInsertarActividades.valueMarca');   \r            set('frmInsertarActividades.cboMarcas',iSeleccionado);   \r    \r            iSeleccionado = new Array();   \r            \r            iSeleccionado[0] = get('frmInsertarActividades.valueCanal')==\"\"?\"0\":get('frmInsertarActividades.valueCanal');   \r            set('frmInsertarActividades.cboCanales',iSeleccionado);   \r    \r            iSeleccionado = new Array();    \r            iSeleccionado[0] = get('frmInsertarActividades.diaLaborable')==\"\"?\"0\":get('frmInsertarActividades.diaLaborable');   \r            set('frmInsertarActividades.cboTipoDias',iSeleccionado);   \r    \r            iSeleccionado = new Array();    \r            iSeleccionado[0] = get('frmInsertarActividades.areaResponsable')==\"\"?\"0\":get('frmInsertarActividades.areaResponsable');   \r     \r            set('frmInsertarActividades.cboAreaResp',iSeleccionado);   \r    \r            iSeleccionado = new Array();    \r            iSeleccionado[0] = get('frmInsertarActividades.ClaseActividad')==\"\"?\"0\":get('frmInsertarActividades.ClaseActividad');   \r            set('frmInsertarActividades.cboClaseAct',iSeleccionado);   \r    \r               \r            iSeleccionado = new Array();    \r            iSeleccionado[0] = get('frmInsertarActividades.codigoTipoActividad')==\"\"?\"0\":get('frmInsertarActividades.codigoTipoActividad');   \r            set('frmInsertarActividades.cboTpAct',iSeleccionado);   \r    \r            get('frmInsertarActividades.ebelNoticia')==\"1\"?set('frmInsertarActividades.RebelNoticias','S'):set('frmInsertarActividades.RebelNoticias','N');   \r    \r               \r            iSeleccionado = new Array();    \r            iSeleccionado[0] = get('frmInsertarActividades.tipoDireccionOid')==\"\"?\"0\":get('frmInsertarActividades.tipoDireccionOid');   \r            set('frmInsertarActividades.cbTipoDirec',iSeleccionado);   \r\r			iSeleccionado = new Array();    \r            iSeleccionado[0] = get('frmInsertarActividades.mensajeOid')==\"\"?\"0\":get('frmInsertarActividades.mensajeOid');   \r            set('frmInsertarActividades.cbMensaje',iSeleccionado);  \r }\r function habilitarOrigen(){   \r    if (get('frmInsertarActividades.cboTpAct','T') == 'Actividad origen') {   \r       accion('frmInsertarActividades.cbactividadRef', '.disabled=false');\r       accion('frmInsertarActividades.txtCampDesp', '.disabled=true'); \r    } else if (get('frmInsertarActividades.cboTpAct','T') == 'Referencia Otra Campaña') {\r       accion('frmInsertarActividades.cbactividadRef', '.disabled=false');   \r       accion('frmInsertarActividades.txtCampDesp', '.disabled=false');   \r    } else {   \r       accion('frmInsertarActividades.cbactividadRef', '.disabled=true');\r       accion('frmInsertarActividades.txtCampDesp', '.disabled=true');\r       set ('frmInsertarActividades.cbactividadRef',' ');   \r    }\r\r    \r    \r }   \r    \r function deshabilitarTipoDireccion(){   \r    if (get('frmInsertarActividades.RebelNoticias') == 'N'){   \r       accion('frmInsertarActividades.cbTipoDirec','.disabled=true');   \r       set ('frmInsertarActividades.cbTipoDirec',' ');    \r    }else{   \r       accion('frmInsertarActividades.cbTipoDirec','.disabled=false');\r    }\r }\r\r    \r function mostrarCodigoError(){   \r    \r   var vErrCodigo = get('frmInsertarActividades.errCodigo');   \r   var vErrDescrip = get('frmInsertarActividades.errDescripcion');   \r               \r   if (get('frmInsertarActividades.errDescripcion')!=''){   \r       var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);   \r   }   \r }  \r  \r function traspasar(listaOrigen,listaDestino){   \r        \r    var vectorValue = new Array();   \r    var vectorDesc = new Array();   \r    \r    vectorValue = get(listaOrigen,'V');   \r    vectorDesc = get(listaOrigen,'T');   \r                 \r    for (var i=0;i <= vectorValue.length - 1;i++){   \r       if ((vectorValue[i] != null) && (vectorValue[i] != '')){   \r          del_combo(listaOrigen,'V', vectorValue[i]);   \r          combo_add(listaDestino,vectorValue[i],vectorDesc[i]);   \r       }   \r    }   \r  }   \r  \r function dehabilitarCombo() {   \r   if (get('frmInsertarActividades.cbProcAsig','T') == ''){   \r      accion('frmInsertarActividades.cbProcAsig', '.disabled=true');   \r              \r   }   \r }\r    \r function habilitarcombo() {   \r    accion('frmInsertarActividades.cbProcAsig', '.disabled=false');   \r }\r\r   \r function validarAlfanumericoConEspeciales(valor){   \r    \r    var permitidos = \"0123456789\";   \r    var c;   \r                                  \r    for(var i=0; i<valor.length; i++){   \r       c = valor.charAt(i);   \r       if (permitidos.indexOf(c) == -1 )\r		return false;   \r    }   \r    return true;   \r }   \r\r function validarNumeroConNegativo(valor){   \r    \r    var permitidos = \"0123456789\";   \r    var c;   \r                                  \r    for(var i=0; i<valor.length; i++){   \r       c = valor.charAt(i);   \r       if (permitidos.indexOf(c) == -1 ) {\r			if (i == 0 && c != '-')\r				return false;   \r		 }\r    }   \r    return true;   \r }   \r\r   \r   function fGuardar(){   \r    \r    var dias = get ('frmInsertarActividades.txtDias');   \r    var campana = get ('frmInsertarActividades.txtCampaAntela');   \r    var campadespl = get ('frmInsertarActividades.txtCampDesp');   \r    \r    	if (( (get('frmInsertarActividades.cboTpAct','V')  == '1') && (get('frmInsertarActividades.cbactividadRef') == '') )||\r		( (get('frmInsertarActividades.cboTpAct','V')  == '2') && (get('frmInsertarActividades.cbactividadRef') == '') )) {\r		GestionarMensaje('UIFAC0013',null,null,null);\r		return;\r	}\r\r	if(validarAlfanumericoConEspeciales(campadespl)){\r		if ((get('frmInsertarActividades.cboTpAct','T') == 'Referencia otra Campaña')){    \r          for(var i=0; i <objValidacionSICC.length; i++){   \r			 if(objValidacionSICC[i].nombre == \"txtCampDesp\"){   \r                 objValidacionSICC[i].requerido = true;   \r                 break;   \r             }   \r		  }   \r        }else{   \r          for(var i=0; i <objValidacionSICC.length; i++){   \r            if(objValidacionSICC[i].nombre == \"txtCampDesp\"){   \r              objValidacionSICC[i].requerido = false;   \r              break;   \r            }   \r          } \r	    }\r	}\r    \r    if (validarNumeroConNegativo(dias) && validarAlfanumericoConEspeciales(campana)) {   \r       if ((get('frmInsertarActividades.cboTpAct','T') == 'Actividad origen')||(get('frmInsertarActividades.cboTpAct','T') == 'Referencia otra Campaña')){    \r          for(var i=0; i <objValidacionSICC.length; i++){   \r             if(objValidacionSICC[i].nombre == \"cbactividadRef\"){   \r                 objValidacionSICC[i].requerido = true;   \r                 break;   \r             }   \r          }   \r       }else{   \r          for(var i=0; i <objValidacionSICC.length; i++){   \r            if(objValidacionSICC[i].nombre == \"cbactividadRef\"){   \r              objValidacionSICC[i].requerido = false;   \r              break;   \r            }   \r          }   \r       }   \r    \r       if(!sicc_validaciones_generales()){   \r         return false;   \r       }   \r               \r       set('frmInsertarActividades.valueMarca',get('frmInsertarActividades.cboMarcas','V'));   \r       set('frmInsertarActividades.valueCanal',get('frmInsertarActividades.cboCanales','V'));   \r       set('frmInsertarActividades.ClaseActividad',get('frmInsertarActividades.cboClaseAct','V'));   \r       set('frmInsertarActividades.codigoActividad', get('frmInsertarActividades.txtcdActividad'));   \r       set('frmInsertarActividades.nombreActividad',(get('frmInsertarActividades.txtdesActividad')));   \r       set('frmInsertarActividades.codigoTipoActividad',(get('frmInsertarActividades.cboTpAct','V')));   \r       set('frmInsertarActividades.actividadOrigen',(get('frmInsertarActividades.cbactividadRef')));   \r       set('frmInsertarActividades.diasDesplazamiento',get('frmInsertarActividades.txtDias'));   \r   	   set('frmInsertarActividades.hCampDespl',get('frmInsertarActividades.txtCampDesp'));   \r       set('frmInsertarActividades.areaResponsable', get('frmInsertarActividades.cboAreaResp','V'));   \r       set('frmInsertarActividades.ebelNoticia',get('frmInsertarActividades.RebelNoticias'));   \r       set('frmInsertarActividades.campanasAntelacion',get('frmInsertarActividades.txtCampaAntela'));   \r       set('frmInsertarActividades.tipoDireccion',get('frmInsertarActividades.cbTipoDirec','V'));   \r       set('frmInsertarActividades.indFestivo',get('frmInsertarActividades.cboTipoDias','V'));   \r       set('frmInsertarActividades.mensajeOid',get('frmInsertarActividades.cbMensaje','V'));\r\r       var sProcesosAsignados = '';   \r       var longitud = combo_get('frmInsertarActividades.cbProcAsig','L');   \r\r       if (longitud > 0) {   \r          sProcesosAsignados = combo_get('frmInsertarActividades.cbProcAsig','V',0);   \r       }   \r    \r       for(var i = 1;i < longitud;i++){   \r          sProcesosAsignados += '|' + combo_get('frmInsertarActividades.cbProcAsig','V',i);   \r       }   \r    \r       set('frmInsertarActividades.procesosAsignado',sProcesosAsignados);   \r    \r       if (get('frmInsertarActividades.hCasoDeUso') == 'modificar')   \r          set('frmInsertarActividades.accion','guardar_mod')   \r       else    \r          set('frmInsertarActividades.accion','guardar');   \r    \r    \r       	   var continuar = GestionarMensaje('938');\r	   if (continuar) {\r		   enviaSICC('frmInsertarActividades');   \r	   }\r    \r    }else{        \r                          \r        if (validarNumeroConNegativo(dias)) {   \r                                    \r           var camp = '';   \r    \r           for(var i=0; i <objValidacionSICC.length; i++){   \r              if(objValidacionSICC[i].nombre == \"txtCampaAntela\"){   \r                 camp = objValidacionSICC[i].mostrar;   \r              }   \r           }   \r\r           GestionarMensaje(\"1224\", camp, null, null);   \r           focaliza('frmInsertarActividades.txtCampaAntela');   \r                                \r        }else{   \r                                                \r           var dia = '';   \r           for(var i=0; i <objValidacionSICC.length; i++){   \r              if(objValidacionSICC[i].nombre == \"txtDias\"){   \r                 dia = objValidacionSICC[i].mostrar;   \r              }   \r           }   \r                                                  \r           GestionarMensaje(\"1224\", dia, null, null);   \r           focaliza('frmInsertarActividades.txtDias');   \r                                            \r        }   \r    }   \r    \r }  \r function cmbMarca_onChange(){\r\r    var marca = document.getElementById(\"cboMarcas\");\r    var canal = document.getElementById(\"cboCanales\");\r    var oidMarca = marca.value;\r    var oidCanal = canal.value;\r\r    if((oidMarca != '') && (oidCanal != '')){\r       var arr = new Array();\r\r       arr[arr.length]= new Array(\"oidPais\", get('frmInsertarActividades.varPais'));   \r       arr[arr.length]= new Array(\"oidMarca\", oidMarca);   \r       arr[arr.length]= new Array(\"oidCanal\", oidCanal);\r       arr[arr.length]= new Array(\"oidIdioma\", get('frmInsertarActividades.hIdioma'));\r       \r       \r       recargaCombo('frmInsertarActividades.cbactividadRef', 'CRAObtieneActividad', 'es.indra.sicc.dtos.cra.DTOActividad', arr);\r    }\r }\r \r function cmbCanal_onChange(){\r\r    var marca = document.getElementById(\"cboMarcas\");\r    var canal = document.getElementById(\"cboCanales\");\r    var oidMarca = marca.value;\r    var oidCanal = canal.value;\r\r    if((marca != '') && (canal != '')){\r       var arr = new Array();\r\r       arr[arr.length]= new Array(\"oidPais\", get('frmInsertarActividades.varPais'));   \r       arr[arr.length]= new Array(\"oidMarca\", oidMarca);   \r       arr[arr.length]= new Array(\"oidCanal\", oidCanal);\r       arr[arr.length]= new Array(\"oidIdioma\", get('frmInsertarActividades.hIdioma'));\r       \r       \r       recargaCombo('frmInsertarActividades.cbactividadRef', 'CRAObtieneActividad', 'es.indra.sicc.dtos.cra.DTOActividad', arr);\r    }\r }\r    \r\r \rfunction deshabilitarCampanasAntelacion() {\r    if (get('frmInsertarActividades.RebelNoticias') == 'N'){   \r       accion('frmInsertarActividades.txtCampaAntela','.disabled=true');   \r       set ('frmInsertarActividades.txtCampaAntela','');    \r    }else{   \r       accion('frmInsertarActividades.txtCampaAntela','.disabled=false');\r    }\r}\r\r \rfunction RebelNoticias_onClick() {\r\r	deshabilitarTipoDireccion();\r	deshabilitarCampanasAntelacion();\r}\r\r    \r   \r        \r   "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cboMarcas" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cboCanales" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cboClaseAct" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","2191" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtcdActividad" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","151" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtdesActividad" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","174" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cboTpAct" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","152" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cboAreaResp" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","156" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cboTipoDias" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","2268" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtCampaAntela" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("cod","158" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtDias" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("cod","250" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtCampDesp" );
      ((Element)v.get(17)).setAttribute("required","false" );
      ((Element)v.get(17)).setAttribute("cod","3206" );
      ((Element)v.get(17)).setAttribute("format","t" );
      ((Element)v.get(17)).setAttribute("chars","1-9\\-" );
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("max","3" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtDias" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("cod","250" );
      ((Element)v.get(18)).setAttribute("format","t" );
      ((Element)v.get(18)).setAttribute("chars","0-9\\-" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","10" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:6   */

      /* Empieza nodo:19 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(19)).setAttribute("nombre","frmInsertarActividades" );
      ((Element)v.get(19)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(20)).setAttribute("valor","LPMantieneActividades" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","accion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","exito" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","ok" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oid" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","marca" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","canal" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","valueMarca" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","valueCanal" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","strMarca" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","strCanal" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oidClaseActividad" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","codigoTipoActividad" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","areaResponsable" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","tipoDireccionOid" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","diaLaborable" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","codigoActividad" );
      ((Element)v.get(40)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(19)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","codigoActividadOrigen" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","ClaseActividad" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","nombreActividad" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","tipoActividad" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","actividadOrigen" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","ebelNoticia" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","tipoDireccion" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","campanasAntelacion" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","oidActRef" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","procesosAsignado" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","procesosDisponible" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","diasDesplazamiento" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","accesoOid" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","indEbel" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","indFestivo" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","actividadOrigenDescripcion" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","descripcionLarga" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hPais" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","varPais" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hPrograma" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hIPCliente" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hCampDespl" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(63)).setAttribute("nombre","mensajeOid" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 19   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(64)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(64)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(64)).setAttribute("borde","0" );
      ((Element)v.get(64)).setAttribute("imagenf","" );
      ((Element)v.get(64)).setAttribute("repeat","" );
      ((Element)v.get(64)).setAttribute("padding","" );
      ((Element)v.get(64)).setAttribute("visibilidad","" );
      ((Element)v.get(64)).setAttribute("contravsb","" );
      ((Element)v.get(64)).setAttribute("x","0" );
      ((Element)v.get(64)).setAttribute("y","0" );
      ((Element)v.get(64)).setAttribute("zindex","" );
      ((Element)v.get(19)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","12" );
      ((Element)v.get(68)).setAttribute("height","12" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","750" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","12" );
      ((Element)v.get(66)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("height","1" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:66   */

      /* Empieza nodo:73 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(78)).setAttribute("class","legend" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblDatosAct" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("valor","Datos de actividad" );
      ((Element)v.get(79)).setAttribute("id","legend" );
      ((Element)v.get(79)).setAttribute("cod","00493" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(80)).setAttribute("border","0" );
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("cellspacing","0" );
      ((Element)v.get(80)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("colspan","4" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:84 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblPais" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","5" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lbl_marca" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(92)).setAttribute("id","datosTitle" );
      ((Element)v.get(92)).setAttribute("cod","6" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(96)).setAttribute("nombre","lbl_canal" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("filas","1" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("id","datosTitle" );
      ((Element)v.get(96)).setAttribute("cod","7" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(84)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:84   */

      /* Empieza nodo:99 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblPaisActual" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("codi","5" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(107)).setAttribute("nombre","cboMarcas" );
      ((Element)v.get(107)).setAttribute("id","datosCampos" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(107)).setAttribute("size","1" );
      ((Element)v.get(107)).setAttribute("multiple","N" );
      ((Element)v.get(107)).setAttribute("req","S" );
      ((Element)v.get(107)).setAttribute("valorinicial","" );
      ((Element)v.get(107)).setAttribute("textoinicial","" );
      ((Element)v.get(107)).setAttribute("onshtab","vaAlPrimeroMarcas();" );
      ((Element)v.get(107)).setAttribute("onchange","cmbMarca_onChange();" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:109 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(112)).setAttribute("nombre","cboCanales" );
      ((Element)v.get(112)).setAttribute("id","datosCampos" );
      ((Element)v.get(112)).setAttribute("size","1" );
      ((Element)v.get(112)).setAttribute("multiple","N" );
      ((Element)v.get(112)).setAttribute("req","S" );
      ((Element)v.get(112)).setAttribute("valorinicial","" );
      ((Element)v.get(112)).setAttribute("textoinicial","" );
      ((Element)v.get(112)).setAttribute("onchange","cmbCanal_onChange();" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:114 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(99)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:99   */

      /* Empieza nodo:116 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("colspan","4" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:80   */

      /* Empieza nodo:119 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(119)).setAttribute("border","0" );
      ((Element)v.get(119)).setAttribute("align","center" );
      ((Element)v.get(119)).setAttribute("cellspacing","0" );
      ((Element)v.get(119)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblClaseAct" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","Clase actividad" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("cod","2191" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","25" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lbl_cdActividad" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("valor","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("cod","151" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","25" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("colspan","3" );
      ((Element)v.get(120)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lbl_desActividad" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","174" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lbl_tipoActividad" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","152" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(120)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:120   */

      /* Empieza nodo:139 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(139));

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
      ((Element)v.get(143)).setAttribute("nombre","cboClaseAct" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(143)).setAttribute("size","1" );
      ((Element)v.get(143)).setAttribute("multiple","N" );
      ((Element)v.get(143)).setAttribute("req","S" );
      ((Element)v.get(143)).setAttribute("valorinicial","" );
      ((Element)v.get(143)).setAttribute("textoinicial","" );
      ((Element)v.get(143)).setAttribute("onshtab","vaAlPrimero();" );
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
      ((Element)v.get(139)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(148)).setAttribute("nombre","txtcdActividad" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).setAttribute("max","2" );
      ((Element)v.get(148)).setAttribute("tipo","" );
      ((Element)v.get(148)).setAttribute("onchange","" );
      ((Element)v.get(148)).setAttribute("req","S" );
      ((Element)v.get(148)).setAttribute("size","2" );
      ((Element)v.get(148)).setAttribute("valor","" );
      ((Element)v.get(148)).setAttribute("validacion","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","25" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(139)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(152)).setAttribute("nombre","txtdesActividad" );
      ((Element)v.get(152)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).setAttribute("max","40" );
      ((Element)v.get(152)).setAttribute("tipo","" );
      ((Element)v.get(152)).setAttribute("onchange","" );
      ((Element)v.get(152)).setAttribute("req","S" );
      ((Element)v.get(152)).setAttribute("size","53" );
      ((Element)v.get(152)).setAttribute("valor","" );
      ((Element)v.get(152)).setAttribute("validacion","" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(156)).setAttribute("onclick","levantarI18N('frmInsertarActividades','1');" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","25" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(139)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(160)).setAttribute("nombre","cboTpAct" );
      ((Element)v.get(160)).setAttribute("id","datosCampos" );
      ((Element)v.get(160)).setAttribute("size","1" );
      ((Element)v.get(160)).setAttribute("multiple","N" );
      ((Element)v.get(160)).setAttribute("req","S" );
      ((Element)v.get(160)).setAttribute("valorinicial","" );
      ((Element)v.get(160)).setAttribute("textoinicial","" );
      ((Element)v.get(160)).setAttribute("onchange","habilitarOrigen();" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(162)).setAttribute("ID","2" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(163)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(163)).setAttribute("TIPO","STRING" );
      ((Element)v.get(163)).setAttribute("VALOR","2" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 162   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(164)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(164)).setAttribute("TIPO","STRING" );
      ((Element)v.get(164)).setAttribute("VALOR","Referencia Otra Campaña" );
      ((Element)v.get(162)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:162   */

      /* Empieza nodo:165 / Elemento padre: 161   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(165)).setAttribute("ID","1" );
      ((Element)v.get(161)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(166)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(166)).setAttribute("TIPO","STRING" );
      ((Element)v.get(166)).setAttribute("VALOR","1" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 165   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(167)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(167)).setAttribute("TIPO","STRING" );
      ((Element)v.get(167)).setAttribute("VALOR","Actividad origen" );
      ((Element)v.get(165)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:165   */

      /* Empieza nodo:168 / Elemento padre: 161   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(168)).setAttribute("ID","0" );
      ((Element)v.get(161)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(169)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(169)).setAttribute("TIPO","STRING" );
      ((Element)v.get(169)).setAttribute("VALOR","0" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 168   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(170)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(170)).setAttribute("TIPO","STRING" );
      ((Element)v.get(170)).setAttribute("VALOR","Fija" );
      ((Element)v.get(168)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:168   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:171 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:139   */

      /* Empieza nodo:173 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("colspan","4" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:119   */

      /* Empieza nodo:176 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(176)).setAttribute("border","0" );
      ((Element)v.get(176)).setAttribute("align","center" );
      ((Element)v.get(176)).setAttribute("cellspacing","0" );
      ((Element)v.get(176)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lbl_actividadRef" );
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("id","datosTitle" );
      ((Element)v.get(181)).setAttribute("cod","155" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","25" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(185)).setAttribute("nombre","lbl_dias" );
      ((Element)v.get(185)).setAttribute("alto","13" );
      ((Element)v.get(185)).setAttribute("filas","1" );
      ((Element)v.get(185)).setAttribute("valor","" );
      ((Element)v.get(185)).setAttribute("id","datosTitle" );
      ((Element)v.get(185)).setAttribute("cod","250" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","25" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(189)).setAttribute("nombre","lbl_campDesp" );
      ((Element)v.get(189)).setAttribute("alto","13" );
      ((Element)v.get(189)).setAttribute("filas","1" );
      ((Element)v.get(189)).setAttribute("valor","" );
      ((Element)v.get(189)).setAttribute("id","datosTitle" );
      ((Element)v.get(189)).setAttribute("cod","3206" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","25" );
      ((Element)v.get(191)).setAttribute("height","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(193)).setAttribute("nombre","lbl_areaResp" );
      ((Element)v.get(193)).setAttribute("alto","13" );
      ((Element)v.get(193)).setAttribute("filas","1" );
      ((Element)v.get(193)).setAttribute("valor","" );
      ((Element)v.get(193)).setAttribute("id","datosTitle" );
      ((Element)v.get(193)).setAttribute("cod","156" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:177   */

      /* Empieza nodo:196 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(200)).setAttribute("nombre","cbactividadRef" );
      ((Element)v.get(200)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).setAttribute("size","1" );
      ((Element)v.get(200)).setAttribute("multiple","N" );
      ((Element)v.get(200)).setAttribute("req","N" );
      ((Element)v.get(200)).setAttribute("valorinicial","" );
      ((Element)v.get(200)).setAttribute("textoinicial","" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:202 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","25" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(196)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(205)).setAttribute("nombre","txtDias" );
      ((Element)v.get(205)).setAttribute("id","datosCampos" );
      ((Element)v.get(205)).setAttribute("max","5" );
      ((Element)v.get(205)).setAttribute("tipo","" );
      ((Element)v.get(205)).setAttribute("onchange","" );
      ((Element)v.get(205)).setAttribute("req","N" );
      ((Element)v.get(205)).setAttribute("size","6" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("validacion","" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(196)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(209)).setAttribute("nombre","txtCampDesp" );
      ((Element)v.get(209)).setAttribute("id","datosCampos" );
      ((Element)v.get(209)).setAttribute("max","2" );
      ((Element)v.get(209)).setAttribute("tipo","" );
      ((Element)v.get(209)).setAttribute("onchange","" );
      ((Element)v.get(209)).setAttribute("req","N" );
      ((Element)v.get(209)).setAttribute("size","2" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("validacion","" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","25" );
      ((Element)v.get(211)).setAttribute("height","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(196)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(213)).setAttribute("nombre","cboAreaResp" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("size","1" );
      ((Element)v.get(213)).setAttribute("multiple","N" );
      ((Element)v.get(213)).setAttribute("req","S" );
      ((Element)v.get(213)).setAttribute("valorinicial","" );
      ((Element)v.get(213)).setAttribute("textoinicial","" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(196)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:196   */

      /* Empieza nodo:217 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("colspan","4" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:176   */

      /* Empieza nodo:220 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(220)).setAttribute("border","0" );
      ((Element)v.get(220)).setAttribute("align","center" );
      ((Element)v.get(220)).setAttribute("cellspacing","0" );
      ((Element)v.get(220)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(225)).setAttribute("nombre","lbl_ebelNoticias" );
      ((Element)v.get(225)).setAttribute("alto","13" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(225)).setAttribute("id","datosTitle" );
      ((Element)v.get(225)).setAttribute("cod","157" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","25" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(229)).setAttribute("nombre","lbl_campaAntela" );
      ((Element)v.get(229)).setAttribute("alto","13" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(229)).setAttribute("id","datosTitle" );
      ((Element)v.get(229)).setAttribute("cod","158" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","25" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(233)).setAttribute("nombre","lbl_TipoDirec" );
      ((Element)v.get(233)).setAttribute("alto","13" );
      ((Element)v.get(233)).setAttribute("filas","1" );
      ((Element)v.get(233)).setAttribute("valor","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(233)).setAttribute("id","datosTitle" );
      ((Element)v.get(233)).setAttribute("cod","159" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","25" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(237)).setAttribute("nombre","lbl_tipo_dias" );
      ((Element)v.get(237)).setAttribute("alto","13" );
      ((Element)v.get(237)).setAttribute("filas","1" );
      ((Element)v.get(237)).setAttribute("valor","" );
      ((Element)v.get(237)).setAttribute("id","datosTitle" );
      ((Element)v.get(237)).setAttribute("cod","2268" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","25" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(241)).setAttribute("nombre","lbl_mensaje" );
      ((Element)v.get(241)).setAttribute("alto","13" );
      ((Element)v.get(241)).setAttribute("filas","1" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("id","datosTitle" );
      ((Element)v.get(241)).setAttribute("cod","531" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","100%" );
      ((Element)v.get(221)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:221   */

      /* Empieza nodo:244 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(244)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("table"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(248)).setAttribute("border","0" );
      ((Element)v.get(248)).setAttribute("cellspacing","0" );
      ((Element)v.get(248)).setAttribute("cellpadding","0" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("class","datosCampos" );
      ((Element)v.get(250)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(251)).setAttribute("nombre","RebelNoticias" );
      ((Element)v.get(251)).setAttribute("tipo","H" );
      ((Element)v.get(251)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).setAttribute("onclick","deshabilitarTipoDireccion();" );
      ((Element)v.get(251)).setAttribute("req","N" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(252)).setAttribute("valor","S" );
      ((Element)v.get(252)).setAttribute("check","N" );
      ((Element)v.get(252)).setAttribute("onfocus","" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).setAttribute("cod","117" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Elemento padre:252 / Elemento actual: 253   */
      v.add(doc.createTextNode("xxx"));
      ((Element)v.get(252)).appendChild((Text)v.get(253));

      /* Termina nodo Texto:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(254)).setAttribute("valor","N" );
      ((Element)v.get(254)).setAttribute("check","N" );
      ((Element)v.get(254)).setAttribute("onfocus","" );
      ((Element)v.get(254)).setAttribute("id","datosCampos" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(254)).setAttribute("cod","87" );
      ((Element)v.get(251)).appendChild((Element)v.get(254));

      /* Elemento padre:254 / Elemento actual: 255   */
      v.add(doc.createTextNode("ccc"));
      ((Element)v.get(254)).appendChild((Text)v.get(255));

      /* Termina nodo Texto:255   */
      /* Termina nodo:254   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:256 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","25" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(244)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(259)).setAttribute("nombre","txtCampaAntela" );
      ((Element)v.get(259)).setAttribute("id","datosCampos" );
      ((Element)v.get(259)).setAttribute("max","2" );
      ((Element)v.get(259)).setAttribute("tipo","" );
      ((Element)v.get(259)).setAttribute("onchange","" );
      ((Element)v.get(259)).setAttribute("req","N" );
      ((Element)v.get(259)).setAttribute("size","2" );
      ((Element)v.get(259)).setAttribute("valor","" );
      ((Element)v.get(259)).setAttribute("validacion","" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(244)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(263)).setAttribute("nombre","cbTipoDirec" );
      ((Element)v.get(263)).setAttribute("id","datosCampos" );
      ((Element)v.get(263)).setAttribute("size","1" );
      ((Element)v.get(263)).setAttribute("multiple","N" );
      ((Element)v.get(263)).setAttribute("req","N" );
      ((Element)v.get(263)).setAttribute("valorinicial","" );
      ((Element)v.get(263)).setAttribute("textoinicial","" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:265 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","25" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(244)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(268)).setAttribute("nombre","cboTipoDias" );
      ((Element)v.get(268)).setAttribute("id","datosCampos" );
      ((Element)v.get(268)).setAttribute("size","1" );
      ((Element)v.get(268)).setAttribute("multiple","N" );
      ((Element)v.get(268)).setAttribute("req","S" );
      ((Element)v.get(268)).setAttribute("valorinicial","" );
      ((Element)v.get(268)).setAttribute("textoinicial","" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(270)).setAttribute("ID","1" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(271)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(271)).setAttribute("TIPO","STRING" );
      ((Element)v.get(271)).setAttribute("VALOR","1" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 270   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(272)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(272)).setAttribute("TIPO","STRING" );
      ((Element)v.get(272)).setAttribute("VALOR","Continuos" );
      ((Element)v.get(270)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:270   */

      /* Empieza nodo:273 / Elemento padre: 269   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(273)).setAttribute("ID","0" );
      ((Element)v.get(269)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(274)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(274)).setAttribute("TIPO","STRING" );
      ((Element)v.get(274)).setAttribute("VALOR","0" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 273   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(275)).setAttribute("NOMBRE","DESCRIPCION" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(275)).setAttribute("TIPO","STRING" );
      ((Element)v.get(275)).setAttribute("VALOR","Laborables" );
      ((Element)v.get(273)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:273   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:276 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","25" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(244)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(279)).setAttribute("nombre","cbMensaje" );
      ((Element)v.get(279)).setAttribute("id","datosCampos" );
      ((Element)v.get(279)).setAttribute("size","1" );
      ((Element)v.get(279)).setAttribute("multiple","N" );
      ((Element)v.get(279)).setAttribute("req","N" );
      ((Element)v.get(279)).setAttribute("valorinicial","" );
      ((Element)v.get(279)).setAttribute("textoinicial","" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:281 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(244)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:244   */

      /* Empieza nodo:283 / Elemento padre: 220   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(220)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("colspan","4" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:220   */

      /* Empieza nodo:286 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(286)).setAttribute("width","100%" );
      ((Element)v.get(286)).setAttribute("border","0" );
      ((Element)v.get(286)).setAttribute("align","center" );
      ((Element)v.get(286)).setAttribute("cellspacing","0" );
      ((Element)v.get(286)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(291)).setAttribute("nombre","lbl_procesosAsig" );
      ((Element)v.get(291)).setAttribute("alto","13" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(291)).setAttribute("id","datosTitle" );
      ((Element)v.get(291)).setAttribute("cod","164" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("colspan","3" );
      ((Element)v.get(287)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(295)).setAttribute("nombre","lbl_procesosDisp" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(295)).setAttribute("id","datosTitle" );
      ((Element)v.get(295)).setAttribute("cod","165" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).setAttribute("width","100%" );
      ((Element)v.get(287)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:287   */

      /* Empieza nodo:298 / Elemento padre: 286   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(286)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","8" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(298)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(302)).setAttribute("nombre","cbProcAsig" );
      ((Element)v.get(302)).setAttribute("id","datosCampos" );
      ((Element)v.get(302)).setAttribute("size","5" );
      ((Element)v.get(302)).setAttribute("multiple","S" );
      ((Element)v.get(302)).setAttribute("req","N" );
      ((Element)v.get(302)).setAttribute("onchange","dehabilitarCombo();" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:304 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","25" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(298)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("table"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).setAttribute("class","botonera" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(310)).setAttribute("nombre","btnDer" );
      ((Element)v.get(310)).setAttribute("ID","botonContenido" );
      ((Element)v.get(310)).setAttribute("tipo","html" );
      ((Element)v.get(310)).setAttribute("accion","traspasar('frmInsertarActividades.cbProcAsig','frmInsertarActividades.cbProcDisp');" );
      ((Element)v.get(310)).setAttribute("estado","false" );
      ((Element)v.get(310)).setAttribute("cod","2194" );
      ((Element)v.get(310)).setAttribute("alt","<" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:311 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).setAttribute("class","botonera" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(313)).setAttribute("nombre","btnIzq" );
      ((Element)v.get(313)).setAttribute("ID","botonContenido" );
      ((Element)v.get(313)).setAttribute("tipo","html" );
      ((Element)v.get(313)).setAttribute("accion","traspasar('frmInsertarActividades.cbProcDisp','frmInsertarActividades.cbProcAsig');" );
      ((Element)v.get(313)).setAttribute("estado","false" );
      ((Element)v.get(313)).setAttribute("cod","2193" );
      ((Element)v.get(313)).setAttribute("alt",">" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:314 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","25" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(298)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(317)).setAttribute("nombre","cbProcDisp" );
      ((Element)v.get(317)).setAttribute("id","datosCampos" );
      ((Element)v.get(317)).setAttribute("size","5" );
      ((Element)v.get(317)).setAttribute("multiple","S" );
      ((Element)v.get(317)).setAttribute("req","N" );
      ((Element)v.get(317)).setAttribute("ontab","vuelveAlPrimero();" );
      ((Element)v.get(317)).setAttribute("onchange","habilitarcombo();" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:319 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("width","100%" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(298)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:298   */

      /* Empieza nodo:321 / Elemento padre: 286   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(286)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("colspan","4" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:286   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:324 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:73   */

      /* Empieza nodo:326 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(327)).setAttribute("align","center" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","12" );
      ((Element)v.get(328)).setAttribute("height","12" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("width","750" );
      ((Element)v.get(326)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(326)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","12" );
      ((Element)v.get(332)).setAttribute("height","1" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:326   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:19   */


   }

}
