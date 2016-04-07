

/*
    INDRA/CAR/mmg
    $Id: carindicniveljerar.js,v 1.1 2009/12/03 19:02:06 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarIndicNivelJerarId = "";
var jsCarIndicNivelJerarCodIndiNiveJera = "";

//Variables de paginacion, 
var carIndicNivelJerarPageCount = 1;

//Varible de columna que representa el campo de choice
var carIndicNivelJerarChoiceColumn = 0;

//Flag de siguiente pagina;
var carIndicNivelJerarMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carIndicNivelJerarTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var carIndicNivelJerarLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");','focaliza("carIndicNivelJerarFrm.codIndiNiveJera");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
carIndicNivelJerarLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var carIndicNivelJerarTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function carIndicNivelJerarInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('carIndicNivelJerarFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('carIndicNivelJerarFrm.accion')){
		case "query": carIndicNivelJerarQueryInitComponents(); break;
		case "view": carIndicNivelJerarViewInitComponents(); break;
		case "create": carIndicNivelJerarCreateInitComponents(); break;
		case "update": carIndicNivelJerarUpdateInitComponents(); break;
		case "remove": carIndicNivelJerarRemoveInitComponents(); break;
		case "lov": carIndicNivelJerarLovInitComponents(); break;
	}
	//alert('accion :' + get('carIndicNivelJerarFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('carIndicNivelJerarFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carIndicNivelJerar')) carIndicNivelJerarCmdRequery();
}

function carIndicNivelJerarQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	focusFirstField('carIndicNivelJerarFrm', true);	
}

function carIndicNivelJerarViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('carIndicNivelJerarFrm.codIndiNiveJera', get('carIndicNivelJerarFrm.codIndiNiveJeraCheckValue'));
		
	focusFirstField('carIndicNivelJerarFrm', true);
}

function carIndicNivelJerarCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carIndicNivelJerarFrm.codIndiNiveJera','S', GestionarMensaje('CarIndicNivelJerar.codIndiNiveJera.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('carIndicNivelJerarFrm', true);
}

function carIndicNivelJerarUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('carIndicNivelJerarFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('carIndicNivelJerarFrm.codIndiNiveJera', get('carIndicNivelJerarFrm.codIndiNiveJeraCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		carIndicNivelJerarTmpUpdateValues = carIndicNivelJerarBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carIndicNivelJerarFrm.codIndiNiveJera','S', GestionarMensaje('CarIndicNivelJerar.codIndiNiveJera.requiered.message'));
		
			focusFirstFieldModify('carIndicNivelJerarFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		focusFirstField('carIndicNivelJerarFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('carIndicNivelJerarFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carIndicNivelJerarRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	carIndicNivelJerarList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('carIndicNivelJerarFrm', true);
}

function carIndicNivelJerarLovInitComponents(){
	carIndicNivelJerarLovReturnParameters = window.dialogArguments;
	
	focusFirstField('carIndicNivelJerarFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad




//Función que permite cargar los datos de un elemento de lov seleccionado
function carIndicNivelJerarSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carIndicNivelJerarFrm.' + campo, id);
	set('carIndicNivelJerarFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function carIndicNivelJerarLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carIndicNivelJerarLovReturnParameters.id = '';
	carIndicNivelJerarLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carIndicNivelJerarLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carIndicNivelJerarList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carIndicNivelJerarList.codSeleccionados();
	var descripcion = carIndicNivelJerarList.extraeDato(
		carIndicNivelJerarList.codSeleccionados()[0], carIndicNivelJerarChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carIndicNivelJerarLovReturnParameters.id = codigo;
	carIndicNivelJerarLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function carIndicNivelJerarCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carIndicNivelJerarFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('carIndicNivelJerarFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carIndicNivelJerarList", "CarIndicNivelJerarConectorTransactionQuery", 
		"result_ROWSET", parametros, "carIndicNivelJerarPostQueryActions(datos);"]], "", "");	
}

function carIndicNivelJerarCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carIndicNivelJerarFrm.lastQueryToSession'));
	var i =0;
	set('carIndicNivelJerarFrm.codIndiNiveJera', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	carIndicNivelJerarPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carIndicNivelJerarCmdQuery(carIndicNivelJerarPageCount);
}

function carIndicNivelJerarFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carIndicNivelJerarPageCount = 1;
	carIndicNivelJerarCmdQuery(carIndicNivelJerarPageCount);
}

function carIndicNivelJerarPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carIndicNivelJerarLastQuery){
		carIndicNivelJerarFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carIndicNivelJerarPageCount--;
	carIndicNivelJerarCmdQuery(carIndicNivelJerarPageCount);
}

function carIndicNivelJerarNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carIndicNivelJerarLastQuery){
		carIndicNivelJerarFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carIndicNivelJerarPageCount++;
	carIndicNivelJerarCmdQuery(carIndicNivelJerarPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carIndicNivelJerarPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carIndicNivelJerarListLayer', 'O');
		visibilidad('carIndicNivelJerarListButtonsLayer', 'O');
		if(get('carIndicNivelJerarFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	carIndicNivelJerarLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 1)){
			case 'A': datosTmp.ij2(GestionarMensaje('CarIndicNivelJerar.codIndiNiveJera.A.value'), i, 1); break;
			case 'I': datosTmp.ij2(GestionarMensaje('CarIndicNivelJerar.codIndiNiveJera.I.value'), i, 1); break;
			default: datosTmp .ij2('', i, 1);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:carIndicNivelJerarViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carIndicNivelJerarChoiceColumn) + "</A>",
			i, carIndicNivelJerarChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carIndicNivelJerarList.setDatos(datosTmp.filtrar([0,1],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	carIndicNivelJerarTimeStamps = datosTmp.filtrar([2],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		carIndicNivelJerarMorePagesFlag = true;
		carIndicNivelJerarList.eliminar(mmgPageSize, 1);
	}else{
		carIndicNivelJerarMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('carIndicNivelJerarFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carIndicNivelJerarListLayer', 'V');
	visibilidad('carIndicNivelJerarListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carIndicNivelJerarList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carIndicNivelJerarList.display();
	
	//Actualizamos el estado de los botones 
	if(carIndicNivelJerarMorePagesFlag){
		set_estado_botonera('carIndicNivelJerarPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carIndicNivelJerarPaginationButtonBar',
			3,"inactivo");
	}
	if(carIndicNivelJerarPageCount > 1){
		set_estado_botonera('carIndicNivelJerarPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carIndicNivelJerarPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carIndicNivelJerarPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carIndicNivelJerarPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carIndicNivelJerarUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carIndicNivelJerarList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carIndicNivelJerarFrm.idSelection', carIndicNivelJerarList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('carIndicNivelJerarFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = carIndicNivelJerarList.codSeleccionados()[0];
		parametros["previousAction"] = get('carIndicNivelJerarFrm.accion');
		parametros["accion"] = get('carIndicNivelJerarFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CarIndicNivelJerarLPStartUp', get('carIndicNivelJerarFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) carIndicNivelJerarCmdRequery();
	}
}

function carIndicNivelJerarRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carIndicNivelJerarList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carIndicNivelJerarList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carIndicNivelJerarFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carIndicNivelJerarList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carIndicNivelJerarTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carIndicNivelJerarFrm.timestamp', timestamps);


	carIndicNivelJerarFrm.oculto='S';
	envia('carIndicNivelJerarFrm');
	carIndicNivelJerarFrm.oculto='N';
}

function carIndicNivelJerarViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carIndicNivelJerarList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	carIndicNivelJerarViewDetail(carIndicNivelJerarList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function carIndicNivelJerarViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carIndicNivelJerarFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CarIndicNivelJerarLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('carIndicNivelJerarFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
		
	
	if(validacion){
		carIndicNivelJerarFrm.oculto='S';
		envia('carIndicNivelJerarFrm');
		carIndicNivelJerarFrm.oculto='N';
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
	carIndicNivelJerarRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('carIndicNivelJerarFrm.accion');
	var origenTmp = get('carIndicNivelJerarFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carIndicNivelJerarBuildUpdateRecordString() != carIndicNivelJerarTmpUpdateValues){
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
	document.all.carIndicNivelJerarListLayer.style.display='none';
	document.all.carIndicNivelJerarListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carIndicNivelJerarListLayer.style.display='';
	document.all.carIndicNivelJerarListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCarIndicNivelJerarCodIndiNiveJera = get('carIndicNivelJerarFrm.codIndiNiveJera');
	
	
	var parametros = "";
	parametros += jsCarIndicNivelJerarCodIndiNiveJera + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carIndicNivelJerarBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarIndicNivelJerarCodIndiNiveJera + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carIndicNivelJerarFrm.accion'), 
		get('carIndicNivelJerarFrm.origen'));
	
	jsCarIndicNivelJerarId = get('carIndicNivelJerarFrm.id').toString();
	jsCarIndicNivelJerarCodIndiNiveJera = get('carIndicNivelJerarFrm.codIndiNiveJera');
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carIndicNivelJerarFrm.accion'), 
		get('carIndicNivelJerarFrm.origen'));


	set('carIndicNivelJerarFrm.id', jsCarIndicNivelJerarId);
	set('carIndicNivelJerarFrm.codIndiNiveJera', jsCarIndicNivelJerarCodIndiNiveJera);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCarIndicNivelJerarCodIndiNiveJera = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carIndicNivelJerarFrm.errCodigo', errorCode);
	set('carIndicNivelJerarFrm.errDescripcion', description);
	set('carIndicNivelJerarFrm.errSeverity', severity);
	fMostrarMensajeError();
}
