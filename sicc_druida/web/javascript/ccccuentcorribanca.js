

/*
    INDRA/CAR/mmg
    $Id: ccccuentcorribanca.js,v 1.1 2009/12/03 19:01:33 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCccCuentCorriBancaId = "";
var jsCccCuentCorriBancaCodCc = "";
var jsCccCuentCorriBancaSociOidSoci = "";
var jsCccCuentCorriBancaDesCc = "";
var jsCccCuentCorriBancaCucoOidCcTeso = "";
var jsCccCuentCorriBancaCucoOidCcPnte = "";
var jsCccCuentCorriBancaCodCcBanc = "";
var jsCccCuentCorriBancaSucuOidSucu = "";
var jsCccCuentCorriBancaValNumeSwif = "";
var jsCccCuentCorriBancaValDire = "";
var jsCccCuentCorriBancaValCont = "";
var jsCccCuentCorriBancaValTele = "";
var jsCccCuentCorriBancaValObse = "";
var jsCccCuentCorriBancaPaisOidPais = "";

//Variables de paginacion, 
var cccCuentCorriBancaPageCount = 1;

//Varible de columna que representa el campo de choice
var cccCuentCorriBancaChoiceColumn = 7;

//Flag de siguiente pagina;
var cccCuentCorriBancaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cccCuentCorriBancaTimeStamps = null;

//Tama?os del formulario
var sizeFormQuery = 273;
var sizeFormView = 417;
var sizeFormUpdate = 417;

//Ultima busqueda realizada
var cccCuentCorriBancaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci?n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cccCuentCorriBancaFrm.codCc");','focaliza("cccCuentCorriBancaFrm.codCc");','focaliza("cccCuentCorriBancaFrm.codCc");','focaliza("cccCuentCorriBancaFrm.codCc");','focaliza("cccCuentCorriBancaFrm.codCc");','focaliza("cccCuentCorriBancaFrm.codCc");'],[3,'focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", true);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", true);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", true);'],[4,'focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");'],[5,'focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", true);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", true);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", true);'],[6,'focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", true);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", true);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", true);'],[7,'focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");'],[8,'focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", false);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", false);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", false);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", true);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", true);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", true);'],[9,'','focaliza("cccCuentCorriBancaFrm.valNumeSwif");','focaliza("cccCuentCorriBancaFrm.valNumeSwif");','','focaliza("cccCuentCorriBancaFrm.valNumeSwif");','focaliza("cccCuentCorriBancaFrm.valNumeSwif");'],[10,'','focaliza("cccCuentCorriBancaFrm.valDire");','focaliza("cccCuentCorriBancaFrm.valDire");','','focaliza("cccCuentCorriBancaFrm.valDire");','focaliza("cccCuentCorriBancaFrm.valDire");'],[11,'','focaliza("cccCuentCorriBancaFrm.valCont");','focaliza("cccCuentCorriBancaFrm.valCont");','','focaliza("cccCuentCorriBancaFrm.valCont");','focaliza("cccCuentCorriBancaFrm.valCont");'],[12,'','focaliza("cccCuentCorriBancaFrm.valTele");','focaliza("cccCuentCorriBancaFrm.valTele");','','focaliza("cccCuentCorriBancaFrm.valTele");','focaliza("cccCuentCorriBancaFrm.valTele");'],[13,'','focaliza("cccCuentCorriBancaFrm.valObse");','focaliza("cccCuentCorriBancaFrm.valObse");','','focaliza("cccCuentCorriBancaFrm.valObse");','focaliza("cccCuentCorriBancaFrm.valObse");'],[14,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificaci?n.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acci?n a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", false);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", true);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", true);','focalizaComboDependence("cccCuentCorriBanca","sociOidSoci", true);'],[4,'focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");','focaliza("cccCuentCorriBancaFrm.desCc");'],[5,'focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", true);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", true);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcTeso", true);'],[6,'focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", false);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", true);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", true);','focalizaComboDependence("cccCuentCorriBanca","cucoOidCcPnte", true);'],[7,'focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");','focaliza("cccCuentCorriBancaFrm.codCcBanc");'],[8,'focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", false);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", false);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", false);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", true);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", true);','focalizaComboDependence("cccCuentCorriBanca","sucuOidSucu", true);'],[9,'','focaliza("cccCuentCorriBancaFrm.valNumeSwif");','focaliza("cccCuentCorriBancaFrm.valNumeSwif");','','focaliza("cccCuentCorriBancaFrm.valNumeSwif");','focaliza("cccCuentCorriBancaFrm.valNumeSwif");'],[10,'','focaliza("cccCuentCorriBancaFrm.valDire");','focaliza("cccCuentCorriBancaFrm.valDire");','','focaliza("cccCuentCorriBancaFrm.valDire");','focaliza("cccCuentCorriBancaFrm.valDire");'],[11,'','focaliza("cccCuentCorriBancaFrm.valCont");','focaliza("cccCuentCorriBancaFrm.valCont");','','focaliza("cccCuentCorriBancaFrm.valCont");','focaliza("cccCuentCorriBancaFrm.valCont");'],[12,'','focaliza("cccCuentCorriBancaFrm.valTele");','focaliza("cccCuentCorriBancaFrm.valTele");','','focaliza("cccCuentCorriBancaFrm.valTele");','focaliza("cccCuentCorriBancaFrm.valTele");'],[13,'','focaliza("cccCuentCorriBancaFrm.valObse");','focaliza("cccCuentCorriBancaFrm.valObse");','','focaliza("cccCuentCorriBancaFrm.valObse");','focaliza("cccCuentCorriBancaFrm.valObse");'],[14,'','','','','','']]);

//Creamos la informaci?n de las jerarqu?as de dependencias de combos (si existen)
//Para cada jerarqu?a de dependencia definimos un vector donde se defina la jerar?a
//La definici?n de la jerarqu?a consiste en definir para cada combo de la jerarqu?a cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de ?l para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedar?an [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var sociOidSociDependeceMap = new Vector();
sociOidSociDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sociOidSociDependeceMap.agregar(['sociOidSoci', padresTmp, '', 'SegSocie']);
var cucoOidCcTesoDependeceMap = new Vector();
cucoOidCcTesoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
cucoOidCcTesoDependeceMap.agregar(['cucoOidCcTeso', padresTmp, '', 'CccCuentConta']);
var cucoOidCcPnteDependeceMap = new Vector();
cucoOidCcPnteDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
cucoOidCcPnteDependeceMap.agregar(['cucoOidCcPnte', padresTmp, '', 'CccCuentConta']);
var sucuOidSucuDependeceMap = new Vector();
sucuOidSucuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sucuOidSucuDependeceMap.agregar(['sucuOidSucu_cbanOidBanc', padresTmp, 'sucuOidSucu', 'CccBanco']);
padresTmp =  new Vector();
padresTmp.cargar(['sucuOidSucu_cbanOidBanc'])
sucuOidSucuDependeceMap.agregar(['sucuOidSucu', padresTmp, '', 'CccSucur']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una b?squeda lov
cccCuentCorriBancaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se est? modifica para chequear
//que no se pierden datos
var cccCuentCorriBancaTmpUpdateValues;



//Funci?n ejecutada en el onload de la pagina
function cccCuentCorriBancaInitComponents(){
	//Deshabilitamos la limpieza gen?rica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del men? secundario
	configurarMenuSecundario('cccCuentCorriBancaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operaci?n de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acci?n a realizar y llama a la funci?n correspondiente
	switch(get('cccCuentCorriBancaFrm.accion')){
		case "query": cccCuentCorriBancaQueryInitComponents(); break;
		case "view": cccCuentCorriBancaViewInitComponents(); break;
		case "create": cccCuentCorriBancaCreateInitComponents(); break;
		case "update": cccCuentCorriBancaUpdateInitComponents(); break;
		case "remove": cccCuentCorriBancaRemoveInitComponents(); break;
		case "lov": cccCuentCorriBancaLovInitComponents(); break;
	}
	//alert('accion :' + get('cccCuentCorriBancaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cccCuentCorriBancaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cccCuentCorriBanca')) cccCuentCorriBancaCmdRequery();
}

function cccCuentCorriBancaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	focusFirstField('cccCuentCorriBancaFrm', true);	
}

function cccCuentCorriBancaViewInitComponents(){
	//Cargamos la descripci?n en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('cccCuentCorriBancaFrm', true);
}

function cccCuentCorriBancaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cccCuentCorriBancaFrm.codCc','S', GestionarMensaje('CccCuentCorriBanca.codCc.requiered.message'));
	
	setMV('cccCuentCorriBancaFrm.sociOidSoci','S', GestionarMensaje('CccCuentCorriBanca.sociOidSoci.requiered.message'));
	
	setMV('cccCuentCorriBancaFrm.desCc','S', GestionarMensaje('CccCuentCorriBanca.desCc.requiered.message'));
	
	setMV('cccCuentCorriBancaFrm.cucoOidCcTeso','S', GestionarMensaje('CccCuentCorriBanca.cucoOidCcTeso.requiered.message'));
	
	setMV('cccCuentCorriBancaFrm.cucoOidCcPnte','S', GestionarMensaje('CccCuentCorriBanca.cucoOidCcPnte.requiered.message'));
	
	setMV('cccCuentCorriBancaFrm.codCcBanc','S', GestionarMensaje('CccCuentCorriBanca.codCcBanc.requiered.message'));
	
	setMV('cccCuentCorriBancaFrm.sucuOidSucu','S', GestionarMensaje('CccCuentCorriBanca.sucuOidSucu.requiered.message'));
	
	

	//Activamos el bot?n de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cccCuentCorriBancaFrm', true);
}

function cccCuentCorriBancaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de b?squeda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificaci?n
	if(get('cccCuentCorriBancaFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		cccCuentCorriBancaTmpUpdateValues = cccCuentCorriBancaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cccCuentCorriBancaFrm.codCc','S', GestionarMensaje('CccCuentCorriBanca.codCc.requiered.message'));
		setMV('cccCuentCorriBancaFrm.sociOidSoci','S', GestionarMensaje('CccCuentCorriBanca.sociOidSoci.requiered.message'));
		setMV('cccCuentCorriBancaFrm.desCc','S', GestionarMensaje('CccCuentCorriBanca.desCc.requiered.message'));
		setMV('cccCuentCorriBancaFrm.cucoOidCcTeso','S', GestionarMensaje('CccCuentCorriBanca.cucoOidCcTeso.requiered.message'));
		setMV('cccCuentCorriBancaFrm.cucoOidCcPnte','S', GestionarMensaje('CccCuentCorriBanca.cucoOidCcPnte.requiered.message'));
		setMV('cccCuentCorriBancaFrm.codCcBanc','S', GestionarMensaje('CccCuentCorriBanca.codCcBanc.requiered.message'));
		setMV('cccCuentCorriBancaFrm.sucuOidSucu','S', GestionarMensaje('CccCuentCorriBanca.sucuOidSucu.requiered.message'));
		
			focusFirstFieldModify('cccCuentCorriBancaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		focusFirstField('cccCuentCorriBancaFrm', true);
	}
	
	//Activamos el bot?n de guardar de la botonera solo si el origen es pagina
	if(get('cccCuentCorriBancaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cccCuentCorriBancaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselecci?n a la lista de resultados
	cccCuentCorriBancaList.maxSel = -1;
	
	//Desctivamos el bot?n de borra de la botonera. Al realizar la query se activar?;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cccCuentCorriBancaFrm', true);
}

function cccCuentCorriBancaLovInitComponents(){
	cccCuentCorriBancaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cccCuentCorriBancaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad
















//Funci?n que permite cargar los datos de un elemento de lov seleccionado
function cccCuentCorriBancaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cccCuentCorriBancaFrm.' + campo, id);
	set('cccCuentCorriBancaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en di?logo de lov
function cccCuentCorriBancaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cccCuentCorriBancaLovReturnParameters.id = '';
	cccCuentCorriBancaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cccCuentCorriBancaLovSelectionAction(){
	//Si no se ha seleccionado ning?n elemento no hacemos nada
	if(cccCuentCorriBancaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habr? que limpiar para s?lo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cccCuentCorriBancaList.codSeleccionados();
	var descripcion = cccCuentCorriBancaList.extraeDato(
		cccCuentCorriBancaList.codSeleccionados()[0], cccCuentCorriBancaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cccCuentCorriBancaLovReturnParameters.id = codigo;
	cccCuentCorriBancaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con b?queda por intervalo


//Nos permite ejecutar la b?squeda
function cccCuentCorriBancaCmdQuery(pageNumber){
	//Llamamos a la validaci?n del formualrio. Si la validaci?n no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cccCuentCorriBancaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la funci?n
	var parametros = generateQuery();
	
	//A?adimos el pageCount y el pageSize a los par?metros de la b?squeda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los par?metros de la ?ltima busqueda. (en la variable del formulario para el tema
	//de volver a la p?gina anterior)
	set('cccCuentCorriBancaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cccCuentCorriBancaList", "CccCuentCorriBancaConectorTransactionQuery", 
		"result_ROWSET", parametros, "cccCuentCorriBancaPostQueryActions(datos);"]], "", "");	
}

function cccCuentCorriBancaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la ?ltima b?squeda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cccCuentCorriBancaFrm.lastQueryToSession'));
	var i =0;
	set('cccCuentCorriBancaFrm.codCc', paramsRequery.ij(i++));
	
	set('cccCuentCorriBancaFrm.sociOidSoci', [paramsRequery.ij(i++)]);
	
	set('cccCuentCorriBancaFrm.desCc', paramsRequery.ij(i++));
	
	set('cccCuentCorriBancaFrm.cucoOidCcTeso', [paramsRequery.ij(i++)]);
	
	set('cccCuentCorriBancaFrm.cucoOidCcPnte', [paramsRequery.ij(i++)]);
	
	set('cccCuentCorriBancaFrm.codCcBanc', paramsRequery.ij(i++));
	
	set('cccCuentCorriBancaFrm.sucuOidSucu', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la p?gina de busqueda como la actual
	cccCuentCorriBancaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cccCuentCorriBancaCmdQuery(cccCuentCorriBancaPageCount);
}

function cccCuentCorriBancaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cccCuentCorriBancaPageCount = 1;
	cccCuentCorriBancaCmdQuery(cccCuentCorriBancaPageCount);
}

function cccCuentCorriBancaPreviousPage(){
	//Si los par?metros de busqueda han cambiado hacemos una b?squeda de firstpage
	if(generateQuery() != cccCuentCorriBancaLastQuery){
		cccCuentCorriBancaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cccCuentCorriBancaPageCount--;
	cccCuentCorriBancaCmdQuery(cccCuentCorriBancaPageCount);
}

function cccCuentCorriBancaNextPage(){
	//Si los par?metros de busqueda han cambiado hacemos una b?squeda de firstpage
	if(generateQuery() != cccCuentCorriBancaLastQuery){
		cccCuentCorriBancaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cccCuentCorriBancaPageCount++;
	cccCuentCorriBancaCmdQuery(cccCuentCorriBancaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cccCuentCorriBancaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cccCuentCorriBancaListLayer', 'O');
		visibilidad('cccCuentCorriBancaListButtonsLayer', 'O');
		if(get('cccCuentCorriBancaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los par?metros de la ?ltima busqueda. (en la variable javascript)
	cccCuentCorriBancaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripci?n en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminaci?n)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cccCuentCorriBancaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cccCuentCorriBancaChoiceColumn) + "</A>",
			i, cccCuentCorriBancaChoiceColumn);
	}*/

	//Filtramos el resultado para coger s?lo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cccCuentCorriBancaList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7],'*'));
	
	//La ?ltima fila de datos representa a los timestamps que debemos guardarlos
	cccCuentCorriBancaTimeStamps = datosTmp.filtrar([8],'*');
	
	//SI hay mas paginas reigistramos que es as? e eliminamos el ?ltimo registro
	if(datosTmp.longitud > mmgPageSize){
		cccCuentCorriBancaMorePagesFlag = true;
		cccCuentCorriBancaList.eliminar(mmgPageSize, 1);
	}else{
		cccCuentCorriBancaMorePagesFlag = false;
	}
	
	//Activamos el bot?n de borrar si estamos en la acci?n
	if(get('cccCuentCorriBancaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cccCuentCorriBancaListLayer', 'V');
	visibilidad('cccCuentCorriBancaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cccCuentCorriBancaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cccCuentCorriBancaList.display();
	
	//Actualizamos el estado de los botones 
	if(cccCuentCorriBancaMorePagesFlag){
		set_estado_botonera('cccCuentCorriBancaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cccCuentCorriBancaPaginationButtonBar',
			3,"inactivo");
	}
	if(cccCuentCorriBancaPageCount > 1){
		set_estado_botonera('cccCuentCorriBancaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cccCuentCorriBancaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cccCuentCorriBancaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cccCuentCorriBancaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cccCuentCorriBancaUpdateSelection(){
	//Si no se ha seleccionado ning?n elemento no hacemos nada
	if(cccCuentCorriBancaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cccCuentCorriBancaFrm.idSelection', cccCuentCorriBancaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificaci?n
	var validacion = ValidaForm('cccCuentCorriBancaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cccCuentCorriBancaList.codSeleccionados()[0];
		parametros["previousAction"] = get('cccCuentCorriBancaFrm.accion');
		parametros["accion"] = get('cccCuentCorriBancaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CccCuentCorriBancaLPStartUp', get('cccCuentCorriBancaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cccCuentCorriBancaCmdRequery();
	}
}

function cccCuentCorriBancaRemoveSelection(){
	//Si no se ha seleccionado ning?n elemento no hacemos nada
	if(cccCuentCorriBancaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmaci?n para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cccCuentCorriBancaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cccCuentCorriBancaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cccCuentCorriBancaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cccCuentCorriBancaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cccCuentCorriBancaFrm.timestamp', timestamps);


	cccCuentCorriBancaFrm.oculto='S';
	envia('cccCuentCorriBancaFrm');
	cccCuentCorriBancaFrm.oculto='N';
}

function cccCuentCorriBancaViewSelection(){
	//Si no se ha seleccionado ning?n elemento no hacemos nada
	if(cccCuentCorriBancaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cccCuentCorriBancaViewDetail(cccCuentCorriBancaList.codSeleccionados()[0]);
}

//Esta funci?n nos permite abrir un dialogo que permite visualiza un registro determianado
function cccCuentCorriBancaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acci?n, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cccCuentCorriBancaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CccCuentCorriBancaLPStartUp', 'view', parametros, null, null);
}

//Funci?n ejecutada cuando se pulsa el bot?n de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripci?n del idioma por defecto
	//intreoducido directamente a trav?s del widget. Esto se pone debio a que la tecla r?pida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	// splatas - 20/07/2006 - DBLG500000869
	var observaciones = get("cccCuentCorriBancaFrm.valObse");
	set("cccCuentCorriBancaFrm.valObse", observaciones);
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validaci?n los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('cccCuentCorriBancaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		cccCuentCorriBancaFrm.oculto='S';
		envia('cccCuentCorriBancaFrm');
		cccCuentCorriBancaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que ten?a el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarqu?a de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cccCuentCorriBancaFrm.sociOidSoci').toString() == ''){
		set('cccCuentCorriBancaFrm.sociOidSoci', []);
		mmgResetCombosOnCascade('sociOidSoci', 'sociOidSoci', 'cccCuentCorriBanca');
		
	}
	if(get('cccCuentCorriBancaFrm.cucoOidCcTeso').toString() == ''){
		set('cccCuentCorriBancaFrm.cucoOidCcTeso', []);
		mmgResetCombosOnCascade('cucoOidCcTeso', 'cucoOidCcTeso', 'cccCuentCorriBanca');
		
	}
	if(get('cccCuentCorriBancaFrm.cucoOidCcPnte').toString() == ''){
		set('cccCuentCorriBancaFrm.cucoOidCcPnte', []);
		mmgResetCombosOnCascade('cucoOidCcPnte', 'cucoOidCcPnte', 'cccCuentCorriBanca');
		
	}
	if(get('cccCuentCorriBancaFrm.sucuOidSucu').toString() == ''){
		set('cccCuentCorriBancaFrm.sucuOidSucu_cbanOidBanc', []);
		mmgResetCombosOnCascade('sucuOidSucu_cbanOidBanc', 'sucuOidSucu', 'cccCuentCorriBanca');
		
	}
	if(get('cccCuentCorriBancaFrm.paisOidPais').toString() == ''){
		set('cccCuentCorriBancaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'cccCuentCorriBanca');
		
	}
	
	
}

//Funci?n que se ejecuta cuando en la botonera se pulsa el bot?n de eliminar
function Borrar(){
	cccCuentCorriBancaRemoveSelection();
}

//Funci?n que se ejecuta cuando en la botonera se pulsa el bot?n de volver
function Volver(){
	var accionTmp = get('cccCuentCorriBancaFrm.accion');
	var origenTmp = get('cccCuentCorriBancaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atr?s significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atr?s
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cccCuentCorriBancaBuildUpdateRecordString() != cccCuentCorriBancaTmpUpdateValues){
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
	document.all.cccCuentCorriBancaListLayer.style.display='none';
	document.all.cccCuentCorriBancaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cccCuentCorriBancaListLayer.style.display='';
	document.all.cccCuentCorriBancaListButtonsLayer.style.display='';
}

//Esta funci?n genera los parametros de la b?squeda
function generateQuery(){
	//Determinamos los valores para realziar la b?squeda
	jsCccCuentCorriBancaCodCc = get('cccCuentCorriBancaFrm.codCc').toString();
	jsCccCuentCorriBancaSociOidSoci = get('cccCuentCorriBancaFrm.sociOidSoci')[0];
	jsCccCuentCorriBancaDesCc = get('cccCuentCorriBancaFrm.desCc').toString();
	jsCccCuentCorriBancaCucoOidCcTeso = get('cccCuentCorriBancaFrm.cucoOidCcTeso')[0];
	jsCccCuentCorriBancaCucoOidCcPnte = get('cccCuentCorriBancaFrm.cucoOidCcPnte')[0];
	jsCccCuentCorriBancaCodCcBanc = get('cccCuentCorriBancaFrm.codCcBanc').toString();
	jsCccCuentCorriBancaSucuOidSucu = get('cccCuentCorriBancaFrm.sucuOidSucu')[0];
	
	
	var parametros = "";
	parametros += jsCccCuentCorriBancaCodCc + "|";
	parametros += jsCccCuentCorriBancaSociOidSoci + "|";
	parametros += jsCccCuentCorriBancaDesCc + "|";
	parametros += jsCccCuentCorriBancaCucoOidCcTeso + "|";
	parametros += jsCccCuentCorriBancaCucoOidCcPnte + "|";
	parametros += jsCccCuentCorriBancaCodCcBanc + "|";
	parametros += jsCccCuentCorriBancaSucuOidSucu + "|";
	
	return parametros;
}

//Esta funci?n nos permite obteber los valore del formulario cuando est? en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cccCuentCorriBancaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCccCuentCorriBancaCodCc + "|";
	parametros += jsCccCuentCorriBancaSociOidSoci + "|";
	parametros += jsCccCuentCorriBancaDesCc + "|";
	parametros += jsCccCuentCorriBancaCucoOidCcTeso + "|";
	parametros += jsCccCuentCorriBancaCucoOidCcPnte + "|";
	parametros += jsCccCuentCorriBancaCodCcBanc + "|";
	parametros += jsCccCuentCorriBancaSucuOidSucu + "|";
	parametros += jsCccCuentCorriBancaValNumeSwif + "|";
	parametros += jsCccCuentCorriBancaValDire + "|";
	parametros += jsCccCuentCorriBancaValCont + "|";
	parametros += jsCccCuentCorriBancaValTele + "|";
	parametros += jsCccCuentCorriBancaValObse + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccCuentCorriBancaFrm.accion'), 
		get('cccCuentCorriBancaFrm.origen'));
	
	jsCccCuentCorriBancaId = get('cccCuentCorriBancaFrm.id').toString();
	jsCccCuentCorriBancaCodCc = get('cccCuentCorriBancaFrm.codCc').toString();
	jsCccCuentCorriBancaSociOidSoci = get('cccCuentCorriBancaFrm.sociOidSoci')[0];
	jsCccCuentCorriBancaDesCc = get('cccCuentCorriBancaFrm.desCc').toString();
	jsCccCuentCorriBancaCucoOidCcTeso = get('cccCuentCorriBancaFrm.cucoOidCcTeso')[0];
	jsCccCuentCorriBancaCucoOidCcPnte = get('cccCuentCorriBancaFrm.cucoOidCcPnte')[0];
	jsCccCuentCorriBancaCodCcBanc = get('cccCuentCorriBancaFrm.codCcBanc').toString();
	jsCccCuentCorriBancaSucuOidSucu = get('cccCuentCorriBancaFrm.sucuOidSucu')[0];
	jsCccCuentCorriBancaValNumeSwif = get('cccCuentCorriBancaFrm.valNumeSwif').toString();
	jsCccCuentCorriBancaValDire = get('cccCuentCorriBancaFrm.valDire').toString();
	jsCccCuentCorriBancaValCont = get('cccCuentCorriBancaFrm.valCont').toString();
	jsCccCuentCorriBancaValTele = get('cccCuentCorriBancaFrm.valTele').toString();
	jsCccCuentCorriBancaValObse = get('cccCuentCorriBancaFrm.valObse').toString();
	jsCccCuentCorriBancaPaisOidPais = get('cccCuentCorriBancaFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccCuentCorriBancaFrm.accion'), 
		get('cccCuentCorriBancaFrm.origen'));


	set('cccCuentCorriBancaFrm.id', jsCccCuentCorriBancaId);
	set('cccCuentCorriBancaFrm.codCc', jsCccCuentCorriBancaCodCc);
	set('cccCuentCorriBancaFrm.sociOidSoci', [jsCccCuentCorriBancaSociOidSoci]);
	set('cccCuentCorriBancaFrm.desCc', jsCccCuentCorriBancaDesCc);
	set('cccCuentCorriBancaFrm.cucoOidCcTeso', [jsCccCuentCorriBancaCucoOidCcTeso]);
	set('cccCuentCorriBancaFrm.cucoOidCcPnte', [jsCccCuentCorriBancaCucoOidCcPnte]);
	set('cccCuentCorriBancaFrm.codCcBanc', jsCccCuentCorriBancaCodCcBanc);
	set('cccCuentCorriBancaFrm.sucuOidSucu', [jsCccCuentCorriBancaSucuOidSucu]);
	set('cccCuentCorriBancaFrm.valNumeSwif', jsCccCuentCorriBancaValNumeSwif);
	set('cccCuentCorriBancaFrm.valDire', jsCccCuentCorriBancaValDire);
	set('cccCuentCorriBancaFrm.valCont', jsCccCuentCorriBancaValCont);
	set('cccCuentCorriBancaFrm.valTele', jsCccCuentCorriBancaValTele);
	set('cccCuentCorriBancaFrm.valObse', jsCccCuentCorriBancaValObse);
	set('cccCuentCorriBancaFrm.paisOidPais', [jsCccCuentCorriBancaPaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la b?squeda
	jsCccCuentCorriBancaCodCc = '';
	jsCccCuentCorriBancaSociOidSoci = '';
	jsCccCuentCorriBancaDesCc = '';
	jsCccCuentCorriBancaCucoOidCcTeso = '';
	jsCccCuentCorriBancaCucoOidCcPnte = '';
	jsCccCuentCorriBancaCodCcBanc = '';
	jsCccCuentCorriBancaSucuOidSucu = '';
	
}

//Permite disprar una acci?n para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cccCuentCorriBancaFrm.errCodigo', errorCode);
	set('cccCuentCorriBancaFrm.errDescripcion', description);
	set('cccCuentCorriBancaFrm.errSeverity', severity);
	fMostrarMensajeError();
}
