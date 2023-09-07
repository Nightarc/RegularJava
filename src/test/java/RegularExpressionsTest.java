import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionsTest {

    @Test
    void checkIP_localhost() {
        assertTrue(RegularExpressions.checkIP("127.0.0.1"));
    }
    @Test
    void checkIP_highest() {
        assertTrue(RegularExpressions.checkIP("255.255.255.255"));
    }
    @Test
    void checkIP_random() {
        assertTrue(RegularExpressions.checkIP("94.193.242.231"));
    }
    @Test
    void checkIP_begin() {
        assertTrue(RegularExpressions.checkIP("1.0.0.0"));
    }
    @Test
    void checkIP_4() {
        assertTrue(RegularExpressions.checkIP("111.222.233.244"));
    }
    @Test
    void checkIP_5() {
        assertTrue(RegularExpressions.checkIP("4.33.222.1"));
    }
    @Test
    void checkIP_FAIL_begin() {
        Assertions.assertFalse(RegularExpressions.checkIP("0.0.0.0"));
    }
    @Test
    void checkIP_FAIL_OutOfRange() {
        Assertions.assertFalse(RegularExpressions.checkIP("256.0.0.1"));
    }
    @Test
    void checkIP_FAIL_LettersInIP() {
        Assertions.assertFalse(RegularExpressions.checkIP("abc.bcd.tyu.gdf"));
    }
    @Test
    void checkIP_FAIL_NegativeNumbers() {
        Assertions.assertFalse(RegularExpressions.checkIP("-1.-2.-3.-4"));
    }
    @Test
    void checkIP_FAIL_SymbolsInIP() {
        Assertions.assertFalse(RegularExpressions.checkIP("123.154.*85.143"));
    }
    @Test
    void checkIP_FAIL_TooLargeBlocks() {
        Assertions.assertFalse(RegularExpressions.checkIP("1234.255.122.121"));
    }

    @Test
    void checkGUID() {
        assertTrue(RegularExpressions.checkGUID("e02fd0e4-00fd-090A-ca30-0d00a0038ba0"));
    }
    @Test
    void checkGUID_random1() {
        assertTrue(RegularExpressions.checkGUID("AAAAAAAA-BBBB-CCCC-DDDD-eee123456789"));
    }
    @Test
    void checkGUID_letters() {
        assertTrue(RegularExpressions.checkGUID("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa"));
    }
    @Test
    void checkGUID_random2() {
        assertTrue(RegularExpressions.checkGUID("AAAAAAAA-BBBB-CCCC-DDDD-eee123456789"));
    }
    @Test
    void checkGUID_random3() {
        assertTrue(RegularExpressions.checkGUID("4359160d-45d4-4b63-b228-efd7a97a06c9"));
    }
    @Test
    void checkGUID_random4() {
        assertTrue(RegularExpressions.checkGUID("e0295c5c-649a-46a5-9fec-1146a7d40126"));
    }
    @Test
    void checkGUID_FAIL_nohyphens() {
        Assertions.assertFalse(RegularExpressions.checkGUID("e02fd0e400fd090Aca300d00a0038ba0"));
    }
    @Test
    void checkGUID_FAIL_wronghyphens() {
        Assertions.assertFalse(RegularExpressions.checkGUID("e02fd0e:400f:d090:Aca3:00d00a0038ba0"));
    }

    @Test
    void checkGUID_FAIL_BlockIsTooBig() {
        Assertions.assertFalse(RegularExpressions.checkGUID("0000000-00001-0000-0000-000000000000"));
    }
    @Test
    void checkGUID_FAIL_BlockIsTooSmall() {
        Assertions.assertFalse(RegularExpressions.checkGUID("0000000-0000-0000-0000-00000000000"));
    }
    @Test
    void checkGUID_FAIL_SymbolsInGUID() {
        Assertions.assertFalse(RegularExpressions.checkGUID("4359?60d-45d4-4b63-*2*8-efd7a9&a06c9"));
    }
    @Test
    void checkGUID_FAIL_GUIDIsNotTheWholeString() {
        Assertions.assertFalse(RegularExpressions.checkGUID("ce0295c5c-649a-46a5-9fec-1146a7d40126g"));
    }

}