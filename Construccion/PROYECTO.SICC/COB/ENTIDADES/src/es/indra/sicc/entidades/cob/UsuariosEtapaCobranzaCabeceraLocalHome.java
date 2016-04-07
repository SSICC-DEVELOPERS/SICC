package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class UsuariosEtapaCobranzaCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public UsuariosEtapaCobranzaCabeceraLocal create(Long uscoOidUsuaCobr, Long etdeOidEtapDeud) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_UECC_SEQ");
		et.begin();
		UsuariosEtapaCobranzaCabeceraLocal local = new UsuariosEtapaCobranzaCabeceraLocal(oid, uscoOidUsuaCobr, etdeOidEtapDeud);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(UsuariosEtapaCobranzaCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(UsuariosEtapaCobranzaCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public UsuariosEtapaCobranzaCabeceraLocal findByPrimaryKey(Long  oid) {
		UsuariosEtapaCobranzaCabeceraLocal local = (UsuariosEtapaCobranzaCabeceraLocal)em.find(UsuariosEtapaCobranzaCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("UsuariosEtapaCobranzaCabeceraLocal.FindAll");          
            return query.getResultList();
        }


}
