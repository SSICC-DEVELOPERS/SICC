/********************************** 
        arbollista.js
        01/11/2002
        DRUIDA 3.0
**********************************/

//Separador para arbolista. Por defecto es el punto.
//Desde el proyecto incluir esta variable con el valor que se desee en el JS de la página.
var vDrdSeparadorArbolLista='.';

function ArbolLista(imgChk0,imgChk1,imgHueco,imgOpen,imgClose,iconos,renderOptimizado,idNivelesArbol) {
        this.data=new Array;

   this.imgChk0=imgChk0;
   this.imgChk1=imgChk1;
   this.imgOpen=imgOpen;
   this.imgClose=imgClose;
   this.imgHueco=imgHueco;
   this.iconos=iconos;
   this.renderOptimizado=renderOptimizado;

	this.index=0;
	this.selected="";
	this.accion=null;
	this.seleccionUnica=true;

        this.display=arbollista_display;
        this.display_simplificado=arbollista_display_simplificado;
        this.display_normal=arbollista_display_normal;
        this.displayRama_normal=arbollista_displayRama_normal;
        this.displayRama_simplificado=arbollista_displayRama_simplificado;
        this.add=arbollista_add;
        this.del=arbollista_del;
        this.init=arbollista_init; // carga 
        this.check=arbollista_check;
        this.getData=arbollista_getData;
        this.checked=arbollista_checked;
        this.opened=arbollista_opened;
        this.get2=arbollista_get2;
        this.expand=arbollista_expand; // repinta
        this.collapse=arbollista_collapse; // repinta
        this.expandLevel=arbollista_expandLevel; // repinta
        this.getChecked=arbollista_getChecked;
        this.mueveNodo=arbollista_mueveNodo;
        this.getNivelSiguiente=arbollista_getNivelSiguiente;
        this.addNodoHijo=arbollista_addNodoHijo;
        this.modificaValor=arbollista_modificaValor;

      if(idNivelesArbol.length==0)
         this.hayIdNivelesArbol=false;
      else
         this.hayIdNivelesArbol=true;

      this.idNivelesArbol=idNivelesArbol;
}

function arbollista_get2(nivel) {
        var c='',i,j,r,f,l,p; // rama , fila actual
	var nodo_padre=null;
        var niveles=nivel.split(vDrdSeparadorArbolLista);
        r=this.data;
        for(i=0;i<niveles.length;i++) {
                c+=(i==0?niveles[0]:vDrdSeparadorArbolLista+niveles[i]);
                l=r.length;
		for(j=0;j<l;j++) {
                        f=r[j];
                        if (f[0]==c) {
                                if (f[3]==null && i!=(niveles.length-1)) {DrdMsgCore(230);return null;}
                                p=r; r=f[3]; break;
                        }
                }
                if (j==l) {DrdMsgCore(230);return null;}
		if (i<niveles.length-1) nodo_padre=f;
        }
        return [f,i-1,j,p,nodo_padre]; // f=nodo_actual, i-1=nivel de indentación, j=orden del nodo entre sus hermanos, p=hermanos
}

function arbollista_getData(nivel) {var g=this.get2(nivel);return (g==null?null:g[0][2]);}
function arbollista_checked(nivel) {var g=this.get2(nivel);return (g==null?null:g[0][4]);}
function arbollista_opened(nivel) {var g=this.get2(nivel);return (g==null?null:g[0][5]);}

function arbollista_check(nivel,estado,accion) { // accion=true/false
   var g=this.get2(nivel);
   if (g!=null) {
      if (estado==null) {estado=!g[0][4];}
      if(this.seleccionUnica && this.selected.length > 0){
         var w=this.get2(this.selected);
         w[0][4]=false;
         this.display();
      }
      if(estado){ this.selected=g[0][0];}
      else { this.selected='';}
      g[0][4]=estado;if (document.all[this.nombre+'_'+g[0][6]]) {document.all[this.nombre+'_'+g[0][6]].src=estado?this.imgChk1:this.imgChk0;}
      if (this.checkCascade && g[0][3]!=null) {
         for(var i=0;i<g[0][3].length;i++) {
            this.check(g[0][3][i][0],estado,false);
         }
      }
   }
	if (accion==true) {
		if (this.accion!=null){
			 eval(this.accion);
		}
	}
}

