package tk.mybatis.simple.model;

import java.util.List;

public interface zzMapper {
	List<Country> getC();

	Integer getId();

	Country getCountry(Integer id);

	int insertCountry(Country c);

	int deleteCountry(Integer id);
}
