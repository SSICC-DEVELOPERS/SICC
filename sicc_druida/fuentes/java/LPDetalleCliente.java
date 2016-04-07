import es.indra.sicc.dtos.mae.DTOConsultaCliente;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import es.indra.druida.DruidaConector;
import java.math.BigDecimal;
import java.util.Vector;

public class LPDetalleCliente extends LPSICCBase {
   public static String TOKEN_VACIO = " ";
   public static String SEPARADOR_PARAMETROS = "&";
   public boolean param = false;
   private String casoDeUso;
   private String sBuffer;

	 public LPDetalleCliente() { super(); }

	 public void inicio() throws Exception {
	 }

   public void ejecucion() throws Exception {
      this.rastreo();
      try {
         setTrazaFichero();
        
         String sAccion = this.conectorParametroLimpia("accion", "", true);
         traza("sAccion: " + sAccion);
        
         // Dispatcher a métodos de manejo de pestañas.
         if (sAccion.equals("pestanya0") ) {
            this.manejarPestanya0();
         }
        
         if (sAccion.equals("pestanya1") ) {
            this.manejarPestanya1();
         }
         
         if (sAccion.equals("pestanya2") ) {
            this.manejarPestanya2();
         }
         
         if (sAccion.equals("pestanya3") ) {
           this.manejarPestanya3();
         }

         if (sAccion.equals("pestanya4") ) {
           this.manejarPestanya4();
         }
         
         
         
         
     
      } catch (Exception ex) {
         ex.printStackTrace();
         this.lanzarPaginaError(ex);
      }
  }
  
  
  private void manejarPestanya0() throws MareException, Exception {
    traza("LPDetalleCliente.manejarPestanya0()");
    
    RecordSet rNuevo = new RecordSet();
    Vector vColNames = new Vector(); 
    Vector vFila = null;
    int cantRegistros = 0;
    
    this.pagina("contenido_cliente_consultar_detalle_p0");
    this.getConfiguracionMenu("LPBusquedaCliente", "consultar");
    this.asignarAtributoPagina("cod","0410");    
    this.getFormatosValidaciones();

    
    
    // Tomo el DTO con el Detalle de Cliente de Sesión. 
    DTOConsultaCliente dtoDatos = (DTOConsultaCliente) 
                                this.conectorParametroSesion("ConsultarClientesDTODetalle");
                                
    RecordSet rTipoSubTipo = dtoDatos.getTiposSubtipos();
    traza("rTipoSubTipo = " + rTipoSubTipo);
    
    // Armo el nuevo RecordSet
    rNuevo = this.armaRSetTipoSubtipo(rTipoSubTipo);
    traza("rTipo: " + rNuevo);

    // Setea la variable de formulario "hidDescTipoCliente" con el PRIMER
    // tipo que llega en el RecordSet. 
    String sTipoCliente = (String) rNuevo.getValueAt(0,0);
    asignarAtributo("VAR", "hidDescTipoCliente", "valor", sTipoCliente);

    // Se conecta y asignar a la lista de Tipo y Subtipo.
    DruidaConector conTipoSubtipo = this.generarConectorLista("rowsetTipoSubtipo", 
                                                              rNuevo, 
                                                              rNuevo.getColumnIdentifiers() );
    asignar("LISTADOA","listado0",conTipoSubtipo,"rowsetTipoSubtipo");              
              
  }
  
