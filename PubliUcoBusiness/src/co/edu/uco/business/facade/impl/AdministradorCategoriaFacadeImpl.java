package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.AdministradorCategoriaBusiness;
import co.edu.uco.business.businessimpl.AdministradorCategoriaBusinessImpl;
import co.edu.uco.business.domain.AdministradorCategoriaDomain;
import co.edu.uco.business.domain.assembler.concrete.AdministradorCategoriaAssembler;
import co.edu.uco.business.facade.AdministradorCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;

public final class AdministradorCategoriaFacadeImpl implements AdministradorCategoriaFacade {

    private final DAOFactory daoFactory;
    private final AdministradorCategoriaBusiness business;

    public AdministradorCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new AdministradorCategoriaBusinessImpl(daoFactory);
    }

    @Override
    public void register(AdministradorCategoriaDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final AdministradorCategoriaDomain domain = AdministradorCategoriaAssembler.getInstance().toDomainFromDto(dto);
            
            
            business.register(domain);
            
            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();
            
            var userMessage = "Se ha presentado un problema tratando de registrar la informacion de la nueva categoria de administrador. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
            var technicalMessage = "Se ha presentado una excepcion no conocida al momento de registrar la nueva AdministradorCategoriaDTO. Por favor valide la traza completa de la excepcion presentada";
            
            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<AdministradorCategoriaDTO> list(AdministradorCategoriaDTO dto) {
        return null;
    }

    @Override
    public void modify(AdministradorCategoriaDTO dto) {
        
    }

    @Override
    public void drop(AdministradorCategoriaDTO dto) {
        
    }
}
