//----------------------------------------------
//	Gestión de teclas rapidas
//----------------------------------------------
document.onkeydown = fnCheckKeys;

//----------------------------------------------
//	Variables genericas para todas las entidades 
//----------------------------------------------
//Tamaño de la pagina
var mmgPageSize = 10; 

//Servelt donde lanzar las peticiones de LPs y de paginas
var mmgServlet = 'sicc0000jg';

//Pagina usadad para abri popups con botonera
var mmgFramedDialogHtml = 'mmgframesdialog.html';

//Separador de entidades en cadenas
var mmgEntitySeparator = '<--ENTITY_SEPARATOR-->';

//Separador de atributos de una entidad en cadenas
var mmgAttributeSeparator = '<--ATTRIBUTE_SEPARATOR-->';

//Constantes que definen las columnas de los vector de gestión de foco
var mmgCombFocusOrderColumnOrder = 0;
var mmgCombFocusOrderColumnPreviousQuery = 1;
var mmgCombFocusOrderColumnPreviousCreate = 2;
var mmgCombFocusOrderColumnPreviousUpdate = 3;
var mmgCombFocusOrderColumnNextQuery = 4;
var mmgCombFocusOrderColumnNextCreate = 5;
var mmgCombFocusOrderColumnCreateUpdate = 6;

//Cosntantes que definen las columnas de los vectores de jerarquias de combos dependientes
var mmgComboDependeceColumnComboName = 0;
var mmgComboDependeceColumnParents = 1;
var mmgComboDependeceColumnChildren = 2;
var mmgComboDependeceColumnEntityName = 3;

//constantes que definene los posibles modos de la pantalla
var MMG_MODE_CREATE = 1;
var MMG_MODE_QUERY = 2;
var MMG_MODE_UPDATE_QUERY = 3;
var MMG_MODE_UPDATE_FORM = 4;
var MMG_MODE_REMOVE = 5;
var MMG_MODE_VIEW = 6;

//Constante de códigos de retorno
var MMG_RC_OK = 0;

//----------------------------------------------------
//	INICIO - Funciones de interfaz del menu secundario
//----------------------------------------------------
function fGuardar(){
	Guardar();
}

function fVolver(){
	Volver();
}

function fBorrar(){
	Borrar();
}

function fLimpiar(){
	Limpiar();
}

//----------------------------------------------------
//	Funciones internacionalización
//----------------------------------------------------
//Nos permite generar una cade con la concatenación de todas las descripciones
//de un determinado atriburo separados por
function buildLocalizedString(formName, localizationOrder){
	var localicedString = "";
    var arrOids = get(formName + '.hOidsIdiomas').split('|');
	for (var i=0;i < (arrOids.length-1); i++){
		var value = get(formName + '.hi18NTraduccion_'+ localizationOrder + '_' + arrOids[i]);
		//localicedString += (value == null || value == ""? " ": value);
		localicedString += value ;
		if(i < (arrOids.length-2) ) localicedString += mmgEntitySeparator;
	}
	return localicedString;
}

//Operacion contraria a buildLocalizedString: pasado un string lo se
function unbuildLocalizedString(formName, localizationOrder, localizationString){
	var localicedString = "";
    var arrOids = get(formName + '.hOidsIdiomas').split('|');
    var values = localizationString.split(mmgEntitySeparator);
	for (var i=0;i < (arrOids.length-1); i++){
		set(formName + '.hi18NTraduccion_'+ localizationOrder + '_' + arrOids[i], values[i]);
	}
}

//Nos permite establecer el valor del idioma por defecto de un atributo internacionalizable
function setDefaultLanguageValue(formName, attributeName, localizationOrder, value){
	//Determinamos el código del idioma por defecto
	var defaultLanguageCode = get(formName+ '.defaultLanguageCode');
	
	//Determinamos el vector con los valores del atributo
	set(formName + '.hi18NTraduccion_'+ localizationOrder + '_' + defaultLanguageCode, value);
}

//Nos permite cargar en el widget de un campo internacionalizable su valor
function loadLocalizationWidget(formName, attributeName, localizationOrder){
	//Determinamos el código del idioma por defecto
	var defaultLanguageCode = get(formName+ '.defaultLanguageCode');
	
	//Actualizamos el widget
	set(formName + '.' + attributeName, 
		get(formName + '.hi18NTraduccion_'+ localizationOrder + '_' + defaultLanguageCode));
}

//Nos permite chequear que se ha dado valor al idioma por defecto de un determinado atributo internacionalizable
function hasDefaultLanguageValue(formName, localizationOrder){
	var defaultLanguageCode = get(formName+ '.defaultLanguageCode');
	var value = get(formName + '.hi18NTraduccion_'+ localizationOrder + '_' + defaultLanguageCode);
	if(value == null || cdos_trim(value) == "") return false;
	else return true;
}

