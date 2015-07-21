package cloud;

import java.io.File;

/**
 * Created by chenweichao on 15-7-20.
 */
public interface ICloudService {


    /**
     * 上传文件到云存储
     * @param file
     * @param key
     * @return
     */
    String uploadFile(File file, String key);

    /**
     * 删除文件
     * @param key
     */
    void deleteFile(String key);

}
