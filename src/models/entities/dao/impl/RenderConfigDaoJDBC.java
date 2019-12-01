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
import models.entities.dao.RenderConfigDao;
import models.entities.tables.RenderConfig;

public class RenderConfigDaoJDBC implements RenderConfigDao {
	
	private Connection conn;
	
	public RenderConfigDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<RenderConfig> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from RenderConfig");
			rs = st.executeQuery();
			
			List<RenderConfig> lista = new ArrayList<>();
			
			while (rs.next()) {
				RenderConfig rc = new RenderConfig(rs.getInt("idRenderConfig"), 
						rs.getInt("shadingUnits"), 
						rs.getInt("tmus"), 
						rs.getInt("rops"), 
						rs.getInt("smCount"), 
						rs.getInt("l1Cache"), 
						rs.getInt("l2Cache"), 
						rs.getInt("tensorCores"), 
						rs.getInt("rtCores"));
				
				lista.add(rc);
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
	public RenderConfig findById(int idRenderConfig) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from RenderConfig a "
					+ "where a.idRenderConfig = ?");
			st.setInt(1, idRenderConfig);
			
			rs = st.executeQuery();
			
			if (rs.next()) {
				RenderConfig rc = new RenderConfig(rs.getInt("idRenderConfig"), 
						rs.getInt("shadingUnits"), 
						rs.getInt("tmus"), 
						rs.getInt("rops"), 
						rs.getInt("smCount"), 
						rs.getInt("l1Cache"), 
						rs.getInt("l2Cache"), 
						rs.getInt("tensorCores"), 
						rs.getInt("rtCores"));
				
				return rc;
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
	public void inserir(RenderConfig renderConfig) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into RenderConfig (shadingUnits, tmus, rops, smCount, L1Cache, L2Cache, tensorCores, rtCores) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, renderConfig.getShadingUnits());
			st.setInt(2, renderConfig.getTmus());
			st.setInt(3, renderConfig.getRops());
			st.setInt(4, renderConfig.getSmCount());
			st.setInt(5, renderConfig.getL1Cache());
			st.setInt(6, renderConfig.getL2Cache());
			st.setInt(7, renderConfig.getTensorCores());
			st.setInt(8, renderConfig.getRtCores());
			
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
				throw new DbException("Erro inexperado ao inserir a Característica Gráfica");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void atualizar(RenderConfig renderConfig) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update a set a.shadingUnits = ?, a.tmus = ?, a.rops = ?, a.smCount = ?, a.L1Cache = ?, "
					+ "a.L2Cache = ?, a.tensorCores = ?, a.rtCores = ? "
					+ "from RenderConfig a "
					+ "where a.idRenderConfig = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, renderConfig.getShadingUnits());
			st.setInt(2, renderConfig.getTmus());
			st.setInt(3, renderConfig.getRops());
			st.setInt(4, renderConfig.getSmCount());
			st.setInt(5, renderConfig.getL1Cache());
			st.setInt(6, renderConfig.getL2Cache());
			st.setInt(7, renderConfig.getTensorCores());
			st.setInt(8, renderConfig.getRtCores());
			st.setInt(9, renderConfig.getIdRenderConfig());
			
			if (st.executeUpdate() > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Alterado! Id: " + renderConfig.getIdRenderConfig());
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao inserir o Render Config");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void remover(RenderConfig renderConfig) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete a"
					+ "from RenderConfig a"
					+ "where a.idRenderConfig = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, renderConfig.getIdRenderConfig());
			
			if (st.executeUpdate() > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					System.out.println("Deletado! Id: " + renderConfig.getIdRenderConfig());
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao remover o Render Config");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

}
