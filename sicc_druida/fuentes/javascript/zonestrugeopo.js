

/*
    INDRA/CAR/mmg
    $Id: zonestrugeopo.js,v 1.1 2009/12/03 19:01:47 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonEstruGeopoId = "";
var jsZonEstruGeopoCodOrde = "";
var jsZonEstruGeopoIndBorr = "";
var jsZonEstruGeopoPaisOidPais = "";
var jsZonEstruGeopoDipoOidDiviPoli = "";
var jsZonEstruGeopoFecActu = "";

//Variables de paginacion, 
var zonEstruGeopoPageCount = 1;

//Varible de columna que representa el campo de choice
var zonEstruGeopoChoiceColumn = 0;

//Flag de siguiente pagina;
var zonEstruGeopoMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonEstruGeopoTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 273;
var sizeFormView = 259;
var sizeFormUpdate = 259;

//Ultima busqueda realizada
var zonEstruGeopoLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");'],[3,'focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");'],[4,'focalizaComboDependence("zonEstruGeopo","paisOidPais", false);','focalizaComboDependence("zonEstruGeopo","paisOidPais", false);','focalizaComboDependence("zonEstruGeopo","paisOidPais", false);','focalizaComboDependence("zonEstruGeopo","paisOidPais", true);','focalizaComboDependence("zonEstruGeopo","paisOidPais", true);','focalizaComboDependence("zonEstruGeopo","paisOidPais", true);'],[5,'focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", false);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", false);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", false);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", true);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", true);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", true);'],[6,'focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");','focaliza("zonEstruGeopoFrm.codOrde");'],[3,'focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");','focaliza("zonEstruGeopoFrm.indBorr");'],[4,'focalizaComboDependence("zonEstruGeopo","paisOidPais", false);','focalizaComboDependence("zonEstruGeopo","paisOidPais", false);','focalizaComboDependence("zonEstruGeopo","paisOidPais", false);','focalizaComboDependence("zonEstruGeopo","paisOidPais", true);','focalizaComboDependence("zonEstruGeopo","paisOidPais", true);','focalizaComboDependence("zonEstruGeopo","paisOidPais", true);'],[5,'focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", false);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", false);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", false);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", true);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", true);','focalizaComboDependence("zonEstruGeopo","dipoOidDiviPoli", true);'],[6,'focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");','focaliza("zonEstruGeopoFrm.fecActu");']]);

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
var dipoOidDiviPoliDependeceMap = new Vector();
dipoOidDiviPoliDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
dipoOidDiviPoliDependeceMap.agregar(['dipoOidDiviPoli', padresTmp, '', 'ZonNivelGeogr']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonEstruGeopoLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonEstruGeopoTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function zonEstruGeopoInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonEstruGeopoFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonEstruGeopoFrm.accion')){
		case "query": zonEstruGeopoQueryInitComponents(); break;
		case "view": zonEstruGeopoViewInitComponents(); break;
		case "create": zonEstruGeopoCreateInitComponents(); break;
		case "update": zonEstruGeopoUpdateInitComponents(); break;
		case "remove": zonEstruGeopoRemoveInitComponents(); break;
		case "lov": zonEstruGeopoLovInitComponents(); break;
	}
	//alert('accion :' + get('zonEstruGeopoFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('zonEstruGeopoFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonEstruGeopo')) zonEstruGeopoCmdRequery();
}

function zonEstruGeopoQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	focusFirstField('zonEstruGeopoFrm', true);	
}

function zonEstruGeopoViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('zonEstruGeopoFrm', true);
}

function zonEstruGeopoCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonEstruGeopoFrm.codOrde','S', GestionarMensaje('ZonEstruGeopo.codOrde.requiered.message'));
	
	setMV('zonEstruGeopoFrm.paisOidPais','S', GestionarMensaje('ZonEstruGeopo.paisOidPais.requiered.message'));
	
	setMV('zonEstruGeopoFrm.dipoOidDiviPoli','S', GestionarMensaje('ZonEstruGeopo.dipoOidDiviPoli.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('zonEstruGeopoFrm', true);
}

function zonEstruGeopoUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonEstruGeopoFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonEstruGeopoTmpUpdateValues = zonEstruGeopoBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonEstruGeopoFrm.codOrde','S', GestionarMensaje('ZonEstruGeopo.codOrde.requiered.message'));
		setMV('zonEstruGeopoFrm.paisOidPais','S', GestionarMensaje('ZonEstruGeopo.paisOidPais.requiered.message'));
		setMV('zonEstruGeopoFrm.dipoOidDiviPoli','S', GestionarMensaje('ZonEstruGeopo.dipoOidDiviPoli.requiered.message'));
		
			focusFirstFieldModify('zonEstruGeopoFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		focusFirstField('zonEstruGeopoFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonEstruGeopoFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonEstruGeopoRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonEstruGeopoList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('zonEstruGeopoFrm', true);
}

function zonEstruGeopoLovInitComponents(){
	zonEstruGeopoLovReturnParameters = window.dialogArguments;
	
	focusFirstField('zonEstruGeopoFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function zonEstruGeopoSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonEstruGeopoFrm.' + campo, id);
	set('zonEstruGeopoFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonEstruGeopoLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonEstruGeopoLovReturnParameters.id = '';
	zonEstruGeopoLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonEstruGeopoLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonEstruGeopoList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonEstruGeopoList.codSeleccionados();
	var descripcion = zonEstruGeopoList.extraeDato(
		zonEstruGeopoList.codSeleccionados()[0], zonEstruGeopoChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonEstruGeopoLovReturnParameters.id = codigo;
	zonEstruGeopoLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonEstruGeopoCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonEstruGeopoFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonEstruGeopoFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonEstruGeopoList", "ZonEstruGeopoConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonEstruGeopoPostQueryActions(datos);"]], "", "");	
}

function zonEstruGeopoCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonEstruGeopoFrm.lastQueryToSession'));
	var i =0;
	set('zonEstruGeopoFrm.codOrde', paramsRequery.ij(i++));
	
	set('zonEstruGeopoFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonEstruGeopoFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('zonEstruGeopoFrm.dipoOidDiviPoli', [paramsRequery.ij(i++)]);
	
	set('zonEstruGeopoFrm.fecActu', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	zonEstruGeopoPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonEstruGeopoCmdQuery(zonEstruGeopoPageCount);
}

function zonEstruGeopoFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonEstruGeopoPageCount = 1;
	zonEstruGeopoCmdQuery(zonEstruGeopoPageCount);
}

function zonEstruGeopoPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonEstruGeopoLastQuery){
		zonEstruGeopoFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonEstruGeopoPageCount--;
	zonEstruGeopoCmdQuery(zonEstruGeopoPageCount);
}

function zonEstruGeopoNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonEstruGeopoLastQuery){
		zonEstruGeopoFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonEstruGeopoPageCount++;
	zonEstruGeopoCmdQuery(zonEstruGeopoPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonEstruGeopoPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonEstruGeopoListLayer', 'O');
		visibilidad('zonEstruGeopoListButtonsLayer', 'O');
		if(get('zonEstruGeopoFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonEstruGeopoLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonEstruGeopoViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonEstruGeopoChoiceColumn) + "</A>",
			i, zonEstruGeopoChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonEstruGeopoList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonEstruGeopoTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonEstruGeopoMorePagesFlag = true;
		zonEstruGeopoList.eliminar(mmgPageSize, 1);
	}else{
		zonEstruGeopoMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonEstruGeopoFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonEstruGeopoListLayer', 'V');
	visibilidad('zonEstruGeopoListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonEstruGeopoList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonEstruGeopoList.display();
	
	//Actualizamos el estado de los botones 
	if(zonEstruGeopoMorePagesFlag){
		set_estado_botonera('zonEstruGeopoPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonEstruGeopoPaginationButtonBar',
			3,"inactivo");
	}
	if(zonEstruGeopoPageCount > 1){
		set_estado_botonera('zonEstruGeopoPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonEstruGeopoPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonEstruGeopoPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonEstruGeopoPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonEstruGeopoUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonEstruGeopoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonEstruGeopoFrm.idSelection', zonEstruGeopoList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonEstruGeopoFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonEstruGeopoList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonEstruGeopoFrm.accion');
		parametros["accion"] = get('zonEstruGeopoFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ZonEstruGeopoLPStartUp', get('zonEstruGeopoFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) zonEstruGeopoCmdRequery();
	}
}

function zonEstruGeopoRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonEstruGeopoList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonEstruGeopoList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonEstruGeopoFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonEstruGeopoList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonEstruGeopoTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonEstruGeopoFrm.timestamp', timestamps);


	zonEstruGeopoFrm.oculto='S';
	envia('zonEstruGeopoFrm');
	zonEstruGeopoFrm.oculto='N';
}

function zonEstruGeopoViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonEstruGeopoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonEstruGeopoViewDetail(zonEstruGeopoList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonEstruGeopoViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonEstruGeopoFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ZonEstruGeopoLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('zonEstruGeopoFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
		
	
	if(validacion){
		zonEstruGeopoFrm.oculto='S';
		envia('zonEstruGeopoFrm');
		zonEstruGeopoFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonEstruGeopoFrm.paisOidPais').toString() == ''){
		set('zonEstruGeopoFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'zonEstruGeopo');
		
	}
	if(get('zonEstruGeopoFrm.dipoOidDiviPoli').toString() == ''){
		set('zonEstruGeopoFrm.dipoOidDiviPoli', []);
		mmgResetCombosOnCascade('dipoOidDiviPoli', 'dipoOidDiviPoli', 'zonEstruGeopo');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonEstruGeopoRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonEstruGeopoFrm.accion');
	var origenTmp = get('zonEstruGeopoFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonEstruGeopoBuildUpdateRecordString() != zonEstruGeopoTmpUpdateValues){
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
	document.all.zonEstruGeopoListLayer.style.display='none';
	document.all.zonEstruGeopoListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonEstruGeopoListLayer.style.display='';
	document.all.zonEstruGeopoListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonEstruGeopoCodOrde = get('zonEstruGeopoFrm.codOrde').toString();
	jsZonEstruGeopoIndBorr = get('zonEstruGeopoFrm.indBorr').toString();
	jsZonEstruGeopoPaisOidPais = get('zonEstruGeopoFrm.paisOidPais')[0];
	jsZonEstruGeopoDipoOidDiviPoli = get('zonEstruGeopoFrm.dipoOidDiviPoli')[0];
	jsZonEstruGeopoFecActu = get('zonEstruGeopoFrm.fecActu').toString();
	
	
	var parametros = "";
	parametros += jsZonEstruGeopoCodOrde + "|";
	parametros += jsZonEstruGeopoIndBorr + "|";
	parametros += jsZonEstruGeopoPaisOidPais + "|";
	parametros += jsZonEstruGeopoDipoOidDiviPoli + "|";
	parametros += jsZonEstruGeopoFecActu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonEstruGeopoBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonEstruGeopoCodOrde + "|";
	parametros += jsZonEstruGeopoIndBorr + "|";
	parametros += jsZonEstruGeopoPaisOidPais + "|";
	parametros += jsZonEstruGeopoDipoOidDiviPoli + "|";
	parametros += jsZonEstruGeopoFecActu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonEstruGeopoFrm.accion'), 
		get('zonEstruGeopoFrm.origen'));
	
	jsZonEstruGeopoId = get('zonEstruGeopoFrm.id').toString();
	jsZonEstruGeopoCodOrde = get('zonEstruGeopoFrm.codOrde').toString();
	jsZonEstruGeopoIndBorr = get('zonEstruGeopoFrm.indBorr').toString();
	jsZonEstruGeopoPaisOidPais = get('zonEstruGeopoFrm.paisOidPais')[0];
	jsZonEstruGeopoDipoOidDiviPoli = get('zonEstruGeopoFrm.dipoOidDiviPoli')[0];
	jsZonEstruGeopoFecActu = get('zonEstruGeopoFrm.fecActu').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonEstruGeopoFrm.accion'), 
		get('zonEstruGeopoFrm.origen'));


	set('zonEstruGeopoFrm.id', jsZonEstruGeopoId);
	set('zonEstruGeopoFrm.codOrde', jsZonEstruGeopoCodOrde);
	set('zonEstruGeopoFrm.indBorr', jsZonEstruGeopoIndBorr);
	set('zonEstruGeopoFrm.paisOidPais', [jsZonEstruGeopoPaisOidPais]);
	set('zonEstruGeopoFrm.dipoOidDiviPoli', [jsZonEstruGeopoDipoOidDiviPoli]);
	set('zonEstruGeopoFrm.fecActu', jsZonEstruGeopoFecActu);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsZonEstruGeopoCodOrde = '';
	jsZonEstruGeopoIndBorr = '';
	jsZonEstruGeopoPaisOidPais = '';
	jsZonEstruGeopoDipoOidDiviPoli = '';
	jsZonEstruGeopoFecActu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonEstruGeopoFrm.errCodigo', errorCode);
	set('zonEstruGeopoFrm.errDescripcion', description);
	set('zonEstruGeopoFrm.errSeverity', severity);
	fMostrarMensajeError();
}
