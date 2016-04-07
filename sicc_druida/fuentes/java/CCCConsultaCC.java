import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ccc.DTORepConsultaCCC;
import es.indra.sicc.dtos.ccc.DTOSaldoCampana;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.ccc.DTORepBusquedaCC;
import es.indra.sicc.dtos.ccc.DTODetalleCargos;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;

import java.util.Vector;
import java.util.Date;
import es.indra.sicc.util.Cronometrador;

//import java.math.BigDecimal;


public class CCCConsultaCC extends LPSICCBase {           
  // String formatoFechaSesion =null;
   public CCCConsultaCC() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
	 
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
	 
     try {
        this.rastreo();
        traza("la accion es " + accion);
        if (accion.equals("generarConsulta")){
           generarConsulta(); 
           //traza("termino de generar el reporte");
           getConfiguracionMenu("CCCConsultaCC", "generarConsulta");
        }else if (accion.equals("saldoCampana")){
                 saldoCampana();
                 getConfiguracionMenu("CCCConsultaCC", "saldoCampana");
               }else if(accion.equals("detalle")){
                        detalle();
                        getConfiguracionMenu("CCCConsultaCC", "saldoCampana");
                     }else{
                        cargarPagina();
                        getConfiguracionMenu("CCCConsultaCC");
                     }
     
     } catch (Exception ex) {
     			
      // cargarPagina();
      //  getConfiguracionMenu("EDUFichaTecnicaCurso");
               
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);
      /*  try{
            cargarPagina();
        }catch(Exception e){
            e.printStackTrace();
        }*/

     }

    
  }
  
  private void cargarPagina() throws Exception{
     pagina("contenido_informe_consulta_CCC_generar"); 
     asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());                                                        
	 traza("***MAD El codigo de cliente parametro es " + conectorParametroLimpia("codCliente", "", true));
	 asignarAtributo("VAR", "codigoConsultora", "valor", conectorParametroLimpia("codCliente", "", true));                                                        

     
  }
 /*
	15/08/2006 - [1] - pperanzola - se realizan cambios por performance.
    09/04/2007 - [2] - Rafael Romero - Se agrega direccion y fecha de nacimiento en la pantalla - SiCC 20070177
 */
  private void generarConsulta() throws Exception{
	 Cronometrador.startTransaction("generarConsulta");
     pagina("contenido_cuenta_corriente_consultar"); 
	 
	 String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
     String codigoConsultora = conectorParametroLimpia("codigoConsultora", "", true);

	 String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
	 if(casoDeUso.length() >0){
		asignar("VAR", "casoDeUso", casoDeUso);
	 }

	 asignarAtributo("LABELC", "lblCodClientedt", "valor", codigoConsultora);
     asignarAtributo("VAR", "codigoCliente", "valor", codigoConsultora);
     
     MareBusinessID id = new MareBusinessID("CCCRepConsultaCCC");
     DTORepBusquedaCC dto = new DTORepBusquedaCC();      
     
     dto.setCodCliente(codigoConsultora); //[1] conectorParametroLimpia("codigoConsultora", "", true));
     
     String numeroCargo = conectorParametroLimpia("numeroCargo", "", true); 
     if(!numeroCargo.equals("")){
        dto.setNumeroCargo(new Long(numeroCargo));
     }
     
     dto.setOidPais(UtilidadesSession.getPais(this));
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     Vector vec = new Vector();
          
     vec.add(dto);
     vec.add(id);

     DTORepConsultaCCC dtoRep = (DTORepConsultaCCC)conectar("ConectorUA",vec).objeto("dtoSalida");

	 //	Modificado por HRCS - Fecha 02/04/2007 - Incidencia Sicc20070176
     String unidadGeo = dtoRep.getRegion() + " / " + dtoRep.getZona() + " / " + dtoRep.getTerritorio(); //getSgv();
     
     if(dtoRep.getApenom() != null){
        asignarAtributo("LABELC", "lblNombredt", "valor", dtoRep.getApenom());
     }
     
     if(dtoRep.getTipoCodigoTipoDocumento() != null){
        asignarAtributo("LABELC", "lblTipoDidt", "valor", dtoRep.getTipoCodigoTipoDocumento());
     }
     
     if(dtoRep.getNumeroDocumento() != null){
        asignarAtributo("LABELC", "lblDocIdentidaddt", "valor", dtoRep.getNumeroDocumento());
     }
     
     if(dtoRep.getFechaIngreso() != null){
         asignarAtributo("LABELC", "lblCampanaIngresodt", "valor", formatFecha (dtoRep.getFechaIngreso(),formatoFechaSesion));
     }
     
     // [1] if(unidadGeo != null){
     asignarAtributo("LABELC", "lblRegionZonaTerritoriodt", "valor", unidadGeo);
    // [1] }
     
     if(dtoRep.getCodNivelRiesgo() != null){
        asignarAtributo("LABELC", "lblRiesgodt", "valor", dtoRep.getCodNivelRiesgo());
     }
     
     if(dtoRep.getImporteLineaCredito() != null){
        asignarAtributo("LABELC", "lblLineaCreditodt", "valor", dtoRep.getImporteLineaCredito());
     }
     
     if(dtoRep.getStatusCliente() != null){
        asignarAtributo("LABELC", "lblEstadodt", "valor", dtoRep.getStatusCliente());
     }        
        
     if(dtoRep.getDeudaTotal() != null){
        asignarAtributo("LABELC", "lblDeudaTotaldt", "valor", dtoRep.getDeudaTotal());
		asignarAtributo("VAR", "hiddenDeudaTotal", "valor", dtoRep.getDeudaTotal());
     }
     
     // [2]i Rafael Romero - 09/04/2007 - SiCC 20070177
     if(dtoRep.getDireccion() != null){
        asignarAtributo("LABELC", "lblDirecciondt", "valor", dtoRep.getDireccion());
     }

     if(dtoRep.getFechaNacimiento() != null){
        asignarAtributo("LABELC", "lblFechaNacidt", "valor", this.formatFecha(dtoRep.getFechaNacimiento(),formatoFechaSesion));
     }

	 //jrivas CCC-04 24/07/2008 
	 if(dtoRep.getPagoSaldoVencido() != null){
        asignarAtributo("LABELC", "lblpagoSaldoVencidot", "valor", dtoRep.getPagoSaldoVencido());
     }
     if(dtoRep.getSaldoPorVencer() != null){
        asignarAtributo("LABELC", "lblSaldoPorVencert", "valor", dtoRep.getSaldoPorVencer());
     }


     asignarAtributo("VAR", "oidCliente", "valor", dtoRep.getOidCliente().toString());
	 asignarAtributo("LABELC", "lblFechaHoradt", "valor", formatFecha (new java.util.Date(System.currentTimeMillis()), formatoFechaSesion+" HH:mm a"  ));
     RecordSet rsDatosLista = dtoRep.getDatosCC();
	 DruidaConector conLista = UtilidadesBelcorp.generarConector("LISTA", rsDatosLista, rsDatosLista.getColumnIdentifiers()); //[1]
     asignar("LISTADOA", "listado1", conLista, "LISTA");
	 Cronometrador.endTransaction("generarConsulta");
  } 
  
  private String formatFecha (Date fecha, String formatoFechaSesion){

	 formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
	 SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
	 return simpleDate.format(fecha);

  }

  private void saldoCampana() throws Exception{
     pagina("contenido_saldo_por_campana"); 
     
     String periodo = conectorParametroLimpia("oidPeriodo", "", true);
     String cliente = conectorParametroLimpia("oidCliente", "", true);
     
     DTOSaldoCampana dto = new DTOSaldoCampana();
     
     dto.setOidPeriodo(new Long(periodo));
     dto.setOidCliente(new Long(cliente));
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     dto.setOidPais(UtilidadesSession.getPais(this));
     
     traza("**********el dto es " + dto);
     MareBusinessID id = new MareBusinessID("CCCRepConsultaSaldoCampana");
     Vector vec = new Vector();
          
     vec.add(dto);
     vec.add(id);
     
     DTOSaldoCampana dtoSC = (DTOSaldoCampana)conectar("ConectorUA",vec).objeto("dtoSalida");
     RecordSet rsFinal;
     rsFinal = dtoSC.getSaldoCampana();
     
     traza("el recordset final es " + dtoSC.getSaldoCampana());
     
     DruidaConector conLista = UtilidadesBelcorp.generarConector("LISTA", rsFinal, rsFinal.getColumnIdentifiers());
     asignar("LISTADOA", "listado1", conLista, "LISTA");
      
  }
  /*
	16/08/2006 - [1] pperanzola  se modifica segun performance
  */
  private void detalle() throws Exception{
     pagina("contenido_cargo_detalle");
     
     String oid = conectorParametroLimpia("oid", "", true);
     
     DTOOID dto = new DTOOID();
     
     dto.setOid(new Long(oid));
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     dto.setOidPais(UtilidadesSession.getPais(this));
     
     MareBusinessID id = new MareBusinessID("CCCRepDetalleCargos");
	 String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
	 Vector vec = new Vector();
          
     vec.add(dto);
     vec.add(id);
     
     DTODetalleCargos dtoDetalleCargos = (DTODetalleCargos)conectar("ConectorUA",vec).objeto("dtoSalida");
     
     RecordSet rsDatosLista = dtoDetalleCargos.getDatosLista();
    
     // Modificado Rafael Romero - SiCC 20070254 - 10/05/2007
     asignarAtributo("LABELC", "lbldtTotal", "valor", rsDatosLista.getValueAt(0,8).toString());

	 //CCC-04 jrivas 28/7/2008
     asignarAtributo("LABELC", "lblCodClientedt", "valor", dtoDetalleCargos.getCodigoConsultora());
     asignarAtributo("LABELC", "lblNombredt", "valor", dtoDetalleCargos.getApenom());
     asignarAtributo("LABELC", "lclCampaniat", "valor", dtoDetalleCargos.getCampania());
     asignarAtributo("LABELC", "lblNumConsolidadot", "valor", dtoDetalleCargos.getNumeroConsolidado());
     String numFact = "";
	 if (dtoDetalleCargos.getNumeroFactura() != null && !dtoDetalleCargos.getNumeroFactura().esVacio()){
		 for (int i = 0; i < dtoDetalleCargos.getNumeroFactura().getRowCount(); i++)  {
			numFact = numFact + dtoDetalleCargos.getNumeroFactura().getValueAt(i, 0) + " <BR/>";
		 }
	 }
	 asignarAtributo("LABELC", "lblNumFacturat", "valor", numFact);
     asignarAtributo("LABELC", "lblFechaFacturaciont", "valor", this.formatFecha(dtoDetalleCargos.getFechaFacturacion(),formatoFechaSesion));
	 asignarAtributo("LABELC", "lblChequeot", "valor", dtoDetalleCargos.getIndicadorChequeo());
     asignarAtributo("LABELC", "lblImporteFletet", "valor", dtoDetalleCargos.getImporteFletes());
     asignarAtributo("LABELC", "lblImpuestost", "valor", dtoDetalleCargos.getImpuestos());
     asignarAtributo("LABELC", "lblSaldoPendCampaniat", "valor", dtoDetalleCargos.getSaldoPendiente());
     asignarAtributo("LABELC", "lblPagosPosteriorest", "valor", dtoDetalleCargos.getPagosPosteriores());
     asignarAtributo("LABELC", "lblPagosDiferidost", "valor", dtoDetalleCargos.getPagosDiferidos());

	 DruidaConector conLista = UtilidadesBelcorp.generarConector("LISTA", rsDatosLista, rsDatosLista.getColumnIdentifiers());
     asignar("LISTADOA", "listado1", conLista, "LISTA");
     
  
  }
}

