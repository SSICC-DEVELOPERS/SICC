/********************************** 
	$Id: base.js,v 1.1 2009/12/03 19:03:47 pecbazalar Exp $
	Funciones javascript básicas
	23/11/2001
	DRUIDA 1.1
**********************************/
// Quitar los comentarios acelera la carga de la página
// TO-DO: Optimizar disgregando algunas funciones en ficheros diferentes (scroll.js, lista.js, ...)

// Establece el tipo de navegador

var ns=(navigator.appName=="Netscape" && parseInt(navigator.appVersion)>=4);
var ie=(document.all)?true:false;

DRUIDA=new drdDRUIDA('document.DRUIDA.document','','Label');

d3_componentes=[];

function nombrePagina(){ return window.drdNombrePagina;}


// Cambia la imagen "nombre" a "imagen".src
function img_to(nombre,imagen) {	
	//if (ns) {nsdoc=eval(nombre+'.nsdoc'); eval(nsdoc+'.src='+imagen+'.src');}
	//else {
   //eval('document.images["'+nombre+'"].src='+imagen+'.src');
   document.images[nombre].src=eval(imagen+".src")
   //}
}

window.labelRC='';

// Cambia el texto de una label
function txt_to(nombre,texto) {
   texto=texto+"";
   var spr = String.fromCharCode(160);
   eval ("var expReg=/" + spr + "/gi;");
   if (texto.replace(expReg,'').replace(/\s/gi,'')=='')
      texto=""; //Si había varios blancos, los convierto a "" 
   
   var obj=eval(nombre); obj.txt=texto;
   var id=obj.ID
   //var id=eval(nombre+'.ID');
   var idtxt="";
   if (id!=null && id != '' && id != ' ') {
      if ( ! (window.LABC_SVQE && texto=="")) { //opcion en globales.xml: <MODIFICAR COMPONENTE="LABELC" OPCION="SiVacioQuitarEstilo"/>
         idtxt=" ID=\""+id+"\" CLASS=\""+id+"\" ";
         }
      }

	var texto2;
	texto=escapeISO(texto);
	if (window.labelRC=='S') {texto=texto.replace(/\n/g,"<br>");}

   var enlace="";
	//if (eval(nombre+".link != null")) {
	if (obj.link != null) {
      enlace="HREF=\""+ obj.link +"\"";
   } else {
      //enlace="HREF='javascript:void(null)'";
   }

   var tooltip="";

   if (obj.tooltip != null) {

      if (window.tipoTooltip.toUpperCase() == 'NATIVO' && ie) {
         tooltip="title=\""+DrdEscHTML(obj.tooltip)+"\"";
         }
      else{
         tooltip="onmouseover='tooltip(event, \"" + obj.tooltip + "\")' onmouseout='tooltip()'";
         }
      } 

   if (obj.link != null || obj.tooltip != null)
      texto="<A "+idtxt+ " " + enlace + " " + tooltip + " id='T1C'>"+texto+"</A>";

   //texto="<A ID="+id+ " " + enlace + " " + tooltip + " id='T1C'>"+texto+"</A>";
   
   /*
	if (id!='') {
		if (eval(nombre+".TC=='Label'")) {
         texto2='<SPAN '+idtxt+'>'+texto+'</SPAN>';
         }
      else if (eval(nombre+".TC=='LabelR'")) {
         var elnowrap=""
         if (eval(nombre+'.W')==0)  
            elnowrap=" nowrap "
         texto2='<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0><TR><TD '+idtxt+' '+ (eval(nombre+'.W')>0?'WIDTH='+eval(nombre+'.W'):'') +' '+ (eval(nombre+'.H')>0?'HEIGHT='+eval(nombre+'.H'):'') +' '+elnowrap+'>'+texto+'</TD></TR></TABLE>';
         }
      else {
         texto2=texto;
         }
	   }
	else {
      texto2=texto;
      }
   */

   if (obj.TC=='Label') {
      texto2='<SPAN '+idtxt+'>'+texto+'</SPAN>';
      }
   else if (obj.TC=='LabelR') {
      var elnowrap=""
      if (obj.W==0)  
         elnowrap=" nowrap "
      texto2='<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"0\"><TR><TD '+idtxt+' '+ (obj.W>0?'WIDTH='+obj.W:'') +' '+ (obj.H>0?'HEIGHT='+obj.H:'') +' '+elnowrap+'>'+texto+'</TD></TR></TABLE>';
      }
   else {
      texto2=texto;
      }

/*
   if (ns) {
		var nsdoc=eval(nombre+'.NS');
		eval(nsdoc+'.open()');
		eval(nsdoc+'.write(texto2)');
        eval(nsdoc+'.close()');
	}
    else if (ie) {
 */
				var milabel=document.all.item(nombre);
		if (milabel!=null) {
			if (milabel.length!=null) {
				for (var i=0; i<milabel.length; i++) {
					if (milabel(i).tagName=='DIV') {milabel(i).innerHTML=texto2;break;}
				}
			}
			else {document.all[nombre].innerHTML=texto2;}
		} 
/* 	} */
	

	var enviar_label=obj.enviar;
	if (enviar_label) {set(enviar_label,texto);}
}

// Cambia el html de una capa
function write_to(nombre,html) {
   /*
	if (ns) {
		var nsdoc=eval(nombre+'.nsdoc');
		eval(nsdoc+'.open()');
		eval(nsdoc+'.write(html)');
        eval(nsdoc+'.close()');		
	}
    else if (ie) {*/
       document.all[nombre].innerHTML=html;
       //}
}

// Enlaza a una nueva página
function url_to(target,url) {
   // TRACEO
/*    if (window.top.DR_DEBUG_JS) 
      DrdGuardaTraza("EV-DRDJS, url_to ('"+(target?target:'')+"','"+(url?url:'')+"')"); */
   
	if (target=='*') {window.close();}
	if (target=='M') {document.location.href=url;}
	if (target=='V') {window.top.location.href=url;}	
}

var conectorActionV=null;
function conectorAction(msgError,redirec) {
	if (conectorActionV==null) return;
	if (window.oculta_frmOculto) {opener.d3ocupado_ocultar('d3general');}
	if (msgError!='') {
		muestraMsgError(msgError);
		conectorActionV.close();
		conectorActionV=null;
	}
	else {
		conectorActionV.close();
		conectorActionV=null;
		if (redirec!='') document.location.href=redirec;
	}
}

/*
function ValidaForm(form,alerta) {
	for (var i=0;i<eval('document.'+form+'.elements.length');i++) {
		var campo=eval('document.'+form+'.elements['+i+'].name');
		if (eval(form+'.'+campo+'TC=="Hidden"')) {continue;}
      if (eval(form+'.'+campo+'TC=="Listado"')) { //Si listado, valido el formulario interno
         var nombrobj=eval(form+'.'+campo+'OBJ');
         (eval(nombrobj)).preparaCamposDR();
         if ((ValidaForm('frm'+nombrobj,alerta))==false)   {
            return false;
            }
         }
      else if (valida(form+'.'+campo,alerta,true)==false) {
         return false;
         }
	}
	return true;
}
*/

// Envía el formulario (genérico), previa validación
// envia('f1','','','S'/'N') valida o no el formulario antes de enviarlo
function envia(form,action,target,valid) {  //,drback) { // drback : false --> no se salvan los valores de la pagina 
   var nn=eval('document.'+form);	
	var nform=eval(form);
	if (nn.conectorActionOculto) {nn.conectorActionOculto.value=nform.oculto;}
   var hayDruidaBack=true;
   if (target!=null || nform.oculto!='N')
      hayDruidaBack=false;
   var elementos=document[form].elements;
   var longitElem=elementos.length
   for (var i=0;i<longitElem;i++) {
      var elemento=elementos[i];
      var campo=elemento.name;
      var tipocmp=nform[campo+'TC'];
      //Hacemos el TRIM si es el caso
      if (tipocmp=="Texto")   {
         if (!nform[campo+'NOTRIM'] && window.TRIM_TEXT)
            elemento.value=DrdTrim(elemento.value);
         }
      else if (tipocmp=='Textarea') {
         if (!nform[campo+'NOTRIM'] && window.TRIM_AREATEXTO)
            elemento.value=DrdTrim(elemento.value);
         }
      else if (tipocmp=="Listado")  {
         //var elinput=eval(form+'.'+campo);
         nn[campo].value=get(form+'.'+campo)
         }
      }

	if (!valid || valid=='S') {
      if (!ValidaForm (form,true))
         return false;
      }
	nn.action=nform.action;

   //Si la página va cacheada atacamos al frameset parent
   if (window.HTML_CACHEADO) {
      nn.target='_parent'; 
      }
   else  {
      nn.target=self.name; 
      }

	if (action) {nn.action=action;}
	if (target) 
      {nn.target=target;}
	else {
      //		if (eval(document[form].conectorActionOculto)) set(form+".conectorActionOculto",nform.oculto);
		if (nform.oculto!='N') { // abre ventana oculta
         /*
         if (!window.DruidaOcultoInd)
            window.DruidaOcultoInd=1;
         var nombre="DruidaOculto"+(window.DruidaOcultoInd++)
         new Date.getTime()));
         */
         var nombre="v"+(new Date().getTime())+(Math.round(1000*Math.random()))

         conectorActionV = DrdNuevaVentanaMinim(nombre);
			conectorActionV.blur();
			nn.target=nombre;
		    if (!window.ocupado_envia && window.oculta_frmOculto) {d3ocupado_ver('d3general',d3ocupado_general);}
		}
	}
	if (window.ocupado_envia) {d3ocupado_ver('d3general',d3ocupado_general);}

	if (hayDruidaBack)
      saveValoresPagina();

   // +TRACEO
/*    if (window.top.DR_DEBUG_JS) {  
      fval=DrdValoresForm(form);
      DrdGuardaTraza("EV-DRDJS, envia ('"+(form?form:'')+"','"+nn.action+"','"+nn.target+"','"+(valid?valid:'')+"')"+((nform.oculto!='N')?" (oculto)":"")+"\n"+fval);
      } */
   
   if (nn.drd_tiempo_inicio)  {
      nn.drd_tiempo_inicio.value=(new Date()).toUTCString();
      if (window.DRD_TIEMPO_TOTAL)
         nn.drd_tiempo_total.value=window.DRD_TIEMPO_TOTAL;
      }
   // -TRACEO

	nn.submit();
	return true;
}

function enviaPrototipo(formulario, target) {
 /*var nn=eval('document.'+form);
 var nform=eval(form);
 nn.action=eval('document.'+form+'.xml.value')+".html";
 nn.target=document.location.href;
 if (target) {nn.target=target;}
 nn.submit();
 return true;*/
 if (target) {eval("top."+target+".document.location.href=eval('document.'+formulario+'.xml.value')+'.html'");}
 else{document.location.href=eval('document.'+formulario+'.xml.value')+".html";}
 return;
}

// Valida, establece el arco de salida y envia el formulario
function setArco (form, arco) { 
   var encontrado = 'N';
   var i ;
   for (i=0; i < ArcosSalida.length && encontrado == 'N'; i++) {   
      if (ArcosSalida[i] == arco) {
         encontrado = 'S';
         eval (form);
         eval ('document.'+form+'.DruidaArco.value = arco') ;
      }
   }
   if (encontrado == 'N') 
      muestraMsgError(DrdMsgCore(175) + arco + DrdMsgCore(176));  //El arco no existe
   else 
      envia(form);
}


//function enviaPrototipo() {
//	alert('2');
// document.location.href=(document.forms[0].xml.value+".html");
//}

// Valida todos los campos de un formulario
// alerta=true => salta un alert si falla la validación y posiciona el foco al 1eer campo inválido
// ValidaForm devuelve true si la validación es correcta, false en caso contrario
function ValidaForm(form,alerta) {
	for (var i=0;i<eval('document.'+form+'.elements.length');i++) {
		var campo=eval('document.'+form+'.elements['+i+'].name');
		if (eval(form+'.'+campo+'TC=="Hidden"')) {continue;}
      if (eval(form+'.'+campo+'TC=="Listado"')) { //Si listado, valido el formulario interno
         var nombrobj=eval(form+'.'+campo+'OBJ');
         (eval(nombrobj)).preparaCamposDR();
         if ((ValidaForm('frm'+nombrobj,alerta))==false)   {
            return false;
            }
         }
      else if (valida(form+'.'+campo,alerta,true)==false) {
         return false;
         }
	}
	return true;
}

// Reset
function reset(form) {
		for (var i=0;i<eval('document.'+form+'.elements.length');i++) {
			var campo=eval('document.'+form+'.elements['+i+'].name');
			//nsdoc=ns?eval(form+'.'+campo+'NS'):eval(form+'.'+campo+'IE');
         nsdoc=eval(form+'.'+campo+'IE');
			nsdoc=nsdoc.substring(0,nsdoc.length-campo.length);
			eval(nsdoc+'reset()');
		}
}

// Devuelve las columnas de matriz(array) filtradas según un criterio. Suponemos array de Strings
// Ejemplo: filtra(arrayBBDD, [1,2], 0, '==,!=,>,<,>=,<=','valor a comparar');
// Devuelve [[col1i,col2i],[col1i+1,col2i+1],...] (array bidimensional) con las filas cuya columna 0==><!valor
// Si solo queremos una columna, devuelve un array unidimensional: filtra(arrayBBDD, [1], 0, ...
// criterio='*' => filtra todas las filas
// columna='*' => filtra todas las columnas
// TO-DO: array criterios
function filtra(matriz,columnas,col,criterio,valor)
{
	salida=new Array();
	var contador=0;
	var test=false;
	for (var i=0;i<matriz.length;i++) {
		var contador2=0;
		if (criterio=='*') {test=true;}
		else {test=eval('\''+matriz[i][col]+'\''+criterio+'\''+valor+'\'');}
		if (test) {	// Se cumple el criterio
			salida[contador]=new Array();
			if (columnas=='*') {salida[contador]=matriz[i];}
			else {
				for (var j=0;j<columnas.length;j++) {
					salida[contador][contador2++]=matriz[i][columnas[j]];
				}
			}
			contador++;
		}
	}
return salida;
}

//Filtrado según varios criterios
//filtra2(matriz,[1,2], [ ['&',1,'==','val1'] , ['|',2,'!=','val2'] , ...])
//filtra2(matriz,[1,2], '*') => filtra las cols 1 y 2 de todas las entradas
//filtra2(matriz,[-1], criterios) => filtra todas las cols de las filas que cumplan criterios
//IMPORTANTE: las condiciones '|' ponerlas en primer lugar en el array, antes que las '&'
function filtra2(matriz,columnas,criterios)
{
	var salida=new Vector();
	salida.cargar(matriz);
	return salida.filtrar(columnas,criterios);
}

function quitaEscapes (cad)	{
	var ret=('' + cad).replace (/&nbsp;/gi , ' ');
	ret=ret.replace (/&gt;/gi , '>');
	ret=ret.replace (/&lt;/gi , '<');
	ret=ret.replace (/&amp;/gi , '&');
	ret=ret.replace (/<\/script/gi , '<script');
	return (ret);
	}

