

/*
    INDRA/CAR/mmg
    $Id: preindiccuadr.js,v 1.1 2009/12/03 19:01:55 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPreIndicCuadrId = "";
var jsPreIndicCuadrCodIndiCuad = "";
var jsPreIndicCuadrDescripcion = "";
var jsPreIndicCuadrValFactCuad = "";

//Variables de paginacion, 
var preIndicCuadrPageCount = 1;

//Varible de columna que representa el campo de choice
var preIndicCuadrChoiceColumn = 1;

//Flag de siguiente pagina;
var preIndicCuadrMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var preIndicCuadrTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var preIndicCuadrLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");'],[3,'focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");'],[4,'','focaliza("preIndicCuadrFrm.valFactCuad");','focaliza("preIndicCuadrFrm.valFactCuad");','','focaliza("preIndicCuadrFrm.valFactCuad");','focaliza("preIndicCuadrFrm.valFactCuad");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");','focaliza("preIndicCuadrFrm.codIndiCuad");'],[3,'focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");','focaliza("preIndicCuadrFrm.Descripcion");'],[4,'','focaliza("preIndicCuadrFrm.valFactCuad");','focaliza("preIndicCuadrFrm.valFactCuad");','','focaliza("preIndicCuadrFrm.valFactCuad");','focaliza("preIndicCuadrFrm.valFactCuad");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
preIndicCuadrLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var preIndicCuadrTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function preIndicCuadrInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('preIndicCuadrFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('preIndicCuadrFrm.accion')){
		case "query": preIndicCuadrQueryInitComponents(); break;
		case "view": preIndicCuadrViewInitComponents(); break;
		case "create": preIndicCuadrCreateInitComponents(); break;
		case "update": preIndicCuadrUpdateInitComponents(); break;
		case "remove": preIndicCuadrRemoveInitComponents(); break;
		case "lov": preIndicCuadrLovInitComponents(); break;
	}
	//alert('accion :' + get('preIndicCuadrFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('preIndicCuadrFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('preIndicCuadr')) preIndicCuadrCmdRequery();
}

function preIndicCuadrQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('preIndicCuadrFrm', true);	
}

function preIndicCuadrViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('preIndicCuadrFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('preIndicCuadrFrm.valFactCuad', get('preIndicCuadrFrm.valFactCuadCheckValue'));
		
	focusFirstField('preIndicCuadrFrm', true);
}

function preIndicCuadrCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('preIndicCuadrFrm.codIndiCuad','S', GestionarMensaje('PreIndicCuadr.codIndiCuad.requiered.message'));
	
	setMV('preIndicCuadrFrm.Descripcion','S', GestionarMensaje('PreIndicCuadr.Descripcion.requiered.message'));
	
	setMV('preIndicCuadrFrm.valFactCuad','S', GestionarMensaje('PreIndicCuadr.valFactCuad.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('preIndicCuadrFrm', true);
}

function preIndicCuadrUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('preIndicCuadrFrm.origen') == "pagina"){
		loadLocalizationWidget('preIndicCuadrFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('preIndicCuadrFrm.valFactCuad', get('preIndicCuadrFrm.valFactCuadCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		preIndicCuadrTmpUpdateValues = preIndicCuadrBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('preIndicCuadrFrm.codIndiCuad','S', GestionarMensaje('PreIndicCuadr.codIndiCuad.requiered.message'));
		setMV('preIndicCuadrFrm.Descripcion','S', GestionarMensaje('PreIndicCuadr.Descripcion.requiered.message'));
		setMV('preIndicCuadrFrm.valFactCuad','S', GestionarMensaje('PreIndicCuadr.valFactCuad.requiered.message'));
		
			focusFirstFieldModify('preIndicCuadrFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('preIndicCuadrFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('preIndicCuadrFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function preIndicCuadrRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	preIndicCuadrList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('preIndicCuadrFrm', true);
}

function preIndicCuadrLovInitComponents(){
	preIndicCuadrLovReturnParameters = window.dialogArguments;
	
	focusFirstField('preIndicCuadrFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function preIndicCuadrSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('preIndicCuadrFrm.' + campo, id);
	set('preIndicCuadrFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function preIndicCuadrLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	preIndicCuadrLovReturnParameters.id = '';
	preIndicCuadrLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function preIndicCuadrLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preIndicCuadrList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = preIndicCuadrList.codSeleccionados();
	var descripcion = preIndicCuadrList.extraeDato(
		preIndicCuadrList.codSeleccionados()[0], preIndicCuadrChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	preIndicCuadrLovReturnParameters.id = codigo;
	preIndicCuadrLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function preIndicCuadrCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('preIndicCuadrFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('preIndicCuadrFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "preIndicCuadrList", "PreIndicCuadrConectorTransactionQuery", 
		"result_ROWSET", parametros, "preIndicCuadrPostQueryActions(datos);"]], "", "");	
}

function preIndicCuadrCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('preIndicCuadrFrm.lastQueryToSession'));
	var i =0;
	set('preIndicCuadrFrm.codIndiCuad', paramsRequery.ij(i++));
	
	set('preIndicCuadrFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	preIndicCuadrPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	preIndicCuadrCmdQuery(preIndicCuadrPageCount);
}

function preIndicCuadrFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	preIndicCuadrPageCount = 1;
	preIndicCuadrCmdQuery(preIndicCuadrPageCount);
}

function preIndicCuadrPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preIndicCuadrLastQuery){
		preIndicCuadrFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	preIndicCuadrPageCount--;
	preIndicCuadrCmdQuery(preIndicCuadrPageCount);
}

function preIndicCuadrNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preIndicCuadrLastQuery){
		preIndicCuadrFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	preIndicCuadrPageCount++;
	preIndicCuadrCmdQuery(preIndicCuadrPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function preIndicCuadrPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('preIndicCuadrListLayer', 'O');
		visibilidad('preIndicCuadrListButtonsLayer', 'O');
		if(get('preIndicCuadrFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	preIndicCuadrLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case 'U': datosTmp.ij2(GestionarMensaje('PreIndicCuadr.valFactCuad.U.value'), i, 3); break;
			case 'M': datosTmp.ij2(GestionarMensaje('PreIndicCuadr.valFactCuad.M.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:preIndicCuadrViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, preIndicCuadrChoiceColumn) + "</A>",
			i, preIndicCuadrChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	preIndicCuadrList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	preIndicCuadrTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		preIndicCuadrMorePagesFlag = true;
		preIndicCuadrList.eliminar(mmgPageSize, 1);
	}else{
		preIndicCuadrMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('preIndicCuadrFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('preIndicCuadrListLayer', 'V');
	visibilidad('preIndicCuadrListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('preIndicCuadrList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	preIndicCuadrList.display();
	
	//Actualizamos el estado de los botones 
	if(preIndicCuadrMorePagesFlag){
		set_estado_botonera('preIndicCuadrPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('preIndicCuadrPaginationButtonBar',
			3,"inactivo");
	}
	if(preIndicCuadrPageCount > 1){
		set_estado_botonera('preIndicCuadrPaginationButtonBar',
			2,"activo");
		set_estado_botonera('preIndicCuadrPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('preIndicCuadrPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('preIndicCuadrPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function preIndicCuadrUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preIndicCuadrList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('preIndicCuadrFrm.idSelection', preIndicCuadrList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('preIndicCuadrFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = preIndicCuadrList.codSeleccionados()[0];
		parametros["previousAction"] = get('preIndicCuadrFrm.accion');
		parametros["accion"] = get('preIndicCuadrFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PreIndicCuadrLPStartUp', get('preIndicCuadrFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) preIndicCuadrCmdRequery();
	}
}

function preIndicCuadrRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preIndicCuadrList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = preIndicCuadrList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('preIndicCuadrFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(preIndicCuadrList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += preIndicCuadrTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('preIndicCuadrFrm.timestamp', timestamps);


	preIndicCuadrFrm.oculto='S';
	envia('preIndicCuadrFrm');
	preIndicCuadrFrm.oculto='N';
}

function preIndicCuadrViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preIndicCuadrList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	preIndicCuadrViewDetail(preIndicCuadrList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function preIndicCuadrViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('preIndicCuadrFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PreIndicCuadrLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('preIndicCuadrFrm', 
		'Descripcion', 1,
		get('preIndicCuadrFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('preIndicCuadrFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('preIndicCuadrFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('PreIndicCuadr.Descripcion.requiered.message'));
		focaliza('preIndicCuadrFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		preIndicCuadrFrm.oculto='S';
		envia('preIndicCuadrFrm');
		preIndicCuadrFrm.oculto='N';
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
	preIndicCuadrRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('preIndicCuadrFrm.accion');
	var origenTmp = get('preIndicCuadrFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(preIndicCuadrBuildUpdateRecordString() != preIndicCuadrTmpUpdateValues){
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
	document.all.preIndicCuadrListLayer.style.display='none';
	document.all.preIndicCuadrListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.preIndicCuadrListLayer.style.display='';
	document.all.preIndicCuadrListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPreIndicCuadrCodIndiCuad = get('preIndicCuadrFrm.codIndiCuad').toString();
	jsPreIndicCuadrDescripcion = get('preIndicCuadrFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsPreIndicCuadrCodIndiCuad + "|";
	parametros += jsPreIndicCuadrDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function preIndicCuadrBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPreIndicCuadrCodIndiCuad + "|";
	parametros += jsPreIndicCuadrDescripcion + "|";
	parametros += jsPreIndicCuadrValFactCuad + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preIndicCuadrFrm.accion'), 
		get('preIndicCuadrFrm.origen'));
	
	jsPreIndicCuadrId = get('preIndicCuadrFrm.id').toString();
	jsPreIndicCuadrCodIndiCuad = get('preIndicCuadrFrm.codIndiCuad').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPreIndicCuadrDescripcion = buildLocalizedString('preIndicCuadrFrm', 1);
	}else{
		jsPreIndicCuadrDescripcion = get('preIndicCuadrFrm.Descripcion');
	}
	jsPreIndicCuadrValFactCuad = get('preIndicCuadrFrm.valFactCuad');
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preIndicCuadrFrm.accion'), 
		get('preIndicCuadrFrm.origen'));


	set('preIndicCuadrFrm.id', jsPreIndicCuadrId);
	set('preIndicCuadrFrm.codIndiCuad', jsPreIndicCuadrCodIndiCuad);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('preIndicCuadrFrm', 1,  jsPreIndicCuadrDescripcion)
		loadLocalizationWidget('preIndicCuadrFrm', 'Descripcion', 1);
	}else{
		set('preIndicCuadrFrm.Descripcion', jsPreIndicCuadrDescripcion);		
	}
	set('preIndicCuadrFrm.valFactCuad', jsPreIndicCuadrValFactCuad);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPreIndicCuadrCodIndiCuad = '';
	jsPreIndicCuadrDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('preIndicCuadrFrm.errCodigo', errorCode);
	set('preIndicCuadrFrm.errDescripcion', description);
	set('preIndicCuadrFrm.errSeverity', severity);
	fMostrarMensajeError();
}
