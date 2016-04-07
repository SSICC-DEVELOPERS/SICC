// fichero.js
// $Id: fichero.js,v 1.1 2009/12/03 19:03:48 pecbazalar Exp $

//function Fichero(nombre,form_nsdoc,campo_destino) {
function Fichero(nombre,campo_destino) {
	this.nombre=nombre;
	//this.form_nsdoc=form_nsdoc; // nombre formulario que incluye el FILE
	this.campo_destino=campo_destino; // 'form.campo' en el que se escribe el nombre del fichero a la vuelta
	this.ventana=null;
	this.isFunction=false;
	this.onSubmit=null;
	this.submit=Fichero_submit;
	this.onload=Fichero_onload;
	this.reset=Fichero_reset;
   this.init=Fichero_init;
	this.focaliza=Fichero_focaliza;
	this.focalizaFinal=Fichero_focalizaFinal;
   }

function Fichero_init() {
   //this.formulario=ns?eval(this.form_nsdoc):eval('document.'+this.nombre+'_form');
   this.formulario=eval('document.'+this.nombre+'_form');
   }

function Fichero_submit() {
	var formulario=this.formulario;
	if (formulario.archivoPrincipal.value=='') {
		muestraMsgError(DrdMsgCore(196));return;
		}
	if (this.onSubmit!=null) {
		var file=formulario.archivoPrincipal.value;
		if (eval(this.onSubmit)==false) return;
	   }
	this.ventana=window.open('','ventanaFichero'+this.nombre,'toolbar=0,directories=0,height=100,width=100,location=0,personalbar=0,resizable=0,titlebar=no,scrollbars=0,status=0,top=2000,left=2000');
	this.ventana.blur();
	formulario.target='ventanaFichero'+this.nombre;
	formulario.submit();

	if (window.ocupado_fichero) {d3ocupado_ver('d3general',d3ocupado_general);} 
   }

// if no existe error, entonces msgError=''
// file: nombre del fichero guardado en el servidor
function Fichero_onload(msgError,file) {
	if (msgError!='') {
			muestraMsgError(msgError);
			//alert(msgError);
			}
	else {
		if (this.isFunction) {eval(this.campo_destino);}
		else {set(this.campo_destino,file);}
	}
	this.ventana.close();
	if (window.ocupado_fichero) {d3ocupado_ocultar('d3general');} 
}


function Fichero_reset() {
	/*if (ns) {
      this.formulario.reset();
      }
	else {*/
      var vvv=this.formulario.archivoPrincipal.outerHTML;
      this.formulario.archivoPrincipal.outerHTML=vvv;
/*       } */
      
   }


function Fichero_focaliza()   {//Focaliza el componente
   this.formulario.archivoPrincipal.focus()
   }

function Fichero_focalizaFinal()   {//Manda el foco al final del componente (ultimo boton)
   if (this.formulario.boton_reset) {//timeout arregla: No se puede anular el evento y el foco salta 2 veces
      setTimeout( this.nombre+".formulario.boton_reset.focus()" ,1);
      }
   else  {
      setTimeout( this.nombre+".formulario.boton_ok.focus()" ,1);
      }
   }



function onKeyDownFicheroReadOnly(obj) {//Esta funcion no pertenece a la 'clase' fichero
   if (!ie) {
      obj.blur();
      return;
      }
   if (event.keyCode==16 || event.keyCode==9 || event.keyCode==13) //Salvo que sea para tabular ...
   	return true;
   obj.click();
   obj.blur();
   }

