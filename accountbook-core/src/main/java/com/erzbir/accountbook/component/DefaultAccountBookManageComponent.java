package com.erzbir.accountbook.component;

import com.erzbir.accountbook.entity.AccountBookContainer;
import com.erzbir.accountbook.entity.AccountBookContainerProvider;
import com.erzbir.accountbook.entity.IAccountBook;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class DefaultAccountBookManageComponent extends AbstractComponent implements AccountBookManageComponent {
    private AccountBookContainer accountBookContainer;

    @Override
    public void add(IAccountBook accountBook) {
        accountBookContainer.add(accountBook);
    }

    @Override
    public void remove(IAccountBook accountBook) {
        accountBookContainer.remove(accountBook.getId());
    }

    @Override
    public boolean contains(IAccountBook accountBook) {
        return accountBookContainer.contains(accountBook);
    }

    @Override
    public List<IAccountBook> getAccountBooks() {
        return accountBookContainer.getItems().values().stream().toList();
    }

    @Override
    public void init() {
        accountBookContainer = AccountBookContainerProvider.INSTANCE;
        isInit.set(true);
    }
}
