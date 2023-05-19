package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoRevisorBusiness;
import co.edu.uco.business.businessimpl.EstadoRevisorBusinessImpl;
import co.edu.uco.business.domain.EstadoRevisorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoRevisorAssembler;
import co.edu.uco.business.facade.EstadoRevisorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoRevisorDTO;

public final class EstadoRevisorFacadeImpl implements EstadoRevisorFacade {

    private final DAOFactory daoFactory;
    private final EstadoRevisorBusiness business;

    public EstadoRevisorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoRevisorBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoRevisorDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoRevisorDomain domain = EstadoRevisorAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado del revisor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoRevisorDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoRevisorDTO> list(EstadoRevisorDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoRevisorDTO dto) {

    }

    @Override
    public void drop(EstadoRevisorDTO dto) {

    }
}
