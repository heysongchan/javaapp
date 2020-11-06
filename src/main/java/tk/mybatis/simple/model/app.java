package tk.mybatis.simple.model;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class app {

	public static void main(String[] args) throws Exception {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);
		reader.close();

		SqlSession session = factory.openSession();
		List<Object> list = session.selectList("selectAll");
		for (Object o : list) {
			Country c = (Country) o;
			System.out.println(c.getId() + "      " + c.getCountryname() + "    " + c.getCountrycode());
		}
		session.close();
	}
}
