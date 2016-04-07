//Obj gruposolapas

function ObjSolapas(nombre,numSolapas,solapaInicial,classTxtOff,classTxtOn,izqOff,izqOn,fndOff,fndOn,dchaOff,dchaOn)	{
   this.nombre=nombre;
   this.classTxtOff=classTxtOff
   this.classTxtOn=classTxtOn
   this.izqOff=DrdImgPath()+izqOff;
   this.izqOn=DrdImgPath()+izqOn;
   this.fndOff=DrdImgPath()+fndOff;
   this.fndOn=DrdImgPath()+fndOn;
   this.dchaOff=DrdImgPath()+dchaOff;
   this.dchaOn=DrdImgPath()+dchaOn;
	this.solapas=[];
   //relleno solapas
	for (var i=0;i<numSolapas;i++)
		this.solapas[this.solapas.length]=new ObjSolapa(nombre,i,(solapaInicial==i?true:false),this);
   this.solapaActiva=solapaInicial;
	}
ObjSolapas.prototype.init=function()   {
   this.capaBotones=document.all[this.nombre+"_botones"];
   var le=this.solapas.length;
	for (var i=0;i<le;i++)
		this.solapas[i].init();
   this.solapas[this.solapaActiva].muestraCapa();
   }

//Obj solapatexto

function ObjSolapa(nombre,indSolapa,activa,objSolapas)	{
   this.nombre=nombre;
   this.objSolapas=objSolapas
   this.indice=indSolapa;
   this.activa=activa
   }
ObjSolapa.prototype.init=function() {
   this.capa=document.all[this.nombre+"_slp"+this.indice]
   this.tblBoton=this.objSolapas.capaBotones.all["drdtabl"+this.indice]
   this.imgIzq=this.tblBoton.all["imgIzq"];
   this.imgDcha=this.tblBoton.all["imgDcha"];
   this.cendCentr=this.tblBoton.all["cendCentr"];
	}
ObjSolapa.prototype.click=function()   {
   if (!this.activa) {
      this.objSolapas.solapas[this.objSolapas.solapaActiva].ocultaCapa();
      this.objSolapas.solapas[this.objSolapas.solapaActiva].ocultaSolapa();
      this.objSolapas.solapaActiva=this.indice
      this.muestraCapa();
      this.muestraSolapa();
      }
   }
ObjSolapa.prototype.ocultaCapa=function()   {   
   this.activa=false;
   this.capa.style.visibility="hidden";  
   }
ObjSolapa.prototype.ocultaSolapa=function()   {   
   this.tblBoton.style.cursor="hand";
   this.cendCentr.background=this.objSolapas.fndOff;
   this.cendCentr.className=this.objSolapas.classTxtOff
   this.imgIzq.src=this.objSolapas.izqOff;
   this.imgDcha.src=this.objSolapas.dchaOff;
   }
ObjSolapa.prototype.muestraCapa=function()  {
   this.activa=true;
   this.capa.style.visibility="inherit"; 
   }
ObjSolapa.prototype.muestraSolapa=function()   {
   this.tblBoton.style.cursor="default";
   this.cendCentr.background=this.objSolapas.fndOn;
   this.cendCentr.className=this.objSolapas.classTxtOn
   this.imgIzq.src=this.objSolapas.izqOn;
   this.imgDcha.src=this.objSolapas.dchaOn;
   }