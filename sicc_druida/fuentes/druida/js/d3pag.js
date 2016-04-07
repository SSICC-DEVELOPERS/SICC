// $Id: d3pag.js,v 1.1 2009/12/03 19:03:48 pecbazalar Exp $

// d3pag.js
// 20/DIC/01

function Paginado(nombre,separador,lista,ret,ava,ir1,labelPag,labelUltima) {
	this.nombre=nombre;
	this.indices='';
	this.separador=separador;
	this.ultima=false;
	this.accion=0; // bloqueo de más llamadas habiendo una en curso
	this.lista=lista;
	this.formulario=null;
	this.ventana=null;
	this.ava=ava;	// nombre botón avanzar
	this.ret=ret;	// nombre botón retroceder
	this.ir1=ir1;	// si 'S', va en el onload a la página1.
	this.pagina=0;
	this.labelPag=null;
	if (labelPag && labelPag!='') {this.labelPag=labelPag;}
	this.funcion=null;
	this.historyback=null;
	this.msjUltima=null;

	this.labelUltima=null;
	if (labelUltima && labelUltima!='') {this.labelUltima=labelUltima;}

	this.avanzar=Paginado_avanzar;
   this.recargar=Paginado_recargar
	this.retroceder=Paginado_retroceder;
   this.retrocederPrimeraPagina=Paginado_retrocederPrimeraPagina;
	this.go=Paginado_go;
	this.onload=Paginado_onload;
	this.init=Paginado_init;
	this.clear=Paginado_clear;
	this.setControl=Paginado_setControl;
	this.setConector=Paginado_setConector;
	this.setRowset=Paginado_setRowset;
	this.cargaInicial=Paginado_cargaInicial;
   this.setInitPage=Paginado_setInitPage;
	this.dameValores=Paginado_dameValores;
	this.ponValores=Paginado_ponValores;
}

function Paginado_init() {
	this.lista=eval(this.lista);
	this.formulario=eval('document.'+this.nombre+'_form');
	this.formulario.target='DruidaOculto'+this.nombre;
	this.ava=eval(this.ava);
	this.ret=eval(this.ret);
	if (this.valores) {this.ponValores(this.valores);}
	if (this.ir1=='S') {this.avanzar();}
}

function Paginado_retroceder() {
	if (this.accion!=0) {return;}
	this.indices=this.indices.substring(0,this.indices.lastIndexOf(this.separador));
	this.indices=this.indices.substring(0,this.indices.lastIndexOf(this.separador));
	this.accion=-1;
	this.go();
}

function Paginado_recargar() {
	if (this.accion!=0) {return;}
	this.indices=this.indices.substring(0,this.indices.lastIndexOf(this.separador));
	this.accion=-1;
	this.go();
}

function Paginado_avanzar() {
	if (this.accion!=0) {return;}
	this.accion=1;
	this.go();
}


function Paginado_go() {
   this.formulario.paginado_indice.value=this.indices.substring(this.indices.lastIndexOf(this.separador)+1);
   if (window.oculta_paginado) {d3ocupado_ver('d3general',d3ocupado_general);}
   var elForm=this.formulario;
	if (window.tipoAsignarJs && window.tipoAsignarJs=='IFRAME')    {
      var nuevoTarget=getFreeComCh();
		elForm.target=nuevoTarget
		document.all[""+nuevoTarget].parent=self.name;
      elForm.submit();
      }
   else if (window.tipoAsignarJs && window.tipoAsignarJs=='AJAX')    {
      /*
       Modificado para construir el vector de parametros para el nuevo metodo
       e invocarlo.
      */
      var loscampos=elForm.getElementsByTagName("INPUT");
	  var params = new Array();
      for (var f=0;f<loscampos.length;f++){
		params[params.length]=[loscampos[f].name,loscampos[f].value];
	  }
      // invocamos a AJAX
      var ai = new AJAXInteractionPaginado();
	  ai.enviar(elForm.action,params);
      // Fin modificaciones
      }
   else  {
      this.ventana=window.open('','','toolbar=0,directories=0,height=100,width=100,location=0,personalbar=0,resizable=0,titlebar=no,scrollbars=0,status=0,top=2000,left=2000');
      this.ventana.name='DruidaOculto'+this.nombre;
      if (this.ventana && !this.ventana.closed) {this.ventana.blur();}
      elForm.submit();
      }
	return true;
   }


