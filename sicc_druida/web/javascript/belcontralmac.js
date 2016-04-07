

/*
    INDRA/CAR/mmg
    $Id: belcontralmac.js,v 1.1 2009/12/03 19:01:52 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsBelContrAlmacId = "";
var jsBelContrAlmacSbacOidSbac = "";
var jsBelContrAlmacProdOidProd = "";
var jsBelContrAlmacAlmcOidAlma = "";
var jsBelContrAlmacValStocMini = "";
var jsBelContrAlmacValStocMaxi = "";
var jsBelContrAlmacValStocRepo = "";
var jsBelContrAlmacIndActi = "";

//Variables de paginacion, 
var belContrAlmacPageCount = 1;

//Varible de columna que representa el campo de choice
var belContrAlmacChoiceColumn = 7;

//Flag de siguiente pagina;
var belContrAlmacMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var belContrAlmacTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 273;
var sizeFormView = 297;
var sizeFormUpdate = 297;

//Ultima busqueda realizada
var belContrAlmacLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("belContrAlmac","sbacOidSbac", false);','focalizaComboDependence("belContrAlmac","sbacOidSbac", false);','focalizaComboDependence("belContrAlmac","sbacOidSbac", false);','focalizaComboDependence("belContrAlmac","sbacOidSbac", true);','focalizaComboDependence("belContrAlmac","sbacOidSbac", true);','focalizaComboDependence("belContrAlmac","sbacOidSbac", true);'],[3,'focalizaComboDependence("belContrAlmac","prodOidProd", false);','focalizaComboDependence("belContrAlmac","prodOidProd", false);','focalizaComboDependence("belContrAlmac","prodOidProd", false);','focalizaComboDependence("belContrAlmac","prodOidProd", true);','focalizaComboDependence("belContrAlmac","prodOidProd", true);','focalizaComboDependence("belContrAlmac","prodOidProd", true);'],[4,'focalizaComboDependence("belContrAlmac","almcOidAlma", false);','focalizaComboDependence("belContrAlmac","almcOidAlma", false);','focalizaComboDependence("belContrAlmac","almcOidAlma", false);','focalizaComboDependence("belContrAlmac","almcOidAlma", true);','focalizaComboDependence("belContrAlmac","almcOidAlma", true);','focalizaComboDependence("belContrAlmac","almcOidAlma", true);'],[5,'focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");'],[6,'focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");'],[7,'focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");'],[8,'','focaliza("belContrAlmacFrm.indActi");','focaliza("belContrAlmacFrm.indActi");','','focaliza("belContrAlmacFrm.indActi");','focaliza("belContrAlmacFrm.indActi");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[5,'focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");','focaliza("belContrAlmacFrm.valStocMini");'],[6,'focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");','focaliza("belContrAlmacFrm.valStocMaxi");'],[7,'focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");','focaliza("belContrAlmacFrm.valStocRepo");'],[8,'','focaliza("belContrAlmacFrm.indActi");','focaliza("belContrAlmacFrm.indActi");','','focaliza("belContrAlmacFrm.indActi");','focaliza("belContrAlmacFrm.indActi");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var sbacOidSbacDependeceMap = new Vector();
sbacOidSbacDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac_acceOidAcce_canaOidCana', padresTmp, 'sbacOidSbac_acceOidAcce', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['sbacOidSbac_acceOidAcce_canaOidCana'])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac_acceOidAcce', padresTmp, 'sbacOidSbac', 'SegAcces']);
padresTmp =  new Vector();
padresTmp.cargar(['sbacOidSbac_acceOidAcce'])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac', padresTmp, '', 'SegSubac']);
var prodOidProdDependeceMap = new Vector();
prodOidProdDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
prodOidProdDependeceMap.agregar(['prodOidProd', padresTmp, '', 'MaeProduView']);
var almcOidAlmaDependeceMap = new Vector();
almcOidAlmaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
almcOidAlmaDependeceMap.agregar(['almcOidAlma', padresTmp, '', 'BelAlmac']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
belContrAlmacLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var belContrAlmacTmpUpdateValues;


		//funcion para valStocMini y su validación con valStocMaxi
		function validacionvalStocMinivalStocMaxi(){
			if ((get('belContrAlmacFrm.valStocMini','T').toString()=="") || 
			(get('belContrAlmacFrm.valStocMaxi','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificación.
				return 'OK';
			if (!(parseFloat(get('belContrAlmacFrm.valStocMini','T').toString())<parseFloat(get('belContrAlmacFrm.valStocMaxi','T').toString()))) {
				//mensaje de error internacionalizable
				return GestionarMensaje("BelContrAlmac.valStocMinivalStocMaxi.message");
			}
			else
				return 'OK';
		}
		
		//funcion para valStocRepo y su validación con valStocMaxi
		function validacionvalStocRepovalStocMaxi(){
			if ((get('belContrAlmacFrm.valStocRepo','T').toString()=="") || 
			(get('belContrAlmacFrm.valStocMaxi','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificación.
				return 'OK';
			if (!(parseFloat(get('belContrAlmacFrm.valStocRepo','T').toString())<=parseFloat(get('belContrAlmacFrm.valStocMaxi','T').toString()))) {
				//mensaje de error internacionalizable
				return GestionarMensaje("BelContrAlmac.valStocRepovalStocMaxi.message");
			}
			else
				return 'OK';
		}
		

//Función ejecutada en el onload de la pagina
function belContrAlmacInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('belContrAlmacFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('belContrAlmacFrm.accion')){
		case "query": belContrAlmacQueryInitComponents(); break;
		case "view": belContrAlmacViewInitComponents(); break;
		case "create": belContrAlmacCreateInitComponents(); break;
		case "update": belContrAlmacUpdateInitComponents(); break;
		case "remove": belContrAlmacRemoveInitComponents(); break;
		case "lov": belContrAlmacLovInitComponents(); break;
	}
	//alert('accion :' + get('belContrAlmacFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('belContrAlmacFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('belContrAlmac')) belContrAlmacCmdRequery();
}

function belContrAlmacQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	focusFirstField('belContrAlmacFrm', true);	
}

function belContrAlmacViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('belContrAlmacFrm', true);
}

function belContrAlmacCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('belContrAlmacFrm.sbacOidSbac','S', GestionarMensaje('BelContrAlmac.sbacOidSbac.requiered.message'));
	
	setMV('belContrAlmacFrm.prodOidProd','S', GestionarMensaje('BelContrAlmac.prodOidProd.requiered.message'));
	
	setMV('belContrAlmacFrm.almcOidAlma','S', GestionarMensaje('BelContrAlmac.almcOidAlma.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('belContrAlmacFrm', true);
}

function belContrAlmacUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('belContrAlmacFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		belContrAlmacTmpUpdateValues = belContrAlmacBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('belContrAlmacFrm.sbacOidSbac','S', GestionarMensaje('BelContrAlmac.sbacOidSbac.requiered.message'));
		setMV('belContrAlmacFrm.prodOidProd','S', GestionarMensaje('BelContrAlmac.prodOidProd.requiered.message'));
		setMV('belContrAlmacFrm.almcOidAlma','S', GestionarMensaje('BelContrAlmac.almcOidAlma.requiered.message'));
		
			focusFirstFieldModify('belContrAlmacFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		focusFirstField('belContrAlmacFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('belContrAlmacFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function belContrAlmacRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	belContrAlmacList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('belContrAlmacFrm', true);
}

function belContrAlmacLovInitComponents(){
	belContrAlmacLovReturnParameters = window.dialogArguments;
	
	focusFirstField('belContrAlmacFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad










//Función que permite cargar los datos de un elemento de lov seleccionado
function belContrAlmacSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('belContrAlmacFrm.' + campo, id);
	set('belContrAlmacFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function belContrAlmacLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	belContrAlmacLovReturnParameters.id = '';
	belContrAlmacLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function belContrAlmacLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belContrAlmacList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = belContrAlmacList.codSeleccionados();
	var descripcion = belContrAlmacList.extraeDato(
		belContrAlmacList.codSeleccionados()[0], belContrAlmacChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	belContrAlmacLovReturnParameters.id = codigo;
	belContrAlmacLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function belContrAlmacCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('belContrAlmacFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('belContrAlmacFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "belContrAlmacList", "BelContrAlmacConectorTransactionQuery", 
		"result_ROWSET", parametros, "belContrAlmacPostQueryActions(datos);"]], "", "");	
}

function belContrAlmacCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('belContrAlmacFrm.lastQueryToSession'));
	var i =0;
	set('belContrAlmacFrm.sbacOidSbac', [paramsRequery.ij(i++)]);
	
	set('belContrAlmacFrm.prodOidProd', [paramsRequery.ij(i++)]);
	
	set('belContrAlmacFrm.almcOidAlma', [paramsRequery.ij(i++)]);
	
	set('belContrAlmacFrm.valStocMini', paramsRequery.ij(i++));
	
	set('belContrAlmacFrm.valStocMaxi', paramsRequery.ij(i++));
	
	set('belContrAlmacFrm.valStocRepo', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	belContrAlmacPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	belContrAlmacCmdQuery(belContrAlmacPageCount);
}

function belContrAlmacFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	belContrAlmacPageCount = 1;
	belContrAlmacCmdQuery(belContrAlmacPageCount);
}

function belContrAlmacPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belContrAlmacLastQuery){
		belContrAlmacFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	belContrAlmacPageCount--;
	belContrAlmacCmdQuery(belContrAlmacPageCount);
}

function belContrAlmacNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belContrAlmacLastQuery){
		belContrAlmacFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	belContrAlmacPageCount++;
	belContrAlmacCmdQuery(belContrAlmacPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function belContrAlmacPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('belContrAlmacListLayer', 'O');
		visibilidad('belContrAlmacListButtonsLayer', 'O');
		if(get('belContrAlmacFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	belContrAlmacLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 7)){
			case 'A': datosTmp.ij2(GestionarMensaje('BelContrAlmac.indActi.A.value'), i, 7); break;
			case 'I': datosTmp.ij2(GestionarMensaje('BelContrAlmac.indActi.I.value'), i, 7); break;
			default: datosTmp .ij2('', i, 7);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:belContrAlmacViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, belContrAlmacChoiceColumn) + "</A>",
			i, belContrAlmacChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	belContrAlmacList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	belContrAlmacTimeStamps = datosTmp.filtrar([8],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		belContrAlmacMorePagesFlag = true;
		belContrAlmacList.eliminar(mmgPageSize, 1);
	}else{
		belContrAlmacMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('belContrAlmacFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('belContrAlmacListLayer', 'V');
	visibilidad('belContrAlmacListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('belContrAlmacList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	belContrAlmacList.display();
	
	//Actualizamos el estado de los botones 
	if(belContrAlmacMorePagesFlag){
		set_estado_botonera('belContrAlmacPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('belContrAlmacPaginationButtonBar',
			3,"inactivo");
	}
	if(belContrAlmacPageCount > 1){
		set_estado_botonera('belContrAlmacPaginationButtonBar',
			2,"activo");
		set_estado_botonera('belContrAlmacPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('belContrAlmacPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('belContrAlmacPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function belContrAlmacUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belContrAlmacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('belContrAlmacFrm.idSelection', belContrAlmacList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('belContrAlmacFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = belContrAlmacList.codSeleccionados()[0];
		parametros["previousAction"] = get('belContrAlmacFrm.accion');
		parametros["accion"] = get('belContrAlmacFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('BelContrAlmacLPStartUp', get('belContrAlmacFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) belContrAlmacCmdRequery();
	}
}

function belContrAlmacRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belContrAlmacList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = belContrAlmacList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('belContrAlmacFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(belContrAlmacList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += belContrAlmacTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('belContrAlmacFrm.timestamp', timestamps);


	belContrAlmacFrm.oculto='S';
	envia('belContrAlmacFrm');
	belContrAlmacFrm.oculto='N';
}

function belContrAlmacViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belContrAlmacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	belContrAlmacViewDetail(belContrAlmacList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function belContrAlmacViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('belContrAlmacFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('BelContrAlmacLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('belContrAlmacFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		belContrAlmacFrm.oculto='S';
		envia('belContrAlmacFrm');
		belContrAlmacFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('belContrAlmacFrm.sbacOidSbac').toString() == ''){
		set('belContrAlmacFrm.sbacOidSbac_acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac', 'belContrAlmac');
		
	}
	if(get('belContrAlmacFrm.prodOidProd').toString() == ''){
		set('belContrAlmacFrm.prodOidProd', []);
		mmgResetCombosOnCascade('prodOidProd', 'prodOidProd', 'belContrAlmac');
		
	}
	if(get('belContrAlmacFrm.almcOidAlma').toString() == ''){
		set('belContrAlmacFrm.almcOidAlma', []);
		mmgResetCombosOnCascade('almcOidAlma', 'almcOidAlma', 'belContrAlmac');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	belContrAlmacRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('belContrAlmacFrm.accion');
	var origenTmp = get('belContrAlmacFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(belContrAlmacBuildUpdateRecordString() != belContrAlmacTmpUpdateValues){
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
	document.all.belContrAlmacListLayer.style.display='none';
	document.all.belContrAlmacListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.belContrAlmacListLayer.style.display='';
	document.all.belContrAlmacListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsBelContrAlmacSbacOidSbac = get('belContrAlmacFrm.sbacOidSbac')[0];
	jsBelContrAlmacProdOidProd = get('belContrAlmacFrm.prodOidProd')[0];
	jsBelContrAlmacAlmcOidAlma = get('belContrAlmacFrm.almcOidAlma')[0];
	jsBelContrAlmacValStocMini = get('belContrAlmacFrm.valStocMini').toString();
	jsBelContrAlmacValStocMaxi = get('belContrAlmacFrm.valStocMaxi').toString();
	jsBelContrAlmacValStocRepo = get('belContrAlmacFrm.valStocRepo').toString();
	
	
	var parametros = "";
	parametros += jsBelContrAlmacSbacOidSbac + "|";
	parametros += jsBelContrAlmacProdOidProd + "|";
	parametros += jsBelContrAlmacAlmcOidAlma + "|";
	parametros += jsBelContrAlmacValStocMini + "|";
	parametros += jsBelContrAlmacValStocMaxi + "|";
	parametros += jsBelContrAlmacValStocRepo + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function belContrAlmacBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsBelContrAlmacSbacOidSbac + "|";
	parametros += jsBelContrAlmacProdOidProd + "|";
	parametros += jsBelContrAlmacAlmcOidAlma + "|";
	parametros += jsBelContrAlmacValStocMini + "|";
	parametros += jsBelContrAlmacValStocMaxi + "|";
	parametros += jsBelContrAlmacValStocRepo + "|";
	parametros += jsBelContrAlmacIndActi + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belContrAlmacFrm.accion'), 
		get('belContrAlmacFrm.origen'));
	
	jsBelContrAlmacId = get('belContrAlmacFrm.id').toString();
	jsBelContrAlmacSbacOidSbac = get('belContrAlmacFrm.sbacOidSbac')[0];
	jsBelContrAlmacProdOidProd = get('belContrAlmacFrm.prodOidProd')[0];
	jsBelContrAlmacAlmcOidAlma = get('belContrAlmacFrm.almcOidAlma')[0];
	jsBelContrAlmacValStocMini = get('belContrAlmacFrm.valStocMini').toString();
	jsBelContrAlmacValStocMaxi = get('belContrAlmacFrm.valStocMaxi').toString();
	jsBelContrAlmacValStocRepo = get('belContrAlmacFrm.valStocRepo').toString();
	jsBelContrAlmacIndActi = get('belContrAlmacFrm.indActi')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belContrAlmacFrm.accion'), 
		get('belContrAlmacFrm.origen'));


	set('belContrAlmacFrm.id', jsBelContrAlmacId);
	set('belContrAlmacFrm.sbacOidSbac', [jsBelContrAlmacSbacOidSbac]);
	set('belContrAlmacFrm.prodOidProd', [jsBelContrAlmacProdOidProd]);
	set('belContrAlmacFrm.almcOidAlma', [jsBelContrAlmacAlmcOidAlma]);
	set('belContrAlmacFrm.valStocMini', jsBelContrAlmacValStocMini);
	set('belContrAlmacFrm.valStocMaxi', jsBelContrAlmacValStocMaxi);
	set('belContrAlmacFrm.valStocRepo', jsBelContrAlmacValStocRepo);
	set('belContrAlmacFrm.indActi', [jsBelContrAlmacIndActi]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsBelContrAlmacSbacOidSbac = '';
	jsBelContrAlmacProdOidProd = '';
	jsBelContrAlmacAlmcOidAlma = '';
	jsBelContrAlmacValStocMini = '';
	jsBelContrAlmacValStocMaxi = '';
	jsBelContrAlmacValStocRepo = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('belContrAlmacFrm.errCodigo', errorCode);
	set('belContrAlmacFrm.errDescripcion', description);
	set('belContrAlmacFrm.errSeverity', severity);
	fMostrarMensajeError();
}
