// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function miSplice(arr, pos){
	var newArray = new Array();
	var j=0;
	for (var i=0;i<arr.length;i++){
		if (pos!=i)	{			
			newArray[j] = arr[i];
			j++;
		}
	}
	return newArray;
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function nuevoOidRangoFlete(){

	if(dtoFlete.rangosFlete!=null&&dtoFlete.rangosFlete.length!=null) {
		var lonRanFle = dtoFlete.rangosFlete.length;
		var oidRanFle = new Number(1);
		for (var i=0;i<lonRanFle;i++) {
			var oidRangoFleteDTO = new Number(dtoFlete.rangosFlete[i].oidRangoFlete);
			if (oidRangoFleteDTO>oidRanFle) {				
				oidRanFle = oidRangoFleteDTO;
			}
		}
		oidRanFle = oidRanFle + 1;
		return oidRanFle;
	} else {
		return new Number(1);
	}

}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function agregarRangoFlete(dtoRangoFlete, posicion){

	if (posicion==null)
	{
		if(dtoFlete.rangosFlete!=null&&dtoFlete.rangosFlete.length!=null){
			posicion = dtoFlete.rangosFlete.length;
		} else {
			posicion = 0;
			dtoFlete.rangosFlete = new Array();			
		}
		dtoFlete.rangosFlete[posicion]= new Object();
	}
	
	if (setear(dtoRangoFlete.oidRangoFlete))
	{	dtoFlete.rangosFlete[posicion].oidRangoFlete = dtoRangoFlete.oidRangoFlete;
	}
	if (setear(dtoRangoFlete.rangoInf))
	{	dtoFlete.rangosFlete[posicion].rangoInf = dtoRangoFlete.rangoInf;
	}
	if (setear(dtoRangoFlete.rangoSup))
	{	dtoFlete.rangosFlete[posicion].rangoSup = dtoRangoFlete.rangoSup;
	}
	if (setear(dtoRangoFlete.montoFij))
	{	dtoFlete.rangosFlete[posicion].montoFij = dtoRangoFlete.montoFij;
	}
	if (setear(dtoRangoFlete.oidFlete))
	{	dtoFlete.rangosFlete[posicion].oidFlete = dtoRangoFlete.oidFlete;
	}
	if (setear(dtoRangoFlete.modificado))
	{	dtoFlete.rangosFlete[posicion].modificado = dtoRangoFlete.modificado;
	}
	if (setear(dtoRangoFlete.guardado))
	{	dtoFlete.rangosFlete[posicion].guardado = dtoRangoFlete.guardado;
	}
	if (setear(dtoRangoFlete.aEliminar))
	{	dtoFlete.rangosFlete[posicion].aEliminar = dtoRangoFlete.aEliminar;
	}
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function setear(x){
	if (x!=null)	{	
		return true;
	} else {
		return false;
	}
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function superponeRangoFlete(dtoRangoFlete){

	if(dtoFlete.rangosFlete!=null&&dtoFlete.rangosFlete.length!=null) {
		var lonRanFle = dtoFlete.rangosFlete.length;
		for (var i=0;i<lonRanFle;i++) {
			if (dtoFlete.rangosFlete[i].aEliminar!='si') {
				if (superponeEsteRangoFlete(dtoFlete.rangosFlete[i], dtoRangoFlete)) {
					return true;
				}
			}	
		}
	} else {
		return false;
	}
}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function superponeEsteRangoFlete(dtoRangoFlete1,dtoRangoFlete2){

	if((dtoRangoFlete1.oidFlete==dtoRangoFlete2.oidFlete) && ((numeroDeFormatoSICC(dtoRangoFlete1.rangoInf)<=numeroDeFormatoSICC(dtoRangoFlete2.rangoInf)) && (numeroDeFormatoSICC(dtoRangoFlete1.rangoSup)>=numeroDeFormatoSICC(dtoRangoFlete2.rangoInf)) ||
	   (numeroDeFormatoSICC(dtoRangoFlete1.rangoInf)<=numeroDeFormatoSICC(dtoRangoFlete2.rangoSup)) && (numeroDeFormatoSICC(dtoRangoFlete1.rangoSup)>=numeroDeFormatoSICC(dtoRangoFlete2.rangoSup)) ||
	   (numeroDeFormatoSICC(dtoRangoFlete1.rangoInf)>=numeroDeFormatoSICC(dtoRangoFlete2.rangoInf)) && (numeroDeFormatoSICC(dtoRangoFlete1.rangoSup)<=numeroDeFormatoSICC(dtoRangoFlete2.rangoSup)))) {
		return true;
	} else {
		return false;
	}

}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function serializarRangosFlete(){
	var toAdd = "";

	if(dtoFlete.rangosFlete!=null&&dtoFlete.rangosFlete.length!=null) {
		for (var i=0;i<dtoFlete.rangosFlete.length;i++) {
			if (dtoFlete.rangosFlete[i].aEliminar!='si'){
				toAdd = toAdd + "oidRangoFlete¿" + dtoFlete.rangosFlete[i].oidRangoFlete;
				toAdd = toAdd + "&" + "rangoInf¿" + dtoFlete.rangosFlete[i].rangoInf;
				toAdd = toAdd + "&" + "rangoSup¿" + dtoFlete.rangosFlete[i].rangoSup;
				toAdd = toAdd + "&" + "montoFij¿" + dtoFlete.rangosFlete[i].montoFij;
				toAdd = toAdd + "&" + "oidFlete¿" + dtoFlete.rangosFlete[i].oidFlete;
				toAdd = toAdd + "#";//separador de rangos de flete
			}
		}
	}
	return toAdd;
}