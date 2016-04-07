function onLoadPag(){
    fMostrarMensajeError();
    configurarMenuSecundario('formulario');
    
    var oidCanal = get('formulario.hOidCana');
    var oidActividad = get('formulario.hOidActi');
    
    if(oidCanal!=''){
        set("formulario.cbCanal", [get('formulario.hOidCana')]);
        recargaActividad();
        if(oidActividad!=''){
            recargaAcceso();
            recargaTipoOferta();
            recargaTipoCliente();
            recargaCicloVida();
            recargaCriAsigna();
            recargaTipoDespacho();
        }
    }
}

function onChangeCanal(){
	if ( get('formulario.cbCanal')!=""){
        recargaActividad();
	}else{
		set_combo("formulario.cbActividad", new Array());
        set_combo("formulario.cbAcceso", new Array());
        set_combo("formulario.cbSubacceso", new Array());
        set_combo("formulario.cbTipoOferta", new Array());
        set_combo("formulario.cbTipoCliente", new Array());
        set_combo("formulario.cbSubTipoCliente", new Array());
        set_combo("formulario.cbCicloVida", new Array());
        set_combo("formulario.cbCriterioAsignacion", new Array());
        set_combo("formulario.cbTipoDespacho", new Array());
        
        set('formulario.hOidActi','');
        set('formulario.hOidAcce','');
        set('formulario.hOidSubAcce','');
        set('formulario.hOidTipOfer','');
        set('formulario.hOidTipClie','');
        set('formulario.hOidSubTipClie','');
        set('formulario.hOidCicVida','');
        set('formulario.hOidCriAsig','');
        set('formulario.hOidTipDesp','');
        
	}
}

function onChangeActividad(){
	if ( get('formulario.cbActividad')!=''){
        // ENVIAR FORMULARIO
        eval('formulario').oculto='N';
        set("formulario.accion", "");
        set('formulario.hOidCana',get('formulario.cbCanal'));
        set('formulario.hOidActi',get('formulario.cbActividad'));
        enviaSICC('formulario')
    }else{
        set_combo('formulario.cbAcceso', new Array());
        set_combo('formulario.cbSubacceso', new Array());
        set_combo('formulario.cbTipoOferta', new Array());
        set_combo('formulario.cbTipoCliente', new Array());
        set_combo('formulario.cbSubTipoCliente', new Array());
        set_combo('formulario.cbCicloVida', new Array());
        set_combo('formulario.cbCriterioAsignacion', new Array());
        set_combo('formulario.cbTipoDespacho', new Array());
        
        set('formulario.hOidAcce','');
        set('formulario.hOidSubAcce','');
        set('formulario.hOidTipOfer','');
        set('formulario.hOidTipClie','');
        set('formulario.hOidSubTipClie','');
        set('formulario.hOidCicVida','');
        set('formulario.hOidCriAsig','');
        set('formulario.hOidTipDesp','');

    }
}

function onChangeAcceso(){
    set('formulario.hOidAcce',get('formulario.cbAcceso'));
    if ( get('formulario.cbAcceso')!=''){
        recargaSubAcceso();
    }else{
        set_combo('formulario.cbSubacceso', new Array());
    }
}

function onChangeSubacceso(){
    set('formulario.hOidSubAcce',get('formulario.cbSubacceso'));
}

function onChangeTipoOferta(){
    set('formulario.hOidTipOfer',get('formulario.cbTipoOferta'));
}

function onChangeTipoCliente(){
    set('formulario.hOidTipClie',get('formulario.cbTipoCliente'));
    if ( get('formulario.cbTipoCliente')!=''){
        recargaSubTipoCliente();
    }else{
        set_combo('formulario.cbSubTipoCliente', new Array());
    }
}

function onChangeSubTipoCliente(){
    set('formulario.hOidSubTipClie',get('formulario.cbSubTipoCliente'));
}

function onChangeCicloVida(){
    set('formulario.hOidCicVida',get('formulario.cbCicloVida'));
}

function onChangeCriterioAsignacion(){
    set('formulario.hOidCriAsig',get('formulario.cbCriterioAsignacion'));
}

