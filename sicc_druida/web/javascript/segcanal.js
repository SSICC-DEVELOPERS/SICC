

/*
    INDRA/CAR/mmg
    $Id: segcanal.js,v 1.1 2009/12/03 19:02:03 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsSegCanalId = "";
var jsSegCanalCodCana = "";
var jsSegCanalDescripcion = "";
var jsSegCanalTipeOidTipoPeri = "";

//Variables de paginacion, 
var segCanalPageCount = 1;

//Varible de columna que representa el campo de choice
var segCanalChoiceColumn = 1;

//Flag de siguiente pagina;
var segCanalMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var segCanalTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var segCanalLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("segCanalFrm.codCana");','focaliza("segCanalFrm.codCana");','focaliza("segCanalFrm.codCana");','focaliza("segCanalFrm.codCana");','focaliza("segCanalFrm.codCana");','focaliza("segCanalFrm.codCana");'],[3,'focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");'],[4,'focalizaComboDependence("segCanal","tipeOidTipoPeri", false);','focalizaComboDependence("segCanal","tipeOidTipoPeri", false);','focalizaComboDependence("segCanal","tipeOidTipoPeri", false);','focalizaComboDependence("segCanal","tipeOidTipoPeri", true);','focalizaComboDependence("segCanal","tipeOidTipoPeri", true);','focalizaComboDependence("segCanal","tipeOidTipoPeri", true);']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");','focaliza("segCanalFrm.Descripcion");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var tipeOidTipoPeriDependeceMap = new Vector();
tipeOidTipoPeriDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tipeOidTipoPeriDependeceMap.agregar(['tipeOidTipoPeri', padresTmp, '', 'SegTipoPerio']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
segCanalLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var segCanalTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function segCanalInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('segCanalFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('segCanalFrm.accion')){
		case "query": segCanalQueryInitComponents(); break;
		case "view": segCanalViewInitComponents(); break;
		case "create": segCanalCreateInitComponents(); break;
		case "update": segCanalUpdateInitComponents(); break;
		case "remove": segCanalRemoveInitComponents(); break;
		case "lov": segCanalLovInitComponents(); break;
	}
	//alert('accion :' + get('segCanalFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('segCanalFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('segCanal')) segCanalCmdRequery();
}

function segCanalQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('segCanalFrm', true);	
}

function segCanalViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('segCanalFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('segCanalFrm', true);
}

function segCanalCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('segCanalFrm.codCana','S', GestionarMensaje('SegCanal.codCana.requiered.message'));
	
	setMV('segCanalFrm.Descripcion','S', GestionarMensaje('SegCanal.Descripcion.requiered.message'));
	
	setMV('segCanalFrm.tipeOidTipoPeri','S', GestionarMensaje('SegCanal.tipeOidTipoPeri.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('segCanalFrm', true);
}

function segCanalUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('segCanalFrm.origen') == "pagina"){
		loadLocalizationWidget('segCanalFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		segCanalTmpUpdateValues = segCanalBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('segCanalFrm.codCana','S', GestionarMensaje('SegCanal.codCana.requiered.message'));
		setMV('segCanalFrm.Descripcion','S', GestionarMensaje('SegCanal.Descripcion.requiered.message'));
		setMV('segCanalFrm.tipeOidTipoPeri','S', GestionarMensaje('SegCanal.tipeOidTipoPeri.requiered.message'));
		
			focusFirstFieldModify('segCanalFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('segCanalFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('segCanalFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function segCanalRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	segCanalList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('segCanalFrm', true);
}

function segCanalLovInitComponents(){
	segCanalLovReturnParameters = window.dialogArguments;
	
	focusFirstField('segCanalFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function segCanalSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('segCanalFrm.' + campo, id);
	set('segCanalFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function segCanalLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	segCanalLovReturnParameters.id = '';
	segCanalLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function segCanalLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(segCanalList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = segCanalList.codSeleccionados();
	var descripcion = segCanalList.extraeDato(
		segCanalList.codSeleccionados()[0], segCanalChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	segCanalLovReturnParameters.id = codigo;
	segCanalLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function segCanalCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('segCanalFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('segCanalFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "segCanalList", "SegCanalConectorTransactionQuery", 
		"result_ROWSET", parametros, "segCanalPostQueryActions(datos);"]], "", "");	
}

function segCanalCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('segCanalFrm.lastQueryToSession'));
	var i =0;
	set('segCanalFrm.codCana', paramsRequery.ij(i++));
	
	set('segCanalFrm.Descripcion', paramsRequery.ij(i++));
	
	set('segCanalFrm.tipeOidTipoPeri', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	segCanalPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	segCanalCmdQuery(segCanalPageCount);
}

function segCanalFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	segCanalPageCount = 1;
	segCanalCmdQuery(segCanalPageCount);
}

function segCanalPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != segCanalLastQuery){
		segCanalFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	segCanalPageCount--;
	segCanalCmdQuery(segCanalPageCount);
}

function segCanalNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != segCanalLastQuery){
		segCanalFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	segCanalPageCount++;
	segCanalCmdQuery(segCanalPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function segCanalPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('segCanalListLayer', 'O');
		visibilidad('segCanalListButtonsLayer', 'O');
		if(get('segCanalFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	segCanalLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:segCanalViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, segCanalChoiceColumn) + "</A>",
			i, segCanalChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	segCanalList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	segCanalTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		segCanalMorePagesFlag = true;
		segCanalList.eliminar(mmgPageSize, 1);
	}else{
		segCanalMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('segCanalFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('segCanalListLayer', 'V');
	visibilidad('segCanalListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('segCanalList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	segCanalList.display();
	
	//Actualizamos el estado de los botones 
	if(segCanalMorePagesFlag){
		set_estado_botonera('segCanalPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('segCanalPaginationButtonBar',
			3,"inactivo");
	}
	if(segCanalPageCount > 1){
		set_estado_botonera('segCanalPaginationButtonBar',
			2,"activo");
		set_estado_botonera('segCanalPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('segCanalPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('segCanalPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function segCanalUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(segCanalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('segCanalFrm.idSelection', segCanalList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('segCanalFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = segCanalList.codSeleccionados()[0];
		parametros["previousAction"] = get('segCanalFrm.accion');
		parametros["accion"] = get('segCanalFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('SegCanalLPStartUp', get('segCanalFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) segCanalCmdRequery();
	}
}

function segCanalRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(segCanalList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = segCanalList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('segCanalFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(segCanalList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += segCanalTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('segCanalFrm.timestamp', timestamps);


	segCanalFrm.oculto='S';
	envia('segCanalFrm');
	segCanalFrm.oculto='N';
}

function segCanalViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(segCanalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	segCanalViewDetail(segCanalList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function segCanalViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('segCanalFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('SegCanalLPStartUp', 'view', parametros, null, null);
}

//Funci�n ejecutada cuando se pulsa el bot�n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci�n del idioma por defecto
	//intreoducido directamente a trav�s del widget. Esto se pone debio a que la tecla r�pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('segCanalFrm', 
		'Descripcion', 1,
		get('segCanalFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci�n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('segCanalFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('segCanalFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('SegCanal.Descripcion.requiered.message'));
		focaliza('segCanalFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		segCanalFrm.oculto='S';
		envia('segCanalFrm');
		segCanalFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('segCanalFrm.tipeOidTipoPeri').toString() == ''){
		set('segCanalFrm.tipeOidTipoPeri', []);
		mmgResetCombosOnCascade('tipeOidTipoPeri', 'tipeOidTipoPeri', 'segCanal');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	segCanalRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('segCanalFrm.accion');
	var origenTmp = get('segCanalFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(segCanalBuildUpdateRecordString() != segCanalTmpUpdateValues){
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
	document.all.segCanalListLayer.style.display='none';
	document.all.segCanalListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.segCanalListLayer.style.display='';
	document.all.segCanalListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsSegCanalCodCana = get('segCanalFrm.codCana').toString();
	jsSegCanalDescripcion = get('segCanalFrm.Descripcion').toString();
	jsSegCanalTipeOidTipoPeri = get('segCanalFrm.tipeOidTipoPeri')[0];
	
	
	var parametros = "";
	parametros += jsSegCanalCodCana + "|";
	parametros += jsSegCanalDescripcion + "|";
	parametros += jsSegCanalTipeOidTipoPeri + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function segCanalBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsSegCanalCodCana + "|";
	parametros += jsSegCanalDescripcion + "|";
	parametros += jsSegCanalTipeOidTipoPeri + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segCanalFrm.accion'), 
		get('segCanalFrm.origen'));
	
	jsSegCanalId = get('segCanalFrm.id').toString();
	jsSegCanalCodCana = get('segCanalFrm.codCana').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsSegCanalDescripcion = buildLocalizedString('segCanalFrm', 1);
	}else{
		jsSegCanalDescripcion = get('segCanalFrm.Descripcion');
	}
	jsSegCanalTipeOidTipoPeri = get('segCanalFrm.tipeOidTipoPeri')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('segCanalFrm.accion'), 
		get('segCanalFrm.origen'));


	set('segCanalFrm.id', jsSegCanalId);
	set('segCanalFrm.codCana', jsSegCanalCodCana);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('segCanalFrm', 1,  jsSegCanalDescripcion)
		loadLocalizationWidget('segCanalFrm', 'Descripcion', 1);
	}else{
		set('segCanalFrm.Descripcion', jsSegCanalDescripcion);		
	}
	set('segCanalFrm.tipeOidTipoPeri', [jsSegCanalTipeOidTipoPeri]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsSegCanalCodCana = '';
	jsSegCanalDescripcion = '';
	jsSegCanalTipeOidTipoPeri = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('segCanalFrm.errCodigo', errorCode);
	set('segCanalFrm.errDescripcion', description);
	set('segCanalFrm.errSeverity', severity);
	fMostrarMensajeError();
}
