package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoComentarioLectorBusiness;
import co.edu.uco.business.businessimpl.EstadoComentarioLectorBusinessImpl;
import co.edu.uco.business.domain.EstadoComentarioLectorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoComentarioLectorAssembler;
import co.edu.uco.business.facade.EstadoComentarioLectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoComentarioLectorDTO;

public final class EstadoComentarioLectorFacadeImpl implements EstadoComentarioLectorFacade {

    private final DAOFactory daoFactory;
    private final EstadoComentarioLectorBusiness business;

    public EstadoComentarioLectorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoComentarioLectorBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoComentarioLectorDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoComentarioLectorDomain domain = EstadoComentarioLectorAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado del comentario del lector. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoComentarioLectorDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoComentarioLectorDTO> list(EstadoComentarioLectorDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoComentarioLectorDTO dto) {

    }

    @Override
    public void drop(EstadoComentarioLectorDTO dto) {

    }
}

