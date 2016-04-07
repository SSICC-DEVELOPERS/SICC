

/*
    INDRA/CAR/mmg
    $Id: maetipoclienview.js,v 1.1 2009/12/03 19:02:10 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeTipoClienViewId = "";
var jsMaeTipoClienViewCodTipoClie = "";
var jsMaeTipoClienViewDescripcion = "";
var jsMaeTipoClienViewIndEvalEsta = "";
var jsMaeTipoClienViewIndEmpl = "";

//Variables de paginacion, 
var maeTipoClienViewPageCount = 1;

//Varible de columna que representa el campo de choice
var maeTipoClienViewChoiceColumn = 1;

//Flag de siguiente pagina;
var maeTipoClienViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeTipoClienViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 125;
var sizeFormUpdate = 125;

//Ultima busqueda realizada
var maeTipoClienViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("maeTipoClienViewFrm.codTipoClie");','focaliza("maeTipoClienViewFrm.codTipoClie");','','focaliza("maeTipoClienViewFrm.codTipoClie");','focaliza("maeTipoClienViewFrm.codTipoClie");',''],[3,'focaliza("maeTipoClienViewFrm.Descripcion");','focaliza("maeTipoClienViewFrm.Descripcion");','focaliza("maeTipoClienViewFrm.Descripcion");','focaliza("maeTipoClienViewFrm.Descripcion");','focaliza("maeTipoClienViewFrm.Descripcion");','focaliza("maeTipoClienViewFrm.Descripcion");'],[4,'focaliza("maeTipoClienViewFrm.indEvalEsta");','focaliza("maeTipoClienViewFrm.indEvalEsta");','focaliza("maeTipoClienViewFrm.indEvalEsta");','focaliza("maeTipoClienViewFrm.indEvalEsta");','focaliza("maeTipoClienViewFrm.indEvalEsta");','focaliza("maeTipoClienViewFrm.indEvalEsta");'],[5,'focaliza("maeTipoClienViewFrm.indEmpl");','focaliza("maeTipoClienViewFrm.indEmpl");','focaliza("maeTipoClienViewFrm.indEmpl");','focaliza("maeTipoClienViewFrm.indEmpl");','focaliza("maeTipoClienViewFrm.indEmpl");','focaliza("maeTipoClienViewFrm.indEmpl");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeTipoClienViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeTipoClienViewTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeTipoClienViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeTipoClienViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeTipoClienViewFrm.accion')){
		case "query": maeTipoClienViewQueryInitComponents(); break;
		case "view": maeTipoClienViewViewInitComponents(); break;
		case "create": maeTipoClienViewCreateInitComponents(); break;
		case "update": maeTipoClienViewUpdateInitComponents(); break;
		case "remove": maeTipoClienViewRemoveInitComponents(); break;
		case "lov": maeTipoClienViewLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeTipoClienViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeTipoClienView')) maeTipoClienViewCmdRequery();
}

function maeTipoClienViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
}

function maeTipoClienViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeTipoClienViewFrm', 'Descripcion', 1);
	
		
	
}

function maeTipoClienViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeTipoClienViewFrm.codTipoClie','S', GestionarMensaje('MaeTipoClienView.codTipoClie.requiered.message'));
	
	setMV('maeTipoClienViewFrm.Descripcion','S', GestionarMensaje('MaeTipoClienView.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeTipoClienViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeTipoClienViewFrm.origen') == "pagina"){
		loadLocalizationWidget('maeTipoClienViewFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeTipoClienViewTmpUpdateValues = maeTipoClienViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeTipoClienViewFrm.Descripcion','S', GestionarMensaje('MaeTipoClienView.Descripcion.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeTipoClienViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeTipoClienViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeTipoClienViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeTipoClienViewLovInitComponents(){
	maeTipoClienViewLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function maeTipoClienViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeTipoClienViewFrm.' + campo, id);
	set('maeTipoClienViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeTipoClienViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeTipoClienViewLovReturnParameters.id = '';
	maeTipoClienViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeTipoClienViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeTipoClienViewList.codSeleccionados();
	var descripcion = maeTipoClienViewList.extraeDato(
		maeTipoClienViewList.codSeleccionados()[0], maeTipoClienViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeTipoClienViewLovReturnParameters.id = codigo;
	maeTipoClienViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeTipoClienViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeTipoClienViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeTipoClienViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeTipoClienViewList", "MaeTipoClienViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeTipoClienViewPostQueryActions(datos);"]], "", "");	
}

function maeTipoClienViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeTipoClienViewFrm.lastQueryToSession'));
	var i =0;
	set('maeTipoClienViewFrm.codTipoClie', paramsRequery.ij(i++));
	
	set('maeTipoClienViewFrm.Descripcion', paramsRequery.ij(i++));
	
	set('maeTipoClienViewFrm.indEvalEsta', (paramsRequery.ij(i++) == 'true'? 'S': 'N'));
	
	set('maeTipoClienViewFrm.indEmpl', (paramsRequery.ij(i++) == 'true'? 'S': 'N'));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeTipoClienViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeTipoClienViewCmdQuery(maeTipoClienViewPageCount);
}

function maeTipoClienViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeTipoClienViewPageCount = 1;
	maeTipoClienViewCmdQuery(maeTipoClienViewPageCount);
}

function maeTipoClienViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoClienViewLastQuery){
		maeTipoClienViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeTipoClienViewPageCount--;
	maeTipoClienViewCmdQuery(maeTipoClienViewPageCount);
}

function maeTipoClienViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoClienViewLastQuery){
		maeTipoClienViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeTipoClienViewPageCount++;
	maeTipoClienViewCmdQuery(maeTipoClienViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeTipoClienViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeTipoClienViewListLayer', 'O');
		visibilidad('maeTipoClienViewListButtonsLayer', 'O');
		if(get('maeTipoClienViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeTipoClienViewLastQuery = generateQuery();

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
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeTipoClienViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeTipoClienViewChoiceColumn) + "</A>",
			i, maeTipoClienViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeTipoClienViewList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeTipoClienViewTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeTipoClienViewMorePagesFlag = true;
		maeTipoClienViewList.eliminar(mmgPageSize, 1);
	}else{
		maeTipoClienViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeTipoClienViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeTipoClienViewListLayer', 'V');
	visibilidad('maeTipoClienViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeTipoClienViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeTipoClienViewList.display();
	
	//Actualizamos el estado de los botones 
	if(maeTipoClienViewMorePagesFlag){
		set_estado_botonera('maeTipoClienViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeTipoClienViewPaginationButtonBar',
			3,"inactivo");
	}
	if(maeTipoClienViewPageCount > 1){
		set_estado_botonera('maeTipoClienViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeTipoClienViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeTipoClienViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeTipoClienViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeTipoClienViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeTipoClienViewFrm.idSelection', maeTipoClienViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeTipoClienViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeTipoClienViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeTipoClienViewFrm.accion');
		parametros["accion"] = get('maeTipoClienViewFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeTipoClienViewLPStartUp', get('maeTipoClienViewFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) maeTipoClienViewCmdRequery();
	}
}

function maeTipoClienViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeTipoClienViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeTipoClienViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeTipoClienViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeTipoClienViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeTipoClienViewFrm.timestamp', timestamps);


	maeTipoClienViewFrm.oculto='S';
	envia('maeTipoClienViewFrm');
	maeTipoClienViewFrm.oculto='N';
}

function maeTipoClienViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeTipoClienViewViewDetail(maeTipoClienViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeTipoClienViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeTipoClienViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeTipoClienViewLPStartUp', 'view', parametros, null, sizeFormView + 55);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('maeTipoClienViewFrm', 
		'Descripcion', 1,
		get('maeTipoClienViewFrm.Descripcion'));	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeTipoClienViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('maeTipoClienViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeTipoClienView.Descripcion.requiered.message'));
		focaliza('maeTipoClienViewFrm.Descripcion');
		return;
	}	
	
	
	
		
	
	if(validacion){
		maeTipoClienViewFrm.oculto='S';
		envia('maeTipoClienViewFrm');
		maeTipoClienViewFrm.oculto='N';
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
	maeTipoClienViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeTipoClienViewFrm.accion');
	var origenTmp = get('maeTipoClienViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeTipoClienViewBuildUpdateRecordString() != maeTipoClienViewTmpUpdateValues){
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
	document.all.maeTipoClienViewListLayer.style.display='none';
	document.all.maeTipoClienViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeTipoClienViewListLayer.style.display='';
	document.all.maeTipoClienViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeTipoClienViewCodTipoClie = get('maeTipoClienViewFrm.codTipoClie').toString();
	jsMaeTipoClienViewDescripcion = get('maeTipoClienViewFrm.Descripcion').toString();
	if(get('maeTipoClienViewFrm.indEvalEsta').toString() == 'S') jsMaeTipoClienViewIndEvalEsta = "true";
	else jsMaeTipoClienViewIndEvalEsta = "false";
	if(get('maeTipoClienViewFrm.indEmpl').toString() == 'S') jsMaeTipoClienViewIndEmpl = "true";
	else jsMaeTipoClienViewIndEmpl = "false";
	
	
	var parametros = "";
	parametros += jsMaeTipoClienViewCodTipoClie + "|";
	parametros += jsMaeTipoClienViewDescripcion + "|";
	parametros += jsMaeTipoClienViewIndEvalEsta + "|";
	parametros += jsMaeTipoClienViewIndEmpl + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeTipoClienViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeTipoClienViewDescripcion + "|";
	parametros += jsMaeTipoClienViewIndEvalEsta + "|";
	parametros += jsMaeTipoClienViewIndEmpl + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoClienViewFrm.accion'), 
		get('maeTipoClienViewFrm.origen'));
	
	jsMaeTipoClienViewId = get('maeTipoClienViewFrm.id').toString();
	jsMaeTipoClienViewCodTipoClie = get('maeTipoClienViewFrm.codTipoClie').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeTipoClienViewDescripcion = buildLocalizedString('maeTipoClienViewFrm', 1);
	}else{
		jsMaeTipoClienViewDescripcion = get('maeTipoClienViewFrm.Descripcion');
	}
	if(get('maeTipoClienViewFrm.indEvalEsta').toString() == 'S') jsMaeTipoClienViewIndEvalEsta = "true";
		else jsMaeTipoClienViewIndEvalEsta = "false";
	if(get('maeTipoClienViewFrm.indEmpl').toString() == 'S') jsMaeTipoClienViewIndEmpl = "true";
		else jsMaeTipoClienViewIndEmpl = "false";
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoClienViewFrm.accion'), 
		get('maeTipoClienViewFrm.origen'));


	set('maeTipoClienViewFrm.id', jsMaeTipoClienViewId);
	set('maeTipoClienViewFrm.codTipoClie', jsMaeTipoClienViewCodTipoClie);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeTipoClienViewFrm', 1,  jsMaeTipoClienViewDescripcion)
		loadLocalizationWidget('maeTipoClienViewFrm', 'Descripcion', 1);
	}else{
		set('maeTipoClienViewFrm.Descripcion', jsMaeTipoClienViewDescripcion);		
	}
	
			
			if(jsMaeTipoClienViewIndEvalEsta == "true") set('maeTipoClienViewFrm.indEvalEsta', 'S');
			else set('maeTipoClienViewFrm.indEvalEsta', 'N');
	
			
			if(jsMaeTipoClienViewIndEmpl == "true") set('maeTipoClienViewFrm.indEmpl', 'S');
			else set('maeTipoClienViewFrm.indEmpl', 'N');
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeTipoClienViewCodTipoClie = '';
	jsMaeTipoClienViewDescripcion = '';
	jsMaeTipoClienViewIndEvalEsta = '';
	jsMaeTipoClienViewIndEmpl = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeTipoClienViewFrm.errCodigo', errorCode);
	set('maeTipoClienViewFrm.errDescripcion', description);
	set('maeTipoClienViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
