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
import models.entities.dao.DadosTesteDao;
import models.entities.services.ConfiguracoesJogosService;
import models.entities.services.DadosTesteService;
import models.entities.services.PlacaDeVideoService;
import models.entities.services.ProcessadorService;
import models.entities.tables.Gpus;
import models.entities.tables.Jogos;
import models.entities.tables.TestesGpu;
import models.entities.views.DadosTeste;
import models.entities.views.Processador;

public class DadosTesteDaoJDBC implements DadosTesteDao {
	
	private Connection conn;
	
	public DadosTesteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<DadosTeste> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * "
					+ "FROM  DadosTestes a "
					+ "order by a.nomeJogo, a.qualidadeGrafica, a.resolucaoAbrev, a.avgfps desc");
			rs = st.executeQuery();
			
			List<DadosTeste> lista = new ArrayList<>();
			
			while (rs.next()) {
				DadosTeste dt = new DadosTeste(
						rs.getString("nomeModeloGpu"), 
						rs.getString("nomeModeloProcessador"),
						rs.getString("nomeJogo"),
						rs.getInt("resolucaoAbrev"), 
						rs.getString("qualidadeGrafica"),
						rs.getString("api"),
						rs.getString("fxaa"),
						rs.getString("ssao"),
						rs.getString("aa"),
						rs.getString("rt"),
						rs.getString("taa"),
						rs.getString("nVidiaTec"),
						rs.getDouble("avgFps"),
						rs.getDouble("minFps"),
						rs.getString("nomeTester"),
						rs.getDate("dtTeste"),
						rs.getString("nomeDriverGpu"),
						rs.getInt("idTesteGpu"),
						rs.getInt("idJogo"),
						rs.getInt("idConfiguracao"),
						rs.getInt("idConfiguracaoJogo"),
						rs.getInt("idGpu"),
						rs.getInt("idProcessador"));
				
				lista.add(dt);
			}
			
			return lista;
					
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<DadosTeste> findByGpu(Gpus gpu) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * "
					+ "FROM  DadosTestes a "
					+ "WHERE a.idGpu = ?"
					+ "order by a.nomeJogo, a.qualidadeGrafica, a.resolucaoAbrev, a.avgfps desc");
			
			st.setInt(1, gpu.getIdGpu());
			rs = st.executeQuery();
			
			List<DadosTeste> lista = new ArrayList<>();
			
			while (rs.next()) {
				DadosTeste dt = new DadosTeste(
						rs.getString("nomeModeloGpu"), 
						rs.getString("nomeModeloProcessador"),
						rs.getString("nomeJogo"),
						rs.getInt("resolucaoAbrev"), 
						rs.getString("qualidadeGrafica"),
						rs.getString("api"),
						rs.getString("fxaa"),
						rs.getString("ssao"),
						rs.getString("aa"),
						rs.getString("rt"),
						rs.getString("taa"),
						rs.getString("nVidiaTec"),
						rs.getDouble("avgFps"),
						rs.getDouble("minFps"),
						rs.getString("nomeTester"),
						rs.getDate("dtTeste"),
						rs.getString("nomeDriverGpu"),
						rs.getInt("idTesteGpu"),
						rs.getInt("idJogo"),
						rs.getInt("idConfiguracao"),
						rs.getInt("idConfiguracaoJogo"),
						rs.getInt("idGpu"),
						rs.getInt("idProcessador"));
				
				lista.add(dt);
			}
			
			return lista;
					
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<DadosTeste> findByJogo(Jogos jogo) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * "
					+ "FROM  DadosTestes a "
					+ "WHERE a.idJogo = ?"
					+ "order by a.nomeJogo, a.qualidadeGrafica, a.resolucaoAbrev, a.avgfps desc");
			
			st.setInt(1, jogo.getIdJogo());
			rs = st.executeQuery();
			
			List<DadosTeste> lista = new ArrayList<>();
			
			while (rs.next()) {
				DadosTeste dt = new DadosTeste(
						rs.getString("nomeModeloGpu"), 
						rs.getString("nomeModeloProcessador"),
						rs.getString("nomeJogo"),
						rs.getInt("resolucaoAbrev"), 
						rs.getString("qualidadeGrafica"),
						rs.getString("api"),
						rs.getString("fxaa"),
						rs.getString("ssao"),
						rs.getString("aa"),
						rs.getString("rt"),
						rs.getString("taa"),
						rs.getString("nVidiaTec"),
						rs.getDouble("avgFps"),
						rs.getDouble("minFps"),
						rs.getString("nomeTester"),
						rs.getDate("dtTeste"),
						rs.getString("nomeDriverGpu"),
						rs.getInt("idTesteGpu"),
						rs.getInt("idJogo"),
						rs.getInt("idConfiguracao"),
						rs.getInt("idConfiguracaoJogo"),
						rs.getInt("idGpu"),
						rs.getInt("idProcessador"));
				
				lista.add(dt);
			}
			
			return lista;
					
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<DadosTeste> findByProcessador(Processador processador) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * "
					+ "FROM  DadosTestes a "
					+ "WHERE a.idProcessador = ?"
					+ "order by a.nomeJogo, a.qualidadeGrafica, a.resolucaoAbrev, a.avgfps desc");
			
			st.setInt(1, processador.getIdProcessador());
			rs = st.executeQuery();
			
			List<DadosTeste> lista = new ArrayList<>();
			
			while (rs.next()) {
				DadosTeste dt = new DadosTeste(
						rs.getString("nomeModeloGpu"), 
						rs.getString("nomeModeloProcessador"),
						rs.getString("nomeJogo"),
						rs.getInt("resolucaoAbrev"), 
						rs.getString("qualidadeGrafica"),
						rs.getString("api"),
						rs.getString("fxaa"),
						rs.getString("ssao"),
						rs.getString("aa"),
						rs.getString("rt"),
						rs.getString("taa"),
						rs.getString("nVidiaTec"),
						rs.getDouble("avgFps"),
						rs.getDouble("minFps"),
						rs.getString("nomeTester"),
						rs.getDate("dtTeste"),
						rs.getString("nomeDriverGpu"),
						rs.getInt("idTesteGpu"),
						rs.getInt("idJogo"),
						rs.getInt("idConfiguracao"),
						rs.getInt("idConfiguracaoJogo"),
						rs.getInt("idGpu"),
						rs.getInt("idProcessador"));
				
				lista.add(dt);
			}
			
			return lista;
					
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<DadosTeste> findByTester(String tester) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * "
					+ "FROM  DadosTestes a "
					+ "WHERE a.nomeTester = ?"
					+ "order by a.nomeJogo, a.qualidadeGrafica, a.resolucaoAbrev, a.avgfps desc");
			
			st.setString(1, tester);
			rs = st.executeQuery();
			
			List<DadosTeste> lista = new ArrayList<>();
			
			while (rs.next()) {
				DadosTeste dt = new DadosTeste(
						rs.getString("nomeModeloGpu"), 
						rs.getString("nomeModeloProcessador"),
						rs.getString("nomeJogo"),
						rs.getInt("resolucaoAbrev"), 
						rs.getString("qualidadeGrafica"),
						rs.getString("api"),
						rs.getString("fxaa"),
						rs.getString("ssao"),
						rs.getString("aa"),
						rs.getString("rt"),
						rs.getString("taa"),
						rs.getString("nVidiaTec"),
						rs.getDouble("avgFps"),
						rs.getDouble("minFps"),
						rs.getString("nomeTester"),
						rs.getDate("dtTeste"),
						rs.getString("nomeDriverGpu"),
						rs.getInt("idTesteGpu"),
						rs.getInt("idJogo"),
						rs.getInt("idConfiguracao"),
						rs.getInt("idConfiguracaoJogo"),
						rs.getInt("idGpu"),
						rs.getInt("idProcessador"));
				
				lista.add(dt);
			}
			
			return lista;
					
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public DadosTeste findById(int idTesteGpu) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * "
					+ "FROM  DadosTestes a "
					+ "WHERE a.idTesteGpu = ?");
			
			st.setInt(1, idTesteGpu);
			rs = st.executeQuery();
			
			if (rs.next()) {
				DadosTeste dt = new DadosTeste(
						rs.getString("nomeModeloGpu"), 
						rs.getString("nomeModeloProcessador"),
						rs.getString("nomeJogo"),
						rs.getInt("resolucaoAbrev"), 
						rs.getString("qualidadeGrafica"),
						rs.getString("api"),
						rs.getString("fxaa"),
						rs.getString("ssao"),
						rs.getString("aa"),
						rs.getString("rt"),
						rs.getString("taa"),
						rs.getString("nVidiaTec"),
						rs.getDouble("avgFps"),
						rs.getDouble("minFps"),
						rs.getString("nomeTester"),
						rs.getDate("dtTeste"),
						rs.getString("nomeDriverGpu"),
						rs.getInt("idTesteGpu"),
						rs.getInt("idJogo"),
						rs.getInt("idConfiguracao"),
						rs.getInt("idConfiguracaoJogo"),
						rs.getInt("idGpu"),
						rs.getInt("idProcessador"));
				
				return dt;
			}
			
			return null;
					
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public TestesGpu findByIdTesteGpu(int idTesteGpu) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * "
					+ "FROM  TestesGpu a "
					+ "WHERE a.idTesteGpu = ?");
			
			st.setInt(1, idTesteGpu);
			rs = st.executeQuery();
			
			if (rs.next()) {
				ConfiguracoesJogosService configuracaoJogo = new ConfiguracoesJogosService();
				PlacaDeVideoService gpu = new PlacaDeVideoService();
				ProcessadorService cpu = new ProcessadorService();
				
				DadosTeste dadosTeste = findById(idTesteGpu);
				
				TestesGpu dt = new TestesGpu(rs.getInt("idTesteGpu"), 
						configuracaoJogo.findByConfiguracaoJogos(dadosTeste.getIdConfiguracaoJogo()), 
						gpu.findByIdGpu(dadosTeste.getIdGpu()), 
						cpu.findByIdProcessadores(dadosTeste.getIdProcessador()), 
						rs.getString("nomeDriverGpu"), 
						rs.getDouble("avgFps"), 
						rs.getDouble("minFps"), 
						rs.getDate("dtTeste"), 
						rs.getString("nomeTester"));
				
				return dt;
			}
			
			return null;
					
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void inserir(TestesGpu testeGpu) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into TestesGpu (idConfiguracaoJogo, idGpu, idProcessador, nomeDriverGpu, avgFps, minFps, dtTeste, nomeTester) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, testeGpu.getConfiguracaoJogo().getIdConfiguracaoJogo());
			st.setInt(2, testeGpu.getGpu().getIdGpu());
			st.setInt(3, testeGpu.getProcessador().getIdProcessador());
			st.setString(4, testeGpu.getNomeDriverGpu());
			st.setDouble(5, testeGpu.getAvgFps());
			st.setDouble(6, testeGpu.getMinFps());
			st.setDate(7, new java.sql.Date(testeGpu.getDtTeste().getTime()));
			st.setString(8, testeGpu.getNomeTester());
			
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
				throw new DbException("Erro inexperado ao inserir o Teste GPU");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void atualizar(TestesGpu testeGpu) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update a set a.idConfiguracaoJogo = ?, a.idGpu = ?, a.idProcessador = ?, a.nomeDriverGpu = ?, "
					+ "a.avgFps = ?, a.minFps = ?, a.dtTeste = ?, a.nomeTester = ? "
					+ "from TestesGpu a "
					+ "where a.idTesteGpu = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, testeGpu.getConfiguracaoJogo().getIdConfiguracaoJogo());
			st.setInt(2, testeGpu.getGpu().getIdGpu());
			st.setInt(3, testeGpu.getProcessador().getIdProcessador());
			st.setString(4, testeGpu.getNomeDriverGpu());
			st.setDouble(5, testeGpu.getAvgFps());
			st.setDouble(6, testeGpu.getMinFps());
			st.setDate(7, new java.sql.Date(testeGpu.getDtTeste().getTime()));
			st.setString(8, testeGpu.getNomeTester());
			st.setInt(9, testeGpu.getIdTesteGpu());
			
			if (st.executeUpdate() > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Alterado! Id: " + testeGpu.getIdTesteGpu());
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao alterar o Teste GPU");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void remover(TestesGpu testeGpu) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete a "
					+ "from TestesGpu a "
					+ "where a.idTesteGpu = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, testeGpu.getIdTesteGpu());
			
			if (st.executeUpdate() > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Deletado! Id: " + testeGpu.getIdTesteGpu());
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao deletar o Teste GPU");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

}
