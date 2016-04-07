/**
* Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 
 
/*
    INDRA/CAR/PROY
    $Id: i18NJS.js,v 1.1 2009/12/03 19:02:22 pecbazalar Exp $
    DESC
*/

function levantarI18N (frmnombre, index) {

	//Levanta un pop-up con el resultado de la invocación de LPMantenerI18N, le pasa como argumento la entidad 
	//que saca del hidden i18NEntidad, el oid de i18NOID y cargar de i18NCargar. 

  var oidsIdiomas = get(frmnombre+".hOidsIdiomas");
	var vWnd = -1;
	var parametros = new Object();
	var cargado = get(frmnombre+".hi18NCargado_"+index);
	
	//alert("cargado: " + cargado );
	//alert("bandera: " + get(frmnombre+".hBandera_"+index) );
	
	if (get(frmnombre+".hBandera_"+index)=="true")
	{
		parametros.Conservar = "true";
		set(frmnombre+".hBandera_"+index,"false")
	}
	var nombreCampoTraducible = get(frmnombre+".htxtNombre_"+index);
	parametros.hi18NidiomaActual = get(frmnombre+".hi18NidiomaActual");
	parametros.hSoloLectura = get(frmnombre+".hSoloLectura_"+index);

  var arrOids = oidsIdiomas.split("|");
	for (var i=0;i<(arrOids.length-1);i++)
	{
    
    eval('parametros.hi18NTraduccion_'+arrOids[i]+'=\"\"');

		if (arrOids[i]=="1")//(parametros.hi18NidiomaActual)
		{			
      parametros['hi18NTraduccion_'+arrOids[i]] = get(frmnombre+"."+nombreCampoTraducible);
			//alert(get(frmnombre+"."+nombreCampoTraducible));
		}
    else
    {
      parametros['hi18NTraduccion_'+arrOids[i]] = get(frmnombre+".hi18NTraduccion_"+index+"_"+arrOids[i]);
    }
	}
  parametros.textarea = obtenerTipo(nombreCampoTraducible);
  //alert("recarga"+cargado);
	//alert(get(frmnombre+".hOidsIdiomas"));
	  var myRand=parseInt(Math.random()*99999999); // cache buster
    vWnd = window.showModalDialog('sicc0000jg?ON=LPMantenerI18n&nroAtrib='+index+'&hi18NCargado='+cargado+'&cacheBuster='+myRand,parametros,'dialogWidth:480px;dialogHeight:500px;status:no;scroll:yes;help:no;resizable=no;');
	
	//setea los parametros de nuevo en las variables ocultas
	set(frmnombre+".hi18NCargado_"+index,"false");
	for (var i=0;i<(arrOids.length-1);i++)
	{
		set(frmnombre+".hi18NTraduccion_"+index+"_"+arrOids[i], eval('parametros.hi18NTraduccion_'+arrOids[i]));		
	}
}
function guardaI18N () {
  var oidsIdiomas = get("frmMantenimientoMultiidioma.hAllOidsIdiomas");
	var arrOids = oidsIdiomas.split("|");
	parametros = window.dialogArguments;
	var tmp;
  var strSalida = "";
  
	for(var i=0;i<(arrOids.length-1); i++)
	{
    /* Soporta TEXTAREA y detecta que componente es para actuar de acuerdo a eso.
       En el caso de ser un TEXTAREA guarda todo el contenido y en caso de ser un 
       CTEXTO e ingresarse mas de una linea se trunca el resto.
       */
       
		tmp = get("frmMantenimientoMultiidioma.txtTraduccion"+arrOids[i]);
    
    if (parametros.textarea){
      strSalida = tmp;
    } else {
      strSalida = tmp.split('\n')[0];
    }
		parametros['hi18NTraduccion_'+arrOids[i]]=strSalida;
	}
	parametros.Conservar="false";
	window.close();
}
function inicializaI18N () {
	//Si el hidden de la página cargar == false, accede a los hiddens (mediante window.opener) I18Ntraduccion_1... 
	//para establecer los CT de la página en base a lo que contengan.(Para Modo Consulta)
	parametros = window.dialogArguments;
  
  accion('frmMantenimientoMultiidioma.txtTraduccion1','.disabled=true');// 1 porque es el español
	//eval('set("frmMantenimientoMultiidioma.txtTraduccion'+parametros.hi18NidiomaActual+'",parametros.hi18NTraduccion_'+parametros.hi18NidiomaActual+')');//anterior	
	set("frmMantenimientoMultiidioma.txtTraduccion1",parametros.hi18NTraduccion_1);

	var oidsIdiomas = get("frmMantenimientoMultiidioma.hAllOidsIdiomas");	
	var arrOids = oidsIdiomas.split("|");

	if (parametros.hSoloLectura=="true")			
	{	
		document.all["btnAceptar"].style.visibility='hidden';
		for (var z=0;z<(arrOids.length-1);z++)
			{	//deshabilita todos los campos
				accion('frmMantenimientoMultiidioma.txtTraduccion'+arrOids[z],'.disabled=true');
			}
	}
/*	for(var k=0;k<(arrOids.length-1); k++) {
		eval('var a = parametros.hi18NTraduccion_'+arrOids[k]);
		alert(a);	
	}*/
	//si parametros tiene vacio meto lo que recupero de la BD y si no dejo lo que tiene
	var bandera="f";

	if (get('frmMantenimientoMultiidioma.hRecupera')=='false')
	{	for(var j=0;j<(arrOids.length-1); j++) {
			
			if (eval('parametros.hi18NTraduccion_'+arrOids[j]+'!=""'))
			{	
				bandera="t";
			}
		}
		if (bandera=='f')
		{
			for(var k=0;k<(arrOids.length-1); k++) {			
        parametros['hi18NTraduccion_'+arrOids[k]]=get("frmMantenimientoMultiidioma.txtTraduccion"+arrOids[k]);			
			}
		}
	}	
	
	if (parametros.Conservar=="true")
	{
		for(var k=0;k<(arrOids.length-1); k++) {		
      parametros['hi18NTraduccion_'+arrOids[k]]=get("frmMantenimientoMultiidioma.txtTraduccion"+arrOids[k]);
      //alert(get('frmMantenimientoMultiidioma.txtTraduccion'+arrOids[i]));
		}		
	}	

	if (get('frmMantenimientoMultiidioma.hRecupera')=='true'){
		
		for(var i=0;i<(arrOids.length-1); i++)
		{			
		  set("frmMantenimientoMultiidioma.txtTraduccion"+arrOids[i],parametros['hi18NTraduccion_'+arrOids[i]]);
			//alert(eval('parametros.hi18NTraduccion_'+arrOids[i]));
		}
	}
	if (arrOids.length-1>1)	{ 
		if (parametros.hSoloLectura!="true")
			if (arrOids[0]!="1")
			{
				focaliza('frmMantenimientoMultiidioma.txtTraduccion'+arrOids[0]);
			} else {	
				focaliza('frmMantenimientoMultiidioma.txtTraduccion'+arrOids[1]);
			}
	} else {
  	    document.body.onkeydown  = inhabilitaTab;
	}

}

