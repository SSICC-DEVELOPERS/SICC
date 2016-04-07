
       
function validaMovimiento(pestActual,pestanyaDestino){
        pestActual++;
        
        //Si estoy navegando hacia adelante, lo hago solo de a una
        if( (pestActual < pestanyaDestino) && (pestActual!=''))
        {
            alert ('ERROR de Navegacion');
            return false;
        }
        
        return true;
    }

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

	function comboToStr( campo ) {
		var l = combo_get( campo, 'L' );
		var arrai = new Array();
		var datos = '';
		for ( var i = 0;i < l;i++ ) {
			datos += cdos_trim(combo_get( campo, 'V', i )) + '|';
		}
		return datos;
	}

	function getComboSeleccionado( combo)
	{
		var i;
		var strV = new String(get(combo));
		var sArrayV ;
		var vValores='';
		if (strV != '')
		{
			if(strV.length > 0 )
				sArrayV = strV.split(',');
			
			for (i = 0; i < sArrayV.length; i++)
				vValores = vValores + cdos_trim(sArrayV[i]) + '|';
		}
		return vValores;
	}
	
	function marcaSeleccionDelUsuario(pControl, datos)
	{
		datos = datos.split(",");
		var comb = pControl;
		set(comb, datos);
	}
