

/*
    INDRA/CAR/mmg
    $Id: segidiom.js,v 1.1 2009/12/03 19:01:42 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsSegIdiomId = "";
var jsSegIdiomCodIdio = "";
var jsSegIdiomDescripcion = "";
var jsSegIdiomIndIdioTrad = "";
var jsSegIdiomCodIsoIdio = "";

//Variables de paginacion, 
var segIdiomPageCount = 1;

//Varible de columna que representa el campo de choice
var segIdiomChoiceColumn = 1;

//Flag de siguiente pagina;
var segIdiomMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segIdiomTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var segIdiomLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("segIdiomFrm.codIdio");','focaliza("segIdiomFrm.codIdio");','focaliza("segIdiomFrm.codIdio");','focaliza("segIdiomFrm.codIdio");','focaliza("segIdiomFrm.codIdio");','focaliza("segIdiomFrm.codIdio");'],[3,'focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");'],[4,'','focaliza("segIdiomFrm.indIdioTrad");','focaliza("segIdiomFrm.indIdioTrad");','','focaliza("segIdiomFrm.indIdioTrad");','focaliza("segIdiomFrm.indIdioTrad");'],[5,'','focaliza("segIdiomFrm.codIsoIdio");','focaliza("segIdiomFrm.codIsoIdio");','','focaliza("segIdiomFrm.codIsoIdio");','focaliza("segIdiomFrm.codIsoIdio");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");','focaliza("segIdiomFrm.Descripcion");'],[4,'','focaliza("segIdiomFrm.indIdioTrad");','focaliza("segIdiomFrm.indIdioTrad");','','focaliza("segIdiomFrm.indIdioTrad");','focaliza("segIdiomFrm.indIdioTrad");'],[5,'','focaliza("segIdiomFrm.codIsoIdio");','focaliza("segIdiomFrm.codIsoIdio");','','focaliza("segIdiomFrm.codIsoIdio");','focaliza("segIdiomFrm.codIsoIdio");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
segIdiomLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var segIdiomTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function segIdiomInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('segIdiomFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('segIdiomFrm.accion')){
		case "query": segIdiomQueryInitComponents(); break;
		case "view": segIdiomViewInitComponents(); break;
		case "create": segIdiomCreateInitComponents(); break;
		case "update": segIdiomUpdateInitComponents(); break;
		case "remove": segIdiomRemoveInitComponents(); break;
		case "lov": segIdiomLovInitComponents(); break;
	}
	//alert('accion :' + get('segIdiomFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('segIdiomFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segIdiom')) segIdiomCmdRequery();
}

function segIdiomQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('segIdiomFrm', true);	
}

function segIdiomViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('segIdiomFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('segIdiomFrm', true);
}

function segIdiomCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('segIdiomFrm.codIdio','S', GestionarMensaje('SegIdiom.codIdio.requiered.message'));
	
	setMV('segIdiomFrm.Descripcion','S', GestionarMensaje('SegIdiom.Descripcion.requiered.message'));
	
	setMV('segIdiomFrm.codIsoIdio','S', GestionarMensaje('SegIdiom.codIsoIdio.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('segIdiomFrm', true);
}

function segIdiomUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('segIdiomFrm.origen') == "pagina"){
		loadLocalizationWidget('segIdiomFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		segIdiomTmpUpdateValues = segIdiomBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('segIdiomFrm.codIdio','S', GestionarMensaje('SegIdiom.codIdio.requiered.message'));
		setMV('segIdiomFrm.Descripcion','S', GestionarMensaje('SegIdiom.Descripcion.requiered.message'));
		setMV('segIdiomFrm.codIsoIdio','S', GestionarMensaje('SegIdiom.codIsoIdio.requiered.message'));
		
			focusFirstFieldModify('segIdiomFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('segIdiomFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('segIdiomFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segIdiomRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	segIdiomList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('segIdiomFrm', true);
}

function segIdiomLovInitComponents(){
	segIdiomLovReturnParameters = window.dialogArguments;
	
	focusFirstField('segIdiomFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function segIdiomSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('segIdiomFrm.' + campo, id);
	set('segIdiomFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function segIdiomLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	segIdiomLovReturnParameters.id = '';
	segIdiomLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function segIdiomLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segIdiomList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = segIdiomList.codSeleccionados();
	var descripcion = segIdiomList.extraeDato(
		segIdiomList.codSeleccionados()[0], segIdiomChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	segIdiomLovReturnParameters.id = codigo;
	segIdiomLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function segIdiomCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('segIdiomFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('segIdiomFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "segIdiomList", "SegIdiomConectorTransactionQuery", 
		"result_ROWSET", parametros, "segIdiomPostQueryActions(datos);"]], "", "");	
}

function segIdiomCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('segIdiomFrm.lastQueryToSession'));
	var i =0;
	set('segIdiomFrm.codIdio', paramsRequery.ij(i++));
	
	set('segIdiomFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	segIdiomPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	segIdiomCmdQuery(segIdiomPageCount);
}

function segIdiomFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	segIdiomPageCount = 1;
	segIdiomCmdQuery(segIdiomPageCount);
}

function segIdiomPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segIdiomLastQuery){
		segIdiomFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	segIdiomPageCount--;
	segIdiomCmdQuery(segIdiomPageCount);
}

function segIdiomNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != segIdiomLastQuery){
		segIdiomFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	segIdiomPageCount++;
	segIdiomCmdQuery(segIdiomPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function segIdiomPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('segIdiomListLayer', 'O');
		visibilidad('segIdiomListButtonsLayer', 'O');
		if(get('segIdiomFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	segIdiomLastQuery = generateQuery();

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
		datosTmp.ij2("<A HREF=\'javascript:segIdiomViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, segIdiomChoiceColumn) + "</A>",
			i, segIdiomChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	segIdiomList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	segIdiomTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		segIdiomMorePagesFlag = true;
		segIdiomList.eliminar(mmgPageSize, 1);
	}else{
		segIdiomMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('segIdiomFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('segIdiomListLayer', 'V');
	visibilidad('segIdiomListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('segIdiomList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	segIdiomList.display();
	
	//Actualizamos el estado de los botones 
	if(segIdiomMorePagesFlag){
		set_estado_botonera('segIdiomPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('segIdiomPaginationButtonBar',
			3,"inactivo");
	}
	if(segIdiomPageCount > 1){
		set_estado_botonera('segIdiomPaginationButtonBar',
			2,"activo");
		set_estado_botonera('segIdiomPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('segIdiomPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('segIdiomPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function segIdiomUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segIdiomList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('segIdiomFrm.idSelection', segIdiomList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('segIdiomFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = segIdiomList.codSeleccionados()[0];
		parametros["previousAction"] = get('segIdiomFrm.accion');
		parametros["accion"] = get('segIdiomFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('SegIdiomLPStartUp', get('segIdiomFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) segIdiomCmdRequery();
	}
}

function segIdiomRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segIdiomList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = segIdiomList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('segIdiomFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(segIdiomList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += segIdiomTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('segIdiomFrm.timestamp', timestamps);


	segIdiomFrm.oculto='S';
	envia('segIdiomFrm');
	segIdiomFrm.oculto='N';
}

function segIdiomViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(segIdiomList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	segIdiomViewDetail(segIdiomList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function segIdiomViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segIdiomFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('SegIdiomLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('segIdiomFrm', 
		'Descripcion', 1,
		get('segIdiomFrm.Descripcion'));	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('segIdiomFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('segIdiomFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('SegIdiom.Descripcion.requiered.message'));
		focaliza('segIdiomFrm.Descripcion');
		return;
	}	
	
	
	
		
	
	if(validacion){
		segIdiomFrm.oculto='S';
		envia('segIdiomFrm');
		segIdiomFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	segIdiomRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('segIdiomFrm.accion');
	var origenTmp = get('segIdiomFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(segIdiomBuildUpdateRecordString() != segIdiomTmpUpdateValues){
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
	document.all.segIdiomListLayer.style.display='none';
	document.all.segIdiomListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.segIdiomListLayer.style.display='';
	document.all.segIdiomListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsSegIdiomCodIdio = get('segIdiomFrm.codIdio').toString();
	jsSegIdiomDescripcion = get('segIdiomFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsSegIdiomCodIdio + "|";
	parametros += jsSegIdiomDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function segIdiomBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsSegIdiomCodIdio + "|";
	parametros += jsSegIdiomDescripcion + "|";
	parametros += jsSegIdiomIndIdioTrad + "|";
	parametros += jsSegIdiomCodIsoIdio + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segIdiomFrm.accion'), 
		get('segIdiomFrm.origen'));
	
	jsSegIdiomId = get('segIdiomFrm.id').toString();
	jsSegIdiomCodIdio = get('segIdiomFrm.codIdio').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsSegIdiomDescripcion = buildLocalizedString('segIdiomFrm', 1);
	}else{
		jsSegIdiomDescripcion = get('segIdiomFrm.Descripcion');
	}
	if(get('segIdiomFrm.indIdioTrad').toString() == 'S') jsSegIdiomIndIdioTrad = "true";
		else jsSegIdiomIndIdioTrad = "false";
	jsSegIdiomCodIsoIdio = get('segIdiomFrm.codIsoIdio').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segIdiomFrm.accion'), 
		get('segIdiomFrm.origen'));


	set('segIdiomFrm.id', jsSegIdiomId);
	set('segIdiomFrm.codIdio', jsSegIdiomCodIdio);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('segIdiomFrm', 1,  jsSegIdiomDescripcion)
		loadLocalizationWidget('segIdiomFrm', 'Descripcion', 1);
	}else{
		set('segIdiomFrm.Descripcion', jsSegIdiomDescripcion);		
	}
	
			
			if(jsSegIdiomIndIdioTrad == "true") set('segIdiomFrm.indIdioTrad', 'S');
			else set('segIdiomFrm.indIdioTrad', 'N');
	set('segIdiomFrm.codIsoIdio', jsSegIdiomCodIsoIdio);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsSegIdiomCodIdio = '';
	jsSegIdiomDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segIdiomFrm.errCodigo', errorCode);
	set('segIdiomFrm.errDescripcion', description);
	set('segIdiomFrm.errSeverity', severity);
	fMostrarMensajeError();
}
