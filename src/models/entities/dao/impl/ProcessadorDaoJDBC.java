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
import models.entities.dao.ProcessadorDao;
import models.entities.services.DadosProcessadorService;
import models.entities.services.PlacaDeVideoService;
import models.entities.tables.DadosProcessador;
import models.entities.tables.Gpus;
import models.entities.tables.Processadores;
import models.entities.views.PlacaDeVideo;
import models.entities.views.Processador;

public class ProcessadorDaoJDBC implements ProcessadorDao {

	private Connection conn;
	
	public ProcessadorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Processador> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a ");
			rs = st.executeQuery();

			List<Processador> lista = new ArrayList<>();

			while (rs.next()) {
				Processador dt = new Processador(rs.getInt("idProcessador"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getInt("nroCores"),
						rs.getInt("nroThreads"),
						rs.getDouble("tdp"),
						rs.getDouble("frequencia"),
						rs.getDouble("turboFrequencia"),
						rs.getString("codeName"),
						rs.getString("socket"),
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Processador> findByModelo(String modelo) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.nomeModelo = ?");
			
			st.setString(1, modelo);
			rs = st.executeQuery();

			List<Processador> lista = new ArrayList<>();

			while (rs.next()) {
				Processador dt = new Processador(rs.getInt("idProcessador"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getInt("nroCores"),
						rs.getInt("nroThreads"),
						rs.getDouble("tdp"),
						rs.getDouble("frequencia"),
						rs.getDouble("turboFrequencia"),
						rs.getString("codeName"),
						rs.getString("socket"),
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Processador> findByFabricante(String fabricante) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.nomeFabricante = ?");
			
			st.setString(1, fabricante);
			rs = st.executeQuery();

			List<Processador> lista = new ArrayList<>();

			while (rs.next()) {
				Processador dt = new Processador(rs.getInt("idProcessador"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getInt("nroCores"),
						rs.getInt("nroThreads"),
						rs.getDouble("tdp"),
						rs.getDouble("frequencia"),
						rs.getDouble("turboFrequencia"),
						rs.getString("codeName"),
						rs.getString("socket"),
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Processador> findByCodename(String codename) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.codename = ?");
			
			st.setString(1, codename);
			rs = st.executeQuery();

			List<Processador> lista = new ArrayList<>();

			while (rs.next()) {
				Processador dt = new Processador(rs.getInt("idProcessador"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getInt("nroCores"),
						rs.getInt("nroThreads"),
						rs.getDouble("tdp"),
						rs.getDouble("frequencia"),
						rs.getDouble("turboFrequencia"),
						rs.getString("codeName"),
						rs.getString("socket"),
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Processador> findByGraficoIntegrado(Gpus graficoIntegrado) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.graficoIntegrado = ?");
			
			st.setString(1, graficoIntegrado.getNomeModelo());
			rs = st.executeQuery();

			List<Processador> lista = new ArrayList<>();

			while (rs.next()) {
				Processador dt = new Processador(rs.getInt("idProcessador"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getInt("nroCores"),
						rs.getInt("nroThreads"),
						rs.getDouble("tdp"),
						rs.getDouble("frequencia"),
						rs.getDouble("turboFrequencia"),
						rs.getString("codeName"),
						rs.getString("socket"),
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public Processador findById(int idProcessador) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.idProcessador = ?");
			
			st.setInt(1, idProcessador);;
			rs = st.executeQuery();

			if (rs.next()) {
				Processador dt = new Processador(rs.getInt("idProcessador"),
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getInt("nroCores"),
						rs.getInt("nroThreads"),
						rs.getDouble("tdp"),
						rs.getDouble("frequencia"),
						rs.getDouble("turboFrequencia"),
						rs.getString("codeName"),
						rs.getString("socket"),
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				return dt;
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void inserir(Processadores processador) {
		PreparedStatement st = null;
		
		DadosProcessadorService dadosProcService = new DadosProcessadorService();
		PlacaDeVideoService gpuService = new PlacaDeVideoService();
		
		DadosProcessador dadosProcessador = dadosProcService.findById(processador.getDadosProcessador().getIdDadosProcessador());
		PlacaDeVideo gpu = null;
		
		if (processador.getGpu() != null) {
			gpu = gpuService.findById(processador.getGpu().getIdGpu());
		}
		
		try {
			st = conn.prepareStatement("insert into Processadores (idDadosProcessador, nomeFabricante, nomeModelo, market, released, codename, "
					+ "generation, memorySupport, frequencia, turbofrequencia, baseClock, multiplicador, multiplDesbloqueado, "
					+ "nroCores, nroThreads, smp, idGpu, tdp) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, dadosProcessador.getIdDadosProcessador());
			st.setString(2, processador.getNomeFabricante());
			st.setString(3, processador.getNomeModelo());
			st.setString(4, processador.getMarket());
			st.setDate(5, new java.sql.Date(processador.getReleased().getTime()));
			st.setString(6, processador.getCodename());
			st.setString(7, processador.getGeneration());
			st.setString(8, processador.getMemorySupport());
			st.setDouble(9, processador.getFrequencia());
			st.setDouble(10, processador.getTurbofrequencia());
			st.setDouble(11, processador.getBaseClock());
			st.setDouble(12, processador.getMultiplicador());
			st.setString(13, processador.getMultiplDesbloqueado());
			st.setInt(14, processador.getNroCores());
			st.setInt(15, processador.getNroThreads());
			st.setInt(16, processador.getSmp());
			st.setInt(17, (gpu != null) ? gpu.getIdGpu() : null);
			st.setDouble(18, processador.getTdp());
			
			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Inserido! Id: " + rs.getInt(1));
				}
				DB.closeResultSet(rs);
				conn.commit();
			}
			else {
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao inserir o processador");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void atualizar(Processadores processador) {
		PreparedStatement st = null;
		
		DadosProcessadorService dadosProcService = new DadosProcessadorService();
		PlacaDeVideoService gpuService = new PlacaDeVideoService();
		
		DadosProcessador dadosProcessador = dadosProcService.findById(processador.getDadosProcessador().getIdDadosProcessador());
		PlacaDeVideo gpu = null;
		
		if (processador.getGpu() != null) {
			gpu = gpuService.findById(processador.getGpu().getIdGpu());
		}
		
		try {
			st = conn.prepareStatement("update a set a.idDadosProcessador = ?, a.nomeFabricante = ?, a.nomeModelo = ?, a.market = ?, "
					+ "a.released = ?, a.codename = ?, a.generation = ?, a.memorySupport = ?, a.frequencia = ?, a.turbofrequencia = ?, "
					+ "a.baseClock = ?, a.multiplicador = ?, a.multiplDesbloqueado = ?, a.nroCores = ?, a.nroThreads = ?, a.smp = ?, "
					+ "a.idGpu = ?, a.tdp = ? "
					+ "from Processadores a "
					+ "where a.idProcessador = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, dadosProcessador.getIdDadosProcessador());
			st.setString(2, processador.getNomeFabricante());
			st.setString(3, processador.getNomeModelo());
			st.setString(4, processador.getMarket());
			st.setDate(5, new java.sql.Date(processador.getReleased().getTime()));
			st.setString(6, processador.getCodename());
			st.setString(7, processador.getGeneration());
			st.setString(8, processador.getMemorySupport());
			st.setDouble(9, processador.getFrequencia());
			st.setDouble(10, processador.getTurbofrequencia());
			st.setDouble(11, processador.getBaseClock());
			st.setDouble(12, processador.getMultiplicador());
			st.setString(13, processador.getMultiplDesbloqueado());
			st.setInt(14, processador.getNroCores());
			st.setInt(15, processador.getNroThreads());
			st.setInt(16, processador.getSmp());
			st.setInt(17, (gpu != null) ? gpu.getIdGpu() : null);
			st.setDouble(18, processador.getTdp());
			st.setInt(19, processador.getIdProcessador());
			
			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Alterado! Id: " + processador.getIdProcessador());
				}
				DB.closeResultSet(rs);
				conn.commit();
			}
			else {
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao atualizar o processador");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void remover(Processadores processador) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete a "
					+ "from Processadores a "
					+ "where a.idProcessador = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, processador.getIdProcessador());
			
			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Deletado! Id: " + processador.getIdProcessador());
				}
				DB.closeResultSet(rs);
				conn.commit();
			}
			else {
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao deletar o processador");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Processadores findByIdProcessadores(int idProcessador) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processadores a "
					+ "where a.idProcessador = ?");
			
			st.setInt(1, idProcessador);;
			rs = st.executeQuery();

			if (rs.next()) {
				Processador processador = findById(idProcessador);
				DadosProcessadorService dadosProcService = new DadosProcessadorService();
				PlacaDeVideoService gpu = new PlacaDeVideoService();
				DadosProcessador dadosProc = dadosProcService.findById(processador.getIdDadosProcessador());
				List<PlacaDeVideo> g = gpu.findByModeloGpu(findById(idProcessador).getGraficoIntegrado());
				
				Processadores dt = new Processadores(rs.getInt("idProcessador"),
						dadosProc,
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getString("market"),
						rs.getDate("released"),
						rs.getString("codename"),
						rs.getString("generation"),
						rs.getString("memorySupport"),
						rs.getDouble("frequencia"),
						rs.getDouble("turbofrequencia"),
						rs.getDouble("baseClock"),
						rs.getDouble("multiplicador"),
						rs.getString("multiplDesbloqueado"),
						rs.getInt("nroCores"),
						rs.getInt("nroThreads"),
						rs.getInt("smp"),
						(g.size() > 0) ? gpu.findByIdGpu(g.get(0).getIdGpu()) : null,
						rs.getDouble("tdp")); 

				return dt;
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
