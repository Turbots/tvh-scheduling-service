package be.tvh.bootcamp.schedule.web;

import be.tvh.bootcamp.schedule.model.CourseDto;
import be.tvh.bootcamp.schedule.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/course")
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping(value = "/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDto> getCourse(@PathVariable Long courseId) {
		log.info("Looking for Course [{}]", courseId);

		Optional<CourseDto> course = this.courseService.findCourse(courseId);

		if (course.isPresent()) {
			return ResponseEntity.ok(course.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
