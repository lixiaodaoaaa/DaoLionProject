package com.ailianlian.base.utils;
/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2017/11/30
       Time     :  09:43
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
    
    结合 SimpleDateUtils 使用，将某个文件夹下 某几天的文件全部清理：
    删除原理。枚举7天内的文件，将不是7天内的文件删除。
    
 */


import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteLogUtils{
    
    /**
     * @param logPath    删除哪个目录下的日志文件
     * @param beforeDays 保留几天内的日志文件
     * 举例 传入 3 ，就会保留3天内的日志文件 ，
     * 删除 从今天算昨天、 前天3天内的日志文件
     * 举例2017-1-5 所有包含2017-1-4 2017-1-4保留 剩余的删除。
     */
    
    private static String TAG = "DeleteLogUtils";
    
    public static void deleteBeforeSomeDays( String logPath, int beforeDays ){
        File logDirectoryFile = new File(logPath);
        if (!logDirectoryFile.exists( )) {
            //文件不存在不用删除
            return;
        }
        
        List<String> listSaveLogFileName = getListSaveLogFileName(logPath, beforeDays);
        List<File> allFiles = getListFileByLogPath(logPath);
        for (File file : allFiles) {
            if (file != null && file.exists( )) {
                // ini 配置文件要保留不能删除
                if (!listSaveLogFileName.contains(file.getName( )) && !file.getName( ).endsWith(".ini")) {
                    file.delete( );
                    Log.i(TAG, "delete file  " + file.getName( ));
                }
            }
        }
    }
    
    
    private static List<File> getListFileByLogPath( String logPath ){
        File logDirectoryFile = new File(logPath);
        if (logDirectoryFile.exists( ) && logDirectoryFile.isDirectory( )) {
            return Arrays.asList(logDirectoryFile.listFiles( ));
        } else {
            return null;
        }
    }
    
    /**
     * @param saveBeforeDays 保留几天的
     * @return 得到不需要删除的文件名列表
     * 举例 输入2 ，就会返回所有两天内的文件名列表
     */
    
    private static List<String> getListSaveLogFileName( String logPath, int saveBeforeDays ){
        List<String> listLogFileNameByPath = getListLogFileNamesByPath(logPath);
        List<String> listSaveSomeDateStr = SimpleDateUtils.getTodayToBeforeSomeDayListStr(saveBeforeDays);
        List<String> listSaveLogFileName = new ArrayList<>( );
        for (int i = 0; i < listLogFileNameByPath.size( ); i++) {
            for (int k = 0; k < listSaveSomeDateStr.size( ); k++) {
                if (listLogFileNameByPath.get(i).contains(listSaveSomeDateStr.get(k))) {
                    listSaveLogFileName.add(listLogFileNameByPath.get(i));
                    Log.i(TAG, "保留文件  不需要删除 " + listLogFileNameByPath.get(i));
                }
            }
        }
        return listSaveLogFileName;
    }
    
    
    /**
     * 通过目录得到某个路径下的所有文件名 将这个集合返回出来一个List
     *
     * @param path
     * @return
     */
    private static List<String> getListLogFileNamesByPath( String path ){
        File logDirectoryFile = new File(path);
        if (logDirectoryFile.exists( )) {
            return Arrays.asList(logDirectoryFile.list( ));
        }
        return null;
    }
    
    
    /**
     * 通过一个 fileName集合 返回一个 文件集合【需要文件名称 和文件路径】
     * 只有文件名称没有路径，那么这个File 会不存在，删除会出错。从文件名
     * 转化成File 【也可以叫 文件名集合到=》文件集合转化】
     *
     * @param parenPath
     * @param filename
     * @return
     */
    private static List<File> getListFileByListName( String parenPath, List<String> filename ){
        List<File> listFile = new ArrayList<>( );
        for (int i = 0; i < filename.size( ); i++) {
            listFile.add(new File(parenPath, filename.get(i)));
        }
        return listFile;
    }
    
    
    /**
     * 通过一个 fileName集合 返回一个 文件集合【需要文件名称 和文件路径】
     * 只有文件名称没有路径，那么这个File 会不存在，删除会出错。从文件名
     * 转化成File 【也可以叫 文件名集合到=》文件集合转化】
     *
     * @param parenPath
     * @param filename
     * @return
     */
    public static List<File> convertListFileNameToListFile( String parenPath, List<String> filename ){
        return getListFileByListName(parenPath, filename);
    }
    
}
