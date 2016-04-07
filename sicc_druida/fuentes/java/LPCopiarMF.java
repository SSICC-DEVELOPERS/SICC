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
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.pre.DTOECopiarMF;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

public class LPCopiarMF extends LPSICCBase{
//------------------------------------------------------------------------------
    private String accion;
//------------------------------------------------------------------------------
    public LPCopiarMF(){
        super();
    }
//------------------------------------------------------------------------------
    public void inicio() throws Exception {
       //pagina("contenido_matriz_facturacion_copiar");
    }
//------------------------------------------------------------------------------
    public void ejecucion() throws Exception {
        accion = conectorParametroLimpia("accion", "", true);
        setTrazaFichero();
        traza("Accion: " + accion);
        try{
			
			String oidProgramaFidelizacion = conectorParametroLimpia("cbProgramaFidelizacion","",true);
			String oidVariante = conectorParametroLimpia("cbVariante","",true);
			// vbongiov -- Cambio 20080746 -- 29/10/2008
			String ckOrdenarCodVenta = conectorParametroLimpia("ckOrdenarCodVenta","",true);
			String oidTipoOferta = conectorParametroLimpia("cbTipoOferta","",true);


            if( accion.equals("") ){
              pagina("contenido_matriz_facturacion_copiar");
              getConfiguracionMenu();
              limpiarSesion();
			  cargarCombosPriviledges();
            }
			
            if( accion.equals("Seleccionar matriz origen") ){
                conectorParametroSesion("oidMFOrigen", "");
                conectorParametroSesion("marcaOrigen", "");
                conectorParametroSesion("canalOrigen", "");
                conectorParametroSesion("periodoOrigen", "");
				//enozigli 13/10/2005
				conectorParametroSesion("oidProgramaFidelizacion", oidProgramaFidelizacion);
				conectorParametroSesion("oidVariante", oidVariante);
				//enozigli 13/10/2005

				// vbongiov -- Cambio 20080746 -- 29/10/2008
				conectorParametroSesion("indOrdenarCodVenta", ckOrdenarCodVenta);
				conectorParametroSesion("oidTipoOferta", oidTipoOferta);

                seleccionarMatrizOrigen();        
            }

            if( accion.equals("Seleccionar matriz nueva") ){
                traza("entro por nueva");
                conectorParametroSesion("oidMFNueva", "");
        		conectorParametroSesion("marcaNueva", "");
                conectorParametroSesion("canalNueva", "");
                conectorParametroSesion("periodoNueva", "");
				//enozigli 13/10/2005
				conectorParametroSesion("oidProgramaFidelizacion", oidProgramaFidelizacion);
				conectorParametroSesion("oidVariante", oidVariante);
				//enozigli 13/10/2005

				// vbongiov -- Cambio 20080746 -- 29/10/2008
				conectorParametroSesion("indOrdenarCodVenta", ckOrdenarCodVenta);
				conectorParametroSesion("oidTipoOferta", oidTipoOferta);

                seleccionarMatrizNueva();      
            }
  
            if( accion.equals("Matriz seleccionada") ){
                pagina("contenido_matriz_facturacion_copiar");
                getConfiguracionMenu();
				cargarCombosPriviledges();
                matrizSeleccionada();
            }
        
            if( accion.equals("Copiar") ){
                copiarMatriz();
            }
             

        }catch ( Exception e )  {
            lanzarPaginaError(e);
            logStackTrace(e);
        }
    }
//------------------------------------------------------------------------------
    private void seleccionarMatrizOrigen() throws Exception{
        String limpia = conectorParametroLimpia("hidLimpia","",true);
        traza("limpia; " + limpia);
        if(limpia.equals("SI")){ 
            limpiarSesion();
    		}
        traza("entro en seleccionar matriz origen");
        conectorParametroSesion("matrizOrigen", new Boolean(true));
        conectorParametroSesion("UltimaLP", "LPCopiarMF");
        conectorAction("LPSeleccionarMF");
        conectorActionParametro("nueva", "");
        // Agregado por SICC20070322 - Rafael Romero - 2/07/2007
        conectorActionParametro("accion", "ElegirMatriz");
        // Fin agregado SICC20070322
    }
//------------------------------------------------------------------------------
    private void seleccionarMatrizNueva() throws Exception{
        String limpia = conectorParametroLimpia("hidLimpia","",true);
        if( limpia.equals("SI")){ 
            limpiarSesion();
        }
        conectorParametroSesion("matrizOrigen",new Boolean(false));
        conectorParametroSesion("UltimaLP", "LPCopiarMF");
        conectorAction("LPSeleccionarMF");
        conectorActionParametro("nueva", "true");
        // Agregado por SICC20070322 - Rafael Romero - 2/07/2007
        conectorActionParametro("accion", "ElegirMatriz");
        // Fin agregado SICC20070322
    }
    