function arbollista_del(nivel) {
        var g=this.get2(nivel);
        if (g!=null) {
                var i=g[3].length-1;
                for(var j=g[2];j<i;) {g[3][j++]=g[3][j];}
                g[3][i]=null;g[3].length--;
		var nodo_padre=g[4];
		if (nodo_padre!=null && g[3].length==0) {nodo_padre[3]=null;}
		this.selected="";
        }
}

function arbollista_expand(nivel) {var g=this.get2(nivel);if (g!=null) {g[0][5]=true;this.display();}}
function arbollista_collapse(nivel) {var g=this.get2(nivel);if (g!=null) {g[0][5]=false;this.display();}}

function arbollista_expandLevel(nivel,n,nodo) {
        var i;
        if (nodo==null) {nodo=this.data;n=0;}
        for(i=0;i<nodo.length;i++) {
                if (nodo[i][3]==null) continue;
                nodo[i][5]=nivel>n;
                this.expandLevel(nivel,n+1,nodo[i][3]);
        }
        if (n==0) this.display();
}

function arbollista_display() {
   if (this.renderOptimizado)
      this.display_simplificado();
   else
      this.display_normal();
   }


function arbollista_display_normal() {
   var s='<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0>';
   s+=this.displayRama_normal(0,this.data);
   s+='</TABLE>';
   scroll_to(this.nombre+'Scroll',s);
   }


//Repetido en la lista y el arbol. ¿Sacar a base?
Array.prototype.mete= function (obj)   {//Mucho mas rapido que ir sumando en una cadena
   this[this.length]=obj;
   }

function arbollista_display_simplificado()   {//Pintado rápido, solo IE
   var s=['<TABLE WIDTH=100% BORDER=0 CELLPADDING=0 CELLSPACING=0>'];
   //Genero el <COLGROUP>
   s.mete('<COLGROUP><COL WIDTH='+this.anchos[0]+'>');
   for(var i=1;i<this.anchos.length;i++) 
      s.mete('<COL WIDTH='+this.anchos[i]+' ID='+this.id[i]+'>');
   s.mete('</COLGROUP>');
   this.displayRama_simplificado(0,this.data,s)
   s.mete('</TABLE>');
   scroll_to(this.nombre+'Scroll',s.join(''));
   }

function arbollista_displayRama_simplificado(n,rama,s) {
   var f,p,i,j;
   var indent='';
   for(i=0;i<n*this.indent;i++)
      {indent+='&nbsp;';}
   var cols=this.anchos.length;
   var filas=rama.length;
   for(i=0;i<filas;i++) {
      f=rama[i];
      var idNiv=""
      if (this.hayIdNivelesArbol)   {
         idNiv=( this.idNivelesArbol.length>n?this.idNivelesArbol[n]:this.idNivelesArbol[this.idNivelesArbol.length-1] );
         s.mete('<TR><TD NOWRAP id="'+idNiv+'">'+indent);
         }  
      else  
         s.mete('<TR><TD NOWRAP>'+indent);
      if (f[3]!=null) { // padre
         var elOnclickAbr=""
         if (this.accionAbr)  {
            elOnclickAbr='nivel=\''+f[0]+'\';if (eval('+this.nombre+'.accionAbr))'+this.nombre+'.expand(\''+f[0]+'\');'
            }
         else
            elOnclickAbr=this.nombre+'.expand(\''+f[0]+'\')';
         
         if (f[5]) 
            s.mete('<IMG style="cursor:hand" SRC="'+this.imgClose+'" onclick="'+this.nombre+'.collapse(\''+f[0]+'\')" align=absmiddle>');// open
         else 
            s.mete('<IMG style="cursor:hand" SRC="'+this.imgOpen+'" onclick="'+elOnclickAbr+'" align=absmiddle>');
         }		     
      else //Si no es padre dejamos el espacio.
         s.mete('<IMG SRC="'+this.imgHueco+'" align=absmiddle>');

      if (f[7])    //f[7]= (no tengo check)? 
         s.mete('<IMG SRC="'+this.imgHueco+'" align=absmiddle>');
      else 
         s.mete('<IMG style="cursor:hand" name="'+(this.nombre+'_'+f[6])+'" onclick="'+this.nombre+'.check(\''+f[0]+'\',null,true)" SRC="'+(f[4]?this.imgChk1:this.imgChk0)+'" align=absmiddle></A>');

      //Icono

      var onclickJs=f[8]?" onclick=\""+f[8]+"\" ":"";
      var estiloJs=f[8]?" style=\"cursor:hand\" ":"";

      if (f[1]!=null)
         {s.mete('<IMG SRC="'+this.iconos[f[1]]+'" '+onclickJs+estiloJs+' align=absmiddle>');}
      s.mete('<SPAN id='+this.id[0]+'>'+f[2][0]+'</SPAN></TD>');
      if (this.hayIdNivelesArbol)   
         for(j=1;j<cols;j++) 
            {s.mete('<TD id="'+idNiv+'" NOWRAP>'+(f[2][j]!=null?f[2][j]:'')+'</TD>');}
      else
         for(j=1;j<cols;j++) 
            {s.mete('<TD NOWRAP>'+(f[2][j]!=null?f[2][j]:'')+'</TD>');}
      s.mete('</TR>');
      if (f[3]!=null && f[5])
         {this.displayRama_simplificado(n+1,f[3],s)}
      }
   }



