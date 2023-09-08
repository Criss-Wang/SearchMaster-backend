package com.criss-wang.search-master.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.criss-wang.search-master.annotation.AuthCheck;
import com.criss-wang.search-master.common.BaseResponse;
import com.criss-wang.search-master.common.DeleteRequest;
import com.criss-wang.search-master.common.ErrorCode;
import com.criss-wang.search-master.common.ResultUtils;
import com.criss-wang.search-master.constant.UserConstant;
import com.criss-wang.search-master.exception.BusinessException;
import com.criss-wang.search-master.exception.ThrowUtils;
import com.criss-wang.search-master.model.dto.picture.PictureQueryRequest;
import com.criss-wang.search-master.model.dto.post.PostAddRequest;
import com.criss-wang.search-master.model.dto.post.PostEditRequest;
import com.criss-wang.search-master.model.dto.post.PostQueryRequest;
import com.criss-wang.search-master.model.dto.post.PostUpdateRequest;
import com.criss-wang.search-master.model.entity.Picture;
import com.criss-wang.search-master.model.entity.Post;
import com.criss-wang.search-master.model.entity.User;
import com.criss-wang.search-master.model.vo.PostVO;
import com.criss-wang.search-master.service.PictureService;
import com.criss-wang.search-master.service.PostService;
import com.criss-wang.search-master.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 图片接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
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
