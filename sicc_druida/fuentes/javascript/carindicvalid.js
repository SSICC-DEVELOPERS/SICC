

/*
    INDRA/CAR/mmg
    $Id: carindicvalid.js,v 1.1 2009/12/03 19:02:14 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarIndicValidId = "";
var jsCarIndicValidCodIndiVali = "";

//Variables de paginacion, 
var carIndicValidPageCount = 1;

//Varible de columna que representa el campo de choice
var carIndicValidChoiceColumn = 1;

//Flag de siguiente pagina;
var carIndicValidMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carIndicValidTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 115;
var sizeFormView = 115;
var sizeFormUpdate = 115;

//Ultima busqueda realizada
var carIndicValidLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("carIndicValidFrm.codIndiVali");','focaliza("carIndicValidFrm.codIndiVali");','focaliza("carIndicValidFrm.codIndiVali");','focaliza("carIndicValidFrm.codIndiVali");','focaliza("carIndicValidFrm.codIndiVali");','focaliza("carIndicValidFrm.codIndiVali");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu� consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
carIndicValidLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var carIndicValidTmpUpdateValues;


//Funci�n ejecutada en el onload de la pagina
function carIndicValidInitComponents(){
	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('carIndicValidFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('carIndicValidFrm.accion')){
		case "query": carIndicValidQueryInitComponents(); break;
		case "view": carIndicValidViewInitComponents(); break;
		case "create": carIndicValidCreateInitComponents(); break;
		case "update": carIndicValidUpdateInitComponents(); break;
		case "remove": carIndicValidRemoveInitComponents(); break;
		case "lov": carIndicValidLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('carIndicValidFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carIndicValid')) carIndicValidCmdRequery();
}

function carIndicValidQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
}

function carIndicValidViewInitComponents(){
	//En principiono se hace nada
}

function carIndicValidCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carIndicValidFrm.codIndiVali','S', GestionarMensaje('CarIndicValid.codIndiVali.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function carIndicValidUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('carIndicValidFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		carIndicValidTmpUpdateValues = carIndicValidBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carIndicValidFrm.codIndiVali','S', GestionarMensaje('CarIndicValid.codIndiVali.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('carIndicValidFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carIndicValidRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	carIndicValidList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function carIndicValidLovInitComponents(){
	carIndicValidLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad




//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function carIndicValidSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carIndicValidFrm.' + campo, id);
	set('carIndicValidFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function carIndicValidLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carIndicValidLovReturnParameters.id = '';
	carIndicValidLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carIndicValidLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carIndicValidList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carIndicValidList.codSeleccionados();
	var descripcion = carIndicValidList.extraeDato(
		carIndicValidList.codSeleccionados()[0], carIndicValidChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carIndicValidLovReturnParameters.id = codigo;
	carIndicValidLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function carIndicValidCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carIndicValidFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	carIndicValidLastQuery = parametros;

	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('carIndicValidFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carIndicValidList", "CarIndicValidConectorTransactionQuery", 
		"result_ROWSET", parametros, "carIndicValidPostQueryActions(datos);"]], "", "");	
}

function carIndicValidCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carIndicValidFrm.lastQueryToSession'));
	var i =0;
	set('carIndicValidFrm.codIndiVali', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parm�metros de la paginaci�n
	carIndicValidPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carIndicValidCmdQuery(carIndicValidPageCount);
}

function carIndicValidFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carIndicValidPageCount = 1;
	carIndicValidCmdQuery(carIndicValidPageCount);
}

function carIndicValidPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carIndicValidLastQuery){
		carIndicValidFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carIndicValidPageCount--;
	carIndicValidCmdQuery(carIndicValidPageCount);
}

function carIndicValidNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carIndicValidLastQuery){
		carIndicValidFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carIndicValidPageCount++;
	carIndicValidCmdQuery(carIndicValidPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carIndicValidPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carIndicValidListLayer', 'O');
		visibilidad('carIndicValidListButtonsLayer', 'O');
		if(get('carIndicValidFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:carIndicValidViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carIndicValidChoiceColumn) + "</A>",
			i, carIndicValidChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carIndicValidList.setDatos(datosTmp.filtrar([0,1],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	carIndicValidTimeStamps = datosTmp.filtrar([2],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		carIndicValidMorePagesFlag = true;
		carIndicValidList.eliminar(mmgPageSize, 1);
	}else{
		carIndicValidMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('carIndicValidFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carIndicValidListLayer', 'V');
	visibilidad('carIndicValidListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carIndicValidList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carIndicValidList.display();
	
	//Actualizamos el estado de los botones 
	if(carIndicValidMorePagesFlag){
		set_estado_botonera('carIndicValidPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carIndicValidPaginationButtonBar',
			3,"inactivo");
	}
	if(carIndicValidPageCount > 1){
		set_estado_botonera('carIndicValidPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carIndicValidPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carIndicValidPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carIndicValidPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carIndicValidUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carIndicValidList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carIndicValidFrm.idSelection', carIndicValidList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('carIndicValidFrm', true);
	if(validacion){
		/*set('carIndicValidFrm.previousAction', 'update');
		set('carIndicValidFrm.ON', 'CarIndicValidLPStartUp');
		set('carIndicValidFrm.conectorAction', 'CarIndicValidLPStartUp');
		set('carIndicValidFrm.origen', 'pagina');
		envia('carIndicValidFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = carIndicValidList.codSeleccionados()[0];
		parametros["previousAction"] = get('carIndicValidFrm.accion');
		parametros["accion"] = get('carIndicValidFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('CarIndicValidLPStartUp', get('carIndicValidFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) carIndicValidCmdRequery();
	}
}

function carIndicValidRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carIndicValidList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carIndicValidList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carIndicValidFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carIndicValidList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carIndicValidTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carIndicValidFrm.timestamp', timestamps);
	envia('carIndicValidFrm');
}

function carIndicValidViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carIndicValidList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('carIndicValidFrm.previousAction', get('carIndicValidFrm.accion'));
	set('carIndicValidFrm.accion', 'view');
	set('carIndicValidFrm.origen', 'pagina');
	set('carIndicValidFrm.ON', 'CarIndicValidLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('carIndicValidFrm.idSelection', carIndicValidList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('carIndicValidFrm');
	carIndicValidViewDetail(carIndicValidList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function carIndicValidViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carIndicValidFrm.accion');
	parametros["accion"] = get('carIndicValidFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('CarIndicValidLPStartUp', get('carIndicValidFrm.accion'), parametros, null, sizeFormView + 30);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('carIndicValidFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
		
	
	if(validacion)envia('carIndicValidFrm');
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	carIndicValidRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('carIndicValidFrm.accion');
	var origenTmp = get('carIndicValidFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carIndicValidBuildUpdateRecordString() != carIndicValidTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('carIndicValidFrm.performRequery', 'true');
		set('carIndicValidFrm.accion', 
			get('carIndicValidFrm.previousAction'));
		set('carIndicValidFrm.origen', 'menu');
		set('carIndicValidFrm.ON', 'CarIndicValidLPStartUp');
		set('carIndicValidFrm.conectorAction', 'CarIndicValidLPStartUp');
		carIndicValidFrm.oculto='N';
		envia('carIndicValidFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.carIndicValidListLayer.style.display='none';
	document.all.carIndicValidListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carIndicValidListLayer.style.display='';
	document.all.carIndicValidListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsCarIndicValidCodIndiVali = get('carIndicValidFrm.codIndiVali').toString();








	var parametros = "";
	parametros += jsCarIndicValidCodIndiVali + "|";




	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carIndicValidBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarIndicValidCodIndiVali + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carIndicValidFrm.accion'), 
		get('carIndicValidFrm.origen'));
	
	jsCarIndicValidId = get('carIndicValidFrm.id').toString();
	jsCarIndicValidCodIndiVali = get('carIndicValidFrm.codIndiVali').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carIndicValidFrm.accion'), 
		get('carIndicValidFrm.origen'));


	set('carIndicValidFrm.id', jsCarIndicValidId);
	set('carIndicValidFrm.codIndiVali', jsCarIndicValidCodIndiVali);

}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carIndicValidFrm.errCodigo', errorCode);
	set('carIndicValidFrm.errDescripcion', description);
	set('carIndicValidFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
