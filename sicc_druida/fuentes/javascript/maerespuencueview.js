

/*
    INDRA/CAR/mmg
    $Id: maerespuencueview.js,v 1.1 2009/12/03 19:02:17 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeRespuEncueViewId = "";
var jsMaeRespuEncueViewCodResp = "";
var jsMaeRespuEncueViewValPeso = "";
var jsMaeRespuEncueViewDescripcion = "";

//Variables de paginacion, 
var maeRespuEncueViewPageCount = 1;

//Varible de columna que representa el campo de choice
var maeRespuEncueViewChoiceColumn = 2;

//Flag de siguiente pagina;
var maeRespuEncueViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeRespuEncueViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 171;
var sizeFormView = 149;
var sizeFormUpdate = 149;

//Ultima busqueda realizada
var maeRespuEncueViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("maeRespuEncueViewFrm.codResp");','focaliza("maeRespuEncueViewFrm.codResp");','focaliza("maeRespuEncueViewFrm.codResp");','focaliza("maeRespuEncueViewFrm.codResp");','focaliza("maeRespuEncueViewFrm.codResp");','focaliza("maeRespuEncueViewFrm.codResp");'],[3,'focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");'],[4,'focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");','focaliza("maeRespuEncueViewFrm.valPeso");'],[4,'focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");','focaliza("maeRespuEncueViewFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeRespuEncueViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeRespuEncueViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeRespuEncueViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeRespuEncueViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeRespuEncueViewFrm.accion')){
		case "query": maeRespuEncueViewQueryInitComponents(); break;
		case "view": maeRespuEncueViewViewInitComponents(); break;
		case "create": maeRespuEncueViewCreateInitComponents(); break;
		case "update": maeRespuEncueViewUpdateInitComponents(); break;
		case "remove": maeRespuEncueViewRemoveInitComponents(); break;
		case "lov": maeRespuEncueViewLovInitComponents(); break;
	}
	//alert('accion :' + get('maeRespuEncueViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeRespuEncueViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeRespuEncueView')) maeRespuEncueViewCmdRequery();
}

function maeRespuEncueViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('maeRespuEncueViewFrm', true);	
}

function maeRespuEncueViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeRespuEncueViewFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeRespuEncueViewFrm', true);
}

function maeRespuEncueViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeRespuEncueViewFrm.codResp','S', GestionarMensaje('MaeRespuEncueView.codResp.requiered.message'));
	
	setMV('maeRespuEncueViewFrm.valPeso','S', GestionarMensaje('MaeRespuEncueView.valPeso.requiered.message'));
	
	setMV('maeRespuEncueViewFrm.Descripcion','S', GestionarMensaje('MaeRespuEncueView.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeRespuEncueViewFrm', true);
}

function maeRespuEncueViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeRespuEncueViewFrm.origen') == "pagina"){
		loadLocalizationWidget('maeRespuEncueViewFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeRespuEncueViewTmpUpdateValues = maeRespuEncueViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeRespuEncueViewFrm.codResp','S', GestionarMensaje('MaeRespuEncueView.codResp.requiered.message'));
		setMV('maeRespuEncueViewFrm.valPeso','S', GestionarMensaje('MaeRespuEncueView.valPeso.requiered.message'));
		setMV('maeRespuEncueViewFrm.Descripcion','S', GestionarMensaje('MaeRespuEncueView.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeRespuEncueViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('maeRespuEncueViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeRespuEncueViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeRespuEncueViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeRespuEncueViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeRespuEncueViewFrm', true);
}

function maeRespuEncueViewLovInitComponents(){
	maeRespuEncueViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeRespuEncueViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeRespuEncueViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeRespuEncueViewFrm.' + campo, id);
	set('maeRespuEncueViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeRespuEncueViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeRespuEncueViewLovReturnParameters.id = '';
	maeRespuEncueViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeRespuEncueViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeRespuEncueViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeRespuEncueViewList.codSeleccionados();
	var descripcion = maeRespuEncueViewList.extraeDato(
		maeRespuEncueViewList.codSeleccionados()[0], maeRespuEncueViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeRespuEncueViewLovReturnParameters.id = codigo;
	maeRespuEncueViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeRespuEncueViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeRespuEncueViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeRespuEncueViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeRespuEncueViewList", "MaeRespuEncueViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeRespuEncueViewPostQueryActions(datos);"]], "", "");	
}

function maeRespuEncueViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeRespuEncueViewFrm.lastQueryToSession'));
	var i =0;
	set('maeRespuEncueViewFrm.codResp', paramsRequery.ij(i++));
	
	set('maeRespuEncueViewFrm.valPeso', paramsRequery.ij(i++));
	
	set('maeRespuEncueViewFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeRespuEncueViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeRespuEncueViewCmdQuery(maeRespuEncueViewPageCount);
}

function maeRespuEncueViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeRespuEncueViewPageCount = 1;
	maeRespuEncueViewCmdQuery(maeRespuEncueViewPageCount);
}

function maeRespuEncueViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeRespuEncueViewLastQuery){
		maeRespuEncueViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeRespuEncueViewPageCount--;
	maeRespuEncueViewCmdQuery(maeRespuEncueViewPageCount);
}

function maeRespuEncueViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeRespuEncueViewLastQuery){
		maeRespuEncueViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeRespuEncueViewPageCount++;
	maeRespuEncueViewCmdQuery(maeRespuEncueViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeRespuEncueViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeRespuEncueViewListLayer', 'O');
		visibilidad('maeRespuEncueViewListButtonsLayer', 'O');
		if(get('maeRespuEncueViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeRespuEncueViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeRespuEncueViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeRespuEncueViewChoiceColumn) + "</A>",
			i, maeRespuEncueViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeRespuEncueViewList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeRespuEncueViewTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeRespuEncueViewMorePagesFlag = true;
		maeRespuEncueViewList.eliminar(mmgPageSize, 1);
	}else{
		maeRespuEncueViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeRespuEncueViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeRespuEncueViewListLayer', 'V');
	visibilidad('maeRespuEncueViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeRespuEncueViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeRespuEncueViewList.display();
	
	//Actualizamos el estado de los botones 
	if(maeRespuEncueViewMorePagesFlag){
		set_estado_botonera('maeRespuEncueViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeRespuEncueViewPaginationButtonBar',
			3,"inactivo");
	}
	if(maeRespuEncueViewPageCount > 1){
		set_estado_botonera('maeRespuEncueViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeRespuEncueViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeRespuEncueViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeRespuEncueViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeRespuEncueViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeRespuEncueViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeRespuEncueViewFrm.idSelection', maeRespuEncueViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeRespuEncueViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeRespuEncueViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeRespuEncueViewFrm.accion');
		parametros["accion"] = get('maeRespuEncueViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeRespuEncueViewLPStartUp', get('maeRespuEncueViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeRespuEncueViewCmdRequery();
	}
}

function maeRespuEncueViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeRespuEncueViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeRespuEncueViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeRespuEncueViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeRespuEncueViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeRespuEncueViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeRespuEncueViewFrm.timestamp', timestamps);


	maeRespuEncueViewFrm.oculto='S';
	envia('maeRespuEncueViewFrm');
	maeRespuEncueViewFrm.oculto='N';
}

function maeRespuEncueViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeRespuEncueViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeRespuEncueViewViewDetail(maeRespuEncueViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeRespuEncueViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeRespuEncueViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeRespuEncueViewLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeRespuEncueViewFrm', 
		'Descripcion', 1,
		get('maeRespuEncueViewFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeRespuEncueViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeRespuEncueViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeRespuEncueView.Descripcion.requiered.message'));
		focaliza('maeRespuEncueViewFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeRespuEncueViewFrm.oculto='S';
		envia('maeRespuEncueViewFrm');
		maeRespuEncueViewFrm.oculto='N';
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
	maeRespuEncueViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeRespuEncueViewFrm.accion');
	var origenTmp = get('maeRespuEncueViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeRespuEncueViewBuildUpdateRecordString() != maeRespuEncueViewTmpUpdateValues){
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
	document.all.maeRespuEncueViewListLayer.style.display='none';
	document.all.maeRespuEncueViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeRespuEncueViewListLayer.style.display='';
	document.all.maeRespuEncueViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeRespuEncueViewCodResp = get('maeRespuEncueViewFrm.codResp').toString();
	jsMaeRespuEncueViewValPeso = get('maeRespuEncueViewFrm.valPeso').toString();
	jsMaeRespuEncueViewDescripcion = get('maeRespuEncueViewFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeRespuEncueViewCodResp + "|";
	parametros += jsMaeRespuEncueViewValPeso + "|";
	parametros += jsMaeRespuEncueViewDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeRespuEncueViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeRespuEncueViewCodResp + "|";
	parametros += jsMaeRespuEncueViewValPeso + "|";
	parametros += jsMaeRespuEncueViewDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeRespuEncueViewFrm.accion'), 
		get('maeRespuEncueViewFrm.origen'));
	
	jsMaeRespuEncueViewId = get('maeRespuEncueViewFrm.id').toString();
	jsMaeRespuEncueViewCodResp = get('maeRespuEncueViewFrm.codResp').toString();
	jsMaeRespuEncueViewValPeso = get('maeRespuEncueViewFrm.valPeso').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeRespuEncueViewDescripcion = buildLocalizedString('maeRespuEncueViewFrm', 1);
	}else{
		jsMaeRespuEncueViewDescripcion = get('maeRespuEncueViewFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeRespuEncueViewFrm.accion'), 
		get('maeRespuEncueViewFrm.origen'));


	set('maeRespuEncueViewFrm.id', jsMaeRespuEncueViewId);
	set('maeRespuEncueViewFrm.codResp', jsMaeRespuEncueViewCodResp);
	set('maeRespuEncueViewFrm.valPeso', jsMaeRespuEncueViewValPeso);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeRespuEncueViewFrm', 1,  jsMaeRespuEncueViewDescripcion)
		loadLocalizationWidget('maeRespuEncueViewFrm', 'Descripcion', 1);
	}else{
		set('maeRespuEncueViewFrm.Descripcion', jsMaeRespuEncueViewDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeRespuEncueViewCodResp = '';
	jsMaeRespuEncueViewValPeso = '';
	jsMaeRespuEncueViewDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeRespuEncueViewFrm.errCodigo', errorCode);
	set('maeRespuEncueViewFrm.errDescripcion', description);
	set('maeRespuEncueViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
