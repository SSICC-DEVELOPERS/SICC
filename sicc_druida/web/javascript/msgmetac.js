

/*
    INDRA/CAR/mmg
    $Id: msgmetac.js,v 1.1 2009/12/03 19:01:35 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMsgMetacId = "";
var jsMsgMetacCodMeta = "";
var jsMsgMetacDescripcion = "";
var jsMsgMetacTimeOidTipo = "";
var jsMsgMetacValEsta = "";
var jsMsgMetacValLiteIden = "";

//Variables de paginacion, 
var msgMetacPageCount = 1;

//Varible de columna que representa el campo de choice
var msgMetacChoiceColumn = 1;

//Flag de siguiente pagina;
var msgMetacMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var msgMetacTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 171;
var sizeFormView = 149;
var sizeFormUpdate = 149;

//Ultima busqueda realizada
var msgMetacLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");'],[3,'focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");'],[4,'focalizaComboDependence("msgMetac","timeOidTipo", false);','focalizaComboDependence("msgMetac","timeOidTipo", false);','focalizaComboDependence("msgMetac","timeOidTipo", false);','focalizaComboDependence("msgMetac","timeOidTipo", true);','focalizaComboDependence("msgMetac","timeOidTipo", true);','focalizaComboDependence("msgMetac","timeOidTipo", true);'],[5,'focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");'],[6,'focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");','focaliza("msgMetacFrm.codMeta");'],[3,'focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");','focaliza("msgMetacFrm.Descripcion");'],[4,'focalizaComboDependence("msgMetac","timeOidTipo", false);','focalizaComboDependence("msgMetac","timeOidTipo", false);','focalizaComboDependence("msgMetac","timeOidTipo", false);','focalizaComboDependence("msgMetac","timeOidTipo", true);','focalizaComboDependence("msgMetac","timeOidTipo", true);','focalizaComboDependence("msgMetac","timeOidTipo", true);'],[5,'focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");','focaliza("msgMetacFrm.valEsta");'],[6,'focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");','focaliza("msgMetacFrm.valLiteIden");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var timeOidTipoDependeceMap = new Vector();
timeOidTipoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
timeOidTipoDependeceMap.agregar(['timeOidTipo', padresTmp, '', 'MsgTipoMetac']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
msgMetacLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var msgMetacTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function msgMetacInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('msgMetacFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('msgMetacFrm.accion')){
		case "query": msgMetacQueryInitComponents(); break;
		case "view": msgMetacViewInitComponents(); break;
		case "create": msgMetacCreateInitComponents(); break;
		case "update": msgMetacUpdateInitComponents(); break;
		case "remove": msgMetacRemoveInitComponents(); break;
		case "lov": msgMetacLovInitComponents(); break;
	}
	//alert('accion :' + get('msgMetacFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('msgMetacFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('msgMetac')) msgMetacCmdRequery();
}

function msgMetacQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	focusFirstField('msgMetacFrm', true);	
}

function msgMetacViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('msgMetacFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('msgMetacFrm.valEsta', get('msgMetacFrm.valEstaCheckValue'));
		
	focusFirstField('msgMetacFrm', true);
}

function msgMetacCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('msgMetacFrm.codMeta','S', GestionarMensaje('MsgMetac.codMeta.requiered.message'));
	
	setMV('msgMetacFrm.Descripcion','S', GestionarMensaje('MsgMetac.Descripcion.requiered.message'));
	
	setMV('msgMetacFrm.timeOidTipo','S', GestionarMensaje('MsgMetac.timeOidTipo.requiered.message'));
	
	setMV('msgMetacFrm.valEsta','S', GestionarMensaje('MsgMetac.valEsta.requiered.message'));
	
	setMV('msgMetacFrm.valLiteIden','S', GestionarMensaje('MsgMetac.valLiteIden.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('msgMetacFrm', true);
}

function msgMetacUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('msgMetacFrm.origen') == "pagina"){
		loadLocalizationWidget('msgMetacFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('msgMetacFrm.valEsta', get('msgMetacFrm.valEstaCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		msgMetacTmpUpdateValues = msgMetacBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('msgMetacFrm.codMeta','S', GestionarMensaje('MsgMetac.codMeta.requiered.message'));
		setMV('msgMetacFrm.Descripcion','S', GestionarMensaje('MsgMetac.Descripcion.requiered.message'));
		setMV('msgMetacFrm.timeOidTipo','S', GestionarMensaje('MsgMetac.timeOidTipo.requiered.message'));
		setMV('msgMetacFrm.valEsta','S', GestionarMensaje('MsgMetac.valEsta.requiered.message'));
		setMV('msgMetacFrm.valLiteIden','S', GestionarMensaje('MsgMetac.valLiteIden.requiered.message'));
		
			focusFirstFieldModify('msgMetacFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		focusFirstField('msgMetacFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('msgMetacFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function msgMetacRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	msgMetacList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('msgMetacFrm', true);
}

function msgMetacLovInitComponents(){
	msgMetacLovReturnParameters = window.dialogArguments;
	
	focusFirstField('msgMetacFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function msgMetacSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('msgMetacFrm.' + campo, id);
	set('msgMetacFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function msgMetacLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	msgMetacLovReturnParameters.id = '';
	msgMetacLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function msgMetacLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(msgMetacList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = msgMetacList.codSeleccionados();
	var descripcion = msgMetacList.extraeDato(
		msgMetacList.codSeleccionados()[0], msgMetacChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	msgMetacLovReturnParameters.id = codigo;
	msgMetacLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function msgMetacCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('msgMetacFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('msgMetacFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "msgMetacList", "MsgMetacConectorTransactionQuery", 
		"result_ROWSET", parametros, "msgMetacPostQueryActions(datos);"]], "", "");	
}

function msgMetacCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('msgMetacFrm.lastQueryToSession'));
	var i =0;
	set('msgMetacFrm.codMeta', paramsRequery.ij(i++));
	
	set('msgMetacFrm.Descripcion', paramsRequery.ij(i++));
	
	set('msgMetacFrm.timeOidTipo', [paramsRequery.ij(i++)]);
	
	set('msgMetacFrm.valEsta', paramsRequery.ij(i++));
	
	set('msgMetacFrm.valLiteIden', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	msgMetacPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	msgMetacCmdQuery(msgMetacPageCount);
}

function msgMetacFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	msgMetacPageCount = 1;
	msgMetacCmdQuery(msgMetacPageCount);
}

function msgMetacPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != msgMetacLastQuery){
		msgMetacFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	msgMetacPageCount--;
	msgMetacCmdQuery(msgMetacPageCount);
}

function msgMetacNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != msgMetacLastQuery){
		msgMetacFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	msgMetacPageCount++;
	msgMetacCmdQuery(msgMetacPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function msgMetacPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('msgMetacListLayer', 'O');
		visibilidad('msgMetacListButtonsLayer', 'O');
		if(get('msgMetacFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	msgMetacLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case 'A': datosTmp.ij2(GestionarMensaje('MsgMetac.valEsta.A.value'), i, 4); break;
			case 'D': datosTmp.ij2(GestionarMensaje('MsgMetac.valEsta.D.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:msgMetacViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, msgMetacChoiceColumn) + "</A>",
			i, msgMetacChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	msgMetacList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	msgMetacTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		msgMetacMorePagesFlag = true;
		msgMetacList.eliminar(mmgPageSize, 1);
	}else{
		msgMetacMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('msgMetacFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('msgMetacListLayer', 'V');
	visibilidad('msgMetacListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('msgMetacList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	msgMetacList.display();
	
	//Actualizamos el estado de los botones 
	if(msgMetacMorePagesFlag){
		set_estado_botonera('msgMetacPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('msgMetacPaginationButtonBar',
			3,"inactivo");
	}
	if(msgMetacPageCount > 1){
		set_estado_botonera('msgMetacPaginationButtonBar',
			2,"activo");
		set_estado_botonera('msgMetacPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('msgMetacPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('msgMetacPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function msgMetacUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(msgMetacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('msgMetacFrm.idSelection', msgMetacList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('msgMetacFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = msgMetacList.codSeleccionados()[0];
		parametros["previousAction"] = get('msgMetacFrm.accion');
		parametros["accion"] = get('msgMetacFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MsgMetacLPStartUp', get('msgMetacFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) msgMetacCmdRequery();
	}
}

function msgMetacRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(msgMetacList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = msgMetacList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('msgMetacFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(msgMetacList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += msgMetacTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('msgMetacFrm.timestamp', timestamps);


	msgMetacFrm.oculto='S';
	envia('msgMetacFrm');
	msgMetacFrm.oculto='N';
}

function msgMetacViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(msgMetacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	msgMetacViewDetail(msgMetacList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function msgMetacViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('msgMetacFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MsgMetacLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	// splatas - DBLG500000796 - 10/07/2006
	var litIdentificador = get('msgMetacFrm.valLiteIden');	
	set('msgMetacFrm.valLiteIden', litIdentificador);
	
	setDefaultLanguageValue('msgMetacFrm', 
		'Descripcion', 1,
		get('msgMetacFrm.Descripcion'));	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('msgMetacFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('msgMetacFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MsgMetac.Descripcion.requiered.message'));
		focaliza('msgMetacFrm.Descripcion');
		return;
	}	
	
	
	
	
		
	
	if(validacion){
		msgMetacFrm.oculto='S';
		envia('msgMetacFrm');
		msgMetacFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('msgMetacFrm.timeOidTipo').toString() == ''){
		set('msgMetacFrm.timeOidTipo', []);
		mmgResetCombosOnCascade('timeOidTipo', 'timeOidTipo', 'msgMetac');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	msgMetacRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('msgMetacFrm.accion');
	var origenTmp = get('msgMetacFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(msgMetacBuildUpdateRecordString() != msgMetacTmpUpdateValues){
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
	document.all.msgMetacListLayer.style.display='none';
	document.all.msgMetacListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.msgMetacListLayer.style.display='';
	document.all.msgMetacListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMsgMetacCodMeta = get('msgMetacFrm.codMeta').toString();
	jsMsgMetacDescripcion = get('msgMetacFrm.Descripcion').toString();
	jsMsgMetacTimeOidTipo = get('msgMetacFrm.timeOidTipo')[0];
	jsMsgMetacValEsta = get('msgMetacFrm.valEsta');
	jsMsgMetacValLiteIden = get('msgMetacFrm.valLiteIden').toString();
	
	
	var parametros = "";
	parametros += jsMsgMetacCodMeta + "|";
	parametros += jsMsgMetacDescripcion + "|";
	parametros += jsMsgMetacTimeOidTipo + "|";
	parametros += jsMsgMetacValEsta + "|";
	parametros += jsMsgMetacValLiteIden + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function msgMetacBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMsgMetacCodMeta + "|";
	parametros += jsMsgMetacDescripcion + "|";
	parametros += jsMsgMetacTimeOidTipo + "|";
	parametros += jsMsgMetacValEsta + "|";
	parametros += jsMsgMetacValLiteIden + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('msgMetacFrm.accion'), 
		get('msgMetacFrm.origen'));
	
	jsMsgMetacId = get('msgMetacFrm.id').toString();
	jsMsgMetacCodMeta = get('msgMetacFrm.codMeta').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMsgMetacDescripcion = buildLocalizedString('msgMetacFrm', 1);
	}else{
		jsMsgMetacDescripcion = get('msgMetacFrm.Descripcion');
	}
	jsMsgMetacTimeOidTipo = get('msgMetacFrm.timeOidTipo')[0];
	jsMsgMetacValEsta = get('msgMetacFrm.valEsta');
	jsMsgMetacValLiteIden = get('msgMetacFrm.valLiteIden').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('msgMetacFrm.accion'), 
		get('msgMetacFrm.origen'));


	set('msgMetacFrm.id', jsMsgMetacId);
	set('msgMetacFrm.codMeta', jsMsgMetacCodMeta);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('msgMetacFrm', 1,  jsMsgMetacDescripcion)
		loadLocalizationWidget('msgMetacFrm', 'Descripcion', 1);
	}else{
		set('msgMetacFrm.Descripcion', jsMsgMetacDescripcion);		
	}
	set('msgMetacFrm.timeOidTipo', [jsMsgMetacTimeOidTipo]);
	set('msgMetacFrm.valEsta', jsMsgMetacValEsta);
	set('msgMetacFrm.valLiteIden', jsMsgMetacValLiteIden);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMsgMetacCodMeta = '';
	jsMsgMetacDescripcion = '';
	jsMsgMetacTimeOidTipo = '';
	jsMsgMetacValEsta = '';
	jsMsgMetacValLiteIden = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('msgMetacFrm.errCodigo', errorCode);
	set('msgMetacFrm.errDescripcion', description);
	set('msgMetacFrm.errSeverity', severity);
	fMostrarMensajeError();
}
