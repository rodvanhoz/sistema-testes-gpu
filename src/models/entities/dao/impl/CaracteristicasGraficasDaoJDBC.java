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
import models.entities.dao.CaracteristicasGraficasDao;
import models.entities.tables.CaracteristicasGraficas;

public class CaracteristicasGraficasDaoJDBC implements CaracteristicasGraficasDao {

	private Connection conn;

	public CaracteristicasGraficasDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<CaracteristicasGraficas> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from CaracteristicasGraficas");
			rs = st.executeQuery();

			List<CaracteristicasGraficas> lista = new ArrayList<>();

			while (rs.next()) {
				CaracteristicasGraficas carac = new CaracteristicasGraficas(rs.getInt("idCaracGrafica"),
						rs.getString("directX"), rs.getString("openGL"), rs.getString("openCL"), rs.getString("vulkan"),
						rs.getString("cuda"), rs.getString("shaderModel"));

				lista.add(carac);
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
	public CaracteristicasGraficas findById(int idCaracGrafica) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from CaracteristicasGraficas a " + "where a.idCaracGrafica = ?");
			st.setInt(1, idCaracGrafica);

			rs = st.executeQuery();

			if (rs.next()) {
				CaracteristicasGraficas carac = new CaracteristicasGraficas(rs.getInt("idCaracGrafica"),
						rs.getString("directX"), rs.getString("openGL"), rs.getString("openCL"), rs.getString("vulkan"),
						rs.getString("cuda"), rs.getString("shaderModel"));

				return carac;
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
	public List<CaracteristicasGraficas> findByDirectX(String directX) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from CaracteristicasGraficas a " + "where a.directX = ?");
			st.setString(1, directX);

			rs = st.executeQuery();

			List<CaracteristicasGraficas> lista = new ArrayList<>();

			while (rs.next()) {
				CaracteristicasGraficas carac = new CaracteristicasGraficas(rs.getInt("idCaracGrafica"),
						rs.getString("directX"), rs.getString("openGL"), rs.getString("openCL"), rs.getString("vulkan"),
						rs.getString("cuda"), rs.getString("shaderModel"));

				lista.add(carac);
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
	public List<CaracteristicasGraficas> findByOpenGL(String openGL) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from CaracteristicasGraficas a " + "where a.openGL = ?");
			st.setString(1, openGL);

			rs = st.executeQuery();

			List<CaracteristicasGraficas> lista = new ArrayList<>();

			while (rs.next()) {
				CaracteristicasGraficas carac = new CaracteristicasGraficas(rs.getInt("idCaracGrafica"),
						rs.getString("directX"), rs.getString("openGL"), rs.getString("openCL"), rs.getString("vulkan"),
						rs.getString("cuda"), rs.getString("shaderModel"));

				lista.add(carac);
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
	public List<CaracteristicasGraficas> findByOpenCL(String openCL) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from CaracteristicasGraficas a " + "where a.openCL = ?");
			st.setString(1, openCL);

			rs = st.executeQuery();

			List<CaracteristicasGraficas> lista = new ArrayList<>();

			while (rs.next()) {
				CaracteristicasGraficas carac = new CaracteristicasGraficas(rs.getInt("idCaracGrafica"),
						rs.getString("directX"), rs.getString("openGL"), rs.getString("openCL"), rs.getString("vulkan"),
						rs.getString("cuda"), rs.getString("shaderModel"));

				lista.add(carac);
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
	public List<CaracteristicasGraficas> findByVulkan(String vulkan) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from CaracteristicasGraficas a " + "where a.vulkan = ?");
			st.setString(1, vulkan);

			rs = st.executeQuery();

			List<CaracteristicasGraficas> lista = new ArrayList<>();

			while (rs.next()) {
				CaracteristicasGraficas carac = new CaracteristicasGraficas(rs.getInt("idCaracGrafica"),
						rs.getString("directX"), rs.getString("openGL"), rs.getString("openCL"), rs.getString("vulkan"),
						rs.getString("cuda"), rs.getString("shaderModel"));

				lista.add(carac);
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
	public List<CaracteristicasGraficas> findByCuda(String cuda) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from CaracteristicasGraficas a " + "where a.cuda = ?");
			st.setString(1, cuda);

			rs = st.executeQuery();

			List<CaracteristicasGraficas> lista = new ArrayList<>();

			while (rs.next()) {
				CaracteristicasGraficas carac = new CaracteristicasGraficas(rs.getInt("idCaracGrafica"),
						rs.getString("directX"), rs.getString("openGL"), rs.getString("openCL"), rs.getString("vulkan"),
						rs.getString("cuda"), rs.getString("shaderModel"));

				lista.add(carac);
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
	public List<CaracteristicasGraficas> findByShaderModel(String shaderModel) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from CaracteristicasGraficas a " + "where a.shaderModel = ?");
			st.setString(1, shaderModel);

			rs = st.executeQuery();

			List<CaracteristicasGraficas> lista = new ArrayList<>();

			while (rs.next()) {
				CaracteristicasGraficas carac = new CaracteristicasGraficas(rs.getInt("idCaracGrafica"),
						rs.getString("directX"), rs.getString("openGL"), rs.getString("openCL"), rs.getString("vulkan"),
						rs.getString("cuda"), rs.getString("shaderModel"));

				lista.add(carac);
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
	public void inserir(CaracteristicasGraficas caracGrafica) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"insert into CaracteristicasGraficas (directX, openGL, openCL, vulkan, cuda, shaderModel) "
							+ "values (?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, caracGrafica.getDirectX());
			st.setString(2, caracGrafica.getOpenGL());
			st.setString(3, caracGrafica.getOpenCL());
			st.setString(4, caracGrafica.getVulkan());
			st.setString(5, caracGrafica.getCuda());
			st.setString(6, caracGrafica.getShaderModel());

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
	public void atualizar(CaracteristicasGraficas caracGrafica) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"update a set a.directX = ?, a.openGL = ?, a.openCL = ?, a.vulkan = ?, a.cuda = ?, a.shaderModel = ? "
					+ "from CaracteristicasGraficas a "
					+ "where a.idCaracGrafica = ?",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, caracGrafica.getDirectX());
			st.setString(2, caracGrafica.getOpenGL());
			st.setString(3, caracGrafica.getOpenCL());
			st.setString(4, caracGrafica.getVulkan());
			st.setString(5, caracGrafica.getCuda());
			st.setString(6, caracGrafica.getShaderModel());
			st.setInt(7, caracGrafica.getIdCaracGrafica());

			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					System.out.println("Alterado! Id: " + rs.getInt(1));
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao alterar a Característica Gráfica");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void remover(CaracteristicasGraficas caracGrafica) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"delete a from CaracteristicasGraficas a "
					+ "where a.idCaracGrafica = ?",
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, caracGrafica.getIdCaracGrafica());

			if (st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					System.out.println("Deletado! Id: " + rs.getInt(1));
				}
				conn.commit();
				DB.closeResultSet(rs);
			} else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new DbException("Erro inexperado ao fazer o rollback: " + e1.getMessage());
				}
				throw new DbException("Erro inexperado ao remover a Característica Gráfica");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

}
