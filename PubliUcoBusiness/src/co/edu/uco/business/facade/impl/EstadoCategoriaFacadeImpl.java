package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoCategoriaBusiness;
import co.edu.uco.business.businessimpl.EstadoCategoriaBusinessImpl;
import co.edu.uco.business.domain.EstadoCategoriaDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoCategoriaAssembler;
import co.edu.uco.business.facade.EstadoCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoCategoriaDTO;

public final class EstadoCategoriaFacadeImpl implements EstadoCategoriaFacade {

    private final DAOFactory daoFactory;
    private final EstadoCategoriaBusiness business;

    public EstadoCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoCategoriaBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoCategoriaDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoCategoriaDomain domain = EstadoCategoriaAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado de la categoría. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoCategoriaDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoCategoriaDTO> list(EstadoCategoriaDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoCategoriaDTO dto) {

    }

    @Override
    public void drop(EstadoCategoriaDTO dto) {

    }
}

