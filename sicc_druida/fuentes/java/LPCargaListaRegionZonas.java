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
/**
 * Sistema:           Belcorp
 * Modulo:            MAV
 */

//$Id: LPCargaListaRegionZonas.java,v 1.2 2011/02/07 21:27:11 peextsapaza Exp $

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.files.ExcelUtil;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;


public class LPCargaListaRegionZonas extends LPSICCBase {     
    private String sNombreLP = "LPCargaListaRegionZonas";
    private String idioma = null;
    private String pais   = null;
    private String targetName = null;

    public static final String FORMATO_DEFAULT_HORA = "hh:mm:ss"; 

    public LPCargaListaRegionZonas() {
    }

    public void inicio() throws Exception {
        setTrazaFichero();
    }

    public void ejecucion() throws Exception{
        String accion = conectorParametroLimpia("accion", "", true);           
        idioma = getIdioma();
        pais   = getPais();	  
    	  try{
            //rastreo();
    		  UtilidadesLog.debug("accion :" + accion);

            if ( accion.equals("") ){
            	mostrarListado();
            } else if (accion.equals("seleccionar") ) {
                pagina("contenido_seleccion_fichero_BP_zonas");                
                seleccionar();               
            } else if (accion.equals("procesar") ) {
                pagina("contenido_seleccion_fichero_BP_zonas");                
                procesar();               
            } else if (accion.equals("cancelar") ) {
                pagina("contenido_bp_lista_region_zonas");                
                mostrarListado();             
            } else if (accion.equals("aceptar") ) {
                pagina("contenido_bp_lista_region_zonas");                
                aceptar();             
            } 
            
        }catch (Exception ex){	  
            logStackTrace(ex);
            
            if(accion.equals(""))
            	pagina("contenido_seleccion_fichero_BP");
            else
            	pagina("contenido_bp_lista_region_zonas");
            
            this.lanzarPaginaError(ex);
        }      
    	  //getConfiguracionMenu();
    }

    private void mostrarListado() throws Exception{
    	pagina("contenido_bp_lista_region_zonas");
    	Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);

		asignarAtributo("VAR", "hidOidPais", "valor", pais.toString() );
		asignarAtributo("VAR", "hidOidIdioma", "valor", idioma.toString() );

		String varListaSubgerencia = this.conectorParametroLimpia("varListaSubgerencia", "", true);
    	String varListaRegiones = this.conectorParametroLimpia("varListaRegiones", "", true);
    	String varListaZonas = this.conectorParametroLimpia("varListaZonas", "", true);
    	String varListaUnidades = this.conectorParametroLimpia("varListaUnidades", "", true);
    	
    	traza("varListaSubgerencia :" + varListaSubgerencia);
    	traza("varListaRegiones :" + varListaRegiones);
    	traza("varListaZonas :" + varListaZonas);
    	traza("varListaUnidades :" + varListaUnidades);

        RecordSet rRegiones= (RecordSet)this.getSessionCache().get("regionesMAV");
        RecordSet rZonas= (RecordSet)this.getSessionCache().get("zonasMAV");
        
        Long subgerenciaArray[] = null;
        if (varListaSubgerencia != null)
          subgerenciaArray = this.parseaCombos(varListaSubgerencia);
        
        Long regionesArray[] = null;
        if (varListaRegiones != null)
          regionesArray = this.parseaCombos(varListaRegiones);

        Long zonaArray[] = null;
        if (varListaZonas != null)
          zonaArray = this.parseaCombos(varListaZonas);
        
        Map unidades = parseaUnidades(varListaUnidades);
        
        ArrayList listaUniAdm = obtenerListaUA(regionesArray, zonaArray, rRegiones, rZonas, unidades);
        
        RecordSet rLista = new RecordSet();
        Vector vCols = new Vector();
        vCols.add("oid");
        vCols.add("codigoRegion");
 	    vCols.add("region");
		vCols.add("codigoZona");
		vCols.add("zona");
		vCols.add("unidades");
		rLista.setColumnIdentifiers(vCols);
		
		for(int i=0; i<listaUniAdm.size(); i++) {
			Vector vFila = new Vector();
			Map mapAux= (Map)listaUniAdm.get(i);
			
			vFila.add(String.valueOf(i));
            vFila.add(mapAux.get("codigoRegion"));
            vFila.add(mapAux.get("region"));
            vFila.add(mapAux.get("codigoZona"));
            vFila.add(mapAux.get("zona"));
            vFila.add(mapAux.get("unidades"));
            
            rLista.addRow(vFila);
		}
        
