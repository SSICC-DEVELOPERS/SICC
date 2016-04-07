

/*
    INDRA/CAR/mmg
    $Id: maeclasi.js,v 1.1 2009/12/03 19:01:55 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeClasiId = "";
var jsMaeClasiTcclOidTipoClas = "";
var jsMaeClasiCodClas = "";
var jsMaeClasiDescripcion = "";

//Variables de paginacion, 
var maeClasiPageCount = 1;

//Varible de columna que representa el campo de choice
var maeClasiChoiceColumn = 2;

//Flag de siguiente pagina;
var maeClasiMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeClasiTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var maeClasiLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeClasi","tcclOidTipoClas", false);','focalizaComboDependence("maeClasi","tcclOidTipoClas", false);','focalizaComboDependence("maeClasi","tcclOidTipoClas", false);','focalizaComboDependence("maeClasi","tcclOidTipoClas", true);','focalizaComboDependence("maeClasi","tcclOidTipoClas", true);','focalizaComboDependence("maeClasi","tcclOidTipoClas", true);'],[3,'focaliza("maeClasiFrm.codClas");','focaliza("maeClasiFrm.codClas");','focaliza("maeClasiFrm.codClas");','focaliza("maeClasiFrm.codClas");','focaliza("maeClasiFrm.codClas");','focaliza("maeClasiFrm.codClas");'],[4,'focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");','focaliza("maeClasiFrm.Descripcion");']]);

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
maeClasiLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeClasiTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeClasiInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeClasiFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeClasiFrm.accion')){
		case "query": maeClasiQueryInitComponents(); break;
		case "view": maeClasiViewInitComponents(); break;
		case "create": maeClasiCreateInitComponents(); break;
		case "update": maeClasiUpdateInitComponents(); break;
		case "remove": maeClasiRemoveInitComponents(); break;
		case "lov": maeClasiLovInitComponents(); break;
	}
	//alert('accion :' + get('maeClasiFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeClasiFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeClasi')) maeClasiCmdRequery();
}

function maeClasiQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('maeClasiFrm', true);	
}

function maeClasiViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeClasiFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeClasiFrm', true);
}

function maeClasiCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeClasiFrm.tcclOidTipoClas','S', GestionarMensaje('MaeClasi.tcclOidTipoClas.requiered.message'));
	
	setMV('maeClasiFrm.codClas','S', GestionarMensaje('MaeClasi.codClas.requiered.message'));
	
	setMV('maeClasiFrm.Descripcion','S', GestionarMensaje('MaeClasi.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeClasiFrm', true);
}

function maeClasiUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeClasiFrm.origen') == "pagina"){
		loadLocalizationWidget('maeClasiFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeClasiTmpUpdateValues = maeClasiBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeClasiFrm.tcclOidTipoClas','S', GestionarMensaje('MaeClasi.tcclOidTipoClas.requiered.message'));
		setMV('maeClasiFrm.codClas','S', GestionarMensaje('MaeClasi.codClas.requiered.message'));
		setMV('maeClasiFrm.Descripcion','S', GestionarMensaje('MaeClasi.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeClasiFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('maeClasiFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeClasiFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeClasiRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeClasiList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeClasiFrm', true);
}

function maeClasiLovInitComponents(){
	maeClasiLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeClasiFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeClasiSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeClasiFrm.' + campo, id);
	set('maeClasiFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeClasiLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeClasiLovReturnParameters.id = '';
	maeClasiLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeClasiLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClasiList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeClasiList.codSeleccionados();
	var descripcion = maeClasiList.extraeDato(
		maeClasiList.codSeleccionados()[0], maeClasiChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeClasiLovReturnParameters.id = codigo;
	maeClasiLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeClasiCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeClasiFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeClasiFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeClasiList", "MaeClasiConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeClasiPostQueryActions(datos);"]], "", "");	
}

function maeClasiCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeClasiFrm.lastQueryToSession'));
	var i =0;
	set('maeClasiFrm.tcclOidTipoClas', [paramsRequery.ij(i++)]);
	
	set('maeClasiFrm.codClas', paramsRequery.ij(i++));
	
	set('maeClasiFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeClasiPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeClasiCmdQuery(maeClasiPageCount);
}

function maeClasiFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeClasiPageCount = 1;
	maeClasiCmdQuery(maeClasiPageCount);
}

function maeClasiPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClasiLastQuery){
		maeClasiFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeClasiPageCount--;
	maeClasiCmdQuery(maeClasiPageCount);
}

function maeClasiNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeClasiLastQuery){
		maeClasiFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeClasiPageCount++;
	maeClasiCmdQuery(maeClasiPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeClasiPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeClasiListLayer', 'O');
		visibilidad('maeClasiListButtonsLayer', 'O');
		if(get('maeClasiFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeClasiLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeClasiViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeClasiChoiceColumn) + "</A>",
			i, maeClasiChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeClasiList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeClasiTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeClasiMorePagesFlag = true;
		maeClasiList.eliminar(mmgPageSize, 1);
	}else{
		maeClasiMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeClasiFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeClasiListLayer', 'V');
	visibilidad('maeClasiListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeClasiList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeClasiList.display();
	
	//Actualizamos el estado de los botones 
	if(maeClasiMorePagesFlag){
		set_estado_botonera('maeClasiPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeClasiPaginationButtonBar',
			3,"inactivo");
	}
	if(maeClasiPageCount > 1){
		set_estado_botonera('maeClasiPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeClasiPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeClasiPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeClasiPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeClasiUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClasiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeClasiFrm.idSelection', maeClasiList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeClasiFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeClasiList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeClasiFrm.accion');
		parametros["accion"] = get('maeClasiFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeClasiLPStartUp', get('maeClasiFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeClasiCmdRequery();
	}
}

function maeClasiRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClasiList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeClasiList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeClasiFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeClasiList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeClasiTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeClasiFrm.timestamp', timestamps);


	maeClasiFrm.oculto='S';
	envia('maeClasiFrm');
	maeClasiFrm.oculto='N';
}

function maeClasiViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeClasiList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeClasiViewDetail(maeClasiList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeClasiViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeClasiFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeClasiLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeClasiFrm', 
		'Descripcion', 1,
		get('maeClasiFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeClasiFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeClasiFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeClasi.Descripcion.requiered.message'));
		focaliza('maeClasiFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeClasiFrm.oculto='S';
		envia('maeClasiFrm');
		maeClasiFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeClasiFrm.tcclOidTipoClas').toString() == ''){
		set('maeClasiFrm.tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', []);
		mmgResetCombosOnCascade('tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', 'tcclOidTipoClas', 'maeClasi');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeClasiRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeClasiFrm.accion');
	var origenTmp = get('maeClasiFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeClasiBuildUpdateRecordString() != maeClasiTmpUpdateValues){
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
	document.all.maeClasiListLayer.style.display='none';
	document.all.maeClasiListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeClasiListLayer.style.display='';
	document.all.maeClasiListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeClasiTcclOidTipoClas = get('maeClasiFrm.tcclOidTipoClas')[0];
	jsMaeClasiCodClas = get('maeClasiFrm.codClas').toString();
	jsMaeClasiDescripcion = get('maeClasiFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeClasiTcclOidTipoClas + "|";
	parametros += jsMaeClasiCodClas + "|";
	parametros += jsMaeClasiDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeClasiBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeClasiTcclOidTipoClas + "|";
	parametros += jsMaeClasiCodClas + "|";
	parametros += jsMaeClasiDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClasiFrm.accion'), 
		get('maeClasiFrm.origen'));
	
	jsMaeClasiId = get('maeClasiFrm.id').toString();
	jsMaeClasiTcclOidTipoClas = get('maeClasiFrm.tcclOidTipoClas')[0];
	jsMaeClasiCodClas = get('maeClasiFrm.codClas').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeClasiDescripcion = buildLocalizedString('maeClasiFrm', 1);
	}else{
		jsMaeClasiDescripcion = get('maeClasiFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClasiFrm.accion'), 
		get('maeClasiFrm.origen'));


	set('maeClasiFrm.id', jsMaeClasiId);
	set('maeClasiFrm.tcclOidTipoClas', [jsMaeClasiTcclOidTipoClas]);
	set('maeClasiFrm.codClas', jsMaeClasiCodClas);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeClasiFrm', 1,  jsMaeClasiDescripcion)
		loadLocalizationWidget('maeClasiFrm', 'Descripcion', 1);
	}else{
		set('maeClasiFrm.Descripcion', jsMaeClasiDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeClasiTcclOidTipoClas = '';
	jsMaeClasiCodClas = '';
	jsMaeClasiDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeClasiFrm.errCodigo', errorCode);
	set('maeClasiFrm.errDescripcion', description);
	set('maeClasiFrm.errSeverity', severity);
	fMostrarMensajeError();
}
