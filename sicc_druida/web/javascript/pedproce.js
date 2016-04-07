

/*
    INDRA/CAR/mmg
    $Id: pedproce.js,v 1.1 2009/12/03 19:01:56 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedProceId = "";
var jsPedProceCodProc = "";
var jsPedProceDescripcion = "";
var jsPedProceGrprOidGrupProc = "";
var jsPedProceProgOidProg = "";
var jsPedProceProcOidProc = "";
var jsPedProceTposOidTipoPosi = "";
var jsPedProceStpoOidSubtPosi = "";

//Variables de paginacion, 
var pedProcePageCount = 1;

//Varible de columna que representa el campo de choice
var pedProceChoiceColumn = 1;

//Flag de siguiente pagina;
var pedProceMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedProceTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 171;
var sizeFormUpdate = 171;

//Ultima busqueda realizada
var pedProceLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("pedProceFrm.codProc");','focaliza("pedProceFrm.codProc");','focaliza("pedProceFrm.codProc");','focaliza("pedProceFrm.codProc");','focaliza("pedProceFrm.codProc");','focaliza("pedProceFrm.codProc");'],[3,'focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");'],[4,'focalizaComboDependence("pedProce","grprOidGrupProc", false);','focalizaComboDependence("pedProce","grprOidGrupProc", false);','focalizaComboDependence("pedProce","grprOidGrupProc", false);','focalizaComboDependence("pedProce","grprOidGrupProc", true);','focalizaComboDependence("pedProce","grprOidGrupProc", true);','focalizaComboDependence("pedProce","grprOidGrupProc", true);'],[5,'focalizaComboDependence("pedProce","progOidProg", false);','focalizaComboDependence("pedProce","progOidProg", false);','focalizaComboDependence("pedProce","progOidProg", false);','focalizaComboDependence("pedProce","progOidProg", true);','focalizaComboDependence("pedProce","progOidProg", true);','focalizaComboDependence("pedProce","progOidProg", true);'],[6,'focalizaComboDependence("pedProce","procOidProc", false);','focalizaComboDependence("pedProce","procOidProc", false);','focalizaComboDependence("pedProce","procOidProc", false);','focalizaComboDependence("pedProce","procOidProc", true);','focalizaComboDependence("pedProce","procOidProc", true);','focalizaComboDependence("pedProce","procOidProc", true);'],[7,'focalizaComboDependence("pedProce","tposOidTipoPosi", false);','focalizaComboDependence("pedProce","tposOidTipoPosi", false);','focalizaComboDependence("pedProce","tposOidTipoPosi", false);','focalizaComboDependence("pedProce","tposOidTipoPosi", true);','focalizaComboDependence("pedProce","tposOidTipoPosi", true);','focalizaComboDependence("pedProce","tposOidTipoPosi", true);'],[8,'focalizaComboDependence("pedProce","stpoOidSubtPosi", false);','focalizaComboDependence("pedProce","stpoOidSubtPosi", false);','focalizaComboDependence("pedProce","stpoOidSubtPosi", false);','focalizaComboDependence("pedProce","stpoOidSubtPosi", true);','focalizaComboDependence("pedProce","stpoOidSubtPosi", true);','focalizaComboDependence("pedProce","stpoOidSubtPosi", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");','focaliza("pedProceFrm.Descripcion");'],[4,'focalizaComboDependence("pedProce","grprOidGrupProc", false);','focalizaComboDependence("pedProce","grprOidGrupProc", false);','focalizaComboDependence("pedProce","grprOidGrupProc", false);','focalizaComboDependence("pedProce","grprOidGrupProc", true);','focalizaComboDependence("pedProce","grprOidGrupProc", true);','focalizaComboDependence("pedProce","grprOidGrupProc", true);'],[5,'focalizaComboDependence("pedProce","progOidProg", false);','focalizaComboDependence("pedProce","progOidProg", false);','focalizaComboDependence("pedProce","progOidProg", false);','focalizaComboDependence("pedProce","progOidProg", true);','focalizaComboDependence("pedProce","progOidProg", true);','focalizaComboDependence("pedProce","progOidProg", true);'],[6,'focalizaComboDependence("pedProce","procOidProc", false);','focalizaComboDependence("pedProce","procOidProc", false);','focalizaComboDependence("pedProce","procOidProc", false);','focalizaComboDependence("pedProce","procOidProc", true);','focalizaComboDependence("pedProce","procOidProc", true);','focalizaComboDependence("pedProce","procOidProc", true);'],[7,'focalizaComboDependence("pedProce","tposOidTipoPosi", false);','focalizaComboDependence("pedProce","tposOidTipoPosi", false);','focalizaComboDependence("pedProce","tposOidTipoPosi", false);','focalizaComboDependence("pedProce","tposOidTipoPosi", true);','focalizaComboDependence("pedProce","tposOidTipoPosi", true);','focalizaComboDependence("pedProce","tposOidTipoPosi", true);'],[8,'focalizaComboDependence("pedProce","stpoOidSubtPosi", false);','focalizaComboDependence("pedProce","stpoOidSubtPosi", false);','focalizaComboDependence("pedProce","stpoOidSubtPosi", false);','focalizaComboDependence("pedProce","stpoOidSubtPosi", true);','focalizaComboDependence("pedProce","stpoOidSubtPosi", true);','focalizaComboDependence("pedProce","stpoOidSubtPosi", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var grprOidGrupProcDependeceMap = new Vector();
grprOidGrupProcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
grprOidGrupProcDependeceMap.agregar(['grprOidGrupProc', padresTmp, '', 'PedGrupoProce']);
var progOidProgDependeceMap = new Vector();
progOidProgDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
progOidProgDependeceMap.agregar(['progOidProg', padresTmp, '', 'PedProgr']);
var procOidProcDependeceMap = new Vector();
procOidProcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
procOidProcDependeceMap.agregar(['procOidProc', padresTmp, '', 'PedProceView']);
var tposOidTipoPosiDependeceMap = new Vector();
tposOidTipoPosiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tposOidTipoPosiDependeceMap.agregar(['tposOidTipoPosi', padresTmp, '', 'PedTipoPosic']);
var stpoOidSubtPosiDependeceMap = new Vector();
stpoOidSubtPosiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
stpoOidSubtPosiDependeceMap.agregar(['stpoOidSubtPosi', padresTmp, '', 'PedSubtiPosicView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedProceLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedProceTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedProceInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedProceFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedProceFrm.accion')){
		case "query": pedProceQueryInitComponents(); break;
		case "view": pedProceViewInitComponents(); break;
		case "create": pedProceCreateInitComponents(); break;
		case "update": pedProceUpdateInitComponents(); break;
		case "remove": pedProceRemoveInitComponents(); break;
		case "lov": pedProceLovInitComponents(); break;
	}
	//alert('accion :' + get('pedProceFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedProceFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedProce')) pedProceCmdRequery();
}

function pedProceQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	focusFirstField('pedProceFrm', true);	
}

function pedProceViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('pedProceFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('pedProceFrm', true);
}

function pedProceCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedProceFrm.codProc','S', GestionarMensaje('PedProce.codProc.requiered.message'));
	
	setMV('pedProceFrm.Descripcion','S', GestionarMensaje('PedProce.Descripcion.requiered.message'));
	
	setMV('pedProceFrm.grprOidGrupProc','S', GestionarMensaje('PedProce.grprOidGrupProc.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedProceFrm', true);
}

function pedProceUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedProceFrm.origen') == "pagina"){
		loadLocalizationWidget('pedProceFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		pedProceTmpUpdateValues = pedProceBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedProceFrm.codProc','S', GestionarMensaje('PedProce.codProc.requiered.message'));
		setMV('pedProceFrm.Descripcion','S', GestionarMensaje('PedProce.Descripcion.requiered.message'));
		setMV('pedProceFrm.grprOidGrupProc','S', GestionarMensaje('PedProce.grprOidGrupProc.requiered.message'));
		
			focusFirstFieldModify('pedProceFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		focusFirstField('pedProceFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedProceFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedProceRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedProceList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedProceFrm', true);
}

function pedProceLovInitComponents(){
	pedProceLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedProceFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad










//Función que permite cargar los datos de un elemento de lov seleccionado
function pedProceSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedProceFrm.' + campo, id);
	set('pedProceFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedProceLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedProceLovReturnParameters.id = '';
	pedProceLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedProceLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedProceList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedProceList.codSeleccionados();
	var descripcion = pedProceList.extraeDato(
		pedProceList.codSeleccionados()[0], pedProceChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedProceLovReturnParameters.id = codigo;
	pedProceLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedProceCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedProceFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedProceFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedProceList", "PedProceConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedProcePostQueryActions(datos);"]], "", "");	
}

function pedProceCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedProceFrm.lastQueryToSession'));
	var i =0;
	set('pedProceFrm.codProc', paramsRequery.ij(i++));
	
	set('pedProceFrm.Descripcion', paramsRequery.ij(i++));
	
	set('pedProceFrm.grprOidGrupProc', [paramsRequery.ij(i++)]);
	
	set('pedProceFrm.progOidProg', [paramsRequery.ij(i++)]);
	
	set('pedProceFrm.procOidProc', [paramsRequery.ij(i++)]);
	
	set('pedProceFrm.tposOidTipoPosi', [paramsRequery.ij(i++)]);
	
	set('pedProceFrm.stpoOidSubtPosi', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	pedProcePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedProceCmdQuery(pedProcePageCount);
}

function pedProceFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedProcePageCount = 1;
	pedProceCmdQuery(pedProcePageCount);
}

function pedProcePreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedProceLastQuery){
		pedProceFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedProcePageCount--;
	pedProceCmdQuery(pedProcePageCount);
}

function pedProceNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedProceLastQuery){
		pedProceFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedProcePageCount++;
	pedProceCmdQuery(pedProcePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedProcePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedProceListLayer', 'O');
		visibilidad('pedProceListButtonsLayer', 'O');
		if(get('pedProceFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedProceLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedProceViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedProceChoiceColumn) + "</A>",
			i, pedProceChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedProceList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedProceTimeStamps = datosTmp.filtrar([8],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedProceMorePagesFlag = true;
		pedProceList.eliminar(mmgPageSize, 1);
	}else{
		pedProceMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedProceFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedProceListLayer', 'V');
	visibilidad('pedProceListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedProceList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedProceList.display();
	
	//Actualizamos el estado de los botones 
	if(pedProceMorePagesFlag){
		set_estado_botonera('pedProcePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedProcePaginationButtonBar',
			3,"inactivo");
	}
	if(pedProcePageCount > 1){
		set_estado_botonera('pedProcePaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedProcePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedProcePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedProcePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedProceUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedProceList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedProceFrm.idSelection', pedProceList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedProceFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedProceList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedProceFrm.accion');
		parametros["accion"] = get('pedProceFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedProceLPStartUp', get('pedProceFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedProceCmdRequery();
	}
}

function pedProceRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedProceList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedProceList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedProceFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedProceList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedProceTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedProceFrm.timestamp', timestamps);


	pedProceFrm.oculto='S';
	envia('pedProceFrm');
	pedProceFrm.oculto='N';
}

function pedProceViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedProceList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedProceViewDetail(pedProceList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedProceViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedProceFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedProceLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('pedProceFrm', 
		'Descripcion', 1,
		get('pedProceFrm.Descripcion'));	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('pedProceFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('pedProceFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('PedProce.Descripcion.requiered.message'));
		focaliza('pedProceFrm.Descripcion');
		return;
	}	
	
	
	
	
	
	
		
	
	if(validacion){
		pedProceFrm.oculto='S';
		envia('pedProceFrm');
		pedProceFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedProceFrm.grprOidGrupProc').toString() == ''){
		set('pedProceFrm.grprOidGrupProc', []);
		mmgResetCombosOnCascade('grprOidGrupProc', 'grprOidGrupProc', 'pedProce');
		
	}
	if(get('pedProceFrm.progOidProg').toString() == ''){
		set('pedProceFrm.progOidProg', []);
		mmgResetCombosOnCascade('progOidProg', 'progOidProg', 'pedProce');
		
	}
	if(get('pedProceFrm.procOidProc').toString() == ''){
		set('pedProceFrm.procOidProc', []);
		mmgResetCombosOnCascade('procOidProc', 'procOidProc', 'pedProce');
		
	}
	if(get('pedProceFrm.tposOidTipoPosi').toString() == ''){
		set('pedProceFrm.tposOidTipoPosi', []);
		mmgResetCombosOnCascade('tposOidTipoPosi', 'tposOidTipoPosi', 'pedProce');
		
	}
	if(get('pedProceFrm.stpoOidSubtPosi').toString() == ''){
		set('pedProceFrm.stpoOidSubtPosi', []);
		mmgResetCombosOnCascade('stpoOidSubtPosi', 'stpoOidSubtPosi', 'pedProce');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedProceRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedProceFrm.accion');
	var origenTmp = get('pedProceFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedProceBuildUpdateRecordString() != pedProceTmpUpdateValues){
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
	document.all.pedProceListLayer.style.display='none';
	document.all.pedProceListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedProceListLayer.style.display='';
	document.all.pedProceListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedProceCodProc = get('pedProceFrm.codProc').toString();
	jsPedProceDescripcion = get('pedProceFrm.Descripcion').toString();
	jsPedProceGrprOidGrupProc = get('pedProceFrm.grprOidGrupProc')[0];
	jsPedProceProgOidProg = get('pedProceFrm.progOidProg')[0];
	jsPedProceProcOidProc = get('pedProceFrm.procOidProc')[0];
	jsPedProceTposOidTipoPosi = get('pedProceFrm.tposOidTipoPosi')[0];
	jsPedProceStpoOidSubtPosi = get('pedProceFrm.stpoOidSubtPosi')[0];
	
	
	var parametros = "";
	parametros += jsPedProceCodProc + "|";
	parametros += jsPedProceDescripcion + "|";
	parametros += jsPedProceGrprOidGrupProc + "|";
	parametros += jsPedProceProgOidProg + "|";
	parametros += jsPedProceProcOidProc + "|";
	parametros += jsPedProceTposOidTipoPosi + "|";
	parametros += jsPedProceStpoOidSubtPosi + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedProceBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedProceCodProc + "|";
	parametros += jsPedProceDescripcion + "|";
	parametros += jsPedProceGrprOidGrupProc + "|";
	parametros += jsPedProceProgOidProg + "|";
	parametros += jsPedProceProcOidProc + "|";
	parametros += jsPedProceTposOidTipoPosi + "|";
	parametros += jsPedProceStpoOidSubtPosi + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedProceFrm.accion'), 
		get('pedProceFrm.origen'));
	
	jsPedProceId = get('pedProceFrm.id').toString();
	jsPedProceCodProc = get('pedProceFrm.codProc').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPedProceDescripcion = buildLocalizedString('pedProceFrm', 1);
	}else{
		jsPedProceDescripcion = get('pedProceFrm.Descripcion');
	}
	jsPedProceGrprOidGrupProc = get('pedProceFrm.grprOidGrupProc')[0];
	jsPedProceProgOidProg = get('pedProceFrm.progOidProg')[0];
	jsPedProceProcOidProc = get('pedProceFrm.procOidProc')[0];
	jsPedProceTposOidTipoPosi = get('pedProceFrm.tposOidTipoPosi')[0];
	jsPedProceStpoOidSubtPosi = get('pedProceFrm.stpoOidSubtPosi')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedProceFrm.accion'), 
		get('pedProceFrm.origen'));


	set('pedProceFrm.id', jsPedProceId);
	set('pedProceFrm.codProc', jsPedProceCodProc);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('pedProceFrm', 1,  jsPedProceDescripcion)
		loadLocalizationWidget('pedProceFrm', 'Descripcion', 1);
	}else{
		set('pedProceFrm.Descripcion', jsPedProceDescripcion);		
	}
	set('pedProceFrm.grprOidGrupProc', [jsPedProceGrprOidGrupProc]);
	set('pedProceFrm.progOidProg', [jsPedProceProgOidProg]);
	set('pedProceFrm.procOidProc', [jsPedProceProcOidProc]);
	set('pedProceFrm.tposOidTipoPosi', [jsPedProceTposOidTipoPosi]);
	set('pedProceFrm.stpoOidSubtPosi', [jsPedProceStpoOidSubtPosi]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedProceCodProc = '';
	jsPedProceDescripcion = '';
	jsPedProceGrprOidGrupProc = '';
	jsPedProceProgOidProg = '';
	jsPedProceProcOidProc = '';
	jsPedProceTposOidTipoPosi = '';
	jsPedProceStpoOidSubtPosi = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedProceFrm.errCodigo', errorCode);
	set('pedProceFrm.errDescripcion', description);
	set('pedProceFrm.errSeverity', severity);
	fMostrarMensajeError();
}
