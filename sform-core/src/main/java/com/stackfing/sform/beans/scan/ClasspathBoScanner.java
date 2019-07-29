package com.stackfing.sform.beans.scan;

import com.stackfing.sform.beans.BusinessObjectSource;
import com.stackfing.sform.beans.BusniessObjectSourceLoader;
import com.stackfing.sform.beans.BusniessObjectSourceRegistry;
import com.stackfing.sform.beans.DefaultBusinessObjectSourceLoader;
import com.stackfing.sform.beans.support.SimpleBusniessObjectSourceRegistry;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: fing
 * @Description:
 * @Date: 2019/7/23
 * @Since:
 */
public class ClasspathBoScanner implements BoScanner {

    private BusniessObjectSourceRegistry registry;

    private String scanpkg;


    public ClasspathBoScanner(String pkg) {
        this.scanpkg = pkg;
        // TODO ?
        if (this.registry == null) {
            this.registry = new SimpleBusniessObjectSourceRegistry();
        }
    }

    @Autowired
    public void setRegistry(BusniessObjectSourceRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void scanPackage() {
        scanPackage(this.scanpkg);
    }

    @Override
    public void scanPackage(String pkg) {
        List<Class<?>> list = getClasssFromPackage(pkg);
        for (Class<?> aClass : list) {
            BusniessObjectSourceLoader loader = new DefaultBusinessObjectSourceLoader();
            BusinessObjectSource businessObjectSource = loader.loadBusniessObjectSource(aClass);
            if (businessObjectSource == null) {
                continue;
            }
            registry.registerBusniessObjectSource(businessObjectSource);
            System.out.println(businessObjectSource);
        }
    }

    @Override
    public void scanPackages(String... pkgs) {

    }

    private void findClassInPackageByFile(String packageName, String filePath, final boolean recursive,
                                  List<Class<?>> clazzs) {
        File dir = new File(filePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 在给定的目录下找到所有的文件，并且进行条件过滤
        File[] dirFiles = dir.listFiles(file -> {
            boolean acceptDir = recursive && file.isDirectory();// 接受dir目录
            boolean acceptClass = file.getName().endsWith("class");// 接受class文件
            return acceptDir || acceptClass;
        });

        if (Objects.isNull(dirFiles)) {
            return;
        }
        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findClassInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, clazzs);
            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<Class<?>> getClasssFromPackage(String packageName) {
        List<Class<?>> clazzs = new ArrayList<>();
        // 是否循环搜索子包
        boolean recursive = true;
        // 包名对应的路径名称
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;

        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {

                URL url = dirs.nextElement();
                String protocol = url.getProtocol();

                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // TODO recursive always true
                    findClassInPackageByFile(packageName, filePath, recursive, clazzs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazzs;
    }

    public List<BusniessObjectSource> getAllBo() {
        return registry.getBusniessObjectSource();
    }
}