    private void matrizSeleccionada() throws Exception{
        // Recoge de sesión el identificador de la matriz seleccionada (oidCabeceraMF) 
        // Crea el idBusiness = "PREConsultarCabeceraMF" 
        // Crea un DTOOID con: 
        //  - oid = oidCabeceraMF 
        // Invoca a ConectorConsultarCabeceraMF 
        // Recupera el DTOSalida devuelto por el conector 
        // Recupera de sesión la variable matrizOrigen
        // Si matrizOrigen == True 
        // { 
        // Guarda en sesión la variable oidMFOrigen = oidCabeceraMF (Para guardar el oid de la matriz seleccionada) 
        //  Muestra la información de la matriz original:  
        //  - Marca: DTOSalida.descripcionMarca 
        //  - Canal: DTOSalida.descripcionCanal 
        //  - Periodo: DTOSalida.descripcionPeriodo   
        // }  
        // Si matrizOrigen == False 
        // { 
        // Guarda en sesión la variable oidMFNueva = oidCabeceraMF (Para guardar el oid de la matriz seleccionada) 
        // Muestra la información de la matriz nueva:  
        //  - Marca: DTOSalida.descripcionMarca 
        //  - Canal: DTOSalida.descripcionCanal 
        //  - Periodo: DTOSalida.descripcionPeriodo   
        // }  

		//enozigli 13/10/2005
		String soidProgramaFidelizacion = (String)conectorParametroSesion("oidProgramaFidelizacion");
		String soidVariante = (String)conectorParametroSesion("oidVariante");
		asignarAtributo("VAR", "hoidProgramaFidelizacion", "valor", soidProgramaFidelizacion );	
		asignarAtributo("VAR", "hoidVariante", "valor", soidVariante );	
		//enozigli 13/10/2005

		// vbongiov -- Cambio 20080746 -- 29/10/2008
		String sIndOrdenarCodVenta = (String)conectorParametroSesion("indOrdenarCodVenta");
		String soidTipoOferta = (String)conectorParametroSesion("oidTipoOferta");

		traza("sIndOrdenarCodVenta: " + sIndOrdenarCodVenta);
		traza("soidTipoOferta: " + soidTipoOferta);

		asignarAtributo("VAR", "hIndOrdenarCodVenta", "valor", sIndOrdenarCodVenta );	
		asignarAtributo("VAR", "hoidTipoOferta", "valor", soidTipoOferta );	

        //Si se selecciono una matriz, se recuperan de sesion los datos de la matriz
        Long oidCabeceraMF = (Long)conectorParametroSesion("oidCabeceraMF");
        String marca = (String)conectorParametroSesion("descripcionMarca");
        String canal = (String)conectorParametroSesion("descripcionCanal");
        String periodo = (String)conectorParametroSesion("descripcionPeriodo");

        Boolean matrizOrigen = (Boolean)conectorParametroSesion("matrizOrigen");
        //Si matrizOrigen es verdadero, se selecciono la matriz de origen
               
        if( matrizOrigen.booleanValue() ){
            Long oidCabeceraMFOrigen = oidCabeceraMF;
            String marcaOrigen = marca;
            String canalOrigen = canal;
            String periodoOrigen = periodo;
            Long oidCabeceraMFNueva = (conectorParametroSesion("oidMFNueva") != ""?(Long)conectorParametroSesion("oidMFNueva"):null);
            String marcaNueva = (String)conectorParametroSesion("marcaNueva");
            String canalNueva = (String)conectorParametroSesion("canalNueva");
            String periodoNueva = (String)conectorParametroSesion("periodoNueva");
            conectorParametroSesion("oidMFOrigen", oidCabeceraMF);
            conectorParametroSesion("marcaOrigen", marca);
            conectorParametroSesion("canalOrigen", canal);
            conectorParametroSesion("periodoOrigen", periodo);

            if( marcaOrigen != null ){
                asignarAtributo("LABELC", "lblMarca1XX", "valor", marcaOrigen );					
                asignarAtributo("VAR", "marcaOriginal", "valor", marcaOrigen );					
            }else{
                asignarAtributo("LABELC", "lblMarca1XX", "valor", "" );
            }

            if( canalOrigen != null ){
                asignarAtributo("LABELC", "lblCanal1XX", "valor",  canalOrigen );					
            }else{
                asignarAtributo("LABELC", "lblCanal1XX", "valor", "" );
            }

            if( periodoOrigen != null ){
                asignarAtributo("LABELC", "lblPeriodo1XX", "valor", periodoOrigen );
            }else{
                asignarAtributo("LABELC", "lblPeriodo1XX", "valor", "" );
    				
            }

            if( marcaNueva != null ){
                asignarAtributo("LABELC", "lblMarca2XX", "valor", marcaNueva );					
                asignarAtributo("VAR", "marcaNueva", "valor", marcaNueva );					
            }else{
                asignarAtributo("LABELC", "lblMarca2XX", "valor", "" );									
            }

            if( canalNueva != null ){
                asignarAtributo("LABELC", "lblCanal2XX", "valor",  canalNueva );					
            }else{
                asignarAtributo("LABELC", "lblCanal2XX", "valor", "" );
            }

            if( periodoNueva != null ){
                asignarAtributo("LABELC", "lblPeriodo2XX", "valor", periodoNueva );
            }else{
                asignarAtributo("LABELC", "lblPeriodo2XX", "valor", ""  );
            }
        }else{
            Long oidCabeceraMFNueva = oidCabeceraMF;
            String marcaNueva = marca;
            String canalNueva = canal;
            String periodoNueva = periodo;
            Long oidCabeceraMForigen = (conectorParametroSesion("oidMFOrigen") != ""?(Long)conectorParametroSesion("oidMFOrigen"):null);
            String marcaOrigen = (String)conectorParametroSesion("marcaOrigen");
            String canalOrigen = (String)conectorParametroSesion("canalOrigen");
            String periodoOrigen = (String)conectorParametroSesion("periodoOrigen");
            conectorParametroSesion("oidMFNueva", oidCabeceraMF);
            conectorParametroSesion("marcaNueva", marca);
            conectorParametroSesion("canalNueva", canal);
            conectorParametroSesion("periodoNueva", periodo);
				
            if( marcaOrigen != null ){
                asignarAtributo("LABELC", "lblMarca1XX", "valor", marcaOrigen );					
                asignarAtributo("VAR", "marcaOriginal", "valor", marcaOrigen );					
            }else{
                asignarAtributo("LABELC", "lblMarca1XX", "valor", "" );
            }

            if( canalOrigen != null ){
                asignarAtributo("LABELC", "lblCanal1XX", "valor",  canalOrigen );					
            }else{
                asignarAtributo("LABELC", "lblCanal1XX", "valor", "" );
            }

            if( periodoOrigen != null ){
                asignarAtributo("LABELC", "lblPeriodo1XX", "valor", periodoOrigen );
            }else{
                asignarAtributo("LABELC", "lblPeriodo1XX", "valor", "" );
            }

            if( marcaNueva != null ){
                asignarAtributo("LABELC", "lblMarca2XX", "valor", marcaNueva );					
                asignarAtributo("VAR", "marcaNueva", "valor", marcaNueva );					
            }else{
                asignarAtributo("LABELC", "lblMarca2XX", "valor", "" );									
            }

            if( canalNueva != null ){
                asignarAtributo("LABELC", "lblCanal2XX", "valor",  canalNueva );					
            }else{
                asignarAtributo("LABELC", "lblCanal2XX", "valor", "" );
            }

            if( periodoNueva != null ){
                asignarAtributo("LABELC", "lblPeriodo2XX", "valor", periodoNueva );
            }else{
                asignarAtributo("LABELC", "lblPeriodo2XX", "valor", ""  );
            }
        }
    }

