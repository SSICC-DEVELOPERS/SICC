

/*
    INDRA/CAR/mmg
    $Id: maeclasiview.js,v 1.1 2009/12/03 19:01:38 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeClasiViewId = "";
var jsMaeClasiViewTcclOidTipoClas = "";
var jsMaeClasiViewCodClas = "";
var jsMaeClasiViewDescripcion = "";

//Variables de paginacion, 
var maeClasiViewPageCount = 1;

//Varible de columna que representa el campo de choice
var maeClasiViewChoiceColumn = 2;

//Flag de siguiente pagina;
var maeClasiViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeClasiViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var maeClasiViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeClasiView","tcclOidTipoClas", false);','focalizaComboDependence("maeClasiView","tcclOidTipoClas", false);','focalizaComboDependence("maeClasiView","tcclOidTipoClas", false);','focalizaComboDependence("maeClasiView","tcclOidTipoClas", true);','focalizaComboDependence("maeClasiView","tcclOidTipoClas", true);','focalizaComboDependence("maeClasiView","tcclOidTipoClas", true);'],[3,'focaliza("maeClasiViewFrm.codClas");','focaliza("maeClasiViewFrm.codClas");','focaliza("maeClasiViewFrm.codClas");','focaliza("maeClasiViewFrm.codClas");','focaliza("maeClasiViewFrm.codClas");','focaliza("maeClasiViewFrm.codClas");'],[4,'focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");','focaliza("maeClasiViewFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var tcclOidTipoClasDependeceMap = new Vector();
tcclOidTipoClasDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tcclOidTipoClasDependeceMap.agregar(['tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', padresTmp, 'tcclOidTipoClas_sbtiOidSubtClie', 'MaeTipoClien']);
padresTmp =  new Vector();
padresTmp.cargar(['tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie'])
tcclOidTipoClasDependeceMap.agregar(['tcclOidTipoClas_sbtiOidSubtClie', padresTmp, 'tcclOidTipoClas', 'MaeSubtiClien']);
padresTmp =  new Vector();
padresTmp.cargar(['tcclOidTipoClas_sbtiOidSubtClie'])
tcclOidTipoClasDependeceMap.agregar(['tcclOidTipoClas', padresTmp, '', 'MaeTipoClasiClien']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeClasiViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeClasiViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeClasiViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeClasiViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeClasiViewFrm.accion')){
		case "query": maeClasiViewQueryInitComponents(); break;
		case "view": maeClasiViewViewInitComponents(); break;
		case "create": maeClasiViewCreateInitComponents(); break;
		case "update": maeClasiViewUpdateInitComponents(); break;
		case "remove": maeClasiViewRemoveInitComponents(); break;
		case "lov": maeClasiViewLovInitComponents(); break;
	}
	//alert('accion :' + get('maeClasiViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeClasiViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeClasiView')) maeClasiViewCmdRequery();
}

function maeClasiViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('maeClasiViewFrm', true);	
}

function maeClasiViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeClasiViewFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeClasiViewFrm', true);
}

function maeClasiViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeClasiViewFrm.tcclOidTipoClas','S', GestionarMensaje('MaeClasiView.tcclOidTipoClas.requiered.message'));
	
	setMV('maeClasiViewFrm.codClas','S', GestionarMensaje('MaeClasiView.codClas.requiered.message'));
	
	setMV('maeClasiViewFrm.Descripcion','S', GestionarMensaje('MaeClasiView.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeClasiViewFrm', true);
}

function maeClasiViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeClasiViewFrm.origen') == "pagina"){
		loadLocalizationWidget('maeClasiViewFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeClasiViewTmpUpdateValues = maeClasiViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeClasiViewFrm.tcclOidTipoClas','S', GestionarMensaje('MaeClasiView.tcclOidTipoClas.requiered.message'));
		setMV('maeClasiViewFrm.codClas','S', GestionarMensaje('MaeClasiView.codClas.requiered.message'));
		setMV('maeClasiViewFrm.Descripcion','S', GestionarMensaje('MaeClasiView.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeClasiViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('maeClasiViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeClasiViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeClasiViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeClasiViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeClasiViewFrm', true);
}

function maeClasiViewLovInitComponents(){
	maeClasiViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeClasiViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeClasiViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeClasiViewFrm.' + campo, id);
	set('maeClasiViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeClasiViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeClasiViewLovReturnParameters.id = '';
	maeClasiViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeClasiViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClasiViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeClasiViewList.codSeleccionados();
	var descripcion = maeClasiViewList.extraeDato(
		maeClasiViewList.codSeleccionados()[0], maeClasiViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeClasiViewLovReturnParameters.id = codigo;
	maeClasiViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeClasiViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeClasiViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeClasiViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeClasiViewList", "MaeClasiViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeClasiViewPostQueryActions(datos);"]], "", "");	
}

function maeClasiViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeClasiViewFrm.lastQueryToSession'));
	var i =0;
	set('maeClasiViewFrm.tcclOidTipoClas', [paramsRequery.ij(i++)]);
	
	set('maeClasiViewFrm.codClas', paramsRequery.ij(i++));
	
	set('maeClasiViewFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeClasiViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeClasiViewCmdQuery(maeClasiViewPageCount);
}

function maeClasiViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeClasiViewPageCount = 1;
	maeClasiViewCmdQuery(maeClasiViewPageCount);
}

function maeClasiViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClasiViewLastQuery){
		maeClasiViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeClasiViewPageCount--;
	maeClasiViewCmdQuery(maeClasiViewPageCount);
}

function maeClasiViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClasiViewLastQuery){
		maeClasiViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeClasiViewPageCount++;
	maeClasiViewCmdQuery(maeClasiViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeClasiViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeClasiViewListLayer', 'O');
		visibilidad('maeClasiViewListButtonsLayer', 'O');
		if(get('maeClasiViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeClasiViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeClasiViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeClasiViewChoiceColumn) + "</A>",
			i, maeClasiViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeClasiViewList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeClasiViewTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeClasiViewMorePagesFlag = true;
		maeClasiViewList.eliminar(mmgPageSize, 1);
	}else{
		maeClasiViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeClasiViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeClasiViewListLayer', 'V');
	visibilidad('maeClasiViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeClasiViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeClasiViewList.display();
	
	//Actualizamos el estado de los botones 
	if(maeClasiViewMorePagesFlag){
		set_estado_botonera('maeClasiViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeClasiViewPaginationButtonBar',
			3,"inactivo");
	}
	if(maeClasiViewPageCount > 1){
		set_estado_botonera('maeClasiViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeClasiViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeClasiViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeClasiViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeClasiViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClasiViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeClasiViewFrm.idSelection', maeClasiViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeClasiViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeClasiViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeClasiViewFrm.accion');
		parametros["accion"] = get('maeClasiViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeClasiViewLPStartUp', get('maeClasiViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeClasiViewCmdRequery();
	}
}

function maeClasiViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClasiViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeClasiViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeClasiViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeClasiViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeClasiViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeClasiViewFrm.timestamp', timestamps);


	maeClasiViewFrm.oculto='S';
	envia('maeClasiViewFrm');
	maeClasiViewFrm.oculto='N';
}

function maeClasiViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClasiViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeClasiViewViewDetail(maeClasiViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeClasiViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeClasiViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeClasiViewLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeClasiViewFrm', 
		'Descripcion', 1,
		get('maeClasiViewFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeClasiViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeClasiViewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeClasiView.Descripcion.requiered.message'));
		focaliza('maeClasiViewFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeClasiViewFrm.oculto='S';
		envia('maeClasiViewFrm');
		maeClasiViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeClasiViewFrm.tcclOidTipoClas').toString() == ''){
		set('maeClasiViewFrm.tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', 'tcclOidTipoClas', 'maeClasiView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeClasiViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeClasiViewFrm.accion');
	var origenTmp = get('maeClasiViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeClasiViewBuildUpdateRecordString() != maeClasiViewTmpUpdateValues){
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
	document.all.maeClasiViewListLayer.style.display='none';
	document.all.maeClasiViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeClasiViewListLayer.style.display='';
	document.all.maeClasiViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeClasiViewTcclOidTipoClas = get('maeClasiViewFrm.tcclOidTipoClas')[0];
	jsMaeClasiViewCodClas = get('maeClasiViewFrm.codClas').toString();
	jsMaeClasiViewDescripcion = get('maeClasiViewFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeClasiViewTcclOidTipoClas + "|";
	parametros += jsMaeClasiViewCodClas + "|";
	parametros += jsMaeClasiViewDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeClasiViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeClasiViewTcclOidTipoClas + "|";
	parametros += jsMaeClasiViewCodClas + "|";
	parametros += jsMaeClasiViewDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClasiViewFrm.accion'), 
		get('maeClasiViewFrm.origen'));
	
	jsMaeClasiViewId = get('maeClasiViewFrm.id').toString();
	jsMaeClasiViewTcclOidTipoClas = get('maeClasiViewFrm.tcclOidTipoClas')[0];
	jsMaeClasiViewCodClas = get('maeClasiViewFrm.codClas').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeClasiViewDescripcion = buildLocalizedString('maeClasiViewFrm', 1);
	}else{
		jsMaeClasiViewDescripcion = get('maeClasiViewFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClasiViewFrm.accion'), 
		get('maeClasiViewFrm.origen'));


	set('maeClasiViewFrm.id', jsMaeClasiViewId);
	set('maeClasiViewFrm.tcclOidTipoClas', [jsMaeClasiViewTcclOidTipoClas]);
	set('maeClasiViewFrm.codClas', jsMaeClasiViewCodClas);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeClasiViewFrm', 1,  jsMaeClasiViewDescripcion)
		loadLocalizationWidget('maeClasiViewFrm', 'Descripcion', 1);
	}else{
		set('maeClasiViewFrm.Descripcion', jsMaeClasiViewDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeClasiViewTcclOidTipoClas = '';
	jsMaeClasiViewCodClas = '';
	jsMaeClasiViewDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeClasiViewFrm.errCodigo', errorCode);
	set('maeClasiViewFrm.errDescripcion', description);
	set('maeClasiViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
