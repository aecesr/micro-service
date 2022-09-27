package com.chl.notices.controller;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chl.notices.common.ResponseResult;
import com.chl.notices.common.ResultCode;
import com.chl.notices.domain.entity.Notice;
import com.chl.notices.service.NoticeService;
import com.chl.notices.domain.entity.Notice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @program: notices-service
 * @description:
 * @Author: 曹红亮
 * @create: 2022-09-27 15:24
 **/

@Slf4j
@RestController
@RefreshScope
@RequestMapping(value = "/notices")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoticesController {
    private final NoticeService noticeService;

    @Value("${disableNoticeRequest:false}")
    private Boolean disableNotice;

    @GetMapping("/latest")
//    @SentinelResource(value = "getNotice",blockHandler = "getNoticeBlock")
    public ResponseResult getNotice() {
        System.out.println("123123123123");
        if (disableNotice) {
            log.info("暂停服务公告");
            return ResponseResult.failure(ResultCode.INTERFACE_FORBID_VISIT);
        }
        Notice notice = noticeService.getLatestNotice();
        if (notice != null) {
            return ResponseResult.success(notice);
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
//
//    public  ResponseResult getNoticeBlock(BlockException exception) {
//        log.info("接口被限流");
//        log.info(exception.toString());
//        return ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
//    }

}
