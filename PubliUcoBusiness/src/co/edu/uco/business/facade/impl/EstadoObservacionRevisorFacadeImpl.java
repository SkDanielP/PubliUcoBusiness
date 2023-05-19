package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoObservacionRevisorBusiness;
import co.edu.uco.business.businessimpl.EstadoObservacionRevisorBusinessImpl;
import co.edu.uco.business.domain.EstadoObservacionRevisorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoObservacionRevisorAssembler;
import co.edu.uco.business.facade.EstadoObservacionRevisorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoObservacionRevisorDTO;

public final class EstadoObservacionRevisorFacadeImpl implements EstadoObservacionRevisorFacade {

    private final DAOFactory daoFactory;
    private final EstadoObservacionRevisorBusiness business;

    public EstadoObservacionRevisorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoObservacionRevisorBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoObservacionRevisorDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoObservacionRevisorDomain domain = EstadoObservacionRevisorAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado de la observación del revisor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoObservacionRevisorDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoObservacionRevisorDTO> list(EstadoObservacionRevisorDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoObservacionRevisorDTO dto) {

    }

    @Override
    public void drop(EstadoObservacionRevisorDTO dto) {

    }
}

