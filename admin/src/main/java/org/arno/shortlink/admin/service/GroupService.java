package org.arno.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.arno.shortlink.admin.dao.entity.GroupDO;
import org.arno.shortlink.admin.dto.request.ShortLinkGroupSortReqDTO;
import org.arno.shortlink.admin.dto.request.ShortLinkGroupUpdateReqDTO;
import org.arno.shortlink.admin.dto.response.ShortLinkGroupResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GroupService extends IService<GroupDO> {

    void saveGroup(String groupName);

    void saveGroup(String username, String groupName);

    List<ShortLinkGroupResponseDTO> listGroup();

    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    void deleteGroup(String gid);

    void sortGroup(List<ShortLinkGroupSortReqDTO> reqDTOList);
}