function Paginado_onload(msgError,ultima,next,rowset) { // (string,boolean,string,array)
	var b=true;
	if (this.funcion) {b=eval(this.funcion);} // this.funcion='mifuncion(msgError,ultima,rowset)'. Return true/false.
	if (b) {
		if (msgError!='') {if (opener){opener.focus();}window.focus();muestraMsgError(msgError);}
		else {
			this.ultima=ultima;
			this.indices+=(this.indices==''?'':this.separador)+next;
			var datos=new Array();
			for(var i=0;i<rowset.length;i++) {
				if (rowset[i].length!=0) {datos[i]=new Array(); for(var j=0;j<rowset[i].length;j++) {datos[i][j]=rowset[i][j];	}}
				else {datos[i]=rowset[i];}
			}
			if (this.ultima) {this.ava.setTipo(0);} else {this.ava.setTipo(-2);}
			if (this.indices.indexOf(this.separador)==-1) {this.ret.setTipo(0);} else {this.ret.setTipo(-2);}
			this.lista.setDatos(datos);
         if (!this.lista.tag || (this.lista.tag && this.lista.tag!="LISTAEDITABLE"))
   			this.lista.display();
			this.pagina+=this.accion;
			if (this.labelPag!=null) {txt_to(this.labelPag,this.pagina);}

			// control de labelUltima
			if (!this.ultima && this.msjUltima!=null && this.labelUltima!=null && this.labelUltima!='')	{
				txt_to(this.labelUltima,''); //Si no es la ultima y (estoy pintando un mensaje en la ultima) lo limpio
				}
			if (this.ultima && this.msjUltima!=null)	{
				if (this.labelUltima!=null && this.labelUltima!='')	{
					txt_to(this.labelUltima,this.msjUltima); //Si es la ultima pinto un mensaje en un label
					}
				else	{
					alert(this.msjUltima);//Si es la ultima y no esta definido labelUltima pero si hay mensaje saco un alert
					}
				}
			// /control de labelUltima

		}
		if (this.historyback) {for(var k=0;k<this.historyback.length;k++){this.lista.on(unescape(this.historyback[k]));}if (this.historyback.length>0){setTimeout(this.lista.nombre+".scrollTo('"+unescape(this.historyback[0])+"')",100);}this.historyback=null;}
	}
   if (this.ventana)
   	this.ventana.close();
	if (window.oculta_paginado) {d3ocupado_ocultar('d3general');}
	this.accion=0;
}

// Borra la lista e inicializa variables
function Paginado_clear() {
	if (this.accion!=0) {return;}
	
	if (this.lista.tag != 'LISTAEDITABLE') {
		this.lista.datos.borrar();
		this.lista.seleccion.borrar();
   	}
   else {
		this.lista.datos=[];
      this.lista.ajustaSelecc();
      }

	this.lista.ultimo_pulsado=null;
	this.lista.display();

	this.ava.setTipo(0);
	this.ret.setTipo(0);
	this.indices='';
	this.ultima=false;
	this.pagina=0;
	if (this.labelPag!=null) {txt_to(this.labelPag,this.pagina);}
}

function Paginado_setControl(valor) {this.formulario.paginado_control.value=valor;}
function Paginado_setConector(valor) {this.formulario.paginado_conector.value=valor;}
function Paginado_setRowset(valor) {this.formulario.paginado_idrowset.value=valor;}

