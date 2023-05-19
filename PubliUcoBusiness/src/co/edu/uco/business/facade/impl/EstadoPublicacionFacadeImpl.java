package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoPublicacionBusiness;
import co.edu.uco.business.businessimpl.EstadoPublicacionBusinessImpl;
import co.edu.uco.business.domain.EstadoPublicacionDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoPublicacionAssembler;
import co.edu.uco.business.facade.EstadoPublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoPublicacionDTO;

public final class EstadoPublicacionFacadeImpl implements EstadoPublicacionFacade {

    private final DAOFactory daoFactory;
    private final EstadoPublicacionBusiness business;

    public EstadoPublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoPublicacionBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoPublicacionDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoPublicacionDomain domain = EstadoPublicacionAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado de publicación. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoPublicacionDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoPublicacionDTO> list(EstadoPublicacionDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoPublicacionDTO dto) {

    }

    @Override
    public void drop(EstadoPublicacionDTO dto) {

    }
}
