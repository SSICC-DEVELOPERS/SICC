

/*
    INDRA/CAR/mmg
    $Id: zondivispolit.js,v 1.1 2009/12/03 19:02:28 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonDivisPolitId = "";
var jsZonDivisPolitCodDiviPoli = "";
var jsZonDivisPolitOrde = "";

//Variables de paginacion, 
var zonDivisPolitPageCount = 1;

//Varible de columna que representa el campo de choice
var zonDivisPolitChoiceColumn = 2;

//Flag de siguiente pagina;
var zonDivisPolitMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonDivisPolitTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 150;
var sizeFormView = 150;
var sizeFormUpdate = 150;

//Ultima busqueda realizada
var zonDivisPolitLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("zonDivisPolitFrm.orde");','focaliza("zonDivisPolitFrm.orde");','focaliza("zonDivisPolitFrm.orde");','focaliza("zonDivisPolitFrm.orde");','focaliza("zonDivisPolitFrm.orde");','focaliza("zonDivisPolitFrm.orde");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonDivisPolitLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonDivisPolitTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function zonDivisPolitInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonDivisPolitFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonDivisPolitFrm.accion')){
		case "query": zonDivisPolitQueryInitComponents(); break;
		case "view": zonDivisPolitViewInitComponents(); break;
		case "create": zonDivisPolitCreateInitComponents(); break;
		case "update": zonDivisPolitUpdateInitComponents(); break;
		case "remove": zonDivisPolitRemoveInitComponents(); break;
		case "lov": zonDivisPolitLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('zonDivisPolitFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonDivisPolit')) zonDivisPolitCmdRequery();
}

function zonDivisPolitQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
}

function zonDivisPolitViewInitComponents(){
	//En principiono se hace nada
}

function zonDivisPolitCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonDivisPolitFrm.codDiviPoli','S', GestionarMensaje('ZonDivisPolit.codDiviPoli.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function zonDivisPolitUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonDivisPolitFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		zonDivisPolitTmpUpdateValues = zonDivisPolitBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonDivisPolitFrm.codDiviPoli','S', GestionarMensaje('ZonDivisPolit.codDiviPoli.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonDivisPolitFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonDivisPolitRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonDivisPolitList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function zonDivisPolitLovInitComponents(){
	zonDivisPolitLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function zonDivisPolitSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonDivisPolitFrm.' + campo, id);
	set('zonDivisPolitFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonDivisPolitLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonDivisPolitLovReturnParameters.id = '';
	zonDivisPolitLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonDivisPolitLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonDivisPolitList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonDivisPolitList.codSeleccionados();
	var descripcion = zonDivisPolitList.extraeDato(
		zonDivisPolitList.codSeleccionados()[0], zonDivisPolitChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonDivisPolitLovReturnParameters.id = codigo;
	zonDivisPolitLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonDivisPolitCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonDivisPolitFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonDivisPolitLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonDivisPolitFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonDivisPolitList", "ZonDivisPolitConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonDivisPolitPostQueryActions(datos);"]], "", "");	
}

function zonDivisPolitCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonDivisPolitFrm.lastQueryToSession'));
	var i =0;
	set('zonDivisPolitFrm.codDiviPoli', paramsRequery.ij(i++));
	
	set('zonDivisPolitFrm.orde', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	zonDivisPolitPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonDivisPolitCmdQuery(zonDivisPolitPageCount);
}

function zonDivisPolitFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonDivisPolitPageCount = 1;
	zonDivisPolitCmdQuery(zonDivisPolitPageCount);
}

function zonDivisPolitPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonDivisPolitLastQuery){
		zonDivisPolitFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonDivisPolitPageCount--;
	zonDivisPolitCmdQuery(zonDivisPolitPageCount);
}

function zonDivisPolitNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonDivisPolitLastQuery){
		zonDivisPolitFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonDivisPolitPageCount++;
	zonDivisPolitCmdQuery(zonDivisPolitPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonDivisPolitPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonDivisPolitListLayer', 'O');
		visibilidad('zonDivisPolitListButtonsLayer', 'O');
		visibilidad('zonDivisPolitPreListLayer', 'O');
		if(get('zonDivisPolitFrm.accion') == "remove"){
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
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonDivisPolitViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonDivisPolitChoiceColumn) + "</A>",
			i, zonDivisPolitChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonDivisPolitList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonDivisPolitTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonDivisPolitMorePagesFlag = true;
		zonDivisPolitList.eliminar(mmgPageSize, 1);
	}else{
		zonDivisPolitMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonDivisPolitFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonDivisPolitListLayer', 'V');
	visibilidad('zonDivisPolitListButtonsLayer', 'V');
	visibilidad('zonDivisPolitPreListLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonDivisPolitList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonDivisPolitList.display();
	
	//Actualizamos el estado de los botones 
	if(zonDivisPolitMorePagesFlag){
		set_estado_botonera('zonDivisPolitPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonDivisPolitPaginationButtonBar',
			3,"inactivo");
	}
	if(zonDivisPolitPageCount > 1){
		set_estado_botonera('zonDivisPolitPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonDivisPolitPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonDivisPolitPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonDivisPolitPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonDivisPolitUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonDivisPolitList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonDivisPolitFrm.idSelection', zonDivisPolitList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonDivisPolitFrm', true);
	if(validacion){
		/*set('zonDivisPolitFrm.previousAction', 'update');
		set('zonDivisPolitFrm.ON', 'ZonDivisPolitLPStartUp');
		set('zonDivisPolitFrm.conectorAction', 'ZonDivisPolitLPStartUp');
		set('zonDivisPolitFrm.origen', 'pagina');
		envia('zonDivisPolitFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = zonDivisPolitList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonDivisPolitFrm.accion');
		parametros["accion"] = get('zonDivisPolitFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('ZonDivisPolitLPStartUp', get('zonDivisPolitFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) zonDivisPolitCmdRequery();
	}
}

function zonDivisPolitRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonDivisPolitList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonDivisPolitList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonDivisPolitFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonDivisPolitList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonDivisPolitTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonDivisPolitFrm.timestamp', timestamps);
	envia('zonDivisPolitFrm');
}

function zonDivisPolitViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonDivisPolitList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('zonDivisPolitFrm.previousAction', get('zonDivisPolitFrm.accion'));
	set('zonDivisPolitFrm.accion', 'view');
	set('zonDivisPolitFrm.origen', 'pagina');
	set('zonDivisPolitFrm.ON', 'ZonDivisPolitLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('zonDivisPolitFrm.idSelection', zonDivisPolitList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('zonDivisPolitFrm');
	zonDivisPolitViewDetail(zonDivisPolitList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonDivisPolitViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonDivisPolitFrm.accion');
	parametros["accion"] = get('zonDivisPolitFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('ZonDivisPolitLPStartUp', get('zonDivisPolitFrm.accion'), parametros, null, sizeFormView + 30);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('zonDivisPolitFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
		
	
	if(validacion)envia('zonDivisPolitFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonDivisPolitRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonDivisPolitFrm.accion');
	var origenTmp = get('zonDivisPolitFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonDivisPolitBuildUpdateRecordString() != zonDivisPolitTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('zonDivisPolitFrm.performRequery', 'true');
		set('zonDivisPolitFrm.accion', 
			get('zonDivisPolitFrm.previousAction'));
		set('zonDivisPolitFrm.origen', 'menu');
		set('zonDivisPolitFrm.ON', 'ZonDivisPolitLPStartUp');
		set('zonDivisPolitFrm.conectorAction', 'ZonDivisPolitLPStartUp');
		zonDivisPolitFrm.oculto='N';
		envia('zonDivisPolitFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.zonDivisPolitListLayer.style.display='none';
	document.all.zonDivisPolitListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonDivisPolitListLayer.style.display='';
	document.all.zonDivisPolitListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonDivisPolitCodDiviPoli = get('zonDivisPolitFrm.codDiviPoli').toString();






	jsZonDivisPolitOrde = get('zonDivisPolitFrm.orde').toString();








	var parametros = "";
	parametros += jsZonDivisPolitCodDiviPoli + "|";



	parametros += jsZonDivisPolitOrde + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonDivisPolitBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonDivisPolitCodDiviPoli + "|";
	parametros += jsZonDivisPolitOrde + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonDivisPolitFrm.accion'), 
		get('zonDivisPolitFrm.origen'));
	
	jsZonDivisPolitId = get('zonDivisPolitFrm.id').toString();
	jsZonDivisPolitCodDiviPoli = get('zonDivisPolitFrm.codDiviPoli').toString();
	jsZonDivisPolitOrde = get('zonDivisPolitFrm.orde').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonDivisPolitFrm.accion'), 
		get('zonDivisPolitFrm.origen'));


	set('zonDivisPolitFrm.id', jsZonDivisPolitId);
	set('zonDivisPolitFrm.codDiviPoli', jsZonDivisPolitCodDiviPoli);
	set('zonDivisPolitFrm.orde', jsZonDivisPolitOrde);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonDivisPolitFrm.errCodigo', errorCode);
	set('zonDivisPolitFrm.errDescripcion', description);
	set('zonDivisPolitFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
