package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.CategoriaBusiness;
import co.edu.uco.business.businessimpl.CategoriaBusinessImpl;
import co.edu.uco.business.domain.CategoriaDomain;
import co.edu.uco.business.facade.CategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.CategoriaDTO;

public final class CategoriaFacadeImpl implements CategoriaFacade {

    private final DAOFactory daoFactory;
    private final CategoriaBusiness business;

    public CategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new CategoriaBusinessImpl(daoFactory);
    }

    @Override
    public void register(CategoriaDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final CategoriaDomain domain = CategoriaAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información de la nueva categoría. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar la nueva CategoriaDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<CategoriaDTO> list(CategoriaDTO dto) {
        return null;
    }

    @Override
    public void modify(CategoriaDTO dto) {

    }

    @Override
    public void drop(CategoriaDTO dto) {

    }
}
