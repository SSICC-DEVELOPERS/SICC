import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOGestionStock;
import es.indra.sicc.dtos.ped.DTOListaGestionStock;
import es.indra.sicc.util.UtilidadesBelcorp;

import java.util.Enumeration;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LPUtilGestionStock extends LPSICCBase {
	protected DTOListaGestionStock dtoGestionStock;
  protected String siI18N;
  protected String noI18N;

  public LPUtilGestionStock(){  super();  }
	public void inicio() throws Exception {}
	public void ejecucion() throws Exception {}

	protected void muestraListaGestion( Vector dto ) throws Exception {
    traza("************** Entre a muestraListaGestion");
    RecordSet rs = new RecordSet();
    Vector vv = null;
    
    rs.addColumn( "OID" );
    rs.addColumn( "CODIGOVENTA" );
    rs.addColumn( "CATALOGO" );
    rs.addColumn( "NUMPAGINA" );
    rs.addColumn( "OIDREGION" );
    rs.addColumn( "OIDZONA" );
    rs.addColumn( "TIPOCLIENTE" );
    rs.addColumn( "SUBTIPOCLIENTE" );
    rs.addColumn( "TIPOCLASIFICACION" );
    rs.addColumn( "CLASIFICACION" );
    rs.addColumn( "LIMITEVENTA" );
    rs.addColumn( "CONTROLSTOCK" ); //VALOR UNIDADES
    rs.addColumn( "CONTROLSOCKPORCENTUAL" ); //VALOR PORCENTUAL
    rs.addColumn( "CONTROLLIQUIDACION" );
    rs.addColumn( "ULTIMASNOTICIAS" );

    DTOGestionStock dtoGS = null;

    if( dto != null ){
      traza("************** dto es distinto de null");
      for( int i = 0; i < dto.size(); i++ ){
        traza("************** Entro al for " + i);
        dtoGS = (DTOGestionStock)dto.get(i);

        if( (dtoGS != null && dtoGS.getIndEliminar() != null && !dtoGS.getIndEliminar().booleanValue()) ||
        (dtoGS != null && dtoGS.getIndEliminar() == null) ){
          traza("************** Entro al if principal");
          vv = new Vector();
          vv.setSize( 15 );
          rs.addRow( vv );

          traza("************** rs " + rs);
          int cant = rs.getRowCount();
          cant = cant - 1;
          traza("************** cant " + cant);

          //Se asigna el identificador, que se corresponde con la primera columna
          //de la lista editable.
          //dtoGS.setIndSecuencial( new Integer(i) );
          traza("************** 1");
          if(dtoGS.getOid() != null)                 rs.setValueAt( dtoGS.getOid(), cant, 0 );
          traza("************** 2");
          if(dtoGS.getTxtCodigoVenta() != null)      rs.setValueAt( dtoGS.getTxtCodigoVenta(), cant, 1 );
          traza("************** 3");
          if(dtoGS.getTxtCatalogo() != null)         rs.setValueAt( dtoGS.getTxtCatalogo(), cant, 2 );
          traza("************** 4");
          if(dtoGS.getNumPagina() != null)           rs.setValueAt( dtoGS.getNumPagina(), cant, 3 );
          traza("************** 5");
          if(dtoGS.getRegion() != null)              rs.setValueAt( dtoGS.getTxtRegion(), cant, 4 );
          traza("************** 6");
          if(dtoGS.getTxtZona() != null)             rs.setValueAt( dtoGS.getTxtZona(), cant, 5 );
          traza("************** 7");
          if(dtoGS.getTipoCliente() != null)         rs.setValueAt( dtoGS.getTxtTipoCliente(), cant, 6 );
          traza("************** 8");
          if(dtoGS.getSubtipoCliente() != null)      rs.setValueAt( dtoGS.getTxtSubtipoCliente(), cant, 7 );
          traza("************** 9");
          if(dtoGS.getTipoClasificacion() != null)   rs.setValueAt( dtoGS.getTxtTipoClasificacion(), cant, 8 );
          traza("************** 10");
          if(dtoGS.getClasificacion() != null)       rs.setValueAt( dtoGS.getTxtClasificacion(), cant, 9 );
          traza("************** 11");
          if(dtoGS.getLimiteVenta() != null)         rs.setValueAt( UtilidadesBelcorp.formateaNumeroSICC( (dtoGS.getLimiteVenta()==null?"":dtoGS.getLimiteVenta().toString()), LPSICCBase.FORMATO_DEFAULT, this ), cant, 10 );
          traza("************** 12");
          if(dtoGS.getValorUnidades() != null)       rs.setValueAt( UtilidadesBelcorp.formateaNumeroSICC( (dtoGS.getValorUnidades()==null?"":dtoGS.getValorUnidades().toString()), LPSICCBase.FORMATO_DEFAULT, this ), cant, 11 );
          traza("************** 13");
          if(dtoGS.getValorPorcentual() != null)     rs.setValueAt( UtilidadesBelcorp.formateaNumeroSICC( (dtoGS.getValorPorcentual()==null?"":dtoGS.getValorPorcentual().toString()), LPSICCBase.FORMATO_DEFAULT, this ), cant, 12 );
          traza("************** 14");
          
          //if(dtoGS.getLimiteVenta() != null)         rs.setValueAt( dtoGS.getLimiteVenta(), i, 10 );
          //if(dtoGS.getValorUnidades() != null)       rs.setValueAt( dtoGS.getValorUnidades(), i, 11 );
          //if(dtoGS.getValorPorcentual() != null)     rs.setValueAt( dtoGS.getValorPorcentual(), i, 12 );
          
          if(dtoGS.getControlLiquidacion() != null)  rs.setValueAt( (dtoGS.getControlLiquidacion().booleanValue()?siI18N:noI18N), cant, 13 );
          traza("************** 15");
          if(dtoGS.getIndUltNoticias() != null)      rs.setValueAt( (dtoGS.getIndUltNoticias().booleanValue()?siI18N:noI18N), cant, 14 );
          traza("************** 16");
        }
      }

      DruidaConector con = UtilidadesBelcorp.generarConector("dtoSalida", rs, rs.getColumnIdentifiers());
      traza("************** con " + con.getXML());

      asignar("LISTADOA", "listado1", con, "dtoSalida");
    }
  }


	protected Boolean esIgualZonTipo( DTOGestionStock dto ) throws Exception {
    Vector v = null;
    Enumeration e = null;
    DTOGestionStock dtoGS = null;

    v = dtoGestionStock.getDetalles();

    traza("detalles de sesion");
    traza(v);

    if( v != null ){
      e = v.elements();
    }
    
    while( e != null && e.hasMoreElements() ){
      dtoGS = (DTOGestionStock)e.nextElement();

      if( dtoGS.getRegion().equals( dto.getRegion() ) &&
          dtoGS.getZona().equals( dto.getZona() ) &&
          dtoGS.getTipoCliente().equals( dto.getTipoCliente() ) &&
          dtoGS.getSubtipoCliente().equals( dto.getSubtipoCliente() ) &&
          dtoGS.getTipoClasificacion().equals( dto.getTipoClasificacion() ) &&
          dtoGS.getClasificacion().equals( dto.getClasificacion() ) ) {

              dtoGS.setLimiteVenta( dto.getLimiteVenta() );
              dtoGS.setValorUnidades( dto.getValorUnidades() );
              dtoGS.setValorPorcentual( dto.getValorPorcentual() );
              dtoGS.setControlLiquidacion( dto.getControlLiquidacion() );
              dtoGS.setIndUltNoticias( dto.getIndUltNoticias() );

              return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }
}
