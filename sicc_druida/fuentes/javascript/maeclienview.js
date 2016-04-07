

/*
    INDRA/CAR/mmg
    $Id: maeclienview.js,v 1.1 2009/12/03 19:02:10 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeClienViewId = "";
var jsMaeClienViewCodClie = "";
var jsMaeClienViewPaisOidPais = "";
var jsMaeClienViewIndFichInsc = "";
var jsMaeClienViewCodDigiCtrl = "";
var jsMaeClienViewValApe1 = "";
var jsMaeClienViewValApe2 = "";
var jsMaeClienViewValNom1 = "";
var jsMaeClienViewValNom2 = "";
var jsMaeClienViewValTrat = "";
var jsMaeClienViewValCritBus1 = "";
var jsMaeClienViewValCritBus2 = "";
var jsMaeClienViewCodSexo = "";
var jsMaeClienViewFecIngr = "";
var jsMaeClienViewValApelCasa = "";

//Variables de paginacion, 
var maeClienViewPageCount = 1;

//Varible de columna que representa el campo de choice
var maeClienViewChoiceColumn = 0;

//Flag de siguiente pagina;
var maeClienViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeClienViewTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 651;
var sizeFormView = 633;
var sizeFormUpdate = 633;

//Ultima busqueda realizada
var maeClienViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");']]);

//Vector con acciones de foco para la pantalla de modificaci�n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");','focaliza("maeClienViewFrm.valApelCasa");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu�a consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
maeClienViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var maeClienViewTmpUpdateValues;



//Funci�n ejecutada en el onload de la pagina
function maeClienViewInitComponents(){
	//Deshabilitamos la limpieza gen�rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('maeClienViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('maeClienViewFrm.accion')){
		case "query": maeClienViewQueryInitComponents(); break;
		case "view": maeClienViewViewInitComponents(); break;
		case "create": maeClienViewCreateInitComponents(); break;
		case "update": maeClienViewUpdateInitComponents(); break;
		case "remove": maeClienViewRemoveInitComponents(); break;
		case "lov": maeClienViewLovInitComponents(); break;
	}
	//alert('accion :' + get('maeClienViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeClienViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeClienView')) maeClienViewCmdRequery();
}

function maeClienViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('maeClienViewFrm', true);	
}

function maeClienViewViewInitComponents(){
	//Cargamos la descripci�n en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('maeClienViewFrm', true);
}

function maeClienViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeClienViewFrm.codClie','S', GestionarMensaje('MaeClienView.codClie.requiered.message'));
	
	setMV('maeClienViewFrm.paisOidPais','S', GestionarMensaje('MaeClienView.paisOidPais.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeClienViewFrm', true);
}

function maeClienViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('maeClienViewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		maeClienViewTmpUpdateValues = maeClienViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeClienViewFrm.codClie','S', GestionarMensaje('MaeClienView.codClie.requiered.message'));
		setMV('maeClienViewFrm.paisOidPais','S', GestionarMensaje('MaeClienView.paisOidPais.requiered.message'));
		
			focusFirstFieldModify('maeClienViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('maeClienViewFrm', true);
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('maeClienViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeClienViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	maeClienViewList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera. Al realizar la query se activar�;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeClienViewFrm', true);
}

function maeClienViewLovInitComponents(){
	maeClienViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeClienViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad

















//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function maeClienViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeClienViewFrm.' + campo, id);
	set('maeClienViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function maeClienViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeClienViewLovReturnParameters.id = '';
	maeClienViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeClienViewLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(maeClienViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeClienViewList.codSeleccionados();
	var descripcion = maeClienViewList.extraeDato(
		maeClienViewList.codSeleccionados()[0], maeClienViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeClienViewLovReturnParameters.id = codigo;
	maeClienViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function maeClienViewCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeClienViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('maeClienViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeClienViewList", "MaeClienViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeClienViewPostQueryActions(datos);"]], "", "");	
}

function maeClienViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeClienViewFrm.lastQueryToSession'));
	var i =0;
	set('maeClienViewFrm.codClie', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('maeClienViewFrm.indFichInsc', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.codDigiCtrl', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.valApe1', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.valApe2', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.valNom1', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.valNom2', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.valTrat', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.valCritBus1', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.valCritBus2', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.codSexo', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.fecIngr', paramsRequery.ij(i++));
	
	set('maeClienViewFrm.valApelCasa', paramsRequery.ij(i++));
	
	
	
	//Establecemos la p�gina de busqueda como la actual
	maeClienViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeClienViewCmdQuery(maeClienViewPageCount);
}

function maeClienViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeClienViewPageCount = 1;
	maeClienViewCmdQuery(maeClienViewPageCount);
}

function maeClienViewPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != maeClienViewLastQuery){
		maeClienViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeClienViewPageCount--;
	maeClienViewCmdQuery(maeClienViewPageCount);
}

function maeClienViewNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != maeClienViewLastQuery){
		maeClienViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeClienViewPageCount++;
	maeClienViewCmdQuery(maeClienViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeClienViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeClienViewListLayer', 'O');
		visibilidad('maeClienViewListButtonsLayer', 'O');
		if(get('maeClienViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	maeClienViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci�n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci�n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeClienViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeClienViewChoiceColumn) + "</A>",
			i, maeClienViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeClienViewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	maeClienViewTimeStamps = datosTmp.filtrar([15],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		maeClienViewMorePagesFlag = true;
		maeClienViewList.eliminar(mmgPageSize, 1);
	}else{
		maeClienViewMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('maeClienViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeClienViewListLayer', 'V');
	visibilidad('maeClienViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeClienViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeClienViewList.display();
	
	//Actualizamos el estado de los botones 
	if(maeClienViewMorePagesFlag){
		set_estado_botonera('maeClienViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeClienViewPaginationButtonBar',
			3,"inactivo");
	}
	if(maeClienViewPageCount > 1){
		set_estado_botonera('maeClienViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeClienViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeClienViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeClienViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeClienViewUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(maeClienViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeClienViewFrm.idSelection', maeClienViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('maeClienViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeClienViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeClienViewFrm.accion');
		parametros["accion"] = get('maeClienViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeClienViewLPStartUp', get('maeClienViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeClienViewCmdRequery();
	}
}

function maeClienViewRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(maeClienViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeClienViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeClienViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeClienViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeClienViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeClienViewFrm.timestamp', timestamps);


	maeClienViewFrm.oculto='S';
	envia('maeClienViewFrm');
	maeClienViewFrm.oculto='N';
}

function maeClienViewViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(maeClienViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeClienViewViewDetail(maeClienViewList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function maeClienViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeClienViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeClienViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('maeClienViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		maeClienViewFrm.oculto='S';
		envia('maeClienViewFrm');
		maeClienViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu�a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeClienViewFrm.paisOidPais').toString() == ''){
		set('maeClienViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeClienView');
		
	}
	
	
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	maeClienViewRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('maeClienViewFrm.accion');
	var origenTmp = get('maeClienViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeClienViewBuildUpdateRecordString() != maeClienViewTmpUpdateValues){
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
	document.all.maeClienViewListLayer.style.display='none';
	document.all.maeClienViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeClienViewListLayer.style.display='';
	document.all.maeClienViewListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda
	jsMaeClienViewCodClie = get('maeClienViewFrm.codClie').toString();
	jsMaeClienViewPaisOidPais = get('maeClienViewFrm.paisOidPais')[0];
	jsMaeClienViewIndFichInsc = get('maeClienViewFrm.indFichInsc').toString();
	jsMaeClienViewCodDigiCtrl = get('maeClienViewFrm.codDigiCtrl').toString();
	jsMaeClienViewValApe1 = get('maeClienViewFrm.valApe1').toString();
	jsMaeClienViewValApe2 = get('maeClienViewFrm.valApe2').toString();
	jsMaeClienViewValNom1 = get('maeClienViewFrm.valNom1').toString();
	jsMaeClienViewValNom2 = get('maeClienViewFrm.valNom2').toString();
	jsMaeClienViewValTrat = get('maeClienViewFrm.valTrat').toString();
	jsMaeClienViewValCritBus1 = get('maeClienViewFrm.valCritBus1').toString();
	jsMaeClienViewValCritBus2 = get('maeClienViewFrm.valCritBus2').toString();
	jsMaeClienViewCodSexo = get('maeClienViewFrm.codSexo').toString();
	jsMaeClienViewFecIngr = get('maeClienViewFrm.fecIngr').toString();
	jsMaeClienViewValApelCasa = get('maeClienViewFrm.valApelCasa').toString();
	
	
	var parametros = "";
	parametros += jsMaeClienViewCodClie + "|";
	parametros += jsMaeClienViewPaisOidPais + "|";
	parametros += jsMaeClienViewIndFichInsc + "|";
	parametros += jsMaeClienViewCodDigiCtrl + "|";
	parametros += jsMaeClienViewValApe1 + "|";
	parametros += jsMaeClienViewValApe2 + "|";
	parametros += jsMaeClienViewValNom1 + "|";
	parametros += jsMaeClienViewValNom2 + "|";
	parametros += jsMaeClienViewValTrat + "|";
	parametros += jsMaeClienViewValCritBus1 + "|";
	parametros += jsMaeClienViewValCritBus2 + "|";
	parametros += jsMaeClienViewCodSexo + "|";
	parametros += jsMaeClienViewFecIngr + "|";
	parametros += jsMaeClienViewValApelCasa + "|";
	
	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeClienViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeClienViewCodClie + "|";
	parametros += jsMaeClienViewPaisOidPais + "|";
	parametros += jsMaeClienViewIndFichInsc + "|";
	parametros += jsMaeClienViewCodDigiCtrl + "|";
	parametros += jsMaeClienViewValApe1 + "|";
	parametros += jsMaeClienViewValApe2 + "|";
	parametros += jsMaeClienViewValNom1 + "|";
	parametros += jsMaeClienViewValNom2 + "|";
	parametros += jsMaeClienViewValTrat + "|";
	parametros += jsMaeClienViewValCritBus1 + "|";
	parametros += jsMaeClienViewValCritBus2 + "|";
	parametros += jsMaeClienViewCodSexo + "|";
	parametros += jsMaeClienViewFecIngr + "|";
	parametros += jsMaeClienViewValApelCasa + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienViewFrm.accion'), 
		get('maeClienViewFrm.origen'));
	
	jsMaeClienViewId = get('maeClienViewFrm.id').toString();
	jsMaeClienViewCodClie = get('maeClienViewFrm.codClie').toString();
	jsMaeClienViewPaisOidPais = get('maeClienViewFrm.paisOidPais')[0];
	jsMaeClienViewIndFichInsc = get('maeClienViewFrm.indFichInsc').toString();
	jsMaeClienViewCodDigiCtrl = get('maeClienViewFrm.codDigiCtrl').toString();
	jsMaeClienViewValApe1 = get('maeClienViewFrm.valApe1').toString();
	jsMaeClienViewValApe2 = get('maeClienViewFrm.valApe2').toString();
	jsMaeClienViewValNom1 = get('maeClienViewFrm.valNom1').toString();
	jsMaeClienViewValNom2 = get('maeClienViewFrm.valNom2').toString();
	jsMaeClienViewValTrat = get('maeClienViewFrm.valTrat').toString();
	jsMaeClienViewValCritBus1 = get('maeClienViewFrm.valCritBus1').toString();
	jsMaeClienViewValCritBus2 = get('maeClienViewFrm.valCritBus2').toString();
	jsMaeClienViewCodSexo = get('maeClienViewFrm.codSexo').toString();
	jsMaeClienViewFecIngr = get('maeClienViewFrm.fecIngr').toString();
	jsMaeClienViewValApelCasa = get('maeClienViewFrm.valApelCasa').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeClienViewFrm.accion'), 
		get('maeClienViewFrm.origen'));


	set('maeClienViewFrm.id', jsMaeClienViewId);
	set('maeClienViewFrm.codClie', jsMaeClienViewCodClie);
	set('maeClienViewFrm.paisOidPais', [jsMaeClienViewPaisOidPais]);
	set('maeClienViewFrm.indFichInsc', jsMaeClienViewIndFichInsc);
	set('maeClienViewFrm.codDigiCtrl', jsMaeClienViewCodDigiCtrl);
	set('maeClienViewFrm.valApe1', jsMaeClienViewValApe1);
	set('maeClienViewFrm.valApe2', jsMaeClienViewValApe2);
	set('maeClienViewFrm.valNom1', jsMaeClienViewValNom1);
	set('maeClienViewFrm.valNom2', jsMaeClienViewValNom2);
	set('maeClienViewFrm.valTrat', jsMaeClienViewValTrat);
	set('maeClienViewFrm.valCritBus1', jsMaeClienViewValCritBus1);
	set('maeClienViewFrm.valCritBus2', jsMaeClienViewValCritBus2);
	set('maeClienViewFrm.codSexo', jsMaeClienViewCodSexo);
	set('maeClienViewFrm.fecIngr', jsMaeClienViewFecIngr);
	set('maeClienViewFrm.valApelCasa', jsMaeClienViewValApelCasa);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b�squeda
	jsMaeClienViewCodClie = '';
	jsMaeClienViewPaisOidPais = '';
	jsMaeClienViewIndFichInsc = '';
	jsMaeClienViewCodDigiCtrl = '';
	jsMaeClienViewValApe1 = '';
	jsMaeClienViewValApe2 = '';
	jsMaeClienViewValNom1 = '';
	jsMaeClienViewValNom2 = '';
	jsMaeClienViewValTrat = '';
	jsMaeClienViewValCritBus1 = '';
	jsMaeClienViewValCritBus2 = '';
	jsMaeClienViewCodSexo = '';
	jsMaeClienViewFecIngr = '';
	jsMaeClienViewValApelCasa = '';
	
}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeClienViewFrm.errCodigo', errorCode);
	set('maeClienViewFrm.errDescripcion', description);
	set('maeClienViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
