import LPSICCBase;


public class LPBusquedaCambiarStatus extends LPSICCBase {

   /**Campos primer pantalla**/
        private String hidCriterioBusqueda1 = new String("");
        private String hidCriterioBusqueda2 = new String("");

        private String hidtextCodCliente = new String("");      
        private String hidcbTipoDocId = new String("");         
        private String hidtextNDocId = new String("");          
        private String hidrbDocPrincipal = new String("");
        private String hidcbPersonaCliente = new String("");

		/** Campos de Tipo y SUbTipo **/
	
       private String hidTipoSubtipo = new String("");

            
        /**Campos segunda pestaña**/

        private String hidtextApellido1 = new String("");
        private String hidtextApellido2 = new String("");
        private String hidtextApellidoCasada = new String("");
        private String hidtextNombre1 = new String("");
        private String hidtextNombre2 = new String("");
        private String hidcbTratamiento = new String("");
        private String hidrbSexo         = new String("");
        private String hidcbFormaPago     = new String("");
        private String hidtextFechaNacimiento   = new String("");
        private String hidtextCodEmpleado        = new String("");
        private String hidcbNacionalidad          = new String("");
        private String hidcbEstadoCivil            = new String("");
        private String hidtextOcupacion             = new String("");
        private String hidtextProfesion              = new String("");
        private String hidtextCentroTrabajo           = new String("");
        private String hidtextCargoDesempena          = new String("");
        private String hidcbNivelEstudios             = new String("");
        private String hidtextCentroEstudios          = new String("");
        private String hidtextNHijos                  = new String("");
        private String hidtextNPersonasDependientes   = new String("");
        private String hidcbNivelSocioEconomico       = new String("");
        private String hidcbCicloVidaFamilia          = new String("");
        private String hidrbDeseaCorrespondencia      = new String("");
        private String hidtextImporteIngresoFamiliar  = new String("");
        private String hidcbPaisVinculo               = new String("");
        private String hidtextClienteVinculo          = new String("");
        private String hidcbTipoVinculo               = new String("");
        private String hidtextFechaD                  = new String("");
        private String hidtextFechaH                  = new String("");
        private String hidrbVinculoPrincipal          = new String("");
        private String hidcb                          = new String("");
        private String hidtextDescripcion             = new String("");
        private String hidcbPaisContactado            = new String("");
        private String hidtextCodClienteContactado    = new String("");
        private String hidcbTipoClienteContactado     = new String("");
        private String hidcbCodTipoContactado         = new String("");
        private String hidtextFechaContacto           = new String("");
        private String hidtextFecha1PedidoContacto    = new String("");
        private String hidtextFechaSiguienteContacto  = new String("");
        private String hidtxtFechaIngresoActual       = new String("");

        private String hidcbMarcaContacto             = new String("");
        private String hidcbCanalContacto             = new String("");
        private String hidcbPeriodoContacto           = new String("");        

        /**Campos tercera pestaña**/

        private String hidcbTipoDireccion            = new String("");
        private String hidcbTipoVia                  = new String("");
        private String hidtextNombreVia              = new String("");
        private String hidtextNPrincipal             = new String("");
        private String hidtextCodPostal              = new String("");
        private String hidtextInterior               = new String("");
        private String hidtextManzana                = new String("");
        private String hidtextLote                   = new String("");
        private String hidtextKm                     = new String("");
        private String hidrbDireccionPrincipal       = new String("");
        private String hidtextObservaciones          = new String("");
        private String hidcbTipoComunicacion         = new String("");
        private String hidcbDiaComunicacion          = new String("");
        private String hidrbComunicacionPrincipal    = new String("");
        private String hidtextHoraDesde              = new String("");
        private String hidtextHoraHasta              = new String("");
        private String hidcbIntervaloComunicacion    = new String("");
        private String hidtextTextoComunicacion      = new String("");
        private String hidcbMarca                    = new String("");
        private String hidcbVia                      = new String("");
        private String hidTextVia                    = new String("");
        private String hiddenTipoCliente             = new String("");
        private String hiddenSubTipoCliente          = new String("");

        /**Campos cuarta pestaña**/

