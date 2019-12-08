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
import models.entities.dao.DadosProcessadorDao;
import models.entities.tables.DadosProcessador;

public class DadosProcessadorDaoJDBC implements DadosProcessadorDao {

	private Connection conn;
	
	public DadosProcessadorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<DadosProcessador> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  DadosProcessador a ");
			rs = st.executeQuery();

			List<DadosProcessador> lista = new ArrayList<>();

			while (rs.next()) {
				DadosProcessador dt = new DadosProcessador(rs.getInt("idDadosProcessador"), 
						rs.getString("socket"), 
						rs.getString("foundry"), 
						rs.getInt("processSize"), 
						rs.getDouble("transistors"), 
						rs.getString("package"), 
						rs.getDouble("tCaseMax"));

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public DadosProcessador findById(int idDadosProcessador) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  DadosProcessador a "
					+ "where a.idDadosProcessador = ?");
			
			st.setInt(1, idDadosProcessador);
			rs = st.executeQuery();

			if (rs.next()) {
				DadosProcessador dt = new DadosProcessador(rs.getInt("idDadosProcessador"), 
						rs.getString("socket"), 
						rs.getString("foundry"), 
						rs.getInt("processSize"), 
						rs.getDouble("transistors"), 
						rs.getString("package"), 
						rs.getDouble("tCaseMax"));

				return dt;
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void inserir(DadosProcessador dadosProcessador) {

		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into DadosProcessador (socket, foundry, processSize, transistors, package, tCaseMax) "
					+ "values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, dadosProcessador.getSocket());
			st.setString(2, dadosProcessador.getFoundry());
			st.setInt(3, dadosProcessador.getProcessSize());
			st.setDouble(4, dadosProcessador.getTransistors());
			st.setString(5, dadosProcessador.getPackag());
			st.setDouble(6, dadosProcessador.gettCaseMax());
			
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
				throw new DbException("Erro inexperado ao inserir os DadosProcessador");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void atualizar(DadosProcessador dadosProcessador) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update a set a.socket = ?, a.foundry = ?, a.processSize = ?, a.transistors = ?, a.package = ?, a.tCaseMax = ? "
					+ "from DadosProcessador a "
					+ "where a.idDadosProcessador = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, dadosProcessador.getSocket());
			st.setString(2, dadosProcessador.getFoundry());
			st.setInt(3, dadosProcessador.getProcessSize());
			st.setDouble(4, dadosProcessador.getTransistors());
			st.setString(5, dadosProcessador.getPackag());
			st.setDouble(6, dadosProcessador.gettCaseMax());
			st.setInt(7, dadosProcessador.getIdDadosProcessador());
			
			if (st.executeUpdate() > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Alterado! Id: " + dadosProcessador.getIdDadosProcessador());
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao alterar os DadosProcessador");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void remover(DadosProcessador dadosProcessador) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete a "
					+ "from DadosProcessador a "
					+ "where a.idDadosProcessador = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, dadosProcessador.getIdDadosProcessador());
			
			if (st.executeUpdate() > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Deletado! Id: " + dadosProcessador.getIdDadosProcessador());
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao deletar os DadosProcessador");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

}
