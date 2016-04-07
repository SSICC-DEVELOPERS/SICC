

/*
    INDRA/CAR/mmg
    $Id: zonregioview.js,v 1.1 2009/12/03 19:02:04 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonRegioViewId = "";
var jsZonRegioViewCodRegi = "";
var jsZonRegioViewIndActi = "";
var jsZonRegioViewIndBorr = "";
var jsZonRegioViewCodNse1 = "";
var jsZonRegioViewCodNse2 = "";
var jsZonRegioViewCodNse3 = "";
var jsZonRegioViewDesRegi = "";
var jsZonRegioViewZsgvOidSubgVent = "";

//Variables de paginacion, 
var zonRegioViewPageCount = 1;

//Varible de columna que representa el campo de choice
var zonRegioViewChoiceColumn = 0;

//Flag de siguiente pagina;
var zonRegioViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonRegioViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 399;
var sizeFormView = 381;
var sizeFormUpdate = 381;

//Ultima busqueda realizada
var zonRegioViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("zonRegioView","zsgvOidSubgVent", false);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", false);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", false);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", true);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", true);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focalizaComboDependence("zonRegioView","zsgvOidSubgVent", false);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", false);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", false);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", true);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", true);','focalizaComboDependence("zonRegioView","zsgvOidSubgVent", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var zsgvOidSubgVentDependeceMap = new Vector();
zsgvOidSubgVentDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zsgvOidSubgVentDependeceMap.agregar(['zsgvOidSubgVent_canaOidCana', padresTmp, 'zsgvOidSubgVent', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar([])
zsgvOidSubgVentDependeceMap.agregar(['zsgvOidSubgVent_marcOidMarc', padresTmp, 'zsgvOidSubgVent', 'SegMarca']);
padresTmp =  new Vector();
padresTmp.cargar(['zsgvOidSubgVent_canaOidCana','zsgvOidSubgVent_marcOidMarc'])
zsgvOidSubgVentDependeceMap.agregar(['zsgvOidSubgVent', padresTmp, '', 'ZonSubGerenVentaView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonRegioViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonRegioViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function zonRegioViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonRegioViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonRegioViewFrm.accion')){
		case "query": zonRegioViewQueryInitComponents(); break;
		case "view": zonRegioViewViewInitComponents(); break;
		case "create": zonRegioViewCreateInitComponents(); break;
		case "update": zonRegioViewUpdateInitComponents(); break;
		case "remove": zonRegioViewRemoveInitComponents(); break;
		case "lov": zonRegioViewLovInitComponents(); break;
	}
	//alert('accion :' + get('zonRegioViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('zonRegioViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonRegioView')) zonRegioViewCmdRequery();
}

function zonRegioViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	focusFirstField('zonRegioViewFrm', true);	
}

function zonRegioViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('zonRegioViewFrm', true);
}

function zonRegioViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonRegioViewFrm.codRegi','S', GestionarMensaje('ZonRegioView.codRegi.requiered.message'));
	
	setMV('zonRegioViewFrm.zsgvOidSubgVent','S', GestionarMensaje('ZonRegioView.zsgvOidSubgVent.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('zonRegioViewFrm', true);
}

function zonRegioViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonRegioViewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonRegioViewTmpUpdateValues = zonRegioViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonRegioViewFrm.codRegi','S', GestionarMensaje('ZonRegioView.codRegi.requiered.message'));
		setMV('zonRegioViewFrm.zsgvOidSubgVent','S', GestionarMensaje('ZonRegioView.zsgvOidSubgVent.requiered.message'));
		
			focusFirstFieldModify('zonRegioViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		focusFirstField('zonRegioViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonRegioViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonRegioViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonRegioViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('zonRegioViewFrm', true);
}

function zonRegioViewLovInitComponents(){
	zonRegioViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('zonRegioViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad











//Función que permite cargar los datos de un elemento de lov seleccionado
function zonRegioViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonRegioViewFrm.' + campo, id);
	set('zonRegioViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonRegioViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonRegioViewLovReturnParameters.id = '';
	zonRegioViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonRegioViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonRegioViewList.codSeleccionados();
	var descripcion = zonRegioViewList.extraeDato(
		zonRegioViewList.codSeleccionados()[0], zonRegioViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonRegioViewLovReturnParameters.id = codigo;
	zonRegioViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonRegioViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonRegioViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonRegioViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonRegioViewList", "ZonRegioViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonRegioViewPostQueryActions(datos);"]], "", "");	
}

function zonRegioViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonRegioViewFrm.lastQueryToSession'));
	var i =0;
	set('zonRegioViewFrm.codRegi', paramsRequery.ij(i++));
	
	set('zonRegioViewFrm.indActi', paramsRequery.ij(i++));
	
	set('zonRegioViewFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonRegioViewFrm.codNse1', paramsRequery.ij(i++));
	
	set('zonRegioViewFrm.codNse2', paramsRequery.ij(i++));
	
	set('zonRegioViewFrm.codNse3', paramsRequery.ij(i++));
	
	set('zonRegioViewFrm.desRegi', paramsRequery.ij(i++));
	
	set('zonRegioViewFrm.zsgvOidSubgVent', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	zonRegioViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonRegioViewCmdQuery(zonRegioViewPageCount);
}

function zonRegioViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonRegioViewPageCount = 1;
	zonRegioViewCmdQuery(zonRegioViewPageCount);
}

function zonRegioViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonRegioViewLastQuery){
		zonRegioViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonRegioViewPageCount--;
	zonRegioViewCmdQuery(zonRegioViewPageCount);
}

function zonRegioViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonRegioViewLastQuery){
		zonRegioViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonRegioViewPageCount++;
	zonRegioViewCmdQuery(zonRegioViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonRegioViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonRegioViewListLayer', 'O');
		visibilidad('zonRegioViewListButtonsLayer', 'O');
		if(get('zonRegioViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonRegioViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonRegioViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonRegioViewChoiceColumn) + "</A>",
			i, zonRegioViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonRegioViewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonRegioViewTimeStamps = datosTmp.filtrar([9],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonRegioViewMorePagesFlag = true;
		zonRegioViewList.eliminar(mmgPageSize, 1);
	}else{
		zonRegioViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonRegioViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonRegioViewListLayer', 'V');
	visibilidad('zonRegioViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonRegioViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonRegioViewList.display();
	
	//Actualizamos el estado de los botones 
	if(zonRegioViewMorePagesFlag){
		set_estado_botonera('zonRegioViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonRegioViewPaginationButtonBar',
			3,"inactivo");
	}
	if(zonRegioViewPageCount > 1){
		set_estado_botonera('zonRegioViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonRegioViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonRegioViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonRegioViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonRegioViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonRegioViewFrm.idSelection', zonRegioViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonRegioViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonRegioViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonRegioViewFrm.accion');
		parametros["accion"] = get('zonRegioViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ZonRegioViewLPStartUp', get('zonRegioViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) zonRegioViewCmdRequery();
	}
}

function zonRegioViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonRegioViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonRegioViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonRegioViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonRegioViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonRegioViewFrm.timestamp', timestamps);


	zonRegioViewFrm.oculto='S';
	envia('zonRegioViewFrm');
	zonRegioViewFrm.oculto='N';
}

function zonRegioViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonRegioViewViewDetail(zonRegioViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonRegioViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonRegioViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ZonRegioViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('zonRegioViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonRegioViewFrm.oculto='S';
		envia('zonRegioViewFrm');
		zonRegioViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonRegioViewFrm.zsgvOidSubgVent').toString() == ''){
		set('zonRegioViewFrm.zsgvOidSubgVent_canaOidCana', []);
		mmgResetCombosOnCascade('zsgvOidSubgVent_canaOidCana', 'zsgvOidSubgVent', 'zonRegioView');
		set('zonRegioViewFrm.zsgvOidSubgVent_marcOidMarc', []);
		mmgResetCombosOnCascade('zsgvOidSubgVent_marcOidMarc', 'zsgvOidSubgVent', 'zonRegioView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonRegioViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonRegioViewFrm.accion');
	var origenTmp = get('zonRegioViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonRegioViewBuildUpdateRecordString() != zonRegioViewTmpUpdateValues){
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
	document.all.zonRegioViewListLayer.style.display='none';
	document.all.zonRegioViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonRegioViewListLayer.style.display='';
	document.all.zonRegioViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonRegioViewCodRegi = get('zonRegioViewFrm.codRegi').toString();
	jsZonRegioViewIndActi = get('zonRegioViewFrm.indActi').toString();
	jsZonRegioViewIndBorr = get('zonRegioViewFrm.indBorr').toString();
	jsZonRegioViewCodNse1 = get('zonRegioViewFrm.codNse1').toString();
	jsZonRegioViewCodNse2 = get('zonRegioViewFrm.codNse2').toString();
	jsZonRegioViewCodNse3 = get('zonRegioViewFrm.codNse3').toString();
	jsZonRegioViewDesRegi = get('zonRegioViewFrm.desRegi').toString();
	jsZonRegioViewZsgvOidSubgVent = get('zonRegioViewFrm.zsgvOidSubgVent')[0];
	
	
	var parametros = "";
	parametros += jsZonRegioViewCodRegi + "|";
	parametros += jsZonRegioViewIndActi + "|";
	parametros += jsZonRegioViewIndBorr + "|";
	parametros += jsZonRegioViewCodNse1 + "|";
	parametros += jsZonRegioViewCodNse2 + "|";
	parametros += jsZonRegioViewCodNse3 + "|";
	parametros += jsZonRegioViewDesRegi + "|";
	parametros += jsZonRegioViewZsgvOidSubgVent + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonRegioViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonRegioViewCodRegi + "|";
	parametros += jsZonRegioViewIndActi + "|";
	parametros += jsZonRegioViewIndBorr + "|";
	parametros += jsZonRegioViewCodNse1 + "|";
	parametros += jsZonRegioViewCodNse2 + "|";
	parametros += jsZonRegioViewCodNse3 + "|";
	parametros += jsZonRegioViewDesRegi + "|";
	parametros += jsZonRegioViewZsgvOidSubgVent + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonRegioViewFrm.accion'), 
		get('zonRegioViewFrm.origen'));
	
	jsZonRegioViewId = get('zonRegioViewFrm.id').toString();
	jsZonRegioViewCodRegi = get('zonRegioViewFrm.codRegi').toString();
	jsZonRegioViewIndActi = get('zonRegioViewFrm.indActi').toString();
	jsZonRegioViewIndBorr = get('zonRegioViewFrm.indBorr').toString();
	jsZonRegioViewCodNse1 = get('zonRegioViewFrm.codNse1').toString();
	jsZonRegioViewCodNse2 = get('zonRegioViewFrm.codNse2').toString();
	jsZonRegioViewCodNse3 = get('zonRegioViewFrm.codNse3').toString();
	jsZonRegioViewDesRegi = get('zonRegioViewFrm.desRegi').toString();
	jsZonRegioViewZsgvOidSubgVent = get('zonRegioViewFrm.zsgvOidSubgVent')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonRegioViewFrm.accion'), 
		get('zonRegioViewFrm.origen'));


	set('zonRegioViewFrm.id', jsZonRegioViewId);
	set('zonRegioViewFrm.codRegi', jsZonRegioViewCodRegi);
	set('zonRegioViewFrm.indActi', jsZonRegioViewIndActi);
	set('zonRegioViewFrm.indBorr', jsZonRegioViewIndBorr);
	set('zonRegioViewFrm.codNse1', jsZonRegioViewCodNse1);
	set('zonRegioViewFrm.codNse2', jsZonRegioViewCodNse2);
	set('zonRegioViewFrm.codNse3', jsZonRegioViewCodNse3);
	set('zonRegioViewFrm.desRegi', jsZonRegioViewDesRegi);
	set('zonRegioViewFrm.zsgvOidSubgVent', [jsZonRegioViewZsgvOidSubgVent]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsZonRegioViewCodRegi = '';
	jsZonRegioViewIndActi = '';
	jsZonRegioViewIndBorr = '';
	jsZonRegioViewCodNse1 = '';
	jsZonRegioViewCodNse2 = '';
	jsZonRegioViewCodNse3 = '';
	jsZonRegioViewDesRegi = '';
	jsZonRegioViewZsgvOidSubgVent = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonRegioViewFrm.errCodigo', errorCode);
	set('zonRegioViewFrm.errDescripcion', description);
	set('zonRegioViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