        if(!rLista.esVacio()){
            DruidaConector conLista = UtilidadesBelcorp.generarConector("LISTA", rLista, rLista.getColumnIdentifiers());
            asignar("LISTADOA", "listado1", conLista, "LISTA");
        }        

        // Subgerencia, Region, Zona, Unidades
        asignarAtributo("VAR", "varListaSubgerencia", "valor", varListaSubgerencia);
        asignarAtributo("VAR", "varListaRegiones", "valor", varListaRegiones);
        asignarAtributo("VAR", "varListaZonas", "valor", varListaZonas);
        asignarAtributo("VAR", "varListaUnidades", "valor", varListaUnidades);
        
        String estadoProceso = this.conectorParametroLimpia("estadoProceso","",true);
    	asignarAtributo("VAR", "varEstadoProceso", "valor", estadoProceso );        
    }

    private void seleccionar() throws Exception{
        asignarAtributo("VAR","conectorAction", "valor" ,"LPCargaListaRegionZonas");
        asignarAtributo("VAR","accion", "valor" , "");
        asignarAtributoPagina("cod", "01");
        
		String varListaSubgerencia = this.conectorParametroLimpia("varListaSubgerencia", "", true);
    	String varListaRegiones = this.conectorParametroLimpia("varListaRegiones", "", true);
    	String varListaZonas = this.conectorParametroLimpia("varListaZonas", "", true);
    	String varListaUnidades = this.conectorParametroLimpia("varListaUnidades", "", true);

        asignarAtributo("VAR", "varListaSubgerencia", "valor", varListaSubgerencia);
        asignarAtributo("VAR", "varListaRegiones", "valor", varListaRegiones);
        asignarAtributo("VAR", "varListaZonas", "valor", varListaZonas);
        asignarAtributo("VAR", "varListaUnidades", "valor", varListaUnidades);
    }
    
    private void procesar() throws Exception {
        Long paisActivo = UtilidadesSession.getPais(this); 
        traza("paisActivo: " + paisActivo);
        String tmpDirDruida = getDirTempDruida();           
        String fileName   = conectorParametro("seleccion");		
        traza("fileName: " + fileName);
        String pathDir    = getWebTmpDir();			
        traza("tmpDirDuirda:"+tmpDirDruida);
        traza("pathDir WEB:"+pathDir);

        DTOFicheroDisp dtoFichero = new DTOFicheroDisp();
        dtoFichero.setOidPais(paisActivo);
        dtoFichero.setNombreFichero(fileName);
        dtoFichero.setPathFichero(pathDir);

        ArrayList listRegistros = new ArrayList();
        DTOManagerFileResult dtoResult = procesarExcel(dtoFichero, listRegistros);
        RecordSet rLista = new RecordSet();
        Vector vCols = new Vector();
        vCols.add("posicion");
        vCols.add("fila");
 	    vCols.add("codigoRegion");
 	    vCols.add("codigoZona");
		vCols.add("mensajeError");
		rLista.setColumnIdentifiers(vCols);
		
		ArrayList lista = dtoResult.getListaRespuesta();
		for(int i=0; i<lista.size(); i++) {
			Vector vFila = new Vector();
			Map mapAux= (Map)lista.get(i);
			
			vFila.add(String.valueOf(i));
            vFila.add(mapAux.get("numeroFila"));
            vFila.add(mapAux.get("codigoRegion"));
            vFila.add(mapAux.get("codigoZona"));
            vFila.add(mapAux.get("mensajeError"));
            
            rLista.addRow(vFila);
		}
        
        traza("RecordSet generado: " + rLista);
 	    DruidaConector conFilas = UtilidadesBelcorp.generarConector("listaFilas", 
													rLista, rLista.getColumnIdentifiers());
 	    
        traza("dtoResult: " + dtoResult);
          
        ArrayList listaArchivo = dtoResult.getListaRespuesta();		
        String numeroRegistros = dtoResult.getReporteRegistros();
        String numRegistrosError = String.valueOf(listaArchivo.size());
        String numRegistrosValido = String.valueOf(Integer.parseInt(numeroRegistros) - Integer.parseInt(numRegistrosError));
        
        if(Integer.parseInt(numRegistrosError)< Integer.parseInt(numeroRegistros)) {
        	asignarAtributo("VAR", "hidValido", "valor", "1");
        	this.getSessionCache().put("listaRegionZonas", listRegistros);
        } else
			asignarAtributo("VAR", "hidValido", "valor", "0");
        
        this.asignar("LISTADOA", "listado1", conFilas, "listaFilas");
        this.asignarAtributo("CAPA", "capa1", "visibilidad", "visible");        
        this.asignarAtributo("LABELC","lbldtNumRegistros","valor", numeroRegistros);                                        
        this.asignarAtributo("LABELC","lbldtNumRegistrosError","valor", numRegistrosError);                                                  
        this.asignarAtributo("LABELC","lbldtNumRegistrosValido","valor", numRegistrosValido);
        
        this.asignarAtributo("LABELC","lbldtNumRegistrosValido","valor", numRegistrosValido);
        
        String varListaSubgerencia = this.conectorParametroLimpia("varListaSubgerencia", "", true);
    	String varListaRegiones = this.conectorParametroLimpia("varListaRegiones", "", true);
    	String varListaZonas = this.conectorParametroLimpia("varListaZonas", "", true);
    	String varListaUnidades = this.conectorParametroLimpia("varListaUnidades", "", true);

        asignarAtributo("VAR", "varListaSubgerencia", "valor", varListaSubgerencia);
        asignarAtributo("VAR", "varListaRegiones", "valor", varListaRegiones);
        asignarAtributo("VAR", "varListaZonas", "valor", varListaZonas);
        asignarAtributo("VAR", "varListaUnidades", "valor", varListaUnidades);
    }

    public DTOManagerFileResult procesarExcel(DTOFicheroDisp dto, ArrayList listRegistros) throws Exception {
        traza("procesarExcel: Entrada");
        traza("dtoFichero: " + dto);
        DTOManagerFileResult fResu = new DTOManagerFileResult();
        
        Long oidListaClientes = null;
        ArrayList listMapFila = new ArrayList();
        
        int fila=0;
        
        RecordSet rRegiones= (RecordSet)this.getSessionCache().get("regionesMAV");
        RecordSet rZonas= (RecordSet)this.getSessionCache().get("zonasMAV");
        Map errores = obtenerErrores();
        
        try {        
            //Abrimos el archivo Excel para su procesamiento
            ExcelUtil excelUtil = new ExcelUtil(dto.getPathFichero(), dto.getNombreFichero(), true);         
            //nos colocamos en la primera hora del documento Excel
            excelUtil.initSheet(0);
            
            boolean errorPorFila =false; 
            while(excelUtil.hasNext()) {
                Map mapRow = excelUtil.next();
                fila +=1;
                errorPorFila= false;
    
                //obtenemos el codigo Pais, codigo de cliente y Numero Unidades 
                String codigoRegion=(String)mapRow.get("0");
                String codigoZona=(String)mapRow.get("1");
                String unidades=(String)mapRow.get("2");
                Long oidCliente = null;
                String filaExcel = (String)mapRow.get("rowNum");//obtiene la fila con datas
                
                String oidSubgerencia = "";
                String oidRegion = "";
                String oidZona = "";
                String region ="";
                String zona = "";
                
                 while(fila<Integer.parseInt(filaExcel)){
                     anhadirFilaVacia(listMapFila,fila);                             
                     fila +=1;
                 }
                 
                 //validaciones
                 String mensajeError=null;
    
                 if(StringUtils.isEmpty(codigoRegion)){
                     mensajeError = "error.codigoRegionVacio";
                 }       
    
                 /*if(StringUtils.isEmpty(codigoZona)){
                     mensajeError = "error.codigoZonaVacio";
                 }*/       
                 
                 if(StringUtils.isEmpty(unidades)){
                     mensajeError = "error.unidadesVacio";
                 }       
                 
                 if(StringUtils.isEmpty(codigoRegion) && StringUtils.isEmpty(codigoZona) && StringUtils.isEmpty(unidades) ){
                     mensajeError = "error.noRegistroFila";
                 }
    
                 if(StringUtils.isNotEmpty(codigoRegion)){
                	 boolean encontrado = false;
                	 
                	 for(int i=0; i<rRegiones.getRowCount(); i++) {
                		 String codigoRegionAux = (String)rRegiones.getValueAt(i,3);
                		 
                		 if(codigoRegion.equals(codigoRegionAux)) {
                			oidSubgerencia = rRegiones.getValueAt(i,0).toString();
                			oidRegion = rRegiones.getValueAt(i,1).toString();
                			region = rRegiones.getValueAt(i,2).toString();
                			encontrado = true;
                			break;
                		 }
                	 }
                	 
                    if (!encontrado)     
                        mensajeError = "error.noExisteRegion";
                 }   
    
                 if(StringUtils.isNotEmpty(codigoZona)){
                	 boolean encontrado = false;
                	 
                	 for(int i=0; i<rZonas.getRowCount(); i++) {
                		 String codigoZonaAux = (String)rZonas.getValueAt(i,5);
                		 
                		 if(codigoZona.equals(codigoZonaAux)) {
                			oidZona = rZonas.getValueAt(i,0).toString();
                			zona = rZonas.getValueAt(i,2).toString();
                			encontrado = true;
                			break;
                		 }
                	 }
                	 
                    if (!encontrado)     
                        mensajeError = "error.noExisteZona";
                 }
    
                 if(StringUtils.isNotEmpty(unidades)){
                     if(!validoFormatoPuntaje(unidades)){
                         mensajeError = "error.noFormatoNumeroUnidades";
                     }
                 }                                                       
    
                 if(StringUtils.isEmpty(mensajeError) && StringUtils.isNotEmpty(codigoRegion) && StringUtils.isNotEmpty(unidades)){
                	 
                     Map mapFila = new HashMap();
                     mapFila.put("oidSubgerencia", oidSubgerencia);
                     mapFila.put("oidRegion", oidRegion);
                     mapFila.put("region", region);
                     mapFila.put("codigoRegion", codigoRegion);
                     mapFila.put("oidZona", oidZona);
                     mapFila.put("zona", zona);
                     mapFila.put("codigoZona", codigoZona);
                     mapFila.put("unidades", unidades);
                	 
                     listRegistros.add(mapFila);
                }
                
                if(StringUtils.isNotEmpty(mensajeError)) {
                    //Lo almacenamos en una lista temporal
                    Map mapFila = new HashMap();
                    mapFila.put("numeroFila", String.valueOf(fila));
                    mapFila.put("codigoRegion", codigoRegion);
                    mapFila.put("codigoZona", codigoZona);
                    mapFila.put("mensajeError", errores.get(mensajeError));
                    listMapFila.add(mapFila);
                    UtilidadesLog.debug("Fila : " + mapFila);
                }               
            }
            
            excelUtil.cerrar();
            fResu.setEstatus(new Long(-2)); // Procesamiento Finalizado OK 
            fResu.setListaRespuesta(listMapFila);
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception e) {
            UtilidadesLog.error(e);
        }

        if (fila == 0) {
            traza("El archivo esta vacio");
        } else {
            fResu.setReporteRegistros(String.valueOf(fila));
        }
         
        return fResu;
    }    
	
    private void aceptar() throws Exception {
    	Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);
		
        Vector vSubg = new Vector();
        Vector vZona = new Vector();
        Vector vRegion = new Vector();
        
		Map unidadesRegionZona = new HashMap();
		
		ArrayList listaRegionZonas = (ArrayList)this.getSessionCache().get("listaRegionZonas");
		
		for(int i=0; i<listaRegionZonas.size(); i++) {
			Map elemento = (Map)listaRegionZonas.get(i);
			String oidZonaAux = (String)elemento.get("oidZona");
			
			Long oidSubGerencia = new Long((String)elemento.get("oidSubgerencia"));
			Long oidRegion = new Long((String)elemento.get("oidRegion"));
			Long oidZona = null;
			if(!oidZonaAux.equals(""))
				oidZona = new Long(oidZonaAux);
			Long unidades = (new BigDecimal((String)elemento.get("unidades"))).longValue();
			elemento.put("unidades", unidades.toString());

            if(!vSubg.contains(oidSubGerencia))
                vSubg.add(oidSubGerencia);

            if(oidZona!=null && !vZona.contains(oidZona))
                vZona.add(oidZona);

            if(!vRegion.contains(oidRegion))
                vRegion.add(oidRegion);
            

            if(oidZona!=null) {
            	unidadesRegionZona.put("z" + oidZona.toString(), unidades);
            } else if (oidRegion!=null) {
            	unidadesRegionZona.put("r" + oidRegion.toString(), unidades);
            }            
		}
		
		Long[] aSubg = null;
		Long[] aZona = null;
		Long[] aRegion = null;
		
        if(vSubg.size() > 0) {
            aSubg = (Long[])vSubg.toArray(new Long[vSubg.size()]);
        }

        if(vZona.size() > 0) {
            aZona = (Long[])vZona.toArray(new Long[vZona.size()]);
        }

        if(vRegion.size() > 0) {
            aRegion = (Long[])vRegion.toArray(new Long[vRegion.size()]);
        }
    
        //Ahora lo cargamos en los hiddens de la Pantalla
        
        // Subgerencia
        traza("Toma Subgerencia");   
        asignarAtributo("VAR", "varListaSubgerencia", "valor", parseaArray(aSubg) );

        // Region
        traza("Toma Regiones");   
        asignarAtributo("VAR", "varListaRegiones", "valor", parseaArray(aRegion) );   
         
        // Zona
        traza("Toma Zona");   
        if(aZona != null)
        	asignarAtributo("VAR", "varListaZonas", "valor", parseaArray(aZona) );
        else
        	asignarAtributo("VAR", "varListaZonas", "valor", "" );
          
        // Unidades x Region/Zona
        traza("Toma Unidades x Region/Zona");   
        StringBuffer sBufferUnidades = new StringBuffer("");
        Iterator it = unidadesRegionZona.keySet().iterator();
        int totalElementos = 0;
        while(it.hasNext()) {
     	   String claveUA = (String)it.next();
     	   
     	   if(unidadesRegionZona.get(claveUA)!=null)
     		   claveUA = claveUA + "_" + unidadesRegionZona.get(claveUA).toString();
     	   else
     		   claveUA = claveUA + "_NULL";
     	   
     	   if(totalElementos == 0)
     		   sBufferUnidades.append(claveUA);
     	   else
     		   sBufferUnidades.append("|").append(claveUA);
     	   
     	  totalElementos = totalElementos + 1;
        }
        
        asignarAtributo("VAR", "varListaUnidades", "valor", sBufferUnidades.toString() );
        
        RecordSet rLista = new RecordSet(); 
        Vector vCols = new Vector();
        vCols.add("oid");
        vCols.add("codigoRegion");
 	    vCols.add("region");
		vCols.add("codigoZona");
		vCols.add("zona");
		vCols.add("unidades");
		rLista.setColumnIdentifiers(vCols);
		
		for(int i=0; i<listaRegionZonas.size(); i++) {
			Vector vFila = new Vector();
			Map mapAux= (Map)listaRegionZonas.get(i);
			
			vFila.add(String.valueOf(i));
            vFila.add(mapAux.get("codigoRegion"));
            vFila.add(mapAux.get("region"));
            vFila.add(mapAux.get("codigoZona"));
            vFila.add(mapAux.get("zona"));
            vFila.add(mapAux.get("unidades"));
            
            rLista.addRow(vFila);
		}
        
        if(!rLista.esVacio()){
            DruidaConector conLista = UtilidadesBelcorp.generarConector("LISTA", rLista, rLista.getColumnIdentifiers());
            asignar("LISTADOA", "listado1", conLista, "LISTA");
        }        
    }
    

    public void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException){
            MareException e2=(MareException)e;
            traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
    }
	
    /**
    * Retorna el codigo de pais.
    */
    private String getPais() throws Exception,MareException{
        Long pais = new Long(1);//UtilidadesSession.getPais(this);
        return pais.toString();
    }

    private String getIdioma() throws MareException{
        Long idioma = new Long(1);//UtilidadesSession.getIdioma(this);
        return idioma.toString();
    }

    /*
     * Retorna un String indicando el directorio donde Druida
     * almacena el archivo transferido desde la LP.
     * */
    private String getDirTempDruida() throws Exception{				
        String dir = null;
        dir = Contexto.getPropiedad("TMP.UPLOAD");		
        return dir;
    }

    /*
     * Retorna un String indicando el directorio temporario del 
     * web server. En dicho directorio se deben dejar los archivos
     * que se traen desde la pagina cliente. 
     **/
    private String getWebTmpDir()	throws Exception{
        return Contexto.getPropiedad("TMP.UPLOAD2");
    }
    
    private Long[] parseaCombos(String sCadena) throws Exception {
      traza(" ---- ParseaCombos ----");
      traza("sCadena: " + sCadena);
      StringTokenizer tok = new StringTokenizer(sCadena, ",");
      Vector v = new Vector();

      int i = 0;
      while ( tok.hasMoreTokens() ) {
         String sToken = tok.nextToken();
         traza("sToken: " + sToken);
         v.add( new Long(sToken) );      
      }
      traza(" Fin bucle");

      Long[] sRetorno = (Long[]) v.toArray( new Long[v.size()] );
      traza(" ---- End Parsea Combos ----");

      return sRetorno;
    }
    
    
    private ArrayList obtenerListaUA(Long[] regiones, Long[] zonas, RecordSet rRegiones, RecordSet rZonas, Map unidades) throws Exception {
      traza(" obtenerListaUA ");
      
      RecordSet rZonasAux = null;
      Vector vOidRegConZona = new Vector();
      Vector vOidSubgConRegion = new Vector();
      ArrayList listaUAZonas = new ArrayList();
      ArrayList listaUARegiones = new ArrayList();
      
	  traza("Paso 1");
      
      for(int i=0; i<zonas.length; i++) {
    	  Map ua = new HashMap();
    	  BigDecimal oidRegion = null;
    	  BigDecimal oidZona = null;
    	  
    	  for (int j = 0; j <  rZonas.getRowCount(); j++) {
              oidZona = (BigDecimal)rZonas.getValueAt(j,0);  
              if(oidZona.longValue() == zonas[i]) {
            	  oidRegion = (BigDecimal)rZonas.getValueAt(j,1);
            	  
            	  ua.put("oidZona", oidZona.toString());
            	  ua.put("zona", (String)rZonas.getValueAt(j,2));
            	  ua.put("codigoZona", (String)rZonas.getValueAt(j,5));
            	  ua.put("oidRegion", oidRegion.toString()); 
            	  break;
              }
            	  
          }
    	  for (int j = 0; j <  rRegiones.getRowCount(); j++) {
    		  BigDecimal oidRegionAux = (BigDecimal)rRegiones.getValueAt(j,1);
    		  if(oidRegionAux.longValue() == oidRegion.longValue()) {
    			  ua.put("region", (String)rRegiones.getValueAt(j,2));
    			  ua.put("codigoRegion", (String)rRegiones.getValueAt(j,3));
    			  break;
    		  }
    	  }
    	  
    	  ua.put("unidades", unidades.get("z" + oidZona.toString()));
    	  listaUAZonas.add(ua);
      }
      
      //Obtenemos las regiones que no tienen zona asociada
      for(int i=0; i<regiones.length; i++) {
    	  boolean encontrado = false;
    	  Map mapRegion = new HashMap();
    	  Long oidRegionAux = null;
    	  
    	  for(int j=0; j<listaUAZonas.size(); j++) {
    		  Map elemento = (Map)listaUAZonas.get(j);
    		  oidRegionAux = new Long((String)elemento.get("oidRegion"));  
    		  
    		  if(oidRegionAux.longValue() == regiones[i].longValue()) {
    			  encontrado = true;
    			  break;
    		  }
    	  }
    	  
    	  if(!encontrado) {
			  mapRegion.put("oidRegion", regiones[i].longValue());

    		  for (int k = 0; k <  rRegiones.getRowCount(); k++) {
        		  BigDecimal oidRegionAux2 = (BigDecimal)rRegiones.getValueAt(k,1);
        		  if(oidRegionAux2.longValue() == regiones[i].longValue()) {
        			  mapRegion.put("region", (String)rRegiones.getValueAt(k,2));
        			  mapRegion.put("codigoRegion", (String)rRegiones.getValueAt(k,3));
        			  mapRegion.put("oidZona", "");
        			  mapRegion.put("zona", "");
        			  mapRegion.put("unidades", unidades.get("r" + regiones[i].toString()));
        			  
        			  listaUARegiones.add(mapRegion);
        			  break;
        		  }
        	  }    		  
    	  }	  
      }
      
      listaUAZonas.addAll(listaUARegiones);
      traza("obtenerListaUA - finalizar");
      return listaUAZonas;
    }


	private Long[] quitaOidsRepetidos(Long[] original, Long[] aQuitar) throws Exception {
	  Vector v = new Vector();
	  
	  for (int i = 0; i < original.length; i++)
	  {
	      boolean bAgregar = true;
	      traza("******* Valor original: " + original[i]);
	      for (int j = 0; (j < aQuitar.length) && (bAgregar); j++)
	      {
	    	  traza(" - Valor a comparar: " + aQuitar[j]);
	          if (original[i].longValue() ==  aQuitar[j].longValue() )  // Si el oid de "original" ya existe en "aQuitar"
	          {
	        	  traza("Se quita");
	              bAgregar = false;             
	          }
	      }
	      
	      if (bAgregar) {
	    	traza("Se deja");
	        v.add(original[i]);
	      }
	  }
	  
	  traza("Nuevo vector: " + v);
	  Long[] aRetornar = (Long[])v.toArray(new Long[v.size()]);    
	  return aRetornar;
	  
	}

	private String parseaArray(Long[] array) throws Exception {
      StringBuffer sBuffer = new StringBuffer("");
      traza("Arraylength: " + array.length);
      if (array != null)
      {
          for (int i = 0; i < array.length; i++)
          {
            if (i!= 0)
              sBuffer.append(",");
            sBuffer.append( array[i].toString() );
            traza(array[i].toString() );
          }
      }

      return sBuffer.toString();
	}
	  
    private Map parseaUnidades(String sCadena) throws Exception {
        traza(" ---- parseaUnidades ----");
        traza("sCadena: " + sCadena);
        StringTokenizer tok = new StringTokenizer(sCadena, "|");
        Map unidades = new HashMap();
        	
        int i = 0;
        while ( tok.hasMoreTokens() ) {
           String sToken = tok.nextToken();
           traza("sToken: " + sToken);
           
           StringTokenizer tokAux = new StringTokenizer(sToken, "_");
           String claveUA = tokAux.nextToken();
           String valorUA = tokAux.nextToken();
           
           if(valorUA.equals("NULL")) {
        	   valorUA = null;
           }
           
           unidades.put(claveUA, valorUA);
        }

        traza(" ---- End parseaUnidades ----");

        return unidades;
    }

    private void anhadirFilaVacia(ArrayList listMapFila, int fila) {
        Map mapFila = new HashMap();
        mapFila.put("numeroFila", String.valueOf(fila));
        mapFila.put("codigoRegion", "");
        mapFila.put("codigoZona", "");
        mapFila.put("mensajeError", "error.noRegistroFila");
        listMapFila.add(mapFila);               
    }

    private boolean validoFormatoPuntaje(String numeroPuntaje) {
        boolean valor=true;
        try{
                Double.parseDouble(numeroPuntaje);
        }catch(Exception e){
                valor=false;
        }
        return valor;
    }

    private Map obtenerErrores() {
    	String msgCodigoRegionVacio = conectorParametro("msgCodigoRegionVacio");
    	String msgCodigoZonaVacio = conectorParametro("msgCodigoZonaVacio");
    	String msgUnidadesVacio = conectorParametro("msgUnidadesVacio");
    	String msgNoRegistroFila = conectorParametro("msgNoRegistroFila");
    	String msgNoExisteRegion = conectorParametro("msgNoExisteRegion");
    	String msgNoExisteZona = conectorParametro("msgNoExisteZona");
    	String msgNoFormatoNumeroUnidades = conectorParametro("msgNoFormatoNumeroUnidades");
    	
    	Map errores = new HashMap();
    	errores.put("error.codigoRegionVacio", msgCodigoRegionVacio);
    	errores.put("error.codigoZonaVacio", msgCodigoZonaVacio);
    	errores.put("error.unidadesVacio", msgUnidadesVacio);
    	errores.put("error.noRegistroFila", msgNoRegistroFila);
    	errores.put("error.noExisteRegion", msgNoExisteRegion);
    	errores.put("error.noExisteZona", msgNoExisteZona);
    	errores.put("error.noFormatoNumeroUnidades", msgNoFormatoNumeroUnidades);

    	return errores;
    }
    
}
