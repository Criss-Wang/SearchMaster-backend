package com.crisswang.searchmaster.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.crisswang.searchmaster.annotation.AuthCheck;
import com.crisswang.searchmaster.common.BaseResponse;
import com.crisswang.searchmaster.common.DeleteRequest;
import com.crisswang.searchmaster.common.ErrorCode;
import com.crisswang.searchmaster.common.ResultUtils;
import com.crisswang.searchmaster.constant.UserConstant;
import com.crisswang.searchmaster.exception.BusinessException;
import com.crisswang.searchmaster.exception.ThrowUtils;
import com.crisswang.searchmaster.model.dto.picture.PictureQueryRequest;
import com.crisswang.searchmaster.model.dto.post.PostAddRequest;
import com.crisswang.searchmaster.model.dto.post.PostEditRequest;
import com.crisswang.searchmaster.model.dto.post.PostQueryRequest;
import com.crisswang.searchmaster.model.dto.post.PostUpdateRequest;
import com.crisswang.searchmaster.model.entity.Picture;
import com.crisswang.searchmaster.model.entity.Post;
import com.crisswang.searchmaster.model.entity.User;
import com.crisswang.searchmaster.model.vo.PostVO;
import com.crisswang.searchmaster.service.PictureService;
import com.crisswang.searchmaster.service.PostService;
import com.crisswang.searchmaster.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 图片接口
 *
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {

    @Resource
    private PictureService pictureService;

    /**
     * 分页获取列表（封装类）
     *
     * @param pictureQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<Picture>> listPictureByPage(@RequestBody PictureQueryRequest pictureQueryRequest,
                                                        HttpServletRequest request) {
        long current = pictureQueryRequest.getCurrent();
        long size = pictureQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        String searchText = pictureQueryRequest.getSearchText();
        Page<Picture> picturePage = pictureService.searchPicture(searchText, current, size);
        return ResultUtils.success(picturePage);
    }


}
