package com.erzbir.accountbook.component;

import com.erzbir.accountbook.entity.IBill;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface BillManageComponent extends Component {
    void add(IBill bill);

    void addPay(IBill bill);

    void addIncome(IBill bill);

    void remove(IBill bill);

    boolean contains(IBill bill);

    List<IBill> getBills();

    default Stream<IBill> stream() {
        return getBills().stream();
    }
}
