/**
* Copyright 2006 © por INDRA SI S.A Todos los derechos reservados.
* Dirección
* 
* Privado y Confidencial.
* La información contenida en este documento es propiedad de INDRA SI S.A.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
* Desarrollado por: Indra Sistemas, S.A
* Nombre de Proyecto:  Belcorp - SICC
* @author adiaz
*/

	function manejarPestanyaIn(){
		var name=window.event.srcElement.getAttribute("ID");
		var div=document.getElementById(name);
		div.style.setAttribute("backgroundColor","#496A9A");
		div.style.setAttribute("color","#FFFFFF");
	}

	function manejarPestanyaOut(){
		
		var name=window.event.srcElement.getAttribute("ID");
		var div=document.getElementById(name);
		div.style.setAttribute("backgroundColor","#F0F0F0");
		div.style.setAttribute("color","#496A9A");
	}
    
  /**
   * @author  adiaz
   * @date    02/11/2005
   * @description construido segun modelo: DMCO-DTO-BELC300014763
   * @throws MareException
   */
  function getComboSeleccionado(combo) {
		var i;
		var strV = new String(get(combo));
		var sArrayV ;
		var vValores='';
		if (strV != '')	{
			if(strV.length > 0 )
				sArrayV = strV.split(',');
			
			for (i = 0; i < sArrayV.length; i++) {
				vValores = vValores + cdos_trim(sArrayV[i]) + '|';
      }
		}
		return vValores;
	}

  function marcaSeleccionDelUsuario(pControl, datos) {
		datos = datos.split(",");
		var comb = pControl;
		set(comb, datos);
	}

  function guardoConExito() {
		var strFormName = getFormularioSICC();
		if (get(strFormName+".hExito")=="S") {
			GestionarMensaje('UIDTO7012');
			set(strFormName+".accion", "descuentoDefinido");
			set(strFormName+".conectorAction", "LPOrdenacionDTO");
			enviaSICC(strFormName);
		} else if (get(strFormName+".hExito")=="M") {
			window.close();
		}
	}


	function poneManito(nombre) {          
		  var nombre = document.getElementById(nombre);
		  nombre.style.cursor = "hand";
	}
