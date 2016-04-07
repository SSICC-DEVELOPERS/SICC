

/*
    INDRA/CAR/mmg
    $Id: preestra.js,v 1.1 2009/12/03 19:02:22 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPreEstraId = "";
var jsPreEstraPaisOidPais = "";
var jsPreEstraCodEstr = "";
var jsPreEstraDescripcion = "";
var jsPreEstraTiesOidTipoEstr = "";
var jsPreEstraNumMaxiGrup = "";
var jsPreEstraNumMaxiGrupCndt = "";
var jsPreEstraNumMaxiGrupCndo = "";
var jsPreEstraIndListRank = "";
var jsPreEstraIndCuadGrup = "";
var jsPreEstraTiprOidTipoProd = "";
var jsPreEstraIndCvImpr = "";
var jsPreEstraIndModiImpr = "";
var jsPreEstraIndCvDespAuto = "";
var jsPreEstraIndModiDesp = "";
var jsPreEstraIndCvDigi = "";
var jsPreEstraIndModiDigi = "";

//Variables de paginacion, 
var preEstraPageCount = 1;

//Varible de columna que representa el campo de choice
var preEstraChoiceColumn = 1;

//Flag de siguiente pagina;
var preEstraMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var preEstraTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 255;
var sizeFormUpdate = 255;

//Ultima busqueda realizada
var preEstraLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("preEstraFrm.codEstr");','focaliza("preEstraFrm.codEstr");','','focaliza("preEstraFrm.codEstr");','focaliza("preEstraFrm.codEstr");',''],[4,'focaliza("preEstraFrm.Descripcion");','focaliza("preEstraFrm.Descripcion");','focaliza("preEstraFrm.Descripcion");','focaliza("preEstraFrm.Descripcion");','focaliza("preEstraFrm.Descripcion");','focaliza("preEstraFrm.Descripcion");'],[5,'','focalizaComboDependence("preEstra","tiesOidTipoEstr", false);','','','focalizaComboDependence("preEstra","tiesOidTipoEstr", true);',''],[6,'','focaliza("preEstraFrm.numMaxiGrup");','focaliza("preEstraFrm.numMaxiGrup");','','focaliza("preEstraFrm.numMaxiGrup");','focaliza("preEstraFrm.numMaxiGrup");'],[7,'','focaliza("preEstraFrm.numMaxiGrupCndt");','focaliza("preEstraFrm.numMaxiGrupCndt");','','focaliza("preEstraFrm.numMaxiGrupCndt");','focaliza("preEstraFrm.numMaxiGrupCndt");'],[8,'','focaliza("preEstraFrm.numMaxiGrupCndo");','focaliza("preEstraFrm.numMaxiGrupCndo");','','focaliza("preEstraFrm.numMaxiGrupCndo");','focaliza("preEstraFrm.numMaxiGrupCndo");'],[9,'','focaliza("preEstraFrm.indListRank");','focaliza("preEstraFrm.indListRank");','','focaliza("preEstraFrm.indListRank");','focaliza("preEstraFrm.indListRank");'],[10,'','focaliza("preEstraFrm.indCuadGrup");','focaliza("preEstraFrm.indCuadGrup");','','focaliza("preEstraFrm.indCuadGrup");','focaliza("preEstraFrm.indCuadGrup");'],[11,'','focalizaComboDependence("preEstra","tiprOidTipoProd", false);','focalizaComboDependence("preEstra","tiprOidTipoProd", false);','','focalizaComboDependence("preEstra","tiprOidTipoProd", true);','focalizaComboDependence("preEstra","tiprOidTipoProd", true);'],[12,'','focaliza("preEstraFrm.indCvImpr");','focaliza("preEstraFrm.indCvImpr");','','focaliza("preEstraFrm.indCvImpr");','focaliza("preEstraFrm.indCvImpr");'],[13,'','focaliza("preEstraFrm.indModiImpr");','focaliza("preEstraFrm.indModiImpr");','','focaliza("preEstraFrm.indModiImpr");','focaliza("preEstraFrm.indModiImpr");'],[14,'','focaliza("preEstraFrm.indCvDespAuto");','focaliza("preEstraFrm.indCvDespAuto");','','focaliza("preEstraFrm.indCvDespAuto");','focaliza("preEstraFrm.indCvDespAuto");'],[15,'','focaliza("preEstraFrm.indModiDesp");','focaliza("preEstraFrm.indModiDesp");','','focaliza("preEstraFrm.indModiDesp");','focaliza("preEstraFrm.indModiDesp");'],[16,'','focaliza("preEstraFrm.indCvDigi");','focaliza("preEstraFrm.indCvDigi");','','focaliza("preEstraFrm.indCvDigi");','focaliza("preEstraFrm.indCvDigi");'],[17,'','focaliza("preEstraFrm.indModiDigi");','focaliza("preEstraFrm.indModiDigi");','','focaliza("preEstraFrm.indModiDigi");','focaliza("preEstraFrm.indModiDigi");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var tiesOidTipoEstrDependeceMap = new Vector();
tiesOidTipoEstrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tiesOidTipoEstrDependeceMap.agregar(['tiesOidTipoEstr', padresTmp, '', 'PreTipoEstra']);
var tiprOidTipoProdDependeceMap = new Vector();
tiprOidTipoProdDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tiprOidTipoProdDependeceMap.agregar(['tiprOidTipoProd', padresTmp, '', 'PreTipoProdu']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
preEstraLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var preEstraTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function preEstraInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('preEstraFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('preEstraFrm.accion')){
		case "query": preEstraQueryInitComponents(); break;
		case "view": preEstraViewInitComponents(); break;
		case "create": preEstraCreateInitComponents(); break;
		case "update": preEstraUpdateInitComponents(); break;
		case "remove": preEstraRemoveInitComponents(); break;
		case "lov": preEstraLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('preEstraFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('preEstra')) preEstraCmdRequery();
}

function preEstraQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
}

function preEstraViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('preEstraFrm', 'Descripcion', 1);
	
		
	
}

function preEstraCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('preEstraFrm.codEstr','S', GestionarMensaje('PreEstra.codEstr.requiered.message'));
	
	setMV('preEstraFrm.Descripcion','S', GestionarMensaje('PreEstra.Descripcion.requiered.message'));
	
	setMV('preEstraFrm.tiesOidTipoEstr','S', GestionarMensaje('PreEstra.tiesOidTipoEstr.requiered.message'));
	
	setMV('preEstraFrm.tiprOidTipoProd','S', GestionarMensaje('PreEstra.tiprOidTipoProd.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function preEstraUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('preEstraFrm.origen') == "pagina"){
		loadLocalizationWidget('preEstraFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		preEstraTmpUpdateValues = preEstraBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('preEstraFrm.Descripcion','S', GestionarMensaje('PreEstra.Descripcion.requiered.message'));
		setMV('preEstraFrm.tiprOidTipoProd','S', GestionarMensaje('PreEstra.tiprOidTipoProd.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('preEstraFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function preEstraRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	preEstraList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function preEstraLovInitComponents(){
	preEstraLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad



















//Función que permite cargar los datos de un elemento de lov seleccionado
function preEstraSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('preEstraFrm.' + campo, id);
	set('preEstraFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function preEstraLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	preEstraLovReturnParameters.id = '';
	preEstraLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function preEstraLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preEstraList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = preEstraList.codSeleccionados();
	var descripcion = preEstraList.extraeDato(
		preEstraList.codSeleccionados()[0], preEstraChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	preEstraLovReturnParameters.id = codigo;
	preEstraLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function preEstraCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('preEstraFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('preEstraFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "preEstraList", "PreEstraConectorTransactionQuery", 
		"result_ROWSET", parametros, "preEstraPostQueryActions(datos);"]], "", "");	
}

function preEstraCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('preEstraFrm.lastQueryToSession'));
	var i =0;
	set('preEstraFrm.codEstr', paramsRequery.ij(i++));
	
	set('preEstraFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	preEstraPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	preEstraCmdQuery(preEstraPageCount);
}

function preEstraFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	preEstraPageCount = 1;
	preEstraCmdQuery(preEstraPageCount);
}

function preEstraPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preEstraLastQuery){
		preEstraFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	preEstraPageCount--;
	preEstraCmdQuery(preEstraPageCount);
}

function preEstraNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preEstraLastQuery){
		preEstraFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	preEstraPageCount++;
	preEstraCmdQuery(preEstraPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function preEstraPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('preEstraListLayer', 'O');
		visibilidad('preEstraListButtonsLayer', 'O');
		if(get('preEstraFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	preEstraLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:preEstraViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, preEstraChoiceColumn) + "</A>",
			i, preEstraChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	preEstraList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	preEstraTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		preEstraMorePagesFlag = true;
		preEstraList.eliminar(mmgPageSize, 1);
	}else{
		preEstraMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('preEstraFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('preEstraListLayer', 'V');
	visibilidad('preEstraListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('preEstraList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	preEstraList.display();
	
	//Actualizamos el estado de los botones 
	if(preEstraMorePagesFlag){
		set_estado_botonera('preEstraPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('preEstraPaginationButtonBar',
			3,"inactivo");
	}
	if(preEstraPageCount > 1){
		set_estado_botonera('preEstraPaginationButtonBar',
			2,"activo");
		set_estado_botonera('preEstraPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('preEstraPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('preEstraPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function preEstraUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preEstraList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('preEstraFrm.idSelection', preEstraList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('preEstraFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = preEstraList.codSeleccionados()[0];
		parametros["previousAction"] = get('preEstraFrm.accion');
		parametros["accion"] = get('preEstraFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('PreEstraLPStartUp', get('preEstraFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) preEstraCmdRequery();
	}
}

function preEstraRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preEstraList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = preEstraList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('preEstraFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(preEstraList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += preEstraTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('preEstraFrm.timestamp', timestamps);


	preEstraFrm.oculto='S';
	envia('preEstraFrm');
	preEstraFrm.oculto='N';
}

function preEstraViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preEstraList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	preEstraViewDetail(preEstraList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function preEstraViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('preEstraFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('PreEstraLPStartUp', 'view', parametros, null, sizeFormView + 55);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('preEstraFrm', 
		'Descripcion', 1,
		get('preEstraFrm.Descripcion'));	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('preEstraFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('preEstraFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('PreEstra.Descripcion.requiered.message'));
		focaliza('preEstraFrm.Descripcion');
		return;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		preEstraFrm.oculto='S';
		envia('preEstraFrm');
		preEstraFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('preEstraFrm.paisOidPais').toString() == ''){
		set('preEstraFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'preEstra');
		
	}
	if(get('preEstraFrm.tiesOidTipoEstr').toString() == ''){
		set('preEstraFrm.tiesOidTipoEstr', []);
		mmgResetCombosOnCascade('tiesOidTipoEstr', 'tiesOidTipoEstr', 'preEstra');
		
	}
	if(get('preEstraFrm.tiprOidTipoProd').toString() == ''){
		set('preEstraFrm.tiprOidTipoProd', []);
		mmgResetCombosOnCascade('tiprOidTipoProd', 'tiprOidTipoProd', 'preEstra');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	preEstraRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('preEstraFrm.accion');
	var origenTmp = get('preEstraFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(preEstraBuildUpdateRecordString() != preEstraTmpUpdateValues){
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
	document.all.preEstraListLayer.style.display='none';
	document.all.preEstraListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.preEstraListLayer.style.display='';
	document.all.preEstraListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPreEstraCodEstr = get('preEstraFrm.codEstr').toString();
	jsPreEstraDescripcion = get('preEstraFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsPreEstraCodEstr + "|";
	parametros += jsPreEstraDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function preEstraBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPreEstraDescripcion + "|";
	parametros += jsPreEstraNumMaxiGrup + "|";
	parametros += jsPreEstraNumMaxiGrupCndt + "|";
	parametros += jsPreEstraNumMaxiGrupCndo + "|";
	parametros += jsPreEstraIndListRank + "|";
	parametros += jsPreEstraIndCuadGrup + "|";
	parametros += jsPreEstraTiprOidTipoProd + "|";
	parametros += jsPreEstraIndCvImpr + "|";
	parametros += jsPreEstraIndModiImpr + "|";
	parametros += jsPreEstraIndCvDespAuto + "|";
	parametros += jsPreEstraIndModiDesp + "|";
	parametros += jsPreEstraIndCvDigi + "|";
	parametros += jsPreEstraIndModiDigi + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preEstraFrm.accion'), 
		get('preEstraFrm.origen'));
	
	jsPreEstraId = get('preEstraFrm.id').toString();
	jsPreEstraPaisOidPais = get('preEstraFrm.paisOidPais')[0];
	jsPreEstraCodEstr = get('preEstraFrm.codEstr').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPreEstraDescripcion = buildLocalizedString('preEstraFrm', 1);
	}else{
		jsPreEstraDescripcion = get('preEstraFrm.Descripcion');
	}
	jsPreEstraTiesOidTipoEstr = get('preEstraFrm.tiesOidTipoEstr')[0];
	jsPreEstraNumMaxiGrup = get('preEstraFrm.numMaxiGrup').toString();
	jsPreEstraNumMaxiGrupCndt = get('preEstraFrm.numMaxiGrupCndt').toString();
	jsPreEstraNumMaxiGrupCndo = get('preEstraFrm.numMaxiGrupCndo').toString();
	if(get('preEstraFrm.indListRank').toString() == 'S') jsPreEstraIndListRank = "true";
		else jsPreEstraIndListRank = "false";
	if(get('preEstraFrm.indCuadGrup').toString() == 'S') jsPreEstraIndCuadGrup = "true";
		else jsPreEstraIndCuadGrup = "false";
	jsPreEstraTiprOidTipoProd = get('preEstraFrm.tiprOidTipoProd')[0];
	if(get('preEstraFrm.indCvImpr').toString() == 'S') jsPreEstraIndCvImpr = "true";
		else jsPreEstraIndCvImpr = "false";
	if(get('preEstraFrm.indModiImpr').toString() == 'S') jsPreEstraIndModiImpr = "true";
		else jsPreEstraIndModiImpr = "false";
	if(get('preEstraFrm.indCvDespAuto').toString() == 'S') jsPreEstraIndCvDespAuto = "true";
		else jsPreEstraIndCvDespAuto = "false";
	if(get('preEstraFrm.indModiDesp').toString() == 'S') jsPreEstraIndModiDesp = "true";
		else jsPreEstraIndModiDesp = "false";
	if(get('preEstraFrm.indCvDigi').toString() == 'S') jsPreEstraIndCvDigi = "true";
		else jsPreEstraIndCvDigi = "false";
	if(get('preEstraFrm.indModiDigi').toString() == 'S') jsPreEstraIndModiDigi = "true";
		else jsPreEstraIndModiDigi = "false";
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preEstraFrm.accion'), 
		get('preEstraFrm.origen'));


	set('preEstraFrm.id', jsPreEstraId);
	set('preEstraFrm.paisOidPais', [jsPreEstraPaisOidPais]);
	set('preEstraFrm.codEstr', jsPreEstraCodEstr);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('preEstraFrm', 1,  jsPreEstraDescripcion)
		loadLocalizationWidget('preEstraFrm', 'Descripcion', 1);
	}else{
		set('preEstraFrm.Descripcion', jsPreEstraDescripcion);		
	}
	set('preEstraFrm.tiesOidTipoEstr', [jsPreEstraTiesOidTipoEstr]);
	set('preEstraFrm.numMaxiGrup', jsPreEstraNumMaxiGrup);
	set('preEstraFrm.numMaxiGrupCndt', jsPreEstraNumMaxiGrupCndt);
	set('preEstraFrm.numMaxiGrupCndo', jsPreEstraNumMaxiGrupCndo);
	
			
			if(jsPreEstraIndListRank == "true") set('preEstraFrm.indListRank', 'S');
			else set('preEstraFrm.indListRank', 'N');
	
			
			if(jsPreEstraIndCuadGrup == "true") set('preEstraFrm.indCuadGrup', 'S');
			else set('preEstraFrm.indCuadGrup', 'N');
	set('preEstraFrm.tiprOidTipoProd', [jsPreEstraTiprOidTipoProd]);
	
			
			if(jsPreEstraIndCvImpr == "true") set('preEstraFrm.indCvImpr', 'S');
			else set('preEstraFrm.indCvImpr', 'N');
	
			
			if(jsPreEstraIndModiImpr == "true") set('preEstraFrm.indModiImpr', 'S');
			else set('preEstraFrm.indModiImpr', 'N');
	
			
			if(jsPreEstraIndCvDespAuto == "true") set('preEstraFrm.indCvDespAuto', 'S');
			else set('preEstraFrm.indCvDespAuto', 'N');
	
			
			if(jsPreEstraIndModiDesp == "true") set('preEstraFrm.indModiDesp', 'S');
			else set('preEstraFrm.indModiDesp', 'N');
	
			
			if(jsPreEstraIndCvDigi == "true") set('preEstraFrm.indCvDigi', 'S');
			else set('preEstraFrm.indCvDigi', 'N');
	
			
			if(jsPreEstraIndModiDigi == "true") set('preEstraFrm.indModiDigi', 'S');
			else set('preEstraFrm.indModiDigi', 'N');
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsPreEstraCodEstr = '';
	jsPreEstraDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('preEstraFrm.errCodigo', errorCode);
	set('preEstraFrm.errDescripcion', description);
	set('preEstraFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
