package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;

public class OCSimplificadaColombia extends DocumentoFAC  {

    private byte[] documento;
    private UtilidadesLog log = new UtilidadesLog();
   
    public void componerFactura(DTODocLegal datosDocLegal) throws MareException {
      UtilidadesLog.info("OCSimplificadaColombia.componerFactura(DTODocLegal datosDocLegal): Entrada");
      ArrayList listaPaginas=datosDocLegal.getlistaPaginas();

      SerializadorOrdenDeCompraSimplificada sf1 = new SerializadorOrdenDeCompraSimplificada();
      ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
      
      DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(0);
       
      DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
      
     
      DAODocuContable daoActivo = new DAODocuContable();
      Float numeroCopias = (Float)daoActivo.obtenerCopiasOCS(miCabecera.getOidPais(), miCabecera.getOidCabeceraSolicitud());
      
      DTOImpresion miDTO= new DTOImpresion();
      String mensa = "<frmocs copies=" + '\u0022' + numeroCopias.intValue() + '\u0022' + "><blqcon>";      
      Parseador miParseador= Parseador.getInstance();
      sf1.addMensaje(mensa);
      
          String codTerri="";
          
          if (this.getDtoClienteSolicitud().getCodTerritorio()!= null){
            UtilidadesLog.debug("el territorio es: "+this.getDtoClienteSolicitud().getCodTerritorio().toString());
            codTerri = this.getDtoClienteSolicitud().getCodTerritorio().toString();          
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
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getTelefono()));
          mensa="<tcon><datoVariable01></tcon>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
      
      
      miDTO= new DTOImpresion();
      mensa="</blqcon></frmocs>";
      sf1.addMensaje(mensa);
      sf1.componerDocumento();
		
      
    try
		{
			sf1.saveDocument("c:\\", "OCSimplificadaColombia.txt");
			this.documento = sf1.bufferOut;
		}
		catch (Exception e)
		{
			UtilidadesLog.error("ERROR",e);
		}
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("OCSimplificadaColombia: "+sf1.toString());
                
      UtilidadesLog.info("OCSimplificadaColombia.componerFactura(DTODocLegal datosDocLegal): Salida");
    }
    
    public byte[] getDocument() {
        return this.documento;
    }

}