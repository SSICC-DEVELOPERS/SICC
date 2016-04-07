//$Id: LPGenerarMensajesRecordatorios.java,v 1.1 2009/12/03 18:38:00 pecbazalar Exp $

/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobenenerdas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
/**
 * Sistema:           Belcorp
 * Modulo:            COB
 * Submódulo:         Cobranzas
 * Componente:        LP
 * Fecha:             28/02/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COB-201-324-N036
 *
 * @version           1.0
 * @author            Marta Aurora Montiel
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cob.DTOBuscarClientesAsignados;
import es.indra.sicc.dtos.cob.DTOGenerarMensajes;
import es.indra.sicc.util.DTOColeccion;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;


 public class LPGenerarMensajesRecordatorios extends LPSICCBase {

	 private String accion = "";
	 private Long pais = null;     
	 private Long idioma = null;
	 //DATOS OBTENIDOS DE PANTALLA GENERARA
	/* private String etapa = "";
	 private String marca = "";
	 private String canal = "";
	 private String periodo = "";
	 private String subVenta = "";
	 private String regionDesde = "";
	 private String regionHasta = "";
	 private String zonaDesde = "";
	 private String zonaHasta = "";
	 private String seccionDesde = "";
	 private String seccionHasta = "";
	 private String territorioDesde = "";
     private String territorioHasta = "";
	 private String oidSeleccionados = "";*/


		   

	 public void inicio() throws Exception {
			pagina("contenido_mensajes_recordatorios_generar");      
	  }
	  
	  public void ejecucion() throws Exception {    
			setTrazaFichero();   
			accion = conectorParametro("accion")==null?"":conectorParametro("accion");
			try{
                traza("+++++++++++ Inicializando LPGenerarMensajesRecordatorios +++++++++++++++");
				pais = UtilidadesSession.getPais(this);
			    idioma = UtilidadesSession.getIdioma(this);	
                
                traza("============== Idioma:  " + idioma);
                traza("============== Pais:    " + pais);
                traza("============== Accion:  " + accion);
				
				if(accion.equals("")){
					cargarPagina();				
				}else if (accion.equals("buscar"))
				{
					buscar();
				}
				
				else if(accion.equals("generarMensajes")){
					traza("1");
					generarMensajes();
					traza("2");
				}

			}catch(Exception e){
				lanzarPaginaError(e);
				
				ByteArrayOutputStream pila = new ByteArrayOutputStream();
				PrintStream out = new PrintStream(pila);
				e.printStackTrace(out);
				traza("EL STACK ES COMO SIGUE : " +  pila.toString());			
			}
			getConfiguracionMenu();			
	  }


		private void cargarPagina() throws Exception{
			  /*
			  -> Crear un DTOBelcorp con pais e idioma de la sesión 
				-> Llamar al subsistema "GestorCargaPantalla" con los siguientes datos: 
				- idBusiness = "COBCargarEtapasPais" y el DTOBelcorp => llena el combo "Etapa" 
				-idBusiness = "SEGConsultaCanales" y el DTOBelcorp => llena el combo de "Canal" 
				-idBusiness = "SEGConsultaMarcas" => se llena el combo de "Marca"
			  */
   		    traza("cargarPagina()");
			DTOBelcorp dto = new DTOBelcorp();
			dto.setOidPais(pais);
			dto.setOidIdioma(idioma);
			ComposerViewElementList lista = new ComposerViewElementList();

			ComposerViewElement composer1 = new ComposerViewElement();
			composer1.setIDBusiness("COBCargarEtapasPaisMensaje");
			composer1.setDTOE(dto);
			lista.addViewElement(composer1);
			
			ComposerViewElement composer2 = new ComposerViewElement();
			composer2.setIDBusiness("SEGConsultaCanales");
			composer2.setDTOE(dto);
			lista.addViewElement(composer2);

			ComposerViewElement composer3 = new ComposerViewElement();
			composer3.setIDBusiness("SEGConsultaMarcas");
			composer3.setDTOE(dto);
			lista.addViewElement(composer3);
			traza("antes del conecto de la carga inicial de combos");
			ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());

			conector.ejecucion();
	
			DruidaConector con = conector.getConector();
			traza("antes de asignar a los combos");
 			asignar("COMBO", "cbEtapa", con, "COBCargarEtapasPaisMensaje");
			asignar("COMBO", "cbCanal", con, "SEGConsultaCanales");
			asignar("COMBO", "cbMarca", con, "SEGConsultaMarcas");
			asignarAtributo("VAR", "oidIdioma", "valor", idioma.toString());
			asignarAtributo("VAR", "oidPais", "valor", pais.toString());
            getConfiguracionMenu("LPGenerarMensajesRecordatorios","");
		}
		

		private void buscar()throws Exception{
			/*
			-> Crear DTOBuscarClientesAsignados 
			-> Crear idBusiness "COBBuscarClientesAsignados" 
			->Asignar al conectar el idBusiness y 
			DTOBuscarClientesAsignados 
			->Asignar a la lista editable el resultado. 

			NOTA: Por defecto todos los registros resultantes de las búsqueda, deben aparecen seleccionados en la lista editable. 
			*/
/*
			traza("metodo buscar()");
			etapa = conectorParametroLimpia("etapa", "", true);
			marca = conectorParametroLimpia("marca", "", true);
			canal = conectorParametroLimpia("canal", "", true);
			periodo = conectorParametroLimpia("periodo", "", true);
			subVenta = conectorParametroLimpia("subVenta", "", true);
			regionDesde = conectorParametroLimpia("regionDesde", "", true);
			regionHasta = conectorParametroLimpia("regionHasta", "", true);
			zonaDesde = conectorParametroLimpia("zonaDesde", "", true);
			zonaHasta = conectorParametroLimpia("zonaHasta", "", true);
			seccionDesde = conectorParametroLimpia("seccionDesde", "", true);
			seccionHasta = conectorParametroLimpia("seccionHasta", "", true);
			territorioDesde = conectorParametroLimpia("territorioDesde", "", true);
			territorioHasta = conectorParametroLimpia("territorioHasta", "", true);
*/
			DTOBuscarClientesAsignados dtoBuscarClientesAsignados = new DTOBuscarClientesAsignados();
			/*dtoBuscarClientesAsignados.setCanal(canal.equals("")?null:Long.valueOf(canal));
		    dtoBuscarClientesAsignados.setEtapa(etapa.equals("")?null:Long.valueOf(etapa));//			
			dtoBuscarClientesAsignados.setMarca(marca.equals("")?null:Long.valueOf(marca));
			dtoBuscarClientesAsignados.setOidIdioma(idioma);
			dtoBuscarClientesAsignados.setOidPais(pais);
			dtoBuscarClientesAsignados.setRegionDesde(regionDesde.equals("")?null:Long.valueOf(regionDesde));
			dtoBuscarClientesAsignados.setRegionHasta(regionHasta.equals("")?null:Long.valueOf(regionHasta));
			dtoBuscarClientesAsignados.setSeccionDesde(seccionDesde.equals("")?null:Long.valueOf(seccionDesde));
			dtoBuscarClientesAsignados.setSeccionHasta(seccionHasta.equals("")?null:Long.valueOf(seccionHasta));
			dtoBuscarClientesAsignados.setSubgerenciaVentas(subVenta.equals("")?null:Long.valueOf(subVenta));
			dtoBuscarClientesAsignados.setTerritorioDesde(territorioDesde);
			dtoBuscarClientesAsignados.setTerritorioHasta(territorioHasta);
			dtoBuscarClientesAsignados.setZonaDesde(zonaDesde.equals("")?null:Long.valueOf(zonaDesde));
			dtoBuscarClientesAsignados.setZonaHasta(zonaHasta.equals("")?null:Long.valueOf(zonaHasta));			 
dtoBuscarClientesAsignados.setPeriodo(new Long(57));
//			dtoBuscarClientesAsignados.setPeriodo(periodo.equals("")?null:Long.valueOf(periodo));
		dtoBuscarClientesAsignados.setFechaDoc(date);
//			dtoBuscarClientesAsignados.setFechaVencimiento(date);
*/
			MareBusinessID businessID = new MareBusinessID("COBBuscarClientesAsignados");
			Vector params = new Vector();
			params.add(dtoBuscarClientesAsignados);
			params.add(businessID);
			traza("antes del conector");
			DruidaConector conectorObtenerUsuario = conectar("ConectorBuscarClientesAsignados", params);
			pagina("contenido_mensajes_recordatorios_generar"); 
			traza("despues del conector y antes de asignar");
			asignar ("LISTADOA", "listado1", conectorObtenerUsuario, "dtoSalida.resultado_ROWSET");

		}


		private void generarMensajes() throws Exception{
			/*
			->Armar DTOGenerarMensajes con los oid de los elementos seleccionados en la pantalla llamante 
			y demas criterios seleccionados. 
			->crear idBusiness : COBGenerarMensajes 
			->Asignar al conector el idBussiness y el dto con los oids seleccionados 
			->Asignar a la página "contenido_mensajes_recordatorios_emitidos" setear el hidden idLote con el 
			idLote devuelto en el DTOOID por el conector
			*/
			traza("3");
            DTOColeccion dtoC = new DTOColeccion();
            String oids = new String();
            String oidSeleccionados = conectorParametroLimpia("oidSeleccionados", "", true);
            //subVenta = conectorParametro("subVenta")==null?"":conectorParametro("subVenta");

			traza("OIDs:  " + oidSeleccionados);

            dtoC.setOidIdioma(idioma);
            dtoC.setOidPais(pais);
            
            if (!oidSeleccionados.equals(""))
            {
                ArrayList lista = aplanarSeleccion(oidSeleccionados);
                if (lista!= null)
                {
                    dtoC.setLista(lista);
					dtoC.setOidPais(pais);
			        dtoC.setOidIdioma(idioma);
                    MareBusinessID businessID = new MareBusinessID("COBGenerarMensajes");
                    Vector params = new Vector();
                    params.add(dtoC);
                    params.add(businessID);
                    traza("antes del conector  " + dtoC  );
                    DruidaConector con = conectar("ConectorGenerarMensajes", params);
                   // pagina("contenido_mensajes_recordatorios_generar"); 
				   traza("despues del conector de generar mensaje");
                    pagina("contenido_mensajes_recordatorios_emitidos");
                    DTOOID dto = (DTOOID) con.objeto("DTOOID");
                    asignarAtributo("VAR","oidPais","valor",pais.toString());
					asignarAtributo("VAR","oidIdioma","valor",idioma.toString());
					
                    asignarAtributo("VAR","oidLote","valor",dto.getOid().toString());
                    
                    traza("despues del conector y antes de asignar");
                }
                else
                    traza("No hay datos seleccionados!!!");
            }
		}
        
    ArrayList aplanarSeleccion(String listado) throws Exception {
        traza("************** Entre a aplanarSeleccion *******");
			traza(listado);

      StringTokenizer stRows = new StringTokenizer(listado, "$");
      int rowCount = stRows.countTokens();
      ArrayList listaCliente = new ArrayList ();
      
        String etapa = conectorParametro("oidEtapa")==null?"":conectorParametro("oidEtapa");
        String marca = conectorParametro("oidMarca")==null?"":conectorParametro("oidMarca");
        String canal = conectorParametro("oidCanal")==null?"":conectorParametro("oidCanal");
        String periodo = conectorParametro("oidPeriodo")==null?"":conectorParametro("oidPeriodo");
        
        traza("+ etapa:  " + etapa);
        traza("+ marca:  " + marca);
        traza("+ canal:  " + canal);
        traza("+ periodo:  " + periodo);
        traza("+ listado:  " + listado);
        
        if (etapa!= null && marca!= null && canal != null && periodo != null)
        {
          for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
			  traza("for1");
            DTOGenerarMensajes dtoGenerar =  null;
            StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
              dtoGenerar =  new DTOGenerarMensajes();
 			  dtoGenerar.setOidIdioma(idioma);
			  dtoGenerar.setOidPais(pais);
			  for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
                StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				
				traza("for2");
				for(int contad =  0 ;stCols.hasMoreTokens(); contad++){    
traza("for3");
					String desc = stCols.nextToken().toString();
                    String valor = stCols.nextToken().toString();
                    traza(desc + " " + valor);                    
                    
                    dtoGenerar.setOidEtapa(new Long(etapa));
                    dtoGenerar.setOidMarca(new Long(marca));
                    dtoGenerar.setOidCanal(new Long(canal));
                    dtoGenerar.setOidPeriodo(new Long(periodo));
                    traza("desc " + desc );
					traza("valor " + valor );
                    if(desc.equals("oid"))
                    dtoGenerar.setOidCliente(Long.valueOf(valor));
                    //if(desc.equals("cc"))											
                    //dtoGenerar.set(Long.valueOf(valor));
                    if(desc.equals("nombre"))
                    dtoGenerar.setClienteNombre(valor);
                    if(desc.equals("importe"))
                    dtoGenerar.setImporte(new BigDecimal(valor));
					if(desc.equals("usucobra"))
					dtoGenerar.setOidUsuarioCobranza(Long.valueOf(valor));                   
                }
				
            }
			traza("antes de setear en la lista " + dtoGenerar);
			listaCliente.add(dtoGenerar);
          }
		
        return  listaCliente;
        }
        else
            return null;
     }
	
 }