function Paginado_cargaInicial(msgError,ultima,next) { // (string,boolean,string)
   //alert('XA')
	var b=true;	
	if (this.funcion) {
      var rowset=null;
      if (this.lista.tag && this.lista.tag=='LISTAEDITABLE')
         rowset=this.lista.datos;
      else
         rowset=this.lista.datos.bd;
      b=eval(this.funcion);
      } // this.funcion='mifuncion(msgError,ultima,rowset)'. Return true/false.
	if (b) {
		if (msgError!='') {muestraMsgError(msgError);}
		else {
			this.ultima=ultima;
			this.indices+=(this.indices==''?'':this.separador)+Paginado_escapeISO(next);
			if (this.ultima) {this.ava.setTipo(0);} else {this.ava.setTipo(-2);}
			if (this.indices.indexOf(this.separador)==-1) {this.ret.setTipo(0);} else {this.ret.setTipo(-2);}
			this.pagina=1;
			if (this.labelPag!=null) {txt_to(this.labelPag,this.pagina);}
			// control de labelUltima
			if (!this.ultima && this.msjUltima!=null && this.labelUltima!=null && this.labelUltima!='')	{
				txt_to(this.labelUltima,''); //Si no es la ultima y (estoy pintando un mensaje en la ultima) lo limpio
				}
			if (this.ultima && this.msjUltima!=null)	{
				if (this.labelUltima!=null && this.labelUltima!='')	{
					txt_to(this.labelUltima,this.msjUltima); //Si es la ultima pinto un mensaje en un label
					}
				else	{
					alert(this.msjUltima);//Si es la ultima y no esta definido labelUltima pero si hay mensaje saco un alert
					}
				}
			// /control de labelUltima
		}
	}
}

function Paginado_setInitPage(datos,ultima,next) {
        var b=true;        
        if (this.funcion) {
           var rowset=null;
           if (this.lista.tag && this.lista.tag=='LISTAEDITABLE')
              rowset=this.lista.datos;
            else
               rowset=this.lista.datos.bd;
           b=eval(this.funcion);
           } // this.funcion='mifuncion(msgError,ultima,rowset)'. Return true/false.
        if (b) {
		this.ultima=ultima;
		this.indices=next;
		if (this.ultima) {this.ava.setTipo(0);} else {this.ava.setTipo(-2);}
		if (this.indices.indexOf(this.separador)==-1) {this.ret.setTipo(0);} else {this.ret.setTipo(-2);}
		this.lista.setDatos(datos);
		this.lista.display();
		this.pagina=1;
		if (this.labelPag!=null) {txt_to(this.labelPag,this.pagina);}
		// control de labelUltima
			if (!this.ultima && this.msjUltima!=null && this.labelUltima!=null && this.labelUltima!='')	{
				txt_to(this.labelUltima,''); //Si no es la ultima y (estoy pintando un mensaje en la ultima) lo limpio
				}
			if (this.ultima && this.msjUltima!=null)	{
				if (this.labelUltima!=null && this.labelUltima!='')	{
					txt_to(this.labelUltima,this.msjUltima); //Si es la ultima pinto un mensaje en un label
					}
				else	{
					alert(this.msjUltima);//Si es la ultima y no esta definido labelUltima pero si hay mensaje saco un alert
					}
				}
			// /control de labelUltima
        }
}

function Paginado_escapeISO(str) {
        if (str) {
                str=str+'';
                var myRe=/&#(\d\d\d);/;
                var myArray;
                do {
                        myArray=myRe.exec(str);
                        if (myArray!=null) {str=str.replace(new RegExp(myArray[0],"g"),String.fromCharCode(myArray[1]));}
                }while(myArray!=null);
        }
        return str;
}

function Paginado_dameValores() {

	var c160=';',c159='&',c158='=',c157='#',c156='$';
	var s='',fila,datos='';
	var obj=this.lista;
   var rwst=null;
   if (this.lista.tag && this.lista.tag=='LISTAEDITABLE')
      rwst=this.lista.datos;
   else
      rwst=this.lista.datos.bd;

	for(var k=0;k<rwst.length;k++) {
		if (k>0) datos+=c156;
      if (this.lista.tag && this.lista.tag=='LISTAEDITABLE')
         datos+=escape(obj.codSeleccionados());
      else
         datos+=escape(obj.seleccion.bd[k]);
		
	}
	s+=c158+datos;	
	obj=this; s+=c158+escape(obj.indices);
	s+=c158+escape(obj.ultima);s+=c158+escape(obj.pagina);
	s+=c158+escape(obj.formulario.paginado_control.value);
	s+=c158+escape(obj.formulario.paginado_conector.value);
	s+=c158+escape(obj.formulario.paginado_idrowset.value);
	return s;
}

