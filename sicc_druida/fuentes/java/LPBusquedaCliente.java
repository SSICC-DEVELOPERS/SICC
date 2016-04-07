/**
 * Sistema:          Belcorp - SICC
 * Modulo:           MAE - Maestro de clientes
 * Componente:       LPBusquedaCliente
 * @version          2.0
 */ 

//importa las librerias que va a necesitar

//import LPSICCBase;
//import DruidaTransactionComun;
import es.indra.sicc.druida.formatos.BooleanValue;
import es.indra.druida.DruidaFormatoObjeto;

//import es.indra.sicc.DTBuscarCliente;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.*;
import es.indra.druida.Contexto;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.Hashtable;

import es.indra.druida.DruidaDataBase;
import java.math.BigDecimal;



import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.mae.DTOConsultaCliente;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.dtos.mae.DTOPestanya2;
import es.indra.sicc.dtos.mae.DTOPestanya2Base;
import es.indra.sicc.dtos.mae.DTOPestanya3;
import es.indra.sicc.dtos.mae.DTOPestanya3Base;
import es.indra.sicc.dtos.mae.DTOPestanya4;
import es.indra.sicc.dtos.mae.DTOPestanyaBusqueda1;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposCliente;
import es.indra.sicc.dtos.mae.DTOCampo;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTOProblemaSolucion;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.mae.DTOIdentificacion;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOClienteMarca;
import es.indra.sicc.dtos.mae.DTOClasificacionCliente;
import es.indra.sicc.dtos.mae.DTOVinculo;
import es.indra.sicc.dtos.mae.DTOPreferencia;
import es.indra.sicc.dtos.mae.DTOComunicacion;
import es.indra.sicc.dtos.mae.DTOTarjeta;
import es.indra.sicc.dtos.mae.DTOProblemaSolucion;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import java.io.*;
import es.indra.sicc.dtos.mae.DTOClienteIndicador;



import java.io.*;

import java.lang.Boolean;

import java.util.Vector;
import java.util.HashMap;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import java.sql.*;

public class LPBusquedaCliente extends LPSICCBase {
  public static String TOKEN_VACIO = " ";
  public static String SEPARADOR_PARAMETROS = "&";
   public boolean param = false;
   private String casoDeUso;
   private String sBuffer;

   /*** Campo Codigo Cliente para usar en la primer pestaña del Detalle.  ***/
  private String hidCodigoCliente = new String("");

        /**Campos primer pantalla**/
        private String hidCriterioBusqueda1 = new String("");
        private String hidCriterioBusqueda2 = new String("");

        private String hidtextCodCliente = new String("");      
        private String hidcbTipoDocId = new String("");         
        private String hidtextNDocId = new String("");          
        private String hidrbDocPrincipal = new String("");
        private String hidcbPersonaCliente = new String("");
		private String hidIndActi = new String("");

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
        /*private String hidtextInterior               = new String("");
        private String hidtextManzana                = new String("");
        private String hidtextLote                   = new String("");
        private String hidtextKm                     = new String("");*/
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

   public LPBusquedaCliente() {super();}
	
	 public void inicio() throws Exception {
	 }

	 public void ejecucion() throws Exception {
		 //this.rastreo();
     MareDTO m = new MareDTO();
      setTrazaFichero();
     /*traza("BooleanValue.VERDADERO_KEY: " + BooleanValue.VERDADERO_KEY);
     traza("BooleanValue.FALSE_KEY: " + BooleanValue.FALSO_KEY);
      BooleanValue prueba = new BooleanValue();
      
      traza("AAA");
      traza("idioma: " + UtilidadesSession.getIdioma_ISO(this));
      traza("prueba.A: " + this.getRequest().getSession().getAttribute(BooleanValue.FALSO_KEY)) ;
      traza("prueba.B: " + this.getRequest().getSession().getAttribute(BooleanValue.VERDADERO_KEY));
      
      String no = prueba.getDruidaData().sesionString(prueba.FALSO_KEY);
      traza("no: " + no);
      String si = prueba.getDruidaData().sesionString(prueba.VERDADERO_KEY);
      traza("si: " + si);*/
      
    String accion     = conectorParametroLimpia("accion", "", true);
     
     Long  pais        = UtilidadesSession.getPais(this);
     Long  idioma      = UtilidadesSession.getIdioma(this);
     String criterio1  = conectorParametroLimpia("hCriterio1", "", true);
     String criterio2  = conectorParametroLimpia("hCriterio2", "", true);
	 casoDeUso = (String) conectorParametro("casoDeUso");
	 traza("Caso de Uso: " + casoDeUso);


        traza("ACCION DE ENTRADA: " + accion);

      try{
           /**Todos los ifs que hay en la carga de los combos deben ser removidos. Estan porque sino
             la aplicacion pincha, pero luego no pinchara porque se modificara para que si no encuentra valores
             no devuelva error**/
          //rastreo(); RECORDAR DESCOMENTAR
		
         
         if (accion.equals("")){
         
      			//traza("caso de Uso: " + casoDeUso);
            //[1] this.leeHiddens(); lo quito porque si la accion es vacia las hiddens van a ser vacias
            
            pagina("contenido_clientes_buscar");
            getConfiguracionMenu("LPBusquedaCliente");
            if ( casoDeUso.equals("modificar") )
              this.asignarAtributoPagina("cod", "0409");
            else if (casoDeUso.equals("Cambiar Estatus") || casoDeUso.equals("cambiar") || casoDeUso.equals("cambiarStatus"))
              asignarAtributoPagina("cod", "0344");
            else if (casoDeUso.equals("consultar") )
              asignarAtributoPagina("cod","0410");
              
            asignarCasoUso();
            //[1] this.seteaHiddens(); lo quito porque si la accion es vacia las hiddens van a ser vacias
            //this.leeHiddens();
            //traza("Termina de setear contenido_clientes_buscar");            

         }
       
         
         else if (accion.equals("siguienteTipoSubtipo"))
         {

           /*OK-Guardamos en campos ocultos los parametros que vienen de la pestaña anterior 
             OK-La pagina asociada es PestanyaBusquedaTipoSubtipo 
             OK-idBusiness="MAEObtenerTipoSubtipo" 
             OK-Se llama al ConectorTipoSubtipo con un DTOBelcorp en el que metemos el idioma y el pais 
             FALTA-con el atributo tipos del dto recibido cargamos el combo tipo, el recordset subtipos lo guardamosen listas 
             ocultas para que se recarge el combo subtipo dinaminamente con JavaScript, ya que el recordset de subtipo 
             tiene una columna que indica el tipo*/

            //pagina("contenido_clientes_insertar");
			//pagina("PruebaConsultarClientes");
            this.leeHiddens();
            traza("hidTipo Antes de ir a tipo y subtipo: " + hidTipoSubtipo);
            
      
  			pagina("contenido_clientes_insertar2");
        getConfiguracionMenu("LPBusquedaCliente", "siguienteTipoSubtipo");
        if ( casoDeUso.equals("modificar") )
          this.asignarAtributoPagina("cod", "0409");
        else if (casoDeUso.equals("Cambiar Estatus") || casoDeUso.equals("cambiar") )
          asignarAtributoPagina("cod", "0344");
        else if (casoDeUso.equals("consultar") )
          asignarAtributoPagina("cod","0410");
           
			asignarCasoUso();
            //traza("hidTipo luego de entrar a tipo y subtipo: " + hidTipoSubtipo);
            this.seteaHiddens();
		 
            //asignarAtributo("VAR", "casoConsultar", "valor", "S");                        
            Vector paramEntrada = new Vector();

            MareBusinessID id = new MareBusinessID("MAEObtenerTipoSubtipo");
            DruidaConector conector = new DruidaConector();
            DTOBelcorp dto = new DTOBelcorp();

            dto.setOidPais(pais);
            dto.setOidIdioma(idioma);

            paramEntrada.add(dto);            
            paramEntrada.add(id);

            conector = conectar("ConectorTipoSubtipo",paramEntrada);
            DTOTipoSubtipo dtoS = (DTOTipoSubtipo) conector.objeto("DTOSalida");
      
            RecordSet rSubTipos = dtoS.getSubtipos();
            RecordSet rTipos = dtoS.getTipos();
            UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
            utilidadesBelcorp.agregarRegistroVacio(rTipos, 0);

            //traza("rTipos: " + rTipos.toString() );
            //traza("rSubTipos: " + rSubTipos.toString() );

			StringBuffer sOidTipo = new StringBuffer("");
			StringBuffer sDescTipo = new StringBuffer("");
			DruidaConector con = this.generarConector("rowset", rTipos, rTipos.getColumnIdentifiers());

            //asignar("comboTipoCliente", "rowset", con);
            this.asignar("COMBO", "cbTipoCliente", con, "rowset");
            StringBuffer sOid = new StringBuffer("");
            StringBuffer sDesc = new StringBuffer("");
            StringBuffer sPadre = new StringBuffer("");
            
            if (rSubTipos.getRowCount() > 0)
            {
                for (int i = 0; i< rSubTipos.getRowCount(); i++ )
                {
                    if (i != 0) 
                    {
                      sOid.append(",");
                      sDesc.append(",");
                      sPadre.append(",");
                    }
                    sOid.append( ( (BigDecimal) rSubTipos.getValueAt(i,0)).toString() );
                    sDesc.append(  (String) rSubTipos.getValueAt(i,2) );                
                    sPadre.append( ( (BigDecimal) rSubTipos.getValueAt(i,1)).toString() );
                }              
            }

			//traza("sOid: " + sOid.toString() );
			//traza("sDesc: " + sDesc.toString() );
			//traza("sPadre: "  + sPadre.toString() );

            asignarAtributo("VAR", "oidSubTipo", "valor", sOid.toString() );
            asignarAtributo("VAR", "padreSubTipo", "valor", sPadre.toString() );
            asignarAtributo("VAR", "descSubTipo", "valor", sDesc.toString() );
            
        } 
        
            
         //if((accion.equals(""))||(accion.equals("siguientePestanya1"))) { 
           else if( accion.equals("siguientePestanya1")) 
           {          
            //if((accion.equals("")){
            /*OK-Guardamos en campos ocultos los parametros que vienen de las pestañas anteriores 
             OK-La pagina asociada es PestanyaBusqueda1 
             OK-idBusiness="MAEPestanya1Busqueda" 
             OK-Llamamos al ConectorPestanyaBusqueda1 con un DTOBelcorp (con el pais y el idioma) 
             OK-Con el DTOPestanyaBusqueda1, con tiposDocumento cargamos el combo tipoDocumento y el atributo 
             tamCodigoCliente lo guardamos en un campo oculto "TamCodigoCliente", salvo si es null que no lo guardamos, 
             además limitamos el tamaño del campo codigoCliente a este número.*/
            leeHiddens();
            
      
            pagina("contenido_grupo1_buscar");
            getConfiguracionMenu("LPBusquedaCliente", "siguientePestanya1");
            if ( casoDeUso.equals("modificar") )
              this.asignarAtributoPagina("cod", "0409");
            else if (casoDeUso.equals("Cambiar Estatus") || casoDeUso.equals("cambiar") )
              asignarAtributoPagina("cod", "0344");
            else if (casoDeUso.equals("consultar") )
              asignarAtributoPagina("cod","0410");
              
      			asignarCasoUso();
            seteaHiddens();

            getConfiguracionMenu();

            /************Hiddens********/
                    

            Vector paramEntradaGrupo1     = new Vector();
            MareBusinessID idGrupo1       = new MareBusinessID("MAEPestanya1Busqueda");
            DruidaConector conectorGrupo1 = new DruidaConector();
            DTOBelcorp dtoGrupo1          = new DTOBelcorp();

            dtoGrupo1.setOidPais(pais);
            dtoGrupo1.setOidIdioma(idioma);

            paramEntradaGrupo1.add(dtoGrupo1);            
            paramEntradaGrupo1.add(idGrupo1);
            //traza("antes del conector");

            conectorGrupo1 = conectar("ConectorPestanyaBusqueda1",paramEntradaGrupo1);
            //traza("despues del conector");
            DTOPestanyaBusqueda1 dtoDatos = (DTOPestanyaBusqueda1) conectorGrupo1.objeto("DTOSalida");
            RecordSet rs = (RecordSet)dtoDatos.getTiposDocumento();
            if(rs != null){
                Vector colID = rs.getColumnIdentifiers();
                int numCol = rs.getColumnCount();
                DruidaConector tipoDocumento = this.generarConector("DTOSalida.resultado_ROWSET",rs, colID);
                traza("TipoDoc: " + tipoDocumento.getXML() );
                asignar("COMBO","cbTipoDocId", tipoDocumento, "DTOSalida.resultado_ROWSET");
            }
            
			String hidlongCodCliente   = conectorParametroLimpia("hidCriterioBusqueda1", "", true);
			if (hidlongCodCliente.equals("")){
	            hidlongCodCliente  = this.obtenerLongitudCodigoCliente().toString();
			}

            asignarAtributo("VAR", "hidlongCodCliente", "valor", hidlongCodCliente);

			//SICC-DMCO-MAE-GCC-006 - Cleal 
			//Carga el combo de Indice Activo
			RecordSet rsCbIndActi = new RecordSet();
			Vector vInacti = new Vector();
			vInacti.add(ConstantesMAE.IND_CLIEN_INACTIVO);
			vInacti.add("Inactivo");

			Vector vActi = new Vector();
			vActi.add(ConstantesMAE.IND_CLIEN_ACTIVO);
			vActi.add("Activo");

			rsCbIndActi.addColumn("OID");
			rsCbIndActi.addColumn("DESC");
			rsCbIndActi.addRow(vActi);
			rsCbIndActi.addRow(vInacti);

			Vector colIDIndActi = rsCbIndActi.getColumnIdentifiers();
			
			DruidaConector IndActi = this.generarConector("DTOSalida.resultado_ROWSET",rsCbIndActi, colIDIndActi);
			asignar("COMBO","cbIndActivo", IndActi, "DTOSalida.resultado_ROWSET");
			//

			//traza("termino...");
         } 

         else if(accion.equals("siguientePestanya2")){

           /*FALTA-Guardamos en campos ocultos los parametros que vienen de las pestañas anteriores 
           OK-idBusiness="MAEPestanya2Busqueda" 
           OK-Llamamos al ConectorPestanyaBusqueda2 con un DTOBelcorp (con el pais y el idioma) 
           OK-con los recordset obtenidos rellenamos los combos correspondientes (ignoramos los atributos: saldo, 
            estaCastigado, existe y oidCliente*/ 
            this.leeHiddens();
            
      
            pagina("contenido_grupo2_buscar");
            getConfiguracionMenu("LPBusquedaCliente", "siguientePestanya2");
            if ( casoDeUso.equals("modificar") )
              this.asignarAtributoPagina("cod", "0409");
            else if (casoDeUso.equals("Cambiar Estatus") || casoDeUso.equals("cambiar") )
              asignarAtributoPagina("cod", "0344");
            else if (casoDeUso.equals("consultar") )
              asignarAtributoPagina("cod","0410");
              
      			asignarCasoUso();
            this.seteaHiddens();



/*            String hidtextCodCliente      = conectorParametroLimpia("textCodCliente","",true);
            String hidcbTipoDocId         = conectorParametroLimpia("cbTipoDocId","",true);
            String hidtextNDocId          = conectorParametroLimpia("textNDocId","",true);
            String hidrbDocPrincipal      = conectorParametroLimpia("rbDocPrincipal","",true);
            String hidcbPersonaCliente    = conectorParametroLimpia("cbPersonaCliente","",true);

            asignarAtributo("VAR", "hidtextCodCliente", "valor", hidtextCodCliente);
            asignarAtributo("VAR", "hidcbTipoDocId", "valor", hidcbTipoDocId);
            asignarAtributo("VAR", "hidtextNDocId", "valor", hidtextNDocId);
            asignarAtributo("VAR", "hidrbDocPrincipal", "valor", hidrbDocPrincipal);
            asignarAtributo("VAR", "hidcbPersonaCliente", "valor", hidcbPersonaCliente);
  */         
            Vector paramEntradaGrupo2 = new Vector();
            MareBusinessID idGrupo2 = new MareBusinessID("MAEPestanya2Busqueda");
            DruidaConector conectorGrupo2 = new DruidaConector();
            DTOBelcorp dtoGrupo2 = new DTOBelcorp();

            dtoGrupo2.setOidPais(pais);
            dtoGrupo2.setOidIdioma(idioma);

            paramEntradaGrupo2.add(dtoGrupo2);            
            paramEntradaGrupo2.add(idGrupo2);
            
            //traza("antes conector 2");
            conectorGrupo2 = conectar("ConectorPestanyaBusqueda2",paramEntradaGrupo2);
            //traza("despues conector 2");
           
            DTOPestanya2     dtoDatosPestanya2     = (DTOPestanya2) conectorGrupo2.objeto("DTOSalida");
            traza("dtoPestanya2: " + dtoDatosPestanya2.toString() );
            DTOPestanya2Base dtoDatosPestanya2Base = dtoDatosPestanya2.getBase();
            

            /**********Lleno el combo formas de pago***********/
            RecordSet rsPestanya2              = (RecordSet)dtoDatosPestanya2Base.getFormasPago();
            if (rsPestanya2 != null){
				Vector colIDPestanya2              = rsPestanya2.getColumnIdentifiers();
				int numColPestanya2                = rsPestanya2.getColumnCount();
					rsPestanya2.removeColumn(1);
				DruidaConector formasPago          = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya2, colIDPestanya2);

				
				asignar("COMBO","cbFormaPago", formasPago, "DTOSalida.resultado_ROWSET");
            }

            /***********Lleno el combo de nacionalidad********/
            RecordSet rsPestanyaNac            = (RecordSet)dtoDatosPestanya2.getNacionalidad();
            if(rsPestanyaNac != null){
				Vector colIDPestanyaNac            = rsPestanyaNac.getColumnIdentifiers();
				int numColPestanyaNac              = rsPestanyaNac.getColumnCount();
				DruidaConector nacionalidad        = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanyaNac, colIDPestanyaNac);
				asignar("COMBO","cbNacionalidad", nacionalidad, "DTOSalida.resultado_ROWSET");
            }
       
            /***********Lleno el combo de estado civil********/
            RecordSet rsPestanyaEstCiv         = (RecordSet)dtoDatosPestanya2.getEstadoCivil();
           
            Vector colIDPestanyaEstCiv         = rsPestanyaEstCiv .getColumnIdentifiers();
            int numColPestanyaEstCiv           = rsPestanyaEstCiv .getColumnCount();
            DruidaConector estadoCivil         = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanyaEstCiv , colIDPestanyaEstCiv );
            asignar("COMBO","cbEstadoCivil", estadoCivil, "DTOSalida.resultado_ROWSET");
           