function onChangeTipoDespacho(){
    set('formulario.hOidTipDesp',get('formulario.cbTipoDespacho'));
}

function fGuardar(){
	eval('formulario').oculto='S';
	set("formulario.accion", "guardar");
    enviaSICC('formulario');
}

function ejecucionCorrecta(){
    //alert('OK')
    set("formulario.cbCanal", ['']);
    onChangeCanal();
}

function ejecucionError(){
    //fMostrarMensajeError();
}


function armarArray(datos){
    var valores = new Array();
    valores[0] = ['', ''];
    for(i=0; i < datos.length; i++ ){
        valores[i+1] = datos[i];
    }
    return valores;
}

function recargaActividad(){
    // Limpiar Combo
    set_combo('formulario.cbActividad',new Array());
    combo_add('formulario.cbActividad', '', '');
    // Arma el array de datos correspondiente, para luego cargar el combo cbActividades
    var arrDatos = new Array();
    var i = 0;
    if (get('formulario.cbCanal')!=''){
        arrDatos[arrDatos.length] = new Array( 'oidCanal',  get('formulario.cbCanal')  );
    }
    arrDatos[arrDatos.length] = new Array( 'oidIdioma', get("formulario.hIdioma")  );  
    arrDatos[arrDatos.length] = new Array( 'oidPais', get("formulario.hPais") );
    
    recargaCombo('formulario.cbActividad', 'MAVObtieneActividadesMAV', 'es.indra.sicc.dtos.mav.DTOActividadMAV', arrDatos, 'postRecargaActividad(datos)'); 
}

function postRecargaActividad(datos){
    set_combo('formulario.cbActividad',armarArray(datos));
    set("formulario.cbActividad", [get('formulario.hOidActi')]);
}

function recargaAcceso(){
    // Limpiar Combo
    set_combo('formulario.cbAcceso',new Array());
    combo_add('formulario.cbAcceso', '', '');
    // Preparar valores
    var arr = new Array();
    var peticion = "%"+get('formulario.cbCanal')+"%z%%";
    arr[arr.length] = ['cadena', peticion];
    arr[arr.length] = ['oidIdioma', get('formulario.hIdioma')];
    
    recargaCombo('formulario.cbAcceso', 'MENRecargaAccesos', 'es.indra.sicc.util.DTOString', arr, 'postRecargaAcceso(datos)');

}

function postRecargaAcceso(datos){
    set_combo('formulario.cbAcceso',armarArray(datos));
    set("formulario.cbAcceso", [get('formulario.hOidAcce')]);
    onChangeAcceso();
}

function recargaSubAcceso(){
    // Limpiar Combo
    set_combo('formulario.cbSubacceso',new Array());
    combo_add('formulario.cbSubacceso', '', '');
    // Preparar valores
    var arr = new Array();
    var peticion = "%"+get('formulario.cbAcceso')+"%z%%";
    arr[arr.length] = ['cadena', peticion];
    arr[arr.length] = ['oidIdioma', get('formulario.hIdioma')];

    recargaCombo('formulario.cbSubacceso', 'MENRecargaSubAccesos', 'es.indra.sicc.util.DTOString', arr,'postRecargaSubAcceso(datos)');
}

function postRecargaSubAcceso(datos){
    set_combo('formulario.cbSubacceso',armarArray(datos));
    set("formulario.cbSubacceso", [get('formulario.hOidSubAcce')]);
}

function recargaTipoCliente(){
    // Limpiar Combo
    set_combo('formulario.cbTipoCliente',new Array());
    combo_add('formulario.cbTipoCliente', '', '');
    // Preparar valores
    var array = new Array();
    array[array.length] = ['oid', get('formulario.hOidActi')];
    array[array.length] = ['oidIdioma', get('formulario.hIdioma')];

    recargaCombo('formulario.cbTipoCliente', 'MAVObtieneTiposClienteActividad', 'es.indra.sicc.util.DTOOID', array, 'postRecargaTipoCliente(datos)');
}

function postRecargaTipoCliente(datos){
    set_combo('formulario.cbTipoCliente',armarArray(datos));
    set("formulario.cbTipoCliente", [get('formulario.hOidTipClie')]);
    onChangeTipoCliente();
}

