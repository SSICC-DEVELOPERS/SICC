

/*
    INDRA/CAR/mmg
    $Id: cartiporeeva.js,v 1.1 2009/12/03 19:02:22 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarTipoReevaId = "";

//Variables de paginacion, 
var carTipoReevaPageCount = 1;

//Varible de columna que representa el campo de choice
var carTipoReevaChoiceColumn = 0;

//Flag de siguiente pagina;
var carTipoReevaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carTipoReevaTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 80;
var sizeFormView = 80;
var sizeFormUpdate = 80;

//Ultima busqueda realizada
var carTipoReevaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar(]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu� consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
carTipoReevaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var carTipoReevaTmpUpdateValues;


//Funci�n ejecutada en el onload de la pagina
function carTipoReevaInitComponents(){
	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('carTipoReevaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('carTipoReevaFrm.accion')){
		case "query": carTipoReevaQueryInitComponents(); break;
		case "view": carTipoReevaViewInitComponents(); break;
		case "create": carTipoReevaCreateInitComponents(); break;
		case "update": carTipoReevaUpdateInitComponents(); break;
		case "remove": carTipoReevaRemoveInitComponents(); break;
		case "lov": carTipoReevaLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('carTipoReevaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carTipoReeva')) carTipoReevaCmdRequery();
}

function carTipoReevaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
}

function carTipoReevaViewInitComponents(){
	//En principiono se hace nada
}

function carTipoReevaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	//Asignamos los textos de campo requerido
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function carTipoReevaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('carTipoReevaFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		carTipoReevaTmpUpdateValues = carTipoReevaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('carTipoReevaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carTipoReevaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	carTipoReevaList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function carTipoReevaLovInitComponents(){
	carTipoReevaLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad



//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function carTipoReevaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carTipoReevaFrm.' + campo, id);
	set('carTipoReevaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function carTipoReevaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carTipoReevaLovReturnParameters.id = '';
	carTipoReevaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carTipoReevaLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carTipoReevaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carTipoReevaList.codSeleccionados();
	var descripcion = carTipoReevaList.extraeDato(
		carTipoReevaList.codSeleccionados()[0], carTipoReevaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carTipoReevaLovReturnParameters.id = codigo;
	carTipoReevaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function carTipoReevaCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carTipoReevaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	carTipoReevaLastQuery = parametros;

	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('carTipoReevaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carTipoReevaList", "CarTipoReevaConectorTransactionQuery", 
		"result_ROWSET", parametros, "carTipoReevaPostQueryActions(datos);"]], "", "");	
}

function carTipoReevaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carTipoReevaFrm.lastQueryToSession'));
	var i =0;
	
	
	//No se nos actualizar los parm�metros de la paginaci�n
	carTipoReevaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carTipoReevaCmdQuery(carTipoReevaPageCount);
}

function carTipoReevaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carTipoReevaPageCount = 1;
	carTipoReevaCmdQuery(carTipoReevaPageCount);
}

function carTipoReevaPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carTipoReevaLastQuery){
		carTipoReevaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carTipoReevaPageCount--;
	carTipoReevaCmdQuery(carTipoReevaPageCount);
}

function carTipoReevaNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carTipoReevaLastQuery){
		carTipoReevaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carTipoReevaPageCount++;
	carTipoReevaCmdQuery(carTipoReevaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carTipoReevaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carTipoReevaListLayer', 'O');
		visibilidad('carTipoReevaListButtonsLayer', 'O');
		if(get('carTipoReevaFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:carTipoReevaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carTipoReevaChoiceColumn) + "</A>",
			i, carTipoReevaChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carTipoReevaList.setDatos(datosTmp.filtrar([0],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	carTipoReevaTimeStamps = datosTmp.filtrar([1],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		carTipoReevaMorePagesFlag = true;
		carTipoReevaList.eliminar(mmgPageSize, 1);
	}else{
		carTipoReevaMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('carTipoReevaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carTipoReevaListLayer', 'V');
	visibilidad('carTipoReevaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carTipoReevaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carTipoReevaList.display();
	
	//Actualizamos el estado de los botones 
	if(carTipoReevaMorePagesFlag){
		set_estado_botonera('carTipoReevaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carTipoReevaPaginationButtonBar',
			3,"inactivo");
	}
	if(carTipoReevaPageCount > 1){
		set_estado_botonera('carTipoReevaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carTipoReevaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carTipoReevaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carTipoReevaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carTipoReevaUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carTipoReevaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carTipoReevaFrm.idSelection', carTipoReevaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('carTipoReevaFrm', true);
	if(validacion){
		/*set('carTipoReevaFrm.previousAction', 'update');
		set('carTipoReevaFrm.ON', 'CarTipoReevaLPStartUp');
		set('carTipoReevaFrm.conectorAction', 'CarTipoReevaLPStartUp');
		set('carTipoReevaFrm.origen', 'pagina');
		envia('carTipoReevaFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = carTipoReevaList.codSeleccionados()[0];
		parametros["previousAction"] = get('carTipoReevaFrm.accion');
		parametros["accion"] = get('carTipoReevaFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('CarTipoReevaLPStartUp', get('carTipoReevaFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) carTipoReevaCmdRequery();
	}
}

function carTipoReevaRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carTipoReevaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carTipoReevaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carTipoReevaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carTipoReevaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carTipoReevaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carTipoReevaFrm.timestamp', timestamps);
	envia('carTipoReevaFrm');
}

function carTipoReevaViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carTipoReevaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('carTipoReevaFrm.previousAction', get('carTipoReevaFrm.accion'));
	set('carTipoReevaFrm.accion', 'view');
	set('carTipoReevaFrm.origen', 'pagina');
	set('carTipoReevaFrm.ON', 'CarTipoReevaLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('carTipoReevaFrm.idSelection', carTipoReevaList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('carTipoReevaFrm');
	carTipoReevaViewDetail(carTipoReevaList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function carTipoReevaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carTipoReevaFrm.accion');
	parametros["accion"] = get('carTipoReevaFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('CarTipoReevaLPStartUp', get('carTipoReevaFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('carTipoReevaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
		
	
	if(validacion)envia('carTipoReevaFrm');
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	carTipoReevaRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('carTipoReevaFrm.accion');
	var origenTmp = get('carTipoReevaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carTipoReevaBuildUpdateRecordString() != carTipoReevaTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('carTipoReevaFrm.performRequery', 'true');
		set('carTipoReevaFrm.accion', 
			get('carTipoReevaFrm.previousAction'));
		set('carTipoReevaFrm.origen', 'menu');
		set('carTipoReevaFrm.ON', 'CarTipoReevaLPStartUp');
		set('carTipoReevaFrm.conectorAction', 'CarTipoReevaLPStartUp');
		carTipoReevaFrm.oculto='N';
		envia('carTipoReevaFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.carTipoReevaListLayer.style.display='none';
	document.all.carTipoReevaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carTipoReevaListLayer.style.display='';
	document.all.carTipoReevaListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda


	var parametros = "";

	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carTipoReevaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carTipoReevaFrm.accion'), 
		get('carTipoReevaFrm.origen'));
	
	jsCarTipoReevaId = get('carTipoReevaFrm.id').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carTipoReevaFrm.accion'), 
		get('carTipoReevaFrm.origen'));


	set('carTipoReevaFrm.id', jsCarTipoReevaId);

}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carTipoReevaFrm.errCodigo', errorCode);
	set('carTipoReevaFrm.errDescripcion', description);
	set('carTipoReevaFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