//Nos permite abrir la pantalla de internacionalización
function openLocalizationDialog(formName, attributeName, localizationOrder){
	//Abrimos la ventana de actualización
	levantarI18N (formName, localizationOrder);
	
	//Actualizamos el valor del widget con el valor del idioma por defecto
	var defaultLanguageCode = get(formName+ '.defaultLanguageCode');
	set(formName + '.' +  attributeName, get(formName + '.hi18NTraduccion_'+ localizationOrder + '_' + defaultLanguageCode));
}


//----------------------------------------------------
//	gestión foco
//----------------------------------------------------
//Nos permite saber según el modo que columna del vector de acciones de foco debemos usar
function getFocusColumn(form, siguiente){
	var colAccion;
	var accion = get(form + '.accion');
	var origen = get(form + '.origen');
	if(accion == "query"){
		if(siguiente) colAccion = 4;
		else colAccion = 1;
	}else if(accion == "remove"){
		if(siguiente) colAccion = 4;
		else colAccion = 1;
	}else if(accion == "create"){
		if(siguiente) colAccion = 5;
		else colAccion = 2;
	}else if(accion == "update" && origen == "menu"){
		if(siguiente) colAccion = 4;
		else colAccion = 1;
	}else if(accion == "update" && origen == "pagina"){
		if(siguiente) colAccion = 6;
		else colAccion = 3;
	}
	return colAccion;
}

//Esta función nos permite gestinar el foco dentro del formulario de la patalla
function ejecutarAccionFoco(form, orden, siguiente){
	//Primero determinamos el indice dentro del vector de acciones 
	var colAccion = getFocusColumn(form, siguiente);
		
	//Determinamos la accion a ejecutar
	var accionFoco = "";
	var indice = accionesFoco.buscar(orden, 0);
	var accionTmp = ""
	
	//Por EMP
	//Esta linea es para evitar problemas en el salto de control a control
	var tr=document.body.createTextRange();tr.execCommand("Unselect");
	
	if(siguiente){
		for(var i = indice+1; i < accionesFoco.longitud; i++){
			accionTmp = accionesFoco.ij(i, colAccion);
			if(accionTmp != ""){
				accionFoco = accionTmp;
				break;
			}
		}
		//Si todavía no tenemos acción puede ser porque sea la primera
		if(accionFoco == ""){
			for(var i = 0;  i >= 0 && i < accionesFoco.longitud; i++){
				var accionTmp = accionesFoco.ij(i, colAccion);
				if(accionTmp != ""){
					accionFoco = accionTmp;
					break;
				}
			}
		}
	}else{
		for(var i = indice-1; i >= 0; i--){
			accionTmp = accionesFoco.ij(i, colAccion);
			if(accionTmp != ""){
				accionFoco = accionTmp;
				break;
			}
		}
		//Si todavía no tenemos acción puede ser porque sea la primera
		if(accionTmp == ""){
			for(var i = accionesFoco.longitud -1; i >= 0; i--){
				var accionTmp = accionesFoco.ij(i, colAccion);
				if(accionTmp != ""){
					accionFoco = accionTmp;
					break;
				}
			}
		}
	}
	//Finalmente ejecutamos la acción
	eval(accionFoco);
}

//Esta función nos permite gestinar el foco dentro del formulario de la patalla en el modo de modificacion
function ejecutarAccionFocoModificacion(form, orden, siguiente){
	//Primero determinamos el indice dentro del vector de acciones 
	var colAccion = getFocusColumn(form, siguiente);
		
	//Determinamos la accion a ejecutar
	var accionFoco = "";
	var indice = accionesFocoModificacion.buscar(orden, 0);
	var accionTmp = ""
	
	//Por EMP
	//Esta linea es para evitar problemas en el salto de control a control
	var tr=document.body.createTextRange();tr.execCommand("Unselect");
	
	if(siguiente){
		for(var i = indice+1; i < accionesFocoModificacion.longitud; i++){
			accionTmp = accionesFocoModificacion.ij(i, colAccion);
			if(accionTmp != ""){
				accionFoco = accionTmp;
				break;
			}
		}
		
		//Si todavía no tenemos acción puede ser porque sea la primera
		if(accionFoco == ""){
			for(var i = 0;  i >= 0 && i < accionesFocoModificacion.longitud; i++){
				var accionTmp = accionesFocoModificacion.ij(i, colAccion);
				if(accionTmp != ""){
					accionFoco = accionTmp;
					break;
				}
			}
		}
	}else{
		for(var i = indice-1; i >= 0; i--){
			accionTmp = accionesFocoModificacion.ij(i, colAccion);
			if(accionTmp != ""){
				accionFoco = accionTmp;
				break;
			}
		}
		
		//Si todavía no tenemos acción puede ser porque sea la primera
		if(accionTmp == ""){
			for(var i = accionesFocoModificacion.longitud -1; i >= 0; i--){
				var accionTmp = accionesFocoModificacion.ij(i, colAccion);
				if(accionTmp != ""){
					accionFoco = accionTmp;
					break;
				}
			}
		}
	}
	//Finalmente ejecutamos la acción
	eval(accionFoco);
}

