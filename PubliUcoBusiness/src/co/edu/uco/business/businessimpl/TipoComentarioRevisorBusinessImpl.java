 package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.TipoComentarioRevisorBusiness;
import co.edu.uco.business.domain.TipoComentarioRevisorDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoComentarioRevisorAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoComentarioRevisorEntity;

public final class TipoComentarioRevisorBusinessImpl implements TipoComentarioRevisorBusiness {
		
		private DAOFactory daoFactory;
		
		public TipoComentarioRevisorBusinessImpl(final DAOFactory daoFactory) {
			this.daoFactory = daoFactory;
		}

		@Override
		public void register(TipoComentarioRevisorDomain domain) {
			TipoComentarioRevisorEntity entity = TipoComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain);
			daoFactory.getTipoComentarioRevisorDAO().create(entity);
		}

		@Override
		public List<TipoComentarioRevisorDomain> list(TipoComentarioRevisorDomain domain) {
			TipoComentarioRevisorEntity entity = TipoComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain);
			List<TipoComentarioRevisorEntity> result = daoFactory.getTipoComentarioRevisorDAO().read(entity);
			return null;
		}

		@Override
		public void modify(TipoComentarioRevisorDomain domain) {
			TipoComentarioRevisorEntity entity = TipoComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain);
			daoFactory.getTipoComentarioRevisorDAO().update(entity);
		}

		@Override
		public void drop(TipoComentarioRevisorDomain domain) {
			TipoComentarioRevisorEntity entity = TipoComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain);
			daoFactory.getTipoComentarioRevisorDAO().delete(entity);
		}
	}
