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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.presentacion.rastreador.*;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClienteDTO;
import es.indra.sicc.dtos.dto.DTOEDescuentoCliente;
import es.indra.sicc.dtos.dto.DTOParametroMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOCodigoClienteDto;
import es.indra.sicc.dtos.dto.DTODescuentoCliente;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento; 
import es.indra.sicc.dtos.dto.DTOListaDescuentoCliente;
import java.util.StringTokenizer;
import java.util.Hashtable;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import java.util.Iterator;
import java.util.Vector;


/**
 * Sistema:             Belcorp - SICC
 * Modulo:              DTO - Descuentos
 * Componente:          LPMantenimientoAlcanceCliente
 * Fecha:               06/07/2004
 * Dcoumentacion:
 *                      documentos: SICC-DMCO-DTO-201-324
 * Observaciones:
 * @version             3.0
 * @author              Cintia Verónica Argain
 */
public class LPMantenimientoAlcanceCliente extends LPDescuentos{//[1] extends LPSICCBase {
    private Long lIdioma = null;
    private Long lPais = null;
    private String sAccion = null;
    private String sCasoDeUso = null;
    public String sCodigoCliente = new String();
    public String sPorcentajeDescuento = new String();
    public String sImporteFijoDescuento = new String();
    public DTOOID dtoOidDescuento = new DTOOID();

    private int noRecargaPantalla = 0;

	private DTOGlobalDescuento dtoGlobalDesc = null;//[1]

    public LPMantenimientoAlcanceCliente() {
    }

    public void inicio() throws Exception {
        pagina("contenido_alcance_clientes_crear");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();

		if (dtoGlobalDesc == null){
				dtoGlobalDesc = getDescuento();
		}

        try {
            traza("<<<<<<<<< Inicializando LPMantenimientoAlcanceCliente >>>>>>>>>>>>");
            sAccion = (conectorParametro("accion") == null) ? "" : conectorParametro("accion");
            traza("Accion: " + sAccion);
            
            lPais = UtilidadesSession.getPais(this);
            lIdioma = UtilidadesSession.getIdioma(this);
            
            asignarAtributo("VAR", "hidIdioma", "valor", lIdioma.toString());
            asignarAtributo("VAR", "hidPais", "valor", lPais.toString());
            
        
            sCasoDeUso = (conectorParametro("casoDeUso") == null) ? "" : conectorParametro("casoDeUso");
            
            traza(">>>> Acción................ " + sAccion);
            traza(">>>> Idioma................ " + lIdioma);
            traza(">>>> Pais.................. " + lPais);            
            traza("CU......................... " + sCasoDeUso);
            traza("Cargando menu.............. 19-04-2005");

			// seteo las de herencia
			accion = sAccion;
			casoDeUso = sCasoDeUso;

			noRecargaPantalla = 0;
			//

            /*.. Guardo la variable casodeuso en una variable del form ...*/
			traza("SCS 1");
            asignarAtributo("VAR","hidCasoDeUso","valor",sCasoDeUso);
			traza("SCS 2");

			//Acción "" 
            if (sAccion.equals("")) {
			   cargarPantalla();
            }
            //Acción "añadir" 
            else if (sAccion.equals("aniadir")) {
			   añadir();
            } else if (sAccion.equals("almacenar")) { 
                almacenar(); 
                redirigir(); 
            } else if (sAccion.equals("busquedaRapidaOculta")) {  
				modificarCliente();
            } else if (sAccion.equals("redirigir")) { 
                redirigir(); 
            } else if (sAccion.equals("guardar")) { 
                this.almacenar(); 
                guardar(); // Este método se hereda de la LPDescuentos 
            //Acción "siguiente" 
            } else if (sAccion.equals("siguiente")) {
				this.siguiente();
            }

        } catch (Exception ex) {
            logStackTrace(ex);
			if (noRecargaPantalla == 0)
			{
				cargarPantalla();
			}
            this.lanzarPaginaError(ex);
        }
    }

	public void obtenerAlcanceClienteDetalle () throws Exception {
		   traza(">>>> dentro de obtenerAlcanceClienteDetalle ....");
		   DTOCodigoClienteDto codigoClteDto = new DTOCodigoClienteDto();
	}

