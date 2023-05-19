package co.edu.uco.business.facade.impl;

import java.util.List;

import co.edu.uco.business.business.TipoReporteBusiness;
import co.edu.uco.business.businessimpl.TipoReporteBusinessImpl;
import co.edu.uco.business.domain.TipoReporteDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoReporteAssembler;
import co.edu.uco.business.facade.TipoReporteFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoReporteDTO;

public final class TipoReporteFacadeImpl implements TipoReporteFacade {

    private final DAOFactory daoFactory;
    private final TipoReporteBusiness business;

    public TipoReporteFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.SQLSERVER);
        business = new TipoReporteBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoReporteDTO dto) {
        try {
            daoFactory.iniciarTransaccion();
            final TipoReporteDomain domain = TipoReporteAssembler.getInstance().toDomainFromDto(dto);


            business.register(domain);

            daoFactory.confirmarTransaccion();
        } catch (PubliucoException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransaccion();

            var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo tipo de reporte. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación...";
            var technicalMessage = "Se ha presentado una excepción no conocida al momento de registrar el nuevo TipoReporteDTO. Por favor valide la traza completa de la excepción presentada";

            throw PubliucoBussinesException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<TipoReporteDTO> list(TipoReporteDTO dto) {
        return null;
    }

    @Override
    public void modify(TipoReporteDTO dto) {

    }

    @Override
    public void drop(TipoReporteDTO dto) {

    }
}


