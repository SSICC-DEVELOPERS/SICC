

/*
    INDRA/CAR/mmg
    $Id: maecodigclienanter.js,v 1.1 2009/12/03 19:01:30 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeCodigClienAnterId = "";
var jsMaeCodigClienAnterClieOidClieNuev = "";
var jsMaeCodigClienAnterCodClieAnti = "";
var jsMaeCodigClienAnterPaisOidPais = "";
var jsMaeCodigClienAnterValSistProc = "";

//Variables de paginacion, 
var maeCodigClienAnterPageCount = 1;

//Varible de columna que representa el campo de choice
var maeCodigClienAnterChoiceColumn = 4;

//Flag de siguiente pagina;
var maeCodigClienAnterMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeCodigClienAnterTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeCodigClienAnterLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeCodigClienAnter","clieOidClieNuev", false);','focalizaComboDependence("maeCodigClienAnter","clieOidClieNuev", false);','focalizaComboDependence("maeCodigClienAnter","clieOidClieNuev", false);','focalizaComboDependence("maeCodigClienAnter","clieOidClieNuev", true);','focalizaComboDependence("maeCodigClienAnter","clieOidClieNuev", true);','focalizaComboDependence("maeCodigClienAnter","clieOidClieNuev", true);'],[3,'focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");'],[4,'focalizaComboDependence("maeCodigClienAnter","paisOidPais", false);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", false);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", false);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", true);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", true);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", true);'],[5,'focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");','focaliza("maeCodigClienAnterFrm.codClieAnti");'],[4,'focalizaComboDependence("maeCodigClienAnter","paisOidPais", false);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", false);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", false);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", true);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", true);','focalizaComboDependence("maeCodigClienAnter","paisOidPais", true);'],[5,'focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");','focaliza("maeCodigClienAnterFrm.valSistProc");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var clieOidClieNuevDependeceMap = new Vector();
clieOidClieNuevDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieNuevDependeceMap.agregar(['clieOidClieNuev', padresTmp, '', 'MaeClien']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeCodigClienAnterLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeCodigClienAnterTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeCodigClienAnterInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeCodigClienAnterFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeCodigClienAnterFrm.accion')){
		case "query": maeCodigClienAnterQueryInitComponents(); break;
		case "view": maeCodigClienAnterViewInitComponents(); break;
		case "create": maeCodigClienAnterCreateInitComponents(); break;
		case "update": maeCodigClienAnterUpdateInitComponents(); break;
		case "remove": maeCodigClienAnterRemoveInitComponents(); break;
		case "lov": maeCodigClienAnterLovInitComponents(); break;
	}
	//alert('accion :' + get('maeCodigClienAnterFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeCodigClienAnterFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeCodigClienAnter')) maeCodigClienAnterCmdRequery();
}

function maeCodigClienAnterQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('maeCodigClienAnterFrm', true);	
}

function maeCodigClienAnterViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('maeCodigClienAnterFrm', true);
}

function maeCodigClienAnterCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeCodigClienAnterFrm.clieOidClieNuev','S', GestionarMensaje('MaeCodigClienAnter.clieOidClieNuev.requiered.message'));
	
	setMV('maeCodigClienAnterFrm.codClieAnti','S', GestionarMensaje('MaeCodigClienAnter.codClieAnti.requiered.message'));
	
	setMV('maeCodigClienAnterFrm.paisOidPais','S', GestionarMensaje('MaeCodigClienAnter.paisOidPais.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeCodigClienAnterFrm', true);
}

function maeCodigClienAnterUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeCodigClienAnterFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		maeCodigClienAnterTmpUpdateValues = maeCodigClienAnterBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeCodigClienAnterFrm.clieOidClieNuev','S', GestionarMensaje('MaeCodigClienAnter.clieOidClieNuev.requiered.message'));
		setMV('maeCodigClienAnterFrm.codClieAnti','S', GestionarMensaje('MaeCodigClienAnter.codClieAnti.requiered.message'));
		setMV('maeCodigClienAnterFrm.paisOidPais','S', GestionarMensaje('MaeCodigClienAnter.paisOidPais.requiered.message'));
		
			focusFirstFieldModify('maeCodigClienAnterFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('maeCodigClienAnterFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeCodigClienAnterFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeCodigClienAnterRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeCodigClienAnterList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeCodigClienAnterFrm', true);
}

function maeCodigClienAnterLovInitComponents(){
	maeCodigClienAnterLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeCodigClienAnterFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function maeCodigClienAnterSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeCodigClienAnterFrm.' + campo, id);
	set('maeCodigClienAnterFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeCodigClienAnterLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeCodigClienAnterLovReturnParameters.id = '';
	maeCodigClienAnterLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeCodigClienAnterLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCodigClienAnterList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeCodigClienAnterList.codSeleccionados();
	var descripcion = maeCodigClienAnterList.extraeDato(
		maeCodigClienAnterList.codSeleccionados()[0], maeCodigClienAnterChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeCodigClienAnterLovReturnParameters.id = codigo;
	maeCodigClienAnterLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeCodigClienAnterCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeCodigClienAnterFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeCodigClienAnterFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeCodigClienAnterList", "MaeCodigClienAnterConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeCodigClienAnterPostQueryActions(datos);"]], "", "");	
}

function maeCodigClienAnterCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeCodigClienAnterFrm.lastQueryToSession'));
	var i =0;
	set('maeCodigClienAnterFrm.clieOidClieNuev', [paramsRequery.ij(i++)]);
	
	set('maeCodigClienAnterFrm.codClieAnti', paramsRequery.ij(i++));
	
	set('maeCodigClienAnterFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('maeCodigClienAnterFrm.valSistProc', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeCodigClienAnterPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeCodigClienAnterCmdQuery(maeCodigClienAnterPageCount);
}

function maeCodigClienAnterFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeCodigClienAnterPageCount = 1;
	maeCodigClienAnterCmdQuery(maeCodigClienAnterPageCount);
}

function maeCodigClienAnterPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeCodigClienAnterLastQuery){
		maeCodigClienAnterFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeCodigClienAnterPageCount--;
	maeCodigClienAnterCmdQuery(maeCodigClienAnterPageCount);
}

function maeCodigClienAnterNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeCodigClienAnterLastQuery){
		maeCodigClienAnterFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeCodigClienAnterPageCount++;
	maeCodigClienAnterCmdQuery(maeCodigClienAnterPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeCodigClienAnterPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeCodigClienAnterListLayer', 'O');
		visibilidad('maeCodigClienAnterListButtonsLayer', 'O');
		if(get('maeCodigClienAnterFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeCodigClienAnterLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeCodigClienAnterViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeCodigClienAnterChoiceColumn) + "</A>",
			i, maeCodigClienAnterChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeCodigClienAnterList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeCodigClienAnterTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeCodigClienAnterMorePagesFlag = true;
		maeCodigClienAnterList.eliminar(mmgPageSize, 1);
	}else{
		maeCodigClienAnterMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeCodigClienAnterFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeCodigClienAnterListLayer', 'V');
	visibilidad('maeCodigClienAnterListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeCodigClienAnterList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeCodigClienAnterList.display();
	
	//Actualizamos el estado de los botones 
	if(maeCodigClienAnterMorePagesFlag){
		set_estado_botonera('maeCodigClienAnterPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeCodigClienAnterPaginationButtonBar',
			3,"inactivo");
	}
	if(maeCodigClienAnterPageCount > 1){
		set_estado_botonera('maeCodigClienAnterPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeCodigClienAnterPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeCodigClienAnterPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeCodigClienAnterPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeCodigClienAnterUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCodigClienAnterList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeCodigClienAnterFrm.idSelection', maeCodigClienAnterList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeCodigClienAnterFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeCodigClienAnterList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeCodigClienAnterFrm.accion');
		parametros["accion"] = get('maeCodigClienAnterFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeCodigClienAnterLPStartUp', get('maeCodigClienAnterFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeCodigClienAnterCmdRequery();
	}
}

function maeCodigClienAnterRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCodigClienAnterList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeCodigClienAnterList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeCodigClienAnterFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeCodigClienAnterList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeCodigClienAnterTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeCodigClienAnterFrm.timestamp', timestamps);


	maeCodigClienAnterFrm.oculto='S';
	envia('maeCodigClienAnterFrm');
	maeCodigClienAnterFrm.oculto='N';
}

function maeCodigClienAnterViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCodigClienAnterList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeCodigClienAnterViewDetail(maeCodigClienAnterList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeCodigClienAnterViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeCodigClienAnterFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeCodigClienAnterLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('maeCodigClienAnterFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		maeCodigClienAnterFrm.oculto='S';
		envia('maeCodigClienAnterFrm');
		maeCodigClienAnterFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeCodigClienAnterFrm.clieOidClieNuev').toString() == ''){
		set('maeCodigClienAnterFrm.clieOidClieNuev', []);
		mmgResetCombosOnCascade('clieOidClieNuev', 'clieOidClieNuev', 'maeCodigClienAnter');
		
	}
	if(get('maeCodigClienAnterFrm.paisOidPais').toString() == ''){
		set('maeCodigClienAnterFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeCodigClienAnter');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeCodigClienAnterRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeCodigClienAnterFrm.accion');
	var origenTmp = get('maeCodigClienAnterFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeCodigClienAnterBuildUpdateRecordString() != maeCodigClienAnterTmpUpdateValues){
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
	document.all.maeCodigClienAnterListLayer.style.display='none';
	document.all.maeCodigClienAnterListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeCodigClienAnterListLayer.style.display='';
	document.all.maeCodigClienAnterListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeCodigClienAnterClieOidClieNuev = get('maeCodigClienAnterFrm.clieOidClieNuev')[0];
	jsMaeCodigClienAnterCodClieAnti = get('maeCodigClienAnterFrm.codClieAnti').toString();
	jsMaeCodigClienAnterPaisOidPais = get('maeCodigClienAnterFrm.paisOidPais')[0];
	jsMaeCodigClienAnterValSistProc = get('maeCodigClienAnterFrm.valSistProc').toString();
	
	
	var parametros = "";
	parametros += jsMaeCodigClienAnterClieOidClieNuev + "|";
	parametros += jsMaeCodigClienAnterCodClieAnti + "|";
	parametros += jsMaeCodigClienAnterPaisOidPais + "|";
	parametros += jsMaeCodigClienAnterValSistProc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeCodigClienAnterBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeCodigClienAnterClieOidClieNuev + "|";
	parametros += jsMaeCodigClienAnterCodClieAnti + "|";
	parametros += jsMaeCodigClienAnterPaisOidPais + "|";
	parametros += jsMaeCodigClienAnterValSistProc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeCodigClienAnterFrm.accion'), 
		get('maeCodigClienAnterFrm.origen'));
	
	jsMaeCodigClienAnterId = get('maeCodigClienAnterFrm.id').toString();
	jsMaeCodigClienAnterClieOidClieNuev = get('maeCodigClienAnterFrm.clieOidClieNuev')[0];
	jsMaeCodigClienAnterCodClieAnti = get('maeCodigClienAnterFrm.codClieAnti').toString();
	jsMaeCodigClienAnterPaisOidPais = get('maeCodigClienAnterFrm.paisOidPais')[0];
	jsMaeCodigClienAnterValSistProc = get('maeCodigClienAnterFrm.valSistProc').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeCodigClienAnterFrm.accion'), 
		get('maeCodigClienAnterFrm.origen'));


	set('maeCodigClienAnterFrm.id', jsMaeCodigClienAnterId);
	set('maeCodigClienAnterFrm.clieOidClieNuev', [jsMaeCodigClienAnterClieOidClieNuev]);
	set('maeCodigClienAnterFrm.codClieAnti', jsMaeCodigClienAnterCodClieAnti);
	set('maeCodigClienAnterFrm.paisOidPais', [jsMaeCodigClienAnterPaisOidPais]);
	set('maeCodigClienAnterFrm.valSistProc', jsMaeCodigClienAnterValSistProc);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeCodigClienAnterClieOidClieNuev = '';
	jsMaeCodigClienAnterCodClieAnti = '';
	jsMaeCodigClienAnterPaisOidPais = '';
	jsMaeCodigClienAnterValSistProc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeCodigClienAnterFrm.errCodigo', errorCode);
	set('maeCodigClienAnterFrm.errDescripcion', description);
	set('maeCodigClienAnterFrm.errSeverity', severity);
	fMostrarMensajeError();
}
