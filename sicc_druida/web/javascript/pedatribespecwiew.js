

/*
    INDRA/CAR/mmg
    $Id: pedatribespecwiew.js,v 1.1 2009/12/03 19:02:12 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedAtribEspecwiewId = "";
var jsPedAtribEspecwiewCodAtri = "";
var jsPedAtribEspecwiewDesAtri = "";
var jsPedAtribEspecwiewValForm = "";
var jsPedAtribEspecwiewModuOidModu = "";

//Variables de paginacion, 
var pedAtribEspecwiewPageCount = 1;

//Varible de columna que representa el campo de choice
var pedAtribEspecwiewChoiceColumn = 1;

//Flag de siguiente pagina;
var pedAtribEspecwiewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedAtribEspecwiewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 231;
var sizeFormView = 217;
var sizeFormUpdate = 217;

//Ultima busqueda realizada
var pedAtribEspecwiewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("pedAtribEspecwiew","moduOidModu", false);','focalizaComboDependence("pedAtribEspecwiew","moduOidModu", false);','focalizaComboDependence("pedAtribEspecwiew","moduOidModu", false);','focalizaComboDependence("pedAtribEspecwiew","moduOidModu", true);','focalizaComboDependence("pedAtribEspecwiew","moduOidModu", true);','focalizaComboDependence("pedAtribEspecwiew","moduOidModu", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var moduOidModuDependeceMap = new Vector();
moduOidModuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moduOidModuDependeceMap.agregar(['moduOidModu', padresTmp, '', 'SegModul']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedAtribEspecwiewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedAtribEspecwiewTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function pedAtribEspecwiewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedAtribEspecwiewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedAtribEspecwiewFrm.accion')){
		case "query": pedAtribEspecwiewQueryInitComponents(); break;
		case "view": pedAtribEspecwiewViewInitComponents(); break;
		case "create": pedAtribEspecwiewCreateInitComponents(); break;
		case "update": pedAtribEspecwiewUpdateInitComponents(); break;
		case "remove": pedAtribEspecwiewRemoveInitComponents(); break;
		case "lov": pedAtribEspecwiewLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('pedAtribEspecwiewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedAtribEspecwiew')) pedAtribEspecwiewCmdRequery();
}

function pedAtribEspecwiewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
}

function pedAtribEspecwiewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function pedAtribEspecwiewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedAtribEspecwiewFrm.codAtri','S', GestionarMensaje('PedAtribEspecwiew.codAtri.requiered.message'));
	
	setMV('pedAtribEspecwiewFrm.desAtri','S', GestionarMensaje('PedAtribEspecwiew.desAtri.requiered.message'));
	
	setMV('pedAtribEspecwiewFrm.moduOidModu','S', GestionarMensaje('PedAtribEspecwiew.moduOidModu.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function pedAtribEspecwiewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedAtribEspecwiewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		pedAtribEspecwiewTmpUpdateValues = pedAtribEspecwiewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedAtribEspecwiewFrm.codAtri','S', GestionarMensaje('PedAtribEspecwiew.codAtri.requiered.message'));
		setMV('pedAtribEspecwiewFrm.desAtri','S', GestionarMensaje('PedAtribEspecwiew.desAtri.requiered.message'));
		setMV('pedAtribEspecwiewFrm.moduOidModu','S', GestionarMensaje('PedAtribEspecwiew.moduOidModu.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedAtribEspecwiewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedAtribEspecwiewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedAtribEspecwiewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function pedAtribEspecwiewLovInitComponents(){
	pedAtribEspecwiewLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function pedAtribEspecwiewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedAtribEspecwiewFrm.' + campo, id);
	set('pedAtribEspecwiewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedAtribEspecwiewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedAtribEspecwiewLovReturnParameters.id = '';
	pedAtribEspecwiewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedAtribEspecwiewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAtribEspecwiewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedAtribEspecwiewList.codSeleccionados();
	var descripcion = pedAtribEspecwiewList.extraeDato(
		pedAtribEspecwiewList.codSeleccionados()[0], pedAtribEspecwiewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedAtribEspecwiewLovReturnParameters.id = codigo;
	pedAtribEspecwiewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedAtribEspecwiewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedAtribEspecwiewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedAtribEspecwiewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedAtribEspecwiewList", "PedAtribEspecwiewConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedAtribEspecwiewPostQueryActions(datos);"]], "", "");	
}

function pedAtribEspecwiewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedAtribEspecwiewFrm.lastQueryToSession'));
	var i =0;
	set('pedAtribEspecwiewFrm.codAtri', paramsRequery.ij(i++));
	
	set('pedAtribEspecwiewFrm.desAtri', paramsRequery.ij(i++));
	
	set('pedAtribEspecwiewFrm.valForm', paramsRequery.ij(i++));
	
	set('pedAtribEspecwiewFrm.moduOidModu', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	pedAtribEspecwiewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedAtribEspecwiewCmdQuery(pedAtribEspecwiewPageCount);
}

function pedAtribEspecwiewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedAtribEspecwiewPageCount = 1;
	pedAtribEspecwiewCmdQuery(pedAtribEspecwiewPageCount);
}

function pedAtribEspecwiewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedAtribEspecwiewLastQuery){
		pedAtribEspecwiewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedAtribEspecwiewPageCount--;
	pedAtribEspecwiewCmdQuery(pedAtribEspecwiewPageCount);
}

function pedAtribEspecwiewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedAtribEspecwiewLastQuery){
		pedAtribEspecwiewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedAtribEspecwiewPageCount++;
	pedAtribEspecwiewCmdQuery(pedAtribEspecwiewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedAtribEspecwiewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedAtribEspecwiewListLayer', 'O');
		visibilidad('pedAtribEspecwiewListButtonsLayer', 'O');
		if(get('pedAtribEspecwiewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedAtribEspecwiewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedAtribEspecwiewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedAtribEspecwiewChoiceColumn) + "</A>",
			i, pedAtribEspecwiewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedAtribEspecwiewList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedAtribEspecwiewTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedAtribEspecwiewMorePagesFlag = true;
		pedAtribEspecwiewList.eliminar(mmgPageSize, 1);
	}else{
		pedAtribEspecwiewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedAtribEspecwiewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedAtribEspecwiewListLayer', 'V');
	visibilidad('pedAtribEspecwiewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedAtribEspecwiewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedAtribEspecwiewList.display();
	
	//Actualizamos el estado de los botones 
	if(pedAtribEspecwiewMorePagesFlag){
		set_estado_botonera('pedAtribEspecwiewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedAtribEspecwiewPaginationButtonBar',
			3,"inactivo");
	}
	if(pedAtribEspecwiewPageCount > 1){
		set_estado_botonera('pedAtribEspecwiewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedAtribEspecwiewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedAtribEspecwiewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedAtribEspecwiewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedAtribEspecwiewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAtribEspecwiewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedAtribEspecwiewFrm.idSelection', pedAtribEspecwiewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedAtribEspecwiewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedAtribEspecwiewList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedAtribEspecwiewFrm.accion');
		parametros["accion"] = get('pedAtribEspecwiewFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('PedAtribEspecwiewLPStartUp', get('pedAtribEspecwiewFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) pedAtribEspecwiewCmdRequery();
	}
}

function pedAtribEspecwiewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAtribEspecwiewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedAtribEspecwiewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedAtribEspecwiewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedAtribEspecwiewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedAtribEspecwiewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedAtribEspecwiewFrm.timestamp', timestamps);


	pedAtribEspecwiewFrm.oculto='S';
	envia('pedAtribEspecwiewFrm');
	pedAtribEspecwiewFrm.oculto='N';
}

function pedAtribEspecwiewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAtribEspecwiewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedAtribEspecwiewViewDetail(pedAtribEspecwiewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedAtribEspecwiewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedAtribEspecwiewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('PedAtribEspecwiewLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('pedAtribEspecwiewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		pedAtribEspecwiewFrm.oculto='S';
		envia('pedAtribEspecwiewFrm');
		pedAtribEspecwiewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedAtribEspecwiewFrm.moduOidModu').toString() == ''){
		set('pedAtribEspecwiewFrm.moduOidModu', []);
		mmgResetCombosOnCascade('moduOidModu', 'moduOidModu', 'pedAtribEspecwiew');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedAtribEspecwiewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedAtribEspecwiewFrm.accion');
	var origenTmp = get('pedAtribEspecwiewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedAtribEspecwiewBuildUpdateRecordString() != pedAtribEspecwiewTmpUpdateValues){
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
	document.all.pedAtribEspecwiewListLayer.style.display='none';
	document.all.pedAtribEspecwiewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedAtribEspecwiewListLayer.style.display='';
	document.all.pedAtribEspecwiewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedAtribEspecwiewCodAtri = get('pedAtribEspecwiewFrm.codAtri').toString();
	jsPedAtribEspecwiewDesAtri = get('pedAtribEspecwiewFrm.desAtri').toString();
	jsPedAtribEspecwiewValForm = get('pedAtribEspecwiewFrm.valForm').toString();
	jsPedAtribEspecwiewModuOidModu = get('pedAtribEspecwiewFrm.moduOidModu')[0];
	
	
	var parametros = "";
	parametros += jsPedAtribEspecwiewCodAtri + "|";
	parametros += jsPedAtribEspecwiewDesAtri + "|";
	parametros += jsPedAtribEspecwiewValForm + "|";
	parametros += jsPedAtribEspecwiewModuOidModu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedAtribEspecwiewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedAtribEspecwiewCodAtri + "|";
	parametros += jsPedAtribEspecwiewDesAtri + "|";
	parametros += jsPedAtribEspecwiewValForm + "|";
	parametros += jsPedAtribEspecwiewModuOidModu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedAtribEspecwiewFrm.accion'), 
		get('pedAtribEspecwiewFrm.origen'));
	
	jsPedAtribEspecwiewId = get('pedAtribEspecwiewFrm.id').toString();
	jsPedAtribEspecwiewCodAtri = get('pedAtribEspecwiewFrm.codAtri').toString();
	jsPedAtribEspecwiewDesAtri = get('pedAtribEspecwiewFrm.desAtri').toString();
	jsPedAtribEspecwiewValForm = get('pedAtribEspecwiewFrm.valForm').toString();
	jsPedAtribEspecwiewModuOidModu = get('pedAtribEspecwiewFrm.moduOidModu')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedAtribEspecwiewFrm.accion'), 
		get('pedAtribEspecwiewFrm.origen'));


	set('pedAtribEspecwiewFrm.id', jsPedAtribEspecwiewId);
	set('pedAtribEspecwiewFrm.codAtri', jsPedAtribEspecwiewCodAtri);
	set('pedAtribEspecwiewFrm.desAtri', jsPedAtribEspecwiewDesAtri);
	set('pedAtribEspecwiewFrm.valForm', jsPedAtribEspecwiewValForm);
	set('pedAtribEspecwiewFrm.moduOidModu', [jsPedAtribEspecwiewModuOidModu]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsPedAtribEspecwiewCodAtri = '';
	jsPedAtribEspecwiewDesAtri = '';
	jsPedAtribEspecwiewValForm = '';
	jsPedAtribEspecwiewModuOidModu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedAtribEspecwiewFrm.errCodigo', errorCode);
	set('pedAtribEspecwiewFrm.errDescripcion', description);
	set('pedAtribEspecwiewFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
