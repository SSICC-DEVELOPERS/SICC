package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.Vector;


public class PEDTaponConsultas implements IPedidosConsulta {
	public PEDTaponConsultas() {}

	public DTOSalida obtieneTiposSolicitudPais(DTOBelcorp dto){
		RecordSet rs = new RecordSet();
		DTOSalida dtoSalida = new DTOSalida();
		String [] ids = {"oid", "descripcion", "oidCanal", "oidTipoCliente"};
		rs.setColumnCount(ids.length);
		rs.setColumnIdentifiers(ids);		
		seteaValores(rs, "1", "Linea 11 tapón (C:1, TC: 1)", "1", "1");
		seteaValores(rs, "2", "Linea 12 tapón (C:1, TC: 2)", "1", "2");
		seteaValores(rs, "3", "Linea 13 tapón (C:1, TC: 3)", "1", "3");
		seteaValores(rs, "4", "Linea 133 tapón (C:1, TC: 33)", "1", "33");
		
		seteaValores(rs, "5", "Linea 21 tapón (C:2, TC: 1)", "2", "1");
		seteaValores(rs, "6", "Linea 22 tapón (C:2, TC: 2)", "2", "2");
		seteaValores(rs, "7", "Linea 23 tapón (C:2, TC: 3)", "2", "3");
		seteaValores(rs, "8", "Linea 233 tapón (C:2, TC: 33)", "2", "33");

		seteaValores(rs, "9", "Linea 31 tapón (C:3, TC: 1)", "3", "1");
		seteaValores(rs, "10", "Linea 32 tapón (C:2, TC: 2)", "3", "2");
		seteaValores(rs, "11", "Linea 33 tapón (C:2, TC: 3)", "3", "3");
		seteaValores(rs, "12", "Linea 333 tapón (C:2, TC: 33)", "3", "33");
					
		dtoSalida.setResultado(rs);
		return dtoSalida;
	}

	public DTOSalida obtieneTiposPosicion(DTOBelcorp dto){
		RecordSet rs = new RecordSet();
		DTOSalida dtoSalida = new DTOSalida();
		String [] ids = {"oidTipoPosicion", "descripcion", "oidCanal", "oidTipoCliente"};
		rs.setColumnCount(ids.length);
		rs.setColumnIdentifiers(ids);		

		seteaValores(rs, "1", "Linea 11 tapón (C:1, TC: 1)", "1", "1");
		seteaValores(rs, "2", "Linea 12 tapón (C:1, TC: 2)", "1", "2");
		seteaValores(rs, "3", "Linea 13 tapón (C:1, TC: 3)", "1", "3");
		seteaValores(rs, "4", "Linea 133 tapón (C:1, TC: 33)", "1", "33");
		
		seteaValores(rs, "5", "Linea 21 tapón (C:2, TC: 1)", "2", "1");
		seteaValores(rs, "6", "Linea 22 tapón (C:2, TC: 2)", "2", "2");
		seteaValores(rs, "7", "Linea 23 tapón (C:2, TC: 3)", "2", "3");
		seteaValores(rs, "8", "Linea 233 tapón (C:2, TC: 33)", "2", "33");

		seteaValores(rs, "9", "Linea 31 tapón (C:3, TC: 1)", "3", "1");
		seteaValores(rs, "10", "Linea 32 tapón (C:2, TC: 2)", "3", "2");
		seteaValores(rs, "11", "Linea 33 tapón (C:2, TC: 3)", "3", "3");
		seteaValores(rs, "12", "Linea 333 tapón (C:2, TC: 33)", "3", "33");
		
		dtoSalida.setResultado(rs);
		return dtoSalida;
	}

	private void seteaValores(RecordSet rs, String s1, String s2, String s3, String s4){
		Vector valores = new Vector();
		valores.add(s1);
		valores.add(s2);
		valores.add(s3);
		valores.add(s4);
		rs.addRow(valores);
	}
}