package org.arno.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.arno.shortlink.admin.dao.entity.GroupDO;
import org.springframework.stereotype.Service;


public interface GroupService extends IService<GroupDO> {

    void saveGroup(String groupName);
}
