

/*
    INDRA/CAR/mmg
    $Id: beltipomovimcaja.js,v 1.1 2009/12/03 19:01:48 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsBelTipoMovimCajaId = "";
var jsBelTipoMovimCajaCodCaja = "";
var jsBelTipoMovimCajaDesTipoMoviCaja = "";
var jsBelTipoMovimCajaValSign = "";
var jsBelTipoMovimCajaIndAuto = "";

//Variables de paginacion, 
var belTipoMovimCajaPageCount = 1;

//Varible de columna que representa el campo de choice
var belTipoMovimCajaChoiceColumn = 1;

//Flag de siguiente pagina;
var belTipoMovimCajaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var belTipoMovimCajaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 231;
var sizeFormView = 221;
var sizeFormUpdate = 221;

//Ultima busqueda realizada
var belTipoMovimCajaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("belTipoMovimCajaFrm.codCaja");','focaliza("belTipoMovimCajaFrm.codCaja");','focaliza("belTipoMovimCajaFrm.codCaja");','focaliza("belTipoMovimCajaFrm.codCaja");','focaliza("belTipoMovimCajaFrm.codCaja");','focaliza("belTipoMovimCajaFrm.codCaja");'],[3,'focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");'],[4,'focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");'],[5,'focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");','focaliza("belTipoMovimCajaFrm.desTipoMoviCaja");'],[4,'focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");','focaliza("belTipoMovimCajaFrm.valSign");'],[5,'focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");','focaliza("belTipoMovimCajaFrm.indAuto");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
belTipoMovimCajaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var belTipoMovimCajaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function belTipoMovimCajaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('belTipoMovimCajaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('belTipoMovimCajaFrm.accion')){
		case "query": belTipoMovimCajaQueryInitComponents(); break;
		case "view": belTipoMovimCajaViewInitComponents(); break;
		case "create": belTipoMovimCajaCreateInitComponents(); break;
		case "update": belTipoMovimCajaUpdateInitComponents(); break;
		case "remove": belTipoMovimCajaRemoveInitComponents(); break;
		case "lov": belTipoMovimCajaLovInitComponents(); break;
	}
	//alert('accion :' + get('belTipoMovimCajaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('belTipoMovimCajaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('belTipoMovimCaja')) belTipoMovimCajaCmdRequery();
}

function belTipoMovimCajaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('belTipoMovimCajaFrm', true);	
}

function belTipoMovimCajaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('belTipoMovimCajaFrm', true);
}

function belTipoMovimCajaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('belTipoMovimCajaFrm.codCaja','S', GestionarMensaje('BelTipoMovimCaja.codCaja.requiered.message'));
	
	setMV('belTipoMovimCajaFrm.desTipoMoviCaja','S', GestionarMensaje('BelTipoMovimCaja.desTipoMoviCaja.requiered.message'));
	
	setMV('belTipoMovimCajaFrm.valSign','S', GestionarMensaje('BelTipoMovimCaja.valSign.requiered.message'));
	
	setMV('belTipoMovimCajaFrm.indAuto','S', GestionarMensaje('BelTipoMovimCaja.indAuto.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('belTipoMovimCajaFrm', true);
}

function belTipoMovimCajaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('belTipoMovimCajaFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		belTipoMovimCajaTmpUpdateValues = belTipoMovimCajaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('belTipoMovimCajaFrm.codCaja','S', GestionarMensaje('BelTipoMovimCaja.codCaja.requiered.message'));
		setMV('belTipoMovimCajaFrm.desTipoMoviCaja','S', GestionarMensaje('BelTipoMovimCaja.desTipoMoviCaja.requiered.message'));
		setMV('belTipoMovimCajaFrm.valSign','S', GestionarMensaje('BelTipoMovimCaja.valSign.requiered.message'));
		setMV('belTipoMovimCajaFrm.indAuto','S', GestionarMensaje('BelTipoMovimCaja.indAuto.requiered.message'));
		
			focusFirstFieldModify('belTipoMovimCajaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('belTipoMovimCajaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('belTipoMovimCajaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function belTipoMovimCajaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	belTipoMovimCajaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('belTipoMovimCajaFrm', true);
}

function belTipoMovimCajaLovInitComponents(){
	belTipoMovimCajaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('belTipoMovimCajaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function belTipoMovimCajaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('belTipoMovimCajaFrm.' + campo, id);
	set('belTipoMovimCajaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function belTipoMovimCajaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	belTipoMovimCajaLovReturnParameters.id = '';
	belTipoMovimCajaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function belTipoMovimCajaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimCajaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = belTipoMovimCajaList.codSeleccionados();
	var descripcion = belTipoMovimCajaList.extraeDato(
		belTipoMovimCajaList.codSeleccionados()[0], belTipoMovimCajaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	belTipoMovimCajaLovReturnParameters.id = codigo;
	belTipoMovimCajaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function belTipoMovimCajaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('belTipoMovimCajaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('belTipoMovimCajaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "belTipoMovimCajaList", "BelTipoMovimCajaConectorTransactionQuery", 
		"result_ROWSET", parametros, "belTipoMovimCajaPostQueryActions(datos);"]], "", "");	
}

function belTipoMovimCajaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('belTipoMovimCajaFrm.lastQueryToSession'));
	var i =0;
	set('belTipoMovimCajaFrm.codCaja', paramsRequery.ij(i++));
	
	set('belTipoMovimCajaFrm.desTipoMoviCaja', paramsRequery.ij(i++));
	
	set('belTipoMovimCajaFrm.valSign', [paramsRequery.ij(i++)]);
	
	set('belTipoMovimCajaFrm.indAuto', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	belTipoMovimCajaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	belTipoMovimCajaCmdQuery(belTipoMovimCajaPageCount);
}

function belTipoMovimCajaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	belTipoMovimCajaPageCount = 1;
	belTipoMovimCajaCmdQuery(belTipoMovimCajaPageCount);
}

function belTipoMovimCajaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belTipoMovimCajaLastQuery){
		belTipoMovimCajaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	belTipoMovimCajaPageCount--;
	belTipoMovimCajaCmdQuery(belTipoMovimCajaPageCount);
}

function belTipoMovimCajaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belTipoMovimCajaLastQuery){
		belTipoMovimCajaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	belTipoMovimCajaPageCount++;
	belTipoMovimCajaCmdQuery(belTipoMovimCajaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function belTipoMovimCajaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('belTipoMovimCajaListLayer', 'O');
		visibilidad('belTipoMovimCajaListButtonsLayer', 'O');
		if(get('belTipoMovimCajaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	belTipoMovimCajaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case '+': datosTmp.ij2(GestionarMensaje('BelTipoMovimCaja.valSign.+.value'), i, 3); break;
			case '-': datosTmp.ij2(GestionarMensaje('BelTipoMovimCaja.valSign.-.value'), i, 3); break;
			case '+-': datosTmp.ij2(GestionarMensaje('BelTipoMovimCaja.valSign.+-.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case 'M': datosTmp.ij2(GestionarMensaje('BelTipoMovimCaja.indAuto.M.value'), i, 4); break;
			case 'A': datosTmp.ij2(GestionarMensaje('BelTipoMovimCaja.indAuto.A.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:belTipoMovimCajaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, belTipoMovimCajaChoiceColumn) + "</A>",
			i, belTipoMovimCajaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	belTipoMovimCajaList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	belTipoMovimCajaTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		belTipoMovimCajaMorePagesFlag = true;
		belTipoMovimCajaList.eliminar(mmgPageSize, 1);
	}else{
		belTipoMovimCajaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('belTipoMovimCajaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('belTipoMovimCajaListLayer', 'V');
	visibilidad('belTipoMovimCajaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('belTipoMovimCajaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	belTipoMovimCajaList.display();
	
	//Actualizamos el estado de los botones 
	if(belTipoMovimCajaMorePagesFlag){
		set_estado_botonera('belTipoMovimCajaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('belTipoMovimCajaPaginationButtonBar',
			3,"inactivo");
	}
	if(belTipoMovimCajaPageCount > 1){
		set_estado_botonera('belTipoMovimCajaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('belTipoMovimCajaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('belTipoMovimCajaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('belTipoMovimCajaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function belTipoMovimCajaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimCajaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('belTipoMovimCajaFrm.idSelection', belTipoMovimCajaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('belTipoMovimCajaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = belTipoMovimCajaList.codSeleccionados()[0];
		parametros["previousAction"] = get('belTipoMovimCajaFrm.accion');
		parametros["accion"] = get('belTipoMovimCajaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('BelTipoMovimCajaLPStartUp', get('belTipoMovimCajaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) belTipoMovimCajaCmdRequery();
	}
}

function belTipoMovimCajaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimCajaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = belTipoMovimCajaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('belTipoMovimCajaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(belTipoMovimCajaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += belTipoMovimCajaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('belTipoMovimCajaFrm.timestamp', timestamps);


	belTipoMovimCajaFrm.oculto='S';
	envia('belTipoMovimCajaFrm');
	belTipoMovimCajaFrm.oculto='N';
}

function belTipoMovimCajaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimCajaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	belTipoMovimCajaViewDetail(belTipoMovimCajaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function belTipoMovimCajaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('belTipoMovimCajaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('BelTipoMovimCajaLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('belTipoMovimCajaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		belTipoMovimCajaFrm.oculto='S';
		envia('belTipoMovimCajaFrm');
		belTipoMovimCajaFrm.oculto='N';
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
	belTipoMovimCajaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('belTipoMovimCajaFrm.accion');
	var origenTmp = get('belTipoMovimCajaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(belTipoMovimCajaBuildUpdateRecordString() != belTipoMovimCajaTmpUpdateValues){
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
	document.all.belTipoMovimCajaListLayer.style.display='none';
	document.all.belTipoMovimCajaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.belTipoMovimCajaListLayer.style.display='';
	document.all.belTipoMovimCajaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsBelTipoMovimCajaCodCaja = get('belTipoMovimCajaFrm.codCaja').toString();
	jsBelTipoMovimCajaDesTipoMoviCaja = get('belTipoMovimCajaFrm.desTipoMoviCaja').toString();
	jsBelTipoMovimCajaValSign = get('belTipoMovimCajaFrm.valSign')[0];
	jsBelTipoMovimCajaIndAuto = get('belTipoMovimCajaFrm.indAuto')[0];
	
	
	var parametros = "";
	parametros += jsBelTipoMovimCajaCodCaja + "|";
	parametros += jsBelTipoMovimCajaDesTipoMoviCaja + "|";
	parametros += jsBelTipoMovimCajaValSign + "|";
	parametros += jsBelTipoMovimCajaIndAuto + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function belTipoMovimCajaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsBelTipoMovimCajaCodCaja + "|";
	parametros += jsBelTipoMovimCajaDesTipoMoviCaja + "|";
	parametros += jsBelTipoMovimCajaValSign + "|";
	parametros += jsBelTipoMovimCajaIndAuto + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belTipoMovimCajaFrm.accion'), 
		get('belTipoMovimCajaFrm.origen'));
	
	jsBelTipoMovimCajaId = get('belTipoMovimCajaFrm.id').toString();
	jsBelTipoMovimCajaCodCaja = get('belTipoMovimCajaFrm.codCaja').toString();
	jsBelTipoMovimCajaDesTipoMoviCaja = get('belTipoMovimCajaFrm.desTipoMoviCaja').toString();
	jsBelTipoMovimCajaValSign = get('belTipoMovimCajaFrm.valSign')[0];
	jsBelTipoMovimCajaIndAuto = get('belTipoMovimCajaFrm.indAuto')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belTipoMovimCajaFrm.accion'), 
		get('belTipoMovimCajaFrm.origen'));


	set('belTipoMovimCajaFrm.id', jsBelTipoMovimCajaId);
	set('belTipoMovimCajaFrm.codCaja', jsBelTipoMovimCajaCodCaja);
	set('belTipoMovimCajaFrm.desTipoMoviCaja', jsBelTipoMovimCajaDesTipoMoviCaja);
	set('belTipoMovimCajaFrm.valSign', [jsBelTipoMovimCajaValSign]);
	set('belTipoMovimCajaFrm.indAuto', [jsBelTipoMovimCajaIndAuto]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsBelTipoMovimCajaCodCaja = '';
	jsBelTipoMovimCajaDesTipoMoviCaja = '';
	jsBelTipoMovimCajaValSign = '';
	jsBelTipoMovimCajaIndAuto = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('belTipoMovimCajaFrm.errCodigo', errorCode);
	set('belTipoMovimCajaFrm.errDescripcion', description);
	set('belTipoMovimCajaFrm.errSeverity', severity);
	fMostrarMensajeError();
}
