import es.indra.druida.DruidaConector;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.logicanegocio.com.ConstantesCOMPestanyas;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.com.DTOComisionesAccesos;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LPDosMantenimientoComisionesDatosGenerales extends LPComisiones {
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   

	private String idPestanyaDest;
  
	private String oidPlantilla = null;     
	private String indComparativo = null;     
	private String indTratamientoDif = null;     
	private String oidCanal = null;       //oid del canal
	private String canal = null;          //descripcion del canal
	private String marca = null;  
	private String acceso = null;
	private String periodoDesde = null;
	private String periodoHasta = null;
	private String periodosEspera = null;

	private String opcionMenu = null;

	public LPDosMantenimientoComisionesDatosGenerales() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception {       
		setTrazaFichero();    
  		traza("************ Entre a LPDosMantenimientoComisionesDatosGenerales");
		accion = conectorParametroLimpia("accion", "", true);
 		traza("************ accion:" + accion);
	  
		sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);
		
		try {
			
			/*Diseño Técnico 15/03/2005 ajpoyato
			----------------------------------------------------------
			Todas estas llamadas deben hacerse a "LPMantenimientoComisionesDatosGenerales" con acción "" y
			opcionMenu = "consultar", también se pasa el oid de la comisión que se está consultando. */

			/* Si (accion == "") entonces 
				-> idPestanya = ConstantesCOMPestanyas.PESTANYA_DATOS_GENERALES 
				-> ejecutar "inicializar()" 
				-> ejecutar "cargarPantalla()"  */
			if(accion.equals(""))  
			{
				pagina("contenido_comisiones_datosGenerales_insertar");
				traza("************ Llamando a getFormatosValidaciones");
				getFormatosValidaciones();
				idPestanya = ConstantesCOMPestanyas.PESTANYA_DATOS_GENERALES;		
        
				oidCanal = conectorParametroLimpia("oidCanal", "", true);
				oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);
				canal = conectorParametroLimpia("canal", "", true);
				indComparativo = conectorParametroLimpia("indComparativo", "", true);
				indTratamientoDif = conectorParametroLimpia("indTratamientoDif", "", true);
				opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
                
				traza("ACCION = \" \" ");
				traza("************ oidPlantilla:" + oidPlantilla);
				traza("************ canal:" + canal);
				traza("************ indComparativo:" + indComparativo);
				traza("************ indTratamientoDif:" + indTratamientoDif);
				traza("************ oidCanal:" + oidCanal);    
				traza("************ opcionMenu:" + opcionMenu);    
				
				inicializar();

				//cargarPantalla();
        
				if((indComparativo.equals("")) && (indTratamientoDif.equals(""))) {
				  cargarPantalla(new Long(oidPlantilla), canal, null, null, new Long(oidCanal));                 
				}
				if(!(indComparativo.equals("")) && (indTratamientoDif.equals(""))) {
				  cargarPantalla(new Long(oidPlantilla), canal, new Boolean(indComparativo),
				  null, new Long(oidCanal));                 
				}
				if((indComparativo.equals("")) && (!indTratamientoDif.equals(""))) {
				  cargarPantalla(new Long(oidPlantilla), canal, null,
				  new Boolean(indTratamientoDif), new Long(oidCanal));                 
				}
				if((!indComparativo.equals("")) && (!indTratamientoDif.equals(""))) {
				  cargarPantalla(new Long(oidPlantilla), canal, new Boolean(indComparativo),
				  new Boolean(indTratamientoDif), new Long(oidCanal));                 
				}
        


                traza("************ Llamando a anyadeHiddensI18N");
                //anyadeHiddensI18N(true, "COM_COMIS", null, new Integer(1), "formulario", "txtDescripcionComision", false);
			}
			else if(accion.equals("cargar")) {       
				idPestanya = ConstantesCOMPestanyas.PESTANYA_DATOS_GENERALES;
				//cargarPantalla();				
			}
			else if(accion.equals("almacenar")) {           
        almacenar();
        idPestanyaDest = conectorParametroLimpia("idPestanyaDest", "", true);
        this.marcaTemp = marca;
        this.canalTemp = oidCanal;     
        
        traza("************ marcaTemp " + marcaTemp);
        traza("************ canalTemp " + canalTemp);
        redirigir(new Integer(idPestanyaDest));
			}
			else if(accion.equals("guardar")) {
				almacenar();
				try {      
					this.guardar();
					asignarAtributo("VAR","ejecutar","valor","reInicio()");   
				}
				catch(Exception e) {
				  asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");          
				  throw e;
				}        
			}
      if(accion.equals(""))  {
        cargarMenuSecundario();
      }			
		}
		catch(Exception e)  {
      //preservaHiddensI18n(new Integer(1), "COM_COMIS", "formulario", "txtDescripcionComision", false);
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace(); 
			e.getMessage();
			lanzarPaginaError(e);
		} 
	}
 
 /*
	Si ((opcionMenu == "consultar")||(opcionMenu == "modificar")) entonces 
	Recuperar los datos de la comisión 
	Obtener el oid de comisión de la ventana llamante y crear un DTOOID 
	Crear idBusiness == "COMConsultarComisiones" 
	Asignar conector "ConectorConsultarComisiones" 
	Llamar al método "setComision()" pasando el DTOComisiones recuperado 
	Para el Estado de la comisión "Solicitud Autorizada", únicamente
	aparecerán habilitados para la modificación los siguientes: 
	Pestaña Datos Generales de la Comisión: Período Hasta y Número de períodos de espera 
	Fin Si */
 public void inicializar() throws Exception 
 {
    traza("************* Entre a inicializar");
	if((opcionMenu.equals("consultar")) || (opcionMenu.equals("modificar"))) 
	{
		traza(" obtiene varOidPlantilla = oid de comisión ");
		oidPlantilla = conectorParametroLimpia("varOidPlantilla", "", true);

		traza(" oidComision = varOidPlantilla :  " + oidPlantilla);
		DTOOID dtoe = new DTOOID();
		dtoe.setOid(new Long(oidPlantilla));


		MareBusinessID businessID = new MareBusinessID("COMConsultarComisiones");
		Vector params = new Vector();
        params.add(dtoe); params.add(businessID);
		traza(" conectar:  ConectorConsultarComisiones ");
		DruidaConector con = conectar("ConectorConsultarComisiones", params);        

		DTOComisiones dtoComisiones = this.getComision(); 
		if(dtoComisiones==null) 
		{
		  traza("************* DTOComisiones es null");    
		  dtoComisiones = new DTOComisiones();  
		}  

		traza("************* Antes de llamar a setComision");    
        this.setComision(dtoComisiones); 


	} 
 }
  
  public void cargarPantalla(Long oidPlantilla, String canal,
  Boolean indComparativo, Boolean indTratamientoDif, Long oidCanal) throws Exception {
      traza("************* Entre a cargarPantalla");
      traza("************* oidPlantilla " + oidPlantilla);
      traza("************* canal " + canal);
      traza("************* indComparativo " + indComparativo);
      traza("************* indTratamientoDif " + indTratamientoDif);
      traza("************* oidCanal " + oidCanal);
      
      asignarAtributo("LABELC", "lbldtCanal", "valor", canal);          
      asignarAtributo("VAR", "varOidPlantilla", "valor", oidPlantilla.toString());
      asignarAtributo("VAR", "varOidCanal", "valor", oidCanal.toString());
      
      if(indComparativo!=null) {
        if(indComparativo.booleanValue()==true) {
          asignarAtributo("VAR", "varIndComparativo", "valor", "true");
        }
        else {
          asignarAtributo("VAR", "varIndComparativo", "valor", "false");
        }
      }
      
      if(indTratamientoDif!=null) {
        if(indTratamientoDif.booleanValue()==true) {
          asignarAtributo("VAR", "varIndTratamientoDif", "valor", "true");
        }
        else {
          asignarAtributo("VAR", "varIndTratamientoDif", "valor", "false");
        }
      }

	  if(opcionMenu.equals("consultar")) 
	  {
		/*
		Si estamos en CU de Consulta no se cargan los combos de
		periodos y se deshabilitan el deshabilitar los botones añadir, modificar y eliminar 
		*****PENDIENTE INCIDENCIA***********
		*/

        ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
      
		traza("************ Asignando datos a los combos");    
		asignar("COMBO", "cbMarca", resultados, "COMMarcasPlantilla");
		asignar("COMBO", "cbAcceso", resultados, "COMAccesosPlantilla");
		asignarAtributo("VAR", "varPais", "valor", sPais);
		asignarAtributo("VAR", "varIdioma", "valor", sIdioma);

	  }
	  else if((opcionMenu.equals("insertar")) || (opcionMenu.equals("modificar"))) {
		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
      
		traza("************ Asignando datos a los combos");    
		asignar("COMBO", "cbMarca", resultados, "COMMarcasPlantilla");
		asignar("COMBO", "cbAcceso", resultados, "COMAccesosPlantilla");
		asignarAtributo("VAR", "varPais", "valor", sPais);
		asignarAtributo("VAR", "varIdioma", "valor", sIdioma);
	  }
	  else if((opcionMenu.equals("consultar")) || (opcionMenu.equals("modificar"))) {
		/*
		Si estamos en el CU de Consulta ó Modificación hacer 
		-> Llamar al método "getComision()" y obtener el DTOComisiones 
		-> Mapear en pantalla los datos necesarios tomándolos del dto
		DTOComisiones obtenido 
		Fin Si 
		*/
		 DTOComisiones dtoComisiones = this.getComision();



	  }

	  /*Las pestañas "Productos", "Clientes" deben estar deshabilitadas
		mientras no estén rellenos todos los datos obligatorios de la
		pantalla de datos generales, entre ellos las marcas, accesos y periodos.  */
	}
  
	private ComposerViewElementList crearParametrosEntrada(){    
		DTOOID dtoOid = new DTOOID();
	    dtoOid.setOid(new Long(oidPlantilla));
		dtoOid.setOidIdioma(lIdioma);
	    dtoOid.setOidPais(lPais);
		
	    ComposerViewElementList lista = new ComposerViewElementList(); 
		
		//Primer combo
		ComposerViewElement cve1 = new ComposerViewElement();
		cve1.setIDBusiness("COMAccesosPlantilla");
		cve1.setDTOE(dtoOid);
    
	    //Segundo combo
		ComposerViewElement cve2 = new ComposerViewElement();
		cve2.setIDBusiness("COMMarcasPlantilla");
		cve2.setDTOE(dtoOid);
    
		lista.addViewElement(cve1);
		lista.addViewElement(cve2);
    
		return lista;
	}
  
  public void almacenar () throws Exception {
    traza("************* Entre a almacenar");    
    
    pagina("salidaGenerica");
    
    marca = conectorParametroLimpia("marca", "", true);
    oidCanal = conectorParametroLimpia("canal", "", true);
    acceso = conectorParametroLimpia("acceso", "", true);
    periodoDesde = conectorParametroLimpia("periodoDesde", "", true);
    periodoHasta = conectorParametroLimpia("periodoHasta", "", true);
    periodosEspera = conectorParametroLimpia("periodosEspera", "", true);
    indComparativo = conectorParametroLimpia("comparativo", "", true);
    indTratamientoDif = conectorParametroLimpia("indTratamientoDif", "", true);
    oidPlantilla = conectorParametroLimpia("varOidPlantilla", "", true);
    
    traza("************* marca " + marca);
    traza("************* oidCanal " + oidCanal);
    traza("************* acceso " + acceso);
    traza("************* periodoDesde " + periodoDesde);
    traza("************* periodoHasta " + periodoHasta);
    traza("************* periodosEspera " + periodosEspera);
    traza("************* indComparativo " + indComparativo);
    traza("************* indTratamientoDif " + indTratamientoDif);
    traza("************* oidPlantilla " + oidPlantilla);
    
    DTOComisiones dtoComisiones = this.getComision(); 
    if(dtoComisiones==null) {
      traza("************* DTOComisiones es null");    
      dtoComisiones = new DTOComisiones();  
    }   
    
	//1° Seteando oid de marca
	dtoComisiones.setOidMarca(new Long(marca));
    dtoComisiones.setOidPlantillasComisionesPais(new Long(oidPlantilla));
	//2° Seteando oid de canal
    dtoComisiones.setOidCanal(new Long(oidCanal));
	//3° Seteando oids de accesos
	StringTokenizer stAccesos = new StringTokenizer(acceso,",");
	ArrayList listaAccesos = new ArrayList();
    
	while(stAccesos.hasMoreTokens()) {
		DTOComisionesAccesos dtoComisionesAccesos = new DTOComisionesAccesos();
	    String elementoI = stAccesos.nextToken();
        Long elem = new Long(elementoI);
        traza("************ elem: " + elem);
		dtoComisionesAccesos.setOidPlantillaComisionesAccesos(elem);	
		listaAccesos.add(dtoComisionesAccesos);
    }	
	dtoComisiones.setComisionesAccesos(listaAccesos);
	//4° Seteando oid de periodo desde
    dtoComisiones.setOidPeriodoDesde(new Long(periodoDesde));
	//5° Seteando oid de periodo hasta
    dtoComisiones.setOidPeriodoHasta(new Long(periodoHasta));
  	//6° Seteando cantidad periodos espera
    if(!periodosEspera.equals("")) {
      dtoComisiones.setPeriodosEspera(new Integer(periodosEspera));  
    } 
   	//7° Seteando indicador comparativo
    dtoComisiones.setComparativo(new Boolean(indComparativo));
  	//8° Seteando indicador tratamiento diferencial
    dtoComisiones.setTratamientoDiferencial(new Boolean(indTratamientoDif));   
    
    /*traza("************* Obteniendo vector");    
    Vector aTradu = this.recuperaTraduccionesI18N(new Integer(1));
    traza("************* Despues de obtener el vector");    
    DTOI18nSICC[] dtoI18NSicc = null;
    
    for(int i=0; i<aTradu.size(); i++) {
      DTOI18nSICC dtoI18n = (DTOI18nSICC)aTradu.get(i);
      traza("************* i " + i);
      traza("************* dtoI18n " + dtoI18n);
      dtoI18NSicc[i] = dtoI18n;
    }    
    
    dtoComisiones.setAttTraducible(dtoI18NSicc); */
    
    traza("************* Antes de llamar a setComision");    
    this.setComision(dtoComisiones); 
    
    //traza("************* Se guardo el DTOComisiones con la siguiente informacion");    
    //DTOComisiones dtoTemp = this.getComision(); 
    //traza("************* DTOComisiones " + dtoTemp);        
  }

	private void cargarMenuSecundario() throws Exception {     
		traza("************ Entre a cargarMenuSecundario");
	  	traza("************ accion " + accion);

		if (accion.equals("")) {
			getConfiguracionMenu("LPMantenimientoComisionesDatosGenerales","");
		}
   }
}