//Nos permite poner el foco en el primer campo
function focusFirstField(form, siguiente){
	var colAccion = getFocusColumn(form, siguiente);
	
	for(var i=0; i < accionesFoco.longitud; i++){
		var accion = accionesFoco.ij(i, colAccion);
		if(accion != ""){
			eval(accion);
			return;
		}
	}
}

//Por EMP
//Nos permite poner el foco en el primer campo
//Seria mas interesante modificar la funcion anterior para que reciba un ptro al array
//de acciones a ejecutar y que fuese el mismo método. Pero para evitar problemas con la generacion
//he decidido ir a lo mas rápido.
function focusFirstFieldModify(form, siguiente){
	var colAccion = getFocusColumn(form, siguiente);
	
	for(var i=0; i < accionesFocoModificacion.longitud; i++){
		var accion = accionesFocoModificacion.ij(i, colAccion);
		if(accion != ""){
			tr=document.body.createTextRange();tr.execCommand("Unselect");
			eval(accion);
			return;
		}
	}
}

//Nos permite focalizar el último o primer campo de una jerarquía de dependencias de combos)
function focalizaComboDependence(entityFormName, mapNombre, primero){
	//Primero determianmos el vector con la definición de la jerarquía
	var map = eval(mapNombre + 'DependeceMap');
	if (map == null) return;
	
	//Si es el primero hay que buscar el primero que no tenga padres
	//Si hay que ir al último buscamos el que no tenga hijo (Seguramente sea el último asi que empezamos por el final)
	var accionFoco = "";
	if(primero){
		for(var i=0; i< map.longitud; i++){
			var padres = map.ij(i, mmgComboDependeceColumnParents);
			if(padres.longitud == 0){
				accionFoco = "focaliza(\'" + entityFormName + "Frm." + map.ij(i, mmgComboDependeceColumnComboName) +"\');";
				break;
			}
		}
	}else{
		for(var i=map.longitud-1; i>=0 ; i--){
			var hijo = map.ij(i, mmgComboDependeceColumnChildren);
			if(hijo == null || hijo == ""){
				accionFoco = "focaliza(\'" + entityFormName + "Frm." + map.ij(i, mmgComboDependeceColumnComboName) +"\');";
				break;
			}
		}
	}
	
	//Finalmente ejecutamos la acción determinada
	eval(accionFoco);
}

//----------------------------------------------------
//	Combos dependientes
//----------------------------------------------------
//Nos permite gestionar la gestión de cambios
//Le pasamos el nombre del combo que ha cambiado y el nombre de la jerarquía que estamos gestionando
function mmgDependeneChange(comboNombre, mapNombre, entityFormName){
	//Primero determinamos los objetos del combo y el vector de elementos
	//Si alguno de los dos elementos es nulo no hacemos nada
	var combo = eval(comboNombre);
	var map = eval(mapNombre + 'DependeceMap');
	if(combo == null || map == null) return;
	
	//Determinamos la posición del vector correspondientes a los datos del combo. Si no se encuentra finalizamos
	//Determinamos el combo hijo del combo que ha cambiado
	var indiceCombo = map.buscar(comboNombre, 0);
	if(indiceCombo < 0) return;
	var indiceComboHija = map.buscar(map.ij(indiceCombo, 2), 0);
	if(indiceComboHija < 0) return;
	
	//Comprobamos que todos los padres del hijo tengan valor
	var performLoad = true;
	var padres = map.ij(indiceComboHija,1);
	for(var i=0; i < padres.longitud; i++){
		if(get(entityFormName + 'Frm.' + padres.ij(i)).length == 0) performLoad = false;
	}
	
	//Ejecutamos la carga si todos los padres tiene valor
	if(performLoad){
		//SI el valor del como es "" no realizamos la carga si no que simpemente limpiamos en cascada
		if(get(entityFormName + 'Frm.' + comboNombre).toString() != ""){
			//Primero determinamos los parametros
			var parametros = '';
			for(var i=0; i < padres.longitud; i++){
				parametros += get(entityFormName + 'Frm.' + padres.ij(i))[0];
				if(i != padres.longitud -1) parametros += "|";
			}
			
			//Añadimos el parametro que nos indica is hay que aplicar seguridad estructural a la hora de hacer la consulta
			parametros += "|" + get(entityFormName + 'Frm.applyStructuralEntity');
			
			//Ejecutamos la carga. Previamente ponemos el icono de reloj. Será la función que realiza la
			//carga de los datos en el combo la que volverá a poner el cursor al estado normal
			document.body.style.cursor='wait';
			asignar([["COMBO", entityFormName + 'Frm.' + map.ij(indiceComboHija,0) , map.ij(indiceComboHija, 3) + "ConectorTransactionComboLoad", 
				"result_ROWSET", parametros, "mmgPostComboLoadActions(\"" + map.ij(indiceComboHija,0) + "\", datos, \"" +
				mapNombre +"\", \"" + entityFormName +"\");"]], "", "");	
		}else mmgResetCombosOnCascade(comboNombre, mapNombre, entityFormName);
	}
}

