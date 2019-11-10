package models.entities.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			st = conn.prepareStatement("select *\r\n" + 
					"  from configuracoes a\r\n" + 
					" order by a.resolucaoAbrev, a.api, a.qualidadeGrafica");
			
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
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public Configuracoes findById(int idConfiguracao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Configuracoes> findByQualidadeGrafica(String qualidadeGrafica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Configuracoes> findByResolucaoAbrev(String resolucaoAbrev) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Configuracoes> findByApi(String api) {
		// TODO Auto-generated method stub
		return null;
	}

}
