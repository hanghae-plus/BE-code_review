package code_review.project.account.repository;

import code_review.project.account.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByName(@Param("name") String name);
}
