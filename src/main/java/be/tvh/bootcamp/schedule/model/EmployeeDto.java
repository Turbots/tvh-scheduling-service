package be.tvh.bootcamp.schedule.model;

import be.tvh.bootcamp.schedule.web.view.EmployeeView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class EmployeeDto {

	@JsonView(EmployeeView.class)
	private Long id;

	@JsonView(EmployeeView.class)
	private String name;

	@JsonView(EmployeeView.class)
	private LocalDate startDate;

	@JsonView(EmployeeView.class)
	private String department;

	private EmployeeDto boss;
}
