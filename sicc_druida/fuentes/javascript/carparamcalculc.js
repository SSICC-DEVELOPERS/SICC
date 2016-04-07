

/*
    INDRA/CAR/mmg
    $Id: carparamcalculc.js,v 1.1 2009/12/03 19:01:44 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarParamCalcuLcId = "";
var jsCarParamCalcuLcNiriOidNiveRies = "";
var jsCarParamCalcuLcValTope = "";
var jsCarParamCalcuLcValFactCalc = "";
var jsCarParamCalcuLcIndVariLineCred = "";

//Variables de paginacion, 
var carParamCalcuLcPageCount = 1;

//Varible de columna que representa el campo de choice
var carParamCalcuLcChoiceColumn = 4;

//Flag de siguiente pagina;
var carParamCalcuLcMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carParamCalcuLcTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var carParamCalcuLcLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("carParamCalcuLc","niriOidNiveRies", false);','focalizaComboDependence("carParamCalcuLc","niriOidNiveRies", false);','focalizaComboDependence("carParamCalcuLc","niriOidNiveRies", false);','focalizaComboDependence("carParamCalcuLc","niriOidNiveRies", true);','focalizaComboDependence("carParamCalcuLc","niriOidNiveRies", true);','focalizaComboDependence("carParamCalcuLc","niriOidNiveRies", true);'],[3,'focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");'],[4,'focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");'],[5,'focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");','focaliza("carParamCalcuLcFrm.valTope");'],[4,'focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");','focaliza("carParamCalcuLcFrm.valFactCalc");'],[5,'focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");','focaliza("carParamCalcuLcFrm.indVariLineCred");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var niriOidNiveRiesDependeceMap = new Vector();
niriOidNiveRiesDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
niriOidNiveRiesDependeceMap.agregar(['niriOidNiveRies', padresTmp, '', 'CarNivelRiesg']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
carParamCalcuLcLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var carParamCalcuLcTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function carParamCalcuLcInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('carParamCalcuLcFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('carParamCalcuLcFrm.accion')){
		case "query": carParamCalcuLcQueryInitComponents(); break;
		case "view": carParamCalcuLcViewInitComponents(); break;
		case "create": carParamCalcuLcCreateInitComponents(); break;
		case "update": carParamCalcuLcUpdateInitComponents(); break;
		case "remove": carParamCalcuLcRemoveInitComponents(); break;
		case "lov": carParamCalcuLcLovInitComponents(); break;
	}
	//alert('accion :' + get('carParamCalcuLcFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('carParamCalcuLcFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carParamCalcuLc')) carParamCalcuLcCmdRequery();
}

function carParamCalcuLcQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('carParamCalcuLcFrm', true);	
}

function carParamCalcuLcViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('carParamCalcuLcFrm', true);
}

function carParamCalcuLcCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carParamCalcuLcFrm.niriOidNiveRies','S', GestionarMensaje('CarParamCalcuLc.niriOidNiveRies.requiered.message'));
	
	setMV('carParamCalcuLcFrm.valTope','S', GestionarMensaje('CarParamCalcuLc.valTope.requiered.message'));
	
	setMV('carParamCalcuLcFrm.valFactCalc','S', GestionarMensaje('CarParamCalcuLc.valFactCalc.requiered.message'));
	
	setMV('carParamCalcuLcFrm.indVariLineCred','S', GestionarMensaje('CarParamCalcuLc.indVariLineCred.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('carParamCalcuLcFrm', true);
}

function carParamCalcuLcUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('carParamCalcuLcFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		carParamCalcuLcTmpUpdateValues = carParamCalcuLcBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carParamCalcuLcFrm.niriOidNiveRies','S', GestionarMensaje('CarParamCalcuLc.niriOidNiveRies.requiered.message'));
		setMV('carParamCalcuLcFrm.valTope','S', GestionarMensaje('CarParamCalcuLc.valTope.requiered.message'));
		setMV('carParamCalcuLcFrm.valFactCalc','S', GestionarMensaje('CarParamCalcuLc.valFactCalc.requiered.message'));
		setMV('carParamCalcuLcFrm.indVariLineCred','S', GestionarMensaje('CarParamCalcuLc.indVariLineCred.requiered.message'));
		
			focusFirstFieldModify('carParamCalcuLcFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('carParamCalcuLcFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('carParamCalcuLcFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carParamCalcuLcRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	carParamCalcuLcList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('carParamCalcuLcFrm', true);
}

function carParamCalcuLcLovInitComponents(){
	carParamCalcuLcLovReturnParameters = window.dialogArguments;
	
	focusFirstField('carParamCalcuLcFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function carParamCalcuLcSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carParamCalcuLcFrm.' + campo, id);
	set('carParamCalcuLcFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function carParamCalcuLcLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carParamCalcuLcLovReturnParameters.id = '';
	carParamCalcuLcLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carParamCalcuLcLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carParamCalcuLcList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carParamCalcuLcList.codSeleccionados();
	var descripcion = carParamCalcuLcList.extraeDato(
		carParamCalcuLcList.codSeleccionados()[0], carParamCalcuLcChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carParamCalcuLcLovReturnParameters.id = codigo;
	carParamCalcuLcLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function carParamCalcuLcCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carParamCalcuLcFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('carParamCalcuLcFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carParamCalcuLcList", "CarParamCalcuLcConectorTransactionQuery", 
		"result_ROWSET", parametros, "carParamCalcuLcPostQueryActions(datos);"]], "", "");	
}

function carParamCalcuLcCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carParamCalcuLcFrm.lastQueryToSession'));
	var i =0;
	set('carParamCalcuLcFrm.niriOidNiveRies', [paramsRequery.ij(i++)]);
	
	set('carParamCalcuLcFrm.valTope', paramsRequery.ij(i++));
	
	set('carParamCalcuLcFrm.valFactCalc', paramsRequery.ij(i++));
	
	set('carParamCalcuLcFrm.indVariLineCred', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	carParamCalcuLcPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carParamCalcuLcCmdQuery(carParamCalcuLcPageCount);
}

function carParamCalcuLcFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carParamCalcuLcPageCount = 1;
	carParamCalcuLcCmdQuery(carParamCalcuLcPageCount);
}

function carParamCalcuLcPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carParamCalcuLcLastQuery){
		carParamCalcuLcFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carParamCalcuLcPageCount--;
	carParamCalcuLcCmdQuery(carParamCalcuLcPageCount);
}

function carParamCalcuLcNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carParamCalcuLcLastQuery){
		carParamCalcuLcFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carParamCalcuLcPageCount++;
	carParamCalcuLcCmdQuery(carParamCalcuLcPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carParamCalcuLcPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carParamCalcuLcListLayer', 'O');
		visibilidad('carParamCalcuLcListButtonsLayer', 'O');
		if(get('carParamCalcuLcFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	carParamCalcuLcLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case 'A': datosTmp.ij2(GestionarMensaje('CarParamCalcuLc.indVariLineCred.A.value'), i, 4); break;
			case 'D': datosTmp.ij2(GestionarMensaje('CarParamCalcuLc.indVariLineCred.D.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:carParamCalcuLcViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carParamCalcuLcChoiceColumn) + "</A>",
			i, carParamCalcuLcChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carParamCalcuLcList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	carParamCalcuLcTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		carParamCalcuLcMorePagesFlag = true;
		carParamCalcuLcList.eliminar(mmgPageSize, 1);
	}else{
		carParamCalcuLcMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('carParamCalcuLcFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carParamCalcuLcListLayer', 'V');
	visibilidad('carParamCalcuLcListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carParamCalcuLcList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carParamCalcuLcList.display();
	
	//Actualizamos el estado de los botones 
	if(carParamCalcuLcMorePagesFlag){
		set_estado_botonera('carParamCalcuLcPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carParamCalcuLcPaginationButtonBar',
			3,"inactivo");
	}
	if(carParamCalcuLcPageCount > 1){
		set_estado_botonera('carParamCalcuLcPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carParamCalcuLcPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carParamCalcuLcPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carParamCalcuLcPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carParamCalcuLcUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carParamCalcuLcList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carParamCalcuLcFrm.idSelection', carParamCalcuLcList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('carParamCalcuLcFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = carParamCalcuLcList.codSeleccionados()[0];
		parametros["previousAction"] = get('carParamCalcuLcFrm.accion');
		parametros["accion"] = get('carParamCalcuLcFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CarParamCalcuLcLPStartUp', get('carParamCalcuLcFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) carParamCalcuLcCmdRequery();
	}
}

function carParamCalcuLcRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carParamCalcuLcList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carParamCalcuLcList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carParamCalcuLcFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carParamCalcuLcList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carParamCalcuLcTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carParamCalcuLcFrm.timestamp', timestamps);


	carParamCalcuLcFrm.oculto='S';
	envia('carParamCalcuLcFrm');
	carParamCalcuLcFrm.oculto='N';
}

function carParamCalcuLcViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carParamCalcuLcList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	carParamCalcuLcViewDetail(carParamCalcuLcList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function carParamCalcuLcViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carParamCalcuLcFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CarParamCalcuLcLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('carParamCalcuLcFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		carParamCalcuLcFrm.oculto='S';
		envia('carParamCalcuLcFrm');
		carParamCalcuLcFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('carParamCalcuLcFrm.niriOidNiveRies').toString() == ''){
		set('carParamCalcuLcFrm.niriOidNiveRies', []);
		mmgResetCombosOnCascade('niriOidNiveRies', 'niriOidNiveRies', 'carParamCalcuLc');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	carParamCalcuLcRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('carParamCalcuLcFrm.accion');
	var origenTmp = get('carParamCalcuLcFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carParamCalcuLcBuildUpdateRecordString() != carParamCalcuLcTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
		window.close();
	}else if(accionTmp == 'view'){
		window.close();
	}
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.carParamCalcuLcListLayer.style.display='none';
	document.all.carParamCalcuLcListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carParamCalcuLcListLayer.style.display='';
	document.all.carParamCalcuLcListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCarParamCalcuLcNiriOidNiveRies = get('carParamCalcuLcFrm.niriOidNiveRies')[0];
	jsCarParamCalcuLcValTope = get('carParamCalcuLcFrm.valTope').toString();
	jsCarParamCalcuLcValFactCalc = get('carParamCalcuLcFrm.valFactCalc').toString();
	jsCarParamCalcuLcIndVariLineCred = get('carParamCalcuLcFrm.indVariLineCred')[0];
	
	
	var parametros = "";
	parametros += jsCarParamCalcuLcNiriOidNiveRies + "|";
	parametros += jsCarParamCalcuLcValTope + "|";
	parametros += jsCarParamCalcuLcValFactCalc + "|";
	parametros += jsCarParamCalcuLcIndVariLineCred + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carParamCalcuLcBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarParamCalcuLcNiriOidNiveRies + "|";
	parametros += jsCarParamCalcuLcValTope + "|";
	parametros += jsCarParamCalcuLcValFactCalc + "|";
	parametros += jsCarParamCalcuLcIndVariLineCred + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carParamCalcuLcFrm.accion'), 
		get('carParamCalcuLcFrm.origen'));
	
	jsCarParamCalcuLcId = get('carParamCalcuLcFrm.id').toString();
	jsCarParamCalcuLcNiriOidNiveRies = get('carParamCalcuLcFrm.niriOidNiveRies')[0];
	jsCarParamCalcuLcValTope = get('carParamCalcuLcFrm.valTope').toString();
	jsCarParamCalcuLcValFactCalc = get('carParamCalcuLcFrm.valFactCalc').toString();
	jsCarParamCalcuLcIndVariLineCred = get('carParamCalcuLcFrm.indVariLineCred')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carParamCalcuLcFrm.accion'), 
		get('carParamCalcuLcFrm.origen'));


	set('carParamCalcuLcFrm.id', jsCarParamCalcuLcId);
	set('carParamCalcuLcFrm.niriOidNiveRies', [jsCarParamCalcuLcNiriOidNiveRies]);
	set('carParamCalcuLcFrm.valTope', jsCarParamCalcuLcValTope);
	set('carParamCalcuLcFrm.valFactCalc', jsCarParamCalcuLcValFactCalc);
	set('carParamCalcuLcFrm.indVariLineCred', [jsCarParamCalcuLcIndVariLineCred]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCarParamCalcuLcNiriOidNiveRies = '';
	jsCarParamCalcuLcValTope = '';
	jsCarParamCalcuLcValFactCalc = '';
	jsCarParamCalcuLcIndVariLineCred = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carParamCalcuLcFrm.errCodigo', errorCode);
	set('carParamCalcuLcFrm.errDescripcion', description);
	set('carParamCalcuLcFrm.errSeverity', severity);
	fMostrarMensajeError();
}
