package code_review.project.todolist.repository;

import static code_review.project.todolist.domain.entity.QToDoList.toDoList;

import code_review.project.todolist.domain.entity.QToDoList;
import code_review.project.todolist.presentation.ToDoListResponse;
import com.querydsl.codegen.utils.model.Constructor;
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
				toDoList.isCompleted.asc().nullsLast(), // "완료"가 먼저 나타나도록 오름차순 정렬, null 값은 마지막에 나타나도록 설정
				toDoList.completedTime.asc())
			.fetch();
	}

}
