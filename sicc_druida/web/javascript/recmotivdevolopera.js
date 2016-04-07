

/*
    INDRA/CAR/mmg
    $Id: recmotivdevolopera.js,v 1.1 2009/12/03 19:01:56 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsRecMotivDevolOperaId = "";
var jsRecMotivDevolOperaRopeOidOper = "";
var jsRecMotivDevolOperaModvOidMotiDevo = "";
var jsRecMotivDevolOperaValMarcDefe = "";
var jsRecMotivDevolOperaPaisOidPais = "";

//Variables de paginacion, 
var recMotivDevolOperaPageCount = 1;

//Varible de columna que representa el campo de choice
var recMotivDevolOperaChoiceColumn = 3;

//Flag de siguiente pagina;
var recMotivDevolOperaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var recMotivDevolOperaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 171;
var sizeFormUpdate = 171;

//Ultima busqueda realizada
var recMotivDevolOperaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("recMotivDevolOpera","ropeOidOper", false);','focalizaComboDependence("recMotivDevolOpera","ropeOidOper", false);','focalizaComboDependence("recMotivDevolOpera","ropeOidOper", false);','focalizaComboDependence("recMotivDevolOpera","ropeOidOper", true);','focalizaComboDependence("recMotivDevolOpera","ropeOidOper", true);','focalizaComboDependence("recMotivDevolOpera","ropeOidOper", true);'],[3,'focalizaComboDependence("recMotivDevolOpera","modvOidMotiDevo", false);','focalizaComboDependence("recMotivDevolOpera","modvOidMotiDevo", false);','focalizaComboDependence("recMotivDevolOpera","modvOidMotiDevo", false);','focalizaComboDependence("recMotivDevolOpera","modvOidMotiDevo", true);','focalizaComboDependence("recMotivDevolOpera","modvOidMotiDevo", true);','focalizaComboDependence("recMotivDevolOpera","modvOidMotiDevo", true);'],[4,'focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");'],[5,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");','focaliza("recMotivDevolOperaFrm.valMarcDefe");'],[5,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var ropeOidOperDependeceMap = new Vector();
ropeOidOperDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ropeOidOperDependeceMap.agregar(['ropeOidOper', padresTmp, '', 'RecOperaView']);
var modvOidMotiDevoDependeceMap = new Vector();
modvOidMotiDevoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
modvOidMotiDevoDependeceMap.agregar(['modvOidMotiDevo', padresTmp, '', 'RecMotivDevol']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
recMotivDevolOperaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var recMotivDevolOperaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function recMotivDevolOperaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('recMotivDevolOperaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('recMotivDevolOperaFrm.accion')){
		case "query": recMotivDevolOperaQueryInitComponents(); break;
		case "view": recMotivDevolOperaViewInitComponents(); break;
		case "create": recMotivDevolOperaCreateInitComponents(); break;
		case "update": recMotivDevolOperaUpdateInitComponents(); break;
		case "remove": recMotivDevolOperaRemoveInitComponents(); break;
		case "lov": recMotivDevolOperaLovInitComponents(); break;
	}
	//alert('accion :' + get('recMotivDevolOperaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('recMotivDevolOperaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('recMotivDevolOpera')) recMotivDevolOperaCmdRequery();
}

function recMotivDevolOperaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('recMotivDevolOperaFrm', true);	
}

function recMotivDevolOperaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('recMotivDevolOperaFrm', true);
}

function recMotivDevolOperaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('recMotivDevolOperaFrm.ropeOidOper','S', GestionarMensaje('RecMotivDevolOpera.ropeOidOper.requiered.message'));
	
	setMV('recMotivDevolOperaFrm.modvOidMotiDevo','S', GestionarMensaje('RecMotivDevolOpera.modvOidMotiDevo.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('recMotivDevolOperaFrm', true);
}

function recMotivDevolOperaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('recMotivDevolOperaFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		recMotivDevolOperaTmpUpdateValues = recMotivDevolOperaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('recMotivDevolOperaFrm.ropeOidOper','S', GestionarMensaje('RecMotivDevolOpera.ropeOidOper.requiered.message'));
		setMV('recMotivDevolOperaFrm.modvOidMotiDevo','S', GestionarMensaje('RecMotivDevolOpera.modvOidMotiDevo.requiered.message'));
		
			focusFirstFieldModify('recMotivDevolOperaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('recMotivDevolOperaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('recMotivDevolOperaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function recMotivDevolOperaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	recMotivDevolOperaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('recMotivDevolOperaFrm', true);
}

function recMotivDevolOperaLovInitComponents(){
	recMotivDevolOperaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('recMotivDevolOperaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function recMotivDevolOperaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('recMotivDevolOperaFrm.' + campo, id);
	set('recMotivDevolOperaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function recMotivDevolOperaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	recMotivDevolOperaLovReturnParameters.id = '';
	recMotivDevolOperaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function recMotivDevolOperaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recMotivDevolOperaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = recMotivDevolOperaList.codSeleccionados();
	var descripcion = recMotivDevolOperaList.extraeDato(
		recMotivDevolOperaList.codSeleccionados()[0], recMotivDevolOperaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	recMotivDevolOperaLovReturnParameters.id = codigo;
	recMotivDevolOperaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function recMotivDevolOperaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('recMotivDevolOperaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('recMotivDevolOperaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "recMotivDevolOperaList", "RecMotivDevolOperaConectorTransactionQuery", 
		"result_ROWSET", parametros, "recMotivDevolOperaPostQueryActions(datos);"]], "", "");	
}

function recMotivDevolOperaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('recMotivDevolOperaFrm.lastQueryToSession'));
	var i =0;
	set('recMotivDevolOperaFrm.ropeOidOper', [paramsRequery.ij(i++)]);
	
	set('recMotivDevolOperaFrm.modvOidMotiDevo', [paramsRequery.ij(i++)]);
	
	set('recMotivDevolOperaFrm.valMarcDefe', (paramsRequery.ij(i++) == 'true'? 'S': 'N'));
	
	
	
	//Establecemos la página de busqueda como la actual
	recMotivDevolOperaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	recMotivDevolOperaCmdQuery(recMotivDevolOperaPageCount);
}

function recMotivDevolOperaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	recMotivDevolOperaPageCount = 1;
	recMotivDevolOperaCmdQuery(recMotivDevolOperaPageCount);
}

function recMotivDevolOperaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recMotivDevolOperaLastQuery){
		recMotivDevolOperaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	recMotivDevolOperaPageCount--;
	recMotivDevolOperaCmdQuery(recMotivDevolOperaPageCount);
}

function recMotivDevolOperaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recMotivDevolOperaLastQuery){
		recMotivDevolOperaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	recMotivDevolOperaPageCount++;
	recMotivDevolOperaCmdQuery(recMotivDevolOperaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function recMotivDevolOperaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('recMotivDevolOperaListLayer', 'O');
		visibilidad('recMotivDevolOperaListButtonsLayer', 'O');
		if(get('recMotivDevolOperaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	recMotivDevolOperaLastQuery = generateQuery();

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
		datosTmp.ij2("<A HREF=\'javascript:recMotivDevolOperaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, recMotivDevolOperaChoiceColumn) + "</A>",
			i, recMotivDevolOperaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	recMotivDevolOperaList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	recMotivDevolOperaTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		recMotivDevolOperaMorePagesFlag = true;
		recMotivDevolOperaList.eliminar(mmgPageSize, 1);
	}else{
		recMotivDevolOperaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('recMotivDevolOperaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('recMotivDevolOperaListLayer', 'V');
	visibilidad('recMotivDevolOperaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('recMotivDevolOperaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	recMotivDevolOperaList.display();
	
	//Actualizamos el estado de los botones 
	if(recMotivDevolOperaMorePagesFlag){
		set_estado_botonera('recMotivDevolOperaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('recMotivDevolOperaPaginationButtonBar',
			3,"inactivo");
	}
	if(recMotivDevolOperaPageCount > 1){
		set_estado_botonera('recMotivDevolOperaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('recMotivDevolOperaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('recMotivDevolOperaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('recMotivDevolOperaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function recMotivDevolOperaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recMotivDevolOperaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('recMotivDevolOperaFrm.idSelection', recMotivDevolOperaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('recMotivDevolOperaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = recMotivDevolOperaList.codSeleccionados()[0];
		parametros["previousAction"] = get('recMotivDevolOperaFrm.accion');
		parametros["accion"] = get('recMotivDevolOperaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('RecMotivDevolOperaLPStartUp', get('recMotivDevolOperaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) recMotivDevolOperaCmdRequery();
	}
}

function recMotivDevolOperaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recMotivDevolOperaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = recMotivDevolOperaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('recMotivDevolOperaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(recMotivDevolOperaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += recMotivDevolOperaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('recMotivDevolOperaFrm.timestamp', timestamps);


	recMotivDevolOperaFrm.oculto='S';
	envia('recMotivDevolOperaFrm');
	recMotivDevolOperaFrm.oculto='N';
}

function recMotivDevolOperaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recMotivDevolOperaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	recMotivDevolOperaViewDetail(recMotivDevolOperaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function recMotivDevolOperaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('recMotivDevolOperaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('RecMotivDevolOperaLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('recMotivDevolOperaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		recMotivDevolOperaFrm.oculto='S';
		envia('recMotivDevolOperaFrm');
		recMotivDevolOperaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('recMotivDevolOperaFrm.ropeOidOper').toString() == ''){
		set('recMotivDevolOperaFrm.ropeOidOper', []);
		mmgResetCombosOnCascade('ropeOidOper', 'ropeOidOper', 'recMotivDevolOpera');
		
	}
	if(get('recMotivDevolOperaFrm.modvOidMotiDevo').toString() == ''){
		set('recMotivDevolOperaFrm.modvOidMotiDevo', []);
		mmgResetCombosOnCascade('modvOidMotiDevo', 'modvOidMotiDevo', 'recMotivDevolOpera');
		
	}
	if(get('recMotivDevolOperaFrm.paisOidPais').toString() == ''){
		set('recMotivDevolOperaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'recMotivDevolOpera');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	recMotivDevolOperaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('recMotivDevolOperaFrm.accion');
	var origenTmp = get('recMotivDevolOperaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(recMotivDevolOperaBuildUpdateRecordString() != recMotivDevolOperaTmpUpdateValues){
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
	document.all.recMotivDevolOperaListLayer.style.display='none';
	document.all.recMotivDevolOperaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.recMotivDevolOperaListLayer.style.display='';
	document.all.recMotivDevolOperaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsRecMotivDevolOperaRopeOidOper = get('recMotivDevolOperaFrm.ropeOidOper')[0];
	jsRecMotivDevolOperaModvOidMotiDevo = get('recMotivDevolOperaFrm.modvOidMotiDevo')[0];
	if(get('recMotivDevolOperaFrm.valMarcDefe').toString() == 'S') jsRecMotivDevolOperaValMarcDefe = "true";
	else jsRecMotivDevolOperaValMarcDefe = "false";
	
	
	var parametros = "";
	parametros += jsRecMotivDevolOperaRopeOidOper + "|";
	parametros += jsRecMotivDevolOperaModvOidMotiDevo + "|";
	parametros += jsRecMotivDevolOperaValMarcDefe + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function recMotivDevolOperaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsRecMotivDevolOperaRopeOidOper + "|";
	parametros += jsRecMotivDevolOperaModvOidMotiDevo + "|";
	parametros += jsRecMotivDevolOperaValMarcDefe + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recMotivDevolOperaFrm.accion'), 
		get('recMotivDevolOperaFrm.origen'));
	
	jsRecMotivDevolOperaId = get('recMotivDevolOperaFrm.id').toString();
	jsRecMotivDevolOperaRopeOidOper = get('recMotivDevolOperaFrm.ropeOidOper')[0];
	jsRecMotivDevolOperaModvOidMotiDevo = get('recMotivDevolOperaFrm.modvOidMotiDevo')[0];
	if(get('recMotivDevolOperaFrm.valMarcDefe').toString() == 'S') jsRecMotivDevolOperaValMarcDefe = "true";
		else jsRecMotivDevolOperaValMarcDefe = "false";
	jsRecMotivDevolOperaPaisOidPais = get('recMotivDevolOperaFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recMotivDevolOperaFrm.accion'), 
		get('recMotivDevolOperaFrm.origen'));


	set('recMotivDevolOperaFrm.id', jsRecMotivDevolOperaId);
	set('recMotivDevolOperaFrm.ropeOidOper', [jsRecMotivDevolOperaRopeOidOper]);
	set('recMotivDevolOperaFrm.modvOidMotiDevo', [jsRecMotivDevolOperaModvOidMotiDevo]);
	
			
			if(jsRecMotivDevolOperaValMarcDefe == "true") set('recMotivDevolOperaFrm.valMarcDefe', 'S');
			else set('recMotivDevolOperaFrm.valMarcDefe', 'N');
	set('recMotivDevolOperaFrm.paisOidPais', [jsRecMotivDevolOperaPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsRecMotivDevolOperaRopeOidOper = '';
	jsRecMotivDevolOperaModvOidMotiDevo = '';
	jsRecMotivDevolOperaValMarcDefe = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('recMotivDevolOperaFrm.errCodigo', errorCode);
	set('recMotivDevolOperaFrm.errDescripcion', description);
	set('recMotivDevolOperaFrm.errSeverity', severity);
	fMostrarMensajeError();
}