//Realiza la carga de los datos de una combo.
//Accisones complementarias: 
//	- poner el estado de cursor a normal
//	- Limpiar en cascada las combos hijas de la combo que ha cambiado de valor
function mmgPostComboLoadActions(comboName, datos, mapNombre, entityFormName){
	//Cargamos el combo con los datos. Previamente los tratamos para añadir el elemento vacío
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	datosTmp.insertar(0, ['','']);
	set_combo(entityFormName + "Frm." + comboName, datosTmp.volcar());
	
	//Establecemos el valor por defecto sól en el caso de las entidades estructurales
	var map = eval(mapNombre + 'DependeceMap');
	var indiceCombo = map.buscar(comboName, 0);
	if(indiceCombo >= 0){
		var defaultValue = mmgGetStructuralEntityDefaultValue(entityFormName, 
			map.ij(indiceCombo, mmgComboDependeceColumnEntityName));
		if(defaultValue != null || defaultValue != '') set(entityFormName + "Frm." + comboName, [defaultValue]);
	}
	
	//Reseteamos las combos hijos
	mmgResetCombosOnCascade(comboName, mapNombre, entityFormName);
		//Ponemos el cursos al estado normal
	document.body.style.cursor='default';
}

//Nos permite resetear todos clos
//comboName: el nombre del combo del cual se desean resetera lo hijos
function mmgResetCombosOnCascade(comboName, mapNombre, entityFormName){
	//Determinamos el vector que define la jerarquía de dependencia de las combos que se está tratando
	var map = eval(mapNombre + 'DependeceMap');

	//Nos recorremos los hijos en cascada reseteando las combos
	for(var hijoNombre = map.ij(map.buscar(comboName, 0), 2); hijoNombre != ''; hijoNombre = map.ij(map.buscar(hijoNombre, 0), 2)){
		set_combo(entityFormName + 'Frm.' + hijoNombre, ['','']);
	}
}

//----------------------------------------------------
//	clientes
//----------------------------------------------------

//Nos permite abrir la pantalla de selección rápida de cliente. Si le indicamos el
//formulario y el campo nos carga en la variable ocutla y en el etxtfiel el id y el cod de cliente seleccioanda
//Si form y field son null o cadena vacia devuelve el array con los datos del cliente seleccionado
function mmgOpenClientQuickSearch(form, field) {
	//Sacamos la ventana modal
     var objParams = new Object();
     var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
     
     //SI se nos ha indicado el campo corrspondiente al clinete establecemos el valor del oid
     //a la variable oculta y el codigo lo cargamos en la caja de texto
     if(cliente != null && form != null && cdos_trim(form) != ''&& field != null && cdos_trim(field) != '' ){
     	set(form + '.' + field , cliente[0]);
     	set(form + '.' + field + 'ClientCode', cliente[1]);
     }else{
     	return cliente;
     }
}

//Nos permite rellenar un campo de código de cliente con el valor
function mmgFillClienteCode(form, field){
	var codeLength = parseInt(get(form + '.clientCodeSize'));
	var clientCode = get(form + '.' + field);
	
	//Si no se ha metido ningún valor no rellenamos
	if(cdos_trim(clientCode) == '') return;
	
	//Rellenamos con ceros hasta alcanzar la longitud del codigo de cliente especifiada
	while(clientCode.length < codeLength){
		clientCode = "0" + clientCode;
	}

	//Cambiamos el valor del cliente
	set(form + '.' + field, clientCode);
}



//----------------------------------------------------
//	modo pantalla
//----------------------------------------------------
function getMMGMode(accion, origen){
	switch(accion){
		case 'create': return MMG_MODE_CREATE;
		case 'query': return MMG_MODE_QUERY;
		case 'update': if(origen == 'menu') return MMG_MODE_UPDATE_QUERY; else return MMG_MODE_UPDATE_FORM;
		case 'remove': return MMG_MODE_REMOVE;
		case 'view': return MMG_MODE_VIEW;
		default: return 0;
	}
}


