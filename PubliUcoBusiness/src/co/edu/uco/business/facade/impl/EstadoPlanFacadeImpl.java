package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoPlanBusiness;
import co.edu.uco.business.businessimpl.EstadoPlanBusinessImpl;
import co.edu.uco.business.domain.EstadoPlanDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoPlanAssembler;
import co.edu.uco.business.facade.EstadoPlanFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoPlanDTO;

public final class EstadoPlanFacadeImpl implements EstadoPlanFacade {

    private final DAOFactory daoFactory;
    private final EstadoPlanBusiness business;

    public EstadoPlanFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoPlanBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoPlanDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoPlanDomain domain = EstadoPlanAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado del plan. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoPlanDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoPlanDTO> list(EstadoPlanDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoPlanDTO dto) {

    }

    @Override
    public void drop(EstadoPlanDTO dto) {

    }
}
