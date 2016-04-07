

/*
    INDRA/CAR/mmg
    $Id: eduplantcursodetal.js,v 1.1 2009/12/03 19:01:33 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsEduPlantCursoDetalId = "";
var jsEduPlantCursoDetalCplcOidCabe = "";
var jsEduPlantCursoDetalValDeta = "";
var jsEduPlantCursoDetalIndVisi = "";
var jsEduPlantCursoDetalIndModi = "";
var jsEduPlantCursoDetalIndObli = "";

//Variables de paginacion, 
var eduPlantCursoDetalPageCount = 1;

//Varible de columna que representa el campo de choice
var eduPlantCursoDetalChoiceColumn = 5;

//Flag de siguiente pagina;
var eduPlantCursoDetalMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var eduPlantCursoDetalTimeStamps = null;

//Tama�os del formulario
var sizeFormQuery = 290;
var sizeFormView = 290;
var sizeFormUpdate = 290;

//Ultima busqueda realizada
var eduPlantCursoDetalLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci�n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("eduPlantCursoDetalFrm.indObli");','focaliza("eduPlantCursoDetalFrm.indObli");','focaliza("eduPlantCursoDetalFrm.indObli");','focaliza("eduPlantCursoDetalFrm.indObli");','focaliza("eduPlantCursoDetalFrm.indObli");','focaliza("eduPlantCursoDetalFrm.indObli");']]);

//Creamos la informaci�n de las jerarqu�as de dependencias de combos (si existen)
//Para cada jerarqu�a de dependencia definimos un vector donde se defina la jerar�a
//La definici�n de la jerarqu� consiste en definir para cada combo de la jerarqu�a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de �l para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar�an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var cplcOidCabeDependeceMap = new Vector();
cplcOidCabeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
cplcOidCabeDependeceMap.agregar(['cplcOidCabe', padresTmp, '', 'EduPlantCursoCabec']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b�squeda lov
eduPlantCursoDetalLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est� modifica para chequear
//que no se pierden datos
var eduPlantCursoDetalTmpUpdateValues;


//Funci�n ejecutada en el onload de la pagina
function eduPlantCursoDetalInitComponents(){
	//Inicalizamos el estado del men� secundario
	configurarMenuSecundario('eduPlantCursoDetalFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci�n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci�n a realizar y llama a la funci�n correspondiente
	switch(get('eduPlantCursoDetalFrm.accion')){
		case "query": eduPlantCursoDetalQueryInitComponents(); break;
		case "view": eduPlantCursoDetalViewInitComponents(); break;
		case "create": eduPlantCursoDetalCreateInitComponents(); break;
		case "update": eduPlantCursoDetalUpdateInitComponents(); break;
		case "remove": eduPlantCursoDetalRemoveInitComponents(); break;
		case "lov": eduPlantCursoDetalLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('eduPlantCursoDetalFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('eduPlantCursoDetal')) eduPlantCursoDetalCmdRequery();
}

function eduPlantCursoDetalQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
}

function eduPlantCursoDetalViewInitComponents(){
	//En principiono se hace nada
}

function eduPlantCursoDetalCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('eduPlantCursoDetalFrm.cplcOidCabe','S', GestionarMensaje('EduPlantCursoDetal.cplcOidCabe.requiered.message'));
	
	setMV('eduPlantCursoDetalFrm.indVisi','S', GestionarMensaje('EduPlantCursoDetal.indVisi.requiered.message'));
	
	setMV('eduPlantCursoDetalFrm.indModi','S', GestionarMensaje('EduPlantCursoDetal.indModi.requiered.message'));
	
	setMV('eduPlantCursoDetalFrm.indObli','S', GestionarMensaje('EduPlantCursoDetal.indObli.requiered.message'));
	
	

	//Activamos el bot�n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function eduPlantCursoDetalUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b�squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci�n
	if(get('eduPlantCursoDetalFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		eduPlantCursoDetalTmpUpdateValues = eduPlantCursoDetalBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('eduPlantCursoDetalFrm.cplcOidCabe','S', GestionarMensaje('EduPlantCursoDetal.cplcOidCabe.requiered.message'));
		
		setMV('eduPlantCursoDetalFrm.indVisi','S', GestionarMensaje('EduPlantCursoDetal.indVisi.requiered.message'));
		
		setMV('eduPlantCursoDetalFrm.indModi','S', GestionarMensaje('EduPlantCursoDetal.indModi.requiered.message'));
		
		setMV('eduPlantCursoDetalFrm.indObli','S', GestionarMensaje('EduPlantCursoDetal.indObli.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
	}
	
	//Activamos el bot�n de guardar de la botonera solo si el origen es pagina
	if(get('eduPlantCursoDetalFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function eduPlantCursoDetalRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci�n a la lista de resultados
	eduPlantCursoDetalList.maxSel = -1;
	
	//Desctivamos el bot�n de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function eduPlantCursoDetalLovInitComponents(){
	eduPlantCursoDetalLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad








//Funci�n que permite cargar los datos de un elemento de lov seleccionado
function eduPlantCursoDetalSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('eduPlantCursoDetalFrm.' + campo, id);
	set('eduPlantCursoDetalFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di�logo de lov
function eduPlantCursoDetalLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	eduPlantCursoDetalLovReturnParameters.id = '';
	eduPlantCursoDetalLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function eduPlantCursoDetalLovSelectionAction(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduPlantCursoDetalList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr� que limpiar para s�lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = eduPlantCursoDetalList.codSeleccionados();
	var descripcion = eduPlantCursoDetalList.extraeDato(
		eduPlantCursoDetalList.codSeleccionados()[0], eduPlantCursoDetalChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	eduPlantCursoDetalLovReturnParameters.id = codigo;
	eduPlantCursoDetalLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b�queda por intervalo


//Nos permite ejecutar la b�squeda
function eduPlantCursoDetalCmdQuery(pageNumber){
	//Llamamos a la validaci�n del formualrio. Si la validaci�n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('eduPlantCursoDetalFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci�n
	var parametros = generateQuery();
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable javascript)
	eduPlantCursoDetalLastQuery = parametros;

	//A�adimos el pageCount y el pageSize a los par�metros de la b�squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par�metros de la �ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p�gina anterior)
	set('eduPlantCursoDetalFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "eduPlantCursoDetalList", "EduPlantCursoDetalConectorTransactionQuery", 
		"result_ROWSET", parametros, "eduPlantCursoDetalPostQueryActions(datos);"]], "", "");	
}

function eduPlantCursoDetalCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la �ltima b�squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('eduPlantCursoDetalFrm.lastQueryToSession'));
	var i =0;
	set('eduPlantCursoDetalFrm.cplcOidCabe', [paramsRequery.ij(i++)]);
	
	set('eduPlantCursoDetalFrm.valDeta', paramsRequery.ij(i++));
	
	set('eduPlantCursoDetalFrm.indVisi', paramsRequery.ij(i++));
	
	set('eduPlantCursoDetalFrm.indModi', paramsRequery.ij(i++));
	
	set('eduPlantCursoDetalFrm.indObli', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parm�metros de la paginaci�n
	eduPlantCursoDetalPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	eduPlantCursoDetalCmdQuery(eduPlantCursoDetalPageCount);
}

function eduPlantCursoDetalFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	eduPlantCursoDetalPageCount = 1;
	eduPlantCursoDetalCmdQuery(eduPlantCursoDetalPageCount);
}

function eduPlantCursoDetalPreviousPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != eduPlantCursoDetalLastQuery){
		eduPlantCursoDetalFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	eduPlantCursoDetalPageCount--;
	eduPlantCursoDetalCmdQuery(eduPlantCursoDetalPageCount);
}

function eduPlantCursoDetalNextPage(){
	//Si los par�metros de busqueda han cambiado hacemos una b�squeda de firstpage
	if(generateQuery() != eduPlantCursoDetalLastQuery){
		eduPlantCursoDetalFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	eduPlantCursoDetalPageCount++;
	eduPlantCursoDetalCmdQuery(eduPlantCursoDetalPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function eduPlantCursoDetalPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('eduPlantCursoDetalListLayer', 'O');
		visibilidad('eduPlantCursoDetalListButtonsLayer', 'O');
		if(get('eduPlantCursoDetalFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:eduPlantCursoDetalViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, eduPlantCursoDetalChoiceColumn) + "</A>",
			i, eduPlantCursoDetalChoiceColumn);
	}*/

	//Filtramos el resultado para coger s�lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	eduPlantCursoDetalList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La �ltima fila de datos representa a los timestamps que debemos guardarlos
	eduPlantCursoDetalTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es as� e eliminamos el �ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		eduPlantCursoDetalMorePagesFlag = true;
		eduPlantCursoDetalList.eliminar(mmgPageSize, 1);
	}else{
		eduPlantCursoDetalMorePagesFlag = false;
	}
	
	//Activamos el bot�n de borrar si estamos en la acci�n
	if(get('eduPlantCursoDetalFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('eduPlantCursoDetalListLayer', 'V');
	visibilidad('eduPlantCursoDetalListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('eduPlantCursoDetalList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	eduPlantCursoDetalList.display();
	
	//Actualizamos el estado de los botones 
	if(eduPlantCursoDetalMorePagesFlag){
		set_estado_botonera('eduPlantCursoDetalPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('eduPlantCursoDetalPaginationButtonBar',
			3,"inactivo");
	}
	if(eduPlantCursoDetalPageCount > 1){
		set_estado_botonera('eduPlantCursoDetalPaginationButtonBar',
			2,"activo");
		set_estado_botonera('eduPlantCursoDetalPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('eduPlantCursoDetalPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('eduPlantCursoDetalPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function eduPlantCursoDetalUpdateSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduPlantCursoDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('eduPlantCursoDetalFrm.idSelection', eduPlantCursoDetalList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci�n
	var validacion = ValidaForm('eduPlantCursoDetalFrm', true);
	if(validacion){
		/*set('eduPlantCursoDetalFrm.previousAction', 'update');
		set('eduPlantCursoDetalFrm.ON', 'EduPlantCursoDetalLPStartUp');
		set('eduPlantCursoDetalFrm.conectorAction', 'EduPlantCursoDetalLPStartUp');
		set('eduPlantCursoDetalFrm.origen', 'pagina');
		envia('eduPlantCursoDetalFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = eduPlantCursoDetalList.codSeleccionados()[0];
		parametros["previousAction"] = get('eduPlantCursoDetalFrm.accion');
		parametros["accion"] = get('eduPlantCursoDetalFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('EduPlantCursoDetalLPStartUp', get('eduPlantCursoDetalFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) eduPlantCursoDetalCmdRequery();
	}
}

function eduPlantCursoDetalRemoveSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduPlantCursoDetalList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci�n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = eduPlantCursoDetalList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('eduPlantCursoDetalFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(eduPlantCursoDetalList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += eduPlantCursoDetalTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('eduPlantCursoDetalFrm.timestamp', timestamps);
	envia('eduPlantCursoDetalFrm');
}

function eduPlantCursoDetalViewSelection(){
	//Si no se ha seleccionado ning�n elemento no hacemos nada
	if(eduPlantCursoDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('eduPlantCursoDetalFrm.previousAction', get('eduPlantCursoDetalFrm.accion'));
	set('eduPlantCursoDetalFrm.accion', 'view');
	set('eduPlantCursoDetalFrm.origen', 'pagina');
	set('eduPlantCursoDetalFrm.ON', 'EduPlantCursoDetalLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('eduPlantCursoDetalFrm.idSelection', eduPlantCursoDetalList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('eduPlantCursoDetalFrm');
	eduPlantCursoDetalViewDetail(eduPlantCursoDetalList.codSeleccionados()[0]);
}

//Esta funci�n nos permite abrir un dialogo que permite visualiza un registro determianado
function eduPlantCursoDetalViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci�n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('eduPlantCursoDetalFrm.accion');
	parametros["accion"] = get('eduPlantCursoDetalFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('EduPlantCursoDetalLPStartUp', get('eduPlantCursoDetalFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('eduPlantCursoDetalFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
		
	
	if(validacion)envia('eduPlantCursoDetalFrm');
}

function Limpiar(){
	//Recuperamos los valores que ten�a el formaulario al cargar la pantalla
	populateJs2Form();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de eliminar
function Borrar(){
	eduPlantCursoDetalRemoveSelection();
}

//Funci�n que se ejecuta cuando en la botonera se pulsa el bot�n de volver
function Volver(){
	var accionTmp = get('eduPlantCursoDetalFrm.accion');
	var origenTmp = get('eduPlantCursoDetalFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr�s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr�s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(eduPlantCursoDetalBuildUpdateRecordString() != eduPlantCursoDetalTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('eduPlantCursoDetalFrm.performRequery', 'true');
		set('eduPlantCursoDetalFrm.accion', 
			get('eduPlantCursoDetalFrm.previousAction'));
		set('eduPlantCursoDetalFrm.origen', 'menu');
		set('eduPlantCursoDetalFrm.ON', 'EduPlantCursoDetalLPStartUp');
		set('eduPlantCursoDetalFrm.conectorAction', 'EduPlantCursoDetalLPStartUp');
		eduPlantCursoDetalFrm.oculto='N';
		envia('eduPlantCursoDetalFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.eduPlantCursoDetalListLayer.style.display='none';
	document.all.eduPlantCursoDetalListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.eduPlantCursoDetalListLayer.style.display='';
	document.all.eduPlantCursoDetalListButtonsLayer.style.display='';
}

//Esta funci�n genera los parametros de la b�squeda
function generateQuery(){
	//Determinamos los valores para realziar la b�squeda

	jsEduPlantCursoDetalCplcOidCabe = get('eduPlantCursoDetalFrm.cplcOidCabe')[0];




	jsEduPlantCursoDetalValDeta = get('eduPlantCursoDetalFrm.valDeta').toString();






	jsEduPlantCursoDetalIndVisi = get('eduPlantCursoDetalFrm.indVisi').toString();






	jsEduPlantCursoDetalIndModi = get('eduPlantCursoDetalFrm.indModi').toString();






	jsEduPlantCursoDetalIndObli = get('eduPlantCursoDetalFrm.indObli').toString();








	var parametros = "";
	parametros += jsEduPlantCursoDetalCplcOidCabe + "|";



	parametros += jsEduPlantCursoDetalValDeta + "|";



	parametros += jsEduPlantCursoDetalIndVisi + "|";



	parametros += jsEduPlantCursoDetalIndModi + "|";



	parametros += jsEduPlantCursoDetalIndObli + "|";




	return parametros;
}

//Esta funci�n nos permite obteber los valore del formulario cuando est� en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function eduPlantCursoDetalBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsEduPlantCursoDetalCplcOidCabe + "|";
	parametros += jsEduPlantCursoDetalValDeta + "|";
	parametros += jsEduPlantCursoDetalIndVisi + "|";
	parametros += jsEduPlantCursoDetalIndModi + "|";
	parametros += jsEduPlantCursoDetalIndObli + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduPlantCursoDetalFrm.accion'), 
		get('eduPlantCursoDetalFrm.origen'));
	
	jsEduPlantCursoDetalId = get('eduPlantCursoDetalFrm.id').toString();
	jsEduPlantCursoDetalCplcOidCabe = get('eduPlantCursoDetalFrm.cplcOidCabe')[0];
	jsEduPlantCursoDetalValDeta = get('eduPlantCursoDetalFrm.valDeta').toString();
	jsEduPlantCursoDetalIndVisi = get('eduPlantCursoDetalFrm.indVisi').toString();
	jsEduPlantCursoDetalIndModi = get('eduPlantCursoDetalFrm.indModi').toString();
	jsEduPlantCursoDetalIndObli = get('eduPlantCursoDetalFrm.indObli').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduPlantCursoDetalFrm.accion'), 
		get('eduPlantCursoDetalFrm.origen'));


	set('eduPlantCursoDetalFrm.id', jsEduPlantCursoDetalId);
	set('eduPlantCursoDetalFrm.cplcOidCabe', [jsEduPlantCursoDetalCplcOidCabe]);
	set('eduPlantCursoDetalFrm.valDeta', jsEduPlantCursoDetalValDeta);
	set('eduPlantCursoDetalFrm.indVisi', jsEduPlantCursoDetalIndVisi);
	set('eduPlantCursoDetalFrm.indModi', jsEduPlantCursoDetalIndModi);
	set('eduPlantCursoDetalFrm.indObli', jsEduPlantCursoDetalIndObli);

}

//Permite disprar una acci�n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('eduPlantCursoDetalFrm.errCodigo', errorCode);
	set('eduPlantCursoDetalFrm.errDescripcion', description);
	set('eduPlantCursoDetalFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
