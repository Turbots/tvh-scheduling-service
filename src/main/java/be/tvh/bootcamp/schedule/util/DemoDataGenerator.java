package be.tvh.bootcamp.schedule.util;

import be.tvh.bootcamp.schedule.model.EmployeeType;
import be.tvh.bootcamp.schedule.persistence.Employee;
import be.tvh.bootcamp.schedule.persistence.EmployeeRepository;
import be.tvh.bootcamp.schedule.web.view.EmployeeView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DemoDataGenerator implements ApplicationRunner {

	private final EmployeeRepository employeeRepository;

	public DemoDataGenerator(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Employee boss = buildEmployee("Dieter Hubau", EmployeeType.EXTERNAL, null);

		final Employee hubau = this.employeeRepository.save(boss);

		this.employeeRepository.save(
			Stream.of("Jacob", "Jens", "Maxwell", "Ken", "Tim A", "Tahsin", "Tim B", "Wouter")
				.map(s -> buildEmployee(s, EmployeeType.INTERNAL, hubau)).collect(Collectors.toList()));
	}

	private Employee buildEmployee(String name, EmployeeType type, Employee boss) {
		return Employee.builder()
			.department("TVH Parts")
			.name(name)
			.creationDate(LocalDateTime.now())
			.startDate(LocalDate.now().minusYears(1))
			.type(type)
			.boss(boss)
			.build();
	}
}
