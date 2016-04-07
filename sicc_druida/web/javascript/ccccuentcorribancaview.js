

/*
    INDRA/CAR/mmg
    $Id: ccccuentcorribancaview.js,v 1.1 2009/12/03 19:02:28 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCccCuentCorriBancaViewId = "";
var jsCccCuentCorriBancaViewSociOidSoci = "";
var jsCccCuentCorriBancaViewDesCc = "";
var jsCccCuentCorriBancaViewPaisOidPais = "";

//Variables de paginacion, 
var cccCuentCorriBancaViewPageCount = 1;

//Varible de columna que representa el campo de choice
var cccCuentCorriBancaViewChoiceColumn = 2;

//Flag de siguiente pagina;
var cccCuentCorriBancaViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cccCuentCorriBancaViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var cccCuentCorriBancaViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", true);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", true);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", true);'],[4,'focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");'],[15,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", true);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", true);','focalizaComboDependence("cccCuentCorriBancaView","sociOidSoci", true);'],[4,'focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");','focaliza("cccCuentCorriBancaViewFrm.desCc");'],[15,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var sociOidSociDependeceMap = new Vector();
sociOidSociDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sociOidSociDependeceMap.agregar(['sociOidSoci', padresTmp, '', 'SegSocie']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cccCuentCorriBancaViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cccCuentCorriBancaViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cccCuentCorriBancaViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cccCuentCorriBancaViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cccCuentCorriBancaViewFrm.accion')){
		case "query": cccCuentCorriBancaViewQueryInitComponents(); break;
		case "view": cccCuentCorriBancaViewViewInitComponents(); break;
		case "create": cccCuentCorriBancaViewCreateInitComponents(); break;
		case "update": cccCuentCorriBancaViewUpdateInitComponents(); break;
		case "remove": cccCuentCorriBancaViewRemoveInitComponents(); break;
		case "lov": cccCuentCorriBancaViewLovInitComponents(); break;
	}
	//alert('accion :' + get('cccCuentCorriBancaViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cccCuentCorriBancaViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cccCuentCorriBancaView')) cccCuentCorriBancaViewCmdRequery();
}

function cccCuentCorriBancaViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('cccCuentCorriBancaViewFrm', true);	
}

function cccCuentCorriBancaViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('cccCuentCorriBancaViewFrm', true);
}

function cccCuentCorriBancaViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cccCuentCorriBancaViewFrm.sociOidSoci','S', GestionarMensaje('CccCuentCorriBancaView.sociOidSoci.requiered.message'));
	
	setMV('cccCuentCorriBancaViewFrm.desCc','S', GestionarMensaje('CccCuentCorriBancaView.desCc.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cccCuentCorriBancaViewFrm', true);
}

function cccCuentCorriBancaViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cccCuentCorriBancaViewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		cccCuentCorriBancaViewTmpUpdateValues = cccCuentCorriBancaViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cccCuentCorriBancaViewFrm.sociOidSoci','S', GestionarMensaje('CccCuentCorriBancaView.sociOidSoci.requiered.message'));
		setMV('cccCuentCorriBancaViewFrm.desCc','S', GestionarMensaje('CccCuentCorriBancaView.desCc.requiered.message'));
		
			focusFirstFieldModify('cccCuentCorriBancaViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('cccCuentCorriBancaViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cccCuentCorriBancaViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cccCuentCorriBancaViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cccCuentCorriBancaViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cccCuentCorriBancaViewFrm', true);
}

function cccCuentCorriBancaViewLovInitComponents(){
	cccCuentCorriBancaViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cccCuentCorriBancaViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function cccCuentCorriBancaViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cccCuentCorriBancaViewFrm.' + campo, id);
	set('cccCuentCorriBancaViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cccCuentCorriBancaViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cccCuentCorriBancaViewLovReturnParameters.id = '';
	cccCuentCorriBancaViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cccCuentCorriBancaViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccCuentCorriBancaViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cccCuentCorriBancaViewList.codSeleccionados();
	var descripcion = cccCuentCorriBancaViewList.extraeDato(
		cccCuentCorriBancaViewList.codSeleccionados()[0], cccCuentCorriBancaViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cccCuentCorriBancaViewLovReturnParameters.id = codigo;
	cccCuentCorriBancaViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cccCuentCorriBancaViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cccCuentCorriBancaViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cccCuentCorriBancaViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cccCuentCorriBancaViewList", "CccCuentCorriBancaViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "cccCuentCorriBancaViewPostQueryActions(datos);"]], "", "");	
}

function cccCuentCorriBancaViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cccCuentCorriBancaViewFrm.lastQueryToSession'));
	var i =0;
	set('cccCuentCorriBancaViewFrm.sociOidSoci', [paramsRequery.ij(i++)]);
	
	set('cccCuentCorriBancaViewFrm.desCc', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	cccCuentCorriBancaViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cccCuentCorriBancaViewCmdQuery(cccCuentCorriBancaViewPageCount);
}

function cccCuentCorriBancaViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cccCuentCorriBancaViewPageCount = 1;
	cccCuentCorriBancaViewCmdQuery(cccCuentCorriBancaViewPageCount);
}

function cccCuentCorriBancaViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccCuentCorriBancaViewLastQuery){
		cccCuentCorriBancaViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cccCuentCorriBancaViewPageCount--;
	cccCuentCorriBancaViewCmdQuery(cccCuentCorriBancaViewPageCount);
}

function cccCuentCorriBancaViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccCuentCorriBancaViewLastQuery){
		cccCuentCorriBancaViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cccCuentCorriBancaViewPageCount++;
	cccCuentCorriBancaViewCmdQuery(cccCuentCorriBancaViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cccCuentCorriBancaViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cccCuentCorriBancaViewListLayer', 'O');
		visibilidad('cccCuentCorriBancaViewListButtonsLayer', 'O');
		if(get('cccCuentCorriBancaViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cccCuentCorriBancaViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cccCuentCorriBancaViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cccCuentCorriBancaViewChoiceColumn) + "</A>",
			i, cccCuentCorriBancaViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cccCuentCorriBancaViewList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cccCuentCorriBancaViewTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cccCuentCorriBancaViewMorePagesFlag = true;
		cccCuentCorriBancaViewList.eliminar(mmgPageSize, 1);
	}else{
		cccCuentCorriBancaViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cccCuentCorriBancaViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cccCuentCorriBancaViewListLayer', 'V');
	visibilidad('cccCuentCorriBancaViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cccCuentCorriBancaViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cccCuentCorriBancaViewList.display();
	
	//Actualizamos el estado de los botones 
	if(cccCuentCorriBancaViewMorePagesFlag){
		set_estado_botonera('cccCuentCorriBancaViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cccCuentCorriBancaViewPaginationButtonBar',
			3,"inactivo");
	}
	if(cccCuentCorriBancaViewPageCount > 1){
		set_estado_botonera('cccCuentCorriBancaViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cccCuentCorriBancaViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cccCuentCorriBancaViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cccCuentCorriBancaViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cccCuentCorriBancaViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccCuentCorriBancaViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cccCuentCorriBancaViewFrm.idSelection', cccCuentCorriBancaViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cccCuentCorriBancaViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cccCuentCorriBancaViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('cccCuentCorriBancaViewFrm.accion');
		parametros["accion"] = get('cccCuentCorriBancaViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CccCuentCorriBancaViewLPStartUp', get('cccCuentCorriBancaViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cccCuentCorriBancaViewCmdRequery();
	}
}

function cccCuentCorriBancaViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccCuentCorriBancaViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cccCuentCorriBancaViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cccCuentCorriBancaViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cccCuentCorriBancaViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cccCuentCorriBancaViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cccCuentCorriBancaViewFrm.timestamp', timestamps);


	cccCuentCorriBancaViewFrm.oculto='S';
	envia('cccCuentCorriBancaViewFrm');
	cccCuentCorriBancaViewFrm.oculto='N';
}

function cccCuentCorriBancaViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccCuentCorriBancaViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cccCuentCorriBancaViewViewDetail(cccCuentCorriBancaViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cccCuentCorriBancaViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cccCuentCorriBancaViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CccCuentCorriBancaViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cccCuentCorriBancaViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion){
		cccCuentCorriBancaViewFrm.oculto='S';
		envia('cccCuentCorriBancaViewFrm');
		cccCuentCorriBancaViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cccCuentCorriBancaViewFrm.sociOidSoci').toString() == ''){
		set('cccCuentCorriBancaViewFrm.sociOidSoci', []);
		mmgResetCombosOnCascade('sociOidSoci', 'sociOidSoci', 'cccCuentCorriBancaView');
		
	}
	if(get('cccCuentCorriBancaViewFrm.paisOidPais').toString() == ''){
		set('cccCuentCorriBancaViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cccCuentCorriBancaView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cccCuentCorriBancaViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cccCuentCorriBancaViewFrm.accion');
	var origenTmp = get('cccCuentCorriBancaViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cccCuentCorriBancaViewBuildUpdateRecordString() != cccCuentCorriBancaViewTmpUpdateValues){
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
	document.all.cccCuentCorriBancaViewListLayer.style.display='none';
	document.all.cccCuentCorriBancaViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cccCuentCorriBancaViewListLayer.style.display='';
	document.all.cccCuentCorriBancaViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCccCuentCorriBancaViewSociOidSoci = get('cccCuentCorriBancaViewFrm.sociOidSoci')[0];
	jsCccCuentCorriBancaViewDesCc = get('cccCuentCorriBancaViewFrm.desCc').toString();
	
	
	var parametros = "";
	parametros += jsCccCuentCorriBancaViewSociOidSoci + "|";
	parametros += jsCccCuentCorriBancaViewDesCc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cccCuentCorriBancaViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCccCuentCorriBancaViewSociOidSoci + "|";
	parametros += jsCccCuentCorriBancaViewDesCc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccCuentCorriBancaViewFrm.accion'), 
		get('cccCuentCorriBancaViewFrm.origen'));
	
	jsCccCuentCorriBancaViewId = get('cccCuentCorriBancaViewFrm.id').toString();
	jsCccCuentCorriBancaViewSociOidSoci = get('cccCuentCorriBancaViewFrm.sociOidSoci')[0];
	jsCccCuentCorriBancaViewDesCc = get('cccCuentCorriBancaViewFrm.desCc').toString();
	jsCccCuentCorriBancaViewPaisOidPais = get('cccCuentCorriBancaViewFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccCuentCorriBancaViewFrm.accion'), 
		get('cccCuentCorriBancaViewFrm.origen'));


	set('cccCuentCorriBancaViewFrm.id', jsCccCuentCorriBancaViewId);
	set('cccCuentCorriBancaViewFrm.sociOidSoci', [jsCccCuentCorriBancaViewSociOidSoci]);
	set('cccCuentCorriBancaViewFrm.desCc', jsCccCuentCorriBancaViewDesCc);
	set('cccCuentCorriBancaViewFrm.paisOidPais', [jsCccCuentCorriBancaViewPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCccCuentCorriBancaViewSociOidSoci = '';
	jsCccCuentCorriBancaViewDesCc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cccCuentCorriBancaViewFrm.errCodigo', errorCode);
	set('cccCuentCorriBancaViewFrm.errDescripcion', description);
	set('cccCuentCorriBancaViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
