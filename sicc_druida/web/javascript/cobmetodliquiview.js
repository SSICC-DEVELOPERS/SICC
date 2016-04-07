

/*
    INDRA/CAR/mmg
    $Id: cobmetodliquiview.js,v 1.1 2009/12/03 19:02:18 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobMetodLiquiViewId = "";
var jsCobMetodLiquiViewCodMetoLiqu = "";
var jsCobMetodLiquiViewValDescMetoLiqu = "";
var jsCobMetodLiquiViewIndLiqu = "";
var jsCobMetodLiquiViewIndLiquGrupUsua = "";
var jsCobMetodLiquiViewBaesOidBaseEsca = "";
var jsCobMetodLiquiViewPaisOidPais = "";

//Variables de paginacion, 
var cobMetodLiquiViewPageCount = 1;

//Varible de columna que representa el campo de choice
var cobMetodLiquiViewChoiceColumn = 1;

//Flag de siguiente pagina;
var cobMetodLiquiViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobMetodLiquiViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 273;
var sizeFormView = 221;
var sizeFormUpdate = 267;

//Ultima busqueda realizada
var cobMetodLiquiViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cobMetodLiquiViewFrm.codMetoLiqu");','focaliza("cobMetodLiquiViewFrm.codMetoLiqu");','focaliza("cobMetodLiquiViewFrm.codMetoLiqu");','focaliza("cobMetodLiquiViewFrm.codMetoLiqu");','focaliza("cobMetodLiquiViewFrm.codMetoLiqu");','focaliza("cobMetodLiquiViewFrm.codMetoLiqu");'],[3,'focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");'],[4,'focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");'],[5,'focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");'],[7,'focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", true);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", true);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", true);'],[8,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");','focaliza("cobMetodLiquiViewFrm.valDescMetoLiqu");'],[4,'focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");','focaliza("cobMetodLiquiViewFrm.indLiqu");'],[5,'focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");','focaliza("cobMetodLiquiViewFrm.indLiquGrupUsua");'],[7,'focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", false);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", true);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", true);','focalizaComboDependence("cobMetodLiquiView","baesOidBaseEsca", true);'],[8,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var baesOidBaseEscaDependeceMap = new Vector();
baesOidBaseEscaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
baesOidBaseEscaDependeceMap.agregar(['baesOidBaseEsca', padresTmp, '', 'CobBaseEscal']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cobMetodLiquiViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cobMetodLiquiViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cobMetodLiquiViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cobMetodLiquiViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cobMetodLiquiViewFrm.accion')){
		case "query": cobMetodLiquiViewQueryInitComponents(); break;
		case "view": cobMetodLiquiViewViewInitComponents(); break;
		case "create": cobMetodLiquiViewCreateInitComponents(); break;
		case "update": cobMetodLiquiViewUpdateInitComponents(); break;
		case "remove": cobMetodLiquiViewRemoveInitComponents(); break;
		case "lov": cobMetodLiquiViewLovInitComponents(); break;
	}
	//alert('accion :' + get('cobMetodLiquiViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobMetodLiquiViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobMetodLiquiView')) cobMetodLiquiViewCmdRequery();
}

function cobMetodLiquiViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	focusFirstField('cobMetodLiquiViewFrm', true);	
}

function cobMetodLiquiViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('cobMetodLiquiViewFrm.indLiqu', get('cobMetodLiquiViewFrm.indLiquCheckValue'));
		set('cobMetodLiquiViewFrm.indLiquGrupUsua', get('cobMetodLiquiViewFrm.indLiquGrupUsuaCheckValue'));
		
	focusFirstField('cobMetodLiquiViewFrm', true);
}

function cobMetodLiquiViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobMetodLiquiViewFrm.codMetoLiqu','S', GestionarMensaje('CobMetodLiquiView.codMetoLiqu.requiered.message'));
	
	setMV('cobMetodLiquiViewFrm.valDescMetoLiqu','S', GestionarMensaje('CobMetodLiquiView.valDescMetoLiqu.requiered.message'));
	
	setMV('cobMetodLiquiViewFrm.indLiqu','S', GestionarMensaje('CobMetodLiquiView.indLiqu.requiered.message'));
	
	setMV('cobMetodLiquiViewFrm.indLiquGrupUsua','S', GestionarMensaje('CobMetodLiquiView.indLiquGrupUsua.requiered.message'));
	
	setMV('cobMetodLiquiViewFrm.baesOidBaseEsca','S', GestionarMensaje('CobMetodLiquiView.baesOidBaseEsca.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobMetodLiquiViewFrm', true);
}

function cobMetodLiquiViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cobMetodLiquiViewFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('cobMetodLiquiViewFrm.indLiqu', get('cobMetodLiquiViewFrm.indLiquCheckValue'));
			set('cobMetodLiquiViewFrm.indLiquGrupUsua', get('cobMetodLiquiViewFrm.indLiquGrupUsuaCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		cobMetodLiquiViewTmpUpdateValues = cobMetodLiquiViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobMetodLiquiViewFrm.codMetoLiqu','S', GestionarMensaje('CobMetodLiquiView.codMetoLiqu.requiered.message'));
		setMV('cobMetodLiquiViewFrm.valDescMetoLiqu','S', GestionarMensaje('CobMetodLiquiView.valDescMetoLiqu.requiered.message'));
		setMV('cobMetodLiquiViewFrm.indLiqu','S', GestionarMensaje('CobMetodLiquiView.indLiqu.requiered.message'));
		setMV('cobMetodLiquiViewFrm.indLiquGrupUsua','S', GestionarMensaje('CobMetodLiquiView.indLiquGrupUsua.requiered.message'));
		setMV('cobMetodLiquiViewFrm.baesOidBaseEsca','S', GestionarMensaje('CobMetodLiquiView.baesOidBaseEsca.requiered.message'));
		
			focusFirstFieldModify('cobMetodLiquiViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		focusFirstField('cobMetodLiquiViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cobMetodLiquiViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobMetodLiquiViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cobMetodLiquiViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobMetodLiquiViewFrm', true);
}

function cobMetodLiquiViewLovInitComponents(){
	cobMetodLiquiViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobMetodLiquiViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Función que permite cargar los datos de un elemento de lov seleccionado
function cobMetodLiquiViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobMetodLiquiViewFrm.' + campo, id);
	set('cobMetodLiquiViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cobMetodLiquiViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobMetodLiquiViewLovReturnParameters.id = '';
	cobMetodLiquiViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobMetodLiquiViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobMetodLiquiViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobMetodLiquiViewList.codSeleccionados();
	var descripcion = cobMetodLiquiViewList.extraeDato(
		cobMetodLiquiViewList.codSeleccionados()[0], cobMetodLiquiViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobMetodLiquiViewLovReturnParameters.id = codigo;
	cobMetodLiquiViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cobMetodLiquiViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobMetodLiquiViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cobMetodLiquiViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobMetodLiquiViewList", "CobMetodLiquiViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobMetodLiquiViewPostQueryActions(datos);"]], "", "");	
}

function cobMetodLiquiViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobMetodLiquiViewFrm.lastQueryToSession'));
	var i =0;
	set('cobMetodLiquiViewFrm.codMetoLiqu', paramsRequery.ij(i++));
	
	set('cobMetodLiquiViewFrm.valDescMetoLiqu', paramsRequery.ij(i++));
	
	set('cobMetodLiquiViewFrm.indLiqu', paramsRequery.ij(i++));
	
	set('cobMetodLiquiViewFrm.indLiquGrupUsua', paramsRequery.ij(i++));
	
	set('cobMetodLiquiViewFrm.baesOidBaseEsca', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	cobMetodLiquiViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobMetodLiquiViewCmdQuery(cobMetodLiquiViewPageCount);
}

function cobMetodLiquiViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobMetodLiquiViewPageCount = 1;
	cobMetodLiquiViewCmdQuery(cobMetodLiquiViewPageCount);
}

function cobMetodLiquiViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobMetodLiquiViewLastQuery){
		cobMetodLiquiViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobMetodLiquiViewPageCount--;
	cobMetodLiquiViewCmdQuery(cobMetodLiquiViewPageCount);
}

function cobMetodLiquiViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobMetodLiquiViewLastQuery){
		cobMetodLiquiViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobMetodLiquiViewPageCount++;
	cobMetodLiquiViewCmdQuery(cobMetodLiquiViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobMetodLiquiViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobMetodLiquiViewListLayer', 'O');
		visibilidad('cobMetodLiquiViewListButtonsLayer', 'O');
		if(get('cobMetodLiquiViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cobMetodLiquiViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobMetodLiquiViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobMetodLiquiViewChoiceColumn) + "</A>",
			i, cobMetodLiquiViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobMetodLiquiViewList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cobMetodLiquiViewTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cobMetodLiquiViewMorePagesFlag = true;
		cobMetodLiquiViewList.eliminar(mmgPageSize, 1);
	}else{
		cobMetodLiquiViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cobMetodLiquiViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobMetodLiquiViewListLayer', 'V');
	visibilidad('cobMetodLiquiViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobMetodLiquiViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobMetodLiquiViewList.display();
	
	//Actualizamos el estado de los botones 
	if(cobMetodLiquiViewMorePagesFlag){
		set_estado_botonera('cobMetodLiquiViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobMetodLiquiViewPaginationButtonBar',
			3,"inactivo");
	}
	if(cobMetodLiquiViewPageCount > 1){
		set_estado_botonera('cobMetodLiquiViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobMetodLiquiViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobMetodLiquiViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobMetodLiquiViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobMetodLiquiViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobMetodLiquiViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobMetodLiquiViewFrm.idSelection', cobMetodLiquiViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cobMetodLiquiViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobMetodLiquiViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobMetodLiquiViewFrm.accion');
		parametros["accion"] = get('cobMetodLiquiViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobMetodLiquiViewLPStartUp', get('cobMetodLiquiViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobMetodLiquiViewCmdRequery();
	}
}

function cobMetodLiquiViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobMetodLiquiViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobMetodLiquiViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobMetodLiquiViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobMetodLiquiViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobMetodLiquiViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobMetodLiquiViewFrm.timestamp', timestamps);


	cobMetodLiquiViewFrm.oculto='S';
	envia('cobMetodLiquiViewFrm');
	cobMetodLiquiViewFrm.oculto='N';
}

function cobMetodLiquiViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobMetodLiquiViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobMetodLiquiViewViewDetail(cobMetodLiquiViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cobMetodLiquiViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobMetodLiquiViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobMetodLiquiViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobMetodLiquiViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
		
	
	if(validacion){
		cobMetodLiquiViewFrm.oculto='S';
		envia('cobMetodLiquiViewFrm');
		cobMetodLiquiViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobMetodLiquiViewFrm.baesOidBaseEsca').toString() == ''){
		set('cobMetodLiquiViewFrm.baesOidBaseEsca', []);
		mmgResetCombosOnCascade('baesOidBaseEsca', 'baesOidBaseEsca', 'cobMetodLiquiView');
		
	}
	if(get('cobMetodLiquiViewFrm.paisOidPais').toString() == ''){
		set('cobMetodLiquiViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cobMetodLiquiView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cobMetodLiquiViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cobMetodLiquiViewFrm.accion');
	var origenTmp = get('cobMetodLiquiViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobMetodLiquiViewBuildUpdateRecordString() != cobMetodLiquiViewTmpUpdateValues){
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
	document.all.cobMetodLiquiViewListLayer.style.display='none';
	document.all.cobMetodLiquiViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobMetodLiquiViewListLayer.style.display='';
	document.all.cobMetodLiquiViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCobMetodLiquiViewCodMetoLiqu = get('cobMetodLiquiViewFrm.codMetoLiqu').toString();
	jsCobMetodLiquiViewValDescMetoLiqu = get('cobMetodLiquiViewFrm.valDescMetoLiqu').toString();
	jsCobMetodLiquiViewIndLiqu = get('cobMetodLiquiViewFrm.indLiqu');
	jsCobMetodLiquiViewIndLiquGrupUsua = get('cobMetodLiquiViewFrm.indLiquGrupUsua');
	jsCobMetodLiquiViewBaesOidBaseEsca = get('cobMetodLiquiViewFrm.baesOidBaseEsca')[0];
	
	
	var parametros = "";
	parametros += jsCobMetodLiquiViewCodMetoLiqu + "|";
	parametros += jsCobMetodLiquiViewValDescMetoLiqu + "|";
	parametros += jsCobMetodLiquiViewIndLiqu + "|";
	parametros += jsCobMetodLiquiViewIndLiquGrupUsua + "|";
	parametros += jsCobMetodLiquiViewBaesOidBaseEsca + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobMetodLiquiViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobMetodLiquiViewCodMetoLiqu + "|";
	parametros += jsCobMetodLiquiViewValDescMetoLiqu + "|";
	parametros += jsCobMetodLiquiViewIndLiqu + "|";
	parametros += jsCobMetodLiquiViewIndLiquGrupUsua + "|";
	parametros += jsCobMetodLiquiViewBaesOidBaseEsca + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobMetodLiquiViewFrm.accion'), 
		get('cobMetodLiquiViewFrm.origen'));
	
	jsCobMetodLiquiViewId = get('cobMetodLiquiViewFrm.id').toString();
	jsCobMetodLiquiViewCodMetoLiqu = get('cobMetodLiquiViewFrm.codMetoLiqu').toString();
	jsCobMetodLiquiViewValDescMetoLiqu = get('cobMetodLiquiViewFrm.valDescMetoLiqu').toString();
	jsCobMetodLiquiViewIndLiqu = get('cobMetodLiquiViewFrm.indLiqu');
	jsCobMetodLiquiViewIndLiquGrupUsua = get('cobMetodLiquiViewFrm.indLiquGrupUsua');
	jsCobMetodLiquiViewBaesOidBaseEsca = get('cobMetodLiquiViewFrm.baesOidBaseEsca')[0];
	jsCobMetodLiquiViewPaisOidPais = get('cobMetodLiquiViewFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobMetodLiquiViewFrm.accion'), 
		get('cobMetodLiquiViewFrm.origen'));


	set('cobMetodLiquiViewFrm.id', jsCobMetodLiquiViewId);
	set('cobMetodLiquiViewFrm.codMetoLiqu', jsCobMetodLiquiViewCodMetoLiqu);
	set('cobMetodLiquiViewFrm.valDescMetoLiqu', jsCobMetodLiquiViewValDescMetoLiqu);
	set('cobMetodLiquiViewFrm.indLiqu', jsCobMetodLiquiViewIndLiqu);
	set('cobMetodLiquiViewFrm.indLiquGrupUsua', jsCobMetodLiquiViewIndLiquGrupUsua);
	set('cobMetodLiquiViewFrm.baesOidBaseEsca', [jsCobMetodLiquiViewBaesOidBaseEsca]);
	set('cobMetodLiquiViewFrm.paisOidPais', [jsCobMetodLiquiViewPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCobMetodLiquiViewCodMetoLiqu = '';
	jsCobMetodLiquiViewValDescMetoLiqu = '';
	jsCobMetodLiquiViewIndLiqu = '';
	jsCobMetodLiquiViewIndLiquGrupUsua = '';
	jsCobMetodLiquiViewBaesOidBaseEsca = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobMetodLiquiViewFrm.errCodigo', errorCode);
	set('cobMetodLiquiViewFrm.errDescripcion', description);
	set('cobMetodLiquiViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
