

/*
    INDRA/CAR/mmg
    $Id: eduplantcursocabec.js,v 1.1 2009/12/03 19:02:11 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsEduPlantCursoCabecId = "";

//Variables de paginacion, 
var eduPlantCursoCabecPageCount = 1;

//Varible de columna que representa el campo de choice
var eduPlantCursoCabecChoiceColumn = 0;

//Flag de siguiente pagina;
var eduPlantCursoCabecMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var eduPlantCursoCabecTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 80;
var sizeFormView = 80;
var sizeFormUpdate = 80;

//Ultima busqueda realizada
var eduPlantCursoCabecLastQuery= null;

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
eduPlantCursoCabecLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var eduPlantCursoCabecTmpUpdateValues;


//Funci�n ejecutada en el onload de la pagina
function eduPlantCursoCabecInitComponents(){
	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('eduPlantCursoCabecFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('eduPlantCursoCabecFrm.accion')){
		case "query": eduPlantCursoCabecQueryInitComponents(); break;
		case "view": eduPlantCursoCabecViewInitComponents(); break;
		case "create": eduPlantCursoCabecCreateInitComponents(); break;
		case "update": eduPlantCursoCabecUpdateInitComponents(); break;
		case "remove": eduPlantCursoCabecRemoveInitComponents(); break;
		case "lov": eduPlantCursoCabecLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('eduPlantCursoCabecFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('eduPlantCursoCabec')) eduPlantCursoCabecCmdRequery();
}

function eduPlantCursoCabecQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
}

function eduPlantCursoCabecViewInitComponents(){
	//En principiono se hace nada
}

function eduPlantCursoCabecCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	//Asignamos los textos de campo requerido
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function eduPlantCursoCabecUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('eduPlantCursoCabecFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		eduPlantCursoCabecTmpUpdateValues = eduPlantCursoCabecBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('eduPlantCursoCabecFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function eduPlantCursoCabecRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	eduPlantCursoCabecList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function eduPlantCursoCabecLovInitComponents(){
	eduPlantCursoCabecLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad



//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function eduPlantCursoCabecSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('eduPlantCursoCabecFrm.' + campo, id);
	set('eduPlantCursoCabecFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function eduPlantCursoCabecLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	eduPlantCursoCabecLovReturnParameters.id = '';
	eduPlantCursoCabecLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function eduPlantCursoCabecLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduPlantCursoCabecList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = eduPlantCursoCabecList.codSeleccionados();
	var descripcion = eduPlantCursoCabecList.extraeDato(
		eduPlantCursoCabecList.codSeleccionados()[0], eduPlantCursoCabecChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	eduPlantCursoCabecLovReturnParameters.id = codigo;
	eduPlantCursoCabecLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function eduPlantCursoCabecCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('eduPlantCursoCabecFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	eduPlantCursoCabecLastQuery = parametros;

	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('eduPlantCursoCabecFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "eduPlantCursoCabecList", "EduPlantCursoCabecConectorTransactionQuery", 
		"result_ROWSET", parametros, "eduPlantCursoCabecPostQueryActions(datos);"]], "", "");	
}

function eduPlantCursoCabecCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('eduPlantCursoCabecFrm.lastQueryToSession'));
	var i =0;
	
	
	//No se nos actualizar los parm�metros de la paginaci�n
	eduPlantCursoCabecPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	eduPlantCursoCabecCmdQuery(eduPlantCursoCabecPageCount);
}

function eduPlantCursoCabecFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	eduPlantCursoCabecPageCount = 1;
	eduPlantCursoCabecCmdQuery(eduPlantCursoCabecPageCount);
}

function eduPlantCursoCabecPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != eduPlantCursoCabecLastQuery){
		eduPlantCursoCabecFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	eduPlantCursoCabecPageCount--;
	eduPlantCursoCabecCmdQuery(eduPlantCursoCabecPageCount);
}

function eduPlantCursoCabecNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != eduPlantCursoCabecLastQuery){
		eduPlantCursoCabecFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	eduPlantCursoCabecPageCount++;
	eduPlantCursoCabecCmdQuery(eduPlantCursoCabecPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function eduPlantCursoCabecPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('eduPlantCursoCabecListLayer', 'O');
		visibilidad('eduPlantCursoCabecListButtonsLayer', 'O');
		if(get('eduPlantCursoCabecFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:eduPlantCursoCabecViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, eduPlantCursoCabecChoiceColumn) + "</A>",
			i, eduPlantCursoCabecChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	eduPlantCursoCabecList.setDatos(datosTmp.filtrar([0],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	eduPlantCursoCabecTimeStamps = datosTmp.filtrar([1],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		eduPlantCursoCabecMorePagesFlag = true;
		eduPlantCursoCabecList.eliminar(mmgPageSize, 1);
	}else{
		eduPlantCursoCabecMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('eduPlantCursoCabecFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('eduPlantCursoCabecListLayer', 'V');
	visibilidad('eduPlantCursoCabecListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('eduPlantCursoCabecList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	eduPlantCursoCabecList.display();
	
	//Actualizamos el estado de los botones 
	if(eduPlantCursoCabecMorePagesFlag){
		set_estado_botonera('eduPlantCursoCabecPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('eduPlantCursoCabecPaginationButtonBar',
			3,"inactivo");
	}
	if(eduPlantCursoCabecPageCount > 1){
		set_estado_botonera('eduPlantCursoCabecPaginationButtonBar',
			2,"activo");
		set_estado_botonera('eduPlantCursoCabecPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('eduPlantCursoCabecPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('eduPlantCursoCabecPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function eduPlantCursoCabecUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduPlantCursoCabecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('eduPlantCursoCabecFrm.idSelection', eduPlantCursoCabecList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('eduPlantCursoCabecFrm', true);
	if(validacion){
		/*set('eduPlantCursoCabecFrm.previousAction', 'update');
		set('eduPlantCursoCabecFrm.ON', 'EduPlantCursoCabecLPStartUp');
		set('eduPlantCursoCabecFrm.conectorAction', 'EduPlantCursoCabecLPStartUp');
		set('eduPlantCursoCabecFrm.origen', 'pagina');
		envia('eduPlantCursoCabecFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = eduPlantCursoCabecList.codSeleccionados()[0];
		parametros["previousAction"] = get('eduPlantCursoCabecFrm.accion');
		parametros["accion"] = get('eduPlantCursoCabecFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('EduPlantCursoCabecLPStartUp', get('eduPlantCursoCabecFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) eduPlantCursoCabecCmdRequery();
	}
}

function eduPlantCursoCabecRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduPlantCursoCabecList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = eduPlantCursoCabecList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('eduPlantCursoCabecFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(eduPlantCursoCabecList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += eduPlantCursoCabecTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('eduPlantCursoCabecFrm.timestamp', timestamps);
	envia('eduPlantCursoCabecFrm');
}

function eduPlantCursoCabecViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduPlantCursoCabecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('eduPlantCursoCabecFrm.previousAction', get('eduPlantCursoCabecFrm.accion'));
	set('eduPlantCursoCabecFrm.accion', 'view');
	set('eduPlantCursoCabecFrm.origen', 'pagina');
	set('eduPlantCursoCabecFrm.ON', 'EduPlantCursoCabecLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('eduPlantCursoCabecFrm.idSelection', eduPlantCursoCabecList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('eduPlantCursoCabecFrm');
	eduPlantCursoCabecViewDetail(eduPlantCursoCabecList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function eduPlantCursoCabecViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('eduPlantCursoCabecFrm.accion');
	parametros["accion"] = get('eduPlantCursoCabecFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('EduPlantCursoCabecLPStartUp', get('eduPlantCursoCabecFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('eduPlantCursoCabecFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
		
	
	if(validacion)envia('eduPlantCursoCabecFrm');
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	eduPlantCursoCabecRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('eduPlantCursoCabecFrm.accion');
	var origenTmp = get('eduPlantCursoCabecFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(eduPlantCursoCabecBuildUpdateRecordString() != eduPlantCursoCabecTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('eduPlantCursoCabecFrm.performRequery', 'true');
		set('eduPlantCursoCabecFrm.accion', 
			get('eduPlantCursoCabecFrm.previousAction'));
		set('eduPlantCursoCabecFrm.origen', 'menu');
		set('eduPlantCursoCabecFrm.ON', 'EduPlantCursoCabecLPStartUp');
		set('eduPlantCursoCabecFrm.conectorAction', 'EduPlantCursoCabecLPStartUp');
		eduPlantCursoCabecFrm.oculto='N';
		envia('eduPlantCursoCabecFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.eduPlantCursoCabecListLayer.style.display='none';
	document.all.eduPlantCursoCabecListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.eduPlantCursoCabecListLayer.style.display='';
	document.all.eduPlantCursoCabecListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda


	var parametros = "";

	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function eduPlantCursoCabecBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduPlantCursoCabecFrm.accion'), 
		get('eduPlantCursoCabecFrm.origen'));
	
	jsEduPlantCursoCabecId = get('eduPlantCursoCabecFrm.id').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduPlantCursoCabecFrm.accion'), 
		get('eduPlantCursoCabecFrm.origen'));


	set('eduPlantCursoCabecFrm.id', jsEduPlantCursoCabecId);

}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('eduPlantCursoCabecFrm.errCodigo', errorCode);
	set('eduPlantCursoCabecFrm.errDescripcion', description);
	set('eduPlantCursoCabecFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