	public void siguiente() throws Exception{
			    //Este método realiza las acciones necesarias para pasar a la pestaña siguiente (BELC300014763) 
                //-> Tomar valor parametro "casodeuso" 
                sCasoDeUso = (conectorParametro("hidCasoDeUso") == null) ? "" : conectorParametro("hidCasoDeUso");
                traza("<<<< SIGUIENTE >>>> CASO DE USO  " + sCasoDeUso);

 		        if(sCasoDeUso.equals("modificar") || sCasoDeUso.equals("insertar")){
				    this.almacenar();
	  		    }

                //-> Guardar nombre de lp actual en sesión, variable "DTOUltimaLP" 
                conectorParametroSesion("DTOUltimaLP", "LPMantenimientoAlcanceCliente");

                //-> Llamar a la Lp "LPMantenimientoAlcanceAdministrativo" con acción "" y 
                conectorAction("LPMantenimientoAlcanceAdministrativo");
                conectorActionParametro("accion", "");

                //pasando la variable "casodeuso" con valor de parametro recibido
                conectorActionParametro("casoDeUso", sCasoDeUso);
    }

	public void almacenar() throws Exception {
		   traza(">>>> dentro de almacenar....");
		   String listado2STR = conectorParametro("hidContenidoDescuentosClientes");
		   traza(">>>> listado2STR es.... " + listado2STR);

		   obtenerFilasListaYacumularDto(listado2STR);

		   traza("indicador alc. clte, queda: " + dtoGlobalDesc.getIndAlcanceCliente());
		   traza("lista, queda: " + dtoGlobalDesc.getAlcanceCliente());

	}

