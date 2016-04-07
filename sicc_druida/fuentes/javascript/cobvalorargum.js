

/*
    INDRA/CAR/mmg
    $Id: cobvalorargum.js,v 1.1 2009/12/03 19:01:44 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobValorArgumId = "";
var jsCobValorArgumValArgu = "";
var jsCobValorArgumValDescValoArgu = "";
var jsCobValorArgumValObse = "";
var jsCobValorArgumArguOidArgu = "";

//Variables de paginacion, 
var cobValorArgumPageCount = 1;

//Varible de columna que representa el campo de choice
var cobValorArgumChoiceColumn = 2;

//Flag de siguiente pagina;
var cobValorArgumMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobValorArgumTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 217;
var sizeFormUpdate = 217;

//Ultima busqueda realizada
var cobValorArgumLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");'],[3,'focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");'],[4,'','focaliza("cobValorArgumFrm.valObse");','focaliza("cobValorArgumFrm.valObse");','','focaliza("cobValorArgumFrm.valObse");','focaliza("cobValorArgumFrm.valObse");'],[5,'focalizaComboDependence("cobValorArgum","arguOidArgu", false);','focalizaComboDependence("cobValorArgum","arguOidArgu", false);','focalizaComboDependence("cobValorArgum","arguOidArgu", false);','focalizaComboDependence("cobValorArgum","arguOidArgu", true);','focalizaComboDependence("cobValorArgum","arguOidArgu", true);','focalizaComboDependence("cobValorArgum","arguOidArgu", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");','focaliza("cobValorArgumFrm.valArgu");'],[3,'focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");','focaliza("cobValorArgumFrm.valDescValoArgu");'],[4,'','focaliza("cobValorArgumFrm.valObse");','focaliza("cobValorArgumFrm.valObse");','','focaliza("cobValorArgumFrm.valObse");','focaliza("cobValorArgumFrm.valObse");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var arguOidArguDependeceMap = new Vector();
arguOidArguDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
arguOidArguDependeceMap.agregar(['arguOidArgu', padresTmp, '', 'CobArgum']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cobValorArgumLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cobValorArgumTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cobValorArgumInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cobValorArgumFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cobValorArgumFrm.accion')){
		case "query": cobValorArgumQueryInitComponents(); break;
		case "view": cobValorArgumViewInitComponents(); break;
		case "create": cobValorArgumCreateInitComponents(); break;
		case "update": cobValorArgumUpdateInitComponents(); break;
		case "remove": cobValorArgumRemoveInitComponents(); break;
		case "lov": cobValorArgumLovInitComponents(); break;
	}
	//alert('accion :' + get('cobValorArgumFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobValorArgumFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobValorArgum')) cobValorArgumCmdRequery();
}

function cobValorArgumQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('cobValorArgumFrm', true);	
}

function cobValorArgumViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('cobValorArgumFrm', true);
}

function cobValorArgumCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobValorArgumFrm.valArgu','S', GestionarMensaje('CobValorArgum.valArgu.requiered.message'));
	
	setMV('cobValorArgumFrm.valDescValoArgu','S', GestionarMensaje('CobValorArgum.valDescValoArgu.requiered.message'));
	
	setMV('cobValorArgumFrm.arguOidArgu','S', GestionarMensaje('CobValorArgum.arguOidArgu.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobValorArgumFrm', true);
}

function cobValorArgumUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cobValorArgumFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		cobValorArgumTmpUpdateValues = cobValorArgumBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobValorArgumFrm.valArgu','S', GestionarMensaje('CobValorArgum.valArgu.requiered.message'));
		setMV('cobValorArgumFrm.valDescValoArgu','S', GestionarMensaje('CobValorArgum.valDescValoArgu.requiered.message'));
		setMV('cobValorArgumFrm.arguOidArgu','S', GestionarMensaje('CobValorArgum.arguOidArgu.requiered.message'));
		
			focusFirstFieldModify('cobValorArgumFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('cobValorArgumFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cobValorArgumFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobValorArgumRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cobValorArgumList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobValorArgumFrm', true);
}

function cobValorArgumLovInitComponents(){
	cobValorArgumLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobValorArgumFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function cobValorArgumSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobValorArgumFrm.' + campo, id);
	set('cobValorArgumFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cobValorArgumLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobValorArgumLovReturnParameters.id = '';
	cobValorArgumLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobValorArgumLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobValorArgumList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobValorArgumList.codSeleccionados();
	var descripcion = cobValorArgumList.extraeDato(
		cobValorArgumList.codSeleccionados()[0], cobValorArgumChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobValorArgumLovReturnParameters.id = codigo;
	cobValorArgumLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cobValorArgumCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobValorArgumFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cobValorArgumFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobValorArgumList", "CobValorArgumConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobValorArgumPostQueryActions(datos);"]], "", "");	
}

function cobValorArgumCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobValorArgumFrm.lastQueryToSession'));
	var i =0;
	set('cobValorArgumFrm.valArgu', paramsRequery.ij(i++));
	
	set('cobValorArgumFrm.valDescValoArgu', paramsRequery.ij(i++));
	
	set('cobValorArgumFrm.arguOidArgu', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	cobValorArgumPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobValorArgumCmdQuery(cobValorArgumPageCount);
}

function cobValorArgumFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobValorArgumPageCount = 1;
	cobValorArgumCmdQuery(cobValorArgumPageCount);
}

function cobValorArgumPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobValorArgumLastQuery){
		cobValorArgumFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobValorArgumPageCount--;
	cobValorArgumCmdQuery(cobValorArgumPageCount);
}

function cobValorArgumNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobValorArgumLastQuery){
		cobValorArgumFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobValorArgumPageCount++;
	cobValorArgumCmdQuery(cobValorArgumPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobValorArgumPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobValorArgumListLayer', 'O');
		visibilidad('cobValorArgumListButtonsLayer', 'O');
		if(get('cobValorArgumFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cobValorArgumLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobValorArgumViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobValorArgumChoiceColumn) + "</A>",
			i, cobValorArgumChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobValorArgumList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cobValorArgumTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cobValorArgumMorePagesFlag = true;
		cobValorArgumList.eliminar(mmgPageSize, 1);
	}else{
		cobValorArgumMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cobValorArgumFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobValorArgumListLayer', 'V');
	visibilidad('cobValorArgumListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobValorArgumList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobValorArgumList.display();
	
	//Actualizamos el estado de los botones 
	if(cobValorArgumMorePagesFlag){
		set_estado_botonera('cobValorArgumPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobValorArgumPaginationButtonBar',
			3,"inactivo");
	}
	if(cobValorArgumPageCount > 1){
		set_estado_botonera('cobValorArgumPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobValorArgumPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobValorArgumPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobValorArgumPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobValorArgumUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobValorArgumList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobValorArgumFrm.idSelection', cobValorArgumList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cobValorArgumFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobValorArgumList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobValorArgumFrm.accion');
		parametros["accion"] = get('cobValorArgumFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobValorArgumLPStartUp', get('cobValorArgumFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobValorArgumCmdRequery();
	}
}

function cobValorArgumRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobValorArgumList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobValorArgumList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobValorArgumFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobValorArgumList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobValorArgumTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobValorArgumFrm.timestamp', timestamps);


	cobValorArgumFrm.oculto='S';
	envia('cobValorArgumFrm');
	cobValorArgumFrm.oculto='N';
}

function cobValorArgumViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobValorArgumList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobValorArgumViewDetail(cobValorArgumList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cobValorArgumViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobValorArgumFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobValorArgumLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobValorArgumFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		cobValorArgumFrm.oculto='S';
		envia('cobValorArgumFrm');
		cobValorArgumFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobValorArgumFrm.arguOidArgu').toString() == ''){
		set('cobValorArgumFrm.arguOidArgu', []);
		mmgResetCombosOnCascade('arguOidArgu', 'arguOidArgu', 'cobValorArgum');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cobValorArgumRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cobValorArgumFrm.accion');
	var origenTmp = get('cobValorArgumFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobValorArgumBuildUpdateRecordString() != cobValorArgumTmpUpdateValues){
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
	document.all.cobValorArgumListLayer.style.display='none';
	document.all.cobValorArgumListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobValorArgumListLayer.style.display='';
	document.all.cobValorArgumListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCobValorArgumValArgu = get('cobValorArgumFrm.valArgu').toString();
	jsCobValorArgumValDescValoArgu = get('cobValorArgumFrm.valDescValoArgu').toString();
	jsCobValorArgumArguOidArgu = get('cobValorArgumFrm.arguOidArgu')[0];
	
	
	var parametros = "";
	parametros += jsCobValorArgumValArgu + "|";
	parametros += jsCobValorArgumValDescValoArgu + "|";
	parametros += jsCobValorArgumArguOidArgu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobValorArgumBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobValorArgumValArgu + "|";
	parametros += jsCobValorArgumValDescValoArgu + "|";
	parametros += jsCobValorArgumValObse + "|";
	parametros += jsCobValorArgumArguOidArgu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobValorArgumFrm.accion'), 
		get('cobValorArgumFrm.origen'));
	
	jsCobValorArgumId = get('cobValorArgumFrm.id').toString();
	jsCobValorArgumValArgu = get('cobValorArgumFrm.valArgu').toString();
	jsCobValorArgumValDescValoArgu = get('cobValorArgumFrm.valDescValoArgu').toString();
	jsCobValorArgumValObse = get('cobValorArgumFrm.valObse').toString();
	jsCobValorArgumArguOidArgu = get('cobValorArgumFrm.arguOidArgu')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobValorArgumFrm.accion'), 
		get('cobValorArgumFrm.origen'));


	set('cobValorArgumFrm.id', jsCobValorArgumId);
	set('cobValorArgumFrm.valArgu', jsCobValorArgumValArgu);
	set('cobValorArgumFrm.valDescValoArgu', jsCobValorArgumValDescValoArgu);
	set('cobValorArgumFrm.valObse', jsCobValorArgumValObse);
	set('cobValorArgumFrm.arguOidArgu', [jsCobValorArgumArguOidArgu]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCobValorArgumValArgu = '';
	jsCobValorArgumValDescValoArgu = '';
	jsCobValorArgumArguOidArgu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobValorArgumFrm.errCodigo', errorCode);
	set('cobValorArgumFrm.errDescripcion', description);
	set('cobValorArgumFrm.errSeverity', severity);
	fMostrarMensajeError();
}
