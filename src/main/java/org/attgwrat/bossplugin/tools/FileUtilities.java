package org.attgwrat.bossplugin.tools;

import org.apache.commons.io.FileUtils;
import org.attgwrat.bossplugin.BossPlugin;
import org.bukkit.Bukkit;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtilities {
    public static void getWorldsFromResources() throws IOException {
        URL inputUrl = BossPlugin.class.getResource("/worlds.zip");
        File dest = new File(Bukkit.getWorldContainer().getAbsolutePath(), "worlds.zip");
        FileUtils.copyURLToFile(inputUrl, dest);
        unzip(dest);
        dest.delete();
    }

    private static void unzip(File zipfile) throws IOException {
        File serverFolder = Bukkit.getWorldContainer();
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipfile.toPath()));
        ZipEntry zipEntry = zis.getNextEntry();
        while(zipEntry != null) {
            File newFile = newFile(serverFolder, zipEntry);
            if(newFile.exists()) {
                zipEntry = zis.getNextEntry();
                continue;
            }

            BossPlugin.getInstance().getLogger().info("Unpacking worlds: " + zipEntry.getName());

            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }

                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();


    }

    private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException{ //courtesy of baeldung
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
}
