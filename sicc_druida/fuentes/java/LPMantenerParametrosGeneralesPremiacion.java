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
 * Autor: Viviana Bongiovanni
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOArticulo;
import es.indra.sicc.dtos.inc.DTOBuscarNumConcurso;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOLotesPremio;
import es.indra.sicc.dtos.inc.DTONivelPremiacion;
import es.indra.sicc.dtos.inc.DTONivelesPremiacion;
import es.indra.sicc.dtos.inc.DTOPagoMonetario;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.dtos.inc.DTOPedidoPremiar;
import es.indra.sicc.dtos.inc.DTOPremioArticulo;
import es.indra.sicc.dtos.inc.DTOPremioDescuento;
import es.indra.sicc.dtos.inc.DTOPremioMonetario;
import es.indra.sicc.dtos.inc.DTOPremioPuntos;
import es.indra.sicc.dtos.inc.DTOProductosLote;
import es.indra.sicc.dtos.inc.DTOProgramaNuevas;
import es.indra.sicc.dtos.pre.DTOEBuscarProductos;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

/**
 * @author Administrador
 *
 */
public class LPMantenerParametrosGeneralesPremiacion extends LPIncentivos {

	// sapaza -- PER-SiCC-2011-0295 -- 17/06/2011
	String oidVigenciaConcurso;

	  
  // vbongiov -- Cambio 20090930 -- 16/07/2009
  public static String replace(String s, String s1, String s2){	
	
	int i = 0;
	int j = 0;
	int k = s1.length();
	StringBuffer stringbuffer = null;
	String s3 = s;
	while((j = s.indexOf(s1, i)) >= 0) 
	{
		if(stringbuffer == null)
		{
			stringbuffer = new StringBuffer(s.length() * 2);
		}
		stringbuffer.append(s.substring(i, j));
		stringbuffer.append(s2);
		i = j + k;
	}
	if(i != 0/* && i != 1 && i != 2*/)
	{
		stringbuffer.append(s.substring(i));
		s3 = stringbuffer.toString();
	}

	return s3;
}

         DTOConcurso dtoConcurso = null;  

         public LPMantenerParametrosGeneralesPremiacion()  {
           super();
         }

         private RecordSet agregarBlanco(DTOSalida dtoSalida) throws Exception{
		      RecordSet tipoPremioQuery = null;
		      RecordSet tipoPremio = new RecordSet();
		      
		      if(dtoSalida!=null){
		           tipoPremioQuery = dtoSalida.getResultado();
		           
		           tipoPremio.setColumnIdentifiers(tipoPremioQuery.getColumnIdentifiers());
		           
		           tipoPremio.addRow(new Object[] {"", ""});
		           
		           for(int i=0; i < tipoPremioQuery.getRowCount(); i++){
		                tipoPremio.addRow(tipoPremioQuery.getRow(i));
		           }
		      }
		      return tipoPremio;
		  }
  

