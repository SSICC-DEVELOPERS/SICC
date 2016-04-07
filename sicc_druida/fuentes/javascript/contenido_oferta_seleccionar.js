function onLoadPag()   {
        ocultarLista();
        configurarMenuSecundario("frmmatrizfacturacionconsultar");
	     if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
        }
        focaliza("frmmatrizfacturacionconsultar.txtCodigoSAP"); 
        DrdEnsanchaConMargenDcho('listado1',12);
        eval (ON_RSZ);  
    }

	 function fVolver() {
           window.close();
     } 

    function ocultarLista() {
        //Al principio se debe ocultar la lista
        document.all["Cplistado1"].style.visibility='hidden'; 
        document.all["primera1Div"].style.visibility='hidden';
        document.all["separaDiv"].style.visibility='hidden';
        document.all["ret1Div"].style.visibility='hidden'; 
        document.all["ava1Div"].style.visibility='hidden';   
        document.all["CosultarDiv"].style.visibility='hidden';
        document.all["ModificarDiv"].style.visibility='hidden'; 
        document.all["CpLin1listado1"].style.visibility='hidden';
        document.all["CpLin2listado1"].style.visibility='hidden' ;
        document.all["CpLin3listado1"].style.visibility='hidden' ;
        document.all["CpLin4listado1"].style.visibility='hidden';
    }


    function mostrarLista(ultima, rowset) {
        var tamano = rowset.length;
        if (tamano > 0) {
            //Al principio se debe ocultar la lista
            document.all["Cplistado1"].style.visibility='visible'; 
            document.all["primera1Div"].style.visibility='visible'; 
            document.all["ret1Div"].style.visibility='visible'; 
            document.all["ava1Div"].style.visibility='visible'; 
            document.all["separaDiv"].style.visibility='visible';
            document.all["CpLin1listado1"].style.visibility='visible'; 
            document.all["CpLin2listado1"].style.visibility='visible'; 
            document.all["CpLin3listado1"].style.visibility='visible'; 
            document.all["CpLin4listado1"].style.visibility='visible'; 
            if (get('frmmatrizfacturacionconsultar.tipoAccion')=='LPModificarOferta'){
                document.all["ModificarDiv"].style.visibility='visible';    
            }else{
                document.all["CosultarDiv"].style.visibility='visible';
            }
            return true;
        }else{
            ocultarLista();
            return false;
        }
    }

    function fLimpiar(){
        focaliza("frmmatrizfacturacionconsultar.txtCodigoSAP");  
    }

    function accionBuscar(){	
        var oid = get('frmmatrizfacturacionconsultar.hidOidCabeceraMF');
	
        var arr = new Array();
        var i = 0;

        arr[i] = ["oidIdioma", get('frmmatrizfacturacionconsultar.hIdioma')];
        i++;

        arr[i] = ["oidCabeceraMF", oid];
        i++;

        if ( (get('frmmatrizfacturacionconsultar.txtCodigoSAP')!="")  )
        {
            arr[i] = ["codSAP",fTrim(get('frmmatrizfacturacionconsultar.txtCodigoSAP'))];
            i++;
        }

		if ( (get('frmmatrizfacturacionconsultar.txtCodigoVta')!="")  )
        {
            arr[i] = ["codVta",fTrim(get('frmmatrizfacturacionconsultar.txtCodigoVta'))];
            i++;
        }


        if ( get('frmmatrizfacturacionconsultar.txtDescripcion')!="")
        {
          arr[i] = ["descripcionSAP",get('frmmatrizfacturacionconsultar.txtDescripcion')];
          i++;
        }

        if ( get('frmmatrizfacturacionconsultar.cbCatalogo')!="")
        {
          arr[i] =["oidCatalogo",get('frmmatrizfacturacionconsultar.cbCatalogo')];
          i++;
        }

        if(!sicc_validaciones_generales()){
        return false;
        }  

        if ( get('frmmatrizfacturacionconsultar.cbMarca')!="")
        {
          arr[i] = ["oidMarca",get('frmmatrizfacturacionconsultar.cbMarca')];
          i++;
        }

        if ( get('frmmatrizfacturacionconsultar.txtPaginadesde')!="")
        {
          arr[i] = ["paginaDesde",get('frmmatrizfacturacionconsultar.txtPaginadesde')];
          i++;
        }

        if ( get('frmmatrizfacturacionconsultar.txtPaginaHasta')!="")
        {
          arr[i] = ["paginaHasta",get('frmmatrizfacturacionconsultar.txtPaginaHasta')];
          i++;
        }

        if ( get('frmmatrizfacturacionconsultar.cbLineaProducto')!="")	
        {
          arr[i] = ["oidLineaProducto",get('frmmatrizfacturacionconsultar.cbLineaProducto')];
          i++;
        }

        if ( get('frmmatrizfacturacionconsultar.cbUnidadNegocio')!="")	
        {
          arr[i] = ["oidUnidadNegocio",get('frmmatrizfacturacionconsultar.cbUnidadNegocio')];
          i++;
        }

        if ( get('frmmatrizfacturacionconsultar.cbNegocio')!="")	
        {
          arr[i] = ["oidNegocio",get('frmmatrizfacturacionconsultar.cbNegocio')];
          i++;
        }

        if ( get('frmmatrizfacturacionconsultar.cbGenerico')!="")	
        {
          arr[i] = ["oidGenerico",get('frmmatrizfacturacionconsultar.cbGenerico')];
              i++;
        }

        if ( get('frmmatrizfacturacionconsultar.cbSuperGenerico')!=""){            
          arr[i] = ["oidSupergenerico",get('frmmatrizfacturacionconsultar.cbSuperGenerico')];            
          i++;
        }

        if ( get('frmmatrizfacturacionconsultar.cbEstrategia')!=""){            
			//obtenemos los oids multiselección de cbGrupoDeZonasSeleccionados
			var arrOidsEstrategias = get('frmmatrizfacturacionconsultar.cbEstrategia');
			var stringArrOidsEstrategias = arrOidsEstrategias.join();
			if (stringArrOidsEstrategias.substring(0,1) == ',') {
				stringArrOidsEstrategias = stringArrOidsEstrategias.substring(1,stringArrOidsEstrategias.length-1);
			}
			arr[i] = ["oidsEstrategias", stringArrOidsEstrategias];            
			i++;
		}
		
		configurarPaginado(mipgndo,"PREBuscarOfertas","ConectorBuscarOfertas","es.indra.sicc.dtos.pre.DTOEBuscarOfertas", arr);	
        //mostrarLista();
    }


    function accionConsultar(){
        var codigos = new Array();
        codigos = listado1.codSeleccionados();
        var cant = codigos.length;
        if (cant == 1){
            //obtiene valor matrizFacturada
            var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);        
            set("frmmatrizfacturacionconsultar.hidOidOferta",  listado1.datos[posicion][16]);
            var obj = new Object();
            obj.accion = "obtenerOferta";
            obj.hidOidOferta = get("frmmatrizfacturacionconsultar.hidOidOferta");
			mostrarModalSICC('LPConsultarOferta','obtenerOferta',obj,795,495);
        }else{
            var valo = GestionarMensaje('4', null, null, null);
        }
    }

    function accionModificar(){
        //obtiene oid seleccionado
        var codigos = new Array();
        codigos = listado1.codSeleccionados();
        var cant = codigos.length;

        //obtiene valor matrizFacturada
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
		
        if (cant == 1){
            set("frmmatrizfacturacionconsultar.hidMatrizFacturada", listado1.datos[posicion][14]);            
            set("frmmatrizfacturacionconsultar.hidOidOferta", listado1.datos[posicion][16]);
            set('frmmatrizfacturacionconsultar.conectorAction','LPModificarOferta' );
            set('frmmatrizfacturacionconsultar.accion','ObtenerOfertaModificacion');
            enviaSICC('frmmatrizfacturacionconsultar');
        }else{
            var valo = GestionarMensaje('4', null, null, null);
        }
    }

    function accionVolver(){
        if (frmmatrizfacturacionconsultar.accion.equals("Matriz seleccionada")){               
          set('frmmatrizfacturacionconsultar.conectorAction', 'LPConsultarOferta');
          set('frmmatrizfacturacionconsultar.accion','');
          enviaSICC('frmmatrizfacturacionconsultar');
        }
    }
    function tabGenerico(nombreComp, tipotab){       
            var arr = arrayComponentes();
            var tabular = false;
            var nombreFormulario = getFormularioSICC();
            var j = 0;
            var k = arr.length;
            if (tipotab != "sh") {
                j = j-1;                
                k = k-1;
            }

            while(j<k){
                var t;
                if(tipotab == "sh"){
                  k--;
                  t = k;
                } else{
                  j++;
                  t = j;                  
                }
                  
                var nombre = arr[t][0];
                var tipo = arr[t][1];
                if (tabular==false){
                  if (nombreComp==nombre){
                      tabular=true;
                      if (tipotab == "sh"){
                        if (k==0) k= arr.length;
                      } else {
                        if ((j+1)==arr.length)  j = -1;
                      }
                  }                
                } else {
                  try {
                    var name = nombreFormulario+"."+nombre;
                    if (tipo=="BOTONXY"){
                       focalizaBotonHTML_XY(nombre);
                    } else if (tipo=="BOTON") {
                       focalizaBotonHTML("botonContenido",nombre)
                    } else {
                       focaliza(name);
                    }
                    return;
                  } catch (e) {
                    if (tipotab == "sh") {if (k==0) k= arr.length;} else 
                    {if ((j+1)==arr.length)  j = -1;}                    
                  }
                }
            }
          }
         function arrayComponentes(){
              var arr = new Array();
              arr[arr.length]= new Array("txtCodigoSAP","");
              arr[arr.length]= new Array("cbSuperGenerico","");
              arr[arr.length]= new Array("btnBuscarProductos","BOTON");
              arr[arr.length]= new Array("Cosultar","BOTONXY");

              arr[arr.length]= new Array("Modificar","BOTONXY");                        
              
              return arr;
          }