function recargaSubTipoCliente(){
    // Limpiar Combo
    set_combo('formulario.cbSubTipoCliente',new Array());
    combo_add('formulario.cbSubTipoCliente', '', '');
    // Preparar valores
    var array = new Array();
    array[array.length] = ['oidPais', get('formulario.hPais')];
    array[array.length] = ['oidIdioma', get('formulario.hIdioma')];
    array[array.length] = ['oidTipoCliente', get('formulario.cbTipoCliente')];

    recargaCombo('formulario.cbSubTipoCliente', 'CMNObtieneSubtiposCliente', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', array, 'postRecargaSubTipoCliente(datos)');
}

function postRecargaSubTipoCliente(datos){
    set_combo('formulario.cbSubTipoCliente',armarArray(datos));
    set("formulario.cbSubTipoCliente", [get('formulario.hOidSubTipClie')]);
}

function recargaCriAsigna(){
    // Limpiar Combo
    set_combo('formulario.cbCriterioAsignacion',new Array());
    combo_add('formulario.cbCriterioAsignacion', '', '');
    // Preparar valores
    var array = new Array();
    array[array.length] = ['oidPais', get('formulario.hPais')];
    array[array.length] = ['oidIdioma', get('formulario.hIdioma')];

    recargaCombo('formulario.cbCriterioAsignacion', 'MAVObtenerCriteriosAsignacion', 'es.indra.sicc.util.DTOBelcorp', array, 'postRecargaCriAsigna(datos)');
}

function postRecargaCriAsigna(datos){
    set_combo('formulario.cbCriterioAsignacion',armarArray(datos));
    set("formulario.cbCriterioAsignacion", [get('formulario.hOidCriAsig')]);
}

function recargaTipoOferta(){
    // Limpiar Combo
    set_combo('formulario.cbTipoOferta',new Array());
    combo_add('formulario.cbTipoOferta', '', '');
    // Preparar valores
    var array = new Array();
    array[array.length] = ['oid', get('formulario.hOidActi')];
    array[array.length] = ['oidIdioma', get('formulario.hIdioma')];

    recargaCombo('formulario.cbTipoOferta', 'MAVObtenerTiposOfertaActividad', 'es.indra.sicc.util.DTOOID', array, 'postRecargaTipoOferta(datos)');

}

function postRecargaTipoOferta(datos){
    set_combo('formulario.cbTipoOferta',armarArray(datos));
    set("formulario.cbTipoOferta", [get('formulario.hOidTipOfer')]);
}

function recargaCicloVida(){
    // Limpiar Combo
    set_combo('formulario.cbCicloVida',new Array());
    combo_add('formulario.cbCicloVida', '', '');
    // Preparar valores
    var array = new Array();
    array[array.length] = ['oid', get('formulario.hOidActi')];
    array[array.length] = ['oidIdioma', get('formulario.hIdioma')];

    recargaCombo('formulario.cbCicloVida', 'MAVObtenerCiclosVidaActividad', 'es.indra.sicc.util.DTOOID', array, 'postRecargaCicloVida(datos)');

}

function postRecargaCicloVida(datos){
    set_combo('formulario.cbCicloVida',armarArray(datos));
    set("formulario.cbCicloVida", [get('formulario.hOidCicVida')]);
}

function recargaTipoDespacho(){
    // Limpiar Combo
    set_combo('formulario.cbTipoDespacho',new Array());
    combo_add('formulario.cbTipoDespacho', '', '');
    // Preparar valores
    var array = new Array();
    array[array.length] = ['oid', get('formulario.hOidActi')];
    array[array.length] = ['oidIdioma', get('formulario.hIdioma')];

    recargaCombo('formulario.cbTipoDespacho', 'MAVObtenerTiposDespachoActividad', 'es.indra.sicc.util.DTOOID', array, 'postRecargaTipoDespacho(datos)');

}

function postRecargaTipoDespacho(datos){
    set_combo('formulario.cbTipoDespacho',armarArray(datos));
    set("formulario.cbTipoDespacho", [get('formulario.hOidTipDesp')]);
}
