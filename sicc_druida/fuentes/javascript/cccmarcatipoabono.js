

/*
    INDRA/CAR/mmg
    $Id: cccmarcatipoabono.js,v 1.1 2009/12/03 19:01:40 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCccMarcaTipoAbonoId = "";
var jsCccMarcaTipoAbonoValObse = "";
var jsCccMarcaTipoAbonoMasiOidMarcSali = "";
var jsCccMarcaTipoAbonoTaspOidTipoAbonSubp = "";
var jsCccMarcaTipoAbonoIndEntrSali = "";

//Variables de paginacion, 
var cccMarcaTipoAbonoPageCount = 1;

//Varible de columna que representa el campo de choice
var cccMarcaTipoAbonoChoiceColumn = 4;

//Flag de siguiente pagina;
var cccMarcaTipoAbonoMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cccMarcaTipoAbonoTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 231;
var sizeFormView = 209;
var sizeFormUpdate = 209;

//Ultima busqueda realizada
var cccMarcaTipoAbonoLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");','focaliza("cccMarcaTipoAbonoFrm.indEntrSali");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var masiOidMarcSaliDependeceMap = new Vector();
masiOidMarcSaliDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
masiOidMarcSaliDependeceMap.agregar(['masiOidMarcSali', padresTmp, '', 'CccMarcaSitua']);
var taspOidTipoAbonSubpDependeceMap = new Vector();
taspOidTipoAbonSubpDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
taspOidTipoAbonSubpDependeceMap.agregar(['taspOidTipoAbonSubp', padresTmp, '', 'CccTipoAbonoSubpr']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cccMarcaTipoAbonoLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cccMarcaTipoAbonoTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cccMarcaTipoAbonoInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cccMarcaTipoAbonoFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cccMarcaTipoAbonoFrm.accion')){
		case "query": cccMarcaTipoAbonoQueryInitComponents(); break;
		case "view": cccMarcaTipoAbonoViewInitComponents(); break;
		case "create": cccMarcaTipoAbonoCreateInitComponents(); break;
		case "update": cccMarcaTipoAbonoUpdateInitComponents(); break;
		case "remove": cccMarcaTipoAbonoRemoveInitComponents(); break;
		case "lov": cccMarcaTipoAbonoLovInitComponents(); break;
	}
	//alert('accion :' + get('cccMarcaTipoAbonoFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cccMarcaTipoAbonoFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cccMarcaTipoAbono')) cccMarcaTipoAbonoCmdRequery();
}

function cccMarcaTipoAbonoQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('cccMarcaTipoAbonoFrm', true);	
}

function cccMarcaTipoAbonoViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('cccMarcaTipoAbonoFrm', true);
}

function cccMarcaTipoAbonoCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cccMarcaTipoAbonoFrm.taspOidTipoAbonSubp','S', GestionarMensaje('CccMarcaTipoAbono.taspOidTipoAbonSubp.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cccMarcaTipoAbonoFrm', true);
}

function cccMarcaTipoAbonoUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cccMarcaTipoAbonoFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		cccMarcaTipoAbonoTmpUpdateValues = cccMarcaTipoAbonoBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cccMarcaTipoAbonoFrm.taspOidTipoAbonSubp','S', GestionarMensaje('CccMarcaTipoAbono.taspOidTipoAbonSubp.requiered.message'));
		
			focusFirstFieldModify('cccMarcaTipoAbonoFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('cccMarcaTipoAbonoFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cccMarcaTipoAbonoFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cccMarcaTipoAbonoRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cccMarcaTipoAbonoList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cccMarcaTipoAbonoFrm', true);
}

function cccMarcaTipoAbonoLovInitComponents(){
	cccMarcaTipoAbonoLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cccMarcaTipoAbonoFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function cccMarcaTipoAbonoSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cccMarcaTipoAbonoFrm.' + campo, id);
	set('cccMarcaTipoAbonoFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cccMarcaTipoAbonoLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cccMarcaTipoAbonoLovReturnParameters.id = '';
	cccMarcaTipoAbonoLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cccMarcaTipoAbonoLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMarcaTipoAbonoList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cccMarcaTipoAbonoList.codSeleccionados();
	var descripcion = cccMarcaTipoAbonoList.extraeDato(
		cccMarcaTipoAbonoList.codSeleccionados()[0], cccMarcaTipoAbonoChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cccMarcaTipoAbonoLovReturnParameters.id = codigo;
	cccMarcaTipoAbonoLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cccMarcaTipoAbonoCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cccMarcaTipoAbonoFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cccMarcaTipoAbonoFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cccMarcaTipoAbonoList", "CccMarcaTipoAbonoConectorTransactionQuery", 
		"result_ROWSET", parametros, "cccMarcaTipoAbonoPostQueryActions(datos);"]], "", "");	
}

function cccMarcaTipoAbonoCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cccMarcaTipoAbonoFrm.lastQueryToSession'));
	var i =0;
	set('cccMarcaTipoAbonoFrm.valObse', paramsRequery.ij(i++));
	
	set('cccMarcaTipoAbonoFrm.masiOidMarcSali', [paramsRequery.ij(i++)]);
	
	set('cccMarcaTipoAbonoFrm.taspOidTipoAbonSubp', [paramsRequery.ij(i++)]);
	
	set('cccMarcaTipoAbonoFrm.indEntrSali', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	cccMarcaTipoAbonoPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cccMarcaTipoAbonoCmdQuery(cccMarcaTipoAbonoPageCount);
}

function cccMarcaTipoAbonoFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cccMarcaTipoAbonoPageCount = 1;
	cccMarcaTipoAbonoCmdQuery(cccMarcaTipoAbonoPageCount);
}

function cccMarcaTipoAbonoPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccMarcaTipoAbonoLastQuery){
		cccMarcaTipoAbonoFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cccMarcaTipoAbonoPageCount--;
	cccMarcaTipoAbonoCmdQuery(cccMarcaTipoAbonoPageCount);
}

function cccMarcaTipoAbonoNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccMarcaTipoAbonoLastQuery){
		cccMarcaTipoAbonoFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cccMarcaTipoAbonoPageCount++;
	cccMarcaTipoAbonoCmdQuery(cccMarcaTipoAbonoPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cccMarcaTipoAbonoPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cccMarcaTipoAbonoListLayer', 'O');
		visibilidad('cccMarcaTipoAbonoListButtonsLayer', 'O');
		if(get('cccMarcaTipoAbonoFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cccMarcaTipoAbonoLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cccMarcaTipoAbonoViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cccMarcaTipoAbonoChoiceColumn) + "</A>",
			i, cccMarcaTipoAbonoChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cccMarcaTipoAbonoList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cccMarcaTipoAbonoTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cccMarcaTipoAbonoMorePagesFlag = true;
		cccMarcaTipoAbonoList.eliminar(mmgPageSize, 1);
	}else{
		cccMarcaTipoAbonoMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cccMarcaTipoAbonoFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cccMarcaTipoAbonoListLayer', 'V');
	visibilidad('cccMarcaTipoAbonoListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cccMarcaTipoAbonoList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cccMarcaTipoAbonoList.display();
	
	//Actualizamos el estado de los botones 
	if(cccMarcaTipoAbonoMorePagesFlag){
		set_estado_botonera('cccMarcaTipoAbonoPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cccMarcaTipoAbonoPaginationButtonBar',
			3,"inactivo");
	}
	if(cccMarcaTipoAbonoPageCount > 1){
		set_estado_botonera('cccMarcaTipoAbonoPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cccMarcaTipoAbonoPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cccMarcaTipoAbonoPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cccMarcaTipoAbonoPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cccMarcaTipoAbonoUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMarcaTipoAbonoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cccMarcaTipoAbonoFrm.idSelection', cccMarcaTipoAbonoList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cccMarcaTipoAbonoFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cccMarcaTipoAbonoList.codSeleccionados()[0];
		parametros["previousAction"] = get('cccMarcaTipoAbonoFrm.accion');
		parametros["accion"] = get('cccMarcaTipoAbonoFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CccMarcaTipoAbonoLPStartUp', get('cccMarcaTipoAbonoFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cccMarcaTipoAbonoCmdRequery();
	}
}

function cccMarcaTipoAbonoRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMarcaTipoAbonoList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cccMarcaTipoAbonoList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cccMarcaTipoAbonoFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cccMarcaTipoAbonoList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cccMarcaTipoAbonoTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cccMarcaTipoAbonoFrm.timestamp', timestamps);


	cccMarcaTipoAbonoFrm.oculto='S';
	envia('cccMarcaTipoAbonoFrm');
	cccMarcaTipoAbonoFrm.oculto='N';
}

function cccMarcaTipoAbonoViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMarcaTipoAbonoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cccMarcaTipoAbonoViewDetail(cccMarcaTipoAbonoList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cccMarcaTipoAbonoViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cccMarcaTipoAbonoFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CccMarcaTipoAbonoLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cccMarcaTipoAbonoFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		cccMarcaTipoAbonoFrm.oculto='S';
		envia('cccMarcaTipoAbonoFrm');
		cccMarcaTipoAbonoFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cccMarcaTipoAbonoFrm.masiOidMarcSali').toString() == ''){
		set('cccMarcaTipoAbonoFrm.masiOidMarcSali', []);
		mmgResetCombosOnCascade('masiOidMarcSali', 'masiOidMarcSali', 'cccMarcaTipoAbono');
		
	}
	if(get('cccMarcaTipoAbonoFrm.taspOidTipoAbonSubp').toString() == ''){
		set('cccMarcaTipoAbonoFrm.taspOidTipoAbonSubp', []);
		mmgResetCombosOnCascade('taspOidTipoAbonSubp', 'taspOidTipoAbonSubp', 'cccMarcaTipoAbono');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cccMarcaTipoAbonoRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cccMarcaTipoAbonoFrm.accion');
	var origenTmp = get('cccMarcaTipoAbonoFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cccMarcaTipoAbonoBuildUpdateRecordString() != cccMarcaTipoAbonoTmpUpdateValues){
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
	document.all.cccMarcaTipoAbonoListLayer.style.display='none';
	document.all.cccMarcaTipoAbonoListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cccMarcaTipoAbonoListLayer.style.display='';
	document.all.cccMarcaTipoAbonoListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCccMarcaTipoAbonoValObse = get('cccMarcaTipoAbonoFrm.valObse').toString();
	jsCccMarcaTipoAbonoMasiOidMarcSali = get('cccMarcaTipoAbonoFrm.masiOidMarcSali')[0];
	jsCccMarcaTipoAbonoTaspOidTipoAbonSubp = get('cccMarcaTipoAbonoFrm.taspOidTipoAbonSubp')[0];
	jsCccMarcaTipoAbonoIndEntrSali = get('cccMarcaTipoAbonoFrm.indEntrSali').toString();
	
	
	var parametros = "";
	parametros += jsCccMarcaTipoAbonoValObse + "|";
	parametros += jsCccMarcaTipoAbonoMasiOidMarcSali + "|";
	parametros += jsCccMarcaTipoAbonoTaspOidTipoAbonSubp + "|";
	parametros += jsCccMarcaTipoAbonoIndEntrSali + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cccMarcaTipoAbonoBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCccMarcaTipoAbonoValObse + "|";
	parametros += jsCccMarcaTipoAbonoMasiOidMarcSali + "|";
	parametros += jsCccMarcaTipoAbonoTaspOidTipoAbonSubp + "|";
	parametros += jsCccMarcaTipoAbonoIndEntrSali + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccMarcaTipoAbonoFrm.accion'), 
		get('cccMarcaTipoAbonoFrm.origen'));
	
	jsCccMarcaTipoAbonoId = get('cccMarcaTipoAbonoFrm.id').toString();
	jsCccMarcaTipoAbonoValObse = get('cccMarcaTipoAbonoFrm.valObse').toString();
	jsCccMarcaTipoAbonoMasiOidMarcSali = get('cccMarcaTipoAbonoFrm.masiOidMarcSali')[0];
	jsCccMarcaTipoAbonoTaspOidTipoAbonSubp = get('cccMarcaTipoAbonoFrm.taspOidTipoAbonSubp')[0];
	jsCccMarcaTipoAbonoIndEntrSali = get('cccMarcaTipoAbonoFrm.indEntrSali').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccMarcaTipoAbonoFrm.accion'), 
		get('cccMarcaTipoAbonoFrm.origen'));


	set('cccMarcaTipoAbonoFrm.id', jsCccMarcaTipoAbonoId);
	set('cccMarcaTipoAbonoFrm.valObse', jsCccMarcaTipoAbonoValObse);
	set('cccMarcaTipoAbonoFrm.masiOidMarcSali', [jsCccMarcaTipoAbonoMasiOidMarcSali]);
	set('cccMarcaTipoAbonoFrm.taspOidTipoAbonSubp', [jsCccMarcaTipoAbonoTaspOidTipoAbonSubp]);
	set('cccMarcaTipoAbonoFrm.indEntrSali', jsCccMarcaTipoAbonoIndEntrSali);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCccMarcaTipoAbonoValObse = '';
	jsCccMarcaTipoAbonoMasiOidMarcSali = '';
	jsCccMarcaTipoAbonoTaspOidTipoAbonSubp = '';
	jsCccMarcaTipoAbonoIndEntrSali = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cccMarcaTipoAbonoFrm.errCodigo', errorCode);
	set('cccMarcaTipoAbonoFrm.errDescripcion', description);
	set('cccMarcaTipoAbonoFrm.errSeverity', severity);
	fMostrarMensajeError();
}
