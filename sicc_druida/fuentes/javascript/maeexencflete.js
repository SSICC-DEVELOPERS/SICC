

/*
    INDRA/CAR/mmg
    $Id: maeexencflete.js,v 1.1 2009/12/03 19:01:31 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeExencFleteId = "";
var jsMaeExencFletePaisOidPais = "";
var jsMaeExencFleteTiclOidTipoClie = "";
var jsMaeExencFleteSbtiOidSubtClie = "";
var jsMaeExencFleteTcclOidTipoClas = "";
var jsMaeExencFleteClasOidClas = "";
var jsMaeExencFleteIndExenFlet = "";

//Variables de paginacion, 
var maeExencFletePageCount = 1;

//Varible de columna que representa el campo de choice
var maeExencFleteChoiceColumn = 5;

//Flag de siguiente pagina;
var maeExencFleteMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeExencFleteTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var maeExencFleteLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focalizaComboDependence("maeExencFlete","ticlOidTipoClie", false);','focalizaComboDependence("maeExencFlete","ticlOidTipoClie", false);','focalizaComboDependence("maeExencFlete","ticlOidTipoClie", false);','focalizaComboDependence("maeExencFlete","ticlOidTipoClie", true);','focalizaComboDependence("maeExencFlete","ticlOidTipoClie", true);','focalizaComboDependence("maeExencFlete","ticlOidTipoClie", true);'],[4,'focalizaComboDependence("maeExencFlete","sbtiOidSubtClie", false);','focalizaComboDependence("maeExencFlete","sbtiOidSubtClie", false);','focalizaComboDependence("maeExencFlete","sbtiOidSubtClie", false);','focalizaComboDependence("maeExencFlete","sbtiOidSubtClie", true);','focalizaComboDependence("maeExencFlete","sbtiOidSubtClie", true);','focalizaComboDependence("maeExencFlete","sbtiOidSubtClie", true);'],[5,'focalizaComboDependence("maeExencFlete","tcclOidTipoClas", false);','focalizaComboDependence("maeExencFlete","tcclOidTipoClas", false);','focalizaComboDependence("maeExencFlete","tcclOidTipoClas", false);','focalizaComboDependence("maeExencFlete","tcclOidTipoClas", true);','focalizaComboDependence("maeExencFlete","tcclOidTipoClas", true);','focalizaComboDependence("maeExencFlete","tcclOidTipoClas", true);'],[6,'focalizaComboDependence("maeExencFlete","clasOidClas", false);','focalizaComboDependence("maeExencFlete","clasOidClas", false);','focalizaComboDependence("maeExencFlete","clasOidClas", false);','focalizaComboDependence("maeExencFlete","clasOidClas", true);','focalizaComboDependence("maeExencFlete","clasOidClas", true);','focalizaComboDependence("maeExencFlete","clasOidClas", true);'],[7,'focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[6,'focalizaComboDependence("maeExencFlete","clasOidClas", false);','focalizaComboDependence("maeExencFlete","clasOidClas", false);','focalizaComboDependence("maeExencFlete","clasOidClas", false);','focalizaComboDependence("maeExencFlete","clasOidClas", true);','focalizaComboDependence("maeExencFlete","clasOidClas", true);','focalizaComboDependence("maeExencFlete","clasOidClas", true);'],[7,'focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");','focaliza("maeExencFleteFrm.indExenFlet");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var ticlOidTipoClieDependeceMap = new Vector();
ticlOidTipoClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ticlOidTipoClieDependeceMap.agregar(['ticlOidTipoClie', padresTmp, '', 'MaeTipoClien']);
var sbtiOidSubtClieDependeceMap = new Vector();
sbtiOidSubtClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sbtiOidSubtClieDependeceMap.agregar(['sbtiOidSubtClie', padresTmp, '', 'MaeSubtiClienView']);
var tcclOidTipoClasDependeceMap = new Vector();
tcclOidTipoClasDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tcclOidTipoClasDependeceMap.agregar(['tcclOidTipoClas', padresTmp, '', 'MaeTipoClasiClienView']);
var clasOidClasDependeceMap = new Vector();
clasOidClasDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clasOidClasDependeceMap.agregar(['clasOidClas', padresTmp, '', 'MaeClasiView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeExencFleteLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeExencFleteTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeExencFleteInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeExencFleteFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeExencFleteFrm.accion')){
		case "query": maeExencFleteQueryInitComponents(); break;
		case "view": maeExencFleteViewInitComponents(); break;
		case "create": maeExencFleteCreateInitComponents(); break;
		case "update": maeExencFleteUpdateInitComponents(); break;
		case "remove": maeExencFleteRemoveInitComponents(); break;
		case "lov": maeExencFleteLovInitComponents(); break;
	}
	//alert('accion :' + get('maeExencFleteFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeExencFleteFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeExencFlete')) maeExencFleteCmdRequery();
}

function maeExencFleteQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	focusFirstField('maeExencFleteFrm', true);	
}

function maeExencFleteViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('maeExencFleteFrm.indExenFlet', get('maeExencFleteFrm.indExenFletCheckValue'));
		
	focusFirstField('maeExencFleteFrm', true);
}

function maeExencFleteCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeExencFleteFrm.ticlOidTipoClie','S', GestionarMensaje('MaeExencFlete.ticlOidTipoClie.requiered.message'));
	
	setMV('maeExencFleteFrm.indExenFlet','S', GestionarMensaje('MaeExencFlete.indExenFlet.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeExencFleteFrm', true);
}

function maeExencFleteUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeExencFleteFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('maeExencFleteFrm.indExenFlet', get('maeExencFleteFrm.indExenFletCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		maeExencFleteTmpUpdateValues = maeExencFleteBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeExencFleteFrm.ticlOidTipoClie','S', GestionarMensaje('MaeExencFlete.ticlOidTipoClie.requiered.message'));
		setMV('maeExencFleteFrm.indExenFlet','S', GestionarMensaje('MaeExencFlete.indExenFlet.requiered.message'));
		
			focusFirstFieldModify('maeExencFleteFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		focusFirstField('maeExencFleteFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeExencFleteFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeExencFleteRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeExencFleteList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeExencFleteFrm', true);
}

function maeExencFleteLovInitComponents(){
	maeExencFleteLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeExencFleteFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Función que permite cargar los datos de un elemento de lov seleccionado
function maeExencFleteSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeExencFleteFrm.' + campo, id);
	set('maeExencFleteFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeExencFleteLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeExencFleteLovReturnParameters.id = '';
	maeExencFleteLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeExencFleteLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeExencFleteList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeExencFleteList.codSeleccionados();
	var descripcion = maeExencFleteList.extraeDato(
		maeExencFleteList.codSeleccionados()[0], maeExencFleteChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeExencFleteLovReturnParameters.id = codigo;
	maeExencFleteLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeExencFleteCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeExencFleteFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeExencFleteFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeExencFleteList", "MaeExencFleteConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeExencFletePostQueryActions(datos);"]], "", "");	
}

function maeExencFleteCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeExencFleteFrm.lastQueryToSession'));
	var i =0;
	set('maeExencFleteFrm.ticlOidTipoClie', [paramsRequery.ij(i++)]);
	
	set('maeExencFleteFrm.sbtiOidSubtClie', [paramsRequery.ij(i++)]);
	
	set('maeExencFleteFrm.tcclOidTipoClas', [paramsRequery.ij(i++)]);
	
	set('maeExencFleteFrm.clasOidClas', [paramsRequery.ij(i++)]);
	
	set('maeExencFleteFrm.indExenFlet', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeExencFletePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeExencFleteCmdQuery(maeExencFletePageCount);
}

function maeExencFleteFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeExencFletePageCount = 1;
	maeExencFleteCmdQuery(maeExencFletePageCount);
}

function maeExencFletePreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeExencFleteLastQuery){
		maeExencFleteFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeExencFletePageCount--;
	maeExencFleteCmdQuery(maeExencFletePageCount);
}

function maeExencFleteNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeExencFleteLastQuery){
		maeExencFleteFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeExencFletePageCount++;
	maeExencFleteCmdQuery(maeExencFletePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeExencFletePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeExencFleteListLayer', 'O');
		visibilidad('maeExencFleteListButtonsLayer', 'O');
		if(get('maeExencFleteFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeExencFleteLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 5)){
			case '1': datosTmp.ij2(GestionarMensaje('MaeExencFlete.indExenFlet.1.value'), i, 5); break;
			case '0': datosTmp.ij2(GestionarMensaje('MaeExencFlete.indExenFlet.0.value'), i, 5); break;
			default: datosTmp .ij2('', i, 5);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeExencFleteViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeExencFleteChoiceColumn) + "</A>",
			i, maeExencFleteChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeExencFleteList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeExencFleteTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeExencFleteMorePagesFlag = true;
		maeExencFleteList.eliminar(mmgPageSize, 1);
	}else{
		maeExencFleteMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeExencFleteFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeExencFleteListLayer', 'V');
	visibilidad('maeExencFleteListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeExencFleteList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeExencFleteList.display();
	
	//Actualizamos el estado de los botones 
	if(maeExencFleteMorePagesFlag){
		set_estado_botonera('maeExencFletePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeExencFletePaginationButtonBar',
			3,"inactivo");
	}
	if(maeExencFletePageCount > 1){
		set_estado_botonera('maeExencFletePaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeExencFletePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeExencFletePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeExencFletePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeExencFleteUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeExencFleteList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeExencFleteFrm.idSelection', maeExencFleteList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeExencFleteFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeExencFleteList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeExencFleteFrm.accion');
		parametros["accion"] = get('maeExencFleteFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeExencFleteLPStartUp', get('maeExencFleteFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeExencFleteCmdRequery();
	}
}

function maeExencFleteRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeExencFleteList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeExencFleteList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeExencFleteFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeExencFleteList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeExencFleteTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeExencFleteFrm.timestamp', timestamps);


	maeExencFleteFrm.oculto='S';
	envia('maeExencFleteFrm');
	maeExencFleteFrm.oculto='N';
}

function maeExencFleteViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeExencFleteList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeExencFleteViewDetail(maeExencFleteList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeExencFleteViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeExencFleteFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeExencFleteLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('maeExencFleteFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
		
	
	if(validacion){
		maeExencFleteFrm.oculto='S';
		envia('maeExencFleteFrm');
		maeExencFleteFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeExencFleteFrm.paisOidPais').toString() == ''){
		set('maeExencFleteFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeExencFlete');
		
	}
	if(get('maeExencFleteFrm.ticlOidTipoClie').toString() == ''){
		set('maeExencFleteFrm.ticlOidTipoClie', []);
		mmgResetCombosOnCascade('ticlOidTipoClie', 'ticlOidTipoClie', 'maeExencFlete');
		
	}
	if(get('maeExencFleteFrm.sbtiOidSubtClie').toString() == ''){
		set('maeExencFleteFrm.sbtiOidSubtClie', []);
		mmgResetCombosOnCascade('sbtiOidSubtClie', 'sbtiOidSubtClie', 'maeExencFlete');
		
	}
	if(get('maeExencFleteFrm.tcclOidTipoClas').toString() == ''){
		set('maeExencFleteFrm.tcclOidTipoClas', []);
		mmgResetCombosOnCascade('tcclOidTipoClas', 'tcclOidTipoClas', 'maeExencFlete');
		
	}
	if(get('maeExencFleteFrm.clasOidClas').toString() == ''){
		set('maeExencFleteFrm.clasOidClas', []);
		mmgResetCombosOnCascade('clasOidClas', 'clasOidClas', 'maeExencFlete');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeExencFleteRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeExencFleteFrm.accion');
	var origenTmp = get('maeExencFleteFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeExencFleteBuildUpdateRecordString() != maeExencFleteTmpUpdateValues){
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
	document.all.maeExencFleteListLayer.style.display='none';
	document.all.maeExencFleteListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeExencFleteListLayer.style.display='';
	document.all.maeExencFleteListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeExencFleteTiclOidTipoClie = get('maeExencFleteFrm.ticlOidTipoClie')[0];
	jsMaeExencFleteSbtiOidSubtClie = get('maeExencFleteFrm.sbtiOidSubtClie')[0];
	jsMaeExencFleteTcclOidTipoClas = get('maeExencFleteFrm.tcclOidTipoClas')[0];
	jsMaeExencFleteClasOidClas = get('maeExencFleteFrm.clasOidClas')[0];
	jsMaeExencFleteIndExenFlet = get('maeExencFleteFrm.indExenFlet');
	
	
	var parametros = "";
	parametros += jsMaeExencFleteTiclOidTipoClie + "|";
	parametros += jsMaeExencFleteSbtiOidSubtClie + "|";
	parametros += jsMaeExencFleteTcclOidTipoClas + "|";
	parametros += jsMaeExencFleteClasOidClas + "|";
	parametros += jsMaeExencFleteIndExenFlet + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeExencFleteBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeExencFleteTiclOidTipoClie + "|";
	parametros += jsMaeExencFleteSbtiOidSubtClie + "|";
	parametros += jsMaeExencFleteTcclOidTipoClas + "|";
	parametros += jsMaeExencFleteClasOidClas + "|";
	parametros += jsMaeExencFleteIndExenFlet + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeExencFleteFrm.accion'), 
		get('maeExencFleteFrm.origen'));
	
	jsMaeExencFleteId = get('maeExencFleteFrm.id').toString();
	jsMaeExencFletePaisOidPais = get('maeExencFleteFrm.paisOidPais')[0];
	jsMaeExencFleteTiclOidTipoClie = get('maeExencFleteFrm.ticlOidTipoClie')[0];
	jsMaeExencFleteSbtiOidSubtClie = get('maeExencFleteFrm.sbtiOidSubtClie')[0];
	jsMaeExencFleteTcclOidTipoClas = get('maeExencFleteFrm.tcclOidTipoClas')[0];
	jsMaeExencFleteClasOidClas = get('maeExencFleteFrm.clasOidClas')[0];
	jsMaeExencFleteIndExenFlet = get('maeExencFleteFrm.indExenFlet');
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeExencFleteFrm.accion'), 
		get('maeExencFleteFrm.origen'));


	set('maeExencFleteFrm.id', jsMaeExencFleteId);
	set('maeExencFleteFrm.paisOidPais', [jsMaeExencFletePaisOidPais]);
	set('maeExencFleteFrm.ticlOidTipoClie', [jsMaeExencFleteTiclOidTipoClie]);
	set('maeExencFleteFrm.sbtiOidSubtClie', [jsMaeExencFleteSbtiOidSubtClie]);
	set('maeExencFleteFrm.tcclOidTipoClas', [jsMaeExencFleteTcclOidTipoClas]);
	set('maeExencFleteFrm.clasOidClas', [jsMaeExencFleteClasOidClas]);
	set('maeExencFleteFrm.indExenFlet', jsMaeExencFleteIndExenFlet);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeExencFleteTiclOidTipoClie = '';
	jsMaeExencFleteSbtiOidSubtClie = '';
	jsMaeExencFleteTcclOidTipoClas = '';
	jsMaeExencFleteClasOidClas = '';
	jsMaeExencFleteIndExenFlet = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeExencFleteFrm.errCodigo', errorCode);
	set('maeExencFleteFrm.errDescripcion', description);
	set('maeExencFleteFrm.errSeverity', severity);
	fMostrarMensajeError();
}
