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
 *
 */
 

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;


public class LPReasignarCarteraUsuarios extends LPSICCBase {
    //definicion de variables
    String accion = null;
    String casoDeUso = null;
    Long pais = null;
    Long idiomaUsuario = null;
    String ipCliente = null;
    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;
    private boolean debugging = false;

    // Definicion del constructor
    public LPReasignarCarteraUsuarios() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
    
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        TiempoDeCargaInicio = System.currentTimeMillis();

        this.rastreo();
        setTrazaFichero();        

        accion = this.conectorParametroLimpia("accion", "", true);
        casoDeUso = this.conectorParametroLimpia("casoDeUso", "", true);
        if (debugging) {
          ipCliente = "192.168.119.144";
          idiomaUsuario = new Long(1);
          pais = new Long(1);
        } else {
          ipCliente = UtilidadesBelcorp.getIPCliente(this);
          //<inicio>Modificado por sapaza, corregimos el seteo de idioma y pais
          idiomaUsuario = UtilidadesSession.getIdioma(this);          
          pais = UtilidadesSession.getPais(this); 
          //<fin>
        }

        try {
            if (accion.equals("")) {
                cargarPagina();
            } else if (accion.equals("reasignar")) {
                reasignar();
            }

            TiempoDeCargaFin = System.currentTimeMillis();
            traza("El tiempo de carga de LPReasignarCarteraUsuarios es :" +
                (TiempoDeCargaFin - TiempoDeCargaInicio));
        } catch (Exception e) {
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    }
    
  /** 
   * Método para cargar la pagina principal
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */    
    private void cargarPagina() throws Exception {
    
        pagina("contenido_cartera_usuarios_reasignar");
        generarHiddenFormatoFecha();
        getFormatosValidaciones();
        this.getConfiguracionMenu("LPReasignarCarteraUsuarios", "");

        cargaCombos();

        asignarAtributo("VAR","hoidPais","valor",(this.pais!=null?this.pais.toString():""));
        asignarAtributo("VAR","hoidIdioma","valor",(this.idiomaUsuario!=null?this.idiomaUsuario.toString():""));
       
    }
    
  /** 
   * Método para reasignar la cartera segun el filtro de usuarios
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */    
    private void reasignar() throws Exception {    

      Long usuarioOrigen = ((conectorParametro("cbUsuOri")==null)||(conectorParametro("cbUsuOri").equals("")))?null:Long.valueOf(conectorParametro("cbUsuOri"));
      Long usuarioDestino = ((conectorParametro("cbUsuDest")==null)||(conectorParametro("cbUsuDest").equals("")))?null:Long.valueOf(conectorParametro("cbUsuDest"));
      Long etapaDeuda = ((conectorParametro("cbCodEtapaD")==null)||(conectorParametro("cbCodEtapaD").equals("")))?null:Long.valueOf(conectorParametro("cbCodEtapaD"));
      Long marca = ((conectorParametro("cbMarca")==null)||(conectorParametro("cbMarca").equals("")))?null:Long.valueOf(conectorParametro("cbMarca"));
      Long canal = ((conectorParametro("cbCanal")==null)||(conectorParametro("cbCanal").equals("")))?null:Long.valueOf(conectorParametro("cbCanal"));
      Long periodo = ((conectorParametro("cbCodPeriodo")==null)||(conectorParametro("cbCodPeriodo").equals("")))?null:Long.valueOf(conectorParametro("cbCodPeriodo"));

      DTOAsignacionesCobranza dtoAsCob = new DTOAsignacionesCobranza();
      dtoAsCob.setOidPais(this.pais);  
      dtoAsCob.setOidIdioma(this.idiomaUsuario);
      dtoAsCob.setUsuarioOrigen(usuarioOrigen);
      dtoAsCob.setUsuarioDestino(usuarioDestino);
      dtoAsCob.setEtapaDeuda(etapaDeuda);
      dtoAsCob.setMarca(marca);
      dtoAsCob.setCanal(canal);
      dtoAsCob.setPeriodo(periodo);     

      MareBusinessID id = new MareBusinessID("COBReasignarCartera");
      Vector vec = new Vector();
      vec.add(dtoAsCob);
      vec.add(id);
      //Invoco a ConectorReasignarCartera 
      traza("antes de conectar ConectorReasignarCartera");
      pagina("salidaGenerica");
      asignarAtributo("VAR", "ejecutarError", "valor", "quitaOculto();");
      DruidaConector conectorSalida = conectar("ConectorReasignarCartera",vec);
      this.asignarAtributo("VAR", "ejecutar", "valor", "onClickBuscar()");
      //asignarAtributo("VAR", "ejecutar", "valor", "quitaOculto();");
      
    }    
    