//----------------------------------------------------
//	Miscelaneous
//----------------------------------------------------
//Este método nos indica si en el modo en el que estamos se muestran lso campos de to en campos con intervalo
function isMostrarIntervalo(entidad){
	return get(entidad + 'Frm.accion')=='query' || get(entidad + 'Frm.accion')=='remove' ||
		(get(entidad + 'Frm.accion')=='update' && get(entidad + 'Frm.origen') == 'menu');
}

//Nos permite saber si en el modo en el que estamos es necesario mostrar los elementos de internacionalización
function isMostratLocalzation(entidad){
	return get(entidad + 'Frm.accion')=='create' || 
		(get(entidad + 'Frm.accion')=='update' && get(entidad + 'Frm.origen') == 'pagina');
}

//Nos permite determinar si es necesario realziar una acción de requery
function isPerformRequery(entidad){
	var query = get(entidad + 'Frm.lastQueryToSession');
	var accion = get(entidad + 'Frm.accion');
	var origen = get(entidad + 'Frm.origen');

	//Habrá que realizar el requery cuando estemos en los modos de query, remove, o update form
	//y en la variable last query haya un valor
	return   (query != null && query != "") && 
		(accion == "query" || accion == "remove" || (accion == "update" && origen=="menu"));
}

//Este método nos permite relizar
function mmgImgEventDispatcherForFocus(event, actionForTab, actionForShiftTab){
	if(event.keyCode == 9){
		if(event.shiftKey) eval(actionForShiftTab);
		else eval(actionForTab);
		event.returnValue=false;
	}else return true;
}

//Este método  nos permite generar una request a partir de un url y un vector de parametros
//donde la primera columna es el nombre del parametro y el segundo es el valor.
function mmgBuildHttpQuery(url, parametros){
	var request = url + "?";
	for(var i = 0; i< parametros.longitud; i++){
		request = request + parametros.ij(i, 0) + "=" + parametros.ij(i, 1);
		if(i != parametros.longitud -1) request = request + "&";
	}
	return request;
}

//Nos permite volcar el contenido de un formulario a un array donde el indice es el nombre de campo
//y el valor de cada una de las posiciones del array el valor del campo del formulario
function mmgFormToArray(form){
	var formFields = new Array();
	for(field in form.elements) formFields[field.name] =  field.value;
	return formFields
}

//Nos permite obtener el valor por defecto de una determinada entidad estructural
function mmgGetStructuralEntityDefaultValue(formName, entityName){
	switch(entityName){
		case 'SegPais': return get(formName + 'Frm.structuralDefaultPais');
		case 'SegSocie': return get(formName + 'Frm.structuralDefaultSociedad');
		case 'SegMarca': return get(formName + 'Frm.structuralDefaultMarca');
		case 'SegCanal': return get(formName + 'Frm.structuralDefaultCanal');
		case 'SegAcces': return get(formName + 'Frm.structuralDefaultAcceso');
		case 'SegSubac': return get(formName + 'Frm.structuralDefaultSubacceso');		
		case 'ZonSubGenrenVenta': return get(formName + 'Frm.structuralDefaultSubgerenciaVentas');		
		case 'ZonRegio': return get(formName + 'Frm.structuralDefaultRegion');
		case 'ZonZona': return get(formName + 'Frm.structuralDefaultZona');		
		case 'ZonSecci': return get(formName + 'Frm.structuralDefaultSeccion');		
		case 'ZonTerri': return get(formName + 'Frm.structuralDefaultTerritorio');	
		default: return '';
	}
}


  function VerificaContenidoCmbs(cmb1, cmb2, entidad, atributo){
  	if ((cmb1!=null) && (cmb2!=null) && (entidad!=null) && (atributo!=null)){  	
	  	if (get(cmb1,'T').toString()==get(cmb2,'T').toString()){
	  		//con esta linea voy a obtener el nombre de la entidad y del atributo
	  	 	return GestionarMensaje(entidad + "." + atributo + ".cmbValueIncorrecto.message");
	  	}
		return 'OK';
	}
	else
		return DrdMsgCore(230);
  }

function sicc_caracteres_fecha_validos(valorFecha, separador) {
    	//los caracteres permitidos para 
		//la fecha son numeros y el separador, solamente
	var RegInteger = /^\d+$/; //Expresion regular que verifica la existencia de "solo numeros"
	var FechaTmp = valorFecha.split(separador).join("");
	return RegInteger.test(FechaTmp)
} 

