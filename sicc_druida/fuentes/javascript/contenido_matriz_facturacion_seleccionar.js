 /**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
          var formName = "frmContenido";

    function muestraLista( ultima, rowset, error){
          var tamano = rowset.length;
          if (tamano > 0) {
              return true;
          } else {
              return false;
          }
    } 

    function carga(){
          var retorno;
          var flag1;
          var flag2;
          var parametro=get("frmContenido.hidParametro");
          switch (parametro) {
              case "S": 
                    retorno = GestionarMensaje('1026');
                    if (retorno){
                         flag1= true;
                         retorno = GestionarMensaje('1027'); 
                         if (retorno){
                              flag2=true;
                              set("frmContenido.conectorAction","LPEliminarMF"); 
                              set("frmContenido.flag_1",flag1); 
                              set("frmContenido.flag_2",flag2); 
                              set("frmContenido.accion","MatrizYOfertas"); 
                              set("frmContenido.conexion","true"); 
                              enviaSICC ("frmContenido");
                              return false;
                         }else{
                              set("frmContenido.conectorAction","LPEliminarMF"); 
                              set("frmContenido.flag_1",flag1); 
                              set("frmContenido.flag_2",flag2); 
                              set("frmContenido.accion","Matriz"); 
                              set("frmContenido.conexion","true"); 
                              enviaSICC ("frmContenido");
                              return false;
                         }
                    }else{
                    }
                    break;
              case "E":             
                    retorno = GestionarMensaje('1028'); 
                    break;
          }
          return true;
    }

    function onLoadPag()   {
          if (carga()){    
              DrdEnsanchaConMargenDcho('listado1',12);
              DrdEnsanchaConMargenDcho('listado2',12);
              eval (ON_RSZ);
              ON_RSZ = '';
              configurarMenuSecundario('frmContenido');
              configurarPaginado(mipgndo2,'PREBuscarMatricesActualesYFuturas','ConectorBuscarMatrices',
                    'es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion', armarArray());
                
              if (get('frmContenido.hidOcultarNueva') == 'NO') {
                    document.all['NuevaDiv'].style.visibility='visible';
                    document.all['Nueva'].focus();
              } else {
                    document.all['NuevaDiv'].style.visibility='hidden';
                    document.all['Anteriores'].focus();
              }
              
              setearMatrizSeleccionada();              
              fMostrarMensajeError();
              
          }      
		  if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
		  }
    }

    function armarArray(){
          var hh = new Array();
          hh[0] = new Array('oidIdioma','1');
          return hh;
    }

    function fVolver() {
           window.close();
     } 

    // Funcion ejecutada al presionar el boton seleccionar
    function accionSeleccionaMatriz(){
          if (setFilaSeleccion()) {
              hidOcultarNueva = 'SI';
              set('frmContenido.conectorAction', 'LPSeleccionarMF');
              set('frmContenido.accion', 'Matriz seleccionada');
              enviaSICC('frmContenido');
          }else
              ShowError(1);
    }

    function setearMatrizSeleccionada(){
          if (listado1.numSelecc() <= 0){    
              var pais = get('frmContenido.hidDesPaisSelec');
              var marca = get('frmContenido.hidDesMarcaSelec');
              var canal = get('frmContenido.hidDesCanalSelec');
              var periodo = get('frmContenido.hidDesPeriSelec');
                      
              if (pais != '' && marca!= '' && canal!= '' && periodo!= ''){
                    var nuevos_datos = new Array();
                    var oid = get('frmContenido.hidOidCabeceraMF');
                    var cod_marca = get('frmContenido.hidCodMarcaSelec');
                    var cod_canal = get('frmContenido.hidCodCanalSelec');
                    var cod_periodo = get('frmContenido.hidCodPeriSelec');
    
                    nuevos_datos[0] = [oid, pais, marca, canal, periodo];
                      
                    listado1.setDatos(nuevos_datos);                      
              }
          }
    }

    function onShTabBotonNueva() {
      document.all['Seleccionar'].focus();
    }

    function onShTabBotonAterior() {
      if (document.all['NuevaDiv'].style.visibility == 'visible') {
          document.all['Nueva'].focus();
      } else {
          document.all['Seleccionar'].focus();
      }
    }

    function onTabBotonSeleccionar() {
      if (document.all['NuevaDiv'].style.visibility == 'visible') {
          document.all['Nueva'].focus();
      } else {
          document.all['Seleccionar'].focus();
      }
    }
  
    function showError(){
          if(get('frmContenido.hidError') == "PRE0012"){
              GestionarMensaje('1028');
          }else if (get('frmContenido.errCodigo') != ''){          
              fMostrarMensajeError();
              set("frmContenido.conectorAction", "LPEliminarMF");
              set("frmContenido.accion", "");
              enviaSICC("frmContenido");                      
          }
    }

    function ShowError(codigoError){
          if (codigoError == 1){                
                              GestionarMensaje('41');
          }
    } 

    function accionPulsaNueva(){
          set('frmContenido.conectorAction', 'LPSeleccionarNuevaMF');
          set('frmContenido.accion', 'Matriz seleccionada');
          //set('frmContenido.accion', '');
          enviaSICC('frmContenido');
    }

    function accionPulsaAnterior(){
          configurarPaginadoExt(mipgndo2,'PREBuscarMatricesAnteriores','ConectorBuscarMatrices',
          'es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion', armarArray(),0 ,20);
    }

    function setFilaSeleccion() {
          if(listado1.numSelecc() <= 0 && listado2.numSelecc() <= 0){
              return false;
          }

          if(listado1.numSelecc() > 0 && listado2.numSelecc() > 0){
              return false;
          }

          if (listado2.numSelecc() > 0){
              var codigo = listado2.codSeleccionados();
              set('frmContenido.hidOidCabeceraMF', codigo)
              set('frmContenido.hidDesPaisSelec', listado2.extraeDato(listado2.codSeleccionados()[0], 0));
              set('frmContenido.hidDesMarcaSelec',listado2.extraeDato(listado2.codSeleccionados()[0], 1));
              set('frmContenido.hidDesCanalSelec',listado2.extraeDato(listado2.codSeleccionados()[0], 2));
              set('frmContenido.hidDesPeriSelec', listado2.extraeDato(listado2.codSeleccionados()[0], 3));
              return true
          }

          if (listado1.numSelecc() > 0){
              var codigo = listado1.codSeleccionados();
              set('frmContenido.hidOidCabeceraMF', codigo)
              set('frmContenido.hidDesPaisSelec', listado1.extraeDato(listado1.codSeleccionados()[0], 0));
              set('frmContenido.hidDesMarcaSelec',listado1.extraeDato(listado1.codSeleccionados()[0], 1));
              set('frmContenido.hidDesCanalSelec',listado1.extraeDato(listado1.codSeleccionados()[0], 2));
              set('frmContenido.hidDesPeriSelec', listado1.extraeDato(listado1.codSeleccionados()[0], 3));
              return true;
          }
          return true;
    }

