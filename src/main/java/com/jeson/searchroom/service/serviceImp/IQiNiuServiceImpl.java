package com.jeson.searchroom.service.serviceImp;

import com.jeson.searchroom.service.IQiNiuService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

/**
 * 七牛云service
 *
 * @author jeson
 * @create 2019-03-20 18:04
 **/
@Service
public class IQiNiuServiceImpl implements IQiNiuService,InitializingBean {

    @Autowired
    Auth auth;

    @Autowired
    UploadManager uploadManager;

    @Value("${qiniu.bucket}")
    private String bucket;

    private StringMap putPolicy;

    /**
     * 文件上传
     * @param file
     *
     * @return
     * */
    @Override
    public Response uploadFile(File file) throws QiniuException {
        Response response = uploadManager.put(file, null, getUploadToken());
        int retr = 0;
        while (response.needRetry() && retr < 3){
             response = uploadManager.put(file, null, getUploadToken());
             retr++;
        }
        return response;
    }

    /**
     * 文件流上传
     *
     * @param inputStream
     * @return
     * */
    @Override
    public Response uploadFile(InputStream inputStream) throws QiniuException {
        Response response = uploadManager.put(inputStream, null, getUploadToken(), null, null);
        int retry=0;
        while (response.needRetry() && retry <3){
            response = uploadManager.put(inputStream, null, getUploadToken(), null, null);
            retry++;
        }
        return response;
    }

    /**
     * 上传策略定义返回格式
     * */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
         putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"w\":$(imageInfo.width),\"h\":$(imageInfo.height)}");
    }

    private String getUploadToken(){
        return this.auth.uploadToken(bucket,null,3600,putPolicy);
    }


}