// Establece el valor de un campo (campo='form.nombre')
function set(campo,valor){

      // TRACEO
/*       if (window.top.DR_DEBUG_JS)
         DrdGuardaTraza("EV-DRDJS, set ('"+(campo?campo:'')+"','"+(valor?valor:'')+"')"); */
      

		var TC=eval(campo+'TC');	 // Tipo de componente
		if (TC=='Hidden' || TC=='Texto' || TC=='Textarea'  )	
			valor=quitaEscapes(valor);
		if (TC=='Hidden') {
			var nn=eval('document.'+campo);
			nn.value=valor+'';
			return true;
			}
		//var nsdoc=eval(campo+'NS');
		var iedoc=eval(campo+'IE');
		switch(TC) {
			case 'Combo':	var token=''; 
							var flag=false; // selecciona los valor duplica en form global
							//var n=eval(ns?nsdoc:iedoc);
                     var n=eval(iedoc);
							var longitud=n.length;
							if (longitud==0) {
								eval('document.'+campo+'.value=\'\'');
								break;
								}
							if (valor!=null) {	// selecciona exclusivamente los elementos de valor
								n.selectedIndex=-1;
								for(var j=0;j<longitud;j++) {
									n.options[j].selected=false;
									for(var i=0;i<valor.length;i++) {
										if (n.options[j].value==valor[i]) {
											n.options[j].selected=true;
											if (flag)
												token+='|';
											token+=valor[i];
											flag=true;
											}
										}
									}
								}
							else { // Valor=null => únicamente duplica la select en el formulario global, y no selecciona
								if (n.type=='select-one') {
									if (n.selectedIndex!=-1) {
										token=n.options[n.selectedIndex].value;
										flag=true;
										}
									else if (eval(campo+'SZ')==1) {
										n.options[0].selected=true;
										token=n.options[0].value;
										}
									}
								else {
									for(var j=0;j<longitud;j++) {
										if (n.options[j].selected) {
											if (flag) 
												{token+='|';}
											token+=n.options[j].value;
											flag=true;
											}
										}
									}
								}
							token=quitaEscapes(token);
							eval('document.'+campo+'.value="'+token+'"');	 // Escribe el valor del campo en el formulario global
							break;

			case 'Radio':	   valor=valor+'';
									eval('document.'+campo+'.value=""');
									//for(var j=0;j<eval((ns?nsdoc:iedoc)+'.length');j++) {
                           for(var j=0;j<eval((iedoc)+'.length');j++) {
										//eval((ns?nsdoc:iedoc)+'['+j+'].checked=false');
                              eval((iedoc)+'['+j+'].checked=false');
										//if (eval((ns?nsdoc:iedoc)+'['+j+'].value=="'+valor+'"')) {
                              if (eval((iedoc)+'['+j+'].value=="'+valor+'"')) {
													//eval((ns?nsdoc:iedoc)+'['+j+'].checked=true');	// Selecciona el radio-button
                                       eval((iedoc)+'['+j+'].checked=true');	// Selecciona el radio-button
													eval('document.'+campo+'.value="'+valor+'"');	// Escribe el valor del campo en el formulario global
													break;
										}
									}									
									break;
			case 'Checkbox':	// (Des)selecciona el radio-button
									//if (valor==null) {if (eval((ns?nsdoc:iedoc)+'.checked')) {valor='S';} else {valor='N';}}
                           if (valor==null) {if (eval((iedoc)+'.checked')) {valor='S';} else {valor='N';}}
									else {if (valor!='S') {valor='N';}}
									//eval((ns?nsdoc:iedoc)+'.checked='+(valor=='S'?'true':'false'));
                           eval((iedoc)+'.checked='+(valor=='S'?'true':'false'));
									eval('document.'+campo+'.value="'+valor+'"');	// Escribe el valor del campo en el formulario global
									break;
			case 'Texto': valor=escapeISO(valor);
			case 'Textarea': valor=valor+'';
									//var nn=eval(ns?nsdoc:iedoc);
                           var nn=eval(iedoc);
									if (nn.value!=valor) {nn.value=valor;}	// Escribe el valor del campo en el formulario local
									nn=eval('document.'+campo);nn.value=valor; // Escribe el valor del campo en el formulario global
									break;
		}
		return valida(campo,true,false);
}



// Valida los campos de los formularios (campo='form.nombre')
function valida(campo, alerta, enviar){
		var MV=eval(campo+'MV');	 // Modo de validación (Inmediato, Conjunto)
		if (!enviar && (MV=='C' || MV=='c')) {return true;}
		//var nsdoc=eval(campo+'NS');
		var iedoc=eval(campo+'IE');
		var valor='';
		valor=get(campo);

      var TCkk=eval(campo+'TC');	 // Tipo de componente

		if (MV=='C' || MV=='I') {	// Campo obligatorio
            if (window.reqIgnEsp)
               valorxx=(""+valor).replace(/ /gi,"");
            else
               valorxx=valor;
				if (valorxx=='' || (TCkk=='Checkbox' && valor=='N')) {
					if (alerta) {
						var mensajeRequerido=eval(campo+'MR');
						if (mensajeRequerido) {focaliza(campo,mensajeRequerido);} 
						else {focaliza(campo,DrdMsgCore(179));} //Campo requerido
					}
					return false;
				}
		}
		var TV=eval(campo+'TV');	 // Tipo de validación
		if (TV=='null' || valor=='') {return true;} // si no hay validación o el campo está vacío (no es obligatorio si ha llegado hasta aquí)
		var ok='';
		if (entornoV(TV)!='DRD_ERROR_001') {ok=eval(entornoV(TV));}
		else {
			var busca=/\'\$[^\$]+\$\'/g;
			var campos=TV.match(busca);
			if (campos!=null) {	// Sustitución de los argumentos referentes a los campos
				for(var i=0;i<campos.length;i++) {
						//if (ns) {TV=TV.replace(/\'\$[^\$]+\$\'/,'get(\''+campos[i].substring(2,campos[i].length-2)+'\')');}
						//else {
                     TV=TV.replace(campos[i],'get(\''+campos[i].substring(2,campos[i].length-2)+'\')');
                     //}
				}
			}
			ok=eval(TV);
		}
		if (ok=='OK') {return true;}
		if (alerta) {focaliza(campo,ok);}
		return false;
}


// Posiciona el foco en un campo de formulario
function foco(campo) {focaliza(campo,'');}


function generaNsdoc(obj)  {
   var prim=true
   var ret="document."+obj.name;
   while (obj.parentElement)  {
      obj=obj.parentElement //Suponemos que el focaliza nunca se hace sobre una capa o similar
      if (obj.tagName=='DIV' && obj.id!=null) {
         var obj2=window[obj.id]
         if (obj2!=null && obj2.TC)
            ret="document."+obj.id+"."+ret;
         }
      }
   //alert(ret)
   return ret
   }

// Posiciona el foco en un campo de formulario. Si ok!='' muestra alert(ok)
function focaliza(campo,ok,posicion) {

		var C,CN;
		var hacer_focus=true;
		//var hacer_select=false;
      var hacer_select=false; 
		subcapas=new Vector('subcapas'); 
		// var nsdoc=eval(campo+'NS'); //ej:'document.miscrollDiv.document.miscrollDivtv.document.miscroll.document.fecha'
		var iedoc=eval(campo+'IE'); //ej:'fecha'
		var TC=eval(campo+'TC'); //ej:Texto
      var elobj=eval(iedoc)
      var nsdoc=generaNsdoc(elobj);
      //alert(1+"-"+nsdoc)
		subcapas.token('.',nsdoc);  //Se quita porque usa el NSDOC que ahora no se genera. Se puede reprogramar usando solo lo de IE
		for(var i=0; i<subcapas.longitud-1; i++) {
         CN=subcapas.ij(i);
			if (CN=='document') 
				continue;

			//C=eval(subcapas.ij(i));
         C=window[subcapas.ij(i)]

         switch(C.TC) {
            case 'Scroll': //hacer_select=true; hacer_focus=false;break;
               if (ie && window.FLAG_SCR_NATIVO==null) {
                  hacer_focus=false;
                  }
               if ( window.FLAG_SCR_NATIVO==null)	{
                  i+=5;
                  }	
               visibilidad(CN,'V');
               break;
            case 'Capa':
               visibilidad(CN,'V'); break;
            case 'Solapas':
               i=i+2;
               visibilidad(CN,'V');
               solapas_to(CN,subcapas.ij(i));
               break;
            case 'Tabla': 
               break;
            case 'Formulario': 
               break;
            case 'DUMMY': //Por el scroll nativo
               break;
            default: 
               hacer_focus=false; break;
            }
         }


		if (ok!='' && ok!=null) {muestraMsgError(ok);}

		if (hacer_focus) {
			if (TC=='Radio') {
				var nr="0";
				//eval ("var ntotr="+(ns?nsdoc:iedoc)+".length;");
            eval ("var ntotr="+(iedoc)+".length;");
				if (posicion)	
					if (posicion >= 0 && posicion < ntotr)
						nr=posicion;
				//eval((ns?nsdoc:iedoc)+'['+nr+'].focus()');
            try   {eval((iedoc)+'['+nr+'].focus()');}catch (e){ /* estaba oculto */}
				//setTimeout...;
				}
			else if (TC=='ColMinim')   { //Columna minimizada en un listado
            var col=eval(campo+'COL');
            var lst=eval(campo+'PADR');
            eval (lst+".maximiza("+col+")"); //La maximizamos
            eval (lst+".preparaCamposDR()");
            focaliza(campo,'');
            return;
            }
         else				{
            /*             if (!eval((ns?nsdoc:iedoc)+'.disabled'))
               eval((ns?nsdoc:iedoc)+'.focus()');
            */
            try   {
               var obj=eval(iedoc)
               if (!obj.disabled)
                  eval(obj.focus());
               }  catch (e)   { /* estaba oculto */}
            }
         
			if (TC=='Texto' || TC=='Textarea') {
            //if (!eval((ns?nsdoc:iedoc)+'.disabled'))
               //eval((ns?nsdoc:iedoc)+'.select()');
            if (!eval(iedoc+'.disabled'))
               eval(iedoc+'.select()');
            }
			}

		if (hacer_select) {
			if (TC=='Texto' || TC=='Textarea') 
            //if (!eval((ns?nsdoc:iedoc)+'.disabled'))
				   //eval((ns?nsdoc:iedoc)+'.select()');
            if (!eval(iedoc+'.disabled'))
				   eval(iedoc+'.select()');
			}
	}

function muestraMsgError (mensg)	{
	//Esta función saca un alert o una ventana modal en función de la variable window.alertModal
	//Se configura en globales.xml
	if (mensg == null)
		return;
	msg=mensg+'';
	if (msg=='')
		return;
	if (window.alertModal)	{
		if (window.alertModal.sFuncJS) {
			// evaluar funcion proyecto y llamarla
			eval(window.alertModal.sFuncJS+"(mensg)");
		} else {
         var vParam = new Object();
         // TODO: parametrizar los parametros enviados. Ahora esta limitado a descripcionMensaje
         vParam.descripcionMensaje = msg;
		 vParam.opener = window;
			var ret=window.showModalDialog(window.alertModal.drServlet +'?ON='+window.alertModal.ON, vParam, window.alertModal.sFeatures?window.alertModal.sFeatures:'');
		}

		}
	else 
		alert(msg);
	}

function muestraMsgErrorLOModal (msg,sfeatures,surl)	{
	if (!msg || msg=='')
		return;
   var vParam = new Object();
   vParam.descripcionMensaje = msg;
   vParam.opener = window;
   var ret=window.showModalDialog(surl+escape(msg), vParam, sfeatures);
	}

function escapeISO(str) {
	if (str) {
		str=str+'';
		var myRe=/&#(\d+);/;
		var myArray;
		do {
			myArray=myRe.exec(str);
			if (myArray!=null) {str=str.replace(new RegExp(myArray[0],"g"),String.fromCharCode(myArray[1]));}
		}while(myArray!=null);
	}
	return str;
}

// Devuelve el valor del campo (campo='form.nombre')
function get(campo,p1) {
		var valor="";
		var TC=eval(campo+'TC');
		//var nsdoc=eval(campo+'NS');
		var iedoc=eval(campo+'IE');
		switch(TC) {
			case 'Hidden': valor=eval('document.'+campo+'.value'); break;
			case 'Texto':	valor=eval(iedoc+'.value');break;
			case 'Textarea':	valor=eval((iedoc)+'.value');break;
			case 'Radio':	for(var j=0;j<eval((iedoc)+'.length');j++) {
										if (eval((iedoc)+'['+j+'].checked')) {valor=eval((iedoc)+'['+j+'].value'); break;}
									}
									break;			
			case 'Checkbox':	valor=eval((iedoc)+'.checked');
									if (valor==true) {valor='S';} else {valor='N';}
									break;
			case 'Combo':	// get(combo) devuelve un array
										//var n=eval(ns?nsdoc:iedoc);
                              var n=eval(iedoc);
										if (n.type=='select-one') {
											if (n.selectedIndex==-1) {valor='';break;}
											if (p1 && p1=='T') {valor=[n.options[n.selectedIndex].text];}
											else {valor=[n.options[n.selectedIndex].value];}
										}
										else {
											var token=new Array();
											var contador=0;
											for(var j=0;j<n.length;j++) {
												if (n.options[j].selected) {
													if (p1 && p1=='T') {token[contador++]=n.options[j].text;}
													else {token[contador++]=n.options[j].value;}
												}
											}
											valor=token;
										}
										break;
         case 'Listado':   var nobj=eval(campo+'OBJ');
                           var lst=eval(nobj);
                           valor=eval(nobj).get();
                           break;
         case 'ColMinim':  //columna oculta en el listado
                           valor=eval('document.'+campo+'.value'); break;
                           break;
		}
		return valor;
}

wMoveTo=moveTo;

// Mueve una capa a las coordenadas x,y
function moveTo(nombre,x,y) {
/* 	if (ns) {
		var nsdoc=eval(nombre+'.nsdoc');
		nsdoc=nsdoc.substring(0,nsdoc.length-9);
		nsdoc=eval(nsdoc);
		nsdoc.left=x;
		nsdoc.top=y;
	}
	else { */
	
		document.all[nombre].style.left=x;
		document.all[nombre].style.top=y;
	//}
}

// Mueve una capa incremntox, incrementoy
function moveBy(nombre,incx,incy) {
/* 	if (ns) {
		var nsdoc=eval(nombre+'.nsdoc');
		nsdoc=nsdoc.substring(0,nsdoc.length-9);
		nsdoc=eval(nsdoc);
		nsdoc.left+=incx;
		nsdoc.top+=incy;
	}
	else { */
	
		document.all[nombre].style.left=document.all[nombre].offsetLeft+incx;
		document.all[nombre].style.top=document.all[nombre].offsetTop+incy;
/* 	} */
	
}

// Corrección scroll en IE
var scrollIEname=null;

if (ie) {
	document.onmousemove=scrollIEmove;
	document.onmouseup=scrollIEup;
}
function scrollIEmove() {
	if (scrollIEname) {
		if (eval(scrollIEname+'.activoy>0')) {eval(scrollIEname+'ay()');}
		else if (eval(scrollIEname+'.activox>0')) {eval(scrollIEname+'ax()');}
		return false;
	}
	return true;
}
function scrollIEup() {
	if (scrollIEname) {
//		if (eval(scrollIEname+'.activoy!=0')) {eval(scrollIEname+'.activoy=0');}
		if (eval(scrollIEname+'.activoy!=-1')) {eval(scrollIEname+'.activoy=0');}
//		else {eval(scrollIEname+'.activox=0');}
                else {if (eval(scrollIEname+'.activox!=-1')) eval(scrollIEname+'.activox=0');}
		scrollIEname=null;
		return false;
	}
	return true;
}

