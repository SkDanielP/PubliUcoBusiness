package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoSuscripcionBusiness;
import co.edu.uco.business.businessimpl.EstadoSuscripcionBusinessImpl;
import co.edu.uco.business.domain.EstadoSuscripcionDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoSuscripcionAssembler;
import co.edu.uco.business.facade.EstadoSuscripcionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoSuscripcionDTO;

public final class EstadoSuscripcionFacadeImpl implements EstadoSuscripcionFacade {

    private final DAOFactory daoFactory;
    private final EstadoSuscripcionBusiness business;

    public EstadoSuscripcionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoSuscripcionBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoSuscripcionDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoSuscripcionDomain domain = EstadoSuscripcionAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado de suscripción. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoSuscripcionDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoSuscripcionDTO> list(EstadoSuscripcionDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoSuscripcionDTO dto) {

    }

    @Override
    public void drop(EstadoSuscripcionDTO dto) {

    }
}

