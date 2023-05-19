package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.EstadoPreferenciaBusiness;
import co.edu.uco.business.businessimpl.EstadoPreferenciaBusinessImpl;
import co.edu.uco.business.domain.EstadoPreferenciaDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoPreferenciaAssembler;
import co.edu.uco.business.facade.EstadoPreferenciaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoPreferenciaDTO;

public final class EstadoPreferenciaFacadeImpl implements EstadoPreferenciaFacade {

    private final DAOFactory daoFactory;
    private final EstadoPreferenciaBusiness business;

    public EstadoPreferenciaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new EstadoPreferenciaBusinessImpl(daoFactory);
    }

    @Override
    public void register(EstadoPreferenciaDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final EstadoPreferenciaDomain domain = EstadoPreferenciaAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo estado de preferencia. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo EstadoPreferenciaDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<EstadoPreferenciaDTO> list(EstadoPreferenciaDTO dto) {
        return null;
    }

    @Override
    public void modify(EstadoPreferenciaDTO dto) {

    }

    @Override
    public void drop(EstadoPreferenciaDTO dto) {

    }
}

