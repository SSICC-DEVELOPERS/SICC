

/*
    INDRA/CAR/mmg
    $Id: calmotivtipoclien.js,v 1.1 2009/12/03 19:02:17 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCalMotivTipoClienId = "";
var jsCalMotivTipoClienMocoOidMotiCont = "";
var jsCalMotivTipoClienTiclOidTipoClie = "";
var jsCalMotivTipoClienPaisOidPais = "";

//Variables de paginacion, 
var calMotivTipoClienPageCount = 1;

//Varible de columna que representa el campo de choice
var calMotivTipoClienChoiceColumn = 2;

//Flag de siguiente pagina;
var calMotivTipoClienMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var calMotivTipoClienTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var calMotivTipoClienLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", false);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", false);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", false);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", true);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", true);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", true);'],[3,'focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", false);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", false);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", false);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", true);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", true);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", true);'],[4,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", false);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", false);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", false);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", true);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", true);','focalizaComboDependence("calMotivTipoClien","mocoOidMotiCont", true);'],[3,'focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", false);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", false);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", false);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", true);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", true);','focalizaComboDependence("calMotivTipoClien","ticlOidTipoClie", true);'],[4,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var mocoOidMotiContDependeceMap = new Vector();
mocoOidMotiContDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
mocoOidMotiContDependeceMap.agregar(['mocoOidMotiCont', padresTmp, '', 'CalMotivConta']);
var ticlOidTipoClieDependeceMap = new Vector();
ticlOidTipoClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ticlOidTipoClieDependeceMap.agregar(['ticlOidTipoClie', padresTmp, '', 'MaeTipoClien']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
calMotivTipoClienLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var calMotivTipoClienTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function calMotivTipoClienInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('calMotivTipoClienFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('calMotivTipoClienFrm.accion')){
		case "query": calMotivTipoClienQueryInitComponents(); break;
		case "view": calMotivTipoClienViewInitComponents(); break;
		case "create": calMotivTipoClienCreateInitComponents(); break;
		case "update": calMotivTipoClienUpdateInitComponents(); break;
		case "remove": calMotivTipoClienRemoveInitComponents(); break;
		case "lov": calMotivTipoClienLovInitComponents(); break;
	}
	//alert('accion :' + get('calMotivTipoClienFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('calMotivTipoClienFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('calMotivTipoClien')) calMotivTipoClienCmdRequery();
}

function calMotivTipoClienQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('calMotivTipoClienFrm', true);	
}

function calMotivTipoClienViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('calMotivTipoClienFrm', true);
}

function calMotivTipoClienCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('calMotivTipoClienFrm.mocoOidMotiCont','S', GestionarMensaje('CalMotivTipoClien.mocoOidMotiCont.requiered.message'));
	
	setMV('calMotivTipoClienFrm.ticlOidTipoClie','S', GestionarMensaje('CalMotivTipoClien.ticlOidTipoClie.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('calMotivTipoClienFrm', true);
}

function calMotivTipoClienUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('calMotivTipoClienFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		calMotivTipoClienTmpUpdateValues = calMotivTipoClienBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('calMotivTipoClienFrm.mocoOidMotiCont','S', GestionarMensaje('CalMotivTipoClien.mocoOidMotiCont.requiered.message'));
		setMV('calMotivTipoClienFrm.ticlOidTipoClie','S', GestionarMensaje('CalMotivTipoClien.ticlOidTipoClie.requiered.message'));
		
			focusFirstFieldModify('calMotivTipoClienFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('calMotivTipoClienFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('calMotivTipoClienFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function calMotivTipoClienRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	calMotivTipoClienList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('calMotivTipoClienFrm', true);
}

function calMotivTipoClienLovInitComponents(){
	calMotivTipoClienLovReturnParameters = window.dialogArguments;
	
	focusFirstField('calMotivTipoClienFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function calMotivTipoClienSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('calMotivTipoClienFrm.' + campo, id);
	set('calMotivTipoClienFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function calMotivTipoClienLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	calMotivTipoClienLovReturnParameters.id = '';
	calMotivTipoClienLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function calMotivTipoClienLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(calMotivTipoClienList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = calMotivTipoClienList.codSeleccionados();
	var descripcion = calMotivTipoClienList.extraeDato(
		calMotivTipoClienList.codSeleccionados()[0], calMotivTipoClienChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	calMotivTipoClienLovReturnParameters.id = codigo;
	calMotivTipoClienLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function calMotivTipoClienCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('calMotivTipoClienFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('calMotivTipoClienFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "calMotivTipoClienList", "CalMotivTipoClienConectorTransactionQuery", 
		"result_ROWSET", parametros, "calMotivTipoClienPostQueryActions(datos);"]], "", "");	
}

function calMotivTipoClienCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('calMotivTipoClienFrm.lastQueryToSession'));
	var i =0;
	set('calMotivTipoClienFrm.mocoOidMotiCont', [paramsRequery.ij(i++)]);
	
	set('calMotivTipoClienFrm.ticlOidTipoClie', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	calMotivTipoClienPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	calMotivTipoClienCmdQuery(calMotivTipoClienPageCount);
}

function calMotivTipoClienFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	calMotivTipoClienPageCount = 1;
	calMotivTipoClienCmdQuery(calMotivTipoClienPageCount);
}

function calMotivTipoClienPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != calMotivTipoClienLastQuery){
		calMotivTipoClienFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	calMotivTipoClienPageCount--;
	calMotivTipoClienCmdQuery(calMotivTipoClienPageCount);
}

function calMotivTipoClienNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != calMotivTipoClienLastQuery){
		calMotivTipoClienFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	calMotivTipoClienPageCount++;
	calMotivTipoClienCmdQuery(calMotivTipoClienPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function calMotivTipoClienPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('calMotivTipoClienListLayer', 'O');
		visibilidad('calMotivTipoClienListButtonsLayer', 'O');
		if(get('calMotivTipoClienFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	calMotivTipoClienLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:calMotivTipoClienViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, calMotivTipoClienChoiceColumn) + "</A>",
			i, calMotivTipoClienChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	calMotivTipoClienList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	calMotivTipoClienTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		calMotivTipoClienMorePagesFlag = true;
		calMotivTipoClienList.eliminar(mmgPageSize, 1);
	}else{
		calMotivTipoClienMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('calMotivTipoClienFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('calMotivTipoClienListLayer', 'V');
	visibilidad('calMotivTipoClienListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('calMotivTipoClienList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	calMotivTipoClienList.display();
	
	//Actualizamos el estado de los botones 
	if(calMotivTipoClienMorePagesFlag){
		set_estado_botonera('calMotivTipoClienPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('calMotivTipoClienPaginationButtonBar',
			3,"inactivo");
	}
	if(calMotivTipoClienPageCount > 1){
		set_estado_botonera('calMotivTipoClienPaginationButtonBar',
			2,"activo");
		set_estado_botonera('calMotivTipoClienPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('calMotivTipoClienPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('calMotivTipoClienPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function calMotivTipoClienUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(calMotivTipoClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('calMotivTipoClienFrm.idSelection', calMotivTipoClienList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('calMotivTipoClienFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = calMotivTipoClienList.codSeleccionados()[0];
		parametros["previousAction"] = get('calMotivTipoClienFrm.accion');
		parametros["accion"] = get('calMotivTipoClienFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CalMotivTipoClienLPStartUp', get('calMotivTipoClienFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) calMotivTipoClienCmdRequery();
	}
}

function calMotivTipoClienRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(calMotivTipoClienList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = calMotivTipoClienList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('calMotivTipoClienFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(calMotivTipoClienList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += calMotivTipoClienTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('calMotivTipoClienFrm.timestamp', timestamps);


	calMotivTipoClienFrm.oculto='S';
	envia('calMotivTipoClienFrm');
	calMotivTipoClienFrm.oculto='N';
}

function calMotivTipoClienViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(calMotivTipoClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	calMotivTipoClienViewDetail(calMotivTipoClienList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function calMotivTipoClienViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('calMotivTipoClienFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CalMotivTipoClienLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('calMotivTipoClienFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion){
		calMotivTipoClienFrm.oculto='S';
		envia('calMotivTipoClienFrm');
		calMotivTipoClienFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('calMotivTipoClienFrm.mocoOidMotiCont').toString() == ''){
		set('calMotivTipoClienFrm.mocoOidMotiCont', []);
		mmgResetCombosOnCascade('mocoOidMotiCont', 'mocoOidMotiCont', 'calMotivTipoClien');
		
	}
	if(get('calMotivTipoClienFrm.ticlOidTipoClie').toString() == ''){
		set('calMotivTipoClienFrm.ticlOidTipoClie', []);
		mmgResetCombosOnCascade('ticlOidTipoClie', 'ticlOidTipoClie', 'calMotivTipoClien');
		
	}
	if(get('calMotivTipoClienFrm.paisOidPais').toString() == ''){
		set('calMotivTipoClienFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'calMotivTipoClien');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	calMotivTipoClienRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('calMotivTipoClienFrm.accion');
	var origenTmp = get('calMotivTipoClienFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(calMotivTipoClienBuildUpdateRecordString() != calMotivTipoClienTmpUpdateValues){
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
	document.all.calMotivTipoClienListLayer.style.display='none';
	document.all.calMotivTipoClienListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.calMotivTipoClienListLayer.style.display='';
	document.all.calMotivTipoClienListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCalMotivTipoClienMocoOidMotiCont = get('calMotivTipoClienFrm.mocoOidMotiCont')[0];
	jsCalMotivTipoClienTiclOidTipoClie = get('calMotivTipoClienFrm.ticlOidTipoClie')[0];
	
	
	var parametros = "";
	parametros += jsCalMotivTipoClienMocoOidMotiCont + "|";
	parametros += jsCalMotivTipoClienTiclOidTipoClie + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function calMotivTipoClienBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCalMotivTipoClienMocoOidMotiCont + "|";
	parametros += jsCalMotivTipoClienTiclOidTipoClie + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('calMotivTipoClienFrm.accion'), 
		get('calMotivTipoClienFrm.origen'));
	
	jsCalMotivTipoClienId = get('calMotivTipoClienFrm.id').toString();
	jsCalMotivTipoClienMocoOidMotiCont = get('calMotivTipoClienFrm.mocoOidMotiCont')[0];
	jsCalMotivTipoClienTiclOidTipoClie = get('calMotivTipoClienFrm.ticlOidTipoClie')[0];
	jsCalMotivTipoClienPaisOidPais = get('calMotivTipoClienFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('calMotivTipoClienFrm.accion'), 
		get('calMotivTipoClienFrm.origen'));


	set('calMotivTipoClienFrm.id', jsCalMotivTipoClienId);
	set('calMotivTipoClienFrm.mocoOidMotiCont', [jsCalMotivTipoClienMocoOidMotiCont]);
	set('calMotivTipoClienFrm.ticlOidTipoClie', [jsCalMotivTipoClienTiclOidTipoClie]);
	set('calMotivTipoClienFrm.paisOidPais', [jsCalMotivTipoClienPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCalMotivTipoClienMocoOidMotiCont = '';
	jsCalMotivTipoClienTiclOidTipoClie = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('calMotivTipoClienFrm.errCodigo', errorCode);
	set('calMotivTipoClienFrm.errDescripcion', description);
	set('calMotivTipoClienFrm.errSeverity', severity);
	fMostrarMensajeError();
}
