package org.arno.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import groovy.util.logging.Slf4j;
import org.arno.shortlink.admin.dao.entity.GroupDO;
import org.arno.shortlink.admin.dao.mapper.GroupMapper;
import org.arno.shortlink.admin.service.GroupService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService{

}
