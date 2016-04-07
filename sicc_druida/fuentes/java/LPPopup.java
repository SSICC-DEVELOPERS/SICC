/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

//import LPSICCBase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
public class LPPopup extends LPSICCBase {



	 private String accion = null;
	 private String casoUso = null;   
	 private Long idioma;
	 private Long pais;
	 private Long oidCanal;
	 private Long oidAcceso;
	
	    
          public LPPopup() {
                    super();
          }
          
          public void inicio() throws Exception {
          
          }

          public void ejecucion() throws Exception {
          //rastreo();
          
          setTrazaFichero();
          traza("[cs][cs]*** Entrada - LPPopup - ejecucion ***");
                    
    	try  {	
		traza("[cs][cs][cs]***LPPopup Entrada");
		this.idioma = UtilidadesSession.getIdioma(this);
                this.pais = UtilidadesSession.getPais(this);
                traza("[cs][cs][cs]idioma0 : " + this.idioma);
                traza("[cs][cs][cs]pais0 : " + this.pais);
                this.accion = conectorParametroLimpia("accion","", true);
                this.casoUso = conectorParametroLimpia("casodeUso","", true);
                 
                pagina("contenido_registro_ventas_insertar");
                Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
                asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());

                traza("[cs][cs]antes de asignar casUsoa ala pagina");
                asignar("VAR", "casoUso", this.casoUso);
                traza("[cs][cs] DEspues de  de asignar casUsoa ala pagina");
               
                traza("[cs][cs][cs]CasoUso definida : " + casoUso);
                traza("[cs][cs][cs]Accion definida : " + accion);
                
                this.generarHiddenFormatoFecha();
                
                String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
		        separadorMiles = ".";
		}
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);

                if(this.accion.equals("btn_modificar")){
               
			getConfiguracionMenu("LPPopup", "modificar");
			
		}	
		
                
               
  		asignar("VAR", "idioma", idioma.toString());
  		traza("[cs]\n[cs][cs]->Idioma : "+idioma);
  		asignar("VAR", "pais", pais.toString());	
  		traza("[cs]\n[cs][cs]->Pais : "+pais);
  		if(casoUso.equals("modificar")){
  			asignarAtributo("PAGINA","contenido_registro_ventas_insertar", "cod", "0784");
  			asignarAtributo("PAGINA","contenido_registro_ventas_insertar", "msgle", " Modificar Registro Ventas");
  		}

		if(casoUso.equals("eliminar")){
  			asignarAtributo("PAGINA","contenido_registro_ventas_insertar", "cod", "0785");
  			asignarAtributo("PAGINA","contenido_registro_ventas_insertar", "msgle", " Eliminar Registro Ventas");
  		}
  		if(casoUso.equals("consultar")){
  			asignarAtributo("PAGINA","contenido_registro_ventas_insertar", "cod", "0786");
  			asignarAtributo("PAGINA","contenido_registro_ventas_insertar", "msgle", " Consultar Registro Ventas");
  		}
   		
        	String oidSeleccionado = conectorParametroLimpia("oidSeleccionado","", true);
        	traza("[cs][cs][MUY IMOPORTANTE cs]->oidSeleccionado  : "+oidSeleccionado );
        	asignar("VAR", "oidSeleccionado", oidSeleccionado);
        	DTOOID dtoOid= new DTOOID();
        	dtoOid.setOid(new Long(oidSeleccionado)); //aqui le paso el oid que seleccionó en la lista editable.
		dtoOid.setOidPais(pais);
		dtoOid.setOidIdioma(idioma);
		traza("[cs]\n [cs] DTOOID RELLENO:  "+ dtoOid);
		
		
