function nuevaFila(){
		var fil = new Array();
		fil[0]=" ";
		fil[1]=" ";
		listado1.datos[listado1.datos.length] = fil;
		listado1.setDatos(listado1.datos);
		//var tabla=document.getElementById("tblDatlistado1");
		//var tr=tabla.getElementsByTagName("tr")
		//alert(tabla.outerHTML);
	}
	function manejarPestanas(){
		
		var name=window.event.srcElement.getAttribute("ID");
		var div=document.getElementById(name);
		div.style.setAttribute("backgroundColor","#496A9A");
		div.style.setAttribute("color","#FFFFFF");
	}

	function manejarPestanas2(){
		
		var name=window.event.srcElement.getAttribute("ID");
		var div=document.getElementById(name);
		div.style.setAttribute("backgroundColor","#F0F0F0");
		div.style.setAttribute("color","#496A9A");
	}

//Devuelve el numero de indice	
function cadenamenos(cadena,carac){
		var cad =new String(cadena);
		var largo=cad.length;
		var index=0;
		
		for(var i=largo;cad.charAt(i)!=carac;i--){
			index=i;
		}
		
		comp=cad.substring(Math.abs(index),largo);
		
		//alert(cadena);
		return comp;
		
	}
/****************************************************************/
//-------------------------------------------------------------------------------------------------------------------	
function recargarValores(valores){
	//var valores = get(formName + ".elementosP1");
	var componenteValorArray = valores.split(";");
	for(var z=0;z<componenteValorArray.length-1;z++){
		var temparray = componenteValorArray[z].split("=");
		var componenteName = temparray[0];		
		var componenteValue = temparray[1];		
		var componente = document.getElementById(componenteName);
		//alert(componenteName + " = " + componenteValue );
		if(componente.type=="text"||componente.type=="textarea"){
			componente.value = componenteValue;
		}else if(componente.type=="radio"||componente.type=="checkbox"){
			componente.checked = componenteValue;
		}else if(componente.type=="select-one"||componente.type=="select-multiple"){
			componente.value = componenteValue;
		}else{
			componente.value = componenteValue;
		}
	}
}
//-------------------------------------------------------------------------------------------------------------------	
function recolectarValores(){
	var result = new String();
	result = recolectarValoresTexto();
	result = result + recolectarValoresRadio();
	result = result + recolectarValoresCombo();
	result = result + recolectarValoresTextArea();
	return result;
}
//------------------------------------------------------------------------------------------------------------------
function recolectarValoresCombo(){
	var result = new String();
	var combos = document.all.tags("SELECT");
	for(var x=0;x<combos.length;x++){
		if(combos.item(x).value!="-1"){
			result = result  + combos.item(x).name + "=" + combos.item(x).value + ";";
		}
	}
	return result;	
}
//------------------------------------------------------------------------------------------------------------------
function recolectarValoresTexto(){
	var result = new String();
	var textos = document.all.tags("INPUT");
	for(var x=0;x<textos.length;x++){
		if(textos.item(x).type =="text"&&textos.item(x).value!=""){
			result = result  + textos.item(x).name + "=" + textos.item(x).value + ";";
		}
	}
	return result;	
}
//------------------------------------------------------------------------------------------------------------------
function recolectarValoresRadio(){
	var result = new String();
	var textos = document.all.tags("INPUT");
	for(var x=0;x<textos.length;x++){
		if((textos.item(x).type =="radio"||textos.item(x).type =="checkbox")&&textos.item(x).checked==true){
			result = result  + textos.item(x).name + "=" + textos.item(x).checked + ";";
		}
	}
	return result;	
}

//------------------------------------------------------------------------------------------------------------------
function recolectarValoresTextArea(){
	var result = new String();
	var textos = document.all.tags("TEXTAREA");
	for(var x=0;x<textos.length;x++){
	//	alert(textos.item(x).name );
		if(textos.item(x).value!=""){
			result = result  + textos.item(x).name + "=" + textos.item(x).value + ";";
		}
	}

	return result;	
}
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------	
function recolectarValoresLista(lista){
	var result = new String();

	if(lista!=null){
		result = recolectarValoresTextoLista(lista);
		result = result + recolectarValoresRadioLista(lista);
		result = result + recolectarValoresComboLista(lista);
		result = result + recolectarValoresTextAreaLista(lista);
	}else{
		result = "";
	} 
	return result
}
//------------------------------------------------------------------------------------------------------------------
function recolectarValoresComboLista(lista){
	var result = new String();
	var combos = lista.all.tags("SELECT");
	for(var x=0;x<combos.length;x++){
		if(combos.item(x).value!="-1"){
			result = result  + combos.item(x).name + "=" + combos.item(x).value + ";";
		}
	}
	return result;	
}
//------------------------------------------------------------------------------------------------------------------
function recolectarValoresTextoLista(lista){
	var result = new String();
	var textos = lista.all.tags("INPUT");
	for(var x=0;x<textos.length;x++){
		if(textos.item(x).type =="text"&&textos.item(x).value!=""){
			result = result  + textos.item(x).name + "=" + textos.item(x).value + ";";
		}
	}
	return result;	
}
//------------------------------------------------------------------------------------------------------------------
function recolectarValoresRadioLista(lista){
	var result = new String();
	var textos = lista.all.tags("INPUT");
	for(var x=0;x<textos.length;x++){
		if((textos.item(x).type =="radio"||textos.item(x).type =="checkbox")&&textos.item(x).checked==true){
			result = result  + textos.item(x).name + "=" + textos.item(x).checked + ";";
		}
	}
	return result;	
}
//------------------------------------------------------------------------------------------------------------------
function recolectarValoresTextAreaLista(lista){
	var result = new String();
	var textos = lista.all.tags("TEXTAREA");
	for(var x=0;x<textos.length;x++){
	//	alert(textos.item(x).name );
		result = result  + textos.item(x).name + "=" + textos.item(x).value + ";";
	}

	return result;	
}
//---------------------------------------------------------------------------------------------------