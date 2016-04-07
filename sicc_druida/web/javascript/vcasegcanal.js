

/*
    INDRA/CAR/mmg
    $Id: vcasegcanal.js,v 1.1 2009/12/03 19:01:46 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsVcaSegCanalCodUsua = "";
var jsVcaSegCanalOidCana = "";
var jsVcaSegCanalTipeOidTipoPeri = "";
var jsVcaSegCanalCodCana = "";

//Variables de paginacion, 
var vcaSegCanalPageCount = 1;

//Varible de columna que representa el campo de choice
var vcaSegCanalChoiceColumn = 4;

//Flag de siguiente pagina;
var vcaSegCanalMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var vcaSegCanalTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 220;
var sizeFormView = 220;
var sizeFormUpdate = 220;

//Ultima busqueda realizada
var vcaSegCanalLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("vcaSegCanalFrm.codCana");','focaliza("vcaSegCanalFrm.codCana");','focaliza("vcaSegCanalFrm.codCana");','focaliza("vcaSegCanalFrm.codCana");','focaliza("vcaSegCanalFrm.codCana");','focaliza("vcaSegCanalFrm.codCana");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
vcaSegCanalLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var vcaSegCanalTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function vcaSegCanalInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('vcaSegCanalFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('vcaSegCanalFrm.accion')){
		case "query": vcaSegCanalQueryInitComponents(); break;
		case "view": vcaSegCanalViewInitComponents(); break;
		case "create": vcaSegCanalCreateInitComponents(); break;
		case "update": vcaSegCanalUpdateInitComponents(); break;
		case "remove": vcaSegCanalRemoveInitComponents(); break;
		case "lov": vcaSegCanalLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('vcaSegCanalFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('vcaSegCanal')) vcaSegCanalCmdRequery();
}

function vcaSegCanalQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
}

function vcaSegCanalViewInitComponents(){
	//En principiono se hace nada
}

function vcaSegCanalCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('vcaSegCanalFrm.codUsua','S', GestionarMensaje('VcaSegCanal.codUsua.requiered.message'));
	
	setMV('vcaSegCanalFrm.oidCana','S', GestionarMensaje('VcaSegCanal.oidCana.requiered.message'));
	
	setMV('vcaSegCanalFrm.tipeOidTipoPeri','S', GestionarMensaje('VcaSegCanal.tipeOidTipoPeri.requiered.message'));
	
	setMV('vcaSegCanalFrm.codCana','S', GestionarMensaje('VcaSegCanal.codCana.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function vcaSegCanalUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('vcaSegCanalFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		vcaSegCanalTmpUpdateValues = vcaSegCanalBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('vcaSegCanalFrm.codUsua','S', GestionarMensaje('VcaSegCanal.codUsua.requiered.message'));
		
		setMV('vcaSegCanalFrm.oidCana','S', GestionarMensaje('VcaSegCanal.oidCana.requiered.message'));
		
		setMV('vcaSegCanalFrm.tipeOidTipoPeri','S', GestionarMensaje('VcaSegCanal.tipeOidTipoPeri.requiered.message'));
		
		setMV('vcaSegCanalFrm.codCana','S', GestionarMensaje('VcaSegCanal.codCana.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('vcaSegCanalFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function vcaSegCanalRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	vcaSegCanalList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function vcaSegCanalLovInitComponents(){
	vcaSegCanalLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function vcaSegCanalSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('vcaSegCanalFrm.' + campo, id);
	set('vcaSegCanalFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function vcaSegCanalLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	vcaSegCanalLovReturnParameters.id = '';
	vcaSegCanalLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function vcaSegCanalLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaSegCanalList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = vcaSegCanalList.codSeleccionados();
	var descripcion = vcaSegCanalList.extraeDato(
		vcaSegCanalList.codSeleccionados()[0], vcaSegCanalChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	vcaSegCanalLovReturnParameters.id = codigo;
	vcaSegCanalLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function vcaSegCanalCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('vcaSegCanalFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	vcaSegCanalLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('vcaSegCanalFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "vcaSegCanalList", "VcaSegCanalConectorTransactionQuery", 
		"result_ROWSET", parametros, "vcaSegCanalPostQueryActions(datos);"]], "", "");	
}

function vcaSegCanalCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('vcaSegCanalFrm.lastQueryToSession'));
	var i =0;
	set('vcaSegCanalFrm.codUsua', paramsRequery.ij(i++));
	
	set('vcaSegCanalFrm.oidCana', paramsRequery.ij(i++));
	
	set('vcaSegCanalFrm.tipeOidTipoPeri', paramsRequery.ij(i++));
	
	set('vcaSegCanalFrm.codCana', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	vcaSegCanalPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	vcaSegCanalCmdQuery(vcaSegCanalPageCount);
}

function vcaSegCanalFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	vcaSegCanalPageCount = 1;
	vcaSegCanalCmdQuery(vcaSegCanalPageCount);
}

function vcaSegCanalPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != vcaSegCanalLastQuery){
		vcaSegCanalFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	vcaSegCanalPageCount--;
	vcaSegCanalCmdQuery(vcaSegCanalPageCount);
}

function vcaSegCanalNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != vcaSegCanalLastQuery){
		vcaSegCanalFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	vcaSegCanalPageCount++;
	vcaSegCanalCmdQuery(vcaSegCanalPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function vcaSegCanalPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('vcaSegCanalListLayer', 'O');
		visibilidad('vcaSegCanalListButtonsLayer', 'O');
		if(get('vcaSegCanalFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:vcaSegCanalViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, vcaSegCanalChoiceColumn) + "</A>",
			i, vcaSegCanalChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	vcaSegCanalList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	vcaSegCanalTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		vcaSegCanalMorePagesFlag = true;
		vcaSegCanalList.eliminar(mmgPageSize, 1);
	}else{
		vcaSegCanalMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('vcaSegCanalFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('vcaSegCanalListLayer', 'V');
	visibilidad('vcaSegCanalListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('vcaSegCanalList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	vcaSegCanalList.display();
	
	//Actualizamos el estado de los botones 
	if(vcaSegCanalMorePagesFlag){
		set_estado_botonera('vcaSegCanalPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('vcaSegCanalPaginationButtonBar',
			3,"inactivo");
	}
	if(vcaSegCanalPageCount > 1){
		set_estado_botonera('vcaSegCanalPaginationButtonBar',
			2,"activo");
		set_estado_botonera('vcaSegCanalPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('vcaSegCanalPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('vcaSegCanalPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function vcaSegCanalUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaSegCanalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('vcaSegCanalFrm.idSelection', vcaSegCanalList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('vcaSegCanalFrm', true);
	if(validacion){
		/*set('vcaSegCanalFrm.previousAction', 'update');
		set('vcaSegCanalFrm.ON', 'VcaSegCanalLPStartUp');
		set('vcaSegCanalFrm.conectorAction', 'VcaSegCanalLPStartUp');
		set('vcaSegCanalFrm.origen', 'pagina');
		envia('vcaSegCanalFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = vcaSegCanalList.codSeleccionados()[0];
		parametros["previousAction"] = get('vcaSegCanalFrm.accion');
		parametros["accion"] = get('vcaSegCanalFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('VcaSegCanalLPStartUp', get('vcaSegCanalFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) vcaSegCanalCmdRequery();
	}
}

function vcaSegCanalRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaSegCanalList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = vcaSegCanalList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('vcaSegCanalFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(vcaSegCanalList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += vcaSegCanalTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('vcaSegCanalFrm.timestamp', timestamps);
	envia('vcaSegCanalFrm');
}

function vcaSegCanalViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaSegCanalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('vcaSegCanalFrm.previousAction', get('vcaSegCanalFrm.accion'));
	set('vcaSegCanalFrm.accion', 'view');
	set('vcaSegCanalFrm.origen', 'pagina');
	set('vcaSegCanalFrm.ON', 'VcaSegCanalLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('vcaSegCanalFrm.idSelection', vcaSegCanalList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('vcaSegCanalFrm');
	vcaSegCanalViewDetail(vcaSegCanalList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function vcaSegCanalViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('vcaSegCanalFrm.accion');
	parametros["accion"] = get('vcaSegCanalFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('VcaSegCanalLPStartUp', get('vcaSegCanalFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('vcaSegCanalFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion)envia('vcaSegCanalFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	vcaSegCanalRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('vcaSegCanalFrm.accion');
	var origenTmp = get('vcaSegCanalFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(vcaSegCanalBuildUpdateRecordString() != vcaSegCanalTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('vcaSegCanalFrm.performRequery', 'true');
		set('vcaSegCanalFrm.accion', 
			get('vcaSegCanalFrm.previousAction'));
		set('vcaSegCanalFrm.origen', 'menu');
		set('vcaSegCanalFrm.ON', 'VcaSegCanalLPStartUp');
		set('vcaSegCanalFrm.conectorAction', 'VcaSegCanalLPStartUp');
		vcaSegCanalFrm.oculto='N';
		envia('vcaSegCanalFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.vcaSegCanalListLayer.style.display='none';
	document.all.vcaSegCanalListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.vcaSegCanalListLayer.style.display='';
	document.all.vcaSegCanalListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsVcaSegCanalCodUsua = get('vcaSegCanalFrm.codUsua').toString();






	jsVcaSegCanalOidCana = get('vcaSegCanalFrm.oidCana').toString();






	jsVcaSegCanalTipeOidTipoPeri = get('vcaSegCanalFrm.tipeOidTipoPeri').toString();






	jsVcaSegCanalCodCana = get('vcaSegCanalFrm.codCana').toString();








	var parametros = "";
	parametros += jsVcaSegCanalCodUsua + "|";



	parametros += jsVcaSegCanalOidCana + "|";



	parametros += jsVcaSegCanalTipeOidTipoPeri + "|";



	parametros += jsVcaSegCanalCodCana + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function vcaSegCanalBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsVcaSegCanalCodUsua + "|";
	parametros += jsVcaSegCanalOidCana + "|";
	parametros += jsVcaSegCanalTipeOidTipoPeri + "|";
	parametros += jsVcaSegCanalCodCana + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('vcaSegCanalFrm.accion'), 
		get('vcaSegCanalFrm.origen'));
	
	jsVcaSegCanalCodUsua = get('vcaSegCanalFrm.codUsua').toString();
	jsVcaSegCanalOidCana = get('vcaSegCanalFrm.oidCana').toString();
	jsVcaSegCanalTipeOidTipoPeri = get('vcaSegCanalFrm.tipeOidTipoPeri').toString();
	jsVcaSegCanalCodCana = get('vcaSegCanalFrm.codCana').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('vcaSegCanalFrm.accion'), 
		get('vcaSegCanalFrm.origen'));


	set('vcaSegCanalFrm.codUsua', jsVcaSegCanalCodUsua);
	set('vcaSegCanalFrm.oidCana', jsVcaSegCanalOidCana);
	set('vcaSegCanalFrm.tipeOidTipoPeri', jsVcaSegCanalTipeOidTipoPeri);
	set('vcaSegCanalFrm.codCana', jsVcaSegCanalCodCana);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('vcaSegCanalFrm.errCodigo', errorCode);
	set('vcaSegCanalFrm.errDescripcion', description);
	set('vcaSegCanalFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
