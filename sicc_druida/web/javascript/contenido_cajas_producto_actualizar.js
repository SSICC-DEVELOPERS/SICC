function onLoad(){  
	
    configurarMenuSecundario('formulario');
    
    fMostrarMensajeError();

	txt_to('Descripcion', get('formulario.hDescProd'));
	
	focaliza("formulario.txtCantSacada"); 

  
}

function onClickAceptar(){
    if(sicc_validaciones_generales("gAceptar")){
    
        unidadesLP = Number(get('formulario.hUnidadesListaPicado'));
        unidadesCaja = Number(get('formulario.txtCantSacada'));
        
        oidCodigoError = ""; 
        codigoError = "";
        
        // Faltan productos
        if(unidadesLP > unidadesCaja){
            // ¿Hay {0} faltantes. ¿Confirma?
            if(GestionarMensaje("APEUI054", (unidadesLP-unidadesCaja), null, null)){
            
                if(unidadesCaja==0){
                    oidCodigoError = get('formulario.OID_ERROR_FALTANTE_FACTURADO'); 
                    codigoError = get('formulario.COD_ERROR_FALTANTE_FACTURADO');
                } else {
                    oidCodigoError = get('formulario.OID_ERROR_FALTANTE_CANTIDAD'); 
                    codigoError = get('formulario.COD_ERROR_FALTANTE_CANTIDAD');
                }
            } else {
                return;
            }
        }
        
        // Hay mas productos que los solicitados
        if(unidadesLP < unidadesCaja){
            // ¿Hay {0} faltantes. ¿Confirma?
            if(GestionarMensaje("APEUI055", (unidadesCaja - unidadesLP), null, null)){
            
              oidCodigoError = get('formulario.OID_ERROR_SOBRANTE_CANTIDAD'); 
              codigoError = get('formulario.COD_ERROR_SOBRANTE_CANTIDAD');
                
            } else {
                return;
            }
        }
        
        var retorno = new Array();
        retorno[0] = unidadesCaja;
        retorno[1] = oidCodigoError;
        retorno[2] = codigoError;
        
        returnValue = retorno;
        close();   
    }
}

function fVolver(){
  close();
}

function isEnter(){

	if (event.keyCode == 13){
			onClickAceptar();
	}

}

function fLimpiar(){
    
    txt_to('Descripcion', get('formulario.hDescProd'));
    set('formulario.txtCantSacada','');
    
    focaliza("formulario.txtCantSacada"); 
}

function focalizaBoton(){
    focalizaBotonHTML('botonContenido','btnAceptar');
}

function focalizaCampo(){
    focaliza("formulario.txtCantSacada"); 
}
