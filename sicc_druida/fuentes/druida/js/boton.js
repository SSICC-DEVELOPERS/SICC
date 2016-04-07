/********************************** 
	boton.js
	Funciones JavaScript asociadas a la clase Boton (Boton.java)
	02/04/2001
	DRUIDA 1.1
**********************************/
//function Boton(nombre, nsdoctxt, img, tipo, estado, accion, msg, codigo, unSoloCLick, tooltip) {
function Boton(nombre, img, tipo, estado, accion, msg, codigo, unSoloCLick, tooltip) {
	this.nombre=nombre;
   //this.nsdoctxt=nsdoctxt;
	this.nsdoc=new Object(); //Para que no fallen las llamadas a nsdoc.src que se hagan antes del init de este objeto
	this.tipo=tipo;
	this.imagen=new Array();
	if (tipo != 'html') {
		this.imagen[0]=new Image();this.imagen[0].src=img+'0.gif';
		this.imagen[1]=new Image();this.imagen[1].src=img+'1.gif';
		this.imagen[2]=new Image();this.imagen[2].src=img+'2.gif';
      this.imagen[3]=new Image();
      if (this.tipo=='1' || this.tipo=='2' ) {
         this.imagen[3].src=img+'3.gif';
         }
      else 
         {/*this.imagen[3].src='';*/}
	} else {
      /*
		ths.imagen[0]=new Image();this.imagen[0].src='';
		this.imagen[1]=new Image();this.imagen[1].src='';
		this.imagen[2]=new Image();this.imagen[2].src='';
		this.imagen[3]=new Image();*/
	}
	this.estado=estado; if (this.tipo < 1) { this.estado = false; }
	this.accion=accion;
	this.msg=msg;
	this.codigo=codigo;
	this.f_init=false;

	this.init=BotonInit;
	this.click=BotonClick;
	this.onMouseOver=BotonOnMouseOver;
	this.onMouseOut=BotonOnMouseOut;
	this.setTipo=BotonTipo;
	this.setEstado=BotonEstado;
	this.getBody=BotonGetBody;
   this.actualizaPropTipo= BotonActualizaPropTipo;
   if (!unSoloCLick)
      this.unSoloCLick=false;
   else
    	this.unSoloCLick=unSoloCLick;
   this.tooltip=tooltip;
   this.TC='Boton'
   }

function BotonInit() {
	if (this.f_init) return;
	this.f_init=true;
   /*
	if (ns) {
		this.nsdoc=eval(this.nsdoctxt);
	} else {*/
		if (this.tipo != 'html') {
			this.nsdoc = document.images[this.nombre+'I'];
		} else {
			this.nsdoc = this.nombre; // boton html no lleva imagenes
		}

   //	}
   //this.actualizaPropTipo();

   this.setTipo(this.tipo);//Para actualizar las imágenes
}

function BotonClick() {
   var oldtipo=this.tipo;
   if (this.tipo != 'html' && this.unSoloCLick)
      this.tipo=0;
	if (oldtipo == 0) {return;}
   //TRACEO:
   //DrdGuardaTraza("EV-USU, pulsado &lt;BOTON nombre=\""+this.nombre+"\" accion=\""+this.accion+"\"/&gt;");
	if (this.accion != null) {if (eval(this.accion) == false) return;}
	if (oldtipo < 0) {return;}
	if (this.estado == false) {	this.estado = true;
      if (this.tipo!='html'){this.nsdoc.src = this.imagen[3].src;}
      }
	else {this.estado = false; if (this.tipo!='html'){this.nsdoc.src = this.imagen[1].src;}}
}

function BotonOnMouseOver() {
   if (this.tipo==-2 || (this.tipo==2 && !this.estado))
      this.nsdoc.src=this.imagen[2].src;
   if (this.tooltip!=null && !DrdTooltipNat)
      tooltip(event, this.tooltip); 
   /*
	if (this.tipo==0) return;
	if (this.tipo==1 || this.tipo==-1) return;
	if (this.tipo==2 && this.estado) return;
	this.nsdoc.src=this.imagen[2].src;
   if (this.tooltip!=null !DrdTooltipNativo()) {
      tooltip(event, this.tooltip); 
   }*/
}

function BotonOnMouseOut() {
   if (this.tipo==-2 || (this.tipo==2 && !this.estado))
      this.nsdoc.src=this.imagen[1].src;
   if (this.tooltip!=null && !DrdTooltipNat)
      tooltip(); 
   /*
	if (this.tipo==0) return;
	if (this.tipo==1 || this.tipo==-1) return;
	if (this.tipo==2 && this.estado) return;
	this.nsdoc.src=this.imagen[1].src;
   if (this.tooltip!=null) {
      tooltip();
   }*/
}

function BotonActualizaPropTipo()   {
   if (!this.nsdoc.parentElement)
      return; //Aun no podemos actualizar porque no se ejecutó el init
   if (this.tipo==0) {
      var elahref=this.nsdoc.parentElement;
      elahref.disabled=true
      elahref.style.cursor="default"
      }
   else if (this.tipo!='html') {
      var elahref=this.nsdoc.parentElement;
      elahref.disabled=false
      elahref.style.cursor="hand"
      }
   }

function BotonTipo(tipo) {
	this.estado=false;	 // Al cambiar el tipo cambia el estado a false
	this.tipo=tipo;
	if (tipo!=0) {tipo=1;}
   if (this.tipo!='html')  {
      this.actualizaPropTipo();
   	this.nsdoc.src=this.imagen[tipo].src;
      }
}

function BotonEstado(estado) { //estado=true/false. No llama a la acción
	if (this.tipo<1) return;
	this.estado=estado;
   if (this.tipo!='html')  {
   	if (this.estado==true) {this.nsdoc.src=this.imagen[3].src;}
	   else {this.nsdoc.src=this.imagen[1].src;}
      }
}

function BotonGetBody() {
	var html="<A HREF='javascript:void(null);' onClick='"+this.nombre+".click();return false;' onMouseOver='"+this.nombre+".onMouseOver();";
	if (this.msg!=null) {html+="window.status=\""+this.msg+"\";return true;";}
	html+="' onMouseOut='"+this.nombre+".onMouseOut()'>";
	var img0;	if (this.tipo==0) {img0=0;} else {if (this.estado) {img0=3;} else {img0=1;}}
	html+="<IMG NAME='"+this.nombre+"I' SRC='"+this.imagen[img0].src+"' BORDER=0";
	if (this.msg!=null) {html+=" ALT='"+this.msg+"'";}
	html+="></A>";
	return html;
}
