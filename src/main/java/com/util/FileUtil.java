/**
 * Title:		XINHUANET
 * Copyright:	Copyright(c) 2000-2014,XINHUANET.com All rights reserved.
 * Company:		新华网(www.xinhuanet.com)
 */
package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件操作常用方法类
 * 
 * @since zengqingmeng @ 2014年6月19日 下午5:41:59
 * 
 */
public class FileUtil {

	/**
	 * 列出某个目录下的所有文件
	 * 
	 * @param path
	 * @return
	 * @since zengqingmeng @ 2014年6月24日 下午3:00:42
	 */
	public static File[] listClildFiles(String path) {
		if (StringUtil.isEmpty(path)) {
			return null;
		}
		File file = new File(path);
		if (file.exists() && file.isDirectory()) {
			return file.listFiles();
		}
		return null;
	}

	/**
	 * 移动文件位置，此方法支持在Linux/Unix下跨分区移动文件
	 * 
	 * @param fSrc
	 * @param fDst
	 * @throws IOException
	 * @since zengqingmeng @ 2014年6月20日 上午11:23:50
	 */
	public static void moveFile(File fSrc, File fDst) throws IOException {
		if (fSrc == null || fDst == null) {
			throw new IllegalArgumentException("one of the two file object is null: fSrc=" + fSrc + "; fDst=" + fDst);
		}
		if (false == fSrc.isFile()) {
			throw new IllegalArgumentException("the fSrc [ " + fSrc + " ] is NOT a file!");
		}
		// 目标文件名(文件或目录)已存在, 不允许覆盖
		if (fDst.exists()) {
			throw new IllegalArgumentException("the fDst [ " + fSrc + " ] is already exist!");
		}
		// 先尝试用File.renameTo()方法移动文件
		boolean success = fSrc.renameTo(fDst);
		if (success) {
			return;
		}
		// 可能是目标位置没有权限, 抛出异常
		File destDir = fDst.getParentFile();
		if (false == destDir.canWrite()) {
			throw new IOException("user [" + System.getProperty("user.name")
					+ "] not have write permission on dest dir [" + destDir + "]!");
		}
		// 可能是在Linux/Unix上跨分区移动, File.renameTo()方法不支持此操作, 因此自行实现(先复制然后删除源文件).
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(fSrc);
			fos = new FileOutputStream(fDst);
			byte[] buf = new byte[8192];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
			fSrc.delete();
		} catch (IOException e) {
			throw e;
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}

	}
}
