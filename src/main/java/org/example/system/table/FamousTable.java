package org.example.system.table;

import org.example.system.Util;
import org.example.system.entity.Famous_Say;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FamousTable {
    public FamousTable() {

    }

    // 테이블의 데이터가 저장될 폴더 경로
    private static String getTableDirPath() {
        return "prodData/famousSaying";
    }

    // 특정 데이터의 파일경로
    public static String getTableDataFilePath(long id) {
        return getTableDirPath() + "/" + id + ".json";
    }

    // 테이블에서 가장 마지막에 생성된 데이터의 ID를 저정한 파일의 경로
    public static String getTableLastIdFilePath() {
        return getTableDirPath() + "/last_id.txt";
    }

    // 테이블에서 가장 마지막에 생성된 데이터의 ID
    public long getLastId() {
        return Util.file.readNoFromFile(getTableLastIdFilePath(), 0);
    }

    // // 테이블에서 가장 마지막에 생성된 데이터의 ID 갱신
    private void saveLastId(long id) {
        Util.file.saveNoToFile(getTableLastIdFilePath(), id);
    }

    public List<Famous_Say> findAll() {
        List<Long> fileIds = getFileIds();

        return fileIds
                .stream()
                .map(id -> findById(id))
                .collect(Collectors.toList());
    }

    private List<Long> getFileIds() {
        String path = getTableDirPath();
        List<String> fileNames = Util.file.getFileNamesFromDir(path);

        return fileNames
                .stream()
                .filter(fileName -> !fileName.equals("last_id.txt"))
                .filter(fileName -> !fileName.equals("data.json"))
                .filter(fileName -> fileName.endsWith(".json"))
                .map(fileName -> fileName.replace(".json", ""))
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());
    }

    public Famous_Say findById(long id) {
        String path = getTableDataFilePath(id);

        if (new File(path).exists() == false) {
            return null;
        }

        Map<String, Object> map = Util.json.jsonToMapFromFile(path);

        if (map == null) {
            return null;
        }

        return new Famous_Say((long) map.get("id"), (String) map.get("content"), (String) map.get("authorName"));
    }

    public long save(Famous_Say famous_say) {
        Util.file.mkdir(getTableDirPath());

        // 객체의 내용을 JSON 문장으로 변환
        String body = famous_say.toJson();

        // 파일이 저장할 경로 생성
        String filePath = getTableDataFilePath(famous_say.getId());

        // 파일 생성 or 갱신
        Util.file.saveToFile(filePath, body);

        saveLastId(famous_say.getId());

        return famous_say.getId();

    }


    public void remove(Famous_Say famous_say) {
        String path = getTableDataFilePath(famous_say.getId());
        System.out.printf("%d번 명언이 삭제되었습니다. \n", famous_say.getId());
        Util.file.deleteFile(path);
    }

    public void modify(Famous_Say famous_say, String content, String authorName) {
        famous_say.setFamous_Saying(content);
        famous_say.setAuthor(authorName);

        String body = famous_say.toJson();

        String filePath = getTableDataFilePath(famous_say.getId());
        Util.file.saveToFile(filePath, body);
    }
}
