package models.entities.dao.impl;

import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import models.entities.dao.ProcessadorDao;
import models.entities.services.DadosProcessadorService;
import models.entities.services.PlacaDeVideoService;
import models.entities.services.ProcessadorService;
import models.entities.tables.DadosProcessador;
import models.entities.tables.Gpus;
import models.entities.tables.Processadores;
import models.entities.views.PlacaDeVideo;
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
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Processador> findByModelo(String modelo) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.nomeModelo = ?");
			
			st.setString(1, modelo);
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
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Processador> findByFabricante(String fabricante) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.nomeFabricante = ?");
			
			st.setString(1, fabricante);
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
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Processador> findByCodename(String codename) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.codename = ?");
			
			st.setString(1, codename);
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
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Processador> findByGraficoIntegrado(Gpus graficoIntegrado) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.graficoIntegrado = ?");
			
			st.setString(1, graficoIntegrado.getNomeModelo());
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
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				lista.add(dt);
			}

			return lista;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public Processador findById(int idProcessador) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processador a "
					+ "where a.idProcessador = ?");
			
			st.setInt(1, idProcessador);;
			rs = st.executeQuery();

			if (rs.next()) {
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
						rs.getString("graficoIntegrado"),
						rs.getInt("idDadosProcessador")); 

				return dt;
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void inserir(Processador processador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Processador processador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Processador processador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Processadores findByIdProcessadores(int idProcessador) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM  Processadores a "
					+ "where a.idProcessador = ?");
			
			st.setInt(1, idProcessador);;
			rs = st.executeQuery();

			if (rs.next()) {
				Processador processador = findById(idProcessador);
				DadosProcessadorService dadosProcService = new DadosProcessadorService();
				PlacaDeVideoService gpu = new PlacaDeVideoService();
				DadosProcessador dadosProc = dadosProcService.findById(processador.getIdDadosProcessador());
				List<PlacaDeVideo> g = gpu.findByModeloGpu(findById(idProcessador).getGraficoIntegrado());
				
				Processadores dt = new Processadores(rs.getInt("idProcessador"),
						dadosProc,
						rs.getString("nomeFabricante"),
						rs.getString("nomeModelo"),
						rs.getString("market"),
						rs.getDate("released"),
						rs.getString("codename"),
						rs.getString("generation"),
						rs.getString("memorySupport"),
						rs.getDouble("frequencia"),
						rs.getDouble("turbofrequencia"),
						rs.getDouble("baseClock"),
						rs.getDouble("multiplicador"),
						rs.getString("multiplDesbloqueado"),
						rs.getInt("nroCores"),
						rs.getInt("nroThreads"),
						rs.getInt("smp"),
						(g.size() > 0) ? gpu.findByIdGpu(g.get(0).getIdGpu()) : null,
						rs.getDouble("tdp")); 

				return dt;
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