   private void copiarMatriz() throws Exception{
        pagina("salidaGenerica");
		String scbProgramaFidelizacion = conectorParametro("cbProgramaFidelizacion");
		String scbVariante = conectorParametro("cbVariante");

        DTOECopiarMF dto = new DTOECopiarMF();
        dto.setOidOrigen((Long)conectorParametroSesion("oidMFOrigen"));
        dto.setOidNueva((Long)conectorParametroSesion("oidMFNueva"));
		try {
			dto.setCodigoProgramaFidelizacion(new Long(scbProgramaFidelizacion));	
		} catch (NumberFormatException ne){	
			traza("Programa de Fidelizacion no seleccionado");
		}
		try {
			dto.setVariante(new Long(scbVariante));	
		} catch (NumberFormatException ne) {	
			traza("Variante no seleccionado");
		}		

		 // vbongiov -- Cambio 20080746 -- 29/10/2008
		String ckOrdenarCodVenta = conectorParametroLimpia("ckOrdenarCodVenta", "", true);
		String cbTipoOferta = conectorParametroLimpia("cbTipoOferta", "", true);
		
		dto.setIndOrdenarCodVenta(ckOrdenarCodVenta.equals("S")?Boolean.TRUE:Boolean.FALSE);
		dto.setOidTipoOferta(cbTipoOferta.equals("")?null:Long.valueOf(cbTipoOferta));


        MareBusinessID id = new MareBusinessID("PRECopiarMF");
        Vector parametros = new Vector();
        parametros.add(dto);
        parametros.add(id);
        conectar("ConectorCopiarMF", parametros);
        limpiarSesion();
        asignarAtributo("VAR", "ejecutar", "valor","despuesDeCopiar()");					
    }
    private void limpiarSesion() throws Exception {
        traza("entro a limpiar sesion");
        this.getRequest().getSession().removeAttribute("oidMFNueva");
        this.getRequest().getSession().removeAttribute("marcaNueva");
        this.getRequest().getSession().removeAttribute("canalNueva");
        this.getRequest().getSession().removeAttribute("periodoNueva");
        this.getRequest().getSession().removeAttribute("oidMFOrigen");
        this.getRequest().getSession().removeAttribute("marcaOrigen");
        this.getRequest().getSession().removeAttribute("canalOrigen");
        this.getRequest().getSession().removeAttribute("periodoOrigen");
        asignarAtributo("VAR", "hidLimpia", "valor","");					
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2=(MareException)e;
            traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
    }
//**********************************************************************************

