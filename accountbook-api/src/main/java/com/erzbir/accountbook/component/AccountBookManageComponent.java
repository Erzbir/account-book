package com.erzbir.accountbook.component;

import com.erzbir.accountbook.entity.IAccountBook;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface AccountBookManageComponent extends Component {
    void add(IAccountBook accountBook);

    void remove(IAccountBook accountBook);

    boolean contains(IAccountBook accountBook);

    List<IAccountBook> getAccountBooks();

    default Stream<IAccountBook> stream() {
        return getAccountBooks().stream();
    }
}
