package be.tvh.bootcamp.schedule.web;

import be.tvh.bootcamp.schedule.model.EmployeeDto;
import be.tvh.bootcamp.schedule.service.EmployeeService;
import be.tvh.bootcamp.schedule.web.view.EmployeeView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(EmployeeView.class)
	public Set<EmployeeDto> findAll() {
		return this.employeeService.findAllEmployees();
	}
}
