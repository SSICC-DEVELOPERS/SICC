/**
 * Sistema:           Belcorp
 * Modulo:            COM
 * Submódulo:         ###
 * Componente:        LPUnitTest
 * Fecha:             14/04/2005
 * Observaciones:     
 *
 * @version           1.0
 * @author            Igor Dedoukh
 * ult. modif.:       
 */
 import es.indra.druida.DruidaConector;
 import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
 import es.indra.mare.common.mln.MareBusinessID;
 import es.indra.sicc.util.DTOBelcorp;
 import es.indra.sicc.util.DTOSalida;
 import es.indra.sicc.util.UtilidadesBelcorp;
 import es.indra.sicc.util.UtilidadesSession;
 import es.indra.sicc.util.DTOOID;
 import java.util.Vector;


public class LPUnitTest extends LPSICCBase 
{

	private String accion = null;
	private Long lIdioma = null;
	private Long lPais = null; 
	public LPUnitTest() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception 
	{
		setTrazaFichero();
		try  
		{
			this.rastreo();
			traza("*********** Entre a LPUnitTest");
			accion = conectorParametroLimpia("accion", "", true);
			lIdioma = UtilidadesSession.getIdioma(this);
		    lPais = UtilidadesSession.getPais(this); 

			if("test".equals(accion)){
				/*if(conectorParametroLimpia("update", "", true) != "")
				{  testUPDATE(new Long(conectorParametroLimpia("oid", "", true)), 
									  conectorParametroLimpia("bid", "", true), 
									  conectorParametroLimpia("con", "", true));
				}else
				{*/  testLoadDTOSalida(new Long(conectorParametroLimpia("oid", "", true)), 
												conectorParametroLimpia("bid", "", true), 
												conectorParametroLimpia("con", "", true));
				//}
			}
			else
			   pagina("contenido_unit_test");
			getConfiguracionMenu();
			//conectorAction("LPMantenimientoComisiones");
			//conectorActionParametro("accion", "InsertarComisiones"); 
		}
		catch ( Exception e )  
		{
			traza("Exception en LPUnitTest");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}


	// *******************************************************************************************************************
    /* imports:
	     import es.indra.druida.DruidaConector;
		 import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
         import es.indra.mare.common.mln.MareBusinessID;
         import es.indra.sicc.util.DTOBelcorp;
         import es.indra.sicc.util.DTOSalida;
	     import es.indra.sicc.util.UtilidadesBelcorp;
		 import es.indra.sicc.util.UtilidadesSession;
		 import es.indra.sicc.util.DTOOID;
	   public:
	     lIdioma = UtilidadesSession.getIdioma(this);
		 lPais = UtilidadesSession.getPais(this);       
       argument: DTOOID
	   objeto conector con nombre->  "DTOSalida"
	   y si Recordset no vacio
	*/
	public void testLoadDTOSalida(Long oid,String bid,String connector) throws Exception 
	{   traza("# METHOD testLoadDTOSalida,  oid: " + oid);
        DTOOID dtoOid = new DTOOID();dtoOid.setOid(oid);dtoOid.setOidPais(lPais);dtoOid.setOidIdioma(lIdioma);
		MareBusinessID businessID = new MareBusinessID(bid);Vector pms = new Vector();pms.add(dtoOid);pms.add(businessID);
		traza("# conectar -> " + connector + " ...... ");
		DruidaConector con = conectar(connector,pms);
        traza("# ....................................................... [OK] "); 
		traza("# con.objeto  : " + con.objeto("DTOSalida"));
		DTOSalida dtos = new DTOSalida();dtos=(DTOSalida)con.objeto("DTOSalida");   
        traza("# DTOSalida: " + dtos);  
		RecordSet rs = dtos.getResultado();
		StringBuffer sb = new StringBuffer();
		String str = null;
        if(!rs.esVacio())
        {  traza("# RecordSet: " + rs); // obtiene primer registro de rs
           for(int i=0;rs.existeColumna(i);i++)
		   {
			  str = "   COLUMN: ".concat(rs.getColumnName(i).concat(" ... ")).concat((rs.getValueAt(0,i)!=null)?rs.getValueAt(0,i).toString():"NULL");
		      traza(str);
			  sb.append("\n" + str);
		   }
		}
		pagina("contenido_unit_test");
		//pagina("salidaGenerica"); 
		asignarAtributo("VAR", "resultMLNF", "valor", sb.toString());
		//asignarAtributo("VAR", "ejecutar", "valor", "showResult(" + sb.toString() + ")");
		
		
	} //testLoadDTOSalida
	// ********************************************************************************************************************

	public void testUPDATE(Long oid,String bid,String connector) throws Exception 
	{   traza("# METHOD testUPDATE,  oid: " + oid);
        DTOOID dtoOid = new DTOOID();dtoOid.setOid(oid);dtoOid.setOidPais(lPais);dtoOid.setOidIdioma(lIdioma);
		MareBusinessID businessID = new MareBusinessID(bid);Vector pms = new Vector();pms.add(dtoOid);pms.add(businessID);
		traza("# conectar -> ".concat(connector));
		DruidaConector con = conectar(connector,pms);traza("# ....................................................... [OK] ");
	}
	// *********************************************************************************************************************
}