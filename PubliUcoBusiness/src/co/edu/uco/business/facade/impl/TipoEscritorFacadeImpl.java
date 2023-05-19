package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.TipoEscritorBusiness;
import co.edu.uco.business.businessimpl.EstadoTipoEscritorBusinessImpl;
import co.edu.uco.business.businessimpl.TipoEscritorBusinessImpl;
import co.edu.uco.business.domain.TipoEscritorDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoEscritorAssembler;
import co.edu.uco.business.facade.TipoEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoEscritorDTO;

public final class TipoEscritorFacadeImpl implements TipoEscritorFacade {

    private final DAOFactory daoFactory;
    private final TipoEscritorBusiness business;

    public TipoEscritorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new TipoEscritorBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoEscritorDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final TipoEscritorDomain domain = TipoEscritorAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo tipo de escritor. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo TipoEscritorDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<TipoEscritorDTO> list(TipoEscritorDTO dto) {
        return null;
    }

    @Override
    public void modify(TipoEscritorDTO dto) {

    }

    @Override
    public void drop(TipoEscritorDTO dto) {

    }
}
