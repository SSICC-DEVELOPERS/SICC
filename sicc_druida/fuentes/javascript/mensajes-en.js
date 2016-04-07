function GestionarMensaje(codigo, arg1, arg2, arg3) {
          campo_obligatorio = "Debe introducir un valor para ";
  switch (codigo + "") {
		//Mensaje de internacionalozaci�n
		case 'MMGGlobal.localzation.windowtitle': return "Internacionalizaci�n";
		case 'MMGGlobal.localzation.nolanguage.message': return "Debe seleccionar un idioma";
		case 'MMGGlobal.localzation.nodescription.message': return "Tam�o de descripcion ivalido ";
		case 'MMGGlobal.localzation.languagedescriptionexits.message': return "Existe descripci�n para el idioma seleccionado";
		case 'MMGGlobal.localzation.descriptionsingleselection.message': return "Seleccione una �nica descripci�n";
		case 'MMGGlobal.localzation.defalutlanguagevalue.message': return "Debe dar valor al menos al idioma por defecto";
		case 'MMGGlobal.update.lostchanges.message': return "�Desea guardar los cambios efectuados?";
		case 'MMGGlobal.remove.confirmation.message': return "�Desea realmente eliminar los registros seleccionados?";		
		   

		//Jrivas Agregados para validacion de ValidaNumeroMMG
		case 'CarCondiEvaluNr.valMini': return "Valor m�nimo";
		case 'CarCondiEvaluNr.valMaxi': return "Valor m�ximo";
		case 'CarCondiEvaluNr.valEscaMini': return "Escala m�nima";
		case 'CarJerar.valPorcLineCred': return "Exceso l�nea cr�dito";
		case 'CarJerar.valPorcMontMaxi': return "Exceso monto m�ximo";
		case 'CarParamCalcuLc.valTope': return "Valor tope";
		case 'CarParamCalcuLc.valFactCalc': return "Factor c�lculo";
		case 'CarParamEvaluNr.valPeso': return "Peso";
		case 'PedTasaImpue.valTasaImpu': return "Tasa impuestos";
		case 'SegPais.valPorcAlar': return "Porcentaje alarma";
		case 'SegPais.numLimiDifePago': return "L�mite diferencia pago";
		case 'SegPais.valMaxiDifeAnlsComb': return "M�xima diferencia an�lisis combinatorio";
		case 'SegTipoCambi.valTipoCamb': return "Tipo cambio";
		case 'ZonEstadZona.impoVentMini': return "Importe m�nimo venta";
		case 'ZonEstadZona.valoTiemMini': return "Tiempo m�nimo";
		case 'BelParamBelce.valMontMaxiDife': return "XXXXXXXX";
		case 'BelParamBelce.valLimiEfecCaja': return "XXXXXXXX";
		case 'BelParamBelce.valFactLoca': return "XXXXXXXX";

		// SPLATAS - DBLG500000827 - 16/06/2006
		case 'PedUmbraFalta.valUmbrFalt': return "\'\'Umbral faltantes\'\'";

		case 'CobEscalLiqui.valRangHastPorc': return "Rango hasta %";
		case 'CobEscalLiqui.valRangDesdPorc': return "Rango Desde %";

		/*
		 * Las claves siguientes originales eran incorrectas y fueron modificadas
		 * por las existentes debajo de este comentario. Este cambio fue detectado
		 * por pruebas y tratado como la incidencia DBLG500000832. La modificaci�n
		 * se realiz� en los 4 archivos de idiomas (mensajes-en.js, mensajes-es.js,
		 * mensajes-fr.js y mensajes-pt.js).
		 * Original: case 'CobEscalLiqui.inpComiPorc': return "Comisi�n %";
		 * Original: case 'CobEscalLiqui.inpComiImpo': return "Comisi�n Importe";
		 */
		case 'CobEscalLiqui.impComiPorc': return "Comisi�n %";
		case 'CobEscalLiqui.impComiImpo': return "Comisi�n Importe";
		
		case 'CobEscalLiqui.impRangDesdImpo': return "Rango Desde Importe";
		case 'CobEscalLiqui.impRangHastImpo': return "Rango Hasta Importe";
		case 'CobEtapaDeuda.impDesd': return "Importe desde";
		case 'CobEtapaDeuda.impHast': return "Importe hasta";
		case 'CobEtapaDeuda.valPorcIncu': return "% incumplidas";
		case 'ComConge.impCong': return "Importe";
		case 'MaeProdu.valCostEstd': return "Coste estandar";
		case 'MaeProdu.valPrecPosi': return "Precio de posicionamiento";
		case 'MaeProdu.valPrecCata': return "Predio de cat�logo";
		case 'MaeProdu.valPrecCont': return "Precio contable";
		case 'RecAutor.impMaxi': return "Importe m�ximo";
		case 'RecAutor.impMontMaxiDife': return "Importe m�nimo";
		case 'RecParamNmper.valPorcReca': return "Porcentaje de recargo";
		case 'FacTipoOfertExclu.fecDesd': return "Fecha desde";
		case 'FacTipoOfertExclu.fecHast': return "Fecha hasta";

		
		
		
		//Mensajes query
		case 'MMGGlobal.query.noresults.message': return "No existen registros que cumplan con los criterios de b�squeda.";
		
		//Mensajes remove
		case 'MMGGlobal.remove.noselection.message': return "No ha seleccionado ning�n elemento para eliminar";
		
		//Mensajes update
		case 'MMGGlobal.update.noselection.message': return "No ha seleccionado ning�n elemento para modificar";		
		
		//Mensajes view
		case 'MMGGlobal.view.singleselection.message': return "Debe seleccionar un �nico elemento de la lista";		
		
		//Valores si/no para checkboxes
		case 'MMGGlobal.checkbox.yes.message': return "S�";
		case 'MMGGlobal.checkbox.no.message': return "No";


				//Valores si/no para radioButtons
		case 'MMGGlobal.radioButton.yes.message': return "S�";
		case 'MMGGlobal.radioButton.no.message': return "No";



		case 'AppRutasTrans.label': return "AppRutasTranss";
		
		case 'AppRutasTrans.paisOidPais.requiered.message': return "El campo \'\'P�is\'\' es obligatorio";
		case 'AppRutasTrans.codRuta.requiered.message': return "El campo \'\'C�d Ruta\'\' es obligatorio";
		case 'AppRutasTrans.numSecu.requiered.message': return "El campo \'\'Num. Secuencia\'\' es obligatorio";
		case 'AppRutasTrans.Descripcion.requiered.message': return "El campo \'\'Descripcion\'\' es obligatorio";
		case 'BelAlmac.label': return "BelAlmacs";
		
		case 'BelAlmac.paisOidPais.requiered.message': return "El campo \'\'P�is\'\' es obligatorio";
		case 'BelAlmac.codAlma.requiered.message': return "El campo \'\'C�d. Almac�n\'\' es obligatorio";
		case 'BelAlmac.indInfoSap.requiered.message': return "El campo \'\'Informar SAP\'\' es obligatorio";
		case 'BelAlmac.indInfoSap.1.value': return "Si";
		case 'BelAlmac.indInfoSap.0.value': return "No";
		case 'BelAlmac.Descripcion.requiered.message': return "El campo \'\'Descripcion\'\' es obligatorio";
		
		case 'BelCaja.label': return "Cajas";		
		case 'BelCaja.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'BelCaja.sbacOidSbac.requiered.message': return "El campo \'\'Subacceso\'\' es obligatorio";
		case 'BelCaja.codCaja.requiered.message': return "El campo \'\'C�d. Caja\'\' es obligatorio";
		case 'BelCaja.userOidUser.requiered.message': return "El campo \'\'Responsable cierre de caja\'\' es obligatorio";
		case 'BelCaja.ticjOidTipoCaja.N.value': return "Normal";
		case 'BelCaja.ticjOidTipoCaja.P.value': return "Principal";
		case 'BelCaja.ticjOidTipoCaja.F.value': return "Caja Fuerte";
						
		case 'BelContrAlmac.label': return "Controles de Almacen";		
		case 'BelContrAlmac.sbacOidSbac.requiered.message': return "El campo \'\'Subacceso\'\' es obligatorio";
		case 'BelContrAlmac.prodOidProd.requiered.message': return "El campo \'\'Producto\'\' es obligatorio";
		case 'BelContrAlmac.almcOidAlma.requiered.message': return "El campo \'\'Almac�n\'\' es obligatorio";

		// splatas - 05/10/2005
		case 'BelContrAlmac.valStocMinivalStocMaxi.message': return "\'\'valStocMini\'\' debe ser menor que \'\'valStocMaxi\'\'";
		case 'BelContrAlmac.valStocRepovalStocMaxi.message': return "\'\'valStocRepo\'\' debe ser menor o igual que \'\'valStocMaxi\'\'";

		case 'BelEstadMerca.label': return "Estados de la mercanc�a";		
		case 'BelEstadMerca.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'BelEstadMerca.codEsta.requiered.message': return "El campo \'\'C�d. estado\'\' es obligatorio";
		case 'BelEstadMerca.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		
		case 'BelFormaPago.label': return "BelFormaPagos";
		
		case 'BelFormaPago.codFormPago.requiered.message': return "El campo \'\'C�d. forma pago\'\' es obligatorio";
		case 'BelFormaPago.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'BelFormaPago.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'BelFormaPagoTapon.label': return "BelFormaPagoTapons";
		
		case 'BelFormaPagoTapon.codFormPago.requiered.message': return "El Campo \'\'C�d. forma pago\'\' es obligatorio";
		case 'BelFormaPagoTapon.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";

		case 'BelMedioPago.codMediPago.requiered.message': return "El Campo \'\'C�digo\'\' es obligatorio";
		case 'BelMedioPago.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'BelMedioPago.tmepOidTipoMediPago.requiered.message': return "El Campo \'\'Tipo medio pago\'\' es obligatorio";

		case 'BelParamBelce.label': return "Par�metros Belcenters";		
		case 'BelParamBelce.sbacOidSbac.requiered.message': return "El campo \'\'Subacceso\'\' es obligatorio";
		case 'BelParamBelce.valDire.requiered.message': return "El campo \'\'Direcci�n\'\' es obligatorio";
		case 'BelParamBelce.valMontMaxiDife.requiered.message': return "El campo \'\'Monto m�ximo de diferencia\'\' es obligatorio";
		case 'BelParamBelce.valLimiEfecCaja.requiered.message': return "El campo \'\'L�mite efectivo caja\'\' es obligatorio";
		case 'BelParamBelce.numCaja.requiered.message': return "El campo \'\'N�mero de cajas\'\' es obligatorio";
		case 'BelParamBelce.valNombLoca.requiered.message': return "El campo \'\'Nombre de local\'\' es obligatorio";
		case 'BelParamBelce.valTiempRepo.requiered.message': return "El campo \'\'Tiempo de reposici�n\'\' es obligatorio";
		case 'BelParamBelce.valFactLoca.requiered.message': return "El campo \'\'Fiempo de reposici�n\'\' es obligatorio";
		case 'BelParamBelce.numMaxiProd.requiered.message': return "El campo \'\'N�mero m�ximo de productos\'\' es obligatorio";
		case 'BelParamBelce.valAlerStoc.requiered.message': return "El campo \'\'Alerta de stock\'\' es obligatorio";
		case 'BelParamBelce.valUsua.requiered.message': return "El campo \'\'Usuario\'\' es obligatorio";
		case 'BelParamBelce.clieOidClie.requiered.message': return "El campo \'\'Cliente\'\' es obligatorio";
		case 'BelParamBelce.sociOidSoci.requiered.message': return "El campo \'\'Sociedad\'\' es obligatorio";
		case 'BelParamBelce.ttraOidTipoTran.requiered.message': return "El campo \'\'Tipo de transacci�n\'\' es obligatorio";
		case 'BelParamBelce.ccbaOidCuenCorrBanc.requiered.message': return "El campo \'\'Cuenta corriente\'\' es obligatorio";
		case 'BelParamBelce.tmvcOidCobr.requiered.message': return "El campo \'\'Tipo de movimiento cobrar\'\' es obligatorio";
		case 'BelParamBelce.tmvcOidCier.requiered.message': return "El campo \'\'Tipo de movimiento cierre\'\' es obligatorio";
		case 'BelParamBelce.tmalOidConfStoc.requiered.message': return "El campo \'\'Movimiento confirmar stock\'\' es obligatorio";
		case 'BelParamBelce.tmalOidConfStocTran.requiered.message': return "El campo \'\'Movimiento confirmar stock en tr�nsito\'\' es obligatorio";
		case 'BelParamBelce.tmalOidStocTran.requiered.message': return "El campo \'\'Movimiento Stock en tr�nsito\'\' es obligatorio";
		case 'BelParamBelce.tmalOidStocDevo.requiered.message': return "El campo \'\'Movimiento stock devoluci�n\'\' es obligatorio";
		case 'BelParamBelce.tmalOidRegu.requiered.message': return "El campo \'\'Movimiento regularizaci�n\'\' es obligatorio";
		case 'BelParamBelce.tmalOidReguSap.requiered.message': return "El campo \'\'Movimiento regularizaci�n SAP\'\' es obligatorio";
		case 'BelParamBelce.tmalOidDevoStoc.requiered.message': return "El campo \'\'Movimiento devolver stock de existencias\'\' es obligatorio";
		case 'BelParamBelce.tmalOidPetiExis.requiered.message': return "El campo \'\'Movimiento petici�n de existencias\'\' es obligatorio";
		case 'BelParamBelce.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		
		case 'BelTipoCaja.label': return "Tipos de Cajas";		
		case 'BelTipoCaja.codTipoCaja.requiered.message': return "El campo \'\'C�d. Tipo de Caja\'\' es obligatorio";
		case 'BelTipoCaja.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'BelTipoMovimAlmac.label': return "Tipo Movimiento Almacenes";		
		case 'BelTipoMovimAlmac.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'BelTipoMovimAlmac.codTipoMovi.requiered.message': return "El campo \'\'C�d. Tipo de Movimiento\'\' es obligatorio";
		case 'BelTipoMovimAlmac.indMoviEntrAlma.requiered.message': return "El campo \'\'Movimiento entre almacenes\'\' es obligatorio";
		case 'BelTipoMovimAlmac.indMantMovi.requiered.message': return "El campo \'\'Mantiene movimientos\'\' es obligatorio";
		case 'BelTipoMovimAlmac.indSap.requiered.message': return "El campo \'\'Indicador Sap\'\' es obligatorio";


		case 'BelTipoMovimCaja.label': return "Tipo de Movimiento de Cajas";		
		case 'BelTipoMovimCaja.codCaja.requiered.message': return "El campo \'\'C�d. Caja\'\' es obligatorio";
		case 'BelTipoMovimCaja.desTipoMoviCaja.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'BelTipoMovimCaja.valSign.requiered.message': return "El campo \'\'Signo\'\' es obligatorio";
		case 'BelTipoMovimCaja.valSign.+.value': return "+";
		case 'BelTipoMovimCaja.valSign.-.value': return "-";
		case 'BelTipoMovimCaja.valSign.+-.value': return "+-";
		case 'BelTipoMovimCaja.indAuto.requiered.message': return "El campo \'\'Indicador M/A\'\' es obligatorio";
		case 'BelTipoMovimCaja.indAuto.M.value': return "Manual";
		case 'BelTipoMovimCaja.indAuto.A.value': return "Automatico";

		case 'CalAtribEstadConta.label': return "Atributos Estado Contactos";		
		case 'CalAtribEstadConta.codAtri.requiered.message': return "El campo \'\'C�d. Atributo\'\' es obligatorio";
		case 'CalAtribEstadConta.tecoOidTipoEstaCont.requiered.message': return "El campo \'\'Tipo Estado Contacto\'\' es obligatorio";
		case 'CalAtribEstadConta.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'CalGuias.label': return "Guias";		
		case 'CalGuias.codGuia.requiered.message': return "El campo \'\'C�d. Guia\'\' es obligatorio";
		case 'CalGuias.valTitu.requiered.message': return "El campo \'\'T�tulo de gu�a\'\' es obligatorio";
		case 'CalGuias.fecInicVali.requiered.message': return "El campo \'\'Fecha inicio validez\'\' es obligatorio";
		case 'CalGuias.fecFinVali.requiered.message': return "El campo \'\'Fecha fin validez\'\' es obligatorio";
		case 'CalGuias.valDescGuia.requiered.message': return "El campo \'\'Descripci�n de gu�a\'\' es obligatorio";
		case 'CalGuias.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'CalGuias.dpteOidDepa.requiered.message': return "El campo \'\'Departamento responsable\'\' es obligatorio";
		case 'CalGuias.fecFinValifecInicVali.message': return "\'\'Fecha fin validez\'\' debe ser mayor o igual que \'\'Fecha inicio validez\'\'";

		case 'CalMotivConta.label': return "Motivos de Contactos";		
		case 'CalMotivConta.codMoti.requiered.message': return "El campo \'\'C�d. Motivo\'\' es obligatorio";
		case 'CalMotivConta.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'CalMotivTipoClien.label': return "Motivos contacto por tipo cliente";		
		case 'CalMotivTipoClien.ticlOidTipoClie.requiered.message': return "El campo \'\'Tipo cliente\'\' es obligatorio";
		case 'CalMotivTipoClien.mocoOidMotiCont.requiered.message': return "El campo \'\'Motivo Contacto\'\' es obligatorio";
		case 'CalMotivTipoClien.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";

		case 'CalTipoEstadConta.label': return "Tipos de estado de contactos";		
		case 'CalTipoEstadConta.codEsta.requiered.message': return "El campo \'\'C�d. Estado\'\' es obligatorio";
		case 'CalTipoEstadConta.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'CalTipoGestiClien.label': return "Tipos de gestiones del cliente";		
		case 'CalTipoGestiClien.codGest.requiered.message': return "El campo \'\'C�d. de Gesti�n\'\' es obligatorio";
		case 'CalTipoGestiClien.valDesc.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";


		case 'CarCodigAprob.label': return "CarCodigAprobs";
		case 'CarCodigAprob.codApro.requiered.message': return "El Campo \'\'C�d. aprobaci�n\'\' es obligatorio";
		case 'CarCodigAprob.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'CarCondiEvaluNr.label': return "CarCondiEvaluNrs";
		
		case 'CarCondiEvaluNr.penrOidParaEvalNr.requiered.message': return "El Campo \'\'C�d. tipo evaluaci�n\'\' es obligatorio";
		case 'CarCondiEvaluNr.valMini.requiered.message': return "El Campo \'\'Valor m�nimo\'\' es obligatorio";
		case 'CarCondiEvaluNr.valEscaMini.requiered.message': return "El Campo \'\'Escala m�nima\'\' es obligatorio";
		case 'CarCondiEvaluNr.valMaxivalMini.message': return "\'\'Valor m�ximo\'\' debe ser mayor que \'\'Valor m�nimo\'\'";
		case 'CarEstatPedid.label': return "CarEstatPedids";
		
		case 'CarEstatPedid.codEsta.requiered.message': return "El Campo \'\'C�d. estatus\'\' es obligatorio";
		case 'CarEstatPedid.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'CarIndicNivelJerar.label': return "CarIndicNivelJerars";
		
		case 'CarIndicNivelJerar.codIndiNiveJera.requiered.message': return "El Campo \'\'codIndiNiveJera\'\' es obligatorio";
		case 'CarIndicNivelJerar.codIndiNiveJera.A.value': return "A";
		case 'CarIndicNivelJerar.codIndiNiveJera.I.value': return "I";
		case 'CarJerar.label': return "CarJerars";
		
		case 'CarJerar.codJera.requiered.message': return "El Campo \'\'C�d. jerarqu�a\'\' es obligatorio";
		case 'CarJerar.numDias.requiered.message': return "El Campo \'\'N� d�as\'\' es obligatorio";
		case 'CarJerar.valPorcMontMaxi.requiered.message': return "El Campo \'\'Exceso monto m�ximo\'\' es obligatorio";
		case 'CarJerar.valPorcLineCred.requiered.message': return "El Campo \'\'Exceso l�nea cr�dito\'\' es obligatorio";
		case 'CarNivelRedon.label': return "CarNivelRedons";
		
		case 'CarNivelRedon.Descripcion.requiered.message': return "El Campo \'\'Descripcion\'\' es obligatorio";
		case 'CarNivelRiesg.label': return "CarNivelRiesgs";
		
		case 'CarNivelRiesg.codNiveRies.requiered.message': return "El Campo \'\'C�d. nivel riesgo\'\' es obligatorio";
		case 'CarNivelRiesg.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";

		case 'CarParamCalcuLc.label': return "Par�metros c�lculo LC";		
		case 'CarParamCalcuLc.niriOidNiveRies.requiered.message': return "El campo \'\'C�d. nivel riesgo\'\' es obligatorio";
		case 'CarParamCalcuLc.valTope.requiered.message': return "El campo \'\'Valor tope\'\' es obligatorio";
		case 'CarParamCalcuLc.valFactCalc.requiered.message': return "El campo \'\' Factor c�lculo\'\' es obligatorio";
		case 'CarParamCalcuLc.indVariLineCred.requiered.message': return "El campo \'\'Ind. var. L�nea cr�dito\'\' es obligatorio";
		case 'CarParamCalcuLc.indVariLineCred.A.value': return "Aumentar LC";
		case 'CarParamCalcuLc.indVariLineCred.D.value': return "Disminuir LC";

		case 'CarParamEvaluNr.label': return "Par�metros evaluaci�n NR";		
		case 'CarParamEvaluNr.codPara.requiered.message': return "El campo \'\'C�d. tipo evaluaci�n\'\' es obligatorio";
		case 'CarParamEvaluNr.valPeso.requiered.message': return "El campo \'\'Peso\'\' es obligatorio";
		case 'CarParamEvaluNr.desPara.requiered.message': return "El campo \'\' Descripci�n tipo evaluaci�n\'\' es obligatorio";
		

		case 'CarParamGenerCarte.label': return "CarParamGenerCartes";
		
		case 'CarParamGenerCarte.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'CarParamGenerCarte.inijOidIndiNiveJera.requiered.message': return "El Campo \'\'Ind. nivel jer�rquico siguiente\'\' es obligatorio";
		case 'CarParamGenerCarte.nireOidNiveRedo.requiered.message': return "El Campo \'\'Nivel redondeo\'\' es obligatorio";
		case 'CarParamGenerCarte.numPeriNuev.requiered.message': return "El Campo \'\'N� per�odos re-evaluaci�n nuevas\'\' es obligatorio";
		case 'CarParamGenerCarte.numPeriAnti.requiered.message': return "El Campo \'\'N� per�odos re-evaluaci�n antiguas\'\' es obligatorio";
		case 'CarParamNr.label': return "CarParamNrs";
		
		case 'CarParamNr.niriOidNiveRies.requiered.message': return "El Campo \'\'C�d. nivel riesgo\'\' es obligatorio";
		case 'CarParamNr.valMini.requiered.message': return "El Campo \'\'Valor m�nimo\'\' es obligatorio";
		case 'CarParamNr.valMaxivalMini.message': return "\'\'Valor m�ximo\'\' debe ser mayor que \'\'Valor m�nimo\'\'";
		case 'CccBanco.label': return "CccBancos";
		
		case 'CccBanco.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'CccBanco.codBanc.requiered.message': return "El Campo \'\'C�d. banco\'\' es obligatorio";
		case 'CccBanco.codBrio.requiered.message': return "El Campo \'\'C�d. bancario\'\' es obligatorio";
		case 'CccBanco.desBanc.requiered.message': return "El Campo \'\'Descripci�n banco\'\' es obligatorio";
		case 'CccCuentConta.label': return "CccCuentContas";
		
		case 'CccCuentConta.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'CccCuentConta.codCuenCont.requiered.message': return "El Campo \'\'C�d. cuenta contable\'\' es obligatorio";
		case 'CccCuentConta.codCuenSap.requiered.message': return "El Campo \'\'C�d. cuenta contable SAP\'\' es obligatorio";
		case 'CccCuentConta.Descripcion.requiered.message': return "El Campo \'\'Descripci�n cuenta contable\'\' es obligatorio";
		case 'CccCuentCorriBanca.label': return "CccCuentCorriBancas";
		
		case 'CccCuentCorriBanca.sociOidSoci.requiered.message': return "El Campo \'\'Sociedad\'\' es obligatorio";
		case 'CccCuentCorriBanca.sucuOidSucu.requiered.message': return "El Campo \'\'C�d. sucursal\'\' es obligatorio";
		case 'CccCuentCorriBanca.cucoOidCcPnte.requiered.message': return "El Campo \'\'C�d. cuenta contable puente\'\' es obligatorio";
		case 'CccCuentCorriBanca.cucoOidCcTeso.requiered.message': return "El Campo \'\'C�d. cuenta contable tesorer�a\'\' es obligatorio";
		case 'CccCuentCorriBanca.codCc.requiered.message': return "El Campo \'\'C�d. cuenta corriente\'\' es obligatorio";
		case 'CccCuentCorriBanca.codCcBanc.requiered.message': return "El Campo \'\'N� cuenta corriente banco\'\' es obligatorio";
		case 'CccCuentCorriBanca.desCc.requiered.message': return "El Campo \'\'Descripci�n cuenta corriente\'\' es obligatorio";
		case 'CccMarcaSitua.label': return "CccMarcaSituas";
		
		case 'CccMarcaSitua.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'CccMarcaSitua.codMarcSitu.requiered.message': return "El Campo \'\'C�d. marca situaci�n\'\' es obligatorio";
		case 'CccMarcaSitua.indCuenCast.requiered.message': return "El Campo \'\'Ind. Cc castigada\'\' es obligatorio";
		case 'CccMarcaSitua.indCuenCast.1.value': return "Si";
		case 'CccMarcaSitua.indCuenCast.0.value': return "No";
		case 'CccMarcaSitua.Descripcion.requiered.message': return "El Campo \'\'Descripci�n marca situaci�n\'\' es obligatorio";
		case 'CccParamConta.label': return "CccParamContas";
		
		case 'CccParamConta.subpOidSubp.requiered.message': return "El Campo \'\'Subproceso\'\' es obligatorio";
		case 'CccParamConta.valDebeHabe.requiered.message': return "El Campo \'\'Ind. Debe/Haber\'\' es obligatorio";
		case 'CccParamConta.valDebeHabe.D.value': return "Debe";
		case 'CccParamConta.valDebeHabe.H.value': return "Haber";
		case 'CccParamConta.valObteCuen.D.value': return "Cuenta Directa";
		case 'CccParamConta.valObteCuen.B.value': return "Cuenta Banco";
		case 'CccParamConta.valObteCuen.P.value': return "Cuenta Puente banco";
		case 'CccParamConta.valObteCuen.T.value': return "Cuenta Tipo abono/cargo";
		case 'CccParamConta.valObteCuen.C.value': return "Cuenta Cuota anterior";
		case 'CccParamConta.valObteCuen.N.value': return "Cuenta cuota Nueva";
		case 'CccParamConta.valTextApun.requiered.message': return "El Campo \'\'Texto apunte\'\' es obligatorio";
		case 'CccParamConta.indConcFech.requiered.message': return "El Campo \'\'Concatenar fecha texto\'\' apunte es obligatorio";
		case 'CccParamConta.indConcFech.1.value': return "Si";
		case 'CccParamConta.indConcFech.0.value': return "No";
		case 'CccProce.label': return "CccProces";
		
		case 'CccProce.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'CccProce.codProc.requiered.message': return "El Campo \'\'Proceso\'\' es obligatorio";
		case 'CccProce.desProc.requiered.message': return "El Campo \'\'Descripci�n\'\' proceso es obligatorio";
		case 'CccProce.indCvDire.1.value': return "Si";
		case 'CccProce.indCvDire.0.value': return "No";
		case 'CccSubpr.label': return "CccSubprs";
		
		case 'CccSubpr.ccprOidProc.requiered.message': return "El Campo \'\'Proceso\'\' es obligatorio";
		case 'CccSubpr.codSubp.requiered.message': return "El Campo \'\'Subproceso\'\' es obligatorio";
		case 'CccSubpr.desSubp.requiered.message': return "El Campo \'\'Descripci�n\'\' subproceso es obligatorio";
		case 'CccSubpr.valIndiCons.requiered.message': return "El Campo \'\'Ind. consultas\'\' es obligatorio";
		case 'CccSubpr.valIndiCons.D.value': return "Debe";
		case 'CccSubpr.valIndiCons.H.value': return "Haber";
		case 'CccSubpr.valIndiCons.A.value': return "Ambos";
		case 'CccSubpr.valIndiCons.N.value': return "No Aplica";
		case 'CccSucur.label': return "CccSucurs";
		
		case 'CccSucur.cbanOidBanc.requiered.message': return "El Campo \'\'Banco\'\' es obligatorio";
		case 'CccSucur.codSucu.requiered.message': return "El Campo \'\'C�d. sucursa\'\'l es obligatorio";
		case 'CccSucur.valDire.requiered.message': return "El Campo \'\'Direcci�n\'\' es obligatorio";
		case 'CccTipoAbonoSubpr.label': return "CccTipoAbonoSubprs";
		
		case 'CccTipoAbonoSubpr.subpOidSubp.requiered.message': return "El Campo \'\'Subproceso\'\' es obligatorio";
		case 'CccTipoAbonoSubpr.cucoOidCuenCont.requiered.message': return "El Campo \'\'Cuenta contable\'\' es obligatorio";
		case 'CccTipoAbonoSubpr.tcabOidTcab.requiered.message': return "El Campo \'\'Tipo abono\'\' es obligatorio";
		case 'CccTipoCargoAbono.label': return "CccTipoCargoAbonos";
		
		case 'CccTipoCargoAbono.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'CccTipoCargoAbono.codTipoCargAbon.requiered.message': return "El Campo \'\'C�d. tipo abono/cargo\'\' es obligatorio";
		case 'CccTipoCargoAbono.Descripcion.requiered.message': return "El Campo \'\'Descripci�n tipo abono/cargo\'\' es obligatorio";
		case 'CccTipoError.label': return "CccTipoErrors";
		
		case 'CccTipoError.codErro.requiered.message': return "El Campo \'\'C�d. tipo error\'\' es obligatorio";
		case 'CccTipoError.Descripcion.requiered.message': return "El Campo \'\'Descripci�n tipo error\'\' es obligatorio";
		case 'CccTipoTrans.label': return "CccTipoTranss";
		
		case 'CccTipoTrans.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'CccTipoTrans.codTipoTran.requiered.message': return "El Campo \'\'C�digo\'\' es obligatorio";
		case 'CccTipoTrans.codTipoTranCheq.requiered.message': return "El Campo \'\'Ind. transacci�n cheque devuelto\'\' es obligatorio";
		case 'CccTipoTrans.codTipoTranCheq.S.value': return "Si";
		case 'CccTipoTrans.codTipoTranCheq.N.value': return "No";
		case 'CccTipoTrans.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";

		case 'CobAccioCobra.label': return "CobAccioCobras";
		case 'CobAccioCobra.codAcciCobr.requiered.message': return "El campo \'\'C�digo Acci�n Cobranza\'\' es obligatorio";
		case 'CobAccioCobra.valDesc.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'CobAccioCobra.indFechHoraSegu.1.value': return "Si";
		case 'CobAccioCobra.indFechHoraSegu.0.value': return "No";
		case 'CobAccioCobra.indFechImpoComp.1.value': return "Si";
		case 'CobAccioCobra.indFechImpoComp.0.value': return "No";
		case 'CobAccioCobra.indFechHoraNuevSegu.1.value': return "Si";
		case 'CobAccioCobra.indFechHoraNuevSegu.0.value': return "No";
		case 'CobAccioCobra.indAporPrue.1.value': return "Si";
		case 'CobAccioCobra.indAporPrue.0.value': return "No";
		case 'CobAccioCobra.indDescPrue.1.value': return "Si";
		case 'CobAccioCobra.indDescPrue.0.value': return "No";
		case 'CobAccioCobra.indNumeDocuSopo.1.value': return "Si";
		case 'CobAccioCobra.indNumeDocuSopo.0.value': return "No";
		case 'CobAccioCobra.indTipoDocuPago.1.value': return "Si";
		case 'CobAccioCobra.indTipoDocuPago.0.value': return "No";
		case 'CobAccioCobra.indBancSucu.1.value': return "1";
		case 'CobAccioCobra.indBancSucu.0.value': return "No";
		case 'CobAccioCobra.indNuevTelf.1.value': return "Si";
		case 'CobAccioCobra.indNuevTelf.0.value': return "No";
		case 'CobAccioCobra.indPasaAdmi.1.value': return "Si";
		case 'CobAccioCobra.indPasaAdmi.0.value': return "No";
		case 'CobAccioCobra.indPetiBloqAdmi.1.value': return "Si";
		case 'CobAccioCobra.indPetiBloqAdmi.0.value': return "No";
		case 'CobAccioCobra.indPetiDesbAdmi.1.value': return "Si";
		case 'CobAccioCobra.indPetiDesbAdmi.0.value': return "No";
		case 'CobAccioCobra.indAcciMensReco.1.value': return "Si";
		case 'CobAccioCobra.indAcciMensReco.0.value': return "No";
		case 'CobAccioCobra.indObse.1.value': return "Si";
		case 'CobAccioCobra.indObse.0.value': return "No";
		case 'CobAccioCobra.paisOidPais.requiered.message': return "El campo \'\'paisOidPais\'\' es obligatorio";
		case 'CobAccioCobra.saccOidSubtAcci.requiered.message': return "El campo \'\'Subtipo Acci�n\'\' es obligatorio";

		case 'CobArgum.label': return "CobArgums";
		case 'CobArgum.codArgu.requiered.message': return "El campo \'\'C�digo Argumento\'\' es obligatorio";
		case 'CobArgum.valDesc.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'CobArgum.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";

		case 'CobArgumObligVolun.label': return "CobArgumObligVoluns";		
		case 'CobArgumObligVolun.codArguObliVolu.requiered.message': return "El campo \'\'codArguObliVolu\'\' es obligatorio";

		case 'CobBaseEscal.label': return "Base Escalas";		
		case 'CobBaseEscal.codBaseEsca.requiered.message': return "El campo \'\'Cod. de Base Escala\'\' es obligatorio";
		case 'CobBaseEscal.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'CobEscalLiqui.label': return "CobEscalLiquis";
		case 'CobEscalLiqui.numOrdeEsca.requiered.message': return "El campo \'\'Orden Escala\'\' es obligatorio";
		case 'CobEscalLiqui.impRangHastImpoimpRangDesdImpo.message': return "\'\'Rango hasta importe\'\' debe ser mayor que \'\'Rango desde importe\'\'";
		case 'CobEscalLiqui.valRangHastPorcvalRangHastPorc.message': return "\'\'Rango hasta %\'\' debe ser mayor que \'\'Rango desde %\'\'";
		case 'CobEscalLiqui.valRangHastPorcvalRangDesdPorc.message': return "\'\'Rango hasta %\'\' debe ser mayor que \'\'Rango desde %\'\'";
		case 'CobEscalLiqui.impComiPorc.requiered.message': return "El campo \'\'Comisi�n %\'\' es obligatorio";
		case 'CobEscalLiqui.impComiImpo.requiered.message': return "El campo \'\'Comisi�n Importe\'\' es obligatorio";
		case 'CobEscalLiqui.melcOidMetoLiquCobr.requiered.message': return "El campo \'\'C�digo M�todo Liquidaci�n\'\' es obligatorio";


		case 'CobEstadGrupoUsuar.label': return "Estado Grupo de Usuarios";		
		case 'CobEstadGrupoUsuar.codEstaGrupUsua.requiered.message': return "El campo \'\'C�d. Estado Grupo de Usuarios\'\' es obligatorio";
		case 'CobEstadGrupoUsuar.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'CobEstadUsuarEtapaCobra.label': return "CobEstadUsuarEtapaCobras";		
		case 'CobEstadUsuarEtapaCobra.codEstaUsuaEtapCobr.requiered.message': return "El campo \'\'C�d. Estado Usuario Etapa Cobranza\'\' es obligatorio";
		case 'CobEstadUsuarEtapaCobra.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'CobEtapaDeuda.label': return "CobEtapaDeudas";
		case 'CobEtapaDeuda.codEtapDeud.requiered.message': return "El campo \'\'C�digo Etapa Deuda\'\' es obligatorio";
		case 'CobEtapaDeuda.valDesc.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'CobEtapaDeuda.indExcl.1.value': return "Si";
		case 'CobEtapaDeuda.indExcl.0.value': return "No";
		case 'CobEtapaDeuda.valEdadInic.requiered.message': return "El campo \'\'Edad inicial\'\' es obligatorio";
		case 'CobEtapaDeuda.valEdadFina.requiered.message': return "El campo \'\'Edad final\'\' es obligatorio";
		case 'CobEtapaDeuda.valEdadFinavalEdadInic.message': return "\'\'Edad Final\'\' debe ser mayor o igual que \'\'Edad Inicial\'\'";
		case 'CobEtapaDeuda.indTelf.requiered.message': return "El campo \'\'Tel�fono\'\' es obligatorio";
		case 'CobEtapaDeuda.indTelf.1.value': return "Si";
		case 'CobEtapaDeuda.indTelf.0.value': return "No";
		case 'CobEtapaDeuda.impDesd.requiered.message': return "El campo \'\'Importe desde\'\' es obligatorio";
		case 'CobEtapaDeuda.impHast.requiered.message': return "El campo \'\'Importe hasta\'\' es obligatorio";
		case 'CobEtapaDeuda.impHastimpDesd.message': return "\'\'Importe hasta\'\' debe ser mayor o igual que \'\'Importe desde\'\'";
		case 'CobEtapaDeuda.numDiasGracCompPago.requiered.message': return "El campo \'\'D�as gracia compromisos pago\'\' es obligatorio";
		case 'CobEtapaDeuda.valPorcIncu.requiered.message': return "El campo \'\'% incumplidas\'\' es obligatorio";
		case 'CobEtapaDeuda.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'CobEtapaDeuda.oredOidEtapDeu1.requiered.message': return "El campo \'\'Orden Etapa Deuda 1\'\' es obligatorio";
		
		case 'CobEtapaDeudaTipoCargo.label': return "CobEtapaDeudaTipoCargos";
		case 'CobEtapaDeudaTipoCargo.tcabOidTipoCargAbon.requiered.message': return "El campo \'\'Tipo Cargo\'\' es obligatorio";
		case 'CobEtapaDeudaTipoCargo.etdeOidEtapDeud.requiered.message': return "El campo \'\'Etapa Deuda\'\' es obligatorio";

		case 'CobGrupoUsuarCobra.label': return "CobGrupoUsuarCobras";
		case 'CobGrupoUsuarCobra.codGrupUsua.requiered.message': return "El campo \'\'C�digo Grupo Usuario\'\' es obligatorio";
		case 'CobGrupoUsuarCobra.valDesc.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'CobGrupoUsuarCobra.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'CobGrupoUsuarCobra.codUsua.requiered.message': return "El campo \'\'C�digo Usuario Supervisor\'\' es obligatorio";

		case 'CobGuionArgumCabec.label': return "CobGuionArgumCabecs";
		case 'CobGuionArgumCabec.codGuiaArgu.requiered.message': return "El campo \'\'C�digo Gu�a Argumental\'\' es obligatorio";
		case 'CobGuionArgumCabec.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'CobGuionArgumCabec.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'CobGuionArgumDetal.label': return "CobGuionArgumDetals";
		case 'CobGuionArgumDetal.numOrdeArgu.requiered.message': return "El campo \'\'Orden del argumento\'\' es obligatorio";
		case 'CobGuionArgumDetal.indValoDefe.requiered.message': return "El campo \'\'Valor por defecto\'\' es obligatorio";
		case 'CobGuionArgumDetal.indValoDefe.0.value': return "No";
		case 'CobGuionArgumDetal.indValoDefe.1.value': return "Si";
		case 'CobGuionArgumDetal.indActiAtriObse.requiered.message': return "El campo \'\'Activar atributo observaciones\'\' es obligatorio";
		case 'CobGuionArgumDetal.indActiAtriObse.0.value': return "No";
		case 'CobGuionArgumDetal.indActiAtriObse.1.value': return "Si";
		case 'CobGuionArgumDetal.arguOidArgu.requiered.message': return "El campo \'\'C�digo Argumento\'\' es obligatorio";
		case 'CobGuionArgumDetal.gacaOidGuioArguCabe.requiered.message': return "El campo \'\'C�digo Gu�a Argumental\'\' es obligatorio";
		case 'CobGuionArgumDetal.obvoOidArguObliVolu.requiered.message': return "El campo \'\'Obligatorio / Voluntario\'\' es obligatorio";

		case 'CobMetodLiqui.label': return "CobMetodLiquis";
		case 'CobMetodLiqui.codMetoLiqu.requiered.message': return "El campo \'\'C�digo M�todo Liquidaci�n\'\' es obligatorio";
		case 'CobMetodLiqui.valDescMetoLiqu.requiered.message': return "El campo \'\'Descripci�n M�todo Liquidaci�n\'\' es obligatorio";
		case 'CobMetodLiqui.indLiqu.requiered.message': return "El campo \'\'Liquidaci�n\'\' es obligatorio";
		case 'CobMetodLiqui.indLiqu.0.value': return "No";
		case 'CobMetodLiqui.indLiqu.1.value': return "Si";
		case 'CobMetodLiqui.indLiquGrupUsua.requiered.message': return "El campo \'\'Liquidaci�n grupo de usuarios\'\' es obligatorio";
		case 'CobMetodLiqui.indLiquGrupUsua.0.value': return "No";
		case 'CobMetodLiqui.indLiquGrupUsua.1.value': return "Si";
		case 'CobMetodLiqui.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'CobMetodLiqui.baesOidBaseEsca.requiered.message': return "El campo \'\'Base Escala\'\' es obligatorio";

		case 'CobMotivIncob.label': return "CobMotivIncobs";
		case 'CobMotivIncob.codMotiCobr.requiered.message': return "El campo \'\'C�digo Motivo No Cobro\'\' es obligatorio";
		case 'CobMotivIncob.valDescMotiCobr.requiered.message': return "El campo \'\'Descripci�n Motivo No Cobro\'\' es obligatorio";
		case 'CobMotivIncob.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";

		case 'CobOrdenEtapaDeuda.label': return "CobOrdenEtapaDeudas";		
		case 'CobOrdenEtapaDeuda.codOrdeEtapDeud.requiered.message': return "El campo \'\'C�d. Orden Etapa Deuda\'\' es obligatorio";
		case 'CobOrdenEtapaDeuda.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";


		case 'CobSubtiAccio.label': return "CobSubtiAccios";		
		case 'CobSubtiAccio.codSubtAcci.requiered.message': return "El campo \'\'C�d. Subtipo de Acci�n\'\' es obligatorio";

		case 'CobTipoBalan.label': return "CobTipoBalans";		
		case 'CobTipoBalan.codTipoBala.requiered.message': return "El campo \'\'C�d. Tipo de Balanceo\'\' es obligatorio";
		case 'CobTipoBalan.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'CobUsuarCobraView.label': return "CobUsuarCobraViews";		

		case 'CobUsuarEtapaCobraCabec.label': return "CobUsuarEtapaCobraCabecs";
		case 'CobUsuarEtapaCobraCabec.uscoOidUsuaCobr.requiered.message': return "El campo \'\'C�digo usuario\'\' es obligatorio";
		case 'CobUsuarEtapaCobraCabec.etdeOidEtapDeud.requiered.message': return "El campo \'\'C�digo Etapa Deuda\'\' es obligatorio";

		case 'CobUsuarEtapaCobraDetal.label': return "CobUsuarEtapaCobraDetals";
		case 'CobUsuarEtapaCobraDetal.ueccOidUsuaEtapCobr.requiered.message': return "El campo \'\'C�digo usuario\'\' es obligatorio";
		case 'CobUsuarEtapaCobraDetal.zsgvOidSubgVent.requiered.message': return "El campo \'\'Subgerencia de Ventas\'\' es obligatorio";
		case 'CobUsuarEtapaCobraDetal.edtcOidEtapDeudTipoCarg.requiered.message': return "El campo \'\'Tipo de Cargo\'\' es obligatorio";


		case 'CobUsuarGrupoUsuar.label': return "CobUsuarGrupoUsuars";
		case 'CobUsuarGrupoUsuar.uscoOidUsuaCobr.requiered.message': return "El campo \'\'C�digo Usuario\'\' es obligatorio";
		case 'CobUsuarGrupoUsuar.gucoOidGrupUsuaCobr.requiered.message': return "El campo \'\'C�digo Grupo Usuario\'\' es obligatorio";

		case 'CobValorArgum.label': return "CobValorArgums";
		case 'CobValorArgum.valArgu.requiered.message': return "El campo \'\'Valor argumento\'\' es obligatorio";
		case 'CobValorArgum.valDescValoArgu.requiered.message': return "El campo \'\'Descripci�n valor argumento\'\' es obligatorio";
		case 'CobValorArgum.arguOidArgu.requiered.message': return "El campo \'\'C�digo Argumento\'\' es obligatorio";

		case 'ComConge.label': return "Gerente Congelado";		
		case 'ComConge.codCong.requiered.message': return "El campo \'\'Congelado Id\'\' es obligatorio";
		case 'ComConge.fecDesd.requiered.message': return "El campo \'\'Fecha Desde\'\' es obligatorio";
		case 'ComConge.fecHast.requiered.message': return "El campo \'\'Fecha Hasta\'\' es obligatorio";
		case 'ComConge.fecHastvalMini.message': return "\'\'Fecha Hasta\'\' debe ser mayor que \'\'Fecha Desde\'\'";
		case 'ComConge.impCong.requiered.message': return "El campo \'\'Importe\'\' es obligatorio";
		case 'ComConge.indDescAuto.requiered.message': return "El campo \'\'Descongelaci�n autom�tica \'\' es obligatorio";
		case 'ComConge.indDescAuto.0.value': return "No";
		case 'ComConge.indDescAuto.1.value': return "Si";
		case 'ComConge.clieOidClie.requiered.message': return "El campo \'\'C�digo Cliente\'\' es obligatorio";
		case 'ComConge.fecHastfecDesd.message': return "\'\'Fecha Hasta\'\' debe ser mayor que \'\'Fecha Desde\'\'";

		case 'ComEstadComis.label': return "Estados de Comisi�n";		
		case 'ComEstadComis.codEstaComi.requiered.message': return "El campo \'\'C�digo\'\' es obligatorio";
		case 'ComEstadComis.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'ComTipoClienComisCabec.label': return "Tipo de Cliente Cabecera";		
		case 'ComTipoClienComisCabec.codClas.G.value': return "Gerente";
		case 'ComTipoClienComisCabec.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'ComTipoClienComisCabec.codClas.requiered.message': return "El campo \'\'Id. Clasificaci�n\'\' es obligatorio";
		case 'ComTipoClienComisCabec.codSubc.requiered.message': return "El campo \'\'Id. SubClasificaci�n\'\' es obligatorio";
		case 'ComTipoClienComisCabec.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'ComTipoClienComisDetal.label': return "Tipo de Cliente Detalle";		
		case 'ComTipoClienComisDetal.codTipoClieComi.requiered.message': return "El campo \'\'Tipo Cliente\'\' es obligatorio";
		case 'ComTipoClienComisDetal.clasOidClas.requiered.message': return "El campo \'\'Tipo Clasificaci�n\'\' es obligatorio";
		case 'ComTipoClienComisDetal.tcccOidTipoClieComiCabe.requiered.message': return "El campo \'\'Tipo Cliente\'\' es obligatorio";
		case 'ComTipoClienComisDetal.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'ComTipoPlant.label': return "ComTipoPlants";		
		case 'ComTipoPlant.codPlan.requiered.message': return "El campo \'\'codPlan\'\' es obligatorio";

		case 'CraPerio.label': return "Periodos";		
		case 'CraPerio.marcOidMarc.requiered.message': return "El campo \'\'Marca\'\' es obligatorio";
		case 'CraPerio.canaOidCana.requiered.message': return "El campo \'\'Canal\'\' es obligatorio";
		case 'CraPerio.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'CraPerio.periOidPeri.requiered.message': return "El campo \'\'Per�odo\'\' es obligatorio";
		case 'CraPerio.fecInic.requiered.message': return "El campo \'\'Fecha Inicio\'\' es obligatorio";
		case 'CraPerio.fecFina.requiered.message': return "El campo \'\'Fecha de Fin\'\' es obligatorio";
		case 'CraPerio.valEsta.requiered.message': return "El campo \'\'Estado\'\' es obligatorio";
		case 'CraPerio.valNombPeri.requiered.message': return "El campo \'\'Nombre del Per�odo\'\' es obligatorio";

		case 'EduFrecuCurso.label': return "EduFrecuCursos";		
		case 'EduFrecuCurso.codFrec.requiered.message': return "El Campo \'\'C�d. frecuencia\'\' es obligatorio";
		case 'EduFrecuCurso.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'EduTipoCurso.label': return "EduTipoCursos";
		
		case 'EduTipoCurso.marcOidMarc.requiered.message': return "El Campo \'\'Marca\'\' es obligatorio";
		case 'EduTipoCurso.codTipoCurs.requiered.message': return "El Campo \'\'Tipo curso\'\' es obligatorio";
		case 'EduTipoCurso.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		
		// splatas - 19/10/2005
		case 'FacAsignImpre.label': return "Asignaci�n impresoras";		
		case 'FacAsignImpre.imviOidImpr.requiered.message': return "El campo \'\'Impresora virtual\'\' es obligatorio";
		case 'FacAsignImpre.sbacOidSbac.requiered.message': return "El campo \'\'Subacceso\'\' es obligatorio";
		case 'FacAsignImpre.forsOidForm.requiered.message': return "El campo \'\'Formulario\'\' es obligatorio";
		
		case 'FacFormu.label': return "Formularios";		
		case 'FacFormu.codForm.requiered.message': return "El campo \'\'C�d. formulario\'\' es obligatorio";
		case 'FacFormu.numLine.requiered.message': return "El campo \'\'N�mero l�nea\'\' es obligatorio";
		case 'FacFormu.valTamaForm.requiered.message': return "El campo \'\'Tama�o formulario\'\' es obligatorio";
		case 'FacFormu.valRutiDiseForm.requiered.message': return "El campo \'\' Rutina dise�o formato\'\' es obligatorio";
		case 'FacFormu.indImpr.requiered.message': return "El campo \'\'Se imprime\'\' es obligatorio";
		case 'FacFormu.indImpr.1.value': return "Si";
		case 'FacFormu.indImpr.0.value': return "No";
		case 'FacFormu.indPrei.requiered.message': return "El campo \'\'Preimpreso\'\' es obligatorio";
		case 'FacFormu.indSpooIndi.requiered.message': return "El campo \'\'Spool individual paquete documentario\'\' es obligatorio";
		case 'FacFormu.teimOidTecn.requiered.message': return "El campo \'\'Tecnolog�a\'\' es obligatorio";
		case 'FacFormu.valNombForm.requiered.message': return "El campo \'\'Nombre formulario\'\' es obligatorio";
		case 'FacFormu.indActi.requiered.message': return "El campo \'\'Status\'\' es obligatorio";
		case 'FacFormu.indActi.1.value': return "Activo";
		case 'FacFormu.indActi.0.value': return "Baja";
		case 'FacFormu.indNumOfic.requiered.message': return "El campo \'\'Tipo numeraci�n documento\'\' es obligatorio";
		case 'FacFormu.indNumOfic.1.value': return "Oficial";
		case 'FacFormu.indNumOfic.0.value': return "Libre";
		case 'FacFormu.numLineSaltPagi.requiered.message': return "El campo \'\'N� l�neas salto p�gina\'\' es obligatorio";
		case 'FacFormu.tidoOidTipoDocu.requiered.message': return "El campo \'\'Tipo documento legal\'\' es obligatorio";
		case 'FacFormu.deimOidDestImpr.requiered.message': return "El campo \'\'Destino\'\' es obligatorio";
		
		// splatas - 26/10/2005
		case 'FacFormu.indNumOfic.validation.message': return "Si \'\'Tipo numeraci�n documento\'\' es \'\'Oficial\'\' entonces \'\'Preimpreso\'\' debe ser \'\'Si\'\'";

		case 'FacImpreVirtu.label': return "Impresoras";		
		case 'FacImpreVirtu.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'FacImpreVirtu.codImpr.requiered.message': return "El campo \'\' C�d. impresora\'\' es obligatorio";
		case 'FacImpreVirtu.desImpr.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'FacImpreVirtu.tiimOidTipo.requiered.message': return "El campo \'\'Tipo impresora\'\' es obligatorio";
		case 'FacImpreVirtu.indEstaActi.requiered.message': return "El campo \'\'Estatus\'\' es obligatorio";
		case 'FacImpreVirtu.indEstaActi.0.value': return "Baja";
		case 'FacImpreVirtu.indEstaActi.1.value': return "Activo";
		case 'FacImpreVirtu.valTamaBuff.requiered.message': return "El campo \'\'Tama�o buffer\'\' es obligatorio";
		case 'FacImpreVirtu.numSecu.requiered.message': return "El campo \'\'Secuencia\'\' es obligatorio";
		case 'FacImpreVirtu.numSecu.0.value': return "No";
		case 'FacImpreVirtu.numSecu.1.value': return "Si";

		case 'FacTipoDocum.label': return "FacTipoDocums";
		case 'FacTipoDocum.codTipoDocu.requiered.message': return "El Campo \'\'codTipoDocu\'\' es obligatorio";
		case 'FacTipoDocum.desTipoDocu.requiered.message': return "El Campo \'\'desTipoDocu\'\' es obligatorio";

		case 'FacParamFactu.label': return "Par�metros facturaci�n";		
		case 'FacParamFactu.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'FacParamFactu.numMaxiCampPrd.requiered.message': return "El campo \'\'N� m�ximo per�odos PRD\'\' es obligatorio";
		case 'FacParamFactu.numMaxiPediProy.requiered.message': return "El campo \'\'N� m�ximo pedidos proyecci�n\'\' es obligatorio";
		case 'FacParamFactu.indDocuMonoPagi.requiered.message': return "El campo \'\'Documento monop�gina\'\' es obligatorio";
		case 'FacParamFactu.indDocuMonoPagi.1.value': return "Si";
		case 'FacParamFactu.indDocuMonoPagi.0.value': return "No";
		case 'FacParamFactu.indCheqClieNuev.requiered.message': return "El campo \'\'Ind. cheque cliente nuevo\'\' es obligatorio";
		case 'FacParamFactu.indCheqClieNuev.1.value': return "Si";
		case 'FacParamFactu.indCheqClieNuev.0.value': return "No";
		case 'FacParamFactu.indTipoProyRegi.requiered.message': return "El campo \'\'Ind. tipo proyecci�n\'\' es obligatorio";
		case 'FacParamFactu.indTipoProyRegi.1.value': return "Region";
		case 'FacParamFactu.indTipoProyRegi.2.value': return "Zona";
		case 'FacParamFactu.indPrecCont.1.value': return "Si";
		case 'FacParamFactu.indPrecCont.0.value': return "No";
		case 'FacParamFactu.indMostVencCupo.requiered.message': return "El campo \'\'Mostrar vencimiento cup�n\'\' es obligatorio";
		case 'FacParamFactu.indMostVencCupo.1.value': return "Si";
		case 'FacParamFactu.indMostVencCupo.0.value': return "No";

		// splatas - 26/10/2006 - DBLG700000163
		case 'FacParamFactu.codModaDist.A.value': return "APE";
		case 'FacParamFactu.codModaDist.L.value': return "Larissa";
		case 'FacParamFactu.codModaDist.O.value': return "Otros";

		case 'FacTecnoImpre.label': return "FacTecnoImpres";		
		case 'FacTipoFormu.label': return "FacTipoFormus";		
		case 'FacTipoFormu.codTipoForm.requiered.message': return "El campo \'\'C�d. tipo formulario\'\' es obligatorio";

		case 'FacTipoImpre.label': return "FacTipoImpres";		
		case 'FacTipoOfertExclu.label': return "FacTipoOfertExclus";		
		case 'FacTipoOfertExclu.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'FacTipoOfertExclu.tofeOidTipoOfer.requiered.message': return "El campo \'\'Tipo oferta\'\' es obligatorio";
		case 'FacTipoOfertExclu.fecDesd.requiered.message': return "El campo \'\'Fecha desde\'\' es obligatorio";
		case 'FacTipoOfertExclu.fecHast.requiered.message': return "El campo \'\'Fecha hasta\'\' es obligatorio";
		case 'FacTipoOfertExclu.fecHastfecDesd.message': return "\'\'Fecha hasta %\'\' debe ser mayor que \'\'Fecha desde %\'\'";

		case 'GenDetaSicc.label': return "GenDetaSiccs";
		
		case 'GenDetaSicc.enti.requiered.message': return "El Campo \'\'enti\'\' es obligatorio";
		case 'GenDetaSicc.entiPk.requiered.message': return "El Campo \'\'entiPk\'\' es obligatorio";
		case 'GenDetaSicc.atri.requiered.message': return "El Campo \'\'atri\'\' es obligatorio";
		case 'GenDetaSicc.deta.requiered.message': return "El Campo \'\'deta\'\' es obligatorio";
		case 'GenDetaSicc.idioOidIdio.requiered.message': return "El Campo \'\'idioOidIdio\'\' es obligatorio";
		case 'GenDetaSiccWithDefault.label': return "GenDetaSiccWithDefaults";
		
		case 'GenDetaSiccWithDefault.enti.requiered.message': return "El Campo \'\'enti\'\' es obligatorio";
		case 'GenDetaSiccWithDefault.entiPk.requiered.message': return "El Campo \'\'entiPk\'\' es obligatorio";
		case 'GenDetaSiccWithDefault.atri.requiered.message': return "El Campo \'\'atri\'\' es obligatorio";
		case 'GenDetaSiccWithDefault.deta.requiered.message': return "El Campo \'\'deta\'\' es obligatorio";
		case 'GenDetaSiccWithDefault.idioOidIdio.requiered.message': return "El Campo \'\'idioOidIdio\'\' es obligatorio";

		case 'IncDirig.label': return "IncDirigs";		
		case 'IncDirig.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'IncMotivPremiConsu.label': return "Motivos premios consuelo";		
		case 'IncMotivPremiConsu.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'IncPartiConcuCabec.label': return "Participantes concurso incentivos cabecera";		
		case 'IncPartiConcuCabec.valGrupClie.requiered.message': return "El campo \'\'Grupo clientes\'\' es obligatorio";
		case 'IncPartiConcuCabec.paisOidPais.requiered.message': return "El campo \'\'paisOidPais\'\' es obligatorio";
		case 'IncPartiConcuCabec.diriOidDiri.requiered.message': return "El campo \'\'Clasificaci�n\'\' es obligatorio";
		case 'IncPartiConcuCabec.desDesc.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'IncPartiConcuDetal.label': return "Participantes concurso incentivos detalle";		
		case 'IncPartiConcuDetal.paciOidPartConcCabe.requiered.message': return "El campo \'\'Grupo clientes\'\' es obligatorio";
		case 'IncPartiConcuDetal.ticlOidTipoClie.requiered.message': return "El campo \'\'Tipo cliente\'\' es obligatorio";
		
		case 'IntAccesBuzonIvrrg.label': return "Correspondencia buz�n IVR regi�n";		
		case 'IntAccesBuzonIvrrg.codAcceBuzoIvrr.requiered.message': return "El campo \'\'C�d. acceso buzon IVR\'\' es obligatorio";
		case 'IntAccesBuzonIvrrg.zorgOidRegi.requiered.message': return "El campo \'\'Regi�n\'\' es obligatorio";
		case 'IntAccesBuzonIvrzn.label': return "Correspondencia buz�n IVR zona";		
		case 'IntAccesBuzonIvrzn.codAcceBuzoIvrz.requiered.message': return "El campo \'\'C�d. acceso buz�n IVR\'\' es obligatorio";
		case 'IntAccesBuzonIvrzn.zzonOidZona.requiered.message': return "El campo \'\'Zona\'\' es obligatorio";

		case 'IntImporContaFactu.label': return "Mantenimiento importes contables facturaci�n";		
		case 'IntImporContaFactu.codImpoCont.requiered.message': return "El campo \'\'C�d. importe\'\' es obligatorio";
		case 'IntImporContaFactu.valIdenCabeDeta.requiered.message': return "El campo \'\'Cabecera detalle\'\' es obligatorio";
		case 'IntImporContaFactu.valDescImpo.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'IntParamContaFactu.label': return "Mantenimiento par�metros contables facturaci�n";		
		case 'IntParamContaFactu.codApun.requiered.message': return "El campo \'\'C�d. apunte\'\' es obligatorio";
		case 'IntParamContaFactu.valTipoAsie.requiered.message': return "El campo \'\'Tipo asiento\'\' es obligatorio";
		case 'IntParamContaFactu.valTipoAsie.VN.value': return "VN";
		case 'IntParamContaFactu.valTipoAsie.AB.value': return "AB";
		case 'IntParamContaFactu.valTipoAsie.TN.value': return "TN";
		case 'IntParamContaFactu.valIdenCabeDeta.requiered.message': return "El campo \'\'Cabecera/Detalle\'\' es obligatorio";
		case 'IntParamContaFactu.valIdenCabeDeta.C.value': return "C";
		case 'IntParamContaFactu.valIdenCabeDeta.D.value': return "D";
		case 'IntParamContaFactu.valDesc.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'IntParamContaFactu.prodOidProd.requiered.message': return "El campo \'\'C�d. producto SAP\'\' es obligatorio";
		case 'IntParamContaFactu.cucoOidCuenCont.requiered.message': return "El campo \'\'Cuenta Contable\'\' es obligatorio";
		case 'IntParamContaFactu.valIndiDebeHabe.requiered.message': return "El campo \'\'Debe/Haber\'\' es obligatorio";
		case 'IntParamContaFactu.valIndiDebeHabe.D.value': return "D";
		case 'IntParamContaFactu.valIndiDebeHabe.H.value': return "H";
		case 'IntParamContaFactu.imcfOidImpoContFact.requiered.message': return "El campo \'\'C�d. importe\'\' es obligatorio";
		case 'IntParamContaFactu.paisOidPais.requiered.message': return "El campo \'\'Pais\'\' es obligatorio";

		case 'MaeCicloVida.label': return "MaeCicloVidas";
		case 'MaeCicloVida.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeCicloVida.codCiclVida.requiered.message': return "El Campo \'\'Ciclo vida\'\' es obligatorio";
		case 'MaeCicloVida.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeClaseTarje.label': return "MaeClaseTarjes";
		
		case 'MaeClaseTarje.codClasTarj.requiered.message': return "El Campo \'\'Clase tarjeta\'\' es obligatorio";
		case 'MaeClasi.label': return "MaeClasis";
		
		case 'MaeClasi.tcclOidTipoClas.requiered.message': return "El Campo \'\'Tipo clasificaci�n\'\' es obligatorio";
		case 'MaeClasi.codClas.requiered.message': return "El Campo \'\'Clasificaci�n\'\' es obligatorio";
		case 'MaeClasi.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeClasiView.label': return "MaeClasiViews";
		
		case 'MaeClasiView.tcclOidTipoClas.requiered.message': return "El Campo \'\'Tipo clasificaci�n\'\' es obligatorio";
		case 'MaeClasiView.codClas.requiered.message': return "El Campo \'\'Clasificaci�n\'\' es obligatorio";
		case 'MaeClasiView.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeCriteBusqu.label': return "MaeCriteBusqus";
		
		case 'MaeCriteBusqu.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeCriteBusqu.atreOidAtriEsp1.requiered.message': return "El Campo \'\'Criterio b�squeda 1\'\' es obligatorio";
		case 'MaeCriteBusqu.atreOidAtriEsp2.requiered.message': return "El Campo \'\'Criterio b�squeda 2\'\' es obligatorio";

		case 'MaeCodigClienAnter.label': return "MaeCodigClienAnters";		
		case 'MaeCodigClienAnter.clieOidClieNuev.requiered.message': return "El Campo \'\'Cliente nuevo\'\' es obligatorio";
		case 'MaeCodigClienAnter.codClieAnti.requiered.message': return "El Campo \'\'Cliente antiguo\'\' es obligatorio";
		case 'MaeCodigClienAnter.paisOidPais.requiered.message': return "El Campo \'\'Pa�s antiguo\'\' es obligatorio";
		case 'MaeEncueAplicClien.label': return "MaeEncueAplicCliens";
		
		case 'MaeEncueAplicClien.clieOidClie.requiered.message': return "El Campo \'\'C�d. cliente\'\' es obligatorio";
		case 'MaeEncueAplicClien.enseOidEncu.requiered.message': return "El Campo \'\'C�d. encuesta\'\' es obligatorio";
		case 'MaeEncueAplicClien.reenOidResp.requiered.message': return "El Campo \'\'C�d. respuesta\'\' es obligatorio";
		case 'MaeEncueNse.label': return "MaeEncueNses";
		
		case 'MaeEncueNse.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeEncueNse.codTipoEncu.requiered.message': return "El Campo \'\'C�d. encuesta\'\' es obligatorio";
		case 'MaeEncueNse.marcOidMarc.requiered.message': return "El Campo \'\'Marca\'\' es obligatorio";
		case 'MaeEncueNse.prenOidPreg.requiered.message': return "El Campo \'\'C�d. pregunta\'\' es obligatorio";
		case 'MaeEncueNse.valPesoPreg.requiered.message': return "El Campo \'\'Peso pregunta\'\' es obligatorio";
		case 'MaeEncueNse.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeEncueNseView.label': return "MaeEncueNseViews";
		
		case 'MaeEncueNseView.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeEncueNseView.codTipoEncu.requiered.message': return "El Campo \'\'C�d. encuesta\'\' es obligatorio";
		case 'MaeEncueNseView.marcOidMarc.requiered.message': return "El Campo \'\'Marca\'\' es obligatorio";
		case 'MaeEncueNseView.prenOidPreg.requiered.message': return "El Campo \'\'C�d. pregunta\'\' es obligatorio";
		case 'MaeEncueNseView.valPesoPreg.requiered.message': return "El Campo \'\'Peso pregunta\'\' es obligatorio";
		case 'MaeEncueNseView.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeEstadCivil.label': return "MaeEstadCivils";
		
		case 'MaeEstadCivil.codEstaCivi.requiered.message': return "El Campo \'\'Tipo estado civil\'\' es obligatorio";
		case 'MaeEstadCivil.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeEstatClien.label': return "MaeEstatCliens";
		
		case 'MaeEstatClien.codEstaClie.requiered.message': return "El Campo \'\'C�d. estatus\'\' es obligatorio";
		case 'MaeEstatClien.tescOidTipoEsta.requiered.message': return "El Campo \'\'C�d. tipo estatus\'\' es obligatorio";
		case 'MaeEstatClien.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeEstatClienView.label': return "MaeEstatClienViews";
		
		case 'MaeEstatClienView.codEstaClie.requiered.message': return "El Campo \'\'C�d. estatus\'\' es obligatorio";
		case 'MaeEstatClienView.tescOidTipoEsta.requiered.message': return "El Campo \'\'C�d. tipo estatus\'\' es obligatorio";
		case 'MaeEstatClienView.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeEstatProdu.label': return "MaeEstatProdus";
		
		case 'MaeEstatProdu.codEstaProd.requiered.message': return "El Campo \'\'estatus\'\' es obligatorio";
		case 'MaeEstatProdu.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeEstatProdu.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeExencFlete.label': return "MaeExencFletes";
		
		case 'MaeExencFlete.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeExencFlete.indExenFlet.requiered.message': return "El Campo \'\'Ind. exenci�n flete\'\' es obligatorio";
		case 'MaeExencFlete.indExenFlet.1.value': return "Activo";
		case 'MaeExencFlete.indExenFlet.0.value': return "Inactivo";
		case 'MaeExencFlete.ticlOidTipoClie.requiered.message': return "El Campo \'\'Tipo cliente\'\' es obligatorio";
		case 'MaeGener.label': return "MaeGeners";
		
		case 'MaeGener.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeGener.codGene.requiered.message': return "El Campo \'\'Gen�rico\'\' es obligatorio";
		case 'MaeGener.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeLineaProdu.label': return "MaeLineaProdus";
		
		case 'MaeLineaProdu.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeLineaProdu.codLineProd.requiered.message': return "El Campo \'\'L�nea producto\'\' es obligatorio";
		case 'MaeLineaProdu.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeMagni.label': return "MaeMagnis";
		
		case 'MaeMagni.codMagn.requiered.message': return "El Campo \'\'Magnitud\'\' es obligatorio";
		case 'MaeMagni.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeNegoc.label': return "MaeNegocs";
		
		case 'MaeNegoc.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeNegoc.codNego.requiered.message': return "El Campo \'\'Negocio\'\' es obligatorio";
		case 'MaeNegoc.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeNivelEstud.label': return "MaeNivelEstuds";
		
		case 'MaeNivelEstud.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeNivelEstud.codNiveEstu.requiered.message': return "El Campo \'\'Tipo nivel estudios\'\' es obligatorio";
		case 'MaeNivelEstud.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeParamClien.label': return "MaeParamCliens";
		
		case 'MaeParamClien.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeParamClien.codTipoAsig.requiered.message': return "El Campo \'\'Tipo asignaci�n c�digo\'\' es obligatorio";
		case 'MaeParamClien.codTipoAsig.M.value': return "Manual";
		case 'MaeParamClien.codTipoAsig.A.value': return "Automatico";
		case 'MaePreguEncue.label': return "MaePreguEncues";
		
		case 'MaePreguEncue.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaePreguEncue.codPreg.requiered.message': return "El Campo \'\'C�d. pregunta\'\' es obligatorio";
		case 'MaePreguEncue.Descripcion.requiered.message': return "El Campo \'\'Texto pregunta\'\' es obligatorio";
		case 'MaePreguEncue.enseOidEncu.requiered.message': return "El Campo \'\'Encuesta\'\' es obligatorio";
		case 'MaePreguEncue.valPesoPreg.requiered.message': return "El Campo \'\'Peso de la pregunta\'\' es obligatorio";

		case 'MaeProdu.label': return "Maestro de Productos";		
		case 'MaeProdu.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";
		case 'MaeProdu.codSap.requiered.message': return "El campo \'\'C�d. Sap\'\' es obligatorio";
		
		case 'MaeRespuEncue.label': return "MaeRespuEncues";
		case 'MaeRespuEncue.prenOidPreg.requiered.message': return "El Campo \'\'C�d. pregunta\'\' es obligatorio";
		case 'MaeRespuEncue.codResp.requiered.message': return "El Campo \'\'C�d. respuesta\'\' es obligatorio";
		case 'MaeRespuEncue.valPeso.requiered.message': return "El Campo \'\'Peso respuesta\'\' es obligatorio";
		case 'MaeRespuEncue.Descripcion.requiered.message': return "El Campo \'\'Texto respuesta\'\' es obligatorio";
		case 'MaeSubtiClien.label': return "MaeSubtiCliens";
		
		case 'MaeSubtiClien.codSubtClie.requiered.message': return "El Campo \'\'C�d. subtipo cliente\'\' es obligatorio";
		case 'MaeSubtiClien.ticlOidTipoClie.requiered.message': return "El Campo \'\'C�d. tipo cliente\'\' es obligatorio";
		case 'MaeSubtiClien.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeSubtiClienView.label': return "MaeSubtiClienViews";
		
		case 'MaeSubtiClienView.codSubtClie.requiered.message': return "El Campo \'\'C�d. subtipo\'\' es obligatorio";
		case 'MaeSubtiClienView.ticlOidTipoClie.requiered.message': return "El Campo \'\'C�d. tipo cliente\'\' es obligatorio";
		case 'MaeSubtiClienView.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeSuperGener.label': return "MaeSuperGeners";
		
		case 'MaeSuperGener.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeSuperGener.codSupeGene.requiered.message': return "El Campo \'\'Supergen�rico\'\' es obligatorio";
		case 'MaeSuperGener.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoBloqu.label': return "MaeTipoBloqus";
		
		case 'MaeTipoBloqu.codTipoBloq.requiered.message': return "El Campo \'\'C�d. bloqueo\'\' es obligatorio";
		case 'MaeTipoBloqu.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoClasiClien.label': return "MaeTipoClasiCliens";
		
		case 'MaeTipoClasiClien.sbtiOidSubtClie.requiered.message': return "El Campo \'\'Subtipo cliente\'\' es obligatorio";
		case 'MaeTipoClasiClien.codTipoClas.requiered.message': return "El Campo \'\'Tipo clasificaci�n\'\' es obligatorio";
		case 'MaeTipoClasiClien.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoClasiClienView.label': return "MaeTipoClasiClienViews";
		
		case 'MaeTipoClasiClienView.sbtiOidSubtClie.requiered.message': return "El Campo \'\'Subtipo cliente\'\' es obligatorio";
		case 'MaeTipoClasiClienView.codTipoClas.requiered.message': return "El Campo \'\'Tipo clasificaci�n\'\' es obligatorio";
		case 'MaeTipoClasiClienView.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoClien.label': return "MaeTipoCliens";
		
		case 'MaeTipoClien.codTipoClie.requiered.message': return "El Campo \'\'C�d. tipo cliente\'\' es obligatorio";
		case 'MaeTipoClien.indEvalEsta.requiered.message': return "El Campo \'\'Ind. evaluar estatus\'\' es obligatorio";
		case 'MaeTipoClien.indEvalEsta.1.value': return "Si";
		case 'MaeTipoClien.indEvalEsta.0.value': return "No";
		case 'MaeTipoClien.indEmpl.1.value': return "Si";
		case 'MaeTipoClien.indEmpl.0.value': return "No";
		case 'MaeTipoClien.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";

		case 'MaeTipoEstatClien.codTipoEsta.requiered.message': return "El Campo \'\'Tipo estatus cliente\'\' es obligatorio";		
		case 'MaeTipoEstatClien.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";				
		case 'MaeTipoEstatClien.marcOidMarc.requiered.message': return "El Campo \'\'Marca\'\' es obligatorio";				
		
		case 'MaeTipoComun.label': return "MaeTipoComuns";
		
		case 'MaeTipoComun.codTipoComu.requiered.message': return "El Campo \'\'Tipo comunicaci�n\'\' es obligatorio";
		case 'MaeTipoComun.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoDirec.label': return "MaeTipoDirecs";
		
		case 'MaeTipoDirec.codTipoDire.requiered.message': return "El Campo \'\'Tipo direcci�n\'\' es obligatorio";
		case 'MaeTipoDirec.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoDocum.label': return "MaeTipoDocums";
		
		case 'MaeTipoDocum.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeTipoDocum.codTipoDocu.requiered.message': return "El Campo \'\'Tipo documento\'\' es obligatorio";
		case 'MaeTipoDocum.indObli.requiered.message': return "El Campo \'\'Ind. obligatorio\'\' es obligatorio";
		case 'MaeTipoDocum.indObli.1.value': return "Si";
		case 'MaeTipoDocum.indObli.0.value': return "No";
		case 'MaeTipoDocum.indDni.requiered.message': return "El Campo \'\'DNI\'\' es obligatorio";
		case 'MaeTipoDocum.indDni.1.value': return "Si";
		case 'MaeTipoDocum.indDni.0.value': return "No";
		case 'MaeTipoDocum.indDocIdenFisc.requiered.message': return "El Campo \'\'NIF\'\' es obligatorio";
		case 'MaeTipoDocum.indDocIdenFisc.1.value': return "Si";
		case 'MaeTipoDocum.indDocIdenFisc.0.value': return "No";
		case 'MaeTipoDocum.tidoOidTipoDocu.requiered.message': return "El Campo \'\'Tipo documento legal\'\' es obligatorio";
		case 'MaeTipoDocum.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeEstatClien.label': return "MaeEstatCliens";
		
		case 'MaeEstatClien.codEstaClie.requiered.message': return "El Campo \'\'C�d. estatus\'\' es obligatorio";
		case 'MaeEstatClien.tescOidTipoEsta.requiered.message': return "El Campo \'\'C�d. tipo estatus\'\' es obligatorio";
		case 'MaeEstatClien.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeEstatClienView.label': return "MaeEstatClienViews";
		
		case 'MaeEstatClienView.codEstaClie.requiered.message': return "El Campo \'\'C�d. estatus\'\' es obligatorio";
		case 'MaeEstatClienView.tescOidTipoEsta.requiered.message': return "El Campo \'\'C�d. tipo estatus\'\' es obligatorio";
		case 'MaeEstatClienView.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoNivelSocecPerso.label': return "MaeTipoNivelSocecPersos";
		
		case 'MaeTipoNivelSocecPerso.codNsep.requiered.message': return "El Campo \'\'C�d. NSEP\'\' es obligatorio";
		case 'MaeTipoNivelSocecPerso.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeTipoNivelSocecPerso.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoPerfiPsico.label': return "MaeTipoPerfiPsicos";
		
		case 'MaeTipoPerfiPsico.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeTipoPerfiPsico.codTipoPerfPsic.requiered.message': return "El Campo \'\'Tipo perfil psicogr�fico\'\' es obligatorio";
		case 'MaeTipoPerfiPsico.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoPrefe.label': return "MaeTipoPrefes";
		
		case 'MaeTipoPrefe.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeTipoPrefe.codTipoPref.requiered.message': return "El Campo \'\'C�d. preferencias\'\' es obligatorio";
		case 'MaeTipoPrefe.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoProbl.label': return "MaeTipoProbls";
		
		case 'MaeTipoProbl.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeTipoProbl.codTipoProb.requiered.message': return "El Campo \'\'C�d. tipo problema\'\' es obligatorio";
		case 'MaeTipoProbl.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoProblTipoSoluc.label': return "MaeTipoProblTipoSolucs";
		
		case 'MaeTipoProblTipoSoluc.tipbOidTipoProb.requiered.message': return "El Campo \'\'C�d. tipo problema\'\' es obligatorio";
		case 'MaeTipoProblTipoSoluc.tsocOidTipoSolu.requiered.message': return "El Campo \'\'C�d. tipo soluci�n\'\' es obligatorio";
		case 'MaeTipoSoluc.label': return "MaeTipoSolucs";
		
		case 'MaeTipoSoluc.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeTipoSoluc.codTipoSolu.requiered.message': return "El Campo \'\'C�d. tipo soluci�n\'\' es obligatorio";
		case 'MaeTipoSoluc.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoTarje.label': return "MaeTipoTarjes";
		
		case 'MaeTipoTarje.codTipoTarj.requiered.message': return "El Campo \'\'Tipos tarjeta\'\' es obligatorio";
		case 'MaeTipoTarje.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeTipoVincu.label': return "MaeTipoVincus";
		
		case 'MaeTipoVincu.codTipoVinc.requiered.message': return "El Campo \'\'Tipo v�nculo\'\' es obligatorio";
		case 'MaeTipoVincu.indReco.requiered.message': return "El Campo \'\'Recomendada/recomendante\'\' es obligatorio";
		case 'MaeTipoVincu.indReco.1.value': return "Si";
		case 'MaeTipoVincu.indReco.0.value': return "No";
		case 'MaeTipoVincu.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MaeUnidaMedid.label': return "MaeUnidaMedids";
		
		case 'MaeUnidaMedid.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeUnidaMedid.codUnidMedi.requiered.message': return "El Campo \'\'Unidad medida\'\' es obligatorio";
		case 'MaeUnidaMedid.magnOidMagn.requiered.message': return "El Campo \'\'Magnitud\'\' es obligatorio";
		case 'MaeUnidaMedid.indUmStnd.1.value': return "Si";
		case 'MaeUnidaMedid.indUmStnd.0.value': return "No";
		case 'MaeUnidaMedid.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		
		// splatas - DBLG500000808	
		case 'MaeUnidaMedid.indUmStnd.requiered.message': return "El Campo \'\'Ind. UM est�ndar\'\' es obligatorio";

		case 'MaeUnidaNegoc.label': return "MaeUnidaNegocs";
		
		case 'MaeUnidaNegoc.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MaeUnidaNegoc.codUnidNego.requiered.message': return "El Campo \'\'Unidad negocio\'\' es obligatorio";
		case 'MaeUnidaNegoc.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
				case 'MsgMedioEnvio.label': return "MsgMedioEnvios";
		
		case 'MsgMedioEnvio.codMediEnvi.requiered.message': return "El Campo \'\'codMediEnvi\'\' es obligatorio";
		case 'MsgMedioEnvio.desMediEnvi.requiered.message': return "El Campo \'\'desMediEnvi\'\' es obligatorio";
		case 'MsgMedioEnvioPais.label': return "MsgMedioEnvioPaiss";
		
		case 'MsgMedioEnvioPais.paisOidPais.requiered.message': return "El Campo \'\'Pa�s\'\' es obligatorio";
		case 'MsgMedioEnvioPais.meenOidMediEnvi.requiered.message': return "El Campo \'\'C�d. medio env�o\'\' es obligatorio";
		case 'MsgMedioEnvioPais.codEsta.requiered.message': return "El Campo \'\'Estado\'\' es obligatorio";
		case 'MsgMedioEnvioPais.codEsta.A.value': return "Activo";
		case 'MsgMedioEnvioPais.codEsta.D.value': return "Desactivo";

		case 'MsgMensa.label': return "MsgMensas";		
		case 'MsgMensa.codMens.requiered.message': return "El campo \'\'C�digo de Mensaje\'\' es obligatorio";
		case 'MsgMensa.desMens.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'MsgMensa.valText.requiered.message': return "El campo \'\'Valor\'\' es obligatorio";

		case 'MsgMetac.label': return "MsgMetacs";
		case 'MsgMetac.codMeta.requiered.message': return "El Campo \'\'C�digo\'\' es obligatorio";
		case 'MsgMetac.valLiteIden.requiered.message': return "El Campo \'\'Literal identificador\'\' es obligatorio";
		case 'MsgMetac.valEsta.requiered.message': return "El Campo \'\'Estado\'\' es obligatorio";
		case 'MsgMetac.valEsta.A.value': return "Activo";
		case 'MsgMetac.valEsta.D.value': return "Desactivo";
		case 'MsgMetac.timeOidTipo.requiered.message': return "El Campo \'\'Tipo metacar�cter\'\' es obligatorio";
		case 'MsgMetac.Descripcion.requiered.message': return "El Campo \'\'Descripci�n metacar�cter\'\' es obligatorio";		

		case 'MsgParamMensa.label': return "MsgParamMensas";		
		case 'MsgParamMensa.codDatoVari.requiered.message': return "El Campo \'\'C�d. variable\'\' es obligatorio";
		case 'MsgParamMensa.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'MsgParamMensa.desDatoVari.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'MsgParamMensa.fecSist.requiered.message': return "El Campo \'\'Fecha\'\' es obligatorio";
		case 'MsgTipoMensa.label': return "MsgTipoMensas";
		
		case 'MsgTipoMensa.codTipoMens.requiered.message': return "El Campo \'\'codTipoMens\'\' es obligatorio";
		case 'MsgTipoMetac.label': return "MsgTipoMetacs";
		
		case 'MsgTipoMetac.codTipo.requiered.message': return "El Campo \'\'codTipo\'\' es obligatorio";

		case 'PedAsignAlmac.label': return "Asignaci�n almac�n";		
		case 'PedAsignAlmac.sbacOidSbac.requiered.message': return "El campo \'\'Subacceso\'\' es obligatorio";
		case 'PedAsignAlmac.marcOidMarc.requiered.message': return "El campo \'\'Marca\'\' es obligatorio";
		case 'PedAsignAlmac.almcOidAlma.requiered.message': return "El campo \'\'Almac�n\'\' es obligatorio";
		case 'PedAsignAlmac.paisOidPais.requiered.message': return "El campo \'\'Pa�s\'\' es obligatorio";

		case 'PedAtribEspec.label': return "PedAtribEspecs";
		case 'PedAtribEspec.codAtri.requiered.message': return "El Campo \'\'codAtri\'\' es obligatorio";
		case 'PedAtribEspec.desAtri.requiered.message': return "El Campo \'\'desAtri\'\' es obligatorio";
		case 'PedAtribEspec.moduOidModu.requiered.message': return "El Campo \'\'moduOidModu\'\' es obligatorio";
		
		case 'PedClaseSolic.label': return "Clase solicitud";
		case 'PedClaseSolic.codClasSoli.requiered.message': return "El campo \'\'C�d. clase solicitud\'\' es obligatorio";
		case 'PedClaseSolic.indOrdeComp.requiered.message': return "El campo \'\'Ind. orden de compra\'\' es obligatorio";
		case 'PedClaseSolic.indOrdeComp.1.value': return "Si";
		case 'PedClaseSolic.indOrdeComp.0.value': return "No";
		case 'PedClaseSolic.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		
		case 'PedImpueGener.sbacOidSbac.requiered.message': return "El campo \'\'Subacceso\'\' es obligatorio";
		case 'PedImpueGener.taimOidTasaImpu.requiered.message': return "El campo \'\'Tasa Impuesto\'\' es obligatorio";

		case 'PedImpueGener.indTasaUnic.1.value': return 'Si';
		case 'PedImpueGener.indTasaUnic.0.value': return 'No';

		case 'PedImpueGener.sbacOidSbac.requiered.message': return "El campo \'\'Subacceso\'\' es obligatorio";
		case 'PedImpueGener.taimOidTasaImpu.requiered.message': return "El campo \'\'Tasa Impuesto\'\' es obligatorio";

		
		case 'PedImpueNegoc.sbacOidSbac.requiered.message': return "El campo \'\'Subacceso\'\' es obligatorio";
		case 'PedImpueNegoc.negoOidNego.requiered.message': return "El campo \'\'Negocio\'\' es obligatorio";
		case 'PedImpueNegoc.taimOidTasaImpu.requiered.message': return "El campo \'\'Tasa Impuesto\'\' es obligatorio";		

		// splatas - 13/10/2005
		case 'PedProce.codProc.requiered.message': return "El campo \'\'C�d. proc.\'\' es obligatorio";		
		case 'PedProce.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'PedProce.grprOidGrupProc.requiered.message': return "El campo \'\'Grupo proceso\'\' es obligatorio";	

		case 'PedSubtiPosic.label': return "Subtipo posiciones";		
		case 'PedSubtiPosic.codSubtPosi.requiered.message': return "El campo \'\'C�d. subtipo posici�n\'\' es obligatorio";
		case 'PedSubtiPosic.tposOidTipoPosi.requiered.message': return "El campo \'\'Tipo posici�n\'\' es obligatorio";
		case 'PedSubtiPosic.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'PedTasaImpue.label': return "PedTasaImpues";
		case 'PedTasaImpue.valTasaImpu.requiered.message': return "El Campo \'\'Tasa impuestos\'\' es obligatorio";
		case 'PedTasaImpue.valIndiImpu.requiered.message': return "El Campo \'\'Ind. impuestos\'\' es obligatorio";
		case 'PedTasaImpue.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'PedTasaImpue.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";

		case 'PedTipoDespa.label': return "Tipo despacho";
		case 'PedTipoDespa.paisOidPais.requiered.message': return "El campo \'\'Pais\'\' es obligatorio";
		case 'PedTipoDespa.codTipoDesp.requiered.message': return "El campo \'\'C�d. tipo despacho\'\' es obligatorio";
		case 'PedTipoDespa.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		case 'PedTipoPosic.label': return "Tipo posiciones";		
		case 'PedTipoPosic.codTipoPosi.requiered.message': return "El campo \'\'C�d. tipo posici�n\'\' es obligatorio";
		case 'PedTipoPosic.indDemaNorm.1.value': return "Si";
		case 'PedTipoPosic.indDemaNorm.0.value': return "No";
		case 'PedTipoPosic.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";

		// splatas - 04/10/2005 
		case 'PedUmbraFalta.negoOidNego.requiered.message': return "El campo \'\'Negocio\'\' es obligatorio"; 
        case 'PedUmbraFalta.valUmbrFalt.requiered.message': return "El campo \'\'Umbral faltantes\'\' es obligatorio"; 


		case 'PreArgumVenta.label': return "PreArgumVentas";
		case 'PreArgumVenta.codArguVent.requiered.message': return "El Campo \'\'C�d. argumento venta\'\' es obligatorio";

		case 'PreCatal.label': return "PreCatals";
		
		case 'PreCatal.codCata.requiered.message': return "El Campo \'\'C�digo\'\' es obligatorio";
		case 'PreCatal.desCata.requiered.message': return "El Campo \'\'Descripci�n cat�logo\'\' es obligatorio";
		case 'PreCatal.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'PreCatalOrden.label': return "PreCatalOrdens";
		
		case 'PreCatalOrden.numOrde.requiered.message': return "El Campo \'\'N� orden\'\' es obligatorio";
		case 'PreCatalOrden.ocatOidCata.requiered.message': return "El Campo \'\'Cat�logo\'\' es obligatorio";
		case 'PreCatalOrden.marcOidMarc.requiered.message': return "El Campo \'\'Marca\'\' es obligatorio";
		case 'PreCatalOrden.canaOidCana.requiered.message': return "El Campo \'\'Canal\'\' es obligatorio";
		case 'PreCicloVida.label': return "PreCicloVidas";
		
		case 'PreCicloVida.codCiclVida.requiered.message': return "El Campo \'\'C�d. ciclo vida\'\' es obligatorio";
		case 'PreCondiPromo.label': return "PreCondiPromos";
		
		case 'PreCondiPromo.codCondProm.requiered.message': return "El Campo \'\'C�d. condici�n\'\' es obligatorio";
		case 'PreConfiGp.label': return "PreConfiGps";
		
		case 'PreConfiGp.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'PreConfiGp.marcOidMarc.requiered.message': return "El Campo \'\'Marca\'\' es obligatorio";
		case 'PreConfiGp.canaOidCana.requiered.message': return "El Campo \'\'Canal\'\' es obligatorio";
		case 'PreConfiGp.valIncr.requiered.message': return "El Campo \'\'Incremento p�gina\'\' es obligatorio";
		case 'PreIndicCuadr.label': return "PreIndicCuadrs";
		
		case 'PreIndicCuadr.codIndiCuad.requiered.message': return "El Campo \'\'C�d. indicador cuadre\'\' es obligatorio";
		case 'PreIndicCuadr.valFactCuad.requiered.message': return "El Campo \'\'Factor cuadre\'\' es obligatorio";
		case 'PreIndicCuadr.valFactCuad.U.value': return "Unidades";
		case 'PreIndicCuadr.valFactCuad.M.value': return "Monto";
		case 'PreIndicCuadr.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'PreIndicCuadrTipoEstra.label': return "PreIndicCuadrTipoEstras";
		
		case 'PreIndicCuadrTipoEstra.indcOidIndiCuad.requiered.message': return "El Campo \'\'Indicador cuadre\'\' es obligatorio";
		case 'PreIndicCuadrTipoEstra.tiesOidTipoEstr.requiered.message': return "El Campo \'\'Tipo estrategia\'\' es obligatorio";
		case 'PreTipoEstra.label': return "PreTipoEstras";
		
		case 'PreTipoEstra.codTipoEstr.requiered.message': return "El Campo \'\'codTipoEstr\'\' es obligatorio";
		case 'PreTipoEstra.desTipoEstr.requiered.message': return "El Campo \'\'desTipoEstr\'\' es obligatorio";
		case 'PreTipoOfert.label': return "PreTipoOferts";
		
		case 'PreTipoOfert.canaOidCana.requiered.message': return "El Campo \'\'Canal\'\' es obligatorio";
		case 'PreTipoOfert.codTipoOfer.requiered.message': return "El Campo \'\'C�d. tipo oferta\'\' es obligatorio";
		case 'PreTipoOfert.Descripcion.requiered.message': return "El Campo \'\'Descripci�n tipo oferta\'\' es obligatorio";
		case 'PreTipoProdu.label': return "PreTipoProdus";
		
		case 'PreTipoProdu.codTipoProd.requiered.message': return "El Campo \'\'codTipoProd\'\' es obligatorio";
		
		case 'RecAutor.label': return "Autorizaciones";		
		case 'RecAutor.codUsua.requiered.message': return "El campo \'\'C�d. usuario\'\' es obligatorio";
		case 'RecAutor.tiopOidTipoOper.requiered.message': return "El campo \'\'Tipo operaci�n\'\' es obligatorio";
		case 'RecAutor.indIngr.1.value': return "Si";
		case 'RecAutor.indIngr.0.value': return "No";
		case 'RecAutor.indDesb.1.value': return "Si";
		case 'RecAutor.indDesb.0.value': return "No";
		case 'RecAutor.paisOidPais.requiered.message': return "El campo \'\'Pais\'\' es obligatorio";
		case 'RecMotivBloqu.label': return "RecMotivBloqus";		
		case 'RecMotivBloqu.valMotiBloq.requiered.message': return "El campo \'\'C�d. bloqueo\'\' es obligatorio";
		case 'RecMotivBloqu.paisOidPais.requiered.message': return "El campo \'\'Pais\'\' es obligatorio";
		case 'RecMotivBloqu.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'RecMotivDevol.label': return "Motivos de devoluci�n de reclamos";		
		case 'RecMotivDevol.codMotiDevo.requiered.message': return "El campo \'\'C�d. motivo devoluci�n\'\' es obligatorio";
		case 'RecMotivDevol.paisOidPais.requiered.message': return "El campo \'\'Pais\'\' es obligatorio";
		case 'RecMotivDevol.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'RecMotivDevolOpera.label': return "Motivos devoluci�n de reclamos por operaci�n";		
		case 'RecMotivDevolOpera.ropeOidOper.requiered.message': return "El campo \'\'C�d. operaci�n\'\' es obligatorio";
		case 'RecMotivDevolOpera.modvOidMotiDevo.requiered.message': return "El campo \'\'Motivo devoluci�n reclamos\'\' es obligatorio";
		case 'RecMotivDevolOpera.paisOidPais.requiered.message': return "El campo \'\'Pais\'\' es obligatorio";
		case 'RecMotivRechaDesbl.label': return "Motivo de desbloqueo/rechazo de reclamos";		
		case 'RecMotivRechaDesbl.paisOidPais.requiered.message': return "El campo \'\'Pais\'\' es obligatorio";
		case 'RecMotivRechaDesbl.codRechDesb.requiered.message': return "El campo \'\'C�d. desbloqueo/rechazo\'\' es obligatorio";
		case 'RecMotivRechaDesbl.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'RecParamNmper.label': return "Parametrizaci�n NMP por tipo de cliente";		
		case 'RecParamNmper.ticlOidTipoClie.requiered.message': return "El campo \'\'Tipo cliente\'\' es obligatorio";
		case 'RecParamNmper.pperOidPrecPerd.requiered.message': return "El campo \'\'Precio a aplicar\'\' es obligatorio";
		case 'RecParamNmper.valPorcReca.requiered.message': return "El campo \'\'% recargo a aplicar sobre precio\'\' es obligatorio";
		case 'RecParamNmper.indParaModi.1.value': return "Si";
		case 'RecParamNmper.indParaModi.0.value': return "No";
		case 'RecParamNmper.paisOidPais.requiered.message': return "El campo \'\'dPais\'\' es obligatorio";
		case 'RecResulChequ.label': return "Tipos de resultados de chequeos";		
		case 'RecResulChequ.paisOidPais.requiered.message': return "El campo \'\'Pais\'\' es obligatorio";
		case 'RecResulChequ.codResuCheq.requiered.message': return "El campo \'\'C�d. resultados chequeos\'\' es obligatorio";
		case 'RecResulChequ.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'RecResulChequ.indResu.requiered.message': return "El campo \'\'Resultado\'\' es obligatorio";
		case 'RecResulChequ.indResu.1.value': return "Si";
		case 'RecResulChequ.indResu.0.value': return "No";

		case 'SegAcces.label': return "SegAccess";
		case 'SegAcces.canaOidCana.requiered.message': return "El Campo \'\'Canal\'\' es obligatorio";
		case 'SegAcces.codAcce.requiered.message': return "El Campo \'\'C�d. acceso\'\' es obligatorio";
		case 'SegAcces.indAcce.requiered.message': return "El Campo \'\'Ind. acceso\'\' es obligatorio";
		case 'SegAcces.indAcce.C.value': return "Call Center";
		case 'SegAcces.indAcce.B.value': return "Belcenter";
		case 'SegAcces.indAcce.G.value': return "Gerente";
		case 'SegAcces.indAcce.O.value': return "Otros";
		case 'SegAcces.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'SegCanal.label': return "SegCanals";
		
		case 'SegCanal.codCana.requiered.message': return "El Campo \'\'C�d. canal\'\' es obligatorio";
		case 'SegCanal.tipeOidTipoPeri.requiered.message': return "El Campo \'\'Tipo per�odo\'\' es obligatorio";
		case 'SegCanal.Descripcion.requiered.message': return "El Campo \'\'Descripci�n canal\'\' es obligatorio";
		case 'SegCanalView.label': return "SegCanalViews";
		
		case 'SegCanalView.codCana.requiered.message': return "El Campo \'\'C�d. canal\'\' es obligatorio";
		case 'SegCanalView.tipeOidTipoPeri.requiered.message': return "El Campo \'\'Tipo per�odo\'\' es obligatorio";
		case 'SegCanalView.Descripcion.requiered.message': return "El Campo \'\'Descripci�n canal\'\' es obligatorio";
		case 'SegDeptoEmpre.label': return "SegDeptoEmpres";
		
		case 'SegDeptoEmpre.codDpto.requiered.message': return "El Campo \'\'C�d. departamento\'\' es obligatorio";
		case 'SegDeptoEmpre.desCortDpto.requiered.message': return "El Campo \'\'Descripci�n corta\'\' es obligatorio";
		case 'SegDeptoEmpre.Descripcion.requiered.message': return "El Campo \'\'Descripci�n larga\'\' es obligatorio";
		case 'SegIdiom.label': return "SegIdioms";
		
		case 'SegIdiom.codIdio.requiered.message': return "El Campo \'\'C�d. idioma\'\' es obligatorio";
		case 'SegIdiom.codIsoIdio.requiered.message': return "El Campo \'\'C�d. ISO\'\' es obligatorio";
		case 'SegIdiom.Descripcion.requiered.message': return "El Campo \'\'Descripci�n idioma\'\' es obligatorio";
		case 'SegMarca.label': return "SegMarcas";
		
		case 'SegMarca.codMarc.requiered.message': return "El Campo \'\'C�d. marca\'\' es obligatorio";
		case 'SegMarca.desMarc.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'SegMarcaCorpoMarcaProdu.label': return "SegMarcaCorpoMarcaProdus";
		
		case 'SegMarcaCorpoMarcaProdu.marcOidMarc.requiered.message': return "El Campo \'\'Marca corporativa\'\' es obligatorio";
		case 'SegMarcaCorpoMarcaProdu.maprOidMarcProd.requiered.message': return "El Campo \'\'Marca producto\'\' es obligatorio";
		case 'SegMarcaCorpoMarcaProdu.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'SegMarcaProdu.label': return "SegMarcaProdus";
		
		case 'SegMarcaProdu.codMarcProd.requiered.message': return "El Campo \'\'C�d. marca producto\'\' es obligatorio";
		case 'SegMarcaProdu.desMarcProd.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'SegModul.label': return "SegModuls";
		
		case 'SegModul.codModu.requiered.message': return "El Campo \'\'C�d. m�dulo\'\' es obligatorio";
		case 'SegModul.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'SegMoned.label': return "SegMoneds";
		
		case 'SegMoned.codMone.requiered.message': return "El Campo \'\'C�d. moneda\'\' es obligatorio";
		case 'SegMoned.numDeci.requiered.message': return "El Campo \'\'N� decimales\'\' es obligatorio";
		case 'SegMoned.numDeci.0.value': return "0";
		case 'SegMoned.numDeci.1.value': return "1";
		case 'SegMoned.numDeci.2.value': return "2";
		case 'SegMoned.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'SegNacio.label': return "SegNacios";
		
		case 'SegNacio.codNaci.requiered.message': return "El Campo \'\'C�d. nacionalidad\'\' es obligatorio";
		case 'SegNacio.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";

		case 'SegPais.label': return "Pa�s";
		case 'SegPais.codPais.requiered.message': return "El Campo \'\'C�d. Pa�s\'\' es obligatorio";
		case 'SegPais.moneOidMone.requiered.message': return "El Campo \'\'C�d. moneda\'\' es obligatorio";
		case 'SegPais.moneOidMone.cmbValueIncorrecto.message': return "El valor de \'\'Moneda\'\' debe ser distinto al de \'\'Moneda alternativa\'\'";
		case 'SegPais.Descripcion.requiered.message': return "El campo \'\'Descripci�n\'\' es obligatorio";
		case 'SegPais.valIden.requiered.message': return "El Campo \'\'Identificador\'\' es obligatorio";
		case 'SegPais.valIden.B.value': return "Boleta";
		case 'SegPais.valIden.F.value': return "Factura";
		case 'SegPais.valProgEjec.requiered.message': return "El Campo \'\'Programa ejecuci�n\'\' es obligatorio";
		case 'SegPais.valPorcAlar.requiered.message': return "El Campo \'\'Porcentaje alarma\'\' es obligatorio";
		case 'SegPais.numDiasMora.requiered.message': return "El Campo \'\'D�as mora\'\' es obligatorio";
		case 'SegPais.indSaldUnic.requiered.message': return "El Campo \'\'Saldo �nico\'\' es obligatorio";
		case 'SegPais.indSaldUnic.1.value': return "Si";
		case 'SegPais.indSaldUnic.0.value': return "No";
		case 'SegPais.indInteGis.requiered.message': return "El Campo \'\'Integraci�n\'\' es obligatorio";
		case 'SegPais.indInteGis.I.value': return "GIS";
		case 'SegPais.indInteGis.G.value': return "Georreferenciador";
		case 'SegPais.indCompAuto.requiered.message': return "El Campo \'\'Compensaci�n autom�tica\'\' es obligatorio";
		case 'SegPais.indCompAuto.1.value': return "Si";
		case 'SegPais.indCompAuto.0.value': return "No";
		case 'SegPais.indTratAcumDesc.requiered.message': return "El Campo \'\'Tratamiento acumulativo descuentos\'\' es obligatorio";
		case 'SegPais.indTratAcumDesc.1.value': return "Si";
		case 'SegPais.indTratAcumDesc.0.value': return "No";
		case 'SegPais.valTiemRezo.requiered.message': return "El Campo \'\'Tiempo rezonificaci�n\'\' es obligatorio";
		case 'SegPais.valConfSecuCcc.requiered.message': return "El Campo \'\'Configuraci�n secuencial CCC\'\' es obligatorio";
		case 'SegPais.valConfSecuCcc.U.value': return "�nico";
		case 'SegPais.valConfSecuCcc.A.value': return "A�o";
		case 'SegPais.valConfSecuCcc.M.value': return "Mes y a�o";
		case 'SegPais.numLimiDifePago.requiered.message': return "El Campo \'\'L�mite diferencia pago\'\' es obligatorio";
		case 'SegPais.valMaxiDifeAnlsComb.requiered.message': return "El Campo \'\'M�xima diferencia an�lisis combinatorio\'\' es obligatorio";
		case 'SegPais.numDiasFact.requiered.message': return "El Campo \'\'N� d�as fecha facturaci�n\'\' es obligatorio";
		case 'SegPais.numPosiNumeClie.requiered.message': return "El Campo \'\'Longitud c�d. cliente\'\' es obligatorio";
		case 'SegPais.moneOidMoneAlt.requiered.message': return "El Campo \'\'Moneda alternativa\'\' es obligatorio";
		case 'SegPais.indEmisVenc.requiered.message': return "El Campo \'\'Emisi�n vencimiento\'\' es obligatorio";
		case 'SegPais.indEmisVenc.1.value': return "Si";
		case 'SegPais.indEmisVenc.0.value': return "No";
		case 'SegPais.valFormFech.requiered.message': return "El Campo \'\'Formato fecha\'\' es obligatorio";
		case 'SegPais.valFormFech.dd/mm/aaaa.value': return "dd/mm/aaaa";
		case 'SegPais.valFormFech.mm/dd/aaaa.value': return "mm/dd/aaaa";
		case 'SegPais.valFormFech.dd-mm-aaaa.value': return "dd-mm-aaaa";
		case 'SegPais.valSepaMile.requiered.message': return "El Campo \'\'Separador miles\'\' es obligatorio";
		case 'SegPais.valSepaMile.,.value': return ",";
		case 'SegPais.valSepaMile...value': return ".";
		case 'SegPais.valSepaMile.cmbValueIncorrecto.message': return "El valor de \'\'Separador miles\'\' debe ser distinto al de \'\'Separador decimal\'\'";
		case 'SegPais.valSepaDeci.requiered.message': return "El Campo \'\'Separador decimales\'\' es obligatorio";
		case 'SegPais.valSepaDeci.,.value': return ",";
		case 'SegPais.valSepaDeci...value': return ".";
		case 'SegPais.numPeriEgre.requiered.message': return "El Campo \'\'N� per�odos egreso\'\' es obligatorio";
		case 'SegPais.numPeriReti.requiered.message': return "El Campo \'\'N� per�odos retiro\'\' es obligatorio";
		case 'SegPais.valUrl.requiered.message': return "El Campo \'\'URL\'\' es obligatorio";
		case 'SegPais.indFletZonaUbig.requiered.message': return "El Campo \'\'Ind. flete-zona ubigeo\'\' es obligatorio";
		case 'SegPais.indFletZonaUbig.U.value': return "Ubigeo";
		case 'SegPais.indFletZonaUbig.Z.value': return "Zona";
		case 'SegPais.valIndiSecuMoni.requiered.message': return "El Campo \'\'Ind. secuencia monitor\'\' es obligatorio";
		case 'SegPais.valIndiSecuMoni.1.value': return "Si";
		case 'SegPais.valIndiSecuMoni.0.value': return "No";
		case 'SegPais.indSecu.M.value': return "M";
		case 'SegPais.indSecu.T.value': return "T";
		case 'SegPais.indBalaAreaCheq.P.value': return "P";
		case 'SegPais.indBalaAreaCheq.C.value': return "C";
		case 'SegPais.indImpuIncl.requiered.message': return "El campo \'\'Indicador impuesto incluido\'\' es obligatorio";
		case 'SegPais.indImpuIncl.1.value': return "Si";
		case 'SegPais.indImpuIncl.0.value': return "No";

		//Agregado Jrivas 25/11/2004
		case 'SegPais.indImpuIncl.label': return "Ind. Impuesto Incluido";
		case 'SegPais.indImpuIncl.1.label': return "Si";
		case 'SegPais.indImpuIncl.0.label': return "No";


		case 'SegPaisView.label': return "SegPaisViews";
		
		case 'SegPaisView.codPais.requiered.message': return "El Campo \'\'C�d. Pa�s\'\' es obligatorio";
		case 'SegPaisView.moneOidMone.requiered.message': return "El Campo \'\'C�d. moneda\'\' es obligatorio";
		case 'SegPaisView.valIden.requiered.message': return "El Campo \'\'Identificador\'\' es obligatorio";
		case 'SegPaisView.valIden.B.value': return "Boleta";
		case 'SegPaisView.valIden.F.value': return "Factura";
		case 'SegPaisView.valProgEjec.requiered.message': return "El Campo \'\'Programa ejecuci�n\'\' es obligatorio";
		case 'SegPaisView.valPorcAlar.requiered.message': return "El Campo \'\'Porcentaje alarma\'\' es obligatorio";
		case 'SegPaisView.numDiasMora.requiered.message': return "El Campo \'\'D�as mora\'\' es obligatorio";
		case 'SegPaisView.indSaldUnic.requiered.message': return "El Campo \'\'Saldo �nico\'\' es obligatorio";
		case 'SegPaisView.indSaldUnic.1.value': return "Si";
		case 'SegPaisView.indSaldUnic.0.value': return "No";
		case 'SegPaisView.indInteGis.requiered.message': return "El Campo \'\'Integraci�n\'\' es obligatorio";
		case 'SegPaisView.indInteGis.I.value': return "GIS";
		case 'SegPaisView.indInteGis.G.value': return "Georreferenciador";
		case 'SegPaisView.indCompAuto.requiered.message': return "El Campo \'\'Compensaci�n autom�tica\'\' es obligatorio";
		case 'SegPaisView.indCompAuto.1.value': return "Si";
		case 'SegPaisView.indCompAuto.0.value': return "No";
		case 'SegPaisView.indTratAcumDesc.requiered.message': return "El Campo \'\'Tratamiento acumulativo descuentos\'\' es obligatorio";
		case 'SegPaisView.indTratAcumDesc.1.value': return "Si";
		case 'SegPaisView.indTratAcumDesc.0.value': return "No";
		case 'SegPaisView.valTiemRezo.requiered.message': return "El Campo \'\'Tiempo rezonificaci�n\'\' es obligatorio";
		case 'SegPaisView.valConfSecuCcc.requiered.message': return "El Campo \'\'Configuraci�n secuencial CCC\'\' es obligatorio";
		case 'SegPaisView.valConfSecuCcc.U.value': return "�nico";
		case 'SegPaisView.valConfSecuCcc.A.value': return "A�o";
		case 'SegPaisView.valConfSecuCcc.M.value': return "Mes y a�o";
		case 'SegPaisView.numLimiDifePago.requiered.message': return "El Campo \'\'L�mite diferencia pago\'\' es obligatorio";
		case 'SegPaisView.valMaxiDifeAnlsComb.requiered.message': return "El Campo \'\'M�xima diferencia an�lisis combinatorio\'\' es obligatorio";
		case 'SegPaisView.numDiasFact.requiered.message': return "El Campo \'\'N� d�as fecha facturaci�n\'\' es obligatorio";
		case 'SegPaisView.numPosiNumeClie.requiered.message': return "El Campo \'\'Longitud c�d. cliente\'\' es obligatorio";
		case 'SegPaisView.moneOidMoneAlt.requiered.message': return "El Campo \'\'C�d. moneda alternativa\'\' es obligatorio";
		case 'SegPaisView.indEmisVenc.requiered.message': return "El Campo \'\'Emisi�n vencimiento\'\' es obligatorio";
		case 'SegPaisView.indEmisVenc.1.value': return "Si";
		case 'SegPaisView.indEmisVenc.0.value': return "No";
		case 'SegPaisView.valFormFech.requiered.message': return "El Campo \'\'Formato fecha\'\' es obligatorio";
		case 'SegPaisView.valFormFech.dd/mm/aaaa.value': return "dd/mm/aaaa";
		case 'SegPaisView.valFormFech.mm/dd/aaaa.value': return "mm/dd/aaaa";
		case 'SegPaisView.valFormFech.dd-mm-aaaa.value': return "dd-mm-aaaa";
		case 'SegPaisView.valSepaMile.requiered.message': return "El Campo \'\'Separador miles\'\' es obligatorio";
		case 'SegPaisView.valSepaMile.,.value': return ",";
		case 'SegPaisView.valSepaMile...value': return ".";
		case 'SegPaisView.valSepaDeci.requiered.message': return "El Campo \'\'Separador decimales\'\' es obligatorio";
		case 'SegPaisView.valSepaDeci.,.value': return ",";
		case 'SegPaisView.valSepaDeci...value': return ".";
		case 'SegPaisView.numPeriEgre.requiered.message': return "El Campo \'\'N� per�odos egreso\'\' es obligatorio";
		case 'SegPaisView.numPeriReti.requiered.message': return "El Campo \'\'N� per�odos retiro\'\' es obligatorio";
		case 'SegPaisView.valUrl.requiered.message': return "El Campo \'\'URL\'\' es obligatorio";
		case 'SegPaisView.indFletZonaUbig.requiered.message': return "El Campo \'\'Ind. flete-zona ubigeo\'\' es obligatorio";
		case 'SegPaisView.indFletZonaUbig.U.value': return "Ubigeo";
		case 'SegPaisView.indFletZonaUbig.Z.value': return "Zona";
		case 'SegPaisView.valIndiSecuMoni.requiered.message': return "El Campo \'\'Ind. secuencia monitor\'\' es obligatorio";
		case 'SegPaisView.valIndiSecuMoni.1.value': return "Si";
		case 'SegPaisView.valIndiSecuMoni.0.value': return "No";
		case 'SegPaisView.Descripcion.requiered.message': return "El Campo \'\'Descripci�n Pa�s\'\' es obligatorio";
		case 'SegPerioCorpo.label': return "SegPerioCorpos";
		
		case 'SegPerioCorpo.tipeOidTipoPeri.requiered.message': return "El Campo \'\'C�d. tipo per�odo\'\' es obligatorio";
		case 'SegPerioCorpo.codPeri.requiered.message': return "El Campo \'\'C�d. per�odo\'\' es obligatorio";
		case 'SegPerioCorpo.valAnio.requiered.message': return "El Campo \'\'A�o\'\' es obligatorio";
		case 'SegPerioCorpo.Descripcion.requiered.message': return "El Campo \'\'Descripci�n tipo per�odo\'\' es obligatorio";
		case 'SegSocie.label': return "SegSocies";
		
		case 'SegSocie.codSoci.requiered.message': return "El Campo \'\'C�d. empresa\'\' es obligatorio";
		case 'SegSocie.valIdenFisc.requiered.message': return "El Campo \'\'Identificaci�n fiscal\'\' es obligatorio";
		case 'SegSocie.paisOidPais.requiered.message': return "El Campo \'\'paisOidPais\'\' es obligatorio";
		case 'SegSocie.valDeno.requiered.message': return "El Campo \'\'Denominaci�n\'\' es obligatorio";
		case 'SegTipoCambi.label': return "SegTipoCambis";
		
		case 'SegTipoCambi.moneOidMon1.requiered.message': return "El Campo \'\'Moneda desde\'\' es obligatorio";
		case 'SegTipoCambi.moneOidMon1.cmbValueIncorrecto.message': return "El valor de Moneda debe ser distinto al de Moneda contrapartida";
		case 'SegTipoCambi.moneOidMon2.requiered.message': return "El Campo \'\'Moneda contrapartida\'\' es obligatorio";
		case 'SegTipoCambi.valTipoCamb.requiered.message': return "El Campo \'\'Tipo cambio\'\' es obligatorio";
		case 'SegTipoCambi.fecDesd.requiered.message': return "El Campo \'\'Fecha desde\'\' es obligatorio";
		case 'SegTipoCambi.fecHast.requiered.message': return "El Campo \'\'Fecha hasta\'\' es obligatorio";
		case 'SegTipoPerio.label': return "SegTipoPerios";
		
		case 'SegTipoPerio.codTipoPeri.requiered.message': return "El Campo \'\'C�d. tipo per�odo\'\' es obligatorio";
		case 'SegTipoPerio.numDias.requiered.message': return "El Campo \'\'Duraci�n\'\' es obligatorio";
		case 'SegTipoPerio.numPeriAnio.requiered.message': return "El Campo \'\'N� per�odos a�o\'\' es obligatorio";
		case 'SegTipoPerio.Descripcion.requiered.message': return "El Campo \'\'Descripci�n tipo per�odo\'\' es obligatorio";
		case 'SegTipoVia.label': return "SegTipoVias";
		
		case 'SegTipoVia.codTipoVia.requiered.message': return "El Campo \'\'C�d. tipo v�a\'\' es obligatorio";
		case 'SegTipoVia.desAbrvTipoVia.requiered.message': return "El Campo \'\'Descripci�n abreviada\'\' es obligatorio";
		case 'SegTipoVia.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
			case 'ZonEstadZona.label': return "ZonEstadZonas";
		
		case 'ZonEstadZona.codEstaZona.requiered.message': return "El Campo \'\'C�digo\'\' es obligatorio";
		case 'ZonEstadZona.paisOidPais.requiered.message': return "El Campo \'\'Pa�s\'\' es obligatorio";
		case 'ZonEstadZona.marcOidMarc.requiered.message': return "El Campo \'\'Marca\'\' es obligatorio";
		case 'ZonEstadZona.indInic.1.value': return "Si";
		case 'ZonEstadZona.indInic.0.value': return "No";
		case 'ZonEstadZona.Descripcion.requiered.message': return "El Campo \'\'Nombre estado\'\' es obligatorio";
		case 'ZonEstruGeopo.label': return "ZonEstruGeopos";
		
		case 'ZonEstruGeopo.codOrde.requiered.message': return "El Campo \'\'codOrde\'\' es obligatorio";
		case 'ZonEstruGeopo.paisOidPais.requiered.message': return "El Campo \'\'Pa�s\'\' es obligatorio";
		case 'ZonEstruGeopo.dipoOidDiviPoli.requiered.message': return "El Campo \'\'dipoOidDiviPoli\'\' es obligatorio";
		case 'ZonNivelGeogr.label': return "ZonNivelGeogrs";
		
		case 'ZonNivelGeogr.codDiviPoli.requiered.message': return "El Campo \'\'C�d. nivel\'\' es obligatorio";
		case 'ZonNivelGeogr.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";
		case 'ZonSubesGeopo.label': return "ZonSubesGeopos";
		
		case 'ZonSubesGeopo.codSube.requiered.message': return "El Campo \'\'C�d. subestructura\'\' es obligatorio";
		case 'ZonSubesGeopo.egeoOidEstrGeop.requiered.message': return "El Campo \'\'Orden\'\' es obligatorio";
		case 'ZonSubesGeopo.Descripcion.requiered.message': return "El Campo \'\'Descripci�n\'\' es obligatorio";	
                  //Fin de valores para mmg	
                           
                    case '2': return cdos_mostrarAlert("El C�digo Marca es obligatorio."); break;
                    case '3': return cdos_mostrarAlert('Faltan campos obligatorios por informar'); break;
                    case '4': return cdos_mostrarAlert("Debe seleccionar al menos un elemento de la lista."); break;
                    case '5': return cdos_mostrarConfirm("�Desea borrar los elementos seleccionados?"); break;
                    case '6': return cdos_mostrarConfirm("Se ha producido un error en la operacion. �Desea reintentarlo?"); break;
                    case '7': return cdos_mostrarAlert("El Tipo de Cambio ha sido insertado correctamente.");break;
                    case '8':  return cdos_mostrarAlert("Solo puede seleccionar un registro."); break;
                    case '9': return cdos_mostrarAlert("El campo es obligatorio. Debe ingresar un valor."); break;
                    case '10': return cdos_mostrarAlert("El elemento ha sido Eliminado"); break;
                    case '11': return cdos_mostrarAlert("El elemento seleccionado no es v�lido"); break;
                    case '12': return "El valor del parametro accion no es valido"; break;
                    case '13': return cdos_mostrarAlert("La Descripci�n es obligatoria."); break; 
                    case '14': return cdos_mostrarAlert(campo_obligatorio+"el C�digo Moneda."); break;
                    case '15': return cdos_mostrarAlert(campo_obligatorio+"el Nombre Moneda."); break;    
                    case '16': return cdos_mostrarAlert(campo_obligatorio+"el Nombre Corto."); break;     
                    case '17': return cdos_mostrarAlert(campo_obligatorio+"el S�mbolo."); break;  
                    case '18': return cdos_mostrarAlert(campo_obligatorio+"la Longitud Entero."); break;  
                    case '19': return cdos_mostrarAlert(campo_obligatorio+"el N�mero Decimales."); break; 
                    case '20': return cdos_mostrarAlert(campo_obligatorio+"el Texto de Ayuda."); break;   
                    case '21': return cdos_mostrarAlert(campo_obligatorio+"el Canal."); break;    
                    case '22': return cdos_mostrarAlert(campo_obligatorio+"el Acceso."); break;   
                    case '23': return cdos_mostrarAlert(campo_obligatorio+"el C�digo Subacceso."); break; 
                    case '21': return cdos_mostrarAlert(campo_obligatorio+"el Canal."); break;    
                    case '22': return cdos_mostrarAlert(campo_obligatorio+"el Acceso."); break;   
                    case '23': return cdos_mostrarAlert(campo_obligatorio+"el C�digo Subacceso."); break; 
                    case '24': return cdos_mostrarAlert(campo_obligatorio+"la Moneda."); break;
                    case '25': return cdos_mostrarAlert(campo_obligatorio+"el Pa�s."); break;     
                    case '26': return cdos_mostrarAlert(campo_obligatorio+"el C�digo Pa�s."); break;
                    case '27': return cdos_mostrarAlert("Debe introducir un valor en el campo indicado por el cursor."); focaliza(arg1,''); break;
                    case '28': return cdos_mostrarAlert('Los campos Clave nueva y confirmaci�n clave nueva deben ser iguales'); break;
                    case '29': return cdos_mostrarAlert(campo_obligatorio+'el campo Clave Nueva.'); break;
                    case '30': return cdos_mostrarAlert(campo_obligatorio+'el campo Clave Actual no puede ser nulo.'); break;
                    case '31': return cdos_mostrarAlert(campo_obligatorio+'el campo Confirmar Clave.'); break;
                    case '32': return cdos_mostrarAlert(campo_obligatorio+'el C�digo de Empresa.');break; 
                    case '33': return cdos_mostrarAlert(campo_obligatorio+"el T�po de Per�odo.");break;   
                    case '34': return cdos_mostrarAlert("El C�digo de Canal no puede ser nulo");break;    
                    case '35': return cdos_mostrarAlert("Los D�as de Cambio no puede ser nulo");break;    
                    case '36': return cdos_mostrarAlert("El N�mero de Repeticiones no puede ser nulo");break;
                    case '37': return cdos_mostrarAlert("La Cantidad M�nima no puede ser nula");break;
                    case '38': return cdos_mostrarAlert("La Inserci�n se realiz� correctamente.");break;
                    case '39': return cdos_mostrarAlert("La Modificaci�n se realiz� correctamente.");break;
                    case '40': return cdos_mostrarAlert("La Eliminaci�n se realiz� correctamente.");break;
                    case '41': return cdos_mostrarAlert("Debe Seleccionar exactamente un Elemento");break;
                    case '42': return cdos_mostrarAlert("Debe ingresar Nombre Elemento de Men�");break;
                    case '43':return "EL usuario y/o la contrase�a no son correctos. Intentelo de nuevo.";
                    case '44':return "El Usuario no posee un Usuario de Sustituci�n";
                    case '45':return "Clave inv�lida";
                    case '46':return "Se ha producido la Sustituci�n de Usuario";
                    case '47':return "Las credenciales del Usuario de Sustituci�n no pudieron ser Autentificadas";
                    case '48':return "La Contrase�a del usuario de Sustituci�n es obligatoria";
                    case '49': return cdos_mostrarAlert("El C�digo Idioma no puede ser nulo");break;
                    case '50':return cdos_mostrarAlert("Debe seleccionar un elemento de la lista");break;
                    case '51':return "�Desea eliminar el perfil ";
                    case '52':return "El Perfil seleccionado no es v�lido"; 
                    case '53':return "El Valor accion no es ninguno de los esperados <"+arg1+">" ;
                    case '54': return cdos_mostrarAlert("El campo Identificador de Usuario no puede ser nulo"); break;
                    case '55': return cdos_mostrarAlert("El campo Clave de Acceso no puede ser nulo"); break;
                    case '56': return cdos_mostrarAlert("El campo Indicacion de Clave Inicial no puede ser nulo"); break;
                    case '57': return cdos_mostrarAlert("El campo Perfil no puede ser nulo"); break;
                    case '58': return cdos_mostrarAlert("El campo Primer Apellido no puede ser nulo"); break;
                    case '59': return cdos_mostrarAlert("El campo Primer Nombre no puede ser nulo"); break;
                    case '60': return cdos_mostrarAlert("El campo Departamento no puede ser nulo"); break;
                    case '61': return cdos_mostrarAlert("El campo Pais no puede ser nulo"); break;
                    case '62': return cdos_mostrarAlert("El campo Empresa no puede ser nulo"); break;
                    case '63': return cdos_mostrarAlert("El campo Marca no puede ser nulo"); break;
                    case '64': return cdos_mostrarAlert("El campo Canal no puede ser nulo"); break;
                    case '65': return cdos_mostrarAlert("El campo Acceso no puede ser nulo"); break;
                    case '66': return cdos_mostrarAlert("El campo SubnivelAcceso no puede ser nulo"); break;
                    case '67': return cdos_mostrarAlert("El campo TipoUsuario no puede ser nulo"); break;
                    case '68': return cdos_mostrarAlert("El campo Idioma no puede ser nulo"); break;
                    case '69': return cdos_mostrarAlert("El campo FormatoFecha no puede ser nulo"); break;
                    case '70': return cdos_mostrarAlert("El campo NumeroDecimal no puede ser nulo"); break;
                    case '71': return cdos_mostrarAlert("El campo SeparadorDecimales no puede ser nulo"); break;
                    case '72': return cdos_mostrarAlert("El campo SeparadorMiles no puede ser nulo"); break;
                    case '73': return cdos_mostrarAlert("El campo UsuarioHabilitado no puede ser nulo"); break;
                    case '74': return cdos_mostrarAlert("El campo Fecha Desde no puede ser nulo"); break;
                    case '75': return cdos_mostrarAlert("Debe seleccionar una Moneda Base"); break;
                    case '76': return cdos_mostrarAlert("Debe seleccionar una Moneda Contrapartida"); break;
                    case '77': return cdos_mostrarAlert("El valor tiene que ser un n�mero entero mayor que cero y no puede estar vacio."); break;
                    case '78': return cdos_mostrarAlert("El C�digo no puede ser nulo"); break;    
                    case '79': return cdos_mostrarAlert("El Nombre del Estado no puede ser nulo"); break; 
                    case '80': return cdos_mostrarAlert("El Inicio no puede ser nulo"); break;    
                    case '81': return " No hay texto de Ayuda para esta funci�n.";break;
                    case '82': return cdos_mostrarConfirm("� Esta operaci�n cerrar� la ventana actual y perder� los datos no guardados. Esta seguro de que desea continuar. ?");
                    case '83': return cdos_mostrarAlert("El elemento ya existe.");break;
                    case '84': return "Si";
                    case '85': return "S";
                    case '86': return "No";
                    case '87': return "N";
                    case '88': return "Interactivo";
                    case '89': return "Batch";
                    case '90': return "Tercero";                             
                    case '91': return cdos_mostrarAlert("La Divisi�n Pol�tica no puede ser nula"); break;
                    case '92': return cdos_mostrarAlert("La Pagina de Inicio debe ser una de las Funciones Seleccionadas");break;
                    case '93': return "Conector no v�lido."; break;
                    case '94': return "Proceso de Transformaci�n err�neo."; break;
                    case '95': return "Nombre de funciones de Perfiles nulos."; break;
                    case '96': return cdos_mostrarAlert("Si es Funci�n final, debe dar un valor al Programa Ejecutable"); break;
                    case '97': return cdos_mostrarAlert("Debe Seleccionar un Elemento"); break;
                    case '98': return "Nombre de funciones de Perfiles no v�lidas"; break;
                    case '99': return "El campo Nombre de Perfil es obligatorio.";
                    case '100': return "Se guard� correctamente el nuevo perfil.";
                    case '101': return "Es necesario seleccionar una Funci�n y una Pantalla de Inicio antes de grabar el nuevo Perfil.";
                    case '102': return cdos_mostrarAlert("La Pantalla de Inicio Asociada al Perfil es Obligatoria");break;
                    case '103': return cdos_mostrarAlert("El Perfil ha sido guardado");break;
                    case '104': return cdos_mostrarAlert("Si es Agrupaci�n L�gica debe colgar de Men�. Si es Funci�n Final no puede colgar de Men�");break;
                    case '105': return cdos_mostrarAlert("El campo Regi�n no puede ser nulo"); break;
                    case '106': return cdos_mostrarAlert("El campo Zona no puede ser nulo"); break;
                    case '107': return cdos_mostrarAlert("El campo Secci�n no puede ser nulo"); break;
                    case '108': return cdos_mostrarAlert("El campo Territorio no puede ser nulo"); break;
                    case '109': return cdos_mostrarAlert("El campo Pa�s defecto puede ser nulo"); break;
                    case '110': return cdos_mostrarAlert("El campo Regi�n defecto no puede ser nulo"); break;
                    case '111': return cdos_mostrarAlert("El campo Zona defecto no puede ser nulo"); break;
                    case '113': return cdos_mostrarAlert("Se realizo la copia de perfil correctamente."); break;
                    case '112': return cdos_mostrarAlert("El campo Secci�n defecto no puede ser nulo"); break;
                    case '114': return " Objeto DTOEntradaInsertarPerfiles nulo.";
                    case '115': return " Datos de Entrada no v�lidos o incompletos.";
                    case '116': return "El campo Nombre de Perfil del perfil de copia, no puede estar vac�o.";
                    case '117': return "El nombre de Perfil Copia, debe ser diferente al Perfil Seleccionado.";
                    case '118': return "Error al ejecutar la acci�n.";
                    case '119': return cdos_mostrarAlert("Caracter no v�lido en el campo Nombre Elemento de Men�"); break;
                    case '120': return cdos_mostrarAlert("Caracter no v�lido en el campo Programa Ejecutable"); break;
                    case '121': return "Caracter no v�lido en el campo Nombre de Perfil.";
                    case '122': return " Funci�n";
                    case '123': return " Asignada";
                    case '124': return " P.Inicio";
                    case '125': return cdos_mostrarAlert("El campo Serie Desde no puede ser nulo"); break;
                    case '126': return cdos_mostrarAlert("Debe especificar algun criterio de b�squeda."); break;
                    case '127': return cdos_mostrarAlert("Debe ingresar por lo menos un nivel"); break;
                    case '128': return cdos_mostrarAlert("Caracter no v�lido en el campo Identificador de Usuario"); break;
                    case '129': return cdos_mostrarAlert("Caracter no v�lido en el campo Nombre1"); break;
                    case '130': return cdos_mostrarAlert("Caracter no v�lido en el campo Apellido1"); break;
                    case '131': return cdos_mostrarConfirm("�Desea eliminar el elemento seleccionado?"); break;
                    case '132': return cdos_mostrarAlert("El campo Desde no puede ser nulo"); break;
                    case '133': return cdos_mostrarAlert("El campo Desde debe ser menor que Hasta"); break;
                    case '134': return "La clave nueva no puede ser igual al identificador de usuario.";
                    case '135': return "Se ha actualizado la clave de acceso.\nPor favor inicie sesi�n nuevamente";
                    case '136': return "La clave de acceso es incorrecta.";
                    case '137': return cdos_mostrarAlert("El campo actividad no puede ser nulo"); break;
                    case '138': return cdos_mostrarAlert("El campo tipo de cliente no puede ser nulo"); break;
                    case '139': return cdos_mostrarAlert(" 5 - Error de Petici�n de datos no existente"); break;
                    case '146': return "Se ha producido un error (codigo Pais vacio). La operaci�n no pudo ser realizar.";
                    case '148': return "El campo 'N�mero de p�gina' es obligatorio.";
                    case '149': return "El campo 'N�mero de p�gina' tiene un formato de n�mero incorrecto.";
                    case '150': return "El campo 'Incremento' es obligatorio.";
                    case '151': return "El campo 'Incremento' tiene un formato de n�mero incorrecto.";
                    case '152': return "El campo 'Marca' es obligatorio.";
                    case '153': return "El campo 'Canal' es obligatorio.";
                    case '154': return cdos_mostrarAlert("Importe fijo y  porcentaje no pueden ser ambos nulos"); break;
                    case '155': return cdos_mostrarAlert("El D�a de Vencimiento no puede ser nulo"); break;
                    case '156': return "Activo";
                    case '157': return "No Activo";
                    case '158': return cdos_mostrarAlert("El campo 'Orden Compra Desde' no puede ser nulo"); break;
                    case '159': return cdos_mostrarAlert("El campo 'Orden Compra Hasta' no puede ser nulo"); break;
                    case '160': return cdos_mostrarAlert("No se ha encontrado ning�n elemento con los criterios especificados."); break;
                    case '161': return cdos_mostrarAlert("Debe Ingresar todos los Porcentajes o ninguno.");break; 
                    case '162': return cdos_mostrarAlert("La Suma de los Porcentajes debe ser 100");break;
                    case '163': return cdos_mostrarAlert("Debe Ingresar el primero, todos o ning�n Vencimiento");break; 
                    case '164': return cdos_mostrarAlert("El N�mero de Cuota no puede ser nulo");break; 
                    case '165': return "Caracteres permitidos:";
                    case '166': return "�Desea eliminar el elemento seleccionado?";
                    case '167': return cdos_mostrarAlert("Se ha generado la guia de producto."); break;
                    case '168': return cdos_mostrarAlert("Para poder a�adir no debe seleccionar registros"); break;
                    case '169': return cdos_mostrarAlert ("El campo sub tipo de cliente no puede ser nulo");break;
                    case '170': return cdos_mostrarAlert ("El campo tipo de clasificaci�n de cliente no puede ser nulo");break;
                    case '171': return cdos_mostrarAlert ("El campo estatus no puede ser nulo");break;
                    case '172':   return cdos_mostrarAlert ("El campo estatus 2 no puede ser nulo");	break;		
                    case '173':   return cdos_mostrarAlert ("El campo clasificaci�n no puede ser nulo");break;
                    case '174':   return " de ";
                    case '175': return "Condicionante";
                    case '176': return "Condicionado";
                    case '177': return "Paquete"; 
                    case '180': return cdos_mostrarAlert("Para Insertar, no se puede seleccionar elemento");break; 
                    case '181': return cdos_mostrarAlert("Para Descargar, no se puede seleccionar elemento");break; 
                    case '182': return cdos_mostrarAlert ("No se puede modificar esta oferta");break; 
                    case '183': return cdos_mostrarAlert ("No se puede eliminar el unico grupo Condicionante/Condicionado asociado a la oferta");break; 
                    case '1110': cdos_mostrarAlert ("No se puede eliminar el unico grupo asociado a la oferta");break; 
                                      case '184': return cdos_mostrarAlert ("No se puede eliminar el unico Paquete asociado a la oferta");break;
                    case '185': return cdos_mostrarAlert ("No se puede eliminar la unica condici�n asociada a la oferta");break;  
                    case '186': return cdos_mostrarAlert ("No se puede eliminar la unica l�nea de la condici�n");break;  
                    case '187': return cdos_mostrarAlert ("Desea eliminar la oferta");break;  
                    case '188': return cdos_mostrarAlert ("Deber� crear matriz de facturaci�n para que los cambios se reflejen en esta");break;
                    case '189': return cdos_mostrarAlert ("Seleccione una Estrategia, por favor");break;
                    case '190': return cdos_mostrarAlert ("El campo 'Primer N� de Ranking' no puede ser nulo");break;
                    case '191': return cdos_mostrarAlert ("El campo '�ltimo N� de Ranking' no puede ser nulo");break;
                    case '192': return cdos_mostrarAlert ("El campo 'Primer N� de Ranking' debe ser menor o igual a '�ltimo N� de Ranking'");break;
                    case '193': return cdos_mostrarAlert ("Por favor, ingrese el factor cuadre");break;
                    case '194': return cdos_mostrarAlert ("Para guardar un grupo tiene que haber al menos un producto seleccionado");break;
                    case '195': return cdos_mostrarAlert("Clave de Acceso y Confirmar Clave de Acceso deben ser iguales."); break;
                    case '196': return "El nombre de Perfil elegido ya existe. Por favor seleccione otro nombre.";
                    case '197': return cdos_mostrarAlert ("No esta permitida la selecci�n de los elementos de la lista"); break; 
                    case '198': return cdos_mostrarAlert("El campo Tipo de Cambio no puede ser nulo"); break; 
                    case '199': return cdos_mostrarAlert("El campo Programa Ejecuci�n no puede ser nulo");  break;
                    case '200': return cdos_mostrarAlert("El campo Porcentaje Alarma no puede ser nulo");  break;
                    case '201': return cdos_mostrarAlert("El campo D�as de Mora no puede ser nulo");  break;
                    case '202': return("No existen pa�ses sin estructura geopol�tica definida");  break;
                    case '203': return cdos_mostrarConfirm("Este elemento de Men� puede tener asociada un texto de ayuda");  break;
                    case '204': return cdos_mostrarConfirm("El tipo cambio debe ser mayor a cero");  break;
                    case '205': return cdos_mostrarAlert("Se guardaron correctamente los datos de parametrizaci�n");  break;
                    case '206': return cdos_mostrarAlert("El a�o ingresado no puede ser menor al a�o actual");  break;
                    case '207': return cdos_mostrarAlert("En el �ltimo nivel, un Elemento s�lo puede ser Funci�n Final");  break;
                    case '208': return cdos_mostrarAlert("Debe seleccionar un valor para D�as no Laborables");  break;
                    case '209': return cdos_mostrarAlert("La confirmaci�n de la matriz es obligatoria.");  break;
                    case '210': return cdos_mostrarAlert("La confirmaci�n de la aprobaci�n de la matriz es obligatoria.");  break;
                    case '211': return "El campo Descripcion es obligatorio completarlo."; break;
                    case '212': cdos_mostrarAlert('El campo Subgerencia de ventas no puede ser nulo');return;
                    case '213': cdos_mostrarAlert('El campo Responsable de Cr�dito no puede ser nulo');return;
                    case '214': cdos_mostrarAlert('El campo Nivel de Riesgo no puede ser nulo');return;   
                    case '215': cdos_mostrarAlert('El campo Nivel Jer�rquico de Autorizaci�n no puede ser nulo');return;
                    case '216': return "No se han podido eliminar las siguientes matrices por estar en uso:"; break;
                    case '217': return "�Desea eliminar los elementos seleccionados?"; break;
                    case '218': cdos_mostrarAlert('Debe ingresar indicador de cuadre'); return;
                    case '219': return "El campo Descripcion contiene caracteres no v�lidos."; break;
                    case '220': return cdos_mostrarAlert("Debe seleccionar al menos una condici�n: rango de p�ginas, l�nea de negocio o producto."); break;
                    case '221': cdos_mostrarAlert ("Los precios para esta estrategia deben coincidir"); return;
                    case '222': return "Nacional"; break;
                    case '223': return cdos_mostrarAlert("La selecci�n de las listas Subgerencia, Regi�n, Zona son obligatorias."); break;
                    case '224': return "No nacional"; break;
                    case '225': return cdos_mostrarAlert("Debe ingresar los par�metros de b�squeda");  break;
                    case '226': return cdos_mostrarAlert("El campo porcentaje tiene un formato incorrecto.");  break;
                    case '227': return cdos_mostrarAlert("El resgistro ya ha sido a�adido antes.");  break;
                    case '228': return cdos_mostrarAlert("Operaci�n no habilitada");  break;
                    case '229': return "El criterio de asignacion es obligatorio";
                    case '230': return cdos_mostrarAlert("La fecha de Periodo Hasta debe ser posterior a la fecha de Periodo Desde");  break;
                    case '231': return cdos_mostrarAlert("El campo 'N�mero de descuento' no puede ser nulo");  break;
                    case '232': return cdos_mostrarAlert("El campo 'Nombre de descuento' no puede ser nulo");  break;
                    case '233': return cdos_mostrarAlert("El porcentaje m�nimo CS debe ser menor o igual que el porcentaje m�ximo CS ");  break;
                    case '234': return cdos_mostrarAlert("La suma de condicionantes y condicionados debe ser menor o igual al n�mero maximo de grupos de la estrategia.");  break;
                    case '235': return cdos_mostrarAlert("No se puede ingresar una oferta sin producto principal");  break;
                    case '236': return "El Parametro '"+arg1+"'  es Obligatorio. Debe ingresar el campo N�mero M�ximo y seleccionar un Valor Posible.";  break;
                    case '237': return "El Parametro '"+arg1+"'  es Obligatorio. Debe seleccionar uno o mas Valores Posibles.";  break;
                    case '238': return "El Parametro '"+arg1+"'  es Obligatorio. Debe seleccionar uno valor por Default.";  break;
                    case '239': return "El Parametro '"+arg1+"'  es necesario completarlo. Debe seleccionar uno o mas Valores Posibles y un Valor Default.";  break;
                    case '240': return "Debe seleccionar un solo elemento de la lista";  break;
                    case '241': return "Es obligatorio completar el campo 'Descripcion de Nueva Matriz'.";  break;
                    case '242': return "El campo 'Descripcion de Nueva Matriz' presenta caracteres no v�lidos."; break;
                    case '243': return cdos_mostrarAlert("El campo Periodo Inicial no puede ser nulo"); break;
                    case '244': return cdos_mostrarAlert("El campo Periodo Final no puede ser nulo"); break;
                    case '245': return "Datos Generales";
                    case '246': return "Tipo de Cliente";
                    case '247': return "Alcance Administrativo";
                    case '248': return "Base de C�lculo";
                    case '249': return "Aplicaci�n de Descuento";
                    case '250': return cdos_mostrarAlert("Debe seleccionar una linea de producto");
                    case '251': return "El valor del campo 'N�mero de Unidades Obligatorias' no es v�lido"; return;
                    case '252': return "El valor del campo 'Escala Desde' no es correcto."; return;
                    case '253': return "El valor del campo 'Escala Hasta' no es correcto."; return;
                    case '254': return "El valor del campo 'Porcentaje de Descuento' no es v�lido"; return;
                    case '255': return "El valor del campo 'Escala Hasta' no puede estar en otra escala ya ingresada"; return;
                    case '256': return "La definici�n de escalas no es correcta. Se producen solapamientos"; return;
                    case '257': return "El campo 'Escala Desde' debe ser menor al valor del campo 'Escala Hasta'"; return;
                    case '258': return "Es necesario seleccionar un elemento en la lista para borrarlo"; return;
                    case '259': return "No exiten elementos en la lista a borrar"; return;
                    case '260': return cdos_mostrarAlert("La l�nea ya se encuentra ingresada."); break;
                    case '261': return cdos_mostrarConfirm("�Desea eliminar la oferta?"); break;
                    case '262': return "La fecha Desde debe ser menor que la fecha Hasta"; break;
                    case '263': return "El valor m�ximo debe ser mayor al valor m�nimo"; break;
    case '264': return cdos_mostrarAlert("La operaci�n ha sido exitosa"); break;
    case '265': return cdos_mostrarAlert("La operaci�n produjo un error"); break;
    case '266': return cdos_mostrarAlert("El n�mero de clientes del env�o excede al parametrizado para el pa�s"); break;
            case '267': return cdos_mostrarAlert("El registro ha sido a�adido antes."); break;   
                    case '268': return "Debe seleccionar al menos una Subgerencia de ventas."; break;
                    case '269': return cdos_mostrarAlert("No es un valor num�rico del 0 al 100."); break;
                    case '270': return cdos_mostrarAlert("El descuento debe estar dirigido al menos a un tipo de cliente"); break; 
                    case '271': return cdos_mostrarAlert("Ingresar importe fijo o porcentaje"); break;
                    case '272': return "No se ha encontrado ning�n registro que cumpla con alguno de los criterios especificados"; break;
                    case '273': return cdos_mostrarAlert("Seleccionar al menos un cliente."); break; 
                    case '274': return cdos_mostrarAlert("Para agregar una linea, debe seleccionar un cat�logo."); break;
                    case '402': return cdos_mostrarAlert("Se debe ingresar la Matriz Origen y la Matriz Destino."); break;
                    case '404': return cdos_mostrarAlert("Para guardar condiciones debe seleccionar un indicador de cuadre."); break;
                    case '405': return cdos_mostrarAlert("N�mero inv�lido: caracteres permitidos:-0123456789."); break;            
                    case '406': return cdos_mostrarAlert("Debe seleccionar un registro"); break;           
                    case '407': return cdos_mostrarAlert("Debe seleccionar una Actividad"); break;                  
                    case '408': return cdos_mostrarAlert("Debe seleccionar un criterio de Agrupaci�n"); break;    
                    case '409': return "EN:Es obligatorio ingresar al menos un 'Escalon' para guardar una Base de Aplicaci�n"; break;     
                    case '410': return "EN:No es posible ingresar escalones con un intervalo entre dos escalones ya ingresados."; break;
                    case '411': return cdos_mostrarAlert("Debe seleccionar al menos un Tipo Despacho"); break;             
                    case '412': return cdos_mostrarAlert("Debe seleccionar al menos un Tipo de Cliente");break;            
                    case '413': return cdos_mostrarAlert("Debe seleccionar alg�n Producto");break;
                    case '414': return cdos_mostrarAlert("Debe seleccionar un canal.");break;
                    case '415': return cdos_mostrarAlert("Debe seleccionar una marca.");break; 
                    case '416': return cdos_mostrarAlert("Debe seleccionar un per�odo.");break;
                    case '417': return "La fecha de entrega es incorrecta. \nSi contin�a con la modificaci�n se abonar� un suplemento\n �Desea continuar con la modificaci�n?";break;     
                    case '418': return "�Est� seguro de que desea continuar con la modificacion del registro? ";break;
                    case '501': return cdos_mostrarAlert("El campo Ubigeo no puede ser nulo.");break;
                    case '502': return cdos_mostrarAlert("El campo Negocio no puede ser nulo");break;                   
                    case '503': return cdos_mostrarAlert("El campo Indicador de Impuesto no puede ser nulo");break;        
                    case '506': return cdos_mostrarAlert("El campo Indicador de Tasa �nica no puede ser nulo");break;     
                    case '507': return "Contado"; break;
                    case '508': return "Cr�dito"; break;
                    case '509': return "Todos"; break;
                    case '510': return ""; break;
                    case '511': return cdos_mostrarAlert("El formato de N�mero de Orden debe ser pppnnnn"); break;
					case '512': return "Con actividad origen "; break;
					case '513': return "Fija "; break;
					case '514': return cdos_mostrarAlert("La actividad de facturaci�n no puede marcarse como repetitiva. Su comportamiento se especificar� en la creaci�n del cronograma en funci�n del tipo de facturaci�n (monofacturaci�n, multifacturaci�n o facturaci�n semanal) del grupo de zonas"); break;
					
					case '601': return cdos_mostrarAlert("Soporte binario del reporte; con errores"); break; 
                    case '604': return cdos_mostrarAlert("La generaci�n del reporte finaliz� err�neamente"); break; 
                    case '605': return cdos_mostrarAlert("Se ha abortado la generaci�n del reporte"); break;

                    case '701': return cdos_mostrarAlert("La cantidad de items seleccionados en el campo Accesos no puede ser mayor a lo especificado en la Matriz Origen");break;         
                    case '702': return cdos_mostrarAlert("La cantidad de items seleccionados en el campo SubAccesos no puede ser mayor a lo especificado en la Matriz Origen");break;     
                    case '703': return cdos_mostrarAlert("El campo Accesos no puede ser nulo");break;     
                    case '704': return cdos_mostrarAlert("El campo SubAccesos no puede ser nulo");break;  
                    case '705': return cdos_mostrarAlert("N�mero inv�lido: debe ser un entero entre -9 y 9"); break;
                    case '706': return cdos_mostrarAlert("Debe seleccionar un Estado de Autorizaci�n"); break;
                    case '707': return cdos_mostrarAlert("No se puede eliminar el unico grupo Sin Tipo asociado a la oferta"); break;
                    case '708': return cdos_mostrarAlert("Los campos Pa�s, Marca, Canal y A�o son obligatorios"); break;
                    case '709': return cdos_mostrarAlert("El Argumento de ventas es obligatorio."); break;
                    case '710': return cdos_mostrarAlert("El C�digo de Pago Fraccionado es obligatorio."); break;
          case '711': return cdos_mostrarAlert("Error al ejecutar la acci�n"); break;
          case '712': return cdos_mostrarAlert("No se puede agregar mas grupos a la oferta"); break;
                    case '713': return cdos_mostrarAlert("No se puede agregar mas grupos condicionantes a la oferta"); break;
                    case '714': return cdos_mostrarAlert("No se puede agregar mas grupos condicionados a la oferta"); break;
                    case '715': return cdos_mostrarAlert("No se puede agregar mas Paquetes a la oferta"); break;
                    case '716': return cdos_mostrarAlert("El n�mero de Grupos no puede ser mayor al de la estrategia."); break;
                    case '717': return cdos_mostrarAlert("El N�mero de Paquetes no puede ser mayor al de la estrategia."); break;
                    case '718': return cdos_mostrarAlert("El Grupo Condicionantes no puede ser mayor al de la estrategia."); break;
                    case '719': return cdos_mostrarAlert("El Grupo Condicionados no puede ser mayor al de la estrategia."); break;
                    case '720': return cdos_mostrarAlert("Debe haber un producto asociado."); break;
                    case '721': return cdos_mostrarAlert("El campo Condicionantes debe indicarse."); break;
                    case '722': return cdos_mostrarAlert("El campo Condicionados debe indicarse."); break;
                    case '723': return cdos_mostrarAlert("El campo Tipo solicitud no puede ser nulo");break; 
                    case '724': return cdos_mostrarConfirm("�Desea Recalcular los Per�odos?"); break;  
					case '725': return cdos_mostrarConfirm("Al eliminar este elemento de Men� se eliminar� tambi�n la ayuda asociada. Desea continuar?"); break;
                    case '726': alert("Solo debe Ingresar n�meros");
                    case '727': return cdos_mostrarAlert("Solo puede ingresar n�meros.");break;
                    case '729': return cdos_mostrarConfirm("�Est� seguro que desea aprobar este reporte?");
                    case '730': return cdos_mostrarAlert("S�lo puede ingresar n�meros.");break;

                    case '731': return cdos_mostrarAlert("El campo Tipo de Solicitud no puede ser nulo"); break; 
                    case '732': return cdos_mostrarAlert("El campo N� Solicitud por Lote no puede ser nulo"); break; 
                    case '733': return cdos_mostrarAlert("El campo Sujeto a Flete no puede ser nulo"); break; 
                    case '734': return cdos_mostrarAlert("El campo Uni�n Solicitudes no puede ser nulo"); break; 
                    case '735': return cdos_mostrarAlert("El campo Reserva Stock no puede ser nulo"); break; 
                    case '736': return cdos_mostrarAlert("El campo Varios Medios de Pago no puede ser nulo"); break; 
                    case '737': return cdos_mostrarAlert("El campo Revisi�n no puede ser nulo"); break; 
                    case '738': return cdos_mostrarAlert("El campo Flag Pedido Prueba no puede ser nulo"); break; 

                    case '739': return cdos_mostrarAlert("El campo N� Solicitud por Lote debe ser un numero entero"); break; 
                    case '740': return cdos_mostrarAlert("El campo Alarma N� Unidades debe ser un numero entero"); break; 
                    case '741': return cdos_mostrarAlert("El Bot�n A�adir queda deshabilitado cuando el porcentaje es Nacional."); break; 
                    case '742': return cdos_mostrarAlert("Debe ingresar un c�digo de cliente"); break;
                    case '743': return cdos_mostrarAlert("No se puede a�adir una subgerencia cuando el porcentaje es Nacional."); break; 
                    case '744': return "El Parametro '"+arg1+"' no es modificable. Es necesario ingresar un valor por defecto.";  break;
					case '745': return "El valor del campo 'N�mero Maximo' debe estar comprendido entre los valores 0 y 99";  break;
                    case '746': return cdos_mostrarAlert("Oferta guardada, deber� crear la matriz de facturaci�n para que los cambios ser reflejen en esta."); break; 
                    case '747': return cdos_mostrarAlert("N�mero inv�lido: caracteres permitidos:0123456789."); break;    
                    case '748': return cdos_mostrarAlert("No se pueden eliminar todos los producto del grupo"); break;    
					case '749': return cdos_mostrarAlert("S�lo puede ingresar letras y n�meros."); break;   
					case '750': return cdos_mostrarAlert("Se debe ingresar un valor por defecto."); break;
					case '751': return cdos_mostrarConfirm("Se perder�n las modificaciones.�Desea continuar?."); break;

					 case '800': return cdos_mostrarAlert("El campo D�as cambio es obligatorio"); break; 
					 case '801': return cdos_mostrarAlert("El campo N� repeticiones es obligatorio"); break; 
					 case '802': return cdos_mostrarAlert("El campo Longitud m�nima es obligatorio"); break; 
					 case '803': return cdos_mostrarAlert("El campo N� m�x. intentos es obligatorio"); break; 
					 case '804': return cdos_mostrarAlert("Operaci�n realizada con �xito"); break; 
					 case '805': return cdos_mostrarAlert("N�mero documento no existe, se generar� siguiente secuencia que corresponda"); break; 
					 case '806': return cdos_mostrarAlert("N�mero documento existe, pero no pertenece al cliente introducido: debe introducir otro n�mero documento"); break; 
					 case '807': return cdos_mostrarAlert("Debe ingresar un c�digo de cliente para validar el n�mero de documento"); break;

                   
                   case '901': return cdos_mostrarAlert("Debe seleccionar un Grupo de Zona o una Subgerencia de Ventas / Regi�n."); break;
				  case '902': return cdos_mostrarAlert("La Fecha Inicio del Periodo no puede ser menor que la Fecha Actual"); break;
				  case '903': return cdos_mostrarAlert("La Fecha Inicio del Periodo Inicial no puede ser mayor a la Fecha Inicio del Periodo Final"); break;

				  case '904': return cdos_mostrarAlert("La Fecha Inicio del Periodo Inicial debe ser menor a la Fecha Inicio del Periodo Final"); break;
				  case '905': return cdos_mostrarAlert("La Fecha Actual debe ser anterior a la Fecha Inicio del Periodo Inicial"); break;
				  case '906': return cdos_mostrarAlert("La Fecha Inicio del Periodo Inicial debe ser anterior a la Fecha Inicio del Periodo Final"); break;
                    case '907': return cdos_mostrarConfirm("�Desea eliminar la condici�n?"); break;
                    case '908': return cdos_mostrarConfirm("�Desea eliminar el grupo?"); break;
                    case '909': return cdos_mostrarAlert("El valor m�ximo debe ser mayor al valor m�nimo"); break;
                    case '910': return cdos_mostrarAlert("Debe seleccionar alg�n item en el combo SubTipo Cliente"); break;
                    case '911': return cdos_mostrarAlert('El campo Tipo de Clasificaci�n de Cliente no puede ser nulo'); break;   
                    case '912': return cdos_mostrarAlert("El campo Clasificaci�n de Cliente no puede ser nulo"); break;
                    case '913': return cdos_mostrarAlert("El Campo C�digo de Venta no puede ser nulo."); break;   
                    case '914': return cdos_mostrarAlert("El Campo Control de Stock no puede ser nulo."); break;
                    case '915': return cdos_mostrarAlert("El Campo Limite de Venta no puede ser nulo."); break;
                    case '916': return cdos_mostrarAlert("El Campo Control de Liquidaci�n no puede ser nulo."); break;
                    case '917': return cdos_mostrarAlert("El campo Unidad de medidas no puede estar vacio"); break; 
                    case '918': return cdos_mostrarAlert("Debe seleccionar un tipo de per�odo.");break; 
                    case '919': return cdos_mostrarAlert("El campo Tipo de Despacho no puede ser nulo.");break;
          case '920': return cdos_mostrarAlert("El campo Descripci�n no puede ser nulo");break;             
                    case '921': return cdos_mostrarAlert("Si la unidad de medida es porcentual(%), el m�ximo permitido de caracteres es de 3 caracteres en control de stock (1 d�gito de unidad y 2 de cent�simas), sino es de 6 n�meros"); break; 
                    case '922': return cdos_mostrarAlert("Se debe seleccionar al menos un elemento de Unidades de Negocio");break;
                    case '923': return cdos_mostrarAlert("Se debe seleccionar al menos un elemento de la lista Unidades de Negocio");break;
                    case '924': return cdos_mostrarAlert("Se debe seleccionar al menos un elemento de la lista Negocio");break;
                    case '925': return cdos_mostrarAlert("Se debe seleccionar al menos un elemento de la lista Super Gen�rico");break;
                    case '926': return cdos_mostrarAlert("Se debe seleccionar al menos un elemento de la lista Gen�rico");break;
                    case '927': return cdos_mostrarAlert("Se debe traer al menos un Producto");break;

                    case '929': return "Rango de valores permitidos: desde "; break;
                    case '930': return " hasta "; break;

                    case '931': return cdos_mostrarAlert("No se puede agregar m�s de nueve l�neas de Cat�logo");break;
                    case '932': return cdos_mostrarAlert("No se puede agregar m�s de nueve l�neas de Producto");break;
                    case '933': return cdos_mostrarAlert("No se puede agregar m�s de nueve Productos");break;
                    case '935': return "La fecha de inicio debe ser mayor o igual a la fecha de inicio de la actividad anterior";break;
                    case '936': return "La fecha fin debe ser mayor que la fecha de inicio";break;
                    case '937': return "El valor del campo '"+arg1+"' debe ser positivo";break;

                    case '938': return cdos_mostrarConfirm("Los cambios no afectaran a actividades que ya se encuentren en el cronograma. �Desea continuar?"); break;
                    case '939': return cdos_mostrarAlert("Debe completar el campo Descripci�n");break;
                    case '940': return cdos_mostrarAlert("Debe completar el campo Tasa de Impuestos");break;
                    case '941': return cdos_mostrarAlert("El log se ha generado exitosamente"); break;
                    case '942': return "La hora debe estar en formato HH:mm. HH Debe ser un n�mero entre 0 y 23, y mm un n�mero entre 0 y 59."; break;
                    case '943': return cdos_mostrarAlert("A�n no se han agregado grupos de zonas"); break;

                    case '944': return cdos_mostrarAlert("Para poder guardar, primero necesita realizar la b�squeda presionando el bot�n buscar."); break;
                    case '945': return cdos_mostrarAlert("La actividad origen especificada genera un ciclo"); break;

                    case '946': return cdos_mostrarAlert("Para el c�digo de cat�logo y la p�gina de cat�logo sleccionados no existen c�digos de venta"); break; 
                                      case '947':     return cdos_mostrarAlert("La Fecha es incorrecta. (dd/mm/aaaa)"); break;
                    case '948':   return cdos_mostrarAlert("La Hora es incorrecta. (hh/mm/ss)"); break;
                    case '949': return cdos_mostrarConfirm("El reporte seleccionado no posee detalle. �Desea aprobarlo de todos modos.?"); break;
                    case '950': return cdos_mostrarConfirm("�Desea guardar los datos introducidos?"); break;
                    case '951': return "Operaci�n realizada con �xito"; break;
                    case '952': return cdos_mostrarAlert("Debe completar todos los campos"); break;
                    case '953': return cdos_mostrarAlert("El campo D�as de Cambio contiene caracteres inv�lidos. El juego de caracteres permitido es 123456789"); break;
                    case '954': return cdos_mostrarAlert("El campo N� de Repeticiones contiene caracteres inv�lidos. El juego de caracteres permitido es 0123456789"); break;
                    case '955': return cdos_mostrarAlert("El campo Longitud M�nima contiene caracteres inv�lidos. El juego de caracteres permitido es 0123456789"); break;
                    case '956': return cdos_mostrarConfirm("�Desea continuar el proceso de eliminaci�n de la unidades administrativas asignadas a " + arg1 + "?"); break;
                    case '957': return cdos_mostrarConfirm("�Desea continuar el proceso de eliminaci�n de la unidades geogr�ficas asignadas al pa�s activo?");  break;
                    case '958': return "Alerta!"; break;
                    case '959': return cdos_mostrarAlert("El campo " + arg1 + " contiene caracteres inv�lidos. El juego de caracteres permitido es 0123456789"); break;
                    case '960': return cdos_mostrarAlert("Debe introducir un nivel de orden para el campo " + arg1); break;
                    case '961': return cdos_mostrarAlert("No se encontr� el elemento " + arg1 + ". Se debe ingresar una secuencia completa desde 1 a " + arg2 + " sin repeticiones"); break;
                    case '962': return cdos_mostrarAlert("El nivel de orden " + arg1 + " se encuentra repetido en la secuencia. Se debe ingresar una secuencia completa desde 1 a " + arg2 + " sin repeticiones"); break;
                    case '963': return cdos_mostrarConfirm("�Desea eliminar los datos seleccionados?"); break;
                    case '964': return cdos_mostrarAlert("Si desea ingresar valor para un s�lo elemento, el nivel de orden del mismo debe ser 1");  break;
                    case '965': return cdos_mostrarAlert("No se encontr� el elemento " + arg1 + ". Se debe ingresar una secuencia completa sin salteos ni repeticiones"); break;
                    case '966': return cdos_mostrarAlert("El nivel de orden " + arg1 + " se encuentra repetido en la secuencia. Se debe ingresar una secuencia completa sin salteos ni repeticiones");  break;
                    case '967': return cdos_mostrarAlert("El nivel de orden no puede ser 0. La secuencia debe comenzar en 1");  break;
                    case '968': return cdos_mostrarConfirm("�Desea continuar con el proceso de eliminaci�n de la estructura geopol�tica asignada al pais activo?");  break;

                    case '970': return cdos_mostrarAlert("No se han asignado niveles a las divisiones pol�ticas");  break;
                                      
				  case '988': return "El registro se ha insertado correctamente"; break;
				  case '989': return "Los registros se han eliminado correctamente"; break;
				  case '990': return "El registro se ha modificado correctamente"; break;

				  case '991': return cdos_mostrarAlert("Debe seleccionar al menos 1 pa�s"); break;
				  case '992': return cdos_mostrarAlert("No se debe seleccionar mas de 5 pa�ses"); break;
				  case '993': return 'C�digo';
				  case '994': return 'Descripci�n';

				  case '971': return "En Ejecuci�n"; break;
				  case '972': return "Carga finalizada revise log de errores"; break;
				  case '973': return "No Iniciado"; break;
				  case '974': return "Procesamiento Finalizado Error"; break;
				  case '975': return "Sin Estatus"; break;
				  case '976': return cdos_mostrarAlert("El campo N� M�ximo de Intentos contiene caracteres inv�lidos. El juego de caracteres permitido es 0123456789") ; break;
				  case '977': return cdos_mostrarAlert("El campo NSE Belcorp es obligatorio") ; break;
				  case '978': return cdos_mostrarAlert("El campo NSE Pa�s es obligatorio") ; break;
				  case '979': return cdos_mostrarAlert("El campo C�d. funci�n es obligatorio"); break;
				  case '980': return cdos_mostrarAlert("El campo Texto ayuda es obligatorio"); break;
				  case '981': return cdos_mostrarAlert("El Path de Fichero de Ayuda no puede estar vac�o"); break;
				  case '982': return "PRODUCTOS"; break;
				  case '983': return "CLIENTES"; break;

				  case '984': return "C�digo"; break;
				  case '985': return "Descripci�n"; break;
				  case '986': return "Tipo cliente"; break;
				  case '987': return "Subtipo cliente"; break;

				  case '986': return "Tipo cliente"; break;
				  case '987': return "Subtipo cliente"; break;

				  case '995': return cdos_mostrarAlert("El campo Usuario contiene caracteres inv�lidos"); break;
				  case '996': return cdos_mostrarAlert("El campo Apellido 1 contiene caracteres inv�lidos"); break;
				  case '997': return cdos_mostrarAlert("El campo Apellido 2 contiene caracteres inv�lidos."); break;
				  case '998': return cdos_mostrarAlert("El campo Nombre 1 contiene caracteres inv�lidos."); break;
				  case '999': return cdos_mostrarAlert("El campo Nombre 2 contiene caracteres inv�lidos."); break;
                    case '1000': return cdos_mostrarAlert("El campo Obligatorio es obligatorio."); break;
                    case '1001': return cdos_mostrarAlert("El campo Modificable es obligatorio."); break;
                                      case '1002': return "Fija"; break;
                                      case '1003': return "Referenciada"; break;
                    case '1004': return cdos_mostrarConfirm("Ya existe un cronograma para los datos seleccionados. �Desea eliminarlo y generar uno nuevo?"); break;
                   		  case '1005': return cdos_mostrarAlert("Formato de fecha inv�lido y/o valor de fecha Desde mayor que valor de fecha Hasta"); break;
             		  case '1006': return cdos_mostrarAlert("Formato de fecha inv�lido. El formato de fecha v�lido es: " + arg1); break;
				  case '1007': return cdos_mostrarAlert("El valor de la fecha Desde debe ser menor o igual que el valor de la fecha Hasta"); break;
				  case '1008': return "Servicio";break;
				  case '1009': return "Producto";break;
				  case '1010': return "Si";break;
				  case '1011': return "No";break;
				  case '1012': return "Caja";break;
				  case '1013': return "Bolsa";break;
				  case '1014': return "El cliente ya existe y tiene cuentas castigadas. El saldo del cliente es";break;
				  case '1015': return cdos_mostrarAlert("El campo Estrategia no puede ser nulo");break;
				  case '1016': return cdos_mostrarAlert("El campo Marca no puede ser nulo");break;
				  case '1017': return cdos_mostrarAlert("El campo Canal no puede ser nulo");break;
				  case '1018': return cdos_mostrarAlert("El campo N� tipo desde no puede ser nulo");break;
				  case '1019': return cdos_mostrarAlert("El campo N� tipo hasta no puede ser nulo");break;
				  case '1020': return cdos_mostrarAlert("El campo N� tipo desde debe ser menor al campo N� tipo hasta");break;
				  case '1021': return cdos_mostrarAlert("Debe seleccionar al menos un elemento de la lista");break;
				  case '1022': return cdos_mostrarAlert("Debe seleccionar un solo elemento de la lista");break;
		  case '1023': return cdos_mostrarAlert("El campo N� tipo desde debe ser un numero entero");break;
		  case '1024': return cdos_mostrarAlert("El campo N� tipo hasta debe ser un numero entero");break;

				  case '1025': return cdos_mostrarAlert(campo_obligatorio+"el C�digo de venta."); break;

				  case '1026': return cdos_mostrarConfirm("�Esta seguro que desea eliminar la matriz seleccionada?"); break;

				  case '1027': return cdos_mostrarConfirm("�Desea eliminar tambi�n las ofertas asociadas?"); break;
				 
				  case '1028': return cdos_mostrarAlert("Operaci�n realizada con �xito"); break;

				  case '1029': return cdos_mostrarAlert(campo_obligatorio + "producto principal"); break;
				  case '1030': return cdos_mostrarAlert(campo_obligatorio + "producto de reemplazo"); break;
				  case '1031': return "Sr"; break;
				  case '1032': return "Sra"; break;
				  case '1033': return "Srta"; break;
				  case '1034': return "Domingo"; break;
				  case '1035': return "Lunes"; break;
				  case '1036': return "Martes"; break;
				  case '1037': return "Mi�rcoles"; break;
				  case '1038': return "Jueves"; break;
				  case '1039': return "Viernes"; break;
				  case '1040': return "S�bado"; break;
				  case '1041': return "Masculino"; break;
				  case '1042': return "Femenino"; break;
				  case '1043': return "Persona"; break;
				  case '1044': return "Problema"; break;
				  case '1045': return "Solucion"; break;
				  case '1046': return "El cliente ya existe"; break;
				  case '1047': return "Sr."; break;
				  case '1048': return "Sra."; break;
				  case '1049': return "Srta."; break;
				  case '1050': return "Empresa"; break;
                    case '1051': return cdos_mostrarAlert("No se puede repetir el tipo Clasificacion.");break;
                    case '1052': return cdos_mostrarAlert("Es obligatorio seleccionar un territorio.");break; 
                                      case '1053': return "Domingo"; break;
                                      case '1054': return "El campo C�d. subacceso es obligatorio."; break;
                                      case '1055': return "El campo Descripci�n es obligatorio."; break;
                                      case '1056': return "El campo Canal es obligatorio."; break;
                                      case '1057': return "El campo Acceso es obligatorio."; break; 
                                      case '1058': return "El campo Ubigeo es obligatorio."; break;
                                      case '1059': return  cdos_mostrarAlert("Si atributo visible, obligatorio y no modificable, el valor no puede ser nulo."); break;
                                      case '1060': return  cdos_mostrarAlert("El campo confirmaci�n de documento no coincide con el n� de documento de identidad."); break;
                                      case '1061': return  cdos_mostrarAlert("Debe marcar un documento como principal."); break;
                                      case '1062': return "� Desea guardar los cambios efectuados ?"; break;
                                      case '1063': return "� Desea volver a la pantalla anterior ?"; break;
                                      case '1064': return cdos_mostrarAlert("El campo de Nro de pedidos estimados es numerico");break;
                                      case '1065': return cdos_mostrarAlert("Debe ingresar un Nombre de perfil");break;
                                      case '1066': return cdos_mostrarAlert("Debe elegir una funcion final como inicio");break;
                                      case '1064': return cdos_mostrarAlert("El campo de Nro de pedidos estimados es numerico");break;
                                      case '1067': return cdos_mostrarAlert("El campo Nro de pedidos estimados es obligatorio"); break;
                                      case '1068': return cdos_mostrarAlert("El campo de Unidades estimadas es numerico"); break;
                                      case '1069': return cdos_mostrarAlert("El campo Unidades estimadas es obligatorio"); break;                   
					                  case '1070': return cdos_mostrarAlert("El campo Clientes estimados es obligatorio"); break;
                                      case '1071': return cdos_mostrarAlert("El campo de Clientes estimados es numerico"); break;	
                                      case '1072': return cdos_mostrarAlert("El campo Valor estimado es obligatorio"); break;
                                      case '1073': return cdos_mostrarAlert("El campo de Valor estimado debe ser numerico"); break;
                                      case '1074': return cdos_mostrarAlert("El campo Tipo cambio es obligatorio"); break;
                                      case '1075': return cdos_mostrarAlert("El campo de Tipo cambio debe ser numerico"); break;
                                      case '1076': return "El campo Marca es obligatorio"; break;
                                      case '1077': return cdos_mostrarConfirm("�Desea realmente eliminar los registros seleccionados?"); break;
                                      case '1078': return cdos_mostrarAlert("Debe seleccionar una unidad geogr�fica."); break;	
                    case '1079': return cdos_mostrarAlert("Debe marcar una direcci�n como direcci�n principal."); break;  
                    case '1080': return cdos_mostrarAlert("Debe ingresar una clasificaci�n completa."); break;    

                                      case '1081': return cdos_mostrarAlert("El campo Tipo Via es obligatorio"); break;	
                                      case '1082': return cdos_mostrarAlert("El campo Nombre via es obligatorio"); break;	
                                      case '1083': return cdos_mostrarAlert("El campo Unidad geografica orden 1 es obligatorio"); break;	
                                      case '1084': return cdos_mostrarAlert("El campo Unidad geografica orden 2 es obligatorio"); break;	
                                      case '1085': return cdos_mostrarAlert("El campo Unidad geografica orden 3 es obligatorio"); break;	
                                      case '1086': return cdos_mostrarAlert("El nombre de perfil no es v�lido"); break;
                                      case '1087': return cdos_mostrarAlert("No hay ning�n subproceso seleccionado"); break;
                                      case '1088': return cdos_mostrarAlert("Introduzca el importe para la divisa que ha seleccionado"); break;
                                      case '1089': return cdos_mostrarAlert("Seleccione una divisa para el importe divisa introducido"); break;

                                      case '1090': return "Acceso"; break;
                                      case '1091': return "Total"; break;
                                      case '1092': return cdos_mostrarAlert("El importe a aplicar no puede ser mayor que el importe pendiente"); break;
                                      case '1093': return cdos_mostrarAlert("El importe a aplicar no puede ser mayor que el importe de la cuota"); break;
                                      case '1094': return "Pesta&ntilde;a 1"; break;		 
                                      case '1095': return "Pesta&ntilde;a 2"; break;		 
                                      case '1096': return "Pesta&ntilde;a 3"; break;		 
                                      case '1097': return "Pesta&ntilde;a 4"; break;		
                                      case '1098': return cdos_mostrarAlert("Debe especificarse UNA marca salida"); break;
                                      case '1099': return cdos_mostrarAlert("El campo Proceso es obligatorio"); break;
                                      case '1100': return cdos_mostrarAlert("El campo Subproceso es obligatorio"); break;
                                      case '1101': return cdos_mostrarAlert("El campo Tipo de abono/cargo es obligatorio"); break;
                                      case '1102': return cdos_mostrarAlert("Debe seleccionar Entrada o Salida"); break;
                                      case '1103': return cdos_mostrarAlert("No se puede repetir el tipo de direcci�n"); break;
                                      case '1104': return cdos_mostrarAlert("No puede haber mas de un registro para un tipo de tarjeta dado"); break;
                                      case '1105': return "Valor por defecto"; break;
                                      case '1106': return cdos_mostrarAlert("El campo Nombre campo es obligatorio"); break;
                                      case '1107': return cdos_mostrarAlert("El campo Tipo Cliente es obligatorio."); break;	
                                      case '1108': return cdos_mostrarAlert("El campo SubTipo Cliente es obligatorio."); break;	
                                      case '1109': return cdos_mostrarAlert("El campo Valor por Defecto es obligatorio."); break;	

                                      case '1111': return cdos_mostrarAlert("S�lo se pueden eliminar elementos que no tengan otros elementos dependientes."); break;	
                                      case '1112': return cdos_mostrarAlert("El A�o debe tener formato: aaaa"); break;	
                                      case '1113': return cdos_mostrarAlert("El campo mes esta mal informado"); break;	
                                      case '1114': return cdos_mostrarAlert("El campo codigo sap es obligatorio"); break;	
                                      case '1115': return cdos_mostrarAlert("El campo territorio es obligatorio"); break;	
                    
                                      case '1116': return cdos_mostrarAlert("El campo Tipo Direcci�n es obligatorio."); break;			
                                      case '1117': return cdos_mostrarAlert("El campo Nombre Via es obligatorio."); break;			
                                  case '1118': return cdos_mostrarAlert("El campo Tipo Via es obligatorio."); break;	
                                  case '1119': return cdos_mostrarAlert("El campo Via es obligatorio."); break;
                                  case '1120': return cdos_mostrarAlert("El campo Codigo Postal es obligatorio."); break;
                                  case '1121': return cdos_mostrarAlert("El campo Interior es obligatorio."); break;
                                  case '1122': return cdos_mostrarAlert("El campo Manzana es obligatorio."); break;
                                  case '1123': return cdos_mostrarAlert("El campo Lote es obligatorio."); break;
                                      case '1124': return cdos_mostrarAlert("El campo Kilometro es obligatorio."); break;
                                      case '1125': return cdos_mostrarAlert("El campo Numero Principal es obligatorio."); break;
                                      case '1126': return cdos_mostrarAlert("El cliente solo puede tener definido un tipo de documento como principal."); break;
                                      case '1127': return cdos_mostrarAlert("El elemento no puede ser padre de si mismo."); break;
                                      case '1128': return "El numero de documento introducido no tiene 10 caracteres:"; break;				  
                                      case '1129': return cdos_mostrarAlert("El rango de valores debe estar entre 1 y 999."); break;
                                      case '1130': return cdos_mostrarAlert("El cliente s�lo puede tener una direcci�n principal."); break;
                                      case "1131": return cdos_mostrarAlert("El proceso de gesti�n de cheques no est� definido para el pais activo"); break;
                                      case '1132': return "Normal"; break;
                                      case '1133': return "Adicional"; break;
                                      case '1134': return "Pendiente"; break;
                                      case '1135': return "Aplicado"; break;
                                      
                                      //Modificado por Gaston Acevedo en respuesta a la incidencia BELC300004711
                                      //este mensaje deberia ser el 503
                                      //case '1136': return "El campo Indicador impuesto es obligatorio"; break;
                                      case '1136': return "El tama�o del c�digo de cliente introducido excede el tama�o definido para el pa�s actual";
                                      //Fin de la modificacion de GAcevedo


                                      
                                      case '1137': return "No se puede eliminar la depuraci�n porque no se pudieron retroceder todos los movimientos"; break;
                                      
                                      case '1138': return "El campo Descripci�n SAP es obligatorio"; break;         
                                      case '1139': return "El campo C�digo antiguo es obligatorio"; break;     
                                      case '1140': return "El campo Descripci�n corta es obligatorio"; break;    
                                      case '1141': return "El campo Indicador lote es obligatorio"; break;
                                      case '1142': return "El campo Indicador P / S es obligatorio"; break; 
                                      case '1143': return "El campo Unidad negocio es obligatorio"; break;
                                      case '1144': return "El campo Negocio es obligatorio"; break;    
                                      case '1145': return "El campo Gen�rico es obligatorio"; break;
                                      case '1146': return "El campo Supergen�rico es obligatorio"; break;
                                      case '1147': return "El campo Jerarqu�a1 es obligatorio"; break;          
                                      case '1148': return "El campo Jerarqu�a2 es obligatorio"; break;
                                      case '1149': return "El campo Jerarqu�a3 es obligatorio"; break;   
                                      case '1150': return "El campo L�nea es obligatorio"; break;        
                                      case '1151': return "El campo Atributo1 es obligatorio"; break;
                                      case '1152': return "El campo Atributo2 es obligatorio"; break;
                                      case '1153': return "El campo Atributo3 es obligatorio"; break;    
                                      case '1154': return "El campo Dimensi�n alto es obligatorio"; break;
                                      case '1155': return "El campo Dimensi�n largo es obligatorio"; break;
                                      case '1156': return "El campo Dimensi�n ancho es obligatorio"; break;   
                                      case '1157': return "El campo Unidad medida dimensiones es obligatorio"; break;
                                      case '1158': return "El campo Volumen es obligatorio"; break;
                                      case '1159': return "El campo Unidad medida volumen es obligatorio"; break;   
                                      case '1160': return "El campo Peso es obligatorio"; break;
                                      case '1161': return "El campo Unidad medida peso es obligatorio"; break;
                                      case '1162': return "El campo Unidades dentro pedido es obligatorio"; break;
                                      case '1163': return "El campo Unidades por caja es obligatorio"; break;
                                      case '1164': return "El campo Coste est�ndar es obligatorio"; break;
                                      case '1165': return "El campo Precio posicionamiento es obligatorio"; break;
                                      case '1166': return "El campo Situacion es obligatorio"; break;
                                      case '1167': return "El campo Estatus producto es obligatorio"; break;
                                      case '1168': return "El campo Indicador dentro caja es obligatorio"; break;   
                                      case '1169': return "El campo Forma pago es obligatorio"; break;
                                      case '1170': return "El campo Precio cat�logo es obligatorio"; break;
                                      case '1171': return "El campo Precio contable es obligatorio"; break;
                                      case '1172': return "El campo C�digo SAP es obligatorio"; break;
                                      case '1173': return "El campo % unidades es obligatorio"; break;

                                      case '1174': return "El campo Dimensi�n alto debe ser num�rico"; break;
                                      case '1175': return "El campo Dimensi�n largo debe ser num�rico"; break;
                                      case '1176': return "El campo Dimensi�n ancho debe ser num�rico"; break;
                                      case '1177': return "El campo Peso debe ser num�rico"; break;
                                      case '1178': return "El campo Volumen debe ser num�rico"; break;
                                      case '1179': return "El campo Unidades dentro pedido debe ser num�rico"; break;
                                      case '1180': return "El campo Unidades por caja debe ser num�rico"; break;
                                      case '1181': return "El campo % unidades debe ser num�rico"; break;

                                      	  
                                      case '1182': return "El campo Coste est�ndar debe tener el formato " + arg1; break;
                                      case '1183': return "El campo Precio posicionamiento debe tener el formato " + arg1; break;
                                      case '1184': return "El campo Precio cat�logo debe tener el formato " + arg1; break;
                                      case '1185': return "El campo Precio contable debe tener el formato " + arg1; break;
                                      case '1186': return "El campo C�digo antiguo es obligatorio"; break;
                                      case '1187': return "El campo Territorio es obligatorio"; break;
                                      case '1188': return "El campo Indicador impuesto es obligatorio"; break;
                                      case "1189": return cdos_mostrarAlert("El movimiento al que hace referencia est� incompleto"); break;
                                      case "1190": return cdos_mostrarAlert("La referencia al cargo abono directo relacionado est� incompleta. Rellene todos los campos, por favor."); break;
                                      case "1191": return cdos_mostrarAlert("La fecha desde debe ser menor que la fecha hasta"); break;
                                      case "1192": return cdos_mostrarAlert("La fecha de contacto debe ser menor que la fecha de siguiente contacto"); break;
                                      case "1193": return cdos_mostrarAlert("El cliente s�lo puede tener una direcci�n principal"); break;
                                      case "1194": return "Pesta�a"; break;
                                      case "1195": return "Hora Hasta"; break;
                                      case "1196": return "Hora Desde"; break;
									  case "1197": return cdos_mostrarAlert("El campo N� unidades debe ser num�rico "); break;
									  case "1198": return cdos_mostrarAlert("El cliente s�lo puede tener una comunicaci�n principal."); break;
									  case "1199": return cdos_mostrarAlert("El cliente s�lo puede tener un v�nculo principal."); break;	
									  case "1200": return "El campo Indicador impuesto es obligatorio"; break;
									  case '1201': return cdos_mostrarAlert("El campo "+arg1+" es obligatorio.");  break;
									  case "1202": return cdos_mostrarAlert( "Debe especificar un valor por defecto para el valor " +arg1); break;	
									  case "1203": return cdos_mostrarAlert( "Indicador 'afecta a facturas' y 'afecta a cuenta corriente' no pueden ambos entre sus valores posibles el valor 'SI'"); break;	

									  case "1204": return cdos_mostrarAlert( "El numero de Orden no puede ser nulo"); break;
									   case "1206": return cdos_mostrarAlert( "Debe ingresar numeros en Nro de Orden"); break;
									   case "1207": return "Antes de cuadre"; break;
									   case "1208": return "Despues de cuadre"; break;
									   case "1209": return cdos_mostrarAlert( "No existen c�digos de reemplazo para el c�digo introducido"); break;
									   case "1210": return cdos_mostrarAlert( "No existen c�digos de recuperaci�n para el c�digo introducido"); break;
									   case "1211": return cdos_mostrarAlert( "No existen c�digos alternativos por criterios introducidos"); break;
										case "1212": return cdos_mostrarConfirm("� Desea volver a la pantalla de conexi�n del sistema ?");
										case "1213": return "�Esta seguro de que desea eliminar este lote?"; break;
										
										case "1214": return cdos_mostrarConfirm("� Desea volver a la pantalla de inicio del Sistema  ?");

										case "1216": return cdos_mostrarAlert("La fecha del primer contacto debe ser anterior a la fecha del siguiente contacto"); break;
										case "1217": return cdos_mostrarAlert("Debe seleccionar solo un elemento"); break;
										case "1218": return cdos_mostrarAlert("Debe seleccionar un elemento para eliminar"); break;	
										case "1219": return cdos_mostrarAlert("Solo se puede devolver un elemento, y ya hay un elemento en la lista temporal"); break;	
										case "1220": return cdos_mostrarAlert("No hay ning�n elemento en la lista temporal"); break;	
										case "1221": return cdos_mostrarAlert("No hay ning�n elemento en la lista temporal"); break;	
	
									    case "1223": return cdos_mostrarAlert("Se debe seleccionar un elemento"); break;	
										case "1224":  return cdos_mostrarAlert("El campo " + arg1 + " debe ser n�merico" ) ; break;
										case "1225":  return cdos_mostrarAlert("Debe seleccionar un resultado de b�squeda" ) ; break;
										case "1226":  return cdos_mostrarAlert("Solo puede seleccionar un producto" ) ; break;
										case "1227":  return cdos_mostrarAlert("Debe seleccionar un producto para eliminar" ) ; break;
										case "1228":  return cdos_mostrarAlert("El producto ya se encuentra en la lista" ) ; break;
						   			    case "1229":  return cdos_mostrarConfirm("Ya existe un cronograma para la marca, el canal y el periodo dados, si contin�a se borrar� el cronograma y se volver� a generar. �Desea continuar?");  break;
                                       	case "1230":  return cdos_mostrarAlert("No existe ninguna matriz para copiar");  break;
										case '1231': return "Enero"; break;
										case '1232': return "Febrero"; break;
										case '1233': return "Marzo"; break;
										case '1234': return "Abril"; break;
										case '1235': return "Mayo"; break;
										case '1236': return "Junio"; break;
										case '1237': return "Julio"; break;
										case '1238': return "Agosto"; break;
										case '1239': return "Septiembre"; break;
										case '1240': return "Octubre"; break;
										case '1241': return "Noviembre"; break;
										case '1242': return "Diciembre"; break;
										case '1243': return cdos_mostrarAlert("El campo debe de ser num�rico");  break;	
										case '1244': return "Grupo zona"; break;
										case '1245': return "Zona"; break;
	                                    case '1246': return cdos_mostrarAlert("Debe seleccionar una matriz de origen"); break;
                                        case '1247': return cdos_mostrarAlert("Debe seleccionar una matriz nueva"); break;
										case '1248': return cdos_mostrarAlert("El campo Tipo campo es obligatorio"); break;
										case '1249': return cdos_mostrarAlert("El descuento se ha definido como nacional. No se pueden seleccionar unidades administrativas para la aplicaci�n a no ser que aplique descuento adicional"); break;
										case "1253":  return cdos_mostrarAlert("El N� orden del producto " + arg1 + " debe ser n�merico" ) ; break;
										case "1254":  return cdos_mostrarAlert("El N� orden del producto " + arg1 + " es obligatorio" ) ; break;

										case "1263":  return cdos_mostrarAlert("El campo " + arg1 + " solo admite "+ arg2 +" valores");break;
										case "1264":  return cdos_mostrarAlert("El campo " + arg1 + " es obligatorio"); break;
										case "1265":  return cdos_mostrarAlert("Debe ingresar al menos un elemento en la lista de" + arg1); break;
										case "1266":  return cdos_mostrarAlert("Se debe definir al menos una escala v�lida"); break;
										case "1267":  return cdos_mostrarAlert("Existen huecos en la escala"); break;

										case "1268":  return "La opci�n" + arg1 + "es excluyente y no se puede combinar con el resto"; break;
					                    case '1269': return cdos_mostrarConfirm("�Desea eliminar la actividad del cronograma?"); break;
										case '1270': return cdos_mostrarAlert("Formato de Fecha incorrecto"); break;
										case '1271': return cdos_mostrarAlert("Boton habilitado"); break;
										case '1272': return "Cumplea�os"; break;
										case '1273': return "Aniversario"; break;
										case '1274': return "Edad"; break;
										case '1275': return "Pedido Supera Monto"; break;
										case '1276': return "Pedido Supera Monto en Marca"; break;
										case '1277': return "Pedido Supera Monto en Unidad de Negocio"; break;
										case '1278': return "Pedido Supera Monto en Negocio"; break;
										case '1279': return "Pedido Supera Monto en Cat�logo"; break;
										case '1280': return cdos_mostrarAlert("Debe elegir al menos una marca como entrada"); break;
										case '1281': return cdos_mostrarAlert("Base de Aplicaci�n Guardada"); break;
										case '1282': return cdos_mostrarAlert("Base de C�lculo Guardada"); break;
										case '1283': return cdos_mostrarAlert("El campo Numero de Unidades es obligatorio"); break;
										case '1284': return cdos_mostrarAlert("El campo Numero de Unidades solo puede contener valores num�ricos"); break;
										case '1285': return cdos_mostrarAlert("El valor del campo Numero de Unidades debe ser mayor que cero"); break;
										case '1286': return cdos_mostrarAlert("Si se seleccciona un Per�odo Desde, se debe seleccionar un Per�odo Hasta"); break;
										case '1287': return cdos_mostrarAlert("El nivel de orden " + arg1 + " se encuentra repetido en la secuencia.");  break;
						   			    case "1288": return cdos_mostrarConfirm("�Desea que la actividad deje de ser fija?");  break;

						   			    case "1290": return cdos_mostrarConfirm("�Desea eliminar el cronograma?");  break;
										case "1291": return "Aceptar"; break;
										case "1292": return "Continuar"; break;
										case "1293": return "F�rmula de Reparto"; break;
										case "1294": return cdos_mostrarAlert("El campo " + arg1 + " es obligatorio"); break;
										case "1295": return "N�mero de Unidades Totales a Asignar"; break;
										case "1296": return cdos_mostrarAlert("El valor del campo " + arg1 + " debe mayor que cero"); break;
										case "1297": return cdos_mostrarAlert("El campo " + arg1 + " s�lo puede contener valores num�ricos"); break;
										case "1298": return "Variables de Venta"; break;
										case "1299": return cdos_mostrarAlert("Se debe seleccionar el c�digo de configuraci�n a copiar.");break;		
										case '1300': return cdos_mostrarAlert("El Campo C�digo Movimiento es obligatorio."); break;
										case '1301': return cdos_mostrarAlert("El Campo Descripci�n es obligatorio."); break;
										case '1302': return cdos_mostrarAlert("El Campo C�digo Movimiento SAP es obligatorio."); break;
						
										case "1305": return cdos_mostrarAlert("El campo Empresa es obligatorio");break;
										case "1306": return cdos_mostrarAlert("El campo N� Lote es obligatorio");break;
										case "1307": return cdos_mostrarAlert("El campo Cuenta corriente bancaria es obligatorio");break;
										case "1308": return cdos_mostrarAlert("El campo Consecutivo transacci�n es obligatorio ");break;
										case "1309": return cdos_mostrarAlert("El campo Tipo transacci�n es obligatorio");break;
										case "1310": return cdos_mostrarAlert("No es posible eliminar el usuario con el que ha accedido al sistema");break;
										case "1311": return "Eliminar Cronograma";break;
										case "1312": return "Consultar Cronograma";break;
										case '1313': return cdos_mostrarAlert("Fecha inv�lida o formato incorrecto de fecha. " + arg1); break;
										
										case '1314': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� lote"); break;
										case '1315': return cdos_mostrarAlert("Debe ingresar n�meros en el campo Consecutivo transacci�n"); break;
										case '1316': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� factura"); break;
										case '1317': return cdos_mostrarAlert("Debe ingresar n�meros en el campo Digito chequeo"); break;
										case '1318': return cdos_mostrarAlert("Debe ingresar n�meros en el campo Importe pago"); break;
										case '1319': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� cup�n"); break;
										case '1320': return cdos_mostrarAlert("Debe ingresar n�meros en el campo Oficina recaudadora"); break;
										case '1321': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� doc. creaci�n"); break;
										case '1322': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� documento aplicaci�n"); break;
										
										case '1324': return "Esta operaci�n har� que se borren los datos de la lista no guardados. �Est� seguro de que desea continuar?"; break;
										case '1325': return "La suma de los pocentajes sumados de las l�neas de detalle debe ser igual a 100%"; break;
                                      	case '1347': return "Debe introducir al menos un criterio"; break;
                                      	case '1348': return "El saldo resultante de la restisuma de los distintos conceptos debe ser 0"; break;
										case '1351': return "Peso"; break;
										case '1352': return "Dimensi�n Alto"; break;
										case '1353': return "Dimensi�n Ancho"; break;
										case '1354': return "Dimensi�n Largo"; break;
										case '1355': return "Volumen"; break;
										case '1356': return "Unidades por Caja"; break;
										case '1357': return "Unidades Dentro Pedido"; break;
										case '1358': return "Coste Estandar"; break;
										case '1359': return "Precio de Posicionamiento"; break;
										case '1360': return "Precio Cat�logo"; break;
										case '1361': return "Precio Contable"; break;
										case '1362': return "Porcentaje Unidades"; break;

										case '1364': return cdos_mostrarAlert("Hay que especificar L�mite de Venta"); break;
										case '1365': return cdos_mostrarAlert("El nivel 2 debe ser mayor que el nivel 1"); break;
										case '1366': return cdos_mostrarAlert("El nivel 3 debe ser mayor que el nivel 2"); break;
										case '1367': return cdos_mostrarAlert("La validaci�n de la cabecera de la solicitud no es correcta "); break;
										case '1369': return cdos_mostrarConfirm("Han quedado grupos de zonas sin zonas. �Desea mantener esta situaci�n?");break;	
  				    				    case '1379': return cdos_mostrarConfirm("Han quedado zonas sin asignar. �Desea mantener esta situaci�n?");break;
										case '1380': return cdos_mostrarAlert("Debe informar un valor por defecto en la inserci�n obligatoria"); break;
										case '1381': return cdos_mostrarAlert("Debe introducir un �nico valor por defecto para cada atributo"); break;
										case '1382': return cdos_mostrarAlert("El campo ID valor por defecto debe ser un n�mero entero"); break;
										case '1383': return cdos_mostrarAlert("El campo Indicador rastreo es obligatorio"); break;

										case '1386': return cdos_mostrarAlert("Debe seleccionar un Subcriterio de Asignaci�n"); break;
										case '1387': return cdos_mostrarAlert("Debe seleccionar el importe o porcentaje del descuento a aplicar excluyentemente"); break;										

										case '1390': return cdos_mostrarAlert("Los n�meros de Secuencia deben ser enteros, mayores que cero y menores o iguales que 999999."); break;										
										case '1391': return cdos_mostrarAlert("No existen m�s bases de aplicaci�n"); break;
										case '1392': return cdos_mostrarAlert("Debe a�adir un registro a la lista"); break;
										case '1393': return cdos_mostrarAlert("N�mero inv�lido: caracteres permitidos: 0123456789."); break;
										case '1394': return cdos_mostrarAlert("No se pueden seleccionar criterios para la base de c�lculo y productos"); break;
										case '1395': return ("Fecha inv�lida o formato de fecha inv�lido. El formato de fecha v�lido es: " + arg1); break;
										/*  inicio CAMBIO MSG 002 - pperez  */
										/*case '1398': return cdos_mostrarAlert('La opci�n Generaci�n de Pedidos es excluyente y no se puede combinar con el resto');break;    */
	                                    case '1398': return cdos_mostrarAlert('La opci�n Generacion de Pedido s�lo se puede combinar con las opciones Unidades Administrativas y Tipo de Cliente');break;  
										/*  fin CAMBIO MSG 002 - pperez  */
										case '1399': return cdos_mostrarAlert('La opci�n Lista de Consultoras es excluyente y no se puede combinar con el resto');break;   
  									    case '1400': return cdos_mostrarAlert('N�mero de secuencia repetido');break;
    					                case '1401': return cdos_mostrarAlert('Hay territorios sin n�mero de secuencia asignado');break;
                     					case '1402': return "Debe rellenar al menos el rango documento interno o la serie y rango documento legal";break;
                                        case '1403': return cdos_mostrarAlert("El fichero de consultoras se ha procesado correctamente, todas las consultoras tienen el mensaje correspondiente asociado.");break;
                      					case '1404': return cdos_mostrarAlert("El campo Codigo Venta es obligatorio.");break;	
                     		  			case '1405': return cdos_mostrarAlert("Debe introducir al menos dos criterios de filtro");break;
										case '1406': return cdos_mostrarAlert("Si el el tipo de mensaje es G2, el destinatario debe ser lista de consultoras o generaci�n de pedidos.");break;
									    case '1407': return cdos_mostrarAlert("Si el el tipo de mensaje es G1, el destinatario no puede ser lista de consultoras ni generaci�n de pedidos.");break;
									    case '1410': return "Fecha de Entrega"; break;
										case '1411': return "Pendiente de Envio"; break;
										case '1412': return "Enviado"; break;
										case '1414': return cdos_mostrarAlert("La fecha de contacto debe ser menor que la fecha de siguiente contacto"); break;
										case '1415': return cdos_mostrarAlert("Es obligatorio seleccionar un tipo de oferta"); break;
										case '1416': return cdos_mostrarAlert("Debe seleccionar un Tipo de Cliente Contactado"); break;
										case '1419': return cdos_mostrarAlert("Deben rellenarse todos los campos obligatorios por tipo y subtipo de cliente"); break;
										case '1420': return cdos_mostrarAlert("Debe completar la informaci�n correspondiente a los datos generales del patr�n"); break;
										case '1421': return cdos_mostrarAlert("Datos incompetos. Compruebe que ha introducido la informaci�n de la secci�n y ha a�adido alg�n mensaje"); break;
										case '1422': return cdos_mostrarAlert("Necesita a�adir alguna secci�n al patr�n antes de guardarlo"); break;
										case '1423': return cdos_mostrarAlert("No se eliminar�n los patrones que sirvan de origen para otros"); break;
										case '1424': return cdos_mostrarAlert("Necesita a�adir alguna secci�n al patr�n para poder visualizarlo"); break;
										case '1425': return cdos_mostrarAlert("El c�digo de patr�n utilizado no es v�lido"); break;
										case '1426': return cdos_mostrarAlert("El orden de impresi�n de los mensajes es incorrecto"); break;
										case '1427': return cdos_mostrarConfirm("Existen zonas sin asignar. �Esta seguro que desea guardar?"); break;
 										case '1428': return cdos_mostrarAlert("Subsistema de reimpresi�n no implementado"); break;
 										case '1429': return "Debe introducir o el n�mero de cup�n o el c�digo de cliente e importe"; break;
										case '1430': return cdos_mostrarAlert("El descuento se ha definido como No Nacional. Se deben seleccionar unidades administrativas de aplicaci�n"); break;
										case '1431': return cdos_mostrarAlert("Debe introducir al menos un valor de L�mite de Venta, Control de Stock o Control de Liquidaci�n"); break;
										case '1432': return cdos_mostrarAlert("No puede activar indicador anulaciones y devoluciones simult�neamente, active s�lo uno"); break;
										case '1433': return cdos_mostrarAlert("Importe pendiente tiene signo diferente a importe a aplicar"); break;
										case '1435': return cdos_mostrarAlert("La actividad que desea eliminar est� marcada como fija. No se puede completar la acci�n"); break;
										case '1437': return cdos_mostrarAlert("No se pueden ingresar mas clasificaciones"); break;
										case '1442': return cdos_mostrarAlert("La lista de Criterios Seleccionados debe contener al menos una l�nea"); break;
										case '1451': return "Fichero con formato incorrecto"; break;
										case '1452': return cdos_mostrarAlert("Buz�n nuevo no puede ser igual que buz�n actual"); break;
										case '1463': return cdos_mostrarAlert("Canal y/o Acceso del usuario no coinciden con Canal y/o Acceso del Tipo de solicitud"); break;
										case '1464': return cdos_mostrarAlert("El fichero se ha generado correctamente."); break;
										case '1466': return cdos_mostrarAlert("La fecha introducida no es correcta."); break;
										case '1467': return cdos_mostrarAlert("No se han encontrado etapas de cobranzas por lo que no se puede generar el cronograma."); break;
										case '1468': return cdos_mostrarAlert("No se han modificado datos."); break;
										case '1469': return cdos_mostrarAlert("Se debe seleccionar al menos un interfaz"); break;
										case '1473': return "Fecha de Cierre"; break;
										case '1474': return cdos_mostrarAlert("Debe especificar un solo criterio de b�squeda"); break;

										case '1475': return "Llamada con IVR"; break;
										case '1476': return "Crear gesti�n"; break;
										case '1477': return "Consultar datos cliente"; break;
										case '1478': return "Consultar consultoras por compromiso pago"; break;
										case '1479': return "Consultar consultoras por tipo acci�n"; break;
										case '1480': return "Consultar consultoras por gesti�n de pago"; break;
										case '1481': return "Consultar hist�rico deuda"; break;
										case '1482': return "Consultar hist�rico cobranza"; break;
										case '1483': return "Consultar gu�as argumentales"; break;										
										case '1484': return cdos_mostrarConfirm("Debe seleccionar un valor en el campo " + arg1 + " Desde"); break;
										case '1485': return cdos_mostrarAlert("Al menos debe haber un campo informado"); break;
										case '1487': return cdos_mostrarAlert("Se debe seleccionar �nicamente un elemento de la lista"); break;
										case '1488': return cdos_mostrarAlert("Se tratar�n s�lo aquellas liquidaciones"); break;
										case '1489': return cdos_mostrarAlert("Edad Desde debe ser menor o igual que Edad Hasta"); break;
										case '1490': return cdos_mostrarExito("Liquidaciones Generadas"); break;
									    case '1491': return cdos_mostrarAlert("S�lo se puede realizar exclusi�n sobre una inclusi�n por jerarqu�a");break;
										case '1492': return cdos_mostrarAlert("Debe especificar al menos un tipo de cliente para la comisi�n");break;
							  		    case '1493': return cdos_mostrarAlert("El campo Tope m�nimo debe ser menor o igual al campo Tope m�ximo");break;
		  								case '1494': return cdos_mostrarAlert("La Fecha antig�edad desde debe ser menor o igual a la Fecha antig�edad Hasta");break;
										case '1495': return cdos_mostrarAlert("La lista de productos v�lidos debe contener al menos un elemento");break;
										case '1497': return cdos_mostrarAlert("S�lo puede elegir un producto"); break;
										case '1498': return cdos_mostrarAlert("Debe existir al menos una variable de venta"); break;
										case '1499': return cdos_mostrarAlert("Debe existir al menos un monto de venta"); break;

										case '1500': return cdos_mostrarAlert("La descarga de la gu�a de productos se ha realizado con �xito"); break;
                                        case '1501': return cdos_mostrarAlert("Se ha producido un error en la descarga de la gu�a de productos"); break;
															 
										case '1502': return cdos_mostrarAlert(campo_obligatorio + "producto de recuperaci�n"); break;
										case '1503': return "Lunes a Viernes"; break;
										case '1504': return "Lunes a Domingo"; break;
										case '1505': return "Persona"; break;
										case '1506': return "Empresa"; break;

                                        case '1507': return "Pesta�a 1"; break;
                                        case '1508': return "Pesta�a 2"; break;
                                        case '1509': return "Pesta�a 3"; break;
                                        case '1510': return "Pesta�a 4"; break;
                                        case '1511': return "Tipo y Subtipo"; break;
                                        case '1512': return "Criterios B�squeda"; break;
                                   case '1513': return cdos_mostrarAlert("Los valores no pueden ser todos nulos."); break;
                                        case '1514': return cdos_mostrarAlert("Formato hora inv�lido. El formato de hora v�lido es: HH:mm"); break;
                                        case '1515': return "N�mero de Documento"; break;
                                        case '1516': return "N�mero de Hijos"; break;
                                        case '1517': return "N�mero de Personas Dependientes"; break;
                                        case '1518': return "N�mero Principal"; break;
                                        case '1519': return "Interior"; break;
                                        case '1520': return "Manzana"; break;
                                        case '1521': return "Lote"; break;
                                        case '1522': return "KM"; break;
                                      case '1523': return "Consultar v�nculo de jerarqu�a"; break;
                                      case '1524': return "Eliminar v�nculo de jerarqu�a"; break;
                         case '1525': return cdos_mostrarAlert("El campo Marca es obligatorio."); break;
                                      case '1526': return cdos_mostrarAlert("El campo C�d. subacceso es obligatorio."); break;
                                      case '1527': return cdos_mostrarAlert("El campo Descripci�n es obligatorio."); break;
                                      case '1528': return cdos_mostrarAlert("El campo Canal es obligatorio."); break;
                                      case '1529': return cdos_mostrarAlert("El campo Acceso es obligatorio."); break; 
                                      case '1530': return cdos_mostrarAlert("El campo Ubigeo es obligatorio."); break;
                                      case '1531': return "Eliminar subacceso"; break;
                                      case '1532': return cdos_mostrarAlert("El campo Indicador de cuadre es obligatorio."); break;
                                      case '1533': return cdos_mostrarAlert("El campo N� Orden debe ser numerico"); break;
                                      case '1534': return "El campo \""+arg1+"\" es obligatorio"; break;

									  case '1535': return "Capital"; break;
									  case '1536': return "Provincia"; break;
									  case '1537': return "Frontera"; break;

									  case '1538': return "Ventas"; break;
									  case '1539': return "Cobranza"; break;

						case '1540': return cdos_mostrarAlert("Funcionalidad no disponible en este paquete"); break;
		 			    case '1541': return cdos_mostrarAlert("Debe ingresar un valor para Comision o Importe Fijo"); break;
	   				    case '1542': return cdos_mostrarAlert("Los campos Comision e Importe Fijo son excluyentes"); break;
					    case '1543': return cdos_mostrarConfirm("La comisi�n est� incompleta �desea grabarla en estado \'\'En creaci�n\'\' ?"); break;
					    case '1544': return cdos_mostrarAlert("La plantilla seleccionada no tiene un tipo de comision asociado"); break;

						case '1545': return cdos_mostrarAlert("El campo \"Tipo Premio\" es obligatorio"); break;
						case '1546': return "Puntaje Servicio"; break;
						case '1547': return "Cantidad fija puntos"; break;
						case '1548': return "Cantidad desde"; break;
						case '1549': return "Cantidad hasta"; break;
						case '1550': return "Puntos por productos exigidos"; break;
						case '1551': return cdos_mostrarAlert("Debe definir premio para el tipo de premio y nivel seleccionado"); break;
						case '1552': return cdos_mostrarAlert("No se puede a�adir m�s premios porque el premio no es electivo"); break;
						case '1553': return "Bloque de Producto"; break;
						case '1554': return "Bloque de Negocio"; break;
						case '1555': return "Bloque de Oferta"; break;
						case '1556': return cdos_mostrarAlert("Alg�n nivel de premiaci�n ha cambiado, debe definir nuevamente las caracter�sticas de Programa Nuevas"); break;
						case '1557': return "N� aspirantes"; break;
					    case '1558': return "Cantidad"; break;
	  				    case '1559': return "Exigencia m�nima"; break;
						case '1560': return cdos_mostrarAlert("La opci�n de Premios electivos debe estar activa porque existen m�s de un premio en el lote"); break;
 	 				    case '1561': return cdos_mostrarAlert("Debe ingresar un valor en Puntos unidad o en Factor Multiplicidad"); break;
						case '1562': return cdos_mostrarAlert("El campo \"Forma de c�lculo\" es obligatorio"); break;
						case '1563': return cdos_mostrarAlert("El campo \"Base de c�lculo\" es obligatorio"); break;
						case '1564': return cdos_mostrarAlert("No se puede modificar un concurso que no est� en estado \"Autorizado\""); break;
						case '1565': return cdos_mostrarAlert("No se puede solicitar la puesta en marcha de un concurso que no est� en estado \"Modificaci�n\""); break;
						case '1566': return cdos_mostrarAlert("No se puede borrar una solicitud rechazada de un concurso que no est� en estado \"Rechazada Autorizaci�n\""); break;
						case '1567': return cdos_mostrarAlert("No se puede borrar una modificacion rechazada de un concurso que no est� en estado \"Rechazada Aprobaci�n\""); break;
						case '1568': return cdos_mostrarAlert("No se puede borrar una modificacion de un concurso que no est� en estado \"Modificaci�n\""); break;

						case '1569': return cdos_mostrarConfirm("Si se han definido datos en la pesta�a 'Par�metros Gerentes' se perder�n los mismos"); break;
						case '1570': return cdos_mostrarConfirm("Si se han definido datos en la pesta�a 'Par�metros Consultoras' se perder�n los mismos"); break;
						case '1571': return cdos_mostrarConfirm("Si se han definido datos en la pesta�a 'Par�metros Consultoras' y/o 'Par�metros Gerentes' se perder�n los mismos"); break;
						case '1572': return cdos_mostrarConfirm("Si se han definido datos en otras pesta�as se perder�n los mismos"); break;
						case '1573': return cdos_mostrarConfirm("Si se han definido datos en la pesta�a 'Variables Venta' se perder�n los mismos"); break;

						case '1574': return cdos_mostrarAlert("Tipo Venta Calificaci�n debe ser Venta Hist�rica o Venta Proyectada para poder calcular Metas"); break;
						case '1575': return cdos_mostrarAlert("Debe seleccionar una agrupaci�n"); break;
						case '1576': return cdos_mostrarAlert("Los campos Porcentaje incremento y Monto incremento son excluyentes"); break;
					    case '1577': return "Monto m�nimo"; break;
						case '1578': return cdos_mostrarAlert("El campo \"Cantidad fija puntos\" es obligatorio"); break;
						case '1579': return cdos_mostrarAlert("El campo \"Cantidad desde\" es obligatorio"); break;
						case '1580': return cdos_mostrarConfirm("Si se han definido Niveles se perder�n los mismos"); break;
						case '1581': return cdos_mostrarAlert("No hay gerentes a asignar premios"); break;
						case '1582': return cdos_mostrarAlert("El A�o debe tener formato: aa"); break;
						case '1583': return cdos_mostrarAlert("Caja cuadrada"); break;
						case '1584': return cdos_mostrarAlert("EN:No se pueden guardar premios consuelo sin especificar el campo mensaje"); break;

						case '10000': return cdos_mostrarAlert("Debe seleccionar al menos un estatus de venta para poder definir la lista de clasificaci�n participantes calificaci�n "); break;
				

                      case '1323': return  cdos_mostrarAlert('Aqu� se mostrar� el reporte de faltantes');break; 	                    
					
					

 
                    case '2455': return cdos_mostrarAlert("N�mero inv�lido: caracteres permitidos:0123456789"); break;
                    case '2456': return cdos_mostrarAlert("Uso erroneo del caracter -"); break;
                    case '2458': return cdos_mostrarAlert("Rango no v�lido"); break;
                    case '2459': return cdos_mostrarAlert("N�mero inv�lido: s�lo se permite un separador decimal."); break;
                    case '2460': return cdos_mostrarAlert("N�mero inv�lido: s�lo se permite un m�ximo de 6 d�gitos enteros y 2 d�gitos decimales."); break;
                    case '2461': return cdos_mostrarAlert("L�mite inferior de validaci�n no se ajusta al formato enteros.decimales"); break;
          
                    case '2463': return cdos_mostrarAlert("La secuencia debe ser un n�mero entre 0 y 999"); break;
                    case '2464': return cdos_mostrarAlert("El calendario debe tener al menos un dia feriado"); break;
                    case '2465': return cdos_mostrarAlert("N�mero inv�lido: s�lo se permite un m�ximo de 4 d�gitos enteros y 2 d�gitos decimales."); break;
                    case '2466': return cdos_mostrarAlert("N�mero inv�lido: s�lo se permite un m�ximo de 3 d�gitos enteros y 3 d�gitos decimales."); break;
                    case '2491': return cdos_mostrarAlert("El campo nivel 1 debe ser menor que el campo nivel 2."); break;
                    case '2492': return cdos_mostrarAlert("El campo nivel 2 debe ser menor que el campo nivel 3."); break;

                    case '2510': return cdos_mostrarAlert("El campo debe tener hasta 14 n�meros de parte entera y 2 de decimal"); break;
                    case '2511': return cdos_mostrarAlert("El campo debe tener hasta 5 n�meros de parte entera y 5 de decimal"); break;
                    case '2512': return cdos_mostrarAlert("El campo debe tener hasta 15 n�meros de parte entera y 5 de decimal"); break;

                    case '2513': return cdos_mostrarAlert("Falta campo obligatorio"); break;
                             case '2514': return cdos_mostrarConfirm("Estos cambios no afectar�n al Cronograma hasta que se realice una nueva generaci�n del mismo. �Desea Guardar de todos modos?"); break;
                    case '2515': return cdos_mostrarAlert("Debe seleccionar un Grupo de Zonas"); break;
                    case '2516': return cdos_mostrarAlert("La hora debe estar en formato HH:mm:ss. HH Debe ser un n�mero entre 0 y 23, mm un n�mero entre 0 y 59 y ss un n�mero entre 0 y 59."); break;
                    case '2518': return cdos_mostrarConfirm("Quedan zonas sin asignar. �Est� Ud. Seguro que desea salir?"); break;
                                      case '2519': return cdos_mostrarAlert("El campo comunidad es obligatorio"); break;
                                      case '2520': return cdos_mostrarAlert("No ha seleccionado una matriz");break;		
                                     case '2521': return cdos_mostrarAlert("Se deben cocolar en rango desde y hasta un numero entero positivo");break;		
                                      case '2522': return cdos_mostrarAlert("El rango desde es mayor al hasta");break;		
                                      case '2523': return cdos_mostrarAlert("Debe seleccionar al menos una fila para borrar");break;
                                      case '2524': return cdos_mostrarAlert("Se debe introducir al menos una venta exclusiva");break;
                    case '2525': return cdos_mostrarAlert("Solo puede seleccionar un registro."); break;
                    case '2526': return cdos_mostrarAlert("Debe seleccionar al menos un conjunto de tipo y subtipo."); break;
                    case '2527': return cdos_mostrarAlert("El campo tipo de documento es obligatorio."); break;
                    case '2528': return cdos_mostrarAlert("El campo n�mero de documento es obligatorio."); break;
                    case '2529': return cdos_mostrarAlert("El campo confirmacion n�mero de documento es obligatorio."); break;
                    case '2530': return cdos_mostrarAlert("El campo Persona o Empresa es obligatorio."); break;
                    case '2531': return cdos_mostrarAlert("El pa�s no tiene Estructura Geopol�tica definida."); break;
                                      case '2532': return cdos_mostrarAlert("Un Parametro no visible no puede ser Obligatorio."); break;
                                      case '2533': return cdos_mostrarConfirm("Se perder�n los datos de alcance de Clasificaci�n / TipoClasificaci�n �desea continuar?"); break;
                                      case '2534': return cdos_mostrarAlert("El campo Tipo de comunicacion es obligatorio"); break;
                                      case '2535': return cdos_mostrarAlert("El campo Hora desde debe contener un valor numerico entre 0 y 24"); break;
                                      case '2536': return cdos_mostrarAlert("El campo Tipo Direcci�n es obligatorio"); break;
                                      case '2537': return cdos_mostrarAlert("El campo V�a es obligatorio"); break;
                                      case '2538': return cdos_mostrarAlert("El campo N�mero es obligatorio"); break;
                                      case '2539': return cdos_mostrarAlert("El campo C�digo Postal es obligatorio"); break;
                                      case '2540': return cdos_mostrarAlert("El campo Interior es obligatorio"); break;
                                      case '2541': return cdos_mostrarAlert("El campo Manzana es obligatorio"); break;
                                      case '2542': return cdos_mostrarAlert("El campo Lote es obligatorio"); break;
                                      case '2543': return cdos_mostrarAlert("El campo Kilometro es obligatorio"); break;
                                      case '2544': return cdos_mostrarAlert("El campo Observaciones es obligatorio"); break;
                                      case '2545': return cdos_mostrarAlert("El campo Cliente vinculo es obligatorio"); break;
                                      case '2546': return cdos_mostrarAlert("El campo Tipo V�nculo es obligatorio"); break;
                                      case '2547': return cdos_mostrarAlert("El campo Tipo Preferencia es obligatorio"); break;
                                      case '2548': return cdos_mostrarAlert("El campo Marca Observaciones es obligatorio"); break;
          			  case '2549': return cdos_mostrarAlert("El campo Tipo Tarjeta es obligatorio"); break;
                                      case '2550': return cdos_mostrarAlert("El campo Tipo Soluci�n es obligatorio"); break;
                                      case '2551': return cdos_mostrarAlert("El campo Tipo Problema es obligatorio"); break;
                                      case '2552': return "El campo C�d. grupo es obligatorio."; break;
                                      case '2553': return "El campo Nombre grupo es obligatorio."; break;
                                      case '2554': return "Debe seleccionar un item en el combo Tipo facturaci�n."; break;
                                      case '2555': return cdos_mostrarAlert("El campo A�o debe ser num�rico"); break;
                                      case '2556': return cdos_mostrarAlert("El campo C�d. grupo debe ser num�rico entre 0 y 999"); break;
                                      case '2557': return cdos_mostrarAlert("Debe seleccionar una fila"); break;				
                                      case '2558': return cdos_mostrarAlert("En el campo Descripci�n estado no se pueden poner caracteres especiales"); break;
                                      case '2559': return cdos_mostrarAlert("ENGLISH: Los campos deben ser numericos no decimales"); break;
                                      case '2560': return cdos_mostrarAlert("El campo C�d. estado debe ser num�rico"); break;
                                      case '2561': return cdos_mostrarAlert("el campo indicado por el cursor es  obligatorio"); break;
                                      case '2562': return cdos_mostrarAlert("El campo Pagina desde debe ser numerico"); break;
                                      case '2563': return cdos_mostrarAlert("El campo Pagina hasta debe ser numerico"); break;
									  case '2564': return "Laborables"; break;
									  case '2565': return "Continuos"; break;
									  case '2566': return cdos_mostrarAlert("El a�o introducido es menor al actual"); break;

									  case '2596': return cdos_mostrarAlert("No existen registros que cumplan los criterios de b�squeda"); break;


									  case '1250': return cdos_mostrarAlert("El campo N� serie desde debe ser un numero entero");break;
									  case '1251': return cdos_mostrarAlert("El campo N� serie hasta debe ser un numero entero");break;
									  case '1255': return cdos_mostrarAlert("Debe ingresar un numero de lote");break;
									  case '1256': return cdos_mostrarAlert("Debe ingresar numeros en este campo");break;
									  case '1257': return cdos_mostrarAlert("Debe ingresar una Fecha de Pago");break;
									  case '1258': return cdos_mostrarAlert("Debe seleccionar una cuenta corriente");break; 
									  case '1259': return cdos_mostrarAlert("Debe seleccionar una empresa");break; 
									  case '1260': return cdos_mostrarAlert("Ha excedido la cantidad de registros permitidos" );break; 
									  case '1261': return cdos_mostrarAlert("No debe ingresar numeros en este campo" );break;					
									  case '1262': return "Debe seleccionar los registros que formar�n el lote de depuraci�n."; break;
									  case '1289': return cdos_mostrarConfirm("El precio marcado es superior al precio normal del producto.");

									  case '1314': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� lote"); break;
									  case '1315': return cdos_mostrarAlert("Debe ingresar n�meros en el campo Consecutivo transacci�n"); break;
									  case '1316': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� factura"); break;
									  case '1317': return cdos_mostrarAlert("Debe ingresar n�meros en el campo Digito chequeo"); break;
									  case '1318': return cdos_mostrarAlert("Debe ingresar n�meros en el campo Importe pago"); break;
									  case '1319': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� cup�n"); break;
									  case '1320': return cdos_mostrarAlert("Debe ingresar n�meros en el campo Oficina recaudadora"); break;
									  case '1321': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� doc. creaci�n"); break;
									  case '1322': return cdos_mostrarAlert("Debe ingresar n�meros en el campo N� documento aplicaci�n"); break;
									  case '1328': return cdos_mostrarAlert("Debe seleccionar un Almac�n para poder eliminarlo"); break;  
									  case '1329': return cdos_mostrarAlert("El regalo debe tener productos asociados");break;	
									  case '1330': return cdos_mostrarAlert("El campo Almacen es obligatorio.");break;
									  case '1331': return cdos_mostrarAlert("El campo Almacen Destino es obligatorio.");break;
									  case '1332': return "Lunes a Viernes"; break;
									  case '1333': return "Lunes a Domingo"; break;
								            									
									case '1335': return   cdos_mostrarAlert("Debe introducir, al menos, un criterio de b�squeda"); break;									  
									
									 case '1336': return cdos_mostrarAlert("Esta opci�n estar� disponible para la siguiente versi�n"); break;
									case '1337': return cdos_mostrarAlert(" Debe seleccionar un elemento de de la lista"); break;
									case '1334': return cdos_mostrarAlert("El flete m�nimo debe ser menor que el flete m�ximo");break;

									case '1339': return cdos_mostrarConfirm('Va a cambiar la campa�a. Se perder�n todos los cambios. �Est� seguro?'); break;
									case '1340': return "Facturas";
									case '1341': return "Cuentas Corrientes";
									case '1342': return cdos_mostrarAlert("La marca seleccionada se encuentra repetida"); break;	
									case '1343': return cdos_mostrarAlert("Se ha especificado un Control de Stock en unidades y en porcentaje"); break;	
                                  	case '1344': return cdos_mostrarAlert("Clave duplicada.");break;
									//Para obtener un codigo se debe ingresar a la aplicacion pertinente, y NO agregar un codigo sumandole 1 al ultimo
									case '1345': return cdos_mostrarAlert("Atenci�n, el pagador de la factura es diferente del cliente"); break;	
									case '1346': return cdos_mostrarAlert("Atenci�n, el receptor de la factura es diferente del cliente"); break;	
									case '1349': return cdos_mostrarAlert("El elemento ra�z no se puede consultar"); break;
									case '1350': return cdos_mostrarAlert("El elemento ra�z no se puede modificar"); break;	
									case '1413': return cdos_mostrarAlert("Debe seleccionar un registro de la lista"); break;

									case '1408': return "N� Unidades"; break;
									case '1455': return cdos_mostrarExito("Se ha re-evaluado la l�nea de cr�dito para las consultoras de la Subgerencia de ventas " + arg1.subgerenciaVentas + ", Regi�n " + arg1.region + ", Zona " + arg1.zona + ", Marca " + arg1.marca + ", Canal " + arg1.canal + " y Clase de solicitud " + arg1.claseSolicitud + " seleccionadas"); break;
									case '1456': return cdos_mostrarExito("Se ha re-evaluado el nivel de riesgo para las consultoras de la Subgerencia de ventas " + arg1.subgerenciaVentas + ", Regi�n " + arg1.region + ", Zona " + arg1.zona + ", Marca " + arg1.marca + ", Canal " + arg1.canal + " y Clase de solicitud " + arg1.claseSolicitud + " seleccionadas"); break;
									case '1459': return "Exito"; break;

								    case '4007' : return  cdos_mostrarAlert("El campo indicador impuesto  es obligatorio"); break;		
								    case '4008': return cdos_mostrarAlert("Se ha re-evaluado el nivel de riesgo y la l�nea de cr�dito para la consultora " + arg1); break;
								    case '4009': return cdos_mostrarAlert("Se ha re-evaluado la l�nea de cr�dito para la consultora " + arg1); break;
								    case '4010': return cdos_mostrarAlert("Se ha re-evaluado el nivel de riesgo para la consultora " + arg1); break;
								    case '50033' : return  cdos_mostrarAlert("Los reclamos seleccionados se pasaron a procesado"); break;	
								    case '50034' : return  cdos_mostrarAlert("S�lo se pueden pasar a procesados los reclamos en estado solicitado"); break;
                                    case '45789': return cdos_mostrarConfirm("Quedan zonas sin asignar. �Est� Ud. Seguro que desea guardar?"); break;
  								    case '50007': return cdos_mostrarConfirm("Se van a secuenciar las ofertas para la matriz de facturaci�n seleccionada.");break;	
									case '50010': return cdos_mostrarAlert("Solo puede visualizar reportes con status Finalizado"); break;		
									case '50011': return cdos_mostrarAlert("El registro no se puede Modificar"); break;	                  
			
									case '2567': return cdos_mostrarAlert("El campo \"Subl�nea\" es obligatorio"); break;
									case '2568': return cdos_mostrarAlert("El campo \"Zona\" es obligatorio"); break;
									case '2569': return cdos_mostrarAlert("El campo \"Bah�a inicial\" es obligatorio"); break;
									case '2570': return cdos_mostrarAlert("El campo \"Bah�a final\" es obligatorio"); break;
									case '2571': return cdos_mostrarAlert("No se ha introducido ninguna zona en linea de detalle"); break;
									case '2572': return "Zona"; break;
									case '2573': return "Bah�a inicial"; break;
									case '2574': return "Bah�a final"; break;

									case '2580': return cdos_mostrarAlert("Ya existe un Orden de Anaquel por defecto para los Centro de Distribuci�n, Mapa de CD y Mapa de Zonas seleccionados"); break;
									case '2581': return cdos_mostrarAlert("No se encontraron anaqueles sin expandir para el Mapa, L�nea y Subl�nea seleccionado"); break;
									case '2582': return cdos_mostrarAlert("Ya se selecciono ese N�mero de Anaquel"); break;
									case '2583': return cdos_mostrarAlert("No se ha asociado un n�mero de orden a todos los anaqueles"); break;

									case '2584': return cdos_mostrarConfirm("�El CD ya ha sido balanceado. �Desea realizar de nuevo la operaci�n eliminando los datos existentes?"); break;
									case '2585': return cdos_mostrarConfirm("�Desea mantener los datos ingresados manualmente?"); break;

									case 'APE-0041': return "No se ha indicado tipo de caja para embalaje"; break;
									case 'APE-0041-1': return "No posee tipo de caja para embalaje"; break;
									case 'APE-0042': return "El nivel de aplicaci�n es mayor o igual a la capacidad m�nima de la caja"; break;
									case 'APE-0043': return "La capacidad m�nima de la caja " + arg1 + " es menor o igual a la capacidad de la caja " + arg2; break;

									case 'APEUI050': return cdos_mostrarConfirm("Ha cambiado la Marca o el Canal, si acepta se eliminar�n los elementos ya ingresados"); break;
									case 'APEUI051': return cdos_mostrarAlert("Ya se ingres� esa zonificaci�n"); break;
									case 'APEUI052': return cdos_mostrarAlert("Ya existe una zonificaci�n que abarca la Secci�n"); break;
									case 'APEUI053': return cdos_mostrarAlert("Ya existe una zonificacion que abarca la Zona"); break;
									case 'APEUI054': return cdos_mostrarConfirm("Hay " + arg1 + " faltantes. �Confirma?"); break;
									case 'APEUI055': return cdos_mostrarConfirm("Hay " + arg1 + " sobrantes. �Confirma?"); break;
									case 'APEUI056': return cdos_mostrarAlert("No se encuentran datos o bien la caja ya fue chequeada"); break;
									case 'APEUI058': return cdos_mostrarAlert("No existe un Mapa de Zona por defecto"); break;
									case 'APEUI059': return cdos_mostrarAlert("No existe un Mapa de Anaquel por defecto"); break;
									case 'APEUI060': return cdos_mostrarAlert("Ya existe un Mapa de Anaquel por defecto para el pa�s, Centro de distribuci�n "+ arg1.CD 
																				+", Mapa de CD "+ arg1.MapaCD +", mapa de zona "+ arg1.MapaZona +" y mapa de anaquel "
																				+ arg1.MapaAnaquel); break;
									case 'APEUI062': return cdos_mostrarAlert("La capacidad m�nima debe ser menor que la capacidad"); break;
									case 'APEUI063': return "Las etiquetas han sido reimpresas"; break;
									case 'APEUI064': return "La etiqueta ha sido impresa"; break;

									case '2586': return cdos_mostrarAlert("El campo \"Unidades en la Caja\" es obligatorio"); break;
									case '2587': return cdos_mostrarAlert("El campo \"C�d Anaquel\" es obligatorio"); break;
									case '2588': return cdos_mostrarAlert("El campo \"C�d Producto\" es obligatorio"); break;									
									case '2589': return "Unidades en la caja"; break;
									case '2590': return cdos_mostrarAlert("No existen detalles con error"); break;		
									case '2591': return cdos_mostrarConfirm("La subl�nea se encuentra con estado Ordenado Contin�a"); break;
									case '2592': return cdos_mostrarAlert("Debe existir por lo menos una sublinea ordenada"); break;	
                                    case '2593': return cdos_mostrarAlert("No tiene anqueles asignados"); break;	
									case '2594': return cdos_mostrarAlert("La sublinea no esta ordenada"); break;	
									case '2595': return cdos_mostrarAlert("El campo Horas/dia no puede ser mayor a 24"); break;	
									case '2596': return cdos_mostrarAlert("No existen registros que cumplan los criterios de b�squeda"); break;	
									case '2597': return "Partici�n"; break;
									case '2598': return "Trasvase"; break;
									case '2599': return cdos_mostrarAlert("Ya existe el Territorio a Crear con otros valores de NSE1 y NSE2"); break;	
									case '2600': return cdos_mostrarAlert("A�n quedan consultoras sin territorio asignado"); break;	
									case '2601': return cdos_mostrarAlert("No se ha introducido datos en la lista de consultoras"); break;
									case '2602': return "Fusi�n"; break;
									case '2603': return cdos_mostrarAlert("El Territorio 1 a Fusionar no podra ser el mismo que el Territorio 2 a Fusionar"); break;	
									case '2604': return cdos_mostrarAlert("Ya existe UA a Crear con otros valores de NSE1 y NSE2"); break;  
									case '2605': return cdos_mostrarAlert("A�n quedan UA sin asignar"); break;  
									case '2606': return cdos_mostrarAlert("No se ha introducido datos en la lista de UAs"); break;  
									case '2607': return cdos_mostrarAlert("La UA 1 a Fusionar no podra ser el mismo que la UA 2 a Fusionar"); break;  
									case '2608': return cdos_mostrarAlert("El campo " + arg1 + " debe tener una longitud maxima de " + arg2 + " caracteres"); break; 
									case '2609': return "UA a Crear"; break; 
									case '2610': return cdos_mostrarAlert("La Versi�n seleccionada ya se encuentra activa para facturaci�n"); break;  
                                    case '2611': return cdos_mostrarAlert("La Versi�n seleccionada no se encuentra activa para facturaci�n"); break; 
									case '2612': return cdos_mostrarAlert("El Tipo Vinculo Recomendante/Recomendada debe ser vinculo principal"); break;  
                                    case '2613': return cdos_mostrarAlert("La Fecha desde debe ser menor o igual que la Fecha del Sistema"); break; 
									case '2614': return "OK"; break; 
                                    case '2615': return "Err�nea"; break; 

									case '2616': return cdos_mostrarAlert("El cliente tiene problemas de ESTATUS"); break;
									case '2617': return cdos_mostrarAlert("Hay cruce de campa�as"); break;
								
									case '2625': return cdos_mostrarAlert("Proceso mal parametrizado: falta el CU a Invocar"); break;
									case '2627': return "La Etiqueta " + arg1 + " ha sido actualizada satisfactoriamente"; break;
									case '2628': return cdos_mostrarAlert("Cup�n 3  ingresado correctamente"); break;
									case '2629': return cdos_mostrarAlert("Caracteres no permitido: ' , >, < , ; y Enters"); break;
									case '2630': return cdos_mostrarAlert(" " + arg1 + " "); break;

									case '2631': return cdos_mostrarAlert("Si se ha ingresado N�mero de Documento Legal Final el Flag Anulado debe estar seleccionado"); break;
									case '2632': return cdos_mostrarAlert("N�mero de Documento Legal debe ser menor o igual a N�mero de Documento Legal Final"); break;
									case '2633': return cdos_mostrarExito("Registro se grab� en forma exitosa"); break;
									case '2634': return cdos_mostrarAlert("No se pudo guardar el registro"); break;
									case '2635': return cdos_mostrarAlert("El archivo debe tener extension csv"); break;
									case '2636': return "Opcional"; break; 
									case '2637': return cdos_mostrarConfirm("Documento de referencia con chequeo conforme");
									case '2638': return cdos_mostrarAlert("Proceso Terminado"); break;
									case '2639': return cdos_mostrarConfirm("Desea grabar los reemplazos configurados");break;
									case '2640': return cdos_mostrarConfirm("�Desea reemplazar los productos pendientes en bolsa de faltantes por el producto reemplazo y generar una nueva solicitud de despacho?");break;
									case '2641': return "Obligatorio"; break; 
									case '2642': return cdos_mostrarAlert("El producto reemplazo no debe ser igual al producto reemplazado"); break;
									case '2643': return cdos_mostrarAlert("Incompatible con los par�metros Dirigido a distinto de \"Consultora\", Base c�lculo distinta \"Monto\" y  Tipo concurso distinto a \"Concurso de Ventas\"."); break;
									case '2644': return cdos_mostrarConfirm("�Desea reemplazar los productos de reemplazos pendientes en bolsa de faltantes por el producto origen y generar una nueva solicitud de despacho?");break;

                    case "000000000000001": return  'Par�metro inexistente';
                    case "000000000000002": return  'Valor no num�rico.';
                    case "000000000000003": return  'Caracteres permitidos:\n';
                    case "000000000000004": return  ' caracteres.';
                    case "000000000000005": return  'Longitud permitida: ';
                    case "000000000000006": return  'Longitud m�xima: ';
                    case "000000000000007": return  'Longitud m�nima: ';
                    case "000000000000008": return  "El n�mero de ocurrencias de '";
                    case "000000000000009": return  "' dentro de '";
                    case "000000000000010": return  "' debe estar comprendido entre ";
                    case "000000000000011": return  " y ";
                    case "000000000000012": return  'Fecha no v�lida: debe ser mayor o igual que ';
                    case "000000000000013": return  'Fecha no v�lida: debe ser menor o igual que ';
                    case "000000000000014": return  'Formato Fecha inv�lido. Caracteres permitidos:dmDMY/-';
                    case "000000000000015": return  'Formato Fecha inv�lido. S�lo se permite un tipo de separador.';
                    case "000000000000016": return  'Formato Fecha inv�lido. S�lo se permite un tipo de d�a (D � d).';
                    case "000000000000017": return  'Formato Fecha inv�lido. S�lo se permite un tipo de mes (M � m).';
                    case "000000000000018": return  'Formato Fecha inv�lido: s�lo se permite una D.';
                    case "000000000000019": return  'Formato Fecha inv�lido: s�lo se permite una d.';
                    case "000000000000020": return  'Formato Fecha inv�lido: s�lo se permite una M.';
                    case "000000000000021": return  'Formato Fecha inv�lido: s�lo se permite una m.';
                    case "000000000000022": return  'Formato Fecha inv�lido: s�lo se permite una Y.';
                    case "000000000000023": return  "Formato Fecha inv�lido: tras 'd' debe haber un separador o estar al final del formato.";
                    case "000000000000024": return  "Formato Fecha inv�lido: tras 'm' debe haber un separador o estar al final del formato.";
                    case "000000000000025": return  'Fecha inv�lida. Caracteres permitidos:0123456789';
                    case "000000000000026": return  'Fecha inv�lida: formato(';
                    case "000000000000027": return  ') incompleto.';
                    case "000000000000028": return  'Fecha inv�lida: el d�a debe tener 2 d�gitos.';
                    case "000000000000029": return  'Fecha inv�lida: el mes debe tener 2 d�gitos.';
                    case "000000000000030": return  'Fecha inv�lida: el a�o debe tener 4 d�gitos.';
                    case "000000000000031": return  'Fecha inv�lida: error de formato(';
                    case "000000000000032": return  ').';
                    case "000000000000033": return  'Fecha inv�lida: longitud incorrecta.';
                    case "000000000000034": return  'Fecha inv�lida: ';
                    case "000000000000035": return  ' <= a�o <= ';
                    case "000000000000036": return  'Fecha inv�lida: el mes debe estar comprendido entre 1 y 12.';
                    case "000000000000037": return  'Fecha inv�lida: el d�a para ese mes debe estar comprendido entre 1 y ';
                    case "000000000000038": return  'Fecha inv�lida: dicho mes s�lo tiene 30 d�as.';
                    case "000000000000039": return  'Fecha inv�lida: dicho mes de Febrero s�lo tiene ';
                    case "000000000000040": return  ' d�as.';
                    case "000000000000041": return  'Rango permitido: ';
                    case "000000000000042": return  ' <=valor<= ';
                    case "000000000000043": return  'N�mero inv�lido: campo vac�o.';
                    case "000000000000044": return  'N�mero inv�lido: caracteres permitidos:0123456789';
                    case "000000000000045": return  'N�mero inv�lido: s�lo se permite un separador decimal.';
                    case "000000000000046": return  "N�mero inv�lido: el signo - debe preceder al n�mero.";
                    case "000000000000047": return  'N�mero inv�lido: s�lo se permite un m�ximo de ';
                    case "000000000000048": return  ' d�gitos enteros y ';
                    case "000000000000049": return  ' d�gitos decimales.';
                    case "000000000000050": return  "L�mite inferior de validaci�n no se ajusta al formato enteros.decimales";
                    case "000000000000051": return  "N�mero inv�lido: el l�mite inferior es:";
                    case "000000000000052": return  "L�mite superior de validaci�n no se ajusta al formato enteros.decimales";
                    case "000000000000053": return  "N�mero inv�lido: el l�mite superior es:";
                    case "000000000000054": return  'Uso erroneo del caracter \'-\'';
                    case "000000000000055": return  'Formato m�nimo: ';
                    case "000000000000056": return  'Formato inv�lido: debe ser mayor o igual que: ';
                    case "000000000000057": return  'Formato m�ximo: ';
                    case "000000000000058": return  'Formato inv�lido: debe ser menor o igual que: ';
                    case "000000000000059": return  'No existe el formato a validar.';
                    case "000000000000060": return  "El formato a validar no puede incluir '**'";
                    case "000000000000061": return  "El formato a validar no puede incluir '*?'";
                    case "000000000000062": return  "El formato a validar no puede incluir '?*'";
                    case "000000000000063": return  "El formato a validar no incluye ']' para un '[' existente.";
                    case "000000000000064": return  'Formato inv�lido: longitud incorrecta.';
                    case "000000000000065": return  'El formato a validar no puede terminar en \\';
                    case "000000000000066": return  'Formato inv�lido: el car�cter ';
                    case "000000000000067": return  " debe ser '";
                    case "000000000000068": return  ' debe ser una letra may�scula.';
                    case "000000000000069": return  ' debe ser una letra min�scula.';
                    case "000000000000070": return  ' debe ser un d�gito.';
                    case "000000000000071": return  ' debe ser una letra.';
                    case "000000000000072": return  ' debe ser uno de los siguientes: ';
                    case "000000000000073": return  "A continuaci�n de '";
                    case "000000000000074": return  "' se esperaba lo siguiente:\n";
                    case "000000000000075": return  "N�mero inv�lido: el campo no contiene un n�mero.\n";
                    case "000000000000076": return  "La clave nueva ya ha sido utilizada en las �ltimas ";
					case "000000000000078": return cdos_mostrarAlert("La marca seleccionada se encuentra repetida."); break;

					case "000000000000100": return "El campo " + arg1 + " debe ser num�rico";
					case "000000000000101": return "El campo " + arg1 + " admite "+ arg2 +" valores decimales como m�ximo";
					case "000000000000102": return "El campo " + arg1 + " admite un �nico separador decimal";
					case "000000000000103": return "El campo " + arg1 + " solo admite valores entre "+ arg2 +" y "+ arg3;
					case "000000000000104": return  "N�mero inv�lido, debe ser un entero";
					case "000000000000105": return  "N�mero inv�lido, el separador de miles \'"+arg1+"\' debe agrupar de a tres digitos";

                    case "PRE0077": return cdos_mostrarAlert("Se debe seleccionar un/unos elemento/s"); break;
                    
                    case "PRE0079": return cdos_mostrarAlert("Existe algun producto seleccionado que ya se encuentra a�adido"); break;
                    case "PRE0080": return cdos_mostrarAlert("No puede guardar la pagina sin a�adir un producto"); break;
                    case 'PRE0023': return cdos_mostrarConfirm("No existen registros que cumplan los criterios de busqueda. �Desea realizar la b�squeda en Maestro de Materiales?"); break;
                    case "PRE0011": return cdos_mostrarAlert("No se puede modificar esta oferta al estar la matriz facturada"); break;
                    case "PRE0017": return cdos_mostrarAlert("�Esta seguro que desea eliminar la oferta?"); break;

                    case "PRE0013": return cdos_mostrarAlert("Debe seleccionar una linea"); break;
                    case "PRE0014": return cdos_mostrarAlert("No se pueden eliminar todas las lineas de la condici�n"); break;	 
                    case "PRE0016": return cdos_mostrarAlert("No se pueden eliminar todos los grupos del mismo tipo"); break;	 	
                    case "PRE0025": return cdos_mostrarAlert("Debe seleccionar un producto"); break;
                    case "PRE0043": return cdos_mostrarAlert("Debe seleccionar una matriz origen y matriz nueva"); break; 
					case "PRE0050": return cdos_mostrarAlert("Existen productos con n�meros de orden repetidos o nulos"); break; 
                    case "PRE0047": return cdos_mostrarAlert("La entrada que intenta introducir en Venta Exclusiva ya existe."); break; 

                    case "PRE1001": return cdos_mostrarAlert("Quedan grupos por ingresar."); break; 
					case "PRE1002": return cdos_mostrarAlert("Se debe evaluar ranking por demanda."); break; 
					case "PRE1003": return cdos_mostrarAlert("Se debe/n ingresar condicion/es de promocion."); break; 
					case "PRE1004": return cdos_mostrarAlert("Para evaluar el ranking deben estar los grupos completos. Presione el boton Grupos."); break; 
					case "PRE1005": return cdos_mostrarAlert("Numero/s de ranking incorrectos."); break; 
					case "PRE1006": return cdos_mostrarAlert("Es obligatorio completar Evaluar Ranking Por Demanda."); break; 

                    case "MAE0006": return cdos_mostrarAlert("El cliente ya existe y tiene cuentas castigadas. El saldo del cliente es "+ arg1); break;
                    case "MAE0007": return cdos_mostrarAlert("El cliente ya existe"); break;
                    case "MAE0010": return cdos_mostrarAlert("El cliente debe tener por lo menos una linea de clasificacion"); break;
                    case "MAE0012": return cdos_mostrarAlert("El tipo de clasificaci�n seleccionado ya se est� utilizando para otra clasificaci�n"); break;
                    case "MAE0013": return cdos_mostrarAlert("El tipo de cliente seleccionado ya se est� utilizando para otro subtipo"); break;
                    case "MAE0018": return cdos_mostrarAlert("La hora desde debe de ser menor que la hora hasta"); break;
					case "MAE0033": return cdos_mostrarAlert("El Grupo Clasificaci�n no puede contener tipos y subtipos de cliente no definidos");break;
					case 'MAE0036': return cdos_mostrarAlert("Debe definir c�digo de cliente contactado y tipo de cliente contactado en Grupo Primer Contacto");break;
                    case "CAR002": return cdos_mostrarAlert("Solo se puede seleccionar un Nivel de Riesgo en una modificaci�n"); break;

					case "PED009": return cdos_mostrarAlert("Opci�n no autorizada: debe tener informe generado"); break;                                      
					case "UIPED002": return cdos_mostrarAlert("Ha introducido movimiento de asignaci�n y movimiento de reserva de stocks"); break;                                      
					case "UIPED003": return cdos_mostrarAlert("Seleccione alguna celda de un GP, por favor"); break;
					case "UIPED004": return cdos_mostrarConfirm("�Desea grabar la secuencia del monitor especificada?"); break;
					case "UIPED005": return cdos_mostrarAlert("No se puede repetir el n�mero de secuencia dentro de un GP"); break;
					case "UIPED006": return cdos_mostrarAlert("Para el desglose por Estados debe seleccionar un GP1"); break;
					case "UIPED007": return cdos_mostrarAlert("Seleccione una celda del GP1, por favor."); break;
					case "UIPED008": return cdos_mostrarAlert("Seleccione una celda del GP2, por favor."); break;
					case "UIPED009": return cdos_mostrarAlert("Seleccione una celda del GP3, por favor."); break;
					case "UIPED010": return cdos_mostrarAlert("Seleccione una celda del GP4, por favor."); break;
					case "UIPED011": return cdos_mostrarAlert("Seleccione una celda del GP5, por favor."); break;
					case "UIPED012": return cdos_mostrarAlert("No se ha especificado el grupo de reversi�n"); break;
					case "UIPED013": return cdos_mostrarAlert("Para poder facturar debe especificar Fecha Facturaci�n"); break;
					case "UIPED017": return cdos_mostrarAlert("Solo se puede crear un grupo de reversi�n para un GP. Indique el n�mero de secuencia solo para un GP."); break;
					case "UIPED018": return cdos_mostrarAlert("Para poder ejecutar un grupo de procesos debe marcarse una secuencia en el grupo anterior."); break;
					case "UIPED022": return cdos_mostrarAlert("No pueden existir dos tipificaciones con el mismo n�mero de orden."); break;
					case "UIPED025": return cdos_mostrarAlert("Se debe indicar al menos una secuencia en un GP para generar un grupo de reversi�n."); break;
					case "UIPED026": return cdos_mostrarAlert("Debe indicar un c�digo de grupo de reversi�n."); break;
					case "UIPED027": return cdos_mostrarAlert("Para poder guardar la planilla debe definir una secuencia para el monitor."); break;
					case "UIPED029": return cdos_mostrarAlert("Cliente no v�lido"); break;
					case "UIPED030": return cdos_mostrarAlert("Debe especificar como m�nimo tres criterios de b�squeda para realizar la misma."); break;
					case "UIPED036": return cdos_mostrarAlert("La orden de transporte no tiene consulta asociada."); break;
					case "UIPED037": return cdos_mostrarAlert("Si tipo de solicitud es de consolidado, debe introducir subacceso"); break;


					case "UIEDU0005": return cdos_mostrarAlert("El Per�odo Fin Constancia debe ser mayor que el Per�odo Inicio Constancia"); break;
					case "UIEDU0003": return cdos_mostrarAlert("No puede informarse el Per�odo Inicio Constancia sin Per�odo Fin Constancia o viceversa"); break;
					case "UIEDU0006": return cdos_mostrarAlert("El Per�odo Fin Ventas debe ser mayor que el Per�odo Inicio Ventas"); break;
					case "UIEDU0004": return cdos_mostrarAlert("No puede informarse el Per�odo Inicio Ventas sin Per�odo Fin Ventas o viceversa"); break;
					
					case '1338' : return  cdos_mostrarAlert("No se pueden repetir los n�meros de orden para un Tipo de Solicitud"); break;

					case 'UIDTO0001' : return  cdos_mostrarAlert("Debe seleccionar un registro de la lista"); break;
					case 'UIDTO0002' : return  cdos_mostrarAlert("No existen m�s bases de aplicaci�n"); break;
					case 'UIDTO0003' : return  cdos_mostrarAlert("La definici�n de escalas no es correcta. Se producen solapamientos"); break;
					case 'UIDTO0004' : return  cdos_mostrarConfirm("Existen huecos entre las escalas definidas. �Desea continuar?"); break;
					case 'UIDTO0007' : return  cdos_mostrarAlert("Indicador 'afecta a facturas' y 'afecta a cuenta corriente' no pueden tener ambos el mismo valor"); break;	
					case 'UIDTO7012' : return  cdos_mostrarAlert("Descuento guardado con exito."); break;	

					case 'UICCC008' : return  cdos_mostrarAlert("Debe llenarse, al menos, un criterio de b�squeda."); break;
				    case 'UICCC0024' : return cdos_mostrarAlert("Uno o m�s de los registros seleccionados no fue eliminado pues est� siendo utilizado"); break;    
					case 'UICCC0037' : return "Ya existen movimientos para la cuenta corriente y la fecha"; break;    

					case 'UICAL0003' : return  cdos_mostrarAlert("El c�digo de cliente no existe"); break;
				    case '1461' : return "Se ha bloqueado administrativamente al cliente"; break;    
				
					case '1368' : return cdos_mostrarAlert("El mes introducido no es correcto.");break;
					case '1370' : return "Al menos hay un cliente seleccionado m�s de una vez"; break; 
					case '1371' : return "El Grupo Detalle debe contener al menos una l�nea"; break;
					case '1372' : return cdos_mostrarAlert("El codigo de Cliente para el proceso seleccionado es obligatorio."); break;
					case '1373' : return cdos_mostrarAlert("Ya existe una solicitud para el mismo cliente."); break;
					case '1374' : return "Debe seleccionar, al menos, "+arg1+" criterios de b�squeda"; break;
					case '1375' : return "�Realmente desea reabrir el per�odo introducido? "; break;
					case '1376' : return "Se han actualizado "+arg1+" registros"; break;
					case '1377' : return "El campo de entrada 'Fecha de Cierre' es obligatorio"; break;
					case '1378' : return "S�lo puede haber una agrupaci�n de stock por defecto"; break;
					case '1388' :  return  cdos_mostrarAlert("Debe llenarse, al menos, un criterio de b�squeda."); break;

                    case 'GEN-0206': return cdos_mostrarAlert("Operaci�n realizada con �xito."); break;
					case 'UIREP001' : return "La Fecha debe estar entre, "+arg1+" y "+arg2+" "; break;
                    case '1389' : return cdos_mostrarAlert("Debe introducir al menos "+arg1+" criterios de b�squeda"); break;

					case 'PED-0001': return  cdos_mostrarAlert('El campo P�gina cat�logo desde debe ser menor � igual al campo P�gina cat�logo hasta');break; 	                    
					case 'PED-0002': return  cdos_mostrarAlert('Debe seleccionar al menos un c�digo de venta');break; 	                    
					case '1396': return cdos_mostrarAlert('Debe seleccionar una ruta');break;
					case '1397': return cdos_mostrarAlert('Espanolllllll:   No existen registros que cumplan con los criterios de b�squeda.');break;
					case 'MSG001': return cdos_mostrarAlert('La opci�n Generaci�n de Pedidos es excluyente y no se puede combinar con el resto');break;   
					case 'MSG002': return cdos_mostrarAlert('La opci�n Lista de Consultoras es excluyente y no se puede combinar con el resto');break;   
					case 'MSG007': return cdos_mostrarAlert('Si el tipo de mensaje es G1, el destinatario debe ser lista de consultoras o generaci�n de pedidos.');break;   
   				    case 'MSG008': return cdos_mostrarAlert('Si el tipo de mensaje es G2, el destinatario no puede ser lista de consultoras ni generaci�n de pedidos.');break;   
					case 'MSG009': return cdos_mostrarAlert('Debe seleccionar el tipo de per�odo, el per�odo desde y el per�odo hasta.');break;   
					case 'MSG010': return cdos_mostrarAlert('El per�odo desde debe ser menor o igual que el per�odo hasta.');break;   
					case 'MSG011': return cdos_mostrarAlert('La fecha de permanencia desde debe ser menor o igual que la fecha de permanencia hasta.');break;   
					case 'MSG012': return cdos_mostrarAlert('Si el tipo de permanencia es Rango de fechas debe introducir fecha de permanencia desde y hasta');break;
					case 'MSG013': return cdos_mostrarAlert('No se encuentra el c�digo de cliente en maestro de clientes');break;
					case 'MSG014': return cdos_mostrarAlert('Debe definirse un per�odo para el patr�n.');break;				
					case 'MSG015': return cdos_mostrarAlert('Los datos de mensaje fueron grabados');break;
					case 'UICAR004': return cdos_mostrarAlert("Monto de la orden Desde es mayor o igual que el campo Monto de la orden hasta");break;
		  			case 'UICAR005': return cdos_mostrarAlert("Monto de la deuda Vencida Desde es mayor o igual que el campo Monto de la deuda Vencida hasta");break;
					case 'UICAR006': return cdos_mostrarAlert("No tiene nivel jer�rquico suficiente para liberar esta solicitud");break;
					case 'UIBEL005': return cdos_mostrarAlert('Subacceso (origen) y Subacceso(destino) no pueden ser iguales.');break;
					case 'UIBEL006': return cdos_mostrarConfirm("Belcenter destino ya est� parametrizado, confirme que desea ejecutar la copia.");break;
            		case '1409': return "Error en rangos de b�squeda"; break;
			case '1417': return "El valor de territorio desde y territorio hasta debe ser un n�mero entero."; break;
			case '1418': return "El registro est� cerrado. Para poder modificarlo debe abrirlo antes."; break;
			case '1434': return cdos_mostrarAlert("La fecha de vencimiento debe ser mayor o igual que la fecha valor.");break;
			case '1436': return cdos_mostrarAlert("Para identificar un movimiento en cuenta corriente debe completar los siguientes campos: acceso, subacceso, ejercicio cuota, n�mero identificador cuota y n�mero orden cuota."); break;
			case 'UIPED028': return cdos_mostrarAlert("No puede activar el indicador anulaciones y devoluciones simult�neamente, active s�lo uno."); break;
			case 'DTO-0020': return "No se puede eliminar una matriz de descuentos en uso.";break;
			case '1438': return cdos_mostrarAlert("Debe introducir al menos dos criterios de selecci�n.");break;
			case 'UIFAC0009': return cdos_mostrarAlert("Cierre de Zonas: s�lo puede seleccionarse una regi�n");break;
			case 'UIFAC0005': return "Fecha Facturaci�n Desde debe ser menor o igual que Fecha Facturaci�n Hasta";break;
			case 'UIFAC0007': return "N�mero Consolidado Desde debe ser menor o igual que N�mero Consolidado Hasta";break;
			case 'UIFAC0008': return "Operaci�n realizada correctamente";break;
			case 'UIFAC0011': return "Debe introducir al menos un criterio de selecci�n: Rango N�mero Consolidado Desde, Rango N�mero Consolidado Hasta � Fecha Facturaci�n Desde, Fecha Facturaci�n Hasta";break;
			case 'UIFAC0012': return "Regi�n (� zona � secci�n � territorio) desde debe ser menor o igual que hasta";break;
			case 'UIFAC0013': return cdos_mostrarAlert("Si el tipo de actividad es con actividad origen ser� OBLIGATORIO seleccionar actividad origen"); break;
			case '1443': return "Debe introducir al menos un criterio de selecci�n: Ejercicio, Rango Desde Documento Interno, Rango Hasta Documento Interno O Serie Documento Legal, Rango Desde Documento Legal, Rango Hasta Documento Legal O Canal/Acceso/Subacceso, N�mero Consolidado Desde, N�mero Consolidado Hasta"; break;
			case '1444': return "Rango desde documento interno debe ser menor o igual que rango hasta"; break;
			case '1445': return "Rango desde documento legal debe ser menor o igual que rango hasta"; break;
			case '1446': return "Fecha facturaci�n desde debe ser menor o igual que fecha  hasta"; break;
			case '1447': return "Fecha proceso desde debe ser menor o igual que fecha hasta"; break;
			case '1448': return "N�mero consolidado desde debe ser menor o igual que n�mero hasta"; break;
			case '1449': return "Operaci�n realizada correctamente"; break;
			case '1453': return "El campo 'Tipo Doc. Contable' es obligatorio"; break;
	    	case '1454': return cdos_mostrarAlert("El cliente no tiene asociado medio de comunicaci�n, no se puede generar la notificaci�n"); break;
			case '1462': return cdos_mostrarAlert("Fecha OC Menor que fecha �ltima ejecuci�n"); break;
			case '1450': return cdos_mostrarAlert("Fecha OC mayor que Fecha del Sistema"); break;
			case '3333': return cdos_mostrarAlert("No se pueden guardar premios consuelo sin elegir clientes o concursos"); break;
			case '3334': return cdos_mostrarAlert("Debe existir al menos un cliente v�lido"); break;


			case 'UIFAC0010': return cdos_mostrarAlert("Debe completar datos");break;
			
			case 'UIBEL0010': return cdos_mostrarAlert("Se corregir�n Unidades de Reposici�n al ser mayor que Stock M�ximo");break;
			case 'UIBEL0011': return cdos_mostrarAlert("Ya existe c�digo de producto, modifique las unidades de reposici�n");break;
			case 'UIBEL0012': return cdos_mostrarAlert("El signo de los campos Importe/Importe Divisa no coincide con el tipo de movimientos de caja");break;
			case '1457': return "La Fecha Hasta no puede ser anterior a la Fecha Desde"; break;
			case '1458': return "Opci�n no disponible en esta versi�n "; break;
			case '1460': return cdos_mostrarAlert("Las Unidades Atendidas deben ser un n�mero entero mayor que cero");break;
			case 'REC001': return cdos_mostrarAlert("La operaci�n debe tener al menos un tipo de operaci�n asociado");break;
			case 'REC002': return cdos_mostrarAlert("No se puede indicar perdida sin tipo de solicitud para perdida");break;
			case 'REC003': return cdos_mostrarAlert("No se puede seleccionar un tipo de solicitud para perdida sin indicar perdida");break;
			case 'REC004': return cdos_mostrarAlert("Debe seleccionarse un almac�n y un tipo de movimiento");break;
			case 'REC005': return cdos_mostrarAlert("Debe existir al menos una operaci�n de reclamo");break;
			case 'REC009': return cdos_mostrarAlert("Debe rellenar al menos un criterio de b�squeda");break;
			case 'REC010': return cdos_mostrarAlert("Debe seleccionar un motivo de bloqueo");break;
			case 'REC012': return cdos_mostrarAlert("El bloqueo esta desactivo y se ha especificado un motivo de Bloqueo");break;
			//case 'REC013': return cdos_mostrarAlert("El bloqueo esta activo y no se ha especificado un motivo de Bloqueo");break;
			case 'REC013': return cdos_mostrarAlert("Se debe a�adir a la lista al menos un registro");break;

			case 'REC014': return cdos_mostrarAlert("Debe a�adir al menos una operac�on al reclamo");break;
			case 'REC015': return cdos_mostrarAlert("El numero de unidades a devolver es incorrecto para numero del reclamo:" + arg1 + " numero de operacion:" + arg2 + " numero de Linea:" + arg3);break;
			case 'REC016': return cdos_mostrarAlert("El registro est� repetido: n� operaci�n " + arg1 + ", n� l�nea " + arg2);break;
			case 'REC017': return cdos_mostrarAlert("Debe haber a�adido al menos un elemento de la lista superior.");break;
			
			case 'REC025': return cdos_mostrarAlert("No puede reclamar un n�mero de unidades mayor al de la factura.");break;
			case 'REC026': return cdos_mostrarAlert("El campo 'Unidades reclamadas' es obligatorio.");break;

			case '1465': return cdos_mostrarAlert("El separador de miles no se encuentra en una posici�n correcta.");break;
			case '1470': return cdos_mostrarAlert("Debe a�adir al menos un detalle a la hoja de demanda.");break;
			case '1471': return cdos_mostrarAlert("El campo Total a pagar hasta debe ser mayor al campo Total a pagar desde.");break;
			case '1472': return cdos_mostrarConfirm("�Realmente desea cerrar el per�odo introducido?");break;
			case 'UIINT-001': return cdos_mostrarAlert("La Fecha Hasta no puede ser anterior a la Fecha Desde");break;
			case 'UIINT-002': return cdos_mostrarAlert("Se debe seleccionar al menos un interfaz");break;
			case 'UIINT-003': return cdos_mostrarConfirm("La Fecha Desde es diferente a d�a 21");break;
			case 'UIINT-004': return cdos_mostrarConfirm("La Fecha Desde ha sido modificada");break;
			case 'UIINT-005': return cdos_mostrarConfirm("La Fecha Hasta es diferente a d�a 20");break;
			case 'UIINT-006': return cdos_mostrarAlert("Existen lotes en estado pendiente de confirmar");break;
			case 'UIINT-007': return cdos_mostrarAlert("Se debe seleccionar un tipo cliente y un subtipo cliente");break;			
			case 'UIINT-008': return cdos_mostrarAlert("Se ha producido un error al generar el fichero");break;	
			case 'UIINT-009': return cdos_mostrarAlert("Al menos un campo de importe ADAM debe ser diferente de 0"); break;		
			case '150001': return cdos_mostrarAlert("El c�digo de producto introducido no existe");break;
			case '150002': return cdos_mostrarAlert("El usuario no esta autorizado a realizar la operaci�n");break;
			case '150003': return cdos_mostrarAlert("El importe de la operaci�n supera el importe autorizado para el usuario");break;
			case '150004': return cdos_mostrarAlert("La diferencia de importes supera la autorizada para el usuario");break;
			case 'REC007': return cdos_mostrarAlert("Deben guardarse los datos antes de generar un reclamo");break;
			case 'REC011': return cdos_mostrarAlert("No tiene autorizaci�n para eliminar alguno de los tipos de operaci�n seleccionados");break;
			case 'UIREC015': return cdos_mostrarAlert("No de pueden seleccionar productos debido a la configuraci�n del tipo de operaci�n");break;
			case 'UIREC010': return cdos_mostrarAlert("Se intenta almacenar informaci�n ya contenida. Debe eliminar registro afectado antes de seguir");break;
			case 'REC050': return cdos_mostrarAlert("La operaci�n no tiene l�neas de operaci�n asociadas");break;
			case 'UICCC021': return cdos_mostrarAlert("No se puede eliminar un registro cerrado. Si desea realizar la operaci�n, deber� reabrir el periodo");break;
			case 'REC-012': return cdos_mostrarConfirm("El chequeo no fue correcto �Desea introducir el reclamo?");break;
			default: return  'No esta definido el mensaje para: ' + codigo; 

			case 'UICOB0005': return cdos_mostrarAlert("Debe seleccionar al menos un criterio: marca, canal y per�odo o cliente");break;	
			case 'UICOB0001': return cdos_mostrarAlert("La fecha introducida no es correcta");break;			  
			
			case 'UICOM0001': return cdos_mostrarAlert("No se puede aceptar una modificaci�n cuyo periodo de entrada en vigor es anterior al periodo actual");break;
			case 'UICOM0004': return cdos_mostrarAlert("No se pueden modificar plantillas cuyo estado es Eliminado");break;
			case 'UICOM0005': return cdos_mostrarAlert("La comisi�n no puede ser incremental de tipo venta hist�rica, porque no existe el periodo del a�o anterior");break;                                             
			case 'UICOM0007': return cdos_mostrarAlert("No se pueden mostrar los detalles las plantillas eliminadas");break;
			case 'UICOM0008': return cdos_mostrarAlert("N�mero de d�as para comisi�n no puede ser igual para dos niveles de tramo");break;
			case 'UICOM0009': return cdos_mostrarAlert("Debe existir al menos un registro en la lista Datos de Niveles");break;	
			case 'UICOM0010': return cdos_mostrarAlert("Los datos necesarios de la comisi�n no est�n completos");break;
			case 'UICOM0011': return cdos_mostrarAlert("La Fecha Hasta debe ser mayor o igual a la Fecha Desde");break;
			case 'UICOM0012': return cdos_mostrarAlert("No se pueden eliminar plantillas cuyo estado es Eliminado");break;
			case 'UICOM0055': return cdos_mostrarAlert("No se pueden mostrar los detalles las plantillas eliminadas");break;
	        case 'UICOB0006': return cdos_mostrarAlert("Debe seleccionar el campo Usuario cobranza � el campo Grupo usuario como criterio para la b�squeda");break;	
            case 'UICOB0007': return cdos_mostrarConfirm("�Desea Anular La Gestion?"); break;
			case 'REC008': return "El tipo de operaci�n permite la selecci�n de otra campa�a, �desea cambiarla?";break;  
			case 'REC0003': return cdos_mostrarAlert("No puede reclamar un n�mero de unidades mayor al de la factura");break;

			case 'ZON001': return "Responsable no cumple campa�as para reingreso, �desea continuar?";break;

			case "INC-0015": return cdos_mostrarAlert("Debe definir los Niveles de premiaci�n antes de definir las caracter�sticas de Programa Nuevas"); break;
			case "INC016": return cdos_mostrarAlert("Debe seleccionar al menos un valor en el campo Marca para introducir un elemento en la Lista de Productos Exigidos"); break;
			case "INC012": return cdos_mostrarAlert("Superado saldo en puntos"); break;
			case "INC030": return cdos_mostrarAlert("Para poder Calcular metas debe ingresar al menos los datos obligatorios en Definir Venta Proyectada de la pesta�a Calificaci�n"); break;
			case "INC031": return cdos_mostrarAlert("Para poder Mantener metas debe ingresar al menos los datos obligatorios en Definir Venta Proyectada de la pesta�a Calificaci�n"); break;
     	    case "INC023": return cdos_mostrarAlert("Debe seleccionar un Nivel para recuperar la informacion de Ganadoras"); break;
			//Cleal 20647
			case "INC033": return cdos_mostrarConfirm("Al seleccionar el valor 'Sin Premio' en el campo Tipo Cambio, se perder�n los elementos a�adidos a la lista Productos Sustitutivos"); break;
			case "INC034": return cdos_mostrarAlert("Al definir un concurso debe a�adirse al menos un elemento de la lista Clasificaci�n participantes"); break;
			case "INC035": return cdos_mostrarAlert("Al definir un concurso de ranking debe a�adirse al menos un elemento de la lista Clasificaci�n participantes"); break;
			case "INC036": return cdos_mostrarAlert("Para poder Calcular Metas debe ingresar al menos un elemento en la lista \'Incrementos por rango\' "); break;

			case "INC041": return cdos_mostrarAlert("Para poder Mantener Metas debe ingresar datos en Definir Metas Proyectada de la pesta�a Calificaci�n"); break;

			case 'INC042': return cdos_mostrarAlert("El valor del campo Puntos debe ser mayor que cero"); break; 
            case 'INC043': return cdos_mostrarAlert("El valor del campo Puntos debe ser menor que cero"); break; 
            case 'INC044': return cdos_mostrarAlert("El valor del campo Puntos Exigidos debe ser mayor que cero"); break; 
            case 'INC045': return cdos_mostrarAlert("El valor del campo Puntos Exigidos debe ser menor que cero"); break; 


			case 'UIINC0001': return cdos_mostrarAlert("Debe haber al menos un elemento en el lista");break;

			//Cortaberr�a Incidencia BELC300014838
			case 'UIPED031': return cdos_mostrarAlert("No se pueden eliminar tipos de solicitud asociadas a un Grupo de Solicitudes.");break;
			
			case 'UIPED032': return cdos_mostrarAlert("No se ha encontrado ninguna solicitud digitada para este Cliente.");break;

			// BELC300019645
			case 'REC018': return cdos_mostrarAlert("Los datos introducidos no son correctos.");break;
			
			case 'UICCC0015' : return cdos_mostrarAlert("S�lo se pueden pasar a procesados los reclamos en estado solicitado"); break;
		    case 'INC0039': return cdos_mostrarAlert("El nro. de clientes que no han sido procesado es: " + arg1); break;
			case "INC-006": return cdos_mostrarAlert("Si la base de c�lculo es \'\'Recomendadas\'\' debe existir al menos un monto de venta"); break;
			case "INC-0011": return cdos_mostrarAlert("Si la forma de c�lculo es \'\'Variables de venta\'\' debe existir al menos una variable de venta"); break;
			// INC 21375
			case "INC-0052": return cdos_mostrarAlert("No se pueden guardar todos los datos del concurso debido a que faltan datos obligatorios, se han guardado los par�metros generales."); break;

		   case '50012': return cdos_mostrarAlert("Fichero Generado Correctamente");break;

		   // Agregado por ssantana, 28/11/2005, SICC-GCC-ZON-003
		   case 'UIZON005': return cdos_mostrarAlert("Debe seleccionar exactamente un elemento de la lista de resultados para ver el Detalle"); break; 
    	   case 'UIZON006': return cdos_mostrarAlert("Esta UA no tiene responsable asignado"); break;
			// Fin agregado por ssantana, 28/11/2005, SICC-GCC-ZON-003

			// Agregado por ssantana, 06/12/2005, SICC-GCC-EDU-009
		    case 'UIEDU0007': return cdos_mostrarAlert("Algunos clientes no han sido actualizados por no pasar las validaciones"); break; 
			case 'UIEDU0008': return cdos_mostrarAlert("Seleccione al menos un registro a eliminar"); break; 
			// Fin Agregado por ssantana, 06/12/2005, SICC-GCC-EDU-009			
		
			case 'INC037': return cdos_mostrarAlert("Debe seleccionar un registro para ver su detalle");break;

		    // Agregado por pzerbino, 14/12/2005, INCIDENCIA BELC300021739
			case 'UIBEL0013': return cdos_mostrarAlert("Ya existe c�digo de producto, introduzca otro c�digo"); break; 
		    // Fin Agregado por pzerbino, 14/12/2005, INCIDENCIA BELC300021739

			// Agregado por jsilva, 14/12/2005, INCIDENCIA BELC300022117
			case '1645': return cdos_mostrarAlert("Cliente y Periodo son mutuamente excluyentes"); break;
			// Fin Agregado por jsilva, 14/12/2005, INCIDENCIA BELC300022117
			//Cleal - 21495
			case 'M00047': return cdos_mostrarAlert("Ejecuci�n en proceso, puede continuar trabajando"); break; 
			case 'INC-0038': return cdos_mostrarAlert("Debe calcular las metas de Region para poder modificarlas"); break;
			case 'INC-0039': return cdos_mostrarAlert("Debe calcular las metas de Subgerencia para poder modificarlas"); break;
			case 'INC-0040': return cdos_mostrarAlert("Debe calcular las metas de Zona para poder modificarlas"); break;
			//22399
			case 'INC-0041': return cdos_mostrarAlert("Debe calcular las metas de Region para poder consultarlas"); break;
			case 'INC-0042': return cdos_mostrarAlert("Debe calcular las metas de Subgerencia para poder consultarlas"); break;
			case 'INC-0043': return cdos_mostrarAlert("Debe calcular las metas de Zona para poder consultarlas"); break;	

			case 'INC046': return cdos_mostrarAlert("El cliente ingresado no es participante del concurso seleccionado"); break;	

			//Agregado por cvalenzu - DBLG500000423
			case 'INC047': return cdos_mostrarAlert("No se puede insertar el registro. Existen rangos solapados."); break;
			case 'INC048': return cdos_mostrarAlert("El valor Desde debe ser menor al valor Hasta"); break;
			//FIN - Agregado por cvalenzu - DBLG500000423
			case 'INC049': return cdos_mostrarConfirm("Se ha modificado la selecci�n del concurso. Se perderan los cambios �Desea continuar?");
			case 'INC050': return cdos_mostrarConfirm("Se han modificado los datos del cliente �Desea guardar los cambios?");
			case 'INC051': return cdos_mostrarAlert("Se ha seleccionado un premio no disponible"); break;
			
			case 'INC052': return cdos_mostrarAlert("El concurso seleccionado no puede ser modificado"); break;
			case 'INC053': return cdos_mostrarAlert("El per�odo desde " + arg1 + " no es posterior al per�odo actual"); break;
			case 'INC054': return cdos_mostrarAlert("El per�odo hasta " + arg1 + " no es posterior al per�odo desde"); break;
			case 'INC055': return cdos_mostrarAlert("El per�odo hasta " + arg1 + " no es posterior al per�odo de puesta en marcha"); break;

			case 'INC056': return cdos_mostrarAlert("No se puede solicitar la puesta en marcha de un concurso que no tiene especificado el periodo de puesta en marcha"); break;
			case 'INC058': return cdos_mostrarAlert("Para calcular metas deben definirse Estatus de Venta para Calificaci�n"); break;
			case 'INC059': return cdos_mostrarAlert("Para calcular metas deben definirse participantes calificaci�n"); break;
			case 'INC060': return cdos_mostrarAlert("Al generar una nueva versi�n debe seleccionarse el per�odo de puesta en marcha del concurso"); break;
			case 'INC061': return cdos_mostrarAlert("Debe ingresar al menos un Premio consuelo"); break;

			// Cambio RI 20080621 - dmorello, 25/09/2008
			case 'INC062': return cdos_mostrarAlert("El Per�odo a Activar es obligatorio"); break;
			case 'INC063': return cdos_mostrarAlert("El Per�odo a Cerrar es obligatorio"); break;
			case 'INC064': return cdos_mostrarConfirm("�Est� seguro de correr ese proceso en otra campa�a distinta a la actual?");


			//DBLG300000597
			case 'BEL-ACT': return "Activo"; break;
			case 'BEL-INA': return "Inactivo"; break;
			
			//BELC300022504
			case "UIPED042": return cdos_mostrarAlert("No se puede modificar este valor."); break;
			case 'MAE0002': return cdos_mostrarAlert("El numero de documento "+arg1 +" ya existe"); break;
			case 'MAE0002BIS': return cdos_mostrarAlert("El cliente ya existe"); break;

			//Caso de Uso Insertar Codigos Clientes Anteriores pzerbino 13/02/2006
			case 'MAE0024': return cdos_mostrarAlert("El c�digo de cliente introducido no es v�lido."); break;
			case 'MAE0037': return cdos_mostrarAlert("El c�digo de cliente nuevo que quiere insertar ya existe."); break;

			case 'REC027': return cdos_mostrarAlert("No se puede ingresar una Operaci�n de anulaci�n al existir operaciones definidas en el Reclamo"); break;
			case 'REC029': return cdos_mostrarAlert("Los datos de p�rdida no se han completado correctamente, la Operaci�n no se puede guardar"); break;
			case 'REC030': return cdos_mostrarAlert("No se ha especificado un motivo de Bloqueo"); break;
			case 'REC031': return "Antig�edad mayor a la prevista, �Desea Continuar?"; break;
			case 'REC028': return cdos_mostrarAlert("No se puede ingresar otra Operaci�n al existir definida una de Anulaci�n"); break;
  			case 'UIMAE0003': return "S�lo una de las direcciones puede ser la principal. �Desea que la nueva direcci�n pase a ser la principal?"; break;

			case 'MAV100': return cdos_mostrarAlert("Debe introducir un valor en Promedio o Unidades"); break;
			case 'MAV101': return cdos_mostrarAlert("Promedio y Unidades son mutuamente excluyentes"); break;


			case 'MAV-003': return cdos_mostrarAlert("No se genera ning�n pago intercompa��a para la actividad seleccionada"); break;

			// splatas - 18/05/2006
			case '3335': return cdos_mostrarAlert("El porcentaje debe ser menor o igual a 100"); break;
			case '3336': return cdos_mostrarAlert("Debe ingresar 'Porcentaje hasta' o 'Importe hasta'"); break;

			// SPLATAS - 06/06/2006
			case '3337': return cdos_mostrarAlert("Nuevo orden guardado"); break;
                        case '3338': return cdos_mostrarAlert("El campo Texto Apunte es obligatorio"); break;

			/* ssantana, 08/08/2006, DBLG500001192 */ 
			case 'UIGEN0006': return cdos_mostrarAlert('Debe introducir al menos un elemento de b�squeda'); break;
			case 'PED_051': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": la solicitud no ha sido registrada"); break;
			case 'PED_052': return cdos_mostrarAlert("La solicitud no ha sido registrada"); break;
			case 'PED_053': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": la solicitud no ha sido digitada aun"); break;
			case 'PED_054': return cdos_mostrarAlert("La solicitud no ha sido digitada aun"); break;
			case 'PED_056': return cdos_mostrarAlert("No existe el C�digo de Cliente"); break;
			case 'PED_057': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": no existe el C�digo de Receptor"); break;
			case 'PED_058': return cdos_mostrarAlert("No existe el C�digo de Receptor"); break;
			case 'PED_059': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": no existe el C�digo de Pagador"); break;
			case 'PED_060': return cdos_mostrarAlert("No existe el C�digo de Pagador"); break;
			case 'PED_061': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": no existe el C�digo de Consultora asociada"); break;
			case 'PED_062': return cdos_mostrarAlert("No existe el C�digo de Consultora asociada"); break;
			case 'PED_063': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": Cliente bloqueado"); break;
			case 'PED_064': return cdos_mostrarAlert("Cliente bloqueado"); break;
			case 'PED_065': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": no existe Unidad Administrativa activa del Cliente"); break;
			case 'PED_066': return cdos_mostrarAlert("No existe Unidad Administrativa activa del Cliente"); break;
			case 'PED_067': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": Moneda documento no es moneda de matriz de precios"); break;
			case 'PED_068': return cdos_mostrarAlert("Moneda documento no es moneda de matriz de precios"); break;
			case 'PED_069': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": zona del cliente no est� activa"); break;
			case 'PED_070': return cdos_mostrarAlert("Zona del cliente no est� activa"); break;
			case 'PED_071': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": no existe periodo definido para la fecha de la solicitud"); break;
			case 'PED_072': return cdos_mostrarAlert("No existe periodo definido para la fecha de la solicitud"); break;
			case 'PED_073': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": no est� definida la fecha prevista de facturaci�n del periodo para la zona del cliente"); break;
			case 'PED_074': return cdos_mostrarAlert("No est� definida la fecha prevista de facturaci�n del periodo para la zona del cliente"); break;
			case 'PED_075': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": no est� definida la forma de pago"); break;
			case 'PED_076': return cdos_mostrarAlert("No est� definida la forma de pago"); break;
			case 'PED_077': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": Almacen no parametrizado"); break;
			case 'PED_078': return cdos_mostrarAlert("Almacen no parametrizado"); break;
			case 'PED_079': return cdos_mostrarAlert("Generar posici�n: solicitud: " + arg1 + ": C�digo de venta no existe o no digitable"); break;
			case 'PED_080': return cdos_mostrarAlert("Generar posici�n: solicitud: " + arg1 + ": El n�mero m�ximo de unidades que se pueden solicitar es:"); break;
			case 'PED_081': return cdos_mostrarAlert("Generar posici�n: solicitud: " + arg1 + ": Las unidades demandadas son incorrectas"); break;
			case 'PED_082': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": no existe el C�digo de Cliente"); break;
			// vbongiov -- 30/10/2006 -- DBLG500001029
			case 'PED_083': return cdos_mostrarAlert("Validaciones generales: solicitud: " + arg1 + ": Cliente no Valido"); break;
			case 'PED_084': return cdos_mostrarAlert("Cliente no Valido"); break;
            // SiCC 20070284 - RRomero - 08/06/2007
			case 'PED_085': return cdos_mostrarAlert("Debe utilizar un �nico criterio de b�squeda: C�digo SAP � C�digo de Cat�logo."); break;

			// DBLG700000069 - gPineda - 26/10/2006 
			case '3339': return cdos_mostrarAlert("El c�digo de cliente Desde debe ser menor que el c�digo de cliente Hasta."); break;

			// DBLG700000226 - SPLATAS - 23/11/2006
			case '3340': return cdos_mostrarAlert("Longitud m�xima de 'Observaciones': 100 caracteres"); break;
			case '3341': return cdos_mostrarAlert("No existen documentos internos para los criterios de seleccion"); break;
        	case '3342': return cdos_mostrarAlert("Existen menos documentos internos que los ingresados en el rango"); break;
			case '3343': return cdos_mostrarAlert(campo_obligatorio+" el Ejercicio."); break; 
			case '3344': return cdos_mostrarAlert(campo_obligatorio+" el Rango Desde Doc. Interno."); break; 
			case '3345': return cdos_mostrarAlert(campo_obligatorio+" el Rango Hasta Doc. Interno."); break; 
			case '3346': return cdos_mostrarAlert(campo_obligatorio+" la Serie del Doc. Legal."); break; 
			case '3347': return cdos_mostrarAlert(campo_obligatorio+" el Rango Desde Doc. Legal."); break; 

			//V-CCC-031 - cvalenzu - 19/12/2006
			case '3348': return cdos_mostrarAlert("No se puede seleccionar el estado Solicitado"); break; 

			//	Agregado por HRCS - Fecha 10/04/2007 - Incidencia Sicc20070184
			case 'MAE0038': return cdos_mostrarAlert("Cliente no es valido porque ya tiene un tipo de vinculo 'Dupla Cyzone' o es de tipo 'Hija Dupla'"); break;

			//	Agregado por HRCS - Fecha 18/04/2007 - Cambio Sicc20070215
			case 'INT0001': return cdos_mostrarAlert("No se ha seleccionado ninguna interface DAT a enviar");
			case 'INT0002': return cdos_mostrarConfirm("Los siguientes interfaces No se enviar�n: "+ arg1 +". �Desea continuar?");

			//	Agregado por Sapaza - Fecha 18/05/2007 - Cambio Sicc20070266
			case 'REPCRA001': return cdos_mostrarAlert("Debe Seleccionar m�ximo 3 periodos");

			//	Agregado por HRCS - Fecha 30/05/2007 - Cambio Sicc20070258
			case 'FAC0001': return cdos_mostrarConfirm("Advertencia: existe ya ("+ arg1 +") asignaci�n(es) para el rango de documentos especificados. �Desea continuar?");
            // ---------- APE -----------
            case 'APE001': return cdos_mostrarAlert("El Tipo Caja Producto " + arg1 + " ya se encuentra asignado para la subl�nea " + arg2); break;
            case 'APE002': return cdos_mostrarAlert("No se ha Introducido ninguna zona"); break;
			case 'APE003': return cdos_mostrarAlert("No se puede repetir el identificador de zona dentro de una subl�nea de armado"); break;
	        case 'APE006': return cdos_mostrarAlert("No se ha asociado un n�mero de orden a todos los anaqueles. Anaqueles sin orden: " + arg1); break;
	        case 'APE007': return cdos_mostrarAlert("Hay c�digos de anaquel repetidos: " + arg1); break;
            case 'APE009': return cdos_mostrarAlert("Lista de estimados cargada para la campa�a seleccionada"); break;
			case 'APE010': return cdos_mostrarConfirm("Ya se ha generado previamente la lista de estimados de la campa�a. �Desea reescribirla?");  break;
			case 'APE011': return cdos_mostrarConfirm("�Desea conservar los datos introducidos manualmente?");  break;
			case 'APE012': return cdos_mostrarAlert("El c�digo de Versi�n ha de ser �nico para el periodo"); break;
			case 'APE013': return cdos_mostrarAlert("El porcentaje total de distribuci�n entre subl�neas ha de ser del 100%"); break;
			case 'APE014': return cdos_mostrarAlert("Se ha realizado correctamente el mapa de centro de distribuci�n " + arg1 + " con n�mero " + arg2); break;
            case 'APE015': return cdos_mostrarAlert("Operaci�n realizada con �xito"); break;
			case 'APE015bis': return cdos_mostrarAlert("Se ha creado la copia solicitada"); break;
			case 'APE016': return cdos_mostrarConfirm("Hay productos asignados a los anaqueles manipulados. Se mover�n todos al anaquel destino. �Desea continuar?");  break;
            case 'APE017': return cdos_mostrarAlert("2 anaqueles Origen deben ser ingresados como m�nimo"); break;
			case 'APE018': return cdos_mostrarAlert("El c�digo del anaquel destino debe ser uno de los anaquel origen"); break;
			case 'APE019': return cdos_mostrarAlert("Los anaqueles ingresados no pertenecen a la misma subl�nea"); break;
			case 'APE020': return cdos_mostrarAlert("Los anaqueles no pertencen al mapa seleccionado"); break;
			case 'APE021': return cdos_mostrarConfirm("El CD ya ha sido Balanceado. �Desea realizar de nuevo la operaci�n eliminando los datos existentes?");  break;
			case 'APE022': return cdos_mostrarConfirm("�Desea mantener los datos ingresados manualmente?");  break;
			case 'APE023': return cdos_mostrarAlert("Se debe seleccionar al menos un valor para Lineas de Armado"); break;
			case 'APE024': return cdos_mostrarConfirm("�Confirma eliminar los formatos etiqueta seleccionados?");  break;
			case 'APE025': return cdos_mostrarAlert("Se han eliminado las entradas seleccionadas"); break;
			case 'APE026': return cdos_mostrarAlert("Se han anulado las etiquetas correspondientes a los consolidados seleccionados"); break;
			case 'APE027': return cdos_mostrarAlert("Debe seleccionar al menos un criterio de b�squeda"); break;
			case 'APE028': return cdos_mostrarAlert("Ya se ha ingresado el anaquel " + arg1 + " en otra l�nea"); break;
			case 'APE029': return cdos_mostrarAlert("La etiqueta ya ha sido impresa. S�lo se puede reimprimir mediante la opci�n correspondiente"); break;
			case 'APE030': return cdos_mostrarAlert("No se encontraron anaqueles sin expandir para el mapa, l�nea y subl�nea seleccionado"); break;
			case 'APE031': return cdos_mostrarAlert("El n�mero de anaquel no puede ser seleccionado m�s de una vez"); break;
			case 'APE032': return cdos_mostrarAlert("No se ha asociado un n�mero de orden a todos los anaqueles"); break;

			case 'APE033': return cdos_mostrarAlert("El campo bahias por sublinea solo admite valores entre "+ arg1 +" y "+ arg2);break;
			case 'APE034': return cdos_mostrarAlert("El campo niveles solo admite valores entre "+ arg1 +" y "+ arg2);break;
			case 'APE035': return cdos_mostrarAlert("El campo columnas por bahia solo admite valores entre "+ arg1 +" y "+ arg2);break;

			case 'APE36': return cdos_mostrarAlert("No se puede repetir el tipo de caja."); break;

			case 'APE036': return cdos_mostrarAlert("Ya existe un Orden de Anaquel por defecto para los Centro de Distribuci�n, Mapa de CD y Mapa de Zonas seleccionados."); break;
			case 'APE037': return cdos_mostrarAlert("Ya se han enviado las etiquetas a la impresora"); break;
			case 'APE038': return cdos_mostrarExito("Se ha realizado la copia con el nuevo n�mero de versi�n " + arg1); break;
			case 'APE039': return cdos_mostrarAlert("No se pudieron asignar todos los productos al llenarse todos los anaqueles"); break;
            case 'APE040': return cdos_mostrarExito("La asignacion del producto " + arg1 + " al anaquel " + arg2 + " es valida"); break;
			case 'APE041': return cdos_mostrarConfirm("El CD ya ha sido balanceado. �Desea realizar de nuevo la operaci�n eliminando los datos existentes?");  break;
			case 'APE042': return cdos_mostrarConfirm("�Desea mantener los datos ingresados manualmente?");  break;
			case 'APE043': return cdos_mostrarConfirm("Ya se ha generado previamente la lista de estimados de la campa�a. �Desea rescribirla?");  break;
			case 'APE044': return cdos_mostrarConfirm("�Desea conservar los datos introducidos manualmente?");  break;
			case 'APE045': return cdos_mostrarAlert("Hay productos asignados a los anaqueles manipulados.");  break;
			case 'APE046': return cdos_mostrarAlert("El campo C�d. anaquel origen es obligatorio"); break;
			case 'APE047': return cdos_mostrarAlert("Debe asignar al menos un producto a un anaquel"); break;
			case 'APE048': return cdos_mostrarAlert("El porcentaje de seguridad debe tener un valor menor que 100"); break;
			case 'APE049': return cdos_mostrarConfirm("Faltan " + arg1 + " Unidades. �Desea continuar?");  break;
			case 'APE050': return cdos_mostrarConfirm("Sobran " + arg1 + " Unidades. �Desea continuar?");  break;
			case 'APE051': return cdos_mostrarExito("Revisados todos los productos de la caja");  break;

			case 'APE052': return cdos_mostrarAlert("Hay " + arg1 + " Faltantes"); break;
			case 'APE053': return cdos_mostrarAlert("Hay " + arg1 + " Sobrantes"); break;

			case '3349': return cdos_mostrarAlert("El campo 'Centro distribuci�n' es obligatorio."); break; 
			case '3350': return cdos_mostrarAlert("El campo 'Mapa centro distribuci�n' es obligatorio."); break; 
			case '3351': return cdos_mostrarAlert("El campo 'Mapa zonas' es obligatorio."); break; 
			case '3352': return cdos_mostrarAlert("El campo 'Periodo' es obligatorio."); break; 

			case '3360': return cdos_mostrarConfirm("�Desea borrar el Orden de Anaquel seleccionado?"); break;
		    case '3361': return "Porcentaje productos"; break;

			case '3374': return cdos_mostrarAlert("Sublinea Armado debe tener detalles"); break;
			case '3375': return cdos_mostrarAlert(campo_obligatorio+" Tipo Caja Producto."); break; 
			case '3376': return cdos_mostrarAlert(campo_obligatorio+" Capacidad anaquel tipo caja"); break; 
			case '3377': return "Capacidad anaquel tipo caja"; break;
			case '3378': return "No se puede desdoblar una linea con un solo articulo"; break;
			case '3379': return "El numero de unidades introducido no es correcto"; break;

			case 'APEUI048': return cdos_mostrarAlert("Las etiquetas han sido impresas"); break;
			case 'APEUI057': return cdos_mostrarAlert("Los anaqueles ingresados no pertenecen a la misma bah�a"); break;
			case 'APEUI061': return cdos_mostrarAlert("No se ha definido zona para todas las bah�as de la l�nea"); break;
			case 'APEUI065': return cdos_mostrarAlert("Debe Seleccionar al menos un criterio de Origen Chequeo"); break;
			case 'APEUI066': return cdos_mostrarAlert("No existe el codigo de territorio: " + arg1); break;			
			case 'APEUI067': return cdos_mostrarAlert("Debe seleccionar un Periodo o ingresar Fecha Desde"); break;	

			// Cambio APE-09 - dmorello, 05/06/2008
			case 'APEUI068': return "Las etiquetas del consolidado " + arg1 + " fueron impresas correctamente"; break;
			
			//	Agregado por HRCS - Fecha 14/08/2007 - Cambio Sicc20070361
			case 'MAE0039': return cdos_mostrarConfirm("El cliente no cumple con el rango de edades especificado para el Tipo y Subtipo de cliente. Pulse [Aceptar] para corregir la fecha de nacimiento o [Cancelar] para abortar el ingreso del cliente.");
			case 'MAE0040': return cdos_mostrarConfirm("El cliente no cumple con el rango de edades especificado para el Tipo y Subtipo de cliente. Pulse [Aceptar] para corregir la fecha de nacimiento o [Cancelar] para continuar con las modificaciones.");
			case 'MAE0041': return cdos_mostrarAlert("El cliente de v�nculo No es v�lido porque es de tipo 'Hija Dupla'.");
			case 'MAE0042': return cdos_mostrarAlert("El cliente de v�nculo No es v�lido porque no es de tipo 'Consultor(a)'.");
			case 'MAE0043': return cdos_mostrarAlert("El cliente de v�nculo No existe.");
			case 'MAE0044': return cdos_mostrarAlert("Debe definir en Grupo V�nculos uno del Tipo Dupla Cyzone y que debe ser el �nico en su tipo para el cliente.");
			case 'MAE0045': return cdos_mostrarAlert("El v�nculo Dupla Cyzone no debe estar seleccionado como V�nculo Principal.");
			case 'MAE0046': return cdos_mostrarAlert("Debe ingresar la Fecha de Nacimiento del cliente.");
			case 'MAE0047': return cdos_mostrarAlert("Codigo de cliente vinculo No puede ser el mismo que el codigo del cliente.");


			// Agregado por dmorello - 14/03/2008 - Cambio COL-BLO-001
			case 'MAE0048': return cdos_mostrarAlert("Ya existe otro tipo de bloqueo financiero");
			case 'MAE0049': return cdos_mostrarAlert("Nivel de gravedad debe ser mayor a cero; introduzca otro nivel de gravedad");
			
			// Agregado por dmorello - 17/03/2008 - Cambio COL-BLO-001
			case 'MAE0050': return cdos_mostrarAlert("Debe introducir al menos un criterio de b�squeda");
			case 'MAE0051': return cdos_mostrarAlert("C�digo Usuario "+arg1+" no existe, introduzca otro valor");
			case 'MAE0052': return cdos_mostrarConfirm("Cliente ya bloqueado, �desea modificar el bloqueo actual?");
			case 'MAE0053': return cdos_mostrarAlert("El usuario no est� autorizado para desbloquear");
			case 'MAE0054': return cdos_mostrarAlert("El tipo de bloqueo no puede desbloquearse de forma manual");

			//	Agregado por Sapaza - Fecha 26/09/2007 - Cambio COL-CCC-03
			case 'UICCC0038' : return  cdos_mostrarAlert("El C�digo de consultora a reasignar debe ser <> al c�digo de consultora reasignado"); break;

			//	Agregado por jrivas - BRECHA CRA-003
			case 'CRA003': return cdos_mostrarConfirm("Alguna de las Zonas seleccionadas tiene datos. �Desea eliminarlos?");
			case 'CRA003.2': return cdos_mostrarAlert("No existen datos para la zona de referencia y periodo seleccionados");

			//	Agregado por enozigli - BRECHA CRA-001
			case '3380': return "Referencia otra Campa�a"; break;

			case '3381': return cdos_mostrarAlert("Per�odo Inicial Evaluaci�n debe ser menor o igual Per�odo Final Evaluaci�n"); break;
			
			// dmorello, 20/06/2008 - CRA-01
			case 'CRA001': return cdos_mostrarAlert("La actividad ingresada no puede referenciar a otra actividad del mismo per�odo"); break;
			case 'CRA001.2': return cdos_mostrarAlert("Es obligatorio ingresar un per�odo de referencia para la actividad seleccionada"); break;

			//	Agregado por enozigli - 13/07/2009 - Cambio ped fletes
            case '3382': return "El campo 'Rango Inferior' debe ser menor al valor del campo 'Rango Superior'"; return;
            case '3383': return "La definici�n de rangos no es correcta. Se producen solapamientos"; return;

			case '3384': return cdos_mostrarAlert("Se debe rellenar s�lo uno de los campos: C�digo de Anaquel, C�digo de Producto o Descripci�n."); break;
			
			//	Agregado por Sapaza - Fecha 15/07/2010 - PER-SiCC-2010-0395
			case 'INC057': return cdos_mostrarAlert("El Monto m�nimo pedido tiene que ser mayor o igual a 1"); break;

			//	Agregado por Sapaza - Fecha 18/08/2010 - PER-SiCC-2010-0141			
			case 'PED086': return cdos_mostrarConfirm("No hay ninguna zona seleccionada, desea enviar el proceso para todas las zonas filtradas?");
			
			//	Agregado por Sapaza - Fecha 20/08/2010 - PER-SiCC-2010-0478
			case 'COM056': return cdos_mostrarAlert("Se tiene que ingresar %Comisi�n o Bono"); break;
			
  }
}
                           