  private void manejarPestanya1() throws MareException, Exception {
    traza("LPDetalleCliente.manejarPestanya1()");

    String sTipoDocumento = null;
    String sNroDocumento = null;
    String sPersonaEmpresa = null;
    BigDecimal bigDocPpal = null;    
    
    Vector vFila = null;
    Vector vColNames = new Vector();
    int cantRegistros = 0;
    

    this.pagina("contenido_cliente_consultar_detalle_p1");
    this.getConfiguracionMenu("LPBusquedaCliente", "consultar");
    this.asignarAtributoPagina("cod","0410");    
    this.getFormatosValidaciones();
    
    // Tomo el DTO con el Detalle de Cliente de Sesión. 
    DTOConsultaCliente dtoDatos = (DTOConsultaCliente) 
                                this.conectorParametroSesion("ConsultarClientesDTODetalle");
                                
    String sCodigoCliente = dtoDatos.getCodigoCliente();
    traza("lblCodigoCliente: " + sCodigoCliente);
    asignarAtributo("LABELC", "lbl1CodClienteActual", "valor", sCodigoCliente);
    
    RecordSet r = dtoDatos.getIdentificaciones();
    traza("Identificaciones: " + r.toString() );
    RecordSet rNuevo = this.armaRSetDocumento(r);
    traza("rNuevo: " + rNuevo);

    DruidaConector con = this.generarConectorLista("rowsetID", rNuevo, rNuevo.getColumnIdentifiers());
    traza("con: " + con.getXML() );

    asignar("LISTADOA","listado1",con,"rowsetID");
    
  }  
  
  
 private void manejarPestanya2()  throws MareException, Exception {
    traza("LPDetalleCliente.manejarPestanya2()");
    this.pagina("contenido_cliente_consultar_detalle_p2");
    this.getConfiguracionMenu("LPBusquedaCliente", "consultar");
    this.asignarAtributoPagina("cod","0410");    

    
    String sFormatoFecha = UtilidadesSession.getFormatoFecha(this);
    this.asignarAtributo("VAR", "hFormatoFechaPais", "valor", sFormatoFecha);
    
    // Tomo el DTO con el Detalle de Cliente de Sesión. 
    DTOConsultaCliente dtoDatos = (DTOConsultaCliente) 
                                this.conectorParametroSesion("ConsultarClientesDTODetalle");
    
    traza("dtoDatos: " + dtoDatos);
    Vector vFila = new Vector();
    
    
    traza("indActivo");
    Boolean bIndActivo = dtoDatos.getIndicadorActivo();
    String sIndActivo = "N";
    if ( bIndActivo != null && bIndActivo.booleanValue() ) { 
      traza(" -- Cliente está activo");
      sIndActivo = "S"; 
    }
    this.asignarAtributo("CHECKBOX", "ckIndActivo", "check", sIndActivo);

    traza("textApellido1");
    String sApellido1 = dtoDatos.getApellido1();
    if (sApellido1 == null){sApellido1 = "";}
    asignarAtributo("LABELC", "lbl2dtApellido1", "valor", sApellido1);                
    
    traza("textApellido2");                
    String sApellido2 = dtoDatos.getApellido2();
    if (sApellido2 == null) { sApellido2 = ""; }    
    asignarAtributo("LABELC", "lbl2dtApellido2", "valor", sApellido2);                                

    traza("textApellidoCasada");                                
    String sApellidoCasada = dtoDatos.getApellidoCasada();
    if (sApellidoCasada == null) { sApellidoCasada = "";}
    asignarAtributo("LABELC", "lbl2dtApellidoCasada", "valor", sApellidoCasada);                                                

    traza("textNombre1");
    String sNombre1 = dtoDatos.getNombre1();
    if (sNombre1 == null) { sNombre1 = "";}
    asignarAtributo("LABELC", "lbl2dtNombre1", "valor", sNombre1);                                

    traza("textNombre2");
    String sNombre2 = dtoDatos.getNombre2();
    if (sNombre2 == null) { sNombre2 = "";}                
    asignarAtributo("LABELC", "lbl2dtNombre2", "valor", sNombre2);                      

    traza("Sexo");
    String sSexo = null;
    if (dtoDatos.getSexo() != null) {
      sSexo = String.valueOf(dtoDatos.getSexo());                  
    } else {
      sSexo = "";
    }
    asignarAtributo("VAR", "hidSexo", "valor", sSexo);  

    traza("Tratamiento");
    String sTratamiento = null;
    if (dtoDatos.getTratamiento() != null) {
      sTratamiento = dtoDatos.getTratamiento().toString();
    } else {
      sTratamiento = "";
    }
    asignarAtributo("VAR", "hidTratamiento", "valor", sTratamiento);

    traza("Forma de Pago");
    String sFormaPago = null;
    traza("Forma de pago: " + sFormaPago);
    if (dtoDatos.getFormaPago() == null) {
      sFormaPago = "";
    } else {
      sFormaPago = dtoDatos.getFormaPago();
    }
    asignarAtributo("VAR", "hidFormaPago", "valor", sFormaPago);

    traza("Fecha de Ingreso");
    Date fechaIngreso = dtoDatos.getFechaIngreso();
    String sFechaIngreso = null;
    if (fechaIngreso == null) {
      sFechaIngreso = "";
    } else {
      sFechaIngreso = transformaFechas(fechaIngreso);                                  
    }

    asignarAtributo("LABELC", "lbl2dtFechaIngreso", "valor", sFechaIngreso);

    traza("Fecha de Nacimiento");
    Date fechaNacimiento = dtoDatos.getFechaNacimiento();
    String sFechaNacimiento = null;
    if (fechaNacimiento == null) {
      sFechaNacimiento = "";
    } else {
      sFechaNacimiento = transformaFechas(fechaNacimiento);
    }
    asignarAtributo("LABELC", "lbl2dtFechaNacimiento", "valor", sFechaNacimiento);                
    asignarAtributo("VAR", "hFechaNacimiento", "valor", sFechaNacimiento);

    traza("Codigo de Empleado");
    String sCodEmpleado = dtoDatos.getCodigoEmpleado();
    if (sCodEmpleado == null) { sCodEmpleado = ""; }
    asignarAtributo("LABELC", "lbl2dtCodEmpleado", "valor", sCodEmpleado);                

    traza("Ocupacion");
    String sOcupacion = dtoDatos.getOcupacion();
    if (sOcupacion == null) { sOcupacion = ""; }
    asignarAtributo("LABELC", "lbl2dtOcupacion", "valor", sOcupacion);                

    traza("Nacionalidad");
    String sNacionalidad = dtoDatos.getNacionalidad();
    if (sNacionalidad == null) { sNacionalidad = ""; }
    asignarAtributo("VAR", "hidNacionalidad", "valor", sNacionalidad);

    traza("Estado Civil");
    String sEstadoCivil = dtoDatos.getEstadoCivil();
    if (sEstadoCivil == null) { sEstadoCivil = ""; }
    asignarAtributo("VAR", "hidEstadoCivil", "valor", sEstadoCivil);

    traza("Profesion");
    String sProfesion = dtoDatos.getProfesion();
    if (sProfesion == null) { sProfesion = ""; }
    asignarAtributo("LABELC", "lbl2dtProfesion", "valor", sProfesion);                          

    traza("Centro Trabajo");
    String sCentroTrabajo = dtoDatos.getCentroTrabajo();
    if (sCentroTrabajo == null) { sCentroTrabajo = ""; }
    asignarAtributo("LABELC", "lbl2dtCentroTrabajo", "valor", sCentroTrabajo);                          

    traza("Cargo que desempeña");
    String sCargo = dtoDatos.getCargo();
    if (sCargo == null) { sCargo = ""; }
    asignarAtributo("LABELC", "lbl2dtCargoDesempena", "valor", sCargo);                                          

    traza("Centro Estudios");
    String sCentroEstudios = dtoDatos.getCentro();
    if (sCentroEstudios == null) { sCentroEstudios = ""; }
    asignarAtributo("LABELC", "lbl2dtCentroEstudios", "valor", sCentroEstudios);                                          

    traza("Nro Hijos");
    String nroHijos = dtoDatos.getNumeroHijos();
    traza("  ---- NroHijos: " + nroHijos);
    if (nroHijos == null) { nroHijos = ""; } 
    asignarAtributo("LABELC", "lbl2dtNHijos", "valor", nroHijos);                

    traza("Nro Personas dependientes");
    String nroPersonasDepend = dtoDatos.getPersonasDependientes();
    traza("   ---- Nro Personas dependientes: " +  nroPersonasDepend);                
    if (nroPersonasDepend == null) { nroPersonasDepend = "";}
    asignarAtributo("LABELC", "lbl2dtNPersonasDependientes", "valor", nroPersonasDepend);                

    traza("Nivel Estudios");
    String sNivelEstudios = dtoDatos.getNivelEstudios();
    if (sNivelEstudios == null) {sNivelEstudios = "";}
    asignarAtributo("VAR", "hidNivelEstudios", "valor", sNivelEstudios);

    traza("Nivel Socioeconomico");
    String NSEP = dtoDatos.getNSEP();
    if (NSEP == null) { NSEP ="";}
    asignarAtributo("VAR", "hidNSE", "valor", NSEP);

    traza("Nivel de Ciclo Familiar");
    String nivelCicloFamiliar = dtoDatos.getCicloVidaFamiliar();
    if (nivelCicloFamiliar == null) {nivelCicloFamiliar = "";}
    asignarAtributo("VAR", "hidCicloVidaFamiliar", "valor", nivelCicloFamiliar);

    traza("Correspondencia");
    Boolean bDeseaCorresp  = dtoDatos.getDeseaCorrespondencia();
    if (bDeseaCorresp != null) {
        if (bDeseaCorresp.booleanValue() == true) {
          asignarAtributo("VAR", "hidCorresp", "valor", "S");
        } else {
          asignarAtributo("VAR", "hidCorresp", "valor", "N");
        }
    } else {
      asignarAtributo("VAR", "hidCorresp", "valor", "");
    }

    traza("Ingreso Familiar");
    String sIngreso = dtoDatos.getImporteIngreso();

    if ( sIngreso == null || sIngreso.equals("") ) { 
       sIngreso = ""; 
       asignarAtributo("LABELC", "lbl2dtImporteIngresoFamiliar", "valor", sIngreso);
    } else {
       sIngreso = UtilidadesBelcorp.formateaNumeroSICC(sIngreso, 
                                                       LPSICCBase.FORMATO_MONEDA,
                                                       this);
       asignarAtributo("LABELC", "lbl2dtImporteIngresoFamiliar", "valor", sIngreso);
    }

    // ----- Vinculos -----
    traza("Lista de Vinculos");
    RecordSet r = dtoDatos.getVinculos();
    r = this.armaRSetVinculos(r);
    traza("rNuevo Vinculo: " + r);
    
    DruidaConector con = this.generarConectorLista("rowsetVinculo", 
                                                    r, 
                                                    r.getColumnIdentifiers());
    asignar("LISTADOA","listado2",con,"rowsetVinculo");                

    // ----- Preferencias -----
    traza("Lista de Preferencias");
    RecordSet rPref = dtoDatos.getPreferencias();
    rPref = this.armaRSetPreferencias(rPref);
    traza("rPref: " + rPref.toString() );

    DruidaConector conPref = this.generarConectorLista("rowsetPref", 
                                                        rPref, 
                                                        rPref.getColumnIdentifiers());
    asignar("LISTADOA","listado3",conPref,"rowsetPref");                

    // ----- Observaciones -----
    traza("Grupo de Observaciones");
    RecordSet rGrupo = dtoDatos.getObservaciones();
    rGrupo = this.armaRSetObservaciones(rGrupo);
    traza("rGrupo: " + rGrupo);

    DruidaConector conGrupo = this.generarConectorLista("rowsetGrupo", 
                                                        rGrupo, 
                                                        rGrupo.getColumnIdentifiers());
    asignar("LISTADOA","listado4",conGrupo,"rowsetGrupo");      

    boolean hayPrimerContacto = true;
    // Para luego ver si se pone la descripcion de Tipo de Cliente Contacto
    // en caso de que haya o no haya Primer Contacto.

    traza("Fecha de Primer Contacto");
    Date fechaPrimerContacto = dtoDatos.getFechaContacto();
    String sFechaPrimerContacto = null;
    if (fechaPrimerContacto == null) {
      sFechaPrimerContacto = "";
    } else {
      sFechaPrimerContacto = this.transformaFechas(fechaPrimerContacto); 
    }
    //asignarAtributo("CTEXTO", "textFechaContacto", "valor", sFechaPrimerContacto);
    asignarAtributo("LABELC", "lbl2dtFechaContacto", "valor", sFechaPrimerContacto);                

    traza("Fecha Primer Pedido de Contacto");
    Date fechaSiguienteContacto = dtoDatos.getFechaSiguienteContacto();
    String sFechaSigContacto = null;
    if (fechaSiguienteContacto == null) {
      sFechaSigContacto = "";
    } else {
      sFechaSigContacto = this.transformaFechas(fechaSiguienteContacto);
    }
    asignarAtributo("LABELC", "lbl2dtFechaSiguienteContacto", "valor", sFechaSigContacto);

    traza("Tipo Cliente Contactado");
    String sTipoClienteContactado = dtoDatos.getTipoClienteContactado();
    traza("  --- Tipo Cliente Contactado: " + sTipoClienteContactado);
    if (sTipoClienteContactado == null) { sTipoClienteContactado = "";}
    asignarAtributo("LABELC", "lbl2dtTipoClienteContactado", "valor", sTipoClienteContactado);                

    traza("Codigo de Cliente Contactado");
    String sCodigoClienteContactado = dtoDatos.getCodigoClienteContactado();
    if (sCodigoClienteContactado == null) {
        sCodigoClienteContactado = "";
    } else {
        hayPrimerContacto = false;
    }
        
    traza("sCodigoClienteContactado: " + sCodigoClienteContactado);
    asignarAtributo("LABELC", "lbl2dtCodClienteContactado", "valor", sCodigoClienteContactado);                

    traza("Pais del Contactado (Desc)");
    String sDescPais = dtoDatos.getPaisContactado();
    if (sDescPais == null) { sDescPais = ""; }
    asignarAtributo("VAR", "hidPaisClienteContactado", "valor", sDescPais);

    if ( !hayPrimerContacto ) {
      traza("Tipo de Cliente Contacto");
      /*traza("sDescTipo: " + sDescTipo);
      asignarAtributo("LABELC", "lbl2dtTipoClienteContacto", "valor", sDescTipo);   */
    }

    traza("Tipo Contacto (Inbound/Outbound)");
    String inbound = dtoDatos.getTipoContacto();
    if (inbound == null) {inbound = "";}
    if (!inbound.equals("")) {
          if (inbound.equals("I")) {
              inbound = "Inbound";
          }
          if (inbound.equals("O")) {
              inbound = "Outbound";
          }
    }
    asignarAtributo("LABELC", "lbl2dtCodTipoContacto", "valor", inbound); 


    traza("Marca Contacto");
    String sMarcaDesc = dtoDatos.getMarcaContactoDesc();
    if (sMarcaDesc == null) {sMarcaDesc = "";}
    asignarAtributo("LABELC", "lbl2dtMarca", "valor", sMarcaDesc);

    traza("Periodo Contacto");
    String sPeriodoDesc = dtoDatos.getPeriodoContactoDesc();
    if (sPeriodoDesc == null) {sPeriodoDesc = "";}
    asignarAtributo("LABELC", "lbldtPeriodoPrimerPedido", "valor", sPeriodoDesc);

    traza("Canal Contacto");
    String sCanalDesc = dtoDatos.getCanalContactoDesc();
    if (sCanalDesc == null) {sCanalDesc = "";}
    asignarAtributo("LABELC", "lbldtCanal", "valor", sCanalDesc);

    traza("Pais de Contacto");
    String sPaisContacto = UtilidadesSession.getDescripcionPais(this);
    asignarAtributo("LABELC", "lbl2PaisContactoActual", "valor", sPaisContacto);

 }
 
