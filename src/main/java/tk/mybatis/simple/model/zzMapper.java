package tk.mybatis.simple.model;

import java.util.List;

public interface zzMapper {
	List<Country> getC();

	Integer getId();

	Country getCountry(Integer id);

	void insertCountry(Country c);

	void deleteCountry(Integer id);
}
