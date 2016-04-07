

/*
    INDRA/CAR/mmg
    $Id: precatalorden.js,v 1.1 2009/12/03 19:01:46 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPreCatalOrdenId = "";
var jsPreCatalOrdenMarcOidMarc = "";
var jsPreCatalOrdenCanaOidCana = "";
var jsPreCatalOrdenOcatOidCata = "";
var jsPreCatalOrdenNumOrde = "";

//Variables de paginacion, 
var preCatalOrdenPageCount = 1;

//Varible de columna que representa el campo de choice
var preCatalOrdenChoiceColumn = 4;

//Flag de siguiente pagina;
var preCatalOrdenMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var preCatalOrdenTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var preCatalOrdenLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("preCatalOrden","marcOidMarc", false);','focalizaComboDependence("preCatalOrden","marcOidMarc", false);','focalizaComboDependence("preCatalOrden","marcOidMarc", false);','focalizaComboDependence("preCatalOrden","marcOidMarc", true);','focalizaComboDependence("preCatalOrden","marcOidMarc", true);','focalizaComboDependence("preCatalOrden","marcOidMarc", true);'],[3,'focalizaComboDependence("preCatalOrden","canaOidCana", false);','focalizaComboDependence("preCatalOrden","canaOidCana", false);','focalizaComboDependence("preCatalOrden","canaOidCana", false);','focalizaComboDependence("preCatalOrden","canaOidCana", true);','focalizaComboDependence("preCatalOrden","canaOidCana", true);','focalizaComboDependence("preCatalOrden","canaOidCana", true);'],[4,'focalizaComboDependence("preCatalOrden","ocatOidCata", false);','focalizaComboDependence("preCatalOrden","ocatOidCata", false);','focalizaComboDependence("preCatalOrden","ocatOidCata", false);','focalizaComboDependence("preCatalOrden","ocatOidCata", true);','focalizaComboDependence("preCatalOrden","ocatOidCata", true);','focalizaComboDependence("preCatalOrden","ocatOidCata", true);'],[5,'','focaliza("preCatalOrdenFrm.numOrde");','focaliza("preCatalOrdenFrm.numOrde");','','focaliza("preCatalOrdenFrm.numOrde");','focaliza("preCatalOrdenFrm.numOrde");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[5,'','focaliza("preCatalOrdenFrm.numOrde");','focaliza("preCatalOrdenFrm.numOrde");','','focaliza("preCatalOrdenFrm.numOrde");','focaliza("preCatalOrdenFrm.numOrde");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
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
var ocatOidCataDependeceMap = new Vector();
ocatOidCataDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ocatOidCataDependeceMap.agregar(['ocatOidCata', padresTmp, '', 'PreCatal']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
preCatalOrdenLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var preCatalOrdenTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function preCatalOrdenInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('preCatalOrdenFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('preCatalOrdenFrm.accion')){
		case "query": preCatalOrdenQueryInitComponents(); break;
		case "view": preCatalOrdenViewInitComponents(); break;
		case "create": preCatalOrdenCreateInitComponents(); break;
		case "update": preCatalOrdenUpdateInitComponents(); break;
		case "remove": preCatalOrdenRemoveInitComponents(); break;
		case "lov": preCatalOrdenLovInitComponents(); break;
	}
	//alert('accion :' + get('preCatalOrdenFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('preCatalOrdenFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('preCatalOrden')) preCatalOrdenCmdRequery();
}

function preCatalOrdenQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('preCatalOrdenFrm', true);	
}

function preCatalOrdenViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('preCatalOrdenFrm', true);
}

function preCatalOrdenCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('preCatalOrdenFrm.marcOidMarc','S', GestionarMensaje('PreCatalOrden.marcOidMarc.requiered.message'));
	
	setMV('preCatalOrdenFrm.canaOidCana','S', GestionarMensaje('PreCatalOrden.canaOidCana.requiered.message'));
	
	setMV('preCatalOrdenFrm.ocatOidCata','S', GestionarMensaje('PreCatalOrden.ocatOidCata.requiered.message'));
	
	setMV('preCatalOrdenFrm.numOrde','S', GestionarMensaje('PreCatalOrden.numOrde.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('preCatalOrdenFrm', true);
}

function preCatalOrdenUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('preCatalOrdenFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		preCatalOrdenTmpUpdateValues = preCatalOrdenBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('preCatalOrdenFrm.marcOidMarc','S', GestionarMensaje('PreCatalOrden.marcOidMarc.requiered.message'));
		setMV('preCatalOrdenFrm.canaOidCana','S', GestionarMensaje('PreCatalOrden.canaOidCana.requiered.message'));
		setMV('preCatalOrdenFrm.ocatOidCata','S', GestionarMensaje('PreCatalOrden.ocatOidCata.requiered.message'));
		setMV('preCatalOrdenFrm.numOrde','S', GestionarMensaje('PreCatalOrden.numOrde.requiered.message'));
		
			focusFirstFieldModify('preCatalOrdenFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('preCatalOrdenFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('preCatalOrdenFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function preCatalOrdenRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	preCatalOrdenList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('preCatalOrdenFrm', true);
}

function preCatalOrdenLovInitComponents(){
	preCatalOrdenLovReturnParameters = window.dialogArguments;
	
	focusFirstField('preCatalOrdenFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function preCatalOrdenSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('preCatalOrdenFrm.' + campo, id);
	set('preCatalOrdenFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function preCatalOrdenLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	preCatalOrdenLovReturnParameters.id = '';
	preCatalOrdenLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function preCatalOrdenLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preCatalOrdenList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = preCatalOrdenList.codSeleccionados();
	var descripcion = preCatalOrdenList.extraeDato(
		preCatalOrdenList.codSeleccionados()[0], preCatalOrdenChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	preCatalOrdenLovReturnParameters.id = codigo;
	preCatalOrdenLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function preCatalOrdenCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('preCatalOrdenFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('preCatalOrdenFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "preCatalOrdenList", "PreCatalOrdenConectorTransactionQuery", 
		"result_ROWSET", parametros, "preCatalOrdenPostQueryActions(datos);"]], "", "");	
}

function preCatalOrdenCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('preCatalOrdenFrm.lastQueryToSession'));
	var i =0;
	set('preCatalOrdenFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('preCatalOrdenFrm.canaOidCana', [paramsRequery.ij(i++)]);
	
	set('preCatalOrdenFrm.ocatOidCata', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	preCatalOrdenPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	preCatalOrdenCmdQuery(preCatalOrdenPageCount);
}

function preCatalOrdenFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	preCatalOrdenPageCount = 1;
	preCatalOrdenCmdQuery(preCatalOrdenPageCount);
}

function preCatalOrdenPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preCatalOrdenLastQuery){
		preCatalOrdenFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	preCatalOrdenPageCount--;
	preCatalOrdenCmdQuery(preCatalOrdenPageCount);
}

function preCatalOrdenNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preCatalOrdenLastQuery){
		preCatalOrdenFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	preCatalOrdenPageCount++;
	preCatalOrdenCmdQuery(preCatalOrdenPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function preCatalOrdenPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('preCatalOrdenListLayer', 'O');
		visibilidad('preCatalOrdenListButtonsLayer', 'O');
		if(get('preCatalOrdenFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	preCatalOrdenLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:preCatalOrdenViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, preCatalOrdenChoiceColumn) + "</A>",
			i, preCatalOrdenChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	preCatalOrdenList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	preCatalOrdenTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		preCatalOrdenMorePagesFlag = true;
		preCatalOrdenList.eliminar(mmgPageSize, 1);
	}else{
		preCatalOrdenMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('preCatalOrdenFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('preCatalOrdenListLayer', 'V');
	visibilidad('preCatalOrdenListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('preCatalOrdenList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	preCatalOrdenList.display();
	
	//Actualizamos el estado de los botones 
	if(preCatalOrdenMorePagesFlag){
		set_estado_botonera('preCatalOrdenPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('preCatalOrdenPaginationButtonBar',
			3,"inactivo");
	}
	if(preCatalOrdenPageCount > 1){
		set_estado_botonera('preCatalOrdenPaginationButtonBar',
			2,"activo");
		set_estado_botonera('preCatalOrdenPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('preCatalOrdenPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('preCatalOrdenPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function preCatalOrdenUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preCatalOrdenList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('preCatalOrdenFrm.idSelection', preCatalOrdenList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('preCatalOrdenFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = preCatalOrdenList.codSeleccionados()[0];
		parametros["previousAction"] = get('preCatalOrdenFrm.accion');
		parametros["accion"] = get('preCatalOrdenFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PreCatalOrdenLPStartUp', get('preCatalOrdenFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) preCatalOrdenCmdRequery();
	}
}

function preCatalOrdenRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preCatalOrdenList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = preCatalOrdenList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('preCatalOrdenFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(preCatalOrdenList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += preCatalOrdenTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('preCatalOrdenFrm.timestamp', timestamps);


	preCatalOrdenFrm.oculto='S';
	envia('preCatalOrdenFrm');
	preCatalOrdenFrm.oculto='N';
}

function preCatalOrdenViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preCatalOrdenList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	preCatalOrdenViewDetail(preCatalOrdenList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function preCatalOrdenViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('preCatalOrdenFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PreCatalOrdenLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('preCatalOrdenFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		preCatalOrdenFrm.oculto='S';
		envia('preCatalOrdenFrm');
		preCatalOrdenFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('preCatalOrdenFrm.marcOidMarc').toString() == ''){
		set('preCatalOrdenFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'preCatalOrden');
		
	}
	if(get('preCatalOrdenFrm.canaOidCana').toString() == ''){
		set('preCatalOrdenFrm.canaOidCana', []);
		mmgResetCombosOnCascade('canaOidCana', 'canaOidCana', 'preCatalOrden');
		
	}
	if(get('preCatalOrdenFrm.ocatOidCata').toString() == ''){
		set('preCatalOrdenFrm.ocatOidCata', []);
		mmgResetCombosOnCascade('ocatOidCata', 'ocatOidCata', 'preCatalOrden');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	preCatalOrdenRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('preCatalOrdenFrm.accion');
	var origenTmp = get('preCatalOrdenFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(preCatalOrdenBuildUpdateRecordString() != preCatalOrdenTmpUpdateValues){
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
	document.all.preCatalOrdenListLayer.style.display='none';
	document.all.preCatalOrdenListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.preCatalOrdenListLayer.style.display='';
	document.all.preCatalOrdenListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPreCatalOrdenMarcOidMarc = get('preCatalOrdenFrm.marcOidMarc')[0];
	jsPreCatalOrdenCanaOidCana = get('preCatalOrdenFrm.canaOidCana')[0];
	jsPreCatalOrdenOcatOidCata = get('preCatalOrdenFrm.ocatOidCata')[0];
	
	
	var parametros = "";
	parametros += jsPreCatalOrdenMarcOidMarc + "|";
	parametros += jsPreCatalOrdenCanaOidCana + "|";
	parametros += jsPreCatalOrdenOcatOidCata + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function preCatalOrdenBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPreCatalOrdenMarcOidMarc + "|";
	parametros += jsPreCatalOrdenCanaOidCana + "|";
	parametros += jsPreCatalOrdenOcatOidCata + "|";
	parametros += jsPreCatalOrdenNumOrde + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preCatalOrdenFrm.accion'), 
		get('preCatalOrdenFrm.origen'));
	
	jsPreCatalOrdenId = get('preCatalOrdenFrm.id').toString();
	jsPreCatalOrdenMarcOidMarc = get('preCatalOrdenFrm.marcOidMarc')[0];
	jsPreCatalOrdenCanaOidCana = get('preCatalOrdenFrm.canaOidCana')[0];
	jsPreCatalOrdenOcatOidCata = get('preCatalOrdenFrm.ocatOidCata')[0];
	jsPreCatalOrdenNumOrde = get('preCatalOrdenFrm.numOrde').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preCatalOrdenFrm.accion'), 
		get('preCatalOrdenFrm.origen'));


	set('preCatalOrdenFrm.id', jsPreCatalOrdenId);
	set('preCatalOrdenFrm.marcOidMarc', [jsPreCatalOrdenMarcOidMarc]);
	set('preCatalOrdenFrm.canaOidCana', [jsPreCatalOrdenCanaOidCana]);
	set('preCatalOrdenFrm.ocatOidCata', [jsPreCatalOrdenOcatOidCata]);
	set('preCatalOrdenFrm.numOrde', jsPreCatalOrdenNumOrde);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPreCatalOrdenMarcOidMarc = '';
	jsPreCatalOrdenCanaOidCana = '';
	jsPreCatalOrdenOcatOidCata = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('preCatalOrdenFrm.errCodigo', errorCode);
	set('preCatalOrdenFrm.errDescripcion', description);
	set('preCatalOrdenFrm.errSeverity', severity);
	fMostrarMensajeError();
}
