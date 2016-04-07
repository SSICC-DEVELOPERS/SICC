
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_comisiones_productos_excluir  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_comisiones_productos_excluir" );
      ((Element)v.get(0)).setAttribute("cod","0515" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar comisiones" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag()   {  \r  configurarMenuSecundario(\"formulario\");     \r\r  var vieneModificar = get(\"formulario.vieneModificar\");\r  var tipoInsercion = get(\"formulario.tipoInsercion\");\r  var oidMarcaTemp = get(\"formulario.oidMarcaTemp\");\r  var oidUNegocioTemp = get(\"formulario.oidUNegocioTemp\");\r  var oidNegocioTemp = get(\"formulario.oidNegocioTemp\");\r  var oidSupergenericoTemp = get(\"formulario.oidSupergenericoTemp\");\r  var oidGenericoTemp = get(\"formulario.oidGenericoTemp\");\r  var oidTipoOfertaTemp = get(\"formulario.oidTipoOfertaTemp\");\r  var oidCicloVidaTemp = get(\"formulario.oidCicloVidaTemp\");\r  var lblCodigoProducto = get(\"formulario.lblCodigoProducto\");\r  \r  ocultoCapas();\r\r  if(vieneModificar==\"true\") {\r		var excluirSeleccionado = new Array(); \r    excluirSeleccionado[0] = tipoInsercion;\r    set('formulario.cbInsertar',excluirSeleccionado);	\r\r    set('formulario.txtCodProducto',lblCodigoProducto);	\r\r		var tipoOfertaSeleccionada = new Array(); \r    tipoOfertaSeleccionada[0] = oidTipoOfertaTemp;\r    set('formulario.cbTipoOfertaC',tipoOfertaSeleccionada);\r\r		var cicloVidaSeleccionada = new Array(); \r    cicloVidaSeleccionada[0] = oidCicloVidaTemp;\r    set('formulario.cbCicloVidaC',cicloVidaSeleccionada);\r\r		var marcaSeleccionada = new Array(); \r    marcaSeleccionada[0] = oidMarcaTemp;\r    set('formulario.cbMarcaJ',marcaSeleccionada);\r\r		var unidadNegocioSeleccionada = new Array(); \r    unidadNegocioSeleccionada[0] = oidUNegocioTemp;\r    set('formulario.cbUnidadNegocioJ',unidadNegocioSeleccionada);\r\r		var negocioSeleccionada = new Array(); \r    negocioSeleccionada[0] = oidNegocioTemp;\r    set('formulario.cbNegocioJ',negocioSeleccionada);\r\r		var supergenericoSeleccionada = new Array(); \r    supergenericoSeleccionada[0] = oidSupergenericoTemp;\r    set('formulario.cbSupergenericoJ',supergenericoSeleccionada);\r\r		var genericoSeleccionada = new Array(); \r    genericoSeleccionada[0] = oidGenericoTemp;\r    set('formulario.cbGenericoJ',genericoSeleccionada);\r\r		var tipoOfertaSeleccionada = new Array(); \r    tipoOfertaSeleccionada[0] = oidTipoOfertaTemp;\r    set('formulario.cbTipoOfertaJ',tipoOfertaSeleccionada);\r\r		var cicloVidaSeleccionada = new Array(); \r    cicloVidaSeleccionada[0] = oidCicloVidaTemp;\r    set('formulario.cbCicloVidaJ',cicloVidaSeleccionada);\r\r	btmAceptarOnClick();\r  }\r\r  focoComboInsertar();\r  var opcionMenu = get(\"formulario.opcionMenu\");\r  if(opcionMenu==\"consultar\") {\r	deshabilitarTodo();\r	btnProxy(1, '0');	\r	btnProxy(5, '0');	\r  }\r}\r\rfunction deshabilitarTodo(){\r	document.getElementById(\"cbInsertar\").disabled = true;\r	document.getElementById(\"btnAceptar1\").disabled = true;\r	document.getElementById(\"txtCodProducto\").disabled = true;\r	document.getElementById(\"cbCicloVidaC\").disabled = true;\r	document.getElementById(\"cbTipoOfertaC\").disabled = true;\r	document.getElementById(\"cbMarcaJ\").disabled = true;\r	document.getElementById(\"cbUnidadNegocioJ\").disabled = true;\r	document.getElementById(\"cbNegocioJ\").disabled = true;\r	document.getElementById(\"cbSupergenericoJ\").disabled = true;\r	document.getElementById(\"cbGenericoJ\").disabled = true;\r	document.getElementById(\"cbTipoOfertaJ\").disabled = true;\r	document.getElementById(\"cbCicloVidaJ\").disabled = true;\r}\r\rfunction ocultoCapas() {\r	document.all[\"capa2\"].style.visibility= \"hidden\";\r	document.all[\"capa3\"].style.visibility= \"hidden\";\r}\r\rfunction focoCodigoProducto() {\r	focaliza(\"formulario.txtCodProducto\");\r}\r\r\rfunction focoComboMarca() {\r	focaliza(\"formulario.cbMarcaJ\");\r}\r\rfunction focoComboInsertar() {\r	focaliza(\"formulario.cbInsertar\");\r}\r\rfunction muestroCapas(capa) {\r	if(capa==\"capa2\") {\r		document.all[\"capa2\"].style.visibility= \"visible\";\r		document.all[\"capa3\"].style.visibility= \"hidden\";\r		focoCodigoProducto();\r	}\r	else if(capa==\"capa3\"){\r		document.all[\"capa2\"].style.visibility= \"hidden\";\r		document.all[\"capa3\"].style.visibility= \"visible\";\r		focoComboMarca();\r	}	\r	else {\r		document.all[\"capa2\"].style.visibility= \"hidden\";\r		document.all[\"capa3\"].style.visibility= \"hidden\";\r		focoComboInsertar();\r	}\r}\r\rfunction fVolver() {\r	window.close();\r}\r\rfunction btmAceptarOnClick () {\r	var algo = get(\"formulario.varConstanteCodigoProducto\");	\r	var combo = get(\"formulario.cbInsertar\");\r	\r	if(combo==\"\") {\r		muestroCapas(\"ninguna\");\r		return;\r	}\r\r	if(combo==algo) {\r		muestroCapas(\"capa2\");\r	}\r	else {\r		muestroCapas(\"capa3\");\r	}	\r}\r\rfunction fGuardar() {\r	guardarOnClick();\r}\r\rfunction guardarOnClick() {\r	/* Retornar todos los datos del formulario en un arreglo javaScript \r	cerrar ventana */\r\r	if((document.all[\"capa2\"].style.visibility==\"hidden\") && (document.all[\"capa3\"].style.visibility== \"hidden\") ) {\r		return;\r	}\r\r	var algo = get(\"formulario.varConstanteCodigoProducto\");	\r	var combo = get(\"formulario.cbInsertar\");\r\r	if(combo==algo) {\r		if(!sicc_validaciones_generales()){\r		    return;   \r	    }\r		onClickAceptarProducto();\r	}\r	else {\r		onClickAceptarJerarquia();\r	}	\r}\r\rfunction onClickAceptarProducto() {\r	var codigoProducto = get(\"formulario.txtCodProducto\");\r	var tipoOferta = get(\"formulario.cbTipoOfertaC\");\r	var desTipoOferta = get(\"formulario.cbTipoOfertaC\", \"T\");\r	var cicloVida = get(\"formulario.cbCicloVidaC\");\r	var desCicloVida = get(\"formulario.cbCicloVidaC\", \"T\");\r	var oidTipoProducto = get(\"formulario.oidTipoProducto\");\r\r	set(\"formulario.codProducto\", codigoProducto);\r	set(\"formulario.oidTipoOferta\", tipoOferta);\r    set(\"formulario.descTipoOferta\", desTipoOferta);\r    set(\"formulario.oidCicloVida\", cicloVida);\r    set(\"formulario.descCicloVida\", desCicloVida);\r    set(\"formulario.oidTipoProducto\", oidTipoProducto);\r     \r    eval(\"formulario\").oculto= \"S\";\r     \r    set(\"formulario.conectorAction\", \"LPMantenimientoComisionesProductos\");\r    set(\"formulario.accion\", \"AceptarProducto\");\r	enviaSICC(\"formulario\"); \r}\r\rfunction onClickAceptarJerarquia() {\r	var oidMarcaProducto = get(\"formulario.cbMarcaJ\");\r	var descMarcaProducto = get(\"formulario.cbMarcaJ\", \"T\");\r	var oidUnidadNegocio = get(\"formulario.cbUnidadNegocioJ\");\r	var descUnidadNegocio = get(\"formulario.cbUnidadNegocioJ\", \"T\");\r	var oidNegocio = get(\"formulario.cbNegocioJ\");\r	var descNegocio = get(\"formulario.cbNegocioJ\", \"T\");\r	var oidSupergenerico = get(\"formulario.cbSupergenericoJ\");\r	var descSupergenerico = get(\"formulario.cbSupergenericoJ\", \"T\");\r	var oidGenerico = get(\"formulario.cbGenericoJ\");\r	var descGenerico = get(\"formulario.cbGenericoJ\", \"T\");\r	var oidTipoOferta = get(\"formulario.cbTipoOfertaJ\");\r	var descTipoOferta = get(\"formulario.cbTipoOfertaJ\", \"T\");\r	var oidCicloVida = get(\"formulario.cbCicloVidaJ\");\r	var descCicloVida = get(\"formulario.cbCicloVidaJ\", \"T\");\r	var oidTipoProducto = get(\"formulario.oidTipoProducto\");\r\r	if((oidMarcaProducto==\"\") && (oidUnidadNegocio==\"\") && (oidNegocio==\"\") && (oidSupergenerico==\"\") && (oidGenerico==\"\") && (oidTipoOferta==\"\") && (oidCicloVida==\"\")) {\r		GestionarMensaje('1485',null,null,null); \r		focoComboInsertar();\r        return false;      \r	}\r	else {\r		set(\"formulario.oidMarcaProducto\", oidMarcaProducto);\r		set(\"formulario.descMarcaProducto\", descMarcaProducto);\r        set(\"formulario.oidUnidadNegocio\", oidUnidadNegocio);\r        set(\"formulario.descUnidadNegocio\", descUnidadNegocio);\r        set(\"formulario.oidNegocio\", oidNegocio);\r		set(\"formulario.descNegocio\", descNegocio);\r		set(\"formulario.oidSupergenerico\", oidSupergenerico);\r        set(\"formulario.descSupergenerico\", descSupergenerico);\r        set(\"formulario.oidGenerico\", oidGenerico);\r        set(\"formulario.descGenerico\", descGenerico);\r		set(\"formulario.oidTipoOferta\", oidTipoOferta);\r		set(\"formulario.descTipoOferta\", descTipoOferta);\r        set(\"formulario.oidCicloVida\", oidCicloVida);\r        set(\"formulario.descCicloVida\", descCicloVida);\r	    set(\"formulario.oidTipoProducto\", oidTipoProducto);\r      \r        eval(\"formulario\").oculto= \"S\";\r      \r        set(\"formulario.conectorAction\", \"LPMantenimientoComisionesProductos\");\r        set(\"formulario.accion\", \"AceptarJerarquia\");\r        enviaSICC(\"formulario\", \"\", \"\", \"N\"); \r	}\r}\r\rfunction reInicioCodigo(oidTipo, desTipo, oidProducto){\r	var codigoProducto = get(\"formulario.txtCodProducto\");\r	var tipoOferta = get(\"formulario.cbTipoOfertaC\");\r	var desTipoOferta = get(\"formulario.cbTipoOfertaC\", \"T\");\r	var cicloVida = get(\"formulario.cbCicloVidaC\");\r	var desCicloVida = get(\"formulario.cbCicloVidaC\", \"T\");\r	var oidTipoInsercion = get(\"formulario.cbInsertar\");\r\r	if(codigoProducto==\"\") codigoProducto= \" \";\r	if(tipoOferta==\"\") tipoOferta= \" \";\r	if(desTipoOferta==\"\") desTipoOferta= \" \";\r	if(cicloVida==\"\") cicloVida= \" \";\r	if(desCicloVida==\"\") desCicloVida= \" \";\r	if(oidTipoInsercion==\"\") oidTipoInsercion= \" \";\r\r	var array = new Array();\r	var todos = \"\";\r\r	todos = \"codigo\";\r	todos = todos + \",\" + oidTipo;\r	todos = todos + \",\" + desTipo;\r	todos = todos + \",\" + codigoProducto;\r	todos = todos + \",\" + desTipoOferta;\r	todos = todos + \",\" + desCicloVida;\r	todos = todos + \",\" + tipoOferta;\r	todos = todos + \",\" + cicloVida;\r	todos = todos + \",\" + oidTipoInsercion;\r	todos = todos + \",\" + oidProducto;\r\r	array[0] = todos;\r\r	returnValue =array;\r	window.close();\r}\r\rfunction fErrorAlGuardar() {\r  var vieneModificar = get(\"formulario.vieneModificar\");\r  \r  if(vieneModificar==\"true\") {\r	  focoComboMarca();\r  }\r  else {\r	  focoComboInsertar();\r  }\r}\r\rfunction reInicioJerarquia(oidTipo, desTipo) {\r	var oidMarcaProducto = get(\"formulario.cbMarcaJ\");\r	var descMarcaProducto = get(\"formulario.cbMarcaJ\", \"T\");\r	var oidUnidadNegocio = get(\"formulario.cbUnidadNegocioJ\");\r	var descUnidadNegocio = get(\"formulario.cbUnidadNegocioJ\", \"T\");\r	var oidNegocio = get(\"formulario.cbNegocioJ\");\r	var descNegocio = get(\"formulario.cbNegocioJ\", \"T\");\r	var oidSupergenerico = get(\"formulario.cbSupergenericoJ\");\r	var descSupergenerico = get(\"formulario.cbSupergenericoJ\", \"T\");\r	var oidGenerico = get(\"formulario.cbGenericoJ\");\r	var descGenerico = get(\"formulario.cbGenericoJ\", \"T\");\r	var oidTipoOferta = get(\"formulario.cbTipoOfertaJ\");\r	var descTipoOferta = get(\"formulario.cbTipoOfertaJ\", \"T\");\r	var oidCicloVida = get(\"formulario.cbCicloVidaJ\");\r	var descCicloVida = get(\"formulario.cbCicloVidaJ\", \"T\");	\r	var oidTipoInsercion = get(\"formulario.cbInsertar\");\r\r	if(oidMarcaProducto==\"\") oidMarcaProducto= \" \";\r	if(descMarcaProducto==\"\") descMarcaProducto= \" \";\r	if(oidUnidadNegocio==\"\") oidUnidadNegocio= \" \";\r	if(descUnidadNegocio==\"\") descUnidadNegocio= \" \";\r	if(oidNegocio==\"\") oidNegocio= \" \";\r	if(descNegocio==\"\") descNegocio= \" \";\r	if(oidSupergenerico==\"\") oidSupergenerico= \" \";\r	if(descSupergenerico==\"\") descSupergenerico= \" \";\r	if(oidGenerico==\"\") oidGenerico= \" \";\r	if(descGenerico==\"\") descGenerico= \" \";\r	if(oidTipoOferta==\"\") oidTipoOferta= \" \";\r	if(descTipoOferta==\"\") descTipoOferta= \" \";\r	if(oidCicloVida==\"\") oidCicloVida= \" \";\r	if(descCicloVida==\"\") descCicloVida= \" \";\r	if(oidTipoInsercion==\"\") oidTipoInsercion= \" \";\r\r	var array = new Array();\r	var todos = \"\";\r	\r	todos = \"jerarquia\";\r	todos = todos + \",\" + oidMarcaProducto;\r	todos = todos + \",\" + descMarcaProducto;\r	todos = todos + \",\" + oidUnidadNegocio;\r	todos = todos + \",\" + descUnidadNegocio;\r	todos = todos + \",\" + oidNegocio;\r	todos = todos + \",\" + descNegocio;\r	todos = todos + \",\" + oidSupergenerico;\r	todos = todos + \",\" + descSupergenerico;\r	todos = todos + \",\" + oidGenerico;	\r	todos = todos + \",\" + descGenerico;\r	todos = todos + \",\" + oidTipoOferta;\r	todos = todos + \",\" + descTipoOferta;\r	todos = todos + \",\" + oidCicloVida;\r	todos = todos + \",\" + descCicloVida;\r	todos = todos + \",\" + oidTipoInsercion;\r	todos = todos + \",\" + oidTipo;\r	todos = todos + \",\" + desTipo;\r\r	array[0] = todos;\r\r	returnValue =array;\r	window.close();\r}\r\rfunction onTabBotonAceptar() {\r	var capa2 = document.all[\"capa2\"].style.visibility;\r	var capa3 = document.all[\"capa3\"].style.visibility;\r\r	if((capa2=='hidden') && (capa3=='hidden')) {\r		focoComboInsertar();\r		return;\r    }  \r\r	if(capa2!='hidden') {\r		focoCodigoProducto();\r		return;\r	}\r	if(capa3!='hidden') {\r		focoComboMarca();\r		return;\r	}\r}\r\rfunction onShTabComboInsertar() {\r	var capa2 = document.all[\"capa2\"].style.visibility;\r	var capa3 = document.all[\"capa3\"].style.visibility;\r\r	if((capa2=='hidden') && (capa3=='hidden')) {\r		focalizaBotonHTML('botonContenido','btnAceptar1');\r		return;\r    }  \r\r	if(capa2!='hidden') {\r		focaliza(\"formulario.cbTipoOfertaC\");\r		return;\r	}\r	if(capa3!='hidden') {\r		focaliza(\"formulario.cbCicloVidaJ\");\r		return;\r	}	\r}\r\rfunction onTabComboTipoOferta() {\r	focoComboInsertar();\r}\r\rfunction onTabCicloVida() {\r	focoComboInsertar();\r}\r\r\r \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtCodProducto" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("format","t" );
      ((Element)v.get(8)).setAttribute("cod","337" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","varPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","varOidCanal" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","varOidMarca" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","varConstanteCodigoProducto" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","vieneModificar" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","tipoInsercion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidMarcaTemp" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidUNegocioTemp" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","oidNegocioTemp" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","oidSupergenericoTemp" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidGenericoTemp" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidTipoOfertaTemp" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidCicloVidaTemp" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","codProducto" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidTipoOferta" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","descTipoOferta" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","oidCicloVida" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","descCicloVida" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","oidMarcaProducto" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","descMarcaProducto" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oidUnidadNegocio" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","descUnidadNegocio" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidNegocio" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","descNegocio" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","oidSupergenerico" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","descSupergenerico" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","oidGenerico" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","descGenerico" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","oidTipoProducto" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","lblCodigoProducto" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","oidTipoPlantilla" );
      ((Element)v.get(45)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(9)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","titulo" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(48)).setAttribute("nombre","capa1" );
      ((Element)v.get(9)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(52)).setAttribute("height","12" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","750" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","12" );
      ((Element)v.get(50)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(56)).setAttribute("height","1" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:50   */

      /* Empieza nodo:57 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(62)).setAttribute("class","legend" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblProductosIncluidos" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","legend" );
      ((Element)v.get(63)).setAttribute("cod","00646" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(64)).setAttribute("border","0" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("cellpadding","0" );
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("colspan","4" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","6" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","1338" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:68   */

      /* Empieza nodo:79 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lbldtMarca" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lbldtUnidadNegocio" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(79)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:79   */
      /* Termina nodo:64   */

      /* Empieza nodo:90 / Elemento padre: 61   */
      v.add(doc.createElement("table"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(90)).setAttribute("border","0" );
      ((Element)v.get(90)).setAttribute("align","center" );
      ((Element)v.get(90)).setAttribute("cellspacing","0" );
      ((Element)v.get(90)).setAttribute("cellpadding","0" );
      ((Element)v.get(61)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("colspan","4" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","588" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","590" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(94)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:94   */

      /* Empieza nodo:105 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(109)).setAttribute("nombre","lbldtNegocio" );
      ((Element)v.get(109)).setAttribute("alto","13" );
      ((Element)v.get(109)).setAttribute("filas","1" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","25" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lbldtSupergenerico" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(105)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:105   */
      /* Termina nodo:90   */

      /* Empieza nodo:116 / Elemento padre: 61   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","100%" );
      ((Element)v.get(116)).setAttribute("border","0" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("cellpadding","0" );
      ((Element)v.get(61)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("colspan","4" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:120 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(120));

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
      ((Element)v.get(124)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("cod","589" );
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
      ((Element)v.get(128)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("cod","608" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(120)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:120   */

      /* Empieza nodo:131 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lbldtGenerico" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(139)).setAttribute("nombre","lbldtTipoOferta" );
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("filas","1" );
      ((Element)v.get(139)).setAttribute("valor","" );
      ((Element)v.get(139)).setAttribute("id","datosCampos" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(131)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:131   */
      /* Termina nodo:116   */

      /* Empieza nodo:142 / Elemento padre: 61   */
      v.add(doc.createElement("table"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(142)).setAttribute("border","0" );
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(142)).setAttribute("cellspacing","0" );
      ((Element)v.get(142)).setAttribute("cellpadding","0" );
      ((Element)v.get(61)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("colspan","4" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:146 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(150)).setAttribute("id","datosTitle" );
      ((Element)v.get(150)).setAttribute("cod","581" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:146   */

      /* Empieza nodo:153 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lbldtCicloVida" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("valor","" );
      ((Element)v.get(157)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(153)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:153   */

      /* Empieza nodo:160 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("colspan","4" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:142   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:163 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:57   */

      /* Empieza nodo:165 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(166)).setAttribute("align","center" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(167)).setAttribute("height","15" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:168 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(173)).setAttribute("class","legend" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("id","legend" );
      ((Element)v.get(174)).setAttribute("cod","00275" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("table"));
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(175)).setAttribute("border","0" );
      ((Element)v.get(175)).setAttribute("align","center" );
      ((Element)v.get(175)).setAttribute("cellspacing","0" );
      ((Element)v.get(175)).setAttribute("cellpadding","0" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("colspan","4" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblInsertar" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","00647" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:179   */

      /* Empieza nodo:186 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(186)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(190)).setAttribute("nombre","cbInsertar" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).setAttribute("size","1" );
      ((Element)v.get(190)).setAttribute("multiple","N" );
      ((Element)v.get(190)).setAttribute("req","N" );
      ((Element)v.get(190)).setAttribute("valorinicial","" );
      ((Element)v.get(190)).setAttribute("textoinicial","" );
      ((Element)v.get(190)).setAttribute("onshtab","onShTabComboInsertar();" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:192 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("width","100%" );
      ((Element)v.get(186)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:186   */

      /* Empieza nodo:194 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("colspan","4" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:175   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:197 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:168   */

      /* Empieza nodo:199 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("table"));
      ((Element)v.get(204)).setAttribute("width","100%" );
      ((Element)v.get(204)).setAttribute("border","0" );
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(204)).setAttribute("cellspacing","0" );
      ((Element)v.get(204)).setAttribute("cellpadding","0" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("class","botonera" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(207)).setAttribute("nombre","btnAceptar1" );
      ((Element)v.get(207)).setAttribute("ID","botonContenido" );
      ((Element)v.get(207)).setAttribute("tipo","html" );
      ((Element)v.get(207)).setAttribute("accion","btmAceptarOnClick();" );
      ((Element)v.get(207)).setAttribute("estado","false" );
      ((Element)v.get(207)).setAttribute("cod","12" );
      ((Element)v.get(207)).setAttribute("ontab","onTabBotonAceptar();" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:208 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","12" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:199   */

      /* Empieza nodo:210 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("width","12" );
      ((Element)v.get(211)).setAttribute("align","center" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(212)).setAttribute("width","12" );
      ((Element)v.get(212)).setAttribute("height","15" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("width","750" );
      ((Element)v.get(210)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("width","12" );
      ((Element)v.get(210)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","12" );
      ((Element)v.get(216)).setAttribute("height","1" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:210   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:217 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(217)).setAttribute("nombre","capa2" );
      ((Element)v.get(217)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(217)).setAttribute("borde","0" );
      ((Element)v.get(217)).setAttribute("imagenf","" );
      ((Element)v.get(217)).setAttribute("repeat","" );
      ((Element)v.get(217)).setAttribute("padding","" );
      ((Element)v.get(217)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(217)).setAttribute("contravsb","" );
      ((Element)v.get(217)).setAttribute("x","0" );
      ((Element)v.get(217)).setAttribute("y","270" );
      ((Element)v.get(217)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("table"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(218)).setAttribute("border","0" );
      ((Element)v.get(218)).setAttribute("cellspacing","0" );
      ((Element)v.get(218)).setAttribute("cellpadding","0" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("width","12" );
      ((Element)v.get(220)).setAttribute("align","center" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","12" );
      ((Element)v.get(221)).setAttribute("height","12" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("width","750" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(219)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","12" );
      ((Element)v.get(225)).setAttribute("height","1" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:219   */

      /* Empieza nodo:226 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(231)).setAttribute("class","legend" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(232)).setAttribute("nombre","lblProductosExcluidos" );
      ((Element)v.get(232)).setAttribute("alto","13" );
      ((Element)v.get(232)).setAttribute("filas","1" );
      ((Element)v.get(232)).setAttribute("valor","" );
      ((Element)v.get(232)).setAttribute("id","legend" );
      ((Element)v.get(232)).setAttribute("cod","00339" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 230   */
      v.add(doc.createElement("table"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(233)).setAttribute("border","0" );
      ((Element)v.get(233)).setAttribute("align","center" );
      ((Element)v.get(233)).setAttribute("cellspacing","0" );
      ((Element)v.get(233)).setAttribute("cellpadding","0" );
      ((Element)v.get(230)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).setAttribute("colspan","4" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:237 / Elemento padre: 233   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(241)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(241)).setAttribute("alto","13" );
      ((Element)v.get(241)).setAttribute("filas","1" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("id","datosTitle" );
      ((Element)v.get(241)).setAttribute("cod","337" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:237   */

      /* Empieza nodo:244 / Elemento padre: 233   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(244));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(248)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(248)).setAttribute("id","datosCampos" );
      ((Element)v.get(248)).setAttribute("max","20" );
      ((Element)v.get(248)).setAttribute("tipo","" );
      ((Element)v.get(248)).setAttribute("onchange","" );
      ((Element)v.get(248)).setAttribute("req","S" );
      ((Element)v.get(248)).setAttribute("size","27" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(248)).setAttribute("validacion","" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(244)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:244   */
      /* Termina nodo:233   */

      /* Empieza nodo:251 / Elemento padre: 230   */
      v.add(doc.createElement("table"));
      ((Element)v.get(251)).setAttribute("width","100%" );
      ((Element)v.get(251)).setAttribute("border","0" );
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(251)).setAttribute("cellspacing","0" );
      ((Element)v.get(251)).setAttribute("cellpadding","0" );
      ((Element)v.get(230)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("colspan","4" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:255 / Elemento padre: 251   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(251)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(259)).setAttribute("nombre","lblCicloVida3" );
      ((Element)v.get(259)).setAttribute("alto","13" );
      ((Element)v.get(259)).setAttribute("filas","1" );
      ((Element)v.get(259)).setAttribute("valor","" );
      ((Element)v.get(259)).setAttribute("id","datosTitle" );
      ((Element)v.get(259)).setAttribute("cod","581" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(263)).setAttribute("nombre","lblTipoOferta3" );
      ((Element)v.get(263)).setAttribute("alto","13" );
      ((Element)v.get(263)).setAttribute("filas","1" );
      ((Element)v.get(263)).setAttribute("valor","" );
      ((Element)v.get(263)).setAttribute("id","datosTitle" );
      ((Element)v.get(263)).setAttribute("cod","608" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(255)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:255   */

      /* Empieza nodo:266 / Elemento padre: 251   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(251)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(266)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(270)).setAttribute("nombre","cbCicloVidaC" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("size","1" );
      ((Element)v.get(270)).setAttribute("multiple","N" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(270)).setAttribute("valorinicial","" );
      ((Element)v.get(270)).setAttribute("textoinicial","" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:272 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","25" );
      ((Element)v.get(273)).setAttribute("height","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(266)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(275)).setAttribute("nombre","cbTipoOfertaC" );
      ((Element)v.get(275)).setAttribute("id","datosCampos" );
      ((Element)v.get(275)).setAttribute("size","1" );
      ((Element)v.get(275)).setAttribute("multiple","N" );
      ((Element)v.get(275)).setAttribute("req","N" );
      ((Element)v.get(275)).setAttribute("valorinicial","" );
      ((Element)v.get(275)).setAttribute("textoinicial","" );
      ((Element)v.get(275)).setAttribute("ontab","onTabComboTipoOferta();" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:277 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("width","100%" );
      ((Element)v.get(266)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","8" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:266   */

      /* Empieza nodo:279 / Elemento padre: 251   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(251)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).setAttribute("colspan","4" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","8" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:251   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:282 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:226   */

      /* Empieza nodo:284 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("width","12" );
      ((Element)v.get(285)).setAttribute("align","center" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","12" );
      ((Element)v.get(286)).setAttribute("height","12" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).setAttribute("width","750" );
      ((Element)v.get(284)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).setAttribute("width","12" );
      ((Element)v.get(284)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","12" );
      ((Element)v.get(290)).setAttribute("height","1" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:284   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:291 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(291)).setAttribute("nombre","capa3" );
      ((Element)v.get(291)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(291)).setAttribute("borde","0" );
      ((Element)v.get(291)).setAttribute("imagenf","" );
      ((Element)v.get(291)).setAttribute("repeat","" );
      ((Element)v.get(291)).setAttribute("padding","" );
      ((Element)v.get(291)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(291)).setAttribute("contravsb","" );
      ((Element)v.get(291)).setAttribute("x","0" );
      ((Element)v.get(291)).setAttribute("y","270" );
      ((Element)v.get(291)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("table"));
      ((Element)v.get(292)).setAttribute("width","100%" );
      ((Element)v.get(292)).setAttribute("border","0" );
      ((Element)v.get(292)).setAttribute("cellspacing","0" );
      ((Element)v.get(292)).setAttribute("cellpadding","0" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("width","12" );
      ((Element)v.get(294)).setAttribute("align","center" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","12" );
      ((Element)v.get(295)).setAttribute("height","12" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).setAttribute("width","750" );
      ((Element)v.get(293)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).setAttribute("width","12" );
      ((Element)v.get(293)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","12" );
      ((Element)v.get(299)).setAttribute("height","1" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:293   */

      /* Empieza nodo:300 / Elemento padre: 292   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(292)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(305)).setAttribute("class","legend" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(306)).setAttribute("nombre","lblProductosExcluidos3" );
      ((Element)v.get(306)).setAttribute("alto","13" );
      ((Element)v.get(306)).setAttribute("filas","1" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("id","legend" );
      ((Element)v.get(306)).setAttribute("cod","00339" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 304   */
      v.add(doc.createElement("table"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(307)).setAttribute("border","0" );
      ((Element)v.get(307)).setAttribute("align","center" );
      ((Element)v.get(307)).setAttribute("cellspacing","0" );
      ((Element)v.get(307)).setAttribute("cellpadding","0" );
      ((Element)v.get(304)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).setAttribute("colspan","4" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:311 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(315)).setAttribute("nombre","lblMarca3" );
      ((Element)v.get(315)).setAttribute("alto","13" );
      ((Element)v.get(315)).setAttribute("filas","1" );
      ((Element)v.get(315)).setAttribute("valor","" );
      ((Element)v.get(315)).setAttribute("id","datosTitle" );
      ((Element)v.get(315)).setAttribute("cod","6" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","25" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(319)).setAttribute("nombre","lblUnidadNegocio3" );
      ((Element)v.get(319)).setAttribute("alto","13" );
      ((Element)v.get(319)).setAttribute("filas","1" );
      ((Element)v.get(319)).setAttribute("valor","" );
      ((Element)v.get(319)).setAttribute("id","datosTitle" );
      ((Element)v.get(319)).setAttribute("cod","1338" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(311)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:311   */

      /* Empieza nodo:322 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","8" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 322   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("nowrap","nowrap" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(322)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(326)).setAttribute("nombre","cbMarcaJ" );
      ((Element)v.get(326)).setAttribute("id","datosCampos" );
      ((Element)v.get(326)).setAttribute("size","1" );
      ((Element)v.get(326)).setAttribute("multiple","N" );
      ((Element)v.get(326)).setAttribute("req","N" );
      ((Element)v.get(326)).setAttribute("valorinicial","" );
      ((Element)v.get(326)).setAttribute("textoinicial","" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:328 / Elemento padre: 322   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","25" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 322   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(322)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(331)).setAttribute("nombre","cbUnidadNegocioJ" );
      ((Element)v.get(331)).setAttribute("id","datosCampos" );
      ((Element)v.get(331)).setAttribute("size","1" );
      ((Element)v.get(331)).setAttribute("multiple","N" );
      ((Element)v.get(331)).setAttribute("req","N" );
      ((Element)v.get(331)).setAttribute("valorinicial","" );
      ((Element)v.get(331)).setAttribute("textoinicial","" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:333 / Elemento padre: 322   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("width","100%" );
      ((Element)v.get(322)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:322   */
      /* Termina nodo:307   */

      /* Empieza nodo:335 / Elemento padre: 304   */
      v.add(doc.createElement("table"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(335)).setAttribute("border","0" );
      ((Element)v.get(335)).setAttribute("align","center" );
      ((Element)v.get(335)).setAttribute("cellspacing","0" );
      ((Element)v.get(335)).setAttribute("cellpadding","0" );
      ((Element)v.get(304)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("colspan","4" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:339 / Elemento padre: 335   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(335)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(343)).setAttribute("nombre","lblNegocio3" );
      ((Element)v.get(343)).setAttribute("alto","13" );
      ((Element)v.get(343)).setAttribute("filas","1" );
      ((Element)v.get(343)).setAttribute("valor","" );
      ((Element)v.get(343)).setAttribute("id","datosTitle" );
      ((Element)v.get(343)).setAttribute("cod","588" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","25" );
      ((Element)v.get(345)).setAttribute("height","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(347)).setAttribute("nombre","lblSupergenerico3" );
      ((Element)v.get(347)).setAttribute("alto","13" );
      ((Element)v.get(347)).setAttribute("filas","1" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(347)).setAttribute("valor","" );
      ((Element)v.get(347)).setAttribute("id","datosTitle" );
      ((Element)v.get(347)).setAttribute("cod","590" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(339)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:339   */

      /* Empieza nodo:350 / Elemento padre: 335   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(335)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","8" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(350)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(354)).setAttribute("nombre","cbNegocioJ" );
      ((Element)v.get(354)).setAttribute("id","datosCampos" );
      ((Element)v.get(354)).setAttribute("size","1" );
      ((Element)v.get(354)).setAttribute("multiple","N" );
      ((Element)v.get(354)).setAttribute("req","N" );
      ((Element)v.get(354)).setAttribute("valorinicial","" );
      ((Element)v.get(354)).setAttribute("textoinicial","" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:356 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","25" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(350)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(359)).setAttribute("nombre","cbSupergenericoJ" );
      ((Element)v.get(359)).setAttribute("id","datosCampos" );
      ((Element)v.get(359)).setAttribute("size","1" );
      ((Element)v.get(359)).setAttribute("multiple","N" );
      ((Element)v.get(359)).setAttribute("req","N" );
      ((Element)v.get(359)).setAttribute("valorinicial","" );
      ((Element)v.get(359)).setAttribute("textoinicial","" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:361 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).setAttribute("width","100%" );
      ((Element)v.get(350)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:350   */
      /* Termina nodo:335   */

      /* Empieza nodo:363 / Elemento padre: 304   */
      v.add(doc.createElement("table"));
      ((Element)v.get(363)).setAttribute("width","100%" );
      ((Element)v.get(363)).setAttribute("border","0" );
      ((Element)v.get(363)).setAttribute("align","center" );
      ((Element)v.get(363)).setAttribute("cellspacing","0" );
      ((Element)v.get(363)).setAttribute("cellpadding","0" );
      ((Element)v.get(304)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).setAttribute("colspan","4" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","8" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:367 / Elemento padre: 363   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(363)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(371)).setAttribute("nombre","lblGenerico3" );
      ((Element)v.get(371)).setAttribute("alto","13" );
      ((Element)v.get(371)).setAttribute("filas","1" );
      ((Element)v.get(371)).setAttribute("valor","" );
      ((Element)v.get(371)).setAttribute("id","datosTitle" );
      ((Element)v.get(371)).setAttribute("cod","589" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","25" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(375)).setAttribute("nombre","lblTipoOferta33" );
      ((Element)v.get(375)).setAttribute("alto","13" );
      ((Element)v.get(375)).setAttribute("filas","1" );
      ((Element)v.get(375)).setAttribute("valor","" );
      ((Element)v.get(375)).setAttribute("id","datosTitle" );
      ((Element)v.get(375)).setAttribute("cod","608" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).setAttribute("width","100%" );
      ((Element)v.get(367)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","8" );
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:367   */

      /* Empieza nodo:378 / Elemento padre: 363   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(363)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","8" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(378)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(382)).setAttribute("nombre","cbGenericoJ" );
      ((Element)v.get(382)).setAttribute("id","datosCampos" );
      ((Element)v.get(382)).setAttribute("size","1" );
      ((Element)v.get(382)).setAttribute("multiple","N" );
      ((Element)v.get(382)).setAttribute("req","N" );
      ((Element)v.get(382)).setAttribute("valorinicial","" );
      ((Element)v.get(382)).setAttribute("textoinicial","" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:384 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","25" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(378)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(387)).setAttribute("nombre","cbTipoOfertaJ" );
      ((Element)v.get(387)).setAttribute("id","datosCampos" );
      ((Element)v.get(387)).setAttribute("size","1" );
      ((Element)v.get(387)).setAttribute("multiple","N" );
      ((Element)v.get(387)).setAttribute("req","N" );
      ((Element)v.get(387)).setAttribute("valorinicial","" );
      ((Element)v.get(387)).setAttribute("textoinicial","" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:389 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(389)).setAttribute("width","100%" );
      ((Element)v.get(378)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(390)).setAttribute("width","8" );
      ((Element)v.get(390)).setAttribute("height","8" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:378   */
      /* Termina nodo:363   */

      /* Empieza nodo:391 / Elemento padre: 304   */
      v.add(doc.createElement("table"));
      ((Element)v.get(391)).setAttribute("width","100%" );
      ((Element)v.get(391)).setAttribute("border","0" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(391)).setAttribute("align","center" );
      ((Element)v.get(391)).setAttribute("cellspacing","0" );
      ((Element)v.get(391)).setAttribute("cellpadding","0" );
      ((Element)v.get(304)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).setAttribute("colspan","4" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","8" );
      ((Element)v.get(394)).setAttribute("height","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:395 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(399)).setAttribute("nombre","lblCicloVida33" );
      ((Element)v.get(399)).setAttribute("alto","13" );
      ((Element)v.get(399)).setAttribute("filas","1" );
      ((Element)v.get(399)).setAttribute("valor","" );
      ((Element)v.get(399)).setAttribute("id","datosTitle" );
      ((Element)v.get(399)).setAttribute("cod","581" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).setAttribute("width","100%" );
      ((Element)v.get(395)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:395   */

      /* Empieza nodo:402 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(402)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(406)).setAttribute("nombre","cbCicloVidaJ" );
      ((Element)v.get(406)).setAttribute("id","datosCampos" );
      ((Element)v.get(406)).setAttribute("size","1" );
      ((Element)v.get(406)).setAttribute("multiple","N" );
      ((Element)v.get(406)).setAttribute("req","N" );
      ((Element)v.get(406)).setAttribute("valorinicial","" );
      ((Element)v.get(406)).setAttribute("textoinicial","" );
      ((Element)v.get(406)).setAttribute("ontab","onTabCicloVida();" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:408 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).setAttribute("width","100%" );
      ((Element)v.get(402)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","8" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:402   */

      /* Empieza nodo:410 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).setAttribute("colspan","4" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","8" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:391   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:413 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:300   */

      /* Empieza nodo:415 / Elemento padre: 292   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(292)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(416)).setAttribute("width","12" );
      ((Element)v.get(416)).setAttribute("align","center" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","12" );
      ((Element)v.get(417)).setAttribute("height","12" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).setAttribute("width","750" );
      ((Element)v.get(415)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("width","12" );
      ((Element)v.get(415)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","12" );
      ((Element)v.get(421)).setAttribute("height","1" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:415   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:9   */


   }

}
