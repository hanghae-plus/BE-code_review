package code_review.project.account.presentation;

import code_review.project.account.application.AccountService;
import code_review.project.account.application.AccountService.AccountResponse;
import code_review.project.account.application.AccountService.TransferAccountResponse;
import code_review.project.account.domain.dto.in.AccountRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
@Slf4j
public class AccountController {

	private final AccountService accountService;

	@PostMapping
	public ResponseEntity<String> createAccount(@RequestBody AccountRequest request) {
		return ResponseEntity.ok(accountService.createAccount(request));
	}

	@PostMapping("{accountId}/deposit")
	public ResponseEntity<Integer> depositAccount(@PathVariable Long accountId, Integer amount) {
		return ResponseEntity.ok(accountService.depositAccount(accountId, amount));
	}

	@PostMapping("{accountId}/withdraw")
	public ResponseEntity<Integer> withdrawAccount(@PathVariable Long accountId, Integer amount) {
		return ResponseEntity.ok(accountService.withdrawAccount(accountId, amount));
	}

	@PostMapping("{accountId}/transfer")
	public ResponseEntity<TransferAccountResponse> transferAccount(@PathVariable Long accountId, String recipientAccountId, Integer amount) {
		return ResponseEntity.ok(accountService.transferAccount(accountId, recipientAccountId, amount));
	}

	@GetMapping("/{accountId}")
	public ResponseEntity<AccountResponse> findAccount(@PathVariable Long accountId) {
		return ResponseEntity.ok(accountService.findAccount(accountId));
	}
}