function ValidaFechaMMG(fecha, formatoFechaUsuario) {
	//esta funcion valida fechas, convirtiendo los strings a fechas de javascript
	//y validando tanto la existencia como el rango de la fecha. Se asume que el
	//formato de las fechas minimas y maximas seran dd/mm/yyyy.
	var strValor = fecha;
	if(strValor==""){
		return true;
	}
	var arrFormato = null;
	var arrFecha = null;
	var separador = "";
	var strValorFormatoFechaPais = get(getFormularioSICC()+".hFormatoFechaPais");

	if (formatoFechaUsuario == undefined || formatoFechaUsuario == ""){

		if( strValorFormatoFechaPais == "" ){
			formatoFechaUsuario = "dd/mm/yyyy";
		} else {
			formatoFechaUsuario = strValorFormatoFechaPais;
		}

	}
	if(formatoFechaUsuario.indexOf("/")>-1){
		separador = "/";
		arrFormato = formatoFechaUsuario.split("/");
		arrFecha = strValor.split("/");
	}else{
		separador = "-";
		arrFormato = formatoFechaUsuario.split("-");
		arrFecha = strValor.split("-");
	}
	//para ser valida la fecha permite 3 valores (dia, mes, anio)
	if(arrFecha.length != 3){
		cdos_mostrarAlert(GestionarMensaje("000000000000031")+ formatoFechaUsuario.replace(/y/g,'a') +GestionarMensaje("000000000000032"));
		//GestionarMensaje("1006", formatoFechaUsuario.replace(/y/g,'a'));
		//sicc_focaliza_componente(strName);
		
		// SPLATAS - 27/07/2006 - DBLG500000961
		//return false;
		return;
	}
	//valido los caracteres de la fecha
	if(!sicc_caracteres_fecha_validos(strValor,separador)){
		cdos_mostrarAlert(GestionarMensaje("000000000000025"));
		//sicc_focaliza_componente(strName);
		
		// SPLATAS - 27/07/2006 - DBLG500000961
		//return false;
		return;
	}
	//ahora trabajo con la fecha
	var dia, mes, anio;
	for(var i=0; i < arrFormato.length;i++){
		switch(arrFormato[i]){
			case 'dd'://TODO dd
				dia = arrFecha[i];
				break;
			case 'mm':// TODO mm
				mes = arrFecha[i];
				break;
			default:
				anio = arrFecha[i];
				break;
		}
	}
	//en cada variable tengo la parte de la fecha que corresponde, por lo que valido
	//primero el formato, luego la validez, por ultimo el rango
	if(dia.length!=2){
		cdos_mostrarAlert(GestionarMensaje("000000000000028"));
		//sicc_focaliza_componente(strName);
		
		// SPLATAS - 27/07/2006 - DBLG500000961
		//return false;
		return;
	}
	if(mes.length!=2){
		cdos_mostrarAlert(GestionarMensaje("000000000000029"));
		//sicc_focaliza_componente(strName);
		
		// SPLATAS - 27/07/2006 - DBLG500000961
		//return false;
		return;
	}
	if(anio.length != 4){
		cdos_mostrarAlert(GestionarMensaje("000000000000030"));
		//sicc_focaliza_componente(strName);
		
		// SPLATAS - 27/07/2006 - DBLG500000961
		//return false;
		return;
	}

	//el mes no puede ser superior a 12 ni menor que 1
	if(parseInt(mes,10) < 1 || parseInt(mes,10) > 12){
		cdos_mostrarAlert(GestionarMensaje("000000000000036"));
		//sicc_focaliza_componente(strName);
		
		// SPLATAS - 27/07/2006 - DBLG500000961
		//return false;
		return;
	}

	var diaMaximo =0;
	switch(parseInt(mes,10)){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			diaMaximo = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaMaximo = 30;
			break;
		case 2:
			if(sicc_anio_bisiesto(anio)){
				diaMaximo = 29;
			}else{
				diaMaximo = 28;
			}
	}
	if(parseInt(dia,10) < 1 || parseInt(dia,10) > parseInt(diaMaximo,10)){
		cdos_mostrarAlert(GestionarMensaje("000000000000037")+diaMaximo);
		sicc_focaliza_componente(strName);
		
		// SPLATAS - 27/07/2006 - DBLG500000961
		//return false;
		return;
	}

	//se presupone que si existen fecha limite, las mismas
	//seran correctas, por lo que no se hacen todas las validaciones a las mismas.
	//Las fechas limite se esperan en formato dd/mm/yyyy

	var oDate = new Date(anio, parseInt(mes,10)-1, dia);

	return 'OK';
} 

