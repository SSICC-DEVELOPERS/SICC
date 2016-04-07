

/*
    INDRA/CAR/mmg
    $Id: eduaptascurso.js,v 1.1 2009/12/03 19:01:35 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsEduAptasCursoId = "";
var jsEduAptasCursoCtsuOidClieTipoSubt = "";
var jsEduAptasCursoMcurOidCurs = "";
var jsEduAptasCursoFecAsis = "";
var jsEduAptasCursoIndAcceDmrt = "";
var jsEduAptasCursoIndAptaCurs = "";
var jsEduAptasCursoIndInvi = "";
var jsEduAptasCursoIndAsis = "";
var jsEduAptasCursoIndPrue = "";

//Variables de paginacion, 
var eduAptasCursoPageCount = 1;

//Varible de columna que representa el campo de choice
var eduAptasCursoChoiceColumn = 8;

//Flag de siguiente pagina;
var eduAptasCursoMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var eduAptasCursoTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 430;
var sizeFormView = 430;
var sizeFormUpdate = 430;

//Ultima busqueda realizada
var eduAptasCursoLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("eduAptasCursoFrm.indPrue");','focaliza("eduAptasCursoFrm.indPrue");','focaliza("eduAptasCursoFrm.indPrue");','focaliza("eduAptasCursoFrm.indPrue");','focaliza("eduAptasCursoFrm.indPrue");','focaliza("eduAptasCursoFrm.indPrue");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var ctsuOidClieTipoSubtDependeceMap = new Vector();
ctsuOidClieTipoSubtDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ctsuOidClieTipoSubtDependeceMap.agregar(['ctsuOidClieTipoSubt', padresTmp, '', 'MaeClienTipoSubti']);
var mcurOidCursDependeceMap = new Vector();
mcurOidCursDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
mcurOidCursDependeceMap.agregar(['mcurOidCurs', padresTmp, '', 'EduMatriCurso']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
eduAptasCursoLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var eduAptasCursoTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function eduAptasCursoInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('eduAptasCursoFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('eduAptasCursoFrm.accion')){
		case "query": eduAptasCursoQueryInitComponents(); break;
		case "view": eduAptasCursoViewInitComponents(); break;
		case "create": eduAptasCursoCreateInitComponents(); break;
		case "update": eduAptasCursoUpdateInitComponents(); break;
		case "remove": eduAptasCursoRemoveInitComponents(); break;
		case "lov": eduAptasCursoLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('eduAptasCursoFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('eduAptasCurso')) eduAptasCursoCmdRequery();
}

function eduAptasCursoQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
}

function eduAptasCursoViewInitComponents(){
	//En principiono se hace nada
}

function eduAptasCursoCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('eduAptasCursoFrm.ctsuOidClieTipoSubt','S', GestionarMensaje('EduAptasCurso.ctsuOidClieTipoSubt.requiered.message'));
	
	setMV('eduAptasCursoFrm.mcurOidCurs','S', GestionarMensaje('EduAptasCurso.mcurOidCurs.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function eduAptasCursoUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('eduAptasCursoFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		eduAptasCursoTmpUpdateValues = eduAptasCursoBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('eduAptasCursoFrm.ctsuOidClieTipoSubt','S', GestionarMensaje('EduAptasCurso.ctsuOidClieTipoSubt.requiered.message'));
		
		setMV('eduAptasCursoFrm.mcurOidCurs','S', GestionarMensaje('EduAptasCurso.mcurOidCurs.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('eduAptasCursoFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function eduAptasCursoRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	eduAptasCursoList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function eduAptasCursoLovInitComponents(){
	eduAptasCursoLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad











//Función que permite cargar los datos de un elemento de lov seleccionado
function eduAptasCursoSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('eduAptasCursoFrm.' + campo, id);
	set('eduAptasCursoFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function eduAptasCursoLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	eduAptasCursoLovReturnParameters.id = '';
	eduAptasCursoLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function eduAptasCursoLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduAptasCursoList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = eduAptasCursoList.codSeleccionados();
	var descripcion = eduAptasCursoList.extraeDato(
		eduAptasCursoList.codSeleccionados()[0], eduAptasCursoChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	eduAptasCursoLovReturnParameters.id = codigo;
	eduAptasCursoLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function eduAptasCursoCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('eduAptasCursoFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	eduAptasCursoLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('eduAptasCursoFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "eduAptasCursoList", "EduAptasCursoConectorTransactionQuery", 
		"result_ROWSET", parametros, "eduAptasCursoPostQueryActions(datos);"]], "", "");	
}

function eduAptasCursoCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('eduAptasCursoFrm.lastQueryToSession'));
	var i =0;
	set('eduAptasCursoFrm.ctsuOidClieTipoSubt', [paramsRequery.ij(i++)]);
	
	set('eduAptasCursoFrm.mcurOidCurs', [paramsRequery.ij(i++)]);
	
	set('eduAptasCursoFrm.fecAsis', paramsRequery.ij(i++));
	
	set('eduAptasCursoFrm.indAcceDmrt', paramsRequery.ij(i++));
	
	set('eduAptasCursoFrm.indAptaCurs', paramsRequery.ij(i++));
	
	set('eduAptasCursoFrm.indInvi', paramsRequery.ij(i++));
	
	set('eduAptasCursoFrm.indAsis', paramsRequery.ij(i++));
	
	set('eduAptasCursoFrm.indPrue', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	eduAptasCursoPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	eduAptasCursoCmdQuery(eduAptasCursoPageCount);
}

function eduAptasCursoFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	eduAptasCursoPageCount = 1;
	eduAptasCursoCmdQuery(eduAptasCursoPageCount);
}

function eduAptasCursoPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != eduAptasCursoLastQuery){
		eduAptasCursoFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	eduAptasCursoPageCount--;
	eduAptasCursoCmdQuery(eduAptasCursoPageCount);
}

function eduAptasCursoNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != eduAptasCursoLastQuery){
		eduAptasCursoFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	eduAptasCursoPageCount++;
	eduAptasCursoCmdQuery(eduAptasCursoPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function eduAptasCursoPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('eduAptasCursoListLayer', 'O');
		visibilidad('eduAptasCursoListButtonsLayer', 'O');
		if(get('eduAptasCursoFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:eduAptasCursoViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, eduAptasCursoChoiceColumn) + "</A>",
			i, eduAptasCursoChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	eduAptasCursoList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	eduAptasCursoTimeStamps = datosTmp.filtrar([9],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		eduAptasCursoMorePagesFlag = true;
		eduAptasCursoList.eliminar(mmgPageSize, 1);
	}else{
		eduAptasCursoMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('eduAptasCursoFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('eduAptasCursoListLayer', 'V');
	visibilidad('eduAptasCursoListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('eduAptasCursoList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	eduAptasCursoList.display();
	
	//Actualizamos el estado de los botones 
	if(eduAptasCursoMorePagesFlag){
		set_estado_botonera('eduAptasCursoPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('eduAptasCursoPaginationButtonBar',
			3,"inactivo");
	}
	if(eduAptasCursoPageCount > 1){
		set_estado_botonera('eduAptasCursoPaginationButtonBar',
			2,"activo");
		set_estado_botonera('eduAptasCursoPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('eduAptasCursoPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('eduAptasCursoPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function eduAptasCursoUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduAptasCursoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('eduAptasCursoFrm.idSelection', eduAptasCursoList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('eduAptasCursoFrm', true);
	if(validacion){
		/*set('eduAptasCursoFrm.previousAction', 'update');
		set('eduAptasCursoFrm.ON', 'EduAptasCursoLPStartUp');
		set('eduAptasCursoFrm.conectorAction', 'EduAptasCursoLPStartUp');
		set('eduAptasCursoFrm.origen', 'pagina');
		envia('eduAptasCursoFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = eduAptasCursoList.codSeleccionados()[0];
		parametros["previousAction"] = get('eduAptasCursoFrm.accion');
		parametros["accion"] = get('eduAptasCursoFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('EduAptasCursoLPStartUp', get('eduAptasCursoFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) eduAptasCursoCmdRequery();
	}
}

function eduAptasCursoRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduAptasCursoList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = eduAptasCursoList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('eduAptasCursoFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(eduAptasCursoList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += eduAptasCursoTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('eduAptasCursoFrm.timestamp', timestamps);
	envia('eduAptasCursoFrm');
}

function eduAptasCursoViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduAptasCursoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('eduAptasCursoFrm.previousAction', get('eduAptasCursoFrm.accion'));
	set('eduAptasCursoFrm.accion', 'view');
	set('eduAptasCursoFrm.origen', 'pagina');
	set('eduAptasCursoFrm.ON', 'EduAptasCursoLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('eduAptasCursoFrm.idSelection', eduAptasCursoList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('eduAptasCursoFrm');
	eduAptasCursoViewDetail(eduAptasCursoList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function eduAptasCursoViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('eduAptasCursoFrm.accion');
	parametros["accion"] = get('eduAptasCursoFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('EduAptasCursoLPStartUp', get('eduAptasCursoFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('eduAptasCursoFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
		
	
	if(validacion)envia('eduAptasCursoFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	eduAptasCursoRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('eduAptasCursoFrm.accion');
	var origenTmp = get('eduAptasCursoFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(eduAptasCursoBuildUpdateRecordString() != eduAptasCursoTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('eduAptasCursoFrm.performRequery', 'true');
		set('eduAptasCursoFrm.accion', 
			get('eduAptasCursoFrm.previousAction'));
		set('eduAptasCursoFrm.origen', 'menu');
		set('eduAptasCursoFrm.ON', 'EduAptasCursoLPStartUp');
		set('eduAptasCursoFrm.conectorAction', 'EduAptasCursoLPStartUp');
		eduAptasCursoFrm.oculto='N';
		envia('eduAptasCursoFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.eduAptasCursoListLayer.style.display='none';
	document.all.eduAptasCursoListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.eduAptasCursoListLayer.style.display='';
	document.all.eduAptasCursoListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsEduAptasCursoCtsuOidClieTipoSubt = get('eduAptasCursoFrm.ctsuOidClieTipoSubt')[0];





	jsEduAptasCursoMcurOidCurs = get('eduAptasCursoFrm.mcurOidCurs')[0];




	jsEduAptasCursoFecAsis = get('eduAptasCursoFrm.fecAsis').toString();






	jsEduAptasCursoIndAcceDmrt = get('eduAptasCursoFrm.indAcceDmrt').toString();






	jsEduAptasCursoIndAptaCurs = get('eduAptasCursoFrm.indAptaCurs').toString();






	jsEduAptasCursoIndInvi = get('eduAptasCursoFrm.indInvi').toString();






	jsEduAptasCursoIndAsis = get('eduAptasCursoFrm.indAsis').toString();






	jsEduAptasCursoIndPrue = get('eduAptasCursoFrm.indPrue').toString();








	var parametros = "";
	parametros += jsEduAptasCursoCtsuOidClieTipoSubt + "|";



	parametros += jsEduAptasCursoMcurOidCurs + "|";



	parametros += jsEduAptasCursoFecAsis + "|";



	parametros += jsEduAptasCursoIndAcceDmrt + "|";



	parametros += jsEduAptasCursoIndAptaCurs + "|";



	parametros += jsEduAptasCursoIndInvi + "|";



	parametros += jsEduAptasCursoIndAsis + "|";



	parametros += jsEduAptasCursoIndPrue + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function eduAptasCursoBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsEduAptasCursoCtsuOidClieTipoSubt + "|";
	parametros += jsEduAptasCursoMcurOidCurs + "|";
	parametros += jsEduAptasCursoFecAsis + "|";
	parametros += jsEduAptasCursoIndAcceDmrt + "|";
	parametros += jsEduAptasCursoIndAptaCurs + "|";
	parametros += jsEduAptasCursoIndInvi + "|";
	parametros += jsEduAptasCursoIndAsis + "|";
	parametros += jsEduAptasCursoIndPrue + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduAptasCursoFrm.accion'), 
		get('eduAptasCursoFrm.origen'));
	
	jsEduAptasCursoId = get('eduAptasCursoFrm.id').toString();
	jsEduAptasCursoCtsuOidClieTipoSubt = get('eduAptasCursoFrm.ctsuOidClieTipoSubt')[0];
	jsEduAptasCursoMcurOidCurs = get('eduAptasCursoFrm.mcurOidCurs')[0];
	jsEduAptasCursoFecAsis = get('eduAptasCursoFrm.fecAsis').toString();
	jsEduAptasCursoIndAcceDmrt = get('eduAptasCursoFrm.indAcceDmrt').toString();
	jsEduAptasCursoIndAptaCurs = get('eduAptasCursoFrm.indAptaCurs').toString();
	jsEduAptasCursoIndInvi = get('eduAptasCursoFrm.indInvi').toString();
	jsEduAptasCursoIndAsis = get('eduAptasCursoFrm.indAsis').toString();
	jsEduAptasCursoIndPrue = get('eduAptasCursoFrm.indPrue').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduAptasCursoFrm.accion'), 
		get('eduAptasCursoFrm.origen'));


	set('eduAptasCursoFrm.id', jsEduAptasCursoId);
	set('eduAptasCursoFrm.ctsuOidClieTipoSubt', [jsEduAptasCursoCtsuOidClieTipoSubt]);
	set('eduAptasCursoFrm.mcurOidCurs', [jsEduAptasCursoMcurOidCurs]);
	set('eduAptasCursoFrm.fecAsis', jsEduAptasCursoFecAsis);
	set('eduAptasCursoFrm.indAcceDmrt', jsEduAptasCursoIndAcceDmrt);
	set('eduAptasCursoFrm.indAptaCurs', jsEduAptasCursoIndAptaCurs);
	set('eduAptasCursoFrm.indInvi', jsEduAptasCursoIndInvi);
	set('eduAptasCursoFrm.indAsis', jsEduAptasCursoIndAsis);
	set('eduAptasCursoFrm.indPrue', jsEduAptasCursoIndPrue);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('eduAptasCursoFrm.errCodigo', errorCode);
	set('eduAptasCursoFrm.errDescripcion', description);
	set('eduAptasCursoFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
