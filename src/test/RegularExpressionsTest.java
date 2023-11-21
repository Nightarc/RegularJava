package src.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import src.main.RegularExpressions;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionsTest {
    //IP TESTS
    @ParameterizedTest
    @ValueSource(strings = {
            "127.0.0.1",
            "255.255.255.255",
            "94.193.242.231",
            "1.0.0.0",
            "111.222.233.244",
            "4.33.222.1"
            })
    void checkIP(String ip)
    {
        assertTrue(RegularExpressions.checkPattern(ip, RegularExpressions.patterns.get("IP")));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0.0.0.0",
            "256.0.0.1",
            "abc.bcd.tyu.gdf",
            "-1.-2.-3.-4",
            "123.154.*85.143",
            "1234.255.122.121"})
    void checkIPFalse(String ip)
    {
        assertFalse(RegularExpressions.checkPattern(ip, RegularExpressions.patterns.get("IP")));
    }
    @ParameterizedTest
    @ValueSource(strings = {
            "e02fd0e4-00fd-090A-ca30-0d00a0038ba0",
            "AAAAAAAA-BBBB-CCCC-DDDD-eee123456789",
            "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa",
            "AAAAAAAA-BBBB-CCCC-DDDD-eee123456789",
            "4359160d-45d4-4b63-b228-efd7a97a06c9",
            "e0295c5c-649a-46a5-9fec-1146a7d40126",})
    void checkGUID(String ip)
    {
        assertTrue(RegularExpressions.checkPattern(ip, RegularExpressions.patterns.get("GUID")));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "e02fd0e400fd090Aca300d00a0038ba0",
            "e02fd0e:400f:d090:Aca3:00d00a0038ba0",
            "0000000-00001-0000-0000-000000000000",
            "0000000-0000-0000-0000-00000000000",
            "4359?60d-45d4-4b63-*2*8-efd7a9&a06c9",
            "ce0295c5c-649a-46a5-9fec-1146a7d40126g"})
    void checkGUIDFalse(String ip)
    {
        assertFalse(RegularExpressions.checkPattern(ip, RegularExpressions.patterns.get("GUID")));
    }
    @ParameterizedTest
    @ValueSource(strings = {
            "http://www.example.com",
            "www.example.com",
            "www.com",
            "ya.ru",
            "https://ru.wikipedia.org",
            "https://ru.wikipedia.org:1030",
            "https://ru.wikipedia.org:1030?thing=Стул&section=Мебель",
            "https://ru.wikipedia.org:1030?thing=Chair",
            "https://ru.wikipedia.org:1030?thing=Стул&section=Мебель#ExampleAnchor",
            "https://ru.wikipedia.org:1030#ExampleAnchor"})
    void checkURL(String ip)
    {
        assertTrue(RegularExpressions.checkPattern(ip, RegularExpressions.patterns.get("URL")));
    }
    @ParameterizedTest
    @ValueSource(strings = {
                "Just Text",
                "http://a.com",
                "https://r.wikipedia.org",
                "https://-ru.wikipedia.org-",
                "http://ex ample.com",
                "http://192.168.0.1"})
    void checkURLFalse(String ip)
    {
        assertFalse(RegularExpressions.checkPattern(ip, RegularExpressions.patterns.get("URL")));
    }
    @ParameterizedTest
    @ValueSource(strings = {
            "C00l_Pass",
            "SupperPas1",
            "123456789Zx",
            "___xxX_SuperEpicGamer1337__Xxx",
            "9817cb6Y5892p",
            "TotallyUnsecurePassword123"})
    void checkPassword(String ip)
    {
        assertTrue(RegularExpressions.checkPattern(ip, RegularExpressions.patterns.get("SecurePassword")));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "TotallySecurePassword",
            "Se3ur2taaaaaaaa-a",
            "12312КириллицаТожеПароль18594",
            "BRAVEISBESTDEFENCE!!!*&*$123",
            "Cool_pass",
            "C00l"})
    void checkPasswordFalse(String ip)
    {
        assertFalse(RegularExpressions.checkPattern(ip, RegularExpressions.patterns.get("SecurePassword")));
    }

}