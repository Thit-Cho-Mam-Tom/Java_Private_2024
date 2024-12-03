package service;

import model.Account;
import model.Status;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final List<Account> accounts = new ArrayList<>();

    @Override
    public List<Account> getAllAccount() {
        return new ArrayList<>(accounts);
    }

    @Override
    public void createNewAccount(Account account) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(account.getUsername())) {
                throw new IllegalArgumentException("Tài khoản có tên người dùng " + account.getUsername() + " đã tồn tại.");
            }
        }
        accounts.add(account);
    }

    @Override
    public Account getAccountByUsername(String username) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                return acc;
            }
        }
        throw new IllegalArgumentException("Tài khoản có tên người dùng " + username + " đã tồn tại.");
    }

    @Override
    public void deleteAccount(String username) {
        Account accountToDelete = getAccountByUsername(username);
        accounts.remove(accountToDelete);
    }

    @Override
    public void changeStatus(String username, Status status) {
        Account accountToUpdate = getAccountByUsername(username);
        accountToUpdate.setStatus(status);
    }
}
