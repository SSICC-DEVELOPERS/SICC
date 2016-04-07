var FORMULARIO = 'frmFormulario';

function onLoadPag(){
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if(errDescripcion != ''){
         var errCodigo = get(FORMULARIO +'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo,errDescripcion);
    }
    
    configurarMenuSecundario(FORMULARIO);

	focaliza(FORMULARIO +'.cbSociedad');	
}

function accionAceptar(){
	set(FORMULARIO + '.accion','recepcionar');
    set(FORMULARIO + '.conectorAction',"LPHIP");
    enviaSICC(FORMULARIO);
}

function focalizaBoton(){
	document.all['btnAceptar'].focus();
}

function focalizaSociedad(){
	focaliza(FORMULARIO +'.cbSociedad');	
}

function fLimpiar(){
	set(FORMULARIO +'.areatxtObservaciones','');
	focaliza(FORMULARIO +'.cbSociedad');
}

function sociedadOnChange(){
	set(FORMULARIO +'.oidSociedad',get(FORMULARIO +'.cbSociedad'));	
}

function Correcto(){
	var formulario = getFormularioSICC();
    set(formulario+".conectorAction","LPInicioBelcorp");
    set(formulario+".accion","");
    try{
             parent.frames['menu'].location.reload();
             parent.frames["iconos"].mostrarCapa();
    }catch(e){}
    eval(formulario).oculto = 'N';
    enviaSICC(formulario,'','','N');	
}