        private String hidcbTipoTarjeta = new String("");
        private String hidcbClasesTarjeta = new String("");
        private String hidcbEntidadBancaria = new String("");
        private String hidcbMarcaPestanya4 = new String("");
        private String hidcbCanal = new String("");
        private String hidcbTipoClasificacion = new String("");
        private String hidcbTipoProblema = new String("");
        private String hidrbSolucion = new String("");
        private String hidcbTipoSolucion = new String("");
        private String hidtextDescripcionProblema = new String("");
        private String hidtextDescripcionSolucion = new String("");
        private String hidcbClasificacion = new String("");
        private String hidtextNegocioProducto = new String("");
        private String ListaComboClasificacion = new String("");
	 public LPBusquedaCambiarStatus() {super();}
	
	 public void inicio() throws Exception {
	 }

	 public void ejecucion() throws Exception {
			conectorAction("LPBusquedaCliente");
			conectorActionParametro("casoDeUso","Cambiar Estatus");
			conectorActionParametro("accion","");
      leerParametros();
      setearParametros();
	 }

   private void leerParametros() throws Exception {
      hidCriterioBusqueda1         = conectorParametroLimpia("hidCriterioBusqueda1","", true); 
      hidCriterioBusqueda2         = conectorParametroLimpia("hidCriterioBusqueda2","", true);
      hidTipoSubtipo               = conectorParametroLimpia("hidTipoSubtipo","", true);
      hiddenTipoCliente            = conectorParametroLimpia("hiddenTipoCliente","", true);
      hiddenSubTipoCliente         = conectorParametroLimpia("hiddenSubTipoCliente","", true);
      hidtextCodCliente            = conectorParametroLimpia("hidtextCodCliente","", true);
      hidcbTipoDocId               = conectorParametroLimpia("hidcbTipoDocId","", true);
      hidtextNDocId                = conectorParametroLimpia("hidtextNDocId","", true);
      hidrbDocPrincipal            = conectorParametroLimpia("hidrbDocPrincipal","", true);
      hidcbPersonaCliente          = conectorParametroLimpia("hidcbPersonaCliente","", true);
      hidtextApellido1             = conectorParametroLimpia("hidtextApellido1","", true);
      hidtextApellido2             = conectorParametroLimpia("hidtextApellido2","", true);
      hidtextApellidoCasada        = conectorParametroLimpia("hidtextApellidoCasada","", true);
      hidtextNombre1               = conectorParametroLimpia("hidtextNombre1","", true);
      hidtextNombre2               = conectorParametroLimpia("hidtextNombre2","", true);
      hidcbTratamiento             = conectorParametroLimpia("hidcbTratamiento","", true);

      hidrbSexo                    = conectorParametroLimpia("hidrbSexo","", true);
      hidcbFormaPago               = conectorParametroLimpia("hidcbFormaPago","", true);
      hidtextFechaNacimiento       = conectorParametroLimpia("hidtextFechaNacimiento","", true);
      hidtextCodEmpleado           = conectorParametroLimpia("hidtextCodEmpleado","", true);
      hidcbNacionalidad            = conectorParametroLimpia("hidcbNacionalidad","", true);
      hidcbTratamiento             = conectorParametroLimpia("hidcbTratamiento","", true);
      hidcbEstadoCivil             = conectorParametroLimpia("hidcbEstadoCivil","", true);
      hidtextOcupacion             = conectorParametroLimpia("hidtextOcupacion","", true);
      hidtextProfesion             = conectorParametroLimpia("hidtextProfesion","", true);
      hidtextCentroTrabajo         = conectorParametroLimpia("hidtextCentroTrabajo","", true);
      hidtextCargoDesempena        = conectorParametroLimpia("hidtextCargoDesempena","", true);
      hidcbNivelEstudios           = conectorParametroLimpia("hidcbNivelEstudios","", true);
      hidtextCentroEstudios        = conectorParametroLimpia("hidtextCentroEstudios","", true);
      hidtextNHijos                = conectorParametroLimpia("hidtextNHijos","", true);
      hidtextNPersonasDependientes = conectorParametroLimpia("hidtextNPersonasDependientes","", true);
      
      hidcbNivelSocioEconomico      = conectorParametroLimpia("hidcbNivelSocioEconomico","", true);
      hidcbCicloVidaFamilia         = conectorParametroLimpia("hidcbCicloVidaFamilia","", true);
      hidrbDeseaCorrespondencia     = conectorParametroLimpia("hidrbDeseaCorrespondencia","", true);
      hidtextImporteIngresoFamiliar = conectorParametroLimpia("hidtextImporteIngresoFamiliar","", true);
      hidcbPaisVinculo              = conectorParametroLimpia("hidcbPaisVinculo","", true);
      hidtextClienteVinculo         = conectorParametroLimpia("hidtextClienteVinculo","", true);
      hidcbTipoVinculo              = conectorParametroLimpia("hidcbTipoVinculo","", true);
      hidtextFechaD                 = conectorParametroLimpia("hidtextFechaD","", true);
      hidtextFechaH                 = conectorParametroLimpia("hidtextFechaH","", true);
      hidrbVinculoPrincipal         = conectorParametroLimpia("hidrbVinculoPrincipal","", true);
      hidcb                         = conectorParametroLimpia("hidcb","", true);
      hidtextDescripcion            = conectorParametroLimpia("hidtextDescripcion","", true);
      hidcbPaisContactado           = conectorParametroLimpia("hidcbPaisContactado","", true);
      hidtextCodClienteContactado   = conectorParametroLimpia("hidtextCodClienteContactado","", true);
      hidcbTipoClienteContactado    = conectorParametroLimpia("hidcbTipoClienteContactado","", true);
      hidcbCodTipoContactado        = conectorParametroLimpia("hidcbCodTipoContactado","", true);
      hidtextFechaContacto          = conectorParametroLimpia("hidtextFechaContacto","", true);
      hidtextFecha1PedidoContacto   = conectorParametroLimpia("hidtextFecha1PedidoContacto","", true);
      hidtextFechaSiguienteContacto = conectorParametroLimpia("hidtextFechaSiguienteContacto","", true);
      hidtxtFechaIngresoActual      = conectorParametroLimpia("hidtxtFechaIngresoActual","", true);
      hidcbMarcaContacto            = conectorParametroLimpia("hidcbMarcaContacto","", true);
      hidcbMarcaContacto            = conectorParametroLimpia("hidcbMarcaContacto","", true);
      hidcbPeriodoContacto          = conectorParametroLimpia("hidcbPeriodoContacto","", true);
      hidcbTipoDireccion            = conectorParametroLimpia("hidcbTipoDireccion","", true);
      hidcbTipoVia                  = conectorParametroLimpia("hidcbTipoVia","", true);
      hidtextNombreVia              = conectorParametroLimpia("hidtextNombreVia","", true);
      hidtextNPrincipal             = conectorParametroLimpia("hidtextNPrincipal","", true);
      hidtextCodPostal              = conectorParametroLimpia("hidtextCodPostal","", true);
      hidtextInterior               = conectorParametroLimpia("hidtextInterior","", true);
      hidtextManzana                = conectorParametroLimpia("hidtextManzana","", true);
      hidtextLote                   = conectorParametroLimpia("hidtextLote","", true);
      hidtextKm                     = conectorParametroLimpia("hidtextKm","", true);
      hidrbDireccionPrincipal       = conectorParametroLimpia("hidrbDireccionPrincipal","", true);
      hidtextObservaciones          = conectorParametroLimpia("hidtextObservaciones","", true);
      hidcbTipoComunicacion         = conectorParametroLimpia("hidcbTipoComunicacion","", true);
      hidcbDiaComunicacion          = conectorParametroLimpia("hidcbDiaComunicacion","", true);
      hidrbComunicacionPrincipal    = conectorParametroLimpia("hidrbComunicacionPrincipal","", true);
      hidtextHoraDesde              = conectorParametroLimpia("hidtextHoraDesde","", true);
      hidtextHoraHasta              = conectorParametroLimpia("hidtextHoraHasta","", true);
      hidcbIntervaloComunicacion    = conectorParametroLimpia("hidcbIntervaloComunicacion","", true);
      hidtextTextoComunicacion      = conectorParametroLimpia("hidtextTextoComunicacion","", true);
      hidcbMarca                    = conectorParametroLimpia("hidcbMarca","", true);
      hidcbVia                      = conectorParametroLimpia("hidcbVia","", true);
      hidTextVia                    = conectorParametroLimpia("hidTextVia","", true);
      hidcbTipoTarjeta              = conectorParametroLimpia("hidcbTipoTarjeta","", true);
      hidcbClasesTarjeta            = conectorParametroLimpia("hidcbClasesTarjeta","", true);
      hidcbEntidadBancaria          = conectorParametroLimpia("hidcbEntidadBancaria","", true);
      hidcbMarcaPestanya4           = conectorParametroLimpia("hidcbMarcaPestanya4","", true);
      hidcbCanal                    = conectorParametroLimpia("hidcbCanal","", true);
      hidcbTipoClasificacion        = conectorParametroLimpia("hidcbTipoClasificacion","", true);
      hidcbTipoProblema             = conectorParametroLimpia("hidcbTipoProblema","", true);
      hidrbSolucion                 = conectorParametroLimpia("hidrbSolucion","", true);
      hidcbTipoSolucion             = conectorParametroLimpia("hidcbTipoSolucion","", true);
      hidtextDescripcionProblema    = conectorParametroLimpia("hidtextDescripcionProblema","", true);
      hidtextDescripcionSolucion    = conectorParametroLimpia("hidtextDescripcionSolucion","", true);
      hidcbClasificacion            = conectorParametroLimpia("hidcbClasificacion","", true);
      hidtextNegocioProducto        = conectorParametroLimpia("hidtextNegocioProducto","", true);
      ListaComboClasificacion       = conectorParametroLimpia("ListaComboClasificacion","", true);


   }