function noSetearParametros(){
	/*	var oidsIdiomas = get("frmMantenimientoMultiidioma.hAllOidsIdiomas");	
	var arrOids = oidsIdiomas.split("|");
	for(var k=0;k<(arrOids.length-1); k++) {
		var a = eval('parametros.hi18NTraduccion_'+arrOids[k]);
		alert(a);	
	}*/
	parametros.Conservar="false";
	set('frmMantenimientoMultiidioma.hRecupera','true');
	window.close();	
}

function limpiaI18N(frmnombre, cantAtribs) {

	//necesito el nombre del formulario y cant atributos.
    var oidsIdiomas = get(frmnombre+".hOidsIdiomas");
    var arrOids = oidsIdiomas.split("|");
	//var cantAtribs = null;
	for (var i=0;i<(cantAtribs+1) ;i++ )
	{
			set(frmnombre+".hi18NCargado_"+i,"true");
			
			set(frmnombre+".hBandera_"+i,"true") //rgiorgi 15/3/2004. Incidencia de pérdida de datos luego de limpiar.
			
			//alert(frmnombre+".hi18NCargado_"+i);
			//set(frmnombre+".hOid_"+i,"");
			for (var j=0;j<(arrOids.length-1); j++)
			{
				set(frmnombre+".hi18NTraduccion_"+i+"_"+arrOids[j],"");
			}
	}
}

function obtenerTipo(strNombre){
  var obj = document.body.all[strNombre];
  if(obj.length && (typeof(obj)).toUpperCase()=="OBJECT"){
    for(var i=0;i<obj.length;i++){
      if(obj[i].tagName && obj[i].tagName.toUpperCase()=="TEXTAREA"){
        return true;
      }
    }  
  }else{
    if(obj.tagName && obj.tagName.toUpperCase()=="TEXTAREA"){
      return true;
    }
  }
  return false;
}
