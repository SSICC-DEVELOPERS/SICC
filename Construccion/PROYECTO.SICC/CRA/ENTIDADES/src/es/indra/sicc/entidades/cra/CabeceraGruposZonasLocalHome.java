package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.CabeceraGruposZonasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CabeceraGruposZonasLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public CabeceraGruposZonasLocal create(Long pais_oid_pais, 
                                    Long marc_oid_marc, Long cana_oid_cana, 
                                    Integer cod_grup,
                                    Long cod_tipo_fact, Boolean ind_esta) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_CGZO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CabeceraGruposZonasLocal local = new CabeceraGruposZonasLocal(oid, pais_oid_pais, 
                                    marc_oid_marc, cana_oid_cana, cod_grup, cod_tipo_fact, ind_esta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CabeceraGruposZonasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraGruposZonasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraGruposZonasLocal findByPrimaryKey(Long  oid) {
		CabeceraGruposZonasLocal local = em.find(CabeceraGruposZonasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOldPK(Long marca, Long pais, Long canal, Integer codigoGrupo) {
		Query query=em.createNamedQuery("CabeceraGruposZonasLocal.FindByOldPK");
		
		query.setParameter(1, marca);
		query.setParameter(2, pais);
		query.setParameter(3, canal);
		query.setParameter(4, codigoGrupo);

		return query.getResultList();
	}

}