  public void almacenar() throws Exception {  
  
      if(this.opcionMenu.equals("nueva version")){
           this.pagina("salidaGenerica");
      } else {
           this.traza("sin salidaGenerica");
      }
      
      try {
           //Obtengo el concurso de session
           this.dtoConcurso = super.getConcurso();
    
           String datosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true);        
           String oidParamGralesPremiacion = this.conectorParametroLimpia("oidParamGralesPremiacion", "", true);   
           
                    String cbTipoSeleccion = this.conectorParametroLimpia("hCbTipoSeleccion", "", true);    
           
                    String txtNumNiveles = this.conectorParametroLimpia("txtNumNiveles", "", true);        
           String ckPeriodoDespacho = this.conectorParametroLimpia("ckPeriodoDespacho", "", true);        
           String cbPeriodo = this.conectorParametroLimpia("cbPeriodo", "", true);        
           
           String cbPeriodoInicio = this.conectorParametroLimpia("cbPeriodoInicio", "", true);
           
           String txtNumPeriodoObtencion = this.conectorParametroLimpia("txtNumPeriodoObtencion", "", true);        
           String ckComunicacion = ""; //this.conectorParametroLimpia("ckComunicacion", "", true);        
           String txtMensaje = ""; //this.conectorParametroLimpia("txtMensaje", "", true);        
           String ckPremioElectivo = this.conectorParametroLimpia("ckPremioElectivo", "", true);        
           String cbTipoEleccion = this.conectorParametroLimpia("cbTipoEleccion", "", true);   
           
            String ckPremiosAcumulativosNiveles = this.conectorParametroLimpia("ckPremiosAcumulativosNiveles", "", true);    
            //AGREGADO
            String txtHastaNivel = this.conectorParametroLimpia("txtHastaNivel", "", true);    
            //FIN AGREGADO
           String ckNivelesRotativos = this.conectorParametroLimpia("ckNivelesRotativos", "", true);        
           String txtNumRotaciones = this.conectorParametroLimpia("txtNumRotaciones", "", true);        
           String ckAccesoNivelPremioSuperior = this.conectorParametroLimpia("ckAccesoNivelPremioSuperior", "", true);      

           // vbongiov -- Cambio 20080811 -- 26/08/2009
		   String txtCantidadNumerosAOtorgar = this.conectorParametroLimpia("txtCantidadNumerosAOtorgar", "", true);      
		   String txtCodProducto = this.conectorParametroLimpia("txtCodProducto", "", true);      
		   String oidProducto = this.conectorParametroLimpia("oidProducto", "", true);      
           
		   // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
           String ckSinPremioPorDefecto = this.conectorParametroLimpia("ckSinPremioPorDefecto", "", true);
		   
           DTONivelesPremiacion dtoNivelesPremiacion = null;
           
           // Guardo los datos ingresados en el dtoConcurso
           this.dtoConcurso.setIndPremios(Boolean.TRUE);
           this.traza("datosObligatorios: " + datosObligatorios);
           this.dtoConcurso.setIndObligPremios(datosObligatorios.equals("true")?Boolean.TRUE:Boolean.FALSE);
           
           DTOParametrosGeneralesPremiacion dtoParamGenerPrem = new DTOParametrosGeneralesPremiacion();
           
           dtoParamGenerPrem.setOidPais(UtilidadesSession.getPais(this));            
           dtoParamGenerPrem.setOidParamGralesPremiacion(oidParamGralesPremiacion.equals("")?null:new Long(oidParamGralesPremiacion));
           dtoParamGenerPrem.setOidTipoPremiacion(cbTipoSeleccion.equals("")?null:new Long(cbTipoSeleccion));
           dtoParamGenerPrem.setNroNiveles(txtNumNiveles.equals("")?null:new Integer(txtNumNiveles));
           dtoParamGenerPrem.setIndPeriodoDespacho(ckPeriodoDespacho.equals("S")?Boolean.TRUE:Boolean.FALSE);
           dtoParamGenerPrem.setOidPeriodo(cbPeriodo.equals("")?null:new Long(cbPeriodo));
           
           //sapaza -- PER-SiCC-2010-0210 -- 27/04/2010
           dtoParamGenerPrem.setOidPeriodoInicio(cbPeriodoInicio.equals("")?null:new Long(cbPeriodoInicio));
           
           dtoParamGenerPrem.setNroPeriodosObtencion(txtNumPeriodoObtencion.equals("")?null:new Integer(txtNumPeriodoObtencion));
           dtoParamGenerPrem.setIndComunicacion(ckComunicacion.equals("S")?Boolean.TRUE:Boolean.FALSE);
           dtoParamGenerPrem.setMensaje(txtMensaje.equals("")?null:txtMensaje);             
           //Modificado por Cristian Valenzuela - 17/2/2006 - INC - 22630
           dtoParamGenerPrem.setIndPremiosElectivos(ckPremioElectivo.equals("S")?Boolean.TRUE:Boolean.FALSE);
           dtoParamGenerPrem.setOidTipoEleccion(cbTipoEleccion.equals("")?null:new Long(cbTipoEleccion));
           
           // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
           dtoParamGenerPrem.setIndSinPremioPorDefecto(ckSinPremioPorDefecto.equals("S")?Boolean.TRUE:Boolean.FALSE);
           
           if(!cbTipoSeleccion.equals("") && cbTipoSeleccion.equals(ConstantesINC.OID_TIPO_PREM_NIVELES.toString())) {
                this.traza("niveles");
                dtoParamGenerPrem.setIndPremiosAcumulativosNiveles(ckPremiosAcumulativosNiveles.equals("S")?Boolean.TRUE:Boolean.FALSE);
                             //AGREGADO
                             dtoParamGenerPrem.setHastaNivel(txtHastaNivel.equals("")?null:new Integer(txtHastaNivel));			  
                             //FIN AGREGADO
                dtoParamGenerPrem.setIndNivelesRotativos(ckNivelesRotativos.equals("S")?Boolean.TRUE:Boolean.FALSE);
                dtoParamGenerPrem.setNroRotaciones(txtNumRotaciones.equals("")?null:new Integer(txtNumRotaciones));
                dtoParamGenerPrem.setIndAccesoNivelPremioSuperior(ckAccesoNivelPremioSuperior.equals("S")?Boolean.TRUE:Boolean.FALSE);
                
           // vbongiov -- Cambio 20080811 -- 26/08/2009
           } else if(!cbTipoSeleccion.equals("") && cbTipoSeleccion.equals(ConstantesINC.OID_TIPO_PREMIACION_SORTEO.toString())) {
				this.traza("sorteo");
				dtoParamGenerPrem.setCantidadNumerosAOtorgar(txtCantidadNumerosAOtorgar.equals("")?null:new Integer(txtCantidadNumerosAOtorgar));
				dtoParamGenerPrem.setCodProducto(txtCodProducto);
				dtoParamGenerPrem.setOidProducto(oidProducto.equals("")?null:new Long(oidProducto));

		   } else {
                this.traza("bolsa");
                dtoParamGenerPrem.setIndPremiosAcumulativosNiveles(Boolean.FALSE);
                             //AGREGADO
                             dtoParamGenerPrem.setHastaNivel(null);
                             //FIN AGREGADO
                dtoParamGenerPrem.setIndNivelesRotativos(Boolean.FALSE);
                dtoParamGenerPrem.setNroRotaciones(null);
                dtoParamGenerPrem.setIndAccesoNivelPremioSuperior(Boolean.FALSE);
           }
                    //FIN - Modificado por Cristian Valenzuela - 17/2/2006 - INC - 22630
           
           // Obtiene los niveles de premiacion
           dtoNivelesPremiacion = this.getNivelesPremiacion();
          
           // Guarda el numero de premio maximo
           if(dtoNivelesPremiacion!= null) {                
                dtoParamGenerPrem.setNumeroPremio(dtoNivelesPremiacion.getNumeroPremioMax());
           }
                    else {
                dtoParamGenerPrem.setNumeroPremio(Integer.valueOf("0"));
           }
                  
           this.traza("DTOParametrosGeneralesPremiacion: " + dtoParamGenerPrem);
           // Guarda los parametros generales de premiacion
           this.dtoConcurso.setParamGralesPremiacion(dtoParamGenerPrem);    
           
           this.traza("DTONivelesPremiacion: " + dtoNivelesPremiacion);   
           // Guarda los niveles de premiacion
           if(dtoNivelesPremiacion!=null) {
                this.dtoConcurso.setIndNivelPremiacion(Boolean.TRUE);
                this.dtoConcurso.setListaNivelesPremiacion(dtoNivelesPremiacion);
                
           } else {
                this.dtoConcurso.setIndNivelPremiacion(Boolean.FALSE);
                this.dtoConcurso.setListaNivelesPremiacion(null);
           }
           
           // Guarda en session el concurso
           if(this.opcionMenu.equals("nueva version")){
              this.conectorParametroSesion("dtoConcursoBufferSS", this.dtoConcurso); 
              this.traza("dtoConcurso final: " + this.dtoConcurso);
           } else {
                super.setConcurso(this.dtoConcurso);
                this.traza("dtoConcurso final: " + super.getConcurso());
           }
           
           // Cierra la ventana modal
           if(this.opcionMenu.equals("nueva version")){
                this.asignarAtributo("VAR", "ejecutar", "valor", "cerrarModal()");
           }
           
      } catch(Exception e){
          if(this.opcionMenu.equals("nueva version")){
             this.asignarAtributo("VAR", "ejecutarError", "valor", "focaliza('formulario.cbTipoSeleccion');");
          }
                              throw e;
                    }	
  }  

  public void almacenarNivel() throws Exception {
         
      pagina("salidaGenerica");
      
      try{
           //Obtengo el concurso de session
           this.dtoConcurso = super.getConcurso();
           
           String listaDatosNiveles = this.conectorParametroLimpia("listaDatosNiveles", "", true);        
           String datosNiveles = this.conectorParametroLimpia("datosNiveles", "", true);   
           String oidTipoDeterminacionMetas = this.conectorParametroLimpia("hOidTipoDeterminacionMetas", "", true);   
           this.opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);     
           
           DTONivelesPremiacion dtoNivelesPremiacion = new DTONivelesPremiacion();
           ArrayList arrLstNivelesPremiacion = new ArrayList();
           ArrayList arrLstNumeroNiveles = new ArrayList();
           
           // Guardo el numero de premio maximo
           Vector numeroPremioM = new Vector();
           Integer numeroPremioMax = new Integer(0);     
           numeroPremioM.add(numeroPremioMax);
           
           if(!listaDatosNiveles.equals("")) {
           
                StringTokenizer stkListaDatosNiveles = new StringTokenizer(listaDatosNiveles,"---");
                StringTokenizer stkDatosNiveles = new StringTokenizer(datosNiveles,"%%%");
                
                StringTokenizer stkRegNiveles = null;
                DTONivelPremiacion dtoNivelPremiacion = null;
                
                String premio = null;
                DTOPremioPuntos dtoPremioPuntos = null;
                DTOPremioMonetario dtoPremioMonetario = null;
                DTOPremioDescuento dtoPremioDescuento = null;
                DTOPremioArticulo dtoPremioArticulo = null;           
              
                String numNivel = null;
                String puntajeServ = null;
                Long tipoPremio = null;
                String descTipoPremio = null;
                String nivelElegible = null;
                String cantFijaPuntos = null;
                String cantDesde = null;
                String cantHasta = null;
                String puntosProdExigidos = null;
                String numAspirantes = null;
                String oidPremio = null;
				String descripcionNivel = null;
                
                // Recorre los registros
                while (stkListaDatosNiveles.hasMoreTokens()) {
                    stkRegNiveles = new StringTokenizer(stkListaDatosNiveles.nextToken(),"###");
                    dtoNivelPremiacion = new DTONivelPremiacion();
                    
                    numNivel = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setNumeroNivel(numNivel.equals("BLANCO")?null:Integer.valueOf(numNivel));
                    
                    // Se guarda para la validacion de consultoras nuevas
                    arrLstNumeroNiveles.add(Integer.valueOf(numNivel));
                    
                    puntajeServ = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setPuntajeServicio(puntajeServ.equals("BLANCO")?null:Integer.valueOf(this.desFormatearNumero(puntajeServ, this.FORMATO_DEFAULT)));
                    
                    tipoPremio = Long.valueOf(stkRegNiveles.nextToken());
                    dtoNivelPremiacion.setOidTipoPremio(tipoPremio);
                    
                    descTipoPremio = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setDescripcion(descTipoPremio);
                    
                    nivelElegible = stkRegNiveles.nextToken();
                    nivelElegible = nivelElegible.equals("BLANCO")?null:nivelElegible;
                    dtoNivelPremiacion.setIndNivelSelectivo(nivelElegible.equals("S")?Boolean.TRUE:Boolean.FALSE);
                    
                    cantFijaPuntos = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setCantidadFijaPuntos(cantFijaPuntos.equals("BLANCO")?null:Integer.valueOf(this.desFormatearNumero(cantFijaPuntos, this.FORMATO_DEFAULT)));
                    
                    cantDesde = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setCantidadDesde(cantDesde.equals("BLANCO")?null:Integer.valueOf(this.desFormatearNumero(cantDesde, this.FORMATO_DEFAULT)));
                    
                    cantHasta = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setCantidadHasta(cantHasta.equals("BLANCO")?null:Integer.valueOf(this.desFormatearNumero(cantHasta, this.FORMATO_DEFAULT)));
                    
                    puntosProdExigidos = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setPuntosProductosExigidos(puntosProdExigidos.equals("BLANCO")?null:Integer.valueOf(this.desFormatearNumero(puntosProdExigidos, this.FORMATO_DEFAULT)));
                    
                    numAspirantes = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setNumeroAspirantes(numAspirantes.equals("BLANCO")?null:Integer.valueOf(numAspirantes));
                    
                    oidPremio = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setOid(oidPremio.equals("BLANCO")?null:Long.valueOf(oidPremio));

					// vbongiov -- Cambio 20090930 -- 16/07/2009
					descripcionNivel = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setDescripcionNivel(descripcionNivel.equals("BLANCO")?null:descripcionNivel);
             
                    // Almacena los datos del premio
                    premio = stkDatosNiveles.nextToken();
                    
                    if(tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_PUNTOS)){
                         // Almacena el Premio Puntos
                         dtoPremioPuntos = this.almacenarPremioPuntos(premio, numeroPremioM);
                         
                         this.traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
                         
                         dtoNivelPremiacion.setIndPremiosPuntos(Boolean.TRUE);
                         dtoNivelPremiacion.setIndPremiosDescuento(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosArticulos(Boolean.FALSE);
                         
                         dtoNivelPremiacion.setPremioPuntos(dtoPremioPuntos);            
                         
                    } else if(tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_DESCUENTO)){
                         // Almacena el Premio Descuento
                         dtoPremioDescuento = this.almacenarPremioDescuento(premio, numeroPremioM);
                         
                         this.traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
                         
                         dtoNivelPremiacion.setIndPremiosDescuento(Boolean.TRUE);
                         dtoNivelPremiacion.setIndPremiosPuntos(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosArticulos(Boolean.FALSE);
                         
                         dtoNivelPremiacion.setPremioDescuento(dtoPremioDescuento); 
                         
                    } else if(tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_MONETARIO)){
                         // Almacena el Premio Monetario
                         dtoPremioMonetario = this.almacenarPremioMonetario(premio, numeroPremioM, oidTipoDeterminacionMetas, numNivel);
                         
                         this.traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
                         
                         dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.TRUE);
                         dtoNivelPremiacion.setIndPremiosDescuento(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosPuntos(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosArticulos(Boolean.FALSE);
                         
                         dtoNivelPremiacion.setPremioMonetario(dtoPremioMonetario); 
                         
                    } else if(tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_ARTICULO)){
                         // Almacena el Premio Articulos
                         dtoPremioArticulo = this.almacenarPremioArticulo(premio, numeroPremioM);
                         
                         this.traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
                         
                         dtoNivelPremiacion.setIndPremiosArticulos(Boolean.TRUE);
                         dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosDescuento(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosPuntos(Boolean.FALSE);
                         
                         dtoNivelPremiacion.setPremioArticulo(dtoPremioArticulo); 
                    }
                    
                    this.traza("dtoNivelPremiacion nivel: " + numNivel);
                    this.traza("dtoNivelPremiacion valor: " + dtoNivelPremiacion);
                    
                    // Almacena el registro de nivel
                    arrLstNivelesPremiacion.add(dtoNivelPremiacion);                
                
                }           
           }
           
           // Validacion de numero de niveles para consultoras
           String mensaje = "N";
           
           if(arrLstNumeroNiveles.size()!=0 && this.dtoConcurso.getIndProgramaNuevas().booleanValue()) {
                this.traza("valido nuevas");
                boolean eliminar = false;
                ArrayList arrLstPedidosPremiar = null;
                
                DTOProgramaNuevas dtoProgramaNuevas = this.dtoConcurso.getProgramaNuevas();
                arrLstPedidosPremiar = dtoProgramaNuevas.getListaPedidosPremiar();
                
                if(arrLstPedidosPremiar.size()!=0){
                
                    int cant = arrLstPedidosPremiar.size();
                    DTOPedidoPremiar dtoPedidoPremiar = null;
                    Integer numeroNivelNuevas = null;
                    int cantNiveles = arrLstNumeroNiveles.size();
                    Integer numeroNivel = null;
                
                    for(int i=0; i<cant; i++ ){
                         dtoPedidoPremiar = (DTOPedidoPremiar)arrLstPedidosPremiar.get(i);
                         this.traza("dtoPedidoPremiar: " + dtoPedidoPremiar);
                         numeroNivelNuevas = dtoPedidoPremiar.getOidNivelPremiacion()!=null?new Integer(dtoPedidoPremiar.getOidNivelPremiacion().toString()):null;
                         boolean existe = false;
                         
                                                // vbongiov -- 20/10/2006 -- DBLG700000134
                                                if (numeroNivelNuevas != null){
                                                         for(int j=0; j<cantNiveles; j++){
                                                                  numeroNivel = (Integer)arrLstNumeroNiveles.get(j);
                                                                  if(numeroNivel.equals(numeroNivelNuevas)) {
                                                                           existe = true;
                                                                           break;
                                                                  } 
                                                         }
                                                } else {
                                                         existe = true;
                                                }

                         
                         this.traza("existe: " + existe);
                         
                         if(!existe) {
                             eliminar = true;
                             break;
                         }                         
                    }
                    
                    // El nivel ha sido eliminado se limpian los datos de programas nuevas
                    if(eliminar){
                         if(!this.opcionMenu.equals("nueva version")){
                             this.traza("eliminar nuevas");
                             this.dtoConcurso.setIndProgramaNuevas(Boolean.FALSE);
                             this.dtoConcurso.setIndObligProgramaNuevas(Boolean.FALSE);
                             this.dtoConcurso.setProgramaNuevas(null);
                             
                             mensaje = "S";
                             
                         } else {
                             throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + "0342"));     
                         }
                    }
                }
                
           } else if(arrLstNumeroNiveles.size()==0 && this.dtoConcurso.getIndProgramaNuevas().booleanValue()) {
                // No hay ningun nivel definido
                this.traza("valido nuevas - No hay ningun nivel definido");
                if(!this.opcionMenu.equals("nueva version")){
                    this.dtoConcurso.setIndProgramaNuevas(Boolean.FALSE);
                    this.dtoConcurso.setIndObligProgramaNuevas(Boolean.FALSE);
                    this.dtoConcurso.setProgramaNuevas(null);
                    
                    mensaje = "S";
                
                }  else {
                    throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + "0342"));     
                }
           }
           
           
           // Convierte el ArrayList en DTONivelPremiacion[]
           dtoNivelesPremiacion.setListaNiveles((DTONivelPremiacion[])arrLstNivelesPremiacion.toArray(new DTONivelPremiacion[0]));        
           
           this.traza("niveles length: " + dtoNivelesPremiacion.getListaNiveles().length);
           this.traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
           
           // Almacena el numero de premio maximo
           dtoNivelesPremiacion.setNumeroPremioMax((Integer)numeroPremioM.get(0));
                    dtoNivelesPremiacion.setOidPais(UtilidadesSession.getPais(this));
           
           // Guarda el DTONivelesPremiacion
           this.setNivelesPremiacion(dtoNivelesPremiacion);
           
           // Cierra la ventana modal
           this.asignarAtributo("VAR", "ejecutar", "valor", "cerrarModal('" + mensaje.toString() + "')");
           
      } catch(Exception e){
                              this.asignarAtributo("VAR", "ejecutarError", "valor", "errorAlmacenarNivel()");
                              throw e;
                    }	
      
  }
  
  
  public DTOPremioArticulo almacenarPremioArticulo(String premioArticulo, Vector numeroPremioM) throws Exception {
      /*  0-ind
           1-tipoPremiacion
           2-oidPremioArticulos
           3-listaLotes  
      */
     
      String oidPremioArticulo = null;
      String listaLotes = null;
      
      this.traza("premioArticulo: " + premioArticulo);
           
      StringTokenizer stkPremioArt = new StringTokenizer(premioArticulo,"###");
      DTOPremioArticulo dtoPremioArticulo = new DTOPremioArticulo();
      
      dtoPremioArticulo.setOidPais(UtilidadesSession.getPais(this));
      
      this.traza("oid: " + stkPremioArt.nextToken());
      this.traza("tipo Premio: " + stkPremioArt.nextToken());
             
      dtoPremioArticulo.setNumeroUnidadesPremioArticulo(Integer.valueOf(stkPremioArt.nextToken()));
      
      oidPremioArticulo = stkPremioArt.nextToken();
      dtoPremioArticulo.setOidPremioArticulo(oidPremioArticulo.equals("BLANCO")?null:Long.valueOf(oidPremioArticulo));
    
         
      // Almacena la lista de lotes
      listaLotes = stkPremioArt.nextToken(); 
      this.traza("listaLotes: " + listaLotes);
      
      if(!listaLotes.equals("BLANCO")){
      
           ArrayList arrLstLotes = new ArrayList();
           ArrayList arrLstProdLotes = null;
           StringTokenizer stkLotes = new StringTokenizer(listaLotes,":::");
           StringTokenizer stkLote = null;
           String listaProdLotes = null;
           StringTokenizer stkProdArticulo = null;
           StringTokenizer stkProd = null;
           DTOLotesPremio dtoLotesPremio = null;
           DTOProductosLote dtoProductosLote = null;
         
           String numeroPremio = null;
           String despachoArticulo = null;
           String codVentaFicticio = null;
           String oidProducto = null;
           String oidProdLote = null;
           String oidLote = null;
           String indCentSerGar = null;    
           String numMeses = null;
           String obs = null;
           String oidCentSerGar = null;
           String oidCentSerEntrega = null;
           
           while (stkLotes.hasMoreTokens()) {
           
                stkLote = new StringTokenizer(stkLotes.nextToken(),";;;");
                dtoLotesPremio = new DTOLotesPremio();
                
                numeroPremio = stkLote.nextToken();
                dtoLotesPremio.setNumeroPremio(Integer.valueOf(numeroPremio));  
                
                // Obtiene el numero de premio maximo
                if(((Integer)numeroPremioM.get(0)).intValue() < Integer.valueOf(numeroPremio).intValue()){
                   numeroPremioM.set(0,Integer.valueOf(numeroPremio)); 
                }
                
                dtoLotesPremio.setDescripcionLote(stkLote.nextToken());  
                
                listaProdLotes = stkLote.nextToken();
                this.traza("listaProdLotes: " + listaProdLotes);
                
                oidLote = stkLote.nextToken();
                dtoLotesPremio.setOidLotePremio(oidLote.equals("BLANCO")?null:Long.valueOf(oidLote));
                
                arrLstProdLotes = new ArrayList();
                
                if(!listaProdLotes.equals("BLANCO")){
                
                    stkProdArticulo = new StringTokenizer(listaProdLotes,"---");
                    
                    while (stkProdArticulo.hasMoreTokens()) {
           
                         stkProd = new StringTokenizer(stkProdArticulo.nextToken(),"&&&");
                         dtoProductosLote = new DTOProductosLote();
                         
                         dtoProductosLote.setCodigoProducto(stkProd.nextToken());  

  					 	 // vbongiov -- Cambio 20090930 -- 16/07/2009
						 dtoProductosLote.setDescProducto(stkProd.nextToken());  
                         
                         dtoProductosLote.setNumeroUnidades(Integer.valueOf(this.desFormatearNumero(stkProd.nextToken(), this.FORMATO_DEFAULT)));  
                         
                         dtoProductosLote.setPrecioPublico(new BigDecimal(this.desFormatearNumero(stkProd.nextToken(), this.FORMATO_MONEDA)));  
                         
                         despachoArticulo = stkProd.nextToken();
                         dtoProductosLote.setIndDespachaArticulo(despachoArticulo.equals("S")?Boolean.TRUE:Boolean.FALSE);  
                                                                              
                         codVentaFicticio = stkProd.nextToken();
                         dtoProductosLote.setCodVentaFicticio(codVentaFicticio.equals("BLANCO")?null:codVentaFicticio);  
                         
                         // vbongiov -- 18/09/2007
                         indCentSerGar = stkProd.nextToken();
                         dtoProductosLote.setIndCentroServGar(indCentSerGar.equals("S")?Boolean.TRUE:Boolean.FALSE);
                         
                         dtoProductosLote.setDescCentSerGar(stkProd.nextToken());  
          
                         numMeses = stkProd.nextToken();
                         dtoProductosLote.setNumMeses(numMeses.equals("BLANCO")?null:Integer.valueOf(this.desFormatearNumero(numMeses, this.FORMATO_DEFAULT)));  
          
                         obs = stkProd.nextToken();
                         dtoProductosLote.setObservaciones(obs.equals("BLANCO")?null:obs); 
          
                         dtoProductosLote.setIndTipoEntrega(stkProd.nextToken());  
          
                         dtoProductosLote.setDescCentSerEntrega(stkProd.nextToken());  
          
                         oidCentSerGar = stkProd.nextToken();
                         dtoProductosLote.setOidCentroServGar(oidCentSerGar.equals("BLANCO")?null:Long.valueOf(oidCentSerGar));  
          
                         oidCentSerEntrega = stkProd.nextToken();
                         dtoProductosLote.setOidCentroServEntrega(oidCentSerEntrega.equals("BLANCO")?null:Long.valueOf(oidCentSerEntrega));  
                                   
                         oidProducto = stkProd.nextToken();
                         dtoProductosLote.setOidProducto(oidProducto.equals("BLANCO")?null:Long.valueOf(oidProducto));    
                         
                         oidProdLote = stkProd.nextToken();
                         dtoProductosLote.setOidProductoLote(oidProdLote.equals("BLANCO")?null:Long.valueOf(oidProdLote));      

                                                                 this.traza("ANTES DE ENVIAR LA LISTA DE PRODUCTOS LOTES");
                                                                 this.traza("DTOProductosLote: " + dtoProductosLote);
                        
                         arrLstProdLotes.add(dtoProductosLote);
                    }
                    
                    // Almacena la lista de productos del lote
                    dtoLotesPremio.setLstProductosLote(arrLstProdLotes);
                         
                } else {
                    dtoLotesPremio.setLstProductosLote(null);
                }
                
                // Almacena la lista de productos del lote
                arrLstLotes.add(dtoLotesPremio);
                
           }
           
           // Almacena la lista de lotes
           dtoPremioArticulo.setLstLotesPremio(arrLstLotes);
      
      } else {
           dtoPremioArticulo.setLstLotesPremio(null);
      }
      
      return dtoPremioArticulo;    
  }
  
  
  public DTOPremioDescuento almacenarPremioDescuento(String premioDescuento, Vector numeroPremioM) throws Exception {
      /*  0-ind
           1-tipoPremiacion
           2-numPremio            
           3-tipoPremDesc
           4-cant
           5-porcenj
           6-periodoDesde
           7-periodoHasta
           8-oidPremioDesc
           9-listaArticulos
      */
      String numeroPremio = null;
      String cant = null;
      String porcenj = null;
      String periodoHasta = null;
      String oidPremioDesc = null;
      String listaArticulos = null;
      
      this.traza("premioDescuento: " + premioDescuento);
           
      StringTokenizer stkPremioDesc = new StringTokenizer(premioDescuento,"###");
      DTOPremioDescuento dtoPremioDescuento = new DTOPremioDescuento();
      
      dtoPremioDescuento.setOidPais(UtilidadesSession.getPais(this));
      
      this.traza("oid: " + stkPremioDesc.nextToken());
      this.traza("tipo Premio: " + stkPremioDesc.nextToken());
      
      numeroPremio = stkPremioDesc.nextToken();
      dtoPremioDescuento.setNumeroPremio(Integer.valueOf(numeroPremio));      
      
      dtoPremioDescuento.setOidTipoDescuento(Long.valueOf(stkPremioDesc.nextToken()));
      
      cant = stkPremioDesc.nextToken();
      dtoPremioDescuento.setCantidadDescuento(cant.equals("BLANCO")?null:new BigDecimal(this.desFormatearNumero(cant, this.FORMATO_DEFAULT)));
      
      porcenj = stkPremioDesc.nextToken();
      dtoPremioDescuento.setPorcentajeDescuento(porcenj.equals("BLANCO")?null:new BigDecimal(this.desFormatearNumero(porcenj, this.FORMATO_DEFAULT)));
      
      dtoPremioDescuento.setOidPeriodoAplicacionDesde(Long.valueOf(stkPremioDesc.nextToken()));
      
      periodoHasta = stkPremioDesc.nextToken();
      dtoPremioDescuento.setOidPeriodoAplicacionHasta(periodoHasta.equals("BLANCO")?null:Long.valueOf(periodoHasta));
      
      oidPremioDesc = stkPremioDesc.nextToken();
      dtoPremioDescuento.setOidPremioDescuento(oidPremioDesc.equals("BLANCO")?null:Long.valueOf(oidPremioDesc));
      
      // Obtiene el numero de premio maximo
      if(((Integer)numeroPremioM.get(0)).intValue() < Integer.valueOf(numeroPremio).intValue()){
           numeroPremioM.set(0,Integer.valueOf(numeroPremio)); 
      }
      
      // Almacena la lista de articulos
      listaArticulos = stkPremioDesc.nextToken(); 
      
      if(!listaArticulos.equals("BLANCO")){
      
           ArrayList arrLstArticulos = new ArrayList();
           StringTokenizer stkArticulos = new StringTokenizer(listaArticulos,"---");
           StringTokenizer stkArticulo = null;
           DTOArticulo dtoArticulo = null;
         
           String uniNegDesc = null;
           String negDesc = null;
           String superGenerDesc = null;
           String generDesc = null;
           String codProd = null;
           String oidUniNeg = null;
           String oidNeg = null;
           String oidSuperGener = null;
           String oidGener = null;
           String oidProd = null;
           String oidArticulo = null;
           
           while (stkArticulos.hasMoreTokens()) {
                stkArticulo = new StringTokenizer(stkArticulos.nextToken(),"&&&");
                dtoArticulo = new DTOArticulo();
                
                dtoArticulo.setMarca(stkArticulo.nextToken());  
                
                uniNegDesc = stkArticulo.nextToken();
                dtoArticulo.setUnidadNegocio(uniNegDesc.equals("BLANCO")?null:uniNegDesc);
                
                negDesc = stkArticulo.nextToken();
                dtoArticulo.setNegocio(negDesc.equals("BLANCO")?null:negDesc);
                
                superGenerDesc = stkArticulo.nextToken();
                dtoArticulo.setSupergenerico(superGenerDesc.equals("BLANCO")?null:superGenerDesc);
                
                generDesc = stkArticulo.nextToken();
                dtoArticulo.setGenerico(generDesc.equals("BLANCO")?null:generDesc);
                
                codProd = stkArticulo.nextToken();
                dtoArticulo.setCodigoProducto(codProd.equals("BLANCO")?null:codProd);
                
                dtoArticulo.setOidMarca(Long.valueOf(stkArticulo.nextToken()));  
                
                oidUniNeg = stkArticulo.nextToken();
                dtoArticulo.setOidUnidadNegocio(oidUniNeg.equals("BLANCO")?null:Long.valueOf(oidUniNeg));
                
                oidNeg = stkArticulo.nextToken();
                dtoArticulo.setOidNegocio(oidNeg.equals("BLANCO")?null:Long.valueOf(oidNeg));
                
                oidSuperGener = stkArticulo.nextToken();
                dtoArticulo.setOidSupergenerico(oidSuperGener.equals("BLANCO")?null:Long.valueOf(oidSuperGener));
                
                oidGener = stkArticulo.nextToken();
                dtoArticulo.setOidGenerico(oidGener.equals("BLANCO")?null:Long.valueOf(oidGener));
                
                oidProd = stkArticulo.nextToken();
                dtoArticulo.setOidProducto(oidProd.equals("BLANCO")?null:Long.valueOf(oidProd));
                
                oidArticulo = stkArticulo.nextToken();
                dtoArticulo.setOidProductoDescuento(oidArticulo.equals("BLANCO")?null:Long.valueOf(oidArticulo));
                
                arrLstArticulos.add(dtoArticulo);
           }
           
           dtoPremioDescuento.setLstArticulos(arrLstArticulos);
      
      } else {
           dtoPremioDescuento.setLstArticulos(null);
      }
      
      return dtoPremioDescuento;    
  }
  
  /*
  Modificado por: Cristian Valenzuela
  Fecha: 23/10/2006
  Incidencia: DBLG500000562
  Comentario: Se quita la carga de los combos generico y super generico,
  se reemplaza por una caja de texto y un boton buscar
  */
  
  public DTOPremioMonetario almacenarPremioMonetario(String premioMonetario, Vector numeroPremioM, String oidTipoDeterminacionMetas, String numNivel) throws Exception {
      /*  0-ind
           1-tipoPremiacion
           2-numPremio            
           3-tipoPremMonet
           4-cant
           5-porcenj
           6-oidMoneda
           7-oidFormaPago
           8-oidPremioMonet
           9-pagoPartes
           10-oidCumplimiento
           11-descontarPagos
           12-listaPago
      */
      
      String numeroPremio = null;
      String cant = null;
      String porcenj = null;
      String oidPremioMonet = null;
      String pagoPartes = null;
      String descontarPagosAnticipandos = null;      
      String listaPagos = null;
      
      this.traza("premioMonetario: " + premioMonetario);
           
      StringTokenizer stkPremioMonet = new StringTokenizer(premioMonetario,"###");
      DTOPremioMonetario dtoPremioMonetario = new DTOPremioMonetario();
      
      dtoPremioMonetario.setOidPais(UtilidadesSession.getPais(this));
      
      this.traza("oid: " + stkPremioMonet.nextToken());
      this.traza("tipo Premio: " + stkPremioMonet.nextToken());
      
      numeroPremio = stkPremioMonet.nextToken();
      dtoPremioMonetario.setNumeroPremio(Integer.valueOf(numeroPremio));      
      
      dtoPremioMonetario.setOidTipoPremioMonetario(Long.valueOf(stkPremioMonet.nextToken()));
      
      cant = stkPremioMonet.nextToken();
      dtoPremioMonetario.setCantidad(cant.equals("BLANCO")?null:new BigDecimal(this.desFormatearNumero(cant, this.FORMATO_DEFAULT)));
      
      porcenj = stkPremioMonet.nextToken();
      dtoPremioMonetario.setPorcentaje(porcenj.equals("BLANCO")?null:new BigDecimal(this.desFormatearNumero(porcenj, this.FORMATO_DEFAULT)));
      
      dtoPremioMonetario.setOidMoneda(Long.valueOf(stkPremioMonet.nextToken()));
      
      dtoPremioMonetario.setOidFormaPago(Long.valueOf(stkPremioMonet.nextToken()));
      
      oidPremioMonet = stkPremioMonet.nextToken();
      dtoPremioMonetario.setOidPremioMonetario(oidPremioMonet.equals("BLANCO")?null:Long.valueOf(oidPremioMonet));
      
      // Obtiene el numero de premio maximo
      if(((Integer)numeroPremioM.get(0)).intValue() < Integer.valueOf(numeroPremio).intValue()){
           numeroPremioM.set(0,Integer.valueOf(numeroPremio)); 
      }
      
      // Hay Otros Datos
      if(oidTipoDeterminacionMetas.equals(ConstantesINC.OID_TIPO_DET_METAS_BONO_ANUAL.toString())) {
           // Almacena otros datos
           pagoPartes = stkPremioMonet.nextToken();
           dtoPremioMonetario.setIndPagoPartes(pagoPartes.equals("S")?Boolean.TRUE:Boolean.FALSE);
           
           dtoPremioMonetario.setOidCumplimiento(Long.valueOf(stkPremioMonet.nextToken()));
           
           descontarPagosAnticipandos = stkPremioMonet.nextToken();
           dtoPremioMonetario.setIndDescontarPagosAnticipados(descontarPagosAnticipandos.equals("S")?Boolean.TRUE:Boolean.FALSE);
           
           // Pagos
           listaPagos = stkPremioMonet.nextToken(); 
           
           if(!listaPagos.equals("BLANCO")){
           
                ArrayList arrLstPagos = new ArrayList();
                StringTokenizer stkPagos = new StringTokenizer(listaPagos,"---");
                StringTokenizer stkPago = null;
                DTOPagoMonetario dtoPagoMonetario = null;
             
                String premioPorcj = null;
                BigDecimal premioPorcentaje = null; 
                BigDecimal totalPorcentaje = new BigDecimal(0);
                String oidPago = null;
                
                while (stkPagos.hasMoreTokens()) {
                    stkPago = new StringTokenizer(stkPagos.nextToken(),"&&&");
                    dtoPagoMonetario = new DTOPagoMonetario();
                    
                    dtoPagoMonetario.setNumeroPago(Integer.valueOf(stkPago.nextToken()));  
                    
                    premioPorcj = stkPago.nextToken();
                    premioPorcentaje = new BigDecimal(this.desFormatearNumero(premioPorcj, this.FORMATO_DEFAULT));                    
                    dtoPagoMonetario.setPremio(premioPorcentaje);
                    
                    // Sumo los premioPorcentaje
                    totalPorcentaje = totalPorcentaje.add(premioPorcentaje);
                    
                    dtoPagoMonetario.setPeriodoControl(stkPago.nextToken());  
                    
                    dtoPagoMonetario.setOidPeriodoControl(Long.valueOf(stkPago.nextToken()));  
                    
                    oidPago = stkPago.nextToken();
                    dtoPagoMonetario.setOidPagoMonetario(oidPago.equals("BLANCO")?null:Long.valueOf(oidPago));
                    
                    arrLstPagos.add(dtoPagoMonetario);
                }
                
                this.traza("totalPorcentaje: " + totalPorcentaje.toString());
                // Verifica que la suma de porcentajes sea 100
                if(totalPorcentaje.compareTo(new BigDecimal(100))!=0){
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(
                                      ConstantesSEG.MODULO_INC, "", "0014") );

                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter(numNivel);
                    
                    throw ex;
                }
                
                dtoPremioMonetario.setLstPagosMonetarios(arrLstPagos);
           
           } else {
                dtoPremioMonetario.setLstPagosMonetarios(null);
           }
           
      } else {
           // No se parametrizan Otros Datos
           dtoPremioMonetario.setIndPagoPartes(Boolean.FALSE);
           dtoPremioMonetario.setOidCumplimiento(null);
           dtoPremioMonetario.setIndDescontarPagosAnticipados(Boolean.FALSE);
           dtoPremioMonetario.setLstPagosMonetarios(null);
      }
      
      return dtoPremioMonetario;    
  }
  
  
  public DTOPremioPuntos almacenarPremioPuntos(String premioPuntos, Vector numeroPremioM) throws Exception {
      /*  0-ind
           1-tipoPremiacion
           2-numPremio 
           3-concDest
           4-tipoPremPuntos
           5-cant
           6-porcenj
           7-oidPremioPuntos
      */
      String numeroPremio = null;
      String cant = null;
      String porcenj = null;
      String oidPremioPuntos = null;
      
      this.traza("premioPuntos: " + premioPuntos);
           
      StringTokenizer stkPremioPuntos = new StringTokenizer(premioPuntos,"###");
      DTOPremioPuntos dtoPremioPuntos = new DTOPremioPuntos();
      
      this.traza("oid: " + stkPremioPuntos.nextToken());
      this.traza("tipo Premio: " + stkPremioPuntos.nextToken());
      
      numeroPremio = stkPremioPuntos.nextToken();
      dtoPremioPuntos.setNumeroPremio(Integer.valueOf(numeroPremio));
      
      dtoPremioPuntos.setOidConcursoDestino(Long.valueOf(stkPremioPuntos.nextToken()));
      dtoPremioPuntos.setOidTipoPremioPuntos(Long.valueOf(stkPremioPuntos.nextToken()));
      
      cant = stkPremioPuntos.nextToken();
      dtoPremioPuntos.setCantidad(cant.equals("BLANCO")?null:Integer.valueOf(this.desFormatearNumero(cant, this.FORMATO_DEFAULT)));
      
      porcenj = stkPremioPuntos.nextToken();
      dtoPremioPuntos.setPorcentaje(porcenj.equals("BLANCO")?null:new BigDecimal(this.desFormatearNumero(porcenj, this.FORMATO_DEFAULT)));
      
      oidPremioPuntos = stkPremioPuntos.nextToken();
      dtoPremioPuntos.setOidPremioPuntos(oidPremioPuntos.equals("BLANCO")?null:Long.valueOf(oidPremioPuntos));
      
      // Obtiene el numero de premio maximo
      if(((Integer)numeroPremioM.get(0)).intValue() < Integer.valueOf(numeroPremio).intValue()){
           numeroPremioM.set(0,Integer.valueOf(numeroPremio)); 
      }
      
      return dtoPremioPuntos;    
  }
  
  
  /*
  Modificado por: Cristian Valenzuela
  Fecha: 23/10/2006
  Incidencia: DBLG500000562
  Comentario: Se quita la carga de los combos generico y super generico,
  se reemplaza por una caja de texto y un boton buscar
  */

  public void cargarPantalla() throws Exception {
      // Validaciones
      this.getFormatosValidaciones();         
      
      // Pestañas - asigna los hiddens
      super.cargarFlagsPestanyas();
      
      //Obtengo el concurso de session
      if(this.opcionMenu.equals("nueva version")){
           this.dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS"); 
           super.setConcurso(this.dtoConcurso); 

      }
           else {
           this.dtoConcurso = super.getConcurso();
      }

      this.traza("dtoConcurso inicial: " + this.dtoConcurso);
      
      ComposerViewElementList cv = this.crearParametrosEntrada(this.dtoConcurso.getPlantilla().getIndSorteo());
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      this.traza("antes del conector.ejecucion");
      conector.ejecucion();
      this.traza("luego del conector");
      DruidaConector resultados = conector.getConector();
      this.traza("antes de asignar al COMBO");
      this.asignar("COMBO","cbTipoSeleccion",resultados,"INCObtenerTipoPremiacion");          
      if(this.dtoConcurso.getParamGenerales().getOidMarca()!=null && this.dtoConcurso.getParamGenerales().getOidCanal()!=null) {
    	  
    	  if(this.opcionMenu.equals("Consultar Concurso")) {
           this.asignar("COMBO","cbPeriodo",resultados,"CRAObtienePeriodos");
           
           //sapaza -- PER-SiCC-2010-0210 -- 27/04/2010
           this.asignar("COMBO","cbPeriodoInicio",resultados,"CRAObtienePeriodos");
    	  } else {
    		  
    		//sapaza -- PER-SiCC-2010-0210 -- 28/04/2010
    		this.asignar("COMBO","cbPeriodo",resultados,"CRAObtenerPeriodosPosterioresActivos");
    		this.asignar("COMBO","cbPeriodoInicio",resultados,"CRAObtenerPeriodosPosterioresActivos");
    	  } 
           
      }
      this.asignar("COMBO","cbTipoEleccion",resultados,"INCObtenerTipoEleccion");   
      // Manejo de habilitaciones
      this.asignarAtributo("VAR","IND_ACTIVO","valor", ConstantesINC.IND_ACTIVO.equals(new Integer(1))?"S":"N");
      this.asignarAtributo("VAR","IND_INACTIVO","valor", ConstantesINC.IND_INACTIVO.equals(new Integer(1))?"S":"N");
      this.asignarAtributo("VAR","OID_TIPO_PREM_NIVELES","valor", ConstantesINC.OID_TIPO_PREM_NIVELES.toString());
      this.asignarAtributo("VAR","hIndPremiosAcumuPorNiveles","valor", this.checkValor(this.dtoConcurso.getPlantilla().getIndPremiosAcumuPorNiveles()));
      this.asignarAtributo("VAR","hIndNivelesRotativos","valor", this.checkValor(this.dtoConcurso.getPlantilla().getIndNivelesRotativos()));      
      this.asignarAtributo("VAR","hIndFaseCalificacion","valor", this.checkValor(this.dtoConcurso.getPlantilla().getIndFaseCalificacion()));
      this.asignarAtributo("VAR","hIndPremiosElectivos","valor", this.checkValor(this.dtoConcurso.getPlantilla().getIndPremiosElectivos()));
	  // vbongiov -- Cambio 20080811 -- 26/08/2009
	  this.traza("hIndSorteo: " + this.dtoConcurso.getPlantilla().getIndSorteo());
	  this.asignarAtributo("VAR","hIndSorteo","valor", this.checkValor(this.dtoConcurso.getPlantilla().getIndSorteo()));
	  this.asignarAtributo("VAR","OID_TIPO_PREMIACION_SORTEO","valor", ConstantesINC.OID_TIPO_PREMIACION_SORTEO.toString());
	  this.asignarAtributo("VAR","hOidMarca","valor", this.dtoConcurso.getParamGenerales().getOidMarca().toString());
	  
	  // sapaza -- PER-SiCC-2010-0210 -- 27/04/2010
	  this.asignarAtributo("VAR","OID_TIPO_PREM_BOLSA","valor", ConstantesINC.OID_TIPO_PREM_BOLSA.toString());

	  // sapaza -- PER-SiCC-2010-0388 -- 14/07/2010
	  if((dtoConcurso.getPlantilla().getOidTipoCalificacion() != null) && 
		 (dtoConcurso.getPlantilla().getOidTipoCalificacion().longValue()== ConstantesINC.OID_TIPO_CALIF_HISTORICA_INC_NIVELES.longValue())) {
		  this.asignarAtributo("VAR","hIndAccesoNivelPremioSuperior","valor", "S");
	  } else {
		  this.asignarAtributo("VAR","hIndAccesoNivelPremioSuperior","valor", "N");
	  }	  
	  
      // Carga los datos de la pestaña si ya fue cargada
      if(this.dtoConcurso.getIndPremios()!=null && this.dtoConcurso.getIndPremios().booleanValue()){
           this.traza("Se ha rellenado la pestania");

           this.asignarAtributo("VAR","oidParamGralesPremiacion","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getOidParamGralesPremiacion()));
           
                    this.asignarAtributo("VAR","hCbTipoSeleccion","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getOidTipoPremiacion()));
           
                    this.asignarAtributo("CTEXTO","txtNumNiveles","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getNroNiveles()));
           
                    this.asignarAtributo("CHECKBOX","ckPeriodoDespacho","check", this.checkValor(this.dtoConcurso.getParamGralesPremiacion().getIndPeriodoDespacho()));
           
                    this.asignarAtributo("VAR","hCbPeriodo","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getOidPeriodo()));
                    
                    //sapaza -- PER-SiCC-2010-0210 -- 27/04/2010
                    this.asignarAtributo("VAR","hCbPeriodoInicio","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getOidPeriodoInicio()));
           
                    this.asignarAtributo("CTEXTO","txtNumPeriodoObtencion","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getNroPeriodosObtencion()));      
           
                    //this.asignarAtributo("CHECKBOX","ckComunicacion","check", this.checkValor(this.dtoConcurso.getParamGralesPremiacion().getIndComunicacion()));
           
           //if(this.checkValor(this.dtoConcurso.getParamGralesPremiacion().getIndComunicacion()).equals("S")) {
			//this.asignarAtributo("CTEXTO","txtMensaje","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getMensaje()));
		//}

           this.asignarAtributo("CHECKBOX","ckPremiosAcumulativosNiveles","check", this.checkValor(this.dtoConcurso.getParamGralesPremiacion().getIndPremiosAcumulativosNiveles()));
           
                    this.asignarAtributo("CTEXTO","txtHastaNivel","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getHastaNivel()));
                    
                    this.asignarAtributo("CHECKBOX","ckNivelesRotativos","check", this.checkValor(this.dtoConcurso.getParamGralesPremiacion().getIndNivelesRotativos()));
           
                    this.asignarAtributo("CTEXTO","txtNumRotaciones","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getNroRotaciones()));
           
                    this.asignarAtributo("CHECKBOX","ckAccesoNivelPremioSuperior","check", this.checkValor(this.dtoConcurso.getParamGralesPremiacion().getIndAccesoNivelPremioSuperior()));
           
                    this.asignarAtributo("CHECKBOX","ckPremioElectivo","check", this.checkValor(this.dtoConcurso.getParamGralesPremiacion().getIndPremiosElectivos()));
           
           if(this.checkValor(this.dtoConcurso.getParamGralesPremiacion().getIndPremiosElectivos()).equals("S")) {
			this.asignarAtributo("VAR","hCbTipoEleccion","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getOidTipoEleccion()));

			// sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
			this.asignarAtributo("CHECKBOX","ckSinPremioPorDefecto","check", this.checkValor(this.dtoConcurso.getParamGralesPremiacion().getIndSinPremioPorDefecto()));
		}


           // vbongiov -- Cambio 20080811 -- 26/08/2009
           this.asignarAtributo("CTEXTO","txtCantidadNumerosAOtorgar","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getCantidadNumerosAOtorgar()));
		   this.asignarAtributo("CTEXTO","txtCodProducto","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getCodProducto()));
		   this.asignarAtributo("VAR","oidProducto","valor", this.convString(this.dtoConcurso.getParamGralesPremiacion().getOidProducto()));

                
           // Carga los datos de los niveles
           if(this.dtoConcurso.getIndNivelPremiacion()!=null && this.dtoConcurso.getIndNivelPremiacion().booleanValue()){
                // Guarda en una variable de session el DTONivelesPremiacion
                DTONivelesPremiacion dtoNivelesPremiacion = this.dtoConcurso.getListaNivelesPremiacion();
                             dtoNivelesPremiacion.setNumeroPremioMax(this.dtoConcurso.getParamGralesPremiacion().getNumeroPremio());
                             dtoNivelesPremiacion.setOidPais(UtilidadesSession.getPais(this));
                this.setNivelesPremiacion(dtoNivelesPremiacion);
           }
                    else {
                this.setNivelesPremiacion(null);
           }      
      }
           else {
           this.traza("No se ha rellenado todavia la pestania");
                    this.setNivelesPremiacion(null);
           // Valor por defecto
           this.asignarAtributo("CTEXTO","txtNumRotaciones","valor", ConstantesINC.IND_ACTIVO.toString());             
      }      
  }
  
  
  public void cargarPantallaMantenerNivel() throws Exception {
           this.traza("LPMantenerParametrosGeneralesPremiacion.cargarPantallaMantenerNivel() - Entrada");	    
      this.pagina("contenido_nivel_mantener");
      this.getFormatosValidaciones();     
      this.dtoConcurso = super.getConcurso();      
      this.opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);      
      this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);
      
      // Carga de combo de datos Niveles
      DTOBelcorp dtoBel = new DTOBelcorp();
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
      dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
      
      Vector paramEntrada  = new Vector();
      paramEntrada.add(dtoBel);
      paramEntrada.add(new MareBusinessID("INCObtenerTipoPremio"));
             
           this.traza("antes conector tipo premio");
           DruidaConector conectorTipoPremio = this.conectar("ConectorObjeto", paramEntrada);
           this.traza("despues conector tipo premio");
      
      DTOSalida dtoSalida = (DTOSalida)conectorTipoPremio.objeto("DTOSalida");
      RecordSet rsTipoPremio = this.agregarBlanco(dtoSalida);
      
      this.asignar("COMBO","cbTipoPremio",this.generarConector("ROWSET", rsTipoPremio, rsTipoPremio.getColumnIdentifiers()),"ROWSET");  
           
           // Carga de combos de las capas
      ComposerViewElementList cv = this.crearParametrosEntradaNiveles();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
    
      this.traza("antes de asignar los COMBOS");
      // Puntos
      this.asignar("COMBO","cbConcursoDestino",resultados,"INCCargarNroConcursoVersion");    
      this.asignar("COMBO","cbTipoPremioPuntos1",resultados,"INCObtenerTipoPremiosPuntos");    
      // Monetario
      this.asignar("COMBO","cbTipoPremioMonetario2",resultados,"INCObtenerTipoPremioMonetario");        
      this.asignar("COMBO","cbMoneda",resultados,"SEGObtenerMonedasPorPais");   
      this.asignar("COMBO","cbFormaPago",resultados,"INCObtenerFormaPago");    
      this.asignar("COMBO","cbCumplimiento",resultados,"INCObtenerTipoCumplimiento");   
      
      if(this.dtoConcurso.getParamGenerales().getOidMarca()!=null && this.dtoConcurso.getParamGenerales().getOidCanal()!=null) {
           this.asignar("COMBO","cbPeriodoControl",resultados,"CRAObtienePeriodos"); 
      }
      // Descuento
      this.asignar("COMBO","cbTipoPremioDescuento5",resultados,"INCObtenerTipoDescuento");   
      
      if(this.dtoConcurso.getParamGenerales().getOidMarca()!=null && this.dtoConcurso.getParamGenerales().getOidCanal()!=null) {
           this.asignar("COMBO","cbPeriodoAplicacionDesde",resultados,"CRAObtienePeriodos");    
           this.asignar("COMBO","cbPeriodoAplicacionHasta",resultados,"CRAObtienePeriodos");    
      }
      
      if(this.dtoConcurso.getParamGenerales().getOidMarca()!=null) {
           this.asignar("COMBO","cbMarca",resultados,"SEGRecuperarMarcasProductoMP");   
      }

      this.asignar("COMBO","cbUnidadNegocio",resultados,"MAEObtenerUnidadesNegocioPorPais");   
      this.asignar("COMBO","cbNegocio",resultados,"MAEObtenerNegocioPorPais");    
      //asignar("COMBO","cbSupergenerico",resultados,"MAEObtenerSuperGenericosPorPais");    
      //asignar("COMBO","cbGenerico",resultados,"MAEObtenerGenericosPorPais");   
      
      // vbongiov -- 18/09/2007
      //Articulos
      this.asignar("COMBO","cbCenServGar",resultados,"INCObtenerCentroServicio");   
      this.asignar("COMBO","cbCenServEntrega",resultados,"INCObtenerCentroServicio");
      
      this.traza("despues de asignar los COMBOS");
      
      this.asignarAtributo("VAR","hOidMarca","valor", this.dtoConcurso.getParamGenerales().getOidMarca().toString());
      
      // Hidden para habilitaciones
      this.asignarAtributo("VAR","IND_ACTIVO","valor", ConstantesINC.IND_ACTIVO.equals(new Integer(1))?"S":"N");
      this.asignarAtributo("VAR","IND_INACTIVO","valor", ConstantesINC.IND_INACTIVO.equals(new Integer(1))?"S":"N");     
      this.asignarAtributo("VAR","OID_TIPO_PREMIO_PUNTOS","valor", ConstantesINC.OID_TIPO_PREMIO_PUNTOS.toString());
      this.asignarAtributo("VAR","OID_TIPO_PREMIO_MONETARIO","valor", ConstantesINC.OID_TIPO_PREMIO_MONETARIO.toString());
      this.asignarAtributo("VAR","OID_TIPO_PREMIO_ARTICULO","valor", ConstantesINC.OID_TIPO_PREMIO_ARTICULO.toString());
      this.asignarAtributo("VAR","OID_TIPO_PREMIO_DESCUENTO","valor", ConstantesINC.OID_TIPO_PREMIO_DESCUENTO.toString());
   
      this.asignarAtributo("VAR","hIndPuntajeServicio","valor", this.checkValor(this.dtoConcurso.getPlantilla().getIndPuntajeServicio()));
      this.asignarAtributo("VAR","hIndPremiosElectivos","valor", this.checkValor(this.dtoConcurso.getPlantilla().getIndPremiosElectivos()));      
      this.asignarAtributo("VAR","OID_TIPO_PREM_NIVELES","valor", ConstantesINC.OID_TIPO_PREM_NIVELES.toString());
      // Agregado por dmaneiro - 15/11/2005 - Inc. 21039
                  this.asignarAtributo("VAR","hIndRanking","valor", this.checkValor(this.dtoConcurso.getParamGenerales().getIndRanking()));
                  //Agregado por dmaneiro - 04/11/2005 - Inc. 21041
                  this.asignarAtributo("VAR","hIndProductosExigidos","valor", this.checkValor(this.dtoConcurso.getPlantilla().getIndProductosExigidos()));

                   //se cambio conectorParametroLimpia - dmaneiro - 20/12/2005 - inc. 21040
      String cbTipoSeleccion = this.conectorParametro("hCbTipoSeleccion");   
      this.traza("cbTipoSeleccion: " + cbTipoSeleccion);
      this.asignarAtributo("VAR","hCbTipoSeleccion","valor", cbTipoSeleccion);

      // Puntos
      this.asignarAtributo("VAR","OID_TIPO_PREM_PTOS_CANT_FIJA","valor", ConstantesINC.OID_TIPO_PREM_PTOS_CANT_FIJA.toString());
      this.asignarAtributo("VAR","OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT","valor", ConstantesINC.OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT.toString());
      this.asignarAtributo("VAR","OID_TIPO_PREM_PTOS_PUNTAJE_OBT","valor", ConstantesINC.OID_TIPO_PREM_PTOS_PUNTAJE_OBT.toString());
      // Monetario
      this.asignarAtributo("VAR","OID_TIPO_PREM_MONET_CANT_FIJA","valor", ConstantesINC.OID_TIPO_PREM_MONET_CANT_FIJA.toString());
      this.asignarAtributo("VAR","OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT","valor", ConstantesINC.OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT.toString());
      this.asignarAtributo("VAR","OID_TIPO_PREM_MONET_PUNTAJE_OBT","valor", ConstantesINC.OID_TIPO_PREM_MONET_PUNTAJE_OBT.toString());
      this.asignarAtributo("VAR","OID_TIPO_DET_METAS_BONO_ANUAL","valor", ConstantesINC.OID_TIPO_DET_METAS_BONO_ANUAL.toString());
      this.asignarAtributo("VAR","OID_TIPO_CUMPLIMIENTO_TOTAL","valor", ConstantesINC.OID_TIPO_CUMPLIMIENTO_TOTAL.toString());
           
      if(this.dtoConcurso.getParamCalificacion()!=null){
           this.asignarAtributo("VAR","hOidTipoDeterminacionMetas","valor", this.dtoConcurso.getParamCalificacion().getOidTipoDeterminacionMetas()==null?"":this.dtoConcurso.getParamCalificacion().getOidTipoDeterminacionMetas().toString());
      } else {
           this.asignarAtributo("VAR","hOidTipoDeterminacionMetas","valor", "");
      }
      
      // Descuento
      this.asignarAtributo("VAR","OID_TIPO_DESCUENTO_IMPORTE","valor", ConstantesINC.OID_TIPO_DESCUENTO_IMPORTE.toString());
      this.asignarAtributo("VAR","OID_TIPO_DESCUENTO_PORCENTAJE","valor", ConstantesINC.OID_TIPO_DESCUENTO_PORCENTAJE.toString());
      
      // Articulos
      String indPremiosElectivos = this.conectorParametroLimpia("hIndPremiosElectivosPremios", "", true);  
      this.asignarAtributo("VAR","hIndPremiosElectivosPremios","valor", indPremiosElectivos);
     
      // Carga la lista datos de Niveles
      // Número de niveles a visualizar
      String numeroNiveles = this.conectorParametroLimpia("numeroNiveles", "", true);  
      int numNiveles = Integer.valueOf(numeroNiveles).intValue();
      
      this.asignarAtributo("VAR","numeroNiveles","valor", numeroNiveles);
      
      // Recordset auxiliar
      RecordSet rs = new RecordSet();          
      rs.addColumn("oid");
      rs.addColumn("numNivel");
      rs.addColumn("puntajeServicio");
      rs.addColumn("tipoPremio");
      rs.addColumn("nivelElegible");    
      rs.addColumn("cantFijaPuntos");
      rs.addColumn("cantDesde");
      rs.addColumn("cantHasta");
      rs.addColumn("puntosProdExigidos");        
      rs.addColumn("numAspirantes");    
      rs.addColumn("oidNivel"); 
	  // vbongiov -- Cambio 20090930 -- 16/07/2009
	  rs.addColumn("descripcion");       
      
      // Lista de niveles premiacion
      DTONivelesPremiacion dtoNivelesPremiacion = this.getNivelesPremiacion();
      int cantNiveles = 0;
      StringBuffer datosNiveles = new StringBuffer();
      int numPremio = 0;
   
      if(dtoNivelesPremiacion!=null) {
           // Cantidad de niveles ingresados por el usuario
           cantNiveles = dtoNivelesPremiacion.getListaNiveles()==null?0:dtoNivelesPremiacion.getListaNiveles().length;
      }
      
      // El usuario ha ingresado niveles
      if(this.dtoConcurso.getIndNivelPremiacion().booleanValue() || cantNiveles!=0 ){
           this.traza("Hay registros de niveles");
           DTONivelPremiacion[] dtoNivelPremiacionArr = dtoNivelesPremiacion.getListaNiveles();
           DTONivelPremiacion dtoNivelPremiacion = null;
           DTOPremioPuntos dtoPremioPuntos = null;
           DTOPremioMonetario dtoPremioMonetario = null;
           DTOPremioDescuento dtoPremioDescuento = null;
           DTOPremioArticulo dtoPremioArticulo = null;
           ArrayList arrLstArticulos = null;
           StringBuffer articulos = new StringBuffer();
           DTOArticulo dtoArticulo = null;     
           ArrayList arrLstPagos = null;
           StringBuffer pagos = null;
           DTOPagoMonetario dtoPagoMonetario = null;  
           ArrayList arrLstLotes = null;
           StringBuffer lotes = null;
           ArrayList arrLstProdLotes = null;
           StringBuffer prodLotes = null;
           DTOLotesPremio dtoLotesPremio = null;
           DTOProductosLote dtoProductosLote = null;
           
           
           this.traza("numNiveles: " + numNiveles);
           this.traza("cantNiveles: " + cantNiveles);
           
           for(int i=0; i<numNiveles; i++){
                if(i<cantNiveles) {
                    // Se desea visualizar este nivel ingresado por el usuario
                    dtoNivelPremiacion = dtoNivelPremiacionArr[i];
                    this.traza("dtoNivelPremiacion: " + dtoNivelPremiacion);
					// vbongiov -- Cambio 20090930 -- 16/07/2009
                    rs.addRow(new Object[] {
                         Integer.toString(i), 
                         dtoNivelPremiacion.getNumeroNivel()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getNumeroNivel().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getPuntajeServicio()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getPuntajeServicio().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getOidTipoPremio(),
                         dtoNivelPremiacion.getIndNivelSelectivo()==null?"N":(dtoNivelPremiacion.getIndNivelSelectivo().booleanValue()?"S":"N"),
                         dtoNivelPremiacion.getCantidadFijaPuntos()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getCantidadFijaPuntos().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getCantidadDesde()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getCantidadDesde().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getCantidadHasta()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getCantidadHasta().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getPuntosProductosExigidos()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getPuntosProductosExigidos().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getNumeroAspirantes()==null?"":dtoNivelPremiacion.getNumeroAspirantes().toString(),
                         dtoNivelPremiacion.getOid()==null?"":dtoNivelPremiacion.getOid().toString(),
						 dtoNivelPremiacion.getDescripcionNivel()==null?"":dtoNivelPremiacion.getDescripcionNivel()});    
                  
                         // Arma registro de niveles
                         if(dtoNivelPremiacion.getIndPremiosPuntos().booleanValue()){
                             dtoPremioPuntos = dtoNivelPremiacion.getPremioPuntos();
                          
                             datosNiveles.append("%%%").append(Integer.toString(i).toString());
                             datosNiveles.append("###").append(ConstantesINC.OID_TIPO_PREMIO_PUNTOS.toString());
                             datosNiveles.append("###").append(dtoPremioPuntos.getNumeroPremio().toString());
                             datosNiveles.append("###").append(dtoPremioPuntos.getOidConcursoDestino().toString());
                             datosNiveles.append("###").append(dtoPremioPuntos.getOidTipoPremioPuntos().toString());
                             datosNiveles.append("###").append(dtoPremioPuntos.getCantidad()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioPuntos.getCantidad().toString(), this.FORMATO_DEFAULT, this));
                             datosNiveles.append("###").append(dtoPremioPuntos.getPorcentaje()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioPuntos.getPorcentaje().toString(), this.FORMATO_DEFAULT, this));
                             datosNiveles.append("###").append(dtoPremioPuntos.getOidPremioPuntos()==null?"BLANCO":dtoPremioPuntos.getOidPremioPuntos().toString());
                           
                             // Busca el maximo numero de premio ingresado
                             if(numPremio < dtoPremioPuntos.getNumeroPremio().intValue()){
                                  numPremio = dtoPremioPuntos.getNumeroPremio().intValue(); 
                             }
                             
                         } else if(dtoNivelPremiacion.getIndPremiosDescuento().booleanValue()){
                             dtoPremioDescuento = dtoNivelPremiacion.getPremioDescuento();
                             
                             datosNiveles.append("%%%").append(Integer.toString(i).toString());
                             datosNiveles.append("###").append(ConstantesINC.OID_TIPO_PREMIO_DESCUENTO.toString());
                             datosNiveles.append("###").append(dtoPremioDescuento.getNumeroPremio().toString());
                             datosNiveles.append("###").append(dtoPremioDescuento.getOidTipoDescuento().toString());
                             datosNiveles.append("###").append(dtoPremioDescuento.getCantidadDescuento()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioDescuento.getCantidadDescuento().toString(), this.FORMATO_MONEDA, this));
                             datosNiveles.append("###").append(dtoPremioDescuento.getPorcentajeDescuento()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioDescuento.getPorcentajeDescuento().toString(), this.FORMATO_DEFAULT, this));                             
                             datosNiveles.append("###").append(dtoPremioDescuento.getOidPeriodoAplicacionDesde()==null?"BLANCO":dtoPremioDescuento.getOidPeriodoAplicacionDesde().toString());
                             datosNiveles.append("###").append(dtoPremioDescuento.getOidPeriodoAplicacionHasta()==null?"BLANCO":dtoPremioDescuento.getOidPeriodoAplicacionHasta().toString());
                             datosNiveles.append("###").append(dtoPremioDescuento.getOidPremioDescuento()==null?"BLANCO":dtoPremioDescuento.getOidPremioDescuento().toString());
                           
                             // Busca el maximo numero de premio ingresado
                             if(numPremio < dtoPremioDescuento.getNumeroPremio().intValue()){
                                  numPremio = dtoPremioDescuento.getNumeroPremio().intValue(); 
                             }
                            
                             // Obtiene los articulos
                             arrLstArticulos = dtoPremioDescuento.getLstArticulos();
                         
                             if(arrLstArticulos!=null){
                                  articulos = new StringBuffer();
                                  int cantArt = arrLstArticulos.size();
                                  this.traza("cantArt: " + cantArt);
                                  
                                  for(int j=0; j<cantArt; j++){
                                      dtoArticulo = (DTOArticulo)arrLstArticulos.get(j);
                                      
                                      articulos.append("---").append(dtoArticulo.getMarca());
                                      articulos.append("&&&").append(dtoArticulo.getUnidadNegocio()==null?"BLANCO":dtoArticulo.getUnidadNegocio());
                                      articulos.append("&&&").append(dtoArticulo.getNegocio()==null?"BLANCO":dtoArticulo.getNegocio());
                                      articulos.append("&&&").append(dtoArticulo.getSupergenerico()==null?"BLANCO":dtoArticulo.getSupergenerico());
                                      articulos.append("&&&").append(dtoArticulo.getGenerico()==null?"BLANCO":dtoArticulo.getGenerico());
                                      articulos.append("&&&").append(dtoArticulo.getCodigoProducto()==null?"BLANCO":dtoArticulo.getCodigoProducto());
                                      articulos.append("&&&").append(dtoArticulo.getOidMarca().toString());
                                      articulos.append("&&&").append(dtoArticulo.getOidUnidadNegocio()==null?"BLANCO":dtoArticulo.getOidUnidadNegocio().toString());
                                      articulos.append("&&&").append(dtoArticulo.getOidNegocio()==null?"BLANCO":dtoArticulo.getOidUnidadNegocio().toString());
                                      articulos.append("&&&").append(dtoArticulo.getOidSupergenerico()==null?"BLANCO":dtoArticulo.getOidSupergenerico().toString());
                                      articulos.append("&&&").append(dtoArticulo.getOidGenerico()==null?"BLANCO":dtoArticulo.getOidGenerico().toString());
                                      articulos.append("&&&").append(dtoArticulo.getOidProducto()==null?"BLANCO":dtoArticulo.getOidProducto().toString());
                                      articulos.append("&&&").append(dtoArticulo.getOidProductoDescuento()==null?"BLANCO":dtoArticulo.getOidProductoDescuento().toString());
                                      
                                  }
                                  datosNiveles.append("###").append(articulos.length()==0?"BLANCO":articulos.toString().substring(3));
                                  
                                 
                             } else {
                                  datosNiveles.append("#BLANCO");
                             }
                             
                         } else if(dtoNivelPremiacion.getIndPremiosMonetarios().booleanValue()){
                             dtoPremioMonetario = dtoNivelPremiacion.getPremioMonetario();
                             
                             datosNiveles.append("%%%").append(Integer.toString(i).toString());
                             datosNiveles.append("###").append(ConstantesINC.OID_TIPO_PREMIO_MONETARIO.toString());
                             datosNiveles.append("###").append(dtoPremioMonetario.getNumeroPremio().toString());
                             datosNiveles.append("###").append(dtoPremioMonetario.getOidTipoPremioMonetario().toString());
                             datosNiveles.append("###").append(dtoPremioMonetario.getCantidad()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioMonetario.getCantidad().toString(), this.FORMATO_MONEDA, this));
                             datosNiveles.append("###").append(dtoPremioMonetario.getPorcentaje()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioMonetario.getPorcentaje().toString(), this.FORMATO_DEFAULT, this));                             
                             datosNiveles.append("###").append(dtoPremioMonetario.getOidMoneda().toString());
                             datosNiveles.append("###").append(dtoPremioMonetario.getOidFormaPago().toString());
                             datosNiveles.append("###").append(dtoPremioMonetario.getOidPremioMonetario()==null?"BLANCO":dtoPremioMonetario.getOidPremioMonetario().toString());
                            
                             // Busca el maximo numero de premio ingresado
                             if(numPremio < dtoPremioMonetario.getNumeroPremio().intValue()){
                                  numPremio = dtoPremioMonetario.getNumeroPremio().intValue(); 
                             }
                            
                             // Verifica Otros Datos
                             if(this.dtoConcurso.getParamCalificacion()!= null && 
                                 ConstantesINC.OID_TIPO_DET_METAS_BONO_ANUAL.equals(this.dtoConcurso.getParamCalificacion().getOidTipoDeterminacionMetas())) {
                                 
                                 // Hay Otros Datos
                                 datosNiveles.append("###").append(dtoPremioMonetario.getIndPagoPartes().booleanValue()?"S":"N");
                                 datosNiveles.append("###").append(dtoPremioMonetario.getOidCumplimiento()==null?"BLANCO":dtoPremioMonetario.getOidCumplimiento().toString());
                                 datosNiveles.append("###").append(dtoPremioMonetario.getIndDescontarPagosAnticipados().booleanValue()?"S":"N");
                             
                                  // Obtiene los Pagos
                                  arrLstPagos = dtoPremioMonetario.getLstPagosMonetarios();
                                  
                                  if(arrLstPagos!=null){
                                      pagos = new StringBuffer();
                                      int cantPagos = arrLstPagos.size();
                                      this.traza("cantPagos: " + cantPagos);
                                      
                                      for(int j=0; j<cantPagos; j++){
                                           dtoPagoMonetario = (DTOPagoMonetario)arrLstPagos.get(j);
                                           
                                           pagos.append("---").append(dtoPagoMonetario.getNumeroPago());
                                           pagos.append("&&&").append(UtilidadesBelcorp.formateaNumeroSICC(dtoPagoMonetario.getPremio().toString(), this.FORMATO_DEFAULT, this));
                                           pagos.append("&&&").append(dtoPagoMonetario.getPeriodoControl());
                                           pagos.append("&&&").append(dtoPagoMonetario.getOidPeriodoControl());                                           
                                           pagos.append("&&&").append(dtoPagoMonetario.getOidPagoMonetario()==null?"BLANCO":dtoPagoMonetario.getOidPagoMonetario().toString());
                                           
                                      }
                                      datosNiveles.append("###").append(pagos.length()==0?"BLANCO":pagos.toString().substring(3));
                                      
                                      
                                  } else {
                                      datosNiveles.append("#BLANCO");
                                  }
                             
                             } else {
                                  // No hay Otros Datos
                                  datosNiveles.append("#BLANCO");
                                  datosNiveles.append("#BLANCO");
                                  datosNiveles.append("#BLANCO");
                                  datosNiveles.append("#BLANCO");
                             }
                         } else if(dtoNivelPremiacion.getIndPremiosArticulos().booleanValue()){
                             dtoPremioArticulo = dtoNivelPremiacion.getPremioArticulo();
                            
                             datosNiveles.append("%%%").append(Integer.toString(i).toString());
                             datosNiveles.append("###").append(ConstantesINC.OID_TIPO_PREMIO_ARTICULO.toString());                            
                             datosNiveles.append("###").append(dtoPremioArticulo.getNumeroUnidadesPremioArticulo().toString());     
                             datosNiveles.append("###").append(dtoPremioArticulo.getOidPremioArticulo()==null?"BLANCO":dtoPremioArticulo.getOidPremioArticulo().toString());
                            
                             // Obtiene los Lotes
                             arrLstLotes = dtoPremioArticulo.getLstLotesPremio();
                             
                             if(arrLstLotes!=null){
                                  lotes = new StringBuffer();
                                  int cantLotes = arrLstLotes.size();
                                  this.traza("cantLotes: " + cantLotes);
                                  
                                  for(int j=0; j<cantLotes; j++){
                                      dtoLotesPremio = (DTOLotesPremio)arrLstLotes.get(j);
                                      
                                      // Busca el maximo numero de premio ingresado
                                      if(numPremio < dtoLotesPremio.getNumeroPremio().intValue()){
                                           numPremio = dtoLotesPremio.getNumeroPremio().intValue(); 
                                      }
                                      
                                      lotes.append(":::").append(dtoLotesPremio.getNumeroPremio());
                                      lotes.append(";;;").append(dtoLotesPremio.getDescripcionLote());                                                                                
                                      
                                      // Obtiene los Lotes
                                      arrLstProdLotes = dtoLotesPremio.getLstProductosLote();
                                      
                                      if(arrLstProdLotes!=null){
                                      
                                           int cantProdLotes = arrLstProdLotes.size();
                                           this.traza("cantProdLotes: " + cantProdLotes);
                                           
                                           prodLotes = new StringBuffer();
                                           
                                           for(int k=0; k<cantProdLotes; k++){
                                           
                                                dtoProductosLote = (DTOProductosLote)arrLstProdLotes.get(k);
                                           
                                                prodLotes.append("---").append(dtoProductosLote.getCodigoProducto());
												// vbongiov -- Cambio 20090930 -- 16/07/2009
												prodLotes.append("&&&").append(dtoProductosLote.getDescProducto());
                                                prodLotes.append("&&&").append(UtilidadesBelcorp.formateaNumeroSICC(dtoProductosLote.getNumeroUnidades().toString(), this.FORMATO_DEFAULT, this));                            
                                                prodLotes.append("&&&").append(UtilidadesBelcorp.formateaNumeroSICC(dtoProductosLote.getPrecioPublico().toString(), this.FORMATO_MONEDA, this));                            
                                                prodLotes.append("&&&").append(dtoProductosLote.getIndDespachaArticulo().booleanValue()?"S":"N");
                                                prodLotes.append("&&&").append(dtoProductosLote.getCodVentaFicticio()==null?"BLANCO":dtoProductosLote.getCodVentaFicticio().toString());
                                                // vbongiov --18/09/2007
                                                prodLotes.append("&&&").append(dtoProductosLote.getIndCentroServGar().booleanValue()?"S":"N");
                                                prodLotes.append("&&&").append(dtoProductosLote.getDescCentSerGar()==null?"BLANCO":dtoProductosLote.getDescCentSerGar());
                                                prodLotes.append("&&&").append(dtoProductosLote.getNumMeses()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoProductosLote.getNumMeses().toString(), this.FORMATO_DEFAULT, this));                            
                                                prodLotes.append("&&&").append(dtoProductosLote.getObservaciones()==null?"BLANCO":dtoProductosLote.getObservaciones());
                                                prodLotes.append("&&&").append(dtoProductosLote.getIndTipoEntrega());
                                                prodLotes.append("&&&").append(dtoProductosLote.getDescCentSerEntrega()==null?"BLANCO":dtoProductosLote.getDescCentSerEntrega());
                                                prodLotes.append("&&&").append(dtoProductosLote.getOidCentroServGar()==null?"BLANCO":dtoProductosLote.getOidCentroServGar().toString());
                                                prodLotes.append("&&&").append(dtoProductosLote.getOidCentroServEntrega()==null?"BLANCO":dtoProductosLote.getOidCentroServEntrega().toString());
                                                prodLotes.append("&&&").append(dtoProductosLote.getOidProducto()==null?"BLANCO":dtoProductosLote.getOidProducto().toString());
                                                prodLotes.append("&&&").append(dtoProductosLote.getOidProductoLote()==null?"BLANCO":dtoProductosLote.getOidProductoLote().toString());
                                           }  
                                           
                                           // Obtiene los productos del lote
                                           lotes.append(";;;").append(prodLotes.length()==0?"BLANCO":prodLotes.toString().substring(3));
                                      
                                      } else {
                                           lotes.append(";BLANCO");
                                      }
                                      
                                      lotes.append(";;;").append(dtoLotesPremio.getOidLotePremio()==null?"BLANCO":dtoLotesPremio.getOidLotePremio().toString());
                                  }
                                  
                                  // Obtiene los lotes
                                  datosNiveles.append("###").append(lotes.length()==0?"BLANCO":lotes.toString().substring(3));
                                  
                                  
                             } else {
                                  datosNiveles.append("#BLANCO");
                             }
                         }                        
                         
                         this.traza("datosNiveles: " + datosNiveles.toString().substring(3));
                         
                } else {
                    // Se desea ingresar nuevos registros
                    this.traza("Nuevo registro de niveles");
					// vbongiov -- Cambio 20090930 -- 16/07/2009
                    rs.addRow(new Object[] {Integer.toString(i), Integer.toString(i+1), "", "", "", "", "", "", "", "", "", ""});
                
                    datosNiveles.append("%%%").append(Integer.toString(i).toString()).append("#BLANCO");
                 
                }                   
           }
         
      } else {           
           this.traza("No hay registros de niveles");
           for(int i=0;i<numNiveles;i++){
			    // vbongiov -- Cambio 20090930 -- 16/07/2009
                rs.addRow(new Object[] {Integer.toString(i), Integer.toString(i+1), "", "", "", "", "", "", "", "", "", ""});
                
                datosNiveles.append("%%%").append(Integer.toString(i).toString()).append("#BLANCO");
                
                // Maximo numero de Premio ingresado
                numPremio = 0;
           }
      }
         
      this.asignar("LISTADOA", "listado", this.generarConector("ROWSET", rs, rs.getColumnIdentifiers()),"ROWSET");
      this.asignarAtributo("VAR","datosNiveles","valor", datosNiveles.length()==0?"":datosNiveles.toString().substring(3));
      
      this.asignarAtributo("VAR","numeroPremio","valor", new Integer(numPremio).toString());      
      
           // INC 21869 - dmorello, 05/12/2005
           // Se asigna al combo cbMoneda el valor correspondiente a la moneda local del país
           DTOOID dtoOidPais = new DTOOID();
           dtoOidPais.setOid(UtilidadesSession.getPais(this));
           Vector params  = new Vector();
      params.add(dtoOidPais);
      params.add(new MareBusinessID("ObtenerMonedaDefault"));
             
                    this.traza("antes conector moneda default");
                    DruidaConector conectorMonedaDefault = this.conectar("ConectorObjeto", params);
                    this.traza("despues conector moneda default");
      
           DTOOID dtoValorDefectoMoneda = (DTOOID)conectorMonedaDefault.objeto("DTOSalida");
           this.traza("oid moneda devuelto: " + dtoValorDefectoMoneda.getOid().toString());
           this.asignarAtributo("VAR","oidMonedaDefault","valor",dtoValorDefectoMoneda.getOid().toString());
           // Fin agregado INC 21869
  }
  
  
  // Convierte el valor del check de boolean a String
  private String checkValor(Boolean val) throws Exception {
      if(val !=null && val.booleanValue()){
           return "S";
      } else if(val !=null && !val.booleanValue()) {
           return "N";
      } else {
		return "";
	}
  }
  
  
  // Controla valores nulos
  private String convString(Object val) throws Exception {
      if(val !=null) {
		return val.toString();
	} else {
		return "";
	}
  }
    
  
  private ComposerViewElementList crearParametrosEntrada(Boolean indSorteo) throws Exception{
      this.traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();

      // vbongiov -- Cambio 20080811 -- 26/08/2009
	  DTOBoolean dtoBoolean = new DTOBoolean();
	  dtoBoolean.setOidPais(UtilidadesSession.getPais(this));
      dtoBoolean.setOidIdioma(UtilidadesSession.getIdioma(this));

	  if(indSorteo!= null && indSorteo.booleanValue()) {
		  dtoBoolean.setValor(true);
	  } else {
		  dtoBoolean.setValor(false);
	  }
      
      DTOBelcorp dtoBel = new DTOBelcorp();
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
      dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
      
      DTOPeriodo dtoP = new DTOPeriodo();
      dtoP.setOidPais(UtilidadesSession.getPais(this));
      dtoP.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoP.setMarca(this.dtoConcurso.getParamGenerales().getOidMarca());
      dtoP.setCanal(this.dtoConcurso.getParamGenerales().getOidCanal());
           
      ComposerViewElement combo1 = new ComposerViewElement();             
      combo1.setIDBusiness("INCObtenerTipoPremiacion");
      combo1.setDTOE(dtoBoolean);
           
      lista.addViewElement(combo1);
      
      if(this.dtoConcurso.getParamGenerales().getOidMarca()!=null && this.dtoConcurso.getParamGenerales().getOidCanal()!=null) {
           ComposerViewElement combo2 = new ComposerViewElement();         
           combo2.setIDBusiness("CRAObtienePeriodos");
           combo2.setDTOE(dtoP);
                
           lista.addViewElement(combo2);
           
           dtoP.setPais(dtoP.getOidPais());
           dtoP.setOid(this.dtoConcurso.getParamGenerales().getOidPeriodoDesde());
           ComposerViewElement combo2a = new ComposerViewElement();         
           combo2a.setIDBusiness("CRAObtenerPeriodosPosterioresActivos");
           combo2a.setDTOE(dtoP);
                
           lista.addViewElement(combo2a);
      }
      
      ComposerViewElement combo3 = new ComposerViewElement();         
      combo3.setIDBusiness("INCObtenerTipoEleccion");
      combo3.setDTOE(dtoBel);
           
      lista.addViewElement(combo3);   
      
      return lista;
  }
  
  
  
  private ComposerViewElementList crearParametrosEntradaNiveles() throws Exception{
      this.traza("LPMantenerParametrosGeneralesPremiacion.crearParametrosEntradaNiveles() - Entrada");
      ComposerViewElementList lista = new ComposerViewElementList();
      
      DTOBelcorp dtoBel = new DTOBelcorp();
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
      dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
      
      DTOPeriodo dtoP = new DTOPeriodo();
      dtoP.setOidPais(UtilidadesSession.getPais(this));
      dtoP.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoP.setMarca(this.dtoConcurso.getParamGenerales().getOidMarca());
      dtoP.setCanal(this.dtoConcurso.getParamGenerales().getOidCanal());
      
      DTOOID dtoOid = new DTOOID();
      dtoOid.setOidPais(UtilidadesSession.getPais(this));
      dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoOid.setOid(this.dtoConcurso.getParamGenerales().getOidMarca());

           DTOBuscarNumConcurso dtoBn = new DTOBuscarNumConcurso();
      dtoBn.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoBn.setOidPais(UtilidadesSession.getPais(this));
      dtoBn.setIndActivo(Integer.valueOf("1")); 
     
      ComposerViewElement combo2 = new ComposerViewElement();             
      combo2.setIDBusiness("INCCargarNroConcursoVersion");
      combo2.setDTOE(dtoBn);
           
      lista.addViewElement(combo2);
      
      ComposerViewElement combo3 = new ComposerViewElement();             
      combo3.setIDBusiness("INCObtenerTipoPremiosPuntos");
      combo3.setDTOE(dtoBel);
           
      lista.addViewElement(combo3);
      
      ComposerViewElement combo4 = new ComposerViewElement();             
      combo4.setIDBusiness("INCObtenerTipoPremioMonetario");
      combo4.setDTOE(dtoBel);
           
      lista.addViewElement(combo4);
      
      ComposerViewElement combo5 = new ComposerViewElement();             
      combo5.setIDBusiness("SEGObtenerMonedasPorPais");
      combo5.setDTOE(dtoBel);
           
      lista.addViewElement(combo5);
      
      ComposerViewElement combo6 = new ComposerViewElement();             
      combo6.setIDBusiness("INCObtenerFormaPago");
      combo6.setDTOE(dtoBel);
           
      lista.addViewElement(combo6);     
      
      ComposerViewElement combo7 = new ComposerViewElement();             
      combo7.setIDBusiness("INCObtenerTipoCumplimiento");
      combo7.setDTOE(dtoBel);
           
      lista.addViewElement(combo7);      
      
      if(this.dtoConcurso.getParamGenerales().getOidMarca()!=null && this.dtoConcurso.getParamGenerales().getOidCanal()!=null) {
           ComposerViewElement combo8 = new ComposerViewElement();         
           combo8.setIDBusiness("CRAObtienePeriodos");
           combo8.setDTOE(dtoP);
                
           lista.addViewElement(combo8);
      }
      
      ComposerViewElement combo9 = new ComposerViewElement();         
      combo9.setIDBusiness("INCObtenerTipoDescuento");
      combo9.setDTOE(dtoBel);
           
      lista.addViewElement(combo9);
      
      if(this.dtoConcurso.getParamGenerales().getOidMarca()!=null) {
           ComposerViewElement combo10 = new ComposerViewElement();         
           combo10.setIDBusiness("SEGRecuperarMarcasProductoMP");
           combo10.setDTOE(dtoOid);
                
           lista.addViewElement(combo10);
      }
      
      ComposerViewElement combo11 = new ComposerViewElement();         
      combo11.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");
      combo11.setDTOE(dtoBel);
           
      lista.addViewElement(combo11);          
      
      ComposerViewElement combo12 = new ComposerViewElement();         
      combo12.setIDBusiness("MAEObtenerNegocioPorPais");
      combo12.setDTOE(dtoBel);
           
      lista.addViewElement(combo12);          
      
      /*ComposerViewElement combo13 = new ComposerViewElement();         
      combo13.setIDBusiness("MAEObtenerSuperGenericosPorPais");
      combo13.setDTOE(dtoBel);
           
      lista.addViewElement(combo13);   
      
      ComposerViewElement combo14 = new ComposerViewElement();         
      combo14.setIDBusiness("MAEObtenerGenericosPorPais");
      combo14.setDTOE(dtoBel);
           
      lista.addViewElement(combo14);   */
      
      // vbongiov -- 18/09/2007
      ComposerViewElement combo15 = new ComposerViewElement();      
      combo15.setIDBusiness("INCObtenerCentroServicio");
      combo15.setDTOE(dtoBel);
             
      lista.addViewElement(combo15);
      
      this.traza("LPMantenerParametrosGeneralesPremiacion.crearParametrosEntradaNiveles() - Salida");
      return lista;
  }
  
  
  public void ejecucion() throws Exception{

          this.setTrazaFichero();

          this.accion = this.conectorParametroLimpia("accion", "", true);
          this.opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);

          this.oidVigenciaConcurso = this.conectorParametroLimpia("oidVigenciaConcurso", "", true);
          
          this.asignarAtributo("VAR", "accion", "valor", this.accion);
   this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);
   
          this.traza("opcionMenu: " + this.opcionMenu);
   this.traza("accion: " + this.accion);
   this.traza("oidVigenciaConcurso: " + this.oidVigenciaConcurso);
   
   try{
   
 // Pestañas
 super.obtenerFlagsPestanyas();
   
 // Seteo Pais e Idioma
 Long pais = UtilidadesSession.getPais(this);
 Long idioma = UtilidadesSession.getIdioma(this);
   
 this.asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()) );
 this.asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()) );    
 
 //sapaza -- PER-SiCC-2011-0295 -- 17/06/2011
 this.asignarAtributo("VAR", "oidVigenciaConcurso", "valor", this.oidVigenciaConcurso);
 
 if(this.opcionMenu.equals("Crear concurso")){
    this.asignarAtributoPagina("cod", "0491");
 } else if(this.opcionMenu.equals("Consultar Concurso")){
    this.asignarAtributoPagina("cod", "0493");
 } else if(this.opcionMenu.equals("Modificar Concurso") || this.opcionMenu.equals("nueva version")){
    this.asignarAtributoPagina("cod", "0486");
 }

 // Acciones
 if( this.accion.equals("") ){
      this.cargarPantalla();
 } else if( this.accion.equals("cargar mantener nivel") ){
      this.cargarPantallaMantenerNivel();
 } else if( this.accion.equals("eliminar niveles") ){
      this.eliminarNiveles();
 } else if( this.accion.equals("almacenar niveles") ){
      this.almacenarNivel();
 } else if( this.accion.equals("almacenar") ){
      this.almacenar();
      if(!this.opcionMenu.equals("nueva version")){
          super.redirigir();
      }
 } else if( this.accion.equals("guardar") ){
      this.almacenar();
      super.guardar();
 } else if( this.accion.equals("redirigir") ){
      super.redirigir();
 // vbongiov -- Cambio 20090930 -- 16/07/2009
 } else if( this.accion.equals("obtenerDescProducto") ){
      this.obtenerDescProducto();
 }

   }catch (Exception e){   
  
this.traza(e);      
this.lanzarPaginaError(e);
  
   }
    // Configura menu secundario
  this.getConfiguracionMenu();

 }//fin ejecucion
  
  public void eliminarNiveles() throws Exception {
         
      this.pagina("salidaGenerica");
           this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
      
      try{
                    this.traza("eliminarNiveles");
    
           // Guarda el DTONivelesPremiacion
           this.setNivelesPremiacion(null);

                    //Obtengo el concurso de session
                    this.dtoConcurso = super.getConcurso();

           this.dtoConcurso.setIndNivelPremiacion(Boolean.FALSE);
           this.dtoConcurso.setListaNivelesPremiacion(null);

           super.setConcurso(this.dtoConcurso);
           
           this.asignarAtributo("VAR", "ejecutar", "valor", "terminaEliminarNiveles();");

                    this.traza("termina eliminarNiveles");
           
      } catch(Exception e){
                              this.asignarAtributo("VAR", "ejecutarError", "valor", "terminaEliminarNiveles();");
                              throw e;
           }	
  }


  private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
      new StringBuffer();
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
      
      for (int i=0; i < sizeRows; i++){
         Element e_row = docDestino.createElement("ROW");
         e_rows.appendChild(e_row);
  
         Element e_campo0   = docDestino.createElement("CAMPO");
  
         for(int j=0; j < sizeColums; j++){
           if( columns.contains(columsDesc.elementAt(j))){
             Element e_campo2   = docDestino.createElement("CAMPO");
             
             if(j == 0){
                e_campo0.setAttribute("NOMBRE","oculto");
             }else{
                e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
             }
             e_campo2.setAttribute("TIPO","OBJECTO");
             e_campo2.setAttribute("LONGITUD","50");
             Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
             e_campo2.appendChild(txt0);
             e_row.appendChild(e_campo2);
           }
         }
      }
      conectorValoresPosibles.setXML(docDestino.getDocumentElement());
      this.traza("DruidaConector: " + conectorValoresPosibles.getXML());
      return conectorValoresPosibles;
         }

 // Obtiene el DTONivelesPremiacion auxiliar
  public DTONivelesPremiacion getNivelesPremiacion() throws Exception {
      DTONivelesPremiacion dtoNivelesPremiacion = null;
      
      try{
           dtoNivelesPremiacion = (DTONivelesPremiacion)this.getSessionCache().get("DTONivelesPremiacion");
      }catch(Exception e){
         this.traza("no se encontro el DTONivelesPremiacion en sesion");
      }
      
      this.traza("dtoNivelesPremiacion: " + dtoNivelesPremiacion);
      
      return dtoNivelesPremiacion;
  }
  
  
  public void inicio() throws Exception {	
     this.pagina("contenido_parametros_generales_premiacion_mantener");
 }

  // vbongiov -- Cambio 20090930 -- 16/07/2009
  private void obtenerDescProducto() throws Exception{

	  this.pagina("salidaGenerica");
	  this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");

	  try { 
		  String codProducto = this.conectorParametroLimpia("codProducto", "", true); 

		  // Obtencion de la descripcion larga
		  DTOEBuscarProductos dtoBuscarProductos = new DTOEBuscarProductos();    
		  dtoBuscarProductos.setCodSAP(codProducto);
		  dtoBuscarProductos.setIndPremio(Boolean.TRUE);

		  dtoBuscarProductos.setOidPais(UtilidadesSession.getPais(this));
		  dtoBuscarProductos.setOidIdioma(UtilidadesSession.getIdioma(this));

		  this.traza("dtoBuscarProductos: " + dtoBuscarProductos);
		 
		  MareBusinessID id = new MareBusinessID("PREBuscarProductosMaestro");                  
		  Vector paramEntrada = new Vector();

		  paramEntrada.add(dtoBuscarProductos);
		  paramEntrada.add(id);
		  this.traza("*************** Antes de conectar");
		  DruidaConector con = this.conectar("ConectorObtenerProducto", paramEntrada);              
		  this.traza("*************** Despues de conectar");

		  DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida");   

          String descProducto = (String)dtoSalida.getResultado().getValueAt(0,"VAL_I18N");	
				
		  this.asignarAtributo("VAR", "ejecutar", "valor", "aniadirProductoLote('" + this.replace(descProducto,"'", " ") + "')");	   
				
	  } catch(Exception e) {
		   this.traza("Excepcion: " + e);
		   this.asignarAtributo("VAR", "ejecutarError", "valor", "ejecutarErrorAniadirProductoLote()");

		   throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC + "0001"));     
	  }
  }
  
  // Setea el DTONivelesPremiacion auxiliar
  public void setNivelesPremiacion(DTONivelesPremiacion dto){
      this.getSessionCache().put("DTONivelesPremiacion", dto);           
  }

}

/**
 *	Clase que sobreescribe al StringTokenizer para realizar split con separador string 
 */

class StringTokenizer{
	
	private Iterator<String> it=null;
	public StringTokenizer(String datosNiveles, String string) {
		String[] str = datosNiveles.split(string);
		List<String> l = new ArrayList<String>();
		for (String s:str) {
			l.add(s);
		} 
		this.it=l.iterator();
	}
	
	public Boolean hasMoreTokens(){
		return this.it.hasNext();
	}
	
	public String nextToken(){
		return this.it.next();
	}
}