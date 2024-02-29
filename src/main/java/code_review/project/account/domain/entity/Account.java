package code_review.project.account.domain.entity;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import code_review.project.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = PROTECTED)
@EntityListeners(AmountChangeListener.class)
public class Account extends BaseTimeEntity<Account, Long> {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "account_id")
	private Long id;

	private String name;

	private Integer amount;

	public static Account create(String accountName) {
		return Account.builder()
			.name(accountName)
			.amount(0)
			.build();
	}

	public void deposit(Integer amount) {
		this.amount += amount;
	}

	public void withdraw(Integer amount) {
		int result = this.amount - amount;
		if (result < 0) {
			throw new IllegalArgumentException("존재하는 금액보다 출금하려는 금액이 큽니다.");
		}
		this.amount = result;
	}

	public static void transfer(Account from, Account to, Integer amount) {
		from.withdraw(amount);
		to.deposit(amount);
	}
}
