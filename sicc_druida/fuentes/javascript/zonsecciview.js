

/*
    INDRA/CAR/mmg
    $Id: zonsecciview.js,v 1.1 2009/12/03 19:01:46 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonSecciViewId = "";
var jsZonSecciViewCodSecc = "";
var jsZonSecciViewIndActi = "";
var jsZonSecciViewIndBorr = "";
var jsZonSecciViewCodNse1 = "";
var jsZonSecciViewCodNse2 = "";
var jsZonSecciViewCodNse3 = "";
var jsZonSecciViewDesSecci = "";
var jsZonSecciViewZzonOidZona = "";

//Variables de paginacion, 
var zonSecciViewPageCount = 1;

//Varible de columna que representa el campo de choice
var zonSecciViewChoiceColumn = 0;

//Flag de siguiente pagina;
var zonSecciViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonSecciViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 399;
var sizeFormView = 381;
var sizeFormUpdate = 381;

//Ultima busqueda realizada
var zonSecciViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("zonSecciView","zzonOidZona", false);','focalizaComboDependence("zonSecciView","zzonOidZona", false);','focalizaComboDependence("zonSecciView","zzonOidZona", false);','focalizaComboDependence("zonSecciView","zzonOidZona", true);','focalizaComboDependence("zonSecciView","zzonOidZona", true);','focalizaComboDependence("zonSecciView","zzonOidZona", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focalizaComboDependence("zonSecciView","zzonOidZona", false);','focalizaComboDependence("zonSecciView","zzonOidZona", false);','focalizaComboDependence("zonSecciView","zzonOidZona", false);','focalizaComboDependence("zonSecciView","zzonOidZona", true);','focalizaComboDependence("zonSecciView","zzonOidZona", true);','focalizaComboDependence("zonSecciView","zzonOidZona", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var zzonOidZonaDependeceMap = new Vector();
zzonOidZonaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zzonOidZonaDependeceMap.agregar(['zzonOidZona_marcOidMarc', padresTmp, 'zzonOidZona', 'SegMarca']);
padresTmp =  new Vector();
padresTmp.cargar([])
zzonOidZonaDependeceMap.agregar(['zzonOidZona_canaOidCana', padresTmp, 'zzonOidZona', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['zzonOidZona_marcOidMarc','zzonOidZona_canaOidCana'])
zzonOidZonaDependeceMap.agregar(['zzonOidZona', padresTmp, '', 'ZonZonaView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonSecciViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonSecciViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function zonSecciViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonSecciViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonSecciViewFrm.accion')){
		case "query": zonSecciViewQueryInitComponents(); break;
		case "view": zonSecciViewViewInitComponents(); break;
		case "create": zonSecciViewCreateInitComponents(); break;
		case "update": zonSecciViewUpdateInitComponents(); break;
		case "remove": zonSecciViewRemoveInitComponents(); break;
		case "lov": zonSecciViewLovInitComponents(); break;
	}
	//alert('accion :' + get('zonSecciViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('zonSecciViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonSecciView')) zonSecciViewCmdRequery();
}

function zonSecciViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	focusFirstField('zonSecciViewFrm', true);	
}

function zonSecciViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('zonSecciViewFrm', true);
}

function zonSecciViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonSecciViewFrm.codSecc','S', GestionarMensaje('ZonSecciView.codSecc.requiered.message'));
	
	setMV('zonSecciViewFrm.zzonOidZona','S', GestionarMensaje('ZonSecciView.zzonOidZona.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('zonSecciViewFrm', true);
}

function zonSecciViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonSecciViewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonSecciViewTmpUpdateValues = zonSecciViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonSecciViewFrm.codSecc','S', GestionarMensaje('ZonSecciView.codSecc.requiered.message'));
		setMV('zonSecciViewFrm.zzonOidZona','S', GestionarMensaje('ZonSecciView.zzonOidZona.requiered.message'));
		
			focusFirstFieldModify('zonSecciViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		focusFirstField('zonSecciViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonSecciViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonSecciViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonSecciViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('zonSecciViewFrm', true);
}

function zonSecciViewLovInitComponents(){
	zonSecciViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('zonSecciViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad











//Función que permite cargar los datos de un elemento de lov seleccionado
function zonSecciViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonSecciViewFrm.' + campo, id);
	set('zonSecciViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonSecciViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonSecciViewLovReturnParameters.id = '';
	zonSecciViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonSecciViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSecciViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonSecciViewList.codSeleccionados();
	var descripcion = zonSecciViewList.extraeDato(
		zonSecciViewList.codSeleccionados()[0], zonSecciViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonSecciViewLovReturnParameters.id = codigo;
	zonSecciViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonSecciViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonSecciViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonSecciViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonSecciViewList", "ZonSecciViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonSecciViewPostQueryActions(datos);"]], "", "");	
}

function zonSecciViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonSecciViewFrm.lastQueryToSession'));
	var i =0;
	set('zonSecciViewFrm.codSecc', paramsRequery.ij(i++));
	
	set('zonSecciViewFrm.indActi', paramsRequery.ij(i++));
	
	set('zonSecciViewFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonSecciViewFrm.codNse1', paramsRequery.ij(i++));
	
	set('zonSecciViewFrm.codNse2', paramsRequery.ij(i++));
	
	set('zonSecciViewFrm.codNse3', paramsRequery.ij(i++));
	
	set('zonSecciViewFrm.desSecci', paramsRequery.ij(i++));
	
	set('zonSecciViewFrm.zzonOidZona', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	zonSecciViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonSecciViewCmdQuery(zonSecciViewPageCount);
}

function zonSecciViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonSecciViewPageCount = 1;
	zonSecciViewCmdQuery(zonSecciViewPageCount);
}

function zonSecciViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonSecciViewLastQuery){
		zonSecciViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonSecciViewPageCount--;
	zonSecciViewCmdQuery(zonSecciViewPageCount);
}

function zonSecciViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonSecciViewLastQuery){
		zonSecciViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonSecciViewPageCount++;
	zonSecciViewCmdQuery(zonSecciViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonSecciViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonSecciViewListLayer', 'O');
		visibilidad('zonSecciViewListButtonsLayer', 'O');
		if(get('zonSecciViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonSecciViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonSecciViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonSecciViewChoiceColumn) + "</A>",
			i, zonSecciViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonSecciViewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonSecciViewTimeStamps = datosTmp.filtrar([9],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonSecciViewMorePagesFlag = true;
		zonSecciViewList.eliminar(mmgPageSize, 1);
	}else{
		zonSecciViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonSecciViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonSecciViewListLayer', 'V');
	visibilidad('zonSecciViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonSecciViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonSecciViewList.display();
	
	//Actualizamos el estado de los botones 
	if(zonSecciViewMorePagesFlag){
		set_estado_botonera('zonSecciViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonSecciViewPaginationButtonBar',
			3,"inactivo");
	}
	if(zonSecciViewPageCount > 1){
		set_estado_botonera('zonSecciViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonSecciViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonSecciViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonSecciViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonSecciViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSecciViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonSecciViewFrm.idSelection', zonSecciViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonSecciViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonSecciViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonSecciViewFrm.accion');
		parametros["accion"] = get('zonSecciViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ZonSecciViewLPStartUp', get('zonSecciViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) zonSecciViewCmdRequery();
	}
}

function zonSecciViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSecciViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonSecciViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonSecciViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonSecciViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonSecciViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonSecciViewFrm.timestamp', timestamps);


	zonSecciViewFrm.oculto='S';
	envia('zonSecciViewFrm');
	zonSecciViewFrm.oculto='N';
}

function zonSecciViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSecciViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonSecciViewViewDetail(zonSecciViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonSecciViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonSecciViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ZonSecciViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('zonSecciViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonSecciViewFrm.oculto='S';
		envia('zonSecciViewFrm');
		zonSecciViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonSecciViewFrm.zzonOidZona').toString() == ''){
		set('zonSecciViewFrm.zzonOidZona_marcOidMarc', []);
		mmgResetCombosOnCascade('zzonOidZona_marcOidMarc', 'zzonOidZona', 'zonSecciView');
		set('zonSecciViewFrm.zzonOidZona_canaOidCana', []);
		mmgResetCombosOnCascade('zzonOidZona_canaOidCana', 'zzonOidZona', 'zonSecciView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonSecciViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonSecciViewFrm.accion');
	var origenTmp = get('zonSecciViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonSecciViewBuildUpdateRecordString() != zonSecciViewTmpUpdateValues){
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
	document.all.zonSecciViewListLayer.style.display='none';
	document.all.zonSecciViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonSecciViewListLayer.style.display='';
	document.all.zonSecciViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonSecciViewCodSecc = get('zonSecciViewFrm.codSecc').toString();
	jsZonSecciViewIndActi = get('zonSecciViewFrm.indActi').toString();
	jsZonSecciViewIndBorr = get('zonSecciViewFrm.indBorr').toString();
	jsZonSecciViewCodNse1 = get('zonSecciViewFrm.codNse1').toString();
	jsZonSecciViewCodNse2 = get('zonSecciViewFrm.codNse2').toString();
	jsZonSecciViewCodNse3 = get('zonSecciViewFrm.codNse3').toString();
	jsZonSecciViewDesSecci = get('zonSecciViewFrm.desSecci').toString();
	jsZonSecciViewZzonOidZona = get('zonSecciViewFrm.zzonOidZona')[0];
	
	
	var parametros = "";
	parametros += jsZonSecciViewCodSecc + "|";
	parametros += jsZonSecciViewIndActi + "|";
	parametros += jsZonSecciViewIndBorr + "|";
	parametros += jsZonSecciViewCodNse1 + "|";
	parametros += jsZonSecciViewCodNse2 + "|";
	parametros += jsZonSecciViewCodNse3 + "|";
	parametros += jsZonSecciViewDesSecci + "|";
	parametros += jsZonSecciViewZzonOidZona + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonSecciViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonSecciViewCodSecc + "|";
	parametros += jsZonSecciViewIndActi + "|";
	parametros += jsZonSecciViewIndBorr + "|";
	parametros += jsZonSecciViewCodNse1 + "|";
	parametros += jsZonSecciViewCodNse2 + "|";
	parametros += jsZonSecciViewCodNse3 + "|";
	parametros += jsZonSecciViewDesSecci + "|";
	parametros += jsZonSecciViewZzonOidZona + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonSecciViewFrm.accion'), 
		get('zonSecciViewFrm.origen'));
	
	jsZonSecciViewId = get('zonSecciViewFrm.id').toString();
	jsZonSecciViewCodSecc = get('zonSecciViewFrm.codSecc').toString();
	jsZonSecciViewIndActi = get('zonSecciViewFrm.indActi').toString();
	jsZonSecciViewIndBorr = get('zonSecciViewFrm.indBorr').toString();
	jsZonSecciViewCodNse1 = get('zonSecciViewFrm.codNse1').toString();
	jsZonSecciViewCodNse2 = get('zonSecciViewFrm.codNse2').toString();
	jsZonSecciViewCodNse3 = get('zonSecciViewFrm.codNse3').toString();
	jsZonSecciViewDesSecci = get('zonSecciViewFrm.desSecci').toString();
	jsZonSecciViewZzonOidZona = get('zonSecciViewFrm.zzonOidZona')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonSecciViewFrm.accion'), 
		get('zonSecciViewFrm.origen'));


	set('zonSecciViewFrm.id', jsZonSecciViewId);
	set('zonSecciViewFrm.codSecc', jsZonSecciViewCodSecc);
	set('zonSecciViewFrm.indActi', jsZonSecciViewIndActi);
	set('zonSecciViewFrm.indBorr', jsZonSecciViewIndBorr);
	set('zonSecciViewFrm.codNse1', jsZonSecciViewCodNse1);
	set('zonSecciViewFrm.codNse2', jsZonSecciViewCodNse2);
	set('zonSecciViewFrm.codNse3', jsZonSecciViewCodNse3);
	set('zonSecciViewFrm.desSecci', jsZonSecciViewDesSecci);
	set('zonSecciViewFrm.zzonOidZona', [jsZonSecciViewZzonOidZona]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsZonSecciViewCodSecc = '';
	jsZonSecciViewIndActi = '';
	jsZonSecciViewIndBorr = '';
	jsZonSecciViewCodNse1 = '';
	jsZonSecciViewCodNse2 = '';
	jsZonSecciViewCodNse3 = '';
	jsZonSecciViewDesSecci = '';
	jsZonSecciViewZzonOidZona = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonSecciViewFrm.errCodigo', errorCode);
	set('zonSecciViewFrm.errDescripcion', description);
	set('zonSecciViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
