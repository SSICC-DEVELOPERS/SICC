/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    INDRA/CCC/PROY
    $Id: LPEnviarMovimientosAlmacenDiarios.java,v 1.1 2009/12/03 18:34:30 pecbazalar Exp $
    DESC
 */
 
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOINTEnviarMovimientos;
 
 public class LPEnviarMovimientosAlmacenDiarios extends LPSICCBase {
	private String accion= null;
	private Long pais;
	private Long idioma;
	
	public LPEnviarMovimientosAlmacenDiarios() { super(); }
	
	public void inicio() throws Exception {
		pagina("contenido_movimientos_almacen_diarios_enviar");
	    this.getFormatosValidaciones();
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPEnviarMovimientosAlmacenDiarios - ejecucion ***");         
		
		this.accion = conectorParametroLimpia("accion", "", true);
		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);
		
		traza("** Accion: "+this.accion+" ** Idioma: "+this.idioma+" ** Pais: "+this.pais);
		
		asignarAtributo("PAGINA","contenido_movimientos_almacen_diarios_enviar", "cod", "0258");
		asignarAtributo("PAGINA","contenido_movimientos_almacen_diarios_enviar", 
			"msgle", "Enviar movimientos de almacén diarios");

		getConfiguracionMenu("LPEnviarMovimientosAlmacenDiarios","");
		try{				
			if (accion.equals("")){
				traza("Antes de llamar a accionVacia");
				accionVacia();
			}
			if (accion.equals("enviar")){
				traza("accionEnviar");
				accionEnviar();
			}
		}
		catch(Exception  e){
			traza("ERROR: " + e);
			e.printStackTrace();
			lanzarPaginaError(e);  
		}
		traza("*** Salida - LPEnviarMovimientosAlmacenDiarios - ejecucion ***");         
	}
	
	private void accionVacia() throws Exception{
		traza("*** Entrada - LPEnviarMovimientosAlmacenDiarios.accionVacia - ejecucion ***");
		/*
		obtenerDatosIniciales() 
		Creamos un DTOString con la constante IGestorInterfaces.COD_INTERFAZ_SAM7 (además del pais y el idioma) 
		Llamamos al ConectorObjeto con el idBusiness "INTCargaInicialInterfaz" y el dto. 
		Con el DTOCargaInicialInterfaz obtenido cargamos los campos txtNumeroLote y txtObservaciones con los atributos numeroLote e observaciones 		
		*/
		
		//con esto cargamos los combos
		obtenerDatosIniciales();
		
		DTOCargaInicialInterfaz dtoSalida=null;
		Vector paramConector = new Vector();
		DTOString dto = new DTOString();
		
		dto.setCadena(IGestorInterfaces.COD_INTERFAZ_SAM7);
		traza("COD_INTERFAZ_SAM7: "+IGestorInterfaces.COD_INTERFAZ_SAM7);
		dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
              
        //Relleno los parametros de entrada para llamar al conector
		paramConector.add(dto);
		paramConector.add(new MareBusinessID("INTCargaInicialInterfaz"));

		traza("Antes de conectar en accion vacia");			
		DruidaConector conector = conectar("ConectorObjeto", paramConector);
		dtoSalida = (DTOCargaInicialInterfaz)conector.objeto("DTOSalida");
		traza ("DTOSALIDA: "+ dtoSalida);
		
		//Con el DTOCargaInicialInterfaz obtenido cargamos los campos txtNumeroLote y txtObservaciones con los atributos numeroLote e observaciones
		traza("***** Antes de rellenar campos");   
		traza("DTOSALIDA.getDescripcion: "+dtoSalida.getDescripcion());
		traza("DTOSALIDA.getNumeroLote: "+ dtoSalida.getNumeroLote());
		asignarAtributo("AREATEXTO","areatxtObservaciones","valor",dtoSalida.getDescripcion());          
		asignar("LABELC","lblvalorLote",dtoSalida.getNumeroLote().toString());
		asignar("VAR","numeroLote",dtoSalida.getNumeroLote().toString());
		    
		traza("*** Salida - LPEnviarMovimientosAlmacenDiarios.accionVacia - ejecucion ***");
	}
	
	/**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       11/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */   
	private void accionEnviar() throws Exception{
		traza("*** Entrada - LPEnviarMovimientosAlmacenDiarios.accionEnviar - ejecucion ***");
		
		pagina("salidaGenerica");
        asignarAtributo("VAR", "ejecutar", "valor", "ejecucionCorrecta()");		
		
		Vector paramConector = new Vector();
		DTOINTEnviarMovimientos dtoIntEnvMov = new DTOINTEnviarMovimientos();
		
		String observaciones = conectorParametroLimpia("areatxtObservaciones","",true);
        String canal = conectorParametroLimpia("cbCanal","",true);
        String acceso = conectorParametroLimpia("cbAcceso","",true);
		String subaccesos = conectorParametroLimpia("subaccesos","",true);
        String numeroLote = conectorParametroLimpia("numeroLote","",true);
		String tiposMovimiento = conectorParametroLimpia("tiposMovimiento","",true);
              
        traza("** observaciones: " + observaciones);
		traza("** canal: " + canal);
        traza("** acceso: " + acceso);
        traza("** subaccesos: " + subaccesos);
        traza("** numeroLote: " + numeroLote);
        traza("** tiposMovimiento: " + tiposMovimiento);
        traza("** pais: " + this.pais);
        traza("** idioma: " + this.idioma);

		if ((observaciones != null) && !(observaciones.equals(""))){
		  	dtoIntEnvMov.setObservaciones(observaciones);
        }

        if ((canal!=null) && !(canal.equals(""))){
	       	dtoIntEnvMov.setCanal(Long.valueOf(canal));
        }
    
		if ((acceso!=null) && !(acceso.equals(""))){
			dtoIntEnvMov.setAcceso(Long.valueOf(acceso));
        }
		//Modificado por cambios - Cristian Valenzuela - 22/9/2005
		ArrayList arrSubaccesos = new ArrayList();
		StringTokenizer stSub = new StringTokenizer(subaccesos, ",");
		int cant2 = stSub.countTokens();
		traza("****** cant2 " + cant2);

		while(stSub.hasMoreTokens()) {
			String elemento = stSub.nextToken();
			traza("*** elemento " + elemento);
			Long elem = new Long(elemento);
			arrSubaccesos.add(elem);
		}

		dtoIntEnvMov.setSubaccesos(arrSubaccesos);
		//Modificado por cambios - Cristian Valenzuela - 22/9/2005
        
		if ((numeroLote != null) && !(numeroLote.equals(""))){
			dtoIntEnvMov.setNumeroLote(numeroLote);
        }
		
		//Agregado por cambios - Cristian Valenzuela - 22/9/2005
		ArrayList arrTiposMovimientos = new ArrayList();
		StringTokenizer st1 = new StringTokenizer(tiposMovimiento, ",");
		int cant = st1.countTokens();
		traza("****** cant " + cant);

		while(st1.hasMoreTokens()) {
			String elemento = st1.nextToken();
			traza("*** elemento " + elemento);
			Long elem = new Long(elemento);
			arrTiposMovimientos.add(elem);
		}

		dtoIntEnvMov.setTipoMovimientos(arrTiposMovimientos);
		//Agregado por cambios - Cristian Valenzuela - 22/9/2005

		if (this.pais!=null){
			dtoIntEnvMov.setOidPais(this.pais);
        }

	    if (this.idioma!=null){
			dtoIntEnvMov.setOidIdioma(this.idioma);
        }
              
        paramConector.add(dtoIntEnvMov);
        paramConector.add(new MareBusinessID("INTEnviarMovimientosAlmacenDiariosBatch"));
        traza("dtoIntEnvMov " + dtoIntEnvMov);
        traza("ANTES CONECTOR AL ENVIAR");
        DruidaConector conector = conectar("ConectorEnviarMovimientosAlmacenDiariosBatch", paramConector);
		traza("*** Salida - LPEnviarMovimientosAlmacenDiarios.accionEnviar - ejecucion ***");
	}

	/**	
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       11/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */   
	private void obtenerDatosIniciales() throws Exception{
		traza("*** Entrada - LPEnviarMovimientosAlmacenDiarios.obtenerDatosIniciales - ejecucion ***");		
	
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "pais", pais.toString());
		
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(this.pais);
        dto.setOidIdioma(this.idioma);

        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = null;
               
		elem=new ComposerViewElement(); 
		elem.setIDBusiness("SEGConsultaCanales");
		elem.setDTOE(dto);
		listelem.addViewElement(elem);

		//Se agrega el ID para la carga del combo tipo movimientos
		elem=new ComposerViewElement(); 
		elem.setIDBusiness("BELObtenerTiposMovimientosAlmacenIndicadorSAP");
		elem.setDTOE(dto);
		listelem.addViewElement(elem);
		//Se agrega el ID para la carga del combo tipo movimientos
		
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();
		
		asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales");
		asignar("COMBO", "cbTipoMovimiento", conConsultar, "BELObtenerTiposMovimientosAlmacenIndicadorSAP");
		
		traza("*** Salida - LPEnviarMovimientosAlmacenDiarios.obtenerDatosIniciales - ejecucion ***");
	}  
}