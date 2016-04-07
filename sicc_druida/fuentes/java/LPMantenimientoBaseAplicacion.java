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

//import LPSICCBase; 
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.*;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.dtos.dto.DTOParametroMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacionDetalle;
import es.indra.sicc.dtos.dto.DTOEBaseAplicacionDetalle;
import es.indra.sicc.dtos.dto.DTOEBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOEscalon;
import es.indra.sicc.dtos.dto.DTOListaBasesAplicacionDto;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento;
import es.indra.sicc.dtos.dto.DTOProductoDTO;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector; 
import java.util.StringTokenizer; 
import java.math.BigDecimal;
 
 /**
  * Sistema:             Belcorp - SICC
  * Modulo:              DTO - Descuentos
  * Componente:          LPMantenimientoBaseAplicacion
  * Fecha:               06/07/2004
  * Dcoumentacion:       
  *                      documentos: SICC-DMCO-DTO-201-324
  * Observaciones:
  * @version             3.0
  * @author              Cintia Verónica Argain
  */
public class LPMantenimientoBaseAplicacion extends LPDescuentos {
	private Long lIdioma = null;
    private Long lPais = null;
	private DTOGlobalDescuento dtoDescuento = null;
    public DTODatosMatrizDescuentos  dtoMatrizDescuento = new DTODatosMatrizDescuentos();
 
    public LPMantenimientoBaseAplicacion() { super(); }
 
    public void inicio() throws Exception {
		pagina("contenido_base_aplicacion_crear");
        this.getFormatosValidaciones();         
    }
 
    public void ejecucion() throws Exception {
	    setTrazaFichero();
        traza("LPMantenimientoBaseAplicacion.ejecucion() - Entrada");

        accion = conectorParametroLimpia("accion", "", true);
        casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
        lPais = UtilidadesSession.getPais(this);
        lIdioma = UtilidadesSession.getIdioma(this);
        
		traza("****** accion: "+ accion);
		traza("****** casoDeUso: " + casoDeUso);		
	    traza("****** lPais: " + lPais);		
		traza("****** lIdioma: "+ lIdioma);

  	    asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
		asignarAtributo("VAR","accion","valor",accion);

        try {
	        if (accion.equals("")){       
				//Comienza configuracion del menu secundario
				if (casoDeUso.equals("consultar")){
            getConfiguracionMenu("LPMantenimientoBaseAplicacion","consultar");
            String modvig = (String)conectorParametroSesion("modificarVigente");
            if ("true".equals(modvig)) {            	
              asignarAtributoPagina("cod","0354");
            } else {
              asignarAtributoPagina("cod","0233");
            }
				}
				else if(casoDeUso.equals("insertar")) {
					getConfiguracionMenu("LPMantenimientoBaseAplicacion","insertar");
				} 
				else if(casoDeUso.equals("modificar")) {
					getConfiguracionMenu("LPMantenimientoBaseAplicacion","modificar");
					asignarAtributoPagina("cod","0354");                                                        
				}          		
				//Finaliza configuracion del menu secundario

				cargarPantalla();
            }
			else if (accion.equals("almacenar")){
				almacenar();
				redirigir();
			}
			else if (accion.equals("redirigir")){
				redirigir();
			}
            else if (accion.equals("guardarBaseAplicacion")){
				almacenar();
				guardar();
            }
			else if (accion.equals("otraBase")){
				otraBase();
            }
			else if (accion.equals("siguiente")){
				siguiente();
            }
            else if (accion.equals("aniadirEscala")){
				aniadirEscala();
            }
			
	        traza("LPMantenimientoBaseAplicacion.ejecucion() - Salida");
         }
		 catch(Exception ex) {
              logStackTrace(ex);
			  cargarPantalla();
             this.lanzarPaginaError(ex);
         }
     }

	 private void aniadirEscala() throws Exception {
		traza("LPMantenimientoBaseAplicacion.aniadirEscala() - Entrada");
		pagina("contenido_base_aplicacion_detalle");
	    this.getFormatosValidaciones();
		this.getConfiguracionMenu("LPMantenimientoBaseAplicacion","aniadirEscala");		
		traza("LPMantenimientoBaseAplicacion.aniadirEscala() - Salida");
	 }

	 private void inicializarArray(DTOSBaseAplicacion[] arrDTOSBase) throws Exception {
		traza("LPMantenimientoBaseAplicacion.inicializarArray() - Entrada");
		for(int i=0; i<arrDTOSBase.length; i++) {
			DTOSBaseAplicacion dtoTemp = arrDTOSBase[i];
			dtoTemp.setIndice(new Long(i+1));
		}

		for(int i=0; i<arrDTOSBase.length; i++) {
			DTOSBaseAplicacion dtoTemp = arrDTOSBase[i];
			traza("********* i:" + i);
			traza("********* DTOSBaseAplicacion " + dtoTemp);
		}
		
		traza("LPMantenimientoBaseAplicacion.inicializarArray() - Salida");
	 }

