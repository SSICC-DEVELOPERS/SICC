import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ped.DTOAtributoEspecial;
import es.indra.sicc.dtos.ped.DTOValoresPorDefecto;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.math.BigDecimal;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOError;

public class LPMantieneValoresPorDefecto extends LPSICCBase {
    private String mAccion = null;
    private String mCasoDeUso = null;
    private String oid = null;
    private String mPais = null;
    private Long lPais = null;
    private String mIdioma = null;
    private Long lIdioma = null;
    private String mDescPais = null;
    private String opcionMenu = null;

    //para caso de uso modificar-----
    private String tipoSolicitud;
    private String listado;
    //-------------------------------

    public LPMantieneValoresPorDefecto() { super(); }

    public void inicio() throws Exception { }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("******************* Entre a LPMantieneValoresPorDefecto");
        mAccion = conectorParametroLimpia("accion", "", true);
        opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

        mPais = UtilidadesSession.getPais(this).toString();
        lPais = UtilidadesSession.getPais(this);
        mIdioma = UtilidadesSession.getIdioma(this).toString();
        lIdioma = UtilidadesSession.getIdioma(this);
        mDescPais = UtilidadesSession.getDescripcionPais(this).toString();

        //oid = conectorParametro("oid");
        //yyy
        tipoSolicitud = this.conectorParametroLimpia("cbTipoSolicitud", "", true);
        listado = this.conectorParametroLimpia("hListado", "", true);

        try {
            traza("************ accion:" + mAccion);

            if (this.mAccion.equals("muestraConsulta")) {
                pagina("contenido_valores_defecto_solicitud_consultar1");
                getFormatosValidaciones();

                if (opcionMenu != null) {
                    if (opcionMenu.equals("eliminar")) {
                        this.asignarAtributoPagina("cod", "01022");
                    } else if (opcionMenu.equals("modificar")) {
                        this.asignarAtributoPagina("cod", "01023");
                    }
                }
                this.muestraCarga();
            }

            if (this.mAccion.equals("muestraInsercion")) {
                pagina("contenido_valores_defecto_solicitud_insertar");
                if (opcionMenu.equals("modificar")) {
                    this.asignarAtributoPagina("cod", "01023");
                }
                this.muestraCarga();
                this.muestraInsercion();
            }
            if (this.mAccion.equals("guardar")) {
                pagina("contenido_valores_defecto_solicitud_insertar");
                this.guarda();
            }
            if (this.mAccion.equals("buscar")) {
                pagina("contenido_valores_defecto_solicitud_consultar1");
                this.busca();
            }
            if (this.mAccion.equals("cargarValoresPorDefecto")) {
              traza("en cargarValoresPorDefecto");
              traza("opcion menu: " + opcionMenu);
              this.cargarValoresPorDefecto();
            }
            //Agregado por cvalenzu
            if (this.mAccion.equals("guardarModificar")) {
              guardarModificar();
            }			
        		//FIN - Agregado por cvalenzu
  
            cargarMenuSecundario();
        }	catch (Exception e) {
            traza("Tiro excepcion");
    
            DTOError dtoError = UtilidadesBelcorp.recuperarDatosException(e, this);
            int codigoExcepcion = Integer.parseInt(dtoError.getCodigoError());
            int codigoErrorPeticionDatosNoExistente = Integer.parseInt(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
      
            traza("codigoExcepcion: " + codigoExcepcion);
            traza("codigoErrorPeticionDatosNoExistente: " + codigoErrorPeticionDatosNoExistente);
    
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            e.printStackTrace(out);
            traza("EL STACK ES COMO SIGUE : " + pila.toString());
            e.printStackTrace();
            e.getMessage();

            //Si se cambia el valor del combo en insertar y no hay datos, no debe mostrar mensaje de error.
            if (this.mAccion != null && this.mAccion.equals("cargarValoresPorDefecto") && this.opcionMenu != null 
                && this.opcionMenu.equals("insertar") && codigoExcepcion == codigoErrorPeticionDatosNoExistente){
              traza("--- No se muestra mensaje de error -----");
              this.asignarAtributo("VAR", "ejecutar", "valor", "recuperaValoresDefectoERR()");   
              return;
            }               
            
            lanzarPaginaError(e);
            
        }
    }

