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
 * la dalistribución de este código sin permiso expreso.
 */

import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOMultinivel;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import java.math.BigDecimal;
import es.indra.sicc.util.UtilidadesBelcorp;

public class LPMantenerMultinivel extends LPIncentivos{ 
  private String pais = null;
  private String idioma = null;
  private String formatoFechaPais = null;   
  private String datosObligatorios = null;
  private String estadoAGeo = null;
  private String estadoCali = null;
  private String estadoGerente = null;
  private String estadoConsultora= null;
  private String programaNuevas= null;
  private String estadoMultinivel= null;  
  
  public LPMantenerMultinivel() { super();  }

  public void inicio() throws Exception {        
    this.obtenerFlagsPestanyas();
    pagina("contenido_multinivel_mantener");    
    this.cargarFlagsPestanyas();
    this.getFormatosValidaciones();
  }  
  
  public void ejecucion() throws Exception  {
    setTrazaFichero();
    
    accion     	= conectorParametroLimpia("accion", "", true);
    traza("accion>>>> " + accion);        
    pais 	  	= UtilidadesSession.getPais(this).toString();
    traza("pais >>>>  "  +pais );         
    idioma              = UtilidadesSession.getIdioma(this).toString();
    traza("idioma >>>> " + idioma);	       
    formatoFechaPais    = UtilidadesSession.getFormatoFecha(this);      
    opcionMenu = conectorParametroLimpia("opcionMenu", "", true);     
    
    estadoAGeo = conectorParametroLimpia("hIndEstadoAmbitoGeografico", "", true);
    estadoCali = conectorParametroLimpia("hIndEstadoCalificion", "", true);
    estadoGerente = conectorParametroLimpia("hIndEstadoGerentes", "", true);
    estadoConsultora = conectorParametroLimpia("hIndEstadoConsultoras", "", true);
    programaNuevas = conectorParametroLimpia("hIndEstadoProgramaNuevas", "", true);
    estadoMultinivel = conectorParametroLimpia("hIndEstadoMultinivel", "", true);
           
    try {    
          getConfiguracionMenu("LPMantenerMultinivel" ,"");
          asignarAtributo("VAR","hFormatoFechaPais","valor",formatoFechaPais);     
          asignarAtributo("VAR","hPais","valor",pais);
          asignarAtributo("VAR","hIdioma","valor",idioma);         
          asignarAtributo("VAR", "hIndEstadoAmbitoGeografico", "valor", estadoAGeo);
          
          if (accion.equals("")){ 
              this.cargarPantalla();
          }                   
        
         if (accion.equals("almacenar")){       
               this.almacenar();                                
               this.redirigir();
         } 
                                
         if (accion.equals("guardar")){           
               this.almacenar(); 
               this.guardar(); 
         }
                  
         if(accion.equals("redirigir")){                      
              this.redirigir();
         } 
         
        if(opcionMenu.equals("Crear concurso")){
          asignarAtributoPagina("cod", "0491");             
        }
        else if(opcionMenu.equals("Consultar Concurso")){
            asignarAtributoPagina("cod", "0493");
        }
        else if(opcionMenu.equals("Modificar Concurso")){
            asignarAtributoPagina("cod", "0486");
        }
   
     }
	 catch( Exception e )  {
		traza("Exception en LPMantenerMultinivel " + e);
        e.printStackTrace();     
        lanzarPaginaError(e);
     }
   }
  