//CCCBuscarRegistroVentasOID = es.indra.mare.common.activator.EjbOperation,  
//activator/mons/ccc/MLNFBuscarRegistroVentasOID.xml
		  traza("[cs][cs]Rellenar vector paramConector");
          
		  Vector paramConector = new Vector();
		  paramConector.add(dtoOid);
		  paramConector.add(new MareBusinessID("CCCBuscarRegistroVentasOID"));             
		  traza("[cs][cs]Antes de Conectar ConectorBuscarRegistroVentasOID");
          
		  DruidaConector conector = conectar("ConectorBuscarRegistroVentasOID", paramConector);							
		  traza("[cs][cs]Despues de Conectar ConectorBuscarRegistroVentasOID");
          
		  traza("[cs]Obteniendo DTO de salida, ");
		  DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		  traza("[cs]Obtenido  DTOSalida");
		  traza("[cs]DTO de salida Contenido:\n");
		  traza("[cs]" + dtoSalida);
          
		  //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010 
		  asignar("VAR", "oid", oidSeleccionado.toString());
                 
                  RecordSet rs=new RecordSet();                                                                   
		  rs=dtoSalida.getResultado();                                                                    
		  //si es vacio el reco9rd Set nunca llegara aqui.
		  if (rs.getValueAt(0, "SOCI_OID_SOCI") != null){
		  	 traza("[cs]\nSOCI_OID_SOCI");
		  	Long oidEmpresa = new Long(((BigDecimal)rs.getValueAt(0,"SOCI_OID_SOCI")).longValue());//0 ->r.SOCI_OID_SOCI, ???  n12
		        
		         traza("[cs]\noidEmpresa" + oidEmpresa );
		        asignar("VAR", "cbOidEmpresa", oidEmpresa.toString());
		  }
		  if (rs.getValueAt(0, "TAIM_OID_TASA_IMPU") != null){
		  	traza("[cs]\nTAIM_OID_TASA_IMPU\n");
		  	Long tipoImpuesto = new Long(((BigDecimal)rs.getValueAt(0,"TAIM_OID_TASA_IMPU")).longValue());//2 ->BEL7739
		  	
		  	traza("[cs]tipoImpuesto" + tipoImpuesto );
		  	asignar("VAR", "cbOidTipoImpuesto", tipoImpuesto.toString());
		  } 
		  if (rs.getValueAt(0, "OID_CANA") != null){
		  	
		  	Long canal = new Long(((BigDecimal)rs.getValueAt(0,"OID_CANA")).longValue());//13->l.OID_CANA, n12
		  	this.oidCanal=canal;
		  	traza("[cs]\n*IMPPRTANTE **OID_CANA " +canal);
		  	asignar("VAR", "cbOidCanal", canal.toString());
		  }
		  if (rs.getValueAt(0, "OID_ACCE") != null){
		  	traza("[cs]\nOID_ACCE");
		  	Long acceso = new Long(((BigDecimal)rs.getValueAt(0,"OID_ACCE")).longValue()); //14->a.OID_ACCE, n12
		  	this.oidAcceso=acceso;
		  	asignar("VAR", "cbOidAcceso", acceso.toString());
		  	traza("[cs]\n acceso" + acceso );
		  }
		  if (rs.getValueAt(0, "SBAC_OID_SBAC") != null){
		  	traza("[cs]\nSBAC_OID_SBAC");
		  	Long subAcceso = new Long(((BigDecimal)rs.getValueAt(0,"SBAC_OID_SBAC")).longValue()); //15->r.SBAC_OID_SBAC,   n12 
		  	asignar("VAR", "cbOidSubAcceso", subAcceso.toString());
		  	traza("[cs]\n subAcceso" + subAcceso );
		  }
		  if (rs.getValueAt(0, "TIDO_OID_TIPO_DOCU") != null){
		  	traza("[cs]\nTIDO_OID_TIPO_DOCU\n");
		 	Long tipoDocumentoLegal = new Long(((BigDecimal)rs.getValueAt(0,"TIDO_OID_TIPO_DOCU")).longValue());//17->r.TIDO_OID_TIPO_DOCU, //ojo no estoy seguron12
		 	//Long tipoDocumentoLegal = new Long(((BigDecimal)rs.getValueAt(0,"TAIM_OID_TASA_IMPU")).longValue());//2 ->BEL7739
		  	asignar("VAR", "cbOidTipoDocumentoLegal", tipoDocumentoLegal.toString());
		  	traza("[cs]\n tipoDocumentoLegal" + tipoDocumentoLegal );
		  }
		  if (rs.getValueAt(0, "TIDO_TIPO_DOCU_REFE") != null){
		  	traza("[cs]\nTIDO_TIPO_DOCU_REFE\n");
		  	Long tipoDocumentoRef = new Long(((BigDecimal)rs.getValueAt(0,"TIDO_TIPO_DOCU_REFE")).longValue());//23->r.TIDO_TIPO_DOCU_REFE, 
		  	//Long tipoDocumentoRef = new Long(((BigDecimal)rs.getValueAt(0,"TAIM_OID_TASA_IMPU")).longValue());//2 ->BEL7739
		  	asignar("VAR", "cbOidTipoDocumentoRef", tipoDocumentoRef.toString());
		  	traza("[cs]\n tipoDocumentoRef" + tipoDocumentoRef );
		  }
		  if (rs.getValueAt(0, "COD_CLIE") != null){
		  	traza("[cs]\nCOD_CLIE\n");
		  	String CodigoCliente = (String)rs.getValueAt(0,"COD_CLIE");//5 ->c.COD_CLIE, var
		  	asignarAtributoElemento("txtCodCliente", "valor", CodigoCliente );
		  }
		  if (rs.getValueAt(0, "FEC_EMIS") != null){
		  	
		 	 Date fechaEmision = (Date) rs.getValueAt(0,"FEC_EMIS");//3 ->r.FEC_EMIS,
		 	 traza("[cs]FEC_EMIS\n" + fechaEmision);
		 	
		 	String formatoFecha = UtilidadesSession.getFormatoFecha(this);
		 	String fechaStringD = UtilidadesBelcorp.fechaFormateada(fechaEmision, formatoFecha); 
		 	
		 	
			 /*  2-. Para el formateo de una fecha Date a String para mostrarla en pantalla se debe usar 
una funcion en la clase UtilidadesBelcorp que permite realizar el formateo de una fecha
usando los formatos que son los disponibles en SICC.
    public static String fechaFormateada(Date fecha, String formato)

Como cadena de formato que debemos pasarle a estos dos métodos debe ser la que se encuentra en sesión, 
la obtendremos llamando al siguiente método:
UtilidadesSession.getFormatoFecha(this)
*/
			 /*String formatoFecha = UtilidadesSession.getFormatoFecha(this); 
String textFechaImputacionProceso = UtilidadesBelcorp.fechaFormateada(new Date(), formatoFecha); 

			 */
			
			 traza("[cs]fechaStringD" + fechaStringD);
			 traza("[cs]formatoFecha" + formatoFecha);
			
		 	 asignarAtributoElemento("txtFechaEmision", "valor", fechaStringD);
		  }
	
		 if (rs.getValueAt(0, "VAL_NOM1") != null){
		 	traza("[cs]VAL_NOM1\n");   
 		  	String nombre1 = (String)rs.getValueAt(0,"VAL_NOM1");//6 ->c.VAL_NOM1, 
 		  	 asignarAtributoElemento("txtNombre1","valor", nombre1 );
 		 }
		 if (rs.getValueAt(0, "VAL_NOM2") != null){
		 	traza("[cs]VAL_NOM2\n");
		  	String nombre2 = (String)rs.getValueAt(0,"VAL_NOM2");//7 ->c.VAL_NOM2,
		  	  asignarAtributoElemento("txtNombre2","valor", nombre2 ); 
		 }
		 if (rs.getValueAt(0, "VAL_APE1") != null){
		 	traza("[cs]VAL_APE1\n");
		  	String ape1 = (String)rs.getValueAt(0,"VAL_APE1");//8 ->c.VAL_APE1,
		  	asignarAtributoElemento("txtApellido1","valor", ape1 );   
		 }
		 if (rs.getValueAt(0, "VAL_APE2") != null){
		 	traza("[cs]VAL_APE2\n");
		  	String ape2 = (String)rs.getValueAt(0,"VAL_APE2");//8.1--<<<<c.VAL_APE2,
		        asignarAtributoElemento("txtApellido2","valor", ape2 );
		 }
		  
		  if (rs.getValueAt(0, "VAL_BASE_IMPO") != null){
		  	traza("[cs]VAL_BASE_IMPO\n");
		  	//Double baseImponible = new Double(((BigDecimal)rs.getValueAt(0,"VAL_BASE_IMPO")).doubleValue()); //9 ->r.VAL_BASE_IMPO, 
		  	BigDecimal baseImponible = ((BigDecimal)rs.getValueAt(0,"VAL_BASE_IMPO")); //9 ->r.VAL_BASE_IMPO, 
		  	asignarAtributoElemento("txtBaseImponible","valor", baseImponible.toString() );
		  	asignar("VAR", "baseSinFormato", baseImponible.toString());
		  	//set(FORMULARIO+'.baseSinFormato',base);
			
			

     
		  }
		  if (rs.getValueAt(0, "IMP_IMPU") != null){
		  	traza("[cs]IMP_IMPU\n");
		  	//Double importeImpuesto = new Double(((BigDecimal)rs.getValueAt(0,"IMP_IMPU")).doubleValue());//10->r.IMP_IMPU,  
		  	BigDecimal importeImpuesto = ((BigDecimal)rs.getValueAt(0,"IMP_IMPU"));//10->r.IMP_IMPU,  
		  	asignarAtributoElemento("txtImporteImpuesto","valor", importeImpuesto.toString() );
		  	asignar("VAR", "importeSinFormato", importeImpuesto.toString());
		  	//set(FORMULARIO+'.importeSinFormato',importe);
		  }
		  
		  if (rs.getValueAt(0, "IMP_TOTA") != null){
		traza("[cs]IMP_TOTA\n");
		  	//Double importeTotal = new Double(((BigDecimal)rs.getValueAt(0,"IMP_TOTA")).doubleValue());//11->r.IMP_TOTA,   
		  	BigDecimal importeTotal = ((BigDecimal)rs.getValueAt(0,"IMP_TOTA"));//11->r.IMP_TOTA,   
		  	asignarAtributoElemento("lbldtImporteTotal","valor", importeTotal.toString() );
		  	asignar("VAR", "totalSinFormato", importeTotal.toString());
		  //set(FORMULARIO+'.totalSinFormato',total);
		  
		  }
		  if (rs.getValueAt(0, "VAL_TASA_IMPU") != null){
			traza("[cs]VAL_TASA_IMPU\n");
		  	Float coeficienteImpuesto = new Float(((BigDecimal)rs.getValueAt(0,"VAL_TASA_IMPU")).floatValue()); //BEL7739 
		 	asignarAtributoElemento("lbldtCoeficienteImpuesto","valor", coeficienteImpuesto.toString());
		 	traza("[cs]VAL_TASA_IMPU:" + coeficienteImpuesto.toString());
		 	//String coeficienteString = conectorParametroLimpia("lbldtCoeficienteImpuesto","", true);
		 	asignar("VAR", "coeficienteImp", coeficienteImpuesto.toString());
		 	
		 	
		  }
		  
		  if (rs.getValueAt(0, "VAL_PUNT_EMIS") != null){
		  	traza("[cs]VAL_PUNT_EMIS\n");
		  	String puntoEmision = (String) rs.getValueAt(0,"VAL_PUNT_EMIS");//16->r.VAL_PUNT_EMIS,
		  	asignarAtributoElemento("txtPuntoEmision","valor", puntoEmision );
                  
		  }
		  if (rs.getValueAt(0, "VAL_SERI_DOCU_LEGA") != null){
		  	traza("[cs]VAL_SERI_DOCU_LEGA\n");
			String serieDocumentoLegal = (String)rs.getValueAt(0,"VAL_SERI_DOCU_LEGA");//18->r.VAL_SERI_DOCU_LEGA, 
		  	  asignarAtributoElemento("txtSerieDocLegal","valor", serieDocumentoLegal );
		  }
		  if (rs.getValueAt(0, "VAL_NUME_DOCU_LEGA") != null){
		  	traza("[cs]VAL_NUME_DOCU_LEGA\n");
		  	Long  numeroDocumentoLegal = new Long(((BigDecimal)rs.getValueAt(0,"VAL_NUME_DOCU_LEGA")).longValue());///19->r.VAL_NUME_DOCU_LEGA,                                  , 
		  	 asignarAtributoElemento("txtNumDocLegal","valor", numeroDocumentoLegal.toString());
		  }
		  if (rs.getValueAt(0, "VAL_NUME_IDEN_FISC") != null){
		  	traza("[cs]VAL_NUME_IDEN_FISC\n");
		  	String numeroIdentFiscal = (String)rs.getValueAt(0,"VAL_NUME_IDEN_FISC");//20->r.VAL_NUME_IDEN_FISC,
		  	asignarAtributoElemento("txtNumIdentificaionFiscal","valor", numeroIdentFiscal );
    		  } 
		  if (rs.getValueAt(0, "VAL_NUME_IDEN_NNAL") != null){
		  	traza("[cs]VAL_NUME_IDEN_NNAL\n");
		  	String numeroIdentNacional =(String) rs.getValueAt(0,"VAL_NUME_IDEN_NNAL");//21->r.VAL_NUME_IDEN_NNAL,
		  	 asignarAtributoElemento("txtNumIdentificaionNacional","valor", numeroIdentNacional );
		  } 
		  if (rs.getValueAt(0, "VAL_SERI_DOCU_REFE") != null){
		  	traza("[cs]VAL_SERI_DOCU_REFE\n");
		  	String serieDocReferencia = (String)rs.getValueAt(0,"VAL_SERI_DOCU_REFE");//24->r.VAL_SERI_DOCU_REFE,
		  	asignarAtributoElemento("txtSerieDocReferencia","valor", serieDocReferencia );
		  }
		  if (rs.getValueAt(0, "VAL_NUME_DOCU_REFE") != null){
		  	traza("[cs]VAL_NUME_DOCU_REFE\n");
		  	Long numeroDocReferencia = new Long(((BigDecimal)rs.getValueAt(0,"VAL_NUME_DOCU_REFE")).longValue()); //25->r.VAL_NUME_DOCU_REFE, 
		  	 asignarAtributoElemento("txtNumDocReferencia","valor", numeroDocReferencia.toString());
		  }
		  if(rs.getValueAt(0, "VAL_DESC") != null){
			traza("[cs]VAL_DESC\n");			
			BigDecimal descuento = ((BigDecimal)rs.getValueAt(0,"VAL_DESC"));
			asignarAtributoElemento("txtDescuento","valor", descuento.toString());
			asignar("VAR", "descuentoSinFormato", descuento.toString());
		  }
		  if (rs.getValueAt(0, "VAL_BASE_IMPO_NETO") != null){
		  	traza("[cs]VAL_BASE_IMPO_NETO\n");
		  	//Double baseImponible = new Double(((BigDecimal)rs.getValueAt(0,"VAL_BASE_IMPO")).doubleValue()); //9 ->r.VAL_BASE_IMPO, 
		  	BigDecimal baseImponibleNeto = ((BigDecimal)rs.getValueAt(0,"VAL_BASE_IMPO_NETO")); //9 ->r.VAL_BASE_IMPO, 
		  	asignarAtributoElemento("txtBaseImponibleNeto","valor", baseImponibleNeto.toString() );
		  	asignar("VAR", "baseSinFormato", baseImponibleNeto.toString());
		  	//set(FORMULARIO+'.baseSinFormato',base);
		  }	
                           
		  if (rs.getValueAt(0, "IND_ESTA") != null){
		  	traza("[cs]IND_ESTA\n");
				int estadoAnul = (((BigDecimal)rs.getValueAt(0,"IND_ESTA")).intValue());//26->r.IND_ESTA,                                            
				if(estadoAnul==1){
					Boolean estadoAnulado=new Boolean(true);
					if(estadoAnulado.booleanValue()){
				              asignarAtributo("CHECKBOX","ckEstadoAnulado","check","S");
					}else{
                              			asignarAtributo("CHECKBOX","ckEstadoAnulado","check","N");
					}
				}
		  }
		 
		  if (rs.getValueAt(0, "IND_TRAN_GRAT") != null){
		  	traza("[cs]IND_TRAN_GRAT\n");
				int  indicadorTransfG =(((BigDecimal)rs.getValueAt(0,"IND_TRAN_GRAT")).intValue());//7->r.IND_TRAN_GRAT, 
				if(indicadorTransfG==1){
					Boolean indicadorTransferenciaG= new Boolean(true);
					if (indicadorTransferenciaG.booleanValue()){
                                    		asignarAtributo("CHECKBOX","ckIndicadorTransferenciaGratuita","check","S");
                    			 }else{
                                    		asignarAtributo("CHECKBOX","ckIndicadorTransferenciaGratuita","check","N");
					 }
		  		}
		  }
		  if (rs.getValueAt(0, "VAL_INDI_RUV") != null){
		  	traza("[cs]VAL_INDI_RUV\n");
		  	String estadoRUV = (String)rs.getValueAt(0,"VAL_INDI_RUV");//28->r.VAL_INDI_RUV
		  	asignarAtributoElemento("lbldtEstadoRUV", "valor" , estadoRUV);
		  	asignar("VAR","estadoRUV", estadoRUV);
		  }
		  
		  //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
		  if (rs.getValueAt(0, "TDOC_OID_TIPO_DOCU") != null){
		  	traza("[cs]\nTDOC_OID_TIPO_DOCU\n");
		 	Long tipoDocumentoSigla = new Long(((BigDecimal)rs.getValueAt(0,"TDOC_OID_TIPO_DOCU")).longValue());
		  	asignar("VAR", "cbOidTipoDocumentoSigla", tipoDocumentoSigla.toString());
		  	traza("[cs]\n tipoDocumentoSigla" + tipoDocumentoSigla );
		  }
		  if (rs.getValueAt(0, "FEC_EMIS_REFE") != null){ 
		  	
		 	 Date fechaEmisionRefe = (Date) rs.getValueAt(0,"FEC_EMIS_REFE");
		 	 traza("[cs]FEC_EMIS_REFE\n" + fechaEmisionRefe);
		 	
		 	String formatoFecha = UtilidadesSession.getFormatoFecha(this);
		 	String fechaStringDRef = UtilidadesBelcorp.fechaFormateada(fechaEmisionRefe, formatoFecha); 
		 	
			 traza("[cs]fechaStringD" + fechaStringDRef);
			 traza("[cs]formatoFecha" + formatoFecha);
			
		 	 asignarAtributoElemento("txtFechaEmisionReferencia", "valor", fechaStringDRef);
		  }
		  
	 
 //1 ->r.TAIM_OID_TASA_IMPU,//4 ->r.CLIE_OID_CLIE,//22->r.PAIS_OID_PAIS, 
  /*asignarAtributoElemento("txtCodTipoMovimiento","valor",dto.getCodigoMovimiento().toString());
    asignarAtributoElemento("txtCodMovimientoSAP","valor",dto.getCodigoMovimientoSAP().toString());
*/ 		
		traza("[cs][cs]antes cargarCombos cs]");
        	cargarCombos();//funcion que carga los combos de la pagina
        	//Sacamos el oid Seleccionado en al lista editable.

    		if(this.accion.equals("btn_detalle")){
			getConfiguracionMenu("LPPopup", "detalle");
			traza("[cs][cs] accion==btn_detalle ***");
			
			asignarAtributoElemento("ckIndicadorTransferenciaGratuita","disabled","S");
		     	asignarAtributoElemento("ckEstadoAnulado","disabled","S");
		     	asignarAtributoElemento("txtNumDocReferencia","disabled","S");
		     	asignarAtributoElemento("txtSerieDocReferencia","disabled","S");
		     	asignarAtributoElemento("txtNumIdentificaionNacional","disabled","S");
		    	asignarAtributoElemento("txtNumIdentificaionFiscal","disabled","S");
		     	asignarAtributoElemento("txtNumDocLegal","disabled","S");
		     	asignarAtributoElemento("txtSerieDocLegal","disabled","S");
		     	asignarAtributoElemento("txtPuntoEmision","disabled","S");                    	
		     	asignarAtributoElemento("txtImporteImpuesto","disabled","S");
		        asignarAtributoElemento("txtBaseImponible","disabled","S");
		     	asignarAtributoElemento("txtApellido2","disabled","S");
		        asignarAtributoElemento("txtApellido1","disabled","S");
		     	asignarAtributoElemento("txtNombre2","disabled","S");
		     	asignarAtributoElemento("txtNombre1","disabled","S");
		     	asignarAtributoElemento("txtCodCliente","disabled","S");
		     	asignarAtributoElemento("txtFechaEmision","disabled","S");
		     	asignarAtributoElemento("txtNombre1","disabled","S");
				asignarAtributoElemento("txtDescuento","disabled","S");
				asignarAtributoElemento("txtBaseImponibleNeto","disabled","S");
				asignarAtributoElemento("txtNumDocLegalFinal","disabled","S");

				//sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
				asignarAtributoElemento("txtFechaEmisionReferencia","disabled","S");
		     	 
		}	

    }catch ( Exception e ) {
                              logStackTrace(e);
                              lanzarPaginaError(e);
    }
           traza("[cs][cs]*** Salida - LPPopup - ejecucion ***");
          }
    private void cargarCombos() throws Exception{
    
    //funcion que carga los combos..
    traza("[cs][cs]cargarCombos  ENTRADA");
    	ComposerViewElementList listelem = new ComposerViewElementList();
 	ComposerViewElement empresa = new ComposerViewElement(); 
 	ComposerViewElement tipoImpuestos = new ComposerViewElement();
 	ComposerViewElement canal = new ComposerViewElement();
 	ComposerViewElement acceso = new ComposerViewElement();
 	ComposerViewElement subAcceso = new ComposerViewElement();
 	ComposerViewElement tipoDocumentoLegal = new ComposerViewElement();
 	ComposerViewElement tipoDocumentoLegalReferencia = new ComposerViewElement();
 	
 	//sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
 	ComposerViewElement tipoDocumentoSigla = new ComposerViewElement(); 
 	
 	
 	DTOBelcorp dto = new DTOBelcorp();
 	dto.setOidPais(this.pais);
 	dto.setOidIdioma(this.idioma);
 	
 	empresa.setIDBusiness("SEGObtenerEmpresasPorPais");
 	empresa.setDTOE(dto);
	traza("Elemento empresa");
	listelem.addViewElement(empresa);

 	tipoImpuestos.setIDBusiness("CCCObtenerTasasImpuestoPorPais");
 	tipoImpuestos.setDTOE(dto);
	traza("Elemento tipo impuestos");
	listelem.addViewElement(tipoImpuestos);

	canal.setIDBusiness("SEGConsultaCanales");
 	canal.setDTOE(dto);
	traza("Elemento canales");
	listelem.addViewElement(canal);
	
	tipoDocumentoLegal.setIDBusiness("FACObtenerTiposDocumentoLegal");
	//tipoDocumentoLegal.setIDBusiness("CCCObtenerTasasImpuestoPorPais");
 	tipoDocumentoLegal.setDTOE(dto);
	traza("Elemento tipo documento legal");
	listelem.addViewElement(tipoDocumentoLegal);

	//sapaza -- PER-SiCC-2010-0487 -- 16/08/2010    
    tipoDocumentoSigla.setIDBusiness("MAEObtenerTiposDocumentoPorSigla");
    tipoDocumentoSigla.setDTOE(dto);
    traza("Elemento tipo documento sigla");
    listelem.addViewElement(tipoDocumentoSigla);
    
	// CANAL CON DTOAccesosPorCanal

	// DBLG700000069 (7) - gPineda - 03/10/06
	if( this.oidCanal != null ){
		DTOAccesosPorCanal dtoacceso = new DTOAccesosPorCanal();
		dtoacceso.setOidPais(this.pais);
		dtoacceso.setOidIdioma(this.idioma);
		dtoacceso.setOidCanal(this.oidCanal);
		
		traza("**IMPORTANTE Elemento this.oidCanal= " + this.oidCanal);
		acceso.setIDBusiness("SEGObtenerAccesosPorCanal");
		acceso.setDTOE(dtoacceso);
		traza("Elemento acceso");
		listelem.addViewElement(acceso);

		DTOOID dtooid = new DTOOID();
		dtooid.setOidPais(this.pais);
		dtooid.setOidIdioma(this.idioma);
		dtooid.setOid(this.oidAcceso);
		traza("**IMPORTANTE Elemento this.oidAcceso= " + this.oidAcceso);
		traza("**dtooid=  " + dtooid);
		subAcceso.setIDBusiness("SegObtenerSubaccesosPorAcceso");
		subAcceso.setDTOE(dtooid);
		traza("Elemento subacceso");
		listelem.addViewElement(subAcceso);
	}
	
 	//tipoDocumentoLegalReferencia.setIDBusiness("FACObtenerTiposDocumentoLegal");
 	//tipoDocumentoLegalReferencia.setDTOE(dto);
	//traza("Elemento tipo documento referencia");
	//listelem.addViewElement(tipoDocumentoLegalReferencia);

 	//Se llama al subsistema GestorCargaPantalla. 
 	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
 	traza("conector creado");
 	
 	conector.ejecucion();
 	traza("ejecutado");
 	DruidaConector conConsultar = conector.getConector();
 	traza("Obtener conConsultar");
	
	traza("\nConector: " , conConsultar);
	
 	asignar("COMBO","cbEmpresa", conConsultar,"SEGObtenerEmpresasPorPais");
 	
 	traza("Combo empresa asignado");
	asignar("COMBO","cbTipoImpuesto", conConsultar,"CCCObtenerTasasImpuestoPorPais");
	traza("Combo tipoImpuesto asignado");	
	asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales");
	traza("Combo canal asignado");			
	// DBLG700000069 (7) - gPineda - 03/10/06
	if( this.oidCanal != null ){
		asignar("COMBO","cbAcceso", conConsultar,"SEGObtenerAccesosPorCanal");				
		asignar("COMBO","cbSubacceso", conConsultar,"SegObtenerSubaccesosPorAcceso");
	}
 	asignar("COMBO","cbTipoDocLegal", conConsultar,"FACObtenerTiposDocumentoLegal");
 	//asignar("COMBO","cbTipoDocLegal", conConsultar,"CCCObtenerTasasImpuestoPorPais");
 	traza("Combo tipoDocLegal asignado");
	asignar("COMBO","cbTipoDocLegalReferencia", conConsultar,"FACObtenerTiposDocumentoLegal");	
	//asignar("COMBO","cbTipoDocLegalReferencia", conConsultar,"CCCObtenerTasasImpuestoPorPais");			
	traza("Combo tipoDocLegalRef asignado");

	//sapaza -- PER-SiCC-2010-0487 -- 16/08/2010    
    asignar("COMBO","cbTipoDocSigla", conConsultar,"MAEObtenerTiposDocumentoPorSigla");	
    traza("Combo cbTipoDocSigla asignado");

	traza("[cs][cs]asignado cbTipoDocLegalReferencia");	
   traza("[cs][cs]cargarCombos  SALIDA");
    }

    private void logStackTrace(Throwable e) throws Exception {
                    traza("[cs][cs]Se produjo la excepcion: " + e.getMessage());
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    e.printStackTrace(ps);
                    
                    traza("[cs][cs]Stack Trace: " + baos.toString());
     }
	/* FALTA LOS DOS PRIMERO, POR SI ACASO. 
asignarAtributoElemento("txtNombre1","valor", nombre1 );
     asignarAtributoElemento("txtNombre2","valor", nombre2 );
     asignarAtributoElemento("txtApellido1","valor", ape1 );
     asignarAtributoElemento("txtApellido2","valor", ape2 );
     asignarAtributoElemento("txtBaseImponible","valor", baseImponible );
     asignarAtributoElemento("txtImporteImpuesto","valor", importeImpuesto );
     asignarAtributoElemento("txtPuntoEmision","valor", puntoEmision );
     asignarAtributoElemento("txtSerieDocLegal","valor", serieDocumentoLegal );
     asignarAtributoElemento("txtNumDocLegal","valor", numeroDocumentoLegal );
     asignarAtributoElemento("txtNumIdentificaionFiscal","valor", numeroIdentFiscal );
     asignarAtributoElemento("txtNumIdentificaionNacional","valor", numeroIdentNacional );
     asignarAtributoElemento("txtSerieDocReferencia","valor", serieDocReferencia );
     asignarAtributoElemento("txtNumDocReferencia","valor", numeroDocReferencia );*/


	/*
	asignarAtributoElemento("ckIndicadorTransferenciaGratuita","disabled","S");
     	asignarAtributoElemento("ckEstadoAnulado","disabled","S");
     	asignarAtributoElemento("txtNumDocReferencia","disabled","S");
     	asignarAtributoElemento("txtSerieDocReferencia","disabled","S");
     	asignarAtributoElemento("txtNumIdentificaionNacional","disabled","S");
    	asignarAtributoElemento("txtNumIdentificaionFiscal","disabled","S");
     	asignarAtributoElemento("txtNumDocLegal","disabled","S");
     	asignarAtributoElemento("txtSerieDocLegal","disabled","S");
     	asignarAtributoElemento("txtPuntoEmision","disabled","S");                    	
     	asignarAtributoElemento("txtImporteImpuesto","disabled","S");
        asignarAtributoElemento("txtBaseImponible","disabled","S");
     	asignarAtributoElemento("txtApellido2","disabled","S");
        asignarAtributoElemento("txtApellido1","disabled","S");
     	asignarAtributoElemento("txtNombre2","disabled","S");
     	asignarAtributoElemento("txtNombre1","disabled","S");
     	asignarAtributoElemento("txtCodCliente","disabled","S");
     	asignarAtributoElemento("txtFechaEmision","disabled","S");
     	asignarAtributoElemento("txtNombre1","disabled","S");
     	
     	
     	*/


}		//lP