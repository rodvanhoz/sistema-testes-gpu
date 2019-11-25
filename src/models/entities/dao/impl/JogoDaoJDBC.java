package models.entities.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;
import models.entities.dao.JogoDao;
import models.entities.tables.Jogos;

public class JogoDaoJDBC implements JogoDao {

	private Connection conn;

	public JogoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Jogos> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from Jogos a "
					+ "order by a.DtLancto desc");
			rs = st.executeQuery();

			List<Jogos> jogos = new ArrayList<>();

			while (rs.next()) {
				Jogos j = new Jogos(rs.getInt("idJogo"), rs.getString("nomeJogo"), rs.getDate("dtLancto"));

				jogos.add(j);
			}
			
			return jogos;

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
	public List<Jogos> findByDtLancto(Date dtLancto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jogos findById(int idJogo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Jogos jogo) {

		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into Jogos (nomeJogo, dtLancto) "
					+ "values (?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, jogo.getNomeJogo());
			st.setDate(2, new java.sql.Date(jogo.getDtLancto().getTime()));
			
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
				throw new DbException("Erro inexperado ao inserir o jogo");
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
	public void atualizar(Jogos jogo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Jogos jogo) {
		// TODO Auto-generated method stub

	}

}