            /***********Lleno el combo de nivel estudios*******/
            RecordSet rsPestanyaNivEst         = (RecordSet)dtoDatosPestanya2.getNivelEstudios();
           
            Vector colIDPestanyaNivEst         = rsPestanyaNivEst.getColumnIdentifiers();
            int numColPestanyaNivEst           = rsPestanyaNivEst .getColumnCount();
            DruidaConector nivelEstudios       = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanyaNivEst, colIDPestanyaNivEst );
            asignar("COMBO","cbNivelEstudios", nivelEstudios, "DTOSalida.resultado_ROWSET");
           
            /********Lleno el combo de nivel socioeconomico****/
            RecordSet rsPestanyaNivSoc         = (RecordSet)dtoDatosPestanya2.getNSEP();
           
            Vector colIDPestanyaNivSoc         = rsPestanyaNivSoc.getColumnIdentifiers();
            int numColPestanyaNivSoc           = rsPestanyaNivSoc .getColumnCount();
            DruidaConector nivelSocioEconomico = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanyaNivSoc, colIDPestanyaNivSoc);
            asignar("COMBO","cbNivelSocioEconomico", nivelSocioEconomico, "DTOSalida.resultado_ROWSET");
                 
            /********Lleno el combo de ciclo de vida familiar******/
            RecordSet rsPestanyaCicVida        = (RecordSet)dtoDatosPestanya2.getCiclosVida();
          
            Vector colIDPestanyaCicVida        = rsPestanyaCicVida.getColumnIdentifiers();
            int numColPestanyaCicVida          = rsPestanyaCicVida .getColumnCount();
            DruidaConector cicloVidaFamiliar   = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanyaCicVida, colIDPestanyaCicVida);
            asignar("COMBO","cbCicloVidaFamiliar", cicloVidaFamiliar, "DTOSalida.resultado_ROWSET");
          
            /********Lleno el combo de pais vinculo y pais contactado*******/
            RecordSet rsPestanyaPaisVin        = (RecordSet)dtoDatosPestanya2.getPaises();
            Vector colIDPestanyaPaisVin        = rsPestanyaPaisVin.getColumnIdentifiers();
            int numColPestanyaPaisVin          = rsPestanyaPaisVin.getColumnCount();
            DruidaConector paisVinculo         = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanyaPaisVin, colIDPestanyaPaisVin);
            //asignar("COMBO","cbPaisVinculo", paisVinculo, "DTOSalida.resultado_ROWSET");
            //asignar("COMBO","cbPaisContactado", paisVinculo, "DTOSalida.resultado_ROWSET");

            /********Lleno el combo de Tipo vinculo **********/
            RecordSet rsPestanyaTipoVin        = (RecordSet)dtoDatosPestanya2.getTiposVinculo();
            if(rsPestanyaTipoVin != null){
				Vector colIDPestanyaTipoVin        = rsPestanyaTipoVin.getColumnIdentifiers();
				int numColPestanyaTipoVin          = rsPestanyaTipoVin.getColumnCount();
				DruidaConector tiposVinculo        = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanyaTipoVin, colIDPestanyaTipoVin);
				asignar("COMBO","cbTipoVinculo", tiposVinculo, "DTOSalida.resultado_ROWSET");
            }
            /********Lleno el combo de Tipo Preferencias **********/
            RecordSet rsPestanyaTipoPref       = (RecordSet)dtoDatosPestanya2.getTiposPreferencias();
            if(rsPestanyaTipoPref != null){
				Vector colIDPestanyaTipoPref       = rsPestanyaTipoPref.getColumnIdentifiers();
				int numColPestanyaTipoPref         = rsPestanyaTipoPref.getColumnCount();
				DruidaConector tiposPreferencias   = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanyaTipoPref, colIDPestanyaTipoPref);
				asignar("COMBO","cb", tiposPreferencias, "DTOSalida.resultado_ROWSET");
            }
            /********Lleno el combo de Tipo Cliente **********/
            RecordSet rsPestanyaTipoCli        = (RecordSet)dtoDatosPestanya2.getTipoCliente();
            if(rsPestanyaTipoCli != null){
            Vector colIDPestanyaTipoCli        = rsPestanyaTipoCli.getColumnIdentifiers();
            int numColPestanyaTipoCli          = rsPestanyaTipoCli.getColumnCount();
            DruidaConector tiposCliente        = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanyaTipoCli, colIDPestanyaTipoCli);
            asignar("COMBO","cbTipoClienteContactado", tiposCliente, "DTOSalida.resultado_ROWSET");

            /********Lleno el combo de Marca Contacto **********/
            RecordSet rsMarcaContacto = dtoDatosPestanya2.getMarcas();
            if ( rsMarcaContacto != null){
              traza("rsMarcaContacto: " + rsMarcaContacto);
              //UtilidadesBelcorp.agregarRegistroVacio(rsMarcaContacto, 0);              
              DruidaConector con = UtilidadesBelcorp.generarConector("marcasCombo", rsMarcaContacto, rsMarcaContacto.getColumnIdentifiers() );
              this.asignar("COMBO", "cbMarca", con, "marcasCombo");
            }

            RecordSet rsCanalContacto = dtoDatosPestanya2.getCanales();
            if ( rsCanalContacto != null) {
              //traza("rsCanalContacto: " + rsCanalContacto);
              //UtilidadesBelcorp.agregarRegistroVacio(rsCanalContacto, 0);
              DruidaConector con = UtilidadesBelcorp.generarConector("canalCombo", rsCanalContacto, rsCanalContacto.getColumnIdentifiers() );
              this.asignar("COMBO", "cbCanal", con, "canalCombo");                      
            }            
              
              

      			/************ Asigno Formato de Fecha de Sesion para validacion *************/
            String formatoFecha = UtilidadesSession.getFormatoFecha(this);
            asignarAtributo("VAR", "hFormatoFechaPais", "valor", formatoFecha);

            }
         }

         else if(accion.equals("siguientePestanya3")){

          /*-FALTAGuardamos en campos ocultos los parametros que vienen de las pestañas anteriores 
              OK-idBusiness="MAEPestanya3Busqueda" 
              OK-Llamamos a ConectorPestanyaBusqueda3 con un DTOBelcorp (con el pais y el idioma) 
              OK-con los atributos del DTOPestanya3 cargamos los combos correspondientes con las siguientes 
              excepciones: 
              ignoramos los atributos oidClientesVinculo, oidClienteContacto, niveles, tiposClasificacion, 
              clasificaciones y canales si el atributo usaGeoreferenciador es true, entonces ocultamos los 
              combos via y tipoVia */ 
            this.leeHiddens();
            
      
            pagina("contenido_grupo3_buscar");
            getConfiguracionMenu("LPBusquedaCliente", "siguientePestanya3");
            if ( casoDeUso.equals("modificar") )
              this.asignarAtributoPagina("cod", "0409");
            else if (casoDeUso.equals("Cambiar Estatus") || casoDeUso.equals("cambiar") )
              asignarAtributoPagina("cod", "0344");
            else if (casoDeUso.equals("consultar") )
              asignarAtributoPagina("cod","0410");
            
      			asignarCasoUso();
            this.seteaHiddens();
                       
            Vector paramEntradaGrupo3 = new Vector();
            
            MareBusinessID idGrupo3 = new MareBusinessID("MAEPestanya3Busqueda");
            DruidaConector conectorGrupo3 = new DruidaConector();
            DTOBelcorp dtoGrupo3 = new DTOBelcorp();
            
            dtoGrupo3.setOidPais(pais);
            dtoGrupo3.setOidIdioma(idioma);

            paramEntradaGrupo3.add(dtoGrupo3);            
            paramEntradaGrupo3.add(idGrupo3);
            conectorGrupo3 = conectar("ConectorPestanyaBusqueda3",paramEntradaGrupo3);
                 
            DTOPestanya3     dtoDatosPestanya3     = (DTOPestanya3) conectorGrupo3.objeto("DTOSalida");
            //traza("dtoDatosPestanya3: " + dtoDatosPestanya3.toString() );
            DTOPestanya3Base dtoDatosPestanya3Base = dtoDatosPestanya3.getBase();
            //traza("dtoPestanya3Base: " + dtoDatosPestanya3Base.toString() );

            /*si el atributo usaGeoreferenciador es true, entonces ocultamos los combos via y tipoVia*/

            Boolean blUsaGeoreferenciador = dtoDatosPestanya3Base.getUsaGeoreferenciador();
                   
            if(blUsaGeoreferenciador == null){
              blUsaGeoreferenciador = new Boolean(false);
               //blUsaGeoreferenciador.FALSE.booleanValue();
            }
            
            traza("bolean:" + blUsaGeoreferenciador);
            if(blUsaGeoreferenciador.booleanValue())
            {
               asignarAtributo("CAPA", "capaTextNombreVia", "visibilidad", "visible");
               asignarAtributo("CAPA", "capaLblNombreVia", "visibilidad", "visible");
               asignarAtributo("CAPA", "capaLblVia", "visibilidad", "hidden");
               asignarAtributo("CAPA", "capaCbVia", "visibilidad", "hidden");               

            } else
            {
               asignarAtributo("CAPA", "capaTextNombreVia", "visibilidad", "hidden");
               asignarAtributo("CAPA", "capaLblNombreVia", "visibilidad", "hidden");
               asignarAtributo("CAPA", "capaLblVia", "visibilidad", "visible");
               asignarAtributo("CAPA", "capaCbVia", "visibilidad", "visible");               
               asignarAtributo("VAR", "geoReferenciador", "valor", "N");
               asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getIdioma(this).toString() );
            }
                       
            /**********Lleno el combo Tipo Direccion***********/
            RecordSet rsPestanya3TipoDir     = (RecordSet)dtoDatosPestanya3Base.getTiposDirecciones();
            if(rsPestanya3TipoDir != null){
		        Vector colIDPestanya3TipoDir     = rsPestanya3TipoDir.getColumnIdentifiers();
			    int numColPestanya3TipoDir       = rsPestanya3TipoDir.getColumnCount();
	            //traza(rsPestanya3TipoDir.toString());
		        DruidaConector tiposDirecciones  = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya3TipoDir, colIDPestanya3TipoDir);
			    asignar("COMBO","cbTipoDireccion", tiposDirecciones, "DTOSalida.resultado_ROWSET");
            }
            /**********Lleno el combo Tipo Via***************/
            RecordSet rsPestanya3TipoVia     = (RecordSet)dtoDatosPestanya3Base.getTipoVia();
            if(rsPestanya3TipoVia != null){
			    Vector colIDPestanya3TipoVia     = rsPestanya3TipoVia.getColumnIdentifiers();
	            int numColPestanya3TipoVia       = rsPestanya3TipoVia.getColumnCount();
				DruidaConector tipoVia           = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya3TipoVia, colIDPestanya3TipoVia);
			    asignar("COMBO","cbTipoVia", tipoVia, "DTOSalida.resultado_ROWSET");
            }
            /**********Lleno el combo Marca***************/
            RecordSet rsPestanya3Marca       = (RecordSet)dtoDatosPestanya3Base.getMarcas();
            if(rsPestanya3Marca != null){
				Vector colIDPestanya3Marca       = rsPestanya3Marca.getColumnIdentifiers();
				int numColPestanya3Marca         = rsPestanya3Marca.getColumnCount();
				DruidaConector marca             = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya3Marca, colIDPestanya3Marca);
				asignar("COMBO","cbMarca", marca, "DTOSalida.resultado_ROWSET");
            }
            /*******Lleno el combo Tipo COmunicacion********/
            RecordSet rsPestanya3TipoCom     = (RecordSet)dtoDatosPestanya3.getTiposComunicacion();
            if(rsPestanya3TipoCom != null){
				Vector colIDPestanya3TipoCom     = rsPestanya3TipoCom.getColumnIdentifiers();
				int numColPestanya3TipoCom       = rsPestanya3TipoCom.getColumnCount();
				DruidaConector tiposComunicacion = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya3TipoCom, colIDPestanya3TipoCom);
				asignar("COMBO","cbTipoComunicacion", tiposComunicacion, "DTOSalida.resultado_ROWSET");
			}
            
         }

         else if(accion.equals("siguientePestanya4")){
         traza("paso por pestaña 4");

          /*FALTA-Guardamos en campos ocultos los parametros que vienen de las pestañas anteriores 
             OK-idBusiness="MAEPestanya4Busqueda" 
             OK-Llamamos al ConectorPestanyaBusqueda4 con un DTOBelcorp (con el pais y el idioma) 
             -Con los recordset obtenidos en el DTOPestanya4 rellenamos los combos correspondientes; 
             salvo el combo clasicaciones, que lo guardamos en un array Javascript para poder recargarlo 
             dinamicamente. Dicho array tendrá tres columnas: oid, descripcion y tipoClasificacion 
             (para poder filtrar por el tipo).*/ 
             
            this.leeHiddens();
            
      
            pagina("contenido_grupo4_buscar");
            getConfiguracionMenu("LPBusquedaCliente", "siguientePestanya4");
            if ( casoDeUso.equals("modificar") )
              this.asignarAtributoPagina("cod", "0409");
            else if (casoDeUso.equals("Cambiar Estatus") || casoDeUso.equals("cambiar") )
              asignarAtributoPagina("cod", "0344");
            else if (casoDeUso.equals("consultar") )
              asignarAtributoPagina("cod","0410");
              
      			asignarCasoUso();
            this.seteaHiddens();


            Vector paramEntradaGrupo4 = new Vector();

            MareBusinessID idGrupo4 = new MareBusinessID("MAEPestanya4Busqueda");
            DruidaConector conectorGrupo4 = new DruidaConector();
            DTOBelcorp dtoGrupo4 = new DTOBelcorp();

            dtoGrupo4.setOidPais(pais);
            dtoGrupo4.setOidIdioma(idioma);

            paramEntradaGrupo4.add(dtoGrupo4);            
            paramEntradaGrupo4.add(idGrupo4);

            //traza("antes conector");         
            conectorGrupo4 = conectar("ConectorPestanyaBusqueda4",paramEntradaGrupo4);
            //traza("antes casteo");

            

            DTOPestanya4  dtoDatosPestanya4   = (DTOPestanya4) conectorGrupo4.objeto("DTOSalida");

            /*******Lleno el combo Tipo Tarjeta**********/
            RecordSet rsPestanya4TipoTarj     = (RecordSet)dtoDatosPestanya4.getTiposTarjeta();
            if(rsPestanya4TipoTarj != null){
				Vector colIDPestanya4TipoTarj     = rsPestanya4TipoTarj.getColumnIdentifiers();
				int numColPestanya4TipoTarj       = rsPestanya4TipoTarj.getColumnCount();
				DruidaConector tiposTarjeta       = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya4TipoTarj, colIDPestanya4TipoTarj);
				asignar("COMBO","cbTipoTarjeta", tiposTarjeta, "DTOSalida.resultado_ROWSET");
            }
             /*******Lleno el combo Clases Tarjeta**********/
            RecordSet rsPestanya4ClaseTarj      = (RecordSet)dtoDatosPestanya4.getClasesTarjeta();
            if(rsPestanya4ClaseTarj != null){
				Vector colIDPestanya4ClaseTarj      = rsPestanya4ClaseTarj.getColumnIdentifiers();
				int numColPestanya4ClaseTarj        = rsPestanya4ClaseTarj.getColumnCount();
				DruidaConector clasesTarjeta        = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya4ClaseTarj, colIDPestanya4ClaseTarj);
				asignar("COMBO","cbClasesTarjeta",clasesTarjeta, "DTOSalida.resultado_ROWSET");
            }
            
            /*******Lleno el combo Entidad Bancaria**********/
            RecordSet rsPestanya4Banco          = (RecordSet)dtoDatosPestanya4.getBancos();
            if(rsPestanya4Banco != null){
				Vector colIDPestanya4Banco          = rsPestanya4Banco.getColumnIdentifiers();
				int numColPestanya4Banco            = rsPestanya4Banco.getColumnCount();
				DruidaConector entidadesBancarias   = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya4Banco, colIDPestanya4Banco);
				asignar("COMBO","cbEntidadBancaria",entidadesBancarias, "DTOSalida.resultado_ROWSET");
            }
            /*******Lleno el combo Marcas *****************/
            RecordSet rsPestanya4Marca          = (RecordSet)dtoDatosPestanya4.getMarcas();
            //traza("RecordSet Marcas: " + rsPestanya4Marca.toString() );
            if(rsPestanya4Marca != null){
              Vector colIDPestanya4Marca          = rsPestanya4Marca.getColumnIdentifiers();
              int numColPestanya4Marca            = rsPestanya4Marca.getColumnCount();
              DruidaConector marcas               = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya4Marca, colIDPestanya4Marca);
              asignar("COMBO","cbMarca",marcas, "DTOSalida.resultado_ROWSET");
            }
            /*******Lleno el combo Canal *****************/
            RecordSet rsPestanya4Canal          = (RecordSet)dtoDatosPestanya4.getCanales();
            //traza("recordSet canales: " + rsPestanya4Canal.toString() );
            if(rsPestanya4Canal != null){
				Vector colIDPestanya4Canal          = rsPestanya4Canal.getColumnIdentifiers();
				int numColPestanya4Canal            = rsPestanya4Canal.getColumnCount();
				DruidaConector canales              = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya4Canal, colIDPestanya4Canal);
				asignar("COMBO","cbCanal",canales, "DTOSalida.resultado_ROWSET");
            }

             UtilidadesBelcorp utilidadesBelcorp = new UtilidadesBelcorp();
            /********************Carga de tipo y subtipo******************************/
              // Parsea elem para obtener RecordSet tipos y subtipos, y array de oid Subtipo
              
            Vector v = this.obtieneTipos(hidTipoSubtipo);
            //traza("el tipo subtipo es " + hidTipoSubtipo);
            RecordSet rTipos = (RecordSet) v.get(0);
            RecordSet rSubTipos = (RecordSet) v.get(1);
            Long[] oidSubtipos = (Long[]) v.get(2);

            //traza("rTipos: " +rTipos);
            //traza("rSubTipos: " + rSubTipos);

            //  Asigna el RecordSet rTipos al combo de la pagina.
            DruidaConector conTipoCliente = UtilidadesBelcorp.generarConector("tiposCliente", rTipos, rTipos.getColumnIdentifiers() );
            this.asignar("COMBO", "cbTipoCliente", conTipoCliente, "tiposCliente");

            DruidaConector conSubtipoCliente = UtilidadesBelcorp.generarConector("subtiposCliente", rSubTipos, rSubTipos.getColumnIdentifiers() );

            this.asignar("LISTADOA", "listaSubtipos", conSubtipoCliente, "subtiposCliente");

            /*for (int u = 0; u < oidSubtipos.length; u++) {
                traza("oidSubtipos[" + u + "]=" + oidSubtipos[u]);
            }*/

            

            /**************************************************/
            Vector colID = new Vector();
            DruidaConector dtipo = new DruidaConector();

             // TipoClasificacion
            RecordSet tiposClasi = dtoDatosPestanya4.getTiposClasificacion();
            utilidadesBelcorp.agregarRegistroVacio(tiposClasi, 0);
            colID = tiposClasi.getColumnIdentifiers();
            dtipo = this.generarConector("DTOSalida.tiposClasificacion_ROWSET", tiposClasi, colID);
            this.crearListaLP(colID, tiposClasi.getColumnCount(), "Capa2", "ListaTipoClasi", "14", "200");
            asignar("LISTA", "ListaTipoClasi", dtipo, "DTOSalida.tiposClasificacion_ROWSET");
            //asignar("COMBO", "comboTipoClasificacion", dtipo, "DTOSalida.tiposClasificacion_ROWSET");


            // Clasificaciones
            RecordSet clasi = dtoDatosPestanya4.getClasificaciones();
            utilidadesBelcorp.agregarRegistroVacio(clasi, 0);
            colID = clasi.getColumnIdentifiers();
            dtipo = this.generarConector("DTOSalida.clasificaciones_ROWSET", clasi, colID);
            this.crearListaLP(colID, clasi.getColumnCount(), "Capa1", "Lista1", "14", "200");
            asignar("LISTA", "Lista1", dtipo, "DTOSalida.clasificaciones_ROWSET");



            

            /***************************************************/
            
            /*****Lleno el combo Tipo Clasificacion******/
            /*RecordSet rsPestanya4TipoCla        = (RecordSet)dtoDatosPestanya4.getTiposClasificacion();
            if (rsPestanya4TipoCla == null || rsPestanya4TipoCla.getRowCount() == 0)
            {
               traza("Tipo de clasificacion esta vacio");              
            } else
            {
               traza("RecordSet Tipo Clasificacion: " + rsPestanya4TipoCla.toString() );
               RecordSet r = new RecordSet();
               Vector colsId = new Vector();
               colsId.add(new String("Oid"));
               colsId.add(new String("Desc"));
               
               r.setColumnIdentifiers(colsId);
               Vector vBuffer = new Vector();
               
               for (int i = 0; i<rsPestanya4TipoCla.getRowCount(); i++)
               {
                   vBuffer = new Vector();
                   vBuffer.add(rsPestanya4TipoCla.getValueAt(i,0));  // OID 
                   vBuffer.add(rsPestanya4TipoCla.getValueAt(i,2));  // Descripcion.
                   r.addRow(vBuffer);
               }
               traza("Nuevo RecordSet: " + r.toString() );

               //Vector colIDPestanya4TipoCla = rsPestanya4TipoCla.getColumnIdentifiers();               
               Vector colIDPestanya4TipoCla = r.getColumnIdentifiers();               
               traza("colIdentifiers: " + colIDPestanya4TipoCla.toString() );

               //DruidaConector tiposClasificaciones = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya4TipoCla, colIDPestanya4TipoCla);
               DruidaConector tiposClasificaciones = this.generarConector("DTOSalida.resultado_ROWSET",r, colIDPestanya4TipoCla);
               asignar("COMBO", "cbTipoClasificacion", tiposClasificaciones, "DTOSalida.resultado_ROWSET");
               traza("Seteo COMBO Tipo Clasificacion!!!!");
            }*/
           
            /*****Lleno la variable con Clasificacion******/
           /* RecordSet rsPestanya4Cla        = (RecordSet)dtoDatosPestanya4.getClasificaciones();
            if(rsPestanya4Cla == null || rsPestanya4Cla.getRowCount() == 0 )
            {
              traza("clasificacion esta vacio");
            }
            else
            {
                traza("RecordSet Clasificaciones: " + rsPestanya4Cla.toString() );
                Vector fila = null;
                int longitud = rsPestanya4Cla.getRowCount();
                StringBuffer oids = new StringBuffer();
                StringBuffer desc = new StringBuffer();
                StringBuffer tipoClas = new StringBuffer();
                
                BigDecimal big = null;
                for (int i = 0; i < longitud; i++)
                {
                    fila = rsPestanya4Cla.getRow(i);
                    traza("Obtengo oid");
                    big = (BigDecimal) fila.get(0); 
                    oids.append( big.toString() );
                    
                    traza("Obtengo el tipo de clasificacion");
                    big = (BigDecimal) fila.get(1);
                    tipoClas.append(big.toString());

                    traza("Obtendo desc");
                    desc.append( (String) fila.get(2) );

                    traza("fila " + i + ": " + fila.toString() );
                    if (i != (longitud-1) ) 
                    {
                        oids.append(",");
                        desc.append(",");
                        tipoClas.append(",");
                    }
                }
                traza("oids: " + oids.toString() );
                traza("desc: " + desc.toString() );
                traza("tipoClas: " + tipoClas.toString() );
                asignarAtributo("VAR", "clasOid", "valor", oids.toString());
                asignarAtributo("VAR", "clasDesc", "valor", desc.toString());
                asignarAtributo("VAR", "clasTipoClas", "valor", tipoClas.toString());

            }*/
            
            /*******Lleno el combo Tipo Problema***********/
            RecordSet rsPestanya4TipoProb       = (RecordSet)dtoDatosPestanya4.getTiposProblema();
            if(rsPestanya4TipoProb != null){
				Vector colIDPestanya4TipoProb       = rsPestanya4TipoProb.getColumnIdentifiers();
				int numColPestanya4TipoProb         = rsPestanya4TipoProb.getColumnCount();
				DruidaConector tiposProblema = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya4TipoProb, colIDPestanya4TipoProb);
				asignar("COMBO","cbTipoProblema",tiposProblema, "DTOSalida.resultado_ROWSET");
			}
            /*******Lleno el combo Tipo Solucion********/
            RecordSet rsPestanya4TipoSol       = (RecordSet)dtoDatosPestanya4.getTiposSolucion();
            if(rsPestanya4TipoSol != null){
				Vector colIDPestanya4TipoSol       = rsPestanya4TipoSol.getColumnIdentifiers();
				int numColPestanya4TipoSol         = rsPestanya4TipoSol.getColumnCount();
				DruidaConector tiposSolucion      = this.generarConector("DTOSalida.resultado_ROWSET",rsPestanya4TipoSol, colIDPestanya4TipoSol);
				asignar("COMBO","cbTipoSolucion",tiposSolucion, "DTOSalida.resultado_ROWSET");
			}

        }

        else if (accion.equals("buscar")){ 

            this.leeHiddens();
            pagina("salidaGenerica");            
            String cadenaParams = this.generarCadenaParametros();
            //traza("Resultados");

            boolean hayRegistros = this.checkResultado(cadenaParams);
            if (hayRegistros)
            {
                asignarAtributo("VAR", "ejecutar", "valor", "hayRegistros('" + cadenaParams + "')");
            } else
            {
                asignarAtributo("VAR", "ejecutar", "valor", "noHayRegistros()");              
            }

        }

        else if (accion.equals("buscarPagina"))
        {
              this.leeHiddens();
			  String sCadenaParams = this.conectorParametroLimpia("hCadenaParams", "", true);
              pagina("contenido_clientes_resultados_buscar");
			  traza("sCadenaParams: " + sCadenaParams);
			  this.asignarAtributo("VAR", "hidCadenaParametros", "valor", sCadenaParams);

			  traza("	seteaHiddens...");				
              this.seteaHiddens();
              //traza("Nueva pag: contenido_clientes_resultados_buscar");
              
			  traza("	Recordset....");
			  RecordSet r = (RecordSet) 
                              this.conectorParametroSesion("rResultadoConsultaClientes");
			  traza("	Recordset= " + r.toString());	  
			
              traza("	DruidaConector");
			  DruidaConector conLista = UtilidadesBelcorp.generarConector("conLista", 
                                                                          r, 
                                                                          r.getColumnIdentifiers());
			  asignarAtributo("PAGINADO", "mypgndo", "conector", "ConectorTransactionBuscarCliente");
			  /* asignarAtributo("PAGINADO", "mypgndo", "control", "0|" + sCadenaParams);*/
			  asignarAtributo("PAGINADO", "mypgndo", "rowset", "dtoSalida.resultado");

			  traza("	hace el asignar con ... " + conLista.toString());
              this.asignar("LISTADOA", "listado1", conLista, "conLista");
        	  
			  traza("	asigna el c.u.=" + casoDeUso);
              asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
              getConfiguracionMenu("LPBusquedaCliente", "buscar");

              if ( casoDeUso.equals("modificar") ) {
                this.asignarAtributoPagina("cod", "0409");
              } else if (casoDeUso.equals("Cambiar Estatus") || casoDeUso.equals("cambiar") ) {
                asignarAtributoPagina("cod", "0344");
              } else if (casoDeUso.equals("consultar") ) {
                asignarAtributoPagina("cod","0410");
              }
              
              //asignarAtributo("VAR", "hidCadenaParametros", "valor", cadenaParams);
        }

       else  if(accion.equals("consultar"))
        {
            traza("Entro a consultar");        
            String codigoOid = (String)conectorParametro("dtoOid");  // Oid de Cliente para consultar. 
            traza("Valor de		 " + codigoOid);
            
            Vector paramEntradaConsulta     = new Vector();
            MareBusinessID idConsulta       = new MareBusinessID("MAEConsularCliente");
            DruidaConector conectorConsulta = new DruidaConector();
            //Creamos un DTOOID que recibimos como parametro, además metemos el idioma y pais. 
            DTOOID dtoID                    = new DTOOID();
		
            dtoID.setOidPais(pais);
            dtoID.setOidIdioma(idioma);
            dtoID.setOid(new Long(codigoOid));
            
            paramEntradaConsulta.add(dtoID);            
            paramEntradaConsulta.add(idConsulta);
            

            conectorConsulta = conectar("ConectorConsultaCliente",paramEntradaConsulta);

            
            DTOConsultaCliente dtoDatos = (DTOConsultaCliente) conectorConsulta.objeto("dtoSalida");
            //traza("dtoDatos: " + dtoDatos.toString() );            
            
            // Agregado por ssantana, 03/11/2005, BELC300021214
            this.conectorParametroSesion("ConsultarClientesDTODetalle", dtoDatos);
            this.conectorAction("LPDetalleCliente");
            this.conectorActionParametro("accion", "pestanya0");
            // Fin Agregado por ssantana, 03/11/2005
            
        }
        else if(accion.equals("desactivar")){
		
            leeHiddens();
            

			//SICC-DMCO-MAE-GCC-006 - Cleal
			DTOClienteIndicador dTOClieInd = new DTOClienteIndicador();
			
            String codigosSelec = this.conectorParametroLimpia("hidCodigosStatus","",true);
			String indActiSelec = this.conectorParametroLimpia("hidIndActivo","",true);
            String sToken = "";
			String sTokenInd = "";

            StringTokenizer tok = new StringTokenizer(codigosSelec, ",");
            Long[] oids = new Long[tok.countTokens()];
			//traza("Nro de OIDs: "+tok.countTokens());

			StringTokenizer tokind = new StringTokenizer(indActiSelec, ",");
			Long[] indicadores = new Long[tokind.countTokens()];
			String indicador = "";
			//traza("Nro de Indicadores: "+tokind.countTokens());			

            int i = 0;
            while (tok.hasMoreTokens())
            {
                sToken = tok.nextToken();
				sTokenInd = tokind.nextToken();
				//traza("Token desactivar OID: "+sToken);
				//traza("Token desactivar IndActi: "+sTokenInd);
                oids[i] = new Long(sToken);


				if(sTokenInd.equalsIgnoreCase("Si")){
					indicador = "1";
				} else {
					indicador = "0";
				}

				indicadores[i] = new Long(indicador);
				i++;
            }

			      //traza("Estoy en 2");
            MareBusinessID bussID = new MareBusinessID("MAEDesactivarCliente");
			      //traza("Estoy en 3");
            DTOOIDs dtoOids = new DTOOIDs();
            dtoOids.setOids(oids);
			dTOClieInd.setOidindicadores(dtoOids);
//			dTOClieInd.setOidindicadores(oids);
			dTOClieInd.setIndicadores(indicadores);

            Vector params = new Vector();
            params.add(dTOClieInd);
			//params.add(oids);
            params.add(bussID);
			//traza("Antes del conector");
            DruidaConector con = this.conectar("ConectorEliminar", params);

			      conectorAction("LPBusquedaCambiarStatus");
            setearParametros();
            
            

        }
                
      }

      catch (Exception ex) 
      {
         traza("Exception: " + ex);
         StringWriter sw = new StringWriter();
			   PrintWriter pw = new PrintWriter(sw);
			   ex.printStackTrace(pw);
			   traza("------\r\n" + sw.toString() + "------\r\n");
			   this.lanzarPaginaError(ex);
      }
      //menu secundario
       //getConfiguracionMenu();

      
   }

   
   private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns)
		throws DOMException,Exception
	{
    
		traza("en 'generarConector'... ");

		traza("rowsetID = " +rowsetID);
		traza("datos = " + datos.toString());
		traza("columns = " + columns.toString());

		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();

		if ( columns == null ){
			columns = new Vector();
		}

		Vector columsDesc = datos.getColumnIdentifiers();		
		//traza("datos de generar conector:" + datos);
		DruidaConector conectorValoresPosibles = new DruidaConector();				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		
		traza("antes del for()...");
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
					
					if( datos.getValueAt(i,j) != null ){
						traza("	------------->	datos.getValueAt(i,j).toString() =" + datos.getValueAt(i,j).toString());
					}
					Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					
					e_campo2.appendChild(txt);
					e_row.appendChild(e_campo2);
				}
			}
		}	
		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		
		traza("sale de 'generarConector' !");
		return conectorValoresPosibles;
	}


  private void leeHiddens() throws Exception
  {
        traza("--- Lee Hiddens ---");

        //traza("Criterios Búsqueda");
          hidCriterioBusqueda1   = conectorParametroLimpia("hidCriterioBusqueda1", "", true);
          //traza("hidCriterioBusqueda1: " + hidCriterioBusqueda1);
          hidCriterioBusqueda2   = conectorParametroLimpia("hidCriterioBusqueda2", "", true);        
          //traza("hidCriterioBusqueda2: " + hidCriterioBusqueda2);

	      //traza("Tipo y subtipo");
          //traza("*** a ver " + conectorParametroLimpia("hidTipoSubtipo", "", true));
    			hidTipoSubtipo    = conectorParametroLimpia("hidTipoSubtipo", "", true);
          //traza("el tipo antes " + conectorParametroLimpia("hiddenTipoCliente", "", true));
          //traza("el subtipo antes " + conectorParametroLimpia("hiddenSubTipoCliente", "", true));
          hiddenTipoCliente = conectorParametroLimpia("hiddenTipoCliente", "", true);
          hiddenSubTipoCliente = conectorParametroLimpia("hiddenSubTipoCliente", "", true);
          //traza("*****************************el tipo de cliente es " + hiddenTipoCliente);
          //traza("*****************************el subtipo de cliente es " + hiddenSubTipoCliente);
      
          //traza("************hidTipoSubtipo: " + hidTipoSubtipo);
        	//hidSubTipo = conectorParametroLimpia("hidSubTipo", "", true);
          //traza("hidSubTipo: " + hidSubTipo );
		
        
        //traza("PrimeraPestana");
          hidtextCodCliente      = conectorParametroLimpia("hidtextCodCliente","",true);
          hidcbTipoDocId         = conectorParametroLimpia("hidcbTipoDocId","",true);
          hidtextNDocId          = conectorParametroLimpia("hidtextNDocId","",true);
          hidrbDocPrincipal      = conectorParametroLimpia("hidrbDocPrincipal","",true);
          hidcbPersonaCliente    = conectorParametroLimpia("hidcbPersonaCliente","",true);
		  //traza("leeHidens: "+conectorParametroLimpia("hidIndActivo","",true));
		  hidIndActi			 = conectorParametroLimpia("hidIndActivo","",true);
		  //traza("leeHidens - hidIndActi: "+hidIndActi);
            
        /**Campos segunda pestaña**/
        //traza("2daPestana");            
          hidtextApellido1              = conectorParametroLimpia("hidtextApellido1","",true);
          hidtextApellido2              = conectorParametroLimpia("hidtextApellido2","",true);
          hidtextApellidoCasada         = conectorParametroLimpia("hidtextApellidoCasada","",true);
          hidtextNombre1                = conectorParametroLimpia("hidtextNombre1","",true);
          hidtextNombre2                = conectorParametroLimpia("hidtextNombre2","",true);
          hidcbTratamiento              = conectorParametroLimpia("hidcbTratamiento","",true);
          hidrbSexo                     = conectorParametroLimpia("hidrbSexo","",true);
          hidcbFormaPago                = conectorParametroLimpia("hidcbFormaPago","",true);
          hidtextFechaNacimiento        = conectorParametroLimpia("hidtextFechaNacimiento","",true);
          hidtextCodEmpleado            = conectorParametroLimpia("hidtextCodEmpleado","",true); 
          hidcbNacionalidad             = conectorParametroLimpia("hidcbNacionalidad","",true);  
          hidcbEstadoCivil              = conectorParametroLimpia("hidcbEstadoCivil","",true);   
          hidtextOcupacion              = conectorParametroLimpia("hidtextOcupacion","",true);   
          hidtextProfesion              = conectorParametroLimpia("hidtextProfesion","",true);    
          hidtextCentroTrabajo          = conectorParametroLimpia("hidtextCentroTrabajo","",true);   
          hidtextCargoDesempena         = conectorParametroLimpia("hidtextCargoDesempena","",true);   
          hidcbNivelEstudios            = conectorParametroLimpia("hidcbNivelEstudios","",true);  
          hidtextCentroEstudios         = conectorParametroLimpia("hidtextCentroEstudios","",true);  
          hidtextNHijos                 = conectorParametroLimpia("hidtextNHijos","",true);  
          hidtextNPersonasDependientes  = conectorParametroLimpia("hidtextNPersonasDependientes","",true);  
          hidcbNivelSocioEconomico      = conectorParametroLimpia("hidcbNivelSocioEconomico","",true);  
          hidcbCicloVidaFamilia         = conectorParametroLimpia("hidcbCicloVidaFamilia","",true);  
          hidrbDeseaCorrespondencia     = conectorParametroLimpia("hidrbDeseaCorrespondencia","",true);  
          hidtextImporteIngresoFamiliar = conectorParametroLimpia("hidtextImporteIngresoFamiliar","",true);  
          hidcbPaisVinculo              = conectorParametroLimpia("hidcbPaisVinculo","",true);  
          hidtextClienteVinculo         = conectorParametroLimpia("hidtextClienteVinculo","",true);  
          hidcbTipoVinculo              = conectorParametroLimpia("hidcbTipoVinculo","",true);  
          hidtextFechaD                 = conectorParametroLimpia("hidtextFechaD","",true);  
          hidtextFechaH                 = conectorParametroLimpia("hidtextFechaH","",true);  
          hidrbVinculoPrincipal         = conectorParametroLimpia("hidrbVinculoPrincipal","",true);  
          hidcb                         = conectorParametroLimpia("hidcb","",true);  
          hidtextDescripcion            = conectorParametroLimpia("hidtextDescripcion","",true);  
          hidcbPaisContactado           = conectorParametroLimpia("hidcbPaisContactado","",true);  
          hidtextCodClienteContactado   = conectorParametroLimpia("hidtextCodClienteContactado","",true);  
          hidcbTipoClienteContactado    = conectorParametroLimpia("hidcbTipoClienteContactado","",true);  
          hidcbCodTipoContactado        = conectorParametroLimpia("hidcbCodTipoContactado","",true);  
          hidtextFechaContacto          = conectorParametroLimpia("hidtextFechaContacto","",true);  
          hidtextFecha1PedidoContacto   = conectorParametroLimpia("hidtextFecha1PedidoContacto","",true);   
          hidtextFechaSiguienteContacto = conectorParametroLimpia("hidtextFechaSiguienteContacto","",true);  
          hidtxtFechaIngresoActual      = conectorParametroLimpia("hidtxtFechaIngresoActual", "", true);
        //private String = new String("");          
          hidcbMarcaContacto      = conectorParametroLimpia("hidcbMarcaContacto", "", true);        
          //traza("lee, hidcbMarcaContacto: " + hidcbMarcaContacto);
          hidcbCanalContacto      = conectorParametroLimpia("hidcbCanalContacto", "", true);                  
          //traza("lee, hidcbCanalContacto: " + hidcbCanalContacto);
          hidcbPeriodoContacto    = conectorParametroLimpia("hidcbPeriodoPrimerPedido", "", true);                            
          //traza("lee, hidcbPeriodoContacto: " + hidcbPeriodoContacto);
          
        /**Campos tercera pestaña**/
        //traza("3raPestana");            
          hidcbTipoDireccion           = conectorParametroLimpia("hidcbTipoDireccion", "", true);
          //traza("Lee Hiddens - hidcbTipoDireccion: " + hidcbTipoDireccion);
          hidcbTipoVia                 = conectorParametroLimpia("hidcbTipoVia", "", true);
          hidtextNombreVia             = conectorParametroLimpia("hidtextNombreVia", "", true);
          hidtextNPrincipal            = conectorParametroLimpia("hidtextNPrincipal", "", true);
          hidtextCodPostal             = conectorParametroLimpia("hidtextCodPostal", "", true);
          /*hidtextInterior              = conectorParametroLimpia("hidtextInterior", "", true);
          hidtextManzana               = conectorParametroLimpia("hidtextManzana", "", true);
          hidtextLote                  = conectorParametroLimpia("hidtextLote", "", true);
          hidtextKm                    = conectorParametroLimpia("hidtextKm", "", true);*/
          hidrbDireccionPrincipal      = conectorParametroLimpia("hidrbDireccionPrincipal", "", true);
          hidtextObservaciones         = conectorParametroLimpia("hidtextObservaciones", "", true);
          hidcbTipoComunicacion        = conectorParametroLimpia("hidcbTipoComunicacion", "", true);
          hidcbDiaComunicacion         = conectorParametroLimpia("hidcbDiaComunicacion", "", true);
          hidrbComunicacionPrincipal   = conectorParametroLimpia("hidrbComunicacionPrincipal", "", true);
          hidtextHoraDesde             = conectorParametroLimpia("hidtextHoraDesde", "", true);
          hidtextHoraHasta             = conectorParametroLimpia("hidtextHoraHasta", "", true);
          hidcbIntervaloComunicacion   = conectorParametroLimpia("hidcbIntervaloComunicacion", "", true);
          hidtextTextoComunicacion     = conectorParametroLimpia("hidtextTextoComunicacion", "", true);
          hidcbMarca                   = conectorParametroLimpia("hidcbMarca", "", true);
          hidcbVia                     = conectorParametroLimpia("hidcbVia", "", true);
          hidTextVia                   = conectorParametroLimpia("hidTextVia", "", true);
          
        /**Campos cuarta pestaña**/
        //traza("cuarta pestaña");
          hidcbTipoTarjeta         =  conectorParametroLimpia("hidcbTipoTarjeta","", true);
          hidcbClasesTarjeta       =  conectorParametroLimpia("hidcbClasesTarjeta","", true);
          hidcbEntidadBancaria     = conectorParametroLimpia("hidcbEntidadBancaria", "", true);
          hidcbMarcaPestanya4      = conectorParametroLimpia("hidcbMarcaPestanya4", "", true);
          hidcbCanal               = conectorParametroLimpia("hidcbCanal", "", true);
          hidcbTipoClasificacion   = conectorParametroLimpia("hidcbTipoClasificacion", "", true);      
          hidcbTipoProblema        = conectorParametroLimpia("hidcbTipoProblema", "", true);            
          hidrbSolucion            = conectorParametroLimpia("hidrbSolucion", "", true);                  
          hidcbTipoSolucion        = conectorParametroLimpia("hidcbTipoSolucion", "", true);                        
          hidtextDescripcionProblema     = conectorParametroLimpia("hidtextDescripcionProblema", "", true);
          hidtextDescripcionSolucion     = conectorParametroLimpia("hidtextDescripcionSolucion", "", true);
          hidcbClasificacion     = conectorParametroLimpia("hidcbClasificacion", "", true);      
          hidtextNegocioProducto     = conectorParametroLimpia("hidtextNegocioProducto", "", true);      
          ListaComboClasificacion     = conectorParametroLimpia("ListaComboClasificacion", "", true);            

  }



  private void seteaHiddens() throws Exception
  {

	    traza("	entró en seteHiddens");
			
        /** Asignaciones Criterios de búsqueda **/
        asignarAtributo("VAR", "hidCriterioBusqueda1", "valor", hidCriterioBusqueda1);
        asignarAtributo("VAR", "hidCriterioBusqueda2", "valor", hidCriterioBusqueda2);        

        /**Asignaciones hiddens Tipo y Subtipo**/
    		asignarAtributo("VAR", "hidTipoSubtipo", "valor", hidTipoSubtipo);
        asignarAtributo("VAR","hiddenTipoCliente", "valor", hiddenTipoCliente);
        asignarAtributo("VAR","hiddenSubTipoCliente", "valor", hiddenSubTipoCliente);
	
        /**Asignaciones hiddens primera pestaña**/
        asignarAtributo("VAR", "hidtextCodCliente", "valor", hidtextCodCliente);
        asignarAtributo("VAR", "hidcbTipoDocId", "valor", hidcbTipoDocId);
        asignarAtributo("VAR", "hidtextNDocId", "valor", hidtextNDocId);
        asignarAtributo("VAR", "hidrbDocPrincipal", "valor", hidrbDocPrincipal);
        asignarAtributo("VAR", "hidcbPersonaCliente", "valor", hidcbPersonaCliente);
		asignarAtributo("VAR", "hidIndActivo", "valor", hidIndActi);
		

        /**Asignaciones hiddens segunda pestaña**/
		traza("	setea APELLIDO1= " + hidtextApellido1);
			
        asignarAtributo("VAR", "hidtextApellido1","valor",hidtextApellido1);
        asignarAtributo("VAR", "hidtextApellido2","valor",hidtextApellido2);
        asignarAtributo("VAR", "hidtextApellidoCasada","valor",hidtextApellidoCasada);
        asignarAtributo("VAR", "hidtextNombre1","valor",hidtextNombre1);
        asignarAtributo("VAR", "hidtextNombre2","valor",hidtextNombre2);
        asignarAtributo("VAR", "hidcbTratamiento","valor",hidcbTratamiento);
        asignarAtributo("VAR", "hidrbSexo","valor",hidrbSexo);
        asignarAtributo("VAR", "hidcbFormaPago","valor",hidcbFormaPago);
        asignarAtributo("VAR", "hidtextFechaNacimiento","valor",hidtextFechaNacimiento);
        asignarAtributo("VAR", "hidtextCodEmpleado","valor",hidtextCodEmpleado);
        asignarAtributo("VAR", "hidcbNacionalidad","valor",hidcbNacionalidad);
        asignarAtributo("VAR", "hidcbEstadoCivil","valor",hidcbEstadoCivil);
        asignarAtributo("VAR", "hidtextOcupacion","valor",hidtextOcupacion);
        asignarAtributo("VAR", "hidtextProfesion","valor",hidtextProfesion);
        asignarAtributo("VAR", "hidtextCentroTrabajo","valor",hidtextCentroTrabajo);
        asignarAtributo("VAR", "hidtextCargoDesempena","valor",hidtextCargoDesempena);
        asignarAtributo("VAR", "hidcbNivelEstudios","valor",hidcbNivelEstudios); 
        asignarAtributo("VAR", "hidtextCentroEstudios","valor",hidtextCentroEstudios);
        asignarAtributo("VAR", "hidtextNHijos","valor",hidtextNHijos);
        asignarAtributo("VAR", "hidtextNPersonasDependientes","valor",hidtextNPersonasDependientes);
        asignarAtributo("VAR", "hidcbNivelSocioEconomico","valor",hidcbNivelSocioEconomico);
        asignarAtributo("VAR", "hidcbCicloVidaFamilia","valor",hidcbCicloVidaFamilia);
        asignarAtributo("VAR", "hidrbDeseaCorrespondencia","valor",hidrbDeseaCorrespondencia);
        asignarAtributo("VAR", "hidtextImporteIngresoFamiliar","valor",hidtextImporteIngresoFamiliar);
        asignarAtributo("VAR", "hidcbPaisVinculo","valor",hidcbPaisVinculo);
        asignarAtributo("VAR", "hidtextClienteVinculo","valor",hidtextClienteVinculo);
        asignarAtributo("VAR", "hidcbTipoVinculo","valor",hidcbTipoVinculo);
        asignarAtributo("VAR", "hidtextFechaD","valor",hidtextFechaD);
        asignarAtributo("VAR", "hidtextFechaH","valor",hidtextFechaH);
        asignarAtributo("VAR", "hidrbVinculoPrincipal","valor",hidrbVinculoPrincipal);
        asignarAtributo("VAR", "hidcb","valor",hidcb);
        asignarAtributo("VAR", "hidtextDescripcion","valor",hidtextDescripcion);
        asignarAtributo("VAR", "hidcbPaisContactado","valor",hidcbPaisContactado);
        asignarAtributo("VAR", "hidtextCodClienteContactado","valor",hidtextCodClienteContactado);
        asignarAtributo("VAR", "hidcbTipoClienteContactado","valor",hidcbTipoClienteContactado);
        asignarAtributo("VAR", "hidcbCodTipoContactado","valor",hidcbCodTipoContactado);
        asignarAtributo("VAR", "hidtextFechaContacto","valor",hidtextFechaContacto);
        asignarAtributo("VAR", "hidtextFecha1PedidoContacto","valor",hidtextFecha1PedidoContacto);
        asignarAtributo("VAR", "hidtextFechaSiguienteContacto","valor",hidtextFechaSiguienteContacto);
        asignarAtributo("VAR", "hidtxtFechaIngresoActual","valor",hidtxtFechaIngresoActual);

        asignarAtributo("VAR", "hidcbMarcaContacto", "valor", hidcbMarcaContacto); 
        //traza("setea, hidcbMarcaContacto: " +hidcbMarcaContacto);
        asignarAtributo("VAR", "hidcbCanalContacto", "valor", hidcbCanalContacto);
        //traza("setea, hidcbCanalContacto: " +hidcbCanalContacto);        
        asignarAtributo("VAR", "hidcbPeriodoPrimerPedido", "valor", hidcbPeriodoContacto);        
        //traza("setea, hidcbPeriodoContacto: " +hidcbPeriodoContacto);        
         
        /**Asignaciones de la tercera pestaña**/
        //traza("hidTipoDireccion, Asignacion: " + hidcbTipoDireccion);
        asignarAtributo("VAR","hidcbTipoDireccion", "valor", hidcbTipoDireccion);
        asignarAtributo("VAR","hidcbTipoVia", "valor", hidcbTipoVia);
        asignarAtributo("VAR","hidtextNombreVia", "valor", hidtextNombreVia);
        asignarAtributo("VAR","hidtextNPrincipal", "valor", hidtextNPrincipal);
        asignarAtributo("VAR","hidtextCodPostal", "valor", hidtextCodPostal);
        /*asignarAtributo("VAR","hidtextInterior", "valor", hidtextInterior);
        asignarAtributo("VAR","hidtextManzana", "valor", hidtextManzana);
        asignarAtributo("VAR","hidtextLote", "valor", hidtextLote);
        asignarAtributo("VAR","hidtextKm", "valor", hidtextKm);*/
        asignarAtributo("VAR","hidrbDireccionPrincipal", "valor", hidrbDireccionPrincipal);
        asignarAtributo("VAR","hidtextObservaciones", "valor", hidtextObservaciones);
        asignarAtributo("VAR","hidcbTipoComunicacion", "valor", hidcbTipoComunicacion);
        asignarAtributo("VAR","hidcbDiaComunicacion", "valor", hidcbDiaComunicacion);
        asignarAtributo("VAR","hidrbComunicacionPrincipal", "valor", hidrbComunicacionPrincipal);
        asignarAtributo("VAR","hidtextHoraDesde", "valor", hidtextHoraDesde);
        asignarAtributo("VAR","hidtextHoraHasta", "valor", hidtextHoraHasta);
        asignarAtributo("VAR","hidcbIntervaloComunicacion", "valor", hidcbIntervaloComunicacion);
        asignarAtributo("VAR","hidtextTextoComunicacion", "valor", hidtextTextoComunicacion);
        asignarAtributo("VAR","hidcbMarca", "valor", hidcbMarca);
        asignarAtributo("VAR","hicbVia", "valor", hidcbVia);
        asignarAtributo("VAR","hidTextVia", "valor", hidTextVia);        
        

        /**Asignacion a cuarta pestaña**/        
        asignarAtributo("VAR","hidcbTipoTarjeta", "valor", hidcbTipoTarjeta);
        asignarAtributo("VAR","hidcbClasesTarjeta", "valor", hidcbClasesTarjeta);        
        asignarAtributo("VAR","hidcbEntidadBancaria", "valor", hidcbEntidadBancaria);
        asignarAtributo("VAR","hidcbMarcaPestanya4", "valor", hidcbMarcaPestanya4);                        
        asignarAtributo("VAR","hidcbCanal", "valor", hidcbCanal);
        asignarAtributo("VAR","hidcbTipoClasificacion", "valor", hidcbTipoClasificacion);
        asignarAtributo("VAR","hidcbTipoProblema", "valor", hidcbTipoProblema);
        asignarAtributo("VAR","hidrbSolucion", "valor", hidrbSolucion);        
        asignarAtributo("VAR","hidcbTipoSolucion", "valor", hidcbTipoSolucion);                
        asignarAtributo("VAR","hidtextDescripcionProblema", "valor", hidtextDescripcionProblema);        
        asignarAtributo("VAR","hidtextDescripcionSolucion", "valor", hidtextDescripcionSolucion);                
        asignarAtributo("VAR","hidcbClasificacion", "valor", hidcbClasificacion);                        
        asignarAtributo("VAR","hidtextNegocioProducto", "valor", hidtextNegocioProducto);                                
        asignarAtributo("VAR","ListaComboClasificacion", "valor", ListaComboClasificacion);                                        
    
  }

  private void setearParametros() throws Exception
  {
        traza("--- Setea parametros ---");

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
          /*conectorActionParametro("hidtextInterior",hidtextInterior);
          conectorActionParametro("hidtextManzana",hidtextManzana);
          conectorActionParametro("hidtextLote",hidtextLote);
          conectorActionParametro("hidtextKm",hidtextKm);*/
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



  private String generarCadenaParametros() throws Exception
  {
      StringBuffer cadena = new StringBuffer("");

	  //cadena = separator(cadena);
      // TipoSubtipo 
      if (hidTipoSubtipo != null && !hidTipoSubtipo.equals("") )
          cadena.append(hidTipoSubtipo);
	   else
		      cadena.append(DTBuscarCliente.TOKEN_VACIO);

	    cadena = separator(cadena);

  
      // Tipo Documento.
      if (hidcbTipoDocId != null && !hidcbTipoDocId.equals("") )
          cadena.append(hidcbTipoDocId);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // Documento Principal
      if (hidrbDocPrincipal != null && !hidrbDocPrincipal.equals("") )
      {
          if (hidrbDocPrincipal.equals("S") )
              cadena.append("1");
           else 
              cadena.append("0");
      } else
      {
          cadena.append(DTBuscarCliente.TOKEN_VACIO);
      }
      cadena = separator(cadena);

      // Numero de Documento.
      if (hidtextNDocId != null & !hidtextNDocId.equals("") ) 
          cadena.append(hidtextNDocId);
       else	
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // Persona Empresa
      if (hidcbPersonaCliente != null && !hidcbPersonaCliente.equals("") )
          cadena.append(hidcbPersonaCliente);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // Codigo Cliente
      if (hidtextCodCliente != null && !hidtextCodCliente.equals("") )
          cadena.append(hidtextCodCliente);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // ********* FIN CAMPOS PESTANYA 1 ****************

      // Apellido1
      if (hidtextApellido1 != null && !hidtextApellido1.equals("") )
          cadena.append(hidtextApellido1);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // Apellido2
      if (hidtextApellido2 != null && !hidtextApellido2.equals("") )
          cadena.append(hidtextApellido2);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // Apellido de Casada
      if (hidtextApellidoCasada != null && !hidtextApellidoCasada.equals("") )
          cadena.append(hidtextApellidoCasada);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // Nombre 1
      if (hidtextNombre1 != null && !hidtextNombre1.equals("") )
          cadena.append(hidtextNombre1);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);      

      // Nombre 2
      if (hidtextNombre2 != null && !hidtextNombre2.equals("") )
          cadena.append(hidtextNombre2);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);      

      // Tratamiento
      if (hidcbTratamiento != null && !hidcbTratamiento.equals("") )
          cadena.append(hidcbTratamiento);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);            

      // Sexo
      if (hidrbSexo != null && !hidrbSexo.equals("") )
      {
        if (hidrbSexo.equals("S") ) // Masculino
          cadena.append("M");
       else  // Femenino
          cadena.append("F");
      } else
      {
          cadena.append(DTBuscarCliente.TOKEN_VACIO);
      }

      cadena = separator(cadena);            

      // FechaIngreso
      if (hidtxtFechaIngresoActual != null && !hidtxtFechaIngresoActual.equals("") )
          cadena.append(hidtxtFechaIngresoActual);
       else  
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                  

      // Forma Pago
      if (hidcbFormaPago != null && !hidcbFormaPago.equals("") )
          cadena.append(hidcbFormaPago);
       else  
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);            

      // Tipo Direccion
      if (hidcbTipoDireccion != null && !hidcbTipoDireccion.equals("") )
          cadena.append(hidcbTipoDireccion);
       else  
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                  

      // Tipo Via
      if (hidcbTipoVia != null && !hidcbTipoVia.equals("") )
          cadena.append(hidcbTipoVia);
       else  
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                        

      // Via 
      if (hidtextNombreVia != null && !hidtextNombreVia.equals("") )
          cadena.append(hidtextNombreVia);
       else  
          cadena.append(DTBuscarCliente.TOKEN_VACIO);
          
      // Via
