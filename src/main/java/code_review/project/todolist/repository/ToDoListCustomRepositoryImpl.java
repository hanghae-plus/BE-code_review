package code_review.project.todolist.repository;

import static code_review.project.todolist.domain.entity.QToDoList.toDoList;

import code_review.project.todolist.domain.dto.out.ToDoListResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ToDoListCustomRepositoryImpl implements ToDoListCustomRepository {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<ToDoListResponse> findAllToDoList() {
		return queryFactory
			.select(Projections.constructor(ToDoListResponse.class,
				toDoList.id,
				toDoList.description,
				toDoList.isCompleted,
				toDoList.completedTime))
			.from(toDoList)
			.orderBy(
				toDoList.isCompleted.desc(),
				toDoList.createdAt.asc())
			.fetch();
	}

}
