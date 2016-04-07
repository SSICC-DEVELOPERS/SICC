/**
 * Sistema:           Belcorp - SICC
 * Modulo:            MEN - Menu
 * Componente:        LPEliminarUsuarios
 * @version           2.0
 */ 

import java.io.*;


import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.sicc.util.UtilidadesSession;
import java.util.*;
import java.io.*;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.sicc.util.IVariablesSesion;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException; 

import es.indra.sicc.dtos.men.DTOEntradaBorrarUsuario;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios;

/* By jalem - 26/01/2004
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
*/
public class LPEliminarUsuarios extends LPSICCBase {

         String accion            		= null;

         String pIdentificadorUsuario	= null;
         String pNombre1					= null;
         String pNombre2					= null;
         String pApellido1					= null;
         String pApellido2					= null;
         String pPerfil						= null;
         String pTelefono					= null;
         String pDepartamento				= null;
         String pValidezDesde				= null;
         String pHasta						= null;
         String pTipoUsuario				= null;
         String pUsuarioHabilitado		= null;

         String pelementosSeleccionados = null;

   Vector paramEntrada                    = null;
   Vector datosUsuario                             = null;

         DTOEntradaCriteriosDeBusquedaUsuarios dtoe 	= null;
         DTOEntradaBorrarUsuario dtoeBorrar 				= null;
          
   DruidaConector conectorBuscar                                    = null;
   DruidaConector conectorEliminarUsuarios      = null;
   
   Long idioma;
   Long pais;

    public LPEliminarUsuarios() {super();}

    public void inicio() throws Exception {
         pagina("contenido_usuarios_buscar");
                  asignarAtributoPagina("cod", "010");
    }

    public void ejecucion() throws Exception {
				setTrazaFichero();

                  asignarAtributo("VAR","usuarioSesion", "valor", conectorParametroSesion("DruidaUsuario").toString());
				
				  rastreo();
                  accion            			= conectorParametroLimpia("accion","",true);
                  pelementosSeleccionados	= conectorParametroLimpia("elementosSeleccionados","",true);

                  pIdentificadorUsuario	= conectorParametroLimpia("txtUsuario","",true);
                  pNombre1						= conectorParametroLimpia("txtPrimerNombre","",true);
                  pNombre2						= conectorParametroLimpia("txtSegundoNombre","",true);
                  pApellido1					= conectorParametroLimpia("txtPrimerApellido","",true);
                  pApellido2					= conectorParametroLimpia("txtSegundoApellido","",true);
                  pPerfil						= conectorParametroLimpia("cbPerfil","",true);
                  pTelefono					= conectorParametroLimpia("txtTelefono","",true);
                  pDepartamento				= conectorParametroLimpia("cbDepartamento","",true);
                  pValidezDesde				= conectorParametroLimpia("txtValidezDesde","",true);
                  pHasta						= conectorParametroLimpia("txtHasta","",true);
                  pTipoUsuario				= conectorParametroLimpia("cbTipoUsuario","",true);
                  pUsuarioHabilitado		= conectorParametroLimpia("rbUsuarioHabilitado","",true);

                  idioma = UtilidadesSession.getIdioma(this);

                  dtoe = new DTOEntradaCriteriosDeBusquedaUsuarios();
                  dtoeBorrar = new DTOEntradaBorrarUsuario();
  				  String usuario = (String)conectorParametroSesion("DruidaUsuario");
				  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
				  dtoe.setUsuario(usuario);
				  dtoe.setPassword(contrasenia);
				  dtoeBorrar.setUsuario(usuario);
				  dtoeBorrar.setPassword(contrasenia);


                  traza("accion: " + accion);

                  if (accion.equals("")){
                          obtenerCombosBusqueda(idioma); //llena perfiles y departamentos
						  generarHiddenFormatoFecha();
						  asignarAtributo("VAR","casoDeUso", "valor", "eliminar");
						  asignarAtributo("VAR","accion", "valor", "Buscar");
                          asignarAtributo("VAR","conectorAction", "valor", "LPEliminarUsuarios");
						 this.asignarAtributoElemento("frmFormulario", "oculto", "S");  
                  }

                  try
                  {
                           if( accion.equals("Buscar") || accion.equals("VolverElimina") ) {

                                    dtoe = new DTOEntradaCriteriosDeBusquedaUsuarios();
									dtoe.setUsuario(usuario);
									dtoe.setPassword(contrasenia);
                                    obtenerParametrosBusqueda(dtoe, accion);
                                    
                                    generarHiddenFormatoFecha();
                                    mostrarResultadosBusqueda();

                           }
                           
                           if( accion.equals("Eliminar") ){
									pagina("salidaGenerica");
									eliminarUsuarios(pelementosSeleccionados);
                           }
                           
                  }catch (Exception ex) {
                                    this.lanzarPaginaError(ex);
                  }
                  
                  getConfiguracionMenu(); //menú secundario
    }

