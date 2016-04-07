/**
 * Sistema:           Belcorp - SICC
 * Modulo:            MEN - Menu
 * Componente:        LPConsultarUsuarios
 * @version           2.0
 */ 

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.men.DTOEntradaConsultarUsuario;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/* jalem 26/01/2004
 
 import es.indra.sicc.util.BelcorpError;
 import es.indra.sicc.util.IBelcorpError;
 import es.indra.sicc.util.DTOError;
 
 */

public class LPConsultarUsuarios extends LPSICCBase {
	
	private final int SIZE_LABEL = 8;
	
	String accion = null;
	
	String pIdentificadorUsuario = null;
	String pNombre1 = null;
	String pNombre2	= null;
	String pApellido1 = null;
	String pApellido2 = null;
	String pPerfil = null;
	String pTelefono = null;
	String pDepartamento = null;
	String pValidezDesde = null;
	String pHasta = null;
	String pTipoUsuario = null;
	String pUsuarioHabilitado = null;
	String pelementosSeleccionados= null;
	Vector paramEntrada = null;
	Vector datosUsuario = null;	
	DTOEntradaCriteriosDeBusquedaUsuarios dtoe = null;
	DTOEntradaConsultarUsuario dtoeConsultar = null;
	DruidaConector conectorBuscar = null;
	DruidaConector conectorConsultar = null;      
	Long idioma;
	Long pais;
	
	public LPConsultarUsuarios() {
        super();
    }
	
	public void inicio() throws Exception {
		//pagina("contenido_usuarios_buscar");
	}
	