  /** 
   * Método de carga inicial de combos
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */
    private void cargaCombos() throws Exception{
      //Preparamos los parametros del subsistema
      ComposerViewElementList cv = crearParametrosEntrada();
		
      //Utilizamos el subsistema
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
		
      //Cargamos los combos con los resultados
      asignar("COMBO", "cbUsuOri", resultados, "COBObtenerUsuariosCobCombo");
      asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
      asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
    }

    private ComposerViewElementList crearParametrosEntrada(){
      ComposerViewElementList lista = new ComposerViewElementList(); 

      DTOBelcorp dtoe = new DTOBelcorp();    
      dtoe.setOidPais(this.pais);
      dtoe.setOidIdioma(this.idiomaUsuario);

      //Primer combo etapa
      ComposerViewElement ci1 = new ComposerViewElement();
      ci1.setIDBusiness("COBObtenerUsuariosCobCombo");
      ci1.setDTOE(dtoe);


      
      //Segundo combo marca
      ComposerViewElement ci2 = new ComposerViewElement();
      ci2.setIDBusiness("SEGConsultaMarcas");
      ci2.setDTOE(dtoe);    

      //Tercer combo canal
      ComposerViewElement ci3 = new ComposerViewElement();
      ci3.setIDBusiness("SEGConsultaCanales");
      ci3.setDTOE(dtoe);   

/*		//Refefinimos la posición de las columnas porque el resultado de 
		// la operación de negocio no es estándar
		ci2.setPosOID((byte)2);
		ci2.setPosDesc((byte)0);
  */    
      
      lista.addViewElement(ci1);
      lista.addViewElement(ci2);
      lista.addViewElement(ci3);
    
      return lista;
    }
       
//------------------------METODOS DE APOYO--------------------------------------------

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

    /**
    * Retorna el string fecha segun el formato por pais.
    * La fecha a formatear viene en formato Date YYYY-MM-DD.
    */
    private String obtenerFechaFormatoPais(Date fecha) throws Exception {
      // obtenemos el formato de fecha segun el pais
      // String formatoFecha = conectorParametro("hFormatoFechaPais");
      String formatoFecha = null;
      if (debugging) {
        formatoFecha = new String("yyyy-MM-dd");
      } else { 
        formatoFecha = UtilidadesSession.getFormatoFecha(this);
      }
      // aseguro el indicador de mes a mayuscula  
      formatoFecha = formatoFecha.replace('m','M');
      //trabajamos con el formato del pais
      SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
      //formateamos la fecha segun el formato del pais
      String fechaFormatoPaisStr = null;
      if (fecha != null){
        fechaFormatoPaisStr = formatoPais.format(fecha);
      }
      //retorna la fecha formateada    
      return fechaFormatoPaisStr;
    }
    /**
     * Retorna string fecha en formato YYYY-MM-DD, tal como lo maneja Date.
     * Recibe el string fecha en formato en el formato del pais. 
     */
    private String obtenerFechaFormatoDate(String fecha) throws Exception {
        // obtenemos el formato de fecha segun el pais
        // String formatoFecha = conectorParametro("hFormatoFechaPais");
        String formatoFecha = null;
        if (debugging){
          formatoFecha = new String("yyyy-MM-dd");
        } else {
          formatoFecha = UtilidadesSession.getFormatoFecha(this);
        }
        // aseguro el indicador de mes a mayuscula  
        formatoFecha = formatoFecha.replace('m','M');
        //trabajamos con el formato del pais
        SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
        //formateamos la fecha segun el formato Date yyyy-mmm-dd
        Date fechaFormatoDate = new java.sql.Date(formatoPais.parse(fecha).getTime());
        //retorna la fecha formateada
        return fechaFormatoDate.toString();
    }    
    
//------------------------FIN METODOS DE APOYO--------------------------------------------
}
