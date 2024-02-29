package code_review.project.account.application;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import code_review.project.account.application.AccountService.TransferAccountResponse;
import code_review.project.account.domain.entity.Account;
import code_review.project.account.repository.AccountRepository;
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
class AccountServiceTest {

	@Autowired
	private EntityManager em;

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRepository accountRepository;

	@BeforeEach
	@Transactional
	void BeforeEachRegisterAccount() {
		//accountService.createAccount("미래계좌");
	}

	@Test
	void registerAccount() {
		//String accountName = accountService.createAccount("미래계좌");
	    //assertThat(accountName).isEqualTo("미래계좌");
	}

	@Test
	void depositAccount() {
	    // given
		Account entity = accountRepository.findByName("미래계좌");
		Integer amount = accountService.depositAccount(entity.getId(), 10000);
	    assertThat(amount).isEqualTo(10000);
	}

	@Test
	void withdrawAccountFailTest() {
		assertThatThrownBy(
			() -> accountService.withdrawAccount(1L, 10000))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void withdrawAccount() {
		Account result = accountRepository.findByName("미래계좌");
		accountService.depositAccount(result.getId(), 10000);
		Integer amount = accountService.withdrawAccount(result.getId(), 10000);
	    assertThat(amount).isEqualTo(0);
	}

	@Test
	void transferAccount() {

		Account from = Account.builder()
					.name("적금계좌")
					.amount(10000)
					.build();

		Account to = Account.builder()
					.name("도약계좌")
					.amount(0)
					.build();

		accountRepository.save(from);
		accountRepository.save(to);
		TransferAccountResponse result = accountService.transferAccount(from.getId(), String.valueOf(to.getId()), 10000);

		assertThatThrownBy(
			() -> accountService.transferAccount(from.getId(), String.valueOf(to.getId()), 10000))
			.isInstanceOf(IllegalArgumentException.class);

		log.info("result => {}", result);
	}
}