// Controla el movimiento de la ventana de scroll verticalmente
// Alto mínimo del scroll: 63px
function scrolly(nombre,inc) {
	if (window.FLAG_SCR_NATIVO=='S') {return;}
	if (eval(nombre+'.activoy')==0) {return;}
/* 	if (ns) {
		var nsdoc=eval(nombre+'.nsdoc');
		var H=eval(nombre+'.height');
		var h=eval(nsdoc+'.'+nombre+'.document.height');
		var alto=eval(nombre+'.alto');
	}
	else { */
	
		var H=document.all[nombre+'Divtv'].scrollHeight;
		var h=document.all[nombre].scrollHeight;
		var err=document.all[nombre+'Divtv'].scrollTop;
		if (err!=0) {
			document.all[nombre+'Divtv'].scrollTop=0;	
			inc=-err;
		}
		var alto=document.all[nombre+'AscensorImg'].style.pixelHeight;
/* 	} */
	
	var T=eval(nombre+'.top');T+=inc;
	if (h<=H || T>0) {T=0;}
	else {if (T<(H-h)) {T=H-h;}}
	eval(nombre+'.top='+T);
	//if (ns) {eval(nsdoc+'.'+nombre+'.top='+T);}
	//else {
      document.all[nombre].style.top=T;
      //}
	if(H!=h) {var a=(H-(alto+32))/(H-h);} else {var a=0;}
        var b=16;
        var t=a*T+b;
        if (t<16) {t=16;}
	else if (t>(H-alto-16)) {t=(H-alto-16);}
        //if (ns) {eval(nsdoc.substring(0,nsdoc.length-14)+'Divsv.top='+t);}
        //else {
           document.all[nombre+'Divsv'].style.top=t;
           //}
        /* Sincronización de scroll */
        var capa_asociada=eval(nombre+'.asociay');
        if (capa_asociada) {
                //if (ns) {capa_asociada=eval(capa_asociada);nsdoc=capa_asociada.nsdoc.substring(0,capa_asociada.nsdoc.length-9);eval(nsdoc+'.top='+(T+eval(nombre+'.yoffset')*1));}
                //else {
                   document.all[capa_asociada].style.top=(T+eval(nombre+'.yoffset')*1);
                   //}
        }
        /* */
        if (eval(nombre+'.activoy')==1) {setTimeout("scrolly('"+nombre+"',"+inc+")",30);}
}

function paginadoy(nombre, ypos) {
	objeto=eval(nombre);
	var pmouse=ypos-16-objeto.ypos;
	var pasc;
	//if (ns) {var nsdoc=eval(nombre+'.nsdoc');pasc=eval(nsdoc.substring(0,nsdoc.length-14)+'Divsv.top')-16;}
	//else {
      pasc=parseInt(document.all[nombre+'Divsv'].style.top)-16;
      //}
	objeto.activoy=2;
	if (pmouse<pasc) {scrolly(nombre,objeto.height-16-20);} // corrección 16 ancho scroll, 20 alto medio de línea
	else {scrolly(nombre,-objeto.height+16+20);} // corrección 16 ancho scroll, 20 alto medio de línea
	objeto.activoy=0;
}

function paginadox(nombre, xpos) {
	objeto=eval(nombre);
	var pmouse=xpos-16-objeto.xpos;
	var pasc;
	//if (ns) {var nsdoc=eval(nombre+'.nsdoc');pasc=eval(nsdoc.substring(0,nsdoc.length-14)+'Divsh.left')-16;}
	//else {
      pasc=parseInt(document.all[nombre+'Divsh'].style.left)-16;
      //}
	objeto.activox=2;
	if (pmouse<pasc) {scrollx(nombre,objeto.height);}
	else {scrollx(nombre,-objeto.height);}
	objeto.activox=0;
}

function getRealTop(objeto) {
    yPos = objeto.offsetTop;
    tempEl = objeto.offsetParent;
    while (tempEl != null) {yPos += tempEl.offsetTop;tempEl = tempEl.offsetParent;}
    return yPos;
}
function getRealLeft(objeto) {
    xPos = objeto.offsetLeft;
    tempEl = objeto.offsetParent;
    while (tempEl != null) {xPos += tempEl.offsetLeft;tempEl = tempEl.offsetParent;}
    return xPos;
}

// Controla el ascensor del scroll vertical
function ascensory(nombre,yy) {
	if (eval(nombre+'.activoy!=2')) {return false;}
        /* if (ns) {
                var nsdoc=eval(nombre+'.nsdoc');
                var H=eval(nombre+'.height');
                var h=eval(nsdoc+'.'+nombre+'.document.height');
		var alto=eval(nombre+'.alto');
        }
        else { */
        
                var H=document.all[nombre+'Divtv'].scrollHeight;
                var h=document.all[nombre].scrollHeight;
		var alto=document.all[nombre+'AscensorImg'].style.pixelHeight;
/*         } */
        
        var ypos=eval(nombre+'.ypos');
	var t=yy-ypos-16-alto/2;
	var t0=t;
	alto+=32;
	if (t<0) {t=0;}
	else if (t>H-alto) {t=H-alto;}
	var T=t*((H-h)/(H-alto));
        var inc=T-eval(nombre+'.top');
        scrolly(nombre,inc);
}



// Controla los eventos asociados al movimiento  horizontal y vertical de la ventana de scroll nativo de IE
function onScrollNativoIE (nombre)	{
	//Controlamos la existencia de capas asociadas y si las hay las movemos (por ejemplo las del objeto rejilla)
	var capa_asociadax=eval(nombre+'.asociax');
	var capa_asociaday=eval(nombre+'.asociay');
	var offx=eval(nombre+'.xoffset');
	var offy=eval(nombre+'.yoffset');
   if (!offx)
      offx=0;
   if (!offy)
      offy=0;

   var tAsoc=eval(nombre+'.tipoAsoc');
   if (!tAsoc)
      tAsoc='';
   
	if (capa_asociadax) {
      if (tAsoc=='scrollInterno')
         document.all[capa_asociadax].scrollLeft=document.all[nombre].scrollLeft;
      else
   		document.all[capa_asociadax].style.left=-(document.all[nombre].scrollLeft-offx);
      }
	if (capa_asociaday) {
      if (tAsoc=='scrollInterno')   {
         document.all[capa_asociaday].scrollTop=document.all[nombre].scrollTop;
         //document.all[capa_asociaday].scrollTop=-1000;
         //document.all[capa_asociaday].style.top=0;
         //window.status=document.all[capa_asociaday].scrollTop+" - "+capa_asociaday+" - "+document.all[nombre].scrollTop;
         }
      else
   		document.all[capa_asociaday].style.top=-(document.all[nombre].scrollTop-offy);		
      }

	return;
	}



// Controla el movimiento de la ventana de scroll horizontalmente
function scrollx(nombre,inc) {
	if (window.FLAG_SCR_NATIVO=='S') 
		return;

	if (eval(nombre+'.activox')==0) {return;}
/* 	if (ns) {
		var nsdoc=eval(nombre+'.nsdoc');
		var W=eval(nombre+'.width');
		var w=eval(nsdoc+'.'+nombre+'.document.width');
	}
	else { */
	
		var W=document.all[nombre+'Divtv'].scrollWidth;
		var w=document.all[nombre].scrollWidth;
/* 	} */
	
	var L=eval(nombre+'.left');L+=inc;
	if (w<=W || L>0) {L=0;}
	else {if (L<(W-w)) {L=W-w;}}
	eval(nombre+'.left='+L);
	//if (ns) {eval(nsdoc+'.'+nombre+'.left='+L);}
	//else {
      document.all[nombre].style.left=L;
      //}
	if (W!=w) {var a=(W-69)/(W-w);} else {var a=0;}
	var b=16;		
	var l=a*L+b;
	if (l<16) {l=16;}
	else if (l>(W-53)) {l=(W-53);}
	//if (ns) {eval(nsdoc.substring(0,nsdoc.length-14)+'Divsh.left='+l);}
	//else {
      document.all[nombre+'Divsh'].style.left=l;
      //}
	/* Sincronización de scroll */
	var capa_asociada=eval(nombre+'.asociax');
	if (capa_asociada) {
		//if (ns) {capa_asociada=eval(capa_asociada);nsdoc=capa_asociada.nsdoc.substring(0,capa_asociada.nsdoc.length-9);eval(nsdoc+'.left='+(L+eval(nombre+'.xoffset')*1));}
		//else {
         var tAsoc=eval(nombre+'.tipoAsoc');
         if (!tAsoc)
            tAsoc='';
         if (tAsoc=='scrollInterno')
            document.all[capa_asociada].scrollLeft=-(L);
         else
            document.all[capa_asociada].style.left=(L+eval(nombre+'.xoffset')*1);
        // }
	}
	/* */
	if (eval(nombre+'.activox')==1) {setTimeout("scrollx('"+nombre+"',"+inc+")",30);}
}

// Controla el ascensor del scroll horizontal
function ascensorx(nombre,xx) {
if (eval(nombre+'.activox!=2')) {return false;}
	var xpos=eval(nombre+'.xpos');
	var l=xx-xpos-34;
/* 	if (ns) {
		var nsdoc=eval(nombre+'.nsdoc');
		var W=eval(nombre+'.width');
		var w=eval(nsdoc+'.'+nombre+'.document.width');
	}
	else { */
	
		var W=document.all[nombre+'Divtv'].scrollWidth;
		var w=document.all[nombre].scrollWidth;
	//}
	if (l<0) {l=0;}
	else if (l>(W-69)) {l=W-69;}
	var L=l*(W-w)/(W-69);
	var inc=L-eval(nombre+'.left');
	scrollx(nombre,inc);
}

// Cambia el html de una ventana de scroll
function scroll_to(nombre, html)
{
/* 	if (ns) {
		var nsdoc=eval(nombre+'.nsdoc');
		nsdoc+='.layers["'+nombre+'"].document';
		eval(nsdoc+'.open()');
		eval(nsdoc+'.write(html)');
        eval(nsdoc+'.close()');		
      }
    else if (ie) { */
	
       if (!document.all[nombre])   
          return;
       document.all[nombre].innerHTML=html;
/*        } */
       
	eval(nombre+"_init()");
	if (eval(nombre+'.activoy!=-1')) {eval(nombre+'.activoy=1');scrolly(nombre,+100000);eval(nombre+'.activoy=0');}
	if (eval(nombre+'.activox!=-1')) {eval(nombre+'.activox=1');scrollx(nombre,+100000);eval(nombre+'.activox=0');}
}

// Simula la pulsación de la capa 'capa' en las solapas 'solapa'.
function solapas_to(solapa,capa,noAccion) { // Si existe noAccion (poner a true), no ejecuta accion (primera vez que carga las solapas)
	var S=eval(solapa);
	if (noAccion) {/*NOP*/}
	else {
		if (S.accion) {
			if (eval(S.accion)==false) return;
		}
	}
	var flag=false;
	var pestaniai;
	for(var i=0;i<S.pestanias.length;i++) {
		pestaniai=S.pestanias[i];
		if (pestaniai==capa) {S.indiceSeleccionada=i;img_to(solapa+i+'',solapa+i+'.chk');visibilidad(capa,'V');flag=true;}
		else if (eval(pestaniai+'.vsb')=='visible') {img_to(solapa+i+'',solapa+i+'.off');visibilidad(pestaniai,'O');}
	}
	if (!flag) {solapas_to(solapa,S.i);}	else {S.i=capa;}
}

function getClip(capa) {
	var obj;
/* 	if (ns) {
		var o=eval(capa);
		var nsdoc=o.nsdoc.substring(0,o.nsdoc.length-9);
		obj=eval(nsdoc);
		return [obj.clip.top,obj.clip.right,obj.clip.bottom,obj.clip.left];
	}
	else { */
	
		obj=document.all[capa];
		var clipv = obj.style.clip;
		if (clipv=='') {clipv="rect(0px "+obj.style.width+" "+obj.style.height+" 0px)";}
		clipv = clipv.split("rect(")[1].split(")")[0].split("px");
		return [Number(clipv[0]),Number(clipv[1]),Number(clipv[2]),Number(clipv[3])];
/* 	} */
	
}

function setClip(capa,valores) {
	var obj;
/* 	if (ns) {
		var o=eval(capa);
		var nsdoc=o.nsdoc.substring(0,o.nsdoc.length-9);
		obj=eval(nsdoc);
		obj.clip.top=valores[0];
		obj.clip.right=valores[1];
		obj.clip.bottom=valores[2];
		obj.clip.left=valores[3];
	}
	else { */
	
		obj=document.all[capa];
		obj.style.clip="rect("+valores[0]+"px "+valores[1]+"px "+valores[2]+"px "+valores[3]+"px)";
/* 	} */
	
}

// Muestra (código=V) /oculta(O)/ Conmunta(C) una capa
function visibilidad(nombre,codigo)
{	
	var tipo;
	var TC=eval(nombre+'.TC');
	if (codigo=='visible' || codigo=='inherit') {codigo='V';}
	else if (codigo=='hidden' || codigo=='hide') {codigo='O';}
	if (TC=='Menu') {visibilidad_menu(nombre,codigo);return;}
/* 	if (ns) {
		var nsdoc=eval(nombre+'.nsdoc');
		nsdoc=nsdoc.substring(0,nsdoc.length-9);
		if (codigo=='V') {tipo="inherit";}
		else if (codigo=='O') {tipo="hide";}
		else if (codigo=='C') {tipo=eval(nombre+'.vsb');if (tipo=="visible") {tipo="hide";} else {tipo="inherit";}}
		eval(nsdoc+'.visibility="'+tipo+'"');
	}
	else { */
	
		if (codigo=='V') {tipo="inherit";}
		else if (codigo=='O') {tipo="hidden";}
		else if (codigo=='C') {tipo=eval(nombre+'.vsb');if (tipo=="visible") {tipo="hidden";} else {tipo="inherit";}}
		eval('document.all["'+nombre+'"].style.visibility="'+tipo+'"');
/* 	} */
	
	if (tipo=="inherit") {eval(nombre+'.vsb="visible"');} else {eval(nombre+'.vsb="hidden"');}
	if (TC!='Capa' || tipo!='inherit') {return;} 	// Contravisibilidad
	var contravsb=eval(nombre+'.contravsb');
	if (contravsb!='') eval(contravsb);
}

// devuelve true/false según una capa esté visible o no
function get_visibilidad(nombre) {
	n=eval(nombre);
	if (n.vsb=="visible") {return true;}
	else {return false;}
}

//window.deshabilitadoColor="red";

function accion(campo, tipo_accion) {
/* 	if (ns) {var nsdoc=eval(campo+'NS'); eval(nsdoc+tipo_accion);}
	if (ie) { */
	
		var iedoc=eval(campo+'IE');
      eval(iedoc+tipo_accion);
		if (tipo_accion=='.disabled=true' && window.deshabilitadoColor) {
			var obj=eval(eval(campo+'IE'));
			if (eval(campo+'TC')=='Radio') {
            for(var j=0;j<obj.length;j++) {
               if (window.deshabilitadoColor)
               eval(iedoc+'['+j+'].style.backgroundColor=window.deshabilitadoColor');
               eval(iedoc+'['+j+']'+tipo_accion);
               }
            }
			else {
				obj.style.backgroundColor=window.deshabilitadoColor;
				obj.style.fontWeight='bold';
				if (window.disableFontSize) obj.style.fontSize=window.disableFontSize;
			}
		}
		if (tipo_accion=='.disabled=false') {
			var color=null;
			var oblig=eval(campo+"MV");
			if (oblig=='C') {color=window.requeridoS;}
			else {color=window.requeridoN;}

			var obj=eval(eval(campo+'IE'));
			if (eval(campo+'TC')=='Radio') {
            for(var j=0;j<obj.length;j++) {
               eval(iedoc+'['+j+']'+tipo_accion);
               eval(iedoc+'['+j+'].style.backgroundColor="'+color+'"');
               }
            }
			else {
				obj.style.backgroundColor=color;
				obj.style.fontWeight='normal';
				if (window.enableFontSize) obj.style.fontSize=window.enableFontSize;
			}
		//}
	}
}