//********************************************************//
//********************************************************//
//********************************************************//
function ValidaNumeroMMG(valorTest, hhh, hhhh, strMostrar, minValue, valorMaximo) {
	var strCantDec = "2";
	var strMostrar = GestionarMensaje(strMostrar);
	var	strSepDec = get(getFormularioSICC()+".hSeparadorDecimalPais");
	var	strSepMil = get(getFormularioSICC()+".hSeparadorMilesPais"); 
	var valorMinimo = ""+minValue;
	var valorMaximo = ""+valorMaximo;
		
	//var strMostrar = 'CarParamEvaluNr.label';
	//aca normalizo la cantidad de decimales, ya que nada me asegura
	//que el formato admita decimales, aunque seria lo logico.
	//Si la cantidad de decimales no es un numero valido, entonces es cero.
	if(isNaN(parseInt(strCantDec,10))){
		strCantDec = 0;
	}else{
		strCantDec=parseInt(strCantDec,10);
	}

	//Primero me fijo si es un numero, para eso
	//le saco todos los separadores
	var strCleaned = valorTest.split(strSepDec).join("");
	strCleaned = strCleaned.split(strSepMil).join("")+"";
	
	if(!parseInt(strCleaned.substr(0,1),10) && parseInt(strCleaned.substr(0,1),10)!=0){//si el primero no es un numero, puede ser solo el simbolo negativo
		if(strCleaned.substr(0,1)!="-"){
			cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
			//sicc_focaliza_componente(strName);
			return false;
		}else{//tambien lo saco para testear el numero
			strCleaned = strCleaned.substr(1);
		}
	}

	var RegInteger = /^\d+$/; //Solo numeros
	if(!RegInteger.test(strCleaned)){
		cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
		//sicc_focaliza_componente(strName);
		return false;
	}
	
	//Ahora se que es un numero, primero valido los decimales
	//el ultimo debe ser un numero
	if(isNaN(parseInt(valorTest.substr(valorTest.length-1),10))){
			cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
			//sicc_focaliza_componente(strName);
			return false;
	}

	//me fijo el largo de los decimales
	var arrTest = valorTest.split(strSepDec);
	if(arrTest.length ==2 && arrTest[1]!=null && arrTest[1]!=""){//si tiene decimales
		if(parseInt(strCantDec,10)==0){
			cdos_mostrarAlert(GestionarMensaje("000000000000104"));
			//sicc_focaliza_componente(strName);
			return false;
		}
		var strDecimales = arrTest[arrTest.length-1]+"";
		if(strDecimales.length > parseInt(strCantDec,10)){//me fijo cuantos son
			cdos_mostrarAlert(GestionarMensaje("000000000000101" ,  strMostrar,parseInt(strCantDec,10)));
			//sicc_focaliza_componente(strName);
			return false;
		}
	}else{
		if(arrTest.length > 2){//sino
			cdos_mostrarAlert(GestionarMensaje("000000000000102" ,  strMostrar));
			//sicc_focaliza_componente(strName);
			return false;
		}
	}
	//ahora voy por la parte entera

	var strInteger = arrTest[0]+"";
	
	if(strInteger.indexOf(strSepMil) >- 1){//si tiene separadores de miles
		var arrInteger = strInteger.split(strSepMil);
		//en todo el array los numero son de a 3 digitos
		//excepto en la primera posicion, 
		//donde solo no pueden ser 4 digitos
		for(var i=0; i < arrInteger.length; i++){
			if(i==0){
				if((arrInteger[i]+"").length>3){
					cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  strMostrar));
					//sicc_focaliza_componente(strName);
					return false;
				}
			}else{
				if((arrInteger[i]+"").length!=3){
					cdos_mostrarAlert(GestionarMensaje("000000000000105",strSepMil));
					//sicc_focaliza_componente(strName);
					return false;
				}
			}
		}
	}


	//por ultimo valido el rango del valor
	//saco el separador de miles
	var strNumeroTest = valorTest.split(strSepMil).join("");
	//si el separador decimal es el punto, lo dejo, sino, lo reemplazo por el punto
	if(strSepDec!="."){
		strNumeroTest  = strNumeroTest.split(strSepDec).join(".")
	}
	
	if(valorMinimo!=""){
		if(parseFloat(strNumeroTest )<parseFloat(valorMinimo)){
			cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));
			//sicc_focaliza_componente(strName);
			return false;
		}
	}	
	if(valorMaximo!=""){
		if(parseFloat(strNumeroTest)>parseFloat(valorMaximo)){
			cdos_mostrarAlert(GestionarMensaje("000000000000103" ,  strMostrar,parseFloat(valorMinimo),parseFloat(valorMaximo)));
			//sicc_focaliza_componente(strName);
			return false;
		}
	}
	return 'OK';
} 

