

/*
    INDRA/CAR/mmg
    $Id: maetipoclien.js,v 1.1 2009/12/03 19:02:04 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeTipoClienId = "";
var jsMaeTipoClienCodTipoClie = "";
var jsMaeTipoClienDescripcion = "";
var jsMaeTipoClienIndEvalEsta = "";
var jsMaeTipoClienIndEmpl = "";

//Variables de paginacion, 
var maeTipoClienPageCount = 1;

//Varible de columna que representa el campo de choice
var maeTipoClienChoiceColumn = 1;

//Flag de siguiente pagina;
var maeTipoClienMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeTipoClienTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeTipoClienLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("maeTipoClienFrm.codTipoClie");','focaliza("maeTipoClienFrm.codTipoClie");','focaliza("maeTipoClienFrm.codTipoClie");','focaliza("maeTipoClienFrm.codTipoClie");','focaliza("maeTipoClienFrm.codTipoClie");','focaliza("maeTipoClienFrm.codTipoClie");'],[3,'focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");'],[4,'focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");'],[5,'focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");','focaliza("maeTipoClienFrm.Descripcion");'],[4,'focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");','focaliza("maeTipoClienFrm.indEvalEsta");'],[5,'focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");','focaliza("maeTipoClienFrm.indEmpl");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeTipoClienLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeTipoClienTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeTipoClienInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeTipoClienFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeTipoClienFrm.accion')){
		case "query": maeTipoClienQueryInitComponents(); break;
		case "view": maeTipoClienViewInitComponents(); break;
		case "create": maeTipoClienCreateInitComponents(); break;
		case "update": maeTipoClienUpdateInitComponents(); break;
		case "remove": maeTipoClienRemoveInitComponents(); break;
		case "lov": maeTipoClienLovInitComponents(); break;
	}
	//alert('accion :' + get('maeTipoClienFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeTipoClienFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeTipoClien')) maeTipoClienCmdRequery();
}

function maeTipoClienQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('maeTipoClienFrm', true);	
}

function maeTipoClienViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeTipoClienFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('maeTipoClienFrm.indEvalEsta', get('maeTipoClienFrm.indEvalEstaCheckValue'));
		set('maeTipoClienFrm.indEmpl', get('maeTipoClienFrm.indEmplCheckValue'));
		
	focusFirstField('maeTipoClienFrm', true);
}

function maeTipoClienCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeTipoClienFrm.codTipoClie','S', GestionarMensaje('MaeTipoClien.codTipoClie.requiered.message'));
	
	setMV('maeTipoClienFrm.Descripcion','S', GestionarMensaje('MaeTipoClien.Descripcion.requiered.message'));
	
	setMV('maeTipoClienFrm.indEvalEsta','S', GestionarMensaje('MaeTipoClien.indEvalEsta.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeTipoClienFrm', true);
}

function maeTipoClienUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeTipoClienFrm.origen') == "pagina"){
		loadLocalizationWidget('maeTipoClienFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('maeTipoClienFrm.indEvalEsta', get('maeTipoClienFrm.indEvalEstaCheckValue'));
			set('maeTipoClienFrm.indEmpl', get('maeTipoClienFrm.indEmplCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		maeTipoClienTmpUpdateValues = maeTipoClienBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeTipoClienFrm.codTipoClie','S', GestionarMensaje('MaeTipoClien.codTipoClie.requiered.message'));
		setMV('maeTipoClienFrm.Descripcion','S', GestionarMensaje('MaeTipoClien.Descripcion.requiered.message'));
		setMV('maeTipoClienFrm.indEvalEsta','S', GestionarMensaje('MaeTipoClien.indEvalEsta.requiered.message'));
		
			focusFirstFieldModify('maeTipoClienFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('maeTipoClienFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeTipoClienFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeTipoClienRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeTipoClienList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeTipoClienFrm', true);
}

function maeTipoClienLovInitComponents(){
	maeTipoClienLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeTipoClienFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function maeTipoClienSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeTipoClienFrm.' + campo, id);
	set('maeTipoClienFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeTipoClienLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeTipoClienLovReturnParameters.id = '';
	maeTipoClienLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeTipoClienLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeTipoClienList.codSeleccionados();
	var descripcion = maeTipoClienList.extraeDato(
		maeTipoClienList.codSeleccionados()[0], maeTipoClienChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeTipoClienLovReturnParameters.id = codigo;
	maeTipoClienLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeTipoClienCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeTipoClienFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeTipoClienFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeTipoClienList", "MaeTipoClienConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeTipoClienPostQueryActions(datos);"]], "", "");	
}

function maeTipoClienCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeTipoClienFrm.lastQueryToSession'));
	var i =0;
	set('maeTipoClienFrm.codTipoClie', paramsRequery.ij(i++));
	
	set('maeTipoClienFrm.Descripcion', paramsRequery.ij(i++));
	
	set('maeTipoClienFrm.indEvalEsta', paramsRequery.ij(i++));
	
	set('maeTipoClienFrm.indEmpl', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeTipoClienPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeTipoClienCmdQuery(maeTipoClienPageCount);
}

function maeTipoClienFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeTipoClienPageCount = 1;
	maeTipoClienCmdQuery(maeTipoClienPageCount);
}

function maeTipoClienPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoClienLastQuery){
		maeTipoClienFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeTipoClienPageCount--;
	maeTipoClienCmdQuery(maeTipoClienPageCount);
}

function maeTipoClienNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoClienLastQuery){
		maeTipoClienFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeTipoClienPageCount++;
	maeTipoClienCmdQuery(maeTipoClienPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeTipoClienPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeTipoClienListLayer', 'O');
		visibilidad('maeTipoClienListButtonsLayer', 'O');
		if(get('maeTipoClienFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeTipoClienLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case '1': datosTmp.ij2(GestionarMensaje('MaeTipoClien.indEvalEsta.1.value'), i, 3); break;
			case '0': datosTmp.ij2(GestionarMensaje('MaeTipoClien.indEvalEsta.0.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case '1': datosTmp.ij2(GestionarMensaje('MaeTipoClien.indEmpl.1.value'), i, 4); break;
			case '0': datosTmp.ij2(GestionarMensaje('MaeTipoClien.indEmpl.0.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeTipoClienViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeTipoClienChoiceColumn) + "</A>",
			i, maeTipoClienChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeTipoClienList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeTipoClienTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeTipoClienMorePagesFlag = true;
		maeTipoClienList.eliminar(mmgPageSize, 1);
	}else{
		maeTipoClienMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeTipoClienFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeTipoClienListLayer', 'V');
	visibilidad('maeTipoClienListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeTipoClienList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeTipoClienList.display();
	
	//Actualizamos el estado de los botones 
	if(maeTipoClienMorePagesFlag){
		set_estado_botonera('maeTipoClienPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeTipoClienPaginationButtonBar',
			3,"inactivo");
	}
	if(maeTipoClienPageCount > 1){
		set_estado_botonera('maeTipoClienPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeTipoClienPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeTipoClienPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeTipoClienPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeTipoClienUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeTipoClienFrm.idSelection', maeTipoClienList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeTipoClienFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeTipoClienList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeTipoClienFrm.accion');
		parametros["accion"] = get('maeTipoClienFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeTipoClienLPStartUp', get('maeTipoClienFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeTipoClienCmdRequery();
	}
}

function maeTipoClienRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeTipoClienList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeTipoClienFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeTipoClienList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeTipoClienTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeTipoClienFrm.timestamp', timestamps);


	maeTipoClienFrm.oculto='S';
	envia('maeTipoClienFrm');
	maeTipoClienFrm.oculto='N';
}

function maeTipoClienViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeTipoClienViewDetail(maeTipoClienList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeTipoClienViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeTipoClienFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeTipoClienLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('maeTipoClienFrm', 
		'Descripcion', 1,
		get('maeTipoClienFrm.Descripcion'));	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeTipoClienFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('maeTipoClienFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeTipoClien.Descripcion.requiered.message'));
		focaliza('maeTipoClienFrm.Descripcion');
		return;
	}	
	
	
	
		
	
	if(validacion){
		maeTipoClienFrm.oculto='S';
		envia('maeTipoClienFrm');
		maeTipoClienFrm.oculto='N';
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
	maeTipoClienRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeTipoClienFrm.accion');
	var origenTmp = get('maeTipoClienFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeTipoClienBuildUpdateRecordString() != maeTipoClienTmpUpdateValues){
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
	document.all.maeTipoClienListLayer.style.display='none';
	document.all.maeTipoClienListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeTipoClienListLayer.style.display='';
	document.all.maeTipoClienListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeTipoClienCodTipoClie = get('maeTipoClienFrm.codTipoClie').toString();
	jsMaeTipoClienDescripcion = get('maeTipoClienFrm.Descripcion').toString();
	jsMaeTipoClienIndEvalEsta = get('maeTipoClienFrm.indEvalEsta');
	jsMaeTipoClienIndEmpl = get('maeTipoClienFrm.indEmpl');
	
	
	var parametros = "";
	parametros += jsMaeTipoClienCodTipoClie + "|";
	parametros += jsMaeTipoClienDescripcion + "|";
	parametros += jsMaeTipoClienIndEvalEsta + "|";
	parametros += jsMaeTipoClienIndEmpl + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeTipoClienBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeTipoClienCodTipoClie + "|";
	parametros += jsMaeTipoClienDescripcion + "|";
	parametros += jsMaeTipoClienIndEvalEsta + "|";
	parametros += jsMaeTipoClienIndEmpl + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoClienFrm.accion'), 
		get('maeTipoClienFrm.origen'));
	
	jsMaeTipoClienId = get('maeTipoClienFrm.id').toString();
	jsMaeTipoClienCodTipoClie = get('maeTipoClienFrm.codTipoClie').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeTipoClienDescripcion = buildLocalizedString('maeTipoClienFrm', 1);
	}else{
		jsMaeTipoClienDescripcion = get('maeTipoClienFrm.Descripcion');
	}
	jsMaeTipoClienIndEvalEsta = get('maeTipoClienFrm.indEvalEsta');
	jsMaeTipoClienIndEmpl = get('maeTipoClienFrm.indEmpl');
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoClienFrm.accion'), 
		get('maeTipoClienFrm.origen'));


	set('maeTipoClienFrm.id', jsMaeTipoClienId);
	set('maeTipoClienFrm.codTipoClie', jsMaeTipoClienCodTipoClie);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeTipoClienFrm', 1,  jsMaeTipoClienDescripcion)
		loadLocalizationWidget('maeTipoClienFrm', 'Descripcion', 1);
	}else{
		set('maeTipoClienFrm.Descripcion', jsMaeTipoClienDescripcion);		
	}
	set('maeTipoClienFrm.indEvalEsta', jsMaeTipoClienIndEvalEsta);
	set('maeTipoClienFrm.indEmpl', jsMaeTipoClienIndEmpl);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeTipoClienCodTipoClie = '';
	jsMaeTipoClienDescripcion = '';
	jsMaeTipoClienIndEvalEsta = '';
	jsMaeTipoClienIndEmpl = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeTipoClienFrm.errCodigo', errorCode);
	set('maeTipoClienFrm.errDescripcion', description);
	set('maeTipoClienFrm.errSeverity', severity);
	fMostrarMensajeError();
}