    private void muestraCarga() throws Exception {
        traza("******************* Entre a muestraCarga");

        DTOBelcorp dtoBel = new DTOBelcorp();
        dtoBel.setOidPais(this.lPais);
        dtoBel.setOidIdioma(this.lIdioma);

        ComposerViewElementList lista = new ComposerViewElementList();
        ComposerViewElement composer1 = new ComposerViewElement();

        composer1.setIDBusiness("PEDobtieneTiposSolicitudPorPais");
        composer1.setDTOE(dtoBel);

        lista.addViewElement(composer1);

        ConectorComposerView conector = new ConectorComposerView(lista,
                this.getRequest());
        conector.ejecucion();

        DruidaConector con = conector.getConector();
        asignar("COMBO", "cbTipoSolicitud", con,
            "PEDobtieneTiposSolicitudPorPais");

        traza("********************* mPais " + mPais);
        traza("********************* mIdioma " + mIdioma);
        asignarAtributo("VAR", "oidPais", "valor", mPais);
        asignarAtributo("VAR", "oidIdioma", "valor", mIdioma);

        asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
    }

    //Autor: Marcelo J. Maidana
    //Fecha: 21/12/2005
    //Modificado.
    private void muestraInsercion() throws Exception {
        traza("******************* Entre a muestraInsercion");

        MareBusinessID businessID = null;
        DTOAtributoEspecial dtoAtributo = null;
        Vector parametros = null;
        DruidaConector con = null;
        DTOSalida dto = null;
        RecordSet rs = null;
        String[][] lista = null;

        //-----------
        traza("opcionMenu: " + this.opcionMenu);

        if ((this.opcionMenu != null) && this.opcionMenu.equals("modificar")) {
            traza("entro por modificar");

            lista = parsearTextoLista(this.listado);
            rs = this.armarRecordSet(lista);

            traza("**************************************");
            traza("RecordSet armado");
            traza(rs);
            traza("**************************************");
        } else {
            traza("******************* Creando BusinessID");
            businessID = new MareBusinessID("PEDconsultaAtributosEspeciales");
            traza("******************* Creando DTOAtributoEspecial");
            dtoAtributo = new DTOAtributoEspecial();

            parametros = new Vector();
            parametros.add(dtoAtributo);
            parametros.add(businessID);

            traza("******************* Antes de conectar");
            con = conectar("ConectorBuscarAtributosEspeciales", parametros);
            traza("******************* Despues de conectar");
            dto = (DTOSalida) con.objeto("DTOSalida");
            rs = dto.getResultado();
        }
        this.asignarAtributo("VAR", "oidTipoSolicitud", "valor", tipoSolicitud);
        this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);

        DruidaConector conec = 
                UtilidadesBelcorp.generarConector("dtoSalida.atributosEspeciales_ROWSET",
                                                  rs, 
                                                  rs.getColumnIdentifiers());
        this.asignar("LISTADOA", 
                     "listado1", 
                     conec,
                     "dtoSalida.atributosEspeciales_ROWSET");