/*      if ( hidcbVia != null && !hidcbVia.equals("") )
          cadena.append(hidcbVia);
        else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);*/
        
      cadena = separator(cadena);                        

      // Numero Principal
      if (hidtextNPrincipal != null && !hidtextNPrincipal.equals("") )
          cadena.append(hidtextNPrincipal);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                        

      // Codigo Postal
      if (hidtextCodPostal != null && !hidtextCodPostal.equals("") )
          cadena.append(hidtextCodPostal);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                              

/*   SICC-GCC-MAE-005 - Cleal   
	 // Interior
      if (hidtextInterior != null && !hidtextInterior.equals("") )
          cadena.append(hidtextInterior);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);      

      // Manzana
      if (hidtextManzana != null && !hidtextManzana.equals("") )
          cadena.append(hidtextManzana);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);            

      // Lote 
      if (hidtextLote != null && !hidtextLote.equals("") )
          cadena.append(hidtextLote);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);  

      // Kilometro
      if (hidtextKm != null && !hidtextKm.equals("") )
          cadena.append(hidtextKm);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);        
*/
      // Observaciones
      if (hidtextObservaciones != null && !hidtextObservaciones.equals("") )
          cadena.append(hidtextObservaciones);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);              

      // Direccion Principal
      if (hidrbDireccionPrincipal != null && !hidrbDireccionPrincipal.equals("") )
      {
          if (hidrbDireccionPrincipal.equals("S")) 
            cadena.append("true");
         else
            cadena.append("false");
      } else
            cadena.append(DTBuscarCliente.TOKEN_VACIO);
 
      cadena = separator(cadena);   

      // Nombre Via 
      if (hidtextNombreVia != null && !hidtextNombreVia.equals("") )
          cadena.append(hidtextNombreVia);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);     

      // Marca
      if (hidcbMarca != null && !hidcbMarca.equals("") )
          cadena.append(hidcbMarca);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena); 

      // Marca Clasificacion
      if (hidcbMarcaPestanya4 != null && !hidcbMarcaPestanya4.equals("") )
          cadena.append(hidcbMarcaPestanya4);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);       

      // Canal Clasificacion
      if (hidcbCanal != null && !hidcbCanal.equals("") )
          cadena.append(hidcbCanal);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);       

      // Tipo Clasificacion
      if (hidcbTipoClasificacion != null && !hidcbTipoClasificacion.equals("") )
          cadena.append(hidcbTipoClasificacion);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);             

      // Clasificacion
      if (hidcbClasificacion != null && !hidcbClasificacion.equals("") )
          cadena.append(hidcbClasificacion);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);             
	  
	  //SICC-DMCO-MAE-GCC-006 - Cleal 
	  //indicadorActivo - hidIndActi es la variable oculta de la pagina de donde saco el valor del combo
	  if (hidIndActi != null && !hidIndActi.equals("") )
          cadena.append(hidIndActi);
	   else
		      cadena.append(DTBuscarCliente.TOKEN_VACIO);

	    cadena = separator(cadena);


      // Criterio Busqueda 1
      if (hidCriterioBusqueda1 != null && !hidCriterioBusqueda1.equals("") )
          cadena.append(hidCriterioBusqueda1);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                         

      // Criterio Busqueda 2
      if (hidCriterioBusqueda2 != null && !hidCriterioBusqueda2.equals("") )
          cadena.append(hidCriterioBusqueda2);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                               

      // Fecha Nacimiento
      if (hidtextFechaNacimiento != null && !hidtextFechaNacimiento.equals("") )
          cadena.append(hidtextFechaNacimiento);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                                     

      // Codigo Empleado
      if (hidtextCodEmpleado != null && !hidtextCodEmpleado.equals("") )
          cadena.append(hidtextCodEmpleado);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                                           

      // Nacionalidad
      if (hidcbNacionalidad != null && !hidcbNacionalidad.equals("") )
          cadena.append(hidcbNacionalidad);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // Estado Civil
      if (hidcbEstadoCivil != null && !hidcbEstadoCivil.equals("") )
          cadena.append(hidcbEstadoCivil);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);      

      // Ocupacion
      if (hidtextOcupacion != null && !hidtextOcupacion.equals("") )
          cadena.append(hidtextOcupacion);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);            

      // Profesion
      if (hidtextProfesion != null && !hidtextProfesion.equals("") )
          cadena.append(hidtextProfesion);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);            
      
      // Centro Trabajo
      if (hidtextCentroTrabajo != null && !hidtextCentroTrabajo.equals("") )
          cadena.append(hidtextCentroTrabajo);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);   

      // Cargo 
      if (hidtextCargoDesempena != null && !hidtextCargoDesempena.equals("") )
          cadena.append(hidtextCargoDesempena);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);   

      // Nivel de Estudios
      if (hidcbNivelEstudios != null && !hidcbNivelEstudios.equals("") )
          cadena.append(hidcbNivelEstudios);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);   

      // Centro de Estudios
      if (hidtextCentroEstudios != null && !hidtextCentroEstudios.equals("") )
          cadena.append(hidtextCentroEstudios);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);         

      // Numero de Hijos
      if (hidtextNHijos != null && !hidtextNHijos.equals("") )
          cadena.append(hidtextNHijos);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);               

      // Personas Dependientes
      if (hidtextNPersonasDependientes != null && !hidtextNPersonasDependientes.equals("") )
          cadena.append(hidtextNPersonasDependientes);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                     

      // NSEP (Nivel Socieconomico Persona)
      if (hidcbNivelSocioEconomico != null && !hidcbNivelSocioEconomico.equals("") )
          cadena.append(hidcbNivelSocioEconomico);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);    

      // Ciclo de Vida Familiar
      if (hidcbCicloVidaFamilia != null && !hidcbCicloVidaFamilia.equals("") )
          cadena.append(hidcbCicloVidaFamilia);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);          

      // Desea Correspondencia
      if (hidrbDeseaCorrespondencia != null && !hidrbDeseaCorrespondencia.equals("") )
      {
        if (hidrbDeseaCorrespondencia.equals("S") )
           cadena.append("true");        
         else
           cadena.append("false");
      } else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);          

      // Importe Ingreso
      if (hidtextImporteIngresoFamiliar != null && !hidtextImporteIngresoFamiliar.equals("") )
          cadena.append(hidtextImporteIngresoFamiliar);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);          

      // Pais Contactado 
      if (hidcbPaisContactado != null && !hidcbPaisContactado.equals("") )
          cadena.append(hidcbPaisContactado);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // Cliente Contactado
      if (hidtextCodClienteContactado != null && !hidtextCodClienteContactado.equals("") )
          cadena.append(hidtextCodClienteContactado);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);      

      // Tipo Cliente Contactado
      if (hidcbTipoClienteContactado != null && !hidcbTipoClienteContactado.equals("") )
          cadena.append(hidcbTipoClienteContactado);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);            

      // Tipo Contacto
      if (hidcbCodTipoContactado != null && !hidcbCodTipoContactado.equals("") )
          cadena.append(hidcbCodTipoContactado);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                  

      // Fecha Contacto
      if (hidtextFechaContacto != null && !hidtextFechaContacto.equals("") )
          cadena.append(hidtextFechaContacto);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);           

      // Fecha Siguiente Contacto
      if (hidtextFechaSiguienteContacto != null && !hidtextFechaSiguienteContacto.equals("") )
          cadena.append(hidtextFechaSiguienteContacto);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                 

      // ***************************************************
      //      ACA VA CANAL, PERIODO Y MARCA DE CONTACTO
      // ***************************************************
