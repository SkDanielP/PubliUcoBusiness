package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoLectorBusiness;
import co.edu.uco.business.businessimpl.EstadoLectorBusinessImpl;
import co.edu.uco.business.domain.EstadoLectorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoLectorAssembler;
import co.edu.uco.business.facade.EstadoLectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoLectorDTO;

public final class EstadoLectorFacadeImpl implements EstadoLectorFacade {

    private final DAOFactory daoFactory;
    private final EstadoLectorBusiness business;

    public EstadoLectorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoLectorBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoLectorDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoLectorDomain domain = EstadoLectorAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado del lector. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoLectorDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoLectorDTO> list(EstadoLectorDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoLectorDTO dto) {

    }

    @Override
    public void drop(EstadoLectorDTO dto) {

    }
}