  /**
   * @author eiraola 21/11/2005 
   * @description  DMCO-DTO-BELC300014763  
   * * @throws java.lang.Exception
   */
	public void cargarPantalla() throws Exception {
		traza("LPMantenimientoBaseAplicacion.cargarPantalla() - Entrada");
        
        // Se obtiene el dtoDescuento de la caché de la LPDescuentos
		dtoDescuento = getDescuento();

		traza("DTOGlobalDescuento:     ****************");
        traza(dtoDescuento);

		cargaCombos();
		recuperaValoresConfiguracionMatrizDescuento();

        DTOListaBasesAplicacionDto dtoLista = null;
        DTOSBaseAplicacion[] arrDTOSBase = new DTOSBaseAplicacion[0];
        DTOSBaseAplicacion dtoBaseAplicDTO = null;

        if (dtoDescuento != null) {
            dtoLista = dtoDescuento.getBasesAplicacion();
            traza("******** DTOListaBasesAplicacionDto " + dtoLista);
        }
        if (dtoLista != null) {
            arrDTOSBase = dtoLista.getBasesAplicacion();
            traza("******** arrDTOSBase[]" + arrDTOSBase);
        }
        int cantBasesAplicacion = arrDTOSBase.length;
        traza("******** la cantidad de Bases de Aplicacion es_" + cantBasesAplicacion);
        
        if (cantBasesAplicacion > 0) {
            inicializarArray(arrDTOSBase);
            dtoBaseAplicDTO = arrDTOSBase[0];
            traza("******** DTOSBaseAplicacion (el elemento [0]) " + dtoBaseAplicDTO);

            //Este metodo carga:
			//1- valores seleccionados en los combos
			//2- lista Productos 
			//3- lista Criterios seleccionados
			//4- valor en N° unidades obligatorias
			cargaListaCriterios(dtoBaseAplicDTO);

            //Este metodo carga:
			//1 - lista Definicion de escalas
			cargaListaCriteriosEscalas(dtoBaseAplicDTO);

            if ((casoDeUso.equals("modificar"))||(casoDeUso.equals("consultar"))) {
                traza("Entro por modificar o consultar");
                if (dtoBaseAplicDTO.getOidBase()!=null) {
					asignarAtributo("VAR","hidOidBase","valor", dtoBaseAplicDTO.getOidBase().toString());			
				}
				if(dtoBaseAplicDTO.getOidDescuento()!=null) {
					asignarAtributo("VAR","hidOidDescuento","valor", dtoBaseAplicDTO.getOidDescuento().toString());
				}

                asignarAtributo("VAR","posicion","valor","0");
                asignarAtributo("VAR","longitud","valor", String.valueOf(cantBasesAplicacion));  // DBLG500001127

            }

            if ((casoDeUso.equals("modificar"))||(casoDeUso.equals("insertar"))) {
                traza("Entro por modificar o insertar");
                if(dtoBaseAplicDTO.getOidBase()!=null) {
				    asignarAtributo("VAR","hidOidBase","valor", dtoBaseAplicDTO.getOidBase().toString());	
				}		

				if(dtoBaseAplicDTO.getIndice()!=null) {
				    asignarAtributo("VAR","indiceBase","valor", dtoBaseAplicDTO.getIndice().toString());
				}

            }

        }
   		
		setDescuento(dtoDescuento);
		traza("LPMantenimientoBaseAplicacion.cargarPantalla() - Salida");
	 }

	 private ArrayList aplanarProductos(String sDetalleProductos) throws Exception{
		traza("LPMantenimientoBaseCalculo.aplanarProductos() - Entrada");
		traza("************** sDetalleProductos :" + sDetalleProductos);

   	    StringTokenizer stRows = new StringTokenizer(sDetalleProductos, "$");

        int rowCount = stRows.countTokens();
        ArrayList productos = new ArrayList();
        
        for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
			DTOProductoDTO dtoProducto = new DTOProductoDTO();
		
            StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");

			for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
				StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				
					
				for(int contad =  0 ;stCols.hasMoreTokens(); contad++){								
					String desc = stCols.nextToken().toString();
                    String valor = stCols.nextToken().toString();

					traza(desc + " " + valor);                    

	                if(desc.equals("oid"))
						dtoProducto.setOidProducto(Long.valueOf(valor));
	                if(desc.equals("codigosap"))											
						dtoProducto.setCodigoSAP(new String(valor));
				    if(desc.equals("descripcion"))
						dtoProducto.setDescripcion(new String(valor));
			    }
			}

