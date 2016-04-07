function enviaFormulario() {
	// Primero chequea que las tres cajas de texto contengan un valor.
	var txtDiasCambio = get("frmConfigurarClaveSeguridad.txtDiasCambio");
	var txtNumRepeticiones = get("frmConfigurarClaveSeguridad.txtNumRepeticiones");
	var txtLongMinima= get("frmConfigurarClaveSeguridad.txtLongMinima");
	var txtNumMaxIntentos = get("frmConfigurarClaveSeguridad.txtNumMaxIntentos");
	//alert("txtNumMaxIntentos: " + txtNumMaxIntentos);

	// Si las 4 cajas de texto tienen algo, chequea el formato de las mismas.

  if (!sicc_validaciones_generales()) {
			return;
  }

	// Si todo pasó bien, entonces llama a la LP.

	set("frmConfigurarClaveSeguridad.accion", "guardar");
 
  eval("frmConfigurarClaveSeguridad").oculto="S";
	enviaSICC("frmConfigurarClaveSeguridad");
  eval("frmConfigurarClaveSeguridad").oculto="N";
  
  focaliza('frmConfigurarClaveSeguridad.txtDiasCambio');
}


function focalizaComponente() {   
   document.selection.empty();
   focaliza('frmConfigurarClaveSeguridad.txtDiasCambio');       
}


function focalizaComponenteShift() {    
    document.selection.empty();
	focaliza('frmConfigurarClaveSeguridad.txtNumMaxIntentos');       
}


function fnErrores(){
	configurarMenuSecundario("frmConfigurarClaveSeguridad");
	var msg = get("frmConfigurarClaveSeguridad.mensaje");

	if(msg!=null && msg!=''){
		GestionarMensaje(msg);
		return;
	}
	else{
		var codigo = get("frmConfigurarClaveSeguridad.errCodigo");
		var descripcion = get("frmConfigurarClaveSeguridad.errDescripcion");

		if(descripcion!=null && descripcion!='' )
			{
				if(fMostrarMensajeError(codigo,descripcion)==0){
					postForm();
			}
		}
		else if (codigo!=null && descripcion!=null &&
			codigo=='' && descripcion!='')
			{
				if(descripcion.substr(0,4)=="ERR_")
				{
					var errNums = descripcion.split("_");
					var txtDescrip = null; 

					if ( descripcion.split("_")[2]!=null) {
						txtDescrip = GestionarMensaje(errNums[1],errNums[2],null,null);		
					}
					else{					
						txtDescrip = GestionarMensaje(errNum[1],"",null,null);
					}
										
					if(errNums[1]=="52"){
						configurarMenuSecundario("frmConfigurarClaveSeguridad");
					}
					
					descripcion=txtDescrip;
					if(fMostrarMensajeError(codigo,descripcion)==0){
						postForm();
					}
				}				
			}
	}
	focaliza("frmConfigurarClaveSeguridad.txtDiasCambio");
}


function fGuardar() {
	enviaFormulario();
}


function fLimpiar() {
	set("frmConfigurarClaveSeguridad.accion", "");

	var txtDiasCambio = get("frmConfigurarClaveSeguridad.hidDiasCambio");
	var txtNumRepeticiones = get("frmConfigurarClaveSeguridad.hidNumRepeticiones");
	var txtLongMinima= get("frmConfigurarClaveSeguridad.hidLongMinima");
	var txtNumMaxIntentos = get("frmConfigurarClaveSeguridad.hidNumMaximoIntentos");
  
  eval("frmConfigurarClaveSeguridad").oculto="N";
	//enviaSICC("frmConfigurarClaveSeguridad");
  focaliza('frmConfigurarClaveSeguridad.txtDiasCambio');
}

function fSeteoCajas(parDiasDeCambio, parNumRepeticiones, parLongMinima, parNumMaxIntentos) {

  set("frmConfigurarClaveSeguridad.txtDiasCambio", parDiasDeCambio);
	set("frmConfigurarClaveSeguridad.txtNumRepeticiones", parNumRepeticiones);
	set("frmConfigurarClaveSeguridad.txtLongMinima", parLongMinima);
	set("frmConfigurarClaveSeguridad.txtNumMaxIntentos", parNumMaxIntentos);
  
	set("frmConfigurarClaveSeguridad.hidDiasCambio", parDiasDeCambio);
	set("frmConfigurarClaveSeguridad.hidNumRepeticiones", parNumRepeticiones);
	set("frmConfigurarClaveSeguridad.hidLongMinima", parLongMinima);
	set("frmConfigurarClaveSeguridad.hidNumMaximoIntentos", parNumMaxIntentos);

  eval("frmConfigurarClaveSeguridad").oculto="N";
  focaliza('frmConfigurarClaveSeguridad.txtDiasCambio');
}

function errorGrabacion() {
  eval("frmConfigurarClaveSeguridad").oculto="N";
  focaliza('frmConfigurarClaveSeguridad.txtDiasCambio');
}
