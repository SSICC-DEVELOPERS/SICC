

/*
    INDRA/CAR/mmg
    $Id: maetipoclienwiew.js,v 1.1 2009/12/03 19:02:08 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeTipoClienwiewId = "";
var jsMaeTipoClienwiewCodTipoClie = "";
var jsMaeTipoClienwiewDescripcion = "";
var jsMaeTipoClienwiewIndEvalEsta = "";
var jsMaeTipoClienwiewIndEmpl = "";
var jsMaeTipoClienwiewFopaOidFormPago = "";

//Variables de paginacion, 
var maeTipoClienwiewPageCount = 1;

//Varible de columna que representa el campo de choice
var maeTipoClienwiewChoiceColumn = 1;

//Flag de siguiente pagina;
var maeTipoClienwiewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeTipoClienwiewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 290;
var sizeFormView = 290;
var sizeFormUpdate = 255;

//Ultima busqueda realizada
var maeTipoClienwiewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("maeTipoClienwiewFrm.codTipoClie");','focaliza("maeTipoClienwiewFrm.codTipoClie");','','focaliza("maeTipoClienwiewFrm.codTipoClie");','focaliza("maeTipoClienwiewFrm.codTipoClie");',''],[3,'focaliza("maeTipoClienwiewFrm.Descripcion");','focaliza("maeTipoClienwiewFrm.Descripcion");','focaliza("maeTipoClienwiewFrm.Descripcion");','focaliza("maeTipoClienwiewFrm.Descripcion");','focaliza("maeTipoClienwiewFrm.Descripcion");','focaliza("maeTipoClienwiewFrm.Descripcion");'],[4,'focaliza("maeTipoClienwiewFrm.indEvalEsta");','focaliza("maeTipoClienwiewFrm.indEvalEsta");','focaliza("maeTipoClienwiewFrm.indEvalEsta");','focaliza("maeTipoClienwiewFrm.indEvalEsta");','focaliza("maeTipoClienwiewFrm.indEvalEsta");','focaliza("maeTipoClienwiewFrm.indEvalEsta");'],[5,'focaliza("maeTipoClienwiewFrm.indEmpl");','focaliza("maeTipoClienwiewFrm.indEmpl");','focaliza("maeTipoClienwiewFrm.indEmpl");','focaliza("maeTipoClienwiewFrm.indEmpl");','focaliza("maeTipoClienwiewFrm.indEmpl");','focaliza("maeTipoClienwiewFrm.indEmpl");'],[6,'focalizaComboDependence("maeTipoClienwiew","fopaOidFormPago", false);','focalizaComboDependence("maeTipoClienwiew","fopaOidFormPago", false);','focalizaComboDependence("maeTipoClienwiew","fopaOidFormPago", false);','focalizaComboDependence("maeTipoClienwiew","fopaOidFormPago", true);','focalizaComboDependence("maeTipoClienwiew","fopaOidFormPago", true);','focalizaComboDependence("maeTipoClienwiew","fopaOidFormPago", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var fopaOidFormPagoDependeceMap = new Vector();
fopaOidFormPagoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
fopaOidFormPagoDependeceMap.agregar(['fopaOidFormPago', padresTmp, '', 'BelFormaPago']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeTipoClienwiewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeTipoClienwiewTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeTipoClienwiewInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeTipoClienwiewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeTipoClienwiewFrm.accion')){
		case "query": maeTipoClienwiewQueryInitComponents(); break;
		case "view": maeTipoClienwiewViewInitComponents(); break;
		case "create": maeTipoClienwiewCreateInitComponents(); break;
		case "update": maeTipoClienwiewUpdateInitComponents(); break;
		case "remove": maeTipoClienwiewRemoveInitComponents(); break;
		case "lov": maeTipoClienwiewLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeTipoClienwiewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeTipoClienwiew')) maeTipoClienwiewCmdRequery();
}

function maeTipoClienwiewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
}

function maeTipoClienwiewViewInitComponents(){
	//En principiono se hace nada
}

function maeTipoClienwiewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeTipoClienwiewFrm.codTipoClie','S', GestionarMensaje('MaeTipoClienwiew.codTipoClie.requiered.message'));
	
	setMV('maeTipoClienwiewFrm.Descripcion','S', GestionarMensaje('MaeTipoClienwiew.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeTipoClienwiewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeTipoClienwiewFrm.origen') == "pagina"){
		loadLocalizationWidget('maeTipoClienwiewFrm', 'Descripcion', 1);
		

		//Registramos el valor del elemento que estamos modificando
		maeTipoClienwiewTmpUpdateValues = maeTipoClienwiewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeTipoClienwiewFrm.Descripcion','S', GestionarMensaje('MaeTipoClienwiew.Descripcion.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeTipoClienwiewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeTipoClienwiewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeTipoClienwiewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeTipoClienwiewLovInitComponents(){
	maeTipoClienwiewLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function maeTipoClienwiewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeTipoClienwiewFrm.' + campo, id);
	set('maeTipoClienwiewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeTipoClienwiewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeTipoClienwiewLovReturnParameters.id = '';
	maeTipoClienwiewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeTipoClienwiewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienwiewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeTipoClienwiewList.codSeleccionados();
	var descripcion = maeTipoClienwiewList.extraeDato(
		maeTipoClienwiewList.codSeleccionados()[0], maeTipoClienwiewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeTipoClienwiewLovReturnParameters.id = codigo;
	maeTipoClienwiewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeTipoClienwiewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeTipoClienwiewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeTipoClienwiewLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeTipoClienwiewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeTipoClienwiewList", "MaeTipoClienwiewConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeTipoClienwiewPostQueryActions(datos);"]], "", "");	
}

function maeTipoClienwiewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeTipoClienwiewFrm.lastQueryToSession'));
	var i =0;
	set('maeTipoClienwiewFrm.codTipoClie', paramsRequery.ij(i++));
	
	set('maeTipoClienwiewFrm.Descripcion', paramsRequery.ij(i++));
	
	set('maeTipoClienwiewFrm.indEvalEsta', (paramsRequery.ij(i++) == 'true'? 'S': 'N'));
	
	set('maeTipoClienwiewFrm.indEmpl', (paramsRequery.ij(i++) == 'true'? 'S': 'N'));
	
	set('maeTipoClienwiewFrm.fopaOidFormPago', [paramsRequery.ij(i++)]);
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	maeTipoClienwiewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeTipoClienwiewCmdQuery(maeTipoClienwiewPageCount);
}

function maeTipoClienwiewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeTipoClienwiewPageCount = 1;
	maeTipoClienwiewCmdQuery(maeTipoClienwiewPageCount);
}

function maeTipoClienwiewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoClienwiewLastQuery){
		maeTipoClienwiewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeTipoClienwiewPageCount--;
	maeTipoClienwiewCmdQuery(maeTipoClienwiewPageCount);
}

function maeTipoClienwiewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoClienwiewLastQuery){
		maeTipoClienwiewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeTipoClienwiewPageCount++;
	maeTipoClienwiewCmdQuery(maeTipoClienwiewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeTipoClienwiewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeTipoClienwiewListLayer', 'O');
		visibilidad('maeTipoClienwiewListButtonsLayer', 'O');
		visibilidad('maeTipoClienwiewPreListLayer', 'O');
		if(get('maeTipoClienwiewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}

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
		datosTmp.ij2("<A HREF=\'javascript:maeTipoClienwiewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeTipoClienwiewChoiceColumn) + "</A>",
			i, maeTipoClienwiewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeTipoClienwiewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeTipoClienwiewTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeTipoClienwiewMorePagesFlag = true;
		maeTipoClienwiewList.eliminar(mmgPageSize, 1);
	}else{
		maeTipoClienwiewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeTipoClienwiewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeTipoClienwiewListLayer', 'V');
	visibilidad('maeTipoClienwiewListButtonsLayer', 'V');
	visibilidad('maeTipoClienwiewPreListLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeTipoClienwiewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeTipoClienwiewList.display();
	
	//Actualizamos el estado de los botones 
	if(maeTipoClienwiewMorePagesFlag){
		set_estado_botonera('maeTipoClienwiewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeTipoClienwiewPaginationButtonBar',
			3,"inactivo");
	}
	if(maeTipoClienwiewPageCount > 1){
		set_estado_botonera('maeTipoClienwiewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeTipoClienwiewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeTipoClienwiewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeTipoClienwiewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeTipoClienwiewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienwiewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeTipoClienwiewFrm.idSelection', maeTipoClienwiewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeTipoClienwiewFrm', true);
	if(validacion){
		/*set('maeTipoClienwiewFrm.previousAction', 'update');
		set('maeTipoClienwiewFrm.ON', 'MaeTipoClienwiewLPStartUp');
		set('maeTipoClienwiewFrm.conectorAction', 'MaeTipoClienwiewLPStartUp');
		set('maeTipoClienwiewFrm.origen', 'pagina');
		envia('maeTipoClienwiewFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = maeTipoClienwiewList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeTipoClienwiewFrm.accion');
		parametros["accion"] = get('maeTipoClienwiewFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeTipoClienwiewLPStartUp', get('maeTipoClienwiewFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) maeTipoClienwiewCmdRequery();
	}
}

function maeTipoClienwiewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienwiewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeTipoClienwiewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeTipoClienwiewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeTipoClienwiewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeTipoClienwiewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeTipoClienwiewFrm.timestamp', timestamps);
	envia('maeTipoClienwiewFrm');
}

function maeTipoClienwiewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienwiewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('maeTipoClienwiewFrm.previousAction', get('maeTipoClienwiewFrm.accion'));
	set('maeTipoClienwiewFrm.accion', 'view');
	set('maeTipoClienwiewFrm.origen', 'pagina');
	set('maeTipoClienwiewFrm.ON', 'MaeTipoClienwiewLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('maeTipoClienwiewFrm.idSelection', maeTipoClienwiewList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('maeTipoClienwiewFrm');
	maeTipoClienwiewViewDetail(maeTipoClienwiewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeTipoClienwiewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeTipoClienwiewFrm.accion');
	parametros["accion"] = get('maeTipoClienwiewFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeTipoClienwiewLPStartUp', get('maeTipoClienwiewFrm.accion'), parametros, null, sizeFormView + 30);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('maeTipoClienwiewFrm', 
		'Descripcion', 1,
		get('maeTipoClienwiewFrm.Descripcion'));	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeTipoClienwiewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('maeTipoClienwiewFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeTipoClienwiew.Descripcion.requiered.message'));
		focaliza('maeTipoClienwiewFrm.Descripcion');
		return;
	}	
	
	
	
	
		
	
	if(validacion)envia('maeTipoClienwiewFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeTipoClienwiewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeTipoClienwiewFrm.accion');
	var origenTmp = get('maeTipoClienwiewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeTipoClienwiewBuildUpdateRecordString() != maeTipoClienwiewTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('maeTipoClienwiewFrm.performRequery', 'true');
		set('maeTipoClienwiewFrm.accion', 
			get('maeTipoClienwiewFrm.previousAction'));
		set('maeTipoClienwiewFrm.origen', 'menu');
		set('maeTipoClienwiewFrm.ON', 'MaeTipoClienwiewLPStartUp');
		set('maeTipoClienwiewFrm.conectorAction', 'MaeTipoClienwiewLPStartUp');
		maeTipoClienwiewFrm.oculto='N';
		envia('maeTipoClienwiewFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.maeTipoClienwiewListLayer.style.display='none';
	document.all.maeTipoClienwiewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeTipoClienwiewListLayer.style.display='';
	document.all.maeTipoClienwiewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeTipoClienwiewCodTipoClie = get('maeTipoClienwiewFrm.codTipoClie').toString();






	jsMaeTipoClienwiewDescripcion = get('maeTipoClienwiewFrm.Descripcion').toString();









		if(get('maeTipoClienwiewFrm.indEvalEsta').toString() == 'S') jsMaeTipoClienwiewIndEvalEsta = "true";
		else jsMaeTipoClienwiewIndEvalEsta = "false";






		if(get('maeTipoClienwiewFrm.indEmpl').toString() == 'S') jsMaeTipoClienwiewIndEmpl = "true";
		else jsMaeTipoClienwiewIndEmpl = "false";




	jsMaeTipoClienwiewFopaOidFormPago = get('maeTipoClienwiewFrm.fopaOidFormPago')[0];






	var parametros = "";
	parametros += jsMaeTipoClienwiewCodTipoClie + "|";



	parametros += jsMaeTipoClienwiewDescripcion + "|";



	parametros += jsMaeTipoClienwiewIndEvalEsta + "|";



	parametros += jsMaeTipoClienwiewIndEmpl + "|";



	parametros += jsMaeTipoClienwiewFopaOidFormPago + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeTipoClienwiewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeTipoClienwiewDescripcion + "|";
	parametros += jsMaeTipoClienwiewIndEvalEsta + "|";
	parametros += jsMaeTipoClienwiewIndEmpl + "|";
	parametros += jsMaeTipoClienwiewFopaOidFormPago + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoClienwiewFrm.accion'), 
		get('maeTipoClienwiewFrm.origen'));
	
	jsMaeTipoClienwiewId = get('maeTipoClienwiewFrm.id').toString();
	jsMaeTipoClienwiewCodTipoClie = get('maeTipoClienwiewFrm.codTipoClie').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeTipoClienwiewDescripcion = buildLocalizedString('maeTipoClienwiewFrm', 1);
	}else{
		jsMaeTipoClienwiewDescripcion = get('maeTipoClienwiewFrm.Descripcion');
	}
	if(get('maeTipoClienwiewFrm.indEvalEsta').toString() == 'S') jsMaeTipoClienwiewIndEvalEsta = "true";
	else jsMaeTipoClienwiewIndEvalEsta = "false";
	if(get('maeTipoClienwiewFrm.indEmpl').toString() == 'S') jsMaeTipoClienwiewIndEmpl = "true";
	else jsMaeTipoClienwiewIndEmpl = "false";
	jsMaeTipoClienwiewFopaOidFormPago = get('maeTipoClienwiewFrm.fopaOidFormPago')[0];

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoClienwiewFrm.accion'), 
		get('maeTipoClienwiewFrm.origen'));


	set('maeTipoClienwiewFrm.id', jsMaeTipoClienwiewId);
	set('maeTipoClienwiewFrm.codTipoClie', jsMaeTipoClienwiewCodTipoClie);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeTipoClienwiewFrm', 1,  jsMaeTipoClienwiewDescripcion)
		loadLocalizationWidget('maeTipoClienwiewFrm', 'Descripcion', 1);
	}else{
		set('maeTipoClienwiewFrm.Descripcion', jsMaeTipoClienwiewDescripcion);		
	}

		
		if(jsMaeTipoClienwiewIndEvalEsta == "true") set('maeTipoClienwiewFrm.indEvalEsta', 'S');
		else set('maeTipoClienwiewFrm.indEvalEsta', 'N');

		
		if(jsMaeTipoClienwiewIndEmpl == "true") set('maeTipoClienwiewFrm.indEmpl', 'S');
		else set('maeTipoClienwiewFrm.indEmpl', 'N');
	set('maeTipoClienwiewFrm.fopaOidFormPago', [jsMaeTipoClienwiewFopaOidFormPago]);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeTipoClienwiewFrm.errCodigo', errorCode);
	set('maeTipoClienwiewFrm.errDescripcion', description);
	set('maeTipoClienwiewFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
