

/*
    INDRA/CAR/mmg
    $Id: vcamgupermiusuar.js,v 1.1 2009/12/03 19:02:29 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsVcaMguPermiUsuarCodUsua = "";
var jsVcaMguPermiUsuarCodProp = "";
var jsVcaMguPermiUsuarValProp = "";

//Variables de paginacion, 
var vcaMguPermiUsuarPageCount = 1;

//Varible de columna que representa el campo de choice
var vcaMguPermiUsuarChoiceColumn = 3;

//Flag de siguiente pagina;
var vcaMguPermiUsuarMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var vcaMguPermiUsuarTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 185;
var sizeFormView = 185;
var sizeFormUpdate = 185;

//Ultima busqueda realizada
var vcaMguPermiUsuarLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("vcaMguPermiUsuarFrm.valProp");','focaliza("vcaMguPermiUsuarFrm.valProp");','focaliza("vcaMguPermiUsuarFrm.valProp");','focaliza("vcaMguPermiUsuarFrm.valProp");','focaliza("vcaMguPermiUsuarFrm.valProp");','focaliza("vcaMguPermiUsuarFrm.valProp");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
vcaMguPermiUsuarLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var vcaMguPermiUsuarTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function vcaMguPermiUsuarInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('vcaMguPermiUsuarFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('vcaMguPermiUsuarFrm.accion')){
		case "query": vcaMguPermiUsuarQueryInitComponents(); break;
		case "view": vcaMguPermiUsuarViewInitComponents(); break;
		case "create": vcaMguPermiUsuarCreateInitComponents(); break;
		case "update": vcaMguPermiUsuarUpdateInitComponents(); break;
		case "remove": vcaMguPermiUsuarRemoveInitComponents(); break;
		case "lov": vcaMguPermiUsuarLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('vcaMguPermiUsuarFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('vcaMguPermiUsuar')) vcaMguPermiUsuarCmdRequery();
}

function vcaMguPermiUsuarQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
}

function vcaMguPermiUsuarViewInitComponents(){
	//En principiono se hace nada
}

function vcaMguPermiUsuarCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('vcaMguPermiUsuarFrm.codUsua','S', GestionarMensaje('VcaMguPermiUsuar.codUsua.requiered.message'));
	
	setMV('vcaMguPermiUsuarFrm.codProp','S', GestionarMensaje('VcaMguPermiUsuar.codProp.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function vcaMguPermiUsuarUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('vcaMguPermiUsuarFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		vcaMguPermiUsuarTmpUpdateValues = vcaMguPermiUsuarBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('vcaMguPermiUsuarFrm.codUsua','S', GestionarMensaje('VcaMguPermiUsuar.codUsua.requiered.message'));
		
		setMV('vcaMguPermiUsuarFrm.codProp','S', GestionarMensaje('VcaMguPermiUsuar.codProp.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('vcaMguPermiUsuarFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function vcaMguPermiUsuarRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	vcaMguPermiUsuarList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function vcaMguPermiUsuarLovInitComponents(){
	vcaMguPermiUsuarLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function vcaMguPermiUsuarSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('vcaMguPermiUsuarFrm.' + campo, id);
	set('vcaMguPermiUsuarFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function vcaMguPermiUsuarLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	vcaMguPermiUsuarLovReturnParameters.id = '';
	vcaMguPermiUsuarLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function vcaMguPermiUsuarLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaMguPermiUsuarList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = vcaMguPermiUsuarList.codSeleccionados();
	var descripcion = vcaMguPermiUsuarList.extraeDato(
		vcaMguPermiUsuarList.codSeleccionados()[0], vcaMguPermiUsuarChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	vcaMguPermiUsuarLovReturnParameters.id = codigo;
	vcaMguPermiUsuarLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function vcaMguPermiUsuarCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('vcaMguPermiUsuarFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	vcaMguPermiUsuarLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('vcaMguPermiUsuarFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "vcaMguPermiUsuarList", "VcaMguPermiUsuarConectorTransactionQuery", 
		"result_ROWSET", parametros, "vcaMguPermiUsuarPostQueryActions(datos);"]], "", "");	
}

function vcaMguPermiUsuarCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('vcaMguPermiUsuarFrm.lastQueryToSession'));
	var i =0;
	set('vcaMguPermiUsuarFrm.codUsua', paramsRequery.ij(i++));
	
	set('vcaMguPermiUsuarFrm.codProp', paramsRequery.ij(i++));
	
	set('vcaMguPermiUsuarFrm.valProp', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	vcaMguPermiUsuarPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	vcaMguPermiUsuarCmdQuery(vcaMguPermiUsuarPageCount);
}

function vcaMguPermiUsuarFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	vcaMguPermiUsuarPageCount = 1;
	vcaMguPermiUsuarCmdQuery(vcaMguPermiUsuarPageCount);
}

function vcaMguPermiUsuarPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != vcaMguPermiUsuarLastQuery){
		vcaMguPermiUsuarFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	vcaMguPermiUsuarPageCount--;
	vcaMguPermiUsuarCmdQuery(vcaMguPermiUsuarPageCount);
}

function vcaMguPermiUsuarNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != vcaMguPermiUsuarLastQuery){
		vcaMguPermiUsuarFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	vcaMguPermiUsuarPageCount++;
	vcaMguPermiUsuarCmdQuery(vcaMguPermiUsuarPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function vcaMguPermiUsuarPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('vcaMguPermiUsuarListLayer', 'O');
		visibilidad('vcaMguPermiUsuarListButtonsLayer', 'O');
		if(get('vcaMguPermiUsuarFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:vcaMguPermiUsuarViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, vcaMguPermiUsuarChoiceColumn) + "</A>",
			i, vcaMguPermiUsuarChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	vcaMguPermiUsuarList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	vcaMguPermiUsuarTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		vcaMguPermiUsuarMorePagesFlag = true;
		vcaMguPermiUsuarList.eliminar(mmgPageSize, 1);
	}else{
		vcaMguPermiUsuarMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('vcaMguPermiUsuarFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('vcaMguPermiUsuarListLayer', 'V');
	visibilidad('vcaMguPermiUsuarListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('vcaMguPermiUsuarList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	vcaMguPermiUsuarList.display();
	
	//Actualizamos el estado de los botones 
	if(vcaMguPermiUsuarMorePagesFlag){
		set_estado_botonera('vcaMguPermiUsuarPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('vcaMguPermiUsuarPaginationButtonBar',
			3,"inactivo");
	}
	if(vcaMguPermiUsuarPageCount > 1){
		set_estado_botonera('vcaMguPermiUsuarPaginationButtonBar',
			2,"activo");
		set_estado_botonera('vcaMguPermiUsuarPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('vcaMguPermiUsuarPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('vcaMguPermiUsuarPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function vcaMguPermiUsuarUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaMguPermiUsuarList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('vcaMguPermiUsuarFrm.idSelection', vcaMguPermiUsuarList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('vcaMguPermiUsuarFrm', true);
	if(validacion){
		/*set('vcaMguPermiUsuarFrm.previousAction', 'update');
		set('vcaMguPermiUsuarFrm.ON', 'VcaMguPermiUsuarLPStartUp');
		set('vcaMguPermiUsuarFrm.conectorAction', 'VcaMguPermiUsuarLPStartUp');
		set('vcaMguPermiUsuarFrm.origen', 'pagina');
		envia('vcaMguPermiUsuarFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = vcaMguPermiUsuarList.codSeleccionados()[0];
		parametros["previousAction"] = get('vcaMguPermiUsuarFrm.accion');
		parametros["accion"] = get('vcaMguPermiUsuarFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('VcaMguPermiUsuarLPStartUp', get('vcaMguPermiUsuarFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) vcaMguPermiUsuarCmdRequery();
	}
}

function vcaMguPermiUsuarRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaMguPermiUsuarList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = vcaMguPermiUsuarList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('vcaMguPermiUsuarFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(vcaMguPermiUsuarList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += vcaMguPermiUsuarTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('vcaMguPermiUsuarFrm.timestamp', timestamps);
	envia('vcaMguPermiUsuarFrm');
}

function vcaMguPermiUsuarViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaMguPermiUsuarList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('vcaMguPermiUsuarFrm.previousAction', get('vcaMguPermiUsuarFrm.accion'));
	set('vcaMguPermiUsuarFrm.accion', 'view');
	set('vcaMguPermiUsuarFrm.origen', 'pagina');
	set('vcaMguPermiUsuarFrm.ON', 'VcaMguPermiUsuarLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('vcaMguPermiUsuarFrm.idSelection', vcaMguPermiUsuarList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('vcaMguPermiUsuarFrm');
	vcaMguPermiUsuarViewDetail(vcaMguPermiUsuarList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function vcaMguPermiUsuarViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('vcaMguPermiUsuarFrm.accion');
	parametros["accion"] = get('vcaMguPermiUsuarFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('VcaMguPermiUsuarLPStartUp', get('vcaMguPermiUsuarFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('vcaMguPermiUsuarFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
		
	
	if(validacion)envia('vcaMguPermiUsuarFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	vcaMguPermiUsuarRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('vcaMguPermiUsuarFrm.accion');
	var origenTmp = get('vcaMguPermiUsuarFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(vcaMguPermiUsuarBuildUpdateRecordString() != vcaMguPermiUsuarTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('vcaMguPermiUsuarFrm.performRequery', 'true');
		set('vcaMguPermiUsuarFrm.accion', 
			get('vcaMguPermiUsuarFrm.previousAction'));
		set('vcaMguPermiUsuarFrm.origen', 'menu');
		set('vcaMguPermiUsuarFrm.ON', 'VcaMguPermiUsuarLPStartUp');
		set('vcaMguPermiUsuarFrm.conectorAction', 'VcaMguPermiUsuarLPStartUp');
		vcaMguPermiUsuarFrm.oculto='N';
		envia('vcaMguPermiUsuarFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.vcaMguPermiUsuarListLayer.style.display='none';
	document.all.vcaMguPermiUsuarListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.vcaMguPermiUsuarListLayer.style.display='';
	document.all.vcaMguPermiUsuarListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsVcaMguPermiUsuarCodUsua = get('vcaMguPermiUsuarFrm.codUsua').toString();






	jsVcaMguPermiUsuarCodProp = get('vcaMguPermiUsuarFrm.codProp').toString();






	jsVcaMguPermiUsuarValProp = get('vcaMguPermiUsuarFrm.valProp').toString();








	var parametros = "";
	parametros += jsVcaMguPermiUsuarCodUsua + "|";



	parametros += jsVcaMguPermiUsuarCodProp + "|";



	parametros += jsVcaMguPermiUsuarValProp + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function vcaMguPermiUsuarBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsVcaMguPermiUsuarCodUsua + "|";
	parametros += jsVcaMguPermiUsuarCodProp + "|";
	parametros += jsVcaMguPermiUsuarValProp + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('vcaMguPermiUsuarFrm.accion'), 
		get('vcaMguPermiUsuarFrm.origen'));
	
	jsVcaMguPermiUsuarCodUsua = get('vcaMguPermiUsuarFrm.codUsua').toString();
	jsVcaMguPermiUsuarCodProp = get('vcaMguPermiUsuarFrm.codProp').toString();
	jsVcaMguPermiUsuarValProp = get('vcaMguPermiUsuarFrm.valProp').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('vcaMguPermiUsuarFrm.accion'), 
		get('vcaMguPermiUsuarFrm.origen'));


	set('vcaMguPermiUsuarFrm.codUsua', jsVcaMguPermiUsuarCodUsua);
	set('vcaMguPermiUsuarFrm.codProp', jsVcaMguPermiUsuarCodProp);
	set('vcaMguPermiUsuarFrm.valProp', jsVcaMguPermiUsuarValProp);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('vcaMguPermiUsuarFrm.errCodigo', errorCode);
	set('vcaMguPermiUsuarFrm.errDescripcion', description);
	set('vcaMguPermiUsuarFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
