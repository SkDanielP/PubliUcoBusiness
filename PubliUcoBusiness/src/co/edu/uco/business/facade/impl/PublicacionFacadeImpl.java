package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.PublicacionBusiness;
import co.edu.uco.business.businessimpl.PublicacionBusinessImpl;
import co.edu.uco.business.domain.PublicacionDomain;
import co.edu.uco.business.domain.assembler.concrete.PublicacionAssembler;
import co.edu.uco.business.facade.PublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PublicacionDTO;

public final class PublicacionFacadeImpl implements PublicacionFacade {

    private final DAOFactory daoFactory;
    private final PublicacionBusiness business;

    public PublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new PublicacionBusinessImpl(daoFactory);
    }

    @Override
    public void register(PublicacionDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final PublicacionDomain domain = PublicacionAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información de la nueva publicación. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar la nueva PublicacionDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<PublicacionDTO> list(PublicacionDTO dto) {
        return null;
    }

    @Override
    public void modify(PublicacionDTO dto) {

    }

    @Override
    public void drop(PublicacionDTO dto) {

    }
}
