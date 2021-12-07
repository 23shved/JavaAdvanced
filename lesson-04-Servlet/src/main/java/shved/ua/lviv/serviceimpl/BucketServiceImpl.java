package shved.ua.lviv.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import shved.ua.lviv.dao.BucketDao;
import shved.ua.lviv.daoimpl.BucketDaoImpl;
import shved.ua.lviv.domain.Bucket;
import shved.ua.lviv.services.BucketService;

public class BucketServiceImpl implements BucketService{

	private BucketDao bucketDao;

	public BucketServiceImpl() {
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Bucket create(Bucket t) {
		return bucketDao.create(t);
	}

	@Override
	public Bucket read(Integer t) {
		return bucketDao.read(t);

	}

	@Override
	public Bucket update(Bucket t) {
		return bucketDao.update(t);

	}

	@Override
	public void delete(Integer t) {
		bucketDao.delete(t);
		
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

}
