package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.TipoAccesoBusiness;
import co.edu.uco.business.businessimpl.TipoAccesoBusinessImpl;
import co.edu.uco.business.domain.TipoAccesoDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoAccesoAssembler;
import co.edu.uco.business.facade.TipoAccesoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoAccesoDTO;

public final class TipoAccesoFacadeImpl implements TipoAccesoFacade {

    private final DAOFactory daoFactory;
    private final TipoAccesoBusiness business;

    public TipoAccesoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new TipoAccesoBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoAccesoDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final TipoAccesoDomain domain = TipoAccesoAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo tipo de acceso. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo TipoAccesoDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<TipoAccesoDTO> list(TipoAccesoDTO dto) {
        return null;
    }

    @Override
    public void modify(TipoAccesoDTO dto) {

    }

    @Override
    public void drop(TipoAccesoDTO dto) {

    }
}
