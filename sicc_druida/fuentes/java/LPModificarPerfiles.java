/*
    INDRA/CAR/sicc
    $Id: LPModificarPerfiles.java,v 1.1 2009/12/03 18:43:02 pecbazalar Exp $
    Logica de Presentacion de Modificar Perfiles
*/

//import LPSICCBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import java.util.Vector;
import java.util.StringTokenizer;
import java.lang.StringBuffer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.IVariablesSesion;
import es.indra.mare.common.mgu.manager.Property;
import java.util.HashMap;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.DOMException;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusqueda;
import es.indra.sicc.dtos.men.DTOEntradaPresentarMenu;
import es.indra.sicc.dtos.men.DTOEntradaModificarPerfiles;
import es.indra.sicc.util.DTOSalida;

//import es.indra.sicc.dtos.men.DTOEntradaBorrarPerfiles;

// Definicion de la clase
public class LPModificarPerfiles extends LPSICCBase {
	
	private String accion="";
	private String perfil="";
	private String seleccionado="";
	private String buscado="";
	private static final String nombreLogica="LPModificarPerfiles";
	private boolean botonVolver = false;


    // Definicion del constructor
    public LPModificarPerfiles() 
    {
      super();
    }


    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception 
    {
    	setTrazaFichero();
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception 
    {

        try{
			this.rastreo();
			accion = conectorParametroLimpia("accion","",true);
			perfil = conectorParametroLimpia("txtNombrePerfil","",true);
			seleccionado = conectorParametroLimpia("seleccion","",true);
			buscado = conectorParametroLimpia("buscado","",true);
			traza("accion: " + accion);
			if(accion.equals("")){
				pagina("contenido_perfil_usuario_buscar");
				asignarAtributoPagina("cod", "052");
				asignarAtributo("VAR","conectorAction", "valor", nombreLogica );
				asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
				asignarAtributo("CAPA", "capaBotonConsultar", "visibilidad", "hidden");
				asignarAtributo("CAPA", "capaBotonModificar", "visibilidad", "hidden");
				asignarAtributo("CAPA", "capaBotonCopiar", "visibilidad", "hidden");
			}

			if(accion.equals("busca")){
				  buscarPerfil(perfil, false);
			} 
        }catch(Exception e){
			lanzarPaginaError(e);
			asignarAtributo("CAPA","capaResultado","visibilidad","hidden");
			asignarAtributo("CAPA","capaBotonModificar","visibilidad","hidden");
			asignarAtributo("CAPA", "capaBotonCopiar", "visibilidad", "hidden");                
			asignarAtributo("CAPA", "capaBotonConsultar", "visibilidad", "hidden");        
			asignarAtributo("VAR","accion","valor", accion);
			asignarAtributo("VAR","conectorAction", "valor", nombreLogica );
		}

	try{

		if(accion.equals("modifica")){
                consultarPerfil(seleccionado,"",perfil);
        } 
		
		if(accion.equals("ejecuta")){
                  String lista = conectorParametro("seleccionLista");
                  String inicio = conectorParametro("seleccionInicio");
                  lista = (lista == null ? "" :lista);
                  inicio = (inicio == null ? "" :inicio);
                  traza("lista: " + lista);
                  traza("inicio: " + inicio);
                  modificarPerfil(perfil,seleccionado,lista,inicio,buscado);
          }

        }catch(Exception e){
			lanzarPaginaError(e);
			asignarAtributo("CAPA","capaResultado","visibilidad","hidden");
			asignarAtributo("CAPA","capaBotonModificar","visibilidad","hidden");
			asignarAtributo("CAPA", "capaBotonCopiar", "visibilidad", "hidden");                
			asignarAtributo("CAPA", "capaBotonConsultar", "visibilidad", "hidden");        
			asignarAtributo("VAR","accion","valor", accion);
			asignarAtributo("VAR","conectorAction", "valor", nombreLogica );
		}
        getConfiguracionMenu();
    }

	private void buscarPerfil(String nombrePerfil, boolean bModificacion)throws Exception, MareException{
		// Parametro bModificacion: Si es true, provino del metodo modificar mas abajo, setea la variable
		// exitoModificar a "S" asi en el Javascript se puede recargar el menu para actualizar el menu de 
		// funciones - SSantana, 16/2/2004.

		pagina("contenido_perfil_usuario_buscar");
		asignarAtributoPagina("cod", "052");
		asignarAtributo("VAR","conectorAction", "valor", nombreLogica );
		asignarAtributo("CTEXTO","txtNombrePerfil","valor",nombrePerfil);
		if (bModificacion)
			asignarAtributo("VAR", "exitoModificar", "valor", "S");

		DTOEntradaCriteriosDeBusqueda  DTOCriterios = new DTOEntradaCriteriosDeBusqueda(nombrePerfil);
	    String usuario = (String)conectorParametroSesion("DruidaUsuario");
	    String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		DTOCriterios.setUsuario(usuario);
		DTOCriterios.setPassword(contrasenia);
		DruidaConector conectorConsultarPerfiles = null;
		MareBusinessID bussinesId = new MareBusinessID("MENBuscarPerfiles");

		Vector params = new Vector();
		params.add(DTOCriterios);
		params.add(bussinesId);
		traza("buscarPerfil - Antes de conectar");
		conectorConsultarPerfiles = conectar("ConectorConsultarPerfiles", params);
		traza("buscarPerfil - Despues de conectar");
		DTOSalida dtoSalida = (DTOSalida) conectorConsultarPerfiles.objeto("dtoSalida");

		RecordSet r = dtoSalida.getResultado();
    if (r.getRowCount() == 0)
    {
        String codigoError = null;
		traza("No se encontraron perfiles. Tira MareException");
        codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
        throw new MareException(null,null,UtilidadesError.armarCodigoError(codigoError) );
    }    
		DruidaConector con = generarConector("perfil",r,r.getColumnIdentifiers());

		asignarAtributo("CAPA","capaResultado","visibilidad","visible");
		asignar("LISTA", "lstResultado", con, "perfil");
		conectorParametroSesion("DTOCriteriosdeBusqueda", DTOCriterios);
		asignarAtributo("CAPA","capaBotonModificar","visibilidad","visible");
		asignarAtributo("CAPA", "capaBotonConsultar", "visibilidad", "hidden");
		asignarAtributo("CAPA", "capaBotonCopiar", "visibilidad", "hidden");        
		asignarAtributo("VAR","accion","valor","modifica");
		if (botonVolver)
		{
			traza("voy a asignar S a modificado ");
             asignarAtributo("VAR","botonVolver", "valor", "S");
		}

	}


	private void consultarPerfil(String nombrePerfil,String mensaje, String buscado)throws Exception, MareException
  {
      traza("Función consultarPerfil");
			pagina("contenido_perfil_usuarios_modificar");

			String usuario = (String)conectorParametroSesion("DruidaUsuario");
			String contrasenia = (String)conectorParametroSesion("DruidaPassword");

			asignarAtributoPagina("cod", "052");
			asignarAtributo("VAR","conectorAction", "valor", nombreLogica );
			asignarAtributo("VAR","accion","valor","ejecuta");
			asignarAtributo("VAR","seleccion","valor",nombrePerfil);
			asignarAtributo("VAR","buscado","valor",buscado);
			asignarAtributo("CTEXTO","txtNombrePerfil","valor",nombrePerfil);
			traza("Buscado Consultar: "+buscado);
	/*		if(mensaje.length()>0)
      {
				traza("mensaje.length>0");	
				asignarAtributo("VAR","mensaje", "valor", mensaje);
				traza("Paso");
			}else
      { */
        
				DTOEntradaPresentarMenu DTOCriteriosFunciones = new DTOEntradaPresentarMenu();
				DTOCriteriosFunciones.setUsuario(usuario);
				DTOCriteriosFunciones.setPassword(contrasenia);
				DruidaConector ConectorConsultarFunciones = null;
				MareBusinessID bussinesIdFunciones = new MareBusinessID("MENConsultaFunciones");
				Vector paramsFunciones = new Vector();
        
        DTOCriteriosFunciones.setOidIdioma(UtilidadesSession.getIdioma(this));
				paramsFunciones.add(DTOCriteriosFunciones);
				paramsFunciones.add(bussinesIdFunciones);
				//traigo todas las funciones del menu
        traza("Antes de conectar");
				ConectorConsultarFunciones = conectar("ConectorConsultarFuncionesFinales", paramsFunciones);
        traza("Despues de conectar");        
    		asignar(	"REJILLA", "contenidoDinamico", transformar("XslMantenimientoPerfiles", ConectorConsultarFunciones) );

				DTOEntradaCriteriosDeBusqueda  DTOCriteriosPerfil = new DTOEntradaCriteriosDeBusqueda();

				DTOCriteriosPerfil.setUsuario(usuario);
				DTOCriteriosPerfil.setPassword(contrasenia);

	  			DTOCriteriosPerfil.setNombrePerfil(nombrePerfil);
			    DTOCriteriosPerfil.setOidIdioma(UtilidadesSession.getIdioma(this) );
        
				MareBusinessID bussinesIdPerfil = new MareBusinessID("MENConsultarPerfiles");
				DruidaConector ConectorConsultarPerfil = null;
				Vector paramsPerfil = new Vector();
				paramsPerfil.add(DTOCriteriosPerfil);
				paramsPerfil.add(bussinesIdPerfil);
        
        traza("Antes de conectar 2");
				ConectorConsultarPerfil = conectar("ConectorConsultarFuncionesPerfil", paramsPerfil);
        traza("Despues de conectar 2");
        traza("ConectorConsultarPerfil: " + ConectorConsultarPerfil.getXML() );

        Vector vFuncionesSeleccionadasOid = valorVector("id", ConectorConsultarPerfil);
        Vector vFuncionesSeleccionadasInicio = valorVector("inicio", ConectorConsultarPerfil);
        traza("Vector vFuncionesSeleccionadasOid: " + vFuncionesSeleccionadasOid.toString() );
        traza("Vector vFuncionesSeleccionadasInicio: " + vFuncionesSeleccionadasInicio.toString() );

        StringBuffer sOids = new StringBuffer("");
        StringBuffer sInicio = new StringBuffer("");

        for (int i=0; i<vFuncionesSeleccionadasOid.size(); i++)
        {
            if (i != 0)
            {
              sOids.append("|");
              sInicio.append("|");
            }
            sOids.append( vFuncionesSeleccionadasOid.get(i).toString() ) ;
            sInicio.append( vFuncionesSeleccionadasInicio.get(i).toString() );
        }
        
        asignarAtributo("VAR", "seleccionadasOid", "valor", sOids.toString() );
        asignarAtributo("VAR", "seleccionadasInicio", "valor", sInicio.toString() );
        

//     }

      traza("Sale de consultarPerfil");
	}

	private void modificarPerfil(String nombrePerfil, 
			String nombrePerfilViejo,
			String listaFunciones, 
		    String pantallaInicio,
			String buscado)throws Exception, MareException
  {
    traza("funcion modificarPerfil");		
		pagina("contenido_perfil_usuarios_modificar");
		asignarAtributoPagina("cod", "052");

    
		DTOEntradaModificarPerfiles DTOModificar = new DTOEntradaModificarPerfiles();
		MareBusinessID bussinesId = new MareBusinessID("MENModificarPerfiles");
		Vector vFunciones = new Vector();
    traza("listaFunciones: " + listaFunciones );
    
		StringTokenizer st = new StringTokenizer(listaFunciones,"|");
    String sBuffer = null;    
    
  	while (st.hasMoreTokens()) 
    {
      sBuffer = st.nextToken();
      if (sBuffer.startsWith("_"))
      {
        // Quita el "_"
        sBuffer = sBuffer.substring(1, sBuffer.length());

      }
      traza("sBuffer: " + sBuffer);      
		  vFunciones.add(sBuffer);
		}
    if ( pantallaInicio != null && !pantallaInicio.equals("") )
      pantallaInicio = pantallaInicio.substring(1, pantallaInicio.length());    
    traza("vFunciones: " + vFunciones.toString() );
    traza("nombrePerfil: " + nombrePerfil);
    traza("pantallaInicio: " + pantallaInicio);
    traza("nombrePerfilViejo: " + nombrePerfilViejo);

	    String usuario = (String)conectorParametroSesion("DruidaUsuario");
	    String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		DTOModificar.setUsuario(usuario);
		DTOModificar.setPassword(contrasenia);

		DTOModificar.setNombreDePerfil(nombrePerfil);
		DTOModificar.setListaDeFuncionesAcciones(vFunciones);


		DTOModificar.setPantallaInicioDeAplicacionAsociada(pantallaInicio);
		DTOModificar.setNombreDePerfilViejo(nombrePerfilViejo);
		Vector params = new Vector();

		params.add(DTOModificar);
		params.add(bussinesId);		
    traza("Antes de conectar");
		conectar("ConectorModificarPerfiles", params);
    traza("Despues de conectar");
//		consultarPerfil(nombrePerfil,"",buscado);
        botonVolver = true;
        traza("Fue modificado");

/*		HashMap hs = (HashMap)this.conectorParametroSesion( IVariablesSesion.PROPERTIES_USUARIO );
    
		Property prop = (Property) hs.get( IVariablesSesion.PERFIL_USUARIO  ) ;
    if (prop == null)
    {
      traza("Prop es null");
    } else
  		traza("Prop: " + prop.toString() );*/
    //String PerfilUsuario = UtilidadesSession.getPerfil(this);
    //traza("Perfil Usuario: "+ PerfilUsuario );    
    //traza("Nombre de Perfil Modificado: " + nombrePerfil);
		buscarPerfil(nombrePerfil, true);
	}

	private DruidaConector generarConector(String rowsetID,RecordSet datos,Vector columns)
		throws DOMException,Exception
	{
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();

		if ( columns == null ){
			columns = new Vector();
		}

		Vector columsDesc = datos.getColumnIdentifiers();		
		
		DruidaConector conectorValoresPosibles = new DruidaConector();				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		
		for (int i=0; i < sizeRows; i++)
		{
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);

			for (int j=0; j < sizeColums; j++){
				if ( columns.contains(columsDesc.elementAt(j)) ){
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt);
					e_row.appendChild(e_campo2);
				}
			}
		}	
		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		return conectorValoresPosibles;
	}  
}
