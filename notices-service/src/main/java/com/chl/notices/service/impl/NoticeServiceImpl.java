package com.chl.notices.service.impl;

import com.chl.notices.domain.entity.Notice;
import com.chl.notices.repository.NoticeRepository;
import com.chl.notices.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
* @author 小曹同学
* @description 针对表【notice】的数据库操作Service实现
* @createDate 2022-09-06 20:09:11
*/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoticeServiceImpl implements NoticeService{

    private final NoticeRepository noticeRepository;

    @Override
    public Notice getLatestNotice() {
        Sort sort = Sort.by("createTime").descending();
        return noticeRepository.findByShowFlag(true,sort).get(0);
    }
}
