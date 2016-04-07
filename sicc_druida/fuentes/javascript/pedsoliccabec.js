

/*
    INDRA/CAR/mmg
    $Id: pedsoliccabec.js,v 1.1 2009/12/03 19:01:37 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedSolicCabecId = "";

//Variables de paginacion, 
var pedSolicCabecPageCount = 1;

//Varible de columna que representa el campo de choice
var pedSolicCabecChoiceColumn = 0;

//Flag de siguiente pagina;
var pedSolicCabecMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedSolicCabecTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 80;
var sizeFormView = 80;
var sizeFormUpdate = 80;

//Ultima busqueda realizada
var pedSolicCabecLastQuery= null;

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
pedSolicCabecLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var pedSolicCabecTmpUpdateValues;


//Funci�n ejecutada en el onload de la pagina
function pedSolicCabecInitComponents(){
	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('pedSolicCabecFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('pedSolicCabecFrm.accion')){
		case "query": pedSolicCabecQueryInitComponents(); break;
		case "view": pedSolicCabecViewInitComponents(); break;
		case "create": pedSolicCabecCreateInitComponents(); break;
		case "update": pedSolicCabecUpdateInitComponents(); break;
		case "remove": pedSolicCabecRemoveInitComponents(); break;
		case "lov": pedSolicCabecLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('pedSolicCabecFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedSolicCabec')) pedSolicCabecCmdRequery();
}

function pedSolicCabecQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
}

function pedSolicCabecViewInitComponents(){
	//En principiono se hace nada
}

function pedSolicCabecCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	//Asignamos los textos de campo requerido
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function pedSolicCabecUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('pedSolicCabecFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		pedSolicCabecTmpUpdateValues = pedSolicCabecBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('pedSolicCabecFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedSolicCabecRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	pedSolicCabecList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function pedSolicCabecLovInitComponents(){
	pedSolicCabecLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad



//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function pedSolicCabecSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedSolicCabecFrm.' + campo, id);
	set('pedSolicCabecFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function pedSolicCabecLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedSolicCabecLovReturnParameters.id = '';
	pedSolicCabecLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedSolicCabecLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(pedSolicCabecList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedSolicCabecList.codSeleccionados();
	var descripcion = pedSolicCabecList.extraeDato(
		pedSolicCabecList.codSeleccionados()[0], pedSolicCabecChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedSolicCabecLovReturnParameters.id = codigo;
	pedSolicCabecLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function pedSolicCabecCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedSolicCabecFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	pedSolicCabecLastQuery = parametros;

	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('pedSolicCabecFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedSolicCabecList", "PedSolicCabecConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedSolicCabecPostQueryActions(datos);"]], "", "");	
}

function pedSolicCabecCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedSolicCabecFrm.lastQueryToSession'));
	var i =0;
	
	
	//No se nos actualizar los parm�metros de la paginaci�n
	pedSolicCabecPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedSolicCabecCmdQuery(pedSolicCabecPageCount);
}

function pedSolicCabecFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedSolicCabecPageCount = 1;
	pedSolicCabecCmdQuery(pedSolicCabecPageCount);
}

function pedSolicCabecPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != pedSolicCabecLastQuery){
		pedSolicCabecFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedSolicCabecPageCount--;
	pedSolicCabecCmdQuery(pedSolicCabecPageCount);
}

function pedSolicCabecNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != pedSolicCabecLastQuery){
		pedSolicCabecFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedSolicCabecPageCount++;
	pedSolicCabecCmdQuery(pedSolicCabecPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedSolicCabecPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedSolicCabecListLayer', 'O');
		visibilidad('pedSolicCabecListButtonsLayer', 'O');
		if(get('pedSolicCabecFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:pedSolicCabecViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedSolicCabecChoiceColumn) + "</A>",
			i, pedSolicCabecChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedSolicCabecList.setDatos(datosTmp.filtrar([0],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	pedSolicCabecTimeStamps = datosTmp.filtrar([1],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		pedSolicCabecMorePagesFlag = true;
		pedSolicCabecList.eliminar(mmgPageSize, 1);
	}else{
		pedSolicCabecMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('pedSolicCabecFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedSolicCabecListLayer', 'V');
	visibilidad('pedSolicCabecListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedSolicCabecList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedSolicCabecList.display();
	
	//Actualizamos el estado de los botones 
	if(pedSolicCabecMorePagesFlag){
		set_estado_botonera('pedSolicCabecPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedSolicCabecPaginationButtonBar',
			3,"inactivo");
	}
	if(pedSolicCabecPageCount > 1){
		set_estado_botonera('pedSolicCabecPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedSolicCabecPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedSolicCabecPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedSolicCabecPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedSolicCabecUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(pedSolicCabecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedSolicCabecFrm.idSelection', pedSolicCabecList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('pedSolicCabecFrm', true);
	if(validacion){
		/*set('pedSolicCabecFrm.previousAction', 'update');
		set('pedSolicCabecFrm.ON', 'PedSolicCabecLPStartUp');
		set('pedSolicCabecFrm.conectorAction', 'PedSolicCabecLPStartUp');
		set('pedSolicCabecFrm.origen', 'pagina');
		envia('pedSolicCabecFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = pedSolicCabecList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedSolicCabecFrm.accion');
		parametros["accion"] = get('pedSolicCabecFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('PedSolicCabecLPStartUp', get('pedSolicCabecFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) pedSolicCabecCmdRequery();
	}
}

function pedSolicCabecRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(pedSolicCabecList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedSolicCabecList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedSolicCabecFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedSolicCabecList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedSolicCabecTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedSolicCabecFrm.timestamp', timestamps);
	envia('pedSolicCabecFrm');
}

function pedSolicCabecViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(pedSolicCabecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('pedSolicCabecFrm.previousAction', get('pedSolicCabecFrm.accion'));
	set('pedSolicCabecFrm.accion', 'view');
	set('pedSolicCabecFrm.origen', 'pagina');
	set('pedSolicCabecFrm.ON', 'PedSolicCabecLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('pedSolicCabecFrm.idSelection', pedSolicCabecList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('pedSolicCabecFrm');
	pedSolicCabecViewDetail(pedSolicCabecList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function pedSolicCabecViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedSolicCabecFrm.accion');
	parametros["accion"] = get('pedSolicCabecFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('PedSolicCabecLPStartUp', get('pedSolicCabecFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('pedSolicCabecFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
		
	
	if(validacion)envia('pedSolicCabecFrm');
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	pedSolicCabecRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('pedSolicCabecFrm.accion');
	var origenTmp = get('pedSolicCabecFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedSolicCabecBuildUpdateRecordString() != pedSolicCabecTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('pedSolicCabecFrm.performRequery', 'true');
		set('pedSolicCabecFrm.accion', 
			get('pedSolicCabecFrm.previousAction'));
		set('pedSolicCabecFrm.origen', 'menu');
		set('pedSolicCabecFrm.ON', 'PedSolicCabecLPStartUp');
		set('pedSolicCabecFrm.conectorAction', 'PedSolicCabecLPStartUp');
		pedSolicCabecFrm.oculto='N';
		envia('pedSolicCabecFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.pedSolicCabecListLayer.style.display='none';
	document.all.pedSolicCabecListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedSolicCabecListLayer.style.display='';
	document.all.pedSolicCabecListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda


	var parametros = "";

	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedSolicCabecBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedSolicCabecFrm.accion'), 
		get('pedSolicCabecFrm.origen'));
	
	jsPedSolicCabecId = get('pedSolicCabecFrm.id').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedSolicCabecFrm.accion'), 
		get('pedSolicCabecFrm.origen'));


	set('pedSolicCabecFrm.id', jsPedSolicCabecId);

}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedSolicCabecFrm.errCodigo', errorCode);
	set('pedSolicCabecFrm.errDescripcion', description);
	set('pedSolicCabecFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
