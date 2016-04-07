

/*
    INDRA/CAR/mmg
    $Id: belestadmerca.js,v 1.1 2009/12/03 19:02:17 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsBelEstadMercaId = "";
var jsBelEstadMercaPaisOidPais = "";
var jsBelEstadMercaCodEsta = "";
var jsBelEstadMercaDescripcion = "";

//Variables de paginacion, 
var belEstadMercaPageCount = 1;

//Varible de columna que representa el campo de choice
var belEstadMercaChoiceColumn = 1;

//Flag de siguiente pagina;
var belEstadMercaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var belEstadMercaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var belEstadMercaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("belEstadMercaFrm.codEsta");','focaliza("belEstadMercaFrm.codEsta");','','focaliza("belEstadMercaFrm.codEsta");','focaliza("belEstadMercaFrm.codEsta");',''],[4,'focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[4,'focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");','focaliza("belEstadMercaFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
belEstadMercaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var belEstadMercaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function belEstadMercaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('belEstadMercaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('belEstadMercaFrm.accion')){
		case "query": belEstadMercaQueryInitComponents(); break;
		case "view": belEstadMercaViewInitComponents(); break;
		case "create": belEstadMercaCreateInitComponents(); break;
		case "update": belEstadMercaUpdateInitComponents(); break;
		case "remove": belEstadMercaRemoveInitComponents(); break;
		case "lov": belEstadMercaLovInitComponents(); break;
	}
	//alert('accion :' + get('belEstadMercaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('belEstadMercaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('belEstadMerca')) belEstadMercaCmdRequery();
}

function belEstadMercaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('belEstadMercaFrm', true);	
}

function belEstadMercaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('belEstadMercaFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('belEstadMercaFrm', true);
}

function belEstadMercaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('belEstadMercaFrm.codEsta','S', GestionarMensaje('BelEstadMerca.codEsta.requiered.message'));
	
	setMV('belEstadMercaFrm.Descripcion','S', GestionarMensaje('BelEstadMerca.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('belEstadMercaFrm', true);
}

function belEstadMercaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('belEstadMercaFrm.origen') == "pagina"){
		loadLocalizationWidget('belEstadMercaFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		belEstadMercaTmpUpdateValues = belEstadMercaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('belEstadMercaFrm.Descripcion','S', GestionarMensaje('BelEstadMerca.Descripcion.requiered.message'));
		
			focusFirstFieldModify('belEstadMercaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('belEstadMercaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('belEstadMercaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function belEstadMercaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	belEstadMercaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('belEstadMercaFrm', true);
}

function belEstadMercaLovInitComponents(){
	belEstadMercaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('belEstadMercaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function belEstadMercaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('belEstadMercaFrm.' + campo, id);
	set('belEstadMercaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function belEstadMercaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	belEstadMercaLovReturnParameters.id = '';
	belEstadMercaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function belEstadMercaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belEstadMercaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = belEstadMercaList.codSeleccionados();
	var descripcion = belEstadMercaList.extraeDato(
		belEstadMercaList.codSeleccionados()[0], belEstadMercaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	belEstadMercaLovReturnParameters.id = codigo;
	belEstadMercaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function belEstadMercaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('belEstadMercaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('belEstadMercaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "belEstadMercaList", "BelEstadMercaConectorTransactionQuery", 
		"result_ROWSET", parametros, "belEstadMercaPostQueryActions(datos);"]], "", "");	
}

function belEstadMercaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('belEstadMercaFrm.lastQueryToSession'));
	var i =0;
	set('belEstadMercaFrm.codEsta', paramsRequery.ij(i++));
	
	set('belEstadMercaFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	belEstadMercaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	belEstadMercaCmdQuery(belEstadMercaPageCount);
}

function belEstadMercaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	belEstadMercaPageCount = 1;
	belEstadMercaCmdQuery(belEstadMercaPageCount);
}

function belEstadMercaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belEstadMercaLastQuery){
		belEstadMercaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	belEstadMercaPageCount--;
	belEstadMercaCmdQuery(belEstadMercaPageCount);
}

function belEstadMercaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belEstadMercaLastQuery){
		belEstadMercaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	belEstadMercaPageCount++;
	belEstadMercaCmdQuery(belEstadMercaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function belEstadMercaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('belEstadMercaListLayer', 'O');
		visibilidad('belEstadMercaListButtonsLayer', 'O');
		if(get('belEstadMercaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	belEstadMercaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:belEstadMercaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, belEstadMercaChoiceColumn) + "</A>",
			i, belEstadMercaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	belEstadMercaList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	belEstadMercaTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		belEstadMercaMorePagesFlag = true;
		belEstadMercaList.eliminar(mmgPageSize, 1);
	}else{
		belEstadMercaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('belEstadMercaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('belEstadMercaListLayer', 'V');
	visibilidad('belEstadMercaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('belEstadMercaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	belEstadMercaList.display();
	
	//Actualizamos el estado de los botones 
	if(belEstadMercaMorePagesFlag){
		set_estado_botonera('belEstadMercaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('belEstadMercaPaginationButtonBar',
			3,"inactivo");
	}
	if(belEstadMercaPageCount > 1){
		set_estado_botonera('belEstadMercaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('belEstadMercaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('belEstadMercaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('belEstadMercaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function belEstadMercaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belEstadMercaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('belEstadMercaFrm.idSelection', belEstadMercaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('belEstadMercaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = belEstadMercaList.codSeleccionados()[0];
		parametros["previousAction"] = get('belEstadMercaFrm.accion');
		parametros["accion"] = get('belEstadMercaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('BelEstadMercaLPStartUp', get('belEstadMercaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) belEstadMercaCmdRequery();
	}
}

function belEstadMercaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belEstadMercaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = belEstadMercaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('belEstadMercaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(belEstadMercaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += belEstadMercaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('belEstadMercaFrm.timestamp', timestamps);


	belEstadMercaFrm.oculto='S';
	envia('belEstadMercaFrm');
	belEstadMercaFrm.oculto='N';
}

function belEstadMercaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belEstadMercaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	belEstadMercaViewDetail(belEstadMercaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function belEstadMercaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('belEstadMercaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('BelEstadMercaLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('belEstadMercaFrm', 
		'Descripcion', 1,
		get('belEstadMercaFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('belEstadMercaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('belEstadMercaFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('BelEstadMerca.Descripcion.requiered.message'));
		focaliza('belEstadMercaFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		belEstadMercaFrm.oculto='S';
		envia('belEstadMercaFrm');
		belEstadMercaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('belEstadMercaFrm.paisOidPais').toString() == ''){
		set('belEstadMercaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'belEstadMerca');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	belEstadMercaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('belEstadMercaFrm.accion');
	var origenTmp = get('belEstadMercaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(belEstadMercaBuildUpdateRecordString() != belEstadMercaTmpUpdateValues){
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
	document.all.belEstadMercaListLayer.style.display='none';
	document.all.belEstadMercaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.belEstadMercaListLayer.style.display='';
	document.all.belEstadMercaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsBelEstadMercaCodEsta = get('belEstadMercaFrm.codEsta').toString();
	jsBelEstadMercaDescripcion = get('belEstadMercaFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsBelEstadMercaCodEsta + "|";
	parametros += jsBelEstadMercaDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function belEstadMercaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsBelEstadMercaDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belEstadMercaFrm.accion'), 
		get('belEstadMercaFrm.origen'));
	
	jsBelEstadMercaId = get('belEstadMercaFrm.id').toString();
	jsBelEstadMercaPaisOidPais = get('belEstadMercaFrm.paisOidPais')[0];
	jsBelEstadMercaCodEsta = get('belEstadMercaFrm.codEsta').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsBelEstadMercaDescripcion = buildLocalizedString('belEstadMercaFrm', 1);
	}else{
		jsBelEstadMercaDescripcion = get('belEstadMercaFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belEstadMercaFrm.accion'), 
		get('belEstadMercaFrm.origen'));


	set('belEstadMercaFrm.id', jsBelEstadMercaId);
	set('belEstadMercaFrm.paisOidPais', [jsBelEstadMercaPaisOidPais]);
	set('belEstadMercaFrm.codEsta', jsBelEstadMercaCodEsta);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('belEstadMercaFrm', 1,  jsBelEstadMercaDescripcion)
		loadLocalizationWidget('belEstadMercaFrm', 'Descripcion', 1);
	}else{
		set('belEstadMercaFrm.Descripcion', jsBelEstadMercaDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsBelEstadMercaCodEsta = '';
	jsBelEstadMercaDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('belEstadMercaFrm.errCodigo', errorCode);
	set('belEstadMercaFrm.errDescripcion', description);
	set('belEstadMercaFrm.errSeverity', severity);
	fMostrarMensajeError();
}
