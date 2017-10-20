package be.tvh.bootcamp.schedule.service;

import be.tvh.bootcamp.schedule.model.CourseDto;
import be.tvh.bootcamp.schedule.persistence.Course;
import be.tvh.bootcamp.schedule.persistence.CourseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CourseService {

	private final CourseRepository courseRepository;
	private final CourseConverter courseConverter;

	public CourseService(CourseRepository courseRepository,
		CourseConverter courseConverter) {
		this.courseRepository = courseRepository;
		this.courseConverter = courseConverter;
	}

	@Transactional
	public Optional<CourseDto> findCourse(Long courseId) {
		Optional<Course> course = this.courseRepository.findOneById(courseId);

		return course.map(this.courseConverter::convert);
	}
}
