package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.LectorBusiness;
import co.edu.uco.business.businessimpl.LectorBusinessImpl;
import co.edu.uco.business.domain.LectorDomain;
import co.edu.uco.business.domain.assembler.concrete.LectorAssembler;
import co.edu.uco.business.facade.LectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.LectorDTO;

public final class LectorFacadeImpl implements LectorFacade {

    private final DAOFactory daoFactory;
    private final LectorBusiness business;

    public LectorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new LectorBusinessImpl(daoFactory);
    }

    @Override
    public void register(LectorDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final LectorDomain domain = LectorAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo lector. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo LectorDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<LectorDTO> list(LectorDTO dto) {
        return null;
    }

    @Override
    public void modify(LectorDTO dto) {

    }

    @Override
    public void drop(LectorDTO dto) {

    }
}
