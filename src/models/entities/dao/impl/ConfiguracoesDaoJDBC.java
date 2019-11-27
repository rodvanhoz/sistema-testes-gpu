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
import models.entities.dao.ConfiguracoesDao;
import models.entities.tables.Configuracoes;

public class ConfiguracoesDaoJDBC implements ConfiguracoesDao {

	private Connection conn;

	public ConfiguracoesDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Configuracoes> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select *\r\n" + "  from configuracoes a\r\n"
					+ " order by a.resolucaoAbrev, a.api, a.qualidadeGrafica");

			rs = st.executeQuery();

			List<Configuracoes> lista = new ArrayList<>();

			while (rs.next()) {
				Configuracoes c = new Configuracoes(rs.getInt("idConfiguracao"), 
												    rs.getInt("resolucaoAbrev"),
												    rs.getString("resolucaoDetalhe"), 
												    rs.getString("api"), 
												    rs.getString("qualidadeGrafica"),
												    rs.getString("ssao"), 
												    rs.getString("fxaa"), 
												    rs.getString("taa"), 
												    rs.getString("rt"),
												    rs.getString("aa"), 
												    rs.getString("nVidiaTec"));

				lista.add(c);
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
	public Configuracoes findById(int idConfiguracao) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select *\r\n" + 
					"  from configuracoes a\r\n" + 
					" where a.idConfiguracao = ?");

			st.setInt(1, idConfiguracao);
			rs = st.executeQuery();

			Configuracoes c = new Configuracoes(rs.getInt("idConfiguracao"), 
												rs.getInt("resolucaoAbrev"),
												rs.getString("resolucaoDetalhe"), 
												rs.getString("api"), 
												rs.getString("qualidadeGrafica"),
												rs.getString("ssao"), 
												rs.getString("fxaa"), 
												rs.getString("taa"), 
												rs.getString("rt"),
												rs.getString("aa"), 
												rs.getString("nVidiaTec"));
			
			return c;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Configuracoes> findByQualidadeGrafica(String qualidadeGrafica) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select *\r\n" + 
									   "  from configuracoes a\r\n" +
									   " where a.qualidadeGrafica = ?\r\n" +
									   " order by a.resolucaoAbrev, a.api, a.qualidadeGrafica");
			
			st.setString(1, qualidadeGrafica);
			rs = st.executeQuery();

			List<Configuracoes> lista = new ArrayList<>();

			while (rs.next()) {
				Configuracoes c = new Configuracoes(rs.getInt("idConfiguracao"), 
												    rs.getInt("resolucaoAbrev"),
												    rs.getString("resolucaoDetalhe"), 
												    rs.getString("api"), 
												    rs.getString("qualidadeGrafica"),
												    rs.getString("ssao"), 
												    rs.getString("fxaa"), 
												    rs.getString("taa"), 
												    rs.getString("rt"),
												    rs.getString("aa"), 
												    rs.getString("nVidiaTec"));

				lista.add(c);
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
	public List<Configuracoes> findByResolucaoAbrev(int resolucaoAbrev) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select *\r\n" + 
									   "  from configuracoes a\r\n" +
									   " where a.resolucaoAbrev = ?\r\n" +
									   " order by a.resolucaoAbrev, a.api, a.qualidadeGrafica");
			
			st.setInt(1, resolucaoAbrev);
			rs = st.executeQuery();

			List<Configuracoes> lista = new ArrayList<>();

			while (rs.next()) {
				Configuracoes c = new Configuracoes(rs.getInt("idConfiguracao"), 
												    rs.getInt("resolucaoAbrev"),
												    rs.getString("resolucaoDetalhe"), 
												    rs.getString("api"), 
												    rs.getString("qualidadeGrafica"),
												    rs.getString("ssao"), 
												    rs.getString("fxaa"), 
												    rs.getString("taa"), 
												    rs.getString("rt"),
												    rs.getString("aa"), 
												    rs.getString("nVidiaTec"));

				lista.add(c);
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
	public List<Configuracoes> findByApi(String api) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select *\r\n" + 
									   "  from configuracoes a\r\n" +
									   " where a.resolucaoAbrev = ?\r\n" +
									   " order by a.api, a.api, a.qualidadeGrafica");
			
			st.setString(1, api);
			rs = st.executeQuery();

			List<Configuracoes> lista = new ArrayList<>();

			while (rs.next()) {
				Configuracoes c = new Configuracoes(rs.getInt("idConfiguracao"), 
												    rs.getInt("resolucaoAbrev"),
												    rs.getString("resolucaoDetalhe"), 
												    rs.getString("api"), 
												    rs.getString("qualidadeGrafica"),
												    rs.getString("ssao"), 
												    rs.getString("fxaa"), 
												    rs.getString("taa"), 
												    rs.getString("rt"),
												    rs.getString("aa"), 
												    rs.getString("nVidiaTec"));

				lista.add(c);
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
	public void inserir(Configuracoes configuracao) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into Configuracoes (resolucaoAbrev, resolucaoDetalhe, api, qualidadeGrafica, ssao, fxaa, taa, rt, aa, nVidiaTec) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, configuracao.getResolucaoAbrev());
			st.setString(2, configuracao.getResolucaoDetalhe());
			st.setString(3, configuracao.getApi());
			st.setString(4, configuracao.getQualidadeGrafica());
			st.setString(5, configuracao.getSsao());
			st.setString(6, configuracao.getFxaa());
			st.setString(7, configuracao.getTaa());
			st.setString(8, configuracao.getRt());
			st.setString(9, configuracao.getAa());
			st.setString(10, configuracao.getNVidiaTec());
			
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
				throw new DbException("Erro inexperado ao inserir a configuracao");
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
	public void atualizar(Configuracoes configuracao) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update a set a.resolucaoAbrev = ?, a.resolucaoDetalhe = ?, a.api = ?, a.qualidadeGrafica = ?, "
					+ "a.ssao = ?, a.fxaa = ?, a.taa = ?, a.rt = ?, a.aa = ?, a.nvidiaTec = ? "
					+ "from Configuracoes a "
					+ "where a.idConfiguracao = ?", 
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, configuracao.getResolucaoAbrev());
			st.setString(2, configuracao.getResolucaoDetalhe());
			st.setString(3, configuracao.getApi());
			st.setString(4, configuracao.getQualidadeGrafica());
			st.setString(5, configuracao.getSsao());
			st.setString(6, configuracao.getFxaa());
			st.setString(7, configuracao.getTaa());
			st.setString(8, configuracao.getRt());
			st.setString(9, configuracao.getAa());
			st.setString(10, configuracao.getNVidiaTec());
			st.setInt(11,  configuracao.getIdConfiguracao());
			
			if (st.executeUpdate() == 1) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Alterado! Id: " + configuracao.getIdConfiguracao());
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
				throw new DbException("Erro inexperado ao alterar a configuracao");
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
	public void remover(Configuracoes configuracao) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete a "
					+ "from Configuracoes a "
					+ "where a.idConfiguracao = ?", 
					Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1,  configuracao.getIdConfiguracao());
			
			if (st.executeUpdate() == 1) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Alterado! Id: " + configuracao.getIdConfiguracao());
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
				throw new DbException("Erro inexperado ao deletar a configuracao");
			}
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}

	}

}