            traza("*********** dtoProducto " + dtoProducto);
            productos.add(dtoProducto);
        }

 		traza("LPMantenimientoBaseCalculo.aplanarProductos() - Salida");
		return productos;
	 }

	 public void almacenar() throws Exception {
		traza("LPMantenimientoBaseAplicacion.almacenar() - Entrada");
		dtoDescuento = getDescuento();
		boolean iguales = false;
		int pos = 0;
		int cant = 0;
		Long oidBaseAplicacion = null;
		Long lIndice = null;
		Integer numUnObl = null;

		String strIndice = conectorParametroLimpia("indiceBase", "", true);
		traza("***** strIndice " + strIndice);
		if(!strIndice.equals("")) lIndice = new Long(strIndice);

		String strBaseAplicacion = conectorParametroLimpia("hidOidBase", "", true);
		traza("***** strBaseAplicacion " + strBaseAplicacion);

		String strNumUnOblig = conectorParametroLimpia("txtNumUnidadesObligatorias", "", true);
		traza("***** strNumUnOblig " + strNumUnOblig);

		if(!strNumUnOblig.equals("")) {
			numUnObl = new Integer(strNumUnOblig);		
		}

		if(!strBaseAplicacion.equals("")) {
			oidBaseAplicacion = new Long(strBaseAplicacion);		
		}

		traza("***** iguales " + iguales);		
		traza("***** pos " + pos);		
		
		String sDetalleCriterios = 
		conectorParametro("hidDetalleCriterios")==null?"":conectorParametro("hidDetalleCriterios");
		traza("*************** sDetalleCriterios " + sDetalleCriterios);
			 
		String sDetalleCriterios2 = 
		conectorParametro("hidDetalleCriterios2")==null?"":conectorParametro("hidDetalleCriterios2");
		traza("*************** sDetalleCriterios2 " + sDetalleCriterios2);

		String sDetalleProductos = 
		conectorParametro("hidDetalleProductos")==null?"":conectorParametro("hidDetalleProductos");
		traza("*************** sDetalleProductos " + sDetalleProductos);
			
		ArrayList aDetalleCriterio = aplanarCriterios(sDetalleCriterios);
		ArrayList aDetalleCriterio2 = aplanarCriterios2(sDetalleCriterios2);
		ArrayList aDetalleProductos = aplanarProductos(sDetalleProductos);

		if(dtoDescuento.getBasesAplicacion()!=null && 
			dtoDescuento.getBasesAplicacion().getBasesAplicacion()!=null) {
			traza("*********** Entro al if");
			DTOSBaseAplicacion[] arrDtosActual = dtoDescuento.getBasesAplicacion().getBasesAplicacion();
			int cantArrayActual = arrDtosActual.length;
			traza("*********** cantArrayActual " + cantArrayActual);

			boolean existeBase = false;
			int posicion = 0;

			for(int i=0; i<cantArrayActual; i++) {
				DTOSBaseAplicacion dtoTemp = arrDtosActual[i];
				traza("********* dtoTemp.getIndice() " + dtoTemp.getIndice());
				traza("********* lIndice " + lIndice);

				if(dtoTemp.getIndice()!=null && lIndice!=null) {
					if(dtoTemp.getIndice().longValue()==lIndice.longValue()) {
						existeBase = true;
						posicion = i;
					}
				}
			}
			
			DTOSBaseAplicacion dtoTemp = new DTOSBaseAplicacion();
			dtoTemp.setNumeroUnidadesObligatorias(numUnObl);
			dtoTemp.setOidBase(oidBaseAplicacion);			
			dtoTemp.setOidIdioma(lIdioma);
			dtoTemp.setOidPais(lPais);

			dtoTemp.setDetalle(aDetalleCriterio);
			dtoTemp.setEscalones(aDetalleCriterio2);	
			dtoTemp.setProductos(aDetalleProductos);	
			traza("*************** DTOSBaseAplicacion " + dtoTemp);		
			
			traza("********* existeBase " + existeBase);

			if(existeBase==false) {
				DTOSBaseAplicacion[] arrDtosTemp = new DTOSBaseAplicacion[cantArrayActual + 1];
	
				for(int i=0; i<cantArrayActual; i++) {
					traza("******* Entro al for " + i);
					arrDtosTemp[i] = arrDtosActual[i];				
				}

				arrDtosTemp[cantArrayActual] = dtoTemp;
				dtoDescuento.getBasesAplicacion().setBasesAplicacion(arrDtosTemp);
			}
			else {
				DTOSBaseAplicacion[] arrDtosTemp = new DTOSBaseAplicacion[cantArrayActual];
	
				for(int i=0; i<cantArrayActual; i++) {
					traza("******* Entro al for " + i);
					arrDtosTemp[i] = arrDtosActual[i];				
				}

				arrDtosTemp[posicion] = dtoTemp;
				dtoDescuento.getBasesAplicacion().setBasesAplicacion(arrDtosTemp);
			}			
		}
		else {
			traza("*************** Entro al else");
			DTOListaBasesAplicacionDto dtoLista = new DTOListaBasesAplicacionDto();
	  	    DTOSBaseAplicacion[] arrDTOSBase = new DTOSBaseAplicacion[1];
			DTOSBaseAplicacion dtoTemp = new DTOSBaseAplicacion();

			dtoTemp.setDetalle(aDetalleCriterio);
			dtoTemp.setEscalones(aDetalleCriterio2);
			dtoTemp.setProductos(aDetalleProductos);
			dtoTemp.setIndice(new Long(1));

			arrDTOSBase[0] = dtoTemp;

			dtoLista.setBasesAplicacion(arrDTOSBase);
			dtoDescuento.setBasesAplicacion(dtoLista);
		}

		traza("***** se va del almacenar con longitud: " + 
		dtoDescuento.getBasesAplicacion().getBasesAplicacion().length);
		
		dtoDescuento.setIndBaseAplicacion(new Boolean(true));
		traza("********** DTOGlobalDescuento a grabar " + dtoDescuento);		
		setDescuento(dtoDescuento);
		traza("LPMantenimientoBaseAplicacion.almacenar() - Salida");
	 }
 
     private void logStackTrace(Throwable e) throws Exception {
 		traza("LPMantenimientoBaseAplicacion.logStackTrace() - Entrada");
        traza("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException) {
          MareException e2=(MareException)e;
          traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
		traza("LPMantenimientoBaseAplicacion.logStackTrace() - Salida");
     }

   private void cargaListaCriterios(DTOSBaseAplicacion dtoBaseAplicDTO) throws Exception{
		traza("LPMantenimientoBaseAplicacion.cargaListaCriterios() - Entrada");

        if (dtoBaseAplicDTO.getDetalle()!= null) {
            ArrayList arr = dtoBaseAplicDTO.getDetalle();
            Iterator itDet = arr.iterator();
            RecordSet rs = new RecordSet();    
            StringBuffer selTO = new StringBuffer();
            StringBuffer selCV = new StringBuffer();            

            for(int i=0; i < 18;i++)
                rs.addColumn("id");
            int z = 1;
			while(itDet.hasNext()){
               DTOSBaseAplicacionDetalle  dto = (DTOSBaseAplicacionDetalle)itDet.next();
			   traza("*********** dto " + dto);

               rs.addRow(generaVector(dto,z));
			   z++;

               if(dto.getMarca()!=null) 
			   asignarAtributo("VAR","hidMarcasSel","valor",dto.getMarca().toString());

			   if(dto.getUnidadNegocio()!=null)				   asignarAtributo("VAR","hidUniNegSel","valor",dto.getUnidadNegocio().toString());
               
			   if(dto.getNegocio()!=null) 
			   asignarAtributo("VAR","hidNegocioSel","valor",dto.getNegocio().toString());
               
			   if(dto.getSupergenerico()!=null) asignarAtributo("VAR","hidSuperGenericoSel","valor",dto.getSupergenerico().toString());
               
			   if(dto.getGenerico()!=null)
			   asignarAtributo("VAR","hidGenericoSel","valor",dto.getGenerico().toString());
               
			   if(dto.getExclusionTipoOferta()!=null) asignarAtributo("VAR","hidETO","valor",dto.getExclusionTipoOferta().toString());
               
			   if(dto.getTipoOferta()!=null){
					selTO.append(dto.getTipoOferta().toString());
					selTO.append(",");
               } 
               if(dto.getCicloVida()!=null){
					selCV.append(dto.getCicloVida().toString());
					selCV.append(",");
               } 
           
            }//fin while

			asignarAtributo("VAR","hidUltimoElementoEnLaLista","valor",Integer.toString(z));

            if (selTO.length() >1){
               StringBuffer cadena = selTO;
               asignarAtributo("VAR","selTipoOferta","valor",selTO.substring(0,cadena.length()- 1));
            }
            if (selCV.length() >1){
               StringBuffer cadena = selCV;
               asignarAtributo("VAR","selCicloVida","valor",selCV.substring(0,cadena.length()- 1));
            }
            if(!rs.esVacio()){
                String listado ="listado2";
				traza("********* rs " + rs);
				asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", rs,rs.getColumnIdentifiers()),"dtoSalida");
            }
            if(dtoBaseAplicDTO.getNumeroUnidadesObligatorias()!=null) {
				traza("********* NumeroUnidadesObligatorias" + dtoBaseAplicDTO.getNumeroUnidadesObligatorias().toString());
	
				asignarAtributo("CTEXTO","txtNumUnidadesObligatorias","valor",
				dtoBaseAplicDTO.getNumeroUnidadesObligatorias().toString());
			}
		}

		if (dtoBaseAplicDTO.getProductos()!= null) {
	 		ArrayList arrProductos = dtoBaseAplicDTO.getProductos();
            Iterator itProductos = arrProductos.iterator();
	        RecordSet rsProd = new RecordSet();   
			 
		    for(int i=0; i < 3;i++)
				rsProd.addColumn("id");        
			 
			while(itProductos.hasNext()){
				DTOProductoDTO dtoProducto = (DTOProductoDTO)itProductos.next();
			    traza("*********** dtoProducto " + dtoProducto);

                Vector vecp = new Vector();
                vecp.add(dtoProducto.getOidProducto());
			    vecp.add(dtoProducto.getCodigoSAP());                    
                vecp.add(dtoProducto.getDescripcion());
                rsProd.addRow(vecp);
			}

			if(!rsProd.esVacio()){
				String listado ="listado1";
				traza("********* rsProd " + rsProd);
				asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", rsProd,rsProd.getColumnIdentifiers()),"dtoSalida");
			}			
		}

		traza("LPMantenimientoBaseAplicacion.cargaListaCriterios() - Salida");
   }

    private Vector generaVector(DTOSBaseAplicacionDetalle dto, int secuencial) throws Exception{
		traza("LPMantenimientoBaseAplicacion.generaVector() - Entrada");

		traza("********* Marca " + dto.getMarca());
		traza("********* DescripcionMarca " + dto.getDescripcionMarca());
		traza("********* UnidadNegocio " + dto.getUnidadNegocio());
		traza("********* DescripcionUnidadNegocio " + dto.getDescripcionUnidadNegocio());
		traza("********* Negocio " + dto.getNegocio());
		traza("********* DescripcionNegocio " + dto.getDescripcionNegocio());
		traza("********* Supergenerico " + dto.getSupergenerico());
		traza("********* DescripcionSupergenerico " + dto.getDescripcionSupergenerico());
		traza("********* Generico " + dto.getGenerico());
		traza("********* DescripcionGenerico " + dto.getDescripcionGenerico());
		traza("********* ExclusionTipoOferta " + dto.getExclusionTipoOferta());
		traza("********* TipoOferta " + dto.getTipoOferta());
		traza("********* DescripcionTipoOferta " + dto.getDescripcionTipoOferta());
		traza("********* CicloVida " + dto.getCicloVida());
		traza("********* DescripcionCicloVida " + dto.getDescripcionCicloVida());
		traza("********* Producto " + dto.getProducto());
		traza("********* DescripcionProducto " + dto.getDescripcionProducto());

        Vector vec = new Vector();
		//aca pongo como primero un campo secuencial para que todos tengan distinto codigo porque sino despues todos tienen
		//el mismo valor y hace cualquiera! pincha como en la incidencia BELC300023107 (DBLG500000636)

		vec.add(Integer.toString(secuencial));

        if(dto.getMarca()!=null){
            vec.add(dto.getMarca());            
        }else{
            vec.add("");            
        }
        if(dto.getDescripcionMarca()!=null) vec.add(dto.getDescripcionMarca());
            else vec.add("");
        if(dto.getUnidadNegocio()!=null)  vec.add(dto.getUnidadNegocio());            
            else vec.add("");
        if(dto.getDescripcionUnidadNegocio()!=null) vec.add(dto.getDescripcionUnidadNegocio());
            else vec.add("");
        if(dto.getNegocio()!=null) vec.add(dto.getNegocio());
            else vec.add("");
        if(dto.getDescripcionNegocio()!=null) vec.add(dto.getDescripcionNegocio());
            else vec.add("");
        if(dto.getSupergenerico()!=null) vec.add(dto.getSupergenerico());
            else vec.add("");
        if(dto.getDescripcionSupergenerico()!=null) vec.add(dto.getDescripcionSupergenerico());
            else vec.add("");
        if(dto.getGenerico()!=null) vec.add(dto.getGenerico());
            else vec.add("");
        if(dto.getDescripcionGenerico()!=null) vec.add(dto.getDescripcionGenerico());
            else vec.add("");
        if(dto.getExclusionTipoOferta()!=null){
            if(dto.getExclusionTipoOferta().booleanValue()) vec.add("S");
            else vec.add("N");            
        }

        if(dto.getTipoOferta()!=null) vec.add(dto.getTipoOferta());
            else vec.add("");            
        if(dto.getDescripcionTipoOferta()!=null) vec.add(dto.getDescripcionTipoOferta());
            else vec.add("");            
        if(dto.getCicloVida()!=null) vec.add(dto.getCicloVida());
            else vec.add("");            
        if(dto.getDescripcionCicloVida()!=null) vec.add(dto.getDescripcionCicloVida());
            else vec.add("");            
        if(dto.getProducto()!=null) vec.add(dto.getProducto());
            else vec.add("");            
        if(dto.getDescripcionProducto()!=null) vec.add(dto.getDescripcionProducto());
            else vec.add("");            
            
		traza("LPMantenimientoBaseAplicacion.generaVector() - Salida");
        return vec;
    }


   private void cargaListaCriteriosEscalas(DTOSBaseAplicacion dtoBaseAplicDTO) throws Exception{
   		traza("LPMantenimientoBaseAplicacion.cargaListaCriteriosEscalas() - Entrada");
		
		try{
			ArrayList arrayEscalones =  dtoBaseAplicDTO.getEscalones();
			Iterator itEsc = arrayEscalones.iterator();

			RecordSet rsEsc = new RecordSet();
			
			rsEsc.addColumn("ID");
			rsEsc.addColumn("Periodo Desde");
			rsEsc.addColumn("Periodo Hasta");        
			rsEsc.addColumn("Descuento");   
			
			while (itEsc.hasNext()){
				DTOEscalon dtoE = (DTOEscalon)itEsc.next();
				Vector vec = new Vector();
				vec.add(dtoE.getOidEscalon());
				vec.add(dtoE.getEscalaDesde());
				vec.add(dtoE.getEscalaHasta());
				vec.add(dtoE.getPorcentajeDescuento()); 
				
				rsEsc.addRow(vec);
			}
			traza("**** cargaListaCriteriosEscalas: " + rsEsc);

			Vector colID = rsEsc.getColumnIdentifiers();
			int numCol = rsEsc.getColumnCount();
			String listado ="listado3";
			asignar("LISTADOA", listado, 
			UtilidadesBelcorp.generarConector("ROWSET", rsEsc, (Vector)rsEsc.getColumnIdentifiers()),"ROWSET");
		}
		catch (Exception e){
		}

  		traza("LPMantenimientoBaseAplicacion.cargaListaCriteriosEscalas() - Salida");	
	}

    private void cargaCombosPantallaConsulta(DTOSBaseAplicacion dtoBaseAplicDTO) throws Exception{
  		traza("LPMantenimientoBaseAplicacion.cargaCombosPantallaConsulta() - Entrada");	
		 try{
         ArrayList arrayDetalle = dtoBaseAplicDTO.getDetalle();
        Iterator itDet = arrayDetalle.iterator();
        RecordSet rsDet = new RecordSet();
        cargaCombos();
        /*rsEsc.addColumn("ID");
        rsEsc.addColumn("Periodo Desde");
        rsEsc.addColumn("Periodo Hasta");        
        rsEsc.addColumn("Descuento");                */
   		if(itDet.hasNext()){
			DTOEBaseAplicacionDetalle dtoB = (DTOEBaseAplicacionDetalle)itDet.next();
            /*Vector vec = new Vector();
            vec.add(dtoE.setOidEscalon());
            vec.add(dtoE.setEscalaDesde());
            vec.add(dtoE.setEscalaHasta());
            vec.add(dtoE.setPorcentajeDescuento());            
            rsEsc.addRow(vec);*/
            if(dtoB.getMarca()!=null) 
                asignarAtributo("VAR","selM","valor",dtoB.getMarca().toString());
            if(dtoB.getUnidadNegocio()!=null)             
                asignarAtributo("VAR","selUN","valor",dtoB.getUnidadNegocio().toString());
            if(dtoB.getNegocio()!=null)             
                asignarAtributo("VAR","selN","valor",dtoB.getNegocio().toString());
            if(dtoB.getSupergenerico()!=null) 
                asignarAtributo("VAR","selSG","valor",dtoB.getSupergenerico().toString());
            if(dtoB.getGenericos()!=null) 
                asignarAtributo("VAR","selG","valor",dtoB.getGenericos().toString());
            if(dtoB.getExclusionTipoOferta()!=null) 
                asignarAtributo("VAR","selETO","valor",dtoB.getExclusionTipoOferta().toString());
            if(dtoB.getTipoOferta()!=null) 
                asignarAtributo("VAR","selTO","valor",dtoB.getTipoOferta().toString());
            if(dtoB.getCicloVida()!=null) 
                asignarAtributo("VAR","selCV","valor",dtoB.getCicloVida().toString());            
        }
    	/*traza("recordset: "+rsEsc);
        Vector colID   = rsEsc.getColumnIdentifiers();
        int numCol     = rsEsc.getColumnCount();
		asignar("LISTADOA", "listado1", generarConectorListEditCF("ROWSET", rsEsc, (Vector)rsEsc.getColumnIdentifiers()),"ROWSET");*/
		 }catch(Exception e){}

  		traza("LPMantenimientoBaseAplicacion.cargaCombosPantallaConsulta() - Salida");	
    }

    private void cargaCombos() throws Exception{        
		traza("LPMantenimientoBaseAplicacion.cargaCombos() - Entrada");
		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
        traza("**** Antes de conector");
		DruidaConector resultados = conector.getConector();
        traza("**** Despues de conector "); 
        
		asignar("COMBO", "cbMarca", resultados, "SEGRecuperarMarcasProductoMP");
        asignar("COMBO", "cbUnidadNegocio", resultados, "MAEObtenerUnidadesNegocioPorPais");
        asignar("COMBO", "cbNegocio", resultados, "MAEObtenerNegocioPorPais");
		asignar("COMBO", "cbSupergenerico", resultados, "MAEObtenerSuperGenericosPorPais");
        asignar("COMBO", "cbGenerico", resultados, "MAEObtenerGenericosPorPais");
        asignar("COMBO", "cbTipoOferta", resultados, "PREObtenerTiposOfertaPorCanal");
        asignar("COMBO", "cbCicloVida", resultados, "PREObtenerCiclosVida");
		traza("LPMantenimientoBaseAplicacion.cargaCombos() - Salida");
    }

    private ComposerViewElementList crearParametrosEntrada()throws Exception {
		traza("LPMantenimientoBaseAplicacion.crearParametrosEntrada() - Entrada");
		dtoDescuento = getDescuento();

        DTOBelcorp dtoBel =  new DTOBelcorp();
        dtoBel.setOidIdioma(lIdioma);
        dtoBel.setOidPais(lPais);
        
		ComposerViewElementList lista = new ComposerViewElementList();
		
        DTOOID dtoOidMarca = new DTOOID();
        dtoOidMarca.setOid(dtoDescuento.getDatosGralesDto().getOidMarca());
        dtoOidMarca.setOidIdioma(lIdioma);
        dtoOidMarca.setOidPais(lPais);

        asignarAtributo("VAR","oidMarcaCorporativa","valor", dtoDescuento.getDatosGralesDto().getOidMarca().toString());        

		//Combo Marca
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("SEGRecuperarMarcasProductoMP");
		ci1.setDTOE(dtoOidMarca);
        
		//Combo generico
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("MAEObtenerGenericosPorPais");
		ci2.setDTOE(dtoBel);
        
		//Combo unidadNegocio
        ComposerViewElement ci3 = new ComposerViewElement();
		ci3.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");
		ci3.setDTOE(dtoBel);
        
		//Combo superGenerico
        ComposerViewElement ci4 = new ComposerViewElement();
		ci4.setIDBusiness("MAEObtenerSuperGenericosPorPais");
		ci4.setDTOE(dtoBel);
        
		//Combo negocio
        ComposerViewElement ci5 = new ComposerViewElement();
		ci5.setIDBusiness("MAEObtenerNegocioPorPais");
		ci5.setDTOE(dtoBel);

		//Tipo Oferta
        ComposerViewElement ci6 = new ComposerViewElement();
        DTOOID  dtoOid = new DTOOID();
        dtoOid.setOid(dtoDescuento.getDatosGralesDto().getOidCanal());
        dtoOid.setOidIdioma(lIdioma);
        dtoOid.setOidPais(lPais);
		ci6.setIDBusiness("PREObtenerTiposOfertaPorCanal");
		ci6.setDTOE(dtoOid);

        //Ciclo Vida
        ComposerViewElement ci7 = new ComposerViewElement();
		ci7.setIDBusiness("PREObtenerCiclosVida");
		ci7.setDTOE(dtoBel);
        
		lista.addViewElement(ci1);
		lista.addViewElement(ci2);
        lista.addViewElement(ci3);
		lista.addViewElement(ci4);
        lista.addViewElement(ci5);
    	lista.addViewElement(ci6);
        lista.addViewElement(ci7);
		
		traza("LPMantenimientoBaseAplicacion.crearParametrosEntrada() - Salida");
		return lista;
	}

    private void recuperaValoresConfiguracionMatrizDescuento() throws Exception {
		traza("LPMantenimientoBaseAplicacion.recuperaValoresConfiguracionMatrizDescuento() - Entrada");
		dtoDescuento = getDescuento();
		dtoMatrizDescuento = dtoDescuento.getDatosMatriz();
		Iterator iterador = dtoMatrizDescuento.getListaParametros().iterator();
		while (iterador.hasNext()){
			DTOParametroMatrizDescuentos dtoP = (DTOParametroMatrizDescuentos)iterador.next();
			String sParam = dtoP.getOidParametro().toString();
			int para = Integer.parseInt(sParam);

            switch (para){
                case 20:
                {
                    traza("entro al 20");
                    asignarAtributo("VAR","VisibleBADM","valor",obtenerValor(dtoP.getVisible()));
                    asignarAtributo("VAR","ObligatorioBADM","valor",obtenerValor(dtoP.getObligatorio()));
                    asignarAtributo("VAR","ModificableBADM","valor",obtenerValor(dtoP.getModificable()));
                }
                break;
                    
                case 21:
                {
                    traza("entro al 21");
                    asignarAtributo("VAR","VisibleBADUN","valor",obtenerValor(dtoP.getVisible()));
                    asignarAtributo("VAR","ObligatorioBADUN","valor",obtenerValor(dtoP.getObligatorio()));
                    asignarAtributo("VAR","ModificableBADUN","valor",obtenerValor(dtoP.getModificable()));
                }
                break;

                case 22:
                {
                    traza("entro al 22");
                    asignarAtributo("VAR","VisibleBADN","valor",obtenerValor(dtoP.getVisible()));
                    asignarAtributo("VAR","ObligatorioBADN","valor",obtenerValor(dtoP.getObligatorio()));
                    asignarAtributo("VAR","ModificableBADN","valor",obtenerValor(dtoP.getModificable()));
                }
                break;

                case 23:
                {
                    traza("entro al 23");
                    asignarAtributo("VAR","VisibleBADSG","valor",obtenerValor(dtoP.getVisible()));
                    asignarAtributo("VAR","ObligatorioBADSG","valor",obtenerValor(dtoP.getObligatorio()));
                    asignarAtributo("VAR","ModificableBADSG","valor",obtenerValor(dtoP.getModificable()));
                }
                break;

                case 24:
                {
                    traza("entro al 24");
                    asignarAtributo("VAR","VisibleBADG","valor",obtenerValor(dtoP.getVisible()));
                    asignarAtributo("VAR","ObligatorioBADG","valor",obtenerValor(dtoP.getObligatorio()));
                    asignarAtributo("VAR","ModificableBADG","valor",obtenerValor(dtoP.getModificable()));
                }
                break;

                case 25:
                {
                    traza("entro al 25");
                    asignarAtributo("VAR","VisibleBADP","valor",obtenerValor(dtoP.getVisible()));
                    asignarAtributo("VAR","ObligatorioBADP","valor",obtenerValor(dtoP.getObligatorio()));
                    asignarAtributo("VAR","ModificableBADP","valor",obtenerValor(dtoP.getModificable()));
                }
                break;
			}
		}
		traza("LPMantenimientoBaseAplicacion.recuperaValoresConfiguracionMatrizDescuento() - Salida");
	}

	private String obtenerValor(Boolean bool) {
		if(bool.booleanValue())
			return "S";
		else
			return "N";
	}

	private ArrayList aplanarCriterios(String listado) throws Exception {
		traza("LPMantenimientoBaseAplicacion.aplanarCriterios() - Entrada");

		StringTokenizer stRows = new StringTokenizer(listado, "$");
		ArrayList listaDescuentos = new ArrayList ();
        
		for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
			DTOSBaseAplicacionDetalle dtoBaseApliDet=  new DTOSBaseAplicacionDetalle();
	        dtoBaseApliDet.setOidIdioma(lIdioma);
		    dtoBaseApliDet.setOidPais(lPais);
		
			StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");

			for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
				StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				

				for(int contad =  0 ;stCols.hasMoreTokens(); contad++){								
		            String desc = stCols.nextToken().toString();
				    String valor = stCols.nextToken().toString();
		            traza(desc + " " + valor);                    
					if(desc.equals("m"))
					  dtoBaseApliDet.setMarca(Long.valueOf(valor));

					if(desc.equals("un"))											
					  dtoBaseApliDet.setUnidadNegocio(Long.valueOf(valor));
					
					if(desc.equals("n"))
					  dtoBaseApliDet.setNegocio(Long.valueOf(valor));
					
					if(desc.equals("sg"))
					  dtoBaseApliDet.setSupergenerico(Long.valueOf(valor));			
					
					if(desc.equals("g"))
					  dtoBaseApliDet.setGenerico(Long.valueOf(valor));										
					
					if(desc.equals("eto")){
					  if(valor.equals("S")) 
						dtoBaseApliDet.setExclusionTipoOferta(Boolean.TRUE);
					  else dtoBaseApliDet.setExclusionTipoOferta(Boolean.FALSE);											
					}

					if(desc.toString().equals("to"))
		              dtoBaseApliDet.setTipoOferta(Long.valueOf(valor)); 											
				
					if(desc.toString().equals("cv"))
		              dtoBaseApliDet.setCicloVida(Long.valueOf(valor));											
				
					if(desc.toString().equals("pr"))
		              dtoBaseApliDet.setProducto(Long.valueOf(valor));

					if(desc.toString().equals("descmarca"))
					  dtoBaseApliDet.setDescripcionMarca(valor);

					if(desc.toString().equals("descunidad"))
						dtoBaseApliDet.setDescripcionUnidadNegocio(valor);
					
					if(desc.toString().equals("descnegocio"))
						dtoBaseApliDet.setDescripcionNegocio(valor);

					if(desc.toString().equals("descsupergenerico"))
						dtoBaseApliDet.setDescripcionSupergenerico(valor);

					if(desc.toString().equals("descgenerico"))
						dtoBaseApliDet.setDescripcionGenerico(valor);

					if(desc.toString().equals("desctipooferta"))
						dtoBaseApliDet.setDescripcionTipoOferta(valor);

					if(desc.toString().equals("descciclovida"))
						dtoBaseApliDet.setDescripcionCicloVida(valor);

					if(desc.toString().equals("descproducto"))
						dtoBaseApliDet.setDescripcionProducto(valor);

			    }
			}

        traza("********* dtoBaseApliDet " + dtoBaseApliDet);
        listaDescuentos.add(dtoBaseApliDet);
        }

		traza("LPMantenimientoBaseAplicacion.aplanarCriterios() - Salida");
		return listaDescuentos;
	}

	private ArrayList aplanarCriterios2(String listado) throws Exception {
		traza("LPMantenimientoBaseAplicacion.aplanarCriterios2() - Entrada");

		StringTokenizer stRows = new StringTokenizer(listado, "$");
		ArrayList listaDescuentos = new ArrayList ();
        
		for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
			DTOEscalon dto = new DTOEscalon();
	        dto.setOidIdioma(lIdioma);
		    dto.setOidPais(lPais);
		
			StringTokenizer stCols = new StringTokenizer(stRows.nextToken(), "|");

	        if (stCols.hasMoreTokens()) {
				String ed = this.desFormatearNumero(stCols.nextToken(),this.FORMATO_DEFAULT);
				traza("********* Seteando escala desde: "+ed);
				dto.setEscalaDesde(new BigDecimal(ed));          
			}
          
	        if (stCols.hasMoreTokens()) {
				String eh = stCols.nextToken();
				if(!eh.equals("null")){
					String ehf = this.desFormatearNumero(eh,this.FORMATO_DEFAULT);  
					traza("********* Seteando escala hasta: "+ehf);
					dto.setEscalaHasta(new BigDecimal(ehf));              
				}    
	        }	
          
		    if (stCols.hasMoreTokens()) {
				String pd = this.desFormatearNumero(stCols.nextToken(),this.FORMATO_DEFAULT);
				traza("********* Seteando porcentaje descuento: " + pd);
				dto.setPorcentajeDescuento(Double.valueOf(pd));
		    }          

			traza("********* dto" + dto);
	        listaDescuentos.add(dto);
        }
		traza("LPMantenimientoBaseAplicacion.aplanarCriterios2() - Salida");
        return  listaDescuentos;
	}

	private void otraBase() throws Exception {
		traza("LPMantenimientoBaseAplicacion.otraBase() - Entrada");
		almacenar();
		cargaCombos();
		recuperaValoresConfiguracionMatrizDescuento();		
		traza("LPMantenimientoBaseAplicacion.otraBase() - Salida");
	}

	public void siguiente() throws Exception {
		traza("LPMantenimientoBaseAplicacion.siguiente() - Entrada");		

		dtoDescuento = getDescuento();
		casoDeUso = conectorParametroLimpia("casoDeUso", "", true);          
		traza("****** casoDeUso: " + casoDeUso);

		if (casoDeUso.equals("modificar") || casoDeUso.equals("consultar")) {
			if(casoDeUso.equals("modificar")) {
				almacenar();	
				guardar();
			}

			String posicion = conectorParametroLimpia("posicion", "", true);          
			traza("****** posicion: " + posicion);
			
			Long posTemp = new Long(posicion);
			long pos = posTemp.longValue() + 1;		
			Long posNueva = new Long(pos);

			DTOSBaseAplicacion[] dtoArrTemp = dtoDescuento.getBasesAplicacion().getBasesAplicacion();
            int cantBasesAplicacion = dtoArrTemp.length;
            traza("****** longitud: " + cantBasesAplicacion);
			if(dtoArrTemp[posNueva.intValue()]!=null) {
				DTOSBaseAplicacion dtoBase = dtoArrTemp[posNueva.intValue()];                                  
                traza("******* DTOSBaseAplicacion: " + dtoBase);
                cargaCombos();
                cargaListaCriterios(dtoBase);                                                          
                cargaListaCriteriosEscalas(dtoBase);

                asignarAtributo("VAR","posicion","valor", posNueva.toString());             // DBLG500001127
                asignarAtributo("VAR","longitud","valor", String.valueOf(cantBasesAplicacion));  // DBLG500001127
                asignarAtributo("VAR","casoDeUso","valor",casoDeUso);    
                asignarAtributo("VAR","hidOidBase","valor",dtoBase.getOidBase().toString());
                asignarAtributo("VAR","hidOidDescuento","valor",dtoBase.getOidDescuento().toString()); 

				if(casoDeUso.equals("consultar")) {
					//Esto se hace desde javascript (teoricamente)

					/* Cargar los combos sólo con la información contenida en la estructura de dtos dtoBaseAplicacion 
					Permitir sólo la consulta, deshabilitando el botón "buscarProductos" y los combos 
					Habilitar botón "siguiente" y ocultar "otraBase"  */
				}
				else {
					//Eso se hace desde javascript (teoricamente)

					//Habilitar los botones "siguiente" y "otraBase" 
				}
			}
			else {
				//Lanzar mensaje de error con el código "UIDTO0002" de errores de interfaz 
				//throw new MareException(new Exception(),70000002);
			}		
		}
		else if (casoDeUso.equals("insertar")) {
			almacenar(); 
			guardar(); 
		}

		traza("LPMantenimientoBaseAplicacion.siguiente() - Salida");
	}
}
