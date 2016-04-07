

/*
    INDRA/CAR/mmg
    $Id: segtipocambi.js,v 1.1 2009/12/03 19:01:35 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsSegTipoCambiId = "";
var jsSegTipoCambiMoneOidMon1 = "";
var jsSegTipoCambiMoneOidMon2 = "";
var jsSegTipoCambiFecDesd = "";
var jsSegTipoCambiValTipoCamb = "";
var jsSegTipoCambiFecHast = "";

//Variables de paginacion, 
var segTipoCambiPageCount = 1;

//Varible de columna que representa el campo de choice
var segTipoCambiChoiceColumn = 3;

//Flag de siguiente pagina;
var segTipoCambiMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segTipoCambiTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var segTipoCambiLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("segTipoCambi","moneOidMon1", false);','focalizaComboDependence("segTipoCambi","moneOidMon1", false);','focalizaComboDependence("segTipoCambi","moneOidMon1", false);','focalizaComboDependence("segTipoCambi","moneOidMon1", true);','focalizaComboDependence("segTipoCambi","moneOidMon1", true);','focalizaComboDependence("segTipoCambi","moneOidMon1", true);'],[3,'focalizaComboDependence("segTipoCambi","moneOidMon2", false);','focalizaComboDependence("segTipoCambi","moneOidMon2", false);','focalizaComboDependence("segTipoCambi","moneOidMon2", false);','focalizaComboDependence("segTipoCambi","moneOidMon2", true);','focalizaComboDependence("segTipoCambi","moneOidMon2", true);','focalizaComboDependence("segTipoCambi","moneOidMon2", true);'],[4,'focaliza("segTipoCambiFrm.fecDesd");','focaliza("segTipoCambiFrm.fecDesd");','','focaliza("segTipoCambiFrm.fecDesd");','focaliza("segTipoCambiFrm.fecDesd");',''],[5,'','focaliza("segTipoCambiFrm.valTipoCamb");','focaliza("segTipoCambiFrm.valTipoCamb");','','focaliza("segTipoCambiFrm.valTipoCamb");','focaliza("segTipoCambiFrm.valTipoCamb");'],[6,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[5,'','focaliza("segTipoCambiFrm.valTipoCamb");','focaliza("segTipoCambiFrm.valTipoCamb");','','focaliza("segTipoCambiFrm.valTipoCamb");','focaliza("segTipoCambiFrm.valTipoCamb");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var moneOidMon1DependeceMap = new Vector();
moneOidMon1DependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moneOidMon1DependeceMap.agregar(['moneOidMon1', padresTmp, '', 'SegMoned']);
var moneOidMon2DependeceMap = new Vector();
moneOidMon2DependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moneOidMon2DependeceMap.agregar(['moneOidMon2', padresTmp, '', 'SegMoned']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
segTipoCambiLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var segTipoCambiTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function segTipoCambiInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('segTipoCambiFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('segTipoCambiFrm.accion')){
		case "query": segTipoCambiQueryInitComponents(); break;
		case "view": segTipoCambiViewInitComponents(); break;
		case "create": segTipoCambiCreateInitComponents(); break;
		case "update": segTipoCambiUpdateInitComponents(); break;
		case "remove": segTipoCambiRemoveInitComponents(); break;
		case "lov": segTipoCambiLovInitComponents(); break;
	}
	//alert('accion :' + get('segTipoCambiFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('segTipoCambiFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segTipoCambi')) segTipoCambiCmdRequery();
}

function segTipoCambiQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('segTipoCambiFrm', true);	
}

function segTipoCambiViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('segTipoCambiFrm', true);
}

function segTipoCambiCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('segTipoCambiFrm.moneOidMon1','S', GestionarMensaje('SegTipoCambi.moneOidMon1.requiered.message'));
	
	setMV('segTipoCambiFrm.moneOidMon2','S', GestionarMensaje('SegTipoCambi.moneOidMon2.requiered.message'));
	
	setMV('segTipoCambiFrm.fecDesd','S', GestionarMensaje('SegTipoCambi.fecDesd.requiered.message'));
	
	setMV('segTipoCambiFrm.valTipoCamb','S', GestionarMensaje('SegTipoCambi.valTipoCamb.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('segTipoCambiFrm', true);
}

function segTipoCambiUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('segTipoCambiFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		segTipoCambiTmpUpdateValues = segTipoCambiBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('segTipoCambiFrm.moneOidMon1','S', GestionarMensaje('SegTipoCambi.moneOidMon1.requiered.message'));
		setMV('segTipoCambiFrm.moneOidMon2','S', GestionarMensaje('SegTipoCambi.moneOidMon2.requiered.message'));
		setMV('segTipoCambiFrm.valTipoCamb','S', GestionarMensaje('SegTipoCambi.valTipoCamb.requiered.message'));
		
			focusFirstFieldModify('segTipoCambiFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('segTipoCambiFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('segTipoCambiFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segTipoCambiRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	segTipoCambiList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('segTipoCambiFrm', true);
}

function segTipoCambiLovInitComponents(){
	segTipoCambiLovReturnParameters = window.dialogArguments;
	
	focusFirstField('segTipoCambiFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function segTipoCambiSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('segTipoCambiFrm.' + campo, id);
	set('segTipoCambiFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function segTipoCambiLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	segTipoCambiLovReturnParameters.id = '';
	segTipoCambiLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function segTipoCambiLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segTipoCambiList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = segTipoCambiList.codSeleccionados();
	var descripcion = segTipoCambiList.extraeDato(
		segTipoCambiList.codSeleccionados()[0], segTipoCambiChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	segTipoCambiLovReturnParameters.id = codigo;
	segTipoCambiLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function segTipoCambiCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('segTipoCambiFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('segTipoCambiFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "segTipoCambiList", "SegTipoCambiConectorTransactionQuery", 
		"result_ROWSET", parametros, "segTipoCambiPostQueryActions(datos);"]], "", "");	
}

function segTipoCambiCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('segTipoCambiFrm.lastQueryToSession'));
	var i =0;
	set('segTipoCambiFrm.moneOidMon1', [paramsRequery.ij(i++)]);
	
	set('segTipoCambiFrm.moneOidMon2', [paramsRequery.ij(i++)]);
	
	set('segTipoCambiFrm.fecDesd', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	segTipoCambiPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	segTipoCambiCmdQuery(segTipoCambiPageCount);
}

function segTipoCambiFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	segTipoCambiPageCount = 1;
	segTipoCambiCmdQuery(segTipoCambiPageCount);
}

function segTipoCambiPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segTipoCambiLastQuery){
		segTipoCambiFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	segTipoCambiPageCount--;
	segTipoCambiCmdQuery(segTipoCambiPageCount);
}

function segTipoCambiNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segTipoCambiLastQuery){
		segTipoCambiFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	segTipoCambiPageCount++;
	segTipoCambiCmdQuery(segTipoCambiPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function segTipoCambiPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('segTipoCambiListLayer', 'O');
		visibilidad('segTipoCambiListButtonsLayer', 'O');
		if(get('segTipoCambiFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	segTipoCambiLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:segTipoCambiViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, segTipoCambiChoiceColumn) + "</A>",
			i, segTipoCambiChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	segTipoCambiList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	segTipoCambiTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		segTipoCambiMorePagesFlag = true;
		segTipoCambiList.eliminar(mmgPageSize, 1);
	}else{
		segTipoCambiMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('segTipoCambiFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('segTipoCambiListLayer', 'V');
	visibilidad('segTipoCambiListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('segTipoCambiList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	segTipoCambiList.display();
	
	//Actualizamos el estado de los botones 
	if(segTipoCambiMorePagesFlag){
		set_estado_botonera('segTipoCambiPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('segTipoCambiPaginationButtonBar',
			3,"inactivo");
	}
	if(segTipoCambiPageCount > 1){
		set_estado_botonera('segTipoCambiPaginationButtonBar',
			2,"activo");
		set_estado_botonera('segTipoCambiPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('segTipoCambiPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('segTipoCambiPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function segTipoCambiUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segTipoCambiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('segTipoCambiFrm.idSelection', segTipoCambiList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('segTipoCambiFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = segTipoCambiList.codSeleccionados()[0];
		parametros["previousAction"] = get('segTipoCambiFrm.accion');
		parametros["accion"] = get('segTipoCambiFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('SegTipoCambiLPStartUp', get('segTipoCambiFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) segTipoCambiCmdRequery();
	}
}

function segTipoCambiRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segTipoCambiList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = segTipoCambiList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('segTipoCambiFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(segTipoCambiList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += segTipoCambiTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('segTipoCambiFrm.timestamp', timestamps);


	segTipoCambiFrm.oculto='S';
	envia('segTipoCambiFrm');
	segTipoCambiFrm.oculto='N';
}

function segTipoCambiViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segTipoCambiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	segTipoCambiViewDetail(segTipoCambiList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function segTipoCambiViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segTipoCambiFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('SegTipoCambiLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('segTipoCambiFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
		
	
	if(validacion){
		segTipoCambiFrm.oculto='S';
		envia('segTipoCambiFrm');
		segTipoCambiFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('segTipoCambiFrm.moneOidMon1').toString() == ''){
		set('segTipoCambiFrm.moneOidMon1', []);
		mmgResetCombosOnCascade('moneOidMon1', 'moneOidMon1', 'segTipoCambi');
		
	}
	if(get('segTipoCambiFrm.moneOidMon2').toString() == ''){
		set('segTipoCambiFrm.moneOidMon2', []);
		mmgResetCombosOnCascade('moneOidMon2', 'moneOidMon2', 'segTipoCambi');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	segTipoCambiRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('segTipoCambiFrm.accion');
	var origenTmp = get('segTipoCambiFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(segTipoCambiBuildUpdateRecordString() != segTipoCambiTmpUpdateValues){
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
	document.all.segTipoCambiListLayer.style.display='none';
	document.all.segTipoCambiListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.segTipoCambiListLayer.style.display='';
	document.all.segTipoCambiListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsSegTipoCambiMoneOidMon1 = get('segTipoCambiFrm.moneOidMon1')[0];
	jsSegTipoCambiMoneOidMon2 = get('segTipoCambiFrm.moneOidMon2')[0];
	jsSegTipoCambiFecDesd = get('segTipoCambiFrm.fecDesd').toString();
	
	
	var parametros = "";
	parametros += jsSegTipoCambiMoneOidMon1 + "|";
	parametros += jsSegTipoCambiMoneOidMon2 + "|";
	parametros += jsSegTipoCambiFecDesd + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function segTipoCambiBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsSegTipoCambiMoneOidMon1 + "|";
	parametros += jsSegTipoCambiMoneOidMon2 + "|";
	parametros += jsSegTipoCambiValTipoCamb + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segTipoCambiFrm.accion'), 
		get('segTipoCambiFrm.origen'));
	
	jsSegTipoCambiId = get('segTipoCambiFrm.id').toString();
	jsSegTipoCambiMoneOidMon1 = get('segTipoCambiFrm.moneOidMon1')[0];
	jsSegTipoCambiMoneOidMon2 = get('segTipoCambiFrm.moneOidMon2')[0];
	jsSegTipoCambiFecDesd = get('segTipoCambiFrm.fecDesd').toString();
	jsSegTipoCambiValTipoCamb = get('segTipoCambiFrm.valTipoCamb').toString();
	jsSegTipoCambiFecHast = get('segTipoCambiFrm.fecHast').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segTipoCambiFrm.accion'), 
		get('segTipoCambiFrm.origen'));


	set('segTipoCambiFrm.id', jsSegTipoCambiId);
	set('segTipoCambiFrm.moneOidMon1', [jsSegTipoCambiMoneOidMon1]);
	set('segTipoCambiFrm.moneOidMon2', [jsSegTipoCambiMoneOidMon2]);
	set('segTipoCambiFrm.fecDesd', jsSegTipoCambiFecDesd);
	set('segTipoCambiFrm.valTipoCamb', jsSegTipoCambiValTipoCamb);
	set('segTipoCambiFrm.fecHast', jsSegTipoCambiFecHast);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsSegTipoCambiMoneOidMon1 = '';
	jsSegTipoCambiMoneOidMon2 = '';
	jsSegTipoCambiFecDesd = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segTipoCambiFrm.errCodigo', errorCode);
	set('segTipoCambiFrm.errDescripcion', description);
	set('segTipoCambiFrm.errSeverity', severity);
	fMostrarMensajeError();
}
