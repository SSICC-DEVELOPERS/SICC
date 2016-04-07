var formName 			= 'frmContenido.';
    //var casoDeUso;

    
  function onLoadPag()   {

    configurarMenuSecundario("frmContenido");
    
    DrdEnsanchaConMargenDcho('listado1',22);
    DrdEnsanchaConMargenDcho('listado2',22);
    DrdEnsanchaConMargenDcho('listado3',22);
    
    //document.all["primera1Div"].style.visibility='';
    //document.all["ret1Div"].style.visibility='';
    //document.all["ava1Div"].style.visibility='';
    
   // document.all["primera2Div"].style.visibility='';
   // document.all["ret2Div"].style.visibility='';
   // document.all["ava2Div"].style.visibility='';
    
  //  document.all["primera3Div"].style.visibility='';
  //  document.all["ret3Div"].style.visibility='';
   // document.all["ava3Div"].style.visibility='';

    eval (ON_RSZ);  
    varNoLimpiarSICC=true;
    if (get('frmContenido.casoDeUso') == "Modificar Condicion"){
        document.all["SalirCondicionDiv"].style.visibility='hidden';
		  btnProxy(7,"0");
		  btnProxy(8,"0");
		  btnProxy(9,"0");
    } 

    focaliza('frmContenido.cbIndicadorCuadre','');

    set('frmContenido.cbIndicadorCuadre', get('frmContenido.hidIndicadorCuadre'));
    set('frmContenido.cbCatalogo', get('frmContenido.hidDesCatalogo'));
    
    set('frmContenido.txtPaginaDesde', get('frmContenido.hidPaginaDesde'));
    set('frmContenido.txtPaginaHasta',get('frmContenido.hidPaginaHasta'));
    set('frmContenido.txtFactorCuadre',get('frmContenido.hidFactorCuadre'));
    
    checked= get(formName + 'hidcheckExcluirPagina')==""?"N":get(formName + 'hidcheckExcluirPagina');
    set(formName + 'checkExcluirPagina',checked);

    checked= get(formName + 'hidcheckExcluirLineaProd')==""?"N":get(formName + 'hidcheckExcluirLineaProd');
    set(formName + 'checkExcluir1',checked);

    checked= get(formName + 'hidcheckExcluirProducto')==""?"N":get(formName + 'hidcheckExcluirProducto');
    set(formName + 'checkExcluir2',checked);

    inicializarCombos();
    
   }

    function buscarLineaProductos()   {
        //Tomo los valores de los controles
        setMV('frmContenido.cbIndicadorCuadre','N');
        setMV('frmContenido.txtFactorCuadre','N');
        setMV('frmContenido.cbCatalogo','N');
        TomarDatosPantalla();
       
        set('frmContenido.accion','Buscar lineas productos');
        enviaSICC('frmContenido');
    }

    function buscarProducto()   {
        //incidencia 10341 (obligat campo por incoherencia)
        if(!sicc_validaciones_generales("grgral")){
        return false;
        }          
        setMV('frmContenido.cbIndicadorCuadre','N');
        setMV('frmContenido.txtFactorCuadre','N');
        setMV('frmContenido.cbCatalogo','N');
        TomarDatosPantalla();
        set('frmContenido.accion','Buscar producto');
        enviaSICC('frmContenido');
    }

	function TomarDatosPantalla(){
      set('frmContenido.hOidCatalogo',get('frmContenido.cbCatalogo','V'));
      set('frmContenido.hidDesCatalogo',get('frmContenido.cbCatalogo','T'));
      set('frmContenido.hidIndicadorCuadre',get('frmContenido.cbIndicadorCuadre','V'));

      set('frmContenido.hidFactorCuadre',get('frmContenido.txtFactorCuadre'));
      set('frmContenido.hidPaginaDesde', get('frmContenido.txtPaginaDesde'));
      set('frmContenido.hidPaginaHasta', get('frmContenido.txtPaginaHasta'));
        
      set('frmContenido.hidcheckExcluirPagina', get('frmContenido.checkExcluirPagina'));
      set('frmContenido.hidcheckExcluirLineaProd', get('frmContenido.checkExcluir1'));
      set('frmContenido.hidcheckExcluirProducto', get('frmContenido.checkExcluir2'));
	}

    function accionEliminarLineasProductos (){
              setMV('frmContenido.cbIndicadorCuadre','N');
          setMV('frmContenido.txtFactorCuadre','N');
        setMV('frmContenido.cbCatalogo','N');
        //Comprobar que se ha seleccionado al menos una linea 
        //Si no, muestra el mensaje PRE-0013 
        if (listado1.numSelecc() > 0)
        {
            var strV;
            strV = tomarInfoListaProductos( listado1 );
            set('frmContenido.hLineaProductosSeleccionados', strV);

            set('frmContenido.accion','Eliminar lineas producto');
            enviaSICC('frmContenido');
        }
        else
            GestionarMensaje('13');
    }

    function accionEliminarProductos(){
              setMV('frmContenido.cbIndicadorCuadre','N');
          setMV('frmContenido.txtFactorCuadre','N');
        setMV('frmContenido.cbCatalogo','N'); 
        //Comprobar que se ha seleccionado al menos una linea 
        //Si no, muestra el mensaje PRE-0013 
        if (listado2.numSelecc() > 0)
        {
            var strV;
            strV = tomarInfoListaProductos( listado2 );
            set('frmContenido.hProductosSeleccionados', strV);

            set('frmContenido.accion','Eliminar productos');
            enviaSICC('frmContenido');
        }
        else
            GestionarMensaje('13');
    }
    function mostrarMensajeNumerico(campo){
          var msg = sicc_obtenerDescripcion(campo);
          focaliza("frmContenido."+campo);
          cdos_mostrarAlert(GestionarMensaje("000000000000100" ,  "\""+msg+"\""));
    }
    
    function accionAniadirCondicion(){
          setMV('frmContenido.cbIndicadorCuadre','N');
          setMV('frmContenido.txtFactorCuadre','N');
          /*var validar1 = esNumero(get('frmContenido.txtPaginaDesde'));
          if( validar1 != 'OK'){
            mostrarMensajeNumerico("txtPaginaDesde");
            return false;
          }
          var validar2 = esNumero(get('frmContenido.txtPaginaHasta'));
          if( validar2 != 'OK'){
            mostrarMensajeNumerico("txtPaginaHasta");
            return false;
          }*/
		  if (get('frmContenido.txtPaginaHasta')!='')
		  {		  
			  if(!sicc_validaciones_generales("nros")){
				  return false;
			  }
		  }
		  if (get('frmContenido.txtPaginaHasta')!=''&&get('frmContenido.txtPaginaDesde')=='')
		  {		  
			  if(!sicc_validaciones_generales("grpags")){
				  return false;
			  }
		  }
		  if (get('frmContenido.txtPaginaDesde')!='')
		  {		  
			  if(!sicc_validaciones_generales("grpags")){
				  return false;
			  }
		  }
          if(!sicc_validaciones_generales("grgral")){
          return false;
          }
          
          if((listado1.datos.length <= 0) && 
             (listado2.datos.length <= 0) && 
             (get('frmContenido.txtPaginaDesde')=='')){
             //Hay que mostrar el mensaje de que debo definir alguna condicion.
             GestionarMensaje('220');
          } else {
             //=> puedo aniadir
             
            set('frmContenido.hidIndicadorCuadre',get('frmContenido.cbIndicadorCuadre','V'));
            set('frmContenido.hidFactorCuadre',get('frmContenido.txtFactorCuadre'));
            
            set('frmContenido.hidcheckExcluirPagina', get('frmContenido.checkExcluirPagina'));
            set('frmContenido.hOidCatalogo',get('frmContenido.cbCatalogo','V'));
            set('frmContenido.hidDesCatalogo', get('frmContenido.cbCatalogo','T'));
            set('frmContenido.hidPaginaDesde', get('frmContenido.txtPaginaDesde'));
            set('frmContenido.hidPaginaHasta', get('frmContenido.txtPaginaHasta'));
            
            set('frmContenido.hidcheckExcluirLineaProd', get('frmContenido.checkExcluir1'));
            marcaSeleccion(listado1);
            strV = tomarInfoListaProductos( listado1 );
            set('frmContenido.hLineaProductosSeleccionados', strV);


            set('frmContenido.hidcheckExcluirProducto', get('frmContenido.checkExcluir2'));
            marcaSeleccion(listado2);
            strV =  tomarInfoListaProductos( listado2 );
            set('frmContenido.hProductosSeleccionados', strV);

            set('frmContenido.accion','Anadir condicion');
            enviaSICC('frmContenido');
          }
    }
    
    function accionEliminarLineasCondicion(){
        setMV('frmContenido.cbCatalogo','N');
        setMV('frmContenido.cbIndicadorCuadre','N'); 
        setMV('frmContenido.txtFactorCuadre','N'); 	        
        //Comprobar que se ha seleccionado al menos una linea 
        //Si no, muestra el mensaje PRE-0013 
        if (listado3.numSelecc() > 0) {
            var strV;
            strV = tomarInfoListaProductos( listado3 );
            setMV('frmContenido.cbIndicadorCuadre','N'); 
            setMV('frmContenido.txtFactorCuadre','N'); 
            set('frmContenido.hLineasCondicionSeleccionadas', strV);
            set('frmContenido.accion','Eliminar lineas condicion');
            enviaSICC('frmContenido');
        } else GestionarMensaje('13');
    }

    function accionGuardar(){
          setMV('frmContenido.cbCatalogo','N'); 
          if(!sicc_validaciones_generales("grinicial")){
          return false;
          }
			if (get('frmContenido.cbIndicadorCuadre','V')=='1') {//Por Unidades
				if(!sicc_validaciones_generales("grinicialfc")){
					return false;
				}
			} else {//Por Monto se permite decimales
				if(!sicc_validaciones_generales("grinicialfcd")){
					return false;
				}
			}
         if(listado3.datos.length >0 ){
            set('frmContenido.hidFactorCuadre',get('frmContenido.txtFactorCuadre'));
            set('frmContenido.hidIndicadorCuadre',get('frmContenido.cbIndicadorCuadre','V'));
            set('frmContenido.hidDesIndCuadre',get('frmContenido.cbIndicadorCuadre','T'));            
        
            set('frmContenido.accion','Guardar');
            enviaSICC('frmContenido');
        } else GestionarMensaje('220');
    }

    function accionSalirDefinirCondicion (){
      /*Se le saca la obligatoriedad a los campos obligatorios por maqueta*/
        setMV('frmContenido.cbCatalogo','N'); 
        setMV('frmContenido.cbIndicadorCuadre','N'); 
        setMV('frmContenido.txtFactorCuadre','N'); 	

        set('frmContenido.accion','Finalizar');
        enviaSICC('frmContenido');
    }

    function fGuardar(){
        accionGuardar();
    }

    function fBorrar(){
        if (listado1.numSelecc() > 0) {
            accionEliminarLineasProductos();
            return true;   
        }        
        if (listado2.numSelecc() > 0){
            accionEliminarProductos();
            return true;
        }                
        if (listado3.numSelecc() > 0){
            accionEliminarLineasCondicion();
            return true;
        }
    }

    function fLimpiar(){
	     if (get('frmContenido.casoDeUso') == "Modificar Condicion")
	         setMV('frmContenido.cbCatalogo','N');
            setMV('frmContenido.cbIndicadorCuadre','N'); 
            setMV('frmContenido.txtFactorCuadre','N'); 	
        
        document.all.tags("INPUT").checkExcluirPagina[0].checked=false;
        document.all.tags("INPUT").checkExcluir1[0].checked=false;
        document.all.tags("INPUT").checkExcluir2[0].checked=false;
        focaliza('frmContenido.cbIndicadorCuadre','');
            set('frmContenido.accion','');
            enviaSICC('frmContenido');        
        
    }

    function inicializarCombos(){
        array = new Array();
        array[0] = get('frmContenido.hOidCatalogo');
        set('frmContenido.cbCatalogo',array);

        if (get('frmContenido.hidHabilitaCatalogo')=='N'){
          accion('frmContenido.cbCatalogo','.disabled=true');
        } else {
          accion('frmContenido.cbCatalogo','.disabled=false');
        }

        array = new Array();
        array[0] = get('frmContenido.hidIndicadorCuadre');
        set('frmContenido.cbIndicadorCuadre',array);
    }

    function tomarInfoListaProductos(listadoConSeleccion){
        // Tomar todos los valores seleccionados y meterlos en un array
        if (listadoConSeleccion.datos.length > 0){
            var strV = '';
            var codigo = new Array();
            
            codigo = listadoConSeleccion.codSeleccionados();
            
            for(i=0;i<listadoConSeleccion.codSeleccionados().length;i++) {
                strV += codigo[i] + ';' +                
                listadoConSeleccion.extraeDato(listadoConSeleccion.codSeleccionados()[i], 0) +
                ';'+ listadoConSeleccion.extraeDato(listadoConSeleccion.codSeleccionados()[i], 1);
                if (i<listadoConSeleccion.codSeleccionados().length)
                    strV += '|';
            }
            return strV;
        }
        return '';
    }
    
    function accionAniadirCondicion2 (){

        var bExcluirPaginas;
        var bExcluirLineasProd;
        var bExcluirProductos;
        var bValidado = true;
        
        bExcluirPaginas = get('frmContenido.checkExcluirPagina','V');
        bExcluirLineasProd = get('frmContenido.checkExcluir1','V');
        bExcluirProductos = get('frmContenido.checkExcluir2','V');

        if  (esNumero ( get('frmContenido.txtFactorCuadre'))!= 'OK' ){
          GestionarMensaje('2560');
          focaliza('frmContenido.txtFactorCuadre');
          return;
        }

        if  (esNumero ( get('frmContenido.txtPaginaDesde'))!= 'OK' ){
          GestionarMensaje('2562');
          focaliza('frmContenido.txtPaginaDesde');
          return false
        }


        if  (esNumero ( get('frmContenido.txtPaginaHasta'))!= 'OK' ) {
          GestionarMensaje('2563');
          focaliza('frmContenido.txtPaginaHasta');
          return false
        }
	
        if(fValidarCOMBO('frmContenido.cbCatalogo') &&
		       ((listado1.datos.length > 0) || (listado2.datos.length > 0))    ||
           (fValidarCTEXT('frmContenido.txtPaginaDesde')&&fValidarCTEXT('frmContenido.txtPaginaHasta'))){
            var strV;

            set('frmContenido.hidIndicadorCuadre',get('frmContenido.cbIndicadorCuadre','V'));
            set('frmContenido.hidFactorCuadre',get('frmContenido.txtFactorCuadre'));
            
//            if (bExcluirPaginas == 'N')
            {
                set('frmContenido.hidcheckExcluirPagina', get('frmContenido.checkExcluirPagina'));
                set('frmContenido.hOidCatalogo',get('frmContenido.cbCatalogo','V'));
                set('frmContenido.hidDesCatalogo', get('frmContenido.cbCatalogo','T'));
                set('frmContenido.hidPaginaDesde', get('frmContenido.txtPaginaDesde'));
                set('frmContenido.hidPaginaHasta', get('frmContenido.txtPaginaHasta'));
            }
            
//            if (bExcluirLineasProd == 'N')
            {
                set('frmContenido.hidcheckExcluirLineaProd', get('frmContenido.checkExcluir1'));
            		marcaSeleccion(listado1);
                strV = tomarInfoListaProductos( listado1 );
                set('frmContenido.hLineaProductosSeleccionados', strV);
            }

//            if (bExcluirProductos == 'N')
            {
                set('frmContenido.hidcheckExcluirProducto', get('frmContenido.checkExcluir2'));
                marcaSeleccion(listado2);
                strV =  tomarInfoListaProductos( listado2 );
                set('frmContenido.hProductosSeleccionados', strV);
            }
            
            set('frmContenido.accion','Anadir condicion');
            enviaSICC('frmContenido');
        } else {
            GestionarMensaje('27');
        }
    }    
	function marcaSeleccion(listado)
	{
		var codigos = listado.codigos();

		for (var i = 0; i < codigos.length ; i++ ){
	      listado.seleccionaCod(codigos[i]) ;
		}
	}

	function foco2(opcion){
			if(opcion==1){
				if (get('frmContenido.casoDeUso') == "Modificar Condicion")
					focaliza("frmContenido.cbIndicadorCuadre");
				else focalizaBotonHTML('botonContenido','SalirCondicion');
			}
			if(opcion==2){
				if (get('frmContenido.casoDeUso') == "Modificar Condicion")
					focaliza("frmContenido.checkExcluir2");
				else focalizaBotonHTML('botonContenido','SalirCondicion');
			}

	}