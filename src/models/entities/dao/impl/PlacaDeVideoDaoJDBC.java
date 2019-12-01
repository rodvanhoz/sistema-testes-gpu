package models.entities.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import models.entities.dao.PlacaDeVideoDao;
import models.entities.services.CaracteristicasGraficasService;
import models.entities.services.ProcessadorGraficoService;
import models.entities.services.RenderConfigService;
import models.entities.tables.Gpus;
import models.entities.views.PlacaDeVideo;

public class PlacaDeVideoDaoJDBC implements PlacaDeVideoDao {

	private Connection conn;
	
	public PlacaDeVideoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<PlacaDeVideo> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM PlacaDeVideo a");
			rs = st.executeQuery();

			List<PlacaDeVideo> lista = new ArrayList<>();

			while (rs.next()) {
				PlacaDeVideo dt = new PlacaDeVideo(
						rs.getInt("idGpu"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getString("nomeGpu"), 
						rs.getString("arquitetura"),
						rs.getInt("shadingUnits"),
						rs.getInt("rops"),
						rs.getInt("tmus"),
						rs.getInt("tamMemoriaKB"),
						rs.getString("tpMemoria"),
						rs.getDouble("gpuClock"),
						rs.getDouble("boostClock"),
						rs.getString("directX"),
						rs.getDouble("memClock"),
						rs.getDouble("memClockEfetivo"),
						rs.getInt("tamBanda"),
						rs.getDouble("tdp"),
						rs.getString("busInterface"),
						rs.getDate("dtLancto"));
				
				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<PlacaDeVideo> findByModeloGpu(String nomeModelo) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM PlacaDeVideo a "
					+ "where a.nomeModelo = ?");
			st.setString(1, nomeModelo);
			
			rs = st.executeQuery();

			List<PlacaDeVideo> lista = new ArrayList<>();

			while (rs.next()) {
				PlacaDeVideo dt = new PlacaDeVideo(
						rs.getInt("idGpu"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getString("nomeGpu"), 
						rs.getString("arquitetura"),
						rs.getInt("shadingUnits"),
						rs.getInt("rops"),
						rs.getInt("tmus"),
						rs.getInt("tamMemoriaKB"),
						rs.getString("tpMemoria"),
						rs.getDouble("gpuClock"),
						rs.getDouble("boostClock"),
						rs.getString("directX"),
						rs.getDouble("memClock"),
						rs.getDouble("memClockEfetivo"),
						rs.getInt("tamBanda"),
						rs.getDouble("tdp"),
						rs.getString("busInterface"),
						rs.getDate("dtLancto"));
				
				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<PlacaDeVideo> findByArquitetura(String arquitetura) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM PlacaDeVideo a "
					+ "where a.arquitetura = ?");
			st.setString(1, arquitetura);
			
			rs = st.executeQuery();

			List<PlacaDeVideo> lista = new ArrayList<>();

			while (rs.next()) {
				PlacaDeVideo dt = new PlacaDeVideo(
						rs.getInt("idGpu"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getString("nomeGpu"), 
						rs.getString("arquitetura"),
						rs.getInt("shadingUnits"),
						rs.getInt("rops"),
						rs.getInt("tmus"),
						rs.getInt("tamMemoriaKB"),
						rs.getString("tpMemoria"),
						rs.getDouble("gpuClock"),
						rs.getDouble("boostClock"),
						rs.getString("directX"),
						rs.getDouble("memClock"),
						rs.getDouble("memClockEfetivo"),
						rs.getInt("tamBanda"),
						rs.getDouble("tdp"),
						rs.getString("busInterface"),
						rs.getDate("dtLancto"));
				
				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<PlacaDeVideo> findByTpMemoria(String tpMemoria) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM PlacaDeVideo a "
					+ "where a.tpMemoria = ?");
			st.setString(1, tpMemoria);
			
			rs = st.executeQuery();

			List<PlacaDeVideo> lista = new ArrayList<>();

			while (rs.next()) {
				PlacaDeVideo dt = new PlacaDeVideo(
						rs.getInt("idGpu"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getString("nomeGpu"), 
						rs.getString("arquitetura"),
						rs.getInt("shadingUnits"),
						rs.getInt("rops"),
						rs.getInt("tmus"),
						rs.getInt("tamMemoriaKB"),
						rs.getString("tpMemoria"),
						rs.getDouble("gpuClock"),
						rs.getDouble("boostClock"),
						rs.getString("directX"),
						rs.getDouble("memClock"),
						rs.getDouble("memClockEfetivo"),
						rs.getInt("tamBanda"),
						rs.getDouble("tdp"),
						rs.getString("busInterface"),
						rs.getDate("dtLancto"));
				
				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<PlacaDeVideo> findByFabricante(String nomeFabricante) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM PlacaDeVideo a "
					+ "where a.nomeFabricante = ?");
			st.setString(1, nomeFabricante);
			
			rs = st.executeQuery();

			List<PlacaDeVideo> lista = new ArrayList<>();

			while (rs.next()) {
				PlacaDeVideo dt = new PlacaDeVideo(
						rs.getInt("idGpu"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getString("nomeGpu"), 
						rs.getString("arquitetura"),
						rs.getInt("shadingUnits"),
						rs.getInt("rops"),
						rs.getInt("tmus"),
						rs.getInt("tamMemoriaKB"),
						rs.getString("tpMemoria"),
						rs.getDouble("gpuClock"),
						rs.getDouble("boostClock"),
						rs.getString("directX"),
						rs.getDouble("memClock"),
						rs.getDouble("memClockEfetivo"),
						rs.getInt("tamBanda"),
						rs.getDouble("tdp"),
						rs.getString("busInterface"),
						rs.getDate("dtLancto"));
				
				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<PlacaDeVideo> findByBusInterface(String BusInterface) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM PlacaDeVideo a "
					+ "where a.busInterface = ?");
			st.setString(1, BusInterface);
			
			rs = st.executeQuery();

			List<PlacaDeVideo> lista = new ArrayList<>();

			while (rs.next()) {
				PlacaDeVideo dt = new PlacaDeVideo(
						rs.getInt("idGpu"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getString("nomeGpu"), 
						rs.getString("arquitetura"),
						rs.getInt("shadingUnits"),
						rs.getInt("rops"),
						rs.getInt("tmus"),
						rs.getInt("tamMemoriaKB"),
						rs.getString("tpMemoria"),
						rs.getDouble("gpuClock"),
						rs.getDouble("boostClock"),
						rs.getString("directX"),
						rs.getDouble("memClock"),
						rs.getDouble("memClockEfetivo"),
						rs.getInt("tamBanda"),
						rs.getDouble("tdp"),
						rs.getString("busInterface"),
						rs.getDate("dtLancto"));
				
				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public PlacaDeVideo findById(int idGpu) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM PlacaDeVideo a "
					+ "where a.idGpu = ?");
			st.setInt(1, idGpu);
			
			rs = st.executeQuery();

			if (rs.next()) {
				PlacaDeVideo dt = new PlacaDeVideo(
						rs.getInt("idGpu"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getString("nomeGpu"), 
						rs.getString("arquitetura"),
						rs.getInt("shadingUnits"),
						rs.getInt("rops"),
						rs.getInt("tmus"),
						rs.getInt("tamMemoriaKB"),
						rs.getString("tpMemoria"),
						rs.getDouble("gpuClock"),
						rs.getDouble("boostClock"),
						rs.getString("directX"),
						rs.getDouble("memClock"),
						rs.getDouble("memClockEfetivo"),
						rs.getInt("tamBanda"),
						rs.getDouble("tdp"),
						rs.getString("busInterface"),
						rs.getDate("dtLancto"));
				
				return dt;
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public Gpus findByIdGpu(int idGpu) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ProcessadorGraficoService procGraficoService = new ProcessadorGraficoService();
		CaracteristicasGraficasService caracGraficaService = new CaracteristicasGraficasService();
		RenderConfigService renderConfigService = new RenderConfigService();

		try {
			st = conn.prepareStatement("SELECT * FROM Gpus a "
					+ "where a.idGpu = ?");
			st.setInt(1, idGpu);
			
			rs = st.executeQuery();

			if (rs.next()) {
				
				Gpus gpu = new Gpus(rs.getInt("idGpu"), 
						procGraficoService.findById(rs.getInt("idProcessadorGrafico")), 
						caracGraficaService.findById(rs.getInt("idCaracteristicasGraficas")), 
						renderConfigService.findById(rs.getInt("idRenderConfig")),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getInt("tamMemoriaKB"),
						rs.getString("tpMemoria"),
						rs.getInt("tamBanda"),
						rs.getDouble("tdp"),
						rs.getDouble("gpuClock"),
						rs.getDouble("boostClock"),
						rs.getDouble("memClock"),
						rs.getDouble("memClockEfetivo"),
						rs.getString("busInterface"),
						rs.getDate("dtLancto"));
				
				return gpu;
						
				}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
	
	@Override
	public void inserir(Gpus gpu) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into Gpus (idProcessadorGrafico, idCaracteristicasGraficas, idRenderConfig, nomeFabricante, nomeModelo, "
					+ "tamMemoriaKB, tpMemoria, tamBanda, tdp, gpuClock, boostClock, memClock, memClockEfetivo, busInterface, dtLancto) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, gpu.getProcessadorGrafico().getIdProcGrafico());
			st.setInt(2, gpu.getCaracteristicasGraficas().getIdCaracGrafica());
			st.setInt(3, gpu.getRenderConfig().getIdRenderConfig());
			st.setString(4, gpu.getNomeFabricante());
			st.setString(5, gpu.getNomeModelo());
			st.setInt(6, gpu.getTamMemoriaKB());
			st.setString(7, gpu.getTpMemoria());
			st.setInt(8, gpu.getTamBanda());
			st.setDouble(9, gpu.getTdp());
			st.setDouble(10, gpu.getGpuClock());
			st.setDouble(11, gpu.getBoostClock());
			st.setDouble(12, gpu.getMemClock());
			st.setDouble(13, gpu.getMemClockEfetivo());
			st.setString(14, gpu.getBusInterface());
			st.setDate(15, new java.sql.Date(gpu.getDtLancto().getTime()));
			
			if (st.executeUpdate() > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Inserido! Id: " + rs.getInt(1));
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao inserir a GPU");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void alterar(Gpus gpu) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update a set a.idProcessadorGrafico = ?, a.idCaracteristicasGraficas = ?, a.idRenderConfig = ?, "
					+ "a.nomeFabricante = ?, a.nomeModelo = ?, a.tamMemoriaKB = ?, a.tpMemoria = ?, a.tamBanda = ?, a.tdp = ?, "
					+ "a.gpuClock = ?, a.boostClock = ?, a.memClock = ?, a.memClockEfetivo = ?, a.busInterface = ?, a.dtLancto = ? "
					+ "from Gpus a "
					+ "where a.idGpu = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, gpu.getProcessadorGrafico().getIdProcGrafico());
			st.setInt(2, gpu.getCaracteristicasGraficas().getIdCaracGrafica());
			st.setInt(3, gpu.getRenderConfig().getIdRenderConfig());
			st.setString(4, gpu.getNomeFabricante());
			st.setString(5, gpu.getNomeModelo());
			st.setInt(6, gpu.getTamMemoriaKB());
			st.setString(7, gpu.getTpMemoria());
			st.setInt(8, gpu.getTamBanda());
			st.setDouble(9, gpu.getTdp());
			st.setDouble(10, gpu.getGpuClock());
			st.setDouble(11, gpu.getBoostClock());
			st.setDouble(12, gpu.getMemClock());
			st.setDouble(13, gpu.getMemClockEfetivo());
			st.setString(14, gpu.getBusInterface());
			st.setDate(15, new java.sql.Date(gpu.getDtLancto().getTime()));
			st.setInt(16, gpu.getIdGpu());
			
			if (st.executeUpdate() > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Alterado! Id: " + gpu.getIdGpu());
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao alterar a GPU");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void remover(Gpus gpu) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete a"
					+ "from Gpus a "
					+ "where a.idGpu = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, gpu.getIdGpu());
			
			if (st.executeUpdate() > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Deletado! Id: " + gpu.getIdGpu());
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao deletar a GPU");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

}
