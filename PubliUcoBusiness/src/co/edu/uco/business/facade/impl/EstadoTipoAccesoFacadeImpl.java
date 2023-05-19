package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoTipoAccesoBusiness;
import co.edu.uco.business.businessimpl.EstadoTipoAccesoBusinessImpl;
import co.edu.uco.business.domain.EstadoTipoAccesoDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoTipoAccesoAssembler;
import co.edu.uco.business.facade.EstadoTipoAccesoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoTipoAccesoDTO;

public final class EstadoTipoAccesoFacadeImpl implements EstadoTipoAccesoFacade {

    private final DAOFactory daoFactory;
    private final EstadoTipoAccesoBusiness business;

    public EstadoTipoAccesoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoTipoAccesoBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoTipoAccesoDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoTipoAccesoDomain domain = EstadoTipoAccesoAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado del tipo de acceso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoTipoAccesoDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoTipoAccesoDTO> list(EstadoTipoAccesoDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoTipoAccesoDTO dto) {

    }

    @Override
    public void drop(EstadoTipoAccesoDTO dto) {

    }
}