function arbollista_displayRama_normal(n,rama) {
        var f,p,i,j,s='';
        var indent='';for(i=0;i<n*this.indent;i++) {indent+='&nbsp;';}
        for(i=0;i<rama.length;i++) {
                f=rama[i];
                s+='<TR><TD NOWRAP width='+this.anchos[0]+'>'+indent;
                if (f[3]!=null) { // padre
                        if (f[5]) {s+='<A HREF="javascript:'+this.nombre+'.collapse(\''+f[0]+'\')"><IMG SRC="'+this.imgClose+'" BORDER=0 align=absmiddle></A>';} // open
                        else {s+='<A HREF="javascript:'+this.nombre+'.expand(\''+f[0]+'\')"><IMG SRC="'+this.imgOpen+'" BORDER=0 align=absmiddle></A>';}
                }		     
                else{ //Si no es padre dejamos el espacio.
	                s+='<IMG SRC="'+this.imgHueco+'" BORDER=0 align=absmiddle>';
                }

                if (f[7])  {  //f[7]= (no tengo check)? 
	                s+='<IMG SRC="'+this.imgHueco+'" BORDER=0 align=absmiddle>';
                   }
                else {
                   s+='<A HREF="javascript:'+this.nombre+'.check(\''+f[0]+'\',null,true)"><IMG name="'+(this.nombre+'_'+f[6])+'" SRC="'+(f[4]?this.imgChk1:this.imgChk0)+'" BORDER=0 align=absmiddle></A>';
                   }

                if (f[1]!=null) {s+='<IMG SRC="'+this.iconos[f[1]]+'" BORDER=0 align=absmiddle>';}
                s+='<SPAN id='+this.id[0]+'>'+f[2][0]+'</SPAN></TD>';
                for(j=1;j<this.anchos.length;j++) {s+='<TD NOWRAP id='+this.id[j]+' width='+this.anchos[j]+'>'+(f[2][j]!=null?f[2][j]:'')+'</TD>';}
                s+='</TR>';
                if (f[3]!=null && f[5]) {s+=this.displayRama_normal(n+1,f[3]);}
        }
        return s;
   }

   function arbollista_add(fila) { // (Array)
      var c='',i,j,r,f,l; // rama , fila actual
      var niveles=fila[0].split(vDrdSeparadorArbolLista);
      r=this.data;
      for(i=0;i<niveles.length-1;i++) {
             c+=(i==0?niveles[0]:vDrdSeparadorArbolLista+niveles[i]);
             l=r.length;
             for(j=0;j<l;j++) {
                     f=r[j];
                     if (f[0]==c) {
                             if (f[3]==null) {
                                     if (i!=(niveles.length-2)) {DrdMsgCore(230);return;}
                                     f[3]=new Array;
                             }
                             r=f[3]; break;
                     }
             }
             if (j==l) {DrdMsgCore(230);return;}
         }
      for(i=0;i<r.length;i++) {f=r[i];if (f[0]>=fila[0]) {if (f[0]==fila[0]) {DrdMsgCore(231);return;}break;}}        
      for(j=r.length;j>i;) {r[j--]=r[j];}
      r[i]=[fila[0],fila[1],fila[2],null,false,false,this.index++,fila[3],fila[4]];
      }

