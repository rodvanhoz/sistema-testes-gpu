package models.entities.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DbException;
import models.entities.dao.DadosTesteDao;
import models.entities.views.DadosTeste;
import models.entities.views.PlacaDeVideo;

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
			st = conn.prepareStatement("SELECT * FROM DadosTestes");
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
						rs.getString("nomeDriverGpu"));
				
				lista.add(dt);
			}
			
			return lista;
					
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<DadosTeste> findByGpu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DadosTeste> findByJogo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DadosTeste> findByProcessador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DadosTeste> findByTester() {
		// TODO Auto-generated method stub
		return null;
	}

}
