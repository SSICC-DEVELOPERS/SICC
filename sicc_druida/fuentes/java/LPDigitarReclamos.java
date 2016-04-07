import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.rec.DTOCargaInicialDigitarReclamos;
import es.indra.sicc.dtos.rec.DTOConsultarCabeceraReclamo;
import es.indra.sicc.dtos.rec.DTOLineaOperacion;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;
import es.indra.sicc.dtos.rec.DTOReclamo;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;


//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPDigitarReclamos extends LPSICCBase
{

    private Long idioma;
    private Long pais;
    private String accion;
    private String opcionMenu;
    private Object matrizLineasOperacion[][];

    public LPDigitarReclamos()
    {
        idioma = null;
        pais = null;
        accion = null;
        opcionMenu = null;
        matrizLineasOperacion = (Object[][])null;
    }

    public void inicio()
        throws Exception
    {
    }

    public void ejecucion()
        throws Exception
    {
        try
        {
            traza("*** LPDigitarReclamos.ejecucion: Entrada ***");
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);
            accion = conectorParametroLimpia("accion", "", true);
            traza("Accion definida : " + accion);
            if(accion.equals(""))
            {
                inicializar();
                cargaInicial();
            } else
            if(accion.equals("Introducir lineas operacion"))
            {
                cargaInicialIntroducirLineas();
            } else
            if(accion.equals("Buscar"))
            {
                buscarExistente();
            } else
            if(accion.equals("Cargar"))
            {
                cargarExistente();
            } else
            if(accion.equals("Guardar"))
            {
                guardar();
            }
            traza("*** LPDigitarReclamos.ejecucion: Salida **");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            logStackTrace(exception);
            lanzarPaginaError(exception);
        }
    }

    private void inicializar()
        throws Exception
    {
        traza("*** LPDigitarReclamos.inicializar: Entrada **");
        pagina("contenido_reclamos_operaciones_digitar");
        asignarAtributo("PAGINA", "contenido_reclamos_operaciones_digitar", "cod", "0139");
        asignarAtributo("PAGINA", "contenido_reclamos_operaciones_digitar", "msgle", "Digitar Reclamos");
        getConfiguracionMenu("LPDigitarReclamos", "");
        asignarAtributo("VAR", "accion", "valor", accion);
        asignar("VAR", "idioma", idioma.toString());
        asignar("VAR", "pais", pais.toString());
        Byte byte1 = obtenerLongitudCodigoCliente();
        asignar("VAR", "numDigitosCodigoCliente", byte1.toString());
        asignar("VAR", "asumeSeguro", ConstantesREC.ASUME_SEGURO.toString());
        String s = UtilidadesSession.getSeparadorDecimales(this);
        String s1 = ",";
        if(s.equals(","))
        {
            s1 = ".";
        }
        asignar("VAR", "hid_SeparadorMiles", s1);
        asignar("VAR", "hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
        asignar("VAR", "hid_SeparadorDecimales", s);
        traza("*** LPDigitarReclamos.inicializar: Salida **");
    }

    private void cargaInicial()
        throws Exception
    {
        traza("*** LPDigitarReclamos.cargaInicial: Entrada ***");
        DTOBelcorp dtobelcorp = new DTOBelcorp();
        dtobelcorp.setOidPais(pais);
        dtobelcorp.setOidIdioma(idioma);
        Vector vector = new Vector();
        vector.add(dtobelcorp);
        vector.add(new MareBusinessID("RECCargaInicialDigitacion"));
        DruidaConector druidaconector = conectar("ConectorCargaInicialDigitarReclamos", vector);
        Object obj = druidaconector.objeto("DTOCargaInicialDigitarReclamos");
        DTOCargaInicialDigitarReclamos dtocargainicialdigitarreclamos = (DTOCargaInicialDigitarReclamos)druidaconector.objeto("DTOCargaInicialDigitarReclamos");
        RecordSet recordset = dtocargainicialdigitarreclamos.getOperacion();
        RecordSet recordset1 = new RecordSet();
        recordset1.addColumn(new String("OID"));
        recordset1.addColumn(new String("DESCRIPCION"));
        RecordSet recordset2 = null;
        recordset2 = new RecordSet();
        recordset2.addColumn(new String("OID"));
        recordset2.addColumn(new String("DESCRIPCION"));
        RecordSet recordset3 = new RecordSet();
        recordset3.addColumn(new String("OID"));
        recordset3.addColumn(new String("DESCRIPCION"));
        for(int i = 0; i < recordset.getRowCount(); i++)
        {
            Object aobj[] = new Object[2];
            aobj[0] = recordset.getValueAt(i, 0);
            aobj[1] = recordset.getValueAt(i, 1);
            recordset1.addRow(aobj);
            aobj = new Object[2];
            aobj[0] = recordset.getValueAt(i, 0);
            aobj[1] = recordset.getValueAt(i, 2);
            recordset2.addRow(aobj);
            aobj = new Object[2];
            aobj[0] = recordset.getValueAt(i, 0);
            aobj[1] = recordset.getValueAt(i, 3);
            recordset3.addRow(aobj);
        }

        Vector vector1 = recordset1.getColumnIdentifiers();
        DruidaConector druidaconector1 = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", recordset1, vector1);
        asignar("COMBO", "cbCodOperacion", druidaconector1, "DTOSalida.combo_ROWSET");
        druidaconector1 = UtilidadesBelcorp.generarConector("codigosOperacion", recordset2, vector1);
        asignar("MATRIZJS", "codigosOperacion", druidaconector1);
        vector1 = recordset3.getColumnIdentifiers();
        DruidaConector druidaconector2 = UtilidadesBelcorp.generarConector("operacionesAnulacion", recordset3, vector1);
        asignar("MATRIZJS", "operacionesAnulacion", druidaconector2);
        asignarAtributo("LABELC", "lblNOperacionX", "valor", "1");
        asignarAtributo("VAR", "numeroOperacion", "valor", "1");
        asignarAtributoElemento("txtCodCliResponsable", "disabled", "S");
        RecordSet recordset4 = dtocargainicialdigitarreclamos.getAsumePerdida();
        vector1 = recordset4.getColumnIdentifiers();
        druidaconector1 = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", recordset4, vector1);
        asignar("COMBO", "cbAsumePerdida", druidaconector1, "DTOSalida.combo_ROWSET");
        asignarAtributoElemento("cbAsumePerdida", "disabled", "S");
        asignarAtributoElemento("txtMontoArt", "disabled", "S");
        asignarAtributoElemento("txtCodArtPagado", "disabled", "S");
        asignarAtributoElemento("txtCodClienteSeguro", "disabled", "S");
        asignarAtributo("LABELC", "lblNumeroLineaX", "valor", "1");
        asignarAtributo("VAR", "numeroLinea", "valor", "1");
        traza("*** LPDigitarReclamos.cargaInicial: Salida ***");
    }

    private void cargaInicialIntroducirLineas()
        throws Exception
    {
        traza("*** LPDigitarReclamos.cargaInicialIntroducirLineas: Entrada ***");
        pagina("contenido_reclamos_operaciones_digitar_detalle");
        asignarAtributo("PAGINA", "contenido_reclamos_operaciones_digitar_detalle", "cod", "0139");
        asignarAtributo("PAGINA", "contenido_reclamos_operaciones_digitar_detalle", "msgle", "Digitar Reclamos Detalle");
        getConfiguracionMenu("LPDigitarReclamos", "detalle");
        asignarAtributo("VAR", "accion", "valor", accion);
        asignar("VAR", "idioma", idioma.toString());
        asignar("VAR", "pais", pais.toString());
        asignar("VAR", "numeroOperacion", conectorParametroLimpia("numeroOperacion", "", true));
        DTOOID dtooid = new DTOOID();
        dtooid.setOidPais(pais);
        dtooid.setOidIdioma(idioma);
        dtooid.setOid(new Long(conectorParametroLimpia("oidOperacion", "", true)));
        ComposerViewElementList composerviewelementlist = new ComposerViewElementList();
        ComposerViewElement composerviewelement = new ComposerViewElement();
        composerviewelement.setIDBusiness("RECObtenerTiposMovimiento");
        composerviewelement.setDTOE(dtooid);
        composerviewelementlist.addViewElement(composerviewelement);
        composerviewelement = new ComposerViewElement();
        composerviewelement.setIDBusiness("RECObtenerMotivosDevolucionOperacion");
        composerviewelement.setDTOE(dtooid);
        composerviewelementlist.addViewElement(composerviewelement);
        ConectorComposerView conectorcomposerview = new ConectorComposerView(composerviewelementlist, getRequest());
        conectorcomposerview.ejecucion();
        DruidaConector druidaconector = conectorcomposerview.getConector();
        asignar("COMBO", "cbTipoMov", druidaconector, "RECObtenerTiposMovimiento");
        asignar("COMBO", "cbMotivoDev", druidaconector, "RECObtenerMotivosDevolucionOperacion");
        asignarAtributo("LABELC", "lblNumeroLineaX", "valor", "1");
        asignarAtributo("VAR", "numeroLinea", "valor", "1");
        String s = UtilidadesSession.getSeparadorDecimales(this);
        String s1 = ",";
        if(s.equals(","))
        {
            s1 = ".";
        }
        asignar("VAR", "hid_SeparadorMiles", s1);
        asignar("VAR", "hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
        asignar("VAR", "hid_SeparadorDecimales", s);
        traza("*** LPDigitarReclamos.cargaInicialIntroducirLineas: Salida ***");
    }

    private void guardar()
        throws Exception
    {
        traza("*** LPDigitarReclamos.guardar: Entrada ***");
        pagina("salidaGenerica");
        asignar("VAR", "cerrarVentana", "false");
        asignar("VAR", "ejecutar", "insercionCorrecta()");
        
        Boolean borrarAnterior = new Boolean(conectorParametroLimpia("modificacionDigitados", "", true));
        if(borrarAnterior.booleanValue()){
        //eliminamos la cabecera que fue modificada y 
        //luego creamos la nueva.        
            DTOConsultarCabeceraReclamo dtoconsultarcabecerareclamo = new DTOConsultarCabeceraReclamo();
            String codDocRef = conectorParametroLimpia("txtCodDocRef", "", true);
            if(!codDocRef.trim().equals("")) {
                dtoconsultarcabecerareclamo.setNumeroDocReferencia(new Long(codDocRef.trim()));
            }
            dtoconsultarcabecerareclamo.setNumeroReclamo(conectorParametroLimpia("txtNumeroReclamo", "", true));
            dtoconsultarcabecerareclamo.setCodigoEstado("D");
            dtoconsultarcabecerareclamo.setCodCliente(conectorParametroLimpia("txtCodCliente", "", true));
            traza("Dto para borrar: "+dtoconsultarcabecerareclamo.toString());
            Vector vectortmp = new Vector();
            vectortmp.add(dtoconsultarcabecerareclamo);
            vectortmp.add(new MareBusinessID("RECEliminaReclamoDigitado"));
            conectar("ConectorObjetoGenerico", vectortmp);
        }
        
        
        DTOReclamo dtoreclamo = crearDTOReclamo();
        traza("DTOREclamo: " + dtoreclamo);
        Vector vector = new Vector();
        vector.add(dtoreclamo);
        vector.add(new MareBusinessID("RECGuardarReclamoDigitado"));
        DruidaConector druidaconector = conectar("ConectorGuardarReclamoDigitado", vector);
        accion = "";
        traza("*** LPDigitarReclamos.guardar: Salida ***");
    }

    private DTOReclamo crearDTOReclamo()
        throws Exception
    {
        traza("*** LPDigitarReclamos.crearDTOReclamo: Entrada ***");
        DTOReclamo dtoreclamo = new DTOReclamo();
        dtoreclamo.setOidPais(pais);
        dtoreclamo.setOidIdioma(idioma);
        String s = conectorParametroLimpia("txtNumeroReclamo", "", true);
        if(!s.equals(""))
        {
            dtoreclamo.setNumReclamo(new Long(conectorParametroLimpia("txtNumeroReclamo", "", true)));
        }
        dtoreclamo.setNumeroDocumentoReferencia(new Long(conectorParametroLimpia("txtCodDocRef", "", true)));
        dtoreclamo.setCodigoCliente(conectorParametroLimpia("txtCodCliente", "", true));
        matrizLineasOperacion = cadenaToMatriz(conectorParametroLimpia("lineasOperacion", "", true));
        String s1 = conectorParametroLimpia("operacionesReclamo", "", true);
        StringTokenizer stringtokenizer = new StringTokenizer(s1, "#");
        ArrayList arraylist = new ArrayList();
        DTOOperacionReclamo dtooperacionreclamo;
        for(; stringtokenizer.countTokens() > 0; arraylist.add(dtooperacionreclamo))
        {
            String s2 = stringtokenizer.nextToken();
            StringTokenizer stringtokenizer1 = new StringTokenizer(s2, "@");
            dtooperacionreclamo = null;
            if(stringtokenizer1.countTokens() > 0)
            {
                dtooperacionreclamo = new DTOOperacionReclamo();
                dtooperacionreclamo.setOidPais(pais);
                dtooperacionreclamo.setOidIdioma(idioma);
                dtooperacionreclamo.setNumSecuencial(numeroInteger(stringtokenizer1.nextToken()));
                dtooperacionreclamo.setTipoOperacion(numeroLong(stringtokenizer1.nextToken()));
                dtooperacionreclamo.setCodigoResponsablePerdida(cadena(stringtokenizer1.nextToken()));
                dtooperacionreclamo.setAsumePerdida(numeroLong(stringtokenizer1.nextToken()));
                dtooperacionreclamo.setMontoPerdida(numeroDecimal(stringtokenizer1.nextToken()));
                dtooperacionreclamo.setCodigoArticuloDigitacion(cadena(stringtokenizer1.nextToken()));
                dtooperacionreclamo.setCodigoClienteSeguro(cadena(stringtokenizer1.nextToken()));
                dtooperacionreclamo.setLineas(obtenerLineas(dtooperacionreclamo.getNumSecuencial()));
            }
        }

        dtoreclamo.setOperaciones(arraylist);
        traza("*** LPDigitarReclamos.crearDTOReclamo: Salida ***");
        return dtoreclamo;
    }

    private ArrayList obtenerLineas(Integer integer)
        throws Exception
    {
        traza("*** LPDigitarReclamos.obtenerLineas: Entrada ***");
        ArrayList arraylist = new ArrayList();
        if(matrizLineasOperacion != null)
        {
            for(int i = 0; i < matrizLineasOperacion.length; i++)
            {
                if(((Long)matrizLineasOperacion[i][0]).longValue() == integer.longValue())
                {
                    DTOLineaOperacion dtolineaoperacion = new DTOLineaOperacion();
                    dtolineaoperacion.setOidPais(pais);
                    dtolineaoperacion.setOidIdioma(idioma);
                    dtolineaoperacion.setOperacion((Long)matrizLineasOperacion[i][0]);
                    dtolineaoperacion.setNumLinea(new Integer(((Integer)matrizLineasOperacion[i][1]).intValue()));
                    dtolineaoperacion.setOidTipoMovimiento((Long)matrizLineasOperacion[i][2]);
                    dtolineaoperacion.setCodigoVenta((String)matrizLineasOperacion[i][3]);
                    dtolineaoperacion.setUnidadesReclamadas((Integer)matrizLineasOperacion[i][4]);
                    dtolineaoperacion.setOidMotivoDevolucion((Long)matrizLineasOperacion[i][5]);
                    dtolineaoperacion.setUnidadesDevueltas((Integer)matrizLineasOperacion[i][6]);
                    arraylist.add(dtolineaoperacion);
                }
            }

        }
        traza("*** LPDigitarReclamos.obtenerLineas: Salida ***");
        return arraylist;
    }

    private Object[][] cadenaToMatriz(String s)
        throws Exception
    {
        if(!s.equals(""))
        {
            String[] stringtokenizer = s.split("#");
			Object aobj[][] = new Object[stringtokenizer.length][7];
			int i;
			int j;
			for (i = 0; i< stringtokenizer.length; i++ ){
				String s1 = stringtokenizer[i];
				String[] stringtokenizer1 = s1.split("@");
				aobj[i][0] = numeroLong(stringtokenizer1[0]);
				aobj[i][1] = numeroInteger(stringtokenizer1[1]);
				aobj[i][2] = numeroLong(stringtokenizer1[2]);
				aobj[i][3] = cadena(stringtokenizer1[3]);
				aobj[i][4] = numeroInteger(stringtokenizer1[4]);
				aobj[i][5] = numeroLong(stringtokenizer1[5]);
				aobj[i][6] = numeroInteger(stringtokenizer1[6]);
			}
			/* [1]
			StringTokenizer stringtokenizer = new StringTokenizer(s, "#");
            Object aobj[][] = new Object[stringtokenizer.countTokens()][7];
            int i = 0;
            do
            {
                if(stringtokenizer.countTokens() <= 0)
                {
                    break;
                }
                String s1 = stringtokenizer.nextToken();
                StringTokenizer stringtokenizer1 = new StringTokenizer(s1, "@");
                if(stringtokenizer1.countTokens() > 0)
                {
                    aobj[i][0] = numeroLong(stringtokenizer1.nextToken());
                    aobj[i][1] = numeroInteger(stringtokenizer1.nextToken());
                    aobj[i][2] = numeroLong(stringtokenizer1.nextToken());
                    aobj[i][3] = cadena(stringtokenizer1.nextToken());
                    aobj[i][4] = numeroInteger(stringtokenizer1.nextToken());
                    aobj[i][5] = numeroLong(stringtokenizer1.nextToken());
                    aobj[i][6] = numeroInteger(stringtokenizer1.nextToken());
                    i++;
                }
			   
            } while(true);
			[1]
			*/
            return aobj;
        } else
        {
            return (Object[][])null;
        }
    }

    private String cadena(String s)
        throws Exception
    {
        if(s != null && !s.equals("-"))
        {
            return s;
        } else
        {
            return null;
        }
    }

    private BigDecimal numeroDecimal(String s)
        throws Exception
    {
        if(s != null && !s.equals("-")&& !s.equals(""))
        {
            return new BigDecimal(s);
        } else
        {
            return null;
        }
    }

    private BigDecimal numeroDecimalNoNulo(String s)
        throws Exception
    {
        if(s != null && !s.equals("-")&& !s.equals(""))
        {
            return new BigDecimal(s);
        } else
        {
            return new BigDecimal("0");
        }
    }

    private Long numeroLong(String s)
        throws Exception
    {
        if(s != null && !s.equals("-") && !s.equals(""))
        {
            return new Long(s);
        } else
        {
            return null;
        }
    }

    private Integer numeroInteger(String s)
        throws Exception
    {
        if(s != null && !s.equals("-")&& !s.equals(""))
        {
            return new Integer(s);
        } else
        {
            return null;
        }
    }

    private void logStackTrace(Throwable throwable)
        throws Exception
    {
        traza("Se produjo la excepcion: " + throwable.getMessage());
        /*ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        throwable.printStackTrace(printstream);
        traza("Stack Trace: " + bytearrayoutputstream.toString());*/
    }

    private void buscarExistente()
        throws Exception
    {
        pagina("salidaGenerica");
        //asignar("VAR", "cerrarVentana", "true");
        //asignar("VAR", "debugWindow", "true");
        Boolean boolean1 = new Boolean("false");
        Vector vector = new Vector();
        traza("Paso 1");
        DTOConsultarCabeceraReclamo dtoconsultarcabecerareclamo = new DTOConsultarCabeceraReclamo();
        String codDocRef = conectorParametroLimpia("codDocRef", "", true);
        if(!codDocRef.trim().equals("")) {
            dtoconsultarcabecerareclamo.setNumeroDocReferencia(new Long(codDocRef.trim()));
        }
        traza("Paso 2");
        dtoconsultarcabecerareclamo.setNumeroReclamo(conectorParametroLimpia("numRecla", "", true));
        traza("Paso 3");
        dtoconsultarcabecerareclamo.setCodigoEstado("D");
        traza("Paso 4");
        dtoconsultarcabecerareclamo.setCodCliente(conectorParametroLimpia("codClie", "", true));
        traza("Paso 5");
        vector.add(dtoconsultarcabecerareclamo);
        vector.add(new MareBusinessID("RECExisteReclamoDigitado"));
        traza("Paso 6");
        DruidaConector druidaconector = conectar("ConectorObjetoGenerico", vector);
        traza("Paso 7");
        DTOSalida dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        traza("Paso 8");
        RecordSet recordset = dtosalida.getResultado();
        traza("Paso 9");
        if(!recordset.esVacio()) {
            boolean1 = new Boolean("true");
        }
        traza("Paso 10");
        asignar("VAR", "ejecutar", "cargarExistente(" + boolean1.toString() + ");");
    }

    private void cargarExistente()throws Exception {
        traza("LPDigitarReclamos.cargarExistente(): Entrada");
        inicializar();
        cargaInicial();
        asignar("VAR", "modificacionDigitados", "true");
        asignar("CTEXTO","txtNumeroReclamo",conectorParametroLimpia("txtNumeroReclamo", "", true));
        asignar("CTEXTO","txtCodDocRef",conectorParametroLimpia("txtCodDocRef", "", true));
        asignar("CTEXTO","txtCodCliente",conectorParametroLimpia("txtCodCliente", "", true));
        
        Vector vector = new Vector();
        DTOConsultarCabeceraReclamo dtoconsultarcabecerareclamo = new DTOConsultarCabeceraReclamo();
        String codDocRef = conectorParametroLimpia("txtCodDocRef", "", true);
        if(!codDocRef.trim().equals("")) {
            dtoconsultarcabecerareclamo.setNumeroDocReferencia(new Long(codDocRef.trim()));
        }
        dtoconsultarcabecerareclamo.setNumeroReclamo(conectorParametroLimpia("txtNumeroReclamo", "", true));
        dtoconsultarcabecerareclamo.setCodigoEstado("D");
        dtoconsultarcabecerareclamo.setCodCliente(conectorParametroLimpia("txtCodCliente", "", true));
        dtoconsultarcabecerareclamo.setOidPais(UtilidadesSession.getPais(this));
        vector.add(dtoconsultarcabecerareclamo);
        vector.add(new MareBusinessID("RECObtieneReclamoDigitado"));
        DruidaConector druidaconector = conectar("ConectorObjetoGenerico", vector);
        DTOSalida dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        RecordSet recordset = dtosalida.getResultado();
        
        //Obtuve los datos de las operaciones y las lineas en un recordset
        //ahora los separo según el indicador del campo tipo, done L=linea y O=Operacion
        //Hecho esto, se asignara el recordset de las operaciones a la lista
        //y si bajara en un array de js las lineas correspondientes.
        
        RecordSet operaciones=new RecordSet();
        RecordSet lineasOperacion=new RecordSet();
        operaciones.addColumn("num_oper_recl_digi1");
        operaciones.addColumn("num_oper_recl_digi2");
        operaciones.addColumn("cod_oper");
        operaciones.addColumn("val_tipo_oper");
        operaciones.addColumn("oid_tipo_oper");
        operaciones.addColumn("val_resp_perd");
        operaciones.addColumn("aspe_oid_asum_perd");
        operaciones.addColumn("imp_mont_arti");
        operaciones.addColumn("cod_arti");
        operaciones.addColumn("val_clie_segu");
        //--------------------------------------------
        lineasOperacion.addColumn("num_line");//0
        lineasOperacion.addColumn("cod_tipo_movi");//1
        lineasOperacion.addColumn("cod_vent");//2
        lineasOperacion.addColumn("num_unid_recl");//3
        lineasOperacion.addColumn("cod_moti_devo");//4
        lineasOperacion.addColumn("num_unid_devu");//5
        lineasOperacion.addColumn("tipoMovimiento");//6
        lineasOperacion.addColumn("modv_oid_moti_devo");//7
        lineasOperacion.addColumn("num_oper_recl_digi");//8
        
        int largo = recordset.getRowCount();
        int numeroOperacion = 1;
        for( int i=0; i<largo;i++ ){
            String tipo = recordset.getValueAt(i,0).toString();
            if(tipo.equals("O")){//es una "O" de Operacion ;)
                Vector vectortmp = new Vector();
                vectortmp.add(recordset.getValueAt(i,"NUM_OPER_RECL_DIGI"));
                //vectortmp.add(recordset.getValueAt(i,"NUM_OPER_RECL_DIGI"));
                vectortmp.add(numeroOperacion+"");
                vectortmp.add(recordset.getValueAt(i,"COD_OPER"));
                vectortmp.add(recordset.getValueAt(i,"VAL_TIPO_OPER"));
                vectortmp.add(recordset.getValueAt(i,"OID_TIPO_OPER"));
                vectortmp.add(recordset.getValueAt(i,"VAL_RESP_PERD"));
                vectortmp.add(recordset.getValueAt(i,"ASPE_OID_ASUM_PERD"));
                vectortmp.add(recordset.getValueAt(i,"IMP_MONT_ARTI"));
                vectortmp.add(recordset.getValueAt(i,"COD_ARTI"));
                vectortmp.add(recordset.getValueAt(i,"VAL_CLIE_SEGU"));
                operaciones.addRow(vectortmp);        
                numeroOperacion++;
            }else{
                Vector vectortmp = new Vector();
                vectortmp.add(recordset.getValueAt(i,"NUM_OPER_RECL_DIGI"));
                vectortmp.add(recordset.getValueAt(i,"IMP_MONT_ARTI"));
                vectortmp.add(recordset.getValueAt(i,"VAL_TIPO_OPER"));
                vectortmp.add(recordset.getValueAt(i,"OID_TIPO_OPER"));
                vectortmp.add(recordset.getValueAt(i,"VAL_RESP_PERD"));                
                vectortmp.add(recordset.getValueAt(i,"ASPE_OID_ASUM_PERD"));
                vectortmp.add(recordset.getValueAt(i,"TIPOMOVIMIENTO"));
                vectortmp.add(recordset.getValueAt(i,"COD_ARTI"));
                vectortmp.add(recordset.getValueAt(i,"VAL_CLIE_SEGU"));
                lineasOperacion.addRow(vectortmp);        
                
            }
        }
        
        DruidaConector conOperaciones=UtilidadesBelcorp.generarConector("operaciones",operaciones,operaciones.getColumnIdentifiers());
        DruidaConector conLineas=UtilidadesBelcorp.generarConector("lineas",lineasOperacion,lineasOperacion.getColumnIdentifiers());
        
        asignar("LISTADOA","listado1",conOperaciones);
        asignar("MATRIZJS", "lineasDeOperacionModificacion", conLineas);
        //lineasDeOperacionModificacion

        traza("LPDigitarReclamos.cargarExistente(): Salida");
    }
}
