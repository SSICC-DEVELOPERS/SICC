

/*
    INDRA/CAR/mmg
    $Id: carcondievalunr.js,v 1.1 2009/12/03 19:02:11 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarCondiEvaluNrId = "";
var jsCarCondiEvaluNrPenrOidParaEvalNr = "";
var jsCarCondiEvaluNrValMini = "";
var jsCarCondiEvaluNrValMaxi = "";
var jsCarCondiEvaluNrValEscaMini = "";

//Variables de paginacion, 
var carCondiEvaluNrPageCount = 1;

//Varible de columna que representa el campo de choice
var carCondiEvaluNrChoiceColumn = 4;

//Flag de siguiente pagina;
var carCondiEvaluNrMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carCondiEvaluNrTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var carCondiEvaluNrLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("carCondiEvaluNr","penrOidParaEvalNr", false);','focalizaComboDependence("carCondiEvaluNr","penrOidParaEvalNr", false);','focalizaComboDependence("carCondiEvaluNr","penrOidParaEvalNr", false);','focalizaComboDependence("carCondiEvaluNr","penrOidParaEvalNr", true);','focalizaComboDependence("carCondiEvaluNr","penrOidParaEvalNr", true);','focalizaComboDependence("carCondiEvaluNr","penrOidParaEvalNr", true);'],[3,'focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");'],[4,'focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");'],[5,'focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");','focaliza("carCondiEvaluNrFrm.valMini");'],[4,'focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");','focaliza("carCondiEvaluNrFrm.valMaxi");'],[5,'focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");','focaliza("carCondiEvaluNrFrm.valEscaMini");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var penrOidParaEvalNrDependeceMap = new Vector();
penrOidParaEvalNrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
penrOidParaEvalNrDependeceMap.agregar(['penrOidParaEvalNr', padresTmp, '', 'CarParamEvaluNr']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
carCondiEvaluNrLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var carCondiEvaluNrTmpUpdateValues;


		//funcion para valMaxi y su validaci�n con valMini
		function validacionvalMaxivalMini(){
			if ((get('carCondiEvaluNrFrm.valMaxi','T').toString()=="") || 
			(get('carCondiEvaluNrFrm.valMini','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificaci�n.
				return 'OK';
			if (!(parseFloat(get('carCondiEvaluNrFrm.valMaxi','T').toString())>parseFloat(get('carCondiEvaluNrFrm.valMini','T').toString()))) {
				//mensaje de error internacionalizable
				return GestionarMensaje("CarCondiEvaluNr.valMaxivalMini.message");
			}
			else
				return 'OK';
		}
		

//Funci�n ejecutada en el onload de la pagina
function carCondiEvaluNrInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('carCondiEvaluNrFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('carCondiEvaluNrFrm.accion')){
		case "query": carCondiEvaluNrQueryInitComponents(); break;
		case "view": carCondiEvaluNrViewInitComponents(); break;
		case "create": carCondiEvaluNrCreateInitComponents(); break;
		case "update": carCondiEvaluNrUpdateInitComponents(); break;
		case "remove": carCondiEvaluNrRemoveInitComponents(); break;
		case "lov": carCondiEvaluNrLovInitComponents(); break;
	}
	//alert('accion :' + get('carCondiEvaluNrFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('carCondiEvaluNrFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carCondiEvaluNr')) carCondiEvaluNrCmdRequery();
}

function carCondiEvaluNrQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('carCondiEvaluNrFrm', true);	
}

function carCondiEvaluNrViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('carCondiEvaluNrFrm', true);
}

function carCondiEvaluNrCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carCondiEvaluNrFrm.penrOidParaEvalNr','S', GestionarMensaje('CarCondiEvaluNr.penrOidParaEvalNr.requiered.message'));
	
	setMV('carCondiEvaluNrFrm.valMini','S', GestionarMensaje('CarCondiEvaluNr.valMini.requiered.message'));
	
	setMV('carCondiEvaluNrFrm.valEscaMini','S', GestionarMensaje('CarCondiEvaluNr.valEscaMini.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('carCondiEvaluNrFrm', true);
}

function carCondiEvaluNrUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('carCondiEvaluNrFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		carCondiEvaluNrTmpUpdateValues = carCondiEvaluNrBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carCondiEvaluNrFrm.penrOidParaEvalNr','S', GestionarMensaje('CarCondiEvaluNr.penrOidParaEvalNr.requiered.message'));
		setMV('carCondiEvaluNrFrm.valMini','S', GestionarMensaje('CarCondiEvaluNr.valMini.requiered.message'));
		setMV('carCondiEvaluNrFrm.valEscaMini','S', GestionarMensaje('CarCondiEvaluNr.valEscaMini.requiered.message'));
		
			focusFirstFieldModify('carCondiEvaluNrFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('carCondiEvaluNrFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('carCondiEvaluNrFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carCondiEvaluNrRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	carCondiEvaluNrList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('carCondiEvaluNrFrm', true);
}

function carCondiEvaluNrLovInitComponents(){
	carCondiEvaluNrLovReturnParameters = window.dialogArguments;
	
	focusFirstField('carCondiEvaluNrFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function carCondiEvaluNrSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carCondiEvaluNrFrm.' + campo, id);
	set('carCondiEvaluNrFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function carCondiEvaluNrLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carCondiEvaluNrLovReturnParameters.id = '';
	carCondiEvaluNrLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carCondiEvaluNrLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carCondiEvaluNrList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carCondiEvaluNrList.codSeleccionados();
	var descripcion = carCondiEvaluNrList.extraeDato(
		carCondiEvaluNrList.codSeleccionados()[0], carCondiEvaluNrChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carCondiEvaluNrLovReturnParameters.id = codigo;
	carCondiEvaluNrLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function carCondiEvaluNrCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carCondiEvaluNrFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('carCondiEvaluNrFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carCondiEvaluNrList", "CarCondiEvaluNrConectorTransactionQuery", 
		"result_ROWSET", parametros, "carCondiEvaluNrPostQueryActions(datos);"]], "", "");	
}

function carCondiEvaluNrCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carCondiEvaluNrFrm.lastQueryToSession'));
	var i =0;
	set('carCondiEvaluNrFrm.penrOidParaEvalNr', [paramsRequery.ij(i++)]);
	
	set('carCondiEvaluNrFrm.valMini', paramsRequery.ij(i++));
	
	set('carCondiEvaluNrFrm.valMaxi', paramsRequery.ij(i++));
	
	set('carCondiEvaluNrFrm.valEscaMini', paramsRequery.ij(i++));
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	carCondiEvaluNrPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carCondiEvaluNrCmdQuery(carCondiEvaluNrPageCount);
}

function carCondiEvaluNrFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carCondiEvaluNrPageCount = 1;
	carCondiEvaluNrCmdQuery(carCondiEvaluNrPageCount);
}

function carCondiEvaluNrPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carCondiEvaluNrLastQuery){
		carCondiEvaluNrFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carCondiEvaluNrPageCount--;
	carCondiEvaluNrCmdQuery(carCondiEvaluNrPageCount);
}

function carCondiEvaluNrNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != carCondiEvaluNrLastQuery){
		carCondiEvaluNrFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carCondiEvaluNrPageCount++;
	carCondiEvaluNrCmdQuery(carCondiEvaluNrPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carCondiEvaluNrPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carCondiEvaluNrListLayer', 'O');
		visibilidad('carCondiEvaluNrListButtonsLayer', 'O');
		if(get('carCondiEvaluNrFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	carCondiEvaluNrLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:carCondiEvaluNrViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carCondiEvaluNrChoiceColumn) + "</A>",
			i, carCondiEvaluNrChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carCondiEvaluNrList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	carCondiEvaluNrTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		carCondiEvaluNrMorePagesFlag = true;
		carCondiEvaluNrList.eliminar(mmgPageSize, 1);
	}else{
		carCondiEvaluNrMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('carCondiEvaluNrFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carCondiEvaluNrListLayer', 'V');
	visibilidad('carCondiEvaluNrListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carCondiEvaluNrList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carCondiEvaluNrList.display();
	
	//Actualizamos el estado de los botones 
	if(carCondiEvaluNrMorePagesFlag){
		set_estado_botonera('carCondiEvaluNrPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carCondiEvaluNrPaginationButtonBar',
			3,"inactivo");
	}
	if(carCondiEvaluNrPageCount > 1){
		set_estado_botonera('carCondiEvaluNrPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carCondiEvaluNrPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carCondiEvaluNrPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carCondiEvaluNrPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carCondiEvaluNrUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carCondiEvaluNrList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carCondiEvaluNrFrm.idSelection', carCondiEvaluNrList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('carCondiEvaluNrFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = carCondiEvaluNrList.codSeleccionados()[0];
		parametros["previousAction"] = get('carCondiEvaluNrFrm.accion');
		parametros["accion"] = get('carCondiEvaluNrFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CarCondiEvaluNrLPStartUp', get('carCondiEvaluNrFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) carCondiEvaluNrCmdRequery();
	}
}

function carCondiEvaluNrRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carCondiEvaluNrList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carCondiEvaluNrList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carCondiEvaluNrFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carCondiEvaluNrList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carCondiEvaluNrTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carCondiEvaluNrFrm.timestamp', timestamps);


	carCondiEvaluNrFrm.oculto='S';
	envia('carCondiEvaluNrFrm');
	carCondiEvaluNrFrm.oculto='N';
}

function carCondiEvaluNrViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(carCondiEvaluNrList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	carCondiEvaluNrViewDetail(carCondiEvaluNrList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function carCondiEvaluNrViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carCondiEvaluNrFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CarCondiEvaluNrLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('carCondiEvaluNrFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		carCondiEvaluNrFrm.oculto='S';
		envia('carCondiEvaluNrFrm');
		carCondiEvaluNrFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('carCondiEvaluNrFrm.penrOidParaEvalNr').toString() == ''){
		set('carCondiEvaluNrFrm.penrOidParaEvalNr', []);
		mmgResetCombosOnCascade('penrOidParaEvalNr', 'penrOidParaEvalNr', 'carCondiEvaluNr');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	carCondiEvaluNrRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('carCondiEvaluNrFrm.accion');
	var origenTmp = get('carCondiEvaluNrFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carCondiEvaluNrBuildUpdateRecordString() != carCondiEvaluNrTmpUpdateValues){
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
	document.all.carCondiEvaluNrListLayer.style.display='none';
	document.all.carCondiEvaluNrListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carCondiEvaluNrListLayer.style.display='';
	document.all.carCondiEvaluNrListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsCarCondiEvaluNrPenrOidParaEvalNr = get('carCondiEvaluNrFrm.penrOidParaEvalNr')[0];
	jsCarCondiEvaluNrValMini = get('carCondiEvaluNrFrm.valMini').toString();
	jsCarCondiEvaluNrValMaxi = get('carCondiEvaluNrFrm.valMaxi').toString();
	jsCarCondiEvaluNrValEscaMini = get('carCondiEvaluNrFrm.valEscaMini').toString();
	
	
	var parametros = "";
	parametros += jsCarCondiEvaluNrPenrOidParaEvalNr + "|";
	parametros += jsCarCondiEvaluNrValMini + "|";
	parametros += jsCarCondiEvaluNrValMaxi + "|";
	parametros += jsCarCondiEvaluNrValEscaMini + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carCondiEvaluNrBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarCondiEvaluNrPenrOidParaEvalNr + "|";
	parametros += jsCarCondiEvaluNrValMini + "|";
	parametros += jsCarCondiEvaluNrValMaxi + "|";
	parametros += jsCarCondiEvaluNrValEscaMini + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carCondiEvaluNrFrm.accion'), 
		get('carCondiEvaluNrFrm.origen'));
	
	jsCarCondiEvaluNrId = get('carCondiEvaluNrFrm.id').toString();
	jsCarCondiEvaluNrPenrOidParaEvalNr = get('carCondiEvaluNrFrm.penrOidParaEvalNr')[0];
	jsCarCondiEvaluNrValMini = get('carCondiEvaluNrFrm.valMini').toString();
	jsCarCondiEvaluNrValMaxi = get('carCondiEvaluNrFrm.valMaxi').toString();
	jsCarCondiEvaluNrValEscaMini = get('carCondiEvaluNrFrm.valEscaMini').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carCondiEvaluNrFrm.accion'), 
		get('carCondiEvaluNrFrm.origen'));


	set('carCondiEvaluNrFrm.id', jsCarCondiEvaluNrId);
	set('carCondiEvaluNrFrm.penrOidParaEvalNr', [jsCarCondiEvaluNrPenrOidParaEvalNr]);
	set('carCondiEvaluNrFrm.valMini', jsCarCondiEvaluNrValMini);
	set('carCondiEvaluNrFrm.valMaxi', jsCarCondiEvaluNrValMaxi);
	set('carCondiEvaluNrFrm.valEscaMini', jsCarCondiEvaluNrValEscaMini);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsCarCondiEvaluNrPenrOidParaEvalNr = '';
	jsCarCondiEvaluNrValMini = '';
	jsCarCondiEvaluNrValMaxi = '';
	jsCarCondiEvaluNrValEscaMini = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carCondiEvaluNrFrm.errCodigo', errorCode);
	set('carCondiEvaluNrFrm.errDescripcion', description);
	set('carCondiEvaluNrFrm.errSeverity', severity);
	fMostrarMensajeError();
}
