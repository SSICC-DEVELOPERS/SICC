// $Id: d3ocupado.js,v 1.1 2009/12/03 19:03:47 pecbazalar Exp $

var d3ocupado_cont=0;

function d3ocupado_ver(nombre,d3ocupadoPosition) {
	d3ocupado_cont++;
	var W,H;
	if (ns) {
		var w=document.layers['d3ocupado'+nombre].document.width;
		var h=document.layers['d3ocupado'+nombre].document.height;
		if (d3ocupadoPosition=='SI') {W=window.pageXOffset;	H=window.pageYOffset;}
		else if (d3ocupadoPosition=='SD') {W=window.innerWidth+window.pageXOffset-w-(document.height>window.innerHeight?16:0);H=window.pageYOffset;}
		else if (d3ocupadoPosition=='II') {W=window.pageXOffset;H=window.innerHeight+window.pageYOffset-h-(document.width>window.innerWidth?16:0);}
		else if (d3ocupadoPosition=='ID') {W=window.innerWidth+window.pageXOffset-w-(document.height>window.innerHeight?16:0);H=window.innerHeight+window.pageYOffset-h-(document.width>window.innerWidth?16:0);}
		else {W=window.innerWidth/2+window.pageXOffset-w/2-(document.height>window.innerHeight?16:0);H=window.innerHeight/2+window.pageYOffset-h/2-(document.width>window.innerWidth?16:0);} // C
		for(var i=0;i<document.layers['d3ocupado'+nombre].document.images.length;i++) {document.layers['d3ocupado'+nombre].document.images[i].src=document.layers['d3ocupado'+nombre].document.images[i].src;}
		document.layers['d3ocupado'+nombre].top=H;
		document.layers['d3ocupado'+nombre].left=W;
		document.layers['d3ocupado'+nombre].visibility="show";
	}
	else {
      var capaOcupado=document.all["d3ocupado"+nombre];
      var db=document.body;
		var w=capaOcupado.scrollWidth;
		var h=capaOcupado.scrollHeight;
		if (d3ocupadoPosition=='SI') {W=db.scrollLeft;H=db.scrollTop;}
		else if (d3ocupadoPosition=='SD') {W=db.scrollLeft+db.clientWidth-w;H=db.scrollTop;}
		else if (d3ocupadoPosition=='II') {W=db.scrollLeft;H=db.scrollTop+db.clientHeight-h;}
		else if (d3ocupadoPosition=='ID') {W=db.scrollLeft+db.clientWidth-w;H=db.scrollTop+db.clientHeight-h;}
		else {W=db.scrollLeft+db.clientWidth/2-w/2;H=db.scrollTop+db.clientHeight/2-h/2;} //C
		capaOcupado.style.top=H;
		capaOcupado.style.left=W;
		capaOcupado.style.visibility="visible";
		if (window.ocupado_bloquea) {
         var capaDruida=document.all['DRUIDA'],capaDruidaStyle=capaDruida.style;
         capaDruidaStyle.height="0";
         capaDruidaStyle.visibility='visible'; 
         var bb=document.body;
         var w=bb.scrollWidth
         var h=0;
         if (window.drdAltoOcupado) {
            h=window.drdAltoOcupado;
            }
         else  {
            var h=bb.scrollHeight;
            var h2=bb.offsetHeight;
            h=h>h2?h:h2;//Tomamos el mayor.
            }
			capaDruidaStyle.pixelWidth=w;
         //Restamos por bug
         capaDruidaStyle.height=h;
         capaDruidaStyle.display="block";
			capaDruidaStyle.zIndex=9999999999;

         if (capaDruida.offsetHeight>h)   {
            h=h-(capaDruida.offsetHeight-h)
            capaDruidaStyle.height=h;
            }
         if (window.ocupado_bloquea_onclick)
            capaDruida.onclick=d3_bloq_oncl
		}
	}
}

function d3ocupado_ocultar(nombre) {
	d3ocupado_cont--;
	if (d3ocupado_cont<0) d3ocupado_cont=0;
	if (d3ocupado_cont==0) {
		if (ns) {
         if (document.layers['d3ocupado'+nombre])
            document.layers['d3ocupado'+nombre].visibility="hide";
         }
		else {
         if (document.all['d3ocupado'+nombre])
   			document.all['d3ocupado'+nombre].style.visibility="hidden";
			if (window.ocupado_bloquea) {
            if (document.all['DRUIDA']) {
               document.all['DRUIDA'].style.visibility='hidden';
               document.all['DRUIDA'].style.display='none';
               document.all['DRUIDA'].style.zIndex=0;
               }
         if (window.ocupado_bloquea_onclick)
            document.all['DRUIDA'].onclick=null;
			}
		}
	}

}


function d3_bloq_oncl ()   {
   if (window.ocupado_bloquea_onclick)
      eval(window.ocupado_bloquea_onclick)
   }