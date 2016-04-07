

/*
    INDRA/CAR/mmg
    $Id: pedprogr.js,v 1.1 2009/12/03 19:01:48 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedProgrId = "";
var jsPedProgrValNomb = "";
var jsPedProgrValClasEjec = "";

//Variables de paginacion, 
var pedProgrPageCount = 1;

//Varible de columna que representa el campo de choice
var pedProgrChoiceColumn = 0;

//Flag de siguiente pagina;
var pedProgrMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedProgrTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 121;
var sizeFormUpdate = 121;

//Ultima busqueda realizada
var pedProgrLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");','focaliza("pedProgrFrm.valClasEjec");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedProgrLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedProgrTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedProgrInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedProgrFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedProgrFrm.accion')){
		case "query": pedProgrQueryInitComponents(); break;
		case "view": pedProgrViewInitComponents(); break;
		case "create": pedProgrCreateInitComponents(); break;
		case "update": pedProgrUpdateInitComponents(); break;
		case "remove": pedProgrRemoveInitComponents(); break;
		case "lov": pedProgrLovInitComponents(); break;
	}
	//alert('accion :' + get('pedProgrFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedProgrFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedProgr')) pedProgrCmdRequery();
}

function pedProgrQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('pedProgrFrm', true);	
}

function pedProgrViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('pedProgrFrm', true);
}

function pedProgrCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedProgrFrm', true);
}

function pedProgrUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedProgrFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		pedProgrTmpUpdateValues = pedProgrBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		
			focusFirstFieldModify('pedProgrFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('pedProgrFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedProgrFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedProgrRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedProgrList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedProgrFrm', true);
}

function pedProgrLovInitComponents(){
	pedProgrLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedProgrFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function pedProgrSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedProgrFrm.' + campo, id);
	set('pedProgrFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedProgrLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedProgrLovReturnParameters.id = '';
	pedProgrLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedProgrLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedProgrList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedProgrList.codSeleccionados();
	var descripcion = pedProgrList.extraeDato(
		pedProgrList.codSeleccionados()[0], pedProgrChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedProgrLovReturnParameters.id = codigo;
	pedProgrLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedProgrCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedProgrFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedProgrFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedProgrList", "PedProgrConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedProgrPostQueryActions(datos);"]], "", "");	
}

function pedProgrCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedProgrFrm.lastQueryToSession'));
	var i =0;
	set('pedProgrFrm.valNomb', paramsRequery.ij(i++));
	
	set('pedProgrFrm.valClasEjec', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	pedProgrPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedProgrCmdQuery(pedProgrPageCount);
}

function pedProgrFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedProgrPageCount = 1;
	pedProgrCmdQuery(pedProgrPageCount);
}

function pedProgrPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedProgrLastQuery){
		pedProgrFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedProgrPageCount--;
	pedProgrCmdQuery(pedProgrPageCount);
}

function pedProgrNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedProgrLastQuery){
		pedProgrFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedProgrPageCount++;
	pedProgrCmdQuery(pedProgrPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedProgrPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedProgrListLayer', 'O');
		visibilidad('pedProgrListButtonsLayer', 'O');
		if(get('pedProgrFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedProgrLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedProgrViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedProgrChoiceColumn) + "</A>",
			i, pedProgrChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedProgrList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedProgrTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedProgrMorePagesFlag = true;
		pedProgrList.eliminar(mmgPageSize, 1);
	}else{
		pedProgrMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedProgrFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedProgrListLayer', 'V');
	visibilidad('pedProgrListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedProgrList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedProgrList.display();
	
	//Actualizamos el estado de los botones 
	if(pedProgrMorePagesFlag){
		set_estado_botonera('pedProgrPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedProgrPaginationButtonBar',
			3,"inactivo");
	}
	if(pedProgrPageCount > 1){
		set_estado_botonera('pedProgrPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedProgrPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedProgrPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedProgrPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedProgrUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedProgrList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedProgrFrm.idSelection', pedProgrList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedProgrFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedProgrList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedProgrFrm.accion');
		parametros["accion"] = get('pedProgrFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedProgrLPStartUp', get('pedProgrFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedProgrCmdRequery();
	}
}

function pedProgrRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedProgrList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedProgrList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedProgrFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedProgrList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedProgrTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedProgrFrm.timestamp', timestamps);


	pedProgrFrm.oculto='S';
	envia('pedProgrFrm');
	pedProgrFrm.oculto='N';
}

function pedProgrViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedProgrList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedProgrViewDetail(pedProgrList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedProgrViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedProgrFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedProgrLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('pedProgrFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
		
	
	if(validacion){
		pedProgrFrm.oculto='S';
		envia('pedProgrFrm');
		pedProgrFrm.oculto='N';
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
	pedProgrRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedProgrFrm.accion');
	var origenTmp = get('pedProgrFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedProgrBuildUpdateRecordString() != pedProgrTmpUpdateValues){
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
	document.all.pedProgrListLayer.style.display='none';
	document.all.pedProgrListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedProgrListLayer.style.display='';
	document.all.pedProgrListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedProgrValNomb = get('pedProgrFrm.valNomb').toString();
	jsPedProgrValClasEjec = get('pedProgrFrm.valClasEjec').toString();
	
	
	var parametros = "";
	parametros += jsPedProgrValNomb + "|";
	parametros += jsPedProgrValClasEjec + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedProgrBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedProgrValNomb + "|";
	parametros += jsPedProgrValClasEjec + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedProgrFrm.accion'), 
		get('pedProgrFrm.origen'));
	
	jsPedProgrId = get('pedProgrFrm.id').toString();
	jsPedProgrValNomb = get('pedProgrFrm.valNomb').toString();
	jsPedProgrValClasEjec = get('pedProgrFrm.valClasEjec').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedProgrFrm.accion'), 
		get('pedProgrFrm.origen'));


	set('pedProgrFrm.id', jsPedProgrId);
	set('pedProgrFrm.valNomb', jsPedProgrValNomb);
	set('pedProgrFrm.valClasEjec', jsPedProgrValClasEjec);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedProgrValNomb = '';
	jsPedProgrValClasEjec = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedProgrFrm.errCodigo', errorCode);
	set('pedProgrFrm.errDescripcion', description);
	set('pedProgrFrm.errSeverity', severity);
	fMostrarMensajeError();
}