window.requeridoS='red';
window.requeridoN='white';

// Establece el modo de validación
function setMV(campo,valor,MR) {
	if (valor=='S' || valor=='C') {valor='C';}
	else if (valor=='N' || valor=='c') {valor='c';}
	else {muestraMsgError(DrdMsgCore(180));return;}
	if (MR) {eval(campo+'MR="'+MR+'"');}
	eval(campo+"MV='"+valor+"'");
	if (ie) {
		var obj=eval(eval(campo+'IE'));if (obj.disabled) {return;}
		if (window.requeridoS && valor=='C') {
			var obj=eval(eval(campo+'IE'));
			if (eval(campo+'TC')=='Radio') {for(var j=0;j<obj.length;j++) {eval(eval(campo+'IE')+'['+j+'].style.backgroundColor=window.requeridoS');}}
			else obj.style.backgroundColor=window.requeridoS;
		}
		else if (window.requeridoN && valor=='c') {
			var obj=eval(eval(campo+'IE'));
			if (eval(campo+'TC')=='Radio') {for(var j=0;j<obj.length;j++) {eval(eval(campo+'IE')+'['+j+'].style.backgroundColor=window.requeridoN');}}
			else obj.style.backgroundColor=window.requeridoN;
		}
	}
}

// Permite foco sobre campo si campo_ref cumple el criterio acerca de valor. En caso contrario lo expulsa
function admiteFoco(campo,campo_ref,criterio,valor)
{
		if (!eval('\''+get(campo_ref)+'\''+criterio+'\''+valor+'\'')) {accion(campo,'.blur()');}
}

function vacia(campo1,campo2) {
	if (get(campo2)=='') {set(campo1,'');setMV(campo1,'c');}
}

// Objecto Vector compatible NS/IE
function Vector(nombre) {
	this.nombre=''; if (nombre) this.nombre=nombre;
	this.longitud=0;
	this.bd=new Array();

	this.eliminar=vectorEliminar;
	this.insertar=vectorInsertar;
	this.modificar=vectorModificar;
	this.cargar=vectorCargar;
	this.volcar=vectorVolcar;
	this.token=vectorToken;
	this.agregar=vectorAgregar;
	this.ij=vectorIJ;
	this.ij2=vectorIJ2;
	this.buscar=vectorBuscar;
	this.unir=vectorUnir;
	this.filtrar=vectorFiltrar;
	this.borrar=vectorBorrar; // Borra todo el vector
	this.ordenar=vectorOrdenar;
}

// ('N'/'L','str_ini'/''[,col]) -> 'Numérico/Lexicográfico', 'cadena inicial a partir de la cual compara',columna de ordenación)
// Si un elemento no es numérico, se ubica al final en una ordenación N
function vectorOrdenar(tipo,str,col) {
	var min;
	var ci,cmin;
	var s;
	for(var i=0;i<this.bd.length-1;i++) {
		min=i;
		if (col || col==0) {cmin=this.bd[i][col];} else {cmin=this.bd[i];}
		if (str!='') {cmin=cmin.substring(cmin.indexOf(str));}
		if (tipo=='N') {if (isNaN(cmin*1)) {cmin=Number.MAX_VALUE} else {cmin=cmin*1;}}
		for(var j=i+1;j<this.bd.length;j++) {
			if (col || col==0) {ci=this.bd[j][col];} else {ci=this.bd[j];}
			if (str!='') {ci=ci.substring(ci.indexOf(str));}
			if (tipo=='N') {if (isNaN(ci*1)) {ci=Number.MAX_VALUE} else {ci=ci*1;}}
			if (ci<cmin) {	min=j;cmin=ci;	}
		}
		if (min!=i) {s=this.bd[i];this.bd[i]=this.bd[min];this.bd[min]=s;}
	}
}

function vectorIJ(i,j) {
	if (i<0 || i>=this.bd.length) {muestraMsgError("Vector '"+this.nombre+DrdMsgCore(187)+i+".");return false;} //err indexado en i=...
	if (j || j==0) {
		if (j<0 || j>=this.bd[i].length) {muestraMsgError("Vector.ij:"+DrdMsgCore(188));return false;} //err indexado en j
		return this.bd[i][j];
	}
	else {return this.bd[i];}
}

function vectorIJ2(valor,i,j) {
	if (i<0 || i>=this.bd.length) {muestraMsgError("Vector.ij2:"+DrdMsgCore(189));return false;} //err indexado en i
	if (j || j==0) {
		if (j<0 || j>=this.bd[i].length) {muestraMsgError("Vector.ij2:"+DrdMsgCore(188));return false;} //err indexado en j
		this.bd[i][j]=valor;
	}
	else {this.bd[i]=valor;}
	return true;
}

function vectorInsertar(indice,valor) {
	for(var i=this.longitud;i>indice;i--) {this.bd[i]=this.bd[i-1];}
	this.bd[indice]=valor;
	this.longitud++;
}

function vectorEliminar(indice) {
	for(var i=indice+1;i<this.longitud;i++) {this.bd[i-1]=this.bd[i];}
	this.bd.length--;this.longitud--;
}

function vectorModificar(indice,valor) {
	this.eliminar(indice);
	this.insertar(indice,valor);
}

/*function vectorCargar(matriz) {
	delete this.bd;
	this.bd=new Array();
	for(var i=0;i<matriz.length;i++) {this.bd[i]=matriz[i];}
	this.longitud=this.bd.length;
}*/

function vectorCargar(matriz) {
        delete this.bd;
        this.bd=new Array();
        for(var i=0;i<matriz.length;i++) {
			if (matriz[i].constructor==Array) {
				this.bd[i]=new Array(); for(var j=0;j<matriz[i].length;j++) {this.bd[i][j]=matriz[i][j];}
			}
			else {this.bd[i]=matriz[i];}
		}
        this.longitud=this.bd.length;
}

// Devuelve la entrada en que se encuentra campo (-1 si no existe)
function vectorBuscar(campo,columna) {
	for(var i=0;i<this.bd.length;i++) {
		if (columna || columna==0) {if (this.bd[i][columna]==campo) {return i;}}
		else {if (this.bd[i]==campo) {return i;}}
	}
	return -1;
}

function vectorToken(separador,cadena) {
	var bd2=cadena.split(separador);
	this.cargar(bd2);
}

function vectorVolcar() {return this.bd;}

function vectorAgregar(valor) {
	this.bd[this.bd.length]=valor;
	this.longitud=this.bd.length;
}

// esta función asume vector de arrays. Si no existe columna, une el vector
function vectorUnir(separador,columna) {
	var token='';var flag=false;
	for(var i=0;i<this.bd.length;i++) {
		if (flag) {token+=separador;}
		if (columna || columna==0) {token+=this.bd[i][columna];flag=true;}
		else {token+=this.bd[i];flag=true;}
	}
	return token;
}

function vectorBorrar() {
	delete this.bd;
	this.bd=new Array();
	this.longitud=this.bd.length;
}

//filtrar([1,2], [ ['&',1,'==','val1'] , ['|',2,'!=','val2'] , ...])
//filtrar([1,2], '*') => filtra las cols 1 y 2 de todas las entradas
//filtrar([-1], criterios) => filtra todas las cols de las filas que cumplan criterios
function vectorFiltrar(columnas,criterios)
{
	var salida=new Array();
	var contador=0;
	var test=false;
	for (var i=0;i<this.bd.length;i++) {
		if (criterios=='*') {test=true;}
		else {
			for(k=0;k<criterios.length;k++) {
				test2=eval('\''+this.bd[i][criterios[k][1]]+'\''+criterios[k][2]+'\''+criterios[k][3]+'\'');
				if (k!=0) {
					if (criterios[k][0]=='&') {test=test&&test2;}
					if (criterios[k][0]=='|') {test=test||test2;}
				}
				else {test=test2;}
			}
		}
		if (test) {	// Se cumple el criterio
			salida[contador]=new Array();
			if (columnas[0]==-1) {for (var j=0;j<this.bd[i].length;j++) {salida[contador][j]=this.bd[i][j];}}
			else {
				var contador2=0;
				for (var j=0;j<columnas.length;j++) {salida[contador][contador2++]=this.bd[i][columnas[j]];}
			}
			contador++;
		}
	}
return salida;
}

// Devuelve pon# si micampo==val#. En caso contrario, devuelve micampo
//decode(micampo,[['val1','pon1'],['val2','pon2'],...]);
function decode(campo,lista) 
{
	for(var i=0;i<lista.length;i++) {if (campo==lista[i][0]) {return lista[i][1];}}
	return campo;
}

// Muestra el valor de los campos del formulario f en un alert. Función de depuración
function formulario(f)
{
var cad='';
var f1=eval('document.'+f);
for (var i=0;i<f1.elements.length;i++) {cad=cad+f1.elements[i].name+"="+f1.elements[i].value+" \t"}
alert(cad);
return false;
}

// funciones de debug (borrar)
function funcion(f)
{
formulario(f);
}

function ver_array(matriz) {
	var w=window.open('','','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,top=100,left=100,width=500,height=400');
   var body='<TABLE BORDER=1>';
	for(var i=0;i<matriz.length;i++) {
		body+='<TR><TD>'+i+'</TD>';
		if (matriz[i].__proto__==Array.prototype) {
			for(var j=0;j<matriz[i].length;j++) {
				body+='<TD>'+matriz[i][j]+'</TD>';
			}
		}
		else {body+='<TD>'+matriz[i]+'</TD>';}
		body+='</TR>';
	}
	body+='</TABLE>'
	w.document.write(body);
	w.document.close();
}


Array.prototype.mete= function (obj)   {//Mucho mas rapido que ir sumando en una cadena
   this[this.length]=obj;
   }

var d3canal_v=new Vector();

function asignar(componente,nombre,conector,ID,control) {
   var separador='',alert_='',excepcion_='',d3canal_componente='',d3canal_element='',d3canal_nombre='',d3canal_conector='',d3canal_ID='',d3canal_control='',d3canal_accion='';
   var entradas=new Array();
   var nombre_ventana_aleat="v"+ (new Date().getTime()) + (Math.round(1000*Math.random()))
   var nombre_ventana='';
   if (arguments.length==5) {entradas[0]=[componente,nombre,conector,ID,control];}
   else if (arguments.length==1) {entradas=componente;}
   else if (arguments.length==2) {entradas=componente;alert_=nombre;}
   else if (arguments.length==3) {entradas=componente;alert_=nombre;excepcion_=conector;}
   else {muestraMsgError(DrdMsgCore(190));return;} //Num argum asign incorrecto
   for(var i=0;i<entradas.length;i++) {
      if (i!=0) 
         separador='>';
      var tag=entradas[i][0]
      if (tag=="COMBO" || tag=="LISTA" || tag=="LISTAEDITABLE") {d3canal_element+=separador+'ROWSET';}
      else if (tag=="TEXT") {d3canal_element+=separador+'CAMPO';}
      else if (tag=="RAMA") {/*alert('si');*/}
      else if (tag=="VAR") {}
      else {muestraMsgError(DrdMsgCore(191)+tag+DrdMsgCore(192));return;} //Comp no permitido
      d3canal_componente+=separador+tag;
      if (entradas[i].length==5) {entradas[i][5]='-';}
      d3canal_nombre+=separador+entradas[i][1]+'@'+entradas[i][5];
      if (i==0) {nombre_ventana='DruidaOcultoAsignar'+entradas[0][1].replace(/\./g,'_');}
      d3canal_conector+=separador+entradas[i][2];
      d3canal_ID+=separador+(entradas[i][3]==''?'-':entradas[i][3]);
      d3canal_control+=separador+(entradas[i][4]==''?'-':entradas[i][4]);
      }
   var elForm=document.d3canal_form
   elForm.d3canal_componente.value=d3canal_componente;
   elForm.d3canal_nombre.value=d3canal_nombre;
   elForm.d3canal_conector.value=d3canal_conector;
   elForm.d3canal_ID.value=d3canal_ID;
   elForm.d3canal_control.value=d3canal_control;
   elForm.d3canal_element.value=d3canal_element;
   elForm.d3canal_alert.value=alert_;
   elForm.d3canal_excepcion.value=excepcion_;
   if (window.oculta_asignar) 
      {d3ocupado_ver('d3general',d3ocupado_general);}

   if (window.tipoAsignarJs && window.tipoAsignarJs=='IFRAME')    {
      elForm.target=getFreeComCh();
      if (navigator && navigator.appVersion.indexOf("MSIE 5.0")==-1) //En la 5.0 del IE la instrucción de abajo da problemas
         document.all[""+elForm.target].parent=self.name;
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
      var ai = new AJAXInteraction();
	  ai.enviar(elForm.action,params);
      // Fin modificaciones
   }
   else    {
      if (d3canalCloseWindow) {
   		 ventana = DrdNuevaVentanaMinim(nombre_ventana_aleat);
         }
      else {
         ventana = DrdNuevaVentana(nombre_ventana_aleat);
         }
      ventana.blur();
      d3canal_v.agregar([nombre_ventana,ventana]);
      //elForm.target=nombre_ventana;
	   elForm.target=nombre_ventana_aleat;
      elForm.submit();
      }
   }


// asignarException="mifuncion(msgError)"; // Si retorna TRUE se continua con la ejecución normalmente
var asignarException=null; 

