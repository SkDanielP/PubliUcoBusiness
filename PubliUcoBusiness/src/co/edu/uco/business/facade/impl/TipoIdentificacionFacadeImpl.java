package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.TipoIdentificacionBusiness;
import co.edu.uco.business.businessimpl.TipoIdentificacionBusinessImpl;
import co.edu.uco.business.domain.TipoIdentificacionDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoIdentificacionAssembler;
import co.edu.uco.business.facade.TipoIdentificacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;

public final class TipoIdentificacionFacadeImpl implements TipoIdentificacionFacade {

    private final DAOFactory daoFactory;
    private final TipoIdentificacionBusiness business;

    public TipoIdentificacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new TipoIdentificacionBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoIdentificacionDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final TipoIdentificacionDomain domain = TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo tipo de identificación. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo TipoIdentificacionDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<TipoIdentificacionDTO> list(TipoIdentificacionDTO dto) {
        return null;
    }

    @Override
    public void modify(TipoIdentificacionDTO dto) {

    }

    @Override
    public void drop(TipoIdentificacionDTO dto) {

    }
}

