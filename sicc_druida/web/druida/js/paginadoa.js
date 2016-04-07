/********************************** 
	paginadoa.js
	Funciones JavaScript asociadas a la clase PaginadoA (PaginadoA.java)
	06/03/2001
	DRUIDA 1.1
**********************************/
function PaginadoA(nombre,descriptores) {
	this.nombre=nombre;
	this.botonI=eval(nombre+'botonI');
	this.botonF=eval(nombre+'botonF');
	this.botonR=eval(nombre+'botonR');
	this.botonA=eval(nombre+'botonA');
	this.botonRN=eval(nombre+'botonRN');
	this.botonAN=eval(nombre+'botonAN');
	this.descriptores=new Vector();
	this.descriptores.cargar(descriptores);
	this.descriptor=this.descriptores.ij(0,0);	 // descriptor activo de entre la lista
	this.entrada=this.descriptores.ij(0,1);
	this.accion=this.descriptores.ij(0,2);
	this.total_pag=0;
	this.n_pag=0;
	this.salto=5;

	this.display=PaginadoAdisplay;
	this.go=PaginadoAgo;
	this.avanzar=PaginadoAavanzar;
	this.retroceder=PaginadoAretroceder;
	this.setDescriptor=PaginadoAsetDescriptor;
	this.setClaves=PaginadoAsetClaves;
}

function PaginadoAdisplay(arg) {
	datos=new Vector();
	if (arg==null) {
		if (canal.getCodigo()=='TIMEOUT') {alert(canal.getMensaje());return;}
		if (canal.getCodigo()!='0') {alert(canal.getMensaje());return;}
		datos.cargar(canal.getDatos());
	}
	else {datos.cargar(arg);}
	datos.ij2(datos.ij(0,0).split('|'),0);
	this.n_pag=datos.ij(0,0)*1;
	this.total_pag=datos.ij(0,1)*1;
	this.salto=parseInt(this.total_pag/10); if (isNaN(this.salto) || this.salto<5) {this.salto=5;}
	if (this.n_pag==1) {this.botonI.setTipo(0);this.botonR.setTipo(0);} else {this.botonI.setTipo(-2);this.botonR.setTipo(-2);}
	if (this.n_pag-this.salto<1) {this.botonRN.setTipo(0);} else {this.botonRN.setTipo(-2);}
	if (this.n_pag+this.salto>this.total_pag) {this.botonAN.setTipo(0);} else {this.botonAN.setTipo(-2);}
	if (this.n_pag==this.total_pag) {this.botonF.setTipo(0);this.botonA.setTipo(0);} else {this.botonF.setTipo(-2);this.botonA.setTipo(-2);}
	datos.eliminar(0);
	set(this.nombre+'Form.n_pag0',this.n_pag);
	txt_to(this.nombre+'totalpag',this.total_pag);
	eval(this.accion);
}

function PaginadoAavanzar(n) {this.go(this.n_pag+n);}
function PaginadoAretroceder(n) {this.go(this.n_pag-n);}
function PaginadoAgo(n) {
	if (!n && n!=0) {n=this.entrada[0];}
	n=parseInt(n);
	if (isNaN(n)) {set(this.nombre+'Form.n_pag0',this.n_pag);return;}
	if (n<0) {n=1;}
	if (n>this.total_pag) {n=this.total_pag;}
	set(this.nombre+'Form.n_pag',n);
	set(this.nombre+'Form.lineas',this.entrada[1]);
	for(var i=2;i<this.entrada.length;i++) {set(this.nombre+'Form.clave'+(i-2),this.entrada[i]);}
	canal.run(this.descriptor);
}

function PaginadoAsetDescriptor(descriptor) {
	var i=this.descriptores.buscar(descriptor,0);
	if (i==-1) {alert('PaginadoA.setDescriptor('+descriptor+'): descriptor inexistente.');return;}
	this.descriptor=this.descriptores.ij(i,0);
	this.entrada=this.descriptores.ij(i,1);
	this.accion=this.descriptores.ij(i,2);
	this.n_pag=this.entrada[0];
	this.total_pag=this.entrada[0];
	this.salto=5;
}

function PaginadoAsetClaves(claves) {for(var i=2;i<this.entrada.length;i++) {this.entrada[i]=claves[i-2];}}