function d3canal(msgError,componentes) {
	var nombre_ventana='';
   var continuar=true;
	if (asignarException && msgError!='')  //Si hay mensaje de error ...
      continuar=eval(asignarException);
   var nombre_ventana="";
   if (componentes.length>0)
      nombre_ventana='DruidaOcultoAsignar'+componentes[0][1].substring(0,(componentes[0][1].indexOf('@'))).replace(/\./g,'_');
	if (continuar) {
		for(var k=0;k<componentes.length;k++) {
			var datos=new Array();
			var componente=componentes[k][0];
			var pos=componentes[k][1].indexOf('@');
			var nombre=componentes[k][1].substring(0,pos);
			var accion=componentes[k][1].substring(pos+1);
			var rowset=componentes[k][2];
			for(var i=0;i<rowset.length;i++) { //Extraigo los datos
				if (componente!='TEXT') 
               {datos[i]=new Array(); for(var j=0;j<rowset[i].length;j++) {datos[i][j]=escapeISO(rowset[i][j]);}}
				else
               {datos[i]=escapeISO(rowset[i].toString());}
   			}
			if (accion!='-')  //EJECUTO EL ACCION?
            {eval(accion);}
			else { //POR DEFECTO, ASIGNO
				if (componente=="COMBO") {
					var valorinicial=eval(nombre+'valorinicial');
					var textoinicial=eval(nombre+'textoinicial');
					if (valorinicial!=null) {
						var datos2=new Array(); datos2[0]=[valorinicial,textoinicial];
						var datos3=datos2.concat(datos);
						datos=datos3;
					   }
					set_combo(nombre,datos,null);
				   }
				else if (componente=="TEXT" || componente=="VAR") 
               {set(nombre,escapeISO(rowset[0]));}
				else if (componente=="LISTA") {
					var objeto=eval(nombre);
					if (datos.length>0) {objeto.setDatos(datos);}
					else {objeto.datos.borrar();objeto.seleccion.borrar();}
					objeto.display();
   				}
				else if (componente=="LISTAEDITABLE") {
					var objeto=eval(eval(nombre+'OBJ'));
               objeto.setDatos(datos);
   				}
				else 
               {muestraMsgError(DrdMsgCore(191)+componente+DrdMsgCore(192));} //Comp no permitido
   			}
			datos=null;
			rowset=null;		
         }
   	}
   if (window.tipoAsignarJs && window.tipoAsignarJs!='AJAX') {
      var i=d3canal_v.buscar(nombre_ventana,0);
      if (i!=-1) {
         var ventana=d3canal_v.ij(i,1);
         if (d3canalCloseWindow) {ventana.close();}
         d3canal_v.eliminar(i);
         }
      }
	if (window.oculta_asignar) 
      {d3ocupado_ocultar('d3general');}
	if (!asignarException && msgError!='')
      {if (opener){opener.focus();}window.focus();muestraMsgError(msgError);}
   }

var d3canalCloseWindow=true; // Controla cerrar ventanas en d3canal para seguimiento de datos

// Desactiva botones en una botonera.
// indice: nº de orden del BTN (incluyendo imágenes fijas), empieza en 1.
// estado: 'activo','inactivo'
function set_estado_botonera(nombre,indice,estado) {
	var botonera=eval(nombre);
	var botonName=nombre+''+indice;
	var botonObj=eval(botonName);
	var valor;
	if (estado=='activo') {valor=true;if (botonObj.dis.src) img_to(botonName,botonName+'.off');}
	else if (estado=='inactivo') {valor=false;if (botonObj.dis.src) img_to(botonName,botonName+'.dis');}
	else {muestraMsgError(DrdMsgCore(193));return;} //estado no permit
	botonera.estado[indice]=valor;
}

function tooltip(e,alt) {
	if (arguments.length==2) {
		if (window.Event) { //ns
			document.tooltipDiv.top=e.pageY+16;
			document.tooltipDiv.left=e.pageX;
			document.tooltipDiv.document.open();
			document.tooltipDiv.document.write("<SPAN STYLE='background-color:#FFFFDF;font-family:arial;font-size:10pt'>&nbsp;"+alt+"&nbsp;</SPAN>");
			document.tooltipDiv.document.close();
			document.tooltipDiv.visibility='visible';
		}
		else { //ie
			document.all['tooltipDiv'].style.top=event.clientY+document.body.scrollTop+16;
			document.all['tooltipDiv'].style.left=event.clientX+document.body.scrollLeft;
//			document.all['tooltipDiv'].innerHTML="<SPAN STYLE='background-color:#FFFFDF;font-family:arial;font-size:10pt'>&nbsp;"+alt+"&nbsp;</SPAN>";
			document.all['tooltipDiv'].innerHTML="<SPAN STYLE='"+window.tooltipEstilo+"'>&nbsp;"+alt+"&nbsp;</SPAN>";
			document.all['tooltipDiv'].style.visibility='visible';
		}
	}
	else {
		if (window.Event) {document.tooltipDiv.visibility='hide';} //ns
		else {document.all['tooltipDiv'].style.visibility='hidden';} //ie
	}
	return true;
}

function druidaBack(on) {
   var lista="";
	var h=null;
	for(var i=0;i<document.all.length;i++) {
		if (document.all[i].name) {
			if (document.all[i].name=='d3history_'+on) {
				h=document.all[i].value;
			}
		}
	}
	if (h==null) {muestraMsgError(DrdMsgCore(194)+on+DrdMsgCore(195));return;}

   var txttarget=(window.HTML_CACHEADO)?" target=\"_parent\" ":"";

	var s='<form method=post name="f1" action="'+d3_PS+'" '+txttarget+'>';
	var ma=h.split(';');

	for(var j=0;j<ma.length;j++) {
		var ma2=ma[j].split('=');
      if (ma2[0]=='d3history_d3_back' || ma2[0]=='drd_tiempo_inicio' || ma2[0]=='drd_tiempo_total' || ma2[0]=='drd_comando' || ma2[0]=='drd_cod_al')   {
         //No hago nada
         }
      else if (ma2[0].substr(0,10)=='d3history_')   {
         lista+="<"+ma2[0].substr(10)+">"; //En el d3history_d3_back que mandemos tendrá que ir
         s+='<input type="hidden" name="'+ma2[0]+'" value="'+document.all[ma2[0]].value+'">';
         }
      else  {
         s+='<input type="hidden" name="'+ma2[0]+'"';
         if (ma2.length==2) {
            s+=' value="'+unescape(ma2[1].replace(/\+/g,' '))+'" ';}
         s+='>';
         }
		s+='\r\n';
   	}
   
   //var d3historyold=document.all['d3history_d3_back'].value; //De aquí he de quitar los que no tengan que ir

   var d3historyold=document.all['d3history_d3_back'];
   if (d3historyold.length)
      d3historyold=d3historyold[0];
   d3historyold=d3historyold.value;

   lista+="<"+on+">";   //Me quedo sólo con los que iban + el que hay que recuperar
   //Divido el d3history

   if (window.drd_tiempo_inicio) {
      s+='<input type="hidden" name="drd_tiempo_inicio" value="'+(new Date()).toUTCString()+'">';
      if (window.DRD_TIEMPO_TOTAL)
         s+='<input type="hidden" name="drd_tiempo_total" value="'+window.DRD_TIEMPO_TOTAL+'">';
      if (window.drd_comando)
         s+='<input type="hidden" name="drd_comando" value="'+window.drd_comando+'">';
      if (window.drd_comando)
         s+='<input type="hidden" name="drd_cod_al" value="'+window.drd_cod_al+'">';
      }

   s+='<input type="hidden" name="d3history_d3_back" value="*'+d3historyold+'">';
	s+='</form>';


   /*

      var c160=';',c159='=',c158='&',c157='#',c156='$';
      if (h) {
         var nombre,comp,values,pages=h.substring(1).split(c160);
         for(var i=0;i<pages.length;i++) {
            comp=pages[i].split(c159);
            if (comp[0]==nombrePagina()) {

      */

   // +++++++++++++++
   //alert('VOY A '+on);
   //alert('Y Tengo '+DrdHBListaPaginas());
   //alert('pero envio '+l);
   //alert("LO QUE MANDO\n"+s);

	document.body.innerHTML=s;
   
	document.f1.submit();
}

function setTextSize(caja,size) {accion(caja,'.size='+size);}
function setTextMaxLength(caja,maxLength) {accion(caja,'.maxLength='+maxLength);}

var d3historyBack=false; // establecer a true en el XML para guardar valores de salida
function saveValoresPagina() {
   if (window.DBck==null)
      return
   var d3hb=document.all['d3history_d3_back']
	if (ns || document.all['d3history_d3_back']==null)
      {return;}
   if (d3hb.length)
      d3hb=d3hb[0];
	var h=d3hb.value;
	if (h && h.charAt(0)=='*') {d3hb.value=h.substring(1);}
	if (d3historyBack==false)
      return;
	var c160=';',c159='=',c158='&',c157='#',c156='$';
	var obj,nombre,s=nombrePagina();
	for(var j=0;j<d3_componentes.length;j++) {
		nombre=d3_componentes[j][1];
		s+=c159+d3_componentes[j][0];
		s+=c158+nombre;
		switch(d3_componentes[j][0]) {
			case 'TEXT':	s+=c158+escape(eval(nombre+'MV'));
							obj=eval(eval(nombre+'IE')); s+=c158+escape(obj.disabled==true);
			case 'CHECKBOX': // disbale
			case 'VAR': s+=c158+escape(get(nombre)); break;
			case 'LABEL':
			case 'LABELC': obj=eval(nombre);s+=c158+escape(obj.txt); break;
			case 'CAPA': obj=eval(nombre);s+=c158+escape(obj.vsb); break;
			case 'COMBO':	obj=eval(eval(nombre+'IE')); s+=c158+escape(obj.disabled==true);
							s+=c158+escape(get(nombre).toString());
							break;
			case 'BOTON': obj=eval(nombre);s+=c158+escape(obj.tipo);s+=c158+escape(obj.estado); break;
			case 'LISTAboton':	obj=eval(nombre);
								var fila,datos='';
								for(var k=0;k<obj.datos.bd.length;k++) {
									fila=obj.datos.bd[k];
									if (datos!='') datos+=c157;
									for(k2=0;k2<fila.length;k2++) {
										if (k2>0) datos+=c156;
										datos+=escape(fila[k2]);
									}
								}
								s+=c158+datos;
								datos='';
								for(var k=0;k<obj.seleccion.bd.length;k++) {
									if (k>0) datos+=c156;
									datos+=escape(obj.seleccion.bd[k]);
								}
								s+=c158+datos;
								break;
			case 'PAGINADO':	obj=eval(nombre); s+=c158+escape(obj.indices);
								s+=c158+escape(obj.ultima);s+=c158+escape(obj.pagina);
								s+=c158+escape(obj.formulario.paginado_control.value);
								s+=c158+escape(obj.formulario.paginado_conector.value);
								s+=c158+escape(obj.formulario.paginado_idrowset.value);
								break;
		   }
	   }
	var pages=null;
	var h=d3hb.value;
	if (h) {
		var i,comp;
		pages=h.split(c160);
		for(i=0;i<pages.length;i++) {
			comp=pages[i].split(c159);
			if (comp[0]==nombrePagina()) 
            {pages[i]=s;break;}
		   }
		if (i==pages.length) 
         {pages[pages.length]=s;}
	   }
	else 
      {pages=new Array(s);}
	d3hb.value=pages[0];
	if (pages.length>1) {
		for(var i=1;i<pages.length;i++) {d3hb.value+=c160+pages[i];}
	   }
   DrdHBSimplifica();

// +++++++++++++++
//alert("saveValoresPagina:\nEl valor de d3history_d3_back era:\n"+document.all['d3history_d3_back'].value);

   }
   
   function DrdHBSimplifica() { //Codifica los valores de los campos d3history_XXX para que no repitan el valor de d3history_d3_back
   var pags=DrdHBListaPaginas();
   for (var i=0;i<pags.length;i++)  {
      //Elimino las referencias al atributo d3history_d3_back, que generaré luego dinámicamente
      var simpl="";asimplif=document.all['d3history_'+pags[i]].value;
      var a=asimplif.split(';');
      for(var j=0;j<a.length;j++) {
         var a2=a[j].split('=');
         if (a2[0]=='d3history_d3_back') {
            //No hago nada
            }
         else if (a2[0].substr(0,10)=='d3history_') {
            if (j>0)
              simpl+=";";
            simpl+=a2[0]+"= ";
            }
         else {
            if (j>0)
              simpl+=";";
            simpl+=a[j];
            }
         }
      //alert('para d3history_'+pags[i]+" antes:\n"+asimplif+"\n despues:\n"+simpl);
      document.all['d3history_'+pags[i]].value=simpl;
      }
   }


function loadValoresPagina() {
   if (window.DBck==null)
      return
   var d3hb=document.all['d3history_d3_back']
	if (ns || d3hb==null) {return;}
   if (d3hb.length)
      d3hb=d3hb[0];
	var obj,h=d3hb.value;
	if (d3historyBack==false || (h && h.charAt(0)!='*')) return;
	d3hb.value=h.substring(1);
	var c160=';',c159='=',c158='&',c157='#',c156='$';
	if (h) {
		var nombre,comp,values,pages=h.substring(1).split(c160);
		for(var i=0;i<pages.length;i++) {
			comp=pages[i].split(c159);
			if (comp[0]==nombrePagina()) {
				for(var j=1;j<comp.length;j++) {
					values=comp[j].split(c158);
					nombre=values[1];
					switch(values[0]) {
						case 'TEXT':	var disableValue=unescape(values[3]);
										if (disableValue=='true') {
											obj=eval(nombre+'MV'); if (obj!=unescape(values[2])) {setMV(nombre,unescape(values[2]));}
											obj=eval(eval(nombre+'IE'));if (new String(obj.disabled)!=unescape(values[3])) {accion(nombre,'.disabled='+unescape(values[3]));}
										}
										else {
											obj=eval(eval(nombre+'IE'));if (new String(obj.disabled)!=unescape(values[3])) {accion(nombre,'.disabled='+unescape(values[3]));}
//											obj=eval(nombre+'MV'); if (obj!=unescape(values[2])) {setMV(nombre,unescape(values[2]));}
											setMV(nombre,unescape(values[2]));
										}
										set(nombre,unescape(values[4]));
										break;
						case 'CHECKBOX':
						case 'VAR': set(nombre,unescape(values[2])); break;
						case 'LABEL':
						case 'LABELC': 	txt_to(nombre,unescape(values[2])); break;
						case 'CAPA': visibilidad(nombre,unescape(values[2])=='visible'?'V':'O'); break;
						case 'COMBO': 	obj=eval(eval(nombre+'IE'));if (new String(obj.disabled)!=unescape(values[2])) {accion(nombre,'.disabled='+unescape(values[2]));}
										set(nombre,[unescape(values[3])]); break;
						case 'BOTON': obj=eval(nombre);obj.setTipo(unescape(values[2])*1);obj.setEstado(unescape(values[3])=='true'); break;
						case 'LISTAboton':	obj=eval(nombre);
											var datos=new Array();
											if (values[2]!='') {
												var cols,filas=values[2].split(c157);
												for(var k=0;k<filas.length;k++) {
													datos[k]=new Array();
													cols=filas[k].split(c156);
													for(k2=0;k2<cols.length;k2++) {
														datos[k][k2]=unescape(cols[k2]);
													}
												}						
											}
											obj.setDatos(datos);
											if (values[3]=='') {obj.offN();}
											else {
												datos=values[3].split(c156);
												for(var k=0;k<datos.length;k++) {obj.on(unescape(datos[k]));}
											}
											obj.display();
											break;
						case 'PAGINADO':	obj=eval(nombre);
											obj.indices=unescape(values[2]);obj.ultima=(unescape(values[3])=='true');obj.pagina=unescape(values[4])*1;
											obj.formulario.paginado_control.value=unescape(values[5]);
											obj.formulario.paginado_conector.value=unescape(values[6]);
											obj.formulario.paginado_idrowset.value=unescape(values[7]);
											break;
					}
				}
			}
		}
	}
}


