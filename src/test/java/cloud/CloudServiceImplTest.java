package cloud;//package com.mango.weish.model.cloud.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* CloudServiceImpl Tester.
*
* @author <Authors name>
* @since <pre>七月 20, 2015</pre>
* @version 1.0
*/
public class CloudServiceImplTest {
    private static ClassPathXmlApplicationContext context;
    private CloudServiceImpl cloudService;

    @Before
    public void before() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/springContext_test.xml");
        cloudService = context.getBean("cloudService", CloudServiceImpl.class);
}

@After
public void after() throws Exception {
}

/**
*
* Method: upload(byte[] data, String key)
*
*/
@Test
public void testUpload() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: uploadFile(String filepath, String key)
*
*/
@Test
public void testUploadFile() throws Exception {
    String filepath ="/home/maximus/Pictures/img1.jpg";
    String resutl = cloudService.uploadFile(filepath);

}
    @Test
public void testdeleteFile() throws Exception {
     cloudService.deleteFile("Fg4TxjmAZ5heOe26vg-SxdZhHcAe");

}


}
