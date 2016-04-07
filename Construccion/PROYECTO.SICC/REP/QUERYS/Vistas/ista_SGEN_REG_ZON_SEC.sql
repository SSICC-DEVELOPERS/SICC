CREATE OR REPLACE FORCE VIEW OWN_PERU.V_SGEN_REG_ZON_SEC
(OID_SUBG_VENT, OID_REGI, OID_ZONA, OID_SECC)
AS 
SELECT 
	   SUBG.OID_SUBG_VENT, 
	   REG.OID_REGI, 
	   ZON.OID_ZONA, 
	   SEC.OID_SECC
FROM 
	 ZON_SUB_GEREN_VENTA SUBG, 
	 ZON_REGIO REG, 
	 ZON_ZONA ZON,
	 ZON_SECCI SEC
WHERE 
	  SUBG.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT(+)
	  AND REG.OID_REGI = ZON.ZORG_OID_REGI(+)
	  AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA(+)
ORDER BY
	  SUBG.OID_SUBG_VENT, 
	  REG.OID_REGI, 
	  ZON.OID_ZONA, 
	  SEC.OID_SECC;

COMMENT ON TABLE OWN_PERU.V_SGEN_REG_ZON_SEC IS 'Informacion de OID segun Gerarquia.';


GRANT SELECT ON  OWN_PERU.V_SGEN_REG_ZON_SEC TO USU_PERU;