        traza("LPMantieneValoresPorDefecto.muestraInsercion - Salida");
    }

    //Autor: Marcelo J. Maidana
    //Fecha: 21/12/2005
    //Creado.
    //Crea un array bidimancional con los datos de la lista editable a partir de 
    //un String con separadores.
    private String[][] parsearTextoLista(String textoLista)
        throws Exception {
        traza("LPMantieneValoresPorDefecto.parsearTextoLista(String textoLista) - Entrada");
        traza("textoLista: " + textoLista);

        String[] arLineas = null;
        String[] arLinea = null;

        arLineas = this.split(textoLista, "|");
        arLinea = this.split(arLineas[0], ",");

        String[][] arLineasReturn = new String[arLineas.length][arLinea.length];

        for (int i = 0; i < arLineas.length; i++) {
            arLinea = this.split(arLineas[i], ",");
            for (int j = 0; j < arLinea.length; j++) {
                arLineasReturn[i][j] = arLinea[j];
            }
        }

        traza("LPMantieneValoresPorDefecto.parsearTextoLista - Salida");

        return arLineasReturn;
    }

    //Autor: Marcelo J. Maidana
    //Fecha: 21/12/2005
    //Creado.
    //Crea un array a partir de un String con separadores.
    private String[] split(String texto, String sep) {
        StringTokenizer token = new StringTokenizer(texto, sep);
        String[] sRetorno = new String[token.countTokens()];

        for (int i = 0; i < sRetorno.length; i++) {
            sRetorno[i] = token.nextToken();
        }

        return sRetorno;
    }

    //Autor: Marcelo J. Maidana
    //Fecha: 21/12/2005
    //Creado.
    //Arma el RecordSet que se utilizara para generar el conector para asignar
    //a la lista editable.
    private RecordSet armarRecordSet(String[][] datos)
        throws Exception {
        traza("LPMantieneValoresPorDefecto.armarRecordSet() - Entrada");

        RecordSet rs = new RecordSet();
        Vector fila = null;
        Vector v = new Vector();

        v.add("OID");
        v.add("CAMPO_SOLICITUD");
        v.add("VALOR_DEFECTO");
        v.add("ID_VALOR_DEFECTO");
        v.add("INSERCION_OBLIGATORIA");
        v.add("MODIFICACION_OBLIGATORIA");

        rs.setColumnCount(6);
        rs.setColumnIdentifiers(v);

        for (int i = 0; i < datos.length; i++) {
            fila = new Vector();
            for (int j = 0; j < datos[i].length; j++) {
                if (j != 1) {
                    if ((j == 5) || (j == 6)) {
                        datos[i][j] = ((datos[i][j] != null) &&
                            datos[i][j].equalsIgnoreCase("SI")) ? "S" : "N";
                    }

                    if (datos[i][j] == null || datos[i][j].equals("")){
                        datos[i][j] = " ";
                    }

                    traza("datos[" + i + "][" + j + "]: " + datos[i][j]);

                    fila.add(datos[i][j]);
                }
            }
            for (int k = 0; k < fila.size(); k++){
                if (fila.get(k) != null && fila.get(k).equals(" ")){
                    fila.set(k, "");
                }
            }
            rs.addRow(fila);
        }

        traza("LPMantieneValoresPorDefecto.armarRecordSet() - Salida");
        return rs;
    }

    private void guarda() throws Exception {
        traza("LPMantieneValoresPorDefecto.guarda() - Entrada");
        traza("********* opcionMenu: " + opcionMenu);

        if (!this.opcionMenu.equals("modificar")){
           pagina("salidaGenerica");
        } else {
           this.conectorAction("LPMantieneValoresPorDefecto");
           this.conectorActionParametro("accion", "muestraConsulta");
           this.conectorActionParametro("opcionMenu", "modificar");
    		}

        String listaValores = null;
        listaValores = conectorParametro("listaValores");

        if (listaValores == null) {
           listaValores = "";
        }

        traza("******************* listaValores: " + listaValores);

        String oidTipoSolicitud = null;
        oidTipoSolicitud = conectorParametro("oidTipoSolicitud");

        if (oidTipoSolicitud == null) {
           oidTipoSolicitud = "";
        }

        traza("******************* oidTipoSolicitud: " + oidTipoSolicitud);

        ArrayList lista = new ArrayList();
        StringTokenizer st1 = new StringTokenizer(listaValores, ",");
        int cant = st1.countTokens();
        traza("********** cantidad de elementos: " + cant);

        int i = 0;
        DTOValoresPorDefecto dtoValores = new DTOValoresPorDefecto();
        dtoValores.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoValores.setPrograma(UtilidadesSession.getFuncion(this));

        while (st1.hasMoreTokens()) {
            String elementoI = st1.nextToken();
            traza("************ Elemento: " + elementoI);
            if (i == 0) {            
                if (this.opcionMenu.equals("modificar")) {
                    traza("*********** Seteando el oid");
                
                    if (elementoI.equals("null")) {
                        dtoValores.setOid(null);
                    } else {
                        dtoValores.setOid(new Long(elementoI)); //(new Long(elementoI));
                    }
                } else {            
                    traza("*********** Seteando el oid del campo");
                    dtoValores.setOidCampo(new Long(elementoI));                
                }
            }

            if (i == 2) {
                if (elementoI.equals("null")) {
                    traza("*********** Seteando NULL al valor por defecto");
                    dtoValores.setValorPorDefecto(null);
                }	else {
                    traza("*********** Seteando el valor por defecto");
                    dtoValores.setValorPorDefecto(new String(elementoI));
                }
            }

/*            if (i == 3) {
                if (elementoI.equals("null")) {
                    traza(
                        "*********** Seteando NULL al OID del valor por defecto");
                    dtoValores.setOidValorPorDefecto(null);
                }
				else {
                    traza("*********** Seteando el OID del valor por defecto");
                    dtoValores.setOidValorPorDefecto(new Long(elementoI));
                }
            }*/

            if (i == 3) {
                if (elementoI.equals("S")) {
                    dtoValores.setIndObligatorio(new Boolean(true));
                }	else {
                    dtoValores.setIndObligatorio(new Boolean(false));
                }
            }

            if (i == 4) {
                if (elementoI.equals("S")) {
                    dtoValores.setIndModificable(new Boolean(true));
                } else {
                    dtoValores.setIndModificable(new Boolean(false));
                }
            }

            i++;

            if (i == 5) {
                dtoValores.setOidTipoSolicitudPais(new Long(oidTipoSolicitud));
                traza("********* dtoValores: " + dtoValores);
                i = 0;
                lista.add(dtoValores);
                dtoValores = new DTOValoresPorDefecto();
            }
        }

        traza("************ lista: " + lista);

        DTOColeccion dtoCol = new DTOColeccion();
        dtoCol.setLista(lista);

        MareBusinessID businessID = null;
        Vector parametros = null;

        if (this.opcionMenu.equals("modificar")) {
            traza("******************* Seteando BusineesID para MODIFICAR");
            businessID = new MareBusinessID("PEDModificaValoresPorDefecto");
        }	else {
            traza("******************* Seteando BusineesID para GUARDAR");
            businessID = new MareBusinessID("PEDguardaValoresPorDefecto");
        }

        parametros = new Vector();
        parametros.add(dtoCol);
        parametros.add(businessID);

        try {
            traza("******************* Antes de conectar");
            DruidaConector con = conectar("ConectorGuardarValoresPorDefecto", parametros);
            traza("******************* Despues de conectar");

            asignarAtributo("VAR", "ejecutar", "valor", "reInicio()");
        }	catch (Exception e) {
            asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");
            throw e;
        }
    }

    private void guardarModificar() throws Exception {
        traza("LPMantieneValoresPorDefecto.guardarModificar() - Entrada");
        pagina("salidaGenerica");
        traza("********* opcionMenu: " + opcionMenu);

        String listaValores = null;
        listaValores = conectorParametro("listaValores");
        if (listaValores == null) {
            listaValores = "";
        }
        traza("******************* listaValores: " + listaValores);

        String oidTipoSolicitud = null;
        oidTipoSolicitud = conectorParametro("oidTipoSolicitud");
        if (oidTipoSolicitud == null) {
            oidTipoSolicitud = "";
        }
        traza("******************* oidTipoSolicitud: " + oidTipoSolicitud);

        ArrayList lista = new ArrayList();
        StringTokenizer st1 = new StringTokenizer(listaValores, ",");
        int cant = st1.countTokens();
        traza("********** cantidad de elementos: " + cant);

        int i = 0;
        DTOValoresPorDefecto dtoValores = new DTOValoresPorDefecto();
        dtoValores.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoValores.setPrograma(UtilidadesSession.getFuncion(this));

        while (st1.hasMoreTokens()) {
            String elementoI = st1.nextToken();
            traza("************ Elemento: " + elementoI);

            if (i == 0) {                            
	            traza("*********** Seteando el oid");           
                if (elementoI.equals("null")) {
                  dtoValores.setOid(null);
                }	else {
                  dtoValores.setOid(new Long(elementoI));                     
                }				
            }            
			
            if (i == 3) {
                if (elementoI.equals("null")) {
                    traza("*********** Seteando NULL al valor por defecto");
                    dtoValores.setValorPorDefecto(null);
                } else {
                    traza("*********** Seteando el valor por defecto");
                    dtoValores.setValorPorDefecto(new String(elementoI));
                }
            }

            /*if (i == 4) {
                if (elementoI.equals("null")) {
                    traza("*********** Seteando NULL al OID del valor por defecto");
                    dtoValores.setOidValorPorDefecto(null);
                }	else {
                    traza("*********** Seteando el OID del valor por defecto");
                    dtoValores.setOidValorPorDefecto(new Long(elementoI));
                }
            }*/			
			
            if (i == 4) {
                if (elementoI.equals("S")) {
                    dtoValores.setIndObligatorio(new Boolean(true));
                }	else {
                    dtoValores.setIndObligatorio(new Boolean(false));
                }
            }

            if (i == 5) {
                if (elementoI.equals("S")) {
                    dtoValores.setIndModificable(new Boolean(true));
                }	else {
                    dtoValores.setIndModificable(new Boolean(false));
                }
            }

            i++;

            if (i == 6) {
                dtoValores.setOidTipoSolicitudPais(new Long(oidTipoSolicitud));
                traza("********* dtoValores: " + dtoValores);
                i = 0;
                lista.add(dtoValores);
                dtoValores = new DTOValoresPorDefecto();
            }
        }

        traza("************ lista: " + lista);

        DTOColeccion dtoCol = new DTOColeccion();
        dtoCol.setLista(lista);

        MareBusinessID businessID = null;
        Vector parametros = null;

        businessID = new MareBusinessID("PEDModificaValoresPorDefecto");

        parametros = new Vector();
        parametros.add(dtoCol);
        parametros.add(businessID);

        try {
            traza("******************* Antes de conectar");
            DruidaConector con = conectar("ConectorGuardarValoresPorDefecto", parametros);
            traza("******************* Despues de conectar");
            traza("LPMantieneValoresPorDefecto.guardarModificar() - Salida");
            asignarAtributo("VAR", "ejecutar", "valor", "reInicio()");
        } catch (Exception e) {
            traza("LPMantieneValoresPorDefecto.guardarModificar() - Salida");
            asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");
            throw e;
        }
    }

    private void busca() throws Exception {
        traza("******************* Entre a busca");

        String oidTipoSolicitud = null;
        oidTipoSolicitud = conectorParametro("oidTipoSolicitud");

        if (oidTipoSolicitud == null) {
            oidTipoSolicitud = "";
        }

        traza("******************* oidTipoSolicitud: " + oidTipoSolicitud);

        MareBusinessID businessID = new MareBusinessID("PEDconsultaValoresDefecto");
        DTOValoresPorDefecto dtoValores = new DTOValoresPorDefecto();
        dtoValores.setOidPais(lPais);

        if (!oidTipoSolicitud.equals("")) {
            traza("******************* oidTipoSolicitud es distinto de nulo");
            dtoValores.setOidTipoSolicitudPais(new Long(oidTipoSolicitud));
        }

        Vector parametros = new Vector();
        parametros.add(dtoValores);
        parametros.add(businessID);

        traza("******************* Antes de conectar");

        DruidaConector con = conectar("ConectorBuscarValoresPorDefecto",
                parametros);
        traza("******************* Despues de conectar");

        traza("******************* Asignando los datos a la lista");
        asignar("LISTADOA", "listado1", con, "dtoSalida.resultado_ROWSET");
        asignarAtributo("VAR", "entroConsulta", "valor", "true");
    }

    private void cargarValoresPorDefecto() throws Exception {
    		traza("LPMantieneValoresPorDefecto.cargarValoresPorDefecto - Entrada");
		/*    - El DTOSalida devuelto tiene n registros con las siguientes columnas:
				Con ellas se rellena cada fila de la tabla lstAtributos donde la 
				descripcion del atributo especial coincida y existan valores por 
				defecto definidos.
			  
			  - Se deshabilitan las lineas que poseen valores por defecto definido. 
			  // Esto se hace para evitar que se realicen modificaciones en lugar
			  de inserciones */
        pagina("salidaGenerica");
        String oidTipoSolicitud = conectorParametroLimpia("oidTipoSolicitud", "", true);		
        DTOValoresPorDefecto dto = new DTOValoresPorDefecto();
        dto.setOidTipoSolicitudPais(Long.valueOf(oidTipoSolicitud));
        dto.setOidPais(UtilidadesSession.getPais(this));
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));
    
        traza("******************* DTOValoresPorDefecto " + dto);
    
        MareBusinessID businessID = new MareBusinessID("PEDconsultaValoresDefecto");
        Vector parametros = new Vector();      
        parametros.add(dto);
        parametros.add(businessID);

    		try {
         	 traza("******************* Antes de conectar");
           DruidaConector con = 
               conectar("ConectorBuscarValoresPorDefectoInsercion", parametros);			
           traza("******************* Despues de conectar");			
           DTOSalida dtoSalida = (DTOSalida)con.objeto("dtoSalida"); 			
           traza("******************* dtoSalida " + dtoSalida);
           RecordSet rs = dtoSalida.getResultado();
           traza("******************* rs " + rs);
           String listaValores = parseaDatosValoresDefecto(rs);
  	 		   asignarAtributo("VAR", 
                           "ejecutar",
                           "valor", 
                 			     "recuperaValoresDefectoOK('" + listaValores + "');");         
    		} catch(Exception e) {
           asignarAtributo("VAR", "ejecutarError", "valor", "recuperaValoresDefectoERR()");          
           throw e;
    		} 

        traza("LPMantieneValoresPorDefecto.cargarValoresPorDefecto - Salida");
	}

	private String parseaDatosValoresDefecto(RecordSet rs) throws Exception {
      traza("LPMantieneValoresPorDefecto.parseaDatosValoresDefecto - Entrada");
      int cant = rs.getRowCount();
      StringBuffer listaValores = new StringBuffer();

      for (int i=0; i<cant; i++) {
         if(i>0) { listaValores.append("|"); }
         
         BigDecimal bdOid = (BigDecimal)rs.getValueAt(i, "OID");
         String descTipoSolic = (String)rs.getValueAt(i, "DESCTIPOSOLIC");
         String descAtri = (String)rs.getValueAt(i, "DES_ATRI");
         String valValoDefe = (String)rs.getValueAt(i, "VAL_VALO_DEFE");
         BigDecimal bdObli = (BigDecimal)rs.getValueAt(i, "IND_OBLI");
         BigDecimal bdModi = (BigDecimal)rs.getValueAt(i, "IND_MODI");

         listaValores.append(bdOid);
         listaValores.append("~");
         listaValores.append(descTipoSolic);
         listaValores.append("~");
         listaValores.append(descAtri);
         listaValores.append("~");
         listaValores.append(valValoDefe);
         listaValores.append("~");
         listaValores.append(bdObli);
         listaValores.append("~");
         listaValores.append(bdModi);
		  }

      traza("****** listaValores " + listaValores.toString());
      traza("LPMantieneValoresPorDefecto.parseaDatosValoresDefecto - Salida");
      return listaValores.toString();
	}

    private void cargarMenuSecundario() throws Exception {
        traza("******************* Entre a cargarMenuSecundario");

        if (this.mAccion.equals("muestraInsercion")) {
            getConfiguracionMenu("LPMantieneValoresPorDefecto", "insertar");
        }

        if (this.mAccion.equals("muestraConsulta") &&
            this.opcionMenu.equals("eliminar")) {
            traza("configura menu eliminar");
            getConfiguracionMenu("LPMantieneValoresPorDefecto", "eliminar");
        }
		else if (this.mAccion.equals("muestraConsulta")) {
            traza("configura menu consultar");
            getConfiguracionMenu("LPMantieneValoresPorDefecto", "consultar");
        }
    }
}
