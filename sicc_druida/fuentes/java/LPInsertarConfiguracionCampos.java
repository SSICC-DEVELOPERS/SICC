/*
    INDRA/CAR/PROY
    $Id: LPInsertarConfiguracionCampos.java,v 1.1 2009/12/03 18:36:15 pecbazalar Exp $
    DESC
*/
import LPSICCBase;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.mae.DTOCombosConfiguracionCampos;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.mae.DTOConfiguracionCampo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.mare.common.exception.MareException;


public class LPInsertarConfiguracionCampos extends LPSICCBase  {

  String casoDeUso;
  String accion;

  String tipoCampo;
         String tipoCliente;
         String subtipoCliente;
         String nombreCampo;
         String obligatorio;
         String modificable;
         String valorxdefecto;
  boolean duplicado;

  public void inicio() throws Exception  {
    pagina("contenido_campos_parametrizables_insertar");
  }

  public LPInsertarConfiguracionCampos ()  {
    super();
  }

  public void ejecucion() throws Exception  {

    try{
      rastreo();
         setTrazaFichero();
         traza(" ");
         traza("********************************************************");
         traza("********************* ejecucion() LPInsertar **********************");
         traza("********************************************************");

        casoDeUso = conectorParametroLimpia("hCasoDeUso","",true);
           traza("casoDeUso : " + casoDeUso);
         accion = conectorParametroLimpia("accion","",true);
           traza("accion : " + accion);

         tipoCampo = conectorParametroLimpia("cbTipoCampo","",true);
         tipoCliente = conectorParametroLimpia("cbTipoCliente","",true);
         subtipoCliente = conectorParametroLimpia("cbSubTipoCliente","",true);
         nombreCampo = conectorParametroLimpia("cbNombreCampo","",true);
         obligatorio = conectorParametroLimpia("IngresoObligatorio","",true);
         modificable = conectorParametroLimpia("ModificableporUsuario","",true);
         valorxdefecto = conectorParametroLimpia("txtValorPorDefecto","",true);

           traza("tipoCampo : " + tipoCampo);
           traza("tipoCliente : "    + tipoCliente);
           traza("subtipoCliente : " + subtipoCliente);
           traza("nombreCampo : "    + nombreCampo);
           traza("obligatorio : "    + obligatorio);
           traza("modificable : "    + modificable);
           traza("valorxdefecto : "  + valorxdefecto);


  //accion == " " ------------------------------------------------------------------
      if (accion.equals("")) {

         cargarDatosFiltro();
         asignarAtributo("VAR","hCasoDeUso", "valor", "Insertar");

      }


  //accion == "Guardar" ------------------------------------------------------------------
      if (accion.equals("Guardar")) {

         pagina("salidaGenerica");
         traza("Entra en accion Guardar");
         //-se crea un DTOConfiguracionCampo de la siguiente forma: 
         //los atributos campo, obligatorio, modificable y valorDefecto se rellenan con el value de los correspondientes campos.
         //el atributo subtipoCliente se rellena con el value del combo subtipoCliente se el campo indClienteProducto vale true, si vale false el atributo va a null.
         //el atributo oid no se rellena (se generará automáticamente).
         DTOConfiguracionCampo dtoGuardar = new DTOConfiguracionCampo();

                  // Auditoria
                  dtoGuardar.setIpCliente(UtilidadesBelcorp.getIPCliente(this));				
         dtoGuardar.setPrograma(UtilidadesSession.getFuncion(this));


                  traza("-------------------------------------------------");
                  traza("subtipocliente: " + subtipoCliente);
                  traza("nombrecampo: " + nombreCampo);
                  traza("-------------------------------------------------");


         if ( tipoCampo.equals("1") )  {
           dtoGuardar.setSubtipoCliente(null);
         }
         else  {
           dtoGuardar.setSubtipoCliente( Long.valueOf(subtipoCliente) );
         }
         dtoGuardar.setCampo( Long.valueOf(nombreCampo) );
         if ( obligatorio.equals("S") ) dtoGuardar.setObligatorio( Boolean.TRUE);
         else dtoGuardar.setObligatorio( Boolean.FALSE);
         if ( modificable.equals("S") ) dtoGuardar.setModificable( Boolean.TRUE);
         else dtoGuardar.setModificable( Boolean.FALSE);
         traza("antes de valor por defecto");
         dtoGuardar.setValorDefecto(valorxdefecto);
         dtoGuardar.setOidPais(new UtilidadesSession().getPais(this));
         Vector objBussines = new Vector();
         objBussines.add(dtoGuardar);
           traza("dtoGuardar " + dtoGuardar );
         //-idBusiness = "MAEInsertarConfiguracionCampo"
         objBussines.add(new MareBusinessID("MAEInsertarConfiguracionCampo"));
         //-Se llama al ConectorGuardarConfiguracionCampos
         DruidaConector guardar = conectar("ConectorGuardarConfiguracionCampos",objBussines);
           traza("ConectorGuardarConfiguracionCampos");
         asignarAtributo("VAR","ejecutar","valor","fLimpiar()");
         asignarAtributo("VAR","cerrarVentana","valor","false");
           traza("Sale de accion Guardar");

      }


    } catch (Exception e) {
         lanzarPaginaError(e);
         logStackTrace(e);
      }
    getConfiguracionMenu("LPInsertarConfiguracionCampos",accion);

  }


