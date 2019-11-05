package models.entities.services;

import java.util.List;

import models.entities.dao.DaoFactory;
import models.entities.dao.PlacaDeVideoDao;
import models.entities.views.PlacaDeVideo;

public class PlacaDeVideoService {

	private PlacaDeVideoDao dao = DaoFactory.createPlacaDeVideoDao();
	
	public List<PlacaDeVideo> findAll() {
		return dao.findAll();
	}
}
