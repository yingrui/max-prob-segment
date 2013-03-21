//package websiteschema.mpsegment.core
//
//import org.junit.Assert
//import org.junit.Test
//import websiteschema.mpsegment.dict.POSUtil
//
//class SegmentResultTest {
//
//    @Test
//    def should_merge_two_words_into_one_word() {
//        var segmentResult = new SegmentResult(6)
//        segmentResult.setWords(new Array[String]{"一个", "几十", "万", "人口", "的", "社区"})
//        segmentResult.setPOSArray(new Array[Int]{POSUtil.POS_M, POSUtil.POS_UNKOWN, POSUtil.POS_UNKOWN, POSUtil.POS_N, POSUtil.POS_U, POSUtil.POS_N})
//        segmentResult.setDomainTypes(new Array[Int]{0, 0, 0, 0, 0, 0})
//        segmentResult.setConcepts(new Array[String]{"N/A", "N/A", "N/A", "N/A", "N/A", "N/A"})
//
//        segmentResult.merge(1, 2, POSUtil.POS_M)
//        Assert.assertEquals("几十万", segmentResult.getWord(1))
//        Assert.assertNull(segmentResult.getWordAtom(2))
//        Assert.assertEquals(6, segmentResult.length())
//        segmentResult.compact()
//        Assert.assertEquals(5, segmentResult.length())
//        Assert.assertNotNull(segmentResult.getWordAtom(2))
//        Assert.assertEquals("人口", segmentResult.getWord(2))
//    }
//
//    @Test
//    def should_merge_pinyin_of_Chinese_words_correctly_when_merge_words() {
//        var segmentResult = new SegmentResult(6)
//        segmentResult.setWords(new Array[String]{"一个", "几十", "万", "人口", "的", "社区"})
//        segmentResult.setPOSArray(new Array[Int]{POSUtil.POS_M, POSUtil.POS_UNKOWN, POSUtil.POS_UNKOWN, POSUtil.POS_N, POSUtil.POS_U, POSUtil.POS_N})
//        segmentResult.setDomainTypes(new Array[Int]{0, 0, 0, 0, 0, 0})
//        segmentResult.setPinyin(new Array[String]{"yi'ge", "ji'shi", "wan", "ren'kou", "de", "she'qu"})
//        segmentResult.setConcepts(new Array[String]{"N/A", "N/A", "N/A", "N/A", "N/A", "N/A"})
//
//        segmentResult.merge(1, 2, POSUtil.POS_M)
//        Assert.assertEquals("ji'shi'wan", segmentResult.getPinyin(1))
//    }
//
//    @Test
//    def should_merge_pinyin_of_other_words_correctly_when_merge_words() {
//        var segmentResult = new SegmentResult(4)
//        segmentResult.setWords(new Array[String]{"1个", "a","b","c"})
//        segmentResult.setPOSArray(new Array[Int]{POSUtil.POS_M, POSUtil.POS_UNKOWN, POSUtil.POS_UNKOWN, POSUtil.POS_UNKOWN})
//        segmentResult.setDomainTypes(new Array[Int]{0, 0, 0, 0})
//        segmentResult.setPinyin(new Array[String]{"yi'ge", "a", "b", "c"})
//        segmentResult.setConcepts(new Array[String]{"N/A", "N/A", "N/A", "N/A"})
//
//        segmentResult.merge(1, 3, POSUtil.POS_UNKOWN)
//        Assert.assertEquals("abc", segmentResult.getPinyin(1))
//    }
//
//    @Test
//    def should_merge_pinyin_of_date_words_correctly_when_merge_words() {
//        var segmentResult = new SegmentResult(2)
//        segmentResult.setWords(new Array[String]{"１", "２日"})
//        segmentResult.setPOSArray(new Array[Int]{POSUtil.POS_M, POSUtil.POS_T})
//        segmentResult.setDomainTypes(new Array[Int]{0, 0})
//        segmentResult.setPinyin(new Array[String]{"１", "２'ri"})
//        segmentResult.setConcepts(new Array[String]{"N/A", "N/A"})
//
//        segmentResult.merge(0, 1, POSUtil.POS_T)
//        Assert.assertEquals("１２'ri", segmentResult.getPinyin(0))
//    }
//
//    @Test
//    def should_merge_multi_words_by_two_steps() {
//        var segmentResult = new SegmentResult(6)
//        segmentResult.setWords(new Array[String]{"一个", "几十", "万", "人口", "的", "社区"})
//        segmentResult.setPOSArray(new Array[Int]{POSUtil.POS_UNKOWN, POSUtil.POS_UNKOWN, POSUtil.POS_UNKOWN, POSUtil.POS_N, POSUtil.POS_U, POSUtil.POS_N})
//        segmentResult.setDomainTypes(new Array[Int]{0, 0, 0, 0, 0, 0})
//        segmentResult.setConcepts(new Array[String]{"N/A", "N/A", "N/A", "N/A", "N/A", "N/A"})
//
//        segmentResult.merge(0, 1, POSUtil.POS_M)
//        segmentResult.merge(1, 2, POSUtil.POS_M)
//        Assert.assertEquals("一个几十万", segmentResult.getWord(0))
//        Assert.assertNull(segmentResult.getWordAtom(1))
//        Assert.assertNull(segmentResult.getWordAtom(2))
//        Assert.assertEquals(6, segmentResult.length())
//        segmentResult.compact()
//        Assert.assertEquals(4, segmentResult.length())
//        Assert.assertNotNull(segmentResult.getWordAtom(1))
//        Assert.assertEquals("人口", segmentResult.getWord(1))
//    }
//
//    @Test
//    def should_merge_multi_words() {
//        var segmentResult = new SegmentResult(12)
//        segmentResult.setWords(new Array[String]{"（", "一", "九", "九", "七", "年", "十二月", "三", "十", "一", "日", "）"})
//        segmentResult.setPOSArray(new Array[Int]{POSUtil.POS_UNKOWN, POSUtil.POS_M, POSUtil.POS_M, POSUtil.POS_M, POSUtil.POS_M, POSUtil.POS_Q, POSUtil.POS_T, POSUtil.POS_M, POSUtil.POS_M, POSUtil.POS_M, POSUtil.POS_Q, POSUtil.POS_UNKOWN})
//        segmentResult.setDomainTypes(new Array[Int]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})
//        segmentResult.setConcepts(new Array[String]{"N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"})
//
//        segmentResult.merge(1, 4, POSUtil.POS_M)
//        segmentResult.merge(4, 5, POSUtil.POS_T)
//        segmentResult.merge(7, 9, POSUtil.POS_M)
//        segmentResult.merge(9, 10, POSUtil.POS_T)
//        segmentResult.compact()
//        println(segmentResult)
//    }
//
//}
