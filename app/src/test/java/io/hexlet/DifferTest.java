package io.hexlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

class DifferTest {

    //    @Test
//    void tstGenerate() {
//        var diffrent = new Differ();
//        Map<String, Object> map1Exp =
//            Map.of("host", "hexlet.io",
//                "timeout", 50,
//                "proxy", "123.234.53.22",
//                "follow", false
//            );
//        Map<String, Object> map2Exp =
//            Map.of("host", "hexlet.io",
//                "timeout", 20,
//                "verbose", true
//            );
//
//        var filePath1 = Paths.get("src", "test", "resources", "fixtures", "file1.json")
//            .toAbsolutePath().normalize();
//        var filePath2 = Paths.get("src", "test", "resources", "fixtures", "file2.json")
//            .toAbsolutePath().normalize();
//
//        try {
//            diffrent.generate(Files.readString(filePath1).trim(), Files.readString(filePath2).trim());
//            Assertions.assertEquals(map1Exp, diffrent.map1);
//            Assertions.assertEquals(map2Exp, diffrent.map2);
//        } catch (JsonProcessingException | IOException e) {
//            Assertions.fail(e);
//        }
//
//    }
    private Differ differ;
    private Path filePath1;
    private Path filePath2;

    @BeforeEach
    void setUp() {
        differ = new Differ();
        filePath1 = Paths.get("src", "test", "resources", "fixtures", "file1.json").toAbsolutePath().normalize();
        filePath2 = Paths.get("src", "test", "resources", "fixtures", "file2.json").toAbsolutePath().normalize();
    }

    @Test
    void testMap1() {
//        Map<String, Object> map1Exp = Map.of("host", "hexlet.io", "follow", true, "timeout", 52);
//        Map<String, Object> map2Exp = Map.of("host", "hexlet.io", "timeout", 20, "verbose", true);
        Map<String, Object> map1Exp =
            Map.of("host", "hexlet.io",
                "timeout", 50,
                "proxy", "123.234.53.22",
                "follow", false
            );
        Map<String, Object> map2Exp =
            Map.of("host", "hexlet.io",
                "timeout", 20,
                "verbose", true
            );
        Assertions.assertDoesNotThrow(() -> {
            differ.generate(Files.readString(filePath1).trim(), Files.readString(filePath2).trim());
            Assertions.assertEquals(map1Exp, differ.map1);
            Assertions.assertEquals(map2Exp, differ.map2);
        }, "Исключение при проверке");
    }
}
