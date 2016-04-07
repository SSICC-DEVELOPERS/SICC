

/*
    INDRA/CAR/mmg
    $Id: maeestatclienview.js,v 1.1 2009/12/03 19:02:28 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeEstatClienViewId = "";
var jsMaeEstatClienViewDescripcion = "";

//Variables de paginacion, 
var maeEstatClienViewPageCount = 1;

//Varible de columna que representa el campo de choice
var maeEstatClienViewChoiceColumn = 0;

//Flag de siguiente pagina;
var maeEstatClienViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeEstatClienViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeEstatClienViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[4,'focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");','focaliza("maeEstatClienViewFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeEstatClienViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeEstatClienViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeEstatClienViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeEstatClienViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeEstatClienViewFrm.accion')){
		case "query": maeEstatClienViewQueryInitComponents(); break;
		case "view": maeEstatClienViewViewInitComponents(); break;
		case "create": maeEstatClienViewCreateInitComponents(); break;
		case "update": maeEstatClienViewUpdateInitComponents(); break;
		case "remove": maeEstatClienViewRemoveInitComponents(); break;
		case "lov": maeEstatClienViewLovInitComponents(); break;
	}
	//alert('accion :' + get('maeEstatClienViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeEstatClienViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeEstatClienView')) maeEstatClienViewCmdRequery();
}

function maeEstatClienViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	focusFirstField('maeEstatClienViewFrm', true);	
}

function maeEstatClienViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeEstatClienViewFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeEstatClienViewFrm', true);
}

function maeEstatClienViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeEstatClienViewFrm.Descripcion','S', GestionarMensaje('MaeEstatClienView.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeEstatClienViewFrm', true);
}

function maeEstatClienViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeEstatClienViewFrm.origen') == "pagina"){
		loadLocalizationWidget('maeEstatClienViewFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeEstatClienViewTmpUpdateValues = maeEstatClienViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeEstatClienViewFrm.Descripcion','S', GestionarMensaje('MaeEstatClienView.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeEstatClienViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		focusFirstField('maeEstatClienViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeEstatClienViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeEstatClienViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeEstatClienViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeEstatClienViewFrm', true);
}

function maeEstatClienViewLovInitComponents(){
	maeEstatClienViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeEstatClienViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad




//Función que permite cargar los datos de un elemento de lov seleccionado
function maeEstatClienViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeEstatClienViewFrm.' + campo, id);
	set('maeEstatClienViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeEstatClienViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeEstatClienViewLovReturnParameters.id = '';
	maeEstatClienViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeEstatClienViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEstatClienViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeEstatClienViewList.codSeleccionados();
	var descripcion = maeEstatClienViewList.extraeDato(
		maeEstatClienViewList.codSeleccionados()[0], maeEstatClienViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeEstatClienViewLovReturnParameters.id = codigo;
	maeEstatClienViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeEstatClienViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeEstatClienViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeEstatClienViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeEstatClienViewList", "MaeEstatClienViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeEstatClienViewPostQueryActions(datos);"]], "", "");	
}

function maeEstatClienViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeEstatClienViewFrm.lastQueryToSession'));
	var i =0;
	set('maeEstatClienViewFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeEstatClienViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeEstatClienViewCmdQuery(maeEstatClienViewPageCount);
}

function maeEstatClienViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeEstatClienViewPageCount = 1;
	maeEstatClienViewCmdQuery(maeEstatClienViewPageCount);
}

function maeEstatClienViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEstatClienViewLastQuery){
		maeEstatClienViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeEstatClienViewPageCount--;
	maeEstatClienViewCmdQuery(maeEstatClienViewPageCount);
}

function maeEstatClienViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeEstatClienViewLastQuery){
		maeEstatClienViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeEstatClienViewPageCount++;
	maeEstatClienViewCmdQuery(maeEstatClienViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeEstatClienViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeEstatClienViewListLayer', 'O');
		visibilidad('maeEstatClienViewListButtonsLayer', 'O');
		if(get('maeEstatClienViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeEstatClienViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeEstatClienViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeEstatClienViewChoiceColumn) + "</A>",
			i, maeEstatClienViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeEstatClienViewList.setDatos(datosTmp.filtrar([0,1],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeEstatClienViewTimeStamps = datosTmp.filtrar([2],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeEstatClienViewMorePagesFlag = true;
		maeEstatClienViewList.eliminar(mmgPageSize, 1);
	}else{
		maeEstatClienViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeEstatClienViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeEstatClienViewListLayer', 'V');
	visibilidad('maeEstatClienViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeEstatClienViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeEstatClienViewList.display();
	
	//Actualizamos el estado de los botones 
	if(maeEstatClienViewMorePagesFlag){
		set_estado_botonera('maeEstatClienViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeEstatClienViewPaginationButtonBar',
			3,"inactivo");
	}
	if(maeEstatClienViewPageCount > 1){
		set_estado_botonera('maeEstatClienViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeEstatClienViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeEstatClienViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeEstatClienViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeEstatClienViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEstatClienViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeEstatClienViewFrm.idSelection', maeEstatClienViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeEstatClienViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeEstatClienViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeEstatClienViewFrm.accion');
		parametros["accion"] = get('maeEstatClienViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeEstatClienViewLPStartUp', get('maeEstatClienViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeEstatClienViewCmdRequery();
	}
}

function maeEstatClienViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEstatClienViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeEstatClienViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeEstatClienViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeEstatClienViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeEstatClienViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeEstatClienViewFrm.timestamp', timestamps);


	maeEstatClienViewFrm.oculto='S';
	envia('maeEstatClienViewFrm');
	maeEstatClienViewFrm.oculto='N';
}

function maeEstatClienViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeEstatClienViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeEstatClienViewViewDetail(maeEstatClienViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeEstatClienViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeEstatClienViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeEstatClienViewLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	setDefaultLanguageValue('maeEstatClienViewFrm', 
		'Descripcion', 1,
		get('maeEstatClienViewFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeEstatClienViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	if(!hasDefaultLanguageValue('maeEstatClienViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeEstatClienView.Descripcion.requiered.message'));
		focaliza('maeEstatClienViewFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeEstatClienViewFrm.oculto='S';
		envia('maeEstatClienViewFrm');
		maeEstatClienViewFrm.oculto='N';
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
	maeEstatClienViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeEstatClienViewFrm.accion');
	var origenTmp = get('maeEstatClienViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeEstatClienViewBuildUpdateRecordString() != maeEstatClienViewTmpUpdateValues){
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
	document.all.maeEstatClienViewListLayer.style.display='none';
	document.all.maeEstatClienViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeEstatClienViewListLayer.style.display='';
	document.all.maeEstatClienViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeEstatClienViewDescripcion = get('maeEstatClienViewFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeEstatClienViewDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeEstatClienViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeEstatClienViewDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEstatClienViewFrm.accion'), 
		get('maeEstatClienViewFrm.origen'));
	
	jsMaeEstatClienViewId = get('maeEstatClienViewFrm.id').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeEstatClienViewDescripcion = buildLocalizedString('maeEstatClienViewFrm', 1);
	}else{
		jsMaeEstatClienViewDescripcion = get('maeEstatClienViewFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeEstatClienViewFrm.accion'), 
		get('maeEstatClienViewFrm.origen'));


	set('maeEstatClienViewFrm.id', jsMaeEstatClienViewId);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeEstatClienViewFrm', 1,  jsMaeEstatClienViewDescripcion)
		loadLocalizationWidget('maeEstatClienViewFrm', 'Descripcion', 1);
	}else{
		set('maeEstatClienViewFrm.Descripcion', jsMaeEstatClienViewDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeEstatClienViewDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeEstatClienViewFrm.errCodigo', errorCode);
	set('maeEstatClienViewFrm.errDescripcion', description);
	set('maeEstatClienViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
