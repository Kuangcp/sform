package com.stackfing.sform.beans.scan;

/**
 * @Author: fing
 * @Description:
 * @Date: 2019/7/23
 * @Since:
 */
public interface BoScanner {

    void scanPackage(String pkg);

    void scanPackages(String...pkgs);

}
