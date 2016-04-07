package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class UsuariosEtapaCobranzaDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public UsuariosEtapaCobranzaDetalleLocal create(Long zsgvOidSubgVent, Long edtcOidEtapDeudTipoCarg, Long ueccOidUsuaEtapCobr, Long zorgOidRegi, Long zzonOidZona, Long zsccOidSecc, Long terrOidTerr, Long gacaOidGuioArguCabe, Long melcOidMetoLiquCobr
                        ) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_UECD_SEQ"); 
		et.begin();
		UsuariosEtapaCobranzaDetalleLocal local = new UsuariosEtapaCobranzaDetalleLocal(oid, zsgvOidSubgVent, edtcOidEtapDeudTipoCarg, ueccOidUsuaEtapCobr, zorgOidRegi, zzonOidZona, zsccOidSecc, terrOidTerr, gacaOidGuioArguCabe, melcOidMetoLiquCobr);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(UsuariosEtapaCobranzaDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(UsuariosEtapaCobranzaDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public UsuariosEtapaCobranzaDetalleLocal findByPrimaryKey(Long  oid) {
		UsuariosEtapaCobranzaDetalleLocal local = (UsuariosEtapaCobranzaDetalleLocal)em.find(UsuariosEtapaCobranzaDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("UsuariosEtapaCobranzaDetalleLocal.FindAll");          
            return query.getResultList();
        }


}
