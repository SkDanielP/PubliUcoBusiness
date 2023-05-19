package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoRevisionBusiness;
import co.edu.uco.business.businessimpl.EstadoRevisionBusinessImpl;
import co.edu.uco.business.domain.EstadoRevisionDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoRevisionAssembler;
import co.edu.uco.business.facade.EstadoRevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoRevisionDTO;

public final class EstadoRevisionFacadeImpl implements EstadoRevisionFacade {

    private final DAOFactory daoFactory;
    private final EstadoRevisionBusiness business;

    public EstadoRevisionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoRevisionBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoRevisionDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoRevisionDomain domain = EstadoRevisionAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado de revisión. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoRevisionDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoRevisionDTO> list(EstadoRevisionDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoRevisionDTO dto) {

    }

    @Override
    public void drop(EstadoRevisionDTO dto) {

    }
}
