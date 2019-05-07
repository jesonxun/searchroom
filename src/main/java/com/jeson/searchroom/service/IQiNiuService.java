package com.jeson.searchroom.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-20 18:02
 **/
public interface IQiNiuService {

    public Response uploadFile(File file) throws QiniuException;

    public Response uploadFile(InputStream inputStream) throws QiniuException;
}