	public void obtenerFilasListaYacumularDto(String listado2STRparam) throws Exception {
        StringTokenizer stRows = new StringTokenizer(listado2STRparam, "$");
        int rowCount = stRows.countTokens();
		traza("&&&&&&&&&&&& rowCount, es: " + rowCount);
		if (rowCount>0)
		{
			Hashtable productos = new Hashtable();
			DTOListaDescuentoCliente dtoLista = new DTOListaDescuentoCliente();
			DTODescuentoCliente[] alcanceCliente = new DTODescuentoCliente[rowCount];

			for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
				StringTokenizer stCols = new StringTokenizer(stRows.nextToken(), "|");
			   
				DTODescuentoCliente registro = new DTODescuentoCliente();
				String aux = new String();

				//oid oculto
				if (stCols.hasMoreTokens()) { 
					registro.setOidCliente(new Long(stCols.nextToken()));
				}

				if (stCols.hasMoreTokens()) {
					registro.setCodigoCliente(stCols.nextToken());
				}

				if (stCols.hasMoreTokens()) { 
					registro.setNombre(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) {
					registro.setApellidos(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					aux = stCols.nextToken(); 
					if (!(aux.equals(" ")))
					{
						registro.setPorcentajeDescuento(formatearFloat(aux));
					}
				}
				aux = "";
				if (stCols.hasMoreTokens()) { 
					aux = stCols.nextToken(); 
					if (!(aux.equals(" ")))
					{
						registro.setImporteDescuento(formatearDouble(aux));
					}
				}
				traza("registro, me queda asi....: " + registro);
				alcanceCliente[cont] = registro;
			}
      		
			dtoLista.setAlcanceCliente(alcanceCliente);
            dtoLista.setOidIdioma(lIdioma);
            dtoLista.setOidPais(lPais);
	        dtoGlobalDesc.setAlcanceCliente(dtoLista);
		} else {
			//lista esta vacia, hago null en el dto
			DTOListaDescuentoCliente dtoLista = new DTOListaDescuentoCliente();
			dtoLista.setAlcanceCliente(null);
			dtoGlobalDesc.setAlcanceCliente(dtoLista);
		}
	    dtoGlobalDesc.setIndAlcanceCliente(Boolean.TRUE);
		setDescuento(dtoGlobalDesc);

	}

	private Double formatearDouble(String val) throws Exception{
        if (val.equals(" ")){
            try{traza("Valor ---" + val  + "---") ;}catch(Exception e){}
            return null;
        }
        traza(val);
        return new Double(val);
	}
	private Float formatearFloat(String val) throws Exception{
        if (val.equals(" ")){
            try{traza("Valor ---" + val  + "---") ;}catch(Exception e){}
            return null;
        }
        traza(val);
        return new Float(val);
	}

	public void añadir() throws Exception{
       String sOidDescuento = conectorParametro("hidOidDescuento");
       traza("DESCUENTO PARA el detalle..... " + sOidDescuento);

       pagina("contenido_alcance_clientes_detalle");
	   asignarAtributo("VAR", "hidLongCliente", "valor", obtenerLongitudCodigoCliente().toString());

       getConfiguracionMenu("LPMantenimientoAlcanceCliente","aniadir");  
       asignarAtributoPagina("cod", "0644");
       asignarAtributo("VAR", "hidIdioma", "valor", lIdioma.toString());
       asignarAtributo("VAR", "hidOidDescuento", "valor", sOidDescuento);

	}

	public void cargarPantalla() throws Exception{

 	    traza("(en: cargarPantalla(), el dto global, tiene: " + dtoGlobalDesc);

      traza("(en: cargarPantalla())>>>> Acción................" + sAccion);
      traza("(en: cargarPantalla())CU..................." + sCasoDeUso);

      asignarAtributo("VAR","hidCasoDeUso","valor",sCasoDeUso);
		// Se carga la lista descuentosCliente con los datos obtenidos en el dtoDescuento
      cargaDeListaPrincipal();
        
  		if (sCasoDeUso.equals("consultar")){
          String modvig = (String)conectorParametroSesion("modificarVigente");
          if ("true".equals(modvig)) {
            getConfiguracionMenu("LPMantenimientoAlcanceCliente","vacio");
            asignarAtributoPagina("cod","0354");
          } else {
            getConfiguracionMenu("LPMantenimientoAlcanceCliente","consultar");
            asignarAtributoPagina("cod","0233");
          }   	 
        } else if ("modificar".equals(sCasoDeUso)){
          getConfiguracionMenu("LPMantenimientoAlcanceCliente","vacio");
          asignarAtributoPagina("cod","0354");
        } else if ("insertar".equals(sCasoDeUso)){
          getConfiguracionMenu("LPMantenimientoAlcanceCliente","vacio");
          asignarAtributoPagina("cod", "0644");
          traza("salio de la accion vacia");
        }

		if (sCasoDeUso.equals("consultar") || sCasoDeUso.equals("modificar")){
 		  Long oidDescuento = dtoGlobalDesc.getDatosGralesDto().getOidDescuento();
          asignarAtributo("VAR", "hidOidDescuento", "valor", oidDescuento.toString());
		} else if (sCasoDeUso.equals("insertar")){
		  asignarAtributo("VAR", "hidOidDescuento", "valor", "");
		}
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }

    public void cargaDeListaPrincipal() throws Exception {
        traza(">>>>> Entrando a cargaDeListaPrincipal");

		if (dtoGlobalDesc.getAlcanceCliente() != null)
		{
			DTODescuentoCliente[] listaAlcClte = dtoGlobalDesc.getAlcanceCliente().getAlcanceCliente();
			if (listaAlcClte != null)
			{
				int cantAlcClie = 0;
				cantAlcClie = listaAlcClte.length;
				RecordSet recLista = new RecordSet();
				int iAlcClie;

				recLista.addColumn("OID");
				recLista.addColumn("COD_CLIE");
				recLista.addColumn("nombre");
				recLista.addColumn("apellido");
				recLista.addColumn("VAL_PORC_DESC");
				recLista.addColumn("IMP_FIJO");

				DTODescuentoCliente registro = new DTODescuentoCliente();

				for (iAlcClie = 0; iAlcClie < cantAlcClie; iAlcClie++){

					registro = (DTODescuentoCliente)listaAlcClte[iAlcClie];
					traza(">>>>>>> registro es: " + registro);

					Vector valoresAlcanClie = new Vector();

					valoresAlcanClie.add(registro.getOidCliente()); 
					valoresAlcanClie.add(registro.getCodigoCliente()); 
					valoresAlcanClie.add(registro.getNombre()); 
					valoresAlcanClie.add(registro.getApellidos()); 
					valoresAlcanClie.add(registro.getPorcentajeDescuento());
					valoresAlcanClie.add(registro.getImporteDescuento());

					recLista.addRow(valoresAlcanClie);
					traza("rec: " + recLista);

				}
				String nombreListado = "listado1";

				asignar("LISTADOA", nombreListado, UtilidadesBelcorp.generarConector("ROWSET", recLista, recLista.getColumnIdentifiers()));
				traza(">>>>>>> LISTA CARGADA");
			} else {
				traza(">>>>>>> LISTA NO CARGADA, dtoGlobalDesc.getAlcanceCliente().getAlcanceCliente() esta vacia!!");
			}

		}

    }

  
	private void modificarCliente() throws Exception{
		traza("### Entro a modificarCliente ###");
		pagina("salidaGenerica");
		this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
		asignarAtributo("VAR", "ejecutarError", "valor", "errorClienteBusqueda()");
		// idBusiness= "MAEBusquedaRapidaClientes" 
		MareBusinessID idBusiness = new MareBusinessID("MAEBusquedaRapidaCliente");
        // Creamos un DTOBusquedaRapidaClientes y lo rellenamos con: 
		// - pais 
		// - idioma 
		// - codigoCliente: Valor introducido en txtCliente 
		DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
		dto.setIndicadorSituacion(new Long(0));
		dto.setTamanioPagina(new Integer(1));
		dto.setOidPais(UtilidadesSession.getPais(this));
		dto.setOidIdioma(UtilidadesSession.getIdioma(this));

		String codigoCliente = new String();
		
	    codigoCliente = conectorParametroLimpia("txtCodCliente", "", true);

		//asignarAtributo("VAR", "ejecutarError", "valor", "errorClienteBusqueda('" + indBusquedaCodigo + "')");
		traza("Código de cliente capturado: " + codigoCliente);
		dto.setCodigoCliente(codigoCliente);		
		// Llamamos al ConectorBusquedaRapidaCliente con el dto creado. 
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(idBusiness);
		traza("Conectando a ConectorBusquedaRapidaCliente... ");

		DruidaConector conector = null;
		try
		{
		    conector = conectar("ConectorBusquedaRapidaCliente", parametros);	

			traza("Conectó.");
			// Recibe un DTOSalida (con un registro) 
			DTOSalida dtoRetornado = (DTOSalida)conector.objeto("DTOSalida");
			RecordSet retorno = dtoRetornado.getResultado();
			traza("Retornó: ");

			traza(" - OID: " + (BigDecimal)retorno.getValueAt(0, "OID"));
			traza(" - COD_CLIE: " + (String)retorno.getValueAt(0, "COD_CLIE"));
			traza(" - VAL_NOM1: " + (String)retorno.getValueAt(0, "VAL_NOM1"));
			traza(" - VAL_NOM2: " + (String)retorno.getValueAt(0, "VAL_NOM2"));
			traza(" - VAL_APE1: " + (String)retorno.getValueAt(0, "VAL_APE1"));		
			traza(" - VAL_APE2: " + (String)retorno.getValueAt(0, "VAL_APE2"));		

			sAccion = (conectorParametro("accion") == null) ? "" : conectorParametro("accion");
			String oidCliente = ((BigDecimal)retorno.getValueAt(0, "OID")).toString();
			String codCliente = (String)retorno.getValueAt(0, "COD_CLIE");
			String nombreUsuario = (String)retorno.getValueAt(0, "VAL_NOM1");
			String nombreUsuario2 = (String)retorno.getValueAt(0, "VAL_NOM2");
			String apellidoUsuario = (String)retorno.getValueAt(0, "VAL_APE1");
			String apellidoUsuario2 = (String)retorno.getValueAt(0, "VAL_APE2");
			
			String funcion = new String("asignarDatosCliente('" + oidCliente + "','" + codCliente + "','" + nombreUsuario + "','" + nombreUsuario2 + "','" + apellidoUsuario + "','" + apellidoUsuario2 + "')");

			traza("Funcion a ejecutar: " + funcion);
			
			asignarAtributo("VAR", "ejecutar", "valor", funcion);
			traza("PASO");

        } catch (Exception ex) {
			traza("SCS, excepcion al buscar clienteeeeeeeeeeeeeeee... ");
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
			noRecargaPantalla = 1;
        }
		
	}

}
