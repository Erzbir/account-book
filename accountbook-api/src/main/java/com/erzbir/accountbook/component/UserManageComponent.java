package com.erzbir.accountbook.component;

import com.erzbir.accountbook.entity.IUser;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface UserManageComponent extends Component {
    void update(IUser user);

    IUser getUser(String key);
}
