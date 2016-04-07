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


import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.bel.DTOCaja;
import es.indra.sicc.dtos.bel.DTOCargaPaginaMCD;
import es.indra.sicc.dtos.bel.DTOImporte;
import es.indra.sicc.dtos.bel.DTOImportesFisicos;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.math.BigDecimal;

 /**
 * Sistema:           Belcorp
 * Modulo:            BEL
 * Submódulo:         Cierre de Caja 
 * Componente:        Logica de Presentacion
 * Fecha:             08/11/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-BEL-201-374-N046
 * @version           1.0
 * @autor             Gustavo De Marzi
 */

public class LPCerrarUnaCaja extends LPSICCBase {

    private String accion = null;
    private String idioma = null;
    private String paisDescripcion = null;
    private String pais = null;
	private String nroOportunidad = "0";

    public LPCerrarUnaCaja() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_caja_cerrar");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {

        // Obtenemos la accion el pais y el idioma.
        obtenerAccionPaisIdioma();
        traza("la accion es " + accion);
        try {
			
            if (accion.equals("")) {
                cargarPagina(); 
            }else if(accion.equals("guardar")){
                guardar();
            }else if(accion.equals("anyadir")){
                anyadir();
            }else if(accion.equals("modificar")){
                modificar();
            }
			getFormatosValidaciones();
            getConfiguracionMenu();
            
        } catch (Exception ex ) {
			      logStackTrace(ex);
            lanzarPaginaError(ex);
            asignarAtributo("VAR","hIdioma", "valor",idioma);
            asignarAtributo("VAR","hPais", "valor", pais);
            asignarAtributo("VAR","hPaisDescripcion", "valor", paisDescripcion);
        }
    }


    /**
     * Obtiene la accion y el pais.
     */
    private void obtenerAccionPaisIdioma() throws Exception {
        //manejo de traza
        setTrazaFichero();

        //Obtiene accion       
        accion = conectorParametro("accion");
        if (this.accion==null){
           this.accion = "";
           asignarAtributo("VAR","accion","valor",accion);
           traza("accion: " + this.accion);
        }

        //Obtiene idioma
        idioma = conectorParametro("hIdioma"); 
        if ((idioma == null) || ((idioma != null) && idioma.equals(""))){
            idioma = (UtilidadesSession.getIdioma(this)).toString();
    		    traza("idioma:  " + this.idioma);
            asignarAtributo("VAR", "hIdioma", "valor", this.idioma);
        }

        //Obtiene el pais
        pais = conectorParametro("hPais"); 
        paisDescripcion = conectorParametro("hPaisDescripcion"); 
        if ((pais == null) || ((pais != null) && pais.equals(""))) {
			     pais = UtilidadesSession.getPais(this).toString();
			     paisDescripcion = UtilidadesSession.getDescripcionPais(this);
    		   traza("pais: " + this.pais);
    		   traza("paisDescripcion: " + this.paisDescripcion);
           asignarAtributo("VAR", "hPais", "valor", pais);
           asignarAtributo("VAR", "hPaisDescripcion", "valor", paisDescripcion);
        }
    }


    /** mdolce 11/11/204
     * metodo para la carga inicial de la pantalla
     */
    private void cargarPagina() throws Exception {
        // -> Obtener la dirección IP del cliente a través del request
        getConfiguracionMenu();
        String ipCliente = UtilidadesBelcorp.getIPCliente(this);
        traza("IPCliente: " + ipCliente);
        // -> Crear objeto DTOString, asignando a su atributo "cadena" la dirección IP obtenida en la actividad anterior y el idioma y pais de la sesión 
        DTOString dtoString = new DTOString();
        traza("paso 1 ");
        dtoString.setCadena(ipCliente);
        traza("paso 2 ");
        dtoString.setOidPais(new Long(this.pais));
        traza("paso 3 ");
        dtoString.setOidIdioma(new Long(this.idioma));
        // -> Crear idBusiness = "BELObtenerDatosCaja"
        traza("paso 4 ");
        Vector paramEntrada = new Vector();
        traza("paso 5 ");
        paramEntrada.add(dtoString);
        traza("paso 6 ");
        paramEntrada.add(new MareBusinessID("BELObtenerDatosCaja"));
        traza("paso 7 ");
        traza("BELObtenerDatosCaja dtoString: " + dtoString);
        // -> Asignar conector "ConectorObtenerDatosCaja" con idBusiness y dto creados 
        DruidaConector conectorObtenerDatosCaja = conectar("ConectorObtenerDatosCaja", paramEntrada);
        traza("despues de BELObtenerDatosCaja");
        
        // -> Crear variable llamada "caja" de tipo DTOCaja
        DTOCaja caja = new DTOCaja();
        /// -> Recuperar DTOCaja de respuesta a la asignación del conector y guardarlo en "caja" 
        caja = (DTOCaja)conectorObtenerDatosCaja.objeto("dtoSalida");
        traza("caja: " + caja);
        traza("la constante es " + ConstantesBEL.CAJA_CERRADA);
        traza("el tipo caja " + caja.getOidTipoCaja());

        String estadoCaja      = caja.getEstadoCaja();
        String constanteEstado = ConstantesBEL.CAJA_CERRADA.toString();

        if(estadoCaja.equals(constanteEstado)){
           traza("esta en el primer if");
           throw new MareException(new Exception(), 30103);
          
       //    -> No mostrar página, volver a la página de inicio            
//        }else if(caja.getOidTipoCaja().longValue() != ConstantesBEL.OID_TIPO_CAJA_NORMAL.longValue()){
	}else if(!caja.getOidTipoCaja().equals(ConstantesBEL.OID_TIPO_CAJA_NORMAL)){
                   throw new MareException(new Exception(), 30107);
                  //     -> No mostrar página, volver a la página de inicio*/
              }else{
                 traza("entro en el ultimo else subacceso " + caja.getOidSubacceso().toString());
                 asignarAtributo("VAR", "hSubacceso", "valor", caja.getOidSubacceso().toString());
                 asignarAtributo("VAR", "hCaja", "valor", caja.getOidCaja().toString());
               }


    }


    /** mdolce 11/11/2004
     * metodo para guardar las cajas cerradas
     */
    private void guardar() throws Exception {

	   /* Incidencia 12456 */
	   pagina("salidaGenerica");
      /* fin Incidencia 12456 */

       DTOImportesFisicos dto = new DTOImportesFisicos();
       MareBusinessID id = new MareBusinessID("BELCerrarCaja");
       ArrayList arr = new ArrayList();
       DruidaConector con = null;
       DTOBoolean dtoB = null;

       String listado = conectorParametroLimpia("hListado", "", true);
       if(listado.startsWith(";")){
          listado = " " + listado;
       }
       
       StringTokenizer tok = new StringTokenizer(listado, "|");
       
       while (tok.hasMoreTokens()) {

          DTOImporte dtoI = new DTOImporte();
          StringTokenizer tok2 = new StringTokenizer(tok.nextToken(), ";");
          traza("la cantidad " + tok2.countTokens());

          while(tok2.hasMoreTokens()){

            String str = new String();
            str = tok2.nextToken();
            
            traza("paso 1 " + str);
            
            if(!str.equals(" ")){
              traza("entro " + str);
              dtoI.setImporte(new BigDecimal(str));
            }

            str = tok2.nextToken(); 

            traza("paso 2 str "  + str);      

            if(!str.equals(" ")){
               traza("entro al 2 " + str);
               dtoI.setImporteDivisa(new BigDecimal(str));
            }

            str = tok2.nextToken(); 

            traza("paso 3 str " + str);      

            if(!str.equals(" ")){
               dtoI.setOidMedioPagoBelcenter(new Long(str));
            }

            
            str = tok2.nextToken();
            traza("paso 4  str" + str + "str");
			
            if(str !=null){
				traza("antes del trim ");
				//str = str.trim();
				if( !str.equals(" ") && !str.equals("") ){
				   traza("entrovcvxcvxv " + str);
	               dtoI.setOidMonedaAlternativa(new Long(str));
				}else {
				
					traza("str de mneerrr");
				}

			}
          }

          arr.add(dtoI);
        }
        
		String caja  = conectorParametroLimpia("hCaja", "", true);
        String subac = conectorParametroLimpia("hSubacceso", "", true);
		nroOportunidad = conectorParametroLimpia("hIdOportunidad", "", true);
		traza("antes de setear el dto  " + nroOportunidad);

		dto.setOidCaja(new Long(caja));
		traza("antes de setear el dto 1 ");
        dto.setOidSubacceso(new Long(subac));
		traza("antes de setear el dto  2");
        dto.setUsuario(UtilidadesSession.getIdUsuario(this));
		traza("antes de setear el dto  3");
        dto.setDetalle(arr);
		traza("antes de setear el dto  4");
        dto.setOidIdioma( UtilidadesSession.getIdioma( this ) );
		traza("antes de setear el dto  5");
        dto.setOidPais( UtilidadesSession.getPais( this ) );
		traza("antes de setear el dto  6");
		dto.setNroOportunidad( nroOportunidad.equals("")?null:new Integer(nroOportunidad) );
              
        traza("el dto es " + dto); 
        
        Vector param = new Vector();
        param.add(dto);
        param.add(id);

        con = conectar("ConectorCerrarCaja",param);

	    asignarAtributo("VAR", "hIdOportunidad", "valor", nroOportunidad);
		
		//***********************  Incidencia 12456   *********************


        if( con != null ){
           dtoB = (DTOBoolean)con.objeto( "DTOSalida" );

			traza(" nroOportunidad: "+ nroOportunidad);

			if(nroOportunidad.equals("1")){
				//como se deberia hacer un enviaOculto , deberia cerrar la pupop y quedar con la 
				//primer pantalla, siempre que el resultado sea DESCUADRADO

				traza("nroOportunidad.equals(1)");

				if(!dtoB.getValor()){
					traza("dtoB.getValor() false");
					//Debo tirar la Mare informando que la caja esta Descuadrada y que puede modificar
					//asignarAtributo("VAR", "nroOportunidad", "valor", nroOportunidad);
					throw new MareException(new Exception(), 30109);
				}else{
					asignarAtributo("VAR", "ejecutar", "valor", "reiniciar()");

					/*
					 traza("dtoB.getValor() true");
					 conectorAction("LPCerrarUnaCaja");
			         conectorActionParametro("accion", "");
					 throw new MareException(new Exception(), 30109);
					 */
				
				}

			}else {
					traza("no nroOportunidad.equals(1)");
				   if(dtoB.getValor()){
					   traza("dtoB.getValor() true");
				   //-> Si el dato que contiene es igual a "true" entonces mostrar mensaje con código "UIBEL0008 Caja Cuadrada"
					  pagina("contenido_caja_cerrar");
					  throw new MareException(new Exception(), 30108);
				   }else{
					   traza("dtoB.getValor() false");
				   //-> Si el dato que contiene es igual a "false" entonces mostrar mensaje con código "UIBEL0009 Caja Descuadrada"					  
					  pagina("contenido_caja_cerrar");
					  throw new MareException(new Exception(), 30109);
				   }
				  
			}			
		}
    }


    /** mdolce 11/11/2004
     * metodo para mostrar la modal para modificar o añadir
     */
    private void anyadir() throws Exception {
       pagina("contenido_caja_cerrar_detalle");
       cargarPaginaDetalle();        
    }


    /**
     * 
     */
    private void modificar() throws Exception {
       pagina("contenido_caja_cerrar_detalle");
       cargarPaginaDetalle();  

       String oidMedioPago  = conectorParametroLimpia("hMedioPago","", true);
       String oidMoneda     = conectorParametroLimpia("hMoneda","", true);
       String importe       = conectorParametroLimpia("hImporte", "", true);
       String importeDivisa = conectorParametroLimpia("hImporteDivisa", "", true);

       asignarAtributo("VAR", "hMedioPago", "valor", oidMedioPago);
       asignarAtributo("VAR", "hMoneda", "valor", oidMoneda);
       asignarAtributo("VAR", "hImporte", "valor", importe);
       asignarAtributo("VAR", "hImporteDivisa", "valor", importeDivisa);
       asignarAtributo("VAR", "accion", "valor", accion);
          
    }

   /**
     * 
     */
    private void cargarPaginaDetalle() throws Exception {
       traza("cgd paso 1");

       DTOOID            dtoe  = new DTOOID();
       traza("cgd paso 2");
     //  DTOBelcorp        dto   = new DTOBelcorp();
       traza("cgd paso 3");
       DTOCargaPaginaMCD dtoCP = new DTOCargaPaginaMCD();
       traza("cgd paso 4");

       String subacceso = conectorParametroLimpia("hSubacceso", "", true);
       traza("cgd paso 5  subacceso  " + subacceso);

       dtoe.setOid(subacceso.equals("")?null:new Long(subacceso));
       traza("cgd paso 6");
       dtoe.setOidPais( UtilidadesSession.getPais( this ) );
       traza("cgd paso 7");
       dtoe.setOidIdioma( UtilidadesSession.getIdioma( this ) );
       traza("cgd paso 8");        
       ComposerViewElementList lista = new ComposerViewElementList();
       traza("cgd paso 9");
    
       ComposerViewElement elem = null;
       traza("cgd paso 10");
       elem = new ComposerViewElement();
       traza("cgd paso 11");
       elem.setIDBusiness("BELObtenerMediosPagoBelcenter");

       traza("cgd paso 12");
       elem.setDTOE( dtoe );
       traza("cgd paso 13");
       lista.addViewElement( elem );
       traza("cgd paso 14");

       ConectorComposerView conector = null;
       traza("cgd paso 15");
       DruidaConector resultados = null;
       traza("cgd paso 16");
       
       conector = new ConectorComposerView(lista, this.getRequest());
       traza("cgd paso 17");
       conector.ejecucion();
       traza("cgd paso 18");

       resultados = null;
       traza("cgd paso 19");
       resultados = conector.getConector();
       traza("cgd paso 20");

       asignar("COMBO", "cbMedioPago", resultados, "BELObtenerMediosPagoBelcenter");
       traza("cgd paso 21");

       MareBusinessID id = new MareBusinessID("BELCargaPaginaMCD");
       traza("cgd paso 22");
       DruidaConector con = null;
       
       //dto.setOidPais( UtilidadesSession.getPais( this ) );
       traza("cgd paso 23");
       //dto.setOidIdioma( UtilidadesSession.getIdioma( this ) );
       traza("cgd paso 24");

       Vector param = new Vector();
       traza("cgd paso 25");
       param.add(dtoe);
       traza("cgd paso 26");
       param.add(id);
       traza("cgd paso 27");

       con = conectar("ConectorCargaPaginaMCD",param);
       traza("cgd paso 29");

       if( con != null ){
           dtoCP = (DTOCargaPaginaMCD)con.objeto( "dtoSalida" );
           asignarAtributo("VAR","hOidComboMoneda", "valor", dtoCP.getOidMonedaAlternativa().toString());
           asignarAtributo("VAR","hDescComboMoneda", "valor",  dtoCP.getDescripcionMonedaAlternativa());       
           asignarAtributo("VAR","hTipoCambio", "valor", dtoCP.getTipoCambio().toString());
       }
     
    }


    /**
     * Imprime el stack trace en caso de errores.
     */
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

}    