   private void setearParametros() throws Exception {
        traza("--- Setea parametros ---");

        traza("--- Caso de Uso ---");
             
          
      conectorActionParametro("hidCriterioBusqueda1",hidCriterioBusqueda1); 
      conectorActionParametro("hidCriterioBusqueda2",hidCriterioBusqueda2);
      conectorActionParametro("hidTipoSubtipo",hidTipoSubtipo);
      conectorActionParametro("hiddenTipoCliente",hiddenTipoCliente);
      conectorActionParametro("hiddenSubTipoCliente",hiddenSubTipoCliente);
      conectorActionParametro("hidtextCodCliente",hidtextCodCliente);
      conectorActionParametro("hidcbTipoDocId",hidcbTipoDocId);
      conectorActionParametro("hidtextNDocId",hidtextNDocId);
      conectorActionParametro("hidrbDocPrincipal",hidrbDocPrincipal);
      conectorActionParametro("hidcbPersonaCliente",hidcbPersonaCliente);
      conectorActionParametro("hidtextApellido1",hidtextApellido1);
      conectorActionParametro("hidtextApellido2",hidtextApellido2);
      conectorActionParametro("hidtextApellidoCasada",hidtextApellidoCasada);
      conectorActionParametro("hidtextNombre1",hidtextNombre1);
      conectorActionParametro("hidtextNombre2",hidtextNombre2);
      conectorActionParametro("hidcbTratamiento",hidcbTratamiento);
      conectorActionParametro("hidrbSexo",hidrbSexo);
      conectorActionParametro("hidcbFormaPago",hidcbFormaPago);
      conectorActionParametro("hidtextFechaNacimiento",hidtextFechaNacimiento);
      conectorActionParametro("hidtextCodEmpleado",hidtextCodEmpleado);
      conectorActionParametro("hidcbNacionalidad",hidcbNacionalidad);
      conectorActionParametro("hidcbTratamiento",hidcbTratamiento);
      conectorActionParametro("hidcbEstadoCivil",hidcbEstadoCivil);
      conectorActionParametro("hidtextOcupacion",hidtextOcupacion);
      conectorActionParametro("hidtextProfesion",hidtextProfesion);
      conectorActionParametro("hidtextCentroTrabajo",hidtextCentroTrabajo);
      conectorActionParametro("hidtextCargoDesempena",hidtextCargoDesempena);
      conectorActionParametro("hidcbNivelEstudios",hidcbNivelEstudios);
      conectorActionParametro("hidtextCentroEstudios",hidtextCentroEstudios);
      conectorActionParametro("hidtextNHijos",hidtextNHijos);
      conectorActionParametro("hidtextNPersonasDependientes",hidtextNPersonasDependientes);
      conectorActionParametro("hidcbNivelSocioEconomico",hidcbNivelSocioEconomico);
      conectorActionParametro("hidcbCicloVidaFamilia",hidcbCicloVidaFamilia);
      conectorActionParametro("hidrbDeseaCorrespondencia",hidrbDeseaCorrespondencia);
      conectorActionParametro("hidtextImporteIngresoFamiliar",hidtextImporteIngresoFamiliar);
      conectorActionParametro("hidcbPaisVinculo",hidcbPaisVinculo);
      conectorActionParametro("hidtextClienteVinculo",hidtextClienteVinculo);
      conectorActionParametro("hidcbTipoVinculo",hidcbTipoVinculo);
      conectorActionParametro("hidtextFechaD",hidtextFechaD);
      conectorActionParametro("hidtextFechaH",hidtextFechaH);
      conectorActionParametro("hidrbVinculoPrincipal",hidrbVinculoPrincipal);
      conectorActionParametro("hidcb",hidcb);
      conectorActionParametro("hidtextDescripcion",hidtextDescripcion);
      conectorActionParametro("hidcbPaisContactado",hidcbPaisContactado);
      conectorActionParametro("hidtextCodClienteContactado",hidtextCodClienteContactado);
      conectorActionParametro("hidcbTipoClienteContactado",hidcbTipoClienteContactado);
      conectorActionParametro("hidcbCodTipoContactado",hidcbCodTipoContactado);
      conectorActionParametro("hidtextFechaContacto",hidtextFechaContacto);
      conectorActionParametro("hidtextFecha1PedidoContacto",hidtextFecha1PedidoContacto);
      conectorActionParametro("hidtextFechaSiguienteContacto",hidtextFechaSiguienteContacto);
      conectorActionParametro("hidtxtFechaIngresoActual",hidtxtFechaIngresoActual);
      conectorActionParametro("hidcbMarcaContacto",hidcbMarcaContacto);
      conectorActionParametro("hidcbMarcaContacto",hidcbMarcaContacto);
      conectorActionParametro("hidcbPeriodoContacto",hidcbPeriodoContacto);
      conectorActionParametro("hidcbTipoDireccion",hidcbTipoDireccion);
      conectorActionParametro("hidcbTipoVia",hidcbTipoVia);
      conectorActionParametro("hidtextNombreVia",hidtextNombreVia);
      conectorActionParametro("hidtextNPrincipal",hidtextNPrincipal);
      conectorActionParametro("hidtextCodPostal",hidtextCodPostal);
      conectorActionParametro("hidtextInterior",hidtextInterior);
      conectorActionParametro("hidtextManzana",hidtextManzana);
      conectorActionParametro("hidtextLote",hidtextLote);
      conectorActionParametro("hidtextKm",hidtextKm);
      conectorActionParametro("hidrbDireccionPrincipal",hidrbDireccionPrincipal);
      conectorActionParametro("hidtextObservaciones",hidtextObservaciones);
      conectorActionParametro("hidcbTipoComunicacion",hidcbTipoComunicacion);
      conectorActionParametro("hidcbDiaComunicacion",hidcbDiaComunicacion);
      conectorActionParametro("hidrbComunicacionPrincipal",hidrbComunicacionPrincipal);
      conectorActionParametro("hidtextHoraDesde",hidtextHoraDesde);
      conectorActionParametro("hidtextHoraHasta",hidtextHoraHasta);
      conectorActionParametro("hidcbIntervaloComunicacion",hidcbIntervaloComunicacion);
      conectorActionParametro("hidtextTextoComunicacion",hidtextTextoComunicacion);
      conectorActionParametro("hidcbMarca",hidcbMarca);
      conectorActionParametro("hidcbVia",hidcbVia);
      conectorActionParametro("hidTextVia",hidTextVia);
      conectorActionParametro("hidcbTipoTarjeta",hidcbTipoTarjeta);
      conectorActionParametro("hidcbClasesTarjeta",hidcbClasesTarjeta);
      conectorActionParametro("hidcbEntidadBancaria",hidcbEntidadBancaria);
      conectorActionParametro("hidcbMarcaPestanya4",hidcbMarcaPestanya4);
      conectorActionParametro("hidcbCanal",hidcbCanal);
      conectorActionParametro("hidcbTipoClasificacion",hidcbTipoClasificacion);
      conectorActionParametro("hidcbTipoProblema",hidcbTipoProblema);
      conectorActionParametro("hidrbSolucion",hidrbSolucion);
      conectorActionParametro("hidcbTipoSolucion",hidcbTipoSolucion);
      conectorActionParametro("hidtextDescripcionProblema",hidtextDescripcionProblema);
      conectorActionParametro("hidtextDescripcionSolucion",hidtextDescripcionSolucion);
      conectorActionParametro("hidcbClasificacion",hidcbClasificacion);
      conectorActionParametro("hidtextNegocioProducto",hidtextNegocioProducto);
      conectorActionParametro("ListaComboClasificacion",ListaComboClasificacion);
          
                 

  }
}