//DrdPrecargaImgs('http://car3:2005/d3/img/ALICO.gif','http://car3:2005/d3/img/ALCHK0.gif','http://car3:2005/d3/img/hueco.gif','http://car3:2005/d3/img/hueco.gif','http://car3:2005/d3/img/ALOPEN.gif');

   function arbollista_init(array) { // ['n1.n2.n3',icono,['c1','c2','c3'],sinSelecc?]
      this.index=0;
      this.data=new Array;
      for(var i=0;i<array.length;i++) {this.add(array[i]);}

      //De paso hago la precarga también;

      /*if (this.iconos)  {
         for (var r=0;r<this.iconos.length;r++) {
            DrdPrecargaImg(this.iconos[r]);
            }
         }
      */
      //DrdPrecargaImg(this.imgChk0);
      //DrdPrecargaImg(this.imgChk1);
      //DrdPrecargaImg(this.imgClose);
      //DrdPrecargaImg(this.imgHueco);
      //DrdPrecargaImg(this.imgOpen);

      //DrdPrecargaImgs('http://car3:2005/d3/img/ALICO.gif','http://car3:2005/d3/img/ALCHK0.gif','http://car3:2005/d3/img/hueco.gif','http://car3:2005/d3/img/hueco.gif','http://car3:2005/d3/img/ALOPEN.gif');
      }

function arbollista_getChecked(){
	return this.selected;
}

function arbollista_mueveNodo(direccion){
     if(this.selected.length > 0){
        var o = this.get2(this.selected);
        var aux = new Array;
        var numHermano = o[2];
        var numHermanos = o[3].length;
	if(numHermano == 0 && direccion == 'up'){return null;}
        if(numHermano==numHermanos-1 && direccion == 'down'){return null;}
        if(direccion == 'up'){
        	aux[0] = o[3][numHermano];
        	aux[1] = o[3][numHermano-1];
        	o[3][numHermano] = o[3][numHermano-1];
        	o[3][numHermano-1] = aux[0];
        	this.display();
        	return aux;
        }else if(direccion == 'down'){
        	aux[0] = o[3][numHermano];
        	aux[1] = o[3][numHermano+1];
        	o[3][numHermano] = o[3][numHermano+1];
        	o[3][numHermano+1] = aux[0];
        	this.display();
        	return aux;
        }
     }        
}

function arbollista_getNivelSiguiente(){
	if(this.selected.length > 0){
	        var nodoAct = this.get2(this.selected);
	        if(nodoAct[0][3] != null){
	        	lg = ''+nodoAct[0][3].length;
	        	var val = nodoAct[0][3][nodoAct[0][3].length-1][0];
	        	val = val.substring(0,(val.length-lg.length));
	        	var f = nodoAct[0][3].length+1;
	        	val = val + f;
	        	return val;
	        }else{
	        	return this.selected+vDrdSeparadorArbolLista+'n1';
	        }
	}
	
}

function arbollista_addNodoHijo(datos){
	niv = this.getNivelSiguiente();
	if( niv != null && datos.length > 0){
		var fila = new Array;
		fila[0] = niv;
		fila[1] = null;
		fila[2] = datos;
		this.add(fila);
		this.get2(this.selected)[0][5]=true;
		this.display();
		return niv;
	}	
}

function arbollista_modificaValor(numCampo,valor){
	if( this.selected != null ){
		this.getData(this.selected)[numCampo]=valor;
		this.display();
	}
}
