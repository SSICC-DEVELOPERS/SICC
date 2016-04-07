var LPName = "LPInsertarKit";
var formName = "frmPrototipoInsertarUsuario";
var numDecimales = null;
var entornoSeparador = null;
var sizeOfCTEXT = 6;
var sizeInt = null;

function onLoadPag()   {
   configurarMenuSecundario(formName);
   if(chequeaErrores()){
      DrdEnsanchaConMargenDcho('listado1',38);
      document.all["primera1Div"].style.visibility='hidden';
      document.all["ret1Div"].style.visibility='hidden';
      document.all["ava1Div"].style.visibility='hidden';
      eval (ON_RSZ);
      completarComboTipo();
      if(_get("CasoDeUso") == "Modificar") {
         LPName = "LPModificarKit";
         /* Posicionamos valores en los combos y radiob */
         _selectV("cbIndicadorPS");   _selectV("cbGenerico");
         _selectV("cbMarca");         _selectV("cbSuperGenerico");
         _selectV("cbCanal");         _selectV("cbEstatusProducto");
         _selectV("cbPeriodoInicio"); _selectV("cbSituacion");
         _selectV("cbPeriodoFin");    _selectV("cbUnidadMedidaDimensiones");
         _selectV("cbLinea");         _selectV("cbUnidadMedidaVolumen");
         _selectV("cbNegocio");       _selectV("cbUnidadMedidaPeso");
         _selectV("cbUnidadNegocio"); _selectV("cbIndicadorDentroCaja");
         _selectV("rbIndicadorLote");
      }
   }
}

function completarComboTipo()  {
    _selectV("cbUnidadNegocio");
    _selectV("rbIndicadorLote");

    var descrip = GestionarMensaje(984, "", "", "");
    var cod = GestionarMensaje(985, "", "", "");
    combo_add(formName + '.cbIndicadorPS', "1", GestionarMensaje(1009, "", "", ""));
    combo_add(formName + '.cbIndicadorPS', "0", GestionarMensaje(1008, "", "", ""));
    set(formName + '.cbIndicadorPS',new Array('1'));

    combo_add(formName + '.cbSituacion', "1", GestionarMensaje(156, "", "", ""));
    combo_add(formName + '.cbSituacion', "0", GestionarMensaje(157, "", "", ""));

    set(formName + '.cbSituacion',new Array('1'));

    combo_add(formName + '.cbIndicadorDentroCaja', "C", GestionarMensaje(1012, "", "", ""));
    combo_add(formName + '.cbIndicadorDentroCaja', "B", GestionarMensaje(1013, "", "", ""));

    set(formName + '.cbIndicadorDentroCaja',new Array('B'));

    /*-- COMMENTAR AL FINAL -----*/
    set(formName + '.cbMarca',new Array('3'));
    set(formName + '.cbUnidadNegocio',new Array('2'));
    set(formName + '.cbGenerico',new Array('2'));
    set(formName + '.cbSuperGenerico',new Array('3'));
    set(formName + '.cbUnidadMedidaDimensiones',new Array('6'));
    set(formName + '.cbUnidadMedidaPeso',new Array('6'));
    set(formName + '.cbUnidadMedidaVolumen',new Array('2'));
    set(formName + '.cbLinea',new Array('1'));
    set(formName + '.cbNegocio',new Array('2'));
    set(formName + '.cbEstatusProducto',new Array('1'));
}

function anadir(){
    //alert(ValidaNum(get(formName + ".txtNumeroUnidades").toString()));
    if(ValidaNum(get(formName + ".txtNumeroUnidades").toString()) == "OK"){
        if(get(formName + ".txtProductos").toString() != "" && get(formName + ".txtNumeroUnidades").toString() != "") {
            var nuevaFila = new Array(); nuevaFila[0] = "" + first_col++;
            nuevaFila[1] = get(formName + ".txtProductos").toString();
            nuevaFila[2] = get(formName + ".txtNumeroUnidades").toString();
            with(listado1) {
                for(var x = 0; x < datos.length;x++) {
                    if(datos[x][1] == nuevaFila[1]) {
                        datos[x][2] = nuevaFila[2]; display();
                        return false;
                    }
                }
            }
            listado1.datos[listado1.datos.length] = nuevaFila;
            listado1.setDatos(listado1.datos);
        }
    }
}

