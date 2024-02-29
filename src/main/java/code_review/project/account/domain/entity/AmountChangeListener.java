package code_review.project.account.domain.entity;

import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AmountChangeListener {
	@PreUpdate
	public void beforeUpdate(Account entity) {
		Integer result = entity.getAmount();
		log.info("before => {}", result);
	}

	@PostUpdate
	public void afterUpdate(Account entity) {
		Integer result = entity.getAmount();
		log.info("after => {}", result);
	}
}
