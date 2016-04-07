package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;


public class OrdenDeCompraSimplificada extends DocumentoFAC 
{
  private byte[] documento;
  private UtilidadesLog log = new UtilidadesLog();
    
//modificado por la incidencia 21179
public void componerFactura(DTODocLegal datosDocLegal)
    {
       UtilidadesLog.info("OrdenDeCompraSimplificada.componerFactura(DTODocLegal datosDocLegal): Entrada");
      ArrayList listaPaginas=datosDocLegal.getlistaPaginas();

      SerializadorOrdenDeCompraSimplificada sf1 = new SerializadorOrdenDeCompraSimplificada();
      //sf1.addSeccion(0);
      ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
      
      DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(0);
       
      DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
      
      //añadido por la incidencia 21179
      DTOImpresion miDTO= new DTOImpresion();
      String mensa="<frmocs><blqcon>";
      //Parseador miParseador= new Parseador();
      Parseador miParseador= Parseador.getInstance();
      sf1.addMensaje(mensa);
      //DTOClienteSolicitud dtoClienteSolicitud=null;
      //DatosClienteHelper datosCliente = new DatosClienteHelper();
      //String codigoTerritorio="";
      /*try
      {*/
          //dtoClienteSolicitud = datosCliente.obtenerDatosCliente(miCabecera.getOidCabeceraSolicitud(), datosDocLegal.getUsuario());   
          //codigo territorio (es region + zona + seccion + dos ultimas posiciones territorio)
          /**
           * Cambio hecho a pedido de Jainiver Arias
           * By JPB
           */
          
          /*if (this.getDtoClienteSolicitud().getCodRegion()!=null)
          {
              codigoTerritorio+=this.getDtoClienteSolicitud().getCodRegion().toString();
          }
          
          if (this.getDtoClienteSolicitud().getCodZona()!=null)
          {
              codigoTerritorio+=this.getDtoClienteSolicitud().getCodZona().toString();
          }
          
          if (this.getDtoClienteSolicitud().getCodSeccion()!=null)
          {
              codigoTerritorio+=this.getDtoClienteSolicitud().getCodSeccion().toString();
          }*/
          
          //obtenemos los ultimos dos dígitos del codigo de territorio
          String codTerri="";
          //String codTerri2="";
          if (this.getDtoClienteSolicitud().getCodTerritorio()!= null){
            UtilidadesLog.debug("el territorio es: "+this.getDtoClienteSolicitud().getCodTerritorio().toString());
            codTerri = this.getDtoClienteSolicitud().getCodTerritorio().toString();
            //codTerri2= codTerri.substring(codTerri.length()-2);
          }
          
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getCodRegion()));
          mensa="<creg><datoVariable01></creg>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getCodZona()));
          mensa="<czon><datoVariable01></czon>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getCodSeccion()));
          mensa="<csec><datoVariable01></csec>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(codTerri));
          mensa="<cter><datoVariable01></cter>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          
          //código cliente
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getCodigoCliente()));
          mensa="<ccon><datoVariable01></ccon>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          
          //nombre cliente
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(validarToString(this.getDtoClienteSolicitud().getNombre())));
          mensa="<ncon><datoVariable01></ncon>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          
          //direccion
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getDescripcionVia()) + " " + 
                                 validarToString(this.getDtoClienteSolicitud().getNombreVia()) + " " + 
                                 validarToString(this.getDtoClienteSolicitud().getNumero()) + " " +
                                 validarToString(this.getDtoClienteSolicitud().getObservaciones()));
          mensa="<dir1><datoVariable01></dir1>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          
          //ubigeo
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getDescripcionUbigeo()));
          mensa="<dir2><datoVariable01></dir2>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          
          //telefono
          miDTO= new DTOImpresion();
          //miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getTelefono()));
          miDTO.setDatoVariable1("");
          mensa="<tcon><datoVariable01></tcon>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
      /*}catch (MareException me)
      {
          //por incidencia 21179 y 21774
          //UtilidadesLog.debug("Error en obtener datos cliente. El documento se deja en blanco");
          UtilidadesLog.error("OrdenDeCompraSimplificada.componerFactura: Error al obtener los datos del cliente.");
      }*/
      
      
      miDTO= new DTOImpresion();
      mensa="</blqcon></frmocs>";
      sf1.addMensaje(mensa);
      
      /*
      //*****************************antes de la incidencia 21179
      DTOImpresion miDTO= new DTOImpresion();
      String mensa="<frmocs><blqcon>";
      Parseador miParseador= new Parseador();
      sf1.addMensaje(mensa);
              
      miDTO= new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(validarToString(miCabecera.getCodTerritorio())));
      mensa="<cter><datoVariable01></cter>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
      
      miDTO= new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getCodCliente()));
      mensa="<ccon><datoVariable01></ccon>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
            
      miDTO= new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getApellido1())+" "+validarToString(miCabecera.getApellido2())+" ,"+validarToString(miCabecera.getNombre1())+" "+validarToString(miCabecera.getNombre2()));
      mensa="<ncon><datoVariable01></ncon>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));      
      
      miDTO= new DTOImpresion();
      //modificado por incidencia 21005. Se setea el campo nombre via 
      //que ya trae todos los valores concatenados
      //miDTO.setDatoVariable1(validarToString(miCabecera.getTipoVia())+" "+validarToString(miCabecera.getNombreVia())+" "+validarToString(miCabecera.getNumero()));
      String direccion="";
      if (miCabecera.getNombreVia()!=null)
      {
          direccion = miCabecera.getNombreVia();
      }
      miDTO.setDatoVariable1(validarToString(direccion));
      mensa="<dir1><datoVariable01></dir1>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
      
      miDTO= new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getDescripcionUbigeo()));
      mensa="<dir2><datoVariable01></dir2>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
      
      miDTO= new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getTelefono()));
      mensa="<tcon><datoVariable01></tcon>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
      miDTO= new DTOImpresion();
      mensa="</blqcon></frmocs>";
      sf1.addMensaje(mensa);*/
    
    // Invocación del serializador
		
		// Composición de la sección 1
		/*
    String codTerri =miCabecera.getCodTerritorio();
    String codTerri2="";
    if(codTerri!=null)
    {
    codTerri2= this.validarToString(codTerri.substring(codTerri.length()-2));  
      
    }
    
    
		datos.add(0,validarToString(miCabecera.getCodRegion())+validarToString(miCabecera.getCodZona())+validarToString(miCabecera.getCodSeccion())+codTerri2 );
		System.out.println("COD: "+validarToString(miCabecera.getCodRegion()));
    System.out.println("COD: "+validarToString(miCabecera.getCodZona()));
    System.out.println("COD: "+validarToString(miCabecera.getCodSeccion()));
    System.out.println("COD: "+codTerri2);
    
    sf1.addMensaje(0, datos);
		datos.clear();
		
    datos.add(0,validarToString(miCabecera.getCodCliente()));
		sf1.addMensaje(1, datos);
		datos.clear();
		
    datos.add(0,validarToString(miCabecera.getApellido1())+" "+validarToString(miCabecera.getApellido2())+" ,"+validarToString(miCabecera.getNombre1())+" "+validarToString(miCabecera.getNombre2()));
    sf1.addMensaje(2,datos);
    datos.clear();
    
    datos.add(0,validarToString(miCabecera.getTipoVia())+" "+validarToString(miCabecera.getNombreVia())+" "+validarToString(miCabecera.getNumero())+" "+validarToString(miCabecera.getDescripcionUbigeo()));
    datos.add(1,"");
    sf1.addMensaje(3,datos);
    datos.clear();
    
    datos.add(0,validarToString(miCabecera.getTelefono()));
		sf1.addMensaje(4, datos);
		datos.clear();
    
    sf1.addSeccion(1);
		*/
			
  	// Final
		sf1.componerDocumento();
		
      
    try
		{
			sf1.saveDocument("c:\\", "ordenDeCompraSimplificada.txt");
			this.documento = sf1.bufferOut;
		}
		catch (Exception e)
		{
			UtilidadesLog.error("ERROR",e);
		}
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("OrdenDeCompraSimplificada: "+sf1.toString());
                
      UtilidadesLog.info("OrdenDeCompraSimplificada.componerFactura(DTODocLegal datosDocLegal): Salida");
    }
    
    public byte[] getDocument()
    {
        return this.documento;
    }

}