function cargarPeriodos() {
    var marca = get(formName + '.cbMarca2').toString();
    var canal = get(formName + '.cbCanal').toString();
    var tipo_periodo = get(formName + '.cbTipoPeriodo').toString();
    if(marca != "" && canal != "" && tipo_periodo != "") {
        recargaCombo("cbPeriodoInicio", "MAEBuscarPeriodos", "es.indra.sicc.dtos.mae.DTOBusquedaPeriodos", MakeParameters("inicio",marca,canal,tipo_periodo));
        recargaCombo("cbPeriodoFin", "MAEBuscarPeriodos", "es.indra.sicc.dtos.mae.DTOBusquedaPeriodos", MakeParameters("fin", marca,canal,tipo_periodo));
    }
}

function cargaCanal(id) {
    //alert(lstOculta.datos.longitud);
    //alert(lstOculta.datos.ij(0,1));
    set_combo(formName + '.cbCanal','');
    combo_add(formName + '.cbCanal','','');
    for(var i = 1; i < lstOculta.datos.longitud;i++) {
        //alert(lstOculta.datos.ij(i,0) + " " + lstOculta.datos.ij(i,1) + " " + lstOculta.datos.ij(i,2) );
        if(get(formName + ".cbTipoPeriodo").toString() == lstOculta.datos.ij(i,2))
            combo_add(formName + '.cbCanal', lstOculta.datos.ij(i,0), lstOculta.datos.ij(i,1));
    }
}

function MakeParameters(cb,marca,canal,tipo_periodo) {
    var parametros = new Array([],[],[]);
    parametros[0][0] = "marca";
    parametros[0][1] = marca;
    parametros[1][0] = "canal";
    parametros[1][1] = canal;
    parametros[2][0] = "tipoPeriodo";
    parametros[2][1] = tipo_periodo;
    return parametros;
}

function fGuardar() {
    numDecimales = _get("hid_NumeroDecimales");   //alert(numDecimales);
    entornoSeparador = (_get("hid_SeparadorDecimales") == ",")?true:false;
    //------ decimales ----------------------------------------
    if(checkFloatNoEmpty("txtDimensionAlto")) return;
    if(checkFloatNoEmpty("txtDimensionAncho")) return;
    if(checkFloatNoEmpty("txtDimensionLargo")) return;
    if(checkFloatNoEmpty("txtDimensionVolumen")) return;
    if(checkFloatNoEmpty("txtDimensionPeso")) return;
    if(checkFloatNoEmpty("txtCosteEstandar")) return;
    if(checkFloatNoEmpty("txtPrecioPosicionamiento")) return;
    sizeOfCTEXT = 13;
    if(checkFloatNoEmpty("txtPrecioCatalogo")) return;
    if(checkFloatNoEmpty("txtPrecioContable")) return;
    //--------- numericos ---------------
    if(checkNumNoEmpty("txtPorcentajeUnidades")) return;
    if(checkNumNoEmpty("txtUnidadesDentroPedido")) return;
    if(checkNumNoEmpty("txtUnidadesCaja")) return;
    //alert(listado1.datos.toString());
    if(listado1.datos.length > 0) {
        var lst_productos= "";
        var lst_num_unidades= "";
        var p = "";
        for(var i =0;i < listado1.datos.length;i++) {
            if(i > 0) p = "|";
            lst_productos += p + listado1.datos[i][1];
            lst_num_unidades += p + listado1.datos[i][2];
        }
        alert(lst_productos);
        set(formName + ".hid_lstColumnProductos", lst_productos);
        set(formName + ".hid_lstColumnNumUnidades", lst_num_unidades);
   }else{ /*gestionarMensaje();*/ }
   alert("grabando");
   set(formName + ".accion", "Guardar");
   set(formName + ".conectorAction", LPName); /* Nombre de LP esta asignado anteriormente en la carga */
   enviaSICC(formName);
}

function fBorrar(){isklu4itVibRegistr(listado1);}
