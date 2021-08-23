package hus.censoCamas;

import hus.censoCamas.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class CensoCamasApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(CensoCamasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		String sql = "SELECT TOP 3 *  FROM GENPACIEN";
		List<Paciente> pacientes = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Paciente.class));
		pacientes.forEach(System.out::println);


	}
}
