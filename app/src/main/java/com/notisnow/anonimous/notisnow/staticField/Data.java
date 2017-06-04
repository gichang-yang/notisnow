package com.notisnow.anonimous.notisnow.staticField;

/**
 * Created by yang-gichang on 2017. 5. 28..
 */

public class Data {
    //순서:공과대학(0),화공(1),it(2),전자(3),기계(4),물리(5),소프트(6)
    private static String[] url = {
            "http://eng.sookmyung.ac.kr/wiz5/wizard/frames/server_sub.html?home_id=engineering&menu_seq=16&menu_seq_open=&tic=1495977191&handle=3&state=list&boardSeq=&siteId=engineering&SITE_ID=engineering&boardId=3&BOARD_ID=3"
            , "http://cbe.sookmyung.ac.kr/wiz5/wizard/frames/server_sub.html?home_id=cbe&menu_seq=5&menu_seq_open=&tic=1495976656&handle=6&state=list&boardSeq=&siteId=cbe&SITE_ID=cbe&boardId=6&BOARD_ID=6"
            , "http://it.sookmyung.ac.kr/wiz5/wizard/frames/server_sub.html?home_id=it&menu_seq=10&menu_seq_open=&tic=1495976982&handle=1&state=list&boardSeq=&siteId=it&SITE_ID=it&boardId=1&BOARD_ID=1"
            , "http://electro.sookmyung.ac.kr/wiz5/wizard/frames/server_sub.html?home_id=electro&menu_seq=5&menu_seq_open=&tic=1495977296&handle=1&state=list&boardSeq=&siteId=electro&SITE_ID=electro&boardId=1&BOARD_ID=1"
            , "http://mse.sookmyung.ac.kr/wiz5/wizard/frames/server_sub.html?home_id=mse&menu_seq=4&menu_seq_open=&tic=1495978301&handle=1&state=list&boardSeq=&siteId=mse&SITE_ID=mse&boardId=1&BOARD_ID=1"
            ,""
            ,"http://csweb.sookmyung.ac.kr/wiz/contents/board/board.php?home_id=cs&handle=1"
    };

    private static String[] query = {
            "td.title",
            "td.title",
            "td.title",
            "td.title",
            "td.title",
            "[href^=javascript:jf_view]",
            "[href^=javascript:jf_view]"
    };


    public static String[] getUrl() {
        return url;
    }

    public static String[] getQuery(){return query;}
}