/*        private String hidcbMarcaContacto             = new String("");
        private String hidcbCanalContacto             = new String("");
        private String hidcbPeriodoContacto           = new String("");*/     
        
      // Marca Contacto
      if (hidcbMarcaContacto != null && !hidcbMarcaContacto.equals("") )
        cadena.append(hidcbMarcaContacto);
      else
        cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                 

      // Canal Contacto
      if (hidcbCanalContacto != null && !hidcbCanalContacto.equals("") )
        cadena.append(hidcbCanalContacto);
      else
        cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                 
      
      // Periodo Contacto
      if (hidcbPeriodoContacto != null && !hidcbPeriodoContacto.equals("") )
        cadena.append(hidcbPeriodoContacto);
      else
        cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);            
      // ***************** Fin ***********************************
      
      // Pais Vinculo
      if (hidcbPaisVinculo != null && !hidcbPaisVinculo.equals("") )
          cadena.append(hidcbPaisVinculo);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);         

      // Vinculo Principal
      if (hidrbVinculoPrincipal != null && !hidrbVinculoPrincipal.equals("") )
      {
        if (hidrbVinculoPrincipal.equals("S") )
          cadena.append("true");
        else
          cadena.append("false");
      } else
      {
         cadena.append(DTBuscarCliente.TOKEN_VACIO);        
      }


      cadena = separator(cadena);               

      // Fecha Desde
      if (hidtextFechaD != null && !hidtextFechaD.equals("") )
          cadena.append(hidtextFechaD);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);    

      // Fecha Hasta
      if (hidtextFechaH != null && !hidtextFechaH.equals("") )
          cadena.append(hidtextFechaH);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);    

      // Cliente Vinculado
      if (hidtextClienteVinculo != null && !hidtextClienteVinculo.equals("") )
          cadena.append(hidtextClienteVinculo);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);          

      // Tipo Vinculo
      if (hidcbTipoVinculo != null && !hidcbTipoVinculo.equals("") )
          cadena.append(hidcbTipoVinculo);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                

      // Descripcion Preferencia
      if (hidtextDescripcion != null && !hidtextDescripcion.equals("") )
          cadena.append(hidtextDescripcion);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                      

      // Tipo Preferencia
      if (hidcb != null && !hidcb.equals("") )
          cadena.append(hidcb);
       else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);

      // Tipo Comunicacion
      if (hidcbTipoComunicacion != null && !hidcbTipoComunicacion.equals("") )
         cadena.append(hidcbTipoComunicacion);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);     

      // Dia Comunicacion
      if (hidcbDiaComunicacion != null && !hidcbDiaComunicacion.equals("") )
         cadena.append(hidcbDiaComunicacion);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);          

      // Texto Comunicacion
      if (hidtextTextoComunicacion != null && !hidtextTextoComunicacion.equals("") )
         cadena.append(hidtextTextoComunicacion);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);              

      // Comunicacion Principal
      if (hidrbComunicacionPrincipal != null && !hidrbComunicacionPrincipal.equals("") )
      {
        if ( hidrbComunicacionPrincipal.equals("S") )
          cadena.append("true");
        else
          cadena.append("false");
      } else
      {
         //cadena.append( hidrbComunicacionPrincipal );
         cadena.append(DTBuscarCliente.TOKEN_VACIO);
      }

      cadena = separator(cadena);                    

      // Horas Desde
      if (hidtextHoraDesde != null && !hidtextHoraDesde.equals("") )
         cadena.append(hidtextHoraDesde);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                    

      // Horas Hasta
      if (hidtextHoraHasta != null && !hidtextHoraHasta.equals("") )
         cadena.append(hidtextHoraHasta);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);      

      // Intervalo de comunicacion
      if (hidcbIntervaloComunicacion != null && !hidcbIntervaloComunicacion.equals("") )
         cadena.append(hidcbIntervaloComunicacion);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);            
      
      // Tipo Tarjeta
      if (hidcbTipoTarjeta != null && !hidcbTipoTarjeta.equals("") )
         cadena.append(hidcbTipoTarjeta);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);      

      // Clase Tarjeta
      if (hidcbClasesTarjeta != null && !hidcbClasesTarjeta.equals("") )
         cadena.append(hidcbClasesTarjeta);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);            

      // Banco      
      if (hidcbEntidadBancaria != null && !hidcbEntidadBancaria.equals("") )
         cadena.append(hidcbEntidadBancaria);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);         

      // Tipo Problema
      if (hidcbTipoProblema != null && !hidcbTipoProblema.equals(""))
           cadena.append(hidcbTipoProblema);
      else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);   

      //Descripcion Problema
      if (hidtextDescripcionProblema != null && !hidtextDescripcionProblema.equals("") )
          cadena.append(hidtextDescripcionProblema);
      else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                            

      //Tipo Solucion
      if (hidcbTipoSolucion != null && !hidcbTipoSolucion.equals("") )
          cadena.append(hidcbTipoSolucion);
      else
          cadena.append(DTBuscarCliente.TOKEN_VACIO);        
           
      cadena = separator(cadena);            
        
      // Descripcion - SOLUCION
      if (hidtextDescripcionSolucion != null && !hidtextDescripcionSolucion.equals("") )
         cadena.append(hidtextDescripcionSolucion);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      cadena = separator(cadena);                       


      if (hidrbSolucion == null || hidrbSolucion.equals("")){
        cadena.append(DTBuscarCliente.TOKEN_VACIO);
      }else if (hidrbSolucion.equals("S")){
                cadena.append("true");
           }else{
                cadena.append("false");

           }

      cadena = separator(cadena);
     
      // Negocio
      if (hidtextNegocioProducto != null && !hidtextNegocioProducto.equals("") )
         cadena.append(hidtextNegocioProducto);
      else
         cadena.append(DTBuscarCliente.TOKEN_VACIO);

      //cadena = separator(cadena);   
	  cadena = separator(cadena);

      //traza("CADENA FORMADA: " + cadena.toString() );
      return cadena.toString();
      
  }
  

  private StringBuffer separator(StringBuffer buf)
  {
       buf.append(DruidaTransactionComun.SEPARADOR_PARAMETROS);
       return buf;
  }

	/*
	 * Temporal, borrorar. Es para ver un log porque la traza no funciona
	 * */
	private static String getFileName() {
		String mareRoot = System.getProperty("MareConfigurationRoot");

		if(!mareRoot.endsWith(File.separator))
			mareRoot += File.separator;

		mareRoot += "fichero_rastreo.log";
		System.out.println("Archivo Rastreo: " + mareRoot);

		return mareRoot;
	}

	/*
	 * Temporal, borrorar. Es para ver un log porque la traza no funciona
	 * */
	private static void write(String str) {
		try {
			RandomAccessFile logFile = new RandomAccessFile(getFileName(), "rw");
			logFile.seek(logFile.length());

			logFile.writeBytes(str + "\n");

			logFile.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			String codigoError = CodigosError.ERROR_ARCHIVO_RASTREO;
			//throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} catch(IOException e) {
			e.printStackTrace();
			String codigoError = CodigosError.ERROR_ARCHIVO_RASTREO;
			//throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
	}


  private void seteaVisibilidadListas(String sVisibilidad) throws Exception
  {
      // Setea la visibilidad de las listas en la pantalla de Detalle. 

      for (int i = 1; i<12; i++)
        asignarAtributo("CAPA", "capaListado" + i, "visibilidad", sVisibilidad);

      asignarAtributo("CAPA", "capaFormulario1", "visibilidad", "hidden");
      asignarAtributo("CAPA", "capaFormulario2", "visibilidad", "hidden");      

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

  private String transformaFechas(Date fechaBD) throws Exception
  { 
  
      traza("TransformaFechas");
      // Transforma las Fechas para mostrar en pantalla, en formato de Sesión.
      String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
      formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
      //traza("Antes: " + fechaBD.toString() );
      SimpleDateFormat sFormat = new SimpleDateFormat(formatoFechaSesion);
      String sBuffer = sFormat.format(fechaBD);
      //traza("Despues: " + sBuffer.toString() );

      return sBuffer;
    
  }

  private void asignarCasoUso() throws Exception
  {
		asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
  }

  private void situarPestanyas(String pestanya) throws Exception
  {		
	    traza("situarPestanyas - pestanya a Mostrar: " + pestanya);

		if ( pestanya.equals("0") )
		{
		  asignarAtributo("LISTAEDITABLE", "listado0", "y", "42");
		  asignarAtributo("LISTAEDITABLE", "listado0", "alto", "299");
		  asignarAtributo("PAGINADO", "mipgndo0", "y", "318");
		  asignarAtributo("BOTON", "ret0", "y", "292");
		  asignarAtributo("BOTON", "ava0", "y", "292");
		  asignarAtributo("BOTON", "primera0", "y", "322");
		  asignarAtributo("BOTON", "Siguiente0", "y", "319");
		  asignarAtributo("CAPA", "capaFull", "alto", "350");

		}
		else if ( pestanya.equals("1") )
		{
/*		asignarAtributo("LISTAEDITABLE", "listado1", "y", "147");
		  asignarAtributo("LISTAEDITABLE", "listado1", "alto", "275");
		  asignarAtributo("PAGINADO", "mipgndo1", "y", "373");
		  asignarAtributo("BOTON", "ret1", "y", "373");
		  asignarAtributo("BOTON", "ava1", "y", "373");
		  asignarAtributo("BOTON", "pri1", "y", "403");
		  asignarAtributo("BOTON", "Anterior1", "y", "399");
		  asignarAtributo("BOTON", "Validar1", "y", "399");
  		  asignarAtributo("CAPA", "capaTituloLista1", "y", "112");
  		  asignarAtributo("CAPA", "capaTituloLista1", "alto", "50");
		  asignarAtributo("CAPA", "capaFormulario1", "alto", "100");
		  asignarAtributo("CAPA", "capaFormulario1", "y", "30");
		  asignarAtributo("CAPA", "capaFull", "alto", "440");*/

    	asignarAtributo("LISTAEDITABLE", "listado1", "y", "137");
		  asignarAtributo("LISTAEDITABLE", "listado1", "alto", "275");
		  asignarAtributo("PAGINADO", "mipgndo1", "y", "363");
		  asignarAtributo("BOTON", "ret1", "y", "363");
		  asignarAtributo("BOTON", "ava1", "y", "363");
		  asignarAtributo("BOTON", "pri1", "y", "393");
		  asignarAtributo("BOTON", "Anterior1", "y", "389");
		  asignarAtributo("BOTON", "Validar1", "y", "389");
		  asignarAtributo("CAPA", "capaTituloLista1", "y", "112");
		  asignarAtributo("CAPA", "capaTituloLista1", "alto", "50");
		  asignarAtributo("CAPA", "capaFormulario1", "alto", "100");
		  asignarAtributo("CAPA", "capaFormulario1", "y", "30");
		  asignarAtributo("CAPA", "capaFull", "alto", "440");      

		}

		else if ( pestanya.equals("2") )
		{
			asignarAtributo("CAPA", "capaFormulario2", "y", "30");
			asignarAtributo("CAPA", "capaFormulario2", "alto", "100%");
			asignarAtributo("LISTAEDITABLE", "listado2", "y", "407");
			asignarAtributo("LISTAEDITABLE", "listado2", "alto", "275");
		    asignarAtributo("PAGINADO", "mipgndo2", "y", "633");
		    asignarAtributo("BOTON", "ret2", "y", "633");
		    asignarAtributo("BOTON", "ava2", "y", "633");
		    asignarAtributo("BOTON", "pri2", "y", "663");

			asignarAtributo("CAPA", "capaTituloLista21", "y", "382");
			asignarAtributo("CAPA", "capaTituloLista21", "alto", "50");
			asignarAtributo("LISTAEDITABLE", "listado3", "y", "730");
			asignarAtributo("LISTAEDITABLE", "listado3", "alto", "275");
		    asignarAtributo("PAGINADO", "mipgndo3", "y", "956");
		    asignarAtributo("BOTON", "ret3", "y", "956");
		    asignarAtributo("BOTON", "ava3", "y", "956");
		    asignarAtributo("BOTON", "pri3", "y", "986");
			
			asignarAtributo("CAPA", "capaTituloLista22", "y", "705");
			asignarAtributo("CAPA", "capaTituloLista22", "alto", "50");

			asignarAtributo("LISTAEDITABLE", "listado4", "y", "1053");
			asignarAtributo("LISTAEDITABLE", "listado4", "alto", "290");
		    asignarAtributo("PAGINADO", "mipgndo4", "y", "1279");
		    asignarAtributo("BOTON", "ret4", "y", "1279");
		    asignarAtributo("BOTON", "ava4", "y", "1279");
		    asignarAtributo("BOTON", "pri4", "y", "1309");

			asignarAtributo("CAPA", "capaTituloLista23", "y", "1028");
			asignarAtributo("CAPA", "capaTituloLista23", "alto", "50");

		    asignarAtributo("CAPA", "capaFull", "alto", "1350");

		}

		else if ( pestanya.equals("3") )
		{
			asignarAtributo("LISTAEDITABLE", "listado5", "y", "67");
			asignarAtributo("LISTAEDITABLE", "listado5", "alto", "290");
		    asignarAtributo("PAGINADO", "mipgndo5", "y", "293");
		    asignarAtributo("BOTON", "ret5", "y", "293");
		    asignarAtributo("BOTON", "ava5", "y", "293");
		    asignarAtributo("BOTON", "pri5", "y", "323");			

			asignarAtributo("CAPA", "capaTituloLista31", "y", "42");
			asignarAtributo("CAPA", "capaTituloLista31", "alto", "50");

			asignarAtributo("LISTAEDITABLE", "listado6", "y", "405");
			asignarAtributo("LISTAEDITABLE", "listado6", "alto", "290");
		    asignarAtributo("PAGINADO", "mipgndo6", "y", "630");
		    asignarAtributo("BOTON", "ret6", "y", "630");
		    asignarAtributo("BOTON", "ava6", "y", "630");
		    asignarAtributo("BOTON", "pri6", "y", "660");			

			asignarAtributo("CAPA", "capaTituloLista32", "y", "380");
			asignarAtributo("CAPA", "capaTituloLista32", "alto", "50");

			asignarAtributo("LISTAEDITABLE", "listado7", "y", "743");
			asignarAtributo("LISTAEDITABLE", "listado7", "alto", "275");
		    asignarAtributo("PAGINADO", "mipgndo7", "y", "969");
		    asignarAtributo("BOTON", "ret7", "y", "969");
		    asignarAtributo("BOTON", "ava7", "y", "969");
		    asignarAtributo("BOTON", "pri7", "y", "999");			
		    asignarAtributo("BOTON", "Anterior7", "y", "995");			
		    asignarAtributo("BOTON", "Siguiente7", "y", "995");			

			asignarAtributo("CAPA", "capaTituloLista33", "y", "718");
			asignarAtributo("CAPA", "capaTituloLista33", "alto", "50");

		    asignarAtributo("CAPA", "capaFull", "alto", "1050");
			
		}

		else if ( pestanya.equals("4"))
		{

			asignarAtributo("LISTAEDITABLE", "listado8", "y", "67");
			asignarAtributo("LISTAEDITABLE", "listado8", "alto", "275");
		    asignarAtributo("PAGINADO", "mipgndo8", "y", "293");
		    asignarAtributo("BOTON", "ret8", "y", "293");
		    asignarAtributo("BOTON", "ava8", "y", "293");
		    asignarAtributo("BOTON", "pri8", "y", "323");			

			asignarAtributo("CAPA", "capaTituloLista41", "y", "42");
			asignarAtributo("CAPA", "capaTituloLista41", "alto", "50");

			asignarAtributo("LISTAEDITABLE", "listado9", "y", "390");
			asignarAtributo("LISTAEDITABLE", "listado9", "alto", "275");
		    asignarAtributo("PAGINADO", "mipgndo9", "y", "616");
		    asignarAtributo("BOTON", "ret9", "y", "616");
		    asignarAtributo("BOTON", "ava9", "y", "616");
		    asignarAtributo("BOTON", "pri9", "y", "646");			

			asignarAtributo("CAPA", "capaTituloLista2", "y", "365");
			asignarAtributo("CAPA", "capaTituloLista2", "alto", "50");

			asignarAtributo("LISTAEDITABLE", "listado10", "y", "713");
			asignarAtributo("LISTAEDITABLE", "listado10", "alto", "290");
		    asignarAtributo("PAGINADO", "mipgndo10", "y", "939");
		    asignarAtributo("BOTON", "ret10", "y", "939");
		    asignarAtributo("BOTON", "ava10", "y", "939");
		    asignarAtributo("BOTON", "pri10", "y", "969");			

			asignarAtributo("CAPA", "capaTituloLista10", "y", "688");
			asignarAtributo("CAPA", "capaTituloLista10", "alto", "50");

			asignarAtributo("LISTAEDITABLE", "listado11", "y", "1051");
			asignarAtributo("LISTAEDITABLE", "listado11", "alto", "275");
		    asignarAtributo("PAGINADO", "mipgndo11", "y", "1277");
		    asignarAtributo("BOTON", "ret11", "y", "1277");
		    asignarAtributo("BOTON", "ava11", "y", "1277");
		    asignarAtributo("BOTON", "pri11", "y", "1307");			
		    asignarAtributo("BOTON", "Anterior11", "y", "1303");			

			asignarAtributo("CAPA", "capaTituloLista11", "y", "1026");
			asignarAtributo("CAPA", "capaTituloLista11", "alto", "50");

		    asignarAtributo("CAPA", "capaFull", "alto", "1350");

		}

   }

 private void obtenerConfiguracionCampos() throws Exception{
	try{
    HashMap tipoSubt = new HashMap();
	 traza("Creamos los DTOS");
	  Vector field = new Vector();
	  DTOConfiguracionCamposCliente dtoConfigClie = new DTOConfiguracionCamposCliente();
		DTOConfiguracionCamposCliente dtoSalida = new DTOConfiguracionCamposCliente();
	  DTOCampo[] dtocampo= new DTOCampo[24];
		UtilidadesSession sesion = new UtilidadesSession();

	 //traza("Leemos los objetos de la sesion");
		tipoSubt=(HashMap)conectorParametroSesion("tipoSubtipo");
		/*if(tipoSubt.isEmpty()){
			traza("HasMap vacio");
		}*/
	
		//this.traza("Cargamos los DTOCampos");
		 for(int i=0;i<23;i++){
			 //traza("Indice: " + i);
			 dtocampo[i]=new DTOCampo();
			 switch(i){
				case 0:
					dtocampo[i].setCodigoCampo("MAECLIEAPELL1");
					field.addElement(dtocampo[i]);
					break;
				case 1:
					dtocampo[i].setCodigoCampo("MAECLIEAPELL2");
					field.addElement(dtocampo[i]);
					break;
				case 2:
					dtocampo[i].setCodigoCampo("MAECLIEAPELLCA");
					field.addElement(dtocampo[i]);
					break;
				case 3:
					dtocampo[i].setCodigoCampo("MAECLIENOM1");
					field.addElement(dtocampo[i]);
					break;
				case 4:
					dtocampo[i].setCodigoCampo("MAECLIENOM2");
					field.addElement(dtocampo[i]);
					break;
				case 5:
					dtocampo[i].setCodigoCampo("MAECLIEFECHNA");
					field.addElement(dtocampo[i]);
					break;
				case 6:
					dtocampo[i].setCodigoCampo("MAECLIECODEMP");
					field.addElement(dtocampo[i]);
					break;
				case 7:
					dtocampo[i].setCodigoCampo("MAECLIEOCUP");
					field.addElement(dtocampo[i]);
					break;
				case 8:
					dtocampo[i].setCodigoCampo("MAECLIEPROF");
					field.addElement(dtocampo[i]);
					break;
				case 9:
					dtocampo[i].setCodigoCampo("MAECLIECENTRA");
					field.addElement(dtocampo[i]);
					break;
				case 10:
					dtocampo[i].setCodigoCampo("MAECLIECARGO");
					field.addElement(dtocampo[i]);
					break;
				case 11:
					dtocampo[i].setCodigoCampo("MAECLIECENESTU");
					field.addElement(dtocampo[i]);
					break;
				case 12:
					dtocampo[i].setCodigoCampo("MAECLIEPERSDEP");
					field.addElement(dtocampo[i]);
					break;
				case 13:
					dtocampo[i].setCodigoCampo("MAECLIEINGFAM");
					field.addElement(dtocampo[i]);
					break;
				case 14:
					dtocampo[i].setCodigoCampo("MAECLIEFECHING");
					field.addElement(dtocampo[i]);
					break;
				
				case 15:
					dtocampo[i].setCodigoCampo("MAECLIETRAT");
					field.addElement(dtocampo[i]);
					break;
				case 16:
					dtocampo[i].setCodigoCampo("MAECLIENACIO");
					field.addElement(dtocampo[i]);
					break;
				case 17:
					dtocampo[i].setCodigoCampo("MAECLIEESTCIV");
					field.addElement(dtocampo[i]);
					break;
				case 18:
					dtocampo[i].setCodigoCampo("MAECLIENIVESTU");
					field.addElement(dtocampo[i]);
					break;
				case 19:
					dtocampo[i].setCodigoCampo("MAECLIENSEP");
					field.addElement(dtocampo[i]);
					break;
				case 20:
					dtocampo[i].setCodigoCampo("MAECLIECICLVID");
					field.addElement(dtocampo[i]);
					break;
				case 21:
					dtocampo[i].setCodigoCampo("MAECLIESEXO");
					field.addElement(dtocampo[i]);
					break;
				case 22:
					dtocampo[i].setCodigoCampo("MAECLIEDESCORR");
					field.addElement(dtocampo[i]);
					break;
/*				case 23:
					dtocampo[i].setCodigoCampo("MAECLIEEDAD");
					field.addElement(dtocampo[i]);
					break;*/
				 
			 }
		 }
		 //traza("Sale del bucle");
			tipoSubt=(HashMap)conectorParametroSesion("tipoSubtipo");
			dtoConfigClie.setCampos(field);
			dtoConfigClie.setTipo(new Long(tipoSubt.get("h_comboTipoCliente_0").toString()));
			dtoConfigClie.setSubtipo(new Long(tipoSubt.get("h_comboSubtipoCliente_0").toString()));
			dtoConfigClie.setOidPais(sesion.getPais(this));
			dtoConfigClie.setOidIdioma(sesion.getIdioma(this));

      Vector params = new Vector();
      MareBusinessID bussID = new MareBusinessID("MAEConfiguracionCamposCliente");
      
      params.add(dtoConfigClie);
      params.add(bussID);
      
      DruidaConector con = this.conectar("ConectorObjetoGenerico", params);
      dtoSalida = (DTOConfiguracionCamposCliente) con.objeto("DTOSalida");

			Vector resultado=dtoSalida.getCampos();
      //traza("vector Campos: " + resultado.toString() );
			this.asignarAtributoRequerido(resultado);
			
		
		
		
	  }catch(Throwable th){
            this.traza("error en ConfiguracionCampos");
            ByteArrayOutputStream stack = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(stack);
            th.printStackTrace(out);
            traza(  stack.toString());
            BelcorpError belcorpError = new BelcorpError();
            DTOError dtoError = belcorpError.obtenerError(	th, 
            UtilidadesSession.getIdioma_ISO( this ) , 
                                        ""	
                                      );
            String s = th.getMessage();
            traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
                  throw((Exception) th);
       
           }     
  }   

  private void asignarAtributoRequerido(Vector resultado) throws Exception
  {	
      traza("Entra a asignarAtributoRequerido");
      DTOCampo dtoCampo = null;
      HashMap hashCampos = new HashMap();
      
      Vector vCampos = new Vector();
      Vector vTipoNombre = new Vector();

      // Apellido 1 
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textApellido1");
      hashCampos.put("MAECLIEAPELL1", vTipoNombre);

      // Apellido 2
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textApellido2");
      hashCampos.put("MAECLIEAPELL2", vTipoNombre);
      
      // Apellido Casada
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textApellidoCasada");
      hashCampos.put("MAECLIEAPELLCA", vTipoNombre);
      
      // Apellido Nombre 1 
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textNombre1");
      hashCampos.put("MAECLIENOM1", vTipoNombre);      

      // Apellido Nombre 2
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textNombre2");
      hashCampos.put("MAECLIENOM2", vTipoNombre);            

      // Fecha Nacimiento
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textFechaNacimiento");
      hashCampos.put("MAECLIEFECHNA", vTipoNombre);                  

      // Codigo Empleado
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textCodEmpleado");
      hashCampos.put("MAECLIECODEMP", vTipoNombre);          

      // Ocupacion 
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textOcupacion");
      hashCampos.put("MAECLIEOCUP", vTipoNombre);                

      // Profesion
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textProfesion");
      hashCampos.put("MAECLIEPROF", vTipoNombre);                      

      // Centro de Trabajo
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textCentroTrabajo");
      hashCampos.put("MAECLIECENTRA", vTipoNombre);                      
      
      // Cargo que desempeña
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textCargoDesempena");
      hashCampos.put("MAECLIECARGO", vTipoNombre);                            
      
      // Centro Estudios
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textCentroEstudios");
      hashCampos.put("MAECLIECENESTU", vTipoNombre);                            

      // Personas Dependientes
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textNPersonasDependientes");
      hashCampos.put("MAECLIEPERSDEP", vTipoNombre);                                  

      // Ingresos Familiares
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textImporteIngresoFamiliar");
      hashCampos.put("MAECLIEINGFAM", vTipoNombre);   

      // Fecha de Ingreso 
      vTipoNombre = new Vector();
      vTipoNombre.add("LABELC");
      vTipoNombre.add("lbl2FechaIngresoActual");
      hashCampos.put("MAECLIEFECHING", vTipoNombre);         

      // Tratamiento
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbTratamiento");
      hashCampos.put("MAECLIETRAT", vTipoNombre);               

      // Nacionalidad 
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbNacionalidad");
      hashCampos.put("MAECLIENACIO", vTipoNombre);               

      // Estado Civil
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbEstadoCivil");
      hashCampos.put("MAECLIEESTCIV", vTipoNombre);        

      // Nivel Estudios
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbNivelEstudios");
      hashCampos.put("MAECLIENIVESTU", vTipoNombre);        

      // Nivel Socioeconomico
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbNivelSocioEconomico");
      hashCampos.put("MAECLIENSEP", vTipoNombre);     

      // Ciclo de Vida
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbCicloVidaFamiliar");
      hashCampos.put("MAECLIECICLVID", vTipoNombre);  

      // Sexo
      vTipoNombre = new Vector();
      vTipoNombre.add("RADIOB");
      vTipoNombre.add("rbSexo");
      hashCampos.put("MAECLIESEXO", vTipoNombre);  

      // Desea Correspondecia
      vTipoNombre = new Vector();
      vTipoNombre.add("RADIOB");
      vTipoNombre.add("rbDeseaCorrespondencia");
      hashCampos.put("MAECLIEDESCORR", vTipoNombre);  

      String codigoCampo = null;
      Boolean requerido = null;
      Vector vAsignar = null;
      String nombreCampoXML = null;
      String tipoCampoXML = null;
      
      for (int i = 0; i < 23; i++)
      {
        //traza("AsignarAtributo, bucle " + i);
        dtoCampo = (DTOCampo)resultado.get(i);
        codigoCampo = dtoCampo.getCodigoCampo();
        //traza("    - codigo Campo: " + codigoCampo );
        requerido = dtoCampo.getObligatorio();
        
        vAsignar = (Vector) hashCampos.get(codigoCampo);
        tipoCampoXML = (String) vAsignar.get(0);
        nombreCampoXML = (String) vAsignar.get(1);     

        if (requerido.booleanValue() == true)
          this.asignarAtributo(tipoCampoXML, nombreCampoXML, "req", "S");
        else
          this.asignarAtributo(tipoCampoXML, nombreCampoXML, "req", "N");       
        
      }
  }
  
  private boolean checkResultado(String params) throws Exception
  {
      DTOCliente dto = this.creardtoCliente(params);
      String sPageSize = Contexto.getPropiedad("PAG.SIZE");
      traza("PageSize: " + sPageSize);
      dto.setTamanioPagina(new Integer(sPageSize));
      dto.setIndicadorSituacion(new Long(0));
      
      MareBusinessID bussID = new MareBusinessID("MAEBusquedaClientes");

      Vector v = new Vector();
      
      v.add(dto);
      v.add(bussID);

      DruidaConector con = this.conectar("ConectorObjetoGenerico", v);
      
      DTOSalida dtoS = (DTOSalida) con.objeto("DTOSalida");
      RecordSet r = dtoS.getResultado();
      if (r.getRowCount() == 0) {
        return false;
      } else {
        traza("Cant. de registros: " + r.getRowCount());
        // Agregado by ssantana, 9/11/2005, inc. BELC300021301
        //traza("RecordSet a subir a sesion: " + r);
        this.conectorParametroSesion("rResultadoConsultaClientes", r);
        // Fin agregado by ssantana, 9/11/2005, inc. BELC300021301
        
        return true;
      }

  }  


private DTOCliente creardtoCliente(String parametros) throws Exception
{
  		traza("entre a DTBuscarCliente creardtocliente");
			DTOCliente dtoClie = new DTOCliente();
			StringTokenizer stk = new StringTokenizer(parametros,SEPARADOR_PARAMETROS);
			traza("stk: " + stk);
			//traza("Nro. parametros: "+stk.countTokens());
			//traza("parametros: " + parametros);
			//stk.countTokens()
			
			//while (stk.hasMoreTokens()){            
            DTOCrearClienteBasico dtoCrearCliBas = new DTOCrearClienteBasico();
            String strSTK = tokenizar(stk);


            Vector vec = new Vector();
            //traza("paso 2 " + strSTK);
            if(!(strSTK.equals(" "))){
				//traza("Entro IF");
                vec = obtieneTipos(strSTK);

                RecordSet rTipos    = (RecordSet)vec.get(0);// new RecordSet();
                RecordSet rSubTipos = (RecordSet)vec.get(1);;// new RecordSet();
                       
				int cantDto = 0;
				///*[1]
				if (rTipos!= null){
					cantDto = rTipos.getRowCount();
				}
				//traza("cantDto=" + cantDto);
				//*/[1]
                
                /* traza("paso 7");
                for (int i=0 ;i < rTipos.getRowCount() ; i++)  {
                  traza("paso 8  y " + i);
                  cantDto++;
                }*/

                DTOTipoSubtipoCliente[] dtoTipoSubClie = new DTOTipoSubtipoCliente[cantDto];
            
                for (int i=0 ;i < cantDto ; i++){
                   dtoTipoSubClie[i]= new DTOTipoSubtipoCliente();
                   //traza("paso 11 " + rTipos.getValueAt(i, 0));
                   dtoTipoSubClie[i].setTipo( ((String)rTipos.getValueAt(i, 0)).equals(TOKEN_VACIO)?null:new Long( (String)rTipos.getValueAt(i, 0)) );
            
                }
                for (int i=0 ;i < rSubTipos.getRowCount() ; i++){
                   //dtoTipoSubClie[i]= new DTOTipoSubtipoCliente();
                   dtoTipoSubClie[i].setSubtipo( ((String)rSubTipos.getValueAt(i, 1)).equals(TOKEN_VACIO)?null:new Long( (String)rSubTipos.getValueAt(i, 1)) );
              
                }

            
                //DTOTipoSubtipoCliente[] dtoTipoSubClie = new DTOTipoSubtipoCliente[1];
                //dtoTipoSubClie[0]= new DTOTipoSubtipoCliente();
                //String strSTK = tokenizar(stk);
                /*dtoTipoSubClie[0].setTipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
          traza("Tipo: " + strSTK);
                strSTK = tokenizar(stk);
                dtoTipoSubClie[0].setSubtipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
          traza("SubTipo: " + strSTK);*/
            

      
                /*for (int t = 0; t < dtoTipoSubClie.length; t++) {
                   traza("DTO A ENVIAR TIPOSUBT" + dtoTipoSubClie[t]);
                }*/

                dtoCrearCliBas.setTiposSubtipos(dtoTipoSubClie);     
            }else{
               DTOTipoSubtipoCliente[] dtoTipoSubClie = new DTOTipoSubtipoCliente[1];
               dtoTipoSubClie[0]= new DTOTipoSubtipoCliente();
               dtoTipoSubClie[0].setTipo(null);
               dtoTipoSubClie[0].setSubtipo(null);
               dtoCrearCliBas.setTiposSubtipos(dtoTipoSubClie);

            }
			//traza("dtoTipoSubClie: " + dtoTipoSubClie[0].toString() );
			//traza("0");


			
            DTOIdentificacion[] dtoIdentif = new DTOIdentificacion[1];
            dtoIdentif[0] = new DTOIdentificacion();

            strSTK = tokenizar(stk);
            dtoIdentif[0].setTipoDocumento( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );            
			//traza("tipoDoc: " + strSTK);
            strSTK = tokenizar(stk);
            dtoIdentif[0].setEsPrincipal( strSTK.equals(TOKEN_VACIO)?null:(strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE) );
			//traza("EsPrincipal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoIdentif[0].setNumeroDocumento( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("NumDoc: " + strSTK);
            strSTK = tokenizar(stk);
            dtoIdentif[0].setIndPersonaEmpresa( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("IndicadorPersona: " + strSTK);
            dtoCrearCliBas.setIdentificaciones(dtoIdentif);

			//traza("dtoIdentif: + " + dtoIdentif[0].toString());
                  
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setCodigoCliente( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("CodigoCliente: " + strSTK);
            strSTK = tokenizar(stk);

            dtoCrearCliBas.setApellido1( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Apellido 1: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setApellido2( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Apellido 2: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setApellidoCasada( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Apellido Casada: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setNombre1( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Nombre 1: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setNombre2( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Nombre 2: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setTratamiento( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Tratamiento: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setSexo( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Sexo: " + strSTK);
            strSTK = tokenizar(stk);
            //dtoCrearCliBas.setFechaIngreso( toDate(strSTK) );
			dtoCrearCliBas.setFechaIngreso( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			//traza("FechaIngreso: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setFormaPago(strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK));
			//traza("FormaPago: " + strSTK);
//			traza("dtoCrearClienteBasico: " + dtoCrearCliBas.toString());

			//traza("2");
            DTODireccion[] dtoDire = new DTODireccion[1];
            dtoDire[0] = new DTODireccion();
            strSTK = tokenizar(stk);
            dtoDire[0].setTipoDireccion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("TipoDireccion: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setTipoVia( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("TipoVia: " + strSTK);
            strSTK = tokenizar(stk);
            //dtoDire[0].setVia( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			dtoDire[0].setVia(new Long(42163));
			//traza("Via - Al no usarse se setea a cualquier valor:  ");
			//traza("Via: " + strSTK );
            strSTK = tokenizar(stk);
            dtoDire[0].setNumeroPrincipal( strSTK.equals(TOKEN_VACIO)?null:Integer.valueOf(strSTK));
			//traza("NumPrincipal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setCodigoPostal( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("CodigoPostal: " + strSTK);
            strSTK = tokenizar(stk);
/*            dtoDire[0].setInterior( strSTK.equals(TOKEN_VACIO)?null:Integer.valueOf(strSTK) );
			traza("Interior: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setManzana( strSTK.equals(TOKEN_VACIO)?null:Integer.valueOf(strSTK) );
			traza("Manzana: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setLote( strSTK.equals(TOKEN_VACIO)?null:Integer.valueOf(strSTK) );
			traza("Lote: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setKilometro( strSTK.equals(TOKEN_VACIO)?null:Integer.valueOf(strSTK) );
			traza("Kilometro: " + strSTK);
            strSTK = tokenizar(stk);*/
            dtoDire[0].setObservaciones( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Observaciones: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setEsDireccionPrincipal( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("0")?Boolean.FALSE :Boolean.TRUE ) );
			//traza("EsDirPrincipal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setNombreVia( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("NombreVia: " + strSTK);
            dtoCrearCliBas.setDirecciones(dtoDire);

			//traza("dtoDire: " + dtoDire[0].toString() );                
			//traza("3");                
            DTOClienteMarca[] dtoClieMarca = new DTOClienteMarca[1];
            dtoClieMarca[0] = new DTOClienteMarca();
            strSTK = tokenizar(stk);
            dtoClieMarca[0].setMarca( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Marca: " + strSTK);
            dtoCrearCliBas.setMarcas(dtoClieMarca);
			//traza("dtoClieMarca: " + dtoClieMarca[0].toString() );
			//traza("4");

            DTOClasificacionCliente[] dtoClasiClie = new DTOClasificacionCliente[1];
            dtoClasiClie[0] = new DTOClasificacionCliente();
			strSTK = tokenizar(stk);
            dtoClasiClie[0].setMarca( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("MarcaClasif: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClasiClie[0].setCanal( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Canal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClasiClie[0].setTipoClasificacion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("TipoClasif: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClasiClie[0].setClasificacion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Clasif: " + strSTK);
            dtoCrearCliBas.setClasificaciones(dtoClasiClie);
			//traza("dtoClasiClie: " + dtoClasiClie[0].toString());

            //rellenamos los atributos de DTOCliente
            dtoClie.setBase(dtoCrearCliBas);

			//SICC-DMCO-MAE-GCC-006 - Cleal 
			strSTK = tokenizar(stk);
			dtoClie.setIndicadorActivo(strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK));
			//traza("Indicador Activo: " + strSTK);
			//

            strSTK = tokenizar(stk);
            dtoClie.setCriterioBusqueda1( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Criterio 1: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCriterioBusqueda2( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Criterio 2: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setFechaNacimiento( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			//traza("Fecha Nac: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCodigoEmpleado( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Codigo Empleado: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setNacionalidad( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Nacionalidad: " + strSTK);
/*            strSTK = tokenizar(stk);                
            dtoClie.setEdad( strSTK.equals(TOKEN_VACIO)||(strSTK.length()>2)?null:Short.valueOf(strSTK) );
			traza("Edad: " + strSTK);*/
            strSTK = tokenizar(stk);
            dtoClie.setEstadoCivil( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("EstadoCivil: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setOcupacion( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Ocupacion: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setProfesion( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Profesion: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCentroTrabajo( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Centro Trabajo: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCargo( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Cargo: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setNivelEstudios( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Nivel de Estudios: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCentroEstudios( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Centro de Estudios: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setNumeroHijos( strSTK.equals(TOKEN_VACIO)||(strSTK.length()>1)?null:Byte.valueOf(strSTK) );
			//traza("NumeroHijos: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setPersonasDependientes( strSTK.equals(TOKEN_VACIO)||(strSTK.length()>1)?null:Byte.valueOf(strSTK) );
			//traza("PersonasDependientes: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setNSEP( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("NSEP: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCicloVida( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Ciclo Vida: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setDeseaCorrespondencia( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE ) );
			//traza("DeseaCorrespondencia: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setImporteIngresos( strSTK.equals(TOKEN_VACIO)?null:Double.valueOf(strSTK) );
			//traza("Importe Ingresos: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setPaisContactado( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("PaisContactado: " + strSTK);
            strSTK = tokenizar(stk);      
            dtoClie.setClienteContactado( strSTK.equals(TOKEN_VACIO)?null:strSTK ); //codigoClienteContactado
			//traza("Cliente Contactado: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setTipoClienteContactado( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Tipo Cliente Contactado: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setTipoContacto( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Tipo Contacto: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setFechaPrimerContacto( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			//traza("Fecha Primer Contacto: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setFechaSiguienteContacto( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			//traza("Fecha Sig. Contacto: " + strSTK);

            // by Ssantana
            strSTK = tokenizar(stk);
            dtoClie.setMarcaContacto( strSTK.equals(TOKEN_VACIO)?null:new Long(strSTK) );
      //traza("Marca contacto: " + strSTK);

            strSTK = tokenizar(stk);
            dtoClie.setCanalContacto( strSTK.equals(TOKEN_VACIO)?null:new Long(strSTK) );
      //traza("Canal contacto: " + strSTK);

            strSTK = tokenizar(stk);
            dtoClie.setPeriodoContacto(strSTK.equals(TOKEN_VACIO)?null:new Long(strSTK) );            
      //traza("Periodo contacto: " + strSTK);
            // end by Ssantana

            
            
            
            //strSTK = tokenizar(stk);
            //dtoClie.setFechaPrimerPedidoContactado( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			//traza("Fecha Primer Pedido Contacto: " + strSTK);
			//traza("dtoClie: " + dtoClie.toString());

            DTOVinculo[] dtoVinculo = new DTOVinculo[1];
            dtoVinculo[0] = new DTOVinculo();
            strSTK = tokenizar(stk);
            dtoVinculo[0].setPais( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Pais: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setPrincipal( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE) );
			//traza("Principal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setFechaDesde( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			//traza("Fecha Desde: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setFechaHasta( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			//traza("Fecha Hasta: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setCodigoCliente( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("CodCliente: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setTipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );                
			//traza("Tipo: " + strSTK);
            dtoClie.setVinculos(dtoVinculo);  
			//traza("dtoVinculo: " + dtoVinculo[0].toString() );

            DTOPreferencia[] dtoPreferencia = new DTOPreferencia[1];
            dtoPreferencia[0] = new DTOPreferencia();
            strSTK = tokenizar(stk);
            dtoPreferencia[0].setDescripcion( strSTK.equals(TOKEN_VACIO)?null:strSTK  );
			//traza("Descripcion Preferencia: " + strSTK);
            strSTK = tokenizar(stk);
            dtoPreferencia[0].setTipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Tipo Pref: " + strSTK);
            dtoClie.setPreferencias(dtoPreferencia);
			//traza("dtoPreferencia: " + dtoPreferencia[0].toString() );

            dtoClie.setObservaciones(null);

            DTOComunicacion[] dtoComunica = new DTOComunicacion[1];
            dtoComunica[0] = new DTOComunicacion();
            strSTK = tokenizar(stk);
            dtoComunica[0].setTipoComunicacion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Tipo comm: " + strSTK);
            strSTK = tokenizar(stk);				
            dtoComunica[0].setDiaComunicacion( strSTK.equals(TOKEN_VACIO)||(strSTK.length()>1)?null:(new Character(strSTK.charAt(0))) );
			//traza("Dia Comm: " + strSTK);
            strSTK = tokenizar(stk);
            dtoComunica[0].setTextoComunicacion( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			//traza("Texto comm: " + strSTK);
            strSTK = tokenizar(stk);
            dtoComunica[0].setPrincipal( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE ) );
			//traza("Principal: " + strSTK);
            strSTK = tokenizar(stk);
            //Long horaDesde = toHoraAsLong(strSTK);
            //traza("horaDesde: " + horaDesde.toString() );
            //dtoComunica[0].setHoraDesde( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
            dtoComunica[0].setHoraDesde( strSTK.equals(TOKEN_VACIO)?null:toHoraAsLong(strSTK) );            
			//traza("Hora Desde: " + strSTK);
            strSTK = tokenizar(stk);
            //dtoComunica[0].setHoraHasta( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
            dtoComunica[0].setHoraHasta( strSTK.equals(TOKEN_VACIO)?null:toHoraAsLong(strSTK) );            
			//traza("Hora Hasta: " + strSTK);
            strSTK = tokenizar(stk);
            dtoComunica[0].setIntervaloComunicacion( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("false")?Boolean.FALSE:Boolean.TRUE ) );
            dtoClie.setComunicaciones(dtoComunica);       
			//traza("dtoComunica: " + dtoComunica[0].toString() );


            DTOTarjeta[] dtoTarjeta = new DTOTarjeta[1];
            dtoTarjeta[0] = new DTOTarjeta();
            strSTK = tokenizar(stk);
            dtoTarjeta[0].setTipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			//traza("Tipo Tarjeta: " + strSTK);
            strSTK = tokenizar(stk);
            dtoTarjeta[0].setClase( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
      		//	traza("Clase Tarjeta: " + strSTK);
            strSTK = tokenizar(stk);
            dtoTarjeta[0].setBanco( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
      		//	traza("Banco: " + strSTK);
            dtoClie.setTarjetas(dtoTarjeta);
            //traza("dtoTarjeta: " + dtoTarjeta[0].toString());


            strSTK = tokenizar(stk);
            DTOProblemaSolucion[] dtoProbleSolu = new DTOProblemaSolucion[1];
            dtoProbleSolu[0]= new DTOProblemaSolucion();


        //    dtoProbleSolu[0].set = armaProblemaSolucion(stk);
            
            //traza("EL TOK ES " + strSTK);
            
            dtoProbleSolu[0].setTipoProblema( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
            
            strSTK = tokenizar(stk);

      
            dtoProbleSolu[0].setDescripcionProblema( strSTK.equals(TOKEN_VACIO)?null:strSTK );

            strSTK = tokenizar(stk);

            dtoProbleSolu[0].setTipoSolucion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );


            strSTK = tokenizar(stk);
      
            dtoProbleSolu[0].setDescripcionSolucion( strSTK.equals(TOKEN_VACIO)?null:strSTK );

            strSTK = tokenizar(stk);

            dtoProbleSolu[0].setSolucion( strSTK.equals(TOKEN_VACIO)?null:(strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE) );

            strSTK = tokenizar(stk);
      
            dtoProbleSolu[0].setNegocio( strSTK.equals(TOKEN_VACIO)?null:strSTK );

            dtoClie.setProblemasSoluciones(dtoProbleSolu);
            
      		//	traza("dtoProbleSolu: " + dtoProbleSolu[0].toString());
            dtoClie.setPsicografias(null);

            dtoClie.setOidIdioma(UtilidadesSession.getIdioma(this));
            dtoClie.setOidPais(UtilidadesSession.getPais(this));  				

            //dtoClie.setTamanioPagina(pageSize);
            

            //traza("dtoClie: " + dtoClie.toString() );
           return dtoClie; 

             /*
             * estos parametros no cargue corroboara que no se me haya pasado algo!!
             * dtoClie.setPaisContactado();
            dtoClie.setOid(long);
            dtoClie.setOidClienteContactado(long);
             dtoClie.setTipoClienteContacto(dtoClie);
            */
	
         }  

   /*******FECHA**************/
	private Date toDate(String sFecha) throws Exception
    {
		String formatoFecha = UtilidadesSession.getFormatoFecha(this);
		//traza("formatoSesion: " + formatoFecha);
		//formatoFecha = formatoFecha.replace("m","M");
    formatoFecha = formatoFecha.replace('m', 'M');
		//SimpleDateFormat miFecha = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
	    /* La fecha viene de la forma dd/MM/yyyy */
      
		java.util.Date fecha = miFecha.parse(sFecha);
    miFecha = new SimpleDateFormat(formatoFecha);

    String fechaRes = miFecha.format(fecha);
		fecha = miFecha.parse(fechaRes);
    traza(fechaRes);
		//java.sql.Date sql = new java.sql.Date(fecha.getTime() + (86400*1000));
    java.sql.Date sql = new java.sql.Date(fecha.getTime());    
    //traza("sql Date: " + sql.toString() );
    
		return sql;
	}

	private String tokenizar(StringTokenizer tok) throws Exception{
		String str = tok.nextToken();
		
		return str;
	}
  

  private Vector obtieneTipos(String cadena) throws Exception{
        System.out.println("------ Entrando a obtiene Tipos --------");
        RecordSet tiposCliente = new RecordSet();
        RecordSet subTipos = new RecordSet();
        Vector vSubTipos = new Vector();
        Long[] subtipos = null;

        Vector vTipos = new Vector();
        Vector vSubtipos = new Vector();
        
        tiposCliente.setColumnCount(2);
        subTipos.setColumnCount(3);
        Vector vTiposCol = new Vector();
        vTiposCol.add("OID_CLIENTE");
        vTiposCol.add("DESC_CLIENTE");
        tiposCliente.setColumnIdentifiers( vTiposCol );

        vTiposCol = new Vector();
        vTiposCol.add("OID_CLIENTE");
        vTiposCol.add("OID_SUBTIPO");
        vTiposCol.add("DESC_CLIENTE");        
        subTipos.setColumnIdentifiers(vTiposCol);

        StringTokenizer tok = new StringTokenizer(cadena, ";");
        StringTokenizer tokCampo = null;
        String valor = null;
        String sCampo = null;
        int contadorFilas = 0;
        int contadorCampos = 0;
        //traza("Entra al while");
        //traza("Fila: " + contadorFilas); // Seria 0. 
        while ( tok.hasMoreTokens() )
        {
          int i = 0; // Se procesa el token cuando i = 0 e i = 2 (Id Cliente y Descripcion).
          sCampo = tok.nextToken();
          //traza("sCampo: " + sCampo);
          tokCampo = new StringTokenizer(sCampo, "=");
          while ( tokCampo.hasMoreTokens() )  // Proceso el 4campo actual.
          {
              //traza("Procesa campo " + contadorCampos);
              //traza("el campo es " + valor);
              valor = tokCampo.nextToken();
              
              valor = tokCampo.nextToken();
              if ( contadorCampos == 0 ){ // Se tiene el Oid Tipo 
                  //traza("es campo0");
                tiposCliente.setRowCount( tiposCliente.getRowCount()+1 );
                subTipos.setRowCount( subTipos.getRowCount()+1);
                tiposCliente.setValueAt(valor, contadorFilas, 0);
                subTipos.setValueAt(valor, contadorFilas, 0);
              }

              if ( contadorCampos == 1) {// Se tiene el Oid Subtipo
                //traza("es campo2");
                if(!(valor.equals(" ") || !(valor == null))){
                   
                   vSubTipos.add(new Long(valor));
                   subTipos.setValueAt(valor, contadorFilas, 1);
                }else{
                   
                   vSubTipos.add(null);
                   subTipos.setValueAt(valor, contadorFilas, 1);
                }
              }

              if ( contadorCampos == 2) // Se tiene la Desc Tipo
                tiposCliente.setValueAt(valor, contadorFilas, 1);

              if ( contadorCampos == 3) // Se tiene la Desc Subtipo
                subTipos.setValueAt(valor, contadorFilas, 2);
              
          }
          contadorCampos++;

          if (contadorCampos == 4)
          {
            contadorFilas++;
            contadorCampos = 0;
            
          }


        }

        // Arma el array Long[] con los oid Subtipos
        Long[] sRetorno = (Long[]) vSubTipos.toArray( new Long[vSubTipos.size()] );
        //traza("tiposCliente: " + tiposCliente);
        //traza("subTipos: " + subTipos);

        Vector v = new Vector();
        v.add(tiposCliente);
        v.add(subTipos);
        v.add(sRetorno);

        return v;
        
      
    }

     private void crearListaLP(Vector nomColumns, int cantColumns, String nomCapa, String nomLista, String XCapa, String YCapa) throws Exception {
        //traza("dentro de crearListaLP()  " + nomColumns + " " + cantColumns);
        Document document = getXML();

        Element eCapa = document.createElement("CAPA");
        eCapa.setAttribute("nombre", nomCapa);
        eCapa.setAttribute("alto", "162");
        eCapa.setAttribute("ancho", "580");
        eCapa.setAttribute("colorf", "");
        eCapa.setAttribute("borde", "1");
        eCapa.setAttribute("imagenf", "");
        eCapa.setAttribute("repeat", "");
        eCapa.setAttribute("padding", "");
        eCapa.setAttribute("visibilidad", "hidden");
        eCapa.setAttribute("contravsb", "");
        eCapa.setAttribute("zindex", "");
        eCapa.setAttribute("x", XCapa);
        eCapa.setAttribute("y", YCapa);

        Element eLista = document.createElement("LISTA");

        eLista.setAttribute("seleccion", "boton");
        eLista.setAttribute("nombre", nomLista);
        eLista.setAttribute("ancho", "580");
        eLista.setAttribute("alto", "150");
        eLista.setAttribute("multisel", "0");
        eLista.setAttribute("incy", "1");
        eLista.setAttribute("incx", "10");
        eLista.setAttribute("colorf", "#EFEFEF");
        eLista.setAttribute("imagenoff", "close_no.gif");
        eLista.setAttribute("imagenon", "close_up.gif");
        eLista.setAttribute("accion", "");
        eLista.setAttribute("sep", "|");
        eLista.setAttribute("pixelsborde", "3");
        eLista.setAttribute("colorborde", "#CCCCCC");

        Element eCABECERA = document.createElement("CABECERA");
        eCABECERA.setAttribute("nombre", "cabecera");
        eCABECERA.setAttribute("height", "20");

        Integer anchoCab;

        if (cantColumns < 4) {
            anchoCab = new Integer(580 / cantColumns);
        } else {
            anchoCab = new Integer(150);
        }

        Element eCOL_1 = document.createElement("COL");
        eCOL_1.setAttribute("id", "fondoCabecera");
        eCOL_1.setAttribute("ancho", anchoCab.toString());

        Element eCOL_2 = document.createElement("COL");
        eCOL_2.setAttribute("id", "fondoCabecera");
        eCOL_2.setAttribute("ancho", anchoCab.toString());

        Element eCOL_3 = document.createElement("COL");
        eCOL_3.setAttribute("id", "fondoCabecera");
        eCOL_3.setAttribute("ancho", anchoCab.toString());

        Element eCOL_4 = document.createElement("COL");
        eCOL_4.setAttribute("id", "fondoCabecera");
        eCOL_4.setAttribute("ancho", anchoCab.toString());

        Element eCOL_5 = document.createElement("COL");
        eCOL_5.setAttribute("id", "fondoCabecera");
        eCOL_5.setAttribute("ancho", anchoCab.toString());

        Element eCOL_6 = document.createElement("COL");
        eCOL_6.setAttribute("id", "fondoCabecera");
        eCOL_6.setAttribute("ancho", anchoCab.toString());

        Vector columnas = new Vector();

        for (int i = 0; i < cantColumns; i++) {
            Element eLABEL_2 = document.createElement("LABELC");
            eLABEL_2.setAttribute("id", "fondoCabecera");
            eLABEL_2.setAttribute("nombre", "lbDivisionesPoliticas" + i);
            eLABEL_2.setAttribute("ancho", anchoCab.toString());
            eLABEL_2.setAttribute("alto", "20");
            eLABEL_2.setAttribute("filas", "1");
            eLABEL_2.setAttribute("id", "datosCamposCabecera");

            if (i != 0) {
                eLABEL_2.setAttribute("valor", (String) nomColumns.get(i));
            } else {
                eLABEL_2.setAttribute("cod", "199");
            }

            eLABEL_2.setAttribute("enviaroculto", "N");
            columnas.add(eLABEL_2); //Agrego label a la columna
        }

        //traza("despues de poner en variables los titulos " + columnas + " " +      cantColumns);
        if (cantColumns >= 1) {
            eCOL_1.appendChild((Element) columnas.get(0));
            eCABECERA.appendChild(eCOL_1);

        }

        if (cantColumns >= 2) {
            eCOL_2.appendChild((Element) columnas.get(1));
            eCABECERA.appendChild(eCOL_2);


        }

        if (cantColumns >= 3) {
            eCOL_3.appendChild((Element) columnas.get(2));
            eCABECERA.appendChild(eCOL_3);


        }

        if (cantColumns >= 4) {
            eCOL_4.appendChild((Element) columnas.get(3));
            eCABECERA.appendChild(eCOL_4);


        }

        if (cantColumns >= 5) {
            eCOL_5.appendChild((Element) columnas.get(4));
            eCABECERA.appendChild(eCOL_5);


        }

        if (cantColumns >= 6) {
            eCOL_6.appendChild((Element) columnas.get(5));
            eCABECERA.appendChild(eCOL_6);


        }

        Element ePRESENTACION = document.createElement("PRESENTACION");
        Integer ancho = new Integer(cantColumns * anchoCab.intValue());
        ePRESENTACION.setAttribute("ancho", ancho.toString());
        ePRESENTACION.setAttribute("filas", "1");

        int swX1 = 0;
        StringBuffer cadena = new StringBuffer("['datosCamposCenterImpar'");

        for (int i = 1; i < cantColumns; i++) {
            if (swX1 == 0) {
                cadena.append(", 'datosCamposCenterPar'");
                swX1 = 1;
            } else {
                cadena.append(", 'datosCamposCenterImpar'");
                swX1 = 0;
            }
        }

        for (int i = 0; i < cantColumns; i++) {
            Element eCOLP_2 = document.createElement("COL");
            eCOLP_2.setAttribute("ancho", anchoCab.toString());
            eCOLP_2.setAttribute("caracteres", "150");
            ePRESENTACION.appendChild(eCOLP_2); //Agrego columna a la presentacion
        }

        cadena.append("]");


        ePRESENTACION.setAttribute("bloquesid", cadena.toString());

        Element eROWSET = document.createElement("ROWSET");

        eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
        eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
        eLista.appendChild(eROWSET); //Agrego el rowset de la lista

        eCapa.appendChild(eLista);

        getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);
   }

   private Long toHoraAsLong(String sHora) throws Exception
   {
     // by Ssantana 
     // Recibe una hora de formato HH:mm y devuelve un Long
     // cuyo valor representa esa hora. 

     SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");

     java.util.Date fecha = simpleDate.parse(sHora);

     Long time = new Long(fecha.getTime());


     return time;
     
   }

}
   
