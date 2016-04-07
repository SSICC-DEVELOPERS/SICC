

/*
    INDRA/CAR/mmg
    $Id: incmotivpremiconsu.js,v 1.1 2009/12/03 19:01:36 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsIncMotivPremiConsuId = "";
var jsIncMotivPremiConsuDescripcion = "";

//Variables de paginacion, 
var incMotivPremiConsuPageCount = 1;

//Varible de columna que representa el campo de choice
var incMotivPremiConsuChoiceColumn = 1;

//Flag de siguiente pagina;
var incMotivPremiConsuMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var incMotivPremiConsuTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var incMotivPremiConsuLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");','focaliza("incMotivPremiConsuFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
incMotivPremiConsuLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var incMotivPremiConsuTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function incMotivPremiConsuInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('incMotivPremiConsuFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('incMotivPremiConsuFrm.accion')){
		case "query": incMotivPremiConsuQueryInitComponents(); break;
		case "view": incMotivPremiConsuViewInitComponents(); break;
		case "create": incMotivPremiConsuCreateInitComponents(); break;
		case "update": incMotivPremiConsuUpdateInitComponents(); break;
		case "remove": incMotivPremiConsuRemoveInitComponents(); break;
		case "lov": incMotivPremiConsuLovInitComponents(); break;
	}
	//alert('accion :' + get('incMotivPremiConsuFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('incMotivPremiConsuFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('incMotivPremiConsu')) incMotivPremiConsuCmdRequery();
}

function incMotivPremiConsuQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	focusFirstField('incMotivPremiConsuFrm', true);	
}

function incMotivPremiConsuViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('incMotivPremiConsuFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('incMotivPremiConsuFrm', true);
}

function incMotivPremiConsuCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Asignamos los textos de campo requerido
	setMV('incMotivPremiConsuFrm.Descripcion','S', GestionarMensaje('IncMotivPremiConsu.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('incMotivPremiConsuFrm', true);
}

function incMotivPremiConsuUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('incMotivPremiConsuFrm.origen') == "pagina"){
		loadLocalizationWidget('incMotivPremiConsuFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		incMotivPremiConsuTmpUpdateValues = incMotivPremiConsuBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('incMotivPremiConsuFrm.Descripcion','S', GestionarMensaje('IncMotivPremiConsu.Descripcion.requiered.message'));
		
			focusFirstFieldModify('incMotivPremiConsuFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		focusFirstField('incMotivPremiConsuFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('incMotivPremiConsuFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function incMotivPremiConsuRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	incMotivPremiConsuList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('incMotivPremiConsuFrm', true);
}

function incMotivPremiConsuLovInitComponents(){
	incMotivPremiConsuLovReturnParameters = window.dialogArguments;
	
	focusFirstField('incMotivPremiConsuFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad




//Función que permite cargar los datos de un elemento de lov seleccionado
function incMotivPremiConsuSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('incMotivPremiConsuFrm.' + campo, id);
	set('incMotivPremiConsuFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function incMotivPremiConsuLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	incMotivPremiConsuLovReturnParameters.id = '';
	incMotivPremiConsuLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function incMotivPremiConsuLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incMotivPremiConsuList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = incMotivPremiConsuList.codSeleccionados();
	var descripcion = incMotivPremiConsuList.extraeDato(
		incMotivPremiConsuList.codSeleccionados()[0], incMotivPremiConsuChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	incMotivPremiConsuLovReturnParameters.id = codigo;
	incMotivPremiConsuLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function incMotivPremiConsuCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('incMotivPremiConsuFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('incMotivPremiConsuFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "incMotivPremiConsuList", "IncMotivPremiConsuConectorTransactionQuery", 
		"result_ROWSET", parametros, "incMotivPremiConsuPostQueryActions(datos);"]], "", "");	
}

function incMotivPremiConsuCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('incMotivPremiConsuFrm.lastQueryToSession'));
	var i =0;
	set('incMotivPremiConsuFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	incMotivPremiConsuPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	incMotivPremiConsuCmdQuery(incMotivPremiConsuPageCount);
}

function incMotivPremiConsuFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	incMotivPremiConsuPageCount = 1;
	incMotivPremiConsuCmdQuery(incMotivPremiConsuPageCount);
}

function incMotivPremiConsuPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != incMotivPremiConsuLastQuery){
		incMotivPremiConsuFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	incMotivPremiConsuPageCount--;
	incMotivPremiConsuCmdQuery(incMotivPremiConsuPageCount);
}

function incMotivPremiConsuNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != incMotivPremiConsuLastQuery){
		incMotivPremiConsuFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	incMotivPremiConsuPageCount++;
	incMotivPremiConsuCmdQuery(incMotivPremiConsuPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function incMotivPremiConsuPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('incMotivPremiConsuListLayer', 'O');
		visibilidad('incMotivPremiConsuListButtonsLayer', 'O');
		if(get('incMotivPremiConsuFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	incMotivPremiConsuLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:incMotivPremiConsuViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, incMotivPremiConsuChoiceColumn) + "</A>",
			i, incMotivPremiConsuChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	incMotivPremiConsuList.setDatos(datosTmp.filtrar([0,1],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	incMotivPremiConsuTimeStamps = datosTmp.filtrar([2],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		incMotivPremiConsuMorePagesFlag = true;
		incMotivPremiConsuList.eliminar(mmgPageSize, 1);
	}else{
		incMotivPremiConsuMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('incMotivPremiConsuFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('incMotivPremiConsuListLayer', 'V');
	visibilidad('incMotivPremiConsuListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('incMotivPremiConsuList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	incMotivPremiConsuList.display();
	
	//Actualizamos el estado de los botones 
	if(incMotivPremiConsuMorePagesFlag){
		set_estado_botonera('incMotivPremiConsuPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('incMotivPremiConsuPaginationButtonBar',
			3,"inactivo");
	}
	if(incMotivPremiConsuPageCount > 1){
		set_estado_botonera('incMotivPremiConsuPaginationButtonBar',
			2,"activo");
		set_estado_botonera('incMotivPremiConsuPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('incMotivPremiConsuPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('incMotivPremiConsuPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function incMotivPremiConsuUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incMotivPremiConsuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('incMotivPremiConsuFrm.idSelection', incMotivPremiConsuList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('incMotivPremiConsuFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = incMotivPremiConsuList.codSeleccionados()[0];
		parametros["previousAction"] = get('incMotivPremiConsuFrm.accion');
		parametros["accion"] = get('incMotivPremiConsuFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('IncMotivPremiConsuLPStartUp', get('incMotivPremiConsuFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) incMotivPremiConsuCmdRequery();
	}
}

function incMotivPremiConsuRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incMotivPremiConsuList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = incMotivPremiConsuList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('incMotivPremiConsuFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(incMotivPremiConsuList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += incMotivPremiConsuTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('incMotivPremiConsuFrm.timestamp', timestamps);


	incMotivPremiConsuFrm.oculto='S';
	envia('incMotivPremiConsuFrm');
	incMotivPremiConsuFrm.oculto='N';
}

function incMotivPremiConsuViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incMotivPremiConsuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	incMotivPremiConsuViewDetail(incMotivPremiConsuList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function incMotivPremiConsuViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('incMotivPremiConsuFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('IncMotivPremiConsuLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	setDefaultLanguageValue('incMotivPremiConsuFrm', 
		'Descripcion', 1,
		get('incMotivPremiConsuFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('incMotivPremiConsuFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	if(!hasDefaultLanguageValue('incMotivPremiConsuFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('IncMotivPremiConsu.Descripcion.requiered.message'));
		focaliza('incMotivPremiConsuFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		incMotivPremiConsuFrm.oculto='S';
		envia('incMotivPremiConsuFrm');
		incMotivPremiConsuFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	incMotivPremiConsuRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('incMotivPremiConsuFrm.accion');
	var origenTmp = get('incMotivPremiConsuFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(incMotivPremiConsuBuildUpdateRecordString() != incMotivPremiConsuTmpUpdateValues){
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
	document.all.incMotivPremiConsuListLayer.style.display='none';
	document.all.incMotivPremiConsuListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.incMotivPremiConsuListLayer.style.display='';
	document.all.incMotivPremiConsuListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsIncMotivPremiConsuDescripcion = get('incMotivPremiConsuFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsIncMotivPremiConsuDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function incMotivPremiConsuBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsIncMotivPremiConsuDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('incMotivPremiConsuFrm.accion'), 
		get('incMotivPremiConsuFrm.origen'));
	
	jsIncMotivPremiConsuId = get('incMotivPremiConsuFrm.id').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsIncMotivPremiConsuDescripcion = buildLocalizedString('incMotivPremiConsuFrm', 1);
	}else{
		jsIncMotivPremiConsuDescripcion = get('incMotivPremiConsuFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('incMotivPremiConsuFrm.accion'), 
		get('incMotivPremiConsuFrm.origen'));


	set('incMotivPremiConsuFrm.id', jsIncMotivPremiConsuId);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('incMotivPremiConsuFrm', 1,  jsIncMotivPremiConsuDescripcion)
		loadLocalizationWidget('incMotivPremiConsuFrm', 'Descripcion', 1);
	}else{
		set('incMotivPremiConsuFrm.Descripcion', jsIncMotivPremiConsuDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsIncMotivPremiConsuDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('incMotivPremiConsuFrm.errCodigo', errorCode);
	set('incMotivPremiConsuFrm.errDescripcion', description);
	set('incMotivPremiConsuFrm.errSeverity', severity);
	fMostrarMensajeError();
}