 private void manejarPestanya3() throws MareException, Exception {
    traza("LPDetalleCliente.manejarPestanya3()");
    this.pagina("contenido_cliente_consultar_detalle_p3");
    this.getConfiguracionMenu("LPBusquedaCliente", "consultar");
    this.asignarAtributoPagina("cod","0410");    
    
    // Tomo el DTO con el Detalle de Cliente de Sesión. 
    DTOConsultaCliente dtoDatos = (DTOConsultaCliente) 
                                this.conectorParametroSesion("ConsultarClientesDTODetalle");
    traza("dtoDatos: " + dtoDatos);

    // ------- Comunicaciones ---------
    RecordSet rCom = dtoDatos.getComunicaciones();
    traza("rComunicacion: " + rCom);

    DruidaConector conCom = this.generarConectorLista("rowsetCom", 
                                                      rCom, 
                                                      rCom.getColumnIdentifiers());
    asignar("LISTADOA","listado6",conCom,"rowsetCom");                                            

    // ------- Marca ---------
    traza("Marca");
    String[] descMarcas = dtoDatos.getMarcas();
    
    RecordSet rNuevaMarca = this.armaRSetMarcas(descMarcas);
    traza("rNuevaMarca: "+ rNuevaMarca);
    DruidaConector conMarca = this.generarConectorLista("rowsetMarca", 
                                                        rNuevaMarca, 
                                                        rNuevaMarca.getColumnIdentifiers());                
    asignar("LISTADOA","listado7",conMarca,"rowsetMarca");                                                  

    // ------- Direcciones ---------
    traza("Direcciones");
    RecordSet rDirecciones = dtoDatos.getDirecciones();
    traza("rDirecciones: " + rDirecciones);
    RecordSet rDirNuevo = this.armaRSetDirecciones(rDirecciones);
    traza("rDirNuevo: " + rDirNuevo.toString());
    DruidaConector conDir = this.generarConectorLista("rowsetDir", 
                                                      rDirNuevo, 
                                                      rDirNuevo.getColumnIdentifiers());
    asignar("LISTADOA","listado5",conDir,"rowsetDir");                                                                  

 }
 
 
 private void manejarPestanya4() throws MareException, Exception {
 
    traza("LPDetalleCliente.manejarPestanya4"); 
    
    this.pagina("contenido_cliente_consultar_detalle_p4");
    this.getConfiguracionMenu("LPBusquedaCliente", "consultar");
    this.asignarAtributoPagina("cod","0410");    
    
    // Tomo el DTO con el Detalle de Cliente de Sesión. 
    DTOConsultaCliente dtoDatos = (DTOConsultaCliente) 
                                this.conectorParametroSesion("ConsultarClientesDTODetalle");
    
    
    traza("dtoDatos: " + dtoDatos);
    
    // ------------------------------ Grupo Tarjetas ---------------------------------------
    traza("Grupo Tarjetas");
    RecordSet rTarjetas = dtoDatos.getTarjetas();
    RecordSet rTarjNuevo = this.armaRSetTarjetas(rTarjetas);
    
    DruidaConector conTarjetas = this.generarConectorLista("rowsetTarjetas", 
                                                           rTarjNuevo, 
                                                           rTarjNuevo.getColumnIdentifiers());
    asignar("LISTADOA","listado8",conTarjetas,"rowsetTarjetas");                                                                          

    // --------------------------- Clasificaciones------------------------------------------
    traza("Clasificaciones");
    RecordSet rClasi = dtoDatos.getClasificaciones();
    DruidaConector conClasi = this.generarConectorLista("rowsetClasi",
                                                        rClasi, 
                                                        rClasi.getColumnIdentifiers() );
    asignar("LISTADOA","listado9",conClasi,"rowsetClasi");                                                                                        

    // ---------------------------- Psicografia --------------------------------------------
    traza("Psicografia");
    RecordSet rPsico = dtoDatos.getPsicografias();
    traza("rPsico: " + rPsico);
    RecordSet rPsicoNuevo = this.armaRSetPsico(rPsico);
    traza("rPsicoNuevo: " + rPsicoNuevo);
    DruidaConector conPsico = this.generarConectorLista("rowsetPsico", 
                                                        rPsicoNuevo, 
                                                        rPsicoNuevo.getColumnIdentifiers());
    asignar("LISTADOA","listado11",conPsico,"rowsetPsico");   
    
    // ----------------------------- Problema/Solucion --------------------------------------
    traza("Problema/Solucion");
    RecordSet rProbSol = dtoDatos.getProblemasSoluciones();
    RecordSet rNuevoProbSol = new RecordSet();
    traza("rProbSol: " + rProbSol);

    DruidaConector conProble = this.generarConectorLista("rowsetProb", 
                                                         rProbSol, 
                                                         rProbSol.getColumnIdentifiers());
    asignar("LISTADOA","listado10",conProble,"rowsetProb");     
   
 }
  
