

/*
    INDRA/CAR/mmg
    $Id: calguias.js,v 1.1 2009/12/03 19:01:38 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCalGuiasId = "";
var jsCalGuiasCodGuia = "";
var jsCalGuiasDpteOidDepa = "";
var jsCalGuiasValTitu = "";
var jsCalGuiasFecInicVali = "";
var jsCalGuiasFecFinVali = "";
var jsCalGuiasValDescGuia = "";
var jsCalGuiasPaisOidPais = "";

//Variables de paginacion, 
var calGuiasPageCount = 1;

//Varible de columna que representa el campo de choice
var calGuiasChoiceColumn = 6;

//Flag de siguiente pagina;
var calGuiasMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var calGuiasTimeStamps = null;

//Tama?os del formulario
var sizeFormQuery = 417;
var sizeFormView = 399;
var sizeFormUpdate = 399;

//Ultima busqueda realizada
var calGuiasLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci?n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("calGuiasFrm.codGuia");','focaliza("calGuiasFrm.codGuia");','','focaliza("calGuiasFrm.codGuia");','focaliza("calGuiasFrm.codGuia");',''],[3,'focalizaComboDependence("calGuias","dpteOidDepa", false);','focalizaComboDependence("calGuias","dpteOidDepa", false);','focalizaComboDependence("calGuias","dpteOidDepa", false);','focalizaComboDependence("calGuias","dpteOidDepa", true);','focalizaComboDependence("calGuias","dpteOidDepa", true);','focalizaComboDependence("calGuias","dpteOidDepa", true);'],[4,'focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");'],[5,'focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");'],[6,'focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");'],[7,'focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");'],[8,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificaci?n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci?n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("calGuiasFrm.codGuia");','focaliza("calGuiasFrm.codGuia");','','focaliza("calGuiasFrm.codGuia");','focaliza("calGuiasFrm.codGuia");',''],[3,'focalizaComboDependence("calGuias","dpteOidDepa", false);','focalizaComboDependence("calGuias","dpteOidDepa", false);','focalizaComboDependence("calGuias","dpteOidDepa", false);','focalizaComboDependence("calGuias","dpteOidDepa", true);','focalizaComboDependence("calGuias","dpteOidDepa", true);','focalizaComboDependence("calGuias","dpteOidDepa", true);'],[4,'focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");','focaliza("calGuiasFrm.valTitu");'],[5,'focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");','focaliza("calGuiasFrm.fecInicVali");'],[6,'focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");','focaliza("calGuiasFrm.fecFinVali");'],[7,'focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");','focaliza("calGuiasFrm.valDescGuia");'],[8,'','','','','','']]);

//Creamos la informaci?n de las jerarqu?as de dependencias de combos (si existen)
//Para cada jerarqu?a de dependencia definimos un vector donde se defina la jerar?a
//La definici?n de la jerarqu?a consiste en definir para cada combo de la jerarqu?a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de ?l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar?an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var dpteOidDepaDependeceMap = new Vector();
dpteOidDepaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
dpteOidDepaDependeceMap.agregar(['dpteOidDepa', padresTmp, '', 'SegDeptoEmpre']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b?squeda lov
calGuiasLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est? modifica para chequear
//que no se pierden datos
var calGuiasTmpUpdateValues;


		//funcion para fecFinVali y su validaci?n con fecInicVali
		function validacionfecFinValifecInicVali(){
			if ((get('calGuiasFrm.fecFinVali','T').toString()=="") || 
			(get('calGuiasFrm.fecInicVali','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificaci?n.
				return 'OK';
			
				var errorLevel = EsFechaValida(get('calGuiasFrm.fecInicVali','T') ,get('calGuiasFrm.fecFinVali','T') , "calGuiasFrm", "N");
				
			
			if ( errorLevel == 3){
			     return GestionarMensaje("CalGuias.fecFinValifecInicVali.message");
			}else
			     return 'OK';
		}
		

//Funci?n ejecutada en el onload de la pagina
function calGuiasInitComponents(){
	//Deshabilitamos la limpieza gen?rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men? secundario
	configurarMenuSecundario('calGuiasFrm');
   	 
	 if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
    }

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci?n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci?n a realizar y llama a la funci?n correspondiente
	switch(get('calGuiasFrm.accion')){
		case "query": calGuiasQueryInitComponents(); break;
		case "view": calGuiasViewInitComponents(); break;
		case "create": calGuiasCreateInitComponents(); break;
		case "update": calGuiasUpdateInitComponents(); break;
		case "remove": calGuiasRemoveInitComponents(); break;
		case "lov": calGuiasLovInitComponents(); break;
	}
	//alert('accion :' + get('calGuiasFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('calGuiasFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('calGuias')) calGuiasCmdRequery();
}

function calGuiasQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	focusFirstField('calGuiasFrm', true);	
}

function calGuiasViewInitComponents(){
	//Cargamos la descripci?n en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('calGuiasFrm', true);
}

function calGuiasCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('calGuiasFrm.codGuia','S', GestionarMensaje('CalGuias.codGuia.requiered.message'));
	
	setMV('calGuiasFrm.dpteOidDepa','S', GestionarMensaje('CalGuias.dpteOidDepa.requiered.message'));
	
	setMV('calGuiasFrm.valTitu','S', GestionarMensaje('CalGuias.valTitu.requiered.message'));
	
	setMV('calGuiasFrm.fecInicVali','S', GestionarMensaje('CalGuias.fecInicVali.requiered.message'));
	
	setMV('calGuiasFrm.fecFinVali','S', GestionarMensaje('CalGuias.fecFinVali.requiered.message'));
	
	setMV('calGuiasFrm.valDescGuia','S', GestionarMensaje('CalGuias.valDescGuia.requiered.message'));
	
	

	//Activamos el bot?n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('calGuiasFrm', true);
}

function calGuiasUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b?squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci?n
	if(get('calGuiasFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		calGuiasTmpUpdateValues = calGuiasBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('calGuiasFrm.dpteOidDepa','S', GestionarMensaje('CalGuias.dpteOidDepa.requiered.message'));
		setMV('calGuiasFrm.valTitu','S', GestionarMensaje('CalGuias.valTitu.requiered.message'));
		setMV('calGuiasFrm.fecInicVali','S', GestionarMensaje('CalGuias.fecInicVali.requiered.message'));
		setMV('calGuiasFrm.fecFinVali','S', GestionarMensaje('CalGuias.fecFinVali.requiered.message'));
		setMV('calGuiasFrm.valDescGuia','S', GestionarMensaje('CalGuias.valDescGuia.requiered.message'));
		
			focusFirstFieldModify('calGuiasFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		focusFirstField('calGuiasFrm', true);
	}
	
	//Activamos el bot?n de guardar de la botonera solo si el origen es pagina
	if(get('calGuiasFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function calGuiasRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci?n a la lista de resultados
	calGuiasList.maxSel = -1;
	
	//Desctivamos el bot?n de borra de la botonera. Al realizar la query se activar?;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('calGuiasFrm', true);
}

function calGuiasLovInitComponents(){
	calGuiasLovReturnParameters = window.dialogArguments;
	
	focusFirstField('calGuiasFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad










//Funci?n que permite cargar los datos de un elemento de lov seleccionado
function calGuiasSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('calGuiasFrm.' + campo, id);
	set('calGuiasFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di?logo de lov
function calGuiasLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	calGuiasLovReturnParameters.id = '';
	calGuiasLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function calGuiasLovSelectionAction(){
	//Si no se ha seleccionado ning?n elemento no hacemos nada
	if(calGuiasList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr? que limpiar para s?lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = calGuiasList.codSeleccionados();
	var descripcion = calGuiasList.extraeDato(
		calGuiasList.codSeleccionados()[0], calGuiasChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	calGuiasLovReturnParameters.id = codigo;
	calGuiasLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b?queda por intervalo


//Nos permite ejecutar la b?squeda
function calGuiasCmdQuery(pageNumber){
	//Llamamos a la validaci?n del formualrio. Si la validaci?n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('calGuiasFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci?n
	var parametros = generateQuery();
	
	//A?adimos el pageCount y el pageSize a los par?metros de la b?squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par?metros de la ?ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p?gina anterior)
	set('calGuiasFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "calGuiasList", "CalGuiasConectorTransactionQuery", 
		"result_ROWSET", parametros, "calGuiasPostQueryActions(datos);"]], "", "");	
}

function calGuiasCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la ?ltima b?squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('calGuiasFrm.lastQueryToSession'));
	var i =0;
	set('calGuiasFrm.codGuia', paramsRequery.ij(i++));
	
	set('calGuiasFrm.dpteOidDepa', [paramsRequery.ij(i++)]);
	
	set('calGuiasFrm.valTitu', paramsRequery.ij(i++));
	
	set('calGuiasFrm.fecInicVali', paramsRequery.ij(i++));
	
	set('calGuiasFrm.fecFinVali', paramsRequery.ij(i++));
	
	set('calGuiasFrm.valDescGuia', paramsRequery.ij(i++));
	
	
	
	//Establecemos la p?gina de busqueda como la actual
	calGuiasPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	calGuiasCmdQuery(calGuiasPageCount);
}

function calGuiasFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	calGuiasPageCount = 1;
	calGuiasCmdQuery(calGuiasPageCount);
}

function calGuiasPreviousPage(){
	//Si los par?metros de busqueda han cambiado hacemos una b?squeda de firstpage
	if(generateQuery() != calGuiasLastQuery){
		calGuiasFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	calGuiasPageCount--;
	calGuiasCmdQuery(calGuiasPageCount);
}

function calGuiasNextPage(){
	//Si los par?metros de busqueda han cambiado hacemos una b?squeda de firstpage
	if(generateQuery() != calGuiasLastQuery){
		calGuiasFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	calGuiasPageCount++;
	calGuiasCmdQuery(calGuiasPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function calGuiasPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('calGuiasListLayer', 'O');
		visibilidad('calGuiasListButtonsLayer', 'O');
		if(get('calGuiasFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par?metros de la ?ltima busqueda. (en la variable javascript)
	calGuiasLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci?n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci?n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:calGuiasViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, calGuiasChoiceColumn) + "</A>",
			i, calGuiasChoiceColumn);
	}*/

	//Filtramos el resultado para coger s?lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	calGuiasList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6],'*'));
	
	//La ?ltima fila de datos representa a los timestamps que debemos guardarlos
	calGuiasTimeStamps = datosTmp.filtrar([7],'*');
	
	//SI hay mas paginas reigistramos que es as? e eliminamos el ?ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		calGuiasMorePagesFlag = true;
		calGuiasList.eliminar(mmgPageSize, 1);
	}else{
		calGuiasMorePagesFlag = false;
	}
	
	//Activamos el bot?n de borrar si estamos en la acci?n
	if(get('calGuiasFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('calGuiasListLayer', 'V');
	visibilidad('calGuiasListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('calGuiasList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	calGuiasList.display();
	
	//Actualizamos el estado de los botones 
	if(calGuiasMorePagesFlag){
		set_estado_botonera('calGuiasPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('calGuiasPaginationButtonBar',
			3,"inactivo");
	}
	if(calGuiasPageCount > 1){
		set_estado_botonera('calGuiasPaginationButtonBar',
			2,"activo");
		set_estado_botonera('calGuiasPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('calGuiasPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('calGuiasPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function calGuiasUpdateSelection(){
	//Si no se ha seleccionado ning?n elemento no hacemos nada
	if(calGuiasList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('calGuiasFrm.idSelection', calGuiasList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci?n
	var validacion = ValidaForm('calGuiasFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = calGuiasList.codSeleccionados()[0];
		parametros["previousAction"] = get('calGuiasFrm.accion');
		parametros["accion"] = get('calGuiasFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CalGuiasLPStartUp', get('calGuiasFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) calGuiasCmdRequery();
	}
}

function calGuiasRemoveSelection(){
	//Si no se ha seleccionado ning?n elemento no hacemos nada
	if(calGuiasList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci?n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = calGuiasList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('calGuiasFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(calGuiasList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += calGuiasTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('calGuiasFrm.timestamp', timestamps);


	calGuiasFrm.oculto='S';
	envia('calGuiasFrm');
	calGuiasFrm.oculto='N';
}

function calGuiasViewSelection(){
	//Si no se ha seleccionado ning?n elemento no hacemos nada
	if(calGuiasList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	calGuiasViewDetail(calGuiasList.codSeleccionados()[0]);
}

//Esta funci?n nos permite abrir un dialogo que permite visualiza un registro determianado
function calGuiasViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci?n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('calGuiasFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CalGuiasLPStartUp', 'view', parametros, null, null);
}

//Funci?n ejecutada cuando se pulsa el bot?n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci?n del idioma por defecto
	//intreoducido directamente a trav?s del widget. Esto se pone debio a que la tecla r?pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	// splatas - DBLG500000796 - 10/07/2006
	var valDescGuia = get('calGuiasFrm.valDescGuia');	
	set('calGuiasFrm.valDescGuia', valDescGuia);
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci?n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('calGuiasFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		calGuiasFrm.oculto='S';
		envia('calGuiasFrm');
		calGuiasFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten?a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu?a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('calGuiasFrm.dpteOidDepa').toString() == ''){
		set('calGuiasFrm.dpteOidDepa', []);
		mmgResetCombosOnCascade('dpteOidDepa', 'dpteOidDepa', 'calGuias');
		
	}
	if(get('calGuiasFrm.paisOidPais').toString() == ''){
		set('calGuiasFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'calGuias');
		
	}
	
	
}

//Funci?n que se ejecuta cuando en la botonera se pulsa el bot?n de eliminar
function Borrar(){
	calGuiasRemoveSelection();
}

//Funci?n que se ejecuta cuando en la botonera se pulsa el bot?n de volver
function Volver(){
	var accionTmp = get('calGuiasFrm.accion');
	var origenTmp = get('calGuiasFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr?s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr?s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(calGuiasBuildUpdateRecordString() != calGuiasTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
		window.close();
	}else {
		window.close();
	}
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.calGuiasListLayer.style.display='none';
	document.all.calGuiasListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.calGuiasListLayer.style.display='';
	document.all.calGuiasListButtonsLayer.style.display='';
}

//Esta funci?n genera los parametros de la b?squeda
function generateQuery(){
	//Determinamos los valores para realziar la b?squeda
	jsCalGuiasCodGuia = get('calGuiasFrm.codGuia').toString();
	jsCalGuiasDpteOidDepa = get('calGuiasFrm.dpteOidDepa')[0];
	jsCalGuiasValTitu = get('calGuiasFrm.valTitu').toString();
	jsCalGuiasFecInicVali = get('calGuiasFrm.fecInicVali').toString();
	jsCalGuiasFecFinVali = get('calGuiasFrm.fecFinVali').toString();
	jsCalGuiasValDescGuia = get('calGuiasFrm.valDescGuia').toString();
	
	
	var parametros = "";
	parametros += jsCalGuiasCodGuia + "|";
	parametros += jsCalGuiasDpteOidDepa + "|";
	parametros += jsCalGuiasValTitu + "|";
	parametros += jsCalGuiasFecInicVali + "|";
	parametros += jsCalGuiasFecFinVali + "|";
	parametros += jsCalGuiasValDescGuia + "|";
	
	return parametros;
}

//Esta funci?n nos permite obteber los valore del formulario cuando est? en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function calGuiasBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCalGuiasDpteOidDepa + "|";
	parametros += jsCalGuiasValTitu + "|";
	parametros += jsCalGuiasFecInicVali + "|";
	parametros += jsCalGuiasFecFinVali + "|";
	parametros += jsCalGuiasValDescGuia + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('calGuiasFrm.accion'), 
		get('calGuiasFrm.origen'));
	
	jsCalGuiasId = get('calGuiasFrm.id').toString();
	jsCalGuiasCodGuia = get('calGuiasFrm.codGuia').toString();
	jsCalGuiasDpteOidDepa = get('calGuiasFrm.dpteOidDepa')[0];
	jsCalGuiasValTitu = get('calGuiasFrm.valTitu').toString();
	jsCalGuiasFecInicVali = get('calGuiasFrm.fecInicVali').toString();
	jsCalGuiasFecFinVali = get('calGuiasFrm.fecFinVali').toString();
	jsCalGuiasValDescGuia = get('calGuiasFrm.valDescGuia').toString();
	jsCalGuiasPaisOidPais = get('calGuiasFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('calGuiasFrm.accion'), 
		get('calGuiasFrm.origen'));


	set('calGuiasFrm.id', jsCalGuiasId);
	set('calGuiasFrm.codGuia', jsCalGuiasCodGuia);
	set('calGuiasFrm.dpteOidDepa', [jsCalGuiasDpteOidDepa]);
	set('calGuiasFrm.valTitu', jsCalGuiasValTitu);
	set('calGuiasFrm.fecInicVali', jsCalGuiasFecInicVali);
	set('calGuiasFrm.fecFinVali', jsCalGuiasFecFinVali);
	set('calGuiasFrm.valDescGuia', jsCalGuiasValDescGuia);
	set('calGuiasFrm.paisOidPais', [jsCalGuiasPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b?squeda
	jsCalGuiasCodGuia = '';
	jsCalGuiasDpteOidDepa = '';
	jsCalGuiasValTitu = '';
	jsCalGuiasFecInicVali = '';
	jsCalGuiasFecFinVali = '';
	jsCalGuiasValDescGuia = '';
	
}

//Permite disprar una acci?n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
alert("calGuiasFrm.errCodigo = " + errorCode);

	set('calGuiasFrm.errCodigo', errorCode);
	set('calGuiasFrm.errDescripcion', description);
	set('calGuiasFrm.errSeverity', severity);
	fMostrarMensajeError();
}