function consultaValoresPagina(nombrepagina,nombreobjeto,atributo) {
   var d3hb=document.all['d3history_d3_back'];
	if (ns || document.all['d3history_d3_back']==null) {return null;}
   if (d3hb.length)
      d3hb=d3hb[0];
	var obj,h=d3hb.value;
	if (!h) {return null;} if (h.charAt(0)=='*') {h=h.substring(1);}
	var c160=';',c159='=',c158='&',c157='#',c156='$';
	if (h) {
		var nombre,comp,values,pages=h.split(c160);
		for(var i=0;i<pages.length;i++) {
			comp=pages[i].split(c159);
			if (comp[0]==nombrepagina) {
				for(var j=1;j<comp.length;j++) {
					values=comp[j].split(c158);
					nombre=values[1];
					if (nombre==nombreobjeto) {
						switch(values[0]) {
							case 'TEXT':	if (atributo=="disable") return unescape(values[3]);
											if (atributo=="MV") return unescape(values[2]);
											if (atributo=="valor") return unescape(values[4]);
											break;
							case 'CHECKBOX':
							case 'VAR': 
							case 'LABEL':
							case 'LABELC': 	if (atributo=="valor") return unescape(values[2]); break;
							case 'CAPA': if (atributo=="visibilidad") return unescape(values[2]); break;
							case 'COMBO': 	if (atributo=="disable") return unescape(values[2]);
											if (atributo=="valor") return unescape(values[3]);
											break;
							case 'BOTON': if (atributo=="tipo") return unescape(values[2]);
											if (atributo=="estado") return unescape(values[3]);
											break;								
							case 'LISTAboton':	obj=eval(nombre);
												var datos=new Array();
												if (values[2]!='') {
													var cols,filas=values[2].split(c157);
													for(var k=0;k<filas.length;k++) {
														datos[k]=new Array();
														cols=filas[k].split(c156);
														for(k2=0;k2<cols.length;k2++) {
															datos[k][k2]=unescape(cols[k2]);
														}
													}											
												}
												if (atributo=="datos") return datos;
												if (atributo=="seleccion") {
													if (values[3]=='') {return new Array();}
													else {
														datos=values[3].split(c156);
														for(var k=0;k<datos.length;k++) {obj.on(unescape(datos[k]));}
													}
													return datos;
												}
												break;
							case 'PAGINADO':	if (atributo=="indices") return unescape(values[2]);
												if (atributo=="utima") return unescape(values[3]);
												if (atributo=="pagina") return unescape(values[4]);
												if (atributo=="control") return unescape(values[5]);
												if (atributo=="conector") return unescape(values[6]);
												if (atributo=="rowset") return unescape(values[7]);
												break;
						}
					}
				}
			}
		}
	}
	return null;
}

function cambiaValoresPagina(nombrepagina,nombreobjeto,atributo,valor) {
   var d3hb=document.all['d3history_d3_back'];
	if (ns || document.all['d3history_d3_back']==null) {return null;}
   if (d3hb.length)
      d3hb=d3hb[0];
	var obj,h=d3hb.value,ast='';
	if (!h) {return null;} if (h.charAt(0)=='*') {h=h.substring(1);ast='*';}
	var c160=';',c159='=',c158='&',c157='#',c156='$';
	if (h) {
		var nombre,comp,values,pages=h.split(c160);
		var cambio=false;
		for(var i=0;i<pages.length;i++) {
			comp=pages[i].split(c159);
			if (comp[0]==nombrepagina) {
				for(var j=1;j<comp.length;j++) {
					values=comp[j].split(c158);
					nombre=values[1];
					if (nombre==nombreobjeto) {
						switch(values[0]) {
							case 'TEXT':	if (atributo=="disable") {values[3]=escape(valor);cambio=true;}
											if (atributo=="MV") {values[2]=escape(valor);cambio=true;}
											if (atributo=="valor") {values[4]=escape(valor);cambio=true;}
											break;
							case 'CHECKBOX':
							case 'VAR': 
							case 'LABEL':
							case 'LABELC': 	if (atributo=="valor") {values[2]=escape(valor);cambio=true;} break;
							case 'CAPA': if (atributo=="visibilidad") {values[2]=escape(valor);cambio=true;} break;
							case 'COMBO': 	if (atributo=="disable") {values[2]=escape(valor);cambio=true;}
											if (atributo=="valor") {values[3]=escape(valor);cambio=true;}
											break;
							case 'BOTON': if (atributo=="tipo") {values[2]=escape(valor);cambio=true;}
											if (atributo=="estado") {values[3]=escape(valor);cambio=true;}
											break;
							case 'PAGINADO':	if (atributo=="indices") {values[2]=escape(valor);cambio=true;}
												if (atributo=="utima") {values[3]=escape(valor);cambio=true;}
												if (atributo=="pagina") {values[4]=escape(valor);cambio=true;}
												if (atributo=="control") {values[5]=escape(valor);cambio=true;}
												if (atributo=="conector") {values[6]=escape(valor);cambio=true;}
												if (atributo=="rowset") {values[7]=escape(valor);cambio=true;}
												break;
						}
						if (cambio) {
							cambio=values[0]+c158+values[1];
							for(var jj=2;jj<values.length;jj++) {
								cambio+=c158+values[jj];
							}
							h='';for(var jj=0;jj<i;jj++) {h+=pages[jj]+c160;}
							h+=comp[0];for(var jj=1;jj<j;jj++) {h+=c159+comp[jj];}
							h+=c159+cambio;for(var jj=j+1;jj<comp.length;jj++) {h+=c159+comp[jj];}
							for(var jj=i+1;jj<pages.length;jj++) {h+=c160+pages[jj];}
							d3hb.value=ast+h;
						}
					}
				}
			}
		}
	}
}

// RO="S","N". Sólo cajas de texto.
function setREADONLY(campo,RO) {
	eval(campo+"RO='"+RO+"'");
	if (ie) {
		var obj=eval(eval(campo+'IE'));if (obj.disabled) {return;}
		if (RO=="S") {obj.style.backgroundColor=window.colReadOnly;obj.readOnly=true;}
		else {
			obj.style.backgroundColor=window.requeridoN;obj.readOnly=false;
			if (eval(campo+"MV=='C'")) obj.style.backgroundColor=window.requeridoS;
		}
	}
}


function convertirFormatoFecha(fecha,formato,fechaTope)    {  
   //Recibimos en 'fecha' el nombre de un campo ('f1.txtFech' por ejemplo) de formulario de tipo text a convertir
   //En formato recibimos un formato análogo al del método ValidaFecha. Obligatorio usar un separador.
   //(Por ejemplo: usando como formato 'D/M/Y' sustituye '1/1/1' por '01/01/2001')
   //FechaTope:año a partir del cual se considera que es 19XX y por debajo del cual se entiende 20XX. No es obligatorio.

   if (fechaTope==null || fechaTope=='')
      fechaTope=60;
   var R="";
   var i=formato.indexOf('-');
   var j=formato.indexOf('/');
   if (i!=-1 && j!=-1 ) //No permitimos ambos separadores en el formato
      return;
   var sep=(i!=-1)?'-':'/';
   var i=get(fecha).indexOf('-');
   var j=get(fecha).indexOf('/');
   if (i!=-1 && j!=-1 ) //No permitimos ambos separadores en la fecha
      return;
   var arrFech=extraeArray(get(fecha),sep);
   var arrForm=extraeArray(formato,sep);
   if (arrFech.length!=arrForm.length)
      return;
   for (i=0;i<arrFech.length;i++)   {
      if (arrForm[i]=='D' || arrForm[i]=='M' ) {
         if (arrFech[i].length==1)
            arrFech[i]="0"+arrFech[i];
         }
      else if (arrForm[i]=='Y') {
         if (arrFech[i].length==2)
            if (eval(arrFech[i])>fechaTope)  {
               arrFech[i]="19"+arrFech[i];
               }
            else  {
               arrFech[i]="20"+arrFech[i];
               }
         if (arrFech[i].length==1)
            if (eval(arrFech[i])>fechaTope)  {
               arrFech[i]="190"+arrFech[i];
               }
            else  {
               arrFech[i]="200"+arrFech[i];
               }
         }
      R=R+arrFech[i];
      if ((i+1)<arrFech.length)
         R=R+sep
      }
      set(fecha,R);
   }

function extraeArray(cadena,sep)    {
   //Retorna un array dividiendo la cadena según 'sep'
   var s=cadena;
   var R=new Array();
   var i;
   while (s.length>0)   {
      i=s.indexOf(sep);
      if (i!=-1)  {
         R[R.length]=s.substr(0,i);
         s=s.substr(i+sep.length)
         }
      else  {
         R[R.length]=s;
         s="";
         }
      }
   return (R);
   }


function DrdGuardaTraza(msg,esDeTiempos)   { //Abre la ventana de trazas si hace falta y va volcando las trazas JS en ella.
   //Desactivo la función por ahora: TO-DO

   if(!ie)
      return;
   if (!window.top.DR_DEBUG_JS && !esDeTiempos)
      return;

   var dt=new Date();
   meses= new Array ("ENE","FEB","MAR","ABR","MAY","JUN","JUL","AGO","SEP","OCT","NOV","DIC");
   var hor=dt.getHours();
   if (hor < 10)  hor="0"+hor
   var min=dt.getMinutes();
   if (min < 10)  min="0"+min
   var sec=dt.getSeconds();
   if (sec < 10)  sec="0"+sec
   var txtfecha=dt.getDate()+" "+meses[dt.getMonth()]+", "+hor+":"+min+":"+sec;

   var abre=false;
   var vent=window;
   var nv=vent.navigator;
   while (!nv.DRVentTraz && vent.opener && vent.opener!=vent){
      vent=vent.opener;
      var nv=vent.navigator;
      }
   if (!nv.DRVentTraz)  {
      abre=true;
      }
   else if (nv.DRVentTraz.closed)   {
      abre=true
      }

   if (abre)   {
      //nv.DRVentTraz=vent.open('','','width=800,height=150,scrollbars=1,status=0,titlebar=1,resizable=1,toolbar=0,menubar=0,location=0')
      //nv.DRVentTraz.name='DRVentTraz';
      //nv.DRVentTraz.close();

      nv.DRVentTraz=vent.open('','','width=800,height=150,scrollbars=1,status=0,titlebar=1,resizable=1,toolbar=0,menubar=0,location=0')
      nv.DRVentTraz.name='DRVentTraz'

      var html_inicio="<body style=\"font-family: Verdana, Arial;font-size: 9px;color: #FFFFFF;\" bgcolor=\"#666666\" leftmargin=\"5\" topmargin=\"5\" marginwidth=\"5\" marginheight=\"5\" >";
      html_inicio+="<input type=\"button\" name=\"Button\" value=\"Copiar al Portapapeles\" onclick=\"tr=document.body.createTextRange();tr.execCommand('Copy');alert('¡Copiado!');\">";
      html_inicio+="<br><br>[ "+txtfecha+" "+(window.name?window.name:"")+" ]: VENTANA DE TRAZAS JAVASCRIPT ACTIVADA<br>";

      nv.DRVentTraz.document.write(html_inicio);
      nv.DRVentTraz.focus();

      //nv.DRVentTraz.alert("Ventana de trazas JS Druida Activada.");

      vent.focus();
      }

   nv.DRVentTraz.document.write("<br>[ "+txtfecha+" "+(window.name?window.name:"")+" ] : "+DrdEscHTML(msg));
   }



