package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.TipoRevisionBusiness;
import co.edu.uco.business.businessimpl.TipoRevisionBusinessImpl;
import co.edu.uco.business.domain.TipoRevisionDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoRevisionAssembler;
import co.edu.uco.business.facade.TipoRevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoRevisionDTO;

public final class TipoRevisionFacadeImpl implements TipoRevisionFacade {

    private final DAOFactory daoFactory;
    private final TipoRevisionBusiness business;

    public TipoRevisionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new TipoRevisionBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoRevisionDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final TipoRevisionDomain domain = TipoRevisionAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo tipo de revisión. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo TipoRevisionDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<TipoRevisionDTO> list(TipoRevisionDTO dto) {
        return null;
    }

    @Override
    public void modify(TipoRevisionDTO dto) {

    }

    @Override
    public void drop(TipoRevisionDTO dto) {

    }
}
