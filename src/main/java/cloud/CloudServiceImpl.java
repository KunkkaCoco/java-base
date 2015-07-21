package cloud;

import com.alibaba.fastjson.JSON;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by chenweichao on 15-7-20.
 */
@Service(value = "cloudService")
public class CloudServiceImpl implements ICloudService {

    private static final Logger LOG = LoggerFactory.getLogger(CloudServiceImpl.class);
    // 重用 uploadManager。一般地，只需要创建一个 uploadManager 对象
    private static UploadManager uploadManager = new UploadManager();
    private static BucketManager bucketManager = new BucketManager(UploadHelper.auth);
    private static String bucket = "myspace";

    @Override
    public String uploadFile(File file,String key) {
        String result = "";
        String upToken = UploadHelper.uploadToken(bucket, null, null, null, null);
        try {
            Response res = uploadManager.put(file, key, upToken);
            LOG.info("**************************** 上传Response :" + JSON.toJSONString(res));
            MyRet myRet = res.jsonToObject(MyRet.class);

            if (res.isOK()) {
                //success
                LOG.info("SUCCESS : " + myRet.hash);
                result = myRet.hash;
            } else {
                LOG.info("fail : " + res.url());
                //
            }
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时简单状态信息
            LOG.error(r.toString());
            try {
                // 响应的文本信息
                LOG.error(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }

        return result;
    }

    @Override
    public void deleteFile(String key) {
        String result = "SUCCESS";
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException e) {
            LOG.error("删除文件失败" + e);
            result = " failure";
        }
    }



    public class MyRet {
        public long fsize;
        public String key;
        public String hash;
        public int width;
        public int height;
    }

}
