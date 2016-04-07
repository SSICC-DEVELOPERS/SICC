

/*
    INDRA/CAR/mmg
    $Id: preindiccuadrtipoestra.js,v 1.1 2009/12/03 19:02:29 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPreIndicCuadrTipoEstraId = "";
var jsPreIndicCuadrTipoEstraIndcOidIndiCuad = "";
var jsPreIndicCuadrTipoEstraTiesOidTipoEstr = "";
var jsPreIndicCuadrTipoEstraIndOferMonoGrup = "";

//Variables de paginacion, 
var preIndicCuadrTipoEstraPageCount = 1;

//Varible de columna que representa el campo de choice
var preIndicCuadrTipoEstraChoiceColumn = 3;

//Flag de siguiente pagina;
var preIndicCuadrTipoEstraMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var preIndicCuadrTipoEstraTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var preIndicCuadrTipoEstraLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','focalizaComboDependence("preIndicCuadrTipoEstra","indcOidIndiCuad", false);','focalizaComboDependence("preIndicCuadrTipoEstra","indcOidIndiCuad", false);','','focalizaComboDependence("preIndicCuadrTipoEstra","indcOidIndiCuad", true);','focalizaComboDependence("preIndicCuadrTipoEstra","indcOidIndiCuad", true);'],[3,'focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", false);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", false);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", false);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", true);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", true);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", true);'],[4,'','focaliza("preIndicCuadrTipoEstraFrm.indOferMonoGrup");','focaliza("preIndicCuadrTipoEstraFrm.indOferMonoGrup");','','focaliza("preIndicCuadrTipoEstraFrm.indOferMonoGrup");','focaliza("preIndicCuadrTipoEstraFrm.indOferMonoGrup");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','focalizaComboDependence("preIndicCuadrTipoEstra","indcOidIndiCuad", false);','focalizaComboDependence("preIndicCuadrTipoEstra","indcOidIndiCuad", false);','','focalizaComboDependence("preIndicCuadrTipoEstra","indcOidIndiCuad", true);','focalizaComboDependence("preIndicCuadrTipoEstra","indcOidIndiCuad", true);'],[3,'focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", false);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", false);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", false);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", true);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", true);','focalizaComboDependence("preIndicCuadrTipoEstra","tiesOidTipoEstr", true);'],[4,'','focaliza("preIndicCuadrTipoEstraFrm.indOferMonoGrup");','focaliza("preIndicCuadrTipoEstraFrm.indOferMonoGrup");','','focaliza("preIndicCuadrTipoEstraFrm.indOferMonoGrup");','focaliza("preIndicCuadrTipoEstraFrm.indOferMonoGrup");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var indcOidIndiCuadDependeceMap = new Vector();
indcOidIndiCuadDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
indcOidIndiCuadDependeceMap.agregar(['indcOidIndiCuad', padresTmp, '', 'PreIndicCuadr']);
var tiesOidTipoEstrDependeceMap = new Vector();
tiesOidTipoEstrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tiesOidTipoEstrDependeceMap.agregar(['tiesOidTipoEstr', padresTmp, '', 'PreTipoEstra']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
preIndicCuadrTipoEstraLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var preIndicCuadrTipoEstraTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function preIndicCuadrTipoEstraInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('preIndicCuadrTipoEstraFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('preIndicCuadrTipoEstraFrm.accion')){
		case "query": preIndicCuadrTipoEstraQueryInitComponents(); break;
		case "view": preIndicCuadrTipoEstraViewInitComponents(); break;
		case "create": preIndicCuadrTipoEstraCreateInitComponents(); break;
		case "update": preIndicCuadrTipoEstraUpdateInitComponents(); break;
		case "remove": preIndicCuadrTipoEstraRemoveInitComponents(); break;
		case "lov": preIndicCuadrTipoEstraLovInitComponents(); break;
	}
	//alert('accion :' + get('preIndicCuadrTipoEstraFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('preIndicCuadrTipoEstraFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('preIndicCuadrTipoEstra')) preIndicCuadrTipoEstraCmdRequery();
}

function preIndicCuadrTipoEstraQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	focusFirstField('preIndicCuadrTipoEstraFrm', true);	
}

function preIndicCuadrTipoEstraViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('preIndicCuadrTipoEstraFrm', true);
}

function preIndicCuadrTipoEstraCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('preIndicCuadrTipoEstraFrm.indcOidIndiCuad','S', GestionarMensaje('PreIndicCuadrTipoEstra.indcOidIndiCuad.requiered.message'));
	
	setMV('preIndicCuadrTipoEstraFrm.tiesOidTipoEstr','S', GestionarMensaje('PreIndicCuadrTipoEstra.tiesOidTipoEstr.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('preIndicCuadrTipoEstraFrm', true);
}

function preIndicCuadrTipoEstraUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('preIndicCuadrTipoEstraFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		preIndicCuadrTipoEstraTmpUpdateValues = preIndicCuadrTipoEstraBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('preIndicCuadrTipoEstraFrm.indcOidIndiCuad','S', GestionarMensaje('PreIndicCuadrTipoEstra.indcOidIndiCuad.requiered.message'));
		setMV('preIndicCuadrTipoEstraFrm.tiesOidTipoEstr','S', GestionarMensaje('PreIndicCuadrTipoEstra.tiesOidTipoEstr.requiered.message'));
		
			focusFirstFieldModify('preIndicCuadrTipoEstraFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		focusFirstField('preIndicCuadrTipoEstraFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('preIndicCuadrTipoEstraFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function preIndicCuadrTipoEstraRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	preIndicCuadrTipoEstraList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('preIndicCuadrTipoEstraFrm', true);
}

function preIndicCuadrTipoEstraLovInitComponents(){
	preIndicCuadrTipoEstraLovReturnParameters = window.dialogArguments;
	
	focusFirstField('preIndicCuadrTipoEstraFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function preIndicCuadrTipoEstraSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('preIndicCuadrTipoEstraFrm.' + campo, id);
	set('preIndicCuadrTipoEstraFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function preIndicCuadrTipoEstraLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	preIndicCuadrTipoEstraLovReturnParameters.id = '';
	preIndicCuadrTipoEstraLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function preIndicCuadrTipoEstraLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preIndicCuadrTipoEstraList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = preIndicCuadrTipoEstraList.codSeleccionados();
	var descripcion = preIndicCuadrTipoEstraList.extraeDato(
		preIndicCuadrTipoEstraList.codSeleccionados()[0], preIndicCuadrTipoEstraChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	preIndicCuadrTipoEstraLovReturnParameters.id = codigo;
	preIndicCuadrTipoEstraLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function preIndicCuadrTipoEstraCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('preIndicCuadrTipoEstraFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('preIndicCuadrTipoEstraFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "preIndicCuadrTipoEstraList", "PreIndicCuadrTipoEstraConectorTransactionQuery", 
		"result_ROWSET", parametros, "preIndicCuadrTipoEstraPostQueryActions(datos);"]], "", "");	
}

function preIndicCuadrTipoEstraCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('preIndicCuadrTipoEstraFrm.lastQueryToSession'));
	var i =0;
	set('preIndicCuadrTipoEstraFrm.tiesOidTipoEstr', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	preIndicCuadrTipoEstraPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	preIndicCuadrTipoEstraCmdQuery(preIndicCuadrTipoEstraPageCount);
}

function preIndicCuadrTipoEstraFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	preIndicCuadrTipoEstraPageCount = 1;
	preIndicCuadrTipoEstraCmdQuery(preIndicCuadrTipoEstraPageCount);
}

function preIndicCuadrTipoEstraPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preIndicCuadrTipoEstraLastQuery){
		preIndicCuadrTipoEstraFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	preIndicCuadrTipoEstraPageCount--;
	preIndicCuadrTipoEstraCmdQuery(preIndicCuadrTipoEstraPageCount);
}

function preIndicCuadrTipoEstraNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preIndicCuadrTipoEstraLastQuery){
		preIndicCuadrTipoEstraFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	preIndicCuadrTipoEstraPageCount++;
	preIndicCuadrTipoEstraCmdQuery(preIndicCuadrTipoEstraPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function preIndicCuadrTipoEstraPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('preIndicCuadrTipoEstraListLayer', 'O');
		visibilidad('preIndicCuadrTipoEstraListButtonsLayer', 'O');
		if(get('preIndicCuadrTipoEstraFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	preIndicCuadrTipoEstraLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 3) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 3);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 3);
		}
	}
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:preIndicCuadrTipoEstraViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, preIndicCuadrTipoEstraChoiceColumn) + "</A>",
			i, preIndicCuadrTipoEstraChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	preIndicCuadrTipoEstraList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	preIndicCuadrTipoEstraTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		preIndicCuadrTipoEstraMorePagesFlag = true;
		preIndicCuadrTipoEstraList.eliminar(mmgPageSize, 1);
	}else{
		preIndicCuadrTipoEstraMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('preIndicCuadrTipoEstraFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('preIndicCuadrTipoEstraListLayer', 'V');
	visibilidad('preIndicCuadrTipoEstraListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('preIndicCuadrTipoEstraList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	preIndicCuadrTipoEstraList.display();
	
	//Actualizamos el estado de los botones 
	if(preIndicCuadrTipoEstraMorePagesFlag){
		set_estado_botonera('preIndicCuadrTipoEstraPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('preIndicCuadrTipoEstraPaginationButtonBar',
			3,"inactivo");
	}
	if(preIndicCuadrTipoEstraPageCount > 1){
		set_estado_botonera('preIndicCuadrTipoEstraPaginationButtonBar',
			2,"activo");
		set_estado_botonera('preIndicCuadrTipoEstraPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('preIndicCuadrTipoEstraPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('preIndicCuadrTipoEstraPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function preIndicCuadrTipoEstraUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preIndicCuadrTipoEstraList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('preIndicCuadrTipoEstraFrm.idSelection', preIndicCuadrTipoEstraList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('preIndicCuadrTipoEstraFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = preIndicCuadrTipoEstraList.codSeleccionados()[0];
		parametros["previousAction"] = get('preIndicCuadrTipoEstraFrm.accion');
		parametros["accion"] = get('preIndicCuadrTipoEstraFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PreIndicCuadrTipoEstraLPStartUp', get('preIndicCuadrTipoEstraFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) preIndicCuadrTipoEstraCmdRequery();
	}
}

function preIndicCuadrTipoEstraRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preIndicCuadrTipoEstraList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = preIndicCuadrTipoEstraList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('preIndicCuadrTipoEstraFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(preIndicCuadrTipoEstraList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += preIndicCuadrTipoEstraTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('preIndicCuadrTipoEstraFrm.timestamp', timestamps);


	preIndicCuadrTipoEstraFrm.oculto='S';
	envia('preIndicCuadrTipoEstraFrm');
	preIndicCuadrTipoEstraFrm.oculto='N';
}

function preIndicCuadrTipoEstraViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preIndicCuadrTipoEstraList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	preIndicCuadrTipoEstraViewDetail(preIndicCuadrTipoEstraList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function preIndicCuadrTipoEstraViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('preIndicCuadrTipoEstraFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PreIndicCuadrTipoEstraLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('preIndicCuadrTipoEstraFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion){
		preIndicCuadrTipoEstraFrm.oculto='S';
		envia('preIndicCuadrTipoEstraFrm');
		preIndicCuadrTipoEstraFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('preIndicCuadrTipoEstraFrm.indcOidIndiCuad').toString() == ''){
		set('preIndicCuadrTipoEstraFrm.indcOidIndiCuad', []);
		mmgResetCombosOnCascade('indcOidIndiCuad', 'indcOidIndiCuad', 'preIndicCuadrTipoEstra');
		
	}
	if(get('preIndicCuadrTipoEstraFrm.tiesOidTipoEstr').toString() == ''){
		set('preIndicCuadrTipoEstraFrm.tiesOidTipoEstr', []);
		mmgResetCombosOnCascade('tiesOidTipoEstr', 'tiesOidTipoEstr', 'preIndicCuadrTipoEstra');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	preIndicCuadrTipoEstraRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('preIndicCuadrTipoEstraFrm.accion');
	var origenTmp = get('preIndicCuadrTipoEstraFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(preIndicCuadrTipoEstraBuildUpdateRecordString() != preIndicCuadrTipoEstraTmpUpdateValues){
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
	document.all.preIndicCuadrTipoEstraListLayer.style.display='none';
	document.all.preIndicCuadrTipoEstraListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.preIndicCuadrTipoEstraListLayer.style.display='';
	document.all.preIndicCuadrTipoEstraListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPreIndicCuadrTipoEstraTiesOidTipoEstr = get('preIndicCuadrTipoEstraFrm.tiesOidTipoEstr')[0];
	
	
	var parametros = "";
	parametros += jsPreIndicCuadrTipoEstraTiesOidTipoEstr + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function preIndicCuadrTipoEstraBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPreIndicCuadrTipoEstraIndcOidIndiCuad + "|";
	parametros += jsPreIndicCuadrTipoEstraTiesOidTipoEstr + "|";
	parametros += jsPreIndicCuadrTipoEstraIndOferMonoGrup + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preIndicCuadrTipoEstraFrm.accion'), 
		get('preIndicCuadrTipoEstraFrm.origen'));
	
	jsPreIndicCuadrTipoEstraId = get('preIndicCuadrTipoEstraFrm.id').toString();
	jsPreIndicCuadrTipoEstraIndcOidIndiCuad = get('preIndicCuadrTipoEstraFrm.indcOidIndiCuad')[0];
	jsPreIndicCuadrTipoEstraTiesOidTipoEstr = get('preIndicCuadrTipoEstraFrm.tiesOidTipoEstr')[0];
	if(get('preIndicCuadrTipoEstraFrm.indOferMonoGrup').toString() == 'S') jsPreIndicCuadrTipoEstraIndOferMonoGrup = "true";
		else jsPreIndicCuadrTipoEstraIndOferMonoGrup = "false";
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preIndicCuadrTipoEstraFrm.accion'), 
		get('preIndicCuadrTipoEstraFrm.origen'));


	set('preIndicCuadrTipoEstraFrm.id', jsPreIndicCuadrTipoEstraId);
	set('preIndicCuadrTipoEstraFrm.indcOidIndiCuad', [jsPreIndicCuadrTipoEstraIndcOidIndiCuad]);
	set('preIndicCuadrTipoEstraFrm.tiesOidTipoEstr', [jsPreIndicCuadrTipoEstraTiesOidTipoEstr]);
	
			
			if(jsPreIndicCuadrTipoEstraIndOferMonoGrup == "true") set('preIndicCuadrTipoEstraFrm.indOferMonoGrup', 'S');
			else set('preIndicCuadrTipoEstraFrm.indOferMonoGrup', 'N');
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPreIndicCuadrTipoEstraTiesOidTipoEstr = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('preIndicCuadrTipoEstraFrm.errCodigo', errorCode);
	set('preIndicCuadrTipoEstraFrm.errDescripcion', description);
	set('preIndicCuadrTipoEstraFrm.errSeverity', severity);
	fMostrarMensajeError();
}
