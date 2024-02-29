package code_review.project.account.application;

import code_review.project.account.domain.entity.Account;
import code_review.project.account.domain.dto.in.AccountRequest;
import code_review.project.account.repository.AccountRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountService {

	private final AccountRepository accountRepository;

	public String createAccount(AccountRequest request) {
		Account account = Account.create(request.getAccountName());
		accountRepository.save(account);
		return account.getName();
	}

	public Integer depositAccount(Long accountId, Integer amount) {
		Account entity = accountRepository.findById(accountId)
			.orElseThrow(() -> new IllegalArgumentException("해당 계좌를 찾을 수 없습니다."));

		entity.deposit(amount);

		return entity.getAmount();
	}

	public Integer withdrawAccount(Long accountId, Integer amount) {
		Account entity = accountRepository.findById(accountId)
			.orElseThrow(() -> new IllegalArgumentException("해당 계좌를 찾을 수 없습니다."));

		entity.withdraw(amount);
		return entity.getAmount();
	}

	public TransferAccountResponse transferAccount(Long accountId, String recipientAccountId, Integer amount) {

		// from
		Account from = accountRepository.findById(accountId)
			.orElseThrow(() -> new IllegalArgumentException("해당 계좌를 찾을 수 없습니다."));

		// to
		Account to = accountRepository.findById(Long.valueOf(recipientAccountId))
			.orElseThrow(() -> new IllegalArgumentException("해당 계좌를 찾을 수 없습니다."));

		Account.transfer(from, to, amount);

		return TransferAccountResponse.of(from.getName(), from.getAmount(), to.getName(), to.getAmount());
	}

	public AccountResponse findAccount(Long accountId) {
		Account entity = accountRepository.findById(accountId)
			.orElseThrow(() -> new IllegalArgumentException("해당 계좌를 찾을 수 없습니다."));
		return AccountResponse.of(entity);
	}

	@Data
	@Builder
	public static class AccountResponse {
		private Long accountId;
		private String name;
		private Integer amount;

		public static AccountResponse of(Account entity) {
			return AccountResponse.builder()
				.accountId(entity.getId())
				.name(entity.getName())
				.amount(entity.getAmount())
				.build();
		}
	}

	@Data
	@Builder
	public static class TransferAccountResponse {
		private String fromName;
		private Integer fromAmount;
		private String toName;
		private Integer toAmount;

		public static TransferAccountResponse of(String fromName, Integer fromAmount, String toName, Integer toAmount) {
			return TransferAccountResponse.builder()
				.fromName(fromName)
				.fromAmount(fromAmount)
				.toName(toName)
				.toAmount(toAmount)
				.build();
		}
	}
}
