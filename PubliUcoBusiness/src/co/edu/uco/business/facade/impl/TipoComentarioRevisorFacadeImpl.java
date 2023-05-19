package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.TipoComentarioRevisorBusiness;
import co.edu.uco.business.businessimpl.TipoComentarioRevisorBusinessImpl;
import co.edu.uco.business.domain.TipoComentarioRevisorDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoComentarioRevisorAssembler;
import co.edu.uco.business.facade.TipoComentarioRevisorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoComentarioRevisorDTO;

public final class TipoComentarioRevisorFacadeImpl implements TipoComentarioRevisorFacade {

    private final DAOFactory daoFactory;
    private final TipoComentarioRevisorBusiness business;

    public TipoComentarioRevisorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new TipoComentarioRevisorBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoComentarioRevisorDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final TipoComentarioRevisorDomain domain = TipoComentarioRevisorAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo tipo de comentario del revisor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo TipoComentarioRevisorDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<TipoComentarioRevisorDTO> list(TipoComentarioRevisorDTO dto) {
        return null;
    }

    @Override
    public void modify(TipoComentarioRevisorDTO dto) {

    }

    @Override
    public void drop(TipoComentarioRevisorDTO dto) {

    }
}