/*
	@author : pperanzola
	@date   : 17/05/2005
	Nos permite gestionar la gestión de cambios cuando los combos dependen unos de otros y se realiza
	una carga automatica de un valor por default
	Le pasamos el nombre del combo que ha cambiado y el nombre de la jerarquía que estamos gestionando
*/
function mmgDependeneChangeNivel2(comboNombre, mapNombre, entityFormName, comboNombre2, mapNombre2){
	//Limpiamos todo
	mmgResetCombosOnCascade(comboNombre, mapNombre, entityFormName);
	
	//Primero determinamos los objetos del combo y el vector de elementos
	//Si alguno de los dos elementos es nulo no hacemos nada
	var combo = eval(comboNombre);
	var map = eval(mapNombre + 'DependeceMap');
	if(combo == null || map == null) return; 
	
	//Determinamos la posición del vector correspondientes a los datos del combo. Si no se encuentra finalizamos
	//Determinamos el combo hijo del combo que ha cambiado
	var indiceCombo = map.buscar(comboNombre, 0);
	if(indiceCombo < 0) return;
	var indiceComboHija = map.buscar(map.ij(indiceCombo, 2), 0);
	if(indiceComboHija < 0) return;
	
	//Comprobamos que todos los padres del hijo tengan valor
	var performLoad = true;
	var padres = map.ij(indiceComboHija,1);
	for(var i=0; i < padres.longitud; i++){
		if(get(entityFormName + 'Frm.' + padres.ij(i)).length == 0) performLoad = false;
	}
	
	//Ejecutamos la carga si todos los padres tiene valor
	if(performLoad){
		//SI el valor del combo es "" no realizamos la carga si no que simpemente limpiamos en cascada
		if(get(entityFormName + 'Frm.' + comboNombre).toString() != ""){
			//Primero determinamos los parametros
			var parametros = '';
			for(var i=0; i < padres.longitud; i++){
				parametros += get(entityFormName + 'Frm.' + padres.ij(i))[0];
				if(i != padres.longitud -1) parametros += "|";
			}
			
			//Añadimos el parametro que nos indica is hay que aplicar seguridad estructural a la hora de hacer la consulta
			parametros += "|" + get(entityFormName + 'Frm.applyStructuralEntity');
			
			//Ejecutamos la carga. Previamente ponemos el icono de reloj. Será la función que realiza la
			//carga de los datos en el combo la que volverá a poner el cursor al estado normal
			document.body.style.cursor='wait';
			asignar([["COMBO", entityFormName + 'Frm.' + map.ij(indiceComboHija,0) , map.ij(indiceComboHija, 3) + "ConectorTransactionComboLoad", 
				"result_ROWSET", parametros, "mmgPostComboLoadActionsNivel2(\"" + map.ij(indiceComboHija,0) + "\", datos, \"" +
				mapNombre +"\", \"" + entityFormName +"\",\"" + comboNombre2 + "\",\"" + mapNombre2 + "\");"]], "", "");	
		}else mmgResetCombosOnCascade(comboNombre, mapNombre, entityFormName);
	}
	
}
/*
	@author : pperanzola
	@date   : 17/05/2005
	tiene la misma funcionalidad que el mmgPostComboLoadActions salvo que recibe mayor cantidad de parametros
	y vuelve a llamar al mmgDependeneChange
*/

function mmgPostComboLoadActionsNivel2(comboName, datos, mapNombre, entityFormName,comboNombre2, mapNombre2){
	//Cargamos el combo con los datos. Previamente los tratamos para añadir el elemento vacío
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	datosTmp.insertar(0, ['','']);
	set_combo(entityFormName + "Frm." + comboName, datosTmp.volcar());
	
	//Establecemos el valor por defecto sól en el caso de las entidades estructurales
	var map = eval(mapNombre + 'DependeceMap');
	var indiceCombo = map.buscar(comboName, 0);
	if(indiceCombo >= 0){
		var defaultValue = mmgGetStructuralEntityDefaultValue(entityFormName, 
			map.ij(indiceCombo, mmgComboDependeceColumnEntityName));
		if(defaultValue != null || defaultValue != '') set(entityFormName + "Frm." + comboName, [defaultValue]);
	}

	mmgDependeneChange(comboNombre2 ,mapNombre2 ,entityFormName);
	//Reseteamos las combos hijos
	//mmgResetCombosOnCascade(comboName, mapNombre, entityFormName);
		//Ponemos el cursos al estado normal
	//document.body.style.cursor='default';
}


function sicc_anio_bisiesto(anio) {

    if (anio%100 == 0){
		if (anio%400 == 0){
			return true;
		
		} else {
			return false;
		}
    
	} else {
		if (anio%4 == 0){ 
			return true;

        } else {
			return false;

		}
    }

}

//esto solo esta para que no exploten los mmg
function evalua_ultima(paginado, rowset){
}