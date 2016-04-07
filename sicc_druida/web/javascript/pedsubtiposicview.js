

/*
    INDRA/CAR/mmg
    $Id: pedsubtiposicview.js,v 1.1 2009/12/03 19:02:19 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedSubtiPosicViewId = "";
var jsPedSubtiPosicViewCodSubtPosi = "";
var jsPedSubtiPosicViewTposOidTipoPosi = "";
var jsPedSubtiPosicViewDescripcion = "";

//Variables de paginacion, 
var pedSubtiPosicViewPageCount = 1;

//Varible de columna que representa el campo de choice
var pedSubtiPosicViewChoiceColumn = 2;

//Flag de siguiente pagina;
var pedSubtiPosicViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedSubtiPosicViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var pedSubtiPosicViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("pedSubtiPosicViewFrm.codSubtPosi");','focaliza("pedSubtiPosicViewFrm.codSubtPosi");','focaliza("pedSubtiPosicViewFrm.codSubtPosi");','focaliza("pedSubtiPosicViewFrm.codSubtPosi");','focaliza("pedSubtiPosicViewFrm.codSubtPosi");','focaliza("pedSubtiPosicViewFrm.codSubtPosi");'],[3,'focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", false);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", false);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", false);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", true);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", true);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", true);'],[4,'focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", false);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", false);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", false);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", true);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", true);','focalizaComboDependence("pedSubtiPosicView","tposOidTipoPosi", true);'],[4,'focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");','focaliza("pedSubtiPosicViewFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var tposOidTipoPosiDependeceMap = new Vector();
tposOidTipoPosiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tposOidTipoPosiDependeceMap.agregar(['tposOidTipoPosi', padresTmp, '', 'PedTipoPosic']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedSubtiPosicViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedSubtiPosicViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedSubtiPosicViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedSubtiPosicViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedSubtiPosicViewFrm.accion')){
		case "query": pedSubtiPosicViewQueryInitComponents(); break;
		case "view": pedSubtiPosicViewViewInitComponents(); break;
		case "create": pedSubtiPosicViewCreateInitComponents(); break;
		case "update": pedSubtiPosicViewUpdateInitComponents(); break;
		case "remove": pedSubtiPosicViewRemoveInitComponents(); break;
		case "lov": pedSubtiPosicViewLovInitComponents(); break;
	}
	//alert('accion :' + get('pedSubtiPosicViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedSubtiPosicViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedSubtiPosicView')) pedSubtiPosicViewCmdRequery();
}

function pedSubtiPosicViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('pedSubtiPosicViewFrm', true);	
}

function pedSubtiPosicViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('pedSubtiPosicViewFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('pedSubtiPosicViewFrm', true);
}

function pedSubtiPosicViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedSubtiPosicViewFrm.codSubtPosi','S', GestionarMensaje('PedSubtiPosicView.codSubtPosi.requiered.message'));
	
	setMV('pedSubtiPosicViewFrm.tposOidTipoPosi','S', GestionarMensaje('PedSubtiPosicView.tposOidTipoPosi.requiered.message'));
	
	setMV('pedSubtiPosicViewFrm.Descripcion','S', GestionarMensaje('PedSubtiPosicView.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedSubtiPosicViewFrm', true);
}

function pedSubtiPosicViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedSubtiPosicViewFrm.origen') == "pagina"){
		loadLocalizationWidget('pedSubtiPosicViewFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		pedSubtiPosicViewTmpUpdateValues = pedSubtiPosicViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedSubtiPosicViewFrm.codSubtPosi','S', GestionarMensaje('PedSubtiPosicView.codSubtPosi.requiered.message'));
		setMV('pedSubtiPosicViewFrm.tposOidTipoPosi','S', GestionarMensaje('PedSubtiPosicView.tposOidTipoPosi.requiered.message'));
		setMV('pedSubtiPosicViewFrm.Descripcion','S', GestionarMensaje('PedSubtiPosicView.Descripcion.requiered.message'));
		
			focusFirstFieldModify('pedSubtiPosicViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('pedSubtiPosicViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedSubtiPosicViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedSubtiPosicViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedSubtiPosicViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedSubtiPosicViewFrm', true);
}

function pedSubtiPosicViewLovInitComponents(){
	pedSubtiPosicViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedSubtiPosicViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function pedSubtiPosicViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedSubtiPosicViewFrm.' + campo, id);
	set('pedSubtiPosicViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedSubtiPosicViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedSubtiPosicViewLovReturnParameters.id = '';
	pedSubtiPosicViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedSubtiPosicViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedSubtiPosicViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedSubtiPosicViewList.codSeleccionados();
	var descripcion = pedSubtiPosicViewList.extraeDato(
		pedSubtiPosicViewList.codSeleccionados()[0], pedSubtiPosicViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedSubtiPosicViewLovReturnParameters.id = codigo;
	pedSubtiPosicViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedSubtiPosicViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedSubtiPosicViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedSubtiPosicViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedSubtiPosicViewList", "PedSubtiPosicViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedSubtiPosicViewPostQueryActions(datos);"]], "", "");	
}

function pedSubtiPosicViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedSubtiPosicViewFrm.lastQueryToSession'));
	var i =0;
	set('pedSubtiPosicViewFrm.codSubtPosi', paramsRequery.ij(i++));
	
	set('pedSubtiPosicViewFrm.tposOidTipoPosi', [paramsRequery.ij(i++)]);
	
	set('pedSubtiPosicViewFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	pedSubtiPosicViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedSubtiPosicViewCmdQuery(pedSubtiPosicViewPageCount);
}

function pedSubtiPosicViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedSubtiPosicViewPageCount = 1;
	pedSubtiPosicViewCmdQuery(pedSubtiPosicViewPageCount);
}

function pedSubtiPosicViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedSubtiPosicViewLastQuery){
		pedSubtiPosicViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedSubtiPosicViewPageCount--;
	pedSubtiPosicViewCmdQuery(pedSubtiPosicViewPageCount);
}

function pedSubtiPosicViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedSubtiPosicViewLastQuery){
		pedSubtiPosicViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedSubtiPosicViewPageCount++;
	pedSubtiPosicViewCmdQuery(pedSubtiPosicViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedSubtiPosicViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedSubtiPosicViewListLayer', 'O');
		visibilidad('pedSubtiPosicViewListButtonsLayer', 'O');
		if(get('pedSubtiPosicViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedSubtiPosicViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedSubtiPosicViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedSubtiPosicViewChoiceColumn) + "</A>",
			i, pedSubtiPosicViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedSubtiPosicViewList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedSubtiPosicViewTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedSubtiPosicViewMorePagesFlag = true;
		pedSubtiPosicViewList.eliminar(mmgPageSize, 1);
	}else{
		pedSubtiPosicViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedSubtiPosicViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedSubtiPosicViewListLayer', 'V');
	visibilidad('pedSubtiPosicViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedSubtiPosicViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedSubtiPosicViewList.display();
	
	//Actualizamos el estado de los botones 
	if(pedSubtiPosicViewMorePagesFlag){
		set_estado_botonera('pedSubtiPosicViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedSubtiPosicViewPaginationButtonBar',
			3,"inactivo");
	}
	if(pedSubtiPosicViewPageCount > 1){
		set_estado_botonera('pedSubtiPosicViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedSubtiPosicViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedSubtiPosicViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedSubtiPosicViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedSubtiPosicViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedSubtiPosicViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedSubtiPosicViewFrm.idSelection', pedSubtiPosicViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedSubtiPosicViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedSubtiPosicViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedSubtiPosicViewFrm.accion');
		parametros["accion"] = get('pedSubtiPosicViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedSubtiPosicViewLPStartUp', get('pedSubtiPosicViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedSubtiPosicViewCmdRequery();
	}
}

function pedSubtiPosicViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedSubtiPosicViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedSubtiPosicViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedSubtiPosicViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedSubtiPosicViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedSubtiPosicViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedSubtiPosicViewFrm.timestamp', timestamps);


	pedSubtiPosicViewFrm.oculto='S';
	envia('pedSubtiPosicViewFrm');
	pedSubtiPosicViewFrm.oculto='N';
}

function pedSubtiPosicViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedSubtiPosicViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedSubtiPosicViewViewDetail(pedSubtiPosicViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedSubtiPosicViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedSubtiPosicViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedSubtiPosicViewLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('pedSubtiPosicViewFrm', 
		'Descripcion', 1,
		get('pedSubtiPosicViewFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('pedSubtiPosicViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('pedSubtiPosicViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('PedSubtiPosicView.Descripcion.requiered.message'));
		focaliza('pedSubtiPosicViewFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		pedSubtiPosicViewFrm.oculto='S';
		envia('pedSubtiPosicViewFrm');
		pedSubtiPosicViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedSubtiPosicViewFrm.tposOidTipoPosi').toString() == ''){
		set('pedSubtiPosicViewFrm.tposOidTipoPosi', []);
		mmgResetCombosOnCascade('tposOidTipoPosi', 'tposOidTipoPosi', 'pedSubtiPosicView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedSubtiPosicViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedSubtiPosicViewFrm.accion');
	var origenTmp = get('pedSubtiPosicViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedSubtiPosicViewBuildUpdateRecordString() != pedSubtiPosicViewTmpUpdateValues){
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
	document.all.pedSubtiPosicViewListLayer.style.display='none';
	document.all.pedSubtiPosicViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedSubtiPosicViewListLayer.style.display='';
	document.all.pedSubtiPosicViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedSubtiPosicViewCodSubtPosi = get('pedSubtiPosicViewFrm.codSubtPosi').toString();
	jsPedSubtiPosicViewTposOidTipoPosi = get('pedSubtiPosicViewFrm.tposOidTipoPosi')[0];
	jsPedSubtiPosicViewDescripcion = get('pedSubtiPosicViewFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsPedSubtiPosicViewCodSubtPosi + "|";
	parametros += jsPedSubtiPosicViewTposOidTipoPosi + "|";
	parametros += jsPedSubtiPosicViewDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedSubtiPosicViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedSubtiPosicViewCodSubtPosi + "|";
	parametros += jsPedSubtiPosicViewTposOidTipoPosi + "|";
	parametros += jsPedSubtiPosicViewDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedSubtiPosicViewFrm.accion'), 
		get('pedSubtiPosicViewFrm.origen'));
	
	jsPedSubtiPosicViewId = get('pedSubtiPosicViewFrm.id').toString();
	jsPedSubtiPosicViewCodSubtPosi = get('pedSubtiPosicViewFrm.codSubtPosi').toString();
	jsPedSubtiPosicViewTposOidTipoPosi = get('pedSubtiPosicViewFrm.tposOidTipoPosi')[0];
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPedSubtiPosicViewDescripcion = buildLocalizedString('pedSubtiPosicViewFrm', 1);
	}else{
		jsPedSubtiPosicViewDescripcion = get('pedSubtiPosicViewFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedSubtiPosicViewFrm.accion'), 
		get('pedSubtiPosicViewFrm.origen'));


	set('pedSubtiPosicViewFrm.id', jsPedSubtiPosicViewId);
	set('pedSubtiPosicViewFrm.codSubtPosi', jsPedSubtiPosicViewCodSubtPosi);
	set('pedSubtiPosicViewFrm.tposOidTipoPosi', [jsPedSubtiPosicViewTposOidTipoPosi]);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('pedSubtiPosicViewFrm', 1,  jsPedSubtiPosicViewDescripcion)
		loadLocalizationWidget('pedSubtiPosicViewFrm', 'Descripcion', 1);
	}else{
		set('pedSubtiPosicViewFrm.Descripcion', jsPedSubtiPosicViewDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedSubtiPosicViewCodSubtPosi = '';
	jsPedSubtiPosicViewTposOidTipoPosi = '';
	jsPedSubtiPosicViewDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedSubtiPosicViewFrm.errCodigo', errorCode);
	set('pedSubtiPosicViewFrm.errDescripcion', description);
	set('pedSubtiPosicViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
