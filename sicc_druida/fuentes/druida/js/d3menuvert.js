
/*
    $Id: d3menuvert.js,v 1.1 2009/12/03 19:03:48 pecbazalar Exp $
    INDRA/CAR/d3desa
*/


function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i, j=0, x, a=MM_swapImage.arguments;
  document.MM_sr = new Array; 
  for(i = 0; i < (a.length-2); i += 3)
    if ((x=MM_findObj(a[i])) != null)
        {document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function CambiaSimbolo(idObject,iEstado,bMouseOver,oMenu) { 
  var x = MM_findObj(idObject);
//  var sSim, vImagen;
  var aImg = new Array();
//MenuCArbol.imgmenos=["img/btnMenos1N.gif","img/btnMenos1S.gif"];
//MenuCArbol.imgmas=["img/btnMas1N.gif","img/btnMas1S.gif"];

  if (x!=null){
        if (iEstado==0)           //si está plegado
         aImg = oMenu.imgmas;
        else  
         aImg = oMenu.imgmenos;
        if (bMouseOver==1){ //si se está cambiando el nivel en el que está el ratón encima        
            x.src = aImg[1];
            x.oSrc =  aImg[0];                     
        }
        else { 
            x.src =  aImg[0];                     
            x.oSrc = '';
        }
    }
}


/****************************************************************************************************************/  
function VerCapa(mid, estadoVisible, oMenu){  // Oculta o muestra la opción del menú
    if(ns){
        document.layers[oMenu.nombre].document.layers[mid].visibility = estadoVisible;
    }else{
        document.all[mid].style.visibility= estadoVisible;
        }
}

/**************************************************************************************************************/   
function PosicionCapa( mid ,x ,y , oMenu){  // Coloca la opción del menú en la posición indicada
    if (ns){
        document.layers[oMenu.nombre].layers[mid].top  = x;
        document.layers[oMenu.nombre].layers[mid].left = y;
    }else{
        document.all[mid].style.top  = x; 
        document.all[mid].style.left = y; 
    }
}

/******************************************************************************************************************/
function capaClick(obj, menu){    //  sirve para plegar o desplegar una opción del menú, y el resto cambiarlas

    estado  = obj.estado;
    var olMenu = eval(menu);
     
    if (estado == "PLEGADO"){     //Si el nivel sobre el que se ha pinchado está plegado significa que puede haber 
                                  //algun nivel desplegado y por lo tanto hay que plegarlo
        for (f = 1 ; f<= obj0.numEle ; f++){    //se recorre el primer nivel y si encuentra alguno desplegado se restaura
            if (obj0.arrID1[f].estado == "DESPLEGADO"){
                obj0.arrID1[f].estado = "PLEGADO" ;                 
                CambiaSimbolo('IMG'+obj0.arrID1[f].ID,0,0,olMenu);
            }
        }
        obj.estado = "DESPLEGADO";          //Se despliega el que se ha pulsado     
        CambiaSimbolo('IMG'+obj.ID,1,1,olMenu);        
    }else{                                  //Si el nivel sobre el que se ha pinchado está desplegado significa que no hay ningún otro nivel desplegado 
        obj.estado = "PLEGADO";             //Se pliega el que se ha pulsado
        CambiaSimbolo('IMG'+obj.ID,0,1,olMenu);
    }
    
    posicionarCapas(olMenu);                 // coloco todas las capas
}

/*****************************************************************************************************************/
function posicionarCapas (oMenu){        //coloca todas las opciones del menu según sea su estado
    pos = oMenu.PosicionHorizontalDefecto;
    for (f = 1 ; f <= obj0.numEle ; f++){               // recorro el primer nivel
        PosicionCapa( obj0.arrID1[f].ID ,pos, oMenu.nivel1posY, oMenu);         // posiciono el primer nivel
        pos = pos + ( oMenu.espacioNivel1 * obj0.arrID1[f].numEspacios ) ;
        estado = obj0.arrID1[f].estado;
        if (estado == "DESPLEGADO" ){
            for (g = 1 ; g <= obj0.arrID1[f].numEle ; g++){     // recorro el segundo nivel y las muestro
                VerCapa(obj0.arrID1[f].arrID2[g].ID,'visible',oMenu);
                PosicionCapa( obj0.arrID1[f].arrID2[g].ID ,pos , oMenu.nivel2posY, oMenu);  
                pos = pos + ( oMenu.espacioNivel2 * obj0.arrID1[f].arrID2[g].numEspacios);
            }
        }else{
            for (g = 1 ; g <= obj0.arrID1[f].numEle ; g++){     // recorro el segundo nivel y las oculto
                VerCapa(obj0.arrID1[f].arrID2[g].ID,'hidden', oMenu);
            }  
        }         
    }  
}

function ImgMouseOver(opMenu,menu){
    var olMenu = eval(menu);

    var sImagen = "Menos";    
   var sImg = olMenu.imgmenos[1];
    if (opMenu.estado=="PLEGADO") {sImagen = "Mas"; sImg = olMenu.imgmas[1];}
    MM_swapImage('IMG'+opMenu.ID,"", sImg, 1);   
//    MM_swapImage('IMG'+oMenu.ID,"", 'img/btn'+sImagen+'1S.gif',1);   
}

function txtFilaSoloImg (id, idH, img) {
    return '<DIV  ID='+id+'  STYLE="position:absolute;"><img src="' + DrdImgPath () + img+'"></DIV><DIV  ID='+idH+' STYLE="position:absolute;"></DIV>';
    }

function txtinicioArbol (altura, oMenu) {
    //Colocamos el logo allá donde corresponda
    txt='<table width="100%" border="0" cellspacing="0" cellpadding="0"><tr>'
        +'<td><img src="'+ DrdImgPath () + 'transparente.gif' +'" width="1" height="'+altura+'"></td></tr><tr><td>';
   if (oMenu.imgFondo!='')
        txt += '<img src="'+ oMenu.imgFondo+'" >';
   txt += '</td></tr></table>';
    return txt;
    }
    



function marcaOpcion (obj) {
   //Solo IE
   if (window.CLASS_RESALT && document.all!=null)  {
      if (window.OLD_OBJ_RESALT!=null) {
         window.OLD_OBJ_RESALT.className=window.OLD_CLASS_RESALT;
         }
      window.OLD_OBJ_RESALT=obj;
      window.OLD_CLASS_RESALT=obj.className;
      obj.className=window.CLASS_RESALT;
      }
   }


function txtfilaPadreV2(ident, identH, num, texto, accion, tooltip, oMenu) {
    //Se trata de un padre con hijos
    acc=(accion=='')?"void(null);":accion;

 

    txt = '<DIV  ID=' + ident + ' STYLE="position:absolute;" '
          + ((tooltip!='' && DrdTooltipNativo())?"title=\""+DrdEscHTML(tooltip)+"\"":"") 
          +'><table width="100%" border="0" cellspacing="0" '
          + 'cellpadding="0"><tr><td height="'+oMenu.altoFila+'" valign="middle" background="'+oMenu.imgfondoniv1+'" >'
          + '<a href="JavaScript:capaClick(window.obj0.arrID1[' + num + "],'Menu"+oMenu.nombre+"');"+acc+'"  onMouseOut="MM_swapImgRestore();tooltip()" '
          + 'onMouseOver="ImgMouseOver(window.obj0.arrID1[' + num + '],\'Menu'+oMenu.nombre + '\')';

   if (tooltip != "" && !DrdTooltipNativo()) //caso de tooltip pero no nativo 
       txt +=  ";tooltip(event, '"+tooltip+"') ";
   txt += '" ';

    if (ns) 
       txt += ' STYLE="font-family: Verdana,Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold;  color: #C8D2E8; text-decoration: none;" >';
    else
       txt += ' class="menuNiv1" >';  

    txt += '<img name="IMG'+ ident +'" border="0" src="'+oMenu.imgmas[0]+'" widthK="13" height="'+oMenu.altoFila+'" align="texttop">' 
        + texto
        + '</a></td></tr></table></DIV>';
    txt += '<DIV  ID='+identH+' STYLE="position:absolute;">'
        + '<table width="100%" border="0" cellspacing="0" cellpadding="0">';

    return(txt);
    }

function txtfilaSinHijosV2(ident,identH,num,texto,accion, tooltip, oMenu)  {
    //Se trata de una opción sin hijos
    acc=(accion=='')?"void(null);":accion;
    txt='<DIV ID=' + ident + '  STYLE="position:absolute;" '
       + ((tooltip!='' && DrdTooltipNativo())?"title=\""+DrdEscHTML(tooltip)+"\"":"") 
       + '><table width="100%" border="0" cellspacing="0" '
       + 'cellpadding="0"><tr><td height="'+oMenu.altoFila+'" valign="middle" background="'+oMenu.imgfondoniv1+'" >'
       + '<a href="JavaScript:'+acc+'"  onMouseOut="MM_swapImgRestore();tooltip()" '
       + 'onMouseOver="MM_swapImage(\'IMG' + ident + '\',\'\',\''+ oMenu.iconiv1[1] +'\',1)';

   if (tooltip != "" && !DrdTooltipNativo())
       txt +=  ";tooltip(event, '"+tooltip+"') ";
   txt += '" ';
    
    if (ns) 
      txt +=  ' STYLE="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold;  color: #E6E8F5; text-decoration: none;" >';
    else
        txt +=  ' class="menuNiv2" >';  

    txt += '<img name="IMG'+ ident +'" border="0" src="'+ oMenu.iconiv1[0] +'" widthK="13" height="'+oMenu.altoFila+'" align="texttop">' 
        + texto
        + '</a></td></tr></table></DIV>';
    txt += '<DIV  ID='+identH+' STYLE="position:absolute;"></DIV>';
    return(txt);
    }

function txtfilaHijoV2(id, texto, accion, tooltip, nivel_indentacion, oMenu)  {
    acc=(accion=='')?"void(null);":accion;
    txt='<tr><td '
       + ((tooltip!='' && DrdTooltipNativo())?"title=\""+DrdEscHTML(tooltip)+"\"":"")
       +' height="'+oMenu.altoFila+'" valign="middle" background="'+oMenu.imgfondoniv2+'">';

    txt += '<img src="'+ DrdImgPath ()+'transparente.gif'+'" width="'+(8*(nivel_indentacion))+'" height="'+oMenu.altoFila+'" align="texttop">';
   
// txt += '<a href="JavaScript:marcaOpcion(this);'+acc+'" onMouseOut="MM_swapImgRestore()" '
//        +  'onMouseOver="MM_swapImage(\'img'+id+'\',\'\',\''+ oMenu.iconiv2[1] +'\',1)" ';

   txt += '<a href="Javascript:void(null);" onclick="marcaOpcion(this);'+acc+'" onMouseOut="MM_swapImgRestore();tooltip()" '
        +  'onMouseOver="MM_swapImage(\'img'+id+'\',\'\',\''+ oMenu.iconiv2[1] +'\',1)';

   if (tooltip != "" && !DrdTooltipNativo())
       txt +=  ";tooltip(event, '"+tooltip+"') ";
   txt += '" ';

   if (ns) 
        txt += ' STYLE="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold;  color: #E6E8F5; text-decoration: none;" >';
    else
        txt += ' class="menuNiv2" >';   


    txt += '<img name="img'+id+'" border="0" src="'+ oMenu.iconiv2[0] +'" widthK="17" height="'+oMenu.altoFila+'" align="texttop">';

   txt += texto +'</a></td></tr>';
    return(txt);
   }

function txtfilaHijoConHijosV2(id,texto,accion, tooltip, nivel_indentacion, oMenu)    {

   //Esto ha sido añadido
    acc=(accion=='')?"void(null);":accion;
    //txt='<tr><td class="menuNiv20" height="'+altoFila+'" valign="middle" background="../img/Menu/EGTM_FondoMnuNiv3.gif">';
    txt='<tr><td '
       + ((tooltip!='' && DrdTooltipNativo())?"title=\""+DrdEscHTML(tooltip)+"\"":"")
       +' height="'+oMenu.altoFila+'" valign="middle" background="'+oMenu.imgfondoniv3+'"';

    if (ns) 
        txt += '><a STYLE="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold; color: #C8D2E8; text-decoration: none;"></a>';
    else
        txt += ' class="menuNiv20" >';

    txt += '<img name="img'+id+'" border="0" src="'+ DrdImgPath ()+'transparente.gif'+'" width="'+8*(nivel_indentacion)+'" height="'+oMenu.altoFila+'" align="texttop">';
    txt += '<img name="IMG'+ id +'_btn" border="0" src="'+oMenu.imgmenos[0]+'" height="'+oMenu.altoFila+'" align="texttop">' ;


   txt += texto+'</td></tr>';
    return(txt);
}

function txtfilaPadre(ident, identH, num, texto, accion, tooltip, oMenu) {
    
    //Se trata de un padre con hijos
    acc=(accion=='')?"void(null);":accion;

    txt = '<DIV  ID=' + ident + ' STYLE="position:absolute;" '
          + ((tooltip!='' && DrdTooltipNativo())?"title=\""+DrdEscHTML(tooltip)+"\"":"") 
          + '><table width="132" border="0" cellspacing="0" '
          + 'cellpadding="0"><tr><td height="'+oMenu.altoFila+'" valign="middle" background="'+oMenu.imgfondoniv1+'" >'
          + '<a href="JavaScript:capaClick(window.obj0.arrID1[' + num + "],'Menu"+oMenu.nombre+"');"+acc+'"  onMouseOut="MM_swapImgRestore();tooltip()" '
          + 'onMouseOver="ImgMouseOver(window.obj0.arrID1[' + num + '],\'Menu'+oMenu.nombre + '\')';

   if (tooltip != "" && !DrdTooltipNativo())
       txt +=  ";tooltip(event, '"+tooltip+"') ";
   txt += '" ';

    if (ns) 
       txt += ' STYLE="font-family: Verdana,Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold;  color: #C8D2E8; text-decoration: none;" >';
    else
       txt += ' class="menuNiv1" >';  

    txt += '<img name="IMG'+ ident +'" border="0" src="'+oMenu.imgmas[0]+'" widthK="13" height="'+oMenu.altoFila+'" align="texttop">' 
        + texto
        + '</a></td></tr></table></DIV>';
    txt += '<DIV  ID='+identH+' STYLE="position:absolute;">'
        + '<table width="132" border="0" cellspacing="0" cellpadding="0">';
    return(txt);
    }

function txtfilaSinHijos(ident,identH,num,texto,accion, tooltip, oMenu)  {
    //Se trata de una opción sin hijos
    acc=(accion=='')?"void(null);":accion;
    txt='<DIV  ID=' + ident + '  STYLE="position:absolute;" '
       + ((tooltip!='' && DrdTooltipNativo())?"title=\""+DrdEscHTML(tooltip)+"\"":"") 
       +'><table width="132" border="0" cellspacing="0" '
       + 'cellpadding="0"><tr><td height="'+oMenu.altoFila+'" valign="middle" background="'+oMenu.imgfondoniv1+'" >'
       + '<a href="JavaScript:'+acc+'"  onMouseOut="MM_swapImgRestore();tooltip()" '
       + 'onMouseOver="MM_swapImage(\'IMG' + ident + '\',\'\',\''+ oMenu.iconiv1[1] +'\',1)';

   if (tooltip != "" && !DrdTooltipNativo())
       txt +=  ";tooltip(event, '"+tooltip+"') ";
   txt += '" ';
    
   if (ns) 
      txt += ' STYLE="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold;  color: #E6E8F5; text-decoration: none;" >';
   else
      txt += ' class="menuNiv2" >'; 
   
   txt += '<img name="IMG'+ ident +'" border="0" src="'+ oMenu.iconiv1[0] +'" widthK="13" height="'+oMenu.altoFila+'" align="left">' 
       + texto
       + '</a></td></tr></table></DIV>';
   txt += '<DIV  ID='+identH+' STYLE="position:absolute;"></DIV>';
   return(txt);
}

function txtfilaHijo(id, texto, accion, tooltip, nivel_indentacion, oMenu)  {
   acc=(accion=='')?"void(null);":accion;
   txt='<tr><td '
      + ((tooltip!='' && DrdTooltipNativo())?"title=\""+DrdEscHTML(tooltip)+"\"":"") 
      +' height="'+oMenu.altoFila+'" valign="middle" background="'+oMenu.imgfondoniv2+'">';

   if (nivel_indentacion==2)
      txt += '<img src="'+ DrdImgPath ()+'transparente.gif'+'" width="8" height="'+oMenu.altoFila+'" align="left">';

   txt += '<a href="JavaScript:'+acc+'" onMouseOut="MM_swapImgRestore();tooltip()" '
       +  'onMouseOver="MM_swapImage(\'img'+id+'\',\'\',\''+ oMenu.iconiv2[1] +'\',1)';

   if (tooltip != "" && !DrdTooltipNativo())
       txt +=  ";tooltip(event, '"+tooltip+"') ";
   txt += '" ';

    if (ns) 
        txt += ' STYLE="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold;  color: #E6E8F5; text-decoration: none;" >';
    else
        txt += ' class="menuNiv2" >';   

    txt += '<img name="img'+id+'" border="0" src="'+ oMenu.iconiv2[0] +'" widthK="17" height="'+oMenu.altoFila+'" align="left">'
        + texto +'</a></td></tr>';
    return(txt);
}

function txtfilaHijoConHijos(id, texto, accion, tooltip, oMenu)    {
    acc=(accion=='')?"void(null);":accion;
    txt='<tr><td '
      + ((tooltip!='' && DrdTooltipNativo())?"title=\""+DrdEscHTML(tooltip)+"\"":"") 
      +' height="'+oMenu.altoFila+'" valign="middle" background="'+oMenu.imgfondoniv3+'"';
    if (ns) 
        txt += '><a STYLE="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold; color: #C8D2E8; text-decoration: none;"></a>';
    else
        txt += ' class="menuNiv20" >';

    txt += '<img name="img'+id+'" border="0" src="'+ DrdImgPath ()+'transparente.gif'+'" widthK="17" height="'+oMenu.altoFila+'" align="left">'+texto+'</td></tr>';
    return(txt);
}

function txtfinal() { return("</table></div>"); }



function iniciarArbol (menu)    {
   var oMenu = eval(menu);

   var arrayX = new Array();
   //var texto="";
   var texto=""
   var nhijosvalidos = 0;
   for (p=0; p < oMenu.opciones.length; p++)   { //Por cada padre ...
      idCapa = "idP"+(p+1);
      idCapaGHijo = "idH"+(p+1);

//      if (oMenu.opciones[p].length == 2)    {     //si es solo una imagen ...
      if (oMenu.opciones[p].length == 4 && oMenu.opciones[p][3]==null)    {     //si es solo una imagen ...
         nhijosvalidos++; 
         texto += txtFilaSoloImg(idCapa,idCapaGHijo,oMenu.opciones[p][0], oMenu);
         arrayX[p+1] = new Objeto1(idCapa, "PLEGADO",1, [, new Objeto2(idCapaGHijo, 0)] ,2); 
      }
      else if (oMenu.opciones[p].length == 3)   { //si no tiene hijos
         nhijosvalidos++; //las img no cuentan esta vez para posicionar el fondo

         // txtfilaSinHijos(ident,identH,num,texto,accion, tooltip, oMenu)
         if (oMenu.niveles == 3)
            texto += txtfilaSinHijosV2(idCapa , idCapaGHijo , p+1 , oMenu.opciones[p][0] , oMenu.opciones[p][1], oMenu.opciones[p][2], oMenu);
         else
            texto += txtfilaSinHijos(idCapa , idCapaGHijo , p+1 , oMenu.opciones[p][0] , oMenu.opciones[p][1], oMenu.opciones[p][2], oMenu);

         arrayX[p+1] = new Objeto1(idCapa, "PLEGADO",1, [, new Objeto2(idCapaGHijo, 0)] ,2); 
      }
      else    {
         nhijosvalidos++; //las img no cuentan esta vez para posicionar el fondo
         var hijos = oMenu.opciones[p][3];

         // txtfilaPadre(ident, identH, num, texto, accion, tooltip, oMenu)
         if (oMenu.niveles == 3)
            texto += txtfilaPadreV2( idCapa, idCapaGHijo, p+1 ,oMenu.opciones[p][0], oMenu.opciones[p][1], oMenu.opciones[p][2], oMenu);
         else
            texto += txtfilaPadre( idCapa, idCapaGHijo, p+1, oMenu.opciones[p][0], oMenu.opciones[p][1], oMenu.opciones[p][2], oMenu);

         for (h = 0; h < hijos.length; h++)  {   //Por cada hijo...
            if (hijos[h][1] == '') { 
               // txtfilaHijoConHijos(id, texto, accion, tooltip, oMenu)
               if (oMenu.niveles == 3)
                  texto += txtfilaHijoConHijosV2( idCapaGHijo+h , hijos[h][0], hijos[h][1], hijos[h][2], hijos[h][3], oMenu);
               else
                  texto += txtfilaHijoConHijos( idCapaGHijo+h, hijos[h][0], hijos[h][1], hijos[h][2], oMenu);
            }
            else {
               // txtfilaHijo (id, texto, accion, tooltip, nivel_indentacion, oMenu)
               if (oMenu.niveles == 3)
                  texto += txtfilaHijoV2( idCapaGHijo+h , hijos[h][0] , hijos[h][1], hijos[h][2], hijos[h][3], oMenu);
               else
                  texto += txtfilaHijo( idCapaGHijo+h, hijos[h][0], hijos[h][1], hijos[h][2], hijos[h][3], oMenu);
            }
         }
         texto += txtfinal();
         arrayX[p+1] = new Objeto1(idCapa, "PLEGADO",1, [, new Objeto2(idCapaGHijo, oMenu.altoFila * hijos.length)] ,2); 
      }   
   }
//    alert(nhijosvalidos);
//    texto2 = txtinicioArbol((nhijosvalidos) *  oMenu.altoFila, oMenu);
//    alert(texto2);

   texto = txtinicioArbol((nhijosvalidos) *  oMenu.altoFila, oMenu) + texto;
    window.obj0 = new Objeto0(arrayX , oMenu.opciones.length )  ;

//    alert(texto);
//  document.all['CArbol'].innerHTML=texto;

    EscribeEnCapa(texto,oMenu.nombre);
    }

function EscribeEnCapa (txt,capa)   {
//alert(capa);
// var vCapa=( (navegador=='N')? document.layers["CArbol"] : document.all["CArbol"]);

    if (ns) {
      document.layers[capa].document.open();
      document.layers[capa].document.write(txt);
      document.layers[capa].document.close();
//        capa.document.open();
//        capa.document.write(txt);
//        capa.document.close();
        }
    else    {
        document.all[capa].innerHTML=txt;
        }
    }

function Objeto2(id, numEspacio){
    this.ID = id;               // id de la capa
    this.numEspacios = numEspacio;      // espacios a dejar por lo ancho que sean los submenus
}

function Objeto1(id, estado,numElementos,arrayID2,numEspacios){       // esta funcion es el constructor
    this.ID = id;
    this.estado= estado;            // el estado no sindica si está o no desplegado
    this.numEle= numElementos;      // numero de elementos del nivel dos
    this.arrID2 = arrayID2;     // array de los ID de la capa dos
    this.numEspacios = numEspacios;     // espacios a dejar por lo ancho que sean los submenus
}



function Objeto0(arrayID1,numElementos){
    this.arrID1    = arrayID1;      //  En este array colocamos todos los elementos del nivel 1
    this.numEle  = numElementos;    //  Nos indica cuantos elementos tiene el nivel uno 
}