function Paginado_ponValores(s) {
	var c160=';',c159='&',c158='=',c157='#',c156='$';
	var values=s.split(c158);
	var obj=this; var datos=null;
	if (values[1]!='') {datos=values[1].split(c156);}
	this.historyback=datos;
	obj.indices=unescape(values[2]);obj.ultima=(unescape(values[3])=='true');obj.pagina=unescape(values[4])*1;
	obj.formulario.paginado_control.value=unescape(values[5]);
	obj.formulario.paginado_conector.value=unescape(values[6]);
	obj.formulario.paginado_idrowset.value=unescape(values[7]);
	if (this.indices!='') {this.indices=this.indices.substring(0,this.indices.lastIndexOf(this.separador));}
	this.accion=-1;
	this.go();
}

function Paginado_retrocederPrimeraPagina ()  {
   if (this.accion!=0) 
      return;
   if (this.indices.indexOf('$')!=-1) { //Si estamos en la primera no retrocedemos
      this.indices="";
      this.accion=-1;
      this.go();
      }
   }

function AJAXInteractionPaginado(url, callback) {

    var req = init();
    req.onreadystatechange = processRequest;
        
    function init() {
      if (window.XMLHttpRequest) {
        return new XMLHttpRequest();
      } else if (window.ActiveXObject) {
        return new ActiveXObject("Microsoft.XMLHTTP");
      }
    }
    
    function processRequest () {
      if (req.readyState==4)  {//"loaded"
      if (req.status==200) {//"OK"
         var txt=req.responseText
         if (txt.charAt(0)!='[') {
            mipgndo.onload(txt)
            }
         else  {
            /*var res=eval(txt)
            var objPaginado=eval(res[3])
            objPaginado.onload("",res[0],res[1],res[2]) */
	    var res=eval(txt);
		//comprobamos si hay error
	    if(res[0][0]!=null && res[0][0]!=""){
		var objPaginado = eval(res[1][0]);
		objPaginado.onload(res[0][0],false,null,new Array());
		return;
	    }		
            var objPaginado=eval(res[1][3])
            objPaginado.onload("",res[1][0],res[1][1],res[1][2])
            }
         } 
      else   {
         alert("Problema con la petición de datos al servidor. Estado de la página de retorno: "+req.status+" - "+req.statusText)
         }
      }
    }

    this.doGet = function() {
      req.open("GET", url, true);
      req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
      req.send(null);
    }
    
    this.doPost = function(body) {
      req.open("POST", url, true);
      req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
      req.send(body);
    }
    
    /*
    * Metodo enviar
    * Envia la solicitud HTTP segun el metodo indicado. Por defecto POST.
    * destino: Cadena con el URI destino.
    * parametros: vector con los parametros a enviar.
    *    Es un vector compuesto de vectores de 2 elementos, 
    *    el primero es el nombre del parametro y el segundo el valor.
    * modoGet: indicador para usar el metodo GET. Por defecto si no usa el metodo POST
    *    para usar GET establecer su valor a 1.
    */
    this.enviar = function(destino, parametros, modoGet){
        var strParam = null;
        for(var i=0;i<parametros.length;i++){
            var param_i = parametros[i];
            strParam = strParam + "&" + param_i[0] + "=" + encodeURIComponent(param_i[1]);
        }
        strParam = strParam.substr(1);
        if(modoGet!=null && modoGet==1){
            if(strParam!= null && strParam.length > 0){
                strParam = "?" + strParam;
            }else{
                strParam = "";
            }
            req.open("GET", destino+strParam, true);
            req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            req.send(null);
        }else{
            req.open("POST", destino, true);
            req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            req.send(strParam);
        }
    }
    
}