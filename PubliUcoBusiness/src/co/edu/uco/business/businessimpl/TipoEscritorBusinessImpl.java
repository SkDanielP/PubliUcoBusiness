package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.TipoEscritorBusiness;
import co.edu.uco.business.domain.TipoEscritorDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoEscritorAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoEscritorEntity;

public final class TipoEscritorBusinessImpl implements TipoEscritorBusiness {

    private DAOFactory daoFactory;

    public TipoEscritorBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void register(TipoEscritorDomain domain) {
        TipoEscritorEntity entity = TipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getTipoEscritorDAO().create(entity);
    }

    @Override
    public List<TipoEscritorDomain> list(TipoEscritorDomain domain) {
        TipoEscritorEntity entity = TipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
        List<TipoEscritorEntity> result = daoFactory.getTipoEscritorDAO().read(entity);
        return null;
    }

    @Override
    public void modify(TipoEscritorDomain domain) {
        TipoEscritorEntity entity = TipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getTipoEscritorDAO().update(entity);
    }

    @Override
    public void drop(TipoEscritorDomain domain) {
        TipoEscritorEntity entity = TipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getTipoEscritorDAO().delete(entity);
    }
}