          private void eliminarUsuarios(String elementosSeleccionados ) throws Exception{

          dtoeBorrar = new DTOEntradaBorrarUsuario();
	      String usuario = (String)conectorParametroSesion("DruidaUsuario");
	      String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		  dtoeBorrar.setUsuario(usuario);
		  dtoeBorrar.setPassword(contrasenia);
          dtoeBorrar.setIdUsuario(elementosSeleccionados );
          MareBusinessID id = new MareBusinessID("MENEliminarUsuarios");

          Vector paramEntrada = new Vector();
          paramEntrada.addElement(dtoeBorrar);
          paramEntrada.addElement(id);

          conectorEliminarUsuarios = conectar("ConectorEliminarUsuarios",paramEntrada);
		  asignarAtributo("VAR","ejecutar","valor","enviarFormulario()");
    }    

         private void mostrarResultadosBusqueda() throws Exception {

                  asignarAtributo("CTEXTO","txtUsuario", "valor", pIdentificadorUsuario);
                  asignarAtributo("CTEXTO","txtPrimerNombre", "valor", pNombre1);
                  asignarAtributo("CTEXTO","txtSegundoNombre", "valor", pNombre2);
                  asignarAtributo("CTEXTO","txtPrimerApellido", "valor", pApellido1);
                  asignarAtributo("CTEXTO","txtSegundoApellido", "valor", pApellido2);
                  asignarAtributo("VAR","hPerfil", "valor", pPerfil);								//asignarAtributo("COMBO","cbPerfil", "valor", pPerfil);		
                  asignarAtributo("CTEXTO","txtTelefono", "valor", pTelefono);		
                  asignarAtributo("VAR","hDepartamento", "valor", pDepartamento);				//asignarAtributo("COMBO","cbDepartamento", "valor", pDepartamento);		
                  asignarAtributo("CTEXTO","txtValidezDesde", "valor", pValidezDesde);
                  asignarAtributo("CTEXTO","txtHasta", "valor", pHasta);		
                  asignarAtributo("VAR","hTipoUsuario", "valor", pTipoUsuario);					//asignarAtributo("COMBO","cbTipoUsuario", "valor", pTipoUsuario);
                  asignarAtributo("VAR","hUsuarioHabilitado", "valor", pUsuarioHabilitado);	//asignarAtributo("RADIO","rbUsuarioHabilitado", "valor", pUsuarioHabilitado);

                  DTOEntradaCriteriosDeBusquedaUsuarios dtoe = (DTOEntradaCriteriosDeBusquedaUsuarios) conectorParametroSesion("dtoeBuscar");
				  String usuario = (String)conectorParametroSesion("DruidaUsuario");
				  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
				  dtoe.setUsuario(usuario);
				  dtoe.setPassword(contrasenia);
                  
                  paramEntrada = new Vector();
                  paramEntrada.add( dtoe );
                  paramEntrada.add( new MareBusinessID("MENBuscarUsuarios") );
                  conectorBuscar = conectar("ConectorBuscarUsuario", paramEntrada);
                  asignarAtributo("VAR","casoDeUso", "valor", "eliminar");
                  asignar("LISTADOA","listado1",conectorBuscar,"dtoSalida.resultado_ROWSET");

                  asignarAtributo("VAR","accion", "valor", "Buscar");
                  asignarAtributo("VAR","conectorAction", "valor", "LPEliminarUsuarios");
                  
                  obtenerCombosBusqueda(idioma); //llena perfiles y departamentos
         }

