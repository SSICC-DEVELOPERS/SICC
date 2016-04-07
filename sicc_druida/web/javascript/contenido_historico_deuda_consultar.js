 function onLoad(){
        setTimeout('configurarMenuSecundario("frmFormulario");',200);

        if ( get('frmFormulario.accion')==''){
            focaliza('frmFormulario.txtCodigoCliente','');
        }
    //eval(ON_RSZ);
    }
    
    /*  Llamar a la lp "LPConsultarHistoricoDeuda" con acción "buscar"  */ 
    function botonOnClick(){

        set('frmFormulario.conectorAction', 'LPConsultarHistoricoDeuda');
        set('frmFormulario.accion', 'buscar');
        enviaSICC('frmFormulario');
    }
    
    /*  
     -> Abrimos una ventana modal, llamando a la
        "LPBusquedaRapidaCliente" con accion "" 
     -> Recuperar el array de respuesta con los valores de la fila 
        seleccionada (oid, codigo, nombre1, nombre2, apellido1, apellido2). 
     -> Asignamos "oid" a la variable "oidCliente" y "codigo" 
        al campo "codigoCliente"  
    */

    function buscarClienteOnClick(){
        if ( get('formulario.accion') != 'clienteSeleccionado' )  {
          // var oid;
          // var obj = new Object();
           var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',new Object());//[1] obj);
           if(whnd!=null){
      
           //[1] }else{
               /* posicion N°
                0 : oid del cliente
                1 : codigo del cliente
                2 : Nombre1 del cliente
                3 : Nombre2 del cliente
                4 : apellido1 del cliente
                5 : apellido2 del cliente */
             
                var oid = whnd[0];
                var cod = whnd[1];
                //[1] var nombre1 = whnd[2];
                //[1] var nombre2 = whnd[3];
                //[1] var apellido1 = whnd[4]; 
                //[1] var apellido2 = whnd[5]; 
                
                // asigno los valores a las variables y campos corresp.
                set("frmFormulario.hOidCliente", oid);
                set("frmFormulario.txtCodigoCliente", cod);
           
           }    
        }
    }
    
    /* Llamar a la lp "LPConsultarHistoricoDeuda" con acción "buscar"  */
  /*  function buscarOnClick(){

      set('frmFormulario.conectorAction', 'LPConsultarHistoricoDeuda');
      set('frmFormulario.accion', 'buscar');
      enviaSICC('frmFormulario');
    }
  */
    function ontab_Buscar(){
       focaliza('frmFormulario.txtCodigoCliente','');       
    }

    function onShifTab_txtCodigoCliente(){
             focalizaBotonHTML('botonContenido', 'btnBuscar');
    }

    
    function onchange_codCliente(){
        var codCliente = get('frmFormulario.txtCodigoCliente');
        if (codCliente.length != 0){    
           codigoCompleto = validarLongCodCliene(codCliente);
           set('frmFormulario.txtCodigoCliente', codigoCompleto);
        }
    }
       
    function validarLongCodCliene(codCliente) {
        var longiCod = get('frmFormulario.hLongitudCodCliente');
        var faltantes = longiCod -  codCliente.length;
        var resultCod = new String("");
        if(faltantes > 0){
           for(var t = 0 ; t<faltantes; t++){
              resultCod = resultCod + "0";
           }
           resultCod = resultCod + codCliente;
           return resultCod;
        }
        return codCliente;
    }
  