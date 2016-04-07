import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.intsys.DTOCargarOrdenesDeCompra;
import es.indra.sicc.dtos.intsys.DTOInterfaz;
import es.indra.sicc.dtos.intsys.DTOObtenerNumeroDeLote;
import es.indra.sicc.logicanegocio.intsys.ConstantesOCR;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;

public class LPRecepcionarOC extends LPSICCBase{

  String accion;
  DTOInterfaz dtoi;
  DTOSalida dtos;
  Vector v;
  MareBusinessID id;  
  RecordSet rs;
  Date fechaUltimoProceso;
  java.sql.Date fechaUltimoProcesoSQL;
  DruidaConector con;
  Long lote;
  String desc;
  DTOCargarOrdenesDeCompra dtoCO;
  DTOObtenerNumeroDeLote dtoONL;

  String fechaOC;

  public LPRecepcionarOC(){ 
    super();
  }
  
  public void inicio() throws Exception{
    this.pagina("contenido_ordenes_compra_recepcion");
  }

  public void ejecucion() throws Exception{

    try{

      this.setTrazaFichero();

      this.generarHiddenFormatoFecha();

      accion = this.conectorParametroLimpia("accion", "", true);

      if(accion.equals("")){

        asignarAtributo("VAR", "hFechaSistema", "valor", obtenerFechaFormatoPais(new java.util.Date()));

        dtoi = new DTOInterfaz();
        dtoi.setCodInterfaz(ConstantesOCR.OCR_INTERFAZ_ORDEN_COMPRA);
/*        id = new MareBusinessID("INTObtenerUltimaFechaInicioProceso");

        //----------------------------
        
        v = new Vector();
        v.add(dtoi);
        v.add(id);

        traza("va a invocar a INTObtenerUltimaFechaInicioProceso");
        con = this.conectar("ConectorObtenerUltimaFechaInicioProceso", v);
        traza("invoco con exito");
        
        dtos = (DTOSalida)con.objeto("DTOSalida");
        rs = dtos.getResultado();
*/
        if(rs != null && !rs.esVacio()){
          fechaUltimoProcesoSQL = (java.sql.Date)rs.getValueAt(0, 0);
        }

        if( fechaUltimoProcesoSQL != null ){
          String fecha = obtenerFechaFormatoPais(fechaUltimoProcesoSQL);
          this.asignarAtributo("VAR", "hFechaUltimoInicioProceso", "valor", fecha);
        }
        
        //-------------------------

        id = new MareBusinessID("INTObtenerValoresPorDefecto");
        v = new Vector();
        v.add(dtoi);
        v.add(id);

        traza("va a invocar a INTObtenerValoresPorDefecto");
        con = this.conectar("ConectorObtenerValoresPorDefecto", v);
        traza("invoco con exito");
        
        dtos = (DTOSalida)con.objeto("dtoSalida");
        rs = dtos.getResultado();

        if(rs != null && !rs.esVacio()){
          lote = (Long)rs.getValueAt(0, "Numero_Lote");
          asignarAtributo("VAR", "hValorLote", "valor", lote.toString());
          desc = (String)rs.getValueAt(0, "Descripcion");
          asignarAtributo("VAR", "hDescLote", "valor", desc);
        }

        this.getConfiguracionMenu( "LPRecepcionarOC", "" );

      }else if(accion.equals("RecibirInterfaz")){

        dtoCO = new DTOCargarOrdenesDeCompra();
        dtoCO.setOidPais(UtilidadesSession.getPais(this));
        
        // sapaza  PER-SiCC-2010-0494  17/08/2010 
        dtoCO.setIndInterfaz( ConstantesOCR.INDICADOR_INTERFAZ_OCR_MONETARIO );
        traza("el DTOCargarOrdenesDeCompra, es: " + dtoCO);
        
        id = new MareBusinessID("INTCargarOrdenesDeCompra");
        
        v = new Vector();
        v.add(dtoCO);
        v.add(id);

        traza("va a conectar RecibirInterfaz");
        this.conectar("ConectorObtenerUltimaFechaInicioProceso", v);
        traza("conecto ok");
      }

      //this.getConfiguracionMenu( "LPInsertarUsuarios", "" );

      this.getConfiguracionMenu( "LPRecepcionarOC", "" );

    }catch(Exception e){
      logStackTrace(e);		
      //this.lanzarPaginaError(e);
	  if (e instanceof InvocationTargetException) {

		  if (((InvocationTargetException) e).getTargetException() instanceof MareException) {

			MareException mareException = (MareException) ((InvocationTargetException) e).getTargetException();
			traza("codigo error: " + mareException.getCode());
			traza("mensaje error: " + mareException.getMessage());
			if(mareException.getCode() > 0) {
				this.lanzarPaginaError(e);
			} else {
				asignarAtributo("VAR","errDescripcion","valor", mareException.getMessage());
			}
		   } else {
				this.lanzarPaginaError(e);
		   }

		} else {
			this.lanzarPaginaError(e);
		}
    }
  }

  private void logStackTrace(Throwable e) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(os);

    e.printStackTrace(ps);
    try {
      traza("Se produjo la excepcion: " 
        + e.getMessage() 
        + "\n" 
        + "stackTrace = " 
        + os.toString());
    }catch (Exception ex) {
      //traza ("Error en logStackTrace: " + ex.getMessage ());
      e.printStackTrace ();
    }
  }

  /**
   * Retorna el string fecha segun el formato por pais.
   * La fecha a formatear viene en formato Date YYYY-MM-DD.
   */
  private String obtenerFechaFormatoPais(java.util.Date fecha) throws Exception {
    // obtenemos el formato de fecha segun el pais
    // String formatoFecha = conectorParametro("hFormatoFechaPais");
    String formatoFecha = UtilidadesSession.getFormatoFecha(this);
    // aseguro el indicador de mes a mayuscula  
    formatoFecha = formatoFecha.replace('m','M');
    //trabajamos con el formato del pais
    SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
    //formateamos la fecha segun el formato del pais
    String fechaFormatoPaisStr = formatoPais.format(fecha);
    //retorna la fecha formateada
    return fechaFormatoPaisStr;
  }


}