function DrdEscHTML (cad) { //Escapa con vistas a construir una cadena HTML entre caracteres comilla doble (")
   if (cad!=null){
       cad=cad+"";
      //return cad.replace(/</gi,"&lt;").replace(/>/gi,"&gt;").replace(/"/gi,"&quot;").replace(/\n/gi,"<br>"); 
      return cad.replace(/</gi,"&lt;").replace(/>/gi,"&gt;").replace(/"/gi,"&quot;");
    }
   return "";
}

function DrdEscXML (cad) { //Escapa con vistas a construir una cadena HTML entre caracteres comilla doble (")
   if (cad!=null){
      cad=cad+"";
      return cad.replace(/</gi,"&lt;").replace(/>/gi,"&gt;").replace(/"/gi,"&quot;"); 
   }
   return "";
}


function DrdValoresForm (form) { //Retorna una cadena con los valores del formulario
   var ret="&nbsp;&nbsp;&nbsp;&nbsp;CAMPOS DE &lt;FORMULARIO nombre=\""+form+"\"/&gt; :";
   var f=eval('document.'+form);
   for (var i=0;i<f.elements.length;i++) {
      var c=f.elements[i];
      ret+=((i==0?"":"&nbsp;&nbsp;,")+"\n&nbsp;&nbsp;&nbsp;&nbsp;[ "+c.name+": "+c.value+" ]");
      }
   return ret;
}

function DrdHBListaPaginas()   {
   //History back: retorna un array con las paginas
   if (!ie) 
      return;
   var r=new Array();
   var f=document.forms;
   for (var i=0;i<f.length;i++)  {
      var frm=f.item(i);
      var e=frm.all;
      for(var j=0;j<e.length;j++)   {
         var inp=e.item(j);
         if (inp.name && inp.name.length > 10 && inp.name.substr(0,10)=='d3history_' && inp.name.substr(10)!='d3_back' && inp.value!='')  {
            r[r.length]=inp.name.substr(10);
            }
         }
      }
   return r;
   }


function DrdHBLimpia(paginas)   {
   //History back: elimina la informacion de esas paginas
   //paginas es un array de nombres
   //Si se omite, se borran todos
   if (!ie) 
      return;
   var alimpiar=null;
   if (paginas!=null && paginas.length && paginas.length>0) 
      alimpiar=[paginas];
   else  
      alimpiar=DrdHBListaPaginas()
   for (var i=0;i<alimpiar.length;i++) {
      if (document.all['d3history_'+alimpiar[i]] )   {
         document.all['d3history_'+alimpiar[i]].value="";
         }
      else
         return false;
      }
   return true;
   }

function DrdHBDejaSolo(paginas)   {
   //History back: elimina la informacion de todas las paginas menos esas
   //paginas es un array de nombres
   if (!ie) 
      return;
   var noborrar="";
   for (var i=0;i<paginas.length;i++) 
      noborrar+="<"+paginas[i]+">";
   var alimpiar=DrdHBListaPaginas()
   for (i=0;i<alimpiar.length;i++) {
      if (noborrar.indexOf("<"+alimpiar[i]+">")==-1 )   
         document.all['d3history_'+alimpiar[i]].value="";
      }
   }

function tip_compon(objn)  {    //Obtenemos el tipo de componente
   var TC="";
   if (eval("window."+objn))  {
      if (eval("window."+objn+".TC")) {
         TC=eval("window."+objn+".TC");
         }
      }
   return TC;
   }

// --------------------  funciones que controlan el onresize en el caso de que sea necesario ejecutando eval(ON_RSZ) , solo IE

ON_RSZ=""; //ACUMULADOR EVENTOS ONRESIZE
OWR_DEM=false;
OWR_RETARDO = 5 //ESTE ES EL RETARDO MAXIMO PARA ACTUALIZARSE

function onWindowResize () {
   contOnWResize=OWR_RETARDO;
   if (!OWR_DEM)   {
      OWR_DEM=true;
      demonioOnWResize();
      }
   }

function demonioOnWResize () {
   if (window.contOnWResize>0)   {
      window.contOnWResize--;
      setTimeout("demonioOnWResize()",50);
      }
   else  {
      OWR_DEM=false;
      eval(ON_RSZ);
      }
   }

// --------------------  funciones para preparar el centrado automático (internas), solo IE. Primero las que inicializan, luego las que se llaman cada vez.

function aux_cambioAnchoMargen(laCapa,elMargDchaAncho) { //Horiz
   var cc=document.all[laCapa];
   cc.margDchaAncho=elMargDchaAncho;
   cc.minim=cc.offsetWidth ;
   //ON_RSZ+="act_CAMRG('"+laCapa+"');";
   aux_agregaString("act_CAMRG('"+laCapa+"');");
   window.onresize=onWindowResize;
   }

function aux_mueveMargen(laCapa,elMargDchaAncho) { //Horiz
   var cc=document.all[laCapa];
   cc.margDcha=elMargDchaAncho;
   cc.minim=cc.offsetLeft;
   aux_agregaString("act_MMRG('"+laCapa+"');");
   window.onresize=onWindowResize;
   }

function aux_centra(laCapa) { //Horiz
   var cc=document.all[laCapa];
   cc.centrado=true;
   cc.minim=cc.offsetLeft;
   aux_agregaString("act_CNTR('"+laCapa+"');");
   window.onresize=onWindowResize;
   }

function aux_cambioAltoMargen(laCapa,elMargInfAlto) { //Vertical
   var cc=document.all[laCapa];
   cc.margInfAlto=elMargInfAlto;
   cc.minimAlto=cc.offsetHeight;
   aux_agregaString("act_CAMRG2('"+laCapa+"');");
   window.onresize=onWindowResize;
   }

function aux_mueveMargenV(laCapa,elMargInf) { //Vertical
   var cc=document.all[laCapa];
   cc.margInf=elMargInf;
   cc.minimY=cc.offsetTop;
   aux_agregaString("act_MMRG2('"+laCapa+"');");
   window.onresize=onWindowResize;
   }


// ----------

function act_CAMRG(laCapa) { // Horiz, cambio ancho margen
   var cc=document.all[laCapa];
   var anchoPant=document.body.offsetWidth -16;
   var anchoCapa=anchoPant - cc.offsetLeft - cc.margDchaAncho;
   if (anchoCapa < cc.minim) 
      anchoCapa=cc.minim;
   cc.style.width=anchoCapa;
   cc.style.clip="rect(0,"+anchoCapa+","+cc.offsetHeight+",0)";
   }

function act_MMRG(laCapa) { // Horiz, mueve margen
   var cc=document.all[laCapa];
   var anchoPant=document.body.offsetWidth -16;
   var xCapa= anchoPant - cc.margDcha - cc.offsetWidth;
   if (xCapa < cc.minim)
      xCapa=cc.minim;
   cc.style.left=xCapa;
   }

function act_CNTR(laCapa) { // Horiz
   var cc=document.all[laCapa];
   var anchoPant=document.body.offsetWidth -16;
   var xCapa= Math.abs( ( anchoPant - cc.offsetWidth) /2 );
   if (xCapa < cc.minim)
      xCapa=cc.minim;
   cc.style.left=xCapa;
   }

function act_CAMRG2(laCapa) {  // Vertical, cambio alto margen
   var cc=document.all[laCapa];
   var altoPant=document.body.offsetHeight; 
   var altoCapa=altoPant - cc.offsetTop - cc.margInfAlto;
   if (altoCapa < cc.minimAlto) 
      altoCapa=cc.minimAlto;
   cc.style.height=altoCapa;
   cc.style.clip="rect(0,"+cc.offsetWidth+","+altoCapa+",0)";
   }

function act_MMRG2(laCapa) { // Vertical, mueve margen
   var cc=document.all[laCapa];
   var altoPant=document.body.offsetHeight;
   var yCapa= altoPant - cc.margInf - cc.offsetHeight;
   if (yCapa < cc.minimY)
      yCapa=cc.minimY;
   cc.style.top=yCapa;
   }

// --------------------  funciones para preparar el centrado automático , solo IE


function DrdCentra(objn) { //Centra el elemento
   var TC=tip_compon(objn);
   if (TC=="Boton")   
      aux_centra(objn+'Div');
   else //capa
      aux_centra(objn);
   }

function DrdAlineaConMargenDcho(objn,margen) { //Alinea hasta un cierto margen derecho
   var TC=tip_compon(objn);
   if (TC=="Boton")
      aux_mueveMargen(objn+'Div',margen);
   else //capa
      aux_mueveMargen(objn,margen);
   }

function DrdEnsanchaConMargenDcho(objn,margen)  { //Ensancha hasta un cierto margen derecho
   var TC=tip_compon(objn);
   //Segun el tipo de componente preparamos ...
   if (TC=="Listado")   {
      var xlista=document.all["Cp"+objn].offsetLeft;
      if (margen==null)
         margen=xlista;
      var elborde = eval(objn).GrBorde;
      aux_cambioAnchoMargen('Cp'+objn,margen);
      aux_cambioAnchoMargen('CpFCab'+objn,margen + xlista + elborde );
      aux_cambioAnchoMargen('CpCab'+objn,margen + xlista + elborde );
      aux_cambioAnchoMargen('CpLCab'+objn,margen + xlista + elborde );
      aux_cambioAnchoMargen('CpScroll'+objn,margen + xlista + elborde );
      aux_cambioAnchoMargen('CpLin1'+objn,margen );
      aux_mueveMargen('CpLin4'+objn,margen );
      aux_cambioAnchoMargen('CpLin3'+objn,margen );
	  aux_agregaString(objn + ".ancho=document.all['Cp" + objn + "'].offsetWidth;");
	  aux_agregaString(objn + ".anchos = DrGeneraCopiaDeArray("+objn + ".anchosOld);");
	  aux_agregaString(objn + ".ajustaAnchosMinimos();");
	  aux_agregaString("if ("+objn+".form)   {"+objn + ".actualizaDat();}");
	  aux_agregaString("if ("+objn+".datos.length > 0){"+objn + ".repinta();}");
      }
   else if (TC=="Arbol")   {
      if (margen==null)
         margen=document.all[objn].offsetLeft;
      aux_cambioAnchoMargen(objn+"Scroll",margen);
      }
   else { //'Capa'
      if (margen==null)
         margen=document.all[objn].offsetLeft;
      aux_cambioAnchoMargen(objn,margen);
      }
   }


function aux_agregaString(strAgregado){
  if(!ON_RSZ.substr(strAgregado)>-1){
	ON_RSZ+=strAgregado;
  }
}

function DrdEnsanchaConMargenInf(objn,margen)  { //Ensancha hasta un cierto margen inferior
   //Solo lista por ahora
   var TC=tip_compon(objn);
   //Segun el tipo de componente preparamos ...
   if (TC=="Listado")   {
      var ylista=document.all["Cp"+objn].offsetTop;
      if (margen==null)
         margen=ylista;
      var elborde = eval(objn).GrBorde;
      aux_cambioAltoMargen('Cp'+objn,margen);
      aux_cambioAltoMargen('CpScroll'+objn,margen + ylista + elborde );
      aux_cambioAltoMargen('CpLin2'+objn,margen );
      aux_cambioAltoMargen('CpLin4'+objn,margen );
      aux_mueveMargenV('CpLin3'+objn,margen );
      aux_agregaString(objn + ".alto=document.all['Cp" + objn + "'].offsetHeight;");
      }
   else  {//Capa
      if (margen==null)
         margen=document.all[objn].offsetTop;
      aux_cambioAltoMargen(objn,margen);
      }
   }

function DrdAlineaConMargenInf(objn,margen) { //Alinea hasta un cierto margen inferior
   var TC=tip_compon(objn);
   if (TC=="Boton")
      aux_mueveMargenV(objn+'Div',margen);
   else //capa
      aux_mueveMargenV(objn,margen);
   }

// Limita el numero de caracteres a introducir en un Area de texto
function LimitaAreatexto(campo, valorActual, maxlen) {
	var nn = eval('document.' + campo);
   set(campo, valorActual);
   if (valorActual.length > maxlen) {
      set(campo, nn.value.substring(0, maxlen));
   } 
	return ;
}

DrdTooltipNat=(window.tipoTooltip && window.tipoTooltip == 'NATIVO' && ie)?true:false;

function DrdTooltipNativo()   {
   return DrdTooltipNat;
   }

function DrdCierraCargandoDeOpener()   {
   if (opener && opener.d3ocupado_ocultar){
      opener.d3ocupado_ocultar('d3general');	
      if (opener.opener && opener.opener.d3ocupado_ocultar){
         opener.opener.d3ocupado_ocultar('d3general');
         }
      }
   }

function DrdNuevaVentanaMinim(nombre)   {
   //BUG DE IE6 si desde una modal se hace una window.open no sabe de que ventana abrir y con varios navegadores abiertos se puede perder la sesion
   //Para solucionarlo pueden mandar este argumento (window.dialogArguments.opener)
/*    var windowReal=null;
   if (window.dialogArguments && window.dialogArguments.opener)   {
      windowReal=window.dialogArguments.opener;
      }
   else
      windowReal=window; */
   var windowReal= recorrerJerarquia(window);
   var laventana=windowReal.open('','','toolbar=0,directories=0,location=0,personalbar=0,resizable=0,titlebar=no,scrollbars=0,status=1,top=4000,left=4000');
   laventana.name=nombre;
   if (window.dialogArguments && window.dialogArguments.opener)   
      laventana.opener=window;
   return laventana
   }

function DrdNuevaVentana(nombre)   {
   //BUG DE IE6 si desde una modal se hace una window.open no sabe de que ventana abrir y con varios navegadores abiertos se puede perder la sesion
   //Para solucionarlo pueden mandar este argumento (window.dialogArguments.opener)
/*    var windowReal=null;
   if (window.dialogArguments && window.dialogArguments.opener)   
      windowReal=window.dialogArguments.opener;
   else
      windowReal=window; */
   var windowReal= recorrerJerarquia(window);
   var laventana=windowReal.open('','','toolbar=0,directories=0,location=0,personalbar=0,resizable=0,titlebar=no,scrollbars=0,status=1,top=0,left=0');
   laventana.name=nombre;
   if (window.dialogArguments && window.dialogArguments.opener)   
      laventana.opener=window;
   return laventana
   }

function recorrerJerarquia(windowSrc){
   if(windowSrc.dialogArguments && windowSrc.dialogArguments.opener){
      return recorrerJerarquia(windowSrc.dialogArguments.opener)
      }
   else{
      return windowSrc;
      }
   }

function DrdTrazasTiempoFinOnload ()   {
/*    window.drdate_2=new Date();
  
   if (window.drd_tiempo_inicio && window.drd_tiempo_inicio!="" && window.drd_tiempo_inicio!=" " && window.drdate_1)   {
     
         var tserv=(window.drdate_1-(new Date(window.drd_tiempo_inicio)))
         var tonload=window.drdate_2 - window.drdate_1; 
        
         window.DRD_TIEMPO_TOTAL=(tserv+tonload)
        } */
   
   }

function DrdTrazasTiempoInicioOnload() {
   //window.drdate_1=new Date();
   }

function DrdTrim(cad)   {
   var i1=0,i2=cad.length-1;
   while (i1<cad.length && ( cad.charAt(i1)==' ' || cad.charAt(i1)=='\n' || cad.charAt(i1)=='\t'))
      i1++
   while (i2>0 && ( cad.charAt(i2)==' ' || cad.charAt(i2)=='\n' || cad.charAt(i2)=='\t')) 
      i2--
   return (cad.substring(i1,i2+1))
   }


function DrdCargaRedONavega(formulario,conValidacion,red,entrada,evento,elTarget) { //Sin target --> en el actual
   var nn=eval('document.'+formulario);
   var nformulario=eval(formulario);
   //Necesario por si navegamos a otro frame, hay que guardar esto
   if (!window.DRD_RED_ACTUAL && nn.drd_net ){
      window.DRD_RED_ACTUAL=nn.drd_net.value;
      window.DRD_ESTADO_ACTUAL=nn.drd_estado.value;
      }
   //verifico evento
   var ind=DrdIndiceElementoEnMatrizUnidimensional(evento,window.evSalida)
   if (nn.drd_evento && evento && (!window.evSalida || ind==-1)){
      alert("Error: Se intenta utilizar el método DrdNavega() con un evento no reconocido para el estado y red actual. estado="+nn.drd_estado.value+" red="+nn.drd_net.value+" evento="+evento)
      return false;
      }
   //Trato los campos
   for (var i=0;i<nn.elements.length;i++) {//Trato los campos
      var elemento=nn.elements[i];
      var campo=elemento.name;
      var tipocmp=eval(formulario+'.'+campo+'TC');
      //Hacemos el TRIM si es el caso
      if (!eval(formulario+'.'+campo+'NOTRIM') && ( (window.TRIM_TEXT && tipocmp=="Texto") || (window.TRIM_AREATEXTO && tipocmp=='Textarea'))) {
         elemento.value=DrdTrim(elemento.value);
         }
      if (eval(formulario+'.'+campo+'TC=="Listado"')) {
         var elinput=eval(formulario+'.'+campo);
         eval("document."+formulario+"."+campo+".value=get(formulario+'.'+campo)");;
         }
      }
   //validamos

	if (conValidacion==null || conValidacion=='S' || conValidacion==true) {
      if (!ValidaForm (formulario,true))
         return false;
      }
   //Preparo el target
	if (elTarget) 
      nn.target=elTarget;
   else if (nformulario.oculto!='N') { // abre ventana oculta
      if (!window.DruidaOcultoInd)
         window.DruidaOcultoInd=1;
      var nombre="DruidaOculto"+(window.DruidaOcultoInd++)
      conectorActionV = DrdNuevaVentanaMinim(nombre);
 		conectorActionV.blur();
		nn.target=nombre;
		}
   else if (window.HTML_CACHEADO)
      nn.target='_parent'; //Si la página va cacheada atacamos al frameset parent
   else  
      nn.target=self.name;
   //Si es caso de navegar hacia LO lo hacemos en oculto
   if (ind != -1 && window.evSalidaTipo[ind]=="LO")   {

      if (tipoNavLo=="VENTANA") {
         if (window.vNavLO && !window.vNavLO.closed){ //Si ya estaba navegando ...
            muestraMsgError("ERROR: EJECUCION EN CURSO");
            return;
            }
         window.targetANav=nn.target //Lo guardo para luego
         window.formANav=nn //Lo guardo para luego
         var unId=DrDameUnId("LO");
         window.vNavLO=window.open("about:blank","","top=4000,width=800,height=100");
         window.vNavLO.name=unId;
         nn.target=unId
         }
      else  {//IFRAME
         if (window.vNavLO){ //Si ya estaba navegando ...
            muestraMsgError("ERROR: EJECUCION EN CURSO");
            return;
            }
         window.vNavLO=true;
         window.targetANav=nn.target //Lo guardo para luego
         window.formANav=nn //Lo guardo para luego
         DrdGeneraFrameSiNoExiste("FRAMENAVEGLO");
         nn.target="FRAMENAVEGLO"
         }
      }

   //Capa de ocupado
   if (!window.ocupado_envia && window.oculta_frmOculto && nformulario.oculto!='N')
      d3ocupado_ver('d3general',d3ocupado_general);
	else if (nformulario.oculto=='N' && window.ocupado_envia) 
      d3ocupado_ver('d3general',d3ocupado_general);
   //Save valores 
	saveValoresPagina();
   //Según el caso modifico el formulario para la red
   if (nn.drd_estado && nn.drd_net && entrada && red)   {
      nn.drd_estado.value=entrada;
      nn.drd_net.value=red;
      if (nn.drd_evento)
         nn.drd_evento.value="";
      }
   else if (nn.drd_evento && evento)  {
      nn.drd_estado.value=window.DRD_ESTADO_ACTUAL;
      nn.drd_net.value=window.DRD_RED_ACTUAL;
      nn.drd_evento.value=evento;
      }
   nn.drd_loparam.value=""; //Solo se usa de LO a LP, en DrdCargaRedONavega_2
	nn.submit();
	return true;
   }




function DrdNavega(formulario,conValidacion,evento,elTarget) {
   DrdCargaRedONavega(formulario,conValidacion,null,null,evento,elTarget);
   }


function DrdCargaRed(formulario,conValidacion,red,entrada,elTarget) {  
   DrdCargaRedONavega(formulario,conValidacion,red,entrada,null,elTarget);
   }

function DrdCargaRedONavega_2(evento,estado,red,loParametros)   {//Venimos de navegar en minimizada con una LO
   //Recupero
   window.vNavLO=false;
   var frm=window.formANav;
   frm.target=window.targetANav;
   frm.drd_evento.value=evento
   frm.drd_estado.value=estado
   frm.drd_net.value=red
   frm.drd_loparam.value=loParametros
   frm.submit();
   }

function DrdExiteElementoEnMatrizUnidimensional(elemento,matriz)  {
   for (var f=0;f<matriz.length;f++)   
      if (matriz[f]==elemento)
         return true;
   return false;
   }


// FUNCIONES DE COMUNICACION POR IFRAMES

function creaIFAuto()   {
   stComCh=new Array(15);
   for(var rr=0;rr<15;rr++) {
      document.write('<div id="comServ'+rr+'" ></div>');
      stComCh[rr]=false;
      }
   }  

function getFreeComCh(){
   for(var rr=0;rr<15;rr++) {
      if(!stComCh[rr])  {
         stComCh[rr]=true;
         document.all["comServ"+rr].outerHTML='<iframe id="comServ'+rr+'" name="comServ'+rr+'" src="" style="width:0px;height:0px"></iframe>'
         return("comServ"+rr);
         }
      }
   }

function setFreeComCh(ind){
   stComCh[ind]=false;
   document.all["comServ"+ind].outerHTML='<div id="comServ'+ind+'" ></div>'
   }

if (window.tipoAsignarJs && window.tipoAsignarJs=='IFRAME')
   creaIFAuto()


function DrdIndiceElementoEnMatrizUnidimensional(elemento,matriz)  {
   if (!matriz || !matriz.length)
      return -1
   for (var f=0;f<matriz.length;f++)   
      if (matriz[f]==elemento)
         return f;
   return -1;
   }

function DrDameUnId(cab)  {
   return cab+Math.round(Math.random()*99999999);
   }

function DrControlaError(msg, url, linenumber){
   alert("OCURRIÓ UN ERROR EN EL OBJETO 'VENTANA MINIMIZADA DE NAVEGACIÓN' EN LA LINEA "+linenumber+" :\n"+msg);
   window.vNavLO.moveTo(10,10);
   window.vNavLO.focus();
   return true;
   }


function DrFocalizaBotonera(nombreBtnra,posicion){
   var obj=null;
   var hrf=document.all[nombreBtnra+"_AHREF"]
   if (!hrf)
      return;
   if (!hrf.length)
      obj=hrf
   else   {
      if (posicion>=0 && posicion<hrf.length)
         obj=hrf[posicion]
      else if (posicion>=0)//Si el número era mayor ...
         obj=hrf[hrf.length -1]
      }
   obj.focus();
   }


//Función de cacheo, por japleon
function rutaFrmCache(){
	ruta=self;
	if(window.opener)
		if(window.opener.top.frames["datosAlm"])
			ruta=window.opener;
	return ruta;
   }

function DrdGeneraFrameSiNoExiste(nombre) {
   if (!document.all[nombre])   {
      document.body.insertAdjacentHTML('BeforeEnd','<iframe id="'+nombre+'" name="'+nombre+'" src="" style="width:0px;height:0px;"></iframe>');
      }
   }


//Precarga de imagenes:

function DrdPrecImgs()  { //usando urls completas 
   var i=0,arg=DrdPrecImgs.arguments;
   for(i=0; i<arg.length ; i++)  
      DrdPrecImg(arg[i])
   }

function DrdPrecImgsMRut()  { //Metiendo ruta delante
   var i=0,arg=DrdPrecImgsMRut.arguments;
   for(i=0; i<arg.length ; i++)  
      if (arg[i]!='')
         DrdPrecImg(arg[i],true);
   }

function DrdPrecImg(url,meteImgPath)  {
   var laimg=new Image();
   if (url=='')
      return laimg;
   if (meteImgPath)
      laimg.src=DrdImgPath()+url;
   else
      laimg.src=url;
   return laimg;
   }

//Precarga del transparente.gif
DrdPrecImg(imgTransp);

//tipoNavLo="VENTANA"
tipoNavLo="IFRAME" //No merece la pena configurarlo por el globales

//Funciones útiles para la optimización de tiempos: 

var traz=[];

function t(msg)   {
   traz[traz.length]=[new Date(),msg];
   }

function ver_t()   {
   var txt="";
   for (var i=0;i<traz.length;i++)  {
      if (i>0)
         txt += "["+ (traz[i][0] - traz[i-1][0]) +" mseg.] " + traz[i][1] + "\n";
      else
         txt += "[inicio] " + traz[i][1] + "\n";
      }
   if (traz.length>1)
      txt+="[TOTAL : "+ (traz[traz.length-1][0] - traz[0][0]) +" mseg.]"
   alert(txt);
   traz=[];
   }



// OBJETOS A INSTANCIAR: 

function drdDRUIDA(NS,ID,TC)   {
   this.NS=NS
   this.ID=ID
   this.TC=TC
   }

function drdFormulario (action,oculto)  {
   this.action=action
   this.oculto=oculto
   this.conectorActionOcultoTC="Hidden" // Si no hay action, se necesita la variable conectorActionOculto.  Ver FORMULARIOFILNAL en drd30_comunes.xsl 

   this.regElemFrm=function (nombre,NS,IE,TC,MR,TV,RO,MV,NOTRIM,SZ,valorinicial,textoinicial)   {
      this[nombre+"NS"]=NS
      this[nombre+"IE"]=IE
      this[nombre+"TC"]=TC
      this[nombre+"MR"]=MR
      this[nombre+"TV"]=TV
      this[nombre+"RO"]=RO
      this[nombre+"MV"]=MV
      this[nombre+"NOTRIM"]=NOTRIM
      this[nombre+"SZ"]=SZ
      this[nombre+"valorinicial"]=valorinicial
      this[nombre+"textoinicial"]=textoinicial
      }

   this.rgElemFrm=function (nombre,IE,TC,MR,TV,RO,MV,NOTRIM,SZ,valorinicial,textoinicial)   {
      this[nombre+"IE"]=IE
      this[nombre+"TC"]=TC
      this[nombre+"MR"]=MR
      this[nombre+"TV"]=TV
      this[nombre+"RO"]=RO
      this[nombre+"MV"]=MV
      this[nombre+"NOTRIM"]=NOTRIM
      this[nombre+"SZ"]=SZ
      this[nombre+"valorinicial"]=valorinicial
      this[nombre+"textoinicial"]=textoinicial
      }
   }

function drdAlertModal(ON,drServlet,sFeatures,sFuncJS)   {
   this.ON=ON;
   this.drServlet=drServlet;
   this.sFeatures=sFeatures;
   this.sFuncJS=sFuncJS;
   }

//function drdLabel(NS,ID,tooltip,link) {
function drdLabel(ID,tooltip,link) {
   //this.NS=NS;
   this.ID=ID;
   this.TC='Label';
   this.tooltip=tooltip;
   this.link=link;
   }

//function drdLabelC(NS,ID,W,H,tooltip,link) {
function drdLabelC(ID,W,H,tooltip,link) {
   //this.NS=NS;
   this.ID=ID;
   this.TC='LabelR';
   this.W=W;
   this.H=H;
   this.tooltip=tooltip;
   this.link=link;
   }

//function drdCapa(nsdoc,vsb,contravsb) {
function drdCapa(vsb,contravsb) {
   //this.nsdoc=nsdoc;
   this.vsb=vsb;
   this.contravsb=contravsb;
   this.TC='Capa'
   }

function drdScroll(nombre,vsb) {
   this.nombre=nombre;
   this.vsb=vsb;
   this.TC='Scroll'
   window[this.nombre+"Div"]=new Object();
   window[this.nombre+"Div"].TC='DUMMY';
   window[this.nombre+"Divtv"]=new Object();
   window[this.nombre+"Divtv"].TC='DUMMY';
   }

/* function drdSolapas(nombre,nsdoc,i,pestanias,accion)   { */
function drdSolapas(nombre,i,pestanias,accion)   { 
   this.nombre=nombre;
   //this.nsdoc=nsdoc;
   this.i=i;
   this.pestanias=pestanias;
   this.accion=accion;
   this.vsb='visible';
   this.TC='Solapas';
   this.arrayPest=[];
   this.indiceSeleccionada=-1;
   this.cambiaImagen=function(indiceSolapa, indiceImagen) {
      this.arrayPest[indiceSolapa].cambiaImagen(indiceImagen);
      }
   }

/* function drdSolapa(offsrc,chksrc,nsdoc,objSolapas,offsrc2,chksrc2) { */
   function drdSolapa(offsrc,chksrc,objSolapas,offsrc2,chksrc2) {
   this.off=new Image();
   this.off.src=DrdImgPath()+offsrc;
   this.chk=new Image();
   this.chk.src=DrdImgPath()+chksrc;
   //this.nsdoc=nsdoc;
   if (offsrc2 && chksrc2)   {
      this.off1=this.off;
      this.chk1=this.chk;
      this.off2=new Image();
      this.off2.src=DrdImgPath()+offsrc2
      this.chk2=new Image();
      this.chk2.src=DrdImgPath()+chksrc2;
      }
   if (objSolapas)   {
      this.padre=objSolapas;
      this.indice=objSolapas.arrayPest.length;
      objSolapas.arrayPest[this.indice]=this;
      }
   this.cambiaImagen=function (indimg) {
      //Indice puede ser 0 o 1 o -1 para alternar
      //solapa=nombre de la capa
      var solapa=this.padre.nombre
      if (this.padre.indiceSeleccionada==this.indice)
         var finalImg='.chk'
      else
         var finalImg='.off'
      if (indimg==0) {
         this.off=this.off1
         this.chk=this.chk1
         }
      else  {
         finalImg+='2'
         this.off=this.off2
         this.chk=this.chk2
         }
      var imagen=solapa+this.indice+finalImg;
		img_to(solapa+this.indice+'',imagen);
      }
   }
/* 
function drdBotonera(nsdoc){ */
function drdBotonera(){ 
   //this.nsdoc=nsdoc;
   this.vsb='visible';
   this.estado=[];
   this.registraBtn=function (indice,estado)  {
      this.estado[indice]=estado;
      }
   }

/* function drdBtn(padre,indice,estado,offsrc,dissrc,onsrc,nsdoc) { */
function drdBtn(padre,indice,estado,offsrc,dissrc,onsrc) {
   this.padre=padre;
   this.offsrc=offsrc;
   this.dissrc=dissrc;
   this.onsrc=onsrc;
   //this.nsdoc=nsdoc;
   if (dissrc!=null) {
      this.dis=new Image();
      if(dissrc!='')
         this.dis.src=DrdImgPath()+dissrc;
      }
   if (offsrc!=null) {
      this.off=new Image();
      if (offsrc!='')
         this.off.src=DrdImgPath()+offsrc;
      }
   if (onsrc!=null) {
      this.on=new Image();
      if (onsrc!='')
         this.on.src=DrdImgPath()+onsrc;
      }
   padre.registraBtn(indice,estado);
   }

function drdEvaluaProblemas(sacarInforme) {
   //Se llama cuando DR_DEBUG_JS=true

   //Es una función de depuración en desarrollo para verproblemas

   var elAlert="";
   if (window.drd_listas!=null)  {
      elAlert="";
      for (var i=0;i<drd_listas.length;i++)  {
         if (drd_listas[i].numPintadosDat>1) {
            elAlert+="¡Atencion!: La Lista '"+drd_listas[i].nombre+"' puede presentar problemas de rendimiento ya que se pinta "+drd_listas[i].numPintadosDat+" veces al generar la página.\n";
            }
         }
      if (elAlert!="") {
         elAlert+="\nEsto es un error ya que una lista no se debería pintar mas que una vez al final del onload. Puede que uno de esos repintados sea el que se hace por defecto, en cuyo caso se puede evitar usando el atributo <DATOS ... primerRefresco=\"N\" >. Quizá se estén usando métodos para manipular la lista y no se haya usado el parámetro adecuado para no repintarla en cada ocasión. Mire en la documentación de la lista para buscar mas información de como evitarlo."
         alert(elAlert)
         }
      }

   var complej=document.all.length;
   elAlert="Numero de elementos HTML de la página: "+complej+".\n\n"
   if (complej>500 && complej<1000)
      alert(elAlert+"Parece un valor alto. Tenga cuidado con valores altos ya que se pueden ocasionar problemas de rendimiento. La lentitud del javascript crece exponencialmente con la complejidad de la página.");
   else if (complej>=1000 && complej<2000)
      alert(elAlert+"Este valor es alto y se pueden ocasionar problemas de rendimiento. La lentitud del javascript crece exponencialmente con la complejidad de la página.")
   else if (complej>=2000)
      alert(elAlert+"¡Atencion!: Este valor es muy alto y se pueden ocasionar problemas de rendimiento. La lentitud del javascript crece exponencialmente con la complejidad de la página. Quizá se debería considerar la posibilidad de partir esta pantalla en varias mas pequeñas o por ejemplo utilizar solapas con IFRAMES para ir cargando progresivamente varias partes de la pantalla.")

   if (window.tiempos!=null)  {
      var TCarga=window.tiempos[1] -window.tiempos[0]
      var TOnload=window.tiempos[2] -window.tiempos[1]
      var TTotal=TCarga+TOnload
      elAlert="El tiempo total desde que se recibe el principio de la página hasta que acaba el onload ha sido de "+(TTotal/1000)+" Seg. ("+(TCarga/1000)+" Seg. de carga + "+(TOnload/1000)+" Seg. en el onload)\n\n";
      if (TTotal>4000 && TTotal<9000)  {
         elAlert+="Aunque puede deberse a muchas causas, parece un valor alto. Quizá la página es demasiado pesada y debería ser partida en varias páginas menos complejas. Por ejemplo se podrían utilizar solapas con IFRAMES para ir cargando progresivamente las distintas partes de la página. Compruebe también que en el onload no se está acumulando mas javascript del que es estrictamente necesario. Tenga especial cuidado con los métodos de objetos que generan código dinámicamente (como la lista).\n"
         }
      else if (TTotal>9000)  {
         elAlert+="¡Atención! Aunque puede deberse a muchas causas, parece un valor muy alto. Quizá la página es demasiado pesada y debería ser partida en varias páginas menos complejas. Por ejemplo se podrían utilizar solapas con IFRAMES para ir cargando progresivamente las distintas partes de la página. Compruebe también que en el onload no se está acumulando mas javascript del que es estrictamente necesario. Tenga especial cuidado con los métodos de objetos que generan código dinámicamente (como la lista).\n"
         }
      alert(elAlert)
      }

   }

function drdEvTmp()   {
   if (window.tiempos==null)
      window.tiempos=[]
   window.tiempos[window.tiempos.length]=new Date();
   }


function AJAXInteraction(url, callback) {

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
      //alert(xmlHttp.ResponseBody )
         var txt=req.responseText
         if (txt.charAt(0)!='[') {
            d3canal(txt,[])
            }
         else  {
            //alert(txt)
            d3canal("",eval(txt)) 
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

