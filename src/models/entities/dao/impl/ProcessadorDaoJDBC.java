package models.entities.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import models.entities.dao.ProcessadorDao;
import models.entities.views.DadosTeste;
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
						rs.getString("graficoIntegrado")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Processador> findByModelo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Processador> findByFabricante() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Processador> findByCodename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Processador> findByGraficoIntegrado() {
		// TODO Auto-generated method stub
		return null;
	}

}
