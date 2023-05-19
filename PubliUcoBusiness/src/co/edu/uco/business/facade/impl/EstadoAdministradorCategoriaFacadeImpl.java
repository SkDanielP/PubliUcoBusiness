package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoAdministradoCategoriaBusiness;
import co.edu.uco.business.businessimpl.EstadoAdministradorCategoriaBusinessImpl;
import co.edu.uco.business.domain.EstadoAdministradorCategoriaDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoAdministradorCategoriaAssembler;
import co.edu.uco.business.facade.EstadoAdministradorCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoAdministradorCategoriaDTO;

public final class EstadoAdministradorCategoriaFacadeImpl implements EstadoAdministradorCategoriaFacade {

    private final DAOFactory daoFactory;
    private final EstadoAdministradoCategoriaBusiness business;

    public EstadoAdministradorCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoAdministradorCategoriaBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoAdministradorCategoriaDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoAdministradorCategoriaDomain domain = EstadoAdministradorCategoriaAssembler.getInstance().toDomainFromDto(dto);

            // Perform any necessary operations before registering

            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado del administrador de la categoría. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoAdministradorCategoriaDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoAdministradorCategoriaDTO> list(EstadoAdministradorCategoriaDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoAdministradorCategoriaDTO dto) {

    }

    @Override
    public void drop(EstadoAdministradorCategoriaDTO dto) {

    }
}