	public void cargarPantalla() throws Exception{  
		  traza("******** Entro a LPMantenerMultinivel.cargarPantalla()");
		  DTOConcurso dtoConcurso =  this.getConcurso();
  		  traza("******** dtoConcurso " + dtoConcurso);
  
		  DTOBelcorp dtob = new DTOBelcorp();                
		  dtob.setOidIdioma(dtoConcurso.getOidIdioma());
		  dtob.setOidPais(dtoConcurso.getOidPais());		  
		 
		  //--Se crea un dtoPeriodo 
		  DTOPeriodo dtop = new DTOPeriodo();
		  
		  dtop.setOidPais(dtoConcurso.getOidPais());
		  dtop.setOidIdioma(dtoConcurso.getOidIdioma());
		  dtop.setMarca(dtoConcurso.getParamGenerales().getOidMarca());
		  dtop.setCanal(dtoConcurso.getParamGenerales().getOidCanal());
		  
		  ComposerViewElementList lista = new ComposerViewElementList();  
		  
		  //-- cbPeriodoDesde    
		  ComposerViewElement cmb1 = new ComposerViewElement();
		  cmb1.setIDBusiness("CRAObtienePeriodos");
		  cmb1.setDTOE(dtop);          
			   
		  //-- cbCalculoPremio 
		  ComposerViewElement cmb2 = new ComposerViewElement();
		  cmb2.setIDBusiness("INCObtenerCalculoPremio"); 
		  cmb2.setDTOE(dtob);

		  lista.addViewElement(cmb1);
		  lista.addViewElement(cmb2);  
		  
		  ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		  conector.ejecucion();
			  
		  DruidaConector resultados = conector.getConector();			  
			  
		  // - Invocar al subsistema GestorCargaPantalla         
		  asignar("COMBO","cbPeriodoDesde", resultados,"CRAObtienePeriodos");                                             
		  asignar("COMBO","cbPeriodoHasta", resultados,"CRAObtienePeriodos");
		  asignar("COMBO","cbCalculoPremio", resultados,"INCObtenerCalculoPremio");                                             
		  asignar("COMBO","cbPeriodoDesdePagoTiempo", resultados,"CRAObtienePeriodos");
		  asignar("COMBO","cbPeriodoHastaPagoTiempo", resultados,"CRAObtienePeriodos");

		  String oid = "";

		  String cbPeriodoDesde = "";
		  String cbPeriodoHasta = "";
		  String txtPeriodoEsperaParaCalculo = "";
		  String txtPeriodoEsperaSobreCalculo = "";
 
		  String txtNumMinRecomendadas = "";
		  String txtMontoMinRed = "";
		  String txtPedidoMinRed = "";
		  String txtUnidadesMinRed = "";

		  String txtMontoMinMadre = "";
		  String txtPedidoMinMadre = "";
		  String txtUnidadesMinMadre = "";

		  String txtMontoMinPedidoHijas = "";
		  String txtPedidoMinHijas = "";
		  String txtUnidadesMinPedidoHijas = "";

		  String cbCalculoPremio = "";
		  String txtPorcentajePremioSobreVenta = "";
		  String txtPorcentajePremioSobreCobranza = "";

		  String ckActividad = "";
		  String txtMontoMinPedidoHijas1 = "";
		  String txtUnidadesMinPedidoHijas1 = "";

		  String ckPagoTiempo = "";
		  String cbPeriodoDesdePagoTiempo = "";
		  String cbPeriodoHastaPagoTiempo = "";
		  String txtDiasGracia = "";
		  
		  //--Si es true indica que se ha llenado la pestania
		  Boolean indMultinivel = dtoConcurso.getIndMultinivel();
			if (indMultinivel != null && indMultinivel.booleanValue() == true){		
				//1°oid
				if (dtoConcurso.getMultinivel().getOid() != null) 
					oid = dtoConcurso.getMultinivel().getOid().toString();
				asignarAtributo("VAR","oid","valor", oid);

				//2° Periodo desde			
				if (dtoConcurso.getMultinivel().getOidPeriodoDesde() != null)
					cbPeriodoDesde = dtoConcurso.getMultinivel().getOidPeriodoDesde().toString();			  
				asignarAtributo("VAR","TempcbPeriodoDesde","valor", cbPeriodoDesde);

				//3° Periodo hasta
				if (dtoConcurso.getMultinivel().getOidPeriodoHasta() != null)
					cbPeriodoHasta = dtoConcurso.getMultinivel().getOidPeriodoHasta().toString();			  
				asignarAtributo("VAR","TempcbPeriodoHasta","valor", cbPeriodoHasta);

				//4° Periodos para calculo					
				if(dtoConcurso.getMultinivel().getPeriodosParaCalculo() != null) {
				    txtPeriodoEsperaParaCalculo = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getPeriodosParaCalculo().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				asignarAtributo("VAR","TemptxtPeriodoEsperaParaCalculo","valor", txtPeriodoEsperaParaCalculo);

				//5° Periodos sobre calculo			  
				if (dtoConcurso.getMultinivel().getPeriodosSobreCalculo() != null) {
					txtPeriodoEsperaSobreCalculo = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getPeriodosSobreCalculo().toString(), 
						this.FORMATO_DEFAULT, this);					
				}
				asignarAtributo("VAR","TemptxtPeriodoEsperaSobreCalculo","valor", txtPeriodoEsperaSobreCalculo);

				//6° Numero minimo recomendadas				
				if (dtoConcurso.getMultinivel().getNumeroMinimoRecomendadas() != null) {
					txtNumMinRecomendadas = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getNumeroMinimoRecomendadas().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				asignarAtributo("VAR","TemptxtNumMinRecomendadas","valor", txtNumMinRecomendadas);				
				
				//7° Monto minimo red
				if(dtoConcurso.getMultinivel().getMontoMinimoRed() != null) {
					txtMontoMinRed = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getMontoMinimoRed().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				asignarAtributo("VAR","TemptxtMontoMinRed","valor", txtMontoMinRed);

				//8° Pedidos minimo red
				if (dtoConcurso.getMultinivel().getPedidosMinimosRed() != null) {
					txtPedidoMinRed = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getPedidosMinimosRed().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				asignarAtributo("VAR","TemptxtPedidoMinRed","valor", txtPedidoMinRed);

				//9° Unidades min red
				if (dtoConcurso.getMultinivel().getUnidadesMinimasRed() != null) {
					txtUnidadesMinRed = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getUnidadesMinimasRed().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				asignarAtributo("VAR","TemptxtUnidadesMinRed","valor", txtUnidadesMinRed);

				//10° Monto minimo madre
				if (dtoConcurso.getMultinivel().getMontoMinimoMadre() != null) {
					txtMontoMinMadre = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getMontoMinimoMadre().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				asignarAtributo("VAR","TemptxtMontoMinMadre","valor", txtMontoMinMadre);

				//11° Pedidos minimo madre
				if (dtoConcurso.getMultinivel().getPedidosMinimosMadre() != null) {
					txtPedidoMinMadre = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getPedidosMinimosMadre().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				asignarAtributo("VAR","TemptxtPedidoMinMadre","valor", txtPedidoMinMadre);

				//12° Unidades min madre
				if (dtoConcurso.getMultinivel().getUnidadesMinimasMadre() != null) {
					txtUnidadesMinMadre = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getUnidadesMinimasMadre().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				asignarAtributo("VAR","TemptxtUnidadesMinMadre","valor", txtUnidadesMinMadre);
				
				//13° Monto min pedido por hijas
				if (dtoConcurso.getMultinivel().getMontoMinimoPedidoPorHijas() != null) {
					txtMontoMinPedidoHijas = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getMontoMinimoPedidoPorHijas().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				asignarAtributo("VAR","TemptxtMontoMinPedidoHijas","valor", txtMontoMinPedidoHijas);

				//14° Pedido minimo hijas
				if (dtoConcurso.getMultinivel().getPedidosMinimosHijas() != null) {
					txtPedidoMinHijas = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getPedidosMinimosHijas().toString(), 
						this.FORMATO_DEFAULT, this);
				}
 			    asignarAtributo("VAR","TemptxtPedidoMinHijas","valor", txtPedidoMinHijas);

				//15° Unidades min hijas
				if (dtoConcurso.getMultinivel().getUnidadesMinimasHijas() != null) {
					txtUnidadesMinPedidoHijas = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getUnidadesMinimasHijas().toString(), 
						this.FORMATO_DEFAULT, this);					
				}
 			    asignarAtributo("VAR","TemptxtUnidadesMinPedidoHijas","valor", txtUnidadesMinPedidoHijas);

				//16° Calculo premio
				if (dtoConcurso.getMultinivel().getOidCalculoPremio() != null)
					cbCalculoPremio = dtoConcurso.getMultinivel().getOidCalculoPremio().toString();
				asignarAtributo("VAR","TempcbCalculoPremio","valor", cbCalculoPremio);

				//17° Porcentaje sobre ventas
				if (dtoConcurso.getMultinivel().getPorcentajeSobreVenta() != null) {
					txtPorcentajePremioSobreVenta = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getPorcentajeSobreVenta().toString(), 
						this.FORMATO_DEFAULT, this);					
				}
				asignarAtributo("VAR","TemptxtPorcentajePremioSobreVenta","valor", txtPorcentajePremioSobreVenta);

				//18° Porcentaje sobre cobranzas
				if (dtoConcurso.getMultinivel().getPorcentajeSobreCobranza() != null) {
					txtPorcentajePremioSobreCobranza = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getPorcentajeSobreCobranza().toString(), 
						this.FORMATO_DEFAULT, this);					
				}
				asignarAtributo("VAR","TemptxtPorcentajePremioSobreCobranza","valor", txtPorcentajePremioSobreCobranza);

				//19° Actividad					
				if (dtoConcurso.getMultinivel().getActividad() != null)
					ckActividad = dtoConcurso.getMultinivel().getActividad().toString();
				asignarAtributo("VAR","TempckActividad","valor", ckActividad);

				//20° Monto minimo pedido hijas
				if (dtoConcurso.getMultinivel().getMontoMinimoPedidoHijas() != null) {
					txtMontoMinPedidoHijas1 = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getMontoMinimoPedidoHijas().toString(), 
						this.FORMATO_DEFAULT, this);					
				}
				asignarAtributo("VAR","TemptxtMontoMinPedidoHijas1","valor", txtMontoMinPedidoHijas1);

				//21° Unidades min pedido hijas				
				if (dtoConcurso.getMultinivel().getUnidadesMinimasPedidoHijas() != null) {
					txtUnidadesMinPedidoHijas1 = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getUnidadesMinimasPedidoHijas().toString(), 
						this.FORMATO_DEFAULT, this);					
				}
				asignarAtributo("VAR","TemptxtUnidadesMinPedidoHijas1","valor", txtUnidadesMinPedidoHijas1);

				//22° Pago a tiempo				
				if(dtoConcurso.getMultinivel().getPagoTiempo() != null)
					ckPagoTiempo = dtoConcurso.getMultinivel().getPagoTiempo().toString();
				asignarAtributo("VAR","TempckPagoTiempo","valor", ckPagoTiempo);

				//23° Periodo desde pago
				if (dtoConcurso.getMultinivel().getOidPeriodoATiempoDesde() != null)
					 cbPeriodoDesdePagoTiempo = dtoConcurso.getMultinivel().getOidPeriodoATiempoDesde().toString();
				asignarAtributo("VAR","TempcbPeriodoDesdePagoTiempo","valor", cbPeriodoDesdePagoTiempo);

				//24° Periodo hasta pago
				if (dtoConcurso.getMultinivel().getOidPeriodoATiempoHasta() != null)
					cbPeriodoHastaPagoTiempo = dtoConcurso.getMultinivel().getOidPeriodoATiempoHasta().toString();
				asignarAtributo("VAR","TempcbPeriodoHastaPagoTiempo","valor", cbPeriodoHastaPagoTiempo);

				//25° Dias gracia				
				if (dtoConcurso.getMultinivel().getDiasGracia() != null) {
					txtDiasGracia = UtilidadesBelcorp.formateaNumeroSICC(dtoConcurso.getMultinivel().getDiasGracia().toString(), 
						this.FORMATO_DEFAULT, this);					
				}
				asignarAtributo("VAR","TemptxtDiasGracia","valor", txtDiasGracia);		   
		   
			}
			else{		   
				oid = null;
				ckActividad = ConstantesINC.IND_INACTIVO.toString();
				asignarAtributo("VAR","hChkActividad","valor", ckActividad);
					
				//--Falta agregar la constante OID_CALCULO_PREMIO_HIJAS 
				cbCalculoPremio = ConstantesINC.OID_BASE_CALCULO_MONTO.toString();
				asignarAtributo("VAR","hOidCalculoPremio","valor", cbCalculoPremio);
					
				//--Falta agregar la constante ConstantesINC.OID_IND_INACTIVO 
				ckPagoTiempo = ConstantesINC.OID_TIPO_PRODUCTOS_A_CALIFICAR.toString();
				asignarAtributo("VAR","hChkPagoTiempo","valor", ckPagoTiempo);				
			} //-- Fin de dtoConcurso.indMultinivel
			
			//--Se asigna a la pag. opcionMenu y accion
			asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
			asignarAtributo("VAR", "accion", "valor", accion);    
	} 
 
	public void almacenar() throws Exception{ 
		traza("********* Entro a LPMantenerMultinivel.almacenar()");
	    DTOConcurso dto = this.getConcurso();        
	    traza("***** dto " + dto);
   
		String oid = conectorParametroLimpia("oid", "", true);
	    traza("********* oid: " + oid);

		//Comienzo de la obtencion de los campos de la pantalla
		//Linea 1
		String cbPeriodoDesde = conectorParametroLimpia("TempcbPeriodoDesde", "", true);
		String cbPeriodoHasta = conectorParametroLimpia("TempcbPeriodoHasta", "", true);
		String txtPeriodoEsperaParaCalculo = conectorParametroNumero("TemptxtPeriodoEsperaParaCalculo", this.FORMATO_DEFAULT);
		String txtPeriodoEsperaSobreCalculo = conectorParametroNumero("TemptxtPeriodoEsperaSobreCalculo", this.FORMATO_DEFAULT);
		traza("******** cbPeriodoDesde " + cbPeriodoDesde);
		traza("******** cbPeriodoHasta " + cbPeriodoHasta);
		traza("******** txtPeriodoEsperaParaCalculo " + txtPeriodoEsperaParaCalculo);
		traza("******** txtPeriodoEsperaSobreCalculo " + txtPeriodoEsperaSobreCalculo);

		//Linea 2
		String txtNumMinRecomendadas = conectorParametroNumero("TemptxtNumMinRecomendadas", this.FORMATO_DEFAULT);
		String txtMontoMinRed = conectorParametroNumero("TemptxtMontoMinRed", this.FORMATO_DEFAULT);
		String txtPedidoMinRed = conectorParametroNumero("TemptxtPedidoMinRed", this.FORMATO_DEFAULT);
		String txtUnidadesMinRed = conectorParametroNumero("TemptxtUnidadesMinRed", this.FORMATO_DEFAULT);
		traza("******** txtNumMinRecomendadas " + txtNumMinRecomendadas);
		traza("******** txtMontoMinRed " + txtMontoMinRed);
		traza("******** txtPedidoMinRed " + txtPedidoMinRed);
		traza("******** txtUnidadesMinRed " + txtUnidadesMinRed);

		//Linea 3
		String txtMontoMinMadre = conectorParametroNumero("TemptxtMontoMinMadre", this.FORMATO_DEFAULT);
		String txtPedidoMinMadre = conectorParametroNumero("TemptxtPedidoMinMadre", this.FORMATO_DEFAULT);
		String txtUnidadesMinMadre = conectorParametroNumero("TemptxtUnidadesMinMadre", this.FORMATO_DEFAULT);
		traza("******** txtMontoMinMadre " + txtMontoMinMadre);
		traza("******** txtPedidoMinMadre " + txtPedidoMinMadre);
		traza("******** txtUnidadesMinMadre " + txtUnidadesMinMadre);

		//Linea 4
		String txtMontoMinPedidoHijas = conectorParametroNumero("TemptxtMontoMinPedidoHijas", this.FORMATO_DEFAULT);
		String txtPedidoMinHijas = conectorParametroNumero("TemptxtPedidoMinHijas", this.FORMATO_DEFAULT);
		String txtUnidadesMinPedidoHijas = conectorParametroNumero("TemptxtUnidadesMinPedidoHijas", this.FORMATO_DEFAULT);
		traza("******** txtMontoMinPedidoHijas " + txtMontoMinPedidoHijas);
		traza("******** txtPedidoMinHijas " + txtPedidoMinHijas);
		traza("******** txtUnidadesMinPedidoHijas " + txtUnidadesMinPedidoHijas);

		//Linea 5
		String cbCalculoPremio = conectorParametroLimpia("TempcbCalculoPremio", "", true);
		String txtPorcentajePremioSobreVenta = conectorParametroNumero("TemptxtPorcentajePremioSobreVenta", this.FORMATO_DEFAULT);
		String txtPorcentajePremioSobreCobranza = conectorParametroNumero("TemptxtPorcentajePremioSobreCobranza", this.FORMATO_DEFAULT);
		traza("******** cbCalculoPremio " + cbCalculoPremio);
		traza("******** txtPorcentajePremioSobreVenta " + txtPorcentajePremioSobreVenta);
		traza("******** txtPorcentajePremioSobreCobranza " + txtPorcentajePremioSobreCobranza);

		//Linea 6
		String ckActividad = conectorParametroLimpia("TempckActividad", "", true);
		String txtMontoMinPedidoHijas1 = conectorParametroNumero("TemptxtMontoMinPedidoHijas1", this.FORMATO_DEFAULT);
		String txtUnidadesMinPedidoHijas1 = conectorParametroNumero("TemptxtUnidadesMinPedidoHijas1", this.FORMATO_DEFAULT);
		traza("******** ckActividad " + ckActividad);
		traza("******** txtMontoMinPedidoHijas1 " + txtMontoMinPedidoHijas1);
		traza("******** txtUnidadesMinPedidoHijas1 " + txtUnidadesMinPedidoHijas1);

		//Linea 7
		String ckPagoTiempo = conectorParametroLimpia("TempckPagoTiempo", "", true);
		String cbPeriodoDesdePagoTiempo = conectorParametroLimpia("TempcbPeriodoDesdePagoTiempo", "", true);
		String cbPeriodoHastaPagoTiempo = conectorParametroLimpia("TempcbPeriodoHastaPagoTiempo", "", true);
		String txtDiasGracia = conectorParametroNumero("TemptxtDiasGracia", this.FORMATO_DEFAULT);
		traza("******** ckPagoTiempo " + ckPagoTiempo);
		traza("******** cbPeriodoDesdePagoTiempo " + cbPeriodoDesdePagoTiempo);
		traza("******** cbPeriodoHastaPagoTiempo " + cbPeriodoHastaPagoTiempo);
		traza("******** txtDiasGracia " + txtDiasGracia);
		//Fin de la obtencion de los campos de la pantalla

		datosObligatorios = conectorParametroLimpia("datosObligatorios", "", true);    
		traza("*********** datosObligatorios "  + datosObligatorios);

		DTOMultinivel dtoMultinivel = new DTOMultinivel();

		//1° oid
		if(oid.length()>0) dtoMultinivel.setOid(new Long(oid));
		else dtoMultinivel.setOid(null);
		//2° Periodo Desde    
	    if(cbPeriodoDesde.length()>0) dtoMultinivel.setOidPeriodoDesde(new Long(cbPeriodoDesde));
		else dtoMultinivel.setOidPeriodoDesde(null);
		//3° Periodo Hasta      
	    if(cbPeriodoHasta.length()>0) dtoMultinivel.setOidPeriodoHasta(new Long(cbPeriodoHasta));
		else dtoMultinivel.setOidPeriodoHasta(null);
		//4° Periodos para calculo     
	    if(txtPeriodoEsperaParaCalculo.length()>0) dtoMultinivel.setPeriodosParaCalculo(new Integer(txtPeriodoEsperaParaCalculo));
		else dtoMultinivel.setPeriodosParaCalculo(null);
		//5° Periodos sobre calculo    
	    if(txtPeriodoEsperaSobreCalculo.length()>0) dtoMultinivel.setPeriodosSobreCalculo(new Integer(txtPeriodoEsperaSobreCalculo));
		else dtoMultinivel.setPeriodosSobreCalculo(null);
		//6° Numero minimo recomendadas    
	    if(txtNumMinRecomendadas.length()>0) dtoMultinivel.setNumeroMinimoRecomendadas(new Integer(txtNumMinRecomendadas));
		else dtoMultinivel.setNumeroMinimoRecomendadas(null);
		//7° Monto minimo red
	    if(txtMontoMinRed.length()>0) dtoMultinivel.setMontoMinimoRed(new BigDecimal(txtMontoMinRed));
		else dtoMultinivel.setMontoMinimoRed(null);
		//8° Pedidos minimos red
	    if(txtPedidoMinRed.length()>0) dtoMultinivel.setPedidosMinimosRed(new Integer(txtPedidoMinRed));
		else dtoMultinivel.setPedidosMinimosRed(null);
		//9° Unidades min red    
		if(txtUnidadesMinRed.length()>0) dtoMultinivel.setUnidadesMinimasRed(new Integer(txtUnidadesMinRed));
		else dtoMultinivel.setUnidadesMinimasRed(null);
		//10° Monto minimo madre
	    if (txtMontoMinMadre.length()>0) dtoMultinivel.setMontoMinimoMadre(new BigDecimal(txtMontoMinMadre));
		else dtoMultinivel.setMontoMinimoMadre(null);
		//11° Pedidos minimo madre     
		if(txtPedidoMinMadre.length()>0) dtoMultinivel.setPedidosMinimosMadre(new Integer(txtPedidoMinMadre));
		else dtoMultinivel.setPedidosMinimosMadre(null);
		//12° Unidades min madre   
	    if(txtUnidadesMinMadre.length()>0) dtoMultinivel.setUnidadesMinimasMadre(new Integer(txtUnidadesMinMadre));
		else dtoMultinivel.setUnidadesMinimasMadre(null);
		//13° Monto min pedido por hijas  
	    if(txtMontoMinPedidoHijas.length()>0) dtoMultinivel.setMontoMinimoPedidoPorHijas(new BigDecimal(txtMontoMinPedidoHijas));
		else dtoMultinivel.setMontoMinimoPedidoPorHijas(null);
		//14° Pedidos minimos  hijas
	    if(txtPedidoMinHijas.length()>0) dtoMultinivel.setPedidosMinimosHijas(new Integer(txtPedidoMinHijas));
		else dtoMultinivel.setPedidosMinimosHijas(null);
		//15° Unidades min hijas    
	    if(txtUnidadesMinPedidoHijas.length()>0) dtoMultinivel.setUnidadesMinimasHijas(new Integer(txtUnidadesMinPedidoHijas));
		else dtoMultinivel.setUnidadesMinimasHijas(null);
		//16° Calculo premio    
	    if (cbCalculoPremio.length()>0) dtoMultinivel.setOidCalculoPremio(new Long(cbCalculoPremio));
		else dtoMultinivel.setOidCalculoPremio(null);
		//17° Porcentaje sobre ventas  
	    if (txtPorcentajePremioSobreVenta.length()>0) dtoMultinivel.setPorcentajeSobreVenta(new BigDecimal(txtPorcentajePremioSobreVenta));
		else dtoMultinivel.setPorcentajeSobreVenta(null);
		//18° Porcentaje sobre cobranza    
	    if(txtPorcentajePremioSobreCobranza.length()>0) dtoMultinivel.setPorcentajeSobreCobranza(new BigDecimal(txtPorcentajePremioSobreCobranza));
		else dtoMultinivel.setPorcentajeSobreCobranza(null);
		//19° Actividad    
	    if (ckActividad.equals("S")) {
			dtoMultinivel.setActividad(new Boolean(true));
			//20° Monto minimo pedido hijas
			if (txtMontoMinPedidoHijas1.length()>0){
				dtoMultinivel.setMontoMinimoPedidoHijas(new BigDecimal(txtMontoMinPedidoHijas1));
	        }        
			else {
				dtoMultinivel.setMontoMinimoPedidoHijas(null);
			}
			//21° Unidades min pedido hijas
	        if (txtUnidadesMinPedidoHijas1.length()>0){
		        dtoMultinivel.setUnidadesMinimasPedidoHijas(new Integer(txtUnidadesMinPedidoHijas1));
			}    
			else {
				dtoMultinivel.setUnidadesMinimasPedidoHijas(null);
			}
		}		    
	    else {
		    dtoMultinivel.setActividad(new Boolean(false));
            dtoMultinivel.setMontoMinimoPedidoHijas(null);
            dtoMultinivel.setUnidadesMinimasPedidoHijas(null);
		}
		//22° Pago a tiempo        
	    if (ckPagoTiempo.equals("S")){
		    dtoMultinivel.setPagoTiempo(new Boolean(true));
	        //23° Periodo desde pago a tiempo
			if (cbPeriodoDesdePagoTiempo.length()>0){
				dtoMultinivel.setOidPeriodoATiempoDesde(new Long(cbPeriodoDesdePagoTiempo));
	        }  		   
			else {
				dtoMultinivel.setOidPeriodoATiempoDesde(null);
			}
	        //24° Periodo hasta pago a tiempo
			if (cbPeriodoHastaPagoTiempo.length()>0){
				dtoMultinivel.setOidPeriodoATiempoHasta(new Long(cbPeriodoHastaPagoTiempo));
	        }          
			else {
				dtoMultinivel.setOidPeriodoATiempoHasta(null);
			}
	        //25° Dias gracia
	        if (txtDiasGracia.length()>0){
		        dtoMultinivel.setDiasGracia(new Integer(txtDiasGracia));
			}       
			else {
				dtoMultinivel.setDiasGracia(null);
			}
	    }
		else{        
	        dtoMultinivel.setPagoTiempo(new Boolean(false));
		    dtoMultinivel.setOidPeriodoATiempoDesde(null);
			dtoMultinivel.setOidPeriodoATiempoHasta(null);
	        dtoMultinivel.setDiasGracia(null); 
		}   
    
	    if ((datosObligatorios != null) && (datosObligatorios.length()>0)){
		   dto.setIndObligMultinivel(new Boolean(datosObligatorios));
	    }  

		dto.setIndMultinivel(new Boolean(true));
		dto.setMultinivel(dtoMultinivel);
	    traza("************* dto a subir a sesion: " + dto);    
		this.setConcurso(dto);  
	 }   
}
