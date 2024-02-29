package code_review.project.todolist.application;

import static org.assertj.core.api.Assertions.assertThat;

import code_review.project.todolist.domain.entity.ToDoList;
import code_review.project.todolist.repository.ToDoListRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Slf4j
class ToDoListServiceTest {

	@Autowired
	private EntityManager em;

	@Autowired
	private ToDoListRepository toDoListRepository;

	@BeforeEach
	@Transactional
	void BeforeEachRegisterToDoList() {
		ToDoList entity = ToDoList.builder()
			.description("자바 공부하기")
			.isCompleted(false)
			.build();
		toDoListRepository.save(entity);
	}

	@Test
	void findToDoList() {

	}

	@Test
	void registerToDoList() {
		ToDoList entity = ToDoList.builder()
			.description("자바 공부하기")
			.isCompleted(false)
			.build();
		toDoListRepository.save(entity);
	}

	@Test
	void changeToDoList() {
		ToDoList entity = toDoListRepository.findByDescription("자바 공부하기");
		entity.changeDescription("스프링 공부하기");

		flushAndClear();

		toDoListRepository.findById(entity.getId()).ifPresent(data -> {
			assertThat(data.getDescription()).isEqualTo("스프링 공부하기");
		});
	}

	@Test
	void deleteToDoList() {
		ToDoList entity = toDoListRepository.findByDescription("자바 공부하기");
		toDoListRepository.delete(entity);

		flushAndClear();

		ToDoList result = toDoListRepository.findByDescription("자바 공부하기");
		assertThat(result).isNull();
	}

	private void flushAndClear() {
		em.flush();
		em.clear();
	}
}