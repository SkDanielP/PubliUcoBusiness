package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoEscritorBusiness;
import co.edu.uco.business.businessimpl.EstadoEscritorBusinessImpl;
import co.edu.uco.business.domain.EstadoEscritorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoEscritorAssembler;
import co.edu.uco.business.facade.EstadoEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoEscritorDTO;

public final class EstadoEscritorFacadeImpl implements EstadoEscritorFacade {

    private final DAOFactory daoFactory;
    private final EstadoEscritorBusiness business;

    public EstadoEscritorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoEscritorBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoEscritorDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoEscritorDomain domain = EstadoEscritorAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado del escritor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoEscritorDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoEscritorDTO> list(EstadoEscritorDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoEscritorDTO dto) {

    }

    @Override
    public void drop(EstadoEscritorDTO dto) {

    }
}
