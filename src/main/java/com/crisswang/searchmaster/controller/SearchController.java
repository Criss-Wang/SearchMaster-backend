package com.crisswang.searchmaster.controller;

import com.crisswang.searchmaster.common.BaseResponse;
import com.crisswang.searchmaster.common.ResultUtils;
import com.crisswang.searchmaster.manager.SearchFacade;
import com.crisswang.searchmaster.model.dto.search.SearchRequest;
import com.crisswang.searchmaster.model.vo.SearchVO;
import com.crisswang.searchmaster.service.PictureService;
import com.crisswang.searchmaster.service.PostService;
import com.crisswang.searchmaster.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 图片接口
 *
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Resource
    private UserService userService;

    @Resource
    private PostService postService;

    @Resource
    private PictureService pictureService;

    @Resource
    private SearchFacade searchFacade;

    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacade.searchAll(searchRequest, request));
    }

}
