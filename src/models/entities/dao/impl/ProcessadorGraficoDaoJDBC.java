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
import models.entities.dao.ProcessadorGraficoDao;
import models.entities.tables.ProcessadorGrafico;

public class ProcessadorGraficoDaoJDBC implements ProcessadorGraficoDao {

	private Connection conn;
	
	public ProcessadorGraficoDaoJDBC(Connection conn) {
	
		this.conn = conn;
	}
	
	@Override
	public List<ProcessadorGrafico> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from ProcessadorGrafico");
			rs = st.executeQuery();
			
			List<ProcessadorGrafico> lista = new ArrayList<>();

			while (rs.next()) {
				ProcessadorGrafico pg = new ProcessadorGrafico(rs.getInt("idProcGrafico"), 
						rs.getString("nomeGpu"), 
						rs.getString("variantGpu"), 
						rs.getString("arquitetura"), 
						rs.getString("fundicao"), 
						rs.getInt("nnProcessador"), 
						rs.getDouble("nroTransistors"), 
						rs.getInt("mmProcessador"));
				
				lista.add(pg);
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
	public ProcessadorGrafico findById(int idProcessadorGrafico) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from ProcessadorGrafico a "
					+ "where a.idProcessadorGrafico = ?");
			st.setInt(1, idProcessadorGrafico);
			
			rs = st.executeQuery();
			
			if (rs.next()) {
				ProcessadorGrafico pg = new ProcessadorGrafico(rs.getInt("idProcGrafico"), 
						rs.getString("nomeGpu"), 
						rs.getString("variantGpu"), 
						rs.getString("arquitetura"), 
						rs.getString("fundicao"), 
						rs.getInt("nnProcessador"), 
						rs.getDouble("nroTransistors"), 
						rs.getInt("mmProcessador"));
				
				return pg;
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
	public List<ProcessadorGrafico> findByArquitetura(String arquitetura) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from ProcessadorGrafico a "
					+ "where a.arquitetura = ?");
			st.setString(1, arquitetura);
			
			rs = st.executeQuery();
			
			List<ProcessadorGrafico> lista = new ArrayList<>();

			while (rs.next()) {
				ProcessadorGrafico pg = new ProcessadorGrafico(rs.getInt("idProcGrafico"), 
						rs.getString("nomeGpu"), 
						rs.getString("variantGpu"), 
						rs.getString("arquitetura"), 
						rs.getString("fundicao"), 
						rs.getInt("nnProcessador"), 
						rs.getDouble("nroTransistors"), 
						rs.getInt("mmProcessador"));
				
				lista.add(pg);
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
	public List<ProcessadorGrafico> findByFundicao(String fundicao) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from ProcessadorGrafico a "
					+ "where a.fundicao = ?");
			st.setString(1, fundicao);
			
			rs = st.executeQuery();
			
			List<ProcessadorGrafico> lista = new ArrayList<>();

			while (rs.next()) {
				ProcessadorGrafico pg = new ProcessadorGrafico(rs.getInt("idProcGrafico"), 
						rs.getString("nomeGpu"), 
						rs.getString("variantGpu"), 
						rs.getString("arquitetura"), 
						rs.getString("fundicao"), 
						rs.getInt("nnProcessador"), 
						rs.getDouble("nroTransistors"), 
						rs.getInt("mmProcessador"));
				
				lista.add(pg);
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
	public List<ProcessadorGrafico> findByNomeGPU(String nomeGPU) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from ProcessadorGrafico a "
					+ "where a.nomeGPU = ?");
			st.setString(1, nomeGPU);
			
			rs = st.executeQuery();
			
			List<ProcessadorGrafico> lista = new ArrayList<>();

			while (rs.next()) {
				ProcessadorGrafico pg = new ProcessadorGrafico(rs.getInt("idProcGrafico"), 
						rs.getString("nomeGpu"), 
						rs.getString("variantGpu"), 
						rs.getString("arquitetura"), 
						rs.getString("fundicao"), 
						rs.getInt("nnProcessador"), 
						rs.getDouble("nroTransistors"), 
						rs.getInt("mmProcessador"));
				
				lista.add(pg);
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
	public void inserir(ProcessadorGrafico processadorGrafico) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into ProcessadorGrafico (nomeGpu, variantGpu, arquitetura, fundicao, nnProcessador, nroTransistors, mmProcessador) "
					+ "values (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, processadorGrafico.getNomeGpu());
			st.setString(2, processadorGrafico.getVariantGpu());
			st.setString(3, processadorGrafico.getArquitetura());
			st.setString(4, processadorGrafico.getFundicao());
			st.setInt(5, processadorGrafico.getNnProcessador());
			st.setDouble(6, processadorGrafico.getNroTransistors());
			st.setInt(7, processadorGrafico.getMmProcessador());
			
			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Inserido! Id: " + rs.getInt(1));
				}
				conn.commit();
				DB.closeResultSet(rs);
			}
			else {
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao inserir o Processador Gráfico");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void atualizar(ProcessadorGrafico processadorGrafico) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update a set a.nomeGpu = ?, a.variantGpu = ?, a.arquitetura = ?, a.fundicao = ?, "
					+ "a.nnProcessador = ?, a.nroTransistors = ?, a.mmProcessador = ? "
					+ "from ProcessadorGrafico a "
					+ "where idProcessadorGrafico = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, processadorGrafico.getNomeGpu());
			st.setString(2, processadorGrafico.getVariantGpu());
			st.setString(3, processadorGrafico.getArquitetura());
			st.setString(4, processadorGrafico.getFundicao());
			st.setInt(5, processadorGrafico.getNnProcessador());
			st.setDouble(6, processadorGrafico.getNroTransistors());
			st.setInt(7, processadorGrafico.getMmProcessador());
			st.setInt(8, processadorGrafico.getIdProcGrafico());
			
			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Alterado! Id: " + processadorGrafico.getIdProcGrafico());
				}
				conn.commit();
				DB.closeResultSet(rs);
			}
			else {
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao alterar o Processador Gráfico");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void remover(ProcessadorGrafico processadorGrafico) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete a from ProcessadorGrafico a "
					+ "where a.idProcessadorGrafico = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, processadorGrafico.getIdProcGrafico());
			
			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Deletado! Id: " + processadorGrafico.getIdProcGrafico());
				}
				conn.commit();
				DB.closeResultSet(rs);
			}
			else {
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao deletar o Processador Gráfico");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

}
