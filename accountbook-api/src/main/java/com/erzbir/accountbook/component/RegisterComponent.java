package com.erzbir.accountbook.component;

import com.erzbir.accountbook.entity.IUser;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface RegisterComponent extends Component {
    boolean register(IUser user);
}