   	private void cargarCombosPriviledges() throws Exception {
		traza(" >>>>Entra en cargarCombosPriviledges ");
		ComposerViewElementList cv = crearParametrosEntrada();
		traza(" >>>Se crearon Parametros de Entrada ");
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		traza(" >>>Se ejecuto el conector ");
		DruidaConector resultados = conector.getConector();
		asignar("COMBO", "cbProgramaFidelizacion", resultados, "MAEObtenerProgramasFidelizacion");
		asignar("COMBO", "cbVariante", resultados, "PREObtenerVariantes");
		// vbongiov -- Cambio 20080746 -- 29/10/2008
		asignar("COMBO", "cbTipoOferta", resultados, "PREObtenerTipoOfertaCopiar");
		traza(" >>>Se asignaron los valores ");

	}

	private ComposerViewElementList crearParametrosEntrada() throws Exception {
        ComposerViewElementList lista = new ComposerViewElementList(); 
        DTOBelcorp dtobcp = new DTOBelcorp();
 		UtilidadesSession sesion = new UtilidadesSession();

		dtobcp.setOidIdioma(sesion.getIdioma(this));
        dtobcp.setOidPais(sesion.getPais(this));

		ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("MAEObtenerProgramasFidelizacion");         
        ci1.setDTOE(dtobcp);
        lista.addViewElement(ci1);


		ComposerViewElement ci2 = new ComposerViewElement();
        ci2.setIDBusiness("PREObtenerVariantes");         
        ci2.setDTOE(dtobcp);
        lista.addViewElement(ci2);

        // vbongiov -- Cambio 20080746 -- 29/10/2008
		ComposerViewElement ci3 = new ComposerViewElement();
        ci3.setIDBusiness("PREObtenerTipoOfertaCopiar");         
        ci3.setDTOE(dtobcp);
        lista.addViewElement(ci3);

        return lista;

    }
//**********************************************************************************
}
