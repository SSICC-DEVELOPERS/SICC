

/*
    INDRA/CAR/mmg
    $Id: carparamnr.js,v 1.1 2009/12/03 19:01:35 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarParamNrId = "";
var jsCarParamNrNiriOidNiveRies = "";
var jsCarParamNrValMini = "";
var jsCarParamNrValMaxi = "";

//Variables de paginacion, 
var carParamNrPageCount = 1;

//Varible de columna que representa el campo de choice
var carParamNrChoiceColumn = 3;

//Flag de siguiente pagina;
var carParamNrMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carParamNrTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var carParamNrLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("carParamNr","niriOidNiveRies", false);','focalizaComboDependence("carParamNr","niriOidNiveRies", false);','focalizaComboDependence("carParamNr","niriOidNiveRies", false);','focalizaComboDependence("carParamNr","niriOidNiveRies", true);','focalizaComboDependence("carParamNr","niriOidNiveRies", true);','focalizaComboDependence("carParamNr","niriOidNiveRies", true);'],[3,'focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");'],[4,'focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");','focaliza("carParamNrFrm.valMini");'],[4,'focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");','focaliza("carParamNrFrm.valMaxi");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var niriOidNiveRiesDependeceMap = new Vector();
niriOidNiveRiesDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
niriOidNiveRiesDependeceMap.agregar(['niriOidNiveRies', padresTmp, '', 'CarNivelRiesg']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
carParamNrLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var carParamNrTmpUpdateValues;


		//funcion para valMaxi y su validaci�n con valMini
		function validacionvalMaxivalMini(){
			if ((get('carParamNrFrm.valMaxi','T').toString()=="") || 
			(get('carParamNrFrm.valMini','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificaci�n.
				return 'OK';
			if (!(parseFloat(get('carParamNrFrm.valMaxi','T').toString())>parseFloat(get('carParamNrFrm.valMini','T').toString()))) {
				//mensaje de error internacionalizable
				return GestionarMensaje("CarParamNr.valMaxivalMini.message");
			}
			else
				return 'OK';
		}
		

//Funci�n ejecutada en el onload de la pagina
function carParamNrInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('carParamNrFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('carParamNrFrm.accion')){
		case "query": carParamNrQueryInitComponents(); break;
		case "view": carParamNrViewInitComponents(); break;
		case "create": carParamNrCreateInitComponents(); break;
		case "update": carParamNrUpdateInitComponents(); break;
		case "remove": carParamNrRemoveInitComponents(); break;
		case "lov": carParamNrLovInitComponents(); break;
	}
	//alert('accion :' + get('carParamNrFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('carParamNrFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carParamNr')) carParamNrCmdRequery();
}

function carParamNrQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('carParamNrFrm', true);	
}

function carParamNrViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('carParamNrFrm', true);
}

function carParamNrCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carParamNrFrm.niriOidNiveRies','S', GestionarMensaje('CarParamNr.niriOidNiveRies.requiered.message'));
	
	setMV('carParamNrFrm.valMini','S', GestionarMensaje('CarParamNr.valMini.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('carParamNrFrm', true);
}

function carParamNrUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('carParamNrFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		carParamNrTmpUpdateValues = carParamNrBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carParamNrFrm.niriOidNiveRies','S', GestionarMensaje('CarParamNr.niriOidNiveRies.requiered.message'));
		setMV('carParamNrFrm.valMini','S', GestionarMensaje('CarParamNr.valMini.requiered.message'));
		
			focusFirstFieldModify('carParamNrFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('carParamNrFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('carParamNrFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carParamNrRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	carParamNrList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('carParamNrFrm', true);
}

function carParamNrLovInitComponents(){
	carParamNrLovReturnParameters = window.dialogArguments;
	
	focusFirstField('carParamNrFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function carParamNrSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carParamNrFrm.' + campo, id);
	set('carParamNrFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function carParamNrLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carParamNrLovReturnParameters.id = '';
	carParamNrLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carParamNrLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carParamNrList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carParamNrList.codSeleccionados();
	var descripcion = carParamNrList.extraeDato(
		carParamNrList.codSeleccionados()[0], carParamNrChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carParamNrLovReturnParameters.id = codigo;
	carParamNrLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function carParamNrCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carParamNrFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('carParamNrFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carParamNrList", "CarParamNrConectorTransactionQuery", 
		"result_ROWSET", parametros, "carParamNrPostQueryActions(datos);"]], "", "");	
}

function carParamNrCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carParamNrFrm.lastQueryToSession'));
	var i =0;
	set('carParamNrFrm.niriOidNiveRies', [paramsRequery.ij(i++)]);
	
	set('carParamNrFrm.valMini', paramsRequery.ij(i++));
	
	set('carParamNrFrm.valMaxi', paramsRequery.ij(i++));
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	carParamNrPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carParamNrCmdQuery(carParamNrPageCount);
}

function carParamNrFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carParamNrPageCount = 1;
	carParamNrCmdQuery(carParamNrPageCount);
}

function carParamNrPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carParamNrLastQuery){
		carParamNrFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carParamNrPageCount--;
	carParamNrCmdQuery(carParamNrPageCount);
}

function carParamNrNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carParamNrLastQuery){
		carParamNrFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carParamNrPageCount++;
	carParamNrCmdQuery(carParamNrPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carParamNrPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carParamNrListLayer', 'O');
		visibilidad('carParamNrListButtonsLayer', 'O');
		if(get('carParamNrFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	carParamNrLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:carParamNrViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carParamNrChoiceColumn) + "</A>",
			i, carParamNrChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carParamNrList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	carParamNrTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		carParamNrMorePagesFlag = true;
		carParamNrList.eliminar(mmgPageSize, 1);
	}else{
		carParamNrMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('carParamNrFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carParamNrListLayer', 'V');
	visibilidad('carParamNrListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carParamNrList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carParamNrList.display();
	
	//Actualizamos el estado de los botones 
	if(carParamNrMorePagesFlag){
		set_estado_botonera('carParamNrPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carParamNrPaginationButtonBar',
			3,"inactivo");
	}
	if(carParamNrPageCount > 1){
		set_estado_botonera('carParamNrPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carParamNrPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carParamNrPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carParamNrPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carParamNrUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carParamNrList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carParamNrFrm.idSelection', carParamNrList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('carParamNrFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = carParamNrList.codSeleccionados()[0];
		parametros["previousAction"] = get('carParamNrFrm.accion');
		parametros["accion"] = get('carParamNrFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CarParamNrLPStartUp', get('carParamNrFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) carParamNrCmdRequery();
	}
}

function carParamNrRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carParamNrList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carParamNrList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carParamNrFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carParamNrList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carParamNrTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carParamNrFrm.timestamp', timestamps);


	carParamNrFrm.oculto='S';
	envia('carParamNrFrm');
	carParamNrFrm.oculto='N';
}

function carParamNrViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carParamNrList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	carParamNrViewDetail(carParamNrList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function carParamNrViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carParamNrFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CarParamNrLPStartUp', 'view', parametros, null, null);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('carParamNrFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion){
		carParamNrFrm.oculto='S';
		envia('carParamNrFrm');
		carParamNrFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('carParamNrFrm.niriOidNiveRies').toString() == ''){
		set('carParamNrFrm.niriOidNiveRies', []);
		mmgResetCombosOnCascade('niriOidNiveRies', 'niriOidNiveRies', 'carParamNr');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	carParamNrRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('carParamNrFrm.accion');
	var origenTmp = get('carParamNrFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carParamNrBuildUpdateRecordString() != carParamNrTmpUpdateValues){
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
	document.all.carParamNrListLayer.style.display='none';
	document.all.carParamNrListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carParamNrListLayer.style.display='';
	document.all.carParamNrListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsCarParamNrNiriOidNiveRies = get('carParamNrFrm.niriOidNiveRies')[0];
	jsCarParamNrValMini = get('carParamNrFrm.valMini').toString();
	jsCarParamNrValMaxi = get('carParamNrFrm.valMaxi').toString();
	
	
	var parametros = "";
	parametros += jsCarParamNrNiriOidNiveRies + "|";
	parametros += jsCarParamNrValMini + "|";
	parametros += jsCarParamNrValMaxi + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carParamNrBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarParamNrNiriOidNiveRies + "|";
	parametros += jsCarParamNrValMini + "|";
	parametros += jsCarParamNrValMaxi + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carParamNrFrm.accion'), 
		get('carParamNrFrm.origen'));
	
	jsCarParamNrId = get('carParamNrFrm.id').toString();
	jsCarParamNrNiriOidNiveRies = get('carParamNrFrm.niriOidNiveRies')[0];
	jsCarParamNrValMini = get('carParamNrFrm.valMini').toString();
	jsCarParamNrValMaxi = get('carParamNrFrm.valMaxi').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carParamNrFrm.accion'), 
		get('carParamNrFrm.origen'));


	set('carParamNrFrm.id', jsCarParamNrId);
	set('carParamNrFrm.niriOidNiveRies', [jsCarParamNrNiriOidNiveRies]);
	set('carParamNrFrm.valMini', jsCarParamNrValMini);
	set('carParamNrFrm.valMaxi', jsCarParamNrValMaxi);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsCarParamNrNiriOidNiveRies = '';
	jsCarParamNrValMini = '';
	jsCarParamNrValMaxi = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carParamNrFrm.errCodigo', errorCode);
	set('carParamNrFrm.errDescripcion', description);
	set('carParamNrFrm.errSeverity', severity);
	fMostrarMensajeError();
}
