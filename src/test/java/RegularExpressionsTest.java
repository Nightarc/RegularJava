import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionsTest {
    //IP TESTS
    @Test
    void checkIP_localhost() {
        assertTrue(RegularExpressions.checkPattern("127.0.0.1", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_highest() {
        assertTrue(RegularExpressions.checkPattern("255.255.255.255", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_random() {
        assertTrue(RegularExpressions.checkPattern("94.193.242.231", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_begin() {
        assertTrue(RegularExpressions.checkPattern("1.0.0.0", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_4() {
        assertTrue(RegularExpressions.checkPattern("111.222.233.244", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_5() {
        assertTrue(RegularExpressions.checkPattern("4.33.222.1", RegularExpressions.patterns.get("IP")));
    }

    //IP FAIL TESTS
    @Test
    void checkIP_FAIL_begin() {
        Assertions.assertFalse(RegularExpressions.checkPattern("0.0.0.0", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_FAIL_OutOfRange() {
        Assertions.assertFalse(RegularExpressions.checkPattern("256.0.0.1", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_FAIL_LettersInIP() {
        Assertions.assertFalse(RegularExpressions.checkPattern("abc.bcd.tyu.gdf", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_FAIL_NegativeNumbers() {
        Assertions.assertFalse(RegularExpressions.checkPattern("-1.-2.-3.-4", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_FAIL_SymbolsInIP() {
        Assertions.assertFalse(RegularExpressions.checkPattern("123.154.*85.143", RegularExpressions.patterns.get("IP")));
    }
    @Test
    void checkIP_FAIL_TooLargeBlocks() {
        Assertions.assertFalse(RegularExpressions.checkPattern("1234.255.122.121", RegularExpressions.patterns.get("IP")));
    }


    //GUID TESTS
    @Test
    void checkGUID() {
        assertTrue(RegularExpressions.checkPattern("e02fd0e4-00fd-090A-ca30-0d00a0038ba0", RegularExpressions.patterns.get("GUID")));
    }
    @Test
    void checkGUID_random1() {
        assertTrue(RegularExpressions.checkPattern("AAAAAAAA-BBBB-CCCC-DDDD-eee123456789", RegularExpressions.patterns.get("GUID")));
    }
    @Test
    void checkGUID_letters() {
        assertTrue(RegularExpressions.checkPattern("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa", RegularExpressions.patterns.get("GUID")));
    }
    @Test
    void checkGUID_random2() {
        assertTrue(RegularExpressions.checkPattern("AAAAAAAA-BBBB-CCCC-DDDD-eee123456789", RegularExpressions.patterns.get("GUID")));
    }
    @Test
    void checkGUID_random3() {
        assertTrue(RegularExpressions.checkPattern("4359160d-45d4-4b63-b228-efd7a97a06c9", RegularExpressions.patterns.get("GUID")));
    }
    @Test
    void checkGUID_random4() {
        assertTrue(RegularExpressions.checkPattern("e0295c5c-649a-46a5-9fec-1146a7d40126", RegularExpressions.patterns.get("GUID")));
    }

    //GUID FAIL TESTS
    @Test
    void checkGUID_FAIL_nohyphens() {
        Assertions.assertFalse(RegularExpressions.checkPattern("e02fd0e400fd090Aca300d00a0038ba0", RegularExpressions.patterns.get("GUID")));
    }
    @Test
    void checkGUID_FAIL_wronghyphens() {
        Assertions.assertFalse(RegularExpressions.checkPattern("e02fd0e:400f:d090:Aca3:00d00a0038ba0", RegularExpressions.patterns.get("GUID")));
    }

    @Test
    void checkGUID_FAIL_BlockIsTooBig() {
        Assertions.assertFalse(RegularExpressions.checkPattern("0000000-00001-0000-0000-000000000000", RegularExpressions.patterns.get("GUID")));
    }
    @Test
    void checkGUID_FAIL_BlockIsTooSmall() {
        Assertions.assertFalse(RegularExpressions.checkPattern("0000000-0000-0000-0000-00000000000", RegularExpressions.patterns.get("GUID")));
    }
    @Test
    void checkGUID_FAIL_SymbolsInGUID() {
        Assertions.assertFalse(RegularExpressions.checkPattern("4359?60d-45d4-4b63-*2*8-efd7a9&a06c9", RegularExpressions.patterns.get("GUID")));
    }
    @Test
    void checkGUID_FAIL_GUIDIsNotTheWholeString() {
        Assertions.assertFalse(RegularExpressions.checkPattern("ce0295c5c-649a-46a5-9fec-1146a7d40126g", RegularExpressions.patterns.get("GUID")));
    }

    // URL TESTS
    @Test
    void checkURL_http() {
        assertTrue(RegularExpressions.checkPattern("http://www.example.com", RegularExpressions.patterns.get("URL")));
    }
    @Test
    void checkURL_WithoutProtocol() {
        assertTrue(RegularExpressions.checkPattern("www.example.com", RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_SubDomain() {
        assertTrue(RegularExpressions.checkPattern("https://ru.wikipedia.org",
                RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_Port() {
        assertTrue(RegularExpressions.checkPattern("https://ru.wikipedia.org:1030",
                RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_GETRequest() {
        assertTrue(RegularExpressions.checkPattern("https://ru.wikipedia.org:1030?thing=Стул&section=Мебель",
                RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_GETRequestSingleLatin() {
        assertTrue(RegularExpressions.checkPattern("https://ru.wikipedia.org:1030?thing=Chair",
                RegularExpressions.patterns.get("URL")));
    }
    @Test
    void checkURL_Anchor() {
        assertTrue(RegularExpressions.checkPattern("https://ru.wikipedia.org:1030?thing=Стул&section=Мебель#ExampleAnchor",
                RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_AnchorOnly() {
        assertTrue(RegularExpressions.checkPattern("https://ru.wikipedia.org:1030#ExampleAnchor",
                RegularExpressions.patterns.get("URL")));
    }

    //URL FAIL TESTS
    @Test
    void checkURL_FAIL_PlainText() {
        assertFalse(RegularExpressions.checkPattern("Just Text",
                RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_FAIL_DomainTooShort() {
        assertFalse(RegularExpressions.checkPattern("http://a.com",
                RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_FAIL_SubDomainTooShort() {
        assertFalse(RegularExpressions.checkPattern("https://r.wikipedia.org",
                RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_FAIL_SymbolsInDomain() {
        assertFalse(RegularExpressions.checkPattern("https://-ru.wikipedia.org-",
                RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_FAIL_WhitespacesInDomain() {
        assertFalse(RegularExpressions.checkPattern("http://ex ample.com",
                RegularExpressions.patterns.get("URL")));
    }

    @Test
    void checkURL_FAIL_IPDomain() {
        assertFalse(RegularExpressions.checkPattern("http://192.168.0.1",
                RegularExpressions.patterns.get("URL")));
    }
}