	public void ejecucion() throws Exception {
    
        try{
            accion = conectorParametroLimpia("accion","",true);
            setTrazaFichero();
            pelementosSeleccionados = conectorParametroLimpia("elementosSeleccionados","",true);
            pIdentificadorUsuario	= conectorParametroLimpia("txtUsuario","",true);
            pNombre1 = conectorParametroLimpia("txtPrimerNombre","",true);
            pNombre2 = conectorParametroLimpia("txtSegundoNombre","",true);
            pApellido1 = conectorParametroLimpia("txtPrimerApellido","",true);
            pApellido2 = conectorParametroLimpia("txtSegundoApellido","",true);
            pPerfil = conectorParametroLimpia("cbPerfil","",true);
            pTelefono	= conectorParametroLimpia("txtTelefono","",true);
            pDepartamento = conectorParametroLimpia("cbDepartamento","",true);
            pValidezDesde = conectorParametroLimpia("txtValidezDesde","",true);
            pHasta = conectorParametroLimpia("txtHasta","",true);
            pTipoUsuario = conectorParametroLimpia("cbTipoUsuario","",true);
            pUsuarioHabilitado = conectorParametroLimpia("rbUsuarioHabilitado","",true);
            idioma = UtilidadesSession.getIdioma( this );
            pais = UtilidadesSession.getPais( this );
            dtoe = new DTOEntradaCriteriosDeBusquedaUsuarios();
            dtoeConsultar = new DTOEntradaConsultarUsuario();
			String usuario = (String)conectorParametroSesion("DruidaUsuario");
			String contrasenia = (String)conectorParametroSesion("DruidaPassword");
			dtoe.setUsuario(usuario);
			dtoe.setPassword(contrasenia);
			dtoeConsultar.setUsuario(usuario);
			dtoeConsultar.setPassword(contrasenia);

            traza("accion: " + accion);
            if (accion.equals("")){
                pagina("contenido_usuarios_buscar");
                rastreo();
                generarHiddenFormatoFecha();
                asignarAtributo("VAR","casoDeUso", "valor", "consultar");                           
                obtenerCombosBusqueda(idioma); //llena perfiles y departamentos
                asignarAtributo("VAR","accion", "valor", "Buscar");
                asignarAtributo("VAR","conectorAction", "valor", "LPConsultarUsuarios");
            }
            else if (accion.equals("Buscar") || accion.equals("VolverConsulta") ) {
                dtoe = new DTOEntradaCriteriosDeBusquedaUsuarios();
				dtoe.setUsuario(usuario);
				dtoe.setPassword(contrasenia);
                obtenerParametrosBusqueda(dtoe, accion);        
                pagina("contenido_usuarios_buscar");
                //asignarAtributo("VAR","casoDeUso", "valor", "consultar");
                generarHiddenFormatoFecha();
                mostrarResultadosBusqueda();
            }
            else if( accion.equals("Consultar") ){
                pagina("contenido_usuario_consultar");
                pelementosSeleccionados = conectorParametroLimpia("elementosSeleccionados","",true);
                conectorParametroSesion("elementosSeleccionados",pelementosSeleccionados);
                dtoeConsultar.setIdUsuario(pelementosSeleccionados);
                dtoeConsultar.setOidIdioma(idioma);
                conectorParametroSesion("dtoeConsultar",dtoeConsultar);
                paramEntrada = new Vector();
                paramEntrada.add( dtoeConsultar );
                paramEntrada.add( new MareBusinessID("MENConsultarUsuarios2") );
                conectorConsultar = conectar("ConectorConsultarUsuarios2", paramEntrada);					
                
                RecordSet rsUsu = ((DTOSalida)conectorConsultar.objeto("DTOSalida")).getResultado();
                
                //UtilidadesLog.debug(rsUsu);
                
                String claveInicial = "";
                String apellido1 = "";
                String apellido2 = "";
                String apeCasada = "";
                String nombre1 = "";
                String nombre2 = "";
                String email = "";
                String telefono = "";
                String departamento = "";
                String idenPC = "";
                String valDesde = "";
                String valHasta = "";
                String tipoUsuario = "";
                String idioma = "";
                String pantallaInicio = "";
                String rastreo = "";
                String rasDesde = "";
                String rasHasta = "";
                String sustUsuario = "";
                String sustDesde = "";
                String sustHasta = "";
                String sustObser = "";
                String indNodDig = "";
                String indAdmNod = "";
                String sociedades = "";
                String marcas = "";
                String canales = "";
                String accesos = "";
                String subAccesos = "";
                String paises = "";
                String sgvs = "";
                String regiones = "";
                String zonas = "";
                String secciones = "";
                String territorios = "";
                String sociedadDF = "";
                String marcaDF = "";
                String canalDF = "";
                String accesoDF = "";
                String subAccesoDF = "";
                String paisDF = "";
                String sgvDF = "";
                String regionDF = "";
                String zonaDF = "";
                String seccionDF = "";
                String territorioDF = "";
                String perfiles = "";
                String habilitado = "";

                int idPrp = 0;
                for(int i = 0; i<rsUsu.getRowCount(); i++){
                    if(rsUsu.getValueAt(i,0)!=null){
                        idPrp = ((BigDecimal)rsUsu.getValueAt(i,0)).intValue();
                    }else{
                        idPrp = -10; // EL valor -10 sirve para no procesar la linea en caso el IdProperti sea nulo
                    }
                    switch(idPrp){
                        case -1: if(rsUsu.getValueAt(i,4)!=null){perfiles += (perfiles.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 1: if(rsUsu.getValueAt(i,3)!=null) claveInicial=(String)rsUsu.getValueAt(i,3); break;
                        case 2: if(rsUsu.getValueAt(i,3)!=null) apellido1=(String)rsUsu.getValueAt(i,3); break;
                        case 3: if(rsUsu.getValueAt(i,3)!=null) apellido2=(String)rsUsu.getValueAt(i,3); break;
                        case 4: if(rsUsu.getValueAt(i,3)!=null) apeCasada=(String)rsUsu.getValueAt(i,3); break;
                        case 5: if(rsUsu.getValueAt(i,3)!=null) nombre1=(String)rsUsu.getValueAt(i,3); break;
                        case 6: if(rsUsu.getValueAt(i,3)!=null) nombre2=(String)rsUsu.getValueAt(i,3); break;
                        case 7: if(rsUsu.getValueAt(i,3)!=null) email=(String)rsUsu.getValueAt(i,3); break;
                        case 8: if(rsUsu.getValueAt(i,3)!=null) telefono=(String)rsUsu.getValueAt(i,3); break;
                        case 9: if(rsUsu.getValueAt(i,4)!=null) departamento=(String)rsUsu.getValueAt(i,4); break;
                        case 10: if(rsUsu.getValueAt(i,3)!=null) idenPC=(String)rsUsu.getValueAt(i,3); break;
                        case 11: if(rsUsu.getValueAt(i,3)!=null) valDesde=(String)rsUsu.getValueAt(i,3); break;
                        case 12: if(rsUsu.getValueAt(i,3)!=null) valHasta=(String)rsUsu.getValueAt(i,3); break;
                        case 13: if(rsUsu.getValueAt(i,3)!=null) tipoUsuario=(String)rsUsu.getValueAt(i,3); break;
                        case 28: if(rsUsu.getValueAt(i,4)!=null) idioma=(String)rsUsu.getValueAt(i,4); break;
                        case 29: if(rsUsu.getValueAt(i,4)!=null) pantallaInicio=(String)rsUsu.getValueAt(i,4); break;
                        case 18: if(rsUsu.getValueAt(i,3)!=null) rastreo=(String)rsUsu.getValueAt(i,3); break;
                        case 45: if(rsUsu.getValueAt(i,3)!=null) rasDesde=(String)rsUsu.getValueAt(i,3); break;
                        case 44: if(rsUsu.getValueAt(i,3)!=null) rasHasta=(String)rsUsu.getValueAt(i,3); break;
                        case 19: if(rsUsu.getValueAt(i,4)!=null) sustUsuario=(String)rsUsu.getValueAt(i,4); break;
                        case 20: if(rsUsu.getValueAt(i,3)!=null) sustDesde=(String)rsUsu.getValueAt(i,3); break;
                        case 21: if(rsUsu.getValueAt(i,3)!=null) sustHasta=(String)rsUsu.getValueAt(i,3); break;
                        case 22: if(rsUsu.getValueAt(i,3)!=null) sustObser=(String)rsUsu.getValueAt(i,3); break;
                        case 54: if(rsUsu.getValueAt(i,3)!=null) indNodDig=(String)rsUsu.getValueAt(i,3); break;
                        case 55: if(rsUsu.getValueAt(i,3)!=null) indAdmNod=(String)rsUsu.getValueAt(i,3); break;
                        case 30: if(rsUsu.getValueAt(i,4)!=null){sociedades += (sociedades.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 24: if(rsUsu.getValueAt(i,4)!=null){marcas += (marcas.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 25: if(rsUsu.getValueAt(i,4)!=null){canales += (canales.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 26: if(rsUsu.getValueAt(i,4)!=null){accesos += (accesos.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 27: if(rsUsu.getValueAt(i,4)!=null){subAccesos += (subAccesos.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 36: if(rsUsu.getValueAt(i,4)!=null){paises += (paises.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 42: if(rsUsu.getValueAt(i,4)!=null){sgvs += (sgvs.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 38: if(rsUsu.getValueAt(i,4)!=null){regiones += (regiones.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 39: if(rsUsu.getValueAt(i,4)!=null){zonas += (zonas.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 40: if(rsUsu.getValueAt(i,4)!=null){secciones += (secciones.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 41: if(rsUsu.getValueAt(i,4)!=null){territorios += (territorios.equals("")) ? (String)rsUsu.getValueAt(i,4) : ("<BR/>"+(String)rsUsu.getValueAt(i,4));} break;
                        case 48: if(rsUsu.getValueAt(i,4)!=null) sociedadDF=(String)rsUsu.getValueAt(i,4); break;
                        case 49: if(rsUsu.getValueAt(i,4)!=null) marcaDF=(String)rsUsu.getValueAt(i,4); break;
                        case 50: if(rsUsu.getValueAt(i,4)!=null) canalDF=(String)rsUsu.getValueAt(i,4); break;
                        case 51: if(rsUsu.getValueAt(i,4)!=null) accesoDF=(String)rsUsu.getValueAt(i,4); break;
                        case 52: if(rsUsu.getValueAt(i,4)!=null) subAccesoDF=(String)rsUsu.getValueAt(i,4); break;
                        case 31: if(rsUsu.getValueAt(i,4)!=null) paisDF=(String)rsUsu.getValueAt(i,4); break;
                        case 43: if(rsUsu.getValueAt(i,4)!=null) sgvDF=(String)rsUsu.getValueAt(i,4); break;
                        case 33: if(rsUsu.getValueAt(i,4)!=null) regionDF=(String)rsUsu.getValueAt(i,4); break;
                        case 34: if(rsUsu.getValueAt(i,4)!=null) zonaDF=(String)rsUsu.getValueAt(i,4); break;
                        case 35: if(rsUsu.getValueAt(i,4)!=null) seccionDF=(String)rsUsu.getValueAt(i,4); break;
                        case 53: if(rsUsu.getValueAt(i,4)!=null) territorioDF=(String)rsUsu.getValueAt(i,4); break;
                        case 23: if(rsUsu.getValueAt(i,3)!=null) habilitado=(String)rsUsu.getValueAt(i,3); break;
                    }
                }
                
                asignarAtributo("LABELC","lblIdentificadorUsuario", "valor", pelementosSeleccionados);
                asignarAtributo("VAR","hIndicacionClaveInicial", "valor", claveInicial);
                asignarAtributo("LABELC","lblPerfil","valor",perfiles);
                int lin = obtenerCantFilas(perfiles);
                if(lin>1)asignarAtributo("LABELC","lblPerfil","alto","" + SIZE_LABEL*lin);
                asignarAtributo("VAR", "hUsuarioHabilitado", "valor", habilitado);
                asignarAtributo("LABELC","lblPrimerApellido", "valor", apellido1 );
                asignarAtributo("LABELC","lblSegundoApellido", "valor", apellido2);
                asignarAtributo("LABELC","lblApellidoCasada", "valor", apeCasada);
                asignarAtributo("LABELC","lblPrimerNombre", "valor", nombre1);
                asignarAtributo("LABELC","lblSegundoNombre", "valor", nombre2);
                asignarAtributo("LABELC","lblEMail", "valor", email);
                asignarAtributo("LABELC","lblTelefono", "valor", telefono);
                asignarAtributo("LABELC","lblDepartamento", "valor", departamento);
                asignarAtributo("LABELC","lblIdentificadorPC", "valor", idenPC);
                if ( !valDesde.equals("")){
                    try{
                        valDesde = UtilidadesBelcorp.fechalongToString(this, Long.parseLong( valDesde ));
                    }catch(Exception e) {}
                }
                asignarAtributo("LABELC","lblValidezDesde", "valor", valDesde);
                if ( !valHasta.equals("")){
                    try{
                        valHasta = UtilidadesBelcorp.fechalongToString(this, Long.parseLong( valHasta ));
                    }catch(Exception e) {}
                }
                asignarAtributo("LABELC","lblValidezHasta", "valor", valHasta);
                asignarAtributo("LABELC","lblSociedad","valor",sociedades);
                lin = obtenerCantFilas(sociedades);
                if(lin>1)asignarAtributo("LABELC","lblSociedad","alto","" + SIZE_LABEL*lin);
                asignarAtributo("LABELC","lblMarca","valor",marcas);
                lin = obtenerCantFilas(marcas);
                if(lin>1)asignarAtributo("LABELC","lblMarca","alto","" + SIZE_LABEL*lin);
                asignarAtributo("LABELC","lblCanal","valor",canales);
                lin = obtenerCantFilas(canales);
                if(lin>1)asignarAtributo("LABELC","lblCanal","alto","" + SIZE_LABEL*lin);
                asignarAtributo("LABELC","lblAcceso","valor",accesos);
                lin = obtenerCantFilas(accesos);
                if(lin>1)asignarAtributo("LABELC","lblAcceso","alto","" + SIZE_LABEL*lin);
                asignarAtributo("LABELC","lblSubnivelAcceso","valor",subAccesos);
                lin = obtenerCantFilas(subAccesos);
                if(lin>1)asignarAtributo("LABELC","lblSubnivelAcceso","alto","" + SIZE_LABEL*lin);
                asignarAtributo("LABELC","lblPais","valor", paises);
                lin = obtenerCantFilas(paises);
                if(lin>1)asignarAtributo("LABELC","lblPais","alto","" + SIZE_LABEL*lin);
                asignarAtributo("LABELC","lblSubgerencia","valor",sgvs);
                lin = obtenerCantFilas(sgvs);
                if(lin>1)asignarAtributo("LABELC","lblSubgerencia","alto","" + SIZE_LABEL*lin);
                asignarAtributo("LABELC","lblRegion","valor",regiones);
                lin = obtenerCantFilas(regiones);
                if(lin>1) asignarAtributo("LABELC","lblRegion","alto","" + SIZE_LABEL*lin);
                asignarAtributo("LABELC","lblZona","valor",zonas);
                lin = obtenerCantFilas(zonas);
                if(lin>1)asignarAtributo("LABELC","lblZona","alto","" + (SIZE_LABEL-2)*lin);
                asignarAtributo("LABELC","lblSeccion","valor",secciones);
                lin = obtenerCantFilas(secciones);
                if(lin>1)asignarAtributo("LABELC","lblSeccion","alto","" + SIZE_LABEL*lin);
                asignarAtributo("LABELC","lblTerritorio","valor",territorios);
                lin = obtenerCantFilas(territorios);
                if(lin>1)asignarAtributo("LABELC","lblTerritorio","alto","" + SIZE_LABEL*lin);

                asignarAtributo("LABELC","lblPaisDefecto","valor",paisDF);
                asignarAtributo("LABELC","lblSGVDefecto","valor",sgvDF);
                asignarAtributo("LABELC","lblRegionDefecto","valor",regionDF);
                asignarAtributo("LABELC","lblZonaDefecto","valor",zonaDF);
                asignarAtributo("LABELC","lblSeccionDefecto","valor",seccionDF);
                asignarAtributo("LABELC","lblTerritorioDefecto","valor",territorioDF);
                asignarAtributo("LABELC","lblSociedadDefecto","valor",sociedadDF);
                asignarAtributo("LABELC","lblMarcaDefecto","valor",marcaDF);
                asignarAtributo("LABELC","lblCanalDefecto","valor",canalDF);
                asignarAtributo("LABELC","lblAccesoDefecto","valor",accesoDF);
                asignarAtributo("LABELC","lblSubaccesoDefecto","valor",subAccesoDF);
                asignarAtributo("VAR","hTipoUsuario","valor",tipoUsuario);


                asignarAtributo("LABELC","lblIdioma","valor",idioma);
                asignarAtributo("VAR","hRastreoAcceso","valor",rastreo);
                if ( !rasDesde.equals("")){
                    try{
                        rasDesde = UtilidadesBelcorp.fechalongToString(this, Long.parseLong( rasDesde ));
                    }catch(Exception e) {}
                }
                asignarAtributo("LABELC","lblFechaInicioRastreo","valor",rasDesde);
                if ( !rasHasta.equals("")){
                    try{
                        rasHasta = UtilidadesBelcorp.fechalongToString(this, Long.parseLong( rasHasta ));
                    }catch(Exception e) {}
                }
                asignarAtributo("LABELC","lblFechaFinRastreo","valor",rasHasta);
                asignarAtributo("LABELC","lblFuncionDirecta","valor",pantallaInicio);

                asignarAtributo("LABELC","lblUsuarioSustitucion","valor",sustUsuario);
                if ( !sustDesde.equals("")){
                    try{
                        sustDesde = UtilidadesBelcorp.fechalongToString(this, Long.parseLong( sustDesde ));
                    }catch(Exception e) {}
                }
                asignarAtributo("LABELC","lblFechaDesde","valor",sustDesde);
                if ( !sustHasta.equals("")){
                    try{
                        sustHasta = UtilidadesBelcorp.fechalongToString(this, Long.parseLong( sustHasta ));
                    }catch(Exception e) {}
                }
                asignarAtributo("LABELC","lblFechaHasta","valor",sustHasta);
                asignarAtributo("LABELC","lblObservaciones","valor",sustObser);

                asignarAtributo("VAR","hIndNDG", "valor",  indNodDig);
                asignarAtributo("VAR","hIndAdmNDG", "valor",  indAdmNod);
            }
            getConfiguracionMenu(); //menú secundario
            
        } catch(Exception ex){
            if (accion.equals("")){
                pagina("contenido_usuarios_buscar");
                generarHiddenFormatoFecha();
                asignarAtributo("VAR","casoDeUso", "valor", "consultar");                           
                obtenerCombosBusqueda(idioma); //llena perfiles y departamentos
                asignarAtributo("VAR","accion", "valor", "Buscar");
                asignarAtributo("VAR","conectorAction", "valor", "LPConsultarUsuarios");
            }
            else if (accion.equals("Buscar") || accion.equals("VolverConsulta") ) {
                pagina("contenido_usuarios_buscar");
                obtenerCombosBusqueda(idioma); //llena perfiles y departamentos
                generarHiddenFormatoFecha();
                asignarAtributo("VAR","accion", "valor", "Buscar");
                asignarAtributo("VAR","conectorAction", "valor", "LPConsultarUsuarios");
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
            }
            else if( accion.equals("Consultar") ){
                pagina("contenido_usuario_consultar");
                asignarAtributo("VAR","accion", "valor", "Consultar");
                asignarAtributo("VAR","conectorAction", "valor", "LPConsultarUsuarios");
                asignarAtributo("VAR","elementosSeleccionados", "valor", pelementosSeleccionados);                
            }
            this.lanzarPaginaError(ex);
        }
	}
	

	private void prepararMantenimientoUsuarios() throws Exception{
		Vector paramEntrada  = null;
		Vector rowsets = new Vector();
		Vector nombresJS = new Vector();
		String codigoJS = "";
		String resultado = "";
		HashMap params = new HashMap();
		DruidaConector conectorAlterado;
		
		MareDTO dtoe = new MareDTO();
		dtoe.setProperty("idioma", idioma );
		
		paramEntrada  = new Vector();
		paramEntrada.add( dtoe );
		paramEntrada.add( new MareBusinessID("MENObtieneDatosPantalla") );
		
		DruidaConector conectorMantenimiento = conectar("ConectorRecuperaDatosPantalla",  paramEntrada );
		nombresJS.add("vSociedad");				rowsets.add("dtoSalida.empresas_ROWSET");
		nombresJS.add("vDepartamento");			rowsets.add("dtoSalida.departamentos_ROWSET");
		nombresJS.add("vMarca");					rowsets.add("dtoSalida.marcas_ROWSET");
		nombresJS.add("vCanal");					rowsets.add("dtoSalida.canales_ROWSET");
		nombresJS.add("vAcceso");					rowsets.add("dtoSalida.accesos_ROWSET");
		nombresJS.add("vSubacceso");				rowsets.add("dtoSalida.subaccesos_ROWSET");
		nombresJS.add("vPerfil");					rowsets.add("dtoSalida.perfiles_ROWSET");
		nombresJS.add("vFuncionMenu");			rowsets.add("dtoSalida.funcionesMenu_ROWSET");
		nombresJS.add("vIdioma");					rowsets.add("dtoSalida.idiomas_ROWSET");
		nombresJS.add("vUsuarioSustitucion");	rowsets.add("dtoSalida.usuariosSustitucion_ROWSET");
		nombresJS.add("vPais");						rowsets.add("dtoSalida.paises_ROWSET");
		nombresJS.add("vSubgerencias");			rowsets.add("dtoSalida.subgerencias_ROWSET");
		nombresJS.add("vRegion");					rowsets.add("dtoSalida.regiones_ROWSET");
		nombresJS.add("vZona");						rowsets.add("dtoSalida.zonas_ROWSET");
		nombresJS.add("vSeccion");					rowsets.add("dtoSalida.secciones_ROWSET");
		nombresJS.add("vTerritorio");				rowsets.add("dtoSalida.territorios_ROWSET");
		
		for (int i=0; i<rowsets.size() ; i++)
		{
			params.clear();
			params.put("rowset", rowsets.get(i) );
			conectorAlterado = transformar("prepararMantenimientoUsuarios", conectorMantenimiento, params);
			resultado =(String) ((Element)((Node)conectorAlterado.getXML())).getChildNodes().item(0).getNodeValue();
			codigoJS = codigoJS + "var " + nombresJS.get(i) + " = " + resultado + "; ";
		}
        //DruidaDOMObjeto objetoJS = crearJAVASCRIPT( codigoJS );
        //asignar("JAVASCRIPT", "arraysJS", objetoJS);
		Element element = getXML().getDocumentElement();
		NodeList javascript = element.getElementsByTagName("JAVASCRIPT");
		CDATASection cdata = null;
		Element script = null;
		
		if(javascript.getLength() == 0){
			script = element.getOwnerDocument().createElement("JAVASCRIPT");
			cdata = element.getOwnerDocument().createCDATASection(codigoJS);
			script.appendChild(cdata);
			element.insertBefore(script,
					element.getElementsByTagName("FORMULARIO").item(0));
		}else{
			script = (Element)javascript.item(0);
			
			NodeList lista = script.getChildNodes();
			int largo = lista.getLength();
			
			for(int i = 0; i < largo; i++){
				Node actual = lista.item(i);
				
				if(actual.getNodeType() == Node.CDATA_SECTION_NODE){
					cdata = (CDATASection)actual;
					cdata.setData(codigoJS);
					break;
				}
			}
		}
		
		
	}
	
	private void mostrarResultadosBusqueda() throws Exception {
		
		asignarAtributo("CTEXTO","txtUsuario", "valor", pIdentificadorUsuario);
		asignarAtributo("CTEXTO","txtPrimerNombre", "valor", pNombre1);
		asignarAtributo("CTEXTO","txtSegundoNombre", "valor", pNombre2);
		asignarAtributo("CTEXTO","txtPrimerApellido", "valor", pApellido1);
		asignarAtributo("CTEXTO","txtSegundoApellido", "valor", pApellido2);
		asignarAtributo("VAR","hPerfil", "valor", pPerfil);				  //asignarAtributo("COMBO","cbPerfil", "valor", pPerfil);		
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
		asignarAtributo("VAR","casoDeUso", "valor", "consultar");
		asignar("LISTADOA","listado1",conectorBuscar,"dtoSalida.resultado_ROWSET");
		
		asignarAtributo("VAR","accion", "valor", "Buscar");
		asignarAtributo("VAR","conectorAction", "valor", "LPConsultarUsuarios");
		
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
			
			pPerfil						= (String) dtoe.getPerfil();
			pTelefono					= (String) dtoe.getTelefonoContacto();
			pDepartamento				= (String) dtoe.getDepartamento();
			pValidezDesde				= (String) dtoe.getValidezDesde();
			pHasta						= (String) dtoe.getValidezHasta();
			pTipoUsuario				= (String) dtoe.getTipoUsuario();
			pUsuarioHabilitado		= (String) dtoe.getUsuarioHabilitado();
			
		} else { //pagina.
			
			pIdentificadorUsuario	= conectorParametroLimpia("txtUsuario","",true);
			pNombre1						= conectorParametroLimpia("txtNombre1","",true);
			pNombre2						= conectorParametroLimpia("txtNombre2","",true);
			pApellido1					= conectorParametroLimpia("txtApellido1","",true);
			pApellido2					= conectorParametroLimpia("txtApellido2","",true);
			pPerfil						= conectorParametroLimpia("cbPerfil","",true);
			pTelefono					= conectorParametroLimpia("txtTelefono","",true);
			pDepartamento				= conectorParametroLimpia("cbDepartamento","",true);
			pValidezDesde				= conectorParametroLimpia("txtValidezDesde","",true);
			pHasta						= conectorParametroLimpia("txtHasta","",true);
			pTipoUsuario				= conectorParametroLimpia("cbTipoUsuario","",true);
			pUsuarioHabilitado		= conectorParametroLimpia("cbUsuarioHablitado","",true);
			
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
	
	private int obtenerCantFilas(String cadena){
		int valor = 1;
		
		StringTokenizer stk = new StringTokenizer(cadena,"<BR>");
		if ( stk.countTokens() > 0)
			return stk.countTokens();
		else
			return valor;		
	}
	
	private String recogeCadena(String param){
		if (param==null)
			return "";
		else
			return param;	
	}
	
}