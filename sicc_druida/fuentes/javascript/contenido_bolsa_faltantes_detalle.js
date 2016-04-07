   function onLoadPag()   
    {           
      DrdEnsanchaConMargenDcho('listado1',12); 
      configurarMenuSecundario("formulario");

      document.all["Cplistado1"].style.visibility=''; 
      document.all["CpLin1listado1"].style.visibility='';  
      document.all["CpLin2listado1"].style.visibility=''; 
      document.all["CpLin3listado1"].style.visibility='';
      document.all["CpLin4listado1"].style.visibility='';  
      
      document.all["primera1Div"].style.visibility='hidden'; 
      document.all["ret1Div"].style.visibility='hidden';
      document.all["ava1Div"].style.visibility='hidden';  
      document.all["separaDiv"].style.visibility='hidden'; 
      document.getElementById("cbCodMensaje").disabled = true;    
	  focaliza('formulario.ckComunicacion');
      eval (ON_RSZ);   
         
    }

	function onClickComunicacion(){
	/*Descripcion: este metodo activa el combo cbCodigoMensaje 
	Implementacion: si el CheckBox esta activo habilitar el combo cbCodigoMensaje sino deshabilitarlo.*/
		
		document.getElementById("cbCodMensaje").disabled  = (get('formulario.ckComunicacion')  == 'N')?true:false;
	}

	function accionAniadir(){
		
		if (sicc_validaciones_generales()) {
			var oid = get('formulario.cbProducto');
			var producto= get('formulario.cbProducto', 'T');
			var cantidad = get('formulario.txtCantidad');

			var dat = new Array();
			dat[0] = oid;
			dat[1] = producto;
			dat[2] = cantidad;

			listado1.insertar(dat);
			
			//Se limpian los campos
			set('formulario.cbProducto', '');
			set('formulario.txtCantidad', '');
			
		}
	}

	function onClickGuardar(){
		var descCodMensaje = get('formulario.cbCodMensaje', 'T');
		var valoresEditados = "inicial";

		if(get('formulario.ckComunicacion')=="S"){
			set('formulario.hDescCodMensaje', descCodMensaje);
		}
		else {
			set('formulario.hDescCodMensaje', "");
		}

		if(get('formulario.cbTipoCambio')==get('formulario.constSinPremio')){
			if(listado1.datos.length >0){
				if(GestionarMensaje('INC033')){
					valoresEditados = "";		
				}
				else {
					set('formulario.cbTipoCambio','');
					focaliza('formulario.cbTipoCambio');					
				}
			}
		}

		if(valoresEditados=="inicial") {
			if(listado1.datos.length >0){
				valoresEditados = tomaValoresEditadosLista();
			}
			else {
				valoresEditados = "";	
			}			
		}
		
		eval('formulario').oculto= "S";
		set('formulario.valoresListaEditable', valoresEditados); 
		set('formulario.accion', 'guardarProductosSustitutivos');
		enviaSICC('formulario');
	}
	
	function fGuardar(){
	  onClickGuardar();
	}

	function onClickBorrar(){
		listado1.eliminarSelecc();
	}
	
	function fBorrar(){
		onClickBorrar();
	}
	
	function tomaValoresEditadosLista(){
	  valoresConcatenados = "";
	  listado1.save();
	  var lista = listado1.datos; //Me devuelve una matriz con el contenido de la lista editable
	  var filas = listado1.datos.length;
	  var columnas = lista[0].length;
	  
	  for ( var i = 0; i < filas; i++) {
		for(var j=0;j<columnas;j++){
		  if(valoresConcatenados=="" || j==0) {
  			valoresConcatenados = valoresConcatenados + lista[i][j];
		  }
		  else {
			 valoresConcatenados = valoresConcatenados +","+ lista[i][j];
		  }
		}
		if (i!=filas-1){
			valoresConcatenados = valoresConcatenados + "|";
		}		  
	  }

	  return valoresConcatenados;
	}
	
	function fVolver(){
		window.close();
	}

	function reInicio(){
		fVolver();
	}

	function fErrorAlGuardarI(){
		focaliza('formulario.ckComunicacion');
	}

	function accionAsignarPremioConsuelo() {
		var parametros = new Object();
		mostrarModalSICC("LPAsignarPremiosConsuelo", "", parametros);
	}
