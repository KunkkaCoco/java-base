package com.monitor;

/**
 * <p>description</p>
 * Created by chenweichao on 15-11-2.
 */


        import org.apache.commons.io.filefilter.FileFilterUtils;
        import org.apache.commons.io.filefilter.HiddenFileFilter;
        import org.apache.commons.io.filefilter.IOFileFilter;
        import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
        import org.apache.commons.io.monitor.FileAlterationMonitor;
        import org.apache.commons.io.monitor.FileAlterationObserver;

        import java.io.File;
        import java.util.concurrent.TimeUnit;

/**
 * 文件监控,commons io 实现
 * User: Jianghui
 * Date: 12-6-18
 * Time: 下午2:04
 * To change this template use File | Settings | File Templates.
 * 可参考
 * 监控文件夹变化 http://sourceforge.net/projects/jpathwatch/files/
 * 监控文件变化   http://jnotify.sourceforge.net/

 */
public class TestMonitor {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {


        // 监控目录
        String rootDir = "/home/maximus/tmp/test";
        // 轮询间隔 5 秒
        long interval = TimeUnit.MILLISECONDS.toMillis(100);
        // 创建一个文件观察器用于处理文件的格式

        // Create a FileFilter
        IOFileFilter directories = FileFilterUtils.and(
                FileFilterUtils.directoryFileFilter(),
                HiddenFileFilter.VISIBLE);
        IOFileFilter files = FileFilterUtils.and(
                FileFilterUtils.fileFileFilter());
        IOFileFilter filter = FileFilterUtils.or(directories, files);

        // Create the File system observer and register File Listeners
        FileAlterationObserver observer = new FileAlterationObserver(
                rootDir, filter, null);
        observer.addListener(new FileMonitorFileListener()); //设置文件变化监听器
        //创建文件变化监听器
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        // 开始监控
        monitor.start();


    }

    private static class FileMonitorFileListener extends FileAlterationListenerAdaptor

    {
        /**
         * 文件创建执行
         */
        @Override
        public void onFileCreate(File file) {
            System.out.println("[新建]:" + file.getAbsolutePath());
        }

        /**
         * 文件创建修改
         */
        @Override
        public void onFileChange(File file) {
            System.out.println("[修改]:" + file.getAbsolutePath());
        }


        /**
         * 文件删除
         */
        @Override
        public void onFileDelete(File file) {
            System.out.println("[删除]:" + file.getAbsolutePath());
        }
    }
}