  private DruidaConector generarConectorLista(String rowsetID, RecordSet datos,Vector columns) throws DOMException,Exception
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
      Element e_campo0   = docDestino.createElement("CAMPO");
      e_campo0.setAttribute("NOMBRE", "oculto");
      //e_campo0.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
      e_campo0.setAttribute("TIPO","OBJECTO");
      e_campo0.setAttribute("LONGITUD","50");
      Text txt = docDestino.createTextNode(String.valueOf(i));
      e_campo0.appendChild(txt);
      e_row.appendChild(e_campo0);

			for (int j=0; j < sizeColums; j++){
				if ( columns.contains(  columsDesc.elementAt(j)) ){
				
				//------------------------------------------------------------
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt0);
					e_row.appendChild(e_campo2);
				}
			}
		}	

    conectorValoresPosibles.setXML(docDestino.getDocumentElement());
    return conectorValoresPosibles;
	}
  
  private String transformaFechas(java.util.Date fechaBD) throws Exception
  { 
  
      traza("TransformaFechas");
      // Transforma las Fechas para mostrar en pantalla, en formato de Sesión.
      String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
      formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
      traza("Antes: " + fechaBD.toString() );
      SimpleDateFormat sFormat = new SimpleDateFormat(formatoFechaSesion);
      String sBuffer = sFormat.format(fechaBD);
      traza("Despues: " + sBuffer.toString() );

      return sBuffer;
    
  }  
  
  
  private RecordSet armaRSetVinculos(RecordSet rEntrada) throws MareException,
                                                                Exception {
                                                                
    traza("LPDetalleCliente.armaRSetVinculos()");
    RecordSet rRetorno = new RecordSet();
    Vector vNuevoCols = new Vector();
    Vector vFila = new Vector();
    String sFechaBufferDesde = null;
    String sFechaBufferHasta = null;    
    java.util.Date fechaDesde = null;
    java.util.Date fechaHasta = null;
    int cantRegistros = rEntrada.getRowCount();
    traza("rVinculos: " + rEntrada);
    
    vNuevoCols.add("CLIENTE");
    vNuevoCols.add("TIPO");
    vNuevoCols.add("DESDE");
    vNuevoCols.add("HASTA");
    vNuevoCols.add("ID_PPAL");
    
    rRetorno.setColumnIdentifiers(vNuevoCols);
    
    for (int i = 0; i < cantRegistros; i++ ) {
       vFila = new Vector();
       fechaDesde = (java.util.Date) rEntrada.getValueAt(i, 2);
       fechaHasta = (java.util.Date) rEntrada.getValueAt(i, 3);

       if (fechaDesde == null) {
          sFechaBufferDesde = "";
       } else {
          traza("Llama a transformarFechas");
          sFechaBufferDesde = 
                 this.transformaFechas(fechaDesde);
       }

       if (fechaHasta == null) {
          sFechaBufferHasta = "";
       } else {
          traza("Llama a transformarFechas");
          sFechaBufferHasta = 
                 this.transformaFechas(fechaHasta);
       }
       
       vFila.add(rEntrada.getValueAt(i, 1)); // Cliente
       vFila.add(rEntrada.getValueAt(i, 6)); // Tipo 
       vFila.add(sFechaBufferDesde);         // Desde
       vFila.add(sFechaBufferHasta);         // Hasta
       vFila.add(rEntrada.getValueAt(i, 5)); // Id. ppal.
       
       rRetorno.addRow(vFila);
    }
      
    return rRetorno;
  }
  
  
  private RecordSet armaRSetPreferencias(RecordSet rEntrada) throws MareException, 
                                                                    Exception {
                                                                    
    traza("LPDetalleCliente.armaRSetPreferencias()");
    RecordSet rRetorno = new RecordSet();
    Vector vNuevoCols = new Vector();
    Vector vFila = null;
    int cantRegistros = rEntrada.getRowCount();
    
    vNuevoCols.add("TIPO_PREF");
    vNuevoCols.add("DESC_PREF");
    rRetorno.setColumnIdentifiers(vNuevoCols);
    
    for (int i = 0; i < cantRegistros; i++) {
      vFila = new Vector(); 
      vFila.add(rEntrada.getValueAt(i,0)); // Tipo Pref.
      vFila.add(rEntrada.getValueAt(i,2)); // Desc Pref.
      
      rRetorno.addRow(vFila);
    }
    return rRetorno; 
    
  }
  
  
  private RecordSet armaRSetObservaciones(RecordSet rEntrada) throws MareException,
                                                                  Exception {
     traza("LPDetalleCliente.armaRObservaciones()");    
     RecordSet rRetorno = new RecordSet();
     Vector vNuevoCols = new Vector();
     Vector vFila = null;
     int cantRegistros = rEntrada.getRowCount();
     
     vNuevoCols.add("MARCA");
     vNuevoCols.add("NRO");
     vNuevoCols.add("TEXTO");
     
     rRetorno.setColumnIdentifiers(vNuevoCols);
     
     for (int i = 0; i < cantRegistros; i++) {
        vFila = new Vector();
        
        vFila.add(rEntrada.getValueAt(i,3)); // Marca
        vFila.add(rEntrada.getValueAt(i,1)); // Nro
        vFila.add(rEntrada.getValueAt(i,2)); // Texto. 
        
        rRetorno.addRow(vFila);
     }
     return rRetorno;
  }
  
  
  private RecordSet armaRSetDirecciones(RecordSet rEntrada) throws MareException, 
                                                              Exception { 

     traza("LPDetalleCliente.armaRSetDirecciones()");
     Vector vFila = null;
     Vector vNewCols  = new Vector();
     RecordSet rRetorno = new RecordSet();     
     int cantRegistros = rEntrada.getRowCount();

     // Setea los ColumnIdentifiers     
     vNewCols.add("UniGeografica");
     vNewCols.add("TipoDir");
     vNewCols.add("TipoVia");
     vNewCols.add("NombreVia");
     vNewCols.add("NroPrincipal");
     vNewCols.add("CodPostal");
     vNewCols.add("Observaciones");                
     vNewCols.add("IndPrincipal");                                

     rRetorno.setColumnIdentifiers(vNewCols);
     
     // Armo el nuevo RecordSet
     for (int i = 0; i < cantRegistros; i++)
     {
        vFila = new Vector();
        vFila.add(rEntrada.getValueAt(i,9)); // Desc. Unidad Geografica   
        vFila.add(rEntrada.getValueAt(i,6)); // TipoDir   
        vFila.add(rEntrada.getValueAt(i,7)); // TipoVia   
        vFila.add(rEntrada.getValueAt(i,2));  // NombreVia    
        vFila.add(rEntrada.getValueAt(i,3));  // NroPrincipa
        vFila.add(rEntrada.getValueAt(i,4));  // CodPostal
        vFila.add(rEntrada.getValueAt(i,5)); // Observaciones
        vFila.add(rEntrada.getValueAt(i,8)); // Ind Dir. Principal. 
                       
        rRetorno.addRow(vFila);
     }
     traza("rDirNuevo: " + rRetorno.toString());
     
     return rRetorno;
  } 
  
  private RecordSet armaRSetMarcas(String[] arrayMarcas) throws MareException, 
                                                              Exception {
    traza("LPDetalleCliente.armarRSetMarcas()");
    RecordSet rRetorno = new RecordSet();
    Vector vNewCols = new Vector();
    Vector vFila = null;
    int cantRegistros = arrayMarcas.length;
    
    vNewCols.add("Marca");
    rRetorno.setColumnIdentifiers(vNewCols);
   
    for (int i=0; i < cantRegistros; i++)
    {
        vFila = new Vector();
        vFila.add(arrayMarcas[i]);
        rRetorno.addRow(vFila);
    }
    return rRetorno;

  }
  
  
  private RecordSet armaRSetTarjetas(RecordSet rEntrada) throws MareException, 
                                                                Exception {
    traza("LPDetalleCliente.armaRSetTarjetas()");
    RecordSet rRetorno = new RecordSet();
    Vector vNewCols = new Vector();
    int cantRegistros = rEntrada.getRowCount();

    vNewCols.add("Tipo");
    vNewCols.add("Clases");
    vNewCols.add("Banco");

    rRetorno.setColumnIdentifiers(vNewCols);

    Vector vFila = null;
    for (int i = 0; i < cantRegistros; i++)
    {
      vFila = new Vector();
      vFila.add(rEntrada.getValueAt(i,3)); // Tipo
      vFila.add(rEntrada.getValueAt(i,4)); // Clase        
      vFila.add(rEntrada.getValueAt(i,5)); // Banco                               
      rRetorno.addRow(vFila);
    }
    return rRetorno;
  }
  
  private RecordSet armaRSetDocumento(RecordSet rEntrada) throws MareException,
                                                                 Exception {
                    
    traza("LPDetalleCliente.armaRSetDocumento()");                                               
    RecordSet rRetorno = new RecordSet();
    Vector vFila = null;
    Vector vNewCols = new Vector();
    int cantRegistros = rEntrada.getRowCount();    
    
    vNewCols.add("TIPO_DOC");
    vNewCols.add("NRO_DOC");
    vNewCols.add("DOC_PPAL");
    vNewCols.add("PER_EMP");
    rRetorno.setColumnIdentifiers(vNewCols);
    
    for (int i = 0; i < cantRegistros; i++ ) {
      vFila = new Vector();
      vFila.add(rEntrada.getValueAt(i, 4));
      vFila.add(rEntrada.getValueAt(i,1));
      vFila.add(rEntrada.getValueAt(i,2));
      vFila.add(rEntrada.getValueAt(i,3));
      rRetorno.addRow(vFila);
    }
    
    return rRetorno;
                                                                   
  }
  
  
  private RecordSet armaRSetTipoSubtipo(RecordSet rEntrada) throws MareException,
                                                                   Exception {
    traza("LPDetalleCliente.armaRSetTipoSubtipo()");
    
    RecordSet rRetorno = new RecordSet();
    Vector vFila = null;
    Vector vNewCols = new Vector();
    int cantRegistros = rEntrada.getRowCount();

    vNewCols.add("TIPO");
    vNewCols.add("SUB_TIPO");
    rRetorno.setColumnIdentifiers(vNewCols);
    
    for ( int i = 0; i < cantRegistros; i++ ) {
       vFila = new Vector(); 
       
       vFila.add(rEntrada.getValueAt(i, 2)); // Tipo 
       vFila.add(rEntrada.getValueAt(i, 3)); // Subtipo
       
       rRetorno.addRow( vFila );
    }
    return rRetorno;

  }
  
  
  private RecordSet armaRSetPsico(RecordSet rEntrada) throws MareException, 
                                                             Exception {
     traza("LPDetalleCliente.armaRSetPsico()");
     RecordSet rRetorno = new RecordSet();
     Vector vNewCols = new Vector();
     Vector vFila = null;
     int cantRegistros = rEntrada.getRowCount();
     int cantCols = rEntrada.getColumnCount();

     vNewCols = rEntrada.getColumnIdentifiers();
     
     rRetorno.setColumnIdentifiers(vNewCols);
     
     
     for ( int i = 0; i < cantRegistros; i++ ) {
       vFila = new Vector();
       for ( int j = 0; j < cantCols; j++ ) {
          if ( j == 3 ) {
            java.sql.Date fechaSQL = (java.sql.Date)rEntrada.getValueAt(i,j);
            traza("Fecha SQL: " + fechaSQL.toString() );
            String nuevaFecha = this.transformaFechas(fechaSQL);
            traza("Nueva Fecha: " + nuevaFecha.toString() );
            vFila.add(nuevaFecha);
          } else {
            vFila.add(rEntrada.getValueAt(i,j));
          }
       }
       rRetorno.addRow(vFila);       
     }
     return rRetorno;
  }
                                                 
}

