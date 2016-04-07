

/*
    INDRA/CAR/mmg
    $Id: preconfigp.js,v 1.1 2009/12/03 19:01:54 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPreConfiGpId = "";
var jsPreConfiGpPaisOidPais = "";
var jsPreConfiGpMarcOidMarc = "";
var jsPreConfiGpCanaOidCana = "";
var jsPreConfiGpValIncr = "";

//Variables de paginacion, 
var preConfiGpPageCount = 1;

//Varible de columna que representa el campo de choice
var preConfiGpChoiceColumn = 3;

//Flag de siguiente pagina;
var preConfiGpMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var preConfiGpTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var preConfiGpLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focalizaComboDependence("preConfiGp","marcOidMarc", false);','focalizaComboDependence("preConfiGp","marcOidMarc", false);','focalizaComboDependence("preConfiGp","marcOidMarc", false);','focalizaComboDependence("preConfiGp","marcOidMarc", true);','focalizaComboDependence("preConfiGp","marcOidMarc", true);','focalizaComboDependence("preConfiGp","marcOidMarc", true);'],[4,'focalizaComboDependence("preConfiGp","canaOidCana", false);','focalizaComboDependence("preConfiGp","canaOidCana", false);','focalizaComboDependence("preConfiGp","canaOidCana", false);','focalizaComboDependence("preConfiGp","canaOidCana", true);','focalizaComboDependence("preConfiGp","canaOidCana", true);','focalizaComboDependence("preConfiGp","canaOidCana", true);'],[5,'','focaliza("preConfiGpFrm.valIncr");','focaliza("preConfiGpFrm.valIncr");','','focaliza("preConfiGpFrm.valIncr");','focaliza("preConfiGpFrm.valIncr");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[5,'','focaliza("preConfiGpFrm.valIncr");','focaliza("preConfiGpFrm.valIncr");','','focaliza("preConfiGpFrm.valIncr");','focaliza("preConfiGpFrm.valIncr");']]);

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
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);
var canaOidCanaDependeceMap = new Vector();
canaOidCanaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
canaOidCanaDependeceMap.agregar(['canaOidCana', padresTmp, '', 'SegCanalView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
preConfiGpLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var preConfiGpTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function preConfiGpInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('preConfiGpFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('preConfiGpFrm.accion')){
		case "query": preConfiGpQueryInitComponents(); break;
		case "view": preConfiGpViewInitComponents(); break;
		case "create": preConfiGpCreateInitComponents(); break;
		case "update": preConfiGpUpdateInitComponents(); break;
		case "remove": preConfiGpRemoveInitComponents(); break;
		case "lov": preConfiGpLovInitComponents(); break;
	}
	//alert('accion :' + get('preConfiGpFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('preConfiGpFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('preConfiGp')) preConfiGpCmdRequery();
}

function preConfiGpQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('preConfiGpFrm', true);	
}

function preConfiGpViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('preConfiGpFrm', true);
}

function preConfiGpCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('preConfiGpFrm.marcOidMarc','S', GestionarMensaje('PreConfiGp.marcOidMarc.requiered.message'));
	
	setMV('preConfiGpFrm.canaOidCana','S', GestionarMensaje('PreConfiGp.canaOidCana.requiered.message'));
	
	setMV('preConfiGpFrm.valIncr','S', GestionarMensaje('PreConfiGp.valIncr.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('preConfiGpFrm', true);
}

function preConfiGpUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('preConfiGpFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		preConfiGpTmpUpdateValues = preConfiGpBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('preConfiGpFrm.marcOidMarc','S', GestionarMensaje('PreConfiGp.marcOidMarc.requiered.message'));
		setMV('preConfiGpFrm.canaOidCana','S', GestionarMensaje('PreConfiGp.canaOidCana.requiered.message'));
		setMV('preConfiGpFrm.valIncr','S', GestionarMensaje('PreConfiGp.valIncr.requiered.message'));
		
			focusFirstFieldModify('preConfiGpFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('preConfiGpFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('preConfiGpFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function preConfiGpRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	preConfiGpList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('preConfiGpFrm', true);
}

function preConfiGpLovInitComponents(){
	preConfiGpLovReturnParameters = window.dialogArguments;
	
	focusFirstField('preConfiGpFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function preConfiGpSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('preConfiGpFrm.' + campo, id);
	set('preConfiGpFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function preConfiGpLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	preConfiGpLovReturnParameters.id = '';
	preConfiGpLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function preConfiGpLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preConfiGpList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = preConfiGpList.codSeleccionados();
	var descripcion = preConfiGpList.extraeDato(
		preConfiGpList.codSeleccionados()[0], preConfiGpChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	preConfiGpLovReturnParameters.id = codigo;
	preConfiGpLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function preConfiGpCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('preConfiGpFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('preConfiGpFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "preConfiGpList", "PreConfiGpConectorTransactionQuery", 
		"result_ROWSET", parametros, "preConfiGpPostQueryActions(datos);"]], "", "");	
}

function preConfiGpCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('preConfiGpFrm.lastQueryToSession'));
	var i =0;
	set('preConfiGpFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('preConfiGpFrm.canaOidCana', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	preConfiGpPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	preConfiGpCmdQuery(preConfiGpPageCount);
}

function preConfiGpFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	preConfiGpPageCount = 1;
	preConfiGpCmdQuery(preConfiGpPageCount);
}

function preConfiGpPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preConfiGpLastQuery){
		preConfiGpFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	preConfiGpPageCount--;
	preConfiGpCmdQuery(preConfiGpPageCount);
}

function preConfiGpNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preConfiGpLastQuery){
		preConfiGpFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	preConfiGpPageCount++;
	preConfiGpCmdQuery(preConfiGpPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function preConfiGpPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('preConfiGpListLayer', 'O');
		visibilidad('preConfiGpListButtonsLayer', 'O');
		if(get('preConfiGpFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	preConfiGpLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:preConfiGpViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, preConfiGpChoiceColumn) + "</A>",
			i, preConfiGpChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	preConfiGpList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	preConfiGpTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		preConfiGpMorePagesFlag = true;
		preConfiGpList.eliminar(mmgPageSize, 1);
	}else{
		preConfiGpMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('preConfiGpFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('preConfiGpListLayer', 'V');
	visibilidad('preConfiGpListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('preConfiGpList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	preConfiGpList.display();
	
	//Actualizamos el estado de los botones 
	if(preConfiGpMorePagesFlag){
		set_estado_botonera('preConfiGpPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('preConfiGpPaginationButtonBar',
			3,"inactivo");
	}
	if(preConfiGpPageCount > 1){
		set_estado_botonera('preConfiGpPaginationButtonBar',
			2,"activo");
		set_estado_botonera('preConfiGpPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('preConfiGpPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('preConfiGpPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function preConfiGpUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preConfiGpList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('preConfiGpFrm.idSelection', preConfiGpList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('preConfiGpFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = preConfiGpList.codSeleccionados()[0];
		parametros["previousAction"] = get('preConfiGpFrm.accion');
		parametros["accion"] = get('preConfiGpFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PreConfiGpLPStartUp', get('preConfiGpFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) preConfiGpCmdRequery();
	}
}

function preConfiGpRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preConfiGpList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = preConfiGpList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('preConfiGpFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(preConfiGpList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += preConfiGpTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('preConfiGpFrm.timestamp', timestamps);


	preConfiGpFrm.oculto='S';
	envia('preConfiGpFrm');
	preConfiGpFrm.oculto='N';
}

function preConfiGpViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preConfiGpList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	preConfiGpViewDetail(preConfiGpList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function preConfiGpViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('preConfiGpFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PreConfiGpLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('preConfiGpFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		preConfiGpFrm.oculto='S';
		envia('preConfiGpFrm');
		preConfiGpFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('preConfiGpFrm.paisOidPais').toString() == ''){
		set('preConfiGpFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'preConfiGp');
		
	}
	if(get('preConfiGpFrm.marcOidMarc').toString() == ''){
		set('preConfiGpFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'preConfiGp');
		
	}
	if(get('preConfiGpFrm.canaOidCana').toString() == ''){
		set('preConfiGpFrm.canaOidCana', []);
		mmgResetCombosOnCascade('canaOidCana', 'canaOidCana', 'preConfiGp');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	preConfiGpRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('preConfiGpFrm.accion');
	var origenTmp = get('preConfiGpFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(preConfiGpBuildUpdateRecordString() != preConfiGpTmpUpdateValues){
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
	document.all.preConfiGpListLayer.style.display='none';
	document.all.preConfiGpListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.preConfiGpListLayer.style.display='';
	document.all.preConfiGpListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPreConfiGpMarcOidMarc = get('preConfiGpFrm.marcOidMarc')[0];
	jsPreConfiGpCanaOidCana = get('preConfiGpFrm.canaOidCana')[0];
	
	
	var parametros = "";
	parametros += jsPreConfiGpMarcOidMarc + "|";
	parametros += jsPreConfiGpCanaOidCana + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function preConfiGpBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPreConfiGpMarcOidMarc + "|";
	parametros += jsPreConfiGpCanaOidCana + "|";
	parametros += jsPreConfiGpValIncr + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preConfiGpFrm.accion'), 
		get('preConfiGpFrm.origen'));
	
	jsPreConfiGpId = get('preConfiGpFrm.id').toString();
	jsPreConfiGpPaisOidPais = get('preConfiGpFrm.paisOidPais')[0];
	jsPreConfiGpMarcOidMarc = get('preConfiGpFrm.marcOidMarc')[0];
	jsPreConfiGpCanaOidCana = get('preConfiGpFrm.canaOidCana')[0];
	jsPreConfiGpValIncr = get('preConfiGpFrm.valIncr').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preConfiGpFrm.accion'), 
		get('preConfiGpFrm.origen'));


	set('preConfiGpFrm.id', jsPreConfiGpId);
	set('preConfiGpFrm.paisOidPais', [jsPreConfiGpPaisOidPais]);
	set('preConfiGpFrm.marcOidMarc', [jsPreConfiGpMarcOidMarc]);
	set('preConfiGpFrm.canaOidCana', [jsPreConfiGpCanaOidCana]);
	set('preConfiGpFrm.valIncr', jsPreConfiGpValIncr);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPreConfiGpMarcOidMarc = '';
	jsPreConfiGpCanaOidCana = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('preConfiGpFrm.errCodigo', errorCode);
	set('preConfiGpFrm.errDescripcion', description);
	set('preConfiGpFrm.errSeverity', severity);
	fMostrarMensajeError();
}
