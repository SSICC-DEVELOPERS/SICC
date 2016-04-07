

/*
    INDRA/CAR/mmg
    $Id: cobsubtiaccio.js,v 1.1 2009/12/03 19:01:57 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobSubtiAccioId = "";
var jsCobSubtiAccioCodSubtAcci = "";

//Variables de paginacion, 
var cobSubtiAccioPageCount = 1;

//Varible de columna que representa el campo de choice
var cobSubtiAccioChoiceColumn = 1;

//Flag de siguiente pagina;
var cobSubtiAccioMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobSubtiAccioTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var cobSubtiAccioLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");','focaliza("cobSubtiAccioFrm.codSubtAcci");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
cobSubtiAccioLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var cobSubtiAccioTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function cobSubtiAccioInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('cobSubtiAccioFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('cobSubtiAccioFrm.accion')){
		case "query": cobSubtiAccioQueryInitComponents(); break;
		case "view": cobSubtiAccioViewInitComponents(); break;
		case "create": cobSubtiAccioCreateInitComponents(); break;
		case "update": cobSubtiAccioUpdateInitComponents(); break;
		case "remove": cobSubtiAccioRemoveInitComponents(); break;
		case "lov": cobSubtiAccioLovInitComponents(); break;
	}
	//alert('accion :' + get('cobSubtiAccioFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobSubtiAccioFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobSubtiAccio')) cobSubtiAccioCmdRequery();
}

function cobSubtiAccioQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	focusFirstField('cobSubtiAccioFrm', true);	
}

function cobSubtiAccioViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('cobSubtiAccioFrm', true);
}

function cobSubtiAccioCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobSubtiAccioFrm.codSubtAcci','S', GestionarMensaje('CobSubtiAccio.codSubtAcci.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobSubtiAccioFrm', true);
}

function cobSubtiAccioUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('cobSubtiAccioFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		cobSubtiAccioTmpUpdateValues = cobSubtiAccioBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobSubtiAccioFrm.codSubtAcci','S', GestionarMensaje('CobSubtiAccio.codSubtAcci.requiered.message'));
		
			focusFirstFieldModify('cobSubtiAccioFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		focusFirstField('cobSubtiAccioFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('cobSubtiAccioFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobSubtiAccioRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	cobSubtiAccioList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobSubtiAccioFrm', true);
}

function cobSubtiAccioLovInitComponents(){
	cobSubtiAccioLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobSubtiAccioFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad




//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function cobSubtiAccioSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobSubtiAccioFrm.' + campo, id);
	set('cobSubtiAccioFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function cobSubtiAccioLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobSubtiAccioLovReturnParameters.id = '';
	cobSubtiAccioLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobSubtiAccioLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobSubtiAccioList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobSubtiAccioList.codSeleccionados();
	var descripcion = cobSubtiAccioList.extraeDato(
		cobSubtiAccioList.codSeleccionados()[0], cobSubtiAccioChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobSubtiAccioLovReturnParameters.id = codigo;
	cobSubtiAccioLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function cobSubtiAccioCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobSubtiAccioFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('cobSubtiAccioFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobSubtiAccioList", "CobSubtiAccioConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobSubtiAccioPostQueryActions(datos);"]], "", "");	
}

function cobSubtiAccioCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobSubtiAccioFrm.lastQueryToSession'));
	var i =0;
	set('cobSubtiAccioFrm.codSubtAcci', paramsRequery.ij(i++));
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	cobSubtiAccioPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobSubtiAccioCmdQuery(cobSubtiAccioPageCount);
}

function cobSubtiAccioFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobSubtiAccioPageCount = 1;
	cobSubtiAccioCmdQuery(cobSubtiAccioPageCount);
}

function cobSubtiAccioPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != cobSubtiAccioLastQuery){
		cobSubtiAccioFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobSubtiAccioPageCount--;
	cobSubtiAccioCmdQuery(cobSubtiAccioPageCount);
}

function cobSubtiAccioNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != cobSubtiAccioLastQuery){
		cobSubtiAccioFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobSubtiAccioPageCount++;
	cobSubtiAccioCmdQuery(cobSubtiAccioPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobSubtiAccioPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobSubtiAccioListLayer', 'O');
		visibilidad('cobSubtiAccioListButtonsLayer', 'O');
		if(get('cobSubtiAccioFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	cobSubtiAccioLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobSubtiAccioViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobSubtiAccioChoiceColumn) + "</A>",
			i, cobSubtiAccioChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobSubtiAccioList.setDatos(datosTmp.filtrar([0,1],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	cobSubtiAccioTimeStamps = datosTmp.filtrar([2],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		cobSubtiAccioMorePagesFlag = true;
		cobSubtiAccioList.eliminar(mmgPageSize, 1);
	}else{
		cobSubtiAccioMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('cobSubtiAccioFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobSubtiAccioListLayer', 'V');
	visibilidad('cobSubtiAccioListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobSubtiAccioList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobSubtiAccioList.display();
	
	//Actualizamos el estado de los botones 
	if(cobSubtiAccioMorePagesFlag){
		set_estado_botonera('cobSubtiAccioPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobSubtiAccioPaginationButtonBar',
			3,"inactivo");
	}
	if(cobSubtiAccioPageCount > 1){
		set_estado_botonera('cobSubtiAccioPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobSubtiAccioPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobSubtiAccioPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobSubtiAccioPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobSubtiAccioUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobSubtiAccioList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobSubtiAccioFrm.idSelection', cobSubtiAccioList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('cobSubtiAccioFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobSubtiAccioList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobSubtiAccioFrm.accion');
		parametros["accion"] = get('cobSubtiAccioFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobSubtiAccioLPStartUp', get('cobSubtiAccioFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobSubtiAccioCmdRequery();
	}
}

function cobSubtiAccioRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobSubtiAccioList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobSubtiAccioList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobSubtiAccioFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobSubtiAccioList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobSubtiAccioTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobSubtiAccioFrm.timestamp', timestamps);


	cobSubtiAccioFrm.oculto='S';
	envia('cobSubtiAccioFrm');
	cobSubtiAccioFrm.oculto='N';
}

function cobSubtiAccioViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(cobSubtiAccioList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobSubtiAccioViewDetail(cobSubtiAccioList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function cobSubtiAccioViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobSubtiAccioFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobSubtiAccioLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobSubtiAccioFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
		
	
	if(validacion){
		cobSubtiAccioFrm.oculto='S';
		envia('cobSubtiAccioFrm');
		cobSubtiAccioFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	cobSubtiAccioRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('cobSubtiAccioFrm.accion');
	var origenTmp = get('cobSubtiAccioFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobSubtiAccioBuildUpdateRecordString() != cobSubtiAccioTmpUpdateValues){
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
	document.all.cobSubtiAccioListLayer.style.display='none';
	document.all.cobSubtiAccioListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobSubtiAccioListLayer.style.display='';
	document.all.cobSubtiAccioListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsCobSubtiAccioCodSubtAcci = get('cobSubtiAccioFrm.codSubtAcci').toString();
	
	
	var parametros = "";
	parametros += jsCobSubtiAccioCodSubtAcci + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobSubtiAccioBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobSubtiAccioCodSubtAcci + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobSubtiAccioFrm.accion'), 
		get('cobSubtiAccioFrm.origen'));
	
	jsCobSubtiAccioId = get('cobSubtiAccioFrm.id').toString();
	jsCobSubtiAccioCodSubtAcci = get('cobSubtiAccioFrm.codSubtAcci').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobSubtiAccioFrm.accion'), 
		get('cobSubtiAccioFrm.origen'));


	set('cobSubtiAccioFrm.id', jsCobSubtiAccioId);
	set('cobSubtiAccioFrm.codSubtAcci', jsCobSubtiAccioCodSubtAcci);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsCobSubtiAccioCodSubtAcci = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobSubtiAccioFrm.errCodigo', errorCode);
	set('cobSubtiAccioFrm.errDescripcion', description);
	set('cobSubtiAccioFrm.errSeverity', severity);
	fMostrarMensajeError();
}
