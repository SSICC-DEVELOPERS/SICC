

/*
    INDRA/CAR/mmg
    $Id: pedtiposolic.js,v 1.1 2009/12/03 19:01:55 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedTipoSolicId = "";
var jsPedTipoSolicCodTipoSoli = "";
var jsPedTipoSolicTiclOidTipoClie = "";
var jsPedTipoSolicMarcOidMarc = "";
var jsPedTipoSolicAcceOidAcce = "";
var jsPedTipoSolicClsoOidClasSoli = "";
var jsPedTipoSolicIndCons = "";
var jsPedTipoSolicIndSoliNega = "";
var jsPedTipoSolicGrsoOidGrupSoli = "";
var jsPedTipoSolicIndDevo = "";
var jsPedTipoSolicIndAnul = "";
var jsPedTipoSolicSbacOidSbac = "";
var jsPedTipoSolicCodGrupSoli = "";
var jsPedTipoSolicDescripcion = "";

//Variables de paginacion, 
var pedTipoSolicPageCount = 1;

//Varible de columna que representa el campo de choice
var pedTipoSolicChoiceColumn = 12;

//Flag de siguiente pagina;
var pedTipoSolicMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedTipoSolicTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 567;
var sizeFormView = 623;
var sizeFormUpdate = 623;

//Ultima busqueda realizada
var pedTipoSolicLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");'],[3,'focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", false);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", false);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", false);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", true);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", true);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", true);'],[4,'focalizaComboDependence("pedTipoSolic","marcOidMarc", false);','focalizaComboDependence("pedTipoSolic","marcOidMarc", false);','focalizaComboDependence("pedTipoSolic","marcOidMarc", false);','focalizaComboDependence("pedTipoSolic","marcOidMarc", true);','focalizaComboDependence("pedTipoSolic","marcOidMarc", true);','focalizaComboDependence("pedTipoSolic","marcOidMarc", true);'],[5,'focalizaComboDependence("pedTipoSolic","acceOidAcce", false);','focalizaComboDependence("pedTipoSolic","acceOidAcce", false);','focalizaComboDependence("pedTipoSolic","acceOidAcce", false);','focalizaComboDependence("pedTipoSolic","acceOidAcce", true);','focalizaComboDependence("pedTipoSolic","acceOidAcce", true);','focalizaComboDependence("pedTipoSolic","acceOidAcce", true);'],[6,'focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", false);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", false);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", false);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", true);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", true);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", true);'],[7,'focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");'],[8,'focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");'],[9,'focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", false);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", false);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", false);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", true);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", true);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", true);'],[10,'focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");'],[11,'focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");'],[12,'focalizaComboDependence("pedTipoSolic","sbacOidSbac", false);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", false);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", false);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", true);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", true);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", true);'],[13,'focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");'],[14,'','focaliza("pedTipoSolicFrm.Descripcion");','focaliza("pedTipoSolicFrm.Descripcion");','','focaliza("pedTipoSolicFrm.Descripcion");','focaliza("pedTipoSolicFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");','focaliza("pedTipoSolicFrm.codTipoSoli");'],[3,'focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", false);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", false);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", false);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", true);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", true);','focalizaComboDependence("pedTipoSolic","ticlOidTipoClie", true);'],[4,'focalizaComboDependence("pedTipoSolic","marcOidMarc", false);','focalizaComboDependence("pedTipoSolic","marcOidMarc", false);','focalizaComboDependence("pedTipoSolic","marcOidMarc", false);','focalizaComboDependence("pedTipoSolic","marcOidMarc", true);','focalizaComboDependence("pedTipoSolic","marcOidMarc", true);','focalizaComboDependence("pedTipoSolic","marcOidMarc", true);'],[5,'focalizaComboDependence("pedTipoSolic","acceOidAcce", false);','focalizaComboDependence("pedTipoSolic","acceOidAcce", false);','focalizaComboDependence("pedTipoSolic","acceOidAcce", false);','focalizaComboDependence("pedTipoSolic","acceOidAcce", true);','focalizaComboDependence("pedTipoSolic","acceOidAcce", true);','focalizaComboDependence("pedTipoSolic","acceOidAcce", true);'],[6,'focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", false);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", false);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", false);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", true);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", true);','focalizaComboDependence("pedTipoSolic","clsoOidClasSoli", true);'],[7,'focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");','focaliza("pedTipoSolicFrm.indCons");'],[8,'focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");','focaliza("pedTipoSolicFrm.indSoliNega");'],[9,'focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", false);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", false);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", false);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", true);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", true);','focalizaComboDependence("pedTipoSolic","grsoOidGrupSoli", true);'],[10,'focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");','focaliza("pedTipoSolicFrm.indDevo");'],[11,'focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");','focaliza("pedTipoSolicFrm.indAnul");'],[12,'focalizaComboDependence("pedTipoSolic","sbacOidSbac", false);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", false);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", false);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", true);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", true);','focalizaComboDependence("pedTipoSolic","sbacOidSbac", true);'],[13,'focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");','focaliza("pedTipoSolicFrm.codGrupSoli");'],[14,'','focaliza("pedTipoSolicFrm.Descripcion");','focaliza("pedTipoSolicFrm.Descripcion");','','focaliza("pedTipoSolicFrm.Descripcion");','focaliza("pedTipoSolicFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var ticlOidTipoClieDependeceMap = new Vector();
ticlOidTipoClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ticlOidTipoClieDependeceMap.agregar(['ticlOidTipoClie', padresTmp, '', 'MaeTipoClien']);
var marcOidMarcDependeceMap = new Vector();
marcOidMarcDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
marcOidMarcDependeceMap.agregar(['marcOidMarc', padresTmp, '', 'SegMarca']);
var acceOidAcceDependeceMap = new Vector();
acceOidAcceDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
acceOidAcceDependeceMap.agregar(['acceOidAcce_canaOidCana', padresTmp, 'acceOidAcce', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['acceOidAcce_canaOidCana'])
acceOidAcceDependeceMap.agregar(['acceOidAcce', padresTmp, '', 'SegAcces']);
var clsoOidClasSoliDependeceMap = new Vector();
clsoOidClasSoliDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clsoOidClasSoliDependeceMap.agregar(['clsoOidClasSoli', padresTmp, '', 'PedClaseSolic']);
var grsoOidGrupSoliDependeceMap = new Vector();
grsoOidGrupSoliDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
grsoOidGrupSoliDependeceMap.agregar(['grsoOidGrupSoli', padresTmp, '', 'CarGrupoSolic']);
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

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedTipoSolicLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedTipoSolicTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedTipoSolicInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedTipoSolicFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedTipoSolicFrm.accion')){
		case "query": pedTipoSolicQueryInitComponents(); break;
		case "view": pedTipoSolicViewInitComponents(); break;
		case "create": pedTipoSolicCreateInitComponents(); break;
		case "update": pedTipoSolicUpdateInitComponents(); break;
		case "remove": pedTipoSolicRemoveInitComponents(); break;
		case "lov": pedTipoSolicLovInitComponents(); break;
	}
	//alert('accion :' + get('pedTipoSolicFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedTipoSolicFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedTipoSolic')) pedTipoSolicCmdRequery();
}

function pedTipoSolicQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('pedTipoSolicFrm', true);	
}

function pedTipoSolicViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('pedTipoSolicFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('pedTipoSolicFrm', true);
}

function pedTipoSolicCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedTipoSolicFrm.codTipoSoli','S', GestionarMensaje('PedTipoSolic.codTipoSoli.requiered.message'));
	
	setMV('pedTipoSolicFrm.ticlOidTipoClie','S', GestionarMensaje('PedTipoSolic.ticlOidTipoClie.requiered.message'));
	
	setMV('pedTipoSolicFrm.marcOidMarc','S', GestionarMensaje('PedTipoSolic.marcOidMarc.requiered.message'));
	
	setMV('pedTipoSolicFrm.acceOidAcce','S', GestionarMensaje('PedTipoSolic.acceOidAcce.requiered.message'));
	
	setMV('pedTipoSolicFrm.clsoOidClasSoli','S', GestionarMensaje('PedTipoSolic.clsoOidClasSoli.requiered.message'));
	
	setMV('pedTipoSolicFrm.indCons','S', GestionarMensaje('PedTipoSolic.indCons.requiered.message'));
	
	setMV('pedTipoSolicFrm.indSoliNega','S', GestionarMensaje('PedTipoSolic.indSoliNega.requiered.message'));
	
	setMV('pedTipoSolicFrm.indDevo','S', GestionarMensaje('PedTipoSolic.indDevo.requiered.message'));
	
	setMV('pedTipoSolicFrm.indAnul','S', GestionarMensaje('PedTipoSolic.indAnul.requiered.message'));
	
	setMV('pedTipoSolicFrm.Descripcion','S', GestionarMensaje('PedTipoSolic.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedTipoSolicFrm', true);
}

function pedTipoSolicUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedTipoSolicFrm.origen') == "pagina"){
		loadLocalizationWidget('pedTipoSolicFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		pedTipoSolicTmpUpdateValues = pedTipoSolicBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedTipoSolicFrm.codTipoSoli','S', GestionarMensaje('PedTipoSolic.codTipoSoli.requiered.message'));
		setMV('pedTipoSolicFrm.ticlOidTipoClie','S', GestionarMensaje('PedTipoSolic.ticlOidTipoClie.requiered.message'));
		setMV('pedTipoSolicFrm.marcOidMarc','S', GestionarMensaje('PedTipoSolic.marcOidMarc.requiered.message'));
		setMV('pedTipoSolicFrm.acceOidAcce','S', GestionarMensaje('PedTipoSolic.acceOidAcce.requiered.message'));
		setMV('pedTipoSolicFrm.clsoOidClasSoli','S', GestionarMensaje('PedTipoSolic.clsoOidClasSoli.requiered.message'));
		setMV('pedTipoSolicFrm.indCons','S', GestionarMensaje('PedTipoSolic.indCons.requiered.message'));
		setMV('pedTipoSolicFrm.indSoliNega','S', GestionarMensaje('PedTipoSolic.indSoliNega.requiered.message'));
		setMV('pedTipoSolicFrm.indDevo','S', GestionarMensaje('PedTipoSolic.indDevo.requiered.message'));
		setMV('pedTipoSolicFrm.indAnul','S', GestionarMensaje('PedTipoSolic.indAnul.requiered.message'));
		setMV('pedTipoSolicFrm.Descripcion','S', GestionarMensaje('PedTipoSolic.Descripcion.requiered.message'));
		
			focusFirstFieldModify('pedTipoSolicFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('pedTipoSolicFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedTipoSolicFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedTipoSolicRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedTipoSolicList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedTipoSolicFrm', true);
}

function pedTipoSolicLovInitComponents(){
	pedTipoSolicLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedTipoSolicFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad
















//Función que permite cargar los datos de un elemento de lov seleccionado
function pedTipoSolicSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedTipoSolicFrm.' + campo, id);
	set('pedTipoSolicFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedTipoSolicLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedTipoSolicLovReturnParameters.id = '';
	pedTipoSolicLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedTipoSolicLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedTipoSolicList.codSeleccionados();
	var descripcion = pedTipoSolicList.extraeDato(
		pedTipoSolicList.codSeleccionados()[0], pedTipoSolicChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedTipoSolicLovReturnParameters.id = codigo;
	pedTipoSolicLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedTipoSolicCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedTipoSolicFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedTipoSolicFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedTipoSolicList", "PedTipoSolicConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedTipoSolicPostQueryActions(datos);"]], "", "");	
}

function pedTipoSolicCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedTipoSolicFrm.lastQueryToSession'));
	var i =0;
	set('pedTipoSolicFrm.codTipoSoli', paramsRequery.ij(i++));
	
	set('pedTipoSolicFrm.ticlOidTipoClie', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicFrm.marcOidMarc', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicFrm.acceOidAcce', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicFrm.clsoOidClasSoli', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicFrm.indCons', paramsRequery.ij(i++));
	
	set('pedTipoSolicFrm.indSoliNega', paramsRequery.ij(i++));
	
	set('pedTipoSolicFrm.grsoOidGrupSoli', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicFrm.indDevo', paramsRequery.ij(i++));
	
	set('pedTipoSolicFrm.indAnul', paramsRequery.ij(i++));
	
	set('pedTipoSolicFrm.sbacOidSbac', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicFrm.codGrupSoli', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	pedTipoSolicPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedTipoSolicCmdQuery(pedTipoSolicPageCount);
}

function pedTipoSolicFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedTipoSolicPageCount = 1;
	pedTipoSolicCmdQuery(pedTipoSolicPageCount);
}

function pedTipoSolicPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedTipoSolicLastQuery){
		pedTipoSolicFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedTipoSolicPageCount--;
	pedTipoSolicCmdQuery(pedTipoSolicPageCount);
}

function pedTipoSolicNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedTipoSolicLastQuery){
		pedTipoSolicFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedTipoSolicPageCount++;
	pedTipoSolicCmdQuery(pedTipoSolicPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedTipoSolicPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedTipoSolicListLayer', 'O');
		visibilidad('pedTipoSolicListButtonsLayer', 'O');
		if(get('pedTipoSolicFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedTipoSolicLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedTipoSolicViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedTipoSolicChoiceColumn) + "</A>",
			i, pedTipoSolicChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedTipoSolicList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedTipoSolicTimeStamps = datosTmp.filtrar([13],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedTipoSolicMorePagesFlag = true;
		pedTipoSolicList.eliminar(mmgPageSize, 1);
	}else{
		pedTipoSolicMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedTipoSolicFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedTipoSolicListLayer', 'V');
	visibilidad('pedTipoSolicListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedTipoSolicList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedTipoSolicList.display();
	
	//Actualizamos el estado de los botones 
	if(pedTipoSolicMorePagesFlag){
		set_estado_botonera('pedTipoSolicPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedTipoSolicPaginationButtonBar',
			3,"inactivo");
	}
	if(pedTipoSolicPageCount > 1){
		set_estado_botonera('pedTipoSolicPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedTipoSolicPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedTipoSolicPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedTipoSolicPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedTipoSolicUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedTipoSolicFrm.idSelection', pedTipoSolicList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedTipoSolicFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedTipoSolicList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedTipoSolicFrm.accion');
		parametros["accion"] = get('pedTipoSolicFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedTipoSolicLPStartUp', get('pedTipoSolicFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedTipoSolicCmdRequery();
	}
}

function pedTipoSolicRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedTipoSolicList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedTipoSolicFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedTipoSolicList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedTipoSolicTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedTipoSolicFrm.timestamp', timestamps);


	pedTipoSolicFrm.oculto='S';
	envia('pedTipoSolicFrm');
	pedTipoSolicFrm.oculto='N';
}

function pedTipoSolicViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedTipoSolicViewDetail(pedTipoSolicList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedTipoSolicViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedTipoSolicFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedTipoSolicLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
	
	
	
	
	
	setDefaultLanguageValue('pedTipoSolicFrm', 
		'Descripcion', 1,
		get('pedTipoSolicFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('pedTipoSolicFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	if(!hasDefaultLanguageValue('pedTipoSolicFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('PedTipoSolic.Descripcion.requiered.message'));
		focaliza('pedTipoSolicFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		pedTipoSolicFrm.oculto='S';
		envia('pedTipoSolicFrm');
		pedTipoSolicFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedTipoSolicFrm.ticlOidTipoClie').toString() == ''){
		set('pedTipoSolicFrm.ticlOidTipoClie', []);
		mmgResetCombosOnCascade('ticlOidTipoClie', 'ticlOidTipoClie', 'pedTipoSolic');
		
	}
	if(get('pedTipoSolicFrm.marcOidMarc').toString() == ''){
		set('pedTipoSolicFrm.marcOidMarc', []);
		mmgResetCombosOnCascade('marcOidMarc', 'marcOidMarc', 'pedTipoSolic');
		
	}
	if(get('pedTipoSolicFrm.acceOidAcce').toString() == ''){
		set('pedTipoSolicFrm.acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('acceOidAcce_canaOidCana', 'acceOidAcce', 'pedTipoSolic');
		
	}
	if(get('pedTipoSolicFrm.clsoOidClasSoli').toString() == ''){
		set('pedTipoSolicFrm.clsoOidClasSoli', []);
		mmgResetCombosOnCascade('clsoOidClasSoli', 'clsoOidClasSoli', 'pedTipoSolic');
		
	}
	if(get('pedTipoSolicFrm.grsoOidGrupSoli').toString() == ''){
		set('pedTipoSolicFrm.grsoOidGrupSoli', []);
		mmgResetCombosOnCascade('grsoOidGrupSoli', 'grsoOidGrupSoli', 'pedTipoSolic');
		
	}
	if(get('pedTipoSolicFrm.sbacOidSbac').toString() == ''){
		set('pedTipoSolicFrm.sbacOidSbac_acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac', 'pedTipoSolic');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedTipoSolicRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedTipoSolicFrm.accion');
	var origenTmp = get('pedTipoSolicFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedTipoSolicBuildUpdateRecordString() != pedTipoSolicTmpUpdateValues){
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
	document.all.pedTipoSolicListLayer.style.display='none';
	document.all.pedTipoSolicListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedTipoSolicListLayer.style.display='';
	document.all.pedTipoSolicListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedTipoSolicCodTipoSoli = get('pedTipoSolicFrm.codTipoSoli').toString();
	jsPedTipoSolicTiclOidTipoClie = get('pedTipoSolicFrm.ticlOidTipoClie')[0];
	jsPedTipoSolicMarcOidMarc = get('pedTipoSolicFrm.marcOidMarc')[0];
	jsPedTipoSolicAcceOidAcce = get('pedTipoSolicFrm.acceOidAcce')[0];
	jsPedTipoSolicClsoOidClasSoli = get('pedTipoSolicFrm.clsoOidClasSoli')[0];
	jsPedTipoSolicIndCons = get('pedTipoSolicFrm.indCons').toString();
	jsPedTipoSolicIndSoliNega = get('pedTipoSolicFrm.indSoliNega').toString();
	jsPedTipoSolicGrsoOidGrupSoli = get('pedTipoSolicFrm.grsoOidGrupSoli')[0];
	jsPedTipoSolicIndDevo = get('pedTipoSolicFrm.indDevo').toString();
	jsPedTipoSolicIndAnul = get('pedTipoSolicFrm.indAnul').toString();
	jsPedTipoSolicSbacOidSbac = get('pedTipoSolicFrm.sbacOidSbac')[0];
	jsPedTipoSolicCodGrupSoli = get('pedTipoSolicFrm.codGrupSoli').toString();
	
	
	var parametros = "";
	parametros += jsPedTipoSolicCodTipoSoli + "|";
	parametros += jsPedTipoSolicTiclOidTipoClie + "|";
	parametros += jsPedTipoSolicMarcOidMarc + "|";
	parametros += jsPedTipoSolicAcceOidAcce + "|";
	parametros += jsPedTipoSolicClsoOidClasSoli + "|";
	parametros += jsPedTipoSolicIndCons + "|";
	parametros += jsPedTipoSolicIndSoliNega + "|";
	parametros += jsPedTipoSolicGrsoOidGrupSoli + "|";
	parametros += jsPedTipoSolicIndDevo + "|";
	parametros += jsPedTipoSolicIndAnul + "|";
	parametros += jsPedTipoSolicSbacOidSbac + "|";
	parametros += jsPedTipoSolicCodGrupSoli + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedTipoSolicBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedTipoSolicCodTipoSoli + "|";
	parametros += jsPedTipoSolicTiclOidTipoClie + "|";
	parametros += jsPedTipoSolicMarcOidMarc + "|";
	parametros += jsPedTipoSolicAcceOidAcce + "|";
	parametros += jsPedTipoSolicClsoOidClasSoli + "|";
	parametros += jsPedTipoSolicIndCons + "|";
	parametros += jsPedTipoSolicIndSoliNega + "|";
	parametros += jsPedTipoSolicGrsoOidGrupSoli + "|";
	parametros += jsPedTipoSolicIndDevo + "|";
	parametros += jsPedTipoSolicIndAnul + "|";
	parametros += jsPedTipoSolicSbacOidSbac + "|";
	parametros += jsPedTipoSolicCodGrupSoli + "|";
	parametros += jsPedTipoSolicDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedTipoSolicFrm.accion'), 
		get('pedTipoSolicFrm.origen'));
	
	jsPedTipoSolicId = get('pedTipoSolicFrm.id').toString();
	jsPedTipoSolicCodTipoSoli = get('pedTipoSolicFrm.codTipoSoli').toString();
	jsPedTipoSolicTiclOidTipoClie = get('pedTipoSolicFrm.ticlOidTipoClie')[0];
	jsPedTipoSolicMarcOidMarc = get('pedTipoSolicFrm.marcOidMarc')[0];
	jsPedTipoSolicAcceOidAcce = get('pedTipoSolicFrm.acceOidAcce')[0];
	jsPedTipoSolicClsoOidClasSoli = get('pedTipoSolicFrm.clsoOidClasSoli')[0];
	jsPedTipoSolicIndCons = get('pedTipoSolicFrm.indCons').toString();
	jsPedTipoSolicIndSoliNega = get('pedTipoSolicFrm.indSoliNega').toString();
	jsPedTipoSolicGrsoOidGrupSoli = get('pedTipoSolicFrm.grsoOidGrupSoli')[0];
	jsPedTipoSolicIndDevo = get('pedTipoSolicFrm.indDevo').toString();
	jsPedTipoSolicIndAnul = get('pedTipoSolicFrm.indAnul').toString();
	jsPedTipoSolicSbacOidSbac = get('pedTipoSolicFrm.sbacOidSbac')[0];
	jsPedTipoSolicCodGrupSoli = get('pedTipoSolicFrm.codGrupSoli').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPedTipoSolicDescripcion = buildLocalizedString('pedTipoSolicFrm', 1);
	}else{
		jsPedTipoSolicDescripcion = get('pedTipoSolicFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedTipoSolicFrm.accion'), 
		get('pedTipoSolicFrm.origen'));


	set('pedTipoSolicFrm.id', jsPedTipoSolicId);
	set('pedTipoSolicFrm.codTipoSoli', jsPedTipoSolicCodTipoSoli);
	set('pedTipoSolicFrm.ticlOidTipoClie', [jsPedTipoSolicTiclOidTipoClie]);
	set('pedTipoSolicFrm.marcOidMarc', [jsPedTipoSolicMarcOidMarc]);
	set('pedTipoSolicFrm.acceOidAcce', [jsPedTipoSolicAcceOidAcce]);
	set('pedTipoSolicFrm.clsoOidClasSoli', [jsPedTipoSolicClsoOidClasSoli]);
	set('pedTipoSolicFrm.indCons', jsPedTipoSolicIndCons);
	set('pedTipoSolicFrm.indSoliNega', jsPedTipoSolicIndSoliNega);
	set('pedTipoSolicFrm.grsoOidGrupSoli', [jsPedTipoSolicGrsoOidGrupSoli]);
	set('pedTipoSolicFrm.indDevo', jsPedTipoSolicIndDevo);
	set('pedTipoSolicFrm.indAnul', jsPedTipoSolicIndAnul);
	set('pedTipoSolicFrm.sbacOidSbac', [jsPedTipoSolicSbacOidSbac]);
	set('pedTipoSolicFrm.codGrupSoli', jsPedTipoSolicCodGrupSoli);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('pedTipoSolicFrm', 1,  jsPedTipoSolicDescripcion)
		loadLocalizationWidget('pedTipoSolicFrm', 'Descripcion', 1);
	}else{
		set('pedTipoSolicFrm.Descripcion', jsPedTipoSolicDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedTipoSolicCodTipoSoli = '';
	jsPedTipoSolicTiclOidTipoClie = '';
	jsPedTipoSolicMarcOidMarc = '';
	jsPedTipoSolicAcceOidAcce = '';
	jsPedTipoSolicClsoOidClasSoli = '';
	jsPedTipoSolicIndCons = '';
	jsPedTipoSolicIndSoliNega = '';
	jsPedTipoSolicGrsoOidGrupSoli = '';
	jsPedTipoSolicIndDevo = '';
	jsPedTipoSolicIndAnul = '';
	jsPedTipoSolicSbacOidSbac = '';
	jsPedTipoSolicCodGrupSoli = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedTipoSolicFrm.errCodigo', errorCode);
	set('pedTipoSolicFrm.errDescripcion', description);
	set('pedTipoSolicFrm.errSeverity', severity);
	fMostrarMensajeError();
}
