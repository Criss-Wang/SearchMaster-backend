package com.crisswang.searchmaster.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crisswang.searchmaster.model.entity.Picture;

/**
 * 图片服务
 *
 */
public interface PictureService {

    Page<Picture> searchPicture(String searchText, long pageNum, long pageSize);
}
