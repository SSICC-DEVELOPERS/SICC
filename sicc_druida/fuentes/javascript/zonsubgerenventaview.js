

/*
    INDRA/CAR/mmg
    $Id: zonsubgerenventaview.js,v 1.1 2009/12/03 19:02:03 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonSubGerenVentaViewId = "";
var jsZonSubGerenVentaViewPaisOidPais = "";
var jsZonSubGerenVentaViewCodSubgVent = "";
var jsZonSubGerenVentaViewIndBorr = "";
var jsZonSubGerenVentaViewIndActi = "";
var jsZonSubGerenVentaViewCodNse1 = "";
var jsZonSubGerenVentaViewCodNse2 = "";
var jsZonSubGerenVentaViewCodNse3 = "";
var jsZonSubGerenVentaViewDesSubgVent = "";
var jsZonSubGerenVentaViewMarcOidMarc = "";
var jsZonSubGerenVentaViewCanaOidCana = "";

//Variables de paginacion, 
var zonSubGerenVentaViewPageCount = 1;

//Varible de columna que representa el campo de choice
var zonSubGerenVentaViewChoiceColumn = 1;

//Flag de siguiente pagina;
var zonSubGerenVentaViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonSubGerenVentaViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 483;
var sizeFormView = 473;
var sizeFormUpdate = 473;

//Ultima busqueda realizada
var zonSubGerenVentaViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("zonSubGerenVentaView","canaOidCana", false);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", false);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", false);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", true);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", true);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focalizaComboDependence("zonSubGerenVentaView","canaOidCana", false);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", false);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", false);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", true);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", true);','focalizaComboDependence("zonSubGerenVentaView","canaOidCana", true);']]);

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
zonSubGerenVentaViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonSubGerenVentaViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function zonSubGerenVentaViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonSubGerenVentaViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonSubGerenVentaViewFrm.accion')){
		case "query": zonSubGerenVentaViewQueryInitComponents(); break;
		case "view": zonSubGerenVentaViewViewInitComponents(); break;
		case "create": zonSubGerenVentaViewCreateInitComponents(); break;
		case "update": zonSubGerenVentaViewUpdateInitComponents(); break;
		case "remove": zonSubGerenVentaViewRemoveInitComponents(); break;
		case "lov": zonSubGerenVentaViewLovInitComponents(); break;
	}
	//alert('accion :' + get('zonSubGerenVentaViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('zonSubGerenVentaViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonSubGerenVentaView')) zonSubGerenVentaViewCmdRequery();
}

function zonSubGerenVentaViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('zonSubGerenVentaViewFrm', true);	
}

function zonSubGerenVentaViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('zonSubGerenVentaViewFrm', true);
}

function zonSubGerenVentaViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonSubGerenVentaViewFrm.paisOidPais','S', GestionarMensaje('ZonSubGerenVentaView.paisOidPais.requiered.message'));
	
	setMV('zonSubGerenVentaViewFrm.codSubgVent','S', GestionarMensaje('ZonSubGerenVentaView.codSubgVent.requiered.message'));
	
	setMV('zonSubGerenVentaViewFrm.marcOidMarc','S', GestionarMensaje('ZonSubGerenVentaView.marcOidMarc.requiered.message'));
	
	setMV('zonSubGerenVentaViewFrm.canaOidCana','S', GestionarMensaje('ZonSubGerenVentaView.canaOidCana.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('zonSubGerenVentaViewFrm', true);
}

function zonSubGerenVentaViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonSubGerenVentaViewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonSubGerenVentaViewTmpUpdateValues = zonSubGerenVentaViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonSubGerenVentaViewFrm.paisOidPais','S', GestionarMensaje('ZonSubGerenVentaView.paisOidPais.requiered.message'));
		setMV('zonSubGerenVentaViewFrm.codSubgVent','S', GestionarMensaje('ZonSubGerenVentaView.codSubgVent.requiered.message'));
		setMV('zonSubGerenVentaViewFrm.marcOidMarc','S', GestionarMensaje('ZonSubGerenVentaView.marcOidMarc.requiered.message'));
		setMV('zonSubGerenVentaViewFrm.canaOidCana','S', GestionarMensaje('ZonSubGerenVentaView.canaOidCana.requiered.message'));
		
			focusFirstFieldModify('zonSubGerenVentaViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('zonSubGerenVentaViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonSubGerenVentaViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonSubGerenVentaViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonSubGerenVentaViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('zonSubGerenVentaViewFrm', true);
}

function zonSubGerenVentaViewLovInitComponents(){
	zonSubGerenVentaViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('zonSubGerenVentaViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad













//Función que permite cargar los datos de un elemento de lov seleccionado
function zonSubGerenVentaViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonSubGerenVentaViewFrm.' + campo, id);
	set('zonSubGerenVentaViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonSubGerenVentaViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonSubGerenVentaViewLovReturnParameters.id = '';
	zonSubGerenVentaViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonSubGerenVentaViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSubGerenVentaViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonSubGerenVentaViewList.codSeleccionados();
	var descripcion = zonSubGerenVentaViewList.extraeDato(
		zonSubGerenVentaViewList.codSeleccionados()[0], zonSubGerenVentaViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonSubGerenVentaViewLovReturnParameters.id = codigo;
	zonSubGerenVentaViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonSubGerenVentaViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonSubGerenVentaViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonSubGerenVentaViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonSubGerenVentaViewList", "ZonSubGerenVentaViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonSubGerenVentaViewPostQueryActions(datos);"]], "", "");	
}

function zonSubGerenVentaViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonSubGerenVentaViewFrm.lastQueryToSession'));
	var i =0;
	set('zonSubGerenVentaViewFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('zonSubGerenVentaViewFrm.codSubgVent', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaViewFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaViewFrm.indActi', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaViewFrm.codNse1', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaViewFrm.codNse2', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaViewFrm.codNse3', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaViewFrm.desSubgVent', paramsRequery.ij(i++));
	
	set('zonSubGerenVentaViewFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('zonSubGerenVentaViewFrm.canaOidCana', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	zonSubGerenVentaViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonSubGerenVentaViewCmdQuery(zonSubGerenVentaViewPageCount);
}

function zonSubGerenVentaViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonSubGerenVentaViewPageCount = 1;
	zonSubGerenVentaViewCmdQuery(zonSubGerenVentaViewPageCount);
}

function zonSubGerenVentaViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonSubGerenVentaViewLastQuery){
		zonSubGerenVentaViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonSubGerenVentaViewPageCount--;
	zonSubGerenVentaViewCmdQuery(zonSubGerenVentaViewPageCount);
}

function zonSubGerenVentaViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonSubGerenVentaViewLastQuery){
		zonSubGerenVentaViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonSubGerenVentaViewPageCount++;
	zonSubGerenVentaViewCmdQuery(zonSubGerenVentaViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonSubGerenVentaViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonSubGerenVentaViewListLayer', 'O');
		visibilidad('zonSubGerenVentaViewListButtonsLayer', 'O');
		if(get('zonSubGerenVentaViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonSubGerenVentaViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonSubGerenVentaViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonSubGerenVentaViewChoiceColumn) + "</A>",
			i, zonSubGerenVentaViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonSubGerenVentaViewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonSubGerenVentaViewTimeStamps = datosTmp.filtrar([11],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonSubGerenVentaViewMorePagesFlag = true;
		zonSubGerenVentaViewList.eliminar(mmgPageSize, 1);
	}else{
		zonSubGerenVentaViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonSubGerenVentaViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonSubGerenVentaViewListLayer', 'V');
	visibilidad('zonSubGerenVentaViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonSubGerenVentaViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonSubGerenVentaViewList.display();
	
	//Actualizamos el estado de los botones 
	if(zonSubGerenVentaViewMorePagesFlag){
		set_estado_botonera('zonSubGerenVentaViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonSubGerenVentaViewPaginationButtonBar',
			3,"inactivo");
	}
	if(zonSubGerenVentaViewPageCount > 1){
		set_estado_botonera('zonSubGerenVentaViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonSubGerenVentaViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonSubGerenVentaViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonSubGerenVentaViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonSubGerenVentaViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSubGerenVentaViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonSubGerenVentaViewFrm.idSelection', zonSubGerenVentaViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonSubGerenVentaViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonSubGerenVentaViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonSubGerenVentaViewFrm.accion');
		parametros["accion"] = get('zonSubGerenVentaViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ZonSubGerenVentaViewLPStartUp', get('zonSubGerenVentaViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) zonSubGerenVentaViewCmdRequery();
	}
}

function zonSubGerenVentaViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSubGerenVentaViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonSubGerenVentaViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonSubGerenVentaViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonSubGerenVentaViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonSubGerenVentaViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonSubGerenVentaViewFrm.timestamp', timestamps);


	zonSubGerenVentaViewFrm.oculto='S';
	envia('zonSubGerenVentaViewFrm');
	zonSubGerenVentaViewFrm.oculto='N';
}

function zonSubGerenVentaViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSubGerenVentaViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonSubGerenVentaViewViewDetail(zonSubGerenVentaViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonSubGerenVentaViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonSubGerenVentaViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ZonSubGerenVentaViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('zonSubGerenVentaViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonSubGerenVentaViewFrm.oculto='S';
		envia('zonSubGerenVentaViewFrm');
		zonSubGerenVentaViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonSubGerenVentaViewFrm.paisOidPais').toString() == ''){
		set('zonSubGerenVentaViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'zonSubGerenVentaView');
		
	}
	if(get('zonSubGerenVentaViewFrm.marcOidMarc').toString() == ''){
		set('zonSubGerenVentaViewFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'zonSubGerenVentaView');
		
	}
	if(get('zonSubGerenVentaViewFrm.canaOidCana').toString() == ''){
		set('zonSubGerenVentaViewFrm.canaOidCana', []);
		mmgResetCombosOnCascade('canaOidCana', 'canaOidCana', 'zonSubGerenVentaView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonSubGerenVentaViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonSubGerenVentaViewFrm.accion');
	var origenTmp = get('zonSubGerenVentaViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonSubGerenVentaViewBuildUpdateRecordString() != zonSubGerenVentaViewTmpUpdateValues){
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
	document.all.zonSubGerenVentaViewListLayer.style.display='none';
	document.all.zonSubGerenVentaViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonSubGerenVentaViewListLayer.style.display='';
	document.all.zonSubGerenVentaViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonSubGerenVentaViewPaisOidPais = get('zonSubGerenVentaViewFrm.paisOidPais')[0];
	jsZonSubGerenVentaViewCodSubgVent = get('zonSubGerenVentaViewFrm.codSubgVent').toString();
	jsZonSubGerenVentaViewIndBorr = get('zonSubGerenVentaViewFrm.indBorr').toString();
	jsZonSubGerenVentaViewIndActi = get('zonSubGerenVentaViewFrm.indActi').toString();
	jsZonSubGerenVentaViewCodNse1 = get('zonSubGerenVentaViewFrm.codNse1').toString();
	jsZonSubGerenVentaViewCodNse2 = get('zonSubGerenVentaViewFrm.codNse2').toString();
	jsZonSubGerenVentaViewCodNse3 = get('zonSubGerenVentaViewFrm.codNse3').toString();
	jsZonSubGerenVentaViewDesSubgVent = get('zonSubGerenVentaViewFrm.desSubgVent').toString();
	jsZonSubGerenVentaViewMarcOidMarc = get('zonSubGerenVentaViewFrm.marcOidMarc')[0];
	jsZonSubGerenVentaViewCanaOidCana = get('zonSubGerenVentaViewFrm.canaOidCana')[0];
	
	
	var parametros = "";
	parametros += jsZonSubGerenVentaViewPaisOidPais + "|";
	parametros += jsZonSubGerenVentaViewCodSubgVent + "|";
	parametros += jsZonSubGerenVentaViewIndBorr + "|";
	parametros += jsZonSubGerenVentaViewIndActi + "|";
	parametros += jsZonSubGerenVentaViewCodNse1 + "|";
	parametros += jsZonSubGerenVentaViewCodNse2 + "|";
	parametros += jsZonSubGerenVentaViewCodNse3 + "|";
	parametros += jsZonSubGerenVentaViewDesSubgVent + "|";
	parametros += jsZonSubGerenVentaViewMarcOidMarc + "|";
	parametros += jsZonSubGerenVentaViewCanaOidCana + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonSubGerenVentaViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonSubGerenVentaViewPaisOidPais + "|";
	parametros += jsZonSubGerenVentaViewCodSubgVent + "|";
	parametros += jsZonSubGerenVentaViewIndBorr + "|";
	parametros += jsZonSubGerenVentaViewIndActi + "|";
	parametros += jsZonSubGerenVentaViewCodNse1 + "|";
	parametros += jsZonSubGerenVentaViewCodNse2 + "|";
	parametros += jsZonSubGerenVentaViewCodNse3 + "|";
	parametros += jsZonSubGerenVentaViewDesSubgVent + "|";
	parametros += jsZonSubGerenVentaViewMarcOidMarc + "|";
	parametros += jsZonSubGerenVentaViewCanaOidCana + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonSubGerenVentaViewFrm.accion'), 
		get('zonSubGerenVentaViewFrm.origen'));
	
	jsZonSubGerenVentaViewId = get('zonSubGerenVentaViewFrm.id').toString();
	jsZonSubGerenVentaViewPaisOidPais = get('zonSubGerenVentaViewFrm.paisOidPais')[0];
	jsZonSubGerenVentaViewCodSubgVent = get('zonSubGerenVentaViewFrm.codSubgVent').toString();
	jsZonSubGerenVentaViewIndBorr = get('zonSubGerenVentaViewFrm.indBorr').toString();
	jsZonSubGerenVentaViewIndActi = get('zonSubGerenVentaViewFrm.indActi').toString();
	jsZonSubGerenVentaViewCodNse1 = get('zonSubGerenVentaViewFrm.codNse1').toString();
	jsZonSubGerenVentaViewCodNse2 = get('zonSubGerenVentaViewFrm.codNse2').toString();
	jsZonSubGerenVentaViewCodNse3 = get('zonSubGerenVentaViewFrm.codNse3').toString();
	jsZonSubGerenVentaViewDesSubgVent = get('zonSubGerenVentaViewFrm.desSubgVent').toString();
	jsZonSubGerenVentaViewMarcOidMarc = get('zonSubGerenVentaViewFrm.marcOidMarc')[0];
	jsZonSubGerenVentaViewCanaOidCana = get('zonSubGerenVentaViewFrm.canaOidCana')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonSubGerenVentaViewFrm.accion'), 
		get('zonSubGerenVentaViewFrm.origen'));


	set('zonSubGerenVentaViewFrm.id', jsZonSubGerenVentaViewId);
	set('zonSubGerenVentaViewFrm.paisOidPais', [jsZonSubGerenVentaViewPaisOidPais]);
	set('zonSubGerenVentaViewFrm.codSubgVent', jsZonSubGerenVentaViewCodSubgVent);
	set('zonSubGerenVentaViewFrm.indBorr', jsZonSubGerenVentaViewIndBorr);
	set('zonSubGerenVentaViewFrm.indActi', jsZonSubGerenVentaViewIndActi);
	set('zonSubGerenVentaViewFrm.codNse1', jsZonSubGerenVentaViewCodNse1);
	set('zonSubGerenVentaViewFrm.codNse2', jsZonSubGerenVentaViewCodNse2);
	set('zonSubGerenVentaViewFrm.codNse3', jsZonSubGerenVentaViewCodNse3);
	set('zonSubGerenVentaViewFrm.desSubgVent', jsZonSubGerenVentaViewDesSubgVent);
	set('zonSubGerenVentaViewFrm.marcOidMarc', [jsZonSubGerenVentaViewMarcOidMarc]);
	set('zonSubGerenVentaViewFrm.canaOidCana', [jsZonSubGerenVentaViewCanaOidCana]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsZonSubGerenVentaViewPaisOidPais = '';
	jsZonSubGerenVentaViewCodSubgVent = '';
	jsZonSubGerenVentaViewIndBorr = '';
	jsZonSubGerenVentaViewIndActi = '';
	jsZonSubGerenVentaViewCodNse1 = '';
	jsZonSubGerenVentaViewCodNse2 = '';
	jsZonSubGerenVentaViewCodNse3 = '';
	jsZonSubGerenVentaViewDesSubgVent = '';
	jsZonSubGerenVentaViewMarcOidMarc = '';
	jsZonSubGerenVentaViewCanaOidCana = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonSubGerenVentaViewFrm.errCodigo', errorCode);
	set('zonSubGerenVentaViewFrm.errDescripcion', description);
	set('zonSubGerenVentaViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
