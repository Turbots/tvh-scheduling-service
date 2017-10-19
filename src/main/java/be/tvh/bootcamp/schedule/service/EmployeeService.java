package be.tvh.bootcamp.schedule.service;

import be.tvh.bootcamp.schedule.model.EmployeeDto;
import be.tvh.bootcamp.schedule.persistence.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final EmployeeConverter employeeConverter;

	public EmployeeService(EmployeeRepository employeeRepository,
		EmployeeConverter employeeConverter) {
		this.employeeRepository = employeeRepository;
		this.employeeConverter = employeeConverter;
	}

	public Set<EmployeeDto> findAllEmployees() {
		return this.employeeRepository.findAll().stream()
			.map(employeeConverter::convert)
			.collect(Collectors.toSet());
	}
}
