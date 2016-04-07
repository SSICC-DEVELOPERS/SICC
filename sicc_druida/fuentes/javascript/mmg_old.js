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







