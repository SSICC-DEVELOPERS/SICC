/*
    INDRA/CAR/PROY
    $Id: LPCrearLotesClientes.java,v 1.1 2009/12/03 18:41:15 pecbazalar Exp $
    DESC
*/

import LPSICCBase;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.util.UtilidadesError;

//Librerias DTO modulo
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.dtos.mae.DTOCrearLotesClientes;



//import es.indra.sicc.dtos.zon.DTOUsuario;
//import es.indra.sicc.dtos.zon.DTOEGPaises;


//Librerias Mare
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;

//Librerias druida
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.druida.DruidaBaseComun;

//Librerias Utilidades java
import java.util.Vector;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Enumeration;
import java.io.*;

//Librerias utilidades XML
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.DOMException;
import es.indra.sicc.util.xml.XMLDocument;
import java.lang.StringBuffer;
import java.lang.Exception;
import java.math.BigDecimal;

// Definicion de la clase
public class LPCrearLotesClientes extends LPSICCBase {

private HashMap param = new HashMap();
private HashMap param2 = new HashMap();


	//Constructor de la clase
	 public LPCrearLotesClientes () {super();}

	public void inicio() throws Exception {
		 pagina("contenido_lotes_clientes_insertar");
		 this.getConfiguracionMenu();
    
  }

   public void ejecucion() throws Exception {
   String accion = conectorParametro("accion");
   accion = (accion==null )?"":accion;
    setTrazaFichero();
    param =conectorParametro();
    traza("Entro a LP con accion = "+ accion);
    
      try{
         if(accion.equals("")){
	         asignarAtributo("CAPA","capaTitulo","visibilidad","hidden");
           InicioLP();
         }

         if(accion.equals("crearClientes")){ 
            crearCliente();
            asignarAtributo("CAPA","capaTitulo","visibilidad","visible");
            asignarAtributo("VAR","accion","valor","crearClientes");
		        asignarAtributo("VAR","exito","valor","S");
		        asignarAtributo("VAR","casoDeUso","valor","Insertar");
		       // traza(this.getXML().getDocumentElement().toString());  
          
         }

         if((accion.equals("ImprimirCupones")) || (accion.equals("ImprimirCodigos"))){
            pagina("salidaGenerica");
            traza("entro en Imprimir");
            asignarAtributo("VAR", "ejecutar", "valor", "alertarError()");
            
           // throw new MareException(new Exception(),UtilidadesError.armarCodigoError("160230001")); 
            //asignarAtributo("VAR","exito","valor","S");
         }

         /*if(accion.equals("ImprimirCodigos")){
            pagina("salidaGenerica");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError("160230001")); 
         }*/

      }catch (Exception ex) {
                 
         traza("La excepcion es " + ex);
         this.traza("Error en ejecucion");
 		     this.lanzarPaginaError(ex);
         
      }
   }

   private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns)
		throws DOMException,Exception{

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
		
		for (int i=0; i < sizeRows; i++){
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);

			for (int j=0; j < sizeColums; j++){
				if ( columns.contains(columsDesc.elementAt(j)) ){
					Element e_campo0   = docDestino.createElement("CAMPO");
					e_campo0.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo0.setAttribute("TIPO","OBJECTO");
					e_campo0.setAttribute("LONGITUD","50");
					Text txt = docDestino.createTextNode("");
					e_campo0.appendChild(txt);
					e_row.appendChild(e_campo0);



				
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

  private void InicioLP()throws Exception{
        this.traza("Estoy en InicioLP");
        this.traza("LLamo al Facade");
            try{
                Vector objBussines = new Vector();
                DTOBelcorp dtoBelcorp = new DTOBelcorp();
                UtilidadesSession sesion = new UtilidadesSession();
                dtoBelcorp.setOidPais(sesion.getPais(this));
                dtoBelcorp.setOidIdioma(sesion.getIdioma(this));
                traza(dtoBelcorp);
                MareBusinessID id = new MareBusinessID("MAELotesPermitidos");
                objBussines.add(dtoBelcorp);
                objBussines.add(id);
                DruidaConector ver =conectar("ConectorLotesPermitidos",objBussines);
                traza("coorecto");
                DTOBoolean dtos = (DTOBoolean) ver.objeto("DTOSalida");
                traza("dto " + dtos);

                if(dtos.getValor()){
                
                }else{
                   throw new MareException(new Exception(),UtilidadesError.armarCodigoError("160210001")); 
                }
           }catch(Throwable th){
            this.traza("error en InicioLP");
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

  private void crearCliente()throws Exception{
    try{
      this.traza("entro en crear cliente");
      this.traza("verifico rango de valor de cliente");
          String sval = (String)this.param.get("txtNumClientes");
          Integer ival = new Integer(sval);
          if(ival.intValue() < 0 || ival.intValue() > 999){  
              throw new MareException(new Exception(),UtilidadesError.armarCodigoError("160220001"));   
          }
      this.traza("asigno pais e idioma");  
          DTOCrearLotesClientes dlclien = new DTOCrearLotesClientes();
          UtilidadesSession sesion = new UtilidadesSession();
          dlclien.setNumClientes(ival);
          dlclien.setOidPais(sesion.getPais(this));
          dlclien.setOidIdioma(sesion.getIdioma(this));
          this.traza("Invoco al Facade");
          DTOSalida dtos = (DTOSalida)obtenerDatosSalida("MAECrearLotesClientes","ConectorCrearLotesClientes",(DTOCrearLotesClientes)dlclien);
          this.traza("asigno resultado a componente");
          RecordSet clientes = (RecordSet)dtos.getResultado();          
		      traza("Este el recordset que me devuelve" + clientes);

          for (int i=0; i<clientes.getRowCount() ; i++)  {
			        traza("Entro a poner ceros a izquierda ciclo: " + i);
              String codClien = ((Long)clientes.getValueAt(i,0)).toString();
			        traza("Casteo " + i +" cod Clien");
              Byte longCod = obtenerLongitudCodigoCliente();
			        traza("Obtuvo " + i +" longitud de Cliente");
              clientes.setValueAt(this.pad(codClien,longCod),i,0);
              traza("Este es el codigo de cliente: " +  codClien);
          }

          Vector colID = clientes.getColumnIdentifiers();
          int numCol = clientes.getColumnCount();          
          DruidaConector cliente = this.generarConector("DTOSalida.resultado_ROWSET",clientes, colID);
		  //DruidaConector resul = transformar("XSLColumnaListaEditable",cliente);
		      traza("Vemos resultado de la consulta"+ cliente.getXML());
          asignar("LISTADOA","listado1",cliente,"DTOSalida.resultado_ROWSET");
		  
          this.traza("se creo cliente exitosamente");
    }catch(Throwable th){
     this.traza("error en crearClientes");
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

  private Object obtenerDatosSalida(String bID,String conector,Object dto)throws Exception{
				traza("entro a ObtenerDatos Salida");
                Vector objBussines = new Vector();
                MareBusinessID id = new MareBusinessID(bID);
                objBussines.add(dto);
                objBussines.add(id);
                DruidaConector ver =conectar(conector,objBussines);
                Object obj = ver.objeto("DTOSalida");
				traza("ver DTOSalida" + obj.toString());
                return obj;
                   
  }

  private String pad(String s, Byte len) {
        StringBuffer buf = new StringBuffer();
        int slen = s.length();
        if (len.intValue() > slen)
        {
            int diff = len.intValue() - s.length();
            for(int i = 0; i < diff; i++)
            {
                buf.append("0");
            }
        }
        buf.append(s);

        return buf.toString();
  }
  

  
}
