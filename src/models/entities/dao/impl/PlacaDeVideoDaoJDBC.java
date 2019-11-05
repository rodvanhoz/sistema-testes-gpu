package models.entities.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import models.entities.dao.PlacaDeVideoDao;
import models.entities.views.PlacaDeVideo;
import models.entities.views.Processador;

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
		}
	}

	@Override
	public List<PlacaDeVideo> findByModeloGpu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlacaDeVideo> findByArquitetura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlacaDeVideo> findByTpMemoria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlacaDeVideo> findByFabricante() {
		// TODO Auto-generated method stub
		return null;
	}

}
