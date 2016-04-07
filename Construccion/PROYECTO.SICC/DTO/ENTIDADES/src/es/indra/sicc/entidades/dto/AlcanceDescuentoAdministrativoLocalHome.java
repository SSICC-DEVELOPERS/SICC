package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.AlcanceDescuentoAdministrativoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class AlcanceDescuentoAdministrativoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public AlcanceDescuentoAdministrativoLocal create(Long dcto_oid_desc, Long zsgv_oid_subg_vent, Long zorg_oid_regi, Long zzon_oid_zona) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_ALAD_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AlcanceDescuentoAdministrativoLocal local = new AlcanceDescuentoAdministrativoLocal(oid, dcto_oid_desc, zsgv_oid_subg_vent, zorg_oid_regi, zzon_oid_zona);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AlcanceDescuentoAdministrativoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AlcanceDescuentoAdministrativoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AlcanceDescuentoAdministrativoLocal findByPrimaryKey(Long  oid) {
		AlcanceDescuentoAdministrativoLocal local = (AlcanceDescuentoAdministrativoLocal)em.find(AlcanceDescuentoAdministrativoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
