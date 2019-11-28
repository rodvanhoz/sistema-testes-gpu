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
import models.entities.dao.ConfiguracoesJogosDao;
import models.entities.tables.Configuracoes;
import models.entities.tables.ConfiguracoesJogos;
import models.entities.tables.Jogos;
import models.entities.views.ConfiguracoesJogosW;

public class ConfiguracoesJogosDaoJDBC implements ConfiguracoesJogosDao {
	
	private Connection conn;

	public ConfiguracoesJogosDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<ConfiguracoesJogosW> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from ConfiguracoesJogosW a "
					+ " order by a.idJogo, a.idConfiguracao");

			rs = st.executeQuery();

			List<ConfiguracoesJogosW> lista = new ArrayList<>();

			while (rs.next()) {
				ConfiguracoesJogosW c = new ConfiguracoesJogosW(rs.getString("nomeJogo"),
													rs.getDate("dtLancto"),
												    rs.getInt("resolucaoAbrev"),
												    rs.getString("resolucaoDetalhe"), 
												    rs.getString("api"), 
												    rs.getString("qualidadeGrafica"),
												    rs.getString("ssao"), 
												    rs.getString("fxaa"), 
												    rs.getString("taa"), 
												    rs.getString("rt"),
												    rs.getString("aa"), 
												    rs.getString("nVidiaTec"),
												    rs.getInt("idJogo"),
												    rs.getInt("idConfiguracao"),
												    rs.getInt("idConfiguracaoJogo"));

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
	public ConfiguracoesJogosW findById(int idConfiguracaoJogos) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from ConfiguracoesJogosW a "
					+ "where a.idConfiguracaoJogo = ?");
			
			st.setInt(1, idConfiguracaoJogos);
			rs = st.executeQuery();

			while (rs.next()) {
				ConfiguracoesJogosW c = new ConfiguracoesJogosW(rs.getString("nomeJogo"),
													rs.getDate("dtLancto"),
												    rs.getInt("resolucaoAbrev"),
												    rs.getString("resolucaoDetalhe"), 
												    rs.getString("api"), 
												    rs.getString("qualidadeGrafica"),
												    rs.getString("ssao"), 
												    rs.getString("fxaa"), 
												    rs.getString("taa"), 
												    rs.getString("rt"),
												    rs.getString("aa"), 
												    rs.getString("nVidiaTec"),
												    rs.getInt("idJogo"),
												    rs.getInt("idConfiguracao"),
												    rs.getInt("idConfiguracaoJogo"));

				return c;
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
	public ConfiguracoesJogosW findByJogo(Jogos jogo) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from ConfiguracoesJogosW a "
					+ "where a.idJogo = ?");
			
			st.setInt(1, jogo.getIdJogo());
			rs = st.executeQuery();

			while (rs.next()) {
				ConfiguracoesJogosW c = new ConfiguracoesJogosW(rs.getString("nomeJogo"),
													rs.getDate("dtLancto"),
												    rs.getInt("resolucaoAbrev"),
												    rs.getString("resolucaoDetalhe"), 
												    rs.getString("api"), 
												    rs.getString("qualidadeGrafica"),
												    rs.getString("ssao"), 
												    rs.getString("fxaa"), 
												    rs.getString("taa"), 
												    rs.getString("rt"),
												    rs.getString("aa"), 
												    rs.getString("nVidiaTec"),
												    rs.getInt("idJogo"),
												    rs.getInt("idConfiguracao"),
												    rs.getInt("idConfiguracaoJogo"));

				return c;
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
	public ConfiguracoesJogosW findByConfiguracao(Configuracoes configuracao) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from ConfiguracoesJogosW a "
					+ "where a.idJogo = ?");
			
			st.setInt(1, configuracao.getIdConfiguracao());
			rs = st.executeQuery();

			while (rs.next()) {
				ConfiguracoesJogosW c = new ConfiguracoesJogosW(rs.getString("nomeJogo"),
													rs.getDate("dtLancto"),
												    rs.getInt("resolucaoAbrev"),
												    rs.getString("resolucaoDetalhe"), 
												    rs.getString("api"), 
												    rs.getString("qualidadeGrafica"),
												    rs.getString("ssao"), 
												    rs.getString("fxaa"), 
												    rs.getString("taa"), 
												    rs.getString("rt"),
												    rs.getString("aa"), 
												    rs.getString("nVidiaTec"),
												    rs.getInt("idJogo"),
												    rs.getInt("idConfiguracao"),
												    rs.getInt("idConfiguracaoJogo"));

				return c;
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
	public void inserir(ConfiguracoesJogos configuracaoJogo) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into ConfiguracoesJogos (idJogo, idConfiguracao) "
					+ "values (?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, configuracaoJogo.getJogo().getIdJogo());
			st.setInt(2, configuracaoJogo.getConfiguracao().getIdConfiguracao());
			
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
				throw new DbException("Erro inexperado ao inserir a relação Configuração / Jogo");
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
	public void atualizar(ConfiguracoesJogos configuracaoJogo) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update a set a.idJogo = ?, a.idConfiguracao = ? "
					+ "from ConfiguracoesJogos a "
					+ "where a.idConfiguracaoJogo = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, configuracaoJogo.getJogo().getIdJogo());
			st.setInt(2, configuracaoJogo.getConfiguracao().getIdConfiguracao());
			st.setInt(3, configuracaoJogo.getIdConfiguracaoJogo());
			
			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Alterado! Id: " + configuracaoJogo.getIdConfiguracaoJogo());
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
				throw new DbException("Erro inexperado ao atualizar a relação Configuração / Jogo");
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
	public void remover(ConfiguracoesJogos configuracaoJogo) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete a "
					+ "from ConfiguracoesJogos a "
					+ "where a.idConfiguracaoJogo = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, configuracaoJogo.getIdConfiguracaoJogo());
			
			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Deletado! Id: " + configuracaoJogo.getIdConfiguracaoJogo());
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
				throw new DbException("Erro inexperado ao deletar a relação Configuração / Jogo");
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
