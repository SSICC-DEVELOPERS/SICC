/********************************** 
	canal.js
	Funciones JavaScript asociadas a la clase canal (Canal.java)
	14/02/2001
	DRUIDA 1.1
**********************************/
function Canal(marco,srv) {
	this.servicios=new Vector(); this.servicios.cargar(srv);
	this.barral=0;
	this.barrainc=0;
	this.temporizador=null;
	this.f=0;
	this.canalFrame='';
	this.descriptor='';
	this.codigo='';
	this.mensaje='';
	this.datos=null;

	this.run=CanalRun;
	this.barra=CanalBarra;
	this.stop=CanalStop;
	this.getDescriptor=CanalGetDescriptor;
	this.getCodigo=CanalGetCodigo;
	this.getMensaje=CanalGetMensaje;
	this.getDatos=CanalGetDatos;
}

function CanalRun(descriptor) {
	var n=this.servicios.buscar(descriptor,0);
	if (n==-1) {alert('Canal(): el descriptor indicado ('+descriptor+') no existe en este canal.'); return false;}
	var valid='N'; if (this.servicios.ij(n,3)=='true') {valid='S';}
	set(this.servicios.ij(n,2)+'.drd_canal_descriptor',descriptor);
	if (this.servicios.ij(n,4)!='-1') {set(this.servicios.ij(n,2)+'.drd_canal_salida',this.servicios.ij(n,4));set(this.servicios.ij(n,2)+'.drd_canal_campos',this.servicios.ij(n,8));set(this.servicios.ij(n,2)+'.drd_canal_separador',this.servicios.ij(n,7));}
	this.canalFrame=window.open('','canalFrame','toolbar=0,directories=0,height=100,width=100,location=0,personalbar=0,resizable=0,titlebar=no,scrollbars=0,status=0,top=2000,left=2000');
	this.canalFrame.blur();
	if (!envia(this.servicios.ij(n,2),this.servicios.ij(n,1),"canalFrame",valid)) {
		this.canalFrame.close();
		return false;
	}
	this.descriptor=descriptor;
	this.f=1;

	var capa,W,H,W1,H1;
	if (ns) {capa=document.canalMsg0.document.canalMsg1;} else {capa=document.all['canalMsg1'].style;}
	W=(ns?window.innerWidth/2+window.pageXOffset:document.body.scrollLeft+document.body.offsetWidth/2);
	H=(ns?window.innerHeight/2+window.pageYOffset:document.body.scrollTop+document.body.offsetHeight/2);
	capa.top=H-50;capa.left=W-100;

	W1=(ns?document.width:document.body.scrollWidth);
	H1=(ns?document.height:document.body.scrollHeight);	
	if (ns) {capa=document.canalMsg0;} else {capa=document.all['canalMsg0'].style;}

	if (W1<(W+100)) {W1=W+100;}
	if (H1<(H+50)) {H1=H+50;}

	capa.width=W1;capa.height=H1;
	if (ns) {capa.clip.top=0;capa.clip.right=W1;capa.clip.bottom=H1;capa.clip.left=0;}
	else {capa.clip='rect(0px '+W1+'px '+H1+'px 0px)';}
	capa.visibility="visible";

	this.barrainc=0.2*160/this.servicios.ij(n,5);
	if (this.temporizador!=null) {clearInterval(this.temporizador);}
	this.temporizador=setInterval("canal.barra()",200);
	canal.barra();
	return true;
}

function CanalBarra() {
	this.barral+=this.barrainc;
	if (this.barral>=160 || this.f==2) {this.barral=160;}
	if (ns) {		
		document.canalMsg0.document.canalMsg1.document.canalMsg3.clip.right=this.barral;
		document.canalMsg0.document.canalMsg1.document.canalMsg4.document.open();
		document.canalMsg0.document.canalMsg1.document.canalMsg4.document.write("<SPAN ID=canalid>"+parseInt(this.barral/160*100)+"%</SPAN>");
		document.canalMsg0.document.canalMsg1.document.canalMsg4.document.close();
	}
	else {
		document.all['canalMsg3'].style.clip='rect(0px '+this.barral+'px 25px 0px)';
		document.all['canalMsg4'].innerHTML="<SPAN STYLE='font-size:10pt;font-family:helvetica;font-weight:bold'>"+parseInt(this.barral/160*100)+"%</SPAN>";
	}
	if (this.f==2) {
		this.f=3;
		if (this.temporizador!=null) {clearInterval(this.temporizador);}
		this.temporizador=setInterval("canal.barra()",200);
	}
	else if (this.f==3) {this.stop(this.descriptor);}
	else {if (this.barral>=160) {this.stop('');}}
}

function CanalOnLoad(descriptor) {if (canal.f==1) {canal.stop(descriptor);}}

function CanalStop(descriptor) {
	if (descriptor!='') {
		if (descriptor!=this.descriptor) {return;} // rechaza descriptores distintos del actual
		if (this.f==1) {this.f=2;return;}
		if (this.temporizador!=null) {clearInterval(this.temporizador);}
		datos2=new Array();datos2=this.canalFrame.CanalVueltaGetDatos();
		if (datos2==null) {this.datos=null;}
		else {
			this.datos=new Array();
			for(var i=0;i<datos2.length;i++) {
				if (datos2[i].length!=0) {
					this.datos[i]=new Array();
					for(var j=0;j<datos2[i].length;j++) {
						this.datos[i][j]=datos2[i][j];
					}
				}
				else {this.datos[i]=datos2[i];}
			}
		}
		this.codigo=this.canalFrame.CanalVueltaGetCodigo();
		this.mensaje=this.canalFrame.CanalVueltaGetMensaje();
		this.canalFrame.CanalVueltaCierra();
	}
	else {// timeout
		if (this.temporizador!=null) {clearInterval(this.temporizador);}
		this.codigo='TIMEOUT';
		this.mensaje='Fin del temporizador para conexión con el servidor';
		this.datos=null;
		this.canalFrame.close();
	}
	this.f=0;
	this.barral=0;
	this.barrainc=0;
	this.temporizador=null;
	if (ns) {document.canalMsg0.visibility='hide';document.canalMsg0.document.canalMsg1.document.canalMsg3.clip.right=0;}
	else {document.all['canalMsg0'].style.visibility='hidden';document.all['canalMsg3'].style.clip='rect(0px 0px 25px 0px)';}
	var n=this.servicios.buscar(this.descriptor,0);
	if (n==-1) {alert('Canal (): el descriptor indicado ('+descriptor+') no existe en este canal.'); return;}
	eval(this.servicios.ij(n,6));
}

function CanalGetDescriptor() {return this.descriptor;}
function CanalGetCodigo() {return this.codigo;}
function CanalGetMensaje() {return this.mensaje;}
function CanalGetDatos() {return this.datos;}
