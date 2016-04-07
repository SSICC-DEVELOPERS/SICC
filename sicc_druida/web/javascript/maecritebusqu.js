

/*
    INDRA/CAR/mmg
    $Id: maecritebusqu.js,v 1.1 2009/12/03 19:01:57 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeCriteBusquId = "";
var jsMaeCriteBusquPaisOidPais = "";
var jsMaeCriteBusquAtreOidAtriEsp1 = "";
var jsMaeCriteBusquAtreOidAtriEsp2 = "";

//Variables de paginacion, 
var maeCriteBusquPageCount = 1;

//Varible de columna que representa el campo de choice
var maeCriteBusquChoiceColumn = 2;

//Flag de siguiente pagina;
var maeCriteBusquMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeCriteBusquTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeCriteBusquLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", true);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", true);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", true);'],[4,'focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", true);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", true);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", true);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", true);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp1", true);'],[4,'focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", false);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", true);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", true);','focalizaComboDependence("maeCriteBusqu","atreOidAtriEsp2", true);']]);

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
var atreOidAtriEsp1DependeceMap = new Vector();
atreOidAtriEsp1DependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
atreOidAtriEsp1DependeceMap.agregar(['atreOidAtriEsp1', padresTmp, '', 'PedAtribEspec']);
var atreOidAtriEsp2DependeceMap = new Vector();
atreOidAtriEsp2DependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
atreOidAtriEsp2DependeceMap.agregar(['atreOidAtriEsp2', padresTmp, '', 'PedAtribEspec']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeCriteBusquLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeCriteBusquTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeCriteBusquInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeCriteBusquFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeCriteBusquFrm.accion')){
		case "query": maeCriteBusquQueryInitComponents(); break;
		case "view": maeCriteBusquViewInitComponents(); break;
		case "create": maeCriteBusquCreateInitComponents(); break;
		case "update": maeCriteBusquUpdateInitComponents(); break;
		case "remove": maeCriteBusquRemoveInitComponents(); break;
		case "lov": maeCriteBusquLovInitComponents(); break;
	}
	//alert('accion :' + get('maeCriteBusquFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeCriteBusquFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeCriteBusqu')) maeCriteBusquCmdRequery();
}

function maeCriteBusquQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('maeCriteBusquFrm', true);	
}

function maeCriteBusquViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('maeCriteBusquFrm', true);
}

function maeCriteBusquCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeCriteBusquFrm.atreOidAtriEsp1','S', GestionarMensaje('MaeCriteBusqu.atreOidAtriEsp1.requiered.message'));
	
	setMV('maeCriteBusquFrm.atreOidAtriEsp2','S', GestionarMensaje('MaeCriteBusqu.atreOidAtriEsp2.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeCriteBusquFrm', true);
}

function maeCriteBusquUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeCriteBusquFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		maeCriteBusquTmpUpdateValues = maeCriteBusquBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeCriteBusquFrm.atreOidAtriEsp1','S', GestionarMensaje('MaeCriteBusqu.atreOidAtriEsp1.requiered.message'));
		setMV('maeCriteBusquFrm.atreOidAtriEsp2','S', GestionarMensaje('MaeCriteBusqu.atreOidAtriEsp2.requiered.message'));
		
			focusFirstFieldModify('maeCriteBusquFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('maeCriteBusquFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeCriteBusquFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeCriteBusquRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeCriteBusquList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeCriteBusquFrm', true);
}

function maeCriteBusquLovInitComponents(){
	maeCriteBusquLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeCriteBusquFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeCriteBusquSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeCriteBusquFrm.' + campo, id);
	set('maeCriteBusquFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeCriteBusquLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeCriteBusquLovReturnParameters.id = '';
	maeCriteBusquLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeCriteBusquLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCriteBusquList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeCriteBusquList.codSeleccionados();
	var descripcion = maeCriteBusquList.extraeDato(
		maeCriteBusquList.codSeleccionados()[0], maeCriteBusquChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeCriteBusquLovReturnParameters.id = codigo;
	maeCriteBusquLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeCriteBusquCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeCriteBusquFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeCriteBusquFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeCriteBusquList", "MaeCriteBusquConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeCriteBusquPostQueryActions(datos);"]], "", "");	
}

function maeCriteBusquCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeCriteBusquFrm.lastQueryToSession'));
	var i =0;
	set('maeCriteBusquFrm.atreOidAtriEsp1', [paramsRequery.ij(i++)]);
	
	set('maeCriteBusquFrm.atreOidAtriEsp2', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	maeCriteBusquPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeCriteBusquCmdQuery(maeCriteBusquPageCount);
}

function maeCriteBusquFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeCriteBusquPageCount = 1;
	maeCriteBusquCmdQuery(maeCriteBusquPageCount);
}

function maeCriteBusquPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeCriteBusquLastQuery){
		maeCriteBusquFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeCriteBusquPageCount--;
	maeCriteBusquCmdQuery(maeCriteBusquPageCount);
}

function maeCriteBusquNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeCriteBusquLastQuery){
		maeCriteBusquFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeCriteBusquPageCount++;
	maeCriteBusquCmdQuery(maeCriteBusquPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeCriteBusquPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeCriteBusquListLayer', 'O');
		visibilidad('maeCriteBusquListButtonsLayer', 'O');
		if(get('maeCriteBusquFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeCriteBusquLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeCriteBusquViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeCriteBusquChoiceColumn) + "</A>",
			i, maeCriteBusquChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeCriteBusquList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeCriteBusquTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeCriteBusquMorePagesFlag = true;
		maeCriteBusquList.eliminar(mmgPageSize, 1);
	}else{
		maeCriteBusquMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeCriteBusquFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeCriteBusquListLayer', 'V');
	visibilidad('maeCriteBusquListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeCriteBusquList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeCriteBusquList.display();
	
	//Actualizamos el estado de los botones 
	if(maeCriteBusquMorePagesFlag){
		set_estado_botonera('maeCriteBusquPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeCriteBusquPaginationButtonBar',
			3,"inactivo");
	}
	if(maeCriteBusquPageCount > 1){
		set_estado_botonera('maeCriteBusquPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeCriteBusquPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeCriteBusquPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeCriteBusquPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeCriteBusquUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCriteBusquList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeCriteBusquFrm.idSelection', maeCriteBusquList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeCriteBusquFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeCriteBusquList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeCriteBusquFrm.accion');
		parametros["accion"] = get('maeCriteBusquFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeCriteBusquLPStartUp', get('maeCriteBusquFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeCriteBusquCmdRequery();
	}
}

function maeCriteBusquRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCriteBusquList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeCriteBusquList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeCriteBusquFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeCriteBusquList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeCriteBusquTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeCriteBusquFrm.timestamp', timestamps);


	maeCriteBusquFrm.oculto='S';
	envia('maeCriteBusquFrm');
	maeCriteBusquFrm.oculto='N';
}

function maeCriteBusquViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCriteBusquList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeCriteBusquViewDetail(maeCriteBusquList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeCriteBusquViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeCriteBusquFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeCriteBusquLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('maeCriteBusquFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion){
		maeCriteBusquFrm.oculto='S';
		envia('maeCriteBusquFrm');
		maeCriteBusquFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeCriteBusquFrm.paisOidPais').toString() == ''){
		set('maeCriteBusquFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeCriteBusqu');
		
	}
	if(get('maeCriteBusquFrm.atreOidAtriEsp1').toString() == ''){
		set('maeCriteBusquFrm.atreOidAtriEsp1', []);
		mmgResetCombosOnCascade('atreOidAtriEsp1', 'atreOidAtriEsp1', 'maeCriteBusqu');
		
	}
	if(get('maeCriteBusquFrm.atreOidAtriEsp2').toString() == ''){
		set('maeCriteBusquFrm.atreOidAtriEsp2', []);
		mmgResetCombosOnCascade('atreOidAtriEsp2', 'atreOidAtriEsp2', 'maeCriteBusqu');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeCriteBusquRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeCriteBusquFrm.accion');
	var origenTmp = get('maeCriteBusquFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeCriteBusquBuildUpdateRecordString() != maeCriteBusquTmpUpdateValues){
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
	document.all.maeCriteBusquListLayer.style.display='none';
	document.all.maeCriteBusquListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeCriteBusquListLayer.style.display='';
	document.all.maeCriteBusquListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeCriteBusquAtreOidAtriEsp1 = get('maeCriteBusquFrm.atreOidAtriEsp1')[0];
	jsMaeCriteBusquAtreOidAtriEsp2 = get('maeCriteBusquFrm.atreOidAtriEsp2')[0];
	
	
	var parametros = "";
	parametros += jsMaeCriteBusquAtreOidAtriEsp1 + "|";
	parametros += jsMaeCriteBusquAtreOidAtriEsp2 + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeCriteBusquBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeCriteBusquAtreOidAtriEsp1 + "|";
	parametros += jsMaeCriteBusquAtreOidAtriEsp2 + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeCriteBusquFrm.accion'), 
		get('maeCriteBusquFrm.origen'));
	
	jsMaeCriteBusquId = get('maeCriteBusquFrm.id').toString();
	jsMaeCriteBusquPaisOidPais = get('maeCriteBusquFrm.paisOidPais')[0];
	jsMaeCriteBusquAtreOidAtriEsp1 = get('maeCriteBusquFrm.atreOidAtriEsp1')[0];
	jsMaeCriteBusquAtreOidAtriEsp2 = get('maeCriteBusquFrm.atreOidAtriEsp2')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeCriteBusquFrm.accion'), 
		get('maeCriteBusquFrm.origen'));


	set('maeCriteBusquFrm.id', jsMaeCriteBusquId);
	set('maeCriteBusquFrm.paisOidPais', [jsMaeCriteBusquPaisOidPais]);
	set('maeCriteBusquFrm.atreOidAtriEsp1', [jsMaeCriteBusquAtreOidAtriEsp1]);
	set('maeCriteBusquFrm.atreOidAtriEsp2', [jsMaeCriteBusquAtreOidAtriEsp2]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeCriteBusquAtreOidAtriEsp1 = '';
	jsMaeCriteBusquAtreOidAtriEsp2 = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeCriteBusquFrm.errCodigo', errorCode);
	set('maeCriteBusquFrm.errDescripcion', description);
	set('maeCriteBusquFrm.errSeverity', severity);
	fMostrarMensajeError();
}