  private void cargarDatosFiltro()  throws Exception  {
    Vector paramEntrada = new Vector();
    DTOBelcorp dtoIn = new DTOBelcorp();
    UtilidadesSession sesion = new UtilidadesSession();
    dtoIn.setOidIdioma( sesion.getIdioma(this) );
    dtoIn.setOidPais( sesion.getPais(this) );
    paramEntrada.add( dtoIn );
    paramEntrada.add( new MareBusinessID("MAECombosConfiguracionCampos") );
    DruidaConector con = conectar("ConectorRellenarCombosConfiguracionCampos",paramEntrada);
    DTOCombosConfiguracionCampos dtoOut = (DTOCombosConfiguracionCampos) con.objeto("DTOSalida");
         
    RecordSet rsNombreCampo = dtoOut.getCampos();
    Vector columnas = rsNombreCampo.getColumnIdentifiers();
    DruidaConector dcNC = UtilidadesBelcorp.generarConector( "dtoSalida.resultado_ROWSET", rsNombreCampo, columnas );
    asignar( "LISTA", "listaOcultaNC", dcNC);
         traza("***************dcNC*************************");
         
    RecordSet rsTipoCliente = dtoOut.getTipoCliente();
    columnas = rsTipoCliente.getColumnIdentifiers();
    DruidaConector dcTC = UtilidadesBelcorp.generarConector( "dtoSalida.resultado_ROWSET", rsTipoCliente, columnas );
    asignar( "COMBO", "cbTipoCliente", dcTC);
         traza("***************dcTC*************************");
         
    RecordSet rsSubtipoCliente = dtoOut.getSubtipoCliente();
    columnas = rsSubtipoCliente.getColumnIdentifiers();
    DruidaConector dcSTC = UtilidadesBelcorp.generarConector( "dtoSalida.resultado_ROWSET", rsSubtipoCliente,  columnas);
    asignar( "LISTA", "listaOcultaSTC", dcSTC);
         traza("***************dcSTC*************************");
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



} //class

/*************************************************************************************************
si accion="" { 
-idBusiness="MAECombosConfiguracionCampos" 
-Se crea un DTOBelcorp (Con el pais y el idioma) 
-Se llama al ConectorRellenarCombosConfiguracionCampos 
-Con el DTOConfiguracionCampo (en los recordset la primera columna es el value del combo y la segunda el elemento) : 
+con el atributo tipoCliente cargamos el combo tipoCliente 
+el atributo subtipoCliente lo guardamos como un array Javascript, ya que además contiene una tercera columna que es el tipo, de modo que cuando se seleccione el tipo cargamos en el combo subtipo todas las filas cuya tercera columna coincida con el value del combo tipoCliente 
+separamos el atributo campos en dos arrays Javascript según la tercera columna del recordset: 
Un array camposProductos con las filas cuya tercera columna sea "PRODUCTOS" 
Otro array camposClientes con las filas cuya tercera columna sea "CLIENTES" 
Ambos arrays tendrán las dos primeras columnas del recordset, que son el valor y el elemento para cargar el combo 
Como inicialmente el indClienteProducto está a true cargaremos en el combo campo el array camposClientes 

} 

si accion="Guardar" { 
-idBusiness = "MAEInsertarConfiguracionCampo" 
-se crea un DTOConfiguracionCampo de la siguiente forma: 
los atributos campo, obligatorio, modificable y valorDefecto se rellenan con el value de los correspondientes campos. 
el atributo subtipoCliente se rellena con el value del combo subtipoCliente se el campo indClienteProducto vale true, si vale false el atributo va a null. 
el atributo oid no se rellena (se generará automáticamente). 
-Se llama al ConectorGuardarConfiguracionCampos 
}

NOTAS
Los radioB obligatorio y modificable tienen las opciones "SI" y "NO" (en el idioma del usuario) y los valores true y false respectivamente 

El radioB indClienteProducto tiene dos opciones: "Cliente" y "Producto" con los valores true y false respectivamente.
Este campo no se va a guardar, sino que simplemente influye en la interfaz gráfica de la siguiente mamera:
Cuando este seleccionada la opción producto (false) se ocultan los combos tipoCliente y subtipoCliente (estarán en una capa), y por tanto dejan de ser obligatorios.

Cada vez que cambie el combo tipoCliente se debe recargar el de subtipoCliente filtrando por el tipo elegido (tenemos un array oculto con todas las posibilidades).

Cada vez que se cambie el indClienteProducto (que inicialmente está a true) se recarga el combo campo de la siguiente forma: si indCliente pasa a valer true se carga en campo el array camposClientes, si es false se carga el array camposProductos (estos arrays fueron guardados por la LP).
Todos los campos son obligatorios salvo los de tipo y subtipo cuando están ocultos.
****************************************************************************************************/
