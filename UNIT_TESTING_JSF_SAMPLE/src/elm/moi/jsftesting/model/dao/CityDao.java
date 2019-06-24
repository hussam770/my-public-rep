package elm.moi.jsftesting.model.dao;

import java.util.List;

import elm.moi.jsftesting.model.City;

public class CityDao extends DaoImpl{
	
	public static CityDao instance = new CityDao();
	
	public static CityDao getInstance() {
        return instance;
    }

	@Override
	public Object get(int id) {
		// TODO Auto-generated method stub
		//return entityManager.find(City.class, (int)id);
		return 2 ;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub
		
	}

}
