package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.CalificacionBusiness;
import co.edu.uco.business.businessimpl.CalificacionBusinessImpl;
import co.edu.uco.business.domain.CalificacionDomain;
import co.edu.uco.business.domain.assembler.concrete.CalificacionAssembler;
import co.edu.uco.business.facade.CalificacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.CalificacionDTO;

public final class CalificacionFacadeImpl implements CalificacionFacade {

    private final DAOFactory daoFactory;
    private final CalificacionBusiness business;

    public CalificacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new CalificacionBusinessImpl(daoFactory);
    }

    @Override
    public void register(CalificacionDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final CalificacionDomain domain = CalificacionAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información de la nueva calificación. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar la nueva CalificacionDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<CalificacionDTO> list(CalificacionDTO dto) {
        return null;
    }

    @Override
    public void modify(CalificacionDTO dto) {

    }

    @Override
    public void drop(CalificacionDTO dto) {

    }
}

