package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

public class MONExtensionPED  {
	public MONExtensionPED() {
	}

	public void guardaImpuestoNegocio(MareDTO dto) throws MareException {
		long sbac = dto.getLong("sbacOidSbac");
		long pais = dto.getLong("paisOidPais");

		try {
            BelcorpService bs =  BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();
            query.append(" SELECT * ");
            query.append("   FROM ped_impue_gener ");
            query.append("  WHERE ped_impue_gener.pais_oid_pais = " + pais );
            query.append("    AND ped_impue_gener.sbac_oid_sbac = " + sbac );

            RecordSet resultado = bs.dbService.executeStaticQuery(query.toString());          

			if (!resultado.esVacio()) {
				//Si existe algún registro devuelto se lanza la siguiente MareException: 
	            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_003));
			}
	            
        }catch (Exception e)  {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
	}
}