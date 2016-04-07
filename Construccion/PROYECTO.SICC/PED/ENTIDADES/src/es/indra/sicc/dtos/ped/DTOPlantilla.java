package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.TreeSet;

	public class DTOPlantilla extends DTOAuditableSICC {
	private TreeSet gp1;
	private TreeSet gp2;
	private TreeSet gp3;
	private TreeSet gp4;
	private TreeSet gp5;
	private String codigo;
	private String descripcion;
	private Long oid;
	
	public DTOPlantilla() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String newCodigo) {
		codigo = newCodigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		descripcion = newDescripcion;
	}

	public TreeSet getGp1() {
		return gp1;
	}

	public void setGp1(TreeSet newGp1) {
		gp1 = newGp1;
	}

	public TreeSet getGp2() {
		return gp2;
	}

	public void setGp2(TreeSet newGp2) {
		gp2 = newGp2;
	}

	public TreeSet getGp3() {
		return gp3;
	}

	public void setGp3(TreeSet newGp3) {
		gp3 = newGp3;
	}

	public TreeSet getGp4() {
		return gp4;
	}

	public void setGp4(TreeSet newGp4) {
		gp4 = newGp4;
	}

	public TreeSet getGp5() {
		return gp5;
	}

	public void setGp5(TreeSet newGp5) {
		gp5 = newGp5;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}
}