         private void obtenerParametrosBusqueda(DTOEntradaCriteriosDeBusquedaUsuarios dtoe, String accion) throws Exception{
                  
                  String origen = "sesion";
                  
                  if ( accion.equals("Buscar") ) origen = "pagina";
                  
                  if (origen.equals("sesion") ){
                           
                           //Se recoge el DTOEntradaGenerico de la sesión. 		
                           dtoe = (DTOEntradaCriteriosDeBusquedaUsuarios) conectorParametroSesion("dtoeBuscar");
						   String usuario = (String)conectorParametroSesion("DruidaUsuario");
						   String contrasenia = (String)conectorParametroSesion("DruidaPassword");
						   dtoe.setUsuario(usuario);
						   dtoe.setPassword(contrasenia);

                           pIdentificadorUsuario 	= (String) dtoe.getIdUsuario();
                           pNombre1    				= (String) dtoe.getNombreUsuario1();
                           pNombre2    				= (String) dtoe.getNombreUsuario2();
                           pApellido1    				= (String) dtoe.getApellidoUsuario1();
                           pApellido2    				= (String) dtoe.getApellidoUsuario2();

                           //pPerfil						= (String) dtoe.getPerfil();
							pPerfil						= "";
                           pTelefono					= (String) dtoe.getTelefonoContacto();
                           pDepartamento				= (String) dtoe.getDepartamento();
                           pValidezDesde				= (String) dtoe.getValidezDesde();
                           pHasta						= (String) dtoe.getValidezHasta();
                           pTipoUsuario				= (String) dtoe.getTipoUsuario();
                           pUsuarioHabilitado		= (String) dtoe.getUsuarioHabilitado();

                  } else { //pagina.
                           
                           //traza("saca de pagina");
                           pIdentificadorUsuario	= conectorParametroLimpia("txtUsuario","",true);
                           pNombre1						= conectorParametroLimpia("txtPrimerNombre","",true);
                           pNombre2						= conectorParametroLimpia("txtSegundoNombre","",true);
                           pApellido1					= conectorParametroLimpia("txtPrimerApellido","",true);
                           pApellido2					= conectorParametroLimpia("txtSegundoApellido","",true);
                           pPerfil						= conectorParametroLimpia("cbPerfil","",true);
                           pTelefono					= conectorParametroLimpia("txtTelefono","",true);
                           pDepartamento				= conectorParametroLimpia("cbDepartamento","",true);
                           pValidezDesde				= conectorParametroLimpia("txtValidezDesde","",true);
                           pHasta						= conectorParametroLimpia("txtHasta","",true);
                           pTipoUsuario				= conectorParametroLimpia("cbTipoUsuario","",true);
                           pUsuarioHabilitado		= conectorParametroLimpia("rbUsuarioHabilitado","",true);
                           
                           dtoe.setIdUsuario( pIdentificadorUsuario );
                           dtoe.setNombreUsuario1( pNombre1 );
                           dtoe.setNombreUsuario2( pNombre2 );
                           dtoe.setApellidoUsuario1( pApellido1 );
                           dtoe.setApellidoUsuario2( pApellido2 );

						   dtoe.setPerfil( pPerfil );
                           dtoe.setTelefonoContacto( pTelefono );
                           dtoe.setDepartamento( pDepartamento );
                           dtoe.setValidezDesde( pValidezDesde );
                           dtoe.setValidezHasta( pHasta );
                           dtoe.setTipoUsuario( pTipoUsuario );
                           dtoe.setUsuarioHabilitado( pUsuarioHabilitado );
                           dtoe.setFormatoFecha(UtilidadesSession.getFormatoFecha(this) );
                           //Se almacena el DTOEntradaGenerico en sesión. 
                           conectorParametroSesion("dtoeBuscar",dtoe);
                  }
         }

         private void obtenerCombosBusqueda(Long idioma) throws Exception {

                  paramEntrada = new Vector();
                  
                  MareDTO dtoe = new MareDTO();
                  dtoe.setProperty("idioma", idioma);
                  
                  paramEntrada.add( dtoe );
                  paramEntrada.add( new MareBusinessID("MENCargaDatosEnPantalla") );
                  conectorBuscar = conectar("ConectorCargaDatosPantalla", paramEntrada);

                  asignar("COMBO","cbPerfil",conectorBuscar,"dtoSalida.perfiles_ROWSET");
                  asignar("COMBO","cbDepartamento",conectorBuscar,"dtoSalida.departamentos_ROWSET");
         }
                  
}

