package shved.ua.lviv.services;

import java.util.Map;

import shved.ua.lviv.domain.Product;
import shved.ua.lviv.shared.AbsractCRUD;

public interface ProductService extends AbsractCRUD<Product>{
	public Map<Integer, Product> readAllMap();
}
