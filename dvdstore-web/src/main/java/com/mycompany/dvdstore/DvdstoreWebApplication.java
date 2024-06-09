package com.mycompany.dvdstore;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DvdstoreWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdstoreWebApplication.class, args);
		/*DataSource ds = context.getBean(DataSource.class);
		Connection conn = null;
		try{
			conn = ds.getConnection();
			ResultSet result = conn.createStatement().executeQuery("SELECT * FROM MOVIE");
			while (result.next()){
				System.out.println(result.getLong("id")+" | "+result.getString("titre"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}*/
	}

	@Bean
	public Hibernate5Module dataHibernate5Module() {
		return new Hibernate5Module();
	}

}
