package be.tvh.bootcamp.schedule.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class CourseDto {

	private Long id;
	private String topic;
	private LocalDate startDate;
	private LocalDate endDate;
	private EmployeeDto teacher;
	private Set<EmployeeDto> students;
}
