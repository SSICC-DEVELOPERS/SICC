

/*
    INDRA/CAR/mmg
    $Id: recparamnmper.js,v 1.1 2009/12/03 19:01:32 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsRecParamNmperId = "";
var jsRecParamNmperTiclOidTipoClie = "";
var jsRecParamNmperPperOidPrecPerd = "";
var jsRecParamNmperValPorcReca = "";
var jsRecParamNmperIndParaModi = "";
var jsRecParamNmperPaisOidPais = "";

//Variables de paginacion, 
var recParamNmperPageCount = 1;

//Varible de columna que representa el campo de choice
var recParamNmperChoiceColumn = 4;

//Flag de siguiente pagina;
var recParamNmperMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var recParamNmperTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 231;
var sizeFormView = 217;
var sizeFormUpdate = 217;

//Ultima busqueda realizada
var recParamNmperLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("recParamNmper","ticlOidTipoClie", false);','focalizaComboDependence("recParamNmper","ticlOidTipoClie", false);','focalizaComboDependence("recParamNmper","ticlOidTipoClie", false);','focalizaComboDependence("recParamNmper","ticlOidTipoClie", true);','focalizaComboDependence("recParamNmper","ticlOidTipoClie", true);','focalizaComboDependence("recParamNmper","ticlOidTipoClie", true);'],[3,'focalizaComboDependence("recParamNmper","pperOidPrecPerd", false);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", false);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", false);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", true);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", true);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", true);'],[4,'focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");'],[5,'focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");'],[6,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focalizaComboDependence("recParamNmper","pperOidPrecPerd", false);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", false);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", false);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", true);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", true);','focalizaComboDependence("recParamNmper","pperOidPrecPerd", true);'],[4,'focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");','focaliza("recParamNmperFrm.valPorcReca");'],[5,'focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");','focaliza("recParamNmperFrm.indParaModi");'],[6,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var ticlOidTipoClieDependeceMap = new Vector();
ticlOidTipoClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ticlOidTipoClieDependeceMap.agregar(['ticlOidTipoClie', padresTmp, '', 'MaeTipoClien']);
var pperOidPrecPerdDependeceMap = new Vector();
pperOidPrecPerdDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
pperOidPrecPerdDependeceMap.agregar(['pperOidPrecPerd', padresTmp, '', 'RecPreciPerdi']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
recParamNmperLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var recParamNmperTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function recParamNmperInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('recParamNmperFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('recParamNmperFrm.accion')){
		case "query": recParamNmperQueryInitComponents(); break;
		case "view": recParamNmperViewInitComponents(); break;
		case "create": recParamNmperCreateInitComponents(); break;
		case "update": recParamNmperUpdateInitComponents(); break;
		case "remove": recParamNmperRemoveInitComponents(); break;
		case "lov": recParamNmperLovInitComponents(); break;
	}
	//alert('accion :' + get('recParamNmperFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('recParamNmperFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('recParamNmper')) recParamNmperCmdRequery();
}

function recParamNmperQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('recParamNmperFrm', true);	
}

function recParamNmperViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('recParamNmperFrm', true);
}

function recParamNmperCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('recParamNmperFrm.ticlOidTipoClie','S', GestionarMensaje('RecParamNmper.ticlOidTipoClie.requiered.message'));
	
	setMV('recParamNmperFrm.pperOidPrecPerd','S', GestionarMensaje('RecParamNmper.pperOidPrecPerd.requiered.message'));
	
	setMV('recParamNmperFrm.valPorcReca','S', GestionarMensaje('RecParamNmper.valPorcReca.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('recParamNmperFrm', true);
}

function recParamNmperUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('recParamNmperFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		recParamNmperTmpUpdateValues = recParamNmperBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('recParamNmperFrm.ticlOidTipoClie','S', GestionarMensaje('RecParamNmper.ticlOidTipoClie.requiered.message'));
		setMV('recParamNmperFrm.pperOidPrecPerd','S', GestionarMensaje('RecParamNmper.pperOidPrecPerd.requiered.message'));
		setMV('recParamNmperFrm.valPorcReca','S', GestionarMensaje('RecParamNmper.valPorcReca.requiered.message'));
		
			focusFirstFieldModify('recParamNmperFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('recParamNmperFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('recParamNmperFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function recParamNmperRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	recParamNmperList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('recParamNmperFrm', true);
}

function recParamNmperLovInitComponents(){
	recParamNmperLovReturnParameters = window.dialogArguments;
	
	focusFirstField('recParamNmperFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Función que permite cargar los datos de un elemento de lov seleccionado
function recParamNmperSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('recParamNmperFrm.' + campo, id);
	set('recParamNmperFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function recParamNmperLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	recParamNmperLovReturnParameters.id = '';
	recParamNmperLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function recParamNmperLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recParamNmperList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = recParamNmperList.codSeleccionados();
	var descripcion = recParamNmperList.extraeDato(
		recParamNmperList.codSeleccionados()[0], recParamNmperChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	recParamNmperLovReturnParameters.id = codigo;
	recParamNmperLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function recParamNmperCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('recParamNmperFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('recParamNmperFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "recParamNmperList", "RecParamNmperConectorTransactionQuery", 
		"result_ROWSET", parametros, "recParamNmperPostQueryActions(datos);"]], "", "");	
}

function recParamNmperCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('recParamNmperFrm.lastQueryToSession'));
	var i =0;
	set('recParamNmperFrm.ticlOidTipoClie', [paramsRequery.ij(i++)]);
	
	set('recParamNmperFrm.pperOidPrecPerd', [paramsRequery.ij(i++)]);
	
	set('recParamNmperFrm.valPorcReca', paramsRequery.ij(i++));
	
	set('recParamNmperFrm.indParaModi', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	recParamNmperPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	recParamNmperCmdQuery(recParamNmperPageCount);
}

function recParamNmperFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	recParamNmperPageCount = 1;
	recParamNmperCmdQuery(recParamNmperPageCount);
}

function recParamNmperPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recParamNmperLastQuery){
		recParamNmperFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	recParamNmperPageCount--;
	recParamNmperCmdQuery(recParamNmperPageCount);
}

function recParamNmperNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recParamNmperLastQuery){
		recParamNmperFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	recParamNmperPageCount++;
	recParamNmperCmdQuery(recParamNmperPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function recParamNmperPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('recParamNmperListLayer', 'O');
		visibilidad('recParamNmperListButtonsLayer', 'O');
		if(get('recParamNmperFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	recParamNmperLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case '1': datosTmp.ij2(GestionarMensaje('RecParamNmper.indParaModi.1.value'), i, 4); break;
			case '0': datosTmp.ij2(GestionarMensaje('RecParamNmper.indParaModi.0.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:recParamNmperViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, recParamNmperChoiceColumn) + "</A>",
			i, recParamNmperChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	recParamNmperList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	recParamNmperTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		recParamNmperMorePagesFlag = true;
		recParamNmperList.eliminar(mmgPageSize, 1);
	}else{
		recParamNmperMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('recParamNmperFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('recParamNmperListLayer', 'V');
	visibilidad('recParamNmperListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('recParamNmperList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	recParamNmperList.display();
	
	//Actualizamos el estado de los botones 
	if(recParamNmperMorePagesFlag){
		set_estado_botonera('recParamNmperPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('recParamNmperPaginationButtonBar',
			3,"inactivo");
	}
	if(recParamNmperPageCount > 1){
		set_estado_botonera('recParamNmperPaginationButtonBar',
			2,"activo");
		set_estado_botonera('recParamNmperPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('recParamNmperPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('recParamNmperPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function recParamNmperUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recParamNmperList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('recParamNmperFrm.idSelection', recParamNmperList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('recParamNmperFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = recParamNmperList.codSeleccionados()[0];
		parametros["previousAction"] = get('recParamNmperFrm.accion');
		parametros["accion"] = get('recParamNmperFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('RecParamNmperLPStartUp', get('recParamNmperFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) recParamNmperCmdRequery();
	}
}

function recParamNmperRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recParamNmperList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = recParamNmperList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('recParamNmperFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(recParamNmperList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += recParamNmperTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('recParamNmperFrm.timestamp', timestamps);


	recParamNmperFrm.oculto='S';
	envia('recParamNmperFrm');
	recParamNmperFrm.oculto='N';
}

function recParamNmperViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recParamNmperList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	recParamNmperViewDetail(recParamNmperList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function recParamNmperViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('recParamNmperFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('RecParamNmperLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('recParamNmperFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
		
	
	if(validacion){
		recParamNmperFrm.oculto='S';
		envia('recParamNmperFrm');
		recParamNmperFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('recParamNmperFrm.ticlOidTipoClie').toString() == ''){
		set('recParamNmperFrm.ticlOidTipoClie', []);
		mmgResetCombosOnCascade('ticlOidTipoClie', 'ticlOidTipoClie', 'recParamNmper');
		
	}
	if(get('recParamNmperFrm.pperOidPrecPerd').toString() == ''){
		set('recParamNmperFrm.pperOidPrecPerd', []);
		mmgResetCombosOnCascade('pperOidPrecPerd', 'pperOidPrecPerd', 'recParamNmper');
		
	}
	if(get('recParamNmperFrm.paisOidPais').toString() == ''){
		set('recParamNmperFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'recParamNmper');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	recParamNmperRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('recParamNmperFrm.accion');
	var origenTmp = get('recParamNmperFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(recParamNmperBuildUpdateRecordString() != recParamNmperTmpUpdateValues){
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
	document.all.recParamNmperListLayer.style.display='none';
	document.all.recParamNmperListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.recParamNmperListLayer.style.display='';
	document.all.recParamNmperListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsRecParamNmperTiclOidTipoClie = get('recParamNmperFrm.ticlOidTipoClie')[0];
	jsRecParamNmperPperOidPrecPerd = get('recParamNmperFrm.pperOidPrecPerd')[0];
	jsRecParamNmperValPorcReca = get('recParamNmperFrm.valPorcReca').toString();
	jsRecParamNmperIndParaModi = get('recParamNmperFrm.indParaModi')[0];
	
	
	var parametros = "";
	parametros += jsRecParamNmperTiclOidTipoClie + "|";
	parametros += jsRecParamNmperPperOidPrecPerd + "|";
	parametros += jsRecParamNmperValPorcReca + "|";
	parametros += jsRecParamNmperIndParaModi + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function recParamNmperBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsRecParamNmperTiclOidTipoClie + "|";
	parametros += jsRecParamNmperPperOidPrecPerd + "|";
	parametros += jsRecParamNmperValPorcReca + "|";
	parametros += jsRecParamNmperIndParaModi + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recParamNmperFrm.accion'), 
		get('recParamNmperFrm.origen'));
	
	jsRecParamNmperId = get('recParamNmperFrm.id').toString();
	jsRecParamNmperTiclOidTipoClie = get('recParamNmperFrm.ticlOidTipoClie')[0];
	jsRecParamNmperPperOidPrecPerd = get('recParamNmperFrm.pperOidPrecPerd')[0];
	jsRecParamNmperValPorcReca = get('recParamNmperFrm.valPorcReca').toString();
	jsRecParamNmperIndParaModi = get('recParamNmperFrm.indParaModi')[0];
	jsRecParamNmperPaisOidPais = get('recParamNmperFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recParamNmperFrm.accion'), 
		get('recParamNmperFrm.origen'));


	set('recParamNmperFrm.id', jsRecParamNmperId);
	set('recParamNmperFrm.ticlOidTipoClie', [jsRecParamNmperTiclOidTipoClie]);
	set('recParamNmperFrm.pperOidPrecPerd', [jsRecParamNmperPperOidPrecPerd]);
	set('recParamNmperFrm.valPorcReca', jsRecParamNmperValPorcReca);
	set('recParamNmperFrm.indParaModi', [jsRecParamNmperIndParaModi]);
	set('recParamNmperFrm.paisOidPais', [jsRecParamNmperPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsRecParamNmperTiclOidTipoClie = '';
	jsRecParamNmperPperOidPrecPerd = '';
	jsRecParamNmperValPorcReca = '';
	jsRecParamNmperIndParaModi = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('recParamNmperFrm.errCodigo', errorCode);
	set('recParamNmperFrm.errDescripcion', description);
	set('recParamNmperFrm.errSeverity', severity);
	fMostrarMensajeError();
}
