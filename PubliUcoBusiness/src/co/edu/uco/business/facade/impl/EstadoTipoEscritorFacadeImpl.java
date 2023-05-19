package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoTipoEscritorBusiness;
import co.edu.uco.business.businessimpl.EstadoTipoEscritorBusinessImpl;
import co.edu.uco.business.domain.EstadoTipoEscritorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoTipoEscritorAssembler;
import co.edu.uco.business.facade.EstadoTipoEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoTipoEscritorDTO;

public final class EstadoTipoEscritorFacadeImpl implements EstadoTipoEscritorFacade {

    private final DAOFactory daoFactory;
    private final EstadoTipoEscritorBusiness business;

    public EstadoTipoEscritorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoTipoEscritorBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoTipoEscritorDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoTipoEscritorDomain domain = EstadoTipoEscritorAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado del tipo de escritor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoTipoEscritorDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoTipoEscritorDTO> list(EstadoTipoEscritorDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoTipoEscritorDTO dto) {

    }

    @Override
    public void drop(EstadoTipoEscritorDTO dto) {

    }
}

